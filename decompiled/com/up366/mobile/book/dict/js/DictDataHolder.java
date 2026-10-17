package com.up366.mobile.book.dict.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DictDataHolder {
    public com.alibaba.fastjson.JSONObject exerciseData;
    public java.lang.String exerciseType;

    public DictDataHolder(java.lang.String str, java.lang.String str2) {
        init(str, str2);
    }

    public void init(java.lang.String str, java.lang.String str2) {
        this.exerciseType = str;
        this.exerciseData = com.alibaba.fastjson.JSON.parseObject(str2);
    }
}
