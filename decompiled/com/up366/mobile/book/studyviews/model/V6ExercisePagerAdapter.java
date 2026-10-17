package com.up366.mobile.book.studyviews.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V6ExercisePagerAdapter extends androidx.viewpager.widget.PagerAdapter {
    private final com.up366.mobile.book.model.TreeBookChapter bookChapterInfo;
    private final com.up366.mobile.book.StudyActivity context;
    private com.up366.mobile.book.helper.V6ChapterDataHelper dataHelper;
    private android.util.SparseArray<com.up366.mobile.book.studyviews.view.V6ExerciseView> map = new android.util.SparseArray<>();
    private com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper;
    public final com.up366.mobile.book.studyviews.StudyV6View studyFragment;

    public boolean isViewFromObject(android.view.View view, java.lang.Object obj) {
        return view == obj;
    }

    public V6ExercisePagerAdapter(com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.helper.V6ChapterDataHelper v6ChapterDataHelper, com.up366.mobile.book.studyviews.StudyV6View studyV6View, com.up366.mobile.book.helper.recorder.SpeechRecordHelper speechRecordHelper) {
        this.context = studyActivity;
        this.bookChapterInfo = studyActivity.bookChapterInfo;
        this.dataHelper = v6ChapterDataHelper;
        this.studyFragment = studyV6View;
        this.speechRecordHelper = speechRecordHelper;
    }

    public java.lang.Object instantiateItem(android.view.ViewGroup viewGroup, int i) {
        com.up366.mobile.book.studyviews.view.V6ExerciseView v6ExerciseView = new com.up366.mobile.book.studyviews.view.V6ExerciseView(this.context);
        v6ExerciseView.setParams(this.dataHelper, this.bookChapterInfo.getPages().get(i), i, this.studyFragment, this.speechRecordHelper, null);
        viewGroup.addView(v6ExerciseView);
        v6ExerciseView.refresh();
        this.map.put(i, v6ExerciseView);
        return v6ExerciseView;
    }

    public void destroyItem(android.view.ViewGroup viewGroup, int i, java.lang.Object obj) {
        com.up366.mobile.book.studyviews.view.V6ExerciseView v6ExerciseView = this.map.get(i);
        v6ExerciseView.destroy();
        viewGroup.removeView(v6ExerciseView);
        this.map.delete(i);
    }

    public int getCount() {
        return this.bookChapterInfo.getPages().size();
    }

    public com.up366.mobile.book.studyviews.view.V6ExerciseView getExerciseView(int i) {
        return this.map.get(i);
    }

    public void destroy() {
        for (int i = 0; i < this.map.size(); i++) {
            this.map.valueAt(i).destroy();
        }
    }
}
