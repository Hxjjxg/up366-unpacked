package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TaskChainTool {
    private int resultCode;
    private java.lang.String resultInfo;
    private volatile boolean isQuerying = false;
    private volatile boolean isSuccess = false;
    private volatile boolean isError = false;
    private java.util.List<com.up366.mobile.common.utils.TaskChainTool.IQueryObject> queryList = java.util.Collections.synchronizedList(new java.util.ArrayList());
    private java.util.List<com.up366.mobile.common.utils.TaskChainTool.ISuccessCallback> successList = java.util.Collections.synchronizedList(new java.util.ArrayList());
    private java.util.List<com.up366.mobile.common.utils.TaskChainTool.IErrorCallback> errorList = java.util.Collections.synchronizedList(new java.util.ArrayList());
    private java.util.List<java.lang.Object> resultList = java.util.Collections.synchronizedList(new java.util.ArrayList());

    public interface IErrorCallback {
        void error(int i, java.lang.String str);
    }

    public interface IQueryObject {
        void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps);
    }

    public interface IReturnOps {
        void error(int i, java.lang.String str);

        void onResponse(int i, java.lang.String str, java.lang.Object obj);

        void onResponse(com.up366.common.http.Response response, java.lang.Object obj);

        void success();
    }

    public interface ISuccessCallback {
        void success(int i, java.lang.String str, java.lang.Object[] objArr);
    }

    public com.up366.mobile.common.utils.TaskChainTool query(com.up366.mobile.common.utils.TaskChainTool.IQueryObject iQueryObject) {
        this.queryList.add(iQueryObject);
        return this;
    }

    public com.up366.mobile.common.utils.TaskChainTool onSuccess(com.up366.mobile.common.utils.TaskChainTool.ISuccessCallback iSuccessCallback) {
        this.successList.add(iSuccessCallback);
        doQuery();
        return this;
    }

    public com.up366.mobile.common.utils.TaskChainTool onError(com.up366.mobile.common.utils.TaskChainTool.IErrorCallback iErrorCallback) {
        this.errorList.add(iErrorCallback);
        doQuery();
        return this;
    }

    public void doQueryParallel() {
        if (this.isError) {
            while (this.errorList.size() > 0) {
                this.errorList.remove(0).error(this.resultCode, this.resultInfo);
            }
            return;
        }
        if (this.isSuccess || this.queryList.size() == 0) {
            while (this.successList.size() > 0) {
                this.successList.remove(0).success(this.resultCode, this.resultInfo, this.resultList.toArray());
            }
            return;
        }
        this.isQuerying = true;
        final java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger(this.queryList.size());
        final java.lang.Object[] objArr = new java.lang.Object[this.queryList.size()];
        for (final int i = 0; i < this.queryList.size(); i++) {
            this.queryList.get(i).query(new com.up366.mobile.common.utils.TaskChainTool.IReturnOps() { // from class: com.up366.mobile.common.utils.TaskChainTool.1
                @Override // com.up366.mobile.common.utils.TaskChainTool.IReturnOps
                public void success() {
                    com.up366.mobile.common.utils.TaskChainTool.this.isQuerying = false;
                    com.up366.mobile.common.utils.TaskChainTool.this.isSuccess = true;
                    com.up366.mobile.common.utils.TaskChainTool.this.resultList.addAll(java.util.Arrays.asList(objArr));
                    com.up366.mobile.common.utils.TaskChainTool.this.doQuery();
                }

                @Override // com.up366.mobile.common.utils.TaskChainTool.IReturnOps
                public void error(int i2, java.lang.String str) {
                    com.up366.mobile.common.utils.TaskChainTool.this.isQuerying = false;
                    com.up366.mobile.common.utils.TaskChainTool.this.isError = true;
                    com.up366.mobile.common.utils.TaskChainTool.this.resultCode = i2;
                    com.up366.mobile.common.utils.TaskChainTool.this.resultInfo = str;
                    com.up366.mobile.common.utils.TaskChainTool.this.doQuery();
                }

                @Override // com.up366.mobile.common.utils.TaskChainTool.IReturnOps
                public void onResponse(int i2, java.lang.String str, java.lang.Object obj) {
                    if (com.up366.mobile.common.utils.TaskChainTool.this.isError || com.up366.mobile.common.utils.TaskChainTool.this.isSuccess) {
                        return;
                    }
                    if (i2 != 0) {
                        error(i2, str);
                        return;
                    }
                    objArr[i] = obj;
                    if (atomicInteger.decrementAndGet() == 0) {
                        success();
                    }
                }

                @Override // com.up366.mobile.common.utils.TaskChainTool.IReturnOps
                public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                    if (com.up366.mobile.common.utils.TaskChainTool.this.isError || com.up366.mobile.common.utils.TaskChainTool.this.isSuccess) {
                        return;
                    }
                    if (response.isError()) {
                        error(response.getCode(), response.getInfo());
                        return;
                    }
                    objArr[i] = obj;
                    if (atomicInteger.decrementAndGet() == 0) {
                        success();
                    }
                }
            });
        }
        this.queryList.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doQuery() {
        if (this.isQuerying) {
            return;
        }
        if (this.isError) {
            while (this.errorList.size() > 0) {
                this.errorList.remove(0).error(this.resultCode, this.resultInfo);
            }
        } else if (this.isSuccess || this.queryList.size() == 0) {
            while (this.successList.size() > 0) {
                this.successList.remove(0).success(this.resultCode, this.resultInfo, this.resultList.toArray());
            }
        } else {
            this.isQuerying = true;
            this.queryList.remove(0).query(new com.up366.mobile.common.utils.TaskChainTool.IReturnOps() { // from class: com.up366.mobile.common.utils.TaskChainTool.2
                @Override // com.up366.mobile.common.utils.TaskChainTool.IReturnOps
                public void success() {
                    com.up366.mobile.common.utils.TaskChainTool.this.isSuccess = true;
                    com.up366.mobile.common.utils.TaskChainTool.this.isQuerying = false;
                    com.up366.mobile.common.utils.TaskChainTool.this.doQuery();
                }

                @Override // com.up366.mobile.common.utils.TaskChainTool.IReturnOps
                public void error(int i, java.lang.String str) {
                    com.up366.mobile.common.utils.TaskChainTool.this.isError = true;
                    com.up366.mobile.common.utils.TaskChainTool.this.isQuerying = false;
                    com.up366.mobile.common.utils.TaskChainTool.this.resultCode = i;
                    com.up366.mobile.common.utils.TaskChainTool.this.resultInfo = str;
                    com.up366.mobile.common.utils.TaskChainTool.this.doQuery();
                }

                @Override // com.up366.mobile.common.utils.TaskChainTool.IReturnOps
                public void onResponse(int i, java.lang.String str, java.lang.Object obj) {
                    com.up366.mobile.common.utils.TaskChainTool.this.isQuerying = false;
                    if (com.up366.mobile.common.utils.TaskChainTool.this.isError || com.up366.mobile.common.utils.TaskChainTool.this.isSuccess) {
                        return;
                    }
                    if (i != 0) {
                        error(i, str);
                    } else {
                        com.up366.mobile.common.utils.TaskChainTool.this.resultList.add(obj);
                        com.up366.mobile.common.utils.TaskChainTool.this.doQuery();
                    }
                }

                @Override // com.up366.mobile.common.utils.TaskChainTool.IReturnOps
                public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                    com.up366.mobile.common.utils.TaskChainTool.this.isQuerying = false;
                    if (com.up366.mobile.common.utils.TaskChainTool.this.isError || com.up366.mobile.common.utils.TaskChainTool.this.isSuccess) {
                        return;
                    }
                    if (response.isError()) {
                        error(response.getCode(), response.getInfo());
                    } else {
                        com.up366.mobile.common.utils.TaskChainTool.this.resultList.add(obj);
                        com.up366.mobile.common.utils.TaskChainTool.this.doQuery();
                    }
                }
            });
        }
    }
}
