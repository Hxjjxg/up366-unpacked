package com.sunhapper.x.spedit.view;

/* JADX INFO: compiled from: SpXEditableFactory.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/sunhapper/x/spedit/view/SpXEditableFactory;", "Landroid/text/Editable$Factory;", "mNoCopySpans", "", "Landroid/text/NoCopySpan;", "(Ljava/util/List;)V", "newEditable", "Landroid/text/Editable;", "source", "", "Companion", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
public final class SpXEditableFactory extends android.text.Editable.Factory {
    private static java.lang.Class<?> sWatcherClass;
    private final java.util.List<android.text.NoCopySpan> mNoCopySpans;

    /* JADX WARN: Multi-variable type inference failed */
    public SpXEditableFactory(java.util.List<? extends android.text.NoCopySpan> list) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(list, "mNoCopySpans");
        this.mNoCopySpans = list;
        try {
            sWatcherClass = getClass().getClassLoader().loadClass("android.text.DynamicLayout$ChangeWatcher");
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.text.Editable.Factory
    public android.text.Editable newEditable(java.lang.CharSequence source) {
        com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder emojiSpannableStringBuilderValueOf;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(source, "source");
        if (sWatcherClass != null) {
            com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.Companion companion = com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.INSTANCE;
            java.lang.Class<?> cls = sWatcherClass;
            if (cls == null) {
                kotlin.jvm.internal.Intrinsics.throwNpe();
            }
            emojiSpannableStringBuilderValueOf = companion.create$SpEditText_release(cls, source);
        } else {
            emojiSpannableStringBuilderValueOf = android.text.SpannableStringBuilder.valueOf(source);
        }
        java.util.Iterator<android.text.NoCopySpan> it = this.mNoCopySpans.iterator();
        while (it.hasNext()) {
            emojiSpannableStringBuilderValueOf.setSpan(it.next(), 0, source.length(), 16711698);
        }
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(emojiSpannableStringBuilderValueOf, "spannableStringBuilder");
        return emojiSpannableStringBuilderValueOf;
    }
}
