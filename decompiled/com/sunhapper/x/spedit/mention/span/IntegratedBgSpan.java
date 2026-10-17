package com.sunhapper.x.spedit.mention.span;

/* JADX INFO: compiled from: IntegratedBgSpan.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\f\u0010\u0012\u001a\u00020\u0003*\u00020\u0000H\u0016R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/sunhapper/x/spedit/mention/span/IntegratedBgSpan;", "Lcom/sunhapper/x/spedit/mention/span/IntegratedSpan;", "bgSpan", "Landroid/text/style/BackgroundColorSpan;", "getBgSpan", "()Landroid/text/style/BackgroundColorSpan;", "setBgSpan", "(Landroid/text/style/BackgroundColorSpan;)V", "isShow", "", "()Z", "setShow", "(Z)V", "generateBgSpan", "removeBg", "", "text", "Landroid/text/Spannable;", "createStoredBgSpan", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
public interface IntegratedBgSpan extends com.sunhapper.x.spedit.mention.span.IntegratedSpan {
    android.text.style.BackgroundColorSpan createStoredBgSpan(com.sunhapper.x.spedit.mention.span.IntegratedBgSpan integratedBgSpan);

    android.text.style.BackgroundColorSpan generateBgSpan();

    android.text.style.BackgroundColorSpan getBgSpan();

    boolean isShow();

    void removeBg(android.text.Spannable text);

    void setBgSpan(android.text.style.BackgroundColorSpan backgroundColorSpan);

    void setShow(boolean z);

    /* JADX INFO: compiled from: IntegratedBgSpan.kt */
    @kotlin.Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public static final class DefaultImpls {
        public static void removeBg(com.sunhapper.x.spedit.mention.span.IntegratedBgSpan integratedBgSpan, android.text.Spannable spannable) {
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(spannable, "text");
            integratedBgSpan.setShow(false);
            android.text.style.BackgroundColorSpan bgSpan = integratedBgSpan.getBgSpan();
            if (bgSpan != null) {
                spannable.removeSpan(bgSpan);
            }
        }

        public static android.text.style.BackgroundColorSpan createStoredBgSpan(com.sunhapper.x.spedit.mention.span.IntegratedBgSpan integratedBgSpan, com.sunhapper.x.spedit.mention.span.IntegratedBgSpan integratedBgSpan2) {
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(integratedBgSpan2, "$this$createStoredBgSpan");
            integratedBgSpan2.setBgSpan(integratedBgSpan2.generateBgSpan());
            android.text.style.BackgroundColorSpan bgSpan = integratedBgSpan2.getBgSpan();
            if (bgSpan == null) {
                kotlin.jvm.internal.Intrinsics.throwNpe();
            }
            return bgSpan;
        }

        public static android.text.style.BackgroundColorSpan generateBgSpan(com.sunhapper.x.spedit.mention.span.IntegratedBgSpan integratedBgSpan) {
            return new android.text.style.BackgroundColorSpan(-256);
        }
    }
}
