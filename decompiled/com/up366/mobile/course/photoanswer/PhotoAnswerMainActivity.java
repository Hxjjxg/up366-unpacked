package com.up366.mobile.course.photoanswer;

/* JADX INFO: compiled from: PhotoAnswerMainActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0083\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0083\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0014J\b\u00107\u001a\u000204H\u0002J\b\u00108\u001a\u000204H\u0014J\b\u00109\u001a\u000204H\u0014J\b\u0010:\u001a\u000204H\u0014J\b\u0010;\u001a\u000204H\u0014J\b\u0010<\u001a\u000204H\u0002J\b\u0010=\u001a\u000204H\u0002J\u0016\u0010>\u001a\u0002042\f\u0010?\u001a\b\u0012\u0004\u0012\u0002040@H\u0002J\b\u0010A\u001a\u000204H\u0017J\b\u0010B\u001a\u000204H\u0014J\b\u0010C\u001a\u00020DH\u0002J\u0018\u0010E\u001a\u0002042\u0006\u0010F\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u0002042\u0006\u0010J\u001a\u00020\rH\u0002J\u0010\u0010L\u001a\u0002042\u0006\u0010M\u001a\u00020NH\u0016J$\u0010O\u001a\u0002042\b\b\u0002\u0010K\u001a\u00020\u000f2\b\u0010P\u001a\u0004\u0018\u00010\r2\b\u0010Q\u001a\u0004\u0018\u00010RJ\u0006\u0010S\u001a\u000204J\u0010\u0010T\u001a\u0002042\u0006\u0010U\u001a\u00020\u000fH\u0002J\u0010\u0010G\u001a\u0002042\u0006\u0010G\u001a\u00020HH\u0016J\u001a\u0010V\u001a\u0002042\u0006\u0010W\u001a\u00020\r2\b\b\u0002\u0010X\u001a\u00020\rH\u0002J\u0018\u0010Y\u001a\u0002042\u0006\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\\H\u0016J\b\u0010]\u001a\u000204H\u0016J\u000e\u0010^\u001a\u0002042\u0006\u0010_\u001a\u00020\\J\u0006\u0010`\u001a\u000204J\b\u0010a\u001a\u000204H\u0002J\u0006\u0010b\u001a\u000204J\b\u0010c\u001a\u000204H\u0002J\b\u0010d\u001a\u000204H\u0002J\u0010\u0010e\u001a\u0002042\u0006\u0010f\u001a\u00020gH\u0016J\b\u0010h\u001a\u000204H\u0002J\u0006\u0010i\u001a\u000204J\u0006\u0010j\u001a\u000204J\u000e\u0010k\u001a\u0002042\u0006\u0010Q\u001a\u00020RJ\u0016\u0010l\u001a\u0002042\u0006\u0010m\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020RJ\u000e\u0010n\u001a\u0002042\u0006\u0010Q\u001a\u00020RJ\u000e\u0010o\u001a\u00020D2\u0006\u0010Q\u001a\u00020RJ\b\u0010p\u001a\u000204H\u0002J\b\u0010q\u001a\u000204H\u0002J(\u0010r\u001a\u0002042\u0006\u0010s\u001a\u00020t2\u0006\u0010m\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020R2\b\b\u0002\u0010u\u001a\u00020\rJ\u000e\u0010v\u001a\u0002042\u0006\u0010_\u001a\u00020\\J\u0010\u0010w\u001a\u0002042\u0006\u0010x\u001a\u00020DH\u0016J\u0012\u0010y\u001a\u0002042\b\u0010z\u001a\u0004\u0018\u00010{H\u0007J\u0012\u0010y\u001a\u0002042\b\u0010z\u001a\u0004\u0018\u00010|H\u0007J\u0010\u0010y\u001a\u0002042\u0006\u0010z\u001a\u00020~H\u0007J\b\u0010\u007f\u001a\u000204H\u0002J\t\u0010\u0080\u0001\u001a\u000204H\u0002J\u0012\u0010y\u001a\u0002042\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010(\u001a\u0004\b0\u00101R\u000e\u0010K\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020DX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0084\u0001"}, d2 = {"Lcom/up366/mobile/course/photoanswer/PhotoAnswerMainActivity;", "Lcom/up366/mobile/course/photoanswer/BasePhotoAnswerMainActivity;", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController$CameraControllerCallback;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "binding", "Lcom/up366/mobile/databinding/PhotoAnswerMainActivityBinding;", "getBinding", "()Lcom/up366/mobile/databinding/PhotoAnswerMainActivityBinding;", "setBinding", "(Lcom/up366/mobile/databinding/PhotoAnswerMainActivityBinding;)V", "staticKey", "", "submitErrorTipCount", "", "repeatTipTxt", "startCountTime", "", "fromType", "detectLib", "Lcom/up366/papercut/DetectLib;", "resultDispatcher", "Lcom/up366/mobile/course/photoanswer/result/ScanResultDispatcher;", "resultContext", "Lcom/up366/mobile/course/photoanswer/result/ScanResultContext;", "lastShowNoAnswerSheetTime", "tipTxtViewModel", "Lcom/up366/mobile/course/photoanswer/viewmodel/TipTxtViewModel;", "scanSession", "Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;", "logic", "Lcom/up366/mobile/course/photoanswer/logic/PhotoAnswerLogic;", "cameraController", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController;", "imageShowHelper", "Lcom/up366/mobile/course/photoanswer/logic/helper/PhotoAnswerImageShowHelper;", "getImageShowHelper", "()Lcom/up366/mobile/course/photoanswer/logic/helper/PhotoAnswerImageShowHelper;", "imageShowHelper$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/up366/mobile/course/photoanswer/adpter/PhotoAnswerImageListAdapter;", "getAdapter", "()Lcom/up366/mobile/course/photoanswer/adpter/PhotoAnswerImageListAdapter;", "adapter$delegate", "scanShowAmin", "Landroid/view/animation/ScaleAnimation;", "getScanShowAmin", "()Landroid/view/animation/ScaleAnimation;", "scanShowAmin$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initData", "onResume", "onStart", "onStop", "onPause", "initViewModel", "initView", "addAnimStart", "callback", "Lkotlin/Function0;", "onBackPressed", "onDestroy", "isActivityUsable", "", "showBorderView", "edgeResult", "analyzeResult", "Lcom/up366/mobile/course/p1p/PaperRecognitionResult;", "scanOnePage", "filepath", "checkFindConnerErrorCount", "onTakePhotoCallback", "pageData", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/PhotoCorrectImageData;", "showNoSheetDialog", "filePath", "scanOnePageResult", "Lcom/up366/mobile/course/photoanswer/logic/model/ScanOnePageResult;", "showOldAnswerSheetDialog", "handleOldAnswerSheetCallback", "code", "showAnalysisUi", "cropImagePath", "realPath", "onPageSelectedShow", "position", com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE, "Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerImageInfo;", "closePageImageShow", "promptPageRepeat", "imageInfo", "handleSubmitTask", "handleSubmitTaskV1", "skipOnlineAnswer", "updateImageStatus", "showSubmitUploading", "onClick", "view", "Landroid/view/View;", "openAlum", "showLoadingView", "hideLoadingView", "retryFetch", "showCommonError", "errorCount", "handleResult", "scanOnePageResultOk", "showTakeNextTip", "showSubmitDialog", "showDialogByType", "dialogType", "Lcom/up366/mobile/course/photoanswer/dialog/DialogType;", "title", "addImageAndShow", "setActivityIsShowing", "isShowing", "onMessageEvent", "event", "Lcom/up366/mobile/common/event/OpenAlumEvent;", "Lcom/up366/mobile/common/event/StartAnalyzeEvent;", "uploadSuccess", "Lcom/up366/mobile/common/event/CommonUploadLogEvent;", "showErrorDialog", "showSuccessPage", "switchHandEvent", "Lcom/up366/mobile/common/event/SwitchHandCheckEvent;", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerMainActivity extends com.up366.mobile.course.photoanswer.BasePhotoAnswerMainActivity implements com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController.CameraControllerCallback, android.view.View.OnClickListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.Companion INSTANCE = new com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.Companion(null);
    public static final java.lang.String FROM_TYPE_MG_BOOK_PRACTICE_ = "_MG_BOOK_PRACTICE_";
    public static final java.lang.String FROM_TYPE_SCAN_PAPER_GENERAL = "SCAN_PAPER_GENERAL";
    public static final java.lang.String FROM_TYPE_TASK_INFO = "TASK_INFO";
    public static final java.lang.String KEY_INTENT_DATA = "key_data";
    public static final java.lang.String KEY_INTENT_FROM_TYPE = "key_from_type";

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy adapter;
    public com.up366.mobile.databinding.PhotoAnswerMainActivityBinding binding;
    private final com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController cameraController;
    private int checkFindConnerErrorCount;

    /* JADX INFO: renamed from: imageShowHelper$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy imageShowHelper;
    private long lastShowNoAnswerSheetTime;
    private final com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic logic;
    private com.up366.mobile.course.photoanswer.result.ScanResultContext resultContext;
    private com.up366.mobile.course.photoanswer.result.ScanResultDispatcher resultDispatcher;
    private final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session scanSession;

    /* JADX INFO: renamed from: scanShowAmin$delegate, reason: from kotlin metadata */
    private final kotlin.Lazy scanShowAmin;
    private long startCountTime;
    private int submitErrorTipCount;
    private com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel;
    private boolean uploadSuccess;
    private java.lang.String staticKey = "";
    private java.lang.String repeatTipTxt = "";
    private java.lang.String fromType = "";
    private final com.up366.papercut.DetectLib detectLib = new com.up366.papercut.DetectLib();

    /* JADX INFO: compiled from: PhotoAnswerMainActivity.kt */
    @kotlin.Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.values().length];
            try {
                iArr[com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.NO_ANSWER_SHEET.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.TAKE_PHOTO_SUCCESS_TO_NEXT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.WAIT_TAKE_PHOTO.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                iArr[com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.PHOTO_OUT_SCREEN.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                iArr[com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.PHOTO_TOO_SMALL.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                iArr[com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.PHOTO_UPDATE_PAPER.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                iArr[com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.SUBMIT_AFTER_TAKE_PHOTO.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                iArr[com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.HAND_IN_IMAGE.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                iArr[com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.HAND_TAKE_PHOTO.ordinal()] = 9;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                iArr[com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.PAGE_REPEATED.ordinal()] = 10;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                iArr[com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.IS_NOT_RECTANGLE.ordinal()] = 11;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @kotlin.jvm.JvmStatic
    public static final void startActivity(android.content.Context context, java.lang.String str, java.lang.String str2) {
        INSTANCE.startActivity(context, str, str2);
    }

    public PhotoAnswerMainActivity() {
        com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session sessionCreateSession = com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.createSession();
        this.scanSession = sessionCreateSession;
        this.logic = new com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic(sessionCreateSession);
        this.cameraController = new com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController(sessionCreateSession);
        this.imageShowHelper = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda17
            public final java.lang.Object invoke() {
                return com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.imageShowHelper_delegate$lambda$0(this.f$0);
            }
        });
        this.adapter = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda18
            public final java.lang.Object invoke() {
                return com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.adapter_delegate$lambda$1(this.f$0);
            }
        });
        this.scanShowAmin = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda19
            public final java.lang.Object invoke() {
                return com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.scanShowAmin_delegate$lambda$2();
            }
        });
    }

    public final com.up366.mobile.databinding.PhotoAnswerMainActivityBinding getBinding() {
        com.up366.mobile.databinding.PhotoAnswerMainActivityBinding photoAnswerMainActivityBinding = this.binding;
        if (photoAnswerMainActivityBinding != null) {
            return photoAnswerMainActivityBinding;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(com.up366.mobile.databinding.PhotoAnswerMainActivityBinding photoAnswerMainActivityBinding) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(photoAnswerMainActivityBinding, "<set-?>");
        this.binding = photoAnswerMainActivityBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper getImageShowHelper() {
        return (com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper) this.imageShowHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper imageShowHelper_delegate$lambda$0(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        return new com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper(photoAnswerMainActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter getAdapter() {
        return (com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter adapter_delegate$lambda$1(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        androidx.recyclerview.widget.RecyclerView recyclerView = photoAnswerMainActivity.getBinding().rvPageList;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(recyclerView, "rvPageList");
        return new com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter(arrayList, recyclerView);
    }

    private final android.view.animation.ScaleAnimation getScanShowAmin() {
        return (android.view.animation.ScaleAnimation) this.scanShowAmin.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final android.view.animation.ScaleAnimation scanShowAmin_delegate$lambda$2() {
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(250L);
        return scaleAnimation;
    }

    /* JADX INFO: compiled from: PhotoAnswerMainActivity.kt */
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/up366/mobile/course/photoanswer/PhotoAnswerMainActivity$Companion;", "", "<init>", "()V", "KEY_INTENT_DATA", "", "KEY_INTENT_FROM_TYPE", "FROM_TYPE_SCAN_PAPER_GENERAL", "FROM_TYPE_MG_BOOK_PRACTICE_", "FROM_TYPE_TASK_INFO", "startActivity", "", "context", "Landroid/content/Context;", "taskInfoString", "fromType", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final void startActivity(android.content.Context context, java.lang.String taskInfoString, java.lang.String fromType) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(taskInfoString, "taskInfoString");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fromType, "fromType");
            android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.class);
            intent.putExtra(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.KEY_INTENT_DATA, taskInfoString);
            intent.putExtra(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.KEY_INTENT_FROM_TYPE, fromType);
            context.startActivity(intent);
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBinding(com.up366.mobile.databinding.PhotoAnswerMainActivityBinding.inflate(getLayoutInflater()));
        this.staticKey = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        setContentView((android.view.View) getBinding().getRoot());
        new com.up366.mobile.course.p1p.helper.RecursiveFileCleanupHelper().cleanupInBack(com.up366.mobile.course.p1p.P1pPathHelper.INSTANCE.getTaskWorkPathRoot(), 90);
        initData();
        this.resultContext = new com.up366.mobile.course.photoanswer.result.ScanResultContext(this, this.logic, this.cameraController, getAdapter());
        com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext = this.resultContext;
        if (scanResultContext == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("resultContext");
            scanResultContext = null;
        }
        this.resultDispatcher = new com.up366.mobile.course.photoanswer.result.ScanResultDispatcher(scanResultContext);
        android.app.Activity activity = (android.app.Activity) this;
        com.up366.qmui.util.QMUIStatusBarHelper.translucent(activity);
        com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarDarkMode(activity);
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading(activity, "加载中");
        getBinding().ivReadyTips.setVisibility(8);
        getBinding().tvStart.setVisibility(8);
        com.up366.common.EventBusUtilsUp.register(this);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda23
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.onCreate$lambda$4(this.f$0);
            }
        });
        initViewModel();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        com.up366.asecengine.englishengine.AsecEngineHelper.create(com.up366.common.global.GB.get().getApplicationContext());
        final boolean zLoadModel = photoAnswerMainActivity.detectLib.loadModel(photoAnswerMainActivity.getAssets());
        final int iInitScan = com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.initScan(photoAnswerMainActivity.scanSession, photoAnswerMainActivity.logic.getCacheHelper().getStudyTaskId());
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda24
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.onCreate$lambda$4$lambda$3(this.f$0, iInitScan, zLoadModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onCreate$lambda$4$lambda$3(final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, int i, boolean z) {
        if (!photoAnswerMainActivity.isActivityUsable() || photoAnswerMainActivity.scanSession.isClosed() || i == -10001) {
            return;
        }
        android.app.Activity activity = (android.app.Activity) photoAnswerMainActivity;
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss(activity);
        if (!z || i != 0) {
            com.up366.common.log.Logger.error("initScanEngineError retInit:" + z + " initStatus:" + i);
            com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.showDialog$default(com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE, activity, com.up366.mobile.course.photoanswer.dialog.DialogType.INIT_SCAN_ENGINE_ERROR, new com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$onCreate$1$1$1
                @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
                public void onCallback(int code, java.lang.Object info) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
                    this.this$0.finish();
                }
            }, null, 8, null);
            return;
        }
        photoAnswerMainActivity.getBinding().ivReadyTips.setVisibility(0);
        photoAnswerMainActivity.getBinding().tvStart.setVisibility(0);
    }

    private final void initData() {
        this.fromType = java.lang.String.valueOf(getIntent().getStringExtra(KEY_INTENT_FROM_TYPE));
        java.lang.String stringExtra = getIntent().getStringExtra(KEY_INTENT_DATA);
        if (kotlin.jvm.internal.Intrinsics.areEqual(FROM_TYPE_SCAN_PAPER_GENERAL, this.fromType)) {
            com.up366.mobile.course.photoanswer.model.ScanPaperModel scanPaperModel = (com.up366.mobile.course.photoanswer.model.ScanPaperModel) com.alibaba.fastjson.JSON.parseObject(stringExtra, com.up366.mobile.course.photoanswer.model.ScanPaperModel.class);
            com.up366.mobile.course.answersheet.AnswerSheetCacheHelper cacheHelper = this.logic.getCacheHelper();
            kotlin.jvm.internal.Intrinsics.checkNotNull(scanPaperModel);
            cacheHelper.setData(scanPaperModel).setCurWebViewId(scanPaperModel.getCurWebViewId());
            com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.setScanPaperGeneral(true);
            com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.setGeneralScanPaper(true);
            return;
        }
        com.up366.mobile.course.task.TaskInfoV2 taskInfoV2 = (com.up366.mobile.course.task.TaskInfoV2) com.alibaba.fastjson.JSON.parseObject(stringExtra, com.up366.mobile.course.task.TaskInfoV2.class);
        java.util.Map jSONObject = new com.alibaba.fastjson.JSONObject();
        java.util.Map map = jSONObject;
        map.put("studytaskid", taskInfoV2.getJobId());
        map.put("taskid", taskInfoV2.getContentId());
        map.put("bookid", taskInfoV2.getExtParam().getBookId());
        map.put("courseid", java.lang.Integer.valueOf(taskInfoV2.getCourseId()));
        com.up366.mobile.common.onlinelog.OpLog.report(com.up366.mobile.common.onlinelog.OpLogData.Page.SMART_PAPER, com.up366.mobile.common.onlinelog.OpLogData.Control.PHOTO_TASK, com.up366.mobile.common.onlinelog.OpLogData.Event.ENTER_PAGE, (com.alibaba.fastjson.JSONObject) jSONObject);
        com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.fetchP1pConfig(taskInfoV2);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.setGeneralScanPaper(false);
        com.up366.mobile.course.answersheet.AnswerSheetCacheHelper cacheHelper2 = this.logic.getCacheHelper();
        kotlin.jvm.internal.Intrinsics.checkNotNull(taskInfoV2);
        cacheHelper2.setData(taskInfoV2);
        com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.Companion companion = com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE;
        java.lang.String jobId = taskInfoV2.getJobId();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jobId, "getJobId(...)");
        companion.onCreate(jobId);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        this.cameraController.setActivityIsShowing(true);
        com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.onResume(this.staticKey);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onStart() {
        super.onStart();
        this.cameraController.setActiveCamera(true);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onStop() {
        super.onStop();
        this.cameraController.setActiveCamera(false);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onPause() {
        this.cameraController.setActivityIsShowing(false);
        super.onPause();
        com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.onPause(this.staticKey);
    }

    private final void initViewModel() {
        com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel = (com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel) new androidx.lifecycle.ViewModelProvider((androidx.lifecycle.ViewModelStoreOwner) this).get(com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel.class);
        this.tipTxtViewModel = tipTxtViewModel;
        if (tipTxtViewModel == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            tipTxtViewModel = null;
        }
        tipTxtViewModel.getStatus().observe((androidx.lifecycle.LifecycleOwner) this, new com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$sam$androidx_lifecycle_Observer$0(new kotlin.jvm.functions.Function1() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda14
            public final java.lang.Object invoke(java.lang.Object obj) {
                return com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.initViewModel$lambda$5(this.f$0, (com.up366.mobile.course.photoanswer.logic.model.TipTextStatus) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final kotlin.Unit initViewModel$lambda$5(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, com.up366.mobile.course.photoanswer.logic.model.TipTextStatus tipTextStatus) {
        if (com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.GONE == tipTextStatus) {
            photoAnswerMainActivity.getBinding().tipTextLayout.setVisibility(8);
            return kotlin.Unit.INSTANCE;
        }
        photoAnswerMainActivity.getBinding().tipTextLayout.setVisibility(0);
        photoAnswerMainActivity.getBinding().tipTxt.getLayoutParams().width = -2;
        int i = tipTextStatus == null ? -1 : com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.WhenMappings.$EnumSwitchMapping$0[tipTextStatus.ordinal()];
        int i2 = com.up366.mobile.R.drawable.bg_toast_transparent;
        float f = 20.0f;
        java.lang.String str = "";
        switch (i) {
            case 1:
                str = "请将完整的答题卡置于摄像头内!\nA3或者8K答题卡不要对折！";
                f = 16.0f;
                i2 = 2131231014;
                break;
            case 2:
                str = "拍摄成功\n请换下一张";
                break;
            case 3:
                str = "捕捉中...请保持稳定哦～";
                f = 16.0f;
                i2 = 2131231014;
                break;
            case 4:
                str = "离纸远一点";
                f = 16.0f;
                i2 = 2131231014;
                break;
            case 5:
                str = "离纸近一点";
                f = 16.0f;
                i2 = 2131231014;
                break;
            case 6:
                str = "纸张更换中";
                f = 16.0f;
                i2 = 2131231014;
                break;
            case 7:
                str = "请先拍照再提交哦～";
                f = 16.0f;
                i2 = 2131231014;
                break;
            case 8:
                str = "检测到有手遮挡答卷，请移开";
                f = 16.0f;
                i2 = 2131231014;
                break;
            case 9:
                str = "点击下方白色按钮进行手动拍照";
                f = 16.0f;
                i2 = 2131231014;
                break;
            case 10:
                str = photoAnswerMainActivity.repeatTipTxt;
                break;
            case 11:
                i2 = com.up366.mobile.R.drawable.p1p_trapezoid_tip;
                f = 16.0f;
                break;
            default:
                f = 16.0f;
                i2 = 2131231014;
                break;
        }
        photoAnswerMainActivity.getBinding().tipTextLayout.setBackgroundResource(i2);
        photoAnswerMainActivity.getBinding().tipTxt.setTextSize(f);
        android.widget.TextView textView = photoAnswerMainActivity.getBinding().tipTxt;
        byte[] bytes = str.getBytes(kotlin.text.Charsets.UTF_8);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        textView.setText(new java.lang.String(bytes, kotlin.text.Charsets.UTF_8));
        photoAnswerMainActivity.getBinding().tipTextLayout.requestLayout();
        return kotlin.Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        getBinding().alumTv.setVisibility((com.up366.mobile.common.utils.PlatformUtils.isClosePad() || !com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isSupportAlumSelect()) ? 8 : 0);
        com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity = this;
        getBinding().alumTv.setOnClickListener(photoAnswerMainActivity);
        getBinding().btBack.setOnClickListener(photoAnswerMainActivity);
        getBinding().ibGuide.setOnClickListener(photoAnswerMainActivity);
        getBinding().tvSubmit.setOnClickListener(photoAnswerMainActivity);
        getBinding().vScreenMask.setOnClickListener(photoAnswerMainActivity);
        getBinding().tvStart.setOnClickListener(photoAnswerMainActivity);
        getBinding().tvReadyTips.setOnClickListener(photoAnswerMainActivity);
        getBinding().clPhotoResult.setOnClickListener(photoAnswerMainActivity);
        getBinding().clShowPage.setOnClickListener(photoAnswerMainActivity);
        getBinding().takePhotoBtn.setOnClickListener(photoAnswerMainActivity);
        com.up366.common.BitmapUtilsUp.display(getBinding().ivLoading, com.up366.mobile.R.drawable.photo_answer_loading);
        getBinding().title.setText(this.logic.getCacheHelper().getJobName());
        getBinding().title.setMaxWidth(com.up366.common.DpUtilsUp.dp2px(100.0f));
        getBinding().previewView1.post(new java.lang.Runnable() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.initView$lambda$6(this.f$0);
            }
        });
        androidx.recyclerview.widget.RecyclerView.ItemAnimator itemAnimator = getBinding().rvPageList.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(250L);
            itemAnimator.setRemoveDuration(250L);
        }
        getBinding().rvPageList.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager((android.content.Context) this, 0, false));
        getBinding().rvPageList.setAdapter(getAdapter());
        getAdapter().setItemListener(new kotlin.jvm.functions.Function2() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda10
            public final java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.initView$lambda$9(this.f$0, ((java.lang.Integer) obj).intValue(), (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController cameraController = photoAnswerMainActivity.cameraController;
        androidx.camera.view.PreviewView previewView = photoAnswerMainActivity.getBinding().previewView;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(previewView, "previewView");
        android.view.TextureView textureView = photoAnswerMainActivity.getBinding().previewView1;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(textureView, "previewView1");
        cameraController.init(previewView, textureView, photoAnswerMainActivity.detectLib, photoAnswerMainActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit initView$lambda$9(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, int i, com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(photoAnswerImageInfo, com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE);
        photoAnswerMainActivity.cameraController.stopAnalyze();
        photoAnswerMainActivity.getImageShowHelper().showPageImage(i, photoAnswerMainActivity.getAdapter().getPages());
        return kotlin.Unit.INSTANCE;
    }

    private final void addAnimStart(final kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
        getBinding().ivPhotoResultBg.setBackgroundColor(0);
        androidx.transition.Transition duration = new androidx.transition.ChangeBounds().setDuration(400L);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(duration, "setDuration(...)");
        duration.addListener(new androidx.transition.TransitionListenerAdapter() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.addAnimStart.1
            public void onTransitionEnd(androidx.transition.Transition transition) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transition, "transition");
                androidx.transition.TransitionManager.endTransitions(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.getBinding().clRoot);
                com.up366.mobile.common.utils.ViewUtil.gone(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.getBinding().clPhotoResult);
                androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.getBinding().clPhotoResult.getLayoutParams();
                kotlin.jvm.internal.Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
                layoutParams2.topToTop = 0;
                layoutParams2.bottomToBottom = 0;
                layoutParams2.startToStart = 0;
                layoutParams2.endToEnd = 0;
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.getBinding().ivPhotoResultBg.setBackgroundResource(com.up366.mobile.R.drawable.p1p_scan_image_bg);
                callback.invoke();
            }
        });
        androidx.transition.TransitionManager.beginDelayedTransition(getBinding().clRoot, duration);
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = getBinding().clPhotoResult.getLayoutParams();
        kotlin.jvm.internal.Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
        layoutParams2.topToTop = com.up366.mobile.R.id.v_anim;
        layoutParams2.bottomToBottom = com.up366.mobile.R.id.v_anim;
        layoutParams2.startToStart = com.up366.mobile.R.id.v_anim;
        layoutParams2.endToEnd = com.up366.mobile.R.id.v_anim;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        if (getBinding().clPhotoResult.getVisibility() == 0) {
            return;
        }
        if (getImageShowHelper().isShowing()) {
            getImageShowHelper().retractShowView(true);
            return;
        }
        if (getAdapter().getPages().size() > 0) {
            this.cameraController.stopAnalyze();
            com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel = this.tipTxtViewModel;
            if (tipTxtViewModel == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
                tipTxtViewModel = null;
            }
            tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.GONE);
            getBinding().borderView.clear();
            if (kotlin.jvm.internal.Intrinsics.areEqual(this.fromType, FROM_TYPE_SCAN_PAPER_GENERAL)) {
                com.up366.common.log.Logger.info("FROM_TYPE_SCAN_PAPER_GENERAL exit");
                finish();
                return;
            } else {
                com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.showDialog$default(com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE, (android.app.Activity) this, com.up366.mobile.course.photoanswer.dialog.DialogType.EXIT_ACTIVITY_DIALOG, new com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.onBackPressed.1
                    @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
                    public void onCallback(int code, java.lang.Object info) {
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
                        if (code == 0) {
                            com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("exitP1p", ""));
                            com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.finish();
                        } else {
                            com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("exitP1pCancel", ""));
                            com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.cameraController.startAnalyze();
                        }
                    }
                }, null, 8, null);
                return;
            }
        }
        com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("back", ""));
        finish();
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        this.cameraController.setActivityIsShowing(false);
        com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.closeAsync(this.scanSession);
        this.cameraController.onDestroy();
        com.up366.mobile.course.photoanswer.logic.utils.CameraCleanUtils.INSTANCE.clean((android.content.Context) this);
        com.up366.common.log.Logger.info(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("exitP1p", ""));
        com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.onDestroy();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.onDistroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
        super.onDestroy();
    }

    private final boolean isActivityUsable() {
        return (isFinishing() || isDestroyed()) ? false : true;
    }

    private final void showBorderView(int edgeResult, com.up366.mobile.course.p1p.PaperRecognitionResult analyzeResult) {
        if (getBinding().borderView.getImageWidth() <= 0 || getBinding().borderView.getImageHeight() <= 0 || this.cameraController.getNeedUpdateTransform()) {
            getBinding().borderView.setImageSourceInfo(analyzeResult.getRealCropRect().width(), analyzeResult.getRealCropRect().height(), false);
            this.cameraController.setNeedUpdateTransform(false);
        }
        getBinding().borderView.clear();
        if (edgeResult == -3 || edgeResult == 0 || edgeResult == 1) {
            com.up366.mobile.course.p1p.view.GraphicOverlay graphicOverlay = getBinding().borderView;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(graphicOverlay, "borderView");
            getBinding().borderView.add(new com.up366.mobile.course.p1p.view.BorderGraphic(graphicOverlay, analyzeResult));
            getBinding().borderView.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scanOnePage(final java.lang.String filepath) {
        if (this.scanSession.isClosed() || !isActivityUsable()) {
            return;
        }
        com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel = this.tipTxtViewModel;
        if (tipTxtViewModel == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            tipTxtViewModel = null;
        }
        tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.GONE);
        showAnalysisUi$default(this, filepath, null, 2, null);
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda13
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.scanOnePage$lambda$13(this.f$0, filepath);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scanOnePage$lambda$13(final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, java.lang.String str) {
        final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResultScanOnePage = photoAnswerMainActivity.logic.scanOnePage(str);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda6
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.scanOnePage$lambda$13$lambda$12(this.f$0, scanOnePageResultScanOnePage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scanOnePage$lambda$13$lambda$12(final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult) {
        if (photoAnswerMainActivity.scanSession.isClosed() || !photoAnswerMainActivity.isActivityUsable()) {
            return;
        }
        photoAnswerMainActivity.addAnimStart(new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda0
            public final java.lang.Object invoke() {
                return com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.scanOnePage$lambda$13$lambda$12$lambda$11(this.f$0, scanOnePageResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit scanOnePage$lambda$13$lambda$12$lambda$11(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult) {
        photoAnswerMainActivity.handleResult(scanOnePageResult);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController.CameraControllerCallback
    public void onTakePhotoCallback(com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData pageData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pageData, "pageData");
        if (this.scanSession.isClosed() || !isActivityUsable()) {
            return;
        }
        int code = pageData.getCode();
        final java.lang.String cropImagePath = pageData.getCropImagePath();
        com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel = null;
        if (code == 0) {
            this.checkFindConnerErrorCount = 0;
            if (pageData.isV2Paper()) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(cropImagePath);
                scanOnePage(cropImagePath);
                return;
            }
            com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel2 = this.tipTxtViewModel;
            if (tipTxtViewModel2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
                tipTxtViewModel2 = null;
            }
            tipTxtViewModel2.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.GONE);
            kotlin.jvm.internal.Intrinsics.checkNotNull(cropImagePath);
            showAnalysisUi$default(this, cropImagePath, null, 2, null);
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda8
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.onTakePhotoCallback$lambda$16(this.f$0, cropImagePath);
                }
            });
            return;
        }
        if (code == -108) {
            com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel3 = this.tipTxtViewModel;
            if (tipTxtViewModel3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            } else {
                tipTxtViewModel = tipTxtViewModel3;
            }
            tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.HAND_IN_IMAGE);
            return;
        }
        if (code == -1) {
            com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel4 = this.tipTxtViewModel;
            if (tipTxtViewModel4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            } else {
                tipTxtViewModel = tipTxtViewModel4;
            }
            tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.GONE);
            com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.showDialog$default(com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE, (android.app.Activity) this, com.up366.mobile.course.photoanswer.dialog.DialogType.TOO_BLUR, null, null, 8, null);
            return;
        }
        if (code == -5) {
            int i = this.checkFindConnerErrorCount + 1;
            this.checkFindConnerErrorCount = i;
            showNoSheetDialog(i, cropImagePath, null);
        } else if (code == -4) {
            showOldAnswerSheetDialog();
        } else if (code == -6) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("没有获取到图片，请重试");
            this.cameraController.startAnalyze();
        } else {
            this.cameraController.startAnalyze();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTakePhotoCallback$lambda$16(final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, java.lang.String str) {
        com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic photoAnswerLogic = photoAnswerMainActivity.logic;
        kotlin.jvm.internal.Intrinsics.checkNotNull(str);
        final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResultScanV3OnePage$default = com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic.scanV3OnePage$default(photoAnswerLogic, str, null, null, 6, null);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda29
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.onTakePhotoCallback$lambda$16$lambda$15(this.f$0, scanOnePageResultScanV3OnePage$default);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onTakePhotoCallback$lambda$16$lambda$15(final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult) {
        if (photoAnswerMainActivity.scanSession.isClosed() || !photoAnswerMainActivity.isActivityUsable()) {
            return;
        }
        photoAnswerMainActivity.addAnimStart(new kotlin.jvm.functions.Function0() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda16
            public final java.lang.Object invoke() {
                return com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.onTakePhotoCallback$lambda$16$lambda$15$lambda$14(this.f$0, scanOnePageResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit onTakePhotoCallback$lambda$16$lambda$15$lambda$14(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult) {
        photoAnswerMainActivity.handleResult(scanOnePageResult);
        return kotlin.Unit.INSTANCE;
    }

    public static /* synthetic */ void showNoSheetDialog$default(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, int i, java.lang.String str, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        photoAnswerMainActivity.showNoSheetDialog(i, str, scanOnePageResult);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showNoSheetDialog(int checkFindConnerErrorCount, final java.lang.String filePath, final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        ((java.util.Map) jSONObject).put("errorCount", java.lang.Integer.valueOf(checkFindConnerErrorCount));
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.showDialog((android.app.Activity) this, com.up366.mobile.course.photoanswer.dialog.DialogType.NO_ANSWER_SHEET, new com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.showNoSheetDialog.1
            @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
            public void onCallback(int code, java.lang.Object info) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
                if (code == 0) {
                    if (((java.lang.Boolean) info).booleanValue()) {
                        com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.skipOnlineAnswer();
                        return;
                    }
                    com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult2 = scanOnePageResult;
                    if (scanOnePageResult2 != null) {
                        com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo = scanOnePageResult2.getImageInfo();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo);
                        imageInfo.setForceUse(true);
                        com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity = com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this;
                        com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo2 = scanOnePageResult.getImageInfo();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo2);
                        photoAnswerMainActivity.addImageAndShow(imageInfo2);
                        com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.cameraController.startAnalyze();
                        return;
                    }
                    com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity2 = com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this;
                    java.lang.String str = filePath;
                    kotlin.jvm.internal.Intrinsics.checkNotNull(str);
                    photoAnswerMainActivity2.scanOnePage(str);
                    return;
                }
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.StartAnalyzeEvent());
            }
        }, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showOldAnswerSheetDialog() {
        if (this.logic.getCacheHelper().hasNewAnswerSheet()) {
            com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.showDialog$default(com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE, (android.app.Activity) this, com.up366.mobile.course.photoanswer.dialog.DialogType.ERROR_NEW_OLD_PAPER, new com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.showOldAnswerSheetDialog.1
                @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
                public void onCallback(int code, java.lang.Object info) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
                    com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.handleOldAnswerSheetCallback(code);
                }
            }, null, 8, null);
        } else {
            com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.showDialog$default(com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE, (android.app.Activity) this, com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_NEW_ANSWER_SHEET, new com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.showOldAnswerSheetDialog.2
                @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
                public void onCallback(int code, java.lang.Object info) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
                    com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.handleOldAnswerSheetCallback(code);
                }
            }, null, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleOldAnswerSheetCallback(int code) {
        if (code == 0) {
            finish();
            return;
        }
        com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.INSTANCE.setTakePhotoType(1);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SwitchHandCheckEvent(false));
        this.cameraController.startAnalyze();
    }

    @Override // com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController.CameraControllerCallback
    public void analyzeResult(com.up366.mobile.course.p1p.PaperRecognitionResult analyzeResult) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(analyzeResult, "analyzeResult");
        if (this.scanSession.isClosed() || !isActivityUsable()) {
            return;
        }
        com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel = null;
        if (!com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.isConnerOk(this.scanSession)) {
            if (com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.isOldPaper(this.scanSession)) {
                if (java.lang.System.currentTimeMillis() - this.lastShowNoAnswerSheetTime < 1800) {
                    com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.StartAnalyzeEvent());
                    return;
                } else {
                    this.lastShowNoAnswerSheetTime = java.lang.System.currentTimeMillis();
                    showOldAnswerSheetDialog();
                    return;
                }
            }
            com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel2 = this.tipTxtViewModel;
            if (tipTxtViewModel2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            } else {
                tipTxtViewModel = tipTxtViewModel2;
            }
            tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.NO_ANSWER_SHEET);
            showBorderView(-4, analyzeResult);
            return;
        }
        int iHandleRecognitionEdgeResult = com.up366.mobile.course.photoanswer.logic.helper.RecognitionEdgeV2Helper.INSTANCE.handleRecognitionEdgeResult(analyzeResult);
        if (iHandleRecognitionEdgeResult == -4) {
            com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel3 = this.tipTxtViewModel;
            if (tipTxtViewModel3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            } else {
                tipTxtViewModel = tipTxtViewModel3;
            }
            tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.NO_ANSWER_SHEET);
        } else if (iHandleRecognitionEdgeResult == -3) {
            com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel4 = this.tipTxtViewModel;
            if (tipTxtViewModel4 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            } else {
                tipTxtViewModel = tipTxtViewModel4;
            }
            tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.PHOTO_TOO_SMALL);
        } else if (iHandleRecognitionEdgeResult == -2) {
            com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel5 = this.tipTxtViewModel;
            if (tipTxtViewModel5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            } else {
                tipTxtViewModel = tipTxtViewModel5;
            }
            tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.IS_NOT_RECTANGLE);
        } else if (iHandleRecognitionEdgeResult == -1) {
            com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel6 = this.tipTxtViewModel;
            if (tipTxtViewModel6 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            } else {
                tipTxtViewModel = tipTxtViewModel6;
            }
            tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.PHOTO_OUT_SCREEN);
        } else if (iHandleRecognitionEdgeResult == 1) {
            com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel7 = this.tipTxtViewModel;
            if (tipTxtViewModel7 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            } else {
                tipTxtViewModel = tipTxtViewModel7;
            }
            tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.WAIT_TAKE_PHOTO);
        } else if (iHandleRecognitionEdgeResult == 2) {
            com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel8 = this.tipTxtViewModel;
            if (tipTxtViewModel8 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            } else {
                tipTxtViewModel = tipTxtViewModel8;
            }
            tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.WAIT_TAKE_PHOTO);
            this.cameraController.takePicture();
        }
        showBorderView(iHandleRecognitionEdgeResult, analyzeResult);
    }

    static /* synthetic */ void showAnalysisUi$default(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, java.lang.String str, java.lang.String str2, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        photoAnswerMainActivity.showAnalysisUi(str, str2);
    }

    private final void showAnalysisUi(final java.lang.String cropImagePath, final java.lang.String realPath) {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda27
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.showAnalysisUi$lambda$19(this.f$0, realPath, cropImagePath);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAnalysisUi$lambda$19(final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, java.lang.String str, java.lang.String str2) {
        if (photoAnswerMainActivity.scanSession.isClosed() || !photoAnswerMainActivity.isActivityUsable()) {
            return;
        }
        com.up366.mobile.course.p1p.helper.P1pStatusHelper.INSTANCE.isAnalysising();
        photoAnswerMainActivity.getBinding().borderView.clear();
        photoAnswerMainActivity.getBinding().ivPhotoResultBg.setBackgroundColor(0);
        com.up366.mobile.common.utils.ViewUtil.visible(photoAnswerMainActivity.getBinding().clPhotoResult);
        photoAnswerMainActivity.startCountTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        com.up366.mobile.common.utils.ViewUtil.gone(photoAnswerMainActivity.getBinding().scanTips);
        com.up366.common.task.TaskUtils.postMainTaskDelay(com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda15
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.showAnalysisUi$lambda$19$lambda$17(this.f$0);
            }
        });
        com.bumptech.glide.RequestManager requestManagerWith = com.bumptech.glide.Glide.with((androidx.fragment.app.FragmentActivity) photoAnswerMainActivity);
        java.lang.String str3 = str;
        if (str3.length() != 0) {
            str2 = str3;
        }
        requestManagerWith.load(str2).into((android.widget.ImageView) photoAnswerMainActivity.getBinding().ivResultShow);
        photoAnswerMainActivity.getBinding().ivResultShow.clearAnimation();
        photoAnswerMainActivity.getBinding().ivResultShow.setVisibility(0);
        photoAnswerMainActivity.getScanShowAmin().setAnimationListener(new com.up366.mobile.common.utils.AnimUtils.AnimationAdapter() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$showAnalysisUi$1$3
            @Override // com.up366.mobile.common.utils.AnimUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(android.view.animation.Animation animation) {
                this.this$0.getBinding().ivPhotoResultBg.setBackgroundResource(com.up366.mobile.R.drawable.p1p_scan_image_bg);
            }
        });
        photoAnswerMainActivity.getBinding().ivResultShow.startAnimation(photoAnswerMainActivity.getScanShowAmin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAnalysisUi$lambda$19$lambda$17(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        if (photoAnswerMainActivity.scanSession.isClosed() || !photoAnswerMainActivity.isActivityUsable()) {
            return;
        }
        if (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - photoAnswerMainActivity.startCountTime < 2998 || !com.up366.mobile.course.p1p.helper.P1pStatusHelper.INSTANCE.isAnalysising()) {
            com.up366.common.log.Logger.info("拍照时间小于3秒，不显示扫描提示");
        } else {
            com.up366.mobile.common.utils.ViewUtil.visible(photoAnswerMainActivity.getBinding().scanTips);
        }
    }

    @Override // com.up366.mobile.course.photoanswer.BasePhotoAnswerMainActivity
    public void onPageSelectedShow(int position, final com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo page) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(page, com.up366.medialibrary.config.PictureConstants.EXTRA_PAGE);
        com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel = this.tipTxtViewModel;
        if (tipTxtViewModel == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            tipTxtViewModel = null;
        }
        tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.GONE);
        com.up366.mobile.common.utils.ViewUtil.visible(getBinding().ibDelete);
        getBinding().ibDelete.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.onPageSelectedShow$lambda$20(this.f$0, page, view);
            }
        });
        getAdapter().setPageSelectPosition(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageSelectedShow$lambda$20(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo, android.view.View view) {
        photoAnswerMainActivity.logic.getCacheHelper().removeImage(photoAnswerImageInfo.getSourceImageFilePath());
        java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> imageList = photoAnswerMainActivity.logic.getCacheHelper().getImageList();
        photoAnswerMainActivity.getImageShowHelper().deletePageResult(imageList);
        photoAnswerMainActivity.getAdapter().setDataS(imageList);
    }

    @Override // com.up366.mobile.course.photoanswer.BasePhotoAnswerMainActivity
    public void closePageImageShow() {
        getAdapter().setPageSelectPosition(-1);
        this.cameraController.startAnalyze();
    }

    public final void promptPageRepeat(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SwitchHandCheckEvent(false));
        this.repeatTipTxt = "你重复拍摄了" + imageInfo.getImageIndex() + "/" + imageInfo.getTotalImageCount() + "\n替换成功～";
        com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel = this.tipTxtViewModel;
        if (tipTxtViewModel == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            tipTxtViewModel = null;
        }
        tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.PAGE_REPEATED);
        this.cameraController.setActivityIsShowing(false);
        getBinding().vScreenMask.setVisibility(0);
        com.up366.common.task.TaskUtils.postMainTaskDelay(1500L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda28
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.promptPageRepeat$lambda$21(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void promptPageRepeat$lambda$21(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        photoAnswerMainActivity.getBinding().vScreenMask.setVisibility(8);
        photoAnswerMainActivity.cameraController.setActivityIsShowing(true);
        photoAnswerMainActivity.cameraController.startAnalyze();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void handleSubmitTask() {
        if (kotlin.jvm.internal.Intrinsics.areEqual(this.fromType, FROM_TYPE_SCAN_PAPER_GENERAL)) {
            com.up366.mobile.course.answersheet.AnswerSheetCacheHelper cacheHelper = this.logic.getCacheHelper();
            com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel = null;
            if (!cacheHelper.checkFull()) {
                com.up366.common.log.Logger.info("checkFull  tip not full dialog");
                com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel2 = this.tipTxtViewModel;
                if (tipTxtViewModel2 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
                } else {
                    tipTxtViewModel = tipTxtViewModel2;
                }
                tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.GONE);
                getBinding().borderView.clear();
                com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.showDialog$default(com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE, (android.app.Activity) this, com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_FULL_DIALOG, null, null, 8, null);
                return;
            }
            if (!cacheHelper.checkBlocks()) {
                updateImageStatus();
                com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.showDialog((android.app.Activity) this, com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_FULL_BLOCKS_DIALOG, new com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.handleSubmitTask.1
                    @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
                    public void onCallback(int code, java.lang.Object info) {
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
                        if (code == 1) {
                            com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.cameraController.startAnalyze();
                        }
                    }
                }, null);
                return;
            } else {
                showSubmitUploading();
                this.logic.submitTaskV2();
                return;
            }
        }
        handleSubmitTaskV1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleSubmitTaskV1() {
        com.up366.mobile.course.answersheet.AnswerSheetCacheHelper cacheHelper = this.logic.getCacheHelper();
        if (cacheHelper.hasForceUseImage()) {
            com.up366.common.log.Logger.info("hasForceUseImage  force submit");
            showSubmitUploading();
            this.logic.submitTask(true);
            return;
        }
        if (!cacheHelper.checkFull()) {
            com.up366.common.log.Logger.info("checkFull  tip not full dialog");
            com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel = this.tipTxtViewModel;
            if (tipTxtViewModel == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
                tipTxtViewModel = null;
            }
            tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.GONE);
            getBinding().borderView.clear();
            com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.showDialog$default(com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE, (android.app.Activity) this, com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_FULL_DIALOG, null, null, 8, null);
            return;
        }
        if (!cacheHelper.checkBlocks()) {
            com.up366.common.log.Logger.info("checkBlocks  tip not full dialog");
            java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> imageList = cacheHelper.getImageList();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> it = imageList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getFilePath());
            }
            com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLogAlarm(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002007, -1, (24 & 4) != 0 ? null : "checkBlocks error", (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, (24 & 32) != 0 ? null : (java.lang.String[]) arrayList.toArray(new java.lang.String[0]));
            updateImageStatus();
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            ((java.util.Map) jSONObject).put("errorCount", java.lang.Integer.valueOf(this.submitErrorTipCount));
            com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.showDialog((android.app.Activity) this, com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_FULL_BLOCKS_DIALOG, new com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.handleSubmitTaskV1.1
                @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
                public void onCallback(int code, java.lang.Object info) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
                    if (code == 1) {
                        com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.cameraController.startAnalyze();
                    } else if (!((java.lang.Boolean) info).booleanValue()) {
                        com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.showSubmitUploading();
                        com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.logic.submitTask(true);
                    } else {
                        com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.skipOnlineAnswer();
                    }
                }
            }, jSONObject);
            this.submitErrorTipCount++;
            return;
        }
        com.up366.common.log.Logger.info("submitTask");
        showSubmitUploading();
        this.logic.submitTask(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void skipOnlineAnswer() {
        com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.setSubmitType(3);
        java.lang.Object data = this.logic.getCacheHelper().getData();
        kotlin.jvm.internal.Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.up366.mobile.course.task.TaskInfoV2");
        com.up366.mobile.course.task.TaskJumpHelper.jumpToDetailTaskPage((android.content.Context) this, (com.up366.mobile.course.task.TaskInfoV2) data);
        finish();
    }

    private final void updateImageStatus() {
        final com.up366.mobile.course.answersheet.AnswerSheetCacheHelper cacheHelper = this.logic.getCacheHelper();
        java.util.Map<java.lang.Integer, com.alibaba.fastjson.JSONObject> layoutJsonBlocksMap = cacheHelper.getLayoutJsonBlocksMap();
        for (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo : cacheHelper.getImageList()) {
            com.alibaba.fastjson.JSONArray blocks = photoAnswerImageInfo.getBlocks();
            int size = blocks.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    com.alibaba.fastjson.JSONObject jSONObject = blocks.getJSONObject(i);
                    int intValue = jSONObject.getIntValue("blockNo");
                    if (!layoutJsonBlocksMap.containsKey(java.lang.Integer.valueOf(intValue))) {
                        cacheHelper.updateImageStatus(photoAnswerImageInfo, -1);
                        break;
                    }
                    com.alibaba.fastjson.JSONObject jSONObject2 = layoutJsonBlocksMap.get(java.lang.Integer.valueOf(intValue));
                    kotlin.jvm.internal.Intrinsics.checkNotNull(jSONObject2);
                    com.alibaba.fastjson.JSONObject jSONObject3 = jSONObject2;
                    if (jSONObject3.getIntValue("blockType") != jSONObject.getIntValue("blockType") || jSONObject3.getIntValue("imageNo") != jSONObject.getIntValue("imageNo") || !kotlin.jvm.internal.Intrinsics.areEqual(jSONObject3.getString("template"), jSONObject.getString("template"))) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            cacheHelper.updateImageStatus(photoAnswerImageInfo, -1);
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda7
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.updateImageStatus$lambda$22(this.f$0, cacheHelper);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateImageStatus$lambda$22(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, com.up366.mobile.course.answersheet.AnswerSheetCacheHelper answerSheetCacheHelper) {
        photoAnswerMainActivity.getAdapter().setDataS(answerSheetCacheHelper.getImageList());
        photoAnswerMainActivity.getAdapter().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showSubmitUploading() {
        this.logic.getCacheHelper().resetUploadKey();
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        java.util.Map map = (java.util.Map) jSONObject;
        map.put("msg", "提交中");
        map.put("key", this.logic.getCacheHelper().getUploadKey());
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.showDialog((android.app.Activity) this, com.up366.mobile.course.photoanswer.dialog.DialogType.SUBMIT_ANSWER_UPLOADING_DIALOG, null, jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel = null;
        switch (view.getId()) {
            case com.up366.mobile.R.id.alum_tv /* 2131361903 */:
                this.cameraController.stopAnalyze();
                com.up366.mobile.common.utils.PermissionUtils.checkReadStoragePermission((android.content.Context) this, "相册", new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda26
                    @Override // com.up366.common.callback.ICallbackCodeInfo
                    public final void onResult(int i, java.lang.String str) {
                        com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.onClick$lambda$24(this.f$0, i, str);
                    }
                });
                break;
            case com.up366.mobile.R.id.bt_back /* 2131361984 */:
                onBackPressed();
                break;
            case com.up366.mobile.R.id.ib_guide /* 2131362555 */:
                com.up366.mobile.commonui.CommonWebViewActivity.openPhotoAnswerGuideActivity((android.content.Context) this);
                break;
            case com.up366.mobile.R.id.take_photo_btn /* 2131363371 */:
                if (com.up366.mobile.course.p1p.helper.P1pStatusHelper.INSTANCE.canTakePicture()) {
                    com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.start();
                    this.cameraController.takePicture();
                }
                break;
            case com.up366.mobile.R.id.tv_start /* 2131363614 */:
                com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel2 = this.tipTxtViewModel;
                if (tipTxtViewModel2 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
                } else {
                    tipTxtViewModel = tipTxtViewModel2;
                }
                tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.NO_ANSWER_SHEET);
                getBinding().tvReadyTips.setVisibility(8);
                com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.INSTANCE.setTakePhotoType(1);
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SwitchHandCheckEvent(false));
                this.cameraController.startAnalyze();
                break;
            case com.up366.mobile.R.id.tv_submit /* 2131363615 */:
                if (getAdapter().getPages().size() == 0) {
                    this.cameraController.stopAnalyze();
                    getBinding().borderView.clear();
                    com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel3 = this.tipTxtViewModel;
                    if (tipTxtViewModel3 == null) {
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
                    } else {
                        tipTxtViewModel = tipTxtViewModel3;
                    }
                    tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.SUBMIT_AFTER_TAKE_PHOTO);
                    com.up366.common.task.TaskUtils.postMainTaskDelay(1500L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda25
                        @Override // com.up366.common.task.Task
                        public final void run() {
                            com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.onClick$lambda$23(this.f$0);
                        }
                    });
                } else {
                    handleSubmitTask();
                }
                break;
            case com.up366.mobile.R.id.v_screen_mask /* 2131363706 */:
                getBinding().vScreenMask.setVisibility(8);
                this.cameraController.startAnalyze();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$23(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        photoAnswerMainActivity.cameraController.startAnalyze();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$24(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, int i, java.lang.String str) {
        if (i != 0) {
            photoAnswerMainActivity.cameraController.startAnalyze();
        } else {
            photoAnswerMainActivity.openAlum();
        }
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$openAlum$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PhotoAnswerMainActivity.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/up366/mobile/course/photoanswer/PhotoAnswerMainActivity$openAlum$1", "Lcom/up366/medialibrary/listener/OnResultCallbackListener;", "Lcom/up366/medialibrary/MediaInfo;", "onResult", "", "results", "", "onCancel", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C00731 implements com.up366.medialibrary.listener.OnResultCallbackListener<com.up366.medialibrary.MediaInfo> {
        C00731() {
        }

        @Override // com.up366.medialibrary.listener.OnResultCallbackListener
        public void onResult(java.util.List<com.up366.medialibrary.MediaInfo> results) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(results, "results");
            final com.up366.medialibrary.MediaInfo mediaInfo = results.get(0);
            com.up366.common.log.Logger.info("alum select mediaInfo " + mediaInfo);
            final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity = com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this;
            com.up366.common.task.TaskUtils.postMainTaskDelay(120L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$openAlum$1$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.C00731.onResult$lambda$0(photoAnswerMainActivity);
                }
            });
            final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity2 = com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this;
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$openAlum$1$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.C00731.onResult$lambda$2(photoAnswerMainActivity2, mediaInfo);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onResult$lambda$0(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
            com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel = photoAnswerMainActivity.tipTxtViewModel;
            if (tipTxtViewModel == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
                tipTxtViewModel = null;
            }
            tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.GONE);
            photoAnswerMainActivity.showLoadingView();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onResult$lambda$2(final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, com.up366.medialibrary.MediaInfo mediaInfo) {
            photoAnswerMainActivity.cameraController.alumPicture(mediaInfo, new kotlin.jvm.functions.Function1() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$openAlum$1$$ExternalSyntheticLambda0
                public final java.lang.Object invoke(java.lang.Object obj) {
                    return com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.C00731.onResult$lambda$2$lambda$1(photoAnswerMainActivity, (com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.Unit onResult$lambda$2$lambda$1(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, com.up366.mobile.course.photoanswer.logic.cameraAlum.PhotoCorrectImageData photoCorrectImageData) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(photoCorrectImageData, "pageData");
            if (photoAnswerMainActivity.scanSession.isClosed()) {
                return kotlin.Unit.INSTANCE;
            }
            photoAnswerMainActivity.hideLoadingView();
            photoAnswerMainActivity.onTakePhotoCallback(photoCorrectImageData);
            return kotlin.Unit.INSTANCE;
        }

        @Override // com.up366.medialibrary.listener.OnResultCallbackListener
        public void onCancel() {
            com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.hideLoadingView();
            com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.cameraController.startAnalyze();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void openAlum() {
        com.up366.medialibrary.helper.MediaHelperManager.getSelectorHelper().openPictureGallery((android.app.Activity) this, 1, new com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.C00731());
    }

    public final void showLoadingView() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.showLoadingView$lambda$25(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLoadingView$lambda$25(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        if (photoAnswerMainActivity.scanSession.isClosed() || !photoAnswerMainActivity.isActivityUsable()) {
            return;
        }
        photoAnswerMainActivity.getBinding().loadingLayout.setVisibility(0);
    }

    public final void hideLoadingView() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda11
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.hideLoadingView$lambda$26(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideLoadingView$lambda$26(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        if (photoAnswerMainActivity.scanSession.isClosed() || !photoAnswerMainActivity.isActivityUsable()) {
            return;
        }
        photoAnswerMainActivity.getBinding().loadingLayout.setVisibility(8);
    }

    public final void retryFetch(final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scanOnePageResult, "scanOnePageResult");
        showLoadingView();
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda20
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.retryFetch$lambda$28(scanOnePageResult, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void retryFetch$lambda$28(com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        if (scanOnePageResult.getCode() == -101) {
            objectRef.element = photoAnswerMainActivity.logic.retryByFetchLayoutInfo(scanOnePageResult.getPaperCodeModel());
        } else if (scanOnePageResult.getCode() == -106) {
            objectRef.element = photoAnswerMainActivity.logic.retryByFetchPaperCode(scanOnePageResult.getPaperCodeModel());
        } else if (scanOnePageResult.getCode() == -1001 || scanOnePageResult.getCode() == -1000 || scanOnePageResult.getCode() == -1002) {
            com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic photoAnswerLogic = photoAnswerMainActivity.logic;
            java.lang.String filePath = scanOnePageResult.getPaperCodeModel().getFilePath();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
            objectRef.element = com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic.scanV3OnePage$default(photoAnswerLogic, filePath, null, null, 6, null);
        }
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda2
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.retryFetch$lambda$28$lambda$27(this.f$0, objectRef);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void retryFetch$lambda$28$lambda$27(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, kotlin.jvm.internal.Ref.ObjectRef objectRef) {
        if (photoAnswerMainActivity.scanSession.isClosed() || !photoAnswerMainActivity.isActivityUsable()) {
            return;
        }
        photoAnswerMainActivity.hideLoadingView();
        com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult = (com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult) objectRef.element;
        if (scanOnePageResult != null) {
            photoAnswerMainActivity.handleResult(scanOnePageResult);
        }
    }

    public final void showCommonError(int errorCount, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult) {
        int errorCode;
        java.lang.String[] strArr;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scanOnePageResult, "scanOnePageResult");
        if (scanOnePageResult.getImageInfo() != null) {
            com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo = scanOnePageResult.getImageInfo();
            kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo);
            errorCode = imageInfo.getErrorCode();
        } else {
            errorCode = -1;
        }
        int i = errorCode;
        if (scanOnePageResult.getImageInfo() != null) {
            com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo2 = scanOnePageResult.getImageInfo();
            kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo2);
            strArr = new java.lang.String[]{imageInfo2.getFilePath()};
        } else {
            strArr = null;
        }
        com.up366.mobile.course.p1p.log.P1pLogHelper p1pLogHelper = com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE;
        com.alibaba.fastjson.JSONObject layoutJson = this.logic.getCacheHelper().getLayoutJson();
        java.lang.String jSONString = layoutJson != null ? layoutJson.toJSONString() : null;
        com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel paperCodeModel = scanOnePageResult.getPaperCodeModel();
        p1pLogHelper.buildLogAlarm(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002008, i, (24 & 4) != 0 ? null : null, (24 & 8) != 0 ? null : jSONString, (24 & 16) != 0 ? null : paperCodeModel != null ? paperCodeModel.getPaperCode() : null, (24 & 32) != 0 ? null : strArr);
        showDialogByType$default(this, com.up366.mobile.course.photoanswer.dialog.DialogType.COMMON_ERROR_DIALOG, errorCount, scanOnePageResult, null, 8, null);
    }

    public final void handleResult(com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scanOnePageResult, "scanOnePageResult");
        com.up366.mobile.course.photoanswer.result.ScanResultDispatcher scanResultDispatcher = this.resultDispatcher;
        com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext = null;
        if (scanResultDispatcher == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("resultDispatcher");
            scanResultDispatcher = null;
        }
        if (scanResultDispatcher.dispatch(scanOnePageResult)) {
            return;
        }
        com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext2 = this.resultContext;
        if (scanResultContext2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("resultContext");
            scanResultContext2 = null;
        }
        scanResultContext2.setErrorCount(scanResultContext2.getErrorCount() + 1);
        com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext3 = this.resultContext;
        if (scanResultContext3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("resultContext");
        } else {
            scanResultContext = scanResultContext3;
        }
        showCommonError(scanResultContext.getErrorCount(), scanOnePageResult);
    }

    public final boolean scanOnePageResultOk(com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scanOnePageResult, "scanOnePageResult");
        if (scanOnePageResult.getCode() != 0) {
            return false;
        }
        if (com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.INSTANCE.isHandTakePhoto()) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SwitchHandCheckEvent(false));
        }
        com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo = scanOnePageResult.getImageInfo();
        kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo);
        addImageAndShow(imageInfo);
        if (!this.logic.getCacheHelper().checkFull()) {
            showTakeNextTip();
            return true;
        }
        com.up366.common.log.Logger.info("show submit dialog");
        showSubmitDialog();
        return true;
    }

    private final void showTakeNextTip() {
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda12
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.showTakeNextTip$lambda$30(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTakeNextTip$lambda$30(final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel = photoAnswerMainActivity.tipTxtViewModel;
        if (tipTxtViewModel == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            tipTxtViewModel = null;
        }
        tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.TAKE_PHOTO_SUCCESS_TO_NEXT);
        photoAnswerMainActivity.getBinding().vScreenMask.setVisibility(0);
        com.up366.common.task.TaskUtils.postMainTaskDelay(1200L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.showTakeNextTip$lambda$30$lambda$29(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTakeNextTip$lambda$30$lambda$29(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        photoAnswerMainActivity.getBinding().vScreenMask.setVisibility(8);
        photoAnswerMainActivity.cameraController.startAnalyze();
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$showSubmitDialog$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PhotoAnswerMainActivity.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/up366/mobile/course/photoanswer/PhotoAnswerMainActivity$showSubmitDialog$1", "Lcom/up366/mobile/course/photoanswer/dialog/Dialog2Helper$IDialogCallback;", "onCallback", "", "code", "", "info", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C00771 implements com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback {
        C00771() {
        }

        @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
        public void onCallback(int code, java.lang.Object info) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
            if (code == 0) {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.getImageShowHelper().showPageImage(0, com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.getAdapter().getPages());
            } else if (code == 1) {
                final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity = com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this;
                com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$showSubmitDialog$1$$ExternalSyntheticLambda0
                    @Override // com.up366.common.task.Task
                    public final void run() {
                        photoAnswerMainActivity.handleSubmitTask();
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showSubmitDialog() {
        com.up366.common.log.Logger.info("show submit dialog");
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.showDialog$default(com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE, (android.app.Activity) this, com.up366.mobile.course.photoanswer.dialog.DialogType.SUBMIT_ANSWER_TIP_DIALOG, new com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.C00771(), null, 8, null);
    }

    public static /* synthetic */ void showDialogByType$default(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, com.up366.mobile.course.photoanswer.dialog.DialogType dialogType, int i, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, java.lang.String str, int i2, java.lang.Object obj) {
        if ((i2 & 8) != 0) {
            str = "";
        }
        photoAnswerMainActivity.showDialogByType(dialogType, i, scanOnePageResult, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showDialogByType(com.up366.mobile.course.photoanswer.dialog.DialogType dialogType, int errorCount, final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, java.lang.String title) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dialogType, "dialogType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scanOnePageResult, "scanOnePageResult");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(title, "title");
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        java.util.Map map = (java.util.Map) jSONObject;
        map.put("errorCount", java.lang.Integer.valueOf(errorCount));
        map.put("title", title);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.showDialog((android.app.Activity) this, dialogType, new com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.showDialogByType.1
            @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
            public void onCallback(int code, java.lang.Object info) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
                if (code != 0) {
                    com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.cameraController.startAnalyze();
                    return;
                }
                if (((java.lang.Boolean) info).booleanValue()) {
                    com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.skipOnlineAnswer();
                    return;
                }
                com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo = scanOnePageResult.getImageInfo();
                kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo);
                imageInfo.setForceUse(true);
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity = com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this;
                com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo2 = scanOnePageResult.getImageInfo();
                kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo2);
                photoAnswerMainActivity.addImageAndShow(imageInfo2);
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.this.cameraController.startAnalyze();
            }
        }, jSONObject);
    }

    public final void addImageAndShow(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
        this.logic.getCacheHelper().addImage(imageInfo);
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda21
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.addImageAndShow$lambda$31(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addImageAndShow$lambda$31(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        photoAnswerMainActivity.getAdapter().setDataS(photoAnswerMainActivity.logic.getCacheHelper().getImageList());
    }

    @Override // com.up366.mobile.course.photoanswer.BasePhotoAnswerMainActivity
    public void setActivityIsShowing(boolean isShowing) {
        this.cameraController.setActivityIsShowing(isShowing);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(com.up366.mobile.common.event.OpenAlumEvent event) {
        openAlum();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(com.up366.mobile.common.event.StartAnalyzeEvent event) {
        this.cameraController.startAnalyze();
        getBinding().vScreenMask.setVisibility(8);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(com.up366.mobile.common.event.CommonUploadLogEvent event) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(event, "event");
        com.up366.common.log.Logger.info("onMessageEvent: " + event);
        if (event.getType() == 24 && kotlin.jvm.internal.Intrinsics.areEqual(event.getRefKey(), this.logic.getCacheHelper().getSubmitKey())) {
            if (com.up366.mobile.course.photoanswer.dialog.DialogType.SUBMIT_ANSWER_UPLOADING_DIALOG != com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.getCurDialogType()) {
                if (event.isSuccess()) {
                    this.uploadSuccess = true;
                }
            } else if (event.isFailed()) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.CloseUploadDialogEvent());
                showErrorDialog();
            } else if (event.isSuccess()) {
                showSuccessPage();
            } else if (event.isProgressUpdate()) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.UpdateLoadingProgressEvent(this.logic.getCacheHelper().getUploadKey(), event.getPercent()));
            }
        }
    }

    private final void showErrorDialog() {
        com.up366.common.task.TaskUtils.postMainTaskDelay(80L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda3
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.showErrorDialog$lambda$32(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void showErrorDialog$lambda$32(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        java.util.Map map = (java.util.Map) jSONObject;
        map.put("leftBtnTxt", "下次再试");
        map.put("taskName", photoAnswerMainActivity.logic.getCacheHelper().getJobName());
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.showDialog((android.app.Activity) photoAnswerMainActivity, com.up366.mobile.course.photoanswer.dialog.DialogType.SUBMIT_ANSWER_ERROR_DIALOG, new com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$showErrorDialog$1$1(photoAnswerMainActivity), jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showSuccessPage() {
        if (kotlin.jvm.internal.Intrinsics.areEqual(this.fromType, FROM_TYPE_SCAN_PAPER_GENERAL)) {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.CloseUploadDialogEvent());
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.EventScanPaperGeneralSubmitData(this.logic.getScanPaperGeneralSubmitData(), this.logic.getCacheHelper().getCurWebViewId()));
            com.alibaba.fastjson.JSONObject scanPaperGeneralSubmitData = this.logic.getScanPaperGeneralSubmitData();
            com.up366.common.log.Logger.info("scan paper general submit data event posted" + (scanPaperGeneralSubmitData != null ? scanPaperGeneralSubmitData.toJSONString() : null));
            finish();
            return;
        }
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.CloseUploadDialogEvent());
        com.up366.mobile.book.helper.TaskCompletedEventHelper.sendTaskCompletedEvent(this.logic.getCacheHelper().getContentId(), this.logic.getCacheHelper().getStudyTaskId());
        com.up366.mobile.course.photoanswer.PhotoAnswerSubmitSuccessActivity.INSTANCE.startActivity((android.content.Context) this, this.fromType);
        finish();
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void onMessageEvent(com.up366.mobile.common.event.SwitchHandCheckEvent switchHandEvent) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(switchHandEvent, "switchHandEvent");
        if (switchHandEvent.isHandCheck()) {
            com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.INSTANCE.setTakePhotoType(0);
            this.cameraController.stopAnalyze();
            com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$$ExternalSyntheticLambda22
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.onMessageEvent$lambda$33(this.f$0);
                }
            });
            getBinding().takePhotoBtn.setVisibility(0);
            return;
        }
        com.up366.mobile.course.photoanswer.logic.helper.SwitchHandHelper.INSTANCE.setTakePhotoType(1);
        getBinding().takePhotoBtn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMessageEvent$lambda$33(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        photoAnswerMainActivity.getBinding().borderView.clear();
        com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel = photoAnswerMainActivity.tipTxtViewModel;
        if (tipTxtViewModel == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("tipTxtViewModel");
            tipTxtViewModel = null;
        }
        tipTxtViewModel.updateStatus(com.up366.mobile.course.photoanswer.logic.model.TipTextStatus.HAND_TAKE_PHOTO);
    }
}
