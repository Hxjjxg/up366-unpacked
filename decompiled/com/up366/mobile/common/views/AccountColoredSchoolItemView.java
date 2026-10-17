package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AccountColoredSchoolItemView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.AccountColoredSchoolItemViewLayoutBinding b;

    public AccountColoredSchoolItemView(android.content.Context context) {
        this(context, null);
    }

    public AccountColoredSchoolItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountColoredSchoolItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.AccountColoredSchoolItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.account_colored_school_item_view_layout, this, true);
    }

    public void setData(final com.up366.mobile.common.logic.model.AccountOrganInfo accountOrganInfo, java.lang.String str, final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.logic.model.AccountOrganInfo> iCallbackCodeInfoObj) {
        this.b.text.setText(accountOrganInfo.buildColorString(getContext(), str));
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.AccountColoredSchoolItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.common.views.AccountColoredSchoolItemView.lambda$setData$0(accountOrganInfo, iCallbackCodeInfoObj, view);
            }
        });
    }

    static /* synthetic */ void lambda$setData$0(com.up366.mobile.common.logic.model.AccountOrganInfo accountOrganInfo, com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, android.view.View view) {
        com.up366.common.log.Logger.info("TAG - AccountCityItemView - click - " + accountOrganInfo);
        iCallbackCodeInfoObj.onResult(0, null, accountOrganInfo);
    }
}
