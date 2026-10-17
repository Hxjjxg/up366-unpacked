package com.up366.mobile.course.photoanswer.logic.helper;

/* JADX INFO: compiled from: PhotoAnswerNetDataHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0001J0\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bH\u0002J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0002¨\u0006\u0010"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/helper/PhotoAnswerNetDataHelper;", "", "<init>", "()V", "fetchLayoutInfoSync", "Lcom/up366/common/http/NetHolder;", "Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerLayoutInfo;", "layoutId", "", "checkLayoutIdSync", "Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerCheckResult;", "data", com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, "paperId", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerNetDataHelper {
    public static final com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper INSTANCE = new com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper();

    private PhotoAnswerNetDataHelper() {
    }

    public final com.up366.common.http.NetHolder<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerLayoutInfo> fetchLayoutInfoSync(final java.lang.String layoutId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(layoutId, "layoutId");
        com.up366.common.http.NetHolder<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerLayoutInfo> netHolderPostSync = com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.FETCH_LAYOUT_INFO).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper.fetchLayoutInfoSync$lambda$0(layoutId, map);
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper$$ExternalSyntheticLambda3
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper.fetchLayoutInfoSync$lambda$1(response, str);
            }
        }));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(netHolderPostSync, "postSync(...)");
        return netHolderPostSync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchLayoutInfoSync$lambda$0(java.lang.String str, java.util.Map map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "params");
        map.put("layoutId", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerLayoutInfo fetchLayoutInfoSync$lambda$1(com.up366.common.http.Response response, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(response, "<unused var>");
        com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerLayoutInfo photoAnswerLayoutInfo = (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerLayoutInfo) com.up366.mobile.common.utils.ResponseUtil.parseObject(str, com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerLayoutInfo.class);
        com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.setPaperCount(photoAnswerLayoutInfo.getLayoutJson());
        return photoAnswerLayoutInfo;
    }

    public final com.up366.common.http.NetHolder<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerCheckResult> checkLayoutIdSync(java.lang.String layoutId, java.lang.Object data) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(layoutId, "layoutId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof com.up366.mobile.course.photoanswer.model.ScanPaperModel) {
            java.lang.String paperId = ((com.up366.mobile.course.photoanswer.model.ScanPaperModel) data).getPaperId();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(paperId, "getPaperId(...)");
            return checkLayoutIdSync(layoutId, paperId);
        }
        com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 = (com.up366.mobile.course.task.TaskInfoV2) data;
        java.lang.String jobId = taskInfoV2.getJobId();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jobId, "getJobId(...)");
        java.lang.String strValueOf = java.lang.String.valueOf(taskInfoV2.getCourseId());
        java.lang.String contentId = taskInfoV2.getContentId();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(contentId, "getContentId(...)");
        return checkLayoutIdSync(layoutId, jobId, strValueOf, contentId);
    }

    static /* synthetic */ com.up366.common.http.NetHolder checkLayoutIdSync$default(com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper photoAnswerNetDataHelper, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, java.lang.Object obj) {
        if ((i & 8) != 0) {
            str4 = "";
        }
        return photoAnswerNetDataHelper.checkLayoutIdSync(str, str2, str3, str4);
    }

    private final com.up366.common.http.NetHolder<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerCheckResult> checkLayoutIdSync(final java.lang.String layoutId, final java.lang.String studyTaskId, final java.lang.String courseId, final java.lang.String taskId) throws java.lang.InterruptedException {
        com.up366.common.http.NetHolder<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerCheckResult> netHolderPostSync = com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.CHECK_LAYOUT).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper$$ExternalSyntheticLambda4
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper.checkLayoutIdSync$lambda$2(layoutId, studyTaskId, courseId, taskId, map);
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper$$ExternalSyntheticLambda5
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper.checkLayoutIdSync$lambda$3(response, str);
            }
        }));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(netHolderPostSync, "postSync(...)");
        return netHolderPostSync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkLayoutIdSync$lambda$2(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.util.Map map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "params");
        map.put("layoutId", str);
        map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, str2);
        map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, str3);
        map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerCheckResult checkLayoutIdSync$lambda$3(com.up366.common.http.Response response, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(response, "<unused var>");
        return (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerCheckResult) com.up366.mobile.common.utils.ResponseUtil.parseObject(str, com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerCheckResult.class);
    }

    private final com.up366.common.http.NetHolder<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerCheckResult> checkLayoutIdSync(final java.lang.String layoutId, final java.lang.String paperId) throws java.lang.InterruptedException {
        com.up366.common.http.NetHolder<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerCheckResult> netHolderPostSync = com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.CHECK_LAYOUT_V2).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper.checkLayoutIdSync$lambda$4(layoutId, paperId, map);
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper.checkLayoutIdSync$lambda$5(response, str);
            }
        }));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(netHolderPostSync, "postSync(...)");
        return netHolderPostSync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkLayoutIdSync$lambda$4(java.lang.String str, java.lang.String str2, java.util.Map map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "params");
        map.put("layoutId", str);
        map.put("paperId", str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerCheckResult checkLayoutIdSync$lambda$5(com.up366.common.http.Response response, java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(response, "<unused var>");
        return (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerCheckResult) com.up366.mobile.common.utils.ResponseUtil.parseObject(str, com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerCheckResult.class);
    }
}
