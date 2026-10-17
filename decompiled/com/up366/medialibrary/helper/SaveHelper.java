package com.up366.medialibrary.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SaveHelper {
    protected SaveHelper() {
    }

    public void saveToAlum(com.up366.medialibrary.model.AttachmentInfo attachmentInfo) throws java.lang.Exception {
        if (attachmentInfo.isVideo()) {
            saveVideoToAlum(attachmentInfo);
        } else {
            if (attachmentInfo.isPicture()) {
                saveImageToAlum(attachmentInfo);
                return;
            }
            com.up366.common.log.Logger.error("saveToAlum error, not support " + attachmentInfo);
            throw new java.lang.RuntimeException("not support");
        }
    }

    private void saveImageToAlum(com.up366.medialibrary.model.AttachmentInfo attachmentInfo) throws java.lang.Exception {
        java.lang.String path = attachmentInfo.getPath();
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(attachmentInfo.getPath())) {
            java.io.File cacheFile2 = getCacheFile2(attachmentInfo.getPath());
            path = com.up366.common.FileUtilsUp.isFileExists(cacheFile2) ? cacheFile2.getAbsolutePath() : com.up366.medialibrary.common.utils.MediaPathUtil.getInst().getLocalImagePath(attachmentInfo.getPath());
        }
        com.up366.common.log.Logger.info("saveImageToAlum path  " + path);
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            savePictureAlbumAndroidQ(com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(path) ? android.net.Uri.parse(path) : android.net.Uri.fromFile(new java.io.File(path)));
        } else {
            savePictureAlbum(path);
        }
    }

    public java.io.File getCacheFile2(java.lang.String str) {
        try {
            com.bumptech.glide.disklrucache.DiskLruCache.Value value = com.bumptech.glide.disklrucache.DiskLruCache.open(new java.io.File(com.up366.common.global.GB.get().getApplicationContext().getCacheDir(), "image_manager_disk_cache"), 1, 1, 262144000).get(new com.bumptech.glide.load.engine.cache.SafeKeyGenerator().getSafeKey(new com.up366.medialibrary.common.DataCacheKey(new com.bumptech.glide.load.model.GlideUrl(str), com.bumptech.glide.signature.EmptySignature.obtain())));
            if (value != null) {
                return value.getFile(0);
            }
            return null;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getCacheFile2 error url " + str + ", " + e.getMessage());
            return null;
        }
    }

    private void saveVideoToAlum(com.up366.medialibrary.model.AttachmentInfo attachmentInfo) throws java.lang.Exception {
        java.lang.String path = attachmentInfo.getPath();
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(attachmentInfo.getPath())) {
            path = com.up366.medialibrary.common.utils.MediaPathUtil.getInst().getLocalVideoPath(attachmentInfo.getPath());
        }
        long duration = ((com.up366.medialibrary.model.VideoAttachmentInfo) attachmentInfo).getDuration();
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            saveVideoAlbumAndroidQ(com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(path) ? android.net.Uri.parse(path) : android.net.Uri.fromFile(new java.io.File(path)), duration);
        } else {
            saveVideoAlbum(path);
        }
    }

    private void saveVideoAlbum(java.lang.String str) throws java.lang.Throwable {
        java.io.File externalFilesDir;
        java.lang.String absolutePath;
        java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
        if (externalStorageState.equals("mounted")) {
            externalFilesDir = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DCIM);
        } else {
            externalFilesDir = com.up366.common.global.GB.get().getApplicationContext().getExternalFilesDir(android.os.Environment.DIRECTORY_PICTURES);
        }
        if (externalFilesDir != null && !externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() || !externalStorageState.equals("mounted")) {
            absolutePath = externalFilesDir.getAbsolutePath();
        } else {
            absolutePath = externalFilesDir.getAbsolutePath() + java.io.File.separator + com.up366.medialibrary.common.utils.MimeTypeUtils.CAMERA + java.io.File.separator;
        }
        java.io.File file = new java.io.File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        java.lang.String createFileName = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("MP4_");
        if (!createFileName.endsWith(".mp4")) {
            createFileName = createFileName + ".mp4";
        }
        java.io.File file2 = new java.io.File(file, createFileName);
        com.up366.common.log.Logger.info("saveVideoAlbumAndroidQ   " + str + "  :  " + file2.getAbsolutePath());
        com.up366.medialibrary.common.utils.PictureFileUtils.copyFile(str, file2.getAbsolutePath());
    }

    private void saveVideoAlbumAndroidQ(final android.net.Uri uri, long j) throws java.lang.Exception {
        java.lang.String createFileName = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("MP4_");
        if (!createFileName.endsWith(".mp4")) {
            createFileName = createFileName + ".mp4";
        }
        final android.content.Context applicationContext = com.up366.common.global.GB.get().getApplicationContext();
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_display_name", createFileName);
        contentValues.put("datetaken", com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Long.valueOf(java.lang.System.currentTimeMillis())));
        contentValues.put("mime_type", gdut.bsx.share2.ShareContentType.VIDEO);
        contentValues.put("relative_path", com.up366.medialibrary.common.utils.MimeTypeUtils.DCIM);
        contentValues.put("duration", java.lang.Long.valueOf(j));
        final android.net.Uri uriInsert = applicationContext.getContentResolver().insert(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert == null) {
            com.up366.common.log.Logger.error("saveVideoAlbumAndroidQ uri is null ");
            throw new java.lang.RuntimeException("uri is null");
        }
        com.up366.common.log.Logger.info("saveVideoAlbumAndroidQ   " + uri + "  : " + uriInsert);
        com.up366.medialibrary.common.utils.PictureThreadUtils.executeByIo(new com.up366.medialibrary.common.utils.PictureThreadUtils.SimpleTask<java.lang.String>() { // from class: com.up366.medialibrary.helper.SaveHelper.1
            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            public java.lang.String doInBackground() {
                try {
                    if (com.up366.medialibrary.common.utils.PictureFileUtils.writeFileFromIS(com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(applicationContext, uri), com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenOutputStream(applicationContext, uriInsert))) {
                        return com.up366.medialibrary.common.utils.PictureFileUtils.getPath(applicationContext, uriInsert);
                    }
                    return "";
                } catch (java.lang.Exception e) {
                    com.up366.common.log.Logger.error("saveVideoAlbumAndroidQ error  " + e.getMessage(), e);
                    return "";
                }
            }

            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            public void onSuccess(java.lang.String str) {
                com.up366.medialibrary.common.utils.PictureThreadUtils.cancel(com.up366.medialibrary.common.utils.PictureThreadUtils.getIoPool());
            }
        });
    }

    private void savePictureAlbum(java.lang.String str) throws java.lang.Exception {
        java.io.File externalFilesDir;
        java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
        if (externalStorageState.equals("mounted")) {
            externalFilesDir = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DCIM);
        } else {
            externalFilesDir = com.up366.common.global.GB.get().getApplicationContext().getExternalFilesDir(android.os.Environment.DIRECTORY_PICTURES);
        }
        if (externalFilesDir != null && !externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        java.io.File file = new java.io.File((com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() || !externalStorageState.equals("mounted")) ? externalFilesDir.getAbsolutePath() : byBrand(externalFilesDir));
        if (!file.exists()) {
            file.mkdirs();
        }
        java.lang.String str2 = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("IMG_") + com.up366.medialibrary.common.utils.MimeTypeUtils.JPG;
        java.io.File file2 = new java.io.File(file, str2);
        com.up366.common.log.Logger.info("savePictureAlbum   " + str + "    : " + file2.getAbsolutePath());
        com.up366.medialibrary.common.utils.PictureFileUtils.copyFileThrowException(str, file2.getAbsolutePath());
        android.provider.MediaStore.Images.Media.insertImage(com.up366.common.global.GB.get().getApplicationContext().getContentResolver(), file2.getAbsolutePath(), str2, (java.lang.String) null);
        com.up366.common.global.GB.get().getApplicationContext().sendBroadcast(new android.content.Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", android.net.Uri.parse("file://" + file2.getAbsolutePath())));
    }

    private java.lang.String byBrand(java.io.File file) {
        if (android.os.Build.BRAND.equals(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI) || android.os.Build.BRAND.equals("Huawei")) {
            return file.getAbsolutePath() + java.io.File.separator + com.up366.medialibrary.common.utils.MimeTypeUtils.CAMERA + java.io.File.separator;
        }
        return file.getAbsolutePath();
    }

    private void savePictureAlbumAndroidQ(final android.net.Uri uri) throws java.lang.Exception {
        java.lang.String str = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("IMG_") + com.up366.medialibrary.common.utils.MimeTypeUtils.JPG;
        final android.content.Context applicationContext = com.up366.common.global.GB.get().getApplicationContext();
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("datetaken", com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Long.valueOf(java.lang.System.currentTimeMillis())));
        contentValues.put("mime_type", "image/jpeg");
        contentValues.put("relative_path", com.up366.medialibrary.common.utils.MimeTypeUtils.DCIM);
        final android.net.Uri uriInsert = applicationContext.getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert == null) {
            com.up366.common.log.Logger.error("savePictureAlbumAndroidQ uri is null ");
            throw new java.lang.RuntimeException("uri is null");
        }
        com.up366.common.log.Logger.info("savePictureAlbumAndroidQ error  " + uri + "   : " + uriInsert);
        com.up366.medialibrary.common.utils.PictureThreadUtils.executeByIo(new com.up366.medialibrary.common.utils.PictureThreadUtils.SimpleTask<java.lang.String>() { // from class: com.up366.medialibrary.helper.SaveHelper.2
            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            public java.lang.String doInBackground() {
                try {
                    if (com.up366.medialibrary.common.utils.PictureFileUtils.writeFileFromIS(com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(applicationContext, uri), com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenOutputStream(applicationContext, uriInsert))) {
                        return com.up366.medialibrary.common.utils.PictureFileUtils.getPath(applicationContext, uriInsert);
                    }
                    return "";
                } catch (java.lang.Exception e) {
                    com.up366.common.log.Logger.error("savePictureAlbumAndroidQ error " + e.getMessage(), e);
                    return "";
                }
            }

            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            public void onSuccess(java.lang.String str2) {
                com.up366.medialibrary.common.utils.PictureThreadUtils.cancel(com.up366.medialibrary.common.utils.PictureThreadUtils.getIoPool());
            }
        });
    }
}
