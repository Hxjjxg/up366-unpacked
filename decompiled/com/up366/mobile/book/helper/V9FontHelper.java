package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V9FontHelper {
    public static final java.lang.String FONT_DIR = "Global/Font";

    public static void copyFontsToLocalStorage(final android.content.Context context) {
        try {
            com.up366.common.task.TaskUtils.postLazyTaskGlobal("V9FontHelper#copyFontsToLocalStorage", new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.V9FontHelper$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Throwable {
                    com.up366.mobile.book.helper.V9FontHelper.copyFontsFromAssets(context);
                }
            });
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - V9FontHelper - Failed to copy fonts to local storage: " + e.getMessage(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void copyFontsFromAssets(android.content.Context context) throws java.lang.Throwable {
        try {
            java.lang.String strJoin = com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getV9RootResourceDir(), FONT_DIR);
            java.io.File file = new java.io.File(strJoin);
            if (!file.exists() && !file.mkdirs()) {
                com.up366.common.log.Logger.error("TAG - V9FontHelper - Failed to create font directory: " + strJoin);
                return;
            }
            android.content.res.AssetManager assets = context.getAssets();
            try {
                java.lang.String[] list = assets.list("fonts");
                if (list != null && list.length != 0) {
                    for (java.lang.String str : list) {
                        if (str.endsWith(".ttf") || str.endsWith(".otf")) {
                            java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(strJoin, str);
                            if (new java.io.File(strJoin2).exists()) {
                                com.up366.common.log.Logger.info("TAG - V9FontHelper - Font file already exists: " + strJoin2);
                            } else {
                                copyAssetFile(assets, "fonts/" + str, strJoin2);
                                com.up366.common.log.Logger.info("TAG - V9FontHelper - Copied font file: " + str + " to " + strJoin2);
                            }
                        }
                    }
                    com.up366.common.log.Logger.info("TAG - V9FontHelper - Font files copy completed to: " + strJoin);
                    return;
                }
                com.up366.common.log.Logger.error("TAG - V9FontHelper - No font files found in assets/fonts directory");
            } catch (java.io.IOException e) {
                com.up366.common.log.Logger.error("TAG - V9FontHelper - assets/fonts directory not found: " + e.getMessage());
            }
        } catch (java.lang.Exception e2) {
            com.up366.common.log.Logger.error("TAG - V9FontHelper - Error copying font files: " + e2.getMessage(), e2);
        }
    }

    private static void copyAssetFile(android.content.res.AssetManager assetManager, java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.io.InputStream inputStreamOpen;
        byte[] bArr;
        long j;
        com.up366.common.FileUtilsUp.mkdirParentDir(str2);
        java.io.InputStream inputStream = null;
        try {
            inputStreamOpen = assetManager.open(str);
            try {
                fileOutputStream = new java.io.FileOutputStream(str2);
            } catch (java.io.IOException e) {
                e = e;
                fileOutputStream = null;
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (java.io.IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            bArr = new byte[4096];
            j = 0;
        } catch (java.io.IOException e3) {
            e = e3;
            inputStream = inputStreamOpen;
            try {
                com.up366.common.log.Logger.error("TAG - V9FontHelper - Error copying asset file: " + e.getMessage(), e);
                com.up366.mobile.common.utils.IOUtils.close(inputStream);
            } catch (java.lang.Throwable th3) {
                th = th3;
                com.up366.mobile.common.utils.IOUtils.close(inputStream);
                com.up366.mobile.common.utils.IOUtils.close(fileOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            inputStream = inputStreamOpen;
            com.up366.mobile.common.utils.IOUtils.close(inputStream);
            com.up366.mobile.common.utils.IOUtils.close(fileOutputStream);
            throw th;
        }
        while (true) {
            int i = inputStreamOpen.read(bArr);
            if (i == -1) {
                break;
            }
            fileOutputStream.write(bArr, 0, i);
            j += (long) i;
            com.up366.mobile.common.utils.IOUtils.close(fileOutputStream);
        }
        com.up366.common.log.Logger.info("TAG - V9FontHelper - Copied " + j + " bytes from " + str + " to " + str2);
        com.up366.mobile.common.utils.IOUtils.close(inputStreamOpen);
        com.up366.mobile.common.utils.IOUtils.close(fileOutputStream);
    }
}
