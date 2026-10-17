package com.up366.mobile.book.studyviews.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V1ExercisePagerAdapter extends androidx.viewpager.widget.PagerAdapter {
    private com.up366.mobile.book.helper.V1AudioHelper audioHelper;
    private com.up366.mobile.book.helper.V1ChapterDataHelper dataHelper;
    private com.up366.mobile.book.helper.V1ListenerBookLogHelper logHelper;
    private android.util.SparseArray<android.view.View> map = new android.util.SparseArray<>();

    public boolean isViewFromObject(android.view.View view, java.lang.Object obj) {
        return view == obj;
    }

    public void setParams(com.up366.mobile.book.helper.V1ChapterDataHelper v1ChapterDataHelper, com.up366.mobile.book.helper.V1AudioHelper v1AudioHelper, com.up366.mobile.book.helper.V1ListenerBookLogHelper v1ListenerBookLogHelper) {
        this.dataHelper = v1ChapterDataHelper;
        this.audioHelper = v1AudioHelper;
        this.logHelper = v1ListenerBookLogHelper;
    }

    public java.lang.Object instantiateItem(android.view.ViewGroup viewGroup, int i) {
        android.view.View view;
        if (i == this.dataHelper.getRealQuestions().size()) {
            com.up366.mobile.book.studyviews.view.V1WellDownView v1WellDownView = new com.up366.mobile.book.studyviews.view.V1WellDownView(viewGroup.getContext());
            v1WellDownView.setBackToCatalogListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.studyviews.model.V1ExercisePagerAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view2) {
                    this.f$0.lambda$instantiateItem$0(view2);
                }
            });
            v1WellDownView.setNextUnitListener(this.dataHelper.getNextUnitListener());
            view = v1WellDownView;
        } else {
            com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView v1ExerciseQuestionView = new com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView(viewGroup.getContext());
            com.up366.mobile.book.helper.V1ChapterDataHelper v1ChapterDataHelper = this.dataHelper;
            v1ExerciseQuestionView.setData(v1ChapterDataHelper, v1ChapterDataHelper.getRealQuestions().get(i), i, this.logHelper, this.audioHelper);
            view = v1ExerciseQuestionView;
        }
        viewGroup.addView(view);
        this.map.put(i, view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$instantiateItem$0(android.view.View view) {
        this.dataHelper.context.onBackPressed();
    }

    public void destroyItem(android.view.ViewGroup viewGroup, int i, java.lang.Object obj) {
        android.view.View view = this.map.get(i);
        if (view instanceof com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView) {
            com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(((com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView) view).b.exerciseQuestionWebview, "jsObj");
        }
        viewGroup.removeView(view);
        this.map.delete(i);
    }

    public int getCount() {
        com.up366.mobile.book.helper.V1ChapterDataHelper v1ChapterDataHelper = this.dataHelper;
        if (v1ChapterDataHelper == null || v1ChapterDataHelper.getRealQuestions() == null) {
            return 0;
        }
        return this.dataHelper.getRealQuestions().size() + 1;
    }

    public com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView getExerciseQuestionView(int i) {
        android.view.View view = this.map.get(i);
        if (view instanceof com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView) {
            return (com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView) view;
        }
        return null;
    }

    public void destroy() {
        for (int i = 0; i < this.map.size(); i++) {
            final android.view.View viewValueAt = this.map.valueAt(i);
            if (viewValueAt instanceof com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView) {
                com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.studyviews.model.V1ExercisePagerAdapter$$ExternalSyntheticLambda1
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(((com.up366.mobile.book.studyviews.view.V1ExerciseQuestionView) viewValueAt).b.exerciseQuestionWebview, "jsObj");
                    }
                });
            }
        }
    }
}
