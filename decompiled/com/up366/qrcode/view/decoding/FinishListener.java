package com.up366.qrcode.view.decoding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class FinishListener implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnCancelListener, java.lang.Runnable {
    private final android.app.Activity activityToFinish;

    public FinishListener(android.app.Activity activity) {
        this.activityToFinish = activity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(android.content.DialogInterface dialogInterface) {
        run();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        run();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.activityToFinish.finish();
    }
}
