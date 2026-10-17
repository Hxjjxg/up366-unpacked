package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class MeAddTearchingClassAcivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView addHowGetCourse;
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final android.widget.TextView approveBtn;
    public final android.widget.ImageView approveLoading;
    public final android.widget.TextView approveStatus;
    public final android.widget.LinearLayout contentLayout;
    public final androidx.constraintlayout.widget.ConstraintLayout courseInfoLayout;
    public final android.widget.TextView courseName;
    public final com.up366.mobile.common.views.EmptyStateView emptyState;
    public final android.view.View placeHolder;
    public final android.widget.ImageView qrSearchClass;
    public final com.up366.mobile.common.views.CommonEditText searchText;
    public final android.widget.ImageView searcherDeleteImage;
    public final android.widget.ImageView searcherImage;
    public final android.widget.TextView teacherName;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;

    protected MeAddTearchingClassAcivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView2, android.widget.ImageView imageView, android.widget.TextView textView3, android.widget.LinearLayout linearLayout, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView4, com.up366.mobile.common.views.EmptyStateView emptyStateView, android.view.View view2, android.widget.ImageView imageView2, com.up366.mobile.common.views.CommonEditText commonEditText, android.widget.ImageView imageView3, android.widget.ImageView imageView4, android.widget.TextView textView5, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        super(obj, view, i);
        this.addHowGetCourse = textView;
        this.appBar = appBarLayout;
        this.approveBtn = textView2;
        this.approveLoading = imageView;
        this.approveStatus = textView3;
        this.contentLayout = linearLayout;
        this.courseInfoLayout = constraintLayout;
        this.courseName = textView4;
        this.emptyState = emptyStateView;
        this.placeHolder = view2;
        this.qrSearchClass = imageView2;
        this.searchText = commonEditText;
        this.searcherDeleteImage = imageView3;
        this.searcherImage = imageView4;
        this.teacherName = textView5;
        this.toolbarLayout = collapsingToolbarLayout;
    }

    public static com.up366.mobile.databinding.MeAddTearchingClassAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeAddTearchingClassAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeAddTearchingClassAcivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_add_tearching_class_acivity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.MeAddTearchingClassAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeAddTearchingClassAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeAddTearchingClassAcivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.me_add_tearching_class_acivity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.MeAddTearchingClassAcivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.MeAddTearchingClassAcivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.MeAddTearchingClassAcivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.me_add_tearching_class_acivity_layout);
    }
}
