package com.up366.mobile.common.base;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BaseFragment extends androidx.fragment.app.Fragment {
    protected android.app.ProgressDialog progressDialog = null;

    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.StringUtils.getUt(getClass().toString(), 2345);
    }

    protected void dismissProgressDialog() {
        android.app.ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }
        this.progressDialog.dismiss();
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

    public void onResume() {
        super.onResume();
        com.up366.mobile.common.onlinelog.ActionLogRecord.addModelPath(getView(), getClass().getName());
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        com.up366.mobile.common.onlinelog.ActionLogRecord.removeModelPath(getView());
    }

    public void startActivity(final android.content.Intent intent, final android.os.Bundle bundle) {
        if (getActivity() == null) {
            com.up366.common.log.Logger.error("startActivity error, getActivity is null" + intent.toString());
            return;
        }
        com.up366.mobile.common.utils.ViewUtil.checkAndPost(hashCode(), new java.lang.Runnable() { // from class: com.up366.mobile.common.base.BaseFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startActivity$0(intent, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startActivity$0(android.content.Intent intent, android.os.Bundle bundle) {
        super.startActivity(intent, bundle);
    }

    public void startActivityForResult(final android.content.Intent intent, final int i, final android.os.Bundle bundle) {
        if (getActivity() == null) {
            com.up366.common.log.Logger.error("startActivity error, getActivity is null" + intent.toString());
            return;
        }
        com.up366.mobile.common.utils.ViewUtil.checkAndPost(hashCode(), new java.lang.Runnable() { // from class: com.up366.mobile.common.base.BaseFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$startActivityForResult$1(intent, i, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startActivityForResult$1(android.content.Intent intent, int i, android.os.Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }
}
