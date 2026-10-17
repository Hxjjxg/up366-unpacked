package com.up366.qrcode.view.camera;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
final class CameraConfigurationManager {
    private static final java.util.regex.Pattern COMMA_PATTERN = java.util.regex.Pattern.compile(com.igexin.push.core.b.an);
    private static final int DESIRED_SHARPNESS = 30;
    private static final java.lang.String TAG = "CameraConfigurationManager";
    private static final int TEN_DESIRED_ZOOM = 27;
    private android.graphics.Point cameraResolution;
    private final android.content.Context context;
    private int previewFormat;
    private java.lang.String previewFormatString;
    private android.graphics.Point screenResolution;

    public static int getDesiredSharpness() {
        return 30;
    }

    CameraConfigurationManager(android.content.Context context) {
        this.context = context;
    }

    void initFromCameraParameters(android.hardware.Camera camera) {
        android.hardware.Camera.Parameters parameters = camera.getParameters();
        this.previewFormat = parameters.getPreviewFormat();
        this.previewFormatString = parameters.get("preview-format");
        java.lang.String str = TAG;
        android.util.Log.d(str, "Default preview format: " + this.previewFormat + '/' + this.previewFormatString);
        android.view.Display defaultDisplay = ((android.view.WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        this.screenResolution = new android.graphics.Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        android.util.Log.d(str, "Screen resolution: " + this.screenResolution);
        android.graphics.Point point = new android.graphics.Point();
        point.x = this.screenResolution.x;
        point.y = this.screenResolution.y;
        if (this.screenResolution.x < this.screenResolution.y) {
            point.x = this.screenResolution.y;
            point.y = this.screenResolution.x;
        }
        android.util.Log.i("#########", "screenX:" + point.x + "   screenY:" + point.y);
        this.cameraResolution = getCameraResolution(parameters, point);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Camera resolution: ");
        sb.append(this.screenResolution);
        android.util.Log.d(str, sb.toString());
    }

    void setDesiredCameraParameters(android.hardware.Camera camera) {
        android.hardware.Camera.Parameters parameters = camera.getParameters();
        android.util.Log.d(TAG, "Setting preview size: " + this.cameraResolution);
        parameters.setPreviewSize(this.cameraResolution.x, this.cameraResolution.y);
        setFlash(parameters);
        setZoom(parameters);
        camera.setDisplayOrientation(90);
        camera.setParameters(parameters);
    }

    android.graphics.Point getCameraResolution() {
        return this.cameraResolution;
    }

    android.graphics.Point getScreenResolution() {
        return this.screenResolution;
    }

    int getPreviewFormat() {
        return this.previewFormat;
    }

    java.lang.String getPreviewFormatString() {
        return this.previewFormatString;
    }

    private static android.graphics.Point getCameraResolution(android.hardware.Camera.Parameters parameters, android.graphics.Point point) {
        android.graphics.Point pointFindBestPreviewSizeValue;
        java.lang.String str = parameters.get("preview-size-values");
        if (str == null) {
            str = parameters.get("preview-size-value");
        }
        if (str != null) {
            android.util.Log.d(TAG, "preview-size-values parameter: " + str);
            pointFindBestPreviewSizeValue = findBestPreviewSizeValue(str, point);
        } else {
            pointFindBestPreviewSizeValue = null;
        }
        return pointFindBestPreviewSizeValue == null ? new android.graphics.Point((point.x >> 3) << 3, (point.y >> 3) << 3) : pointFindBestPreviewSizeValue;
    }

    private static android.graphics.Point findBestPreviewSizeValue(java.lang.CharSequence charSequence, android.graphics.Point point) {
        java.lang.String[] strArrSplit = COMMA_PATTERN.split(charSequence);
        int length = strArrSplit.length;
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            java.lang.String strTrim = strArrSplit[i2].trim();
            int iIndexOf = strTrim.indexOf(120);
            if (iIndexOf < 0) {
                android.util.Log.w(TAG, "Bad preview-size: " + strTrim);
            } else {
                try {
                    int i5 = java.lang.Integer.parseInt(strTrim.substring(0, iIndexOf));
                    int i6 = java.lang.Integer.parseInt(strTrim.substring(iIndexOf + 1));
                    int iAbs = java.lang.Math.abs(i5 - point.x) + java.lang.Math.abs(i6 - point.y);
                    if (iAbs == 0) {
                        i4 = i6;
                        i3 = i5;
                        break;
                    }
                    if (iAbs < i) {
                        i4 = i6;
                        i = iAbs;
                        i3 = i5;
                    }
                } catch (java.lang.NumberFormatException unused) {
                    android.util.Log.w(TAG, "Bad preview-size: " + strTrim);
                }
            }
            i2++;
        }
        if (i3 <= 0 || i4 <= 0) {
            return null;
        }
        return new android.graphics.Point(i3, i4);
    }

    private static int findBestMotZoomValue(java.lang.CharSequence charSequence, int i) {
        int i2 = 0;
        for (java.lang.String str : COMMA_PATTERN.split(charSequence)) {
            try {
                double d = java.lang.Double.parseDouble(str.trim());
                int i3 = (int) (10.0d * d);
                if (java.lang.Math.abs(((double) i) - d) < java.lang.Math.abs(i - i2)) {
                    i2 = i3;
                }
            } catch (java.lang.NumberFormatException unused) {
                return i;
            }
        }
        return i2;
    }

    private void setFlash(android.hardware.Camera.Parameters parameters) {
        if (android.os.Build.MODEL.contains("Behold II") && com.up366.qrcode.view.camera.CameraManager.SDK_INT == 3) {
            parameters.set("flash-value", 1);
        } else {
            parameters.set("flash-value", 2);
        }
        parameters.set("flash-mode", "off");
    }

    private void setZoom(android.hardware.Camera.Parameters parameters) {
        java.lang.String str = parameters.get("zoom-supported");
        if (str == null || java.lang.Boolean.parseBoolean(str)) {
            java.lang.String str2 = parameters.get("max-zoom");
            int iFindBestMotZoomValue = 27;
            if (str2 != null) {
                try {
                    int i = (int) (java.lang.Double.parseDouble(str2) * 10.0d);
                    if (27 > i) {
                        iFindBestMotZoomValue = i;
                    }
                } catch (java.lang.NumberFormatException unused) {
                    android.util.Log.w(TAG, "Bad max-zoom: " + str2);
                }
            }
            java.lang.String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int i2 = java.lang.Integer.parseInt(str3);
                    if (iFindBestMotZoomValue > i2) {
                        iFindBestMotZoomValue = i2;
                    }
                } catch (java.lang.NumberFormatException unused2) {
                    android.util.Log.w(TAG, "Bad taking-picture-zoom-max: " + str3);
                }
            }
            java.lang.String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                iFindBestMotZoomValue = findBestMotZoomValue(str4, iFindBestMotZoomValue);
            }
            java.lang.String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int i3 = (int) (java.lang.Double.parseDouble(str5.trim()) * 10.0d);
                    if (i3 > 1) {
                        iFindBestMotZoomValue -= iFindBestMotZoomValue % i3;
                    }
                } catch (java.lang.NumberFormatException unused3) {
                }
            }
            if (str2 != null || str4 != null) {
                parameters.set("zoom", java.lang.String.valueOf(((double) iFindBestMotZoomValue) / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", iFindBestMotZoomValue);
            }
        }
    }
}
