package com.up366.multimedia.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AttachPicVideoItemView extends android.widget.LinearLayout {
    private int dividerHeight;
    private com.up366.multimedia.views.PictureVideoGridView gridView;
    private android.view.View rootView;

    public AttachPicVideoItemView(android.content.Context context) {
        super(context);
        init(context, null);
    }

    public AttachPicVideoItemView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AttachPicVideoItemView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(final android.content.Context context, android.util.AttributeSet attrs) {
        android.view.View viewInflate = android.view.LayoutInflater.from(context).inflate(com.afollestad.materialcamera.R.layout.media_attachment_pic_video_item, this);
        this.rootView = viewInflate;
        com.up366.multimedia.views.PictureVideoGridView pictureVideoGridView = (com.up366.multimedia.views.PictureVideoGridView) viewInflate.findViewById(com.afollestad.materialcamera.R.id.pic_gridview);
        this.gridView = pictureVideoGridView;
        pictureVideoGridView.setAttachSubView(true);
    }

    public void setData(java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItems) {
        this.gridView.setDividerHeight(this.dividerHeight);
        this.gridView.setDatas(imageItems);
        this.gridView.setEditMode(false);
    }

    public void setDividerHeight(int dividerHeight) {
        this.dividerHeight = dividerHeight;
    }
}
