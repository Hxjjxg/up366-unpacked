package com.up366.mobile.user.setting.clearcache;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ClearCacheLittleItemView extends android.widget.FrameLayout {
    com.up366.mobile.user.setting.clearcache.CacheInfo mCacheInfo;
    android.widget.TextView mCacheName;
    private android.widget.TextView mCacheSizeTv;
    android.widget.ImageView mCheckRdio;

    public ClearCacheLittleItemView(android.content.Context context) {
        this(context, null);
    }

    public ClearCacheLittleItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClearCacheLittleItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        android.view.View viewInflate = android.view.View.inflate(getContext(), com.up366.mobile.R.layout.clear_cache_little_item, this);
        this.mCheckRdio = (android.widget.ImageView) viewInflate.findViewById(com.up366.mobile.R.id.clear_cache_little_item_check_radio);
        this.mCacheName = (android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.clear_cache_little_item_cache_name);
        this.mCacheSizeTv = (android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.tv_cache_size);
        findViewById(com.up366.mobile.R.id.clear_cacle_little_item_content).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.clearcache.ClearCacheLittleItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.up366.mobile.user.setting.clearcache.ClearCacheLittleItemView.this.mCacheInfo.isSelected()) {
                    com.up366.mobile.user.setting.clearcache.ClearCacheLittleItemView.this.mCheckRdio.setImageResource(com.up366.mobile.R.drawable.icon_selected_no);
                    com.up366.mobile.user.setting.clearcache.ClearCacheLittleItemView.this.mCacheInfo.setSelected(false);
                } else {
                    com.up366.mobile.user.setting.clearcache.ClearCacheLittleItemView.this.mCheckRdio.setImageResource(com.up366.mobile.R.drawable.icon_selected);
                    com.up366.mobile.user.setting.clearcache.ClearCacheLittleItemView.this.mCacheInfo.setSelected(true);
                }
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.user.setting.clearcache.CacheSelectEvent(com.up366.mobile.user.setting.clearcache.ClearCacheLittleItemView.this.mCacheInfo));
            }
        });
    }

    protected void setData(com.up366.mobile.user.setting.clearcache.CacheInfo cacheInfo) {
        if (cacheInfo.isSelected()) {
            this.mCheckRdio.setImageResource(com.up366.mobile.R.drawable.icon_selected);
        } else {
            this.mCheckRdio.setImageResource(com.up366.mobile.R.drawable.icon_selected_no);
        }
        this.mCacheName.setText(cacheInfo.getCacheName());
        this.mCacheSizeTv.setText(com.up366.common.ByteUtilsUp.bytesToMKB(cacheInfo.getCacheSize()));
        this.mCacheInfo = cacheInfo;
    }
}
