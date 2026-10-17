package com.up366.mobile.me.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MyBookListUtils {
    public static java.util.List<com.up366.mobile.common.logic.model.MyBook> buildMyBooks() {
        java.util.Map<java.lang.String, com.up366.mobile.common.logic.model.ProductInfo> productMap = com.up366.mobile.common.logic.Auth.cur().book().getProductMap();
        java.util.List<com.up366.mobile.course.mgr.CourseBookInfo> listLoadAll = com.up366.mobile.common.logic.Auth.cur().course().loadAll();
        com.up366.mobile.common.logic.Auth.cur().course().setUpCourseBookNewStatus(listLoadAll);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.HashMap map = new java.util.HashMap();
        for (com.up366.mobile.common.logic.model.ProductInfo productInfo : productMap.values()) {
            com.up366.mobile.common.logic.model.MyBook myBook = new com.up366.mobile.common.logic.model.MyBook(productInfo);
            arrayList.add(myBook);
            map.put(productInfo.getBookId(), myBook);
        }
        if (listLoadAll == null) {
            sortByStudyTime(arrayList);
            return arrayList;
        }
        for (com.up366.mobile.course.mgr.CourseBookInfo courseBookInfo : listLoadAll) {
            if (!map.containsKey(courseBookInfo.getBookId())) {
                com.up366.mobile.common.logic.model.MyBook myBook2 = new com.up366.mobile.common.logic.model.MyBook(courseBookInfo);
                arrayList.add(myBook2);
                map.put(courseBookInfo.getBookId(), myBook2);
            }
            ((com.up366.mobile.common.logic.model.MyBook) java.util.Objects.requireNonNull((com.up366.mobile.common.logic.model.MyBook) map.get(courseBookInfo.getBookId()))).addCourseBookInfo(courseBookInfo);
        }
        sortByStudyTime(arrayList);
        return arrayList;
    }

    private static void sortByStudyTime(java.util.List<com.up366.mobile.common.logic.model.MyBook> list) {
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.me.book.MyBookListUtils$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return java.lang.Long.compare(((com.up366.mobile.common.logic.model.MyBook) obj2).getLastStudyTime(), ((com.up366.mobile.common.logic.model.MyBook) obj).getLastStudyTime());
            }
        });
    }
}
