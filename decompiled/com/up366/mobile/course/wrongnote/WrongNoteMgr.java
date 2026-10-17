package com.up366.mobile.course.wrongnote;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WrongNoteMgr {
    private final com.up366.greendao.DaoSession db;
    private final com.up366.mobile.common.logic.Manager manager;

    public WrongNoteMgr(com.up366.mobile.common.logic.Manager manager) {
        this.manager = manager;
        this.db = manager.db();
    }

    public void fetchWrongNoteList(final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder, final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo>> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo>>(com.up366.mobile.common.http.HttpMgrUtils.selectSubjectListOfStudent) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.1
            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo> array = com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo.class);
                coursePageCountHolder.setWrongNoteNum(array.size());
                return array;
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteSubjectInfo> list) {
                super.onResponse(response, list);
                iCallbackResponse.onResult(response, list);
            }
        });
    }

    public com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo>> fetchWrongNoteDetailList(final com.up366.mobile.commonui.condition.ConditionModel conditionModel) throws java.lang.InterruptedException {
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.selectKnowledgeListOfStudent).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr$$ExternalSyntheticLambda6
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.course.wrongnote.WrongNoteMgr.lambda$fetchWrongNoteDetailList$0(conditionModel, map);
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr$$ExternalSyntheticLambda7
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.common.utils.ResponseUtil.parsePagerList(str, com.up366.mobile.course.wrongnote.modle.WrongNoteKnowledgeInfo.class);
            }
        }));
    }

    static /* synthetic */ void lambda$fetchWrongNoteDetailList$0(com.up366.mobile.commonui.condition.ConditionModel conditionModel, java.util.Map map) {
        map.put("stageId", java.lang.Integer.valueOf(conditionModel.getStageId()));
        map.put("subjectId", java.lang.Integer.valueOf(conditionModel.getSubjectId()));
        map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, conditionModel.getBookId());
        map.put("startTime", com.up366.mobile.common.utils.TimeUtilsApp.formatTime(conditionModel.getBeginTime(), "yyyy-MM-dd HH:mm:ss"));
        map.put("endTime", com.up366.mobile.common.utils.TimeUtilsApp.formatTime(conditionModel.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
    }

    public com.up366.common.http.NetHolder<com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo> fetchWrongNoteDetailStatList(final int i, final int i2, final java.lang.String str) throws java.lang.InterruptedException {
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.getSubjectStatOfStudent).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr$$ExternalSyntheticLambda0
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.course.wrongnote.WrongNoteMgr.lambda$fetchWrongNoteDetailStatList$2(i, i2, str, map);
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr$$ExternalSyntheticLambda1
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                return com.up366.mobile.course.wrongnote.WrongNoteMgr.lambda$fetchWrongNoteDetailStatList$3(response, str2);
            }
        }));
    }

    static /* synthetic */ void lambda$fetchWrongNoteDetailStatList$2(int i, int i2, java.lang.String str, java.util.Map map) {
        map.put("stageId", java.lang.Integer.valueOf(i));
        map.put("subjectId", java.lang.Integer.valueOf(i2));
        map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, str);
    }

    static /* synthetic */ com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo lambda$fetchWrongNoteDetailStatList$3(com.up366.common.http.Response response, java.lang.String str) {
        return (com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo) com.up366.mobile.common.utils.ResponseUtil.parseObject(str, com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo.class);
    }

    public void fetchWrongNoteDetailBookList(final int i, final int i2) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo>>(com.up366.mobile.common.http.HttpMgrUtils.selectBookListOfStudent) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.2
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put("stageId", java.lang.Integer.valueOf(i));
                map.put("subjectId", java.lang.Integer.valueOf(i2));
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo> list) {
                super.onResponse(response, list);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WrongNoteDetailBookListRefresh(response, list));
            }
        });
    }

    public void fetchWrongNoteRankCourseList(final int i, final int i2) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo>>(com.up366.mobile.common.http.HttpMgrUtils.getCourseListOfStudent) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.3
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put("stageId", java.lang.Integer.valueOf(i));
                map.put("subjectId", java.lang.Integer.valueOf(i2));
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> list) {
                super.onResponse(response, list);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WrongNoteRankCourseListRefresh(response, list));
            }
        });
    }

    public void fetchWrongNoteRankList(final java.lang.String str, final int i, final int i2, final java.lang.String str2, final java.lang.String str3) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo>>(com.up366.mobile.common.http.HttpMgrUtils.selectWrongNoteRankListV2) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.4
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, str);
                map.put("pager.pageSize", java.lang.Integer.valueOf(i2));
                map.put("pager.currentPage", java.lang.Integer.valueOf(i));
                map.put("orderType", str2);
                map.put("orderField", str3);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str4) {
                return com.up366.mobile.common.utils.ResponseUtil.parsePagerList(str4, com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteRankInfo> list) {
                super.onResponse(response, list);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WrongNoteRankListRefresh(response, list));
            }
        });
    }

    public void fetchWordNoteDetailBookList() {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo>>(com.up366.mobile.common.http.HttpMgrUtils.selectWdBookListOfStudent) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.5
            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo> list) {
                super.onResponse(response, list);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WrongNoteDetailBookListRefresh(response, list));
            }
        });
    }

    public void fetchWordNoteDetailStatList(final java.lang.String str) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$fetchWordNoteDetailStatList$4(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchWordNoteDetailStatList$4(java.lang.String str) throws java.lang.Exception {
        final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolderLoad = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        fetchWordNoteDetailStatList(coursePageCountHolderLoad, str, new com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo>>() { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.6
            @Override // com.up366.common.callback.ICallbackResponse
            public void onResult(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo> list) {
                com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder = coursePageCountHolderLoad;
                java.util.Objects.requireNonNull(coursePageCountHolder);
                com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.mobile.book.helper.V8OpenHelper$$ExternalSyntheticLambda10(coursePageCountHolder));
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WrongNoteDetailStatInfoRefresh(response, list == null ? null : list.get(0)));
            }
        });
    }

    public void fetchWordNoteDetailStatList(final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder, final java.lang.String str, final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo>> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo>>(com.up366.mobile.common.http.HttpMgrUtils.selectWdStudentStatInfo) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.7
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, str);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo> array = com.up366.mobile.common.utils.ResponseUtil.parseArray(str2, com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo.class);
                coursePageCountHolder.setWrongNoteNum(array.size());
                return array;
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteStatInfo> list) {
                super.onResponse(response, list);
                iCallbackResponse.onResult(response, list);
            }
        });
    }

    public void fetchWordNoteDetailList(final java.lang.String str) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo>>(com.up366.mobile.common.http.HttpMgrUtils.selectWordListOfStudent) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.8
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, str);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str2, com.up366.mobile.course.wrongnote.modle.WordNoteInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> list) {
                super.onResponse(response, list);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteDetailListRefresh(response, list));
            }
        });
    }

    public void fetchWordNoteList(final com.up366.mobile.commonui.condition.ConditionModel conditionModel) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo>>(com.up366.mobile.common.http.HttpMgrUtils.getConditionWordList) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.9
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("degree", conditionModel.getDegree() == 0 ? "" : java.lang.Integer.valueOf(conditionModel.getDegree()));
                map.put("startTime", com.up366.mobile.common.utils.TimeUtilsApp.formatTime(conditionModel.getBeginTime(), "yyyy-MM-dd"));
                map.put("endTime", com.up366.mobile.common.utils.TimeUtilsApp.formatTime(conditionModel.getEndTime(), "yyyy-MM-dd"));
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, conditionModel.getBookId());
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.common.utils.ResponseUtil.parsePagerList(str, com.up366.mobile.course.wrongnote.modle.WordNoteInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> list) {
                super.onResponse(response, list);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteDetailListRefresh(response, list));
            }
        });
    }

    public void fetchWordNoteKilledList(final java.lang.String str, final int i) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo>>(com.up366.mobile.common.http.HttpMgrUtils.selectWordKilledListOfStudent) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.10
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, str);
                map.put("isToday", java.lang.Integer.valueOf(i));
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str2, com.up366.mobile.course.wrongnote.modle.WordNoteInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> list) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteKilledListRefresh(response, list));
            }
        });
    }

    public void fetchKilledWordNoteList(final com.up366.mobile.commonui.condition.ConditionModel conditionModel, final int i) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo>>(com.up366.mobile.common.http.HttpMgrUtils.getConditionHasKilledWordList) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.11
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("degree", conditionModel.getDegree() == 0 ? "" : java.lang.Integer.valueOf(conditionModel.getDegree()));
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, conditionModel.getBookId());
                map.put("isToday", java.lang.Integer.valueOf(i));
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.common.utils.ResponseUtil.parsePagerList(str, com.up366.mobile.course.wrongnote.modle.WordNoteInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> list) {
                super.onResponse(response, list);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteKilledListRefresh(response, list));
            }
        });
    }

    public void fetchWordNoteRankCourseList() {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo>>(com.up366.mobile.common.http.HttpMgrUtils.getWdCourseListOfStudent) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.12
            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WrongNoteCourseInfo> list) {
                super.onResponse(response, list);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WrongNoteRankCourseListRefresh(response, list));
            }
        });
    }

    public void fetchWordNoteRankList(final java.lang.String str) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo>>(com.up366.mobile.common.http.HttpMgrUtils.selectWdRankList) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.13
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, str);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                return com.up366.mobile.common.utils.ResponseUtil.parseArrayByName(str2, com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo.class, "list");
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo> list) {
                super.onResponse(response, list);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteRankListRefresh(response, list));
            }
        });
    }

    public void fetchWordNoteRankListV2(final java.lang.String str, final int i, final int i2, final java.lang.String str2, final java.lang.String str3) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo>>(com.up366.mobile.common.http.HttpMgrUtils.selectWdRankListV2) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.14
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, str);
                map.put("pager.pageSize", java.lang.Integer.valueOf(i2));
                map.put("pager.currentPage", java.lang.Integer.valueOf(i));
                map.put("orderType", str2);
                map.put("orderField", str3);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str4) {
                return com.up366.mobile.common.utils.ResponseUtil.parsePagerList(str4, com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteRankInfo> list) {
                super.onResponse(response, list);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteRankListRefresh(response, list));
            }
        });
    }

    public void fetchWordNoteFromList(final java.lang.String str, final java.lang.String str2, int i, final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo>> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo>>(i == -1 ? com.up366.mobile.common.http.HttpMgrUtils.selectWdFromListOfStudent : com.up366.mobile.common.http.HttpMgrUtils.selectWordKilledDetailsListOfStudent) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.15
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, str);
                map.put("wordId", str2);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str3) {
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str3, com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo> list) {
                super.onResponse(response, list);
                iCallbackResponse.onResult(response, list);
            }
        });
    }

    public void fetchWordNoteFromList(java.lang.String str, java.lang.String str2, int i) {
        fetchWordNoteFromList(str, str2, i, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteFromListRefresh(response, (java.util.List) obj));
            }
        });
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.wrongnote.WrongNoteMgr$16, reason: invalid class name */
    class AnonymousClass16 extends com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo>> {
        final /* synthetic */ java.lang.String val$bookId;
        final /* synthetic */ java.lang.String val$wordId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass16(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            super(str);
            this.val$bookId = str2;
            this.val$wordId = str3;
        }

        @Override // com.up366.common.http.RequestParams
        public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
            super.initParams(map);
            map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, this.val$bookId);
            map.put("wordId", this.val$wordId);
        }

        @Override // com.up366.common.http.RequestParams
        public java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
            java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo> array = com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo.class);
            java.util.Collections.sort(array, new java.util.Comparator() { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr$16$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                    return java.lang.Long.compare(((com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo) obj2).getAddTime(), ((com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo) obj).getAddTime());
                }
            });
            return array;
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteFromInfo> list) {
            super.onResponse(response, list);
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteFromListRefresh(response, list));
        }
    }

    public void fetchWordSourceList(java.lang.String str, java.lang.String str2, boolean z) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.course.wrongnote.WrongNoteMgr.AnonymousClass16(z ? com.up366.mobile.common.http.HttpMgrUtils.selectWordKilledDetailsListOfStudent : com.up366.mobile.common.http.HttpMgrUtils.wordNoteUnfamiliarWordSourceUrl, str, str2));
    }

    public void getWordInfoToBrowse(final java.lang.String str, final com.up366.common.callback.ICallbackResponse<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<com.up366.mobile.course.wrongnote.modle.WordNoteInfo>(com.up366.mobile.common.http.HttpMgrUtils.getWordInfoShow) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.17
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("wordId", str);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public com.up366.mobile.course.wrongnote.modle.WordNoteInfo handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                return (com.up366.mobile.course.wrongnote.modle.WordNoteInfo) com.up366.mobile.common.utils.ResponseUtil.parseObject(str2, com.up366.mobile.course.wrongnote.modle.WordNoteInfo.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo) {
                iCallbackResponse.onResult(response, wordNoteInfo);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [T, com.up366.mobile.course.wrongnote.modle.NoteCountInfo] */
    public com.up366.common.http.NetHolder<com.up366.mobile.course.wrongnote.modle.NoteCountInfo> fetchNoteCountSync(final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) throws java.lang.InterruptedException {
        if (com.up366.mobile.common.logic.Auth.cur().config().isEnableH5TaskList()) {
            com.up366.common.http.Response response = new com.up366.common.http.Response();
            response.setCode(0);
            com.up366.common.http.NetHolder<com.up366.mobile.course.wrongnote.modle.NoteCountInfo> netHolder = new com.up366.common.http.NetHolder<>();
            coursePageCountHolder.setWrongNoteNum(0);
            coursePageCountHolder.setWordNoteNum(0);
            netHolder.resp = response;
            netHolder.info = new com.up366.mobile.course.wrongnote.modle.NoteCountInfo();
            return netHolder;
        }
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.getNoteCount).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr$$ExternalSyntheticLambda3
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                map.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr$$ExternalSyntheticLambda4
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response2, java.lang.String str) {
                return com.up366.mobile.course.wrongnote.WrongNoteMgr.lambda$fetchNoteCountSync$7(coursePageCountHolder, response2, str);
            }
        }));
    }

    static /* synthetic */ com.up366.mobile.course.wrongnote.modle.NoteCountInfo lambda$fetchNoteCountSync$7(com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder, com.up366.common.http.Response response, java.lang.String str) {
        com.up366.mobile.course.wrongnote.modle.NoteCountInfo noteCountInfo = (com.up366.mobile.course.wrongnote.modle.NoteCountInfo) com.up366.mobile.common.utils.ResponseUtil.parseObject(str, com.up366.mobile.course.wrongnote.modle.NoteCountInfo.class);
        coursePageCountHolder.setWrongNoteNum(noteCountInfo.getWnCount());
        coursePageCountHolder.setWordNoteNum(noteCountInfo.getWordCount());
        return noteCountInfo;
    }

    public void killMissingWord(final java.lang.String str) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.wordNoteKillMissingWordUrl) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.18
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                java.util.ArrayList arrayList = new java.util.ArrayList();
                arrayList.add(str);
                map.put("wordIds", arrayList);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                super.onResponse(response, obj);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteKillMissingWordEvent(response));
            }
        });
    }

    public void removeWord(final java.lang.String str, final com.up366.common.callback.ICallbackResponse iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.removeWord) { // from class: com.up366.mobile.course.wrongnote.WrongNoteMgr.19
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("wordIds", str);
            }

            @Override // com.up366.common.http.RequestParams
            public java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                return super.handleResponse(response, str2);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                iCallbackResponse.onResult(response, obj);
            }
        });
    }
}
