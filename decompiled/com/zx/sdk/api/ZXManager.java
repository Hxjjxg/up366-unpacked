package com.zx.sdk.api;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ZXManager {
    public static final java.lang.String TAG = "ZXManager";
    public static com.zx.sdk.api.ZXApi api;
    public static android.content.Context ctx;

    static {
        try {
            java.lang.System.loadLibrary("zxprotect");
        } catch (java.lang.Throwable th) {
            java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("ZXLoadLibraryError:");
            sbA.append(th.getMessage());
            android.util.Log.e(TAG, sbA.toString());
        }
    }

    public static void addZXIDChangedListener(com.zx.sdk.api.ZXIDChangedListener zXIDChangedListener) {
        try {
            if (checkAPI()) {
                api.addZXIDChangedListener(zXIDChangedListener);
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.registerListener(listener) failed: "));
        }
    }

    public static void allowPermissionDialog(boolean z) {
        try {
            if (checkAPI()) {
                api.allowPermissionDialog(z);
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.allowPermissionDialog failed: "));
        }
    }

    private static boolean checkAPI() {
        if (api != null) {
            return true;
        }
        com.zx.a.I8b7.y.b("ZXManager not init, should init firstly");
        return false;
    }

    public static void checkPermission(android.app.Activity activity, com.zx.sdk.api.PermissionCallback permissionCallback) {
        if (permissionCallback == null) {
            return;
        }
        try {
            if (checkAPI()) {
                api.checkPermission(activity, permissionCallback);
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.y.b(th.getMessage());
        }
    }

    public static void getAuthToken(com.zx.sdk.api.Callback callback) {
        try {
            if (checkAPI() && callback != null) {
                api.getAuthToken(callback);
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager getAuthToken onFailed:"));
        }
    }

    public static void getOpenID(com.zx.sdk.api.Callback callback) {
        try {
            if (checkAPI() && callback != null) {
                android.content.Context context = ctx;
                if (context != null) {
                    api.getOpenID(callback, context);
                } else {
                    com.zx.a.I8b7.y.b("Context is empty！Please should init firstly");
                    callback.onFailed(com.igexin.sdk.PushConsts.SET_TAG_RESULT, "Context is empty！Please should init firstly");
                }
            }
        } catch (java.lang.Throwable th) {
            if (callback != null) {
                callback.onFailed(10000, th.getMessage());
            }
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.getOpenID(Callback) failed: "));
        }
    }

    public static void getSAID(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.zx.sdk.api.SAIDCallback sAIDCallback) {
        try {
            if (checkAPI() && sAIDCallback != null) {
                api.getSAID(str, str2, str3, str4, str5, sAIDCallback);
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager getSAID onFailed:"));
        }
    }

    public static void getTag(com.zx.sdk.api.Callback callback) {
        try {
            if (checkAPI() && callback != null) {
                api.getTag(callback);
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager getTag onFailed:"));
        }
    }

    public static java.lang.String getVersion() {
        try {
            if (!checkAPI()) {
                return "3.3.7.58976";
            }
            api.getVersion();
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.getVersion failed: "));
        }
        return "3.3.7.58976";
    }

    public static void getZXID(com.zx.sdk.api.ZXIDListener zXIDListener) {
        try {
            if (checkAPI() && zXIDListener != null) {
                api.getZXID(zXIDListener);
            }
        } catch (java.lang.Throwable th) {
            if (zXIDListener != null) {
                zXIDListener.onFailed(10000, th.getMessage());
            }
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.getZXID(zxidListener) failed: "));
        }
    }

    public static void init(android.content.Context context) {
        try {
            if (api == null) {
                api = new com.zx.a.I8b7.r2(com.zx.a.I8b7.f2.a(context));
            }
            if (!com.zx.a.I8b7.j4.g(context)) {
                throw new java.lang.RuntimeException("ZXSDK 需要在主进程做初始化！");
            }
            api.init(context);
            if (context != null) {
                ctx = context.getApplicationContext();
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.init failed:"));
        }
    }

    public static java.lang.String invoke(java.lang.String str, java.lang.String str2) {
        try {
            return !checkAPI() ? "ZXManager is not init" : api.invoke(str, str2);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.invoke failed: "));
            return null;
        }
    }

    public static boolean isAllowPermissionDialog() {
        try {
            if (checkAPI()) {
                return api.isAllowPermissionDialog();
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.isAllowPermissionDialog failed: "));
            return false;
        }
    }

    public static boolean isEnable() {
        try {
            if (checkAPI()) {
                return api.isEnable();
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.isEnable failed: "));
            return false;
        }
    }

    public static com.zx.sdk.api.ZXApi newSDK(java.lang.String str) {
        try {
            return new com.zx.a.I8b7.r2(str);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.y.b("ZXManager.newProxy failed:" + th);
            return null;
        }
    }

    public static void setDebug(boolean z) {
        try {
            com.zx.a.I8b7.y.a = z;
            com.zx.sdk.api.ZXApi zXApi = api;
            if (zXApi != null) {
                zXApi.setDebug(z);
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.y.b(th.getMessage());
        }
    }

    public static void setEnable(boolean z) {
        try {
            if (checkAPI()) {
                api.setEnable(z);
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.setEnable failed: "));
        }
    }
}
