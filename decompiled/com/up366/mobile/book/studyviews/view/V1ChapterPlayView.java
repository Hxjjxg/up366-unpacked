package com.up366.mobile.book.studyviews.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V1ChapterPlayView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.V1ExerciseChapterPlayViewLayoutBinding b;
    private com.up366.mobile.book.helper.V1BigAudioHelper bigAudioHelper;
    private int curTime;
    private com.up366.mobile.book.helper.V1ChapterDataHelper dataHelper;
    private int pCurrentBigAudioIndex;
    private java.util.List<com.up366.mobile.book.studyviews.model.V1QuestionInfo> questionList;
    private java.util.List<java.lang.Integer> realQuestions;
    private int totalTime;

    public V1ChapterPlayView(android.content.Context context) {
        this(context, null);
    }

    public V1ChapterPlayView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public V1ChapterPlayView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pCurrentBigAudioIndex = 0;
        if (isInEditMode()) {
            android.view.View.inflate(context, com.up366.mobile.R.layout.v1_exercise_chapter_play_view_layout, this);
        } else {
            this.b = (com.up366.mobile.databinding.V1ExerciseChapterPlayViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.v1_exercise_chapter_play_view_layout, this, true);
            initView();
        }
    }

    public void setParams(com.up366.mobile.book.helper.V1ChapterDataHelper v1ChapterDataHelper, com.up366.mobile.book.helper.V1BigAudioHelper v1BigAudioHelper) {
        this.dataHelper = v1ChapterDataHelper;
        this.bigAudioHelper = v1BigAudioHelper;
        v1BigAudioHelper.setOnPauseListener(new com.up366.mobile.book.helper.V1BigAudioHelper.OnPauseListener() { // from class: com.up366.mobile.book.studyviews.view.V1ChapterPlayView$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.book.helper.V1BigAudioHelper.OnPauseListener
            public final void onPause() {
                this.f$0.lambda$setParams$0();
            }
        });
        this.bigAudioHelper.setAudioCallback(new com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback() { // from class: com.up366.mobile.book.studyviews.view.V1ChapterPlayView.1
            @Override // com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback
            public void onPlayFinished() {
                com.up366.mobile.book.studyviews.view.V1ChapterPlayView.this.pAutoPlayNext();
            }

            @Override // com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback
            public void setDuration(int i) {
                throw new java.lang.IllegalStateException("don't call this method ...");
            }

            @Override // com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback
            public void setCurrentPosition(int i) {
                int duration = 0;
                for (int i2 = 0; i2 < com.up366.mobile.book.studyviews.view.V1ChapterPlayView.this.questionList.size() && com.up366.mobile.book.studyviews.view.V1ChapterPlayView.this.pCurrentBigAudioIndex > i2; i2++) {
                    duration += ((com.up366.mobile.book.studyviews.model.V1QuestionInfo) com.up366.mobile.book.studyviews.view.V1ChapterPlayView.this.questionList.get(i2)).getDuration();
                }
                if (i < 0 || i > 3600000) {
                    if (com.up366.mobile.book.studyviews.view.V1ChapterPlayView.this.pSetAudioFile()) {
                        com.up366.mobile.book.studyviews.view.V1ChapterPlayView.this.pResumePlay();
                    }
                    i = 0;
                }
                com.up366.mobile.book.studyviews.view.V1ChapterPlayView.this.curTime = duration + i;
                com.up366.mobile.book.studyviews.view.V1ChapterPlayView.this.updateTimeLabel();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParams$0() {
        ((android.graphics.drawable.AnimationDrawable) this.b.chapterPlayContentAnim.getDrawable()).stop();
        this.b.chapterPlayContentBeginBtn.setBackgroundResource(com.up366.mobile.R.drawable.zhangjiebofang_play_start_btn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pAutoPlayNext() {
        this.pCurrentBigAudioIndex++;
        if (pSetAudioFile()) {
            pResumePlay();
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.show("本章已经播完了");
        this.pCurrentBigAudioIndex = 0;
        pSetAudioFile();
        this.curTime = 0;
        updateTimeLabel();
        pPuasePlay();
    }

    private void initView() {
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.b.chapterPlayContentBeginBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.studyviews.view.V1ChapterPlayView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$1(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.b.chapterPlayContentLastBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.studyviews.view.V1ChapterPlayView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$2(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.b.chapterPlayContentNextBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.studyviews.view.V1ChapterPlayView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(android.view.View view) {
        if (this.bigAudioHelper.isPlaying()) {
            pPuasePlay();
        } else {
            pResumePlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(android.view.View view) {
        pPlayLast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(android.view.View view) {
        pPlayNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTimeLabel() {
        int i = this.totalTime / 1000;
        java.lang.String str = java.lang.String.format(java.util.Locale.CHINA, "%02d:%02d", java.lang.Integer.valueOf(i / 60), java.lang.Integer.valueOf(i % 60));
        int i2 = this.curTime / 1000;
        this.b.chapterPlayContentNowTime.setText(java.lang.String.format(java.util.Locale.CHINA, "%02d:%02d", java.lang.Integer.valueOf(i2 / 60), java.lang.Integer.valueOf(i2 % 60)));
        this.b.chapterPlayContentTotalTime.setText(str);
        this.b.chapterPlayContentProgressBar.setMax(this.totalTime);
        this.b.chapterPlayContentProgressBar.setProgress(this.curTime);
    }

    private void pPuasePlay() {
        this.bigAudioHelper.pausePlay();
    }

    private void pPlayLast() {
        java.util.List<java.lang.Integer> list = this.realQuestions;
        if (list == null) {
            com.up366.common.log.Logger.error("EEEEE - realQuestions is null ...");
            com.up366.mobile.common.utils.ToastPopupUtil.show("试题数据错误！");
            return;
        }
        int size = list.size();
        do {
            size--;
            if (size > -1) {
                if (this.realQuestions.get(size).intValue() < this.pCurrentBigAudioIndex) {
                    this.pCurrentBigAudioIndex = this.realQuestions.get(size).intValue();
                    com.up366.mobile.common.utils.ToastPopupUtil.show("上一题");
                }
            }
            if (pSetAudioFile()) {
                pResumePlay();
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.show("已经是第一题了");
                return;
            }
        } while (size != 0);
        com.up366.mobile.common.utils.ToastPopupUtil.show("已经是第一题了");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
    
        if (pSetAudioFile() == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
    
        pResumePlay();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
    
        com.up366.mobile.common.utils.ToastPopupUtil.show("已经是最后一题了");
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void pPlayNext() {
        /*
            r4 = this;
            java.util.List<java.lang.Integer> r0 = r4.realQuestions
            if (r0 != 0) goto L10
            java.lang.String r0 = "文件错误！"
            com.up366.mobile.common.utils.ToastPopupUtil.show(r0)
            java.lang.String r0 = "EEEEE - realQuestions is null ..."
            com.up366.common.log.Logger.error(r0)
            return
        L10:
            r0 = 0
        L11:
            java.util.List<java.lang.Integer> r1 = r4.realQuestions
            int r1 = r1.size()
            java.lang.String r2 = "已经是最后一题了"
            if (r0 >= r1) goto L52
            java.util.List<java.lang.Integer> r1 = r4.realQuestions
            java.lang.Object r1 = r1.get(r0)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            int r3 = r4.pCurrentBigAudioIndex
            if (r1 <= r3) goto L41
            java.util.List<java.lang.Integer> r1 = r4.realQuestions
            java.lang.Object r0 = r1.get(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r4.pCurrentBigAudioIndex = r0
            java.lang.String r0 = "下一题"
            com.up366.mobile.common.utils.ToastPopupUtil.show(r0)
            goto L52
        L41:
            java.util.List<java.lang.Integer> r1 = r4.realQuestions
            int r1 = r1.size()
            int r1 = r1 + (-1)
            if (r0 != r1) goto L4f
            com.up366.mobile.common.utils.ToastPopupUtil.show(r2)
            return
        L4f:
            int r0 = r0 + 1
            goto L11
        L52:
            boolean r0 = r4.pSetAudioFile()
            if (r0 == 0) goto L5c
            r4.pResumePlay()
            goto L5f
        L5c:
            com.up366.mobile.common.utils.ToastPopupUtil.show(r2)
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.studyviews.view.V1ChapterPlayView.pPlayNext():void");
    }

    public void pStopPlay() {
        this.bigAudioHelper.stopPlay();
        ((android.graphics.drawable.AnimationDrawable) this.b.chapterPlayContentAnim.getDrawable()).stop();
        this.b.chapterPlayContentBeginBtn.setBackgroundResource(com.up366.mobile.R.drawable.zhangjiebofang_play_start_btn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pResumePlay() {
        this.bigAudioHelper.resumePlaying();
        ((android.graphics.drawable.AnimationDrawable) this.b.chapterPlayContentAnim.getDrawable()).start();
        this.b.chapterPlayContentBeginBtn.setBackgroundResource(com.up366.mobile.R.drawable.zhangjiebofang_play_begin_btn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pSetAudioFile() {
        int i = this.pCurrentBigAudioIndex;
        if (i < 0) {
            this.pCurrentBigAudioIndex = 0;
            return false;
        }
        if (i > this.questionList.size() - 1) {
            this.pCurrentBigAudioIndex = this.questionList.size() - 1;
            return false;
        }
        com.up366.mobile.book.studyviews.model.V1QuestionInfo v1QuestionInfo = this.questionList.get(this.pCurrentBigAudioIndex);
        com.up366.common.log.Logger.debug("pCurrentBigAudioIndex : " + this.pCurrentBigAudioIndex + " mp3:" + v1QuestionInfo.getMp3());
        java.lang.String mp3Path = this.dataHelper.getMp3Path(v1QuestionInfo);
        int timeInMillSeconds = this.dataHelper.getTimeInMillSeconds(v1QuestionInfo.getDelay());
        this.bigAudioHelper.stopPlay();
        this.bigAudioHelper.setAudioFile(mp3Path, timeInMillSeconds);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pStopPlay();
    }

    public void refresh() {
        this.questionList = this.dataHelper.getQuestionList();
        this.realQuestions = new java.util.ArrayList();
        for (int i = 0; i < this.questionList.size(); i++) {
            if (this.questionList.get(i).getDisplay() == 1) {
                this.realQuestions.add(java.lang.Integer.valueOf(i - 1));
            }
        }
        this.dataHelper.loadTotalTime(new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.book.studyviews.view.V1ChapterPlayView$$ExternalSyntheticLambda5
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i2, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$refresh$4(i2, str, (java.lang.Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$refresh$4(int i, java.lang.String str, java.lang.Integer num) {
        this.totalTime = num.intValue();
        this.curTime = 0;
        updateTimeLabel();
    }

    public void onShow() {
        this.pCurrentBigAudioIndex = 0;
        this.curTime = 0;
        updateTimeLabel();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.view.V1ChapterPlayView$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onShow$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onShow$5() throws java.lang.Exception {
        pSetAudioFile();
        pPuasePlay();
    }

    public void onHide() {
        pPuasePlay();
    }
}
