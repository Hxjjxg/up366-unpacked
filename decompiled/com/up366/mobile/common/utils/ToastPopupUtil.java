package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ToastPopupUtil {
    private static java.util.Map<java.lang.String, com.up366.mobile.common.utils.ToastPopupUtil.Holder> map = new java.util.HashMap();
    private static java.lang.ref.WeakReference<android.view.View> weakParentView = new java.lang.ref.WeakReference<>(null);

    static /* synthetic */ void lambda$dismiss$0() throws java.lang.Exception {
    }

    static /* synthetic */ void lambda$show$4() throws java.lang.Exception {
    }

    static /* synthetic */ void lambda$showCustomPopWindow$8() {
    }

    private static android.view.View getDecorView(android.app.Activity activity) {
        if (activity == null || activity.getWindow() == null) {
            return null;
        }
        return activity.getWindow().getDecorView();
    }

    private static android.app.Activity findActivity(android.content.Context context) {
        while (context instanceof android.content.ContextWrapper) {
            if (context instanceof android.app.Activity) {
                return (android.app.Activity) context;
            }
            android.content.Context baseContext = ((android.content.ContextWrapper) context).getBaseContext();
            if (baseContext == context) {
                break;
            }
            context = baseContext;
        }
        if (context instanceof android.app.Activity) {
            return (android.app.Activity) context;
        }
        return null;
    }

    private static boolean isActivityInvalid(android.content.Context context) {
        android.app.Activity activityFindActivity = findActivity(context);
        return activityFindActivity != null && (activityFindActivity.isFinishing() || activityFindActivity.isDestroyed());
    }

    private static boolean isHostViewValid(android.view.View view) {
        return (view == null || !androidx.core.view.ViewCompat.isAttachedToWindow(view) || view.getWindowToken() == null) ? false : true;
    }

    private static void clearPendingHolder(java.lang.String str, com.up366.mobile.common.utils.ToastPopupUtil.Holder holder, android.widget.ImageView imageView) {
        if (map.get(str) == holder) {
            map.remove(str);
        }
        imageView.animate().cancel();
        imageView.setRotation(0.0f);
    }

    public static void show(java.lang.String str) {
        android.view.View decorView = getDecorView(com.up366.common.global.GB.get().getCurrentActivity());
        if (decorView == null) {
            return;
        }
        show(decorView, str);
    }

    public static void show(android.app.Activity activity, int i) {
        if (activity == null) {
            return;
        }
        show(activity, activity.getString(i));
    }

    public static void show(android.app.Activity activity, java.lang.String str) {
        android.view.View decorView = getDecorView(activity);
        if (decorView == null) {
            return;
        }
        show(decorView, str, 0, 0, false);
    }

    public static void showInfo(android.app.Activity activity, java.lang.String str) {
        android.view.View decorView = getDecorView(activity);
        if (decorView == null) {
            return;
        }
        show(decorView, str, com.up366.mobile.R.drawable.toast_popup_info, 0, false);
    }

    public static void showInfo(android.app.Activity activity, int i) {
        showInfo(activity, activity.getResources().getString(i));
    }

    public static void showSuccess(android.app.Activity activity, java.lang.String str) {
        android.view.View decorView = getDecorView(activity);
        if (decorView == null) {
            return;
        }
        show(decorView, str, com.up366.mobile.R.drawable.toast_popup_success, 0, false);
    }

    public static void showError(android.app.Activity activity, java.lang.String str) {
        android.view.View decorView = getDecorView(activity);
        if (decorView == null) {
            return;
        }
        show(decorView, str, com.up366.mobile.R.drawable.toast_popup_error, 0, false);
    }

    public static void showLoading(android.app.Activity activity, java.lang.String str) {
        android.view.View decorView = getDecorView(activity);
        if (decorView == null) {
            return;
        }
        show(decorView, str, com.up366.mobile.R.drawable.toast_popup_loading, 0, true);
    }

    public static void showLoadingNoLoadingView(android.app.Activity activity, java.lang.String str) {
        android.view.View decorView = getDecorView(activity);
        if (decorView == null) {
            return;
        }
        show(decorView, str, 0, 0, true);
    }

    public static void showTopIconInfo(android.app.Activity activity, java.lang.String str) {
        android.view.View decorView = getDecorView(activity);
        if (decorView == null) {
            return;
        }
        show(decorView, str, com.up366.mobile.R.drawable.toast_popup_info, 0, false);
    }

    public static void show(android.view.View view, java.lang.String str) {
        show(view.getRootView(), str, 0, 0, false);
    }

    public static void show(android.view.View view, int i) {
        show(view.getRootView(), view.getResources().getString(i), 0, 0, false);
    }

    public static void showInfo(android.view.View view, int i) {
        showInfo(view, view.getResources().getString(i));
    }

    public static void showInfo(android.view.View view, java.lang.String str) {
        show(view.getRootView(), str, com.up366.mobile.R.drawable.toast_popup_info, 0, false);
    }

    public static void showSuccess(android.view.View view, java.lang.String str) {
        show(view.getRootView(), str, com.up366.mobile.R.drawable.toast_popup_success, 0, false);
    }

    public static void showError(android.view.View view, java.lang.String str) {
        show(view.getRootView(), str, com.up366.mobile.R.drawable.toast_popup_error, 0, false);
    }

    public static void showLoading(android.view.View view, java.lang.String str) {
        show(view.getRootView(), str, com.up366.mobile.R.drawable.toast_popup_loading, 0, true);
    }

    public static void showTopIconInfo(android.view.View view, java.lang.String str) {
        show(view.getRootView(), str, com.up366.mobile.R.drawable.toast_popup_info, 0, false);
    }

    public static void showInfo(android.view.View view, com.up366.common.http.Response response) {
        showInfo(view, com.up366.mobile.common.utils.ErrorMessageTool.convert(response));
    }

    public static void showInfo(android.app.Activity activity, com.up366.common.http.Response response) {
        showInfo(activity, com.up366.mobile.common.utils.ErrorMessageTool.convert(response));
    }

    public static void dismiss(android.app.Activity activity) {
        android.view.View decorView = getDecorView(activity);
        if (decorView == null) {
            return;
        }
        dismiss(decorView);
    }

    public static void dismiss(android.view.View view) {
        android.view.View rootView = view.getRootView();
        final java.lang.String str = rootView.getClass().getName() + rootView.hashCode();
        com.up366.common.task.TaskUtils.postLazyTaskMain("dismiss-toast-popup-" + str, 1, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ToastPopupUtil$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.utils.ToastPopupUtil.lambda$dismiss$0();
            }
        });
        rootView.post(new java.lang.Runnable() { // from class: com.up366.mobile.common.utils.ToastPopupUtil$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.common.utils.ToastPopupUtil.lambda$dismiss$1(str);
            }
        });
    }

    static /* synthetic */ void lambda$dismiss$1(java.lang.String str) {
        com.up366.mobile.common.utils.ToastPopupUtil.Holder holderRemove = map.remove(str);
        if (holderRemove != null) {
            try {
                holderRemove.popupWindow.dismiss();
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("dismiss error " + e.getMessage());
            }
        }
    }

    private static void show(final android.view.View view, final java.lang.String str, final int i, int i2, final boolean z) {
        if (view == null) {
            return;
        }
        view.post(new java.lang.Runnable() { // from class: com.up366.mobile.common.utils.ToastPopupUtil$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.common.utils.ToastPopupUtil.lambda$show$7(view, i, z, str);
            }
        });
    }

    static /* synthetic */ void lambda$show$7(android.view.View view, int i, boolean z, java.lang.String str) {
        if (view.getVisibility() == 0 && isHostViewValid(view) && !isActivityInvalid(view.getContext())) {
            final java.lang.String str2 = view.getClass().getName() + view.hashCode();
            com.up366.mobile.common.utils.ToastPopupUtil.Holder holderRemove = map.remove(str2);
            if (holderRemove != null) {
                holderRemove.rootView.setVisibility(4);
                try {
                    holderRemove.popupWindow.dismiss();
                } catch (java.lang.Exception e) {
                    com.up366.common.log.Logger.error("dismiss error " + e.getMessage());
                }
            }
            final com.up366.mobile.common.utils.ToastPopupUtil.Holder holder = new com.up366.mobile.common.utils.ToastPopupUtil.Holder();
            map.put(str2, holder);
            holder.popupWindow = new android.widget.PopupWindow();
            holder.popupWindow.setWidth(-2);
            holder.popupWindow.setHeight(-2);
            holder.rootView = android.view.LayoutInflater.from(view.getContext()).inflate(com.up366.mobile.R.layout.toast_popup_layout, (android.view.ViewGroup) null);
            final android.view.View view2 = holder.rootView;
            final android.widget.PopupWindow popupWindow = holder.popupWindow;
            final android.widget.ImageView imageView = (android.widget.ImageView) view2.findViewById(2131362563);
            final android.widget.TextView textView = (android.widget.TextView) view2.findViewById(2131363383);
            if (i != 0) {
                imageView.setImageResource(i);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            if (z) {
                imageView.animate().setInterpolator(new android.view.animation.LinearInterpolator()).rotationBy(1296000.0f).setDuration(3600000L).start();
            } else {
                imageView.animate().cancel();
                imageView.setRotation(0.0f);
            }
            textView.setText(str);
            textView.post(new java.lang.Runnable() { // from class: com.up366.mobile.common.utils.ToastPopupUtil$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.mobile.common.utils.ToastPopupUtil.lambda$show$2(textView);
                }
            });
            android.content.Context context = view.getContext();
            int i2 = (int) (context.getResources().getDisplayMetrics().density * 12.0f);
            int i3 = (int) (context.getResources().getDisplayMetrics().density * 20.0f);
            if (i != 0) {
                view2.setBackgroundResource(com.up366.mobile.R.drawable.bg_toast_popup_big);
                view2.setPadding(i3, i3, i3, i3);
                textView.setTextSize(16.0f);
            } else {
                view2.setBackgroundResource(com.up366.mobile.R.drawable.bg_toast_popup_small);
                view2.setPadding(i3, i2, i3, i2);
                textView.setTextSize(14.0f);
            }
            popupWindow.setAnimationStyle(android.R.style.Animation.Toast);
            popupWindow.setBackgroundDrawable(null);
            popupWindow.setContentView(view2);
            popupWindow.setTouchable(false);
            popupWindow.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() { // from class: com.up366.mobile.common.utils.ToastPopupUtil$$ExternalSyntheticLambda7
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    com.up366.mobile.common.utils.ToastPopupUtil.lambda$show$3(imageView);
                }
            });
            android.view.View view3 = weakParentView.get();
            if (isHostViewValid(view3) && !isActivityInvalid(view3.getContext())) {
                view = view3;
            }
            if (!isHostViewValid(view) || isActivityInvalid(view.getContext())) {
                clearPendingHolder(str2, holder, imageView);
                return;
            }
            if (view.getRootView().getWindowToken() == null) {
                clearPendingHolder(str2, holder, imageView);
                return;
            }
            try {
                popupWindow.showAtLocation(view, 17, 0, 0);
                com.up366.common.task.TaskUtils.postLazyTaskMain("dismiss-toast-popup-" + str2, 1, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ToastPopupUtil$$ExternalSyntheticLambda8
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        com.up366.mobile.common.utils.ToastPopupUtil.lambda$show$4();
                    }
                });
                if (z) {
                    return;
                }
                final int i4 = holder.id;
                holder.dismissRunnable = new java.lang.Runnable() { // from class: com.up366.mobile.common.utils.ToastPopupUtil$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.up366.mobile.common.utils.ToastPopupUtil.lambda$show$5(view2, popupWindow, str2, i4);
                    }
                };
                com.up366.common.task.TaskUtils.postLazyTaskMain("dismiss-toast-popup-" + str2, 2300, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.ToastPopupUtil$$ExternalSyntheticLambda1
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        holder.dismissRunnable.run();
                    }
                });
            } catch (java.lang.RuntimeException e2) {
                com.up366.common.log.Logger.error("showAtLocation error", e2);
                clearPendingHolder(str2, holder, imageView);
            }
        }
    }

    static /* synthetic */ void lambda$show$2(android.widget.TextView textView) {
        if (textView.getLayout() == null || textView.getWidth() == 0) {
            textView.setMinLines(0);
        } else {
            textView.setMinLines(textView.getLayout().getLineCount());
        }
    }

    static /* synthetic */ void lambda$show$3(android.widget.ImageView imageView) {
        imageView.animate().cancel();
        imageView.setRotation(0.0f);
    }

    static /* synthetic */ void lambda$show$5(android.view.View view, android.widget.PopupWindow popupWindow, java.lang.String str, int i) {
        boolean zIsAttachedToWindow = view.isAttachedToWindow();
        if (popupWindow.isShowing() && zIsAttachedToWindow) {
            popupWindow.dismiss();
        } else {
            com.up366.common.log.Logger.info("TAG - ToastPopupUtil - auto dismiss - isShowing : " + popupWindow.isShowing() + "  attachedToWindow : " + zIsAttachedToWindow);
        }
        com.up366.mobile.common.utils.ToastPopupUtil.Holder holderRemove = map.remove(str);
        if (holderRemove == null || i == holderRemove.id) {
            return;
        }
        map.put(str, holderRemove);
    }

    public static void clean(android.app.Activity activity) {
        dismiss(activity);
    }

    public static void clean(android.view.View view) {
        dismiss(view);
    }

    public static void setParentView(android.view.View view) {
        weakParentView = new java.lang.ref.WeakReference<>(view);
    }

    public static void clearParentView() {
        weakParentView.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Holder {
        private static int gid;
        java.lang.Runnable dismissRunnable;
        int id;
        android.widget.PopupWindow popupWindow;
        android.view.View rootView;

        private Holder() {
            int i = gid;
            gid = i + 1;
            this.id = i;
        }
    }

    public static void showCustomPopWindow(android.view.View view, int i, int i2, android.view.View view2) {
        if (!isHostViewValid(view) || isActivityInvalid(view.getContext())) {
            return;
        }
        final android.widget.PopupWindow popupWindow = new android.widget.PopupWindow();
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.setAnimationStyle(android.R.style.Animation.Toast);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.setContentView(view2);
        popupWindow.setTouchable(false);
        popupWindow.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() { // from class: com.up366.mobile.common.utils.ToastPopupUtil$$ExternalSyntheticLambda4
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                com.up366.mobile.common.utils.ToastPopupUtil.lambda$showCustomPopWindow$8();
            }
        });
        if (view.getWindowToken() == null) {
            return;
        }
        float f = view.getResources().getDisplayMetrics().density;
        try {
            popupWindow.showAsDropDown(view, (int) (i * f), (int) (i2 * f));
            com.up366.common.task.TaskUtils.postLazyTaskMain("dismiss-toast-popup-" + popupWindow.hashCode(), 3000, new com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda2(new java.lang.Runnable() { // from class: com.up366.mobile.common.utils.ToastPopupUtil$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    popupWindow.dismiss();
                }
            }));
        } catch (java.lang.RuntimeException e) {
            com.up366.common.log.Logger.error("showAsDropDown error", e);
        }
    }
}
