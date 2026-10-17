package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class DifficultyLevelDialogLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.ImageView btnClose;
    public final android.widget.TextView btnConfirm;
    public final android.widget.RelativeLayout difficultyLevel1;
    public final android.widget.RelativeLayout difficultyLevel2;
    public final android.widget.RelativeLayout difficultyLevel3;
    public final android.widget.RelativeLayout difficultyLevel4;
    public final android.widget.RelativeLayout difficultyLevel5;
    public final android.widget.ImageView imageView6;
    public final android.widget.TextView levelText1;
    public final android.widget.TextView levelText2;
    public final android.widget.TextView levelText3;
    public final android.widget.TextView levelText4;
    public final android.widget.TextView levelText5;
    public final android.widget.RadioButton radioButton1;
    public final android.widget.RadioButton radioButton2;
    public final android.widget.RadioButton radioButton3;
    public final android.widget.RadioButton radioButton4;
    public final android.widget.RadioButton radioButton5;

    protected DifficultyLevelDialogLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.ImageView imageView, android.widget.TextView textView, android.widget.RelativeLayout relativeLayout, android.widget.RelativeLayout relativeLayout2, android.widget.RelativeLayout relativeLayout3, android.widget.RelativeLayout relativeLayout4, android.widget.RelativeLayout relativeLayout5, android.widget.ImageView imageView2, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.RadioButton radioButton, android.widget.RadioButton radioButton2, android.widget.RadioButton radioButton3, android.widget.RadioButton radioButton4, android.widget.RadioButton radioButton5) {
        super(obj, view, i);
        this.btnClose = imageView;
        this.btnConfirm = textView;
        this.difficultyLevel1 = relativeLayout;
        this.difficultyLevel2 = relativeLayout2;
        this.difficultyLevel3 = relativeLayout3;
        this.difficultyLevel4 = relativeLayout4;
        this.difficultyLevel5 = relativeLayout5;
        this.imageView6 = imageView2;
        this.levelText1 = textView2;
        this.levelText2 = textView3;
        this.levelText3 = textView4;
        this.levelText4 = textView5;
        this.levelText5 = textView6;
        this.radioButton1 = radioButton;
        this.radioButton2 = radioButton2;
        this.radioButton3 = radioButton3;
        this.radioButton4 = radioButton4;
        this.radioButton5 = radioButton5;
    }

    public static com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.difficulty_level_dialog_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.difficulty_level_dialog_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.DifficultyLevelDialogLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.difficulty_level_dialog_layout);
    }
}
