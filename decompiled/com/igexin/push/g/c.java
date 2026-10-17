package com.igexin.push.g;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class c {
    private static final java.lang.String a = "CheckUtils";
    private static java.lang.Integer b = null;
    private static final java.lang.String c = "checkOpNoThrow";
    private static final java.lang.String d = "OP_POST_NOTIFICATION";
    private static final android.content.ServiceConnection e = new android.content.ServiceConnection() { // from class: com.igexin.push.g.c.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            android.content.Context context = com.igexin.push.core.ServiceManager.b;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(android.content.ComponentName componentName) {
            android.content.Context context = com.igexin.push.core.ServiceManager.b;
        }
    };

    public static void a(android.content.Context context, android.content.Intent intent) {
        try {
            if (android.os.Build.VERSION.SDK_INT < 26 || !f()) {
                context.getApplicationContext().startService(intent);
            } else {
                c(intent, context);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("CheckUtils|startPService err：" + th.toString(), new java.lang.Object[0]);
            if (th instanceof java.lang.IllegalStateException) {
                c(intent, context);
            }
        }
    }

    private static void a(java.util.Map<java.lang.String, com.igexin.push.core.b.f> map, java.lang.String str) {
        com.igexin.push.core.b.f fVar = map.get(str);
        map.remove(str);
        for (java.lang.String str2 : fVar.b) {
            com.igexin.push.core.b.f fVar2 = map.get(str2);
            if (fVar2 != null) {
                fVar2.c--;
                if (fVar2.c == 0) {
                    a(map, str2);
                }
            }
        }
    }

    public static boolean a() {
        return java.lang.System.currentTimeMillis() > com.igexin.push.config.d.d;
    }

    public static boolean a(long j) {
        if (com.igexin.push.config.d.c == 0) {
            return false;
        }
        java.util.Date date = new java.util.Date(j);
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(11);
        int i2 = com.igexin.push.config.d.b + com.igexin.push.config.d.c;
        if (i2 >= 24) {
            i2 -= 24;
        }
        if (com.igexin.push.config.d.b < i2) {
            if (i >= com.igexin.push.config.d.b && i < i2) {
                return true;
            }
        } else if (com.igexin.push.config.d.b > i2) {
            if (i >= 0 && i < i2) {
                return true;
            }
            if (i >= com.igexin.push.config.d.b && i < 24) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(android.content.Context context) {
        if (b == null) {
            b = (context.getApplicationInfo().flags & 2) == 0 ? -1 : 1;
        }
        return b.intValue() > 0;
    }

    public static boolean a(android.content.Intent intent, android.content.Context context) {
        if (context == null) {
            return false;
        }
        try {
            android.content.pm.ServiceInfo[] serviceInfoArr = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 4).services;
            if (serviceInfoArr != null && serviceInfoArr.length != 0) {
                for (android.content.pm.ServiceInfo serviceInfo : serviceInfoArr) {
                    if (intent.getComponent() != null && serviceInfo.name.equals(intent.getComponent().getClassName())) {
                        return true;
                    }
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean a(java.lang.String str) {
        try {
            return com.igexin.push.core.e.l.getPackageManager().getLaunchIntentForPackage(str) != null;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return false;
        }
    }

    public static boolean a(org.json.JSONObject jSONObject) {
        java.lang.String string;
        try {
            java.util.HashMap map = new java.util.HashMap();
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject jSONObject2 = (org.json.JSONObject) jSONArray.get(i);
                com.igexin.push.core.b.f fVar = new com.igexin.push.core.b.f();
                if (jSONObject2.has("actionid")) {
                    if (map.containsKey(fVar.a)) {
                        return true;
                    }
                    fVar.a = jSONObject2.getString("actionid");
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    if (jSONObject2.has("type")) {
                        java.lang.String string2 = jSONObject2.getString("type");
                        if (com.igexin.push.core.b.q.equals(string2)) {
                            if (jSONObject2.has("noinstall_action")) {
                                arrayList.add(jSONObject2.getString("noinstall_action"));
                            }
                            if (jSONObject2.has("do")) {
                                string = jSONObject2.getString("do");
                                arrayList.add(string);
                            }
                            fVar.b = arrayList;
                            map.put(fVar.a, fVar);
                        } else if (com.igexin.push.core.b.v.equals(string2)) {
                            if (jSONObject2.has("do_installed")) {
                                arrayList.add(jSONObject2.getString("do_installed"));
                            }
                            if (jSONObject2.has("do_uninstalled")) {
                                string = jSONObject2.getString("do_uninstalled");
                                arrayList.add(string);
                            }
                            fVar.b = arrayList;
                            map.put(fVar.a, fVar);
                        } else {
                            if (!com.igexin.push.core.b.m.equals(string2) && jSONObject2.has("do")) {
                                string = jSONObject2.getString("do");
                                arrayList.add(string);
                            }
                            fVar.b = arrayList;
                            map.put(fVar.a, fVar);
                        }
                    }
                }
            }
            java.util.ArrayList arrayList2 = new java.util.ArrayList(map.values());
            java.util.Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                java.util.List<java.lang.String> list = ((com.igexin.push.core.b.f) ((java.util.Map.Entry) it.next()).getValue()).b;
                if (list != null) {
                    java.util.Iterator<java.lang.String> it2 = list.iterator();
                    while (it2.hasNext()) {
                        com.igexin.push.core.b.f fVar2 = (com.igexin.push.core.b.f) map.get(it2.next());
                        if (fVar2 != null) {
                            fVar2.c++;
                            if (arrayList2.contains(fVar2)) {
                                arrayList2.remove(fVar2);
                            }
                        }
                    }
                }
            }
            java.util.Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                a(map, ((com.igexin.push.core.b.f) it3.next()).a);
            }
            if (map.size() > 0) {
                com.igexin.c.a.c.a.a("CheckUtils|action_chains have loop nodeMap not empty", new java.lang.Object[0]);
                return true;
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            com.igexin.c.a.c.a.a("CheckUtils|isHaveLoop exception :" + th.toString(), new java.lang.Object[0]);
        }
        return false;
    }

    public static boolean b() {
        android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) com.igexin.push.core.e.l.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static boolean b(android.content.Context context) {
        try {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                return ((java.lang.Boolean) android.app.NotificationManager.class.getDeclaredMethod("areNotificationsEnabled", null).invoke((android.app.NotificationManager) context.getSystemService(com.igexin.push.core.b.n), null)).booleanValue();
            }
            android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) context.getSystemService("appops");
            android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
            java.lang.String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            java.lang.Class<?> cls = java.lang.Class.forName(android.app.AppOpsManager.class.getName());
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            java.lang.reflect.Method method = cls.getMethod(c, cls2, cls2, java.lang.String.class);
            java.lang.Integer num = (java.lang.Integer) cls.getDeclaredField(d).get(java.lang.Integer.class);
            num.intValue();
            return ((java.lang.Integer) method.invoke(appOpsManager, num, java.lang.Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return true;
        }
    }

    public static boolean b(android.content.Intent intent, android.content.Context context) {
        if (intent != null && context != null) {
            try {
                android.content.pm.ActivityInfo[] activityInfoArr = context.getApplicationContext().getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 1).activities;
                if (activityInfoArr != null && activityInfoArr.length != 0) {
                    for (android.content.pm.ActivityInfo activityInfo : activityInfoArr) {
                        if (intent.getComponent() != null && activityInfo.name.equals(intent.getComponent().getClassName())) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
        return false;
    }

    public static boolean b(java.lang.String str) {
        try {
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        if (!android.text.TextUtils.isEmpty(com.igexin.push.config.d.C) && !com.igexin.push.a.i.equals(com.igexin.push.config.d.C)) {
            java.util.List listAsList = java.util.Arrays.asList(com.igexin.push.config.d.C.split(com.igexin.push.core.b.an));
            if (listAsList.isEmpty()) {
                return false;
            }
            java.util.Iterator it = listAsList.iterator();
            while (it.hasNext()) {
                if (str.startsWith((java.lang.String) it.next())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static void c() {
        android.net.NetworkInfo.State state = ((android.net.ConnectivityManager) com.igexin.push.core.e.l.getSystemService("connectivity")).getNetworkInfo(1).getState();
        if (state == android.net.NetworkInfo.State.CONNECTED || state == android.net.NetworkInfo.State.CONNECTING) {
            com.igexin.push.core.e.x = 1;
        } else {
            com.igexin.push.core.e.x = 0;
        }
    }

    public static void c(android.content.Context context) throws com.igexin.sdk.GetuiPushException {
        if (context == null) {
            throw new com.igexin.sdk.GetuiPushException("传入的context为空");
        }
        android.content.Context applicationContext = context.getApplicationContext();
        if (a(applicationContext)) {
            android.content.pm.ServiceInfo serviceInfo = (android.content.pm.ServiceInfo) com.igexin.push.g.d.a(applicationContext, com.igexin.sdk.PushService.class).first;
            if (serviceInfo == null) {
                throw new com.igexin.sdk.GetuiPushException("未找到继承 com.igexin.sdk.PushService 的子类");
            }
            java.lang.String str = serviceInfo.processName;
            if (!android.text.TextUtils.isEmpty(serviceInfo.permission)) {
                throw new com.igexin.sdk.GetuiPushException("自定义推送服务(Service)不能配置android:permission");
            }
            if (((android.content.pm.ServiceInfo) com.igexin.push.g.d.a(applicationContext, com.igexin.sdk.GTIntentService.class).first) == null) {
                throw new com.igexin.sdk.GetuiPushException("未找到继承 com.igexin.sdk.GTIntentService 的子类");
            }
            try {
                java.lang.Class.forName("com.getui.gtc.base.log.Logger");
                try {
                    android.content.pm.PackageInfo packageInfo = applicationContext.getApplicationContext().getPackageManager().getPackageInfo(applicationContext.getApplicationContext().getPackageName(), 4229);
                    if (packageInfo == null) {
                        return;
                    }
                    android.content.pm.ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    if (applicationInfo == null) {
                        throw new com.igexin.sdk.GetuiPushException("ApplicationInfo 应用异常");
                    }
                    if (applicationInfo.metaData != null) {
                        java.lang.String strA = com.igexin.push.g.d.a(applicationInfo);
                        if (android.text.TextUtils.isEmpty(strA)) {
                            strA = applicationInfo.metaData.getString(com.igexin.push.core.b.b);
                        }
                        if (android.text.TextUtils.isEmpty(strA) && android.text.TextUtils.isEmpty(applicationInfo.metaData.getString("GETUI_APPID"))) {
                            throw new com.igexin.sdk.GetuiPushException("未配置个推APPID");
                        }
                    } else if (android.text.TextUtils.isEmpty(com.igexin.push.g.d.a(applicationInfo))) {
                        throw new com.igexin.sdk.GetuiPushException("未配置META-DATA");
                    }
                    android.content.pm.ActivityInfo[] activityInfoArr = packageInfo.activities;
                    if (packageInfo != null) {
                        java.lang.String[] strArr = packageInfo.requestedPermissions;
                        if (strArr == null || strArr.length == 0) {
                            throw new com.igexin.sdk.GetuiPushException("Manifest中无权限配置");
                        }
                        java.util.List listAsList = java.util.Arrays.asList(strArr);
                        if (!listAsList.contains("android.permission.INTERNET")) {
                            throw new com.igexin.sdk.GetuiPushException("未在Manifest中配置所需权限：android.permission.INTERNET");
                        }
                        if (!listAsList.contains(com.up366.mobile.common.utils.permissions.Permission.READ_PHONE_STATE)) {
                            throw new com.igexin.sdk.GetuiPushException("未在Manifest中配置所需权限：android.permission.READ_PHONE_STATE");
                        }
                        if (!listAsList.contains("android.permission.ACCESS_NETWORK_STATE")) {
                            throw new com.igexin.sdk.GetuiPushException("未在Manifest中配置所需权限：android.permission.ACCESS_NETWORK_STATE");
                        }
                        if (!listAsList.contains("android.permission.ACCESS_WIFI_STATE")) {
                            throw new com.igexin.sdk.GetuiPushException("未在Manifest中配置所需权限：android.permission.ACCESS_WIFI_STATE");
                        }
                        if (!listAsList.contains("android.permission.VIBRATE")) {
                            throw new com.igexin.sdk.GetuiPushException("未在Manifest中配置所需权限：android.permission.VIBRATE");
                        }
                    }
                } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                }
            } catch (java.lang.ClassNotFoundException unused2) {
                throw new com.igexin.sdk.GetuiPushException("未配置 com.getui:gtc:version 依赖");
            }
        }
    }

    private static void c(android.content.Intent intent, android.content.Context context) {
        com.igexin.c.a.c.a.a("CheckUtils|startPService by bind", new java.lang.Object[0]);
        intent.setType("PB-" + java.lang.System.nanoTime());
        context.getApplicationContext().bindService(intent, e, 1);
    }

    public static boolean c(java.lang.String str) {
        try {
            if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(com.igexin.push.config.d.F) && !com.igexin.push.a.i.equals(com.igexin.push.config.d.F)) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                arrayList.addAll(java.util.Arrays.asList(com.igexin.push.config.d.F.split(com.igexin.push.core.b.an)));
                if (arrayList.isEmpty()) {
                    return false;
                }
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (str.contains((java.lang.String) it.next())) {
                        return true;
                    }
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static void d() {
        com.igexin.push.core.e.y = ((android.os.PowerManager) com.igexin.push.core.e.l.getSystemService("power")).isScreenOn() ? 1 : 0;
    }

    private static boolean d(android.content.Context context) {
        try {
            android.content.pm.ApplicationInfo applicationInfoB = com.igexin.push.g.o.b(context);
            if (applicationInfoB != null && applicationInfoB.metaData != null) {
                if (!android.text.TextUtils.isEmpty(applicationInfoB.metaData.getString("GETUI_APPID"))) {
                    return true;
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean d(java.lang.String str) {
        try {
            if (android.os.Build.VERSION.SDK_INT >= 28 && a(com.igexin.push.core.e.l)) {
                return false;
            }
            com.igexin.push.g.l.a(str, 0);
            com.igexin.c.a.c.a.b(a, "checkApp by GtPm");
            return true;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(a, e2.toString());
            com.igexin.c.a.c.a.b(a, "checkApp by GtPm");
            return false;
        }
    }

    public static boolean e() {
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) com.igexin.push.core.e.l.getSystemService("connectivity");
            if (connectivityManager == null) {
                com.igexin.c.a.c.a.a("CheckUtils|ConnectivityManager is null", new java.lang.Object[0]);
                return false;
            }
            android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            com.igexin.c.a.c.a.a("CheckUtils|activeNetworkInfo = ".concat(java.lang.String.valueOf(activeNetworkInfo)), new java.lang.Object[0]);
            if (activeNetworkInfo == null || activeNetworkInfo.getState() != android.net.NetworkInfo.State.CONNECTED) {
                com.igexin.c.a.c.a.a("CheckUtils|network available = false", new java.lang.Object[0]);
                return false;
            }
            com.igexin.c.a.c.a.a(a + (activeNetworkInfo.getType() == 0 ? "mobile" : activeNetworkInfo.getType() == 1 ? "wifi" : com.igexin.push.a.i) + "|connected", new java.lang.Object[0]);
            return true;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.b(a, "network available ex =" + th.toString());
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean f() {
        java.lang.String str = com.igexin.push.config.d.P;
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            for (java.lang.String str2 : str.split(com.igexin.push.core.b.an)) {
                if (str2.contains("|") && str2.contains("~")) {
                    java.lang.String strSubstring = str2.substring(0, str2.indexOf("|"));
                    java.lang.String[] strArrSplit = str2.substring(str2.indexOf("|") + 1).split("~");
                    if (strArrSplit.length == 2) {
                        int i = java.lang.Integer.parseInt(strArrSplit[0]);
                        int i2 = java.lang.Integer.parseInt(strArrSplit[1]);
                        if (android.os.Build.BRAND.equalsIgnoreCase(strSubstring) && android.os.Build.VERSION.SDK_INT >= i && android.os.Build.VERSION.SDK_INT <= i2) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return false;
    }

    private static java.lang.String g() {
        return null;
    }
}
