package io.objectbox.config;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ValidateOnOpenModePages {
    public static final short AllBranches = 4;
    public static final short Full = 5;
    public static final short None = 1;
    public static final short Regular = 2;
    public static final short Unknown = 0;
    public static final short WithLeaves = 3;
    public static final java.lang.String[] names = {com.up366.common.NetworkUtilsUp.TYPE_UNKNOWN, "None", "Regular", "WithLeaves", "AllBranches", "Full"};

    private ValidateOnOpenModePages() {
    }

    public static java.lang.String name(int i) {
        return names[i];
    }
}
