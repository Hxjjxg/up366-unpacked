package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookFilePathHelper {
    private final com.up366.mobile.book.model.BookInfoStudy book;
    private final com.up366.mobile.book.model.TreeBookChapter bookChapterInfo;

    public BookFilePathHelper(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, com.up366.mobile.book.model.TreeBookChapter treeBookChapter) {
        this.book = bookInfoStudy;
        this.bookChapterInfo = treeBookChapter;
    }

    public java.lang.String getCatalogDir() {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.book.getBookId());
    }

    public java.lang.String getContentDir(java.lang.String str) {
        if (this.bookChapterInfo.isCustomChapterId(str)) {
            int courseId = this.book.getCourseId();
            return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.book.getBookId(), str + "_" + courseId);
        }
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir(), this.book.getBookId(), str);
    }

    public java.lang.String getFileId() {
        return this.book.getFileId();
    }

    public com.up366.common.download.DownloadInfo getDownloadInfo() {
        com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setKey(this.book.getBookId());
        downloadInfo.setFilePath(com.up366.common.FileUtilsUp.join(getCatalogDir(), "/"));
        downloadInfo.setNeedUnzip(true);
        downloadInfo.setName(this.book.getBookName());
        downloadInfo.setDownType(1);
        downloadInfo.setNeedCheck(true);
        downloadInfo.setFileVersion(java.lang.String.valueOf(this.book.getFileId()));
        downloadInfo.setDownloadUrl("?");
        downloadInfo.setFileMD5("?");
        downloadInfo.setFileSize(-1L);
        downloadInfo.setState(1);
        com.up366.mobile.common.utils.FileDownloadRecord.add(downloadInfo.getKey(), new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.BookFilePathHelper$$ExternalSyntheticLambda1
            public final void accept(java.lang.Object obj) {
                this.f$0.lambda$getDownloadInfo$0((com.alibaba.fastjson.JSONObject) obj);
            }
        });
        return downloadInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDownloadInfo$0(com.alibaba.fastjson.JSONObject jSONObject) {
        jSONObject.put("bookid", this.book.getBookId());
    }

    public com.up366.common.download.DownloadInfo getDownloadInfo(final com.up366.mobile.book.model.ChapterInfo chapterInfo) {
        com.up366.common.download.DownloadInfo downloadInfo = new com.up366.common.download.DownloadInfo();
        downloadInfo.setKey(chapterInfo.getId());
        downloadInfo.setFilePath(com.up366.common.FileUtilsUp.join(getContentDir(chapterInfo.getId()), "/"));
        downloadInfo.setNeedUnzip(true);
        downloadInfo.setName(chapterInfo.getName());
        downloadInfo.setDownType(2);
        downloadInfo.setNeedCheck(true);
        downloadInfo.setFileVersion(java.lang.String.valueOf(chapterInfo.getFileId()));
        downloadInfo.setDownloadUrl("?");
        downloadInfo.setFileMD5("?");
        downloadInfo.setFileSize(-1L);
        downloadInfo.setState(1);
        com.up366.mobile.common.utils.FileDownloadRecord.add(downloadInfo.getKey(), new androidx.core.util.Consumer() { // from class: com.up366.mobile.book.helper.BookFilePathHelper$$ExternalSyntheticLambda0
            public final void accept(java.lang.Object obj) {
                this.f$0.lambda$getDownloadInfo$1(chapterInfo, (com.alibaba.fastjson.JSONObject) obj);
            }
        });
        return downloadInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDownloadInfo$1(com.up366.mobile.book.model.ChapterInfo chapterInfo, com.alibaba.fastjson.JSONObject jSONObject) {
        jSONObject.put("bookid", chapterInfo.getBookId());
        com.up366.mobile.book.model.CatalogChapter chapter = this.bookChapterInfo.getChapter(chapterInfo.getId());
        if (chapter != null) {
            java.util.List<com.up366.mobile.book.model.CatalogChapter> list = chapter.tasks;
            if (list.size() > 0) {
                jSONObject.put("taskid", list.get(0).obj.getId());
            }
        }
    }

    private java.lang.String getConfigPath() throws java.lang.Throwable {
        com.alibaba.fastjson.JSONObject object;
        java.lang.String fileContent = com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(getCatalogDir(), "config.json"));
        if (com.up366.common.StringUtils.isEmptyOrNull(fileContent) || (object = com.alibaba.fastjson.JSON.parseObject(fileContent)) == null) {
            return null;
        }
        return com.up366.common.FileUtilsUp.join(getCatalogDir(), object.getString("catalogPath"));
    }

    public java.lang.String getHtmlCatalogPath() throws java.lang.Throwable {
        java.lang.String configPath = getConfigPath();
        return com.up366.common.FileUtilsUp.isFileExists(configPath) ? configPath : com.up366.common.FileUtilsUp.join(getCatalogDir(), "resources/mobile/bookCatalog.html");
    }

    public java.lang.String getV7StudyPagePath() throws java.lang.Throwable {
        com.alibaba.fastjson.JSONObject object;
        java.lang.String fileContent = com.up366.common.FileUtilsUp.getFileContent(com.up366.common.FileUtilsUp.join(getCatalogDir(), "config.json"));
        if (com.up366.common.StringUtils.isEmptyOrNull(fileContent) || (object = com.alibaba.fastjson.JSON.parseObject(fileContent)) == null) {
            return null;
        }
        return com.up366.common.FileUtilsUp.join(getCatalogDir(), object.getString("studyPath"));
    }

    public boolean existsHtmlChapter() {
        return com.up366.common.FileUtilsUp.isFileExists(getHtmlCatalogPath());
    }
}
