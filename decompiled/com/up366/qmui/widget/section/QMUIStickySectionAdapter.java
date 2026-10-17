package com.up366.qmui.widget.section;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class QMUIStickySectionAdapter<H extends com.up366.qmui.widget.section.QMUISection.Model<H>, T extends com.up366.qmui.widget.section.QMUISection.Model<T>, VH extends com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder> extends androidx.recyclerview.widget.RecyclerView.Adapter<VH> {
    public static final int ITEM_TYPE_CUSTOM_OFFSET = 1000;
    public static final int ITEM_TYPE_SECTION_HEADER = 0;
    public static final int ITEM_TYPE_SECTION_ITEM = 1;
    public static final int ITEM_TYPE_SECTION_LOADING = 2;
    public static final int ITEM_TYPE_UNKNOWN = -1;
    private static final java.lang.String TAG = "StickySectionAdapter";
    private com.up366.qmui.widget.section.QMUIStickySectionAdapter.Callback<H, T> mCallback;
    private com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewCallback mViewCallback;
    private java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> mBackupData = new java.util.ArrayList();
    private java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> mCurrentData = new java.util.ArrayList();
    private android.util.SparseIntArray mSectionIndex = new android.util.SparseIntArray();
    private android.util.SparseIntArray mItemIndex = new android.util.SparseIntArray();
    private java.util.ArrayList<com.up366.qmui.widget.section.QMUISection<H, T>> mLoadingBeforeSections = new java.util.ArrayList<>(2);
    private java.util.ArrayList<com.up366.qmui.widget.section.QMUISection<H, T>> mLoadingAfterSections = new java.util.ArrayList<>(2);

    public interface Callback<H extends com.up366.qmui.widget.section.QMUISection.Model<H>, T extends com.up366.qmui.widget.section.QMUISection.Model<T>> {
        void loadMore(com.up366.qmui.widget.section.QMUISection<H, T> qMUISection, boolean z);

        void onItemClick(com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder viewHolder, int i);

        boolean onItemLongClick(com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder viewHolder, int i);
    }

    public interface PositionFinder<H extends com.up366.qmui.widget.section.QMUISection.Model<H>, T extends com.up366.qmui.widget.section.QMUISection.Model<T>> {
        boolean find(com.up366.qmui.widget.section.QMUISection<H, T> qMUISection, T t);
    }

    public interface ViewCallback {
        androidx.recyclerview.widget.RecyclerView.ViewHolder findViewHolderForAdapterPosition(int i);

        void requestChildFocus(android.view.View view);

        void scrollToPosition(int i, boolean z, boolean z2);
    }

    protected void beforeDiffInSet(java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> list, java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> list2) {
    }

    protected int getCustomItemViewType(int i, int i2) {
        return -1;
    }

    protected void onBindCustomItem(VH vh, int i, com.up366.qmui.widget.section.QMUISection<H, T> qMUISection, int i2) {
    }

    protected void onBindSectionHeader(VH vh, int i, com.up366.qmui.widget.section.QMUISection<H, T> qMUISection) {
    }

    protected void onBindSectionItem(VH vh, int i, com.up366.qmui.widget.section.QMUISection<H, T> qMUISection, int i2) {
    }

    protected void onBindSectionLoadingItem(VH vh, int i, com.up366.qmui.widget.section.QMUISection<H, T> qMUISection, boolean z) {
    }

    protected abstract VH onCreateCustomItemViewHolder(android.view.ViewGroup viewGroup, int i);

    protected abstract VH onCreateSectionHeaderViewHolder(android.view.ViewGroup viewGroup);

    protected abstract VH onCreateSectionItemViewHolder(android.view.ViewGroup viewGroup);

    protected abstract VH onCreateSectionLoadingViewHolder(android.view.ViewGroup viewGroup);

    public final void setData(java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> list) {
        setData(list, true);
    }

    public final void setData(java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> list, boolean z) {
        setData(list, z, true);
    }

    public final void setData(java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> list, boolean z, boolean z2) {
        this.mLoadingBeforeSections.clear();
        this.mLoadingAfterSections.clear();
        this.mCurrentData.clear();
        if (list != null) {
            this.mCurrentData.addAll(list);
        }
        beforeDiffInSet(this.mBackupData, this.mCurrentData);
        if (!this.mCurrentData.isEmpty() && z2) {
            lock(this.mCurrentData.get(0));
        }
        diff(true, z);
    }

    public final void setDataWithoutDiff(java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> list, boolean z) {
        setDataWithoutDiff(list, z, true);
    }

    public final void setDataWithoutDiff(java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> list, boolean z, boolean z2) {
        this.mLoadingBeforeSections.clear();
        this.mLoadingAfterSections.clear();
        this.mCurrentData.clear();
        if (list != null) {
            this.mCurrentData.addAll(list);
        }
        if (z2 && !this.mCurrentData.isEmpty()) {
            lock(this.mCurrentData.get(0));
        }
        createDiffCallback(this.mBackupData, this.mCurrentData).cloneNewIndexTo(this.mSectionIndex, this.mItemIndex);
        notifyDataSetChanged();
        this.mBackupData.clear();
        for (com.up366.qmui.widget.section.QMUISection<H, T> qMUISection : this.mCurrentData) {
            this.mBackupData.add(z ? qMUISection.mutate() : qMUISection.cloneForDiff());
        }
    }

    private void diff(boolean z, boolean z2) {
        com.up366.qmui.widget.section.QMUISectionDiffCallback<H, T> qMUISectionDiffCallbackCreateDiffCallback = createDiffCallback(this.mBackupData, this.mCurrentData);
        androidx.recyclerview.widget.DiffUtil.DiffResult diffResultCalculateDiff = androidx.recyclerview.widget.DiffUtil.calculateDiff(qMUISectionDiffCallbackCreateDiffCallback, false);
        qMUISectionDiffCallbackCreateDiffCallback.cloneNewIndexTo(this.mSectionIndex, this.mItemIndex);
        diffResultCalculateDiff.dispatchUpdatesTo(this);
        if (z || this.mBackupData.size() != this.mCurrentData.size()) {
            this.mBackupData.clear();
            for (com.up366.qmui.widget.section.QMUISection<H, T> qMUISection : this.mCurrentData) {
                this.mBackupData.add(z2 ? qMUISection.mutate() : qMUISection.cloneForDiff());
            }
            return;
        }
        for (int i = 0; i < this.mCurrentData.size(); i++) {
            this.mCurrentData.get(i).cloneStatusTo(this.mBackupData.get(i));
        }
    }

    public void refreshCustomData() {
        com.up366.qmui.widget.section.QMUISectionDiffCallback<H, T> qMUISectionDiffCallbackCreateDiffCallback = createDiffCallback(this.mBackupData, this.mCurrentData);
        androidx.recyclerview.widget.DiffUtil.DiffResult diffResultCalculateDiff = androidx.recyclerview.widget.DiffUtil.calculateDiff(qMUISectionDiffCallbackCreateDiffCallback, false);
        qMUISectionDiffCallbackCreateDiffCallback.cloneNewIndexTo(this.mSectionIndex, this.mItemIndex);
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    protected com.up366.qmui.widget.section.QMUISectionDiffCallback<H, T> createDiffCallback(java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> list, java.util.List<com.up366.qmui.widget.section.QMUISection<H, T>> list2) {
        return new com.up366.qmui.widget.section.QMUISectionDiffCallback<>(list, list2);
    }

    public void setCallback(com.up366.qmui.widget.section.QMUIStickySectionAdapter.Callback<H, T> callback) {
        this.mCallback = callback;
    }

    void setViewCallback(com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewCallback viewCallback) {
        this.mViewCallback = viewCallback;
    }

    public int getItemIndex(int i) {
        if (i < 0 || i >= this.mItemIndex.size()) {
            return -1;
        }
        return this.mItemIndex.get(i);
    }

    public int getSectionIndex(int i) {
        if (i < 0 || i >= this.mSectionIndex.size()) {
            return -1;
        }
        return this.mSectionIndex.get(i);
    }

    public com.up366.qmui.widget.section.QMUISection<H, T> getSection(int i) {
        int i2;
        if (i < 0 || i >= this.mSectionIndex.size() || (i2 = this.mSectionIndex.get(i)) < 0 || i2 >= this.mCurrentData.size()) {
            return null;
        }
        return this.mCurrentData.get(i2);
    }

    public com.up366.qmui.widget.section.QMUISection<H, T> getSectionDirectly(int i) {
        if (i < 0 || i >= this.mCurrentData.size()) {
            return null;
        }
        return this.mCurrentData.get(i);
    }

    public boolean isSectionFold(int i) {
        com.up366.qmui.widget.section.QMUISection<H, T> section = getSection(i);
        if (section == null) {
            return false;
        }
        return section.isFold();
    }

    public T getSectionItem(int i) {
        com.up366.qmui.widget.section.QMUISection<H, T> section;
        int itemIndex = getItemIndex(i);
        if (itemIndex >= 0 && (section = getSection(i)) != null) {
            return (T) section.getItemAt(itemIndex);
        }
        return null;
    }

    public void finishLoadMore(com.up366.qmui.widget.section.QMUISection<H, T> qMUISection, java.util.List<T> list, boolean z, boolean z2) {
        if (z) {
            this.mLoadingBeforeSections.remove(qMUISection);
        } else {
            this.mLoadingAfterSections.remove(qMUISection);
        }
        if (this.mCurrentData.indexOf(qMUISection) < 0) {
            return;
        }
        if (z && !qMUISection.isFold()) {
            int i = 0;
            while (true) {
                if (i >= this.mItemIndex.size()) {
                    break;
                }
                int iKeyAt = this.mItemIndex.keyAt(i);
                if (this.mItemIndex.valueAt(i) == 0 && qMUISection == getSection(iKeyAt)) {
                    com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewCallback viewCallback = this.mViewCallback;
                    androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = viewCallback == null ? null : viewCallback.findViewHolderForAdapterPosition(iKeyAt);
                    if (viewHolderFindViewHolderForAdapterPosition != null) {
                        this.mViewCallback.requestChildFocus(viewHolderFindViewHolderForAdapterPosition.itemView);
                    }
                } else {
                    i++;
                }
            }
        }
        qMUISection.finishLoadMore(list, z, z2);
        lock(qMUISection);
        diff(true, true);
    }

    private void lock(com.up366.qmui.widget.section.QMUISection<H, T> qMUISection) {
        boolean z = (qMUISection.isFold() || !qMUISection.isExistBeforeDataToLoad() || qMUISection.isErrorToLoadBefore()) ? false : true;
        boolean z2 = (qMUISection.isFold() || !qMUISection.isExistAfterDataToLoad() || qMUISection.isErrorToLoadAfter()) ? false : true;
        int iIndexOf = this.mCurrentData.indexOf(qMUISection);
        if (iIndexOf < 0 || iIndexOf >= this.mCurrentData.size()) {
            return;
        }
        qMUISection.setLocked(false);
        lockBefore(iIndexOf - 1, z);
        lockAfter(iIndexOf + 1, z2);
    }

    private void lockBefore(int i, boolean z) {
        while (i >= 0) {
            com.up366.qmui.widget.section.QMUISection<H, T> qMUISection = this.mCurrentData.get(i);
            if (z) {
                qMUISection.setLocked(true);
            } else {
                qMUISection.setLocked(false);
                z = (qMUISection.isFold() || !qMUISection.isExistBeforeDataToLoad() || qMUISection.isErrorToLoadBefore()) ? false : true;
            }
            i--;
        }
    }

    private void lockAfter(int i, boolean z) {
        while (i < this.mCurrentData.size()) {
            com.up366.qmui.widget.section.QMUISection<H, T> qMUISection = this.mCurrentData.get(i);
            if (z) {
                qMUISection.setLocked(true);
            } else {
                qMUISection.setLocked(false);
                z = (qMUISection.isFold() || !qMUISection.isExistAfterDataToLoad() || qMUISection.isErrorToLoadAfter()) ? false : true;
            }
            i++;
        }
    }

    public void scrollToSectionHeader(com.up366.qmui.widget.section.QMUISection<H, T> qMUISection, boolean z) {
        if (this.mViewCallback == null) {
            return;
        }
        for (int i = 0; i < this.mCurrentData.size(); i++) {
            com.up366.qmui.widget.section.QMUISection<H, T> qMUISection2 = this.mCurrentData.get(i);
            if (qMUISection.getHeader().isSameItem(qMUISection2.getHeader())) {
                if (qMUISection2.isLocked()) {
                    lock(qMUISection2);
                    diff(false, true);
                    safeScrollToSection(qMUISection2, z);
                    return;
                }
                safeScrollToSection(qMUISection2, z);
                return;
            }
        }
    }

    private void safeScrollToSection(com.up366.qmui.widget.section.QMUISection<H, T> qMUISection, boolean z) {
        for (int i = 0; i < this.mSectionIndex.size(); i++) {
            int iKeyAt = this.mSectionIndex.keyAt(i);
            int iValueAt = this.mSectionIndex.valueAt(i);
            if (iValueAt >= 0 && iValueAt < this.mCurrentData.size() && this.mItemIndex.get(iKeyAt) == -2 && this.mCurrentData.get(iValueAt).getHeader().isSameItem(qMUISection.getHeader())) {
                this.mViewCallback.scrollToPosition(iKeyAt, true, z);
                return;
            }
        }
    }

    public void scrollToSectionItem(com.up366.qmui.widget.section.QMUISection<H, T> qMUISection, T t, boolean z) {
        if (this.mViewCallback == null) {
            return;
        }
        for (int i = 0; i < this.mCurrentData.size(); i++) {
            com.up366.qmui.widget.section.QMUISection<H, T> qMUISection2 = this.mCurrentData.get(i);
            if ((qMUISection == null && qMUISection2.existItem(t)) || qMUISection == qMUISection2) {
                if (qMUISection2.isFold() || qMUISection2.isLocked()) {
                    qMUISection2.setFold(false);
                    lock(qMUISection2);
                    diff(false, true);
                    safeScrollToSectionItem(qMUISection2, t, z);
                    return;
                }
                safeScrollToSectionItem(qMUISection2, t, z);
                return;
            }
        }
    }

    private void safeScrollToSectionItem(com.up366.qmui.widget.section.QMUISection<H, T> qMUISection, T t, boolean z) {
        com.up366.qmui.widget.section.QMUISection<H, T> section;
        for (int i = 0; i < this.mItemIndex.size(); i++) {
            int iKeyAt = this.mItemIndex.keyAt(i);
            int iValueAt = this.mItemIndex.valueAt(i);
            if (iValueAt >= 0 && (section = getSection(iKeyAt)) == qMUISection && section.getItemAt(iValueAt).isSameItem(t)) {
                this.mViewCallback.scrollToPosition(iKeyAt, false, z);
                return;
            }
        }
    }

    public int findCustomPosition(int i, int i2, boolean z) {
        return findPosition(i, i2 - 1000, z);
    }

    public int findPosition(int i, int i2, boolean z) {
        com.up366.qmui.widget.section.QMUISection<H, T> qMUISection;
        if (z && i >= 0 && (qMUISection = this.mCurrentData.get(i)) != null && qMUISection.isFold()) {
            qMUISection.setFold(false);
            lock(qMUISection);
            diff(false, true);
        }
        for (int i3 = 0; i3 < getItemCount(); i3++) {
            if (this.mSectionIndex.get(i3) == i && this.mItemIndex.get(i3) == i2) {
                return i3;
            }
        }
        return -1;
    }

    public int findPosition(com.up366.qmui.widget.section.QMUIStickySectionAdapter.PositionFinder<H, T> positionFinder, boolean z) {
        java.lang.Object obj;
        java.lang.Object itemAt = null;
        int i = 0;
        if (!z) {
            while (i < getItemCount()) {
                com.up366.qmui.widget.section.QMUISection<H, T> section = getSection(i);
                if (section != null) {
                    int itemIndex = getItemIndex(i);
                    if (itemIndex == -2) {
                        if (positionFinder.find(section, null)) {
                            return i;
                        }
                    } else if (itemIndex >= 0 && positionFinder.find(section, section.getItemAt(itemIndex))) {
                        return i;
                    }
                }
                i++;
            }
            return -1;
        }
        for (int i2 = 0; i2 < this.mCurrentData.size(); i2++) {
            com.up366.qmui.widget.section.QMUISection<H, T> qMUISection = this.mCurrentData.get(i2);
            if (!positionFinder.find(qMUISection, null)) {
                for (int i3 = 0; i3 < qMUISection.getItemCount(); i3++) {
                    if (positionFinder.find(qMUISection, qMUISection.getItemAt(i3))) {
                        itemAt = qMUISection.getItemAt(i3);
                        if (qMUISection.isFold()) {
                            qMUISection.setFold(false);
                            lock(qMUISection);
                            diff(false, true);
                        }
                    }
                }
            }
            obj = itemAt;
            itemAt = qMUISection;
        }
        obj = null;
        while (i < getItemCount()) {
            com.up366.qmui.widget.section.QMUISection<H, T> section2 = getSection(i);
            if (section2 == itemAt) {
                int itemIndex2 = getItemIndex(i);
                if (itemIndex2 == -2 && obj == null) {
                    return i;
                }
                if (itemIndex2 >= 0 && section2.getItemAt(itemIndex2).isSameItem(obj)) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    public void toggleFold(int i, boolean z) {
        com.up366.qmui.widget.section.QMUISection<H, T> section = getSection(i);
        if (section == null) {
            return;
        }
        section.setFold(!section.isFold());
        lock(section);
        diff(false, true);
        if (!z || section.isFold() || this.mViewCallback == null) {
            return;
        }
        for (int i2 = 0; i2 < this.mSectionIndex.size(); i2++) {
            int iKeyAt = this.mSectionIndex.keyAt(i2);
            if (getItemIndex(iKeyAt) == -2 && getSection(iKeyAt) == section) {
                this.mViewCallback.scrollToPosition(iKeyAt, true, true);
                return;
            }
        }
    }

    public int getRelativeStickyPosition(int i) {
        while (getItemViewType(i) != 0) {
            i--;
            if (i < 0) {
                return -1;
            }
        }
        return i;
    }

    public final int getItemCount() {
        return this.mItemIndex.size();
    }

    public final VH onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == 0) {
            return (VH) onCreateSectionHeaderViewHolder(viewGroup);
        }
        if (i == 1) {
            return (VH) onCreateSectionItemViewHolder(viewGroup);
        }
        if (i == 2) {
            return (VH) onCreateSectionLoadingViewHolder(viewGroup);
        }
        return (VH) onCreateCustomItemViewHolder(viewGroup, i - 1000);
    }

    public final void onBindViewHolder(final VH vh, final int i) {
        com.up366.qmui.widget.section.QMUISection<H, T> section = getSection(i);
        int itemIndex = getItemIndex(i);
        if (itemIndex == -2) {
            onBindSectionHeader(vh, i, section);
        } else if (itemIndex >= 0) {
            onBindSectionItem(vh, i, section, itemIndex);
        } else if (itemIndex == -3 || itemIndex == -4) {
            onBindSectionLoadingItem(vh, i, section, itemIndex == -3);
        } else {
            onBindCustomItem(vh, i, section, itemIndex + 1000);
        }
        if (itemIndex == -4) {
            vh.isLoadBefore = false;
        } else if (itemIndex == -3) {
            vh.isLoadBefore = true;
        }
        ((com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder) vh).itemView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.qmui.widget.section.QMUIStickySectionAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                int adapterPosition = vh.isForStickyHeader ? i : vh.getAdapterPosition();
                if (adapterPosition == -1 || com.up366.qmui.widget.section.QMUIStickySectionAdapter.this.mCallback == null) {
                    return;
                }
                com.up366.qmui.widget.section.QMUIStickySectionAdapter.this.mCallback.onItemClick(vh, adapterPosition);
            }
        });
        ((com.up366.qmui.widget.section.QMUIStickySectionAdapter.ViewHolder) vh).itemView.setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.up366.qmui.widget.section.QMUIStickySectionAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(android.view.View view) {
                int adapterPosition = vh.isForStickyHeader ? i : vh.getAdapterPosition();
                if (adapterPosition == -1 || com.up366.qmui.widget.section.QMUIStickySectionAdapter.this.mCallback == null) {
                    return false;
                }
                return com.up366.qmui.widget.section.QMUIStickySectionAdapter.this.mCallback.onItemLongClick(vh, adapterPosition);
            }
        });
    }

    public final int getItemViewType(int i) {
        int itemIndex = getItemIndex(i);
        if (itemIndex == -1) {
            android.util.Log.e(TAG, "the item index is undefined, you may need to check your data if not called by QMUIStickySectionItemDecoration.");
            return -1;
        }
        if (itemIndex == -2) {
            return 0;
        }
        if (itemIndex == -3 || itemIndex == -4) {
            return 2;
        }
        if (itemIndex >= 0) {
            return 1;
        }
        return getCustomItemViewType(itemIndex + 1000, i) + 1000;
    }

    public void onViewAttachedToWindow(VH vh) {
        com.up366.qmui.widget.section.QMUISection<H, T> section;
        if (vh.getItemViewType() != 2 || this.mCallback == null || vh.isLoadError || (section = getSection(vh.getAdapterPosition())) == null) {
            return;
        }
        if (vh.isLoadBefore) {
            if (this.mLoadingBeforeSections.contains(section)) {
                return;
            }
            this.mLoadingBeforeSections.add(section);
            this.mCallback.loadMore(section, true);
            return;
        }
        if (this.mLoadingAfterSections.contains(section)) {
            return;
        }
        this.mLoadingAfterSections.add(section);
        this.mCallback.loadMore(section, false);
    }

    public static class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public boolean isForStickyHeader;
        public boolean isLoadBefore;
        public boolean isLoadError;

        public ViewHolder(android.view.View view) {
            super(view);
            this.isLoadError = false;
            this.isLoadBefore = false;
            this.isForStickyHeader = false;
        }
    }
}
