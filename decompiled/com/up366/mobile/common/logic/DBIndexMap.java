package com.up366.mobile.common.logic;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class DBIndexMap {
    public static final java.util.HashMap<java.lang.String, io.objectbox.Property<?>> dbMap;

    DBIndexMap() {
    }

    static {
        java.util.HashMap<java.lang.String, io.objectbox.Property<?>> map = new java.util.HashMap<>();
        dbMap = map;
        map.put("AppCacheInfo", com.up366.mobile.common.logic.model.AppCacheInfo_.key);
        map.put("RecordResultHistory", com.up366.mobile.book.helper.recorder.RecordResultHistory_.objectId);
        map.put("FileCacheInfo", com.up366.mobile.common.utils.alifile.FileCacheInfo_.key);
        map.put("BookResourceMapInfo", com.up366.mobile.book.model.BookResourceMapInfo_.path);
        map.put("StudyTaskJsonMapInfo", com.up366.mobile.book.model.StudyTaskJsonMapInfo_.jobId);
    }
}
