package com.up366.mobile.book.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TreeNode<T> {
    public int deep;
    public java.lang.String id;
    public com.up366.mobile.book.model.TreeNode<T> last;
    public com.up366.mobile.book.model.TreeNode<T> next;
    public T obj;
    public com.up366.mobile.book.model.TreeNode<T> parent;
    public boolean isExpand = false;
    public boolean hasSub = false;
    public boolean isHead = false;
    public boolean isEnd = false;
    public boolean isChecked = false;

    public boolean isVisible() {
        for (com.up366.mobile.book.model.TreeNode<T> treeNode = this.parent; treeNode != null; treeNode = treeNode.parent) {
            if (!treeNode.isExpand) {
                return false;
            }
        }
        return true;
    }

    public com.up366.mobile.book.model.TreeNode<T> lastVisibleNode() {
        for (com.up366.mobile.book.model.TreeNode<T> treeNode = this.last; treeNode != null; treeNode = treeNode.last) {
            if (treeNode.isVisible()) {
                return treeNode;
            }
        }
        return null;
    }

    public com.up366.mobile.book.model.TreeNode<T> nextVisibleNode() {
        for (com.up366.mobile.book.model.TreeNode<T> treeNode = this.next; treeNode != null; treeNode = treeNode.next) {
            if (treeNode.isVisible()) {
                return treeNode;
            }
        }
        return null;
    }

    public com.up366.mobile.book.model.TreeNode<T> lastSameLevelNode() {
        return lastSameLevelNode(this.deep, this.parent);
    }

    private com.up366.mobile.book.model.TreeNode<T> lastSameLevelNode(int i, com.up366.mobile.book.model.TreeNode<T> treeNode) {
        for (com.up366.mobile.book.model.TreeNode<T> treeNode2 = this.last; treeNode2 != null; treeNode2 = treeNode2.last) {
            if (treeNode2.deep == i) {
                if (treeNode2.parent == treeNode) {
                    return treeNode2;
                }
                return null;
            }
        }
        return null;
    }

    public com.up366.mobile.book.model.TreeNode<T> nextSameLevelNode() {
        return nextSameLevelNode(this.deep, this.parent);
    }

    private com.up366.mobile.book.model.TreeNode<T> nextSameLevelNode(int i, com.up366.mobile.book.model.TreeNode<T> treeNode) {
        for (com.up366.mobile.book.model.TreeNode<T> treeNode2 = this.next; treeNode2 != null; treeNode2 = treeNode2.next) {
            if (treeNode2.deep == i) {
                if (treeNode2.parent == treeNode) {
                    return treeNode2;
                }
                return null;
            }
        }
        return null;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }
}
