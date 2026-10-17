package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskMgr {
    private final com.up366.greendao.DaoSession db;
    private com.up366.mobile.common.logic.Manager mManager;
    private java.lang.String allCourseJobkey = "allCourseJobkey";
    private java.lang.String finishkey = "finishkey";

    public TaskMgr(com.up366.mobile.common.logic.Manager manager) {
        this.mManager = manager;
        this.db = manager.db();
    }

    public void fetchTask(final java.lang.String str, final java.lang.String str2, final com.up366.common.callback.ICallbackResponse<com.up366.mobile.course.task.TaskInfoV2> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<com.up366.mobile.course.task.TaskInfoV2>(com.up366.mobile.common.http.HttpMgrUtils.getStudentJobInfo) { // from class: com.up366.mobile.course.task.TaskMgr.1
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, str);
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, str2);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public com.up366.mobile.course.task.TaskInfoV2 handleResponse(com.up366.common.http.Response response, java.lang.String str3) {
                com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str3);
                com.up366.mobile.course.task.TaskMgr.this.mManager.db1().saveOrUpdate(new com.up366.mobile.book.model.StudyTaskJsonMapInfo(object.getString("jobId"), object.toJSONString()));
                return (com.up366.mobile.course.task.TaskInfoV2) com.alibaba.fastjson.JSON.parseObject(str3, com.up366.mobile.course.task.TaskInfoV2.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
                iCallbackResponse.onResult(response, taskInfoV2);
            }
        });
    }

    public void fetchDownUrl(final java.lang.String str, final com.up366.common.callback.ICallbackResponse<java.lang.String> iCallbackResponse) {
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.common.log.Logger.error("TAG - TaskMgr - fetchDownUrl - 网络不可用");
            com.up366.common.http.Response response = new com.up366.common.http.Response();
            response.setCode(-10001);
            iCallbackResponse.onResult(response, "");
            return;
        }
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.GET_TASK_DOWN_URL) { // from class: com.up366.mobile.course.task.TaskMgr.2
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("md5", str);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response2, java.lang.String str2) {
                java.lang.String string;
                com.up366.common.log.Logger.info("TAG - TaskMgr - fetchDownUrl - onResponse - resp = [" + response2 + "], result = [" + str2 + "]");
                if (response2.isError()) {
                    string = "";
                } else {
                    string = com.alibaba.fastjson.JSONObject.parseObject(str2).getString("pdfUrl");
                }
                iCallbackResponse.onResult(response2, string);
            }
        });
    }

    public void submitTaskToHistory(java.lang.String str) {
        submitTaskToHistory(str, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.EventTaskSubmit(response));
            }
        });
    }

    public void submitTaskToHistory(final java.lang.String str, final com.up366.common.callback.ICallbackResponse<java.lang.String> iCallbackResponse) {
        com.up366.common.log.Logger.info("TAG - TaskMgr - submitTaskToHistory - jobJson = [" + str + "]");
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.String>(com.up366.mobile.common.http.HttpMgrUtils.submitTask) { // from class: com.up366.mobile.course.task.TaskMgr.3
            @Override // com.up366.common.http.RequestParams
            public java.lang.String handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                return str2;
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put("jobJson", str);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.String str2) {
                super.onResponse(response, str2);
                iCallbackResponse.onResult(response, str2);
                if (response.isError()) {
                    return;
                }
                com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent("", "");
            }
        });
    }

    public com.up366.common.http.NetHolder<com.up366.mobile.course.task.model.StudyTaskPercentInfo> fetchStudyTaskPercent(final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) throws java.lang.InterruptedException {
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.studyTaskPercent).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda9
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                map.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda10
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.course.task.TaskMgr.lambda$fetchStudyTaskPercent$2(coursePageCountHolder, response, str);
            }
        }));
    }

    static /* synthetic */ com.up366.mobile.course.task.model.StudyTaskPercentInfo lambda$fetchStudyTaskPercent$2(com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder, com.up366.common.http.Response response, java.lang.String str) {
        com.up366.common.log.Logger.info("TaskMgr fetchStudyTaskPercent result=" + str);
        com.up366.mobile.course.task.model.StudyTaskPercentInfo studyTaskPercentInfo = (com.up366.mobile.course.task.model.StudyTaskPercentInfo) com.up366.mobile.common.utils.ResponseUtil.parseObject(str, com.up366.mobile.course.task.model.StudyTaskPercentInfo.class);
        if (coursePageCountHolder.getPercent() != studyTaskPercentInfo.getPercent()) {
            coursePageCountHolder.setHasShowAnimPercent(false);
        }
        coursePageCountHolder.setPercent(studyTaskPercentInfo.getPercent());
        coursePageCountHolder.setMaxPercent(studyTaskPercentInfo.getMaxPercent());
        coursePageCountHolder.setCompareLast(studyTaskPercentInfo.getCompareLast());
        coursePageCountHolder.setCompareGlobal(studyTaskPercentInfo.getCompareGlobal());
        return studyTaskPercentInfo;
    }

    public void fetchAllCourseJob(final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder, final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.course.task.TaskInfoV2>> iCallbackResponse) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$fetchAllCourseJob$4(coursePageCountHolder, iCallbackResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchAllCourseJob$4(com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder, final com.up366.common.callback.ICallbackResponse iCallbackResponse) throws java.lang.Exception {
        final com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.course.task.TaskInfoV2>> netHolderFetchAllCourseJobSync = fetchAllCourseJobSync(coursePageCountHolder);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.common.callback.ICallbackResponse iCallbackResponse2 = iCallbackResponse;
                com.up366.common.http.NetHolder netHolder = netHolderFetchAllCourseJobSync;
                iCallbackResponse2.onResult(netHolder.resp, (java.util.List) netHolder.info);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public com.up366.common.http.Response fetchTaskList() throws java.lang.InterruptedException {
        final com.up366.common.http.NetHolder netHolder = new com.up366.common.http.NetHolder();
        final com.up366.common.http.NetHolder netHolder2 = new com.up366.common.http.NetHolder();
        final com.up366.common.http.NetHolder netHolder3 = new com.up366.common.http.NetHolder();
        final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolderLoad = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        new com.up366.mobile.common.utils.ParallelRequestTool().add(new com.up366.mobile.common.utils.ParallelRequestTool.IRunner() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda13
            @Override // com.up366.mobile.common.utils.ParallelRequestTool.IRunner
            public final void run(com.up366.mobile.common.utils.ParallelRequestTool parallelRequestTool) {
                parallelRequestTool.copy(netHolder, com.up366.mobile.common.logic.Auth.cur().taskMgr().fetchAllCourseJobSync(coursePageCountHolderLoad));
            }
        }).add(new com.up366.mobile.common.utils.ParallelRequestTool.IRunner() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda14
            @Override // com.up366.mobile.common.utils.ParallelRequestTool.IRunner
            public final void run(com.up366.mobile.common.utils.ParallelRequestTool parallelRequestTool) {
                parallelRequestTool.copy(netHolder2, com.up366.mobile.common.logic.Auth.cur().taskMgr().getAllCompletedTaskAndStudyPlanSync());
            }
        }).add(new com.up366.mobile.common.utils.ParallelRequestTool.IRunner() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda15
            @Override // com.up366.mobile.common.utils.ParallelRequestTool.IRunner
            public final void run(com.up366.mobile.common.utils.ParallelRequestTool parallelRequestTool) {
                parallelRequestTool.copy(netHolder3, com.up366.mobile.common.logic.Auth.cur().wrongnote().fetchNoteCountSync(coursePageCountHolderLoad));
            }
        }).run();
        com.up366.common.log.Logger.info("TAG -  - task data load over!");
        if (netHolder.resp.isError()) {
            com.up366.common.log.Logger.info("TAG -  - fetchTaskList - holderTaskList error" + netHolder.resp.toString());
            return netHolder.resp;
        }
        if (netHolder2.resp.isError()) {
            com.up366.common.log.Logger.info("TAG -  - fetchTaskList - holderFinishTask error" + netHolder2.resp.toString());
            return netHolder2.resp;
        }
        if (netHolder3.resp.isError()) {
            com.up366.common.log.Logger.info("TAG -  - fetchTaskList - holderNoteCount error" + netHolder3.resp.toString());
            return netHolder3.resp;
        }
        com.up366.mobile.course.task.TaskFilterHelper.FilterResult filterResultFilter = new com.up366.mobile.course.task.TaskFilterHelper().filter((java.util.List) netHolder.info, (com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan) netHolder2.info);
        com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("task-helper-cache-key", filterResultFilter, 3600000L);
        coursePageCountHolderLoad.setCalendarWeekResult(com.up366.mobile.course.task.TaskDataHelper.filterCalendarWeekTask(filterResultFilter.currentTasks, filterResultFilter.historyTasks));
        coursePageCountHolderLoad.setCurrentTaskNum(com.up366.mobile.course.task.TaskDataHelper.filterCurrentTask(filterResultFilter.currentTasks).size());
        coursePageCountHolderLoad.setHistoryTaskNum(filterResultFilter.historyTasks.size());
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        long j = 43200000 + currentNtpTimeInMillisecond;
        int i = 0;
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : filterResultFilter.currentTasks) {
            if (taskInfoV2.getEndTime() < j && taskInfoV2.getBeginTime() < currentNtpTimeInMillisecond) {
                i++;
            }
        }
        coursePageCountHolderLoad.setWillExpireTaskNum(i);
        coursePageCountHolderLoad.save();
        com.up366.common.http.Response response = new com.up366.common.http.Response();
        response.setCode(0);
        return response;
    }

    public com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.course.task.TaskInfoV2>> fetchAllCourseJobSync(final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) throws java.lang.InterruptedException {
        final java.lang.String str = "allCourseJob-version-h5" + com.up366.mobile.common.logic.Auth.UID();
        if (coursePageCountHolder != null && coursePageCountHolder.getCourseNum() == 0) {
            this.mManager.cache().clearSync(str);
        }
        final int iUID = com.up366.mobile.common.logic.Auth.UID();
        final java.lang.String str2 = (java.lang.String) this.mManager.cache().loadSync(str, java.lang.String.class);
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.allCourseJob).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda11
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.course.task.TaskMgr.lambda$fetchAllCourseJobSync$8(str2, map);
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda12
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str3) {
                return this.f$0.lambda$fetchAllCourseJobSync$10(iUID, str2, str, coursePageCountHolder, response, str3);
            }
        }));
    }

    static /* synthetic */ void lambda$fetchAllCourseJobSync$8(java.lang.String str, java.util.Map map) {
        map.put("version", str);
        map.put("ignoreHiddenTask", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.util.List lambda$fetchAllCourseJobSync$10(int i, java.lang.String str, final java.lang.String str2, final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder, com.up366.common.http.Response response, java.lang.String str3) {
        if (com.up366.mobile.common.logic.Auth.UID() != i) {
            com.up366.mobile.common.onlinelog.OpLog.report("uid_change", "old:" + i + " new:" + com.up366.mobile.common.logic.Auth.UID());
            com.up366.common.log.Logger.error("TAG - TaskMgr - fetchAllCourseJobSync - uid change old:" + i + " new:" + com.up366.mobile.common.logic.Auth.UID());
            return new java.util.ArrayList();
        }
        final com.up366.mobile.course.task.model.UrlAllCourseJob urlAllCourseJob = (com.up366.mobile.course.task.model.UrlAllCourseJob) com.up366.mobile.common.utils.ResponseUtil.parseObject(str3, com.up366.mobile.course.task.model.UrlAllCourseJob.class);
        final java.lang.String version = urlAllCourseJob.getVersion();
        com.up366.common.log.Logger.info("TAG - TaskMgr fetchAllCourseJob result.length=" + str3.length());
        if (str != null && str.equals(version)) {
            this.db.getTaskInfoV2Dao().detachAll();
            return this.db.getTaskInfoV2Dao().loadAll();
        }
        this.db.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$fetchAllCourseJobSync$9(urlAllCourseJob, version, str2, coursePageCountHolder);
            }
        });
        com.alibaba.fastjson.JSONArray jSONArray = com.alibaba.fastjson.JSON.parseObject(str3).getJSONArray("courseJobList");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i2 = 0; i2 < jSONArray.size(); i2++) {
            com.alibaba.fastjson.JSONObject jSONObject = jSONArray.getJSONObject(i2);
            com.alibaba.fastjson.JSONArray jSONArray2 = jSONObject.getJSONArray("allTaskList");
            if (jSONArray2 == null) {
                jSONArray2 = new com.alibaba.fastjson.JSONArray();
            }
            com.alibaba.fastjson.JSONArray jSONArray3 = jSONObject.getJSONArray("ownerTaskList");
            if (jSONArray3 != null) {
                jSONArray2.addAll(jSONArray3);
            }
            for (int i3 = 0; i3 < jSONArray2.size(); i3++) {
                com.alibaba.fastjson.JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                arrayList.add(new com.up366.mobile.book.model.StudyTaskJsonMapInfo(jSONObject2.getString("jobId"), jSONObject2.toJSONString()));
            }
        }
        this.mManager.db1().saveOrUpdate(arrayList);
        saveAllJobToCache(str3);
        return this.db.getTaskInfoV2Dao().loadAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchAllCourseJobSync$9(com.up366.mobile.course.task.model.UrlAllCourseJob urlAllCourseJob, java.lang.String str, java.lang.String str2, com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) {
        java.util.List<com.up366.mobile.course.task.TaskInfoV2> allTask = urlAllCourseJob.getAllTask();
        java.util.List<com.up366.mobile.course.mgr.CourseInfo> allCourseList = urlAllCourseJob.getAllCourseList();
        int size = allCourseList.size();
        com.up366.common.log.Logger.info("TAG - TaskMgr - fetchAllCourseJob - allCourse size : " + size + " allTask size : " + allTask.size() + " version:" + str);
        this.db.getTaskInfoV2Dao().deleteAll();
        this.db.getTaskInfoV2Dao().saveInTx(allTask);
        this.db.getCourseInfoDao().deleteAll();
        this.db.getCourseInfoDao().saveInTx(allCourseList);
        this.mManager.cache().put(str2, str, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_3);
        if (coursePageCountHolder != null) {
            coursePageCountHolder.setCourseNum(size);
        }
    }

    private void saveAllJobToCache(java.lang.String str) {
        this.mManager.cache().put(this.allCourseJobkey + com.up366.mobile.common.logic.Auth.UID(), str, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_6);
    }

    public com.alibaba.fastjson.JSONObject loadAllJob() {
        java.lang.String str = (java.lang.String) this.mManager.cache().loadSync(this.allCourseJobkey + com.up366.mobile.common.logic.Auth.UID(), java.lang.String.class);
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return new com.alibaba.fastjson.JSONObject();
        }
        return com.alibaba.fastjson.JSON.parseObject(str);
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.task.TaskMgr$4, reason: invalid class name */
    class AnonymousClass4 extends com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.task.model.TaskScoreTrend>> {
        final /* synthetic */ com.up366.common.callback.ICallbackResponse val$callback;
        final /* synthetic */ java.lang.String val$endTime;
        final /* synthetic */ java.lang.String val$startTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(java.lang.String str, java.lang.String str2, java.lang.String str3, com.up366.common.callback.ICallbackResponse iCallbackResponse) {
            super(str);
            this.val$startTime = str2;
            this.val$endTime = str3;
            this.val$callback = iCallbackResponse;
        }

        @Override // com.up366.common.http.RequestParams
        public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
            super.initParams(map);
            map.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
            map.put("startDate", this.val$startTime);
            map.put("endDate", this.val$endTime);
        }

        @Override // com.up366.common.http.RequestParams
        public java.util.List<com.up366.mobile.course.task.model.TaskScoreTrend> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
            com.up366.common.log.Logger.info("TaskMgr getTaskScoreTrend result=" + str);
            return com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.course.task.model.TaskScoreTrend.class);
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.task.model.TaskScoreTrend> list) {
            super.onResponse(response, list);
            if (list != null && !list.isEmpty()) {
                java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.course.task.TaskMgr$4$$ExternalSyntheticLambda0
                    @Override // java.util.Comparator
                    public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                        return com.up366.mobile.course.task.TaskMgr.AnonymousClass4.lambda$onResponse$0((com.up366.mobile.course.task.model.TaskScoreTrend) obj, (com.up366.mobile.course.task.model.TaskScoreTrend) obj2);
                    }
                });
            }
            this.val$callback.onResult(response, list);
        }

        static /* synthetic */ int lambda$onResponse$0(com.up366.mobile.course.task.model.TaskScoreTrend taskScoreTrend, com.up366.mobile.course.task.model.TaskScoreTrend taskScoreTrend2) {
            if (taskScoreTrend.getEndTime() - taskScoreTrend2.getEndTime() > 0) {
                return 1;
            }
            return taskScoreTrend.getEndTime() - taskScoreTrend2.getEndTime() < 0 ? -1 : 0;
        }
    }

    public void getTaskScoreTrend(java.lang.String str, java.lang.String str2, com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.course.task.model.TaskScoreTrend>> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.course.task.TaskMgr.AnonymousClass4(com.up366.mobile.common.http.HttpMgrUtils.GET_TASK_SCORE_TREND, str, str2, iCallbackResponse));
    }

    public void getAllCompletedTaskAndStudyPlan(final com.up366.common.callback.ICallbackResponse<com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan> iCallbackResponse) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$getAllCompletedTaskAndStudyPlan$12(iCallbackResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllCompletedTaskAndStudyPlan$12(final com.up366.common.callback.ICallbackResponse iCallbackResponse) throws java.lang.Exception {
        final com.up366.common.http.NetHolder<com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan> allCompletedTaskAndStudyPlanSync = getAllCompletedTaskAndStudyPlanSync();
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda8
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.common.callback.ICallbackResponse iCallbackResponse2 = iCallbackResponse;
                com.up366.common.http.NetHolder netHolder = allCompletedTaskAndStudyPlanSync;
                iCallbackResponse2.onResult(netHolder.resp, (com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan) netHolder.info);
            }
        });
    }

    public com.up366.common.http.NetHolder<com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan> getAllCompletedTaskAndStudyPlanSync() throws java.lang.InterruptedException {
        final java.lang.String str = "allCompletedJob-version";
        final java.lang.String str2 = (java.lang.String) this.mManager.cache().loadSync("allCompletedJob-version", java.lang.String.class);
        return com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams(com.up366.mobile.common.http.HttpMgrUtils.GET_ALL_COMPLETED_TASK_AND_STUDY_PLAN).addParams(new com.up366.common.http.RequestParams.IAddParams() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda3
            @Override // com.up366.common.http.RequestParams.IAddParams
            public final void addParams(java.util.Map map) {
                com.up366.mobile.course.task.TaskMgr.lambda$getAllCompletedTaskAndStudyPlanSync$13(str2, map);
            }
        }).setResponseHandler(new com.up366.common.http.RequestParams.IHandleResponse() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda4
            @Override // com.up366.common.http.RequestParams.IHandleResponse
            public final java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str3) {
                return this.f$0.lambda$getAllCompletedTaskAndStudyPlanSync$15(str2, str, response, str3);
            }
        }));
    }

    static /* synthetic */ void lambda$getAllCompletedTaskAndStudyPlanSync$13(java.lang.String str, java.util.Map map) {
        map.put("version", str);
        map.put("ignoreHiddenTask", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan lambda$getAllCompletedTaskAndStudyPlanSync$15(java.lang.String str, java.lang.String str2, com.up366.common.http.Response response, java.lang.String str3) {
        final com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan completedTaskAndStudyPlan = (com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan) com.up366.mobile.common.utils.ResponseUtil.parseObject(str3, com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan.class);
        java.lang.String version = completedTaskAndStudyPlan.getVersion();
        if (!android.text.TextUtils.equals(str, version)) {
            this.db.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.course.task.TaskMgr$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getAllCompletedTaskAndStudyPlanSync$14(completedTaskAndStudyPlan);
                }
            });
            com.up366.common.log.Logger.info("TAG - TaskMgr - getAllCompletedTaskAndStudyPlanSync - finished size:" + completedTaskAndStudyPlan.getFinishedList().size() + " studyPlanList size:" + completedTaskAndStudyPlan.getStudyPlanList() + " version:" + version);
            this.mManager.cache().put(str2, version, 604800000L);
        }
        com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan completedTaskAndStudyPlan2 = new com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan();
        completedTaskAndStudyPlan2.setFinishedList(this.db.getTaskCompletedInfoDao().loadAll());
        completedTaskAndStudyPlan2.setStudyPlanList(this.db.getStudyPlanInfoDao().loadAll());
        completedTaskAndStudyPlan2.setReturnedList(this.db.getReturnedInfoDao().loadAll());
        completedTaskAndStudyPlan2.setVersion(version);
        saveFinishToCache(com.alibaba.fastjson.JSONObject.toJSONString(completedTaskAndStudyPlan2));
        return completedTaskAndStudyPlan2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllCompletedTaskAndStudyPlanSync$14(com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan completedTaskAndStudyPlan) {
        this.db.getTaskCompletedInfoDao().deleteAll();
        this.db.getTaskCompletedInfoDao().saveInTx(completedTaskAndStudyPlan.getFinishedList());
        this.db.getStudyPlanInfoDao().deleteAll();
        this.db.getStudyPlanInfoDao().saveInTx(completedTaskAndStudyPlan.getStudyPlanList());
        this.db.getReturnedInfoDao().deleteAll();
        this.db.getReturnedInfoDao().saveInTx(completedTaskAndStudyPlan.getReturnedList());
    }

    private void saveFinishToCache(java.lang.String str) {
        this.mManager.cache().put(this.finishkey + com.up366.mobile.common.logic.Auth.UID(), str, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_6);
    }

    public com.alibaba.fastjson.JSONObject loadFinish() {
        java.lang.String str = (java.lang.String) this.mManager.cache().loadSync(this.finishkey + com.up366.mobile.common.logic.Auth.UID(), java.lang.String.class);
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return new com.alibaba.fastjson.JSONObject();
        }
        return com.alibaba.fastjson.JSON.parseObject(str);
    }

    public void fetchTaskByMonth(final java.lang.String str, final java.lang.String str2, final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.course.task.TaskInfoV2>> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.task.TaskInfoV2>>(com.up366.mobile.common.http.HttpMgrUtils.GET_TASK_BY_MONTH) { // from class: com.up366.mobile.course.task.TaskMgr.5
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put("beginTime", str);
                map.put("endTime", str2);
                map.put("ignoreHiddenTask", 1);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.task.TaskInfoV2> handleResponse(com.up366.common.http.Response response, java.lang.String str3) {
                java.util.List<com.up366.mobile.course.task.TaskInfoV2> array = com.up366.mobile.common.utils.ResponseUtil.parseArray(str3, com.up366.mobile.course.task.TaskInfoV2.class);
                com.alibaba.fastjson.JSONArray array2 = com.alibaba.fastjson.JSON.parseArray(str3);
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i = 0; i < array2.size(); i++) {
                    com.alibaba.fastjson.JSONObject jSONObject = array2.getJSONObject(i);
                    arrayList.add(new com.up366.mobile.book.model.StudyTaskJsonMapInfo(jSONObject.getString("jobId"), jSONObject.toJSONString()));
                }
                com.up366.mobile.course.task.TaskMgr.this.mManager.db1().saveOrUpdate(arrayList);
                return array;
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
                super.onResponse(response, list);
                com.up366.mobile.course.task.TaskFilterHelper.initNoAnswerStatus(list);
                iCallbackResponse.onResult(response, list);
            }
        });
    }

    public com.up366.mobile.course.task.TaskInfoV2 tryLoadOneTaskInfo(java.lang.String str) throws java.lang.InterruptedException {
        com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 = (com.up366.mobile.course.task.TaskInfoV2) this.mManager.db().getTaskInfoV2Dao().queryBuilder().where(com.up366.greendao.TaskInfoV2Dao.Properties.JobId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).build().unique();
        com.up366.mobile.course.task.model.ReturnedInfo returnedInfo = (com.up366.mobile.course.task.model.ReturnedInfo) this.mManager.db().getReturnedInfoDao().queryBuilder().where(com.up366.greendao.ReturnedInfoDao.Properties.StudyTaskId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).build().unique();
        if (taskInfoV2 != null && returnedInfo != null) {
            taskInfoV2.setReturnState(1);
            taskInfoV2.setReturnCode(returnedInfo.getReturnCode());
        }
        if (taskInfoV2 != null) {
            return taskInfoV2;
        }
        com.up366.common.http.NetHolder<java.util.List<com.up366.mobile.course.task.TaskInfoV2>> netHolderFetchAllCourseJobSync = fetchAllCourseJobSync(com.up366.mobile.course.task.model.CoursePageCountHolder.load());
        if (netHolderFetchAllCourseJobSync.resp.isError()) {
            com.up366.common.log.Logger.error("TAG - TaskMgr - tryLoadOneTaskInfo - " + netHolderFetchAllCourseJobSync.resp.toString());
        }
        return (com.up366.mobile.course.task.TaskInfoV2) this.mManager.db().getTaskInfoV2Dao().queryBuilder().where(com.up366.greendao.TaskInfoV2Dao.Properties.JobId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).build().unique();
    }

    public void fetchGrowthReportCourseList(final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.course.task.model.GrowthReportCourse>> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.task.model.GrowthReportCourse>>(com.up366.mobile.common.http.HttpMgrUtils.GROWTH_REPORT_COURSE_LIST) { // from class: com.up366.mobile.course.task.TaskMgr.6
            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.course.task.model.GrowthReportCourse> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.course.task.model.GrowthReportCourse.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.task.model.GrowthReportCourse> list) {
                com.up366.common.callback.ICallbackResponse iCallbackResponse2 = iCallbackResponse;
                if (iCallbackResponse2 != null) {
                    iCallbackResponse2.onResult(response, list);
                }
            }
        });
    }

    public void fetchReportType(final com.up366.mobile.course.task.model.ReportTypeParams reportTypeParams, final com.up366.common.callback.ICallbackResponse<com.up366.mobile.course.task.model.ReportTypeResult> iCallbackResponse) {
        com.up366.common.log.Logger.info("TAG - TaskMgr - fetchReportType - params = [" + reportTypeParams + "]");
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<com.up366.mobile.course.task.model.ReportTypeResult>(com.up366.mobile.common.http.HttpMgrUtils.FETCH_REPORT_TYPE) { // from class: com.up366.mobile.course.task.TaskMgr.7
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                super.initParams(map);
                map.put("type", reportTypeParams.getType());
                if (!com.up366.common.StringUtils.isEmptyOrNull(reportTypeParams.getTaskId())) {
                    map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, reportTypeParams.getTaskId());
                }
                if (!com.up366.common.StringUtils.isEmptyOrNull(reportTypeParams.getBookId())) {
                    map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, reportTypeParams.getBookId());
                }
                if (reportTypeParams.getCourseId() != 0) {
                    map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(reportTypeParams.getCourseId()));
                }
                if (!com.up366.common.StringUtils.isEmptyOrNull(reportTypeParams.getStudyTaskId())) {
                    map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, reportTypeParams.getStudyTaskId());
                }
                if (com.up366.common.StringUtils.isEmptyOrNull(reportTypeParams.getScope())) {
                    return;
                }
                map.put("scope", reportTypeParams.getScope());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public com.up366.mobile.course.task.model.ReportTypeResult handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return (com.up366.mobile.course.task.model.ReportTypeResult) com.alibaba.fastjson.JSON.parseObject(str, com.up366.mobile.course.task.model.ReportTypeResult.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, com.up366.mobile.course.task.model.ReportTypeResult reportTypeResult) {
                iCallbackResponse.onResult(response, reportTypeResult);
            }
        });
    }

    public void saveSubmitTaskInfo(java.lang.String str, java.lang.String str2, double d, long j) {
        com.up366.mobile.common.logic.Auth.cur().bookLog().saveToStudyTaskHistory(new com.up366.mobile.book.model.StudyTaskHistory(new com.up366.mobile.common.logic.model.SubmitTaskInfo(str, str2, d, j)));
    }

    public java.util.List<com.up366.mobile.common.logic.model.SubmitTaskInfo> getSubmitTaskInfoByTaskId(java.lang.String str) {
        java.util.List<com.up366.mobile.book.model.StudyTaskHistory> list = com.up366.mobile.common.logic.Auth.cur().db().getStudyTaskHistoryDao().queryBuilder().where(com.up366.greendao.StudyTaskHistoryDao.Properties.TaskId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).orderAsc(new org.greenrobot.greendao.Property[]{com.up366.greendao.StudyTaskHistoryDao.Properties.InsertTime}).list();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.up366.mobile.book.model.StudyTaskHistory studyTaskHistory : list) {
            arrayList.add(new com.up366.mobile.common.logic.model.SubmitTaskInfo(studyTaskHistory.getTaskId(), studyTaskHistory.getStudyTaskId(), studyTaskHistory.getScore(), studyTaskHistory.getInsertTime()));
        }
        return arrayList;
    }
}
