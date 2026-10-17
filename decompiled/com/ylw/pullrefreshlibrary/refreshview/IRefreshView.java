package com.ylw.pullrefreshlibrary.refreshview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface IRefreshView {
    void init(android.content.Context context, com.ylw.pullrefreshlibrary.PullRefreshLayout pullRefreshLayout);

    void initView(android.view.View view);

    void setRefreshTime(java.lang.String str);

    void toStep1(android.content.Context context, int i, int i2);

    void toStep2(android.content.Context context, int i, int i2);

    void toStep3(android.content.Context context, int i, int i2);

    void toStep4(android.content.Context context);

    void updatePercent(float f);
}
