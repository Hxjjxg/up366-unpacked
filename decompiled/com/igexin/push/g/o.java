package com.igexin.push.g;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class o {
    public static final java.lang.String a = "PhoneInfoUtils";
    public static final java.lang.String b = "";
    static boolean c;
    private static volatile android.content.pm.PackageInfo d;
    private static java.lang.String e;

    private static android.location.Location A() {
        try {
            return (android.location.Location) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.C).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static int a(android.content.Context context) {
        try {
            return c(context).applicationInfo.targetSdkVersion;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return 0;
        }
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop " + str).getInputStream()));
            java.lang.String str3 = "";
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    return str3;
                }
                str3 = str3 + line;
            }
        } catch (java.lang.Exception unused) {
            return str2;
        }
    }

    public static java.util.List<android.content.pm.PackageInfo> a() {
        java.util.List<android.content.pm.PackageInfo> list;
        try {
            list = (java.util.List) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.O).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            list = null;
        }
        return list == null ? java.util.Collections.emptyList() : list;
    }

    public static android.content.pm.ApplicationInfo b(android.content.Context context) {
        try {
            return c(context).applicationInfo;
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    public static android.util.Pair<java.lang.String, java.lang.String> b() {
        try {
            if (com.igexin.push.config.d.X && !com.igexin.push.g.d.b("3.1.12.0")) {
                com.igexin.c.a.c.a.b(a, "use gt wf");
                com.getui.gtc.dim.bean.GtWifiInfo json = com.getui.gtc.dim.bean.GtWifiInfo.parseJson((java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.I).caller(com.getui.gtc.dim.Caller.PUSH).build()));
                if (json == null) {
                    return null;
                }
                return android.util.Pair.create(json.getSSID(), json.getBSSID());
            }
            com.igexin.c.a.c.a.b(a, "use wf");
            android.net.wifi.WifiInfo wifiInfo = (android.net.wifi.WifiInfo) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.F).caller(com.getui.gtc.dim.Caller.PUSH).build());
            if (wifiInfo == null) {
                return null;
            }
            java.lang.String ssid = com.up366.asmlibrary.privacy.PrivacyProxy.getSSID(wifiInfo);
            java.lang.String bssid = com.up366.asmlibrary.privacy.PrivacyProxy.getBSSID(wifiInfo);
            com.up366.asmlibrary.Utils.writeLog("com/igexin/push/g/o  ->  b  ->  ()Landroid/util/Pair;\r\ncom/up366/asmlibrary/privacy/PrivacyProxy  ->  getBSSID  ->  (Landroid/net/wifi/WifiInfo;)Ljava/lang/String;\r\n", new java.lang.Throwable());
            return android.util.Pair.create(ssid, bssid);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    private static android.content.pm.PackageInfo c(android.content.Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        if (d != null) {
            com.igexin.c.a.c.a.b(a, "getSelfPackageInfo cache");
            return d;
        }
        synchronized (com.igexin.push.g.o.class) {
            if (d == null) {
                d = context.getPackageManager().getPackageInfo(context.getPackageName(), 128);
                com.igexin.c.a.c.a.b(a, "getSelfPackageInfo");
            }
        }
        return d;
    }

    public static java.lang.String c() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.j).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static java.lang.String d() {
        return android.os.Build.BRAND;
    }

    public static java.lang.String e() {
        return android.os.Build.MODEL;
    }

    public static java.lang.String f() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.f).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static java.lang.String g() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.b).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static java.lang.String h() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.q).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static java.lang.String i() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.r).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static java.util.List<android.net.wifi.ScanResult> j() {
        try {
            return (java.util.List) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.G).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return null;
        }
    }

    public static java.lang.String k() {
        try {
            return android.os.Build.SUPPORTED_ABIS[0];
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static boolean l() {
        try {
            if (!com.igexin.push.config.d.G.contains("*")) {
                return java.util.Arrays.asList(com.igexin.push.config.d.G.toUpperCase().split(com.igexin.push.core.b.an)).contains(android.os.Build.BRAND.toUpperCase());
            }
            com.igexin.c.a.c.a.a("PhoneInfoUtils|delAlarm all", new java.lang.Object[0]);
            return true;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PhoneInfoUtils|delAlarm " + com.igexin.push.config.d.G + " err " + e2.toString(), new java.lang.Object[0]);
            return false;
        }
    }

    public static java.lang.String m() {
        java.lang.String str;
        try {
            str = (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.l).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            str = null;
        }
        if (!android.text.TextUtils.isEmpty(str) && !str.equals(com.igexin.push.core.e.h)) {
            com.igexin.push.core.e.h = str;
        }
        return str;
    }

    public static java.lang.String n() {
        try {
            return c(com.igexin.push.core.e.l).versionName;
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    public static long o() {
        try {
            return c(com.igexin.push.core.e.l).versionCode;
        } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
            com.igexin.c.a.c.a.a(e2);
            return 0L;
        }
    }

    public static java.lang.String p() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.H).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a("PhoneInfoUtils|".concat(java.lang.String.valueOf(th)), new java.lang.Object[0]);
            return "";
        }
    }

    public static java.lang.String q() {
        try {
            byte[] propertyByteArray = new android.media.MediaDrm(new java.util.UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId");
            if (propertyByteArray == null) {
                return "";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (byte b2 : propertyByteArray) {
                sb.append(java.lang.String.format("%02x", java.lang.Byte.valueOf(b2)));
            }
            return sb.toString();
        } catch (java.lang.Error | java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String r() {
        try {
            android.content.Context context = com.igexin.push.core.e.l;
            if (!com.getui.gtc.base.util.CommonUtil.hasPermission(context, com.up366.mobile.common.utils.permissions.Permission.READ_PHONE_STATE, false)) {
                return "";
            }
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            switch (telephonyManager != null ? android.os.Build.VERSION.SDK_INT >= 24 ? com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(telephonyManager) : telephonyManager.getNetworkType() : 0) {
            }
            return "";
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static void s() {
        if (com.igexin.push.g.d.b("3.2.16.0")) {
            return;
        }
        com.getui.gtc.api.GtcManager.getInstance().addOnDycEnableChangedListener(com.igexin.push.core.e.l, new com.getui.gtc.api.OnDycEnableChangedListener.Stub() { // from class: com.igexin.push.g.o.1
            public final void onDycEnableChanged(final java.util.Map map) throws android.os.RemoteException {
                if (map == null || com.igexin.push.g.o.c) {
                    return;
                }
                com.igexin.push.g.o.c = true;
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.d() { // from class: com.igexin.push.g.o.1.1
                    @Override // com.igexin.push.f.d
                    public final void b() {
                        try {
                            if (java.util.Objects.equals(map.get(com.igexin.push.g.f.a.l), java.lang.Boolean.TRUE)) {
                                if (com.igexin.push.core.e.u) {
                                    com.igexin.push.core.a.b.d().i();
                                } else {
                                    com.igexin.push.core.e.aM = true;
                                }
                            }
                            if (java.util.Objects.equals(map.get(com.igexin.push.g.f.a.O), java.lang.Boolean.TRUE)) {
                                com.igexin.push.core.c.a.a().a(false);
                            }
                        } catch (java.lang.Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    }
                }, false, true);
            }
        });
    }

    public static java.lang.String t() {
        try {
            java.lang.Class<?> clsA = com.igexin.push.g.p.a("com.getui.oneid.OneIDManager");
            java.lang.Object objInvoke = com.igexin.push.g.p.a(clsA, "getInstance", new java.lang.Class[0]).invoke(null, null);
            java.lang.Class<?> clsA2 = com.igexin.push.g.p.a("com.getui.oneid.OneResponse");
            java.lang.reflect.Method methodA = com.igexin.push.g.p.a(clsA, "getOneResponse", new java.lang.Class[0]);
            methodA.setAccessible(true);
            java.lang.Object objInvoke2 = methodA.invoke(objInvoke, null);
            if (objInvoke2 == null) {
                return "";
            }
            java.lang.reflect.Method methodA2 = com.igexin.push.g.p.a(clsA2, "getOneAID", new java.lang.Class[0]);
            methodA2.setAccessible(true);
            java.lang.Object objInvoke3 = methodA2.invoke(objInvoke2, null);
            return objInvoke3 instanceof java.lang.String ? (java.lang.String) objInvoke3 : "";
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.b("getOneId error", th.toString());
            return "";
        }
    }

    private static java.lang.String u() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.e).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    private static java.lang.String v() {
        if (!android.text.TextUtils.isEmpty(e)) {
            return e;
        }
        try {
            java.lang.String str = android.os.Build.BRAND;
            if (android.text.TextUtils.isEmpty(str)) {
                return "";
            }
            java.lang.String lowerCase = str.toLowerCase();
            java.util.HashMap map = new java.util.HashMap();
            map.put(com.igexin.assist.util.AssistUtils.BRAND_HW, "ro.build.version.emui");
            map.put("blackshark", "ro.build.version.incremental");
            map.put("redmi", "ro.build.version.incremental");
            map.put(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI, "ro.build.version.incremental");
            map.put("samsang", "ro.build.version.incremental");
            map.put(com.igexin.assist.util.AssistUtils.BRAND_VIVO, "ro.vivo.os.version");
            map.put(com.igexin.assist.util.AssistUtils.BRAND_OPPO, "ro.build.version.opporom");
            map.put(com.igexin.assist.util.AssistUtils.BRAND_MZ, "ro.build.display.id");
            map.put("lenovo", "ro.build.version.incremental");
            map.put("smartisan", "ro.modversion");
            map.put("htc", "ro.build.sense.version");
            map.put("oneplus", "ro.rom.version");
            map.put("yunos", "ro.cta.yunos.version");
            map.put("360", "ro.build.uiversion");
            map.put("nubia", "ro.build.rom.internal.id");
            if (map.containsKey(lowerCase)) {
                java.lang.String strA = a((java.lang.String) map.get(lowerCase), "");
                e = strA;
                return strA;
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return "";
    }

    private static boolean w() {
        return android.os.Build.VERSION.SDK_INT > 28;
    }

    private static java.lang.String x() {
        return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.u).caller(com.getui.gtc.dim.Caller.PUSH).build());
    }

    private static java.lang.String y() {
        try {
            return (java.lang.String) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.J).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return "";
        }
    }

    private static android.location.Location z() {
        try {
            return (android.location.Location) com.getui.gtc.dim.DimManager.getInstance().get(new com.getui.gtc.dim.DimRequest.Builder().key(com.igexin.push.g.f.a.B).caller(com.getui.gtc.dim.Caller.PUSH).build());
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
