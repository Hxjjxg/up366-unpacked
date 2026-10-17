package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AttrsUtils {
    public static float getTypeValueSize(android.content.Context context, int i) {
        float dimensionPixelSize = 0.0f;
        try {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new android.util.TypedValue().resourceId, new int[]{i});
            dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            return dimensionPixelSize;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return dimensionPixelSize;
        }
    }

    public static int getTypeValueSizeForInt(android.content.Context context, int i) {
        int dimensionPixelSize = 0;
        try {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new android.util.TypedValue().resourceId, new int[]{i});
            dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            return dimensionPixelSize;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return dimensionPixelSize;
        }
    }

    public static int getTypeValueColor(android.content.Context context, int i) {
        int color = 0;
        try {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new android.util.TypedValue().resourceId, new int[]{i});
            color = typedArrayObtainStyledAttributes.getColor(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            return color;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return color;
        }
    }

    public static android.content.res.ColorStateList getTypeValueColorStateList(android.content.Context context, int i) {
        android.content.res.ColorStateList colorStateList = null;
        try {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new android.util.TypedValue().resourceId, new int[]{i});
            colorStateList = typedArrayObtainStyledAttributes.getColorStateList(0);
            typedArrayObtainStyledAttributes.recycle();
            return colorStateList;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return colorStateList;
        }
    }

    public static boolean getTypeValueBoolean(android.content.Context context, int i) {
        boolean z = false;
        try {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new android.util.TypedValue().resourceId, new int[]{i});
            z = typedArrayObtainStyledAttributes.getBoolean(0, false);
            typedArrayObtainStyledAttributes.recycle();
            return z;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public static android.graphics.drawable.Drawable getTypeValueDrawable(android.content.Context context, int i, int i2) {
        android.graphics.drawable.Drawable drawable = null;
        try {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new android.util.TypedValue().resourceId, new int[]{i});
            drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return drawable == null ? androidx.core.content.ContextCompat.getDrawable(context, i2) : drawable;
    }

    public static android.content.res.ColorStateList getColorStateList(int[] iArr) {
        try {
            if (iArr.length == 2) {
                return new android.content.res.ColorStateList(new int[][]{new int[]{-16842913}, new int[]{android.R.attr.state_selected}}, iArr);
            }
            return android.content.res.ColorStateList.valueOf(iArr[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
