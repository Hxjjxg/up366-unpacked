package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V1BigAudioHelper implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnSeekCompleteListener, android.media.MediaPlayer.OnErrorListener {
    private com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback audioCallback;
    private java.lang.String audioFile;
    private com.up366.mobile.book.helper.V1BigAudioHelper.OnPauseListener onPauseListener;
    private final int PERIOD = 100;
    private android.media.MediaPlayer mediaPlayer = null;
    private int delayTime = 0;
    private int position = 0;
    private boolean isComplate = false;
    private boolean timerStart = false;
    private boolean isPlaying = false;
    private int mp3Duration = 0;

    public interface OnPauseListener {
        void onPause();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(android.media.MediaPlayer mediaPlayer) {
    }

    private void stopTimer() {
        this.timerStart = false;
    }

    private void startTimer() {
        this.timerStart = true;
    }

    private void onTimeout() {
        if (this.timerStart) {
            if (!this.mediaPlayer.isPlaying() && this.position > this.delayTime) {
                throw new java.lang.IllegalStateException("AudioMgr onTimeout state error, timer should stop ... position:" + this.position + " delayTime:" + this.delayTime + " mediaPlayer.isPlaying():" + this.mediaPlayer.isPlaying());
            }
            if (!this.isComplate) {
                if (!this.mediaPlayer.isPlaying()) {
                    com.up366.common.log.Logger.error("AudioMgr onTimeout state error, isComepate is " + this.isComplate + " but mediaPlayer.isPlaying() is " + this.mediaPlayer.isPlaying());
                    notifyCurrentPosition(getDuration());
                    return;
                }
                notifyCurrentPosition(this.mediaPlayer.getCurrentPosition());
                return;
            }
            int i = this.position + 100;
            this.position = i;
            if (i >= this.delayTime) {
                this.position = 0;
                this.delayTime = 0;
                stopTimer();
                notifyPlayFinished();
                com.up366.common.log.Logger.debug("------onTimeout : finish : " + this.mediaPlayer.getCurrentPosition());
                return;
            }
            com.up366.common.log.Logger.debug("------onTimeout : curposition2 : " + (getDuration() + this.position));
            notifyCurrentPosition(getDuration() + this.position);
        }
    }

    private void notifyPlayFinished() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V1BigAudioHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$notifyPlayFinished$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyPlayFinished$0() throws java.lang.Exception {
        this.audioCallback.onPlayFinished();
    }

    private void notifyCurrentPosition(final int i) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V1BigAudioHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$notifyCurrentPosition$1(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyCurrentPosition$1(int i) throws java.lang.Exception {
        this.audioCallback.setCurrentPosition(i);
    }

    public void setAudioFile(java.lang.String str, int i) {
        if (!com.up366.common.FileUtilsUp.isFileExists(str)) {
            throw new java.lang.IllegalStateException("audioFile : " + str + " is not exists ...");
        }
        android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
        this.mediaPlayer = mediaPlayer;
        mediaPlayer.setOnSeekCompleteListener(this);
        this.mediaPlayer.setOnCompletionListener(this);
        this.mediaPlayer.setOnErrorListener(this);
        this.audioFile = str;
        try {
            this.delayTime = i;
            this.position = 0;
            this.isComplate = false;
            this.isPlaying = false;
            this.mediaPlayer.setDataSource(str);
            this.mediaPlayer.prepare();
            this.mp3Duration = this.mediaPlayer.getDuration();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error(e.getMessage());
        }
    }

    public int getAudioDuration(java.lang.String str) {
        android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
        if (!com.up366.common.FileUtilsUp.isFileExists(str)) {
            throw new java.lang.IllegalStateException("audioFile : " + str + " is not exists ...");
        }
        try {
            mediaPlayer.setDataSource(str);
            mediaPlayer.prepare();
            return mediaPlayer.getDuration();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error(e.getMessage());
            return 0;
        }
    }

    public void setOnPauseListener(com.up366.mobile.book.helper.V1BigAudioHelper.OnPauseListener onPauseListener) {
        this.onPauseListener = onPauseListener;
    }

    public void stopPlay() {
        this.isPlaying = false;
        stopTimer();
        android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    public int getDuration() {
        if (this.mediaPlayer != null) {
            return this.mp3Duration;
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

    public void pausePlay() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V1BigAudioHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$pausePlay$2();
            }
        });
        this.isPlaying = false;
        android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.mediaPlayer.pause();
        }
        stopTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pausePlay$2() throws java.lang.Exception {
        this.onPauseListener.onPause();
    }

    public void resumePlaying() {
        this.isPlaying = true;
        int i = this.delayTime;
        if (i > 0 && this.isComplate && this.position < i) {
            startTimer();
            return;
        }
        android.media.MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null || mediaPlayer.isPlaying()) {
            return;
        }
        this.isComplate = false;
        this.position = 0;
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
        if (!this.isPlaying) {
            pausePlay();
        }
        resumePlaying();
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
        if (this.delayTime > 0) {
            this.isComplate = true;
            this.position = 0;
            this.isPlaying = true;
        } else {
            this.isComplate = false;
            this.position = getDuration();
            this.isPlaying = false;
        }
        com.up366.common.log.Logger.debug("onCompletion : delayTime:" + this.delayTime + " position:" + this.position + " isPlaying:" + this.isPlaying + " mp3:" + this.audioFile);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
        com.up366.common.log.Logger.warn("BigAudioMgr onError - what:" + i + " extra:" + i2);
        return false;
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
