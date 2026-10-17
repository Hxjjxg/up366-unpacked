package com.up366.common;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class FileUtilsUpV2 {
    private FileUtilsUpV2() {
    }

    public static boolean exists(java.io.File file) {
        return file != null && file.exists();
    }

    public static boolean isFile(java.io.File file) {
        return exists(file) && file.isFile();
    }

    public static boolean isDir(java.io.File file) {
        return exists(file) && file.isDirectory();
    }

    public static boolean ensureParentDir(java.io.File file) {
        java.io.File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null) {
            return false;
        }
        if (parentFile.exists()) {
            return parentFile.isDirectory();
        }
        return parentFile.mkdirs();
    }

    public static boolean ensureDir(java.io.File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isDirectory();
        }
        return file.mkdirs();
    }

    public static boolean delete(java.io.File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        java.io.File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (java.io.File file2 : fileArrListFiles) {
                delete(file2);
            }
        }
        return file.delete();
    }

    public static void copy(java.io.File file, java.io.File file2) throws java.io.IOException {
        java.util.Objects.requireNonNull(file);
        java.util.Objects.requireNonNull(file2);
        if (!file.exists()) {
            throw new java.io.IOException("Source not exists: " + file);
        }
        if (file.isDirectory()) {
            ensureDir(file2);
            java.io.File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (java.io.File file3 : fileArrListFiles) {
                    copy(file3, new java.io.File(file2, file3.getName()));
                }
                return;
            }
            return;
        }
        ensureParentDir(file2);
        java.nio.channels.FileChannel channel = new java.io.FileInputStream(file).getChannel();
        try {
            java.nio.channels.FileChannel channel2 = new java.io.FileOutputStream(file2).getChannel();
            try {
                channel.transferTo(0L, channel.size(), channel2);
                if (channel2 != null) {
                    channel2.close();
                }
                if (channel != null) {
                    channel.close();
                }
            } finally {
            }
        } catch (java.lang.Throwable th) {
            if (channel != null) {
                try {
                    channel.close();
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void copyFromAssets(android.content.Context context, java.lang.String str, java.io.File file) throws java.io.IOException {
        ensureParentDir(file);
        java.io.InputStream inputStreamOpen = context.getAssets().open(str);
        try {
            java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = inputStreamOpen.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, i);
                    }
                }
                bufferedOutputStream.close();
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
            } finally {
            }
        } catch (java.lang.Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (java.lang.Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static java.io.File appExternalDir(android.content.Context context, java.lang.String str) {
        java.io.File externalFilesDir = context.getExternalFilesDir(null);
        if (android.text.TextUtils.isEmpty(str)) {
            return externalFilesDir;
        }
        java.io.File file = new java.io.File(externalFilesDir, str);
        ensureDir(file);
        return file;
    }

    public static android.net.Uri getUri(android.content.Context context, java.io.File file) {
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            return androidx.core.content.FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
        }
        return android.net.Uri.fromFile(file);
    }
}
