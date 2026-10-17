package com.igexin.push.g;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class d {
    static long a = 0;
    static java.util.HashMap<java.lang.String, java.lang.Object> b = new java.util.HashMap<>();
    private static final java.lang.String c = "ro.miui.ui.version.name";
    private static final java.lang.String d = "ro.miui.ui.version.code";
    private static final java.lang.String e = "GT";
    private static volatile java.lang.Boolean f;
    private static java.lang.String g;
    private static android.content.pm.PackageInfo h;

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01e8, code lost:
    
        if (r3.getPackage() != null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01ea, code lost:
    
        r3.setSelector(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01ee, code lost:
    
        r3 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01ef, code lost:
    
        if (r5 == null) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01f7, code lost:
    
        if (r5.startsWith("intent:") == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f9, code lost:
    
        r5 = r5.substring(7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01fe, code lost:
    
        if (r10 == null) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0200, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append(r10);
        r0.append(':');
        r0.append(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0210, code lost:
    
        r5 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x021a, code lost:
    
        if (r5.startsWith("android-app:") == false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0224, code lost:
    
        if (r5.charAt(12) != '/') goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x022c, code lost:
    
        if (r5.charAt(13) != '/') goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x022e, code lost:
    
        r6 = r5.indexOf(47, 14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0236, code lost:
    
        if (r6 >= 0) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0238, code lost:
    
        r3.setPackage(r5.substring(14));
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x023f, code lost:
    
        if (r11 != false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0241, code lost:
    
        r3.setAction("android.intent.action.MAIN");
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0245, code lost:
    
        r3.setPackage(r5.substring(14, r6));
        r0 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0252, code lost:
    
        if (r0 >= r5.length()) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0254, code lost:
    
        r8 = r5.indexOf(47, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0258, code lost:
    
        if (r8 < 0) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x025a, code lost:
    
        r10 = r5.substring(r0, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0262, code lost:
    
        if (r8 >= r5.length()) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0264, code lost:
    
        r0 = r8 + 1;
        r6 = r5.indexOf(47, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x026a, code lost:
    
        if (r6 < 0) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x026c, code lost:
    
        r0 = r5.substring(r0, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0271, code lost:
    
        r6 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0273, code lost:
    
        r10 = r5.substring(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0277, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0278, code lost:
    
        if (r10 != null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x027a, code lost:
    
        if (r11 != false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x027d, code lost:
    
        if (r0 != null) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x027f, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append(r10);
        r0.append(":");
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x028b, code lost:
    
        r5 = r10 + "://" + r0 + r5.substring(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02a7, code lost:
    
        r5 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02ac, code lost:
    
        if (r5.length() <= 0) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02ae, code lost:
    
        r3.setData(android.net.Uri.parse(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02b6, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02c0, code lost:
    
        throw new java.net.URISyntaxException(r17, r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02c1, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01df, code lost:
    
        r8.putExtras(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01e2, code lost:
    
        if (r9 == false) goto L102;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.Intent a(java.lang.String r17) throws java.net.URISyntaxException {
        /*
            Method dump skipped, instruction units count: 715
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.g.d.a(java.lang.String):android.content.Intent");
    }

    public static android.util.Pair<android.content.pm.ServiceInfo, java.lang.Class> a(android.content.Context context, java.lang.Class cls) {
        try {
            if (h == null) {
                h = context.getPackageManager().getPackageInfo(context.getPackageName(), android.os.Build.VERSION.SDK_INT >= 24 ? 516 : 4);
            }
            android.content.pm.ServiceInfo[] serviceInfoArr = h.services;
            if (serviceInfoArr != null && serviceInfoArr.length > 0) {
                int length = serviceInfoArr.length;
                for (int i = 0; i < length; i++) {
                    android.content.pm.ServiceInfo serviceInfo = serviceInfoArr[i];
                    try {
                        java.lang.Class<?> cls2 = java.lang.Class.forName(serviceInfo.name);
                        if (cls2 != cls && cls.isAssignableFrom(cls2)) {
                            com.igexin.c.a.c.a.b("GT", cls.getSimpleName() + " child is " + cls2.getSimpleName());
                            return android.util.Pair.create(serviceInfo, cls2);
                        }
                    } catch (java.lang.Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
            com.igexin.c.a.c.a.c.a().a(" findGtImplClassInManifest error = " + th2.toString());
        }
        return android.util.Pair.create(null, null);
    }

    private static java.lang.String a(android.content.Context context) {
        try {
            android.content.Intent launchIntentForPackage = context.getApplicationContext().getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            return (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) ? "" : launchIntentForPackage.getComponent().getClassName();
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static java.lang.String a(android.content.pm.ApplicationInfo applicationInfo) {
        try {
            java.lang.String string = applicationInfo.metaData.getString(com.igexin.push.core.b.a);
            if (android.text.TextUtils.isEmpty(string)) {
                string = applicationInfo.packageName;
            }
            java.lang.Class<?> cls = java.lang.Class.forName(string + ".BuildConfig");
            return (java.lang.String) cls.getField("GETUI_APPID").get(cls);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a("get cf error|" + e2.toString(), new java.lang.Object[0]);
            return "";
        }
    }

    public static java.util.HashMap<java.lang.String, java.lang.Object> a() {
        boolean z;
        try {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (jCurrentTimeMillis - a < 2000) {
                return b;
            }
            b.put("isPause", java.lang.Boolean.FALSE);
            b.put("isTranslucent", java.lang.Boolean.FALSE);
            a = jCurrentTimeMillis;
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ActivityThread");
            android.app.Activity activity = null;
            java.lang.Object objInvoke = cls.getMethod("currentActivityThread", null).invoke(null, null);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            android.util.ArrayMap arrayMap = (android.util.ArrayMap) declaredField.get(objInvoke);
            if (arrayMap.size() <= 0) {
                return b;
            }
            java.util.Iterator it = arrayMap.values().iterator();
            java.lang.Boolean boolValueOf = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                java.lang.Object next = it.next();
                java.lang.Class<?> cls2 = next.getClass();
                java.lang.reflect.Field declaredField2 = cls2.getDeclaredField("activity");
                declaredField2.setAccessible(true);
                android.app.Activity activity2 = (android.app.Activity) declaredField2.get(next);
                java.lang.reflect.Field declaredField3 = cls2.getDeclaredField("paused");
                declaredField3.setAccessible(true);
                boolean z2 = declaredField3.getBoolean(next);
                if (boolValueOf == null) {
                    z = z2;
                } else if (boolValueOf.booleanValue() && z2) {
                    z = true;
                }
                boolValueOf = java.lang.Boolean.valueOf(z);
                if (!z2) {
                    activity = activity2;
                }
            }
            z = activity != null ? activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowIsTranslucent}).getBoolean(0, false) : false;
            b.put("isPause", java.lang.Boolean.valueOf(java.lang.Boolean.TRUE.equals(boolValueOf)));
            b.put("isTranslucent", java.lang.Boolean.valueOf(z));
            return b;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return b;
        }
    }

    public static synchronized boolean a(int i, boolean z) {
        try {
            if (com.igexin.push.core.e.l == null) {
                return false;
            }
            java.lang.String str = com.igexin.push.core.e.G;
            if (com.igexin.assist.util.AssistUtils.BRAND_HW.equalsIgnoreCase(str) || com.igexin.assist.util.AssistUtils.BRAND_HON.equalsIgnoreCase(str)) {
                int iIntValue = ((java.lang.Integer) com.igexin.push.g.q.b(com.igexin.push.core.e.l, com.igexin.push.g.q.h, 0)).intValue();
                if (!z) {
                    i += iIntValue;
                }
                com.igexin.push.g.q.a(com.igexin.push.core.e.l, com.igexin.push.g.q.h, java.lang.Integer.valueOf(i));
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("package", com.igexin.push.core.e.g);
                bundle.putString("class", a(com.igexin.push.core.e.l));
                bundle.putInt("badgenumber", i);
                android.net.Uri uri = android.net.Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                android.net.Uri uri2 = android.net.Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
                if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.l.getContentResolver().getType(uri))) {
                    uri = uri2;
                }
                com.igexin.push.core.e.l.getContentResolver().call(uri, "change_badge", (java.lang.String) null, bundle);
                return true;
            }
        } finally {
        }
        return false;
    }

    public static boolean a(java.lang.String... strArr) {
        for (int i = 0; i < 5; i++) {
            if (android.text.TextUtils.isEmpty(strArr[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean b() {
        try {
            if (f != null) {
                return f.booleanValue();
            }
            boolean z = (!"Xiaomi".equalsIgnoreCase(com.igexin.push.core.e.G) && android.text.TextUtils.isEmpty(c("ro.miui.ui.version.name")) && android.text.TextUtils.isEmpty(c("ro.miui.ui.version.code"))) ? false : true;
            java.lang.Boolean boolValueOf = java.lang.Boolean.valueOf(z);
            f = boolValueOf;
            boolValueOf.getClass();
            return z;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean b(int i, boolean z) {
        try {
            if (com.igexin.push.core.e.l == null || !com.igexin.assist.util.AssistUtils.BRAND_VIVO.equalsIgnoreCase(com.igexin.push.core.e.G)) {
                return false;
            }
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", com.igexin.push.core.e.l.getPackageName());
            android.content.Intent launchIntentForPackage = com.igexin.push.core.e.l.getPackageManager().getLaunchIntentForPackage(com.igexin.push.core.e.l.getPackageName());
            if (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) {
                return false;
            }
            int iIntValue = ((java.lang.Integer) com.igexin.push.g.q.b(com.igexin.push.core.e.l, com.igexin.push.g.q.i, 0)).intValue();
            if (!z) {
                i += iIntValue;
            }
            com.igexin.push.g.q.a(com.igexin.push.core.e.l, com.igexin.push.g.q.i, java.lang.Integer.valueOf(i));
            intent.putExtra("className", launchIntentForPackage.getComponent().getClassName());
            intent.putExtra("notificationNum", i);
            intent.addFlags(16777216);
            com.igexin.push.core.e.l.sendBroadcast(intent);
            return true;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean b(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(g)) {
                g = c();
                com.igexin.c.a.c.a.b("GT", " gtcVersion = " + g);
            }
            java.lang.String[] strArrSplit = g.split("\\.");
            java.lang.String[] strArrSplit2 = str.split("\\.");
            if (strArrSplit.length >= 4 && strArrSplit2.length >= 4) {
                for (int i = 0; i < 3; i++) {
                    int i2 = java.lang.Integer.parseInt(strArrSplit2[i]);
                    int i3 = java.lang.Integer.parseInt(strArrSplit[i]);
                    if (i3 != i2) {
                        return i3 < i2;
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return false;
    }

    private static java.lang.String c() {
        try {
            java.lang.reflect.Field declaredField = java.lang.Class.forName("com.getui.gtc.BuildConfig").getDeclaredField("VERSION_NAME");
            declaredField.setAccessible(true);
            return ((java.lang.String) declaredField.get(null)).substring(4);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    private static java.lang.String c(java.lang.String str) throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop ".concat(java.lang.String.valueOf(str))).getInputStream()), 1024);
            try {
                java.lang.String line = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (java.io.IOException e2) {
                    com.igexin.c.a.c.a.a(e2);
                }
                return line;
            } catch (java.lang.Exception unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException e3) {
                        com.igexin.c.a.c.a.a(e3);
                    }
                }
                return null;
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException e4) {
                        com.igexin.c.a.c.a.a(e4);
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused2) {
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static boolean c(int i, boolean z) {
        try {
            if (com.igexin.push.core.e.l == null || !com.igexin.assist.util.AssistUtils.BRAND_OPPO.equalsIgnoreCase(com.igexin.push.core.e.G)) {
                return false;
            }
            int iIntValue = ((java.lang.Integer) com.igexin.push.g.q.b(com.igexin.push.core.e.l, com.igexin.push.g.q.j, 0)).intValue();
            if (!z) {
                i += iIntValue;
            }
            com.igexin.push.g.q.a(com.igexin.push.core.e.l, com.igexin.push.g.q.j, java.lang.Integer.valueOf(i));
            android.content.Intent intent = new android.content.Intent("com.oppo.unsettledevent");
            intent.putExtra("packageName", com.igexin.push.core.e.l.getPackageName());
            intent.putExtra("number", i);
            intent.putExtra("upgradeNumber", i);
            java.util.List<android.content.pm.ResolveInfo> listQueryBroadcastReceivers = com.igexin.push.core.e.l.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
                com.igexin.push.core.e.l.sendBroadcast(intent);
                return true;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("app_badge_count", i);
            com.igexin.push.core.e.l.getContentResolver().call(android.net.Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (java.lang.String) null, bundle);
            return true;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return false;
        }
    }

    private static android.content.Intent d(java.lang.String str) throws java.net.URISyntaxException {
        boolean z;
        int i;
        java.lang.String strSubstring;
        int iLastIndexOf = str.lastIndexOf(35);
        if (iLastIndexOf < 0) {
            return new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
        }
        int i2 = iLastIndexOf + 1;
        boolean z2 = true;
        if (str.regionMatches(i2, "action(", 0, 7)) {
            int i3 = iLastIndexOf + 8;
            int iIndexOf = str.indexOf(41, i3);
            strSubstring = str.substring(i3, iIndexOf);
            i = iIndexOf + 1;
            z = true;
        } else {
            z = false;
            i = i2;
            strSubstring = null;
        }
        android.content.Intent intent = new android.content.Intent(strSubstring);
        int i4 = 33;
        if (str.regionMatches(i, "categories(", 0, 11)) {
            int i5 = i + 11;
            int iIndexOf2 = str.indexOf(41, i5);
            while (i5 < iIndexOf2) {
                int iIndexOf3 = str.indexOf(33, i5);
                if (iIndexOf3 < 0 || iIndexOf3 > iIndexOf2) {
                    iIndexOf3 = iIndexOf2;
                }
                if (i5 < iIndexOf3) {
                    intent.addCategory(str.substring(i5, iIndexOf3));
                }
                i5 = iIndexOf3 + 1;
            }
            i = iIndexOf2 + 1;
            z = true;
        }
        if (str.regionMatches(i, "type(", 0, 5)) {
            int i6 = i + 5;
            int iIndexOf4 = str.indexOf(41, i6);
            intent.setType(str.substring(i6, iIndexOf4));
            i = iIndexOf4 + 1;
            z = true;
        }
        if (str.regionMatches(i, "launchFlags(", 0, 12)) {
            int i7 = i + 12;
            int iIndexOf5 = str.indexOf(41, i7);
            intent.setFlags(java.lang.Integer.decode(str.substring(i7, iIndexOf5)).intValue());
            intent.setFlags((~(67 | 128)) & intent.getFlags());
            i = iIndexOf5 + 1;
            z = true;
        }
        if (str.regionMatches(i, "component(", 0, 10)) {
            int i8 = i + 10;
            int iIndexOf6 = str.indexOf(41, i8);
            int iIndexOf7 = str.indexOf(33, i8);
            if (iIndexOf7 >= 0 && iIndexOf7 < iIndexOf6) {
                intent.setComponent(new android.content.ComponentName(str.substring(i8, iIndexOf7), str.substring(iIndexOf7 + 1, iIndexOf6)));
            }
            i = iIndexOf6 + 1;
            z = true;
        }
        if (str.regionMatches(i, "extras(", 0, 7)) {
            int i9 = i + 7;
            int iIndexOf8 = str.indexOf(41, i9);
            int i10 = -1;
            if (iIndexOf8 == -1) {
                throw new java.net.URISyntaxException(str, "EXTRA missing trailing ')'", i9);
            }
            if (intent.getExtras() == null) {
                intent.putExtras(new android.os.Bundle());
            }
            android.os.Bundle extras = intent.getExtras();
            while (i9 < iIndexOf8) {
                int iIndexOf9 = str.indexOf(61, i9);
                int i11 = i9 + 1;
                if (iIndexOf9 <= i11 || i9 >= iIndexOf8) {
                    throw new java.net.URISyntaxException(str, "EXTRA missing '='", i9);
                }
                char cCharAt = str.charAt(i9);
                java.lang.String strSubstring2 = str.substring(i11, iIndexOf9);
                int i12 = iIndexOf9 + 1;
                int iIndexOf10 = str.indexOf(i4, i12);
                if (iIndexOf10 == i10 || iIndexOf10 >= iIndexOf8) {
                    iIndexOf10 = iIndexOf8;
                }
                if (i12 >= iIndexOf10) {
                    throw new java.net.URISyntaxException(str, "EXTRA missing '!'", i12);
                }
                java.lang.String strSubstring3 = str.substring(i12, iIndexOf10);
                if (cCharAt == 'B') {
                    extras.putBoolean(strSubstring2, java.lang.Boolean.parseBoolean(strSubstring3));
                } else if (cCharAt == 'S') {
                    extras.putString(strSubstring2, android.net.Uri.decode(strSubstring3));
                } else if (cCharAt == 'f') {
                    extras.putFloat(strSubstring2, java.lang.Float.parseFloat(strSubstring3));
                } else if (cCharAt == 'i') {
                    extras.putInt(strSubstring2, java.lang.Integer.parseInt(strSubstring3));
                } else if (cCharAt == 'l') {
                    extras.putLong(strSubstring2, java.lang.Long.parseLong(strSubstring3));
                } else {
                    if (cCharAt != 's') {
                        switch (cCharAt) {
                            case 'b':
                                extras.putByte(strSubstring2, java.lang.Byte.parseByte(strSubstring3));
                                break;
                            case 'c':
                                extras.putChar(strSubstring2, android.net.Uri.decode(strSubstring3).charAt(0));
                                break;
                            case 'd':
                                try {
                                    extras.putDouble(strSubstring2, java.lang.Double.parseDouble(strSubstring3));
                                } catch (java.lang.NumberFormatException unused) {
                                    throw new java.net.URISyntaxException(str, "EXTRA value can't be parsed", iIndexOf10);
                                }
                                break;
                            default:
                                throw new java.net.URISyntaxException(str, "EXTRA has unknown type", iIndexOf10);
                        }
                        throw new java.net.URISyntaxException(str, "EXTRA value can't be parsed", iIndexOf10);
                    }
                    extras.putShort(strSubstring2, java.lang.Short.parseShort(strSubstring3));
                }
                char cCharAt2 = str.charAt(iIndexOf10);
                if (cCharAt2 == ')') {
                    intent.putExtras(extras);
                } else {
                    if (cCharAt2 != '!') {
                        throw new java.net.URISyntaxException(str, "EXTRA missing '!'", iIndexOf10);
                    }
                    i9 = iIndexOf10 + 1;
                    i4 = 33;
                    i10 = -1;
                }
            }
            intent.putExtras(extras);
        } else {
            z2 = z;
        }
        intent.setData(z2 ? android.net.Uri.parse(str.substring(0, iLastIndexOf)) : android.net.Uri.parse(str));
        if (intent.getAction() != null) {
            return intent;
        }
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }
}
