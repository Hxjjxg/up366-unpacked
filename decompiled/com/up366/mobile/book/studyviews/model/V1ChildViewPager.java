package com.up366.mobile.book.studyviews.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V1ChildViewPager extends androidx.viewpager.widget.ViewPager {
    android.graphics.PointF downPoint;
    private boolean isCanMove;
    com.up366.mobile.book.studyviews.model.V1ChildViewPager.OnSingleTouchListener onSingleTouchListener;

    public interface OnSingleTouchListener {
        void onSingleTouch(android.view.View view);
    }

    public V1ChildViewPager(android.content.Context context) {
        super(context);
        this.downPoint = new android.graphics.PointF();
        this.isCanMove = false;
    }

    public V1ChildViewPager(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downPoint = new android.graphics.PointF();
        this.isCanMove = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int currentItem = getCurrentItem();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downPoint.x = motionEvent.getX();
            this.downPoint.y = motionEvent.getY();
            this.isCanMove = true;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action != 1) {
            if (action == 2) {
                if (currentItem == 0) {
                    this.isCanMove = motionEvent.getX() <= this.downPoint.x + 3.0f;
                }
                getParent().requestDisallowInterceptTouchEvent(this.isCanMove);
            }
        } else if (android.graphics.PointF.length(motionEvent.getX() - this.downPoint.x, motionEvent.getY() - this.downPoint.y) < 5.0f) {
            onSingleTouch(this);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onSingleTouch(android.view.View view) {
        com.up366.mobile.book.studyviews.model.V1ChildViewPager.OnSingleTouchListener onSingleTouchListener = this.onSingleTouchListener;
        if (onSingleTouchListener != null) {
            onSingleTouchListener.onSingleTouch(view);
        }
    }

    public void setOnSingleTouchListener(com.up366.mobile.book.studyviews.model.V1ChildViewPager.OnSingleTouchListener onSingleTouchListener) {
        this.onSingleTouchListener = onSingleTouchListener;
    }

    public boolean isCanMove() {
        return this.isCanMove;
    }

    public void setCanMove(boolean z) {
        this.isCanMove = z;
    }
}
