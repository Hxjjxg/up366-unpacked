package com.contrarywind.timer;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public final class MessageHandler extends android.os.Handler {
    public static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    public static final int WHAT_ITEM_SELECTED = 3000;
    public static final int WHAT_SMOOTH_SCROLL = 2000;
    private final com.contrarywind.view.WheelView wheelView;

    public MessageHandler(com.contrarywind.view.WheelView wheelView) {
        this.wheelView = wheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        int i = message.what;
        if (i == 1000) {
            this.wheelView.invalidate();
        } else if (i == 2000) {
            this.wheelView.smoothScroll(com.contrarywind.view.WheelView.ACTION.FLING);
        } else {
            if (i != 3000) {
                return;
            }
            this.wheelView.onItemSelected();
        }
    }
}
