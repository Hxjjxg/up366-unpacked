package com.up366.mobile.book.webview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CaptureHelper {

    public interface IOnCaptureListener {
        void onCapture(android.graphics.Bitmap bitmap);
    }

    void capture(final com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, float f, final com.up366.mobile.book.webview.CaptureHelper.IOnCaptureListener iOnCaptureListener) {
        final int contentHeight = (int) (studyPageWebView.getContentHeight() * f);
        int width = studyPageWebView.getWidth();
        final android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(width, contentHeight, android.graphics.Bitmap.Config.RGB_565);
        final android.graphics.Bitmap bitmapCreateBitmap2 = android.graphics.Bitmap.createBitmap(width, studyPageWebView.getHeight(), android.graphics.Bitmap.Config.RGB_565);
        final android.graphics.Rect rect = new android.graphics.Rect();
        final int scrollY = studyPageWebView.getScrollY();
        studyPageWebView.scrollTo(0, 0);
        final android.graphics.Canvas canvas = new android.graphics.Canvas(bitmapCreateBitmap);
        studyPageWebView.drawVisible(canvas);
        studyPageWebView.drawVisible(new android.graphics.Canvas(bitmapCreateBitmap2));
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(studyPageWebView, "加载中");
        studyPageWebView.setVisibility(4);
        final android.view.ViewGroup viewGroup = (android.view.ViewGroup) studyPageWebView.getParent();
        viewGroup.setBackground(new android.graphics.drawable.ColorDrawable() { // from class: com.up366.mobile.book.webview.CaptureHelper.1
            android.graphics.Paint paint = new android.graphics.Paint();

            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void draw(android.graphics.Canvas canvas2) {
                rect.set(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
                canvas2.drawBitmap(bitmapCreateBitmap2, 0.0f, 0.0f, this.paint);
            }
        });
        studyPageWebView.postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.book.webview.CaptureHelper$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$capture$1(studyPageWebView, canvas, contentHeight, rect, scrollY, viewGroup, bitmapCreateBitmap2, iOnCaptureListener, bitmapCreateBitmap);
            }
        }, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$capture$1(final com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, android.graphics.Canvas canvas, int i, android.graphics.Rect rect, final int i2, final android.view.ViewGroup viewGroup, final android.graphics.Bitmap bitmap, final com.up366.mobile.book.webview.CaptureHelper.IOnCaptureListener iOnCaptureListener, final android.graphics.Bitmap bitmap2) {
        lambda$loopCapture$2(studyPageWebView, canvas, i, rect, new java.lang.Runnable() { // from class: com.up366.mobile.book.webview.CaptureHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.book.webview.CaptureHelper.lambda$capture$0(studyPageWebView, i2, viewGroup, bitmap, iOnCaptureListener, bitmap2);
            }
        });
    }

    static /* synthetic */ void lambda$capture$0(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, int i, android.view.ViewGroup viewGroup, android.graphics.Bitmap bitmap, com.up366.mobile.book.webview.CaptureHelper.IOnCaptureListener iOnCaptureListener, android.graphics.Bitmap bitmap2) {
        studyPageWebView.scrollTo(0, i);
        viewGroup.setBackground(null);
        bitmap.recycle();
        iOnCaptureListener.onCapture(bitmap2);
        studyPageWebView.setVisibility(0);
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(studyPageWebView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loopCapture, reason: merged with bridge method [inline-methods] */
    public void lambda$loopCapture$2(final com.up366.mobile.book.webview.StudyPageWebView studyPageWebView, final android.graphics.Canvas canvas, final int i, final android.graphics.Rect rect, final java.lang.Runnable runnable) {
        int height = studyPageWebView.getHeight();
        if (studyPageWebView.getScrollY() + (studyPageWebView.getHeight() * 2) > i) {
            height = (i - studyPageWebView.getScrollY()) - studyPageWebView.getHeight();
        }
        com.up366.common.log.Logger.info("TAG - CaptureHelper - loopCapture - getScrollY:" + studyPageWebView.getScrollY() + " scrollY:" + height);
        if (height > 0) {
            studyPageWebView.scrollBy(0, height);
            canvas.save();
            studyPageWebView.getLocalVisibleRect(rect);
            canvas.clipRect(rect);
            studyPageWebView.drawVisible(canvas);
            canvas.restore();
            studyPageWebView.postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.book.webview.CaptureHelper$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loopCapture$2(studyPageWebView, canvas, i, rect, runnable);
                }
            }, 200L);
            return;
        }
        runnable.run();
    }

    private void saveBitmap(android.graphics.Bitmap bitmap) {
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(com.up366.common.global.GB.get().getImgCacheDir() + "/" + new java.util.Date().toString() + com.up366.medialibrary.common.utils.MimeTypeUtils.JPG);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            fileOutputStream.close();
            bitmap.recycle();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
