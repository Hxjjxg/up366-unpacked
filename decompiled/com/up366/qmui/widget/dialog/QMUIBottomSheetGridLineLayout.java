package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIBottomSheetGridLineLayout extends android.widget.LinearLayout {
    private int itemWidth;
    private int linePaddingHor;
    private java.util.List<android.util.Pair<android.view.View, android.widget.LinearLayout.LayoutParams>> mFirstLineViews;
    private java.util.List<android.util.Pair<android.view.View, android.widget.LinearLayout.LayoutParams>> mSecondLineViews;
    private int maxItemCountInLines;
    private int miniItemWidth;

    public QMUIBottomSheetGridLineLayout(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, java.util.List<android.util.Pair<android.view.View, android.widget.LinearLayout.LayoutParams>> list, java.util.List<android.util.Pair<android.view.View, android.widget.LinearLayout.LayoutParams>> list2) {
        super(qMUIBottomSheet.getContext());
        this.miniItemWidth = -1;
        boolean z = true;
        setOrientation(1);
        setGravity(48);
        setPadding(0, com.up366.qmui.util.QMUIResHelper.getAttrDimen(qMUIBottomSheet.getContext(), com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_grid_padding_top), 0, com.up366.qmui.util.QMUIResHelper.getAttrDimen(qMUIBottomSheet.getContext(), com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_grid_padding_bottom));
        this.mFirstLineViews = list;
        this.mSecondLineViews = list2;
        this.maxItemCountInLines = java.lang.Math.max(list != null ? list.size() : 0, list2 != null ? list2.size() : 0);
        this.linePaddingHor = com.up366.qmui.util.QMUIResHelper.getAttrDimen(qMUIBottomSheet.getContext(), com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_padding_hor);
        if (list == null || list.isEmpty()) {
            z = false;
        } else {
            addView(createHorScroller(qMUIBottomSheet, list), new android.widget.LinearLayout.LayoutParams(-2, -2));
        }
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        android.widget.HorizontalScrollView horizontalScrollViewCreateHorScroller = createHorScroller(qMUIBottomSheet, list2);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams.topMargin = com.up366.qmui.util.QMUIResHelper.getAttrDimen(qMUIBottomSheet.getContext(), com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_grid_line_vertical_space);
        }
        addView(horizontalScrollViewCreateHorScroller, layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = android.view.View.MeasureSpec.getSize(i);
        int i3 = this.maxItemCountInLines;
        int i4 = this.linePaddingHor;
        this.itemWidth = calculateItemWidth(size, i3, i4, i4);
        java.util.List<android.util.Pair<android.view.View, android.widget.LinearLayout.LayoutParams>> list = this.mFirstLineViews;
        if (list != null) {
            for (android.util.Pair<android.view.View, android.widget.LinearLayout.LayoutParams> pair : list) {
                if (((android.widget.LinearLayout.LayoutParams) pair.second).width != this.itemWidth) {
                    ((android.widget.LinearLayout.LayoutParams) pair.second).width = this.itemWidth;
                }
            }
        }
        java.util.List<android.util.Pair<android.view.View, android.widget.LinearLayout.LayoutParams>> list2 = this.mSecondLineViews;
        if (list2 != null) {
            for (android.util.Pair<android.view.View, android.widget.LinearLayout.LayoutParams> pair2 : list2) {
                if (((android.widget.LinearLayout.LayoutParams) pair2.second).width != this.itemWidth) {
                    ((android.widget.LinearLayout.LayoutParams) pair2.second).width = this.itemWidth;
                }
            }
        }
        super.onMeasure(i, i2);
    }

    protected android.widget.HorizontalScrollView createHorScroller(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, java.util.List<android.util.Pair<android.view.View, android.widget.LinearLayout.LayoutParams>> list) {
        android.content.Context context = qMUIBottomSheet.getContext();
        android.widget.HorizontalScrollView horizontalScrollView = new android.widget.HorizontalScrollView(context);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setClipToPadding(true);
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int i = this.linePaddingHor;
        linearLayout.setPadding(i, 0, i, 0);
        horizontalScrollView.addView(linearLayout, new android.widget.FrameLayout.LayoutParams(-2, -2));
        for (int i2 = 0; i2 < list.size(); i2++) {
            android.util.Pair<android.view.View, android.widget.LinearLayout.LayoutParams> pair = list.get(i2);
            linearLayout.addView((android.view.View) pair.first, (android.view.ViewGroup.LayoutParams) pair.second);
        }
        return horizontalScrollView;
    }

    @Override // android.view.ViewGroup
    protected void measureChild(android.view.View view, int i, int i2) {
        super.measureChild(view, i, i2);
    }

    private int calculateItemWidth(int i, int i2, int i3, int i4) {
        int i5;
        if (this.miniItemWidth == -1) {
            this.miniItemWidth = com.up366.qmui.util.QMUIResHelper.getAttrDimen(getContext(), com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_grid_item_mini_width);
        }
        int i6 = i - i3;
        int i7 = i6 - i4;
        int i8 = this.miniItemWidth;
        if (i2 >= 3 && (i5 = i7 - (i2 * i8)) > 0 && i5 < i8) {
            i8 = i7 / (i7 / i8);
        }
        return i2 * i8 > i7 ? (int) (i6 / ((i6 / i8) + 0.5f)) : i8;
    }
}
