package com.sunhapper.x.spedit.view;

/* JADX INFO: compiled from: SpXSpannableFactory.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/sunhapper/x/spedit/view/SpXSpannableFactory;", "Landroid/text/Spannable$Factory;", "mNoCopySpans", "", "Landroid/text/NoCopySpan;", "(Ljava/util/List;)V", "newSpannable", "Landroid/text/Spannable;", "source", "", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
public final class SpXSpannableFactory extends android.text.Spannable.Factory {
    private final java.util.List<android.text.NoCopySpan> mNoCopySpans;

    /* JADX WARN: Multi-variable type inference failed */
    public SpXSpannableFactory(java.util.List<? extends android.text.NoCopySpan> list) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(list, "mNoCopySpans");
        this.mNoCopySpans = list;
    }

    @Override // android.text.Spannable.Factory
    public android.text.Spannable newSpannable(java.lang.CharSequence source) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(source, "source");
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        java.util.Iterator<T> it = this.mNoCopySpans.iterator();
        while (it.hasNext()) {
            spannableStringBuilder.setSpan((android.text.NoCopySpan) it.next(), 0, 0, 16711698);
        }
        spannableStringBuilder.append(source);
        return spannableStringBuilder;
    }
}
