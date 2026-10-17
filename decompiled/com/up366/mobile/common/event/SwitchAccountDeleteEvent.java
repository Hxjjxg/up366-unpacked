package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SwitchAccountDeleteEvent {
    private final com.up366.mobile.user.account.switchaccount.SwitchAccountData info;

    public SwitchAccountDeleteEvent(com.up366.mobile.user.account.switchaccount.SwitchAccountData switchAccountData) {
        this.info = switchAccountData;
    }

    public com.up366.mobile.user.account.switchaccount.SwitchAccountData getInfo() {
        return this.info;
    }
}
