package com.up366.mobile.common.crash;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CrashLevelStrategyRegistry {
    private final java.util.Map<java.lang.String, com.up366.mobile.common.crash.CrashLevelHandlingStrategy<?>> strategies = new java.util.concurrent.ConcurrentHashMap();

    public <T> void registerStrategy(com.up366.mobile.common.crash.CrashLevelHandlingStrategy<T> crashLevelHandlingStrategy) {
        this.strategies.put(crashLevelHandlingStrategy.getCrashType(), crashLevelHandlingStrategy);
    }

    public <T> com.up366.mobile.common.crash.CrashLevelHandlingStrategy<T> getStrategy(java.lang.String str) {
        return (com.up366.mobile.common.crash.CrashLevelHandlingStrategy) this.strategies.get(str);
    }

    public boolean containsStrategy(java.lang.String str) {
        return this.strategies.containsKey(str);
    }
}
