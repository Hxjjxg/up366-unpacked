package com.up366.qmui.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIDrawableHelper {
    private static final java.lang.String TAG = "QMUIDrawableHelper";
    private static final android.graphics.Canvas sCanvas = new android.graphics.Canvas();

    public static android.graphics.Bitmap createBitmapFromView(android.view.View view, float f) {
        android.graphics.drawable.Drawable drawable;
        if ((view instanceof android.widget.ImageView) && (drawable = ((android.widget.ImageView) view).getDrawable()) != null && (drawable instanceof android.graphics.drawable.BitmapDrawable)) {
            return ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap();
        }
        view.clearFocus();
        android.graphics.Bitmap bitmapCreateBitmapSafely = createBitmapSafely((int) (view.getWidth() * f), (int) (view.getHeight() * f), android.graphics.Bitmap.Config.ARGB_8888, 1);
        if (bitmapCreateBitmapSafely != null) {
            android.graphics.Canvas canvas = sCanvas;
            synchronized (canvas) {
                canvas.setBitmap(bitmapCreateBitmapSafely);
                canvas.save();
                canvas.drawColor(-1);
                canvas.scale(f, f);
                view.draw(canvas);
                canvas.restore();
                canvas.setBitmap(null);
            }
        }
        return bitmapCreateBitmapSafely;
    }

    public static android.graphics.Bitmap createBitmapFromView(android.view.View view) {
        return createBitmapFromView(view, 1.0f);
    }

    public static android.graphics.Bitmap createBitmapFromView(android.view.View view, int i, int i2, int i3, int i4) {
        android.graphics.Bitmap bitmapCreateBitmapSafely;
        android.graphics.Bitmap bitmapCreateBitmapFromView = createBitmapFromView(view);
        if (bitmapCreateBitmapFromView == null || (bitmapCreateBitmapSafely = createBitmapSafely((view.getWidth() - i3) - i, (view.getHeight() - i2) - i4, android.graphics.Bitmap.Config.ARGB_8888, 1)) == null) {
            return null;
        }
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmapSafely);
        android.graphics.Rect rect = new android.graphics.Rect(i, i2, view.getWidth() - i3, view.getHeight() - i4);
        android.graphics.Rect rect2 = new android.graphics.Rect(0, 0, (view.getWidth() - i3) - i, (view.getHeight() - i2) - i4);
        canvas.drawColor(-1);
        canvas.drawBitmap(bitmapCreateBitmapFromView, rect, rect2, (android.graphics.Paint) null);
        bitmapCreateBitmapFromView.recycle();
        return bitmapCreateBitmapSafely;
    }

    public static android.graphics.Bitmap createBitmapSafely(int i, int i2, android.graphics.Bitmap.Config config, int i3) {
        try {
            return android.graphics.Bitmap.createBitmap(i, i2, config);
        } catch (java.lang.OutOfMemoryError e) {
            e.printStackTrace();
            if (i3 <= 0) {
                return null;
            }
            java.lang.System.gc();
            return createBitmapSafely(i, i2, config, i3 - 1);
        }
    }

    public static android.graphics.drawable.BitmapDrawable createDrawableWithSize(android.content.res.Resources resources, int i, int i2, int i3, int i4) {
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        if (i4 == 0) {
            i4 = 0;
        }
        if (i3 > 0) {
            android.graphics.Paint paint = new android.graphics.Paint();
            paint.setAntiAlias(true);
            paint.setStyle(android.graphics.Paint.Style.FILL);
            paint.setColor(i4);
            android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, i, i2);
            float f = i3;
            canvas.drawRoundRect(rectF, f, f, paint);
        } else {
            canvas.drawColor(i4);
        }
        return new android.graphics.drawable.BitmapDrawable(resources, bitmapCreateBitmap);
    }

    @java.lang.Deprecated
    public static android.graphics.ColorFilter setDrawableTintColor(android.graphics.drawable.Drawable drawable, int i) {
        android.graphics.LightingColorFilter lightingColorFilter = new android.graphics.LightingColorFilter(android.graphics.Color.argb(255, 0, 0, 0), i);
        if (drawable != null) {
            drawable.setColorFilter(lightingColorFilter);
        }
        return lightingColorFilter;
    }

    public static android.graphics.Bitmap drawableToBitmap(android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
            return ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            try {
                android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? android.graphics.Bitmap.Config.ARGB_8888 : android.graphics.Bitmap.Config.RGB_565);
                android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return bitmapCreateBitmap;
            } catch (java.lang.OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static android.graphics.drawable.GradientDrawable createCircleGradientDrawable(int i, int i2, int i3, float f, float f2) {
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setColors(new int[]{i, i2});
        gradientDrawable.setGradientType(1);
        gradientDrawable.setGradientRadius(i3);
        gradientDrawable.setGradientCenter(f, f2);
        return gradientDrawable;
    }

    public static android.graphics.drawable.LayerDrawable createItemSeparatorBg(int i, int i2, int i3, boolean z) {
        android.graphics.drawable.ShapeDrawable shapeDrawable = new android.graphics.drawable.ShapeDrawable();
        shapeDrawable.getPaint().setStyle(android.graphics.Paint.Style.FILL);
        shapeDrawable.getPaint().setColor(i);
        android.graphics.drawable.ShapeDrawable shapeDrawable2 = new android.graphics.drawable.ShapeDrawable();
        shapeDrawable2.getPaint().setStyle(android.graphics.Paint.Style.FILL);
        shapeDrawable2.getPaint().setColor(i2);
        android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{shapeDrawable, shapeDrawable2});
        layerDrawable.setLayerInset(1, 0, z ? i3 : 0, 0, z ? 0 : i3);
        return layerDrawable;
    }

    public static android.graphics.drawable.Drawable getVectorDrawable(android.content.Context context, int i) {
        try {
            return androidx.appcompat.content.res.AppCompatResources.getDrawable(context, i);
        } catch (java.lang.Exception e) {
            com.up366.qmui.QMUILog.d(TAG, "Error in getVectorDrawable. resVector=" + i + ", resName=" + context.getResources().getResourceName(i) + e.getMessage(), new java.lang.Object[0]);
            return null;
        }
    }

    public static android.graphics.Bitmap vectorDrawableToBitmap(android.content.Context context, int i) {
        android.graphics.drawable.Drawable vectorDrawable = getVectorDrawable(context, i);
        if (vectorDrawable == null) {
            return null;
        }
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        vectorDrawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
