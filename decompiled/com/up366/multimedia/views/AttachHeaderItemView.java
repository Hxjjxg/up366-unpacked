package com.up366.multimedia.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class AttachHeaderItemView extends android.widget.LinearLayout {
    public AttachHeaderItemView(android.content.Context context) {
        super(context);
        initView(context);
    }

    public AttachHeaderItemView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public AttachHeaderItemView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(android.content.Context context) {
        android.view.LayoutInflater.from(context).inflate(com.afollestad.materialcamera.R.layout.media_attachment_title_item, this);
        setBackgroundResource(com.afollestad.materialcamera.R.drawable.attachment_top_bg);
    }
}
