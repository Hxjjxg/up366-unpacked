package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class OneKeyLoginManager {
    private static volatile com.chuanglan.shanyan_sdk.OneKeyLoginManager a;

    private OneKeyLoginManager() {
    }

    public static com.chuanglan.shanyan_sdk.OneKeyLoginManager getInstance() {
        if (a == null) {
            synchronized (com.chuanglan.shanyan_sdk.OneKeyLoginManager.class) {
                if (a == null) {
                    a = new com.chuanglan.shanyan_sdk.OneKeyLoginManager();
                }
            }
        }
        return a;
    }

    public void checkProcessesEnable(boolean z) {
        com.chuanglan.shanyan_sdk.t0.h().a(z);
    }

    public void clearScripCache(android.content.Context context) {
        com.chuanglan.shanyan_sdk.t0.h().c();
    }

    public int currentSimCounts(android.content.Context context) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getSimCount");
        return com.chuanglan.shanyan_sdk.C0065v.g().e(context.getApplicationContext());
    }

    public void finishAuthActivity() {
        com.chuanglan.shanyan_sdk.t0.h().f();
    }

    public android.app.Activity getAuthActivity() {
        return com.chuanglan.shanyan_sdk.t0.h().g();
    }

    public void getIEnable(boolean z) {
        com.chuanglan.shanyan_sdk.t0.h().c(z);
    }

    @java.lang.Deprecated
    public void getImEnable(boolean z) {
        com.chuanglan.shanyan_sdk.t0.h().b(z);
    }

    public void getMaEnable(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getMacEnable", java.lang.Boolean.valueOf(z));
    }

    public void getOaidEnable(boolean z) {
        com.chuanglan.shanyan_sdk.t0.h().d(z);
    }

    public java.lang.String getOperatorInfo(android.content.Context context) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getOperatorInfo");
        return com.chuanglan.shanyan_sdk.t0.h().b(context);
    }

    public java.lang.String getOperatorType(android.content.Context context) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getOperatorType");
        return com.chuanglan.shanyan_sdk.C0065v.g().b(context.getApplicationContext());
    }

    public void getPhoneInfo(com.chuanglan.shanyan_sdk.listener.GetPhoneInfoListener getPhoneInfoListener) {
        com.chuanglan.shanyan_sdk.t0.h().a(getPhoneInfoListener);
    }

    @java.lang.Deprecated
    public boolean getPreIntStatus() {
        return com.chuanglan.shanyan_sdk.t0.h().i();
    }

    public android.widget.CheckBox getPrivacyCheckBox() {
        return com.chuanglan.shanyan_sdk.t0.h().j();
    }

    public boolean getScripCache(android.content.Context context) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getScripCache");
        return com.chuanglan.shanyan_sdk.t0.h().d(context.getApplicationContext());
    }

    public java.lang.String getShanYanVersion() {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getShanYanVersion");
        return "2.3.7.7";
    }

    public void getSiEnable(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getSiEnable", java.lang.Boolean.valueOf(z));
    }

    public void getSinbEnable(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "getSinbEnable", java.lang.Boolean.valueOf(z));
    }

    public void init(android.content.Context context, java.lang.String str, com.chuanglan.shanyan_sdk.listener.InitListener initListener) {
        com.chuanglan.shanyan_sdk.t0.h().a(context.getApplicationContext(), str, initListener);
    }

    public void ipv6Enable(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "ipv6Enable", java.lang.Boolean.valueOf(z));
        com.chuanglan.shanyan_sdk.AbstractC0055l.P = z;
    }

    public void isReadPhoneStatePermissionEnable(boolean z) {
        com.chuanglan.shanyan_sdk.t0.h().g(z);
    }

    public void openLoginAuth(boolean z, com.chuanglan.shanyan_sdk.listener.OpenLoginAuthListener openLoginAuthListener, com.chuanglan.shanyan_sdk.listener.OneKeyLoginListener oneKeyLoginListener) {
        com.chuanglan.shanyan_sdk.t0.h().a(z, openLoginAuthListener, oneKeyLoginListener);
    }

    public void performLoginClick() {
        com.chuanglan.shanyan_sdk.t0.h().k();
    }

    public void putSimCounts(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "putSimCounts", java.lang.Boolean.valueOf(z));
        com.chuanglan.shanyan_sdk.AbstractC0055l.O = z;
    }

    public void registerActivityLifecycleCallbacks(android.content.Context context) {
        com.chuanglan.shanyan_sdk.t0.h().e(context);
    }

    public void removeAllListener() {
        com.chuanglan.shanyan_sdk.t0.h().l();
    }

    public void setActionListener(com.chuanglan.shanyan_sdk.listener.ActionListener actionListener) {
        com.chuanglan.shanyan_sdk.t0.h().a(actionListener);
    }

    public void setActivityLifecycleCallbacksEnable(boolean z) {
        com.chuanglan.shanyan_sdk.t0.h().h(z);
    }

    @java.lang.Deprecated
    public void setAuthThemeConfig(com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig) {
        com.chuanglan.shanyan_sdk.t0.h().a(shanYanUIConfig, shanYanUIConfig, shanYanUIConfig);
    }

    public void setCheckBoxValue(boolean z) {
        com.chuanglan.shanyan_sdk.t0.h().e(z);
    }

    public void setDebug(boolean z) {
        com.chuanglan.shanyan_sdk.P.a = z;
        com.unicom.online.account.shield.UniAccountHelper.getInstance().setLogEnable(z);
        com.cmic.gen.sdk.auth.GenAuthnHelper.setDebugMode(z);
    }

    public void setDeviceInfo(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setDeviceInfo", java.lang.Boolean.valueOf(z));
        com.chuanglan.shanyan_sdk.AbstractC0055l.G = z;
    }

    public void setFullReport(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setFullReport");
        com.chuanglan.shanyan_sdk.AbstractC0055l.B = z;
    }

    @java.lang.Deprecated
    public void setInitDebug(boolean z) {
        com.chuanglan.shanyan_sdk.P.b = z;
    }

    public void setLoadingVisibility(boolean z) {
        com.chuanglan.shanyan_sdk.t0.h().f(z);
    }

    public void setLogListener(com.chuanglan.shanyan_sdk.listener.OneKeyLoginLogListener oneKeyLoginLogListener) {
        com.chuanglan.shanyan_sdk.Q.a(oneKeyLoginLogListener);
    }

    public void setLoginActivityStatusListener(com.chuanglan.shanyan_sdk.listener.LoginActivityStatusListener loginActivityStatusListener) {
        com.chuanglan.shanyan_sdk.t0.h().a(loginActivityStatusListener);
    }

    public void setNetworkInfo(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setNetworkInfo", java.lang.Boolean.valueOf(z));
        com.chuanglan.shanyan_sdk.AbstractC0055l.H = z;
    }

    @java.lang.Deprecated
    public void setOnClickPrivacyListener(com.chuanglan.shanyan_sdk.listener.OnClickPrivacyListener onClickPrivacyListener) {
        com.chuanglan.shanyan_sdk.t0.h().a(onClickPrivacyListener);
    }

    public void setPrivacyOnClickListener(com.chuanglan.shanyan_sdk.listener.PricacyOnClickListener pricacyOnClickListener) {
        com.chuanglan.shanyan_sdk.t0.h().a(pricacyOnClickListener);
    }

    public void setPrivacyUrlWhiteList(boolean z, java.lang.String[] strArr) {
        com.chuanglan.shanyan_sdk.t0.h().a(z, strArr);
    }

    public void setSimcardInfo(boolean z) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setSimcardInfo", java.lang.Boolean.valueOf(z));
        com.chuanglan.shanyan_sdk.AbstractC0055l.I = z;
    }

    public void setTimeOutForPreLogin(int i) {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setTimeOutForPreLogin", java.lang.Integer.valueOf(i));
        com.chuanglan.shanyan_sdk.AbstractC0055l.y = i;
    }

    public void startAuthentication(com.chuanglan.shanyan_sdk.listener.AuthenticationExecuteListener authenticationExecuteListener) {
        com.chuanglan.shanyan_sdk.t0.h().a(authenticationExecuteListener);
    }

    public void startPrivacyProtocolActivity(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.chuanglan.shanyan_sdk.t0.h().a(context, str, str2);
    }

    public void unregisterActivityLifecycleCallbacks(boolean z) {
        com.chuanglan.shanyan_sdk.t0.h().i(z);
    }

    public void unregisterOnClickPrivacyListener() {
        com.chuanglan.shanyan_sdk.t0.h().o();
    }

    public void setAuthThemeConfig(com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig, com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig2) {
        com.chuanglan.shanyan_sdk.t0.h().a(shanYanUIConfig, shanYanUIConfig2, (com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig) null);
    }
}
