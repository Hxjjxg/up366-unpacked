package com.up366.mobile.course.photoanswer.logic.model;

/* JADX INFO: compiled from: PhotoAnswerLayoutInfo.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerLayoutInfo;", "", "<init>", "()V", "subjectType", "", "getSubjectType", "()I", "setSubjectType", "(I)V", "printType", "getPrintType", "setPrintType", "layoutJson", "", "getLayoutJson", "()Ljava/lang/String;", "setLayoutJson", "(Ljava/lang/String;)V", "toString", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerLayoutInfo {
    private int subjectType = 1;
    private int printType = 1;
    private java.lang.String layoutJson = "";

    public final int getSubjectType() {
        return this.subjectType;
    }

    public final void setSubjectType(int i) {
        this.subjectType = i;
    }

    public final int getPrintType() {
        return this.printType;
    }

    public final void setPrintType(int i) {
        this.printType = i;
    }

    public final java.lang.String getLayoutJson() {
        return this.layoutJson;
    }

    public final void setLayoutJson(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.layoutJson = str;
    }

    public java.lang.String toString() {
        return "PhotoAnswerLayoutInfo(subjectType=" + this.subjectType + ", printType=" + this.printType + ", layoutJson=" + this.layoutJson + ")";
    }
}
