package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SPUtils {
    private static final java.util.Map<java.lang.String, com.up366.medialibrary.common.utils.SPUtils> SP_UTILS_MAP = new java.util.HashMap();
    private android.content.SharedPreferences sp;

    public static com.up366.medialibrary.common.utils.SPUtils getPictureSpUtils() {
        return getInstance("PictureSpUtils");
    }

    public static com.up366.medialibrary.common.utils.SPUtils getInstance() {
        return getInstance("", 0);
    }

    public static com.up366.medialibrary.common.utils.SPUtils getInstance(int i) {
        return getInstance("", i);
    }

    public static com.up366.medialibrary.common.utils.SPUtils getInstance(java.lang.String str) {
        return getInstance(str, 0);
    }

    public static com.up366.medialibrary.common.utils.SPUtils getInstance(java.lang.String str, int i) {
        if (isSpace(str)) {
            str = "spUtils";
        }
        java.util.Map<java.lang.String, com.up366.medialibrary.common.utils.SPUtils> map = SP_UTILS_MAP;
        com.up366.medialibrary.common.utils.SPUtils sPUtils = map.get(str);
        if (sPUtils == null) {
            synchronized (com.up366.medialibrary.common.utils.SPUtils.class) {
                sPUtils = map.get(str);
                if (sPUtils == null) {
                    sPUtils = new com.up366.medialibrary.common.utils.SPUtils(str, i);
                    map.put(str, sPUtils);
                }
            }
        }
        return sPUtils;
    }

    private SPUtils(java.lang.String str) {
        this.sp = getApplicationByReflect().getSharedPreferences(str, 0);
    }

    private SPUtils(java.lang.String str, int i) {
        this.sp = getApplicationByReflect().getSharedPreferences(str, i);
    }

    public void put(java.lang.String str, java.lang.String str2) {
        put(str, str2, false);
    }

    public void put(java.lang.String str, java.lang.String str2, boolean z) {
        if (z) {
            this.sp.edit().putString(str, str2).commit();
        } else {
            this.sp.edit().putString(str, str2).apply();
        }
    }

    public java.lang.String getString(java.lang.String str) {
        return getString(str, "");
    }

    public java.lang.String getString(java.lang.String str, java.lang.String str2) {
        return this.sp.getString(str, str2);
    }

    public void put(java.lang.String str, int i) {
        put(str, i, false);
    }

    public void put(java.lang.String str, int i, boolean z) {
        if (z) {
            this.sp.edit().putInt(str, i).commit();
        } else {
            this.sp.edit().putInt(str, i).apply();
        }
    }

    public int getInt(java.lang.String str) {
        return getInt(str, -1);
    }

    public int getInt(java.lang.String str, int i) {
        return this.sp.getInt(str, i);
    }

    public void put(java.lang.String str, long j) {
        put(str, j, false);
    }

    public void put(java.lang.String str, long j, boolean z) {
        if (z) {
            this.sp.edit().putLong(str, j).commit();
        } else {
            this.sp.edit().putLong(str, j).apply();
        }
    }

    public long getLong(java.lang.String str) {
        return getLong(str, -1L);
    }

    public long getLong(java.lang.String str, long j) {
        return this.sp.getLong(str, j);
    }

    public void put(java.lang.String str, float f) {
        put(str, f, false);
    }

    public void put(java.lang.String str, float f, boolean z) {
        if (z) {
            this.sp.edit().putFloat(str, f).commit();
        } else {
            this.sp.edit().putFloat(str, f).apply();
        }
    }

    public float getFloat(java.lang.String str) {
        return getFloat(str, -1.0f);
    }

    public float getFloat(java.lang.String str, float f) {
        return this.sp.getFloat(str, f);
    }

    public void put(java.lang.String str, boolean z) {
        put(str, z, false);
    }

    public void put(java.lang.String str, boolean z, boolean z2) {
        if (z2) {
            this.sp.edit().putBoolean(str, z).commit();
        } else {
            this.sp.edit().putBoolean(str, z).apply();
        }
    }

    public boolean getBoolean(java.lang.String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(java.lang.String str, boolean z) {
        return this.sp.getBoolean(str, z);
    }

    public void put(java.lang.String str, java.util.Set<java.lang.String> set) {
        put(str, set, false);
    }

    public void put(java.lang.String str, java.util.Set<java.lang.String> set, boolean z) {
        if (z) {
            this.sp.edit().putStringSet(str, set).commit();
        } else {
            this.sp.edit().putStringSet(str, set).apply();
        }
    }

    public java.util.Set<java.lang.String> getStringSet(java.lang.String str) {
        return getStringSet(str, java.util.Collections.emptySet());
    }

    public java.util.Set<java.lang.String> getStringSet(java.lang.String str, java.util.Set<java.lang.String> set) {
        return this.sp.getStringSet(str, set);
    }

    public java.util.Map<java.lang.String, ?> getAll() {
        return this.sp.getAll();
    }

    public boolean contains(java.lang.String str) {
        return this.sp.contains(str);
    }

    public void remove(java.lang.String str) {
        remove(str, false);
    }

    public void remove(java.lang.String str, boolean z) {
        if (z) {
            this.sp.edit().remove(str).commit();
        } else {
            this.sp.edit().remove(str).apply();
        }
    }

    public void clear() {
        clear(false);
    }

    public void clear(boolean z) {
        if (z) {
            this.sp.edit().clear().commit();
        } else {
            this.sp.edit().clear().apply();
        }
    }

    private static boolean isSpace(java.lang.String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!java.lang.Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static android.app.Application getApplicationByReflect() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ActivityThread");
            java.lang.Object objInvoke = cls.getMethod("getApplication", null).invoke(cls.getMethod("currentActivityThread", null).invoke(null, null), null);
            if (objInvoke == null) {
                throw new java.lang.NullPointerException("u should init first");
            }
            return (android.app.Application) objInvoke;
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
            throw new java.lang.NullPointerException("u should init first");
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
            throw new java.lang.NullPointerException("u should init first");
        } catch (java.lang.NoSuchMethodException e3) {
            e3.printStackTrace();
            throw new java.lang.NullPointerException("u should init first");
        } catch (java.lang.reflect.InvocationTargetException e4) {
            e4.printStackTrace();
            throw new java.lang.NullPointerException("u should init first");
        }
    }
}
