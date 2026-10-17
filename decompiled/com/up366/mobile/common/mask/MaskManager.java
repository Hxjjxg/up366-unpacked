package com.up366.mobile.common.mask;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MaskManager {
    private static com.up366.mobile.common.mask.IMaskManager manager;

    public static com.up366.mobile.common.mask.IMaskManager getMgr() {
        com.up366.mobile.common.mask.IMaskManager iMaskManager = manager;
        if (iMaskManager != null) {
            return iMaskManager;
        }
        synchronized ("MaskManager") {
            if (manager == null) {
                manager = new com.up366.mobile.common.mask.XXXMaskManager();
            }
        }
        return manager;
    }
}
