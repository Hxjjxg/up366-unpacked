package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GrayBitmapUtils {
    public static android.graphics.Bitmap getGrayBitmap(android.graphics.Bitmap bitmap) {
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        android.graphics.Paint paint = new android.graphics.Paint();
        android.graphics.ColorMatrix colorMatrix = new android.graphics.ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new android.graphics.ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    public static void showGrayImage(final android.widget.ImageView imageView, java.lang.String str) {
        com.bumptech.glide.Glide.with(imageView).asBitmap().load(str).listener(new com.bumptech.glide.request.RequestListener<android.graphics.Bitmap>() { // from class: com.up366.mobile.common.utils.GrayBitmapUtils.2
            public boolean onResourceReady(android.graphics.Bitmap bitmap, java.lang.Object obj, com.bumptech.glide.request.target.Target<android.graphics.Bitmap> target, com.bumptech.glide.load.DataSource dataSource, boolean z) {
                return false;
            }

            public /* bridge */ /* synthetic */ boolean onResourceReady(java.lang.Object obj, java.lang.Object obj2, com.bumptech.glide.request.target.Target target, com.bumptech.glide.load.DataSource dataSource, boolean z) {
                return onResourceReady((android.graphics.Bitmap) obj, obj2, (com.bumptech.glide.request.target.Target<android.graphics.Bitmap>) target, dataSource, z);
            }

            public boolean onLoadFailed(com.bumptech.glide.load.engine.GlideException glideException, java.lang.Object obj, com.bumptech.glide.request.target.Target<android.graphics.Bitmap> target, boolean z) {
                android.widget.ImageView imageView2 = imageView;
                imageView2.setImageBitmap(com.up366.mobile.common.utils.GrayBitmapUtils.getGrayBitmap(android.graphics.BitmapFactory.decodeResource(imageView2.getResources(), com.up366.mobile.R.drawable.default_book_picture)));
                return false;
            }
        }).into(new com.bumptech.glide.request.target.SimpleTarget<android.graphics.Bitmap>() { // from class: com.up366.mobile.common.utils.GrayBitmapUtils.1
            public /* bridge */ /* synthetic */ void onResourceReady(java.lang.Object obj, com.bumptech.glide.request.transition.Transition transition) {
                onResourceReady((android.graphics.Bitmap) obj, (com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap>) transition);
            }

            public void onResourceReady(android.graphics.Bitmap bitmap, com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap> transition) {
                imageView.setImageBitmap(com.up366.mobile.common.utils.GrayBitmapUtils.getGrayBitmap(bitmap));
            }
        });
    }
}
