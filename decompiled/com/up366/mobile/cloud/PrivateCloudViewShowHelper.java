package com.up366.mobile.cloud;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PrivateCloudViewShowHelper {
    private android.widget.ImageView imageView;
    private long lastPrivateCloudToastTime;
    private androidx.lifecycle.Lifecycle lifecycle;
    private java.util.LinkedList<java.lang.Long> retryTime = new java.util.LinkedList<>();

    public void setPrivateCloudState(com.up366.mobile.common.event.PrivateCloudCheckEvent privateCloudCheckEvent) {
    }

    public PrivateCloudViewShowHelper(android.widget.ImageView imageView, androidx.lifecycle.Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    private void statisticsPrivateCloudRetryTime() {
        if (this.retryTime.size() > 4 && (this.retryTime.get(0).longValue() - this.retryTime.get(1).longValue()) + (this.retryTime.get(1).longValue() - this.retryTime.get(2).longValue()) + (this.retryTime.get(2).longValue() - this.retryTime.get(3).longValue()) + (this.retryTime.get(3).longValue() - this.retryTime.get(4).longValue()) < com.igexin.push.config.c.l && java.lang.System.currentTimeMillis() - this.retryTime.get(0).longValue() < com.igexin.push.config.c.l) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(this.imageView, "操作太频繁\n2分钟后再试");
            return;
        }
        final com.up366.mobile.common.dialog.AppDialog appDialogCreate = com.up366.mobile.common.dialog.AppDialog.create(this.imageView.getContext());
        appDialogCreate.title("校内极速模式连接失败\n请稍后重试");
        java.lang.String onServer = com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().getOnServer();
        if (onServer != null) {
            appDialogCreate.message(onServer);
        }
        appDialogCreate.left(this.imageView.getContext().getString(com.up366.mobile.R.string.back), new android.view.View.OnClickListener() { // from class: com.up366.mobile.cloud.PrivateCloudViewShowHelper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                appDialogCreate.dismiss();
            }
        }).right("重试", new android.view.View.OnClickListener() { // from class: com.up366.mobile.cloud.PrivateCloudViewShowHelper$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$statisticsPrivateCloudRetryTime$1(view);
            }
        }).setCancelable(false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$statisticsPrivateCloudRetryTime$1(android.view.View view) {
        this.retryTime.addFirst(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().startPrivateCloudModel(null);
    }
}
