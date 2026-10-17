package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppBarRefreshLayoutHelper {
    static /* synthetic */ boolean lambda$binding$0(com.google.android.material.appbar.AppBarLayout appBarLayout) {
        return appBarLayout.getTop() == 0;
    }

    public void binding(final com.google.android.material.appbar.AppBarLayout appBarLayout, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout) {
        pullRefreshLayout.setContentPositionCallback(new com.ylw.pullrefreshlibrary.PullRefreshLayout.IContentPositionCallback() { // from class: com.up366.mobile.common.helper.AppBarRefreshLayoutHelper$$ExternalSyntheticLambda0
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.IContentPositionCallback
            public final boolean isTop() {
                return com.up366.mobile.common.helper.AppBarRefreshLayoutHelper.lambda$binding$0(appBarLayout);
            }
        });
    }

    static /* synthetic */ boolean lambda$binding$1(com.google.android.material.appbar.AppBarLayout appBarLayout, androidx.recyclerview.widget.RecyclerView recyclerView) {
        return appBarLayout.getTop() == 0 && !recyclerView.canScrollVertically(-1);
    }

    public void binding(final com.google.android.material.appbar.AppBarLayout appBarLayout, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout, final androidx.recyclerview.widget.RecyclerView recyclerView) {
        pullRefreshLayout.setContentPositionCallback(new com.ylw.pullrefreshlibrary.PullRefreshLayout.IContentPositionCallback() { // from class: com.up366.mobile.common.helper.AppBarRefreshLayoutHelper$$ExternalSyntheticLambda1
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.IContentPositionCallback
            public final boolean isTop() {
                return com.up366.mobile.common.helper.AppBarRefreshLayoutHelper.lambda$binding$1(appBarLayout, recyclerView);
            }
        });
    }
}
