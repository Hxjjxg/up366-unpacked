package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MediaUtils {
    public static boolean isLargeImg(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return false;
        }
        return i2 > i * 3 || i > 7000;
    }

    public static boolean isLongImg(int i, int i2) {
        return i > 0 && i2 > 0 && i2 > i * 3;
    }

    public static boolean isLongImg(com.up366.medialibrary.model.LocalMedia localMedia) {
        int width = localMedia.getWidth();
        int height = localMedia.getHeight();
        return width > 0 && height > 0 && height > width * 3;
    }

    public static com.up366.medialibrary.model.MediaExtraInfo getImageSize(android.content.Context context, java.lang.String str) {
        androidx.exifinterface.media.ExifInterface exifInterface;
        com.up366.medialibrary.model.MediaExtraInfo mediaExtraInfo = new com.up366.medialibrary.model.MediaExtraInfo();
        try {
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str)) {
                exifInterface = new androidx.exifinterface.media.ExifInterface(com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(context, android.net.Uri.parse(str)));
            } else {
                exifInterface = new androidx.exifinterface.media.ExifInterface(str);
            }
            mediaExtraInfo.setWidth(exifInterface.getAttributeInt("ImageWidth", 1));
            mediaExtraInfo.setHeight(exifInterface.getAttributeInt("ImageLength", 1));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return mediaExtraInfo;
    }

    public static com.up366.medialibrary.model.MediaExtraInfo getImageSize(java.lang.String str) {
        java.io.InputStream fileInputStream;
        com.up366.medialibrary.model.MediaExtraInfo mediaExtraInfo = new com.up366.medialibrary.model.MediaExtraInfo();
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str)) {
                fileInputStream = com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(com.up366.medialibrary.app.PictureAppMaster.getInstance().getAppContext(), android.net.Uri.parse(str));
            } else {
                fileInputStream = new java.io.FileInputStream(str);
            }
            android.graphics.BitmapFactory.decodeStream(fileInputStream, null, options);
            mediaExtraInfo.setWidth(options.outWidth);
            mediaExtraInfo.setHeight(options.outHeight);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return mediaExtraInfo;
    }

    public static com.up366.medialibrary.model.MediaExtraInfo getVideoSize(android.content.Context context, java.lang.String str) throws java.io.IOException {
        int i;
        int i2;
        com.up366.medialibrary.model.MediaExtraInfo mediaExtraInfo = new com.up366.medialibrary.model.MediaExtraInfo();
        android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
        try {
            try {
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str)) {
                    mediaMetadataRetriever.setDataSource(context, android.net.Uri.parse(str));
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                java.lang.String strExtractMetadata = mediaMetadataRetriever.extractMetadata(24);
                if (android.text.TextUtils.equals("90", strExtractMetadata) || android.text.TextUtils.equals("270", strExtractMetadata)) {
                    i = com.up366.medialibrary.common.utils.ValueOf.toInt(mediaMetadataRetriever.extractMetadata(18));
                    i2 = com.up366.medialibrary.common.utils.ValueOf.toInt(mediaMetadataRetriever.extractMetadata(19));
                } else {
                    i2 = com.up366.medialibrary.common.utils.ValueOf.toInt(mediaMetadataRetriever.extractMetadata(18));
                    i = com.up366.medialibrary.common.utils.ValueOf.toInt(mediaMetadataRetriever.extractMetadata(19));
                }
                mediaExtraInfo.setWidth(i2);
                mediaExtraInfo.setHeight(i);
                mediaExtraInfo.setDuration(com.up366.medialibrary.common.utils.ValueOf.toLong(mediaMetadataRetriever.extractMetadata(9)));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            return mediaExtraInfo;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static com.up366.medialibrary.model.MediaExtraInfo getAudioSize(android.content.Context context, java.lang.String str) throws java.io.IOException {
        com.up366.medialibrary.model.MediaExtraInfo mediaExtraInfo = new com.up366.medialibrary.model.MediaExtraInfo();
        android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
        try {
            try {
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str)) {
                    mediaMetadataRetriever.setDataSource(context, android.net.Uri.parse(str));
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                mediaExtraInfo.setDuration(com.up366.medialibrary.common.utils.ValueOf.toLong(mediaMetadataRetriever.extractMetadata(9)));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            return mediaExtraInfo;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public static void removeMedia(android.content.Context context, int i) {
        try {
            context.getApplicationContext().getContentResolver().delete(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new java.lang.String[]{java.lang.Long.toString(i)});
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getDCIMLastImageId(android.content.Context r10) {
        /*
            r0 = -1
            r1 = 0
            java.lang.String r2 = com.up366.medialibrary.common.utils.PictureFileUtils.getDCIMCameraPath()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r6 = "_data like ?"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r3.<init>()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r3.append(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r2 = "%"
            r3.append(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String[] r7 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            boolean r2 = com.up366.medialibrary.common.utils.SdkVersionUtils.isR()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r9 = 1
            if (r2 == 0) goto L38
            r2 = 0
            android.os.Bundle r2 = createQueryArgsBundle(r6, r7, r9, r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            android.content.Context r10 = r10.getApplicationContext()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            android.net.Uri r3 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            android.database.Cursor r10 = com.igexin.c.a.d.g$$ExternalSyntheticApiModelOutline0.m(r10, r3, r1, r2, r1)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            goto L49
        L38:
            java.lang.String r8 = "_id DESC limit 1 offset 0"
            android.content.Context r10 = r10.getApplicationContext()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            android.net.Uri r4 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            r5 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
        L49:
            r1 = r10
            if (r1 == 0) goto L79
            int r10 = r1.getCount()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            if (r10 <= 0) goto L79
            boolean r10 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            if (r10 == 0) goto L79
            java.lang.String r10 = "_id"
            int r10 = r1.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            int r10 = r1.getInt(r10)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            java.lang.String r2 = "date_added"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            long r2 = r1.getLong(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            int r2 = com.up366.medialibrary.common.utils.DateUtils.dateDiffer(r2)     // Catch: java.lang.Throwable -> L7f java.lang.Exception -> L81
            if (r2 > r9) goto L73
            r0 = r10
        L73:
            if (r1 == 0) goto L78
            r1.close()
        L78:
            return r0
        L79:
            if (r1 == 0) goto L7e
            r1.close()
        L7e:
            return r0
        L7f:
            r10 = move-exception
            goto L8b
        L81:
            r10 = move-exception
            r10.printStackTrace()     // Catch: java.lang.Throwable -> L7f
            if (r1 == 0) goto L8a
            r1.close()
        L8a:
            return r0
        L8b:
            if (r1 == 0) goto L90
            r1.close()
        L90:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.medialibrary.common.utils.MediaUtils.getDCIMLastImageId(android.content.Context):int");
    }

    public static long getCameraFirstBucketId(android.content.Context context) {
        android.database.Cursor cursorQuery;
        android.database.Cursor cursor = null;
        try {
            try {
                java.lang.String[] strArr = {com.up366.medialibrary.common.utils.PictureFileUtils.getDCIMCameraPath() + "%"};
                if (!com.up366.medialibrary.common.utils.SdkVersionUtils.isR()) {
                    cursorQuery = context.getApplicationContext().getContentResolver().query(android.provider.MediaStore.Files.getContentUri("external"), null, "_data like ?", strArr, "_id DESC limit 1 offset 0");
                } else {
                    cursorQuery = context.getApplicationContext().getContentResolver().query(android.provider.MediaStore.Files.getContentUri("external"), null, createQueryArgsBundle("_data like ?", strArr, 1, 0), null);
                }
                cursor = cursorQuery;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (cursor == null) {
                    return -1L;
                }
            }
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                long j = cursor.getLong(cursor.getColumnIndex(com.up366.medialibrary.config.PictureConstants.EXTRA_BUCKET_ID));
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            if (cursor == null) {
                return -1L;
            }
            cursor.close();
            return -1L;
        } catch (java.lang.Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static android.os.Bundle createQueryArgsBundle(java.lang.String str, java.lang.String[] strArr, int i, int i2) {
        android.os.Bundle bundle = new android.os.Bundle();
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            bundle.putString("android:query-arg-sql-selection", str);
            bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
            bundle.putString("android:query-arg-sql-sort-order", "_id DESC");
            if (android.os.Build.VERSION.SDK_INT >= 30) {
                bundle.putString("android:query-arg-sql-limit", i + " offset " + i2);
            }
        }
        return bundle;
    }

    public static void deleteCamera(android.content.Context context, java.lang.String str) {
        try {
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str)) {
                context.getContentResolver().delete(android.net.Uri.parse(str), null, null);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUri(android.content.Context context, android.net.Uri uri) {
        if (uri != null) {
            try {
                context.getContentResolver().delete(uri, null, null);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static java.lang.String getMIMEType(java.io.File file) {
        java.lang.String name = file.getName();
        return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(name.lastIndexOf(".") + 1, name.length()).toLowerCase());
    }

    public static java.lang.String getMIMEType(java.lang.String str) {
        return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(str.lastIndexOf(".") + 1, str.length()).toLowerCase());
    }
}
