package com.up366.mobile.user.account.voice;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class VoiceSetActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.VoiceSetLayoutBinding b;

    public static void openPage(android.app.Activity activity) {
        android.content.Intent intent = new android.content.Intent(activity.getIntent());
        intent.setClass(activity, com.up366.mobile.user.account.voice.VoiceSetActivity.class);
        activity.startActivity(intent);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.b = (com.up366.mobile.databinding.VoiceSetLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.voice_set_layout);
        com.up366.common.EventBusUtilsUp.register(this);
        this.b.btnRecord.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.voice.VoiceSetActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$2(android.view.View view) {
        com.up366.mobile.common.dialog.TwoBtnDialog.create(this).title("声纹采集（考试前录入)").message(getString(com.up366.mobile.R.string.voice_message)).left("不同意", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.voice.VoiceSetActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                this.f$0.lambda$onCreate$0(view2);
            }
        }).right("我已知晓并同意", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.voice.VoiceSetActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                this.f$0.lambda$onCreate$1(view2);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(android.view.View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(android.view.View view) {
        com.up366.mobile.user.account.voice.VoiceRecordActivity.openPage(this, 1);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.RecordCloseSetEvent recordCloseSetEvent) {
        finish();
    }
}
