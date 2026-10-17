package com.up366.common;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class EventBusUtilsUp {
    private static org.greenrobot.eventbus.EventBus eventBus = org.greenrobot.eventbus.EventBus.getDefault();

    public static void register(java.lang.Object... objArr) {
        try {
            for (java.lang.Object obj : objArr) {
                eventBus.register(obj);
                com.up366.common.log.Logger.debug("eventBus : " + obj.getClass() + " register : " + obj.hashCode());
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("register error:" + e.getMessage(), e);
        }
    }

    public static void unregister(java.lang.Object... objArr) {
        for (java.lang.Object obj : objArr) {
            com.up366.common.log.Logger.debug("eventBus : " + obj.getClass() + " unregister : " + obj.hashCode());
            eventBus.unregister(obj);
        }
    }

    public static void post(java.lang.Object obj) {
        eventBus.post(obj);
    }
}
