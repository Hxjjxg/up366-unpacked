package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ViewDataInvalidRecord {
    private static final java.util.Map<java.lang.String, java.lang.Long> map = new java.util.HashMap();

    public static com.up366.mobile.common.utils.ViewDataInvalidRecord.ViewDataInvalidRecordInnerClass $(java.lang.Object obj, java.lang.String str) {
        return new com.up366.mobile.common.utils.ViewDataInvalidRecord.ViewDataInvalidRecordInnerClass(obj.toString(), str);
    }

    public static com.up366.mobile.common.utils.ViewDataInvalidRecord.ViewDataInvalidRecordInnerClass $(java.lang.String str) {
        return new com.up366.mobile.common.utils.ViewDataInvalidRecord.ViewDataInvalidRecordInnerClass(str);
    }

    public static void putCache(java.lang.String str, int i) {
        map.put("-\n-cache-\n-" + str, java.lang.Long.valueOf(android.os.SystemClock.uptimeMillis() + ((long) i)));
    }

    public static boolean hasCache(java.lang.String str) {
        java.lang.Long lRemove = map.remove("-\n-cache-\n-" + str);
        return lRemove != null && lRemove.longValue() > android.os.SystemClock.uptimeMillis();
    }

    public static class ViewDataInvalidRecordInnerClass {
        private java.lang.String key;
        private java.lang.String name;

        ViewDataInvalidRecordInnerClass(java.lang.String str, java.lang.String str2) {
            this.key = str;
            this.name = str2;
        }

        ViewDataInvalidRecordInnerClass(java.lang.String str) {
            this.key = "default";
            this.name = str;
        }

        public void invalid() {
            java.lang.Long l = (java.lang.Long) com.up366.mobile.common.utils.ViewDataInvalidRecord.map.get(this.name);
            if (l == null) {
                com.up366.mobile.common.utils.ViewDataInvalidRecord.map.put(this.name, 1L);
            } else {
                com.up366.mobile.common.utils.ViewDataInvalidRecord.map.put(this.name, java.lang.Long.valueOf(l.longValue() + 1));
            }
        }

        public void run(java.lang.Runnable runnable) {
            if (isInvalid()) {
                runnable.run();
            }
        }

        public boolean isInvalid() {
            java.lang.Long l = (java.lang.Long) com.up366.mobile.common.utils.ViewDataInvalidRecord.map.get(this.name);
            if (l == null || l.longValue() <= 0) {
                return false;
            }
            java.lang.String str = this.key + "\n\t\n" + this.name;
            java.lang.Long l2 = (java.lang.Long) com.up366.mobile.common.utils.ViewDataInvalidRecord.map.get(str);
            if (l2 != null && l.longValue() <= l2.longValue()) {
                return false;
            }
            com.up366.mobile.common.utils.ViewDataInvalidRecord.map.put(str, l);
            return true;
        }
    }
}
