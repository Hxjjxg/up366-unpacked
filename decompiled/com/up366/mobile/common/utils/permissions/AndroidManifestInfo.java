package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
final class AndroidManifestInfo {
    com.up366.mobile.common.utils.permissions.AndroidManifestInfo.ApplicationInfo applicationInfo;
    java.lang.String packageName;
    com.up366.mobile.common.utils.permissions.AndroidManifestInfo.UsesSdkInfo usesSdkInfo;
    final java.util.List<com.up366.mobile.common.utils.permissions.AndroidManifestInfo.PermissionInfo> permissionInfoList = new java.util.ArrayList();
    final java.util.List<com.up366.mobile.common.utils.permissions.AndroidManifestInfo.ActivityInfo> activityInfoList = new java.util.ArrayList();
    final java.util.List<com.up366.mobile.common.utils.permissions.AndroidManifestInfo.ServiceInfo> serviceInfoList = new java.util.ArrayList();

    AndroidManifestInfo() {
    }

    static final class UsesSdkInfo {
        int minSdkVersion;

        UsesSdkInfo() {
        }
    }

    static final class PermissionInfo {
        private static final int REQUESTED_PERMISSION_NEVER_FOR_LOCATION;
        int maxSdkVersion;
        java.lang.String name;
        int usesPermissionFlags;

        PermissionInfo() {
        }

        static {
            if (com.up366.mobile.common.utils.permissions.AndroidVersion.isAndroid12()) {
                REQUESTED_PERMISSION_NEVER_FOR_LOCATION = 65536;
            } else {
                REQUESTED_PERMISSION_NEVER_FOR_LOCATION = 65536;
            }
        }

        boolean neverForLocation() {
            return (this.usesPermissionFlags & REQUESTED_PERMISSION_NEVER_FOR_LOCATION) != 0;
        }
    }

    static final class ApplicationInfo {
        java.lang.String name;
        boolean requestLegacyExternalStorage;

        ApplicationInfo() {
        }
    }

    static final class ActivityInfo {
        java.lang.String name;
        boolean supportsPictureInPicture;

        ActivityInfo() {
        }
    }

    static final class ServiceInfo {
        java.lang.String name;
        java.lang.String permission;

        ServiceInfo() {
        }
    }
}
