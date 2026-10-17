package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DialogBlockUser {
    public static final int TYPE_LOGIN = 0;
    public static final int TYPE_MAIN = 1;
    public static final int TYPE_STUDY = 2;
    private static int countTypeLogin;
    private static int countTypeMain;
    private static int countTypeStudy;
    private static boolean hasShow;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface DialogFromType {
    }

    public static void show(android.app.Activity activity, int i, int i2, final com.up366.common.callback.ICallbackCode iCallbackCode) {
        com.up366.common.log.Logger.info("TAG - 2021/4/23 - DialogBlockUser - show - activity = [" + activity + "], type = [" + i + "], callback = [" + iCallbackCode + "]");
        if (hasShow) {
            return;
        }
        boolean z = i2 == -10002;
        hasShow = true;
        if (i == 0) {
            int i3 = countTypeLogin + 1;
            countTypeLogin = i3;
            if (i3 < 3) {
                com.up366.mobile.common.dialog.DialogCountOk.showCountOkDialog(activity, z ? 3 : 1, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.DialogBlockUser$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        com.up366.mobile.common.dialog.DialogBlockUser.lambda$show$0(iCallbackCode, view);
                    }
                });
                return;
            } else {
                com.up366.mobile.common.dialog.DialogCountOk.showCountOkDialog(activity, z ? 4 : 2, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.DialogBlockUser$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        com.up366.mobile.common.dialog.DialogBlockUser.lambda$show$1(iCallbackCode, view);
                    }
                });
                return;
            }
        }
        if (i == 1) {
            int i4 = countTypeMain + 1;
            countTypeMain = i4;
            if (i4 < 3) {
                com.up366.mobile.common.dialog.DialogCountOk.showCountOkDialog(activity, z ? 3 : 1, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.DialogBlockUser$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        com.up366.mobile.common.dialog.DialogBlockUser.lambda$show$2(iCallbackCode, view);
                    }
                });
                return;
            } else {
                com.up366.mobile.common.dialog.DialogCountOk.showCountOkDialog(activity, z ? 4 : 2, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.DialogBlockUser$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        com.up366.mobile.common.dialog.DialogBlockUser.lambda$show$3(iCallbackCode, view);
                    }
                });
                return;
            }
        }
        if (i != 2) {
            return;
        }
        int i5 = countTypeStudy + 1;
        countTypeStudy = i5;
        if (i5 < 3) {
            com.up366.mobile.common.dialog.DialogCountOk.showCountOkDialog(activity, z ? 3 : 1, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.DialogBlockUser$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.common.dialog.DialogBlockUser.lambda$show$4(iCallbackCode, view);
                }
            });
        } else {
            com.up366.mobile.common.dialog.DialogCountOk.showCountOkDialog(activity, z ? 4 : 2, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.DialogBlockUser$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.common.dialog.DialogBlockUser.lambda$show$5(iCallbackCode, view);
                }
            });
        }
    }

    static /* synthetic */ void lambda$show$0(com.up366.common.callback.ICallbackCode iCallbackCode, android.view.View view) {
        hasShow = false;
        iCallbackCode.onResult(0);
    }

    static /* synthetic */ void lambda$show$1(com.up366.common.callback.ICallbackCode iCallbackCode, android.view.View view) {
        hasShow = false;
        iCallbackCode.onResult(0);
    }

    static /* synthetic */ void lambda$show$2(com.up366.common.callback.ICallbackCode iCallbackCode, android.view.View view) {
        hasShow = false;
        iCallbackCode.onResult(0);
    }

    static /* synthetic */ void lambda$show$3(com.up366.common.callback.ICallbackCode iCallbackCode, android.view.View view) {
        hasShow = false;
        iCallbackCode.onResult(0);
    }

    static /* synthetic */ void lambda$show$4(com.up366.common.callback.ICallbackCode iCallbackCode, android.view.View view) {
        hasShow = false;
        iCallbackCode.onResult(0);
    }

    static /* synthetic */ void lambda$show$5(com.up366.common.callback.ICallbackCode iCallbackCode, android.view.View view) {
        hasShow = false;
        iCallbackCode.onResult(0);
    }

    public static boolean checkNeedIntercept() {
        long time = com.up366.common.TimeUtils.parseTime("2021/05/01 00:00:00", "yyyy/MM/dd HH:mm:ss").getTime();
        long time2 = com.up366.common.TimeUtils.parseTime("2021/05/06 00:00:00", "yyyy/MM/dd HH:mm:ss").getTime();
        com.up366.common.log.Logger.info("TAG - 2021/4/23 - DialogBlockUser - show time - now:" + com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() + " begin:" + time + " end:" + time2);
        return true;
    }

    public static boolean isHasShow() {
        return hasShow;
    }
}
