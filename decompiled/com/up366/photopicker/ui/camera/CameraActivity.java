package com.up366.photopicker.ui.camera;

/* JADX INFO: compiled from: CameraActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u0000  \u00012\u00020\u0001:\u0006 \u0001¡\u0001¢\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u000200H\u0002J0\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020J2\u0006\u0010M\u001a\u00020J2\u0006\u0010N\u001a\u00020!H\u0002J\b\u0010O\u001a\u00020EH\u0002J\b\u0010P\u001a\u00020EH\u0002J\u0010\u0010Q\u001a\u00020\u00172\u0006\u0010R\u001a\u000200H\u0002J\u0010\u0010S\u001a\u00020\u00172\u0006\u0010R\u001a\u000200H\u0002J\u0018\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020J2\u0006\u0010W\u001a\u00020JH\u0002J\b\u0010X\u001a\u00020EH\u0002J\b\u0010Y\u001a\u00020EH\u0002J\u0018\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00172\u0006\u0010]\u001a\u00020[H\u0002J\u0012\u0010^\u001a\u00020E2\b\u0010_\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010`\u001a\u00020E2\u0006\u0010a\u001a\u00020bH\u0002J\b\u0010c\u001a\u00020EH\u0002J\u0010\u0010d\u001a\u00020!2\u0006\u0010_\u001a\u00020\u0017H\u0002J\u0012\u0010e\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020\u0017H\u0002J\u0010\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020gH\u0002J\"\u0010i\u001a\u00020E2\u0006\u0010j\u001a\u0002002\u0006\u0010k\u001a\u0002002\b\u0010l\u001a\u0004\u0018\u00010mH\u0014J\b\u0010n\u001a\u00020EH\u0016J\u0012\u0010o\u001a\u00020E2\b\u0010p\u001a\u0004\u0018\u00010qH\u0014J\b\u0010r\u001a\u00020EH\u0014J-\u0010s\u001a\u00020E2\u0006\u0010j\u001a\u0002002\u000e\u0010t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170u2\u0006\u0010v\u001a\u00020wH\u0016¢\u0006\u0002\u0010xJ\b\u0010y\u001a\u00020EH\u0014J\u0010\u0010z\u001a\u00020E2\u0006\u0010{\u001a\u00020qH\u0014J,\u0010|\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u0002002\b\b\u0002\u0010}\u001a\u00020\u00142\b\b\u0002\u0010~\u001a\u00020\u0014H\u0002J\b\u0010\u007f\u001a\u00020EH\u0002J\u0013\u0010\u0080\u0001\u001a\u00030\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u000203H\u0002J\t\u0010\u0083\u0001\u001a\u00020EH\u0002J\u001a\u0010\u0084\u0001\u001a\u00020\u00142\u0007\u0010\u0085\u0001\u001a\u00020\u00142\u0006\u0010~\u001a\u00020\u0014H\u0002J\u0011\u0010\u0086\u0001\u001a\u00020E2\u0006\u0010G\u001a\u000200H\u0002J\u0012\u0010\u0087\u0001\u001a\u00020g2\u0007\u0010\u0088\u0001\u001a\u000200H\u0002J\t\u0010\u0089\u0001\u001a\u000200H\u0002J\t\u0010\u008a\u0001\u001a\u00020EH\u0002J\t\u0010\u008b\u0001\u001a\u00020EH\u0002J\t\u0010\u008c\u0001\u001a\u00020EH\u0002J\t\u0010\u008d\u0001\u001a\u00020EH\u0002J\u0011\u0010\u008e\u0001\u001a\u00020!2\u0006\u0010~\u001a\u00020\u0014H\u0002J\t\u0010\u008f\u0001\u001a\u00020EH\u0002J\t\u0010\u0090\u0001\u001a\u00020EH\u0002J\t\u0010\u0091\u0001\u001a\u00020EH\u0002J\t\u0010\u0092\u0001\u001a\u00020EH\u0002J\t\u0010\u0093\u0001\u001a\u00020EH\u0002J\t\u0010\u0094\u0001\u001a\u00020EH\u0002J\t\u0010\u0095\u0001\u001a\u00020EH\u0002J\t\u0010\u0096\u0001\u001a\u00020EH\u0002J\t\u0010\u0097\u0001\u001a\u00020EH\u0002J\t\u0010\u0098\u0001\u001a\u00020EH\u0002J\t\u0010\u0099\u0001\u001a\u00020EH\u0002J\u0012\u0010\u009a\u0001\u001a\u00020E2\u0007\u0010\u009b\u0001\u001a\u00020!H\u0002J\t\u0010\u009c\u0001\u001a\u00020EH\u0002J\t\u0010\u009d\u0001\u001a\u00020EH\u0002J\u0012\u0010\u009e\u0001\u001a\u00020E2\u0007\u0010\u009f\u0001\u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n )*\u0004\u0018\u00010(0(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020302X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u001702X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020!02X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006£\u0001"}, d2 = {"Lcom/up366/photopicker/ui/camera/CameraActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnBack", "Landroid/widget/ImageButton;", "btnCapture", "btnConfirm", "Landroid/widget/TextView;", "btnFlash", "btnGrid", "btnGuide", "cameraControl", "Landroidx/camera/core/CameraControl;", "cameraPageSetting", "Lcom/up366/photopicker/config/CameraPageSetting;", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "captureRectOverlay", "Landroid/view/View;", "captureRectRatio", "Landroid/graphics/RectF;", "captureRectViewRatio", "configJson", "", "counterText", "counterThumbnail", "Landroid/widget/ImageView;", "galleryButton", "Landroid/widget/FrameLayout;", "galleryIcon", "gridOverlay", "Lcom/up366/photopicker/ui/camera/GridOverlayView;", "hasShownClipAutoGuide", "", "hasTorchSupport", "hideMaxPageHintRunnable", "Ljava/lang/Runnable;", "imageCapture", "Landroidx/camera/core/ImageCapture;", "ioExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "isCapturing", "isFlashOn", "isGridOn", "isMultipleMode", "isPhotosExpanded", "lastCropIndex", "", "photoFiles", "", "Ljava/io/File;", "photoPaths", "photoRectAdjustedStates", "photoThumbnails", "Landroid/widget/LinearLayout;", "previewContentRect", "previewView", "Landroidx/camera/view/PreviewView;", "previewVisibleRatio", "scrollPhotos", "Landroid/widget/HorizontalScrollView;", "tabMultiple", "tabSingle", "tvCaptureHint", "tvMaxPageHint", "webViewDialog", "Lcom/up366/photopicker/ui/WebViewDialog;", "addThumbnailWithDelete", "", "photoPath", com.up366.photopicker.PhotoPickerConstants.EXTRA_INDEX, "applyCaptureRect", com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_TOP, "", com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_BOTTOM, com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_LEFT, com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_RIGHT, "showOverlay", "applyConfig", "applyPressedFeedback", "buildMaxPageReachedHint", "maxPage", "buildMaxPageReachedHintV1", "buildPreviewMappingForSource", "Lcom/up366/photopicker/ui/camera/CameraActivity$PreviewMappingResult;", "sourceWidth", "sourceHeight", "checkCameraPermissionAndStart", "clearCapturedPhotos", "correctBitmapOrientation", "Landroid/graphics/Bitmap;", "filePath", "bitmap", "deleteFileQuietly", com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, "finishWithLaunchFailure", "result", "Lcom/up366/photopicker/PhotoPickerLaunchResult;", "initViews", "isManagedTempFile", "loadCorrectedBitmap", "normalizeSourceSizeForViewport", "Landroid/util/Size;", "size", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSaveInstanceState", "outState", "openCropPage", "initialCropRatio", "visibleRatio", "openGallery", "prepareCapturedPhoto", "Lcom/up366/photopicker/ui/camera/CameraActivity$PreparedCaptureResult;", "photoFile", "readConfig", "remapRatioToVisiblePreview", "sourceRatio", "removePhoto", "resolveCaptureTargetSize", "targetRotation", "resolveTargetRotation", "returnPhotos", "setupClickListeners", "setupFullScreen", "setupTabSwitch", "shouldCropToPreviewVisibleArea", "showGuide", "showMaxPageHint", "showSwitchToSingleConfirmDialog", "startCamera", "takePhoto", "toggleFlash", "toggleGrid", "togglePhotosExpand", "updateCaptureHint", "updateCaptureRectFromConfig", "updateConfirmVisibility", "updateFlashAvailability", "supported", "updateGalleryButtonPressedFeedback", "updatePhotoCounter", "updateTabUI", "isSingle", "Companion", "PreparedCaptureResult", "PreviewMappingResult", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CameraActivity extends androidx.appcompat.app.AppCompatActivity {
    private static final java.lang.String FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS";
    private static final long MAX_PAGE_HINT_DURATION_MS = 2000;
    private static final int OUTPUT_JPEG_QUALITY = 95;
    private static final int REQUEST_CROP = 1001;
    private static final int REQUEST_GALLERY = 1002;
    private static final java.lang.String TAG = "CameraActivity";
    private static final int TARGET_CAPTURE_HEIGHT = 3584;
    private static final int TARGET_CAPTURE_WIDTH = 2688;
    private android.widget.ImageButton btnBack;
    private android.widget.ImageButton btnCapture;
    private android.widget.TextView btnConfirm;
    private android.widget.TextView btnFlash;
    private android.widget.ImageButton btnGrid;
    private android.widget.TextView btnGuide;
    private androidx.camera.core.CameraControl cameraControl;
    private androidx.camera.lifecycle.ProcessCameraProvider cameraProvider;
    private android.view.View captureRectOverlay;
    private java.lang.String configJson;
    private android.widget.TextView counterText;
    private android.widget.ImageView counterThumbnail;
    private android.widget.FrameLayout galleryButton;
    private android.widget.ImageView galleryIcon;
    private com.up366.photopicker.ui.camera.GridOverlayView gridOverlay;
    private boolean hasShownClipAutoGuide;
    private boolean hasTorchSupport;
    private androidx.camera.core.ImageCapture imageCapture;
    private boolean isCapturing;
    private boolean isFlashOn;
    private boolean isGridOn;
    private boolean isMultipleMode;
    private boolean isPhotosExpanded;
    private android.widget.LinearLayout photoThumbnails;
    private androidx.camera.view.PreviewView previewView;
    private android.widget.HorizontalScrollView scrollPhotos;
    private android.widget.TextView tabMultiple;
    private android.widget.TextView tabSingle;
    private android.widget.TextView tvCaptureHint;
    private android.widget.TextView tvMaxPageHint;
    private com.up366.photopicker.ui.WebViewDialog webViewDialog;
    private final java.util.List<java.lang.String> photoPaths = new java.util.ArrayList();
    private final java.util.List<java.io.File> photoFiles = new java.util.ArrayList();
    private final java.util.List<java.lang.Boolean> photoRectAdjustedStates = new java.util.ArrayList();
    private int lastCropIndex = -1;
    private android.graphics.RectF previewContentRect = new android.graphics.RectF();
    private android.graphics.RectF previewVisibleRatio = new android.graphics.RectF(0.0f, 0.0f, 1.0f, 1.0f);
    private android.graphics.RectF captureRectViewRatio = new android.graphics.RectF(0.0f, 0.0f, 1.0f, 1.0f);
    private android.graphics.RectF captureRectRatio = new android.graphics.RectF(0.2f, 0.2f, 0.8f, 0.8f);
    private final java.util.concurrent.ExecutorService ioExecutor = java.util.concurrent.Executors.newSingleThreadExecutor();
    private final java.lang.Runnable hideMaxPageHintRunnable = new java.lang.Runnable() { // from class: com.up366.photopicker.ui.camera.CameraActivity$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            com.up366.photopicker.ui.camera.CameraActivity.hideMaxPageHintRunnable$lambda$0(this.f$0);
        }
    };
    private com.up366.photopicker.config.CameraPageSetting cameraPageSetting = new com.up366.photopicker.config.CameraPageSetting();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideMaxPageHintRunnable$lambda$0(com.up366.photopicker.ui.camera.CameraActivity cameraActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraActivity, "this$0");
        if (cameraActivity.isFinishing() || cameraActivity.isDestroyed()) {
            return;
        }
        android.widget.TextView textView = cameraActivity.tvMaxPageHint;
        if (textView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvMaxPageHint");
            textView = null;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CameraActivity.kt */
    @kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/up366/photopicker/ui/camera/CameraActivity$PreparedCaptureResult;", "", "photoPath", "", "initialCropRatio", "Landroid/graphics/RectF;", "visibleRatio", "(Ljava/lang/String;Landroid/graphics/RectF;Landroid/graphics/RectF;)V", "getInitialCropRatio", "()Landroid/graphics/RectF;", "getPhotoPath", "()Ljava/lang/String;", "getVisibleRatio", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final /* data */ class PreparedCaptureResult {
        private final android.graphics.RectF initialCropRatio;
        private final java.lang.String photoPath;
        private final android.graphics.RectF visibleRatio;

        public static /* synthetic */ com.up366.photopicker.ui.camera.CameraActivity.PreparedCaptureResult copy$default(com.up366.photopicker.ui.camera.CameraActivity.PreparedCaptureResult preparedCaptureResult, java.lang.String str, android.graphics.RectF rectF, android.graphics.RectF rectF2, int i, java.lang.Object obj) {
            if ((i & 1) != 0) {
                str = preparedCaptureResult.photoPath;
            }
            if ((i & 2) != 0) {
                rectF = preparedCaptureResult.initialCropRatio;
            }
            if ((i & 4) != 0) {
                rectF2 = preparedCaptureResult.visibleRatio;
            }
            return preparedCaptureResult.copy(str, rectF, rectF2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final java.lang.String getPhotoPath() {
            return this.photoPath;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final android.graphics.RectF getInitialCropRatio() {
            return this.initialCropRatio;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final android.graphics.RectF getVisibleRatio() {
            return this.visibleRatio;
        }

        public final com.up366.photopicker.ui.camera.CameraActivity.PreparedCaptureResult copy(java.lang.String photoPath, android.graphics.RectF initialCropRatio, android.graphics.RectF visibleRatio) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(photoPath, "photoPath");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(initialCropRatio, "initialCropRatio");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibleRatio, "visibleRatio");
            return new com.up366.photopicker.ui.camera.CameraActivity.PreparedCaptureResult(photoPath, initialCropRatio, visibleRatio);
        }

        public boolean equals(java.lang.Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof com.up366.photopicker.ui.camera.CameraActivity.PreparedCaptureResult)) {
                return false;
            }
            com.up366.photopicker.ui.camera.CameraActivity.PreparedCaptureResult preparedCaptureResult = (com.up366.photopicker.ui.camera.CameraActivity.PreparedCaptureResult) other;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.photoPath, preparedCaptureResult.photoPath) && kotlin.jvm.internal.Intrinsics.areEqual(this.initialCropRatio, preparedCaptureResult.initialCropRatio) && kotlin.jvm.internal.Intrinsics.areEqual(this.visibleRatio, preparedCaptureResult.visibleRatio);
        }

        public int hashCode() {
            return (((this.photoPath.hashCode() * 31) + this.initialCropRatio.hashCode()) * 31) + this.visibleRatio.hashCode();
        }

        public java.lang.String toString() {
            return "PreparedCaptureResult(photoPath=" + this.photoPath + ", initialCropRatio=" + this.initialCropRatio + ", visibleRatio=" + this.visibleRatio + ')';
        }

        public PreparedCaptureResult(java.lang.String str, android.graphics.RectF rectF, android.graphics.RectF rectF2) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "photoPath");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rectF, "initialCropRatio");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rectF2, "visibleRatio");
            this.photoPath = str;
            this.initialCropRatio = rectF;
            this.visibleRatio = rectF2;
        }

        public final android.graphics.RectF getInitialCropRatio() {
            return this.initialCropRatio;
        }

        public final java.lang.String getPhotoPath() {
            return this.photoPath;
        }

        public final android.graphics.RectF getVisibleRatio() {
            return this.visibleRatio;
        }
    }

    /* JADX INFO: compiled from: CameraActivity.kt */
    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/up366/photopicker/ui/camera/CameraActivity$PreviewMappingResult;", "", "visibleRatio", "Landroid/graphics/RectF;", "captureRatio", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)V", "getCaptureRatio", "()Landroid/graphics/RectF;", "getVisibleRatio", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final /* data */ class PreviewMappingResult {
        private final android.graphics.RectF captureRatio;
        private final android.graphics.RectF visibleRatio;

        public static /* synthetic */ com.up366.photopicker.ui.camera.CameraActivity.PreviewMappingResult copy$default(com.up366.photopicker.ui.camera.CameraActivity.PreviewMappingResult previewMappingResult, android.graphics.RectF rectF, android.graphics.RectF rectF2, int i, java.lang.Object obj) {
            if ((i & 1) != 0) {
                rectF = previewMappingResult.visibleRatio;
            }
            if ((i & 2) != 0) {
                rectF2 = previewMappingResult.captureRatio;
            }
            return previewMappingResult.copy(rectF, rectF2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final android.graphics.RectF getVisibleRatio() {
            return this.visibleRatio;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final android.graphics.RectF getCaptureRatio() {
            return this.captureRatio;
        }

        public final com.up366.photopicker.ui.camera.CameraActivity.PreviewMappingResult copy(android.graphics.RectF visibleRatio, android.graphics.RectF captureRatio) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibleRatio, "visibleRatio");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(captureRatio, "captureRatio");
            return new com.up366.photopicker.ui.camera.CameraActivity.PreviewMappingResult(visibleRatio, captureRatio);
        }

        public boolean equals(java.lang.Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof com.up366.photopicker.ui.camera.CameraActivity.PreviewMappingResult)) {
                return false;
            }
            com.up366.photopicker.ui.camera.CameraActivity.PreviewMappingResult previewMappingResult = (com.up366.photopicker.ui.camera.CameraActivity.PreviewMappingResult) other;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.visibleRatio, previewMappingResult.visibleRatio) && kotlin.jvm.internal.Intrinsics.areEqual(this.captureRatio, previewMappingResult.captureRatio);
        }

        public int hashCode() {
            return (this.visibleRatio.hashCode() * 31) + this.captureRatio.hashCode();
        }

        public java.lang.String toString() {
            return "PreviewMappingResult(visibleRatio=" + this.visibleRatio + ", captureRatio=" + this.captureRatio + ')';
        }

        public PreviewMappingResult(android.graphics.RectF rectF, android.graphics.RectF rectF2) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rectF, "visibleRatio");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rectF2, "captureRatio");
            this.visibleRatio = rectF;
            this.captureRatio = rectF2;
        }

        public final android.graphics.RectF getCaptureRatio() {
            return this.captureRatio;
        }

        public final android.graphics.RectF getVisibleRatio() {
            return this.visibleRatio;
        }
    }

    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.up366.photopicker.R.layout.up366_photo_picker_activity_camera);
        boolean z = false;
        if (savedInstanceState != null && savedInstanceState.getBoolean(com.up366.photopicker.PhotoPickerConstants.EXTRA_SHOW_CLIP_AUTO_GUIDE, false)) {
            z = true;
        }
        this.hasShownClipAutoGuide = z;
        readConfig();
        com.up366.common.log.Logger.info("CameraActivity onCreate, maxPage=" + this.cameraPageSetting.getMaxPage() + ", multiplyAvailable=" + this.cameraPageSetting.isMultiplyAvailable());
        setupFullScreen();
        initViews();
        applyPressedFeedback();
        setupTabSwitch();
        setupClickListeners();
        applyConfig();
        checkCameraPermissionAndStart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void readConfig() {
        java.lang.String stringExtra = getIntent().getStringExtra("config");
        this.configJson = stringExtra;
        com.up366.photopicker.config.PhotoPickerConfig photoPickerConfig = (com.up366.photopicker.config.PhotoPickerConfig) com.alibaba.fastjson.JSON.parseObject(stringExtra, com.up366.photopicker.config.PhotoPickerConfig.class);
        if (photoPickerConfig != null) {
            com.up366.photopicker.config.CameraPageSetting cameraPageSetting = photoPickerConfig.getCameraPageSetting();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cameraPageSetting, "it.cameraPageSetting");
            this.cameraPageSetting = cameraPageSetting;
        }
        com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE.init(this.configJson);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("isReshoot", java.lang.Boolean.valueOf(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE.isReshoot()));
        kotlin.Unit unit = kotlin.Unit.INSTANCE;
        com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE.enterPage((android.app.Activity) this, jSONObject);
        com.up366.common.log.Logger.info("CameraActivity readConfig, guideType=" + this.cameraPageSetting.getGuideSetting().getShownType() + ", gridHidden=" + this.cameraPageSetting.isGridButtonHidden());
    }

    private final void initViews() {
        androidx.camera.view.PreviewView previewViewFindViewById = findViewById(com.up366.photopicker.R.id.previewView);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(previewViewFindViewById, "findViewById(R.id.previewView)");
        androidx.camera.view.PreviewView previewView = previewViewFindViewById;
        this.previewView = previewView;
        androidx.camera.view.PreviewView previewView2 = null;
        if (previewView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("previewView");
            previewView = null;
        }
        previewView.setImplementationMode(androidx.camera.view.PreviewView.ImplementationMode.PERFORMANCE);
        androidx.camera.view.PreviewView previewView3 = this.previewView;
        if (previewView3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("previewView");
        } else {
            previewView2 = previewView3;
        }
        previewView2.setScaleType(androidx.camera.view.PreviewView.ScaleType.FILL_CENTER);
        android.view.View viewFindViewById = findViewById(com.up366.photopicker.R.id.gridOverlay);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.gridOverlay)");
        this.gridOverlay = (com.up366.photopicker.ui.camera.GridOverlayView) viewFindViewById;
        android.view.View viewFindViewById2 = findViewById(com.up366.photopicker.R.id.captureRectOverlay);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.captureRectOverlay)");
        this.captureRectOverlay = viewFindViewById2;
        android.view.View viewFindViewById3 = findViewById(com.up366.photopicker.R.id.tvCaptureHint);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.tvCaptureHint)");
        this.tvCaptureHint = (android.widget.TextView) viewFindViewById3;
        android.view.View viewFindViewById4 = findViewById(com.up366.photopicker.R.id.tvMaxPageHint);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(R.id.tvMaxPageHint)");
        this.tvMaxPageHint = (android.widget.TextView) viewFindViewById4;
        android.view.View viewFindViewById5 = findViewById(com.up366.photopicker.R.id.btnCapture);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(R.id.btnCapture)");
        this.btnCapture = (android.widget.ImageButton) viewFindViewById5;
        android.view.View viewFindViewById6 = findViewById(com.up366.photopicker.R.id.btnConfirm);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(R.id.btnConfirm)");
        this.btnConfirm = (android.widget.TextView) viewFindViewById6;
        android.view.View viewFindViewById7 = findViewById(com.up366.photopicker.R.id.btnBack);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(R.id.btnBack)");
        this.btnBack = (android.widget.ImageButton) viewFindViewById7;
        android.view.View viewFindViewById8 = findViewById(com.up366.photopicker.R.id.btnFlash);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(R.id.btnFlash)");
        this.btnFlash = (android.widget.TextView) viewFindViewById8;
        android.view.View viewFindViewById9 = findViewById(com.up366.photopicker.R.id.btnGrid);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(R.id.btnGrid)");
        this.btnGrid = (android.widget.ImageButton) viewFindViewById9;
        android.view.View viewFindViewById10 = findViewById(com.up366.photopicker.R.id.btnGuide);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(R.id.btnGuide)");
        this.btnGuide = (android.widget.TextView) viewFindViewById10;
        android.view.View viewFindViewById11 = findViewById(com.up366.photopicker.R.id.galleryButton);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(R.id.galleryButton)");
        this.galleryButton = (android.widget.FrameLayout) viewFindViewById11;
        android.view.View viewFindViewById12 = findViewById(com.up366.photopicker.R.id.galleryIcon);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(R.id.galleryIcon)");
        this.galleryIcon = (android.widget.ImageView) viewFindViewById12;
        android.view.View viewFindViewById13 = findViewById(com.up366.photopicker.R.id.counterThumbnail);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(R.id.counterThumbnail)");
        this.counterThumbnail = (android.widget.ImageView) viewFindViewById13;
        android.view.View viewFindViewById14 = findViewById(com.up366.photopicker.R.id.counterText);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(R.id.counterText)");
        this.counterText = (android.widget.TextView) viewFindViewById14;
        android.view.View viewFindViewById15 = findViewById(com.up366.photopicker.R.id.tabSingle);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(R.id.tabSingle)");
        this.tabSingle = (android.widget.TextView) viewFindViewById15;
        android.view.View viewFindViewById16 = findViewById(com.up366.photopicker.R.id.tabMultiple);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(R.id.tabMultiple)");
        this.tabMultiple = (android.widget.TextView) viewFindViewById16;
        android.view.View viewFindViewById17 = findViewById(com.up366.photopicker.R.id.photoThumbnails);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(R.id.photoThumbnails)");
        this.photoThumbnails = (android.widget.LinearLayout) viewFindViewById17;
        android.view.View viewFindViewById18 = findViewById(com.up366.photopicker.R.id.scrollPhotos);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(R.id.scrollPhotos)");
        this.scrollPhotos = (android.widget.HorizontalScrollView) viewFindViewById18;
        updateFlashAvailability(getPackageManager().hasSystemFeature("android.hardware.camera.flash"));
    }

    private final void applyPressedFeedback() {
        android.view.View[] viewArr = new android.view.View[8];
        android.widget.ImageButton imageButton = this.btnCapture;
        if (imageButton == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
            imageButton = null;
        }
        viewArr[0] = imageButton;
        android.widget.TextView textView = this.btnConfirm;
        if (textView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            textView = null;
        }
        viewArr[1] = textView;
        android.widget.ImageButton imageButton2 = this.btnBack;
        if (imageButton2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            imageButton2 = null;
        }
        viewArr[2] = imageButton2;
        android.widget.TextView textView2 = this.btnFlash;
        if (textView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnFlash");
            textView2 = null;
        }
        viewArr[3] = textView2;
        android.widget.ImageButton imageButton3 = this.btnGrid;
        if (imageButton3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnGrid");
            imageButton3 = null;
        }
        viewArr[4] = imageButton3;
        android.widget.TextView textView3 = this.btnGuide;
        if (textView3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnGuide");
            textView3 = null;
        }
        viewArr[5] = textView3;
        android.widget.TextView textView4 = this.tabSingle;
        if (textView4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tabSingle");
            textView4 = null;
        }
        viewArr[6] = textView4;
        android.widget.TextView textView5 = this.tabMultiple;
        if (textView5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tabMultiple");
            textView5 = null;
        }
        viewArr[7] = textView5;
        java.util.Iterator it = kotlin.collections.CollectionsKt.listOf(viewArr).iterator();
        while (it.hasNext()) {
            com.up366.photopicker.ui.SafeClickKt.enablePressedAlphaFeedback$default((android.view.View) it.next(), 0.0f, 0.0f, 3, null);
        }
        updateGalleryButtonPressedFeedback();
    }

    private final void updateGalleryButtonPressedFeedback() {
        if (this.isMultipleMode) {
            android.widget.FrameLayout frameLayout = this.galleryButton;
            if (frameLayout == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
                frameLayout = null;
            }
            com.up366.photopicker.ui.SafeClickKt.disablePressedAlphaFeedback$default(frameLayout, 0.0f, 1, null);
            return;
        }
        android.widget.FrameLayout frameLayout2 = this.galleryButton;
        if (frameLayout2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
            frameLayout2 = null;
        }
        com.up366.photopicker.ui.SafeClickKt.enablePressedAlphaFeedback$default(frameLayout2, 0.0f, 0.0f, 3, null);
    }

    private final void setupTabSwitch() {
        updateTabUI(true);
        android.widget.TextView textView = this.tabSingle;
        android.widget.TextView textView2 = null;
        if (textView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tabSingle");
            textView = null;
        }
        textView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.camera.CameraActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.photopicker.ui.camera.CameraActivity.setupTabSwitch$lambda$4(this.f$0, view);
            }
        });
        android.widget.TextView textView3 = this.tabMultiple;
        if (textView3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tabMultiple");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.camera.CameraActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.photopicker.ui.camera.CameraActivity.setupTabSwitch$lambda$5(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setupTabSwitch$lambda$4(com.up366.photopicker.ui.camera.CameraActivity cameraActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraActivity, "this$0");
        com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) cameraActivity, "single_button", null, 4, null);
        if (cameraActivity.isMultipleMode && (!cameraActivity.photoPaths.isEmpty())) {
            cameraActivity.showSwitchToSingleConfirmDialog();
        } else {
            cameraActivity.updateTabUI(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setupTabSwitch$lambda$5(com.up366.photopicker.ui.camera.CameraActivity cameraActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraActivity, "this$0");
        com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) cameraActivity, "multiply_button", null, 4, null);
        cameraActivity.updateTabUI(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showSwitchToSingleConfirmDialog() {
        com.up366.photopicker.oplog.PhotoPickerOpLogHelper.other$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) this, "single_confirm_alert_show", null, null, 8, null);
        android.view.View viewInflate = getLayoutInflater().inflate(com.up366.photopicker.R.layout.up366_photo_picker_dialog_switch_mode, (android.view.ViewGroup) null);
        android.widget.TextView textView = (android.widget.TextView) viewInflate.findViewById(com.up366.photopicker.R.id.tvSwitchTitle);
        android.widget.TextView textView2 = (android.widget.TextView) viewInflate.findViewById(com.up366.photopicker.R.id.tvSwitchContent);
        android.widget.TextView textView3 = (android.widget.TextView) viewInflate.findViewById(com.up366.photopicker.R.id.btnSwitchCancel);
        android.widget.TextView textView4 = (android.widget.TextView) viewInflate.findViewById(com.up366.photopicker.R.id.btnSwitchConfirm);
        textView.setText("切换到单页拍模式");
        textView2.setText("跨页拍中有已拍照片\n切换类型会清空已拍照片");
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder((android.content.Context) this);
        builder.setView(viewInflate);
        builder.setCancelable(true);
        final android.app.AlertDialog alertDialogCreate = builder.create();
        textView3.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.camera.CameraActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.photopicker.ui.camera.CameraActivity.showSwitchToSingleConfirmDialog$lambda$6(this.f$0, alertDialogCreate, view);
            }
        });
        textView4.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.camera.CameraActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.photopicker.ui.camera.CameraActivity.showSwitchToSingleConfirmDialog$lambda$7(this.f$0, alertDialogCreate, view);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(textView3, "btnCancel");
        com.up366.photopicker.ui.SafeClickKt.enablePressedAlphaFeedback$default(textView3, 0.0f, 0.0f, 3, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(textView4, "btnConfirm");
        com.up366.photopicker.ui.SafeClickKt.enablePressedAlphaFeedback$default(textView4, 0.0f, 0.0f, 3, null);
        alertDialogCreate.show();
        android.view.Window window = alertDialogCreate.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showSwitchToSingleConfirmDialog$lambda$6(com.up366.photopicker.ui.camera.CameraActivity cameraActivity, android.app.AlertDialog alertDialog, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraActivity, "this$0");
        com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) cameraActivity, "single_confirm_alert_cancel", null, 4, null);
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showSwitchToSingleConfirmDialog$lambda$7(com.up366.photopicker.ui.camera.CameraActivity cameraActivity, android.app.AlertDialog alertDialog, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraActivity, "this$0");
        com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) cameraActivity, "single_confirm_alert_confirm", null, 4, null);
        cameraActivity.clearCapturedPhotos();
        android.widget.LinearLayout linearLayout = cameraActivity.photoThumbnails;
        if (linearLayout == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("photoThumbnails");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        cameraActivity.updateTabUI(true);
        alertDialog.dismiss();
    }

    private final void updateTabUI(boolean isSingle) {
        this.isMultipleMode = !isSingle;
        android.widget.TextView textView = null;
        android.widget.HorizontalScrollView horizontalScrollView = null;
        if (isSingle) {
            android.widget.TextView textView2 = this.tabSingle;
            if (textView2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tabSingle");
                textView2 = null;
            }
            textView2.setBackgroundResource(com.up366.photopicker.R.drawable.photo_picker_camera_tab_background);
            android.widget.TextView textView3 = this.tabMultiple;
            if (textView3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tabMultiple");
                textView3 = null;
            }
            textView3.setBackgroundColor(0);
            android.widget.TextView textView4 = this.tabSingle;
            if (textView4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tabSingle");
                textView4 = null;
            }
            textView4.setTextColor(com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR);
            android.widget.TextView textView5 = this.tabMultiple;
            if (textView5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tabMultiple");
                textView5 = null;
            }
            textView5.setTextColor(-1);
            android.widget.TextView textView6 = this.btnConfirm;
            if (textView6 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
                textView6 = null;
            }
            textView6.setVisibility(4);
            android.widget.ImageView imageView = this.galleryIcon;
            if (imageView == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("galleryIcon");
                imageView = null;
            }
            imageView.setVisibility(0);
            android.widget.ImageView imageView2 = this.galleryIcon;
            if (imageView2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("galleryIcon");
                imageView2 = null;
            }
            imageView2.setImageResource(com.up366.photopicker.R.drawable.photo_picker_gally);
            android.widget.ImageView imageView3 = this.counterThumbnail;
            if (imageView3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("counterThumbnail");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
            android.widget.TextView textView7 = this.counterText;
            if (textView7 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("counterText");
                textView7 = null;
            }
            textView7.setVisibility(8);
            android.widget.HorizontalScrollView horizontalScrollView2 = this.scrollPhotos;
            if (horizontalScrollView2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("scrollPhotos");
            } else {
                horizontalScrollView = horizontalScrollView2;
            }
            horizontalScrollView.setVisibility(8);
            this.isPhotosExpanded = false;
        } else {
            android.widget.TextView textView8 = this.tabMultiple;
            if (textView8 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tabMultiple");
                textView8 = null;
            }
            textView8.setBackgroundResource(com.up366.photopicker.R.drawable.photo_picker_camera_tab_background);
            android.widget.TextView textView9 = this.tabSingle;
            if (textView9 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tabSingle");
                textView9 = null;
            }
            textView9.setBackgroundColor(0);
            android.widget.TextView textView10 = this.tabMultiple;
            if (textView10 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tabMultiple");
                textView10 = null;
            }
            textView10.setTextColor(com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR);
            android.widget.TextView textView11 = this.tabSingle;
            if (textView11 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tabSingle");
            } else {
                textView = textView11;
            }
            textView.setTextColor(-1);
            updateConfirmVisibility();
            updatePhotoCounter();
        }
        updateConfirmVisibility();
        updateCaptureHint();
        updateGalleryButtonPressedFeedback();
    }

    private final void updateConfirmVisibility() {
        android.widget.TextView textView = this.btnConfirm;
        if (textView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            textView = null;
        }
        textView.setVisibility((this.isMultipleMode && (this.photoPaths.isEmpty() ^ true)) ? 0 : 4);
    }

    private final void setupClickListeners() {
        android.widget.ImageButton imageButton = this.btnBack;
        com.up366.photopicker.ui.camera.GridOverlayView gridOverlayView = null;
        if (imageButton == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            imageButton = null;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(imageButton, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.camera.CameraActivity.setupClickListeners.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, com.igexin.push.g.q.f);
                com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) com.up366.photopicker.ui.camera.CameraActivity.this, "back_button", null, 4, null);
                com.up366.photopicker.ui.camera.CameraActivity.this.finish();
            }
        }, 1, null);
        android.widget.ImageButton imageButton2 = this.btnCapture;
        if (imageButton2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
            imageButton2 = null;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(imageButton2, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.camera.CameraActivity.setupClickListeners.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, com.igexin.push.g.q.f);
                com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) com.up366.photopicker.ui.camera.CameraActivity.this, "camera_shoot", null, 4, null);
                com.up366.photopicker.ui.camera.CameraActivity.this.takePhoto();
            }
        }, 1, null);
        android.widget.TextView textView = this.btnConfirm;
        if (textView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            textView = null;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(textView, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.camera.CameraActivity.setupClickListeners.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, com.igexin.push.g.q.f);
                if (!com.up366.photopicker.ui.camera.CameraActivity.this.photoPaths.isEmpty()) {
                    com.up366.photopicker.oplog.PhotoPickerOpLogHelper photoPickerOpLogHelper = com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE;
                    android.app.Activity activity = (android.app.Activity) com.up366.photopicker.ui.camera.CameraActivity.this;
                    com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                    jSONObject.put("imageCount", java.lang.Integer.valueOf(com.up366.photopicker.ui.camera.CameraActivity.this.photoPaths.size()));
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    photoPickerOpLogHelper.click(activity, "submit_button", jSONObject);
                    com.up366.photopicker.ui.camera.CameraActivity.this.returnPhotos();
                    return;
                }
                com.up366.photopicker.oplog.PhotoPickerOpLogHelper photoPickerOpLogHelper2 = com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE;
                android.app.Activity activity2 = (android.app.Activity) com.up366.photopicker.ui.camera.CameraActivity.this;
                com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
                jSONObject2.put("imageCount", 0);
                kotlin.Unit unit2 = kotlin.Unit.INSTANCE;
                photoPickerOpLogHelper2.click(activity2, "submit_button", jSONObject2);
                android.widget.Toast.makeText((android.content.Context) com.up366.photopicker.ui.camera.CameraActivity.this, "请先拍照", 0).show();
            }
        }, 1, null);
        android.widget.TextView textView2 = this.btnFlash;
        if (textView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnFlash");
            textView2 = null;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(textView2, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.camera.CameraActivity.setupClickListeners.4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, com.igexin.push.g.q.f);
                com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) com.up366.photopicker.ui.camera.CameraActivity.this, "torch_button", null, 4, null);
                com.up366.photopicker.ui.camera.CameraActivity.this.toggleFlash();
            }
        }, 1, null);
        android.widget.ImageButton imageButton3 = this.btnGrid;
        if (imageButton3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnGrid");
            imageButton3 = null;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(imageButton3, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.camera.CameraActivity.setupClickListeners.5
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, com.igexin.push.g.q.f);
                com.up366.photopicker.ui.camera.CameraActivity.this.toggleGrid();
            }
        }, 1, null);
        android.widget.TextView textView3 = this.btnGuide;
        if (textView3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnGuide");
            textView3 = null;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(textView3, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.camera.CameraActivity.setupClickListeners.6
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, com.igexin.push.g.q.f);
                com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) com.up366.photopicker.ui.camera.CameraActivity.this, "tutorial_button", null, 4, null);
                com.up366.photopicker.ui.camera.CameraActivity.this.showGuide();
            }
        }, 1, null);
        android.widget.FrameLayout frameLayout = this.galleryButton;
        if (frameLayout == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
            frameLayout = null;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(frameLayout, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.camera.CameraActivity.setupClickListeners.7
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, com.igexin.push.g.q.f);
                if (!com.up366.photopicker.ui.camera.CameraActivity.this.isMultipleMode) {
                    com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) com.up366.photopicker.ui.camera.CameraActivity.this, "photo_album_button", null, 4, null);
                    com.up366.photopicker.ui.camera.CameraActivity.this.openGallery();
                } else {
                    com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) com.up366.photopicker.ui.camera.CameraActivity.this, "image_list_button", null, 4, null);
                    com.up366.photopicker.ui.camera.CameraActivity.this.togglePhotosExpand();
                }
            }
        }, 1, null);
        androidx.camera.view.PreviewView previewView = this.previewView;
        if (previewView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("previewView");
            previewView = null;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default((android.view.View) previewView, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.camera.CameraActivity.setupClickListeners.8
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, com.igexin.push.g.q.f);
                if (com.up366.photopicker.ui.camera.CameraActivity.this.isPhotosExpanded) {
                    com.up366.photopicker.ui.camera.CameraActivity.this.togglePhotosExpand();
                }
            }
        }, 1, null);
        com.up366.photopicker.ui.camera.GridOverlayView gridOverlayView2 = this.gridOverlay;
        if (gridOverlayView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("gridOverlay");
        } else {
            gridOverlayView = gridOverlayView2;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(gridOverlayView, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.camera.CameraActivity.setupClickListeners.9
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, com.igexin.push.g.q.f);
                if (com.up366.photopicker.ui.camera.CameraActivity.this.isPhotosExpanded) {
                    com.up366.photopicker.ui.camera.CameraActivity.this.togglePhotosExpand();
                }
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void togglePhotosExpand() {
        if (!this.isMultipleMode || this.photoPaths.isEmpty()) {
            return;
        }
        this.isPhotosExpanded = !this.isPhotosExpanded;
        android.widget.HorizontalScrollView horizontalScrollView = this.scrollPhotos;
        if (horizontalScrollView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("scrollPhotos");
            horizontalScrollView = null;
        }
        horizontalScrollView.setVisibility(this.isPhotosExpanded ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void openGallery() {
        com.up366.common.log.Logger.info("CameraActivity 打开相册选择页");
        android.content.Intent intent = new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.photopicker.ui.gallery.GalleryActivity.class);
        intent.putExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_GALLERY_MULTI_SELECT, false);
        java.lang.String str = this.configJson;
        if (str != null) {
            intent.putExtra("config", str);
        }
        startActivityForResult(intent, REQUEST_GALLERY);
    }

    private final void setupFullScreen() {
        androidx.core.view.WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().getDecorView().setSystemUiVisibility(5894);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            android.view.Window window = getWindow();
            android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
            com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(attributes, 1);
            window.setAttributes(attributes);
        }
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            android.view.WindowInsetsController windowInsetsControllerM = androidx.core.util.HalfKt$.ExternalSyntheticApiModelOutline0.m(getWindow());
            if (windowInsetsControllerM != null) {
                androidx.core.util.HalfKt$.ExternalSyntheticApiModelOutline0.m(windowInsetsControllerM, androidx.core.util.HalfKt$.ExternalSyntheticApiModelOutline0.m() | androidx.core.util.HalfKt$.ExternalSyntheticApiModelOutline0.m$1());
                androidx.core.util.HalfKt$.ExternalSyntheticApiModelOutline0.m$1(windowInsetsControllerM, 2);
                return;
            }
            return;
        }
        getWindow().addFlags(1024);
        getWindow().addFlags(512);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void checkCameraPermissionAndStart() {
        com.up366.common.log.Logger.info("CameraActivity 检查相机权限并准备启动相机");
        android.content.Context context = (android.content.Context) this;
        if (!com.up366.photopicker.PhotoPicker.isCameraAvailable(context)) {
            finishWithLaunchFailure(new com.up366.photopicker.PhotoPickerLaunchResult(false, com.up366.photopicker.PhotoPickerErrorCode.CAMERA_UNAVAILABLE, com.up366.photopicker.PhotoPicker.getCameraUnavailableMessage(context)));
        } else if (checkSelfPermission(com.up366.mobile.common.utils.permissions.Permission.CAMERA) == 0) {
            com.up366.common.log.Logger.info("CameraActivity 相机权限已授予");
            startCamera();
        } else {
            com.up366.common.log.Logger.info("CameraActivity 请求相机权限");
            requestPermissions(new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, REQUEST_CROP);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int requestCode, java.lang.String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(permissions, "permissions");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CROP) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                com.up366.common.log.Logger.info("CameraActivity 相机权限申请通过");
                startCamera();
                return;
            }
        }
        com.up366.common.log.Logger.error("CameraActivity 相机权限被拒绝");
        finishWithLaunchFailure(new com.up366.photopicker.PhotoPickerLaunchResult(false, com.up366.photopicker.PhotoPickerErrorCode.PERMISSION_DENIED, com.up366.photopicker.PhotoPicker.getPermissionDeniedMessage((android.content.Context) this)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void startCamera() {
        com.up366.common.log.Logger.info("CameraActivity 开始启动相机");
        android.content.Context context = (android.content.Context) this;
        final com.google.common.util.concurrent.ListenableFuture processCameraProvider = androidx.camera.lifecycle.ProcessCameraProvider.getInstance(context);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(processCameraProvider, "getInstance(this)");
        processCameraProvider.addListener(new java.lang.Runnable() { // from class: com.up366.photopicker.ui.camera.CameraActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.photopicker.ui.camera.CameraActivity.startCamera$lambda$12(this.f$0, processCameraProvider);
            }
        }, androidx.core.content.ContextCompat.getMainExecutor(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void startCamera$lambda$12(com.up366.photopicker.ui.camera.CameraActivity cameraActivity, com.google.common.util.concurrent.ListenableFuture listenableFuture) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraActivity, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(listenableFuture, "$cameraProviderFuture");
        if (cameraActivity.isFinishing() || cameraActivity.isDestroyed()) {
            return;
        }
        cameraActivity.cameraProvider = (androidx.camera.lifecycle.ProcessCameraProvider) listenableFuture.get();
        int iResolveTargetRotation = cameraActivity.resolveTargetRotation();
        androidx.camera.core.Preview.Builder targetRotation = new androidx.camera.core.Preview.Builder().setTargetAspectRatio(0).setTargetRotation(iResolveTargetRotation);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(targetRotation, "Builder().setTargetAspec…tRotation(targetRotation)");
        androidx.camera.core.ImageCapture.Builder jpegQuality = new androidx.camera.core.ImageCapture.Builder().setCaptureMode(1).setTargetResolution(cameraActivity.resolveCaptureTargetSize(iResolveTargetRotation)).setTargetRotation(iResolveTargetRotation).setJpegQuality(95);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jpegQuality, "Builder().setCaptureMode…lity(OUTPUT_JPEG_QUALITY)");
        androidx.camera.core.UseCase useCaseBuild = targetRotation.build();
        androidx.camera.view.PreviewView previewView = cameraActivity.previewView;
        if (previewView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("previewView");
            previewView = null;
        }
        useCaseBuild.setSurfaceProvider(previewView.getSurfaceProvider());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(useCaseBuild, "previewBuilder.build().a…ceProvider)\n            }");
        cameraActivity.imageCapture = jpegQuality.build();
        androidx.camera.core.CameraSelector cameraSelector = androidx.camera.core.CameraSelector.DEFAULT_BACK_CAMERA;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cameraSelector, "DEFAULT_BACK_CAMERA");
        try {
            androidx.camera.lifecycle.ProcessCameraProvider processCameraProvider = cameraActivity.cameraProvider;
            if (processCameraProvider != null) {
                processCameraProvider.unbindAll();
            }
            androidx.camera.lifecycle.ProcessCameraProvider processCameraProvider2 = cameraActivity.cameraProvider;
            androidx.camera.core.Camera cameraBindToLifecycle = processCameraProvider2 != null ? processCameraProvider2.bindToLifecycle((androidx.lifecycle.LifecycleOwner) cameraActivity, cameraSelector, new androidx.camera.core.UseCase[]{useCaseBuild, cameraActivity.imageCapture}) : null;
            cameraActivity.cameraControl = cameraBindToLifecycle != null ? cameraBindToLifecycle.getCameraControl() : null;
            if (cameraBindToLifecycle == null) {
                com.up366.common.log.Logger.error("CameraActivity 绑定相机失败，camera 为空");
                cameraActivity.finishWithLaunchFailure(new com.up366.photopicker.PhotoPickerLaunchResult(false, com.up366.photopicker.PhotoPickerErrorCode.CAMERA_UNAVAILABLE, com.up366.photopicker.PhotoPicker.getCameraUnavailableMessage((android.content.Context) cameraActivity)));
                return;
            }
            cameraActivity.updateFlashAvailability(cameraBindToLifecycle.getCameraInfo().hasFlashUnit());
            com.up366.common.log.Logger.info("CameraActivity 相机启动成功，目标拍照分辨率=" + cameraActivity.resolveCaptureTargetSize(iResolveTargetRotation));
            cameraActivity.updateCaptureRectFromConfig();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("CameraActivity 启动相机失败", e);
            cameraActivity.finishWithLaunchFailure(new com.up366.photopicker.PhotoPickerLaunchResult(false, com.up366.photopicker.PhotoPickerErrorCode.CAMERA_START_FAILED, com.up366.photopicker.PhotoPicker.getCameraStartFailedMessage((android.content.Context) cameraActivity)));
        }
    }

    private final int resolveTargetRotation() {
        android.view.Display display;
        androidx.camera.view.PreviewView previewView = this.previewView;
        if (previewView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("previewView");
            previewView = null;
        }
        android.view.Display display2 = previewView.getDisplay();
        if (display2 != null) {
            return display2.getRotation();
        }
        if (android.os.Build.VERSION.SDK_INT >= 30 && (display = getDisplay()) != null) {
            return display.getRotation();
        }
        android.hardware.display.DisplayManager displayManager = (android.hardware.display.DisplayManager) getSystemService(android.hardware.display.DisplayManager.class);
        android.view.Display display3 = displayManager != null ? displayManager.getDisplay(0) : null;
        if (display3 != null) {
            return display3.getRotation();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void finishWithLaunchFailure(com.up366.photopicker.PhotoPickerLaunchResult result) {
        com.up366.common.log.Logger.error("CameraActivity 启动失败 errorCode=" + result.getErrorCode() + " message=" + result.getErrorMessage());
        android.widget.Toast.makeText((android.content.Context) this, result.getErrorMessage(), 0).show();
        setResult(0, com.up366.photopicker.PhotoPicker.INSTANCE.createLaunchResultIntent$photopicker_release(result));
        finish();
        overridePendingTransition(0, 0);
    }

    private final android.util.Size resolveCaptureTargetSize(int targetRotation) {
        if (targetRotation == 1 || targetRotation == 3) {
            return new android.util.Size(TARGET_CAPTURE_HEIGHT, TARGET_CAPTURE_WIDTH);
        }
        return new android.util.Size(TARGET_CAPTURE_WIDTH, TARGET_CAPTURE_HEIGHT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void takePhoto() {
        androidx.camera.core.ImageCapture imageCapture = this.imageCapture;
        if (imageCapture == null || this.isCapturing) {
            return;
        }
        com.up366.common.log.Logger.info("CameraActivity 开始拍照，isMultipleMode=" + this.isMultipleMode + ", currentCount=" + this.photoPaths.size());
        if (this.isMultipleMode && this.photoPaths.size() >= this.cameraPageSetting.getMaxPage()) {
            com.up366.common.log.Logger.info("CameraActivity 已达到最大拍摄张数 maxPage=" + this.cameraPageSetting.getMaxPage());
            showMaxPageHint();
            return;
        }
        this.isCapturing = true;
        android.widget.ImageButton imageButton = this.btnCapture;
        if (imageButton == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
            imageButton = null;
        }
        imageButton.setEnabled(false);
        android.widget.ImageButton imageButton2 = this.btnCapture;
        if (imageButton2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
            imageButton2 = null;
        }
        imageButton2.setAlpha(0.6f);
        java.io.File externalFilesDir = getExternalFilesDir(null);
        java.io.File file = new java.io.File(externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null, "PHOTO_" + new java.text.SimpleDateFormat(FILENAME_FORMAT, java.util.Locale.CHINA).format(java.lang.Long.valueOf(java.lang.System.currentTimeMillis())) + com.up366.medialibrary.common.utils.MimeTypeUtils.JPG);
        androidx.camera.core.ImageCapture.OutputFileOptions outputFileOptionsBuild = new androidx.camera.core.ImageCapture.OutputFileOptions.Builder(file).build();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(outputFileOptionsBuild, "Builder(photoFile).build()");
        imageCapture.takePicture(outputFileOptionsBuild, androidx.core.content.ContextCompat.getMainExecutor((android.content.Context) this), new com.up366.photopicker.ui.camera.CameraActivity.C00851(file));
    }

    /* JADX INFO: renamed from: com.up366.photopicker.ui.camera.CameraActivity$takePhoto$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CameraActivity.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/up366/photopicker/ui/camera/CameraActivity$takePhoto$1", "Landroidx/camera/core/ImageCapture$OnImageSavedCallback;", "onError", "", "exc", "Landroidx/camera/core/ImageCaptureException;", "onImageSaved", "output", "Landroidx/camera/core/ImageCapture$OutputFileResults;", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C00851 implements androidx.camera.core.ImageCapture.OnImageSavedCallback {
        final /* synthetic */ java.io.File $photoFile;

        public /* synthetic */ void onCaptureProcessProgressed(int i) {
            androidx.camera.core.ImageCapture.OnImageSavedCallback.-CC.$default$onCaptureProcessProgressed(this, i);
        }

        public /* synthetic */ void onCaptureStarted() {
            androidx.camera.core.ImageCapture.OnImageSavedCallback.-CC.$default$onCaptureStarted(this);
        }

        public /* synthetic */ void onPostviewBitmapAvailable(android.graphics.Bitmap bitmap) {
            androidx.camera.core.ImageCapture.OnImageSavedCallback.-CC.$default$onPostviewBitmapAvailable(this, bitmap);
        }

        C00851(java.io.File file) {
            this.$photoFile = file;
        }

        public void onError(androidx.camera.core.ImageCaptureException exc) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(exc, "exc");
            com.up366.common.log.Logger.error("CameraActivity 拍照失败", (java.lang.Throwable) exc);
            com.up366.photopicker.ui.camera.CameraActivity.this.isCapturing = false;
            android.widget.ImageButton imageButton = com.up366.photopicker.ui.camera.CameraActivity.this.btnCapture;
            android.widget.ImageButton imageButton2 = null;
            if (imageButton == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
                imageButton = null;
            }
            imageButton.setEnabled(true);
            android.widget.ImageButton imageButton3 = com.up366.photopicker.ui.camera.CameraActivity.this.btnCapture;
            if (imageButton3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
            } else {
                imageButton2 = imageButton3;
            }
            imageButton2.setAlpha(1.0f);
            android.widget.Toast.makeText((android.content.Context) com.up366.photopicker.ui.camera.CameraActivity.this, "拍照失败: " + exc.getMessage(), 0).show();
        }

        public void onImageSaved(androidx.camera.core.ImageCapture.OutputFileResults output) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(output, "output");
            com.up366.common.log.Logger.info("CameraActivity 拍照成功，开始处理图片 path=" + this.$photoFile.getAbsolutePath());
            com.up366.photopicker.ui.camera.CameraActivity.this.isCapturing = false;
            android.widget.ImageButton imageButton = com.up366.photopicker.ui.camera.CameraActivity.this.btnCapture;
            android.widget.ImageButton imageButton2 = null;
            if (imageButton == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
                imageButton = null;
            }
            imageButton.setEnabled(true);
            android.widget.ImageButton imageButton3 = com.up366.photopicker.ui.camera.CameraActivity.this.btnCapture;
            if (imageButton3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
            } else {
                imageButton2 = imageButton3;
            }
            imageButton2.setAlpha(1.0f);
            java.util.concurrent.ExecutorService executorService = com.up366.photopicker.ui.camera.CameraActivity.this.ioExecutor;
            final com.up366.photopicker.ui.camera.CameraActivity cameraActivity = com.up366.photopicker.ui.camera.CameraActivity.this;
            final java.io.File file = this.$photoFile;
            executorService.execute(new java.lang.Runnable() { // from class: com.up366.photopicker.ui.camera.CameraActivity$takePhoto$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.photopicker.ui.camera.CameraActivity.C00851.onImageSaved$lambda$1(cameraActivity, file);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onImageSaved$lambda$1(final com.up366.photopicker.ui.camera.CameraActivity cameraActivity, java.io.File file) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraActivity, "this$0");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "$photoFile");
            final com.up366.photopicker.ui.camera.CameraActivity.PreparedCaptureResult preparedCaptureResultPrepareCapturedPhoto = cameraActivity.prepareCapturedPhoto(file);
            cameraActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.up366.photopicker.ui.camera.CameraActivity$takePhoto$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.photopicker.ui.camera.CameraActivity.C00851.onImageSaved$lambda$1$lambda$0(cameraActivity, preparedCaptureResultPrepareCapturedPhoto);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onImageSaved$lambda$1$lambda$0(com.up366.photopicker.ui.camera.CameraActivity cameraActivity, com.up366.photopicker.ui.camera.CameraActivity.PreparedCaptureResult preparedCaptureResult) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraActivity, "this$0");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(preparedCaptureResult, "$preparedResult");
            if (cameraActivity.isFinishing() || cameraActivity.isDestroyed()) {
                return;
            }
            java.io.File file = new java.io.File(preparedCaptureResult.getPhotoPath());
            cameraActivity.photoFiles.add(file);
            java.util.List list = cameraActivity.photoPaths;
            java.lang.String absolutePath = file.getAbsolutePath();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(absolutePath, "preparedFile.absolutePath");
            list.add(absolutePath);
            cameraActivity.photoRectAdjustedStates.add(false);
            java.lang.StringBuilder sb = new java.lang.StringBuilder("CameraActivity 打开裁剪页 index=");
            sb.append(cameraActivity.photoFiles.size() - 1);
            com.up366.common.log.Logger.info(sb.toString());
            java.lang.String absolutePath2 = file.getAbsolutePath();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(absolutePath2, "preparedFile.absolutePath");
            cameraActivity.openCropPage(absolutePath2, cameraActivity.photoFiles.size() - 1, preparedCaptureResult.getInitialCropRatio(), preparedCaptureResult.getVisibleRatio());
        }
    }

    private final void addThumbnailWithDelete(java.lang.String photoPath, final int index) {
        android.view.LayoutInflater layoutInflater = getLayoutInflater();
        int i = com.up366.photopicker.R.layout.up366_photo_picker_item_photo_thumbnail_with_delete;
        android.widget.LinearLayout linearLayout = this.photoThumbnails;
        android.widget.LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("photoThumbnails");
            linearLayout = null;
        }
        android.view.View viewInflate = layoutInflater.inflate(i, (android.view.ViewGroup) linearLayout, false);
        android.widget.ImageView imageView = (android.widget.ImageView) viewInflate.findViewById(com.up366.photopicker.R.id.thumbnailImage);
        android.widget.ImageView imageView2 = (android.widget.ImageView) viewInflate.findViewById(com.up366.photopicker.R.id.deleteButton);
        try {
            com.bumptech.glide.Glide.with((androidx.fragment.app.FragmentActivity) this).load(photoPath).centerCrop().apply(com.bumptech.glide.request.RequestOptions.bitmapTransform(new com.bumptech.glide.load.resource.bitmap.RoundedCorners((int) (10 * getResources().getDisplayMetrics().density)))).into(imageView);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("显示缩略图失败", e);
            try {
                imageView.setImageURI(android.net.Uri.parse(photoPath));
            } catch (java.lang.Exception unused) {
            }
        }
        imageView2.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.camera.CameraActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.photopicker.ui.camera.CameraActivity.addThumbnailWithDelete$lambda$16(this.f$0, index, view);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(imageView2, "deleteButton");
        com.up366.photopicker.ui.SafeClickKt.enablePressedAlphaFeedback$default(imageView2, 0.0f, 0.0f, 3, null);
        android.widget.LinearLayout linearLayout3 = this.photoThumbnails;
        if (linearLayout3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("photoThumbnails");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.addView(viewInflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void addThumbnailWithDelete$lambda$16(com.up366.photopicker.ui.camera.CameraActivity cameraActivity, int i, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraActivity, "this$0");
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put(com.up366.photopicker.PhotoPickerConstants.EXTRA_INDEX, java.lang.Integer.valueOf(i));
        kotlin.Unit unit = kotlin.Unit.INSTANCE;
        com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE.click((android.app.Activity) cameraActivity, "image_delete_button", jSONObject);
        cameraActivity.removePhoto(i);
    }

    private final void updatePhotoCounter() {
        android.widget.ImageView imageView = null;
        if (this.photoPaths.isEmpty()) {
            android.widget.ImageView imageView2 = this.counterThumbnail;
            if (imageView2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("counterThumbnail");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
            android.widget.TextView textView = this.counterText;
            if (textView == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("counterText");
                textView = null;
            }
            textView.setVisibility(8);
            android.widget.HorizontalScrollView horizontalScrollView = this.scrollPhotos;
            if (horizontalScrollView == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("scrollPhotos");
                horizontalScrollView = null;
            }
            horizontalScrollView.setVisibility(8);
            this.isPhotosExpanded = false;
            android.widget.ImageView imageView3 = this.galleryIcon;
            if (imageView3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("galleryIcon");
                imageView3 = null;
            }
            imageView3.setVisibility(0);
            android.widget.ImageView imageView4 = this.galleryIcon;
            if (imageView4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("galleryIcon");
            } else {
                imageView = imageView4;
            }
            imageView.setImageResource(com.up366.photopicker.R.drawable.photo_picker_gally_disable);
        } else {
            android.widget.ImageView imageView5 = this.galleryIcon;
            if (imageView5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("galleryIcon");
                imageView5 = null;
            }
            imageView5.setVisibility(8);
            android.widget.ImageView imageView6 = this.counterThumbnail;
            if (imageView6 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("counterThumbnail");
                imageView6 = null;
            }
            imageView6.setVisibility(0);
            android.widget.TextView textView2 = this.counterText;
            if (textView2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("counterText");
                textView2 = null;
            }
            textView2.setVisibility(0);
            android.widget.TextView textView3 = this.counterText;
            if (textView3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("counterText");
                textView3 = null;
            }
            textView3.setText(java.lang.String.valueOf(this.photoPaths.size()));
            if (!this.photoPaths.isEmpty()) {
                try {
                    int i = (int) (10 * getResources().getDisplayMetrics().density);
                    int i2 = (int) (38 * getResources().getDisplayMetrics().density);
                    com.bumptech.glide.RequestBuilder requestBuilderApply = com.bumptech.glide.Glide.with((androidx.fragment.app.FragmentActivity) this).load((java.lang.String) kotlin.collections.CollectionsKt.last(this.photoPaths)).apply(new com.bumptech.glide.request.RequestOptions().override(i2, i2).transform(new com.bumptech.glide.load.Transformation[]{new com.bumptech.glide.load.resource.bitmap.CenterCrop(), new com.bumptech.glide.load.resource.bitmap.RoundedCorners(i)}));
                    android.widget.ImageView imageView7 = this.counterThumbnail;
                    if (imageView7 == null) {
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("counterThumbnail");
                    } else {
                        imageView = imageView7;
                    }
                    requestBuilderApply.into(imageView);
                } catch (java.lang.Exception e) {
                    com.up366.common.log.Logger.error("加载计数缩略图失败", e);
                }
            }
        }
        updateCaptureHint();
    }

    private final void removePhoto(int index) {
        if (index < 0 || index >= this.photoPaths.size()) {
            return;
        }
        com.up366.common.log.Logger.info("CameraActivity 删除已拍照片 index=" + index);
        deleteFileQuietly(this.photoPaths.get(index));
        this.photoPaths.remove(index);
        this.photoFiles.remove(index);
        if (index >= 0 && index < this.photoRectAdjustedStates.size()) {
            this.photoRectAdjustedStates.remove(index);
        }
        android.widget.LinearLayout linearLayout = this.photoThumbnails;
        if (linearLayout == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("photoThumbnails");
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        int i = 0;
        for (java.lang.Object obj : this.photoPaths) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            addThumbnailWithDelete((java.lang.String) obj, i);
            i = i2;
        }
        updatePhotoCounter();
        updateConfirmVisibility();
    }

    private final void clearCapturedPhotos() {
        java.util.Iterator<T> it = this.photoPaths.iterator();
        while (it.hasNext()) {
            deleteFileQuietly((java.lang.String) it.next());
        }
        this.photoPaths.clear();
        this.photoFiles.clear();
        this.photoRectAdjustedStates.clear();
    }

    private final void deleteFileQuietly(java.lang.String path) {
        java.lang.String str = path;
        if (str == null || str.length() == 0) {
            return;
        }
        if (!isManagedTempFile(path)) {
            com.up366.common.log.Logger.info("跳过删除非应用临时文件 path=" + path);
        } else {
            try {
                new java.io.File(path).delete();
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("删除拍照文件失败 path=" + path, e);
            }
        }
    }

    private final boolean isManagedTempFile(java.lang.String path) {
        java.io.File externalFilesDir = getExternalFilesDir(null);
        if (externalFilesDir == null) {
            return false;
        }
        try {
            java.lang.String canonicalPath = externalFilesDir.getCanonicalPath();
            java.lang.String canonicalPath2 = new java.io.File(path).getCanonicalPath();
            if (!kotlin.jvm.internal.Intrinsics.areEqual(canonicalPath2, canonicalPath)) {
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(canonicalPath2, "filePath");
                if (!kotlin.text.StringsKt.startsWith$default(canonicalPath2, canonicalPath + java.io.File.separator, false, 2, (java.lang.Object) null)) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("判断文件是否为应用临时文件失败 path=" + path, e);
            return false;
        }
    }

    static /* synthetic */ void openCropPage$default(com.up366.photopicker.ui.camera.CameraActivity cameraActivity, java.lang.String str, int i, android.graphics.RectF rectF, android.graphics.RectF rectF2, int i2, java.lang.Object obj) {
        if ((i2 & 4) != 0) {
            rectF = cameraActivity.captureRectRatio;
        }
        if ((i2 & 8) != 0) {
            rectF2 = new android.graphics.RectF(0.0f, 0.0f, 1.0f, 1.0f);
        }
        cameraActivity.openCropPage(str, i, rectF, rectF2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void openCropPage(java.lang.String r7, int r8, android.graphics.RectF r9, android.graphics.RectF r10) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "CameraActivity openCropPage, index="
            r0.<init>(r1)
            r0.append(r8)
            java.lang.String r1 = ", path="
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.up366.common.log.Logger.info(r0)
            r6.lastCropIndex = r8
            r0 = 1
            r1 = 0
            java.lang.String r2 = r6.configJson     // Catch: java.lang.Exception -> L41
            java.lang.Class<com.up366.photopicker.config.PhotoPickerConfig> r3 = com.up366.photopicker.config.PhotoPickerConfig.class
            java.lang.Object r2 = com.alibaba.fastjson.JSON.parseObject(r2, r3)     // Catch: java.lang.Exception -> L41
            com.up366.photopicker.config.PhotoPickerConfig r2 = (com.up366.photopicker.config.PhotoPickerConfig) r2     // Catch: java.lang.Exception -> L41
            if (r2 == 0) goto L41
            com.up366.photopicker.config.ClipPageSetting r2 = r2.getClipPageSetting()     // Catch: java.lang.Exception -> L41
            if (r2 == 0) goto L41
            com.up366.photopicker.config.GuideSetting r2 = r2.getGuideSetting()     // Catch: java.lang.Exception -> L41
            if (r2 == 0) goto L41
            boolean r2 = r2.isGuideAutoShown()     // Catch: java.lang.Exception -> L41
            if (r2 != r0) goto L41
            boolean r2 = r6.hasShownClipAutoGuide     // Catch: java.lang.Exception -> L41
            if (r2 != 0) goto L41
            r2 = r0
            goto L42
        L41:
            r2 = r1
        L42:
            if (r2 == 0) goto L46
            r6.hasShownClipAutoGuide = r0
        L46:
            android.content.Intent r3 = new android.content.Intent
            r4 = r6
            android.content.Context r4 = (android.content.Context) r4
            java.lang.Class<com.up366.photopicker.ui.crop.CropActivity> r5 = com.up366.photopicker.ui.crop.CropActivity.class
            r3.<init>(r4, r5)
            java.lang.String r4 = "photo_uri"
            r3.putExtra(r4, r7)
            java.lang.String r7 = "index"
            r3.putExtra(r7, r8)
            java.lang.String r7 = "from_camera"
            r3.putExtra(r7, r0)
            java.lang.String r7 = "is_multiple_mode"
            boolean r8 = r6.isMultipleMode
            r3.putExtra(r7, r8)
            java.lang.String r7 = "show_clip_auto_guide"
            r3.putExtra(r7, r2)
            java.lang.String r7 = "initial_crop_left"
            float r8 = r9.left
            r3.putExtra(r7, r8)
            java.lang.String r7 = "initial_crop_top"
            float r8 = r9.top
            r3.putExtra(r7, r8)
            java.lang.String r7 = "initial_crop_right"
            float r8 = r9.right
            r3.putExtra(r7, r8)
            java.lang.String r7 = "initial_crop_bottom"
            float r8 = r9.bottom
            r3.putExtra(r7, r8)
            java.lang.String r7 = "visible_area_left"
            float r8 = r10.left
            r3.putExtra(r7, r8)
            java.lang.String r7 = "visible_area_top"
            float r8 = r10.top
            r3.putExtra(r7, r8)
            java.lang.String r7 = "visible_area_right"
            float r8 = r10.right
            r3.putExtra(r7, r8)
            java.lang.String r7 = "visible_area_bottom"
            float r8 = r10.bottom
            r3.putExtra(r7, r8)
            java.lang.String r7 = r6.configJson
            if (r7 == 0) goto Lac
            java.lang.String r8 = "config"
            r3.putExtra(r8, r7)
        Lac:
            r7 = 1001(0x3e9, float:1.403E-42)
            r6.startActivityForResult(r3, r7)
            r6.overridePendingTransition(r1, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.photopicker.ui.camera.CameraActivity.openCropPage(java.lang.String, int, android.graphics.RectF, android.graphics.RectF):void");
    }

    protected void onSaveInstanceState(android.os.Bundle outState) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(com.up366.photopicker.PhotoPickerConstants.EXTRA_SHOW_CLIP_AUTO_GUIDE, this.hasShownClipAutoGuide);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.up366.photopicker.ui.camera.CameraActivity.PreparedCaptureResult prepareCapturedPhoto(java.io.File photoFile) {
        android.graphics.RectF captureRatio;
        android.graphics.RectF rectF = new android.graphics.RectF(this.captureRectRatio);
        android.graphics.RectF rectF2 = new android.graphics.RectF(0.0f, 0.0f, 1.0f, 1.0f);
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(photoFile.getAbsolutePath(), options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            if (i > 0 && i2 > 0) {
                int attributeInt = new android.media.ExifInterface(photoFile.getAbsolutePath()).getAttributeInt("Orientation", 1);
                if (attributeInt == 6 || attributeInt == 8) {
                    i = i2;
                    i2 = i;
                }
                com.up366.photopicker.ui.camera.CameraActivity.PreviewMappingResult previewMappingResultBuildPreviewMappingForSource = buildPreviewMappingForSource(i, i2);
                boolean zShouldCropToPreviewVisibleArea = shouldCropToPreviewVisibleArea(previewMappingResultBuildPreviewMappingForSource.getVisibleRatio());
                if (zShouldCropToPreviewVisibleArea) {
                    captureRatio = remapRatioToVisiblePreview(previewMappingResultBuildPreviewMappingForSource.getCaptureRatio(), previewMappingResultBuildPreviewMappingForSource.getVisibleRatio());
                } else {
                    captureRatio = previewMappingResultBuildPreviewMappingForSource.getCaptureRatio();
                }
                java.lang.String absolutePath = photoFile.getAbsolutePath();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(absolutePath, "photoFile.absolutePath");
                return new com.up366.photopicker.ui.camera.CameraActivity.PreparedCaptureResult(absolutePath, captureRatio, zShouldCropToPreviewVisibleArea ? previewMappingResultBuildPreviewMappingForSource.getVisibleRatio() : rectF2);
            }
            java.lang.String absolutePath2 = photoFile.getAbsolutePath();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(absolutePath2, "photoFile.absolutePath");
            return new com.up366.photopicker.ui.camera.CameraActivity.PreparedCaptureResult(absolutePath2, rectF, rectF2);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("拍照后计算初始裁剪框失败，回退默认框", e);
            java.lang.String absolutePath3 = photoFile.getAbsolutePath();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(absolutePath3, "photoFile.absolutePath");
            return new com.up366.photopicker.ui.camera.CameraActivity.PreparedCaptureResult(absolutePath3, rectF, rectF2);
        }
    }

    private final boolean shouldCropToPreviewVisibleArea(android.graphics.RectF visibleRatio) {
        return java.lang.Math.abs(visibleRatio.left) > 0.001f || java.lang.Math.abs(visibleRatio.top) > 0.001f || java.lang.Math.abs(1.0f - visibleRatio.right) > 0.001f || java.lang.Math.abs(1.0f - visibleRatio.bottom) > 0.001f;
    }

    private final com.up366.photopicker.ui.camera.CameraActivity.PreviewMappingResult buildPreviewMappingForSource(float sourceWidth, float sourceHeight) {
        androidx.camera.view.PreviewView previewView = this.previewView;
        androidx.camera.view.PreviewView previewView2 = null;
        if (previewView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("previewView");
            previewView = null;
        }
        float fCoerceAtLeast = kotlin.ranges.RangesKt.coerceAtLeast(previewView.getWidth(), 1.0f);
        androidx.camera.view.PreviewView previewView3 = this.previewView;
        if (previewView3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("previewView");
        } else {
            previewView2 = previewView3;
        }
        float fCoerceAtLeast2 = kotlin.ranges.RangesKt.coerceAtLeast(previewView2.getHeight(), 1.0f);
        float fMax = java.lang.Math.max(fCoerceAtLeast / sourceWidth, fCoerceAtLeast2 / sourceHeight);
        float f = sourceWidth * fMax;
        float f2 = sourceHeight * fMax;
        float f3 = (fCoerceAtLeast - f) / 2.0f;
        float f4 = (fCoerceAtLeast2 - f2) / 2.0f;
        return new com.up366.photopicker.ui.camera.CameraActivity.PreviewMappingResult(new android.graphics.RectF(kotlin.ranges.RangesKt.coerceIn((0.0f - f3) / f, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((0.0f - f4) / f2, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((fCoerceAtLeast - f3) / f, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((fCoerceAtLeast2 - f4) / f2, 0.0f, 1.0f)), new android.graphics.RectF(kotlin.ranges.RangesKt.coerceIn(((this.captureRectViewRatio.left * fCoerceAtLeast) - f3) / f, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn(((this.captureRectViewRatio.top * fCoerceAtLeast2) - f4) / f2, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn(((fCoerceAtLeast * this.captureRectViewRatio.right) - f3) / f, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn(((fCoerceAtLeast2 * this.captureRectViewRatio.bottom) - f4) / f2, 0.0f, 1.0f)));
    }

    private final android.graphics.RectF remapRatioToVisiblePreview(android.graphics.RectF sourceRatio, android.graphics.RectF visibleRatio) {
        float fCoerceAtLeast = kotlin.ranges.RangesKt.coerceAtLeast(visibleRatio.right - visibleRatio.left, 1.0E-4f);
        float fCoerceAtLeast2 = kotlin.ranges.RangesKt.coerceAtLeast(visibleRatio.bottom - visibleRatio.top, 1.0E-4f);
        return new android.graphics.RectF(kotlin.ranges.RangesKt.coerceIn((sourceRatio.left - visibleRatio.left) / fCoerceAtLeast, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((sourceRatio.top - visibleRatio.top) / fCoerceAtLeast2, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((sourceRatio.right - visibleRatio.left) / fCoerceAtLeast, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((sourceRatio.bottom - visibleRatio.top) / fCoerceAtLeast2, 0.0f, 1.0f));
    }

    private final android.graphics.Bitmap loadCorrectedBitmap(java.lang.String filePath) {
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            int i = 1;
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(filePath, options);
            while (true) {
                if (options.outWidth / i <= 200 && options.outHeight / i <= 200) {
                    break;
                }
                i *= 2;
            }
            android.graphics.BitmapFactory.Options options2 = new android.graphics.BitmapFactory.Options();
            options2.inSampleSize = i;
            options2.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
            android.graphics.Bitmap bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(filePath, options2);
            if (bitmapDecodeFile != null) {
                return correctBitmapOrientation(filePath, bitmapDecodeFile);
            }
            return null;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("加载缩略图失败", e);
            return null;
        }
    }

    private final android.graphics.Bitmap correctBitmapOrientation(java.lang.String filePath, android.graphics.Bitmap bitmap) {
        try {
            int attributeInt = new android.media.ExifInterface(filePath).getAttributeInt("Orientation", 1);
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            if (attributeInt == 3) {
                matrix.postRotate(180.0f);
            } else if (attributeInt == 6) {
                matrix.postRotate(90.0f);
            } else {
                if (attributeInt != 8) {
                    return bitmap;
                }
                matrix.postRotate(270.0f);
            }
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "{\n            val exif =…, matrix, true)\n        }");
            return bitmapCreateBitmap;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("修正图片方向失败", e);
            return bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void returnPhotos() {
        com.up366.common.log.Logger.info("CameraActivity 返回拍摄结果 count=" + this.photoPaths.size());
        android.content.Intent intent = new android.content.Intent();
        java.util.List<java.lang.String> list = this.photoPaths;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        for (java.lang.Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            com.up366.photopicker.PhotoPickerPhotoResult photoPickerPhotoResultCreatePhotoResult$photopicker_release = com.up366.photopicker.PhotoPicker.INSTANCE.createPhotoResult$photopicker_release((java.lang.String) obj, kotlin.jvm.internal.Intrinsics.areEqual(kotlin.collections.CollectionsKt.getOrNull(this.photoRectAdjustedStates, i), true));
            if (photoPickerPhotoResultCreatePhotoResult$photopicker_release != null) {
                arrayList.add(photoPickerPhotoResultCreatePhotoResult$photopicker_release);
            }
            i = i2;
        }
        com.up366.photopicker.PhotoPicker.INSTANCE.putResults$photopicker_release(intent, arrayList);
        setResult(-1, intent);
        finish();
    }

    protected void onActivityResult(int requestCode, int resultCode, android.content.Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        com.up366.common.log.Logger.info("CameraActivity onActivityResult requestCode=" + requestCode + " resultCode=" + resultCode);
        int i = 0;
        if (requestCode == REQUEST_CROP) {
            overridePendingTransition(0, 0);
        }
        android.widget.LinearLayout linearLayout = null;
        if (requestCode != REQUEST_CROP || resultCode != -1 || data == null) {
            if (requestCode == REQUEST_CROP && resultCode == 0) {
                com.up366.common.log.Logger.info("CameraActivity 裁剪页取消，isMultipleMode=" + this.isMultipleMode);
                if (this.isMultipleMode) {
                    int size = this.photoPaths.size();
                    int i2 = this.lastCropIndex;
                    if (i2 < 0 || i2 >= size) {
                        return;
                    }
                    removePhoto(i2);
                    return;
                }
                clearCapturedPhotos();
                android.widget.LinearLayout linearLayout2 = this.photoThumbnails;
                if (linearLayout2 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("photoThumbnails");
                } else {
                    linearLayout = linearLayout2;
                }
                linearLayout.removeAllViews();
                updatePhotoCounter();
                return;
            }
            if (requestCode == REQUEST_GALLERY && resultCode == -1 && data != null) {
                java.util.ArrayList<java.lang.String> paths = com.up366.photopicker.PhotoPicker.parsePaths(data);
                if (!paths.isEmpty()) {
                    com.up366.common.log.Logger.info("CameraActivity 相册选择回传 count=" + paths.size());
                    if (this.isMultipleMode) {
                        return;
                    }
                    this.photoFiles.add(new java.io.File(paths.get(0)));
                    java.util.List<java.lang.String> list = this.photoPaths;
                    java.lang.String str = paths.get(0);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "photoPathsFromGallery[0]");
                    list.add(str);
                    this.photoRectAdjustedStates.add(false);
                    java.lang.String str2 = paths.get(0);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str2, "photoPathsFromGallery[0]");
                    openCropPage$default(this, str2, 0, null, null, 12, null);
                    return;
                }
                return;
            }
            return;
        }
        java.lang.String stringExtra = data.getStringExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_CROPPED_PATH);
        int intExtra = data.getIntExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_INDEX, -1);
        boolean booleanExtra = data.getBooleanExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_RETURN_DIRECTLY, false);
        boolean booleanExtra2 = data.getBooleanExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_IS_RECT_ADJUSTED, false);
        if (stringExtra == null || intExtra < 0) {
            return;
        }
        java.lang.String str3 = (java.lang.String) kotlin.collections.CollectionsKt.getOrNull(this.photoPaths, intExtra);
        this.photoPaths.set(intExtra, stringExtra);
        this.photoFiles.set(intExtra, new java.io.File(stringExtra));
        while (this.photoRectAdjustedStates.size() <= intExtra) {
            this.photoRectAdjustedStates.add(false);
        }
        this.photoRectAdjustedStates.set(intExtra, java.lang.Boolean.valueOf(booleanExtra2));
        java.lang.String str4 = str3;
        if (str4 != null && str4.length() != 0 && !kotlin.jvm.internal.Intrinsics.areEqual(str3, stringExtra)) {
            deleteFileQuietly(str3);
        }
        com.up366.common.log.Logger.info("CameraActivity 裁剪结果回传成功 index=" + intExtra + ", returnDirectly=" + booleanExtra + ", isRectAdjusted=" + booleanExtra2);
        if (!this.isMultipleMode) {
            if (booleanExtra) {
                returnPhotos();
                return;
            } else {
                returnPhotos();
                return;
            }
        }
        android.widget.LinearLayout linearLayout3 = this.photoThumbnails;
        if (linearLayout3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("photoThumbnails");
        } else {
            linearLayout = linearLayout3;
        }
        linearLayout.removeAllViews();
        for (java.lang.Object obj : this.photoPaths) {
            int i3 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt.throwIndexOverflow();
            }
            addThumbnailWithDelete((java.lang.String) obj, i);
            i = i3;
        }
        updatePhotoCounter();
        updateConfirmVisibility();
    }

    protected void onResume() {
        super.onResume();
        com.up366.common.log.Logger.info("CameraActivity onResume");
        this.isCapturing = false;
        android.widget.ImageButton imageButton = this.btnCapture;
        android.widget.ImageButton imageButton2 = null;
        if (imageButton == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
            imageButton = null;
        }
        imageButton.setEnabled(true);
        android.widget.ImageButton imageButton3 = this.btnCapture;
        if (imageButton3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnCapture");
        } else {
            imageButton2 = imageButton3;
        }
        imageButton2.setAlpha(1.0f);
        if (this.imageCapture == null || this.cameraProvider == null) {
            startCamera();
        }
    }

    public void onBackPressed() {
        com.up366.photopicker.ui.WebViewDialog webViewDialog;
        com.up366.photopicker.ui.WebViewDialog webViewDialog2 = this.webViewDialog;
        if (webViewDialog2 == null || webViewDialog2 == null || !webViewDialog2.isShowing() || (webViewDialog = this.webViewDialog) == null) {
            return;
        }
        webViewDialog.dismiss();
    }

    private final void applyConfig() {
        com.up366.common.log.Logger.info("CameraActivity applyConfig");
        updateCaptureRectFromConfig();
        int i = 0;
        com.up366.photopicker.ui.camera.GridOverlayView gridOverlayView = null;
        if (!this.cameraPageSetting.isMultiplyAvailable()) {
            android.widget.TextView textView = this.tabMultiple;
            if (textView == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tabMultiple");
                textView = null;
            }
            textView.setVisibility(8);
            android.widget.TextView textView2 = this.tabSingle;
            if (textView2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tabSingle");
                textView2 = null;
            }
            textView2.setVisibility(8);
            this.isMultipleMode = false;
        }
        android.widget.TextView textView3 = this.btnGuide;
        if (textView3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnGuide");
            textView3 = null;
        }
        textView3.setVisibility(this.cameraPageSetting.getGuideSetting().isGuideButtonHidden() ? 8 : 0);
        android.widget.ImageButton imageButton = this.btnGrid;
        if (imageButton == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnGrid");
            imageButton = null;
        }
        if (this.cameraPageSetting.isGridButtonHidden()) {
            this.isGridOn = false;
            com.up366.photopicker.ui.camera.GridOverlayView gridOverlayView2 = this.gridOverlay;
            if (gridOverlayView2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("gridOverlay");
            } else {
                gridOverlayView = gridOverlayView2;
            }
            gridOverlayView.setVisibility(8);
            i = 8;
        }
        imageButton.setVisibility(i);
        if (this.cameraPageSetting.getGuideSetting().isGuideAutoShown()) {
            com.up366.common.log.Logger.info("CameraActivity 自动展示引导页");
            showGuide();
        }
        updateCaptureHint();
    }

    private final void updateCaptureRectFromConfig() {
        com.up366.photopicker.config.RectSetting rectSetting = this.cameraPageSetting.getRectSetting();
        if (rectSetting == null || !rectSetting.isExplicit()) {
            rectSetting = new com.up366.photopicker.config.RectSetting();
        }
        if (this.cameraPageSetting.isRectHidden()) {
            applyCaptureRect(0.0f, 0.0f, 0.0f, 0.0f, false);
        } else {
            applyCaptureRect(rectSetting.getTop(), rectSetting.getBottom(), rectSetting.getLeft(), rectSetting.getRight(), true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.util.Size normalizeSourceSizeForViewport(android.util.Size r7) {
        /*
            r6 = this;
            androidx.camera.view.PreviewView r0 = r6.previewView
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L3f
            r3 = 0
            java.lang.String r4 = "previewView"
            if (r0 != 0) goto Lf
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r3
        Lf:
            int r0 = r0.getHeight()
            if (r0 <= 0) goto L3f
            androidx.camera.view.PreviewView r0 = r6.previewView
            if (r0 != 0) goto L1d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r3
        L1d:
            int r0 = r0.getWidth()
            if (r0 <= 0) goto L3f
            androidx.camera.view.PreviewView r0 = r6.previewView
            if (r0 != 0) goto L2b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r3
        L2b:
            int r0 = r0.getHeight()
            androidx.camera.view.PreviewView r5 = r6.previewView
            if (r5 != 0) goto L37
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L38
        L37:
            r3 = r5
        L38:
            int r3 = r3.getWidth()
            if (r0 < r3) goto L4e
            goto L4c
        L3f:
            android.content.res.Resources r0 = r6.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.orientation
            r3 = 2
            if (r0 == r3) goto L4e
        L4c:
            r0 = r1
            goto L4f
        L4e:
            r0 = r2
        L4f:
            int r3 = r7.getHeight()
            int r4 = r7.getWidth()
            if (r3 < r4) goto L5a
            goto L5b
        L5a:
            r1 = r2
        L5b:
            if (r0 != r1) goto L5e
            goto L6c
        L5e:
            android.util.Size r0 = new android.util.Size
            int r1 = r7.getHeight()
            int r7 = r7.getWidth()
            r0.<init>(r1, r7)
            r7 = r0
        L6c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.photopicker.ui.camera.CameraActivity.normalizeSourceSizeForViewport(android.util.Size):android.util.Size");
    }

    private final void applyCaptureRect(float top, float bottom, float left, float right, final boolean showOverlay) {
        int i;
        android.view.View view;
        final float fCoerceIn = kotlin.ranges.RangesKt.coerceIn(top, 0.0f, 1.0f);
        final float fCoerceIn2 = kotlin.ranges.RangesKt.coerceIn(bottom, 0.0f, 1.0f);
        final float fCoerceIn3 = kotlin.ranges.RangesKt.coerceIn(left, 0.0f, 1.0f);
        final float fCoerceIn4 = kotlin.ranges.RangesKt.coerceIn(right, 0.0f, 1.0f);
        this.captureRectViewRatio.set(showOverlay ? fCoerceIn3 : 0.0f, showOverlay ? fCoerceIn : 0.0f, showOverlay ? 1.0f - fCoerceIn4 : 1.0f, showOverlay ? 1.0f - fCoerceIn2 : 1.0f);
        android.view.View view2 = this.captureRectOverlay;
        if (view2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("captureRectOverlay");
            view2 = null;
        }
        view2.setVisibility(showOverlay ? 0 : 8);
        android.util.Size sizeNormalizeSourceSizeForViewport = normalizeSourceSizeForViewport(resolveCaptureTargetSize(resolveTargetRotation()));
        final float fCoerceAtLeast = kotlin.ranges.RangesKt.coerceAtLeast(sizeNormalizeSourceSizeForViewport.getWidth(), 1.0f);
        final float fCoerceAtLeast2 = kotlin.ranges.RangesKt.coerceAtLeast(sizeNormalizeSourceSizeForViewport.getHeight(), 1.0f);
        com.up366.common.log.Logger.info("CameraActivity applyCaptureRect 使用分辨率=" + sizeNormalizeSourceSizeForViewport.getWidth() + 'x' + sizeNormalizeSourceSizeForViewport.getHeight() + ", showOverlay=" + showOverlay);
        androidx.camera.view.PreviewView previewView = this.previewView;
        if (previewView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("previewView");
            previewView = null;
        }
        android.view.View view3 = (android.view.View) previewView;
        if (androidx.core.view.ViewCompat.isLaidOut(view3) && !view3.isLayoutRequested()) {
            androidx.camera.view.PreviewView previewView2 = this.previewView;
            if (previewView2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("previewView");
                previewView2 = null;
            }
            float width = previewView2.getWidth();
            androidx.camera.view.PreviewView previewView3 = this.previewView;
            if (previewView3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("previewView");
                previewView3 = null;
            }
            float height = previewView3.getHeight();
            float fMax = java.lang.Math.max(width / fCoerceAtLeast, height / fCoerceAtLeast2);
            float f = fCoerceAtLeast * fMax;
            float f2 = fCoerceAtLeast2 * fMax;
            float f3 = (width - f) / 2.0f;
            float f4 = (height - f2) / 2.0f;
            this.previewContentRect.set(f3, f4, f3 + f, f4 + f2);
            this.previewVisibleRatio.set(kotlin.ranges.RangesKt.coerceIn((0.0f - f3) / f, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((0.0f - f4) / f2, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((width - f3) / f, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((height - f4) / f2, 0.0f, 1.0f));
            int i2 = (int) (fCoerceIn3 * width);
            int i3 = (int) (fCoerceIn * height);
            int i4 = (int) ((1.0f - fCoerceIn4) * width);
            int i5 = (int) ((1.0f - fCoerceIn2) * height);
            if (showOverlay) {
                android.view.View view4 = this.captureRectOverlay;
                if (view4 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("captureRectOverlay");
                    view4 = null;
                }
                android.view.ViewGroup.LayoutParams layoutParams = view4.getLayoutParams();
                kotlin.jvm.internal.Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                android.view.ViewGroup.LayoutParams layoutParams2 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams;
                i = 0;
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams2).width = 0;
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams2).height = 0;
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams2).leftMargin = i2;
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams2).topMargin = i3;
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams2).rightMargin = kotlin.ranges.RangesKt.coerceAtLeast((int) (width - i4), 0);
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams2).bottomMargin = kotlin.ranges.RangesKt.coerceAtLeast((int) (height - i5), 0);
                android.view.View view5 = this.captureRectOverlay;
                if (view5 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("captureRectOverlay");
                    view = null;
                } else {
                    view = view5;
                }
                view.setLayoutParams(layoutParams2);
            } else {
                i = 0;
            }
            if (!showOverlay) {
                i2 = i;
            }
            int i6 = showOverlay ? i3 : i;
            if (!showOverlay) {
                i4 = (int) width;
            }
            if (!showOverlay) {
                i5 = (int) height;
            }
            this.captureRectRatio.set(kotlin.ranges.RangesKt.coerceIn((i2 - f3) / f, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((i6 - f4) / f2, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((i4 - f3) / f, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((i5 - f4) / f2, 0.0f, 1.0f));
            return;
        }
        view3.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() { // from class: com.up366.photopicker.ui.camera.CameraActivity$applyCaptureRect$$inlined$doOnLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(android.view.View view6, int left2, int top2, int right2, int bottom2, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view6, "view");
                view6.removeOnLayoutChangeListener(this);
                androidx.camera.view.PreviewView previewView4 = this.this$0.previewView;
                if (previewView4 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("previewView");
                    previewView4 = null;
                }
                float width2 = previewView4.getWidth();
                androidx.camera.view.PreviewView previewView5 = this.this$0.previewView;
                if (previewView5 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("previewView");
                    previewView5 = null;
                }
                float height2 = previewView5.getHeight();
                float fMax2 = java.lang.Math.max(width2 / fCoerceAtLeast, height2 / fCoerceAtLeast2);
                float f5 = fCoerceAtLeast * fMax2;
                float f6 = fCoerceAtLeast2 * fMax2;
                float f7 = (width2 - f5) / 2.0f;
                float f8 = (height2 - f6) / 2.0f;
                this.this$0.previewContentRect.set(f7, f8, f7 + f5, f8 + f6);
                this.this$0.previewVisibleRatio.set(kotlin.ranges.RangesKt.coerceIn((0.0f - f7) / f5, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((0.0f - f8) / f6, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((width2 - f7) / f5, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((height2 - f8) / f6, 0.0f, 1.0f));
                int i7 = (int) (fCoerceIn3 * width2);
                int i8 = (int) (fCoerceIn * height2);
                int i9 = (int) ((1.0f - fCoerceIn4) * width2);
                int i10 = (int) ((1.0f - fCoerceIn2) * height2);
                if (showOverlay) {
                    android.view.View view7 = this.this$0.captureRectOverlay;
                    if (view7 == null) {
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("captureRectOverlay");
                        view7 = null;
                    }
                    android.view.ViewGroup.LayoutParams layoutParams3 = view7.getLayoutParams();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    android.view.ViewGroup.LayoutParams layoutParams4 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams3;
                    ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams4).width = 0;
                    ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams4).height = 0;
                    ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams4).leftMargin = i7;
                    ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams4).topMargin = i8;
                    ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams4).rightMargin = kotlin.ranges.RangesKt.coerceAtLeast((int) (width2 - i9), 0);
                    ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams4).bottomMargin = kotlin.ranges.RangesKt.coerceAtLeast((int) (height2 - i10), 0);
                    android.view.View view8 = this.this$0.captureRectOverlay;
                    if (view8 == null) {
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("captureRectOverlay");
                        view8 = null;
                    }
                    view8.setLayoutParams(layoutParams4);
                }
                boolean z = showOverlay;
                if (!z) {
                    i7 = 0;
                }
                if (!z) {
                    i8 = 0;
                }
                if (!z) {
                    i9 = (int) width2;
                }
                if (!z) {
                    i10 = (int) height2;
                }
                this.this$0.captureRectRatio.set(kotlin.ranges.RangesKt.coerceIn((i7 - f7) / f5, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((i8 - f8) / f6, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((i9 - f7) / f5, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((i10 - f8) / f6, 0.0f, 1.0f));
            }
        });
    }

    private final void updateCaptureHint() {
        java.lang.String str;
        java.lang.String strBuildMaxPageReachedHint;
        java.lang.String description = this.cameraPageSetting.getDescription();
        int iCoerceAtLeast = kotlin.ranges.RangesKt.coerceAtLeast(this.cameraPageSetting.getMaxPage(), 1);
        android.widget.TextView textView = null;
        if (this.isMultipleMode) {
            android.widget.TextView textView2 = this.tvCaptureHint;
            if (textView2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvCaptureHint");
                textView2 = null;
            }
            if (this.photoPaths.size() >= iCoerceAtLeast) {
                strBuildMaxPageReachedHint = buildMaxPageReachedHint(iCoerceAtLeast);
            } else {
                int iCoerceAtMost = kotlin.ranges.RangesKt.coerceAtMost(this.photoPaths.size() + 1, iCoerceAtLeast);
                java.lang.String indexDescription = this.cameraPageSetting.getIndexDescription();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(indexDescription, "idxDesc");
                if (true ^ kotlin.text.StringsKt.isBlank(indexDescription)) {
                    str = "请拍" + indexDescription + (char) 31532 + iCoerceAtMost + "部分";
                } else {
                    str = "请拍第" + iCoerceAtMost + "部分";
                }
                strBuildMaxPageReachedHint = str;
            }
            textView2.setText(strBuildMaxPageReachedHint);
        } else {
            android.widget.TextView textView3 = this.tvCaptureHint;
            if (textView3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvCaptureHint");
                textView3 = null;
            }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(description, "desc");
            java.lang.String str2 = description;
            if (!(true ^ kotlin.text.StringsKt.isBlank(str2))) {
            }
            textView3.setText(str2);
        }
        android.widget.TextView textView4 = this.tvCaptureHint;
        if (textView4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvCaptureHint");
        } else {
            textView = textView4;
        }
        textView.setVisibility(0);
    }

    private final java.lang.String buildMaxPageReachedHint(int maxPage) {
        return "最多可拍" + maxPage + "张，已到达上限";
    }

    private final java.lang.String buildMaxPageReachedHintV1(int maxPage) {
        return "最多可拍" + maxPage + (char) 24352;
    }

    private final void showMaxPageHint() {
        android.widget.TextView textView = this.tvMaxPageHint;
        android.widget.TextView textView2 = null;
        if (textView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvMaxPageHint");
            textView = null;
        }
        textView.setText(buildMaxPageReachedHintV1(kotlin.ranges.RangesKt.coerceAtLeast(this.cameraPageSetting.getMaxPage(), 1)));
        com.up366.common.log.Logger.info("CameraActivity 显示最大拍摄张数提示");
        android.widget.TextView textView3 = this.tvMaxPageHint;
        if (textView3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvMaxPageHint");
            textView3 = null;
        }
        textView3.bringToFront();
        android.widget.TextView textView4 = this.tvMaxPageHint;
        if (textView4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvMaxPageHint");
            textView4 = null;
        }
        textView4.setVisibility(0);
        android.widget.TextView textView5 = this.tvMaxPageHint;
        if (textView5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvMaxPageHint");
            textView5 = null;
        }
        textView5.removeCallbacks(this.hideMaxPageHintRunnable);
        android.widget.TextView textView6 = this.tvMaxPageHint;
        if (textView6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvMaxPageHint");
        } else {
            textView2 = textView6;
        }
        textView2.postDelayed(this.hideMaxPageHintRunnable, MAX_PAGE_HINT_DURATION_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void toggleFlash() {
        com.google.common.util.concurrent.ListenableFuture listenableFutureEnableTorch;
        if (this.hasTorchSupport) {
            this.isFlashOn = !this.isFlashOn;
            com.up366.common.log.Logger.info("CameraActivity 切换手电筒 isFlashOn=" + this.isFlashOn);
            androidx.camera.core.CameraControl cameraControl = this.cameraControl;
            if (cameraControl != null && (listenableFutureEnableTorch = cameraControl.enableTorch(this.isFlashOn)) != null) {
                listenableFutureEnableTorch.addListener(new java.lang.Runnable() { // from class: com.up366.photopicker.ui.camera.CameraActivity$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.up366.photopicker.ui.camera.CameraActivity.toggleFlash$lambda$28(this.f$0);
                    }
                }, androidx.core.content.ContextCompat.getMainExecutor((android.content.Context) this));
            }
            android.widget.TextView textView = this.btnFlash;
            if (textView == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnFlash");
                textView = null;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(0, this.isFlashOn ? com.up366.photopicker.R.drawable.photo_picker_flight_on : com.up366.photopicker.R.drawable.photo_picker_flight_off, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toggleFlash$lambda$28(com.up366.photopicker.ui.camera.CameraActivity cameraActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraActivity, "this$0");
        if (cameraActivity.isFlashOn) {
            return;
        }
        com.up366.common.log.Logger.info("手电筒已关闭");
    }

    private final void updateFlashAvailability(boolean supported) {
        this.hasTorchSupport = supported;
        android.widget.TextView textView = null;
        if (!supported) {
            this.isFlashOn = false;
            android.widget.TextView textView2 = this.btnFlash;
            if (textView2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnFlash");
                textView2 = null;
            }
            textView2.setVisibility(8);
            androidx.camera.core.CameraControl cameraControl = this.cameraControl;
            if (cameraControl != null) {
                cameraControl.enableTorch(false);
            }
        } else {
            android.widget.TextView textView3 = this.btnFlash;
            if (textView3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnFlash");
                textView3 = null;
            }
            textView3.setVisibility(0);
            android.widget.TextView textView4 = this.btnFlash;
            if (textView4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnFlash");
                textView4 = null;
            }
            textView4.setCompoundDrawablesWithIntrinsicBounds(0, this.isFlashOn ? com.up366.photopicker.R.drawable.photo_picker_flight_on : com.up366.photopicker.R.drawable.photo_picker_flight_off, 0, 0);
        }
        android.widget.TextView textView5 = this.btnGuide;
        if (textView5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnGuide");
            textView5 = null;
        }
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = textView5.getLayoutParams();
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams ? layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        layoutParams2.topToTop = -1;
        layoutParams2.topToBottom = supported ? com.up366.photopicker.R.id.btnFlash : com.up366.photopicker.R.id.btnBack;
        android.widget.TextView textView6 = this.btnGuide;
        if (textView6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnGuide");
        } else {
            textView = textView6;
        }
        textView.setLayoutParams((android.view.ViewGroup.LayoutParams) layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleGrid() {
        this.isGridOn = !this.isGridOn;
        com.up366.common.log.Logger.info("CameraActivity 切换九宫格 isGridOn=" + this.isGridOn);
        com.up366.photopicker.ui.camera.GridOverlayView gridOverlayView = this.gridOverlay;
        android.widget.ImageButton imageButton = null;
        if (gridOverlayView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("gridOverlay");
            gridOverlayView = null;
        }
        gridOverlayView.setVisibility(this.isGridOn ? 0 : 8);
        android.widget.ImageButton imageButton2 = this.btnGrid;
        if (imageButton2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnGrid");
        } else {
            imageButton = imageButton2;
        }
        imageButton.setImageResource(this.isGridOn ? com.up366.photopicker.R.drawable.up366_photo_picker_ic_grid_on : com.up366.photopicker.R.drawable.up366_photo_picker_ic_grid_off);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showGuide() {
        com.up366.photopicker.config.GuideSetting guideSetting = this.cameraPageSetting.getGuideSetting();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("CameraActivity 展示引导页，shownType=");
        sb.append(guideSetting.getShownType());
        sb.append(", url=");
        sb.append(guideSetting.getUrl());
        sb.append(", dialogExists=");
        sb.append(this.webViewDialog != null);
        sb.append(", dialogShowing=");
        com.up366.photopicker.ui.WebViewDialog webViewDialog = this.webViewDialog;
        sb.append(webViewDialog != null && webViewDialog.isShowing());
        com.up366.common.log.Logger.info(sb.toString());
        int shownType = guideSetting.getShownType();
        if (shownType != 0) {
            if (shownType != 1) {
                return;
            }
            com.up366.common.log.Logger.info("CameraActivity 通过 GuideActivity 打开引导页 url=" + guideSetting.getUrl());
            android.content.Intent intent = new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.photopicker.ui.GuideActivity.class);
            intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, guideSetting.getUrl());
            intent.putExtra(com.up366.photopicker.ui.GuideActivity.EXTRA_USE_DIALOG, false);
            startActivity(intent);
            return;
        }
        if (this.webViewDialog == null) {
            com.up366.common.log.Logger.info("CameraActivity 创建 WebViewDialog");
            this.webViewDialog = new com.up366.photopicker.ui.WebViewDialog((android.content.Context) this);
        }
        com.up366.common.log.Logger.info("CameraActivity 调用 WebViewDialog.loadUrl");
        com.up366.photopicker.ui.WebViewDialog webViewDialog2 = this.webViewDialog;
        if (webViewDialog2 != null) {
            webViewDialog2.loadUrl(guideSetting.getUrl());
        }
        com.up366.common.log.Logger.info("CameraActivity 调用 WebViewDialog.show");
        com.up366.photopicker.ui.WebViewDialog webViewDialog3 = this.webViewDialog;
        if (webViewDialog3 != null) {
            webViewDialog3.show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDestroy() {
        androidx.camera.core.CameraControl cameraControl;
        super.onDestroy();
        com.up366.photopicker.oplog.PhotoPickerOpLogHelper.leavePage$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) this, null, 2, null);
        android.widget.TextView textView = this.tvMaxPageHint;
        if (textView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvMaxPageHint");
            textView = null;
        }
        textView.removeCallbacks(this.hideMaxPageHintRunnable);
        if (this.isFlashOn && (cameraControl = this.cameraControl) != null) {
            cameraControl.enableTorch(false);
        }
        androidx.camera.lifecycle.ProcessCameraProvider processCameraProvider = this.cameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbindAll();
        }
        com.up366.photopicker.ui.WebViewDialog webViewDialog = this.webViewDialog;
        if (webViewDialog != null) {
            webViewDialog.dismiss();
        }
        this.webViewDialog = null;
        this.ioExecutor.shutdownNow();
    }
}
