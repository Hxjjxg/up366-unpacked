package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUITipDialogView extends com.up366.qmui.layout.QMUILinearLayout {
    private final int mMaxWidth;
    private final int mMiniHeight;
    private final int mMiniWidth;

    public QMUITipDialogView(android.content.Context context) {
        super(context);
        setOrientation(1);
        setGravity(1);
        int attrDimen = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_tip_dialog_radius);
        android.graphics.drawable.Drawable attrDrawable = com.up366.qmui.util.QMUIResHelper.getAttrDrawable(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_tip_dialog_bg);
        int attrDimen2 = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_tip_dialog_padding_horizontal);
        int attrDimen3 = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_tip_dialog_padding_vertical);
        setBackground(attrDrawable);
        setPadding(attrDimen2, attrDimen3, attrDimen2, attrDimen3);
        setRadius(attrDimen);
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.background(com.qmuiteam.qmui.R.attr.qmui_skin_support_tip_dialog_bg);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
        this.mMaxWidth = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_tip_dialog_max_width);
        this.mMiniWidth = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_tip_dialog_min_width);
        this.mMiniHeight = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_tip_dialog_min_height);
    }

    @Override // com.up366.qmui.layout.QMUILinearLayout, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int size = android.view.View.MeasureSpec.getSize(i);
        int mode = android.view.View.MeasureSpec.getMode(i);
        int i3 = this.mMaxWidth;
        if (size > i3) {
            i = android.view.View.MeasureSpec.makeMeasureSpec(i3, mode);
        }
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int i4 = this.mMiniWidth;
        boolean z2 = true;
        if (measuredWidth < i4) {
            i = android.view.View.MeasureSpec.makeMeasureSpec(i4, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
            z = true;
        } else {
            z = false;
        }
        int measuredHeight = getMeasuredHeight();
        int i5 = this.mMiniHeight;
        if (measuredHeight < i5) {
            i2 = android.view.View.MeasureSpec.makeMeasureSpec(i5, com.up366.medialibrary.common.utils.PictureFileUtils.GB);
        } else {
            z2 = z;
        }
        if (z2) {
            super.onMeasure(i, i2);
        }
    }
}
