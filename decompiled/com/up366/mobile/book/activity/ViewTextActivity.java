package com.up366.mobile.book.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ViewTextActivity extends com.up366.mobile.common.base.BaseActivity implements com.up366.mobile.book.jsinterface.V1ViewTextJSInterface.TextViewAudioCtrl {
    private com.up366.mobile.book.helper.V1AudioHelper audioMgr;
    private com.up366.mobile.databinding.QuestionTextActivityContentBinding b;
    public java.lang.String bookId;
    public java.lang.String chapterId;
    private android.os.CountDownTimer countDownTimer;
    private com.up366.mobile.book.jsinterface.V1ViewTextJSInterface jsObj = null;
    private java.lang.String mp3;
    public java.lang.String questionId;

    static /* synthetic */ void lambda$onCreate$1() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.up366.mobile.book.activity.ViewTextActivity$1] */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.b = (com.up366.mobile.databinding.QuestionTextActivityContentBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.question_text_activity_content);
        this.audioMgr = new com.up366.mobile.book.helper.V1AudioHelper();
        this.countDownTimer = new android.os.CountDownTimer(1000L, 100L) { // from class: com.up366.mobile.book.activity.ViewTextActivity.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                com.up366.mobile.book.activity.ViewTextActivity.this.audioMgr.onTimeOut();
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                com.up366.mobile.book.activity.ViewTextActivity.this.countDownTimer.start();
            }
        }.start();
        android.content.Intent intent = getIntent();
        this.bookId = intent.getStringExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
        this.chapterId = intent.getStringExtra("chapterId");
        this.questionId = intent.getStringExtra("questionId");
        java.lang.String stringExtra = intent.getStringExtra("mp3");
        this.mp3 = stringExtra;
        try {
            this.audioMgr.setAudioFile(stringExtra);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - ViewTextActivity - onCreate - " + e.getMessage(), e);
            finish();
        }
        initWebView();
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.b.questionTextActivityPlayButton, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.activity.ViewTextActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.b.questionTextActivityProgressBar.setMax(this.audioMgr.getDuration());
        this.b.questionTextActivityProgressBar.setProgress(0);
        this.audioMgr.toPlay(0);
        pausePlay();
        this.audioMgr.setOnPauseListener(new com.up366.mobile.book.helper.V1AudioHelper.OnPauseListener() { // from class: com.up366.mobile.book.activity.ViewTextActivity$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.book.helper.V1AudioHelper.OnPauseListener
            public final void onPause() {
                com.up366.mobile.book.activity.ViewTextActivity.lambda$onCreate$1();
            }
        });
        this.audioMgr.setAudioCallback(new com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback() { // from class: com.up366.mobile.book.activity.ViewTextActivity.2
            @Override // com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback
            public void setDuration(int i) {
                com.up366.mobile.book.activity.ViewTextActivity.this.b.questionTextActivityProgressBar.setMax(i);
                com.up366.mobile.book.activity.ViewTextActivity.this.b.questionTextActivityProgressBar.setProgress(0);
            }

            @Override // com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback
            public void onPlayFinished() {
                com.up366.mobile.book.activity.ViewTextActivity.this.b.questionTextActivityProgressBar.setProgress(0);
                com.up366.mobile.book.activity.ViewTextActivity.this.b.questionTextActivityPlayButton.setBackgroundResource(com.up366.mobile.R.drawable.zuoti_play_btn_start);
            }

            @Override // com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback
            public void setCurrentPosition(int i) {
                com.up366.mobile.book.activity.ViewTextActivity.this.b.questionTextActivityProgressBar.setProgress(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(android.view.View view) {
        playAudio();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public void onResume() {
        super.onResume();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public void onPause() {
        pausePlay();
        super.onPause();
    }

    private void initWebView() {
        this.jsObj = new com.up366.mobile.book.jsinterface.V1ViewTextJSInterface(this, this.audioMgr);
        this.b.questionTextActivityWebview.addJavascriptInterface(this.jsObj, "jsObj");
        this.b.questionTextActivityWebview.loadUrl(com.up366.common.FileUtilsUp.join("file://", com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.bookId, this.chapterId, com.up366.mobile.book.helper.V9ResourceHelper.DIR_QUESTIONS, this.questionId, "analysis.html"));
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        pausePlay();
        com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(this.b.questionTextActivityWebview, "jsObj");
        android.os.CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.countDownTimer = null;
        }
        super.onDestroy();
    }

    private void playAudio() {
        if (this.audioMgr.isPlaying()) {
            pausePlay();
        } else {
            resumePlay();
        }
    }

    @Override // com.up366.mobile.book.jsinterface.V1ViewTextJSInterface.TextViewAudioCtrl
    public void resumePlay() {
        this.b.questionTextActivityPlayButton.setBackgroundResource(com.up366.mobile.R.drawable.zuoti_play_btn_pause);
        this.audioMgr.resumePlaying();
    }

    @Override // com.up366.mobile.book.jsinterface.V1ViewTextJSInterface.TextViewAudioCtrl
    public void pausePlay() {
        this.b.questionTextActivityPlayButton.setBackgroundResource(com.up366.mobile.R.drawable.zuoti_play_btn_start);
        this.audioMgr.pausePlay();
    }
}
