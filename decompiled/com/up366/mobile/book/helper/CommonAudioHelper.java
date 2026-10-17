package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CommonAudioHelper {
    private static android.os.Handler audioHandler;
    private static com.up366.common.task.TaskExecutor audioStateExecutor;
    private final android.app.Activity activity;
    private com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder commonAudioHolder;
    private com.google.android.exoplayer2.source.DefaultMediaSourceFactory defaultMediaSourceFactory;
    private com.google.android.exoplayer2.source.DefaultMediaSourceFactory httpMediaSourceFactory;
    private final java.util.List<com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder> players = new java.util.ArrayList();

    public static class AudioInfo {
        public long size;
        public long time;
    }

    interface RunnableWithThrowable {
        void run() throws java.lang.Exception;
    }

    public CommonAudioHelper(final androidx.appcompat.app.AppCompatActivity appCompatActivity) {
        if (audioHandler == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("audioHandlerThread");
            handlerThread.start();
            audioHandler = new android.os.Handler(handlerThread.getLooper());
            audioStateExecutor = com.up366.common.task.TaskUtils.createSerialExecutor("audio-state");
        }
        this.activity = appCompatActivity;
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda16
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$new$0(appCompatActivity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(androidx.appcompat.app.AppCompatActivity appCompatActivity) throws java.lang.Exception {
        com.google.android.exoplayer2.upstream.DefaultHttpDataSource.Factory allowCrossProtocolRedirects = new com.google.android.exoplayer2.upstream.DefaultHttpDataSource.Factory().setAllowCrossProtocolRedirects(true);
        com.google.android.exoplayer2.extractor.DefaultExtractorsFactory constantBitrateSeekingEnabled = new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory().setMp3ExtractorFlags(12).setConstantBitrateSeekingEnabled(true);
        com.google.android.exoplayer2.extractor.DefaultExtractorsFactory constantBitrateSeekingEnabled2 = new com.google.android.exoplayer2.extractor.DefaultExtractorsFactory().setConstantBitrateSeekingEnabled(true);
        com.google.android.exoplayer2.upstream.DefaultDataSource.Factory factory = new com.google.android.exoplayer2.upstream.DefaultDataSource.Factory(appCompatActivity, allowCrossProtocolRedirects);
        this.httpMediaSourceFactory = new com.google.android.exoplayer2.source.DefaultMediaSourceFactory(factory, constantBitrateSeekingEnabled2);
        this.defaultMediaSourceFactory = new com.google.android.exoplayer2.source.DefaultMediaSourceFactory(factory, constantBitrateSeekingEnabled);
    }

    public static void test() {
        com.up366.mobile.book.helper.CommonAudioHelper commonAudioHelper = new com.up366.mobile.book.helper.CommonAudioHelper(com.up366.common.global.GB.get().getCurrentActivity());
        com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder();
        audioHolder.audioId = "audioId";
        audioHolder.isFFT = true;
        audioHolder.isWAV = true;
        audioHolder.uri = new java.io.File(".").toURI().toString();
        audioHolder.callBack = new com.up366.mobile.book.helper.ICommonAudioCallBack() { // from class: com.up366.mobile.book.helper.CommonAudioHelper.1
            @Override // com.up366.mobile.book.helper.ICommonAudioCallBack
            public void onMediaStateResult(java.lang.String str, int i, int i2) {
            }

            @Override // com.up366.mobile.book.helper.ICommonAudioCallBack
            public void onWavUpdate(java.lang.String str, byte[] bArr) {
            }
        };
        commonAudioHelper.play(audioHolder);
        commonAudioHelper.seek("audioId", 1000L);
        commonAudioHelper.setVolume("audioId", 1.0f);
        commonAudioHelper.setRate("audioId", 1.0f);
        commonAudioHelper.pause("audioId");
        commonAudioHelper.resume("audioId");
        commonAudioHelper.stop("audioId");
        commonAudioHelper.getDuration("audioId");
        commonAudioHelper.getCurrentTime("audioId");
        commonAudioHelper.pauseAll();
        commonAudioHelper.release();
    }

    public void release() {
        com.up366.common.log.Logger.info("TAG - CommonAudioHelper - release ");
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda14
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$release$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$1() throws java.lang.Exception {
        for (com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder : this.players) {
            if (playerHolder.holder != null) {
                onAudioStateChange(playerHolder.holder, 4, 2);
            }
            if (playerHolder.player != null) {
                if (playerHolder.listener != null) {
                    playerHolder.player.removeListener(playerHolder.listener);
                    playerHolder.listener = null;
                }
                playerHolder.player.release();
            }
            playerHolder.player = null;
            playerHolder.holder = null;
        }
        clearPlayers();
        com.up366.common.log.Logger.debug("TAG - CommonAudioHelper - release over!");
    }

    public void pauseAll() {
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda12
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$pauseAll$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pauseAll$2() throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - CommonAudioHelper - pauseAll ");
        for (com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder : this.players) {
            if (playerHolder.player != null && playerHolder.player.isPlaying()) {
                playerHolder.pauseExState = 1;
                playerHolder.player.pause();
            }
        }
    }

    public int getCurrentTime(final java.lang.String str) {
        android.os.SystemClock.uptimeMillis();
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final long[] jArr = {0};
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda15
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getCurrentTime$3(str, jArr, countDownLatch);
            }
        });
        try {
            countDownLatch.await(1L, java.util.concurrent.TimeUnit.SECONDS);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
        return (int) jArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getCurrentTime$3(java.lang.String str, long[] jArr, java.util.concurrent.CountDownLatch countDownLatch) throws java.lang.Exception {
        com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder = getPlayerHolder(str);
        if (playerHolder == null) {
            com.up366.common.log.Logger.warn("TAG - CommonAudioHelper - getCurrentPlayTime - player not found!");
        } else {
            jArr[0] = playerHolder.player.getCurrentPosition();
        }
        countDownLatch.countDown();
    }

    public int getDuration(final java.lang.String str) {
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final java.util.concurrent.atomic.AtomicLong atomicLong = new java.util.concurrent.atomic.AtomicLong(-9223372036854775807L);
        final java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDuration$5(str, atomicLong);
            }
        };
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda20
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.book.helper.CommonAudioHelper.lambda$getDuration$6(runnable, atomicLong, countDownLatch);
            }
        });
        try {
            countDownLatch.await(3L, java.util.concurrent.TimeUnit.SECONDS);
        } catch (java.lang.InterruptedException unused) {
        }
        if (atomicLong.get() == -9223372036854775807L) {
            final java.util.concurrent.CountDownLatch countDownLatch2 = new java.util.concurrent.CountDownLatch(1);
            runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda21
                @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$getDuration$7(str, atomicLong, countDownLatch2);
                }
            });
            try {
                countDownLatch2.await(3L, java.util.concurrent.TimeUnit.SECONDS);
            } catch (java.lang.InterruptedException unused2) {
            }
        }
        com.up366.common.log.Logger.info("TAG - CommonAudioHelper - getDuration - duration : " + atomicLong.get() + " usedTime:" + (android.os.SystemClock.uptimeMillis() - jUptimeMillis));
        return (int) atomicLong.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDuration$5(final java.lang.String str, final java.util.concurrent.atomic.AtomicLong atomicLong) {
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda9
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getDuration$4(str, atomicLong, countDownLatch);
            }
        });
        try {
            countDownLatch.await(100L, java.util.concurrent.TimeUnit.MILLISECONDS);
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDuration$4(java.lang.String str, java.util.concurrent.atomic.AtomicLong atomicLong, java.util.concurrent.CountDownLatch countDownLatch) throws java.lang.Exception {
        com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder = getPlayerHolder(str);
        if (playerHolder == null) {
            com.up366.common.log.Logger.warn("TAG - CommonAudioHelper - getDuration - player not found!");
            atomicLong.set(0L);
            countDownLatch.countDown();
        } else if (playerHolder.player.getPlaybackState() != 3) {
            countDownLatch.countDown();
        } else {
            atomicLong.set(playerHolder.player.getDuration());
            countDownLatch.countDown();
        }
    }

    static /* synthetic */ void lambda$getDuration$6(java.lang.Runnable runnable, java.util.concurrent.atomic.AtomicLong atomicLong, java.util.concurrent.CountDownLatch countDownLatch) throws java.lang.Exception {
        for (int i = 0; i < 30; i++) {
            runnable.run();
            if (atomicLong.get() != -9223372036854775807L) {
                break;
            }
            java.lang.Thread.sleep(50L);
        }
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDuration$7(java.lang.String str, java.util.concurrent.atomic.AtomicLong atomicLong, java.util.concurrent.CountDownLatch countDownLatch) throws java.lang.Exception {
        com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder = getPlayerHolder(str);
        if (playerHolder == null) {
            com.up366.common.log.Logger.warn("TAG - CommonAudioHelper - getDuration - player not found!");
            atomicLong.set(0L);
        } else if (playerHolder.holder.uri.startsWith("file")) {
            atomicLong.set(getMetaDuration(playerHolder.holder.uri));
        } else {
            atomicLong.set(0L);
        }
        countDownLatch.countDown();
    }

    public int waitDuration(java.lang.String str) {
        return getDuration(str);
    }

    private long getMetaDuration(java.lang.String str) {
        try {
            if (!com.up366.common.FileUtilsUp.isFileExists(java.net.URI.create(str).getPath())) {
                return 0L;
            }
            android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(java.net.URI.create(str).getPath());
            java.lang.String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            mediaMetadataRetriever.release();
            if (strExtractMetadata == null) {
                return 1L;
            }
            com.up366.common.log.Logger.info("TAG - CommonAudioHelper - getMetaDuration - path = [" + str + "] duration:" + strExtractMetadata);
            return java.lang.Long.parseLong(strExtractMetadata);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - CommonAudioHelper - getMetaDuration - " + e.getMessage());
            return 1L;
        }
    }

    public void stop(final java.lang.String str) {
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda17
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$stop$8(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$8(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder = getPlayerHolder(str);
        if (playerHolder == null) {
            com.up366.common.log.Logger.warn("TAG - CommonAudioHelper - stop - player not found!");
        } else {
            onAudioStateChange(playerHolder.holder, 4);
            stopCleanAudio(playerHolder);
        }
    }

    private void stopCleanAudio(com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder, boolean z) {
        if (playerHolder.listener != null) {
            playerHolder.player.removeListener(playerHolder.listener);
            playerHolder.listener = null;
        }
        if (playerHolder.player != null) {
            playerHolder.player.stop();
            if (z) {
                playerHolder.player.release();
            }
        }
        playerHolder.guid = null;
        playerHolder.audioId = null;
        playerHolder.holder = null;
        if (z) {
            removePlayer(playerHolder);
        }
        com.up366.common.log.Logger.info("TAG - CommonAudioHelper - stopCleanAudio - playerHolder:" + this.players.size());
    }

    private void stopCleanAudio(com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder) {
        stopCleanAudio(playerHolder, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopCleanAudioRelease(com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder) {
        stopCleanAudio(playerHolder, true);
    }

    private void addPlayer(com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder) {
        synchronized (this.players) {
            this.players.add(playerHolder);
        }
    }

    private void removePlayer(com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder) {
        synchronized (this.players) {
            this.players.remove(playerHolder);
        }
    }

    private void clearPlayers() {
        synchronized (this.players) {
            this.players.clear();
        }
    }

    public void resume(final java.lang.String str) {
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$resume$9(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resume$9(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder = getPlayerHolder(str);
        if (playerHolder == null) {
            com.up366.common.log.Logger.warn("TAG - CommonAudioHelper - resume - player not found!");
        } else {
            playerHolder.player.play();
        }
    }

    public void pause(final java.lang.String str) {
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda8
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$pause$10(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pause$10(java.lang.String str) throws java.lang.Exception {
        com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder = getPlayerHolder(str);
        if (playerHolder == null) {
            com.up366.common.log.Logger.warn("TAG - CommonAudioHelper - pause - player not found!");
        } else {
            playerHolder.player.pause();
        }
    }

    public void setRate(final java.lang.String str, final float f) {
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$setRate$11(str, f);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setRate$11(java.lang.String str, float f) throws java.lang.Exception {
        com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder = getPlayerHolder(str);
        if (playerHolder == null) {
            com.up366.common.log.Logger.warn("TAG - CommonAudioHelper - setRate - player not found!");
            return;
        }
        playerHolder.holder.rate = f;
        playerHolder.player.setPlaybackParameters(new com.google.android.exoplayer2.PlaybackParameters(f));
    }

    public float getRate(final java.lang.String str) {
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final float[] fArr = {1.0f};
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda18
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getRate$12(str, countDownLatch, fArr);
            }
        });
        try {
            countDownLatch.await(1L, java.util.concurrent.TimeUnit.SECONDS);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - CommonAudioHelper - getRate - " + e.getMessage());
        }
        return fArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getRate$12(java.lang.String str, java.util.concurrent.CountDownLatch countDownLatch, float[] fArr) throws java.lang.Exception {
        com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder = getPlayerHolder(str);
        if (playerHolder == null) {
            com.up366.common.log.Logger.warn("TAG - CommonAudioHelper - getRate - player not found!");
            countDownLatch.countDown();
        } else {
            fArr[0] = playerHolder.holder.rate;
            countDownLatch.countDown();
        }
    }

    public void setVolume(final java.lang.String str, final float f) {
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$setVolume$13(str, f);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setVolume$13(java.lang.String str, float f) throws java.lang.Exception {
        com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder = getPlayerHolder(str);
        if (playerHolder == null) {
            com.up366.common.log.Logger.warn("TAG - CommonAudioHelper - setVolume - player not found!");
        } else {
            playerHolder.holder.volume = f;
            playerHolder.player.setVolume(f);
        }
    }

    public float getVolume(final java.lang.String str) {
        final com.google.common.util.concurrent.AtomicDouble atomicDouble = new com.google.common.util.concurrent.AtomicDouble(1.0d);
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getVolume$14(str, countDownLatch, atomicDouble);
            }
        });
        try {
            countDownLatch.await();
        } catch (java.lang.InterruptedException e) {
            com.up366.common.log.Logger.error("TAG - CommonAudioHelper - getVolume - ", e);
        }
        return atomicDouble.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getVolume$14(java.lang.String str, java.util.concurrent.CountDownLatch countDownLatch, com.google.common.util.concurrent.AtomicDouble atomicDouble) throws java.lang.Exception {
        if (getPlayerHolder(str) == null) {
            com.up366.common.log.Logger.warn("TAG - CommonAudioHelper - getVolume - player not found!");
            countDownLatch.countDown();
        } else {
            atomicDouble.set(r3.player.getVolume());
            countDownLatch.countDown();
        }
    }

    public void seek(final java.lang.String str, final long j) {
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda7
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$seek$15(str, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$seek$15(java.lang.String str, long j) throws java.lang.Exception {
        com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder = getPlayerHolder(str);
        if (playerHolder == null) {
            com.up366.common.log.Logger.warn("TAG - CommonAudioHelper - seek - player not found!");
        } else {
            playerHolder.isSeeking = true;
            playerHolder.player.seekTo(j);
        }
    }

    public void play(final com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder) {
        com.up366.asecengine.asecmgr.RecordFactory3.ensureMediaMode(com.up366.common.global.GB.get().getApplicationContext());
        this.commonAudioHolder = audioHolder;
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda13
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$play$16(audioHolder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$play$16(final com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - CommonAudioHelper - play - " + audioHolder.uri);
        final com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder orCreatePlayerHolder = getOrCreatePlayerHolder(audioHolder);
        orCreatePlayerHolder.listener = new com.google.android.exoplayer2.Player.Listener() { // from class: com.up366.mobile.book.helper.CommonAudioHelper.2
            public /* synthetic */ void onAudioAttributesChanged(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onAudioAttributesChanged(this, audioAttributes);
            }

            public /* synthetic */ void onAudioSessionIdChanged(int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onAudioSessionIdChanged(this, i);
            }

            public /* synthetic */ void onAvailableCommandsChanged(com.google.android.exoplayer2.Player.Commands commands) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onAvailableCommandsChanged(this, commands);
            }

            public /* synthetic */ void onCues(com.google.android.exoplayer2.text.CueGroup cueGroup) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onCues(this, cueGroup);
            }

            public /* synthetic */ void onCues(java.util.List list) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onCues(this, list);
            }

            public /* synthetic */ void onDeviceInfoChanged(com.google.android.exoplayer2.DeviceInfo deviceInfo) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onDeviceInfoChanged(this, deviceInfo);
            }

            public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onDeviceVolumeChanged(this, i, z);
            }

            public /* synthetic */ void onEvents(com.google.android.exoplayer2.Player player, com.google.android.exoplayer2.Player.Events events) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onEvents(this, player, events);
            }

            public /* synthetic */ void onIsLoadingChanged(boolean z) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onIsLoadingChanged(this, z);
            }

            public /* synthetic */ void onLoadingChanged(boolean z) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onLoadingChanged(this, z);
            }

            public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onMaxSeekToPreviousPositionChanged(this, j);
            }

            public /* synthetic */ void onMediaItemTransition(com.google.android.exoplayer2.MediaItem mediaItem, int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onMediaItemTransition(this, mediaItem, i);
            }

            public /* synthetic */ void onMediaMetadataChanged(com.google.android.exoplayer2.MediaMetadata mediaMetadata) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onMediaMetadataChanged(this, mediaMetadata);
            }

            public /* synthetic */ void onMetadata(com.google.android.exoplayer2.metadata.Metadata metadata) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onMetadata(this, metadata);
            }

            public /* synthetic */ void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlaybackParametersChanged(this, playbackParameters);
            }

            public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlaybackSuppressionReasonChanged(this, i);
            }

            public /* synthetic */ void onPlayerErrorChanged(com.google.android.exoplayer2.PlaybackException playbackException) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlayerErrorChanged(this, playbackException);
            }

            public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlayerStateChanged(this, z, i);
            }

            public /* synthetic */ void onPlaylistMetadataChanged(com.google.android.exoplayer2.MediaMetadata mediaMetadata) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlaylistMetadataChanged(this, mediaMetadata);
            }

            public /* synthetic */ void onPositionDiscontinuity(int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPositionDiscontinuity(this, i);
            }

            public /* synthetic */ void onPositionDiscontinuity(com.google.android.exoplayer2.Player.PositionInfo positionInfo, com.google.android.exoplayer2.Player.PositionInfo positionInfo2, int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPositionDiscontinuity(this, positionInfo, positionInfo2, i);
            }

            public /* synthetic */ void onRenderedFirstFrame() {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onRenderedFirstFrame(this);
            }

            public /* synthetic */ void onRepeatModeChanged(int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onRepeatModeChanged(this, i);
            }

            public /* synthetic */ void onSeekBackIncrementChanged(long j) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onSeekBackIncrementChanged(this, j);
            }

            public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onSeekForwardIncrementChanged(this, j);
            }

            public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onShuffleModeEnabledChanged(this, z);
            }

            public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onSkipSilenceEnabledChanged(this, z);
            }

            public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onSurfaceSizeChanged(this, i, i2);
            }

            public /* synthetic */ void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onTimelineChanged(this, timeline, i);
            }

            public /* synthetic */ void onTrackSelectionParametersChanged(com.google.android.exoplayer2.trackselection.TrackSelectionParameters trackSelectionParameters) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onTrackSelectionParametersChanged(this, trackSelectionParameters);
            }

            public /* synthetic */ void onTracksChanged(com.google.android.exoplayer2.Tracks tracks) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onTracksChanged(this, tracks);
            }

            public /* synthetic */ void onVideoSizeChanged(com.google.android.exoplayer2.video.VideoSize videoSize) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onVideoSizeChanged(this, videoSize);
            }

            public /* synthetic */ void onVolumeChanged(float f) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onVolumeChanged(this, f);
            }

            public void onPlaybackStateChanged(int i) {
                if (i == 2 && audioHolder.uri.startsWith("http")) {
                    com.up366.mobile.book.helper.CommonAudioHelper.this.onAudioStateChange(audioHolder, 9);
                }
            }

            public void onPlayWhenReadyChanged(boolean z, int i) {
                com.up366.common.log.Logger.info("TAG - CommonAudioHelper - onPlayWhenReadyChanged - playWhenReady = [" + z + "], reason = [" + i + "] duration:" + orCreatePlayerHolder.player.getDuration());
            }

            public void onIsPlayingChanged(boolean z) {
                com.up366.common.log.Logger.info("TAG - CommonAudioHelper - onIsPlayingChanged - isPlaying = [" + z + "]");
                if (z || !orCreatePlayerHolder.isSeeking) {
                    if (z && orCreatePlayerHolder.isSeeking) {
                        orCreatePlayerHolder.isSeeking = false;
                        return;
                    }
                    if (z) {
                        com.up366.mobile.book.helper.CommonAudioHelper.this.onAudioStateChange(audioHolder, 0);
                        return;
                    }
                    int playbackState = orCreatePlayerHolder.player.getPlaybackState();
                    if (playbackState == 4 || playbackState == 1) {
                        com.up366.mobile.book.helper.CommonAudioHelper.this.onAudioStateChange(audioHolder, 4);
                        if (audioHolder.autoDestroy) {
                            com.up366.mobile.book.helper.CommonAudioHelper.this.stopCleanAudioRelease(orCreatePlayerHolder);
                            return;
                        }
                        return;
                    }
                    com.up366.mobile.book.helper.CommonAudioHelper.this.onAudioStateChange(audioHolder, 1, orCreatePlayerHolder.pauseExState);
                    orCreatePlayerHolder.pauseExState = 0;
                }
            }

            public void onPlayerError(com.google.android.exoplayer2.PlaybackException playbackException) {
                com.up366.common.log.Logger.error("TAG - CommonAudioHelper - onPlayerError - ", playbackException);
                audioHolder.onError.onError(playbackException);
                java.lang.String str = audioHolder.uri;
                if (str.startsWith("http") || new java.io.File(java.net.URI.create(str)).exists()) {
                    com.up366.mobile.book.helper.CommonAudioHelper.this.stopCleanAudioRelease(orCreatePlayerHolder);
                    com.up366.mobile.book.helper.Tools.alarmLogTrackContext.src = str;
                    com.up366.mobile.book.helper.Tools.alarmLogTrackContext.msg = playbackException.getErrorCodeName() + ":" + playbackException.getMessage();
                    com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004004002));
                }
            }
        };
        orCreatePlayerHolder.player.addListener(orCreatePlayerHolder.listener);
        if (orCreatePlayerHolder.player.getPlaybackState() == 1) {
            java.lang.String str = audioHolder.uri;
            if (str.startsWith("http")) {
                orCreatePlayerHolder.player.setMediaSource(this.httpMediaSourceFactory.createMediaSource(com.google.android.exoplayer2.MediaItem.fromUri(str)));
            } else {
                if (!new java.io.File(java.net.URI.create(str)).exists()) {
                    com.up366.mobile.book.helper.Tools.alarmLogTrackContext.src = str;
                    com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004004001));
                }
                orCreatePlayerHolder.player.setMediaSource(this.defaultMediaSourceFactory.createMediaSource(com.google.android.exoplayer2.MediaItem.fromUri(str)));
            }
            orCreatePlayerHolder.player.prepare();
        }
        orCreatePlayerHolder.player.setVolume(audioHolder.volume);
        if (audioHolder.seek >= 0) {
            orCreatePlayerHolder.player.seekTo(audioHolder.seek);
            audioHolder.seek = 0L;
        }
        orCreatePlayerHolder.player.setPlaybackParameters(new com.google.android.exoplayer2.PlaybackParameters(audioHolder.rate));
        orCreatePlayerHolder.player.play();
        com.up366.mobile.common.helper.AudioVolumeHelper.checkVolume();
    }

    public com.up366.mobile.book.helper.CommonAudioHelper.AudioInfo getAudioInfo(final com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder) throws java.lang.InterruptedException {
        com.up366.mobile.book.helper.CommonAudioHelper.AudioInfo audioInfo = new com.up366.mobile.book.helper.CommonAudioHelper.AudioInfo();
        audioInfo.time = -1L;
        audioHolder.audioId = "getAudioInfo-" + audioHolder.uri;
        final java.lang.String strDownloadAudioFile = downloadAudioFile(audioHolder.uri);
        final java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getAudioInfo$17(audioHolder, strDownloadAudioFile, atomicReference);
            }
        });
        long jWaitDuration = waitDuration(audioHolder.audioId);
        runOnAudioThread(new com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getAudioInfo$18(audioHolder);
            }
        });
        if (atomicReference.get() != null) {
            throw new java.lang.IllegalStateException((java.lang.Throwable) atomicReference.get());
        }
        audioInfo.time = jWaitDuration;
        if (audioInfo.time < 0) {
            audioInfo.time = 0L;
            com.up366.common.log.Logger.error("TAG - CommonAudioHelper - getAudioInfo - 获取音频时长失败!" + audioHolder.uri);
        }
        audioInfo.size = new java.io.File(java.net.URI.create(strDownloadAudioFile)).length();
        return audioInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAudioInfo$17(com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder, java.lang.String str, final java.util.concurrent.atomic.AtomicReference atomicReference) throws java.lang.Exception {
        com.up366.common.log.Logger.info("TAG - CommonAudioHelper - getAudioInfo - " + audioHolder.uri + " " + str);
        final com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder orCreatePlayerHolder = getOrCreatePlayerHolder(audioHolder);
        orCreatePlayerHolder.listener = new com.google.android.exoplayer2.Player.Listener() { // from class: com.up366.mobile.book.helper.CommonAudioHelper.3
            public /* synthetic */ void onAudioAttributesChanged(com.google.android.exoplayer2.audio.AudioAttributes audioAttributes) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onAudioAttributesChanged(this, audioAttributes);
            }

            public /* synthetic */ void onAudioSessionIdChanged(int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onAudioSessionIdChanged(this, i);
            }

            public /* synthetic */ void onAvailableCommandsChanged(com.google.android.exoplayer2.Player.Commands commands) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onAvailableCommandsChanged(this, commands);
            }

            public /* synthetic */ void onCues(com.google.android.exoplayer2.text.CueGroup cueGroup) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onCues(this, cueGroup);
            }

            public /* synthetic */ void onCues(java.util.List list) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onCues(this, list);
            }

            public /* synthetic */ void onDeviceInfoChanged(com.google.android.exoplayer2.DeviceInfo deviceInfo) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onDeviceInfoChanged(this, deviceInfo);
            }

            public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onDeviceVolumeChanged(this, i, z);
            }

            public /* synthetic */ void onEvents(com.google.android.exoplayer2.Player player, com.google.android.exoplayer2.Player.Events events) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onEvents(this, player, events);
            }

            public /* synthetic */ void onIsLoadingChanged(boolean z) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onIsLoadingChanged(this, z);
            }

            public /* synthetic */ void onLoadingChanged(boolean z) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onLoadingChanged(this, z);
            }

            public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onMaxSeekToPreviousPositionChanged(this, j);
            }

            public /* synthetic */ void onMediaItemTransition(com.google.android.exoplayer2.MediaItem mediaItem, int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onMediaItemTransition(this, mediaItem, i);
            }

            public /* synthetic */ void onMediaMetadataChanged(com.google.android.exoplayer2.MediaMetadata mediaMetadata) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onMediaMetadataChanged(this, mediaMetadata);
            }

            public /* synthetic */ void onMetadata(com.google.android.exoplayer2.metadata.Metadata metadata) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onMetadata(this, metadata);
            }

            public /* synthetic */ void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlaybackParametersChanged(this, playbackParameters);
            }

            public /* synthetic */ void onPlaybackStateChanged(int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlaybackStateChanged(this, i);
            }

            public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlaybackSuppressionReasonChanged(this, i);
            }

            public /* synthetic */ void onPlayerErrorChanged(com.google.android.exoplayer2.PlaybackException playbackException) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlayerErrorChanged(this, playbackException);
            }

            public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlayerStateChanged(this, z, i);
            }

            public /* synthetic */ void onPlaylistMetadataChanged(com.google.android.exoplayer2.MediaMetadata mediaMetadata) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPlaylistMetadataChanged(this, mediaMetadata);
            }

            public /* synthetic */ void onPositionDiscontinuity(int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPositionDiscontinuity(this, i);
            }

            public /* synthetic */ void onPositionDiscontinuity(com.google.android.exoplayer2.Player.PositionInfo positionInfo, com.google.android.exoplayer2.Player.PositionInfo positionInfo2, int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onPositionDiscontinuity(this, positionInfo, positionInfo2, i);
            }

            public /* synthetic */ void onRenderedFirstFrame() {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onRenderedFirstFrame(this);
            }

            public /* synthetic */ void onRepeatModeChanged(int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onRepeatModeChanged(this, i);
            }

            public /* synthetic */ void onSeekBackIncrementChanged(long j) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onSeekBackIncrementChanged(this, j);
            }

            public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onSeekForwardIncrementChanged(this, j);
            }

            public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onShuffleModeEnabledChanged(this, z);
            }

            public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onSkipSilenceEnabledChanged(this, z);
            }

            public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onSurfaceSizeChanged(this, i, i2);
            }

            public /* synthetic */ void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, int i) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onTimelineChanged(this, timeline, i);
            }

            public /* synthetic */ void onTrackSelectionParametersChanged(com.google.android.exoplayer2.trackselection.TrackSelectionParameters trackSelectionParameters) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onTrackSelectionParametersChanged(this, trackSelectionParameters);
            }

            public /* synthetic */ void onTracksChanged(com.google.android.exoplayer2.Tracks tracks) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onTracksChanged(this, tracks);
            }

            public /* synthetic */ void onVideoSizeChanged(com.google.android.exoplayer2.video.VideoSize videoSize) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onVideoSizeChanged(this, videoSize);
            }

            public /* synthetic */ void onVolumeChanged(float f) {
                com.google.android.exoplayer2.Player.Listener.-CC.$default$onVolumeChanged(this, f);
            }

            public void onPlayWhenReadyChanged(boolean z, int i) {
                com.up366.common.log.Logger.info("TAG - CommonAudioHelper - onPlayWhenReadyChanged - playWhenReady = [" + z + "], reason = [" + i + "] duration:" + orCreatePlayerHolder.player.getDuration());
            }

            public void onIsPlayingChanged(boolean z) {
                com.up366.common.log.Logger.info("TAG - CommonAudioHelper - onIsPlayingChanged - isPlaying = [" + z + "]");
            }

            public void onPlayerError(com.google.android.exoplayer2.PlaybackException playbackException) {
                com.up366.common.log.Logger.error("TAG - CommonAudioHelper - onPlayerError - ", playbackException);
                atomicReference.set(playbackException);
            }
        };
        orCreatePlayerHolder.player.addListener(orCreatePlayerHolder.listener);
        if (orCreatePlayerHolder.player.getPlaybackState() == 1) {
            orCreatePlayerHolder.player.setMediaSource(this.defaultMediaSourceFactory.createMediaSource(com.google.android.exoplayer2.MediaItem.fromUri(str)));
            orCreatePlayerHolder.player.prepare();
        }
        orCreatePlayerHolder.player.setVolume(0.0f);
        orCreatePlayerHolder.player.play();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAudioInfo$18(com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder) throws java.lang.Exception {
        com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder = getPlayerHolder(audioHolder.audioId);
        if (playerHolder != null) {
            stopCleanAudio(playerHolder);
        }
    }

    com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder getOrCreatePlayerHolder(com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder) {
        com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder next;
        java.lang.String strBuildGuid = audioHolder.buildGuid();
        java.util.Iterator<com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder> it = this.players.iterator();
        final com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder = null;
        com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder2 = null;
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.player.getPlaybackState() == 1) {
                playerHolder2 = next;
            } else {
                if (java.util.Objects.equals(audioHolder.audioId, next.audioId)) {
                    playerHolder = next;
                }
                if (java.util.Objects.equals(strBuildGuid, next.guid)) {
                    break;
                }
            }
        }
        if (playerHolder2 != null) {
            stopCleanAudio(playerHolder2, true);
        }
        if (next != null) {
            playerHolder = next;
        } else if (playerHolder != null) {
            stopCleanAudio(playerHolder);
        } else {
            playerHolder = new com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder();
            com.google.android.exoplayer2.DefaultRenderersFactory defaultRenderersFactory = new com.google.android.exoplayer2.DefaultRenderersFactory(this.activity) { // from class: com.up366.mobile.book.helper.CommonAudioHelper.4
                protected void buildAudioRenderers(android.content.Context context, int i, com.google.android.exoplayer2.mediacodec.MediaCodecSelector mediaCodecSelector, boolean z, com.google.android.exoplayer2.audio.AudioSink audioSink, android.os.Handler handler, com.google.android.exoplayer2.audio.AudioRendererEventListener audioRendererEventListener, java.util.ArrayList<com.google.android.exoplayer2.Renderer> arrayList) {
                    arrayList.add(new com.google.android.exoplayer2.audio.MediaCodecAudioRenderer(context, mediaCodecSelector, z, handler, audioRendererEventListener, new com.google.android.exoplayer2.audio.DefaultAudioSink.Builder().setAudioCapabilities(com.google.android.exoplayer2.audio.AudioCapabilities.getCapabilities(com.up366.mobile.book.helper.CommonAudioHelper.this.activity)).setAudioProcessors(new com.google.android.exoplayer2.audio.AudioProcessor[]{new com.up366.mobile.book.helper.CommonAudioHelper.FFTAudioProcessor(playerHolder)}).build()));
                    super.buildAudioRenderers(context, i, mediaCodecSelector, z, audioSink, handler, audioRendererEventListener, arrayList);
                }
            };
            defaultRenderersFactory.setEnableDecoderFallback(true);
            playerHolder.player = new com.google.android.exoplayer2.ExoPlayer.Builder(this.activity, defaultRenderersFactory).setLoadControl(new com.google.android.exoplayer2.DefaultLoadControl.Builder().setBufferDurationsMs(300000, 600000, com.igexin.push.c.b.b, 5000).build()).build();
            addPlayer(playerHolder);
        }
        if (playerHolder.player.isPlaying()) {
            playerHolder.player.pause();
        }
        if (playerHolder.listener != null) {
            playerHolder.player.removeListener(playerHolder.listener);
            playerHolder.listener = null;
        }
        playerHolder.guid = strBuildGuid;
        playerHolder.audioId = audioHolder.audioId;
        playerHolder.holder = audioHolder;
        playerHolder.pauseExState = 0;
        return playerHolder;
    }

    com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder getPlayerHolder(java.lang.String str) {
        com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder next;
        java.util.Iterator<com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder> it = this.players.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.player == null || next.player.getPlaybackState() != 1) {
                if (java.util.Objects.equals(str, next.audioId)) {
                    break;
                }
            }
        }
        if (next == null || next.player != null) {
            return next;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAudioStateChange(com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder, int i) {
        onAudioStateChange(audioHolder, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAudioStateChange(final com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder, final int i, final int i2) {
        com.up366.common.log.Logger.info("TAG - CommonAudioHelper - onAudioStateChange - audioId = [" + audioHolder.audioId + "], state = [" + i + "], exState = [" + i2 + "]");
        audioStateExecutor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda11
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder2 = audioHolder;
                audioHolder2.callBack.onMediaStateResult(audioHolder2.audioId, i, i2);
            }
        });
    }

    static class PlayerHolder {
        public boolean isSeeking;
        com.google.android.exoplayer2.Player.Listener listener;
        com.google.android.exoplayer2.ExoPlayer player;
        public int pauseExState = 0;
        java.lang.String guid = null;
        java.lang.String audioId = null;
        com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder holder = null;

        PlayerHolder() {
        }
    }

    public static class AudioHolder {
        public java.lang.String audioId;
        public com.up366.mobile.book.helper.ICommonAudioCallBack callBack;
        public boolean isFFT;
        public boolean isWAV;
        public com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError onError;
        public int samplingRate;
        public long seek;
        public java.lang.String uri;
        public boolean autoDestroy = false;
        public float rate = 1.0f;
        public float volume = 1.0f;

        public interface IOnError {
            void onError(java.lang.Exception exc);
        }

        public java.lang.String convertUri(java.lang.String str) {
            com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadSync;
            if (!str.startsWith("http") || !str.contains("oss") || (fileMapInfoLoadSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().loadSync(str, null)) == null || !com.up366.common.FileUtilsUp.isFileExists(fileMapInfoLoadSync.getPath())) {
                return str;
            }
            com.up366.common.log.Logger.info("TAG - CommonAudioHelper - convertUri - switch to play local audio file - url:" + str + " path:" + fileMapInfoLoadSync.getPath());
            return new java.io.File(fileMapInfoLoadSync.getPath()).toURI().toString();
        }

        public java.lang.String convertUri(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            if (com.up366.common.FileUtilsUp.isFileExists(str)) {
                return new java.io.File(str).toURI().toString();
            }
            if (com.up366.common.FileUtilsUp.isFileExists(str2)) {
                return new java.io.File(str2).toURI().toString();
            }
            if (com.up366.common.FileUtilsUp.isFileExists(str3)) {
                return new java.io.File(str3).toURI().toString();
            }
            return convertUri(str4);
        }

        java.lang.String buildGuid() {
            return this.audioId + this.uri;
        }
    }

    private static class FFTAudioProcessor extends com.google.android.exoplayer2.audio.BaseAudioProcessor {
        private final com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder;
        private int avgIndex = 0;
        private final int[] avgs = new int[5];
        com.up366.asecengine.jni.AsesJni asesJni = new com.up366.asecengine.jni.AsesJni();

        public FFTAudioProcessor(com.up366.mobile.book.helper.CommonAudioHelper.PlayerHolder playerHolder) {
            this.playerHolder = playerHolder;
        }

        public com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat onConfigure(com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat audioFormat) {
            int i = audioFormat.encoding;
            if (i != 3 && i != 2 && i != 268435456 && i != 536870912 && i != 805306368 && i != 4) {
                com.up366.common.log.Logger.warn("TAG - FFTAudioProcessor - onConfigure - no match encoding:" + i);
                return com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat.NOT_SET;
            }
            return new com.google.android.exoplayer2.audio.AudioProcessor.AudioFormat(audioFormat.sampleRate, audioFormat.channelCount, 2);
        }

        public void queueInput(java.nio.ByteBuffer byteBuffer) {
            com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder;
            int iPosition = byteBuffer.position();
            int iLimit = byteBuffer.limit();
            int i = iLimit - iPosition;
            int i2 = this.inputAudioFormat.encoding;
            if (i2 != 2) {
                if (i2 == 3) {
                    i *= 2;
                } else if (i2 == 4) {
                    i /= 2;
                } else if (i2 != 268435456) {
                    if (i2 == 536870912) {
                        i = (i / 3) * 2;
                    } else {
                        if (i2 != 805306368) {
                            return;
                        }
                        i /= 2;
                    }
                }
            }
            java.nio.ByteBuffer byteBufferReplaceOutputBuffer = replaceOutputBuffer(i);
            int i3 = this.inputAudioFormat.encoding;
            if (i3 == 2) {
                while (iPosition < iLimit) {
                    byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition));
                    byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition + 1));
                    iPosition += 2;
                }
            } else if (i3 == 3) {
                while (iPosition < iLimit) {
                    byteBufferReplaceOutputBuffer.put((byte) 0);
                    byteBufferReplaceOutputBuffer.put((byte) ((byteBuffer.get(iPosition) & 255) - 128));
                    iPosition++;
                }
            } else if (i3 == 4) {
                while (iPosition < iLimit) {
                    short sConstrainValue = (short) (com.google.android.exoplayer2.util.Util.constrainValue(byteBuffer.getFloat(iPosition), -1.0f, 1.0f) * 32767.0f);
                    byteBufferReplaceOutputBuffer.put((byte) (sConstrainValue & 255));
                    byteBufferReplaceOutputBuffer.put((byte) ((sConstrainValue >> 8) & 255));
                    iPosition += 4;
                }
            } else if (i3 == 268435456) {
                while (iPosition < iLimit) {
                    byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition + 1));
                    byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition));
                    iPosition += 2;
                }
            } else if (i3 == 536870912) {
                while (iPosition < iLimit) {
                    byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition + 1));
                    byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition + 2));
                    iPosition += 3;
                }
            } else {
                if (i3 != 805306368) {
                    return;
                }
                while (iPosition < iLimit) {
                    byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition + 2));
                    byteBufferReplaceOutputBuffer.put(byteBuffer.get(iPosition + 3));
                    iPosition += 4;
                }
            }
            byteBuffer.position(byteBuffer.limit());
            byteBufferReplaceOutputBuffer.flip();
            if (byteBufferReplaceOutputBuffer.limit() >= 1024 && (audioHolder = this.playerHolder.holder) != null) {
                if (audioHolder.isFFT) {
                    byte[] bArr = new byte[1024];
                    java.lang.System.arraycopy(byteBufferReplaceOutputBuffer.array(), byteBufferReplaceOutputBuffer.position(), bArr, 0, 1024);
                    int i4 = audioHolder.samplingRate;
                    byte[] bArr2 = new byte[i4];
                    countFFTOutput(this.inputAudioFormat.channelCount, bArr, i4, bArr2);
                    audioHolder.callBack.onWavUpdate(audioHolder.audioId, bArr2);
                }
                if (audioHolder.isWAV) {
                    int i5 = audioHolder.samplingRate;
                    byte[] bArr3 = new byte[i5];
                    java.lang.System.arraycopy(byteBufferReplaceOutputBuffer.array(), byteBufferReplaceOutputBuffer.position(), bArr3, 0, i5);
                    audioHolder.callBack.onWavUpdate(audioHolder.audioId, bArr3);
                }
            }
        }

        private void countFFTOutput(int i, byte[] bArr, int i2, byte[] bArr2) {
            this.asesJni.fft(i, 16, bArr, 1024, bArr2, i2);
            this.avgs[this.avgIndex] = 0;
            for (byte b : bArr2) {
                int[] iArr = this.avgs;
                int i3 = this.avgIndex;
                iArr[i3] = iArr[i3] + b;
            }
            int[] iArr2 = this.avgs;
            int i4 = this.avgIndex;
            iArr2[i4] = iArr2[i4] / bArr2.length;
            int i5 = i4 + 1;
            this.avgIndex = i5;
            this.avgIndex = i5 % iArr2.length;
            int i6 = 0;
            for (int i7 : iArr2) {
                i6 += i7;
            }
            int length = i6 / this.avgs.length;
            int i8 = length <= 50 ? length : 50;
            if (length < 20) {
                i8 = 20;
            }
            this.asesJni.delNoice(bArr2, bArr2.length, i8);
        }
    }

    void runOnAudioThread(final com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable runnableWithThrowable) {
        final java.lang.Throwable th = new java.lang.Throwable();
        audioHandler.post(new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$runOnAudioThread$20(runnableWithThrowable, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runOnAudioThread$20(com.up366.mobile.book.helper.CommonAudioHelper.RunnableWithThrowable runnableWithThrowable, java.lang.Throwable th) {
        try {
            runnableWithThrowable.run();
        } catch (java.lang.Exception e) {
            e.addSuppressed(th);
            com.up366.common.log.Logger.error("TAG - CommonAudioHelper - runOnAudioThread - ", e);
            if (this.commonAudioHolder == null || this.commonAudioHolder.onError == null) {
                return;
            }
            this.commonAudioHolder.onError.onError(e);
        }
    }

    public java.lang.String downloadAudioFile(java.lang.String str) throws java.lang.InterruptedException {
        if (!str.startsWith("http")) {
            return str;
        }
        java.lang.String strNewCacheFile = com.up366.mobile.common.logic.Auth.cur().fileMgr().newCacheFile(604800000L, com.up366.common.digest.MD5.md5(str));
        com.up366.common.log.Logger.info("TAG - V8MuxAVHelper - downloadOnlineAudioSync - url = [" + str + "], dst = [" + strNewCacheFile + "]");
        if (com.up366.common.FileUtilsUp.isFileExists(strNewCacheFile)) {
            return new java.io.File(strNewCacheFile).toURI().toString();
        }
        com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setKey(str);
        downloadInfo.setFilePath(strNewCacheFile);
        downloadInfo.setDownloadUrl(str);
        downloadInfo.setDownType(23);
        downloadInfo.setNeedUnzip(false);
        downloadInfo.setNeedCheck(false);
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        com.up366.common.download.DownloadManager.getInstance().addDownload(downloadInfo, new com.up366.common.download.DownloadManager.IDownloadCallback() { // from class: com.up366.mobile.book.helper.CommonAudioHelper$$ExternalSyntheticLambda5
            @Override // com.up366.common.download.DownloadManager.IDownloadCallback
            public final void onStateChange(java.lang.String str2, int i, int i2, java.lang.String str3, long j, long j2, int i3, java.lang.String str4) {
                com.up366.mobile.book.helper.CommonAudioHelper.lambda$downloadAudioFile$21(countDownLatch, str2, i, i2, str3, j, j2, i3, str4);
            }
        });
        countDownLatch.await(1L, java.util.concurrent.TimeUnit.MINUTES);
        if (!com.up366.common.FileUtilsUp.isFileExists(strNewCacheFile)) {
            throw new java.lang.IllegalStateException("download audio failed!");
        }
        return new java.io.File(strNewCacheFile).toURI().toString();
    }

    static /* synthetic */ void lambda$downloadAudioFile$21(java.util.concurrent.CountDownLatch countDownLatch, java.lang.String str, int i, int i2, java.lang.String str2, long j, long j2, int i3, java.lang.String str3) {
        if (i == 4) {
            countDownLatch.countDown();
        }
        if (i == 6) {
            countDownLatch.countDown();
        }
        if (i == 5) {
            countDownLatch.countDown();
        }
    }
}
