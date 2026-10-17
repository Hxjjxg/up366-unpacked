package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIBottomSheetGridItemModel {
    java.lang.Object tag;
    java.lang.CharSequence text;
    android.graphics.Typeface typeface;
    android.graphics.drawable.Drawable image = null;
    int imageRes = 0;
    int imageSkinTintColorAttr = 0;
    int imageSkinSrcAttr = 0;
    int textSkinColorAttr = 0;
    android.graphics.drawable.Drawable subscript = null;
    int subscriptRes = 0;
    int subscriptSkinTintColorAttr = 0;
    int subscriptSkinSrcAttr = 0;

    public QMUIBottomSheetGridItemModel(java.lang.CharSequence charSequence, java.lang.Object obj) {
        this.text = charSequence;
        this.tag = obj;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel image(android.graphics.drawable.Drawable drawable) {
        this.image = drawable;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel image(int i) {
        this.imageRes = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel subscript(android.graphics.drawable.Drawable drawable) {
        this.subscript = drawable;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel subscript(int i) {
        this.subscriptRes = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel skinTextColorAttr(int i) {
        this.textSkinColorAttr = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel skinImageTintColorAttr(int i) {
        this.imageSkinTintColorAttr = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel skinImageSrcAttr(int i) {
        this.imageSkinSrcAttr = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel skinSubscriptTintColorAttr(int i) {
        this.subscriptSkinTintColorAttr = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel skinSubscriptSrcAttr(int i) {
        this.subscriptSkinSrcAttr = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel typeface(android.graphics.Typeface typeface) {
        this.typeface = typeface;
        return this;
    }

    public java.lang.CharSequence getText() {
        return this.text;
    }

    public android.graphics.drawable.Drawable getImage() {
        return this.image;
    }

    public android.graphics.drawable.Drawable getSubscript() {
        return this.subscript;
    }

    public int getImageRes() {
        return this.imageRes;
    }

    public int getImageSkinSrcAttr() {
        return this.imageSkinSrcAttr;
    }

    public int getImageSkinTintColorAttr() {
        return this.imageSkinTintColorAttr;
    }

    public int getSubscriptRes() {
        return this.subscriptRes;
    }

    public int getSubscriptSkinSrcAttr() {
        return this.subscriptSkinSrcAttr;
    }

    public int getSubscriptSkinTintColorAttr() {
        return this.subscriptSkinTintColorAttr;
    }

    public int getTextSkinColorAttr() {
        return this.textSkinColorAttr;
    }

    public java.lang.Object getTag() {
        return this.tag;
    }

    public android.graphics.Typeface getTypeface() {
        return this.typeface;
    }
}
