package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AttachmentViewUtils {
    public static android.util.Size getImageMaxSize(android.content.Context context) {
        float f = com.up366.medialibrary.common.utils.ScreenUtils.getScreenInfo(context)[0];
        return new android.util.Size((int) (f / 3.0f), (int) (f / 2.0f));
    }

    public static void showVideoThnumbnail(android.widget.ImageView imageView, com.up366.medialibrary.model.AttachmentInfo attachmentInfo, android.util.Size size, int i) {
        showThnumbnail(imageView, ((com.up366.medialibrary.model.VideoAttachmentInfo) attachmentInfo).getThumbnail(), size, i, true);
    }

    public static void showImageThnumbnail(android.widget.ImageView imageView, com.up366.medialibrary.model.AttachmentInfo attachmentInfo, android.util.Size size, int i) {
        showThnumbnail(imageView, attachmentInfo.getPath(), size, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getPlaceHolder(boolean z) {
        return z ? com.up366.medialibrary.R.drawable.picture_thumnail_placeholder : com.up366.medialibrary.R.drawable.picture_image_placeholder;
    }

    private static void showThnumbnail(android.widget.ImageView imageView, java.lang.String str, android.util.Size size, int i, boolean z) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            com.bumptech.glide.Glide.with(imageView.getContext()).load(java.lang.Integer.valueOf(getPlaceHolder(z))).override(size.getWidth(), size.getHeight()).into(imageView);
            return;
        }
        if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(str)) {
            showIntoImage(imageView, str, getLocalSize(str), size, i, z);
            return;
        }
        java.lang.String localImagePath = com.up366.medialibrary.common.utils.MediaPathUtil.getInst().getLocalImagePath(str);
        if (com.up366.common.FileUtilsUp.isFileExists(localImagePath)) {
            showIntoImage(imageView, localImagePath, getLocalSize(localImagePath), size, i, z);
            return;
        }
        java.lang.String thnumbnailFilePath = getThnumbnailFilePath(str);
        if (com.up366.common.FileUtilsUp.isFileExists(thnumbnailFilePath)) {
            showIntoImage(imageView, thnumbnailFilePath, getLocalSize(thnumbnailFilePath), size, i, z);
        } else {
            showLoading(imageView, size);
            com.up366.medialibrary.helper.MediaHelperManager.getTools().downloadThnumbnail(str, thnumbnailFilePath, new com.up366.medialibrary.common.utils.AttachmentViewUtils.AnonymousClass1(imageView, thnumbnailFilePath, size, i, z));
        }
    }

    /* JADX INFO: renamed from: com.up366.medialibrary.common.utils.AttachmentViewUtils$1, reason: invalid class name */
    class AnonymousClass1 implements com.up366.medialibrary.listener.OnDownloadListener {
        final /* synthetic */ android.widget.ImageView val$imageView;
        final /* synthetic */ boolean val$isVideoThnumbnail;
        final /* synthetic */ android.util.Size val$maxSize;
        final /* synthetic */ int val$roundingRadius;
        final /* synthetic */ java.lang.String val$tPath;

        @Override // com.up366.medialibrary.listener.OnDownloadListener
        public void onProgress(int i, java.lang.String str) {
        }

        AnonymousClass1(android.widget.ImageView imageView, java.lang.String str, android.util.Size size, int i, boolean z) {
            this.val$imageView = imageView;
            this.val$tPath = str;
            this.val$maxSize = size;
            this.val$roundingRadius = i;
            this.val$isVideoThnumbnail = z;
        }

        @Override // com.up366.medialibrary.listener.OnDownloadListener
        public void onSuccess() {
            final android.widget.ImageView imageView = this.val$imageView;
            final java.lang.String str = this.val$tPath;
            final android.util.Size size = this.val$maxSize;
            final int i = this.val$roundingRadius;
            final boolean z = this.val$isVideoThnumbnail;
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.medialibrary.common.utils.AttachmentViewUtils$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    android.widget.ImageView imageView2 = imageView;
                    java.lang.String str2 = str;
                    com.up366.medialibrary.common.utils.AttachmentViewUtils.showIntoImage(imageView2, str2, com.up366.medialibrary.common.utils.AttachmentViewUtils.getLocalSize(str2), size, i, z);
                }
            });
        }

        @Override // com.up366.medialibrary.listener.OnDownloadListener
        public void onError(int i, java.lang.String str) {
            com.up366.common.log.Logger.error("showVideoThnumbnail error " + i + "  info :" + str);
            final android.widget.ImageView imageView = this.val$imageView;
            final boolean z = this.val$isVideoThnumbnail;
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.medialibrary.common.utils.AttachmentViewUtils$1$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() {
                    imageView.setImageResource(com.up366.medialibrary.common.utils.AttachmentViewUtils.getPlaceHolder(z));
                }
            });
        }
    }

    private static java.lang.String getThnumbnailFilePath(java.lang.String str) {
        return com.up366.medialibrary.helper.MediaHelperManager.getTools().getRootPath(1) + java.io.File.separator + "thnumnail_" + com.up366.common.digest.MD5.md5(str);
    }

    private static void showLoading(android.widget.ImageView imageView, android.util.Size size) {
        android.content.Context context = imageView.getContext();
        android.view.ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER);
        layoutParams.width = size.getWidth();
        layoutParams.height = size.getHeight();
        com.bumptech.glide.Glide.with(context).asGif().load(java.lang.Integer.valueOf(com.up366.medialibrary.R.drawable.picture_loading)).into(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showIntoImage(android.widget.ImageView imageView, java.lang.String str, android.util.Size size, android.util.Size size2, int i, boolean z) {
        com.up366.medialibrary.common.utils.AttachmentViewUtils.DataHolder imageParams = getImageParams(imageView, size2, size);
        com.bumptech.glide.request.RequestOptions requestOptionsPlaceholder = new com.bumptech.glide.request.RequestOptions().placeholder(getPlaceHolder(z));
        if (i > 0 && imageParams.mRadio / imageParams.radio < 4.0f) {
            requestOptionsPlaceholder = com.bumptech.glide.request.RequestOptions.circleCropTransform().placeholder(getPlaceHolder(z)).transform(new com.bumptech.glide.load.resource.bitmap.RoundedCorners(i));
        }
        com.up366.common.log.Logger.info("showIntoImage holder " + imageParams);
        com.bumptech.glide.Glide.with(imageView.getContext()).load(str).apply(requestOptionsPlaceholder).diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL).override(imageParams.params.width, imageParams.params.height).into(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static android.util.Size getLocalSize(java.lang.String str) {
        android.graphics.BitmapFactory.Options bitmapOptions;
        android.util.Size size = com.up366.medialibrary.common.utils.MMKVUtils.getInst().getSize(str);
        if (size != null && size.getHeight() != 0 && size.getWidth() != 0) {
            return size;
        }
        try {
            bitmapOptions = com.up366.medialibrary.common.utils.ImageUtils.getBitmapOptions(str);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("showImage error " + e.getMessage(), e);
            bitmapOptions = null;
        }
        if (bitmapOptions != null) {
            android.util.Size size2 = new android.util.Size(bitmapOptions.outWidth, bitmapOptions.outHeight);
            com.up366.medialibrary.common.utils.MMKVUtils.getInst().putSize(str, size2);
            return size2;
        }
        return new android.util.Size(0, 0);
    }

    private static com.up366.medialibrary.common.utils.AttachmentViewUtils.DataHolder getImageParams(android.widget.ImageView imageView, android.util.Size size, android.util.Size size2) {
        int width = size.getWidth();
        int height = size.getHeight();
        float f = width;
        float f2 = height;
        float f3 = (f * 1.0f) / f2;
        imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        float width2 = (size2.getWidth() * 1.0f) / (size2.getHeight() == 0 ? 1 : size2.getHeight());
        float f4 = width2 != 0.0f ? width2 : 1.0f;
        android.view.ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        float f5 = f3 / f4;
        if (f5 < 0.1f) {
            imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            layoutParams.width = width;
            layoutParams.height = width / 2;
        } else if (f5 > 4.0f) {
            imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            layoutParams.width = height / 2;
            layoutParams.height = height;
        } else if (f4 < f3) {
            layoutParams.height = height;
            layoutParams.width = (int) (f2 * f4);
        } else {
            layoutParams.width = width;
            layoutParams.height = (int) (f / f4);
        }
        com.up366.medialibrary.common.utils.AttachmentViewUtils.DataHolder dataHolder = new com.up366.medialibrary.common.utils.AttachmentViewUtils.DataHolder();
        dataHolder.params = layoutParams;
        dataHolder.mRadio = f3;
        dataHolder.radio = f4;
        return dataHolder;
    }

    static class DataHolder {
        float mRadio;
        android.view.ViewGroup.LayoutParams params;
        float radio;

        DataHolder() {
        }

        public java.lang.String toString() {
            return "DataHolder{params=" + this.params.width + com.igexin.push.core.b.an + this.params.height + ", mRadio=" + this.mRadio + ", radio=" + this.radio + '}';
        }
    }
}
