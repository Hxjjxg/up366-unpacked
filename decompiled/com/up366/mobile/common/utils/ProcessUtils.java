package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ProcessUtils {
    public static java.lang.String getAppProcessName() {
        java.io.BufferedReader bufferedReader;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/" + android.os.Process.myPid() + "/cmdline"));
            try {
                java.lang.String line = bufferedReader.readLine();
                if (!android.text.TextUtils.isEmpty(line)) {
                    line = line.trim();
                }
                try {
                    bufferedReader.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                return line;
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }
}
