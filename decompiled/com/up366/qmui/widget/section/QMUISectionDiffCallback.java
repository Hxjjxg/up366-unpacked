package com.up366.qmui.widget.section;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISectionDiffCallback<H extends com.up366.qmui.widget.section.QMUISection.Model<H>, T extends com.up366.qmui.widget.section.QMUISection.Model<T>> extends androidx.recyclerview.widget.DiffUtil.Callback {
    private java.util.ArrayList<com.up366.qmui.widget.section.QMUISection<H, T>> mOldList = new java.util.ArrayList<>();
    private java.util.ArrayList<com.up366.qmui.widget.section.QMUISection<H, T>> mNewList = new java.util.ArrayList<>();
    private android.util.SparseIntArray mOldSectionIndex = new android.util.SparseIntArray();
    private android.util.SparseIntArray mOldItemIndex = new android.util.SparseIntArray();
    private android.util.SparseIntArray mNewSectionIndex = new android.util.SparseIntArray();
    private android.util.SparseIntArray mNewItemIndex = new android.util.SparseIntArray();

    protected boolean areCustomContentsTheSame(com.up366.qmui.widget.section.QMUISection<H, T> qMUISection, int i, com.up366.qmui.widget.section.QMUISection<H, T> qMUISection2, int i2) {
        return false;
    }

    protected void onGenerateCustomIndexAfterItemList(com.up366.qmui.widget.section.QMUISectionDiffCallback.IndexGenerationInfo indexGenerationInfo, com.up366.qmui.widget.section.QMUISection<H, T> qMUISection, int i) {
    }

    protected void onGenerateCustomIndexAfterSectionList(com.up366.qmui.widget.section.QMUISectionDiffCallback.IndexGenerationInfo indexGenerationInfo, java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> list) {
    }

    protected void onGenerateCustomIndexBeforeItemList(com.up366.qmui.widget.section.QMUISectionDiffCallback.IndexGenerationInfo indexGenerationInfo, com.up366.qmui.widget.section.QMUISection<H, T> qMUISection, int i) {
    }

    protected void onGenerateCustomIndexBeforeSectionList(com.up366.qmui.widget.section.QMUISectionDiffCallback.IndexGenerationInfo indexGenerationInfo, java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> list) {
    }

    public QMUISectionDiffCallback(java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> list, java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> list2) {
        if (list != null) {
            this.mOldList.addAll(list);
        }
        if (list2 != null) {
            this.mNewList.addAll(list2);
        }
        generateIndex(this.mOldList, this.mOldSectionIndex, this.mOldItemIndex);
        generateIndex(this.mNewList, this.mNewSectionIndex, this.mNewItemIndex);
    }

    public void cloneNewIndexTo(android.util.SparseIntArray sparseIntArray, android.util.SparseIntArray sparseIntArray2) {
        sparseIntArray.clear();
        sparseIntArray2.clear();
        for (int i = 0; i < this.mNewSectionIndex.size(); i++) {
            sparseIntArray.append(this.mNewSectionIndex.keyAt(i), this.mNewSectionIndex.valueAt(i));
        }
        for (int i2 = 0; i2 < this.mNewItemIndex.size(); i2++) {
            sparseIntArray2.append(this.mNewItemIndex.keyAt(i2), this.mNewItemIndex.valueAt(i2));
        }
    }

    private void generateIndex(java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> list, android.util.SparseIntArray sparseIntArray, android.util.SparseIntArray sparseIntArray2) {
        sparseIntArray.clear();
        sparseIntArray2.clear();
        com.up366.qmui.widget.section.QMUISectionDiffCallback.IndexGenerationInfo indexGenerationInfo = new com.up366.qmui.widget.section.QMUISectionDiffCallback.IndexGenerationInfo(sparseIntArray, sparseIntArray2);
        if (list.isEmpty() || !list.get(0).isLocked()) {
            onGenerateCustomIndexBeforeSectionList(indexGenerationInfo, list);
        }
        for (int i = 0; i < list.size(); i++) {
            com.up366.qmui.widget.section.QMUISection<H, T> qMUISection = list.get(i);
            if (!qMUISection.isLocked()) {
                indexGenerationInfo.appendIndex(i, -2);
                if (!qMUISection.isFold()) {
                    onGenerateCustomIndexBeforeItemList(indexGenerationInfo, qMUISection, i);
                    if (qMUISection.isExistBeforeDataToLoad()) {
                        indexGenerationInfo.appendIndex(i, -3);
                    }
                    for (int i2 = 0; i2 < qMUISection.getItemCount(); i2++) {
                        indexGenerationInfo.appendIndex(i, i2);
                    }
                    if (qMUISection.isExistAfterDataToLoad()) {
                        indexGenerationInfo.appendIndex(i, -4);
                    }
                    onGenerateCustomIndexAfterItemList(indexGenerationInfo, qMUISection, i);
                }
            }
        }
        if (list.isEmpty()) {
            onGenerateCustomIndexAfterSectionList(indexGenerationInfo, list);
            return;
        }
        com.up366.qmui.widget.section.QMUISection<H, T> qMUISection2 = list.get(list.size() - 1);
        if (qMUISection2.isLocked()) {
            return;
        }
        if (qMUISection2.isFold() || !qMUISection2.isExistAfterDataToLoad()) {
            onGenerateCustomIndexAfterSectionList(indexGenerationInfo, list);
        }
    }

    public int getOldListSize() {
        return this.mOldSectionIndex.size();
    }

    public int getNewListSize() {
        return this.mNewSectionIndex.size();
    }

    public boolean areItemsTheSame(int i, int i2) {
        int i3 = this.mOldSectionIndex.get(i);
        int i4 = this.mOldItemIndex.get(i);
        int i5 = this.mNewSectionIndex.get(i2);
        int i6 = this.mNewItemIndex.get(i2);
        if (i3 < 0 || i5 < 0) {
            return i3 == i5 && i4 == i6;
        }
        com.up366.qmui.widget.section.QMUISection<H, T> qMUISection = this.mOldList.get(i3);
        com.up366.qmui.widget.section.QMUISection<H, T> qMUISection2 = this.mNewList.get(i5);
        if (!qMUISection.getHeader().isSameItem(qMUISection2.getHeader())) {
            return false;
        }
        if (i4 < 0 && i4 == i6) {
            return true;
        }
        if (i4 < 0 || i6 < 0) {
            return false;
        }
        com.up366.qmui.widget.section.QMUISection.Model itemAt = qMUISection.getItemAt(i4);
        com.up366.qmui.widget.section.QMUISection.Model itemAt2 = qMUISection2.getItemAt(i6);
        if (itemAt == null && itemAt2 == null) {
            return true;
        }
        return (itemAt == null || itemAt2 == null || !itemAt.isSameItem(itemAt2)) ? false : true;
    }

    public boolean areContentsTheSame(int i, int i2) {
        int i3 = this.mOldSectionIndex.get(i);
        int i4 = this.mOldItemIndex.get(i);
        int i5 = this.mNewSectionIndex.get(i2);
        int i6 = this.mNewItemIndex.get(i2);
        if (i5 < 0) {
            return areCustomContentsTheSame(null, i4, null, i6);
        }
        com.up366.qmui.widget.section.QMUISection<H, T> qMUISection = this.mOldList.get(i3);
        com.up366.qmui.widget.section.QMUISection<H, T> qMUISection2 = this.mNewList.get(i5);
        if (i4 == -2) {
            return qMUISection.isFold() == qMUISection2.isFold() && qMUISection.getHeader().isSameContent(qMUISection2.getHeader());
        }
        if (i4 == -3 || i4 == -4) {
            return false;
        }
        if (com.up366.qmui.widget.section.QMUISection.isCustomItemIndex(i4)) {
            return areCustomContentsTheSame(qMUISection, i4, qMUISection2, i6);
        }
        com.up366.qmui.widget.section.QMUISection.Model itemAt = qMUISection.getItemAt(i4);
        com.up366.qmui.widget.section.QMUISection.Model itemAt2 = qMUISection2.getItemAt(i6);
        if (itemAt == null && itemAt2 == null) {
            return true;
        }
        return (itemAt == null || itemAt2 == null || !itemAt.isSameContent(itemAt2)) ? false : true;
    }

    public static class IndexGenerationInfo {
        private int currentPosition;
        private android.util.SparseIntArray itemIndexArray;
        private android.util.SparseIntArray sectionIndexArray;

        private IndexGenerationInfo(android.util.SparseIntArray sparseIntArray, android.util.SparseIntArray sparseIntArray2) {
            this.sectionIndexArray = sparseIntArray;
            this.itemIndexArray = sparseIntArray2;
            this.currentPosition = 0;
        }

        public final void appendCustomIndex(int i, int i2) {
            int i3 = i2 - 1000;
            if (!com.up366.qmui.widget.section.QMUISection.isCustomItemIndex(i3)) {
                throw new java.lang.IllegalArgumentException("Index conflicts with index used internally, please use negative number for custom item");
            }
            appendIndex(i, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void appendIndex(int i, int i2) {
            if (i < 0) {
                throw new java.lang.IllegalArgumentException("use appendWholeListCustomIndex for whole list");
            }
            this.sectionIndexArray.append(this.currentPosition, i);
            this.itemIndexArray.append(this.currentPosition, i2);
            this.currentPosition++;
        }

        public final void appendWholeListCustomIndex(int i) {
            int i2 = i - 1000;
            if (!com.up366.qmui.widget.section.QMUISection.isCustomItemIndex(i2)) {
                throw new java.lang.IllegalArgumentException("Index conflicts with index used internally, please use negative number for custom item");
            }
            appendWholeListIndex(i2);
        }

        private final void appendWholeListIndex(int i) {
            this.sectionIndexArray.append(this.currentPosition, -1);
            this.itemIndexArray.append(this.currentPosition, i);
            this.currentPosition++;
        }
    }
}
