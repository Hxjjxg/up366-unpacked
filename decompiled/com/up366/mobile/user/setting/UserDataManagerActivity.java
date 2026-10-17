package com.up366.mobile.user.setting;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class UserDataManagerActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.ActivityUserDataManagerLayoutBinding b;
    private boolean blockTouchEvent;

    static /* synthetic */ void lambda$onCreate$4(android.view.View view) {
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_setting_personal";
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.mobile.databinding.ActivityUserDataManagerLayoutBinding activityUserDataManagerLayoutBindingInflate = com.up366.mobile.databinding.ActivityUserDataManagerLayoutBinding.inflate(getLayoutInflater());
        this.b = activityUserDataManagerLayoutBindingInflate;
        setContentView(activityUserDataManagerLayoutBindingInflate.getRoot());
        this.b.btnDelete.setEnabled(false);
        android.widget.CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new android.widget.CompoundButton.OnCheckedChangeListener() { // from class: com.up366.mobile.user.setting.UserDataManagerActivity$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
                this.f$0.lambda$onCreate$0(compoundButton, z);
            }
        };
        this.b.read.setOnCheckedChangeListener(onCheckedChangeListener);
        this.b.write.setOnCheckedChangeListener(onCheckedChangeListener);
        this.b.video.setOnCheckedChangeListener(onCheckedChangeListener);
        this.b.voice.setOnCheckedChangeListener(onCheckedChangeListener);
        this.b.btnDelete.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserDataManagerActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$5(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(android.widget.CompoundButton compoundButton, boolean z) {
        if (this.b.read.isChecked() || this.b.write.isChecked() || this.b.video.isChecked() || this.b.voice.isChecked()) {
            this.b.btnDelete.setEnabled(true);
        } else {
            this.b.btnDelete.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$5(final android.view.View view) {
        com.up366.mobile.common.dialog.AppDialog.create(this).title("提示").message("确认删除后，将清除您在平台储存的\n所有个人信息(在班级中的除外)下\n次使用时，将重新存储", 17).setBtnCloseVisibility(8).exchange().left("确认", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserDataManagerActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                this.f$0.lambda$onCreate$3(view, view2);
            }
        }).right("取消", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.UserDataManagerActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                com.up366.mobile.user.setting.UserDataManagerActivity.lambda$onCreate$4(view2);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(final android.view.View view, android.view.View view2) {
        this.blockTouchEvent = true;
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(view, "删除中");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.setting.UserDataManagerActivity$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onCreate$2(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(final android.view.View view) throws java.lang.Exception {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (this.b.read.isChecked()) {
            arrayList.add("1");
        }
        if (this.b.write.isChecked()) {
            arrayList.add("2");
        }
        if (this.b.video.isChecked()) {
            arrayList.add("3");
        }
        if (this.b.voice.isChecked()) {
            arrayList.add("5");
        }
        final com.up366.common.http.NetHolder<java.lang.Object> netHolderCleanUserData = com.up366.mobile.common.logic.Auth.cur().info().cleanUserData(arrayList);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.user.setting.UserDataManagerActivity$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onCreate$1(netHolderCleanUserData, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(com.up366.common.http.NetHolder netHolder, android.view.View view) throws java.lang.Exception {
        this.blockTouchEvent = false;
        com.up366.common.log.Logger.info("TAG - UserDataManagerActivity - onCreate - " + netHolder.resp);
        if (netHolder.resp.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showError(view, netHolder.resp.getInfo());
            return;
        }
        this.b.read.setChecked(false);
        this.b.write.setChecked(false);
        this.b.video.setChecked(false);
        this.b.voice.setChecked(false);
        com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(view, "删除中，将会在48小时内清理完成");
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.blockTouchEvent && motionEvent.getAction() == 0) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public static void start(android.content.Context context) {
        context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.user.setting.UserDataManagerActivity.class));
    }
}
