package com.up366.mobile.course.task.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class CompletedTaskAndStudyPlan {
    private java.util.List<com.up366.mobile.course.task.model.TaskCompletedInfo> finishedList;
    private java.util.List<com.up366.mobile.course.task.model.ReturnedInfo> returnedList;
    private java.util.List<com.up366.mobile.course.task.model.StudyPlanInfo> studyPlanList;
    private java.lang.String version;

    public java.lang.String getVersion() {
        return this.version;
    }

    public void setVersion(java.lang.String str) {
        this.version = str;
    }

    public java.util.List<com.up366.mobile.course.task.model.TaskCompletedInfo> getFinishedList() {
        return this.finishedList;
    }

    public void setFinishedList(java.util.List<com.up366.mobile.course.task.model.TaskCompletedInfo> list) {
        this.finishedList = list;
    }

    public java.util.List<com.up366.mobile.course.task.model.StudyPlanInfo> getStudyPlanList() {
        return this.studyPlanList;
    }

    public void setStudyPlanList(java.util.List<com.up366.mobile.course.task.model.StudyPlanInfo> list) {
        this.studyPlanList = list;
    }

    public java.util.List<com.up366.mobile.course.task.model.ReturnedInfo> getReturnedList() {
        return this.returnedList;
    }

    public void setReturnedList(java.util.List<com.up366.mobile.course.task.model.ReturnedInfo> list) {
        this.returnedList = list;
    }

    public void sortCompletedTaskInfo() {
        java.util.List<com.up366.mobile.course.task.model.TaskCompletedInfo> list = this.finishedList;
        if (list == null) {
            return;
        }
        java.util.Collections.sort(list, new java.util.Comparator() { // from class: com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                return com.up366.mobile.course.task.model.CompletedTaskAndStudyPlan.lambda$sortCompletedTaskInfo$0((com.up366.mobile.course.task.model.TaskCompletedInfo) obj, (com.up366.mobile.course.task.model.TaskCompletedInfo) obj2);
            }
        });
    }

    static /* synthetic */ int lambda$sortCompletedTaskInfo$0(com.up366.mobile.course.task.model.TaskCompletedInfo taskCompletedInfo, com.up366.mobile.course.task.model.TaskCompletedInfo taskCompletedInfo2) {
        if (taskCompletedInfo.getAddDate() < taskCompletedInfo2.getAddDate()) {
            return -1;
        }
        return taskCompletedInfo.getAddDate() > taskCompletedInfo2.getAddDate() ? 1 : 0;
    }
}
