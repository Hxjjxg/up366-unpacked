package com.up366.mobile.user.account.voice;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class VoiceSettedActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.VoiceSettedLayoutBinding b;
    private int type;

    static /* synthetic */ void lambda$onCreate$2(android.view.View view) {
    }

    public static void openPage(android.app.Activity activity) {
        android.content.Intent intent = new android.content.Intent(activity.getIntent());
        intent.setClass(activity, com.up366.mobile.user.account.voice.VoiceSettedActivity.class);
        activity.startActivity(intent);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.b = (com.up366.mobile.databinding.VoiceSettedLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.voice_setted_layout);
        com.up366.common.EventBusUtilsUp.register(this);
        this.b.btnReRecord.setRightText("上次录制 " + com.up366.common.TimeUtils.formatTime(com.up366.mobile.common.logic.Auth.getUserInfo().getRecordTime(), "yyyy.MM.dd"));
        this.b.btnReRecord.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.voice.VoiceSettedActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
        this.b.btnCheck.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.voice.VoiceSettedActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.b.btnDelete.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.voice.VoiceSettedActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$6(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(android.view.View view) {
        com.up366.mobile.user.account.voice.VoiceRecordActivity.openPage(this, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(android.view.View view) {
        com.up366.mobile.user.account.voice.VoiceRecordActivity.openPage(this, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$6(android.view.View view) {
        com.up366.mobile.common.dialog.AppDialog.create(this).title("确认删除声纹吗？").left(getString(com.up366.mobile.R.string.cancel), new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.voice.VoiceSettedActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                com.up366.mobile.user.account.voice.VoiceSettedActivity.lambda$onCreate$2(view2);
            }
        }).setBtnCloseVisibility(8).right(getString(com.up366.mobile.R.string.confirm), new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.voice.VoiceSettedActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                this.f$0.lambda$onCreate$5(view2);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(android.view.View view) {
        final java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add("5");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.voice.VoiceSettedActivity$$ExternalSyntheticLambda8
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onCreate$4(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(java.util.List list) throws java.lang.Exception {
        final com.up366.common.http.NetHolder<java.lang.Object> netHolderCleanUserData = com.up366.mobile.common.logic.Auth.cur().info().cleanUserData(list);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.voice.VoiceSettedActivity$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onCreate$3(netHolderCleanUserData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$3(com.up366.common.http.NetHolder netHolder) throws java.lang.Exception {
        if (netHolder.resp.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, "声纹删除失败");
            return;
        }
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("record_status_update").invalid();
        com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) this, "声纹删除成功");
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("VoiceSettedActivity", "record_status_update").run(new java.lang.Runnable() { // from class: com.up366.mobile.user.account.voice.VoiceSettedActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onResume$8();
            }
        });
        int i = this.type;
        if (i == 2) {
            com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) this, "声纹验证成功");
        } else if (i == 1) {
            com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) this, "录制成功");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$8() {
        com.up366.mobile.common.logic.Auth.cur().info().fetchPersonInfo(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.voice.VoiceSettedActivity$$ExternalSyntheticLambda1
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$onResume$7(response, (java.lang.String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onResume$7(com.up366.common.http.Response response, java.lang.String str) {
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, response);
            return;
        }
        this.b.btnReRecord.setRightText("上次录制 " + com.up366.common.TimeUtils.formatTime(com.up366.mobile.common.logic.Auth.getUserInfo().getRecordTime(), "yyyy.MM.dd"));
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.RecordSuccessEvent recordSuccessEvent) {
        this.type = recordSuccessEvent.getType();
    }
}
