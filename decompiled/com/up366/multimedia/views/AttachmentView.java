package com.up366.multimedia.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AttachmentView extends androidx.recyclerview.widget.RecyclerView {
    private com.up366.multimedia.views.AttachmentAdapter adpter;
    private int attTextSize;
    private int dividerHeight;

    public AttachmentView(android.content.Context context) {
        super(context);
        this.dividerHeight = com.up366.common.DpUtilsUp.dp2px(5.0f);
        this.attTextSize = 14;
        init(context, null);
    }

    public AttachmentView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        this.dividerHeight = com.up366.common.DpUtilsUp.dp2px(5.0f);
        this.attTextSize = 14;
        init(context, attrs);
    }

    public AttachmentView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.dividerHeight = com.up366.common.DpUtilsUp.dp2px(5.0f);
        this.attTextSize = 14;
        init(context, attrs);
    }

    private void init(final android.content.Context context, android.util.AttributeSet attrs) {
        setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(context));
        if (attrs != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, com.afollestad.materialcamera.R.styleable.AttachmentView);
            this.dividerHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.afollestad.materialcamera.R.styleable.AttachmentView_attachmentPictureDividerHeight, com.up366.multimedia.util.PxUtils.dp2px(context, 5.0f));
            this.attTextSize = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.afollestad.materialcamera.R.styleable.AttachmentView_attachmentNameTextSize, 14);
            typedArrayObtainStyledAttributes.recycle();
        }
        com.up366.multimedia.views.AttachmentAdapter attachmentAdapter = new com.up366.multimedia.views.AttachmentAdapter();
        this.adpter = attachmentAdapter;
        attachmentAdapter.setAttrs(this.dividerHeight, this.attTextSize);
        setAdapter(this.adpter);
    }

    public void setData(java.util.List<com.up366.multimedia.model.MediaAttachInfo> infos) {
        this.adpter.setDatas(com.up366.multimedia.util.DataHolderUtils.convertToMediaDataHolder(infos));
    }
}
