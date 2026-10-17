package com.up366.multimedia.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class GridViewUtil {
    public static void addNewPicture(java.lang.String filePath, com.up366.multimedia.views.PictureVideoGridView gridView) {
        if (gridView == null) {
            return;
        }
        com.up366.multimedia.builder.MediaBuilder builder = com.up366.multimedia.util.MediaHelper.getInstance().getBuilder();
        if (builder.getViewId().equals(java.lang.String.valueOf(builder.getGridView().getId()))) {
            return;
        }
        java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> datas = gridView.getDatas();
        if (datas == null) {
            datas = new java.util.ArrayList<>();
        }
        datas.add(new com.up366.multimedia.util.AlbumHelper.ImageItem(java.lang.String.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()), filePath, com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()));
        gridView.setDatas(datas);
    }

    public static void addNewVideo(java.lang.String filePath, java.lang.String posterPath, com.up366.multimedia.views.PictureVideoGridView gridView) {
        if (gridView == null) {
            return;
        }
        com.up366.multimedia.builder.MediaBuilder builder = com.up366.multimedia.util.MediaHelper.getInstance().getBuilder();
        if (builder.getViewId().equals(java.lang.String.valueOf(builder.getGridView().getId()))) {
            return;
        }
        java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> datas = gridView.getDatas();
        if (datas == null) {
            datas = new java.util.ArrayList<>();
        }
        datas.add(new com.up366.multimedia.util.AlbumHelper.ImageItem(java.lang.String.valueOf(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond()), posterPath, filePath));
        gridView.setDatas(datas);
    }
}
