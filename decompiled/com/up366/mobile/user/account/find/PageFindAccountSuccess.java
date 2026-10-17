package com.up366.mobile.user.account.find;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageFindAccountSuccess {
    private final android.app.Activity activity;
    private com.up366.mobile.user.account.find.PageFindAccountSuccess.Adapter adapter;
    private final com.up366.mobile.databinding.AccountFindActivityFindSuccessLayoutBinding b;
    private final com.up366.mobile.common.views.TitleCloseGroupTextView close;
    private final com.up366.mobile.user.account.find.AccountFindActivity.Config config;
    private final java.lang.String organName;
    private final java.util.List<com.up366.mobile.common.logic.model.AccountUserInfo> userList;

    public PageFindAccountSuccess(android.app.Activity activity, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView, com.up366.mobile.common.views.TitleBackView titleBackView, com.up366.mobile.common.views.TitleCloseGroupTextView titleCloseGroupTextView, com.up366.mobile.user.account.find.AccountFindActivity.Config config) {
        this.activity = activity;
        this.config = config;
        titleBackView.setVisibility(8);
        this.close = titleCloseGroupTextView;
        this.organName = config.organName;
        this.userList = (java.util.List) com.up366.mobile.common.logic.Auth.mgr().cache().loadMemorySync("userList");
        if (config.type == 1) {
            collapsingToolbarLayout.setTitle("请确认账号后登录");
        } else {
            collapsingToolbarLayout.setTitle("恭喜你~账号找到啦");
        }
        com.up366.mobile.databinding.AccountFindActivityFindSuccessLayoutBinding accountFindActivityFindSuccessLayoutBinding = (com.up366.mobile.databinding.AccountFindActivityFindSuccessLayoutBinding) androidx.databinding.DataBindingUtil.inflate(activity.getLayoutInflater(), com.up366.mobile.R.layout.account_find_activity_find_success_layout, frameLayout, true);
        this.b = accountFindActivityFindSuccessLayoutBinding;
        collapsingToolbarLayout.setExpandedTitleMarginStart(accountFindActivityFindSuccessLayoutBinding.getRoot().getPaddingLeft());
        initView(activity, appBarLayout);
    }

    private void initView(android.app.Activity activity, final com.google.android.material.appbar.AppBarLayout appBarLayout) {
        this.adapter = new com.up366.mobile.user.account.find.PageFindAccountSuccess.Adapter();
        this.b.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(activity));
        this.b.recycleView.setAdapter(this.adapter);
        final java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_12DP, -1));
        for (int i = 0; i < this.userList.size(); i++) {
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, this.userList.get(i)));
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_12DP, java.lang.Integer.valueOf(i)));
        }
        arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(2, -1));
        arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_12DP, -2));
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.find.PageFindAccountSuccess$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$0(arrayList);
            }
        });
        com.up366.common.task.TaskUtils.postMainTaskDelay(200L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.find.PageFindAccountSuccess$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$1();
            }
        });
        appBarLayout.addOnOffsetChangedListener(new com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener() { // from class: com.up366.mobile.user.account.find.PageFindAccountSuccess$$ExternalSyntheticLambda2
            public final void onOffsetChanged(com.google.android.material.appbar.AppBarLayout appBarLayout2, int i2) {
                this.f$0.lambda$initView$3(appBarLayout, appBarLayout2, i2);
            }
        });
        if (this.userList.size() > 1) {
            this.b.tip.setText(com.up366.common.StringUtils.format("查找到%d个相关的账号，请选择您的账号", java.lang.Integer.valueOf(this.userList.size())));
        } else {
            this.b.tip.setText("请你一定要牢记哟~");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(java.util.List list) throws java.lang.Exception {
        this.adapter.lambda$setDatas$0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1() throws java.lang.Exception {
        refreshReFindViewPositon(this.b.recycleView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2() {
        refreshReFindViewPositon(this.b.recycleView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3(com.google.android.material.appbar.AppBarLayout appBarLayout, com.google.android.material.appbar.AppBarLayout appBarLayout2, int i) {
        appBarLayout.postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.user.account.find.PageFindAccountSuccess$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$initView$2();
            }
        }, 10L);
    }

    private void refreshReFindViewPositon(androidx.recyclerview.widget.RecyclerView recyclerView) {
        java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> datas = this.adapter.getDatas();
        androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(datas.size() - 3);
        androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition2 = recyclerView.findViewHolderForAdapterPosition(datas.size() - 2);
        if (viewHolderFindViewHolderForAdapterPosition == null || viewHolderFindViewHolderForAdapterPosition2 == null) {
            return;
        }
        android.view.View view = viewHolderFindViewHolderForAdapterPosition.itemView;
        android.view.View view2 = viewHolderFindViewHolderForAdapterPosition2.itemView;
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getGlobalVisibleRect(rect);
        android.graphics.Rect rect2 = new android.graphics.Rect();
        view2.getGlobalVisibleRect(rect2);
        view2.getRootView().getGlobalVisibleRect(new android.graphics.Rect());
        float fHeight = rect.bottom + rect2.height() + com.up366.common.DpUtilsUp.dp2px(20.0f);
        float translationY = view2.getTranslationY();
        if (fHeight < r2.bottom) {
            translationY = r2.bottom - fHeight;
        }
        view2.setTranslationY(translationY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class Adapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
        private final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.logic.model.AccountUserInfo> cityClickListener;

        private Adapter() {
            this.cityClickListener = new com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.logic.model.AccountUserInfo>() { // from class: com.up366.mobile.user.account.find.PageFindAccountSuccess.Adapter.1
                @Override // com.up366.common.callback.ICallbackCodeInfoObj
                public void onResult(int i, java.lang.String str, com.up366.mobile.common.logic.model.AccountUserInfo accountUserInfo) {
                    com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("auto-fill-username", accountUserInfo.getUsername(), 1000L);
                    com.up366.mobile.user.account.login.AccountLoginActivity.open(com.up366.mobile.user.account.find.PageFindAccountSuccess.this.activity);
                }
            };
        }

        public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.AccountUserInfoItemView(viewGroup.getContext()));
            }
            if (i == 2) {
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.AccountUserInfoItemReFindView(viewGroup.getContext()));
            }
            return defaultHandler(viewGroup, i);
        }

        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
            com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
            int i2 = dataHolder.viewType;
            if (i2 == 1) {
                ((com.up366.mobile.common.views.AccountUserInfoItemView) viewHolder.itemView).setData((com.up366.mobile.common.logic.model.AccountUserInfo) dataHolder.o, com.up366.mobile.user.account.find.PageFindAccountSuccess.this.organName, this.cityClickListener);
            } else if (i2 == 2) {
                ((com.up366.mobile.common.views.AccountUserInfoItemReFindView) viewHolder.itemView).setData(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.find.PageFindAccountSuccess$Adapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        this.f$0.lambda$onBindViewHolder$0(view);
                    }
                });
            } else {
                defaultHandler(viewHolder, i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(android.view.View view) {
            if (com.up366.mobile.user.account.find.PageFindAccountSuccess.this.config.type == 1) {
                com.up366.mobile.user.account.find.PageFindAccountSuccess.this.close.callOnClick();
                com.up366.mobile.user.account.find.AccountFindActivity.Config configClone = com.up366.mobile.user.account.find.PageFindAccountSuccess.this.config.m1200clone();
                configClone.page = 2;
                com.up366.mobile.user.account.find.AccountFindActivity.openPage(view.getContext(), configClone);
                return;
            }
            com.up366.mobile.user.account.find.PageFindAccountSuccess.this.close.callOnClick();
        }
    }
}
