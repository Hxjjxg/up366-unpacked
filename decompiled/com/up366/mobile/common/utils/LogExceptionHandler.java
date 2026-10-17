package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LogExceptionHandler implements java.lang.Thread.UncaughtExceptionHandler {
    private final java.lang.Thread.UncaughtExceptionHandler ueh = java.lang.Thread.getDefaultUncaughtExceptionHandler();

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(java.lang.Thread thread, java.lang.Throwable th) {
        try {
            com.up366.common.log.Logger.error("Uncaught Exception in " + thread.getName() + "[" + thread.getId() + "]", th);
            android.content.Context applicationContext = com.up366.common.global.GB.get().getApplicationContext();
            com.up366.mobile.common.crash.CrashDataManager.getInstance().collectJVMCrashData(thread, th);
            android.content.Intent launchIntentForPackage = applicationContext.getPackageManager().getLaunchIntentForPackage(applicationContext.getPackageName());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(67108864);
                applicationContext.startActivity(launchIntentForPackage);
            }
        } catch (java.lang.Throwable th2) {
            android.util.Log.e("Up366", "uncaughtException: ", th2);
        }
        java.lang.Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.ueh;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
