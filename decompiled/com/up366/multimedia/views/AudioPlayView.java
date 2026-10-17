package com.up366.multimedia.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AudioPlayView extends android.widget.LinearLayout {
    private android.widget.ImageView audioBtn;
    private int curAudioState;
    private android.widget.TextView curTimeView;
    private com.up366.multimedia.model.MediaAttachInfo data;
    private com.warkiz.widget.IndicatorSeekBar progressBar;
    private android.view.View seekbarUp;
    private int targetAudioState;
    private android.widget.TextView totalTimeView;

    static /* synthetic */ boolean lambda$init$0(android.view.View view, android.view.MotionEvent motionEvent) {
        return true;
    }

    public AudioPlayView(android.content.Context context) {
        super(context);
        this.curAudioState = -1;
        this.targetAudioState = -1;
        init(context, null);
    }

    public AudioPlayView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        this.curAudioState = -1;
        this.targetAudioState = -1;
        init(context, attrs);
    }

    public AudioPlayView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.curAudioState = -1;
        this.targetAudioState = -1;
        init(context, attrs);
    }

    private void init(final android.content.Context context, android.util.AttributeSet attrs) {
        android.view.View viewInflate = android.view.LayoutInflater.from(context).inflate(com.afollestad.materialcamera.R.layout.media_attachment_audio_item, this);
        this.audioBtn = (android.widget.ImageView) viewInflate.findViewById(com.afollestad.materialcamera.R.id.att_audio_btn);
        this.progressBar = (com.warkiz.widget.IndicatorSeekBar) viewInflate.findViewById(com.afollestad.materialcamera.R.id.att_audio_progressbar);
        this.curTimeView = (android.widget.TextView) viewInflate.findViewById(com.afollestad.materialcamera.R.id.cur_time_view);
        this.totalTimeView = (android.widget.TextView) viewInflate.findViewById(com.afollestad.materialcamera.R.id.total_time_view);
        android.view.View viewFindViewById = viewInflate.findViewById(com.afollestad.materialcamera.R.id.seekbar_up);
        this.seekbarUp = viewFindViewById;
        viewFindViewById.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.up366.multimedia.views.AudioPlayView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                return com.up366.multimedia.views.AudioPlayView.lambda$init$0(view, motionEvent);
            }
        });
        this.audioBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimedia.views.AudioPlayView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1332lambda$init$1$comup366multimediaviewsAudioPlayView(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$init$1$com-up366-multimedia-views-AudioPlayView, reason: not valid java name */
    /* synthetic */ void m1332lambda$init$1$comup366multimediaviewsAudioPlayView(android.view.View view) {
        handleAudio();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.common.EventBusUtilsUp.register(this);
        getLayoutParams().width = -1;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    public void setData(com.up366.multimedia.model.MediaAttachInfo attachInfo) {
        this.data = attachInfo;
    }

    private void handleAudio() {
        java.lang.String id = this.data.getId();
        int i = this.curAudioState;
        if (i != -1) {
            if (i == 2) {
                this.targetAudioState = 3;
                com.up366.multimedia.helper.AttachmentAudioHelper.getInst().pausePlay(id);
                return;
            } else if (i == 3) {
                this.targetAudioState = 1;
                com.up366.multimedia.helper.AttachmentAudioHelper.getInst().resumePlaying(id);
                return;
            } else if (i != 4) {
                return;
            }
        }
        this.targetAudioState = 1;
        com.up366.multimedia.helper.AttachmentAudioHelper.getInst().startPlaying(id, this.data.getUrl());
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.multimedia.event.MediaStopEvent event) {
        if (this.curAudioState == 2) {
            com.up366.multimedia.helper.AttachmentAudioHelper.getInst().stopPlay(this.data.getId());
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.multimedia.event.MediaPauseEvent event) {
        if (this.curAudioState == 2) {
            com.up366.multimedia.helper.AttachmentAudioHelper.getInst().pausePlay(this.data.getId());
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.multimedia.event.AttachmentAudioPositionEvent e) {
        if (this.data.getId().equals(e.audioId)) {
            if (e.curPos > this.progressBar.getProgress() && this.curAudioState != 2) {
                this.audioBtn.setImageResource(com.afollestad.materialcamera.R.drawable.media_attach_audio_pause);
            }
            this.curTimeView.setText(covertMMSS(e.curPos));
            this.totalTimeView.setText(covertMMSS(e.duration));
            this.progressBar.setProgress(((e.curPos * 1.0f) / e.duration) * 100.0f);
        }
    }

    private java.lang.String covertMMSS(long mills) {
        return java.lang.String.format("%02d:%02d", java.lang.Long.valueOf(mills / 60000), java.lang.Long.valueOf((mills / 1000) % 60));
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.multimedia.event.AttachmentAudioStateChanged e) {
        if (com.up366.common.StringUtils.isEmptyOrNull(e.audioId) || !e.audioId.equals(this.data.getId())) {
            return;
        }
        this.curAudioState = e.state;
        int i = e.state;
        if (i == 2) {
            this.audioBtn.setImageResource(com.afollestad.materialcamera.R.drawable.media_attach_audio_pause);
            return;
        }
        if (i == 3) {
            this.audioBtn.setImageResource(com.afollestad.materialcamera.R.drawable.media_attach_audio_play);
        } else {
            if (i != 4) {
                return;
            }
            this.curTimeView.setText("00:00");
            this.progressBar.setProgress(0.0f);
            this.audioBtn.setImageResource(com.afollestad.materialcamera.R.drawable.media_attach_audio_play);
        }
    }
}
