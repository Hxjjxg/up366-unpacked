package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class JumpUtils {
    public static void startPictureVideoPlayActivity(android.content.Context context, android.os.Bundle bundle, int i) {
        if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick()) {
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setClass(context, com.up366.medialibrary.activity.PictureVideoPlayActivity.class);
        intent.putExtras(bundle);
        if (!(context instanceof android.app.Activity)) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        } else {
            ((android.app.Activity) context).startActivityForResult(intent, i);
        }
    }

    public static void startPicturePreviewActivity(android.content.Context context, boolean z, android.os.Bundle bundle, int i) {
        if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick()) {
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setClass(context, com.up366.medialibrary.activity.PicturePreviewActivity.class);
        intent.putExtras(bundle);
        if (!(context instanceof android.app.Activity)) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        } else {
            ((android.app.Activity) context).startActivityForResult(intent, i);
        }
    }
}
