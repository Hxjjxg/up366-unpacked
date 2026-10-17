package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V7BookTaskLogHelper {
    private static final com.up366.common.task.TaskExecutor executor = com.up366.common.task.TaskUtils.createSerialExecutor("v7bookTaskLogExecutor");
    private final com.up366.mobile.book.model.BookInfoStudy book;
    private com.up366.mobile.book.model.CatalogPage catalogPage;
    private final com.up366.mobile.book.model.OpenConfigInfo cfg;
    private boolean isActive = false;
    private com.up366.mobile.book.model.BookTaskLogV2 log;
    private long time;

    public V7BookTaskLogHelper(com.up366.mobile.book.model.CatalogPage catalogPage, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        this.catalogPage = catalogPage;
        this.book = bookInfoStudy;
        this.cfg = openConfigInfo;
    }

    public void onEnterPage() {
        if (this.catalogPage == null) {
            return;
        }
        this.time = android.os.SystemClock.elapsedRealtime();
        executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7BookTaskLogHelper$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onEnterPage$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEnterPage$0() throws java.lang.Exception {
        com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2 = (com.up366.mobile.book.model.BookTaskLogV2) com.up366.mobile.common.logic.Auth.cur().db().getBookTaskLogV2Dao().queryBuilder().where(com.up366.greendao.BookTaskLogV2Dao.Properties.TaskId.eq(this.catalogPage.obj.getTaskId()), new org.greenrobot.greendao.query.WhereCondition[0]).unique();
        this.log = bookTaskLogV2;
        if (bookTaskLogV2 == null) {
            com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV22 = new com.up366.mobile.book.model.BookTaskLogV2();
            this.log = bookTaskLogV22;
            bookTaskLogV22.setTaskId(this.catalogPage.obj.getTaskId());
            this.log.setBookId(this.catalogPage.obj.getBookId());
            this.log.setAddTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
            this.log.setStudyDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
            com.up366.mobile.common.logic.Auth.cur().db().insertOrReplace(this.log);
        }
        if (this.isActive) {
            return;
        }
        this.isActive = true;
        updateDuration();
    }

    public void onStop() {
        this.isActive = false;
        if (this.catalogPage == null) {
            return;
        }
        final long studyTime = getStudyTime();
        executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7BookTaskLogHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onStop$1(studyTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStop$1(long j) throws java.lang.Exception {
        this.log.addStudyTime(j);
        com.up366.mobile.common.logic.Auth.cur().db().insertOrReplace(this.log);
    }

    private long getStudyTime() {
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.time;
        this.time = android.os.SystemClock.elapsedRealtime();
        return jElapsedRealtime;
    }

    public void onResume() {
        this.time = android.os.SystemClock.elapsedRealtime();
        if (this.isActive) {
            return;
        }
        this.isActive = true;
        updateDuration();
    }

    public void onPause() {
        this.isActive = false;
        final long studyTime = getStudyTime();
        executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7BookTaskLogHelper$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onPause$2(studyTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPause$2(long j) throws java.lang.Exception {
        this.log.addStudyTime(j);
        com.up366.mobile.common.logic.Auth.cur().db().insertOrReplace(this.log);
    }

    private void updateDuration() {
        com.up366.common.task.TaskUtils.postLazyTaskGlobal(java.lang.Integer.valueOf(hashCode()), 10000, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7BookTaskLogHelper$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$updateDuration$4();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDuration$4() throws java.lang.Exception {
        if (this.isActive) {
            final long studyTime = getStudyTime();
            this.time = android.os.SystemClock.elapsedRealtime();
            executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7BookTaskLogHelper$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$updateDuration$3(studyTime);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDuration$3(long j) throws java.lang.Exception {
        this.log.addStudyTime(j);
        com.up366.mobile.common.logic.Auth.cur().db().insertOrReplace(this.log);
        updateDuration();
    }

    private void submitTaskImpl(final java.lang.String str, final float f, final float f2, final java.lang.String str2, final java.util.List<java.lang.String> list, final int i, final int i2, final com.alibaba.fastjson.JSONArray jSONArray) {
        final long studyTime = getStudyTime();
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask = new com.alibaba.fastjson.JSONObject();
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, this.log.getTaskId());
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("code", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("info", "上传中");
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("status", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("max", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("progress", 0);
        com.up366.mobile.book.helper.BookTaskLogHelper.addingUploadTask.put("percent", 0);
        executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V7BookTaskLogHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$submitTaskImpl$5(studyTime, str, f, f2, list, i, jSONArray, str2, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submitTaskImpl$5(long j, java.lang.String str, float f, float f2, java.util.List list, int i, com.alibaba.fastjson.JSONArray jSONArray, java.lang.String str2, int i2) throws java.lang.Exception {
        java.lang.String str3 = this.cfg.studyTaskId;
        this.log.addStudyTime(j);
        this.log.setTaskNo(str);
        this.log.setScore(f);
        this.log.setPercent(f2);
        this.log.setStudyDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        this.log.setGuid(com.up366.mobile.book.model.AnswerEleAttrInfo.UUID());
        this.log.setFileUrls(android.text.TextUtils.join(";", list));
        this.log.setStudyTaskId(str3);
        this.log.setSubmitType(i);
        java.lang.String bookId = getBookId();
        java.lang.String chapterId = getChapterId();
        java.lang.String taskId = getTaskId();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookId);
        jSONObject.put("chapterId", chapterId);
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, taskId);
        jSONObject.put("score", java.lang.Float.valueOf(f));
        jSONObject.put("studyDate", java.lang.Long.valueOf(this.log.getStudyDate()));
        jSONObject.put("taskNo", str);
        jSONObject.put("seconds", java.lang.Integer.valueOf(this.log.getStudyTime()));
        jSONObject.put("result", "");
        jSONObject.put("qstJson", jSONArray);
        jSONObject.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
        jSONObject.put("percent", java.lang.Float.valueOf(f2));
        jSONObject.put("extendParams", com.alibaba.fastjson.JSON.parse(str2));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(this.book.getCourseId()));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, this.log.getStudyTaskId());
        jSONObject.put("killStudyTask", java.lang.Integer.valueOf(i2));
        this.log.setAnswers(jSONObject.toJSONString());
        com.up366.mobile.common.logic.Auth.cur().bookLog().addBookTaskLog(this.log);
        com.up366.mobile.common.logic.Auth.cur().db().getBookTaskLogV2Dao().queryBuilder().where(com.up366.greendao.BookTaskLogV2Dao.Properties.TaskId.eq(this.log.getTaskId()), new org.greenrobot.greendao.query.WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
        this.time = android.os.SystemClock.elapsedRealtime();
        com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2 = new com.up366.mobile.book.model.BookTaskLogV2();
        this.log = bookTaskLogV2;
        bookTaskLogV2.setTaskId(taskId);
        this.log.setBookId(bookId);
        this.log.setAddTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        this.log.setStudyDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
    }

    private java.lang.String getTaskId() {
        com.up366.mobile.book.model.CatalogPage catalogPage = this.catalogPage;
        if (catalogPage == null) {
            return "";
        }
        return catalogPage.obj.getTaskId();
    }

    private java.lang.String getBookId() {
        return this.book.getBookId();
    }

    private java.lang.String getChapterId() {
        com.up366.mobile.book.model.CatalogPage catalogPage = this.catalogPage;
        if (catalogPage != null) {
            return this.catalogPage.getChapterPPage() != null ? this.catalogPage.getChapterPPage().obj.getId() : catalogPage.obj.getId();
        }
        return "";
    }

    public void submitTaskV1(java.lang.String str, com.up366.mobile.book.model.CatalogPage catalogPage) {
        com.up366.mobile.book.studyviews.model.V6JSSubmitTaskHolder v6JSSubmitTaskHolder = (com.up366.mobile.book.studyviews.model.V6JSSubmitTaskHolder) com.alibaba.fastjson.JSON.parseObject(str, com.up366.mobile.book.studyviews.model.V6JSSubmitTaskHolder.class);
        java.util.List<java.lang.String> urlList = v6JSSubmitTaskHolder.getUrlList();
        if (urlList == null) {
            urlList = new java.util.ArrayList<>();
        }
        java.util.List<java.lang.String> list = urlList;
        findElementAttrUrls(list, v6JSSubmitTaskHolder.getElementAttr());
        submitTaskImpl(v6JSSubmitTaskHolder.getTaskNo(), v6JSSubmitTaskHolder.getScore(), v6JSSubmitTaskHolder.getPercent(), v6JSSubmitTaskHolder.getExtendParams(), list, v6JSSubmitTaskHolder.getSubmitType(), v6JSSubmitTaskHolder.getKillStudyTask(), buildQstJSON(v6JSSubmitTaskHolder.getElementAttr(), catalogPage != null ? catalogPage.obj.getId() : null));
        if (catalogPage != null) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.TaskScoreUpdateEvent(((com.up366.mobile.book.model.CatalogChapter) catalogPage.getChapterPPage()).obj.getId(), catalogPage.obj.getTaskId(), v6JSSubmitTaskHolder.getScore(), (int) v6JSSubmitTaskHolder.getPercent()));
        }
    }

    private com.alibaba.fastjson.JSONArray buildQstJSON(java.lang.String str, java.lang.String str2) {
        com.alibaba.fastjson.JSONArray<com.alibaba.fastjson.JSONObject> array = com.alibaba.fastjson.JSON.parseArray(str);
        if (array == null) {
            array = new com.alibaba.fastjson.JSONArray();
        }
        for (com.alibaba.fastjson.JSONObject jSONObject : array) {
            if (!jSONObject.containsKey("pageId")) {
                jSONObject.put("pageId", str2);
            }
            if (!jSONObject.containsKey("addTime")) {
                jSONObject.put("addTime", java.lang.Long.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()));
            }
            jSONObject.put("elementAttr", jSONObject.getString("elementAttr"));
            jSONObject.put("elementType", jSONObject.getString("elementType"));
        }
        return array;
    }

    private void findElementAttrUrls(java.util.List<java.lang.String> list, java.lang.String str) {
        com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSON.parseArray(str);
        if (array == null) {
            return;
        }
        java.util.Iterator it = array.iterator();
        while (it.hasNext()) {
            com.alibaba.fastjson.JSONObject jSONObject = ((com.alibaba.fastjson.JSONObject) it.next()).getJSONObject("elementAttr");
            if (jSONObject != null) {
                java.lang.String string = jSONObject.getString("record_url");
                if (!android.text.TextUtils.isEmpty(string)) {
                    list.add(string);
                }
            }
        }
    }
}
