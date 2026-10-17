package com.up366.view.crop.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class FileUtils {
    private static final java.lang.String TAG = "FileUtils";

    private FileUtils() {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getDataColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String[] r11) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L33
            r6 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L31 java.lang.IllegalArgumentException -> L33
            if (r8 == 0) goto L2b
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L52
            if (r9 == 0) goto L2b
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L52
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.IllegalArgumentException -> L29 java.lang.Throwable -> L52
            if (r8 == 0) goto L28
            r8.close()
        L28:
            return r9
        L29:
            r9 = move-exception
            goto L35
        L2b:
            if (r8 == 0) goto L51
        L2d:
            r8.close()
            goto L51
        L31:
            r9 = move-exception
            goto L54
        L33:
            r9 = move-exception
            r8 = r7
        L35:
            java.lang.String r10 = "FileUtils"
            java.util.Locale r11 = java.util.Locale.getDefault()     // Catch: java.lang.Throwable -> L52
            java.lang.String r0 = "getDataColumn: _data - [%s]"
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L52
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L52
            r2 = 0
            r1[r2] = r9     // Catch: java.lang.Throwable -> L52
            java.lang.String r9 = java.lang.String.format(r11, r0, r1)     // Catch: java.lang.Throwable -> L52
            android.util.Log.i(r10, r9)     // Catch: java.lang.Throwable -> L52
            if (r8 == 0) goto L51
            goto L2d
        L51:
            return r7
        L52:
            r9 = move-exception
            r7 = r8
        L54:
            if (r7 == 0) goto L59
            r7.close()
        L59:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.view.crop.util.FileUtils.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static java.lang.String getPath(android.content.Context context, android.net.Uri uri) {
        android.net.Uri uri2 = null;
        if (android.provider.DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                java.lang.String[] strArrSplit = android.provider.DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return android.os.Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                }
            } else if (isDownloadsDocument(uri)) {
                java.lang.String documentId = android.provider.DocumentsContract.getDocumentId(uri);
                if (!android.text.TextUtils.isEmpty(documentId)) {
                    try {
                        return getDataColumn(context, android.content.ContentUris.withAppendedId(android.net.Uri.parse("content://downloads/public_downloads"), java.lang.Long.valueOf(documentId).longValue()), null, null);
                    } catch (java.lang.NumberFormatException e) {
                        android.util.Log.i(TAG, e.getMessage());
                        return null;
                    }
                }
            } else if (isMediaDocument(uri)) {
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
        return null;
    }

    public static void copyFile(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.nio.channels.FileChannel fileChannel;
        java.nio.channels.FileChannel channel;
        if (str.equalsIgnoreCase(str2)) {
            return;
        }
        java.nio.channels.FileChannel channel2 = null;
        try {
            channel = new java.io.FileInputStream(new java.io.File(str)).getChannel();
        } catch (java.lang.Throwable th) {
            th = th;
            fileChannel = null;
        }
        try {
            channel2 = new java.io.FileOutputStream(new java.io.File(str2)).getChannel();
            channel.transferTo(0L, channel.size(), channel2);
            channel.close();
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            java.nio.channels.FileChannel fileChannel2 = channel2;
            channel2 = channel;
            fileChannel = fileChannel2;
            if (channel2 != null) {
                channel2.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            throw th;
        }
    }
}
