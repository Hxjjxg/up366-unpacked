package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AccountSelectClassItemView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.AccountSelectClassItemViewLayoutBinding b;

    public AccountSelectClassItemView(android.content.Context context) {
        this(context, null);
    }

    public AccountSelectClassItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountSelectClassItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.AccountSelectClassItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.account_select_class_item_view_layout, this, true);
    }

    public void setData(final com.up366.mobile.common.logic.model.AccountClassInfo accountClassInfo, final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.logic.model.AccountClassInfo> iCallbackCodeInfoObj) {
        this.b.text.setText(accountClassInfo.getClassName());
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.AccountSelectClassItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.common.views.AccountSelectClassItemView.lambda$setData$0(accountClassInfo, iCallbackCodeInfoObj, view);
            }
        });
    }

    static /* synthetic */ void lambda$setData$0(com.up366.mobile.common.logic.model.AccountClassInfo accountClassInfo, com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, android.view.View view) {
        com.up366.common.log.Logger.info("TAG - AccountSelectClassItemView - click - " + accountClassInfo);
        iCallbackCodeInfoObj.onResult(0, null, accountClassInfo);
    }
}
