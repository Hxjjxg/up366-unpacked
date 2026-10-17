package com.up366.photopicker.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Up366PhotoPickerItemGalleryPhotoBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageView galleryImage;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.ImageView selectedCheck;
    public final android.view.View selectedOverlay;

    private Up366PhotoPickerItemGalleryPhotoBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageView imageView, android.widget.ImageView imageView2, android.view.View view) {
        this.rootView = constraintLayout;
        this.galleryImage = imageView;
        this.selectedCheck = imageView2;
        this.selectedOverlay = view;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerItemGalleryPhotoBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerItemGalleryPhotoBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.photopicker.R.layout.up366_photo_picker_item_gallery_photo, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerItemGalleryPhotoBinding bind(android.view.View view) {
        android.view.View viewFindChildViewById;
        int i = com.up366.photopicker.R.id.galleryImage;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = com.up366.photopicker.R.id.selectedCheck;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null && (viewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.up366.photopicker.R.id.selectedOverlay))) != null) {
                return new com.up366.photopicker.databinding.Up366PhotoPickerItemGalleryPhotoBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageView, imageView2, viewFindChildViewById);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
