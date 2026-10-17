package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UpScrollExitFrameLayout extends android.widget.FrameLayout {
    private long downTime;
    private float downY;
    private com.up366.mobile.common.views.UpScrollExitFrameLayout.ExitListener exitListener;
    private float oldY;
    private final int touchSlop;

    public interface ExitListener {
        void exit(boolean z);

        void scrollY(int i);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        return true;
    }

    public UpScrollExitFrameLayout(android.content.Context context) {
        this(context, null);
    }

    public UpScrollExitFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UpScrollExitFrameLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.touchSlop = android.view.ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            float rawY = motionEvent.getRawY();
            this.oldY = rawY;
            this.downY = rawY;
            this.downTime = java.lang.System.currentTimeMillis();
        }
        if (motionEvent.getAction() == 2) {
            float rawY2 = motionEvent.getRawY();
            com.up366.mobile.common.views.UpScrollExitFrameLayout.ExitListener exitListener = this.exitListener;
            if (exitListener != null) {
                exitListener.scrollY((int) (rawY2 - this.oldY));
                this.oldY = rawY2;
            }
        }
        if (motionEvent.getAction() == 1) {
            float rawY3 = motionEvent.getRawY();
            if (this.exitListener != null) {
                if (java.lang.Math.abs(rawY3 - this.downY) < this.touchSlop && java.lang.System.currentTimeMillis() - this.downTime < 200) {
                    this.exitListener.exit(true);
                } else {
                    this.exitListener.exit(false);
                }
            }
        }
        return true;
    }

    public void setExitListener(com.up366.mobile.common.views.UpScrollExitFrameLayout.ExitListener exitListener) {
        this.exitListener = exitListener;
    }
}
