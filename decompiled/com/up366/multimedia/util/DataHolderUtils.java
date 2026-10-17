package com.up366.multimedia.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class DataHolderUtils {
    public static final java.lang.String ATTCHME_TITLE = "ATTCHETITLE";

    public static <T> java.util.List<com.up366.multimedia.base.BaseAdapter.DataHolder> convertToDataHolder(java.util.List<T> datas) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = datas.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.up366.multimedia.base.BaseAdapter.DataHolder(1, it.next()));
        }
        return arrayList;
    }

    public static java.util.List<com.up366.multimedia.base.BaseAdapter.DataHolder> convertToMediaDataHolder(java.util.List<com.up366.multimedia.model.MediaAttachInfo> datas) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        for (com.up366.multimedia.model.MediaAttachInfo mediaAttachInfo : datas) {
            if (mediaAttachInfo.isPicture() || mediaAttachInfo.isVideo()) {
                arrayList3.add(new com.up366.multimedia.util.AlbumHelper.ImageItem(mediaAttachInfo.getId(), mediaAttachInfo.isVideo() ? mediaAttachInfo.getPosterUrl() : mediaAttachInfo.getUrl(), mediaAttachInfo.isVideo() ? mediaAttachInfo.getUrl() : ""));
            } else {
                arrayList2.add(new com.up366.multimedia.base.BaseAdapter.DataHolder(1, mediaAttachInfo));
            }
        }
        handlePicture(arrayList, arrayList3);
        hanleAttach(arrayList, arrayList2);
        return arrayList;
    }

    private static void handlePicture(java.util.List<com.up366.multimedia.base.BaseAdapter.DataHolder> dataHolders, java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItems) {
        if (imageItems == null || imageItems.size() == 0) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.addAll(imageItems);
        dataHolders.add(new com.up366.multimedia.base.BaseAdapter.DataHolder(4, arrayList));
    }

    private static void hanleAttach(java.util.List<com.up366.multimedia.base.BaseAdapter.DataHolder> dataHolders, java.util.List<com.up366.multimedia.base.BaseAdapter.DataHolder> attchHolders) {
        if (attchHolders.size() == 0) {
            return;
        }
        attchHolders.add(0, new com.up366.multimedia.base.BaseAdapter.DataHolder(0, new com.up366.multimedia.model.MediaAttachInfo(ATTCHME_TITLE, "附件", "", 0L, "", "", "")));
        dataHolders.addAll(attchHolders);
    }
}
