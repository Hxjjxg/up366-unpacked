package com.up366.mobile.course.photoanswer.result;

/* JADX INFO: compiled from: ScanResultContext.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u001eJ\u0006\u0010\"\u001a\u00020\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006#"}, d2 = {"Lcom/up366/mobile/course/photoanswer/result/ScanResultContext;", "", "activity", "Lcom/up366/mobile/course/photoanswer/PhotoAnswerMainActivity;", "logic", "Lcom/up366/mobile/course/photoanswer/logic/PhotoAnswerLogic;", "cameraController", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController;", "adapter", "Lcom/up366/mobile/course/photoanswer/adpter/PhotoAnswerImageListAdapter;", "<init>", "(Lcom/up366/mobile/course/photoanswer/PhotoAnswerMainActivity;Lcom/up366/mobile/course/photoanswer/logic/PhotoAnswerLogic;Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController;Lcom/up366/mobile/course/photoanswer/adpter/PhotoAnswerImageListAdapter;)V", "getActivity", "()Lcom/up366/mobile/course/photoanswer/PhotoAnswerMainActivity;", "getLogic", "()Lcom/up366/mobile/course/photoanswer/logic/PhotoAnswerLogic;", "getCameraController", "()Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/CameraController;", "getAdapter", "()Lcom/up366/mobile/course/photoanswer/adpter/PhotoAnswerImageListAdapter;", "errorCount", "", "getErrorCount", "()I", "setErrorCount", "(I)V", "countNotAnswerSheet", "getCountNotAnswerSheet", "setCountNotAnswerSheet", "addImage", "", com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE, "Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerImageInfo;", "restartAnalyze", "finishPage", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScanResultContext {
    private final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity activity;
    private final com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter adapter;
    private final com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController cameraController;
    private int countNotAnswerSheet;
    private int errorCount;
    private final com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic logic;

    public ScanResultContext(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity, com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic photoAnswerLogic, com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController cameraController, com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter photoAnswerImageListAdapter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(photoAnswerMainActivity, "activity");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(photoAnswerLogic, "logic");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cameraController, "cameraController");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(photoAnswerImageListAdapter, "adapter");
        this.activity = photoAnswerMainActivity;
        this.logic = photoAnswerLogic;
        this.cameraController = cameraController;
        this.adapter = photoAnswerImageListAdapter;
    }

    public final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity getActivity() {
        return this.activity;
    }

    public final com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic getLogic() {
        return this.logic;
    }

    public final com.up366.mobile.course.photoanswer.logic.cameraAlum.CameraController getCameraController() {
        return this.cameraController;
    }

    public final com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter getAdapter() {
        return this.adapter;
    }

    public final int getErrorCount() {
        return this.errorCount;
    }

    public final void setErrorCount(int i) {
        this.errorCount = i;
    }

    public final int getCountNotAnswerSheet() {
        return this.countNotAnswerSheet;
    }

    public final void setCountNotAnswerSheet(int i) {
        this.countNotAnswerSheet = i;
    }

    public final void addImage(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo image) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(image, com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE);
        this.activity.addImageAndShow(image);
    }

    public final void restartAnalyze() {
        this.cameraController.startAnalyze();
    }

    public final void finishPage() {
        this.activity.finish();
    }
}
