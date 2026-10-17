package com.up366.asecengine.englishengine;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class OralModelHelper {
    private static final int BUFFER_SIZE = 8192;
    private static final java.lang.String MODEL_NAME = "model_4.6.0.zip";
    private static final int MODEL_VERSION = 42;
    private static final java.lang.String TEMP_MODEL_ZIP = "ases_model_assets.zip";

    public static int getAsesModelVersionNo(android.content.Context context) {
        try {
            java.io.InputStream inputStreamOpen = context.getAssets().open(MODEL_NAME);
            if (inputStreamOpen == null) {
                return 42;
            }
            inputStreamOpen.close();
            return 42;
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    public static boolean hasBundledModel(android.content.Context context) {
        return getAsesModelVersionNo(context) > 0;
    }

    public static boolean copyAssetsModel(android.content.Context context, java.lang.String str) {
        try {
            com.up366.common.FileUtilsUpV2.delete(new java.io.File(str));
            com.up366.common.FileUtilsUpV2.copyFromAssets(context, MODEL_NAME, new java.io.File(str));
            return true;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - OralModelHelper - copyAssetsModel - ", e);
            return false;
        }
    }

    public static boolean restoreModelDirFromAssets(android.content.Context context, java.lang.String str) {
        if (context == null || str == null || str.trim().length() == 0) {
            com.up366.common.log.Logger.error("TAG - OralModelHelper - restoreModelDirFromAssets - invalid args, modelDir=" + str);
            return false;
        }
        if (!hasBundledModel(context)) {
            com.up366.common.log.Logger.warn("TAG - OralModelHelper - restoreModelDirFromAssets - bundled model missing, skip restore");
            return false;
        }
        java.io.File file = new java.io.File(str);
        java.io.File file2 = new java.io.File(file, TEMP_MODEL_ZIP);
        try {
            com.up366.common.log.Logger.info("TAG - OralModelHelper - restoreModelDirFromAssets - modelDir=" + str);
            com.up366.common.FileUtilsUpV2.delete(file);
            if (!file.exists() && !file.mkdirs()) {
                com.up366.common.log.Logger.error("TAG - OralModelHelper - restoreModelDirFromAssets - mkdirs failed: " + str);
                return false;
            }
            if (!copyAssetsModel(context, file2.getAbsolutePath())) {
                com.up366.common.log.Logger.error("TAG - OralModelHelper - restoreModelDirFromAssets - copy assets model failed");
                return false;
            }
            unzipModel(file2, file);
            writeCheckFile(file);
            com.up366.common.log.Logger.info("TAG - OralModelHelper - restoreModelDirFromAssets - success");
            com.up366.common.FileUtilsUpV2.delete(file2);
            return true;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - OralModelHelper - restoreModelDirFromAssets - ", e);
            return false;
        } finally {
            com.up366.common.FileUtilsUpV2.delete(file2);
        }
    }

    private static void unzipModel(java.io.File file, java.io.File file2) throws java.lang.Exception {
        byte[] bArr = new byte[8192];
        java.lang.String str = file2.getCanonicalPath() + java.io.File.separator;
        java.util.zip.ZipInputStream zipInputStream = new java.util.zip.ZipInputStream(new java.io.FileInputStream(file));
        while (true) {
            try {
                java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    java.io.File file3 = new java.io.File(file2, nextEntry.getName());
                    if (!file3.getCanonicalPath().startsWith(str)) {
                        throw new java.lang.IllegalStateException("zip entry outside target dir: " + nextEntry.getName());
                    }
                    if (nextEntry.isDirectory()) {
                        if (!file3.exists() && !file3.mkdirs()) {
                            throw new java.lang.IllegalStateException("mkdirs failed: " + file3.getAbsolutePath());
                        }
                        zipInputStream.closeEntry();
                    } else {
                        java.io.File parentFile = file3.getParentFile();
                        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                            throw new java.lang.IllegalStateException("mkdirs failed: " + parentFile.getAbsolutePath());
                        }
                        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file3));
                        while (true) {
                            try {
                                int i = zipInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                } else {
                                    bufferedOutputStream.write(bArr, 0, i);
                                }
                            } finally {
                            }
                        }
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        zipInputStream.closeEntry();
                    }
                } else {
                    zipInputStream.close();
                    return;
                }
            } catch (java.lang.Throwable th) {
                try {
                    zipInputStream.close();
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    private static void writeCheckFile(java.io.File file) throws java.lang.Exception {
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(new java.io.File(file, "checkFile"), false);
        try {
            fileOutputStream.write("42###20260731".getBytes("UTF-8"));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (java.lang.Throwable th) {
            try {
                fileOutputStream.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
