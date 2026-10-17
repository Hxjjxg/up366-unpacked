package com.up366.mobile.course.photoanswer.logic.model;

/* JADX INFO: compiled from: ScanOnePageResult.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/model/ScanOnePageResult;", "", "<init>", "()V", "isV3Paper", "", "()Z", "setV3Paper", "(Z)V", "code", "", "getCode", "()I", "setCode", "(I)V", "paperCodeModel", "Lcom/up366/mobile/course/photoanswer/logic/model/PaperCodeModel;", "getPaperCodeModel", "()Lcom/up366/mobile/course/photoanswer/logic/model/PaperCodeModel;", "setPaperCodeModel", "(Lcom/up366/mobile/course/photoanswer/logic/model/PaperCodeModel;)V", "imageInfo", "Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerImageInfo;", "getImageInfo", "()Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerImageInfo;", "setImageInfo", "(Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerImageInfo;)V", "toString", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScanOnePageResult {
    private int code;
    private com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo;
    private boolean isV3Paper;
    private com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel paperCodeModel = new com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel();

    /* JADX INFO: renamed from: isV3Paper, reason: from getter */
    public final boolean getIsV3Paper() {
        return this.isV3Paper;
    }

    public final void setV3Paper(boolean z) {
        this.isV3Paper = z;
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel getPaperCodeModel() {
        return this.paperCodeModel;
    }

    public final void setPaperCodeModel(com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel paperCodeModel) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paperCodeModel, "<set-?>");
        this.paperCodeModel = paperCodeModel;
    }

    public final com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo getImageInfo() {
        return this.imageInfo;
    }

    public final void setImageInfo(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo) {
        this.imageInfo = photoAnswerImageInfo;
    }

    public java.lang.String toString() {
        return "ScanOnePageResult(code=" + this.code + ", paperCodeModel=" + this.paperCodeModel + ", imageInfo=" + this.imageInfo + ")";
    }
}
