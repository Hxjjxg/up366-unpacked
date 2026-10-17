package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WordSourceHeaderView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.WordSourceHeaderItemBinding b;
    private android.content.Context context;
    private com.up366.mobile.course.wrongnote.modle.WordNoteInfo info;
    private com.up366.mobile.book.helper.CommonAudioHelper mAudioHelper;

    public WordSourceHeaderView(android.content.Context context) {
        this(context, null);
    }

    public WordSourceHeaderView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WordSourceHeaderView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.up366.mobile.databinding.WordSourceHeaderItemBinding wordSourceHeaderItemBinding = (com.up366.mobile.databinding.WordSourceHeaderItemBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.word_source_header_item, this, true);
        this.b = wordSourceHeaderItemBinding;
        this.context = context;
        wordSourceHeaderItemBinding.ivPlayIcon.setRepeatCount(-1);
    }

    public void setWordInfo(com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo, com.up366.mobile.book.helper.CommonAudioHelper commonAudioHelper) {
        java.lang.String string;
        int color;
        android.graphics.drawable.Drawable drawable;
        this.info = wordNoteInfo;
        this.mAudioHelper = commonAudioHelper;
        int degree = wordNoteInfo.getDegree();
        if (degree == 1) {
            string = this.context.getString(com.up366.mobile.R.string.ting_shuo);
            color = androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.c1);
            drawable = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.bg_word_note_ting_shuo);
        } else if (degree == 2) {
            string = this.context.getString(com.up366.mobile.R.string.ren_du);
            color = androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.c3);
            drawable = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.bg_word_note_ren_du);
        } else if (degree == 3) {
            string = this.context.getString(com.up366.mobile.R.string.pin_xie);
            color = androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.c4);
            drawable = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.bg_word_note_pin_xie);
        } else if (degree == 4) {
            string = this.context.getString(com.up366.mobile.R.string.yun_yong);
            color = androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.c2);
            drawable = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.bg_word_note_yun_yong);
        } else {
            string = this.context.getString(com.up366.mobile.R.string.qi_ta);
            color = androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.c5);
            drawable = androidx.core.content.ContextCompat.getDrawable(this.context, com.up366.mobile.R.drawable.bg_word_note_qi_ta);
        }
        this.b.tvWordCategory.setText(string);
        this.b.tvWordCategory.setTextColor(color);
        this.b.tvWordCategory.setBackground(drawable);
        this.b.tvContent.setText(wordNoteInfo.getWord());
        this.b.tvExplain.setText(android.text.Html.fromHtml(wordNoteInfo.getParaphrase()));
        this.b.tvAddCount.setText(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append(this.context.getString(com.up366.mobile.R.string.add_times_2)).setSpan(new android.text.style.ForegroundColorSpan(androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.font_c4))).append(java.lang.String.format(java.util.Locale.getDefault(), "%d次", java.lang.Integer.valueOf(wordNoteInfo.getWordTimes()))).setSpan(new android.text.style.ForegroundColorSpan(androidx.core.content.ContextCompat.getColor(this.context, com.up366.mobile.R.color.c3))).build());
        this.b.ivPlayIcon.setVisibility(com.up366.common.StringUtils.isEmptyOrNull(wordNoteInfo.getVoiceFile()) ? 4 : 0);
        this.b.ivPlayIcon.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceHeaderView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setWordInfo$0(view);
            }
        });
        refreshPlayIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setWordInfo$0(android.view.View view) {
        playWordVoice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshPlayIcon() {
        int state = this.info.getState();
        if (state != -1) {
            if (state == 0) {
                this.b.ivPlayIcon.setMinAndMaxFrame(22, 38);
                this.b.ivPlayIcon.playAnimation();
                return;
            } else if (state != 1 && state != 4) {
                if (state != 9) {
                    return;
                }
                this.b.ivPlayIcon.setMinAndMaxFrame(0, 13);
                this.b.ivPlayIcon.playAnimation();
                return;
            }
        }
        this.b.ivPlayIcon.setMinAndMaxFrame(18, 19);
        this.b.ivPlayIcon.pauseAnimation();
        this.b.ivPlayIcon.setFrame(18);
    }

    private void playWordVoice() {
        this.mAudioHelper.pauseAll();
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this, this.context.getString(com.up366.mobile.R.string.connect_net_before_play));
            return;
        }
        com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder audioHolder = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder();
        audioHolder.audioId = this.info.getWordId();
        audioHolder.isWAV = false;
        audioHolder.isFFT = false;
        audioHolder.autoDestroy = true;
        audioHolder.samplingRate = 12;
        audioHolder.rate = 1.0f;
        audioHolder.volume = 1.0f;
        audioHolder.seek = 0L;
        audioHolder.callBack = new com.up366.mobile.course.unfamiliarWords.WordSourceHeaderView.AnonymousClass1();
        audioHolder.onError = new com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceHeaderView$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.CommonAudioHelper.AudioHolder.IOnError
            public final void onError(java.lang.Exception exc) {
                this.f$0.lambda$playWordVoice$2(exc);
            }
        };
        com.up366.common.log.Logger.info("play word  audio " + this.info.getVoiceFile());
        audioHolder.uri = this.info.getVoiceFile();
        this.mAudioHelper.play(audioHolder);
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.unfamiliarWords.WordSourceHeaderView$1, reason: invalid class name */
    class AnonymousClass1 implements com.up366.mobile.book.helper.ICommonAudioCallBack {
        @Override // com.up366.mobile.book.helper.ICommonAudioCallBack
        public void onWavUpdate(java.lang.String str, byte[] bArr) {
        }

        AnonymousClass1() {
        }

        @Override // com.up366.mobile.book.helper.ICommonAudioCallBack
        public void onMediaStateResult(java.lang.String str, int i, int i2) {
            com.up366.mobile.course.unfamiliarWords.WordSourceHeaderView.this.info.setState(i);
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceHeaderView$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onMediaStateResult$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onMediaStateResult$0() throws java.lang.Exception {
            com.up366.mobile.course.unfamiliarWords.WordSourceHeaderView.this.refreshPlayIcon();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playWordVoice$2(java.lang.Exception exc) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.unfamiliarWords.WordSourceHeaderView$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$playWordVoice$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playWordVoice$1() throws java.lang.Exception {
        this.info.setState(4);
        com.up366.mobile.common.utils.ToastPopupUtil.show(this, this.context.getString(com.up366.mobile.R.string.word_play_failed));
    }
}
