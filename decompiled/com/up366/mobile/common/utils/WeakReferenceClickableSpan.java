package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WeakReferenceClickableSpan extends android.text.style.ClickableSpan {
    private final java.lang.ref.WeakReference<android.text.style.ClickableSpan> clickableSpanWeakReference;

    public WeakReferenceClickableSpan(java.util.List<android.text.style.ClickableSpan> list, android.text.style.ClickableSpan clickableSpan) {
        list.add(clickableSpan);
        this.clickableSpanWeakReference = new java.lang.ref.WeakReference<>(clickableSpan);
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(android.view.View view) {
        android.text.style.ClickableSpan clickableSpan = this.clickableSpanWeakReference.get();
        if (clickableSpan != null) {
            clickableSpan.onClick(view);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(android.text.TextPaint textPaint) {
        android.text.style.ClickableSpan clickableSpan = this.clickableSpanWeakReference.get();
        if (clickableSpan != null) {
            clickableSpan.updateDrawState(textPaint);
        }
    }
}
