package com.up366.multimedia.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AttachItemView extends android.widget.LinearLayout {
    static final java.util.Map<java.lang.String, java.lang.Integer> ATT_MAP;
    private android.view.View attItemLine;
    private android.widget.TextView attSizeView;
    private com.up366.multimedia.model.MediaAttachInfo attachInfo;
    private android.widget.TextView fileNameView;
    private android.widget.ImageView iconView;
    private int nameTextSize;
    private android.view.View rootView;

    public AttachItemView(android.content.Context context) {
        super(context);
        init(context, null);
    }

    public AttachItemView(android.content.Context context, android.util.AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AttachItemView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(final android.content.Context context, android.util.AttributeSet attrs) {
        android.view.View viewInflate = android.view.LayoutInflater.from(context).inflate(com.afollestad.materialcamera.R.layout.media_attachment_item, this);
        this.rootView = viewInflate;
        this.iconView = (android.widget.ImageView) viewInflate.findViewById(com.afollestad.materialcamera.R.id.att_icon);
        this.fileNameView = (android.widget.TextView) this.rootView.findViewById(com.afollestad.materialcamera.R.id.att_filename);
        this.attSizeView = (android.widget.TextView) this.rootView.findViewById(com.afollestad.materialcamera.R.id.att_size);
        this.attItemLine = this.rootView.findViewById(com.afollestad.materialcamera.R.id.att_item_line);
        this.rootView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimedia.views.AttachItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View v) {
                if (!com.up366.common.NetworkUtilsUp.isConnected()) {
                    android.widget.Toast.makeText(v.getContext(), "请先连接网络！", 1).show();
                    return;
                }
                int i = com.afollestad.materialcamera.R.drawable.att_mp3;
                com.up366.multimedia.views.AttachItemView attachItemView = com.up366.multimedia.views.AttachItemView.this;
                if (i == attachItemView.getImageId(attachItemView.attachInfo)) {
                    android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.multimedia.activity.AudioPreviewActivity.class);
                    intent.putExtra("attachInfo", com.up366.multimedia.views.AttachItemView.this.attachInfo);
                    context.startActivity(intent);
                } else {
                    android.content.Intent intent2 = new android.content.Intent(context, (java.lang.Class<?>) com.up366.multimedia.activity.AttachPreviewActivity.class);
                    intent2.putExtra("title", com.up366.multimedia.views.AttachItemView.this.attachInfo.getName());
                    intent2.putExtra("previewUrl", com.up366.multimedia.views.AttachItemView.this.attachInfo.getViewUrl());
                    context.startActivity(intent2);
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLayoutParams().width = -1;
        requestLayout();
    }

    public void setData(com.up366.multimedia.model.MediaAttachInfo attachInfo, boolean isFirst, boolean isLast) {
        this.attachInfo = attachInfo;
        this.fileNameView.setTextSize(this.nameTextSize);
        this.fileNameView.setCompoundDrawables(null, null, null, null);
        this.iconView.setVisibility(0);
        this.attItemLine.setVisibility(0);
        if (isLast) {
            setBackgroundResource(com.afollestad.materialcamera.R.drawable.attachment_bottom_bg);
            this.attItemLine.setVisibility(4);
        } else {
            setBackgroundResource(com.afollestad.materialcamera.R.drawable.attachment_midden_bg);
        }
        com.up366.common.BitmapUtilsUp.display(this.iconView, getImageId(attachInfo));
        this.fileNameView.setText(attachInfo.getName());
        this.attSizeView.setText(com.up366.common.ByteUtilsUp.bytesToMKB(attachInfo.getSize()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getImageId(com.up366.multimedia.model.MediaAttachInfo attachInfo) {
        java.lang.String ext = attachInfo.getExt();
        if (!com.up366.common.StringUtils.isEmptyOrNull(ext)) {
            ext = ext.toLowerCase();
        }
        java.util.Map<java.lang.String, java.lang.Integer> map = ATT_MAP;
        if (map.containsKey(ext)) {
            return map.get(ext).intValue();
        }
        return com.afollestad.materialcamera.R.drawable.att_common;
    }

    static {
        java.util.HashMap map = new java.util.HashMap();
        ATT_MAP = map;
        map.put("docx", java.lang.Integer.valueOf(com.afollestad.materialcamera.R.drawable.att_docx));
        map.put("mp3", java.lang.Integer.valueOf(com.afollestad.materialcamera.R.drawable.att_mp3));
        map.put("pdf", java.lang.Integer.valueOf(com.afollestad.materialcamera.R.drawable.att_pdf));
        map.put("ppt", java.lang.Integer.valueOf(com.afollestad.materialcamera.R.drawable.att_ppt));
        map.put("pptx", java.lang.Integer.valueOf(com.afollestad.materialcamera.R.drawable.att_ppt));
        map.put("txt", java.lang.Integer.valueOf(com.afollestad.materialcamera.R.drawable.att_txt));
        map.put("wav", java.lang.Integer.valueOf(com.afollestad.materialcamera.R.drawable.att_mp3));
        map.put("xls", java.lang.Integer.valueOf(com.afollestad.materialcamera.R.drawable.att_xlsx));
        map.put("xlsx", java.lang.Integer.valueOf(com.afollestad.materialcamera.R.drawable.att_xlsx));
        map.put("zip", java.lang.Integer.valueOf(com.afollestad.materialcamera.R.drawable.att_zip));
        map.put("rar", java.lang.Integer.valueOf(com.afollestad.materialcamera.R.drawable.att_zip));
    }

    public void setNameTextSize(int nameTextSize) {
        this.nameTextSize = nameTextSize;
    }
}
