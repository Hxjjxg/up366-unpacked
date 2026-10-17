package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class r2 implements com.zx.sdk.api.ZXApi {
    public java.lang.String a;

    public r2(java.lang.String str) throws java.lang.IllegalStateException {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalStateException("ZX_APPID not found");
        }
        this.a = str;
    }

    @Override // com.zx.sdk.api.ZXApi
    public void addZXIDChangedListener(com.zx.sdk.api.ZXIDChangedListener zXIDChangedListener) {
        try {
            com.zx.a.I8b7.f0.b.a.a(this.a, "addZXIDChangedListener", "");
            com.zx.a.I8b7.i3 i3VarB = com.zx.a.I8b7.i3.b();
            java.lang.String str = this.a;
            i3VarB.getClass();
            com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.a.I8b7.p3(i3VarB, str, zXIDChangedListener));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.registerListener(listener) failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void allowPermissionDialog(boolean z) {
        try {
            com.zx.a.I8b7.f0.b.a.a(this.a, "allowPermissionDialog", "enable=" + z);
            com.zx.a.I8b7.i3 i3VarB = com.zx.a.I8b7.i3.b();
            i3VarB.getClass();
            com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.a.I8b7.n3(i3VarB, z));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.allowPermissionDialog failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void checkPermission(android.app.Activity activity, com.zx.sdk.api.PermissionCallback permissionCallback) {
        try {
            com.zx.a.I8b7.f0.b.a.a(this.a, "checkPermission", "");
            if (permissionCallback == null) {
                return;
            }
            com.zx.a.I8b7.i3 i3VarB = com.zx.a.I8b7.i3.b();
            i3VarB.getClass();
            com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.a.I8b7.h3(i3VarB, permissionCallback, activity));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.y.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getAuthToken(com.zx.sdk.api.Callback callback) {
        try {
            com.zx.a.I8b7.f0.b.a.a(this.a, "getAuthToken", "");
            if (callback == null) {
                return;
            }
            com.zx.a.I8b7.i3 i3VarB = com.zx.a.I8b7.i3.b();
            java.lang.String str = this.a;
            i3VarB.getClass();
            com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.a.I8b7.l3(i3VarB, str, callback));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.y.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getOpenID(com.zx.sdk.api.Callback callback, android.content.Context context) {
        try {
            com.zx.a.I8b7.f0.b.a.a(this.a, "getOpenID", "");
            if (callback != null) {
                com.zx.a.I8b7.i3 i3VarB = com.zx.a.I8b7.i3.b();
                i3VarB.getClass();
                com.zx.a.I8b7.i4.f.a.c.execute(new com.zx.a.I8b7.e3(i3VarB, context, callback));
            }
        } catch (java.lang.Throwable th) {
            if (callback != null) {
                callback.onFailed(10000, th.getMessage());
            }
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.getOpenID(cb) failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getSAID(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.zx.sdk.api.SAIDCallback sAIDCallback) {
        try {
            com.zx.a.I8b7.f0.b.a.a(this.a, "getUAID", "");
            if (sAIDCallback != null) {
                com.zx.a.I8b7.i3 i3VarB = com.zx.a.I8b7.i3.b();
                java.lang.String str6 = this.a;
                i3VarB.getClass();
                com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.a.I8b7.j3(i3VarB, str6, str, str2, str3, str4, str5, sAIDCallback));
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager getSAID onFailed:"));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getTag(com.zx.sdk.api.Callback callback) {
        try {
            com.zx.a.I8b7.f0.b.a.a(this.a, "getTag", "");
            if (callback == null) {
                return;
            }
            com.zx.a.I8b7.i3 i3VarB = com.zx.a.I8b7.i3.b();
            java.lang.String str = this.a;
            i3VarB.getClass();
            com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.a.I8b7.k3(i3VarB, str, callback));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.y.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public java.lang.String getVersion() {
        com.zx.a.I8b7.f0.b.a.a(this.a, "getVersion", "");
        return "3.3.7.58976";
    }

    @Override // com.zx.sdk.api.ZXApi
    public void getZXID(com.zx.sdk.api.ZXIDListener zXIDListener) {
        try {
            com.zx.a.I8b7.f0.b.a.a(this.a, "getZXID", "");
            if (zXIDListener != null) {
                com.zx.a.I8b7.i3 i3VarB = com.zx.a.I8b7.i3.b();
                java.lang.String str = this.a;
                i3VarB.getClass();
                com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.a.I8b7.d3(i3VarB, str, zXIDListener));
            }
        } catch (java.lang.Throwable th) {
            if (zXIDListener != null) {
                zXIDListener.onFailed(10000, th.getMessage());
            }
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.getZXID(zxidListener) failed: "));
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void init(android.content.Context context) {
        try {
            com.zx.a.I8b7.f0.b.a.a(this.a, "init", "");
            com.zx.a.I8b7.i3.a(context);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.y.b("ZXManager.init failed:" + th);
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public java.lang.String invoke(java.lang.String str, java.lang.String str2) {
        try {
            com.zx.a.I8b7.f0.b.a.a(this.a, "invoke", "method=" + str + "&argument" + str2);
            return com.zx.a.I8b7.i3.b().a(str, str2);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.invoke failed: "));
            return null;
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public boolean isAllowPermissionDialog() {
        try {
            com.zx.a.I8b7.f0.b.a.a(this.a, "isAllowPermissionDialog", "");
            com.zx.a.I8b7.i3.b().getClass();
            return com.zx.a.I8b7.x3.u == 1;
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.isAllowPermissionDialog failed: "));
            return false;
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public boolean isEnable() {
        try {
            com.zx.a.I8b7.f0.b.a.a(this.a, "isEnable", "");
            com.zx.a.I8b7.i3.b().getClass();
            return com.zx.a.I8b7.x3.t == 1;
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.isEnable failed: "));
            return false;
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void setDebug(boolean z) {
        try {
            com.zx.a.I8b7.f0.b.a.a(this.a, "setDebug", "isDebug=" + z);
            com.zx.a.I8b7.i3 i3VarB = com.zx.a.I8b7.i3.b();
            i3VarB.getClass();
            com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.a.I8b7.o3(i3VarB, z));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.y.b(th.getMessage());
        }
    }

    @Override // com.zx.sdk.api.ZXApi
    public void setEnable(boolean z) {
        try {
            com.zx.a.I8b7.f0.b.a.a(this.a, "setEnable", "enable=" + z);
            com.zx.a.I8b7.i3 i3VarB = com.zx.a.I8b7.i3.b();
            i3VarB.getClass();
            com.zx.a.I8b7.i4.f.a.a.execute(new com.zx.a.I8b7.m3(i3VarB, z));
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r3.a(th, com.zx.a.I8b7.q3.a("ZXManager.setEnable failed: "));
        }
    }
}
