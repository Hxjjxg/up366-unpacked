package com.up366.photopicker.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Up366PhotoPickerActivityCropBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageButton btnBack;
    public final android.widget.ImageButton btnConfirm;
    public final android.widget.TextView btnGuide;
    public final android.widget.LinearLayout btnRetake;
    public final android.widget.LinearLayout btnRotate;
    public final android.widget.LinearLayout cropControls;
    public final com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifier;
    public final com.up366.photopicker.ui.crop.CropOverlayView cropOverlay;
    public final android.widget.FrameLayout cropViewContainer;
    public final android.widget.FrameLayout imageContainer;
    public final android.widget.ImageView imageToCrop;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView tvCropHint;

    private Up366PhotoPickerActivityCropBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageButton imageButton, android.widget.ImageButton imageButton2, android.widget.TextView textView, android.widget.LinearLayout linearLayout, android.widget.LinearLayout linearLayout2, android.widget.LinearLayout linearLayout3, com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView, com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView, android.widget.FrameLayout frameLayout, android.widget.FrameLayout frameLayout2, android.widget.ImageView imageView, android.widget.TextView textView2) {
        this.rootView = constraintLayout;
        this.btnBack = imageButton;
        this.btnConfirm = imageButton2;
        this.btnGuide = textView;
        this.btnRetake = linearLayout;
        this.btnRotate = linearLayout2;
        this.cropControls = linearLayout3;
        this.cropMagnifier = cropMagnifierView;
        this.cropOverlay = cropOverlayView;
        this.cropViewContainer = frameLayout;
        this.imageContainer = frameLayout2;
        this.imageToCrop = imageView;
        this.tvCropHint = textView2;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityCropBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityCropBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.photopicker.R.layout.up366_photo_picker_activity_crop, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityCropBinding bind(android.view.View view) {
        int i = com.up366.photopicker.R.id.btnBack;
        android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = com.up366.photopicker.R.id.btnConfirm;
            android.widget.ImageButton imageButton2 = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageButton2 != null) {
                i = com.up366.photopicker.R.id.btnGuide;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = com.up366.photopicker.R.id.btnRetake;
                    android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = com.up366.photopicker.R.id.btnRotate;
                        android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = com.up366.photopicker.R.id.cropControls;
                            android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (linearLayout3 != null) {
                                i = com.up366.photopicker.R.id.cropMagnifier;
                                com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView = (com.up366.photopicker.ui.crop.CropMagnifierView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (cropMagnifierView != null) {
                                    i = com.up366.photopicker.R.id.cropOverlay;
                                    com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView = (com.up366.photopicker.ui.crop.CropOverlayView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (cropOverlayView != null) {
                                        i = com.up366.photopicker.R.id.cropViewContainer;
                                        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (frameLayout != null) {
                                            i = com.up366.photopicker.R.id.imageContainer;
                                            android.widget.FrameLayout frameLayout2 = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (frameLayout2 != null) {
                                                i = com.up366.photopicker.R.id.imageToCrop;
                                                android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (imageView != null) {
                                                    i = com.up366.photopicker.R.id.tvCropHint;
                                                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        return new com.up366.photopicker.databinding.Up366PhotoPickerActivityCropBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageButton, imageButton2, textView, linearLayout, linearLayout2, linearLayout3, cropMagnifierView, cropOverlayView, frameLayout, frameLayout2, imageView, textView2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
