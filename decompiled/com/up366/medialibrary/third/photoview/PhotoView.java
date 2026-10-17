package com.up366.medialibrary.third.photoview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PhotoView extends androidx.appcompat.widget.AppCompatImageView {
    private com.up366.medialibrary.third.photoview.PhotoViewAttacher attacher;
    private android.widget.ImageView.ScaleType pendingScaleType;

    public PhotoView(android.content.Context context) {
        this(context, null);
    }

    public PhotoView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        this.attacher = new com.up366.medialibrary.third.photoview.PhotoViewAttacher(this);
        super.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        android.widget.ImageView.ScaleType scaleType = this.pendingScaleType;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.pendingScaleType = null;
        }
    }

    public com.up366.medialibrary.third.photoview.PhotoViewAttacher getAttacher() {
        return this.attacher;
    }

    public android.widget.ImageView.ScaleType getScaleType() {
        return this.attacher.getScaleType();
    }

    public android.graphics.Matrix getImageMatrix() {
        return this.attacher.getImageMatrix();
    }

    public void setOnLongClickListener(android.view.View.OnLongClickListener onLongClickListener) {
        this.attacher.setOnLongClickListener(onLongClickListener);
    }

    public void setOnClickListener(android.view.View.OnClickListener onClickListener) {
        this.attacher.setOnClickListener(onClickListener);
    }

    public void setScaleType(android.widget.ImageView.ScaleType scaleType) {
        com.up366.medialibrary.third.photoview.PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher == null) {
            this.pendingScaleType = scaleType;
        } else {
            photoViewAttacher.setScaleType(scaleType);
        }
    }

    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        super.setImageDrawable(drawable);
        com.up366.medialibrary.third.photoview.PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        com.up366.medialibrary.third.photoview.PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    public void setImageURI(android.net.Uri uri) {
        super.setImageURI(uri);
        com.up366.medialibrary.third.photoview.PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.attacher.update();
        }
        return frame;
    }

    public void setRotationTo(float f) {
        this.attacher.setRotationTo(f);
    }

    public void setRotationBy(float f) {
        this.attacher.setRotationBy(f);
    }

    public boolean isZoomable() {
        return this.attacher.isZoomable();
    }

    public void setZoomable(boolean z) {
        this.attacher.setZoomable(z);
    }

    public android.graphics.RectF getDisplayRect() {
        return this.attacher.getDisplayRect();
    }

    public void getDisplayMatrix(android.graphics.Matrix matrix) {
        this.attacher.getDisplayMatrix(matrix);
    }

    public boolean setDisplayMatrix(android.graphics.Matrix matrix) {
        return this.attacher.setDisplayMatrix(matrix);
    }

    public void getSuppMatrix(android.graphics.Matrix matrix) {
        this.attacher.getSuppMatrix(matrix);
    }

    public boolean setSuppMatrix(android.graphics.Matrix matrix) {
        return this.attacher.setDisplayMatrix(matrix);
    }

    public float getMinimumScale() {
        return this.attacher.getMinimumScale();
    }

    public float getMediumScale() {
        return this.attacher.getMediumScale();
    }

    public float getMaximumScale() {
        return this.attacher.getMaximumScale();
    }

    public float getScale() {
        return this.attacher.getScale();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.attacher.setAllowParentInterceptOnEdge(z);
    }

    public void setMinimumScale(float f) {
        this.attacher.setMinimumScale(f);
    }

    public void setMediumScale(float f) {
        this.attacher.setMediumScale(f);
    }

    public void setMaximumScale(float f) {
        this.attacher.setMaximumScale(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.attacher.setScaleLevels(f, f2, f3);
    }

    public void setOnMatrixChangeListener(com.up366.medialibrary.third.photoview.OnMatrixChangedListener onMatrixChangedListener) {
        this.attacher.setOnMatrixChangeListener(onMatrixChangedListener);
    }

    public void setOnPhotoTapListener(com.up366.medialibrary.third.photoview.OnPhotoTapListener onPhotoTapListener) {
        this.attacher.setOnPhotoTapListener(onPhotoTapListener);
    }

    public void setOnOutsidePhotoTapListener(com.up366.medialibrary.third.photoview.OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.attacher.setOnOutsidePhotoTapListener(onOutsidePhotoTapListener);
    }

    public void setOnViewTapListener(com.up366.medialibrary.third.photoview.OnViewTapListener onViewTapListener) {
        this.attacher.setOnViewTapListener(onViewTapListener);
    }

    public void setOnViewDragListener(com.up366.medialibrary.third.photoview.OnViewDragListener onViewDragListener) {
        this.attacher.setOnViewDragListener(onViewDragListener);
    }

    public void setScale(float f) {
        this.attacher.setScale(f);
    }

    public void setScale(float f, boolean z) {
        this.attacher.setScale(f, z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.attacher.setScale(f, f2, f3, z);
    }

    public void setZoomTransitionDuration(int i) {
        this.attacher.setZoomTransitionDuration(i);
    }

    public void setOnDoubleTapListener(android.view.GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.attacher.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(com.up366.medialibrary.third.photoview.OnScaleChangedListener onScaleChangedListener) {
        this.attacher.setOnScaleChangeListener(onScaleChangedListener);
    }

    public void setOnSingleFlingListener(com.up366.medialibrary.third.photoview.OnSingleFlingListener onSingleFlingListener) {
        this.attacher.setOnSingleFlingListener(onSingleFlingListener);
    }
}
