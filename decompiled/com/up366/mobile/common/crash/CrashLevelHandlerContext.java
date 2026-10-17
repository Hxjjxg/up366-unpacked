package com.up366.mobile.common.crash;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CrashLevelHandlerContext {
    private final com.up366.mobile.common.crash.CrashLevelStrategyRegistry registry = new com.up366.mobile.common.crash.CrashLevelStrategyRegistry();

    public CrashLevelHandlerContext() {
        registerStrategy();
    }

    public void registerStrategy() {
        this.registry.registerStrategy(new com.up366.mobile.common.crash.JvmCrashLevelStrategy());
        this.registry.registerStrategy(new com.up366.mobile.common.crash.WebViewCrashLevelStrategy());
    }

    public <T> void handleCrash(java.lang.String str, T t) {
        com.up366.mobile.common.crash.CrashLevelHandlingStrategy<T> strategy = this.registry.getStrategy(str);
        if (strategy != null) {
            strategy.handleCrash(t);
            return;
        }
        com.up366.common.log.Logger.error("TAG - CrashLevelHandlerContext - handleCrash - strategy not found, crashType: " + str);
    }

    public <T> java.lang.String getCrashLevelSummary(java.lang.String str) {
        com.up366.mobile.common.crash.CrashLevelHandlingStrategy<T> strategy = this.registry.getStrategy(str);
        if (strategy != null) {
            return strategy.getCrashLevelSummary(str);
        }
        com.up366.common.log.Logger.error("TAG - CrashLevelHandlerContext - getCrashLevelSummary - strategy not found, crashType: " + str);
        return "";
    }

    public <T> void registerCustomStrategy(com.up366.mobile.common.crash.CrashLevelHandlingStrategy<T> crashLevelHandlingStrategy) {
        this.registry.registerStrategy(crashLevelHandlingStrategy);
    }
}
