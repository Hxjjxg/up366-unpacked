package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CourseGrowthReportView extends android.widget.FrameLayout {
    private static final long ANIMATOR_DURATION = 250;
    private static final long ANIMATOR_TIME_SPAN = 5000;
    private static final int WHAT_KEY = 99;
    private com.up366.mobile.databinding.ItemCourseGrowthReportBinding b;
    private com.up366.mobile.course.task.model.GrowthReportCourse currentCourse;
    private android.animation.AnimatorSet firstAnimSet;
    private android.view.animation.Interpolator interpolator;
    private java.util.List<com.up366.mobile.course.task.model.GrowthReportCourse> mCourses;
    private android.os.Handler mHandler;
    private int mHeight;
    private android.animation.AnimatorSet secondAnimSet;

    public CourseGrowthReportView(android.content.Context context) {
        this(context, null);
    }

    public CourseGrowthReportView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CourseGrowthReportView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.interpolator = new android.view.animation.AccelerateDecelerateInterpolator();
        this.mHeight = com.up366.qmui.util.QMUIDisplayHelper.dpToPx(40);
        this.mHandler = new com.up366.mobile.common.views.CourseGrowthReportView.MyHandler(this);
        com.up366.mobile.databinding.ItemCourseGrowthReportBinding itemCourseGrowthReportBinding = (com.up366.mobile.databinding.ItemCourseGrowthReportBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.item_course_growth_report, this, true);
        this.b = itemCourseGrowthReportBinding;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = itemCourseGrowthReportBinding.flRoot;
        com.up366.mobile.common.utils.ShapeDrawableUtils shapeDrawableUtils = com.up366.mobile.common.utils.ShapeDrawableUtils.INSTANCE;
        constraintLayout.setBackground(com.up366.mobile.common.utils.ShapeDrawableUtils.createShapeDrawable(10, android.graphics.Color.parseColor("#FFFFF2F2")));
        initAnim();
    }

    public void setData(java.util.List<com.up366.mobile.course.task.model.GrowthReportCourse> list) {
        this.mCourses = list;
        this.currentCourse = list.get(0);
        this.b.tvFirst.setText(this.currentCourse.getTitle());
        if (this.mCourses.size() > 1) {
            sendMsg();
        }
        this.b.flRoot.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CourseGrowthReportView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setData$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$0(android.view.View view) {
        java.lang.String strReplace = com.up366.common.global.GB.get().getServerUrl("https://report.up366.cn/#/report-html/fe-listening-and-speaking-training-general-report-mobile?").replace(com.up366.mobile.cloud.PrivateCloudMgr.HTTP, "https://");
        try {
            java.lang.String str = "appType=mobile&courseName=" + java.net.URLEncoder.encode(this.currentCourse.getCourseName(), "UTF-8") + "&courseId=" + this.currentCourse.getCourseId() + "&bookId=" + this.currentCourse.getBookId() + "&client=student";
            android.content.Intent intent = new android.content.Intent(getContext(), (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("target", strReplace + str);
            intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
            intent.putExtra("exercise_type", com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.REDIRECT);
            getContext().startActivity(intent);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    private void resetNextCourse() {
        com.up366.mobile.course.task.model.GrowthReportCourse growthReportCourse = this.currentCourse;
        if (growthReportCourse == null) {
            this.currentCourse = this.mCourses.get(0);
        } else {
            int iIndexOf = this.mCourses.indexOf(growthReportCourse) + 1;
            this.currentCourse = this.mCourses.get(iIndexOf != this.mCourses.size() ? iIndexOf : 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsg() {
        if (this.mHandler.hasMessages(99)) {
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(99, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnim() {
        boolean z = this.b.tvFirst.getTranslationY() == 0.0f;
        resetNextCourse();
        if (z) {
            this.b.tvSecond.setText(this.currentCourse.getTitle());
            this.secondAnimSet.start();
        } else {
            this.b.tvFirst.setText(this.currentCourse.getTitle());
            this.firstAnimSet.start();
        }
    }

    private void initAnim() {
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.b.tvFirst, "translationY", this.mHeight, 0.0f);
        android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(this.b.tvSecond, "translationY", 0.0f, -this.mHeight);
        android.animation.AnimatorSet animatorSet = new android.animation.AnimatorSet();
        this.firstAnimSet = animatorSet;
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.firstAnimSet.setInterpolator(this.interpolator);
        this.firstAnimSet.setDuration(ANIMATOR_DURATION);
        this.firstAnimSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.up366.mobile.common.views.CourseGrowthReportView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.up366.mobile.common.views.CourseGrowthReportView.this.sendMsg();
            }
        });
        android.animation.ObjectAnimator objectAnimatorOfFloat3 = android.animation.ObjectAnimator.ofFloat(this.b.tvFirst, "translationY", 0.0f, -this.mHeight);
        android.animation.ObjectAnimator objectAnimatorOfFloat4 = android.animation.ObjectAnimator.ofFloat(this.b.tvSecond, "translationY", this.mHeight, 0.0f);
        android.animation.AnimatorSet animatorSet2 = new android.animation.AnimatorSet();
        this.secondAnimSet = animatorSet2;
        animatorSet2.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        this.secondAnimSet.setInterpolator(this.interpolator);
        this.secondAnimSet.setDuration(ANIMATOR_DURATION);
        this.secondAnimSet.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.up366.mobile.common.views.CourseGrowthReportView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.up366.mobile.common.views.CourseGrowthReportView.this.sendMsg();
            }
        });
    }

    private static class MyHandler extends android.os.Handler {
        private java.lang.ref.WeakReference<com.up366.mobile.common.views.CourseGrowthReportView> mView;

        public MyHandler(com.up366.mobile.common.views.CourseGrowthReportView courseGrowthReportView) {
            this.mView = new java.lang.ref.WeakReference<>(courseGrowthReportView);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.up366.mobile.common.views.CourseGrowthReportView courseGrowthReportView = this.mView.get();
            if (courseGrowthReportView == null || !courseGrowthReportView.isAttachedToWindow()) {
                return;
            }
            courseGrowthReportView.startAnim();
        }
    }
}
