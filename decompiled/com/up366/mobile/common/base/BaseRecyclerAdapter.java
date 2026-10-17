package com.up366.mobile.common.base;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class BaseRecyclerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter {
    protected static final int BASE_TYPE_DEFINE = -10000;
    public static final int TYPE_DEFINE = 4;
    public static final int TYPE_ERROR = -1;
    public static final int TYPE_FOOTER = 2;
    public static final int TYPE_FOOTER_REFRESH = -6;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_LOADING = -2;
    public static final int TYPE_NODATA = 3;
    public static final int TYPE_NODATA_FIRST = -3;
    public static final int TYPE_NONET = -4;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_WARN = -5;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    protected java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> datas = new java.util.ArrayList();
    private java.util.Map<java.lang.Object, java.lang.Integer> diffMap = new java.util.HashMap();
    private boolean disableCalculateDiff = false;
    private long disableAdapterDiffTime = android.os.SystemClock.uptimeMillis() + 1000;
    private boolean needRefreshAll = false;
    private boolean skipRefreshAll = false;

    public android.view.View inflate(int i) {
        return android.view.LayoutInflater.from(this.recyclerView.getContext()).inflate(i, (android.view.ViewGroup) this.recyclerView, false);
    }

    @java.lang.Deprecated
    public android.view.View inflate(android.view.ViewGroup viewGroup, int i) {
        return android.view.LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
    }

    /* JADX INFO: renamed from: setDatas, reason: merged with bridge method [inline-methods] */
    public void lambda$setDatas$0(final java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> list) {
        if (list != null) {
            if (isInComputingOrScrollingState()) {
                com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.base.BaseRecyclerAdapter$$ExternalSyntheticLambda1
                    @Override // com.up366.common.task.Task
                    public final void run() throws java.lang.Exception {
                        this.f$0.lambda$setDatas$0(list);
                    }
                });
                return;
            }
            if (this.disableCalculateDiff || this.disableAdapterDiffTime > android.os.SystemClock.uptimeMillis()) {
                this.datas = list;
                this.diffMap.clear();
                notifyDataSetChanged();
                for (com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder : this.datas) {
                    this.diffMap.put(dataHolder, java.lang.Integer.valueOf(dataHolder.hashCode()));
                }
                return;
            }
            calculateDiff(list);
        }
    }

    public void setDatas(java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> list, java.lang.Runnable runnable) {
        if (list != null) {
            this.datas = list;
            this.diffMap.clear();
            for (com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder : list) {
                this.diffMap.put(dataHolder, java.lang.Integer.valueOf(dataHolder.hashCode()));
            }
            runnable.run();
        }
    }

    public void setDisableCalculateDiff(boolean z) {
        this.disableCalculateDiff = z;
    }

    private void calculateDiff(final java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> list) {
        final java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> list2 = this.datas;
        this.needRefreshAll = false;
        androidx.recyclerview.widget.DiffUtil.DiffResult diffResultCalculateDiff = androidx.recyclerview.widget.DiffUtil.calculateDiff(new androidx.recyclerview.widget.DiffUtil.Callback() { // from class: com.up366.mobile.common.base.BaseRecyclerAdapter.1
            public int getOldListSize() {
                return list2.size();
            }

            public int getNewListSize() {
                return list.size();
            }

            public boolean areItemsTheSame(int i, int i2) {
                com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = (com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder) list2.get(i);
                com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder2 = (com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder) list.get(i2);
                boolean z = dataHolder.viewType == dataHolder2.viewType && com.up366.mobile.common.base.BaseRecyclerAdapter.this.objectEquals(dataHolder.o, dataHolder2.o) && com.up366.mobile.common.base.BaseRecyclerAdapter.this.objectEquals(dataHolder.o2, dataHolder2.o2);
                if ((dataHolder.o != dataHolder2.o || dataHolder.o2 != dataHolder2.o2 || dataHolder.o3 != dataHolder2.o3) && z) {
                    com.up366.mobile.common.base.BaseRecyclerAdapter.this.needRefreshAll = true;
                }
                return z;
            }

            public boolean areContentsTheSame(int i, int i2) {
                java.lang.Integer num;
                com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = (com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder) list2.get(i);
                com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder2 = (com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder) list.get(i2);
                boolean z = dataHolder.viewType == dataHolder2.viewType && com.up366.mobile.common.base.BaseRecyclerAdapter.this.objectEquals(dataHolder.o, dataHolder2.o) && com.up366.mobile.common.base.BaseRecyclerAdapter.this.objectEquals(dataHolder.o2, dataHolder2.o2);
                if (!z || ((num = (java.lang.Integer) com.up366.mobile.common.base.BaseRecyclerAdapter.this.diffMap.get(dataHolder)) != null && num.intValue() == dataHolder2.hashCode())) {
                    return z;
                }
                return false;
            }
        });
        this.datas = list;
        this.diffMap.clear();
        for (com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder : this.datas) {
            this.diffMap.put(dataHolder, java.lang.Integer.valueOf(dataHolder.hashCode()));
        }
        diffResultCalculateDiff.dispatchUpdatesTo(this);
        if (this.skipRefreshAll || !this.needRefreshAll) {
            return;
        }
        com.up366.common.task.TaskUtils.postLazyTaskMain(toString(), 800, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.base.BaseRecyclerAdapter$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                this.f$0.notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean objectEquals(java.lang.Object obj, java.lang.Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void onAttachedToRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    private boolean isInComputingOrScrollingState() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.recyclerView;
        return recyclerView != null && recyclerView.isComputingLayout();
    }

    public void onDetachedFromRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    public java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> getDatas() {
        return this.datas;
    }

    public int getItemViewType(int i) {
        if (this.datas.size() == 0) {
            return 1;
        }
        return this.datas.get(i).viewType;
    }

    public int getItemCount() {
        return this.datas.size();
    }

    public static class BaseViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public BaseViewHolder(android.view.View view) {
            super(view);
            if (view.getLayoutParams() == null && (view instanceof android.view.ViewGroup)) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
                if (viewGroup.getChildCount() == 1) {
                    view.setLayoutParams(new android.view.ViewGroup.LayoutParams(viewGroup.getChildAt(0).getLayoutParams()));
                }
            }
        }
    }

    public static class DataHolder {
        public java.lang.Object o;
        public java.lang.Object o2;
        public java.lang.Object o3;
        public int viewType;

        public DataHolder() {
        }

        public DataHolder(int i) {
            this.viewType = i;
        }

        public DataHolder(int i, java.lang.Object obj) {
            this.viewType = i;
            this.o = obj;
        }

        public DataHolder(int i, java.lang.Object obj, java.lang.Object obj2) {
            this.viewType = i;
            this.o = obj;
            this.o2 = obj2;
        }

        public DataHolder(int i, java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
            this.viewType = i;
            this.o = obj;
            this.o2 = obj2;
            this.o3 = obj3;
        }

        public java.lang.String toString() {
            return "DataHolder{viewType=" + this.viewType + ", o=" + this.o + '}';
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = (com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder) obj;
            if (this.viewType != dataHolder.viewType) {
                return false;
            }
            java.lang.Object obj2 = this.o;
            if (obj2 == null ? dataHolder.o != null : !obj2.equals(dataHolder.o)) {
                return false;
            }
            java.lang.Object obj3 = this.o2;
            if (obj3 == null ? dataHolder.o2 != null : !obj3.equals(dataHolder.o2)) {
                return false;
            }
            java.lang.Object obj4 = this.o3;
            java.lang.Object obj5 = dataHolder.o3;
            return obj4 != null ? obj4.equals(obj5) : obj5 == null;
        }

        public int hashCode() {
            int i = this.viewType * 31;
            java.lang.Object obj = this.o;
            int iHashCode = (i + (obj != null ? obj.hashCode() : 0)) * 31;
            java.lang.Object obj2 = this.o2;
            int iHashCode2 = (iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31;
            java.lang.Object obj3 = this.o3;
            return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
        }
    }

    public void reset() {
        this.disableAdapterDiffTime = android.os.SystemClock.uptimeMillis() + 1000;
    }

    public void setSkipRefreshAll(boolean z) {
        this.skipRefreshAll = z;
    }
}
