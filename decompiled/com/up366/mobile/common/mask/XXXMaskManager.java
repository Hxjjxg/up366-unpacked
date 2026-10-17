package com.up366.mobile.common.mask;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class XXXMaskManager implements com.up366.mobile.common.mask.IMaskManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final java.lang.String MASK_MANAGER_KEY = "MaskManager";
    private android.widget.FrameLayout layout;

    static /* synthetic */ void lambda$dismissMaskTask$1() throws java.lang.Exception {
    }

    @Override // com.up366.mobile.common.mask.IMaskManager
    public void handleMask(android.app.Activity activity) {
        try {
            if (com.up366.mobile.common.mask.MaskHelper.getInst().isHasOpenMask()) {
                com.up366.mobile.common.mask.MaskHelper.getInst().checkPermission(activity);
                showMask(activity);
            } else {
                dismissMask();
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("handleMask error " + e.getMessage());
        }
    }

    @Override // com.up366.mobile.common.mask.IMaskManager
    public void showMaskTask(android.app.Activity activity) {
        try {
            if (com.up366.mobile.common.mask.MaskHelper.getInst().getAfterDuration() == 0) {
                com.up366.mobile.common.mask.MaskHelper.getInst().showMaskDialog();
            } else {
                com.up366.common.task.TaskUtils.postLazyTaskMain(MASK_MANAGER_KEY, com.up366.mobile.common.mask.MaskHelper.getInst().getAfterDuration(), new com.up366.common.task.Task() { // from class: com.up366.mobile.common.mask.XXXMaskManager$$ExternalSyntheticLambda1
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        com.up366.mobile.common.mask.MaskHelper.getInst().showMaskDialog();
                    }
                });
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("showMaskTask error " + e.getMessage());
        }
    }

    private void showMask(android.app.Activity activity) {
        try {
            android.widget.FrameLayout frameLayout = this.layout;
            if (frameLayout != null) {
                frameLayout.setAlpha(com.up366.mobile.common.mask.MaskHelper.hasPermission(activity) ? 1.0f : 0.0f);
                this.layout.setVisibility(com.up366.mobile.common.mask.MaskHelper.hasPermission(activity) ? 0 : 4);
            } else {
                addMaskView(activity);
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("showMaskTask error " + e.getMessage());
        }
    }

    @Override // com.up366.mobile.common.mask.IMaskManager
    public void dismissMask() {
        try {
            android.widget.FrameLayout frameLayout = this.layout;
            if (frameLayout != null) {
                frameLayout.setAlpha(0.0f);
                this.layout.setVisibility(4);
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("showMaskTask error " + e.getMessage());
        }
    }

    @Override // com.up366.mobile.common.mask.IMaskManager
    public void addMaskView(android.app.Activity activity) {
        addView(com.up366.mobile.common.mask.MaskHelper.getInst().isHasOpenMask() ? 0 : 4);
    }

    @Override // com.up366.mobile.common.mask.IMaskManager
    public void dismissMaskTask() {
        com.up366.common.task.TaskUtils.postLazyTaskMain(MASK_MANAGER_KEY, 0, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.mask.XXXMaskManager$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.mask.XXXMaskManager.lambda$dismissMaskTask$1();
            }
        });
    }

    private void showMaskWithAnimation(android.app.Activity activity, final com.up366.mobile.common.mask.IMaskManager.ICallBack iCallBack) {
        android.widget.FrameLayout frameLayout = this.layout;
        if (frameLayout == null) {
            iCallBack.onFinished();
            return;
        }
        try {
            frameLayout.setVisibility(0);
            android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setDuration(800L);
            valueAnimatorOfFloat.setInterpolator(new android.view.animation.DecelerateInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.mobile.common.mask.XXXMaskManager$$ExternalSyntheticLambda2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                    this.f$0.lambda$showMaskWithAnimation$2(valueAnimator);
                }
            });
            valueAnimatorOfFloat.start();
            valueAnimatorOfFloat.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.up366.mobile.common.mask.XXXMaskManager.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(android.animation.Animator animator) {
                    iCallBack.onFinished();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(android.animation.Animator animator) {
                    iCallBack.onFinished();
                }
            });
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("showMaskWithAnimation error" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showMaskWithAnimation$2(android.animation.ValueAnimator valueAnimator) {
        this.layout.setAlpha(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    @Override // com.up366.mobile.common.mask.IMaskManager
    public synchronized void openMask(android.app.Activity activity, com.up366.mobile.common.mask.IMaskManager.ICallBack iCallBack) {
        try {
            com.up366.mobile.common.mask.MaskHelper.getInst().checkPermission(activity);
            removeMask();
            addView(4);
            com.up366.mobile.common.mask.MaskHelper.getInst();
            if (com.up366.mobile.common.mask.MaskHelper.hasPermission(activity)) {
                showMaskWithAnimation(activity, iCallBack);
            } else {
                iCallBack.onFinished();
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("showMaskTask error " + e.getMessage());
        }
    }

    private void removeMask() {
        if (this.layout == null) {
            return;
        }
        try {
            ((android.view.WindowManager) com.up366.common.global.GB.get().getApplicationContext().getSystemService("window")).removeView(this.layout);
            this.layout = null;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("removeMask  error" + e.getMessage());
        }
    }

    @Override // com.up366.mobile.common.mask.IMaskManager
    public synchronized void closeMask(android.app.Activity activity, final com.up366.mobile.common.mask.IMaskManager.ICallBack iCallBack) {
        try {
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("closeMask error " + e.getMessage());
        }
        if (this.layout == null) {
            iCallBack.onFinished();
            return;
        }
        android.animation.ValueAnimator valueAnimatorOfFloat = android.animation.ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setDuration(800L);
        valueAnimatorOfFloat.setInterpolator(new android.view.animation.DecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.up366.mobile.common.mask.XXXMaskManager$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f$0.lambda$closeMask$3(valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
        valueAnimatorOfFloat.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.up366.mobile.common.mask.XXXMaskManager.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                super.onAnimationEnd(animator);
                iCallBack.onFinished();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
                iCallBack.onFinished();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeMask$3(android.animation.ValueAnimator valueAnimator) {
        float fFloatValue = ((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue();
        this.layout.setAlpha(fFloatValue);
        if (fFloatValue == 0.0f) {
            this.layout.setVisibility(4);
        }
    }

    @Override // com.up366.mobile.common.mask.IMaskManager
    public void dismissMaskOnBackGround() {
        dismissMask();
    }

    private void addView(int i) {
        try {
            if (this.layout != null) {
                return;
            }
            com.up366.mobile.common.mask.MaskHelper.getInst();
            if (com.up366.mobile.common.mask.MaskHelper.hasPermission(com.up366.common.global.GB.get().getCurrentActivity())) {
                android.view.WindowManager.LayoutParams layoutParams = new android.view.WindowManager.LayoutParams(-1, -1, 0, 0, -2);
                layoutParams.flags = -2013264872;
                layoutParams.format = -2;
                if (android.os.Build.VERSION.SDK_INT > 25) {
                    layoutParams.type = 2038;
                } else if (android.os.Build.VERSION.SDK_INT == 25) {
                    layoutParams.type = 2003;
                } else {
                    layoutParams.type = 2005;
                }
                if ("MI MAX".equals(android.os.Build.MODEL) || "Redmi Note 4X".equals(android.os.Build.MODEL)) {
                    layoutParams.type = 2003;
                }
                com.up366.notchtools.NotchTools.getInst().fitNotchForLayoutParams(layoutParams, com.up366.common.global.GB.get().getCurrentActivity().getWindow());
                android.content.Context applicationContext = com.up366.common.global.GB.get().getApplicationContext();
                layoutParams.gravity = 51;
                android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(applicationContext);
                this.layout = frameLayout;
                frameLayout.setBackgroundColor(android.graphics.Color.argb(com.up366.medialibrary.config.PictureConstants.PREVIEW_VIDEO_CODE, 0, 0, 0));
                this.layout.setFocusable(false);
                this.layout.setFocusableInTouchMode(false);
                this.layout.setVisibility(i);
                ((android.view.WindowManager) applicationContext.getSystemService("window")).addView(this.layout, layoutParams);
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.warn("start Mask error " + e.getMessage());
        }
    }
}
