package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V6PageInfoHelper {
    private final com.up366.mobile.book.StudyActivity context;
    protected final com.up366.mobile.book.model.CatalogPage page;

    public V6PageInfoHelper(com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.model.CatalogPage catalogPage) {
        this.context = studyActivity;
        this.page = catalogPage;
    }

    public java.lang.String getPageIds() {
        com.up366.mobile.book.model.CatalogPage chapterPPage = this.page.getChapterPPage();
        if (!(chapterPPage instanceof com.up366.mobile.book.model.CatalogChapter)) {
            return this.page.obj.getId();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (com.up366.mobile.book.model.CatalogChapter catalogChapter : ((com.up366.mobile.book.model.CatalogChapter) chapterPPage).pages) {
            if (catalogChapter.obj.isPage()) {
                sb.append(catalogChapter.obj.getId());
                sb.append(com.igexin.push.core.b.an);
            }
        }
        return sb.toString();
    }

    public java.lang.String loadPageInfo() {
        java.lang.String id = this.page.obj.getId();
        if (this.page.getChapterPPage() != null) {
            id = this.page.getChapterPPage().obj.getId();
        }
        java.lang.String id2 = this.page.obj.getId();
        java.lang.String name = this.page.obj.getName();
        int displayOrder = this.page.obj.getDisplayOrder();
        java.lang.String str = this.page.obj.getDisplayOrder() + ".html";
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        for (com.up366.mobile.book.model.CatalogPage catalogPage = this.page.getpPage(); catalogPage != null; catalogPage = catalogPage.getpPage()) {
            if (catalogPage.getObj() != null) {
                jSONArray.add(0, catalogPage.getObj().getName());
            }
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("chapterId", id);
        jSONObject.put("pageId", id2);
        jSONObject.put("pageNum", java.lang.Integer.valueOf(displayOrder));
        jSONObject.put("displayName", name);
        jSONObject.put("file", str);
        jSONObject.put("fullChapterName", jSONArray);
        java.lang.String jSONString = jSONObject.toJSONString();
        com.up366.common.log.Logger.debug("LLLLL - getCurrentPageInfo - result:" + jSONString);
        return jSONString;
    }

    public java.lang.String loadChapterInfo() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String strJSONStr = new com.up366.mobile.book.studyviews.model.V6JSONChapterInfo((com.up366.mobile.book.model.CatalogChapter) this.page.getChapterPPage()).JSONStr();
        com.up366.common.log.Logger.debug("loadChapterInfo - time :" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        return strJSONStr;
    }

    public java.lang.String loadTaskInfo() {
        long beginTime;
        int isPublished;
        int i;
        int publishType;
        long endTime;
        com.up366.mobile.course.task.TaskInfoV2 taskInfoV2TryLoadOneTaskInfo;
        java.lang.String id = this.page.obj.getId();
        int isShelf = this.page.obj.getIsShelf();
        if (this.page.getChapterPPage() != null) {
            id = this.page.getChapterPPage().obj.getId();
            isShelf = this.page.getChapterPPage().obj.getIsShelf();
        }
        java.lang.String name = this.page.obj.getName();
        int displayOrder = this.page.obj.getDisplayOrder();
        java.lang.String taskId = this.page.obj.getTaskId();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("chapterId", id);
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID, taskId);
        jSONObject.put("order", java.lang.Integer.valueOf(displayOrder));
        jSONObject.put("taskName", name);
        jSONObject.put("pages", getPageIdsByTaskId(taskId));
        jSONObject.put("isShelf", java.lang.Integer.valueOf(isShelf));
        jSONObject.put("lockState", java.lang.Boolean.valueOf(this.page.isInLockChapter()));
        com.up366.mobile.book.model.CourseBookPlan courseBookPlan = this.context.bookChapterInfo.getPlanMap().get(taskId);
        int i2 = 1;
        if (courseBookPlan != null) {
            beginTime = courseBookPlan.getBeginTime();
            endTime = courseBookPlan.getEndTime();
            publishType = courseBookPlan.getPublishType();
            isPublished = courseBookPlan.getIsPublished();
            i = 1;
        } else {
            beginTime = 0;
            isPublished = 0;
            i = 0;
            publishType = 1;
            endTime = 0;
        }
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = this.context.cfg;
        if (!android.text.TextUtils.isEmpty(openConfigInfo.studyTaskId)) {
            jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, openConfigInfo.studyTaskId);
            try {
                taskInfoV2TryLoadOneTaskInfo = com.up366.mobile.common.logic.Auth.cur().taskMgr().tryLoadOneTaskInfo(openConfigInfo.studyTaskId);
            } catch (java.lang.InterruptedException unused) {
                taskInfoV2TryLoadOneTaskInfo = null;
            }
            if (taskInfoV2TryLoadOneTaskInfo != null) {
                beginTime = taskInfoV2TryLoadOneTaskInfo.getBeginTime();
                endTime = taskInfoV2TryLoadOneTaskInfo.getEndTime();
                int publishType2 = taskInfoV2TryLoadOneTaskInfo.getExtParam().getPublishType();
                int isPublished2 = taskInfoV2TryLoadOneTaskInfo.getExtParam().getIsPublished();
                z = taskInfoV2TryLoadOneTaskInfo.getReturnState() == 1;
                com.up366.common.log.Logger.info("TAG - V6PageInfoHelper - loadTaskInfo - studyTask : beginTime:" + beginTime + " endTime:" + endTime + " publishType:" + publishType2 + " isPublished:" + isPublished2);
                publishType = publishType2;
                isPublished = isPublished2;
            } else {
                i2 = i;
            }
            jSONObject.put("xotParam", com.alibaba.fastjson.JSON.parseObject(openConfigInfo.xotParam));
            i = i2;
        }
        jSONObject.put("isPlaned", java.lang.Integer.valueOf(i));
        jSONObject.put("beginTime", java.lang.Long.valueOf(beginTime));
        jSONObject.put("endTime", java.lang.Long.valueOf(endTime));
        jSONObject.put("publishType", java.lang.Integer.valueOf(publishType));
        jSONObject.put("isPublished", java.lang.Integer.valueOf(isPublished));
        jSONObject.put("rollback", java.lang.Boolean.valueOf(z));
        jSONObject.put("retest", java.lang.Integer.valueOf(openConfigInfo.reTest ? 1 : 0));
        return jSONObject.toJSONString();
    }

    private java.lang.String getPageIdsByTaskId(java.lang.String str) {
        java.util.List<com.up366.mobile.book.model.CatalogPage> pages = this.context.bookChapterInfo.getPages();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (com.up366.mobile.book.model.CatalogPage catalogPage : pages) {
            if (str.equals(catalogPage.obj.getTaskId())) {
                sb.append(catalogPage.obj.getId());
                sb.append("\",\"");
            }
        }
        return "\"" + sb.substring(0, sb.length() - 2);
    }

    public java.lang.String loadBookInfo() {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        com.up366.mobile.book.model.BookInfoStudy book = this.context.bookChapterInfo.getBook();
        jSONObject.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID, book.getBookId());
        jSONObject.put("bookName", book.getBookName());
        jSONObject.put("isFree", java.lang.Integer.valueOf(book.isHasBuy() ? 1 : 0));
        jSONObject.put("studyPro", java.lang.Integer.valueOf(book.getPercent()));
        jSONObject.put("authDate", java.lang.Integer.valueOf(book.getValidDays()));
        jSONObject.put("price", java.lang.Float.valueOf(book.getPrice()));
        jSONObject.put("productId", java.lang.Integer.valueOf(book.getProductId()));
        jSONObject.put("isShelf", java.lang.Integer.valueOf(book.getIsShelf()));
        return jSONObject.toJSONString();
    }
}
