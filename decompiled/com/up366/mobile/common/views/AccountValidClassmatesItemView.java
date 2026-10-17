package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AccountValidClassmatesItemView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.AccountFindActivityValidClassmatesItemLayoutBinding b;

    public AccountValidClassmatesItemView(android.content.Context context) {
        this(context, null);
    }

    public AccountValidClassmatesItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountValidClassmatesItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.AccountFindActivityValidClassmatesItemLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.account_find_activity_valid_classmates_item_layout, this, true);
    }

    public void setData(final com.up366.mobile.common.logic.model.AccountUserInfo accountUserInfo, final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.logic.model.AccountUserInfo> iCallbackCodeInfoObj) {
        this.b.item.setText(accountUserInfo.getRealname());
        this.b.item.setEnabled(accountUserInfo.isCheckedEnable());
        this.b.item.setChecked(accountUserInfo.isChecked());
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.AccountValidClassmatesItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setData$0(accountUserInfo, iCallbackCodeInfoObj, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$0(com.up366.mobile.common.logic.model.AccountUserInfo accountUserInfo, com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, android.view.View view) {
        accountUserInfo.setChecked(!accountUserInfo.isChecked());
        this.b.item.setChecked(accountUserInfo.isChecked());
        iCallbackCodeInfoObj.onResult(0, null, accountUserInfo);
    }
}
