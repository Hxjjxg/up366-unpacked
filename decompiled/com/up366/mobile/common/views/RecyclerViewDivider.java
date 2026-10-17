package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class RecyclerViewDivider extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    private android.content.Context context;
    private int count;
    private android.graphics.drawable.Drawable mDivider;
    private int mDividerHeight = 1;
    private int mOrientation;
    private android.graphics.Paint mPaint;
    private int padding;

    public RecyclerViewDivider(android.content.Context context) {
        this.context = context;
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.mPaint = paint;
        paint.setColor(0);
        this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
    }

    public com.up366.mobile.common.views.RecyclerViewDivider color(int i) {
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.mPaint = paint;
        paint.setColor(i);
        this.mPaint.setStyle(android.graphics.Paint.Style.FILL);
        return this;
    }

    public com.up366.mobile.common.views.RecyclerViewDivider height(int i) {
        this.mDividerHeight = i;
        return this;
    }

    public com.up366.mobile.common.views.RecyclerViewDivider drawable(int i) {
        android.graphics.drawable.Drawable drawable = androidx.core.content.ContextCompat.getDrawable(this.context, i);
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerHeight = drawable.getIntrinsicHeight();
        }
        return this;
    }

    public com.up366.mobile.common.views.RecyclerViewDivider column(int i) {
        this.count = i;
        return this;
    }

    public com.up366.mobile.common.views.RecyclerViewDivider oriention(int i) {
        this.mOrientation = i;
        return this;
    }

    public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.set(0, 0, 0, this.mDividerHeight);
        if (recyclerView.getChildLayoutPosition(view) + 1 <= this.count) {
            rect.top = this.mDividerHeight;
        }
        if (this.count != 0) {
            rect.left = this.mDividerHeight;
            if (recyclerView.getChildLayoutPosition(view) % this.count == 1) {
                rect.right = this.mDividerHeight;
            }
            if (this.count == 1) {
                rect.right = this.mDividerHeight;
            }
        }
    }

    public void onDraw(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        if (this.mOrientation == 1) {
            drawVertical(canvas, recyclerView);
        } else {
            drawHorizontal(canvas, recyclerView);
        }
    }

    private void drawHorizontal(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft() + this.padding;
        int measuredWidth = (recyclerView.getMeasuredWidth() - recyclerView.getPaddingRight()) - this.padding;
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + childAt.getLayoutParams().bottomMargin;
            int i2 = this.mDividerHeight + bottom;
            android.graphics.drawable.Drawable drawable = this.mDivider;
            if (drawable != null) {
                drawable.setBounds(paddingLeft, bottom, measuredWidth, i2);
                this.mDivider.draw(canvas);
            }
            android.graphics.Paint paint = this.mPaint;
            if (paint != null) {
                canvas.drawRect(paddingLeft, bottom, measuredWidth, i2, paint);
            }
        }
    }

    private void drawVertical(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int measuredHeight = recyclerView.getMeasuredHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = recyclerView.getChildAt(i);
            int right = childAt.getRight() + childAt.getLayoutParams().rightMargin;
            int i2 = this.mDividerHeight + right;
            android.graphics.drawable.Drawable drawable = this.mDivider;
            if (drawable != null) {
                drawable.setBounds(right, paddingTop, i2, measuredHeight);
                this.mDivider.draw(canvas);
            }
            android.graphics.Paint paint = this.mPaint;
            if (paint != null) {
                canvas.drawRect(right, paddingTop, i2, measuredHeight, paint);
            }
        }
    }

    public androidx.recyclerview.widget.RecyclerView.ItemDecoration padding(int i) {
        this.padding = i;
        return this;
    }
}
