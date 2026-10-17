package com.up366.mobile.user.account.find;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageValidClassmates {
    private final android.app.Activity activity;
    private com.up366.mobile.user.account.find.PageValidClassmates.Adapter adapter;
    private final com.up366.mobile.databinding.AccountFindActivityValidClassmatesLayoutBinding b;
    private final java.lang.String classId;
    private final java.util.List<java.lang.String> classMateNames;
    private final com.up366.mobile.user.account.find.AccountFindActivity.Config config;
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.common.logic.model.AccountUserInfo> controller;
    private final java.util.List<com.up366.mobile.common.logic.model.AccountClassInfo> list;
    private java.util.List<com.up366.mobile.common.logic.model.AccountUserInfo> nameInfos = new java.util.ArrayList();
    private final java.lang.String realName;

    public PageValidClassmates(android.app.Activity activity, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView, com.up366.mobile.user.account.find.AccountFindActivity.Config config) {
        this.activity = activity;
        this.config = config;
        activity.getIntent();
        this.realName = config.realName;
        java.util.List<com.up366.mobile.common.logic.model.AccountClassInfo> list = (java.util.List) com.up366.mobile.common.logic.Auth.mgr().cache().loadMemorySync("classList");
        this.list = list;
        this.classMateNames = (java.util.List) com.up366.mobile.common.logic.Auth.mgr().cache().loadMemorySync("classMateNames");
        this.classId = config.classId;
        collapsingToolbarLayout.setTitle("验证三位同学姓名");
        com.up366.mobile.common.utils.SpannableStringBuilderUtil spannableStringBuilderUtil = new com.up366.mobile.common.utils.SpannableStringBuilderUtil();
        if (list == null) {
            spannableStringBuilderUtil.append("03");
        } else {
            spannableStringBuilderUtil.append("04");
        }
        spannableStringBuilderUtil.setSpan(new android.text.style.ForegroundColorSpan(activity.getResources().getColor(com.up366.mobile.R.color.c1)));
        textView.setText(spannableStringBuilderUtil.append("/04").build());
        com.up366.mobile.databinding.AccountFindActivityValidClassmatesLayoutBinding accountFindActivityValidClassmatesLayoutBinding = (com.up366.mobile.databinding.AccountFindActivityValidClassmatesLayoutBinding) androidx.databinding.DataBindingUtil.inflate(activity.getLayoutInflater(), com.up366.mobile.R.layout.account_find_activity_valid_classmates_layout, frameLayout, true);
        this.b = accountFindActivityValidClassmatesLayoutBinding;
        collapsingToolbarLayout.setExpandedTitleMarginStart(accountFindActivityValidClassmatesLayoutBinding.getRoot().getPaddingLeft());
        initView(activity, appBarLayout, textView);
        initController();
    }

    private void initView(final android.app.Activity activity, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView) {
        this.adapter = new com.up366.mobile.user.account.find.PageValidClassmates.Adapter();
        this.b.recycleView.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(activity, 3));
        final int iDp2px = com.up366.common.DpUtilsUp.dp2px(6.0f);
        this.b.recycleView.addItemDecoration(new androidx.recyclerview.widget.RecyclerView.ItemDecoration() { // from class: com.up366.mobile.user.account.find.PageValidClassmates.1
            public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
                super.getItemOffsets(rect, view, recyclerView, state);
                int i = iDp2px;
                int i2 = recyclerView.getChildLayoutPosition(view) % 3 == 0 ? 0 : i;
                if (recyclerView.getChildLayoutPosition(view) % 3 == 2) {
                    i = 0;
                }
                int i3 = iDp2px;
                rect.set(i2, i3, i, i3);
            }
        });
        this.b.recycleView.setAdapter(this.adapter);
        this.b.btnNext.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.find.PageValidClassmates$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$1(activity, view);
            }
        });
        refreshBtnState();
        if (this.config.type == 1) {
            textView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(final android.app.Activity activity, android.view.View view) {
        java.lang.String checkedNames = getCheckedNames();
        this.b.btnNext.setEnabled(false);
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "正在加载");
        com.up366.mobile.common.logic.Auth.mgr().fetchAccountUserVerify(this.classId, this.realName, checkedNames, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.find.PageValidClassmates$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$initView$0(activity, response, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(android.app.Activity activity, com.up366.common.http.Response response, java.util.List list) {
        java.util.Iterator<com.up366.mobile.common.logic.model.AccountUserInfo> it = this.nameInfos.iterator();
        while (it.hasNext()) {
            it.next().setChecked(false);
        }
        this.controller.refresh();
        refreshBtnState();
        if (response.isError()) {
            if (response.getCode() == 2) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "验证失败:请重新选择你的三位同学！");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, response);
                return;
            }
        }
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        com.up366.mobile.common.logic.Auth.mgr().cache().putMemorySync("userList", list, 3600000L);
        com.up366.mobile.user.account.find.AccountFindActivity.Config configClone = this.config.m1200clone();
        configClone.page = 6;
        com.up366.mobile.user.account.find.AccountFindActivity.openPage(activity, configClone);
    }

    private void initController() {
        com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.common.logic.model.AccountUserInfo> uSV5ListViewDataController = new com.up366.mobile.common.base.USV5ListViewDataController<>(this.activity);
        this.controller = uSV5ListViewDataController;
        uSV5ListViewDataController.setLocalLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.user.account.find.PageValidClassmates$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                this.f$0.lambda$initController$2();
            }
        });
        this.controller.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.user.account.find.PageValidClassmates$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                com.up366.mobile.user.account.find.PageValidClassmates.lambda$initController$3(list, list2);
            }
        });
        this.controller.setAdapter(this.adapter);
        this.controller.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$2() throws java.lang.Exception {
        this.nameInfos = new java.util.ArrayList();
        for (java.lang.String str : this.classMateNames) {
            com.up366.mobile.common.logic.model.AccountUserInfo accountUserInfo = new com.up366.mobile.common.logic.model.AccountUserInfo();
            accountUserInfo.setRealname(str);
            this.nameInfos.add(accountUserInfo);
        }
        this.controller.onLoadLocalData(this.nameInfos);
    }

    static /* synthetic */ void lambda$initController$3(java.util.List list, java.util.List list2) {
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, (com.up366.mobile.common.logic.model.AccountUserInfo) it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshBtnState() {
        if (getCheckCount() < 3) {
            this.b.btnNext.setEnabled(false);
            java.util.Iterator<com.up366.mobile.common.logic.model.AccountUserInfo> it = this.nameInfos.iterator();
            while (it.hasNext()) {
                it.next().setCheckedEnable(true);
            }
            return;
        }
        this.b.btnNext.setEnabled(true);
        for (com.up366.mobile.common.logic.model.AccountUserInfo accountUserInfo : this.nameInfos) {
            if (accountUserInfo.isChecked()) {
                accountUserInfo.setCheckedEnable(true);
            } else {
                accountUserInfo.setCheckedEnable(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class Adapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
        private final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.logic.model.AccountUserInfo> userClickListener;

        private Adapter() {
            this.userClickListener = new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.user.account.find.PageValidClassmates$Adapter$$ExternalSyntheticLambda0
                @Override // com.up366.common.callback.ICallbackCodeInfoObj
                public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                    this.f$0.lambda$new$0(i, str, (com.up366.mobile.common.logic.model.AccountUserInfo) obj);
                }
            };
        }

        public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.AccountValidClassmatesItemView(viewGroup.getContext()));
            }
            return defaultHandler(viewGroup, i);
        }

        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
            com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
            if (dataHolder.viewType == 1) {
                ((com.up366.mobile.common.views.AccountValidClassmatesItemView) viewHolder.itemView).setData((com.up366.mobile.common.logic.model.AccountUserInfo) dataHolder.o, this.userClickListener);
            } else {
                defaultHandler(viewHolder, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(int i, java.lang.String str, com.up366.mobile.common.logic.model.AccountUserInfo accountUserInfo) {
            if (com.up366.mobile.user.account.find.PageValidClassmates.this.getCheckCount() > 3) {
                accountUserInfo.setChecked(false);
            }
            com.up366.mobile.user.account.find.PageValidClassmates.this.refreshBtnState();
            com.up366.mobile.user.account.find.PageValidClassmates.this.controller.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCheckCount() {
        java.util.Iterator<com.up366.mobile.common.logic.model.AccountUserInfo> it = this.nameInfos.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().isChecked()) {
                i++;
            }
        }
        return i;
    }

    private java.lang.String getCheckedNames() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.up366.mobile.common.logic.model.AccountUserInfo accountUserInfo : this.nameInfos) {
            if (accountUserInfo.isChecked()) {
                arrayList.add(accountUserInfo.getRealname());
            }
        }
        return com.up366.common.StringUtils.join(arrayList, com.igexin.push.core.b.an);
    }
}
