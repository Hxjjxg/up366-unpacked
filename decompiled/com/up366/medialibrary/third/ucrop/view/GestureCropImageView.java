package com.up366.medialibrary.third.ucrop.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GestureCropImageView extends com.up366.medialibrary.third.ucrop.view.CropImageView {
    private static final int DOUBLE_TAP_ZOOM_DURATION = 200;
    private int mDoubleTapScaleSteps;
    private android.view.GestureDetector mGestureDetector;
    private boolean mIsRotateEnabled;
    private boolean mIsScaleEnabled;
    private float mMidPntX;
    private float mMidPntY;
    private com.up366.medialibrary.third.ucrop.util.RotationGestureDetector mRotateDetector;
    private android.view.ScaleGestureDetector mScaleDetector;

    public GestureCropImageView(android.content.Context context) {
        super(context);
        this.mIsRotateEnabled = true;
        this.mIsScaleEnabled = true;
        this.mDoubleTapScaleSteps = 5;
    }

    public GestureCropImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsRotateEnabled = true;
        this.mIsScaleEnabled = true;
        this.mDoubleTapScaleSteps = 5;
    }

    public void setScaleEnabled(boolean z) {
        this.mIsScaleEnabled = z;
    }

    public boolean isScaleEnabled() {
        return this.mIsScaleEnabled;
    }

    public void setRotateEnabled(boolean z) {
        this.mIsRotateEnabled = z;
    }

    public boolean isRotateEnabled() {
        return this.mIsRotateEnabled;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.mDoubleTapScaleSteps = i;
    }

    public int getDoubleTapScaleSteps() {
        return this.mDoubleTapScaleSteps;
    }

    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            cancelAllAnimations();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.mMidPntX = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.mMidPntY = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        if (this.mIsScaleEnabled) {
            this.mScaleDetector.onTouchEvent(motionEvent);
        }
        if (this.mIsRotateEnabled) {
            this.mRotateDetector.onTouchEvent(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            setImageToWrapCropBounds();
        }
        return true;
    }

    @Override // com.up366.medialibrary.third.ucrop.view.TransformImageView
    protected void init() {
        super.init();
        setupGestureListeners();
    }

    protected float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) java.lang.Math.pow(getMaxScale() / getMinScale(), 1.0f / this.mDoubleTapScaleSteps));
    }

    private void setupGestureListeners() {
        this.mGestureDetector = new android.view.GestureDetector(getContext(), new com.up366.medialibrary.third.ucrop.view.GestureCropImageView.GestureListener(), null, true);
        this.mScaleDetector = new android.view.ScaleGestureDetector(getContext(), new com.up366.medialibrary.third.ucrop.view.GestureCropImageView.ScaleListener());
        this.mRotateDetector = new com.up366.medialibrary.third.ucrop.util.RotationGestureDetector(new com.up366.medialibrary.third.ucrop.view.GestureCropImageView.RotateListener());
    }

    private class ScaleListener extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(android.view.ScaleGestureDetector scaleGestureDetector) {
            com.up366.medialibrary.third.ucrop.view.GestureCropImageView.this.postScale(scaleGestureDetector.getScaleFactor(), com.up366.medialibrary.third.ucrop.view.GestureCropImageView.this.mMidPntX, com.up366.medialibrary.third.ucrop.view.GestureCropImageView.this.mMidPntY);
            return true;
        }
    }

    private class GestureListener extends android.view.GestureDetector.SimpleOnGestureListener {
        private GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(android.view.MotionEvent motionEvent) {
            com.up366.medialibrary.third.ucrop.view.GestureCropImageView gestureCropImageView = com.up366.medialibrary.third.ucrop.view.GestureCropImageView.this;
            gestureCropImageView.zoomImageToPosition(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200L);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
            com.up366.medialibrary.third.ucrop.view.GestureCropImageView.this.postTranslate(-f, -f2);
            return true;
        }
    }

    private class RotateListener extends com.up366.medialibrary.third.ucrop.util.RotationGestureDetector.SimpleOnRotationGestureListener {
        private RotateListener() {
        }

        @Override // com.up366.medialibrary.third.ucrop.util.RotationGestureDetector.SimpleOnRotationGestureListener, com.up366.medialibrary.third.ucrop.util.RotationGestureDetector.OnRotationGestureListener
        public boolean onRotation(com.up366.medialibrary.third.ucrop.util.RotationGestureDetector rotationGestureDetector) {
            com.up366.medialibrary.third.ucrop.view.GestureCropImageView.this.postRotate(rotationGestureDetector.getAngle(), com.up366.medialibrary.third.ucrop.view.GestureCropImageView.this.mMidPntX, com.up366.medialibrary.third.ucrop.view.GestureCropImageView.this.mMidPntY);
            return true;
        }
    }
}
