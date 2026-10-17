package com.up366.mobile.book.studyviews.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V4ExercisePagerAdapter extends androidx.viewpager.widget.PagerAdapter {
    private final com.up366.mobile.book.model.TreeBookChapter bookChapterInfo;
    private final com.up366.mobile.book.StudyActivity context;
    private com.up366.mobile.book.helper.V4ChapterDataHelper dataHelper;
    private android.util.SparseArray<com.up366.mobile.book.studyviews.view.V4ExerciseView> map = new android.util.SparseArray<>();
    public final com.up366.mobile.book.studyviews.StudyV4View studyFragment;

    public boolean isViewFromObject(android.view.View view, java.lang.Object obj) {
        return view == obj;
    }

    public V4ExercisePagerAdapter(com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.helper.V4ChapterDataHelper v4ChapterDataHelper, com.up366.mobile.book.studyviews.StudyV4View studyV4View) {
        this.context = studyActivity;
        this.bookChapterInfo = studyActivity.bookChapterInfo;
        this.dataHelper = v4ChapterDataHelper;
        this.studyFragment = studyV4View;
    }

    public java.lang.Object instantiateItem(android.view.ViewGroup viewGroup, int i) {
        com.up366.mobile.book.studyviews.view.V4ExerciseView v4ExerciseView = new com.up366.mobile.book.studyviews.view.V4ExerciseView(this.context);
        v4ExerciseView.setParams(this.dataHelper, this.bookChapterInfo.getPages().get(i), i, this.studyFragment);
        viewGroup.addView(v4ExerciseView);
        this.map.put(i, v4ExerciseView);
        return v4ExerciseView;
    }

    public void destroyItem(android.view.ViewGroup viewGroup, int i, java.lang.Object obj) {
        com.up366.mobile.book.studyviews.view.V4ExerciseView v4ExerciseView = this.map.get(i);
        v4ExerciseView.destroy();
        viewGroup.removeView(v4ExerciseView);
        this.map.delete(i);
    }

    public int getCount() {
        return this.bookChapterInfo.getPages().size();
    }

    public com.up366.mobile.book.studyviews.view.V4ExerciseView getExerciseView(int i) {
        return this.map.get(i);
    }

    public void destroy() {
        for (int i = 0; i < this.map.size(); i++) {
            this.map.valueAt(i).destroy();
        }
    }
}
