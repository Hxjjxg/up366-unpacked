package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class OralFeedbackDialogBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView sfCancle;
    public final android.widget.ImageView sfIcon;
    public final android.widget.TextView sfMessage;
    public final android.widget.TextView sfRetry;
    public final android.widget.TextView sfTitle;
    public final android.widget.TextView slCancle;
    public final android.widget.TextView slDescription;
    public final android.widget.RadioGroup slFeedbackTypeGroup;
    public final android.widget.TextView slFeedbackTypeTitle;
    public final android.widget.RadioButton slScoreHigh;
    public final android.widget.RadioButton slScoreLow;
    public final android.widget.TextView slSubmit;
    public final android.widget.TextView slTitle;
    public final android.widget.ImageView ssIcon;
    public final android.widget.TextView ssMessage;
    public final android.widget.TextView ssTitle;
    public final androidx.constraintlayout.widget.ConstraintLayout stateFailed;
    public final androidx.constraintlayout.widget.ConstraintLayout stateSelect;
    public final androidx.constraintlayout.widget.ConstraintLayout stateSuccess;
    public final androidx.constraintlayout.widget.ConstraintLayout stateUploading;
    public final android.widget.TextView suMessage;
    public final android.widget.ProgressBar suProgressBar;
    public final android.widget.TextView suProgressText;
    public final android.widget.TextView suTitle;

    protected OralFeedbackDialogBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.ImageView imageView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.RadioGroup radioGroup, android.widget.TextView textView7, android.widget.RadioButton radioButton, android.widget.RadioButton radioButton2, android.widget.TextView textView8, android.widget.TextView textView9, android.widget.ImageView imageView2, android.widget.TextView textView10, android.widget.TextView textView11, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, androidx.constraintlayout.widget.ConstraintLayout constraintLayout3, androidx.constraintlayout.widget.ConstraintLayout constraintLayout4, android.widget.TextView textView12, android.widget.ProgressBar progressBar, android.widget.TextView textView13, android.widget.TextView textView14) {
        super(obj, view, i);
        this.sfCancle = textView;
        this.sfIcon = imageView;
        this.sfMessage = textView2;
        this.sfRetry = textView3;
        this.sfTitle = textView4;
        this.slCancle = textView5;
        this.slDescription = textView6;
        this.slFeedbackTypeGroup = radioGroup;
        this.slFeedbackTypeTitle = textView7;
        this.slScoreHigh = radioButton;
        this.slScoreLow = radioButton2;
        this.slSubmit = textView8;
        this.slTitle = textView9;
        this.ssIcon = imageView2;
        this.ssMessage = textView10;
        this.ssTitle = textView11;
        this.stateFailed = constraintLayout;
        this.stateSelect = constraintLayout2;
        this.stateSuccess = constraintLayout3;
        this.stateUploading = constraintLayout4;
        this.suMessage = textView12;
        this.suProgressBar = progressBar;
        this.suProgressText = textView13;
        this.suTitle = textView14;
    }

    public static com.up366.mobile.databinding.OralFeedbackDialogBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.OralFeedbackDialogBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.OralFeedbackDialogBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.oral_feedback_dialog, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.OralFeedbackDialogBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.OralFeedbackDialogBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.OralFeedbackDialogBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.oral_feedback_dialog, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.OralFeedbackDialogBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.OralFeedbackDialogBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.OralFeedbackDialogBinding) bind(obj, view, com.up366.mobile.R.layout.oral_feedback_dialog);
    }
}
