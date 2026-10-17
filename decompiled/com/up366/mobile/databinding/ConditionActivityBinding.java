package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ConditionActivityBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView btnConfirm;
    public final android.widget.TextView btnReset;
    public final android.widget.CheckedTextView dateBtnBegin;
    public final android.widget.CheckedTextView dateBtnEnd;
    public final android.widget.LinearLayout dateBtnLl;
    public final android.widget.LinearLayout llBookList;
    public final android.widget.LinearLayout llNoteType;
    public final android.widget.LinearLayout llTimeSelect;
    public final android.widget.TextView llTimeSelectTitle;
    public final android.widget.CheckedTextView noteAll;
    public final android.widget.CheckedTextView noteListen;
    public final android.widget.CheckedTextView noteOther;
    public final android.widget.CheckedTextView noteRead;
    public final android.widget.CheckedTextView noteUse;
    public final android.widget.CheckedTextView noteWrite;
    public final androidx.recyclerview.widget.RecyclerView recycleView;
    public final com.ylw.pullrefreshlibrary.PullRefreshLayout refreshLayout;
    public final android.widget.CheckedTextView timeBtnAll;
    public final android.widget.CheckedTextView timeBtnMouth;
    public final android.widget.CheckedTextView timeBtnToday;
    public final android.widget.CheckedTextView timeBtnWeek;
    public final com.up366.mobile.common.views.TitleBarView titleBar;
    public final android.widget.TextView tvListTitle;
    public final android.view.View view;

    protected ConditionActivityBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.CheckedTextView checkedTextView, android.widget.CheckedTextView checkedTextView2, android.widget.LinearLayout linearLayout, android.widget.LinearLayout linearLayout2, android.widget.LinearLayout linearLayout3, android.widget.LinearLayout linearLayout4, android.widget.TextView textView3, android.widget.CheckedTextView checkedTextView3, android.widget.CheckedTextView checkedTextView4, android.widget.CheckedTextView checkedTextView5, android.widget.CheckedTextView checkedTextView6, android.widget.CheckedTextView checkedTextView7, android.widget.CheckedTextView checkedTextView8, androidx.recyclerview.widget.RecyclerView recyclerView, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, android.widget.CheckedTextView checkedTextView9, android.widget.CheckedTextView checkedTextView10, android.widget.CheckedTextView checkedTextView11, android.widget.CheckedTextView checkedTextView12, com.up366.mobile.common.views.TitleBarView titleBarView, android.widget.TextView textView4, android.view.View view2) {
        super(obj, view, i);
        this.btnConfirm = textView;
        this.btnReset = textView2;
        this.dateBtnBegin = checkedTextView;
        this.dateBtnEnd = checkedTextView2;
        this.dateBtnLl = linearLayout;
        this.llBookList = linearLayout2;
        this.llNoteType = linearLayout3;
        this.llTimeSelect = linearLayout4;
        this.llTimeSelectTitle = textView3;
        this.noteAll = checkedTextView3;
        this.noteListen = checkedTextView4;
        this.noteOther = checkedTextView5;
        this.noteRead = checkedTextView6;
        this.noteUse = checkedTextView7;
        this.noteWrite = checkedTextView8;
        this.recycleView = recyclerView;
        this.refreshLayout = pullRefreshLayout;
        this.timeBtnAll = checkedTextView9;
        this.timeBtnMouth = checkedTextView10;
        this.timeBtnToday = checkedTextView11;
        this.timeBtnWeek = checkedTextView12;
        this.titleBar = titleBarView;
        this.tvListTitle = textView4;
        this.view = view2;
    }

    public static com.up366.mobile.databinding.ConditionActivityBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ConditionActivityBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ConditionActivityBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.condition_activity, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.ConditionActivityBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ConditionActivityBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ConditionActivityBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.condition_activity, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.ConditionActivityBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.ConditionActivityBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.ConditionActivityBinding) bind(obj, view, com.up366.mobile.R.layout.condition_activity);
    }
}
