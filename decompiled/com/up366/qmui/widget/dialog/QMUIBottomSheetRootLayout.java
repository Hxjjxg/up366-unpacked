package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIBottomSheetRootLayout extends com.up366.qmui.layout.QMUILinearLayout {
    private final float mHeightPercent;
    private final int mMaxWidth;
    private final int mUsePercentMinHeight;

    public QMUIBottomSheetRootLayout(android.content.Context context) {
        this(context, null);
    }

    public QMUIBottomSheetRootLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        setBackground(com.up366.qmui.util.QMUIResHelper.getAttrDrawable(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_bg));
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.background(com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_bg);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
        int attrDimen = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_radius);
        if (attrDimen > 0) {
            setRadius(attrDimen, 3);
        }
        this.mUsePercentMinHeight = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_use_percent_min_height);
        this.mHeightPercent = com.up366.qmui.util.QMUIResHelper.getAttrFloatValue(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_height_percent);
        this.mMaxWidth = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_max_width);
    }

    @Override // com.up366.qmui.layout.QMUILinearLayout, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i);
        int mode = android.view.View.MeasureSpec.getMode(i);
        int i3 = this.mMaxWidth;
        if (size > i3) {
            i = android.view.View.MeasureSpec.makeMeasureSpec(i3, mode);
        }
        super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec((int) (android.view.View.MeasureSpec.getSize(i2) * this.mHeightPercent), com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER));
    }
}
