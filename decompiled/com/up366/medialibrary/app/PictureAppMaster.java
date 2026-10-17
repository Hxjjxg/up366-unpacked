package com.up366.medialibrary.app;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PictureAppMaster implements com.up366.medialibrary.app.IApp {
    private static com.up366.medialibrary.app.PictureAppMaster mInstance;
    private com.up366.medialibrary.app.IApp app;

    @Override // com.up366.medialibrary.app.IApp
    public android.content.Context getAppContext() {
        com.up366.medialibrary.app.IApp iApp = this.app;
        if (iApp == null) {
            return null;
        }
        return iApp.getAppContext();
    }

    @Override // com.up366.medialibrary.app.IApp
    public com.up366.medialibrary.common.engine.PictureSelectorEngine getPictureSelectorEngine() {
        com.up366.medialibrary.app.IApp iApp = this.app;
        if (iApp == null) {
            return null;
        }
        return iApp.getPictureSelectorEngine();
    }

    private PictureAppMaster() {
    }

    public static com.up366.medialibrary.app.PictureAppMaster getInstance() {
        if (mInstance == null) {
            synchronized (com.up366.medialibrary.app.PictureAppMaster.class) {
                if (mInstance == null) {
                    mInstance = new com.up366.medialibrary.app.PictureAppMaster();
                }
            }
        }
        return mInstance;
    }

    public void setApp(com.up366.medialibrary.app.IApp iApp) {
        this.app = iApp;
    }

    public com.up366.medialibrary.app.IApp getApp() {
        return this.app;
    }
}
