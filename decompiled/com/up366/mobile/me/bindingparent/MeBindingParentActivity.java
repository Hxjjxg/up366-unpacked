package com.up366.mobile.me.bindingparent;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeBindingParentActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.me.bindingparent.MeBindingParentActivity.RecycleAdapter adapter = new com.up366.mobile.me.bindingparent.MeBindingParentActivity.RecycleAdapter();
    private com.up366.mobile.databinding.MeBindingParentAcivityLayoutBinding binding;
    private androidx.recyclerview.widget.LinearLayoutManager layoutManager;

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_bind_parent";
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.qmui.util.QMUIStatusBarHelper.translucent((android.app.Activity) this);
        com.up366.mobile.databinding.MeBindingParentAcivityLayoutBinding meBindingParentAcivityLayoutBinding = (com.up366.mobile.databinding.MeBindingParentAcivityLayoutBinding) androidx.databinding.DataBindingUtil.inflate(getLayoutInflater(), com.up366.mobile.R.layout.me_binding_parent_acivity_layout, (android.view.ViewGroup) null, true);
        this.binding = meBindingParentAcivityLayoutBinding;
        setContentView(meBindingParentAcivityLayoutBinding.getRoot());
        com.up366.common.EventBusUtilsUp.register(this);
        com.up366.mobile.common.logic.Auth.cur().info().fetchParentQcode();
        initView();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        if ("SUCCESS".equals((java.lang.String) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync("SAVE_SHARE_PICTURE"))) {
            com.up366.mobile.common.utils.ToastPopupUtil.showSuccess((android.app.Activity) this, "保存成功");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        this.binding.shareBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.bindingparent.MeBindingParentActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$0(view);
            }
        });
        this.layoutManager = new androidx.recyclerview.widget.LinearLayoutManager(this, 0, false);
        this.binding.recycleView.setLayoutManager(this.layoutManager);
        this.binding.recycleView.setAdapter(this.adapter);
        new androidx.recyclerview.widget.LinearSnapHelper().attachToRecyclerView(this.binding.recycleView);
        this.binding.recycleView.addOnScrollListener(new androidx.recyclerview.widget.RecyclerView.OnScrollListener() { // from class: com.up366.mobile.me.bindingparent.MeBindingParentActivity.1
            public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
                if (i == 0) {
                    com.up366.mobile.me.bindingparent.MeBindingParentActivity.this.binding.guide.setCurIndex(com.up366.mobile.me.bindingparent.MeBindingParentActivity.this.layoutManager.findFirstVisibleItemPosition());
                }
            }
        });
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.up366.mobile.common.logic.model.ParentQcodeResponse(null, new com.up366.mobile.common.logic.model.ParentQcode(1)));
        arrayList.add(new com.up366.mobile.common.logic.model.ParentQcodeResponse(null, new com.up366.mobile.common.logic.model.ParentQcode(2)));
        this.adapter.lambda$setDatas$0(com.up366.mobile.common.utils.DataHolderUtils.convertToDataHolder(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$0(android.view.View view) {
        com.up366.mobile.me.bindingparent.MeBindingParentSharedActivity.openPage(this, ((com.up366.mobile.common.logic.model.ParentQcodeResponse) this.adapter.getDatas().get(this.layoutManager.findFirstVisibleItemPosition()).o).result);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.onDestroy();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.LoadParentQcodeEvent loadParentQcodeEvent) {
        this.adapter.lambda$setDatas$0(com.up366.mobile.common.utils.DataHolderUtils.convertToDataHolder(loadParentQcodeEvent.result));
        if (loadParentQcodeEvent.resp.isError()) {
            return;
        }
        this.binding.shareBtn.setEnabled(true);
    }

    class RecycleAdapter extends com.up366.mobile.common.base.BaseRecyclerAdapter {
        RecycleAdapter() {
        }

        public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.BindingParentView(viewGroup.getContext()));
        }

        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
            ((com.up366.mobile.common.views.BindingParentView) viewHolder.itemView).setData((com.up366.mobile.common.logic.model.ParentQcodeResponse) this.datas.get(i).o);
        }
    }
}
