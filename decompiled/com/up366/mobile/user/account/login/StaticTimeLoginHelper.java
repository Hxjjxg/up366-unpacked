package com.up366.mobile.user.account.login;

/* JADX INFO: compiled from: StaticTimeLoginHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/up366/mobile/user/account/login/StaticTimeLoginHelper;", "", "<init>", "()V", "LoginType", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StaticTimeLoginHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.user.account.login.StaticTimeLoginHelper.Companion INSTANCE = new com.up366.mobile.user.account.login.StaticTimeLoginHelper.Companion(null);
    private static volatile java.util.concurrent.atomic.AtomicBoolean hasStart = new java.util.concurrent.atomic.AtomicBoolean(false);
    private static long mainListCompleteTime;
    private static long reqDlCompleteTime;
    private static long starTime;
    private static long starTimeReqDl;
    private static int type;

    /* JADX INFO: compiled from: StaticTimeLoginHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/up366/mobile/user/account/login/StaticTimeLoginHelper$LoginType;", "", "<init>", "()V", "AUTO_LOGIN", "", "MANLY_LOGIN_USERNAME", "MANLY_PHONE_CAPTCHA", "MANLY_PHONE_ONE_KEY", "MANLY_LOGIN_QQ", "MANLY_LOGIN_WECHAT", "MANLY_LOGIN_TOURIST", "MANLY_LOGIN_SWITCH_USER", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LoginType {
        public static final int AUTO_LOGIN = 0;
        public static final com.up366.mobile.user.account.login.StaticTimeLoginHelper.LoginType INSTANCE = new com.up366.mobile.user.account.login.StaticTimeLoginHelper.LoginType();
        public static final int MANLY_LOGIN_QQ = 4;
        public static final int MANLY_LOGIN_SWITCH_USER = 7;
        public static final int MANLY_LOGIN_TOURIST = 6;
        public static final int MANLY_LOGIN_USERNAME = 1;
        public static final int MANLY_LOGIN_WECHAT = 5;
        public static final int MANLY_PHONE_CAPTCHA = 2;
        public static final int MANLY_PHONE_ONE_KEY = 3;

        private LoginType() {
        }
    }

    /* JADX INFO: compiled from: StaticTimeLoginHelper.kt */
    @kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/up366/mobile/user/account/login/StaticTimeLoginHelper$Companion;", "", "<init>", "()V", "starTime", "", "starTimeReqDl", "mainListCompleteTime", "reqDlCompleteTime", "hasStart", "Ljava/util/concurrent/atomic/AtomicBoolean;", "type", "", "startLogin", "", "startReqDl", "onMainListComplete", "onReqDlComplete", "reset", "formatTime", "", "time", "static", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final synchronized void startLogin(int type) {
            com.up366.common.log.Logger.info("StaticLoginHelper startLogin type:" + type + " ,hasStart:" + com.up366.mobile.user.account.login.StaticTimeLoginHelper.hasStart);
            com.up366.mobile.user.account.login.StaticTimeLoginHelper.hasStart.set(true);
            com.up366.mobile.user.account.login.StaticTimeLoginHelper.type = type;
            com.up366.mobile.user.account.login.StaticTimeLoginHelper.starTime = java.lang.System.currentTimeMillis();
        }

        public final synchronized void startReqDl() {
            com.up366.common.log.Logger.info("StaticLoginHelper startReqDl hasStart:" + com.up366.mobile.user.account.login.StaticTimeLoginHelper.hasStart);
            if (com.up366.mobile.user.account.login.StaticTimeLoginHelper.hasStart.get()) {
                com.up366.mobile.user.account.login.StaticTimeLoginHelper.starTimeReqDl = java.lang.System.currentTimeMillis();
            }
        }

        public final synchronized void onMainListComplete() {
            com.up366.common.log.Logger.info("StaticLoginHelper onMainListComplete hasStart:" + com.up366.mobile.user.account.login.StaticTimeLoginHelper.hasStart);
            if (com.up366.mobile.user.account.login.StaticTimeLoginHelper.hasStart.get()) {
                com.up366.mobile.user.account.login.StaticTimeLoginHelper.mainListCompleteTime = java.lang.System.currentTimeMillis();
                m1249static();
            }
        }

        public final synchronized void onReqDlComplete() {
            com.up366.common.log.Logger.info("StaticLoginHelper onReqDlComplete hasStart:" + com.up366.mobile.user.account.login.StaticTimeLoginHelper.hasStart);
            if (com.up366.mobile.user.account.login.StaticTimeLoginHelper.hasStart.get()) {
                com.up366.mobile.user.account.login.StaticTimeLoginHelper.reqDlCompleteTime = java.lang.System.currentTimeMillis();
                m1249static();
            }
        }

        public final synchronized void reset() {
            com.up366.common.log.Logger.info("StaticLoginHelper reset hasStart:" + com.up366.mobile.user.account.login.StaticTimeLoginHelper.hasStart);
            com.up366.mobile.user.account.login.StaticTimeLoginHelper.hasStart.set(false);
            com.up366.mobile.user.account.login.StaticTimeLoginHelper.starTime = 0L;
            com.up366.mobile.user.account.login.StaticTimeLoginHelper.starTimeReqDl = 0L;
            com.up366.mobile.user.account.login.StaticTimeLoginHelper.mainListCompleteTime = 0L;
            com.up366.mobile.user.account.login.StaticTimeLoginHelper.reqDlCompleteTime = 0L;
            com.up366.mobile.user.account.login.StaticTimeLoginHelper.type = 0;
        }

        private final java.lang.String formatTime(long time) {
            java.lang.String time2 = com.up366.common.TimeUtils.formatTime(time, "yyyy-MM-dd HH:mm:ss");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(time2, "formatTime(...)");
            return time2;
        }

        /* JADX INFO: renamed from: static, reason: not valid java name */
        private final void m1249static() {
            com.up366.common.log.Logger.info("StaticLoginHelper static hasStart:" + com.up366.mobile.user.account.login.StaticTimeLoginHelper.hasStart + " ,mainListCompleteTime:" + com.up366.mobile.user.account.login.StaticTimeLoginHelper.mainListCompleteTime + " ,reqDlCompleteTime:" + com.up366.mobile.user.account.login.StaticTimeLoginHelper.reqDlCompleteTime);
            if (com.up366.mobile.user.account.login.StaticTimeLoginHelper.mainListCompleteTime == 0 || com.up366.mobile.user.account.login.StaticTimeLoginHelper.reqDlCompleteTime == 0) {
                return;
            }
            final long j = com.up366.mobile.user.account.login.StaticTimeLoginHelper.reqDlCompleteTime - com.up366.mobile.user.account.login.StaticTimeLoginHelper.starTimeReqDl;
            if (j < 0 || j > 1000000) {
                com.up366.common.log.Logger.info("StaticLoginHelper static startTime:" + formatTime(com.up366.mobile.user.account.login.StaticTimeLoginHelper.starTime) + ",starTimeReqDl:" + formatTime(com.up366.mobile.user.account.login.StaticTimeLoginHelper.starTimeReqDl) + ",mainListCompleteTime:" + formatTime(com.up366.mobile.user.account.login.StaticTimeLoginHelper.mainListCompleteTime) + ",reqDlCompleteTime:" + formatTime(com.up366.mobile.user.account.login.StaticTimeLoginHelper.reqDlCompleteTime));
                return;
            }
            com.up366.common.log.Logger.info("StaticLoginHelper static relDuration:" + j + " ,type:" + com.up366.mobile.user.account.login.StaticTimeLoginHelper.type + ",startTime:" + formatTime(com.up366.mobile.user.account.login.StaticTimeLoginHelper.starTime) + ",starTimeReqDl:" + formatTime(com.up366.mobile.user.account.login.StaticTimeLoginHelper.starTimeReqDl) + ",mainListCompleteTime:" + formatTime(com.up366.mobile.user.account.login.StaticTimeLoginHelper.mainListCompleteTime) + ",reqDlCompleteTime:" + formatTime(com.up366.mobile.user.account.login.StaticTimeLoginHelper.reqDlCompleteTime));
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - com.up366.mobile.user.account.login.StaticTimeLoginHelper.starTime;
            final long j2 = jCurrentTimeMillis > j ? jCurrentTimeMillis - j : jCurrentTimeMillis;
            if (j2 < 0 || j2 > 2000) {
                com.up366.common.log.Logger.info("StaticLoginHelper Error totalDuration:" + j2 + " ,duration:" + jCurrentTimeMillis + " ,relDuration:" + j);
                return;
            }
            com.up366.mobile.common.onlinelog.OpLog.report(".def.app.login", "登录时长", (androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject>) new androidx.core.util.Consumer() { // from class: com.up366.mobile.user.account.login.StaticTimeLoginHelper$Companion$$ExternalSyntheticLambda0
                public final void accept(java.lang.Object obj) {
                    com.up366.mobile.user.account.login.StaticTimeLoginHelper.Companion.static$lambda$0(j2, j, (com.alibaba.fastjson.JSONObject) obj);
                }
            });
            reset();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void static$lambda$0(long j, long j2, com.alibaba.fastjson.JSONObject jSONObject) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jSONObject, "ext");
            java.util.Map map = (java.util.Map) jSONObject;
            map.put("totalDuration", java.lang.Long.valueOf(j));
            map.put("reqDlDuration", java.lang.Long.valueOf(j2));
            map.put("type", java.lang.Integer.valueOf(com.up366.mobile.user.account.login.StaticTimeLoginHelper.type));
        }
    }
}
