package com.up366.mobile.user.account.switchaccount;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SwitchAccountAddItemView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.SwitchAccountAddItemViewLayoutBinding b;

    public SwitchAccountAddItemView(android.content.Context context) {
        this(context, null);
    }

    public SwitchAccountAddItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchAccountAddItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.SwitchAccountAddItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.switch_account_add_item_view_layout, this, true);
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.switchaccount.SwitchAccountAddItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(android.view.View view) {
        com.up366.mobile.user.account.login.AccountLoginActivity.open(getContext(), true, "");
    }
}
