package com.up366.multimedia.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AlbumAdapter extends com.up366.multimedia.base.BaseAdapter<com.up366.multimedia.util.AlbumHelper.ImageItem> {
    private com.up366.multimedia.listener.OnDataUpdateListener listener;
    private volatile java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> selectItems = new java.util.ArrayList<>();
    private int maxSize = 9;
    private int windowWidth = 0;
    private int viewHeight = 0;

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        if (viewType == 1) {
            android.view.View viewInflate = inflate(parent, com.afollestad.materialcamera.R.layout.media_album_picture_item);
            if (this.windowWidth == 0) {
                this.windowWidth = parent.getContext().getResources().getDisplayMetrics().widthPixels;
            }
            if (this.viewHeight == 0) {
                this.viewHeight = (this.windowWidth - (com.up366.common.DpUtilsUp.dp2px(3.0f) * 3)) / 4;
            }
            viewInflate.getLayoutParams().height = this.viewHeight;
            return new com.up366.multimedia.base.BaseAdapter.BaseViewHolder(viewInflate);
        }
        android.view.View viewInflate2 = inflate(parent, com.afollestad.materialcamera.R.layout.media_album_nodata_item);
        viewInflate2.getLayoutParams().height = parent.getContext().getResources().getDisplayMetrics().heightPixels - com.up366.common.DpUtilsUp.dp2px(125.0f);
        viewInflate2.getLayoutParams().width = parent.getContext().getResources().getDisplayMetrics().widthPixels;
        return new com.up366.multimedia.base.BaseAdapter.BaseViewHolder(viewInflate2);
    }

    public void onBindViewHolder(final androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
        com.up366.multimedia.util.AlbumHelper.ImageItem next;
        if (this.datas.get(position).viewType == 3) {
            return;
        }
        android.widget.ImageView imageView = (android.widget.ImageView) holder.itemView.findViewById(com.afollestad.materialcamera.R.id.album_pic_image);
        final android.widget.ImageView imageView2 = (android.widget.ImageView) holder.itemView.findViewById(com.afollestad.materialcamera.R.id.album_pic_select_view);
        android.widget.ImageView imageView3 = (android.widget.ImageView) holder.itemView.findViewById(com.afollestad.materialcamera.R.id.preview_video_btn);
        final com.up366.multimedia.util.AlbumHelper.ImageItem curData = getCurData(position);
        if (this.maxSize == 1) {
            imageView2.setVisibility(8);
        } else {
            curData.isSelected = false;
            java.util.Iterator<com.up366.multimedia.util.AlbumHelper.ImageItem> it = this.selectItems.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.imagePath.equals(curData.imagePath) && next.videoPath.equals(curData.videoPath)) {
                    curData.isSelected = true;
                    break;
                }
            }
            if (next != null) {
                this.selectItems.remove(next);
                this.selectItems.add(curData);
            }
            imageView2.setImageResource(curData.isSelected ? com.afollestad.materialcamera.R.drawable.radio_selected : com.afollestad.materialcamera.R.drawable.radio_unslected);
        }
        if (!com.up366.common.StringUtils.isEmptyOrNull(curData.videoPath)) {
            imageView3.setVisibility(0);
            com.bumptech.glide.Glide.with(imageView.getContext()).load(android.net.Uri.fromFile(new java.io.File(curData.videoPath))).into(imageView);
        } else {
            imageView3.setVisibility(4);
            com.up366.common.log.Logger.info("image  uri " + curData.uri + "   " + curData.imagePath);
            if (curData.uri != null) {
                com.bumptech.glide.Glide.with(imageView).load(curData.uri).into(imageView);
            } else {
                com.up366.common.BitmapUtilsUp.display(imageView, curData.imagePath, com.afollestad.materialcamera.R.drawable.media_default);
            }
        }
        holder.itemView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimedia.activity.AlbumAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.m1325x3aad1ccb(holder, curData, imageView2, view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$0$com-up366-multimedia-activity-AlbumAdapter, reason: not valid java name */
    /* synthetic */ void m1325x3aad1ccb(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, com.up366.multimedia.util.AlbumHelper.ImageItem imageItem, android.widget.ImageView imageView, android.view.View view) {
        if (this.maxSize == 1) {
            viewHolder.itemView.setEnabled(false);
            handleItemClick(view, imageItem, imageView);
        } else {
            handleItemClick(view, imageItem, imageView);
        }
    }

    private void handleItemClick(android.view.View view, com.up366.multimedia.util.AlbumHelper.ImageItem cur, android.widget.ImageView selectView) {
        if (this.maxSize == 1) {
            if (this.selectItems.size() > 0) {
                return;
            }
            cur.isSelected = true;
            this.selectItems.add(cur);
            notifyDataUpdate();
            return;
        }
        cur.isSelected = !cur.isSelected;
        if (!cur.isSelected) {
            this.selectItems.remove(cur);
            selectView.setImageResource(com.afollestad.materialcamera.R.drawable.radio_unslected);
            notifyDataUpdate();
            return;
        }
        this.selectItems.add(cur);
        if (this.selectItems.size() > this.maxSize) {
            cur.isSelected = false;
            this.selectItems.remove(cur);
            android.widget.Toast.makeText(view.getContext(), "最多能够选择" + this.maxSize + "张", 1).show();
            return;
        }
        notifyDataUpdate();
        selectView.setImageResource(com.afollestad.materialcamera.R.drawable.radio_selected);
    }

    private void notifyDataUpdate() {
        com.up366.multimedia.listener.OnDataUpdateListener onDataUpdateListener = this.listener;
        if (onDataUpdateListener != null) {
            onDataUpdateListener.onSelectedUpdate(this.selectItems);
        }
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> getSelectItems() {
        return this.selectItems;
    }

    public void setSelectItems(java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> selectItems) {
        if (selectItems == null) {
            selectItems = new java.util.ArrayList<>();
        }
        this.selectItems = selectItems;
        notifyDataSetChanged();
    }

    public com.up366.multimedia.listener.OnDataUpdateListener getListener() {
        return this.listener;
    }

    public void setListener(com.up366.multimedia.listener.OnDataUpdateListener listener) {
        this.listener = listener;
    }
}
