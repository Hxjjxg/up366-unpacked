package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class FeedbackTaskRecordDialogBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView percentText;
    public final android.widget.TextView sfCancel;
    public final android.widget.TextView sfContinue;
    public final android.widget.TextView sfMessage;
    public final android.widget.ProgressBar spProgress;
    public final android.widget.TextView spTitle;
    public final android.widget.TextView stCancel;
    public final android.widget.TextView stContinue;
    public final android.widget.TextView stMessage;
    public final android.widget.LinearLayout stateFailed;
    public final android.widget.LinearLayout stateProgress;
    public final android.widget.LinearLayout stateSuccess;
    public final android.widget.LinearLayout stateTip;

    protected FeedbackTaskRecordDialogBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.ProgressBar progressBar, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.TextView textView7, android.widget.TextView textView8, android.widget.LinearLayout linearLayout, android.widget.LinearLayout linearLayout2, android.widget.LinearLayout linearLayout3, android.widget.LinearLayout linearLayout4) {
        super(obj, view, i);
        this.percentText = textView;
        this.sfCancel = textView2;
        this.sfContinue = textView3;
        this.sfMessage = textView4;
        this.spProgress = progressBar;
        this.spTitle = textView5;
        this.stCancel = textView6;
        this.stContinue = textView7;
        this.stMessage = textView8;
        this.stateFailed = linearLayout;
        this.stateProgress = linearLayout2;
        this.stateSuccess = linearLayout3;
        this.stateTip = linearLayout4;
    }

    public static com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.feedback_task_record_dialog, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.feedback_task_record_dialog, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.FeedbackTaskRecordDialogBinding) bind(obj, view, com.up366.mobile.R.layout.feedback_task_record_dialog);
    }
}
