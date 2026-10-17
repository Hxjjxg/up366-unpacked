package com.up366.mobile.common.utils;

/* JADX INFO: compiled from: ShapeDrawableUtils.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/up366/mobile/common/utils/ShapeDrawableUtils;", "", "<init>", "()V", "createShapeDrawable", "Landroid/graphics/drawable/ShapeDrawable;", "radius", "", "color", "colorString", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ShapeDrawableUtils {
    public static final com.up366.mobile.common.utils.ShapeDrawableUtils INSTANCE = new com.up366.mobile.common.utils.ShapeDrawableUtils();

    private ShapeDrawableUtils() {
    }

    @kotlin.jvm.JvmStatic
    public static final android.graphics.drawable.ShapeDrawable createShapeDrawable(int radius, int color) {
        android.graphics.drawable.ShapeDrawable shapeDrawable = new android.graphics.drawable.ShapeDrawable();
        float f = android.content.res.Resources.getSystem().getDisplayMetrics().density * radius;
        shapeDrawable.setShape(new android.graphics.drawable.shapes.RoundRectShape(new float[]{f, f, f, f, f, f, f, f}, null, null));
        shapeDrawable.getPaint().setColor(color);
        return shapeDrawable;
    }

    @kotlin.jvm.JvmStatic
    public static final android.graphics.drawable.ShapeDrawable createShapeDrawable(int radius, java.lang.String colorString) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(colorString, "colorString");
        return createShapeDrawable(radius, android.graphics.Color.parseColor(colorString));
    }
}
