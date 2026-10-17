package com.up366.qrcode.view.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ImageUtil {
    public static java.lang.String getImageAbsolutePath(android.content.Context context, android.net.Uri uri) {
        android.net.Uri uri2 = null;
        if (context != null && uri != null) {
            if (android.provider.DocumentsContract.isDocumentUri(context, uri)) {
                if (isExternalStorageDocument(uri)) {
                    java.lang.String[] strArrSplit = android.provider.DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return android.os.Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (isDownloadsDocument(uri)) {
                        return getDataColumn(context, android.content.ContentUris.withAppendedId(android.net.Uri.parse("content://downloads/public_downloads"), java.lang.Long.valueOf(android.provider.DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    }
                    if (isMediaDocument(uri)) {
                        java.lang.String[] strArrSplit2 = android.provider.DocumentsContract.getDocumentId(uri).split(":");
                        java.lang.String str = strArrSplit2[0];
                        if (com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE.equals(str)) {
                            uri2 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_VIDEO.equals(str)) {
                            uri2 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_AUDIO.equals(str)) {
                            uri2 = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        }
                        return getDataColumn(context, uri2, "_id=?", new java.lang.String[]{strArrSplit2[1]});
                    }
                }
            } else {
                if (com.igexin.sdk.FlymePushReceiver.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                    if (isGooglePhotosUri(uri)) {
                        return uri.getLastPathSegment();
                    }
                    return getDataColumn(context, uri, null, null);
                }
                if ("file".equalsIgnoreCase(uri.getScheme())) {
                    return uri.getPath();
                }
            }
        }
        return null;
    }

    public static java.lang.String getDataColumn(android.content.Context context, android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) throws java.lang.Throwable {
        android.database.Cursor cursor = null;
        try {
            android.database.Cursor cursorQuery = context.getContentResolver().query(uri, new java.lang.String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return string;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static boolean isExternalStorageDocument(android.net.Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(android.net.Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(android.net.Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(android.net.Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }
}
