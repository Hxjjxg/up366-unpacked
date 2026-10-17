package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIBottomSheetGridItemView extends com.up366.qmui.layout.QMUIConstraintLayout {
    protected androidx.appcompat.widget.AppCompatImageView mIconIv;
    protected java.lang.Object mModelTag;
    protected androidx.appcompat.widget.AppCompatImageView mSubscriptIv;
    protected android.widget.TextView mTitleTv;

    public QMUIBottomSheetGridItemView(android.content.Context context) {
        this(context, null);
    }

    public QMUIBottomSheetGridItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIBottomSheetGridItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setChangeAlphaWhenPress(true);
        setPadding(0, com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_grid_item_padding_top), 0, com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_grid_item_padding_bottom));
        androidx.appcompat.widget.AppCompatImageView appCompatImageViewOnCreateIconView = onCreateIconView(context);
        this.mIconIv = appCompatImageViewOnCreateIconView;
        appCompatImageViewOnCreateIconView.setId(android.view.View.generateViewId());
        this.mIconIv.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        int attrDimen = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_grid_item_icon_size);
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(attrDimen, attrDimen);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.topToTop = 0;
        addView(this.mIconIv, layoutParams);
        android.widget.TextView textViewOnCreateTitleView = onCreateTitleView(context);
        this.mTitleTv = textViewOnCreateTitleView;
        textViewOnCreateTitleView.setId(android.view.View.generateViewId());
        com.up366.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider qMUISkinSimpleDefaultAttrProvider = new com.up366.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider();
        qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(com.up366.qmui.skin.QMUISkinValueBuilder.TEXT_COLOR, com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_grid_item_text_color);
        com.up366.qmui.util.QMUIResHelper.assignTextViewWithAttr(this.mTitleTv, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_grid_item_text_style);
        com.up366.qmui.skin.QMUISkinHelper.setSkinDefaultProvider(this.mTitleTv, qMUISkinSimpleDefaultAttrProvider);
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.leftToLeft = 0;
        layoutParams2.rightToRight = 0;
        layoutParams2.topToBottom = this.mIconIv.getId();
        layoutParams2.topMargin = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_grid_item_text_margin_top);
        addView(this.mTitleTv, layoutParams2);
    }

    protected androidx.appcompat.widget.AppCompatImageView onCreateIconView(android.content.Context context) {
        return new androidx.appcompat.widget.AppCompatImageView(context);
    }

    protected android.widget.TextView onCreateTitleView(android.content.Context context) {
        return new com.up366.qmui.widget.textview.QMUISpanTouchFixTextView(context);
    }

    public void render(com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel qMUIBottomSheetGridItemModel) {
        this.mModelTag = qMUIBottomSheetGridItemModel.tag;
        setTag(qMUIBottomSheetGridItemModel.tag);
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        renderIcon(qMUIBottomSheetGridItemModel, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        renderTitle(qMUIBottomSheetGridItemModel, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        renderSubScript(qMUIBottomSheetGridItemModel, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
    }

    public java.lang.Object getModelTag() {
        return this.mModelTag;
    }

    protected void renderIcon(com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel qMUIBottomSheetGridItemModel, com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilder) {
        if (qMUIBottomSheetGridItemModel.imageSkinSrcAttr != 0) {
            qMUISkinValueBuilder.src(qMUIBottomSheetGridItemModel.imageSkinSrcAttr);
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mIconIv, qMUISkinValueBuilder);
            this.mIconIv.setImageDrawable(com.up366.qmui.skin.QMUISkinHelper.getSkinDrawable(this.mIconIv, qMUIBottomSheetGridItemModel.imageSkinSrcAttr));
            return;
        }
        android.graphics.drawable.Drawable drawable = qMUIBottomSheetGridItemModel.image;
        if (drawable == null && qMUIBottomSheetGridItemModel.imageRes != 0) {
            drawable = androidx.core.content.ContextCompat.getDrawable(getContext(), qMUIBottomSheetGridItemModel.imageRes);
        }
        if (drawable != null) {
            drawable.mutate();
        }
        this.mIconIv.setImageDrawable(drawable);
        if (qMUIBottomSheetGridItemModel.imageSkinTintColorAttr != 0) {
            qMUISkinValueBuilder.tintColor(qMUIBottomSheetGridItemModel.imageSkinTintColorAttr);
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mIconIv, qMUISkinValueBuilder);
        } else {
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mIconIv, "");
        }
    }

    protected void renderTitle(com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel qMUIBottomSheetGridItemModel, com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilder) {
        this.mTitleTv.setText(qMUIBottomSheetGridItemModel.text);
        if (qMUIBottomSheetGridItemModel.textSkinColorAttr != 0) {
            qMUISkinValueBuilder.textColor(qMUIBottomSheetGridItemModel.textSkinColorAttr);
        }
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mTitleTv, qMUISkinValueBuilder);
        if (qMUIBottomSheetGridItemModel.typeface != null) {
            this.mTitleTv.setTypeface(qMUIBottomSheetGridItemModel.typeface);
        }
    }

    protected void renderSubScript(com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel qMUIBottomSheetGridItemModel, com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilder) {
        if (qMUIBottomSheetGridItemModel.subscriptRes != 0 || qMUIBottomSheetGridItemModel.subscript != null || qMUIBottomSheetGridItemModel.subscriptSkinSrcAttr != 0) {
            if (this.mSubscriptIv == null) {
                androidx.appcompat.widget.AppCompatImageView appCompatImageView = new androidx.appcompat.widget.AppCompatImageView(getContext());
                this.mSubscriptIv = appCompatImageView;
                appCompatImageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
                androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
                layoutParams.rightToRight = this.mIconIv.getId();
                layoutParams.topToTop = this.mIconIv.getId();
                addView(this.mSubscriptIv, layoutParams);
            }
            this.mSubscriptIv.setVisibility(0);
            if (qMUIBottomSheetGridItemModel.subscriptSkinSrcAttr != 0) {
                qMUISkinValueBuilder.src(qMUIBottomSheetGridItemModel.subscriptSkinSrcAttr);
                com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mSubscriptIv, qMUISkinValueBuilder);
                this.mIconIv.setImageDrawable(com.up366.qmui.skin.QMUISkinHelper.getSkinDrawable(this.mSubscriptIv, qMUIBottomSheetGridItemModel.subscriptSkinSrcAttr));
                return;
            }
            android.graphics.drawable.Drawable drawable = qMUIBottomSheetGridItemModel.subscript;
            if (drawable == null && qMUIBottomSheetGridItemModel.subscriptRes != 0) {
                drawable = androidx.core.content.ContextCompat.getDrawable(getContext(), qMUIBottomSheetGridItemModel.subscriptRes);
            }
            if (drawable != null) {
                drawable.mutate();
            }
            this.mSubscriptIv.setImageDrawable(drawable);
            if (qMUIBottomSheetGridItemModel.subscriptSkinTintColorAttr != 0) {
                qMUISkinValueBuilder.tintColor(qMUIBottomSheetGridItemModel.subscriptSkinTintColorAttr);
                com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mSubscriptIv, qMUISkinValueBuilder);
                return;
            } else {
                com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mSubscriptIv, "");
                return;
            }
        }
        androidx.appcompat.widget.AppCompatImageView appCompatImageView2 = this.mSubscriptIv;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(8);
        }
    }
}
