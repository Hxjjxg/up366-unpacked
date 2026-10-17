package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CourseBannerView extends android.widget.FrameLayout {
    private com.up366.mobile.common.views.CourseBannerView.InnerPicPagerAdapter adapter;
    private boolean autoScroll;
    private int autoSkipTime;
    private final com.up366.mobile.databinding.CourseBannerItemViewLayoutBinding b;
    private int curPosition;
    private android.os.CountDownTimer downTimer;
    private final androidx.viewpager.widget.ViewPager.OnPageChangeListener listener;
    private boolean timerStart;
    private int touchTime;

    public CourseBannerView(android.content.Context context) {
        this(context, null);
    }

    public CourseBannerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CourseBannerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.autoSkipTime = 510;
        this.timerStart = false;
        this.autoScroll = true;
        this.touchTime = 1;
        this.listener = new com.up366.mobile.common.views.CourseBannerView.AnonymousClass1();
        this.b = (com.up366.mobile.databinding.CourseBannerItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.course_banner_item_view_layout, this, true);
        init();
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.views.CourseBannerView$1, reason: invalid class name */
    class AnonymousClass1 extends androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener {
        private int gotoPage = -1;

        AnonymousClass1() {
        }

        public void onPageScrolled(int i, float f, int i2) {
            super.onPageScrolled(i, f, i2);
        }

        public void onPageSelected(int i) {
            com.up366.mobile.common.views.CourseBannerView.this.curPosition = i;
            if (com.up366.mobile.common.views.CourseBannerView.this.adapter == null || com.up366.mobile.common.views.CourseBannerView.this.adapter.getCount() <= 0) {
                return;
            }
            int count = com.up366.mobile.common.views.CourseBannerView.this.adapter.getCount();
            this.gotoPage = -1;
            if (count > 3) {
                if (i == 0) {
                    this.gotoPage = count - 2;
                } else if (i == count - 1) {
                    this.gotoPage = 1;
                }
            }
            if (this.gotoPage != -1) {
                com.up366.common.task.TaskUtils.postMainTaskDelay(com.up366.mobile.common.views.CourseBannerView.this.autoSkipTime, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.CourseBannerView$1$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        this.f$0.lambda$onPageSelected$0();
                    }
                });
            } else {
                com.up366.mobile.common.views.CourseBannerView.this.b.pointView.setPosition(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPageSelected$0() throws java.lang.Exception {
            com.up366.mobile.common.views.CourseBannerView.this.b.viewPager.setCurrentItem(this.gotoPage, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getContext(), new java.lang.Runnable() { // from class: com.up366.mobile.common.views.CourseBannerView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.common.helper.GuideDialogHelper.getInst().setBannerShowSuccess(true);
            }
        });
        com.up366.mobile.common.logic.Auth.cur().config().fetchBannerList(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.common.views.CourseBannerView$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$onAttachedToWindow$1(response, (java.util.List) obj);
            }
        });
        autoScroll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAttachedToWindow$1(com.up366.common.http.Response response, java.util.List list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!response.isError()) {
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                com.up366.mobile.common.logic.model.AppConfigBanner appConfigBanner = (com.up366.mobile.common.logic.model.AppConfigBanner) it.next();
                if (appConfigBanner.getType() == 0) {
                    arrayList.add(appConfigBanner);
                }
            }
        }
        initData(arrayList);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.up366.mobile.main.PromotionDiagramHelper.postDialogQueueTask(getContext(), new java.lang.Runnable() { // from class: com.up366.mobile.common.views.CourseBannerView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.common.helper.GuideDialogHelper.getInst().setBannerShowSuccess(false);
            }
        });
        stopTimer();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        this.touchTime = 0;
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (java.lang.Exception unused) {
            motionEvent.setAction(3);
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    private void init() {
        final float f = getResources().getDisplayMetrics().density;
        this.b.root.setClipToOutline(true);
        this.b.root.setOutlineProvider(new android.view.ViewOutlineProvider() { // from class: com.up366.mobile.common.views.CourseBannerView.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(android.view.View view, android.graphics.Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f * 10.0f);
            }
        });
        this.adapter = new com.up366.mobile.common.views.CourseBannerView.InnerPicPagerAdapter();
        this.b.viewPager.setAdapter(this.adapter);
        this.b.viewPager.addOnPageChangeListener(this.listener);
        this.b.viewPager.setOffscreenPageLimit(9);
        controlViewPagerSpeed(this.b.viewPager, 500);
        initData(new java.util.ArrayList());
        if (this.timerStart) {
            return;
        }
        this.timerStart = true;
    }

    private void addHeadEnd(java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        list.add(0, list.get(list.size() - 1));
        list.add(list.get(1));
    }

    private void controlViewPagerSpeed(androidx.viewpager.widget.ViewPager viewPager, int i) {
        try {
            java.lang.reflect.Field declaredField = androidx.viewpager.widget.ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            com.up366.mobile.common.views.rotationmap.FixedSpeedScroller fixedSpeedScroller = new com.up366.mobile.common.views.rotationmap.FixedSpeedScroller(getContext(), new android.view.animation.AccelerateDecelerateInterpolator());
            fixedSpeedScroller.setmDuration(i);
            declaredField.set(viewPager, fixedSpeedScroller);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("rotation map view controlViewPagerSpeed error " + e.getMessage(), e);
        }
    }

    private void initData(java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner> list) {
        addHeadEnd(list);
        this.adapter.setData(list);
        androidx.viewpager.widget.ViewPager viewPager = this.b.viewPager;
        int i = this.curPosition;
        if (i == 0) {
            i = 1;
        }
        viewPager.setCurrentItem(i, false);
        this.b.pointView.setCount(list.size());
        this.b.pointView.setHideHeadEnd(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNetwork() {
        com.up366.mobile.common.utils.DataPostDelay.doIfNoCache("checkNetwork", 1, new com.up366.mobile.common.views.CourseBannerView$$ExternalSyntheticLambda1());
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.views.CourseBannerView$3, reason: invalid class name */
    class AnonymousClass3 extends android.os.CountDownTimer {
        AnonymousClass3(long j, long j2) {
            super(j, j2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTick$0() throws java.lang.Exception {
            com.up366.mobile.common.views.CourseBannerView.this.checkNetwork();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            com.up366.common.task.TaskUtils.postLazyTaskGlobal("checkNetwork", new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.CourseBannerView$3$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onTick$0();
                }
            });
            if (com.up366.mobile.common.views.CourseBannerView.this.timerStart) {
                com.up366.mobile.common.views.CourseBannerView courseBannerView = com.up366.mobile.common.views.CourseBannerView.this;
                int i = courseBannerView.touchTime;
                courseBannerView.touchTime = i + 1;
                if (i < 1) {
                    return;
                }
                int currentItem = com.up366.mobile.common.views.CourseBannerView.this.b.viewPager.getCurrentItem() + 1;
                if (currentItem >= com.up366.mobile.common.views.CourseBannerView.this.adapter.getCount()) {
                    currentItem = 0;
                }
                if (!com.up366.mobile.common.views.CourseBannerView.this.autoScroll) {
                    com.up366.mobile.common.views.CourseBannerView.this.timerStart = false;
                } else {
                    com.up366.mobile.common.views.CourseBannerView.this.b.viewPager.setCurrentItem(currentItem, currentItem != 0);
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            com.up366.common.log.Logger.debug("onFinished ");
            com.up366.mobile.common.views.CourseBannerView.this.autoScroll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoScroll() {
        stopTimer();
        this.downTimer = new com.up366.mobile.common.views.CourseBannerView.AnonymousClass3(com.igexin.push.config.c.B, 3500L);
        com.up366.common.task.TaskUtils.postLazyTaskMain("course-banner-view", 3500, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.CourseBannerView$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$autoScroll$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$autoScroll$3() throws java.lang.Exception {
        android.os.CountDownTimer countDownTimer = this.downTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    private void stopTimer() {
        android.os.CountDownTimer countDownTimer = this.downTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.downTimer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class InnerPicPagerAdapter extends androidx.viewpager.widget.PagerAdapter {
        private final java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner> paths = new java.util.ArrayList();
        private final android.util.SparseArray<android.widget.ImageView> mapView = new android.util.SparseArray<>();

        public int getItemPosition(java.lang.Object obj) {
            return -2;
        }

        public boolean isViewFromObject(android.view.View view, java.lang.Object obj) {
            return view == obj;
        }

        InnerPicPagerAdapter() {
        }

        public int getCount() {
            return this.paths.size();
        }

        public void setData(java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner> list) {
            this.paths.clear();
            this.paths.addAll(list);
            notifyDataSetChanged();
        }

        public void destroyItem(android.view.ViewGroup viewGroup, int i, java.lang.Object obj) {
            viewGroup.removeView(this.mapView.get(i));
        }

        public java.lang.Object instantiateItem(android.view.ViewGroup viewGroup, final int i) {
            android.widget.ImageView imageView = this.mapView.get(i);
            if (imageView == null) {
                imageView = new androidx.appcompat.widget.AppCompatImageView(com.up366.mobile.common.views.CourseBannerView.this.getContext()) { // from class: com.up366.mobile.common.views.CourseBannerView.InnerPicPagerAdapter.1
                    final android.graphics.Path path = new android.graphics.Path();
                    final float dp = getResources().getDisplayMetrics().density;

                    protected void onDraw(android.graphics.Canvas canvas) {
                        canvas.save();
                        this.path.reset();
                        android.graphics.Path path = this.path;
                        float width = getWidth() + 1;
                        float height = getHeight();
                        float f = this.dp;
                        path.addRoundRect(0.0f, 0.0f, width, height, f * 10.0f, f * 10.0f, android.graphics.Path.Direction.CW);
                        canvas.clipPath(this.path);
                        super.onDraw(canvas);
                        canvas.restore();
                    }
                };
                imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                this.mapView.put(i, imageView);
            }
            com.up366.common.BitmapUtilsUp.display(imageView, this.paths.get(i).getResUrl(), com.up366.mobile.R.drawable.bg_course_banner);
            com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(imageView, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CourseBannerView$InnerPicPagerAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$instantiateItem$0(i, view);
                }
            });
            viewGroup.addView(imageView);
            return imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$instantiateItem$0(int i, android.view.View view) {
            if (this.paths.size() == 0 || this.paths.get(i) == null) {
                com.up366.common.log.Logger.error("paths is null ");
                return;
            }
            if (com.up366.common.StringUtils.isEmptyOrNull(this.paths.get(i).getForwordUrl())) {
                return;
            }
            com.up366.mobile.common.views.CourseBannerView courseBannerView = com.up366.mobile.common.views.CourseBannerView.this;
            java.lang.String strWrapUrlNavigationBar = courseBannerView.wrapUrlNavigationBar(courseBannerView.wrapUrlJsHideLoading(this.paths.get(i).getForwordUrl()));
            com.up366.mobile.common.onlinelog.OpLog.report("bannerSkip", strWrapUrlNavigationBar);
            com.up366.mobile.book.helper.Tools.openJSV8WebViewWithUrl((android.app.Activity) com.up366.mobile.common.views.CourseBannerView.this.getContext(), "", strWrapUrlNavigationBar, new com.alibaba.fastjson.JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String wrapUrlJsHideLoading(java.lang.String str) {
        if (str == null) {
            return null;
        }
        if (str.contains("js-hide-loading")) {
            return str;
        }
        if (str.contains("?")) {
            return str + "&js-hide-loading=0";
        }
        return str + "?js-hide-loading=0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String wrapUrlNavigationBar(java.lang.String str) {
        if (str == null) {
            return null;
        }
        if (str.contains("show-navigationbar")) {
            return str;
        }
        if (str.contains("?")) {
            return str + "&show-navigationbar=1";
        }
        return str + "?show-navigationbar=1";
    }
}
