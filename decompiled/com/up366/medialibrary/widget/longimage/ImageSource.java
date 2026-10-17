package com.up366.medialibrary.widget.longimage;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class ImageSource {
    static final java.lang.String ASSET_SCHEME = "file:///android_asset/";
    static final java.lang.String FILE_SCHEME = "file:///";
    private final android.graphics.Bitmap bitmap;
    private boolean cached;
    private final java.lang.Integer resource;
    private int sHeight;
    private android.graphics.Rect sRegion;
    private int sWidth;
    private boolean tile;
    private final android.net.Uri uri;

    private ImageSource(android.graphics.Bitmap bitmap, boolean z) {
        this.bitmap = bitmap;
        this.uri = null;
        this.resource = null;
        this.tile = false;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.cached = z;
    }

    private ImageSource(android.net.Uri uri) {
        java.lang.String string = uri.toString();
        if (string.startsWith(FILE_SCHEME) && !new java.io.File(string.substring(7)).exists()) {
            try {
                uri = android.net.Uri.parse(java.net.URLDecoder.decode(string, "UTF-8"));
            } catch (java.io.UnsupportedEncodingException unused) {
            }
        }
        this.bitmap = null;
        this.uri = uri;
        this.resource = null;
        this.tile = true;
    }

    private ImageSource(int i) {
        this.bitmap = null;
        this.uri = null;
        this.resource = java.lang.Integer.valueOf(i);
        this.tile = true;
    }

    public static com.up366.medialibrary.widget.longimage.ImageSource resource(int i) {
        return new com.up366.medialibrary.widget.longimage.ImageSource(i);
    }

    public static com.up366.medialibrary.widget.longimage.ImageSource asset(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("Asset name must not be null");
        }
        return uri(ASSET_SCHEME + str);
    }

    public static com.up366.medialibrary.widget.longimage.ImageSource uri(java.lang.String str) {
        if (str == null) {
            throw new java.lang.NullPointerException("Uri must not be null");
        }
        if (!str.contains("://")) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            str = FILE_SCHEME + str;
        }
        return new com.up366.medialibrary.widget.longimage.ImageSource(android.net.Uri.parse(str));
    }

    public static com.up366.medialibrary.widget.longimage.ImageSource uri(android.net.Uri uri) {
        if (uri == null) {
            throw new java.lang.NullPointerException("Uri must not be null");
        }
        return new com.up366.medialibrary.widget.longimage.ImageSource(uri);
    }

    public static com.up366.medialibrary.widget.longimage.ImageSource bitmap(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            throw new java.lang.NullPointerException("Bitmap must not be null");
        }
        return new com.up366.medialibrary.widget.longimage.ImageSource(bitmap, false);
    }

    public static com.up366.medialibrary.widget.longimage.ImageSource cachedBitmap(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            throw new java.lang.NullPointerException("Bitmap must not be null");
        }
        return new com.up366.medialibrary.widget.longimage.ImageSource(bitmap, true);
    }

    public com.up366.medialibrary.widget.longimage.ImageSource tilingEnabled() {
        return tiling(true);
    }

    public com.up366.medialibrary.widget.longimage.ImageSource tilingDisabled() {
        return tiling(false);
    }

    public com.up366.medialibrary.widget.longimage.ImageSource tiling(boolean z) {
        this.tile = z;
        return this;
    }

    public com.up366.medialibrary.widget.longimage.ImageSource region(android.graphics.Rect rect) {
        this.sRegion = rect;
        setInvariants();
        return this;
    }

    public com.up366.medialibrary.widget.longimage.ImageSource dimensions(int i, int i2) {
        if (this.bitmap == null) {
            this.sWidth = i;
            this.sHeight = i2;
        }
        setInvariants();
        return this;
    }

    private void setInvariants() {
        android.graphics.Rect rect = this.sRegion;
        if (rect != null) {
            this.tile = true;
            this.sWidth = rect.width();
            this.sHeight = this.sRegion.height();
        }
    }

    protected final android.net.Uri getUri() {
        return this.uri;
    }

    protected final android.graphics.Bitmap getBitmap() {
        return this.bitmap;
    }

    protected final java.lang.Integer getResource() {
        return this.resource;
    }

    protected final boolean getTile() {
        return this.tile;
    }

    protected final int getSWidth() {
        return this.sWidth;
    }

    protected final int getSHeight() {
        return this.sHeight;
    }

    protected final android.graphics.Rect getSRegion() {
        return this.sRegion;
    }

    protected final boolean isCached() {
        return this.cached;
    }
}
