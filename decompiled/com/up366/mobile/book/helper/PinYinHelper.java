package com.up366.mobile.book.helper;

/* JADX INFO: compiled from: PinYinHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¨\u0006\u0007"}, d2 = {"Lcom/up366/mobile/book/helper/PinYinHelper;", "", "<init>", "()V", "getPinYinString", "", "chinese", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PinYinHelper {
    public static final com.up366.mobile.book.helper.PinYinHelper INSTANCE = new com.up366.mobile.book.helper.PinYinHelper();

    private PinYinHelper() {
    }

    public final java.lang.String getPinYinString(final java.lang.String chinese) {
        java.lang.String str = chinese;
        if (str != null && str.length() != 0) {
            final java.lang.String str2 = "pinyin_letter_" + chinese;
            java.lang.String str3 = (java.lang.String) com.up366.mobile.common.logic.Auth.cur().cache().get(str2, (java.lang.Class<java.lang.String>) java.lang.String.class, "");
            kotlin.jvm.internal.Intrinsics.checkNotNull(str3);
            if (str3.length() > 0) {
                return str3;
            }
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.PinYinHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.book.helper.PinYinHelper.getPinYinString$lambda$0(chinese, str2);
                }
            });
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPinYinString$lambda$0(java.lang.String str, java.lang.String str2) {
        com.pinyinsearch.model.PinyinSearchUnit pinyinSearchUnit = new com.pinyinsearch.model.PinyinSearchUnit(str);
        com.pinyinsearch.util.PinyinUtil.parse(pinyinSearchUnit);
        java.lang.String sortKey = com.pinyinsearch.util.PinyinUtil.getSortKey(pinyinSearchUnit);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sortKey, "getSortKey(...)");
        java.util.Locale locale = java.util.Locale.getDefault();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        java.lang.String lowerCase = sortKey.toLowerCase(locale);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        com.up366.mobile.common.logic.Auth.cur().cache().put(str2, new kotlin.text.Regex("[^0-9a-z]*").replace(lowerCase, ""), 2592000L);
    }
}
