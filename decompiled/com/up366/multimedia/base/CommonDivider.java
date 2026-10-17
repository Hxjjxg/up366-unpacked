package com.up366.multimedia.base;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CommonDivider extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    private android.graphics.Paint mPaint;
    private int mDividerHeight = 1;
    private int count = 1;

    public CommonDivider(int count) {
        init(count, 0, 0);
    }

    private void init(int count, int color, int mDividerHeight) {
        this.count = count;
        this.mDividerHeight = mDividerHeight;
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.mPaint = paint;
        paint.setColor(color);
        this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
    }

    public com.up366.multimedia.base.CommonDivider height(int height) {
        this.mDividerHeight = height;
        return this;
    }

    public void getItemOffsets(android.graphics.Rect outRect, android.view.View view, androidx.recyclerview.widget.RecyclerView parent, androidx.recyclerview.widget.RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0, 0, 0, 0);
        if (parent.getChildLayoutPosition(view) + 1 > this.count) {
            outRect.top = this.mDividerHeight;
        }
        int childLayoutPosition = parent.getChildLayoutPosition(view);
        int i = this.count;
        if ((childLayoutPosition % i) + 1 < i) {
            outRect.right = this.mDividerHeight;
        }
    }

    public void onDraw(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView parent, androidx.recyclerview.widget.RecyclerView.State state) {
        super.onDraw(canvas, parent, state);
        int paddingLeft = parent.getPaddingLeft();
        int measuredWidth = parent.getMeasuredWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = parent.getChildAt(i);
            int bottom = childAt.getBottom() + childAt.getLayoutParams().bottomMargin;
            int i2 = this.mDividerHeight + bottom;
            android.graphics.Paint paint = this.mPaint;
            if (paint != null) {
                canvas.drawRect(paddingLeft, bottom, measuredWidth, i2, paint);
            }
        }
    }
}
