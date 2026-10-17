package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AccountCityItemView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.AccountCityItemViewLayoutBinding b;

    public AccountCityItemView(android.content.Context context) {
        this(context, null);
    }

    public AccountCityItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountCityItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.AccountCityItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.account_city_item_view_layout, this, true);
    }

    public void setData(final com.up366.mobile.common.logic.model.AccountCityInfo accountCityInfo, final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.logic.model.AccountCityInfo> iCallbackCodeInfoObj) {
        this.b.text.setText(accountCityInfo.getCityName());
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.AccountCityItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.common.views.AccountCityItemView.lambda$setData$0(accountCityInfo, iCallbackCodeInfoObj, view);
            }
        });
    }

    static /* synthetic */ void lambda$setData$0(com.up366.mobile.common.logic.model.AccountCityInfo accountCityInfo, com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, android.view.View view) {
        com.up366.common.log.Logger.info("TAG - AccountCityItemView - click - " + accountCityInfo);
        iCallbackCodeInfoObj.onResult(0, null, accountCityInfo);
    }
}
