package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SortUtils {
    public static void sortFolder(java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) {
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.medialibrary.common.utils.SortUtils$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.medialibrary.common.utils.SortUtils.lambda$sortFolder$0((com.up366.medialibrary.model.LocalMediaFolder) obj, (com.up366.medialibrary.model.LocalMediaFolder) obj2);
            }
        });
    }

    static /* synthetic */ int lambda$sortFolder$0(com.up366.medialibrary.model.LocalMediaFolder localMediaFolder, com.up366.medialibrary.model.LocalMediaFolder localMediaFolder2) {
        if (localMediaFolder.getData() == null || localMediaFolder2.getData() == null) {
            return 0;
        }
        return java.lang.Integer.compare(localMediaFolder2.getImageNum(), localMediaFolder.getImageNum());
    }

    public static void sortLocalMediaAddedTime(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.medialibrary.common.utils.SortUtils$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return java.lang.Long.compare(((com.up366.medialibrary.model.LocalMedia) obj2).getDateAddedTime(), ((com.up366.medialibrary.model.LocalMedia) obj).getDateAddedTime());
            }
        });
    }
}
