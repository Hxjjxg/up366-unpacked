package com.up366.mobile.user.setting.clearcache;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ClearCacheBigItemView extends android.widget.FrameLayout {
    com.up366.mobile.user.setting.clearcache.CacheInfo mCacheInfo;
    private android.widget.TextView mCacheSizeTv;
    android.widget.ImageView mCheckRdio;
    com.up366.mobile.common.views.ClearCacheBookItemView mCourseBookExternalItemView;

    public ClearCacheBigItemView(android.content.Context context) {
        this(context, null);
    }

    public ClearCacheBigItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClearCacheBigItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        android.view.View viewInflate = android.view.View.inflate(getContext(), com.up366.mobile.R.layout.clear_cache_big_item, this);
        this.mCheckRdio = (android.widget.ImageView) viewInflate.findViewById(com.up366.mobile.R.id.clear_cache_big_item_check_radio);
        this.mCourseBookExternalItemView = (com.up366.mobile.common.views.ClearCacheBookItemView) viewInflate.findViewById(com.up366.mobile.R.id.clear_cache_big_item_book_info);
        this.mCacheSizeTv = (android.widget.TextView) viewInflate.findViewById(com.up366.mobile.R.id.tv_cache_size);
        findViewById(com.up366.mobile.R.id.clear_cache_big_item_content).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.setting.clearcache.ClearCacheBigItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$initView$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(android.view.View view) {
        if (this.mCacheInfo.isSelected()) {
            this.mCheckRdio.setImageResource(com.up366.mobile.R.drawable.icon_selected_no);
            this.mCacheInfo.setSelected(false);
        } else {
            this.mCheckRdio.setImageResource(com.up366.mobile.R.drawable.icon_selected);
            this.mCacheInfo.setSelected(true);
        }
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.user.setting.clearcache.CacheSelectEvent(this.mCacheInfo));
    }

    protected void setData(com.up366.mobile.user.setting.clearcache.CacheInfo cacheInfo) {
        if (cacheInfo.isSelected()) {
            this.mCheckRdio.setImageResource(com.up366.mobile.R.drawable.icon_selected);
        } else {
            this.mCheckRdio.setImageResource(com.up366.mobile.R.drawable.icon_selected_no);
        }
        this.mCourseBookExternalItemView.setCacheInfo(cacheInfo);
        this.mCacheSizeTv.setText(com.up366.common.ByteUtilsUp.bytesToMKB(cacheInfo.getCacheSize()));
        this.mCacheInfo = cacheInfo;
    }
}
