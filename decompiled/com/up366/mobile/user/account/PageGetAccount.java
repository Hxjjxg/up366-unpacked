package com.up366.mobile.user.account;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageGetAccount {
    private com.up366.mobile.databinding.AccountActivityGetAccountLayoutBinding b;

    public PageGetAccount(final com.up366.mobile.user.account.AccountActivity accountActivity, androidx.core.widget.NestedScrollView nestedScrollView, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout) {
        collapsingToolbarLayout.setTitle("如何获取账号？");
        com.up366.mobile.databinding.AccountActivityGetAccountLayoutBinding accountActivityGetAccountLayoutBinding = (com.up366.mobile.databinding.AccountActivityGetAccountLayoutBinding) androidx.databinding.DataBindingUtil.inflate(accountActivity.getLayoutInflater(), com.up366.mobile.R.layout.account_activity_get_account_layout, nestedScrollView, true);
        this.b = accountActivityGetAccountLayoutBinding;
        accountActivityGetAccountLayoutBinding.text1.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        this.b.text2.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        this.b.text1.setText(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("老师会给同学们发放账号，如果还没有接收到账号请尝试").append("点此查找").setSpan(new android.text.style.ClickableSpan() { // from class: com.up366.mobile.user.account.PageGetAccount.1
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
                com.up366.mobile.user.account.find.AccountFindActivity.Config config = new com.up366.mobile.user.account.find.AccountFindActivity.Config();
                config.type = 0;
                config.page = 0;
                com.up366.mobile.user.account.find.AccountFindActivity.openPage(accountActivity, config);
            }
        }).build());
        this.b.text2.setText(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("您可以采用").append("手机号注册").setSpan(new com.up366.mobile.user.account.PageGetAccount.AnonymousClass2(accountActivity)).append("账号").build());
    }

    /* JADX INFO: renamed from: com.up366.mobile.user.account.PageGetAccount$2, reason: invalid class name */
    class AnonymousClass2 extends android.text.style.ClickableSpan {
        final /* synthetic */ com.up366.mobile.user.account.AccountActivity val$activity;

        AnonymousClass2(com.up366.mobile.user.account.AccountActivity accountActivity) {
            this.val$activity = accountActivity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(android.view.View view) {
            com.up366.mobile.user.account.PageGetAccount.this.b.text2.setEnabled(false);
            com.up366.common.task.TaskUtils.postMainTaskDelay(1000L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.account.PageGetAccount$2$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$onClick$0();
                }
            });
            com.up366.mobile.user.account.register.AccountRegisterActivity.open(this.val$activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onClick$0() throws java.lang.Exception {
            com.up366.mobile.user.account.PageGetAccount.this.b.text2.setEnabled(true);
        }
    }
}
