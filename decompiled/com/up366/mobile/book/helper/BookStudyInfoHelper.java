package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookStudyInfoHelper {
    private final com.up366.mobile.book.model.BookInfoStudy book;

    public BookStudyInfoHelper(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        this.book = bookInfoStudy;
    }

    public java.lang.String getLatestStudyInfo() {
        com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo = com.up366.mobile.common.logic.Auth.cur().bookProgress().get(this.book.getBookId());
        java.lang.String lastStudyTimeStr = bookScheduleInfo.getLastStudyTimeStr();
        if (com.up366.common.StringUtils.isEmptyOrNull(lastStudyTimeStr) || com.up366.common.StringUtils.isEmptyOrNull(bookScheduleInfo.getPageId())) {
            lastStudyTimeStr = "未开始";
        }
        return java.text.MessageFormat.format("  '{'\n     \"fullPageName\" : \"{0}\", \n     \"chapterId\" : \"{1}\",    \n     \"pageId\" : \"{2}\",      \n     \"bookId\" : \"{3}\" ,      \n     \"studyTime\" : \"{4}\"     \n  '}'                        \n", bookScheduleInfo.getShortSchedule(), bookScheduleInfo.getChapterId(), bookScheduleInfo.getPageId(), bookScheduleInfo.getBookId(), lastStudyTimeStr);
    }
}
