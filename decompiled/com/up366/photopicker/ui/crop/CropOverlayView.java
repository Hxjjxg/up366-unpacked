package com.up366.photopicker.ui.crop;

/* JADX INFO: compiled from: CropOverlayView.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001:\u0002\u008c\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010F\u001a\u00020\u00192\u0006\u0010G\u001a\u00020\u00192\u0006\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u0019H\u0002J\u0010\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u00020)2\u0006\u0010K\u001a\u00020LH\u0002J \u0010N\u001a\u00020)2\u0006\u0010K\u001a\u00020L2\u0006\u0010O\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u000bH\u0002J\u0010\u0010Q\u001a\u00020)2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010R\u001a\u00020)2\u0006\u0010K\u001a\u00020LH\u0002J\u0018\u0010S\u001a\u00020)2\u0006\u0010K\u001a\u00020L2\u0006\u0010T\u001a\u00020\u0007H\u0002J@\u0010U\u001a\u00020)2\u0006\u0010K\u001a\u00020L2\u0006\u0010V\u001a\u00020\u00192\u0006\u0010W\u001a\u00020\u00192\u0006\u0010X\u001a\u00020\u00192\u0006\u0010Y\u001a\u00020\u00192\u0006\u0010Z\u001a\u00020\u00192\u0006\u0010[\u001a\u00020\u0019H\u0002J\u0010\u0010\\\u001a\u00020)2\u0006\u0010]\u001a\u00020\u001bH\u0002J\u0018\u0010^\u001a\u00020&2\u0006\u0010_\u001a\u00020\u00192\u0006\u0010`\u001a\u00020\u0019H\u0002J\u0018\u0010a\u001a\u00020)2\u0006\u0010_\u001a\u00020\u00192\u0006\u0010`\u001a\u00020\u0019H\u0002J\u001b\u0010b\u001a\u00020\u001b2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0002\u0010dJ\u0010\u0010e\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0002J0\u0010f\u001a\u00020\u001b2\u0006\u0010_\u001a\u00020\u00192\u0006\u0010`\u001a\u00020\u00192\u0006\u0010g\u001a\u00020\u00192\u0006\u0010h\u001a\u00020\u00192\u0006\u0010i\u001a\u00020\u0019H\u0002J\u0010\u0010j\u001a\u00020)2\u0006\u0010K\u001a\u00020LH\u0014J \u0010k\u001a\u00020\u001b2\u0006\u0010l\u001a\u00020\u000b2\u0006\u0010m\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020\u000bH\u0002J\u0010\u0010o\u001a\u00020\u001b2\u0006\u0010p\u001a\u00020qH\u0016J+\u0010r\u001a\u00020\u001b2\u0006\u0010_\u001a\u00020\u00192\u0006\u0010`\u001a\u00020\u00192\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0002\u0010sJ\u001b\u0010t\u001a\u00020\u00192\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0002\u0010uJ\u001b\u0010v\u001a\u00020\u001b2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0002\u0010dJ\u0018\u0010w\u001a\u00020\u001b2\u0006\u0010x\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u000bH\u0002J\u0018\u0010z\u001a\u00020\u001b2\u0006\u0010x\u001a\u00020\u00122\u0006\u0010y\u001a\u00020\u0012H\u0002J(\u0010{\u001a\u00020\u001b2\u0006\u0010|\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u000b2\u0006\u0010~\u001a\u00020\u000b2\u0006\u0010\u007f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0080\u0001\u001a\u00020)2\u0007\u0010\u0081\u0001\u001a\u00020\u0007J\u0010\u0010\u0082\u0001\u001a\u00020)2\u0007\u0010\u0083\u0001\u001a\u00020\u0012J+\u0010\u0084\u0001\u001a\u00020)2\u0007\u0010\u0085\u0001\u001a\u00020\u00192\u0007\u0010\u0086\u0001\u001a\u00020\u00192\u0007\u0010\u0087\u0001\u001a\u00020\u00192\u0007\u0010\u0088\u0001\u001a\u00020\u0019J#\u0010\u0089\u0001\u001a\u00020\u001b2\u0006\u0010T\u001a\u00020\u00072\u0007\u0010\u008a\u0001\u001a\u00020\u00192\u0007\u0010\u008b\u0001\u001a\u00020\u0019H\u0002R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010'\u001a\u001c\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020)\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R(\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020)\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R(\u00104\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020)\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R(\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020)\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00101\"\u0004\b9\u00103R\u000e\u0010:\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008d\u0001"}, d2 = {"Lcom/up366/photopicker/ui/crop/CropOverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "corners", "", "Landroid/graphics/PointF;", "getCorners", "()[Landroid/graphics/PointF;", "setCorners", "([Landroid/graphics/PointF;)V", "[Landroid/graphics/PointF;", "cropRect", "Landroid/graphics/RectF;", "getCropRect", "()Landroid/graphics/RectF;", "setCropRect", "(Landroid/graphics/RectF;)V", "draggingType", "handleSize", "", "<set-?>", "", "hasUserAdjustedCrop", "getHasUserAdjustedCrop", "()Z", "imageRect", "innerDragRadius", "interactionChanged", "lastX", "lastY", "minCropSize", "mode", "Lcom/up366/photopicker/ui/crop/CropOverlayView$Mode;", "onCornerDragPreviewChanged", "Lkotlin/Function3;", "", "getOnCornerDragPreviewChanged", "()Lkotlin/jvm/functions/Function3;", "setOnCornerDragPreviewChanged", "(Lkotlin/jvm/functions/Function3;)V", "onCropRectChanged", "Lkotlin/Function1;", "getOnCropRectChanged", "()Lkotlin/jvm/functions/Function1;", "setOnCropRectChanged", "(Lkotlin/jvm/functions/Function1;)V", "onInteractionFinished", "getOnInteractionFinished", "setOnInteractionFinished", "onUserAdjustedCropChanged", "getOnUserAdjustedCropChanged", "setOnUserAdjustedCropChanged", "overlayAlpha", "paintCorner", "Landroid/graphics/Paint;", "paintHandle", "paintOverlay", "quadCornerGuideLength", "quadHandleRadius", "rectDisplayCornerRadius", "rectPaddingBottom", "rectPaddingLeft", "rectPaddingRight", "rectPaddingTop", "constrain", "value", "min", "max", "drawCornerHandles", "canvas", "Landroid/graphics/Canvas;", "drawCornerHandlesQuad", "drawGuideSegment", "start", "end", "drawOverlay", "drawOverlayQuad", "drawQuadCornerGuide", com.up366.photopicker.PhotoPickerConstants.EXTRA_INDEX, "drawRoundedRectCorner", "cornerX", "cornerY", "horizontalDirection", "verticalDirection", "cornerLength", "cornerRadius", "emitCornerDragPreview", "visible", "getTouchMode", "x", "y", "handleMove", "isConvex", "pts", "([Landroid/graphics/PointF;)Z", "isCornerResizeMode", "isNearPoint", "px", "py", "tolerance", "onDraw", "onSegment", "a", "b", com.igexin.push.core.d.d.f, "onTouchEvent", "event", "Landroid/view/MotionEvent;", "pointInPolygon", "(FF[Landroid/graphics/PointF;)Z", "polygonArea", "([Landroid/graphics/PointF;)F", "polygonIsSimple", "samePoint", "first", "second", "sameRect", "segmentsIntersect", "p1", "p2", "p3", "p4", "setDraggingType", "type", "setImageRect", "rect", "setRectPadding", com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_TOP, com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_BOTTOM, com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_LEFT, com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_RIGHT, "tryMoveCorner", "newX", "newY", "Mode", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CropOverlayView extends android.view.View {
    private android.graphics.PointF[] corners;
    private android.graphics.RectF cropRect;
    private int draggingType;
    private final float handleSize;
    private boolean hasUserAdjustedCrop;
    private android.graphics.RectF imageRect;
    private final float innerDragRadius;
    private boolean interactionChanged;
    private float lastX;
    private float lastY;
    private final float minCropSize;
    private com.up366.photopicker.ui.crop.CropOverlayView.Mode mode;
    private kotlin.jvm.functions.Function3<? super java.lang.Boolean, ? super java.lang.Float, ? super java.lang.Float, kotlin.Unit> onCornerDragPreviewChanged;
    private kotlin.jvm.functions.Function1<? super android.graphics.RectF, kotlin.Unit> onCropRectChanged;
    private kotlin.jvm.functions.Function1<? super com.up366.photopicker.ui.crop.CropOverlayView.Mode, kotlin.Unit> onInteractionFinished;
    private kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onUserAdjustedCropChanged;
    private final int overlayAlpha;
    private final android.graphics.Paint paintCorner;
    private final android.graphics.Paint paintHandle;
    private final android.graphics.Paint paintOverlay;
    private final float quadCornerGuideLength;
    private final float quadHandleRadius;
    private final float rectDisplayCornerRadius;
    private float rectPaddingBottom;
    private float rectPaddingLeft;
    private float rectPaddingRight;
    private float rectPaddingTop;

    /* JADX INFO: compiled from: CropOverlayView.kt */
    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/up366/photopicker/ui/crop/CropOverlayView$Mode;", "", "(Ljava/lang/String;I)V", "NONE", "MOVE_CENTER", "RESIZE_TL", "RESIZE_TR", "RESIZE_BL", "RESIZE_BR", "RESIZE_T", "RESIZE_B", "RESIZE_L", "RESIZE_R", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Mode {
        NONE,
        MOVE_CENTER,
        RESIZE_TL,
        RESIZE_TR,
        RESIZE_BL,
        RESIZE_BR,
        RESIZE_T,
        RESIZE_B,
        RESIZE_L,
        RESIZE_R
    }

    /* JADX INFO: compiled from: CropOverlayView.kt */
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropOverlayView(android.content.Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CropOverlayView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean isNearPoint(float x, float y, float px, float py, float tolerance) {
        float f = x - px;
        float f2 = y - py;
        return (f * f) + (f2 * f2) <= tolerance * tolerance;
    }

    public /* synthetic */ CropOverlayView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CropOverlayView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        this.overlayAlpha = 128;
        this.rectDisplayCornerRadius = com.up366.photopicker.ui.crop.CropOverlayViewKt.dpToPx(10.0f, context);
        this.quadCornerGuideLength = com.up366.photopicker.ui.crop.CropOverlayViewKt.dpToPx(17.0f, context);
        this.quadHandleRadius = com.up366.photopicker.ui.crop.CropOverlayViewKt.dpToPx(10.0f, context);
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setColor(android.graphics.Color.argb(128, 0, 0, 0));
        paint.setStyle(android.graphics.Paint.Style.FILL);
        this.paintOverlay = paint;
        android.graphics.Paint paint2 = new android.graphics.Paint();
        paint2.setColor(-1);
        paint2.setStrokeWidth(com.up366.photopicker.ui.crop.CropOverlayViewKt.dpToPx(4.0f, context));
        paint2.setStyle(android.graphics.Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint2.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        this.paintCorner = paint2;
        android.graphics.Paint paint3 = new android.graphics.Paint();
        paint3.setColor(-1);
        paint3.setStyle(android.graphics.Paint.Style.FILL);
        paint3.setAntiAlias(true);
        this.paintHandle = paint3;
        this.innerDragRadius = com.up366.photopicker.ui.crop.CropOverlayViewKt.dpToPx(30.0f, context);
        this.handleSize = com.up366.photopicker.ui.crop.CropOverlayViewKt.dpToPx(18.0f, context);
        this.minCropSize = com.up366.photopicker.ui.crop.CropOverlayViewKt.dpToPx(50.0f, context);
        this.cropRect = new android.graphics.RectF();
        android.graphics.PointF[] pointFArr = new android.graphics.PointF[4];
        for (int i2 = 0; i2 < 4; i2++) {
            pointFArr[i2] = new android.graphics.PointF();
        }
        this.corners = pointFArr;
        this.mode = com.up366.photopicker.ui.crop.CropOverlayView.Mode.NONE;
        this.imageRect = new android.graphics.RectF();
        this.rectPaddingTop = 0.2f;
        this.rectPaddingBottom = 0.2f;
        this.rectPaddingLeft = 0.2f;
        this.rectPaddingRight = 0.2f;
    }

    public final android.graphics.RectF getCropRect() {
        return this.cropRect;
    }

    public final void setCropRect(android.graphics.RectF rectF) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rectF, "<set-?>");
        this.cropRect = rectF;
    }

    public final kotlin.jvm.functions.Function1<android.graphics.RectF, kotlin.Unit> getOnCropRectChanged() {
        return this.onCropRectChanged;
    }

    public final void setOnCropRectChanged(kotlin.jvm.functions.Function1<? super android.graphics.RectF, kotlin.Unit> function1) {
        this.onCropRectChanged = function1;
    }

    public final kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> getOnUserAdjustedCropChanged() {
        return this.onUserAdjustedCropChanged;
    }

    public final void setOnUserAdjustedCropChanged(kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> function1) {
        this.onUserAdjustedCropChanged = function1;
    }

    public final kotlin.jvm.functions.Function3<java.lang.Boolean, java.lang.Float, java.lang.Float, kotlin.Unit> getOnCornerDragPreviewChanged() {
        return this.onCornerDragPreviewChanged;
    }

    public final void setOnCornerDragPreviewChanged(kotlin.jvm.functions.Function3<? super java.lang.Boolean, ? super java.lang.Float, ? super java.lang.Float, kotlin.Unit> function3) {
        this.onCornerDragPreviewChanged = function3;
    }

    public final kotlin.jvm.functions.Function1<com.up366.photopicker.ui.crop.CropOverlayView.Mode, kotlin.Unit> getOnInteractionFinished() {
        return this.onInteractionFinished;
    }

    public final void setOnInteractionFinished(kotlin.jvm.functions.Function1<? super com.up366.photopicker.ui.crop.CropOverlayView.Mode, kotlin.Unit> function1) {
        this.onInteractionFinished = function1;
    }

    public final boolean getHasUserAdjustedCrop() {
        return this.hasUserAdjustedCrop;
    }

    public final android.graphics.PointF[] getCorners() {
        return this.corners;
    }

    public final void setCorners(android.graphics.PointF[] pointFArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pointFArr, "<set-?>");
        this.corners = pointFArr;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.imageRect.isEmpty()) {
            return;
        }
        if (this.draggingType == 0) {
            drawOverlay(canvas);
        } else {
            drawOverlayQuad(canvas);
        }
        if (this.draggingType == 0) {
            drawCornerHandles(canvas);
        } else {
            drawCornerHandlesQuad(canvas);
        }
    }

    private final void drawOverlayQuad(android.graphics.Canvas canvas) {
        android.graphics.Path path = new android.graphics.Path();
        path.addRect(this.imageRect, android.graphics.Path.Direction.CW);
        android.graphics.Path path2 = new android.graphics.Path();
        path2.moveTo(this.corners[0].x, this.corners[0].y);
        path2.lineTo(this.corners[1].x, this.corners[1].y);
        path2.lineTo(this.corners[2].x, this.corners[2].y);
        path2.lineTo(this.corners[3].x, this.corners[3].y);
        path2.close();
        path.addPath(path2);
        path.setFillType(android.graphics.Path.FillType.EVEN_ODD);
        canvas.drawPath(path, this.paintOverlay);
    }

    private final void drawCornerHandlesQuad(android.graphics.Canvas canvas) {
        android.graphics.PointF[] pointFArr = this.corners;
        int length = pointFArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            android.graphics.PointF pointF = pointFArr[i];
            drawQuadCornerGuide(canvas, i2);
            canvas.drawCircle(pointF.x, pointF.y, this.quadHandleRadius, this.paintHandle);
            i++;
            i2++;
        }
    }

    private final void drawOverlay(android.graphics.Canvas canvas) {
        android.graphics.Path path = new android.graphics.Path();
        path.addRect(this.imageRect, android.graphics.Path.Direction.CW);
        android.graphics.RectF rectF = this.cropRect;
        path.addRoundRect(rectF, kotlin.ranges.RangesKt.coerceAtMost(this.rectDisplayCornerRadius, rectF.width() / 2.0f), kotlin.ranges.RangesKt.coerceAtMost(this.rectDisplayCornerRadius, this.cropRect.height() / 2.0f), android.graphics.Path.Direction.CCW);
        canvas.drawPath(path, this.paintOverlay);
    }

    private final void drawCornerHandles(android.graphics.Canvas canvas) {
        android.content.Context context = getContext();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context, "context");
        float fDpToPx = com.up366.photopicker.ui.crop.CropOverlayViewKt.dpToPx(17.0f, context);
        android.content.Context context2 = getContext();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context2, "context");
        float fCoerceAtMost = kotlin.ranges.RangesKt.coerceAtMost(com.up366.photopicker.ui.crop.CropOverlayViewKt.dpToPx(10.0f, context2), fDpToPx);
        drawRoundedRectCorner(canvas, this.cropRect.left, this.cropRect.top, 1.0f, 1.0f, fDpToPx, fCoerceAtMost);
        drawRoundedRectCorner(canvas, this.cropRect.right, this.cropRect.top, -1.0f, 1.0f, fDpToPx, fCoerceAtMost);
        drawRoundedRectCorner(canvas, this.cropRect.left, this.cropRect.bottom, 1.0f, -1.0f, fDpToPx, fCoerceAtMost);
        drawRoundedRectCorner(canvas, this.cropRect.right, this.cropRect.bottom, -1.0f, -1.0f, fDpToPx, fCoerceAtMost);
    }

    private final void drawRoundedRectCorner(android.graphics.Canvas canvas, float cornerX, float cornerY, float horizontalDirection, float verticalDirection, float cornerLength, float cornerRadius) {
        float f = horizontalDirection * cornerRadius;
        android.graphics.RectF rectF = new android.graphics.RectF((f * 2.0f) + cornerX, (cornerRadius * verticalDirection * 2.0f) + cornerY, cornerX, cornerY);
        rectF.sort();
        float f2 = -90.0f;
        float f3 = 270.0f;
        if (horizontalDirection <= 0.0f || verticalDirection <= 0.0f) {
            if (horizontalDirection < 0.0f && verticalDirection > 0.0f) {
                f2 = 90.0f;
            } else if (horizontalDirection <= 0.0f || verticalDirection >= 0.0f) {
                f3 = 90.0f;
            } else {
                f2 = 90.0f;
                f3 = 90.0f;
            }
        }
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo((horizontalDirection * cornerLength) + cornerX, cornerY);
        path.lineTo(f + cornerX, cornerY);
        path.arcTo(rectF, f3, f2, false);
        path.lineTo(cornerX, cornerY + (verticalDirection * cornerLength));
        canvas.drawPath(path, this.paintCorner);
    }

    private final void drawQuadCornerGuide(android.graphics.Canvas canvas, int index) {
        android.graphics.PointF[] pointFArr = this.corners;
        android.graphics.PointF pointF = pointFArr[index];
        android.graphics.PointF pointF2 = pointFArr[((pointFArr.length + index) - 1) % pointFArr.length];
        android.graphics.PointF pointF3 = pointFArr[(index + 1) % pointFArr.length];
        drawGuideSegment(canvas, pointF, pointF2);
        drawGuideSegment(canvas, pointF, pointF3);
    }

    private final void drawGuideSegment(android.graphics.Canvas canvas, android.graphics.PointF start, android.graphics.PointF end) {
        float f = end.x - start.x;
        float f2 = end.y - start.y;
        float fHypot = (float) java.lang.Math.hypot(f, f2);
        if (fHypot <= 0.0f) {
            return;
        }
        float fMin = java.lang.Math.min(this.quadCornerGuideLength, fHypot) / fHypot;
        canvas.drawLine(start.x, start.y, start.x + (f * fMin), start.y + (f2 * fMin), this.paintCorner);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent event) {
        kotlin.jvm.functions.Function1<? super com.up366.photopicker.ui.crop.CropOverlayView.Mode, kotlin.Unit> function1;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            this.lastX = event.getX();
            this.lastY = event.getY();
            this.interactionChanged = false;
            com.up366.photopicker.ui.crop.CropOverlayView.Mode touchMode = getTouchMode(event.getX(), event.getY());
            this.mode = touchMode;
            if (isCornerResizeMode(touchMode)) {
                emitCornerDragPreview(true);
            } else {
                kotlin.jvm.functions.Function3<? super java.lang.Boolean, ? super java.lang.Float, ? super java.lang.Float, kotlin.Unit> function3 = this.onCornerDragPreviewChanged;
                if (function3 != null) {
                    function3.invoke(false, java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(0.0f));
                }
            }
            return this.mode != com.up366.photopicker.ui.crop.CropOverlayView.Mode.NONE;
        }
        if (action == 1) {
            kotlin.jvm.functions.Function3<? super java.lang.Boolean, ? super java.lang.Float, ? super java.lang.Float, kotlin.Unit> function32 = this.onCornerDragPreviewChanged;
            if (function32 != null) {
                function32.invoke(false, java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(0.0f));
            }
            com.up366.photopicker.ui.crop.CropOverlayView.Mode mode = this.mode;
            this.mode = com.up366.photopicker.ui.crop.CropOverlayView.Mode.NONE;
            if (this.draggingType == 1) {
                android.graphics.PointF[] pointFArr = this.corners;
                if (pointFArr.length == 0) {
                    throw new java.util.NoSuchElementException();
                }
                float fMin = pointFArr[0].x;
                kotlin.collections.IntIterator it = new kotlin.ranges.IntRange(1, kotlin.collections.ArraysKt.getLastIndex(pointFArr)).iterator();
                while (it.hasNext()) {
                    fMin = java.lang.Math.min(fMin, pointFArr[it.nextInt()].x);
                }
                android.graphics.PointF[] pointFArr2 = this.corners;
                if (pointFArr2.length == 0) {
                    throw new java.util.NoSuchElementException();
                }
                float fMin2 = pointFArr2[0].y;
                kotlin.collections.IntIterator it2 = new kotlin.ranges.IntRange(1, kotlin.collections.ArraysKt.getLastIndex(pointFArr2)).iterator();
                while (it2.hasNext()) {
                    fMin2 = java.lang.Math.min(fMin2, pointFArr2[it2.nextInt()].y);
                }
                android.graphics.PointF[] pointFArr3 = this.corners;
                if (pointFArr3.length == 0) {
                    throw new java.util.NoSuchElementException();
                }
                float fMax = pointFArr3[0].x;
                kotlin.collections.IntIterator it3 = new kotlin.ranges.IntRange(1, kotlin.collections.ArraysKt.getLastIndex(pointFArr3)).iterator();
                while (it3.hasNext()) {
                    fMax = java.lang.Math.max(fMax, pointFArr3[it3.nextInt()].x);
                }
                android.graphics.PointF[] pointFArr4 = this.corners;
                if (pointFArr4.length == 0) {
                    throw new java.util.NoSuchElementException();
                }
                float fMax2 = pointFArr4[0].y;
                kotlin.collections.IntIterator it4 = new kotlin.ranges.IntRange(1, kotlin.collections.ArraysKt.getLastIndex(pointFArr4)).iterator();
                while (it4.hasNext()) {
                    fMax2 = java.lang.Math.max(fMax2, pointFArr4[it4.nextInt()].y);
                }
                kotlin.jvm.functions.Function1<? super android.graphics.RectF, kotlin.Unit> function12 = this.onCropRectChanged;
                if (function12 != null) {
                    function12.invoke(new android.graphics.RectF(fMin, fMin2, fMax, fMax2));
                }
            } else {
                kotlin.jvm.functions.Function1<? super android.graphics.RectF, kotlin.Unit> function13 = this.onCropRectChanged;
                if (function13 != null) {
                    function13.invoke(this.cropRect);
                }
            }
            if (mode != com.up366.photopicker.ui.crop.CropOverlayView.Mode.NONE && this.interactionChanged && (function1 = this.onInteractionFinished) != null) {
                function1.invoke(mode);
            }
            this.interactionChanged = false;
        } else if (action != 2) {
            if (action == 3) {
                kotlin.jvm.functions.Function3<? super java.lang.Boolean, ? super java.lang.Float, ? super java.lang.Float, kotlin.Unit> function33 = this.onCornerDragPreviewChanged;
                if (function33 != null) {
                    function33.invoke(false, java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(0.0f));
                }
                this.mode = com.up366.photopicker.ui.crop.CropOverlayView.Mode.NONE;
                this.interactionChanged = false;
                if (this.draggingType == 1) {
                    android.graphics.PointF[] pointFArr5 = this.corners;
                    if (pointFArr5.length == 0) {
                        throw new java.util.NoSuchElementException();
                    }
                    float fMin3 = pointFArr5[0].x;
                    kotlin.collections.IntIterator it5 = new kotlin.ranges.IntRange(1, kotlin.collections.ArraysKt.getLastIndex(pointFArr5)).iterator();
                    while (it5.hasNext()) {
                        fMin3 = java.lang.Math.min(fMin3, pointFArr5[it5.nextInt()].x);
                    }
                    android.graphics.PointF[] pointFArr6 = this.corners;
                    if (pointFArr6.length == 0) {
                        throw new java.util.NoSuchElementException();
                    }
                    float fMin4 = pointFArr6[0].y;
                    kotlin.collections.IntIterator it6 = new kotlin.ranges.IntRange(1, kotlin.collections.ArraysKt.getLastIndex(pointFArr6)).iterator();
                    while (it6.hasNext()) {
                        fMin4 = java.lang.Math.min(fMin4, pointFArr6[it6.nextInt()].y);
                    }
                    android.graphics.PointF[] pointFArr7 = this.corners;
                    if (pointFArr7.length == 0) {
                        throw new java.util.NoSuchElementException();
                    }
                    float fMax3 = pointFArr7[0].x;
                    kotlin.collections.IntIterator it7 = new kotlin.ranges.IntRange(1, kotlin.collections.ArraysKt.getLastIndex(pointFArr7)).iterator();
                    while (it7.hasNext()) {
                        fMax3 = java.lang.Math.max(fMax3, pointFArr7[it7.nextInt()].x);
                    }
                    android.graphics.PointF[] pointFArr8 = this.corners;
                    if (pointFArr8.length == 0) {
                        throw new java.util.NoSuchElementException();
                    }
                    float fMax4 = pointFArr8[0].y;
                    kotlin.collections.IntIterator it8 = new kotlin.ranges.IntRange(1, kotlin.collections.ArraysKt.getLastIndex(pointFArr8)).iterator();
                    while (it8.hasNext()) {
                        fMax4 = java.lang.Math.max(fMax4, pointFArr8[it8.nextInt()].y);
                    }
                    kotlin.jvm.functions.Function1<? super android.graphics.RectF, kotlin.Unit> function14 = this.onCropRectChanged;
                    if (function14 != null) {
                        function14.invoke(new android.graphics.RectF(fMin3, fMin4, fMax3, fMax4));
                    }
                } else {
                    kotlin.jvm.functions.Function1<? super android.graphics.RectF, kotlin.Unit> function15 = this.onCropRectChanged;
                    if (function15 != null) {
                        function15.invoke(this.cropRect);
                    }
                }
            }
        } else if (this.mode != com.up366.photopicker.ui.crop.CropOverlayView.Mode.NONE) {
            handleMove(event.getX(), event.getY());
            if (isCornerResizeMode(this.mode)) {
                emitCornerDragPreview(true);
            }
            invalidate();
            return true;
        }
        return super.onTouchEvent(event);
    }

    private final com.up366.photopicker.ui.crop.CropOverlayView.Mode getTouchMode(float x, float y) {
        android.content.Context context = getContext();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context, "context");
        float fDpToPx = com.up366.photopicker.ui.crop.CropOverlayViewKt.dpToPx(20.0f, context);
        float f = this.handleSize * 1.2f;
        if (this.draggingType == 1) {
            if (isNearPoint(x, y, this.corners[0].x, this.corners[0].y, f)) {
                return com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_TL;
            }
            if (isNearPoint(x, y, this.corners[1].x, this.corners[1].y, f)) {
                return com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_TR;
            }
            if (isNearPoint(x, y, this.corners[3].x, this.corners[3].y, f)) {
                return com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_BL;
            }
            if (isNearPoint(x, y, this.corners[2].x, this.corners[2].y, f)) {
                return com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_BR;
            }
        } else {
            if (isNearPoint(x, y, this.cropRect.left, this.cropRect.top, f)) {
                return com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_TL;
            }
            if (isNearPoint(x, y, this.cropRect.right, this.cropRect.top, f)) {
                return com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_TR;
            }
            if (isNearPoint(x, y, this.cropRect.left, this.cropRect.bottom, f)) {
                return com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_BL;
            }
            if (isNearPoint(x, y, this.cropRect.right, this.cropRect.bottom, f)) {
                return com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_BR;
            }
        }
        if (java.lang.Math.abs(x - this.cropRect.left) < fDpToPx && y > this.cropRect.top && y < this.cropRect.bottom) {
            return com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_L;
        }
        if (java.lang.Math.abs(x - this.cropRect.right) < fDpToPx && y > this.cropRect.top && y < this.cropRect.bottom) {
            return com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_R;
        }
        if (java.lang.Math.abs(y - this.cropRect.top) < fDpToPx && x > this.cropRect.left && x < this.cropRect.right) {
            return com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_T;
        }
        if (java.lang.Math.abs(y - this.cropRect.bottom) < fDpToPx && x > this.cropRect.left && x < this.cropRect.right) {
            return com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_B;
        }
        if (this.draggingType == 1) {
            if (pointInPolygon(x, y, this.corners)) {
                return com.up366.photopicker.ui.crop.CropOverlayView.Mode.MOVE_CENTER;
            }
        } else if (x >= this.cropRect.left && x <= this.cropRect.right && y >= this.cropRect.top && y <= this.cropRect.bottom) {
            return com.up366.photopicker.ui.crop.CropOverlayView.Mode.MOVE_CENTER;
        }
        return com.up366.photopicker.ui.crop.CropOverlayView.Mode.NONE;
    }

    private static final float segmentsIntersect$orient(android.graphics.PointF pointF, android.graphics.PointF pointF2, android.graphics.PointF pointF3) {
        return ((pointF2.x - pointF.x) * (pointF3.y - pointF.y)) - ((pointF2.y - pointF.y) * (pointF3.x - pointF.x));
    }

    private final boolean segmentsIntersect(android.graphics.PointF p1, android.graphics.PointF p2, android.graphics.PointF p3, android.graphics.PointF p4) {
        float fSegmentsIntersect$orient = segmentsIntersect$orient(p1, p2, p3);
        float fSegmentsIntersect$orient2 = segmentsIntersect$orient(p1, p2, p4);
        float fSegmentsIntersect$orient3 = segmentsIntersect$orient(p3, p4, p1);
        float fSegmentsIntersect$orient4 = segmentsIntersect$orient(p3, p4, p2);
        if (fSegmentsIntersect$orient == 0.0f && onSegment(p1, p2, p3)) {
            return true;
        }
        if (fSegmentsIntersect$orient2 == 0.0f && onSegment(p1, p2, p4)) {
            return true;
        }
        if (fSegmentsIntersect$orient3 == 0.0f && onSegment(p3, p4, p1)) {
            return true;
        }
        if (fSegmentsIntersect$orient4 == 0.0f && onSegment(p3, p4, p2)) {
            return true;
        }
        if ((fSegmentsIntersect$orient > 0.0f) != (fSegmentsIntersect$orient2 > 0.0f)) {
            if ((fSegmentsIntersect$orient3 > 0.0f) != (fSegmentsIntersect$orient4 > 0.0f)) {
                return true;
            }
        }
        return false;
    }

    private final boolean onSegment(android.graphics.PointF a, android.graphics.PointF b, android.graphics.PointF p) {
        return p.x >= java.lang.Math.min(a.x, b.x) && p.x <= java.lang.Math.max(a.x, b.x) && p.y >= java.lang.Math.min(a.y, b.y) && p.y <= java.lang.Math.max(a.y, b.y);
    }

    private final boolean polygonIsSimple(android.graphics.PointF[] pts) {
        return (segmentsIntersect(pts[0], pts[1], pts[2], pts[3]) || segmentsIntersect(pts[1], pts[2], pts[3], pts[0])) ? false : true;
    }

    private final float polygonArea(android.graphics.PointF[] pts) {
        int length = pts.length;
        float f = 0.0f;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int length2 = i2 % pts.length;
            f += (pts[i].x * pts[length2].y) - (pts[length2].x * pts[i].y);
            i = i2;
        }
        return f / 2.0f;
    }

    private final boolean tryMoveCorner(int index, float newX, float newY) {
        float fCoerceIn = kotlin.ranges.RangesKt.coerceIn(newX, this.imageRect.left, this.imageRect.right);
        float fCoerceIn2 = kotlin.ranges.RangesKt.coerceIn(newY, this.imageRect.top, this.imageRect.bottom);
        int i = (index + 3) % 4;
        int i2 = (index + 1) % 4;
        android.graphics.PointF[] pointFArr = new android.graphics.PointF[4];
        for (int i3 = 0; i3 < 4; i3++) {
            pointFArr[i3] = new android.graphics.PointF(this.corners[i3].x, this.corners[i3].y);
        }
        pointFArr[index].set(fCoerceIn, fCoerceIn2);
        if (tryMoveCorner$dist(pointFArr[index], pointFArr[i]) < this.minCropSize || tryMoveCorner$dist(pointFArr[index], pointFArr[i2]) < this.minCropSize || !polygonIsSimple(pointFArr) || polygonArea(pointFArr) <= 0.0f || !isConvex(pointFArr)) {
            return false;
        }
        this.corners[index].set(fCoerceIn, fCoerceIn2);
        return true;
    }

    private static final float tryMoveCorner$dist(android.graphics.PointF pointF, android.graphics.PointF pointF2) {
        return (float) java.lang.Math.hypot(pointF.x - pointF2.x, pointF.y - pointF2.y);
    }

    private final boolean isConvex(android.graphics.PointF[] pts) {
        int length = pts.length;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (i < length) {
            android.graphics.PointF pointF = pts[i];
            int i2 = i + 1;
            android.graphics.PointF pointF2 = pts[i2 % length];
            android.graphics.PointF pointF3 = pts[(i + 2) % length];
            float f = ((pointF2.x - pointF.x) * (pointF3.y - pointF2.y)) - ((pointF2.y - pointF.y) * (pointF3.x - pointF2.x));
            if (f > 0.0f) {
                z = true;
            }
            if (f < 0.0f) {
                z2 = true;
            }
            if (z && z2) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    private final void handleMove(float x, float y) {
        android.graphics.RectF rectF = new android.graphics.RectF(this.cropRect);
        android.graphics.PointF[] pointFArr = new android.graphics.PointF[4];
        boolean z = false;
        for (int i = 0; i < 4; i++) {
            pointFArr[i] = new android.graphics.PointF(this.corners[i].x, this.corners[i].y);
        }
        float f = x - this.lastX;
        float f2 = y - this.lastY;
        switch (com.up366.photopicker.ui.crop.CropOverlayView.WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()]) {
            case 1:
                if (this.draggingType == 1) {
                    for (android.graphics.PointF pointF : this.corners) {
                        if (pointF.x + f < this.imageRect.left) {
                            f = this.imageRect.left - pointF.x;
                        }
                        if (pointF.x + f > this.imageRect.right) {
                            f = this.imageRect.right - pointF.x;
                        }
                        if (pointF.y + f2 < this.imageRect.top) {
                            f2 = this.imageRect.top - pointF.y;
                        }
                        if (pointF.y + f2 > this.imageRect.bottom) {
                            f2 = this.imageRect.bottom - pointF.y;
                        }
                    }
                    for (android.graphics.PointF pointF2 : this.corners) {
                        pointF2.offset(f, f2);
                    }
                } else {
                    float fWidth = this.cropRect.width();
                    float fHeight = this.cropRect.height();
                    android.graphics.RectF rectF2 = this.cropRect;
                    rectF2.left = constrain(rectF2.left + f, this.imageRect.left, this.imageRect.right - fWidth);
                    android.graphics.RectF rectF3 = this.cropRect;
                    rectF3.top = constrain(rectF3.top + f2, this.imageRect.top, this.imageRect.bottom - fHeight);
                    android.graphics.RectF rectF4 = this.cropRect;
                    rectF4.right = rectF4.left + fWidth;
                    android.graphics.RectF rectF5 = this.cropRect;
                    rectF5.bottom = rectF5.top + fHeight;
                }
                break;
            case 2:
                if (this.draggingType == 1) {
                    tryMoveCorner(0, this.corners[0].x + f, this.corners[0].y + f2);
                } else {
                    float fConstrain = constrain(this.cropRect.left + f, this.imageRect.left, this.cropRect.right - this.minCropSize);
                    float fConstrain2 = constrain(this.cropRect.top + f2, this.imageRect.top, this.cropRect.bottom - this.minCropSize);
                    this.cropRect.left = fConstrain;
                    this.cropRect.top = fConstrain2;
                }
                break;
            case 3:
                if (this.draggingType == 1) {
                    tryMoveCorner(1, this.corners[1].x + f, this.corners[1].y + f2);
                } else {
                    float fConstrain3 = constrain(this.cropRect.right + f, this.cropRect.left + this.minCropSize, this.imageRect.right);
                    float fConstrain4 = constrain(this.cropRect.top + f2, this.imageRect.top, this.cropRect.bottom - this.minCropSize);
                    this.cropRect.right = fConstrain3;
                    this.cropRect.top = fConstrain4;
                }
                break;
            case 4:
                if (this.draggingType == 1) {
                    tryMoveCorner(3, this.corners[3].x + f, this.corners[3].y + f2);
                } else {
                    float fConstrain5 = constrain(this.cropRect.left + f, this.imageRect.left, this.cropRect.right - this.minCropSize);
                    float fConstrain6 = constrain(this.cropRect.bottom + f2, this.cropRect.top + this.minCropSize, this.imageRect.bottom);
                    this.cropRect.left = fConstrain5;
                    this.cropRect.bottom = fConstrain6;
                }
                break;
            case 5:
                if (this.draggingType == 1) {
                    tryMoveCorner(2, this.corners[2].x + f, this.corners[2].y + f2);
                } else {
                    float fConstrain7 = constrain(this.cropRect.right + f, this.cropRect.left + this.minCropSize, this.imageRect.right);
                    float fConstrain8 = constrain(this.cropRect.bottom + f2, this.cropRect.top + this.minCropSize, this.imageRect.bottom);
                    this.cropRect.right = fConstrain7;
                    this.cropRect.bottom = fConstrain8;
                }
                break;
            case 6:
                this.cropRect.top = constrain(this.cropRect.top + f2, this.imageRect.top, this.cropRect.bottom - this.minCropSize);
                break;
            case 7:
                this.cropRect.bottom = constrain(this.cropRect.bottom + f2, this.cropRect.top + this.minCropSize, this.imageRect.bottom);
                break;
            case 8:
                this.cropRect.left = constrain(this.cropRect.left + f, this.imageRect.left, this.cropRect.right - this.minCropSize);
                break;
            case 9:
                this.cropRect.right = constrain(this.cropRect.right + f, this.cropRect.left + this.minCropSize, this.imageRect.right);
                break;
        }
        this.lastX = x;
        this.lastY = y;
        if (this.draggingType == 1) {
            java.lang.Iterable indices = kotlin.collections.ArraysKt.getIndices(this.corners);
            if (!(indices instanceof java.util.Collection) || !((java.util.Collection) indices).isEmpty()) {
                kotlin.collections.IntIterator it = indices.iterator();
                while (it.hasNext()) {
                    int iNextInt = it.nextInt();
                    if (!samePoint(pointFArr[iNextInt], this.corners[iNextInt])) {
                        z = true;
                    }
                }
            }
        } else if (!sameRect(rectF, this.cropRect)) {
            z = true;
        }
        if (z && !this.hasUserAdjustedCrop) {
            this.hasUserAdjustedCrop = true;
            kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> function1 = this.onUserAdjustedCropChanged;
            if (function1 != null) {
                function1.invoke(true);
            }
        }
        if (z) {
            this.interactionChanged = true;
        }
    }

    private final float constrain(float value, float min, float max) {
        return java.lang.Math.min(java.lang.Math.max(value, min), max);
    }

    private final boolean isCornerResizeMode(com.up366.photopicker.ui.crop.CropOverlayView.Mode mode) {
        return mode == com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_TL || mode == com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_TR || mode == com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_BL || mode == com.up366.photopicker.ui.crop.CropOverlayView.Mode.RESIZE_BR;
    }

    private final void emitCornerDragPreview(boolean visible) {
        android.graphics.PointF pointF;
        java.lang.Float fValueOf = java.lang.Float.valueOf(0.0f);
        if (!visible) {
            kotlin.jvm.functions.Function3<? super java.lang.Boolean, ? super java.lang.Float, ? super java.lang.Float, kotlin.Unit> function3 = this.onCornerDragPreviewChanged;
            if (function3 != null) {
                function3.invoke(false, fValueOf, fValueOf);
                return;
            }
            return;
        }
        int i = com.up366.photopicker.ui.crop.CropOverlayView.WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i == 2) {
            pointF = this.draggingType == 1 ? this.corners[0] : new android.graphics.PointF(this.cropRect.left, this.cropRect.top);
        } else if (i == 3) {
            pointF = this.draggingType == 1 ? this.corners[1] : new android.graphics.PointF(this.cropRect.right, this.cropRect.top);
        } else if (i == 4) {
            pointF = this.draggingType == 1 ? this.corners[3] : new android.graphics.PointF(this.cropRect.left, this.cropRect.bottom);
        } else if (i != 5) {
            pointF = null;
        } else {
            pointF = this.draggingType == 1 ? this.corners[2] : new android.graphics.PointF(this.cropRect.right, this.cropRect.bottom);
        }
        if (pointF != null) {
            kotlin.jvm.functions.Function3<? super java.lang.Boolean, ? super java.lang.Float, ? super java.lang.Float, kotlin.Unit> function32 = this.onCornerDragPreviewChanged;
            if (function32 != null) {
                function32.invoke(true, java.lang.Float.valueOf(pointF.x), java.lang.Float.valueOf(pointF.y));
                return;
            }
            return;
        }
        kotlin.jvm.functions.Function3<? super java.lang.Boolean, ? super java.lang.Float, ? super java.lang.Float, kotlin.Unit> function33 = this.onCornerDragPreviewChanged;
        if (function33 != null) {
            function33.invoke(false, fValueOf, fValueOf);
        }
    }

    public final void setImageRect(android.graphics.RectF rect) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rect, "rect");
        this.imageRect.set(rect);
        this.hasUserAdjustedCrop = false;
        float fWidth = this.imageRect.left + (this.rectPaddingLeft * this.imageRect.width());
        float fHeight = this.imageRect.top + (this.rectPaddingTop * this.imageRect.height());
        float fWidth2 = this.imageRect.right - (this.rectPaddingRight * this.imageRect.width());
        float fHeight2 = this.imageRect.bottom - (this.rectPaddingBottom * this.imageRect.height());
        float f = this.minCropSize;
        if (fWidth2 - fWidth < f) {
            float f2 = (fWidth + fWidth2) / 2.0f;
            float f3 = f / 2.0f;
            float f4 = f2 - f3;
            fWidth2 = f3 + f2;
            fWidth = f4;
        }
        if (fHeight2 - fHeight < f) {
            float f5 = (fHeight + fHeight2) / 2.0f;
            float f6 = f / 2.0f;
            float f7 = f5 - f6;
            fHeight2 = f6 + f5;
            fHeight = f7;
        }
        float fConstrain = constrain(fWidth, this.imageRect.left, this.imageRect.right - f);
        float fConstrain2 = constrain(fHeight, this.imageRect.top, this.imageRect.bottom - f);
        this.cropRect.set(fConstrain, fConstrain2, constrain(fWidth2, fConstrain + f, this.imageRect.right), constrain(fHeight2, f + fConstrain2, this.imageRect.bottom));
        this.corners[0].set(this.cropRect.left, this.cropRect.top);
        this.corners[1].set(this.cropRect.right, this.cropRect.top);
        this.corners[2].set(this.cropRect.right, this.cropRect.bottom);
        this.corners[3].set(this.cropRect.left, this.cropRect.bottom);
        invalidate();
    }

    public final void setRectPadding(float top, float bottom, float left, float right) {
        this.rectPaddingTop = top;
        this.rectPaddingBottom = bottom;
        this.rectPaddingLeft = left;
        this.rectPaddingRight = right;
    }

    public final void setDraggingType(int type) {
        this.draggingType = type;
        if (type == 1) {
            this.corners[0].set(this.cropRect.left, this.cropRect.top);
            this.corners[1].set(this.cropRect.right, this.cropRect.top);
            this.corners[2].set(this.cropRect.right, this.cropRect.bottom);
            this.corners[3].set(this.cropRect.left, this.cropRect.bottom);
        }
        invalidate();
    }

    private final boolean pointInPolygon(float x, float y, android.graphics.PointF[] pts) {
        int length = pts.length - 1;
        boolean z = false;
        for (int i = 0; i < pts.length; i++) {
            if ((pts[i].y > y) != (pts[length].y > y) && x < (((pts[length].x - pts[i].x) * (y - pts[i].y)) / (pts[length].y - pts[i].y)) + pts[i].x) {
                z = !z;
            }
            length = i;
        }
        return z;
    }

    private final boolean sameRect(android.graphics.RectF first, android.graphics.RectF second) {
        return java.lang.Math.abs(first.left - second.left) < 0.5f && java.lang.Math.abs(first.top - second.top) < 0.5f && java.lang.Math.abs(first.right - second.right) < 0.5f && java.lang.Math.abs(first.bottom - second.bottom) < 0.5f;
    }

    private final boolean samePoint(android.graphics.PointF first, android.graphics.PointF second) {
        return java.lang.Math.abs(first.x - second.x) < 0.5f && java.lang.Math.abs(first.y - second.y) < 0.5f;
    }
}
