package com.up366.mobile.common.logic;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppCacheMgr {
    private final com.up366.mobile.common.logic.Manager manager;
    private final java.util.Map<java.lang.String, java.lang.ref.SoftReference<com.up366.mobile.common.logic.model.AppCacheInfo>> map = new java.util.HashMap();

    public interface ICallbackCache<T> {
        void onLoad(T t);
    }

    static /* synthetic */ void lambda$put$0(int i) {
    }

    public AppCacheMgr(com.up366.mobile.common.logic.Manager manager) {
        this.manager = manager;
    }

    public void put(java.lang.String str, java.lang.Object obj, long j) {
        put(str, obj, j, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.common.logic.AppCacheMgr$$ExternalSyntheticLambda1
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                com.up366.mobile.common.logic.AppCacheMgr.lambda$put$0(i);
            }
        });
    }

    public void put(java.lang.String str, java.lang.Object obj, long j, final com.up366.common.callback.ICallbackCode iCallbackCode) {
        final com.up366.mobile.common.logic.model.AppCacheInfo appCacheInfo = new com.up366.mobile.common.logic.model.AppCacheInfo(str, obj, j);
        this.map.put(str, new java.lang.ref.SoftReference<>(appCacheInfo));
        final java.lang.Object[] objArr = {appCacheInfo};
        com.up366.common.task.TaskUtils.postLazyTaskGlobal("cache-" + str, (int) j, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.AppCacheMgr$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.logic.AppCacheMgr.lambda$put$1(objArr);
            }
        });
        java.lang.Object arrayList = obj instanceof java.util.ArrayList ? new java.util.ArrayList((java.util.ArrayList) obj) : obj;
        if (obj instanceof java.util.HashMap) {
            arrayList = new java.util.HashMap((java.util.HashMap) obj);
        }
        final java.lang.Object obj2 = arrayList;
        final com.up366.common.task.StackRecordException stackRecordException = new com.up366.common.task.StackRecordException();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.AppCacheMgr$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$put$2(appCacheInfo, obj2, iCallbackCode, stackRecordException);
            }
        });
    }

    static /* synthetic */ void lambda$put$1(java.lang.Object[] objArr) throws java.lang.Exception {
        objArr[0] = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$put$2(com.up366.mobile.common.logic.model.AppCacheInfo appCacheInfo, java.lang.Object obj, com.up366.common.callback.ICallbackCode iCallbackCode, com.up366.common.task.StackRecordException stackRecordException) throws java.lang.Exception {
        try {
            appCacheInfo.setInfo(com.alibaba.fastjson.JSON.toJSONString(obj));
            appCacheInfo.setUpdateTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
            this.manager.db1().saveOrUpdate(appCacheInfo);
            iCallbackCode.onResult(0);
        } catch (java.lang.Exception e) {
            e.addSuppressed(stackRecordException);
            com.up366.common.log.Logger.error("TAG - AppCacheMgr - put - error ", e);
            iCallbackCode.onResult(-1);
        }
    }

    public void putMemorySync(final java.lang.String str, java.lang.Object obj, long j) {
        com.up366.mobile.common.logic.model.AppCacheInfo appCacheInfo = new com.up366.mobile.common.logic.model.AppCacheInfo(str, obj, j);
        this.map.put(str, new java.lang.ref.SoftReference<>(appCacheInfo));
        final java.lang.Object[] objArr = {appCacheInfo};
        com.up366.common.task.TaskUtils.postLazyTaskGlobal("cache-" + str, (int) java.lang.Math.min(2147483647L, j), new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.AppCacheMgr$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$putMemorySync$3(objArr, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$putMemorySync$3(java.lang.Object[] objArr, java.lang.String str) throws java.lang.Exception {
        objArr[0] = null;
        this.map.remove(str);
    }

    public void loadString(java.lang.String str, com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache<java.lang.String> iCallbackCache) {
        load(str, java.lang.String.class, iCallbackCache);
    }

    public void loadInteger(java.lang.String str, com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache<java.lang.Integer> iCallbackCache) {
        load(str, java.lang.Integer.class, iCallbackCache);
    }

    public void clearSync(java.lang.String str) {
        this.map.remove(str);
        this.manager.db1().delete(com.up366.mobile.common.logic.model.AppCacheInfo_.key, str);
    }

    public void clear(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.AppCacheMgr$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$clear$4(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clear$4(java.lang.String str) throws java.lang.Exception {
        this.map.remove(str);
        this.manager.db1().delete(com.up366.mobile.common.logic.model.AppCacheInfo_.key, str);
    }

    public <T> void load(java.lang.String str, com.alibaba.fastjson.TypeReference<T> typeReference, com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache<T> iCallbackCache) {
        loadImpl(str, typeReference, iCallbackCache);
    }

    public <T> void load(java.lang.String str, java.lang.Class<T> cls, com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache<T> iCallbackCache) {
        loadImpl(str, cls, iCallbackCache);
    }

    public <T> T loadSync(java.lang.String str, com.alibaba.fastjson.TypeReference<T> typeReference) {
        try {
            return (T) loadImplSync(str, typeReference);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - AppCacheMgr - loadSync - ", e);
            return null;
        }
    }

    public <T> T loadSync(java.lang.String str, java.lang.Class<T> cls) {
        try {
            return (T) loadImplSync(str, cls);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - AppCacheMgr - loadSync - ", e);
            return null;
        }
    }

    public <T> T loadMemorySync(java.lang.String str) {
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        java.lang.ref.SoftReference<com.up366.mobile.common.logic.model.AppCacheInfo> softReference = this.map.get(str);
        if (softReference == null) {
            return null;
        }
        com.up366.mobile.common.logic.model.AppCacheInfo appCacheInfo = softReference.get();
        if (appCacheInfo != null && appCacheInfo.getExpireTime() > currentNtpTimeInMillisecond) {
            if (appCacheInfo.getMemoryHolder() != null) {
                return (T) appCacheInfo.getMemoryHolder();
            }
            return null;
        }
        this.map.remove(str);
        return null;
    }

    private <T> void loadImpl(final java.lang.String str, final java.lang.Object obj, final com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache<T> iCallbackCache) {
        final com.up366.common.task.StackRecordException stackRecordException = new com.up366.common.task.StackRecordException();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.AppCacheMgr$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$loadImpl$7(str, obj, stackRecordException, iCallbackCache);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadImpl$7(java.lang.String str, java.lang.Object obj, com.up366.common.task.StackRecordException stackRecordException, final com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache iCallbackCache) throws java.lang.Exception {
        try {
            final java.lang.Object objLoadImplSync = loadImplSync(str, obj);
            com.up366.common.task.TaskUtils.postMainTaskWithStackRecord(stackRecordException, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.AppCacheMgr$$ExternalSyntheticLambda4
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackCache.onLoad(objLoadImplSync);
                }
            });
        } catch (java.lang.Exception e) {
            e.addSuppressed(stackRecordException);
            com.up366.common.log.Logger.error("TAG - AppCacheMgr - loadImpl - error ", e);
            com.up366.common.task.TaskUtils.postMainTaskWithStackRecord(stackRecordException, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.AppCacheMgr$$ExternalSyntheticLambda5
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackCache.onLoad(null);
                }
            });
        }
    }

    private <T> T loadImplSync(java.lang.String str, java.lang.Object obj) {
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        java.lang.ref.SoftReference<com.up366.mobile.common.logic.model.AppCacheInfo> softReference = this.map.get(str);
        if (softReference == null || softReference.get() == null) {
            return (T) loadFromDb(str, obj, currentNtpTimeInMillisecond);
        }
        com.up366.mobile.common.logic.model.AppCacheInfo appCacheInfo = softReference.get();
        if (appCacheInfo.getExpireTime() > currentNtpTimeInMillisecond) {
            if (appCacheInfo.getMemoryHolder() == null) {
                appCacheInfo.buildMemoryHolder(obj);
            }
            return (T) appCacheInfo.getMemoryHolder();
        }
        clearSync(str);
        return null;
    }

    private <T> T loadFromDb(java.lang.String str, java.lang.Object obj, long j) {
        com.up366.mobile.common.logic.model.AppCacheInfo appCacheInfo = (com.up366.mobile.common.logic.model.AppCacheInfo) this.manager.db1().findOne(com.up366.mobile.common.logic.model.AppCacheInfo_.key, str);
        if (appCacheInfo == null) {
            return null;
        }
        if (appCacheInfo.getExpireTime() > j) {
            appCacheInfo.buildMemoryHolder(obj);
            this.map.put(str, new java.lang.ref.SoftReference<>(appCacheInfo));
            return (T) appCacheInfo.getMemoryHolder();
        }
        clearSync(str);
        return null;
    }

    public void put(java.lang.String str, java.lang.Object obj) {
        java.lang.String jSONString = com.alibaba.fastjson.JSON.toJSONString(obj);
        com.up366.mobile.common.logic.model.AppCacheInfo appCacheInfo = new com.up366.mobile.common.logic.model.AppCacheInfo(str, obj, Long.MAX_VALUE);
        appCacheInfo.setInfo(jSONString);
        putMemorySync(str, obj, Long.MAX_VALUE);
        this.manager.db1().saveOrUpdate(appCacheInfo);
    }

    public <T> T get(java.lang.String str, com.alibaba.fastjson.TypeReference<T> typeReference, T t) {
        return (T) getImpl(str, typeReference, t);
    }

    public <T> T get(java.lang.String str, java.lang.Class<T> cls, T t) {
        return (T) getImpl(str, cls, t);
    }

    private <T> T getImpl(java.lang.String str, java.lang.Object obj, T t) {
        com.up366.mobile.common.logic.model.AppCacheInfo appCacheInfo = (com.up366.mobile.common.logic.model.AppCacheInfo) this.manager.db1().findOne(com.up366.mobile.common.logic.model.AppCacheInfo_.key, str);
        if (appCacheInfo == null) {
            return t;
        }
        appCacheInfo.buildMemoryHolder(obj);
        this.map.put(str, new java.lang.ref.SoftReference<>(appCacheInfo));
        return (T) appCacheInfo.getMemoryHolder();
    }
}
