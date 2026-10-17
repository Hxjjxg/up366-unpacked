package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BitmapUtils {
    public static void rotateImage(android.content.Context context, boolean z, java.lang.String str) throws java.lang.Throwable {
        if (z) {
            try {
                int pictureDegree = readPictureDegree(context, str);
                if (pictureDegree > 0) {
                    android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                    options.inSampleSize = 2;
                    java.io.File file = new java.io.File(str);
                    android.graphics.Bitmap bitmapRotatingImage = rotatingImage(android.graphics.BitmapFactory.decodeFile(file.getAbsolutePath(), options), pictureDegree);
                    if (bitmapRotatingImage != null) {
                        saveBitmapFile(bitmapRotatingImage, file);
                        bitmapRotatingImage.recycle();
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static android.graphics.Bitmap rotatingImage(android.graphics.Bitmap bitmap, int i) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postRotate(i);
        return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static void saveBitmapFile(android.graphics.Bitmap bitmap, java.io.File file) throws java.lang.Throwable {
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
            } catch (java.lang.Exception e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
            bufferedOutputStream.flush();
            com.up366.medialibrary.common.utils.PictureFileUtils.close(bufferedOutputStream);
        } catch (java.lang.Exception e2) {
            e = e2;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            com.up366.medialibrary.common.utils.PictureFileUtils.close(bufferedOutputStream2);
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            com.up366.medialibrary.common.utils.PictureFileUtils.close(bufferedOutputStream2);
            throw th;
        }
    }

    public static int readPictureDegree(android.content.Context context, java.lang.String str) {
        androidx.exifinterface.media.ExifInterface exifInterface;
        java.io.InputStream contentResolverOpenInputStream = null;
        try {
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(str)) {
                contentResolverOpenInputStream = com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(context, android.net.Uri.parse(str));
                exifInterface = new androidx.exifinterface.media.ExifInterface(contentResolverOpenInputStream);
            } else {
                exifInterface = new androidx.exifinterface.media.ExifInterface(str);
            }
            int attributeInt = exifInterface.getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                com.up366.medialibrary.common.utils.PictureFileUtils.close(contentResolverOpenInputStream);
                return 180;
            }
            if (attributeInt == 6) {
                com.up366.medialibrary.common.utils.PictureFileUtils.close(contentResolverOpenInputStream);
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            com.up366.medialibrary.common.utils.PictureFileUtils.close(contentResolverOpenInputStream);
            return 270;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            com.up366.medialibrary.common.utils.PictureFileUtils.close(contentResolverOpenInputStream);
        }
    }

    public static int readPictureDegree(java.io.InputStream inputStream) {
        try {
            int attributeInt = new androidx.exifinterface.media.ExifInterface(inputStream).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
