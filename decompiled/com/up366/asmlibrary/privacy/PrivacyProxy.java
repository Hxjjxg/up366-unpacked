package com.up366.asmlibrary.privacy;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PrivacyProxy {
    public static final java.lang.String CLASS_NAME_ACTIVITY_MANAGER = "android/app/ActivityManager";
    public static final java.lang.String CLASS_NAME_TELEPHONY_MANAGER = "android/telephony/TelephonyManager";
    public static final java.lang.String CLASS_NAME_WIFI_INFO = "android/net/wifi/WifiInfo";
    public static final int OPCODE_INVOKE_STATIC = 184;
    public static final int OPCODE_INVOKE_VIRTUAL = 182;
    private static final com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData = new com.up366.asmlibrary.privacy.PrivacyProxy.CacheData();
    private static boolean isAgreePrivacyDialog = false;

    public static void initLogger(com.up366.common.log.LogLevel logLevel, java.lang.String str) {
        com.up366.common.log.Logger.init(logLevel, "ASM", str);
    }

    public static void setAgreePrivacyDialog(boolean z) {
        isAgreePrivacyDialog = z;
    }

    private static boolean checkAgreePrivacy(java.lang.String str) {
        com.up366.common.log.Logger.info("调用隐私相关api:" + str + ", 是否已同意隐私弹框" + isAgreePrivacyDialog);
        return isAgreePrivacyDialog;
    }

    public static java.lang.String getDeviceId(android.telephony.TelephonyManager telephonyManager) {
        if (!checkAgreePrivacy("getDeviceId")) {
            return "";
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            com.up366.common.log.Logger.info("android Q 以上，无法调用 getDeviceId");
            return "";
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (!com.up366.common.StringUtils.isEmptyOrNull(cacheData2.deviceId)) {
            return cacheData2.deviceId;
        }
        cacheData2.deviceId = telephonyManager.getDeviceId();
        return cacheData2.deviceId;
    }

    public static java.lang.String getDeviceId(android.telephony.TelephonyManager telephonyManager, int i) {
        if (!checkAgreePrivacy("getDeviceId")) {
            return "";
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            com.up366.common.log.Logger.info("android Q 以上，无法调用 getDeviceId");
            return "";
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (!com.up366.common.StringUtils.isEmptyOrNull(cacheData2.deviceId)) {
            return cacheData2.deviceId;
        }
        cacheData2.deviceId = telephonyManager.getDeviceId(i);
        return cacheData2.deviceId;
    }

    public static java.lang.String getImei(android.telephony.TelephonyManager telephonyManager) {
        if (!checkAgreePrivacy("getImei")) {
            return "";
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            com.up366.common.log.Logger.info("android Q 以上，无法调用 getImei");
            return "";
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (!com.up366.common.StringUtils.isEmptyOrNull(cacheData2.imei)) {
            return cacheData2.imei;
        }
        cacheData2.imei = telephonyManager.getImei();
        return cacheData2.imei;
    }

    public static java.lang.String getImei(android.telephony.TelephonyManager telephonyManager, int i) {
        if (!checkAgreePrivacy("getImei")) {
            return "";
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            com.up366.common.log.Logger.info(" android Q 以上，无法调用 getImei");
            return "";
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (!com.up366.common.StringUtils.isEmptyOrNull(cacheData2.imei)) {
            return cacheData2.imei;
        }
        cacheData2.imei = telephonyManager.getImei(i);
        return cacheData2.imei;
    }

    public static java.lang.String getSimSerialNumber(android.telephony.TelephonyManager telephonyManager) {
        if (!checkAgreePrivacy("getSimSerialNumber")) {
            return "";
        }
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            com.up366.common.log.Logger.info("android Q 以上，无法调用 getSimSerialNumber");
            return "";
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (!com.up366.common.StringUtils.isEmptyOrNull(cacheData2.serialNumber)) {
            return cacheData2.serialNumber;
        }
        cacheData2.serialNumber = telephonyManager.getSimSerialNumber();
        return cacheData2.serialNumber;
    }

    public static java.util.List<android.app.ActivityManager.RunningAppProcessInfo> getRunningAppProcesses(android.app.ActivityManager activityManager) {
        if (!checkAgreePrivacy("getRunningAppProcesses")) {
            return new java.util.ArrayList();
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (cacheData2.runningAppProcessInfoList != null) {
            return cacheData2.runningAppProcessInfoList;
        }
        cacheData2.runningAppProcessInfoList = activityManager.getRunningAppProcesses();
        return cacheData2.runningAppProcessInfoList;
    }

    public static java.util.List<android.app.ActivityManager.RecentTaskInfo> getRecentTasks(android.app.ActivityManager activityManager, int i, int i2) {
        if (!checkAgreePrivacy("getRecentTasks")) {
            return new java.util.ArrayList();
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (cacheData2.recentTaskInfoList != null) {
            return cacheData2.recentTaskInfoList;
        }
        cacheData2.recentTaskInfoList = activityManager.getRecentTasks(i, i2);
        return cacheData2.recentTaskInfoList;
    }

    public static java.util.List<android.app.ActivityManager.RunningTaskInfo> getRunningTasks(android.app.ActivityManager activityManager, int i) {
        if (!checkAgreePrivacy("getRunningTasks")) {
            return new java.util.ArrayList();
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (cacheData2.runningTaskInfoList != null) {
            return cacheData2.runningTaskInfoList;
        }
        cacheData2.runningTaskInfoList = activityManager.getRunningTasks(i);
        return cacheData2.runningTaskInfoList;
    }

    public static java.util.List<android.telephony.CellInfo> getAllCellInfo(android.telephony.TelephonyManager telephonyManager) {
        if (!checkAgreePrivacy("getAllCellInfo")) {
            return new java.util.ArrayList();
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (cacheData2.cellInfoList != null) {
            return cacheData2.cellInfoList;
        }
        cacheData2.cellInfoList = telephonyManager.getAllCellInfo();
        return cacheData2.cellInfoList;
    }

    public static java.lang.String getSSID(android.net.wifi.WifiInfo wifiInfo) {
        if (!checkAgreePrivacy("getSSID")) {
            return "";
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (!com.up366.common.StringUtils.isEmptyOrNull(cacheData2.ssid)) {
            return cacheData2.ssid;
        }
        cacheData2.ssid = wifiInfo.getSSID();
        return cacheData2.ssid;
    }

    public static java.lang.String getBSSID(android.net.wifi.WifiInfo wifiInfo) {
        if (!checkAgreePrivacy("getBSSID")) {
            return "";
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (!com.up366.common.StringUtils.isEmptyOrNull(cacheData2.bssid)) {
            return cacheData2.bssid;
        }
        cacheData2.bssid = wifiInfo.getBSSID();
        return cacheData2.bssid;
    }

    public static java.lang.String toString(android.net.wifi.WifiInfo wifiInfo) {
        if (!checkAgreePrivacy("toString")) {
            return "";
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (!com.up366.common.StringUtils.isEmptyOrNull(cacheData2.WifiInfo_toString)) {
            return cacheData2.WifiInfo_toString;
        }
        cacheData2.WifiInfo_toString = wifiInfo.toString();
        return cacheData2.WifiInfo_toString;
    }

    public static java.lang.String getMacAddress(android.net.wifi.WifiInfo wifiInfo) {
        if (!checkAgreePrivacy("getMacAddress")) {
            return "";
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (!com.up366.common.StringUtils.isEmptyOrNull(cacheData2.macAddress)) {
            return cacheData2.macAddress;
        }
        cacheData2.macAddress = wifiInfo.getMacAddress();
        return cacheData2.macAddress;
    }

    public static java.lang.String getString(android.content.ContentResolver contentResolver, java.lang.String str) {
        if (!checkAgreePrivacy("getAndroidId")) {
            return "";
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (!com.up366.common.StringUtils.isEmptyOrNull(cacheData2.androidId)) {
            return cacheData2.androidId;
        }
        cacheData2.androidId = android.provider.Settings.System.getString(contentResolver, str);
        return cacheData2.androidId;
    }

    public static java.util.List<android.hardware.Sensor> getSensorList(android.hardware.SensorManager sensorManager, int i) {
        if (!checkAgreePrivacy("getSensorList")) {
            return new java.util.ArrayList();
        }
        if (cacheData.sensorList != null) {
            return sensorManager.getSensorList(i);
        }
        return sensorManager.getSensorList(i);
    }

    public static android.net.DhcpInfo getDhcpInfo(android.net.wifi.WifiManager wifiManager) {
        if (checkAgreePrivacy("getDhcpInfo")) {
            return wifiManager.getDhcpInfo();
        }
        return null;
    }

    public static java.util.List<android.net.wifi.WifiConfiguration> getConfiguredNetworks(android.net.wifi.WifiManager wifiManager) {
        if (checkAgreePrivacy("getConfiguredNetworks")) {
            return wifiManager.getConfiguredNetworks();
        }
        return null;
    }

    public static android.location.Location getLastKnownLocation(android.location.LocationManager locationManager, java.lang.String str) {
        if (!checkAgreePrivacy("getLastKnownLocation")) {
            return null;
        }
        com.up366.asmlibrary.privacy.PrivacyProxy.CacheData cacheData2 = cacheData;
        if (cacheData2.location != null) {
            return cacheData2.location;
        }
        cacheData2.location = locationManager.getLastKnownLocation(str);
        return cacheData2.location;
    }

    public static void requestLocationUpdates(android.location.LocationManager locationManager, java.lang.String str, long j, float f, android.location.LocationListener locationListener) {
        if (checkAgreePrivacy("requestLocationUpdates")) {
            locationManager.requestLocationUpdates(str, j, f, locationListener);
        }
    }

    private static class CacheData {
        java.lang.String WifiInfo_toString;
        java.lang.String androidId;
        java.lang.String bssid;
        java.util.List<android.telephony.CellInfo> cellInfoList;
        java.lang.String deviceId;
        java.lang.String imei;
        android.location.Location location;
        java.lang.String macAddress;
        java.util.List<android.app.ActivityManager.RecentTaskInfo> recentTaskInfoList;
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcessInfoList;
        java.util.List<android.app.ActivityManager.RunningTaskInfo> runningTaskInfoList;
        java.util.List<android.hardware.Sensor> sensorList;
        java.lang.String serialNumber;
        java.lang.String ssid;

        private CacheData() {
        }
    }
}
