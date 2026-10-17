package com.up366.multimedia.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SkipUtil {
    public static final int CAMERA_RQ = 6969;
    public static final int PATTERN_NULL = 0;
    public static final int PATTERN_PICTURE = 1;
    public static final int PATTERN_VIDEO = 2;
    public static final int REQUEST_CODE_PHOTO_REQUEST_CUT = 300;
    public static final int REQUEST_CODE_TAKE_PHOTO = 1020;

    public static void toAlbum(java.lang.String viewId) {
        android.content.Intent intent = new android.content.Intent(com.up366.common.global.GB.get().getCurrentActivity(), (java.lang.Class<?>) com.up366.multimedia.activity.AlbumActivity.class);
        intent.putExtra("maxSize", 1);
        intent.putExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_VIEW_ID, viewId);
        com.up366.common.global.GB.get().getCurrentActivity().startActivity(intent);
    }

    public static void toAlbum() {
        toAlbum(com.up366.multimedia.util.MediaHelper.getInstance().getBuilder());
    }

    public static void toAlbum(com.up366.multimedia.builder.MediaBuilder mediaBuilder) {
        com.up366.multimedia.views.PictureVideoGridView gridView = mediaBuilder.getGridView();
        if (gridView == null) {
            com.up366.common.log.Logger.error("toSeeVideo error, gridView is null ");
            return;
        }
        android.content.Context context = gridView.getContext();
        java.lang.String viewUuid = gridView.getViewUuid();
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.multimedia.activity.AlbumActivity.class);
        intent.putParcelableArrayListExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_IMAGE_ITEMS, gridView.getDatas());
        intent.putExtra("maxSize", gridView.getMaxCount());
        intent.putExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_VIEW_ID, viewUuid);
        intent.putExtra(com.up366.multimedia.util.AlbumHelper.INTENT_KEY_ALBUM_TYPE, gridView.isVideoPictureSameExist() ? 0 : com.up366.multimedia.util.MediaHelper.getInstance().getBuilder().getAlbumType());
        context.startActivity(intent);
    }

    protected static void toGallry(com.up366.multimedia.model.PictureVideo video) {
        com.up366.multimedia.views.PictureVideoGridView gridView = com.up366.multimedia.util.MediaHelper.getInstance().getBuilder().getGridView();
        if (gridView == null) {
            com.up366.common.log.Logger.error("toSeeVideo error, gridView is null ");
            return;
        }
        android.content.Context context = gridView.getContext();
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.multimedia.activity.PreviewActivity.class);
        intent.putExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_CUR_PICTURE_VIDEO, video);
        intent.putParcelableArrayListExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_IMAGE_ITEMS, gridView.getDatas());
        intent.putExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_VIEW_ID, gridView.getViewUuid());
        intent.putExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_IS_ADD_MODEL, gridView.isAddModel());
        context.startActivity(intent);
    }

    public static void toSeeVideo(java.lang.String videoPath) {
        com.up366.multimedia.views.PictureVideoGridView gridView = com.up366.multimedia.util.MediaHelper.getInstance().getBuilder().getGridView();
        if (gridView == null) {
            com.up366.common.log.Logger.error("toSeeVideo error, gridView is null ");
            return;
        }
        com.up366.common.EventBusUtilsUp.post(new com.up366.multimedia.event.MediaStopEvent());
        android.content.Intent intent = new android.content.Intent(gridView.getContext(), (java.lang.Class<?>) com.up366.multimedia.activity.VideoPlayActivity.class);
        intent.putExtra("video_src", videoPath);
        intent.putExtra(com.up366.multimedia.activity.PreviewActivity.INTENT_IS_ADD_MODEL, gridView.isAddModel());
        gridView.getContext().startActivity(intent);
    }

    public static void toTakePhoto() {
        toTakePhoto(com.up366.multimedia.util.MediaHelper.getInstance().getBuilder());
    }

    public static void toTakePhoto(com.up366.multimedia.builder.MediaBuilder builder) {
        initData(builder);
        android.content.Intent intent = new android.content.Intent("android.media.action.IMAGE_CAPTURE");
        intent.addFlags(1);
        intent.putExtra("output", com.up366.common.FileUtilsUp.getUriForFile(new java.io.File(builder.getTempPath())));
        android.app.Activity currentActivity = com.up366.common.global.GB.get().getCurrentActivity();
        try {
            if (isIntentAvailable(intent)) {
                currentActivity.startActivityForResult(intent, REQUEST_CODE_TAKE_PHOTO);
            } else {
                startCamera(currentActivity);
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("start IMAGE_CAPTURE error ...", e);
        }
    }

    private static void initData(com.up366.multimedia.builder.MediaBuilder builder) {
        builder.setTempPath(com.up366.multimedia.util.PathUtils.makeTemPath()).setOutPath(com.up366.multimedia.util.PathUtils.makeOutPath());
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            builder.setrCropPath(com.up366.multimedia.util.PathUtils.makerCropPath());
            com.up366.common.FileUtilsUp.mkdirParentDir(builder.getrCropPath());
        }
        com.up366.common.FileUtilsUp.mkdirParentDir(builder.getTempPath());
        com.up366.common.FileUtilsUp.mkdirParentDir(builder.getOutPath());
    }

    private static boolean isIntentAvailable(android.content.Intent intent) {
        return com.up366.common.global.GB.get().getCurrentActivity().getPackageManager().queryIntentActivities(intent, 1).size() > 0;
    }

    protected static void startPhotoZoom() {
        com.up366.multimedia.builder.MediaBuilder builder = com.up366.multimedia.util.MediaHelper.getInstance().getBuilder();
        android.content.Intent intent = new android.content.Intent("com.android.camera.action.CROP");
        intent.addFlags(1);
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("_data", builder.getrCropPath());
            contentValues.put("_display_name", new java.io.File(builder.getrCropPath()).getName());
            contentValues.put("mime_type", "image/jpeg");
            com.up366.common.global.GB.get().getApplicationContext().getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            intent.putExtra("output", android.net.Uri.fromFile(new java.io.File(builder.getrCropPath())));
        } else {
            intent.putExtra("output", android.net.Uri.fromFile(new java.io.File(builder.getOutPath())));
        }
        intent.setDataAndType(com.up366.common.FileUtilsUp.getUriForFile(new java.io.File(builder.getTempPath())), gdut.bsx.share2.ShareContentType.IMAGE);
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", android.graphics.Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        if (isIntentAvailable(intent)) {
            com.up366.common.global.GB.get().getCurrentActivity().startActivityForResult(intent, 300);
            return;
        }
        final int outX = builder.getOutX();
        final int outY = builder.getOutY();
        com.up366.common.task.TaskUtils.postGlobleTask(new com.up366.common.task.Task() { // from class: com.up366.multimedia.util.SkipUtil.1
            @Override // com.up366.common.task.Task
            public void run() throws java.lang.Exception {
                com.up366.multimedia.builder.MediaBuilder builder2 = com.up366.multimedia.util.MediaHelper.getInstance().getBuilder();
                com.up366.common.BitmapUtilsUp.compressBitmap(builder2.getOutPath(), builder2.getTempPath(), outX, outY, 80);
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.multimedia.util.SkipUtil.1.1
                    @Override // com.up366.common.task.Task
                    public void run() throws java.lang.Exception {
                        com.up366.multimedia.builder.MediaBuilder builder3 = com.up366.multimedia.util.MediaHelper.getInstance().getBuilder();
                        com.up366.common.EventBusUtilsUp.post(new com.up366.multimedia.event.PictureLoadEvent(builder3.getOutPath()));
                        com.up366.multimedia.util.GridViewUtil.addNewPicture(builder3.getOutPath(), builder3.getGridView());
                    }
                });
            }
        });
    }

    private static void startCamera(android.content.Context context) {
        java.io.File file = new java.io.File(com.up366.multimedia.util.PathUtils.getPath());
        if (!file.exists() && !file.mkdirs()) {
            throw new java.lang.RuntimeException("Unable to create save directory, make sure WRITE_EXTERNAL_STORAGE permission is granted.");
        }
        new com.afollestad.materialcamera.MaterialCamera((android.app.Activity) context).stillShot().labelConfirm(com.afollestad.materialcamera.R.string.mcam_use_stillshot).saveDir(file).start(CAMERA_RQ);
    }

    public static android.graphics.Bitmap getVideoFrame(long timePoint, java.lang.String mp4Path) {
        android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(mp4Path);
                android.graphics.Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(timePoint);
                try {
                    mediaMetadataRetriever.release();
                    return frameAtTime;
                } catch (java.lang.RuntimeException e) {
                    com.up366.common.log.Logger.error(e.getMessage(), e);
                    return frameAtTime;
                }
            } catch (java.lang.Exception e2) {
                com.up366.common.log.Logger.error(e2.getMessage(), e2);
                return null;
            }
        } finally {
            try {
                mediaMetadataRetriever.release();
            } catch (java.lang.RuntimeException e3) {
                com.up366.common.log.Logger.error(e3.getMessage(), e3);
            }
        }
    }
}
