package com.up366.mobile.closepad;

/* JADX INFO: compiled from: PadConfigHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/up366/mobile/closepad/PadConfigHelper;", "", "<init>", "()V", "isTX18Pad", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PadConfigHelper {
    public static final com.up366.mobile.closepad.PadConfigHelper INSTANCE = new com.up366.mobile.closepad.PadConfigHelper();

    private PadConfigHelper() {
    }

    public final boolean isTX18Pad() {
        return com.up366.mobile.common.utils.PlatformUtils.isCustomClosePad();
    }
}
