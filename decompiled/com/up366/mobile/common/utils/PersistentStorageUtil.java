package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PersistentStorageUtil {
    private static final java.lang.String FILE_ID_PREFIX = "persistent_";
    private static final java.lang.String FILE_NAME = "up366.cache";

    public static boolean savePersistentData(android.content.Context context, java.lang.String str) {
        if (str == null || str.isEmpty()) {
            com.up366.common.log.Logger.info("Attempted to save null or empty key");
            return false;
        }
        java.lang.String uniqueFileName = getUniqueFileName(context);
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return saveUsingMediaStore(context, uniqueFileName, str);
        }
        return saveUsingLegacyMethod(context, uniqueFileName, str);
    }

    public static java.lang.String readPersistentData(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            return readUsingMediaStore(context);
        }
        return readUsingLegacyMethod(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.OutputStream] */
    private static boolean saveUsingMediaStore(android.content.Context context, java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        android.net.Uri uriInsert;
        java.io.OutputStream outputStreamOpenOutputStream;
        android.content.ContentResolver contentResolver = context.getContentResolver();
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", "application/octet-stream");
        contentValues.put("relative_path", android.os.Environment.DIRECTORY_DOWNLOADS);
        ?? r3 = 0;
        try {
            try {
                try {
                    deleteExistingMediaStoreFiles(context);
                    uriInsert = contentResolver.insert(android.provider.MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);
                    try {
                        if (uriInsert == null) {
                            com.up366.common.log.Logger.error("Failed to create MediaStore entry");
                            return false;
                        }
                        outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
                        try {
                            if (outputStreamOpenOutputStream == null) {
                                com.up366.common.log.Logger.error("Failed to open output stream for MediaStore");
                                if (outputStreamOpenOutputStream != null) {
                                    try {
                                        outputStreamOpenOutputStream.close();
                                    } catch (java.io.IOException unused) {
                                    }
                                }
                                return false;
                            }
                            outputStreamOpenOutputStream.write(str2.getBytes());
                            outputStreamOpenOutputStream.flush();
                            if (outputStreamOpenOutputStream == null) {
                                return true;
                            }
                            try {
                                outputStreamOpenOutputStream.close();
                                return true;
                            } catch (java.io.IOException unused2) {
                                return true;
                            }
                        } catch (java.io.IOException e) {
                            e = e;
                            com.up366.common.log.Logger.error("Error writing to MediaStore: " + e.getMessage());
                            if (uriInsert != null) {
                                contentResolver.delete(uriInsert, null, null);
                            }
                            if (outputStreamOpenOutputStream != null) {
                                try {
                                    outputStreamOpenOutputStream.close();
                                } catch (java.io.IOException unused3) {
                                }
                            }
                            return false;
                        }
                    } catch (java.io.IOException e2) {
                        e = e2;
                        outputStreamOpenOutputStream = null;
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (r3 != 0) {
                        try {
                            r3.close();
                        } catch (java.io.IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (java.io.IOException e3) {
                e = e3;
                uriInsert = null;
                outputStreamOpenOutputStream = null;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            r3 = contentValues;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String readUsingMediaStore(android.content.Context r9) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.utils.PersistentStorageUtil.readUsingMediaStore(android.content.Context):java.lang.String");
    }

    private static boolean saveUsingLegacyMethod(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.io.File externalStoragePublicDirectory = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS);
        if ((externalStoragePublicDirectory == null || !externalStoragePublicDirectory.exists()) && !externalStoragePublicDirectory.mkdirs()) {
            com.up366.common.log.Logger.error("Failed to create Downloads directory");
            return false;
        }
        java.io.File file = new java.io.File(externalStoragePublicDirectory, str);
        deleteExistingLegacyFiles(context);
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            try {
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                return true;
            } finally {
            }
        } catch (java.io.IOException e) {
            com.up366.common.log.Logger.error("Error writing to file: " + e.getMessage());
            if (file.exists() && !file.delete()) {
                com.up366.common.log.Logger.info("Failed to delete corrupted file");
            }
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:14|(8:49|15|48|16|52|17|(7:18|(1:20)(1:60)|36|50|37|57|41)|21)|(5:23|55|24|25|26)(4:27|28|59|44)|36|50|37|57|41) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String readUsingLegacyMethod(android.content.Context r8) {
        /*
            java.lang.String r0 = android.os.Environment.DIRECTORY_DOWNLOADS
            java.io.File r0 = android.os.Environment.getExternalStoragePublicDirectory(r0)
            r1 = 0
            if (r0 == 0) goto L9b
            boolean r2 = r0.exists()
            if (r2 != 0) goto L11
            goto L9b
        L11:
            java.lang.String r8 = getUniqueFileName(r8)
            com.up366.mobile.common.utils.PersistentStorageUtil$$ExternalSyntheticLambda1 r2 = new com.up366.mobile.common.utils.PersistentStorageUtil$$ExternalSyntheticLambda1
            r2.<init>()
            java.io.File[] r8 = r0.listFiles(r2)
            if (r8 == 0) goto L9b
            int r0 = r8.length
            if (r0 != 0) goto L25
            goto L9b
        L25:
            com.up366.mobile.common.utils.PersistentStorageUtil$$ExternalSyntheticLambda2 r0 = new com.up366.mobile.common.utils.PersistentStorageUtil$$ExternalSyntheticLambda2
            r0.<init>()
            java.util.Arrays.sort(r8, r0)
            int r0 = r8.length
            r2 = 0
        L2f:
            if (r2 >= r0) goto L9b
            r3 = r8[r2]
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.io.IOException -> L82
            r4.<init>(r3)     // Catch: java.io.IOException -> L82
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L78
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L78
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L78
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L78
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e
            r6.<init>()     // Catch: java.lang.Throwable -> L6e
        L47:
            java.lang.String r7 = r5.readLine()     // Catch: java.lang.Throwable -> L6e
            if (r7 == 0) goto L51
            r6.append(r7)     // Catch: java.lang.Throwable -> L6e
            goto L47
        L51:
            int r7 = r6.length()     // Catch: java.lang.Throwable -> L6e
            if (r7 <= 0) goto L67
            java.lang.String r7 = "Successfully read persistent data from legacy storage"
            com.up366.common.log.Logger.info(r7)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L6e
            r5.close()     // Catch: java.lang.Throwable -> L78
            r4.close()     // Catch: java.io.IOException -> L82
            return r6
        L67:
            r5.close()     // Catch: java.lang.Throwable -> L78
            r4.close()     // Catch: java.io.IOException -> L82
            goto L98
        L6e:
            r6 = move-exception
            r5.close()     // Catch: java.lang.Throwable -> L73
            goto L77
        L73:
            r5 = move-exception
            r6.addSuppressed(r5)     // Catch: java.lang.Throwable -> L78
        L77:
            throw r6     // Catch: java.lang.Throwable -> L78
        L78:
            r5 = move-exception
            r4.close()     // Catch: java.lang.Throwable -> L7d
            goto L81
        L7d:
            r4 = move-exception
            r5.addSuppressed(r4)     // Catch: java.io.IOException -> L82
        L81:
            throw r5     // Catch: java.io.IOException -> L82
        L82:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Failed to read file: "
            r5.<init>(r6)
            java.lang.String r3 = r3.getName()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            com.up366.common.log.Logger.info(r3, r4)
        L98:
            int r2 = r2 + 1
            goto L2f
        L9b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.utils.PersistentStorageUtil.readUsingLegacyMethod(android.content.Context):java.lang.String");
    }

    private static java.lang.String getUniqueFileName(android.content.Context context) {
        return (FILE_ID_PREFIX + context.getPackageName() + "_") + FILE_NAME;
    }

    private static void deleteExistingMediaStoreFiles(android.content.Context context) {
        android.content.ContentResolver contentResolver = context.getContentResolver();
        java.lang.String uniqueFileName = getUniqueFileName(context);
        try {
            int iDelete = contentResolver.delete(android.provider.MediaStore.Downloads.EXTERNAL_CONTENT_URI, "_display_name LIKE ?", new java.lang.String[]{uniqueFileName + "%"});
            if (iDelete > 0) {
                com.up366.common.log.Logger.info("Deleted " + iDelete + " old MediaStore files");
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.info("Error deleting old MediaStore files: " + e.getMessage());
        }
    }

    private static void deleteExistingLegacyFiles(android.content.Context context) {
        java.io.File externalStoragePublicDirectory = android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS);
        if (externalStoragePublicDirectory == null || !externalStoragePublicDirectory.exists()) {
            return;
        }
        final java.lang.String uniqueFileName = getUniqueFileName(context);
        java.io.File[] fileArrListFiles = externalStoragePublicDirectory.listFiles(new java.io.FilenameFilter() { // from class: com.up366.mobile.common.utils.PersistentStorageUtil$$ExternalSyntheticLambda3
            @Override // java.io.FilenameFilter
            public final boolean accept(java.io.File file, java.lang.String str) {
                return str.startsWith(uniqueFileName);
            }
        });
        if (fileArrListFiles == null) {
            return;
        }
        int i = 0;
        for (java.io.File file : fileArrListFiles) {
            if (file.delete()) {
                i++;
            } else {
                com.up366.common.log.Logger.info("Failed to delete old file: " + file.getName());
            }
        }
        if (i > 0) {
            com.up366.common.log.Logger.info("Deleted " + i + " old legacy files");
        }
    }
}
