package com.up366.multimediav2.fragment;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CameraFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener, com.up366.multimediav2.camera.Camera2Manager.Callback, android.hardware.SensorEventListener {
    private static final int CAMERA_PERMISSION_CODE = 1;
    public static final java.lang.String IMAGE_SAVE_PATH_AND_NAME = "SAVE_PATH";
    public static final java.lang.String INTENT_KEY_FROM_SMART = "from_smart";
    private static final float LIGHT_WEAK_DIVIDE = 40.0f;
    private android.app.Activity activity;
    private android.widget.ImageButton btBack;
    private android.widget.TextView btHelp;
    private android.widget.ImageButton btLight;
    private android.widget.ImageButton btSelect;
    private android.widget.ImageButton btTakePicture;
    private com.up366.multimediav2.camera.Camera2Manager camera2Manager;
    private android.widget.ImageButton ibtSmartCamera;
    private android.widget.TextView tvLightToast;
    private android.animation.ObjectAnimator lightAnimator = null;
    private boolean lightStatus = false;
    private java.lang.String imageSavePathAndName = null;
    private boolean firstShowLightToast = true;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {
    }

    @Override // com.up366.multimediav2.camera.Camera2Manager.Callback
    public void onError(java.lang.Exception exc) {
    }

    public static com.up366.multimediav2.fragment.CameraFragment getInstance(java.lang.String str, boolean z) {
        com.up366.multimediav2.fragment.CameraFragment cameraFragment = new com.up366.multimediav2.fragment.CameraFragment();
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("SAVE_PATH", str);
        bundle.putBoolean("from_smart", z);
        cameraFragment.setArguments(bundle);
        return cameraFragment;
    }

    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.multimediav2.R.layout.fragment_camera, viewGroup, false);
        this.activity = getActivity();
        com.up366.multimediav2.camera.Camera2Manager camera2Manager = new com.up366.multimediav2.camera.Camera2Manager(this.activity, (com.up366.multimediav2.views.CameraTextureView) viewInflate.findViewById(com.up366.multimediav2.R.id.ctv_camera_preview));
        this.camera2Manager = camera2Manager;
        camera2Manager.setCallback(this);
        initView(viewInflate);
        initData();
        this.camera2Manager.start();
        return viewInflate;
    }

    private void initData() {
        android.os.Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.imageSavePathAndName = arguments.getString("SAVE_PATH");
        if (!arguments.getBoolean("from_smart")) {
            this.ibtSmartCamera.setVisibility(8);
        }
        android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(this.btLight, com.up366.qmui.skin.QMUISkinValueBuilder.ALPHA, 1.0f, 0.0f);
        this.lightAnimator = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(400L);
        this.lightAnimator.setInterpolator(new android.view.animation.AccelerateInterpolator());
        this.lightAnimator.setRepeatCount(-1);
        this.lightAnimator.setRepeatMode(2);
        this.lightAnimator.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.up366.multimediav2.fragment.CameraFragment.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                super.onAnimationEnd(animator);
                com.up366.multimediav2.fragment.CameraFragment.this.btLight.animate().alpha(1.0f).setDuration(50L).start();
            }
        });
    }

    private void initView(android.view.View view) {
        this.tvLightToast = (android.widget.TextView) view.findViewById(com.up366.multimediav2.R.id.tv_light_toast);
        android.widget.ImageButton imageButton = (android.widget.ImageButton) view.findViewById(com.up366.multimediav2.R.id.bt_light_status);
        this.btLight = imageButton;
        imageButton.setOnClickListener(this);
        android.widget.TextView textView = (android.widget.TextView) view.findViewById(com.up366.multimediav2.R.id.bt_help);
        this.btHelp = textView;
        textView.setOnClickListener(this);
        android.widget.ImageButton imageButton2 = (android.widget.ImageButton) view.findViewById(com.up366.multimediav2.R.id.bt_select_picture);
        this.btSelect = imageButton2;
        imageButton2.setOnClickListener(this);
        android.widget.ImageButton imageButton3 = (android.widget.ImageButton) view.findViewById(com.up366.multimediav2.R.id.bt_back);
        this.btBack = imageButton3;
        imageButton3.setOnClickListener(this);
        android.widget.ImageButton imageButton4 = (android.widget.ImageButton) view.findViewById(com.up366.multimediav2.R.id.bt_take_picture);
        this.btTakePicture = imageButton4;
        imageButton4.setOnClickListener(this);
        android.widget.ImageButton imageButton5 = (android.widget.ImageButton) view.findViewById(com.up366.multimediav2.R.id.bt_change_automatic);
        this.ibtSmartCamera = imageButton5;
        imageButton5.setOnClickListener(this);
    }

    public void onResume() {
        super.onResume();
        if (com.up366.multimediav2.sensor.LightSensorHelper.supportLightSensor(getActivity())) {
            com.up366.multimediav2.sensor.LightSensorHelper.registerListener(getActivity(), this);
        }
    }

    public void onPause() {
        super.onPause();
        com.up366.multimediav2.sensor.LightSensorHelper.unRegisterSensor(getActivity(), this);
        this.camera2Manager.stop();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (id == com.up366.multimediav2.R.id.bt_light_status) {
            openLight();
            return;
        }
        if (id == com.up366.multimediav2.R.id.bt_help) {
            return;
        }
        if (id == com.up366.multimediav2.R.id.bt_change_automatic) {
            finishGotoSmartCamera();
            return;
        }
        if (id == com.up366.multimediav2.R.id.bt_select_picture) {
            finishGotoAlbumActivity();
        } else if (id == com.up366.multimediav2.R.id.bt_back) {
            finishByNoHandle();
        } else if (id == com.up366.multimediav2.R.id.bt_take_picture) {
            this.camera2Manager.obtainPicture(this.lightStatus);
        }
    }

    private void openLight() {
        if (this.lightAnimator.isStarted()) {
            this.lightAnimator.cancel();
        }
        if (this.tvLightToast.getVisibility() == 0) {
            this.tvLightToast.setVisibility(8);
        }
        this.btLight.animate().alpha(1.0f).setDuration(50L).start();
        boolean z = !this.lightStatus;
        this.lightStatus = z;
        this.btLight.setSelected(z);
        this.camera2Manager.openLight(this.lightStatus);
    }

    private void finishByTakePictureSuccess(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.multimediav2.fragment.CameraFragment$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.m1354xfa2917d2(str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$finishByTakePictureSuccess$0$com-up366-multimediav2-fragment-CameraFragment, reason: not valid java name */
    /* synthetic */ void m1354xfa2917d2(java.lang.String str) throws java.lang.Exception {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("SAVE_PATH", str);
        this.activity.setResult(-1, intent);
        this.activity.finish();
    }

    private void finishByNoHandle() {
        this.activity.setResult(0);
        this.activity.finish();
    }

    private void finishGotoAlbumActivity() {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("max_size", 1);
        intent.putExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_VIEW_ID, 123);
        this.activity.setResult(100, intent);
        this.activity.finish();
    }

    private void finishGotoSmartCamera() {
        this.activity.setResult(101);
        this.activity.finish();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 5) {
            return;
        }
        if (sensorEvent.values[0] < LIGHT_WEAK_DIVIDE) {
            if (this.lightStatus) {
                return;
            }
            if (this.firstShowLightToast) {
                this.tvLightToast.setVisibility(0);
                this.firstShowLightToast = false;
            }
            if (this.lightAnimator.isStarted()) {
                return;
            }
            this.btLight.setSelected(true);
            this.lightAnimator.start();
            return;
        }
        if (this.lightAnimator.isStarted()) {
            this.lightAnimator.cancel();
        }
        if (this.tvLightToast.getVisibility() == 0) {
            this.tvLightToast.setVisibility(8);
            this.firstShowLightToast = false;
        }
        if (this.lightStatus) {
            return;
        }
        this.btLight.setSelected(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.String] */
    @Override // com.up366.multimediav2.camera.Camera2Manager.Callback
    public void obtainImage(android.media.Image image) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.io.File file = new java.io.File(this.imageSavePathAndName);
        if (file.exists()) {
            file.delete();
        }
        java.nio.ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new java.io.FileOutputStream(file);
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            } catch (java.io.IOException e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(bArr);
            image.close();
            fileOutputStream.close();
        } catch (java.io.IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            image.close();
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            image = this.imageSavePathAndName;
            finishByTakePictureSuccess(image);
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            image.close();
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (java.io.IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        image = this.imageSavePathAndName;
        finishByTakePictureSuccess(image);
    }
}
