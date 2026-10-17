package com.up366.mobile.book.studyviews.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V6AnswerViewPager extends androidx.viewpager.widget.ViewPager {
    private boolean disableLeft;
    private boolean disableRight;
    private boolean disableSlideOnEventLoop;
    private float downPosX;
    private float downPosY;
    private boolean hasCallOnSlideLeft;
    private float minHorizontalDistance;
    private com.up366.mobile.book.studyviews.model.V6AnswerViewPager.OnSlideLeftInterface onSlideLeft;
    private boolean scrollable;

    public interface OnSlideLeftInterface {
        boolean hasRegisterEvent(java.lang.String str);

        void onSlideLeft();
    }

    public V6AnswerViewPager(android.content.Context context) {
        super(context);
        this.downPosX = 0.0f;
        this.downPosY = 0.0f;
        this.scrollable = true;
        this.minHorizontalDistance = 3.0f;
        init();
    }

    public V6AnswerViewPager(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downPosX = 0.0f;
        this.downPosY = 0.0f;
        this.scrollable = true;
        this.minHorizontalDistance = 3.0f;
        init();
    }

    private void init() {
        this.minHorizontalDistance = android.view.ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public void setScrollable(boolean z) {
        this.scrollable = z;
    }

    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (!this.scrollable || this.disableSlideOnEventLoop) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!this.scrollable || this.disableSlideOnEventLoop) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.hasCallOnSlideLeft = false;
            this.disableSlideOnEventLoop = false;
            this.downPosX = motionEvent.getX();
            this.downPosY = motionEvent.getY();
        } else if (action == 1) {
            try {
                super.onTouchEvent(motionEvent);
            } catch (java.lang.Exception unused) {
                motionEvent.setAction(3);
                super.onTouchEvent(motionEvent);
            }
        } else if (action == 2) {
            float x = motionEvent.getX() - this.downPosX;
            float y = motionEvent.getY() - this.downPosY;
            if (y == 0.0f) {
                y = 1.0E-4f;
            }
            if (java.lang.Math.abs(x / y) > 2.0f && (-x) > this.minHorizontalDistance && this.disableLeft) {
                com.up366.mobile.book.studyviews.model.V6AnswerViewPager.OnSlideLeftInterface onSlideLeftInterface = this.onSlideLeft;
                if (onSlideLeftInterface != null && onSlideLeftInterface.hasRegisterEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_LEFT_SLIDER) && !this.hasCallOnSlideLeft) {
                    this.hasCallOnSlideLeft = true;
                    this.onSlideLeft.onSlideLeft();
                    motionEvent.setAction(3);
                } else {
                    this.disableSlideOnEventLoop = true;
                }
            } else if (x > this.minHorizontalDistance && this.disableRight) {
                this.disableSlideOnEventLoop = true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - 2019/5/21 - V6AnswerViewPager - onMeasure - ", e);
            com.up366.mobile.common.onlinelog.OpLog.report("V6AnswerViewPager-ERROR", "TAG - 2019/5/21 - V6AnswerViewPager - onMeasure - ", e);
        }
    }

    public void setOnSlideLeft(com.up366.mobile.book.studyviews.model.V6AnswerViewPager.OnSlideLeftInterface onSlideLeftInterface) {
        this.onSlideLeft = onSlideLeftInterface;
    }

    public void disableRightSlide(boolean z) {
        this.disableRight = z;
    }

    public void disableLeftSlide(boolean z) {
        this.disableLeft = z;
    }

    public android.view.ViewGroup.LayoutParams getLayoutParams() {
        android.view.ViewGroup.LayoutParams layoutParams = super.getLayoutParams();
        return layoutParams == null ? new android.view.ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }
}
