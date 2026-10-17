package com.up366.mobile.common.base;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class USV5ListViewDataController<T> extends com.up366.mobile.common.base.BaseListViewDataController<T> {
    private android.content.Context context;

    static /* synthetic */ void lambda$new$1(java.util.List list) {
    }

    public USV5ListViewDataController(final android.content.Context context) {
        this.context = context;
        this.warnDataCallback = new com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback() { // from class: com.up366.mobile.common.base.USV5ListViewDataController$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback
            public final void setDatas(com.up366.common.http.Response response, java.util.List list) {
                this.f$0.lambda$new$0(context, response, list);
            }
        };
        this.noDataViewCallback = new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.common.base.USV5ListViewDataController$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                com.up366.mobile.common.base.USV5ListViewDataController.lambda$new$1(list);
            }
        };
        this.errorDataCallback = new com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback() { // from class: com.up366.mobile.common.base.USV5ListViewDataController$$ExternalSyntheticLambda7
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback
            public final void setDatas(com.up366.common.http.Response response, java.util.List list) {
                this.f$0.lambda$new$4(context, response, list);
            }
        };
        this.footerDataCallback = new com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback() { // from class: com.up366.mobile.common.base.USV5ListViewDataController$$ExternalSyntheticLambda8
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback
            public final void setDatas(com.up366.common.http.Response response, java.util.List list) {
                this.f$0.lambda$new$5(response, list);
            }
        };
        setLoadingView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.common.base.USV5ListViewDataController$$ExternalSyntheticLambda9
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-2, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setLoading(true).build()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(android.content.Context context, com.up366.common.http.Response response, java.util.List list) {
        if (this.renderInOnLoadWebData && (context instanceof android.app.Activity)) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) context, response);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$4(final android.content.Context context, com.up366.common.http.Response response, java.util.List list) {
        com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder rightBtnListener = new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state4).setRightBtn(context.getString(com.up366.mobile.R.string.click_retry)).setRightBtnListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.base.USV5ListViewDataController$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$2(view);
            }
        });
        if (response.getCode() == -10000 || response.getCode() == -10001 || response.getCode() == -10002) {
            rightBtnListener.setTipMessage(context.getString(com.up366.mobile.R.string.poor_network_state_tip)).setTipImage(com.up366.mobile.R.drawable.bg_empty_state6).setLeftBtn(context.getString(com.up366.mobile.R.string.see_help)).setLeftBtnListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.base.USV5ListViewDataController$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.commonui.LookHelpActivity.openPage(context);
                }
            });
        } else {
            rightBtnListener.setTipMessage(context.getString(com.up366.mobile.R.string.server_error));
        }
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-1, rightBtnListener.build()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(android.view.View view) {
        reload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$5(com.up366.common.http.Response response, java.util.List list) {
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-6, new com.up366.mobile.common.views.RefreshUpView.Data(response, this)));
    }

    public void setErrorViewClickAction(final com.up366.common.callback.ICallbackCode iCallbackCode) {
        this.errorDataCallback = new com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback() { // from class: com.up366.mobile.common.base.USV5ListViewDataController$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback
            public final void setDatas(com.up366.common.http.Response response, java.util.List list) {
                this.f$0.lambda$setErrorViewClickAction$9(iCallbackCode, response, list);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setErrorViewClickAction$9(final com.up366.common.callback.ICallbackCode iCallbackCode, com.up366.common.http.Response response, java.util.List list) {
        com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder rightBtnListener = new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state4).setRightBtn(this.context.getString(com.up366.mobile.R.string.click_retry)).setRightBtnListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.base.USV5ListViewDataController$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                iCallbackCode.onResult(0);
            }
        });
        if (response.getCode() == -10000 || response.getCode() == -10001 || response.getCode() == -10002) {
            rightBtnListener.setTipMessage(this.context.getString(com.up366.mobile.R.string.poor_network_state_tip)).setTipImage(com.up366.mobile.R.drawable.bg_empty_state6).setLeftBtn(this.context.getString(com.up366.mobile.R.string.see_help)).setLeftBtnListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.base.USV5ListViewDataController$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$setErrorViewClickAction$8(view);
                }
            });
        } else {
            rightBtnListener.setTipMessage(this.context.getString(com.up366.mobile.R.string.server_error));
        }
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-1, rightBtnListener.build()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setErrorViewClickAction$8(android.view.View view) {
        com.up366.mobile.commonui.LookHelpActivity.openPage(this.context);
    }
}
