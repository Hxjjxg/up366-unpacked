package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class HistoryTaskListFragment extends com.up366.mobile.common.base.BaseFragment {
    private static final int REQUEST_CODE_FILTER_CONDITION = 100;
    private com.up366.mobile.databinding.FragmentHistoryTaskListBinding binding;
    private com.up366.mobile.common.views.viewmodel.EmptyViewModel noDataModel;
    private com.up366.mobile.course.task.TaskViewModel viewModel;
    private com.up366.mobile.course.task.TaskAdapter adapter = new com.up366.mobile.course.task.TaskAdapter();
    private com.up366.mobile.commonui.condition.ConditionModel filterCondition = null;
    private final com.up366.mobile.commonui.condition.ConditionModel initFilterCondition = new com.up366.mobile.commonui.condition.ConditionModel();
    private boolean onlyUnanswered = false;
    private boolean historySortTypeIsUp = false;

    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        this.viewModel = (com.up366.mobile.course.task.TaskViewModel) new androidx.lifecycle.ViewModelProvider(requireActivity()).get(com.up366.mobile.course.task.TaskViewModel.class);
        this.binding = (com.up366.mobile.databinding.FragmentHistoryTaskListBinding) androidx.databinding.DataBindingUtil.inflate(layoutInflater, com.up366.mobile.R.layout.fragment_history_task_list, viewGroup, false);
        initData();
        initView();
        initObserver();
        return this.binding.getRoot();
    }

    private void initView() {
        this.binding.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext()));
        this.binding.recycleView.setAdapter(this.adapter);
        this.binding.pullRefresh.setContentView(this.binding.recycleView);
        this.binding.pullRefresh.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.course.task.HistoryTaskListFragment$$ExternalSyntheticLambda4
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                this.f$0.fetchDataFromNet();
            }
        });
    }

    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getActivity() != null) {
            getActivity().setPullRecyclerView(this.binding.pullRefresh, this.binding.recycleView);
        }
    }

    private void initData() {
        this.initFilterCondition.setCourseId(-1);
        this.initFilterCondition.setTimeType(4);
        this.initFilterCondition.setShowBookList(true);
    }

    public void showTaskByCondition() {
        android.content.Intent intent = new android.content.Intent((android.content.Context) requireActivity(), (java.lang.Class<?>) com.up366.mobile.commonui.condition.ConditionActivity.class);
        intent.putExtra(com.up366.mobile.commonui.condition.ConditionActivity.INTENT_KEY_CONDITION_FROM, 2);
        com.up366.mobile.commonui.condition.ConditionModel conditionModel = this.filterCondition;
        if (conditionModel == null) {
            conditionModel = this.initFilterCondition;
        }
        conditionModel.setBeginTimeStr("选择练习开始时间");
        conditionModel.setResetBeginTime(this.initFilterCondition.getResetBeginTime());
        conditionModel.setResetEndTime(this.initFilterCondition.getResetEndTime());
        if (conditionModel.getBeginTime() == 0) {
            conditionModel.setBeginTime(com.up366.mobile.common.utils.TimeUtilsApp.getMonthStartTime(java.lang.Long.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond())).longValue());
            conditionModel.setEndTime(com.up366.mobile.common.utils.TimeUtilsApp.getMonthEndTime(java.lang.Long.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond())).longValue());
        }
        intent.putExtra(com.up366.mobile.commonui.condition.ConditionActivity.INTENT_KEY_CONDITION_MODEL, conditionModel);
        startActivityForResult(intent, 100, null);
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            com.up366.mobile.commonui.condition.ConditionModel conditionModel = (com.up366.mobile.commonui.condition.ConditionModel) intent.getSerializableExtra(com.up366.mobile.commonui.condition.ConditionActivity.INTENT_KEY_CONDITION_RESULT);
            if (conditionModel.getBeginTime() >= getBeforeThreeMonthTime()) {
                this.filterCondition = conditionModel;
                showHistoryTask(com.up366.mobile.course.task.TaskFilterHelper.filterByCondition((java.util.List) this.viewModel.getHistoryTasksLiveData().getValue(), this.filterCondition));
                return;
            }
            if (this.filterCondition == null) {
                this.filterCondition = conditionModel;
                this.binding.pullRefresh.doRefresh();
            } else if (conditionModel.getBeginTime() == this.filterCondition.getBeginTime() && conditionModel.getEndTime() == this.filterCondition.getEndTime()) {
                this.filterCondition = conditionModel;
                showHistoryTask(com.up366.mobile.course.task.TaskFilterHelper.filterByCondition((java.util.List) this.viewModel.getHistoryTasksByTimeLiveData().getValue(), this.filterCondition));
            } else {
                this.filterCondition = conditionModel;
                this.binding.pullRefresh.doRefresh();
            }
        }
    }

    private void initObserver() {
        this.viewModel.getHistoryTasksLiveData().observe(requireActivity(), new androidx.lifecycle.Observer() { // from class: com.up366.mobile.course.task.HistoryTaskListFragment$$ExternalSyntheticLambda0
            public final void onChanged(java.lang.Object obj) {
                this.f$0.lambda$initObserver$0((java.util.List) obj);
            }
        });
        this.viewModel.getHistoryTasksByTimeLiveData().observe(requireActivity(), new androidx.lifecycle.Observer() { // from class: com.up366.mobile.course.task.HistoryTaskListFragment$$ExternalSyntheticLambda1
            public final void onChanged(java.lang.Object obj) {
                this.f$0.lambda$initObserver$1((java.util.List) obj);
            }
        });
        this.viewModel.getHistoryNetErrorLiveData().observe(requireActivity(), new androidx.lifecycle.Observer() { // from class: com.up366.mobile.course.task.HistoryTaskListFragment$$ExternalSyntheticLambda2
            public final void onChanged(java.lang.Object obj) {
                this.f$0.lambda$initObserver$2((com.up366.common.http.Response) obj);
            }
        });
        this.viewModel.getNetErrorLiveData().observe(requireActivity(), new androidx.lifecycle.Observer() { // from class: com.up366.mobile.course.task.HistoryTaskListFragment$$ExternalSyntheticLambda3
            public final void onChanged(java.lang.Object obj) {
                this.f$0.lambda$initObserver$3((com.up366.common.http.Response) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initObserver$1(java.util.List list) {
        showHistoryTask(com.up366.mobile.course.task.TaskFilterHelper.filterByCondition(list, this.filterCondition));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initObserver$2(com.up366.common.http.Response response) {
        showNetError(response.getCode(), response.getInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initObserver$3(com.up366.common.http.Response response) {
        showNetError(response.getCode(), response.getInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fetchDataFromNet() {
        com.up366.mobile.commonui.condition.ConditionModel conditionModel = this.filterCondition;
        if (conditionModel == null || conditionModel.getBeginTime() >= getBeforeThreeMonthTime()) {
            this.viewModel.refreshTaskData(true);
        } else {
            this.viewModel.getTaskByTime(this.filterCondition.getBeginTime(), this.filterCondition.getEndTime());
        }
    }

    public void updateTaskList() {
        this.viewModel.refreshTaskData(false);
    }

    private void showNetError(int i, java.lang.String str) {
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
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-1, tipImage.setTipMessage(string).setLeftBtn(getString(com.up366.mobile.R.string.see_help)).setLeftBtnListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.HistoryTaskListFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showNetError$4(view);
                }
            }).setRightBtn(getString(com.up366.mobile.R.string.click_retry)).setRightBtnListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.HistoryTaskListFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showNetError$5(view);
                }
            }).build()));
            this.adapter.reset();
            this.adapter.lambda$setDatas$0(arrayList);
            return;
        }
        if (this.adapter.getDatas().get(0).viewType == -1 || !getLifecycle().getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.RESUMED) || (activity = getActivity()) == null) {
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) activity, com.up366.mobile.common.utils.ErrorMessageTool.convert(response));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNetError$4(android.view.View view) {
        if (getActivity() != null) {
            com.up366.mobile.commonui.LookHelpActivity.openPage(getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNetError$5(android.view.View view) {
        this.binding.pullRefresh.doRefresh();
    }

    private void showHistoryTask(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        this.viewModel.filterTasksBySearch((com.up366.mobile.course.task.TaskActivity) getActivity(), list);
        this.binding.pullRefresh.complete();
        if (this.onlyUnanswered) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (list != null) {
                for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : list) {
                    if (taskInfoV2.isHistoryNoAnswer()) {
                        arrayList.add(taskInfoV2);
                    }
                }
            }
            list = arrayList;
        }
        if (list == null || list.isEmpty()) {
            showNoDataItem();
            return;
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.List<com.up366.mobile.course.task.TaskInfoV2> listSortTaskList = com.up366.mobile.course.task.TaskDataHelper.sortTaskList(list, this.historySortTypeIsUp);
        java.lang.String str = "";
        java.lang.String str2 = "";
        for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV22 : listSortTaskList) {
            java.lang.String time = com.up366.common.TimeUtils.formatTime(taskInfoV22.getBeginTime(), "yyyy");
            if (!android.text.TextUtils.equals(str, time)) {
                arrayList2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(7));
                arrayList2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(8, time));
                str = time;
            }
            java.lang.String time2 = com.up366.common.TimeUtils.formatTime(taskInfoV22.getBeginTime(), "MM-dd");
            if (!android.text.TextUtils.equals(str2, time2)) {
                arrayList2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_12DP));
                arrayList2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(5, time2, listSortTaskList));
                arrayList2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(7));
                str2 = time2;
            }
            arrayList2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, taskInfoV22));
        }
        arrayList2.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(com.up366.mobile.common.base.USV5RecyclerAdapter.TYPE_SPACE_12DP));
        this.adapter.reset();
        this.adapter.lambda$setDatas$0(arrayList2);
        this.binding.recycleView.scrollToPosition(0);
    }

    private void showNoDataItem() {
        this.noDataModel = new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setTipMessage(this.onlyUnanswered ? "暂无未作答练习~" : "没有作答记录哎，快去做练习吧！").setTipImage(this.onlyUnanswered ? com.up366.mobile.R.drawable.bg_empty_state9 : com.up366.mobile.R.drawable.bg_empty_state5).build();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3, this.noDataModel));
        this.adapter.reset();
        this.adapter.lambda$setDatas$0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: mergeDataByCondition, reason: merged with bridge method [inline-methods] */
    public void lambda$initObserver$0(java.util.List<com.up366.mobile.course.task.TaskInfoV2> list) {
        com.up366.mobile.commonui.condition.ConditionModel conditionModel = this.filterCondition;
        if (conditionModel == null) {
            this.initFilterCondition.setBeginTime(0L);
            showHistoryTask(com.up366.mobile.course.task.TaskFilterHelper.filterByCondition(list, this.initFilterCondition));
            return;
        }
        if (conditionModel.getBeginTime() >= getBeforeThreeMonthTime()) {
            showHistoryTask(com.up366.mobile.course.task.TaskFilterHelper.filterByCondition(list, this.filterCondition));
            return;
        }
        if (getBeforeThreeMonthTime() < this.filterCondition.getEndTime()) {
            java.util.List<com.up366.mobile.course.task.TaskInfoV2> list2 = (java.util.List) this.viewModel.getHistoryTasksByTimeLiveData().getValue();
            if (list2 == null || list2.isEmpty()) {
                showHistoryTask(com.up366.mobile.course.task.TaskFilterHelper.filterByCondition(list, this.filterCondition));
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(list);
            for (com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 : list2) {
                java.util.Iterator it = arrayList.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    if (android.text.TextUtils.equals(((com.up366.mobile.course.task.TaskInfoV2) it.next()).getJobId(), taskInfoV2.getJobId())) {
                        z = true;
                    }
                }
                if (!z) {
                    arrayList.add(taskInfoV2);
                }
            }
            showHistoryTask(com.up366.mobile.course.task.TaskFilterHelper.filterByCondition(arrayList, this.filterCondition));
        }
    }

    private long getBeforeThreeMonthTime() {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.add(2, -2);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public void showSort() {
        if (getContext() == null) {
            return;
        }
        com.up366.mobile.common.helper.BottomSheetHelper bottomSheetHelper = new com.up366.mobile.common.helper.BottomSheetHelper(getContext());
        bottomSheetHelper.setTitle("【历史】排序规则");
        bottomSheetHelper.setTitleMarginStart(com.up366.common.DpUtilsUp.dp2px(8.0f));
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel = new com.up366.mobile.common.views.bottomsheet.BottomSheetModel();
        bottomSheetModel.setContent("按开始时间正序");
        bottomSheetModel.setData(true);
        bottomSheetModel.setSelected(this.historySortTypeIsUp);
        com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel2 = new com.up366.mobile.common.views.bottomsheet.BottomSheetModel();
        bottomSheetModel2.setContent("按开始时间倒序（推荐）");
        bottomSheetModel2.setData(false);
        bottomSheetModel2.setSelected(true ^ this.historySortTypeIsUp);
        arrayList.add(bottomSheetModel);
        arrayList.add(bottomSheetModel2);
        bottomSheetHelper.setContents(arrayList);
        bottomSheetHelper.setItemClickListener(new com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener() { // from class: com.up366.mobile.course.task.HistoryTaskListFragment$$ExternalSyntheticLambda7
            @Override // com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener
            public final void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel3) {
                this.f$0.lambda$showSort$6(qMUIBottomSheet, bottomSheetModel3);
            }
        });
        bottomSheetHelper.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSort$6(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel) {
        this.historySortTypeIsUp = ((java.lang.Boolean) bottomSheetModel.getData()).booleanValue();
        lambda$initObserver$0((java.util.List) this.viewModel.getHistoryTasksLiveData().getValue());
    }

    public void showOnlyUnanswered(boolean z) {
        this.onlyUnanswered = z;
        lambda$initObserver$0((java.util.List) this.viewModel.getHistoryTasksLiveData().getValue());
    }

    @Override // com.up366.mobile.common.base.BaseFragment
    public void onResume() {
        super.onResume();
        if (isVisible()) {
            com.up366.mobile.course.task.TaskActivity activity = getActivity();
            if (activity instanceof com.up366.mobile.course.task.TaskActivity) {
                activity.reportEnterPage(1);
            }
        }
    }
}
