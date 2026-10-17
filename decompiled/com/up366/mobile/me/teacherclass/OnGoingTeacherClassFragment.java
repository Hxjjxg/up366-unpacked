package com.up366.mobile.me.teacherclass;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class OnGoingTeacherClassFragment extends com.up366.mobile.common.base.BaseFragment {
    private com.up366.mobile.me.teacherclass.TeacherClassFragmentAdapter adapter;
    private com.up366.mobile.databinding.MeTearchingClassFragmentLayoutBinding b;
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.user.setting.MeTeachingClass> controller;

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
    }

    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        this.b = (com.up366.mobile.databinding.MeTearchingClassFragmentLayoutBinding) androidx.databinding.DataBindingUtil.inflate(layoutInflater, com.up366.mobile.R.layout.me_tearching_class_fragment_layout, viewGroup, false);
        initView();
        initController();
        initAppBarRefresh();
        this.b.refreshLayout.doRefresh();
        return this.b.getRoot();
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    private void initAppBarRefresh() {
        com.up366.mobile.me.teacherclass.MeTeachingClassActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        new com.up366.mobile.common.helper.AppBarRefreshLayoutHelper().binding(activity.getBinding().appBar, this.b.refreshLayout);
    }

    private void initView() {
        this.adapter = new com.up366.mobile.me.teacherclass.TeacherClassFragmentAdapter();
        this.b.recycleView.setAdapter(this.adapter);
        this.b.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext()));
        this.b.refreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.me.teacherclass.OnGoingTeacherClassFragment$$ExternalSyntheticLambda0
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.lambda$initView$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        this.controller.loadWebData();
    }

    private void initController() {
        com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.user.setting.MeTeachingClass> uSV5ListViewDataController = new com.up366.mobile.common.base.USV5ListViewDataController<>(getContext());
        this.controller = uSV5ListViewDataController;
        uSV5ListViewDataController.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.me.teacherclass.OnGoingTeacherClassFragment$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipMessage("你还没有教学班哦~").setTipImage(com.up366.mobile.R.drawable.bg_empty_state2).build()));
            }
        });
        this.controller.setLocalLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.me.teacherclass.OnGoingTeacherClassFragment$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() {
                com.up366.mobile.common.logic.Auth.cur().teachingClassMgr().loadTeachingClass();
            }
        });
        this.controller.setWebLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.me.teacherclass.OnGoingTeacherClassFragment$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() {
                com.up366.mobile.common.logic.Auth.cur().teachingClassMgr().fetchTeachingClass();
            }
        });
        this.controller.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.me.teacherclass.OnGoingTeacherClassFragment$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                com.up366.mobile.me.teacherclass.OnGoingTeacherClassFragment.lambda$initController$4(list, list2);
            }
        });
        this.controller.setOnCompleteCallback(new com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback() { // from class: com.up366.mobile.me.teacherclass.OnGoingTeacherClassFragment$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IOnCompleteCallback
            public final void onComplete() {
                this.f$0.lambda$initController$5();
            }
        });
        this.controller.setIsSameItem(new com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback() { // from class: com.up366.mobile.me.teacherclass.OnGoingTeacherClassFragment$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IsSameItemCallback
            public final boolean isSame(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.mobile.me.teacherclass.OnGoingTeacherClassFragment.lambda$initController$6((com.up366.mobile.user.setting.MeTeachingClass) obj, (com.up366.mobile.user.setting.MeTeachingClass) obj2);
            }
        });
        this.controller.setAdapter(this.adapter);
        this.controller.setEnable(true);
    }

    static /* synthetic */ void lambda$initController$4(java.util.List list, java.util.List list2) {
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, (com.up366.mobile.user.setting.MeTeachingClass) it.next()));
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_DIVIDER_LINE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$5() {
        this.b.refreshLayout.complete();
    }

    static /* synthetic */ boolean lambda$initController$6(com.up366.mobile.user.setting.MeTeachingClass meTeachingClass, com.up366.mobile.user.setting.MeTeachingClass meTeachingClass2) {
        return meTeachingClass.getCourseId() == meTeachingClass2.getCourseId();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.MeTeachingClassRefreshEvent meTeachingClassRefreshEvent) {
        if (meTeachingClassRefreshEvent.getResp() == null) {
            this.controller.onLoadLocalData(filterData(meTeachingClassRefreshEvent.getDatas()));
        } else {
            this.controller.onLoadWebData(meTeachingClassRefreshEvent.getResp(), filterData(meTeachingClassRefreshEvent.getDatas()));
        }
    }

    private java.util.List<com.up366.mobile.user.setting.MeTeachingClass> filterData(java.util.List<com.up366.mobile.user.setting.MeTeachingClass> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list != null && list.size() != 0) {
            java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.me.teacherclass.OnGoingTeacherClassFragment$$ExternalSyntheticLambda7
                @Override // java.util.Comparator
                public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                    return java.lang.Long.compare(((com.up366.mobile.user.setting.MeTeachingClass) obj).getEndTime(), ((com.up366.mobile.user.setting.MeTeachingClass) obj2).getEndTime());
                }
            });
            for (com.up366.mobile.user.setting.MeTeachingClass meTeachingClass : list) {
                if (meTeachingClass.getStatus() < 2) {
                    arrayList.add(meTeachingClass);
                }
            }
        }
        return arrayList;
    }
}
