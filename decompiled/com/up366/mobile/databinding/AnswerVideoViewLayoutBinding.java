package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class AnswerVideoViewLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.FrameLayout alphaLayer;
    public final android.widget.ImageButton avvErrorRefresh;
    public final android.widget.TextView avvErrorTipInfo;
    public final android.widget.ImageView avvPost;
    public final android.view.SurfaceView avvSurface;
    public final android.widget.LinearLayout ctrlContent;
    public final android.widget.LinearLayout errTip;
    public final android.widget.ImageButton fullBtn;
    public final android.widget.ProgressBar loadProgress;
    public final android.widget.TextView loadProgressText;
    public final android.widget.LinearLayout loadTip;
    public final android.widget.ImageButton playBtn;
    public final android.widget.ImageButton playBtnStatic;
    public final android.widget.ImageButton playMain;
    public final androidx.core.widget.ContentLoadingProgressBar progress;
    public final android.widget.SeekBar seekBar;
    public final android.widget.SeekBar seekBarStatic;
    public final android.widget.LinearLayout staticControlBar;
    public final android.widget.TextView timeTextCur;
    public final android.widget.TextView timeTextCurStatic;
    public final android.widget.TextView timeTextTot;
    public final android.widget.TextView timeTextTotStatic;
    public final android.widget.FrameLayout videoLayout;

    protected AnswerVideoViewLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.FrameLayout frameLayout, android.widget.ImageButton imageButton, android.widget.TextView textView, android.widget.ImageView imageView, android.view.SurfaceView surfaceView, android.widget.LinearLayout linearLayout, android.widget.LinearLayout linearLayout2, android.widget.ImageButton imageButton2, android.widget.ProgressBar progressBar, android.widget.TextView textView2, android.widget.LinearLayout linearLayout3, android.widget.ImageButton imageButton3, android.widget.ImageButton imageButton4, android.widget.ImageButton imageButton5, androidx.core.widget.ContentLoadingProgressBar contentLoadingProgressBar, android.widget.SeekBar seekBar, android.widget.SeekBar seekBar2, android.widget.LinearLayout linearLayout4, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.FrameLayout frameLayout2) {
        super(obj, view, i);
        this.alphaLayer = frameLayout;
        this.avvErrorRefresh = imageButton;
        this.avvErrorTipInfo = textView;
        this.avvPost = imageView;
        this.avvSurface = surfaceView;
        this.ctrlContent = linearLayout;
        this.errTip = linearLayout2;
        this.fullBtn = imageButton2;
        this.loadProgress = progressBar;
        this.loadProgressText = textView2;
        this.loadTip = linearLayout3;
        this.playBtn = imageButton3;
        this.playBtnStatic = imageButton4;
        this.playMain = imageButton5;
        this.progress = contentLoadingProgressBar;
        this.seekBar = seekBar;
        this.seekBarStatic = seekBar2;
        this.staticControlBar = linearLayout4;
        this.timeTextCur = textView3;
        this.timeTextCurStatic = textView4;
        this.timeTextTot = textView5;
        this.timeTextTotStatic = textView6;
        this.videoLayout = frameLayout2;
    }

    public static com.up366.mobile.databinding.AnswerVideoViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AnswerVideoViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AnswerVideoViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.answer_video_view_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.AnswerVideoViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AnswerVideoViewLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AnswerVideoViewLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.answer_video_view_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.AnswerVideoViewLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.AnswerVideoViewLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.AnswerVideoViewLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.answer_video_view_layout);
    }
}
