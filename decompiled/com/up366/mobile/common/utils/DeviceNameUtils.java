package com.up366.mobile.common.utils;

/* JADX INFO: compiled from: DeviceNameUtils.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002¨\u0006\b"}, d2 = {"Lcom/up366/mobile/common/utils/DeviceNameUtils;", "", "<init>", "()V", "getFullDeviceName", "", "getDeviceName", "getUserDeviceName", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeviceNameUtils {
    public static final com.up366.mobile.common.utils.DeviceNameUtils INSTANCE = new com.up366.mobile.common.utils.DeviceNameUtils();

    private DeviceNameUtils() {
    }

    public final java.lang.String getFullDeviceName() {
        java.lang.String str = android.os.Build.MANUFACTURER;
        java.lang.String deviceName = android.os.Build.MODEL;
        java.lang.String userDeviceName = getUserDeviceName();
        java.lang.String str2 = userDeviceName;
        if (str2 != null && str2.length() != 0) {
            return userDeviceName;
        }
        java.lang.String str3 = null;
        try {
            java.lang.reflect.Method method = java.lang.Class.forName("android.os.SystemProperties").getMethod("get", java.lang.String.class);
            java.lang.Object objInvoke = method.invoke(null, "ro.product.marketname");
            java.lang.String str4 = objInvoke instanceof java.lang.String ? (java.lang.String) objInvoke : null;
            if (str4 == null) {
                java.lang.Object objInvoke2 = method.invoke(null, "ro.product.name");
                if (objInvoke2 instanceof java.lang.String) {
                    str3 = (java.lang.String) objInvoke2;
                }
            } else {
                str3 = str4;
            }
        } catch (java.lang.Exception unused) {
        }
        if (str3 != null) {
            deviceName = str3;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(deviceName);
        kotlin.jvm.internal.Intrinsics.checkNotNull(str);
        if (!kotlin.text.StringsKt.contains(deviceName, str, true)) {
            deviceName = getDeviceName();
        }
        java.lang.String str5 = deviceName;
        kotlin.jvm.internal.Intrinsics.checkNotNull(str5);
        return kotlin.text.StringsKt.trim(kotlin.text.StringsKt.replace$default(str5, "_", " ", false, 4, (java.lang.Object) null)).toString();
    }

    private final java.lang.String getDeviceName() {
        java.lang.String str = android.os.Build.MANUFACTURER;
        java.lang.String str2 = android.os.Build.MODEL;
        kotlin.jvm.internal.Intrinsics.checkNotNull(str2);
        kotlin.jvm.internal.Intrinsics.checkNotNull(str);
        if (!kotlin.text.StringsKt.startsWith(str2, str, true)) {
            java.lang.String upperCase = str.toUpperCase(java.util.Locale.ROOT);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            java.lang.String str3 = null;
            if (upperCase.length() <= 0) {
                upperCase = null;
            }
            if (upperCase != null) {
                java.lang.String strValueOf = java.lang.String.valueOf(upperCase.charAt(0));
                kotlin.jvm.internal.Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                java.lang.String upperCase2 = strValueOf.toUpperCase(java.util.Locale.ROOT);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                java.lang.String strSubstring = upperCase.substring(1);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                java.lang.String lowerCase = strSubstring.toLowerCase(java.util.Locale.ROOT);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                str3 = upperCase2 + lowerCase;
            }
            str2 = str3 + " " + str2;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(str2);
        return str2;
    }

    private final java.lang.String getUserDeviceName() {
        java.lang.String str;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 25) {
                java.lang.String string = android.provider.Settings.Global.getString(com.up366.common.global.GB.get().getApplicationContext().getContentResolver(), "device_name");
                java.lang.String str2 = string;
                if (str2 != null && str2.length() != 0) {
                    java.lang.String str3 = android.os.Build.MANUFACTURER;
                    kotlin.jvm.internal.Intrinsics.checkNotNull(str3);
                    java.lang.String upperCase = str3.toUpperCase(java.util.Locale.ROOT);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    if (upperCase.length() <= 0) {
                        upperCase = null;
                    }
                    if (upperCase != null) {
                        java.lang.String strValueOf = java.lang.String.valueOf(upperCase.charAt(0));
                        kotlin.jvm.internal.Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                        java.lang.String upperCase2 = strValueOf.toUpperCase(java.util.Locale.ROOT);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                        java.lang.String strSubstring = upperCase.substring(1);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        java.lang.String lowerCase = strSubstring.toLowerCase(java.util.Locale.ROOT);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        str = upperCase2 + lowerCase;
                    } else {
                        str = null;
                    }
                    return str + " " + string;
                }
                return null;
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.info("LoginDeviceParamHelper getUserDeviceName error: " + e.getMessage());
        }
        return null;
    }
}
