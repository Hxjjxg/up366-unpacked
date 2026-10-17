package com.up366.mobile.book.studyviews.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V1ExerciseQuestionView extends android.widget.FrameLayout {
    private com.up366.mobile.book.helper.V1AudioHelper audioHelper;
    public com.up366.mobile.databinding.V1ExerciseQuestionViewLayoutBinding b;
    private com.up366.mobile.book.helper.V1ChapterDataHelper dataHelper;
    private com.up366.mobile.book.helper.V1ListenerBookLogHelper logHelper;
    private int position;
    private com.up366.mobile.book.studyviews.model.V1QuestionInfo questionInfo;

    public V1ExerciseQuestionView(android.content.Context context) {
        this(context, null);
    }

    public V1ExerciseQuestionView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public V1ExerciseQuestionView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.V1ExerciseQuestionViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.v1_exercise_question_view_layout, this, true);
    }

    public void setData(com.up366.mobile.book.helper.V1ChapterDataHelper v1ChapterDataHelper, com.up366.mobile.book.studyviews.model.V1QuestionInfo v1QuestionInfo, int i, com.up366.mobile.book.helper.V1ListenerBookLogHelper v1ListenerBookLogHelper, com.up366.mobile.book.helper.V1AudioHelper v1AudioHelper) {
        this.questionInfo = v1QuestionInfo;
        this.dataHelper = v1ChapterDataHelper;
        this.position = i;
        this.logHelper = v1ListenerBookLogHelper;
        this.audioHelper = v1AudioHelper;
        initWebView();
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.b.exerciseQuestionViewAnswerButton, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setData$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$0(android.view.View view) {
        this.b.exerciseQuestionWebview.callJSMethod("checkAnswer()");
        this.b.exerciseQuestionViewAnswerButton.startAnimation(android.view.animation.AnimationUtils.loadAnimation(getContext(), com.up366.mobile.R.anim.exercise_check_button_out_to_right));
        this.b.exerciseQuestionViewAnswerButton.setVisibility(4);
    }

    private void initWebView() {
        com.up366.mobile.book.studyviews.model.V1QuestionInfo v1QuestionInfo = this.questionInfo;
        this.b.exerciseQuestionWebview.addJavascriptInterface(new com.up366.mobile.book.jsinterface.JSInterfaceV1(this.dataHelper.getBook(), this.dataHelper.getChapter(), getContext(), v1QuestionInfo.getQuestionId(), com.up366.common.FileUtilsUp.join(this.dataHelper.getBookPath(), v1QuestionInfo.getMp3()), this.audioHelper, new com.up366.mobile.book.jsinterface.JSInterfaceV1.ShowAnswerCallBack() { // from class: com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView.1
            @Override // com.up366.mobile.book.jsinterface.JSInterfaceV1.ShowAnswerCallBack
            public void showCheckButton() {
                if (com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView.this.b.exerciseQuestionViewAnswerButton.getVisibility() != 0) {
                    com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView.1.1
                        @Override // com.up366.common.task.Task
                        public void run() {
                            com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView.this.b.exerciseQuestionViewAnswerButton.setVisibility(0);
                            com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView.this.b.exerciseQuestionViewAnswerButton.startAnimation(android.view.animation.AnimationUtils.loadAnimation(com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView.this.getContext(), com.up366.mobile.R.anim.exercise_check_button_in_from_right));
                        }
                    });
                }
            }

            @Override // com.up366.mobile.book.jsinterface.JSInterfaceV1.ShowAnswerCallBack
            public void addTaskProgress(java.lang.String str, float f) {
                com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView.this.logHelper.addTaskProgress(str, f);
            }

            @Override // com.up366.mobile.book.jsinterface.JSInterfaceV1.ShowAnswerCallBack
            public void submitManyExerlogToServer(java.util.List<com.up366.mobile.book.model.AnswerEleAttrInfo.AnswerJSLog> list) {
                com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView.this.logHelper.submitManyExerlogToServer(list);
            }
        }), "jsObj");
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join("file:///", this.dataHelper.getChapterPath(), com.up366.mobile.book.helper.V9ResourceHelper.DIR_QUESTIONS, v1QuestionInfo.getQuestionId(), "question.html");
        this.b.exerciseQuestionWebview.setBackgroundColor(-986896);
        this.b.exerciseQuestionWebview.loadUrlInQueue(strJoin, this.position);
        this.b.exerciseQuestionWebview.setOnFinishedInterface(new com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface() { // from class: com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface
            public final void onFinish() {
                this.f$0.lambda$initWebView$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initWebView$1() {
        this.b.exerciseQuestionWebview.callJSMethod("onEnterPage()");
    }
}
