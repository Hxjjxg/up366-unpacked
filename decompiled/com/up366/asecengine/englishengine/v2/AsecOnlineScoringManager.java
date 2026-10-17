package com.up366.asecengine.englishengine.v2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsecOnlineScoringManager {
    private static final java.lang.String AUDIO_ENCODING_OPUS = "opus";
    private static final int BINARY_AUDIO_HEADER_SIZE = 35;
    private static final int BINARY_AUDIO_MAGIC = 21313;
    private static final byte BINARY_AUDIO_VERSION = 1;
    private static final java.lang.String DEFAULT_UPLOAD_FILE_MESSAGE_TYPE = "upload_audio_url";
    private static final long DISCONNECT_RESPONSE_WAIT_MS = 200;
    private static final java.lang.String FALLBACK_RETRYING_MESSAGE = "fallback upload retrying";
    private static final int MAX_BINARY_PACKET_SIZE = 65535;
    private static final int MAX_PENDING_ACK_BATCHES = 8;
    private static final int MAX_RESUME_CACHE_BYTES = 67108864;
    private static final java.lang.String NATIVE_COMMAND_ACK = "ack";
    private static final java.lang.String NATIVE_COMMAND_CONNECTED = "connected";
    static final java.lang.String NATIVE_COMMAND_CONTROL = "control";
    static final java.lang.String NATIVE_COMMAND_PING = "ping";
    private static final java.lang.String NATIVE_COMMAND_PONG = "pong";
    private static final java.lang.String NATIVE_TYPE_CONNECTED_RESP = "connected_resp";
    private static final java.lang.String NATIVE_TYPE_DISCONNECT = "disconnect";
    private static final java.lang.String NATIVE_TYPE_DISCONNECT_RESP = "disconnect_resp";
    private static final java.lang.String NATIVE_TYPE_RESTART = "re_start";
    private static final java.lang.String NATIVE_TYPE_RESTART_RESP = "re_start_resp";
    private static final java.lang.String NATIVE_TYPE_SCORE_RESULT = "score_result";
    private static final java.lang.String NATIVE_TYPE_START = "start";
    private static final java.lang.String NATIVE_TYPE_START_RESP = "start_resp";
    private static final java.lang.String NATIVE_TYPE_STOP = "stop";
    public static final int ONLINE_BITRATE = 24000;
    public static final int ONLINE_CHANNELS = 1;
    public static final int ONLINE_FRAME_DURATION_MS = 20;
    public static final int ONLINE_SAMPLE_RATE = 16000;
    private static final int PACKET_ACK_TIMEOUT_MS = 3000;
    private static final int SEND_WINDOW_MS = 200;
    private static final java.lang.String TAG = "AsecOnlineWs";
    private static final java.lang.String UPLOADED_MP3_URL_FIELD = "mp3_file_url";
    private static final java.lang.String UPLOADED_OPUS_URL_FIELD = "opus_file_url";
    private com.up366.asecengine.englishengine.AsecSession activeSession;
    private int autoResumeAttemptCount;
    private java.util.concurrent.ScheduledFuture<?> autoResumeFuture;
    private long autoResumeGeneration;
    private boolean autoResumeInFlight;
    private long autoResumeStartedAtMs;
    private boolean autoResumeSuppressed;
    private long bufferedPacketsTimestampMs;
    private okhttp3.OkHttpClient client;
    private java.lang.String connectRequestId;
    private java.lang.String connectionId;
    private com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig currentOnlineScoringConfig;
    private java.lang.Integer currentUserId;
    private com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig currentWebSocketConfig;
    private java.util.concurrent.ScheduledFuture<?> disconnectCloseFuture;
    private boolean disconnectFrameSent;
    private boolean disconnectRequested;
    private java.lang.String failureMessage;
    private java.util.concurrent.ScheduledFuture<?> incomingHeartbeatFuture;
    private long lastInboundActivityMs;
    private long lastOutboundActivityMs;
    private java.lang.String latestEventSummary;
    private long negotiatedIncomingHeartbeatMs;
    private long negotiatedOutgoingHeartbeatMs;
    private java.util.concurrent.ScheduledFuture<?> outgoingHeartbeatFuture;
    private int outstandingAudioBytes;
    private java.lang.String pendingUploadedOpusPracticeId;
    private java.lang.String pendingUploadedOpusUrl;
    private boolean protocolConnected;
    private boolean realtimeUploadFailed;
    private boolean reconnectingForResume;
    private boolean resumeRequested;
    private com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.SessionInfo sessionInfo;
    private boolean startCommandSent;
    private boolean stopCommandSent;
    private java.util.concurrent.ScheduledFuture<?> stopEvaluateFuture;
    private boolean stopResumePending;
    private boolean transportConnected;
    private okhttp3.WebSocket webSocket;
    private final java.lang.Object lock = new java.lang.Object();
    private final java.util.concurrent.ScheduledExecutorService scheduler = java.util.concurrent.Executors.newSingleThreadScheduledExecutor();
    private final java.util.concurrent.ScheduledExecutorService autoResumeScheduler = java.util.concurrent.Executors.newSingleThreadScheduledExecutor();
    private final java.util.concurrent.atomic.AtomicInteger audioSequence = new java.util.concurrent.atomic.AtomicInteger(0);
    private final java.util.Map<java.lang.String, com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch> pendingAckBatches = new java.util.HashMap();
    private final java.util.Map<java.lang.Integer, com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch> outstandingAudioBatches = new java.util.LinkedHashMap();
    private final java.util.List<byte[]> bufferedPackets = new java.util.ArrayList();
    private java.util.concurrent.CountDownLatch transportReadyLatch = new java.util.concurrent.CountDownLatch(1);
    private java.util.concurrent.CountDownLatch sessionReadyLatch = new java.util.concurrent.CountDownLatch(1);
    private java.util.concurrent.CountDownLatch resumeReadyLatch = new java.util.concurrent.CountDownLatch(0);
    private boolean closed = true;
    private int packetsPerChunk = 10;
    private int packetRetryMaxCount = 0;
    private long stopAckWaitMs = 100;
    private com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy autoResumePolicy = new com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy();
    private final com.up366.asecengine.englishengine.v2.AsecOnlineTransportLogHelper transportLogHelper = new com.up366.asecengine.englishengine.v2.AsecOnlineTransportLogHelper(TAG, new com.up366.asecengine.englishengine.v2.AsecOnlineTransportLogHelper.ConnectionIdProvider() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager$$ExternalSyntheticLambda13
        @Override // com.up366.asecengine.englishengine.v2.AsecOnlineTransportLogHelper.ConnectionIdProvider
        public final java.lang.String getConnectionId() {
            return this.f$0.m18xa4ae5eb2();
        }
    });

    public interface TransportLogListener {
        void onLog(java.lang.String str);
    }

    /* JADX INFO: renamed from: lambda$new$0$com-up366-asecengine-englishengine-v2-AsecOnlineScoringManager, reason: not valid java name */
    /* synthetic */ java.lang.String m18xa4ae5eb2() {
        return this.connectionId;
    }

    public boolean connect(com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfig) {
        synchronized (this.lock) {
            if (asecWebSocketConfig != null) {
                if (asecWebSocketConfig.getWebSocketUrl() != null && asecWebSocketConfig.getWebSocketUrl().trim().length() != 0) {
                    prepareTransportForConnectLocked();
                    if (isConnected() && sameConnectionConfig(asecWebSocketConfig)) {
                        return true;
                    }
                    resetTransportLocked();
                    java.lang.String strNewRequestId = com.up366.asecengine.englishengine.v2.AsecRequestIdHelper.newRequestId();
                    java.lang.String strGenerateConnectionId = asecWebSocketConfig.generateConnectionId();
                    this.connectionId = strGenerateConnectionId;
                    java.lang.String strResolveWebSocketUrl = asecWebSocketConfig.resolveWebSocketUrl(strNewRequestId, strGenerateConnectionId);
                    this.currentWebSocketConfig = asecWebSocketConfig;
                    this.connectRequestId = strNewRequestId;
                    this.transportReadyLatch = new java.util.concurrent.CountDownLatch(1);
                    this.sessionReadyLatch = new java.util.concurrent.CountDownLatch(1);
                    this.failureMessage = null;
                    this.latestEventSummary = null;
                    this.closed = false;
                    this.transportConnected = false;
                    this.protocolConnected = false;
                    this.client = new okhttp3.OkHttpClient.Builder().retryOnConnectionFailure(true).connectTimeout(asecWebSocketConfig.getConnectTimeoutMs(), java.util.concurrent.TimeUnit.MILLISECONDS).build();
                    okhttp3.Request.Builder builderUrl = new okhttp3.Request.Builder().url(strResolveWebSocketUrl);
                    this.transportLogHelper.connectWebSocket(strResolveWebSocketUrl);
                    this.transportLogHelper.connectRequest(this.connectRequestId, strResolveWebSocketUrl);
                    this.webSocket = this.client.newWebSocket(builderUrl.build(), new com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.SocketListener());
                    return awaitTransportReady(asecWebSocketConfig.getConnectTimeoutMs());
                }
            }
            this.failureMessage = "WebSocket URL is empty";
            this.transportLogHelper.connectSkippedWebSocketUrlEmpty();
            return false;
        }
    }

    boolean awaitTransportReady(long j) {
        try {
            boolean zAwait = this.transportReadyLatch.await(j, java.util.concurrent.TimeUnit.MILLISECONDS);
            if (!zAwait) {
                synchronized (this.lock) {
                    java.lang.String str = this.failureMessage;
                    if (str == null) {
                        str = "WebSocket connect timeout";
                    }
                    this.failureMessage = str;
                    this.transportLogHelper.connectTimeout(j);
                    resetTransportLocked();
                }
                return false;
            }
            if (this.failureMessage == null) {
                this.transportLogHelper.transportReady(this.protocolConnected);
            }
            return zAwait && this.protocolConnected && this.failureMessage == null;
        } catch (java.lang.InterruptedException e) {
            java.lang.Thread.currentThread().interrupt();
            this.failureMessage = e.getMessage();
            this.transportLogHelper.awaitTransportInterrupted(e.getMessage());
            return false;
        }
    }

    boolean awaitResumeReady(long j) {
        try {
            boolean zAwait = this.resumeReadyLatch.await(j, java.util.concurrent.TimeUnit.MILLISECONDS);
            synchronized (this.lock) {
                if (!zAwait) {
                    java.lang.String str = this.failureMessage;
                    if (str == null) {
                        str = "re_start timeout";
                    }
                    this.failureMessage = str;
                    this.reconnectingForResume = false;
                    this.transportLogHelper.resumeFailed(str);
                    com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
                    if (asecSession != null) {
                        asecSession.setOnlineMessage(this.failureMessage);
                    }
                    resetTransportLocked();
                    finishResumeAwaitLocked();
                    return false;
                }
                com.up366.asecengine.englishengine.AsecSession asecSession2 = this.activeSession;
                if (asecSession2 != null) {
                    asecSession2.setOnlineMessage(getLatestEventSummary());
                }
                return !this.resumeRequested && !this.reconnectingForResume && this.protocolConnected && this.failureMessage == null;
            }
        } catch (java.lang.InterruptedException e) {
            java.lang.Thread.currentThread().interrupt();
            synchronized (this.lock) {
                this.reconnectingForResume = false;
                this.failureMessage = e.getMessage();
                this.transportLogHelper.resumeFailed(e.getMessage());
                com.up366.asecengine.englishengine.AsecSession asecSession3 = this.activeSession;
                if (asecSession3 != null) {
                    asecSession3.setOnlineMessage(e.getMessage());
                }
                resetTransportLocked();
                finishResumeAwaitLocked();
                return false;
            }
        }
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.lock) {
            z = this.transportConnected && this.protocolConnected && !this.closed;
        }
        return z;
    }

    public boolean restart(com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfig) {
        return restart(asecWebSocketConfig, null);
    }

    public boolean restart(com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfig, java.lang.String str) {
        java.lang.String str2;
        synchronized (this.lock) {
            java.lang.String strResolveRestartPracticeIdLocked = resolveRestartPracticeIdLocked(str);
            if (!isRestartAvailableLocked(strResolveRestartPracticeIdLocked)) {
                com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
                if (asecSession == null) {
                    str2 = "re_start skipped: active session missing";
                } else {
                    str2 = "re_start skipped: audioPracticeId missing or session already stopping";
                }
                this.latestEventSummary = str2;
                if (asecSession != null) {
                    asecSession.setOnlineMessage(str2);
                }
                this.transportLogHelper.resumeFailed(this.latestEventSummary);
                return false;
            }
            syncActiveSessionPracticeIdLocked(strResolveRestartPracticeIdLocked);
            com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfigResolveRestartWebSocketConfigLocked = resolveRestartWebSocketConfigLocked(asecWebSocketConfig);
            if (asecWebSocketConfigResolveRestartWebSocketConfigLocked != null && asecWebSocketConfigResolveRestartWebSocketConfigLocked.getWebSocketUrl() != null && asecWebSocketConfigResolveRestartWebSocketConfigLocked.getWebSocketUrl().trim().length() != 0) {
                long connectTimeoutMs = asecWebSocketConfigResolveRestartWebSocketConfigLocked.getConnectTimeoutMs();
                if (!connect(asecWebSocketConfigResolveRestartWebSocketConfigLocked)) {
                    synchronized (this.lock) {
                        com.up366.asecengine.englishengine.AsecSession asecSession2 = this.activeSession;
                        if (asecSession2 != null) {
                            asecSession2.setOnlineMessage(getLatestEventSummary());
                        }
                    }
                    return false;
                }
                synchronized (this.lock) {
                    java.lang.String strResolveRestartPracticeIdLocked2 = resolveRestartPracticeIdLocked(str);
                    if (!isRestartAvailableLocked(strResolveRestartPracticeIdLocked2)) {
                        this.latestEventSummary = "re_start canceled: session state changed";
                        com.up366.asecengine.englishengine.AsecSession asecSession3 = this.activeSession;
                        if (asecSession3 != null) {
                            asecSession3.setOnlineMessage("re_start canceled: session state changed");
                        }
                        this.transportLogHelper.resumeFailed(this.latestEventSummary);
                        return false;
                    }
                    syncActiveSessionPracticeIdLocked(strResolveRestartPracticeIdLocked2);
                    this.failureMessage = null;
                    this.reconnectingForResume = true;
                    this.resumeReadyLatch = new java.util.concurrent.CountDownLatch(1);
                    if (!sendRestartFrameLocked(strResolveRestartPracticeIdLocked2)) {
                        this.reconnectingForResume = false;
                        com.up366.asecengine.englishengine.AsecSession asecSession4 = this.activeSession;
                        if (asecSession4 != null) {
                            asecSession4.setOnlineMessage(getLatestEventSummary());
                        }
                        resetTransportLocked();
                        finishResumeAwaitLocked();
                        return false;
                    }
                    return awaitResumeReady(connectTimeoutMs);
                }
            }
            this.latestEventSummary = "re_start skipped: websocket url is empty";
            com.up366.asecengine.englishengine.AsecSession asecSession5 = this.activeSession;
            if (asecSession5 != null) {
                asecSession5.setOnlineMessage("re_start skipped: websocket url is empty");
            }
            this.transportLogHelper.resumeFailed(this.latestEventSummary);
            return false;
        }
    }

    public java.lang.String getLatestEventSummary() {
        java.lang.String str;
        synchronized (this.lock) {
            str = this.latestEventSummary;
            if (str == null) {
                str = this.failureMessage;
            }
        }
        return str;
    }

    public boolean startSession(com.up366.asecengine.englishengine.AsecSession asecSession, com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig asecOnlineScoringConfig, java.lang.Integer num) {
        com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig webSocketConfig;
        if (asecSession == null || asecOnlineScoringConfig == null) {
            return false;
        }
        if (asecOnlineScoringConfig.getWebSocketConfig() != null) {
            webSocketConfig = asecOnlineScoringConfig.getWebSocketConfig();
        } else {
            webSocketConfig = this.currentWebSocketConfig;
        }
        if (!connect(webSocketConfig)) {
            asecSession.setOnlineMessage(getLatestEventSummary());
            return false;
        }
        synchronized (this.lock) {
            clearActiveSessionLocked(false);
            this.activeSession = asecSession;
            this.currentOnlineScoringConfig = asecOnlineScoringConfig;
            this.currentUserId = num;
            this.autoResumePolicy = asecOnlineScoringConfig.getAutoResumePolicy();
            this.packetsPerChunk = java.lang.Math.max(1, 10);
            this.packetRetryMaxCount = asecOnlineScoringConfig.getPacketRetryMaxCount();
            this.stopAckWaitMs = asecOnlineScoringConfig.getStopAckWaitMs();
            clearRealtimeAudioCacheLocked();
            this.audioSequence.set(0);
            this.realtimeUploadFailed = false;
            this.startCommandSent = false;
            this.stopCommandSent = false;
            this.resumeRequested = false;
            this.reconnectingForResume = false;
            resetAutoResumeWindowLocked();
            this.failureMessage = null;
            this.latestEventSummary = null;
            this.sessionInfo = null;
            this.sessionReadyLatch = new java.util.concurrent.CountDownLatch(1);
            finishResumeAwaitLocked();
            if (!sendStartFrameLocked()) {
                asecSession.setOnlineMessage(getLatestEventSummary());
                clearActiveSessionLocked(false);
                return false;
            }
            try {
                boolean zAwait = this.sessionReadyLatch.await(webSocketConfig.getConnectTimeoutMs(), java.util.concurrent.TimeUnit.MILLISECONDS);
                synchronized (this.lock) {
                    if (zAwait) {
                        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.SessionInfo sessionInfo = this.sessionInfo;
                        if (sessionInfo != null && this.failureMessage == null) {
                            asecSession.setAudioPracticeId(sessionInfo.practiceId);
                            asecSession.setOnlineSessionId(this.sessionInfo.sessionId);
                            asecSession.setOnlineUploadState(1);
                            asecSession.setOnlineMessage(this.latestEventSummary);
                            this.transportLogHelper.sessionReady(this.sessionInfo.sessionId, this.sessionInfo.practiceId);
                            return true;
                        }
                    }
                    this.transportLogHelper.startSessionFailed(getLatestEventSummary());
                    asecSession.setOnlineMessage(getLatestEventSummary());
                    clearActiveSessionLocked(false);
                    return false;
                }
            } catch (java.lang.InterruptedException e) {
                java.lang.Thread.currentThread().interrupt();
                asecSession.setOnlineMessage(e.getMessage());
                this.transportLogHelper.startSessionInterrupted(e.getMessage());
                synchronized (this.lock) {
                    clearActiveSessionLocked(false);
                    return false;
                }
            }
        }
    }

    public void onOpusPacket(com.up366.asecengine.englishengine.AsecSession asecSession, byte[] bArr, long j) {
        if (asecSession == null || bArr == null || bArr.length == 0) {
            return;
        }
        synchronized (this.lock) {
            if (asecSession == this.activeSession && asecSession.isOnlineScoringEnabled()) {
                if (!this.realtimeUploadFailed && this.sessionInfo != null && !this.stopCommandSent) {
                    if (this.bufferedPackets.isEmpty()) {
                        this.bufferedPacketsTimestampMs = j;
                    }
                    this.bufferedPackets.add((byte[]) bArr.clone());
                    if (this.bufferedPackets.size() >= this.packetsPerChunk) {
                        flushPendingPacketsLocked();
                    }
                }
            }
        }
    }

    public void onRecordCompleted(com.up366.asecengine.englishengine.AsecSession asecSession) {
        java.lang.String strResolveRestartPracticeIdLocked;
        boolean z;
        boolean z2;
        boolean z3;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this.lock) {
            if (asecSession != null) {
                if (asecSession == this.activeSession && asecSession.isOnlineScoringEnabled()) {
                    suppressAutoResumeLocked("record stop", arrayList);
                    if (!asecSession.isLocalScoringEnabled()) {
                        asecSession.onRecordStateChange(3);
                    }
                    flushPendingPacketsLocked();
                    com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfigResolveRestartWebSocketConfigLocked = null;
                    if (shouldAttemptStopResumeLocked()) {
                        strResolveRestartPracticeIdLocked = resolveRestartPracticeIdLocked(null);
                        asecWebSocketConfigResolveRestartWebSocketConfigLocked = resolveRestartWebSocketConfigLocked(null);
                        if (canAttemptStopResumeLocked(strResolveRestartPracticeIdLocked, asecWebSocketConfigResolveRestartWebSocketConfigLocked)) {
                            z = false;
                        } else {
                            this.realtimeUploadFailed = true;
                            emitStopFallbackLocked(buildStopFallbackReasonLocked(), arrayList);
                            z = true;
                        }
                        if (!z) {
                            beginStopResumeLocked();
                            z3 = this.autoResumeInFlight;
                            z2 = !z3;
                        }
                        z2 = false;
                    } else if (!sendStopFrameLocked(false)) {
                        this.latestEventSummary = "stop command send failed";
                        strResolveRestartPracticeIdLocked = resolveRestartPracticeIdLocked(null);
                        asecWebSocketConfigResolveRestartWebSocketConfigLocked = resolveRestartWebSocketConfigLocked(null);
                        if (canAttemptStopResumeLocked(strResolveRestartPracticeIdLocked, asecWebSocketConfigResolveRestartWebSocketConfigLocked)) {
                            z = false;
                        } else {
                            this.realtimeUploadFailed = true;
                            emitStopFallbackLocked(buildStopFallbackReasonLocked(), arrayList);
                            z = true;
                        }
                        if (!z) {
                            beginStopResumeLocked();
                            z3 = this.autoResumeInFlight;
                            z2 = !z3;
                        }
                        z2 = false;
                    } else {
                        scheduleStopEvaluateLocked();
                        strResolveRestartPracticeIdLocked = null;
                        z = false;
                        z2 = false;
                    }
                    emitPendingTransportLogs(arrayList);
                    if (!z && z2) {
                        boolean zRestart = restart(asecWebSocketConfigResolveRestartWebSocketConfigLocked, strResolveRestartPracticeIdLocked);
                        java.util.ArrayList arrayList2 = new java.util.ArrayList();
                        synchronized (this.lock) {
                            if (this.stopResumePending && matchActiveSessionByPracticeIdLocked(strResolveRestartPracticeIdLocked)) {
                                if (!zRestart) {
                                    this.realtimeUploadFailed = true;
                                    emitStopFallbackLocked(buildStopFallbackReasonLocked(), arrayList2);
                                } else if (!sendStopFrameLocked(false)) {
                                    this.latestEventSummary = "stop command send failed";
                                    this.realtimeUploadFailed = true;
                                    emitStopFallbackLocked(buildStopFallbackReasonLocked(), arrayList2);
                                } else {
                                    this.stopResumePending = false;
                                    scheduleStopEvaluateLocked();
                                }
                            }
                        }
                        emitPendingTransportLogs(arrayList2);
                    }
                }
            }
        }
    }

    public void onRecordForceOver(com.up366.asecengine.englishengine.AsecSession asecSession) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this.lock) {
            if (asecSession != null) {
                if (asecSession == this.activeSession && asecSession.isOnlineScoringEnabled()) {
                    suppressAutoResumeLocked("record force over", arrayList);
                    sendStopFrameLocked(true);
                    clearActiveSessionLocked(false);
                    emitPendingTransportLogs(arrayList);
                }
            }
        }
    }

    public void abortSession(com.up366.asecengine.englishengine.AsecSession asecSession) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this.lock) {
            if (asecSession != null) {
                if (asecSession == this.activeSession) {
                    suppressAutoResumeLocked("abort session", arrayList);
                    clearActiveSessionLocked(false);
                }
            }
        }
        emitPendingTransportLogs(arrayList);
    }

    public void clearRetryableFallbackSession(java.lang.String str) {
        com.up366.asecengine.englishengine.AsecSession asecSession;
        synchronized (this.lock) {
            if (str != null) {
                if (str.length() != 0 && (asecSession = this.activeSession) != null) {
                    if (str.equals(asecSession.getRecordId())) {
                        int onlineUploadState = this.activeSession.getOnlineUploadState();
                        if (onlineUploadState == 6 || onlineUploadState == 7) {
                            clearActiveSessionLocked(false);
                        }
                    }
                }
            }
        }
    }

    public boolean reportUploadedOpusRetryBegin(java.lang.String str) {
        return reportUploadedOpusRetryBegin(str, null);
    }

    public boolean reportUploadedOpusRetryBegin(java.lang.String str, java.lang.String str2) {
        synchronized (this.lock) {
            if (!matchActiveSessionByPracticeIdLocked(str)) {
                return false;
            }
            syncActiveSessionPracticeIdLocked(str);
            return moveFallbackRetryToBeginIfNeededLocked(str2);
        }
    }

    public boolean reportUploadedOpusUrl(java.lang.String str, java.lang.String str2) {
        java.lang.String strTrim = str2 == null ? null : str2.trim();
        synchronized (this.lock) {
            if (matchActiveSessionByPracticeIdLocked(str) && strTrim != null && strTrim.length() != 0) {
                syncActiveSessionPracticeIdLocked(str);
                if (!isFallbackUploadReadyLocked()) {
                    cachePendingUploadedOpusUrlLocked(str, strTrim);
                    return true;
                }
                moveFallbackRetryToBeginIfNeededLocked(null);
                com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfig = this.currentWebSocketConfig;
                if (isConnected()) {
                    return finishUploadedOpusUrlLocked(str, strTrim);
                }
                if (!connect(asecWebSocketConfig)) {
                    synchronized (this.lock) {
                        if (matchActiveSessionByPracticeIdLocked(str)) {
                            emitFallbackFailedLocked("websocket reconnect failed");
                        }
                    }
                    return false;
                }
                synchronized (this.lock) {
                    if (!matchActiveSessionByPracticeIdLocked(str)) {
                        return false;
                    }
                    syncActiveSessionPracticeIdLocked(str);
                    return finishUploadedOpusUrlLocked(str, strTrim);
                }
            }
            return false;
        }
    }

    public boolean reportUploadedOpusFailed(java.lang.String str, java.lang.String str2) {
        synchronized (this.lock) {
            if (!matchActiveSessionByPracticeIdLocked(str)) {
                return false;
            }
            syncActiveSessionPracticeIdLocked(str);
            java.lang.String strTrim = str2 == null ? null : str2.trim();
            if ((strTrim == null || strTrim.length() == 0) && (strTrim = this.latestEventSummary) == null) {
                strTrim = "fallback upload failed";
            }
            moveFallbackRetryToBeginIfNeededLocked(null);
            clearPendingUploadedOpusUrlLocked();
            emitFallbackFailedLocked(strTrim);
            return true;
        }
    }

    public boolean reportUploadedMp3Url(java.lang.String str, java.lang.String str2) {
        synchronized (this.lock) {
            if (isConnected() && str != null && str.trim().length() != 0 && str2 != null && str2.trim().length() != 0) {
                return sendUploadedAudioUrlFrameLocked(str, UPLOADED_MP3_URL_FIELD, str2, "mp3 upload url sent");
            }
            return false;
        }
    }

    private boolean finishUploadedOpusUrlLocked(java.lang.String str, java.lang.String str2) {
        if (sendUploadedAudioUrlFrameLocked(str, UPLOADED_OPUS_URL_FIELD, str2, "fallback upload url sent")) {
            this.activeSession.setOnlineUploadState(8);
            this.activeSession.setOnlineMessage("fallback upload success");
            this.activeSession.onRecordStateChange(8);
            clearActiveSessionLocked(false);
            return true;
        }
        emitFallbackFailedLocked("fallback upload url send failed");
        return false;
    }

    public boolean disconnect() {
        synchronized (this.lock) {
            requestDisconnectLocked("manual");
            maybeStartDeferredDisconnectLocked();
        }
        return true;
    }

    public void setTransportLogListener(final com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.TransportLogListener transportLogListener) {
        com.up366.asecengine.englishengine.v2.AsecOnlineTransportLogHelper.LogListener logListener;
        com.up366.asecengine.englishengine.v2.AsecOnlineTransportLogHelper asecOnlineTransportLogHelper = this.transportLogHelper;
        if (transportLogListener == null) {
            logListener = null;
        } else {
            java.util.Objects.requireNonNull(transportLogListener);
            logListener = new com.up366.asecengine.englishengine.v2.AsecOnlineTransportLogHelper.LogListener() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager$$ExternalSyntheticLambda9
                @Override // com.up366.asecengine.englishengine.v2.AsecOnlineTransportLogHelper.LogListener
                public final void onLog(java.lang.String str) {
                    transportLogListener.onLog(str);
                }
            };
        }
        asecOnlineTransportLogHelper.setLogListener(logListener);
    }

    public boolean stopOutgoingHeartbeat() {
        synchronized (this.lock) {
            if (!this.closed && this.transportConnected && this.protocolConnected) {
                java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.outgoingHeartbeatFuture;
                if (scheduledFuture == null && this.negotiatedOutgoingHeartbeatMs <= 0) {
                    this.latestEventSummary = "stop heartbeat skipped: outgoing heartbeat not active";
                    this.transportLogHelper.outgoingHeartbeatStopSkipped("outgoing heartbeat not active");
                    return false;
                }
                long j = this.negotiatedOutgoingHeartbeatMs;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                    this.outgoingHeartbeatFuture = null;
                }
                this.negotiatedOutgoingHeartbeatMs = 0L;
                this.latestEventSummary = "outgoing heartbeat stopped";
                this.transportLogHelper.outgoingHeartbeatStopped(j);
                return true;
            }
            this.latestEventSummary = "stop heartbeat skipped: transport not ready";
            this.transportLogHelper.outgoingHeartbeatStopSkipped("transport not ready");
            return false;
        }
    }

    public void release() {
        synchronized (this.lock) {
            this.disconnectRequested = false;
            this.disconnectFrameSent = false;
            disconnectLocked(true);
        }
        this.autoResumeScheduler.shutdownNow();
        this.scheduler.shutdownNow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evaluateStopResult() {
        synchronized (this.lock) {
            this.stopEvaluateFuture = null;
            com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
            if (asecSession == null) {
                return;
            }
            if (asecSession.isGiveUpScoring()) {
                clearActiveSessionLocked(false);
                return;
            }
            if (this.stopCommandSent && !this.realtimeUploadFailed) {
                if (!this.stopResumePending && !this.resumeRequested && !this.reconnectingForResume && !hasPendingRealtimeAudioLocked()) {
                    this.latestEventSummary = "online upload success";
                    this.activeSession.setOnlineUploadState(5);
                    this.activeSession.setOnlineMessage(this.latestEventSummary);
                    this.activeSession.onRecordStateChange(5);
                    clearActiveSessionLocked(false);
                    return;
                }
                scheduleStopEvaluateLocked();
                return;
            }
            emitStopFallbackLocked(buildStopFallbackReasonLocked());
        }
    }

    private java.lang.String buildStopFallbackReasonLocked() {
        java.lang.String strLatestOrFailureMessageLocked = latestOrFailureMessageLocked();
        if (!this.stopCommandSent) {
            return strLatestOrFailureMessageLocked != null ? strLatestOrFailureMessageLocked : "stop command send failed";
        }
        if (this.realtimeUploadFailed) {
            return strLatestOrFailureMessageLocked != null ? strLatestOrFailureMessageLocked : "realtime upload failed, fallback required";
        }
        int size = this.pendingAckBatches.size();
        if (size <= 0) {
            return strLatestOrFailureMessageLocked != null ? strLatestOrFailureMessageLocked : "realtime upload incomplete, fallback required";
        }
        return "stop ack wait exceeded: pendingAckCount=" + size + ", outstandingBatchCount=" + this.outstandingAudioBatches.size();
    }

    private java.lang.String latestOrFailureMessageLocked() {
        java.lang.String onlineMessage;
        java.lang.String str = this.failureMessage;
        if (str != null && str.length() > 0) {
            return this.failureMessage;
        }
        java.lang.String str2 = this.latestEventSummary;
        if (str2 != null && str2.length() > 0) {
            return this.latestEventSummary;
        }
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        if (asecSession == null || (onlineMessage = asecSession.getOnlineMessage()) == null || onlineMessage.length() <= 0) {
            return null;
        }
        return onlineMessage;
    }

    private boolean shouldAttemptStopResumeLocked() {
        return this.resumeRequested || this.reconnectingForResume || !this.protocolConnected;
    }

    private boolean canAttemptStopResumeLocked(java.lang.String str, com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfig) {
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        return (asecSession == null || !asecSession.isOnlineScoringEnabled() || this.realtimeUploadFailed || str == null || str.length() <= 0 || asecWebSocketConfig == null || asecWebSocketConfig.getWebSocketUrl() == null || asecWebSocketConfig.getWebSocketUrl().trim().length() <= 0) ? false : true;
    }

    private void beginStopResumeLocked() {
        this.stopResumePending = true;
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        if (asecSession == null) {
            return;
        }
        asecSession.setOnlineUploadState(3);
        this.activeSession.setOnlineMessage("stop received, replaying remaining realtime audio before fallback");
        this.activeSession.onRecordStateChange(10);
    }

    private void emitStopFallbackLocked(java.lang.String str) {
        emitStopFallbackLocked(str, null);
    }

    private void emitStopFallbackLocked(java.lang.String str, java.util.List<java.lang.Runnable> list) {
        this.stopResumePending = false;
        suppressAutoResumeLocked("stop fallback", list);
        resetResumeStateLocked();
        clearRealtimeAudioCacheLocked();
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        if (asecSession == null) {
            return;
        }
        asecSession.setOnlineUploadState(6);
        this.activeSession.setOnlineMessage(str);
        this.latestEventSummary = str;
        this.activeSession.onRecordStateChange(6);
        maybeFlushPendingUploadedOpusUrlLocked();
    }

    private void scheduleStopEvaluateLocked() {
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.stopEvaluateFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.stopEvaluateFuture = this.scheduler.schedule(new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.1
            @Override // java.lang.Runnable
            public void run() {
                com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.evaluateStopResult();
            }
        }, this.stopAckWaitMs, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    private boolean matchActiveSessionByPracticeIdLocked(java.lang.String str) {
        if (this.activeSession == null || str == null || str.length() == 0) {
            return false;
        }
        java.lang.String audioPracticeId = this.activeSession.getAudioPracticeId();
        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.SessionInfo sessionInfo = this.sessionInfo;
        return str.equals(com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.firstNonEmpty(audioPracticeId, sessionInfo != null ? sessionInfo.practiceId : null));
    }

    private boolean moveFallbackRetryToBeginIfNeededLocked(java.lang.String str) {
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        if (asecSession == null) {
            return false;
        }
        int onlineUploadState = asecSession.getOnlineUploadState();
        if (onlineUploadState == 6) {
            return true;
        }
        if (onlineUploadState != 7) {
            return false;
        }
        java.lang.String strTrim = str == null ? null : str.trim();
        if (strTrim == null || strTrim.length() == 0) {
            strTrim = FALLBACK_RETRYING_MESSAGE;
        }
        this.activeSession.setOnlineUploadState(6);
        this.activeSession.setOnlineMessage(strTrim);
        this.latestEventSummary = strTrim;
        this.activeSession.onRecordStateChange(6);
        return true;
    }

    private boolean isFallbackUploadReadyLocked() {
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        if (asecSession == null) {
            return false;
        }
        int onlineUploadState = asecSession.getOnlineUploadState();
        return onlineUploadState == 6 || onlineUploadState == 7;
    }

    private void cachePendingUploadedOpusUrlLocked(java.lang.String str, java.lang.String str2) {
        this.pendingUploadedOpusPracticeId = str;
        this.pendingUploadedOpusUrl = str2;
    }

    private void maybeFlushPendingUploadedOpusUrlLocked() {
        java.lang.String str = this.pendingUploadedOpusPracticeId;
        if (str == null || this.pendingUploadedOpusUrl == null || !matchActiveSessionByPracticeIdLocked(str) || !isFallbackUploadReadyLocked()) {
            return;
        }
        final java.lang.String str2 = this.pendingUploadedOpusPracticeId;
        final java.lang.String str3 = this.pendingUploadedOpusUrl;
        this.scheduler.execute(new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.2
            @Override // java.lang.Runnable
            public void run() {
                com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.reportUploadedOpusUrl(str2, str3);
            }
        });
    }

    private void clearPendingUploadedOpusUrlLocked() {
        this.pendingUploadedOpusPracticeId = null;
        this.pendingUploadedOpusUrl = null;
    }

    private void emitFallbackFailedLocked(java.lang.String str) {
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        if (asecSession == null) {
            return;
        }
        asecSession.setOnlineUploadState(7);
        this.activeSession.setOnlineMessage(str);
        this.activeSession.onRecordStateChange(7);
    }

    private void clearActiveSessionLocked(boolean z) {
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.stopEvaluateFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.stopEvaluateFuture = null;
        }
        clearRealtimeAudioCacheLocked();
        clearPendingUploadedOpusUrlLocked();
        this.activeSession = null;
        this.sessionInfo = null;
        this.currentOnlineScoringConfig = null;
        this.currentUserId = null;
        this.autoResumePolicy = new com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy();
        this.realtimeUploadFailed = false;
        this.startCommandSent = false;
        this.stopCommandSent = false;
        this.packetRetryMaxCount = 0;
        this.stopAckWaitMs = 100L;
        this.stopResumePending = false;
        resetResumeStateLocked();
        resetAutoResumeWindowLocked();
        this.latestEventSummary = null;
        this.failureMessage = null;
        this.audioSequence.set(0);
        if (z) {
            disconnectLocked(true);
        } else {
            maybeStartDeferredDisconnectLocked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnectLocked(boolean z) {
        okhttp3.OkHttpClient okHttpClient;
        cancelDisconnectCloseLocked();
        cancelHeartbeatTasksLocked();
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.stopEvaluateFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.stopEvaluateFuture = null;
        }
        clearRealtimeAudioCacheLocked();
        clearPendingUploadedOpusUrlLocked();
        this.activeSession = null;
        this.sessionInfo = null;
        this.currentOnlineScoringConfig = null;
        this.currentUserId = null;
        this.autoResumePolicy = new com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy();
        this.latestEventSummary = null;
        this.failureMessage = null;
        this.startCommandSent = false;
        this.stopCommandSent = false;
        this.realtimeUploadFailed = false;
        this.packetRetryMaxCount = 0;
        this.stopAckWaitMs = 100L;
        this.stopResumePending = false;
        resetResumeStateLocked();
        resetAutoResumeWindowLocked();
        this.disconnectRequested = false;
        this.disconnectFrameSent = false;
        this.connectionId = null;
        this.connectRequestId = null;
        okhttp3.WebSocket webSocket = this.webSocket;
        if (webSocket != null) {
            try {
                webSocket.close(1000, "client_close");
            } catch (java.lang.Exception unused) {
            }
            this.webSocket = null;
        }
        this.transportConnected = false;
        this.protocolConnected = false;
        this.closed = true;
        this.transportReadyLatch.countDown();
        this.sessionReadyLatch.countDown();
        if (!z || (okHttpClient = this.client) == null) {
            return;
        }
        okHttpClient.dispatcher().executorService().shutdown();
        this.client.connectionPool().evictAll();
        this.client = null;
    }

    private void resetTransportLocked() {
        cancelDisconnectCloseLocked();
        cancelHeartbeatTasksLocked();
        this.disconnectRequested = false;
        this.disconnectFrameSent = false;
        this.connectionId = null;
        this.connectRequestId = null;
        okhttp3.WebSocket webSocket = this.webSocket;
        if (webSocket != null) {
            try {
                webSocket.close(1000, "client_reset");
            } catch (java.lang.Exception unused) {
            }
            this.webSocket = null;
        }
        this.transportConnected = false;
        this.protocolConnected = false;
        this.closed = true;
        okhttp3.OkHttpClient okHttpClient = this.client;
        if (okHttpClient != null) {
            okHttpClient.dispatcher().executorService().shutdown();
            this.client.connectionPool().evictAll();
            this.client = null;
        }
    }

    private boolean sameConnectionConfig(com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfig) {
        com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfig2 = this.currentWebSocketConfig;
        return (asecWebSocketConfig2 == null || asecWebSocketConfig2.getWebSocketUrl() == null || !this.currentWebSocketConfig.getWebSocketUrl().equals(asecWebSocketConfig.getWebSocketUrl())) ? false : true;
    }

    private void cancelHeartbeatTasksLocked() {
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.outgoingHeartbeatFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.outgoingHeartbeatFuture = null;
        }
        java.util.concurrent.ScheduledFuture<?> scheduledFuture2 = this.incomingHeartbeatFuture;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(false);
            this.incomingHeartbeatFuture = null;
        }
        this.negotiatedOutgoingHeartbeatMs = 0L;
        this.negotiatedIncomingHeartbeatMs = 0L;
        this.lastOutboundActivityMs = 0L;
        this.lastInboundActivityMs = 0L;
    }

    private void startHeartbeatTasksLocked(long j, long j2) {
        cancelHeartbeatTasksLocked();
        this.negotiatedOutgoingHeartbeatMs = java.lang.Math.max(j2, 0L);
        this.negotiatedIncomingHeartbeatMs = java.lang.Math.max(j, 0L);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        this.lastOutboundActivityMs = jCurrentTimeMillis;
        this.lastInboundActivityMs = jCurrentTimeMillis;
        this.transportLogHelper.heartbeatNegotiated(this.negotiatedOutgoingHeartbeatMs, this.negotiatedIncomingHeartbeatMs);
        if (this.negotiatedOutgoingHeartbeatMs > 0) {
            java.util.concurrent.ScheduledExecutorService scheduledExecutorService = this.scheduler;
            java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.3
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.lock) {
                        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.sendHeartbeatIfNeededLocked();
                    }
                }
            };
            long j3 = this.negotiatedOutgoingHeartbeatMs;
            this.outgoingHeartbeatFuture = scheduledExecutorService.scheduleAtFixedRate(runnable, j3, j3, java.util.concurrent.TimeUnit.MILLISECONDS);
        }
        if (this.negotiatedIncomingHeartbeatMs > 0) {
            java.util.concurrent.ScheduledExecutorService scheduledExecutorService2 = this.scheduler;
            java.lang.Runnable runnable2 = new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.4
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.lock) {
                        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.checkIncomingHeartbeatLocked();
                    }
                }
            };
            long j4 = this.negotiatedIncomingHeartbeatMs;
            this.incomingHeartbeatFuture = scheduledExecutorService2.scheduleAtFixedRate(runnable2, j4, j4, java.util.concurrent.TimeUnit.MILLISECONDS);
        }
    }

    private void prepareTransportForConnectLocked() {
        if (this.disconnectFrameSent) {
            this.transportLogHelper.connectRequestedAfterDisconnectSent();
            disconnectLocked(true);
        } else if (this.disconnectRequested) {
            this.disconnectRequested = false;
            this.transportLogHelper.disconnectCanceledConnectRequestedBeforeSend();
        }
    }

    private void requestDisconnectLocked(java.lang.String str) {
        if (this.disconnectFrameSent) {
            this.transportLogHelper.disconnectAlreadySent(str);
        } else if (this.disconnectRequested) {
            this.transportLogHelper.disconnectAlreadyPending(str);
        } else {
            this.disconnectRequested = true;
            this.transportLogHelper.disconnectRequested(str, this.activeSession != null, this.stopEvaluateFuture != null, this.pendingAckBatches.size());
        }
    }

    private void maybeStartDeferredDisconnectLocked() {
        java.lang.String str;
        if (!this.disconnectRequested || this.disconnectFrameSent) {
            return;
        }
        if (this.activeSession != null || this.stopEvaluateFuture != null || !this.pendingAckBatches.isEmpty()) {
            this.transportLogHelper.disconnectWaiting(this.activeSession != null, this.stopEvaluateFuture != null, this.pendingAckBatches.size());
            return;
        }
        if (this.webSocket == null || this.closed || !this.transportConnected || !this.protocolConnected || (str = this.connectionId) == null || str.length() == 0) {
            this.transportLogHelper.disconnectFinalizeWithoutControlFrame(this.connectionId);
            disconnectLocked(true);
        } else if (!sendDisconnectFrameLocked()) {
            this.transportLogHelper.disconnectControlFrameSendFailedCloseImmediately();
            disconnectLocked(true);
        } else {
            this.disconnectFrameSent = true;
            scheduleDisconnectCloseLocked(200L);
        }
    }

    private void scheduleDisconnectCloseLocked(long j) {
        cancelDisconnectCloseLocked();
        this.transportLogHelper.disconnectCloseScheduled(j);
        this.disconnectCloseFuture = this.scheduler.schedule(new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.lock) {
                    com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.disconnectCloseFuture = null;
                    if (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.disconnectRequested && com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.disconnectFrameSent) {
                        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.transportLogHelper.disconnectCloseExecutingAfterWait();
                        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.disconnectLocked(true);
                    }
                }
            }
        }, j, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    private void cancelDisconnectCloseLocked() {
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.disconnectCloseFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.disconnectCloseFuture = null;
        }
    }

    private void markOutboundActivityLocked() {
        this.lastOutboundActivityMs = java.lang.System.currentTimeMillis();
    }

    private void markInboundActivityLocked() {
        this.lastInboundActivityMs = java.lang.System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendHeartbeatIfNeededLocked() {
        if (this.closed || !this.transportConnected || !this.protocolConnected || this.webSocket == null || this.negotiatedOutgoingHeartbeatMs <= 0) {
            return;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastOutboundActivityMs < this.negotiatedOutgoingHeartbeatMs) {
            return;
        }
        java.lang.String strNewRequestId = com.up366.asecengine.englishengine.v2.AsecRequestIdHelper.newRequestId();
        if (sendTextFrameLocked(com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.buildPingFrame(jCurrentTimeMillis, strNewRequestId, this.connectionId).toString())) {
            this.transportLogHelper.sendPing(strNewRequestId, jCurrentTimeMillis);
        } else {
            markFailureLocked("send heartbeat failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkIncomingHeartbeatLocked() {
        if (this.closed || !this.transportConnected || !this.protocolConnected || this.negotiatedIncomingHeartbeatMs <= 0) {
            return;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long j = this.negotiatedIncomingHeartbeatMs;
        long jMax = java.lang.Math.max(2 * j, j + com.igexin.push.config.c.s);
        long j2 = this.lastInboundActivityMs;
        if (j2 <= 0 || jCurrentTimeMillis - j2 <= jMax) {
            return;
        }
        this.transportLogHelper.incomingHeartbeatTimeout(jCurrentTimeMillis - j2);
        markFailureLocked("heartbeat timeout");
    }

    private boolean sendStartFrameLocked() {
        if (this.currentOnlineScoringConfig == null) {
            this.failureMessage = "online scoring config missing";
            return false;
        }
        this.startCommandSent = true;
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.put(jSONObject, "extend_parameters", this.currentOnlineScoringConfig.getOnlineScoringParameters());
        com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.putIfMissing(jSONObject, "audio_sample_rate", 16000);
        com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.putIfMissing(jSONObject, "audio_encoding", AUDIO_ENCODING_OPUS);
        com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.putIfMissing(jSONObject, "audio_channels", 1);
        com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.putIfMissing(jSONObject, "user_id", this.currentUserId);
        java.lang.String strNewRequestId = com.up366.asecengine.englishengine.v2.AsecRequestIdHelper.newRequestId();
        java.lang.String string = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.buildControlFrame(NATIVE_TYPE_START, jSONObject, strNewRequestId, this.connectionId).toString();
        this.transportLogHelper.sendStart(strNewRequestId, string);
        boolean zSendTextFrameLocked = sendTextFrameLocked(string);
        if (!zSendTextFrameLocked) {
            this.failureMessage = "send start request failed";
        }
        return zSendTextFrameLocked;
    }

    private boolean sendRestartFrameLocked(java.lang.String str) {
        if (str == null || str.length() == 0) {
            this.latestEventSummary = "re_start skipped: audioPracticeId missing";
            this.transportLogHelper.resumeFailed("re_start skipped: audioPracticeId missing");
            return false;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.put(jSONObject, "audio_practice_id", str);
        java.lang.String strNewRequestId = com.up366.asecengine.englishengine.v2.AsecRequestIdHelper.newRequestId();
        java.lang.String string = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.buildControlFrame(NATIVE_TYPE_RESTART, jSONObject, strNewRequestId, this.connectionId).toString();
        this.transportLogHelper.sendRestart(strNewRequestId, string);
        boolean zSendTextFrameLocked = sendTextFrameLocked(string);
        if (!zSendTextFrameLocked) {
            this.latestEventSummary = "send re_start request failed";
        }
        return zSendTextFrameLocked;
    }

    private boolean sendStopFrameLocked(boolean z) {
        if (this.sessionInfo == null || this.currentOnlineScoringConfig == null) {
            return false;
        }
        int i = this.audioSequence.get();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.put(jSONObject, "audio_practice_id", this.sessionInfo.practiceId);
        com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.put(jSONObject, "package_total", java.lang.Integer.valueOf(i));
        com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.put(jSONObject, "connection_id", this.connectionId);
        com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.put(jSONObject, "give_up", java.lang.Boolean.valueOf(z));
        java.lang.String strNewRequestId = com.up366.asecengine.englishengine.v2.AsecRequestIdHelper.newRequestId();
        java.lang.String string = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.buildControlFrame(NATIVE_TYPE_STOP, jSONObject, strNewRequestId, this.connectionId).toString();
        this.transportLogHelper.sendStop(strNewRequestId, string);
        boolean zSendTextFrameLocked = sendTextFrameLocked(string);
        this.stopCommandSent = zSendTextFrameLocked;
        if (zSendTextFrameLocked) {
            this.latestEventSummary = z ? "giveup stop command sent" : "stop command sent";
        }
        return zSendTextFrameLocked;
    }

    private boolean sendDisconnectFrameLocked() {
        java.lang.String str = this.connectionId;
        if (str == null || str.length() == 0) {
            this.transportLogHelper.sendDisconnectSkippedConnectionIdEmpty();
            return false;
        }
        if (this.webSocket == null || this.closed || !this.transportConnected || !this.protocolConnected) {
            this.transportLogHelper.sendDisconnectSkippedTransportNotReady();
            return false;
        }
        java.lang.String strNewRequestId = com.up366.asecengine.englishengine.v2.AsecRequestIdHelper.newRequestId();
        java.lang.String string = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.buildDisconnectFrame(NATIVE_TYPE_DISCONNECT, this.connectionId, strNewRequestId).toString();
        this.transportLogHelper.sendDisconnect(strNewRequestId, string);
        boolean zSendTextFrameLocked = sendTextFrameLocked(string);
        if (zSendTextFrameLocked) {
            this.latestEventSummary = "disconnect command sent";
        }
        return zSendTextFrameLocked;
    }

    private boolean sendUploadedAudioUrlFrameLocked(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (str == null || str.trim().length() == 0 || str2 == null || str2.trim().length() == 0 || str3 == null || str3.trim().length() == 0) {
            return false;
        }
        int i = this.audioSequence.get();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.put(jSONObject, "audio_practice_id", str);
        com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.put(jSONObject, str2, str3);
        com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.put(jSONObject, "package_total", java.lang.Integer.valueOf(i));
        java.lang.String strNewRequestId = com.up366.asecengine.englishengine.v2.AsecRequestIdHelper.newRequestId();
        com.alibaba.fastjson.JSONObject jSONObjectBuildControlFrame = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.buildControlFrame(DEFAULT_UPLOAD_FILE_MESSAGE_TYPE, jSONObject, strNewRequestId, this.connectionId);
        java.lang.String string = jSONObjectBuildControlFrame.toString();
        this.transportLogHelper.sendUploadAudioUrl(com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optString(jSONObjectBuildControlFrame, "type"), strNewRequestId, string);
        boolean zSendTextFrameLocked = sendTextFrameLocked(string);
        if (zSendTextFrameLocked && str4 != null) {
            this.latestEventSummary = str4;
        }
        return zSendTextFrameLocked;
    }

    private void flushPendingPacketsLocked() {
        if (this.bufferedPackets.isEmpty() || this.sessionInfo == null || this.currentOnlineScoringConfig == null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.bufferedPackets);
        long jCurrentTimeMillis = this.bufferedPacketsTimestampMs;
        if (jCurrentTimeMillis <= 0) {
            jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        }
        this.bufferedPackets.clear();
        this.bufferedPacketsTimestampMs = 0L;
        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatchBuildPendingAudioBatchLocked = buildPendingAudioBatchLocked(arrayList, jCurrentTimeMillis);
        if (pendingAudioBatchBuildPendingAudioBatchLocked == null) {
            return;
        }
        this.outstandingAudioBatches.put(java.lang.Integer.valueOf(pendingAudioBatchBuildPendingAudioBatchLocked.sequence), pendingAudioBatchBuildPendingAudioBatchLocked);
        this.outstandingAudioBytes += pendingAudioBatchBuildPendingAudioBatchLocked.frameBytes.length;
        if (ensureResumeCacheCapacityLocked()) {
            if (!canSendOutstandingAudioLocked()) {
                this.transportLogHelper.bufferAudioBatchForResume(pendingAudioBatchBuildPendingAudioBatchLocked.requestId, pendingAudioBatchBuildPendingAudioBatchLocked.sequence, pendingAudioBatchBuildPendingAudioBatchLocked.packetCount, pendingAudioBatchBuildPendingAudioBatchLocked.frameBytes.length, this.outstandingAudioBytes);
            } else {
                maybeSendOutstandingAudioLocked();
            }
        }
    }

    private void scheduleAckTimeoutLocked(final com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatch) {
        pendingAudioBatch.cancel();
        pendingAudioBatch.future = this.scheduler.schedule(new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m24x6cec437e(pendingAudioBatch);
            }
        }, com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: renamed from: lambda$scheduleAckTimeoutLocked$1$com-up366-asecengine-englishengine-v2-AsecOnlineScoringManager, reason: not valid java name */
    /* synthetic */ void m24x6cec437e(com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatch) {
        handleAckTimeout(pendingAudioBatch.requestId);
    }

    private void handleAckTimeout(java.lang.String str) {
        synchronized (this.lock) {
            com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatch = this.pendingAckBatches.get(str);
            if (pendingAudioBatch == null) {
                return;
            }
            pendingAudioBatch.cancel();
            pendingAudioBatch.awaitingAck = false;
            this.pendingAckBatches.remove(str);
            if (!this.resumeRequested && !this.reconnectingForResume && canSendOutstandingAudioLocked()) {
                if (pendingAudioBatch.retryCount >= this.packetRetryMaxCount) {
                    this.latestEventSummary = "packet ack timeout, requestId=" + str + " sequence=" + pendingAudioBatch.sequence;
                    this.transportLogHelper.ackTimeoutFailed(str, pendingAudioBatch.sequence, pendingAudioBatch.retryCount);
                    if (shouldPauseForResumeLocked()) {
                        markResumeRequiredLocked(this.latestEventSummary);
                    } else {
                        this.realtimeUploadFailed = true;
                        if (this.pendingAckBatches.isEmpty()) {
                            maybeStartDeferredDisconnectLocked();
                        }
                    }
                    return;
                }
                com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch.access$1908(pendingAudioBatch);
                this.transportLogHelper.ackTimeoutRetry(str, pendingAudioBatch.sequence, pendingAudioBatch.retryCount);
                if (!sendBinaryFrameLocked(pendingAudioBatch.frameBytes)) {
                    if (shouldPauseForResumeLocked()) {
                        this.latestEventSummary = "packet resend interrupted, requestId=" + str + " sequence=" + pendingAudioBatch.sequence;
                        this.transportLogHelper.resendAudioBatchFailed(str, pendingAudioBatch.sequence, pendingAudioBatch.retryCount);
                        markResumeRequiredLocked(this.latestEventSummary);
                    } else if (pendingAudioBatch.retryCount >= this.packetRetryMaxCount) {
                        this.realtimeUploadFailed = true;
                        this.latestEventSummary = "packet resend failed, requestId=" + str + " sequence=" + pendingAudioBatch.sequence;
                        this.transportLogHelper.resendAudioBatchFailed(str, pendingAudioBatch.sequence, pendingAudioBatch.retryCount);
                        if (this.pendingAckBatches.isEmpty()) {
                            maybeStartDeferredDisconnectLocked();
                        }
                    } else {
                        pendingAudioBatch.awaitingAck = true;
                        this.pendingAckBatches.put(str, pendingAudioBatch);
                        scheduleAckTimeoutLocked(pendingAudioBatch);
                    }
                } else {
                    pendingAudioBatch.awaitingAck = true;
                    this.pendingAckBatches.put(str, pendingAudioBatch);
                    com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch.access$2008(pendingAudioBatch);
                    this.transportLogHelper.resendAudioBatch(str, pendingAudioBatch.sequence, pendingAudioBatch.retryCount);
                    scheduleAckTimeoutLocked(pendingAudioBatch);
                }
            }
        }
    }

    static byte[] buildLengthPrefixedOpusBytes(java.util.List<byte[]> list) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        for (byte[] bArr : list) {
            if (bArr.length > MAX_BINARY_PACKET_SIZE) {
                throw new java.lang.IllegalStateException("Binary Opus frame exceeds max size: " + bArr.length);
            }
            writeUint16LittleEndian(byteArrayOutputStream, bArr.length);
            byteArrayOutputStream.write(bArr, 0, bArr.length);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static void writeUint16LittleEndian(java.io.ByteArrayOutputStream byteArrayOutputStream, int i) {
        byteArrayOutputStream.write(i & 255);
        byteArrayOutputStream.write((i >>> 8) & 255);
    }

    private byte[] buildBinaryAudioPayload(com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.SessionInfo sessionInfo, java.lang.String str, java.util.List<byte[]> list, int i, long j) {
        return buildBinaryAudioPayload(resolveBinaryAudioPracticeId(sessionInfo.practiceId), com.up366.asecengine.englishengine.v2.AsecRequestIdHelper.parseRequestId(str), list, i, j);
    }

    static byte[] buildBinaryAudioPayload(long j, int i, java.util.List<byte[]> list, int i2, long j2) {
        byte[] bArrBuildLengthPrefixedOpusBytes = buildLengthPrefixedOpusBytes(list);
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        crc32.update(bArrBuildLengthPrefixedOpusBytes);
        return java.nio.ByteBuffer.allocate(bArrBuildLengthPrefixedOpusBytes.length + 35).order(java.nio.ByteOrder.LITTLE_ENDIAN).putInt(i).putShort((short) 21313).put(BINARY_AUDIO_VERSION).putLong(j).putInt(i2).putLong(j2).putInt((int) crc32.getValue()).putInt(bArrBuildLengthPrefixedOpusBytes.length).put(bArrBuildLengthPrefixedOpusBytes).array();
    }

    static long resolveBinaryAudioPracticeId(java.lang.String str) {
        if (str == null || str.length() == 0) {
            throw new java.lang.IllegalStateException("Binary audio audioPracticeId is missing");
        }
        try {
            return kotlin.UByte$.ExternalSyntheticBackport0.m(str);
        } catch (java.lang.Exception e) {
            throw new java.lang.IllegalStateException("Binary audio audioPracticeId is not uint64: " + str, e);
        }
    }

    private boolean sendTextFrameLocked(java.lang.String str) {
        okhttp3.WebSocket webSocket = this.webSocket;
        if (webSocket == null) {
            this.transportLogHelper.sendTextFrameSkippedWebSocketNull();
            return false;
        }
        boolean zSend = webSocket.send(str);
        if (!zSend) {
            this.transportLogHelper.warn("sendTextFrame failed");
            this.transportLogHelper.sendTextFrameFailed();
        } else {
            markOutboundActivityLocked();
        }
        return zSend;
    }

    private boolean sendBinaryFrameLocked(byte[] bArr) {
        okhttp3.WebSocket webSocket = this.webSocket;
        if (webSocket == null) {
            this.transportLogHelper.sendBinarySkippedWebSocketNull();
            return false;
        }
        boolean zSend = webSocket.send(okio.ByteString.of(bArr));
        if (!zSend) {
            this.transportLogHelper.warn("sendBinaryFrame failed bytes=" + bArr.length);
            this.transportLogHelper.sendBinaryFailed(bArr.length);
        } else {
            markOutboundActivityLocked();
        }
        return zSend;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIncomingText(java.lang.String str) {
        synchronized (this.lock) {
            try {
                try {
                    markInboundActivityLocked();
                    this.transportLogHelper.recvTextFrame(str);
                } catch (java.lang.Exception e) {
                    this.transportLogHelper.error("handleIncomingText", e);
                    markFailureLocked(e.getMessage());
                }
                if (str != null && str.trim().length() != 0) {
                    handleNativeMessageLocked(com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.parseObject(str));
                }
            } finally {
            }
        }
    }

    private void handleNativeMessageLocked(com.alibaba.fastjson.JSONObject jSONObject) {
        java.lang.String strOptString = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optString(jSONObject, "command");
        java.lang.String strResolveMessageType = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.resolveMessageType(jSONObject);
        if (NATIVE_COMMAND_CONNECTED.equals(strOptString) && NATIVE_TYPE_CONNECTED_RESP.equals(strResolveMessageType)) {
            handleConnectedResponseLocked(jSONObject);
            return;
        }
        if (NATIVE_COMMAND_CONTROL.equals(strOptString) || NATIVE_TYPE_DISCONNECT_RESP.equals(strResolveMessageType)) {
            if (NATIVE_TYPE_START_RESP.equals(strResolveMessageType)) {
                handleStartResponseLocked(jSONObject);
                return;
            } else if (NATIVE_TYPE_RESTART_RESP.equals(strResolveMessageType)) {
                handleRestartResponseLocked(jSONObject);
                return;
            } else {
                handleControlResponseLocked(jSONObject);
                return;
            }
        }
        if (NATIVE_COMMAND_ACK.equals(strOptString)) {
            handleAudioAckLocked(jSONObject);
            return;
        }
        if (NATIVE_COMMAND_PONG.equals(strOptString)) {
            handlePongLocked(jSONObject);
            return;
        }
        if (NATIVE_TYPE_SCORE_RESULT.equals(strResolveMessageType)) {
            this.latestEventSummary = "score result received";
            this.transportLogHelper.scoreResult(com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.resolveRequestId(jSONObject), jSONObject);
        } else if ("error".equalsIgnoreCase(strOptString) || "error".equalsIgnoreCase(strResolveMessageType)) {
            markFailureLocked(com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.resolveMessage(jSONObject, "websocket error"));
        } else {
            this.transportLogHelper.unsupportedMessage(strOptString, strResolveMessageType, com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optString(jSONObject, "type"));
        }
    }

    private void handleConnectedResponseLocked(com.alibaba.fastjson.JSONObject jSONObject) {
        int iOptInt;
        com.alibaba.fastjson.JSONObject jSONObjectOptObject;
        com.alibaba.fastjson.JSONObject jSONObjectOptObject2 = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optObject(jSONObject, "resp");
        java.lang.String strResolveRequestId = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.resolveRequestId(jSONObject);
        if (jSONObjectOptObject2 != null) {
            iOptInt = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optInt(jSONObjectOptObject2, "code", -1);
        } else {
            iOptInt = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optInt(jSONObject, "code", -1);
        }
        if (iOptInt != 0) {
            if (jSONObjectOptObject2 != null) {
                jSONObject = jSONObjectOptObject2;
            }
            markFailureLocked(com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.resolveMessage(jSONObject, "connect request failed"));
            return;
        }
        if (jSONObjectOptObject2 != null) {
            jSONObjectOptObject = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optObject(jSONObjectOptObject2, "data");
        } else {
            jSONObjectOptObject = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optObject(jSONObject, "data");
        }
        long jOptLong = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optLong(jSONObjectOptObject, "server_heartbeat_interval", 0L);
        long jOptLong2 = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optLong(jSONObjectOptObject, "client_heartbeat_interval", 0L);
        java.lang.String strOptString = jSONObjectOptObject != null ? com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optString(jSONObjectOptObject, "connection_id") : null;
        if (strOptString != null && strOptString.length() > 0) {
            this.connectionId = strOptString;
        }
        this.protocolConnected = true;
        startHeartbeatTasksLocked(jOptLong, jOptLong2);
        this.latestEventSummary = "websocket connected";
        this.transportLogHelper.recvConnectedResponse(strResolveRequestId, jSONObject);
        this.transportReadyLatch.countDown();
    }

    private void handleStartResponseLocked(com.alibaba.fastjson.JSONObject jSONObject) {
        com.alibaba.fastjson.JSONObject jSONObjectOptObject = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optObject(jSONObject, "resp");
        java.lang.String strResolveRequestId = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.resolveRequestId(jSONObject);
        if (jSONObjectOptObject == null) {
            markFailureLocked("start response missing resp");
            return;
        }
        if (com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optInt(jSONObjectOptObject, "code", -1) != 0) {
            markFailureLocked(com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.resolveMessage(jSONObjectOptObject, "start request failed"));
            return;
        }
        com.alibaba.fastjson.JSONObject jSONObjectOptObject2 = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optObject(jSONObjectOptObject, "data");
        if (jSONObjectOptObject2 == null) {
            markFailureLocked("start response data missing");
            return;
        }
        java.lang.String strOptString = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optString(jSONObjectOptObject2, "audio_practice_id");
        java.lang.String strFirstNonEmpty = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.firstNonEmpty(com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optString(jSONObjectOptObject2, "session_id"), strOptString);
        if (strOptString == null) {
            markFailureLocked("start response missing audioPracticeId");
            return;
        }
        this.sessionInfo = new com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.SessionInfo(strFirstNonEmpty, strOptString);
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        if (asecSession != null) {
            asecSession.setAudioPracticeId(strOptString);
            this.activeSession.setOnlineSessionId(strFirstNonEmpty);
        }
        this.latestEventSummary = "session ready : " + strOptString;
        this.transportLogHelper.recvStartResponse(strResolveRequestId, jSONObject);
        this.sessionReadyLatch.countDown();
    }

    private void handleRestartResponseLocked(com.alibaba.fastjson.JSONObject jSONObject) {
        com.alibaba.fastjson.JSONObject jSONObjectOptObject = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optObject(jSONObject, "resp");
        java.lang.String strResolveRequestId = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.resolveRequestId(jSONObject);
        if (jSONObjectOptObject == null) {
            this.failureMessage = "re_start response missing resp";
            this.reconnectingForResume = false;
            this.transportLogHelper.recvRestartResponse(strResolveRequestId, jSONObject);
            com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
            if (asecSession != null) {
                asecSession.setOnlineMessage(this.failureMessage);
            }
            resetTransportLocked();
            finishResumeAwaitLocked();
            return;
        }
        int iOptInt = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optInt(jSONObjectOptObject, "code", -1);
        java.lang.String strResolveMessage = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.resolveMessage(jSONObjectOptObject, iOptInt == 0 ? null : "re_start request failed");
        com.alibaba.fastjson.JSONObject jSONObjectOptObject2 = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optObject(jSONObjectOptObject, "data");
        java.lang.String strOptString = jSONObjectOptObject2 != null ? com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optString(jSONObjectOptObject2, "audio_practice_id") : null;
        java.lang.String strFirstNonEmpty = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.firstNonEmpty(jSONObjectOptObject2 != null ? com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optString(jSONObjectOptObject2, "session_id") : null, strOptString);
        this.transportLogHelper.recvRestartResponse(strResolveRequestId, jSONObject);
        if (iOptInt != 0 || strOptString == null || strOptString.length() == 0) {
            java.lang.String str = strResolveMessage != null ? strResolveMessage : "re_start request failed";
            this.failureMessage = str;
            this.reconnectingForResume = false;
            com.up366.asecengine.englishengine.AsecSession asecSession2 = this.activeSession;
            if (asecSession2 != null) {
                asecSession2.setOnlineMessage(str);
            }
            resetTransportLocked();
            finishResumeAwaitLocked();
            return;
        }
        this.sessionInfo = new com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.SessionInfo(strFirstNonEmpty, strOptString);
        com.up366.asecengine.englishengine.AsecSession asecSession3 = this.activeSession;
        if (asecSession3 != null) {
            asecSession3.setAudioPracticeId(strOptString);
            this.activeSession.setOnlineSessionId(strFirstNonEmpty);
            this.activeSession.setOnlineUploadState(1);
            this.activeSession.setOnlineMessage("resume ready");
        }
        this.failureMessage = null;
        this.latestEventSummary = "session resumed : " + strOptString;
        this.resumeRequested = false;
        this.reconnectingForResume = false;
        resetAutoResumeWindowLocked();
        maybeSendOutstandingAudioLocked();
        finishResumeAwaitLocked();
    }

    private void handleControlResponseLocked(com.alibaba.fastjson.JSONObject jSONObject) {
        int iOptInt;
        com.alibaba.fastjson.JSONObject jSONObjectOptObject = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optObject(jSONObject, "resp");
        if (jSONObjectOptObject != null) {
            iOptInt = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optInt(jSONObjectOptObject, "code", -1);
        } else {
            iOptInt = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optInt(jSONObject, "code", -1);
        }
        java.lang.String strOptString = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optString(jSONObject, "type");
        boolean zEquals = NATIVE_TYPE_DISCONNECT_RESP.equals(strOptString);
        if (jSONObjectOptObject == null) {
            jSONObjectOptObject = jSONObject;
        }
        java.lang.String str = "";
        java.lang.String strResolveMessage = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.resolveMessage(jSONObjectOptObject, "");
        java.lang.StringBuilder sb = new java.lang.StringBuilder("recv control resp type=");
        sb.append(com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(strOptString));
        sb.append(" code=");
        sb.append(iOptInt);
        if (strResolveMessage != null && strResolveMessage.length() > 0) {
            str = " message=" + strResolveMessage;
        }
        sb.append(str);
        java.lang.String string = sb.toString();
        this.latestEventSummary = string;
        this.transportLogHelper.recvControlResponse(string, jSONObject);
        if (zEquals) {
            this.transportLogHelper.disconnectResponseReceived();
        }
        if (iOptInt == 0 || zEquals) {
            return;
        }
        this.realtimeUploadFailed = true;
    }

    private void handleAudioAckLocked(com.alibaba.fastjson.JSONObject jSONObject) {
        int iOptInt;
        java.lang.String strResolveRequestId = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.resolveRequestId(jSONObject);
        com.alibaba.fastjson.JSONObject jSONObjectOptObject = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optObject(jSONObject, "resp");
        int iOptInt2 = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optInt(jSONObject, "sequence", jSONObjectOptObject != null ? com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optInt(jSONObjectOptObject, "sequence", com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optInt(com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optObject(jSONObjectOptObject, "data"), "sequence", -1)) : -1);
        if (jSONObjectOptObject != null) {
            iOptInt = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optInt(jSONObjectOptObject, "code", com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optInt(jSONObject, "code", 0));
        } else {
            iOptInt = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.optInt(jSONObject, "code", 0);
        }
        if (jSONObjectOptObject == null) {
            jSONObjectOptObject = jSONObject;
        }
        java.lang.String str = "";
        java.lang.String strResolveMessage = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.resolveMessage(jSONObjectOptObject, "");
        this.transportLogHelper.recvAck(strResolveRequestId, jSONObject);
        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatchRemovePendingAudioBatchLocked = removePendingAudioBatchLocked(strResolveRequestId, iOptInt2);
        if (pendingAudioBatchRemovePendingAudioBatchLocked == null && strResolveRequestId == null && iOptInt2 < 0) {
            return;
        }
        if (pendingAudioBatchRemovePendingAudioBatchLocked != null) {
            pendingAudioBatchRemovePendingAudioBatchLocked.cancel();
            pendingAudioBatchRemovePendingAudioBatchLocked.awaitingAck = false;
            if (strResolveRequestId == null) {
                strResolveRequestId = pendingAudioBatchRemovePendingAudioBatchLocked.requestId;
            }
            if (iOptInt2 < 0) {
                iOptInt2 = pendingAudioBatchRemovePendingAudioBatchLocked.sequence;
            }
        }
        if (iOptInt != 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("audio ack failed requestId=");
            sb.append(com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(strResolveRequestId));
            sb.append(" sequence=");
            sb.append(iOptInt2);
            sb.append(" code=");
            sb.append(iOptInt);
            if (strResolveMessage != null && strResolveMessage.length() > 0) {
                str = " message=" + strResolveMessage;
            }
            sb.append(str);
            this.latestEventSummary = sb.toString();
            if (shouldPauseForResumeLocked()) {
                markResumeRequiredLocked(this.latestEventSummary);
            } else {
                this.realtimeUploadFailed = true;
                com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
                if (asecSession != null) {
                    asecSession.setOnlineMessage(this.latestEventSummary);
                }
            }
            if (this.pendingAckBatches.isEmpty()) {
                maybeStartDeferredDisconnectLocked();
                return;
            }
            return;
        }
        if (pendingAudioBatchRemovePendingAudioBatchLocked != null) {
            removeOutstandingAudioBatchLocked(pendingAudioBatchRemovePendingAudioBatchLocked.sequence);
        }
        maybeSendOutstandingAudioLocked();
        if (this.pendingAckBatches.isEmpty()) {
            maybeStartDeferredDisconnectLocked();
        }
    }

    private void handlePongLocked(com.alibaba.fastjson.JSONObject jSONObject) {
        this.latestEventSummary = "pong received";
        this.transportLogHelper.recvPong(com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.resolveRequestId(jSONObject), jSONObject);
    }

    private com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch removePendingAudioBatchLocked(java.lang.String str, int i) {
        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatchRemove;
        if (str != null && (pendingAudioBatchRemove = this.pendingAckBatches.remove(str)) != null) {
            return pendingAudioBatchRemove;
        }
        if (i < 0) {
            return null;
        }
        for (java.util.Map.Entry<java.lang.String, com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch> entry : this.pendingAckBatches.entrySet()) {
            com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch value = entry.getValue();
            if (value != null && value.sequence == i) {
                this.pendingAckBatches.remove(entry.getKey());
                return value;
            }
        }
        return null;
    }

    private void removeOutstandingAudioBatchLocked(int i) {
        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatchRemove = this.outstandingAudioBatches.remove(java.lang.Integer.valueOf(i));
        if (pendingAudioBatchRemove != null) {
            this.outstandingAudioBytes = java.lang.Math.max(0, this.outstandingAudioBytes - pendingAudioBatchRemove.frameBytes.length);
        }
    }

    private com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch buildPendingAudioBatchLocked(java.util.List<byte[]> list, long j) {
        int andIncrement = this.audioSequence.getAndIncrement();
        java.lang.String strNewRequestId = com.up366.asecengine.englishengine.v2.AsecRequestIdHelper.newRequestId();
        try {
            return new com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch(andIncrement, strNewRequestId, buildBinaryAudioPayload(this.sessionInfo, strNewRequestId, list, andIncrement, j), list.size());
        } catch (java.lang.IllegalStateException e) {
            this.transportLogHelper.error("buildBinaryAudioPayload", e);
            this.realtimeUploadFailed = true;
            this.latestEventSummary = e.getMessage();
            this.transportLogHelper.buildAudioBatchFailed(e.getMessage());
            return null;
        }
    }

    private boolean ensureResumeCacheCapacityLocked() {
        if (this.outstandingAudioBytes <= MAX_RESUME_CACHE_BYTES) {
            return true;
        }
        this.realtimeUploadFailed = true;
        this.latestEventSummary = "resume cache exceeded 67108864 bytes";
        this.transportLogHelper.resumeCacheOverflow("resume cache exceeded 67108864 bytes");
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        if (asecSession != null) {
            asecSession.setOnlineMessage(this.latestEventSummary);
        }
        resetResumeStateLocked();
        clearRealtimeAudioCacheLocked();
        return false;
    }

    private boolean canSendOutstandingAudioLocked() {
        return (this.closed || !this.protocolConnected || !this.transportConnected || this.webSocket == null || this.resumeRequested || this.reconnectingForResume) ? false : true;
    }

    private boolean hasPendingRealtimeAudioLocked() {
        return (this.pendingAckBatches.isEmpty() && this.outstandingAudioBatches.isEmpty() && this.bufferedPackets.isEmpty()) ? false : true;
    }

    private void maybeSendOutstandingAudioLocked() {
        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatchFindNextOutstandingAudioBatchLocked;
        if (canSendOutstandingAudioLocked()) {
            while (this.pendingAckBatches.size() < 8 && (pendingAudioBatchFindNextOutstandingAudioBatchLocked = findNextOutstandingAudioBatchLocked()) != null && dispatchOutstandingAudioBatchLocked(pendingAudioBatchFindNextOutstandingAudioBatchLocked)) {
            }
        }
    }

    private com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch findNextOutstandingAudioBatchLocked() {
        for (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatch : this.outstandingAudioBatches.values()) {
            if (pendingAudioBatch != null && !pendingAudioBatch.awaitingAck) {
                return pendingAudioBatch;
            }
        }
        return null;
    }

    private boolean dispatchOutstandingAudioBatchLocked(com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatch) {
        boolean z = pendingAudioBatch.sendCount > 0;
        if (!sendBinaryFrameLocked(pendingAudioBatch.frameBytes)) {
            this.latestEventSummary = "send audio batch failed";
            if (shouldPauseForResumeLocked()) {
                markResumeRequiredLocked(this.latestEventSummary);
            } else {
                this.realtimeUploadFailed = true;
            }
            return false;
        }
        pendingAudioBatch.awaitingAck = true;
        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch.access$2008(pendingAudioBatch);
        this.pendingAckBatches.put(pendingAudioBatch.requestId, pendingAudioBatch);
        if (!z) {
            this.transportLogHelper.sendAudioBatch(pendingAudioBatch.requestId, pendingAudioBatch.sequence, pendingAudioBatch.packetCount, pendingAudioBatch.frameBytes.length);
        } else {
            this.transportLogHelper.resumeAudioBatch(pendingAudioBatch.requestId, pendingAudioBatch.sequence, pendingAudioBatch.sendCount - 1);
        }
        scheduleAckTimeoutLocked(pendingAudioBatch);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldPauseForResumeLocked() {
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        return (asecSession == null || !asecSession.isOnlineScoringEnabled() || !this.activeSession.isRecord() || this.sessionInfo == null || !this.startCommandSent || this.stopCommandSent || this.disconnectRequested || this.disconnectFrameSent || this.realtimeUploadFailed) ? false : true;
    }

    private boolean isRestartAvailableLocked(java.lang.String str) {
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        return (asecSession == null || !asecSession.isOnlineScoringEnabled() || str == null || str.length() <= 0 || this.stopCommandSent) ? false : true;
    }

    private java.lang.String resolveRestartPracticeIdLocked(java.lang.String str) {
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        java.lang.String audioPracticeId = asecSession != null ? asecSession.getAudioPracticeId() : null;
        com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.SessionInfo sessionInfo = this.sessionInfo;
        return com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.firstNonEmpty(str, audioPracticeId, sessionInfo != null ? sessionInfo.practiceId : null);
    }

    private void syncActiveSessionPracticeIdLocked(java.lang.String str) {
        if (this.activeSession == null || str == null || str.length() == 0 || str.equals(this.activeSession.getAudioPracticeId())) {
            return;
        }
        this.activeSession.setAudioPracticeId(str);
    }

    private com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig resolveRestartWebSocketConfigLocked(com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfig) {
        if (asecWebSocketConfig != null) {
            return asecWebSocketConfig;
        }
        com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig asecOnlineScoringConfig = this.currentOnlineScoringConfig;
        if (asecOnlineScoringConfig != null && asecOnlineScoringConfig.getWebSocketConfig() != null) {
            return this.currentOnlineScoringConfig.getWebSocketConfig();
        }
        return this.currentWebSocketConfig;
    }

    private boolean shouldAutoResumeLocked() {
        com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy asecOnlineAutoResumePolicy;
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        return (asecSession == null || !asecSession.isOnlineScoringEnabled() || !this.activeSession.isRecord() || (asecOnlineAutoResumePolicy = this.autoResumePolicy) == null || !asecOnlineAutoResumePolicy.isEnabled() || this.autoResumeSuppressed || this.stopCommandSent || this.stopResumePending || this.disconnectRequested || this.disconnectFrameSent || this.realtimeUploadFailed) ? false : true;
    }

    private void emitPendingTransportLogs(java.util.List<java.lang.Runnable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (java.lang.Runnable runnable : list) {
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    private void maybeScheduleAutoResumeLocked() {
        maybeScheduleAutoResumeLocked(null);
    }

    private void maybeScheduleAutoResumeLocked(java.util.List<java.lang.Runnable> list) {
        if (this.resumeRequested && !this.autoResumeInFlight && this.autoResumeFuture == null && shouldAutoResumeLocked()) {
            final java.lang.String strResolveRestartPracticeIdLocked = resolveRestartPracticeIdLocked(null);
            if (!isRestartAvailableLocked(strResolveRestartPracticeIdLocked)) {
                markAutoResumeExhaustedLocked("auto resume skipped: audioPracticeId missing or session already stopping", list);
                return;
            }
            com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfigResolveRestartWebSocketConfigLocked = resolveRestartWebSocketConfigLocked(null);
            if (asecWebSocketConfigResolveRestartWebSocketConfigLocked == null || asecWebSocketConfigResolveRestartWebSocketConfigLocked.getWebSocketUrl() == null || asecWebSocketConfigResolveRestartWebSocketConfigLocked.getWebSocketUrl().trim().length() == 0) {
                markAutoResumeExhaustedLocked("auto resume skipped: websocket url is empty", list);
                return;
            }
            long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
            if (this.autoResumeStartedAtMs == 0) {
                this.autoResumeStartedAtMs = jElapsedRealtime;
            }
            if (isAutoResumeBudgetExhaustedLocked(jElapsedRealtime)) {
                markAutoResumeExhaustedLocked(buildAutoResumeExhaustedMessageLocked(jElapsedRealtime), list);
                return;
            }
            final long j = this.autoResumeGeneration;
            final int i = this.autoResumeAttemptCount + 1;
            final long jResolveAutoResumeDelayMsLocked = resolveAutoResumeDelayMsLocked(i);
            final long jMax = java.lang.Math.max(0L, jElapsedRealtime - this.autoResumeStartedAtMs);
            this.autoResumeFuture = this.autoResumeScheduler.schedule(new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.6
                @Override // java.lang.Runnable
                public void run() {
                    com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.performAutoResumeAttempt(j, i);
                }
            }, jResolveAutoResumeDelayMsLocked, java.util.concurrent.TimeUnit.MILLISECONDS);
            java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m17xf8b8904b(i, jResolveAutoResumeDelayMsLocked, jMax, strResolveRestartPracticeIdLocked);
                }
            };
            if (list != null) {
                list.add(runnable);
            } else {
                runnable.run();
            }
        }
    }

    /* JADX INFO: renamed from: lambda$maybeScheduleAutoResumeLocked$2$com-up366-asecengine-englishengine-v2-AsecOnlineScoringManager, reason: not valid java name */
    /* synthetic */ void m17xf8b8904b(int i, long j, long j2, java.lang.String str) {
        this.transportLogHelper.autoResumeScheduled(i, j, j2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performAutoResumeAttempt(long j, final int i) {
        boolean z;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this.lock) {
            com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfigResolveRestartWebSocketConfigLocked = null;
            this.autoResumeFuture = null;
            if (j == this.autoResumeGeneration && this.resumeRequested && shouldAutoResumeLocked()) {
                long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
                if (isAutoResumeBudgetExhaustedLocked(jElapsedRealtime)) {
                    markAutoResumeExhaustedLocked(buildAutoResumeExhaustedMessageLocked(jElapsedRealtime), arrayList);
                    z = true;
                } else {
                    z = false;
                }
                final java.lang.String strResolveRestartPracticeIdLocked = !z ? resolveRestartPracticeIdLocked(null) : null;
                if (!z && !isRestartAvailableLocked(strResolveRestartPracticeIdLocked)) {
                    markAutoResumeExhaustedLocked("auto resume skipped: audioPracticeId missing or session already stopping", arrayList);
                    z = true;
                }
                if (!z) {
                    asecWebSocketConfigResolveRestartWebSocketConfigLocked = resolveRestartWebSocketConfigLocked(null);
                }
                if (!z && (asecWebSocketConfigResolveRestartWebSocketConfigLocked == null || asecWebSocketConfigResolveRestartWebSocketConfigLocked.getWebSocketUrl() == null || asecWebSocketConfigResolveRestartWebSocketConfigLocked.getWebSocketUrl().trim().length() == 0)) {
                    markAutoResumeExhaustedLocked("auto resume skipped: websocket url is empty", arrayList);
                    z = true;
                }
                if (!z) {
                    this.autoResumeInFlight = true;
                    this.autoResumeAttemptCount = i;
                    arrayList.add(new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager$$ExternalSyntheticLambda14
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m19x6507e985(i, strResolveRestartPracticeIdLocked);
                        }
                    });
                }
                emitPendingTransportLogs(arrayList);
                if (z) {
                    return;
                }
                final boolean zRestart = restart(asecWebSocketConfigResolveRestartWebSocketConfigLocked, strResolveRestartPracticeIdLocked);
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                synchronized (this.lock) {
                    if (j != this.autoResumeGeneration) {
                        this.autoResumeInFlight = false;
                    } else {
                        this.autoResumeInFlight = false;
                        final java.lang.String strLatestOrFailureMessageLocked = latestOrFailureMessageLocked();
                        if (this.stopResumePending) {
                            arrayList2.add(new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager$$ExternalSyntheticLambda15
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.m20xe368ed64(i, zRestart, strLatestOrFailureMessageLocked);
                                }
                            });
                            if (!zRestart) {
                                this.realtimeUploadFailed = true;
                                emitStopFallbackLocked(buildStopFallbackReasonLocked(), arrayList2);
                            } else if (!sendStopFrameLocked(false)) {
                                this.latestEventSummary = "stop command send failed";
                                this.realtimeUploadFailed = true;
                                emitStopFallbackLocked(buildStopFallbackReasonLocked(), arrayList2);
                            } else {
                                resetAutoResumeWindowLocked();
                                this.stopResumePending = false;
                                scheduleStopEvaluateLocked();
                            }
                        } else if (zRestart) {
                            arrayList2.add(new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager$$ExternalSyntheticLambda5
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.m21x61c9f143(i, strLatestOrFailureMessageLocked);
                                }
                            });
                            resetAutoResumeWindowLocked();
                        } else {
                            long jElapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
                            if (isAutoResumeBudgetExhaustedLocked(jElapsedRealtime2)) {
                                arrayList2.add(new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager$$ExternalSyntheticLambda6
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.m22xe02af522(i, strLatestOrFailureMessageLocked);
                                    }
                                });
                                markAutoResumeExhaustedLocked(buildAutoResumeExhaustedMessageLocked(jElapsedRealtime2), arrayList2);
                            } else {
                                arrayList2.add(new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager$$ExternalSyntheticLambda7
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f$0.m23x5e8bf901(i, strLatestOrFailureMessageLocked);
                                    }
                                });
                                maybeScheduleAutoResumeLocked(arrayList2);
                            }
                        }
                    }
                }
                emitPendingTransportLogs(arrayList2);
            }
        }
    }

    /* JADX INFO: renamed from: lambda$performAutoResumeAttempt$3$com-up366-asecengine-englishengine-v2-AsecOnlineScoringManager, reason: not valid java name */
    /* synthetic */ void m19x6507e985(int i, java.lang.String str) {
        this.transportLogHelper.autoResumeAttemptStarted(i, str);
    }

    /* JADX INFO: renamed from: lambda$performAutoResumeAttempt$4$com-up366-asecengine-englishengine-v2-AsecOnlineScoringManager, reason: not valid java name */
    /* synthetic */ void m20xe368ed64(int i, boolean z, java.lang.String str) {
        this.transportLogHelper.autoResumeAttemptFinished(i, z, false, str);
    }

    /* JADX INFO: renamed from: lambda$performAutoResumeAttempt$5$com-up366-asecengine-englishengine-v2-AsecOnlineScoringManager, reason: not valid java name */
    /* synthetic */ void m21x61c9f143(int i, java.lang.String str) {
        this.transportLogHelper.autoResumeAttemptFinished(i, true, false, str);
    }

    /* JADX INFO: renamed from: lambda$performAutoResumeAttempt$6$com-up366-asecengine-englishengine-v2-AsecOnlineScoringManager, reason: not valid java name */
    /* synthetic */ void m22xe02af522(int i, java.lang.String str) {
        this.transportLogHelper.autoResumeAttemptFinished(i, false, false, str);
    }

    /* JADX INFO: renamed from: lambda$performAutoResumeAttempt$7$com-up366-asecengine-englishengine-v2-AsecOnlineScoringManager, reason: not valid java name */
    /* synthetic */ void m23x5e8bf901(int i, java.lang.String str) {
        this.transportLogHelper.autoResumeAttemptFinished(i, false, true, str);
    }

    private long resolveAutoResumeDelayMsLocked(int i) {
        com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy asecOnlineAutoResumePolicy = this.autoResumePolicy;
        long[] retryBackoffMs = asecOnlineAutoResumePolicy != null ? asecOnlineAutoResumePolicy.getRetryBackoffMs() : null;
        if (retryBackoffMs == null || retryBackoffMs.length == 0) {
            return 0L;
        }
        return java.lang.Math.max(0L, retryBackoffMs[java.lang.Math.max(0, java.lang.Math.min(i - 1, retryBackoffMs.length - 1))]);
    }

    private boolean isAutoResumeBudgetExhaustedLocked(long j) {
        com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy asecOnlineAutoResumePolicy = this.autoResumePolicy;
        if (asecOnlineAutoResumePolicy == null || this.autoResumeAttemptCount >= asecOnlineAutoResumePolicy.getMaxAttempts()) {
            return true;
        }
        long maxDurationMs = this.autoResumePolicy.getMaxDurationMs();
        if (maxDurationMs > 0) {
            long j2 = this.autoResumeStartedAtMs;
            if (j2 > 0 && j - j2 >= maxDurationMs) {
                return true;
            }
        }
        return false;
    }

    private java.lang.String buildAutoResumeExhaustedMessageLocked(long j) {
        com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy asecOnlineAutoResumePolicy = this.autoResumePolicy;
        if (asecOnlineAutoResumePolicy != null && this.autoResumeAttemptCount >= asecOnlineAutoResumePolicy.getMaxAttempts()) {
            return "auto resume exhausted: attemptCount=" + this.autoResumeAttemptCount;
        }
        long j2 = this.autoResumeStartedAtMs;
        return "auto resume exhausted: durationMs=" + (j2 > 0 ? java.lang.Math.max(0L, j - j2) : 0L);
    }

    private void markAutoResumeExhaustedLocked(java.lang.String str) {
        markAutoResumeExhaustedLocked(str, null);
    }

    private void markAutoResumeExhaustedLocked(final java.lang.String str, java.util.List<java.lang.Runnable> list) {
        this.autoResumeSuppressed = true;
        this.latestEventSummary = str;
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        if (asecSession != null) {
            asecSession.setOnlineMessage(str);
        }
        final long jMax = this.autoResumeStartedAtMs > 0 ? java.lang.Math.max(0L, android.os.SystemClock.elapsedRealtime() - this.autoResumeStartedAtMs) : 0L;
        java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m16x9eab3f40(jMax, str);
            }
        };
        if (list != null) {
            list.add(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: renamed from: lambda$markAutoResumeExhaustedLocked$8$com-up366-asecengine-englishengine-v2-AsecOnlineScoringManager, reason: not valid java name */
    /* synthetic */ void m16x9eab3f40(long j, java.lang.String str) {
        this.transportLogHelper.autoResumeExhausted(this.autoResumeAttemptCount, j, str);
    }

    private void suppressAutoResumeLocked(java.lang.String str) {
        suppressAutoResumeLocked(str, null);
    }

    private void suppressAutoResumeLocked(final java.lang.String str, java.util.List<java.lang.Runnable> list) {
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.autoResumeFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.autoResumeFuture = null;
        }
        if (!this.autoResumeSuppressed || this.autoResumeInFlight) {
            final boolean z = this.autoResumeInFlight;
            java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m25x60678b74(str, z);
                }
            };
            if (list != null) {
                list.add(runnable);
            } else {
                runnable.run();
            }
        }
        this.autoResumeSuppressed = true;
    }

    /* JADX INFO: renamed from: lambda$suppressAutoResumeLocked$9$com-up366-asecengine-englishengine-v2-AsecOnlineScoringManager, reason: not valid java name */
    /* synthetic */ void m25x60678b74(java.lang.String str, boolean z) {
        this.transportLogHelper.autoResumeCanceled(str, z);
    }

    private void resetAutoResumeWindowLocked() {
        java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.autoResumeFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.autoResumeFuture = null;
        }
        this.autoResumeAttemptCount = 0;
        this.autoResumeStartedAtMs = 0L;
        this.autoResumeInFlight = false;
        this.autoResumeSuppressed = false;
        this.autoResumeGeneration++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markResumeRequiredLocked(java.lang.String str) {
        boolean z = !this.resumeRequested;
        if (str == null || str.length() <= 0) {
            str = "websocket disconnected, call connectWebSocket to resume";
        }
        this.latestEventSummary = str;
        this.failureMessage = null;
        this.resumeRequested = true;
        this.reconnectingForResume = false;
        pauseOutstandingAudioLocked();
        resetTransportLocked();
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        if (asecSession != null) {
            asecSession.setOnlineUploadState(2);
            this.activeSession.setOnlineMessage(this.latestEventSummary);
            if (z) {
                this.activeSession.onRecordStateChange(9);
            }
        }
        this.transportLogHelper.resumeRequired(this.latestEventSummary, this.outstandingAudioBatches.size(), this.outstandingAudioBytes);
        maybeScheduleAutoResumeLocked();
        finishResumeAwaitLocked();
    }

    private void pauseOutstandingAudioLocked() {
        for (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatch : this.pendingAckBatches.values()) {
            if (pendingAudioBatch != null) {
                pendingAudioBatch.cancel();
                pendingAudioBatch.awaitingAck = false;
            }
        }
        this.pendingAckBatches.clear();
    }

    private void clearRealtimeAudioCacheLocked() {
        for (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatch : this.pendingAckBatches.values()) {
            if (pendingAudioBatch != null) {
                pendingAudioBatch.cancel();
            }
        }
        for (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatch2 : this.outstandingAudioBatches.values()) {
            if (pendingAudioBatch2 != null) {
                pendingAudioBatch2.cancel();
            }
        }
        this.pendingAckBatches.clear();
        this.outstandingAudioBatches.clear();
        this.outstandingAudioBytes = 0;
        this.bufferedPackets.clear();
        this.bufferedPacketsTimestampMs = 0L;
    }

    private void resetResumeStateLocked() {
        this.resumeRequested = false;
        this.reconnectingForResume = false;
        finishResumeAwaitLocked();
    }

    private void finishResumeAwaitLocked() {
        this.resumeReadyLatch.countDown();
        this.resumeReadyLatch = new java.util.concurrent.CountDownLatch(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markFailureLocked(java.lang.String str) {
        if (this.failureMessage == null) {
            this.failureMessage = str;
        }
        this.transportLogHelper.failure(str);
        this.realtimeUploadFailed = this.startCommandSent;
        this.reconnectingForResume = false;
        com.up366.asecengine.englishengine.AsecSession asecSession = this.activeSession;
        if (asecSession != null) {
            asecSession.setOnlineMessage(str);
        }
        this.transportReadyLatch.countDown();
        this.sessionReadyLatch.countDown();
        finishResumeAwaitLocked();
        if (this.disconnectRequested || this.disconnectFrameSent) {
            disconnectLocked(true);
        }
    }

    private final class SocketListener extends okhttp3.WebSocketListener {
        private SocketListener() {
        }

        public void onOpen(okhttp3.WebSocket webSocket, okhttp3.Response response) {
            synchronized (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.lock) {
                com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.transportConnected = true;
                com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.transportLogHelper.websocketOpen(response != null ? response.code() : -1);
            }
        }

        public void onMessage(okhttp3.WebSocket webSocket, java.lang.String str) {
            com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.handleIncomingText(str);
        }

        public void onMessage(okhttp3.WebSocket webSocket, okio.ByteString byteString) {
            synchronized (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.lock) {
                com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.transportLogHelper.warn("unexpected binary message size=" + byteString.size());
                com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.transportLogHelper.recvBinaryFrame(byteString.size());
            }
        }

        public void onClosing(okhttp3.WebSocket webSocket, int i, java.lang.String str) {
            synchronized (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.lock) {
                com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.transportConnected = false;
                com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.protocolConnected = false;
                if (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.closed) {
                    com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.transportLogHelper.websocketClosing(i, str);
                    return;
                }
                java.lang.String str2 = "websocket closing : " + i + " - " + str;
                if (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.shouldPauseForResumeLocked()) {
                    com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.markResumeRequiredLocked(str2);
                } else {
                    com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.markFailureLocked(str2);
                }
            }
        }

        public void onClosed(okhttp3.WebSocket webSocket, int i, java.lang.String str) {
            synchronized (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.lock) {
                com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.transportConnected = false;
                com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.protocolConnected = false;
                if (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.closed) {
                    com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.transportLogHelper.websocketClosed(i, str);
                    return;
                }
                java.lang.String str2 = "websocket closed : " + i + " - " + str;
                if (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.shouldPauseForResumeLocked()) {
                    com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.markResumeRequiredLocked(str2);
                } else {
                    com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.markFailureLocked(str2);
                }
            }
        }

        public void onFailure(okhttp3.WebSocket webSocket, java.lang.Throwable th, okhttp3.Response response) {
            synchronized (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.lock) {
                com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.transportConnected = false;
                com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.protocolConnected = false;
                com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.transportLogHelper.error("websocket failure", th);
                if (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.closed) {
                    com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.transportLogHelper.websocketFailureAfterClose(th != null ? th.getMessage() : null);
                    return;
                }
                java.lang.String message = th != null ? th.getMessage() : null;
                if (com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.shouldPauseForResumeLocked()) {
                    com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.markResumeRequiredLocked(message);
                } else {
                    com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.this.markFailureLocked(message);
                }
            }
        }
    }

    private static final class SessionInfo {
        private final java.lang.String practiceId;
        private final java.lang.String sessionId;

        private SessionInfo(java.lang.String str, java.lang.String str2) {
            this.sessionId = str;
            this.practiceId = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class PendingAudioBatch {
        private boolean awaitingAck;
        private final byte[] frameBytes;
        private java.util.concurrent.ScheduledFuture<?> future;
        private final int packetCount;
        private final java.lang.String requestId;
        private int retryCount;
        private int sendCount;
        private final int sequence;

        static /* synthetic */ int access$1908(com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatch) {
            int i = pendingAudioBatch.retryCount;
            pendingAudioBatch.retryCount = i + 1;
            return i;
        }

        static /* synthetic */ int access$2008(com.up366.asecengine.englishengine.v2.AsecOnlineScoringManager.PendingAudioBatch pendingAudioBatch) {
            int i = pendingAudioBatch.sendCount;
            pendingAudioBatch.sendCount = i + 1;
            return i;
        }

        private PendingAudioBatch(int i, java.lang.String str, byte[] bArr, int i2) {
            this.sequence = i;
            this.requestId = str;
            this.frameBytes = bArr;
            this.packetCount = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cancel() {
            java.util.concurrent.ScheduledFuture<?> scheduledFuture = this.future;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                this.future = null;
            }
        }
    }
}
