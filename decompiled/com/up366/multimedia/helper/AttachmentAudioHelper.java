package com.up366.multimedia.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AttachmentAudioHelper implements android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnCompletionListener {
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYING = 3;
    private static com.up366.multimedia.helper.AttachmentAudioHelper helper = new com.up366.multimedia.helper.AttachmentAudioHelper();
    private java.util.Map<java.lang.String, android.media.MediaPlayer> map = new java.util.HashMap();
    private volatile java.lang.String audioId = "";
    private boolean isComplate = false;
    private java.util.Map<java.lang.String, java.lang.Integer> mediaTargetStateMap = new java.util.HashMap();

    public static com.up366.multimedia.helper.AttachmentAudioHelper getInst() {
        return helper;
    }

    public AttachmentAudioHelper() {
        new android.os.CountDownTimer(3600000L, 500L) { // from class: com.up366.multimedia.helper.AttachmentAudioHelper.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                com.up366.multimedia.helper.AttachmentAudioHelper.this.onTimeout();
            }
        }.start();
    }

    public void startPlaying(final java.lang.String audioId, java.lang.String audioFile) {
        stopPlay(this.audioId);
        this.audioId = audioId;
        this.isComplate = false;
        android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
        this.map.put(audioId, mediaPlayer);
        this.mediaTargetStateMap.put(audioId, 3);
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        try {
            mediaPlayer.setDataSource(audioFile);
            mediaPlayer.prepareAsync();
            onAudioStateChange(audioId, 2);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error(e.getMessage());
        }
    }

    public void stopPlay(java.lang.String audioId) {
        if (com.up366.common.StringUtils.isEmptyOrNull(audioId)) {
            return;
        }
        if (this.map.get(audioId) != null) {
            this.mediaTargetStateMap.put(audioId, 0);
            this.map.get(audioId).release();
            this.map.remove(audioId);
        }
        onAudioStateChange(audioId, 4);
    }

    public void pausePlay(java.lang.String audioId) {
        if (com.up366.common.StringUtils.isEmptyOrNull(audioId)) {
            return;
        }
        if (this.map.get(audioId) != null) {
            this.mediaTargetStateMap.put(audioId, 4);
            this.map.get(audioId).pause();
        }
        onAudioStateChange(audioId, 3);
    }

    public void resumePlaying(java.lang.String audioId) {
        if (this.map.get(audioId) != null) {
            this.mediaTargetStateMap.put(audioId, 3);
            this.map.get(audioId).start();
        }
        onAudioStateChange(audioId, 2);
    }

    private void onAudioStateChange(final java.lang.String audioId, final int state) {
        com.up366.common.EventBusUtilsUp.post(new com.up366.multimedia.event.AttachmentAudioStateChanged(audioId, state));
    }

    public java.lang.String getAudioId() {
        return this.audioId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTimeout() {
        android.media.MediaPlayer mediaPlayer = this.map.get(this.audioId);
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            if (!this.isComplate) {
                if (!mediaPlayer.isPlaying()) {
                    com.up366.common.log.Logger.error("AudioMgr onTimeout state error, isComepate is " + this.isComplate + " but mediaPlayer.isPlaying() is " + mediaPlayer.isPlaying());
                    return;
                }
                com.up366.common.EventBusUtilsUp.post(new com.up366.multimedia.event.AttachmentAudioPositionEvent(this.audioId, mediaPlayer.getCurrentPosition(), mediaPlayer.getDuration()));
                return;
            }
            com.up366.common.EventBusUtilsUp.post(new com.up366.multimedia.event.AttachmentAudioPositionEvent(this.audioId, 0, mediaPlayer.getDuration()));
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(android.media.MediaPlayer mp, final int what, final int extra) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.multimedia.helper.AttachmentAudioHelper.2
            @Override // com.up366.common.task.Task
            public void run() throws java.lang.Exception {
                com.up366.common.log.Logger.error("AttachmentAudioHelper " + what + " extra " + extra);
                android.widget.Toast.makeText(com.up366.common.global.GB.getCallBack().getCurrentActivity(), "播放失败!", 1).show();
            }
        });
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(android.media.MediaPlayer mp) {
        if (this.mediaTargetStateMap.get(this.audioId).intValue() == 3) {
            mp.start();
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(android.media.MediaPlayer mp) {
        if (this.map.get(this.audioId) != null) {
            this.map.get(this.audioId).release();
        }
        this.mediaTargetStateMap.put(this.audioId, 0);
        this.map.remove(this.audioId);
        this.isComplate = true;
        onAudioStateChange(this.audioId, 4);
    }
}
