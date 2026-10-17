package com.up366.mobile.me.teacherclass;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeTeachingClassActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.MeTearchingClassAcivityLayoutBinding binding;

    static /* synthetic */ void lambda$showExitDialog$2(android.view.View view) {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_class";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (com.up366.mobile.databinding.MeTearchingClassAcivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.me_tearching_class_acivity_layout);
        com.up366.qmui.util.QMUIStatusBarHelper.translucent((android.app.Activity) this);
        com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarLightMode(this);
        initView();
        initTabAndPager();
    }

    private void initView() {
        this.binding.addTeachingClass.setVisibility(com.up366.mobile.common.utils.PlatformUtils.isClosePad() ? 8 : 0);
        this.binding.addTeachingClass.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.teacherclass.MeTeachingClassActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$0(view);
            }
        });
        this.binding.exitClassBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.teacherclass.MeTeachingClassActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$1(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$0(android.view.View view) {
        com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity.openPage(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(android.view.View view) {
        showExitDialog();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showExitDialog() {
        com.up366.mobile.common.dialog.AppDialog.create(this).title("如何退出班级").messageTitle("同学你好，教学班不支持主动退出，不要轻言放弃哦～").message("若你加错班级需要退出，请联系你的老师或助教。").setMessageLeft().btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.teacherclass.MeTeachingClassActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.me.teacherclass.MeTeachingClassActivity.lambda$showExitDialog$2(view);
            }
        }).setBtnCloseVisibility(4).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initTabAndPager() {
        androidx.viewpager.widget.PagerAdapter meTeachingClassAdapter = new com.up366.mobile.me.teacherclass.MeTeachingClassAdapter(getSupportFragmentManager());
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.up366.mobile.me.teacherclass.OnGoingTeacherClassFragment());
        arrayList.add(new com.up366.mobile.me.teacherclass.FinishedTeacherClassFragment());
        meTeachingClassAdapter.setmFragments(arrayList);
        this.binding.contentViewPager.setAdapter(meTeachingClassAdapter);
        this.binding.contentViewPager.setCurrentItem(0, false);
        this.binding.contentViewPager.setScrollble(false);
        com.up366.qmui.widget.tab.QMUITabBuilder selectColor = this.binding.tabSegment.tabBuilder().setTypeface(android.graphics.Typeface.DEFAULT_BOLD, android.graphics.Typeface.DEFAULT_BOLD).setNormalColor(getResources().getColor(com.up366.mobile.R.color.c5)).setSelectColor(getResources().getColor(com.up366.mobile.R.color.font_c4));
        this.binding.tabSegment.addTab(selectColor.setText("进行中").build(this));
        this.binding.tabSegment.addTab(selectColor.setText("往期").build(this));
        int iDp2px = com.up366.qmui.util.QMUIDisplayHelper.dp2px(this, 20);
        com.up366.mobile.common.views.QMUITabIndicatorV2 qMUITabIndicatorV2 = new com.up366.mobile.common.views.QMUITabIndicatorV2();
        qMUITabIndicatorV2.setmIndicatorHeight(com.up366.qmui.util.QMUIDisplayHelper.dp2px(this, 12)).setmIndicatorWidth(com.up366.qmui.util.QMUIDisplayHelper.dp2px(this, 24)).setmIndicatorTop(false).setmIsIndicatorWidthFollowContent(false).setmFixedColorAttr(-1).setmShouldReGetFixedColor(false);
        this.binding.tabSegment.setIndicator(qMUITabIndicatorV2);
        this.binding.tabSegment.setMode(0);
        this.binding.tabSegment.setItemSpaceInScrollMode(iDp2px);
        this.binding.tabSegment.setupWithViewPager(this.binding.contentViewPager, false);
        this.binding.tabSegment.setPadding(iDp2px, 0, iDp2px, 0);
    }

    public com.up366.mobile.databinding.MeTearchingClassAcivityLayoutBinding getBinding() {
        return this.binding;
    }
}
