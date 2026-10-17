package com.up366.photopicker.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Up366PhotoPickerActivityCameraBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageButton btnBack;
    public final android.widget.ImageButton btnCapture;
    public final android.widget.TextView btnConfirm;
    public final android.widget.TextView btnFlash;
    public final android.widget.ImageButton btnGrid;
    public final android.widget.TextView btnGuide;
    public final android.widget.LinearLayout cameraControls;
    public final android.view.View captureRectOverlay;
    public final android.widget.TextView counterText;
    public final android.widget.ImageView counterThumbnail;
    public final android.widget.FrameLayout galleryButton;
    public final android.widget.ImageView galleryIcon;
    public final com.up366.photopicker.ui.camera.GridOverlayView gridOverlay;
    public final android.widget.LinearLayout photoThumbnails;
    public final androidx.camera.view.PreviewView previewView;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.HorizontalScrollView scrollPhotos;
    public final android.widget.LinearLayout tabContainer;
    public final android.widget.TextView tabMultiple;
    public final android.widget.TextView tabSingle;
    public final android.widget.TextView tvCaptureHint;
    public final android.widget.TextView tvMaxPageHint;

    private Up366PhotoPickerActivityCameraBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageButton imageButton, android.widget.ImageButton imageButton2, android.widget.TextView textView, android.widget.TextView textView2, android.widget.ImageButton imageButton3, android.widget.TextView textView3, android.widget.LinearLayout linearLayout, android.view.View view, android.widget.TextView textView4, android.widget.ImageView imageView, android.widget.FrameLayout frameLayout, android.widget.ImageView imageView2, com.up366.photopicker.ui.camera.GridOverlayView gridOverlayView, android.widget.LinearLayout linearLayout2, androidx.camera.view.PreviewView previewView, android.widget.HorizontalScrollView horizontalScrollView, android.widget.LinearLayout linearLayout3, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.TextView textView7, android.widget.TextView textView8) {
        this.rootView = constraintLayout;
        this.btnBack = imageButton;
        this.btnCapture = imageButton2;
        this.btnConfirm = textView;
        this.btnFlash = textView2;
        this.btnGrid = imageButton3;
        this.btnGuide = textView3;
        this.cameraControls = linearLayout;
        this.captureRectOverlay = view;
        this.counterText = textView4;
        this.counterThumbnail = imageView;
        this.galleryButton = frameLayout;
        this.galleryIcon = imageView2;
        this.gridOverlay = gridOverlayView;
        this.photoThumbnails = linearLayout2;
        this.previewView = previewView;
        this.scrollPhotos = horizontalScrollView;
        this.tabContainer = linearLayout3;
        this.tabMultiple = textView5;
        this.tabSingle = textView6;
        this.tvCaptureHint = textView7;
        this.tvMaxPageHint = textView8;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityCameraBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityCameraBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.photopicker.R.layout.up366_photo_picker_activity_camera, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityCameraBinding bind(android.view.View view) {
        android.view.View viewFindChildViewById;
        androidx.camera.view.PreviewView previewViewFindChildViewById;
        int i = com.up366.photopicker.R.id.btnBack;
        android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = com.up366.photopicker.R.id.btnCapture;
            android.widget.ImageButton imageButton2 = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageButton2 != null) {
                i = com.up366.photopicker.R.id.btnConfirm;
                android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = com.up366.photopicker.R.id.btnFlash;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = com.up366.photopicker.R.id.btnGrid;
                        android.widget.ImageButton imageButton3 = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                        if (imageButton3 != null) {
                            i = com.up366.photopicker.R.id.btnGuide;
                            android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = com.up366.photopicker.R.id.cameraControls;
                                android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null && (viewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.up366.photopicker.R.id.captureRectOverlay))) != null) {
                                    i = com.up366.photopicker.R.id.counterText;
                                    android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = com.up366.photopicker.R.id.counterThumbnail;
                                        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                        if (imageView != null) {
                                            i = com.up366.photopicker.R.id.galleryButton;
                                            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                            if (frameLayout != null) {
                                                i = com.up366.photopicker.R.id.galleryIcon;
                                                android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                if (imageView2 != null) {
                                                    i = com.up366.photopicker.R.id.gridOverlay;
                                                    com.up366.photopicker.ui.camera.GridOverlayView gridOverlayView = (com.up366.photopicker.ui.camera.GridOverlayView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                    if (gridOverlayView != null) {
                                                        i = com.up366.photopicker.R.id.photoThumbnails;
                                                        android.widget.LinearLayout linearLayout2 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout2 != null && (previewViewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.up366.photopicker.R.id.previewView))) != null) {
                                                            i = com.up366.photopicker.R.id.scrollPhotos;
                                                            android.widget.HorizontalScrollView horizontalScrollView = (android.widget.HorizontalScrollView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                            if (horizontalScrollView != null) {
                                                                i = com.up366.photopicker.R.id.tabContainer;
                                                                android.widget.LinearLayout linearLayout3 = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout3 != null) {
                                                                    i = com.up366.photopicker.R.id.tabMultiple;
                                                                    android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                    if (textView5 != null) {
                                                                        i = com.up366.photopicker.R.id.tabSingle;
                                                                        android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = com.up366.photopicker.R.id.tvCaptureHint;
                                                                            android.widget.TextView textView7 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                            if (textView7 != null) {
                                                                                i = com.up366.photopicker.R.id.tvMaxPageHint;
                                                                                android.widget.TextView textView8 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                                                                                if (textView8 != null) {
                                                                                    return new com.up366.photopicker.databinding.Up366PhotoPickerActivityCameraBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageButton, imageButton2, textView, textView2, imageButton3, textView3, linearLayout, viewFindChildViewById, textView4, imageView, frameLayout, imageView2, gridOverlayView, linearLayout2, previewViewFindChildViewById, horizontalScrollView, linearLayout3, textView5, textView6, textView7, textView8);
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
