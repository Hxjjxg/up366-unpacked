package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MainBottomTabView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.MainBottomViewLayoutBinding binding;

    public MainBottomTabView(android.content.Context context) {
        super(context);
        init(context);
    }

    public MainBottomTabView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MainBottomTabView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(android.content.Context context) {
        com.up366.mobile.databinding.MainBottomViewLayoutBinding mainBottomViewLayoutBinding = (com.up366.mobile.databinding.MainBottomViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(((android.app.Activity) context).getLayoutInflater(), com.up366.mobile.R.layout.main_bottom_view_layout, this, true);
        this.binding = mainBottomViewLayoutBinding;
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(mainBottomViewLayoutBinding.course, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.MainBottomTabView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OnBottomTabSelected(2));
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.schoolHouse, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.MainBottomTabView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OnBottomTabSelected(5));
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.user, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.MainBottomTabView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OnBottomTabSelected(3));
            }
        });
        initView(true);
    }

    private void initTabView() {
        if (com.up366.mobile.common.helper.UserFunAccreditHelper.INSTANCE.canUseFun(com.up366.mobile.common.helper.UserFunAccreditHelper.FUN_ID_SCHOOL_HOUSE)) {
            this.binding.schoolHouse.setVisibility(0);
        } else {
            this.binding.schoolHouse.setVisibility(8);
        }
    }

    private void initView(boolean z) {
        initTabView();
        if (com.up366.mobile.common.logic.Auth.isAuth()) {
            this.binding.user.setText(getShortRealName());
        } else {
            this.binding.user.setText("未登录");
        }
        if (z) {
            this.binding.course.setNumber(0);
            this.binding.schoolHouse.setNumber(0);
            this.binding.user.setNumber(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i), 0);
        int iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.main_bottom_view_tab_bar_height), 0);
        super.onMeasure(i, iMakeMeasureSpec2);
        setMeasuredDimension(iMakeMeasureSpec, iMakeMeasureSpec2);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.OnBottomTabSelected onBottomTabSelected) {
        com.up366.mobile.common.utils.ViewUtil.enable(this.binding.course, this.binding.schoolHouse, this.binding.user);
        int type = onBottomTabSelected.getType();
        if (type == 2) {
            com.up366.mobile.common.utils.ViewUtil.disable(this.binding.course);
            return;
        }
        if (type == 3) {
            com.up366.mobile.common.utils.ViewUtil.disable(this.binding.user);
        } else if (type == 5) {
            com.up366.mobile.common.utils.ViewUtil.disable(this.binding.schoolHouse);
        } else {
            throw new java.lang.IllegalStateException("unknown type " + onBottomTabSelected.getType());
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginSuccess authLoginSuccess) {
        initView(true);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginout authLoginout) {
        initView(true);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onUserFromNantong(com.up366.mobile.common.event.ThirdConfigUpdate thirdConfigUpdate) {
        initView(false);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.RefreshUserInfo refreshUserInfo) {
        initView(false);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.MeRealNameUpdateEvent meRealNameUpdateEvent) {
        initView(false);
    }

    private java.lang.String getShortRealName() {
        if (com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.common.logic.Auth.getUserInfo().getRealname())) {
            return "我";
        }
        java.lang.String[] strArrSplit = com.up366.mobile.common.logic.Auth.getUserInfo().getRealname().split("");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        for (java.lang.String str : strArrSplit) {
            if (i > 8) {
                break;
            }
            i = vd(str) ? i + 2 : i + 1;
            sb.append(str);
        }
        return sb.toString();
    }

    public boolean vd(java.lang.String str) {
        return java.util.regex.Pattern.compile("[一-龥]").matcher(str).find();
    }
}
