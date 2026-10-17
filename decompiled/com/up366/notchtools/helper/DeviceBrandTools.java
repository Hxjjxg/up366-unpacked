package com.up366.notchtools.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class DeviceBrandTools {
    private static com.up366.notchtools.helper.DeviceBrandTools sDeviceBrandTools;

    public static com.up366.notchtools.helper.DeviceBrandTools getInstance() {
        if (sDeviceBrandTools == null) {
            synchronized (com.up366.notchtools.helper.DeviceBrandTools.class) {
                if (sDeviceBrandTools == null) {
                    sDeviceBrandTools = new com.up366.notchtools.helper.DeviceBrandTools();
                }
            }
        }
        return sDeviceBrandTools;
    }

    public final boolean isHuaWei() {
        java.lang.String str = android.os.Build.MANUFACTURER;
        return !android.text.TextUtils.isEmpty(str) && str.contains("HUAWEI");
    }

    public final boolean isMiui() {
        return !android.text.TextUtils.isEmpty(getSystemProperty(com.igexin.assist.control.xiaomi.XmSystemUtils.KEY_VERSION_MIUI));
    }

    public final boolean isOppo() {
        return com.igexin.assist.util.AssistUtils.BRAND_OPPO.equalsIgnoreCase(android.os.Build.MANUFACTURER);
    }

    public final boolean isVivo() {
        return !android.text.TextUtils.isEmpty(getSystemProperty("ro.vivo.os.name"));
    }

    public final boolean isSamsung() {
        return "samsung".equalsIgnoreCase(android.os.Build.MANUFACTURER);
    }

    private java.lang.String getSystemProperty(java.lang.String str) {
        return com.up366.notchtools.helper.SystemProperties.getInstance().get(str);
    }
}
