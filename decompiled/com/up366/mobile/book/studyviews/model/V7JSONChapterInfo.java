package com.up366.mobile.book.studyviews.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V7JSONChapterInfo {
    public java.lang.String getJSONChapterInfo(java.lang.String str, com.up366.mobile.book.model.CatalogChapter catalogChapter, boolean z) {
        if (catalogChapter == null) {
            com.up366.common.log.Logger.info("TAG - V7JSONChapterInfo - getJSONChapterInfo - chapter not found : " + str);
            return "";
        }
        com.up366.mobile.book.model.ChapterInfo chapterInfo = catalogChapter.obj;
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("displayName", chapterInfo.getName());
        jSONObject.put("order", java.lang.Integer.valueOf(chapterInfo.getDisplayOrder()));
        jSONObject.put("isContent", java.lang.Boolean.valueOf(chapterInfo.isContent()));
        jSONObject.put("isFree", java.lang.Integer.valueOf(chapterInfo.getIsFree()));
        jSONObject.put("parentId", chapterInfo.getParentId());
        jSONObject.put("lockState", java.lang.Integer.valueOf(catalogChapter.isInLockChapter() ? 1 : 0));
        jSONObject.put("chapterState", java.lang.Integer.valueOf(z ? 2 : 1));
        jSONObject.put("chapterPoster", chapterInfo.getPictureUrl());
        jSONObject.put("xotPaperId", chapterInfo.getXotPaperId());
        jSONObject.put("chapterId", str);
        jSONObject.put("extendParams", com.alibaba.fastjson.JSON.parseObject(chapterInfo.getExtendParams()));
        jSONObject.put("isShelf", java.lang.Integer.valueOf(chapterInfo.getIsShelf()));
        if (!com.up366.common.StringUtils.isEmptyOrNull(chapterInfo.getGrayConfig())) {
            jSONObject.put("grayConfig", com.alibaba.fastjson.JSON.parseObject(chapterInfo.getGrayConfig()));
        }
        return jSONObject.toJSONString();
    }

    public java.lang.String getJSONTaskInfo(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, java.lang.String str, com.up366.mobile.book.model.CatalogPage catalogPage, com.up366.mobile.book.model.CourseBookPlan courseBookPlan, com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo, com.up366.mobile.book.model.OpenConfigInfo openConfigInfo) {
        long beginTime;
        long endTime;
        int publishType;
        int isPublished;
        int i;
        float score;
        long studyDate;
        float percent;
        boolean z;
        com.up366.mobile.course.task.TaskInfoV2 taskInfoV2TryLoadOneTaskInfo;
        boolean z2;
        if (catalogPage == null) {
            com.up366.common.log.Logger.info("TAG - 2019/5/16 - V7JSONChapterInfo - getJSONTaskInfo - taskId not found : " + str);
            return "";
        }
        com.up366.mobile.book.model.ChapterInfo chapterInfo = catalogPage.obj;
        com.up366.mobile.book.model.CatalogPage chapterPPage = catalogPage.getChapterPPage();
        if (chapterPPage == null) {
            chapterPPage = catalogPage;
        }
        com.up366.mobile.book.model.CatalogPage chapterPPage2 = chapterPPage.getChapterPPage();
        if (chapterPPage2 == null) {
            chapterPPage2 = chapterPPage;
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        if (courseBookPlan != null) {
            beginTime = courseBookPlan.getBeginTime();
            endTime = courseBookPlan.getEndTime();
            publishType = courseBookPlan.getPublishType();
            isPublished = courseBookPlan.getIsPublished();
            i = 1;
        } else {
            beginTime = 0;
            endTime = 0;
            publishType = 1;
            isPublished = 0;
            i = 0;
        }
        if (bookTaskFinishedInfo != null) {
            score = bookTaskFinishedInfo.getScore();
            percent = bookTaskFinishedInfo.getPercent();
            studyDate = bookTaskFinishedInfo.getStudyDate();
        } else {
            score = 0.0f;
            studyDate = 0;
            percent = 0.0f;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(openConfigInfo.studyTaskId)) {
            z = false;
        } else {
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, openConfigInfo.studyTaskId);
            try {
                taskInfoV2TryLoadOneTaskInfo = com.up366.mobile.common.logic.Auth.cur().taskMgr().tryLoadOneTaskInfo(openConfigInfo.studyTaskId);
            } catch (java.lang.InterruptedException unused) {
                taskInfoV2TryLoadOneTaskInfo = null;
            }
            if (taskInfoV2TryLoadOneTaskInfo != null) {
                beginTime = taskInfoV2TryLoadOneTaskInfo.getBeginTime();
                endTime = taskInfoV2TryLoadOneTaskInfo.getEndTime();
                publishType = taskInfoV2TryLoadOneTaskInfo.getExtParam().getPublishType();
                isPublished = taskInfoV2TryLoadOneTaskInfo.getExtParam().getIsPublished();
                boolean z3 = taskInfoV2TryLoadOneTaskInfo.getReturnState() == 1;
                com.up366.common.log.Logger.info("TAG - V7JSONChapterInfo - getJSONTaskInfo - studyTask : beginTime:" + beginTime + " endTime:" + endTime + " publishType:" + publishType + " isPublished:" + isPublished);
                z2 = z3;
                i = 1;
            } else {
                z2 = false;
            }
            boolean z4 = z2;
            jSONObject.put("fromHistory", java.lang.Boolean.valueOf(openConfigInfo.fromTaskHistory));
            try {
                jSONObject.put("xotParam", com.alibaba.fastjson.JSON.parseObject(openConfigInfo.xotParam));
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("TAG - V7JSONChapterInfo - getJSONTaskInfo - parse xotParam error:", e);
            }
            z = z4;
        }
        jSONObject.put("isPlaned", java.lang.Integer.valueOf(i));
        jSONObject.put("beginTime", java.lang.Long.valueOf(beginTime));
        jSONObject.put("endTime", java.lang.Long.valueOf(endTime));
        jSONObject.put("publishType", java.lang.Integer.valueOf(publishType));
        jSONObject.put("isPublished", java.lang.Integer.valueOf(isPublished));
        jSONObject.put("order", java.lang.Integer.valueOf(chapterInfo.getDisplayOrder()));
        jSONObject.put("parentId", chapterPPage2.obj.getId());
        jSONObject.put("rollback", java.lang.Boolean.valueOf(z));
        jSONObject.put("retest", java.lang.Boolean.valueOf(openConfigInfo.reTest));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, java.lang.Integer.valueOf(java.lang.Math.max(bookInfoStudy.getCourseId(), 0)));
        jSONObject.put("score", java.lang.Float.valueOf(score));
        jSONObject.put("maxScore", java.lang.Float.valueOf(catalogPage.obj.getTotalScore()));
        jSONObject.put("percent", java.lang.Float.valueOf(percent));
        jSONObject.put("studyDate", java.lang.Long.valueOf(studyDate));
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, str);
        jSONObject.put("isShelf", java.lang.Integer.valueOf(chapterPPage2.obj.getIsShelf()));
        return jSONObject.toJSONString();
    }

    public java.lang.String getJSONPageInfo(java.lang.String str, com.up366.mobile.book.model.CatalogPage catalogPage, java.lang.String str2) {
        if (catalogPage == null) {
            com.up366.common.log.Logger.info("TAG - 2019/5/16 - V7JSONChapterInfo - getJSONPageInfo - page not found : " + str);
            return "";
        }
        java.lang.String id = catalogPage.obj.getId();
        java.lang.String name = catalogPage.obj.getName();
        com.up366.mobile.book.model.CatalogPage chapterPPage = catalogPage.getChapterPPage();
        if (chapterPPage != null) {
            id = chapterPPage.obj.getId();
        }
        int displayOrder = catalogPage.obj.getDisplayOrder();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("pageId", str);
        jSONObject.put("chapterId", id);
        jSONObject.put("order", java.lang.Integer.valueOf(displayOrder));
        jSONObject.put("displayName", name);
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, catalogPage.obj.getTaskId());
        jSONObject.put("pagePath", str2);
        return jSONObject.toJSONString();
    }
}
