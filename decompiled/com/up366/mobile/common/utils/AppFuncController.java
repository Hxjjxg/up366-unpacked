package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppFuncController {
    public static final java.lang.String FUNC_BANNER = "func_banner";
    public static final java.lang.String FUNC_DAILY = "func_daily";
    public static final java.lang.String FUNC_HOMEWORK = "func_homework";
    public static final java.lang.String FUNC_JOINCLASS = "func_joinclass";
    public static final java.lang.String FUNC_LIVECLASS = "func_liveclass";
    public static final java.lang.String FUNC_MALL = "func_mall";
    public static final java.lang.String FUNC_NOTICE = "func_notice";
    public static final java.lang.String FUNC_WORDS = "func_words";
    public static final java.lang.String FUNC_WRONGNOTE = "func_wrongnote";
    private static java.lang.String blackFuncList = null;
    private static int curUid = -1;

    public static com.up366.mobile.common.utils.AppFuncController.Inner func(java.lang.String str) {
        return new com.up366.mobile.common.utils.AppFuncController.Inner(str);
    }

    public static void refreshData() {
        blackFuncList = java.util.Arrays.toString(com.up366.mobile.common.logic.Auth.cur().config().loadFuncCloseListSync().toArray());
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.AppFuncReloadEvent());
    }

    public static void showTipDialog() {
        com.up366.mobile.common.dialog.DialogOk.showDialog("提示", "该功能已被老师关闭！", "OK");
    }

    public static class Inner {
        private final java.lang.String func;

        public Inner(java.lang.String str) {
            this.func = str;
        }

        public void runWithTip(java.lang.Runnable runnable) {
            initBlackFuncList();
            if (!com.up366.mobile.common.utils.AppFuncController.blackFuncList.contains(this.func)) {
                runnable.run();
            } else {
                com.up366.mobile.common.utils.AppFuncController.showTipDialog();
            }
        }

        public boolean isInBlackList() {
            initBlackFuncList();
            return com.up366.mobile.common.utils.AppFuncController.blackFuncList.contains(this.func);
        }

        public void run(java.lang.Runnable runnable) {
            initBlackFuncList();
            if (com.up366.mobile.common.utils.AppFuncController.blackFuncList.contains(this.func)) {
                return;
            }
            runnable.run();
        }

        private void initBlackFuncList() {
            if (!com.up366.mobile.common.logic.Auth.isAuth()) {
                com.up366.mobile.common.utils.AppFuncController.curUid = -1;
                com.up366.mobile.common.utils.AppFuncController.blackFuncList = "";
            } else if (com.up366.mobile.common.utils.AppFuncController.blackFuncList == null || com.up366.mobile.common.logic.Auth.UID() != com.up366.mobile.common.utils.AppFuncController.curUid) {
                com.up366.mobile.common.utils.AppFuncController.curUid = com.up366.mobile.common.logic.Auth.UID();
                com.up366.mobile.common.utils.AppFuncController.blackFuncList = java.util.Arrays.toString(com.up366.mobile.common.logic.Auth.cur().config().loadFuncCloseListSync().toArray());
            }
        }
    }
}
