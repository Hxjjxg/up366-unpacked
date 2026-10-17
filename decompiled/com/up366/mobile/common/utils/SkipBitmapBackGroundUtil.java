package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SkipBitmapBackGroundUtil {
    public static void skip(android.app.Activity activity, com.up366.common.task.Task task) {
        try {
            android.view.View decorView = activity.getWindow().getDecorView();
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), android.graphics.Bitmap.Config.RGB_565);
            decorView.draw(new android.graphics.Canvas(bitmapCreateBitmap));
            com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("cache-bitmap", bitmapCreateBitmap, 2000L);
            task.run();
            activity.overridePendingTransition(0, 0);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("skip error :" + e.getMessage(), e);
        }
    }

    public static void loadBitmap(final android.view.View view, final int i) {
        final android.graphics.Bitmap bitmap = (android.graphics.Bitmap) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync("cache-bitmap");
        if (bitmap != null) {
            com.up366.common.task.TaskUtils.postMainTaskDelay(3500L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.SkipBitmapBackGroundUtil$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    com.up366.mobile.common.utils.SkipBitmapBackGroundUtil.lambda$loadBitmap$0(view, i, bitmap);
                }
            });
            view.setBackground(new android.graphics.drawable.ColorDrawable() { // from class: com.up366.mobile.common.utils.SkipBitmapBackGroundUtil.1
                android.graphics.Paint paint = new android.graphics.Paint();
                int[] loc = new int[2];

                @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
                public void draw(android.graphics.Canvas canvas) {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    view.getLocationInWindow(this.loc);
                    canvas.drawBitmap(bitmap, 0.0f, -this.loc[1], this.paint);
                }
            });
        }
    }

    static /* synthetic */ void lambda$loadBitmap$0(android.view.View view, int i, android.graphics.Bitmap bitmap) throws java.lang.Exception {
        hideBackground(view, i);
        bitmap.recycle();
    }

    public static void hideBackground(android.view.View view, int i) {
        view.setBackground(null);
        view.setVisibility(i);
    }

    public static boolean isSkipFromSplashActivity() {
        return com.up366.mobile.common.utils.ViewDataInvalidRecord.hasCache("splash");
    }
}
