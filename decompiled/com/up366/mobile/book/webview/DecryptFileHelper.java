package com.up366.mobile.book.webview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DecryptFileHelper {
    private static final java.lang.String GCM_ENC_SUFFIX = ".u3c";
    private static final java.lang.String LEGACY_ENC_SUFFIX = ".u3enc";
    private static final java.lang.String VALID_FILE = "valid.bin";

    public static class FsStat {
        public long creationTime;
        public long fileSize;
        public long modificationTime;
    }

    public android.webkit.WebResourceResponse getJsWebResourceResponse(java.lang.String str) {
        byte[] bArrDecryptLegacyJs;
        com.up366.mobile.book.webview.DecryptFileHelper.EncFile encFileFindEncFile = findEncFile(str);
        if (encFileFindEncFile == null) {
            return null;
        }
        try {
            byte[] encryptedFile = readEncryptedFile(encFileFindEncFile.path);
            if (encFileFindEncFile.gcm) {
                java.lang.String strFindValidDir = findValidDir(str);
                if (strFindValidDir == null) {
                    com.up366.common.log.Logger.error("TAG - DecryptFileHelper - getJsWebResourceResponse - gcm valid info not found - path:" + str);
                    return null;
                }
                bArrDecryptLegacyJs = com.up366.common.utils.EncryptUtil.decryptGcmJs(encryptedFile, strFindValidDir);
            } else {
                bArrDecryptLegacyJs = com.up366.common.utils.EncryptUtil.decryptLegacyJs(encryptedFile);
            }
            if (bArrDecryptLegacyJs == null) {
                com.up366.common.log.Logger.error("TAG - DecryptFileHelper - getJsWebResourceResponse - decrypt failed - path:" + str);
                return null;
            }
            com.up366.common.log.Logger.info("TAG - DecryptFileHelper - getJsWebResourceResponse - decrypt load - path:" + str);
            return new android.webkit.WebResourceResponse("application/javascript", "UTF-8", new java.io.ByteArrayInputStream(bArrDecryptLegacyJs));
        } catch (java.lang.Throwable th) {
            com.up366.mobile.common.onlinelog.OpLog.report("ERROR-DecryptFileHelper-decrypt", str, th);
            com.up366.common.log.Logger.error(th);
            return null;
        }
    }

    private com.up366.mobile.book.webview.DecryptFileHelper.EncFile findEncFile(java.lang.String str) {
        java.lang.String str2 = str + GCM_ENC_SUFFIX;
        if (com.up366.common.FileUtilsUp.isFileExists(str2)) {
            return new com.up366.mobile.book.webview.DecryptFileHelper.EncFile(str2, true);
        }
        java.lang.String str3 = str + LEGACY_ENC_SUFFIX;
        if (com.up366.common.FileUtilsUp.isFileExists(str3)) {
            return new com.up366.mobile.book.webview.DecryptFileHelper.EncFile(str3, false);
        }
        return null;
    }

    private java.lang.String findValidDir(java.lang.String str) {
        for (java.io.File parentFile = new java.io.File(str).getParentFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
            if (com.up366.common.FileUtilsUp.isFileExists(new java.io.File(parentFile, VALID_FILE).getPath())) {
                return parentFile.getPath();
            }
        }
        return null;
    }

    private byte[] readEncryptedFile(java.lang.String str) throws java.lang.Exception {
        java.io.FileInputStream fileInputStream;
        java.io.FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new java.io.FileInputStream(str);
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            byte[] streamBytes = readStreamBytes(fileInputStream);
            com.up366.common.IOUtils.close(fileInputStream);
            return streamBytes;
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            com.up366.common.IOUtils.close(fileInputStream2);
            throw th;
        }
    }

    private static class EncFile {
        final boolean gcm;
        final java.lang.String path;

        EncFile(java.lang.String str, boolean z) {
            this.path = str;
            this.gcm = z;
        }
    }

    public java.lang.String getEncFileContent(java.lang.String str) throws java.lang.Throwable {
        java.io.InputStream inputStream;
        java.io.InputStream fileInputStream;
        java.io.InputStream inputStream2 = null;
        try {
            android.webkit.WebResourceResponse jsWebResourceResponse = getJsWebResourceResponse(str);
            if (jsWebResourceResponse != null) {
                fileInputStream = jsWebResourceResponse.getData();
            } else {
                fileInputStream = new java.io.FileInputStream(new java.io.File(str));
            }
        } catch (java.lang.Exception e) {
            e = e;
            inputStream = null;
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            java.lang.String str2 = new java.lang.String(readStreamBytes(fileInputStream), java.nio.charset.StandardCharsets.UTF_8);
            com.up366.common.IOUtils.close(fileInputStream);
            return str2;
        } catch (java.lang.Exception e2) {
            inputStream = fileInputStream;
            e = e2;
            try {
                com.up366.common.log.Logger.error("DecryptFileHelper read file : '" + str + "' error ...", e);
                com.up366.common.IOUtils.close(inputStream);
                return null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                com.up366.common.IOUtils.close(inputStream2);
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            inputStream2 = fileInputStream;
            com.up366.common.IOUtils.close(inputStream2);
            throw th;
        }
    }

    private byte[] readStreamBytes(java.io.InputStream inputStream) throws java.lang.Exception {
        byte[] bArr = new byte[4096];
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static boolean isAbsolute(java.lang.String str) {
        return isAbsolute(str, false);
    }

    public static boolean isAbsolute(java.lang.String str, boolean z) {
        if (com.up366.common.FileUtilsUp.isFileExists(str)) {
            if (z && com.up366.common.FileUtilsUp.isDir(str)) {
                return isValidDirectoryOrChildDirectory(str);
            }
            return true;
        }
        if (com.up366.common.FileUtilsUp.isFileExists(str + GCM_ENC_SUFFIX)) {
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(LEGACY_ENC_SUFFIX);
        return com.up366.common.FileUtilsUp.isFileExists(sb.toString());
    }

    private static boolean isValidDirectoryOrChildDirectory(java.lang.String str) {
        if (com.up366.common.utils.EncryptUtil.valid(str)) {
            return true;
        }
        java.io.File[] fileArrListFiles = new java.io.File(str).listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z = false;
        for (java.io.File file : fileArrListFiles) {
            if (file != null && file.isDirectory()) {
                if (!com.up366.common.utils.EncryptUtil.valid(file.getAbsolutePath())) {
                    return false;
                }
                z = true;
            }
        }
        return z;
    }

    public static com.up366.mobile.book.webview.DecryptFileHelper.FsStat stat(java.lang.String str) {
        com.up366.mobile.book.webview.DecryptFileHelper.FsStat fsStat = new com.up366.mobile.book.webview.DecryptFileHelper.FsStat();
        java.io.File file = com.up366.common.FileUtilsUp.isFileExists(str) ? new java.io.File(str) : null;
        if (com.up366.common.FileUtilsUp.isFileExists(str + GCM_ENC_SUFFIX)) {
            file = new java.io.File(str + GCM_ENC_SUFFIX);
        }
        if (file == null) {
            if (com.up366.common.FileUtilsUp.isFileExists(str + LEGACY_ENC_SUFFIX)) {
                file = new java.io.File(str + LEGACY_ENC_SUFFIX);
            }
        }
        if (file != null) {
            fsStat.fileSize = file.length();
            fsStat.modificationTime = file.lastModified();
            fsStat.creationTime = file.lastModified();
        }
        return fsStat;
    }
}
