package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class DirectoryValidationUtils {
    private static final java.lang.String VALID_FILE = "valid.bin";

    private DirectoryValidationUtils() {
    }

    public static boolean hasDirectoryValidationFiles(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return com.up366.common.FileUtilsUp.isFileExists(com.up366.common.FileUtilsUp.join(str, "checkFile")) || com.up366.common.FileUtilsUp.isFileExists(com.up366.common.FileUtilsUp.join(str, VALID_FILE));
    }

    public static boolean hasChildDirectories(java.lang.String str) {
        java.io.File[] fileArrListFiles;
        if (android.text.TextUtils.isEmpty(str) || !com.up366.common.FileUtilsUp.isDir(str) || (fileArrListFiles = new java.io.File(str).listFiles()) == null) {
            return false;
        }
        for (java.io.File file : fileArrListFiles) {
            if (file != null && file.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    public static void deleteDirectoryValidationFiles(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.up366.common.FileUtilsUp.deleteDirOrFile(com.up366.common.FileUtilsUp.join(str, "checkFile"));
        com.up366.common.FileUtilsUp.deleteDirOrFile(com.up366.common.FileUtilsUp.join(str, VALID_FILE));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean rebuildChildDirectoryValidationFiles(java.lang.String r9, java.util.Set<java.lang.String> r10, boolean r11) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r1 = 0
            if (r0 != 0) goto L64
            boolean r0 = com.up366.common.FileUtilsUp.isDir(r9)
            if (r0 != 0) goto Le
            goto L64
        Le:
            java.io.File r0 = new java.io.File
            r0.<init>(r9)
            java.io.File[] r9 = r0.listFiles()
            r0 = 1
            if (r9 != 0) goto L1b
            return r0
        L1b:
            int r2 = r9.length
            r4 = r0
            r3 = r1
        L1e:
            if (r3 >= r2) goto L63
            r5 = r9[r3]
            if (r5 == 0) goto L60
            boolean r6 = r5.isDirectory()
            if (r6 != 0) goto L2b
            goto L60
        L2b:
            java.lang.String r6 = r5.getAbsolutePath()
            if (r11 != 0) goto L59
            if (r10 == 0) goto L3f
            java.lang.String r5 = r5.getName()
            boolean r5 = r10.contains(r5)
            if (r5 == 0) goto L3f
            r5 = r0
            goto L40
        L3f:
            r5 = r1
        L40:
            java.lang.String r7 = "checkFile"
            java.lang.String[] r7 = new java.lang.String[]{r6, r7}
            java.lang.String r7 = com.up366.common.FileUtilsUp.join(r7)
            boolean r7 = com.up366.common.FileUtilsUp.isFileExists(r7)
            boolean r8 = com.up366.common.utils.EncryptUtil.valid(r6)
            if (r5 == 0) goto L59
            if (r7 == 0) goto L59
            if (r8 == 0) goto L59
            goto L60
        L59:
            boolean r5 = generateDirectoryValidationFiles(r6)
            if (r5 != 0) goto L60
            r4 = r1
        L60:
            int r3 = r3 + 1
            goto L1e
        L63:
            return r4
        L64:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.utils.DirectoryValidationUtils.rebuildChildDirectoryValidationFiles(java.lang.String, java.util.Set, boolean):boolean");
    }

    public static boolean generateDirectoryValidationFiles(java.lang.String str) throws java.lang.Throwable {
        java.lang.String strJoin = com.up366.common.FileUtilsUp.join(str, "checkFile");
        java.lang.String strJoin2 = com.up366.common.FileUtilsUp.join(str, VALID_FILE);
        try {
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin);
            com.up366.common.FileUtilsUp.deleteDirOrFile(strJoin2);
            boolean zGenerateValid = com.up366.common.utils.EncryptUtil.generateValid(str);
            com.up366.common.log.Logger.info("TAG - DirectoryValidationUtils - generateDirectoryValidationFiles - generateValid dirPath:" + str + " result:" + zGenerateValid);
            if (zGenerateValid && com.up366.common.FileUtilsUp.isFileExists(strJoin2)) {
                com.up366.common.FileUtilsUp.saveContentToFile(strJoin, buildDirectoryCheckContent(str));
                boolean z = com.up366.common.FileUtilsUp.isFileExists(strJoin2) && com.up366.common.utils.EncryptUtil.valid(str);
                if (!z) {
                    com.up366.common.log.Logger.error("TAG - DirectoryValidationUtils - generateDirectoryValidationFiles - verify failed path:" + str + " err:" + com.up366.common.utils.EncryptUtil.errMsg());
                }
                return z;
            }
            com.up366.common.log.Logger.error("TAG - DirectoryValidationUtils - generateDirectoryValidationFiles - valid not exists path:" + strJoin2 + " err:" + com.up366.common.utils.EncryptUtil.errMsg());
            return false;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - DirectoryValidationUtils - generateDirectoryValidationFiles - error path:" + str, e);
            return false;
        }
    }

    private static java.lang.String buildDirectoryCheckContent(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        collectDirectoryCheckEntries(new java.io.File(str), "", arrayList);
        java.util.Collections.sort(arrayList);
        return com.up366.common.digest.MD5.md5(android.text.TextUtils.join("\n", arrayList));
    }

    private static void collectDirectoryCheckEntries(java.io.File file, java.lang.String str, java.util.List<java.lang.String> list) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            java.io.File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            for (java.io.File file2 : fileArrListFiles) {
                if (file2 != null) {
                    java.lang.String name = file2.getName();
                    if (!"checkFile".equals(name) && !VALID_FILE.equals(name)) {
                        if (!android.text.TextUtils.isEmpty(str)) {
                            name = str + "/" + name;
                        }
                        collectDirectoryCheckEntries(file2, name, list);
                    }
                }
            }
            return;
        }
        list.add(str + ":" + file.length());
    }
}
