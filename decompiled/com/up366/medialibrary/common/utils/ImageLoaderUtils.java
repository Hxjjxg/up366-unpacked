package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ImageLoaderUtils {
    public static boolean assertValidRequest(android.content.Context context) {
        if (context instanceof android.app.Activity) {
            return !isDestroy((android.app.Activity) context);
        }
        if (context instanceof android.content.ContextWrapper) {
            if (((android.content.ContextWrapper) context).getBaseContext() instanceof android.app.Activity) {
                return !isDestroy((android.app.Activity) r2.getBaseContext());
            }
        }
        return true;
    }

    private static boolean isDestroy(android.app.Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }
}
