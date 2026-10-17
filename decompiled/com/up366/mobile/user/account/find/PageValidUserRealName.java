package com.up366.mobile.user.account.find;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageValidUserRealName {
    private final android.app.Activity activity;
    private final com.up366.mobile.databinding.AccountFindActivityValidRealNameLayoutBinding b;
    private final com.up366.mobile.user.account.find.AccountFindActivity.Config config;
    private final java.lang.String organId;
    private final java.lang.String organName;

    public PageValidUserRealName(android.app.Activity activity, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView, com.up366.mobile.user.account.find.AccountFindActivity.Config config) {
        this.activity = activity;
        this.config = config;
        this.organId = config.organId;
        this.organName = config.organName;
        collapsingToolbarLayout.setTitle("输入你的姓名");
        textView.setText(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("02").setSpan(new android.text.style.ForegroundColorSpan(activity.getResources().getColor(com.up366.mobile.R.color.c1))).append("/04").build());
        com.up366.mobile.databinding.AccountFindActivityValidRealNameLayoutBinding accountFindActivityValidRealNameLayoutBinding = (com.up366.mobile.databinding.AccountFindActivityValidRealNameLayoutBinding) androidx.databinding.DataBindingUtil.inflate(activity.getLayoutInflater(), com.up366.mobile.R.layout.account_find_activity_valid_real_name_layout, frameLayout, true);
        this.b = accountFindActivityValidRealNameLayoutBinding;
        collapsingToolbarLayout.setExpandedTitleMarginStart(accountFindActivityValidRealNameLayoutBinding.getRoot().getPaddingLeft());
        initView(activity, appBarLayout, textView);
    }

    private void initView(final android.app.Activity activity, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView) {
        this.b.tipLayout.setVisibility(4);
        this.b.edit.setOnEditActionListener(new com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener() { // from class: com.up366.mobile.user.account.find.PageValidUserRealName$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener
            public final void onSearch(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$0(activity, appEditTextView);
            }
        });
        this.b.btnNext.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.account.find.PageValidUserRealName$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$1(activity, view);
            }
        });
        this.b.edit.setOnChangeListener(new com.up366.mobile.common.views.AppEditTextView.IOnChangeListener() { // from class: com.up366.mobile.user.account.find.PageValidUserRealName$$ExternalSyntheticLambda4
            @Override // com.up366.mobile.common.views.AppEditTextView.IOnChangeListener
            public final void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
                this.f$0.lambda$initView$2(appEditTextView);
            }
        });
        com.up366.common.task.TaskUtils.postMainTaskDelay(300L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.find.PageValidUserRealName$$ExternalSyntheticLambda5
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$initView$3();
            }
        });
        if (this.config.type == 1) {
            textView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(android.app.Activity activity, com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        doValid(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(android.app.Activity activity, android.view.View view) {
        doValid(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(com.up366.mobile.common.views.AppEditTextView appEditTextView) {
        this.b.btnNext.setEnabled(this.b.edit.getTrimText().length() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$3() throws java.lang.Exception {
        this.b.edit.showSoftInput(true);
    }

    private void doValid(final android.app.Activity activity) {
        final java.lang.String trimText = this.b.edit.getTrimText();
        if (com.up366.common.StringUtils.isEmptyOrNull(trimText)) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, "请输入姓名！");
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "正在加载");
            com.up366.mobile.common.logic.Auth.mgr().fetchAccountFindClassList(this.organId, trimText, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.find.PageValidUserRealName$$ExternalSyntheticLambda0
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                    this.f$0.lambda$doValid$5(activity, trimText, response, (java.util.List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doValid$5(final android.app.Activity activity, java.lang.String str, com.up366.common.http.Response response, java.util.List list) {
        com.up366.common.log.Logger.info("TAG - PageValidUserRealName - doValid - " + response);
        this.b.tipLayout.setVisibility(4);
        if (response.getCode() == 2) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
            this.b.tipLayout.setVisibility(0);
            this.b.tip.setText("未搜索到该学生，请检查选择的学校或输入的姓名是否正确");
            return;
        }
        if (response.getCode() == 3) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
            com.up366.mobile.user.account.find.AccountFindActivity.Config configClone = this.config.m1200clone();
            configClone.page = 4;
            com.up366.mobile.user.account.find.AccountFindActivity.openPage(activity, configClone);
            return;
        }
        if (response.getCode() == 4) {
            com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
            com.up366.mobile.user.account.find.AccountFindActivity.Config configClone2 = this.config.m1200clone();
            configClone2.page = 4;
            com.up366.mobile.user.account.find.AccountFindActivity.openPage(activity, configClone2);
            com.up366.common.log.Logger.info("TAG - PageValidUserRealName - doValid - 您的账号暂时无法通过该方式找回");
            return;
        }
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, response);
            return;
        }
        this.config.realName = str;
        if (list.size() == 1) {
            final com.up366.mobile.common.logic.model.AccountClassInfo accountClassInfo = (com.up366.mobile.common.logic.model.AccountClassInfo) list.get(0);
            com.up366.mobile.common.logic.Auth.mgr().fetchAccountUserList(accountClassInfo.getClassId(), str, new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.account.find.PageValidUserRealName$$ExternalSyntheticLambda1
                @Override // com.up366.common.callback.ICallbackResponse
                public final void onResult(com.up366.common.http.Response response2, java.lang.Object obj) {
                    this.f$0.lambda$doValid$4(activity, accountClassInfo, response2, (java.util.List) obj);
                }
            });
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        com.up366.mobile.user.account.find.AccountFindActivity.Config configClone3 = this.config.m1200clone();
        configClone3.page = 3;
        com.up366.mobile.common.logic.Auth.mgr().cache().putMemorySync("classList", list, 3600000L);
        com.up366.mobile.user.account.find.AccountFindActivity.openPage(activity, configClone3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doValid$4(android.app.Activity activity, com.up366.mobile.common.logic.model.AccountClassInfo accountClassInfo, com.up366.common.http.Response response, java.util.List list) {
        if (response.isError()) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(activity, response);
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        com.up366.mobile.common.logic.Auth.mgr().cache().clear("classList");
        com.up366.mobile.common.logic.Auth.mgr().cache().putMemorySync("classMateNames", list, 3600000L);
        com.up366.mobile.user.account.find.AccountFindActivity.Config configClone = this.config.m1200clone();
        configClone.page = 5;
        configClone.classId = accountClassInfo.getClassId();
        configClone.className = accountClassInfo.getClassName();
        com.up366.mobile.user.account.find.AccountFindActivity.openPage(activity, configClone);
    }
}
