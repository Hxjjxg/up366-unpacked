package com.up366.view.wheelview.timer;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class InertiaTimerTask extends java.util.TimerTask {
    private float mCurrentVelocityY = 2.14748365E9f;
    private final float mFirstVelocityY;
    private final com.up366.view.wheelview.WheelView mWheelView;

    public InertiaTimerTask(com.up366.view.wheelview.WheelView wheelView, float f) {
        this.mWheelView = wheelView;
        this.mFirstVelocityY = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.mCurrentVelocityY == 2.14748365E9f) {
            if (java.lang.Math.abs(this.mFirstVelocityY) > 2000.0f) {
                this.mCurrentVelocityY = this.mFirstVelocityY <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.mCurrentVelocityY = this.mFirstVelocityY;
            }
        }
        if (java.lang.Math.abs(this.mCurrentVelocityY) >= 0.0f && java.lang.Math.abs(this.mCurrentVelocityY) <= 20.0f) {
            this.mWheelView.cancelFuture();
            this.mWheelView.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        com.up366.view.wheelview.WheelView wheelView = this.mWheelView;
        float f = i;
        wheelView.setTotalScrollY(wheelView.getTotalScrollY() - f);
        if (!this.mWheelView.isLoop()) {
            float itemHeight = this.mWheelView.getItemHeight();
            float totalScrollY = (-this.mWheelView.getInitPosition()) * itemHeight;
            float itemsCount = ((this.mWheelView.getItemsCount() - 1) - this.mWheelView.getInitPosition()) * itemHeight;
            double d = ((double) itemHeight) * 0.25d;
            if (((double) this.mWheelView.getTotalScrollY()) - d < totalScrollY) {
                totalScrollY = this.mWheelView.getTotalScrollY() + f;
            } else if (((double) this.mWheelView.getTotalScrollY()) + d > itemsCount) {
                itemsCount = this.mWheelView.getTotalScrollY() + f;
            }
            if (this.mWheelView.getTotalScrollY() <= totalScrollY) {
                this.mCurrentVelocityY = 40.0f;
                this.mWheelView.setTotalScrollY((int) totalScrollY);
            } else if (this.mWheelView.getTotalScrollY() >= itemsCount) {
                this.mWheelView.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        float f2 = this.mCurrentVelocityY;
        if (f2 < 0.0f) {
            this.mCurrentVelocityY = f2 + 20.0f;
        } else {
            this.mCurrentVelocityY = f2 - 20.0f;
        }
        this.mWheelView.getHandler().sendEmptyMessage(1000);
    }
}
