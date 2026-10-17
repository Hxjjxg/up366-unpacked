package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class bi {
    public static volatile com.unicom.online.account.kernel.bi f;
    public int b = 500;
    public int c = 1000;
    public int d = com.up366.medialibrary.camera.CustomCameraView.DEFAULT_MIN_RECORD_VIDEO;
    public int e = 1800;

    public static com.unicom.online.account.kernel.bi b() {
        if (f == null) {
            synchronized (com.unicom.online.account.kernel.bi.class) {
                if (f == null) {
                    f = new com.unicom.online.account.kernel.bi();
                }
            }
        }
        return f;
    }
}
