package gdut.bsx.share2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class FileUtil {
    private static final java.lang.String TAG = "Share";

    public static android.net.Uri getFileUri(android.content.Context context, java.lang.String str, java.io.File file) {
        android.net.Uri audioContentUri = null;
        if (context == null) {
            android.util.Log.e(TAG, "getFileUri current activity is null.");
            return null;
        }
        if (file == null || !file.exists()) {
            android.util.Log.e(TAG, "getFileUri file is null or not exists.");
            return null;
        }
        if (android.os.Build.VERSION.SDK_INT < 24) {
            audioContentUri = android.net.Uri.fromFile(file);
        } else {
            if (android.text.TextUtils.isEmpty(str)) {
                str = gdut.bsx.share2.ShareContentType.FILE;
            }
            str.hashCode();
            switch (str) {
                case "audio/*":
                    audioContentUri = getAudioContentUri(context, file);
                    break;
                case "*/*":
                    audioContentUri = getFileContentUri(context, file);
                    break;
                case "video/*":
                    audioContentUri = getVideoContentUri(context, file);
                    break;
                case "image/*":
                    audioContentUri = getImageContentUri(context, file);
                    break;
            }
        }
        return audioContentUri == null ? forceGetFileUri(file) : audioContentUri;
    }

    public static java.lang.String getFileRealPath(android.content.Context context, android.net.Uri uri) {
        android.net.Uri contentUri;
        if (context == null) {
            android.util.Log.e(TAG, "getFileRealPath current activity is null.");
            return null;
        }
        if (uri == null) {
            android.util.Log.e(TAG, "getFileRealPath uri is null.");
            return null;
        }
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
                        contentUri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_VIDEO.equals(str)) {
                        contentUri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_AUDIO.equals(str)) {
                        contentUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    } else {
                        contentUri = android.provider.MediaStore.Files.getContentUri("external");
                    }
                    return getDataColumn(context, contentUri, "_id=?", new java.lang.String[]{strArrSplit2[1]});
                }
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    private static android.net.Uri forceGetFileUri(java.io.File file) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            try {
                android.os.StrictMode.class.getDeclaredMethod("disableDeathOnFileUriExposure", null).invoke(null, null);
            } catch (java.lang.Exception e) {
                android.util.Log.e(TAG, android.util.Log.getStackTraceString(e));
            }
        }
        return android.net.Uri.parse("file://" + file.getAbsolutePath());
    }

    private static android.net.Uri getFileContentUri(android.content.Context context, java.io.File file) {
        android.database.Cursor cursorQuery = context.getContentResolver().query(android.provider.MediaStore.Files.getContentUri("external"), new java.lang.String[]{"_id"}, "_data=? ", new java.lang.String[]{file.getAbsolutePath()}, null);
        if (cursorQuery != null) {
            contentUri = cursorQuery.moveToFirst() ? android.provider.MediaStore.Files.getContentUri("external", cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))) : null;
            cursorQuery.close();
        }
        return contentUri;
    }

    private static android.net.Uri getImageContentUri(android.content.Context context, java.io.File file) {
        java.lang.String absolutePath = file.getAbsolutePath();
        android.database.Cursor cursorQuery = context.getContentResolver().query(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new java.lang.String[]{"_id"}, "_data=? ", new java.lang.String[]{absolutePath}, null);
        android.net.Uri uriWithAppendedPath = null;
        if (cursorQuery != null) {
            if (cursorQuery.moveToFirst()) {
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                uriWithAppendedPath = android.net.Uri.withAppendedPath(android.net.Uri.parse("content://media/external/images/media"), "" + i);
            }
            cursorQuery.close();
        }
        if (uriWithAppendedPath != null) {
            return uriWithAppendedPath;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_data", absolutePath);
        return context.getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    private static android.net.Uri getVideoContentUri(android.content.Context context, java.io.File file) {
        java.lang.String absolutePath = file.getAbsolutePath();
        android.database.Cursor cursorQuery = context.getContentResolver().query(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new java.lang.String[]{"_id"}, "_data=? ", new java.lang.String[]{absolutePath}, null);
        android.net.Uri uriWithAppendedPath = null;
        if (cursorQuery != null) {
            if (cursorQuery.moveToFirst()) {
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                uriWithAppendedPath = android.net.Uri.withAppendedPath(android.net.Uri.parse("content://media/external/video/media"), "" + i);
            }
            cursorQuery.close();
        }
        if (uriWithAppendedPath != null) {
            return uriWithAppendedPath;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_data", absolutePath);
        return context.getContentResolver().insert(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    private static android.net.Uri getAudioContentUri(android.content.Context context, java.io.File file) {
        java.lang.String absolutePath = file.getAbsolutePath();
        android.database.Cursor cursorQuery = context.getContentResolver().query(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new java.lang.String[]{"_id"}, "_data=? ", new java.lang.String[]{absolutePath}, null);
        android.net.Uri uriWithAppendedPath = null;
        if (cursorQuery != null) {
            if (cursorQuery.moveToFirst()) {
                int i = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
                uriWithAppendedPath = android.net.Uri.withAppendedPath(android.net.Uri.parse("content://media/external/audio/media"), "" + i);
            }
            cursorQuery.close();
        }
        if (uriWithAppendedPath != null) {
            return uriWithAppendedPath;
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_data", absolutePath);
        return context.getContentResolver().insert(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    private static boolean isExternalStorageDocument(android.net.Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isDownloadsDocument(android.net.Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(android.net.Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private static java.lang.String getDataColumn(android.content.Context context, android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) throws java.lang.Throwable {
        android.database.Cursor cursor = null;
        try {
            android.database.Cursor cursorQuery = context.getContentResolver().query(uri, new java.lang.String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
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
}
