package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V4PageInfoHelper extends com.up366.mobile.book.helper.V6PageInfoHelper {
    public V4PageInfoHelper(com.up366.mobile.book.StudyActivity studyActivity, com.up366.mobile.book.model.CatalogPage catalogPage) {
        super(studyActivity, catalogPage);
    }

    public java.lang.String getChapterId() {
        return this.page.obj.getId();
    }

    public java.lang.String getCurrentPageInfo() {
        java.lang.String id = this.page.obj.getId();
        if (this.page.getChapterPPage() != null) {
            id = this.page.getChapterPPage().obj.getId();
        }
        java.lang.String id2 = this.page.obj.getId();
        java.lang.String name = this.page.obj.getName();
        this.page.obj.getDisplayOrder();
        java.lang.String str = this.page.obj.getDisplayOrder() + ".html";
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        for (com.up366.mobile.book.model.CatalogPage catalogPage = this.page.getpPage(); catalogPage != null; catalogPage = catalogPage.getpPage()) {
            if (catalogPage.getObj() != null) {
                jSONArray.add(0, catalogPage.getObj().getName());
            }
        }
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("unitId", id);
        jSONObject.put("pageId", id2);
        jSONObject.put("displayname", name);
        jSONObject.put("file", str);
        return jSONObject.toJSONString();
    }
}
