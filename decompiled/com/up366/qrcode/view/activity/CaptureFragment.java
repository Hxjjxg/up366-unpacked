package com.up366.qrcode.view.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CaptureFragment extends androidx.fragment.app.Fragment implements android.view.SurfaceHolder.Callback {
    private static final float BEEP_VOLUME = 0.1f;
    private static final long VIBRATE_DURATION = 200;
    private com.up366.qrcode.view.utils.CodeUtils.AnalyzeCallback analyzeCallback;
    com.up366.qrcode.view.activity.CaptureFragment.CameraInitCallBack callBack;
    private android.hardware.Camera camera;
    private java.lang.String characterSet;
    private java.util.Vector<com.google.zxing.BarcodeFormat> decodeFormats;
    private com.up366.qrcode.view.decoding.CaptureActivityHandler handler;
    private boolean hasSurface;
    private com.up366.qrcode.view.decoding.InactivityTimer inactivityTimer;
    private android.widget.TextView mFlashlight;
    private android.view.SurfaceView mSurfaceView;
    private com.up366.qrcode.view.view.ViewfinderView mViewfinderView;
    private android.media.MediaPlayer mediaPlayer;
    private boolean playBeep;
    private boolean vibrate;
    private android.os.Handler mHandler = new android.os.Handler() { // from class: com.up366.qrcode.view.activity.CaptureFragment.1
        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            com.up366.qrcode.view.activity.CaptureFragment captureFragment = com.up366.qrcode.view.activity.CaptureFragment.this;
            captureFragment.initCamera(captureFragment.mSurfaceView.getHolder());
        }
    };
    private final android.media.MediaPlayer.OnCompletionListener beepListener = new android.media.MediaPlayer.OnCompletionListener() { // from class: com.up366.qrcode.view.activity.CaptureFragment.2
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(android.media.MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    };

    interface CameraInitCallBack {
        void callBack(java.lang.Exception exc);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(android.view.SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.qrcode.view.camera.CameraManager.init(getActivity().getApplication());
        this.hasSurface = false;
        this.inactivityTimer = new com.up366.qrcode.view.decoding.InactivityTimer(getActivity());
    }

    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.qrcode.R.layout.capture_fragment, viewGroup, false);
        initView(viewInflate);
        return viewInflate;
    }

    private void initView(android.view.View view) {
        this.mFlashlight = (android.widget.TextView) view.findViewById(com.up366.qrcode.R.id.flashlight);
        this.mSurfaceView = (android.view.SurfaceView) view.findViewById(com.up366.qrcode.R.id.preview_view);
        this.mViewfinderView = (com.up366.qrcode.view.view.ViewfinderView) view.findViewById(com.up366.qrcode.R.id.viewfinder_view);
        this.mFlashlight.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.qrcode.view.activity.CaptureFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                this.f$0.m1387lambda$initView$0$comup366qrcodeviewactivityCaptureFragment(view2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initView$0$com-up366-qrcode-view-activity-CaptureFragment, reason: not valid java name */
    /* synthetic */ void m1387lambda$initView$0$comup366qrcodeviewactivityCaptureFragment(android.view.View view) {
        onFlashLight();
    }

    private void onFlashLight() {
        if (!getActivity().getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
            android.widget.Toast.makeText((android.content.Context) getActivity(), (java.lang.CharSequence) "闪光灯不可用", 1).show();
            return;
        }
        android.hardware.Camera camera = this.camera;
        if (camera == null) {
            android.widget.Toast.makeText((android.content.Context) getActivity(), (java.lang.CharSequence) "相机权限获取失败，请检查是否开启相机权限...", 0).show();
            return;
        }
        android.hardware.Camera.Parameters parameters = camera.getParameters();
        if ("torch".equals(parameters.getFlashMode())) {
            parameters.setFlashMode("off");
            this.mFlashlight.setText("轻触照亮");
            this.mFlashlight.setTextColor(-1);
            android.graphics.drawable.Drawable drawable = getResources().getDrawable(com.up366.qrcode.R.drawable.flashlight_switch);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.mFlashlight.setCompoundDrawables(null, drawable, null, null);
        } else {
            parameters.setFlashMode("torch");
            this.mFlashlight.setTextColor(-16745729);
            this.mFlashlight.setText("轻触关闭");
            android.graphics.drawable.Drawable drawable2 = getResources().getDrawable(com.up366.qrcode.R.drawable.flashlight_switch_on);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            this.mFlashlight.setCompoundDrawables(null, drawable2, null, null);
        }
        try {
            this.camera.setParameters(parameters);
        } catch (java.lang.Exception e) {
            android.util.Log.e("CaptureFragment", "setParameters error " + e.getMessage());
        }
    }

    public void onResume() {
        super.onResume();
        if (this.hasSurface) {
            this.mHandler.sendEmptyMessage(-1);
        } else {
            this.mSurfaceView.getHolder().addCallback(this);
            this.mSurfaceView.getHolder().setType(3);
        }
        this.decodeFormats = null;
        this.characterSet = null;
        this.playBeep = true;
        if (((android.media.AudioManager) getActivity().getSystemService(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_AUDIO)).getRingerMode() != 2) {
            this.playBeep = false;
        }
        initBeepSound();
        this.vibrate = true;
    }

    public void onPause() {
        super.onPause();
        com.up366.qrcode.view.decoding.CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            captureActivityHandler.quitSynchronously();
            this.handler = null;
        }
        com.up366.qrcode.view.camera.CameraManager.get().closeDriver();
    }

    public void onDestroy() {
        super.onDestroy();
        this.inactivityTimer.shutdown();
    }

    public void handleDecode(com.google.zxing.Result result, android.graphics.Bitmap bitmap) {
        this.inactivityTimer.onActivity();
        playBeepSoundAndVibrate();
        if (result == null || android.text.TextUtils.isEmpty(result.getText())) {
            com.up366.qrcode.view.utils.CodeUtils.AnalyzeCallback analyzeCallback = this.analyzeCallback;
            if (analyzeCallback != null) {
                analyzeCallback.onAnalyzeFailed();
                return;
            }
            return;
        }
        com.up366.qrcode.view.utils.CodeUtils.AnalyzeCallback analyzeCallback2 = this.analyzeCallback;
        if (analyzeCallback2 != null) {
            analyzeCallback2.onAnalyzeSuccess(bitmap, result.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCamera(android.view.SurfaceHolder surfaceHolder) {
        try {
            com.up366.qrcode.view.camera.CameraManager.get().openDriver(surfaceHolder);
            this.camera = com.up366.qrcode.view.camera.CameraManager.get().getCamera();
            com.up366.qrcode.view.activity.CaptureFragment.CameraInitCallBack cameraInitCallBack = this.callBack;
            if (cameraInitCallBack != null) {
                cameraInitCallBack.callBack(null);
            }
            if (this.handler == null) {
                this.handler = new com.up366.qrcode.view.decoding.CaptureActivityHandler(this, this.decodeFormats, this.characterSet, this.mViewfinderView);
            }
        } catch (java.lang.Exception e) {
            com.up366.qrcode.view.activity.CaptureFragment.CameraInitCallBack cameraInitCallBack2 = this.callBack;
            if (cameraInitCallBack2 != null) {
                cameraInitCallBack2.callBack(e);
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(android.view.SurfaceHolder surfaceHolder) {
        if (this.hasSurface) {
            return;
        }
        this.hasSurface = true;
        this.mHandler.sendEmptyMessage(-1);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(android.view.SurfaceHolder surfaceHolder) {
        this.hasSurface = false;
        if (this.camera == null || !com.up366.qrcode.view.camera.CameraManager.get().isPreviewing()) {
            return;
        }
        surfaceHolder.removeCallback(this);
        if (!com.up366.qrcode.view.camera.CameraManager.get().isUseOneShotPreviewCallback()) {
            this.camera.setPreviewCallback(null);
        }
        this.camera.stopPreview();
        com.up366.qrcode.view.camera.CameraManager.get().getPreviewCallback().setHandler(null, 0);
        com.up366.qrcode.view.camera.CameraManager.get().getAutoFocusCallback().setHandler(null, 0);
        com.up366.qrcode.view.camera.CameraManager.get().setPreviewing(false);
    }

    public android.os.Handler getHandler() {
        return this.handler;
    }

    public void drawViewfinder() {
        this.mViewfinderView.drawViewfinder();
    }

    private void initBeepSound() {
        if (this.playBeep && this.mediaPlayer == null) {
            getActivity().setVolumeControlStream(3);
            android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.mediaPlayer.setOnCompletionListener(this.beepListener);
            android.content.res.AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = getResources().openRawResourceFd(com.up366.qrcode.R.raw.beep);
            try {
                this.mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                assetFileDescriptorOpenRawResourceFd.close();
                this.mediaPlayer.setVolume(BEEP_VOLUME, BEEP_VOLUME);
                this.mediaPlayer.prepare();
            } catch (java.io.IOException unused) {
                this.mediaPlayer = null;
            }
        }
    }

    private void playBeepSoundAndVibrate() {
        android.media.MediaPlayer mediaPlayer;
        if (this.playBeep && (mediaPlayer = this.mediaPlayer) != null) {
            mediaPlayer.start();
        }
        if (this.vibrate) {
            androidx.fragment.app.FragmentActivity activity = getActivity();
            getActivity();
            ((android.os.Vibrator) activity.getSystemService("vibrator")).vibrate(200L);
        }
    }

    public com.up366.qrcode.view.utils.CodeUtils.AnalyzeCallback getAnalyzeCallback() {
        return this.analyzeCallback;
    }

    public void setAnalyzeCallback(com.up366.qrcode.view.utils.CodeUtils.AnalyzeCallback analyzeCallback) {
        this.analyzeCallback = analyzeCallback;
    }

    public void setCameraInitCallBack(com.up366.qrcode.view.activity.CaptureFragment.CameraInitCallBack cameraInitCallBack) {
        this.callBack = cameraInitCallBack;
    }
}
