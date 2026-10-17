package com.up366.qmui.skin.defaultAttr;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinSimpleDefaultAttrProvider implements com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider {
    private androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> mSkinAttrs = new androidx.collection.SimpleArrayMap<>();

    public void setDefaultSkinAttr(java.lang.String str, int i) {
        this.mSkinAttrs.put(str, java.lang.Integer.valueOf(i));
    }

    @Override // com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> getDefaultSkinAttrs() {
        return this.mSkinAttrs;
    }
}
