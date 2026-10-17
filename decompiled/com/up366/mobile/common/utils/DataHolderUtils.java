package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DataHolderUtils {
    public static <T> java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> convertToDataHolder(java.util.List<T> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (list == null || list.size() == 0) {
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(3));
        } else {
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, it.next()));
            }
        }
        return arrayList;
    }
}
