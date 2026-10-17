package com.up366.mobile.common.helper;

/* JADX INFO: compiled from: AlarmLogHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u001b\u0010\f\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/up366/mobile/common/helper/AlarmLogHelper;", "", "<init>", "()V", "PRE_FIX_ALARM_LOG", "", "END_FIX_ALARM_LOG", "alarmFiles", "buildAlarmLog", "errCode", "extData", "Lcom/alibaba/fastjson/JSONObject;", "getPicUrls", "picUrls", "", "([Ljava/lang/String;)Ljava/lang/String;", "P1p", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AlarmLogHelper {
    private static final java.lang.String END_FIX_ALARM_LOG = " [/U3Alarm]";
    private static final java.lang.String PRE_FIX_ALARM_LOG = " [U3Alarm]";
    public static final com.up366.mobile.common.helper.AlarmLogHelper INSTANCE = new com.up366.mobile.common.helper.AlarmLogHelper();
    private static final java.lang.String alarmFiles = com.up366.mobile.common.utils.AppFileUtils.getCacheDir() + java.io.File.separator + "alarmfiles" + java.io.File.separator;

    private AlarmLogHelper() {
    }

    /* JADX INFO: compiled from: AlarmLogHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/up366/mobile/common/helper/AlarmLogHelper$P1p;", "", "<init>", "()V", "_006002001", "", "_006002002", "_006002003", "_006002004", "_006002005", "_006002006", "_006002007", "_006002008", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class P1p {
        public static final com.up366.mobile.common.helper.AlarmLogHelper.P1p INSTANCE = new com.up366.mobile.common.helper.AlarmLogHelper.P1p();
        public static final java.lang.String _006002001 = "006002001";
        public static final java.lang.String _006002002 = "006002002";
        public static final java.lang.String _006002003 = "006002003";
        public static final java.lang.String _006002004 = "006002004";
        public static final java.lang.String _006002005 = "006002005";
        public static final java.lang.String _006002006 = "006002006";
        public static final java.lang.String _006002007 = "006002007";
        public static final java.lang.String _006002008 = "006002008";

        private P1p() {
        }
    }

    public final java.lang.String buildAlarmLog(java.lang.String errCode, com.alibaba.fastjson.JSONObject extData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(errCode, "errCode");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(extData, "extData");
        java.util.Map jSONObject = new com.alibaba.fastjson.JSONObject();
        java.util.Map map = jSONObject;
        map.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
        map.put("username", com.up366.mobile.common.logic.Auth.getUserInfo().getUsername());
        map.put("organId", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.getUserInfo().getOrganId()));
        map.put("clientId", com.up366.mobile.common.helper.DeviceIdHelper.getDeviceId());
        map.put("appType", com.up366.mobile.common.utils.PlatformUtils.getAppType());
        map.put("appVersion", com.up366.mobile.BuildConfig.VERSION_NAME);
        map.put("device", android.os.Build.MODEL + "(" + android.os.Build.VERSION.SDK_INT + ":" + android.os.Build.VERSION.RELEASE + ")");
        map.put("addTime", com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy-MM-dd HH:mm:ss.SSS"));
        java.lang.String strSubstring = errCode.substring(0, 3);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        map.put("bizCode", strSubstring);
        java.lang.String strSubstring2 = errCode.substring(0, 6);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        map.put("expCode", strSubstring2);
        map.put("errCode", errCode);
        map.put("extData", extData);
        return PRE_FIX_ALARM_LOG + jSONObject.toJSONString() + END_FIX_ALARM_LOG;
    }

    public final java.lang.String getPicUrls(java.lang.String[] picUrls) {
        if (picUrls == null || picUrls.length == 0) {
            return "";
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(picUrls);
        while (it.hasNext()) {
            java.lang.String str = (java.lang.String) it.next();
            if (com.up366.common.FileUtilsUp.isFileExists(str)) {
                java.lang.String str2 = alarmFiles + java.lang.System.currentTimeMillis() + com.up366.medialibrary.common.utils.MimeTypeUtils.JPG;
                com.up366.common.FileUtilsUp.copyFileOrDir(str, str2);
                com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo = com.up366.mobile.common.logic.Auth.cur().fileMgr().getFileMapInfo(null, str2);
                if (fileMapInfo != null) {
                    arrayList.add(fileMapInfo.getUrl());
                    com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog = new com.up366.mobile.common.logic.log.model.BatchUploadLog(2, fileMapInfo.getPath(), -1);
                    batchUploadLog.addFile(new java.io.File(fileMapInfo.getPath()), fileMapInfo.getObjectId());
                    com.up366.mobile.common.logic.Auth.cur().logMgr().addToBatchQueue(batchUploadLog);
                }
            }
        }
        return kotlin.collections.CollectionsKt.joinToString$default(arrayList, com.igexin.push.core.b.an, (java.lang.CharSequence) null, (java.lang.CharSequence) null, 0, (java.lang.CharSequence) null, (kotlin.jvm.functions.Function1) null, 62, (java.lang.Object) null);
    }
}
