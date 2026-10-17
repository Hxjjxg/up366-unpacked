package com.up366.multimediav2.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CameraActivity extends androidx.appcompat.app.AppCompatActivity {
    public static final java.lang.String INTENT_ALBUM_MAX_SIZE = "max_size";
    public static final java.lang.String INTENT_FUNCTION = "function_name";
    public static final java.lang.String INTENT_IMAGE_SAVE_PATH_AND_NAME = "SAVE_PATH";
    public static final java.lang.String INTENT_KEY_FROM_SMART = "from_smart";
    public static final int REQUEST_CODE_GOTO_SMART_CAMERA = 101;
    public static final int REQULT_CODE_TO_ALBUM = 100;
    private com.up366.multimediav2.fragment.CameraFragment cameraFragment;
    private boolean fromSmart = false;
    private java.lang.String funName;
    private java.lang.String imageSavePathAndName;

    public static void startCameraActivityForResult(android.app.Activity activity, int i, java.lang.String str, boolean z, java.lang.String str2) {
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.multimediav2.activity.CameraActivity.class);
        intent.putExtra("SAVE_PATH", str);
        intent.putExtra("from_smart", z);
        intent.putExtra(INTENT_FUNCTION, str2);
        activity.startActivityForResult(intent, i);
    }

    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        setContentView(com.up366.multimediav2.R.layout.activity_camera);
        initIntentData();
        showCameraFragment();
    }

    private void initIntentData() {
        this.imageSavePathAndName = getIntent().getStringExtra("SAVE_PATH");
        this.fromSmart = getIntent().getBooleanExtra("from_smart", false);
        this.funName = getIntent().getStringExtra(INTENT_FUNCTION);
        this.cameraFragment = com.up366.multimediav2.fragment.CameraFragment.getInstance(this.imageSavePathAndName, this.fromSmart);
    }

    private void showCameraFragment() {
        getSupportFragmentManager().beginTransaction().replace(com.up366.multimediav2.R.id.fl_demo_content, this.cameraFragment).commit();
    }

    public java.lang.String getFunName() {
        return this.funName;
    }
}
