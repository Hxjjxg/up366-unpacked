package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AccountLocationItemView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.AccountCityLocationItemViewLayoutBinding b;

    public AccountLocationItemView(android.content.Context context) {
        this(context, null);
    }

    public AccountLocationItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountLocationItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.AccountCityLocationItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.account_city_location_item_view_layout, this, true);
    }

    private com.up366.mobile.common.logic.model.AccountCityInfo getCityInfoFromList(java.util.List<com.up366.mobile.common.logic.model.AccountCityInfo> list, com.up366.mobile.common.logic.model.AccountCityInfo accountCityInfo) {
        if (accountCityInfo == null) {
            return null;
        }
        for (com.up366.mobile.common.logic.model.AccountCityInfo accountCityInfo2 : list) {
            if (accountCityInfo2.getCityId().equals(accountCityInfo.getCityId())) {
                return accountCityInfo2;
            }
        }
        for (com.up366.mobile.common.logic.model.AccountCityInfo accountCityInfo3 : list) {
            if (!accountCityInfo3.getCityName().equals(accountCityInfo.getCityName())) {
                if (accountCityInfo3.getCityName().equals(accountCityInfo.getCityName() + "市")) {
                }
            }
            return accountCityInfo3;
        }
        return null;
    }

    public void setData(final int i, final java.util.List<com.up366.mobile.common.logic.model.AccountCityInfo> list, final com.up366.mobile.common.logic.model.AccountCityInfo accountCityInfo, final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.logic.model.AccountCityInfo> iCallbackCodeInfoObj, final com.up366.common.callback.ICallbackCode iCallbackCode) {
        this.b.reLocation.setVisibility(0);
        this.b.reLocationIv.setVisibility(8);
        this.b.reLocation.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.AccountLocationItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setData$0(iCallbackCode, view);
            }
        });
        if (accountCityInfo == null) {
            this.b.text.setText("未获取到位置");
            setOnClickListener(null);
        } else {
            this.b.text.setText(accountCityInfo.getCityName());
            setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.AccountLocationItemView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$setData$1(list, accountCityInfo, i, iCallbackCodeInfoObj, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$0(com.up366.common.callback.ICallbackCode iCallbackCode, android.view.View view) {
        this.b.reLocation.setVisibility(8);
        this.b.reLocationIv.setVisibility(0);
        this.b.reLocationIv.animate().setInterpolator(new android.view.animation.LinearInterpolator()).rotationBy(1296000.0f).setDuration(3600000L).start();
        iCallbackCode.onResult(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$1(java.util.List list, com.up366.mobile.common.logic.model.AccountCityInfo accountCityInfo, int i, com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, android.view.View view) {
        com.up366.mobile.common.logic.model.AccountCityInfo cityInfoFromList = getCityInfoFromList(list, accountCityInfo);
        if (cityInfoFromList != null) {
            iCallbackCodeInfoObj.onResult(1, null, cityInfoFromList);
        } else if (i == 1) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this, "该城市暂不支持哦~");
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this, "当前城市暂时无法使用找回\n账号功能");
        }
    }
}
