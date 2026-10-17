package com.sunhapper.x.spedit.mention.watcher;

/* JADX INFO: compiled from: SpanChangedWatcher.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J:\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016J(\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u0012"}, d2 = {"Lcom/sunhapper/x/spedit/mention/watcher/SpanChangedWatcher;", "Landroid/text/SpanWatcher;", "()V", "onSpanAdded", "", "text", "Landroid/text/Spannable;", "what", "", "start", "", "end", "onSpanChanged", "ostart", "oend", "nstart", "nend", "onSpanRemoved", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
public final class SpanChangedWatcher implements android.text.SpanWatcher {
    @Override // android.text.SpanWatcher
    public void onSpanAdded(android.text.Spannable text, java.lang.Object what, int start, int end) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(what, "what");
    }

    @Override // android.text.SpanWatcher
    public void onSpanRemoved(android.text.Spannable text, java.lang.Object what, int start, int end) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(what, "what");
    }

    @Override // android.text.SpanWatcher
    public void onSpanChanged(android.text.Spannable text, java.lang.Object what, int ostart, int oend, int nstart, int nend) {
        com.sunhapper.x.spedit.mention.span.IntegratedSpan[] integratedSpanArr;
        com.sunhapper.x.spedit.mention.span.IntegratedSpan[] integratedSpanArr2;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        if (what == android.text.Selection.SELECTION_END && oend != nstart && (integratedSpanArr2 = (com.sunhapper.x.spedit.mention.span.IntegratedSpan[]) text.getSpans(nstart, nend, com.sunhapper.x.spedit.mention.span.IntegratedSpan.class)) != null) {
            if (!(integratedSpanArr2.length == 0)) {
                com.sunhapper.x.spedit.mention.span.IntegratedSpan integratedSpan = integratedSpanArr2[0];
                int spanStart = text.getSpanStart(integratedSpan);
                int spanEnd = text.getSpanEnd(integratedSpan);
                if (java.lang.Math.abs(nstart - spanEnd) <= java.lang.Math.abs(nstart - spanStart)) {
                    spanStart = spanEnd;
                }
                android.text.Selection.setSelection(text, android.text.Selection.getSelectionStart(text), spanStart);
            }
        }
        if (what == android.text.Selection.SELECTION_START && oend != nstart && (integratedSpanArr = (com.sunhapper.x.spedit.mention.span.IntegratedSpan[]) text.getSpans(nstart, nend, com.sunhapper.x.spedit.mention.span.IntegratedSpan.class)) != null) {
            if (true ^ (integratedSpanArr.length == 0)) {
                com.sunhapper.x.spedit.mention.span.IntegratedSpan integratedSpan2 = integratedSpanArr[0];
                int spanStart2 = text.getSpanStart(integratedSpan2);
                int spanEnd2 = text.getSpanEnd(integratedSpan2);
                if (java.lang.Math.abs(nstart - spanEnd2) <= java.lang.Math.abs(nstart - spanStart2)) {
                    spanStart2 = spanEnd2;
                }
                android.text.Selection.setSelection(text, spanStart2, android.text.Selection.getSelectionEnd(text));
            }
        }
        if ((what instanceof com.sunhapper.x.spedit.mention.span.BreakableSpan) && ((com.sunhapper.x.spedit.mention.span.BreakableSpan) what).isBreak(text)) {
            text.removeSpan(what);
        }
        if (what == android.text.Selection.SELECTION_START && oend != nstart && nstart == nend) {
            for (com.sunhapper.x.spedit.mention.span.IntegratedBgSpan integratedBgSpan : (com.sunhapper.x.spedit.mention.span.IntegratedBgSpan[]) text.getSpans(0, text.length(), com.sunhapper.x.spedit.mention.span.IntegratedBgSpan.class)) {
                integratedBgSpan.removeBg(text);
            }
        }
    }
}
