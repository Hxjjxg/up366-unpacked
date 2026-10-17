package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class SortWordListUtils {
    public static void sortList(java.util.List<com.up366.mobile.course.wrongnote.modle.WordNoteInfo> list, java.lang.String str, final boolean z) {
        if (list.size() == 0) {
        }
        str.hashCode();
        switch (str) {
            case "updateTime":
                java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.course.unfamiliarWords.SortWordListUtils$$ExternalSyntheticLambda2
                    @Override // java.util.Comparator
                    public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                        return com.up366.mobile.course.unfamiliarWords.SortWordListUtils.lambda$sortList$2(z, (com.up366.mobile.course.wrongnote.modle.WordNoteInfo) obj, (com.up366.mobile.course.wrongnote.modle.WordNoteInfo) obj2);
                    }
                });
                break;
            case "word":
                java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.course.unfamiliarWords.SortWordListUtils$$ExternalSyntheticLambda0
                    @Override // java.util.Comparator
                    public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                        return com.up366.mobile.course.unfamiliarWords.SortWordListUtils.lambda$sortList$0(z, (com.up366.mobile.course.wrongnote.modle.WordNoteInfo) obj, (com.up366.mobile.course.wrongnote.modle.WordNoteInfo) obj2);
                    }
                });
                break;
            case "wordTimes":
                java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.course.unfamiliarWords.SortWordListUtils$$ExternalSyntheticLambda1
                    @Override // java.util.Comparator
                    public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                        return com.up366.mobile.course.unfamiliarWords.SortWordListUtils.lambda$sortList$1(z, (com.up366.mobile.course.wrongnote.modle.WordNoteInfo) obj, (com.up366.mobile.course.wrongnote.modle.WordNoteInfo) obj2);
                    }
                });
                break;
        }
    }

    static /* synthetic */ int lambda$sortList$0(boolean z, com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo, com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo2) {
        if (!z) {
            return wordNoteInfo.getWordPinYin().compareTo(wordNoteInfo2.getWordPinYin());
        }
        return -wordNoteInfo.getWordPinYin().compareTo(wordNoteInfo2.getWordPinYin());
    }

    static /* synthetic */ int lambda$sortList$1(boolean z, com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo, com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo2) {
        return !z ? wordNoteInfo.getWordTimes() - wordNoteInfo2.getWordTimes() == 0 ? wordNoteInfo.getWordPinYin().compareTo(wordNoteInfo2.getWordPinYin()) : wordNoteInfo.getWordTimes() - wordNoteInfo2.getWordTimes() : wordNoteInfo2.getWordTimes() - wordNoteInfo.getWordTimes() == 0 ? wordNoteInfo.getWordPinYin().compareTo(wordNoteInfo2.getWordPinYin()) : wordNoteInfo2.getWordTimes() - wordNoteInfo.getWordTimes();
    }

    static /* synthetic */ int lambda$sortList$2(boolean z, com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo, com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo2) {
        return !z ? wordNoteInfo.getUpdateTime() == wordNoteInfo2.getUpdateTime() ? wordNoteInfo.getWordPinYin().compareTo(wordNoteInfo2.getWordPinYin()) : java.lang.Long.compare(wordNoteInfo.getUpdateTime(), wordNoteInfo2.getUpdateTime()) : wordNoteInfo2.getUpdateTime() == wordNoteInfo.getUpdateTime() ? wordNoteInfo.getWordPinYin().compareTo(wordNoteInfo2.getWordPinYin()) : java.lang.Long.compare(wordNoteInfo2.getUpdateTime(), wordNoteInfo.getUpdateTime());
    }
}
