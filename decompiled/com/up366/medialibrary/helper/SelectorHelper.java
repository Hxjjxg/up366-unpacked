package com.up366.medialibrary.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SelectorHelper {
    protected SelectorHelper() {
    }

    protected void init(android.content.Context context) {
        com.tencent.mmkv.MMKV.initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv_media");
        new com.up366.medialibrary.loader.LocalMediaPageLoader(context, com.up366.medialibrary.config.PictureSelectionConfig.getInstance()).loadAllMedia(new com.up366.medialibrary.listener.OnQueryDataResultListener<>());
    }

    public void openGallery(android.app.Activity activity, final com.up366.medialibrary.listener.OnResultCallbackListener<com.up366.medialibrary.MediaInfo> onResultCallbackListener) {
        com.up366.medialibrary.PictureSelector.create(activity).openGallery(com.up366.medialibrary.common.utils.MimeTypeUtils.ofAll()).isPageStrategy(true).isCompress(true).isCamera(false).isDisplayOriginalSize(false).maxVideoSelectNum(9).isWithVideoImage(true).setPictureUIStyle(com.up366.medialibrary.common.style.PictureSelectorUIStyle.ofUp366Style()).isMaxSelectEnabledMask(true).isOriginalImageControl(true).forResult(new com.up366.medialibrary.listener.OnResultCallbackListener<com.up366.medialibrary.model.LocalMedia>() { // from class: com.up366.medialibrary.helper.SelectorHelper.1
            @Override // com.up366.medialibrary.listener.OnResultCallbackListener
            public void onResult(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
                if (onResultCallbackListener == null) {
                    com.up366.common.log.Logger.error("openGallery onResult error OnResultCallbackListener listener is null");
                    return;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                if (list == null) {
                    onResultCallbackListener.onResult(arrayList);
                    return;
                }
                java.util.Iterator<com.up366.medialibrary.model.LocalMedia> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getMediaInfo());
                }
                onResultCallbackListener.onResult(arrayList);
            }

            @Override // com.up366.medialibrary.listener.OnResultCallbackListener
            public void onCancel() {
                com.up366.medialibrary.listener.OnResultCallbackListener onResultCallbackListener2 = onResultCallbackListener;
                if (onResultCallbackListener2 == null) {
                    com.up366.common.log.Logger.error("openGallery onCancel error OnResultCallbackListener listener is null");
                } else {
                    onResultCallbackListener2.onCancel();
                }
            }
        });
    }

    public void openPictureGallery(android.app.Activity activity, int i, final com.up366.medialibrary.listener.OnResultCallbackListener<com.up366.medialibrary.MediaInfo> onResultCallbackListener) {
        com.up366.medialibrary.PictureSelector.create(activity).openGallery(com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage()).isPageStrategy(true).isCompress(false).isCamera(false).isDisplayOriginalSize(false).maxSelectNum(i).isWithVideoImage(false).setPictureUIStyle(com.up366.medialibrary.common.style.PictureSelectorUIStyle.ofUp366Style()).isMaxSelectEnabledMask(true).isOriginalImageControl(false).forResult(new com.up366.medialibrary.listener.OnResultCallbackListener<com.up366.medialibrary.model.LocalMedia>() { // from class: com.up366.medialibrary.helper.SelectorHelper.2
            @Override // com.up366.medialibrary.listener.OnResultCallbackListener
            public void onResult(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
                if (onResultCallbackListener == null) {
                    com.up366.common.log.Logger.error("openGallery onResult error OnResultCallbackListener listener is null");
                    return;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                if (list == null) {
                    onResultCallbackListener.onResult(arrayList);
                    return;
                }
                java.util.Iterator<com.up366.medialibrary.model.LocalMedia> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getMediaInfo());
                }
                onResultCallbackListener.onResult(arrayList);
            }

            @Override // com.up366.medialibrary.listener.OnResultCallbackListener
            public void onCancel() {
                com.up366.medialibrary.listener.OnResultCallbackListener onResultCallbackListener2 = onResultCallbackListener;
                if (onResultCallbackListener2 == null) {
                    com.up366.common.log.Logger.error("openGallery onCancel error OnResultCallbackListener listener is null");
                } else {
                    onResultCallbackListener2.onCancel();
                }
            }
        });
    }
}
