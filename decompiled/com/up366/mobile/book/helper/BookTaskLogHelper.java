package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookTaskLogHelper {
    public static com.alibaba.fastjson.JSONObject addingUploadTask;
    public static java.lang.Runnable addingUploadTaskCallback;
    private static com.up366.common.task.TaskExecutor executor = com.up366.common.task.TaskUtils.createSerialExecutor("bookTaskLogExecutor");
    private com.up366.mobile.book.model.AnswerEleAttrInfo attrInfo;
    private final com.up366.mobile.book.model.BookInfoStudy book;
    private com.up366.mobile.book.model.CatalogPage catalogPage;
    private final com.up366.mobile.book.model.OpenConfigInfo cfg;
    private boolean isActive = false;
    private com.up366.mobile.book.model.BookTaskLogV2 log;
    private long time;

    public BookTaskLogHelper(com.up366.mobile.book.model.CatalogPage catalogPage, com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        this.catalogPage = catalogPage;
        this.book = bookInfoStudy;
        this.cfg = openConfigInfo;
    }

    public void addAnswers(final com.up366.mobile.book.model.CatalogPage catalogPage, final java.util.List<com.up366.mobile.book.model.AnswerEleAttrInfo.AnswerJSLog> list) {
        final long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.BookTaskLogHelper$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$addAnswers$0(catalogPage, currentNtpTimeInMillisecond, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addAnswers$0(com.up366.mobile.book.model.CatalogPage catalogPage, long j, java.util.List list) throws java.lang.Exception {
        this.attrInfo.addAnswers(catalogPage, j, list);
        this.log.setAnswers(com.alibaba.fastjson.JSON.toJSONString(this.attrInfo));
        com.up366.mobile.common.logic.Auth.cur().db().insertOrReplace(this.log);
    }

    public void onEnterPage() {
        if (this.catalogPage == null) {
            return;
        }
        this.time = android.os.SystemClock.elapsedRealtime();
        executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.BookTaskLogHelper$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onEnterPage$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEnterPage$1() throws java.lang.Exception {
        com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2 = (com.up366.mobile.book.model.BookTaskLogV2) com.up366.mobile.common.logic.Auth.cur().db().getBookTaskLogV2Dao().queryBuilder().where(com.up366.greendao.BookTaskLogV2Dao.Properties.TaskId.eq(this.catalogPage.obj.getTaskId()), new org.greenrobot.greendao.query.WhereCondition[0]).unique();
        this.log = bookTaskLogV2;
        if (bookTaskLogV2 == null) {
            com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV22 = new com.up366.mobile.book.model.BookTaskLogV2();
            this.log = bookTaskLogV22;
            bookTaskLogV22.setTaskId(this.catalogPage.obj.getTaskId());
            this.log.setBookId(this.catalogPage.obj.getBookId());
            this.log.setAddTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
            this.log.setStudyDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
            com.up366.mobile.book.model.AnswerEleAttrInfo answerEleAttrInfo = new com.up366.mobile.book.model.AnswerEleAttrInfo(this.catalogPage, this.log, this.book.getCourseId(), this.cfg.studyTaskId);
            this.attrInfo = answerEleAttrInfo;
            this.log.setAnswers(com.alibaba.fastjson.JSON.toJSONString(answerEleAttrInfo));
            com.up366.mobile.common.logic.Auth.cur().db().insertOrReplace(this.log);
        } else {
            com.up366.mobile.book.model.AnswerEleAttrInfo answerEleAttrInfo2 = (com.up366.mobile.book.model.AnswerEleAttrInfo) com.alibaba.fastjson.JSON.parseObject(bookTaskLogV2.getAnswers(), com.up366.mobile.book.model.AnswerEleAttrInfo.class);
            this.attrInfo = answerEleAttrInfo2;
            if (answerEleAttrInfo2 == null) {
                this.attrInfo = (com.up366.mobile.book.model.AnswerEleAttrInfo) com.alibaba.fastjson.JSON.parseObject("{}", com.up366.mobile.book.model.AnswerEleAttrInfo.class);
            }
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
        executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.BookTaskLogHelper$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onStop$2(studyTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStop$2(long j) throws java.lang.Exception {
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
        executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.BookTaskLogHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onPause$3(studyTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPause$3(long j) throws java.lang.Exception {
        this.log.addStudyTime(j);
        com.up366.mobile.common.logic.Auth.cur().db().insertOrReplace(this.log);
    }

    private void updateDuration() {
        com.up366.common.task.TaskUtils.postLazyTaskGlobal(java.lang.Integer.valueOf(hashCode()), 10000, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.BookTaskLogHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$updateDuration$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDuration$5() throws java.lang.Exception {
        if (this.isActive) {
            final long studyTime = getStudyTime();
            this.time = android.os.SystemClock.elapsedRealtime();
            executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.BookTaskLogHelper$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$updateDuration$4(studyTime);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDuration$4(long j) throws java.lang.Exception {
        this.log.addStudyTime(j);
        com.up366.mobile.common.logic.Auth.cur().db().insertOrReplace(this.log);
        updateDuration();
    }

    public void submitTask(java.lang.String str, float f, float f2, java.lang.String str2) {
        submitTaskImpl(str, f, f2, str2, null, 0, 0);
    }

    private void submitTaskImpl(final java.lang.String str, final float f, final float f2, final java.lang.String str2, final java.util.List<java.lang.String> list, final int i, final int i2) {
        final long studyTime = getStudyTime();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        addingUploadTask = jSONObject;
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, this.log.getTaskId());
        addingUploadTask.put("code", 0);
        addingUploadTask.put("info", "上传中");
        addingUploadTask.put("status", 0);
        addingUploadTask.put("max", 0);
        addingUploadTask.put("progress", 0);
        addingUploadTask.put("percent", 0);
        executor.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.BookTaskLogHelper$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$submitTaskImpl$6(list, f2, str2, i2, studyTime, str, f, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submitTaskImpl$6(java.util.List list, float f, java.lang.String str, int i, long j, java.lang.String str2, float f2, int i2) throws java.lang.Exception {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (this.attrInfo.getQstJson().size() == 0) {
            com.up366.common.log.Logger.warn("submitTask " + this.log.getTaskId() + " error : QstJson().size() == 0");
        } else {
            java.util.Iterator<com.up366.mobile.book.model.AnswerEleAttrInfo.EleAttrInfo> it = this.attrInfo.getQstJson().iterator();
            while (it.hasNext()) {
                java.lang.String string = com.alibaba.fastjson.JSON.parseObject(it.next().getElementAttr()).getString("record_url");
                if (!com.up366.common.StringUtils.isEmptyOrNull(string)) {
                    sb.append(string);
                    sb.append(";");
                }
            }
        }
        if (list != null) {
            java.util.Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                java.lang.String str3 = (java.lang.String) it2.next();
                if (!com.up366.common.StringUtils.isEmptyOrNull(str3)) {
                    sb.append(str3);
                    sb.append(";");
                }
            }
        }
        java.lang.String str4 = this.cfg.studyTaskId;
        this.attrInfo.setPercent(f);
        this.attrInfo.setExtendParams(str);
        this.attrInfo.setKillStudyTask(i);
        this.log.addStudyTime(j);
        this.log.setTaskNo(str2);
        this.log.setScore(f2);
        this.log.setPercent(f);
        this.log.setStudyDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        this.attrInfo.init(this.catalogPage, this.log, this.book.getCourseId(), str4);
        this.log.setAnswers(com.alibaba.fastjson.JSON.toJSONString(this.attrInfo));
        this.log.setGuid(com.up366.mobile.book.model.AnswerEleAttrInfo.UUID());
        this.log.setFileUrls(sb.toString());
        this.log.setStudyTaskId(str4);
        this.log.setSubmitType(i2);
        com.up366.mobile.common.logic.Auth.cur().bookLog().addBookTaskLog(this.log);
        com.up366.mobile.common.logic.Auth.cur().db().getBookTaskLogV2Dao().queryBuilder().where(com.up366.greendao.BookTaskLogV2Dao.Properties.TaskId.eq(this.log.getTaskId()), new org.greenrobot.greendao.query.WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
        this.time = android.os.SystemClock.elapsedRealtime();
        com.up366.mobile.book.model.BookTaskLogV2 bookTaskLogV2 = new com.up366.mobile.book.model.BookTaskLogV2();
        this.log = bookTaskLogV2;
        bookTaskLogV2.setTaskId(this.catalogPage.obj.getTaskId());
        this.log.setBookId(this.catalogPage.obj.getBookId());
        this.log.setAddTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        this.log.setStudyDate(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        this.attrInfo = new com.up366.mobile.book.model.AnswerEleAttrInfo(this.catalogPage, this.log, this.book.getCourseId(), this.cfg.studyTaskId);
    }

    public void submitEleAttr(com.up366.mobile.book.model.CatalogPage catalogPage, java.lang.String str) {
        com.up366.common.log.Logger.debug("submitEleAttr(answer) length:" + str.length());
        java.util.List<com.up366.mobile.book.model.AnswerEleAttrInfo.AnswerJSLog> array = com.alibaba.fastjson.JSON.parseArray(str, com.up366.mobile.book.model.AnswerEleAttrInfo.AnswerJSLog.class);
        if (array != null && array.size() > 0) {
            addAnswers(catalogPage, array);
            return;
        }
        com.up366.common.log.Logger.warn("ldx - submitEleAttr(String answer) : " + str);
    }

    public void submitTask(java.lang.String str, java.lang.String str2, float f, int i, com.up366.mobile.book.model.CatalogPage catalogPage) {
        com.up366.common.log.Logger.debug("页面submit() 提交");
        submitTaskImpl(str2, f, i, null, null, 0, 0);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.TaskScoreUpdateEvent(((com.up366.mobile.book.model.CatalogChapter) catalogPage.getChapterPPage()).obj.getId(), str, f, 100));
    }

    public void submitTaskV1(java.lang.String str, com.up366.mobile.book.model.CatalogPage catalogPage) {
        com.up366.common.log.Logger.debug("页面submit() 提交");
        com.up366.mobile.book.studyviews.model.V6JSSubmitTaskHolder v6JSSubmitTaskHolder = (com.up366.mobile.book.studyviews.model.V6JSSubmitTaskHolder) com.alibaba.fastjson.JSON.parseObject(str, com.up366.mobile.book.studyviews.model.V6JSSubmitTaskHolder.class);
        submitTaskImpl(v6JSSubmitTaskHolder.getTaskNo(), v6JSSubmitTaskHolder.getScore(), v6JSSubmitTaskHolder.getPercent(), v6JSSubmitTaskHolder.getExtendParams(), v6JSSubmitTaskHolder.getUrlList(), v6JSSubmitTaskHolder.getSubmitType(), v6JSSubmitTaskHolder.getKillStudyTask());
        com.up366.mobile.book.model.CatalogChapter catalogChapter = (com.up366.mobile.book.model.CatalogChapter) catalogPage.getChapterPPage();
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.TaskScoreUpdateEvent(catalogChapter.obj.getId(), catalogPage.obj.getTaskId(), v6JSSubmitTaskHolder.getScore(), (int) v6JSSubmitTaskHolder.getPercent()));
    }
}
