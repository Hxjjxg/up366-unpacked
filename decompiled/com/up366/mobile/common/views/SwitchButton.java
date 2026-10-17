package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SwitchButton extends com.airbnb.lottie.LottieAnimationView implements android.widget.Checkable {
    private static final java.lang.String TAG = "SwitchButton";
    private float anchorX;
    boolean cancelClickEvent;
    private float downX;
    private com.up366.mobile.common.views.SwitchButton.IOnCheckedChangeListener listener;
    private boolean mChecked;
    private android.view.VelocityTracker mVelocityTracker;
    private float percent;
    private final int scaledTouchSlop;

    public interface IOnCheckedChangeListener {
        void onCheckedChanged(com.up366.mobile.common.views.SwitchButton switchButton, boolean z);
    }

    public SwitchButton(android.content.Context context) {
        this(context, null);
    }

    public SwitchButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchButton(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChecked = false;
        this.cancelClickEvent = false;
        this.scaledTouchSlop = android.view.ViewConfiguration.get(context).getScaledTouchSlop();
        if (isInEditMode()) {
            setBackgroundColor(-2004317953);
            return;
        }
        setAnimation("switch.zip");
        setMinAndMaxFrame(0, 51);
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.SwitchButton$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$0(view);
            }
        });
        switchToCheckState(this.mChecked, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(android.view.View view) {
        toggle();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.mChecked != z) {
            toggle();
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        switchToCheckState(!this.mChecked, false, true);
    }

    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        float x = motionEvent.getX();
        int width = getWidth();
        int i = (width * 5) / 9;
        int action = motionEvent.getAction();
        if (action == 0) {
            obtainVelocityTracker(motionEvent);
            getParent().requestDisallowInterceptTouchEvent(true);
            this.anchorX = motionEvent.getX();
            this.downX = motionEvent.getX();
            this.cancelClickEvent = false;
        } else if (action == 1) {
            this.mVelocityTracker.addMovement(motionEvent);
            if (!this.cancelClickEvent) {
                performClick();
            } else {
                this.mVelocityTracker.computeCurrentVelocity(1000);
                float xVelocity = this.mVelocityTracker.getXVelocity();
                if (xVelocity < -100.0f && x < width) {
                    switchToCheckState(false, true, true);
                } else if ((xVelocity <= 100.0f || x <= 0.0f) && this.percent > 0.5d) {
                    switchToCheckState(false, true, true);
                } else {
                    switchToCheckState(true, true, true);
                }
            }
            releaseVelocityTracker();
        } else if (action == 2) {
            this.mVelocityTracker.addMovement(motionEvent);
            if (java.lang.Math.abs(motionEvent.getX() - this.downX) > this.scaledTouchSlop) {
                this.cancelClickEvent = true;
            }
            float f = x - this.anchorX;
            this.mVelocityTracker.computeCurrentVelocity(1000);
            this.anchorX = x;
            float f2 = this.percent - (f / i);
            this.percent = f2;
            if (f2 <= 0.0f) {
                this.percent = 0.0f;
            }
            if (this.percent >= 1.0f) {
                this.percent = 1.0f;
            }
            setFrame((int) (getMaxFrame() * this.percent));
        } else if (action == 3) {
            releaseVelocityTracker();
        }
        return true;
    }

    private void switchToCheckState(boolean z, boolean z2, boolean z3) {
        if (this.mChecked != z) {
            this.mChecked = z;
            com.up366.mobile.common.views.SwitchButton.IOnCheckedChangeListener iOnCheckedChangeListener = this.listener;
            if (iOnCheckedChangeListener != null) {
                iOnCheckedChangeListener.onCheckedChanged(this, z);
            }
        }
        this.percent = z ? 0.0f : 1.0f;
        if (z3) {
            setSpeed(z ? -1.0f : 1.0f);
            if (!z2) {
                resumeAnimation();
                return;
            } else {
                if (getFrame() <= getMinFrame() || getFrame() >= getMaxFrame()) {
                    return;
                }
                resumeAnimation();
                return;
            }
        }
        setProgress(this.mChecked ? 0.0f : 1.0f);
        this.percent = this.mChecked ? 0.0f : 1.0f;
    }

    public boolean performClick() {
        return super.performClick();
    }

    private void obtainVelocityTracker(android.view.MotionEvent motionEvent) {
        releaseVelocityTracker();
        if (this.mVelocityTracker == null) {
            android.view.VelocityTracker velocityTrackerObtain = android.view.VelocityTracker.obtain();
            this.mVelocityTracker = velocityTrackerObtain;
            velocityTrackerObtain.clear();
        }
        this.mVelocityTracker.addMovement(motionEvent);
    }

    private void releaseVelocityTracker() {
        android.view.VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.switch_width), 0);
        int iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.switch_height), 0);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec2);
        setMeasuredDimension(iMakeMeasureSpec, iMakeMeasureSpec2);
    }

    public void setOnCheckedChangeListener(com.up366.mobile.common.views.SwitchButton.IOnCheckedChangeListener iOnCheckedChangeListener) {
        this.listener = iOnCheckedChangeListener;
    }
}
