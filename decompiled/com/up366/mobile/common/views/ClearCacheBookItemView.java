package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ClearCacheBookItemView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.ClearCacheBookItemViewBinding binding;

    public ClearCacheBookItemView(android.content.Context context) {
        super(context);
        init();
    }

    public ClearCacheBookItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ClearCacheBookItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        if (isInEditMode()) {
            android.view.View.inflate(getContext(), com.up366.mobile.R.layout.clear_cache_book_item_view, this);
        } else {
            this.binding = (com.up366.mobile.databinding.ClearCacheBookItemViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.clear_cache_book_item_view, this, true);
            setBackgroundResource(2131100561);
        }
    }

    public com.up366.mobile.databinding.ClearCacheBookItemViewBinding getBinding() {
        return this.binding;
    }

    public void setCacheInfo(com.up366.mobile.user.setting.clearcache.CacheInfo cacheInfo) {
        this.binding.bookName.setText(cacheInfo.getBookName());
        com.up366.common.BitmapUtilsUp.display(this.binding.bookPicture, cacheInfo.getBookPicUrl(), com.up366.mobile.R.drawable.default_book_picture);
        setBackground(null);
        setForeground(null);
    }
}
