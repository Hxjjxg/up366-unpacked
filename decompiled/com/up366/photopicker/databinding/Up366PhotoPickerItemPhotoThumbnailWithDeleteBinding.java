package com.up366.photopicker.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Up366PhotoPickerItemPhotoThumbnailWithDeleteBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageView deleteButton;
    private final android.widget.FrameLayout rootView;
    public final android.view.View selectedIndicator;
    public final android.widget.ImageView thumbnailImage;

    private Up366PhotoPickerItemPhotoThumbnailWithDeleteBinding(android.widget.FrameLayout frameLayout, android.widget.ImageView imageView, android.view.View view, android.widget.ImageView imageView2) {
        this.rootView = frameLayout;
        this.deleteButton = imageView;
        this.selectedIndicator = view;
        this.thumbnailImage = imageView2;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerItemPhotoThumbnailWithDeleteBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerItemPhotoThumbnailWithDeleteBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.photopicker.R.layout.up366_photo_picker_item_photo_thumbnail_with_delete, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerItemPhotoThumbnailWithDeleteBinding bind(android.view.View view) {
        android.view.View viewFindChildViewById;
        int i = com.up366.photopicker.R.id.deleteButton;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null && (viewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.up366.photopicker.R.id.selectedIndicator))) != null) {
            i = com.up366.photopicker.R.id.thumbnailImage;
            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                return new com.up366.photopicker.databinding.Up366PhotoPickerItemPhotoThumbnailWithDeleteBinding((android.widget.FrameLayout) view, imageView, viewFindChildViewById, imageView2);
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
