package com.up366.mobile.user.account.voice;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class RecordButton extends android.widget.FrameLayout {
    private static final int RECORDING = 2;
    private static final int RECORD_OFF = 0;
    private static final int RECORD_ON = 1;
    private androidx.dynamicanimation.animation.SpringAnimation animation;
    private final com.up366.mobile.databinding.RecordButtonBinding b;
    private com.up366.mobile.user.account.voice.AudioRecordHelper mAudioRecorder;
    private final float passScore;
    private int recordState;
    private java.lang.String recordStr;
    private androidx.core.util.Consumer<com.up366.mobile.common.utils.ParamHolder2<com.up366.common.http.Response, java.lang.String>> respConsumer;
    private androidx.dynamicanimation.animation.FloatValueHolder scaleHolder;
    private java.lang.String sentence;
    private int type;

    public RecordButton(android.content.Context context) {
        this(context, null);
    }

    public RecordButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecordButton(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.recordState = 0;
        this.passScore = 0.6f;
        this.b = (com.up366.mobile.databinding.RecordButtonBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.record_button, this, true);
        init();
    }

    private void init() {
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.recordTxt, this.b.recordImg);
        this.b.recordImg.setImageResource(com.up366.mobile.R.drawable.voice_static);
        final android.graphics.Paint paint = new android.graphics.Paint(1);
        paint.setColor(-3090180);
        this.b.recordBg.setBackground(new android.graphics.drawable.ColorDrawable() { // from class: com.up366.mobile.user.account.voice.RecordButton.1
            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void draw(android.graphics.Canvas canvas) {
                float width = com.up366.mobile.user.account.voice.RecordButton.this.b.recordBg.getWidth() / 2.0f;
                float value = com.up366.mobile.user.account.voice.RecordButton.this.scaleHolder.getValue() * width;
                float f = width - value;
                float f2 = width + value;
                canvas.drawOval(f, f, f2, f2, paint);
            }
        });
        this.scaleHolder = new androidx.dynamicanimation.animation.FloatValueHolder(0.0f);
        androidx.dynamicanimation.animation.SpringAnimation springAnimation = new androidx.dynamicanimation.animation.SpringAnimation(this.scaleHolder);
        this.animation = springAnimation;
        springAnimation.addUpdateListener(new androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener() { // from class: com.up366.mobile.user.account.voice.RecordButton$$ExternalSyntheticLambda1
            public final void onAnimationUpdate(androidx.dynamicanimation.animation.DynamicAnimation dynamicAnimation, float f, float f2) {
                this.f$0.lambda$init$0(dynamicAnimation, f, f2);
            }
        });
        androidx.dynamicanimation.animation.SpringForce springForce = new androidx.dynamicanimation.animation.SpringForce();
        springForce.setStiffness(20.0f);
        springForce.setDampingRatio(1.0f);
        this.animation.setSpring(springForce);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(androidx.dynamicanimation.animation.DynamicAnimation dynamicAnimation, float f, float f2) {
        this.b.recordBg.postInvalidate();
    }

    public void setAudioRecord(com.up366.mobile.user.account.voice.AudioRecordHelper audioRecordHelper, int i, androidx.core.util.Consumer<com.up366.mobile.common.utils.ParamHolder2<com.up366.common.http.Response, java.lang.String>> consumer, java.lang.String str) {
        this.mAudioRecorder = audioRecordHelper;
        this.type = i;
        this.respConsumer = consumer;
        this.sentence = str;
    }

    private void updateVoiceStatus(int i) {
        if (i == 0) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.recordImg, this.b.recordTxt);
            com.up366.mobile.common.utils.ViewUtil.invisible(this.b.recordBg);
            this.b.recordImg.setImageResource(com.up366.mobile.R.drawable.voice_static);
            this.b.recordTxt.setText("长按录音");
            this.animation.animateToFinalPosition(0.0f);
            return;
        }
        if (i != 1) {
            if (i != 2) {
                return;
            }
            com.up366.mobile.common.utils.ViewUtil.invisible(this.b.recordImg, this.b.recordTxt, this.b.recordBg);
        } else {
            this.b.recordImg.setImageResource(com.up366.mobile.R.drawable.voice_record);
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.recordImg, this.b.recordBg);
            com.up366.mobile.common.utils.ViewUtil.invisible(this.b.recordTxt);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.recordState = 1;
            com.up366.mobile.user.account.voice.AudioRecordHelper audioRecordHelper = this.mAudioRecorder;
            if (audioRecordHelper != null) {
                audioRecordHelper.start(new androidx.core.util.Consumer() { // from class: com.up366.mobile.user.account.voice.RecordButton$$ExternalSyntheticLambda5
                    public final void accept(java.lang.Object obj) {
                        this.f$0.lambda$onTouchEvent$2((java.lang.Float) obj);
                    }
                }, new androidx.core.util.Consumer() { // from class: com.up366.mobile.user.account.voice.RecordButton$$ExternalSyntheticLambda6
                    public final void accept(java.lang.Object obj) {
                        this.f$0.reStatus((com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder) obj);
                    }
                });
            }
        } else if (action == 1) {
            if (this.recordState == 2) {
                this.mAudioRecorder.stop();
            }
            this.recordState = 0;
        } else if (action != 2) {
            com.up366.common.log.Logger.error("TAG - RecordButton - onTouchEvent - 未知状态 : " + motionEvent.getAction());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouchEvent$2(final java.lang.Float f) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.voice.RecordButton$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onTouchEvent$1(f);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTouchEvent$1(java.lang.Float f) throws java.lang.Exception {
        this.animation.animateToFinalPosition(f.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reStatus(com.up366.mobile.book.helper.recorder.AsecCallbackDataHolder asecCallbackDataHolder) {
        int i = asecCallbackDataHolder.rawState;
        if (i == -1) {
            updateVoiceStatus(0);
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.b.recordBg, "录制失败，请重试");
            return;
        }
        if (i == 0) {
            if (this.recordState != 0) {
                this.recordState = 2;
                updateVoiceStatus(1);
                return;
            } else {
                updateVoiceStatus(0);
                this.mAudioRecorder.stop();
                return;
            }
        }
        if (i == 1) {
            updateVoiceStatus(2);
            return;
        }
        if (i == 2 || i == 3) {
            return;
        }
        if (i != 4) {
            if (i == 99) {
                this.mAudioRecorder.stopAll();
                return;
            }
            com.up366.common.log.Logger.error("TAG - SpeechRecordHelper - onMediaStateResult - 未知状态 : " + i);
            return;
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(asecCallbackDataHolder.session.getJsonResult());
        if (object == null) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.b.recordBg, "录制失败，请重试");
            updateVoiceStatus(0);
            return;
        }
        this.recordStr = object.getString("recognition");
        java.lang.String lowerCase = this.sentence.toLowerCase(java.util.Locale.ROOT);
        double dSimilarityPercentage = com.up366.mobile.user.account.voice.SentenceSimilarity.similarityPercentage(this.recordStr, lowerCase);
        com.up366.common.log.Logger.info("TAG - 2022-09-06 - RecordButton - reStatus - similar-" + dSimilarityPercentage + "\n" + lowerCase + "\n" + this.recordStr);
        if (dSimilarityPercentage >= 0.6000000238418579d) {
            updateVoiceStatus(2);
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(this.b.recordBg, this.type != 3 ? "上传中" : "声纹验证中");
            com.up366.mobile.common.logic.Auth.cur().info().uploadRecordAliyun(this.type == 3 ? 2 : 1, asecCallbackDataHolder.session.getWavPath(), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.voice.RecordButton$$ExternalSyntheticLambda4
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    this.f$0.lambda$reStatus$5(response, obj);
                }
            });
        } else {
            updateVoiceStatus(0);
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.b.recordBg, "录制失败，请重试");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [B, java.lang.String] */
    public /* synthetic */ void lambda$reStatus$5(com.up366.common.http.Response response, java.lang.Object obj) {
        com.alibaba.fastjson.JSONObject object;
        if (response.isError()) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.voice.RecordButton$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$reStatus$3();
                }
            });
            return;
        }
        com.up366.mobile.common.utils.ParamHolder2 paramHolder2 = new com.up366.mobile.common.utils.ParamHolder2();
        paramHolder2.a = response;
        ?? r3 = (java.lang.String) obj;
        paramHolder2.b = r3;
        this.respConsumer.accept(paramHolder2);
        if (obj == null || (object = com.alibaba.fastjson.JSONObject.parseObject((java.lang.String) r3)) == null || object.getBoolean("passed").booleanValue()) {
            return;
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.voice.RecordButton$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$reStatus$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reStatus$3() throws java.lang.Exception {
        updateVoiceStatus(0);
        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.b.recordBg, "录制失败，请重试");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reStatus$4() throws java.lang.Exception {
        updateVoiceStatus(0);
    }
}
