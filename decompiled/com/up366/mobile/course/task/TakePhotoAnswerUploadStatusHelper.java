package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TakePhotoAnswerUploadStatusHelper {
    public boolean hasUploadingTask(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        for (com.up366.mobile.common.logic.log.model.BatchUploadLog batchUploadLog : com.up366.mobile.common.logic.Auth.cur().logMgr().getTaskList()) {
            if (batchUploadLog.getType() == 24 && batchUploadLog.getRefKey().equals(taskInfoV2.getJobId())) {
                return true;
            }
        }
        return false;
    }

    public void submit(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        com.up366.mobile.common.logic.Auth.cur().logMgr().startBatchQueue();
    }
}
