package com.pinyinsearch.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PinyinSearchUnit implements java.lang.Cloneable {
    private java.lang.String mBaseData;
    private java.lang.StringBuffer mMatchKeyword;
    private java.util.List<com.pinyinsearch.model.PinyinUnit> mPinyinUnits;

    public PinyinSearchUnit() {
        initPinyinSearchUnit();
    }

    public PinyinSearchUnit(java.lang.String str) {
        this.mBaseData = str;
        initPinyinSearchUnit();
    }

    public java.lang.String getBaseData() {
        return this.mBaseData;
    }

    public void setBaseData(java.lang.String str) {
        this.mBaseData = str;
    }

    public java.util.List<com.pinyinsearch.model.PinyinUnit> getPinyinUnits() {
        return this.mPinyinUnits;
    }

    public void setPinyinUnits(java.util.List<com.pinyinsearch.model.PinyinUnit> list) {
        this.mPinyinUnits = list;
    }

    public java.lang.StringBuffer getMatchKeyword() {
        return this.mMatchKeyword;
    }

    public void setMatchKeyword(java.lang.StringBuffer stringBuffer) {
        this.mMatchKeyword = stringBuffer;
    }

    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        com.pinyinsearch.model.PinyinSearchUnit pinyinSearchUnit = (com.pinyinsearch.model.PinyinSearchUnit) super.clone();
        pinyinSearchUnit.mPinyinUnits = new java.util.ArrayList();
        java.util.Iterator<com.pinyinsearch.model.PinyinUnit> it = this.mPinyinUnits.iterator();
        while (it.hasNext()) {
            pinyinSearchUnit.mPinyinUnits.add((com.pinyinsearch.model.PinyinUnit) it.next().clone());
        }
        return pinyinSearchUnit;
    }

    private void initPinyinSearchUnit() {
        this.mPinyinUnits = new java.util.ArrayList();
        this.mMatchKeyword = new java.lang.StringBuffer();
    }
}
