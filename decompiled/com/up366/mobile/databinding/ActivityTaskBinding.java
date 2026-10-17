package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivityTaskBinding extends androidx.databinding.ViewDataBinding {
    public final com.google.android.material.appbar.AppBarLayout appBar;
    public final com.up366.mobile.common.views.UpScrollExitFrameLayout btClose;
    public final androidx.constraintlayout.widget.ConstraintLayout clBook;
    public final androidx.constraintlayout.widget.ConstraintLayout clTab;
    public final android.widget.ImageButton ibStrangeWord;
    public final android.widget.ImageButton ibWrongWord;
    public final android.widget.LinearLayout llSelectBook;
    public final com.up366.mobile.common.views.MaxHeightLayout llTeacherAsk;
    public final android.widget.FrameLayout rootLayout;
    public final androidx.recyclerview.widget.RecyclerView rvAsk;
    public final android.widget.EditText search;
    public final androidx.appcompat.widget.SwitchCompat switchOnlyUnanswered;
    public final com.up366.qmui.widget.tab.QMUITabSegment tabSegment;
    public final com.up366.mobile.common.views.TitleBackView titleBackView;
    public final androidx.appcompat.widget.Toolbar toolbar;
    public final com.up366.mobile.common.views.CollapsingToolbarLayout toolbarLayout;
    public final android.widget.TextView tvCurrentSelectBook;
    public final android.widget.CheckedTextView tvHistorySelectBook;
    public final android.widget.TextView tvSort;
    public final androidx.viewpager.widget.ViewPager viewpager;

    protected ActivityTaskBinding(java.lang.Object obj, android.view.View view, int i, com.google.android.material.appbar.AppBarLayout appBarLayout, com.up366.mobile.common.views.UpScrollExitFrameLayout upScrollExitFrameLayout, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, android.widget.ImageButton imageButton, android.widget.ImageButton imageButton2, android.widget.LinearLayout linearLayout, com.up366.mobile.common.views.MaxHeightLayout maxHeightLayout, android.widget.FrameLayout frameLayout, androidx.recyclerview.widget.RecyclerView recyclerView, android.widget.EditText editText, androidx.appcompat.widget.SwitchCompat switchCompat, com.up366.qmui.widget.tab.QMUITabSegment qMUITabSegment, com.up366.mobile.common.views.TitleBackView titleBackView, androidx.appcompat.widget.Toolbar toolbar, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, android.widget.TextView textView, android.widget.CheckedTextView checkedTextView, android.widget.TextView textView2, androidx.viewpager.widget.ViewPager viewPager) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.btClose = upScrollExitFrameLayout;
        this.clBook = constraintLayout;
        this.clTab = constraintLayout2;
        this.ibStrangeWord = imageButton;
        this.ibWrongWord = imageButton2;
        this.llSelectBook = linearLayout;
        this.llTeacherAsk = maxHeightLayout;
        this.rootLayout = frameLayout;
        this.rvAsk = recyclerView;
        this.search = editText;
        this.switchOnlyUnanswered = switchCompat;
        this.tabSegment = qMUITabSegment;
        this.titleBackView = titleBackView;
        this.toolbar = toolbar;
        this.toolbarLayout = collapsingToolbarLayout;
        this.tvCurrentSelectBook = textView;
        this.tvHistorySelectBook = checkedTextView;
        this.tvSort = textView2;
        this.viewpager = viewPager;
    }

    public static com.up366.mobile.databinding.ActivityTaskBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityTaskBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityTaskBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_task, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ActivityTaskBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityTaskBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityTaskBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.activity_task, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ActivityTaskBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ActivityTaskBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ActivityTaskBinding) bind(obj, view, com.up366.mobile.R.layout.activity_task);
    }
}
