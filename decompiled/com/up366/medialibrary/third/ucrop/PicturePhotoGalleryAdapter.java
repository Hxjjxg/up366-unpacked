package com.up366.medialibrary.third.ucrop;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PicturePhotoGalleryAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter.ViewHolder> {
    private final java.util.List<com.up366.medialibrary.model.LocalMedia> list;
    private com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int i, android.view.View view);
    }

    public PicturePhotoGalleryAdapter(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        this.list = list;
    }

    public com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return new com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter.ViewHolder(android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.up366.medialibrary.R.layout.ucrop_picture_gf_adapter_edit_list, viewGroup, false));
    }

    public void onBindViewHolder(final com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter.ViewHolder viewHolder, int i) {
        com.up366.medialibrary.model.LocalMedia localMedia = this.list.get(i);
        java.lang.String path = localMedia.getPath();
        if (localMedia.isCut()) {
            viewHolder.iv_dot.setVisibility(0);
            viewHolder.iv_dot.setImageResource(com.up366.medialibrary.R.drawable.ucrop_oval_true);
        } else {
            viewHolder.iv_dot.setVisibility(4);
        }
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(localMedia.getMimeType())) {
            viewHolder.mIvPhoto.setVisibility(8);
            viewHolder.mIvVideo.setVisibility(0);
            viewHolder.mIvVideo.setImageResource(com.up366.medialibrary.R.drawable.ucrop_ic_default_video);
        } else {
            viewHolder.mIvPhoto.setVisibility(0);
            viewHolder.mIvVideo.setVisibility(8);
            viewHolder.tvGif.setVisibility(com.up366.medialibrary.common.utils.MimeTypeUtils.isGif(localMedia.getMimeType()) ? 0 : 8);
            if (com.up366.medialibrary.config.PictureSelectionConfig.imageEngine != null) {
                com.up366.medialibrary.config.PictureSelectionConfig.imageEngine.loadGridImage(viewHolder.itemView.getContext(), path, viewHolder.mIvPhoto);
            }
            viewHolder.itemView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    if (com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter.this.listener != null) {
                        com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter.this.listener.onItemClick(viewHolder.getAbsoluteAdapterPosition(), view);
                    }
                }
            });
        }
    }

    public int getItemCount() {
        java.util.List<com.up366.medialibrary.model.LocalMedia> list = this.list;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.ImageView iv_dot;
        android.widget.ImageView mIvPhoto;
        android.widget.ImageView mIvVideo;
        android.widget.TextView tvGif;

        public ViewHolder(android.view.View view) {
            super(view);
            this.mIvPhoto = (android.widget.ImageView) view.findViewById(com.up366.medialibrary.R.id.iv_photo);
            this.mIvVideo = (android.widget.ImageView) view.findViewById(com.up366.medialibrary.R.id.iv_video);
            this.iv_dot = (android.widget.ImageView) view.findViewById(com.up366.medialibrary.R.id.iv_dot);
            this.tvGif = (android.widget.TextView) view.findViewById(com.up366.medialibrary.R.id.tv_gif);
        }
    }

    public void setOnItemClickListener(com.up366.medialibrary.third.ucrop.PicturePhotoGalleryAdapter.OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }
}
