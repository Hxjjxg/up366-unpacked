package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class MimeTypeUtils {
    public static final java.lang.String AMR = ".amr";
    public static final java.lang.String AMR_Q = "audio/amr";
    public static final java.lang.String AVI = ".avi";
    public static final java.lang.String AVI_Q = "video/avi";
    public static final java.lang.String BMP = ".bmp";
    public static final java.lang.String CAMERA = "Camera";
    public static final java.lang.String DCIM = "DCIM/Camera";
    public static final java.lang.String GIF = ".gif";
    public static final java.lang.String JPEG = ".jpeg";
    public static final java.lang.String JPEG_Q = "image/jpeg";
    public static final java.lang.String JPG = ".jpg";
    private static final java.lang.String MIME_TYPE_3GP = "video/3gp";
    public static final java.lang.String MIME_TYPE_AUDIO = "audio/mpeg";
    public static final java.lang.String MIME_TYPE_AUDIO_AMR = "audio/amr";
    private static final java.lang.String MIME_TYPE_AVI = "video/avi";
    private static final java.lang.String MIME_TYPE_BMP = "image/bmp";
    private static final java.lang.String MIME_TYPE_GIF = "image/gif";
    public static final java.lang.String MIME_TYPE_IMAGE = "image/jpeg";
    public static final java.lang.String MIME_TYPE_JPEG = "image/jpeg";
    private static final java.lang.String MIME_TYPE_JPG = "image/jpg";
    private static final java.lang.String MIME_TYPE_MP4 = "video/mp4";
    private static final java.lang.String MIME_TYPE_MPEG = "video/mpeg";
    private static final java.lang.String MIME_TYPE_PNG = "image/png";
    public static final java.lang.String MIME_TYPE_PREFIX_AUDIO = "audio";
    public static final java.lang.String MIME_TYPE_PREFIX_IMAGE = "image";
    public static final java.lang.String MIME_TYPE_PREFIX_VIDEO = "video";
    public static final java.lang.String MIME_TYPE_VIDEO = "video/mp4";
    private static final java.lang.String MIME_TYPE_WEBP = "image/webp";
    public static final java.lang.String MP3 = ".mp3";
    public static final java.lang.String MP3_Q = "audio/mpeg";
    public static final java.lang.String MP4 = ".mp4";
    public static final java.lang.String MP4_Q = "video/mp4";
    public static final java.lang.String PNG = ".png";
    public static final java.lang.String PNG_Q = "image/png";
    public static final java.lang.String WAV = ".wav";
    public static final java.lang.String WAV_Q = "audio/x-wav";
    public static final java.lang.String WEBP = ".webp";

    public static int ofAll() {
        return 0;
    }

    @java.lang.Deprecated
    public static int ofAudio() {
        return 3;
    }

    public static int ofImage() {
        return 1;
    }

    public static int ofVideo() {
        return 2;
    }

    public static java.lang.String ofPNG() {
        return "image/png";
    }

    public static java.lang.String ofJPEG() {
        return "image/jpeg";
    }

    public static java.lang.String ofBMP() {
        return MIME_TYPE_BMP;
    }

    public static java.lang.String ofGIF() {
        return MIME_TYPE_GIF;
    }

    public static java.lang.String ofWEBP() {
        return MIME_TYPE_WEBP;
    }

    public static java.lang.String of3GP() {
        return MIME_TYPE_3GP;
    }

    public static java.lang.String ofMP4() {
        return "video/mp4";
    }

    public static java.lang.String ofMPEG() {
        return MIME_TYPE_MPEG;
    }

    public static java.lang.String ofAVI() {
        return "video/avi";
    }

    public static java.lang.String getRealPathUri(long j, java.lang.String str) {
        android.net.Uri contentUri;
        if (isImage(str)) {
            contentUri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (isVideo(str)) {
            contentUri = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else if (isHasAudio(str)) {
            contentUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        } else {
            contentUri = android.provider.MediaStore.Files.getContentUri("external");
        }
        return android.content.ContentUris.withAppendedId(contentUri, j).toString();
    }

    public static boolean isGif(java.lang.String str) {
        return str != null && (str.equals(MIME_TYPE_GIF) || str.equals("image/GIF"));
    }

    public static boolean isWebp(java.lang.String str) {
        return str != null && str.equalsIgnoreCase(MIME_TYPE_WEBP);
    }

    public static boolean isGifForSuffix(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return GIF.equalsIgnoreCase(str);
    }

    public static boolean isVideo(java.lang.String str) {
        return str != null && str.startsWith(MIME_TYPE_PREFIX_VIDEO);
    }

    public static boolean isUrlHasVideo(java.lang.String str) {
        return str.endsWith(".mp4");
    }

    public static boolean isHasAudio(java.lang.String str) {
        return str != null && str.startsWith(MIME_TYPE_PREFIX_AUDIO);
    }

    public static boolean isImage(java.lang.String str) {
        return str != null && str.startsWith(MIME_TYPE_PREFIX_IMAGE);
    }

    public static boolean isJPEG(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("image/jpeg") || str.startsWith("image/jpg");
    }

    public static boolean isJPG(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("image/jpg");
    }

    public static boolean isHttp(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http") || str.startsWith("https") || str.startsWith("/http") || str.startsWith("/https");
    }

    public static java.lang.String getMimeTypeFromMediaContentUri(android.content.Context context, android.net.Uri uri) {
        java.lang.String mimeTypeFromExtension;
        if (uri.getScheme().equals(com.igexin.sdk.FlymePushReceiver.CONTENT)) {
            mimeTypeFromExtension = context.getContentResolver().getType(uri);
        } else {
            mimeTypeFromExtension = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(android.webkit.MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
        }
        return android.text.TextUtils.isEmpty(mimeTypeFromExtension) ? "image/jpeg" : mimeTypeFromExtension;
    }

    public static boolean isSuffixOfImage(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return PNG.equalsIgnoreCase(str) || ".jpeg".equalsIgnoreCase(str) || JPG.equalsIgnoreCase(str) || WEBP.equalsIgnoreCase(str) || GIF.equalsIgnoreCase(str) || BMP.equalsIgnoreCase(str);
    }

    public static boolean isMimeTypeSame(java.lang.String str, java.lang.String str2) {
        return getMimeType(str) == getMimeType(str2);
    }

    public static java.lang.String getImageMimeType(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return "image/jpeg";
            }
            java.lang.String name = new java.io.File(str).getName();
            int iLastIndexOf = name.lastIndexOf(".");
            return "image/" + (iLastIndexOf == -1 ? "jpeg" : name.substring(iLastIndexOf + 1));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "image/jpeg";
        }
    }

    public static java.lang.String getImageMimeType(java.lang.String str, int i) {
        try {
            java.lang.String name = new java.io.File(str).getName();
            int iLastIndexOf = name.lastIndexOf(".");
            boolean z = iLastIndexOf != -1;
            if (i == 2) {
                if (!z) {
                    return "video/mp4";
                }
                return "video/" + name.substring(iLastIndexOf + 1);
            }
            if (i != 3) {
                if (!z) {
                    return "image/jpeg";
                }
                return "image/" + name.substring(iLastIndexOf + 1);
            }
            if (!z) {
                return "audio/amr";
            }
            return "audio/" + name.substring(iLastIndexOf + 1);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "image/jpeg";
        }
    }

    public static java.lang.String getLastImgType(java.lang.String str) {
        try {
            int iLastIndexOf = str.lastIndexOf(".");
            if (iLastIndexOf == -1) {
                return PNG;
            }
            return str.substring(iLastIndexOf);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return PNG;
        }
    }

    public static int getMimeType(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return 1;
        }
        if (str.startsWith(MIME_TYPE_PREFIX_VIDEO)) {
            return 2;
        }
        return str.startsWith(MIME_TYPE_PREFIX_AUDIO) ? 3 : 1;
    }

    public static java.lang.String getLastImgSuffix(java.lang.String str) {
        try {
            int iLastIndexOf = str.lastIndexOf("/") + 1;
            if (iLastIndexOf <= 0) {
                return PNG;
            }
            return "." + str.substring(iLastIndexOf);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return PNG;
        }
    }

    public static boolean isContent(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("content://");
    }

    public static java.lang.String s(android.content.Context context, java.lang.String str) {
        android.content.Context applicationContext = context.getApplicationContext();
        if (isVideo(str)) {
            return applicationContext.getString(com.up366.medialibrary.R.string.picture_video_error);
        }
        if (isHasAudio(str)) {
            return applicationContext.getString(com.up366.medialibrary.R.string.picture_audio_error);
        }
        return applicationContext.getString(com.up366.medialibrary.R.string.picture_error);
    }
}
