package com.up366.mobile.course.task.model;

/* JADX INFO: compiled from: Bean.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/up366/mobile/course/task/model/HistroyFilterCondition;", "", "status", "", "month", "", "course", "Lcom/up366/mobile/course/mgr/CourseInfo;", "<init>", "(ILjava/lang/String;Lcom/up366/mobile/course/mgr/CourseInfo;)V", "getStatus", "()I", "setStatus", "(I)V", "getMonth", "()Ljava/lang/String;", "setMonth", "(Ljava/lang/String;)V", "getCourse", "()Lcom/up366/mobile/course/mgr/CourseInfo;", "setCourse", "(Lcom/up366/mobile/course/mgr/CourseInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class HistroyFilterCondition {
    private com.up366.mobile.course.mgr.CourseInfo course;
    private java.lang.String month;
    private int status;

    public static /* synthetic */ com.up366.mobile.course.task.model.HistroyFilterCondition copy$default(com.up366.mobile.course.task.model.HistroyFilterCondition histroyFilterCondition, int i, java.lang.String str, com.up366.mobile.course.mgr.CourseInfo courseInfo, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            i = histroyFilterCondition.status;
        }
        if ((i2 & 2) != 0) {
            str = histroyFilterCondition.month;
        }
        if ((i2 & 4) != 0) {
            courseInfo = histroyFilterCondition.course;
        }
        return histroyFilterCondition.copy(i, str, courseInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final java.lang.String getMonth() {
        return this.month;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final com.up366.mobile.course.mgr.CourseInfo getCourse() {
        return this.course;
    }

    public final com.up366.mobile.course.task.model.HistroyFilterCondition copy(int status, java.lang.String month, com.up366.mobile.course.mgr.CourseInfo course) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(month, "month");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(course, "course");
        return new com.up366.mobile.course.task.model.HistroyFilterCondition(status, month, course);
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof com.up366.mobile.course.task.model.HistroyFilterCondition)) {
            return false;
        }
        com.up366.mobile.course.task.model.HistroyFilterCondition histroyFilterCondition = (com.up366.mobile.course.task.model.HistroyFilterCondition) other;
        return this.status == histroyFilterCondition.status && kotlin.jvm.internal.Intrinsics.areEqual(this.month, histroyFilterCondition.month) && kotlin.jvm.internal.Intrinsics.areEqual(this.course, histroyFilterCondition.course);
    }

    public int hashCode() {
        return (((this.status * 31) + this.month.hashCode()) * 31) + this.course.hashCode();
    }

    public java.lang.String toString() {
        return "HistroyFilterCondition(status=" + this.status + ", month=" + this.month + ", course=" + this.course + ")";
    }

    public HistroyFilterCondition(int i, java.lang.String str, com.up366.mobile.course.mgr.CourseInfo courseInfo) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "month");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(courseInfo, "course");
        this.status = i;
        this.month = str;
        this.course = courseInfo;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public /* synthetic */ HistroyFilterCondition(int i, java.lang.String str, com.up366.mobile.course.mgr.CourseInfo courseInfo, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, courseInfo);
    }

    public final java.lang.String getMonth() {
        return this.month;
    }

    public final void setMonth(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.month = str;
    }

    public final com.up366.mobile.course.mgr.CourseInfo getCourse() {
        return this.course;
    }

    public final void setCourse(com.up366.mobile.course.mgr.CourseInfo courseInfo) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(courseInfo, "<set-?>");
        this.course = courseInfo;
    }
}
