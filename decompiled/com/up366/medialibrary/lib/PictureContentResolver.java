package com.up366.medialibrary.lib;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class PictureContentResolver {
    public static java.io.InputStream getContentResolverOpenInputStream(android.content.Context context, android.net.Uri uri) {
        return com.up366.medialibrary.common.io.ArrayPoolProvide.getInstance().openInputStream(context.getContentResolver(), uri);
    }

    public static java.io.OutputStream getContentResolverOpenOutputStream(android.content.Context context, android.net.Uri uri) {
        try {
            return context.getContentResolver().openOutputStream(uri);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
