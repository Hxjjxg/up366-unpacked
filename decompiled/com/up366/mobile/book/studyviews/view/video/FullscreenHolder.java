package com.up366.mobile.book.studyviews.view.video;

/* JADX INFO: compiled from: AnswerVideoView.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class FullscreenHolder extends android.widget.FrameLayout {
    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        return true;
    }

    public FullscreenHolder(android.content.Context context) {
        super(context);
        setBackgroundColor(context.getResources().getColor(android.R.color.black));
    }
}
