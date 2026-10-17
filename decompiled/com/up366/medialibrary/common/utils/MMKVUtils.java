package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MMKVUtils {
    private final com.tencent.mmkv.MMKV coverCache;
    private final com.tencent.mmkv.MMKV imageSizeCache;
    private final com.tencent.mmkv.MMKV mediaListCache;
    private final com.tencent.mmkv.MMKV permissionCache;
    private final com.tencent.mmkv.MMKV thumbnailCache;

    public static com.up366.medialibrary.common.utils.MMKVUtils getInst() {
        return com.up366.medialibrary.common.utils.MMKVUtils.CacheManagerHolder.INSTANCE;
    }

    private MMKVUtils() {
        this.coverCache = com.tencent.mmkv.MMKV.mmkvWithID("coverCache");
        this.mediaListCache = com.tencent.mmkv.MMKV.mmkvWithID("mediaListCache");
        this.permissionCache = com.tencent.mmkv.MMKV.mmkvWithID("permissionCache");
        this.imageSizeCache = com.tencent.mmkv.MMKV.mmkvWithID("imageSizeCache");
        this.thumbnailCache = com.tencent.mmkv.MMKV.mmkvWithID("thumbnailCache");
    }

    public void putThumbnail(java.lang.String str, java.lang.String str2) {
        this.thumbnailCache.putString(str, str2);
    }

    public java.lang.String getThumbnail(java.lang.String str) {
        return this.thumbnailCache.getString(str, (java.lang.String) null);
    }

    public void putSize(java.lang.String str, android.util.Size size) {
        this.imageSizeCache.putString(str, size.toString());
    }

    public android.util.Size getSize(java.lang.String str) {
        java.lang.String string = this.imageSizeCache.getString(str, "");
        if ("".equals(string)) {
            return null;
        }
        return android.util.Size.parseSize(string);
    }

    public java.lang.String getValue(long j) {
        return this.coverCache.getString(j + "", "");
    }

    public void putValue(long j, java.lang.String str) {
        this.coverCache.putString(j + "", str);
    }

    public java.lang.String getUriPermission(java.lang.String str) {
        return this.permissionCache.getString(str, "");
    }

    public void putUriPermission(java.lang.String str, java.lang.String str2) {
        this.permissionCache.putString(str, str2);
    }

    private static final class CacheManagerHolder {
        private static final com.up366.medialibrary.common.utils.MMKVUtils INSTANCE = new com.up366.medialibrary.common.utils.MMKVUtils();

        private CacheManagerHolder() {
        }
    }

    public long getMediaCount() {
        return this.mediaListCache.count();
    }

    public void saveData(final java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) {
        this.mediaListCache.clear();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.medialibrary.common.utils.MMKVUtils$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.m174lambda$saveData$0$comup366medialibrarycommonutilsMMKVUtils(list);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$saveData$0$com-up366-medialibrary-common-utils-MMKVUtils, reason: not valid java name */
    /* synthetic */ void m174lambda$saveData$0$comup366medialibrarycommonutilsMMKVUtils(java.util.List list) throws java.lang.Exception {
        for (int i = 0; i < list.size(); i++) {
            this.mediaListCache.putString("" + i, com.alibaba.fastjson.JSON.toJSONString(list.get(i)));
        }
        this.mediaListCache.commit();
    }

    public java.util.List<com.up366.medialibrary.model.LocalMediaFolder> getCacheMediaDatas() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        while (true) {
            java.lang.String string = this.mediaListCache.getString(i + "", "");
            if ("".equals(string)) {
                return arrayList;
            }
            arrayList.add((com.up366.medialibrary.model.LocalMediaFolder) com.alibaba.fastjson.JSON.parseObject(string, com.up366.medialibrary.model.LocalMediaFolder.class));
            i++;
        }
    }
}
