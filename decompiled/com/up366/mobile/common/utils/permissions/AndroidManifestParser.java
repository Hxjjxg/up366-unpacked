package com.up366.mobile.common.utils.permissions;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
final class AndroidManifestParser {
    private static final java.lang.String ANDROID_MANIFEST_FILE_NAME = "AndroidManifest.xml";
    private static final java.lang.String ANDROID_NAMESPACE_URI = "http://schemas.android.com/apk/res/android";
    private static final java.lang.String ATTR_MAX_SDK_VERSION = "maxSdkVersion";
    private static final java.lang.String ATTR_MIN_SDK_VERSION = "minSdkVersion";
    private static final java.lang.String ATTR_NAME = "name";
    private static final java.lang.String ATTR_PACKAGE = "package";
    private static final java.lang.String ATTR_PERMISSION = "permission";
    private static final java.lang.String ATTR_REQUEST_LEGACY_EXTERNAL_STORAGE = "requestLegacyExternalStorage";
    private static final java.lang.String ATTR_SUPPORTS_PICTURE_IN_PICTURE = "supportsPictureInPicture";
    private static final java.lang.String ATTR_USES_PERMISSION_FLAGS = "usesPermissionFlags";
    private static final java.lang.String TAG_ACTIVITY = "activity";
    private static final java.lang.String TAG_ACTIVITY_ALIAS = "activity-alias";
    private static final java.lang.String TAG_APPLICATION = "application";
    private static final java.lang.String TAG_MANIFEST = "manifest";
    private static final java.lang.String TAG_SERVICE = "service";
    private static final java.lang.String TAG_USES_PERMISSION = "uses-permission";
    private static final java.lang.String TAG_USES_PERMISSION_SDK_23 = "uses-permission-sdk-23";
    private static final java.lang.String TAG_USES_PERMISSION_SDK_M = "uses-permission-sdk-m";
    private static final java.lang.String TAG_USES_SDK = "uses-sdk";

    private AndroidManifestParser() {
    }

    static com.up366.mobile.common.utils.permissions.AndroidManifestInfo parseAndroidManifest(android.content.Context context, int i) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        com.up366.mobile.common.utils.permissions.AndroidManifestInfo androidManifestInfo = new com.up366.mobile.common.utils.permissions.AndroidManifestInfo();
        android.content.res.XmlResourceParser xmlResourceParserOpenXmlResourceParser = context.getAssets().openXmlResourceParser(i, ANDROID_MANIFEST_FILE_NAME);
        do {
            try {
                if (xmlResourceParserOpenXmlResourceParser.getEventType() == 2) {
                    java.lang.String name = xmlResourceParserOpenXmlResourceParser.getName();
                    if (android.text.TextUtils.equals(TAG_MANIFEST, name)) {
                        androidManifestInfo.packageName = xmlResourceParserOpenXmlResourceParser.getAttributeValue(null, ATTR_PACKAGE);
                    }
                    if (android.text.TextUtils.equals(TAG_USES_SDK, name)) {
                        androidManifestInfo.usesSdkInfo = parseUsesSdkFromXml(xmlResourceParserOpenXmlResourceParser);
                    }
                    if (android.text.TextUtils.equals(TAG_USES_PERMISSION, name) || android.text.TextUtils.equals(TAG_USES_PERMISSION_SDK_23, name) || android.text.TextUtils.equals(TAG_USES_PERMISSION_SDK_M, name)) {
                        androidManifestInfo.permissionInfoList.add(parsePermissionFromXml(xmlResourceParserOpenXmlResourceParser));
                    }
                    if (android.text.TextUtils.equals(TAG_APPLICATION, name)) {
                        androidManifestInfo.applicationInfo = parseApplicationFromXml(xmlResourceParserOpenXmlResourceParser);
                    }
                    if (android.text.TextUtils.equals(TAG_ACTIVITY, name) || android.text.TextUtils.equals(TAG_ACTIVITY_ALIAS, name)) {
                        androidManifestInfo.activityInfoList.add(parseActivityFromXml(xmlResourceParserOpenXmlResourceParser));
                    }
                    if (android.text.TextUtils.equals(TAG_SERVICE, name)) {
                        androidManifestInfo.serviceInfoList.add(parseServerFromXml(xmlResourceParserOpenXmlResourceParser));
                    }
                }
            } catch (java.lang.Throwable th) {
                if (xmlResourceParserOpenXmlResourceParser != null) {
                    try {
                        xmlResourceParserOpenXmlResourceParser.close();
                    } catch (java.lang.Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } while (xmlResourceParserOpenXmlResourceParser.next() != 1);
        if (xmlResourceParserOpenXmlResourceParser != null) {
            xmlResourceParserOpenXmlResourceParser.close();
        }
        return androidManifestInfo;
    }

    private static com.up366.mobile.common.utils.permissions.AndroidManifestInfo.UsesSdkInfo parseUsesSdkFromXml(android.content.res.XmlResourceParser xmlResourceParser) {
        com.up366.mobile.common.utils.permissions.AndroidManifestInfo.UsesSdkInfo usesSdkInfo = new com.up366.mobile.common.utils.permissions.AndroidManifestInfo.UsesSdkInfo();
        usesSdkInfo.minSdkVersion = xmlResourceParser.getAttributeIntValue(ANDROID_NAMESPACE_URI, ATTR_MIN_SDK_VERSION, 0);
        return usesSdkInfo;
    }

    private static com.up366.mobile.common.utils.permissions.AndroidManifestInfo.PermissionInfo parsePermissionFromXml(android.content.res.XmlResourceParser xmlResourceParser) {
        com.up366.mobile.common.utils.permissions.AndroidManifestInfo.PermissionInfo permissionInfo = new com.up366.mobile.common.utils.permissions.AndroidManifestInfo.PermissionInfo();
        permissionInfo.name = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, ATTR_NAME);
        permissionInfo.maxSdkVersion = xmlResourceParser.getAttributeIntValue(ANDROID_NAMESPACE_URI, ATTR_MAX_SDK_VERSION, Integer.MAX_VALUE);
        permissionInfo.usesPermissionFlags = xmlResourceParser.getAttributeIntValue(ANDROID_NAMESPACE_URI, ATTR_USES_PERMISSION_FLAGS, 0);
        return permissionInfo;
    }

    private static com.up366.mobile.common.utils.permissions.AndroidManifestInfo.ApplicationInfo parseApplicationFromXml(android.content.res.XmlResourceParser xmlResourceParser) {
        com.up366.mobile.common.utils.permissions.AndroidManifestInfo.ApplicationInfo applicationInfo = new com.up366.mobile.common.utils.permissions.AndroidManifestInfo.ApplicationInfo();
        applicationInfo.name = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, ATTR_NAME);
        applicationInfo.requestLegacyExternalStorage = xmlResourceParser.getAttributeBooleanValue(ANDROID_NAMESPACE_URI, ATTR_REQUEST_LEGACY_EXTERNAL_STORAGE, false);
        return applicationInfo;
    }

    private static com.up366.mobile.common.utils.permissions.AndroidManifestInfo.ActivityInfo parseActivityFromXml(android.content.res.XmlResourceParser xmlResourceParser) {
        com.up366.mobile.common.utils.permissions.AndroidManifestInfo.ActivityInfo activityInfo = new com.up366.mobile.common.utils.permissions.AndroidManifestInfo.ActivityInfo();
        activityInfo.name = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, ATTR_NAME);
        activityInfo.supportsPictureInPicture = xmlResourceParser.getAttributeBooleanValue(ANDROID_NAMESPACE_URI, ATTR_SUPPORTS_PICTURE_IN_PICTURE, false);
        return activityInfo;
    }

    private static com.up366.mobile.common.utils.permissions.AndroidManifestInfo.ServiceInfo parseServerFromXml(android.content.res.XmlResourceParser xmlResourceParser) {
        com.up366.mobile.common.utils.permissions.AndroidManifestInfo.ServiceInfo serviceInfo = new com.up366.mobile.common.utils.permissions.AndroidManifestInfo.ServiceInfo();
        serviceInfo.name = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, ATTR_NAME);
        serviceInfo.permission = xmlResourceParser.getAttributeValue(ANDROID_NAMESPACE_URI, ATTR_PERMISSION);
        return serviceInfo;
    }
}
