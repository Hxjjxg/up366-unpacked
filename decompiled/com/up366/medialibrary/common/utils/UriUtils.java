package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UriUtils {
    public static boolean isFileExistByUri(android.content.Context context, android.net.Uri uri) throws java.lang.Throwable {
        if (uri == null) {
            return false;
        }
        java.lang.String filePath = getFilePath(context, uri);
        if (!android.text.TextUtils.isEmpty(filePath)) {
            return new java.io.File(filePath).exists();
        }
        if (uriStartWithFile(uri)) {
            java.lang.String path = uri.getPath();
            boolean zExists = new java.io.File(path).exists();
            com.up366.common.log.Logger.debug("file uri exist = " + zExists + " file length = " + new java.io.File(path).length());
            return zExists;
        }
        if (!uriStartWithContent(uri)) {
            return uri.toString().startsWith("/") && new java.io.File(uri.toString()).exists();
        }
        androidx.documentfile.provider.DocumentFile documentFileFromSingleUri = androidx.documentfile.provider.DocumentFile.fromSingleUri(context, uri);
        return documentFileFromSingleUri != null && documentFileFromSingleUri.exists();
    }

    public static boolean uriStartWithFile(android.net.Uri uri) {
        return "file".equalsIgnoreCase(uri.getScheme()) && uri.toString().length() > 7;
    }

    public static boolean uriStartWithContent(android.net.Uri uri) {
        return com.igexin.sdk.FlymePushReceiver.CONTENT.equalsIgnoreCase(uri.getScheme());
    }

    public static java.lang.String getFileNameByUri(android.content.Context context, android.net.Uri uri) throws java.lang.Throwable {
        java.lang.String name;
        if (context == null || uri == null) {
            return "";
        }
        if (context.getContentResolver().getType(uri) == null) {
            java.lang.String filePath = getFilePath(context, uri);
            if (android.text.TextUtils.isEmpty(filePath)) {
                name = getName(uri.toString());
            } else {
                name = new java.io.File(filePath).getName();
            }
        } else {
            android.database.Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                int columnIndex = cursorQuery.getColumnIndex("_display_name");
                cursorQuery.moveToFirst();
                java.lang.String string = cursorQuery.getString(columnIndex);
                cursorQuery.close();
                name = string;
            } else {
                name = null;
            }
        }
        com.up366.common.log.Logger.debug("getFileNameByUri filename: " + name);
        return name;
    }

    private static java.lang.String getName(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return str.substring(str.lastIndexOf(47) + 1);
    }

    public static long getFileLength(android.content.Context context, android.net.Uri uri) throws java.lang.Throwable {
        long length = 0;
        if (context.getContentResolver().getType(uri) == null) {
            java.lang.String filePath = getFilePath(context, uri);
            if (!android.text.TextUtils.isEmpty(filePath)) {
                length = new java.io.File(filePath).length();
            }
        } else {
            android.database.Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                int columnIndex = cursorQuery.getColumnIndex("_size");
                cursorQuery.moveToFirst();
                length = cursorQuery.getLong(columnIndex);
                cursorQuery.close();
            }
        }
        com.up366.common.log.Logger.debug("getFileLength fileSize: " + length);
        return length;
    }

    public static int getVideoOrAudioDuration(android.content.Context context, android.net.Uri uri) throws java.lang.Throwable {
        long j;
        android.media.MediaMetadataRetriever mediaMetadataRetriever;
        android.database.Cursor cursorQuery = context.getContentResolver().query(uri, new java.lang.String[]{"duration"}, null, null, null);
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            j = 0;
        } else {
            j = cursorQuery.getLong(cursorQuery.getColumnIndex("duration"));
            cursorQuery.close();
        }
        if (j <= 0) {
            android.media.MediaMetadataRetriever mediaMetadataRetriever2 = null;
            try {
                try {
                    mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
                } catch (java.lang.Exception e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                mediaMetadataRetriever.setDataSource(context, uri);
                j = com.up366.medialibrary.common.utils.ValueOf.toLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
            } catch (java.lang.Exception e2) {
                e = e2;
                mediaMetadataRetriever2 = mediaMetadataRetriever;
                com.up366.common.log.Logger.error("getVideoOrAudioDuration error " + e.getMessage(), e);
                if (mediaMetadataRetriever2 != null) {
                    mediaMetadataRetriever2.release();
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                mediaMetadataRetriever2 = mediaMetadataRetriever;
                if (mediaMetadataRetriever2 != null) {
                    mediaMetadataRetriever2.release();
                }
                throw th;
            }
        }
        long j2 = j > 0 ? j : 0L;
        com.up366.common.log.Logger.debug("duration:" + j2);
        return (int) j2;
    }

    private static androidx.documentfile.provider.DocumentFile getDocumentFile(android.content.Context context, android.net.Uri uri) {
        if (uri == null) {
            com.up366.common.log.Logger.error("uri is null");
            return null;
        }
        androidx.documentfile.provider.DocumentFile documentFileFromSingleUri = androidx.documentfile.provider.DocumentFile.fromSingleUri(context, uri);
        if (documentFileFromSingleUri != null) {
            return documentFileFromSingleUri;
        }
        com.up366.common.log.Logger.error("DocumentFile is null");
        return null;
    }

    public static java.lang.String getUriString(android.net.Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    public static android.net.Uri getLocalUriFromString(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        android.net.Uri uri = android.net.Uri.parse(str);
        if (uriStartWithContent(uri)) {
            return uri;
        }
        if (str.startsWith("file") && str.length() > 7) {
            return android.net.Uri.fromFile(new java.io.File(android.net.Uri.parse(str).getPath()));
        }
        if (str.startsWith("/")) {
            return android.net.Uri.fromFile(new java.io.File(str));
        }
        return null;
    }

    public static java.lang.String getMimeType(android.content.Context context, android.net.Uri uri) throws java.lang.Throwable {
        java.lang.String type = context.getContentResolver().getType(uri);
        if (android.text.TextUtils.isEmpty(type)) {
            java.lang.String filePath = getFilePath(context, uri);
            if (!android.text.TextUtils.isEmpty(filePath)) {
                type = getMimeType(new java.io.File(filePath));
            }
        }
        com.up366.common.log.Logger.debug("getMimeType mimeType: " + type);
        return type;
    }

    public static java.lang.String getMimeType(java.io.File file) {
        return com.up366.medialibrary.common.utils.MediaUtils.getMIMEType(file);
    }

    public static java.lang.String getMimeType(java.lang.String str) {
        if (str.endsWith(".3gp")) {
            return "audio/3gp";
        }
        if (str.endsWith(".jpe") || str.endsWith(".jpeg") || str.endsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.JPG)) {
            return "image/jpeg";
        }
        if (str.endsWith(".amr")) {
            return "audio/amr";
        }
        if (str.endsWith(".mp4")) {
            return "video/mp4";
        }
        if (str.endsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.MP3)) {
            return "audio/mpeg";
        }
        return "application/octet-stream";
    }

    public static java.lang.String getFilePath(android.content.Context context, java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) ? str : getFilePath(context, android.net.Uri.parse(str));
    }

    public static java.lang.String getFilePath(android.content.Context context, android.net.Uri uri) throws java.lang.Throwable {
        java.lang.String dataColumn;
        java.lang.String dataColumn2;
        java.lang.String dataColumn3;
        java.lang.String dataColumn4;
        if (uri == null) {
            return "";
        }
        if (!com.up366.medialibrary.common.utils.VersionUtils.isTargetQ()) {
            android.net.Uri uri2 = null;
            if (android.provider.DocumentsContract.isDocumentUri(context, uri)) {
                if (isExternalStorageDocument(uri)) {
                    java.lang.String[] strArrSplit = android.provider.DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                        return android.os.Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                } else {
                    if (isDownloadsDocument(uri)) {
                        java.lang.String documentId = android.provider.DocumentsContract.getDocumentId(uri);
                        if (documentId.startsWith("raw:")) {
                            return documentId.replaceFirst("raw:", "");
                        }
                        java.lang.String[] strArr = {"content://downloads/public_downloads", "content://downloads/my_downloads", "content://downloads/all_downloads"};
                        if (android.os.Build.VERSION.SDK_INT < 26) {
                            for (int i = 0; i < 3; i++) {
                                try {
                                    dataColumn4 = getDataColumn(context, android.content.ContentUris.withAppendedId(android.net.Uri.parse(strArr[i]), com.up366.medialibrary.common.utils.ValueOf.toLong(documentId)), null, null);
                                } catch (java.lang.Exception unused) {
                                }
                                if (!android.text.TextUtils.isEmpty(dataColumn4)) {
                                    return dataColumn4;
                                }
                            }
                            return "";
                        }
                        try {
                            dataColumn3 = getDataColumn(context, uri, null, null);
                        } catch (java.lang.Exception unused2) {
                        }
                        return !android.text.TextUtils.isEmpty(dataColumn3) ? dataColumn3 : "";
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
                        try {
                            dataColumn2 = getDataColumn(context, uri2, "_id=?", new java.lang.String[]{strArrSplit2[1]});
                        } catch (java.lang.Exception unused3) {
                        }
                        return !android.text.TextUtils.isEmpty(dataColumn2) ? dataColumn2 : "";
                    }
                }
            } else {
                if (isFileProvider(context, uri)) {
                    return getFPUriToPath(context, uri);
                }
                if (isOtherFileProvider(context, uri)) {
                    return copyFileProviderUri(context, uri);
                }
                if (uriStartWithContent(uri)) {
                    try {
                        dataColumn = getDataColumn(context, uri, null, null);
                    } catch (java.lang.Exception unused4) {
                    }
                    return !android.text.TextUtils.isEmpty(dataColumn) ? dataColumn : "";
                }
            }
        }
        if (isFileProvider(context, uri)) {
            return getFPUriToPath(context, uri);
        }
        if (isOtherFileProvider(context, uri)) {
            return copyFileProviderUri(context, uri);
        }
        if (uriStartWithFile(uri)) {
            return uri.getPath();
        }
        if (!uri.toString().startsWith("/")) {
            return "";
        }
        return uri.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009a A[Catch: IOException -> 0x0096, TRY_LEAVE, TryCatch #1 {IOException -> 0x0096, blocks: (B:47:0x0092, B:51:0x009a), top: B:55:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String copyFileProviderUri(android.content.Context r6, android.net.Uri r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = getFileNameByUri(r6, r7)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = ""
            if (r1 == 0) goto Ld
            return r2
        Ld:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.up366.medialibrary.common.utils.MediaPathUtil r3 = com.up366.medialibrary.common.utils.MediaPathUtil.getInst()
            java.lang.String r3 = r3.getFilePath()
            r1.append(r3)
            java.lang.String r3 = java.io.File.separator
            r1.append(r3)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L35
            return r0
        L35:
            r1 = 0
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            java.io.InputStream r6 = r6.openInputStream(r7)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
            r7.<init>(r0)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
            r1 = 2048(0x800, float:2.87E-42)
            byte[] r1 = new byte[r1]     // Catch: java.io.IOException -> L5c java.lang.Throwable -> L8e
        L47:
            int r3 = r6.read(r1)     // Catch: java.io.IOException -> L5c java.lang.Throwable -> L8e
            r4 = -1
            if (r3 == r4) goto L53
            r4 = 0
            r7.write(r1, r4, r3)     // Catch: java.io.IOException -> L5c java.lang.Throwable -> L8e
            goto L47
        L53:
            if (r6 == 0) goto L58
            r6.close()     // Catch: java.io.IOException -> L76
        L58:
            r7.close()     // Catch: java.io.IOException -> L76
            goto L81
        L5c:
            r1 = move-exception
            goto L6d
        L5e:
            r0 = move-exception
            r7 = r1
            goto L8f
        L61:
            r7 = move-exception
            r5 = r1
            r1 = r7
            r7 = r5
            goto L6d
        L66:
            r0 = move-exception
            r7 = r1
            goto L90
        L69:
            r6 = move-exception
            r7 = r1
            r1 = r6
            r6 = r7
        L6d:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L8e
            if (r6 == 0) goto L78
            r6.close()     // Catch: java.io.IOException -> L76
            goto L78
        L76:
            r6 = move-exception
            goto L7e
        L78:
            if (r7 == 0) goto L81
            r7.close()     // Catch: java.io.IOException -> L76
            goto L81
        L7e:
            r6.printStackTrace()
        L81:
            java.io.File r6 = new java.io.File
            r6.<init>(r0)
            boolean r6 = r6.exists()
            if (r6 == 0) goto L8d
            r2 = r0
        L8d:
            return r2
        L8e:
            r0 = move-exception
        L8f:
            r1 = r6
        L90:
            if (r1 == 0) goto L98
            r1.close()     // Catch: java.io.IOException -> L96
            goto L98
        L96:
            r6 = move-exception
            goto L9e
        L98:
            if (r7 == 0) goto La1
            r7.close()     // Catch: java.io.IOException -> L96
            goto La1
        L9e:
            r6.printStackTrace()
        La1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.medialibrary.common.utils.UriUtils.copyFileProviderUri(android.content.Context, android.net.Uri):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0040, code lost:
    
        if (r7.name.equalsIgnoreCase(r2) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
    
        r3 = androidx.core.content.FileProvider.class.getDeclaredMethod("getPathStrategy", android.content.Context.class, java.lang.String.class);
        r3.setAccessible(true);
        r3 = r3.invoke(null, r10, r11.getAuthority());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
    
        if (r3 == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        r4 = java.lang.Class.forName(androidx.core.content.FileProvider.class.getName() + "$PathStrategy").getDeclaredMethod("getFileForUri", android.net.Uri.class);
        r4.setAccessible(true);
        r3 = r4.invoke(r3, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x009d, code lost:
    
        if ((r3 instanceof java.io.File) == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a5, code lost:
    
        return ((java.io.File) r3).getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a6, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a7, code lost:
    
        com.up366.common.log.Logger.error("getFPUriToPath error " + r3.getMessage(), r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0017, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0017, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0017, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0017, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getFPUriToPath(android.content.Context r10, android.net.Uri r11) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.medialibrary.common.utils.UriUtils.getFPUriToPath(android.content.Context, android.net.Uri):java.lang.String");
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

    public static boolean isFileProvider(android.content.Context context, android.net.Uri uri) {
        return (context.getApplicationInfo().packageName + ".fileProvider").equalsIgnoreCase(uri.getAuthority());
    }

    public static boolean isOtherFileProvider(android.content.Context context, android.net.Uri uri) {
        java.lang.String scheme = uri.getScheme();
        java.lang.String authority = uri.getAuthority();
        if (android.text.TextUtils.isEmpty(scheme) || android.text.TextUtils.isEmpty(authority)) {
            return false;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(context.getApplicationInfo().packageName);
        sb.append(".fileProvider");
        return !sb.toString().equalsIgnoreCase(uri.getAuthority()) && com.igexin.sdk.FlymePushReceiver.CONTENT.equalsIgnoreCase(uri.getScheme()) && authority.contains(".fileProvider".toLowerCase());
    }

    public static android.net.Uri takePersistableUriPermission(android.content.Context context, android.net.Uri uri) {
        if (context == null || uri == null || !uriStartWithContent(uri)) {
            return null;
        }
        java.lang.String lastSubFromUri = getLastSubFromUri(uri);
        if (!android.text.TextUtils.isEmpty(lastSubFromUri)) {
            java.lang.String uriPermission = com.up366.medialibrary.common.utils.MMKVUtils.getInst().getUriPermission(lastSubFromUri);
            if (!android.text.TextUtils.isEmpty(uriPermission)) {
                try {
                    context.getContentResolver().takePersistableUriPermission(android.net.Uri.parse(uriPermission), 1);
                    return android.net.Uri.parse(uriPermission);
                } catch (java.lang.SecurityException e) {
                    com.up366.common.log.Logger.error("takePersistableUriPermission failed e: " + e.getMessage(), e);
                    return null;
                }
            }
        }
        try {
            context.getContentResolver().takePersistableUriPermission(uri, 1);
            return uri;
        } catch (java.lang.SecurityException e2) {
            com.up366.common.log.Logger.error("takePersistableUriPermission failed e: " + e2.getMessage(), e2);
            return null;
        }
    }

    private static java.lang.String getLastSubFromUri(android.net.Uri uri) {
        if (uri == null) {
            return "";
        }
        java.lang.String string = uri.toString();
        if (!string.contains("/")) {
            return "";
        }
        return string.substring(string.lastIndexOf("/") + 1);
    }
}
