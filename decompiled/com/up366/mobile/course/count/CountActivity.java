package com.up366.mobile.course.count;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class CountActivity extends com.up366.mobile.common.base.BaseActivity {
    public com.up366.mobile.book.model.BookInfoStudy book;

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.up366.mobile.R.layout.count_main_activity);
        this.book = (com.up366.mobile.book.model.BookInfoStudy) getIntent().getSerializableExtra("book");
        showFragment(2131362178, com.up366.mobile.course.count.CountFragment.class);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() {
        if (((com.up366.mobile.course.count.CountFragment) this.fragmentMap.get(com.up366.mobile.course.count.CountFragment.class)).handleBack()) {
            return;
        }
        super.onBackPressed();
    }
}
