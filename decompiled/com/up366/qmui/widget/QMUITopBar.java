package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUITopBar extends com.up366.qmui.layout.QMUIRelativeLayout implements com.up366.qmui.skin.IQMUISkinHandlerView, com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider {
    private static final int DEFAULT_VIEW_ID = -1;
    private static androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> sDefaultSkinAttrs;
    private android.view.View mCenterView;
    private boolean mIsBackgroundSetterDisabled;
    private int mLeftBackDrawableRes;
    private int mLeftLastViewId;
    private java.util.List<android.view.View> mLeftViewList;
    private int mRightLastViewId;
    private java.util.List<android.view.View> mRightViewList;
    private int mSubTitleTextColor;
    private int mSubTitleTextSize;
    private com.up366.qmui.qqface.QMUIQQFaceView mSubTitleView;
    private int mTitleContainerPaddingHor;
    private android.graphics.Rect mTitleContainerRect;
    private android.widget.LinearLayout mTitleContainerView;
    private int mTitleGravity;
    private int mTitleMarginHorWhenNoBtnAside;
    private int mTitleTextColor;
    private int mTitleTextSize;
    private int mTitleTextSizeWithSubTitle;
    private com.up366.qmui.qqface.QMUIQQFaceView mTitleView;
    private int mTopBarHeight;
    private int mTopBarImageBtnHeight;
    private int mTopBarImageBtnWidth;
    private com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider mTopBarImageColorTintColorProvider;
    private int mTopBarTextBtnPaddingHor;
    private android.content.res.ColorStateList mTopBarTextBtnTextColor;
    private int mTopBarTextBtnTextSize;
    private com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider mTopBarTextDefaultAttrProvider;

    static {
        androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap = new androidx.collection.SimpleArrayMap<>(4);
        sDefaultSkinAttrs = simpleArrayMap;
        simpleArrayMap.put(com.up366.qmui.skin.QMUISkinValueBuilder.BOTTOM_SEPARATOR, java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_topbar_separator_color));
        sDefaultSkinAttrs.put("background", java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_topbar_bg));
    }

    public QMUITopBar(android.content.Context context) {
        this(context, null);
    }

    public QMUITopBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUITopBarStyle);
    }

    public QMUITopBar(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTopBarHeight = -1;
        this.mIsBackgroundSetterDisabled = false;
        initVar();
        init(context, attributeSet, i);
    }

    private void initVar() {
        this.mLeftLastViewId = -1;
        this.mRightLastViewId = -1;
        this.mLeftViewList = new java.util.ArrayList();
        this.mRightViewList = new java.util.ArrayList();
    }

    void init(android.content.Context context, android.util.AttributeSet attributeSet) {
        init(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUITopBarStyle);
    }

    void init(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUITopBar, i, 0);
        this.mLeftBackDrawableRes = typedArrayObtainStyledAttributes.getResourceId(com.qmuiteam.qmui.R.styleable.QMUITopBar_qmui_topbar_left_back_drawable_id, com.qmuiteam.qmui.R.drawable.qmui_icon_topbar_back);
        this.mTitleGravity = typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUITopBar_qmui_topbar_title_gravity, 17);
        this.mTitleTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUITopBar_qmui_topbar_title_text_size, com.up366.qmui.util.QMUIDisplayHelper.sp2px(context, 17));
        this.mTitleTextSizeWithSubTitle = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUITopBar_qmui_topbar_title_text_size, com.up366.qmui.util.QMUIDisplayHelper.sp2px(context, 16));
        this.mSubTitleTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUITopBar_qmui_topbar_subtitle_text_size, com.up366.qmui.util.QMUIDisplayHelper.sp2px(context, 11));
        this.mTitleTextColor = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUITopBar_qmui_topbar_title_color, com.up366.qmui.util.QMUIResHelper.getAttrColor(context, com.qmuiteam.qmui.R.attr.qmui_config_color_gray_1));
        this.mSubTitleTextColor = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUITopBar_qmui_topbar_subtitle_color, com.up366.qmui.util.QMUIResHelper.getAttrColor(context, com.qmuiteam.qmui.R.attr.qmui_config_color_gray_4));
        this.mTitleMarginHorWhenNoBtnAside = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUITopBar_qmui_topbar_title_margin_horizontal_when_no_btn_aside, 0);
        this.mTitleContainerPaddingHor = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUITopBar_qmui_topbar_title_container_padding_horizontal, 0);
        this.mTopBarImageBtnWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUITopBar_qmui_topbar_image_btn_width, com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 48));
        this.mTopBarImageBtnHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUITopBar_qmui_topbar_image_btn_height, com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 48));
        this.mTopBarTextBtnPaddingHor = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUITopBar_qmui_topbar_text_btn_padding_horizontal, com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 12));
        this.mTopBarTextBtnTextColor = typedArrayObtainStyledAttributes.getColorStateList(com.qmuiteam.qmui.R.styleable.QMUITopBar_qmui_topbar_text_btn_color_state_list);
        this.mTopBarTextBtnTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUITopBar_qmui_topbar_text_btn_text_size, com.up366.qmui.util.QMUIDisplayHelper.sp2px(context, 16));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (android.view.ViewParent parent = getParent(); parent instanceof android.view.View; parent = parent.getParent()) {
            if (parent instanceof com.up366.qmui.widget.QMUICollapsingTopBarLayout) {
                makeSureTitleContainerView();
                return;
            }
        }
    }

    public void setCenterView(android.view.View view) {
        android.view.View view2 = this.mCenterView;
        if (view2 == view) {
            return;
        }
        if (view2 != null) {
            removeView(view2);
        }
        this.mCenterView = view;
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(13);
        addView(view, layoutParams);
    }

    public com.up366.qmui.qqface.QMUIQQFaceView setTitle(int i) {
        return setTitle(getContext().getString(i));
    }

    public com.up366.qmui.qqface.QMUIQQFaceView setTitle(java.lang.String str) {
        com.up366.qmui.qqface.QMUIQQFaceView titleView = getTitleView();
        titleView.setText(str);
        if (com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(str)) {
            titleView.setVisibility(8);
        } else {
            titleView.setVisibility(0);
        }
        return titleView;
    }

    public java.lang.CharSequence getTitle() {
        com.up366.qmui.qqface.QMUIQQFaceView qMUIQQFaceView = this.mTitleView;
        if (qMUIQQFaceView == null) {
            return null;
        }
        return qMUIQQFaceView.getText();
    }

    public void showTitleView(boolean z) {
        com.up366.qmui.qqface.QMUIQQFaceView qMUIQQFaceView = this.mTitleView;
        if (qMUIQQFaceView != null) {
            qMUIQQFaceView.setVisibility(z ? 0 : 8);
        }
    }

    private com.up366.qmui.qqface.QMUIQQFaceView getTitleView() {
        if (this.mTitleView == null) {
            com.up366.qmui.qqface.QMUIQQFaceView qMUIQQFaceView = new com.up366.qmui.qqface.QMUIQQFaceView(getContext());
            this.mTitleView = qMUIQQFaceView;
            qMUIQQFaceView.setGravity(17);
            this.mTitleView.setSingleLine(true);
            this.mTitleView.setEllipsize(android.text.TextUtils.TruncateAt.MIDDLE);
            this.mTitleView.setTextColor(this.mTitleTextColor);
            com.up366.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider qMUISkinSimpleDefaultAttrProvider = new com.up366.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider();
            qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COLOR, com.qmuiteam.qmui.R.attr.qmui_skin_support_topbar_title_color);
            this.mTitleView.setTag(com.qmuiteam.qmui.R.id.qmui_skin_default_attr_provider, qMUISkinSimpleDefaultAttrProvider);
            updateTitleViewStyle();
            makeSureTitleContainerView().addView(this.mTitleView, generateTitleViewAndSubTitleViewLp());
        }
        return this.mTitleView;
    }

    private void updateTitleViewStyle() {
        if (this.mTitleView != null) {
            com.up366.qmui.qqface.QMUIQQFaceView qMUIQQFaceView = this.mSubTitleView;
            if (qMUIQQFaceView == null || com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(qMUIQQFaceView.getText())) {
                this.mTitleView.setTextSize(this.mTitleTextSize);
            } else {
                this.mTitleView.setTextSize(this.mTitleTextSizeWithSubTitle);
            }
        }
    }

    public com.up366.qmui.qqface.QMUIQQFaceView setSubTitle(java.lang.String str) {
        com.up366.qmui.qqface.QMUIQQFaceView subTitleView = getSubTitleView();
        subTitleView.setText(str);
        if (com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(str)) {
            subTitleView.setVisibility(8);
        } else {
            subTitleView.setVisibility(0);
        }
        updateTitleViewStyle();
        return subTitleView;
    }

    public com.up366.qmui.qqface.QMUIQQFaceView setSubTitle(int i) {
        return setSubTitle(getResources().getString(i));
    }

    private com.up366.qmui.qqface.QMUIQQFaceView getSubTitleView() {
        if (this.mSubTitleView == null) {
            com.up366.qmui.qqface.QMUIQQFaceView qMUIQQFaceView = new com.up366.qmui.qqface.QMUIQQFaceView(getContext());
            this.mSubTitleView = qMUIQQFaceView;
            qMUIQQFaceView.setGravity(17);
            this.mSubTitleView.setSingleLine(true);
            this.mSubTitleView.setEllipsize(android.text.TextUtils.TruncateAt.MIDDLE);
            this.mSubTitleView.setTextSize(this.mSubTitleTextSize);
            this.mSubTitleView.setTextColor(this.mSubTitleTextColor);
            com.up366.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider qMUISkinSimpleDefaultAttrProvider = new com.up366.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider();
            qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COLOR, com.qmuiteam.qmui.R.attr.qmui_skin_support_topbar_subtitle_color);
            this.mSubTitleView.setTag(com.qmuiteam.qmui.R.id.qmui_skin_default_attr_provider, qMUISkinSimpleDefaultAttrProvider);
            android.widget.LinearLayout.LayoutParams layoutParamsGenerateTitleViewAndSubTitleViewLp = generateTitleViewAndSubTitleViewLp();
            layoutParamsGenerateTitleViewAndSubTitleViewLp.topMargin = com.up366.qmui.util.QMUIDisplayHelper.dp2px(getContext(), 1);
            makeSureTitleContainerView().addView(this.mSubTitleView, layoutParamsGenerateTitleViewAndSubTitleViewLp);
        }
        return this.mSubTitleView;
    }

    public void setTitleGravity(int i) {
        this.mTitleGravity = i;
        com.up366.qmui.qqface.QMUIQQFaceView qMUIQQFaceView = this.mTitleView;
        if (qMUIQQFaceView != null) {
            ((android.widget.LinearLayout.LayoutParams) qMUIQQFaceView.getLayoutParams()).gravity = i;
            if (i == 17 || i == 1) {
                this.mTitleView.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingLeft(), getPaddingBottom());
            }
        }
        com.up366.qmui.qqface.QMUIQQFaceView qMUIQQFaceView2 = this.mSubTitleView;
        if (qMUIQQFaceView2 != null) {
            ((android.widget.LinearLayout.LayoutParams) qMUIQQFaceView2.getLayoutParams()).gravity = i;
        }
        requestLayout();
    }

    public android.graphics.Rect getTitleContainerRect() {
        if (this.mTitleContainerRect == null) {
            this.mTitleContainerRect = new android.graphics.Rect();
        }
        android.widget.LinearLayout linearLayout = this.mTitleContainerView;
        if (linearLayout == null) {
            this.mTitleContainerRect.set(0, 0, 0, 0);
        } else {
            com.up366.qmui.util.QMUIViewHelper.getDescendantRect(this, linearLayout, this.mTitleContainerRect);
        }
        return this.mTitleContainerRect;
    }

    public android.widget.LinearLayout getTitleContainerView() {
        return this.mTitleContainerView;
    }

    void disableBackgroundSetter() {
        this.mIsBackgroundSetterDisabled = true;
        super.setBackgroundDrawable(null);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(android.graphics.drawable.Drawable drawable) {
        if (this.mIsBackgroundSetterDisabled) {
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    private android.widget.LinearLayout makeSureTitleContainerView() {
        if (this.mTitleContainerView == null) {
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(getContext());
            this.mTitleContainerView = linearLayout;
            linearLayout.setOrientation(1);
            this.mTitleContainerView.setGravity(17);
            android.widget.LinearLayout linearLayout2 = this.mTitleContainerView;
            int i = this.mTitleContainerPaddingHor;
            linearLayout2.setPadding(i, 0, i, 0);
            addView(this.mTitleContainerView, generateTitleContainerViewLp());
        }
        return this.mTitleContainerView;
    }

    private android.widget.RelativeLayout.LayoutParams generateTitleContainerViewLp() {
        return new android.widget.RelativeLayout.LayoutParams(-1, com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_topbar_height));
    }

    private android.widget.LinearLayout.LayoutParams generateTitleViewAndSubTitleViewLp() {
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = this.mTitleGravity;
        return layoutParams;
    }

    public void addLeftView(android.view.View view, int i) {
        android.widget.RelativeLayout.LayoutParams layoutParams;
        android.view.ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null && (layoutParams2 instanceof android.widget.RelativeLayout.LayoutParams)) {
            layoutParams = (android.widget.RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        }
        addLeftView(view, i, layoutParams);
    }

    public void addLeftView(android.view.View view, int i, android.widget.RelativeLayout.LayoutParams layoutParams) {
        int i2 = this.mLeftLastViewId;
        if (i2 == -1) {
            layoutParams.addRule(9);
        } else {
            layoutParams.addRule(1, i2);
        }
        layoutParams.alignWithParent = true;
        this.mLeftLastViewId = i;
        view.setId(i);
        this.mLeftViewList.add(view);
        addView(view, layoutParams);
    }

    public void addRightView(android.view.View view, int i) {
        android.widget.RelativeLayout.LayoutParams layoutParams;
        android.view.ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null && (layoutParams2 instanceof android.widget.RelativeLayout.LayoutParams)) {
            layoutParams = (android.widget.RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        }
        addRightView(view, i, layoutParams);
    }

    public void addRightView(android.view.View view, int i, android.widget.RelativeLayout.LayoutParams layoutParams) {
        int i2 = this.mRightLastViewId;
        if (i2 == -1) {
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(0, i2);
        }
        layoutParams.alignWithParent = true;
        this.mRightLastViewId = i;
        view.setId(i);
        this.mRightViewList.add(view);
        addView(view, layoutParams);
    }

    public android.widget.RelativeLayout.LayoutParams generateTopBarImageButtonLayoutParams() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(this.mTopBarImageBtnWidth, this.mTopBarImageBtnHeight);
        layoutParams.topMargin = java.lang.Math.max(0, (getTopBarHeight() - this.mTopBarImageBtnHeight) / 2);
        return layoutParams;
    }

    public com.up366.qmui.alpha.QMUIAlphaImageButton addRightImageButton(int i, int i2) {
        return addRightImageButton(i, true, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.up366.qmui.alpha.QMUIAlphaImageButton] */
    public com.up366.qmui.alpha.QMUIAlphaImageButton addRightImageButton(int i, boolean z, int i2) {
        ?? GenerateTopBarImageButton = generateTopBarImageButton(i, z);
        addRightView(GenerateTopBarImageButton, i2, generateTopBarImageButtonLayoutParams());
        return GenerateTopBarImageButton;
    }

    public com.up366.qmui.alpha.QMUIAlphaImageButton addLeftImageButton(int i, int i2) {
        return addLeftImageButton(i, true, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View, com.up366.qmui.alpha.QMUIAlphaImageButton] */
    public com.up366.qmui.alpha.QMUIAlphaImageButton addLeftImageButton(int i, boolean z, int i2) {
        ?? GenerateTopBarImageButton = generateTopBarImageButton(i, z);
        addLeftView(GenerateTopBarImageButton, i2, generateTopBarImageButtonLayoutParams());
        return GenerateTopBarImageButton;
    }

    public android.widget.RelativeLayout.LayoutParams generateTopBarTextButtonLayoutParams() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, this.mTopBarImageBtnHeight);
        layoutParams.topMargin = java.lang.Math.max(0, (getTopBarHeight() - this.mTopBarImageBtnHeight) / 2);
        return layoutParams;
    }

    public android.widget.Button addLeftTextButton(int i, int i2) {
        return addLeftTextButton(getResources().getString(i), i2);
    }

    public android.widget.Button addLeftTextButton(java.lang.String str, int i) {
        android.widget.Button buttonGenerateTopBarTextButton = generateTopBarTextButton(str);
        addLeftView(buttonGenerateTopBarTextButton, i, generateTopBarTextButtonLayoutParams());
        return buttonGenerateTopBarTextButton;
    }

    public android.widget.Button addRightTextButton(int i, int i2) {
        return addRightTextButton(getResources().getString(i), i2);
    }

    public android.widget.Button addRightTextButton(java.lang.String str, int i) {
        android.widget.Button buttonGenerateTopBarTextButton = generateTopBarTextButton(str);
        addRightView(buttonGenerateTopBarTextButton, i, generateTopBarTextButtonLayoutParams());
        return buttonGenerateTopBarTextButton;
    }

    private android.widget.Button generateTopBarTextButton(java.lang.String str) {
        android.widget.Button button = new android.widget.Button(getContext());
        if (this.mTopBarTextDefaultAttrProvider == null) {
            com.up366.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider qMUISkinSimpleDefaultAttrProvider = new com.up366.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider();
            qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COLOR, com.qmuiteam.qmui.R.attr.qmui_skin_support_topbar_text_btn_color_state_list);
            this.mTopBarTextDefaultAttrProvider = qMUISkinSimpleDefaultAttrProvider;
        }
        button.setTag(com.qmuiteam.qmui.R.id.qmui_skin_default_attr_provider, this.mTopBarTextDefaultAttrProvider);
        button.setBackgroundResource(0);
        button.setMinWidth(0);
        button.setMinHeight(0);
        button.setMinimumWidth(0);
        button.setMinimumHeight(0);
        int i = this.mTopBarTextBtnPaddingHor;
        button.setPadding(i, 0, i, 0);
        button.setTextColor(this.mTopBarTextBtnTextColor);
        button.setTextSize(0, this.mTopBarTextBtnTextSize);
        button.setGravity(17);
        button.setText(str);
        return button;
    }

    private com.up366.qmui.alpha.QMUIAlphaImageButton generateTopBarImageButton(int i, boolean z) {
        com.up366.qmui.alpha.QMUIAlphaImageButton qMUIAlphaImageButton = new com.up366.qmui.alpha.QMUIAlphaImageButton(getContext());
        if (z) {
            if (this.mTopBarImageColorTintColorProvider == null) {
                com.up366.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider qMUISkinSimpleDefaultAttrProvider = new com.up366.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider();
                qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(com.up366.qmui.skin.QMUISkinValueBuilder.TINT_COLOR, com.qmuiteam.qmui.R.attr.qmui_skin_support_topbar_image_tint_color);
                this.mTopBarImageColorTintColorProvider = qMUISkinSimpleDefaultAttrProvider;
            }
            qMUIAlphaImageButton.setTag(com.qmuiteam.qmui.R.id.qmui_skin_default_attr_provider, this.mTopBarImageColorTintColorProvider);
        }
        qMUIAlphaImageButton.setBackgroundColor(0);
        qMUIAlphaImageButton.setImageResource(i);
        return qMUIAlphaImageButton;
    }

    public com.up366.qmui.alpha.QMUIAlphaImageButton addLeftBackImageButton() {
        return addLeftImageButton(this.mLeftBackDrawableRes, com.qmuiteam.qmui.R.id.qmui_topbar_item_left_back);
    }

    public void removeAllLeftViews() {
        java.util.Iterator<android.view.View> it = this.mLeftViewList.iterator();
        while (it.hasNext()) {
            removeView(it.next());
        }
        this.mLeftLastViewId = -1;
        this.mLeftViewList.clear();
    }

    public void removeAllRightViews() {
        java.util.Iterator<android.view.View> it = this.mRightViewList.iterator();
        while (it.hasNext()) {
            removeView(it.next());
        }
        this.mRightLastViewId = -1;
        this.mRightViewList.clear();
    }

    public void removeCenterViewAndTitleView() {
        android.view.View view = this.mCenterView;
        if (view != null) {
            if (view.getParent() == this) {
                removeView(this.mCenterView);
            }
            this.mCenterView = null;
        }
        com.up366.qmui.qqface.QMUIQQFaceView qMUIQQFaceView = this.mTitleView;
        if (qMUIQQFaceView != null) {
            if (qMUIQQFaceView.getParent() == this) {
                removeView(this.mTitleView);
            }
            this.mTitleView = null;
        }
    }

    int getTopBarHeight() {
        if (this.mTopBarHeight == -1) {
            this.mTopBarHeight = com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_topbar_height);
        }
        return this.mTopBarHeight;
    }

    public void setBackgroundAlpha(int i) {
        getBackground().mutate().setAlpha(i);
    }

    public int computeAndSetBackgroundAlpha(int i, int i2, int i3) {
        int iMax = (int) (java.lang.Math.max(0.0d, java.lang.Math.min((i - i2) / (i3 - i2), 1.0d)) * 255.0d);
        setBackgroundAlpha(iMax);
        return iMax;
    }

    @Override // com.up366.qmui.layout.QMUIRelativeLayout, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size;
        super.onMeasure(i, i2);
        if (this.mTitleContainerView != null) {
            int paddingLeft = getPaddingLeft();
            for (int i3 = 0; i3 < this.mLeftViewList.size(); i3++) {
                android.view.View view = this.mLeftViewList.get(i3);
                if (view.getVisibility() != 8) {
                    paddingLeft += view.getMeasuredWidth();
                }
            }
            int paddingRight = getPaddingRight();
            for (int i4 = 0; i4 < this.mRightViewList.size(); i4++) {
                android.view.View view2 = this.mRightViewList.get(i4);
                if (view2.getVisibility() != 8) {
                    paddingRight += view2.getMeasuredWidth();
                }
            }
            int iMax = java.lang.Math.max(this.mTitleMarginHorWhenNoBtnAside, paddingLeft);
            int iMax2 = java.lang.Math.max(this.mTitleMarginHorWhenNoBtnAside, paddingRight);
            if ((this.mTitleGravity & 7) == 1) {
                size = android.view.View.MeasureSpec.getSize(i) - (java.lang.Math.max(iMax, iMax2) * 2);
            } else {
                size = (android.view.View.MeasureSpec.getSize(i) - iMax) - iMax2;
            }
            this.mTitleContainerView.measure(android.view.View.MeasureSpec.makeMeasureSpec(size, com.up366.medialibrary.common.utils.PictureFileUtils.GB), i2);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iMax;
        super.onLayout(z, i, i2, i3, i4);
        android.widget.LinearLayout linearLayout = this.mTitleContainerView;
        if (linearLayout != null) {
            int measuredWidth = linearLayout.getMeasuredWidth();
            int measuredHeight = this.mTitleContainerView.getMeasuredHeight();
            int measuredHeight2 = ((i4 - i2) - this.mTitleContainerView.getMeasuredHeight()) / 2;
            int paddingLeft = getPaddingLeft();
            if ((this.mTitleGravity & 7) == 1) {
                iMax = ((i3 - i) - this.mTitleContainerView.getMeasuredWidth()) / 2;
            } else {
                for (int i5 = 0; i5 < this.mLeftViewList.size(); i5++) {
                    android.view.View view = this.mLeftViewList.get(i5);
                    if (view.getVisibility() != 8) {
                        paddingLeft += view.getMeasuredWidth();
                    }
                }
                iMax = java.lang.Math.max(paddingLeft, this.mTitleMarginHorWhenNoBtnAside);
            }
            this.mTitleContainerView.layout(iMax, measuredHeight2, measuredWidth + iMax, measuredHeight + measuredHeight2);
        }
    }

    @Override // com.up366.qmui.skin.IQMUISkinHandlerView
    public void handle(com.up366.qmui.skin.QMUISkinManager qMUISkinManager, int i, android.content.res.Resources.Theme theme, androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap) {
        if (simpleArrayMap != null) {
            for (int i2 = 0; i2 < simpleArrayMap.size(); i2++) {
                java.lang.String str = (java.lang.String) simpleArrayMap.keyAt(i2);
                java.lang.Integer num = (java.lang.Integer) simpleArrayMap.valueAt(i2);
                if (num != null && (!(getParent() instanceof com.up366.qmui.widget.QMUITopBarLayout) || (!"background".equals(str) && !com.up366.qmui.skin.QMUISkinValueBuilder.BOTTOM_SEPARATOR.equals(str)))) {
                    qMUISkinManager.defaultHandleSkinAttr(this, theme, str, num.intValue());
                }
            }
        }
    }

    @Override // com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> getDefaultSkinAttrs() {
        return sDefaultSkinAttrs;
    }
}
