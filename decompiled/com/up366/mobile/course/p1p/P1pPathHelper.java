package com.up366.mobile.course.p1p;

/* JADX INFO: compiled from: P1pPathHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/up366/mobile/course/p1p/P1pPathHelper;", "", "<init>", "()V", "jobId", "", "getJobId", "()Ljava/lang/String;", "setJobId", "(Ljava/lang/String;)V", "init", "", "getScanWorkPath", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class P1pPathHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.course.p1p.P1pPathHelper.Companion INSTANCE = new com.up366.mobile.course.p1p.P1pPathHelper.Companion(null);
    public java.lang.String jobId;

    @kotlin.jvm.JvmStatic
    public static final java.lang.String getTakePhotoPath() {
        return INSTANCE.getTakePhotoPath();
    }

    @kotlin.jvm.JvmStatic
    public static final java.lang.String getTaskWorkPathRoot() {
        return INSTANCE.getTaskWorkPathRoot();
    }

    public final java.lang.String getJobId() {
        java.lang.String str = this.jobId;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("jobId");
        return null;
    }

    public final void setJobId(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jobId = str;
    }

    public final void init(java.lang.String jobId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jobId, "jobId");
        setJobId(jobId);
    }

    public final java.lang.String getScanWorkPath() {
        return INSTANCE.getTaskWorkPathRoot() + com.up366.mobile.common.logic.Auth.UID() + "_" + getJobId() + "/scanWork/";
    }

    /* JADX INFO: compiled from: P1pPathHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/up366/mobile/course/p1p/P1pPathHelper$Companion;", "", "<init>", "()V", "getTaskWorkPathRoot", "", "getTakePhotoPath", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final java.lang.String getTaskWorkPathRoot() {
            return com.up366.common.global.GB.get().getApplicationContext().getFilesDir().getAbsolutePath() + "/scanPaper/";
        }

        @kotlin.jvm.JvmStatic
        public final java.lang.String getTakePhotoPath() {
            return getTaskWorkPathRoot() + "images/";
        }
    }
}
