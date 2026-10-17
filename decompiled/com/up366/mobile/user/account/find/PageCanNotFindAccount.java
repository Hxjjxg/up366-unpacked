package com.up366.mobile.user.account.find;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PageCanNotFindAccount {
    public PageCanNotFindAccount(android.app.Activity activity, android.widget.FrameLayout frameLayout, com.up366.mobile.common.views.CollapsingToolbarLayout collapsingToolbarLayout, com.google.android.material.appbar.AppBarLayout appBarLayout, android.widget.TextView textView) {
        collapsingToolbarLayout.setTitle("");
        androidx.databinding.DataBindingUtil.inflate(activity.getLayoutInflater(), com.up366.mobile.R.layout.account_find_activity_can_not_find_account_layout, frameLayout, true);
    }
}
