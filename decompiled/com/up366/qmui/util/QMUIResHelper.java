package com.up366.qmui.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIResHelper {
    private static android.util.TypedValue sTmpValue;

    public static float getAttrFloatValue(android.content.Context context, int i) {
        return getAttrFloatValue(context.getTheme(), i);
    }

    public static float getAttrFloatValue(android.content.res.Resources.Theme theme, int i) {
        if (sTmpValue == null) {
            sTmpValue = new android.util.TypedValue();
        }
        if (theme.resolveAttribute(i, sTmpValue, true)) {
            return sTmpValue.getFloat();
        }
        return 0.0f;
    }

    public static int getAttrColor(android.content.Context context, int i) {
        return getAttrColor(context.getTheme(), i);
    }

    public static int getAttrColor(android.content.res.Resources.Theme theme, int i) {
        if (sTmpValue == null) {
            sTmpValue = new android.util.TypedValue();
        }
        if (!theme.resolveAttribute(i, sTmpValue, true)) {
            return 0;
        }
        if (sTmpValue.type == 2) {
            return getAttrColor(theme, sTmpValue.data);
        }
        return sTmpValue.data;
    }

    public static android.content.res.ColorStateList getAttrColorStateList(android.content.Context context, int i) {
        return getAttrColorStateList(context, context.getTheme(), i);
    }

    public static android.content.res.ColorStateList getAttrColorStateList(android.content.Context context, android.content.res.Resources.Theme theme, int i) {
        if (i == 0) {
            return null;
        }
        if (sTmpValue == null) {
            sTmpValue = new android.util.TypedValue();
        }
        if (!theme.resolveAttribute(i, sTmpValue, true)) {
            return null;
        }
        if (sTmpValue.type >= 28 && sTmpValue.type <= 31) {
            return android.content.res.ColorStateList.valueOf(sTmpValue.data);
        }
        if (sTmpValue.type == 2) {
            return getAttrColorStateList(context, theme, sTmpValue.data);
        }
        if (sTmpValue.resourceId == 0) {
            return null;
        }
        return androidx.core.content.ContextCompat.getColorStateList(context, sTmpValue.resourceId);
    }

    public static android.graphics.drawable.Drawable getAttrDrawable(android.content.Context context, int i) {
        return getAttrDrawable(context, context.getTheme(), i);
    }

    public static android.graphics.drawable.Drawable getAttrDrawable(android.content.Context context, android.content.res.Resources.Theme theme, int i) {
        if (i == 0) {
            return null;
        }
        if (sTmpValue == null) {
            sTmpValue = new android.util.TypedValue();
        }
        if (!theme.resolveAttribute(i, sTmpValue, true)) {
            return null;
        }
        if (sTmpValue.type >= 28 && sTmpValue.type <= 31) {
            return new android.graphics.drawable.ColorDrawable(sTmpValue.data);
        }
        if (sTmpValue.type == 2) {
            return getAttrDrawable(context, theme, sTmpValue.data);
        }
        if (sTmpValue.resourceId != 0) {
            return com.up366.qmui.util.QMUIDrawableHelper.getVectorDrawable(context, sTmpValue.resourceId);
        }
        return null;
    }

    public static android.graphics.drawable.Drawable getAttrDrawable(android.content.Context context, android.content.res.TypedArray typedArray, int i) {
        android.util.TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue == null || typedValuePeekValue.type == 2 || typedValuePeekValue.resourceId == 0) {
            return null;
        }
        return com.up366.qmui.util.QMUIDrawableHelper.getVectorDrawable(context, typedValuePeekValue.resourceId);
    }

    public static int getAttrDimen(android.content.Context context, int i) {
        if (sTmpValue == null) {
            sTmpValue = new android.util.TypedValue();
        }
        if (context.getTheme().resolveAttribute(i, sTmpValue, true)) {
            return android.util.TypedValue.complexToDimensionPixelSize(sTmpValue.data, com.up366.qmui.util.QMUIDisplayHelper.getDisplayMetrics(context));
        }
        return 0;
    }

    public static java.lang.String getAttrString(android.content.Context context, int i) {
        java.lang.CharSequence charSequence;
        if (sTmpValue == null) {
            sTmpValue = new android.util.TypedValue();
        }
        if (context.getTheme().resolveAttribute(i, sTmpValue, true) && (charSequence = sTmpValue.string) != null) {
            return charSequence.toString();
        }
        return null;
    }

    public static int getAttrInt(android.content.Context context, int i) {
        if (sTmpValue == null) {
            sTmpValue = new android.util.TypedValue();
        }
        context.getTheme().resolveAttribute(i, sTmpValue, true);
        return sTmpValue.data;
    }

    public static void assignTextViewWithAttr(android.widget.TextView textView, int i) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = textView.getContext().obtainStyledAttributes(null, com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef, i, 0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        int paddingLeft = textView.getPaddingLeft();
        int paddingRight = textView.getPaddingRight();
        int paddingTop = textView.getPaddingTop();
        int paddingBottom = textView.getPaddingBottom();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_gravity) {
                textView.setGravity(typedArrayObtainStyledAttributes.getInt(index, -1));
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_textColor) {
                textView.setTextColor(typedArrayObtainStyledAttributes.getColorStateList(index));
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_textSize) {
                textView.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_paddingLeft) {
                paddingLeft = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_paddingRight) {
                paddingRight = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_paddingTop) {
                paddingTop = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_paddingBottom) {
                paddingBottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_singleLine) {
                textView.setSingleLine(typedArrayObtainStyledAttributes.getBoolean(index, false));
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_ellipsize) {
                int i3 = typedArrayObtainStyledAttributes.getInt(index, 3);
                if (i3 == 1) {
                    textView.setEllipsize(android.text.TextUtils.TruncateAt.START);
                } else if (i3 == 2) {
                    textView.setEllipsize(android.text.TextUtils.TruncateAt.MIDDLE);
                } else if (i3 == 3) {
                    textView.setEllipsize(android.text.TextUtils.TruncateAt.END);
                } else if (i3 == 4) {
                    textView.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
                }
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_maxLines) {
                textView.setMaxLines(typedArrayObtainStyledAttributes.getInt(index, -1));
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_background) {
                com.up366.qmui.util.QMUIViewHelper.setBackgroundKeepingPadding(textView, typedArrayObtainStyledAttributes.getDrawable(index));
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_lineSpacingExtra) {
                textView.setLineSpacing(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0), 1.0f);
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_drawablePadding) {
                textView.setCompoundDrawablePadding(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_textColorHint) {
                textView.setHintTextColor(typedArrayObtainStyledAttributes.getColor(index, 0));
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUITextCommonStyleDef_android_textStyle) {
                textView.setTypeface(null, typedArrayObtainStyledAttributes.getInt(index, -1));
            }
        }
        textView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        typedArrayObtainStyledAttributes.recycle();
    }
}
