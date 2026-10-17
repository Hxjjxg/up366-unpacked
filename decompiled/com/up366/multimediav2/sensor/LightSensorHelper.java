package com.up366.multimediav2.sensor;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class LightSensorHelper {
    public static boolean supportLightSensor(android.content.Context context) {
        if (context == null) {
            return false;
        }
        java.util.List<android.hardware.Sensor> sensorList = ((android.hardware.SensorManager) context.getSystemService("sensor")).getSensorList(-1);
        com.up366.asmlibrary.Utils.writeLog("com/up366/multimediav2/sensor/LightSensorHelper  ->  supportLightSensor  ->  (Landroid/content/Context;)Z\r\nandroid/hardware/SensorManager  ->  getSensorList  ->  (I)Ljava/util/List;\r\n", new java.lang.Throwable());
        java.util.Iterator<android.hardware.Sensor> it = sensorList.iterator();
        while (it.hasNext()) {
            if (5 == it.next().getType()) {
                return true;
            }
        }
        return false;
    }

    public static void registerListener(android.content.Context context, android.hardware.SensorEventListener sensorEventListener) {
        android.hardware.SensorManager sensorManager;
        android.hardware.Sensor defaultSensor;
        if (context == null || (defaultSensor = (sensorManager = (android.hardware.SensorManager) context.getSystemService("sensor")).getDefaultSensor(5)) == null) {
            return;
        }
        sensorManager.registerListener(sensorEventListener, defaultSensor, 0);
    }

    public static void unRegisterSensor(android.content.Context context, android.hardware.SensorEventListener sensorEventListener) {
        android.hardware.SensorManager sensorManager;
        if (context == null || (sensorManager = (android.hardware.SensorManager) context.getSystemService("sensor")) == null) {
            return;
        }
        sensorManager.unregisterListener(sensorEventListener);
    }
}
