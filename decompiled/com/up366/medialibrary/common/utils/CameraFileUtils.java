package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CameraFileUtils {
    public static android.net.Uri createCameraOutImageUri(android.content.Context context, com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig) {
        java.lang.String strRename;
        pictureSelectionConfig.cameraMimeType = com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage();
        if (android.text.TextUtils.isEmpty(pictureSelectionConfig.cameraFileName)) {
            strRename = "";
        } else {
            pictureSelectionConfig.cameraFileName = !com.up366.medialibrary.common.utils.MimeTypeUtils.isSuffixOfImage(pictureSelectionConfig.cameraFileName) ? com.up366.medialibrary.common.utils.StringUtils.renameSuffix(pictureSelectionConfig.cameraFileName, com.up366.medialibrary.common.utils.MimeTypeUtils.JPG) : pictureSelectionConfig.cameraFileName;
            strRename = pictureSelectionConfig.camera ? pictureSelectionConfig.cameraFileName : com.up366.medialibrary.common.utils.StringUtils.rename(pictureSelectionConfig.cameraFileName);
        }
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() && android.text.TextUtils.isEmpty(pictureSelectionConfig.outPutCameraPath)) {
            android.net.Uri uriCreateImageUri = createImageUri(context, strRename, pictureSelectionConfig.cameraImageFormatForQ);
            pictureSelectionConfig.cameraPath = uriCreateImageUri != null ? uriCreateImageUri.toString() : null;
            return uriCreateImageUri;
        }
        java.io.File fileCreateCameraFile = com.up366.medialibrary.common.utils.PictureFileUtils.createCameraFile(context, 1, strRename, pictureSelectionConfig.cameraImageFormat, pictureSelectionConfig.outPutCameraPath);
        pictureSelectionConfig.cameraPath = fileCreateCameraFile.getAbsolutePath();
        return com.up366.medialibrary.common.utils.PictureFileUtils.parUri(context, fileCreateCameraFile);
    }

    public static android.net.Uri createCameraOutVideoUri(android.content.Context context, com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig) {
        java.lang.String strRename;
        pictureSelectionConfig.cameraMimeType = com.up366.medialibrary.common.utils.MimeTypeUtils.ofVideo();
        if (android.text.TextUtils.isEmpty(pictureSelectionConfig.cameraFileName)) {
            strRename = "";
        } else {
            pictureSelectionConfig.cameraFileName = com.up366.medialibrary.common.utils.MimeTypeUtils.isSuffixOfImage(pictureSelectionConfig.cameraFileName) ? com.up366.medialibrary.common.utils.StringUtils.renameSuffix(pictureSelectionConfig.cameraFileName, ".mp4") : pictureSelectionConfig.cameraFileName;
            strRename = pictureSelectionConfig.camera ? pictureSelectionConfig.cameraFileName : com.up366.medialibrary.common.utils.StringUtils.rename(pictureSelectionConfig.cameraFileName);
        }
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() && android.text.TextUtils.isEmpty(pictureSelectionConfig.outPutCameraPath)) {
            android.net.Uri uriCreateVideoUri = createVideoUri(context, strRename, pictureSelectionConfig.cameraVideoFormatForQ);
            pictureSelectionConfig.cameraPath = uriCreateVideoUri != null ? uriCreateVideoUri.toString() : "";
            return uriCreateVideoUri;
        }
        java.io.File fileCreateCameraFile = com.up366.medialibrary.common.utils.PictureFileUtils.createCameraFile(context, 2, strRename, pictureSelectionConfig.cameraVideoFormat, pictureSelectionConfig.outPutCameraPath);
        pictureSelectionConfig.cameraPath = fileCreateCameraFile.getAbsolutePath();
        return com.up366.medialibrary.common.utils.PictureFileUtils.parUri(context, fileCreateCameraFile);
    }

    public static android.net.Uri createCameraOutAudioUri(android.content.Context context, com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig) {
        pictureSelectionConfig.cameraMimeType = com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio();
        if (!com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            return null;
        }
        android.net.Uri uriCreateAudioUri = createAudioUri(context, pictureSelectionConfig.cameraAudioFormatForQ);
        pictureSelectionConfig.cameraPath = uriCreateAudioUri != null ? uriCreateAudioUri.toString() : null;
        return uriCreateAudioUri;
    }

    public static android.net.Uri createImageUri(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.Context applicationContext = context.getApplicationContext();
        android.net.Uri[] uriArr = {null};
        java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
        android.content.ContentValues contentValuesBuildImageContentValues = buildImageContentValues(str, str2);
        if (externalStorageState.equals("mounted")) {
            uriArr[0] = applicationContext.getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValuesBuildImageContentValues);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI, contentValuesBuildImageContentValues);
        }
        return uriArr[0];
    }

    public static android.content.ContentValues buildImageContentValues(java.lang.String str, java.lang.String str2) {
        java.lang.String string = com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        android.content.ContentValues contentValues = new android.content.ContentValues(3);
        if (android.text.TextUtils.isEmpty(str) || str.lastIndexOf(".") == -1) {
            contentValues.put("_display_name", com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("IMG_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(".")), ""));
        }
        if (android.text.TextUtils.isEmpty(str2) || str2.startsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_VIDEO)) {
            str2 = "image/jpeg";
        }
        contentValues.put("mime_type", str2);
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            contentValues.put("datetaken", string);
            contentValues.put("relative_path", com.up366.medialibrary.common.utils.MimeTypeUtils.DCIM);
        }
        return contentValues;
    }

    public static android.net.Uri createVideoUri(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.Context applicationContext = context.getApplicationContext();
        android.net.Uri[] uriArr = {null};
        java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
        android.content.ContentValues contentValuesBuildVideoContentValues = buildVideoContentValues(str, str2);
        if (externalStorageState.equals("mounted")) {
            uriArr[0] = applicationContext.getContentResolver().insert(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValuesBuildVideoContentValues);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(android.provider.MediaStore.Video.Media.INTERNAL_CONTENT_URI, contentValuesBuildVideoContentValues);
        }
        return uriArr[0];
    }

    public static android.content.ContentValues buildVideoContentValues(java.lang.String str, java.lang.String str2) {
        java.lang.String string = com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        android.content.ContentValues contentValues = new android.content.ContentValues(3);
        if (android.text.TextUtils.isEmpty(str) || str.lastIndexOf(".") == -1) {
            contentValues.put("_display_name", com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("VID_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(".")), ""));
        }
        if (android.text.TextUtils.isEmpty(str2) || str2.startsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE)) {
            str2 = "video/mp4";
        }
        contentValues.put("mime_type", str2);
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            contentValues.put("datetaken", string);
            contentValues.put("relative_path", android.os.Environment.DIRECTORY_MOVIES);
        }
        return contentValues;
    }

    public static android.net.Uri createAudioUri(android.content.Context context, java.lang.String str) {
        android.content.Context applicationContext = context.getApplicationContext();
        android.net.Uri[] uriArr = {null};
        java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
        java.lang.String string = com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        android.content.ContentValues contentValues = new android.content.ContentValues(3);
        contentValues.put("_display_name", com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("AUD_"));
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            contentValues.put("datetaken", string);
        }
        if (android.text.TextUtils.isEmpty(str) || str.startsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE) || str.startsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_VIDEO)) {
            str = "audio/amr";
        }
        contentValues.put("mime_type", str);
        if (externalStorageState.equals("mounted")) {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                contentValues.put("relative_path", android.os.Environment.DIRECTORY_MUSIC);
            }
            uriArr[0] = applicationContext.getContentResolver().insert(android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, contentValues);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(android.provider.MediaStore.Audio.Media.INTERNAL_CONTENT_URI, contentValues);
        }
        return uriArr[0];
    }
}
