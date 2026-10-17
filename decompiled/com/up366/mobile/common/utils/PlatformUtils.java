package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PlatformUtils {
    public static final java.lang.String CLOSE_PAD_MODEL = "STUDENT-ANDROID-CLOSE-PAD";
    public static final java.lang.String CUSTOM_CLOSE_PAD_MODEL = "STUDENT-ANDROID-CUSTOM-CLOSE-PAD";
    private static final java.lang.String HOST_DEMO = "up366demo.cn";
    private static final java.lang.String HOST_GRAY = "up366gray.cn";
    private static final java.lang.String HOST_PRODUCT = "up366.cn";
    private static final java.lang.String HOST_TEST = "up366test.cn";
    private static final java.lang.String HOST_UAT = "up366.com.cn";
    private static final java.lang.String KEY_TARGET_URL = "key_switch_target_url";
    private static java.lang.String cpuABI;
    public static boolean isTest;

    public static boolean isClosePad() {
        return false;
    }

    public static boolean isCustomClosePad() {
        return false;
    }

    public static java.lang.String getAppType() {
        if (isClosePad()) {
            return "student-close-pad";
        }
        return "student-android";
    }

    public static boolean isHorizontalWideScreen(android.app.Activity activity) {
        return ((activity instanceof com.up366.mobile.book.StudyActivity) || (activity instanceof com.up366.mobile.main.AppResourceUpdateActivity)) && activity.getRequestedOrientation() == 1;
    }

    public static void suitableForHorizontalWideScreenDialog(android.app.Activity activity, android.app.Dialog dialog) {
        if (isHorizontalWideScreen(activity)) {
            android.view.Window window = activity.getWindow();
            android.view.Window window2 = dialog.getWindow();
            if (window == null || window2 == null) {
                return;
            }
            android.view.View decorView = window.getDecorView();
            android.view.View decorView2 = window2.getDecorView();
            decorView2.setBackgroundColor(6710886);
            decorView2.setPadding(decorView.getPaddingLeft(), 0, decorView.getPaddingRight(), 0);
        }
    }

    public static void suitableForHorizontalWideScreen(final android.app.Activity activity) {
        if (isHorizontalWideScreen(activity)) {
            android.util.DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
            final float f = displayMetrics.widthPixels;
            final float f2 = displayMetrics.heightPixels;
            com.up366.common.log.Logger.info("TAG - CloseUtils - suitableForHorizontalWideScreen - width:" + f + "height:" + f2);
            if (f / f2 > 1.0f) {
                com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.PlatformUtils$$ExternalSyntheticLambda1
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        com.up366.mobile.common.utils.PlatformUtils.lambda$suitableForHorizontalWideScreen$0(activity, f, f2);
                    }
                });
                return;
            }
            android.view.View decorView = activity.getWindow().getDecorView();
            if (decorView.getPaddingLeft() != 0) {
                decorView.setPadding(0, decorView.getPaddingTop(), 0, decorView.getPaddingBottom());
            }
        }
    }

    static /* synthetic */ void lambda$suitableForHorizontalWideScreen$0(android.app.Activity activity, float f, float f2) throws java.lang.Exception {
        android.graphics.Rect rect = new android.graphics.Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        com.up366.common.log.Logger.info("SplitScreenDetector - App: " + rect.width() + "x" + rect.height() + ", Real: " + f + "x" + f2);
        if (r1 * r0 < ((double) (f2 * f)) * 0.7d) {
            return;
        }
        int i = (int) (f / 3.0f);
        android.view.View decorView = activity.getWindow().getDecorView();
        decorView.setPadding(i, decorView.getPaddingTop(), i, decorView.getPaddingBottom());
        decorView.setBackgroundColor(-10066330);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) decorView;
        if (viewGroup.getChildCount() > 0) {
            viewGroup.getChildAt(0).setBackgroundColor(-1);
        }
    }

    public static void updateSuitableForHorizontalWideScreen(android.app.Activity activity) {
        if (!isHorizontalWideScreen(activity)) {
            android.view.View decorView = activity.getWindow().getDecorView();
            if (decorView.getPaddingLeft() != 0) {
                decorView.setPadding(0, decorView.getPaddingTop(), 0, decorView.getPaddingBottom());
                return;
            }
            return;
        }
        suitableForHorizontalWideScreen(activity);
    }

    public static boolean isPadOkay() {
        return android.os.Build.BRAND.toLowerCase().contains("alps") && com.up366.qmui.util.QMUIDeviceHelper.isTablet(com.up366.common.global.GB.get().getApplicationContext());
    }

    public static boolean isQQClientAvailable() {
        android.content.pm.PackageManager packageManager = com.up366.common.global.GB.get().getApplicationContext().getPackageManager();
        if (android.os.Build.VERSION.SDK_INT < 30) {
            return checkByPackageInfo(packageManager) || checkByLaunchIntent(packageManager) || checkByUrlScheme(packageManager);
        }
        if (checkByLaunchIntent(packageManager) || checkByUrlScheme(packageManager)) {
            return true;
        }
        return checkByPackageInfo(packageManager);
    }

    private static boolean checkByPackageInfo(android.content.pm.PackageManager packageManager) {
        try {
            packageManager.getPackageInfo("com.tencent.mobileqq", 1);
            com.up366.common.log.Logger.info("QQ detected by package info");
            return true;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return false;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("checkByPackageInfo error: " + e.getMessage());
            return false;
        }
    }

    private static boolean checkByLaunchIntent(android.content.pm.PackageManager packageManager) {
        try {
            android.content.Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage("com.tencent.mobileqq");
            if (launchIntentForPackage == null || launchIntentForPackage.resolveActivity(packageManager) == null) {
                return false;
            }
            com.up366.common.log.Logger.info("QQ detected by launch intent");
            return true;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("checkByLaunchIntent error: " + e.getMessage());
            return false;
        }
    }

    private static boolean checkByUrlScheme(android.content.pm.PackageManager packageManager) {
        java.lang.String[] strArr;
        int i;
        try {
            strArr = new java.lang.String[]{"mqq://", "mqqapi://", "mqqwpa://"};
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("checkByUrlScheme error: " + e.getMessage());
        }
        for (i = 0; i < 3; i++) {
            java.lang.String str = strArr[i];
            java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str)), 65536);
            if (listQueryIntentActivities != null && !listQueryIntentActivities.isEmpty()) {
                for (android.content.pm.ResolveInfo resolveInfo : listQueryIntentActivities) {
                    if (resolveInfo.activityInfo != null && "com.tencent.mobileqq".equals(resolveInfo.activityInfo.packageName)) {
                        com.up366.common.log.Logger.info("QQ detected by URL scheme: " + str);
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public static java.lang.String getCPUABI() {
        java.io.BufferedReader bufferedReader;
        if (cpuABI == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("abi:");
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream()));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                sb.append(e.getMessage());
            }
            try {
                sb.append(bufferedReader.readLine());
                bufferedReader.close();
                sb.append(" abilist:");
                try {
                    bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop ro.product.cpu.abilist").getInputStream()));
                    try {
                        sb.append(bufferedReader.readLine());
                        bufferedReader.close();
                    } finally {
                    }
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                    sb.append(e2.getMessage());
                }
                cpuABI = sb.toString();
            } finally {
            }
        }
        return cpuABI;
    }

    public static java.lang.String getTargetHostInner() {
        return HOST_PRODUCT;
    }

    public static java.lang.String getTargetHost() {
        java.lang.String targetHostInner = getTargetHostInner();
        return android.text.TextUtils.equals(HOST_GRAY, targetHostInner) ? HOST_PRODUCT : targetHostInner;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getTargetName() {
        /*
            java.lang.String r0 = getTargetHostInner()
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -1819794658: goto L3b;
                case -1284762386: goto L30;
                case -548733026: goto L25;
                case -121843615: goto L1a;
                case 772114063: goto Lf;
                default: goto Le;
            }
        Le:
            goto L46
        Lf:
            java.lang.String r1 = "up366test.cn"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L46
            r0 = 0
            goto L47
        L1a:
            java.lang.String r1 = "up366.cn"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L46
            r0 = 4
            goto L47
        L25:
            java.lang.String r1 = "up366demo.cn"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L46
            r0 = r4
            goto L47
        L30:
            java.lang.String r1 = "up366.com.cn"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L46
            r0 = r2
            goto L47
        L3b:
            java.lang.String r1 = "up366gray.cn"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L46
            r0 = r3
            goto L47
        L46:
            r0 = -1
        L47:
            if (r0 == 0) goto L5b
            if (r0 == r4) goto L58
            if (r0 == r3) goto L55
            if (r0 == r2) goto L52
            java.lang.String r0 = ""
            goto L5d
        L52:
            java.lang.String r0 = " UAT"
            goto L5d
        L55:
            java.lang.String r0 = " GRAY"
            goto L5d
        L58:
            java.lang.String r0 = " DEMO"
            goto L5d
        L5b:
            java.lang.String r0 = " TEST"
        L5d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.utils.PlatformUtils.getTargetName():java.lang.String");
    }

    public static boolean isGray() {
        return android.text.TextUtils.equals(HOST_GRAY, getTargetHostInner());
    }

    public static boolean isDemo() {
        java.lang.String targetHostInner = getTargetHostInner();
        return android.text.TextUtils.equals(HOST_DEMO, targetHostInner) || android.text.TextUtils.equals(HOST_TEST, targetHostInner) || android.text.TextUtils.equals(HOST_UAT, targetHostInner);
    }

    public static void switchTargetHost(final android.app.Activity activity, final java.lang.Runnable runnable) {
        final java.lang.String[] strArr = {HOST_TEST, HOST_DEMO, HOST_PRODUCT, HOST_GRAY, HOST_UAT};
        new androidx.appcompat.app.AlertDialog.Builder(activity).setTitle("切换运行环境").setItems(strArr, new android.content.DialogInterface.OnClickListener() { // from class: com.up366.mobile.common.utils.PlatformUtils$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(android.content.DialogInterface dialogInterface, int i) {
                com.up366.mobile.common.utils.PlatformUtils.lambda$switchTargetHost$2(strArr, runnable, activity, dialogInterface, i);
            }
        }).show();
    }

    static /* synthetic */ void lambda$switchTargetHost$2(java.lang.String[] strArr, java.lang.Runnable runnable, final android.app.Activity activity, android.content.DialogInterface dialogInterface, int i) {
        com.up366.mobile.common.utils.PreferenceUtils.putString(KEY_TARGET_URL, strArr[i]);
        runnable.run();
        com.up366.common.task.TaskUtils.postMainTaskDelay(800L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.PlatformUtils$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.book.helper.OpenHelper.reboot(activity);
            }
        });
    }
}
