package com.up366.multimedia.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MediaHelper {
    private static final com.up366.multimedia.util.MediaHelper helper = new com.up366.multimedia.util.MediaHelper();
    private com.up366.multimedia.builder.MediaBuilder builder = new com.up366.multimedia.builder.MediaBuilder();

    public static com.up366.multimedia.util.MediaHelper getInstance() {
        return helper;
    }

    public void onAlbumSelected(com.up366.multimedia.event.PictureLoadEvent event, int maxSize) {
        if (maxSize == 1 && getBuilder().isSelectPictureSupportZoom()) {
            getInstance().getBuilder().setTempPath(event.getImageItems().get(0).imagePath).setOutPath(com.up366.multimedia.util.PathUtils.makeOutPath()).setrCropPath(com.up366.multimedia.util.PathUtils.makerCropPath());
            com.up366.multimedia.util.SkipUtil.startPhotoZoom();
        } else {
            com.up366.common.EventBusUtilsUp.post(event);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, android.content.Intent intent) throws java.lang.Throwable {
        if (requestCode == 1020 || requestCode == 300 || requestCode == 6969) {
            if (resultCode != -1) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.multimedia.event.PictureLoadEvent(-1));
                return;
            }
            if (requestCode == 300) {
                if (android.os.Build.VERSION.SDK_INT >= 30) {
                    com.up366.common.FileUtilsUp.copyFileOrDir(getBuilder().getrCropPath(), getBuilder().getOutPath());
                }
                notifyData(getBuilder().getOutPath());
                return;
            }
            if (requestCode == 1020) {
                if (getBuilder().isTakePhotoSupportZoom()) {
                    com.up366.multimedia.util.SkipUtil.startPhotoZoom();
                    return;
                } else {
                    com.up366.common.FileUtilsUp.renameFile(getBuilder().getTempPath(), getBuilder().getOutPath());
                    notifyData(getBuilder().getOutPath());
                    return;
                }
            }
            if (requestCode != 6969) {
                return;
            }
            java.lang.String strSubstring = intent.getDataString().substring(7);
            if (strSubstring.endsWith(".mp4")) {
                android.graphics.Bitmap videoFrame = com.up366.multimedia.util.SkipUtil.getVideoFrame(0L, strSubstring);
                java.lang.String strSubstring2 = strSubstring.substring(strSubstring.lastIndexOf("/") + 1, strSubstring.lastIndexOf("."));
                java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.multimedia.util.PathUtils.getPath(), strSubstring2 + com.up366.medialibrary.common.utils.MimeTypeUtils.JPG);
                com.up366.common.BitmapUtilsUp.saveBitmap(videoFrame, strJoin);
                com.up366.common.EventBusUtilsUp.post(new com.up366.multimedia.event.PictureLoadEvent(strJoin));
                com.up366.multimedia.util.GridViewUtil.addNewVideo(strSubstring, strJoin, getBuilder().getGridView());
            }
        }
    }

    public void handleItemClick(com.up366.multimedia.views.PictureVideoGridView gridView, android.view.View view, com.up366.multimedia.model.PictureVideo video) {
        getBuilder().setGridView(gridView);
        getBuilder().setViewId("viewUu11id");
        if (video.type == 1) {
            com.up366.multimedia.util.SkipUtil.toGallry(video);
        } else if (video.type == 2) {
            com.up366.multimedia.util.SkipUtil.toSeeVideo(video.url);
        } else {
            gridView.getAddListener().onClick(view);
        }
    }

    public void deleteItem(com.up366.multimedia.views.PictureVideoGridView gridView, int position) {
        gridView.delete(position);
    }

    private void notifyData(java.lang.String path) {
        com.up366.common.EventBusUtilsUp.post(new com.up366.multimedia.event.PictureLoadEvent(path));
        com.up366.multimedia.util.GridViewUtil.addNewPicture(path, getBuilder().getGridView());
    }

    public com.up366.multimedia.builder.MediaBuilder getBuilder() {
        return this.builder;
    }

    public com.up366.multimedia.builder.MediaBuilder createNewBuilder() {
        com.up366.multimedia.builder.MediaBuilder mediaBuilder = new com.up366.multimedia.builder.MediaBuilder();
        this.builder = mediaBuilder;
        return mediaBuilder;
    }
}
