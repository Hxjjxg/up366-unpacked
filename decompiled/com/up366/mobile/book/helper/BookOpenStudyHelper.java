package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookOpenStudyHelper {
    private final com.up366.mobile.book.model.TreeBookChapter bookChapterInfo;
    private final com.up366.mobile.book.StudyActivity context;
    public com.up366.mobile.book.model.ChapterInfo curOpen;

    public BookOpenStudyHelper(com.up366.mobile.book.StudyActivity studyActivity) {
        this.context = studyActivity;
        this.bookChapterInfo = studyActivity.bookChapterInfo;
    }

    public void study(java.lang.String str, java.lang.String str2, int i) {
        com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo = com.up366.mobile.common.logic.Auth.cur().bookProgress().get(this.bookChapterInfo.getBook().getBookId());
        int[] pageRange = this.bookChapterInfo.getPageRange(null);
        if (i == 0) {
            pageRange = this.bookChapterInfo.getPageRange(null);
        } else if (i == 1) {
            pageRange = this.bookChapterInfo.getPageRange(str);
        } else if (i == 2) {
            str2 = bookScheduleInfo.getPageId();
            str = bookScheduleInfo.getChapterId();
            pageRange = this.bookChapterInfo.getPageRange(str);
        } else if (i == 3) {
            str2 = bookScheduleInfo.getPageId();
            str = bookScheduleInfo.getChapterId();
            pageRange = this.bookChapterInfo.getPageRange(null);
        }
        com.up366.mobile.book.model.CatalogChapter chapter = this.bookChapterInfo.getChapter(str);
        com.up366.mobile.book.model.CatalogPage page = this.bookChapterInfo.getPage(str2);
        if (chapter == null && page == null) {
            if (str2 != null) {
                str = str2;
            }
            if (str != null) {
                com.up366.mobile.book.helper.Tools.alarmLogTrackContext.taskId = str;
                com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004002001));
            }
            com.up366.mobile.common.dialog.DialogOk.showDialog(this.context.getResources().getString(com.up366.mobile.R.string.study_page_not_found) + "(-3)");
            java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - BookOpenStudyHelper - study - 找不到要打开的页面:");
            sb.append(str2);
            com.up366.common.log.Logger.error(sb.toString());
            return;
        }
        if (chapter == null) {
            chapter = (com.up366.mobile.book.model.CatalogChapter) page.getChapterPPage();
            str = chapter.obj.getId();
        }
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo();
        openConfigInfo.title = chapter.obj.getName();
        openConfigInfo.chapterId = str;
        openConfigInfo.pageId = str2;
        openConfigInfo.range = pageRange;
        int pageNo = chapter.getPageNo();
        if (page != null) {
            pageNo = page.getPageNo();
        }
        openConfigInfo.pageNo = pageNo;
        this.context.openPage(openConfigInfo);
    }
}
