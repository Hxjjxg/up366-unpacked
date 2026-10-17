package com.up366.mobile.common.logic;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MeBookMgr {
    private final com.up366.greendao.DaoSession db;
    private final com.up366.mobile.common.logic.Manager manager;

    public MeBookMgr(com.up366.mobile.common.logic.Manager manager) {
        this.manager = manager;
        this.db = manager.db();
    }

    public void loadMyBooks() {
        loadMyBooks(null);
    }

    public void loadMyBooks(final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.event.MyBookListEvent> iCallbackCodeInfoObj) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.MeBookMgr$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$loadMyBooks$1(iCallbackCodeInfoObj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadMyBooks$1(final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj) throws java.lang.Exception {
        final com.up366.mobile.common.event.MyBookListEvent myBookListEvent = new com.up366.mobile.common.event.MyBookListEvent(com.up366.mobile.me.book.MyBookListUtils.buildMyBooks(), this.db.getCourseInfoDao().queryBuilder().list());
        com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync(com.up366.mobile.common.utils.AppCacheKeysUtils.MINE_BOOK_LIST_EVENT, myBookListEvent, 86400000L);
        if (iCallbackCodeInfoObj != null) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.MeBookMgr$$ExternalSyntheticLambda6
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackCodeInfoObj.onResult(0, "", myBookListEvent);
                }
            });
        } else {
            com.up366.common.EventBusUtilsUp.post(myBookListEvent);
        }
    }

    public void fetchMyBooks() {
        fetchMyBooks(null);
    }

    public void fetchMyBooks(final com.up366.common.callback.ICallbackResponse<com.up366.mobile.common.event.MyBookListEvent> iCallbackResponse) {
        com.up366.mobile.common.utils.TaskChainTool taskChainToolQuery = new com.up366.mobile.common.utils.TaskChainTool().query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.common.logic.MeBookMgr$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
            public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                com.up366.mobile.common.logic.MeBookMgr.lambda$fetchMyBooks$2(iReturnOps);
            }
        }).query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.common.logic.MeBookMgr$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
            public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                com.up366.mobile.common.logic.MeBookMgr.lambda$fetchMyBooks$3(iReturnOps);
            }
        });
        taskChainToolQuery.doQueryParallel();
        taskChainToolQuery.onSuccess(new com.up366.mobile.common.utils.TaskChainTool.ISuccessCallback() { // from class: com.up366.mobile.common.logic.MeBookMgr$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.utils.TaskChainTool.ISuccessCallback
            public final void success(int i, java.lang.String str, java.lang.Object[] objArr) {
                com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.MeBookMgr$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        com.up366.mobile.common.logic.MeBookMgr.lambda$fetchMyBooks$5(objArr, i, str, iCallbackResponse);
                    }
                });
            }
        });
        taskChainToolQuery.onError(new com.up366.mobile.common.utils.TaskChainTool.IErrorCallback() { // from class: com.up366.mobile.common.logic.MeBookMgr$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.utils.TaskChainTool.IErrorCallback
            public final void error(int i, java.lang.String str) {
                com.up366.mobile.common.logic.MeBookMgr.lambda$fetchMyBooks$8(iCallbackResponse, i, str);
            }
        });
    }

    static /* synthetic */ void lambda$fetchMyBooks$2(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        com.up366.mobile.book.BookMgr bookMgrBook = com.up366.mobile.common.logic.Auth.cur().book();
        java.util.Objects.requireNonNull(iReturnOps);
        bookMgrBook.fetchMyProducts(new com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda11(iReturnOps));
    }

    static /* synthetic */ void lambda$fetchMyBooks$3(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        com.up366.mobile.course.mgr.CourseMgr courseMgrCourse = com.up366.mobile.common.logic.Auth.cur().course();
        java.util.Objects.requireNonNull(iReturnOps);
        courseMgrCourse.fetchCourseList(new com.up366.mobile.book.BookMgr$$ExternalSyntheticLambda11(iReturnOps));
    }

    static /* synthetic */ void lambda$fetchMyBooks$5(java.lang.Object[] objArr, int i, java.lang.String str, final com.up366.common.callback.ICallbackResponse iCallbackResponse) throws java.lang.Exception {
        java.util.List<com.up366.mobile.common.logic.model.MyBook> listBuildMyBooks = com.up366.mobile.me.book.MyBookListUtils.buildMyBooks();
        java.util.List list = (java.util.List) objArr[1];
        final com.up366.common.http.Response response = new com.up366.common.http.Response(i, "", str, listBuildMyBooks.size(), null);
        final com.up366.mobile.common.event.MyBookListEvent myBookListEvent = new com.up366.mobile.common.event.MyBookListEvent(response, listBuildMyBooks, list);
        com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync(com.up366.mobile.common.utils.AppCacheKeysUtils.MINE_BOOK_LIST_EVENT, myBookListEvent, 86400000L);
        if (iCallbackResponse != null) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.MeBookMgr$$ExternalSyntheticLambda8
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackResponse.onResult(response, myBookListEvent);
                }
            });
        } else {
            com.up366.common.EventBusUtilsUp.post(myBookListEvent);
        }
    }

    static /* synthetic */ void lambda$fetchMyBooks$8(final com.up366.common.callback.ICallbackResponse iCallbackResponse, int i, java.lang.String str) {
        final com.up366.common.http.Response response = new com.up366.common.http.Response(i, "", str, 0, null);
        final com.up366.mobile.common.event.MyBookListEvent myBookListEvent = new com.up366.mobile.common.event.MyBookListEvent(response, new java.util.ArrayList(), new java.util.ArrayList());
        if (iCallbackResponse != null) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.MeBookMgr$$ExternalSyntheticLambda7
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackResponse.onResult(response, myBookListEvent);
                }
            });
        } else {
            com.up366.common.EventBusUtilsUp.post(myBookListEvent);
        }
    }

    public boolean checkCourseBookData() {
        return this.db.getCourseBookInfoDao().loadAll().isEmpty();
    }
}
