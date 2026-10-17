package com.up366.medialibrary.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureAlbumDirectoryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.up366.medialibrary.activity.PictureAlbumDirectoryAdapter.ViewHolder> {
    private int chooseMode;
    private java.util.List<com.up366.medialibrary.model.LocalMediaFolder> folders = new java.util.ArrayList();
    private com.up366.medialibrary.listener.OnAlbumItemClickListener onAlbumItemClickListener;

    public PictureAlbumDirectoryAdapter(com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig) {
        this.chooseMode = pictureSelectionConfig.chooseMode;
    }

    public void bindFolderData(java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) {
        this.folders = list;
        notifyDataSetChanged();
    }

    public void setChooseMode(int i) {
        this.chooseMode = i;
    }

    public java.util.List<com.up366.medialibrary.model.LocalMediaFolder> getFolderData() {
        return this.folders;
    }

    public com.up366.medialibrary.activity.PictureAlbumDirectoryAdapter.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.up366.medialibrary.activity.PictureAlbumDirectoryAdapter.ViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.up366.medialibrary.R.layout.picture_album_folder_item, viewGroup, false));
    }

    public void onBindViewHolder(com.up366.medialibrary.activity.PictureAlbumDirectoryAdapter.ViewHolder viewHolder, final int i) {
        final com.up366.medialibrary.model.LocalMediaFolder localMediaFolder = this.folders.get(i);
        java.lang.String name = localMediaFolder.getName();
        int imageNum = localMediaFolder.getImageNum();
        java.lang.String firstImagePath = localMediaFolder.getFirstImagePath();
        boolean zIsChecked = localMediaFolder.isChecked();
        viewHolder.tvSign.setVisibility(localMediaFolder.getCheckedNum() > 0 ? 0 : 4);
        viewHolder.itemView.setSelected(zIsChecked);
        if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_album_backgroundStyle != 0) {
                viewHolder.itemView.setBackgroundResource(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_album_backgroundStyle);
            }
        } else if (com.up366.medialibrary.config.PictureSelectionConfig.style != null && com.up366.medialibrary.config.PictureSelectionConfig.style.pictureAlbumStyle != 0) {
            viewHolder.itemView.setBackgroundResource(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureAlbumStyle);
        }
        if (this.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio()) {
            viewHolder.ivFirstImage.setImageResource(com.up366.medialibrary.R.drawable.picture_audio_placeholder);
        } else if (com.up366.medialibrary.config.PictureSelectionConfig.imageEngine != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.imageEngine.loadFolderImage(viewHolder.itemView.getContext(), firstImagePath, viewHolder.ivFirstImage);
        }
        android.content.Context context = viewHolder.itemView.getContext();
        if (localMediaFolder.getOfAllType() != -1) {
            if (localMediaFolder.getOfAllType() == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio()) {
                name = context.getString(com.up366.medialibrary.R.string.picture_all_audio);
            } else {
                name = context.getString(com.up366.medialibrary.R.string.picture_camera_roll);
            }
        }
        viewHolder.tvFolderName.setText(context.getString(com.up366.medialibrary.R.string.picture_camera_roll_num, name, java.lang.Integer.valueOf(imageNum)));
        viewHolder.itemView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureAlbumDirectoryAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m143x9960848a(localMediaFolder, i, view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$0$com-up366-medialibrary-activity-PictureAlbumDirectoryAdapter, reason: not valid java name */
    /* synthetic */ void m143x9960848a(com.up366.medialibrary.model.LocalMediaFolder localMediaFolder, int i, android.view.View view) {
        if (this.onAlbumItemClickListener != null) {
            int size = this.folders.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.folders.get(i2).setChecked(false);
            }
            localMediaFolder.setChecked(true);
            notifyDataSetChanged();
            this.onAlbumItemClickListener.onItemClick(i, localMediaFolder.isCameraFolder(), localMediaFolder.getBucketId(), localMediaFolder.getName(), localMediaFolder.getData());
        }
    }

    public int getItemCount() {
        return this.folders.size();
    }

    static class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.ImageView ivFirstImage;
        android.widget.TextView tvFolderName;
        android.widget.TextView tvSign;

        public ViewHolder(android.view.View view) {
            super(view);
            this.ivFirstImage = (android.widget.ImageView) view.findViewById(com.up366.medialibrary.R.id.first_image);
            this.tvFolderName = (android.widget.TextView) view.findViewById(com.up366.medialibrary.R.id.tv_folder_name);
            this.tvSign = (android.widget.TextView) view.findViewById(com.up366.medialibrary.R.id.tv_sign);
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_album_checkDotStyle != 0) {
                    this.tvSign.setBackgroundResource(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_album_checkDotStyle);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_album_textColor != 0) {
                    this.tvFolderName.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_album_textColor);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_album_textSize > 0) {
                    this.tvFolderName.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_album_textSize);
                    return;
                }
                return;
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureFolderCheckedDotStyle != 0) {
                    this.tvSign.setBackgroundResource(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureFolderCheckedDotStyle);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.folderTextColor != 0) {
                    this.tvFolderName.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.style.folderTextColor);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.folderTextSize > 0) {
                    this.tvFolderName.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.style.folderTextSize);
                    return;
                }
                return;
            }
            this.tvSign.setBackground(com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueDrawable(view.getContext(), com.up366.medialibrary.R.attr.picture_folder_checked_dot, com.up366.medialibrary.R.drawable.picture_orange_oval));
            int typeValueColor = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueColor(view.getContext(), com.up366.medialibrary.R.attr.picture_folder_textColor);
            if (typeValueColor != 0) {
                this.tvFolderName.setTextColor(typeValueColor);
            }
            float typeValueSize = com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueSize(view.getContext(), com.up366.medialibrary.R.attr.picture_folder_textSize);
            if (typeValueSize > 0.0f) {
                this.tvFolderName.setTextSize(0, typeValueSize);
            }
        }
    }

    public void setOnAlbumItemClickListener(com.up366.medialibrary.listener.OnAlbumItemClickListener onAlbumItemClickListener) {
        this.onAlbumItemClickListener = onAlbumItemClickListener;
    }
}
