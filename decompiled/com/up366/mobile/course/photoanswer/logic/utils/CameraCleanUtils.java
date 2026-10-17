package com.up366.mobile.course.photoanswer.logic.utils;

/* JADX INFO: compiled from: CameraCleanUtils.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0002J/\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011H\u0002¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/utils/CameraCleanUtils;", "", "<init>", "()V", "clean", "", "context", "Landroid/content/Context;", "getDeviceStateManager", "getFoldStateListener", "cameraManager", "findFieldRecursively", "Ljava/lang/reflect/Field;", "clazz", "Ljava/lang/Class;", "possibleNames", "", "", "(Ljava/lang/Class;[Ljava/lang/String;)Ljava/lang/reflect/Field;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CameraCleanUtils {
    public static final com.up366.mobile.course.photoanswer.logic.utils.CameraCleanUtils INSTANCE = new com.up366.mobile.course.photoanswer.logic.utils.CameraCleanUtils();

    private CameraCleanUtils() {
    }

    public final void clean(android.content.Context context) {
        java.lang.Class<?> cls;
        java.lang.reflect.Method method;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        try {
            java.lang.Object systemService = context.getSystemService("camera");
            kotlin.jvm.internal.Intrinsics.checkNotNull(systemService);
            java.lang.Object foldStateListener = getFoldStateListener(systemService);
            java.lang.Object deviceStateManager = getDeviceStateManager(context);
            if (deviceStateManager == null || (cls = deviceStateManager.getClass()) == null || (method = cls.getMethod("unregisterCallback", java.lang.Class.forName("android.hardware.devicestate.DeviceStateManager$DeviceStateCallback"))) == null) {
                return;
            }
            method.invoke(deviceStateManager, foldStateListener);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.info("LeakFix 注销失败: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    private final java.lang.Object getDeviceStateManager(android.content.Context context) {
        try {
            return context.getClass().getMethod("getSystemService", java.lang.String.class).invoke(context, "device_state");
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.info("LeakFix 获取DeviceStateManager失败: " + e.getMessage());
            return null;
        }
    }

    private final java.lang.Object getFoldStateListener(java.lang.Object cameraManager) {
        try {
            java.lang.reflect.Field fieldFindFieldRecursively = findFieldRecursively(cameraManager.getClass(), "mFoldStateListener");
            if (fieldFindFieldRecursively != null) {
                fieldFindFieldRecursively.setAccessible(true);
            }
            if (fieldFindFieldRecursively != null) {
                return fieldFindFieldRecursively.get(cameraManager);
            }
            return null;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.info("LeakFix 获取FoldStateListener失败: " + e.getMessage());
            return null;
        }
    }

    private final java.lang.reflect.Field findFieldRecursively(java.lang.Class<?> clazz, java.lang.String... possibleNames) {
        try {
            for (java.lang.String str : possibleNames) {
                try {
                    return clazz.getDeclaredField(str);
                } catch (java.lang.NoSuchFieldException unused) {
                    java.lang.Class<? super java.lang.Object> superclass = clazz.getSuperclass();
                    if (superclass != null) {
                        return INSTANCE.findFieldRecursively(superclass, (java.lang.String[]) java.util.Arrays.copyOf(possibleNames, possibleNames.length));
                    }
                }
            }
            return null;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.info("LeakFix 查找字段失败: " + e.getMessage());
            return null;
        }
    }
}
