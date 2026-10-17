package com.up366.mobile.book.studyviews.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V1ExerciseView extends android.widget.FrameLayout {
    private com.up366.mobile.book.studyviews.model.V1ExercisePagerAdapter adapter;
    private com.up366.mobile.book.helper.V1AudioHelper audioHelper;
    private com.up366.mobile.databinding.V1ExerciseViewLayoutBinding b;
    private android.view.View.OnClickListener chapterListener;
    private int currentQuestion;
    private com.up366.mobile.book.helper.V1ChapterDataHelper dataHelper;
    private boolean hasSetAudioFile;
    private com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView lastExerciseQuestionView;
    private com.up366.mobile.book.helper.V1ListenerBookLogHelper logHelper;
    private com.up366.mobile.book.studyviews.model.V1QuestionInfo questionInfo;

    public V1ExerciseView(android.content.Context context) {
        this(context, null);
    }

    public V1ExerciseView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public V1ExerciseView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.V1ExerciseViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.v1_exercise_view_layout, this, true);
        if (isInEditMode()) {
            return;
        }
        initView();
    }

    private void initView() {
        this.adapter = new com.up366.mobile.book.studyviews.model.V1ExercisePagerAdapter();
        this.b.exerciseContentViewpager.setOffscreenPageLimit(5);
        this.b.exerciseContentViewpager.addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener() { // from class: com.up366.mobile.book.studyviews.view.V1ExerciseView.1
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                com.up366.common.log.Logger.debug("EEEEE - cPageChangeListener onPageSelected begin");
                if (com.up366.mobile.book.studyviews.view.V1ExerciseView.this.lastExerciseQuestionView != null) {
                    com.up366.mobile.book.studyviews.view.V1ExerciseView.this.lastExerciseQuestionView.b.exerciseQuestionWebview.callJSMethod("onPageExchange()");
                }
                com.up366.mobile.book.studyviews.view.V1ExerciseView v1ExerciseView = com.up366.mobile.book.studyviews.view.V1ExerciseView.this;
                v1ExerciseView.lastExerciseQuestionView = v1ExerciseView.adapter.getExerciseQuestionView(i);
                com.up366.mobile.book.studyviews.view.V1ExerciseView.this.b.page.setPage(i);
                com.up366.mobile.book.studyviews.view.V1ExerciseView.this.b.exerciseActivityProgressBar.setProgress(0);
                com.up366.mobile.book.studyviews.view.V1ExerciseView.this.b.exerciseActivityPlayButton.setVisibility(4);
                if (i != com.up366.mobile.book.studyviews.view.V1ExerciseView.this.dataHelper.getRealQuestions().size()) {
                    com.up366.mobile.book.studyviews.view.V1ExerciseView.this.b.exerciseActivityPlayButton.setVisibility(0);
                }
                com.up366.mobile.book.studyviews.view.V1ExerciseView.this.cStopPlay();
                if (i != com.up366.mobile.book.studyviews.view.V1ExerciseView.this.dataHelper.getRealQuestions().size()) {
                    com.up366.mobile.book.studyviews.view.V1ExerciseView v1ExerciseView2 = com.up366.mobile.book.studyviews.view.V1ExerciseView.this;
                    v1ExerciseView2.questionInfo = v1ExerciseView2.dataHelper.getRealQuestions().get(i);
                    com.up366.mobile.book.studyviews.view.V1ExerciseView.this.currentQuestion = i;
                    com.up366.mobile.book.studyviews.view.V1ExerciseView.this.hasSetAudioFile = false;
                }
                com.up366.common.log.Logger.debug("EEEEE - cPageChangeListener onPageSelected end");
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.b.exerciseActivityPlayButton, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.studyviews.view.V1ExerciseView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(android.view.View view) {
        playAudio();
    }

    private void cSetAudioFile() {
        if (this.hasSetAudioFile) {
            return;
        }
        this.hasSetAudioFile = true;
        com.up366.mobile.book.studyviews.model.V1QuestionInfo v1QuestionInfo = this.questionInfo;
        if (v1QuestionInfo == null) {
            return;
        }
        java.lang.String mp3 = v1QuestionInfo.getMp3();
        this.b.exerciseActivityProgressBar.setMax(this.questionInfo.getDuration());
        this.b.exerciseActivityProgressBar.setProgress(0);
        cStopPlay();
        this.audioHelper.setAudioFile(com.up366.common.FileUtilsUp.join(this.dataHelper.getBookPath(), mp3));
    }

    private void playAudio() {
        cSetAudioFile();
        if (this.audioHelper.isPlaying()) {
            cPuasePlay();
        } else {
            cResumePlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cStopPlay() {
        this.audioHelper.stopPlay();
        this.b.exerciseActivityPlayButton.setBackgroundResource(com.up366.mobile.R.drawable.zuoti_play_btn_start);
    }

    private void cPuasePlay() {
        this.audioHelper.pausePlay();
    }

    private void cResumePlay() {
        this.audioHelper.resumePlaying();
        this.b.exerciseActivityPlayButton.setBackgroundResource(com.up366.mobile.R.drawable.zuoti_play_btn_pause);
    }

    public void setParams(com.up366.mobile.book.helper.V1ChapterDataHelper v1ChapterDataHelper, com.up366.mobile.book.helper.V1AudioHelper v1AudioHelper, android.view.View.OnClickListener onClickListener) {
        this.dataHelper = v1ChapterDataHelper;
        this.audioHelper = v1AudioHelper;
        this.chapterListener = onClickListener;
        v1AudioHelper.setOnPauseListener(new com.up366.mobile.book.helper.V1AudioHelper.OnPauseListener() { // from class: com.up366.mobile.book.studyviews.view.V1ExerciseView$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.book.helper.V1AudioHelper.OnPauseListener
            public final void onPause() {
                this.f$0.lambda$setParams$1();
            }
        });
        v1AudioHelper.setAudioCallback(new com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback() { // from class: com.up366.mobile.book.studyviews.view.V1ExerciseView.2
            @Override // com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback
            public void setDuration(int i) {
                com.up366.mobile.book.studyviews.view.V1ExerciseView.this.b.exerciseActivityProgressBar.setMax(i);
                com.up366.mobile.book.studyviews.view.V1ExerciseView.this.b.exerciseActivityProgressBar.setProgress(0);
            }

            @Override // com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback
            public void onPlayFinished() {
                com.up366.mobile.book.studyviews.view.V1ExerciseView.this.b.exerciseActivityProgressBar.setProgress(0);
                com.up366.mobile.book.studyviews.view.V1ExerciseView.this.b.exerciseActivityPlayButton.setBackgroundResource(com.up366.mobile.R.drawable.zuoti_play_btn_start);
            }

            @Override // com.up366.mobile.book.helper.V1AudioHelper.IAudioCallback
            public void setCurrentPosition(int i) {
                com.up366.mobile.book.studyviews.view.V1ExerciseView.this.b.exerciseActivityProgressBar.setProgress(i);
            }
        });
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setParams$1() {
        this.b.exerciseActivityPlayButton.setBackgroundResource(com.up366.mobile.R.drawable.zuoti_play_btn_start);
    }

    public void refresh() {
        if (this.dataHelper.getRealQuestions().size() == 0) {
            return;
        }
        this.hasSetAudioFile = false;
        this.b.titleBar.setTitle(this.dataHelper.getChapter().obj.getName());
        this.adapter.setParams(this.dataHelper, this.audioHelper, this.logHelper);
        this.b.exerciseContentViewpager.setAdapter(this.adapter);
        this.b.exerciseActivityPlayButton.setVisibility(0);
        this.b.page.setTotal(this.dataHelper.getRealQuestions().size());
        this.b.page.setChapterListener(this.chapterListener);
        if (this.dataHelper.getRealQuestions().size() != 0) {
            this.questionInfo = this.dataHelper.getRealQuestions().get(0);
        }
        this.b.page.setPage(0);
        cSetAudioFile();
        cPuasePlay();
    }

    public void destroy() {
        this.adapter.destroy();
    }

    public void setLogHelper(com.up366.mobile.book.helper.V1ListenerBookLogHelper v1ListenerBookLogHelper) {
        this.logHelper = v1ListenerBookLogHelper;
    }
}
