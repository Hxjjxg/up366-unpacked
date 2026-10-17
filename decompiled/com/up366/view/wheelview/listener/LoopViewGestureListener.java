package com.up366.view.wheelview.listener;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class LoopViewGestureListener extends android.view.GestureDetector.SimpleOnGestureListener {
    private final com.up366.view.wheelview.WheelView wheelView;

    public LoopViewGestureListener(com.up366.view.wheelview.WheelView wheelView) {
        this.wheelView = wheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f, float f2) {
        this.wheelView.scrollBy(f2);
        return true;
    }
}
