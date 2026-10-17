package com.up366.mobile.me.teacherclass;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeAddTeachingClassActivity extends com.up366.mobile.common.base.BaseActivity {
    private static final int COURSE_SCAN = 11000;
    private com.up366.mobile.databinding.MeAddTearchingClassAcivityLayoutBinding binding;
    private com.up366.mobile.main.FindCourseCodeData courseCodeData;
    private int placeHolderHight = 0;

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "user_class_join";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.binding = (com.up366.mobile.databinding.MeAddTearchingClassAcivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.me_add_tearching_class_acivity_layout);
        initView();
        java.lang.String stringExtra = getIntent().getStringExtra("courseCode");
        if (!com.up366.common.StringUtils.isEmptyOrNull(stringExtra)) {
            this.binding.searchText.setText(stringExtra);
            this.binding.searchText.setSelection(stringExtra.length());
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity$$ExternalSyntheticLambda4
                @Override // com.up366.common.task.Task
                public final void run() {
                    this.f$0.findCourse();
                }
            });
        }
        new com.up366.mobile.common.helper.SoftKeyboardChangeHelper(this.binding.getRoot()).onChange(new com.up366.mobile.common.helper.SoftKeyboardChangeHelper.IOnChangeListener() { // from class: com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity$$ExternalSyntheticLambda5
            @Override // com.up366.mobile.common.helper.SoftKeyboardChangeHelper.IOnChangeListener
            public final void onChange(boolean z, boolean z2, int i, int i2) {
                this.f$0.lambda$onCreate$0(z, z2, i, i2);
            }
        }).watch(new android.view.View[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(boolean z, boolean z2, int i, int i2) {
        if (this.placeHolderHight == 0 && i > 300) {
            ((android.widget.LinearLayout.LayoutParams) this.binding.placeHolder.getLayoutParams()).height = i;
            this.binding.placeHolder.setVisibility(0);
        }
        this.binding.placeHolder.setVisibility(z2 ? 0 : 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.up366.mobile.common.utils.ViewUtil.hideSoftInputOnTouchOutside(motionEvent, this.binding.searchText);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        this.binding.placeHolder.setVisibility(8);
    }

    private void initView() {
        com.up366.qmui.util.QMUIKeyboardHelper.showKeyboard((android.widget.EditText) this.binding.searchText, 50);
        this.binding.searchText.addTextChangedListener(new android.text.TextWatcher() { // from class: com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(android.text.Editable editable) {
                com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity.this.binding.courseInfoLayout.setVisibility(4);
                com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity.this.binding.emptyState.setVisibility(4);
                if (com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity.this.binding.searchText.getText().toString())) {
                    com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity.this.binding.searcherDeleteImage.setVisibility(4);
                } else {
                    com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity.this.binding.searcherDeleteImage.setVisibility(0);
                }
            }
        });
        this.binding.searchText.setOnKeyListener(new android.view.View.OnKeyListener() { // from class: com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(android.view.View view, int i, android.view.KeyEvent keyEvent) {
                return this.f$0.lambda$initView$1(view, i, keyEvent);
            }
        });
        this.binding.qrSearchClass.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$3(view);
            }
        });
        this.binding.searcherDeleteImage.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$4(view);
            }
        });
        this.binding.addHowGetCourse.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$5(view);
            }
        });
        this.binding.approveBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$7(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$1(android.view.View view, int i, android.view.KeyEvent keyEvent) {
        if (i != 66 || keyEvent.getAction() != 1) {
            return false;
        }
        findCourse();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$3(android.view.View view) {
        com.up366.mobile.common.utils.ViewUtil.clickView(view);
        com.up366.mobile.common.utils.PermissionUtils.checkPermission(this, new java.lang.String[]{"相机权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, getString(com.up366.mobile.R.string.permission_camera), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                this.f$0.lambda$initView$2(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$2(int i, java.lang.String str) {
        if (i == 0) {
            startActivityForResult(new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.qrcode.view.activity.CaptureActivity.class), COURSE_SCAN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$4(android.view.View view) {
        this.binding.searchText.setText("");
        com.up366.qmui.util.QMUIKeyboardHelper.hideKeyboard(this.binding.searchText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$initView$5(android.view.View view) {
        startActivity(new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.me.teacherclass.MeHowGetCourseActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$7(final android.view.View view) {
        if (com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_JOINCLASS).isInBlackList()) {
            com.up366.mobile.common.utils.AppFuncController.showTipDialog();
            return;
        }
        this.binding.approveBtn.setVisibility(4);
        this.binding.approveStatus.setVisibility(0);
        this.binding.approveStatus.setText("");
        showApproveLoading();
        this.binding.searchText.setEnabled(false);
        this.binding.qrSearchClass.setEnabled(false);
        com.up366.mobile.common.logic.Auth.cur().teachingClassMgr().courseCodeToJoinCourse(java.lang.Integer.valueOf(this.courseCodeData.getCourseId()), java.lang.Integer.valueOf(this.courseCodeData.getClassId()), new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity$$ExternalSyntheticLambda3
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$initView$6(view, response, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$6(android.view.View view, com.up366.common.http.Response response, java.lang.Object obj) {
        this.binding.searchText.setEnabled(true);
        this.binding.qrSearchClass.setEnabled(true);
        dismissApproveLoading();
        if (response.isError() && response.getCode() != 7) {
            this.binding.approveStatus.setVisibility(4);
            this.binding.approveBtn.setVisibility(0);
            if (com.up366.mobile.common.utils.ErrorMessageTool.isPoorNetwork(response)) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo(view, "加入失败：网络原因，请稍\n后重试！");
                return;
            } else {
                com.up366.mobile.common.utils.ToastPopupUtil.showError(view, response.getInfo());
                return;
            }
        }
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("course-list").invalid();
        if (this.courseCodeData.getIsApprove() == 1 || response.getCode() == 7) {
            this.binding.approveStatus.setText("等待审核");
            com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(view, "您的申请已提交，等待老师的审核");
        } else if (this.courseCodeData.getIsApprove() == 0) {
            this.binding.approveStatus.setText("已加入");
            com.up366.mobile.common.logic.Auth.cur().teachingClassMgr().fetchTeachingClass();
            com.up366.mobile.common.utils.ToastPopupUtil.showSuccess(view, "您已经加入该班级");
        }
    }

    private void showApproveLoading() {
        this.binding.approveLoading.setVisibility(0);
        this.binding.approveLoading.setImageResource(com.up366.mobile.R.drawable.icon_button_loading);
        com.up366.mobile.common.utils.AnimUtils.showAnimation(this.binding.approveLoading);
    }

    private void dismissApproveLoading() {
        this.binding.approveLoading.setImageDrawable(null);
        com.up366.mobile.common.utils.AnimUtils.cancelAnimation(this.binding.approveLoading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findCourse() {
        final androidx.appcompat.widget.AppCompatEditText appCompatEditText = this.binding.searchText;
        java.lang.String string = appCompatEditText.getText().toString();
        if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.view.View) appCompatEditText, "请先输入课程码！");
            return;
        }
        com.up366.qmui.util.QMUIKeyboardHelper.hideKeyboard(appCompatEditText);
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.view.View) appCompatEditText, "正在搜索");
        com.up366.mobile.common.logic.Auth.cur().teachingClassMgr().findCourseByCode(string, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity$$ExternalSyntheticLambda6
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$findCourse$10(appCompatEditText, response, (com.up366.mobile.main.FindCourseCodeData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$findCourse$10(android.widget.TextView textView, com.up366.common.http.Response response, com.up366.mobile.main.FindCourseCodeData findCourseCodeData) {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(textView);
        this.binding.emptyState.setVisibility(4);
        this.binding.courseInfoLayout.setVisibility(4);
        this.binding.approveBtn.setVisibility(4);
        this.binding.approveStatus.setVisibility(4);
        this.binding.approveLoading.setVisibility(4);
        if (!response.isError()) {
            this.courseCodeData = findCourseCodeData;
            this.binding.courseInfoLayout.setVisibility(0);
            this.binding.courseName.setText(findCourseCodeData.getCourseName());
            this.binding.teacherName.setText(findCourseCodeData.getLecturerName());
            if (findCourseCodeData.getApproveStatus() == 0) {
                this.binding.approveBtn.setVisibility(0);
                return;
            } else if (findCourseCodeData.getApproveStatus() == 1) {
                this.binding.approveStatus.setVisibility(0);
                this.binding.approveStatus.setText("等待审核");
                return;
            } else {
                this.binding.approveStatus.setVisibility(0);
                this.binding.approveStatus.setText("已加入");
                return;
            }
        }
        if (response.getCode() == 4) {
            this.binding.emptyState.setVisibility(0);
            this.binding.emptyState.showEmptyState(com.up366.mobile.R.drawable.bg_empty_state2, "没有找到这个班级呀");
            return;
        }
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            this.binding.emptyState.setVisibility(0);
            this.binding.emptyState.showPoorNetStateError(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$findCourse$8(view);
                }
            });
            return;
        }
        this.binding.emptyState.setVisibility(0);
        if (com.up366.common.NetworkUtilsUp.isConnected() && com.up366.mobile.common.utils.ErrorMessageTool.isPoorNetwork(response)) {
            this.binding.emptyState.showPoorNetStateError(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$findCourse$9(view);
                }
            });
            return;
        }
        this.binding.emptyState.showEmptyState(com.up366.mobile.R.drawable.bg_empty_state4, "搜索失败: " + response.getInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$findCourse$8(android.view.View view) {
        this.binding.emptyState.setVisibility(4);
        findCourse();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$findCourse$9(android.view.View view) {
        this.binding.emptyState.setVisibility(4);
        com.up366.mobile.common.utils.ViewUtil.clickView(view);
        findCourse();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == COURSE_SCAN && i2 == -1) {
            java.lang.String stringExtra = intent.getStringExtra(com.up366.qrcode.view.utils.CodeUtils.RESULT_STRING);
            if (com.up366.common.StringUtils.isEmptyOrNull(stringExtra)) {
                com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "未能识别课程码，请扫描课程的二维码");
                return;
            }
            java.lang.String courseCodeFromUrl = com.up366.mobile.jump.JumpUtils.getCourseCodeFromUrl(stringExtra);
            this.binding.searchText.setText(courseCodeFromUrl);
            if (!com.up366.common.StringUtils.isEmptyOrNull(courseCodeFromUrl)) {
                this.binding.searchText.setSelection(courseCodeFromUrl.length());
            }
            findCourse();
        }
    }

    public static void openPage(android.content.Context context) {
        context.startActivity(new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity.class));
    }

    public static void openPage(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity.class);
        intent.putExtra("courseCode", str);
        context.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.mobile.common.utils.ViewUtil.cleanSoftInput(this);
    }
}
