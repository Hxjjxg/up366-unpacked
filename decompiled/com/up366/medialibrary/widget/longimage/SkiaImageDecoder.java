package com.up366.medialibrary.widget.longimage;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SkiaImageDecoder implements com.up366.medialibrary.widget.longimage.ImageDecoder {
    private static final java.lang.String ASSET_PREFIX = "file:///android_asset/";
    private static final java.lang.String FILE_PREFIX = "file://";
    private static final java.lang.String RESOURCE_PREFIX = "android.resource://";
    private final android.graphics.Bitmap.Config bitmapConfig;

    public SkiaImageDecoder() {
        this(null);
    }

    public SkiaImageDecoder(android.graphics.Bitmap.Config config) {
        android.graphics.Bitmap.Config preferredBitmapConfig = com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config != null) {
            this.bitmapConfig = config;
        } else if (preferredBitmapConfig != null) {
            this.bitmapConfig = preferredBitmapConfig;
        } else {
            this.bitmapConfig = android.graphics.Bitmap.Config.RGB_565;
        }
    }

    @Override // com.up366.medialibrary.widget.longimage.ImageDecoder
    public android.graphics.Bitmap decode(android.content.Context context, android.net.Uri uri) throws java.lang.Exception {
        android.graphics.Bitmap bitmapDecodeFile;
        android.content.res.Resources resourcesForApplication;
        java.lang.String string = uri.toString();
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inPreferredConfig = this.bitmapConfig;
        if (string.startsWith(RESOURCE_PREFIX)) {
            java.lang.String authority = uri.getAuthority();
            if (context.getPackageName().equals(authority)) {
                resourcesForApplication = context.getResources();
            } else {
                resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
            }
            java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            int identifier = 0;
            if (size == 2 && pathSegments.get(0).equals("drawable")) {
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), "drawable", authority);
            } else if (size == 1 && android.text.TextUtils.isDigitsOnly(pathSegments.get(0))) {
                try {
                    identifier = java.lang.Integer.parseInt(pathSegments.get(0));
                } catch (java.lang.NumberFormatException unused) {
                }
            }
            bitmapDecodeFile = android.graphics.BitmapFactory.decodeResource(context.getResources(), identifier, options);
        } else {
            java.io.InputStream inputStream = null;
            if (string.startsWith(ASSET_PREFIX)) {
                bitmapDecodeFile = android.graphics.BitmapFactory.decodeStream(context.getAssets().open(string.substring(22)), null, options);
            } else if (string.startsWith(FILE_PREFIX)) {
                bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(string.substring(7), options);
            } else {
                try {
                    java.io.InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                    try {
                        android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                        if (inputStreamOpenInputStream != null) {
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (java.lang.Exception unused2) {
                            }
                        }
                        bitmapDecodeFile = bitmapDecodeStream;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        inputStream = inputStreamOpenInputStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.lang.Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
        }
        if (bitmapDecodeFile != null) {
            return bitmapDecodeFile;
        }
        throw new java.lang.RuntimeException("Skia image region decoder returned null bitmap - image format may not be supported");
    }
}
