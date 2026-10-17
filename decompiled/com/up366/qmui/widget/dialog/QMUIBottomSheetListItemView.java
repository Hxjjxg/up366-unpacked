package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIBottomSheetListItemView extends com.up366.qmui.layout.QMUIConstraintLayout {
    private androidx.appcompat.widget.AppCompatImageView mIconView;
    private int mItemHeight;
    private androidx.appcompat.widget.AppCompatImageView mMarkView;
    private com.up366.qmui.layout.QMUIFrameLayout mRedPointView;
    private boolean mRightMarkSelectedFalseVisible;
    private com.up366.qmui.widget.textview.QMUISpanTouchFixTextView mTextView;

    /* JADX WARN: Multi-variable type inference failed */
    public QMUIBottomSheetListItemView(android.content.Context context, boolean z, boolean z2, boolean z3) {
        super(context);
        this.mMarkView = null;
        this.mRightMarkSelectedFalseVisible = z2;
        setBackground(com.up366.qmui.util.QMUIResHelper.getAttrDrawable(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_list_item_bg));
        int attrDimen = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_padding_hor);
        setPadding(attrDimen, 0, attrDimen, 0);
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.background(com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_list_item_bg);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        androidx.appcompat.widget.AppCompatImageView appCompatImageView = new androidx.appcompat.widget.AppCompatImageView(context);
        this.mIconView = appCompatImageView;
        appCompatImageView.setId(android.view.View.generateViewId());
        this.mIconView.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        com.up366.qmui.widget.textview.QMUISpanTouchFixTextView qMUISpanTouchFixTextView = new com.up366.qmui.widget.textview.QMUISpanTouchFixTextView(context);
        this.mTextView = qMUISpanTouchFixTextView;
        qMUISpanTouchFixTextView.setId(android.view.View.generateViewId());
        com.up366.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider qMUISkinSimpleDefaultAttrProvider = new com.up366.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider();
        qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COLOR, com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_list_item_text_color);
        com.up366.qmui.util.QMUIResHelper.assignTextViewWithAttr(this.mTextView, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_list_item_text_style);
        com.up366.qmui.skin.QMUISkinHelper.setSkinDefaultProvider(this.mTextView, qMUISkinSimpleDefaultAttrProvider);
        com.up366.qmui.layout.QMUIFrameLayout qMUIFrameLayout = new com.up366.qmui.layout.QMUIFrameLayout(context);
        this.mRedPointView = qMUIFrameLayout;
        qMUIFrameLayout.setId(android.view.View.generateViewId());
        this.mRedPointView.setBackgroundColor(com.up366.qmui.util.QMUIResHelper.getAttrColor(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_list_red_point_color));
        qMUISkinValueBuilderAcquire.background(com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_list_red_point_color);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mRedPointView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        if (z) {
            androidx.appcompat.widget.AppCompatImageView appCompatImageView2 = new androidx.appcompat.widget.AppCompatImageView(context);
            this.mMarkView = appCompatImageView2;
            appCompatImageView2.setId(android.view.View.generateViewId());
            this.mMarkView.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
            this.mMarkView.setImageDrawable(com.up366.qmui.util.QMUIResHelper.getAttrDrawable(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_list_mark));
            qMUISkinValueBuilderAcquire.src(com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_list_mark);
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mMarkView, qMUISkinValueBuilderAcquire);
        }
        qMUISkinValueBuilderAcquire.release();
        int attrDimen2 = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_list_item_icon_size);
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(attrDimen2, attrDimen2);
        layoutParams.leftToLeft = 0;
        layoutParams.topToTop = 0;
        layoutParams.rightToLeft = this.mTextView.getId();
        layoutParams.bottomToBottom = 0;
        layoutParams.horizontalChainStyle = 2;
        layoutParams.horizontalBias = z3 ? 0.5f : 0.0f;
        addView(this.mIconView, layoutParams);
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.leftToRight = this.mIconView.getId();
        layoutParams2.rightToLeft = this.mRedPointView.getId();
        layoutParams2.topToTop = 0;
        layoutParams2.bottomToBottom = 0;
        layoutParams2.horizontalChainStyle = 2;
        layoutParams2.horizontalBias = z3 ? 0.5f : 0.0f;
        layoutParams2.leftMargin = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_list_item_icon_margin_right);
        int attrDimen3 = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_list_item_text_view_padding_top);
        int attrDimen4 = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_list_item_text_view_padding_right);
        int attrDimen5 = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_list_item_text_view_padding_bottom);
        int attrDimen6 = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_list_item_text_view_padding_left);
        layoutParams2.goneLeftMargin = 0;
        this.mTextView.setPadding(attrDimen6, attrDimen3, attrDimen4, attrDimen5);
        addView(this.mTextView, layoutParams2);
        int attrDimen7 = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_list_item_red_point_size);
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams3 = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(attrDimen7, attrDimen7);
        layoutParams3.leftToRight = this.mTextView.getId();
        if (z) {
            layoutParams3.rightToLeft = this.mMarkView.getId();
            layoutParams3.rightMargin = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_list_item_mark_margin_left);
        } else {
            layoutParams3.rightToRight = 0;
        }
        layoutParams3.topToTop = 0;
        layoutParams3.bottomToBottom = 0;
        layoutParams3.horizontalChainStyle = 2;
        layoutParams3.horizontalBias = z3 ? 0.5f : 0.0f;
        layoutParams3.leftMargin = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_list_item_tip_point_margin_left);
        addView(this.mRedPointView, layoutParams3);
        if (z) {
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams4 = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
            layoutParams4.rightToRight = 0;
            layoutParams4.topToTop = 0;
            layoutParams4.bottomToBottom = 0;
            addView(this.mMarkView, layoutParams4);
        }
        this.mItemHeight = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_list_item_height);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void render(com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel qMUIBottomSheetListItemModel, boolean z) {
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        int i = 0;
        if (qMUIBottomSheetListItemModel.imageSkinSrcAttr != 0) {
            qMUISkinValueBuilderAcquire.src(qMUIBottomSheetListItemModel.imageSkinSrcAttr);
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mIconView, qMUISkinValueBuilderAcquire);
            this.mIconView.setImageDrawable(com.up366.qmui.skin.QMUISkinHelper.getSkinDrawable(this, qMUIBottomSheetListItemModel.imageSkinSrcAttr));
            this.mIconView.setVisibility(0);
        } else {
            android.graphics.drawable.Drawable drawable = qMUIBottomSheetListItemModel.image;
            if (drawable == null && qMUIBottomSheetListItemModel.imageRes != 0) {
                drawable = androidx.core.content.ContextCompat.getDrawable(getContext(), qMUIBottomSheetListItemModel.imageRes);
            }
            if (drawable != null) {
                drawable.mutate();
                this.mIconView.setImageDrawable(drawable);
                if (qMUIBottomSheetListItemModel.imageSkinTintColorAttr != 0) {
                    qMUISkinValueBuilderAcquire.tintColor(qMUIBottomSheetListItemModel.imageSkinTintColorAttr);
                    com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mIconView, qMUISkinValueBuilderAcquire);
                } else {
                    com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mIconView, "");
                }
            } else {
                this.mIconView.setVisibility(8);
            }
        }
        qMUISkinValueBuilderAcquire.clear();
        this.mTextView.setText(qMUIBottomSheetListItemModel.text);
        if (qMUIBottomSheetListItemModel.typeface != null) {
            this.mTextView.setTypeface(qMUIBottomSheetListItemModel.typeface);
        }
        if (qMUIBottomSheetListItemModel.textSkinColorAttr != 0) {
            qMUISkinValueBuilderAcquire.textColor(qMUIBottomSheetListItemModel.textSkinColorAttr);
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mTextView, qMUISkinValueBuilderAcquire);
            android.content.res.ColorStateList skinColorStateList = com.up366.qmui.skin.QMUISkinHelper.getSkinColorStateList(this.mTextView, qMUIBottomSheetListItemModel.textSkinColorAttr);
            if (skinColorStateList != null) {
                this.mTextView.setTextColor(skinColorStateList);
            }
        } else {
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mTextView, "");
        }
        this.mRedPointView.setVisibility(qMUIBottomSheetListItemModel.hasRedPoint ? 0 : 8);
        androidx.appcompat.widget.AppCompatImageView appCompatImageView = this.mMarkView;
        if (appCompatImageView != null) {
            appCompatImageView.setSelected(z);
            androidx.appcompat.widget.AppCompatImageView appCompatImageView2 = this.mMarkView;
            if (!z && !this.mRightMarkSelectedFalseVisible) {
                i = 4;
            }
            appCompatImageView2.setVisibility(i);
        }
    }

    @Override // com.up366.qmui.layout.QMUIConstraintLayout
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(this.mItemHeight, com.up366.medialibrary.common.utils.PictureFileUtils.GB));
    }
}
