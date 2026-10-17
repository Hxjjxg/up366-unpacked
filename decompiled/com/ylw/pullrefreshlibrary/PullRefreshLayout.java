package com.ylw.pullrefreshlibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PullRefreshLayout extends android.view.ViewGroup {
    public static final java.lang.String TAG = "PullRefreshLayout";
    private boolean autoRefreshing;
    private com.ylw.pullrefreshlibrary.PullRefreshLayout.IContentPositionCallback contentPositionCallback;
    private int contentTopPosition;
    private android.view.View contentView;
    private boolean disallowIntercept;
    private float downPosX;
    private float downPosY;
    private boolean downRefreshing;
    private boolean enable;
    private boolean enablePullDown;
    private boolean hasCancel;
    private android.view.View headView;
    private androidx.customview.widget.ViewDragHelper mDragger;
    private int mShakeSize;
    private java.lang.reflect.Method methodComputeVerticalScrollExtent;
    private java.lang.reflect.Method methodComputeVerticalScrollOffset;
    private java.lang.reflect.Method methodComputeVerticalScrollRange;
    private com.ylw.pullrefreshlibrary.PullRefreshLayout.OnCompleteListener onCompleteListener;
    private com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener onPullDownListener;
    private com.ylw.pullrefreshlibrary.PullRefreshLayout.OnScrollBottomListener onScrollBottomListener;
    private com.ylw.pullrefreshlibrary.PullRefreshLayout.IOnScrollListener onScrollListener;
    private int onScrollToBottomRange;
    private com.ylw.pullrefreshlibrary.PullRefreshLayout.PullCallBack pullCallBack;
    private android.view.View realContentView;
    private com.ylw.pullrefreshlibrary.refreshview.IRefreshView refreshView;
    private boolean refreshing;
    private int vcH;
    private int vtH;
    private boolean waitRefreshing;

    public interface IContentPositionCallback {
        boolean isTop();
    }

    public interface IOnScrollListener {
        void onScroll(int i);
    }

    public interface OnCompleteListener {
        void onComplete();
    }

    public interface OnPullDownListener {
        void onRefresh();
    }

    public interface OnScrollBottomListener {
        void onScrollBottom();
    }

    interface PullCallBack {
        public static final int STATE_STEP1 = 0;
        public static final int STATE_STEP2 = 1;
        public static final int STATE_STEP3 = 2;
        public static final int STATE_STEP4 = 3;

        boolean canPullDown();

        void onPullStateChange(int i);

        void onPullStateChange(int i, float f);
    }

    public PullRefreshLayout(android.content.Context context) {
        this(context, null);
    }

    public PullRefreshLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullRefreshLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.disallowIntercept = false;
        this.downPosY = 0.0f;
        this.downPosX = 0.0f;
        this.hasCancel = false;
        this.downRefreshing = false;
        this.refreshing = false;
        this.autoRefreshing = false;
        this.enable = true;
        this.enablePullDown = false;
        this.onScrollToBottomRange = 10;
        this.pullCallBack = new com.ylw.pullrefreshlibrary.PullRefreshLayout.PullCallBack() { // from class: com.ylw.pullrefreshlibrary.PullRefreshLayout.1
            int lastState = 0;
            private boolean canPullDown = true;
            private boolean reachBottom = false;
            private boolean onScrollBottom = false;
            boolean hasSetListener = false;

            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.PullCallBack
            public boolean canPullDown() {
                computePullState();
                return com.ylw.pullrefreshlibrary.PullRefreshLayout.this.enable && this.canPullDown && com.ylw.pullrefreshlibrary.PullRefreshLayout.this.enablePullDown;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void computePullState() {
                boolean z = this.canPullDown;
                if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.contentPositionCallback != null) {
                    this.canPullDown = com.ylw.pullrefreshlibrary.PullRefreshLayout.this.contentPositionCallback.isTop();
                } else {
                    this.canPullDown = !com.ylw.pullrefreshlibrary.PullRefreshLayout.this.realContentView.canScrollVertically(-1);
                }
                if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.realContentView instanceof android.widget.ScrollView) {
                    if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onScrollListener == null || this.canPullDown) {
                        return;
                    }
                    com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onScrollListener.onScroll(-com.ylw.pullrefreshlibrary.PullRefreshLayout.this.realContentView.getScrollY());
                    return;
                }
                if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.realContentView instanceof android.widget.AbsListView) {
                    android.widget.AbsListView absListView = (android.widget.AbsListView) com.ylw.pullrefreshlibrary.PullRefreshLayout.this.realContentView;
                    boolean z2 = this.canPullDown;
                    if (z != z2 && !z2 && com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onScrollBottomListener != null) {
                        com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onScrollBottomListener.onScrollBottom();
                    }
                    if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onScrollListener == null || this.canPullDown) {
                        return;
                    }
                    com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onScrollListener.onScroll(-com.ylw.pullrefreshlibrary.PullRefreshLayout.this.getABSListScrollY(absListView));
                    return;
                }
                if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.realContentView instanceof android.webkit.WebView) {
                    android.webkit.WebView webView = (android.webkit.WebView) com.ylw.pullrefreshlibrary.PullRefreshLayout.this.realContentView;
                    if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onScrollListener == null || this.canPullDown) {
                        return;
                    }
                    com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onScrollListener.onScroll(-webView.getScrollY());
                    return;
                }
                if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.realContentView instanceof androidx.recyclerview.widget.RecyclerView) {
                    androidx.recyclerview.widget.RecyclerView recyclerView = com.ylw.pullrefreshlibrary.PullRefreshLayout.this.realContentView;
                    int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                    if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onScrollListener != null && !this.canPullDown) {
                        com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onScrollListener.onScroll(-iComputeVerticalScrollOffset);
                    }
                    androidx.recyclerview.widget.RecyclerView.Adapter adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        if (recyclerView.getChildAdapterPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1)) == adapter.getItemCount() - 1) {
                            if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onScrollBottomListener != null && !this.onScrollBottom) {
                                com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onScrollBottomListener.onScrollBottom();
                            }
                            this.onScrollBottom = true;
                        } else {
                            this.onScrollBottom = false;
                        }
                    }
                    if (this.hasSetListener) {
                        return;
                    }
                    this.hasSetListener = true;
                    recyclerView.addOnScrollListener(new androidx.recyclerview.widget.RecyclerView.OnScrollListener() { // from class: com.ylw.pullrefreshlibrary.PullRefreshLayout.1.1
                        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView2, int i2, int i3) {
                            super.onScrolled(recyclerView2, i2, i3);
                            int iComputeVerticalScrollOffset2 = recyclerView2.computeVerticalScrollOffset();
                            if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onScrollListener == null || com.ylw.pullrefreshlibrary.PullRefreshLayout.AnonymousClass1.this.canPullDown) {
                                return;
                            }
                            com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onScrollListener.onScroll(-iComputeVerticalScrollOffset2);
                        }

                        public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView2, int i2) {
                            if (i2 == 0) {
                                computePullState();
                            }
                        }
                    });
                }
            }

            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.PullCallBack
            public void onPullStateChange(int i2) {
                int i3 = this.lastState;
                if (i3 == i2) {
                    return;
                }
                if (i2 == 0) {
                    toStep1(i3, i2);
                } else if (i2 == 1) {
                    toStep2(i3, i2);
                } else if (i2 == 2) {
                    toStep3(i3, i2);
                }
                this.lastState = i2;
            }

            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.PullCallBack
            public void onPullStateChange(int i2, float f) {
                if (i2 != 0) {
                    return;
                }
                com.ylw.pullrefreshlibrary.PullRefreshLayout.this.refreshView.updatePercent(f);
            }

            private void toStep1(int i2, int i3) {
                android.util.Log.d(com.ylw.pullrefreshlibrary.PullRefreshLayout.TAG, "toStep1: ==========");
                com.ylw.pullrefreshlibrary.PullRefreshLayout.this.refreshView.toStep1(com.ylw.pullrefreshlibrary.PullRefreshLayout.this.getContext(), i2, i3);
            }

            private void toStep2(int i2, int i3) {
                android.util.Log.d(com.ylw.pullrefreshlibrary.PullRefreshLayout.TAG, "toStep2: ==========");
                com.ylw.pullrefreshlibrary.PullRefreshLayout.this.refreshView.toStep2(com.ylw.pullrefreshlibrary.PullRefreshLayout.this.getContext(), i2, i3);
            }

            private void toStep3(int i2, int i3) {
                com.ylw.pullrefreshlibrary.PullRefreshLayout.this.refreshView.toStep3(com.ylw.pullrefreshlibrary.PullRefreshLayout.this.getContext(), i2, i3);
                android.util.Log.d(com.ylw.pullrefreshlibrary.PullRefreshLayout.TAG, "toStep3: ==========");
            }
        };
        init(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.waitRefreshing) {
            doRefresh();
        }
    }

    private void init(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.ylw.pullrefreshlibrary.R.styleable.PullRefreshLayout, i, 0);
        int i2 = typedArrayObtainStyledAttributes.getInt(com.ylw.pullrefreshlibrary.R.styleable.PullRefreshLayout_refreshView, 0);
        java.lang.String string = typedArrayObtainStyledAttributes.getString(com.ylw.pullrefreshlibrary.R.styleable.PullRefreshLayout_refreshViewClassName);
        typedArrayObtainStyledAttributes.recycle();
        this.mShakeSize = android.view.ViewConfiguration.get(getContext()).getScaledTouchSlop();
        try {
            this.methodComputeVerticalScrollOffset = android.view.View.class.getDeclaredMethod("computeVerticalScrollOffset", null);
            this.methodComputeVerticalScrollRange = android.view.View.class.getDeclaredMethod("computeVerticalScrollRange", null);
            this.methodComputeVerticalScrollExtent = android.view.View.class.getDeclaredMethod("computeVerticalScrollExtent", null);
            this.methodComputeVerticalScrollOffset.setAccessible(true);
            this.methodComputeVerticalScrollRange.setAccessible(true);
            this.methodComputeVerticalScrollExtent.setAccessible(true);
            if (string != null) {
                try {
                    this.refreshView = (com.ylw.pullrefreshlibrary.refreshview.IRefreshView) java.lang.Class.forName(string).newInstance();
                } catch (java.lang.Exception e) {
                    android.util.Log.e(TAG, "init: ClassNotFoundException ", e);
                }
            }
            if (this.refreshView == null) {
                if (i2 == 0) {
                    this.refreshView = new com.ylw.pullrefreshlibrary.refreshview.RefreshView();
                } else {
                    this.refreshView = new com.ylw.pullrefreshlibrary.refreshview.RefreshView();
                }
            }
            this.refreshView.init(context, this);
            android.view.View childAt = getChildAt(0);
            this.headView = childAt;
            this.refreshView.initView(childAt);
            initDragger();
        } catch (java.lang.Exception e2) {
            throw new java.lang.IllegalStateException(e2);
        }
    }

    private void initDragger() {
        this.mDragger = androidx.customview.widget.ViewDragHelper.create(this, 1.0f, new androidx.customview.widget.ViewDragHelper.Callback() { // from class: com.ylw.pullrefreshlibrary.PullRefreshLayout.2
            public int clampViewPositionHorizontal(android.view.View view, int i, int i2) {
                return 0;
            }

            public boolean tryCaptureView(android.view.View view, int i) {
                return true;
            }

            public int clampViewPositionVertical(android.view.View view, int i, int i2) {
                com.ylw.pullrefreshlibrary.PullRefreshLayout.this.downRefreshing = false;
                com.ylw.pullrefreshlibrary.PullRefreshLayout.this.changePosition();
                if (!com.ylw.pullrefreshlibrary.PullRefreshLayout.this.enablePullDown || i <= com.ylw.pullrefreshlibrary.PullRefreshLayout.this.vtH) {
                    com.ylw.pullrefreshlibrary.PullRefreshLayout.this.pullCallBack.onPullStateChange(0);
                } else {
                    com.ylw.pullrefreshlibrary.PullRefreshLayout.this.downRefreshing = true;
                    com.ylw.pullrefreshlibrary.PullRefreshLayout.this.pullCallBack.onPullStateChange(1);
                }
                if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.enablePullDown && i <= com.ylw.pullrefreshlibrary.PullRefreshLayout.this.vtH) {
                    com.ylw.pullrefreshlibrary.PullRefreshLayout.this.pullCallBack.onPullStateChange(0, (i * 1.0f) / com.ylw.pullrefreshlibrary.PullRefreshLayout.this.vtH);
                }
                return i - (i2 / 2);
            }

            public void onViewDragStateChanged(int i) {
                if (i == 0) {
                    com.ylw.pullrefreshlibrary.PullRefreshLayout.this.changePosition();
                    if (!com.ylw.pullrefreshlibrary.PullRefreshLayout.this.refreshing) {
                        com.ylw.pullrefreshlibrary.PullRefreshLayout.this.resetPosition();
                    }
                    com.ylw.pullrefreshlibrary.PullRefreshLayout.this.pullCallBack.canPullDown();
                    if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onCompleteListener == null || com.ylw.pullrefreshlibrary.PullRefreshLayout.this.downRefreshing || com.ylw.pullrefreshlibrary.PullRefreshLayout.this.refreshing) {
                        return;
                    }
                    com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onCompleteListener.onComplete();
                    return;
                }
                if (i != 1 || com.ylw.pullrefreshlibrary.PullRefreshLayout.this.autoRefreshing) {
                    return;
                }
                com.ylw.pullrefreshlibrary.PullRefreshLayout.this.refreshing = false;
            }

            public void onViewReleased(android.view.View view, float f, float f2) {
                float f3;
                if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.downRefreshing && com.ylw.pullrefreshlibrary.PullRefreshLayout.this.pullCallBack.canPullDown()) {
                    f3 = com.ylw.pullrefreshlibrary.PullRefreshLayout.this.vtH;
                    com.ylw.pullrefreshlibrary.PullRefreshLayout.this.refreshing = true;
                    if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onPullDownListener != null) {
                        com.ylw.pullrefreshlibrary.PullRefreshLayout.this.onPullDownListener.onRefresh();
                    }
                } else {
                    f3 = 0.0f;
                }
                if (com.ylw.pullrefreshlibrary.PullRefreshLayout.this.refreshing) {
                    com.ylw.pullrefreshlibrary.PullRefreshLayout.this.pullCallBack.onPullStateChange(2);
                } else {
                    com.ylw.pullrefreshlibrary.PullRefreshLayout.this.pullCallBack.onPullStateChange(0);
                }
                com.ylw.pullrefreshlibrary.PullRefreshLayout.this.mDragger.settleCapturedViewAt(0, (int) f3);
                com.ylw.pullrefreshlibrary.PullRefreshLayout.this.postInvalidate();
            }

            public int getViewVerticalDragRange(android.view.View view) {
                return com.ylw.pullrefreshlibrary.PullRefreshLayout.this.getMeasuredHeight();
            }
        });
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.mDragger.continueSettling(true)) {
            changePosition();
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changePosition() {
        int top = this.contentView.getTop();
        this.contentView.getBottom();
        this.contentTopPosition = top;
        android.view.View view = this.headView;
        androidx.core.view.ViewCompat.offsetTopAndBottom(view, top - view.getBottom());
        com.ylw.pullrefreshlibrary.PullRefreshLayout.IOnScrollListener iOnScrollListener = this.onScrollListener;
        if (iOnScrollListener != null) {
            iOnScrollListener.onScroll(this.contentView.getTop());
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(getMeasuredWidth()), com.up366.medialibrary.common.utils.PictureFileUtils.GB);
        int iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(getMeasuredHeight()), 0);
        int iMakeMeasureSpec3 = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(getMeasuredHeight()), com.up366.medialibrary.common.utils.PictureFileUtils.GB);
        this.contentView = getChildAt(1);
        measureChild(this.headView, iMakeMeasureSpec, iMakeMeasureSpec2);
        measureChild(this.contentView, iMakeMeasureSpec, iMakeMeasureSpec3);
        if (this.realContentView == null) {
            this.realContentView = this.contentView;
        }
        if (this.vtH == 0) {
            this.vtH = this.headView.getMeasuredHeight();
        }
        if (this.vcH == 0) {
            this.vcH = this.contentView.getMeasuredHeight();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        android.view.View view = this.contentView;
        int i5 = this.contentTopPosition;
        view.layout(0, i5, width, height + i5);
        android.view.View view2 = this.headView;
        int i6 = this.contentTopPosition;
        view2.layout(0, i6 - this.vtH, width, i6);
        if (this.waitRefreshing) {
            doRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPosition() {
        getWidth();
        getHeight();
        this.contentTopPosition = this.contentView.getTop();
        android.view.View view = this.contentView;
        androidx.core.view.ViewCompat.offsetTopAndBottom(view, -view.getTop());
        android.view.View view2 = this.headView;
        androidx.core.view.ViewCompat.offsetTopAndBottom(view2, 0 - view2.getBottom());
        com.ylw.pullrefreshlibrary.PullRefreshLayout.IOnScrollListener iOnScrollListener = this.onScrollListener;
        if (iOnScrollListener != null) {
            iOnScrollListener.onScroll(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.disallowIntercept = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.refreshing) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.disallowIntercept = false;
            this.downPosY = motionEvent.getY();
            this.downPosX = motionEvent.getX();
            this.hasCancel = false;
            this.contentView.dispatchTouchEvent(motionEvent);
            if (!this.disallowIntercept) {
                onInterceptTouchEvent(motionEvent);
            }
            return true;
        }
        if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY() - this.downPosY;
            float fAbs = java.lang.Math.abs(motionEvent.getX() - this.downPosX);
            if (this.pullCallBack.canPullDown() && y > this.mShakeSize && java.lang.Math.abs(y) > java.lang.Math.abs(fAbs)) {
                onTouchEvent(motionEvent);
                motionEvent.setAction(3);
                this.contentView.dispatchTouchEvent(motionEvent);
                this.hasCancel = true;
            } else if (!this.hasCancel) {
                this.contentView.dispatchTouchEvent(motionEvent);
            }
            return true;
        }
        onTouchEvent(motionEvent);
        try {
            this.contentView.dispatchTouchEvent(motionEvent);
        } catch (java.lang.Exception e) {
            android.util.Log.w(TAG, "dispatchTouchEvent: ", e);
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        this.mDragger.shouldInterceptTouchEvent(motionEvent);
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        this.mDragger.processTouchEvent(motionEvent);
        return false;
    }

    public void setOnScrollBottomListener(com.ylw.pullrefreshlibrary.PullRefreshLayout.OnScrollBottomListener onScrollBottomListener) {
        this.onScrollBottomListener = onScrollBottomListener;
    }

    public void setOnPullDownListener(com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener onPullDownListener) {
        this.onPullDownListener = onPullDownListener;
        this.enablePullDown = true;
    }

    public void setOnCompleteListener(com.ylw.pullrefreshlibrary.PullRefreshLayout.OnCompleteListener onCompleteListener) {
        this.onCompleteListener = onCompleteListener;
    }

    public void doRefresh(int i) {
        postDelayed(new java.lang.Runnable() { // from class: com.ylw.pullrefreshlibrary.PullRefreshLayout$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.doRefresh();
            }
        }, i);
    }

    public void doRefresh() {
        if (this.contentView == null) {
            this.waitRefreshing = true;
            return;
        }
        this.waitRefreshing = false;
        this.downRefreshing = true;
        this.refreshing = true;
        this.autoRefreshing = true;
        com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener onPullDownListener = this.onPullDownListener;
        if (onPullDownListener != null) {
            onPullDownListener.onRefresh();
        }
        this.pullCallBack.onPullStateChange(3);
        this.pullCallBack.onPullStateChange(0);
        this.pullCallBack.onPullStateChange(0, 1.0f);
        this.pullCallBack.onPullStateChange(1);
        this.pullCallBack.onPullStateChange(2);
        this.mDragger.captureChildView(this.contentView, 0);
        this.mDragger.smoothSlideViewTo(this.contentView, 0, this.vtH);
        postInvalidate();
    }

    public void complete() {
        if (this.downRefreshing) {
            toStep4();
            postDelayed(new java.lang.Runnable() { // from class: com.ylw.pullrefreshlibrary.PullRefreshLayout$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1392lambda$complete$0$comylwpullrefreshlibraryPullRefreshLayout();
                }
            }, 400L);
        }
    }

    /* JADX INFO: renamed from: lambda$complete$0$com-ylw-pullrefreshlibrary-PullRefreshLayout, reason: not valid java name */
    /* synthetic */ void m1392lambda$complete$0$comylwpullrefreshlibraryPullRefreshLayout() {
        this.mDragger.smoothSlideViewTo(this.contentView, 0, 0);
        postInvalidate();
        this.downRefreshing = false;
        this.autoRefreshing = false;
        this.refreshing = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getABSListScrollY(android.widget.AbsListView absListView) {
        if (absListView.getChildCount() == 0) {
            return 0;
        }
        int firstVisiblePosition = absListView.getFirstVisiblePosition();
        android.view.View childAt = absListView.getChildAt(0);
        return ((firstVisiblePosition * childAt.getHeight()) - childAt.getTop()) - absListView.getListPaddingTop();
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        try {
            return getContentViewComputeVerticalScrollOffset();
        } catch (java.lang.Exception unused) {
            return super.computeVerticalScrollOffset();
        }
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        try {
            return getContentViewComputeVerticalScrollRange();
        } catch (java.lang.Exception unused) {
            return super.computeVerticalScrollRange();
        }
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        try {
            return getContentViewComputeVerticalScrollExtent();
        } catch (java.lang.Exception unused) {
            return super.computeVerticalScrollExtent();
        }
    }

    private int getContentViewComputeVerticalScrollOffset() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        return ((java.lang.Integer) this.methodComputeVerticalScrollOffset.invoke(this.realContentView, null)).intValue();
    }

    private int getContentViewComputeVerticalScrollRange() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        return ((java.lang.Integer) this.methodComputeVerticalScrollRange.invoke(this.realContentView, null)).intValue();
    }

    private int getContentViewComputeVerticalScrollExtent() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        return ((java.lang.Integer) this.methodComputeVerticalScrollExtent.invoke(this.realContentView, null)).intValue();
    }

    private void toStep4() {
        android.util.Log.d(TAG, "toStep4: ==========");
        this.refreshView.toStep4(getContext());
    }

    public boolean isRefreshing() {
        return this.contentView.getTop() != 0;
    }

    public com.ylw.pullrefreshlibrary.refreshview.IRefreshView getRefreshView() {
        return this.refreshView;
    }

    public void setContentView(android.view.View view) {
        this.realContentView = view;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    public void setOnScrollListener(com.ylw.pullrefreshlibrary.PullRefreshLayout.IOnScrollListener iOnScrollListener) {
        this.onScrollListener = iOnScrollListener;
    }

    public void setContentPositionCallback(com.ylw.pullrefreshlibrary.PullRefreshLayout.IContentPositionCallback iContentPositionCallback) {
        this.contentPositionCallback = iContentPositionCallback;
    }
}
