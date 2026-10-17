package com.up366.qmui.widget.grouplist;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUICommonListItemView extends com.up366.qmui.layout.QMUIConstraintLayout {
    public static final int ACCESSORY_TYPE_CHEVRON = 1;
    public static final int ACCESSORY_TYPE_CUSTOM = 3;
    public static final int ACCESSORY_TYPE_NONE = 0;
    public static final int ACCESSORY_TYPE_SWITCH = 2;
    public static final int HORIZONTAL = 1;
    public static final int TIP_POSITION_LEFT = 0;
    public static final int TIP_POSITION_RIGHT = 1;
    private static final int TIP_SHOW_NEW = 2;
    private static final int TIP_SHOW_NOTHING = 0;
    private static final int TIP_SHOW_RED_POINT = 1;
    public static final int VERTICAL = 0;
    private int mAccessoryType;
    private android.view.ViewGroup mAccessoryView;
    private androidx.constraintlayout.widget.Placeholder mAfterTitleHolder;
    private androidx.constraintlayout.widget.Placeholder mBeforeAccessoryHolder;
    protected android.widget.TextView mDetailTextView;
    private boolean mDisableSwitchSelf;
    protected android.widget.ImageView mImageView;
    private android.widget.ImageView mNewTipView;
    private int mOrientation;
    private android.widget.ImageView mRedDot;
    protected android.widget.CheckBox mSwitch;
    protected android.widget.TextView mTextView;
    private int mTipPosition;
    private int mTipShown;

    public interface LayoutParamConfig {
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams onConfig(androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface QMUICommonListItemAccessoryType {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface QMUICommonListItemOrientation {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface QMUICommonListItemTipPosition {
    }

    public static class SkinConfig {
        public int iconTintColorRes = com.qmuiteam.qmui.R.attr.qmui_skin_support_common_list_icon_tint_color;
        public int iconSrcRes = 0;
        public int titleTextColorRes = com.qmuiteam.qmui.R.attr.qmui_skin_support_common_list_title_color;
        public int detailTextColorRes = com.qmuiteam.qmui.R.attr.qmui_skin_support_common_list_detail_color;
        public int newTipSrcRes = com.qmuiteam.qmui.R.attr.qmui_skin_support_common_list_new_drawable;
        public int tipDotColorRes = com.qmuiteam.qmui.R.attr.qmui_skin_support_common_list_red_point_tint_color;
    }

    public QMUICommonListItemView(android.content.Context context) {
        this(context, null);
    }

    public QMUICommonListItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUICommonListItemViewStyle);
    }

    public QMUICommonListItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOrientation = 1;
        this.mTipPosition = 0;
        this.mDisableSwitchSelf = false;
        this.mTipShown = 0;
        init(context, attributeSet, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void init(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        android.view.LayoutInflater.from(context).inflate(com.qmuiteam.qmui.R.layout.qmui_common_list_item, (android.view.ViewGroup) this, true);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUICommonListItemView, i, 0);
        int i2 = typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUICommonListItemView_qmui_orientation, 1);
        int i3 = typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUICommonListItemView_qmui_accessory_type, 0);
        int color = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUICommonListItemView_qmui_common_list_title_color, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(com.qmuiteam.qmui.R.styleable.QMUICommonListItemView_qmui_common_list_detail_color, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.mImageView = (android.widget.ImageView) findViewById(com.qmuiteam.qmui.R.id.group_list_item_imageView);
        this.mTextView = (android.widget.TextView) findViewById(com.qmuiteam.qmui.R.id.group_list_item_textView);
        this.mRedDot = (android.widget.ImageView) findViewById(com.qmuiteam.qmui.R.id.group_list_item_tips_dot);
        this.mNewTipView = (android.widget.ImageView) findViewById(com.qmuiteam.qmui.R.id.group_list_item_tips_new);
        this.mDetailTextView = (android.widget.TextView) findViewById(com.qmuiteam.qmui.R.id.group_list_item_detailTextView);
        this.mAfterTitleHolder = findViewById(com.qmuiteam.qmui.R.id.group_list_item_holder_after_title);
        this.mBeforeAccessoryHolder = findViewById(com.qmuiteam.qmui.R.id.group_list_item_holder_before_accessory);
        this.mAfterTitleHolder.setEmptyVisibility(8);
        this.mBeforeAccessoryHolder.setEmptyVisibility(8);
        this.mTextView.setTextColor(color);
        this.mDetailTextView.setTextColor(color2);
        this.mAccessoryView = (android.view.ViewGroup) findViewById(com.qmuiteam.qmui.R.id.group_list_item_accessoryView);
        setOrientation(i2);
        setAccessoryType(i3);
    }

    public void updateImageViewLp(com.up366.qmui.widget.grouplist.QMUICommonListItemView.LayoutParamConfig layoutParamConfig) {
        if (layoutParamConfig != null) {
            this.mImageView.setLayoutParams(layoutParamConfig.onConfig((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) this.mImageView.getLayoutParams()));
        }
    }

    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            this.mImageView.setVisibility(8);
        } else {
            this.mImageView.setImageDrawable(drawable);
            this.mImageView.setVisibility(0);
        }
    }

    public void setTipPosition(int i) {
        this.mTipPosition = i;
        if (this.mRedDot.getVisibility() == 0) {
            if (this.mTipPosition == 0) {
                this.mAfterTitleHolder.setContentId(this.mRedDot.getId());
                this.mBeforeAccessoryHolder.setContentId(-1);
            } else {
                this.mBeforeAccessoryHolder.setContentId(this.mRedDot.getId());
                this.mAfterTitleHolder.setContentId(-1);
            }
            this.mNewTipView.setVisibility(8);
        } else if (this.mNewTipView.getVisibility() == 0) {
            if (this.mTipPosition == 0) {
                this.mAfterTitleHolder.setContentId(this.mNewTipView.getId());
                this.mBeforeAccessoryHolder.setContentId(-1);
            } else {
                this.mBeforeAccessoryHolder.setContentId(this.mNewTipView.getId());
                this.mAfterTitleHolder.setContentId(-1);
            }
            this.mRedDot.setVisibility(8);
        }
        checkDetailLeftMargin();
    }

    public java.lang.CharSequence getText() {
        return this.mTextView.getText();
    }

    public void setText(java.lang.CharSequence charSequence) {
        this.mTextView.setText(charSequence);
        if (com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(charSequence)) {
            this.mTextView.setVisibility(8);
        } else {
            this.mTextView.setVisibility(0);
        }
    }

    public void showRedDot(boolean z) {
        if (z) {
            this.mTipShown = 1;
        } else if (this.mTipShown == 1) {
            this.mTipShown = 0;
        }
        updateTipShown();
    }

    public void showNewTip(boolean z) {
        if (z) {
            this.mTipShown = 2;
        } else if (this.mTipShown == 2) {
            this.mTipShown = 0;
        }
        updateTipShown();
    }

    private void updateTipShown() {
        int i = this.mTipShown;
        if (i == 1) {
            if (this.mTipPosition == 0) {
                this.mAfterTitleHolder.setContentId(this.mRedDot.getId());
                this.mBeforeAccessoryHolder.setContentId(-1);
            } else {
                this.mBeforeAccessoryHolder.setContentId(this.mRedDot.getId());
                this.mAfterTitleHolder.setContentId(-1);
            }
        } else if (i == 2) {
            if (this.mTipPosition == 0) {
                this.mAfterTitleHolder.setContentId(this.mNewTipView.getId());
                this.mBeforeAccessoryHolder.setContentId(-1);
            } else {
                this.mBeforeAccessoryHolder.setContentId(this.mNewTipView.getId());
                this.mAfterTitleHolder.setContentId(-1);
            }
        } else {
            this.mAfterTitleHolder.setContentId(-1);
            this.mBeforeAccessoryHolder.setContentId(-1);
        }
        this.mNewTipView.setVisibility(this.mTipShown == 2 ? 0 : 8);
        this.mRedDot.setVisibility(this.mTipShown != 1 ? 8 : 0);
        checkDetailLeftMargin();
    }

    private void checkDetailLeftMargin() {
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = this.mDetailTextView.getLayoutParams();
        if (this.mOrientation == 0) {
            layoutParams.leftMargin = 0;
        } else if (this.mNewTipView.getVisibility() == 8 || this.mTipPosition == 0) {
            layoutParams.leftMargin = com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_common_list_item_detail_h_margin_with_title);
        } else {
            layoutParams.leftMargin = com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_common_list_item_detail_h_margin_with_title_large);
        }
    }

    public java.lang.CharSequence getDetailText() {
        return this.mDetailTextView.getText();
    }

    public void setDetailText(java.lang.CharSequence charSequence) {
        this.mDetailTextView.setText(charSequence);
        if (com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(charSequence)) {
            this.mDetailTextView.setVisibility(8);
        } else {
            this.mDetailTextView.setVisibility(0);
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (this.mOrientation == i) {
            return;
        }
        this.mOrientation = i;
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = this.mTextView.getLayoutParams();
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = this.mDetailTextView.getLayoutParams();
        if (i == 0) {
            this.mTextView.setTextSize(0, com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_common_list_item_title_v_text_size));
            this.mDetailTextView.setTextSize(0, com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_common_list_item_detail_v_text_size));
            layoutParams.horizontalChainStyle = -1;
            layoutParams.verticalChainStyle = 2;
            layoutParams.bottomToBottom = -1;
            layoutParams.bottomToTop = this.mDetailTextView.getId();
            layoutParams2.horizontalChainStyle = -1;
            layoutParams2.verticalChainStyle = 2;
            layoutParams2.leftToRight = -1;
            layoutParams2.leftToLeft = this.mTextView.getId();
            layoutParams2.horizontalBias = 0.0f;
            layoutParams2.topToTop = -1;
            layoutParams2.topToBottom = this.mTextView.getId();
            layoutParams2.leftMargin = 0;
            layoutParams2.topMargin = com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_common_list_item_detail_v_margin_with_title);
            return;
        }
        this.mTextView.setTextSize(0, com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_common_list_item_title_h_text_size));
        this.mDetailTextView.setTextSize(0, com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_common_list_item_detail_h_text_size));
        layoutParams.horizontalChainStyle = 1;
        layoutParams.verticalChainStyle = -1;
        layoutParams.bottomToBottom = 0;
        layoutParams.bottomToTop = -1;
        layoutParams2.horizontalChainStyle = 1;
        layoutParams2.verticalChainStyle = -1;
        layoutParams2.leftToRight = this.mTextView.getId();
        layoutParams2.leftToLeft = -1;
        layoutParams2.horizontalBias = 0.0f;
        layoutParams2.topToTop = 0;
        layoutParams2.topToBottom = -1;
        layoutParams2.topMargin = 0;
        checkDetailLeftMargin();
    }

    public int getAccessoryType() {
        return this.mAccessoryType;
    }

    public void setAccessoryType(int i) {
        this.mAccessoryView.removeAllViews();
        this.mAccessoryType = i;
        if (i == 0) {
            this.mAccessoryView.setVisibility(8);
        } else if (i == 1) {
            android.widget.ImageView accessoryImageView = getAccessoryImageView();
            accessoryImageView.setImageDrawable(com.up366.qmui.util.QMUIResHelper.getAttrDrawable(getContext(), com.qmuiteam.qmui.R.attr.qmui_common_list_item_chevron));
            this.mAccessoryView.addView(accessoryImageView);
            this.mAccessoryView.setVisibility(0);
        } else if (i == 2) {
            if (this.mSwitch == null) {
                androidx.appcompat.widget.AppCompatCheckBox appCompatCheckBox = new androidx.appcompat.widget.AppCompatCheckBox(getContext());
                this.mSwitch = appCompatCheckBox;
                appCompatCheckBox.setBackground(null);
                this.mSwitch.setButtonDrawable(com.up366.qmui.util.QMUIResHelper.getAttrDrawable(getContext(), com.qmuiteam.qmui.R.attr.qmui_common_list_item_switch));
                this.mSwitch.setLayoutParams(getAccessoryLayoutParams());
                if (this.mDisableSwitchSelf) {
                    this.mSwitch.setClickable(false);
                    this.mSwitch.setEnabled(false);
                }
            }
            this.mAccessoryView.addView(this.mSwitch);
            this.mAccessoryView.setVisibility(0);
        } else if (i == 3) {
            this.mAccessoryView.setVisibility(0);
        }
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = this.mTextView.getLayoutParams();
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = this.mDetailTextView.getLayoutParams();
        if (this.mAccessoryView.getVisibility() != 8) {
            layoutParams2.goneRightMargin = layoutParams2.rightMargin;
            layoutParams.goneRightMargin = layoutParams.rightMargin;
        } else {
            layoutParams2.goneRightMargin = 0;
            layoutParams.goneRightMargin = 0;
        }
    }

    private android.view.ViewGroup.LayoutParams getAccessoryLayoutParams() {
        return new android.view.ViewGroup.LayoutParams(-2, -2);
    }

    private android.widget.ImageView getAccessoryImageView() {
        androidx.appcompat.widget.AppCompatImageView appCompatImageView = new androidx.appcompat.widget.AppCompatImageView(getContext());
        appCompatImageView.setLayoutParams(getAccessoryLayoutParams());
        appCompatImageView.setScaleType(android.widget.ImageView.ScaleType.CENTER);
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.tintColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_common_list_chevron_color);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) appCompatImageView, qMUISkinValueBuilderAcquire);
        com.up366.qmui.skin.QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
        return appCompatImageView;
    }

    public android.widget.TextView getTextView() {
        return this.mTextView;
    }

    public android.widget.TextView getDetailTextView() {
        return this.mDetailTextView;
    }

    public android.widget.CheckBox getSwitch() {
        return this.mSwitch;
    }

    public android.view.ViewGroup getAccessoryContainerView() {
        return this.mAccessoryView;
    }

    public void addAccessoryCustomView(android.view.View view) {
        if (this.mAccessoryType == 3) {
            this.mAccessoryView.addView(view);
        }
    }

    public void setDisableSwitchSelf(boolean z) {
        this.mDisableSwitchSelf = z;
        android.widget.CheckBox checkBox = this.mSwitch;
        if (checkBox != null) {
            checkBox.setClickable(!z);
            this.mSwitch.setEnabled(!z);
        }
    }

    public void setSkinConfig(com.up366.qmui.widget.grouplist.QMUICommonListItemView.SkinConfig skinConfig) {
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        if (skinConfig.iconTintColorRes != 0) {
            qMUISkinValueBuilderAcquire.tintColor(skinConfig.iconTintColorRes);
        }
        if (skinConfig.iconSrcRes != 0) {
            qMUISkinValueBuilderAcquire.src(skinConfig.iconSrcRes);
        }
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mImageView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        if (skinConfig.titleTextColorRes != 0) {
            qMUISkinValueBuilderAcquire.textColor(skinConfig.titleTextColorRes);
        }
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mTextView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        if (skinConfig.detailTextColorRes != 0) {
            qMUISkinValueBuilderAcquire.textColor(skinConfig.detailTextColorRes);
        }
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mDetailTextView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        if (skinConfig.newTipSrcRes != 0) {
            qMUISkinValueBuilderAcquire.src(skinConfig.newTipSrcRes);
        }
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mNewTipView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        if (skinConfig.tipDotColorRes != 0) {
            qMUISkinValueBuilderAcquire.bgTintColor(skinConfig.tipDotColorRes);
        }
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mRedDot, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
    }
}
