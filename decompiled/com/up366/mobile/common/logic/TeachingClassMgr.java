package com.up366.mobile.common.logic;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TeachingClassMgr {
    private final com.up366.greendao.DaoSession db;
    private volatile boolean localLoading = false;
    private volatile boolean webLoading = false;

    TeachingClassMgr(com.up366.mobile.common.logic.Manager manager) {
        this.db = manager.db();
    }

    public void loadTeachingClass() {
        if (this.localLoading) {
            return;
        }
        this.localLoading = true;
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.logic.TeachingClassMgr$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$loadTeachingClass$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadTeachingClass$0() throws java.lang.Exception {
        java.util.List list = this.db.getMeTeachingClassDao().queryBuilder().orderDesc(new org.greenrobot.greendao.Property[]{com.up366.greendao.MeTeachingClassDao.Properties.JoinTime}).list();
        this.localLoading = false;
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.MeTeachingClassRefreshEvent(list));
    }

    public void fetchTeachingClass() {
        if (this.webLoading) {
            return;
        }
        this.webLoading = true;
        com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.common.logic.TeachingClassMgr.AnonymousClass1(com.up366.mobile.common.http.HttpMgrUtils.getCourseListOfMy));
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.logic.TeachingClassMgr$1, reason: invalid class name */
    class AnonymousClass1 extends com.up366.common.http.RequestParams<java.util.List<com.up366.mobile.user.setting.MeTeachingClass>> {
        AnonymousClass1(java.lang.String str) {
            super(str);
        }

        @Override // com.up366.common.http.RequestParams
        public java.util.List<com.up366.mobile.user.setting.MeTeachingClass> handleResponse(com.up366.common.http.Response response, java.lang.String str) {
            final java.util.List array = com.up366.mobile.common.utils.ResponseUtil.parseArray(str, com.up366.mobile.user.setting.MeTeachingClass.class);
            com.up366.mobile.common.logic.TeachingClassMgr.this.db.runInTx(new java.lang.Runnable() { // from class: com.up366.mobile.common.logic.TeachingClassMgr$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handleResponse$0(array);
                }
            });
            return com.up366.mobile.common.logic.TeachingClassMgr.this.db.getMeTeachingClassDao().queryBuilder().orderDesc(new org.greenrobot.greendao.Property[]{com.up366.greendao.MeTeachingClassDao.Properties.JoinTime}).list();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleResponse$0(java.util.List list) {
            com.up366.mobile.common.logic.TeachingClassMgr.this.db.getMeTeachingClassDao().deleteAll();
            com.up366.mobile.common.logic.TeachingClassMgr.this.db.getMeTeachingClassDao().insertInTx(list);
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(com.up366.common.http.Response response, java.util.List<com.up366.mobile.user.setting.MeTeachingClass> list) {
            com.up366.mobile.common.logic.TeachingClassMgr.this.webLoading = false;
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.MeTeachingClassRefreshEvent(response, list));
        }
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.logic.TeachingClassMgr$2, reason: invalid class name */
    class AnonymousClass2 extends com.up366.common.http.RequestParams<java.lang.Object> {
        final /* synthetic */ com.up366.common.callback.ICallbackResponse val$callback;
        final /* synthetic */ com.up366.mobile.user.setting.MeTeachingClass val$entity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(java.lang.String str, com.up366.mobile.user.setting.MeTeachingClass meTeachingClass, com.up366.common.callback.ICallbackResponse iCallbackResponse) {
            super(str);
            this.val$entity = meTeachingClass;
            this.val$callback = iCallbackResponse;
        }

        @Override // com.up366.common.http.RequestParams
        public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
            map.put("courseIds", java.lang.Integer.valueOf(this.val$entity.getCourseId()));
        }

        @Override // com.up366.common.http.RequestParams
        public java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str) {
            if (response.getCode() == 0) {
                com.up366.mobile.common.logic.TeachingClassMgr.this.db.getMeTeachingClassDao().deleteByKey(this.val$entity.getRowId());
                com.up366.mobile.common.logic.TeachingClassMgr.this.db.getCourseInfoDao().queryBuilder().where(com.up366.greendao.CourseInfoDao.Properties.CourseId.eq(java.lang.Integer.valueOf(this.val$entity.getCourseId())), new org.greenrobot.greendao.query.WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
                com.up366.mobile.common.logic.AppCacheMgr appCacheMgrCache = com.up366.mobile.common.logic.Auth.cur().cache();
                final com.up366.mobile.user.setting.MeTeachingClass meTeachingClass = this.val$entity;
                appCacheMgrCache.load(com.up366.mobile.common.dialog.InterestSelectCourseDialog.CACHE_KEY, com.up366.mobile.course.mgr.CourseInfo.class, new com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache() { // from class: com.up366.mobile.common.logic.TeachingClassMgr$2$$ExternalSyntheticLambda0
                    @Override // com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache
                    public final void onLoad(java.lang.Object obj) {
                        com.up366.mobile.common.logic.TeachingClassMgr.AnonymousClass2.lambda$handleResponse$0(meTeachingClass, (com.up366.mobile.course.mgr.CourseInfo) obj);
                    }
                });
            }
            return super.handleResponse(response, str);
        }

        static /* synthetic */ void lambda$handleResponse$0(com.up366.mobile.user.setting.MeTeachingClass meTeachingClass, com.up366.mobile.course.mgr.CourseInfo courseInfo) {
            if (courseInfo == null || meTeachingClass.getCourseId() != courseInfo.getCourseId()) {
                return;
            }
            com.up366.mobile.common.logic.Auth.cur().cache().clear(com.up366.mobile.common.dialog.InterestSelectCourseDialog.CACHE_KEY);
        }

        @Override // com.up366.common.http.RequestParams
        public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
            this.val$callback.onResult(response, obj);
        }
    }

    public void quitCourse(com.up366.mobile.user.setting.MeTeachingClass meTeachingClass, com.up366.common.callback.ICallbackResponse<java.lang.Object> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.mobile.common.logic.TeachingClassMgr.AnonymousClass2(com.up366.mobile.common.http.HttpMgrUtils.getCourseAllEditOfMy, meTeachingClass, iCallbackResponse));
    }

    public void findCourseByCode(final java.lang.String str, final com.up366.common.callback.ICallbackResponse<com.up366.mobile.main.FindCourseCodeData> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<com.up366.mobile.main.FindCourseCodeData>(com.up366.mobile.common.http.HttpMgrUtils.findCodeToCourse) { // from class: com.up366.mobile.common.logic.TeachingClassMgr.3
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put("courseCode", str);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.up366.common.http.RequestParams
            public com.up366.mobile.main.FindCourseCodeData handleResponse(com.up366.common.http.Response response, java.lang.String str2) {
                return (com.up366.mobile.main.FindCourseCodeData) com.up366.mobile.common.utils.ResponseUtil.parseObject(str2, com.up366.mobile.main.FindCourseCodeData.class);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, com.up366.mobile.main.FindCourseCodeData findCourseCodeData) {
                iCallbackResponse.onResult(response, findCourseCodeData);
            }
        });
    }

    public void courseCodeToJoinCourse(final java.lang.Integer num, final java.lang.Integer num2, final com.up366.common.callback.ICallbackResponse<java.lang.Object> iCallbackResponse) {
        com.up366.common.http.HttpUtilsUp.post(new com.up366.common.http.RequestParams<java.lang.Object>(com.up366.mobile.common.http.HttpMgrUtils.joinCourseByCourseId) { // from class: com.up366.mobile.common.logic.TeachingClassMgr.4
            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> map) {
                map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, num);
                map.put("classId", num2);
            }

            @Override // com.up366.common.http.RequestParams
            public java.lang.Object handleResponse(com.up366.common.http.Response response, java.lang.String str) {
                return super.handleResponse(response, str);
            }

            @Override // com.up366.common.http.RequestParams
            public void onResponse(com.up366.common.http.Response response, java.lang.Object obj) {
                iCallbackResponse.onResult(response, obj);
            }
        });
    }
}
