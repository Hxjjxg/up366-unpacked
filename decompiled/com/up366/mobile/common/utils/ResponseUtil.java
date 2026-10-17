package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ResponseUtil {
    public static <T> T parseObject(java.lang.String str, java.lang.Class<T> cls) {
        return (T) com.alibaba.fastjson.JSON.parseObject(str, cls);
    }

    public static com.alibaba.fastjson.JSONObject parseObject(java.lang.String str) {
        return com.alibaba.fastjson.JSON.parseObject(str);
    }

    public static <T> T parseObjectByName(java.lang.String str, java.lang.Class<T> cls, java.lang.String str2) {
        return (T) com.alibaba.fastjson.JSON.parseObject(str).getObject(str2, cls);
    }

    public static <T> java.util.List<T> parseArray(java.lang.String str, java.lang.Class<T> cls) {
        java.util.List<T> array = com.alibaba.fastjson.JSON.parseArray(str, cls);
        return array == null ? new java.util.ArrayList() : array;
    }

    public static com.alibaba.fastjson.JSONArray parseArray(java.lang.String str) {
        com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSON.parseArray(str);
        return array == null ? new com.alibaba.fastjson.JSONArray() : array;
    }

    public static <T> java.util.List<T> parseArrayByName(java.lang.String str, java.lang.Class<T> cls, java.lang.String str2) {
        com.alibaba.fastjson.JSONArray jSONArray = com.alibaba.fastjson.JSON.parseObject(str).getJSONArray(str2);
        java.util.ArrayList arrayList = new java.util.ArrayList(jSONArray.size());
        for (int i = 0; i < jSONArray.size(); i++) {
            arrayList.add(jSONArray.getObject(i, cls));
        }
        return arrayList;
    }

    public static <T> com.up366.mobile.common.utils.ResponseUtil.Pager<T> parsePager(java.lang.String str, java.lang.Class<T> cls) {
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(str);
        com.alibaba.fastjson.JSONArray jSONArray = object.getJSONArray("list");
        java.util.ArrayList arrayList = new java.util.ArrayList(jSONArray.size());
        for (int i = 0; i < jSONArray.size(); i++) {
            arrayList.add(jSONArray.getObject(i, cls));
        }
        com.up366.mobile.common.utils.ResponseUtil.Pager<T> pager = (com.up366.mobile.common.utils.ResponseUtil.Pager) object.getObject("pager", com.up366.mobile.common.utils.ResponseUtil.Pager.class);
        pager.setDatas(arrayList);
        return pager;
    }

    public static <T> java.util.List<T> parsePagerList(java.lang.String str, java.lang.Class<T> cls) {
        return parsePager(str, cls).datas;
    }

    public static com.up366.mobile.common.utils.ResponseUtil.Pager getPage(com.up366.common.http.Response response) {
        if (response == null || com.up366.common.StringUtils.isEmptyOrNull(response.getResponse())) {
            return new com.up366.mobile.common.utils.ResponseUtil.Pager();
        }
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(response.getResponse());
        if (object == null) {
            return new com.up366.mobile.common.utils.ResponseUtil.Pager();
        }
        com.up366.mobile.common.utils.ResponseUtil.Pager pager = (com.up366.mobile.common.utils.ResponseUtil.Pager) object.getObject("pager", com.up366.mobile.common.utils.ResponseUtil.Pager.class);
        return pager == null ? new com.up366.mobile.common.utils.ResponseUtil.Pager() : pager;
    }

    public static class Pager<T> {
        private int currentPage;
        private java.util.List<T> datas;
        private int indexPageCount;
        private int offset;
        private int pageCount;
        private int pageSize;
        private int totalCount;

        public java.util.List<T> getDatas() {
            return this.datas;
        }

        public void setDatas(java.util.List<T> list) {
            this.datas = list;
        }

        public int getCurrentPage() {
            return this.currentPage;
        }

        public void setCurrentPage(int i) {
            this.currentPage = i;
        }

        public int getIndexPageCount() {
            return this.indexPageCount;
        }

        public void setIndexPageCount(int i) {
            this.indexPageCount = i;
        }

        public int getOffset() {
            return this.offset;
        }

        public void setOffset(int i) {
            this.offset = i;
        }

        public int getPageCount() {
            return this.pageCount;
        }

        public void setPageCount(int i) {
            this.pageCount = i;
        }

        public int getPageSize() {
            return this.pageSize;
        }

        public void setPageSize(int i) {
            this.pageSize = i;
        }

        public int getTotalCount() {
            return this.totalCount;
        }

        public void setTotalCount(int i) {
            this.totalCount = i;
        }
    }
}
