package com.up366.mobile;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Up366Application extends android.app.Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.Thread.setDefaultUncaughtExceptionHandler(new com.up366.mobile.Up366Application.CustomUncaughtHandler());
        com.tencent.mmkv.MMKV.initialize(this);
        com.up366.mobile.common.helper.ApplicationHelper.getInst().initGbCallBack(this);
        com.up366.mobile.common.utils.PreferenceUtils.compatData();
        if (com.up366.mobile.common.utils.PreferenceUtils.getBoolean("hasAgreePermission", false)) {
            com.up366.mobile.common.helper.ApplicationHelper.getInst().onCreate(this);
            com.up366.common.log.Logger.debug("count Up366ApplicationLike.onCreate time : " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        }
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(android.content.Context context) {
        super.attachBaseContext(context);
        com.up366.mobile.common.utils.AndroidPCompatUtils.setWebViewDataDirectorySuffix(context);
        androidx.multidex.MultiDex.install(context);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.common.event.NetStatusChangeEvent netStatusChangeEvent) {
        com.up366.common.task.TaskUtils.postLazyTaskGlobal("Up366ApplicationLike#onReceiveOnlineState", new com.up366.common.task.Task() { // from class: com.up366.mobile.Up366Application$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.common.utils.DownloadHelper.resetAllowNonWiFiState();
            }
        });
    }

    private static class CustomUncaughtHandler implements java.lang.Thread.UncaughtExceptionHandler {
        private CustomUncaughtHandler() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
            android.util.Log.e("CustomUncaughtHandler", "uncaughtException: ", th);
        }
    }
}
