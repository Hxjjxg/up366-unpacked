package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class QRScanHelper {
    public static final int FAILED = 1;
    private static final int REQUEST_QR_SCAN = 10024;
    public static final int SUCCESS = 0;
    private com.up366.mobile.common.helper.QRScanHelper.IScanResult callback;
    private final android.app.Activity context;
    private boolean jumpActivity = true;

    public interface IScanResult {
        void onResult(int i, java.lang.String str);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface ScanResult {
    }

    public QRScanHelper(android.app.Activity activity) {
        this.context = activity;
    }

    public void open(final com.up366.mobile.common.helper.QRScanHelper.IScanResult iScanResult) {
        com.up366.common.log.Logger.info("TAG - QRScanHelper - open - ");
        this.callback = iScanResult;
        android.app.Activity activity = this.context;
        com.up366.mobile.common.utils.PermissionUtils.checkPermission(activity, new java.lang.String[]{"相机权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, activity.getString(com.up366.mobile.R.string.permission_camera), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.helper.QRScanHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                this.f$0.lambda$open$0(iScanResult, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$open$0(com.up366.mobile.common.helper.QRScanHelper.IScanResult iScanResult, int i, java.lang.String str) {
        if (i == 0) {
            this.context.startActivityForResult(new android.content.Intent(this.context, (java.lang.Class<?>) com.up366.qrcode.view.activity.CaptureActivity.class), REQUEST_QR_SCAN);
        } else {
            iScanResult.onResult(1, "");
        }
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.up366.mobile.common.helper.QRScanHelper.IScanResult iScanResult;
        if (i == REQUEST_QR_SCAN && (iScanResult = this.callback) != null) {
            if (i2 == -1) {
                java.lang.String stringExtra = intent.getStringExtra(com.up366.qrcode.view.utils.CodeUtils.RESULT_STRING);
                com.up366.common.log.Logger.info("TAG - QRScanHelper - onActivityResult - resultString : " + stringExtra);
                if (new com.up366.mobile.common.compat.CopyUserAppDataCompat().handle(this.context, stringExtra) || new com.up366.mobile.common.compat.CopyAppDataToSdcardCompat().handle(this.context, stringExtra) || new com.up366.mobile.common.compat.CopySmartPaperToSdcardCompat().handle(this.context, stringExtra) || new com.up366.mobile.common.compat.UploadOralResultCompat().handle(this.context, stringExtra) || new com.up366.mobile.common.compat.ShareUserFileCompat().handle(this.context, stringExtra) || new com.up366.mobile.common.compat.OpenDebugLogCompat().handle(this.context, stringExtra)) {
                    return;
                }
                this.callback.onResult(0, stringExtra);
                if (this.jumpActivity) {
                    if (5 == com.up366.mobile.jump.JumpUtils.judgeUrlType(stringExtra)) {
                        com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity.openPage(this.context, com.up366.mobile.jump.JumpUtils.getCourseCodeFromUrl(stringExtra));
                        return;
                    } else {
                        com.up366.mobile.jump.JumpProxyActivity.skip(this.context, stringExtra);
                        return;
                    }
                }
                return;
            }
            iScanResult.onResult(1, "");
        }
    }

    public void setJumpActivity(boolean z) {
        this.jumpActivity = z;
    }
}
