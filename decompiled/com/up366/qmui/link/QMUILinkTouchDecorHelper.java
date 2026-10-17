package com.up366.qmui.link;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUILinkTouchDecorHelper {
    private java.lang.ref.WeakReference<com.up366.qmui.link.ITouchableSpan> mPressedSpanRf;

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(android.widget.TextView textView, android.text.Spannable spannable, android.view.MotionEvent motionEvent) {
        boolean z = true;
        if (motionEvent.getAction() == 0) {
            com.up366.qmui.link.ITouchableSpan pressedSpan = getPressedSpan(textView, spannable, motionEvent);
            if (pressedSpan != null) {
                pressedSpan.setPressed(true);
                android.text.Selection.setSelection(spannable, spannable.getSpanStart(pressedSpan), spannable.getSpanEnd(pressedSpan));
                this.mPressedSpanRf = new java.lang.ref.WeakReference<>(pressedSpan);
            }
            if (textView instanceof com.up366.qmui.widget.textview.ISpanTouchFix) {
                ((com.up366.qmui.widget.textview.ISpanTouchFix) textView).setTouchSpanHit(pressedSpan != null);
            }
            return pressedSpan != null;
        }
        com.up366.qmui.link.ITouchableSpan iTouchableSpan = null;
        if (motionEvent.getAction() == 2) {
            com.up366.qmui.link.ITouchableSpan pressedSpan2 = getPressedSpan(textView, spannable, motionEvent);
            java.lang.ref.WeakReference<com.up366.qmui.link.ITouchableSpan> weakReference = this.mPressedSpanRf;
            com.up366.qmui.link.ITouchableSpan iTouchableSpan2 = weakReference != null ? weakReference.get() : null;
            if (iTouchableSpan2 == null || iTouchableSpan2 == pressedSpan2) {
                iTouchableSpan = iTouchableSpan2;
            } else {
                iTouchableSpan2.setPressed(false);
                this.mPressedSpanRf = null;
                android.text.Selection.removeSelection(spannable);
            }
            if (textView instanceof com.up366.qmui.widget.textview.ISpanTouchFix) {
                ((com.up366.qmui.widget.textview.ISpanTouchFix) textView).setTouchSpanHit(iTouchableSpan != null);
            }
            return iTouchableSpan != null;
        }
        if (motionEvent.getAction() == 1) {
            java.lang.ref.WeakReference<com.up366.qmui.link.ITouchableSpan> weakReference2 = this.mPressedSpanRf;
            com.up366.qmui.link.ITouchableSpan iTouchableSpan3 = weakReference2 != null ? weakReference2.get() : null;
            if (iTouchableSpan3 != null) {
                iTouchableSpan3.setPressed(false);
                if (motionEvent.getAction() == 1) {
                    iTouchableSpan3.onClick(textView);
                }
            } else {
                z = false;
            }
            this.mPressedSpanRf = null;
            android.text.Selection.removeSelection(spannable);
            if (textView instanceof com.up366.qmui.widget.textview.ISpanTouchFix) {
                ((com.up366.qmui.widget.textview.ISpanTouchFix) textView).setTouchSpanHit(z);
            }
            return z;
        }
        java.lang.ref.WeakReference<com.up366.qmui.link.ITouchableSpan> weakReference3 = this.mPressedSpanRf;
        com.up366.qmui.link.ITouchableSpan iTouchableSpan4 = weakReference3 != null ? weakReference3.get() : null;
        if (iTouchableSpan4 != null) {
            iTouchableSpan4.setPressed(false);
        }
        if (textView instanceof com.up366.qmui.widget.textview.ISpanTouchFix) {
            ((com.up366.qmui.widget.textview.ISpanTouchFix) textView).setTouchSpanHit(false);
        }
        this.mPressedSpanRf = null;
        android.text.Selection.removeSelection(spannable);
        return false;
    }

    public com.up366.qmui.link.ITouchableSpan getPressedSpan(android.widget.TextView textView, android.text.Spannable spannable, android.view.MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int totalPaddingLeft = x - textView.getTotalPaddingLeft();
        int totalPaddingTop = y - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        android.text.Layout layout = textView.getLayout();
        int lineForVertical = layout.getLineForVertical(scrollY);
        float f = scrollX;
        try {
            int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f);
            if (f < layout.getLineLeft(lineForVertical) || f > layout.getLineRight(lineForVertical)) {
                offsetForHorizontal = -1;
            }
            com.up366.qmui.link.ITouchableSpan[] iTouchableSpanArr = (com.up366.qmui.link.ITouchableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, com.up366.qmui.link.ITouchableSpan.class);
            if (iTouchableSpanArr.length > 0) {
                return iTouchableSpanArr[0];
            }
            return null;
        } catch (java.lang.IndexOutOfBoundsException unused) {
            return null;
        }
    }
}
