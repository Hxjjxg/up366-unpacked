package com.up366.mobile.user.account.find;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageSelectClass {
    private final android.app.Activity activity;
    private com.up366.mobile.user.account.find.PageSelectClass.Adapter adapter;
    private final com.up366.mobile.databinding.AccountFindActivitySelectClassLayoutBinding b;
    private final com.up366.mobile.user.account.find.AccountFindActivity.Config config;
    private final java.util.List<com.up366.mobile.common.logic.model.AccountClassInfo> list = (java.util.List) com.up366.mobile.common.logic.Auth.mgr().cache().loadMemorySync("classList");
    private final java.lang.String realName;

    public PageSelectClass(android.app.Activity activity, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView, com.up366.mobile.user.account.find.AccountFindActivity.Config config) {
        this.activity = activity;
        this.config = config;
        this.realName = config.realName;
        collapsingToolbarLayout.setTitle("选择班级");
        textView.setText(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("03").setSpan(new android.text.style.ForegroundColorSpan(activity.getResources().getColor(com.up366.mobile.R.color.c1))).append("/04").build());
        com.up366.mobile.databinding.AccountFindActivitySelectClassLayoutBinding accountFindActivitySelectClassLayoutBinding = (com.up366.mobile.databinding.AccountFindActivitySelectClassLayoutBinding) androidx.databinding.DataBindingUtil.inflate(activity.getLayoutInflater(), com.up366.mobile.R.layout.account_find_activity_select_class_layout, frameLayout, true);
        this.b = accountFindActivitySelectClassLayoutBinding;
        collapsingToolbarLayout.setExpandedTitleMarginStart(accountFindActivitySelectClassLayoutBinding.titlePadding.getPaddingLeft());
        initView(activity, appBarLayout, textView);
    }

    private void initView(android.app.Activity activity, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView) {
        this.adapter = new com.up366.mobile.user.account.find.PageSelectClass.Adapter();
        this.b.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(activity));
        this.b.recycleView.setAdapter(this.adapter);
        final java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_12DP, -1));
        for (int i = 0; i < this.list.size(); i++) {
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, this.list.get(i)));
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_12DP, java.lang.Integer.valueOf(i)));
        }
        arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_12DP, -2));
        com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.find.PageSelectClass$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$0(arrayList);
            }
        });
        if (this.config.type == 1) {
            textView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(java.util.List list) throws java.lang.Exception {
        this.adapter.lambda$setDatas$0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class Adapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
        private final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.logic.model.AccountClassInfo> cityClickListener;

        private Adapter() {
            this.cityClickListener = new com.up366.mobile.user.account.find.PageSelectClass.Adapter.AnonymousClass1();
        }

        public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.AccountSelectClassItemView(viewGroup.getContext()));
            }
            return defaultHandler(viewGroup, i);
        }

        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
            com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
            if (dataHolder.viewType == 1) {
                ((com.up366.mobile.common.views.AccountSelectClassItemView) viewHolder.itemView).setData((com.up366.mobile.common.logic.model.AccountClassInfo) dataHolder.o, this.cityClickListener);
            } else {
                defaultHandler(viewHolder, i);
            }
        }

        /* JADX INFO: renamed from: com.up366.mobile.user.account.find.PageSelectClass$Adapter$1, reason: invalid class name */
        class AnonymousClass1 implements com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.common.logic.model.AccountClassInfo> {
            AnonymousClass1() {
            }

            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public void onResult(int i, java.lang.String str, final com.up366.mobile.common.logic.model.AccountClassInfo accountClassInfo) {
                com.up366.mobile.common.utils.ToastPopupUtil.showLoading(com.up366.mobile.user.account.find.PageSelectClass.this.activity, "正在加载");
                com.up366.mobile.common.logic.Auth.mgr().fetchAccountUserList(accountClassInfo.getClassId(), com.up366.mobile.user.account.find.PageSelectClass.this.realName, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.find.PageSelectClass$Adapter$1$$ExternalSyntheticLambda0
                    @Override // com.up366.common.callback.ICallbackResponse
                    public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                        this.f$0.lambda$onResult$0(accountClassInfo, response, (java.util.List) obj);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onResult$0(com.up366.mobile.common.logic.model.AccountClassInfo accountClassInfo, com.up366.common.http.Response response, java.util.List list) {
                if (response.isError()) {
                    com.up366.mobile.common.utils.ToastPopupUtil.showInfo(com.up366.mobile.user.account.find.PageSelectClass.this.activity, response);
                    return;
                }
                com.up366.mobile.common.utils.ToastPopupUtil.dismiss(com.up366.mobile.user.account.find.PageSelectClass.this.activity);
                com.up366.mobile.user.account.find.AccountFindActivity.Config configClone = com.up366.mobile.user.account.find.PageSelectClass.this.config.m1200clone();
                configClone.page = 5;
                configClone.classId = accountClassInfo.getClassId();
                configClone.className = accountClassInfo.getClassName();
                com.up366.mobile.common.logic.Auth.mgr().cache().putMemorySync("classMateNames", list, 3600000L);
                com.up366.mobile.user.account.find.AccountFindActivity.openPage(com.up366.mobile.user.account.find.PageSelectClass.this.activity, configClone);
            }
        }
    }
}
