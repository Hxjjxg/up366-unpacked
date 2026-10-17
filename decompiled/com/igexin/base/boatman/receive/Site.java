package com.igexin.base.boatman.receive;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class Site<Bag, V> {
    public abstract java.lang.String getTag();

    public abstract V onArrived(Bag bag);

    public abstract void onArrived(Bag bag, com.igexin.base.boatman.receive.IBoatResult<V> iBoatResult);
}
