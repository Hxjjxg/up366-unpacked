package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PermissionUtils {
    private static final java.lang.String BLUETOOTH_IGNORE = "hasBluetoothIgnore";
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 901;
    private static com.up366.common.callback.ICallbackCodeInfo callback;
    private static android.content.Context context;
    private static com.up366.mobile.common.dialog.AppDialog dialog;
    private static java.lang.String[] errorTips;
    private static java.lang.String funName;
    public static boolean onRequestPermissions;
    private static boolean onWaitSystemPermissionDialog;
    private static com.up366.mobile.common.dialog.PermissionDialog permissionDialog;
    private static java.lang.String[] permissions;
    private static final java.util.Queue<com.up366.mobile.common.utils.PermissionUtils.Holder> queue = new java.util.concurrent.ConcurrentLinkedQueue();

    public static void checkPermission(android.content.Context context2, java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String str, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        if (strArr.length != strArr2.length) {
            throw new java.lang.IllegalStateException("errorTips.length != permissions.length");
        }
        if (!(context2 instanceof com.up366.mobile.common.base.BaseActivity)) {
            throw new java.lang.IllegalStateException("context 需要继承 BaseActivity!");
        }
        queue.add(new com.up366.mobile.common.utils.PermissionUtils.Holder(context2, strArr, strArr2, str, iCallbackCodeInfo));
        checkPermissionImpl();
    }

    public static void resetRequestPermissionState() {
        onRequestPermissions = false;
        queue.clear();
    }

    private static void checkPermissionImpl() {
        com.up366.mobile.common.base.BaseActivity baseActivity;
        if (onRequestPermissions && ((baseActivity = (com.up366.mobile.common.base.BaseActivity) context) == null || !baseActivity.isFinishing())) {
            com.up366.common.log.Logger.info("TAG - PermissionUtils - checkPermissionImpl - check return.");
            return;
        }
        final com.up366.mobile.common.utils.PermissionUtils.Holder holderPoll = queue.poll();
        if (holderPoll == null) {
            return;
        }
        final com.up366.mobile.common.base.BaseActivity baseActivity2 = (com.up366.mobile.common.base.BaseActivity) holderPoll.context;
        if (baseActivity2.isFinishing()) {
            com.up366.common.log.Logger.info("TAG - PermissionUtils - checkPermissionImpl - check finishing return.");
            checkPermissionImpl();
        } else {
            onRequestPermissions = true;
            com.up366.common.task.TaskUtils.postLazyTaskMain("checkPermissionTask", 100, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.PermissionUtils$$ExternalSyntheticLambda8
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.mobile.common.utils.PermissionUtils.lambda$checkPermissionImpl$0(holderPoll, baseActivity2);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$checkPermissionImpl$0(com.up366.mobile.common.utils.PermissionUtils.Holder holder, com.up366.mobile.common.base.BaseActivity baseActivity) throws java.lang.Exception {
        context = holder.context;
        errorTips = holder.errorTips;
        funName = holder.funName;
        permissions = holder.permissions;
        callback = holder.callback;
        for (java.lang.String str : permissions) {
            boolean zCanRequestPackageInstalls = androidx.core.content.ContextCompat.checkSelfPermission(context, str) == 0;
            if (com.up366.mobile.common.utils.permissions.Permission.REQUEST_INSTALL_PACKAGES.equals(str)) {
                zCanRequestPackageInstalls = android.os.Build.VERSION.SDK_INT >= 26 ? zCanRequestPackageInstalls | context.getPackageManager().canRequestPackageInstalls() : true;
            }
            if (!zCanRequestPackageInstalls) {
                onWaitSystemPermissionDialog = true;
                if (dialog != null) {
                    return;
                }
                boolean z = true;
                for (java.lang.String str2 : permissions) {
                    com.up366.common.log.Logger.info("TAG - PermissionUtils - checkPermissionImpl - permission: " + com.up366.mobile.common.utils.permissions.PermissionApi.isGrantedPermission(baseActivity, str2) + " - " + com.up366.mobile.common.utils.permissions.PermissionApi.isDoNotAskAgainPermission(baseActivity, str2) + " - " + str2);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("isFirstRequestPermission");
                    sb.append(str2);
                    boolean z2 = com.up366.mobile.common.utils.PreferenceUtils.getBoolean(sb.toString(), true);
                    if (com.up366.mobile.common.utils.permissions.Permission.REQUEST_INSTALL_PACKAGES.equals(str2)) {
                        z = false;
                    }
                    if (z2) {
                        com.up366.mobile.common.utils.PreferenceUtils.putBoolean("isFirstRequestPermission" + str2, false);
                    } else if (com.up366.mobile.common.utils.permissions.PermissionApi.isDoNotAskAgainPermission(baseActivity, str2)) {
                        z = false;
                    }
                }
                if (z) {
                    androidx.core.app.ActivityCompat.requestPermissions((android.app.Activity) context, permissions, REQUEST_PERMISSIONS_REQUEST_CODE);
                    permissionDialog = com.up366.mobile.common.dialog.PermissionDialog.create(context).title("天学网需要申请" + com.up366.common.StringUtils.join(errorTips, "、")).content("天学网需要申请" + com.up366.common.StringUtils.join(errorTips, "、") + "，以便您能使用" + funName + "服务。拒绝或取消授权不影响使用其他服务").show();
                    return;
                }
                obtainPermissionsDialog(context, errorTips, permissions);
                return;
            }
        }
        onGranted();
    }

    private static boolean isHarmonyOs() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.system.BuildEx");
            java.lang.Object objInvoke = cls.getMethod("getOsBrand", null).invoke(cls, null);
            if (objInvoke == null) {
                return false;
            }
            return "harmony".equalsIgnoreCase(objInvoke.toString());
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private static void checkPermissionNoRequest(android.content.Context context2, java.lang.String[] strArr, java.lang.String[] strArr2, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        int[] iArr = new int[strArr2.length];
        for (int i = 0; i < strArr2.length; i++) {
            java.lang.String str = strArr2[i];
            int iCheckSelfPermission = androidx.core.content.ContextCompat.checkSelfPermission(context2, str);
            iArr[i] = iCheckSelfPermission;
            boolean zCanRequestPackageInstalls = true;
            boolean z = iCheckSelfPermission == 0;
            if (!com.up366.mobile.common.utils.permissions.Permission.REQUEST_INSTALL_PACKAGES.equals(str)) {
                zCanRequestPackageInstalls = z;
            } else if (android.os.Build.VERSION.SDK_INT >= 26) {
                zCanRequestPackageInstalls = z | context2.getPackageManager().canRequestPackageInstalls();
            }
            if (!zCanRequestPackageInstalls) {
                onDenied(getTitleString(strArr, "失败！", i));
                return;
            }
        }
        onGranted();
    }

    private static void obtainPermissionsDialog(final android.content.Context context2, java.lang.String[] strArr, final java.lang.String[] strArr2) {
        onWaitSystemPermissionDialog = false;
        final java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < strArr2.length; i++) {
            arrayList.add(strArr[i]);
        }
        java.lang.String str = "天学网需要申请" + android.text.TextUtils.join("、", arrayList);
        java.lang.String str2 = str + "，以便您能使用" + funName + "服务。拒绝或取消授权不影响使用其他服务";
        com.up366.mobile.common.dialog.AppDialog appDialog = dialog;
        if (appDialog != null) {
            appDialog.title(str);
            dialog.message(str2);
        } else {
            dialog = com.up366.mobile.common.dialog.AppDialog.create(context2).title(str).setCancelable(false).message(str2).setOnDissmissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.utils.PermissionUtils$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(android.content.DialogInterface dialogInterface) {
                    com.up366.mobile.common.utils.PermissionUtils.dialog = null;
                }
            }).btnClose(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.utils.PermissionUtils$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.common.utils.PermissionUtils.onDenied("获取" + android.text.TextUtils.join(com.igexin.push.core.b.an, arrayList) + "失败！");
                }
            }).right("去授权", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.utils.PermissionUtils$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.common.utils.PermissionUtils.lambda$obtainPermissionsDialog$3(strArr2, context2, view);
                }
            }).left("取消", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.utils.PermissionUtils$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.common.utils.PermissionUtils.onDenied("获取" + android.text.TextUtils.join(com.igexin.push.core.b.an, arrayList) + "失败！");
                }
            }).show();
        }
    }

    static /* synthetic */ void lambda$obtainPermissionsDialog$3(java.lang.String[] strArr, android.content.Context context2, android.view.View view) {
        if (com.up366.mobile.common.utils.permissions.Permission.REQUEST_INSTALL_PACKAGES.equals(strArr[0])) {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                try {
                    ((android.app.Activity) context2).startActivityForResult(new android.content.Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES"), REQUEST_PERMISSIONS_REQUEST_CODE);
                    return;
                } catch (java.lang.Exception e) {
                    com.up366.common.log.Logger.error("obtainPermissionsDialog error: " + e.getMessage(), e);
                    com.up366.mobile.common.utils.ToastPopupUtil.show("跳转设置页面失败，请手动设置");
                    return;
                }
            }
            return;
        }
        try {
            android.content.Intent intent = new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(android.net.Uri.fromParts("package", context2.getPackageName(), null));
            ((android.app.Activity) context2).startActivityForResult(intent, 1024);
        } catch (java.lang.Exception e2) {
            com.up366.common.log.Logger.error("obtainPermissionsDialog error: " + e2.getMessage(), e2);
            com.up366.mobile.common.utils.ToastPopupUtil.show("跳转设置页面失败，请手动设置");
        }
    }

    private static void checkLowerVersionPermissions(final java.lang.String[] strArr) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.PermissionUtils$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.utils.PermissionUtils.lambda$checkLowerVersionPermissions$6(strArr);
            }
        });
    }

    static /* synthetic */ void lambda$checkLowerVersionPermissions$6(final java.lang.String[] strArr) throws java.lang.Exception {
        final int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            if (com.up366.mobile.common.utils.permissions.Permission.CAMERA.equals(strArr[i])) {
                iArr[i] = 0;
            } else if (com.up366.mobile.common.utils.permissions.Permission.RECORD_AUDIO.equals(strArr[i])) {
                iArr[i] = checkRecordPermissions();
            } else {
                iArr[i] = 0;
            }
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.PermissionUtils$$ExternalSyntheticLambda9
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.common.utils.PermissionUtils.onRequestLowerVersionPermissionsResult(com.up366.mobile.common.utils.PermissionUtils.REQUEST_PERMISSIONS_REQUEST_CODE, strArr, iArr);
            }
        });
    }

    private static void onGranted() {
        onLGranted();
        checkPermissionImpl();
    }

    private static void onLGranted() {
        onRequestPermissions = false;
        callback.onResult(0, "Granted");
        callback = null;
        context = null;
        permissions = null;
        com.up366.mobile.common.dialog.AppDialog appDialog = dialog;
        if (appDialog != null) {
            appDialog.dismiss();
            dialog = null;
        }
        com.up366.mobile.common.dialog.PermissionDialog permissionDialog2 = permissionDialog;
        if (permissionDialog2 != null) {
            permissionDialog2.dismiss();
            permissionDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onDenied(java.lang.String str) {
        if (str.contains("蓝牙权限")) {
            com.up366.mobile.common.utils.PreferenceUtils.putBoolean(BLUETOOTH_IGNORE, true);
            onLGranted();
            return;
        }
        onRequestPermissions = false;
        com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo = callback;
        if (iCallbackCodeInfo != null) {
            iCallbackCodeInfo.onResult(-1, str);
            callback = null;
        }
        context = null;
        permissions = null;
        com.up366.mobile.common.dialog.AppDialog appDialog = dialog;
        if (appDialog != null) {
            appDialog.dismiss();
            dialog = null;
        }
        com.up366.mobile.common.dialog.PermissionDialog permissionDialog2 = permissionDialog;
        if (permissionDialog2 != null) {
            permissionDialog2.dismiss();
            permissionDialog = null;
        }
        checkPermissionImpl();
    }

    public static void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        if (i != REQUEST_PERMISSIONS_REQUEST_CODE) {
            return;
        }
        onWaitSystemPermissionDialog = false;
        if (context == null || strArr.length == 0 || iArr.length == 0) {
            return;
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == -1) {
                onDenied(getTitleString(errorTips, "失败！", i2));
                return;
            }
        }
        onGranted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onRequestLowerVersionPermissionsResult(int i, final java.lang.String[] strArr, int[] iArr) {
        if (i != REQUEST_PERMISSIONS_REQUEST_CODE) {
            return;
        }
        for (final int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == -1) {
                java.lang.String titleString = getTitleString(errorTips, "失败", i2);
                java.lang.String messageString = getMessageString(i2, errorTips, "才能正常使用，请打开手机的权限管理应用，并设置", "为允许，然后再点击“确定”按钮重试。");
                com.up366.mobile.common.dialog.AppDialog appDialog = dialog;
                if (appDialog != null) {
                    appDialog.title(titleString);
                    dialog.message(messageString);
                    return;
                } else {
                    dialog = com.up366.mobile.common.dialog.AppDialog.create(context).title(titleString).setCancelable(false).message(messageString).setOnDissmissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.utils.PermissionUtils$$ExternalSyntheticLambda11
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(android.content.DialogInterface dialogInterface) {
                            com.up366.mobile.common.utils.PermissionUtils.dialog = null;
                        }
                    }).btnClose(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.utils.PermissionUtils$$ExternalSyntheticLambda12
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            com.up366.mobile.common.utils.PermissionUtils.onDenied(com.up366.mobile.common.utils.PermissionUtils.getTitleString(com.up366.mobile.common.utils.PermissionUtils.errorTips, "失败！", i2));
                        }
                    }).right("确定", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.utils.PermissionUtils$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            com.up366.mobile.common.utils.PermissionUtils.checkPermission(com.up366.mobile.common.utils.PermissionUtils.context, com.up366.mobile.common.utils.PermissionUtils.errorTips, strArr, com.up366.mobile.common.utils.PermissionUtils.funName, com.up366.mobile.common.utils.PermissionUtils.callback);
                        }
                    }).left("取消", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.utils.PermissionUtils$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            com.up366.mobile.common.utils.PermissionUtils.onDenied(com.up366.mobile.common.utils.PermissionUtils.getTitleString(com.up366.mobile.common.utils.PermissionUtils.errorTips, "失败！", i2));
                        }
                    }).show();
                    return;
                }
            }
        }
        onGranted();
    }

    private static java.lang.String getTitleString(java.lang.String[] strArr, java.lang.String str, int i) {
        return "获取" + strArr[i] + str;
    }

    private static java.lang.String getMessageString(int i, java.lang.String[] strArr, java.lang.String str, java.lang.String str2) {
        return "天学网AI“" + funName + "”功能需要" + strArr[i] + str + strArr[i] + str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x002b A[EXC_TOP_SPLITTER, PHI: r2 r3
  0x002b: PHI (r2v6 android.media.AudioRecord) = (r2v5 android.media.AudioRecord), (r2v7 android.media.AudioRecord) binds: [B:22:0x0036, B:14:0x0029] A[DONT_GENERATE, DONT_INLINE]
  0x002b: PHI (r3v2 int) = (r3v1 int), (r3v5 int) binds: [B:22:0x0036, B:14:0x0029] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int checkRecordPermissions() {
        /*
            long r0 = android.os.SystemClock.elapsedRealtime()
            long r2 = com.up366.mobile.book.helper.recorder.SpeechRecordHelper.endRecordTime
            long r0 = r0 - r2
            r2 = 3000(0xbb8, double:1.482E-320)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            if (r0 >= 0) goto Lf
            return r1
        Lf:
            r0 = -3
            r2 = 0
            android.media.AudioRecord r2 = createPermissionCheckAudioRecord()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            if (r2 == 0) goto L28
            r2.startRecording()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r3]     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            int r3 = r2.read(r4, r1, r3)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r2.stop()     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L2f
            goto L29
        L26:
            r4 = move-exception
            goto L33
        L28:
            r3 = r0
        L29:
            if (r2 == 0) goto L39
        L2b:
            r2.release()     // Catch: java.lang.Exception -> L39
            goto L39
        L2f:
            r0 = move-exception
            goto L45
        L31:
            r4 = move-exception
            r3 = r0
        L33:
            com.up366.common.log.Logger.warn(r4)     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L39
            goto L2b
        L39:
            if (r3 != r0) goto L44
            java.lang.String r0 = "checkRecordPermissions-DENIED"
            java.lang.String r1 = "PERMISSION_DENIED"
            com.up366.mobile.common.onlinelog.OpLog.report(r0, r1)
            r0 = -1
            return r0
        L44:
            return r1
        L45:
            if (r2 == 0) goto L4a
            r2.release()     // Catch: java.lang.Exception -> L4a
        L4a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.utils.PermissionUtils.checkRecordPermissions():int");
    }

    private static android.media.AudioRecord createPermissionCheckAudioRecord() {
        int minBufferSize = android.media.AudioRecord.getMinBufferSize(16000, 16, 2);
        if (minBufferSize <= 0) {
            minBufferSize = 1024;
        }
        return new android.media.AudioRecord(1, 16000, 16, 2, minBufferSize);
    }

    public static void onResume() {
        if (!onWaitSystemPermissionDialog && onRequestPermissions) {
            com.up366.common.task.TaskUtils.postLazyTaskMain("onResumeCheckPermission", 100, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.PermissionUtils$$ExternalSyntheticLambda10
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.mobile.common.utils.PermissionUtils.lambda$onResume$11();
                }
            });
        }
    }

    static /* synthetic */ void lambda$onResume$11() throws java.lang.Exception {
        if (onRequestPermissions) {
            checkPermissionNoRequest(context, errorTips, permissions, callback);
        }
    }

    public static void checkInstallPermission(android.content.Context context2, java.lang.String str, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        checkPermission(context2, new java.lang.String[]{"应用内安装其他应用权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.REQUEST_INSTALL_PACKAGES}, context2.getString(com.up366.mobile.R.string.permission_install), iCallbackCodeInfo);
    }

    public static void checkStoragePermission(android.content.Context context2, java.lang.String str, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        checkPermission(context2, new java.lang.String[]{"存储权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE}, context2.getString(com.up366.mobile.R.string.permission_storage), iCallbackCodeInfo);
    }

    public static void checkReadStoragePermission(android.content.Context context2, java.lang.String str, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        checkPermission(context2, new java.lang.String[]{"相册权限"}, new java.lang.String[]{compatPermission()}, context2.getString(com.up366.mobile.R.string.permission_storage), iCallbackCodeInfo);
    }

    public static java.lang.String compatPermission() {
        return com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE;
    }

    public static void checkRecordPermission(android.content.Context context2, java.lang.String str, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        boolean z = com.up366.mobile.common.utils.PreferenceUtils.getBoolean(BLUETOOTH_IGNORE, false);
        if (android.os.Build.VERSION.SDK_INT >= 31 && !z && com.up366.mobile.common.logic.Auth.cur().config().isUseBlueToothConnect()) {
            checkPermission(context2, new java.lang.String[]{"麦克风权限", "蓝牙权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.RECORD_AUDIO, com.up366.mobile.common.utils.permissions.Permission.BLUETOOTH_CONNECT}, context2.getString(com.up366.mobile.R.string.permission_mike), iCallbackCodeInfo);
        } else {
            checkPermission(context2, new java.lang.String[]{"麦克风权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.RECORD_AUDIO}, context2.getString(com.up366.mobile.R.string.permission_mike), iCallbackCodeInfo);
        }
    }

    public static void checkCameraPermission(android.content.Context context2, java.lang.String str, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        checkPermission(context2, new java.lang.String[]{"相机权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, context2.getString(com.up366.mobile.R.string.permission_camera), iCallbackCodeInfo);
    }

    static class Holder {
        com.up366.common.callback.ICallbackCodeInfo callback;
        android.content.Context context;
        java.lang.String[] errorTips;
        java.lang.String funName;
        java.lang.String[] permissions;

        public Holder(android.content.Context context, java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String str, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
            this.context = context;
            this.errorTips = strArr;
            this.permissions = strArr2;
            this.funName = str;
            this.callback = iCallbackCodeInfo;
        }
    }
}
