package com.igexin.sdk.router.boatman;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface IShips {
    boolean isRegistered(com.igexin.sdk.router.boatman.receive.Site site);

    void register(com.igexin.sdk.router.boatman.receive.Site site);

    void unRegister(com.igexin.sdk.router.boatman.receive.Site site);
}
