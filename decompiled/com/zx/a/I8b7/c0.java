package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class c0 {

    public static class a {
        public static final com.zx.a.I8b7.c0 a = new com.zx.a.I8b7.c0();
    }

    public com.zx.module.base.ZXModule a(android.content.Context context) {
        com.zx.module.base.ZXModule zXModule = null;
        try {
            com.zx.a.I8b7.x3.a = context;
            com.zx.a.I8b7.w2.a.a.a.a("3.3.7.58976");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(context.getFilesDir().getAbsolutePath());
            java.lang.String str = java.io.File.separator;
            sb.append(str);
            sb.append("zx-core-3.3.7.58976.zip");
            java.lang.String string = sb.toString();
            java.lang.String str2 = context.getFilesDir().getAbsolutePath() + str + "zx-core-3.3.7.58976";
            java.io.File file = new java.io.File(str2);
            java.io.File file2 = new java.io.File(string);
            if (file2.exists()) {
                file.delete();
                a(file2, file);
                java.io.File file3 = new java.io.File(str2 + str + "classes.jar");
                com.zx.module.base.ZXModule zXModule2 = (com.zx.module.base.ZXModule) new com.zx.a.I8b7.a0(file3.getAbsolutePath(), str2, null).b().newInstance();
                java.lang.String str3 = str2 + str + "libzx-core-d.so";
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, str3);
                zXModule2.invoke("loadLib", jSONObject.toString());
                com.zx.a.I8b7.i4.f.a.b.execute(new com.zx.a.I8b7.b0(this, file3, str3, file2, file));
                zXModule = zXModule2;
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
        return zXModule == null ? new com.zx.a.I8b7.u2() : zXModule;
    }

    public static void a(java.io.File file, java.io.File file2) throws java.io.IOException {
        java.util.zip.ZipInputStream zipInputStream = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(file)));
        try {
            byte[] bArr = new byte[io.objectbox.model.PropertyFlags.UNSIGNED];
            while (true) {
                java.util.zip.ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    java.io.File file3 = new java.io.File(file2, nextEntry.getName().replaceFirst("^\\./", ""));
                    java.io.File parentFile = nextEntry.isDirectory() ? file3 : file3.getParentFile();
                    if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
                        throw new java.io.FileNotFoundException("Failed to ensure directory: " + parentFile.getAbsolutePath());
                    }
                    if (!nextEntry.isDirectory()) {
                        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file3);
                        while (true) {
                            try {
                                int i = zipInputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i);
                                }
                            } finally {
                            }
                        }
                        fileOutputStream.close();
                    }
                } else {
                    zipInputStream.close();
                    return;
                }
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
