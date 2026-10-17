package com.igexin.base.boatman;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class Boater<Bag, V> {
    public abstract java.lang.String getTag();

    public void postASync(Bag bag, com.igexin.base.boatman.receive.IBoatResult<V> iBoatResult) {
        com.igexin.base.api.ShipsManager.get().getShip().a(this, bag, iBoatResult);
    }

    public void postSticky(Bag bag, com.igexin.base.boatman.receive.IBoatResult<V> iBoatResult) {
        com.igexin.base.boatman.b ship = com.igexin.base.api.ShipsManager.get().getShip();
        java.lang.String tag = getTag();
        ship.a.lock();
        try {
            boolean zContainsKey = ship.b.containsKey(getTag());
            if (!zContainsKey) {
                if (ship.c.get(tag) == null) {
                    ship.c.put(tag, new java.util.ArrayList());
                }
                ship.c.get(tag).add(new com.igexin.base.boatman.a(bag, iBoatResult));
            }
            if (zContainsKey) {
                ship.a(this, bag, iBoatResult);
            }
        } finally {
            ship.a.unlock();
        }
    }

    public V postSync(Bag bag) {
        com.igexin.base.boatman.receive.Site site = com.igexin.base.api.ShipsManager.get().getShip().b.get(getTag());
        if (site == null) {
            return null;
        }
        return (V) site.onArrived(bag);
    }

    public boolean removeSticky(Bag bag) {
        return com.igexin.base.api.ShipsManager.get().getShip().a(this, bag);
    }
}
