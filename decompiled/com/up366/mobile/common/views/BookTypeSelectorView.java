package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookTypeSelectorView extends com.up366.mobile.common.views.PaddingShadowLayout {
    private com.up366.mobile.databinding.BookTypeSelectorViewLayoutBinding binding;
    private android.content.Context context;
    private com.up366.mobile.market.GoodsCategory selStage;
    private android.util.SparseArray<com.up366.mobile.market.GoodsCategory> subSelMap;

    public BookTypeSelectorView(android.content.Context context) {
        super(context);
        this.subSelMap = new android.util.SparseArray<>();
        init(context);
    }

    public BookTypeSelectorView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.subSelMap = new android.util.SparseArray<>();
        init(context);
    }

    public BookTypeSelectorView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.subSelMap = new android.util.SparseArray<>();
        init(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) {
            return;
        }
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (isInEditMode()) {
            return;
        }
        com.up366.common.EventBusUtilsUp.unregister(this);
        if (this.selStage != null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.selStage.getCategoryId());
            sb.append("\n");
            for (int i = 0; i < this.subSelMap.size(); i++) {
                sb.append(this.subSelMap.keyAt(i));
                sb.append(":");
                sb.append(this.subSelMap.valueAt(i).getCategoryId());
                sb.append("\n");
            }
            com.up366.mobile.common.utils.PreferenceUtils.putString(com.up366.mobile.common.logic.Auth.getUserInfo().getUid() + "book_type_selector_view", sb.toString());
        }
    }

    private void init(android.content.Context context) {
        this.context = context;
        if (isInEditMode()) {
            android.view.View.inflate(context, com.up366.mobile.R.layout.book_type_selector_view_layout, this);
            return;
        }
        com.up366.mobile.databinding.BookTypeSelectorViewLayoutBinding bookTypeSelectorViewLayoutBinding = (com.up366.mobile.databinding.BookTypeSelectorViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(((android.app.Activity) context).getLayoutInflater(), com.up366.mobile.R.layout.book_type_selector_view_layout, this, true);
        this.binding = bookTypeSelectorViewLayoutBinding;
        bookTypeSelectorViewLayoutBinding.tagGroup.removeAllViews();
        this.binding.tabIndicator.removeAllViews();
        initData();
    }

    private void initData() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.BookTypeSelectorView$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initData$0();
            }
        });
        com.up366.mobile.common.logic.Auth.cur().book().fetchGoodsCategoryList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$0() throws java.lang.Exception {
        java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString(com.up366.mobile.common.logic.Auth.getUserInfo().getUid() + "book_type_selector_view", null);
        if (string != null) {
            java.lang.String[] strArrSplit = string.trim().split("\\n");
            com.up366.mobile.market.GoodsCategory goodsCategory = new com.up366.mobile.market.GoodsCategory();
            this.selStage = goodsCategory;
            goodsCategory.setCategoryId(java.lang.Integer.valueOf(strArrSplit[0]).intValue());
            for (int i = 1; i < strArrSplit.length; i++) {
                java.lang.String[] strArrSplit2 = strArrSplit[i].split(":");
                com.up366.mobile.market.GoodsCategory goodsCategory2 = new com.up366.mobile.market.GoodsCategory();
                goodsCategory2.setCategoryId(java.lang.Integer.valueOf(strArrSplit2[1]).intValue());
                this.subSelMap.put(java.lang.Integer.valueOf(strArrSplit2[0]).intValue(), goodsCategory2);
            }
            return;
        }
        if (com.up366.mobile.common.logic.Auth.isAuth()) {
            com.up366.mobile.market.GoodsCategory goodsCategory3 = new com.up366.mobile.market.GoodsCategory();
            this.selStage = goodsCategory3;
            goodsCategory3.setCategoryId(com.up366.mobile.common.logic.Auth.getUserInfo().getSchoolType());
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.AuthLoginSuccess authLoginSuccess) {
        initData();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(final com.up366.mobile.common.event.GoodsCategoryListRefresh goodsCategoryListRefresh) {
        com.up366.common.task.Task task = new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.BookTypeSelectorView$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onMessageEvent$3(goodsCategoryListRefresh);
            }
        };
        if (this.subSelMap.size() == 0) {
            com.up366.common.task.TaskUtils.postMainTask(task);
        } else {
            com.up366.common.task.TaskUtils.postLazyTaskMain("BookStageTypeRefresh", task);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$3(com.up366.mobile.common.event.GoodsCategoryListRefresh goodsCategoryListRefresh) throws java.lang.Exception {
        android.view.LayoutInflater layoutInflaterFrom = android.view.LayoutInflater.from(getContext());
        java.util.List<com.up366.mobile.market.GoodsCategory> types = goodsCategoryListRefresh.getTypes();
        java.util.Collections.sort(types, new java.util.Comparator() { // from class: com.up366.mobile.common.views.BookTypeSelectorView$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.mobile.common.views.BookTypeSelectorView.lambda$onMessageEvent$1((com.up366.mobile.market.GoodsCategory) obj, (com.up366.mobile.market.GoodsCategory) obj2);
            }
        });
        java.util.ArrayList<com.up366.mobile.market.GoodsCategory> arrayList = new java.util.ArrayList();
        for (com.up366.mobile.market.GoodsCategory goodsCategory : types) {
            if (goodsCategory.getLevel() == 0) {
                arrayList.add(goodsCategory);
            }
        }
        for (com.up366.mobile.market.GoodsCategory goodsCategory2 : types) {
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((com.up366.mobile.market.GoodsCategory) it.next()).add(goodsCategory2);
            }
        }
        this.binding.tabIndicator.removeAllViews();
        for (final com.up366.mobile.market.GoodsCategory goodsCategory3 : arrayList) {
            android.widget.RadioButton radioButton = (android.widget.RadioButton) layoutInflaterFrom.inflate(com.up366.mobile.R.layout.book_type_selector_view_layout_stage_item, (android.view.ViewGroup) this.binding.tabIndicator, false);
            this.binding.tabIndicator.addView(radioButton);
            radioButton.setTag(goodsCategory3);
            radioButton.setText(goodsCategory3.getCategoryName());
            radioButton.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() { // from class: com.up366.mobile.common.views.BookTypeSelectorView$$ExternalSyntheticLambda1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
                    this.f$0.lambda$onMessageEvent$2(goodsCategory3, compoundButton, z);
                }
            });
            com.up366.mobile.market.GoodsCategory goodsCategory4 = this.selStage;
            if (goodsCategory4 == null || goodsCategory4.getCategoryId() == goodsCategory3.getCategoryId()) {
                radioButton.setChecked(true);
            }
        }
        if (this.binding.tabIndicator.getCheckedRadioButtonId() != -1 || this.binding.tabIndicator.getChildCount() <= 0) {
            return;
        }
        ((android.widget.RadioButton) this.binding.tabIndicator.getChildAt(0)).setChecked(true);
    }

    static /* synthetic */ int lambda$onMessageEvent$1(com.up366.mobile.market.GoodsCategory goodsCategory, com.up366.mobile.market.GoodsCategory goodsCategory2) {
        return goodsCategory.getDisplayOrder() - goodsCategory2.getDisplayOrder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$2(com.up366.mobile.market.GoodsCategory goodsCategory, android.widget.CompoundButton compoundButton, boolean z) {
        if (z) {
            this.selStage = goodsCategory;
            showChilds();
        }
    }

    private void showChilds() {
        java.util.List<com.up366.mobile.market.GoodsCategory> childs = this.selStage.getChilds();
        android.view.LayoutInflater layoutInflaterFrom = android.view.LayoutInflater.from(getContext());
        com.up366.mobile.market.GoodsCategory goodsCategory = this.subSelMap.get(this.selStage.getCategoryId());
        this.binding.tagGroup.removeAllViews();
        for (final com.up366.mobile.market.GoodsCategory goodsCategory2 : childs) {
            android.widget.RadioButton radioButton = (android.widget.RadioButton) layoutInflaterFrom.inflate(com.up366.mobile.R.layout.book_type_item_layout, (android.view.ViewGroup) this.binding.tagGroup, false);
            this.binding.tagGroup.addView(radioButton);
            radioButton.setTag(goodsCategory2);
            radioButton.setText(goodsCategory2.getCategoryName());
            radioButton.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() { // from class: com.up366.mobile.common.views.BookTypeSelectorView$$ExternalSyntheticLambda4
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
                    this.f$0.lambda$showChilds$4(goodsCategory2, compoundButton, z);
                }
            });
            if (goodsCategory == null) {
                radioButton.setChecked(true);
                goodsCategory = goodsCategory2;
            } else if (goodsCategory2.getCategoryId() == goodsCategory.getCategoryId()) {
                radioButton.setChecked(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showChilds$4(com.up366.mobile.market.GoodsCategory goodsCategory, android.widget.CompoundButton compoundButton, boolean z) {
        if (z) {
            this.subSelMap.put(this.selStage.getCategoryId(), goodsCategory);
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.RefreshRecommendList(this.selStage, goodsCategory));
        }
    }
}
