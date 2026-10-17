package com.up366.multimediav2.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class ActivityAnswerSmartCameraBinding extends androidx.databinding.ViewDataBinding {
    public final com.up366.smart.paper.view.GraphicOverlay borderView;
    public final android.widget.ImageButton btBack;
    public final android.widget.ImageButton btHelp;
    public final android.widget.ImageButton btLightStatus;
    public final androidx.constraintlayout.widget.ConstraintLayout clRoot;
    public final androidx.constraintlayout.widget.ConstraintLayout clSmartCameraBottom;
    public final androidx.constraintlayout.widget.ConstraintLayout clSmartCameraTitle;
    public final android.widget.ImageButton ibHandTakePic;
    public final android.widget.ImageButton ibSelectPic;
    public final android.view.View line;
    public final androidx.camera.view.PreviewView previewView;
    public final com.up366.qmui.widget.roundwidget.QMUIRoundButton qrbAutoPicture;
    public final com.up366.qmui.widget.roundwidget.QMUIRoundButton qrbHandPicture;
    public final android.widget.TextView tvAnalyzeResult;
    public final android.widget.TextView tvChangeManualToast;
    public final android.widget.TextView tvLightToast;
    public final android.widget.TextView tvMovePageOrPhone;

    protected ActivityAnswerSmartCameraBinding(java.lang.Object obj, android.view.View view, int i, com.up366.smart.paper.view.GraphicOverlay graphicOverlay, android.widget.ImageButton imageButton, android.widget.ImageButton imageButton2, android.widget.ImageButton imageButton3, androidx.constraintlayout.widget.ConstraintLayout constraintLayout, androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, androidx.constraintlayout.widget.ConstraintLayout constraintLayout3, android.widget.ImageButton imageButton4, android.widget.ImageButton imageButton5, android.view.View view2, androidx.camera.view.PreviewView previewView, com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton, com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton2, android.widget.TextView textView, android.widget.TextView textView2, android.widget.TextView textView3, android.widget.TextView textView4) {
        super(obj, view, i);
        this.borderView = graphicOverlay;
        this.btBack = imageButton;
        this.btHelp = imageButton2;
        this.btLightStatus = imageButton3;
        this.clRoot = constraintLayout;
        this.clSmartCameraBottom = constraintLayout2;
        this.clSmartCameraTitle = constraintLayout3;
        this.ibHandTakePic = imageButton4;
        this.ibSelectPic = imageButton5;
        this.line = view2;
        this.previewView = previewView;
        this.qrbAutoPicture = qMUIRoundButton;
        this.qrbHandPicture = qMUIRoundButton2;
        this.tvAnalyzeResult = textView;
        this.tvChangeManualToast = textView2;
        this.tvLightToast = textView3;
        this.tvMovePageOrPhone = textView4;
    }

    public static com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z, java.lang.Object obj) {
        return (com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.multimediav2.R.layout.activity_answer_smart_camera, viewGroup, z, obj);
    }

    public static com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding inflate(android.view.LayoutInflater layoutInflater, java.lang.Object obj) {
        return (com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding) androidx.databinding.ViewDataBinding.inflateInternal(layoutInflater, com.up366.multimediav2.R.layout.activity_answer_smart_camera, (android.view.ViewGroup) null, false, obj);
    }

    public static com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding bind(android.view.View view) {
        return bind(view, androidx.databinding.DataBindingUtil.getDefaultComponent());
    }

    @java.lang.Deprecated
    public static com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding bind(android.view.View view, java.lang.Object obj) {
        return (com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBinding) bind(obj, view, com.up366.multimediav2.R.layout.activity_answer_smart_camera);
    }
}
