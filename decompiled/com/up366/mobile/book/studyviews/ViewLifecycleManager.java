package com.up366.mobile.book.studyviews;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ViewLifecycleManager {
    private static volatile com.up366.mobile.book.studyviews.ViewLifecycleManager sInstance;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> mValidIdMap = new java.util.concurrent.ConcurrentHashMap<>();

    public static com.up366.mobile.book.studyviews.ViewLifecycleManager getInstance() {
        if (sInstance == null) {
            synchronized (com.up366.mobile.book.studyviews.ViewLifecycleManager.class) {
                if (sInstance == null) {
                    sInstance = new com.up366.mobile.book.studyviews.ViewLifecycleManager();
                }
            }
        }
        return sInstance;
    }

    public void registerNewId(java.lang.String str, java.lang.String str2) {
        if (!com.up366.common.StringUtils.isEmptyOrNull(str) && !com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            com.up366.common.log.Logger.info("TAG - ViewLifecycleManager - registerNewId - [ activityCode: " + str + " ] - [ instanceId: " + str2 + " ]");
            this.mValidIdMap.put(str, str2);
            return;
        }
        com.up366.common.log.Logger.info("TAG - ViewLifecycleManager - registerNewId - Null value - [ activityCode: " + str + " ] - [ instanceId: " + str2 + " ]");
    }

    public boolean isValidId(java.lang.String str, java.lang.String str2) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str) || com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            com.up366.common.log.Logger.info("TAG - ViewLifecycleManager - isValidId - [ activityCodeToCheck: " + str + " ] - [ instanceIdToCheck: " + str2 + " ]");
            return false;
        }
        java.lang.String str3 = this.mValidIdMap.get(str);
        com.up366.common.log.Logger.info("TAG - ViewLifecycleManager - isValidId - [ activityCodeToCheck: " + str + " ] - [ latestInstanceId: " + str3 + " ] - [ instanceIdToCheck: " + str2 + " ]");
        return !com.up366.common.StringUtils.isEmptyOrNull(str3) && str3.equals(str2);
    }

    public void clearId(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return;
        }
        com.up366.common.log.Logger.info("TAG - ViewLifecycleManager - clearId - [ activityCode: " + str + " ]");
        this.mValidIdMap.remove(str);
    }
}
