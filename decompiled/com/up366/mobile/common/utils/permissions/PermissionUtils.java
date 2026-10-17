package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
final class PermissionUtils {
    private static final android.os.Handler HANDLER = new android.os.Handler(android.os.Looper.getMainLooper());

    PermissionUtils() {
    }

    static boolean checkSelfPermission(android.content.Context context, java.lang.String str) {
        return context.checkSelfPermission(str) == 0;
    }

    static boolean checkOpNoThrow(android.content.Context context, java.lang.String str, int i) {
        android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) context.getSystemService("appops");
        android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
        java.lang.String packageName = context.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(android.app.AppOpsManager.class.getName());
            try {
                i = ((java.lang.Integer) cls.getDeclaredField(str).get(java.lang.Integer.class)).intValue();
            } catch (java.lang.NoSuchFieldException e) {
                e.printStackTrace();
            }
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            return ((java.lang.Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, java.lang.String.class).invoke(appOpsManager, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), packageName)).intValue() == 0;
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.RuntimeException | java.lang.reflect.InvocationTargetException unused) {
            return true;
        }
    }

    static boolean checkOpNoThrow(android.content.Context context, java.lang.String str) {
        int iCheckOpNoThrow;
        android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) context.getSystemService("appops");
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid10()) {
            iCheckOpNoThrow = appOpsManager.unsafeCheckOpNoThrow(str, context.getApplicationInfo().uid, context.getPackageName());
        } else {
            iCheckOpNoThrow = appOpsManager.checkOpNoThrow(str, context.getApplicationInfo().uid, context.getPackageName());
        }
        return iCheckOpNoThrow == 0;
    }

    static boolean shouldShowRequestPermissionRationale(android.app.Activity activity, java.lang.String str) {
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.getAndroidVersionCode() == 31) {
            try {
                return ((java.lang.Boolean) android.content.pm.PackageManager.class.getMethod("shouldShowRequestPermissionRationale", java.lang.String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return activity.shouldShowRequestPermissionRationale(str);
    }

    static void postActivityResult(java.util.List<java.lang.String> list, java.lang.Runnable runnable) {
        long j = 300;
        long j2 = com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid11() ? 200L : 300L;
        if (com.up366.mobile.common.utils.permissions.PhoneRomUtils.isEmui() || com.up366.mobile.common.utils.permissions.PhoneRomUtils.isHarmonyOs()) {
            if (!com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid8()) {
                j = 500;
            }
        } else {
            j = (com.up366.mobile.common.utils.permissions.PhoneRomUtils.isMiui() && com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid11() && containsPermission(list, com.up366.mobile.common.utils.permissions.Permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)) ? 1000L : j2;
        }
        postDelayed(runnable, j);
    }

    static void postDelayed(java.lang.Runnable runnable, long j) {
        HANDLER.postDelayed(runnable, j);
    }

    static boolean isDebugMode(android.content.Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    static com.up366.mobile.common.utils.permissions.AndroidManifestInfo getAndroidManifestInfo(android.content.Context context) {
        com.up366.mobile.common.utils.permissions.AndroidManifestInfo androidManifest;
        int iFindApkPathCookie = findApkPathCookie(context, context.getApplicationInfo().sourceDir);
        com.up366.mobile.common.utils.permissions.AndroidManifestInfo androidManifestInfo = null;
        if (iFindApkPathCookie == 0) {
            return null;
        }
        try {
            androidManifest = com.up366.mobile.common.utils.permissions.AndroidManifestParser.parseAndroidManifest(context, iFindApkPathCookie);
        } catch (java.io.IOException e) {
            e = e;
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            e = e2;
        }
        try {
            if (android.text.TextUtils.equals(context.getPackageName(), androidManifest.packageName)) {
                return androidManifest;
            }
            return null;
        } catch (java.io.IOException | org.xmlpull.v1.XmlPullParserException e3) {
            e = e3;
            androidManifestInfo = androidManifest;
            e.printStackTrace();
            return androidManifestInfo;
        }
    }

    static void optimizePermissionResults(android.app.Activity activity, java.lang.String[] strArr, int[] iArr) {
        for (int i = 0; i < strArr.length; i++) {
            java.lang.String str = strArr[i];
            if (com.up366.mobile.common.utils.permissions.PermissionApi.isSpecialPermission(str)) {
                iArr[i] = com.up366.mobile.common.utils.permissions.PermissionApi.getPermissionResult(activity, str);
            } else if (equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.GET_INSTALLED_APPS)) {
                iArr[i] = com.up366.mobile.common.utils.permissions.PermissionApi.getPermissionResult(activity, str);
            } else if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid14() && (equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_IMAGES) || equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_VIDEO))) {
                iArr[i] = com.up366.mobile.common.utils.permissions.PermissionApi.getPermissionResult(activity, str);
            } else if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid13() && com.up366.mobile.common.utils.permissions.AndroidVersion.getTargetSdkVersionCode(activity) >= 33 && equalsPermission(str, com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE)) {
                iArr[i] = com.up366.mobile.common.utils.permissions.PermissionApi.getPermissionResult(activity, str);
            } else if (com.up366.mobile.common.utils.permissions.Permission.getDangerPermissionFromAndroidVersion(str) > com.up366.mobile.common.utils.permissions.AndroidVersion.getAndroidVersionCode()) {
                iArr[i] = com.up366.mobile.common.utils.permissions.PermissionApi.getPermissionResult(activity, str);
            }
        }
    }

    static <T> java.util.ArrayList<T> asArrayList(T... tArr) {
        java.util.ArrayList<T> arrayList = new java.util.ArrayList<>(tArr != null ? tArr.length : 0);
        if (tArr != null && tArr.length != 0) {
            for (T t : tArr) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @java.lang.SafeVarargs
    static <T> java.util.ArrayList<T> asArrayLists(T[]... tArr) {
        java.util.ArrayList<T> arrayList = new java.util.ArrayList<>();
        if (tArr != null && tArr.length != 0) {
            for (T[] tArr2 : tArr) {
                arrayList.addAll(asArrayList(tArr2));
            }
        }
        return arrayList;
    }

    static android.app.Activity findActivity(android.content.Context context) {
        while (!(context instanceof android.app.Activity)) {
            if (!(context instanceof android.content.ContextWrapper) || (context = ((android.content.ContextWrapper) context).getBaseContext()) == null) {
                return null;
            }
        }
        return (android.app.Activity) context;
    }

    static int findApkPathCookie(android.content.Context context, java.lang.String str) {
        android.content.res.AssetManager assets = context.getAssets();
        try {
            if (com.up366.mobile.common.utils.permissions.AndroidVersion.getTargetSdkVersionCode(context) >= 28 && com.up366.mobile.common.utils.permissions.AndroidVersion.getAndroidVersionCode() >= 28 && com.up366.mobile.common.utils.permissions.AndroidVersion.getAndroidVersionCode() < 30) {
                java.lang.reflect.Method declaredMethod = java.lang.Class.class.getDeclaredMethod("getDeclaredMethod", java.lang.String.class, java.lang.Class[].class);
                declaredMethod.setAccessible(true);
                java.lang.reflect.Method method = (java.lang.reflect.Method) declaredMethod.invoke(android.content.res.AssetManager.class, "findCookieForPath", new java.lang.Class[]{java.lang.String.class});
                if (method != null) {
                    method.setAccessible(true);
                    java.lang.Integer num = (java.lang.Integer) method.invoke(context.getAssets(), str);
                    if (num != null) {
                        return num.intValue();
                    }
                }
            }
            java.lang.Integer num2 = (java.lang.Integer) assets.getClass().getDeclaredMethod("addAssetPath", java.lang.String.class).invoke(assets, str);
            if (num2 != null) {
                return num2.intValue();
            }
        } catch (java.lang.IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (java.lang.reflect.InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return 0;
    }

    static boolean isScopedStorage(android.content.Context context) {
        try {
            android.os.Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null || !bundle.containsKey("ScopedStorage")) {
                return false;
            }
            return bundle.getBoolean("ScopedStorage");
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    static void lockActivityOrientation(android.app.Activity activity) {
        try {
            int i = activity.getResources().getConfiguration().orientation;
            if (i == 1) {
                activity.setRequestedOrientation(isActivityReverse(activity) ? 9 : 1);
            } else if (i == 2) {
                activity.setRequestedOrientation(isActivityReverse(activity) ? 8 : 0);
            }
        } catch (java.lang.IllegalStateException e) {
            e.printStackTrace();
        }
    }

    static boolean isActivityReverse(android.app.Activity activity) {
        android.view.Display defaultDisplay;
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid11()) {
            defaultDisplay = activity.getDisplay();
        } else {
            android.view.WindowManager windowManager = activity.getWindowManager();
            defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        }
        if (defaultDisplay == null) {
            return false;
        }
        int rotation = defaultDisplay.getRotation();
        return rotation == 2 || rotation == 3;
    }

    static boolean areActivityIntent(android.content.Context context, android.content.Intent intent) {
        if (intent == null) {
            return false;
        }
        return !context.getPackageManager().queryIntentActivities(intent, 65536).isEmpty();
    }

    static boolean equalsPermission(java.lang.String str, java.lang.String str2) {
        int length = str.length();
        if (length != str2.length()) {
            return false;
        }
        for (int i = length - 1; i >= 0; i--) {
            if (str.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    static boolean containsPermission(java.util.Collection<java.lang.String> collection, java.lang.String str) {
        if (collection.isEmpty()) {
            return false;
        }
        java.util.Iterator<java.lang.String> it = collection.iterator();
        while (it.hasNext()) {
            if (equalsPermission(it.next(), str)) {
                return true;
            }
        }
        return false;
    }

    static android.net.Uri getPackageNameUri(android.content.Context context) {
        return android.net.Uri.parse("package:" + context.getPackageName());
    }
}
