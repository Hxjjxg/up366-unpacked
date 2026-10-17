package com.up366.mobile.me.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeRecommendBookActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.me.book.MeMyBookActivityAdapter adapter;
    private com.up366.mobile.databinding.MeRecommendBookAcivityLayoutBinding binding;
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.common.logic.model.MyBook> controller = new com.up366.mobile.common.base.USV5ListViewDataController<>(this);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (com.up366.mobile.databinding.MeRecommendBookAcivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.me_recommend_book_acivity_layout);
        com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarLightMode(this);
        initView();
        initController();
        com.up366.mobile.me.book.MeBookUtil.filterData(0, com.up366.mobile.me.book.MeBookUtil.getMyBooksFromCacheEvent(), new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.me.book.MeRecommendBookActivity$$ExternalSyntheticLambda2
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$onCreate$0(i, str, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(int i, java.lang.String str, java.util.List list) {
        this.controller.onLoadLocalData((java.util.List<com.up366.mobile.common.logic.model.MyBook>) list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        this.adapter = new com.up366.mobile.me.book.MeMyBookActivityAdapter();
        this.binding.recycleView.setAdapter(this.adapter);
        this.binding.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
        this.binding.closeBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.book.MeRecommendBookActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$1(view);
            }
        });
        this.binding.appBar.addOnOffsetChangedListener(new com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener() { // from class: com.up366.mobile.me.book.MeRecommendBookActivity$$ExternalSyntheticLambda4
            public final void onOffsetChanged(com.google.android.material.appbar.AppBarLayout appBarLayout, int i) {
                this.f$0.lambda$initView$2(appBarLayout, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(android.view.View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$2(com.google.android.material.appbar.AppBarLayout appBarLayout, int i) {
        this.binding.tipLayout.setAlpha(((i * 1.0f) / ((this.binding.toolbarLayout.getHeight() - com.up366.mobile.common.utils.ScreenUtils.getStatusBarHeight(this)) - this.binding.toolbar.getHeight())) + 1.0f);
    }

    private void initController() {
        this.controller.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.me.book.MeRecommendBookActivity$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                com.up366.mobile.me.book.MeRecommendBookActivity.lambda$initController$3(list, list2);
            }
        });
        this.controller.setIsSameItem(new com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback() { // from class: com.up366.mobile.me.book.MeRecommendBookActivity$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback
            public final boolean isSame(java.lang.Object obj, java.lang.Object obj2) {
                return ((com.up366.mobile.common.logic.model.MyBook) obj).getBookId().equals(((com.up366.mobile.common.logic.model.MyBook) obj2).getBookId());
            }
        });
        this.controller.setAdapter(this.adapter);
        this.controller.setEnable(true);
    }

    static /* synthetic */ void lambda$initController$3(java.util.List list, java.util.List list2) {
        java.util.Iterator<com.up366.mobile.common.logic.model.MyBook> it = com.up366.mobile.me.book.MeBookUtil.filterPadData(list).iterator();
        while (it.hasNext()) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, it.next()));
        }
    }

    public static void openPage(android.content.Context context) {
        context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.me.book.MeRecommendBookActivity.class));
    }
}
