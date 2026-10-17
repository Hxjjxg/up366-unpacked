package com.up366.mobile.main;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class StudyCardDialog {
    public static void showStudyCardDialog(final android.app.Activity activity, com.alibaba.fastjson.JSONObject jSONObject, final com.up366.common.callback.ICallbackCode iCallbackCode) {
        final int intValue = jSONObject.getIntValue("isLearningCard");
        int intValue2 = jSONObject.getIntValue("expireDays");
        if (jSONObject.getIntValue("isRemind") != 1) {
            com.up366.common.log.Logger.info("不需要显示学习卡片对话框" + jSONObject);
            iCallbackCode.onResult(0);
            return;
        }
        com.up366.mobile.common.dialog.AppDialog.create(activity).title("温馨提示").message(getMessageText(intValue2, intValue)).btnOne(intValue == 1 ? "去升级" : "知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.StudyCardDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.main.StudyCardDialog.lambda$showStudyCardDialog$0(iCallbackCode, intValue, activity, view);
            }
        }).setBtnCloseVisibility(intValue != 1 ? 8 : 0).show();
    }

    static /* synthetic */ void lambda$showStudyCardDialog$0(com.up366.common.callback.ICallbackCode iCallbackCode, int i, android.app.Activity activity, android.view.View view) {
        iCallbackCode.onResult(0);
        if (i == 1) {
            com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.open(activity, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.STUDY_CARD_URL) + "?userId=" + com.up366.mobile.common.logic.Auth.UID());
        }
    }

    private static android.text.SpannableStringBuilder getMessageText(int i, int i2) {
        if (i2 == 1) {
            if (i > 0) {
                return new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("您的权益还有").append(i + "").setSpan(new android.text.style.ForegroundColorSpan(-13665796)).append("天就要到期啦~").append("\n到期后部分功能将无法正常使用。\n快去升级您的学习卡吧。\n如有问题可联系您的助教~").build();
            }
            if (i == 0) {
                return new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("您的权益").append("今天").setSpan(new android.text.style.ForegroundColorSpan(-13665796)).append("就要到期啦~").append("\n到期后部分功能将无法正常使用。\n快去升级您的学习卡吧。\n如有问题可联系您的助教~").build();
            }
            return new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("您的权益已经过期").append(java.lang.Math.abs(i) + "").setSpan(new android.text.style.ForegroundColorSpan(-13665796)).append("天啦~").append("\n部分功能已经无法正常使用。\n快去升级您的学习卡吧。\n如有问题可联系您的助教~").build();
        }
        if (i > 0) {
            return new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("您的权益还有").append(i + "").setSpan(new android.text.style.ForegroundColorSpan(-13665796)).append("天就要到期啦~").append("\n到期后部分功能将无法正常使用。\n快去联系您的助教吧~").build();
        }
        if (i == 0) {
            return new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("您的权益").append("今天").setSpan(new android.text.style.ForegroundColorSpan(-13665796)).append("就要到期啦~").append("\n到期后部分功能将无法正常使用。\n快去联系您的助教吧~").build();
        }
        return new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("您的权益已经过期").append(java.lang.Math.abs(i) + "").setSpan(new android.text.style.ForegroundColorSpan(-13665796)).append("天啦~").append("\n部分功能已经无法正常使用。\n快去联系您的助教吧~").build();
    }
}
