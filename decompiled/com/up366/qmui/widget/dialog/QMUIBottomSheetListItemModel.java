package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIBottomSheetListItemModel {
    java.lang.String tag;
    java.lang.CharSequence text;
    android.graphics.Typeface typeface;
    android.graphics.drawable.Drawable image = null;
    int imageRes = 0;
    int imageSkinTintColorAttr = 0;
    int imageSkinSrcAttr = 0;
    int textSkinColorAttr = 0;
    boolean hasRedPoint = false;
    boolean isDisabled = false;

    public QMUIBottomSheetListItemModel(java.lang.CharSequence charSequence, java.lang.String str) {
        this.text = charSequence;
        this.tag = str;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel image(android.graphics.drawable.Drawable drawable) {
        this.image = drawable;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel image(int i) {
        this.imageRes = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel skinTextColorAttr(int i) {
        this.textSkinColorAttr = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel skinImageTintColorAttr(int i) {
        this.imageSkinTintColorAttr = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel skinImageSrcAttr(int i) {
        this.imageSkinSrcAttr = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel redPoint(boolean z) {
        this.hasRedPoint = z;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel disabled(boolean z) {
        this.isDisabled = z;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel typeface(android.graphics.Typeface typeface) {
        this.typeface = typeface;
        return this;
    }
}
