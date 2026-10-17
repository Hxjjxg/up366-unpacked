package com.up366.view.crop.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class UCropView extends android.widget.FrameLayout {
    private com.up366.view.crop.view.GestureCropImageView mGestureCropImageView;
    private final com.up366.view.crop.view.OverlayView mViewOverlay;

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public UCropView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UCropView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        android.view.LayoutInflater.from(context).inflate(com.up366.view.R.layout.ucrop_view_inside_views, (android.view.ViewGroup) this, true);
        this.mGestureCropImageView = (com.up366.view.crop.view.GestureCropImageView) findViewById(com.up366.view.R.id.image_view_crop);
        com.up366.view.crop.view.OverlayView overlayView = (com.up366.view.crop.view.OverlayView) findViewById(com.up366.view.R.id.view_overlay);
        this.mViewOverlay = overlayView;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.view.R.styleable.ucrop_UCropView);
        overlayView.processStyledAttributes(typedArrayObtainStyledAttributes);
        this.mGestureCropImageView.processStyledAttributes(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        setListenersToViews();
    }

    private void setListenersToViews() {
        this.mGestureCropImageView.setCropBoundsChangeListener(new com.up366.view.crop.callback.CropBoundsChangeListener() { // from class: com.up366.view.crop.view.UCropView.1
            @Override // com.up366.view.crop.callback.CropBoundsChangeListener
            public void onCropAspectRatioChanged(float f) {
                com.up366.view.crop.view.UCropView.this.mViewOverlay.setTargetAspectRatio(f);
            }
        });
        this.mViewOverlay.setOverlayViewChangeListener(new com.up366.view.crop.callback.OverlayViewChangeListener() { // from class: com.up366.view.crop.view.UCropView.2
            @Override // com.up366.view.crop.callback.OverlayViewChangeListener
            public void onCropRectUpdated(android.graphics.RectF rectF) {
                com.up366.view.crop.view.UCropView.this.mGestureCropImageView.setCropRect(rectF);
            }
        });
    }

    public com.up366.view.crop.view.GestureCropImageView getCropImageView() {
        return this.mGestureCropImageView;
    }

    public com.up366.view.crop.view.OverlayView getOverlayView() {
        return this.mViewOverlay;
    }

    public void resetCropImageView() {
        removeView(this.mGestureCropImageView);
        this.mGestureCropImageView = new com.up366.view.crop.view.GestureCropImageView(getContext());
        setListenersToViews();
        this.mGestureCropImageView.setCropRect(getOverlayView().getCropViewRect());
        addView((android.view.View) this.mGestureCropImageView, 0);
    }
}
