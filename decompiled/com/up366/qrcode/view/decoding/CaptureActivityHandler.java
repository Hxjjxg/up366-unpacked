package com.up366.qrcode.view.decoding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class CaptureActivityHandler extends android.os.Handler {
    private static final java.lang.String TAG = "CaptureActivityHandler";
    private final com.up366.qrcode.view.decoding.DecodeThread decodeThread;
    private final com.up366.qrcode.view.activity.CaptureFragment fragment;
    private com.up366.qrcode.view.decoding.CaptureActivityHandler.State state;

    private enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public CaptureActivityHandler(com.up366.qrcode.view.activity.CaptureFragment captureFragment, java.util.Vector<com.google.zxing.BarcodeFormat> vector, java.lang.String str, com.up366.qrcode.view.view.ViewfinderView viewfinderView) {
        this.fragment = captureFragment;
        com.up366.qrcode.view.decoding.DecodeThread decodeThread = new com.up366.qrcode.view.decoding.DecodeThread(captureFragment, vector, str, new com.up366.qrcode.view.view.ViewfinderResultPointCallback(viewfinderView));
        this.decodeThread = decodeThread;
        decodeThread.start();
        this.state = com.up366.qrcode.view.decoding.CaptureActivityHandler.State.SUCCESS;
        com.up366.qrcode.view.camera.CameraManager.get().startPreview();
        restartPreviewAndDecode();
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        if (message.what == com.up366.qrcode.R.id.auto_focus) {
            if (this.state == com.up366.qrcode.view.decoding.CaptureActivityHandler.State.PREVIEW) {
                com.up366.qrcode.view.camera.CameraManager.get().requestAutoFocus(this, com.up366.qrcode.R.id.auto_focus);
                return;
            }
            return;
        }
        if (message.what == com.up366.qrcode.R.id.restart_preview) {
            android.util.Log.d(TAG, "Got restart preview message");
            restartPreviewAndDecode();
            return;
        }
        if (message.what == com.up366.qrcode.R.id.decode_succeeded) {
            android.util.Log.d(TAG, "Got decode succeeded message");
            this.state = com.up366.qrcode.view.decoding.CaptureActivityHandler.State.SUCCESS;
            android.os.Bundle data = message.getData();
            this.fragment.handleDecode((com.google.zxing.Result) message.obj, data == null ? null : (android.graphics.Bitmap) data.getParcelable(com.up366.qrcode.view.decoding.DecodeThread.BARCODE_BITMAP));
            return;
        }
        if (message.what == com.up366.qrcode.R.id.decode_failed) {
            this.state = com.up366.qrcode.view.decoding.CaptureActivityHandler.State.PREVIEW;
            com.up366.qrcode.view.camera.CameraManager.get().requestPreviewFrame(this.decodeThread.getHandler(), com.up366.qrcode.R.id.decode);
            return;
        }
        if (message.what == com.up366.qrcode.R.id.return_scan_result) {
            android.util.Log.d(TAG, "Got return scan result message");
            this.fragment.getActivity().setResult(-1, (android.content.Intent) message.obj);
            this.fragment.getActivity().finish();
        } else if (message.what == com.up366.qrcode.R.id.launch_product_query) {
            android.util.Log.d(TAG, "Got product query message");
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse((java.lang.String) message.obj));
            intent.addFlags(524288);
            this.fragment.getActivity().startActivity(intent);
        }
    }

    public void quitSynchronously() {
        this.state = com.up366.qrcode.view.decoding.CaptureActivityHandler.State.DONE;
        com.up366.qrcode.view.camera.CameraManager.get().stopPreview();
        android.os.Message.obtain(this.decodeThread.getHandler(), com.up366.qrcode.R.id.quit).sendToTarget();
        try {
            this.decodeThread.join();
        } catch (java.lang.InterruptedException unused) {
        }
        removeMessages(com.up366.qrcode.R.id.decode_succeeded);
        removeMessages(com.up366.qrcode.R.id.decode_failed);
    }

    private void restartPreviewAndDecode() {
        if (this.state == com.up366.qrcode.view.decoding.CaptureActivityHandler.State.SUCCESS) {
            this.state = com.up366.qrcode.view.decoding.CaptureActivityHandler.State.PREVIEW;
            com.up366.qrcode.view.camera.CameraManager.get().requestPreviewFrame(this.decodeThread.getHandler(), com.up366.qrcode.R.id.decode);
            com.up366.qrcode.view.camera.CameraManager.get().requestAutoFocus(this, com.up366.qrcode.R.id.auto_focus);
            this.fragment.drawViewfinder();
        }
    }
}
