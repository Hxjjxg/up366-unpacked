package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PageFunctionCheckHelper {

    public enum Funtions {
        WORDNOE,
        WRONGNOTE
    }

    public static void checkFunCheck(android.view.View view, com.up366.mobile.common.helper.PageFunctionCheckHelper.Funtions funtions, java.lang.Runnable runnable) {
        if (!com.up366.mobile.common.logic.Auth.getUserInfo().isQuDaoUser()) {
            runnable.run();
            return;
        }
        if (com.up366.mobile.common.helper.PageFunctionCheckHelper.Funtions.WRONGNOTE == funtions) {
            if (view != null) {
                view.setEnabled(false);
            }
            checkFun(view, com.up366.mobile.common.helper.UserFunAccreditHelper.FUN_ID_WRONG_NOTE, runnable);
        } else if (com.up366.mobile.common.helper.PageFunctionCheckHelper.Funtions.WORDNOE == funtions) {
            if (view != null) {
                view.setEnabled(false);
            }
            checkFun(view, com.up366.mobile.common.helper.UserFunAccreditHelper.FUN_ID_WORD_NOTE, runnable);
        } else {
            com.up366.common.log.Logger.error("checkTeachClassAfterFunCheck  error not support :" + funtions.name());
        }
    }

    public static void checkFunCheck(com.up366.mobile.common.helper.PageFunctionCheckHelper.Funtions funtions, java.lang.Runnable runnable) {
        checkFunCheck(null, funtions, runnable);
    }

    private static void checkFun(final android.view.View view, final java.lang.String str, final java.lang.Runnable runnable) {
        com.up366.mobile.common.helper.UserFunAccreditHelper.INSTANCE.checkUseFunAsync(str, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.helper.PageFunctionCheckHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str2) {
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.PageFunctionCheckHelper$$ExternalSyntheticLambda1
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        com.up366.mobile.common.helper.PageFunctionCheckHelper.lambda$checkFun$1(view, i, runnable, str);
                    }
                });
            }
        });
    }

    static /* synthetic */ void lambda$checkFun$1(android.view.View view, int i, java.lang.Runnable runnable, final java.lang.String str) throws java.lang.Exception {
        if (view != null) {
            view.setEnabled(true);
        }
        if (i == 1) {
            runnable.run();
        } else if (i == 0) {
            com.up366.mobile.common.dialog.AppDialog.create(com.up366.common.global.GB.get().getCurrentActivity()).title("您的试用权益已到期").message("如需继续使用请联系教学顾问").setBtnCloseVisibility(8).btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.helper.PageFunctionCheckHelper$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view2) {
                    com.up366.common.log.Logger.info("checkTeachClassAfterFunCheck no function " + str);
                }
            }).show();
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.showError(com.up366.common.global.GB.get().getCurrentActivity(), "操作失败，请重试");
        }
    }
}
