package com.up366.mobile.course.photoanswer.logic.model;

/* JADX INFO: compiled from: PhotoAnswerCheckResult.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerCheckResult;", "", "<init>", "()V", "checkResult", "", "getCheckResult", "()I", "setCheckResult", "(I)V", "subjectType", "getSubjectType", "setSubjectType", "toString", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerCheckResult {
    private int checkResult;
    private int subjectType;

    public final int getCheckResult() {
        return this.checkResult;
    }

    public final void setCheckResult(int i) {
        this.checkResult = i;
    }

    public final int getSubjectType() {
        return this.subjectType;
    }

    public final void setSubjectType(int i) {
        this.subjectType = i;
    }

    public java.lang.String toString() {
        return "PhotoAnswerCheckResult(checkResult=" + this.checkResult + ", subjectType=" + this.subjectType + ")";
    }
}
