package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIAnimationListView extends android.widget.ListView {
    private static final float DEFAULT_OFFSET_DURATION_UNIT = 0.5f;
    private static final long DURATION_ALPHA = 300;
    private static final long DURATION_OFFSET_MAX = 1000;
    private static final long DURATION_OFFSET_MIN = 0;
    private static final java.lang.String TAG = "QMUIAnimationListView";
    protected final java.util.Set<java.lang.Long> mAfterVisible;
    private int mAnimationManipulateDurationLimit;
    protected final java.util.Set<java.lang.Long> mBeforeVisible;
    private android.animation.ValueAnimator mChangeDisappearAnimator;
    private long mChangeDisappearPlayTime;
    protected final androidx.collection.LongSparseArray<android.view.View> mDetachViewsMap;
    private boolean mIsAnimating;
    private long mLastManipulateTime;
    private float mOffsetDurationUnit;
    private android.view.animation.Interpolator mOffsetInterpolator;
    private boolean mOpenChangeDisappearAnimation;
    private final java.util.List<com.up366.qmui.widget.QMUIAnimationListView.Manipulator> mPendingManipulations;
    private final java.util.List<com.up366.qmui.widget.QMUIAnimationListView.Manipulator> mPendingManipulationsWithoutAnimation;
    protected final androidx.collection.LongSparseArray<java.lang.Integer> mPositionMap;
    private android.widget.ListAdapter mRealAdapter;
    protected final androidx.collection.LongSparseArray<java.lang.Integer> mTopMap;
    private com.up366.qmui.widget.QMUIAnimationListView.WrapperAdapter mWrapperAdapter;

    public interface Manipulator<T extends android.widget.ListAdapter> {
        void manipulate(T t);
    }

    public QMUIAnimationListView(android.content.Context context) {
        this(context, null);
    }

    public QMUIAnimationListView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTopMap = new androidx.collection.LongSparseArray<>();
        this.mPositionMap = new androidx.collection.LongSparseArray<>();
        this.mDetachViewsMap = new androidx.collection.LongSparseArray<>();
        this.mBeforeVisible = new java.util.HashSet();
        this.mAfterVisible = new java.util.HashSet();
        this.mPendingManipulations = new java.util.ArrayList();
        this.mPendingManipulationsWithoutAnimation = new java.util.ArrayList();
        this.mChangeDisappearPlayTime = DURATION_OFFSET_MIN;
        this.mIsAnimating = false;
        this.mAnimationManipulateDurationLimit = 0;
        this.mLastManipulateTime = DURATION_OFFSET_MIN;
        this.mOffsetDurationUnit = DEFAULT_OFFSET_DURATION_UNIT;
        this.mOffsetInterpolator = new android.view.animation.LinearInterpolator();
        this.mOpenChangeDisappearAnimation = false;
        init();
    }

    public QMUIAnimationListView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTopMap = new androidx.collection.LongSparseArray<>();
        this.mPositionMap = new androidx.collection.LongSparseArray<>();
        this.mDetachViewsMap = new androidx.collection.LongSparseArray<>();
        this.mBeforeVisible = new java.util.HashSet();
        this.mAfterVisible = new java.util.HashSet();
        this.mPendingManipulations = new java.util.ArrayList();
        this.mPendingManipulationsWithoutAnimation = new java.util.ArrayList();
        this.mChangeDisappearPlayTime = DURATION_OFFSET_MIN;
        this.mIsAnimating = false;
        this.mAnimationManipulateDurationLimit = 0;
        this.mLastManipulateTime = DURATION_OFFSET_MIN;
        this.mOffsetDurationUnit = DEFAULT_OFFSET_DURATION_UNIT;
        this.mOffsetInterpolator = new android.view.animation.LinearInterpolator();
        this.mOpenChangeDisappearAnimation = false;
        init();
    }

    public QMUIAnimationListView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mTopMap = new androidx.collection.LongSparseArray<>();
        this.mPositionMap = new androidx.collection.LongSparseArray<>();
        this.mDetachViewsMap = new androidx.collection.LongSparseArray<>();
        this.mBeforeVisible = new java.util.HashSet();
        this.mAfterVisible = new java.util.HashSet();
        this.mPendingManipulations = new java.util.ArrayList();
        this.mPendingManipulationsWithoutAnimation = new java.util.ArrayList();
        this.mChangeDisappearPlayTime = DURATION_OFFSET_MIN;
        this.mIsAnimating = false;
        this.mAnimationManipulateDurationLimit = 0;
        this.mLastManipulateTime = DURATION_OFFSET_MIN;
        this.mOffsetDurationUnit = DEFAULT_OFFSET_DURATION_UNIT;
        this.mOffsetInterpolator = new android.view.animation.LinearInterpolator();
        this.mOpenChangeDisappearAnimation = false;
        init();
    }

    private void init() {
        setWillNotDraw(false);
    }

    public android.widget.ListAdapter getRealAdapter() {
        return this.mRealAdapter;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(android.widget.ListAdapter listAdapter) {
        this.mRealAdapter = listAdapter;
        com.up366.qmui.widget.QMUIAnimationListView.WrapperAdapter wrapperAdapter = listAdapter != null ? new com.up366.qmui.widget.QMUIAnimationListView.WrapperAdapter(this.mRealAdapter) : null;
        this.mWrapperAdapter = wrapperAdapter;
        super.setAdapter((android.widget.ListAdapter) wrapperAdapter);
    }

    public void setAnimationManipulateDurationLimit(int i) {
        this.mAnimationManipulateDurationLimit = i;
    }

    public <T extends android.widget.ListAdapter> void manipulate(com.up366.qmui.widget.QMUIAnimationListView.Manipulator<T> manipulator) {
        android.util.Log.i(TAG, "manipulate");
        if (!this.mWrapperAdapter.isAnimationEnabled()) {
            manipulateWithoutAnimation(manipulator);
            return;
        }
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        boolean z = jUptimeMillis - this.mLastManipulateTime > ((long) this.mAnimationManipulateDurationLimit);
        this.mLastManipulateTime = jUptimeMillis;
        if (this.mIsAnimating) {
            if (z) {
                this.mPendingManipulations.add(manipulator);
                return;
            } else {
                this.mPendingManipulationsWithoutAnimation.add(manipulator);
                return;
            }
        }
        if (z) {
            this.mIsAnimating = true;
            prepareAnimation();
            manipulator.manipulate(this.mRealAdapter);
            doAnimation();
            return;
        }
        manipulator.manipulate(this.mRealAdapter);
        this.mWrapperAdapter.notifyDataSetChanged();
    }

    public <T extends android.widget.ListAdapter> void manipulateWithoutAnimation(com.up366.qmui.widget.QMUIAnimationListView.Manipulator<T> manipulator) {
        android.util.Log.i(TAG, "manipulateWithoutAnimation");
        if (!this.mIsAnimating) {
            manipulator.manipulate(this.mRealAdapter);
            this.mWrapperAdapter.notifyDataSetChanged();
        } else {
            this.mPendingManipulationsWithoutAnimation.add(manipulator);
        }
    }

    public float getOffsetDurationUnit() {
        return this.mOffsetDurationUnit;
    }

    public void setOffsetDurationUnit(float f) {
        this.mOffsetDurationUnit = f;
    }

    private long getOffsetDuration(int i, int i2) {
        return java.lang.Math.max(DURATION_OFFSET_MIN, java.lang.Math.min((long) (java.lang.Math.abs(i - i2) * this.mOffsetDurationUnit), 1000L));
    }

    public void setOpenChangeDisappearAnimation(boolean z) {
        this.mOpenChangeDisappearAnimation = z;
    }

    public void setOffsetInterpolator(android.view.animation.Interpolator interpolator) {
        this.mOffsetInterpolator = interpolator;
    }

    private void prepareAnimation() {
        this.mTopMap.clear();
        this.mPositionMap.clear();
        this.mBeforeVisible.clear();
        this.mAfterVisible.clear();
        this.mDetachViewsMap.clear();
        this.mWrapperAdapter.setShouldNotifyChange(false);
        int childCount = getChildCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = getChildAt(i);
            long itemId = this.mWrapperAdapter.getItemId(firstVisiblePosition + i);
            this.mTopMap.put(itemId, java.lang.Integer.valueOf(childAt.getTop()));
            this.mPositionMap.put(itemId, java.lang.Integer.valueOf(i));
        }
        for (int i2 = 0; i2 < firstVisiblePosition; i2++) {
            this.mBeforeVisible.add(java.lang.Long.valueOf(this.mWrapperAdapter.getItemId(i2)));
        }
        int count = this.mWrapperAdapter.getCount();
        for (int i3 = firstVisiblePosition + childCount; i3 < count; i3++) {
            this.mAfterVisible.add(java.lang.Long.valueOf(this.mWrapperAdapter.getItemId(i3)));
        }
    }

    private void doAnimation() {
        setEnabled(false);
        setClickable(false);
        doPreLayoutAnimation(new com.up366.qmui.widget.QMUIAnimationListView.ManipulateAnimatorListener() { // from class: com.up366.qmui.widget.QMUIAnimationListView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.up366.qmui.widget.QMUIAnimationListView.this.mWrapperAdapter.notifyDataSetChanged();
                com.up366.qmui.widget.QMUIAnimationListView.this.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() { // from class: com.up366.qmui.widget.QMUIAnimationListView.1.1
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        com.up366.qmui.widget.QMUIAnimationListView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                        com.up366.qmui.widget.QMUIAnimationListView.this.doPostLayoutAnimation();
                        return true;
                    }
                });
            }
        });
    }

    private void doPreLayoutAnimation(android.animation.Animator.AnimatorListener animatorListener) {
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < this.mTopMap.size(); i++) {
            long jKeyAt = this.mTopMap.keyAt(i);
            if (getPositionForId(jKeyAt) < 0) {
                android.animation.Animator deleteAnimator = getDeleteAnimator(getChildAt(((java.lang.Integer) this.mPositionMap.get(jKeyAt)).intValue()));
                this.mPositionMap.remove(jKeyAt);
                animatorSet.play(deleteAnimator);
                arrayList.add(java.lang.Long.valueOf(jKeyAt));
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            this.mTopMap.remove(((java.lang.Long) arrayList.get(i2)).longValue());
        }
        if (this.mOpenChangeDisappearAnimation) {
            for (int i3 = 0; i3 < this.mPositionMap.size(); i3++) {
                android.view.View childAt = getChildAt(((java.lang.Integer) this.mPositionMap.valueAt(i3)).intValue());
                androidx.core.view.ViewCompat.setHasTransientState(childAt, true);
                this.mDetachViewsMap.put(this.mPositionMap.keyAt(i3), childAt);
            }
        }
        if (!animatorSet.getChildAnimations().isEmpty()) {
            animatorSet.addListener(animatorListener);
            animatorSet.start();
        } else {
            animatorListener.onAnimationEnd(animatorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ae A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void doPostLayoutAnimation() {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.qmui.widget.QMUIAnimationListView.doPostLayoutAnimation():void");
    }

    protected long getChangeDisappearDuration() {
        return (long) (getHeight() * this.mOffsetDurationUnit);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006f A[PHI: r2
  0x006f: PHI (r2v8 int) = (r2v7 int), (r2v17 int) binds: [B:21:0x006c, B:18:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            super.onDraw(r9)
            boolean r0 = r8.mOpenChangeDisappearAnimation
            if (r0 == 0) goto L95
            android.animation.ValueAnimator r0 = r8.mChangeDisappearAnimator
            if (r0 == 0) goto L95
            boolean r0 = r0.isStarted()
            if (r0 == 0) goto L95
            androidx.collection.LongSparseArray<android.view.View> r0 = r8.mDetachViewsMap
            int r0 = r0.size()
            if (r0 <= 0) goto L95
            boolean r0 = r8.mIsAnimating
            if (r0 == 0) goto L95
            r0 = 0
            r1 = r0
        L1f:
            androidx.collection.LongSparseArray<android.view.View> r2 = r8.mDetachViewsMap
            int r2 = r2.size()
            if (r1 >= r2) goto L95
            androidx.collection.LongSparseArray<android.view.View> r2 = r8.mDetachViewsMap
            long r2 = r2.keyAt(r1)
            androidx.collection.LongSparseArray<android.view.View> r4 = r8.mDetachViewsMap
            java.lang.Object r4 = r4.valueAt(r1)
            android.view.View r4 = (android.view.View) r4
            int r5 = r8.getPositionForId(r2)
            long r6 = r8.mChangeDisappearPlayTime
            float r6 = (float) r6
            float r7 = r8.mOffsetDurationUnit
            float r6 = r6 / r7
            int r6 = (int) r6
            int r7 = r8.getFirstVisiblePosition()
            if (r5 >= r7) goto L5b
            androidx.collection.LongSparseArray<java.lang.Integer> r5 = r8.mTopMap
            java.lang.Object r2 = r5.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r2 = r2 - r6
            int r3 = r4.getHeight()
            int r3 = -r3
            if (r2 >= r3) goto L6f
            goto L92
        L5b:
            androidx.collection.LongSparseArray<java.lang.Integer> r5 = r8.mTopMap
            java.lang.Object r2 = r5.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r2 = r2 + r6
            int r3 = r8.getHeight()
            if (r2 <= r3) goto L6f
            goto L92
        L6f:
            int r3 = r4.getWidth()
            int r5 = r4.getHeight()
            int r5 = r5 + r2
            r4.layout(r0, r2, r3, r5)
            long r2 = r8.mChangeDisappearPlayTime
            float r2 = (float) r2
            r3 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 * r3
            long r5 = r8.getChangeDisappearDuration()
            float r5 = (float) r5
            float r2 = r2 / r5
            float r3 = r3 - r2
            r4.setAlpha(r3)
            long r2 = r8.getDrawingTime()
            r8.drawChild(r9, r4, r2)
        L92:
            int r1 = r1 + 1
            goto L1f
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.qmui.widget.QMUIAnimationListView.onDraw(android.graphics.Canvas):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishAnimation() {
        this.mWrapperAdapter.setShouldNotifyChange(true);
        this.mChangeDisappearAnimator = null;
        if (this.mOpenChangeDisappearAnimation) {
            for (int i = 0; i < this.mDetachViewsMap.size(); i++) {
                ((android.view.View) this.mDetachViewsMap.valueAt(i)).setAlpha(1.0f);
            }
            this.mDetachViewsMap.clear();
        }
        this.mIsAnimating = false;
        setEnabled(true);
        setClickable(true);
        manipulatePending();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manipulatePending() {
        if (!this.mPendingManipulationsWithoutAnimation.isEmpty()) {
            this.mIsAnimating = true;
            java.util.Iterator<com.up366.qmui.widget.QMUIAnimationListView.Manipulator> it = this.mPendingManipulationsWithoutAnimation.iterator();
            while (it.hasNext()) {
                it.next().manipulate(this.mRealAdapter);
            }
            this.mPendingManipulationsWithoutAnimation.clear();
            this.mWrapperAdapter.notifyDataSetChanged();
            post(new java.lang.Runnable() { // from class: com.up366.qmui.widget.QMUIAnimationListView.5
                @Override // java.lang.Runnable
                public void run() {
                    com.up366.qmui.widget.QMUIAnimationListView.this.mIsAnimating = false;
                    com.up366.qmui.widget.QMUIAnimationListView.this.manipulatePending();
                }
            });
            return;
        }
        if (this.mPendingManipulations.isEmpty()) {
            return;
        }
        this.mIsAnimating = true;
        prepareAnimation();
        java.util.Iterator<com.up366.qmui.widget.QMUIAnimationListView.Manipulator> it2 = this.mPendingManipulations.iterator();
        while (it2.hasNext()) {
            it2.next().manipulate(this.mRealAdapter);
        }
        this.mPendingManipulations.clear();
        doAnimation();
    }

    protected android.animation.Animator getDeleteAnimator(android.view.View view) {
        return alphaObjectAnimator(view, false, DURATION_ALPHA, true);
    }

    protected android.animation.Animator getOffsetAnimator(android.view.View view, int i, int i2) {
        return getOffsetAnimator(view, i, i2, getOffsetDuration(i, i2));
    }

    protected android.animation.Animator getOffsetAnimator(android.view.View view, int i, int i2, long j) {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, "translationY", i - i2, 0.0f);
        objectAnimatorOfFloat.setDuration(j);
        objectAnimatorOfFloat.setInterpolator(this.mOffsetInterpolator);
        return objectAnimatorOfFloat;
    }

    protected android.animation.Animator getAddAnimator(android.view.View view, int i, int i2, int i3, int i4) {
        view.setAlpha(0.0f);
        view.clearAnimation();
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        animatorSet.play(alphaObjectAnimator(view, true, 50L, false));
        if (i3 != i) {
            animatorSet.play(getOffsetAnimator(view, i3, i));
        }
        animatorSet.setStartDelay((long) (view.getHeight() * this.mOffsetDurationUnit));
        return animatorSet;
    }

    protected android.animation.ObjectAnimator alphaObjectAnimator(android.view.View view, final boolean z, long j, boolean z2) {
        float[] fArr = new float[2];
        if (z) {
            fArr[0] = 0.0f;
            fArr[1] = 1.0f;
        } else {
            fArr[0] = 1.0f;
            fArr[1] = 0.0f;
        }
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, com.up366.qmui.skin.QMUISkinValueBuilder.ALPHA, fArr);
        objectAnimatorOfFloat.setDuration(j);
        if (z2) {
            final java.lang.ref.WeakReference weakReference = new java.lang.ref.WeakReference(view);
            objectAnimatorOfFloat.addListener(new com.up366.qmui.widget.QMUIAnimationListView.ManipulateAnimatorListener() { // from class: com.up366.qmui.widget.QMUIAnimationListView.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    if (weakReference.get() != null) {
                        ((android.view.View) weakReference.get()).setAlpha(z ? 0.0f : 1.0f);
                    }
                }
            });
        }
        return objectAnimatorOfFloat;
    }

    protected int getPositionForId(long j) {
        for (int i = 0; i < this.mWrapperAdapter.getCount(); i++) {
            if (this.mWrapperAdapter.getItemId(i) == j) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        return isEnabled() && super.dispatchTouchEvent(motionEvent);
    }

    private static class WrapperAdapter extends android.widget.BaseAdapter {
        private android.widget.ListAdapter mAdapter;
        private boolean mIsAnimationEnabled;
        private final android.database.DataSetObserver mObserver;
        private boolean mShouldNotifyChange = true;

        public WrapperAdapter(android.widget.ListAdapter listAdapter) {
            android.database.DataSetObserver dataSetObserver = new android.database.DataSetObserver() { // from class: com.up366.qmui.widget.QMUIAnimationListView.WrapperAdapter.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    if (com.up366.qmui.widget.QMUIAnimationListView.WrapperAdapter.this.mShouldNotifyChange) {
                        com.up366.qmui.widget.QMUIAnimationListView.WrapperAdapter.this.notifyDataSetChanged();
                    }
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    com.up366.qmui.widget.QMUIAnimationListView.WrapperAdapter.this.notifyDataSetInvalidated();
                }
            };
            this.mObserver = dataSetObserver;
            this.mIsAnimationEnabled = false;
            this.mAdapter = listAdapter;
            listAdapter.registerDataSetObserver(dataSetObserver);
        }

        public void setShouldNotifyChange(boolean z) {
            this.mShouldNotifyChange = z;
        }

        public boolean isAnimationEnabled() {
            return this.mIsAnimationEnabled;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
                com.up366.qmui.QMUILog.d(com.up366.qmui.widget.QMUIAnimationListView.TAG, "notifyDataSetChanged not in main Thread", new java.lang.Object[0]);
            } else {
                super.notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mAdapter.getCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return this.mAdapter.getItemViewType(i);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.mAdapter.getViewTypeCount();
        }

        @Override // android.widget.Adapter
        public java.lang.Object getItem(int i) {
            return this.mAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return this.mAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
            return this.mAdapter.getView(i, view, viewGroup);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            boolean zHasStableIds = this.mAdapter.hasStableIds();
            this.mIsAnimationEnabled = zHasStableIds;
            return zHasStableIds;
        }
    }

    private abstract class ManipulateAnimatorListener implements android.animation.Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
        }

        private ManipulateAnimatorListener() {
        }
    }
}
