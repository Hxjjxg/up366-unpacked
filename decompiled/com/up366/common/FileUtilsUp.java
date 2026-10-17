package com.up366.common;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FileUtilsUp {
    private static final int BUFFER_SIZE = 2048;
    public static final java.lang.String CHECK_FILE = "checkFile";
    private static com.up366.common.task.TaskExecutor executor;

    public static boolean isFileExists(java.lang.String str) {
        if (str == null) {
            return false;
        }
        return new java.io.File(str).exists();
    }

    public static boolean isFileExists(java.io.File file) {
        if (file == null) {
            return false;
        }
        return file.exists();
    }

    public static boolean mkdirParentDir(java.io.File file) {
        return mkdirParentDir(file.getAbsolutePath());
    }

    public static boolean mkdirParentDir(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return false;
        }
        return com.up366.common.FileUtilsUpV2.ensureParentDir(new java.io.File(str));
    }

    public static void deleteDirOrFile(java.io.File file) {
        if (file != null) {
            deleteDirOrFile(file.getAbsolutePath());
        }
    }

    public static void deleteDirOrFile(java.lang.String str) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str)) {
            return;
        }
        boolean zRenameTo = false;
        if (str.endsWith(java.io.File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            com.up366.common.log.Logger.info("delete file " + str + " is not exist!");
            return;
        }
        if (file.isFile()) {
            deleteFile(file);
            return;
        }
        java.lang.String string = str + "_tmp_";
        int i = 0;
        while (true) {
            if (isFileExists(string)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(str);
                sb.append("_tmp_");
                int i2 = i + 1;
                sb.append(i);
                string = sb.toString();
                if (i2 > 30) {
                    com.up366.common.global.GB.get().sendLog("base_delete_file_rename_seq", "tmp file seqNo:" + i2);
                }
                if (i2 > 100) {
                    string = str + "_tmp_" + i2 + java.lang.Math.random();
                    break;
                }
                i = i2;
            }
        }
        try {
            zRenameTo = file.renameTo(new java.io.File(string));
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("deleteDirOrFile rename error  " + e.getMessage(), e);
        }
        if (zRenameTo) {
            cleanFilesInBackgroundThread(string);
            return;
        }
        com.up366.common.log.Logger.warn("TAG - FileUtilsUp - deleteDirOrFile - in origin thread : " + string);
        deleteDirectoryAndFiles(new java.io.File(string));
    }

    private static void cleanFilesInBackgroundThread(final java.lang.String str) {
        if (executor == null) {
            executor = com.up366.common.task.TaskUtils.createSerialExecutor("deleteTemp");
        }
        executor.post(new com.up366.common.task.Task() { // from class: com.up366.common.FileUtilsUp$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.common.FileUtilsUp.deleteDirectoryAndFiles(new java.io.File(str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void deleteDirectoryAndFiles(java.io.File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                deleteFile(file);
                return;
            }
            java.io.File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (java.io.File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        deleteDirectoryAndFiles(file2);
                    } else {
                        deleteFile(file2);
                    }
                }
            }
            deleteFile(file);
        }
    }

    private static void deleteFile(java.io.File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        com.up366.common.log.Logger.error("TAG - FileUtilsUp - deleteFile - error : " + file.getAbsolutePath());
    }

    public static long getExternalStoreAvailableSize() {
        try {
            if (!storageIsWritable()) {
                return 1073741824L;
            }
            android.os.StatFs statFs = new android.os.StatFs(android.os.Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getExternalStoreAvailableSize error " + e.getMessage(), e);
            return 1073741824L;
        }
    }

    private static boolean storageIsWritable() {
        boolean z;
        boolean z2;
        java.lang.String externalStorageState = android.os.Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            z = true;
        } else {
            if ("mounted_ro".equals(externalStorageState)) {
                z2 = false;
                z = true;
                return z && z2;
            }
            z = false;
        }
        z2 = z;
        if (z) {
            return false;
        }
    }

    public static void copyFileOrDir(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        if (com.up366.common.StringUtils.isEmptyOrNull(str) || com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            com.up366.common.log.Logger.error("copyFileOrDir error srcDir" + str);
            return;
        }
        copyFileOrDir(new java.io.File(str), new java.io.File(str2));
    }

    public static void copyFileOrDir(java.io.File file, java.io.File file2) throws java.lang.Throwable {
        if (isFileExists(file)) {
            if (file.isFile()) {
                mkdirParentDir(file2.getPath());
                nioTransferCopy(file, file2);
                return;
            }
            for (java.io.File file3 : file.listFiles()) {
                copyFileOrDir(file3, new java.io.File(join(file2.getAbsolutePath(), file3.getName())));
            }
        } else {
            com.up366.common.log.Logger.error("copyFileOrDir error 文件不存在 srcFile " + file);
        }
    }

    private static void nioTransferCopy(java.io.File file, java.io.File file2) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        java.nio.channels.FileChannel channel;
        java.nio.channels.FileChannel fileChannel;
        java.io.FileOutputStream fileOutputStream2;
        java.io.FileInputStream fileInputStream;
        java.nio.channels.FileChannel fileChannel2;
        java.io.FileInputStream fileInputStream2;
        java.io.FileInputStream fileInputStream3 = null;
        channel = null;
        java.nio.channels.FileChannel channel2 = null;
        fileChannel = null;
        fileChannel = null;
        java.nio.channels.FileChannel fileChannel3 = null;
        try {
            fileInputStream = new java.io.FileInputStream(file);
            try {
                fileOutputStream = new java.io.FileOutputStream(file2);
                try {
                    channel = fileInputStream.getChannel();
                } catch (java.io.IOException e) {
                    e = e;
                    fileOutputStream2 = fileOutputStream;
                    fileChannel = null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    channel = null;
                    fileInputStream3 = fileInputStream;
                    fileChannel2 = channel;
                    com.up366.common.IOUtils.close(fileInputStream3);
                    com.up366.common.IOUtils.close(channel);
                    com.up366.common.IOUtils.close(fileOutputStream);
                    com.up366.common.IOUtils.close(fileChannel2);
                    throw th;
                }
            } catch (java.io.IOException e2) {
                e = e2;
                fileChannel = null;
                fileOutputStream2 = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream = null;
                channel = null;
            }
        } catch (java.io.IOException e3) {
            e = e3;
            fileChannel = null;
            fileOutputStream2 = null;
            fileInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
            channel = null;
        }
        try {
            channel2 = fileOutputStream.getChannel();
            channel.transferTo(0L, channel.size(), channel2);
            com.up366.common.IOUtils.close(fileInputStream);
            com.up366.common.IOUtils.close(channel);
            com.up366.common.IOUtils.close(fileOutputStream);
            com.up366.common.IOUtils.close(channel2);
        } catch (java.io.IOException e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            fileChannel = channel2;
            fileChannel3 = channel;
            try {
                com.up366.common.log.Logger.error("nioTransferCopy error : " + e.getMessage(), e);
                com.up366.common.IOUtils.close(fileInputStream);
                com.up366.common.IOUtils.close(fileChannel3);
                com.up366.common.IOUtils.close(fileOutputStream2);
                com.up366.common.IOUtils.close(fileChannel);
            } catch (java.lang.Throwable th4) {
                th = th4;
                fileInputStream2 = fileInputStream;
                fileChannel2 = fileChannel;
                fileOutputStream = fileOutputStream2;
                channel = fileChannel3;
                fileInputStream3 = fileInputStream2;
                com.up366.common.IOUtils.close(fileInputStream3);
                com.up366.common.IOUtils.close(channel);
                com.up366.common.IOUtils.close(fileOutputStream);
                com.up366.common.IOUtils.close(fileChannel2);
                throw th;
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
            fileInputStream2 = fileInputStream;
            fileChannel2 = channel2;
            fileInputStream3 = fileInputStream2;
            com.up366.common.IOUtils.close(fileInputStream3);
            com.up366.common.IOUtils.close(channel);
            com.up366.common.IOUtils.close(fileOutputStream);
            com.up366.common.IOUtils.close(fileChannel2);
            throw th;
        }
    }

    public static boolean renameFile(java.lang.String str, java.lang.String str2) {
        if (com.up366.common.StringUtils.isEmptyOrNull(str) || com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            return false;
        }
        java.io.File file = new java.io.File(str);
        if (!file.exists()) {
            return false;
        }
        file.renameTo(new java.io.File(str2));
        return true;
    }

    public static android.net.Uri getUriForFile(java.io.File file) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return androidx.core.content.FileProvider.getUriForFile(com.up366.common.global.GB.get().getApplicationContext(), com.up366.common.global.GB.get().getApplicationId(), file);
        }
        return android.net.Uri.fromFile(file);
    }

    public static boolean isCheckFileExists(java.lang.String str) {
        return isFileExists(join(str, "checkFile"));
    }

    public static void deleteCheckFileUnderPath(java.lang.String str) {
        try {
            deleteDirOrFile(join(str, "checkFile"));
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("create checkfile error : " + e.getMessage(), e);
        }
    }

    public static void saveContentToFile(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        if (str2 == null) {
            return;
        }
        java.io.File file = new java.io.File(str);
        if (mkdirParentDir(str)) {
            java.io.FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new java.io.FileOutputStream(file);
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.io.FileNotFoundException e) {
                e = e;
            } catch (java.io.IOException e2) {
                e = e2;
            }
            try {
                fileOutputStream.write(str2.getBytes());
                com.up366.common.IOUtils.close(fileOutputStream);
            } catch (java.io.FileNotFoundException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                com.up366.common.log.Logger.error("saveContentToFile FileNotFoundException error" + e.getLocalizedMessage());
                com.up366.common.IOUtils.close(fileOutputStream2);
            } catch (java.io.IOException e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                com.up366.common.log.Logger.error("saveContentToFile IOException error" + e.getLocalizedMessage());
                com.up366.common.IOUtils.close(fileOutputStream2);
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.up366.common.IOUtils.close(fileOutputStream2);
                throw th;
            }
        }
    }

    public static java.lang.String getFileContent(java.lang.String str) throws java.lang.Throwable {
        java.io.FileInputStream fileInputStream;
        java.io.File file = new java.io.File(str);
        java.lang.String str2 = null;
        str2 = null;
        str2 = null;
        java.io.FileInputStream fileInputStream2 = null;
        str2 = null;
        if (file.exists() && file.canRead()) {
            try {
                fileInputStream = new java.io.FileInputStream(file);
                try {
                    try {
                        byte[] bArr = new byte[fileInputStream.available()];
                        if (fileInputStream.read(bArr) != -1) {
                            str2 = new java.lang.String(bArr, "UTF-8");
                        }
                    } catch (java.io.IOException unused) {
                        com.up366.common.log.Logger.error("read file : '" + str + "' error ...");
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    com.up366.common.IOUtils.close(fileInputStream2);
                    throw th;
                }
            } catch (java.io.IOException unused2) {
                fileInputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                com.up366.common.IOUtils.close(fileInputStream2);
                throw th;
            }
            com.up366.common.IOUtils.close(fileInputStream);
        }
        return str2;
    }

    public static java.lang.String getAssetFile(java.lang.String str) throws java.lang.Throwable {
        java.io.InputStream inputStreamOpen;
        java.io.InputStream inputStream = null;
        str = null;
        java.lang.String str2 = null;
        try {
            try {
                inputStreamOpen = com.up366.common.global.GB.get().getApplicationContext().getAssets().open(str);
                try {
                    byte[] bArr = new byte[inputStreamOpen.available()];
                    if (inputStreamOpen.read(bArr) != -1) {
                        str2 = new java.lang.String(bArr, "UTF-8");
                    }
                } catch (java.io.IOException unused) {
                    com.up366.common.log.Logger.error("file : '" + str + "' not found ...");
                }
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream = inputStreamOpen;
                com.up366.common.IOUtils.close(inputStream);
                throw th;
            }
        } catch (java.io.IOException unused2) {
            inputStreamOpen = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            com.up366.common.IOUtils.close(inputStream);
            throw th;
        }
        com.up366.common.IOUtils.close(inputStreamOpen);
        return str2;
    }

    public static boolean zip(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.io.File file;
        java.util.zip.ZipOutputStream zipOutputStream;
        java.util.zip.ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                file = new java.io.File(str);
                zipOutputStream = new java.util.zip.ZipOutputStream(new java.io.BufferedOutputStream(new java.io.FileOutputStream(new java.io.File(str2)), 2048));
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            boolean zZipFile = zipFile(file, zipOutputStream, "");
            zipOutputStream.flush();
            com.up366.common.IOUtils.close(zipOutputStream);
            return zZipFile;
        } catch (java.lang.Exception e2) {
            e = e2;
            zipOutputStream2 = zipOutputStream;
            com.up366.common.log.Logger.error("zip file error " + e.getMessage(), e);
            com.up366.common.IOUtils.close(zipOutputStream2);
            return false;
        } catch (java.lang.Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            com.up366.common.IOUtils.close(zipOutputStream2);
            throw th;
        }
    }

    private static boolean zipFile(java.io.File file, java.util.zip.ZipOutputStream zipOutputStream, java.lang.String str) throws java.lang.Throwable {
        java.io.BufferedInputStream bufferedInputStream = null;
        try {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(str);
                sb.append(str.trim().length() == 0 ? "" : java.io.File.separator);
                sb.append(file.getName());
                java.lang.String string = sb.toString();
                if (file.isDirectory()) {
                    for (java.io.File file2 : file.listFiles()) {
                        zipFile(file2, zipOutputStream, string);
                    }
                } else {
                    byte[] bArr = new byte[2048];
                    java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(file), 2048);
                    try {
                        zipOutputStream.putNextEntry(new java.util.zip.ZipEntry(string));
                        while (true) {
                            int i = bufferedInputStream2.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, i);
                        }
                        bufferedInputStream = bufferedInputStream2;
                    } catch (java.lang.Exception e) {
                        e = e;
                        bufferedInputStream = bufferedInputStream2;
                        com.up366.common.log.Logger.error("zipFile error " + e.getMessage(), e);
                        com.up366.common.IOUtils.close(bufferedInputStream);
                        return false;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        com.up366.common.IOUtils.close(bufferedInputStream);
                        throw th;
                    }
                }
                com.up366.common.IOUtils.close(bufferedInputStream);
                return true;
            } catch (java.lang.Exception e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static boolean isFile(java.lang.String str) {
        return isFileExists(str) && new java.io.File(str).isFile();
    }

    public static boolean isDir(java.lang.String str) {
        return isFileExists(str) && new java.io.File(str).isDirectory();
    }

    public static long getFileSize(java.lang.String str) {
        if (str == null) {
            return 0L;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists() && file.isFile()) {
            return file.length();
        }
        return 0L;
    }

    public static java.lang.String join(java.lang.String... strArr) {
        if (strArr == null) {
            return ".";
        }
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList();
        for (java.lang.String str : strArr) {
            if (str != null && str.trim().length() > 0) {
                arrayList.add(str.trim());
            }
        }
        if (arrayList.size() == 0) {
            return ".";
        }
        java.lang.String str2 = (java.lang.String) arrayList.get(0);
        java.lang.String str3 = (java.lang.String) arrayList.get(arrayList.size() - 1);
        boolean z = str2.startsWith("/") || str2.startsWith("\\");
        boolean z2 = str3.endsWith("/") || str3.endsWith("\\");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((java.lang.String) it.next());
            sb.append("/");
        }
        java.lang.String[] strArrSplit = sb.toString().split("[/|\\\\]");
        arrayList.clear();
        for (java.lang.String str4 : strArrSplit) {
            if (str4.trim().length() > 0) {
                arrayList.add(str4);
            }
        }
        java.util.ArrayList<java.lang.String> arrayList2 = new java.util.ArrayList();
        if (z) {
            arrayList2.add(0, "/");
        }
        for (java.lang.String str5 : arrayList) {
            str5.hashCode();
            if (!str5.equals(".")) {
                if (str5.equals("..")) {
                    if (arrayList2.size() == 0) {
                        if (z) {
                            arrayList2.add(0, "/");
                        } else {
                            arrayList2.add(0, ".");
                        }
                    } else if (arrayList2.size() != 1) {
                        arrayList2.remove(arrayList2.size() - 1);
                    } else if (z) {
                        arrayList2.set(0, "/");
                    } else {
                        arrayList2.set(0, ".");
                    }
                } else {
                    arrayList2.add(str5);
                }
            }
        }
        if (z2) {
            arrayList2.add("/");
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        for (java.lang.String str6 : arrayList2) {
            sb2.append(str6);
            if (!"/".equals(str6)) {
                sb2.append("/");
            }
        }
        sb2.deleteCharAt(sb2.length() - 1);
        return sb2.toString();
    }

    public static void addFileVersion(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        java.io.FileOutputStream fileOutputStream;
        if (!str.endsWith(java.io.File.separator)) {
            str = str + java.io.File.separator;
        }
        java.lang.String str3 = str + "checkFile";
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                java.io.File file = new java.io.File(str3);
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new java.io.FileOutputStream(file);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Exception unused) {
        }
        try {
            fileOutputStream.write(str2.getBytes("UTF-8"));
            fileOutputStream.flush();
            com.up366.common.IOUtils.close(fileOutputStream);
        } catch (java.lang.Exception unused2) {
            fileOutputStream2 = fileOutputStream;
            com.up366.common.log.Logger.warn("addFileVersion : '" + str3 + "' with '" + str2 + "' error ...");
            com.up366.common.IOUtils.close(fileOutputStream2);
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            com.up366.common.IOUtils.close(fileOutputStream2);
            throw th;
        }
    }

    public static java.lang.String getFileExtension(java.lang.String str) {
        java.lang.String name;
        int iLastIndexOf;
        return (android.text.TextUtils.isEmpty(str) || (iLastIndexOf = (name = new java.io.File(str).getName()).lastIndexOf(46)) == -1) ? "" : name.substring(iLastIndexOf + 1);
    }

    public static java.lang.String getFileName(java.lang.String str) {
        return new java.io.File(str).getName();
    }
}
