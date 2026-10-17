package com.up366.mobile.user.account.find;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AccountFindActivity extends com.up366.mobile.common.base.BaseActivity {
    public static final int PAGE_CAN_NOT_FIND_ACCOUNT = 4;
    public static final int PAGE_FIND_SUCCESS = 6;
    public static final int PAGE_SEARCH_SCHOOL = 1;
    public static final int PAGE_SELECT_CITY = 0;
    public static final int PAGE_SELECT_CLASS = 3;
    public static final int PAGE_VALID_CLASSMATES = 5;
    public static final int PAGE_VALID_REAL_NAME = 2;
    public static final int TYPE_FIND = 0;
    public static final int TYPE_LOGIN_BY_STUDENT_NUMBER = 1;
    private com.up366.mobile.databinding.AccountFindActivityLayoutBinding b;
    public com.up366.mobile.user.account.find.AccountFindActivity.Config config;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface ConfigType {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface PageType {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.b = (com.up366.mobile.databinding.AccountFindActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.account_find_activity_layout);
        int intExtra = getIntent().getIntExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, 0);
        this.config = (com.up366.mobile.user.account.find.AccountFindActivity.Config) getIntent().getSerializableExtra("config");
        com.up366.common.log.Logger.info("TAG - AccountFindActivity - onCreate - page : " + intExtra);
        switch (intExtra) {
            case 0:
                this.currentPageName = "login_city_list";
                new com.up366.mobile.user.account.find.PageSelectCity(this, this.b.content, this.b.toolbarLayout, this.b.appBar, this.b.close, this.config);
                break;
            case 1:
                this.currentPageName = "login_choose_school";
                new com.up366.mobile.user.account.find.PageSearchSchool(this, this.b.content, this.b.toolbarLayout, this.b.appBar, this.b.pager, this.b.close, this.config);
                break;
            case 2:
                new com.up366.mobile.user.account.find.PageValidUserRealName(this, this.b.content, this.b.toolbarLayout, this.b.appBar, this.b.pager, this.config);
                break;
            case 3:
                new com.up366.mobile.user.account.find.PageSelectClass(this, this.b.content, this.b.toolbarLayout, this.b.appBar, this.b.pager, this.config);
                break;
            case 4:
                new com.up366.mobile.user.account.find.PageCanNotFindAccount(this, this.b.content, this.b.toolbarLayout, this.b.appBar, this.b.pager);
                break;
            case 5:
                new com.up366.mobile.user.account.find.PageValidClassmates(this, this.b.content, this.b.toolbarLayout, this.b.appBar, this.b.pager, this.config);
                break;
            case 6:
                new com.up366.mobile.user.account.find.PageFindAccountSuccess(this, this.b.content, this.b.toolbarLayout, this.b.appBar, this.b.pager, this.b.back, this.b.close, this.config);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.up366.mobile.common.utils.ViewUtil.hideSoftInputOnTouchOutside((android.app.Activity) this, motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public static void openPage(android.content.Context context, com.up366.mobile.user.account.find.AccountFindActivity.Config config) {
        android.content.Intent intent = new android.content.Intent();
        intent.setClass(context, com.up366.mobile.user.account.find.AccountFindActivity.class);
        intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, config.page);
        intent.putExtra("config", config);
        context.startActivity(intent);
    }

    public static class Config implements java.io.Serializable, java.lang.Cloneable {
        public java.lang.String cityId;
        public java.lang.String cityName;
        public java.lang.String classId;
        public java.lang.String className;
        public java.lang.String organId;
        public java.lang.String organName;
        public int page;
        public java.lang.String realName;
        public int type;

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public com.up366.mobile.user.account.find.AccountFindActivity.Config m1200clone() {
            try {
                return (com.up366.mobile.user.account.find.AccountFindActivity.Config) super.clone();
            } catch (java.lang.CloneNotSupportedException unused) {
                return new com.up366.mobile.user.account.find.AccountFindActivity.Config();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.mobile.common.utils.ViewUtil.cleanSoftInput(this);
    }
}
