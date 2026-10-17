package com.up366.smart.paper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class TensorFlowUtil {
    public static com.up366.smart.paper.ImageDetector sImageDetector;

    public static void buildImageDetector(android.content.Context context) {
        buildImageDetector(context, null);
    }

    public static void buildImageDetector(android.content.Context context, java.lang.String modelFile) {
        try {
            sImageDetector = new com.up366.smart.paper.ImageDetector(context, modelFile);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            com.up366.common.log.Logger.error("TensorFlowUtil e=" + e.getMessage());
        }
    }
}
