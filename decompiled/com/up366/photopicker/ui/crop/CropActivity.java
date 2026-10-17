package com.up366.photopicker.ui.crop;

/* JADX INFO: compiled from: CropActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 n2\u00020\u0001:\u0001nB\u0005¢\u0006\u0002\u0010\u0002J\b\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0012H\u0002J\u0016\u0010:\u001a\u00020\u00142\f\u0010;\u001a\b\u0012\u0004\u0012\u00020+0<H\u0002J\u001c\u0010=\u001a\u0004\u0018\u00010\u00182\u0006\u0010>\u001a\u0002012\b\u0010?\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u000201H\u0002J\u0010\u0010C\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u0018H\u0002J\b\u0010D\u001a\u000207H\u0002J\u0010\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u0018H\u0002J\u0010\u0010G\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u0018H\u0002J\b\u0010H\u001a\u000207H\u0002J\u0018\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u00142\u0006\u0010K\u001a\u00020\u0014H\u0002J\n\u0010L\u001a\u0004\u0018\u00010\u0014H\u0002J\u0015\u0010M\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*H\u0002¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u000207H\u0002J\b\u0010P\u001a\u000207H\u0002J\n\u0010Q\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010R\u001a\u0002072\u0006\u0010S\u001a\u00020TH\u0002J\u0012\u0010U\u001a\u0004\u0018\u0001012\u0006\u0010S\u001a\u00020TH\u0002J \u0010V\u001a\u00020+2\u0006\u0010W\u001a\u00020+2\u0006\u0010X\u001a\u00020/2\u0006\u0010Y\u001a\u00020/H\u0002J \u0010Z\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u00142\u0006\u0010X\u001a\u00020/2\u0006\u0010Y\u001a\u00020/H\u0002J\b\u0010[\u001a\u000207H\u0016J\u0012\u0010\\\u001a\u0002072\b\u0010]\u001a\u0004\u0018\u00010^H\u0014J\b\u0010_\u001a\u000207H\u0014J\b\u0010`\u001a\u000207H\u0002J\b\u0010a\u001a\u00020\u0014H\u0002J\b\u0010b\u001a\u000207H\u0002J\b\u0010c\u001a\u000207H\u0002J\u0010\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020\u0018H\u0002J\b\u0010g\u001a\u000207H\u0002J\b\u0010h\u001a\u000207H\u0002J\b\u0010i\u001a\u00020\u001aH\u0002J\u0018\u0010j\u001a\u0002072\u0006\u0010k\u001a\u00020/2\u0006\u0010l\u001a\u00020/H\u0002J\b\u0010m\u001a\u000207H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n !*\u0004\u0018\u00010 0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*X\u0082\u000e¢\u0006\u0004\n\u0002\u0010,R\u000e\u0010-\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/up366/photopicker/ui/crop/CropActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnBack", "Landroid/widget/ImageButton;", "btnConfirm", "btnGuide", "Landroid/widget/TextView;", "btnRetake", "Landroid/view/View;", "btnRotate", "cameraPageSetting", "Lcom/up366/photopicker/config/CameraPageSetting;", "clipPageSetting", "Lcom/up366/photopicker/config/ClipPageSetting;", "cropMagnifier", "Lcom/up366/photopicker/ui/crop/CropMagnifierView;", "cropOverlay", "Lcom/up366/photopicker/ui/crop/CropOverlayView;", "cropRectRatio", "Landroid/graphics/RectF;", "cropViewContainer", "Landroid/widget/FrameLayout;", "currentBitmap", "Landroid/graphics/Bitmap;", "fromCamera", "", "imageRect", "imageToCrop", "Landroid/widget/ImageView;", "initialCropOverrideRatio", "ioExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "isImageLoaded", "isImageLoading", "isMultipleMode", "isRectAdjustedByUser", "originalBitmap", "photoIndex", "", "quadCornerRatios", "", "Landroid/graphics/PointF;", "[Landroid/graphics/PointF;", "rotationCount", "scaleFactor", "", "sourceFilePath", "", "tvCropHint", "visibleAreaRatio", "webViewDialog", "Lcom/up366/photopicker/ui/WebViewDialog;", "applyConfig", "", "applyQuadCornersToOverlay", "cropOverlayView", "buildBoundsFromPoints", "points", "", "correctBitmapOrientation", "filePath", "bitmap", "createCropResultIntent", "Landroid/content/Intent;", "croppedPath", "cropBitmapToVisibleArea", "cropImage", "cropQuadBitmap", "sourceBitmap", "cropRectBitmap", "finishNoAnimation", "fitRectWithin", "rect", "bounds", "getCropRectInBitmap", "getQuadCornersInBitmap", "()[Landroid/graphics/PointF;", "hideCropMagnifier", "loadImage", "loadSourceBitmapForExport", "logCropInteraction", "mode", "Lcom/up366/photopicker/ui/crop/CropOverlayView$Mode;", "mapDragHandle", "mapPointAfterRotateCCW", "point", "oldWidth", "oldHeight", "mapRectAfterRotateCCW", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "readConfig", "readVisibleAreaRatio", "retake", "rotateImage", "saveCroppedBitmap", "Ljava/io/File;", "croppedBitmap", "setupFullScreen", "setupImageView", "shouldUseVisibleAreaCrop", "showCropMagnifier", "focusX", "focusY", "showGuide", "Companion", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CropActivity extends androidx.appcompat.app.AppCompatActivity {
    public static final java.lang.String CONTROL_RECT_EDIT = "rect_edit";
    public static final java.lang.String CONTROL_RECT_MOVE = "rect_move";
    public static final java.lang.String DRAG_HANDLE_BOTTOM = "bottom";
    public static final java.lang.String DRAG_HANDLE_BOTTOM_LEFT = "bottomLeft";
    public static final java.lang.String DRAG_HANDLE_BOTTOM_RIGHT = "bottomRight";
    public static final java.lang.String DRAG_HANDLE_LEFT = "left";
    public static final java.lang.String DRAG_HANDLE_RIGHT = "right";
    public static final java.lang.String DRAG_HANDLE_TOP = "top";
    public static final java.lang.String DRAG_HANDLE_TOP_LEFT = "topLeft";
    public static final java.lang.String DRAG_HANDLE_TOP_RIGHT = "topRight";
    private static final int OUTPUT_JPEG_QUALITY = 95;
    private static final java.lang.String TAG = "CropActivity";
    private android.widget.ImageButton btnBack;
    private android.widget.ImageButton btnConfirm;
    private android.widget.TextView btnGuide;
    private android.view.View btnRetake;
    private android.view.View btnRotate;
    private com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifier;
    private com.up366.photopicker.ui.crop.CropOverlayView cropOverlay;
    private android.widget.FrameLayout cropViewContainer;
    private android.graphics.Bitmap currentBitmap;
    private boolean fromCamera;
    private android.widget.ImageView imageToCrop;
    private android.graphics.RectF initialCropOverrideRatio;
    private boolean isImageLoaded;
    private boolean isImageLoading;
    private boolean isMultipleMode;
    private boolean isRectAdjustedByUser;
    private android.graphics.Bitmap originalBitmap;
    private int photoIndex;
    private android.graphics.PointF[] quadCornerRatios;
    private int rotationCount;
    private android.widget.TextView tvCropHint;
    private com.up366.photopicker.ui.WebViewDialog webViewDialog;
    private java.lang.String sourceFilePath = "";
    private float scaleFactor = 1.0f;
    private android.graphics.RectF imageRect = new android.graphics.RectF();
    private android.graphics.RectF visibleAreaRatio = new android.graphics.RectF(0.0f, 0.0f, 1.0f, 1.0f);
    private final java.util.concurrent.ExecutorService ioExecutor = java.util.concurrent.Executors.newSingleThreadExecutor();
    private android.graphics.RectF cropRectRatio = new android.graphics.RectF(0.25f, 0.25f, 0.75f, 0.75f);
    private com.up366.photopicker.config.ClipPageSetting clipPageSetting = new com.up366.photopicker.config.ClipPageSetting();
    private com.up366.photopicker.config.CameraPageSetting cameraPageSetting = new com.up366.photopicker.config.CameraPageSetting();

    /* JADX INFO: compiled from: CropActivity.kt */
    @kotlin.Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[com.up366.photopicker.ui.crop.CropOverlayView.Mode.values().length];
            try {
                iArr[com.up366.photopicker.ui.crop.CropOverlayView.Mode.MOVE_CENTER.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_TL.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_TR.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                iArr[com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_BL.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                iArr[com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_BR.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                iArr[com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_T.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                iArr[com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_B.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                iArr[com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_L.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                iArr[com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_R.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                iArr[com.up366.photopicker.ui.crop.CropOverlayView.Mode.NONE.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(android.os.Bundle savedInstanceState) {
        android.view.View view;
        super.onCreate(savedInstanceState);
        setContentView(com.up366.photopicker.R.layout.up366_photo_picker_activity_crop);
        overridePendingTransition(0, 0);
        com.up366.common.log.Logger.info("CropActivity onCreate");
        readConfig();
        com.up366.photopicker.oplog.PhotoPickerOpLogHelper photoPickerOpLogHelper = com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE;
        android.app.Activity activity = (android.app.Activity) this;
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("source", getIntent().getBooleanExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_FROM_CAMERA, false) ? "camera" : "album");
        kotlin.Unit unit = kotlin.Unit.INSTANCE;
        photoPickerOpLogHelper.enterPage(activity, jSONObject);
        setupFullScreen();
        android.view.View viewFindViewById = findViewById(com.up366.photopicker.R.id.imageToCrop);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.imageToCrop)");
        this.imageToCrop = (android.widget.ImageView) viewFindViewById;
        android.view.View viewFindViewById2 = findViewById(com.up366.photopicker.R.id.cropOverlay);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.cropOverlay)");
        this.cropOverlay = (com.up366.photopicker.ui.crop.CropOverlayView) viewFindViewById2;
        android.view.View viewFindViewById3 = findViewById(com.up366.photopicker.R.id.cropViewContainer);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.cropViewContainer)");
        this.cropViewContainer = (android.widget.FrameLayout) viewFindViewById3;
        android.view.View viewFindViewById4 = findViewById(com.up366.photopicker.R.id.cropMagnifier);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(R.id.cropMagnifier)");
        this.cropMagnifier = (com.up366.photopicker.ui.crop.CropMagnifierView) viewFindViewById4;
        android.view.View viewFindViewById5 = findViewById(com.up366.photopicker.R.id.btnBack);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(R.id.btnBack)");
        this.btnBack = (android.widget.ImageButton) viewFindViewById5;
        android.view.View viewFindViewById6 = findViewById(com.up366.photopicker.R.id.btnRetake);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(R.id.btnRetake)");
        this.btnRetake = viewFindViewById6;
        android.view.View viewFindViewById7 = findViewById(com.up366.photopicker.R.id.btnConfirm);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(R.id.btnConfirm)");
        this.btnConfirm = (android.widget.ImageButton) viewFindViewById7;
        android.view.View viewFindViewById8 = findViewById(com.up366.photopicker.R.id.btnRotate);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(R.id.btnRotate)");
        this.btnRotate = viewFindViewById8;
        android.view.View viewFindViewById9 = findViewById(com.up366.photopicker.R.id.btnGuide);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(R.id.btnGuide)");
        this.btnGuide = (android.widget.TextView) viewFindViewById9;
        android.view.View viewFindViewById10 = findViewById(com.up366.photopicker.R.id.tvCropHint);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(R.id.tvCropHint)");
        this.tvCropHint = (android.widget.TextView) viewFindViewById10;
        android.view.View[] viewArr = new android.view.View[5];
        android.widget.ImageButton imageButton = this.btnBack;
        android.widget.ImageView imageView = null;
        if (imageButton == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            imageButton = null;
        }
        viewArr[0] = imageButton;
        android.view.View view2 = this.btnRetake;
        if (view2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnRetake");
            view2 = null;
        }
        viewArr[1] = view2;
        android.widget.ImageButton imageButton2 = this.btnConfirm;
        if (imageButton2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            imageButton2 = null;
        }
        viewArr[2] = imageButton2;
        android.view.View view3 = this.btnRotate;
        if (view3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnRotate");
            view3 = null;
        }
        viewArr[3] = view3;
        android.widget.TextView textView = this.btnGuide;
        if (textView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnGuide");
            textView = null;
        }
        viewArr[4] = textView;
        java.util.Iterator it = kotlin.collections.CollectionsKt.listOf(viewArr).iterator();
        while (it.hasNext()) {
            com.up366.photopicker.ui.SafeClickKt.enablePressedAlphaFeedback$default((android.view.View) it.next(), 0.0f, 0.0f, 3, null);
        }
        java.lang.String stringExtra = getIntent().getStringExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_PHOTO_URI);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.sourceFilePath = stringExtra;
        this.photoIndex = getIntent().getIntExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_INDEX, 0);
        this.fromCamera = getIntent().getBooleanExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_FROM_CAMERA, false);
        this.isMultipleMode = getIntent().getBooleanExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_IS_MULTIPLE_MODE, false);
        this.visibleAreaRatio = readVisibleAreaRatio();
        android.widget.ImageButton imageButton3 = this.btnBack;
        if (imageButton3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            imageButton3 = null;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(imageButton3, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.crop.CropActivity.onCreate.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view4) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view4, com.igexin.push.g.q.f);
                com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) com.up366.photopicker.ui.crop.CropActivity.this, "back_button", null, 4, null);
                com.up366.photopicker.ui.crop.CropActivity.this.finish();
            }
        }, 1, null);
        android.view.View view4 = this.btnRetake;
        if (view4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnRetake");
            view = null;
        } else {
            view = view4;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(view, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.crop.CropActivity.onCreate.4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view5) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view5, com.igexin.push.g.q.f);
                com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) com.up366.photopicker.ui.crop.CropActivity.this, "re_photo_button", null, 4, null);
                com.up366.photopicker.ui.crop.CropActivity.this.retake();
            }
        }, 1, null);
        android.widget.ImageButton imageButton4 = this.btnConfirm;
        if (imageButton4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            imageButton4 = null;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(imageButton4, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.crop.CropActivity.onCreate.5
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view5) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view5, com.igexin.push.g.q.f);
                com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) com.up366.photopicker.ui.crop.CropActivity.this, "confirm_button", null, 4, null);
                com.up366.photopicker.ui.crop.CropActivity.this.cropImage();
            }
        }, 1, null);
        android.view.View view5 = this.btnRotate;
        if (view5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnRotate");
            view5 = null;
        }
        view5.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.crop.CropActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view6) {
                com.up366.photopicker.ui.crop.CropActivity.onCreate$lambda$2(this.f$0, view6);
            }
        });
        android.widget.TextView textView2 = this.btnGuide;
        if (textView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnGuide");
            textView2 = null;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(textView2, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.crop.CropActivity.onCreate.7
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view6) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view6, com.igexin.push.g.q.f);
                com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) com.up366.photopicker.ui.crop.CropActivity.this, "tutorial_button", null, 4, null);
                com.up366.photopicker.ui.crop.CropActivity.this.showGuide();
            }
        }, 1, null);
        applyConfig();
        android.widget.ImageView imageView2 = this.imageToCrop;
        if (imageView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("imageToCrop");
        } else {
            imageView = imageView2;
        }
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.up366.photopicker.ui.crop.CropActivity$$ExternalSyntheticLambda5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                com.up366.photopicker.ui.crop.CropActivity.onCreate$lambda$3(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onCreate$lambda$2(com.up366.photopicker.ui.crop.CropActivity cropActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) cropActivity, "rotate_button", null, 4, null);
        cropActivity.rotateImage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(com.up366.photopicker.ui.crop.CropActivity cropActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        if (cropActivity.isImageLoaded || cropActivity.isImageLoading || cropActivity.sourceFilePath.length() <= 0) {
            return;
        }
        cropActivity.loadImage();
    }

    private final void readConfig() {
        com.up366.photopicker.config.PhotoPickerConfig photoPickerConfig = (com.up366.photopicker.config.PhotoPickerConfig) com.alibaba.fastjson.JSON.parseObject(getIntent().getStringExtra("config"), com.up366.photopicker.config.PhotoPickerConfig.class);
        if (photoPickerConfig != null) {
            com.up366.photopicker.config.ClipPageSetting clipPageSetting = photoPickerConfig.getClipPageSetting();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(clipPageSetting, "it.clipPageSetting");
            this.clipPageSetting = clipPageSetting;
            com.up366.photopicker.config.CameraPageSetting cameraPageSetting = photoPickerConfig.getCameraPageSetting();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cameraPageSetting, "it.cameraPageSetting");
            this.cameraPageSetting = cameraPageSetting;
        }
        com.up366.common.log.Logger.info("CropActivity readConfig, draggingType=" + this.clipPageSetting.getDraggingType() + ", guideType=" + this.clipPageSetting.getGuideSetting().getShownType());
        if (getIntent().hasExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_INITIAL_CROP_LEFT) && getIntent().hasExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_INITIAL_CROP_TOP) && getIntent().hasExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_INITIAL_CROP_RIGHT) && getIntent().hasExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_INITIAL_CROP_BOTTOM)) {
            this.initialCropOverrideRatio = new android.graphics.RectF(getIntent().getFloatExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_INITIAL_CROP_LEFT, 0.25f), getIntent().getFloatExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_INITIAL_CROP_TOP, 0.25f), getIntent().getFloatExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_INITIAL_CROP_RIGHT, 0.75f), getIntent().getFloatExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_INITIAL_CROP_BOTTOM, 0.75f));
        }
    }

    private final android.graphics.RectF readVisibleAreaRatio() {
        if (getIntent().hasExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_VISIBLE_AREA_LEFT) && getIntent().hasExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_VISIBLE_AREA_TOP) && getIntent().hasExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_VISIBLE_AREA_RIGHT) && getIntent().hasExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_VISIBLE_AREA_BOTTOM)) {
            return new android.graphics.RectF(kotlin.ranges.RangesKt.coerceIn(getIntent().getFloatExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_VISIBLE_AREA_LEFT, 0.0f), 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn(getIntent().getFloatExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_VISIBLE_AREA_TOP, 0.0f), 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn(getIntent().getFloatExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_VISIBLE_AREA_RIGHT, 1.0f), 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn(getIntent().getFloatExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_VISIBLE_AREA_BOTTOM, 1.0f), 0.0f, 1.0f));
        }
        return new android.graphics.RectF(0.0f, 0.0f, 1.0f, 1.0f);
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
    private final void loadImage() {
        if (this.sourceFilePath.length() == 0) {
            com.up366.common.log.Logger.error("CropActivity 图片路径无效");
            android.widget.Toast.makeText((android.content.Context) this, "无效的图片路径", 0).show();
            finishNoAnimation();
            return;
        }
        this.isImageLoading = true;
        com.up366.common.log.Logger.info("CropActivity 开始加载图片 path=" + this.sourceFilePath);
        android.widget.ImageView imageView = this.imageToCrop;
        android.widget.ImageView imageView2 = null;
        if (imageView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("imageToCrop");
            imageView = null;
        }
        int width = imageView.getWidth();
        android.widget.ImageView imageView3 = this.imageToCrop;
        if (imageView3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("imageToCrop");
        } else {
            imageView2 = imageView3;
        }
        int height = imageView2.getHeight();
        float fCoerceAtLeast = kotlin.ranges.RangesKt.coerceAtLeast(this.visibleAreaRatio.right - this.visibleAreaRatio.left, 1.0E-4f);
        float fCoerceAtLeast2 = kotlin.ranges.RangesKt.coerceAtLeast(this.visibleAreaRatio.bottom - this.visibleAreaRatio.top, 1.0E-4f);
        final int iCoerceAtLeast = kotlin.ranges.RangesKt.coerceAtLeast((int) (width / fCoerceAtLeast), width);
        final int iCoerceAtLeast2 = kotlin.ranges.RangesKt.coerceAtLeast((int) (height / fCoerceAtLeast2), height);
        this.ioExecutor.execute(new java.lang.Runnable() { // from class: com.up366.photopicker.ui.crop.CropActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.photopicker.ui.crop.CropActivity.loadImage$lambda$12(this.f$0, iCoerceAtLeast, iCoerceAtLeast2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadImage$lambda$12(final com.up366.photopicker.ui.crop.CropActivity cropActivity, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        try {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            int i3 = 1;
            options.inJustDecodeBounds = true;
            android.graphics.BitmapFactory.decodeFile(cropActivity.sourceFilePath, options);
            while (true) {
                if (options.outWidth / i3 <= i && options.outHeight / i3 <= i2) {
                    break;
                }
                i3 *= 2;
            }
            android.graphics.BitmapFactory.Options options2 = new android.graphics.BitmapFactory.Options();
            options2.inSampleSize = i3;
            options2.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
            final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
            objectRef.element = android.graphics.BitmapFactory.decodeFile(cropActivity.sourceFilePath, options2);
            objectRef.element = cropActivity.correctBitmapOrientation(cropActivity.sourceFilePath, (android.graphics.Bitmap) objectRef.element);
            android.graphics.Bitmap bitmap = (android.graphics.Bitmap) objectRef.element;
            objectRef.element = bitmap != null ? cropActivity.cropBitmapToVisibleArea(bitmap) : null;
            cropActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.up366.photopicker.ui.crop.CropActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.photopicker.ui.crop.CropActivity.loadImage$lambda$12$lambda$10(this.f$0, objectRef);
                }
            });
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("加载图片失败", e);
            cropActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.up366.photopicker.ui.crop.CropActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.photopicker.ui.crop.CropActivity.loadImage$lambda$12$lambda$11(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void loadImage$lambda$12$lambda$10(com.up366.photopicker.ui.crop.CropActivity cropActivity, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(objectRef, "$loadedBitmap");
        if (cropActivity.isFinishing() || cropActivity.isDestroyed()) {
            return;
        }
        cropActivity.isImageLoading = false;
        cropActivity.originalBitmap = (android.graphics.Bitmap) objectRef.element;
        android.graphics.Bitmap bitmap = (android.graphics.Bitmap) objectRef.element;
        cropActivity.currentBitmap = bitmap;
        if (bitmap != null) {
            com.up366.common.log.Logger.info("CropActivity 图片加载成功");
            cropActivity.setupImageView();
            cropActivity.isImageLoaded = true;
        } else {
            com.up366.common.log.Logger.error("CropActivity 图片加载失败，bitmap 为空");
            android.widget.Toast.makeText((android.content.Context) cropActivity, "图片加载失败", 0).show();
            cropActivity.finishNoAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void loadImage$lambda$12$lambda$11(com.up366.photopicker.ui.crop.CropActivity cropActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        if (cropActivity.isFinishing() || cropActivity.isDestroyed()) {
            return;
        }
        cropActivity.isImageLoading = false;
        android.widget.Toast.makeText((android.content.Context) cropActivity, "图片加载失败", 0).show();
        cropActivity.finishNoAnimation();
    }

    private final android.graphics.Bitmap correctBitmapOrientation(java.lang.String filePath, android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
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
            return android.graphics.Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("修正图片方向失败", e);
            return bitmap;
        }
    }

    private final void setupImageView() {
        android.graphics.Bitmap bitmap = this.currentBitmap;
        if (bitmap == null) {
            return;
        }
        com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView = (com.up366.photopicker.ui.crop.CropOverlayView) findViewById(com.up366.photopicker.R.id.cropOverlay);
        float width = cropOverlayView.getWidth();
        float height = cropOverlayView.getHeight();
        float width2 = bitmap.getWidth();
        float height2 = bitmap.getHeight();
        float fMin = java.lang.Math.min(width / width2, height / height2);
        this.scaleFactor = fMin;
        float f = width2 * fMin;
        float f2 = height2 * fMin;
        float f3 = (width - f) / 2.0f;
        float f4 = (height - f2) / 2.0f;
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        float f5 = this.scaleFactor;
        matrix.postScale(f5, f5);
        matrix.postTranslate(f3, f4);
        android.widget.ImageView imageView = this.imageToCrop;
        com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView = null;
        if (imageView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("imageToCrop");
            imageView = null;
        }
        imageView.setImageMatrix(matrix);
        android.widget.ImageView imageView2 = this.imageToCrop;
        if (imageView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("imageToCrop");
            imageView2 = null;
        }
        imageView2.setImageBitmap(bitmap);
        this.imageRect.set(f3, f4, f + f3, f2 + f4);
        cropOverlayView.setImageRect(this.imageRect);
        com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView2 = this.cropMagnifier;
        if (cropMagnifierView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropMagnifier");
            cropMagnifierView2 = null;
        }
        cropMagnifierView2.updateSource(bitmap, this.imageRect, this.scaleFactor);
        hideCropMagnifier();
        cropOverlayView.getCropRect().set(fitRectWithin(new android.graphics.RectF(this.imageRect.left + (this.imageRect.width() * this.cropRectRatio.left), this.imageRect.top + (this.imageRect.height() * this.cropRectRatio.top), this.imageRect.left + (this.imageRect.width() * this.cropRectRatio.right), this.imageRect.top + (this.imageRect.height() * this.cropRectRatio.bottom)), this.imageRect));
        if (this.clipPageSetting.getDraggingType() == 1) {
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cropOverlayView, "cropOverlayView");
            applyQuadCornersToOverlay(cropOverlayView);
        }
        android.graphics.RectF cropRect = cropOverlayView.getCropRect();
        this.cropRectRatio.left = (cropRect.left - this.imageRect.left) / this.imageRect.width();
        this.cropRectRatio.top = (cropRect.top - this.imageRect.top) / this.imageRect.height();
        this.cropRectRatio.right = (cropRect.right - this.imageRect.left) / this.imageRect.width();
        this.cropRectRatio.bottom = (cropRect.bottom - this.imageRect.top) / this.imageRect.height();
        cropOverlayView.invalidate();
        com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView3 = this.cropMagnifier;
        if (cropMagnifierView3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropMagnifier");
        } else {
            cropMagnifierView = cropMagnifierView3;
        }
        cropMagnifierView.updateCropOverlay(cropOverlayView.getCropRect(), cropOverlayView.getCorners(), this.clipPageSetting.getDraggingType());
        cropOverlayView.setOnCropRectChanged(new kotlin.jvm.functions.Function1<android.graphics.RectF, kotlin.Unit>() { // from class: com.up366.photopicker.ui.crop.CropActivity.setupImageView.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.graphics.RectF) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.graphics.RectF rectF) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rectF, "cropRect");
                com.up366.photopicker.ui.crop.CropActivity.this.cropRectRatio.left = (rectF.left - com.up366.photopicker.ui.crop.CropActivity.this.imageRect.left) / com.up366.photopicker.ui.crop.CropActivity.this.imageRect.width();
                com.up366.photopicker.ui.crop.CropActivity.this.cropRectRatio.top = (rectF.top - com.up366.photopicker.ui.crop.CropActivity.this.imageRect.top) / com.up366.photopicker.ui.crop.CropActivity.this.imageRect.height();
                com.up366.photopicker.ui.crop.CropActivity.this.cropRectRatio.right = (rectF.right - com.up366.photopicker.ui.crop.CropActivity.this.imageRect.left) / com.up366.photopicker.ui.crop.CropActivity.this.imageRect.width();
                com.up366.photopicker.ui.crop.CropActivity.this.cropRectRatio.bottom = (rectF.bottom - com.up366.photopicker.ui.crop.CropActivity.this.imageRect.top) / com.up366.photopicker.ui.crop.CropActivity.this.imageRect.height();
                com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView2 = null;
                if (com.up366.photopicker.ui.crop.CropActivity.this.clipPageSetting.getDraggingType() == 1) {
                    com.up366.photopicker.ui.crop.CropActivity cropActivity = com.up366.photopicker.ui.crop.CropActivity.this;
                    com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView3 = cropActivity.cropOverlay;
                    if (cropOverlayView3 == null) {
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropOverlay");
                        cropOverlayView3 = null;
                    }
                    android.graphics.PointF[] corners = cropOverlayView3.getCorners();
                    com.up366.photopicker.ui.crop.CropActivity cropActivity2 = com.up366.photopicker.ui.crop.CropActivity.this;
                    java.util.ArrayList arrayList = new java.util.ArrayList(corners.length);
                    for (android.graphics.PointF pointF : corners) {
                        arrayList.add(new android.graphics.PointF(kotlin.ranges.RangesKt.coerceIn((pointF.x - cropActivity2.imageRect.left) / cropActivity2.imageRect.width(), 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((pointF.y - cropActivity2.imageRect.top) / cropActivity2.imageRect.height(), 0.0f, 1.0f)));
                    }
                    cropActivity.quadCornerRatios = (android.graphics.PointF[]) arrayList.toArray(new android.graphics.PointF[0]);
                }
                com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView4 = com.up366.photopicker.ui.crop.CropActivity.this.cropMagnifier;
                if (cropMagnifierView4 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropMagnifier");
                    cropMagnifierView4 = null;
                }
                com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView4 = com.up366.photopicker.ui.crop.CropActivity.this.cropOverlay;
                if (cropOverlayView4 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropOverlay");
                    cropOverlayView4 = null;
                }
                android.graphics.RectF cropRect2 = cropOverlayView4.getCropRect();
                com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView5 = com.up366.photopicker.ui.crop.CropActivity.this.cropOverlay;
                if (cropOverlayView5 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropOverlay");
                } else {
                    cropOverlayView2 = cropOverlayView5;
                }
                cropMagnifierView4.updateCropOverlay(cropRect2, cropOverlayView2.getCorners(), com.up366.photopicker.ui.crop.CropActivity.this.clipPageSetting.getDraggingType());
            }
        });
        cropOverlayView.setOnUserAdjustedCropChanged(new kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit>() { // from class: com.up366.photopicker.ui.crop.CropActivity.setupImageView.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke(((java.lang.Boolean) obj).booleanValue());
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    com.up366.photopicker.ui.crop.CropActivity.this.isRectAdjustedByUser = true;
                }
            }
        });
        cropOverlayView.setOnInteractionFinished(new kotlin.jvm.functions.Function1<com.up366.photopicker.ui.crop.CropOverlayView.Mode, kotlin.Unit>() { // from class: com.up366.photopicker.ui.crop.CropActivity.setupImageView.3
            {
                super(1);
            }

            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) throws kotlin.NoWhenBranchMatchedException {
                invoke((com.up366.photopicker.ui.crop.CropOverlayView.Mode) obj);
                return kotlin.Unit.INSTANCE;
            }

            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
            public final void invoke(com.up366.photopicker.ui.crop.CropOverlayView.Mode mode) throws kotlin.NoWhenBranchMatchedException {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mode, "mode");
                com.up366.photopicker.ui.crop.CropActivity.this.logCropInteraction(mode);
            }
        });
        cropOverlayView.setOnCornerDragPreviewChanged(new kotlin.jvm.functions.Function3<java.lang.Boolean, java.lang.Float, java.lang.Float, kotlin.Unit>() { // from class: com.up366.photopicker.ui.crop.CropActivity.setupImageView.4
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
                invoke(((java.lang.Boolean) obj).booleanValue(), ((java.lang.Number) obj2).floatValue(), ((java.lang.Number) obj3).floatValue());
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(boolean z, float f6, float f7) {
                if (!com.up366.photopicker.ui.crop.CropActivity.this.clipPageSetting.isMagnifierEnabled() || !z) {
                    com.up366.photopicker.ui.crop.CropActivity.this.hideCropMagnifier();
                } else {
                    com.up366.photopicker.ui.crop.CropActivity.this.showCropMagnifier(f6, f7);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCropMagnifier(float focusX, float focusY) {
        if (!this.clipPageSetting.isMagnifierEnabled() || this.currentBitmap == null || this.imageRect.isEmpty()) {
            hideCropMagnifier();
            return;
        }
        com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView = this.cropMagnifier;
        com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView2 = null;
        if (cropMagnifierView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropMagnifier");
            cropMagnifierView = null;
        }
        cropMagnifierView.updateSource(this.currentBitmap, this.imageRect, this.scaleFactor);
        com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView3 = this.cropMagnifier;
        if (cropMagnifierView3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropMagnifier");
            cropMagnifierView3 = null;
        }
        com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView = this.cropOverlay;
        if (cropOverlayView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropOverlay");
            cropOverlayView = null;
        }
        android.graphics.RectF cropRect = cropOverlayView.getCropRect();
        com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView2 = this.cropOverlay;
        if (cropOverlayView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropOverlay");
            cropOverlayView2 = null;
        }
        cropMagnifierView3.updateCropOverlay(cropRect, cropOverlayView2.getCorners(), this.clipPageSetting.getDraggingType());
        com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView4 = this.cropMagnifier;
        if (cropMagnifierView4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropMagnifier");
            cropMagnifierView4 = null;
        }
        cropMagnifierView4.updateFocusPoint(focusX, focusY);
        float f = getResources().getDisplayMetrics().density * 14.0f;
        float f2 = getResources().getDisplayMetrics().density * 14.0f;
        com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView5 = this.cropMagnifier;
        if (cropMagnifierView5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropMagnifier");
            cropMagnifierView5 = null;
        }
        float width = cropMagnifierView5.getWidth();
        com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView6 = this.cropMagnifier;
        if (cropMagnifierView6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropMagnifier");
            cropMagnifierView6 = null;
        }
        float height = cropMagnifierView6.getHeight();
        float f3 = focusX - (width / 2.0f);
        float f4 = (focusY - height) - f;
        if (f4 < this.imageRect.top) {
            f4 = focusY + f2;
        }
        float f5 = this.imageRect.left;
        float fCoerceAtLeast = kotlin.ranges.RangesKt.coerceAtLeast(this.imageRect.right - width, f5);
        float f6 = this.imageRect.top;
        float fCoerceAtLeast2 = kotlin.ranges.RangesKt.coerceAtLeast(this.imageRect.bottom - height, f6);
        float fCoerceIn = kotlin.ranges.RangesKt.coerceIn(f3, f5, fCoerceAtLeast);
        float fCoerceIn2 = kotlin.ranges.RangesKt.coerceIn(f4, f6, fCoerceAtLeast2);
        com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView7 = this.cropMagnifier;
        if (cropMagnifierView7 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropMagnifier");
            cropMagnifierView7 = null;
        }
        cropMagnifierView7.setTranslationX(fCoerceIn);
        com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView8 = this.cropMagnifier;
        if (cropMagnifierView8 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropMagnifier");
            cropMagnifierView8 = null;
        }
        cropMagnifierView8.setTranslationY(fCoerceIn2);
        com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView9 = this.cropMagnifier;
        if (cropMagnifierView9 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropMagnifier");
        } else {
            cropMagnifierView2 = cropMagnifierView9;
        }
        cropMagnifierView2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideCropMagnifier() {
        com.up366.photopicker.ui.crop.CropMagnifierView cropMagnifierView = this.cropMagnifier;
        if (cropMagnifierView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropMagnifier");
            cropMagnifierView = null;
        }
        cropMagnifierView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Multi-variable type inference failed */
    public final void logCropInteraction(com.up366.photopicker.ui.crop.CropOverlayView.Mode mode) throws kotlin.NoWhenBranchMatchedException {
        switch (com.up366.photopicker.ui.crop.CropActivity.WhenMappings.$EnumSwitchMapping$0[mode.ordinal()]) {
            case 1:
                com.up366.photopicker.oplog.PhotoPickerOpLogHelper.click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) this, CONTROL_RECT_MOVE, null, 4, null);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                java.lang.String strMapDragHandle = mapDragHandle(mode);
                if (strMapDragHandle != null) {
                    com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
                    jSONObject.put("dragHandle", strMapDragHandle);
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                    com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE.click((android.app.Activity) this, CONTROL_RECT_EDIT, jSONObject);
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final java.lang.String mapDragHandle(com.up366.photopicker.ui.crop.CropOverlayView.Mode mode) throws kotlin.NoWhenBranchMatchedException {
        switch (com.up366.photopicker.ui.crop.CropActivity.WhenMappings.$EnumSwitchMapping$0[mode.ordinal()]) {
            case 1:
            case 10:
                return null;
            case 2:
                return DRAG_HANDLE_TOP_LEFT;
            case 3:
                return DRAG_HANDLE_TOP_RIGHT;
            case 4:
                return DRAG_HANDLE_BOTTOM_LEFT;
            case 5:
                return DRAG_HANDLE_BOTTOM_RIGHT;
            case 6:
                return DRAG_HANDLE_TOP;
            case 7:
                return DRAG_HANDLE_BOTTOM;
            case 8:
                return DRAG_HANDLE_LEFT;
            case 9:
                return DRAG_HANDLE_RIGHT;
            default:
                throw new kotlin.NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cropImage() {
        if (!this.isImageLoaded || this.currentBitmap == null) {
            return;
        }
        com.up366.common.log.Logger.info("CropActivity 开始裁剪，draggingType=" + this.clipPageSetting.getDraggingType() + ", photoIndex=" + this.photoIndex);
        android.widget.ImageButton imageButton = this.btnConfirm;
        if (imageButton == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            imageButton = null;
        }
        imageButton.setEnabled(false);
        this.ioExecutor.execute(new java.lang.Runnable() { // from class: com.up366.photopicker.ui.crop.CropActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.photopicker.ui.crop.CropActivity.cropImage$lambda$16(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cropImage$lambda$16(final com.up366.photopicker.ui.crop.CropActivity cropActivity) {
        android.graphics.Bitmap bitmapCropRectBitmap;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        try {
            android.graphics.Bitmap bitmapLoadSourceBitmapForExport = cropActivity.loadSourceBitmapForExport();
            if (bitmapLoadSourceBitmapForExport == null) {
                throw new java.lang.IllegalStateException("无法加载原始图片");
            }
            if (cropActivity.clipPageSetting.getDraggingType() == 1) {
                bitmapCropRectBitmap = cropActivity.cropQuadBitmap(bitmapLoadSourceBitmapForExport);
            } else {
                bitmapCropRectBitmap = cropActivity.cropRectBitmap(bitmapLoadSourceBitmapForExport);
            }
            final java.io.File fileSaveCroppedBitmap = cropActivity.saveCroppedBitmap(bitmapCropRectBitmap);
            if (bitmapCropRectBitmap != bitmapLoadSourceBitmapForExport) {
                bitmapCropRectBitmap.recycle();
            }
            bitmapLoadSourceBitmapForExport.recycle();
            cropActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.up366.photopicker.ui.crop.CropActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.photopicker.ui.crop.CropActivity.cropImage$lambda$16$lambda$14(this.f$0, fileSaveCroppedBitmap);
                }
            });
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("裁剪图片失败", e);
            cropActivity.runOnUiThread(new java.lang.Runnable() { // from class: com.up366.photopicker.ui.crop.CropActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.photopicker.ui.crop.CropActivity.cropImage$lambda$16$lambda$15(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cropImage$lambda$16$lambda$14(com.up366.photopicker.ui.crop.CropActivity cropActivity, java.io.File file) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "$croppedFile");
        if (cropActivity.isFinishing() || cropActivity.isDestroyed()) {
            return;
        }
        java.lang.String absolutePath = file.getAbsolutePath();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(absolutePath, "croppedFile.absolutePath");
        android.content.Intent intentCreateCropResultIntent = cropActivity.createCropResultIntent(absolutePath);
        com.up366.common.log.Logger.info("CropActivity 矩形裁剪成功 path=" + file.getAbsolutePath());
        if (cropActivity.isMultipleMode) {
            cropActivity.setResult(-1, intentCreateCropResultIntent);
            cropActivity.finishNoAnimation();
        } else {
            if (cropActivity.fromCamera) {
                intentCreateCropResultIntent.putExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_RETURN_DIRECTLY, true);
            }
            cropActivity.setResult(-1, intentCreateCropResultIntent);
            cropActivity.finishNoAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void cropImage$lambda$16$lambda$15(com.up366.photopicker.ui.crop.CropActivity cropActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cropActivity, "this$0");
        if (cropActivity.isFinishing() || cropActivity.isDestroyed()) {
            return;
        }
        android.widget.ImageButton imageButton = cropActivity.btnConfirm;
        if (imageButton == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            imageButton = null;
        }
        imageButton.setEnabled(true);
        android.widget.Toast.makeText((android.content.Context) cropActivity, "裁剪失败", 0).show();
    }

    private final android.graphics.Bitmap loadSourceBitmapForExport() {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        android.graphics.Bitmap bitmapDecodeFile = android.graphics.BitmapFactory.decodeFile(this.sourceFilePath, options);
        if (bitmapDecodeFile == null) {
            return null;
        }
        android.graphics.Bitmap bitmapCorrectBitmapOrientation = correctBitmapOrientation(this.sourceFilePath, bitmapDecodeFile);
        if (bitmapCorrectBitmapOrientation == null) {
            bitmapCorrectBitmapOrientation = bitmapDecodeFile;
        }
        if (bitmapCorrectBitmapOrientation != bitmapDecodeFile) {
            bitmapDecodeFile.recycle();
        }
        android.graphics.Bitmap bitmapCropBitmapToVisibleArea = cropBitmapToVisibleArea(bitmapCorrectBitmapOrientation);
        if (bitmapCropBitmapToVisibleArea != bitmapCorrectBitmapOrientation) {
            bitmapCorrectBitmapOrientation.recycle();
            bitmapCorrectBitmapOrientation = bitmapCropBitmapToVisibleArea;
        }
        int i = this.rotationCount % 4;
        int i2 = 0;
        while (i2 < i) {
            android.graphics.Matrix matrix = new android.graphics.Matrix();
            matrix.postRotate(-90.0f);
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmapCorrectBitmapOrientation, 0, 0, bitmapCorrectBitmapOrientation.getWidth(), bitmapCorrectBitmapOrientation.getHeight(), matrix, true);
            if (bitmapCreateBitmap != bitmapCorrectBitmapOrientation) {
                bitmapCorrectBitmapOrientation.recycle();
            }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "rotatedBitmap");
            i2++;
            bitmapCorrectBitmapOrientation = bitmapCreateBitmap;
        }
        return bitmapCorrectBitmapOrientation;
    }

    private final android.graphics.Bitmap cropBitmapToVisibleArea(android.graphics.Bitmap bitmap) {
        if (!shouldUseVisibleAreaCrop()) {
            return bitmap;
        }
        float fCoerceIn = kotlin.ranges.RangesKt.coerceIn(this.visibleAreaRatio.left * bitmap.getWidth(), 0.0f, bitmap.getWidth());
        float fCoerceIn2 = kotlin.ranges.RangesKt.coerceIn(this.visibleAreaRatio.top * bitmap.getHeight(), 0.0f, bitmap.getHeight());
        float fCoerceIn3 = kotlin.ranges.RangesKt.coerceIn(this.visibleAreaRatio.right * bitmap.getWidth(), 0.0f, bitmap.getWidth());
        float fCoerceIn4 = kotlin.ranges.RangesKt.coerceIn(this.visibleAreaRatio.bottom * bitmap.getHeight(), 0.0f, bitmap.getHeight());
        int iCoerceIn = kotlin.ranges.RangesKt.coerceIn((int) fCoerceIn, 0, bitmap.getWidth() - 1);
        int iCoerceIn2 = kotlin.ranges.RangesKt.coerceIn((int) fCoerceIn2, 0, bitmap.getHeight() - 1);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap, iCoerceIn, iCoerceIn2, kotlin.ranges.RangesKt.coerceAtLeast(kotlin.ranges.RangesKt.coerceIn((int) fCoerceIn3, iCoerceIn + 1, bitmap.getWidth()) - iCoerceIn, 1), kotlin.ranges.RangesKt.coerceAtLeast(kotlin.ranges.RangesKt.coerceIn((int) fCoerceIn4, iCoerceIn2 + 1, bitmap.getHeight()) - iCoerceIn2, 1));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(bitmap, saf…p, safeWidth, safeHeight)");
        return bitmapCreateBitmap;
    }

    private final boolean shouldUseVisibleAreaCrop() {
        return java.lang.Math.abs(this.visibleAreaRatio.left) > 0.001f || java.lang.Math.abs(this.visibleAreaRatio.top) > 0.001f || java.lang.Math.abs(1.0f - this.visibleAreaRatio.right) > 0.001f || java.lang.Math.abs(1.0f - this.visibleAreaRatio.bottom) > 0.001f;
    }

    private final android.graphics.Bitmap cropRectBitmap(android.graphics.Bitmap sourceBitmap) {
        float fCoerceIn = kotlin.ranges.RangesKt.coerceIn(this.cropRectRatio.left * sourceBitmap.getWidth(), 0.0f, sourceBitmap.getWidth());
        float fCoerceIn2 = kotlin.ranges.RangesKt.coerceIn(this.cropRectRatio.top * sourceBitmap.getHeight(), 0.0f, sourceBitmap.getHeight());
        float fCoerceIn3 = kotlin.ranges.RangesKt.coerceIn(this.cropRectRatio.right * sourceBitmap.getWidth(), 0.0f, sourceBitmap.getWidth());
        float fCoerceIn4 = kotlin.ranges.RangesKt.coerceIn(this.cropRectRatio.bottom * sourceBitmap.getHeight(), 0.0f, sourceBitmap.getHeight());
        int iCoerceIn = kotlin.ranges.RangesKt.coerceIn((int) fCoerceIn, 0, sourceBitmap.getWidth() - 1);
        int iCoerceIn2 = kotlin.ranges.RangesKt.coerceIn((int) fCoerceIn2, 0, sourceBitmap.getHeight() - 1);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(sourceBitmap, iCoerceIn, iCoerceIn2, kotlin.ranges.RangesKt.coerceAtLeast(kotlin.ranges.RangesKt.coerceIn((int) fCoerceIn3, iCoerceIn + 1, sourceBitmap.getWidth()) - iCoerceIn, 1), kotlin.ranges.RangesKt.coerceAtLeast(kotlin.ranges.RangesKt.coerceIn((int) fCoerceIn4, iCoerceIn2 + 1, sourceBitmap.getHeight()) - iCoerceIn2, 1));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(sourceBitma…p, safeWidth, safeHeight)");
        return bitmapCreateBitmap;
    }

    private final android.graphics.Bitmap cropQuadBitmap(android.graphics.Bitmap sourceBitmap) {
        android.graphics.PointF[] pointFArr = this.quadCornerRatios;
        if (pointFArr == null) {
            com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView = this.cropOverlay;
            if (cropOverlayView == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropOverlay");
                cropOverlayView = null;
            }
            android.graphics.PointF[] corners = cropOverlayView.getCorners();
            java.util.ArrayList arrayList = new java.util.ArrayList(corners.length);
            for (android.graphics.PointF pointF : corners) {
                arrayList.add(new android.graphics.PointF(kotlin.ranges.RangesKt.coerceIn((pointF.x - this.imageRect.left) / this.imageRect.width(), 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn((pointF.y - this.imageRect.top) / this.imageRect.height(), 0.0f, 1.0f)));
            }
            pointFArr = (android.graphics.PointF[]) arrayList.toArray(new android.graphics.PointF[0]);
        }
        float[] fArr = new float[8];
        for (int i = 0; i < 4; i++) {
            int i2 = i * 2;
            fArr[i2] = kotlin.ranges.RangesKt.coerceIn(pointFArr[i].x * sourceBitmap.getWidth(), 0.0f, sourceBitmap.getWidth());
            fArr[i2 + 1] = kotlin.ranges.RangesKt.coerceIn(pointFArr[i].y * sourceBitmap.getHeight(), 0.0f, sourceBitmap.getHeight());
        }
        float fCropQuadBitmap$dist = cropQuadBitmap$dist(fArr, 0, 1);
        float fCropQuadBitmap$dist2 = cropQuadBitmap$dist(fArr, 3, 2);
        float fCropQuadBitmap$dist3 = cropQuadBitmap$dist(fArr, 0, 3);
        float fCropQuadBitmap$dist4 = cropQuadBitmap$dist(fArr, 1, 2);
        int iCoerceAtLeast = (int) kotlin.ranges.RangesKt.coerceAtLeast(java.lang.Math.max(fCropQuadBitmap$dist, fCropQuadBitmap$dist2), 1.0f);
        int iCoerceAtLeast2 = (int) kotlin.ranges.RangesKt.coerceAtLeast(java.lang.Math.max(fCropQuadBitmap$dist3, fCropQuadBitmap$dist4), 1.0f);
        float f = iCoerceAtLeast;
        float f2 = iCoerceAtLeast2;
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setPolyToPoly(fArr, 0, new float[]{0.0f, 0.0f, f, 0.0f, f, f2, 0.0f, f2}, 0, 4);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(iCoerceAtLeast, iCoerceAtLeast2, android.graphics.Bitmap.Config.ARGB_8888);
        new android.graphics.Canvas(bitmapCreateBitmap).drawBitmap(sourceBitmap, matrix, new android.graphics.Paint(2));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(dstW, dstH,… matrix, paint)\n        }");
        return bitmapCreateBitmap;
    }

    private static final float cropQuadBitmap$dist(float[] fArr, int i, int i2) {
        int i3 = i * 2;
        int i4 = i2 * 2;
        return (float) java.lang.Math.hypot(fArr[i3] - fArr[i4], fArr[i3 + 1] - fArr[i4 + 1]);
    }

    private final java.io.File saveCroppedBitmap(android.graphics.Bitmap croppedBitmap) {
        java.io.File file = new java.io.File(getExternalFilesDir(null), "CROPPED_" + java.lang.System.currentTimeMillis() + com.up366.medialibrary.common.utils.MimeTypeUtils.JPG);
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
        try {
            java.io.FileOutputStream fileOutputStream2 = fileOutputStream;
            croppedBitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 95, fileOutputStream2);
            fileOutputStream2.flush();
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            kotlin.io.CloseableKt.closeFinally(fileOutputStream, (java.lang.Throwable) null);
            try {
                android.media.ExifInterface exifInterface = new android.media.ExifInterface(file.getAbsolutePath());
                exifInterface.setAttribute("Orientation", "1");
                exifInterface.saveAttributes();
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("重置 EXIF 信息失败", e);
            }
            return file;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void retake() {
        com.up366.common.log.Logger.info("CropActivity 重拍，photoIndex=" + this.photoIndex);
        setResult(0);
        finishNoAnimation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void rotateImage() {
        android.graphics.Bitmap bitmap;
        if (this.currentBitmap == null) {
            return;
        }
        com.up366.common.log.Logger.info("CropActivity 旋转图片，当前 rotationCount=" + this.rotationCount);
        android.graphics.Bitmap bitmap2 = this.currentBitmap;
        kotlin.jvm.internal.Intrinsics.checkNotNull(bitmap2);
        android.graphics.RectF cropRectInBitmap = getCropRectInBitmap();
        android.graphics.PointF[] quadCornersInBitmap = this.clipPageSetting.getDraggingType() == 1 ? getQuadCornersInBitmap() : null;
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postRotate(-90.0f);
        try {
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
            if (!kotlin.jvm.internal.Intrinsics.areEqual(this.currentBitmap, this.originalBitmap) && (bitmap = this.currentBitmap) != null) {
                bitmap.recycle();
            }
            this.currentBitmap = bitmapCreateBitmap;
            this.rotationCount = (this.rotationCount + 1) % 4;
            float width = bitmapCreateBitmap.getWidth();
            float height = bitmapCreateBitmap.getHeight();
            if (this.clipPageSetting.getDraggingType() == 1 && quadCornersInBitmap != null) {
                java.util.ArrayList arrayList = new java.util.ArrayList(quadCornersInBitmap.length);
                for (android.graphics.PointF pointF : quadCornersInBitmap) {
                    arrayList.add(mapPointAfterRotateCCW(pointF, bitmap2.getWidth(), bitmap2.getHeight()));
                }
                java.util.ArrayList arrayList2 = arrayList;
                java.util.ArrayList<android.graphics.PointF> arrayList3 = arrayList2;
                java.util.ArrayList arrayList4 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                for (android.graphics.PointF pointF2 : arrayList3) {
                    arrayList4.add(new android.graphics.PointF(kotlin.ranges.RangesKt.coerceIn(pointF2.x / width, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn(pointF2.y / height, 0.0f, 1.0f)));
                }
                this.quadCornerRatios = (android.graphics.PointF[]) arrayList4.toArray(new android.graphics.PointF[0]);
                android.graphics.RectF rectFBuildBoundsFromPoints = buildBoundsFromPoints(arrayList2);
                this.cropRectRatio = new android.graphics.RectF(kotlin.ranges.RangesKt.coerceIn(rectFBuildBoundsFromPoints.left / width, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn(rectFBuildBoundsFromPoints.top / height, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn(rectFBuildBoundsFromPoints.right / width, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn(rectFBuildBoundsFromPoints.bottom / height, 0.0f, 1.0f));
            } else if (cropRectInBitmap != null) {
                android.graphics.RectF rectFFitRectWithin = fitRectWithin(mapRectAfterRotateCCW(cropRectInBitmap, bitmap2.getWidth(), bitmap2.getHeight()), new android.graphics.RectF(0.0f, 0.0f, width, height));
                this.cropRectRatio = new android.graphics.RectF(kotlin.ranges.RangesKt.coerceIn(rectFFitRectWithin.left / width, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn(rectFFitRectWithin.top / height, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn(rectFFitRectWithin.right / width, 0.0f, 1.0f), kotlin.ranges.RangesKt.coerceIn(rectFFitRectWithin.bottom / height, 0.0f, 1.0f));
            }
            setupImageView();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("旋转图片失败", e);
            android.widget.Toast.makeText((android.content.Context) this, "旋转失败", 0).show();
        }
    }

    private final android.content.Intent createCropResultIntent(java.lang.String croppedPath) {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_CROPPED_PATH, croppedPath);
        intent.putExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_INDEX, this.photoIndex);
        intent.putExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_IS_RECT_ADJUSTED, this.isRectAdjustedByUser);
        com.up366.photopicker.PhotoPicker.INSTANCE.putResults$photopicker_release(intent, kotlin.collections.CollectionsKt.listOfNotNull(com.up366.photopicker.PhotoPicker.INSTANCE.createPhotoResult$photopicker_release(croppedPath, this.isRectAdjustedByUser)));
        return intent;
    }

    private final android.graphics.RectF getCropRectInBitmap() {
        com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView = null;
        if (!this.isImageLoaded || this.currentBitmap == null) {
            return null;
        }
        com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView2 = this.cropOverlay;
        if (cropOverlayView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropOverlay");
        } else {
            cropOverlayView = cropOverlayView2;
        }
        android.graphics.RectF cropRect = cropOverlayView.getCropRect();
        return new android.graphics.RectF((cropRect.left - this.imageRect.left) / this.scaleFactor, (cropRect.top - this.imageRect.top) / this.scaleFactor, (cropRect.right - this.imageRect.left) / this.scaleFactor, (cropRect.bottom - this.imageRect.top) / this.scaleFactor);
    }

    private final android.graphics.PointF[] getQuadCornersInBitmap() {
        com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView = null;
        if (!this.isImageLoaded || this.currentBitmap == null || this.clipPageSetting.getDraggingType() != 1) {
            return null;
        }
        com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView2 = this.cropOverlay;
        if (cropOverlayView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropOverlay");
        } else {
            cropOverlayView = cropOverlayView2;
        }
        android.graphics.PointF[] corners = cropOverlayView.getCorners();
        java.util.ArrayList arrayList = new java.util.ArrayList(corners.length);
        for (android.graphics.PointF pointF : corners) {
            float f = (pointF.x - this.imageRect.left) / this.scaleFactor;
            kotlin.jvm.internal.Intrinsics.checkNotNull(this.currentBitmap);
            float fCoerceIn = kotlin.ranges.RangesKt.coerceIn(f, 0.0f, r8.getWidth());
            float f2 = (pointF.y - this.imageRect.top) / this.scaleFactor;
            kotlin.jvm.internal.Intrinsics.checkNotNull(this.currentBitmap);
            arrayList.add(new android.graphics.PointF(fCoerceIn, kotlin.ranges.RangesKt.coerceIn(f2, 0.0f, r8.getHeight())));
        }
        return (android.graphics.PointF[]) arrayList.toArray(new android.graphics.PointF[0]);
    }

    private final void applyQuadCornersToOverlay(com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView) {
        android.graphics.PointF[] pointFArr = this.quadCornerRatios;
        if (this.clipPageSetting.getDraggingType() != 1 || pointFArr == null || pointFArr.length == 0) {
            this.quadCornerRatios = null;
            return;
        }
        int length = pointFArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            android.graphics.PointF pointF = pointFArr[i];
            cropOverlayView.getCorners()[i2].set(this.imageRect.left + (this.imageRect.width() * kotlin.ranges.RangesKt.coerceIn(pointF.x, 0.0f, 1.0f)), this.imageRect.top + (this.imageRect.height() * kotlin.ranges.RangesKt.coerceIn(pointF.y, 0.0f, 1.0f)));
            i++;
            i2++;
        }
        cropOverlayView.getCropRect().set(fitRectWithin(buildBoundsFromPoints(kotlin.collections.ArraysKt.asList(cropOverlayView.getCorners())), this.imageRect));
    }

    private final android.graphics.RectF buildBoundsFromPoints(java.util.List<? extends android.graphics.PointF> points) {
        java.util.List<? extends android.graphics.PointF> list = points;
        java.util.Iterator<T> it = list.iterator();
        if (!it.hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        float fMin = ((android.graphics.PointF) it.next()).x;
        while (it.hasNext()) {
            fMin = java.lang.Math.min(fMin, ((android.graphics.PointF) it.next()).x);
        }
        java.util.Iterator<T> it2 = list.iterator();
        if (!it2.hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        float fMin2 = ((android.graphics.PointF) it2.next()).y;
        while (it2.hasNext()) {
            fMin2 = java.lang.Math.min(fMin2, ((android.graphics.PointF) it2.next()).y);
        }
        java.util.Iterator<T> it3 = list.iterator();
        if (!it3.hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        float fMax = ((android.graphics.PointF) it3.next()).x;
        while (it3.hasNext()) {
            fMax = java.lang.Math.max(fMax, ((android.graphics.PointF) it3.next()).x);
        }
        java.util.Iterator<T> it4 = list.iterator();
        if (!it4.hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        float fMax2 = ((android.graphics.PointF) it4.next()).y;
        while (it4.hasNext()) {
            fMax2 = java.lang.Math.max(fMax2, ((android.graphics.PointF) it4.next()).y);
        }
        return new android.graphics.RectF(fMin, fMin2, fMax, fMax2);
    }

    private final android.graphics.PointF mapPointAfterRotateCCW(android.graphics.PointF point, float oldWidth, float oldHeight) {
        return new android.graphics.PointF(kotlin.ranges.RangesKt.coerceIn(point.y, 0.0f, oldHeight), kotlin.ranges.RangesKt.coerceIn(oldWidth - point.x, 0.0f, oldWidth));
    }

    private final android.graphics.RectF mapRectAfterRotateCCW(android.graphics.RectF rect, float oldWidth, float oldHeight) {
        java.util.List<android.graphics.PointF> listListOf = kotlin.collections.CollectionsKt.listOf(new android.graphics.PointF[]{new android.graphics.PointF(rect.left, rect.top), new android.graphics.PointF(rect.right, rect.top), new android.graphics.PointF(rect.right, rect.bottom), new android.graphics.PointF(rect.left, rect.bottom)});
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        for (android.graphics.PointF pointF : listListOf) {
            arrayList.add(new android.graphics.PointF(pointF.y, oldWidth - pointF.x));
        }
        java.util.ArrayList arrayList2 = arrayList;
        java.util.Iterator it = arrayList2.iterator();
        if (!it.hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        float fMin = ((android.graphics.PointF) it.next()).x;
        while (it.hasNext()) {
            fMin = java.lang.Math.min(fMin, ((android.graphics.PointF) it.next()).x);
        }
        float fCoerceIn = kotlin.ranges.RangesKt.coerceIn(fMin, 0.0f, oldHeight);
        java.util.Iterator it2 = arrayList2.iterator();
        if (!it2.hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        float fMax = ((android.graphics.PointF) it2.next()).x;
        while (it2.hasNext()) {
            fMax = java.lang.Math.max(fMax, ((android.graphics.PointF) it2.next()).x);
        }
        float fCoerceIn2 = kotlin.ranges.RangesKt.coerceIn(fMax, 0.0f, oldHeight);
        java.util.Iterator it3 = arrayList2.iterator();
        if (!it3.hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        float fMin2 = ((android.graphics.PointF) it3.next()).y;
        while (it3.hasNext()) {
            fMin2 = java.lang.Math.min(fMin2, ((android.graphics.PointF) it3.next()).y);
        }
        float fCoerceIn3 = kotlin.ranges.RangesKt.coerceIn(fMin2, 0.0f, oldWidth);
        java.util.Iterator it4 = arrayList2.iterator();
        if (!it4.hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        float fMax2 = ((android.graphics.PointF) it4.next()).y;
        while (it4.hasNext()) {
            fMax2 = java.lang.Math.max(fMax2, ((android.graphics.PointF) it4.next()).y);
        }
        return new android.graphics.RectF(fCoerceIn, fCoerceIn3, fCoerceIn2, kotlin.ranges.RangesKt.coerceIn(fMax2, 0.0f, oldWidth));
    }

    private final android.graphics.RectF fitRectWithin(android.graphics.RectF rect, android.graphics.RectF bounds) {
        float fWidth = rect.width();
        float fHeight = rect.height();
        if (fWidth <= 0.0f || fHeight <= 0.0f) {
            return new android.graphics.RectF(bounds);
        }
        if (fWidth > bounds.width() || fHeight > bounds.height()) {
            float fMin = java.lang.Math.min(bounds.width() / fWidth, bounds.height() / fHeight);
            fWidth *= fMin;
            fHeight *= fMin;
        }
        float f = fWidth / 2.0f;
        float f2 = fHeight / 2.0f;
        float fCoerceIn = kotlin.ranges.RangesKt.coerceIn(rect.centerX(), bounds.left + f, bounds.right - f);
        float fCoerceIn2 = kotlin.ranges.RangesKt.coerceIn(rect.centerY(), bounds.top + f2, bounds.bottom - f2);
        return new android.graphics.RectF(fCoerceIn - f, fCoerceIn2 - f2, fCoerceIn + f, fCoerceIn2 + f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDestroy() {
        super.onDestroy();
        com.up366.photopicker.oplog.PhotoPickerOpLogHelper.leavePage$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper.INSTANCE, (android.app.Activity) this, null, 2, null);
        com.up366.common.log.Logger.info("CropActivity onDestroy");
        android.graphics.Bitmap bitmap = this.originalBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        com.up366.photopicker.ui.WebViewDialog webViewDialog = this.webViewDialog;
        if (webViewDialog != null) {
            webViewDialog.dismiss();
        }
        this.webViewDialog = null;
        this.ioExecutor.shutdownNow();
    }

    public void onBackPressed() {
        com.up366.photopicker.ui.WebViewDialog webViewDialog;
        com.up366.photopicker.ui.WebViewDialog webViewDialog2 = this.webViewDialog;
        if (webViewDialog2 == null || webViewDialog2 == null || !webViewDialog2.isShowing() || (webViewDialog = this.webViewDialog) == null) {
            return;
        }
        webViewDialog.dismiss();
    }

    private final void finishNoAnimation() {
        finish();
        overridePendingTransition(0, 0);
    }

    private final void applyConfig() {
        com.up366.photopicker.config.RectSetting rectSetting;
        com.up366.photopicker.config.RectSetting rectSetting2;
        android.graphics.RectF rectF;
        com.up366.common.log.Logger.info("CropActivity applyConfig");
        com.up366.photopicker.config.RectSetting rectSetting3 = this.clipPageSetting.getRectSetting();
        if (rectSetting3 == null || !rectSetting3.isExplicit()) {
            rectSetting = (this.cameraPageSetting.getRectSetting() == null || !this.cameraPageSetting.getRectSetting().isExplicit()) ? new com.up366.photopicker.config.RectSetting() : this.cameraPageSetting.getRectSetting();
        } else {
            rectSetting = rectSetting3;
        }
        com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView = this.cropOverlay;
        android.widget.TextView textView = null;
        if (cropOverlayView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropOverlay");
            cropOverlayView = null;
        }
        cropOverlayView.setRectPadding(rectSetting.getTop(), rectSetting.getBottom(), rectSetting.getLeft(), rectSetting.getRight());
        if ((rectSetting3 == null || !rectSetting3.isExplicit()) && (rectSetting2 = this.cameraPageSetting.getRectSetting()) != null && rectSetting2.isExplicit() && (rectF = this.initialCropOverrideRatio) != null) {
            android.graphics.RectF rectF2 = this.cropRectRatio;
            kotlin.jvm.internal.Intrinsics.checkNotNull(rectF);
            rectF2.set(rectF);
            this.quadCornerRatios = null;
        } else {
            float fCoerceIn = kotlin.ranges.RangesKt.coerceIn(rectSetting.getLeft(), 0.0f, 1.0f);
            float fCoerceIn2 = kotlin.ranges.RangesKt.coerceIn(rectSetting.getTop(), 0.0f, 1.0f);
            float fCoerceIn3 = kotlin.ranges.RangesKt.coerceIn(1.0f - rectSetting.getRight(), 0.0f, 1.0f);
            float fCoerceIn4 = kotlin.ranges.RangesKt.coerceIn(1.0f - rectSetting.getBottom(), 0.0f, 1.0f);
            if (fCoerceIn3 <= fCoerceIn) {
                fCoerceIn3 = kotlin.ranges.RangesKt.coerceAtMost(fCoerceIn + 0.05f, 1.0f);
                fCoerceIn = kotlin.ranges.RangesKt.coerceAtLeast(fCoerceIn3 - 0.05f, 0.0f);
            }
            if (fCoerceIn4 <= fCoerceIn2) {
                fCoerceIn4 = kotlin.ranges.RangesKt.coerceAtMost(fCoerceIn2 + 0.05f, 1.0f);
                fCoerceIn2 = kotlin.ranges.RangesKt.coerceAtLeast(fCoerceIn4 - 0.05f, 0.0f);
            }
            this.cropRectRatio.set(fCoerceIn, fCoerceIn2, fCoerceIn3, fCoerceIn4);
            this.quadCornerRatios = null;
        }
        com.up366.photopicker.ui.crop.CropOverlayView cropOverlayView2 = this.cropOverlay;
        if (cropOverlayView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("cropOverlay");
            cropOverlayView2 = null;
        }
        cropOverlayView2.setDraggingType(this.clipPageSetting.getDraggingType());
        android.widget.TextView textView2 = this.btnGuide;
        if (textView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnGuide");
            textView2 = null;
        }
        textView2.setVisibility(this.clipPageSetting.getGuideSetting().isGuideButtonHidden() ? 8 : 0);
        java.lang.String description = this.clipPageSetting.getDescription();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(description, "desc");
        java.lang.String str = description;
        if (!kotlin.text.StringsKt.isBlank(str)) {
            android.widget.TextView textView3 = this.tvCropHint;
            if (textView3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvCropHint");
                textView3 = null;
            }
            textView3.setText(str);
            android.widget.TextView textView4 = this.tvCropHint;
            if (textView4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvCropHint");
            } else {
                textView = textView4;
            }
            textView.setVisibility(0);
        } else {
            android.widget.TextView textView5 = this.tvCropHint;
            if (textView5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tvCropHint");
            } else {
                textView = textView5;
            }
            textView.setVisibility(8);
        }
        if (getIntent().getBooleanExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_SHOW_CLIP_AUTO_GUIDE, this.clipPageSetting.getGuideSetting().isGuideAutoShown())) {
            com.up366.common.log.Logger.info("CropActivity 自动展示引导页");
            showGuide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showGuide() {
        com.up366.photopicker.config.GuideSetting guideSetting = this.clipPageSetting.getGuideSetting();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("CropActivity 展示引导页，shownType=");
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
            com.up366.common.log.Logger.info("CropActivity 通过 GuideActivity 打开引导页 url=" + guideSetting.getUrl());
            android.content.Intent intent = new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.photopicker.ui.GuideActivity.class);
            intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, guideSetting.getUrl());
            intent.putExtra(com.up366.photopicker.ui.GuideActivity.EXTRA_USE_DIALOG, false);
            startActivity(intent);
            return;
        }
        if (this.webViewDialog == null) {
            com.up366.common.log.Logger.info("CropActivity 创建 WebViewDialog");
            this.webViewDialog = new com.up366.photopicker.ui.WebViewDialog((android.content.Context) this);
        }
        com.up366.common.log.Logger.info("CropActivity 调用 WebViewDialog.loadUrl");
        com.up366.photopicker.ui.WebViewDialog webViewDialog2 = this.webViewDialog;
        if (webViewDialog2 != null) {
            webViewDialog2.loadUrl(guideSetting.getUrl());
        }
        com.up366.common.log.Logger.info("CropActivity 调用 WebViewDialog.show");
        com.up366.photopicker.ui.WebViewDialog webViewDialog3 = this.webViewDialog;
        if (webViewDialog3 != null) {
            webViewDialog3.show();
        }
    }
}
