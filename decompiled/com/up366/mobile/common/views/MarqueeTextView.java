package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MarqueeTextView extends androidx.appcompat.widget.AppCompatTextView {
    private java.lang.Runnable onTextChangedListener;

    public boolean isFocused() {
        return true;
    }

    protected void onFocusChanged(boolean z, int i, android.graphics.Rect rect) {
    }

    public MarqueeTextView(android.content.Context context) {
        super(context);
        setFocusable(true);
    }

    public MarqueeTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(true);
    }

    public MarqueeTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setFocusable(true);
    }

    public void setOnTextChangedListener(java.lang.Runnable runnable) {
        this.onTextChangedListener = runnable;
    }

    protected void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        java.lang.Runnable runnable = this.onTextChangedListener;
        if (runnable != null) {
            runnable.run();
        }
    }
}
