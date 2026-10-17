package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ParseNodeHelper {
    private static com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage> curNode;

    /* JADX WARN: Type inference failed for: r3v3, types: [T, com.up366.mobile.book.model.CatalogChapter] */
    public static java.util.List<com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage>> parse(com.up366.mobile.book.model.TreeBookChapter treeBookChapter) {
        int i;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.List<com.up366.mobile.book.model.CatalogChapter> chapters = treeBookChapter.getChapters();
        java.util.Iterator<com.up366.mobile.book.model.CatalogChapter> it = chapters.iterator();
        while (true) {
            z = false;
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            com.up366.mobile.book.model.CatalogChapter next = it.next();
            com.up366.mobile.book.model.TreeNode treeNode = new com.up366.mobile.book.model.TreeNode();
            treeNode.deep = 0;
            treeNode.id = next.obj.getId();
            treeNode.obj = next;
            treeNode.isHead = next == chapters.get(0);
            treeNode.isEnd = next == chapters.get(chapters.size() - 1);
            if (next.pages != null && next.pages.size() > 0) {
                z = true;
            }
            treeNode.hasSub = z;
            addNodeToList(arrayList, treeNode);
            parseUnits(1, next.pages, treeNode, arrayList);
        }
        java.util.List<com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage>> chapterList = treeBookChapter.getChapterList();
        if (chapterList != null && chapterList.size() == arrayList.size()) {
            for (i = 0; i < chapterList.size(); i++) {
                com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage> treeNode2 = chapterList.get(i);
                com.up366.mobile.book.model.TreeNode treeNode3 = (com.up366.mobile.book.model.TreeNode) arrayList.get(i);
                treeNode3.isExpand = treeNode2.isExpand;
                treeNode3.isChecked = treeNode2.isChecked;
            }
        }
        curNode = null;
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void addNodeToList(java.util.List<com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage>> list, com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage> treeNode) {
        com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage> treeNode2 = curNode;
        if (treeNode2 != null) {
            treeNode2.next = treeNode;
        }
        treeNode.last = curNode;
        list.add(treeNode);
        curNode = treeNode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, com.up366.mobile.book.model.CatalogChapter] */
    private static void parseUnits(int i, java.util.List<com.up366.mobile.book.model.CatalogChapter> list, com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage> treeNode, java.util.List<com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage>> list2) {
        treeNode.hasSub = false;
        java.util.Iterator<com.up366.mobile.book.model.CatalogChapter> it = list.iterator();
        while (it.hasNext()) {
            com.up366.mobile.book.model.CatalogChapter next = it.next();
            if (next.obj.isChapter()) {
                com.up366.mobile.book.model.TreeNode treeNode2 = new com.up366.mobile.book.model.TreeNode();
                treeNode2.deep = i;
                treeNode2.id = next.obj.getId();
                treeNode2.obj = next;
                treeNode2.parent = treeNode;
                treeNode2.isHead = next == list.get(0);
                treeNode2.isEnd = next == list.get(list.size() - 1);
                treeNode2.hasSub = next.pages != null && next.pages.size() > 0;
                addNodeToList(list2, treeNode2);
                if (next.pages.size() > 0) {
                    parseUnits(i + 1, next.pages, treeNode2, list2);
                }
                treeNode.hasSub = true;
            }
        }
    }
}
