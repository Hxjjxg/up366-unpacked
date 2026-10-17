package com.up366.common.download;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ZipHelper {

    public interface ZipCallback {
        void onFail(java.lang.Exception exc);

        void onProgress(int i);

        void onSuccess();
    }

    public static void unzip(java.lang.String str, java.lang.String str2, com.up366.common.download.ZipHelper.ZipCallback zipCallback) {
        unzip(str, str2, null, zipCallback);
    }

    public static void unzip(java.lang.String str, java.lang.String str2, java.lang.String str3, com.up366.common.download.ZipHelper.ZipCallback zipCallback) throws java.lang.Throwable {
        if (isEmpty(str3)) {
            unzipWithoutExt(str, str2, zipCallback);
        } else {
            unzipWithExt(str, str2, str3, zipCallback);
        }
    }

    private static void unzipWithoutExt(java.lang.String str, java.lang.String str2, com.up366.common.download.ZipHelper.ZipCallback zipCallback) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        java.io.BufferedOutputStream zipArchiveInputStream;
        com.up366.common.FileUtilsUp.mkdirParentDir(str2);
        java.io.BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                fileInputStream = new java.io.FileInputStream(str);
                try {
                    zipArchiveInputStream = new org.apache.commons.compress.archivers.zip.ZipArchiveInputStream(fileInputStream, "gbk", true, true);
                } catch (java.lang.Exception e) {
                    e = e;
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                long jAvailable = fileInputStream.available();
                byte[] bArr = new byte[4096];
                int i = -1;
                while (true) {
                    org.apache.commons.compress.archivers.ArchiveEntry nextEntry = zipArchiveInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    java.lang.String name = nextEntry.getName();
                    if (!isEmpty(name)) {
                        java.lang.String strNormalizeEntryName = normalizeEntryName(str, name);
                        if (strNormalizeEntryName.length() == 0) {
                            continue;
                        } else {
                            try {
                                java.io.File fileResolveEntryFile = resolveEntryFile(str, str2, name, strNormalizeEntryName);
                                com.up366.common.FileUtilsUp.mkdirParentDir(fileResolveEntryFile.getPath());
                                if (nextEntry.isDirectory()) {
                                    boolean zMkdirs = fileResolveEntryFile.mkdirs();
                                    if (!zMkdirs && !fileResolveEntryFile.exists()) {
                                        com.up366.common.log.Logger.warn("TAG - ZipHelper - unzip - mkdirs:" + zMkdirs + " " + fileResolveEntryFile.getAbsolutePath());
                                    }
                                } else {
                                    if (fileResolveEntryFile.exists()) {
                                        com.up366.common.FileUtilsUp.deleteDirOrFile(fileResolveEntryFile);
                                    }
                                    java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(fileResolveEntryFile));
                                    while (true) {
                                        try {
                                            int i2 = zipArchiveInputStream.read(bArr);
                                            if (i2 == -1) {
                                                break;
                                            } else {
                                                bufferedOutputStream2.write(bArr, 0, i2);
                                            }
                                        } catch (java.lang.Throwable th2) {
                                            th = th2;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            org.apache.commons.compress.utils.IOUtils.closeQuietly(bufferedOutputStream);
                                            throw th;
                                        }
                                    }
                                    bufferedOutputStream = bufferedOutputStream2;
                                }
                                org.apache.commons.compress.utils.IOUtils.closeQuietly(bufferedOutputStream);
                                int iAvailable = (int) (((jAvailable - ((long) fileInputStream.available())) * 100) / jAvailable);
                                if (iAvailable > i + 10) {
                                    zipCallback.onProgress(iAvailable);
                                    i = iAvailable;
                                }
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                            }
                        }
                    }
                }
                zipCallback.onSuccess();
                org.apache.commons.compress.utils.IOUtils.closeQuietly(zipArchiveInputStream);
            } catch (java.lang.Exception e2) {
                e = e2;
                bufferedOutputStream = zipArchiveInputStream;
                com.up366.common.log.Logger.error("exception path:" + str, e);
                zipCallback.onFail(e);
                org.apache.commons.compress.utils.IOUtils.closeQuietly(bufferedOutputStream);
            } catch (java.lang.Throwable th4) {
                th = th4;
                bufferedOutputStream = zipArchiveInputStream;
                org.apache.commons.compress.utils.IOUtils.closeQuietly(bufferedOutputStream);
                org.apache.commons.compress.utils.IOUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (java.lang.Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        org.apache.commons.compress.utils.IOUtils.closeQuietly(fileInputStream);
    }

    private static void unzipWithExt(java.lang.String str, java.lang.String str2, java.lang.String str3, com.up366.common.download.ZipHelper.ZipCallback zipCallback) {
        com.up366.common.FileUtilsUp.mkdirParentDir(str2);
        try {
            java.io.File file = new java.io.File(str2);
            if (!file.exists() && !file.mkdirs()) {
                com.up366.common.log.Logger.warn("TAG - ZipHelper - unzipWithExt - mkdirs failed:" + file.getAbsolutePath());
            }
            net.lingala.zip4j.ZipFile zipFile = new net.lingala.zip4j.ZipFile(str, str3.toCharArray());
            zipFile.setCharset(java.nio.charset.Charset.forName("GBK"));
            net.lingala.zip4j.model.UnzipParameters unzipParameters = new net.lingala.zip4j.model.UnzipParameters();
            unzipParameters.setExtractSymbolicLinks(false);
            for (net.lingala.zip4j.model.FileHeader fileHeader : zipFile.getFileHeaders()) {
                java.lang.String fileName = fileHeader.getFileName();
                if (!isEmpty(fileName)) {
                    java.lang.String strNormalizeEntryName = normalizeEntryName(str, fileName);
                    if (strNormalizeEntryName.length() != 0) {
                        java.io.File fileResolveEntryFile = resolveEntryFile(str, str2, fileName, strNormalizeEntryName);
                        if (fileHeader.isDirectory()) {
                            if (!fileResolveEntryFile.exists() && !fileResolveEntryFile.mkdirs()) {
                                com.up366.common.log.Logger.warn("TAG - ZipHelper - unzipWithExt - mkdirs failed:" + fileResolveEntryFile.getAbsolutePath());
                            }
                        } else {
                            zipFile.extractFile(fileHeader, str2, strNormalizeEntryName, unzipParameters);
                        }
                    }
                }
            }
            zipCallback.onProgress(100);
            zipCallback.onSuccess();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("exception path:" + str, e);
            zipCallback.onFail(e);
        }
    }

    static java.lang.String normalizeEntryName(java.lang.String str, java.lang.String str2) {
        java.lang.String strReplace = str2.replace('\\', '/');
        if (strReplace.indexOf(0) >= 0) {
            throw new java.lang.IllegalStateException("压缩包中文件名包含相对路径：" + str2 + " zip:" + str);
        }
        if (hasWindowsDrivePrefix(strReplace)) {
            strReplace = strReplace.substring(2);
        }
        java.util.ArrayDeque<java.lang.String> arrayDeque = new java.util.ArrayDeque();
        for (java.lang.String str3 : strReplace.split("/", -1)) {
            if (str3.length() != 0 && !".".equals(str3)) {
                if ("..".equals(str3)) {
                    if (!arrayDeque.isEmpty()) {
                        arrayDeque.removeLast();
                    }
                } else {
                    arrayDeque.addLast(str3);
                }
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str4 : arrayDeque) {
            if (sb.length() > 0) {
                sb.append('/');
            }
            sb.append(str4);
        }
        return sb.toString();
    }

    private static boolean hasWindowsDrivePrefix(java.lang.String str) {
        if (str.length() >= 2) {
            return ((str.charAt(0) >= 'a' && str.charAt(0) <= 'z') || (str.charAt(0) >= 'A' && str.charAt(0) <= 'Z')) && str.charAt(1) == ':';
        }
        return false;
    }

    private static boolean isEmpty(java.lang.String str) {
        return str == null || str.length() == 0;
    }

    private static java.io.File resolveEntryFile(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) throws java.io.IOException {
        java.io.File canonicalFile = new java.io.File(str2).getCanonicalFile();
        java.io.File canonicalFile2 = new java.io.File(canonicalFile, str4).getCanonicalFile();
        java.lang.String path = canonicalFile.getPath();
        java.lang.String path2 = canonicalFile2.getPath();
        if (!path.endsWith(java.io.File.separator)) {
            path = path + java.io.File.separator;
        }
        if (path2.startsWith(path)) {
            return canonicalFile2;
        }
        throw new java.lang.IllegalStateException("压缩包中文件名包含相对路径：" + str3 + " zip:" + str);
    }
}
