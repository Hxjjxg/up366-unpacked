package com.up366.medialibrary.third.photoview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class CustomGestureDetector {
    private static final int INVALID_POINTER_ID = -1;
    private int mActivePointerId = -1;
    private int mActivePointerIndex = 0;
    private final android.view.ScaleGestureDetector mDetector;
    private boolean mIsDragging;
    private float mLastTouchX;
    private float mLastTouchY;
    private com.up366.medialibrary.third.photoview.OnGestureListener mListener;
    private final float mMinimumVelocity;
    private final float mTouchSlop;
    private android.view.VelocityTracker mVelocityTracker;

    CustomGestureDetector(android.content.Context context, com.up366.medialibrary.third.photoview.OnGestureListener onGestureListener) {
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mListener = onGestureListener;
        this.mDetector = new android.view.ScaleGestureDetector(context, new android.view.ScaleGestureDetector.OnScaleGestureListener() { // from class: com.up366.medialibrary.third.photoview.CustomGestureDetector.1
            private float lastFocusX;
            private float lastFocusY = 0.0f;

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(android.view.ScaleGestureDetector scaleGestureDetector) {
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(android.view.ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (java.lang.Float.isNaN(scaleFactor) || java.lang.Float.isInfinite(scaleFactor)) {
                    return false;
                }
                if (scaleFactor < 0.0f) {
                    return true;
                }
                com.up366.medialibrary.third.photoview.CustomGestureDetector.this.mListener.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), scaleGestureDetector.getFocusX() - this.lastFocusX, scaleGestureDetector.getFocusY() - this.lastFocusY);
                this.lastFocusX = scaleGestureDetector.getFocusX();
                this.lastFocusY = scaleGestureDetector.getFocusY();
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(android.view.ScaleGestureDetector scaleGestureDetector) {
                this.lastFocusX = scaleGestureDetector.getFocusX();
                this.lastFocusY = scaleGestureDetector.getFocusY();
                return true;
            }
        });
    }

    private float getActiveX(android.view.MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.mActivePointerIndex);
        } catch (java.lang.Exception unused) {
            return motionEvent.getX();
        }
    }

    private float getActiveY(android.view.MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.mActivePointerIndex);
        } catch (java.lang.Exception unused) {
            return motionEvent.getY();
        }
    }

    public boolean isScaling() {
        return this.mDetector.isInProgress();
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }

    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            this.mDetector.onTouchEvent(motionEvent);
            return processTouchEvent(motionEvent);
        } catch (java.lang.IllegalArgumentException unused) {
            return true;
        }
    }

    private boolean processTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mActivePointerId = motionEvent.getPointerId(0);
            android.view.VelocityTracker velocityTrackerObtain = android.view.VelocityTracker.obtain();
            this.mVelocityTracker = velocityTrackerObtain;
            if (velocityTrackerObtain != null) {
                velocityTrackerObtain.addMovement(motionEvent);
            }
            this.mLastTouchX = getActiveX(motionEvent);
            this.mLastTouchY = getActiveY(motionEvent);
            this.mIsDragging = false;
        } else if (action == 1) {
            this.mActivePointerId = -1;
            if (this.mIsDragging && this.mVelocityTracker != null) {
                this.mLastTouchX = getActiveX(motionEvent);
                this.mLastTouchY = getActiveY(motionEvent);
                this.mVelocityTracker.addMovement(motionEvent);
                this.mVelocityTracker.computeCurrentVelocity(1000);
                float xVelocity = this.mVelocityTracker.getXVelocity();
                float yVelocity = this.mVelocityTracker.getYVelocity();
                if (java.lang.Math.max(java.lang.Math.abs(xVelocity), java.lang.Math.abs(yVelocity)) >= this.mMinimumVelocity) {
                    this.mListener.onFling(this.mLastTouchX, this.mLastTouchY, -xVelocity, -yVelocity);
                }
            }
            android.view.VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        } else if (action == 2) {
            float activeX = getActiveX(motionEvent);
            float activeY = getActiveY(motionEvent);
            float f = activeX - this.mLastTouchX;
            float f2 = activeY - this.mLastTouchY;
            if (!this.mIsDragging) {
                this.mIsDragging = java.lang.Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.mTouchSlop);
            }
            if (this.mIsDragging) {
                this.mListener.onDrag(f, f2);
                this.mLastTouchX = activeX;
                this.mLastTouchY = activeY;
                android.view.VelocityTracker velocityTracker2 = this.mVelocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.mActivePointerId = -1;
            android.view.VelocityTracker velocityTracker3 = this.mVelocityTracker;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.mVelocityTracker = null;
            }
        } else if (action == 6) {
            int pointerIndex = com.up366.medialibrary.third.photoview.Util.getPointerIndex(motionEvent.getAction());
            if (motionEvent.getPointerId(pointerIndex) == this.mActivePointerId) {
                int i = pointerIndex == 0 ? 1 : 0;
                this.mActivePointerId = motionEvent.getPointerId(i);
                this.mLastTouchX = motionEvent.getX(i);
                this.mLastTouchY = motionEvent.getY(i);
            }
        }
        int i2 = this.mActivePointerId;
        this.mActivePointerIndex = motionEvent.findPointerIndex(i2 != -1 ? i2 : 0);
        return true;
    }
}
