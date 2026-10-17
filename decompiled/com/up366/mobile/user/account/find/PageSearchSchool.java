package com.up366.mobile.user.account.find;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageSearchSchool {
    private final android.app.Activity activity;
    private com.up366.mobile.user.account.find.PageSearchSchool.Adapter adapter;
    private final com.up366.mobile.databinding.AccountFindActivitySearchSchoolLayoutBinding b;
    private final java.lang.String cityId;
    private final java.lang.String cityName;
    private final java.lang.Runnable closeAll;
    private final com.up366.mobile.user.account.find.AccountFindActivity.Config config;
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.common.logic.model.AccountOrganInfo> controller;

    static /* synthetic */ void lambda$new$0() {
    }

    public PageSearchSchool(android.app.Activity activity, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView, final com.up366.mobile.common.views.TitleCloseGroupTextView titleCloseGroupTextView, com.up366.mobile.user.account.find.AccountFindActivity.Config config) {
        this.activity = activity;
        this.config = config;
        titleCloseGroupTextView.setOnCloseListener(new com.up366.mobile.common.views.TitleCloseGroupTextView.IOnCloseListener() { // from class: com.up366.mobile.user.account.find.PageSearchSchool$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.views.TitleCloseGroupTextView.IOnCloseListener
            public final void onClose() {
                com.up366.mobile.user.account.find.PageSearchSchool.lambda$new$0();
            }
        });
        this.cityId = config.cityId;
        this.cityName = config.cityName;
        collapsingToolbarLayout.setTitle("搜索你的学校");
        textView.setText(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("01").setSpan(new android.text.style.ForegroundColorSpan(activity.getResources().getColor(com.up366.mobile.R.color.c1))).append("/04").build());
        com.up366.mobile.databinding.AccountFindActivitySearchSchoolLayoutBinding accountFindActivitySearchSchoolLayoutBinding = (com.up366.mobile.databinding.AccountFindActivitySearchSchoolLayoutBinding) androidx.databinding.DataBindingUtil.inflate(activity.getLayoutInflater(), com.up366.mobile.R.layout.account_find_activity_search_school_layout, frameLayout, true);
        this.b = accountFindActivitySearchSchoolLayoutBinding;
        collapsingToolbarLayout.setExpandedTitleMarginStart(accountFindActivitySearchSchoolLayoutBinding.edit.getPaddingLeft());
        initView(activity, appBarLayout);
        if (config.type == 1) {
            titleCloseGroupTextView.setVisibility(4);
            textView.setVisibility(4);
        }
        java.util.Objects.requireNonNull(titleCloseGroupTextView);
        this.closeAll = new java.lang.Runnable() { // from class: com.up366.mobile.user.account.find.PageSearchSchool$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                titleCloseGroupTextView.callOnClick();
            }
        };
        initController();
    }

    private void initView(final android.app.Activity activity, com.google.android.material.appbar.AppBarLayout appBarLayout) {
        this.controller = new com.up366.mobile.common.base.USV5ListViewDataController<>(activity);
        this.adapter = new com.up366.mobile.user.account.find.PageSearchSchool.Adapter(activity, this.config);
        this.b.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(activity));
        this.b.recycleView.setAdapter(this.adapter);
        this.b.recycleView.addItemDecoration(new com.up366.mobile.user.account.find.SelectCityFloatTitleItemDecoration());
        this.b.edit.setOnEditActionListener(new com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener() { // from class: com.up366.mobile.user.account.find.PageSearchSchool$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener
            public final void onSearch(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$1(activity, appEditTextView);
            }
        });
        this.b.edit.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.find.PageSearchSchool$$ExternalSyntheticLambda7
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$2(appEditTextView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(android.app.Activity activity, com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "正在加载");
        this.controller.loadWebData();
        com.up366.mobile.common.utils.ViewUtil.hideSoftInput(this.b.edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        if (this.b.edit.getTrimText().length() == 0 && this.controller.hasLoadedWebData()) {
            this.controller.refresh();
        }
    }

    private void initController() {
        this.controller.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.user.account.find.PageSearchSchool$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state7).setTipMessage("暂未找到该学校").build()));
            }
        });
        this.controller.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.user.account.find.PageSearchSchool$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                this.f$0.lambda$initController$5();
            }
        });
        this.controller.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.user.account.find.PageSearchSchool$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                this.f$0.lambda$initController$6(list, list2);
            }
        });
        this.controller.setAdapter(this.adapter);
        this.controller.setOnCompleteCallback(new com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback() { // from class: com.up366.mobile.user.account.find.PageSearchSchool$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback
            public final void onComplete() {
                this.f$0.lambda$initController$7();
            }
        });
        this.controller.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$5() throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.mgr().fetchAccountOrganList(this.config.type != 1 ? 0 : 1, this.cityId, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.find.PageSearchSchool$$ExternalSyntheticLambda9
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$initController$4(response, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$4(com.up366.common.http.Response response, java.util.List list) {
        com.up366.common.log.Logger.info("TAG - PageSearchSchool - onResult - isError : " + response.isError());
        filterOrganList(this.b.edit.getTrimText(), list);
        this.controller.onLoadWebData(response, (java.util.List<com.up366.mobile.common.logic.model.AccountOrganInfo>) list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$6(java.util.List list, java.util.List list2) {
        if (this.b.edit.getTrimText().length() == 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, (com.up366.mobile.common.logic.model.AccountOrganInfo) list.get(i)));
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_DIVIDER_LINE_37DP, java.lang.Integer.valueOf(i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$7() {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(this.activity);
    }

    private void filterOrganList(java.lang.String str, java.util.List<com.up366.mobile.common.logic.model.AccountOrganInfo> list) {
        if (list == null) {
            return;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            list.clear();
        }
        java.util.Iterator<com.up366.mobile.common.logic.model.AccountOrganInfo> it = list.iterator();
        while (it.hasNext()) {
            com.up366.mobile.common.logic.model.AccountOrganInfo next = it.next();
            next.countCosDistance(str);
            if (!next.containsWord(str)) {
                it.remove();
            }
        }
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.user.account.find.PageSearchSchool$$ExternalSyntheticLambda8
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return java.lang.Float.compare(((com.up366.mobile.common.logic.model.AccountOrganInfo) obj2).getCosDistance(), ((com.up366.mobile.common.logic.model.AccountOrganInfo) obj).getCosDistance());
            }
        });
    }

    private class Adapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
        private final android.app.Activity activity;
        private final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.logic.model.AccountOrganInfo> cityClickListener = new com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.logic.model.AccountOrganInfo>() { // from class: com.up366.mobile.user.account.find.PageSearchSchool.Adapter.1
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public void onResult(int i, java.lang.String str, com.up366.mobile.common.logic.model.AccountOrganInfo accountOrganInfo) {
                com.up366.common.log.Logger.info("TAG - PageSearchSchool - Adapter - onResult - ");
                if (com.up366.mobile.user.account.find.PageSearchSchool.Adapter.this.config.type == 0) {
                    com.up366.mobile.user.account.find.AccountFindActivity.Config configClone = com.up366.mobile.user.account.find.PageSearchSchool.Adapter.this.config.m1200clone();
                    configClone.page = 2;
                    configClone.organId = accountOrganInfo.getOrganId();
                    configClone.organName = accountOrganInfo.getOrganName();
                    com.up366.mobile.user.account.find.AccountFindActivity.openPage(com.up366.mobile.user.account.find.PageSearchSchool.Adapter.this.activity, configClone);
                }
                if (com.up366.mobile.user.account.find.PageSearchSchool.Adapter.this.config.type == 1) {
                    com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.OrganInfo organInfo = new com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.OrganInfo();
                    organInfo.type = 0;
                    organInfo.organId = accountOrganInfo.getOrganId();
                    organInfo.organName = accountOrganInfo.getOrganName();
                    com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.open(com.up366.mobile.user.account.find.PageSearchSchool.Adapter.this.activity, organInfo, com.up366.mobile.user.account.login.AccountLoginStudentNumberActivity.fromSwitch);
                    com.up366.mobile.user.account.find.PageSearchSchool.this.closeAll.run();
                }
            }
        };
        private final com.up366.mobile.user.account.find.AccountFindActivity.Config config;

        public Adapter(android.app.Activity activity, com.up366.mobile.user.account.find.AccountFindActivity.Config config) {
            this.activity = activity;
            this.config = config;
        }

        public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.AccountColoredSchoolItemView(viewGroup.getContext()));
            }
            return defaultHandler(viewGroup, i);
        }

        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
            com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
            if (dataHolder.viewType == 1) {
                ((com.up366.mobile.common.views.AccountColoredSchoolItemView) viewHolder.itemView).setData((com.up366.mobile.common.logic.model.AccountOrganInfo) dataHolder.o, com.up366.mobile.user.account.find.PageSearchSchool.this.b.edit.getTrimText(), this.cityClickListener);
            } else {
                defaultHandler(viewHolder, i);
            }
        }
    }
}
