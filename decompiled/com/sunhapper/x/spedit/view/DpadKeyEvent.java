package com.sunhapper.x.spedit.view;

/* JADX INFO: compiled from: DpadKeyEvent.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/sunhapper/x/spedit/view/DpadKeyEvent;", "Lcom/sunhapper/x/spedit/view/KeyEventProxy;", "()V", "onKeyEvent", "", "keyEvent", "Landroid/view/KeyEvent;", "text", "Landroid/text/Editable;", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
public final class DpadKeyEvent implements com.sunhapper.x.spedit.view.KeyEventProxy {
    @Override // com.sunhapper.x.spedit.view.KeyEventProxy
    public boolean onKeyEvent(android.view.KeyEvent keyEvent, android.text.Editable text) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(keyEvent, "keyEvent");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        if (keyEvent.getKeyCode() == 21 && keyEvent.getAction() == 0) {
            android.text.Editable editable = text;
            int selectionStart = android.text.Selection.getSelectionStart(editable);
            int selectionEnd = android.text.Selection.getSelectionEnd(editable);
            com.sunhapper.x.spedit.mention.span.IntegratedSpan[] integratedSpanArr = (com.sunhapper.x.spedit.mention.span.IntegratedSpan[]) text.getSpans(selectionEnd, selectionEnd, com.sunhapper.x.spedit.mention.span.IntegratedSpan.class);
            if (integratedSpanArr != null) {
                if (!(integratedSpanArr.length == 0)) {
                    for (com.sunhapper.x.spedit.mention.span.IntegratedSpan integratedSpan : integratedSpanArr) {
                        int spanStart = text.getSpanStart(integratedSpan);
                        if (text.getSpanEnd(integratedSpan) == selectionEnd) {
                            android.text.Selection.setSelection(text, selectionStart, spanStart);
                            return true;
                        }
                    }
                }
            }
        }
        if (keyEvent.getKeyCode() == 22 && keyEvent.getAction() == 0) {
            android.text.Editable editable2 = text;
            int selectionStart2 = android.text.Selection.getSelectionStart(editable2);
            int selectionEnd2 = android.text.Selection.getSelectionEnd(editable2);
            com.sunhapper.x.spedit.mention.span.IntegratedSpan[] integratedSpanArr2 = (com.sunhapper.x.spedit.mention.span.IntegratedSpan[]) text.getSpans(selectionEnd2, selectionEnd2, com.sunhapper.x.spedit.mention.span.IntegratedSpan.class);
            if (integratedSpanArr2 != null) {
                if (!(integratedSpanArr2.length == 0)) {
                    for (com.sunhapper.x.spedit.mention.span.IntegratedSpan integratedSpan2 : integratedSpanArr2) {
                        int spanStart2 = text.getSpanStart(integratedSpan2);
                        int spanEnd = text.getSpanEnd(integratedSpan2);
                        if (spanStart2 == selectionEnd2) {
                            android.text.Selection.setSelection(text, selectionStart2, spanEnd);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
