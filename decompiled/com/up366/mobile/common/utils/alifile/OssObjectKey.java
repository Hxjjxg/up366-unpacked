package com.up366.mobile.common.utils.alifile;

/* JADX INFO: compiled from: OssObjectKey.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0007J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u0007J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005¨\u0006\u0018"}, d2 = {"Lcom/up366/mobile/common/utils/alifile/OssObjectKey;", "", "<init>", "()V", "getObjectKey", "", "filePath", "ext", "getObjectKeyUnique", "isUnique", "", "business", "getResource", "getFileExtension", "isVideoFile", "isAudioFile", "isPdfFile", "isImageFile", "isArchiveFile", "isOfficeFile", "isConfigFile", "getExtensionName", "filename", "Business", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OssObjectKey {
    public static final com.up366.mobile.common.utils.alifile.OssObjectKey INSTANCE = new com.up366.mobile.common.utils.alifile.OssObjectKey();

    private OssObjectKey() {
    }

    /* JADX INFO: compiled from: OssObjectKey.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/up366/mobile/common/utils/alifile/OssObjectKey$Business;", "", "<init>", "()V", "STUDY", "", "FEEDBACK", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Business {
        public static final java.lang.String FEEDBACK = "feedback";
        public static final com.up366.mobile.common.utils.alifile.OssObjectKey.Business INSTANCE = new com.up366.mobile.common.utils.alifile.OssObjectKey.Business();
        public static final java.lang.String STUDY = "study";

        private Business() {
        }
    }

    public final java.lang.String getObjectKey(java.lang.String filePath, java.lang.String ext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(filePath, "filePath");
        return getObjectKey(filePath, ext, false, com.up366.mobile.common.utils.alifile.OssObjectKey.Business.STUDY);
    }

    public final java.lang.String getObjectKeyUnique(java.lang.String filePath, java.lang.String ext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(filePath, "filePath");
        return getObjectKey(filePath, ext, true, com.up366.mobile.common.utils.alifile.OssObjectKey.Business.STUDY);
    }

    public static /* synthetic */ java.lang.String getObjectKey$default(com.up366.mobile.common.utils.alifile.OssObjectKey ossObjectKey, java.lang.String str, java.lang.String str2, boolean z, java.lang.String str3, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            str3 = com.up366.mobile.common.utils.alifile.OssObjectKey.Business.STUDY;
        }
        return ossObjectKey.getObjectKey(str, str2, z, str3);
    }

    public final java.lang.String getObjectKey(java.lang.String filePath, java.lang.String ext, boolean isUnique, java.lang.String business) {
        java.lang.String strMd5;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(filePath, "filePath");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(business, "business");
        java.io.File file = new java.io.File(filePath);
        java.lang.String time = com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy/MM/dd/");
        if (isUnique) {
            strMd5 = com.up366.common.digest.MD5.md5(com.up366.common.digest.MD5.md5(file) + com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
        } else {
            strMd5 = com.up366.common.digest.MD5.md5(file);
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(strMd5);
        java.lang.String strSubstring = strMd5.substring(0, 5);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        java.lang.String str = strSubstring + "u" + com.up366.mobile.common.logic.Auth.UID() + "t" + strMd5 + com.igexin.push.core.d.d.g + file.length() + (com.up366.common.StringUtils.isEmptyOrNull(ext) ? getExtensionName(filePath) : ext);
        return "storage/" + com.up366.mobile.common.logic.Auth.userType() + "/" + business + "/" + getResource(filePath, ext) + "/" + time + com.up366.mobile.common.logic.Auth.UID() + "/" + str;
    }

    private final java.lang.String getResource(java.lang.String filePath, java.lang.String ext) {
        java.lang.String fileExtension = getFileExtension(filePath, ext);
        if (com.up366.common.StringUtils.isEmptyOrNull(fileExtension)) {
            return "other";
        }
        return isVideoFile(fileExtension) ? "v" : isAudioFile(fileExtension) ? "a" : isPdfFile(fileExtension) ? com.igexin.push.core.d.d.f : isImageFile(fileExtension) ? com.igexin.push.core.d.d.e : isArchiveFile(fileExtension) ? "z" : isOfficeFile(fileExtension) ? "o" : isConfigFile(fileExtension) ? "conf" : fileExtension;
    }

    private final java.lang.String getFileExtension(java.lang.String filePath, java.lang.String ext) {
        if (!com.up366.common.StringUtils.isEmptyOrNull(ext)) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(ext);
            java.lang.String lowerCase = kotlin.text.StringsKt.removePrefix(ext, ".").toLowerCase(java.util.Locale.ROOT);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return kotlin.text.StringsKt.trim(lowerCase).toString();
        }
        if (!kotlin.text.StringsKt.contains$default(filePath, ".", false, 2, (java.lang.Object) null)) {
            return "";
        }
        java.lang.String lowerCase2 = kotlin.text.StringsKt.substringAfterLast$default(filePath, '.', (java.lang.String) null, 2, (java.lang.Object) null).toLowerCase(java.util.Locale.ROOT);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return kotlin.text.StringsKt.trim(lowerCase2).toString();
    }

    private final boolean isVideoFile(java.lang.String ext) {
        return kotlin.collections.SetsKt.setOf(new java.lang.String[]{"mp4", "avi", "mov", "wmv", "flv", "mkv", "webm", "m4v", "3gp"}).contains(ext);
    }

    private final boolean isAudioFile(java.lang.String ext) {
        return kotlin.collections.SetsKt.setOf(new java.lang.String[]{"mp3", "wav", "aac", "flac", "ogg", "wma", "m4a", "opus", "amr"}).contains(ext);
    }

    private final boolean isPdfFile(java.lang.String ext) {
        return kotlin.jvm.internal.Intrinsics.areEqual(ext, "pdf");
    }

    private final boolean isImageFile(java.lang.String ext) {
        return kotlin.collections.SetsKt.setOf(new java.lang.String[]{"jpg", "jpeg", "png", "gif", "bmp", "webp", "svg", "ico", "tiff", "tif"}).contains(ext);
    }

    private final boolean isArchiveFile(java.lang.String ext) {
        return kotlin.collections.SetsKt.setOf(new java.lang.String[]{"zip", "rar", "7z", "tar", "gz", "bz2", "xz", "z", "tgz", "tbz2"}).contains(ext);
    }

    private final boolean isOfficeFile(java.lang.String ext) {
        return kotlin.collections.SetsKt.setOf(new java.lang.String[]{"doc", "docx", "xls", "xlsx", "ppt", "pptx", "odt", "ods", "odp", "rtf"}).contains(ext);
    }

    private final boolean isConfigFile(java.lang.String ext) {
        return kotlin.collections.SetsKt.setOf(new java.lang.String[]{"conf", "config", "ini", "cfg", "properties", "yml", "yaml", com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_JSON, "xml", "toml"}).contains(ext);
    }

    public final java.lang.String getExtensionName(java.lang.String filename) {
        java.util.List listEmptyList;
        java.util.List listEmptyList2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(filename, "filename");
        if (com.up366.common.StringUtils.isEmptyOrNull(filename)) {
            return "";
        }
        java.util.List listSplit = new kotlin.text.Regex("/").split(filename, 0);
        if (!listSplit.isEmpty()) {
            java.util.ListIterator listIterator = listSplit.listIterator(listSplit.size());
            while (listIterator.hasPrevious()) {
                if (((java.lang.String) listIterator.previous()).length() != 0) {
                    listEmptyList = kotlin.collections.CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        } else {
            listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        }
        java.lang.String[] strArr = (java.lang.String[]) listEmptyList.toArray(new java.lang.String[0]);
        java.util.List listSplit2 = new kotlin.text.Regex("\\.").split(strArr[strArr.length - 1], 0);
        if (!listSplit2.isEmpty()) {
            java.util.ListIterator listIterator2 = listSplit2.listIterator(listSplit2.size());
            while (listIterator2.hasPrevious()) {
                if (((java.lang.String) listIterator2.previous()).length() != 0) {
                    listEmptyList2 = kotlin.collections.CollectionsKt.take(listSplit2, listIterator2.nextIndex() + 1);
                    break;
                }
            }
            listEmptyList2 = kotlin.collections.CollectionsKt.emptyList();
        } else {
            listEmptyList2 = kotlin.collections.CollectionsKt.emptyList();
        }
        java.lang.String[] strArr2 = (java.lang.String[]) listEmptyList2.toArray(new java.lang.String[0]);
        if (strArr2.length == 1) {
            return "";
        }
        return "." + strArr2[strArr2.length - 1];
    }
}
