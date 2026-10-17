package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class TaskItemLayoutV2Binding extends androidx.databinding.ViewDataBinding {
    public final android.widget.TextView answerReview;
    public final android.widget.LinearLayout bottomBtnLayout;
    public final android.widget.LinearLayout clTaskNameScore;
    public final android.widget.LinearLayout classLayout;
    public final android.widget.TextView downloadPaper;
    public final android.widget.TextView endTime;
    public final android.widget.ImageView lock;
    public final android.widget.TextView newSubmit;
    public final android.widget.TextView onlineAnswer;
    public final android.widget.TextView retryTakePhotoBtn;
    public final android.widget.ImageView returnErrorTip;
    public final android.widget.TextView takePhotoBtn;
    public final com.up366.mobile.common.views.RoundBorderTextView taskJiJiangJieZhi;
    public final android.widget.TextView taskName;
    public final android.widget.TextView taskReport;
    public final android.widget.TextView taskScore;
    public final com.up366.mobile.common.views.RoundBorderTextView taskTopRightMokao;
    public final com.up366.mobile.common.views.RoundBorderTextView taskTopRightShangchuanshibai;
    public final com.up366.mobile.common.views.RoundBorderTextView taskTopRightWeikaishi;
    public final com.up366.mobile.common.views.RoundBorderTextView taskTopRightWeizuoda;
    public final android.widget.ImageView timeTip;
    public final android.widget.LinearLayout topLayout;
    public final android.widget.TextView tvHomeworkClassName;
    public final android.widget.TextView tvUseTime;

    protected TaskItemLayoutV2Binding(java.lang.Object obj, android.view.View view, int i, android.widget.TextView textView, android.widget.LinearLayout linearLayout, android.widget.LinearLayout linearLayout2, android.widget.LinearLayout linearLayout3, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.ImageView imageView, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.TextView textView6, android.widget.ImageView imageView2, android.widget.TextView textView7, com.up366.mobile.common.views.RoundBorderTextView roundBorderTextView, android.widget.TextView textView8, android.widget.TextView textView9, android.widget.TextView textView10, com.up366.mobile.common.views.RoundBorderTextView roundBorderTextView2, com.up366.mobile.common.views.RoundBorderTextView roundBorderTextView3, com.up366.mobile.common.views.RoundBorderTextView roundBorderTextView4, com.up366.mobile.common.views.RoundBorderTextView roundBorderTextView5, android.widget.ImageView imageView3, android.widget.LinearLayout linearLayout4, android.widget.TextView textView11, android.widget.TextView textView12) {
        super(obj, view, i);
        this.answerReview = textView;
        this.bottomBtnLayout = linearLayout;
        this.clTaskNameScore = linearLayout2;
        this.classLayout = linearLayout3;
        this.downloadPaper = textView2;
        this.endTime = textView3;
        this.lock = imageView;
        this.newSubmit = textView4;
        this.onlineAnswer = textView5;
        this.retryTakePhotoBtn = textView6;
        this.returnErrorTip = imageView2;
        this.takePhotoBtn = textView7;
        this.taskJiJiangJieZhi = roundBorderTextView;
        this.taskName = textView8;
        this.taskReport = textView9;
        this.taskScore = textView10;
        this.taskTopRightMokao = roundBorderTextView2;
        this.taskTopRightShangchuanshibai = roundBorderTextView3;
        this.taskTopRightWeikaishi = roundBorderTextView4;
        this.taskTopRightWeizuoda = roundBorderTextView5;
        this.timeTip = imageView3;
        this.topLayout = linearLayout4;
        this.tvHomeworkClassName = textView11;
        this.tvUseTime = textView12;
    }

    public static com.up366.mobile.databinding.TaskItemLayoutV2Binding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TaskItemLayoutV2Binding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TaskItemLayoutV2Binding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.task_item_layout_v2, viewGroup, z, obj);
    }

    public static com.up366.mobile.databinding.TaskItemLayoutV2Binding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TaskItemLayoutV2Binding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TaskItemLayoutV2Binding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.mobile.R.layout.task_item_layout_v2, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.mobile.databinding.TaskItemLayoutV2Binding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.mobile.databinding.TaskItemLayoutV2Binding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.mobile.databinding.TaskItemLayoutV2Binding) bind(obj, view, com.up366.mobile.R.layout.task_item_layout_v2);
    }
}
