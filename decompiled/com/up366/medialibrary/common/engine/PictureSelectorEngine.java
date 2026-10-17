package com.up366.medialibrary.common.engine;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public interface PictureSelectorEngine {
    com.up366.medialibrary.common.engine.ImageEngine createEngine();

    com.up366.medialibrary.listener.OnResultCallbackListener<com.up366.medialibrary.model.LocalMedia> getResultCallbackListener();
}
