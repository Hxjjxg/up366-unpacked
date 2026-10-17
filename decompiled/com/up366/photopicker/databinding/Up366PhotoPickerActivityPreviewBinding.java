package com.up366.photopicker.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Up366PhotoPickerActivityPreviewBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageView previewImage;
    private final android.widget.FrameLayout rootView;

    private Up366PhotoPickerActivityPreviewBinding(android.widget.FrameLayout frameLayout, android.widget.ImageView imageView) {
        this.rootView = frameLayout;
        this.previewImage = imageView;
    }

    public android.widget.FrameLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityPreviewBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityPreviewBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.photopicker.R.layout.up366_photo_picker_activity_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityPreviewBinding bind(android.view.View view) {
        int i = com.up366.photopicker.R.id.previewImage;
        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            return new com.up366.photopicker.databinding.Up366PhotoPickerActivityPreviewBinding((android.widget.FrameLayout) view, imageView);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
