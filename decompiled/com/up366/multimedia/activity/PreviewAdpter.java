package com.up366.multimedia.activity;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PreviewAdpter extends androidx.viewpager.widget.PagerAdapter {
    private android.content.Context context;
    private java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> datas = new java.util.ArrayList();
    private android.util.SparseArray<android.view.View> map = new android.util.SparseArray<>();
    private int deleteItemIndex = 0;

    public int getItemPosition(java.lang.Object object) {
        return -2;
    }

    public boolean isViewFromObject(android.view.View view, java.lang.Object object) {
        return view == object;
    }

    public PreviewAdpter(android.content.Context context) {
        this.context = context;
    }

    public java.lang.Object instantiateItem(android.view.ViewGroup container, int position) {
        android.view.View viewInflate = this.map.get(position);
        if (viewInflate == null) {
            viewInflate = android.view.LayoutInflater.from(this.context).inflate(com.afollestad.materialcamera.R.layout.media_preview_item, (android.view.ViewGroup) null);
            this.map.put(position, viewInflate);
            addViewData(viewInflate, position);
        }
        if (position >= this.deleteItemIndex) {
            this.deleteItemIndex = position + 1;
            addViewData(viewInflate, position);
        }
        container.addView(viewInflate);
        return viewInflate;
    }

    private void addViewData(android.view.View view, int position) {
        final com.up366.multimedia.util.AlbumHelper.ImageItem imageItem = this.datas.get(position);
        final com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView subsamplingScaleImageView = (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView) view.findViewById(com.afollestad.materialcamera.R.id.preview_item_gif);
        android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(com.afollestad.materialcamera.R.id.preview_item_gif1);
        android.view.View viewFindViewById = view.findViewById(com.afollestad.materialcamera.R.id.preview_video_btn);
        imageView.setVisibility(8);
        subsamplingScaleImageView.setVisibility(8);
        viewFindViewById.setVisibility(8);
        viewFindViewById.setOnClickListener(null);
        if (!com.up366.common.StringUtils.isEmptyOrNull(imageItem.videoPath)) {
            viewFindViewById.setVisibility(0);
            viewFindViewById.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimedia.activity.PreviewAdpter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view2) {
                    com.up366.multimedia.util.SkipUtil.toSeeVideo(imageItem.videoPath);
                }
            });
            imageView.setVisibility(0);
            com.bumptech.glide.Glide.with(view.getContext()).load(android.net.Uri.fromFile(new java.io.File(imageItem.videoPath))).into(imageView);
            return;
        }
        if (isGif(imageItem.imagePath)) {
            imageView.setVisibility(0);
            com.bumptech.glide.Glide.with(view.getContext()).load(imageItem.imagePath).apply(com.bumptech.glide.request.RequestOptions.skipMemoryCacheOf(true)).apply(com.bumptech.glide.request.RequestOptions.diskCacheStrategyOf(com.bumptech.glide.load.engine.DiskCacheStrategy.NONE)).into(imageView);
            return;
        }
        subsamplingScaleImageView.setVisibility(0);
        if (imageItem.uri != null) {
            com.bumptech.glide.Glide.with(subsamplingScaleImageView).asBitmap().load(imageItem.uri).into(new com.bumptech.glide.request.target.SimpleTarget<android.graphics.Bitmap>() { // from class: com.up366.multimedia.activity.PreviewAdpter.1
                public /* bridge */ /* synthetic */ void onResourceReady(java.lang.Object resource, com.bumptech.glide.request.transition.Transition transition) {
                    onResourceReady((android.graphics.Bitmap) resource, (com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap>) transition);
                }

                public void onResourceReady(android.graphics.Bitmap resource, com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap> transition) {
                    subsamplingScaleImageView.setImage(com.davemorrissey.labs.subscaleview.ImageSource.cachedBitmap(resource));
                }
            });
        } else if (!com.up366.common.StringUtils.isEmptyOrNull(imageItem.imagePath) && imageItem.imagePath.startsWith("http")) {
            com.bumptech.glide.Glide.with(this.context).asBitmap().load(imageItem.imagePath).into(new com.bumptech.glide.request.target.SimpleTarget<android.graphics.Bitmap>() { // from class: com.up366.multimedia.activity.PreviewAdpter.2
                public /* bridge */ /* synthetic */ void onResourceReady(java.lang.Object resource, com.bumptech.glide.request.transition.Transition transition) {
                    onResourceReady((android.graphics.Bitmap) resource, (com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap>) transition);
                }

                public void onResourceReady(android.graphics.Bitmap resource, com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap> transition) {
                    subsamplingScaleImageView.setImage(com.davemorrissey.labs.subscaleview.ImageSource.cachedBitmap(resource));
                }
            });
        } else {
            subsamplingScaleImageView.setImage(com.davemorrissey.labs.subscaleview.ImageSource.uri(imageItem.imagePath));
        }
    }

    public void setDatas(java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void destroyItem(android.view.ViewGroup container, int position, java.lang.Object object) {
        container.removeView(this.map.get(position));
    }

    private boolean isGif(java.lang.String str) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        if (com.up366.common.StringUtils.isEmptyOrNull(str) || str.startsWith("http")) {
            return false;
        }
        java.lang.String str2 = "";
        java.io.FileInputStream fileInputStream2 = null;
        java.io.FileInputStream fileInputStream3 = null;
        try {
            try {
                fileInputStream = new java.io.FileInputStream(str);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[3];
            int i = fileInputStream.read(bArr);
            if (i != -1) {
                str2 = new java.lang.String(bArr, 0, i);
            }
            com.up366.common.IOUtils.close(fileInputStream);
            fileInputStream2 = i;
        } catch (java.lang.Exception e2) {
            e = e2;
            fileInputStream3 = fileInputStream;
            com.up366.common.log.Logger.error("getFileType error :" + e.getMessage());
            com.up366.common.IOUtils.close(fileInputStream3);
            fileInputStream2 = fileInputStream3;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            com.up366.common.IOUtils.close(fileInputStream2);
            throw th;
        }
        return "gif".equalsIgnoreCase(str2);
    }

    public int getCount() {
        return this.datas.size();
    }

    public void deleteItem(int position) {
        this.datas.remove(position);
        this.deleteItemIndex = position;
        notifyDataSetChanged();
    }
}
