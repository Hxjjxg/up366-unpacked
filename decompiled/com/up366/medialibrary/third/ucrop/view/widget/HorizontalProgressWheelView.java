package com.up366.medialibrary.third.ucrop.view.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class HorizontalProgressWheelView extends android.view.View {
    private final android.graphics.Rect mCanvasClipBounds;
    private float mLastTouchedPosition;
    private int mMiddleLineColor;
    private int mProgressLineHeight;
    private int mProgressLineMargin;
    private android.graphics.Paint mProgressLinePaint;
    private int mProgressLineWidth;
    private android.graphics.Paint mProgressMiddleLinePaint;
    private boolean mScrollStarted;
    private com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener mScrollingListener;
    private float mTotalScrollDistance;

    public interface ScrollingListener {
        void onScroll(float f, float f2);

        void onScrollEnd();

        void onScrollStart();
    }

    public HorizontalProgressWheelView(android.content.Context context) {
        this(context, null);
    }

    public HorizontalProgressWheelView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCanvasClipBounds = new android.graphics.Rect();
        init();
    }

    public HorizontalProgressWheelView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mCanvasClipBounds = new android.graphics.Rect();
    }

    public void setScrollingListener(com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener scrollingListener) {
        this.mScrollingListener = scrollingListener;
    }

    public void setMiddleLineColor(int i) {
        this.mMiddleLineColor = i;
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastTouchedPosition = motionEvent.getX();
        } else if (action == 1) {
            com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener scrollingListener = this.mScrollingListener;
            if (scrollingListener != null) {
                this.mScrollStarted = false;
                scrollingListener.onScrollEnd();
            }
        } else if (action == 2) {
            float x = motionEvent.getX() - this.mLastTouchedPosition;
            if (x != 0.0f) {
                if (!this.mScrollStarted) {
                    this.mScrollStarted = true;
                    com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener scrollingListener2 = this.mScrollingListener;
                    if (scrollingListener2 != null) {
                        scrollingListener2.onScrollStart();
                    }
                }
                onScrollEvent(motionEvent, x);
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.mCanvasClipBounds);
        int iWidth = this.mCanvasClipBounds.width() / (this.mProgressLineWidth + this.mProgressLineMargin);
        float f = this.mTotalScrollDistance % (r2 + r1);
        for (int i = 0; i < iWidth; i++) {
            int i2 = iWidth / 4;
            if (i < i2) {
                this.mProgressLinePaint.setAlpha((int) ((i / i2) * 255.0f));
            } else if (i > (iWidth * 3) / 4) {
                this.mProgressLinePaint.setAlpha((int) (((iWidth - i) / i2) * 255.0f));
            } else {
                this.mProgressLinePaint.setAlpha(255);
            }
            float f2 = -f;
            canvas.drawLine(this.mCanvasClipBounds.left + f2 + ((this.mProgressLineWidth + this.mProgressLineMargin) * i), this.mCanvasClipBounds.centerY() - (this.mProgressLineHeight / 4.0f), f2 + this.mCanvasClipBounds.left + ((this.mProgressLineWidth + this.mProgressLineMargin) * i), this.mCanvasClipBounds.centerY() + (this.mProgressLineHeight / 4.0f), this.mProgressLinePaint);
        }
        canvas.drawLine(this.mCanvasClipBounds.centerX(), this.mCanvasClipBounds.centerY() - (this.mProgressLineHeight / 2.0f), this.mCanvasClipBounds.centerX(), (this.mProgressLineHeight / 2.0f) + this.mCanvasClipBounds.centerY(), this.mProgressMiddleLinePaint);
    }

    private void onScrollEvent(android.view.MotionEvent motionEvent, float f) {
        this.mTotalScrollDistance -= f;
        postInvalidate();
        this.mLastTouchedPosition = motionEvent.getX();
        com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener scrollingListener = this.mScrollingListener;
        if (scrollingListener != null) {
            scrollingListener.onScroll(-f, this.mTotalScrollDistance);
        }
    }

    private void init() {
        this.mMiddleLineColor = androidx.core.content.ContextCompat.getColor(getContext(), com.up366.medialibrary.R.color.ucrop_color_widget_rotate_mid_line);
        this.mProgressLineWidth = getContext().getResources().getDimensionPixelSize(com.up366.medialibrary.R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.mProgressLineHeight = getContext().getResources().getDimensionPixelSize(com.up366.medialibrary.R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.mProgressLineMargin = getContext().getResources().getDimensionPixelSize(com.up366.medialibrary.R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.mProgressLinePaint = paint;
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        this.mProgressLinePaint.setStrokeWidth(this.mProgressLineWidth);
        this.mProgressLinePaint.setColor(getResources().getColor(com.up366.medialibrary.R.color.ucrop_color_progress_wheel_line));
        android.graphics.Paint paint2 = new android.graphics.Paint(this.mProgressLinePaint);
        this.mProgressMiddleLinePaint = paint2;
        paint2.setColor(this.mMiddleLineColor);
        this.mProgressMiddleLinePaint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        this.mProgressMiddleLinePaint.setStrokeWidth(getContext().getResources().getDimensionPixelSize(com.up366.medialibrary.R.dimen.ucrop_width_middle_wheel_progress_line));
    }
}
