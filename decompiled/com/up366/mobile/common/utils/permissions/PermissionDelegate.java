package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface PermissionDelegate {
    boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str);

    boolean isGrantedPermission(android.content.Context context, java.lang.String str);
}
