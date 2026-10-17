package com.up366.mobile.course.homework;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class HomeworkMgr {
    private static final java.lang.String KEY_FILEID_PAPERID = "__fileid__paperid__";
    private static final java.lang.String KEY_FILEID_PAPERID_DETAIL = "__fileid__paperid__detail__";
    private final com.up366.greendao.DaoSession db;
    private final com.up366.mobile.common.logic.Manager manager;

    public HomeworkMgr(com.up366.mobile.common.logic.Manager manager) {
        this.manager = manager;
        this.db = manager.db();
    }

    public void getDownInfoByPaperId(final java.lang.String str, final com.up366.common.callback.ICallbackResponse<com.up366.mobile.course.homework.model.PaperDownInfo> iCallbackResponse) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.homework.HomeworkMgr$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getDownInfoByPaperId$0(str, iCallbackResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDownInfoByPaperId$0(java.lang.String str, com.up366.common.callback.ICallbackResponse iCallbackResponse) throws java.lang.Exception {
        com.up366.common.http.NetHolder<com.up366.mobile.course.homework.model.PaperDownInfo> netHolderFetchDownInfoByPaperIdSync = fetchDownInfoByPaperIdSync(str);
        iCallbackResponse.onResult(netHolderFetchDownInfoByPaperIdSync.resp, netHolderFetchDownInfoByPaperIdSync.info);
    }

    public com.up366.common.http.NetHolder<com.up366.mobile.course.homework.model.PaperDownInfo> fetchDownInfoByPaperIdSync(final java.lang.String str) throws java.lang.InterruptedException {
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.getPaperDownInfo).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.course.homework.HomeworkMgr$$ExternalSyntheticLambda0
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                map.put("paperId", str);
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.course.homework.HomeworkMgr$$ExternalSyntheticLambda1
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                return this.f$0.lambda$fetchDownInfoByPaperIdSync$2(str, response, str2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.up366.mobile.course.homework.model.PaperDownInfo lambda$fetchDownInfoByPaperIdSync$2(java.lang.String str, com.up366.common.http.Response response, java.lang.String str2) {
        com.up366.mobile.course.homework.model.PaperDownInfo paperDownInfo = (com.up366.mobile.course.homework.model.PaperDownInfo) com.up366.mobile.common.utils.ResponseUtil.parseObject(str2, com.up366.mobile.course.homework.model.PaperDownInfo.class);
        java.lang.String fileId = paperDownInfo.getFileId();
        this.manager.cache().put(KEY_FILEID_PAPERID + str, fileId);
        this.manager.cache().putMemorySync(KEY_FILEID_PAPERID_DETAIL + fileId, paperDownInfo, 60000L);
        com.up366.mobile.common.logic.Auth.cur().db1().saveOrUpdate(new com.up366.mobile.book.model.BookResourceMapInfo(fileId, com.up366.mobile.book.helper.Tools.RESOURCE_TEST_CACHE_ID, new com.up366.mobile.book.helper.V8FilePathHelper().getResourceDir(fileId)));
        return paperDownInfo;
    }

    public com.up366.mobile.course.homework.model.PaperDownInfo loadPaperDownloadInfoFromCache(java.lang.String str) {
        return (com.up366.mobile.course.homework.model.PaperDownInfo) this.manager.cache().loadMemorySync(KEY_FILEID_PAPERID_DETAIL + str);
    }

    public void clearPaperDownloadInfoFromCache(java.lang.String str) {
        this.manager.cache().clear(KEY_FILEID_PAPERID_DETAIL + str);
    }

    public java.lang.String loadFileIdByPaperId(java.lang.String str) {
        return (java.lang.String) this.manager.cache().loadSync(KEY_FILEID_PAPERID + str, java.lang.String.class);
    }

    public void fetchUserAnswer(final java.lang.String str, final com.up366.common.callback.ICallbackResponse<com.up366.mobile.course.homework.model.AnswerDataOfTest> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<com.up366.mobile.course.homework.model.AnswerDataOfTest>(com.up366.mobile.common.http.HttpMgrUtils.getAnswerDataOfTest) { // from class: com.up366.mobile.course.homework.HomeworkMgr.1
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("testId", str);
                map.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public com.up366.mobile.course.homework.model.AnswerDataOfTest handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                return (com.up366.mobile.course.homework.model.AnswerDataOfTest) com.up366.mobile.common.utils.ResponseUtil.parseObject(str2, com.up366.mobile.course.homework.model.AnswerDataOfTest.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, com.up366.mobile.course.homework.model.AnswerDataOfTest answerDataOfTest) {
                iCallbackResponse.onResult(response, answerDataOfTest);
            }
        });
    }
}
