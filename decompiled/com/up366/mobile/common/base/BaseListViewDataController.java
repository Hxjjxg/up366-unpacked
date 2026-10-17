package com.up366.mobile.common.base;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BaseListViewDataController<T> {
    private com.up366.mobile.common.base.BaseRecyclerAdapter adapter;
    private com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback afterCallBack;
    private com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback beforeCallback;
    private boolean enable;
    com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback errorDataCallback;
    private com.up366.mobile.common.base.BaseListViewDataController.ISetDataFilterCallback filterDataCallback;
    com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback footerDataCallback;
    private com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback<T> isSameItemCallback;
    private com.up366.mobile.common.base.BaseListViewDataController last;
    private com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback loadingViewCallback;
    private com.up366.mobile.common.base.BaseListViewDataController.IDataLoader localLoader;
    private com.up366.mobile.common.base.BaseListViewDataController next;
    com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback noDataViewCallback;
    private java.lang.Runnable notify;
    private com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback onCompleteCallback;
    private com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback<T> realDataCallback;
    protected boolean renderInOnLoadWebData;
    private com.up366.common.http.Response resp;
    private boolean reverse;
    com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback warnDataCallback;
    private com.up366.mobile.common.base.BaseListViewDataController.IDataLoader webLoader;
    private com.up366.mobile.common.base.BaseListViewDataController.IPagerLoader<T> webPagerLoader;
    private java.util.List<T> listDatas = new java.util.ArrayList();
    private int curPage = -1;
    private int pageSize = 10;
    private boolean hasLoadLocalData = false;

    public interface IDataCallback {
        void setDatas(java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> list);
    }

    public interface IDataLoader {
        void load() throws java.lang.Exception;
    }

    public interface IOnCompleteCallback {
        void onComplete();
    }

    public interface IPagerLoader<T> {
        void load(int i, int i2, T t);
    }

    public interface ISetDataCallback {
        void setDatas(java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> list);
    }

    public interface ISetDataFilterCallback<T> {
        boolean filter(T t);
    }

    public interface ISetErrorDataCallback {
        void setDatas(com.up366.common.http.Response response, java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> list);
    }

    public interface ISetRealDataCallback<T> {
        void setDatas(java.util.List<T> list, java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> list2);
    }

    public interface IsSameItemCallback<T> {
        boolean isSame(T t, T t2);
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setEnable(boolean z) {
        com.up366.common.log.Logger.info("TAG - BaseListViewDataController - setEnable - enable = [" + z + "]");
        this.enable = z;
        if (z) {
            if (!this.hasLoadLocalData) {
                render(null);
                loadLocalData();
            } else {
                render(null);
                com.up366.common.http.Response response = this.resp;
                if (response != null && response.isError()) {
                    loadWebData();
                }
            }
        }
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setLoadingView(com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback iSetDataCallback) {
        this.loadingViewCallback = iSetDataCallback;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setNoDataView(com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback iSetDataCallback) {
        this.noDataViewCallback = iSetDataCallback;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setWarnView(com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback iSetErrorDataCallback) {
        this.warnDataCallback = iSetErrorDataCallback;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setErrorView(com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback iSetErrorDataCallback) {
        this.errorDataCallback = iSetErrorDataCallback;
        return this;
    }

    public void setFooterDataCallback(com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback iSetErrorDataCallback) {
        this.footerDataCallback = iSetErrorDataCallback;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setFilterData(com.up366.mobile.common.base.BaseListViewDataController.ISetDataFilterCallback<T> iSetDataFilterCallback) {
        this.filterDataCallback = iSetDataFilterCallback;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setDataView(com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback<T> iSetRealDataCallback) {
        this.realDataCallback = iSetRealDataCallback;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setBeforeRender(com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback iSetDataCallback) {
        this.beforeCallback = iSetDataCallback;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setAfterRender(com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback iSetDataCallback) {
        this.afterCallBack = iSetDataCallback;
        return this;
    }

    private void fullListDataUnique(java.util.List<T> list, java.util.List<T> list2) {
        if (this.isSameItemCallback == null) {
            list.addAll(list2);
            return;
        }
        for (int i = 0; i < list2.size(); i++) {
            int i2 = 0;
            while (true) {
                if (i2 < list.size()) {
                    if (this.isSameItemCallback.isSame(list.get(i2), list2.get(i))) {
                        list.set(i2, list2.get(i));
                        break;
                    }
                    i2++;
                } else {
                    list.add(list2.get(i));
                    break;
                }
            }
        }
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setLocalLoader(com.up366.mobile.common.base.BaseListViewDataController.IDataLoader iDataLoader) {
        this.localLoader = iDataLoader;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setWebLoader(com.up366.mobile.common.base.BaseListViewDataController.IDataLoader iDataLoader) {
        this.webLoader = iDataLoader;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setWebPagerLoader(com.up366.mobile.common.base.BaseListViewDataController.IPagerLoader<T> iPagerLoader) {
        this.webPagerLoader = iPagerLoader;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setPageSize(int i) {
        this.pageSize = i;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setIsSameItem(com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback<T> isSameItemCallback) {
        this.isSameItemCallback = isSameItemCallback;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setOnCompleteCallback(com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback iOnCompleteCallback) {
        this.onCompleteCallback = iOnCompleteCallback;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setAdapter(com.up366.mobile.common.base.BaseRecyclerAdapter baseRecyclerAdapter) {
        this.adapter = baseRecyclerAdapter;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> setNotify(java.lang.Runnable runnable) {
        this.notify = runnable;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> refresh() {
        if (!this.enable) {
            return this;
        }
        render(null);
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> reload() {
        this.hasLoadLocalData = false;
        this.listDatas.clear();
        this.resp = null;
        if (!this.enable) {
            return this;
        }
        render(null);
        loadLocalData();
        loadWebData();
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> reset() {
        this.hasLoadLocalData = false;
        this.listDatas.clear();
        this.resp = null;
        return this;
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> loadLocalData() {
        if (!this.enable) {
            return this;
        }
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.base.BaseListViewDataController$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$loadLocalData$0();
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadLocalData$0() throws java.lang.Exception {
        this.hasLoadLocalData = true;
        com.up366.mobile.common.base.BaseListViewDataController.IDataLoader iDataLoader = this.localLoader;
        if (iDataLoader != null) {
            iDataLoader.load();
        }
    }

    public com.up366.mobile.common.base.BaseListViewDataController<T> loadWebData() {
        if (!this.enable) {
            return this;
        }
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.base.BaseListViewDataController$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$loadWebData$1();
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadWebData$1() throws java.lang.Exception {
        com.up366.mobile.common.base.BaseListViewDataController.IDataLoader iDataLoader = this.webLoader;
        if (iDataLoader != null) {
            iDataLoader.load();
        }
        com.up366.mobile.common.base.BaseListViewDataController.IPagerLoader<T> iPagerLoader = this.webPagerLoader;
        if (iPagerLoader != null) {
            this.curPage = 1;
            iPagerLoader.load(1, this.pageSize, null);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public com.up366.mobile.common.base.BaseListViewDataController<T> loadNextPageData() {
        T t;
        com.up366.mobile.common.utils.ResponseUtil.Pager page;
        if (!this.enable) {
            return this;
        }
        int size = (this.listDatas.size() / this.pageSize) + 1;
        this.curPage = size;
        if (size > 1) {
            java.util.List<T> list = this.listDatas;
            t = list.get(list.size() - 1);
        } else {
            t = null;
        }
        com.up366.common.http.Response response = this.resp;
        if (response != null && (page = com.up366.mobile.common.utils.ResponseUtil.getPage(response)) != null) {
            this.curPage = page.getCurrentPage() + 1;
        }
        com.up366.mobile.common.base.BaseListViewDataController.IPagerLoader<T> iPagerLoader = this.webPagerLoader;
        if (iPagerLoader != null) {
            iPagerLoader.load(this.curPage, this.pageSize, t);
            return this;
        }
        throw new java.lang.IllegalStateException("需要先设置 webPagerLoader");
    }

    public void onLoadLocalData(T t) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (t != null) {
            arrayList.add(t);
        }
        onLoadLocalData((java.util.List) arrayList);
    }

    public void onLoadLocalData(final java.util.List<T> list) {
        com.up366.common.log.Logger.info("TAG - BaseListViewDataController - onLoadLocalData - ");
        this.listDatas = list;
        if (this.enable) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.base.BaseListViewDataController$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onLoadLocalData$2(list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLoadLocalData$2(java.util.List list) throws java.lang.Exception {
        render(null);
        if (this.onCompleteCallback != null) {
            if (list.size() > 0 || (this.webLoader == null && this.webPagerLoader == null)) {
                this.onCompleteCallback.onComplete();
            }
        }
    }

    public void onLoadWebData(com.up366.common.http.Response response, T t) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(t);
        onLoadWebData(response, (java.util.List) arrayList);
    }

    public void onLoadWebData(com.up366.common.http.Response response, java.util.List<T> list) {
        com.up366.common.log.Logger.info("TAG - BaseListViewDataController - onLoadWebData - ");
        if (this.resp == null && !response.isError()) {
            this.listDatas.clear();
        }
        if (this.webPagerLoader != null && this.curPage == 1 && !response.isError()) {
            this.listDatas.clear();
        }
        this.resp = response;
        if (list != null) {
            if (this.webPagerLoader != null) {
                fullListDataUnique(this.listDatas, list);
            } else if (!response.isError()) {
                this.listDatas = list;
            }
        }
        if (this.enable) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.base.BaseListViewDataController$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onLoadWebData$3();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLoadWebData$3() throws java.lang.Exception {
        this.renderInOnLoadWebData = true;
        render(null);
        this.renderInOnLoadWebData = false;
        com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback iOnCompleteCallback = this.onCompleteCallback;
        if (iOnCompleteCallback != null) {
            iOnCompleteCallback.onComplete();
        }
    }

    protected void render(final java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> list) {
        com.up366.common.http.Response response;
        if (this.enable) {
            if (list == null) {
                com.up366.mobile.common.base.BaseListViewDataController baseListViewDataController = this.last;
                if (baseListViewDataController != null) {
                    baseListViewDataController.render(null);
                    return;
                }
                list = new java.util.ArrayList<>();
            }
            java.util.List arrayList = new java.util.ArrayList();
            if (this.filterDataCallback != null) {
                for (T t : this.listDatas) {
                    if (this.filterDataCallback.filter(t)) {
                        arrayList.add(t);
                    }
                }
            } else {
                arrayList = this.listDatas;
            }
            com.up366.common.http.Response response2 = this.resp;
            if (response2 != null && response2.isError() && this.last == null && arrayList.size() != 0) {
                com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback iSetErrorDataCallback = this.warnDataCallback;
                if (iSetErrorDataCallback != null) {
                    iSetErrorDataCallback.setDatas(this.resp, list);
                } else {
                    com.up366.mobile.common.utils.ToastPopupUtil.show(this.resp.getInfo());
                }
            }
            com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback iSetDataCallback = this.beforeCallback;
            if (iSetDataCallback != null) {
                iSetDataCallback.setDatas(list);
            }
            if (this.resp == null && arrayList.size() == 0 && this.hasLoadLocalData) {
                if (this.webLoader == null && this.webPagerLoader == null) {
                    com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback iSetDataCallback2 = this.noDataViewCallback;
                    if (iSetDataCallback2 != null) {
                        iSetDataCallback2.setDatas(list);
                    }
                } else {
                    com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback iSetDataCallback3 = this.loadingViewCallback;
                    if (iSetDataCallback3 != null) {
                        iSetDataCallback3.setDatas(list);
                    }
                }
            } else if (this.resp != null || arrayList.size() != 0 || this.hasLoadLocalData) {
                com.up366.common.http.Response response3 = this.resp;
                if (response3 != null && response3.isError()) {
                    if (arrayList.size() == 0) {
                        com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback iSetErrorDataCallback2 = this.errorDataCallback;
                        if (iSetErrorDataCallback2 != null) {
                            iSetErrorDataCallback2.setDatas(this.resp, list);
                        }
                    } else {
                        com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback<T> iSetRealDataCallback = this.realDataCallback;
                        if (iSetRealDataCallback != null) {
                            iSetRealDataCallback.setDatas((java.util.List<T>) arrayList, list);
                        }
                    }
                } else {
                    com.up366.common.http.Response response4 = this.resp;
                    if (response4 != null && !response4.isError() && arrayList.size() == 0) {
                        com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback iSetDataCallback4 = this.noDataViewCallback;
                        if (iSetDataCallback4 != null) {
                            iSetDataCallback4.setDatas(list);
                        }
                    } else {
                        com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback<T> iSetRealDataCallback2 = this.realDataCallback;
                        if (iSetRealDataCallback2 != null) {
                            iSetRealDataCallback2.setDatas((java.util.List<T>) arrayList, list);
                        }
                    }
                }
            }
            com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback iSetDataCallback5 = this.afterCallBack;
            if (iSetDataCallback5 != null) {
                iSetDataCallback5.setDatas(list);
            }
            if (this.webPagerLoader != null && this.footerDataCallback != null && (response = this.resp) != null) {
                com.up366.mobile.common.utils.ResponseUtil.Pager page = com.up366.mobile.common.utils.ResponseUtil.getPage(response);
                if (((page.getTotalCount() != 0 && page.getTotalCount() >= this.pageSize) || this.resp.isError()) && arrayList.size() >= this.pageSize) {
                    this.footerDataCallback.setDatas(this.resp, list);
                }
            }
            com.up366.mobile.common.base.BaseListViewDataController baseListViewDataController2 = this.next;
            if (baseListViewDataController2 != null) {
                baseListViewDataController2.render(list);
                return;
            }
            if (this.reverse) {
                java.util.Collections.reverse(list);
            }
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.base.BaseListViewDataController$$ExternalSyntheticLambda4
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$render$4(list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$4(java.util.List list) throws java.lang.Exception {
        java.lang.Runnable runnable = this.notify;
        if (runnable != null) {
            this.adapter.setDatas(list, runnable);
        } else {
            this.adapter.lambda$setDatas$0(list);
        }
    }

    public com.up366.mobile.common.base.BaseListViewDataController pipe(com.up366.mobile.common.base.BaseListViewDataController baseListViewDataController) {
        if (this == baseListViewDataController) {
            throw new java.lang.IllegalStateException("this == next is not allowed!");
        }
        this.next = baseListViewDataController;
        baseListViewDataController.last = this;
        return baseListViewDataController;
    }

    public java.util.List<T> getRenderListData() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (this.filterDataCallback != null) {
            for (T t : this.listDatas) {
                if (this.filterDataCallback.filter(t)) {
                    arrayList.add(t);
                }
            }
            return arrayList;
        }
        return this.listDatas;
    }

    public java.util.List<T> getAllListData() {
        return this.listDatas;
    }

    public void destroy() {
        this.enable = false;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public boolean hasLoadedWebData() {
        return this.resp != null && this.listDatas.size() > 0;
    }

    public boolean hasLoadWebData() {
        return this.resp != null;
    }

    public void setReverse(boolean z) {
        this.reverse = z;
    }
}
