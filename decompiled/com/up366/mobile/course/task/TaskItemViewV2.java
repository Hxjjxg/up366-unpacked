package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskItemViewV2 extends android.widget.LinearLayout {
    com.up366.mobile.databinding.TaskItemLayoutV2Binding binding;
    private final com.up366.mobile.course.task.TakePhotoAnswerUploadStatusHelper helper;
    private com.up366.mobile.common.dialog.DialogLoadingXiaoTian loadingDialog;
    private com.up366.mobile.course.task.TaskInfoV2 mTaskInfo;

    static /* synthetic */ void lambda$onMessageEvent$20(android.view.View view) {
    }

    static /* synthetic */ void lambda$showNoDownUrlTipDialog$18(android.view.View view) {
    }

    public TaskItemViewV2(android.content.Context context) {
        super(context);
        this.helper = new com.up366.mobile.course.task.TakePhotoAnswerUploadStatusHelper();
        init();
    }

    private void init() {
        this.binding = (com.up366.mobile.databinding.TaskItemLayoutV2Binding) androidx.databinding.DataBindingUtil.inflate(((android.app.Activity) getContext()).getLayoutInflater(), com.up366.mobile.R.layout.task_item_layout_v2, this, true);
        setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.onlineAnswer, new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$0(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.taskReport, new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$3(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.takePhotoBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$4(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.retryTakePhotoBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.skipTakePhoto(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.downloadPaper, new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$6(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.answerReview, new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$9(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(android.view.View view) {
        if (!this.mTaskInfo.isHasStart() && this.mTaskInfo.isTimingTask()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(this, "该练习还未开始，请在开始后作答");
        } else if (!this.mTaskInfo.isHasStart() && !this.mTaskInfo.isTimingTask()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(this, "完成以上练习才可以解锁该练习哦");
        } else {
            com.up366.mobile.course.task.TaskJumpHelper.jumpToDetailTaskPage(getContext(), this.mTaskInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$2(com.up366.common.http.Response response, final com.up366.mobile.course.task.model.ReportTypeResult reportTypeResult) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda8
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$init$1(reportTypeResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$3(android.view.View view) {
        fetchReportUrl(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda15
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$init$2(response, (com.up366.mobile.course.task.model.ReportTypeResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$1(com.up366.mobile.course.task.model.ReportTypeResult reportTypeResult) throws java.lang.Exception {
        if (com.up366.common.StringUtils.isEmptyOrNull(reportTypeResult.getMobileUrl())) {
            com.up366.mobile.course.task.TaskJumpHelper.jumpToTaskReport(getContext(), this.mTaskInfo);
        } else {
            skipReportUrl(this.mTaskInfo, reportTypeResult.getMobileUrl());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$4(android.view.View view) {
        if (!this.mTaskInfo.isHasStart() && this.mTaskInfo.isTimingTask()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(this, "该练习还未开始，请在开始后作答");
        } else if (!this.mTaskInfo.isHasStart() && !this.mTaskInfo.isTimingTask()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(this, "完成以上练习才可以解锁该练习哦");
        } else {
            skipTakePhoto(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$6(final android.view.View view) {
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            downloadPaper((android.app.Activity) view.getContext());
        } else {
            com.up366.mobile.common.utils.PermissionUtils.checkPermission(view.getContext(), new java.lang.String[]{"存储权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.WRITE_EXTERNAL_STORAGE}, com.up366.mobile.common.utils.ViewUtil.getString(com.up366.mobile.R.string.permission_storage), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda5
                @Override // com.up366.common.callback.ICallbackCodeInfo
                public final void onResult(int i, java.lang.String str) {
                    this.f$0.lambda$init$5(view, i, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$5(android.view.View view, int i, java.lang.String str) {
        if (i == 0) {
            downloadPaper((android.app.Activity) view.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$8(com.up366.common.http.Response response, final com.up366.mobile.course.task.model.ReportTypeResult reportTypeResult) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$init$7(reportTypeResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$9(android.view.View view) {
        fetchReportUrl(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda18
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$init$8(response, (com.up366.mobile.course.task.model.ReportTypeResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$7(com.up366.mobile.course.task.model.ReportTypeResult reportTypeResult) throws java.lang.Exception {
        if (com.up366.common.StringUtils.isEmptyOrNull(reportTypeResult.getMobileUrl()) || reportTypeResult.getAppSupportRedirect() == 0) {
            com.up366.mobile.course.task.TaskJumpHelper.jumpToDetailTaskPage(getContext(), this.mTaskInfo);
        } else {
            skipReportUrl(this.mTaskInfo, reportTypeResult.getMobileUrl());
        }
    }

    private void fetchReportUrl(final com.up366.common.callback.ICallbackResponse<com.up366.mobile.course.task.model.ReportTypeResult> iCallbackResponse) {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(this.binding.taskReport, "加载中");
        com.up366.mobile.course.task.model.ReportTypeParams reportTypeParams = new com.up366.mobile.course.task.model.ReportTypeParams();
        reportTypeParams.setType("studytask");
        reportTypeParams.setCourseId(this.mTaskInfo.getCourseId());
        reportTypeParams.setStudyTaskId(this.mTaskInfo.getJobId());
        reportTypeParams.setScope("student");
        com.up366.mobile.common.logic.Auth.cur().taskMgr().fetchReportType(reportTypeParams, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda17
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$fetchReportUrl$10(iCallbackResponse, response, (com.up366.mobile.course.task.model.ReportTypeResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchReportUrl$10(com.up366.common.callback.ICallbackResponse iCallbackResponse, com.up366.common.http.Response response, com.up366.mobile.course.task.model.ReportTypeResult reportTypeResult) {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(this.binding.taskReport);
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("网络异常，请重试");
        } else {
            iCallbackResponse.onResult(response, reportTypeResult);
        }
    }

    private void skipReportUrl(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent(getContext(), (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("target", com.up366.common.global.GB.get().getServerUrl(str));
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, jSONObject.toJSONString());
        intent.putExtra("exercise_type", com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.REDIRECT);
        com.up366.mobile.common.onlinelog.OpLogData.INSTANCE.addBehavior(taskInfoV2, intent, true, true);
        getContext().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void skipTakePhoto(final android.view.View view) {
        if (this.mTaskInfo.getExtParam().isDisableStuPhotoAnswer()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this, "当前练习老师已设置为扫描批改\n不允许拍照作答");
            return;
        }
        com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.setTaskInfo(this.mTaskInfo);
        com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("takePhoto-answer-start", this.mTaskInfo.getJobId()));
        if (this.helper.hasUploadingTask(this.mTaskInfo)) {
            com.up366.mobile.common.dialog.AppDialog.create(view.getContext()).title("你已完成试卷拍照可以直接提交哦~").message("重新拍照会清除上次记录").left("重新拍照", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view2) {
                    this.f$0.lambda$skipTakePhoto$11(view2);
                }
            }).right("直接提交", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view2) {
                    this.f$0.lambda$skipTakePhoto$12(view2);
                }
            }).show();
            return;
        }
        java.lang.String returnCode = this.mTaskInfo.getReturnCode();
        if (!com.up366.mobile.course.task.dialog.TaskReturnDialogHelper.INSTANCE.isNeedShowReturnDialog(returnCode)) {
            skipPhotoAnswerGuide((android.app.Activity) view.getContext(), this.mTaskInfo);
        } else {
            com.up366.mobile.course.task.dialog.TaskReturnDialogHelper.INSTANCE.showReturnDialog(getContext(), returnCode, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda14
                @Override // com.up366.common.callback.ICallbackCodeInfo
                public final void onResult(int i, java.lang.String str) {
                    this.f$0.lambda$skipTakePhoto$14(view, i, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$skipTakePhoto$11(android.view.View view) {
        skipPhotoAnswerGuide((android.app.Activity) view.getContext(), this.mTaskInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$skipTakePhoto$12(android.view.View view) {
        submit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$skipTakePhoto$14(android.view.View view, int i, java.lang.String str) {
        if (i == 1) {
            com.up366.mobile.course.task.TaskJumpHelper.jumpToDetailTaskPage(getContext(), this.mTaskInfo);
        } else {
            skipPhotoAnswerGuide((android.app.Activity) view.getContext(), this.mTaskInfo);
        }
    }

    private void skipPhotoAnswerGuide(final android.app.Activity activity, final com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        com.up366.mobile.common.utils.PermissionUtils.checkPermission(activity, new java.lang.String[]{"相机权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, com.up366.mobile.common.utils.ViewUtil.getString(com.up366.mobile.R.string.permission_camera), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda11
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                com.up366.mobile.course.task.TaskItemViewV2.lambda$skipPhotoAnswerGuide$15(activity, taskInfoV2, i, str);
            }
        });
    }

    static /* synthetic */ void lambda$skipPhotoAnswerGuide$15(android.app.Activity activity, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, int i, java.lang.String str) {
        if (i == 0) {
            com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.openPage(activity, taskInfoV2);
        }
    }

    private void downloadPaper(final android.app.Activity activity) {
        final java.lang.String fileMd5 = this.mTaskInfo.getExtParam().getFileMd5();
        if (com.up366.common.StringUtils.isEmptyOrNull(fileMd5)) {
            showNoDownUrlTipDialog();
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(this.binding.downloadPaper, "加载中");
            com.up366.mobile.common.logic.Auth.cur().taskMgr().fetchDownUrl(fileMd5, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda19
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    this.f$0.lambda$downloadPaper$17(fileMd5, activity, response, (java.lang.String) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadPaper$17(java.lang.String str, android.app.Activity activity, com.up366.common.http.Response response, java.lang.String str2) {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(this.binding.downloadPaper);
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("网络异常，请重试");
            return;
        }
        if (com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            showNoDownUrlTipDialog();
            return;
        }
        java.lang.String str3 = this.mTaskInfo.getJobName() + ".pdf";
        java.lang.String str4 = "拍照作答时间截止到" + com.up366.common.TimeUtils.formatTime(this.mTaskInfo.getEndTime(), "MM-dd HH:mm");
        com.up366.mobile.common.onlinelog.OpLog.record("taskDownloadPaper", this.mTaskInfo.getExtParam().getBookId() + com.igexin.push.core.b.an + str);
        new com.up366.mobile.common.dialog.ShareDialog(activity, new java.lang.Integer[]{1, 3}).shareUrl("先导出，再打印\n请使用A4纸打印，确保纸上的二维码等内容完整", str3, str4, str2, new com.umeng.socialize.media.UMImage(activity, com.up366.mobile.R.drawable.icon_pdf), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda9
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str5) {
                com.up366.mobile.course.task.TaskItemViewV2.lambda$downloadPaper$16(i, str5);
            }
        });
    }

    static /* synthetic */ void lambda$downloadPaper$16(int i, java.lang.String str) {
        if (i == 0) {
            return;
        }
        if (i == -105) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("分享失败！请前往设置页面打开“存储”权限");
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.show(str);
        }
    }

    private void showNoDownUrlTipDialog() {
        com.up366.mobile.common.dialog.AppTipDialog.create(getContext()).image(com.up366.mobile.R.drawable.bg_empty_state10, com.up366.common.DpUtilsUp.dp2px(200.0f), com.up366.common.DpUtilsUp.dp2px(200.0f)).message("试卷文件出错，请联系助教老师").btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.task.TaskItemViewV2.lambda$showNoDownUrlTipDialog$18(view);
            }
        }).show();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    private void submit() {
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("提交失败，请先连接网络");
            return;
        }
        com.up366.mobile.common.dialog.DialogLoadingXiaoTian dialogLoadingXiaoTian = new com.up366.mobile.common.dialog.DialogLoadingXiaoTian(getContext());
        this.loadingDialog = dialogLoadingXiaoTian;
        dialogLoadingXiaoTian.showCloseBtn();
        this.loadingDialog.setMessage("获取上次记录，提交中").show();
        com.up366.common.task.TaskUtils.postMainTaskDelay(200L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda16
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$submit$19();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$submit$19() throws java.lang.Exception {
        this.helper.submit(this.mTaskInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTaskInfo(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        boolean z;
        int i;
        this.mTaskInfo = taskInfoV2;
        com.up366.mobile.common.utils.ViewUtil.gone(this.binding.taskTopRightMokao, this.binding.taskTopRightWeizuoda, this.binding.taskTopRightShangchuanshibai, this.binding.taskJiJiangJieZhi, this.binding.taskTopRightWeikaishi, this.binding.taskScore, this.binding.taskReport, this.binding.newSubmit, this.binding.lock, this.binding.tvUseTime, this.binding.downloadPaper, this.binding.answerReview, this.binding.takePhotoBtn, this.binding.retryTakePhotoBtn, this.binding.tvHomeworkClassName, this.binding.returnErrorTip);
        this.binding.endTime.setText(com.up366.common.TimeUtils.formatTime(taskInfoV2.getBeginTime(), "MM-dd HH:mm") + " - " + com.up366.common.TimeUtils.formatTime(taskInfoV2.getEndTime(), "MM-dd HH:mm"));
        android.widget.TextView textView = this.binding.tvHomeworkClassName;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("班级: ");
        sb.append(this.mTaskInfo.getCourseName());
        textView.setText(sb.toString());
        java.lang.String secondTime = com.up366.mobile.common.utils.TimeUtilsApp.formatSecondTime(taskInfoV2.getExtParam().getTestDuration());
        this.binding.tvUseTime.setText("预计用时" + secondTime);
        this.binding.taskName.setText(getJobName());
        this.binding.taskScore.setText(getScoreText());
        if (!this.mTaskInfo.isHasStart()) {
            this.binding.taskName.setTextColor(-6378817);
            this.binding.onlineAnswer.setTextColor(-6378817);
            this.binding.takePhotoBtn.setTextColor(-6378817);
            this.binding.downloadPaper.setTextColor(-6378817);
            this.binding.downloadPaper.setTextColor(com.up366.mobile.R.drawable.btn_gray_background_25);
            this.binding.onlineAnswer.setBackgroundResource(com.up366.mobile.R.drawable.btn_gray_background_25);
            this.binding.takePhotoBtn.setBackgroundResource(com.up366.mobile.R.drawable.btn_gray_background_25);
        } else {
            this.binding.taskName.setTextColor(-13421773);
            this.binding.onlineAnswer.setTextColor(-13665796);
            android.widget.TextView textView2 = this.binding.onlineAnswer;
            int i2 = com.up366.mobile.R.drawable.btn_eaf2ff_background_25_round_shape;
            textView2.setBackgroundResource(com.up366.mobile.R.drawable.btn_eaf2ff_background_25_round_shape);
            this.binding.downloadPaper.setTextColor(-13665796);
            this.binding.downloadPaper.setBackgroundResource(com.up366.mobile.R.drawable.btn_eaf2ff_background_25_round_shape);
            boolean zIsDisableStuPhotoAnswer = this.mTaskInfo.getExtParam().isDisableStuPhotoAnswer();
            this.binding.takePhotoBtn.setBackgroundResource(zIsDisableStuPhotoAnswer ? 2131231057 : com.up366.mobile.R.drawable.btn_blue_background_25_2f79fc);
            this.binding.takePhotoBtn.setTextColor(-1);
            android.widget.TextView textView3 = this.binding.retryTakePhotoBtn;
            if (zIsDisableStuPhotoAnswer) {
                i2 = 2131231057;
            }
            textView3.setBackgroundResource(i2);
            this.binding.retryTakePhotoBtn.setTextColor(zIsDisableStuPhotoAnswer ? -1 : -13665796);
        }
        boolean z2 = !com.up366.common.StringUtils.isEmptyOrNull(this.mTaskInfo.getCourseName());
        boolean z3 = (com.up366.common.StringUtils.isEmptyOrNull(secondTime) || this.mTaskInfo.isHistory()) ? false : true;
        boolean z4 = this.mTaskInfo.getUploadStatus() == -1;
        boolean z5 = this.mTaskInfo.getType() == 11;
        boolean zIsHistoryNoAnswer = this.mTaskInfo.isHistoryNoAnswer();
        boolean zIsShowScore = isShowScore(this.mTaskInfo);
        boolean z6 = (this.mTaskInfo.isHasStart() || this.mTaskInfo.isTimingTask()) ? false : true;
        boolean z7 = !this.mTaskInfo.isHasStart() && this.mTaskInfo.isTimingTask();
        boolean z8 = this.mTaskInfo.getEndTime() - 7200000 < com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() && !this.mTaskInfo.isHistory();
        boolean z9 = this.mTaskInfo.getExtParam().canOnlineAnswer() && !this.mTaskInfo.isHistory();
        boolean z10 = this.mTaskInfo.getExtParam().canTakePhotoAnswer() && !this.mTaskInfo.isHistory();
        boolean z11 = this.mTaskInfo.getExtParam().canTakePhotoAnswer() && this.mTaskInfo.getExtParam().canReTest() && this.mTaskInfo.isHistory();
        boolean z12 = this.mTaskInfo.getExtParam().canDownload() && !this.mTaskInfo.isHistory();
        boolean zIsHistory = this.mTaskInfo.isHistory();
        boolean zIsHistory2 = this.mTaskInfo.isHistory();
        boolean z13 = z9;
        boolean z14 = this.mTaskInfo.isNewSubmit() && this.mTaskInfo.isHistory();
        boolean zIsNeedShowReturnDialog = com.up366.mobile.course.task.dialog.TaskReturnDialogHelper.INSTANCE.isNeedShowReturnDialog(this.mTaskInfo.getReturnCode());
        android.widget.LinearLayout linearLayout = this.binding.classLayout;
        if (z3 || z2) {
            z = zIsNeedShowReturnDialog;
            i = 0;
        } else {
            z = zIsNeedShowReturnDialog;
            i = 8;
        }
        linearLayout.setVisibility(i);
        this.binding.tvHomeworkClassName.setVisibility(z2 ? 0 : 4);
        this.binding.taskJiJiangJieZhi.setVisibility(z8 ? 0 : 8);
        this.binding.taskTopRightShangchuanshibai.setVisibility(z4 ? 0 : 8);
        this.binding.taskTopRightMokao.setVisibility(z5 ? 0 : 8);
        this.binding.taskTopRightWeizuoda.setVisibility(zIsHistoryNoAnswer ? 0 : 8);
        this.binding.taskScore.setVisibility(zIsShowScore ? 0 : 8);
        this.binding.lock.setVisibility(z6 ? 0 : 8);
        this.binding.taskTopRightWeikaishi.setVisibility(z7 ? 0 : 8);
        this.binding.newSubmit.setVisibility(z14 ? 0 : 8);
        this.binding.tvUseTime.setVisibility(z3 ? 0 : 8);
        this.binding.downloadPaper.setVisibility(z12 ? 0 : 8);
        this.binding.answerReview.setVisibility(zIsHistory ? 0 : 8);
        this.binding.retryTakePhotoBtn.setVisibility(z11 ? 0 : 8);
        this.binding.takePhotoBtn.setVisibility(z10 ? 0 : 8);
        this.binding.taskReport.setVisibility(zIsHistory2 ? 0 : 8);
        this.binding.onlineAnswer.setVisibility(z13 ? 0 : 8);
        this.binding.returnErrorTip.setVisibility(z ? 0 : 8);
    }

    private boolean isShowScore(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        int type = taskInfoV2.getType();
        if (type == 3 || type == 1 || type == 11) {
            return !com.up366.common.StringUtils.isEmptyOrNull(getScoreText());
        }
        return false;
    }

    private android.text.SpannableString getJobName() {
        java.lang.String str;
        if (this.mTaskInfo.getType() != 4 && this.mTaskInfo.getType() != 5) {
            return new android.text.SpannableString(this.mTaskInfo.getJobName());
        }
        java.lang.String jobName = this.mTaskInfo.getJobName();
        if (com.up366.common.StringUtils.isEmptyOrNull(this.mTaskInfo.getExtParam().getBookId()) || "0".equals(this.mTaskInfo.getExtParam().getBookId())) {
            if (this.mTaskInfo.getType() == 4) {
                jobName = "请前往消灭错题";
            } else {
                jobName = "请前往消灭生词";
            }
        }
        int length = jobName.length();
        if (this.mTaskInfo.getType() == 4) {
            str = jobName + " #记得及时清空错题本哦#";
        } else {
            str = jobName + " #记得及时清空生词本哦#";
        }
        android.text.SpannableString spannableString = new android.text.SpannableString(str);
        spannableString.setSpan(new android.text.style.StyleSpan(1), 0, length, 33);
        spannableString.setSpan(new android.text.style.AbsoluteSizeSpan(com.up366.common.DpUtilsUp.sp2px(14.0f)), length, str.length(), 33);
        return spannableString;
    }

    private java.lang.String getScoreText() {
        int taskPublishType = this.mTaskInfo.getExtParam().getTaskPublishType(this.mTaskInfo.getType());
        int taskPublishedStatus = this.mTaskInfo.getExtParam().getTaskPublishedStatus(this.mTaskInfo.getType());
        if (taskPublishType == 3 && taskPublishedStatus == 0) {
            return "";
        }
        if (taskPublishType == 2 && this.mTaskInfo.getEndTime() > com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()) {
            return "";
        }
        if (this.mTaskInfo.isHistory() && this.mTaskInfo.getMarkStatus() == 2) {
            return "批阅中";
        }
        return this.mTaskInfo.getJobScore();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.CommonUploadLogEvent commonUploadLogEvent) {
        if (commonUploadLogEvent.getRefKey().equals(this.mTaskInfo.getJobId())) {
            if (this.loadingDialog == null) {
                if (commonUploadLogEvent.isSuccess()) {
                    com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent(this.mTaskInfo.getContentId(), this.mTaskInfo.getJobId());
                }
            } else {
                if (commonUploadLogEvent.isProgressUpdate()) {
                    this.loadingDialog.showProgress(commonUploadLogEvent.getPercent());
                    return;
                }
                if (commonUploadLogEvent.isFailed()) {
                    this.loadingDialog.dismiss();
                    this.loadingDialog = null;
                    com.up366.mobile.common.dialog.AppDialog.create(getContext()).title("网络异常！提交失败").message(this.mTaskInfo.getJobName()).left("取消", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            com.up366.mobile.course.task.TaskItemViewV2.lambda$onMessageEvent$20(view);
                        }
                    }).right("重新提交", new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.task.TaskItemViewV2$$ExternalSyntheticLambda7
                        @Override // android.view.View.OnClickListener
                        public final void onClick(android.view.View view) {
                            this.f$0.lambda$onMessageEvent$21(view);
                        }
                    }).show();
                } else if (commonUploadLogEvent.isSuccess()) {
                    this.loadingDialog.dismiss();
                    this.loadingDialog = null;
                    com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent(this.mTaskInfo.getContentId(), this.mTaskInfo.getJobId());
                    com.up366.mobile.course.photoanswer.PhotoAnswerSubmitSuccessActivity.INSTANCE.startActivity(getContext());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessageEvent$21(android.view.View view) {
        submit();
    }
}
