package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V1AudioHelper implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnSeekCompleteListener {
    private com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback audioCallback;
    private com.up366.mobile.book.helper.V1AudioHelper.OnPauseListener onPauseListener;
    private android.media.MediaPlayer mediaPlayer = null;
    private boolean timerStart = false;
    private boolean isPlaying = false;
    private java.util.HashMap<java.lang.String, java.lang.Integer> durMap = new java.util.HashMap<>();

    public interface IAudioCallback {
        void onPlayFinished();

        void setCurrentPosition(int i);

        void setDuration(int i);
    }

    public interface OnPauseListener {
        void onPause();
    }

    private void stopTimer() {
        this.timerStart = false;
    }

    private void startTimer() {
        this.timerStart = true;
    }

    private void onTimeout() {
        if (this.timerStart) {
            notifyCurrentPosition(this.mediaPlayer.getCurrentPosition());
        }
    }

    private void notifyCurrentPosition(final int i) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V1AudioHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$notifyCurrentPosition$0(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyCurrentPosition$0(int i) throws java.lang.Exception {
        if (this.isPlaying) {
            this.audioCallback.setCurrentPosition(i);
        }
    }

    public void setAudioFile(java.lang.String str) {
        if (!com.up366.common.FileUtilsUp.isFileExists(str)) {
            throw new java.lang.IllegalStateException("audioFile : " + str + " is not exists ...");
        }
        android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
        this.mediaPlayer = mediaPlayer;
        mediaPlayer.setOnSeekCompleteListener(this);
        this.mediaPlayer.setOnCompletionListener(this);
        try {
            this.isPlaying = false;
            this.mediaPlayer.setDataSource(str);
            this.mediaPlayer.prepare();
            this.mediaPlayer.start();
            this.mediaPlayer.pause();
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V1AudioHelper$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$setAudioFile$1();
                }
            });
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setAudioFile$1() throws java.lang.Exception {
        this.audioCallback.setDuration(this.mediaPlayer.getDuration());
    }

    public int getAudioDuration(java.lang.String str) {
        android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
        if (this.durMap.get(str) != null) {
            return this.durMap.get(str).intValue();
        }
        if (!com.up366.common.FileUtilsUp.isFileExists(str)) {
            throw new java.lang.IllegalStateException("audioFile : " + str + " is not exists ...");
        }
        try {
            mediaPlayer.setDataSource(str);
            mediaPlayer.prepare();
            int duration = mediaPlayer.getDuration();
            this.durMap.put(str, java.lang.Integer.valueOf(duration));
            return duration;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("total Duration   ERROR " + e.getMessage(), e);
            return 0;
        }
    }

    public void setOnPauseListener(com.up366.mobile.book.helper.V1AudioHelper.OnPauseListener onPauseListener) {
        this.onPauseListener = onPauseListener;
    }

    public void stopPlay() {
        this.isPlaying = false;
        android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
        stopTimer();
    }

    public int getDuration() {
        android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    public int getAudioTotalTimeInSecond() {
        android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getDuration() / 1000;
        }
        return 0;
    }

    public int getCurrentTime() {
        try {
            android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return 0;
            }
            return this.mediaPlayer.getCurrentPosition();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.warn("getCurrentTime:" + e.getMessage());
            return 0;
        }
    }

    public void pausePlay() {
        com.up366.mobile.book.helper.V1AudioHelper.OnPauseListener onPauseListener = this.onPauseListener;
        if (onPauseListener != null) {
            try {
                onPauseListener.onPause();
            } catch (java.lang.Exception unused) {
                this.onPauseListener = null;
                com.up366.common.log.Logger.warn("set onPauseListener = null");
            }
        }
        this.isPlaying = false;
        android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
        stopTimer();
    }

    public void resumePlaying() {
        this.isPlaying = true;
        android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null || mediaPlayer.isPlaying()) {
            return;
        }
        this.mediaPlayer.start();
        startTimer();
    }

    public void toPlay(int i) {
        this.isPlaying = true;
        android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            com.up366.common.log.Logger.error("Media player is not found!");
        } else {
            mediaPlayer.seekTo(i);
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(android.media.MediaPlayer mediaPlayer) {
        if (this.isPlaying) {
            this.mediaPlayer.start();
            startTimer();
        }
    }

    public boolean isPlaying() {
        android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null && !this.timerStart) {
            return false;
        }
        if (mediaPlayer.isPlaying() && !this.timerStart) {
            com.up366.common.log.Logger.error("AudioMgr isPlaying() state error, mediaPlayer.isPlaying() is " + this.mediaPlayer.isPlaying() + " but timer is null ...");
        }
        return this.timerStart;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(android.media.MediaPlayer mediaPlayer) {
        this.isPlaying = false;
        notifyPlayFinished();
        stopTimer();
    }

    private void notifyPlayFinished() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V1AudioHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$notifyPlayFinished$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyPlayFinished$2() throws java.lang.Exception {
        this.audioCallback.onPlayFinished();
    }

    public void setAudioCallback(com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback iAudioCallback) {
        this.audioCallback = iAudioCallback;
    }

    public void onTimeOut() {
        if (this.timerStart) {
            onTimeout();
        }
    }
}
