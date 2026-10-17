package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V6ExerciseOpenHelper {
    private final com.up366.mobile.book.StudyActivity context;

    public V6ExerciseOpenHelper(com.up366.mobile.book.StudyActivity studyActivity) {
        this.context = studyActivity;
    }

    public void openWrongQuestion() {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = this.context.book;
        final android.content.Intent intent = new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.course.wrongnote.WrongNoteActivity.class);
        intent.putExtra("stageId", bookInfoStudy.getStageId());
        intent.putExtra("subjectId", bookInfoStudy.getSubjectId());
        intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
        intent.putExtra("bookName", bookInfoStudy.getBookName());
        intent.putExtra("type", 2);
        intent.putExtra("fromType", 2);
        com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_WRONGNOTE).runWithTip(new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.V6ExerciseOpenHelper$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openWrongQuestion$0(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWrongQuestion$0(android.content.Intent intent) {
        this.context.startActivity(intent);
    }

    public void openWordNote() {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = this.context.book;
        final android.content.Intent intent = new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.course.unfamiliarWords.UnfamiliarWordActivity.class);
        intent.putExtra(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
        intent.putExtra("bookName", bookInfoStudy.getBookName());
        intent.putExtra("type", 2);
        intent.putExtra("fromType", 0);
        com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_WORDS).runWithTip(new java.lang.Runnable() { // from class: com.up366.mobile.book.helper.V6ExerciseOpenHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openWordNote$1(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openWordNote$1(android.content.Intent intent) {
        this.context.startActivity(intent);
    }

    public void trainingMode(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = this.context.book;
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("stageId", str);
        jSONObject.put("subjectId", str2);
        jSONObject.put("knowledgeId", str3);
        jSONObject.put("difficulty", str4);
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, bookInfoStudy.getBookId());
        jSONObject.put("fromJob", false);
        com.up366.mobile.book.helper.V8OpenHelper.openV8Page(this.context, "_SELF_STUDY_", jSONObject, null);
    }

    public void backToCatalog() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V6ExerciseOpenHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$backToCatalog$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$backToCatalog$2() throws java.lang.Exception {
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = this.context.book;
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.BackToBookCatalog(bookInfoStudy.getCourseId(), bookInfoStudy.getBookId()));
        if (!com.up366.mobile.book.activity.BookDataCache.getInstance().containsCatalogPage(bookInfoStudy.getCourseId(), bookInfoStudy.getBookId())) {
            this.context.openCatalogPage();
        }
        this.context.onBackPressed();
        this.context.finish();
    }

    public void gotoNativeModule(java.lang.String str) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        java.lang.String string = object.getString("moduleId");
        boolean z = object.getIntValue("destoryWebview") == 1;
        object.getJSONObject("data");
        string.hashCode();
        if (string.equals("INTELLIGENT_CLASSROOM")) {
            final android.content.Intent intent = new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.main.MainActivity.class);
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.OnBottomTabSelected(2));
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V6ExerciseOpenHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$gotoNativeModule$3(intent);
                }
            });
        } else if (string.equals("ALL_TASK_LIST")) {
            com.up366.mobile.course.task.TaskActivity.startTaskActivity(this.context);
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this.context, "未定义：" + string);
        }
        if (z) {
            this.context.backToBookshelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$gotoNativeModule$3(android.content.Intent intent) throws java.lang.Exception {
        this.context.startActivity(intent);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.app.Activity, com.up366.mobile.book.StudyActivity] */
    public void openDictionary(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - V6ExerciseOpenHelper - openDictionary - word:" + com.alibaba.fastjson.JSON.parseObject(str).getString(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD));
        ?? r0 = this.context;
        com.up366.mobile.book.StudyActivityDialog.openDict(r0, r0.rootView, str);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.app.Activity, com.up366.mobile.book.StudyActivity] */
    public void openDictionaryV2(java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - V6ExerciseOpenHelper - openDictionaryV2 - :" + str);
        ?? r0 = this.context;
        com.up366.mobile.book.StudyActivity2025Dialog.openDict(r0, r0.rootView, str);
    }

    public void launchXotEngine(java.lang.String str, java.lang.String str2, boolean z) {
        android.content.Intent intent = new android.content.Intent((android.content.Context) this.context, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("exercise_type", str);
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, com.alibaba.fastjson.JSON.parseObject(str2).toJSONString());
        this.context.startActivity(intent);
    }
}
