package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MePhotoSystemPhotosLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView closeBtn;
    public final android.widget.TextView confirmBtn;
    public final com.up366.mobile.me.views.MaxHeightRecyclerView recycleView;
    public final android.widget.TextView title;

    protected MePhotoSystemPhotosLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, com.up366.mobile.me.views.MaxHeightRecyclerView maxHeightRecyclerView, android.widget.TextView textView3) {
        super(obj, view, i);
        this.closeBtn = textView;
        this.confirmBtn = textView2;
        this.recycleView = maxHeightRecyclerView;
        this.title = textView3;
    }

    public static com.up366.mobile.databinding.MePhotoSystemPhotosLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MePhotoSystemPhotosLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MePhotoSystemPhotosLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_photo_system_photos_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MePhotoSystemPhotosLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MePhotoSystemPhotosLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MePhotoSystemPhotosLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_photo_system_photos_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MePhotoSystemPhotosLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MePhotoSystemPhotosLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MePhotoSystemPhotosLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_photo_system_photos_layout);
    }
}
