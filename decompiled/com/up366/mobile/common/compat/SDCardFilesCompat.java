package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SDCardFilesCompat {
    private final android.app.Application context;

    private SDCardFilesCompat(android.app.Application application) {
        this.context = application;
    }

    public static void compat(android.app.Application application) {
        try {
            new com.up366.mobile.common.compat.SDCardFilesCompat(application).compat();
        } catch (java.lang.Throwable th) {
            com.up366.common.log.Logger.error("TAG - SDCardFilesCompat - compat - ", th);
        }
    }

    private void compat() throws java.lang.Throwable {
        if (hasCompat() || noStoragePermission()) {
            return;
        }
        copyDirFiles("/mnt/sdcard/Up366Mobile/flipbook/flipbooks", com.up366.mobile.common.utils.AppFileUtils.getFilpbookDir());
        java.io.File[] fileArrListFiles = new java.io.File("/mnt/sdcard/Up366Mobile/").listFiles();
        if (fileArrListFiles != null) {
            for (java.io.File file : fileArrListFiles) {
                if (file.getName().matches("\\d+")) {
                    copyDirFiles(file.getAbsolutePath(), com.up366.mobile.common.utils.AppFileUtils.getAppInternalFilesDir() + "/" + file.getName());
                }
            }
        }
        updateHasCompat();
    }

    private void copyDirFiles(java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        com.up366.common.log.Logger.info("TAG - SDCardFilesCompat - copyDirFiles - src = [" + str + "], dst = [" + str2 + "]");
        com.up366.common.FileUtilsUp.copyFileOrDir(str, str2);
    }

    private boolean noStoragePermission() {
        return androidx.core.content.ContextCompat.checkSelfPermission(this.context, com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE) == -1;
    }

    private boolean hasCompat() {
        return com.up366.mobile.common.utils.PreferenceUtils.getBoolean("SDCardFilesCompat-has-compat", false);
    }

    private void updateHasCompat() {
        com.up366.mobile.common.utils.PreferenceUtils.putBoolean("SDCardFilesCompat-has-compat", true);
        com.up366.common.log.Logger.info("TAG - SDCardFilesCompat - updateHasCompat - success");
    }
}
