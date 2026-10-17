package com.up366.mobile.common.views.rotationmap;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RotationMapView extends android.widget.FrameLayout {
    private com.up366.mobile.common.views.rotationmap.RotationMapView.InnerPicPagerAdapter adapter;
    private boolean autoScroll;
    private int autoSkipTime;
    private int curPosition;
    private float imageRadius;
    private androidx.viewpager.widget.ViewPager.OnPageChangeListener listener;
    private androidx.viewpager.widget.ViewPager picViewPager;
    private com.up366.mobile.common.views.rotationmap.RotationMapCirclePointView pointView;
    private boolean timerStart;
    private int touchTime;

    /* JADX INFO: renamed from: com.up366.mobile.common.views.rotationmap.RotationMapView$1, reason: invalid class name */
    class AnonymousClass1 extends androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener {
        private int gotoPage = -1;

        AnonymousClass1() {
        }

        public void onPageScrolled(int i, float f, int i2) {
            super.onPageScrolled(i, f, i2);
        }

        public void onPageSelected(int i) {
            com.up366.mobile.common.views.rotationmap.RotationMapView.this.curPosition = i;
            if (com.up366.mobile.common.views.rotationmap.RotationMapView.this.adapter == null || com.up366.mobile.common.views.rotationmap.RotationMapView.this.adapter.getCount() <= 0) {
                return;
            }
            int count = com.up366.mobile.common.views.rotationmap.RotationMapView.this.adapter.getCount();
            this.gotoPage = -1;
            if (count > 3) {
                if (i == 0) {
                    this.gotoPage = count - 2;
                } else if (i == count - 1) {
                    this.gotoPage = 1;
                }
            }
            if (this.gotoPage != -1) {
                com.up366.common.task.TaskUtils.postMainTaskDelay(com.up366.mobile.common.views.rotationmap.RotationMapView.this.autoSkipTime, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.rotationmap.RotationMapView$1$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        this.f$0.lambda$onPageSelected$0();
                    }
                });
            } else {
                com.up366.mobile.common.views.rotationmap.RotationMapView.this.pointView.setPosition(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPageSelected$0() throws java.lang.Exception {
            com.up366.mobile.common.views.rotationmap.RotationMapView.this.picViewPager.setCurrentItem(this.gotoPage, false);
        }
    }

    public RotationMapView(android.content.Context context) {
        this(context, null);
    }

    public RotationMapView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotationMapView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.autoSkipTime = 510;
        this.timerStart = false;
        this.autoScroll = true;
        this.touchTime = 1;
        this.listener = new com.up366.mobile.common.views.rotationmap.RotationMapView.AnonymousClass1();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.RotationMapView);
        if (typedArrayObtainStyledAttributes != null) {
            this.imageRadius = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        }
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.mobile.common.logic.Auth.cur().config().fetchBannerList(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.common.views.rotationmap.RotationMapView$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$onAttachedToWindow$0(response, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAttachedToWindow$0(com.up366.common.http.Response response, java.util.List list) {
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
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        this.touchTime = 0;
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        android.view.View.inflate(getContext(), com.up366.mobile.R.layout.views_rotation_map_layout, this);
        if (isInEditMode()) {
            return;
        }
        this.adapter = new com.up366.mobile.common.views.rotationmap.RotationMapView.InnerPicPagerAdapter();
        androidx.viewpager.widget.ViewPager viewPagerFindViewById = findViewById(com.up366.mobile.R.id.rotation_map_pics_pager);
        this.picViewPager = viewPagerFindViewById;
        viewPagerFindViewById.setAdapter(this.adapter);
        this.picViewPager.addOnPageChangeListener(this.listener);
        this.picViewPager.setOffscreenPageLimit(9);
        controlViewPagerSpeed(this.picViewPager, 500);
        this.pointView = (com.up366.mobile.common.views.rotationmap.RotationMapCirclePointView) findViewById(com.up366.mobile.R.id.rotation_map_point_view);
        initData(new java.util.ArrayList());
        if (this.timerStart) {
            return;
        }
        this.timerStart = true;
        autoScroll();
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
        androidx.viewpager.widget.ViewPager viewPager = this.picViewPager;
        int i = this.curPosition;
        if (i == 0) {
            i = 1;
        }
        viewPager.setCurrentItem(i);
        this.pointView.setCount(list.size());
        this.pointView.setHideHeadEnd(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNetwork() {
        com.up366.mobile.common.utils.DataPostDelay.doIfNoCache("checkNetwork", 1, new com.up366.mobile.common.views.CourseBannerView$$ExternalSyntheticLambda1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoScroll() {
        new android.os.CountDownTimer(com.igexin.push.config.c.B, 3500L) { // from class: com.up366.mobile.common.views.rotationmap.RotationMapView.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                com.up366.mobile.common.views.rotationmap.RotationMapView.this.checkNetwork();
                if (com.up366.mobile.common.views.rotationmap.RotationMapView.this.timerStart) {
                    com.up366.mobile.common.views.rotationmap.RotationMapView rotationMapView = com.up366.mobile.common.views.rotationmap.RotationMapView.this;
                    int i = rotationMapView.touchTime;
                    rotationMapView.touchTime = i + 1;
                    if (i < 1) {
                        return;
                    }
                    int currentItem = com.up366.mobile.common.views.rotationmap.RotationMapView.this.picViewPager.getCurrentItem() + 1;
                    if (currentItem >= com.up366.mobile.common.views.rotationmap.RotationMapView.this.adapter.getCount()) {
                        currentItem = 0;
                    }
                    if (!com.up366.mobile.common.views.rotationmap.RotationMapView.this.autoScroll) {
                        com.up366.mobile.common.views.rotationmap.RotationMapView.this.timerStart = false;
                    } else {
                        com.up366.mobile.common.views.rotationmap.RotationMapView.this.picViewPager.setCurrentItem(currentItem, currentItem != 0);
                    }
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                com.up366.common.log.Logger.debug("onFinished ");
                com.up366.mobile.common.views.rotationmap.RotationMapView.this.autoScroll();
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    class InnerPicPagerAdapter extends androidx.viewpager.widget.PagerAdapter {
        private java.util.List<com.up366.mobile.common.logic.model.AppConfigBanner> paths = new java.util.ArrayList();
        private android.util.SparseArray<com.up366.mobile.common.views.RoundImageView> mapView = new android.util.SparseArray<>();

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
            this.mapView.clear();
            notifyDataSetChanged();
        }

        public void destroyItem(android.view.ViewGroup viewGroup, int i, java.lang.Object obj) {
            viewGroup.removeView((android.view.View) this.mapView.get(i));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [android.view.View, android.widget.ImageView, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r4v0, types: [android.view.ViewGroup] */
        public java.lang.Object instantiateItem(android.view.ViewGroup viewGroup, final int i) {
            com.up366.mobile.common.views.RoundImageView roundImageView = this.mapView.get(i);
            ?? r0 = roundImageView;
            if (roundImageView == null) {
                com.up366.mobile.common.views.RoundImageView roundImageView2 = new com.up366.mobile.common.views.RoundImageView(com.up366.mobile.common.views.rotationmap.RotationMapView.this.getContext());
                roundImageView2.setCornerRadius(com.up366.mobile.common.views.rotationmap.RotationMapView.this.imageRadius);
                roundImageView2.setAliasColor(android.R.color.transparent);
                roundImageView2.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                this.mapView.put(i, roundImageView2);
                r0 = roundImageView2;
            }
            com.up366.common.BitmapUtilsUp.display(r0, this.paths.get(i).getResUrl(), com.up366.mobile.R.drawable.default_book3);
            com.up366.mobile.common.utils.ViewUtil.bindOnClickListener((android.view.View) r0, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.rotationmap.RotationMapView$InnerPicPagerAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$instantiateItem$0(i, view);
                }
            });
            viewGroup.addView(r0);
            return r0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$instantiateItem$0(int i, android.view.View view) {
            if (this.paths.size() == 0 || this.paths.get(i) == null) {
                com.up366.common.log.Logger.error("paths is null ");
            } else {
                if (com.up366.common.StringUtils.isEmptyOrNull(this.paths.get(i).getForwordUrl())) {
                    return;
                }
                com.up366.mobile.common.onlinelog.OpLog.report("rotation_map_click", this.paths.get(i).getForwordUrl());
                android.content.Intent intent = new android.content.Intent(com.up366.mobile.common.views.rotationmap.RotationMapView.this.getContext(), (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
                intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, this.paths.get(i).getForwordUrl());
                com.up366.mobile.common.views.rotationmap.RotationMapView.this.getContext().startActivity(intent);
            }
        }
    }
}
