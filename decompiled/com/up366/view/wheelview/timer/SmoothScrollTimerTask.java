package com.up366.view.wheelview.timer;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class SmoothScrollTimerTask extends java.util.TimerTask {
    private int offset;
    private final com.up366.view.wheelview.WheelView wheelView;
    private int realTotalOffset = Integer.MAX_VALUE;
    private int realOffset = 0;

    public SmoothScrollTimerTask(com.up366.view.wheelview.WheelView wheelView, int i) {
        this.wheelView = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.realTotalOffset == Integer.MAX_VALUE) {
            this.realTotalOffset = this.offset;
        }
        int i = this.realTotalOffset;
        int i2 = (int) (i * 0.1f);
        this.realOffset = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.realOffset = -1;
            } else {
                this.realOffset = 1;
            }
        }
        if (java.lang.Math.abs(i) <= 1) {
            this.wheelView.cancelFuture();
            this.wheelView.getHandler().sendEmptyMessage(3000);
            return;
        }
        com.up366.view.wheelview.WheelView wheelView = this.wheelView;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() + this.realOffset);
        if (!this.wheelView.isLoop()) {
            float itemHeight = this.wheelView.getItemHeight();
            float itemsCount = ((this.wheelView.getItemsCount() - 1) - this.wheelView.getInitPosition()) * itemHeight;
            if (this.wheelView.getTotalScrollY() <= (-this.wheelView.getInitPosition()) * itemHeight || this.wheelView.getTotalScrollY() >= itemsCount) {
                com.up366.view.wheelview.WheelView wheelView2 = this.wheelView;
                wheelView2.setTotalScrollY(wheelView2.getTotalScrollY() - this.realOffset);
                this.wheelView.cancelFuture();
                this.wheelView.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.wheelView.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
