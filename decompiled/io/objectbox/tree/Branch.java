package io.objectbox.tree;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class Branch {
    private final long id;
    private final io.objectbox.tree.Tree tree;

    private native long nativeGetBranchId(long j, long j2, java.lang.String[] strArr);

    private native io.objectbox.tree.LeafNode nativeGetLeaf(long j, long j2, java.lang.String[] strArr);

    Branch(io.objectbox.tree.Tree tree, long j) {
        this.tree = tree;
        this.id = j;
    }

    public io.objectbox.tree.Tree getTree() {
        return this.tree;
    }

    public long getId() {
        return this.id;
    }

    @javax.annotation.Nullable
    public io.objectbox.tree.Branch branch(java.lang.String[] strArr) {
        checkPath(strArr);
        long jNativeGetBranchId = nativeGetBranchId(this.tree.getHandle(), this.id, strArr);
        if (jNativeGetBranchId == 0) {
            return null;
        }
        return new io.objectbox.tree.Branch(this.tree, jNativeGetBranchId);
    }

    @javax.annotation.Nullable
    public io.objectbox.tree.Branch branch(java.lang.String str) {
        checkNameOrPath(str);
        return branch(str.split(this.tree.getPathSeparatorRegex()));
    }

    @javax.annotation.Nullable
    public io.objectbox.tree.Branch branchChild(java.lang.String str) {
        return branch(new java.lang.String[]{str});
    }

    @javax.annotation.Nullable
    public io.objectbox.tree.Leaf leaf(java.lang.String[] strArr) {
        checkPath(strArr);
        io.objectbox.tree.LeafNode leafNodeNativeGetLeaf = nativeGetLeaf(this.tree.getHandle(), this.id, strArr);
        if (leafNodeNativeGetLeaf == null) {
            return null;
        }
        return new io.objectbox.tree.Leaf(leafNodeNativeGetLeaf);
    }

    @javax.annotation.Nullable
    public io.objectbox.tree.Leaf leaf(java.lang.String str) {
        checkNameOrPath(str);
        return leaf(str.split(this.tree.getPathSeparatorRegex()));
    }

    @javax.annotation.Nullable
    public io.objectbox.tree.Leaf leafChild(java.lang.String str) {
        checkNameOrPath(str);
        return leaf(new java.lang.String[]{str});
    }

    private void checkNameOrPath(java.lang.String str) {
        if (str == null || str.length() == 0) {
            throw new java.lang.IllegalArgumentException("name/path must not be null or empty");
        }
    }

    private void checkPath(java.lang.String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new java.lang.IllegalArgumentException("path must not be null or empty");
        }
    }
}
