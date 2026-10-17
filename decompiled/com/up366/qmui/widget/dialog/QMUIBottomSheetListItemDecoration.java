package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIBottomSheetListItemDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration implements com.up366.qmui.skin.IQMUISkinHandlerDecoration {
    private final int mSeparatorAttr;
    private final android.graphics.Paint mSeparatorPaint;

    public QMUIBottomSheetListItemDecoration(android.content.Context context) {
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mSeparatorPaint = paint;
        paint.setStrokeWidth(1.0f);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        int i = com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_separator_color;
        this.mSeparatorAttr = i;
        if (i != 0) {
            paint.setColor(com.up366.qmui.util.QMUIResHelper.getAttrColor(context, i));
        }
    }

    public void onDrawOver(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        int i;
        super.onDrawOver(canvas, recyclerView, state);
        androidx.recyclerview.widget.RecyclerView.Adapter adapter = recyclerView.getAdapter();
        androidx.recyclerview.widget.RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (adapter == null || layoutManager == null || this.mSeparatorAttr == 0) {
            return;
        }
        for (int i2 = 0; i2 < recyclerView.getChildCount(); i2++) {
            android.view.View childAt = recyclerView.getChildAt(i2);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if ((childAt instanceof com.up366.qmui.widget.dialog.QMUIBottomSheetListItemView) && (i = childAdapterPosition + 1) < adapter.getItemCount() && adapter.getItemViewType(i) == 3) {
                float decoratedBottom = layoutManager.getDecoratedBottom(childAt);
                canvas.drawLine(com.up366.qmui.util.QMUIDisplayHelper.dpToPx(20), decoratedBottom, recyclerView.getWidth() - com.up366.qmui.util.QMUIDisplayHelper.dpToPx(20), decoratedBottom, this.mSeparatorPaint);
            }
        }
    }

    @Override // com.up366.qmui.skin.IQMUISkinHandlerDecoration
    public void handle(androidx.recyclerview.widget.RecyclerView recyclerView, com.up366.qmui.skin.QMUISkinManager qMUISkinManager, int i, android.content.res.Resources.Theme theme) {
        int i2 = this.mSeparatorAttr;
        if (i2 != 0) {
            this.mSeparatorPaint.setColor(com.up366.qmui.util.QMUIResHelper.getAttrColor(theme, i2));
        }
    }
}
