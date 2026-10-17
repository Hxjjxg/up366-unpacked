package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class InterestSelectCourseDialog {
    public static final java.lang.String CACHE_KEY = "InterestSelectCourseActivity-sel-course";
    public static final int TYPE_FROM_COURSE = 0;
    public static final int TYPE_FROM_SETTING = 1;
    private com.up366.mobile.common.dialog.InterestSelectCourseDialog.Adapter adapter;
    private com.up366.mobile.databinding.InterestSelectCourseActivityLayoutBinding b;
    private final android.app.Activity context;
    private com.up366.mobile.common.base.USV5ListViewDataController<com.up366.mobile.course.mgr.CourseInfo> controller;
    private java.util.List<com.up366.mobile.course.mgr.CourseInfo> courseList;
    private com.up366.mobile.common.dialog.BaseDialog dialog;
    private com.up366.mobile.course.mgr.CourseInfo currentChecked = null;
    private com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.course.mgr.CourseInfo> checkListener = new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.common.dialog.InterestSelectCourseDialog$$ExternalSyntheticLambda0
        @Override // com.up366.common.callback.ICallbackCodeInfoObj
        public final void onResult(int i, java.lang.String str, java.lang.Object obj) {
            this.f$0.lambda$new$0(i, str, (com.up366.mobile.course.mgr.CourseInfo) obj);
        }
    };
    private boolean hasConfirm = false;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface FromType {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(int i, java.lang.String str, com.up366.mobile.course.mgr.CourseInfo courseInfo) {
        this.currentChecked = courseInfo;
        this.controller.refresh();
    }

    public InterestSelectCourseDialog(android.app.Activity activity) {
        this.context = activity;
        this.controller = new com.up366.mobile.common.base.USV5ListViewDataController<>(activity);
    }

    public void show(final int i, final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.course.mgr.CourseInfo> iCallbackCodeInfoObj) {
        this.dialog = createDialog();
        initView(i);
        com.up366.mobile.common.logic.Auth.cur().cache().load(CACHE_KEY, com.up366.mobile.course.mgr.CourseInfo.class, new com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache() { // from class: com.up366.mobile.common.dialog.InterestSelectCourseDialog$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.logic.AppCacheMgr.ICallbackCache
            public final void onLoad(java.lang.Object obj) {
                this.f$0.lambda$show$1((com.up366.mobile.course.mgr.CourseInfo) obj);
            }
        });
        this.dialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.dialog.InterestSelectCourseDialog$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                this.f$0.lambda$show$2(iCallbackCodeInfoObj, dialogInterface);
            }
        });
        com.up366.mobile.common.logic.Auth.cur().course().loadCourseList(new com.up366.common.callback.ICallbackCodeInfoObj() { // from class: com.up366.mobile.common.dialog.InterestSelectCourseDialog$$ExternalSyntheticLambda6
            @Override // com.up366.common.callback.ICallbackCodeInfoObj
            public final void onResult(int i2, java.lang.String str, java.lang.Object obj) {
                this.f$0.lambda$show$3(i, iCallbackCodeInfoObj, i2, str, (java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$1(com.up366.mobile.course.mgr.CourseInfo courseInfo) {
        this.currentChecked = courseInfo;
        this.controller.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$2(com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, android.content.DialogInterface dialogInterface) {
        iCallbackCodeInfoObj.onResult(this.hasConfirm ? 0 : -1, null, this.currentChecked);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$3(int i, com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, int i2, java.lang.String str, java.util.List list) {
        if (i == 0) {
            if (list.size() == 0) {
                com.up366.mobile.course.mgr.CourseInfo courseInfo = new com.up366.mobile.course.mgr.CourseInfo();
                courseInfo.setCourseId(-1);
                iCallbackCodeInfoObj.onResult(0, null, courseInfo);
                return;
            } else if (list.size() == 1) {
                iCallbackCodeInfoObj.onResult(0, null, (com.up366.mobile.course.mgr.CourseInfo) list.get(0));
                return;
            }
        }
        this.courseList = list;
        initController();
        this.dialog.show();
    }

    private void initView(int i) {
        this.adapter = new com.up366.mobile.common.dialog.InterestSelectCourseDialog.Adapter();
        if (i == 0) {
            this.b.tip.setText(com.up366.mobile.R.string.interest_select_course_tip_course);
        }
        if (i == 1) {
            this.b.tip.setText(com.up366.mobile.R.string.interest_select_course_tip_setting);
        }
        this.b.titleBack.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.InterestSelectCourseDialog$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$4(view);
            }
        });
        this.b.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this.context));
        this.b.recycleView.setAdapter(this.adapter);
        this.b.btnOk.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.InterestSelectCourseDialog$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$5(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4(android.view.View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$5(android.view.View view) {
        com.up366.mobile.course.mgr.CourseInfo courseInfo = new com.up366.mobile.course.mgr.CourseInfo();
        courseInfo.setCourseId(this.currentChecked.getCourseId());
        courseInfo.setCourseCode(this.currentChecked.getCourseCode());
        courseInfo.setCourseName(this.currentChecked.getCourseName());
        courseInfo.setIsShelf(this.currentChecked.getIsShelf());
        courseInfo.setOrganId(this.currentChecked.getOrganId());
        courseInfo.setStageId(this.currentChecked.getStageId());
        courseInfo.setSubjectId(this.currentChecked.getSubjectId());
        courseInfo.setDisplayOrder(this.currentChecked.getDisplayOrder());
        courseInfo.setIsGoods(this.currentChecked.getIsGoods());
        com.up366.mobile.common.logic.Auth.cur().cache().put(CACHE_KEY, courseInfo, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MONTH_6);
        this.hasConfirm = true;
        this.dialog.dismiss();
    }

    private void initController() {
        final com.up366.mobile.common.views.viewmodel.EmptyViewModel emptyViewModelBuild = new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setType(3).setTipImage(com.up366.mobile.R.drawable.bg_empty_state3).setTipMessage("暂未找到该学校").build();
        this.controller.setNoDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback() { // from class: com.up366.mobile.common.dialog.InterestSelectCourseDialog$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetDataCallback
            public final void setDatas(java.util.List list) {
                list.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, emptyViewModelBuild));
            }
        });
        this.controller.setLocalLoader(new com.up366.mobile.common.base.BaseListViewDataController.IDataLoader() { // from class: com.up366.mobile.common.dialog.InterestSelectCourseDialog$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.base.BaseListViewDataController.IDataLoader
            public final void load() throws java.lang.Exception {
                this.f$0.lambda$initController$7();
            }
        });
        this.controller.setDataView(new com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback() { // from class: com.up366.mobile.common.dialog.InterestSelectCourseDialog$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.base.BaseListViewDataController.ISetRealDataCallback
            public final void setDatas(java.util.List list, java.util.List list2) {
                this.f$0.lambda$initController$8(list, list2);
            }
        });
        this.controller.setAdapter(this.adapter);
        this.controller.setEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$7() throws java.lang.Exception {
        this.controller.onLoadLocalData(this.courseList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initController$8(java.util.List list, java.util.List list2) {
        this.b.btnOk.setEnabled(this.currentChecked != null);
        for (int i = 0; i < list.size(); i++) {
            com.up366.mobile.course.mgr.CourseInfo courseInfo = (com.up366.mobile.course.mgr.CourseInfo) list.get(i);
            courseInfo.setCheck(this.currentChecked != null && courseInfo.getCourseId() == this.currentChecked.getCourseId());
            list2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, courseInfo));
        }
    }

    public static void openPage(android.app.Activity activity) {
        android.content.Intent intent = new android.content.Intent(activity.getIntent());
        intent.setClass(activity, com.up366.mobile.common.dialog.InterestSelectCourseDialog.class);
        activity.startActivity(intent);
    }

    private class Adapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
        private Adapter() {
        }

        public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.common.views.InterestSelectCourseItemView(viewGroup.getContext()));
            }
            return defaultHandler(viewGroup, i);
        }

        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
            com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
            if (dataHolder.viewType == 1) {
                ((com.up366.mobile.common.views.InterestSelectCourseItemView) viewHolder.itemView).setData((com.up366.mobile.course.mgr.CourseInfo) dataHolder.o, com.up366.mobile.common.dialog.InterestSelectCourseDialog.this.checkListener);
            } else {
                defaultHandler(viewHolder, i);
            }
        }
    }

    private com.up366.mobile.common.dialog.BaseDialog createDialog() {
        com.up366.mobile.common.dialog.BaseDialog baseDialog = new com.up366.mobile.common.dialog.BaseDialog(this.context, com.up366.mobile.R.style.LargeDialog_White);
        com.up366.mobile.databinding.InterestSelectCourseActivityLayoutBinding interestSelectCourseActivityLayoutBinding = (com.up366.mobile.databinding.InterestSelectCourseActivityLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(this.context), com.up366.mobile.R.layout.interest_select_course_activity_layout, (android.view.ViewGroup) null, false);
        this.b = interestSelectCourseActivityLayoutBinding;
        baseDialog.create(interestSelectCourseActivityLayoutBinding.getRoot());
        return baseDialog;
    }
}
