package com.up366.mobile.common.screenshot;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ScreenShotManager {
    private static final long MEDIA_CONTENT_CHANGE_DEBOUNCE_MILLIS = 300;
    private static android.graphics.Point sScreenRealSize;
    private final android.content.Context mContext;
    private com.up366.mobile.common.screenshot.ScreenShotManager.MediaContentObserver mExternalObserver;
    private com.up366.mobile.common.screenshot.ScreenShotManager.MediaContentObserver mInternalObserver;
    private com.up366.mobile.common.screenshot.ScreenShotManager.OnScreenShotListener mListener;
    private volatile android.net.Uri mPendingContentUri;
    private long mStartListenTime;
    private final android.os.Handler mWorkHandler;
    private final android.os.HandlerThread mWorkThread;
    private static final com.up366.mobile.common.screenshot.ScreenShotManager shotManager = new com.up366.mobile.common.screenshot.ScreenShotManager(com.up366.common.global.GB.get().getApplicationContext());
    private static final java.lang.String[] MEDIA_PROJECTIONS_API_16 = {"_data", "datetaken", "width", "height"};
    private static final java.lang.String[] KEYWORDS = {"screenshot", "screenshots", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "截屏"};
    private final java.util.List<java.lang.String> sHasCallbackPaths = new java.util.ArrayList();
    private final android.os.Handler mUiHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    private final java.lang.Runnable mHandleMediaChangeRunnable = new java.lang.Runnable() { // from class: com.up366.mobile.common.screenshot.ScreenShotManager$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.lambda$new$0();
        }
    };

    public interface OnScreenShotListener {
        void onShot(java.lang.String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        android.net.Uri uri = this.mPendingContentUri;
        if (uri == null) {
            return;
        }
        queryLatestMedia(uri);
    }

    private ScreenShotManager(android.content.Context context) {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("The context must not be null.");
        }
        this.mContext = context;
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("ScreenShotManager-Worker");
        this.mWorkThread = handlerThread;
        handlerThread.start();
        this.mWorkHandler = new android.os.Handler(handlerThread.getLooper());
        if (sScreenRealSize == null) {
            android.graphics.Point realScreenSize = getRealScreenSize();
            sScreenRealSize = realScreenSize;
            if (realScreenSize != null) {
                com.up366.common.log.Logger.info("Screen Real Size: " + sScreenRealSize.x + " * " + sScreenRealSize.y);
            } else {
                com.up366.common.log.Logger.error("Get screen real size failed.");
            }
        }
        this.mListener = new com.up366.mobile.common.screenshot.ScreenShotManager.OnScreenShotListener() { // from class: com.up366.mobile.common.screenshot.ScreenShotManager$$ExternalSyntheticLambda2
            @Override // com.up366.mobile.common.screenshot.ScreenShotManager.OnScreenShotListener
            public final void onShot(java.lang.String str) {
                com.up366.mobile.main.CommonSharedActivity.openPage(com.up366.common.global.GB.get().getCurrentActivity(), str);
            }
        };
    }

    public static com.up366.mobile.common.screenshot.ScreenShotManager getInstance() {
        return shotManager;
    }

    public void startListen() {
        if (this.mInternalObserver != null || this.mExternalObserver != null) {
            com.up366.common.log.Logger.warn("ScreenShotManager already listening, skip duplicate register");
            return;
        }
        this.sHasCallbackPaths.clear();
        this.mPendingContentUri = null;
        this.mWorkHandler.removeCallbacks(this.mHandleMediaChangeRunnable);
        this.mStartListenTime = java.lang.System.currentTimeMillis();
        this.mInternalObserver = new com.up366.mobile.common.screenshot.ScreenShotManager.MediaContentObserver(android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.mUiHandler);
        this.mExternalObserver = new com.up366.mobile.common.screenshot.ScreenShotManager.MediaContentObserver(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.mUiHandler);
        this.mContext.getContentResolver().registerContentObserver(android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.mInternalObserver);
        this.mContext.getContentResolver().registerContentObserver(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.mExternalObserver);
    }

    public void stopListen() {
        try {
            if (this.mInternalObserver != null) {
                this.mContext.getContentResolver().unregisterContentObserver(this.mInternalObserver);
            }
            if (this.mExternalObserver != null) {
                this.mContext.getContentResolver().unregisterContentObserver(this.mExternalObserver);
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("stopListen error " + e.getMessage(), e);
        }
        this.mExternalObserver = null;
        this.mInternalObserver = null;
        this.mStartListenTime = 0L;
        this.mPendingContentUri = null;
        this.sHasCallbackPaths.clear();
        this.mWorkHandler.removeCallbacks(this.mHandleMediaChangeRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMediaContentChange(android.net.Uri uri) {
        if (uri == null || this.mStartListenTime <= 0) {
            return;
        }
        this.mPendingContentUri = uri;
        this.mWorkHandler.removeCallbacks(this.mHandleMediaChangeRunnable);
        this.mWorkHandler.postDelayed(this.mHandleMediaChangeRunnable, MEDIA_CONTENT_CHANGE_DEBOUNCE_MILLIS);
    }

    private void queryLatestMedia(android.net.Uri uri) {
        int i;
        int i2;
        android.database.Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.mContext.getContentResolver().query(uri, MEDIA_PROJECTIONS_API_16, null, null, "date_added desc limit 1");
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("handleMediaContentChange error " + e.getMessage(), e);
                if (0 == 0 || cursorQuery.isClosed()) {
                    return;
                }
            }
            if (cursorQuery == null) {
                com.up366.common.log.Logger.error("Deviant logic. cursor is null");
                if (cursorQuery == null || cursorQuery.isClosed()) {
                    return;
                }
                cursorQuery.close();
                return;
            }
            if (!cursorQuery.moveToFirst()) {
                com.up366.common.log.Logger.debug("Cursor no data.");
                if (cursorQuery == null || cursorQuery.isClosed()) {
                    return;
                }
                cursorQuery.close();
                return;
            }
            int columnIndex = cursorQuery.getColumnIndex("_data");
            int columnIndex2 = cursorQuery.getColumnIndex("datetaken");
            int columnIndex3 = cursorQuery.getColumnIndex("width");
            int columnIndex4 = cursorQuery.getColumnIndex("height");
            java.lang.String string = cursorQuery.getString(columnIndex);
            long j = cursorQuery.getLong(columnIndex2);
            if (columnIndex3 < 0 || columnIndex4 < 0) {
                android.graphics.Point imageSize = getImageSize(string);
                int i3 = imageSize.x;
                i = imageSize.y;
                i2 = i3;
            } else {
                i2 = cursorQuery.getInt(columnIndex3);
                i = cursorQuery.getInt(columnIndex4);
            }
            handleMediaRowData(string, j, i2, i);
            if (cursorQuery == null || cursorQuery.isClosed()) {
                return;
            }
            cursorQuery.close();
        } catch (java.lang.Throwable th) {
            if (0 != 0 && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    private android.graphics.Point getImageSize(java.lang.String str) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(str, options);
        return new android.graphics.Point(options.outWidth, options.outHeight);
    }

    private void handleMediaRowData(final java.lang.String str, long j, int i, int i2) {
        if (checkScreenShot(str, j, i, i2)) {
            com.up366.common.log.Logger.debug("ScreenShot: path = " + str + "; size = " + i + " * " + i2 + "; date = " + j);
            if (this.mListener == null || checkCallback(str)) {
                return;
            }
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.screenshot.ScreenShotManager$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$handleMediaRowData$2(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleMediaRowData$2(java.lang.String str) throws java.lang.Exception {
        this.mListener.onShot(str);
    }

    private boolean checkScreenShot(java.lang.String str, long j, int i, int i2) {
        android.graphics.Point point;
        if (j < this.mStartListenTime || java.lang.System.currentTimeMillis() - j > com.igexin.push.config.c.i || (((point = sScreenRealSize) != null && ((i > point.x || i2 > sScreenRealSize.y) && (i2 > sScreenRealSize.x || i > sScreenRealSize.y))) || android.text.TextUtils.isEmpty(str))) {
            return false;
        }
        java.lang.String lowerCase = str.toLowerCase();
        for (java.lang.String str2 : KEYWORDS) {
            if (lowerCase.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCallback(java.lang.String str) {
        if (this.sHasCallbackPaths.contains(str)) {
            return true;
        }
        if (this.sHasCallbackPaths.size() >= 20) {
            for (int i = 0; i < 5; i++) {
                this.sHasCallbackPaths.remove(0);
            }
        }
        this.sHasCallbackPaths.add(str);
        return false;
    }

    private android.graphics.Point getRealScreenSize() {
        android.graphics.Point point;
        java.lang.Exception e;
        try {
            point = new android.graphics.Point();
        } catch (java.lang.Exception e2) {
            point = null;
            e = e2;
        }
        try {
            ((android.view.WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRealSize(point);
        } catch (java.lang.Exception e3) {
            e = e3;
            com.up366.common.log.Logger.error("getRealScreenSize error " + e.getMessage(), e);
        }
        return point;
    }

    private class MediaContentObserver extends android.database.ContentObserver {
        private final android.net.Uri mContentUri;

        MediaContentObserver(android.net.Uri uri, android.os.Handler handler) {
            super(handler);
            this.mContentUri = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            com.up366.mobile.common.screenshot.ScreenShotManager.this.handleMediaContentChange(this.mContentUri);
        }
    }
}
