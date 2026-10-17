package com.sunhapper.x.spedit.view;

/* JADX INFO: compiled from: DefaultKeyEventProxy.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/sunhapper/x/spedit/view/DefaultKeyEventProxy;", "Lcom/sunhapper/x/spedit/view/KeyEventProxy;", "()V", "dpadKeyEvent", "Lcom/sunhapper/x/spedit/view/DpadKeyEvent;", "onKeyEvent", "", "keyEvent", "Landroid/view/KeyEvent;", "text", "Landroid/text/Editable;", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
public final class DefaultKeyEventProxy implements com.sunhapper.x.spedit.view.KeyEventProxy {
    private final com.sunhapper.x.spedit.view.DpadKeyEvent dpadKeyEvent = new com.sunhapper.x.spedit.view.DpadKeyEvent();

    @Override // com.sunhapper.x.spedit.view.KeyEventProxy
    public boolean onKeyEvent(android.view.KeyEvent keyEvent, android.text.Editable text) {
        android.text.Editable editable;
        int selectionStart;
        int selectionEnd;
        com.sunhapper.x.spedit.mention.span.IntegratedSpan[] integratedSpanArr;
        com.sunhapper.x.spedit.mention.span.IntegratedSpan integratedSpan;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(keyEvent, "keyEvent");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        if (this.dpadKeyEvent.onKeyEvent(keyEvent, text)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 67 && keyEvent.getAction() == 0 && (selectionEnd = android.text.Selection.getSelectionEnd(editable)) == (selectionStart = android.text.Selection.getSelectionStart((editable = text))) && (integratedSpanArr = (com.sunhapper.x.spedit.mention.span.IntegratedSpan[]) text.getSpans(selectionStart, selectionEnd, com.sunhapper.x.spedit.mention.span.IntegratedSpan.class)) != null) {
            int length = integratedSpanArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    integratedSpan = null;
                    break;
                }
                integratedSpan = integratedSpanArr[i];
                if (text.getSpanEnd(integratedSpan) == selectionStart) {
                    break;
                }
                i++;
            }
            if (integratedSpan != null) {
                int spanStart = text.getSpanStart(integratedSpan);
                int spanEnd = text.getSpanEnd(integratedSpan);
                if (integratedSpan instanceof com.sunhapper.x.spedit.mention.span.IntegratedBgSpan) {
                    com.sunhapper.x.spedit.mention.span.IntegratedBgSpan integratedBgSpan = (com.sunhapper.x.spedit.mention.span.IntegratedBgSpan) integratedSpan;
                    if (integratedBgSpan.isShow()) {
                        text.replace(spanStart, spanEnd, "");
                    } else {
                        integratedBgSpan.setShow(true);
                        text.setSpan(integratedBgSpan.createStoredBgSpan(integratedBgSpan), spanStart, spanEnd, 33);
                    }
                } else {
                    text.replace(spanStart, spanEnd, "");
                }
                return true;
            }
        }
        return false;
    }
}
