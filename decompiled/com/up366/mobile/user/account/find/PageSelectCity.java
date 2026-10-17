package com.up366.mobile.user.account.find;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageSelectCity {
    private final android.app.Activity activity;
    private com.up366.mobile.user.account.find.PageSelectCity.Adapter adapter;
    private final com.up366.mobile.databinding.AccountFindActivitySelectCityLayoutBinding b;
    private java.util.List<com.up366.mobile.common.logic.model.AccountCityInfo> cityInfos = new java.util.ArrayList();
    private final com.up366.mobile.user.account.find.AccountFindActivity.Config config;
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.common.logic.model.AccountCityInfo> controller;
    private com.up366.mobile.common.logic.model.AccountCityInfo currentCityInfo;

    public PageSelectCity(android.app.Activity activity, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, com.up366.mobile.common.views.TitleCloseGroupTextView titleCloseGroupTextView, com.up366.mobile.user.account.find.AccountFindActivity.Config config) {
        this.activity = activity;
        this.config = config;
        this.controller = new com.up366.mobile.common.base.USV5ListViewDataController<>(activity);
        collapsingToolbarLayout.setTitle("请选择你所在的城市");
        com.up366.mobile.databinding.AccountFindActivitySelectCityLayoutBinding accountFindActivitySelectCityLayoutBinding = (com.up366.mobile.databinding.AccountFindActivitySelectCityLayoutBinding) androidx.databinding.DataBindingUtil.inflate(activity.getLayoutInflater(), com.up366.mobile.R.layout.account_find_activity_select_city_layout, frameLayout, true);
        this.b = accountFindActivitySelectCityLayoutBinding;
        initView(activity, appBarLayout);
        initController();
        if (config.type == 1) {
            titleCloseGroupTextView.setVisibility(4);
            accountFindActivitySelectCityLayoutBinding.tip.setVisibility(0);
        }
        accountFindActivitySelectCityLayoutBinding.refreshLayout.doRefresh();
    }

    private void initView(android.app.Activity activity, com.google.android.material.appbar.AppBarLayout appBarLayout) {
        this.adapter = new com.up366.mobile.user.account.find.PageSelectCity.Adapter(activity);
        new com.up366.mobile.common.helper.AppBarRefreshLayoutHelper().binding(appBarLayout, this.b.refreshLayout, this.b.recycleView);
        this.b.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(activity));
        this.b.recycleView.setAdapter(this.adapter);
        this.b.recycleView.addItemDecoration(new com.up366.mobile.user.account.find.SelectCityFloatTitleItemDecoration());
        com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout = this.b.refreshLayout;
        final com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout2 = this.b.refreshLayout;
        java.util.Objects.requireNonNull(pullRefreshLayout2);
        pullRefreshLayout.setOnCompleteListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnCompleteListener() { // from class: com.up366.mobile.user.account.find.PageSelectCity$$ExternalSyntheticLambda0
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnCompleteListener
            public final void onComplete() {
                pullRefreshLayout2.complete();
            }
        });
        this.b.refreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.user.account.find.PageSelectCity$$ExternalSyntheticLambda1
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.lambda$initView$0();
            }
        });
        this.b.letterSelect.setLetters(java.util.Arrays.asList("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ")));
        this.b.select.setAlpha(0.0f);
        this.b.letterSelect.setOnSelectListener(new com.up366.mobile.common.views.LetterSelectView.IOnSelectListener() { // from class: com.up366.mobile.user.account.find.PageSelectCity$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.views.LetterSelectView.IOnSelectListener
            public final void onSelect(java.lang.String str) {
                this.f$0.getOnLetterSelectListener(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        this.controller.loadWebData();
    }

    private void initController() {
        fetchCurrentLocation();
        this.controller.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.user.account.find.PageSelectCity$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                this.f$0.lambda$initController$2();
            }
        });
        this.controller.setBeforeRender(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.user.account.find.PageSelectCity$$ExternalSyntheticLambda7
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                this.f$0.lambda$initController$3(list);
            }
        });
        this.controller.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.user.account.find.PageSelectCity$$ExternalSyntheticLambda8
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                this.f$0.lambda$initController$4(list, list2);
            }
        });
        this.controller.setAdapter(this.adapter);
        com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.common.logic.model.AccountCityInfo> uSV5ListViewDataController = this.controller;
        final com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout = this.b.refreshLayout;
        java.util.Objects.requireNonNull(pullRefreshLayout);
        uSV5ListViewDataController.setOnCompleteCallback(new com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback() { // from class: com.up366.mobile.user.account.find.PageSelectCity$$ExternalSyntheticLambda9
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback
            public final void onComplete() {
                pullRefreshLayout.complete();
            }
        });
        this.controller.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$2() throws java.lang.Exception {
        com.up366.mobile.common.logic.Auth.mgr().fetchAccountDictList(this.config.type != 1 ? 0 : 1, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.find.PageSelectCity$$ExternalSyntheticLambda5
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$initController$1(response, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$1(com.up366.common.http.Response response, java.util.List list) {
        com.up366.common.log.Logger.info("TAG - PageSelectCity - onResult - isError : " + response.isError());
        this.controller.onLoadWebData(response, (java.util.List<com.up366.mobile.common.logic.model.AccountCityInfo>) list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$3(java.util.List list) {
        this.b.letterSelect.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$4(java.util.List list, java.util.List list2) {
        this.cityInfos = list;
        this.b.letterSelect.setVisibility(0);
        list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_TITLE_ITEM, "定位城市"));
        list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(5));
        char c = 0;
        for (int i = 0; i < list.size(); i++) {
            com.up366.mobile.common.logic.model.AccountCityInfo accountCityInfo = (com.up366.mobile.common.logic.model.AccountCityInfo) list.get(i);
            char firstLetter = accountCityInfo.getFirstLetter();
            if (c != firstLetter) {
                list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_TITLE_ITEM, java.lang.String.valueOf(firstLetter)));
                c = firstLetter;
            } else {
                list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_DIVIDER_LINE, java.lang.Integer.valueOf(i)));
            }
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, accountCityInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOnLetterSelectListener(java.lang.String str) {
        char cCharAt;
        if (!com.up366.common.StringUtils.isEmptyOrNull(str) && !this.b.select.getText().equals(str)) {
            char cCharAt2 = str.charAt(0);
            java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> datas = this.adapter.getDatas();
            int i = 0;
            while (true) {
                if (i >= datas.size()) {
                    i = 0;
                    break;
                }
                com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = datas.get(i);
                if (dataHolder.viewType == -9995 && (cCharAt = ((java.lang.String) dataHolder.o).charAt(0)) <= 'Z' && cCharAt2 <= cCharAt) {
                    break;
                } else {
                    i++;
                }
            }
            androidx.recyclerview.widget.LinearLayoutManager layoutManager = this.b.recycleView.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.scrollToPositionWithOffset(i, 0);
            }
        }
        if (str == null) {
            this.b.select.animate().alpha(0.0f).setDuration(com.igexin.push.config.c.s).rotationBy((float) ((java.lang.Math.random() - 0.5d) * 720.0d)).rotationXBy((float) ((java.lang.Math.random() - 0.5d) * 720.0d)).rotationYBy((float) ((java.lang.Math.random() - 0.5d) * 720.0d)).scaleX(0.1f).scaleY(0.1f).translationYBy(this.b.select.getHeight() * 1.5f).setInterpolator(new android.view.animation.DecelerateInterpolator()).start();
            return;
        }
        this.b.select.setText(str);
        this.b.select.animate().cancel();
        this.b.select.setAlpha(1.0f);
        this.b.select.setScaleX(1.0f);
        this.b.select.setScaleY(1.0f);
        this.b.select.setTranslationY(0.0f);
        this.b.select.setRotation(0.0f);
        this.b.select.setRotationX(0.0f);
        this.b.select.setRotationY(0.0f);
        this.b.select.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class Adapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
        public static final int TYPE_LOCATION = 5;
        private android.app.Activity activity;
        private final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.logic.model.AccountCityInfo> cityClickListener = new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.account.find.PageSelectCity$Adapter$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$new$0(i, str, (com.up366.mobile.common.logic.model.AccountCityInfo) obj);
            }
        };
        private final com.up366.common.callback.ICallbackCode reLocationListener = new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.user.account.find.PageSelectCity$Adapter$$ExternalSyntheticLambda1
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                this.f$0.lambda$new$1(i);
            }
        };

        public Adapter(android.app.Activity activity) {
            this.activity = activity;
        }

        public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            if (i == -9995) {
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.AccountCityItemTitleView(viewGroup.getContext()));
            }
            if (i == 1) {
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.AccountCityItemView(viewGroup.getContext()));
            }
            if (i == 5) {
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.AccountLocationItemView(viewGroup.getContext()));
            }
            return defaultHandler(viewGroup, i);
        }

        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
            com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
            int i2 = dataHolder.viewType;
            if (i2 == -9995) {
                ((com.up366.mobile.common.views.AccountCityItemTitleView) viewHolder.itemView).setData((java.lang.String) dataHolder.o);
                return;
            }
            if (i2 == 1) {
                ((com.up366.mobile.common.views.AccountCityItemView) viewHolder.itemView).setData((com.up366.mobile.common.logic.model.AccountCityInfo) dataHolder.o, this.cityClickListener);
            } else if (i2 == 5) {
                ((com.up366.mobile.common.views.AccountLocationItemView) viewHolder.itemView).setData(com.up366.mobile.user.account.find.PageSelectCity.this.config.type != 1 ? 0 : 1, com.up366.mobile.user.account.find.PageSelectCity.this.cityInfos, com.up366.mobile.user.account.find.PageSelectCity.this.currentCityInfo, this.cityClickListener, this.reLocationListener);
            } else {
                defaultHandler(viewHolder, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(int i, java.lang.String str, com.up366.mobile.common.logic.model.AccountCityInfo accountCityInfo) {
            com.up366.mobile.user.account.find.AccountFindActivity.Config configClone = com.up366.mobile.user.account.find.PageSelectCity.this.config.m1200clone();
            configClone.page = 1;
            configClone.cityId = accountCityInfo.getCityId();
            configClone.cityName = accountCityInfo.getCityName();
            com.up366.mobile.user.account.find.AccountFindActivity.openPage(this.activity, configClone);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(int i) {
            com.up366.mobile.user.account.find.PageSelectCity.this.fetchCurrentLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchCurrentLocation() {
        com.up366.mobile.common.logic.Auth.mgr().fetchCurrentCityInfo(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.find.PageSelectCity$$ExternalSyntheticLambda4
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$fetchCurrentLocation$6(response, (com.up366.mobile.common.logic.model.AccountCityInfo) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchCurrentLocation$6(com.up366.common.http.Response response, com.up366.mobile.common.logic.model.AccountCityInfo accountCityInfo) {
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this.activity, response);
        } else {
            com.up366.common.task.TaskUtils.postMainTaskDelay(1000L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.find.PageSelectCity$$ExternalSyntheticLambda3
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$fetchCurrentLocation$5();
                }
            });
        }
        this.currentCityInfo = accountCityInfo;
        this.controller.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchCurrentLocation$5() throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(this.activity);
    }
}
