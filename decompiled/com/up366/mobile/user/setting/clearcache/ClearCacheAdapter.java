package com.up366.mobile.user.setting.clearcache;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ClearCacheAdapter extends com.up366.mobile.common.base.USV5RecyclerAdapter {
    public static final int VIEW_TYPE_HOMEWORK = 8;
    public static final int VIEW_TYPE_SINGLE_BOOK = 9;
    public static final int VIEW_TYPE_TOTAL_BOOK = 10;

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        switch (i) {
            case 8:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.user.setting.clearcache.ClearCacheLittleItemView(viewGroup.getContext()));
            case 9:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.user.setting.clearcache.ClearCacheBigItemView(viewGroup.getContext()));
            case 10:
                return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.user.setting.clearcache.ClearCacheLittleItemView(viewGroup.getContext()));
            default:
                return defaultHandler(viewGroup, i);
        }
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.datas.get(i);
        switch (getItemViewType(i)) {
            case 8:
                ((com.up366.mobile.user.setting.clearcache.ClearCacheLittleItemView) viewHolder.itemView).setData((com.up366.mobile.user.setting.clearcache.CacheInfo) dataHolder.o);
                break;
            case 9:
                ((com.up366.mobile.user.setting.clearcache.ClearCacheBigItemView) viewHolder.itemView).setData((com.up366.mobile.user.setting.clearcache.CacheInfo) dataHolder.o);
                break;
            case 10:
                ((com.up366.mobile.user.setting.clearcache.ClearCacheLittleItemView) viewHolder.itemView).setData((com.up366.mobile.user.setting.clearcache.CacheInfo) dataHolder.o);
                break;
            default:
                defaultHandler(viewHolder, i);
                break;
        }
    }
}
