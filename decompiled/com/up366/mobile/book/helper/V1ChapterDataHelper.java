package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V1ChapterDataHelper {
    private com.up366.mobile.book.model.BookInfoStudy book;
    private com.up366.mobile.book.model.CatalogChapter chapter;
    public final com.up366.mobile.book.StudyActivity context;
    private java.util.List<com.up366.mobile.book.studyviews.model.V1QuestionInfo> questionList = new java.util.ArrayList();
    private java.util.List<com.up366.mobile.book.studyviews.model.V1QuestionInfo> realQuestionList = new java.util.ArrayList();

    public V1ChapterDataHelper(com.up366.mobile.book.StudyActivity studyActivity) {
        this.context = studyActivity;
    }

    public void init(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.CatalogChapter catalogChapter) {
        this.book = bookInfoStudy;
        this.chapter = catalogChapter;
        initQuestionList(com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), bookInfoStudy.getBookId(), catalogChapter.obj.getId(), "paperList.js")));
    }

    public void loadTotalTime(final com.up366.common.callback.ICallbackCodeInfoObj<java.lang.Integer> iCallbackCodeInfoObj) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V1ChapterDataHelper$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$loadTotalTime$1(iCallbackCodeInfoObj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadTotalTime$1(final com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj) throws java.lang.Exception {
        java.lang.String strJoin;
        com.up366.mobile.book.helper.V1AudioHelper v1AudioHelper = new com.up366.mobile.book.helper.V1AudioHelper();
        com.up366.common.log.Logger.debug("duration---- bookId : " + this.book.getBookId());
        int i = 0;
        final int i2 = 0;
        int i3 = 0;
        while (i < this.questionList.size()) {
            i3++;
            com.up366.mobile.book.studyviews.model.V1QuestionInfo v1QuestionInfo = this.questionList.get(i);
            if (v1QuestionInfo.getFlag() == 0) {
                strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.book.getBookId(), "common/media/", v1QuestionInfo.getMp3());
            } else {
                strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.book.getBookId(), v1QuestionInfo.getMp3());
            }
            int audioDuration = v1AudioHelper.getAudioDuration(strJoin);
            int timeInMillSeconds = getTimeInMillSeconds(v1QuestionInfo.getDelay());
            int i4 = audioDuration + timeInMillSeconds;
            if (i4 < 0 || (i4 > 3600000 && i3 < 30)) {
                i--;
                com.up366.common.log.Logger.debug("get mp3:\"" + strJoin + "\" duration error ... duration = " + i4);
            } else {
                if (i3 > 29) {
                    com.up366.common.log.Logger.error("get mp3:\"" + strJoin + "\" duration error ... duration = " + i4);
                    i4 = 0;
                }
                i2 += i4;
                com.up366.common.log.Logger.debug("duration----" + (i4 / 1000) + "s mm:" + i4 + "ms delayTime:" + timeInMillSeconds + "   mp3:" + v1QuestionInfo.getMp3());
                v1QuestionInfo.setDuration(i4);
                i3 = 0;
            }
            i++;
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V1ChapterDataHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                iCallbackCodeInfoObj.onResult(0, "", java.lang.Integer.valueOf(i2));
            }
        });
    }

    public java.util.List<com.up366.mobile.book.studyviews.model.V1QuestionInfo> getQuestionList() {
        return this.questionList;
    }

    public java.util.List<com.up366.mobile.book.studyviews.model.V1QuestionInfo> getRealQuestions() {
        return this.realQuestionList;
    }

    public java.lang.String getMp3Path(com.up366.mobile.book.studyviews.model.V1QuestionInfo v1QuestionInfo) {
        if (v1QuestionInfo.getFlag() == 0) {
            return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.book.getBookId(), "common/media/", v1QuestionInfo.getMp3());
        }
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.book.getBookId(), v1QuestionInfo.getMp3());
    }

    private void initQuestionList(java.lang.String str) {
        this.questionList.clear();
        this.realQuestionList.clear();
        try {
            com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSON.parseArray(str);
            for (int i = 0; i < array.size(); i++) {
                com.up366.mobile.book.studyviews.model.V1QuestionInfo v1QuestionInfo = new com.up366.mobile.book.studyviews.model.V1QuestionInfo(array.getJSONObject(i));
                this.questionList.add(v1QuestionInfo);
                if (v1QuestionInfo.getFlag() == 1 && v1QuestionInfo.getDisplay() == 1) {
                    this.realQuestionList.add(v1QuestionInfo);
                }
            }
        } catch (java.lang.Exception e) {
            com.up366.common.FileUtilsUp.deleteDirOrFile(com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.book.getBookId(), this.chapter.obj.getId()));
            com.up366.common.log.Logger.error("paperList format error : " + e.getMessage(), e);
        }
    }

    public int getTimeInMillSeconds(java.lang.String str) {
        int length = str.length();
        return (((java.lang.Integer.valueOf(str.substring(0, length - 7)).intValue() * 60) + java.lang.Integer.valueOf(str.substring(length - 6, length - 4)).intValue()) * 1000) + java.lang.Integer.valueOf(str.substring(length - 3)).intValue();
    }

    public java.util.List<com.up366.mobile.book.model.CatalogChapter> getChapters() {
        return this.context.bookChapterInfo.getChapters();
    }

    public com.up366.mobile.book.model.BookInfoStudy getBook() {
        return this.book;
    }

    public com.up366.mobile.book.model.CatalogChapter getChapter() {
        return this.chapter;
    }

    public java.lang.String getBookPath() {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.book.getBookId());
    }

    public java.lang.String getChapterPath() {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.book.getBookId(), this.chapter.obj.getId());
    }

    public android.view.View.OnClickListener getNextUnitListener() {
        return new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.helper.V1ChapterDataHelper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$getNextUnitListener$2(view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getNextUnitListener$2(android.view.View view) {
        com.up366.mobile.book.model.CatalogChapter catalogChapter;
        java.util.List<com.up366.mobile.book.model.CatalogChapter> chapters = getChapters();
        com.up366.mobile.book.model.CatalogChapter chapter = getChapter();
        int i = 0;
        while (true) {
            if (i >= chapters.size()) {
                catalogChapter = null;
                break;
            } else {
                if (chapters.get(i) == chapter && i < chapters.size() - 1) {
                    catalogChapter = chapters.get(i + 1);
                    break;
                }
                i++;
            }
        }
        if (catalogChapter != null) {
            this.context.cfg.title = catalogChapter.obj.getName();
            this.context.cfg.chapterId = catalogChapter.obj.getId();
            this.context.cfg.pageNo = catalogChapter.getPageNo();
            com.up366.mobile.book.StudyActivity studyActivity = this.context;
            studyActivity.openPage(studyActivity.cfg);
            this.context.finish();
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this.context, "没有下一单元了");
    }
}
