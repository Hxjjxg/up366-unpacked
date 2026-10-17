package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OverlapLayoutManager extends androidx.recyclerview.widget.RecyclerView.LayoutManager {
    public androidx.recyclerview.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new androidx.recyclerview.widget.RecyclerView.LayoutParams(-2, -2);
    }

    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);
        int width = getWidth();
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return;
        }
        android.view.View viewForPosition = recycler.getViewForPosition(0);
        int iDp2px = com.up366.common.DpUtilsUp.dp2px(10.0f);
        measureChildWithMargins(viewForPosition, 0, 0);
        int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition);
        int i = (width - (((width - (itemCount * decoratedMeasuredWidth)) + ((itemCount - 1) * iDp2px)) / 2)) - decoratedMeasuredWidth;
        for (int itemCount2 = getItemCount() - 1; itemCount2 >= 0 && itemCount2 <= 3; itemCount2--) {
            android.view.View viewForPosition2 = recycler.getViewForPosition(itemCount2);
            addView(viewForPosition2);
            measureChildWithMargins(viewForPosition2, 0, 0);
            layoutDecorated(viewForPosition2, i, 0, i + decoratedMeasuredWidth, getDecoratedMeasuredHeight(viewForPosition2));
            i -= decoratedMeasuredWidth - iDp2px;
        }
    }
}
