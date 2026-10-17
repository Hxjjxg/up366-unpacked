package com.up366.medialibrary.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureImageGridAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private final com.up366.medialibrary.config.PictureSelectionConfig config;
    private final android.content.Context context;
    private com.up366.medialibrary.listener.OnPhotoSelectChangedListener<com.up366.medialibrary.model.LocalMedia> imageSelectChangedListener;
    private boolean showCamera;
    private java.util.List<com.up366.medialibrary.model.LocalMedia> data = new java.util.ArrayList();
    private java.util.List<com.up366.medialibrary.model.LocalMedia> selectData = new java.util.ArrayList();

    public PictureImageGridAdapter(android.content.Context context, com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig) {
        this.context = context;
        this.config = pictureSelectionConfig;
        this.showCamera = pictureSelectionConfig.isCamera;
    }

    public void setShowCamera(boolean z) {
        this.showCamera = z;
    }

    public boolean isShowCamera() {
        return this.showCamera;
    }

    public void bindData(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        if (list == null) {
            list = new java.util.ArrayList<>();
        }
        this.data = list;
        notifyDataSetChanged();
    }

    public void bindSelectData(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i));
        }
        this.selectData = arrayList;
        if (this.config.isSingleDirectReturn) {
            return;
        }
        subSelectPosition();
        com.up366.medialibrary.listener.OnPhotoSelectChangedListener<com.up366.medialibrary.model.LocalMedia> onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener != null) {
            onPhotoSelectChangedListener.onChange(this.selectData);
        }
    }

    public java.util.List<com.up366.medialibrary.model.LocalMedia> getSelectedData() {
        java.util.List<com.up366.medialibrary.model.LocalMedia> list = this.selectData;
        return list == null ? new java.util.ArrayList() : list;
    }

    public int getSelectedSize() {
        java.util.List<com.up366.medialibrary.model.LocalMedia> list = this.selectData;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public java.util.List<com.up366.medialibrary.model.LocalMedia> getData() {
        java.util.List<com.up366.medialibrary.model.LocalMedia> list = this.data;
        return list == null ? new java.util.ArrayList() : list;
    }

    public boolean isDataEmpty() {
        java.util.List<com.up366.medialibrary.model.LocalMedia> list = this.data;
        return list == null || list.size() == 0;
    }

    public void clear() {
        if (getSize() > 0) {
            this.data.clear();
        }
    }

    public int getSize() {
        java.util.List<com.up366.medialibrary.model.LocalMedia> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public com.up366.medialibrary.model.LocalMedia getItem(int i) {
        if (getSize() > 0) {
            return this.data.get(i);
        }
        return null;
    }

    public int getItemViewType(int i) {
        return (this.showCamera && i == 0) ? 1 : 2;
    }

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new com.up366.medialibrary.activity.PictureImageGridAdapter.CameraViewHolder(android.view.LayoutInflater.from(this.context).inflate(com.up366.medialibrary.R.layout.picture_item_camera, viewGroup, false));
        }
        return new com.up366.medialibrary.activity.PictureImageGridAdapter.ViewHolder(android.view.LayoutInflater.from(this.context).inflate(com.up366.medialibrary.R.layout.picture_image_grid_item, viewGroup, false));
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, final int i) {
        android.content.Context context;
        int i2;
        if (getItemViewType(i) == 1) {
            ((com.up366.medialibrary.activity.PictureImageGridAdapter.CameraViewHolder) viewHolder).itemView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureImageGridAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.m154x35547155(view);
                }
            });
            return;
        }
        final com.up366.medialibrary.activity.PictureImageGridAdapter.ViewHolder viewHolder2 = (com.up366.medialibrary.activity.PictureImageGridAdapter.ViewHolder) viewHolder;
        final com.up366.medialibrary.model.LocalMedia localMedia = this.data.get(this.showCamera ? i - 1 : i);
        localMedia.position = viewHolder2.getAbsoluteAdapterPosition();
        final java.lang.String mimeType = localMedia.getMimeType();
        if (this.config.checkNumMode) {
            notifyCheckChanged(viewHolder2, localMedia);
        }
        if (this.config.isSingleDirectReturn) {
            viewHolder2.tvCheck.setVisibility(8);
            viewHolder2.btnCheck.setVisibility(8);
        } else {
            selectImage(viewHolder2, isSelected(localMedia));
            viewHolder2.tvCheck.setVisibility(0);
            viewHolder2.btnCheck.setVisibility(0);
            if (this.config.isMaxSelectEnabledMask) {
                dispatchHandleMask(viewHolder2, localMedia);
            }
        }
        java.lang.String path = localMedia.getPath();
        if (localMedia.isEditorImage() && !android.text.TextUtils.isEmpty(localMedia.getCutPath())) {
            viewHolder2.ivEditor.setVisibility(0);
            path = localMedia.getCutPath();
        } else {
            viewHolder2.ivEditor.setVisibility(8);
        }
        boolean zIsGif = com.up366.medialibrary.common.utils.MimeTypeUtils.isGif(mimeType);
        boolean zIsWebp = com.up366.medialibrary.common.utils.MimeTypeUtils.isWebp(mimeType);
        boolean zIsLongImg = com.up366.medialibrary.common.utils.MediaUtils.isLongImg(localMedia);
        if ((zIsGif || zIsWebp) && !zIsLongImg) {
            viewHolder2.tvImageMimeType.setVisibility(0);
            android.widget.TextView textView = viewHolder2.tvImageMimeType;
            if (zIsGif) {
                context = this.context;
                i2 = com.up366.medialibrary.R.string.picture_gif_tag;
            } else {
                context = this.context;
                i2 = com.up366.medialibrary.R.string.picture_webp_tag;
            }
            textView.setText(context.getString(i2));
        } else {
            viewHolder2.tvImageMimeType.setVisibility(8);
        }
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia.getMimeType())) {
            if (localMedia.loadLongImageStatus == -1) {
                localMedia.isLongImage = zIsLongImg;
                localMedia.loadLongImageStatus = 0;
            }
            viewHolder2.tvLongChart.setVisibility(localMedia.isLongImage ? 0 : 8);
        } else {
            localMedia.loadLongImageStatus = -1;
            viewHolder2.tvLongChart.setVisibility(8);
        }
        boolean zIsVideo = com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(mimeType);
        if (zIsVideo || com.up366.medialibrary.common.utils.MimeTypeUtils.isHasAudio(mimeType)) {
            viewHolder2.tvDurationLayout.setVisibility(0);
            viewHolder2.tvDuration.setText(com.up366.medialibrary.common.utils.DateUtils.formatDurationTime(localMedia.getDuration()));
            viewHolder2.tvDurationImg.setImageResource(zIsVideo ? com.up366.medialibrary.R.drawable.picture_icon_video : com.up366.medialibrary.R.drawable.picture_icon_audio);
        } else {
            viewHolder2.tvDurationLayout.setVisibility(8);
        }
        if (this.config.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio()) {
            viewHolder2.ivPicture.setImageResource(com.up366.medialibrary.R.drawable.picture_audio_placeholder);
        } else if (com.up366.medialibrary.config.PictureSelectionConfig.imageEngine != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.imageEngine.loadGridImage(this.context, path, viewHolder2.ivPicture);
        }
        if (this.config.enablePreview || this.config.enPreviewVideo || this.config.enablePreviewAudio) {
            viewHolder2.btnCheck.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureImageGridAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.m155x5ae87a56(localMedia, viewHolder2, mimeType, view);
                }
            });
        }
        viewHolder2.contentView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureImageGridAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m156x807c8357(localMedia, mimeType, i, viewHolder2, view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$0$com-up366-medialibrary-activity-PictureImageGridAdapter, reason: not valid java name */
    /* synthetic */ void m154x35547155(android.view.View view) {
        com.up366.medialibrary.listener.OnPhotoSelectChangedListener<com.up366.medialibrary.model.LocalMedia> onPhotoSelectChangedListener = this.imageSelectChangedListener;
        if (onPhotoSelectChangedListener != null) {
            onPhotoSelectChangedListener.onTakePhoto();
        }
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$1$com-up366-medialibrary-activity-PictureImageGridAdapter, reason: not valid java name */
    /* synthetic */ void m155x5ae87a56(com.up366.medialibrary.model.LocalMedia localMedia, com.up366.medialibrary.activity.PictureImageGridAdapter.ViewHolder viewHolder, java.lang.String str, android.view.View view) {
        java.lang.String msg;
        if (this.config.isMaxSelectEnabledMask) {
            if (this.config.isWithVideoImage) {
                int selectedSize = getSelectedSize();
                boolean z = false;
                int i = 0;
                for (int i2 = 0; i2 < selectedSize; i2++) {
                    if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(this.selectData.get(i2).getMimeType())) {
                        i++;
                    }
                }
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(localMedia.getMimeType())) {
                    if (!viewHolder.tvCheck.isSelected() && i >= this.config.maxVideoSelectNum) {
                        z = true;
                    }
                    msg = com.up366.medialibrary.common.utils.StringUtils.getMsg(this.context, localMedia.getMimeType(), this.config.maxVideoSelectNum);
                } else {
                    if (!viewHolder.tvCheck.isSelected() && selectedSize >= this.config.maxSelectNum) {
                        z = true;
                    }
                    msg = com.up366.medialibrary.common.utils.StringUtils.getMsg(this.context, localMedia.getMimeType(), this.config.maxSelectNum);
                }
                if (z) {
                    showPromptDialog(msg);
                    return;
                }
            } else if (!viewHolder.tvCheck.isSelected() && getSelectedSize() >= this.config.maxSelectNum) {
                showPromptDialog(com.up366.medialibrary.common.utils.StringUtils.getMsg(this.context, localMedia.getMimeType(), this.config.maxSelectNum));
                return;
            }
        }
        java.lang.String realPath = localMedia.getRealPath();
        if (!android.text.TextUtils.isEmpty(realPath) && !new java.io.File(realPath).exists()) {
            android.content.Context context = this.context;
            com.up366.medialibrary.common.utils.ToastUtils.s(context, com.up366.medialibrary.common.utils.MimeTypeUtils.s(context, str));
        } else {
            changeCheckboxState(viewHolder, localMedia);
        }
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$2$com-up366-medialibrary-activity-PictureImageGridAdapter, reason: not valid java name */
    /* synthetic */ void m156x807c8357(com.up366.medialibrary.model.LocalMedia localMedia, java.lang.String str, int i, com.up366.medialibrary.activity.PictureImageGridAdapter.ViewHolder viewHolder, android.view.View view) {
        if (this.config.isMaxSelectEnabledMask && localMedia.isMaxSelectEnabledMask()) {
            return;
        }
        java.lang.String realPath = localMedia.getRealPath();
        if (!android.text.TextUtils.isEmpty(realPath) && !new java.io.File(realPath).exists()) {
            android.content.Context context = this.context;
            com.up366.medialibrary.common.utils.ToastUtils.s(context, com.up366.medialibrary.common.utils.MimeTypeUtils.s(context, str));
            return;
        }
        if (this.showCamera) {
            i--;
        }
        if (i == -1) {
            return;
        }
        if ((com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(str) && this.config.enablePreview) || this.config.isSingleDirectReturn || ((com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(str) && (this.config.enPreviewVideo || this.config.selectionMode == 1)) || (com.up366.medialibrary.common.utils.MimeTypeUtils.isHasAudio(str) && (this.config.enablePreviewAudio || this.config.selectionMode == 1)))) {
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(localMedia.getMimeType())) {
                if (this.config.videoMinSecond > 0 && localMedia.getDuration() < this.config.videoMinSecond) {
                    showPromptDialog(this.context.getString(com.up366.medialibrary.R.string.picture_choose_min_seconds, java.lang.Integer.valueOf(this.config.videoMinSecond / 1000)));
                    return;
                } else if (this.config.videoMaxSecond > 0 && localMedia.getDuration() > this.config.videoMaxSecond) {
                    showPromptDialog(this.context.getString(com.up366.medialibrary.R.string.picture_choose_max_seconds, java.lang.Integer.valueOf(this.config.videoMaxSecond / 1000)));
                    return;
                }
            }
            this.imageSelectChangedListener.onPictureClick(localMedia, i);
            return;
        }
        changeCheckboxState(viewHolder, localMedia);
    }

    private void dispatchHandleMask(com.up366.medialibrary.activity.PictureImageGridAdapter.ViewHolder viewHolder, com.up366.medialibrary.model.LocalMedia localMedia) {
        int color;
        if (this.config.isWithVideoImage && this.config.maxVideoSelectNum > 0) {
            if (getSelectedSize() >= this.config.maxSelectNum) {
                boolean zIsSelected = viewHolder.tvCheck.isSelected();
                if (zIsSelected) {
                    color = androidx.core.content.ContextCompat.getColor(this.context, com.up366.medialibrary.R.color.picture_color_00);
                } else {
                    color = androidx.core.content.ContextCompat.getColor(this.context, com.up366.medialibrary.R.color.picture_color_80);
                }
                viewHolder.ivPicture.setColorFilter(androidx.core.graphics.BlendModeColorFilterCompat.createBlendModeColorFilterCompat(color, androidx.core.graphics.BlendModeCompat.SRC_ATOP));
                localMedia.setMaxSelectEnabledMask(!zIsSelected);
                return;
            }
            localMedia.setMaxSelectEnabledMask(false);
            return;
        }
        com.up366.medialibrary.model.LocalMedia localMedia2 = this.selectData.size() > 0 ? this.selectData.get(0) : null;
        if (localMedia2 != null) {
            boolean zIsSelected2 = viewHolder.tvCheck.isSelected();
            if (this.config.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAll()) {
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia2.getMimeType())) {
                    if (!zIsSelected2 && !com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia.getMimeType())) {
                        viewHolder.ivPicture.setColorFilter(androidx.core.graphics.BlendModeColorFilterCompat.createBlendModeColorFilterCompat(androidx.core.content.ContextCompat.getColor(this.context, com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(localMedia.getMimeType()) ? com.up366.medialibrary.R.color.picture_color_half_white : com.up366.medialibrary.R.color.picture_color_20), androidx.core.graphics.BlendModeCompat.SRC_ATOP));
                    }
                    localMedia.setMaxSelectEnabledMask(com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(localMedia.getMimeType()));
                    return;
                }
                if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(localMedia2.getMimeType())) {
                    if (!zIsSelected2 && !com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(localMedia.getMimeType())) {
                        viewHolder.ivPicture.setColorFilter(androidx.core.graphics.BlendModeColorFilterCompat.createBlendModeColorFilterCompat(androidx.core.content.ContextCompat.getColor(this.context, com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia.getMimeType()) ? com.up366.medialibrary.R.color.picture_color_half_white : com.up366.medialibrary.R.color.picture_color_20), androidx.core.graphics.BlendModeCompat.SRC_ATOP));
                    }
                    localMedia.setMaxSelectEnabledMask(com.up366.medialibrary.common.utils.MimeTypeUtils.isImage(localMedia.getMimeType()));
                    return;
                }
                return;
            }
            if (this.config.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofVideo() && this.config.maxVideoSelectNum > 0) {
                if (!zIsSelected2 && getSelectedSize() == this.config.maxVideoSelectNum) {
                    viewHolder.ivPicture.setColorFilter(androidx.core.graphics.BlendModeColorFilterCompat.createBlendModeColorFilterCompat(androidx.core.content.ContextCompat.getColor(this.context, com.up366.medialibrary.R.color.picture_color_half_white), androidx.core.graphics.BlendModeCompat.SRC_ATOP));
                }
                localMedia.setMaxSelectEnabledMask(!zIsSelected2 && getSelectedSize() == this.config.maxVideoSelectNum);
                return;
            }
            if (!zIsSelected2 && getSelectedSize() == this.config.maxSelectNum) {
                viewHolder.ivPicture.setColorFilter(androidx.core.graphics.BlendModeColorFilterCompat.createBlendModeColorFilterCompat(androidx.core.content.ContextCompat.getColor(this.context, com.up366.medialibrary.R.color.picture_color_half_white), androidx.core.graphics.BlendModeCompat.SRC_ATOP));
            }
            localMedia.setMaxSelectEnabledMask(!zIsSelected2 && getSelectedSize() == this.config.maxSelectNum);
            return;
        }
        localMedia.setMaxSelectEnabledMask(false);
    }

    public int getItemCount() {
        return this.showCamera ? this.data.size() + 1 : this.data.size();
    }

    public class CameraViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.widget.TextView tvCamera;

        public CameraViewHolder(android.view.View view) {
            super(view);
            this.tvCamera = (android.widget.TextView) view.findViewById(com.up366.medialibrary.R.id.tvCamera);
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_camera_backgroundColor != 0) {
                    view.setBackgroundColor(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_camera_backgroundColor);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textSize != 0) {
                    this.tvCamera.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textSize);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textColor != 0) {
                    this.tvCamera.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textColor);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_camera_text != 0) {
                    this.tvCamera.setText(view.getContext().getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_camera_text));
                } else {
                    this.tvCamera.setText(com.up366.medialibrary.activity.PictureImageGridAdapter.this.config.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio() ? com.up366.medialibrary.activity.PictureImageGridAdapter.this.context.getString(com.up366.medialibrary.R.string.picture_tape) : com.up366.medialibrary.activity.PictureImageGridAdapter.this.context.getString(com.up366.medialibrary.R.string.picture_take_picture));
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textTopDrawable != 0) {
                    this.tvCamera.setCompoundDrawablesWithIntrinsicBounds(0, com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_camera_textTopDrawable, 0, 0);
                    return;
                }
                return;
            }
            this.tvCamera.setText(com.up366.medialibrary.activity.PictureImageGridAdapter.this.config.chooseMode == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio() ? com.up366.medialibrary.activity.PictureImageGridAdapter.this.context.getString(com.up366.medialibrary.R.string.picture_tape) : com.up366.medialibrary.activity.PictureImageGridAdapter.this.context.getString(com.up366.medialibrary.R.string.picture_take_picture));
        }
    }

    public static class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        android.view.View btnCheck;
        android.view.View contentView;
        android.widget.ImageView ivEditor;
        android.widget.ImageView ivPicture;
        android.widget.TextView tvCheck;
        android.widget.TextView tvDuration;
        android.widget.ImageView tvDurationImg;
        android.view.View tvDurationLayout;
        android.widget.TextView tvImageMimeType;
        android.widget.TextView tvLongChart;

        public ViewHolder(android.view.View view) {
            super(view);
            this.contentView = view;
            this.ivPicture = (android.widget.ImageView) view.findViewById(com.up366.medialibrary.R.id.ivPicture);
            this.tvCheck = (android.widget.TextView) view.findViewById(com.up366.medialibrary.R.id.tvCheck);
            this.btnCheck = view.findViewById(com.up366.medialibrary.R.id.btnCheck);
            this.tvDuration = (android.widget.TextView) view.findViewById(com.up366.medialibrary.R.id.tv_duration);
            this.tvDurationLayout = view.findViewById(com.up366.medialibrary.R.id.tv_duration_layout);
            this.tvDurationImg = (android.widget.ImageView) view.findViewById(com.up366.medialibrary.R.id.tv_duration_img);
            this.tvImageMimeType = (android.widget.TextView) view.findViewById(com.up366.medialibrary.R.id.tv_image_mime_type);
            this.tvLongChart = (android.widget.TextView) view.findViewById(com.up366.medialibrary.R.id.tv_long_chart);
            this.ivEditor = (android.widget.ImageView) view.findViewById(com.up366.medialibrary.R.id.ivEditor);
            if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_check_style != 0) {
                    this.tvCheck.setBackgroundResource(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_check_style);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_check_textSize != 0) {
                    this.tvCheck.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_check_textSize);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_check_textColor != 0) {
                    this.tvCheck.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_check_textColor);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_textSize > 0) {
                    this.tvDuration.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_textSize);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_textColor != 0) {
                    this.tvDuration.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_textColor);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_tag_text != 0) {
                    this.tvImageMimeType.setText(view.getContext().getString(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_tag_text));
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_show) {
                    this.tvImageMimeType.setVisibility(0);
                } else {
                    this.tvImageMimeType.setVisibility(8);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_background != 0) {
                    this.tvImageMimeType.setBackgroundResource(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_background);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_editor_tag_icon != 0) {
                    this.ivEditor.setImageResource(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_editor_tag_icon);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_textColor != 0) {
                    this.tvImageMimeType.setTextColor(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_textColor);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_textSize != 0) {
                    this.tvImageMimeType.setTextSize(com.up366.medialibrary.config.PictureSelectionConfig.uiStyle.picture_adapter_item_gif_tag_textSize);
                    return;
                }
                return;
            }
            if (com.up366.medialibrary.config.PictureSelectionConfig.style != null) {
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCheckedStyle != 0) {
                    this.tvCheck.setBackgroundResource(com.up366.medialibrary.config.PictureSelectionConfig.style.pictureCheckedStyle);
                }
                if (com.up366.medialibrary.config.PictureSelectionConfig.style.picture_adapter_item_editor_tag_icon != 0) {
                    this.ivEditor.setImageResource(com.up366.medialibrary.config.PictureSelectionConfig.style.picture_adapter_item_editor_tag_icon);
                    return;
                }
                return;
            }
            this.tvCheck.setBackground(com.up366.medialibrary.common.utils.AttrsUtils.getTypeValueDrawable(view.getContext(), com.up366.medialibrary.R.attr.picture_checked_style, com.up366.medialibrary.R.drawable.picture_checkbox_selector));
        }
    }

    public boolean isSelected(com.up366.medialibrary.model.LocalMedia localMedia) {
        int size = this.selectData.size();
        for (int i = 0; i < size; i++) {
            com.up366.medialibrary.model.LocalMedia localMedia2 = this.selectData.get(i);
            if (localMedia2 != null && !android.text.TextUtils.isEmpty(localMedia2.getPath()) && (android.text.TextUtils.equals(localMedia2.getPath(), localMedia.getPath()) || localMedia2.getId() == localMedia.getId())) {
                setLocalMediaCropInfo(localMedia2, localMedia);
                return true;
            }
        }
        return false;
    }

    private void setLocalMediaCropInfo(com.up366.medialibrary.model.LocalMedia localMedia, com.up366.medialibrary.model.LocalMedia localMedia2) {
        if (!localMedia.isEditorImage() || localMedia2.isEditorImage()) {
            return;
        }
        localMedia2.setCut(localMedia.isCut());
        localMedia2.setCutPath(localMedia.getCutPath());
        localMedia2.setCropImageWidth(localMedia.getCropImageWidth());
        localMedia2.setCropImageHeight(localMedia.getCropImageHeight());
        localMedia2.setCropOffsetX(localMedia.getCropOffsetX());
        localMedia2.setCropOffsetY(localMedia.getCropOffsetY());
        localMedia2.setCropResultAspectRatio(localMedia.getCropResultAspectRatio());
        localMedia2.setAndroidQToPath(localMedia.getAndroidQToPath());
        localMedia2.setEditorImage(localMedia.isEditorImage());
    }

    private void notifyCheckChanged(com.up366.medialibrary.activity.PictureImageGridAdapter.ViewHolder viewHolder, com.up366.medialibrary.model.LocalMedia localMedia) {
        viewHolder.tvCheck.setText("");
        int size = this.selectData.size();
        for (int i = 0; i < size; i++) {
            com.up366.medialibrary.model.LocalMedia localMedia2 = this.selectData.get(i);
            if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                localMedia.setNum(localMedia2.getNum());
                localMedia2.setPosition(localMedia.getPosition());
                viewHolder.tvCheck.setText(com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Integer.valueOf(localMedia.getNum())));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x0337  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void changeCheckboxState(com.up366.medialibrary.activity.PictureImageGridAdapter.ViewHolder r11, com.up366.medialibrary.model.LocalMedia r12) {
        /*
            Method dump skipped, instruction units count: 852
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.medialibrary.activity.PictureImageGridAdapter.changeCheckboxState(com.up366.medialibrary.activity.PictureImageGridAdapter$ViewHolder, com.up366.medialibrary.model.LocalMedia):void");
    }

    private void singleRadioMediaImage() {
        java.util.List<com.up366.medialibrary.model.LocalMedia> list = this.selectData;
        if (list == null || list.size() <= 0) {
            return;
        }
        notifyItemChanged(this.selectData.get(0).position);
        this.selectData.clear();
    }

    private void subSelectPosition() {
        if (this.config.checkNumMode) {
            int size = this.selectData.size();
            int i = 0;
            while (i < size) {
                com.up366.medialibrary.model.LocalMedia localMedia = this.selectData.get(i);
                i++;
                localMedia.setNum(i);
                notifyItemChanged(localMedia.position);
            }
        }
    }

    public void selectImage(com.up366.medialibrary.activity.PictureImageGridAdapter.ViewHolder viewHolder, boolean z) {
        int color;
        viewHolder.tvCheck.setSelected(z);
        if (z) {
            color = androidx.core.content.ContextCompat.getColor(this.context, com.up366.medialibrary.R.color.picture_color_00);
        } else {
            color = androidx.core.content.ContextCompat.getColor(this.context, com.up366.medialibrary.R.color.picture_color_00);
        }
        viewHolder.ivPicture.setColorFilter(androidx.core.graphics.BlendModeColorFilterCompat.createBlendModeColorFilterCompat(color, androidx.core.graphics.BlendModeCompat.SRC_ATOP));
    }

    private void showPromptDialog(java.lang.String str) {
        if (com.up366.medialibrary.config.PictureSelectionConfig.onChooseLimitCallback != null) {
            com.up366.medialibrary.config.PictureSelectionConfig.onChooseLimitCallback.onChooseLimit(this.context, str);
            return;
        }
        final com.up366.medialibrary.common.dialog.PictureCustomDialog pictureCustomDialog = new com.up366.medialibrary.common.dialog.PictureCustomDialog(this.context, com.up366.medialibrary.R.layout.picture_prompt_dialog);
        android.widget.TextView textView = (android.widget.TextView) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.btnOk);
        ((android.widget.TextView) pictureCustomDialog.findViewById(com.up366.medialibrary.R.id.tv_content)).setText(str);
        textView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.activity.PictureImageGridAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                pictureCustomDialog.dismiss();
            }
        });
        pictureCustomDialog.show();
    }

    public void setOnPhotoSelectChangedListener(com.up366.medialibrary.listener.OnPhotoSelectChangedListener<com.up366.medialibrary.model.LocalMedia> onPhotoSelectChangedListener) {
        this.imageSelectChangedListener = onPhotoSelectChangedListener;
    }
}
