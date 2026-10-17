package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureFileUtils {
    private static final int BYTE_SIZE = 1024;
    public static final int GB = 1073741824;
    public static final int KB = 1024;
    public static final int MB = 1048576;
    public static final java.lang.String POSTFIX = ".jpeg";
    public static final java.lang.String POST_AUDIO = ".amr";
    public static final java.lang.String POST_VIDEO = ".mp4";
    static final java.lang.String TAG = "PictureFileUtils";

    public static java.io.File createCameraFile(android.content.Context context, int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return createMediaFile(context, i, str, str2, str3);
    }

    private static java.io.File createMediaFile(android.content.Context context, int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return createOutFile(context, i, str, str2, str3);
    }

    private static java.io.File createOutFile(android.content.Context context, int i, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.io.File file;
        java.io.File rootDirFile;
        android.content.Context applicationContext = context.getApplicationContext();
        if (android.text.TextUtils.isEmpty(str3)) {
            if (android.text.TextUtils.equals("mounted", android.os.Environment.getExternalStorageState())) {
                rootDirFile = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DCIM);
                file = new java.io.File(rootDirFile.getAbsolutePath() + java.io.File.separator + com.up366.medialibrary.common.utils.MimeTypeUtils.CAMERA + java.io.File.separator);
            } else {
                rootDirFile = getRootDirFile(applicationContext, i);
                file = new java.io.File(rootDirFile.getAbsolutePath() + java.io.File.separator);
            }
            if (!rootDirFile.exists()) {
                rootDirFile.mkdirs();
            }
        } else {
            java.io.File file2 = new java.io.File(str3);
            if (!((java.io.File) java.util.Objects.requireNonNull(file2.getParentFile())).exists()) {
                file2.getParentFile().mkdirs();
            }
            file = file2;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        boolean zIsEmpty = android.text.TextUtils.isEmpty(str);
        if (i == 2) {
            if (zIsEmpty) {
                str = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("VID_") + ".mp4";
            }
            return new java.io.File(file, str);
        }
        if (i == 3) {
            if (zIsEmpty) {
                str = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("AUD_") + ".amr";
            }
            return new java.io.File(file, str);
        }
        if (android.text.TextUtils.isEmpty(str2)) {
            str2 = ".jpeg";
        }
        if (zIsEmpty) {
            str = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("IMG_") + str2;
        }
        return new java.io.File(file, str);
    }

    private static java.io.File getRootDirFile(android.content.Context context, int i) {
        if (i == 2) {
            return context.getExternalFilesDir(android.os.Environment.DIRECTORY_MOVIES);
        }
        if (i == 3) {
            return context.getExternalFilesDir(android.os.Environment.DIRECTORY_MUSIC);
        }
        return context.getExternalFilesDir(android.os.Environment.DIRECTORY_PICTURES);
    }

    private PictureFileUtils() {
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

    public static java.lang.String getDataColumn(android.content.Context context, android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        android.database.Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(uri, new java.lang.String[]{"_data"}, str, strArr, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return string;
                }
                if (cursorQuery == null) {
                    return "";
                }
            } catch (java.lang.IllegalArgumentException e) {
                android.util.Log.i(TAG, java.lang.String.format(java.util.Locale.getDefault(), "getDataColumn: _data - [%s]", e.getMessage()));
                if (cursorQuery == null) {
                    return "";
                }
            }
            cursorQuery.close();
            return "";
        } catch (java.lang.Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public static java.lang.String getPath(android.content.Context context, android.net.Uri uri) {
        android.content.Context applicationContext = context.getApplicationContext();
        android.net.Uri uri2 = null;
        if (android.provider.DocumentsContract.isDocumentUri(applicationContext, uri)) {
            if (isExternalStorageDocument(uri)) {
                java.lang.String[] strArrSplit = android.provider.DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
                        return applicationContext.getExternalFilesDir(android.os.Environment.DIRECTORY_PICTURES) + "/" + strArrSplit[1];
                    }
                    return android.os.Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                }
                return "";
            }
            if (isDownloadsDocument(uri)) {
                return getDataColumn(applicationContext, android.content.ContentUris.withAppendedId(android.net.Uri.parse("content://downloads/public_downloads"), com.up366.medialibrary.common.utils.ValueOf.toLong(android.provider.DocumentsContract.getDocumentId(uri))), null, null);
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
                return getDataColumn(applicationContext, uri2, "_id=?", new java.lang.String[]{strArrSplit2[1]});
            }
            return "";
        }
        if (com.igexin.sdk.FlymePushReceiver.CONTENT.equalsIgnoreCase(uri.getScheme())) {
            if (isGooglePhotosUri(uri)) {
                return uri.getLastPathSegment();
            }
            return getDataColumn(applicationContext, uri, null, null);
        }
        if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return "";
    }

    public static void copyFile(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.nio.channels.FileChannel fileChannel;
        java.nio.channels.FileChannel channel;
        if (str.equalsIgnoreCase(str2)) {
            return;
        }
        java.nio.channels.FileChannel channel2 = null;
        try {
            try {
                channel = new java.io.FileInputStream(str).getChannel();
                try {
                    channel2 = new java.io.FileOutputStream(str2).getChannel();
                    channel.transferTo(0L, channel.size(), channel2);
                } catch (java.lang.Exception unused) {
                    com.up366.common.log.Logger.error("copyFile  error " + str + "   pathInfo " + str2);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                fileChannel = channel2;
                channel2 = channel;
                close(channel2);
                close(fileChannel);
                throw th;
            }
        } catch (java.lang.Exception unused2) {
            channel = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileChannel = null;
            close(channel2);
            close(fileChannel);
            throw th;
        }
        close(channel);
        close(channel2);
    }

    public static void copyFileThrowException(java.lang.String str, java.lang.String str2) throws java.lang.Exception {
        java.nio.channels.FileChannel fileChannel;
        java.nio.channels.FileChannel channel;
        if (str.equalsIgnoreCase(str2)) {
            return;
        }
        java.nio.channels.FileChannel channel2 = null;
        try {
            channel = new java.io.FileInputStream(str).getChannel();
        } catch (java.lang.Throwable th) {
            th = th;
            fileChannel = null;
        }
        try {
            channel2 = new java.io.FileOutputStream(str2).getChannel();
            channel.transferTo(0L, channel.size(), channel2);
            close(channel);
            close(channel2);
        } catch (java.lang.Throwable th2) {
            th = th2;
            java.nio.channels.FileChannel fileChannel2 = channel2;
            channel2 = channel;
            fileChannel = fileChannel2;
            close(channel2);
            close(fileChannel);
            throw th;
        }
    }

    public static boolean writeFileFromIS(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.lang.Throwable {
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.BufferedInputStream bufferedInputStream;
        java.io.BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new java.io.BufferedInputStream(inputStream);
            try {
                bufferedOutputStream = new java.io.BufferedOutputStream(outputStream);
            } catch (java.lang.Exception e) {
                e = e;
                bufferedOutputStream = null;
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedOutputStream = null;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            bufferedOutputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = bufferedInputStream.read(bArr);
                if (i != -1) {
                    outputStream.write(bArr, 0, i);
                } else {
                    outputStream.flush();
                    close(bufferedInputStream);
                    close(bufferedOutputStream);
                    return true;
                }
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            bufferedInputStream2 = bufferedInputStream;
            try {
                e.printStackTrace();
                close(bufferedInputStream2);
                close(bufferedOutputStream);
                return false;
            } catch (java.lang.Throwable th3) {
                th = th3;
                close(bufferedInputStream2);
                close(bufferedOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            bufferedInputStream2 = bufferedInputStream;
            close(bufferedInputStream2);
            close(bufferedOutputStream);
            throw th;
        }
    }

    public static java.lang.String rename(java.lang.String str) {
        return str.substring(0, str.lastIndexOf(".")) + "_" + com.up366.medialibrary.common.utils.DateUtils.getCreateFileName() + str.substring(str.lastIndexOf("."));
    }

    public static java.lang.String getDCIMCameraPath() {
        try {
            return "%" + android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DCIM).getAbsolutePath() + "/Camera";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @java.lang.Deprecated
    public static void deleteCacheDirFile(android.content.Context context, int i) {
        java.io.File[] fileArrListFiles;
        java.io.File externalFilesDir = context.getExternalFilesDir(i == com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage() ? android.os.Environment.DIRECTORY_PICTURES : android.os.Environment.DIRECTORY_MOVIES);
        if (externalFilesDir == null || (fileArrListFiles = externalFilesDir.listFiles()) == null) {
            return;
        }
        for (java.io.File file : fileArrListFiles) {
            if (file.isFile()) {
                file.delete();
            }
        }
    }

    public static java.lang.String getDiskCacheDir(android.content.Context context) {
        java.io.File externalFilesDir = context.getExternalFilesDir(android.os.Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            return "";
        }
        return externalFilesDir.getPath();
    }

    public static java.lang.String getVideoDiskCacheDir(android.content.Context context) {
        java.io.File externalFilesDir = context.getExternalFilesDir(android.os.Environment.DIRECTORY_MOVIES);
        if (externalFilesDir == null) {
            return "";
        }
        return externalFilesDir.getPath();
    }

    public static java.lang.String getAudioDiskCacheDir(android.content.Context context) {
        java.io.File externalFilesDir = context.getExternalFilesDir(android.os.Environment.DIRECTORY_MUSIC);
        if (externalFilesDir == null) {
            return "";
        }
        return externalFilesDir.getPath();
    }

    public static android.net.Uri parUri(android.content.Context context, java.io.File file) {
        java.lang.String str = context.getPackageName() + ".up366MediaProvider";
        if (android.os.Build.VERSION.SDK_INT > 23) {
            return androidx.core.content.FileProvider.getUriForFile(context, str, file);
        }
        return android.net.Uri.fromFile(file);
    }

    public static java.lang.String createFilePath(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String lastImgSuffix = com.up366.medialibrary.common.utils.MimeTypeUtils.getLastImgSuffix(str2);
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(str2)) {
            java.lang.String str4 = getVideoDiskCacheDir(context) + java.io.File.separator;
            if (android.text.TextUtils.isEmpty(str)) {
                if (android.text.TextUtils.isEmpty(str3)) {
                    str3 = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("VID_") + lastImgSuffix;
                }
                return str4 + str3;
            }
            if (android.text.TextUtils.isEmpty(str3)) {
                str3 = "VID_" + str.toUpperCase() + lastImgSuffix;
            }
            return str4 + str3;
        }
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHasAudio(str2)) {
            java.lang.String str5 = getAudioDiskCacheDir(context) + java.io.File.separator;
            if (android.text.TextUtils.isEmpty(str)) {
                if (android.text.TextUtils.isEmpty(str3)) {
                    str3 = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("AUD_") + lastImgSuffix;
                }
                return str5 + str3;
            }
            if (android.text.TextUtils.isEmpty(str3)) {
                str3 = "AUD_" + str.toUpperCase() + lastImgSuffix;
            }
            return str5 + str3;
        }
        java.lang.String str6 = getDiskCacheDir(context) + java.io.File.separator;
        if (android.text.TextUtils.isEmpty(str)) {
            if (android.text.TextUtils.isEmpty(str3)) {
                str3 = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("IMG_") + lastImgSuffix;
            }
            return str6 + str3;
        }
        if (android.text.TextUtils.isEmpty(str3)) {
            str3 = "IMG_" + str.toUpperCase() + lastImgSuffix;
        }
        return str6 + str3;
    }

    public static boolean isFileExists(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str) || new java.io.File(str).exists();
    }

    public static java.lang.String formatFileSize(long j, int i) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("precision shouldn't be less than zero!");
        }
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteSize shouldn't be less than zero!");
        }
        if (j < 1024) {
            return java.lang.String.format("%." + i + "fB", java.lang.Double.valueOf(j));
        }
        if (j < com.up366.medialibrary.config.PictureConstants.MB) {
            return java.lang.String.format("%." + i + "fKB", java.lang.Double.valueOf(j / 1024.0d));
        }
        if (j < 1073741824) {
            return java.lang.String.format("%." + i + "fMB", java.lang.Double.valueOf(j / 1048576.0d));
        }
        return java.lang.String.format("%." + i + "fGB", java.lang.Double.valueOf(j / 1.073741824E9d));
    }

    public static void close(java.io.Closeable closeable) {
        if (closeable instanceof java.io.Closeable) {
            try {
                closeable.close();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static boolean uriStartWithContent(android.net.Uri uri) {
        return com.igexin.sdk.FlymePushReceiver.CONTENT.equalsIgnoreCase(uri.getScheme());
    }
}
