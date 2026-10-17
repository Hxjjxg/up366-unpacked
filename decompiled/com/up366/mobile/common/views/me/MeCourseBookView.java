package com.up366.mobile.common.views.me;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MeCourseBookView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.MeCourseViewLayoutBinding binding;
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.common.logic.model.MyBook> controller;

    static /* synthetic */ void lambda$initAttr$1() throws java.lang.Exception {
    }

    static /* synthetic */ void lambda$initAttr$2() throws java.lang.Exception {
    }

    static /* synthetic */ void lambda$initAttr$5(java.util.List list) {
    }

    public MeCourseBookView(android.content.Context context) {
        super(context);
        initAttr(context, null, 0);
    }

    public MeCourseBookView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        initAttr(context, attributeSet, 0);
    }

    public MeCourseBookView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttr(context, attributeSet, i);
    }

    private void initAttr(final android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        com.up366.mobile.databinding.MeCourseViewLayoutBinding meCourseViewLayoutBinding = (com.up366.mobile.databinding.MeCourseViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.me_course_view_layout, this, true);
        this.binding = meCourseViewLayoutBinding;
        meCourseViewLayoutBinding.courseViewTextBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.me.MeCourseBookView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.me.book.MeMyBookActivity.openPage(context);
            }
        });
        com.up366.mobile.me.book.MeHomeMyBookAdpter meHomeMyBookAdpter = new com.up366.mobile.me.book.MeHomeMyBookAdpter();
        this.binding.courseViewRecycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this.binding.courseViewRecycleView.getContext(), 0, false));
        this.binding.courseViewRecycleView.setAdapter(meHomeMyBookAdpter);
        com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.common.logic.model.MyBook> uSV5ListViewDataController = new com.up366.mobile.common.base.USV5ListViewDataController<>(getContext());
        this.controller = uSV5ListViewDataController;
        uSV5ListViewDataController.setAdapter(meHomeMyBookAdpter);
        this.controller.setLocalLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.common.views.me.MeCourseBookView$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                com.up366.mobile.common.views.me.MeCourseBookView.lambda$initAttr$1();
            }
        });
        this.controller.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.common.views.me.MeCourseBookView$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                com.up366.mobile.common.views.me.MeCourseBookView.lambda$initAttr$2();
            }
        });
        this.controller.setOnCompleteCallback(new com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback() { // from class: com.up366.mobile.common.views.me.MeCourseBookView$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback
            public final void onComplete() {
                this.f$0.lambda$initAttr$3();
            }
        });
        this.controller.setIsSameItem(new com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback() { // from class: com.up366.mobile.common.views.me.MeCourseBookView$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback
            public final boolean isSame(java.lang.Object obj, java.lang.Object obj2) {
                return ((com.up366.mobile.common.logic.model.MyBook) obj).getBookId().equals(((com.up366.mobile.common.logic.model.MyBook) obj2).getBookId());
            }
        });
        this.controller.setLoadingView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.common.views.me.MeCourseBookView$$ExternalSyntheticLambda7
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                com.up366.mobile.common.views.me.MeCourseBookView.lambda$initAttr$5(list);
            }
        });
        this.controller.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.common.views.me.MeCourseBookView$$ExternalSyntheticLambda8
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                com.up366.mobile.common.views.me.MeCourseBookView.lambda$initAttr$6(list);
            }
        });
        this.controller.setErrorView(new com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback() { // from class: com.up366.mobile.common.views.me.MeCourseBookView$$ExternalSyntheticLambda9
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetErrorDataCallback
            public final void setDatas(com.up366.common.http.Response response, java.util.List list) {
                this.f$0.lambda$initAttr$8(response, list);
            }
        });
        this.controller.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.common.views.me.MeCourseBookView$$ExternalSyntheticLambda10
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                com.up366.mobile.common.views.me.MeCourseBookView.lambda$initAttr$9(list, list2);
            }
        });
        this.controller.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initAttr$3() {
        this.binding.courseViewRecycleView.scrollToPosition(0);
    }

    static /* synthetic */ void lambda$initAttr$6(java.util.List list) {
        com.up366.common.log.Logger.error("setNoDataView: ");
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state5).setTipMessage("暂无课本~").build()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initAttr$8(com.up366.common.http.Response response, java.util.List list) {
        list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-1, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state6).setTipMessage("啊！不要啊！网络怎么可以这么差！").setRightBtn("点击重试").setRightBtnListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.me.MeCourseBookView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initAttr$7(view);
            }
        }).build()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initAttr$7(android.view.View view) {
        this.controller.loadWebData();
    }

    static /* synthetic */ void lambda$initAttr$9(java.util.List list, java.util.List list2) {
        java.util.Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, (com.up366.mobile.common.logic.model.MyBook) it.next()));
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_WIDTH_12DP, java.lang.Integer.valueOf(i)));
            i++;
        }
        if (list.size() > 4) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-10001));
        }
    }

    public void setData(com.up366.mobile.common.event.MyBookListEvent myBookListEvent) {
        if (myBookListEvent == null) {
            this.controller.onLoadWebData(new com.up366.common.http.Response(0, "", "", 0, null), new java.util.ArrayList());
            setCount(0);
            return;
        }
        java.util.List<com.up366.mobile.common.logic.model.MyBook> listFilterDataS = filterDataS(com.up366.mobile.me.book.MeBookUtil.filterPadData(myBookListEvent.books));
        if (myBookListEvent.resp != null) {
            this.controller.onLoadWebData(myBookListEvent.resp, listFilterDataS);
            setCount(myBookListEvent.resp.isError() ? 0 : myBookListEvent.books.size());
        } else {
            this.controller.onLoadWebData(new com.up366.common.http.Response(0, "", "", 0, null), listFilterDataS);
            setCount(myBookListEvent.books.size());
        }
    }

    private void setCount(int i) {
        this.binding.courseViewCountText.setText(java.lang.String.format("(%d)", java.lang.Integer.valueOf(i)));
    }

    private java.util.List<com.up366.mobile.common.logic.model.MyBook> filterDataS(java.util.List<com.up366.mobile.common.logic.model.MyBook> list) {
        if (list == null || list.size() == 0) {
            return new java.util.ArrayList();
        }
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.common.views.me.MeCourseBookView$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return java.lang.Long.compare(((com.up366.mobile.common.logic.model.MyBook) obj2).getLastStudyTime(), ((com.up366.mobile.common.logic.model.MyBook) obj).getLastStudyTime());
            }
        });
        return list.size() <= 7 ? list : list.subList(0, 7);
    }
}
