package com.up366.qmui.link;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUILinkTouchMovementMethod extends android.text.method.LinkMovementMethod {
    private static com.up366.qmui.link.QMUILinkTouchDecorHelper sHelper = new com.up366.qmui.link.QMUILinkTouchDecorHelper();
    private static com.up366.qmui.link.QMUILinkTouchMovementMethod sInstance;

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(android.widget.TextView textView, android.text.Spannable spannable, android.view.MotionEvent motionEvent) {
        return sHelper.onTouchEvent(textView, spannable, motionEvent) || android.text.method.Touch.onTouchEvent(textView, spannable, motionEvent);
    }

    public static android.text.method.MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new com.up366.qmui.link.QMUILinkTouchMovementMethod();
        }
        return sInstance;
    }
}
