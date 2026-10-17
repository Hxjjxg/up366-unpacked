package com.up366.mobile.common.base;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class BaseActivity extends androidx.appcompat.app.AppCompatActivity {
    private java.lang.Runnable onFinishListener;
    protected long staticEnterTime;
    private boolean staticIsTracking;
    private long staticStartTime;
    protected long staticTotalDuration;
    private boolean hasFinished = false;
    private final java.util.Set<android.content.DialogInterface> dialogs = new java.util.HashSet();
    private boolean isFirstEnter = true;
    protected java.lang.String currentPageName = getClass().getSimpleName();
    protected java.util.Map<java.lang.Class<? extends androidx.fragment.app.Fragment>, androidx.fragment.app.Fragment> fragmentMap = new java.util.HashMap();

    protected void reportEnterEvent() {
    }

    protected boolean shouldRecordEnterPageEvent() {
        return false;
    }

    protected boolean startActivityBeforeCheck() {
        return true;
    }

    public java.lang.String getCurrentPageName() {
        return this.currentPageName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.hasFinished = false;
        com.up366.common.StringUtils.getUt(getClass().toString(), 2345);
        com.up366.mobile.common.utils.PlatformUtils.suitableForHorizontalWideScreen(this);
        com.up366.mobile.common.utils.PermissionUtils.resetRequestPermissionState();
    }

    public void registerDialog(android.content.DialogInterface dialogInterface) {
        this.dialogs.add(dialogInterface);
    }

    public void unRegisterDialog(android.content.DialogInterface dialogInterface) {
        this.dialogs.remove(dialogInterface);
    }

    protected void onDestroy() {
        this.hasFinished = true;
        if (com.up366.common.global.GB.get().getCurrentActivity() == this) {
            com.up366.common.global.GB.get().setCurrentActivity(null);
        }
        com.up366.mobile.common.mask.MaskManager.getMgr().dismissMaskTask();
        java.util.Iterator<android.content.DialogInterface> it = this.dialogs.iterator();
        while (it.hasNext()) {
            it.next().dismiss();
            it.remove();
        }
        com.up366.mobile.common.utils.PermissionUtils.resetRequestPermissionState();
        if (com.up366.mobile.AppStateMonitor.INSTANCE.isForeground() && this.staticIsTracking) {
            this.staticTotalDuration += java.lang.System.currentTimeMillis() - this.staticStartTime;
        }
        reportPageDuration(this.staticTotalDuration);
        super.onDestroy();
    }

    protected void reportPageDuration(long j) {
        com.up366.common.log.Logger.info(this.currentPageName + "Page duration reported: " + j + "ms");
    }

    protected void dismissDialogs() {
        java.util.Iterator<android.content.DialogInterface> it = this.dialogs.iterator();
        while (it.hasNext()) {
            it.next().dismiss();
            it.remove();
        }
    }

    protected void visible(android.view.View... viewArr) {
        com.up366.mobile.common.utils.ViewUtil.visible(viewArr);
    }

    protected void invisible(android.view.View... viewArr) {
        com.up366.mobile.common.utils.ViewUtil.invisible(viewArr);
    }

    protected void gone(android.view.View... viewArr) {
        com.up366.mobile.common.utils.ViewUtil.gone(viewArr);
    }

    protected void enable(android.view.View... viewArr) {
        com.up366.mobile.common.utils.ViewUtil.enable(viewArr);
    }

    protected void disable(android.view.View... viewArr) {
        com.up366.mobile.common.utils.ViewUtil.disable(viewArr);
    }

    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        com.up366.mobile.common.utils.PermissionUtils.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStart() {
        super.onStart();
        com.up366.mobile.common.utils.ViewUtil.clearStateOnStart(hashCode());
        if (this.isFirstEnter) {
            this.staticEnterTime = java.lang.System.currentTimeMillis();
            this.isFirstEnter = false;
            reportEnterEvent();
        }
        if (shouldRecordEnterPageEvent()) {
            com.up366.mobile.common.onlinelog.ActionLogRecord.record((android.app.Activity) this, com.up366.mobile.common.onlinelog.OpLogData.Event.ENTER_PAGE);
        }
        startTimer();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onResume() {
        super.onResume();
        com.up366.common.global.GB.get().setCurrentActivity(this);
        com.up366.mobile.common.utils.PermissionUtils.onResume();
        com.up366.mobile.common.mask.MaskManager.getMgr().handleMask(this);
        com.up366.mobile.common.mask.MaskManager.getMgr().showMaskTask(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onPause() {
        if (isFinishing()) {
            com.up366.mobile.common.utils.ToastPopupUtil.clean((android.app.Activity) this);
        }
        super.onPause();
        if (shouldRecordEnterPageEvent()) {
            com.up366.mobile.common.onlinelog.ActionLogRecord.record((android.app.Activity) this, com.up366.mobile.common.onlinelog.OpLogData.Event.PAUSE_PAGE);
        }
    }

    protected void onStop() {
        super.onStop();
        pauseTimer();
    }

    public void finish() {
        com.up366.mobile.common.mask.MaskHelper.getInst().onFinishHideInputSoft(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.base.BaseActivity$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$finish$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finish$0() throws java.lang.Exception {
        super.finish();
        java.lang.Runnable runnable = this.onFinishListener;
        if (runnable != null) {
            runnable.run();
        }
    }

    protected void setOnFinishListener(java.lang.Runnable runnable) {
        this.onFinishListener = runnable;
    }

    public boolean hasFinished() {
        return this.hasFinished;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        try {
            com.umeng.socialize.UMShareAPI.get(this).onActivityResult(i, i2, intent);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("友盟分享回调异常", e);
        }
    }

    public void onAttachFragment(androidx.fragment.app.Fragment fragment) {
        super.onAttachFragment(fragment);
        this.fragmentMap.put((java.lang.Class<? extends androidx.fragment.app.Fragment>) fragment.getClass(), fragment);
    }

    protected void showFragment(int i, java.lang.Class<? extends androidx.fragment.app.Fragment> cls) {
        androidx.fragment.app.FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        java.util.Iterator<java.lang.Class<? extends androidx.fragment.app.Fragment>> it = this.fragmentMap.keySet().iterator();
        while (it.hasNext()) {
            androidx.fragment.app.Fragment fragment = this.fragmentMap.get(it.next());
            if (fragment != null) {
                fragmentTransactionBeginTransaction.hide(fragment);
            }
        }
        androidx.fragment.app.Fragment fragment2 = this.fragmentMap.get(cls);
        if (fragment2 == null) {
            try {
                androidx.fragment.app.Fragment fragmentNewInstance = cls.newInstance();
                fragmentTransactionBeginTransaction.add(i, fragmentNewInstance);
                this.fragmentMap.put(cls, fragmentNewInstance);
                fragmentTransactionBeginTransaction.show(fragmentNewInstance);
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                return;
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error(e.getMessage(), e);
                com.up366.mobile.common.onlinelog.OpLog.report("ERROR-showFragment", cls.toString(), e);
                return;
            }
        }
        fragmentTransactionBeginTransaction.show(fragment2);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    protected void assertTrue(boolean z) {
        if (z) {
            return;
        }
        com.up366.mobile.common.onlinelog.OpLog.report("ERROR-assertTrue", "状态错误！！！", new java.lang.IllegalStateException());
        throw new java.lang.IllegalStateException("状态错误！！！");
    }

    public boolean dispatchTouchEvent(final android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            com.up366.mobile.common.onlinelog.ActionLogRecord.recordActionDown(motionEvent);
            com.up366.mobile.common.views.ListItemDragLayout.resetState(motionEvent);
        }
        if (motionEvent.getAction() == 1) {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.base.BaseActivity$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$dispatchTouchEvent$1(motionEvent);
                }
            });
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatchTouchEvent$1(android.view.MotionEvent motionEvent) throws java.lang.Exception {
        com.up366.mobile.common.onlinelog.ActionLogRecord.record(getWindow(), motionEvent);
    }

    public void startActivity(final android.content.Intent intent, final android.os.Bundle bundle) {
        if (startActivityBeforeCheck() && needCheck(intent)) {
            com.up366.mobile.common.utils.ViewUtil.checkAndPost(hashCode(), new java.lang.Runnable() { // from class: com.up366.mobile.common.base.BaseActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startActivity$2(intent, bundle);
                }
            });
        } else {
            lambda$startActivity$2(intent, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: safeStartActivity, reason: merged with bridge method [inline-methods] */
    public void lambda$startActivity$2(android.content.Intent intent, android.os.Bundle bundle) {
        if (intent == null) {
            com.up366.common.log.Logger.warn("TAG - BaseActivity - startActivity - intent is null");
            return;
        }
        try {
            if (intent.resolveActivity(getPackageManager()) != null) {
                super.startActivity(intent, bundle);
            } else {
                onStartActivityFailed(intent, null);
            }
        } catch (android.content.ActivityNotFoundException e) {
            onStartActivityFailed(intent, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onStartActivityFailed(android.content.Intent intent, java.lang.Throwable th) {
        android.content.ComponentName component = intent.getComponent();
        java.lang.String str = "TAG - BaseActivity - startActivity failed, component=" + (component == null ? "" : component.flattenToShortString()) + ", intent=" + intent;
        if (th == null) {
            com.up366.common.log.Logger.warn(str + ", resolveActivity is null");
        } else {
            com.up366.common.log.Logger.error(str, th);
        }
        com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "页面打开失败，请稍后重试");
    }

    private boolean needCheck(android.content.Intent intent) {
        try {
            android.content.ComponentName component = intent.getComponent();
            if (component == null) {
                return true;
            }
            java.lang.String className = component.getClassName();
            if (className.startsWith("com.alipay.android")) {
                return false;
            }
            return !className.startsWith("com.tencent.mm");
        } catch (java.lang.Exception unused) {
            return true;
        }
    }

    private void startTimer() {
        if (this.staticIsTracking) {
            return;
        }
        this.staticStartTime = java.lang.System.currentTimeMillis();
        this.staticIsTracking = true;
    }

    private void pauseTimer() {
        if (this.staticIsTracking) {
            this.staticTotalDuration += java.lang.System.currentTimeMillis() - this.staticStartTime;
            this.staticIsTracking = false;
        }
    }
}
