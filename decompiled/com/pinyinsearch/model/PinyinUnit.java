package com.pinyinsearch.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PinyinUnit implements java.lang.Cloneable {
    private boolean mPinyin = false;
    private int mStartPosition = -1;
    private java.util.List<com.pinyinsearch.model.PinyinBaseUnit> mPinyinBaseUnitIndex = new java.util.ArrayList();

    public boolean isPinyin() {
        return this.mPinyin;
    }

    public void setPinyin(boolean z) {
        this.mPinyin = z;
    }

    public int getStartPosition() {
        return this.mStartPosition;
    }

    public void setStartPosition(int i) {
        this.mStartPosition = i;
    }

    public java.util.List<com.pinyinsearch.model.PinyinBaseUnit> getPinyinBaseUnitIndex() {
        return this.mPinyinBaseUnitIndex;
    }

    public void setPinyinBaseUnitIndex(java.util.List<com.pinyinsearch.model.PinyinBaseUnit> list) {
        this.mPinyinBaseUnitIndex = list;
    }

    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        com.pinyinsearch.model.PinyinUnit pinyinUnit = (com.pinyinsearch.model.PinyinUnit) super.clone();
        pinyinUnit.mPinyinBaseUnitIndex = new java.util.ArrayList();
        java.util.Iterator<com.pinyinsearch.model.PinyinBaseUnit> it = this.mPinyinBaseUnitIndex.iterator();
        while (it.hasNext()) {
            pinyinUnit.mPinyinBaseUnitIndex.add((com.pinyinsearch.model.PinyinBaseUnit) it.next().clone());
        }
        return pinyinUnit;
    }
}
