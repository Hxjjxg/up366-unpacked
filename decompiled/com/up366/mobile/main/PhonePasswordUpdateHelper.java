package com.up366.mobile.main;

/* JADX INFO: compiled from: PhonePasswordUpdateHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0006R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/up366/mobile/main/PhonePasswordUpdateHelper;", "", "<init>", "()V", "hasShowUpdateMobileUserList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hasShowUpdatePasswordUserList", "skip", "", "activity", "Landroid/app/Activity;", "hasShowUpdateMobile", "uid", "hasShowUpdatePassword", "removeAccount", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhonePasswordUpdateHelper {
    public static final com.up366.mobile.main.PhonePasswordUpdateHelper INSTANCE = new com.up366.mobile.main.PhonePasswordUpdateHelper();
    private static final java.util.ArrayList<java.lang.Integer> hasShowUpdateMobileUserList = new java.util.ArrayList<>();
    private static final java.util.ArrayList<java.lang.Integer> hasShowUpdatePasswordUserList = new java.util.ArrayList<>();

    private PhonePasswordUpdateHelper() {
    }

    public final boolean skip(android.app.Activity activity) {
        if (activity == null) {
            return false;
        }
        if (com.up366.mobile.common.logic.Auth.cur().config().isNeedUpdatePassword()) {
            com.up366.common.log.Logger.info("skip update password ");
            hasShowUpdatePasswordUserList.add(java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
            com.up366.mobile.main.UpdatePhonePasswordActivity.start(activity);
            return true;
        }
        if (!com.up366.mobile.common.logic.Auth.cur().config().isNeedBindPhone()) {
            return false;
        }
        hasShowUpdateMobileUserList.add(java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
        com.up366.common.log.Logger.info("skip update phone ");
        com.up366.mobile.user.account.update.AccountUpdateActivity.openPageFromConfig(activity, 1);
        return true;
    }

    public final boolean hasShowUpdateMobile(int uid) {
        return hasShowUpdateMobileUserList.contains(java.lang.Integer.valueOf(uid));
    }

    public final boolean hasShowUpdatePassword(int uid) {
        return hasShowUpdatePasswordUserList.contains(java.lang.Integer.valueOf(uid));
    }

    public final void removeAccount(int uid) {
        hasShowUpdateMobileUserList.remove(java.lang.Integer.valueOf(uid));
        hasShowUpdatePasswordUserList.remove(java.lang.Integer.valueOf(uid));
    }
}
