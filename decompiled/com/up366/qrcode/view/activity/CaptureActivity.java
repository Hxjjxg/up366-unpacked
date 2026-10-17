package com.up366.qrcode.view.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CaptureActivity extends androidx.appcompat.app.AppCompatActivity {
    public static final int REQUEST_IMAGE = 112;
    com.up366.qrcode.view.activity.CaptureFragment.CameraInitCallBack cameraInitCallBack = new com.up366.qrcode.view.activity.CaptureFragment.CameraInitCallBack() { // from class: com.up366.qrcode.view.activity.CaptureActivity.1
        @Override // com.up366.qrcode.view.activity.CaptureFragment.CameraInitCallBack
        public void callBack(java.lang.Exception exc) {
            if (exc != null) {
                android.widget.Toast.makeText((android.content.Context) com.up366.qrcode.view.activity.CaptureActivity.this, (java.lang.CharSequence) "获取相机权限失败，该功能暂无法使用", 0).show();
                com.up366.qrcode.view.activity.CaptureActivity.this.finish();
            }
        }
    };
    com.up366.qrcode.view.utils.CodeUtils.AnalyzeCallback analyzeCallback = new com.up366.qrcode.view.utils.CodeUtils.AnalyzeCallback() { // from class: com.up366.qrcode.view.activity.CaptureActivity.2
        @Override // com.up366.qrcode.view.utils.CodeUtils.AnalyzeCallback
        public void onAnalyzeSuccess(android.graphics.Bitmap bitmap, java.lang.String str) {
            com.up366.qrcode.view.activity.CaptureActivity.this.onResult(true, str);
        }

        @Override // com.up366.qrcode.view.utils.CodeUtils.AnalyzeCallback
        public void onAnalyzeFailed() {
            com.up366.qrcode.view.activity.CaptureActivity.this.onResult(false, "扫描失败");
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.qrcode.view.utils.ZXingLibrary.DisplayUtil.initDisplayOpinion(this);
        performTranslucent();
        setContentView(com.up366.qrcode.R.layout.capture_activity);
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        com.up366.qrcode.view.utils.QMUIStatusBarHelper.setStatusBarDarkMode(this);
        ((android.widget.FrameLayout.LayoutParams) findViewById(com.up366.qrcode.R.id.title_layout).getLayoutParams()).topMargin = com.up366.qrcode.view.utils.QMUIStatusBarHelper.getStatusbarHeight(this);
        com.up366.qrcode.view.activity.CaptureFragment captureFragment = new com.up366.qrcode.view.activity.CaptureFragment();
        getSupportFragmentManager().beginTransaction().replace(com.up366.qrcode.R.id.fl_zxing_container, captureFragment).commit();
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.up366.qrcode.R.id.title_bar_back);
        android.view.View viewFindViewById = findViewById(com.up366.qrcode.R.id.title_bar_album);
        viewFindViewById.setVisibility(8);
        imageView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.qrcode.view.activity.CaptureActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1385lambda$initView$0$comup366qrcodeviewactivityCaptureActivity(view);
            }
        });
        viewFindViewById.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.qrcode.view.activity.CaptureActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1386lambda$initView$1$comup366qrcodeviewactivityCaptureActivity(view);
            }
        });
        captureFragment.setAnalyzeCallback(this.analyzeCallback);
        captureFragment.setCameraInitCallBack(this.cameraInitCallBack);
    }

    /* JADX INFO: renamed from: lambda$initView$0$com-up366-qrcode-view-activity-CaptureActivity, reason: not valid java name */
    /* synthetic */ void m1385lambda$initView$0$comup366qrcodeviewactivityCaptureActivity(android.view.View view) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$initView$1$com-up366-qrcode-view-activity-CaptureActivity, reason: not valid java name */
    /* synthetic */ void m1386lambda$initView$1$comup366qrcodeviewactivityCaptureActivity(android.view.View view) {
        getPicFromAlbum();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getPicFromAlbum() {
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setType(gdut.bsx.share2.ShareContentType.IMAGE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 112);
        } else {
            android.widget.Toast.makeText((android.content.Context) this, (java.lang.CharSequence) "打开相册失败", 0).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void performTranslucent() {
        com.up366.qrcode.view.utils.QMUIStatusBarHelper.translucent((android.app.Activity) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent == null || i != 112) {
            return;
        }
        com.up366.qrcode.view.utils.CodeUtils.analyzeBitmap(com.up366.qrcode.view.utils.ImageUtil.getImageAbsolutePath(this, intent.getData()), new com.up366.qrcode.view.utils.CodeUtils.AnalyzeCallback() { // from class: com.up366.qrcode.view.activity.CaptureActivity.3
            @Override // com.up366.qrcode.view.utils.CodeUtils.AnalyzeCallback
            public void onAnalyzeSuccess(android.graphics.Bitmap bitmap, java.lang.String str) {
                com.up366.qrcode.view.activity.CaptureActivity.this.onResult(true, str);
            }

            @Override // com.up366.qrcode.view.utils.CodeUtils.AnalyzeCallback
            public void onAnalyzeFailed() {
                android.widget.Toast.makeText((android.content.Context) com.up366.qrcode.view.activity.CaptureActivity.this, (java.lang.CharSequence) "图片解析失败", 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResult(boolean z, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent();
        android.os.Bundle bundle = new android.os.Bundle();
        if (z) {
            bundle.putInt(com.up366.qrcode.view.utils.CodeUtils.RESULT_TYPE, 1);
        } else {
            bundle.putInt(com.up366.qrcode.view.utils.CodeUtils.RESULT_TYPE, 2);
        }
        bundle.putString(com.up366.qrcode.view.utils.CodeUtils.RESULT_STRING, str);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }
}
