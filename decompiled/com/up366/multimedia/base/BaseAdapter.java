package com.up366.multimedia.base;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class BaseAdapter<T> extends androidx.recyclerview.widget.RecyclerView.Adapter {
    public static final int TYPE_AUDIO = 5;
    public static final int TYPE_FOOTER = 2;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NODATA = 3;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_PICTURE = 4;
    public static final int TYPE_VIDEO = 6;
    protected java.util.List<com.up366.multimedia.base.BaseAdapter.DataHolder> datas = new java.util.ArrayList();

    public android.view.View inflate(android.view.ViewGroup parent, int layout) {
        return android.view.LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
    }

    public void setDatas(java.util.List<com.up366.multimedia.base.BaseAdapter.DataHolder> datas) {
        if (datas != null) {
            this.datas = datas;
            notifyDataSetChanged();
        }
    }

    public java.util.List<com.up366.multimedia.base.BaseAdapter.DataHolder> getDatas() {
        return this.datas;
    }

    public T getCurData(int position) {
        return this.datas.get(position).o;
    }

    public int getItemViewType(int position) {
        if (this.datas.size() == 0) {
            return 1;
        }
        return this.datas.get(position).viewType;
    }

    public int getItemCount() {
        return this.datas.size();
    }

    public static class BaseViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public BaseViewHolder(android.view.View itemView) {
            super(itemView);
        }
    }

    public static class DataHolder<T> {
        public T o;
        public int viewType;

        public DataHolder() {
        }

        public DataHolder(int viewType) {
            this.viewType = viewType;
        }

        public DataHolder(int viewType, T o) {
            this.viewType = viewType;
            this.o = o;
        }
    }
}
