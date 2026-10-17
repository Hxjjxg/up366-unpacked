package com.up366.common.global;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface IActivityUp {

    public enum ActivityType {
        COMMON_WEB_VIEW,
        WEB_VIEW_2023,
        WEB_VIEW_2019
    }

    void openWebViewActivity(android.content.Context context, com.up366.common.global.IActivityUp.ActivityType activityType, com.alibaba.fastjson.JSONObject jSONObject, boolean z);

    /* JADX INFO: renamed from: com.up366.common.global.IActivityUp$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
    }
}
