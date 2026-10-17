package com.up366.asecengine.englishengine.v2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
final class AsecOnlineTransportLogHelper {
    private final com.up366.asecengine.englishengine.v2.AsecOnlineTransportLogHelper.ConnectionIdProvider connectionIdProvider;
    private volatile com.up366.asecengine.englishengine.v2.AsecOnlineTransportLogHelper.LogListener logListener;
    private final java.lang.String tag;

    interface ConnectionIdProvider {
        java.lang.String getConnectionId();
    }

    interface LogListener {
        void onLog(java.lang.String str);
    }

    AsecOnlineTransportLogHelper(java.lang.String str, com.up366.asecengine.englishengine.v2.AsecOnlineTransportLogHelper.ConnectionIdProvider connectionIdProvider) {
        this.tag = str;
        this.connectionIdProvider = connectionIdProvider;
    }

    void setLogListener(com.up366.asecengine.englishengine.v2.AsecOnlineTransportLogHelper.LogListener logListener) {
        this.logListener = logListener;
    }

    void connectSkippedWebSocketUrlEmpty() {
        log("connect skipped: websocket url is empty");
    }

    void connectWebSocket(java.lang.String str) {
        log("connect websocket : " + str);
    }

    void connectRequest(java.lang.String str, java.lang.String str2) {
        log("connect request requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " url=" + str2);
    }

    void connectTimeout(long j) {
        log("connect timeout timeoutMs=" + j);
    }

    void transportReady(boolean z) {
        log("transport ready protocolConnected=" + z);
    }

    void awaitTransportInterrupted(java.lang.String str) {
        log("await transport interrupted: " + str);
    }

    void startSessionFailed(java.lang.String str) {
        log("startSession failed: " + str);
    }

    void sessionReady(java.lang.String str, java.lang.String str2) {
        log("session ready sessionId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " audioPracticeId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str2));
    }

    void resumeRequired(java.lang.String str, int i, int i2) {
        log("resume required: " + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " backlogBatchCount=" + i + " backlogBytes=" + i2);
    }

    void autoResumeScheduled(int i, long j, long j2, java.lang.String str) {
        log("auto resume scheduled attempt=" + i + " delayMs=" + j + " elapsedMs=" + j2 + " audioPracticeId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str));
    }

    void autoResumeAttemptStarted(int i, java.lang.String str) {
        log("auto resume started attempt=" + i + " audioPracticeId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str));
    }

    void autoResumeAttemptFinished(int i, boolean z, boolean z2, java.lang.String str) {
        log("auto resume finished attempt=" + i + " resumed=" + z + " willRetry=" + z2 + " message=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str));
    }

    void autoResumeExhausted(int i, long j, java.lang.String str) {
        log("auto resume exhausted attemptCount=" + i + " elapsedMs=" + j + " message=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str));
    }

    void autoResumeCanceled(java.lang.String str, boolean z) {
        log("auto resume canceled reason=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " inFlight=" + z);
    }

    void resumeFailed(java.lang.String str) {
        log("resume failed: " + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str));
    }

    void startSessionInterrupted(java.lang.String str) {
        log("startSession interrupted: " + str);
    }

    void heartbeatNegotiated(long j, long j2) {
        log("heartbeat negotiated outgoingMs=" + j + " incomingMs=" + j2);
    }

    void outgoingHeartbeatStopSkipped(java.lang.String str) {
        log("stop outgoing heartbeat skipped reason=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str));
    }

    void outgoingHeartbeatStopped(long j) {
        log("outgoing heartbeat stopped previousIntervalMs=" + j);
    }

    void connectRequestedAfterDisconnectSent() {
        log("connect requested after disconnect sent: reopen transport");
    }

    void disconnectCanceledConnectRequestedBeforeSend() {
        log("disconnect canceled reason=connect requested before disconnect sent");
    }

    void disconnectAlreadySent(java.lang.String str) {
        log("disconnect already sent reason=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str));
    }

    void disconnectAlreadyPending(java.lang.String str) {
        log("disconnect already pending reason=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str));
    }

    void disconnectRequested(java.lang.String str, boolean z, boolean z2, int i) {
        log("disconnect requested reason=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " activeSession=" + z + " stopPending=" + z2 + " pendingAckCount=" + i);
    }

    void disconnectWaiting(boolean z, boolean z2, int i) {
        log("disconnect waiting activeSession=" + z + " stopPending=" + z2 + " pendingAckCount=" + i);
    }

    void disconnectFinalizeWithoutControlFrame(java.lang.String str) {
        log("disconnect finalize without control frame connectionId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str));
    }

    void disconnectControlFrameSendFailedCloseImmediately() {
        log("disconnect control frame send failed, close immediately");
    }

    void disconnectCloseScheduled(long j) {
        log("disconnect close scheduled timeoutMs=" + j);
    }

    void disconnectCloseExecutingAfterWait() {
        log("disconnect close executing after wait");
    }

    void sendPing(java.lang.String str, long j) {
        log("send ping requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " timestampMs=" + j);
    }

    void incomingHeartbeatTimeout(long j) {
        log("incoming heartbeat timeout idleMs=" + j);
    }

    void sendStart(java.lang.String str, java.lang.String str2) {
        emitTextBody("send start requestId=" + str, str2);
    }

    void sendStop(java.lang.String str, java.lang.String str2) {
        emitTextBody("send stop requestId=" + str, str2);
    }

    void sendRestart(java.lang.String str, java.lang.String str2) {
        emitTextBody("send re_start requestId=" + str, str2);
    }

    void sendDisconnectSkippedConnectionIdEmpty() {
        log("send disconnect skipped: connectionId is empty");
    }

    void sendDisconnectSkippedTransportNotReady() {
        log("send disconnect skipped: transport not ready");
    }

    void sendDisconnect(java.lang.String str, java.lang.String str2) {
        emitTextBody("send disconnect requestId=" + str, str2);
    }

    void sendUploadAudioUrl(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        emitTextBody("send " + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " requestId=" + str2, str3);
    }

    void buildAudioBatchFailed(java.lang.String str) {
        log("build audio batch failed: " + str);
    }

    void sendAudioBatch(java.lang.String str, int i, int i2, int i3) {
        log("send audio batch requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " sequence=" + i + " packetCount=" + i2 + " payloadBytes=" + i3);
    }

    void bufferAudioBatchForResume(java.lang.String str, int i, int i2, int i3, int i4) {
        log("buffer audio batch requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " sequence=" + i + " packetCount=" + i2 + " payloadBytes=" + i3 + " backlogBytes=" + i4);
    }

    void resumeAudioBatch(java.lang.String str, int i, int i2) {
        log("resume audio batch requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " sequence=" + i + " resendCount=" + i2);
    }

    void resumeCacheOverflow(java.lang.String str) {
        log("resume cache overflow: " + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str));
    }

    void ackTimeoutFailed(java.lang.String str, int i, int i2) {
        log("ack timeout failed requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " sequence=" + i + " retryCount=" + i2);
    }

    void ackTimeoutRetry(java.lang.String str, int i, int i2) {
        log("ack timeout retry requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " sequence=" + i + " retryCount=" + i2);
    }

    void resendAudioBatch(java.lang.String str, int i, int i2) {
        log("resend audio batch requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " sequence=" + i + " retryCount=" + i2);
    }

    void resendAudioBatchFailed(java.lang.String str, int i, int i2) {
        log("resend audio batch failed requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " sequence=" + i + " retryCount=" + i2);
    }

    void sendTextFrameSkippedWebSocketNull() {
        log("send text frame skipped: websocket is null");
    }

    void sendTextFrameFailed() {
        log("send text frame failed");
    }

    void sendBinarySkippedWebSocketNull() {
        log("send binary skipped: websocket is null");
    }

    void sendBinaryFailed(int i) {
        log("send binary failed bytes=" + i);
    }

    void recvTextFrame(java.lang.String str) {
        emitTextBody("recv text frame", str);
    }

    void scoreResult(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) {
        emitJsonBody("score result requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str), jSONObject);
    }

    void unsupportedMessage(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        log("recv unsupported message command=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str) + " type=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str2) + " rawType=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str3));
    }

    void recvConnectedResponse(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) {
        emitJsonBody("recv connected_resp requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str), jSONObject);
    }

    void recvStartResponse(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) {
        emitJsonBody("recv start_resp requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str), jSONObject);
    }

    void recvRestartResponse(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) {
        emitJsonBody("recv re_start_resp requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str), jSONObject);
    }

    void recvBinaryFrame(int i) {
        log("recv binary frame bytes=" + i);
    }

    void recvControlResponse(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) {
        emitJsonBody(str, jSONObject);
    }

    void disconnectResponseReceived() {
        log("disconnect response received");
    }

    void recvAck(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) {
        emitJsonBody("recv ack requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str), jSONObject);
    }

    void recvPong(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) {
        emitJsonBody("recv pong requestId=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str), jSONObject);
    }

    void failure(java.lang.String str) {
        log("failure=" + str);
    }

    void websocketOpen(int i) {
        log("websocket open code=" + i);
    }

    void websocketClosing(int i, java.lang.String str) {
        log("websocket closing code=" + i + " reason=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str));
    }

    void websocketClosed(int i, java.lang.String str) {
        log("websocket closed code=" + i + " reason=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str));
    }

    void websocketFailureAfterClose(java.lang.String str) {
        log("websocket failure after close message=" + com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(str));
    }

    void warn(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        java.lang.String message = formatMessage(str);
        com.up366.common.log.Logger.warn(message);
        notifyLogListener(message);
    }

    void error(java.lang.String str, java.lang.Throwable th) {
        if (str == null || str.length() == 0) {
            return;
        }
        java.lang.String message = formatMessage(str);
        com.up366.common.log.Logger.error(message, th);
        notifyLogListener(message);
    }

    private void log(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        java.lang.String message = formatMessage(str);
        com.up366.common.log.Logger.info(message);
        notifyLogListener(message);
    }

    private void emitTextBody(java.lang.String str, java.lang.String str2) {
        log(str + " body=" + str2);
    }

    private void emitJsonBody(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) {
        emitTextBody(str, jSONObject != null ? jSONObject.toString() : null);
    }

    private java.lang.String formatMessage(java.lang.String str) {
        return this.tag + " - connectionId=" + resolveConnectionId() + " - " + str;
    }

    private java.lang.String resolveConnectionId() {
        com.up366.asecengine.englishengine.v2.AsecOnlineTransportLogHelper.ConnectionIdProvider connectionIdProvider = this.connectionIdProvider;
        if (connectionIdProvider != null) {
            return com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.valueOrDash(connectionIdProvider.getConnectionId());
        }
        return "-";
    }

    private void notifyLogListener(java.lang.String str) {
        com.up366.asecengine.englishengine.v2.AsecOnlineTransportLogHelper.LogListener logListener = this.logListener;
        if (logListener != null) {
            logListener.onLog(str);
        }
    }
}
