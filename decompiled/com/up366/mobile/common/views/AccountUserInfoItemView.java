package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AccountUserInfoItemView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.AccountUserinfoItemViewLayoutBinding b;

    public AccountUserInfoItemView(android.content.Context context) {
        this(context, null);
    }

    public AccountUserInfoItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountUserInfoItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.AccountUserinfoItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.account_userinfo_item_view_layout, this, true);
    }

    public void setData(final com.up366.mobile.common.logic.model.AccountUserInfo accountUserInfo, java.lang.String str, final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.logic.model.AccountUserInfo> iCallbackCodeInfoObj) {
        this.b.username.setText(java.lang.String.format("账号：%s", accountUserInfo.getUsername()));
        this.b.nameAndOrgan.setText(java.lang.String.format("%s %s", accountUserInfo.getRealname(), str));
        this.b.btnCopy.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.AccountUserInfoItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setData$0(accountUserInfo, view);
            }
        });
        this.b.btnLogin.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.AccountUserInfoItemView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                iCallbackCodeInfoObj.onResult(0, null, accountUserInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$0(com.up366.mobile.common.logic.model.AccountUserInfo accountUserInfo, android.view.View view) {
        copyToClipboard(accountUserInfo.getUsername());
    }

    private void copyToClipboard(java.lang.String str) {
        android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) getContext().getSystemService("clipboard");
        android.content.ClipData clipDataNewPlainText = android.content.ClipData.newPlainText("text", str.trim());
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(this, "账号复制成功");
    }
}
