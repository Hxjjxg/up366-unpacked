package io.objectbox.internal;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class NativeLibraryLoader {
    private static final java.lang.String OBJECTBOX_JNI = "objectbox-jni";

    public static void ensureLoaded() {
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0099  */
    static {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.objectbox.internal.NativeLibraryLoader.<clinit>():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getCpuArch() {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.objectbox.internal.NativeLibraryLoader.getCpuArch():java.lang.String");
    }

    @javax.annotation.Nullable
    private static java.lang.String getCpuArchOSOrNull() {
        java.lang.String line = null;
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("uname -m").getInputStream(), java.nio.charset.Charset.defaultCharset()));
            line = bufferedReader.readLine();
            bufferedReader.close();
            return line;
        } catch (java.lang.Exception unused) {
            return line;
        }
    }

    private static void checkUnpackLib(java.lang.String str) {
        java.lang.String str2 = "/native/" + str;
        java.net.URL resource = io.objectbox.internal.NativeLibraryLoader.class.getResource(str2);
        if (resource == null) {
            java.lang.System.err.println("Not available in classpath: " + str2);
            return;
        }
        java.io.File file = new java.io.File(str);
        try {
            java.net.URLConnection uRLConnectionOpenConnection = resource.openConnection();
            int contentLength = uRLConnectionOpenConnection.getContentLength();
            long lastModified = uRLConnectionOpenConnection.getLastModified();
            if (file.exists() && file.length() == contentLength && file.lastModified() == lastModified) {
                return;
            }
            java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(uRLConnectionOpenConnection.getInputStream());
            try {
                java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file));
                try {
                    org.greenrobot.essentials.io.IoUtils.copyAllBytes(bufferedInputStream, bufferedOutputStream);
                    org.greenrobot.essentials.io.IoUtils.safeClose(bufferedInputStream);
                    if (lastModified > 0) {
                        file.setLastModified(lastModified);
                    }
                } finally {
                    org.greenrobot.essentials.io.IoUtils.safeClose(bufferedOutputStream);
                }
            } catch (java.lang.Throwable th) {
                org.greenrobot.essentials.io.IoUtils.safeClose(bufferedInputStream);
                throw th;
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean loadLibraryAndroid() {
        if (io.objectbox.BoxStore.getContext() == null) {
            return false;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.content.Context");
            if (io.objectbox.BoxStore.getRelinker() == null) {
                java.lang.Class.forName("com.getkeepsafe.relinker.ReLinker").getMethod("loadLibrary", cls, java.lang.String.class, java.lang.String.class).invoke(null, io.objectbox.BoxStore.getContext(), OBJECTBOX_JNI, io.objectbox.BoxStore.JNI_VERSION);
            } else {
                io.objectbox.BoxStore.getRelinker().getClass().getMethod("loadLibrary", cls, java.lang.String.class, java.lang.String.class).invoke(io.objectbox.BoxStore.getRelinker(), io.objectbox.BoxStore.getContext(), OBJECTBOX_JNI, io.objectbox.BoxStore.JNI_VERSION);
            }
            return true;
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return false;
        }
    }

    @javax.annotation.Nonnull
    private static java.lang.String getSupportedABIsAndroid() {
        java.lang.String[] strArr = null;
        try {
            strArr = (java.lang.String[]) java.lang.Class.forName("android.os.Build").getField("SUPPORTED_ABIS").get(null);
        } catch (java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.NoSuchFieldException unused) {
        }
        if (strArr != null) {
            return java.util.Arrays.toString(strArr);
        }
        return "";
    }
}
