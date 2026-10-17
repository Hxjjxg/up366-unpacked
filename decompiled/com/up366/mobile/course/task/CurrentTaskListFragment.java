package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class CurrentTaskListFragment extends com.up366.mobile.common.base.BaseFragment {
    private com.up366.mobile.databinding.FragmentHomeworkListBinding binding;
    private com.up366.mobile.common.views.viewmodel.EmptyViewModel noDataModel;
    private com.up366.mobile.course.mgr.CourseInfo selectCourse;
    private com.up366.mobile.course.task.TaskViewModel viewModel;
    private com.up366.mobile.course.task.TaskAdapter adapter = new com.up366.mobile.course.task.TaskAdapter();
    private boolean curSortTypeIsUp = true;

    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        this.viewModel = (com.up366.mobile.course.task.TaskViewModel) new androidx.lifecycle.ViewModelProvider(requireActivity()).get(com.up366.mobile.course.task.TaskViewModel.class);
        this.binding = (com.up366.mobile.databinding.FragmentHomeworkListBinding) androidx.databinding.DataBindingUtil.inflate(layoutInflater, com.up366.mobile.R.layout.fragment_homework_list, viewGroup, false);
        initData();
        this.binding.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext()));
        this.binding.recycleView.setAdapter(this.adapter);
        this.binding.pullRefresh.setContentView(this.binding.recycleView);
        this.binding.pullRefresh.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.course.task.CurrentTaskListFragment$$ExternalSyntheticLambda2
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.lambda$onCreateView$0();
            }
        });
        initObserver();
        return this.binding.getRoot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0() {
        this.viewModel.refreshTaskData(true);
    }

    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getActivity() != null) {
            getActivity().setPullRecyclerView(this.binding.pullRefresh, this.binding.recycleView);
        }
    }

    private void initData() {
        this.noDataModel = new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state5).setTipMessage("还没有收到练习哎,快去自主练习吧").build();
        this.selectCourse = new com.up366.mobile.course.mgr.CourseInfo(-1, "全部");
    }

    private void initObserver() {
        this.viewModel.getNetErrorLiveData().observe(requireActivity(), new androidx.lifecycle.Observer() { // from class: com.up366.mobile.course.task.CurrentTaskListFragment$$ExternalSyntheticLambda4
            public final void onChanged(java.lang.Object obj) {
                this.f$0.lambda$initObserver$1((com.up366.common.http.Response) obj);
            }
        });
        this.viewModel.getCurrentTasksLiveData().observe(requireActivity(), new androidx.lifecycle.Observer() { // from class: com.up366.mobile.course.task.CurrentTaskListFragment$$ExternalSyntheticLambda5
            public final void onChanged(java.lang.Object obj) {
                this.f$0.lambda$initObserver$2((java.util.List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initObserver$1(com.up366.common.http.Response response) {
        notifyNetError(response.getCode(), response.getInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initObserver$2(java.util.List list) {
        showCurrentTask(com.up366.mobile.course.task.TaskFilterHelper.filterByCourseInfo(list, this.selectCourse));
    }

    public void updateTaskList() {
        this.viewModel.refreshTaskData(false);
    }

    public void notifyNetError(int i, java.lang.String str) {
        java.lang.String string;
        androidx.fragment.app.FragmentActivity activity;
        this.binding.pullRefresh.complete();
        com.up366.common.http.Response response = new com.up366.common.http.Response();
        response.setCode(i);
        response.setInfo(str);
        if (this.adapter.getDatas().isEmpty() || this.adapter.getDatas().get(0).viewType == 3) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder tipImage = new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipImage(com.up366.mobile.R.drawable.bg_empty_state6);
            if (com.up366.mobile.common.utils.ErrorMessageTool.isPoorNetwork(response)) {
                string = getString(com.up366.mobile.R.string.poor_network_state_tip);
            } else {
                string = getString(com.up366.mobile.R.string.server_error);
            }
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-1, tipImage.setTipMessage(string).setLeftBtn(getString(com.up366.mobile.R.string.see_help)).setLeftBtnListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.CurrentTaskListFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$notifyNetError$3(view);
                }
            }).setRightBtn(getString(com.up366.mobile.R.string.click_retry)).setRightBtnListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.CurrentTaskListFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$notifyNetError$4(view);
                }
            }).build()));
            this.adapter.reset();
            this.adapter.lambda$setDatas$0(arrayList);
            return;
        }
        if (!getLifecycle().getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.RESUMED) || (activity = getActivity()) == null) {
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) activity, com.up366.mobile.common.utils.ErrorMessageTool.convert(response));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyNetError$3(android.view.View view) {
        if (getActivity() != null) {
            com.up366.mobile.commonui.LookHelpActivity.openPage(getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyNetError$4(android.view.View view) {
        this.binding.pullRefresh.doRefresh();
    }

    public void showTaskByCourse() {
        if (getContext() == null) {
            return;
        }
        com.up366.mobile.common.helper.BottomSheetHelper bottomSheetHelper = new com.up366.mobile.common.helper.BottomSheetHelper(getContext());
        bottomSheetHelper.setTitle("选择班级");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel = new com.up366.mobile.common.views.bottomsheet.BottomSheetModel();
        com.up366.mobile.course.mgr.CourseInfo courseInfo = new com.up366.mobile.course.mgr.CourseInfo(-1, "全部");
        bottomSheetModel.setContent(courseInfo.getCourseName());
        bottomSheetModel.setData(courseInfo);
        if (this.selectCourse.getCourseId() == courseInfo.getCourseId()) {
            bottomSheetModel.setSelected(true);
        }
        arrayList.add(bottomSheetModel);
        for (com.up366.mobile.course.mgr.CourseInfo courseInfo2 : this.viewModel.getCourseInfos()) {
            com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel2 = new com.up366.mobile.common.views.bottomsheet.BottomSheetModel();
            bottomSheetModel2.setContent(courseInfo2.getCourseName());
            bottomSheetModel2.setData(courseInfo2);
            if (this.selectCourse.getCourseId() == courseInfo2.getCourseId()) {
                bottomSheetModel2.setSelected(true);
            }
            arrayList.add(bottomSheetModel2);
        }
        bottomSheetHelper.setContents(arrayList);
        bottomSheetHelper.setItemClickListener(new com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener() { // from class: com.up366.mobile.course.task.CurrentTaskListFragment$$ExternalSyntheticLambda3
            @Override // com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener
            public final void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel3) {
                this.f$0.lambda$showTaskByCourse$5(qMUIBottomSheet, bottomSheetModel3);
            }
        });
        bottomSheetHelper.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showTaskByCourse$5(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel) {
        com.up366.mobile.course.mgr.CourseInfo courseInfo = (com.up366.mobile.course.mgr.CourseInfo) bottomSheetModel.getData();
        this.selectCourse = courseInfo;
        this.viewModel.setCurrentCourseLiveDataValue(courseInfo);
        showFilterTasks();
    }

    private void showFilterTasks() {
        if (this.selectCourse.getCourseId() == -1) {
            showCurrentTask((java.util.List) this.viewModel.getCurrentTasksLiveData().getValue());
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (this.viewModel.getCurrentTasksLiveData().getValue() != null) {
            for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : (java.util.List) this.viewModel.getCurrentTasksLiveData().getValue()) {
                if (taskInfoV2.getCourseId() == this.selectCourse.getCourseId()) {
                    arrayList.add(taskInfoV2);
                }
            }
        }
        showCurrentTask(arrayList);
    }

    private void showCurrentTask(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        this.viewModel.filterTasksBySearch((com.up366.mobile.course.task.TaskActivity) getActivity(), list);
        this.binding.pullRefresh.complete();
        com.up366.common.log.Logger.info("CurrentTaskListFragment showCurrentTask tasks size = " + list.size());
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list == null || list.isEmpty()) {
            this.viewModel.getCurrentTaskNumber().postValue(0);
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, this.noDataModel));
            this.adapter.reset();
            this.adapter.lambda$setDatas$0(arrayList);
            return;
        }
        this.viewModel.getCurrentTaskNumber().postValue(java.lang.Integer.valueOf(list.size()));
        java.util.List<com.up366.mobile.course.task.TaskInfoV2> listSortTaskList = com.up366.mobile.course.task.TaskDataHelper.sortTaskList(list, this.curSortTypeIsUp);
        java.lang.String str = "";
        boolean z = false;
        java.lang.String str2 = "";
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : listSortTaskList) {
            java.lang.String time = com.up366.common.TimeUtils.formatTime(taskInfoV2.getBeginTime(), "yyyy");
            if (!android.text.TextUtils.equals(str, time)) {
                arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(7));
                arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(8, time));
                str = time;
            }
            java.lang.String time2 = com.up366.common.TimeUtils.formatTime(taskInfoV2.getBeginTime(), "MM-dd");
            if (!android.text.TextUtils.equals(str2, time2)) {
                arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_12DP));
                arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(5, time2, listSortTaskList));
                arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(7));
                str2 = time2;
            }
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, taskInfoV2));
            if (!z && !taskInfoV2.isTimingTask() && taskInfoV2.getBeginTime() > com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() && taskInfoV2.isHasStart()) {
                z = true;
            }
        }
        if (z) {
            arrayList.add(0, new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(6));
        }
        arrayList.add(0, new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(7));
        arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_12DP));
        this.adapter.reset();
        this.adapter.lambda$setDatas$0(arrayList);
    }

    public void showSort() {
        if (getContext() == null) {
            return;
        }
        com.up366.mobile.common.helper.BottomSheetHelper bottomSheetHelper = new com.up366.mobile.common.helper.BottomSheetHelper(getContext());
        bottomSheetHelper.setTitle("【当前】排序规则");
        bottomSheetHelper.setTitleMarginStart(com.up366.common.DpUtilsUp.dp2px(8.0f));
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel = new com.up366.mobile.common.views.bottomsheet.BottomSheetModel();
        bottomSheetModel.setContent("按开始时间正序（推荐）");
        bottomSheetModel.setData(true);
        bottomSheetModel.setSelected(this.curSortTypeIsUp);
        com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel2 = new com.up366.mobile.common.views.bottomsheet.BottomSheetModel();
        bottomSheetModel2.setContent("按开始时间倒序");
        bottomSheetModel2.setData(false);
        bottomSheetModel2.setSelected(true ^ this.curSortTypeIsUp);
        arrayList.add(bottomSheetModel);
        arrayList.add(bottomSheetModel2);
        bottomSheetHelper.setContents(arrayList);
        bottomSheetHelper.setItemClickListener(new com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener() { // from class: com.up366.mobile.course.task.CurrentTaskListFragment$$ExternalSyntheticLambda6
            @Override // com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener
            public final void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel3) {
                this.f$0.lambda$showSort$6(qMUIBottomSheet, bottomSheetModel3);
            }
        });
        bottomSheetHelper.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSort$6(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel) {
        this.curSortTypeIsUp = ((java.lang.Boolean) bottomSheetModel.getData()).booleanValue();
        showFilterTasks();
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onResume() {
        super.onResume();
        if (isVisible()) {
            com.up366.mobile.course.task.TaskActivity activity = getActivity();
            if (activity instanceof com.up366.mobile.course.task.TaskActivity) {
                activity.reportEnterPage(0);
            }
        }
    }
}
