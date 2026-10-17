package com.up366.smart.paper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ImageDetector {
    private static final java.lang.String MODEL_FILE = "models/hed_lite_model_quantize.tflite";
    private int desiredSize;
    protected org.tensorflow.lite.Interpreter tflite;
    private java.nio.MappedByteBuffer tfliteModel;
    org.tensorflow.lite.Interpreter.Options tfliteOptions;

    public ImageDetector(android.content.Context context) throws java.io.IOException {
        this(context, MODEL_FILE);
    }

    public ImageDetector(android.content.Context context, java.lang.String modelFile) throws java.io.IOException {
        this.desiredSize = 256;
        this.tfliteModel = loadModelFile(context, android.text.TextUtils.isEmpty(modelFile) ? MODEL_FILE : modelFile);
        this.tfliteOptions = new org.tensorflow.lite.Interpreter.Options().setNumThreads(4);
        this.tflite = new org.tensorflow.lite.Interpreter(this.tfliteModel, this.tfliteOptions);
    }

    public android.graphics.Bitmap detectImage(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int i = this.desiredSize;
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(((i * i) * 96) / 8);
        byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
        int i2 = this.desiredSize;
        java.nio.ByteBuffer byteBufferAllocateDirect2 = java.nio.ByteBuffer.allocateDirect(((i2 * i2) * 32) / 8);
        byteBufferAllocateDirect2.order(java.nio.ByteOrder.nativeOrder());
        byteBufferAllocateDirect.clear();
        byteBufferAllocateDirect2.clear();
        int i3 = this.desiredSize;
        convertBitmapToByteBuffer(android.graphics.Bitmap.createScaledBitmap(bitmap, i3, i3, false), byteBufferAllocateDirect);
        java.util.HashMap map = new java.util.HashMap();
        map.put(0, byteBufferAllocateDirect2);
        this.tflite.runForMultipleInputsOutputs(new java.lang.Object[]{byteBufferAllocateDirect}, map);
        return convertOutputBufferToBitmap(byteBufferAllocateDirect2);
    }

    private void convertBitmapToByteBuffer(android.graphics.Bitmap bitmap, java.nio.ByteBuffer imgData) {
        if (imgData == null) {
            return;
        }
        int i = this.desiredSize;
        int[] iArr = new int[i * i];
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i);
        imgData.rewind();
        int i2 = 0;
        for (int i3 = 0; i3 < this.desiredSize; i3++) {
            int i4 = 0;
            while (i4 < this.desiredSize) {
                int i5 = i2 + 1;
                int i6 = iArr[i2];
                imgData.putFloat((i6 >> 16) & 255);
                imgData.putFloat((i6 >> 8) & 255);
                imgData.putFloat(i6 & 255);
                i4++;
                i2 = i5;
            }
        }
    }

    private android.graphics.Bitmap convertOutputBufferToBitmap(java.nio.ByteBuffer outImgData) {
        if (outImgData == null) {
            return null;
        }
        outImgData.rewind();
        int i = this.desiredSize;
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(i, i, android.graphics.Bitmap.Config.ARGB_8888);
        int i2 = this.desiredSize;
        int[] iArr = new int[i2 * i2];
        int i3 = 0;
        while (true) {
            int i4 = this.desiredSize;
            if (i3 >= i4 * i4) {
                bitmapCreateBitmap.setPixels(iArr, 0, i4, 0, 0, i4, i4);
                return bitmapCreateBitmap;
            }
            if (outImgData.getFloat() > 0.2d) {
                iArr[i3] = -1;
            } else {
                iArr[i3] = -16777216;
            }
            i3++;
        }
    }

    private java.nio.MappedByteBuffer loadModelFile(android.content.Context activity, java.lang.String modelFile) throws java.io.IOException {
        android.content.res.AssetFileDescriptor assetFileDescriptorOpenFd = activity.getResources().getAssets().openFd(modelFile);
        return new java.io.FileInputStream(assetFileDescriptorOpenFd.getFileDescriptor()).getChannel().map(java.nio.channels.FileChannel.MapMode.READ_ONLY, assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getDeclaredLength());
    }
}
