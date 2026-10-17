package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OpenDebugLogCompat {
    public boolean handle(android.app.Activity activity, java.lang.String str) {
        if (!"32f141c1247961745af1acf776c05d42b4a13c930d4470a9467de377c542fa22".equals(str)) {
            return false;
        }
        com.up366.common.log.Logger.init(com.up366.common.log.LogLevel.DEBUG, "Up366Mobile", com.up366.mobile.common.utils.AppFileUtils.getLogPath());
        return true;
    }
}
