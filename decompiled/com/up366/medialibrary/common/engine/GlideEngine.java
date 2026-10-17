package com.up366.medialibrary.common.engine;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GlideEngine implements com.up366.medialibrary.common.engine.ImageEngine {
    private static com.up366.medialibrary.common.engine.GlideEngine instance;

    @Override // com.up366.medialibrary.common.engine.ImageEngine
    public void loadImage(android.content.Context context, java.lang.String str, android.widget.ImageView imageView) {
        if (com.up366.medialibrary.common.utils.ImageLoaderUtils.assertValidRequest(context)) {
            com.bumptech.glide.Glide.with(context).load(str).into(imageView);
        }
    }

    @Override // com.up366.medialibrary.common.engine.ImageEngine
    public void loadImage(android.content.Context context, final java.lang.String str, final android.widget.ImageView imageView, final com.up366.medialibrary.widget.longimage.SubsamplingScaleImageView subsamplingScaleImageView, final com.up366.medialibrary.listener.OnImageCompleteCallback onImageCompleteCallback) {
        if (com.up366.medialibrary.common.utils.ImageLoaderUtils.assertValidRequest(context)) {
            com.bumptech.glide.Glide.with(context).asBitmap().load(str).into(new com.bumptech.glide.request.target.CustomTarget<android.graphics.Bitmap>() { // from class: com.up366.medialibrary.common.engine.GlideEngine.1
                public void onLoadCleared(android.graphics.drawable.Drawable drawable) {
                }

                public /* bridge */ /* synthetic */ void onResourceReady(java.lang.Object obj, com.bumptech.glide.request.transition.Transition transition) {
                    onResourceReady((android.graphics.Bitmap) obj, (com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap>) transition);
                }

                public void onLoadStarted(android.graphics.drawable.Drawable drawable) {
                    super.onLoadStarted(drawable);
                    com.up366.medialibrary.listener.OnImageCompleteCallback onImageCompleteCallback2 = onImageCompleteCallback;
                    if (onImageCompleteCallback2 != null) {
                        onImageCompleteCallback2.onShowLoading();
                    }
                }

                public void onLoadFailed(android.graphics.drawable.Drawable drawable) {
                    super.onLoadFailed(drawable);
                    com.up366.medialibrary.listener.OnImageCompleteCallback onImageCompleteCallback2 = onImageCompleteCallback;
                    if (onImageCompleteCallback2 != null) {
                        onImageCompleteCallback2.onHideLoading();
                    }
                }

                public void onResourceReady(android.graphics.Bitmap bitmap, com.bumptech.glide.request.transition.Transition<? super android.graphics.Bitmap> transition) {
                    com.up366.medialibrary.listener.OnImageCompleteCallback onImageCompleteCallback2 = onImageCompleteCallback;
                    if (onImageCompleteCallback2 != null) {
                        onImageCompleteCallback2.onHideLoading();
                    }
                    boolean zIsLongImg = com.up366.medialibrary.common.utils.MediaUtils.isLongImg(bitmap.getWidth(), bitmap.getHeight());
                    com.up366.medialibrary.common.utils.MMKVUtils.getInst().putSize(str, new android.util.Size(bitmap.getWidth(), bitmap.getHeight()));
                    subsamplingScaleImageView.setVisibility(zIsLongImg ? 0 : 8);
                    imageView.setVisibility(zIsLongImg ? 8 : 0);
                    if (zIsLongImg) {
                        subsamplingScaleImageView.setQuickScaleEnabled(true);
                        subsamplingScaleImageView.setZoomEnabled(true);
                        subsamplingScaleImageView.setDoubleTapZoomDuration(100);
                        subsamplingScaleImageView.setMinimumScaleType(2);
                        subsamplingScaleImageView.setDoubleTapZoomDpi(2);
                        subsamplingScaleImageView.setImage(com.up366.medialibrary.widget.longimage.ImageSource.cachedBitmap(bitmap), new com.up366.medialibrary.widget.longimage.ImageViewState(0.0f, new android.graphics.PointF(0.0f, 0.0f), 0));
                        return;
                    }
                    imageView.setImageBitmap(bitmap);
                }
            });
        }
    }

    @Override // com.up366.medialibrary.common.engine.ImageEngine
    public void loadFolderImage(final android.content.Context context, java.lang.String str, final android.widget.ImageView imageView) {
        if (com.up366.medialibrary.common.utils.ImageLoaderUtils.assertValidRequest(context)) {
            com.bumptech.glide.Glide.with(context).asBitmap().load(str).override(180, 180).centerCrop().sizeMultiplier(0.5f).placeholder(com.up366.medialibrary.R.drawable.picture_image_placeholder).into(new com.bumptech.glide.request.target.BitmapImageViewTarget(imageView) { // from class: com.up366.medialibrary.common.engine.GlideEngine.2
                /* JADX INFO: Access modifiers changed from: protected */
                public void setResource(android.graphics.Bitmap bitmap) {
                    android.graphics.drawable.Drawable drawableCreate = androidx.core.graphics.drawable.RoundedBitmapDrawableFactory.create(context.getResources(), bitmap);
                    drawableCreate.setCornerRadius(8.0f);
                    imageView.setImageDrawable(drawableCreate);
                }
            });
        }
    }

    @Override // com.up366.medialibrary.common.engine.ImageEngine
    public void loadGridImage(android.content.Context context, java.lang.String str, android.widget.ImageView imageView) {
        if (com.up366.medialibrary.common.utils.ImageLoaderUtils.assertValidRequest(context)) {
            com.bumptech.glide.Glide.with(context).load(str).override(200, 200).centerCrop().placeholder(com.up366.medialibrary.R.drawable.picture_image_placeholder).into(imageView);
        }
    }

    private GlideEngine() {
    }

    public static com.up366.medialibrary.common.engine.GlideEngine createGlideEngine() {
        if (instance == null) {
            synchronized (com.up366.medialibrary.common.engine.GlideEngine.class) {
                if (instance == null) {
                    instance = new com.up366.medialibrary.common.engine.GlideEngine();
                }
            }
        }
        return instance;
    }
}
