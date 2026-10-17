package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class PermissionApi {
    private static final com.up366.mobile.common.utils.permissions.PermissionDelegate DELEGATE;

    static {
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid14()) {
            DELEGATE = new com.up366.mobile.common.utils.permissions.PermissionDelegateImplV34();
            return;
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid13()) {
            DELEGATE = new com.up366.mobile.common.utils.permissions.PermissionDelegateImplV33();
            return;
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid12()) {
            DELEGATE = new com.up366.mobile.common.utils.permissions.PermissionDelegateImplV31();
            return;
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid11()) {
            DELEGATE = new com.up366.mobile.common.utils.permissions.PermissionDelegateImplV30();
            return;
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid10()) {
            DELEGATE = new com.up366.mobile.common.utils.permissions.PermissionDelegateImplV29();
            return;
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid9()) {
            DELEGATE = new com.up366.mobile.common.utils.permissions.PermissionDelegateImplV28();
            return;
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid8()) {
            DELEGATE = new com.up366.mobile.common.utils.permissions.PermissionDelegateImplV26();
            return;
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid6()) {
            DELEGATE = new com.up366.mobile.common.utils.permissions.PermissionDelegateImplV23();
            return;
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid5()) {
            DELEGATE = new com.up366.mobile.common.utils.permissions.PermissionDelegateImplV21();
            return;
        }
        if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid4_4()) {
            DELEGATE = new com.up366.mobile.common.utils.permissions.PermissionDelegateImplV19();
        } else if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid4_3()) {
            DELEGATE = new com.up366.mobile.common.utils.permissions.PermissionDelegateImplV18();
        } else {
            DELEGATE = new com.up366.mobile.common.utils.permissions.PermissionDelegateImplV14();
        }
    }

    static int getPermissionResult(android.content.Context context, java.lang.String str) {
        return isGrantedPermission(context, str) ? 0 : -1;
    }

    public static boolean isGrantedPermission(android.content.Context context, java.lang.String str) {
        return DELEGATE.isGrantedPermission(context, str);
    }

    public static boolean isDoNotAskAgainPermission(android.app.Activity activity, java.lang.String str) {
        return DELEGATE.isDoNotAskAgainPermission(activity, str);
    }

    static boolean isSpecialPermission(java.lang.String str) {
        return com.up366.mobile.common.utils.permissions.Permission.isSpecialPermission(str);
    }

    static boolean containsSpecialPermission(java.util.List<java.lang.String> list) {
        if (list != null && !list.isEmpty()) {
            java.util.Iterator<java.lang.String> it = list.iterator();
            while (it.hasNext()) {
                if (isSpecialPermission(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isGrantedPermissions(android.content.Context context, java.util.List<java.lang.String> list) {
        if (list.isEmpty()) {
            return false;
        }
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            if (!isGrantedPermission(context, it.next())) {
                return false;
            }
        }
        return true;
    }

    static java.util.List<java.lang.String> getGrantedPermissions(android.content.Context context, java.util.List<java.lang.String> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        for (java.lang.String str : list) {
            if (isGrantedPermission(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    static java.util.List<java.lang.String> getDeniedPermissions(android.content.Context context, java.util.List<java.lang.String> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        for (java.lang.String str : list) {
            if (!isGrantedPermission(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    static boolean isDoNotAskAgainPermissions(android.app.Activity activity, java.util.List<java.lang.String> list) {
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            if (isDoNotAskAgainPermission(activity, it.next())) {
                return true;
            }
        }
        return false;
    }

    static java.util.List<java.lang.String> getDeniedPermissions(java.util.List<java.lang.String> list, int[] iArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == -1) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }

    static java.util.List<java.lang.String> getGrantedPermissions(java.util.List<java.lang.String> list, int[] iArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] == 0) {
                arrayList.add(list.get(i));
            }
        }
        return arrayList;
    }
}
