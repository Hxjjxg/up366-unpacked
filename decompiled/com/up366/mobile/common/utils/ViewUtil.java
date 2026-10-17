package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ViewUtil {
    private static float hideSoftInputOnTouchOutsideActionDownX = 0.0f;
    private static float hideSoftInputOnTouchOutsideActionDownY = 0.0f;
    private static boolean hideSoftInputOnTouchOutsideCancel = false;
    private static float hideSoftInputOnTouchOutsideTouchSlop = 0.0f;
    private static long lastClickTime = 0;
    private static int lastPostHash = -1;
    private static int lastView;

    public static void visible(android.view.View... viewArr) {
        for (android.view.View view : viewArr) {
            view.setVisibility(0);
        }
    }

    public static void invisible(android.view.View... viewArr) {
        for (android.view.View view : viewArr) {
            view.setVisibility(4);
        }
    }

    public static void gone(android.view.View... viewArr) {
        for (android.view.View view : viewArr) {
            view.setVisibility(8);
        }
    }

    public static void enable(android.view.View... viewArr) {
        for (android.view.View view : viewArr) {
            view.setEnabled(true);
        }
    }

    public static void disable(android.view.View... viewArr) {
        for (android.view.View view : viewArr) {
            view.setEnabled(false);
        }
    }

    public static void clearAnim(android.view.View... viewArr) {
        for (android.view.View view : viewArr) {
            view.clearAnimation();
        }
    }

    public static void clickView(final android.view.View view) {
        view.setEnabled(false);
        com.up366.common.task.TaskUtils.postMainTaskDelay(1000L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ViewUtil.1
            @Override // com.up366.common.task.Task
            public void run() {
                view.setEnabled(true);
            }
        });
    }

    public static android.view.View.OnTouchListener getTouchTranslationZFeedBack() {
        return new android.view.View.OnTouchListener() { // from class: com.up366.mobile.common.utils.ViewUtil$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                return com.up366.mobile.common.utils.ViewUtil.lambda$getTouchTranslationZFeedBack$0(view, motionEvent);
            }
        };
    }

    static /* synthetic */ boolean lambda$getTouchTranslationZFeedBack$0(android.view.View view, android.view.MotionEvent motionEvent) {
        view.performClick();
        int action = motionEvent.getAction();
        if (action == 0) {
            android.animation.ObjectAnimator objectAnimatorOfFloat = android.animation.ObjectAnimator.ofFloat(view, "translationZ", 16.0f);
            objectAnimatorOfFloat.setDuration(150L);
            objectAnimatorOfFloat.setInterpolator(new android.view.animation.DecelerateInterpolator());
            objectAnimatorOfFloat.start();
        } else if (action == 1 || action == 3) {
            android.animation.ObjectAnimator objectAnimatorOfFloat2 = android.animation.ObjectAnimator.ofFloat(view, "translationZ", 0.0f);
            objectAnimatorOfFloat2.setDuration(150L);
            objectAnimatorOfFloat2.setInterpolator(new android.view.animation.AccelerateInterpolator());
            objectAnimatorOfFloat2.start();
        }
        return false;
    }

    public static void bindOnClickListener(android.view.View.OnClickListener onClickListener, android.view.View... viewArr) {
        for (android.view.View view : viewArr) {
            bindOnClickListener(view, onClickListener);
        }
    }

    public static void bindOnClickListener(android.view.View view, final android.view.View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            view.setOnClickListener(null);
        } else {
            view.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.utils.ViewUtil$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view2) {
                    com.up366.mobile.common.utils.ViewUtil.lambda$bindOnClickListener$2(onClickListener, view2);
                }
            });
        }
    }

    static /* synthetic */ void lambda$bindOnClickListener$2(final android.view.View.OnClickListener onClickListener, final android.view.View view) {
        if (lastView == view.getId()) {
            runTapAction(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ViewUtil$$ExternalSyntheticLambda5
                @Override // com.up366.common.task.Task
                public final void run() {
                    onClickListener.onClick(view);
                }
            });
            return;
        }
        lastView = view.getId();
        lastClickTime = android.os.SystemClock.uptimeMillis();
        onClickListener.onClick(view);
    }

    public static void bindOnClickListener(final android.view.View view, final long j, final android.view.View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            view.setOnClickListener(null);
        } else {
            view.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.utils.ViewUtil$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view2) {
                    com.up366.mobile.common.utils.ViewUtil.runTapAction(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ViewUtil$$ExternalSyntheticLambda6
                        @Override // com.up366.common.task.Task
                        public final void run() throws java.lang.Exception {
                            com.up366.mobile.common.utils.ViewUtil.lambda$bindOnClickListener$4(view, j, onClickListener, view2);
                        }
                    });
                }
            });
        }
    }

    static /* synthetic */ void lambda$bindOnClickListener$4(final android.view.View view, long j, android.view.View.OnClickListener onClickListener, android.view.View view2) throws java.lang.Exception {
        view.setEnabled(false);
        com.up366.common.task.TaskUtils.postMainTaskDelay(j, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ViewUtil$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() {
                view.setEnabled(true);
            }
        });
        onClickListener.onClick(view2);
    }

    public static void runTapAction(com.up366.common.task.Task task) {
        if (task != null) {
            if (lastClickTime > android.os.SystemClock.uptimeMillis() + 300) {
                lastClickTime = 0L;
            }
            if (lastClickTime + 300 > android.os.SystemClock.uptimeMillis()) {
                return;
            }
            lastClickTime = android.os.SystemClock.uptimeMillis();
            com.up366.common.task.TaskUtils.postMainTask(task);
        }
    }

    public static android.graphics.drawable.Drawable getDrawable(android.content.Context context, int i) {
        android.graphics.drawable.Drawable drawable = context.getDrawable(i);
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        return drawable;
    }

    public static boolean isTouchToView(android.view.View view, android.view.MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        return isTouchToView(view, motionEvent.getX(), motionEvent.getY());
    }

    public static boolean isTouchToView(android.view.View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new android.graphics.RectF(iArr[0], iArr[1], r0 + view.getWidth(), iArr[1] + view.getHeight()).contains(f, f2);
    }

    @java.lang.Deprecated
    public static void hideSoftInputOnTouchOutside(final android.app.Activity activity, android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            final float x = motionEvent.getX();
            final float y = motionEvent.getY();
            com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ViewUtil$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.mobile.common.utils.ViewUtil.lambda$hideSoftInputOnTouchOutside$6(activity, x, y);
                }
            });
        }
    }

    static /* synthetic */ void lambda$hideSoftInputOnTouchOutside$6(android.app.Activity activity, float f, float f2) throws java.lang.Exception {
        android.view.View currentFocus = activity.getCurrentFocus();
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager == null || currentFocus == null || currentFocus.getWindowToken() == null || isTouchToView(currentFocus, f, f2)) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
    }

    public static void hideSoftInput(android.view.View view) {
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    public static void showSoftInput(android.view.View view) {
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(view, 1);
        }
    }

    public static void hideSoftInputOnTouchOutside(android.view.MotionEvent motionEvent, android.view.View... viewArr) {
        android.view.inputmethod.InputMethodManager inputMethodManager;
        android.content.Context context = viewArr[0].getContext();
        if (motionEvent.getAction() == 0) {
            hideSoftInputOnTouchOutsideActionDownX = motionEvent.getX();
            hideSoftInputOnTouchOutsideActionDownY = motionEvent.getY();
            hideSoftInputOnTouchOutsideCancel = false;
            hideSoftInputOnTouchOutsideTouchSlop = android.view.ViewConfiguration.get(context).getScaledTouchSlop();
        }
        boolean z = true;
        if (motionEvent.getAction() == 2) {
            float x = hideSoftInputOnTouchOutsideActionDownX - motionEvent.getX();
            float y = hideSoftInputOnTouchOutsideActionDownY - motionEvent.getY();
            float f = (x * x) + (y * y);
            float f2 = hideSoftInputOnTouchOutsideTouchSlop;
            if (f > f2 * f2) {
                hideSoftInputOnTouchOutsideCancel = true;
            }
        }
        if (motionEvent.getAction() != 1 || hideSoftInputOnTouchOutsideCancel) {
            return;
        }
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int[] iArr = new int[2];
        int length = viewArr.length;
        android.os.IBinder iBinder = null;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            android.view.View view = viewArr[i];
            android.os.IBinder windowToken = view.getWindowToken();
            view.getLocationOnScreen(iArr);
            if (rawX > iArr[0] && rawX < r11 + view.getWidth()) {
                if (rawY > iArr[1] && rawY < r11 + view.getHeight()) {
                    iBinder = windowToken;
                    break;
                }
            }
            i++;
            iBinder = windowToken;
        }
        if (z || iBinder == null || motionEvent.getEventTime() - motionEvent.getDownTime() >= 300 || (inputMethodManager = (android.view.inputmethod.InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(iBinder, 2);
        for (android.view.View view2 : viewArr) {
            if (view2.hasFocus()) {
                view2.clearFocus();
            }
        }
    }

    public static void checkAndPost(int i, java.lang.Runnable runnable) {
        if (i == lastPostHash) {
            com.up366.common.log.Logger.warn("TAG - ViewUtil - checkAndPost - fast click repeat hash : " + i);
        } else {
            lastPostHash = i;
            com.up366.common.task.TaskUtils.postLazyTaskGlobal("clearState", com.up366.medialibrary.camera.CustomCameraView.DEFAULT_MIN_RECORD_VIDEO, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ViewUtil$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.common.utils.ViewUtil.lastPostHash = -1;
                }
            });
            runnable.run();
        }
    }

    public static void clearStateOnStart(int i) {
        if (i == lastPostHash) {
            lastPostHash = -1;
        }
    }

    public static java.lang.String getString(int i) {
        return com.up366.common.global.GB.get().getApplicationContext().getString(i);
    }

    public static void cleanSoftInput(android.app.Activity activity) {
        try {
            android.view.View currentFocus = activity.getCurrentFocus();
            android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) activity.getSystemService("input_method");
            if (inputMethodManager == null || currentFocus == null || currentFocus.getWindowToken() == null) {
                return;
            }
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            java.lang.String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
            for (int i = 0; i < 3; i++) {
                java.lang.String str = strArr[i];
                try {
                    java.lang.reflect.Field declaredField = inputMethodManager.getClass().getDeclaredField(str);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    java.lang.Object obj = declaredField.get(inputMethodManager);
                    if (obj != null && (obj instanceof android.view.View) && ((android.view.View) obj).getContext() == activity) {
                        com.up366.common.log.Logger.info("TAG - ViewUtil - cleanSoftInput - clean fieldName: " + str);
                        declaredField.set(inputMethodManager, null);
                    }
                } catch (java.lang.Exception e) {
                    com.up366.common.log.Logger.info("TAG - ViewUtil - cleanSoftInput - fieldName: " + e.getMessage());
                }
            }
            try {
                java.lang.reflect.Field declaredField2 = inputMethodManager.getClass().getDeclaredField("mReportRunnerMap");
                if (!declaredField2.isAccessible()) {
                    declaredField2.setAccessible(true);
                }
                java.lang.Object obj2 = declaredField2.get(inputMethodManager);
                if (obj2 instanceof java.util.Map) {
                    java.util.Iterator it = ((java.util.Map) obj2).values().iterator();
                    while (it.hasNext()) {
                        java.lang.Object next = it.next();
                        try {
                            java.lang.reflect.Field declaredField3 = next.getClass().getDeclaredField("val$view");
                            declaredField3.setAccessible(true);
                            java.lang.Object obj3 = declaredField3.get(next);
                            if ((obj3 instanceof android.view.View) && ((android.view.View) obj3).getContext() == activity) {
                                com.up366.common.log.Logger.info("TAG - ViewUtil - cleanSoftInput - clean runner: " + next);
                                it.remove();
                            }
                        } catch (java.lang.Exception e2) {
                            com.up366.common.log.Logger.info("TAG - ViewUtil - cleanSoftInput - runnerField: " + e2.getMessage());
                        }
                    }
                }
            } catch (java.lang.Exception e3) {
                com.up366.common.log.Logger.info("TAG - ViewUtil - cleanSoftInput - runnerMapField: " + e3.getMessage());
            }
        } catch (java.lang.Exception e4) {
            com.up366.common.log.Logger.info("TAG - ViewUtil - cleanSoftInput: " + e4.getMessage());
        }
    }
}
