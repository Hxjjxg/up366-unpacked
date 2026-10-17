package com.up366.mobile.common.mask;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface IMaskManager {

    public interface ICallBack {
        void onFinished();
    }

    void addMaskView(android.app.Activity activity);

    void closeMask(android.app.Activity activity, com.up366.mobile.common.mask.IMaskManager.ICallBack iCallBack);

    void dismissMask();

    void dismissMaskOnBackGround();

    void dismissMaskTask();

    void handleMask(android.app.Activity activity);

    void openMask(android.app.Activity activity, com.up366.mobile.common.mask.IMaskManager.ICallBack iCallBack);

    void showMaskTask(android.app.Activity activity);
}
