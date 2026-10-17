package com.up366.photopicker.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Up366PhotoPickerActivityGalleryBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.ImageButton btnBack;
    public final android.widget.TextView btnCancel;
    public final android.widget.Button btnConfirm;
    public final androidx.recyclerview.widget.RecyclerView galleryRecycler;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final androidx.constraintlayout.widget.ConstraintLayout topBar;
    public final android.view.View topBarDivider;
    public final android.widget.TextView tvTitle;

    private Up366PhotoPickerActivityGalleryBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.ImageButton imageButton, android.widget.TextView textView, android.widget.Button button, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, android.view.View view, android.widget.TextView textView2) {
        this.rootView = constraintLayout;
        this.btnBack = imageButton;
        this.btnCancel = textView;
        this.btnConfirm = button;
        this.galleryRecycler = recyclerView;
        this.topBar = constraintLayout2;
        this.topBarDivider = view;
        this.tvTitle = textView2;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityGalleryBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityGalleryBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.photopicker.R.layout.up366_photo_picker_activity_gallery, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.photopicker.databinding.Up366PhotoPickerActivityGalleryBinding bind(android.view.View view) {
        androidx.recyclerview.widget.RecyclerView recyclerViewFindChildViewById;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayoutFindChildViewById;
        android.view.View viewFindChildViewById;
        int i = com.up366.photopicker.R.id.btnBack;
        android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = com.up366.photopicker.R.id.btnCancel;
            android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = com.up366.photopicker.R.id.btnConfirm;
                android.widget.Button button = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                if (button != null && (recyclerViewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.up366.photopicker.R.id.galleryRecycler))) != null && (constraintLayoutFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.up366.photopicker.R.id.topBar))) != null && (viewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, (i = com.up366.photopicker.R.id.topBarDivider))) != null) {
                    i = com.up366.photopicker.R.id.tvTitle;
                    android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new com.up366.photopicker.databinding.Up366PhotoPickerActivityGalleryBinding((androidx.constraintlayout.widget.ConstraintLayout) view, imageButton, textView, button, recyclerViewFindChildViewById, constraintLayoutFindChildViewById, viewFindChildViewById, textView2);
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
