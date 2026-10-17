package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class AuthLoginSuccess extends com.android.tools.r8.RecordTag {
    private final boolean isSwitchAccount;

    private /* synthetic */ boolean $record$equals(java.lang.Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            return java.util.Arrays.equals($record$getFieldsAsObjects(), ((com.up366.mobile.common.event.AuthLoginSuccess) obj).$record$getFieldsAsObjects());
        }
        return false;
    }

    private /* synthetic */ java.lang.Object[] $record$getFieldsAsObjects() {
        return new java.lang.Object[]{java.lang.Boolean.valueOf(this.isSwitchAccount)};
    }

    public AuthLoginSuccess(boolean isSwitchAccount) {
        this.isSwitchAccount = isSwitchAccount;
    }

    public final boolean equals(java.lang.Object obj) {
        return $record$equals(obj);
    }

    public final int hashCode() {
        return com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticBackport0.m(getClass(), $record$getFieldsAsObjects());
    }

    public boolean isSwitchAccount() {
        return this.isSwitchAccount;
    }

    public final java.lang.String toString() {
        return com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticBackport0.m($record$getFieldsAsObjects(), com.up366.mobile.common.event.AuthLoginSuccess.class, "isSwitchAccount");
    }
}
