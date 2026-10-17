package com.up366.mobile.user.account.switchaccount;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SwitchAccountItemView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.SwitchAccountUserItemViewLayoutBinding b;
    private com.up366.mobile.user.account.switchaccount.SwitchAccountData data;

    static /* synthetic */ void lambda$new$0(android.view.View view) {
    }

    public SwitchAccountItemView(android.content.Context context) {
        this(context, null);
    }

    public SwitchAccountItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchAccountItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.up366.mobile.databinding.SwitchAccountUserItemViewLayoutBinding switchAccountUserItemViewLayoutBinding = (com.up366.mobile.databinding.SwitchAccountUserItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.switch_account_user_item_view_layout, this, true);
        this.b = switchAccountUserItemViewLayoutBinding;
        switchAccountUserItemViewLayoutBinding.clearBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.switchaccount.SwitchAccountItemView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$2(view);
            }
        });
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.switchaccount.SwitchAccountItemView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(android.view.View view) {
        com.up366.mobile.common.dialog.AppDialog.create(getContext()).title("提示").message("删除" + this.data.getRealName() + "的登录记录？").setBtnCloseVisibility(4).left("取消", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.switchaccount.SwitchAccountItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                com.up366.mobile.user.account.switchaccount.SwitchAccountItemView.lambda$new$0(view2);
            }
        }).right("确定", new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.switchaccount.SwitchAccountItemView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view2) {
                this.f$0.lambda$new$1(view2);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(android.view.View view) {
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SwitchAccountDeleteEvent(this.data));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(android.view.View view) {
        if (this.data.getIsEditing()) {
            return;
        }
        if (this.data.isCurrentUser()) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.FinishSwitchAccountActivityEvent());
        } else {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SwitchLoginEvent(this.data));
        }
    }

    public void setData(com.up366.mobile.user.account.switchaccount.SwitchAccountData switchAccountData) {
        this.data = switchAccountData;
        com.up366.common.BitmapUtilsUp.display(this.b.userPhoto, switchAccountData.getUserPhoto(), com.up366.mobile.R.drawable.default_photo);
        this.b.mask.setVisibility((switchAccountData.isCurrentUser() && switchAccountData.getIsEditing()) ? 0 : 8);
        this.b.curUse.setVisibility(switchAccountData.isCurrentUser() ? 0 : 8);
        this.b.userName.setText(switchAccountData.getUserName());
        this.b.realName.setText(switchAccountData.getRealName());
        this.b.clearBtn.setVisibility((switchAccountData.isCurrentUser() || !switchAccountData.getIsEditing()) ? 8 : 0);
    }
}
