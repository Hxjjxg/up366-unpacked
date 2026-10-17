package com.up366.mobile.course.mgr;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class CourseMgr {
    private final android.util.SparseArray<com.up366.mobile.course.mgr.CourseInfo> courseMap = new android.util.SparseArray<>();
    private final com.up366.greendao.DaoSession db;
    private final com.up366.mobile.common.logic.Manager manager;

    static /* synthetic */ void lambda$loadJumpCourseIdByCourseIdAndBookId$14(com.up366.common.http.Response response, java.util.List list) {
    }

    static /* synthetic */ void lambda$new$0(int i, java.lang.String str, java.util.List list) {
    }

    static /* synthetic */ void lambda$selectCourseIdContainsBookWithCallback$6() throws java.lang.Exception {
    }

    public CourseMgr(com.up366.mobile.common.logic.Manager manager) {
        this.manager = manager;
        this.db = manager.db();
        loadCourseList(new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                com.up366.mobile.course.mgr.CourseMgr.lambda$new$0(i, str, (java.util.List) obj);
            }
        });
    }

    public void fetchCourseList() {
        fetchCourseList(null);
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.mgr.CourseMgr$1, reason: invalid class name */
    class AnonymousClass1 extends com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.mgr.CourseInfo>> {
        final /* synthetic */ com.up366.common.callback.ICallbackResponse val$callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(java.lang.String str, com.up366.common.callback.ICallbackResponse iCallbackResponse) {
            super(str);
            this.val$callback = iCallbackResponse;
        }

        @Override // com.up366.common.http.RequestParams
        public java.util.List<com.up366.mobile.course.mgr.CourseInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
            final java.util.List<com.up366.mobile.course.mgr.CourseInfo> array = com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.course.mgr.CourseInfo.class);
            final java.util.ArrayList arrayList = new java.util.ArrayList();
            com.up366.mobile.course.mgr.CourseMgr.this.fillCourseMap(array);
            int i = 0;
            for (com.up366.mobile.course.mgr.CourseInfo courseInfo : array) {
                int i2 = i + 1;
                courseInfo.setDisplayOrder(i);
                for (com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo : courseInfo.getBooks()) {
                    courseBookInfo.setCourseId(courseInfo.getCourseId());
                    courseBookInfo.genGuid();
                }
                arrayList.addAll(courseInfo.getBooks());
                i = i2;
            }
            com.up366.mobile.course.mgr.CourseMgr.this.db.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.course.mgr.CourseMgr$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handleResponse$0(arrayList, array);
                }
            });
            com.up366.mobile.course.mgr.CourseMgr.this.updateInterestSelectCourseCache(array);
            com.up366.mobile.course.mgr.CourseMgr.this.setUpCourseBookNewStatus(arrayList);
            return array;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleResponse$0(java.util.List list, java.util.List list2) {
            com.up366.mobile.course.mgr.CourseMgr.this.db.deleteAll(com.up366.mobile.course.mgr.CourseBookInfo.class);
            com.up366.mobile.course.mgr.CourseMgr.this.db.deleteAll(com.up366.mobile.course.mgr.CourseInfo.class);
            com.up366.mobile.course.mgr.CourseMgr.this.db.getCourseBookInfoDao().insertInTx(list);
            com.up366.mobile.course.mgr.CourseMgr.this.db.getCourseInfoDao().insertInTx(list2);
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.mgr.CourseInfo> list) {
            super.onResponse(response, list);
            com.up366.common.callback.ICallbackResponse iCallbackResponse = this.val$callback;
            if (iCallbackResponse != null) {
                iCallbackResponse.onResult(response, list);
            }
        }
    }

    public void fetchCourseList(com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.course.mgr.CourseInfo>> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.course.mgr.CourseMgr.AnonymousClass1(com.up366.mobile.common.http.HttpMgrUtils.courseList, iCallbackResponse));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateInterestSelectCourseCache(java.util.List<com.up366.mobile.course.mgr.CourseInfo> list) {
        com.up366.mobile.course.mgr.CourseInfo courseInfo;
        if (list == null || list.isEmpty() || (courseInfo = (com.up366.mobile.course.mgr.CourseInfo) com.up366.mobile.common.logic.Auth.cur().cache().loadSync(com.up366.mobile.common.dialog.InterestSelectCourseDialog.CACHE_KEY, com.up366.mobile.course.mgr.CourseInfo.class)) == null) {
            return;
        }
        java.util.Iterator<com.up366.mobile.course.mgr.CourseInfo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getCourseId() == courseInfo.getCourseId()) {
                return;
            }
        }
        com.up366.mobile.common.logic.Auth.cur().cache().clear(com.up366.mobile.common.dialog.InterestSelectCourseDialog.CACHE_KEY);
        com.up366.mobile.common.onlinelog.OpLog.record("DB-updateInterestSelectCourseCache", "courseId not found: " + courseInfo.getCourseId());
    }

    public void loadCourseList(final com.up366.common.callback.ICallbackCodeInfoObj<java.util.List<com.up366.mobile.course.mgr.CourseInfo>> iCallbackCodeInfoObj) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda16
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$loadCourseList$3(iCallbackCodeInfoObj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadCourseList$3(final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj) throws java.lang.Exception {
        this.db.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadCourseList$2(iCallbackCodeInfoObj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadCourseList$2(final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj) {
        if (!com.up366.mobile.common.logic.Auth.isAuth()) {
            this.db.deleteAll(com.up366.mobile.course.mgr.CourseInfo.class);
            this.db.deleteAll(com.up366.mobile.course.mgr.CourseBookInfo.class);
            com.up366.mobile.common.onlinelog.OpLog.record("DB-saveCourseList-uid=0", "auth:false uid:" + com.up366.mobile.common.logic.Auth.UID());
        }
        final java.util.List<com.up366.mobile.course.mgr.CourseInfo> list = this.db.getCourseInfoDao().queryBuilder().orderAsc(new org.greenrobot.greendao.Property[]{com.up366.greendao.CourseInfoDao.Properties.DisplayOrder}).list();
        fillCourseMap(list);
        java.util.List listLoadAll = this.db.getCourseBookInfoDao().loadAll();
        setUpCourseBookNewStatus(listLoadAll);
        android.util.SparseArray sparseArray = new android.util.SparseArray();
        for (com.up366.mobile.course.mgr.CourseInfo courseInfo : list) {
            courseInfo.getBooks().clear();
            sparseArray.put(courseInfo.getCourseId(), courseInfo);
        }
        for (com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo : listLoadAll) {
            com.up366.mobile.course.mgr.CourseInfo courseInfo2 = (com.up366.mobile.course.mgr.CourseInfo) sparseArray.get(courseBookInfo.getCourseId());
            if (courseInfo2 != null) {
                courseInfo2.getBooks().add(courseBookInfo);
            }
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda12
            @Override // com.up366.common.task.Task
            public final void run() {
                iCallbackCodeInfoObj.onResult(0, null, list);
            }
        });
    }

    public void setUpCourseBookNewStatus(java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> list) {
        if (list == null) {
            return;
        }
        for (com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo : list) {
            java.lang.String str = (java.lang.String) this.manager.cache().loadSync("book-cached-version-" + courseBookInfo.getBookId(), java.lang.String.class);
            if (str != null && !str.equals(courseBookInfo.getMobileRevision())) {
                courseBookInfo.setNew(true);
            } else {
                courseBookInfo.setNew(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillCourseMap(java.util.List<com.up366.mobile.course.mgr.CourseInfo> list) {
        synchronized (this.courseMap) {
            this.courseMap.clear();
            for (com.up366.mobile.course.mgr.CourseInfo courseInfo : list) {
                this.courseMap.put(courseInfo.getCourseId(), courseInfo);
            }
        }
    }

    public com.up366.mobile.course.mgr.CourseInfo getCourseInfo(int i) {
        com.up366.mobile.course.mgr.CourseInfo courseInfo;
        if (i < 1) {
            return null;
        }
        synchronized (this.courseMap) {
            courseInfo = this.courseMap.get(i);
        }
        return courseInfo;
    }

    public void selectCourseIdContainsBook(android.app.Activity activity, java.lang.String str, int i, final androidx.core.util.Consumer<java.lang.Integer> consumer) {
        selectCourseIdContainsBookWithCallback(activity, str, i, new androidx.core.util.Consumer() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda1
            public final void accept(java.lang.Object obj) {
                com.up366.mobile.course.mgr.CourseMgr.lambda$selectCourseIdContainsBook$4(consumer, (java.lang.Integer) obj);
            }
        });
    }

    static /* synthetic */ void lambda$selectCourseIdContainsBook$4(androidx.core.util.Consumer consumer, java.lang.Integer num) {
        if (num != null) {
            consumer.accept(num);
        }
    }

    public void selectCourseIdContainsBookWithCallback(final android.app.Activity activity, java.lang.String str, final int i, final androidx.core.util.Consumer<java.lang.Integer> consumer) {
        if (i > 0) {
            consumer.accept(java.lang.Integer.valueOf(i));
            return;
        }
        if (android.text.TextUtils.equals(com.up366.mobile.book.helper.Tools.commonBookId, str)) {
            consumer.accept(java.lang.Integer.valueOf(i));
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            consumer.accept(java.lang.Integer.valueOf(i));
        } else if (com.up366.mobile.common.logic.Auth.isAuth()) {
            com.up366.common.task.TaskUtils.postLazyTaskMain("loadBookCourseList", 300, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda13
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "加载中");
                }
            });
            loadBookCourseList(str, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda14
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    com.up366.mobile.course.mgr.CourseMgr.lambda$selectCourseIdContainsBookWithCallback$10(activity, consumer, i, response, (java.util.List) obj);
                }
            });
        } else {
            consumer.accept(-1);
        }
    }

    static /* synthetic */ void lambda$selectCourseIdContainsBookWithCallback$10(android.app.Activity activity, final androidx.core.util.Consumer consumer, int i, com.up366.common.http.Response response, java.util.List list) {
        com.up366.common.task.TaskUtils.postLazyTaskMain("loadBookCourseList", new com.up366.common.task.Task() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.course.mgr.CourseMgr.lambda$selectCourseIdContainsBookWithCallback$6();
            }
        });
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        if (response != null && response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError(activity, "获取相关课程信息失败，请稍后重试");
            consumer.accept((java.lang.Object) null);
            return;
        }
        if (list.size() == 0) {
            consumer.accept(-1);
            return;
        }
        if (list.size() == 1) {
            consumer.accept(java.lang.Integer.valueOf(((com.up366.mobile.user.setting.MeTeachingClass) list.get(0)).getCourseId()));
            return;
        }
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((com.up366.mobile.user.setting.MeTeachingClass) it.next()).getCourseId() == i) {
                consumer.accept(java.lang.Integer.valueOf(i));
                return;
            }
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            com.up366.mobile.user.setting.MeTeachingClass meTeachingClass = (com.up366.mobile.user.setting.MeTeachingClass) it2.next();
            com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel = new com.up366.mobile.common.views.bottomsheet.BottomSheetModel();
            bottomSheetModel.setData(meTeachingClass);
            bottomSheetModel.setContent(meTeachingClass.getCourseName());
            arrayList.add(bottomSheetModel);
        }
        if (arrayList.size() == 1) {
            consumer.accept(java.lang.Integer.valueOf(((com.up366.mobile.user.setting.MeTeachingClass) ((com.up366.mobile.common.views.bottomsheet.BottomSheetModel) arrayList.get(0)).getData()).getCourseId()));
        } else {
            final java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(false);
            new com.up366.mobile.common.helper.BottomSheetHelper(activity).setTitle("请选择班级").setContents(arrayList).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda7
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(android.content.DialogInterface dialogInterface) {
                    com.up366.mobile.course.mgr.CourseMgr.lambda$selectCourseIdContainsBookWithCallback$7(atomicBoolean, consumer, dialogInterface);
                }
            }).setItemClickListener(new com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda8
                @Override // com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener
                public final void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel2) {
                    com.up366.mobile.course.mgr.CourseMgr.lambda$selectCourseIdContainsBookWithCallback$9(atomicBoolean, consumer, qMUIBottomSheet, bottomSheetModel2);
                }
            }).show();
        }
    }

    static /* synthetic */ void lambda$selectCourseIdContainsBookWithCallback$7(java.util.concurrent.atomic.AtomicBoolean atomicBoolean, androidx.core.util.Consumer consumer, android.content.DialogInterface dialogInterface) {
        if (atomicBoolean.get()) {
            return;
        }
        consumer.accept((java.lang.Object) null);
    }

    static /* synthetic */ void lambda$selectCourseIdContainsBookWithCallback$9(java.util.concurrent.atomic.AtomicBoolean atomicBoolean, final androidx.core.util.Consumer consumer, com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, final com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel) {
        atomicBoolean.set(true);
        com.up366.common.task.TaskUtils.postMainTaskDelay(250L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() {
                consumer.accept(java.lang.Integer.valueOf(((com.up366.mobile.user.setting.MeTeachingClass) bottomSheetModel.getData()).getCourseId()));
            }
        });
    }

    public void loadBookCourseList(final java.lang.String str, final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.user.setting.MeTeachingClass>> iCallbackResponse) {
        final java.util.List list = (java.util.List) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync(com.up366.mobile.common.utils.AppCacheKeysUtils.LOAD_BOOK_COURSE_LIST + str);
        if (list != null) {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackResponse.onResult(null, list);
                }
            });
        } else {
            loadCourseWhichHasBook(str, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda11
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    com.up366.mobile.course.mgr.CourseMgr.lambda$loadBookCourseList$12(str, iCallbackResponse, response, (java.util.List) obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$loadBookCourseList$12(java.lang.String str, com.up366.common.callback.ICallbackResponse iCallbackResponse, com.up366.common.http.Response response, java.util.List list) {
        if (!response.isError()) {
            com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync(com.up366.mobile.common.utils.AppCacheKeysUtils.LOAD_BOOK_COURSE_LIST + str, list, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MINUTE_5);
        }
        iCallbackResponse.onResult(response, list);
    }

    public void loadCourseWhichHasBook(final java.lang.String str, final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.user.setting.MeTeachingClass>> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.user.setting.MeTeachingClass>>(com.up366.mobile.common.http.HttpMgrUtils.GET_COURSE_LIST_OF_BOOK) { // from class: com.up366.mobile.course.mgr.CourseMgr.2
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, str);
            }

            @Override // com.up366.common.http.RequestParams
            public java.util.List<com.up366.mobile.user.setting.MeTeachingClass> handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                if (com.up366.common.StringUtils.isEmptyOrNull(str2)) {
                    str2 = "[]";
                }
                return com.alibaba.fastjson.JSON.parseArray(str2, com.up366.mobile.user.setting.MeTeachingClass.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.user.setting.MeTeachingClass> list) {
                iCallbackResponse.onResult(response, list);
            }
        });
    }

    public void loadJumpCourseIdByCourseIdAndBookId(java.lang.String str, final java.lang.String str2, final com.up366.common.callback.ICallbackCodeInfoObj<java.lang.Integer> iCallbackCodeInfoObj) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            iCallbackCodeInfoObj.onResult(0, null, -1);
            return;
        }
        try {
            final int i = java.lang.Integer.parseInt(str);
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda20
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$loadJumpCourseIdByCourseIdAndBookId$16(str2, iCallbackCodeInfoObj, i);
                }
            });
        } catch (java.lang.Exception unused) {
            iCallbackCodeInfoObj.onResult(0, null, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadJumpCourseIdByCourseIdAndBookId$16(final java.lang.String str, final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, final int i) throws java.lang.Exception {
        loadCourseWhichHasBook(str, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda15
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$loadJumpCourseIdByCourseIdAndBookId$15(str, iCallbackCodeInfoObj, i, response, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadJumpCourseIdByCourseIdAndBookId$15(java.lang.String str, com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, int i, com.up366.common.http.Response response, java.util.List list) {
        java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> listLoadCourseBookInfoSByBookId = loadCourseBookInfoSByBookId(str);
        if (response.isError()) {
            if (listLoadCourseBookInfoSByBookId.size() == 0) {
                iCallbackCodeInfoObj.onResult(0, null, -1);
                return;
            } else {
                iCallbackCodeInfoObj.onResult(0, null, java.lang.Integer.valueOf(listLoadCourseBookInfoSByBookId.get(0).getCourseId()));
                return;
            }
        }
        if (list.size() == 0) {
            iCallbackCodeInfoObj.onResult(0, null, -1);
            return;
        }
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((com.up366.mobile.user.setting.MeTeachingClass) it.next()).getCourseId() == i) {
                iCallbackCodeInfoObj.onResult(0, null, java.lang.Integer.valueOf(i));
                return;
            }
        }
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda18
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return java.lang.Long.compare(((com.up366.mobile.user.setting.MeTeachingClass) obj2).getJoinTime(), ((com.up366.mobile.user.setting.MeTeachingClass) obj).getJoinTime());
            }
        });
        iCallbackCodeInfoObj.onResult(0, null, java.lang.Integer.valueOf(((com.up366.mobile.user.setting.MeTeachingClass) list.get(0)).getCourseId()));
        if (listLoadCourseBookInfoSByBookId.size() == 0) {
            fetchCourseList(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda19
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response2, java.lang.Object obj) {
                    com.up366.mobile.course.mgr.CourseMgr.lambda$loadJumpCourseIdByCourseIdAndBookId$14(response2, (java.util.List) obj);
                }
            });
        }
    }

    public java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> loadCourseBookInfoS() {
        return this.db.getCourseBookInfoDao().loadAll();
    }

    public java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> loadCourseBookInfoSByBookId(java.lang.String str) {
        return this.db.getCourseBookInfoDao().queryBuilder().where(com.up366.greendao.CourseBookInfoDao.Properties.BookId.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).list();
    }

    public void loadDailyInterest(final com.up366.common.callback.ICallbackCodeInfoObj<java.util.List<com.up366.mobile.course.mgr.DailyInterestInfo>> iCallbackCodeInfoObj) {
        final java.lang.String str = "dailyInterestSentence";
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda17
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$loadDailyInterest$19(str, iCallbackCodeInfoObj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadDailyInterest$19(java.lang.String str, final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj) throws java.lang.Exception {
        final java.util.List<com.up366.mobile.course.mgr.DailyInterestInfo> list = (java.util.List) this.manager.cache().loadSync(str, new com.alibaba.fastjson.TypeReference<java.util.List<com.up366.mobile.course.mgr.DailyInterestInfo>>() { // from class: com.up366.mobile.course.mgr.CourseMgr.3
        });
        if (list != null) {
            setUpNewStatus(list);
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda9
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackCodeInfoObj.onResult(0, "", list);
                }
            });
        } else {
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda10
                @Override // com.up366.common.task.Task
                public final void run() {
                    iCallbackCodeInfoObj.onResult(1, "no cached daily interest", null);
                }
            });
        }
    }

    public void fetchDailyInterest(final com.up366.common.callback.ICallbackResponse<java.util.List<com.up366.mobile.course.mgr.DailyInterestInfo>> iCallbackResponse) {
        if (((java.lang.Boolean) this.manager.cache().loadMemorySync("dailyInterestRefreshTime")) != null) {
            com.up366.common.log.Logger.info("TAG - CourseMgr - fetchDailyInterest - load data from memory cache");
            loadDailyInterest(new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.course.mgr.CourseMgr$$ExternalSyntheticLambda5
                @Override // com.up366.common.callback.ICallbackCodeInfoObj
                public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                    com.up366.mobile.course.mgr.CourseMgr.lambda$fetchDailyInterest$20(iCallbackResponse, i, str, (java.util.List) obj);
                }
            });
        } else {
            this.manager.cache().putMemorySync("dailyInterestRefreshTime", true, com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS);
            final java.lang.String str = "dailyInterestSentence";
            com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.course.mgr.DailyInterestInfo>>(com.up366.mobile.common.http.HttpMgrUtils.dailyInterestSentence) { // from class: com.up366.mobile.course.mgr.CourseMgr.4
                @Override // com.up366.common.http.RequestParams
                public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                    super.initParams(map);
                    map.put("organId", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.getUserInfo().getOrganId()));
                }

                @Override // com.up366.common.http.RequestParams
                public java.util.List<com.up366.mobile.course.mgr.DailyInterestInfo> handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                    java.util.List<com.up366.mobile.course.mgr.DailyInterestInfo> array = com.alibaba.fastjson.JSON.parseArray(str2, com.up366.mobile.course.mgr.DailyInterestInfo.class);
                    com.up366.mobile.course.mgr.CourseMgr.this.setUpNewStatus(array);
                    com.up366.mobile.course.mgr.CourseMgr.this.manager.cache().put(str, array, 86400000L);
                    return array;
                }

                @Override // com.up366.common.http.RequestParams
                public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.course.mgr.DailyInterestInfo> list) {
                    super.onResponse(response, list);
                    iCallbackResponse.onResult(response, list);
                }
            });
        }
    }

    static /* synthetic */ void lambda$fetchDailyInterest$20(com.up366.common.callback.ICallbackResponse iCallbackResponse, int i, java.lang.String str, java.util.List list) {
        if (i == 0) {
            iCallbackResponse.onResult(new com.up366.common.http.Response(i, "cached daily interest", str, 0, "0"), list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpNewStatus(java.util.List<com.up366.mobile.course.mgr.DailyInterestInfo> list) {
        if (list == null) {
            return;
        }
        for (com.up366.mobile.course.mgr.DailyInterestInfo dailyInterestInfo : list) {
            java.lang.String str = (java.lang.String) this.manager.cache().loadSync("book-cached-version-" + dailyInterestInfo.getBookId(), java.lang.String.class);
            if (str != null && !str.equals(dailyInterestInfo.getMobileRevision())) {
                dailyInterestInfo.setNew(true);
            } else {
                dailyInterestInfo.setNew(false);
            }
        }
    }

    public java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> loadAll() {
        return this.db.getCourseBookInfoDao().loadAll();
    }
}
