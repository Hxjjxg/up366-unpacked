package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class AbstractC0059p {
    private static volatile boolean a = true;
    private static volatile int b = -2;
    private static volatile long c = 0;
    private static volatile java.lang.String d = "default_changeKey";
    private static long e = 0;
    private static int f = -1;
    static int g = -1;

    private static int a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    public static boolean a(android.content.Context context) {
        boolean z;
        try {
            if (context == null) {
                com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "checkAuthEnable context is null");
                return false;
            }
            android.content.Context applicationContext = context.getApplicationContext();
            boolean zM = m(applicationContext);
            boolean zL = l(applicationContext);
            boolean zG = g(applicationContext);
            int iJ = j(applicationContext);
            if (zM && !zL && zG) {
                java.lang.String strB = com.chuanglan.shanyan_sdk.C0065v.g().b(applicationContext);
                if (strB != null && !strB.equals("Unknown_Operator") && iJ != 0) {
                    com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "checkAuthEnable network Type", java.lang.Integer.valueOf(iJ), "netOperatorName", strB);
                    if ((!"CUCC".equals(strB) || iJ < 3) && ((!"CTCC".equals(strB) || iJ < 4) && iJ < 2)) {
                    }
                    com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "checkAuthEnable isAuthEnable", java.lang.Boolean.valueOf(z));
                    return z;
                }
                z = true;
                com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "checkAuthEnable isAuthEnable", java.lang.Boolean.valueOf(z));
                return z;
            }
            com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "checkAuthEnable simStateReady", java.lang.Boolean.valueOf(zM), "airplaneMode", java.lang.Boolean.valueOf(zL), "mobileDataEnabled", java.lang.Boolean.valueOf(zG), "networkType", java.lang.Integer.valueOf(iJ));
            z = false;
            com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "checkAuthEnable isAuthEnable", java.lang.Boolean.valueOf(z));
            return z;
        } catch (java.lang.Throwable th) {
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "checkAuthEnable Exception", th);
            return true;
        }
    }

    public static boolean b(android.content.Context context) {
        if (com.chuanglan.shanyan_sdk.AbstractC0055l.E) {
            return com.chuanglan.shanyan_sdk.AbstractC0050g.a(context, com.up366.mobile.common.utils.permissions.Permission.READ_PHONE_STATE);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(android.content.Context r6) {
        /*
            boolean r0 = com.chuanglan.shanyan_sdk.AbstractC0055l.H
            r1 = 1
            if (r0 != 0) goto L6
            return r1
        L6:
            java.lang.String r0 = "CheckAuthEnableShanYanLogger"
            r2 = 2
            r3 = 0
            if (r6 == 0) goto L28
            java.lang.String r4 = "wifi"
            java.lang.Object r6 = r6.getSystemService(r4)     // Catch: java.lang.Exception -> L1b
            android.net.wifi.WifiManager r6 = (android.net.wifi.WifiManager) r6     // Catch: java.lang.Exception -> L1b
            if (r6 == 0) goto L28
            boolean r6 = r6.isWifiEnabled()     // Catch: java.lang.Exception -> L1b
            goto L29
        L1b:
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.String r4 = "is wifi enable Exception"
            r6[r3] = r4
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r6[r1] = r4
            com.chuanglan.shanyan_sdk.Q.d(r0, r6)
        L28:
            r6 = r3
        L29:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r6)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r5 = "is wifi enable"
            r2[r3] = r5
            r2[r1] = r4
            com.chuanglan.shanyan_sdk.Q.a(r0, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuanglan.shanyan_sdk.AbstractC0059p.c(android.content.Context):boolean");
    }

    public static boolean d(android.content.Context context, java.lang.String str) {
        b = d(context);
        if (b == -1) {
            a = true;
            return true;
        }
        int iA = com.chuanglan.shanyan_sdk.p0.a(context, str, -2);
        if (iA == -2 || b != iA) {
            a = true;
            com.chuanglan.shanyan_sdk.p0.b(context, str, b);
        } else {
            a = false;
        }
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "Sub ID changed", "key", str, "oldSubId", java.lang.Integer.valueOf(iA), "newSubId", java.lang.Integer.valueOf(b), "isChanged", java.lang.Boolean.valueOf(a));
        return false;
    }

    private static int e(android.content.Context context) {
        java.lang.Integer numA = a(context, 0);
        int iIntValue = numA.intValue();
        try {
            if (!b(context)) {
                return iIntValue;
            }
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.telephony.SubscriptionManager").getDeclaredMethod("getSubId", java.lang.Integer.TYPE);
            declaredMethod.setAccessible(true);
            int[] iArr = (int[]) declaredMethod.invoke(null, numA);
            return (iArr == null || iArr.length <= 0) ? iIntValue : iArr[0];
        } catch (java.lang.Exception e2) {
            com.chuanglan.shanyan_sdk.Q.d("CheckAuthEnableShanYanLogger", "data sub by subid Exception_e", e2);
            return iIntValue;
        }
    }

    private static java.lang.String f(android.content.Context context) {
        android.telephony.TelephonyManager telephonyManager;
        java.lang.String networkOperator = null;
        try {
            telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                try {
                    networkOperator = telephonyManager.getSimOperator();
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "sim operator Exception_e", th);
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            telephonyManager = null;
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(networkOperator)) {
            try {
                java.lang.Integer numA = a(context, 1);
                if (telephonyManager != null && numA.intValue() != -1) {
                    java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.telephony.TelephonyManager").getDeclaredMethod("getNetworkOperatorForPhone", java.lang.Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    networkOperator = (java.lang.String) declaredMethod.invoke(telephonyManager, numA);
                }
            } catch (java.lang.Throwable th3) {
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "network operator for phone  Exception_e", th3);
            }
        }
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(networkOperator) && telephonyManager != null) {
            try {
                networkOperator = telephonyManager.getNetworkOperator();
            } catch (java.lang.Throwable th4) {
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "network operator Exception_e", th4);
            }
        }
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "default sim card  operator", networkOperator);
        return networkOperator;
    }

    public static boolean g(android.content.Context context) {
        boolean zIsMobileDataEnabled;
        if (!com.chuanglan.shanyan_sdk.AbstractC0055l.H) {
            return true;
        }
        if (context != null) {
            try {
                zIsMobileDataEnabled = cn.com.chinatelecom.account.api.CtAuth.getInstance().isMobileDataEnabled();
            } catch (java.lang.Throwable th) {
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "getMobileDataEnabled Exception_e", th);
                zIsMobileDataEnabled = true;
            }
        } else {
            zIsMobileDataEnabled = true;
        }
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "mobile data enable  ", java.lang.Boolean.valueOf(zIsMobileDataEnabled));
        return zIsMobileDataEnabled;
    }

    private static int h(android.content.Context context) {
        int iIntValue;
        if (context != null) {
            try {
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.telephony.TelephonyManager").getDeclaredMethod("getNetworkType", null);
                declaredMethod.setAccessible(true);
                iIntValue = ((java.lang.Integer) declaredMethod.invoke(telephonyManager, null)).intValue();
            } catch (java.lang.Throwable th) {
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "get Network2 Exception_e", th);
                iIntValue = -1;
            }
        } else {
            iIntValue = -1;
        }
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "net type ", java.lang.Integer.valueOf(iIntValue));
        return iIntValue;
    }

    public static java.lang.String i(android.content.Context context) {
        try {
            java.lang.String strB = b(f(context));
            com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "network Operator Type", strB);
            return strB;
        } catch (java.lang.Throwable th) {
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "network Operator Exception_e", th);
            return "Unknown_Operator";
        }
    }

    public static int j(android.content.Context context) {
        android.net.NetworkInfo activeNetworkInfo;
        int iIntValue;
        if (!com.chuanglan.shanyan_sdk.AbstractC0055l.H) {
            return 0;
        }
        try {
            int iB = b(context) ? b(c(context, d(context))) : 0;
            if (iB == 0 && (iIntValue = a(context, 1).intValue()) >= 0) {
                iB = b(context, iIntValue);
            }
            if (iB == 0) {
                int iH = h(context);
                int iB2 = b(iH);
                com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "get NetworkType", java.lang.Integer.valueOf(iH), "network", java.lang.Integer.valueOf(iB2));
                iB = iB2;
            }
            if (context != null && iB == 0 && (activeNetworkInfo = ((android.net.ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 0) {
                iB = a(activeNetworkInfo.getSubtype());
                com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "get Network Subtype", "network", java.lang.Integer.valueOf(iB));
            }
            com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "get Network network", java.lang.Integer.valueOf(iB));
            return iB;
        } catch (java.lang.Throwable th) {
            com.chuanglan.shanyan_sdk.Q.d("CheckAuthEnableShanYanLogger", "get Network Exception_e", th);
            return 0;
        }
    }

    public static int k(android.content.Context context) {
        int i;
        try {
            java.lang.String strA = a(context, "gsm.sim.state");
            java.lang.String strA2 = a(context, "gsm.sim.state.2");
            if (!com.chuanglan.shanyan_sdk.AbstractC0049f.a(strA2)) {
                strA = strA + com.igexin.push.core.b.an + strA2;
            }
            java.lang.String[] strArrSplit = com.chuanglan.shanyan_sdk.AbstractC0049f.a(strA) ? null : strA.split(com.igexin.push.core.b.an);
            com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "sim state", java.util.Arrays.toString(strArrSplit));
            if (strArrSplit != null) {
                i = 0;
                for (java.lang.String str : strArrSplit) {
                    try {
                        if (!"ABSENT".equalsIgnoreCase(str) && !"NOT_READY".equalsIgnoreCase(str)) {
                            i++;
                        }
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "simCardCount Exception", e);
                        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "current sim card count", java.lang.Integer.valueOf(i));
                        return i;
                    }
                }
            } else {
                int iD = d(context, 0);
                int iD2 = d(context, 1);
                com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "simState1", java.lang.Integer.valueOf(iD), "statesLength", java.lang.Integer.valueOf(iD2));
                i = iD == 5 ? 1 : 0;
                if (iD2 == 5) {
                    i++;
                }
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            i = 0;
        }
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "current sim card count", java.lang.Integer.valueOf(i));
        return i;
    }

    private static boolean l(android.content.Context context) {
        try {
        } catch (java.lang.Throwable th) {
            com.chuanglan.shanyan_sdk.Q.d("CheckAuthEnableShanYanLogger", "isAirplaneMode Exception_e", th);
        }
        boolean z = android.provider.Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1;
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "airplane mode  ", java.lang.Boolean.valueOf(z));
        return z;
    }

    private static boolean m(android.content.Context context) {
        if (!com.chuanglan.shanyan_sdk.AbstractC0055l.I) {
            return true;
        }
        try {
            com.chuanglan.shanyan_sdk.C0065v.g().e(context);
        } catch (java.lang.Throwable th) {
            com.chuanglan.shanyan_sdk.Q.d("CheckAuthEnableShanYanLogger", "isSimStateReady Exception_e", th);
        }
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "sim card  ready", true);
        return true;
    }

    public static boolean b(android.content.Context context, java.lang.String str) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long j = jCurrentTimeMillis - c;
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "intervalTime", java.lang.Long.valueOf(j), java.lang.Long.valueOf(c), d, str);
        if (j < 500 && d.equals(str)) {
            a = false;
            return a;
        }
        c = jCurrentTimeMillis;
        d = str;
        try {
            if (!c(context, str) && !d(context, str)) {
                return a;
            }
            return a;
        } catch (java.lang.Exception e2) {
            com.chuanglan.shanyan_sdk.Q.d("CheckAuthEnableShanYanLogger", "data sim card changed Exception", e2, java.lang.Boolean.valueOf(a));
            return a;
        }
    }

    public static boolean c(android.content.Context context, java.lang.String str) {
        int iA = com.chuanglan.shanyan_sdk.p0.a(context, "cl_jm_f9", -1);
        int iE = com.chuanglan.shanyan_sdk.C0065v.g().e(context);
        if (iE <= 0) {
            a = true;
            return true;
        }
        if (iA == iE) {
            return false;
        }
        a = true;
        com.chuanglan.shanyan_sdk.p0.b(context, "cl_jm_f9", iE);
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "SIM count changed", "key", str, "lastCount", java.lang.Integer.valueOf(iA), "currentCount", java.lang.Integer.valueOf(iE), "isChanged", java.lang.Boolean.valueOf(a));
        return true;
    }

    public static int d(android.content.Context context) {
        try {
        } catch (java.lang.Exception e2) {
            com.chuanglan.shanyan_sdk.Q.d("CheckAuthEnableShanYanLogger", "data sub  Exception_e", e2);
        }
        if (!com.chuanglan.shanyan_sdk.AbstractC0055l.I) {
            return f;
        }
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long j = e;
        long j2 = jElapsedRealtime - j;
        boolean z = j2 > com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS;
        boolean z2 = jElapsedRealtime < j;
        if (z || z2) {
            e = android.os.SystemClock.elapsedRealtime();
            int iA = a();
            f = iA;
            if (-1 == iA && com.chuanglan.shanyan_sdk.C0065v.g().e(context) > 0) {
                f = e(context);
            }
        }
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "current data sub ", java.lang.Integer.valueOf(f), java.lang.Long.valueOf(j2), java.lang.Boolean.valueOf(z), java.lang.Boolean.valueOf(z2));
        return f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static java.lang.String b(java.lang.String str) {
        str.hashCode();
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case 49679470:
                if (str.equals("46000")) {
                    b2 = 0;
                }
                break;
            case 49679471:
                if (str.equals("46001")) {
                    b2 = 1;
                }
                break;
            case 49679472:
                if (str.equals("46002")) {
                    b2 = 2;
                }
                break;
            case 49679473:
                if (str.equals("46003")) {
                    b2 = 3;
                }
                break;
            case 49679474:
                if (str.equals("46004")) {
                    b2 = 4;
                }
                break;
            case 49679475:
                if (str.equals("46005")) {
                    b2 = 5;
                }
                break;
            case 49679476:
                if (str.equals("46006")) {
                    b2 = 6;
                }
                break;
            case 49679477:
                if (str.equals("46007")) {
                    b2 = 7;
                }
                break;
            case 49679478:
                if (str.equals("46008")) {
                    b2 = 8;
                }
                break;
            case 49679479:
                if (str.equals("46009")) {
                    b2 = 9;
                }
                break;
            case 49679501:
                if (str.equals("46010")) {
                    b2 = 10;
                }
                break;
            case 49679502:
                if (str.equals("46011")) {
                    b2 = com.igexin.push.core.b.n.l;
                }
                break;
            case 49679503:
                if (str.equals("46012")) {
                    b2 = 12;
                }
                break;
            case 49679504:
                if (str.equals("46013")) {
                    b2 = 13;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 2:
            case 4:
            case 7:
            case 8:
            case 13:
                return "CMCC";
            case 1:
            case 6:
            case 9:
            case 10:
                return "CUCC";
            case 3:
            case 5:
            case 11:
            case 12:
                return "CTCC";
            default:
                return "Unknown_Operator";
        }
    }

    private static int c(android.content.Context context, int i) {
        if (context == null || i == -1) {
            return -1;
        }
        try {
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.telephony.TelephonyManager").getDeclaredMethod("getNetworkType", java.lang.Integer.TYPE);
            declaredMethod.setAccessible(true);
            return ((java.lang.Integer) declaredMethod.invoke(telephonyManager, java.lang.Integer.valueOf(i))).intValue();
        } catch (java.lang.Throwable th) {
            com.chuanglan.shanyan_sdk.Q.d("CheckAuthEnableShanYanLogger", "get NetType BySubId Exception_e", th);
            return -1;
        }
    }

    public static java.lang.Integer a(android.content.Context context, int i) {
        java.lang.reflect.Method method;
        try {
            int iE = com.chuanglan.shanyan_sdk.C0065v.g().e(context);
            boolean zB = b(context, "defaultdata_sub");
            com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "slot index", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(iE), java.lang.Boolean.valueOf(zB));
            if (iE > 0 && (i == 0 || zB)) {
                java.lang.Object systemService = context.getSystemService("subscription");
                boolean zB2 = b(context);
                if (zB2) {
                    try {
                        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "get default data SubscriptionInfo by system");
                        java.lang.Object objInvoke = systemService.getClass().getMethod("getDefaultDataSubscriptionInfo", null).invoke(systemService, null);
                        if (objInvoke != null) {
                            g = ((java.lang.Integer) objInvoke.getClass().getMethod("getSimSlotIndex", null).invoke(objInvoke, null)).intValue();
                        }
                    } catch (java.lang.Throwable th) {
                        com.chuanglan.shanyan_sdk.Q.d("CheckAuthEnableShanYanLogger", ">= 22 slot index  Exception_e", th);
                    }
                }
                if (g < 0 && zB2 && (method = systemService.getClass().getMethod("getDefaultDataPhoneId", null)) != null) {
                    g = ((java.lang.Integer) method.invoke(systemService, null)).intValue();
                }
            }
        } catch (java.lang.Throwable th2) {
            com.chuanglan.shanyan_sdk.Q.d("CheckAuthEnableShanYanLogger", "slot index Exception_e", th2);
        }
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "default data slot index", java.lang.Integer.valueOf(g));
        return java.lang.Integer.valueOf(g);
    }

    private static int d(android.content.Context context, int i) {
        int iIntValue;
        if (context != null) {
            try {
                android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
                java.lang.reflect.Method declaredMethod = android.telephony.TelephonyManager.class.getDeclaredMethod("getSimState", java.lang.Integer.TYPE);
                declaredMethod.setAccessible(true);
                java.lang.Integer num = (java.lang.Integer) declaredMethod.invoke(telephonyManager, java.lang.Integer.valueOf(i));
                iIntValue = num.intValue();
                com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "data sim card simState invoke", num);
            } catch (java.lang.Throwable th) {
                com.chuanglan.shanyan_sdk.Q.d("CheckAuthEnableShanYanLogger", "get sim card  Exception_e", th);
                return 1;
            }
        } else {
            iIntValue = 1;
        }
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "sim card id", java.lang.Integer.valueOf(i), "simState", java.lang.Integer.valueOf(iIntValue));
        return iIntValue;
    }

    private static int b(int i) {
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "getNetwork1 networkType", java.lang.Integer.valueOf(i));
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
            case 18:
            case 19:
                return 4;
            case 20:
                return 5;
            default:
                return 0;
        }
    }

    private static int b(android.content.Context context, int i) {
        if (i < 0) {
            return 0;
        }
        try {
            java.lang.String strA = a(context, "gsm.network.type");
            java.lang.String strA2 = a(context, "gsm.network.type.2");
            if (!com.chuanglan.shanyan_sdk.AbstractC0049f.a(strA2)) {
                strA = strA + com.igexin.push.core.b.an + strA2;
            }
            java.lang.String str = null;
            java.lang.String[] strArrSplit = com.chuanglan.shanyan_sdk.AbstractC0049f.a(strA) ? null : strA.split(com.igexin.push.core.b.an);
            if (strArrSplit != null && strArrSplit.length > i) {
                str = strArrSplit[i];
            }
            com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "getNetworkType GSMNetwork", "network", str);
            return a(str);
        } catch (java.lang.Throwable th) {
            com.chuanglan.shanyan_sdk.Q.d("CheckAuthEnableShanYanLogger", "getGSMNetwork Exception_e", th);
            return 0;
        }
    }

    private static int a() {
        int iIntValue = -1;
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.telephony.SubscriptionManager").getDeclaredMethod("getDefaultDataSubscriptionId", null);
            declaredMethod.setAccessible(true);
            iIntValue = ((java.lang.Integer) declaredMethod.invoke(null, null)).intValue();
            com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "default data sub scriptionId", java.lang.Integer.valueOf(iIntValue));
            return iIntValue;
        } catch (java.lang.Throwable th) {
            com.chuanglan.shanyan_sdk.Q.d("CheckAuthEnableShanYanLogger", "default data sub scriptionId Exception_e", th);
            return iIntValue;
        }
    }

    private static int a(java.lang.String str) {
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(str)) {
            return 0;
        }
        java.lang.String lowerCase = str.toLowerCase();
        if (lowerCase.contains("lte") || lowerCase.contains("iwlan")) {
            return 4;
        }
        if (lowerCase.contains("nr")) {
            return 5;
        }
        if (lowerCase.contains("unknown")) {
            return 0;
        }
        if (lowerCase.contains("gprs") || lowerCase.contains("edge") || lowerCase.contains("cdma") || lowerCase.contains("1xrtt") || lowerCase.contains("iden")) {
            return 2;
        }
        return (lowerCase.contains("umts") || lowerCase.contains("evdo") || lowerCase.contains("hsdpa") || lowerCase.contains("hsupa") || lowerCase.contains("hspa") || lowerCase.contains("ehrpd") || lowerCase.contains("scdma")) ? 3 : 0;
    }

    private static java.lang.String a(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        if (context != null) {
            try {
                java.lang.Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                str2 = (java.lang.String) clsLoadClass.getMethod("get", java.lang.String.class).invoke(clsLoadClass, new java.lang.String(str));
            } catch (java.lang.Throwable th) {
                com.chuanglan.shanyan_sdk.Q.d("CheckAuthEnableShanYanLogger", "get GMS Type Exception_e", th);
                str2 = "";
            }
        } else {
            str2 = "";
        }
        com.chuanglan.shanyan_sdk.Q.a("CheckAuthEnableShanYanLogger", "get gms  type", str, "gmsType", str2);
        return str2;
    }
}
