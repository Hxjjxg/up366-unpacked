package com.up366.mobile.user.account.voice;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class VoiceRecordActivity extends com.up366.mobile.common.base.BaseActivity {
    public static final int TYPE_CHECK = 3;
    public static final int TYPE_CHECK_RECORD = 2;
    public static final int TYPE_RECORD = 1;
    private com.up366.mobile.databinding.VoiceRecordLayoutBinding b;
    private int type = 1;
    private java.lang.String[] sentences = {"Claire thought it was ridiculous that she was being offered sympathy by a robot, but she gradually admired his wisdom and integrity and began to trust him. ", "He suggested that she invite Gladys and her friends to the house the night before he was to leave and Larry was to return. ", "The guests would be arriving soon, so Claire dismissed Tony for the rest of the night. ", "She heard him declare that he did not want to leave her the next day, and that he felt more than just the desire to please her. ", "Tomorrow night came, then skipped to day, again and again, faster and faster still. ", "I had a strong urge to look at the random things that were being flashed before my eyes! "};

    public static void openPage(android.app.Activity activity, int i) {
        android.content.Intent intent = new android.content.Intent(activity.getIntent());
        intent.setClass(activity, com.up366.mobile.user.account.voice.VoiceRecordActivity.class);
        intent.putExtra("type", i);
        activity.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.b = (com.up366.mobile.databinding.VoiceRecordLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.voice_record_layout);
        int intExtra = getIntent().getIntExtra("type", 1);
        this.type = intExtra;
        if (intExtra != 3) {
            gone(this.b.tipBg, this.b.tipMessage, this.b.tipUsername);
        } else {
            this.b.tipUsername.setText(java.lang.String.format("账号：%s", com.up366.mobile.common.logic.Auth.getUserInfo().getUsername()));
            visible(this.b.tipBg, this.b.tipMessage, this.b.tipUsername);
        }
        java.lang.String str = this.sentences[new java.util.Random().nextInt(6)];
        this.b.content.setText(str);
        this.b.record.setAudioRecord(new com.up366.mobile.user.account.voice.AudioRecordHelper(this), this.type, new androidx.core.util.Consumer() { // from class: com.up366.mobile.user.account.voice.VoiceRecordActivity$$ExternalSyntheticLambda0
            public final void accept(java.lang.Object obj) {
                this.f$0.lambda$onCreate$0((com.up366.mobile.common.utils.ParamHolder2) obj);
            }
        }, str);
        final com.up366.mobile.common.helper.AppResourceUpdateHelper appResourceUpdateHelper = com.up366.mobile.common.helper.AppResourceUpdateHelper.getInstance();
        appResourceUpdateHelper.post(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.voice.VoiceRecordActivity$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onCreate$1(appResourceUpdateHelper);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0(com.up366.mobile.common.utils.ParamHolder2 paramHolder2) {
        if (((com.up366.common.http.Response) paramHolder2.a).isError()) {
            return;
        }
        java.lang.String str = (java.lang.String) paramHolder2.b;
        if (this.type == 3 && str != null) {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(str);
            if (object != null) {
                if (object.getBoolean("passed").booleanValue()) {
                    com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.RecordSuccessEvent(2));
                    finish();
                    return;
                } else {
                    com.up366.mobile.common.utils.ToastPopupUtil.showError(this.b.record, "声纹验证不通过");
                    return;
                }
            }
            return;
        }
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.RecordSuccessEvent(1));
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.RecordCloseSetEvent());
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("record_status_update").invalid();
        if (this.type == 1) {
            com.up366.mobile.user.account.voice.VoiceSettedActivity.openPage(this);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$1(com.up366.mobile.common.helper.AppResourceUpdateHelper appResourceUpdateHelper) throws java.lang.Exception {
        if (appResourceUpdateHelper.checkResourceAses() && !appResourceUpdateHelper.checkUpdateAses() && appResourceUpdateHelper.checkValidAses()) {
            return;
        }
        com.up366.mobile.main.AppResourceUpdateActivity.open(this, 1);
    }
}
