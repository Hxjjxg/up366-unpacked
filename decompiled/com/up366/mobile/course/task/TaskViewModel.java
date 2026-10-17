package com.up366.mobile.course.task;

/* JADX INFO: compiled from: TaskViewModel.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00101\u001a\u000202H\u0002J\u0006\u00103\u001a\u000202J\u0006\u00104\u001a\u000202J\u000e\u00105\u001a\u0002022\u0006\u00106\u001a\u00020+J\u0016\u00107\u001a\u0002022\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209J\u001c\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020=2\n\u0010>\u001a\u00060$R\u00020%H\u0002J\u000e\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020 J\b\u0010A\u001a\u000202H\u0002J\u0014\u0010B\u001a\u0002022\n\u0010>\u001a\u00060$R\u00020%H\u0002J\u0016\u0010C\u001a\u0002022\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0016\u0010E\u001a\u0002022\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J$\u0010G\u001a\u0002022\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010H\u001a\b\u0012\u0004\u0012\u00020 0\u0006H\u0002J \u0010I\u001a\u0002022\b\u0010J\u001a\u0004\u0018\u00010K2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R \u0010#\u001a\b\u0018\u00010$R\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\tR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\tR\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020 0\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\t¨\u0006L"}, d2 = {"Lcom/up366/mobile/course/task/TaskViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "currentTasksLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/up366/mobile/course/task/TaskInfoV2;", "getCurrentTasksLiveData", "()Landroidx/lifecycle/MutableLiveData;", "historyTasksLiveData", "getHistoryTasksLiveData", "historyTasksByTimeLiveData", "getHistoryTasksByTimeLiveData", "netErrorLiveData", "Lcom/up366/common/http/Response;", "getNetErrorLiveData", "historyNetErrorLiveData", "getHistoryNetErrorLiveData", "currentBookId", "", "getCurrentBookId", "()Ljava/lang/String;", "setCurrentBookId", "(Ljava/lang/String;)V", "currentCourseId", "", "getCurrentCourseId", "()I", "setCurrentCourseId", "(I)V", "courseInfos", "Lcom/up366/mobile/course/mgr/CourseInfo;", "getCourseInfos", "()Ljava/util/List;", "filterResult", "Lcom/up366/mobile/course/task/TaskFilterHelper$FilterResult;", "Lcom/up366/mobile/course/task/TaskFilterHelper;", "getFilterResult", "()Lcom/up366/mobile/course/task/TaskFilterHelper$FilterResult;", "setFilterResult", "(Lcom/up366/mobile/course/task/TaskFilterHelper$FilterResult;)V", "refreshDataLiveData", "", "getRefreshDataLiveData", "currentTaskNumber", "getCurrentTaskNumber", "currentSelectCourse", "getCurrentSelectCourse", "loadCourseFromDb", "", "loadDataFromMemory", "loadDataFromDb", "refreshTaskData", "pullRefreshByUser", "getTaskByTime", "beginTime", "", "endTime", "saveTaskMemoryAndDb", "holder", "Lcom/up366/mobile/course/task/model/CoursePageCountHolder;", "result", "setCurrentCourseLiveDataValue", "course", "showUploadFailByLocalData", "fragmentSetData", "historyFragmentSetData", "tasks", "currentFragmentSetData", "taskFilterByCourseAndBook", "setTaskCourseName", "courses", "filterTasksBySearch", "activity", "Lcom/up366/mobile/course/task/TaskActivity;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TaskViewModel extends androidx.lifecycle.ViewModel {
    private com.up366.mobile.course.task.TaskFilterHelper.FilterResult filterResult;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.up366.mobile.course.task.TaskInfoV2>> currentTasksLiveData = new androidx.lifecycle.MutableLiveData<>();
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.up366.mobile.course.task.TaskInfoV2>> historyTasksLiveData = new androidx.lifecycle.MutableLiveData<>();
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.up366.mobile.course.task.TaskInfoV2>> historyTasksByTimeLiveData = new androidx.lifecycle.MutableLiveData<>();
    private final androidx.lifecycle.MutableLiveData<com.up366.common.http.Response> netErrorLiveData = new androidx.lifecycle.MutableLiveData<>();
    private final androidx.lifecycle.MutableLiveData<com.up366.common.http.Response> historyNetErrorLiveData = new androidx.lifecycle.MutableLiveData<>();
    private java.lang.String currentBookId = "";
    private int currentCourseId = -1;
    private final java.util.List<com.up366.mobile.course.mgr.CourseInfo> courseInfos = new java.util.ArrayList();
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> refreshDataLiveData = new androidx.lifecycle.MutableLiveData<>();
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> currentTaskNumber = new androidx.lifecycle.MutableLiveData<>();
    private final androidx.lifecycle.MutableLiveData<com.up366.mobile.course.mgr.CourseInfo> currentSelectCourse = new androidx.lifecycle.MutableLiveData<>();

    public final androidx.lifecycle.MutableLiveData<java.util.List<com.up366.mobile.course.task.TaskInfoV2>> getCurrentTasksLiveData() {
        return this.currentTasksLiveData;
    }

    public final androidx.lifecycle.MutableLiveData<java.util.List<com.up366.mobile.course.task.TaskInfoV2>> getHistoryTasksLiveData() {
        return this.historyTasksLiveData;
    }

    public final androidx.lifecycle.MutableLiveData<java.util.List<com.up366.mobile.course.task.TaskInfoV2>> getHistoryTasksByTimeLiveData() {
        return this.historyTasksByTimeLiveData;
    }

    public final androidx.lifecycle.MutableLiveData<com.up366.common.http.Response> getNetErrorLiveData() {
        return this.netErrorLiveData;
    }

    public final androidx.lifecycle.MutableLiveData<com.up366.common.http.Response> getHistoryNetErrorLiveData() {
        return this.historyNetErrorLiveData;
    }

    public final java.lang.String getCurrentBookId() {
        return this.currentBookId;
    }

    public final void setCurrentBookId(java.lang.String str) {
        this.currentBookId = str;
    }

    public final int getCurrentCourseId() {
        return this.currentCourseId;
    }

    public final void setCurrentCourseId(int i) {
        this.currentCourseId = i;
    }

    public final java.util.List<com.up366.mobile.course.mgr.CourseInfo> getCourseInfos() {
        return this.courseInfos;
    }

    public final com.up366.mobile.course.task.TaskFilterHelper.FilterResult getFilterResult() {
        return this.filterResult;
    }

    public final void setFilterResult(com.up366.mobile.course.task.TaskFilterHelper.FilterResult filterResult) {
        this.filterResult = filterResult;
    }

    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getRefreshDataLiveData() {
        return this.refreshDataLiveData;
    }

    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getCurrentTaskNumber() {
        return this.currentTaskNumber;
    }

    public final androidx.lifecycle.MutableLiveData<com.up366.mobile.course.mgr.CourseInfo> getCurrentSelectCourse() {
        return this.currentSelectCourse;
    }

    private final void loadCourseFromDb() {
        if (this.courseInfos.isEmpty()) {
            java.util.List listLoadAll = com.up366.mobile.common.logic.Auth.cur().db().getCourseInfoDao().loadAll();
            java.util.List<com.up366.mobile.course.mgr.CourseInfo> list = this.courseInfos;
            kotlin.jvm.internal.Intrinsics.checkNotNull(listLoadAll);
            list.addAll(listLoadAll);
        }
    }

    public final void loadDataFromMemory() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.task.TaskViewModel.loadDataFromMemory$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadDataFromMemory$lambda$0(com.up366.mobile.course.task.TaskViewModel taskViewModel) {
        com.up366.mobile.course.task.TaskFilterHelper.FilterResult filterResult = (com.up366.mobile.course.task.TaskFilterHelper.FilterResult) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync("task-helper-cache-key");
        taskViewModel.loadCourseFromDb();
        if (filterResult == null) {
            taskViewModel.loadDataFromDb();
        } else {
            taskViewModel.filterResult = filterResult;
            taskViewModel.fragmentSetData(filterResult);
        }
    }

    public final void loadDataFromDb() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda14
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.task.TaskViewModel.loadDataFromDb$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadDataFromDb$lambda$1(com.up366.mobile.course.task.TaskViewModel taskViewModel) {
        com.up366.mobile.common.logic.Auth.cur().db().getTaskInfoV2Dao().detachAll();
        java.util.List<com.up366.mobile.course.task.TaskInfoV2> listLoadAll = com.up366.mobile.common.logic.Auth.cur().db().getTaskInfoV2Dao().loadAll();
        com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan completedTaskAndStudyPlan = new com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan();
        completedTaskAndStudyPlan.setFinishedList(com.up366.mobile.common.logic.Auth.cur().db().getTaskCompletedInfoDao().loadAll());
        completedTaskAndStudyPlan.setStudyPlanList(com.up366.mobile.common.logic.Auth.cur().db().getStudyPlanInfoDao().loadAll());
        taskViewModel.loadCourseFromDb();
        com.up366.mobile.course.task.TaskFilterHelper.FilterResult filterResultFilter = new com.up366.mobile.course.task.TaskFilterHelper().filter(listLoadAll, completedTaskAndStudyPlan);
        taskViewModel.filterResult = filterResultFilter;
        com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("task-helper-cache-key", filterResultFilter, 3600000L);
        kotlin.jvm.internal.Intrinsics.checkNotNull(filterResultFilter);
        taskViewModel.fragmentSetData(filterResultFilter);
    }

    public final void refreshTaskData(final boolean pullRefreshByUser) {
        if (!pullRefreshByUser) {
            showUploadFailByLocalData();
        }
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.task.TaskViewModel.refreshTaskData$lambda$11(pullRefreshByUser, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshTaskData$lambda$11(final boolean z, final com.up366.mobile.course.task.TaskViewModel taskViewModel) {
        final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolderLoad = com.up366.mobile.course.task.model.CoursePageCountHolder.load();
        com.up366.mobile.common.utils.TaskChainTool taskChainTool = new com.up366.mobile.common.utils.TaskChainTool();
        taskChainTool.query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
            public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                com.up366.mobile.course.task.TaskViewModel.refreshTaskData$lambda$11$lambda$3(iReturnOps);
            }
        });
        if (z) {
            taskChainTool.query(new com.up366.mobile.common.utils.TaskChainTool.IQueryObject() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda6
                @Override // com.up366.mobile.common.utils.TaskChainTool.IQueryObject
                public final void query(com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
                    com.up366.mobile.course.task.TaskViewModel.refreshTaskData$lambda$11$lambda$5(coursePageCountHolderLoad, iReturnOps);
                }
            });
        }
        taskChainTool.doQueryParallel();
        taskChainTool.onError(new com.up366.mobile.common.utils.TaskChainTool.IErrorCallback() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda7
            @Override // com.up366.mobile.common.utils.TaskChainTool.IErrorCallback
            public final void error(int i, java.lang.String str) {
                com.up366.mobile.course.task.TaskViewModel.refreshTaskData$lambda$11$lambda$7(this.f$0, coursePageCountHolderLoad, i, str);
            }
        });
        taskChainTool.onSuccess(new com.up366.mobile.common.utils.TaskChainTool.ISuccessCallback() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda8
            @Override // com.up366.mobile.common.utils.TaskChainTool.ISuccessCallback
            public final void success(int i, java.lang.String str, java.lang.Object[] objArr) {
                com.up366.mobile.course.task.TaskViewModel.refreshTaskData$lambda$11$lambda$10(z, taskViewModel, coursePageCountHolderLoad, i, str, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshTaskData$lambda$11$lambda$3(final com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        com.up366.mobile.common.logic.Auth.cur().taskMgr().getAllCompletedTaskAndStudyPlan(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda10
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                iReturnOps.onResponse(response, (com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshTaskData$lambda$11$lambda$5(com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder, final com.up366.mobile.common.utils.TaskChainTool.IReturnOps iReturnOps) {
        com.up366.mobile.common.logic.Auth.cur().taskMgr().fetchAllCourseJob(coursePageCountHolder, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda3
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                iReturnOps.onResponse(response, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshTaskData$lambda$11$lambda$7(com.up366.mobile.course.task.TaskViewModel taskViewModel, final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder, int i, java.lang.String str) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda9
            @Override // com.up366.common.task.Task
            public final void run() {
                coursePageCountHolder.save();
            }
        });
        com.up366.common.http.Response response = new com.up366.common.http.Response();
        response.setCode(i);
        response.setInfo(str);
        taskViewModel.netErrorLiveData.setValue(response);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshTaskData$lambda$11$lambda$10(final boolean z, final com.up366.mobile.course.task.TaskViewModel taskViewModel, final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder, int i, java.lang.String str, final java.lang.Object[] objArr) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.task.TaskViewModel.refreshTaskData$lambda$11$lambda$10$lambda$9(objArr, z, taskViewModel, coursePageCountHolder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshTaskData$lambda$11$lambda$10$lambda$9(java.lang.Object[] objArr, boolean z, com.up366.mobile.course.task.TaskViewModel taskViewModel, final com.up366.mobile.course.task.model.CoursePageCountHolder coursePageCountHolder) {
        java.util.List<com.up366.mobile.course.task.TaskInfoV2> listLoadAll;
        java.lang.Object obj = objArr[0];
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan");
        com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan completedTaskAndStudyPlan = (com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan) obj;
        com.up366.mobile.common.logic.Auth.cur().db().getTaskInfoV2Dao().detachAll();
        if (z) {
            java.lang.Object obj2 = objArr[1];
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.up366.mobile.course.task.TaskInfoV2>");
            listLoadAll = kotlin.jvm.internal.TypeIntrinsics.asMutableList(obj2);
        } else {
            listLoadAll = com.up366.mobile.common.logic.Auth.cur().db().getTaskInfoV2Dao().loadAll();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(listLoadAll, "loadAll(...)");
        }
        taskViewModel.loadCourseFromDb();
        com.up366.mobile.course.task.TaskFilterHelper.FilterResult filterResultFilter = new com.up366.mobile.course.task.TaskFilterHelper().filter(listLoadAll, completedTaskAndStudyPlan);
        kotlin.jvm.internal.Intrinsics.checkNotNull(coursePageCountHolder);
        kotlin.jvm.internal.Intrinsics.checkNotNull(filterResultFilter);
        taskViewModel.saveTaskMemoryAndDb(coursePageCountHolder, filterResultFilter);
        taskViewModel.fragmentSetData(filterResultFilter);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda13
            @Override // com.up366.common.task.Task
            public final void run() {
                coursePageCountHolder.save();
            }
        });
    }

    public final void getTaskByTime(long beginTime, long endTime) {
        com.up366.mobile.common.logic.Auth.cur().taskMgr().fetchTaskByMonth(com.up366.common.TimeUtils.formatTime(beginTime, "yyyy-MM-dd"), com.up366.common.TimeUtils.formatTime(endTime, "yyyy-MM-dd"), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda5
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                com.up366.mobile.course.task.TaskViewModel.getTaskByTime$lambda$12(this.f$0, response, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTaskByTime$lambda$12(com.up366.mobile.course.task.TaskViewModel taskViewModel, com.up366.common.http.Response response, java.util.List list) {
        if (response.isError()) {
            taskViewModel.historyNetErrorLiveData.setValue(response);
            return;
        }
        java.util.List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            taskViewModel.historyTasksByTimeLiveData.setValue(new java.util.ArrayList());
            return;
        }
        taskViewModel.loadCourseFromDb();
        java.util.List<com.up366.mobile.course.task.TaskInfoV2> listTaskFilterByCourseAndBook = taskViewModel.taskFilterByCourseAndBook(list);
        taskViewModel.setTaskCourseName(listTaskFilterByCourseAndBook, taskViewModel.courseInfos);
        taskViewModel.historyTasksByTimeLiveData.setValue(listTaskFilterByCourseAndBook);
    }

    private final void saveTaskMemoryAndDb(com.up366.mobile.course.task.model.CoursePageCountHolder holder, com.up366.mobile.course.task.TaskFilterHelper.FilterResult result) {
        com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("task-helper-cache-key", result, 3600000L);
        holder.setCalendarWeekResult(com.up366.mobile.course.task.TaskDataHelper.filterCalendarWeekTask(result.currentTasks, result.historyTasks));
        holder.setCurrentTaskNum(com.up366.mobile.course.task.TaskDataHelper.filterCurrentTask(result.currentTasks).size());
        holder.setHistoryTaskNum(result.historyTasks.size());
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        long j = ((long) 43200000) + currentNtpTimeInMillisecond;
        java.util.List<com.up366.mobile.course.task.TaskInfoV2> list = result.currentTasks;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(list, "currentTasks");
        int i = 0;
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : list) {
            if (taskInfoV2.getEndTime() < j && taskInfoV2.getBeginTime() < currentNtpTimeInMillisecond) {
                i++;
            }
        }
        holder.setWillExpireTaskNum(i);
        holder.save();
    }

    public final void setCurrentCourseLiveDataValue(com.up366.mobile.course.mgr.CourseInfo course) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(course, "course");
        this.currentSelectCourse.postValue(course);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showUploadFailByLocalData() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda11
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.task.TaskViewModel.showUploadFailByLocalData$lambda$16(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showUploadFailByLocalData$lambda$16(final com.up366.mobile.course.task.TaskViewModel taskViewModel) {
        java.util.List<com.up366.mobile.common.logic.log.model.BatchUploadLog> taskList = com.up366.mobile.common.logic.Auth.cur().logMgr().getTaskList();
        kotlin.jvm.internal.Intrinsics.checkNotNull(taskList);
        boolean z = false;
        boolean z2 = false;
        for (com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog : taskList) {
            if (batchUploadLog.getState() == -1) {
                z2 = true;
            }
            if (batchUploadLog.getState() == 1) {
                z = true;
            }
        }
        if (z) {
            com.up366.common.task.TaskUtils.postLazyTaskGlobal("lazy_refresh_upload_fail", 1000, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskViewModel$$ExternalSyntheticLambda12
                @Override // com.up366.common.task.Task
                public final void run() {
                    this.f$0.showUploadFailByLocalData();
                }
            });
        } else if (z2) {
            taskViewModel.loadDataFromDb();
        }
    }

    private final void fragmentSetData(com.up366.mobile.course.task.TaskFilterHelper.FilterResult result) {
        java.util.List<com.up366.mobile.course.task.TaskInfoV2> list = result.currentTasks;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(list, "currentTasks");
        currentFragmentSetData(list);
        java.util.List<com.up366.mobile.course.task.TaskInfoV2> list2 = result.historyTasks;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(list2, "historyTasks");
        historyFragmentSetData(list2);
    }

    private final void historyFragmentSetData(java.util.List<com.up366.mobile.course.task.TaskInfoV2> tasks) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(tasks);
        java.util.List<com.up366.mobile.course.task.TaskInfoV2> listTaskFilterByCourseAndBook = taskFilterByCourseAndBook(arrayList);
        setTaskCourseName(listTaskFilterByCourseAndBook, this.courseInfos);
        this.historyTasksLiveData.postValue(listTaskFilterByCourseAndBook);
    }

    private final void currentFragmentSetData(java.util.List<com.up366.mobile.course.task.TaskInfoV2> tasks) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(tasks);
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((com.up366.mobile.course.task.TaskInfoV2) it.next()).getUploadStatus() == -1) {
                this.refreshDataLiveData.postValue(true);
            }
        }
        java.util.List<com.up366.mobile.course.task.TaskInfoV2> listTaskFilterByCourseAndBook = taskFilterByCourseAndBook(arrayList);
        setTaskCourseName(listTaskFilterByCourseAndBook, this.courseInfos);
        this.currentTasksLiveData.postValue(com.up366.mobile.course.task.TaskDataHelper.filterCurrentTask(listTaskFilterByCourseAndBook));
    }

    private final java.util.List<com.up366.mobile.course.task.TaskInfoV2> taskFilterByCourseAndBook(java.util.List<com.up366.mobile.course.task.TaskInfoV2> tasks) {
        java.lang.String str = this.currentBookId;
        if (str == null || str.length() <= 0) {
            return tasks;
        }
        com.up366.mobile.course.mgr.CourseInfo courseInfo = new com.up366.mobile.course.mgr.CourseInfo();
        courseInfo.setCourseId(this.currentCourseId);
        java.util.List<com.up366.mobile.course.task.TaskInfoV2> listFilterByBookId = com.up366.mobile.course.task.TaskFilterHelper.filterByBookId(com.up366.mobile.course.task.TaskFilterHelper.filterByCourseInfo(tasks, courseInfo), this.currentBookId);
        kotlin.jvm.internal.Intrinsics.checkNotNull(listFilterByBookId);
        return listFilterByBookId;
    }

    private final void setTaskCourseName(java.util.List<com.up366.mobile.course.task.TaskInfoV2> tasks, java.util.List<com.up366.mobile.course.mgr.CourseInfo> courses) {
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : tasks) {
            for (com.up366.mobile.course.mgr.CourseInfo courseInfo : courses) {
                if (taskInfoV2.getCourseId() == courseInfo.getCourseId()) {
                    taskInfoV2.setCourseName(courseInfo.getCourseName());
                }
            }
        }
    }

    public final void filterTasksBySearch(com.up366.mobile.course.task.TaskActivity activity, java.util.List<com.up366.mobile.course.task.TaskInfoV2> tasks) {
        if (activity == null || tasks == null) {
            return;
        }
        java.lang.String str = activity.searchText;
        java.lang.String str2 = str;
        if (android.text.TextUtils.isEmpty(str2)) {
            return;
        }
        java.util.Iterator<com.up366.mobile.course.task.TaskInfoV2> it = tasks.iterator();
        while (it.hasNext()) {
            java.lang.String jobName = it.next().getJobName();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jobName, "getJobName(...)");
            kotlin.jvm.internal.Intrinsics.checkNotNull(str);
            if (!kotlin.text.StringsKt.contains$default(jobName, str2, false, 2, (java.lang.Object) null)) {
                it.remove();
            }
        }
    }
}
