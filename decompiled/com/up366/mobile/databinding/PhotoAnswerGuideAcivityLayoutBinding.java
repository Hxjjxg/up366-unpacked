package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class PhotoAnswerGuideAcivityLayoutBinding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView btnIKnow;
    public final android.widget.LinearLayout btnLayoutThree;
    public final android.widget.LinearLayout btnLayoutTwo;
    public final android.widget.TextView btnNext;
    public final android.widget.TextView btnNextTwo;
    public final android.widget.TextView btnPrev;
    public final android.widget.TextView btnPrevTwo;
    public final android.widget.ImageView image1;
    public final android.widget.ImageView image2;
    public final android.widget.ImageView image3;
    public final android.widget.ImageView image4;
    public final android.widget.ScrollView imageLayout;
    public final android.widget.TextView title;

    protected PhotoAnswerGuideAcivityLayoutBinding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.LinearLayout linearLayout, android.widget.LinearLayout linearLayout2, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.ImageView imageView, android.widget.ImageView imageView2, android.widget.ImageView imageView3, android.widget.ImageView imageView4, android.widget.ScrollView scrollView, android.widget.TextView textView6) {
        super(obj, view, i);
        this.btnIKnow = textView;
        this.btnLayoutThree = linearLayout;
        this.btnLayoutTwo = linearLayout2;
        this.btnNext = textView2;
        this.btnNextTwo = textView3;
        this.btnPrev = textView4;
        this.btnPrevTwo = textView5;
        this.image1 = imageView;
        this.image2 = imageView2;
        this.image3 = imageView3;
        this.image4 = imageView4;
        this.imageLayout = scrollView;
        this.title = textView6;
    }

    public static com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.photo_answer_guide_acivity_layout, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.photo_answer_guide_acivity_layout, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding) bind(obj, view, com.up366.mobile.R.layout.photo_answer_guide_acivity_layout);
    }
}
