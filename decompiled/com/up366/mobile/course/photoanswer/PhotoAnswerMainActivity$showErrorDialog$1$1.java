package com.up366.mobile.course.photoanswer;

/* JADX INFO: compiled from: PhotoAnswerMainActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/up366/mobile/course/photoanswer/PhotoAnswerMainActivity$showErrorDialog$1$1", "Lcom/up366/mobile/course/photoanswer/dialog/Dialog2Helper$IDialogCallback;", "onCallback", "", "code", "", "info", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerMainActivity$showErrorDialog$1$1 implements com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback {
    final /* synthetic */ com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity this$0;

    PhotoAnswerMainActivity$showErrorDialog$1$1(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        this.this$0 = photoAnswerMainActivity;
    }

    @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
    public void onCallback(int code, java.lang.Object info) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
        if (code == 0) {
            this.this$0.finish();
        } else if (code == 1) {
            final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity = this.this$0;
            com.up366.common.task.TaskUtils.postMainTaskDelay(100L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$showErrorDialog$1$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$showErrorDialog$1$1.onCallback$lambda$1(photoAnswerMainActivity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCallback$lambda$1(final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        photoAnswerMainActivity.showSubmitUploading();
        com.up366.mobile.common.logic.Auth.cur().logMgr().startBatchQueue();
        com.up366.common.task.TaskUtils.postMainTaskDelay(1200L, new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$showErrorDialog$1$1$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity$showErrorDialog$1$1.onCallback$lambda$1$lambda$0(photoAnswerMainActivity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCallback$lambda$1$lambda$0(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        if (photoAnswerMainActivity.uploadSuccess) {
            photoAnswerMainActivity.showSuccessPage();
        }
    }
}
