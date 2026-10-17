package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DeviceIdHelper {
    private static java.lang.String uniqueDeviceId;

    public static void initDeviceId(android.content.Context context) {
        try {
            try {
                java.lang.String persistentData = com.up366.mobile.common.utils.PersistentStorageUtil.readPersistentData(context);
                uniqueDeviceId = persistentData;
                if (!com.up366.common.StringUtils.isEmptyOrNull(persistentData)) {
                    com.up366.common.log.Logger.info(" DeviceIdHelper -  PersistentData - " + uniqueDeviceId);
                    com.up366.mobile.common.utils.PreferenceUtils.putStringSync("uniqueDeviceId", uniqueDeviceId);
                }
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("TAG - DeviceIdHelper - initDeviceId - PersistentData error", e);
            }
            java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString("uniqueDeviceId", "");
            uniqueDeviceId = string;
            if (!com.up366.common.StringUtils.isEmptyOrNull(string)) {
                uniqueDeviceId = uniqueDeviceId.trim();
            }
            java.lang.String str = uniqueDeviceId;
            if (str != null && str.contains("Up366Mobile")) {
                com.up366.common.log.Logger.error("TAG - DeviceIdHelper - uniqueDeviceId - file - error : " + uniqueDeviceId);
                com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.DeviceIdHelper$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        com.up366.mobile.common.onlinelog.OpLog.report("init-uniqueDeviceId", "2: \"/storage/emulated/0/Up366Mobile\".equals(uniqueDeviceId)");
                    }
                });
                uniqueDeviceId = null;
            }
            if (com.up366.common.StringUtils.isEmptyOrNull(uniqueDeviceId)) {
                uniqueDeviceId = java.util.UUID.randomUUID().toString().replaceAll("-", "");
                com.up366.common.log.Logger.info("TAG - DeviceIdHelper - getUniqueDeviceId - init - " + uniqueDeviceId);
                com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.DeviceIdHelper$$ExternalSyntheticLambda1
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        com.up366.mobile.common.onlinelog.OpLog.report("init-new-uniqueDeviceId", com.up366.mobile.common.helper.DeviceIdHelper.uniqueDeviceId);
                    }
                });
            }
            com.up366.mobile.common.utils.PreferenceUtils.putString("uniqueDeviceId", uniqueDeviceId);
            try {
                com.up366.mobile.common.utils.PersistentStorageUtil.savePersistentData(context, uniqueDeviceId);
            } catch (java.lang.Exception e2) {
                com.up366.common.log.Logger.error("TAG - DeviceIdHelper - initDeviceId - PersistentData error", e2);
            }
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.DeviceIdHelper$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.onlinelog.OpLog.report("init-uniqueDeviceId", com.up366.mobile.common.helper.DeviceIdHelper.uniqueDeviceId + " - ");
                }
            });
        } catch (java.lang.Throwable th) {
            com.up366.common.log.Logger.error("TAG - DeviceIdHelper - getDeviceId - error", th);
            java.lang.String str2 = uniqueDeviceId;
            if (str2 == null || str2.length() < 10) {
                uniqueDeviceId = java.util.UUID.randomUUID().toString().replaceAll("-", "");
            }
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.DeviceIdHelper$$ExternalSyntheticLambda3
                @Override // com.up366.common.task.Task
                public final void run() {
                    java.lang.Throwable th2 = th;
                    com.up366.mobile.common.onlinelog.OpLog.report("get-unique-device-id-error", th2.getMessage(), th2);
                }
            });
        }
    }

    public static java.lang.String getDeviceId() {
        return uniqueDeviceId;
    }
}
