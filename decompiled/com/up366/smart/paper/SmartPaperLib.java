package com.up366.smart.paper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class SmartPaperLib {
    public static final java.lang.String OPENCV_VERSION_3 = "opencv_java3";
    public static final java.lang.String OPENCV_VERSION_4 = "opencv_java4";

    public static void init(android.content.Context context) {
        java.lang.System.loadLibrary(OPENCV_VERSION_4);
        android.util.Log.i("SmartPaperLib", "OpencvLoader:" + org.opencv.android.OpenCVLoader.initDebug());
        com.up366.smart.paper.TensorFlowUtil.buildImageDetector(context);
    }

    public static void init(android.content.Context context, java.lang.String opencvVersion) {
        java.lang.System.loadLibrary(opencvVersion);
        android.util.Log.i("SmartPaperLib", "OpencvLoader:" + org.opencv.android.OpenCVLoader.initDebug());
        com.up366.smart.paper.TensorFlowUtil.buildImageDetector(context);
    }
}
