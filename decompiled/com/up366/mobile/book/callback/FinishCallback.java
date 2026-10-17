package com.up366.mobile.book.callback;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FinishCallback implements com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface {
    private final java.lang.ref.WeakReference<com.up366.mobile.book.StudyActivityInterface> activityRef;

    public FinishCallback(com.up366.mobile.book.StudyActivityInterface studyActivityInterface) {
        this.activityRef = new java.lang.ref.WeakReference<>(studyActivityInterface);
    }

    @Override // com.up366.mobile.book.webview.StudyPageWebView.IOnFinishedInterface
    public void onFinish() {
        final com.up366.mobile.book.StudyActivityInterface studyActivityInterface = this.activityRef.get();
        if (studyActivityInterface != null) {
            com.up366.common.task.TaskUtils.postMainTaskDelay(50L, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.callback.FinishCallback$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    studyActivityInterface.showLoading(false);
                }
            });
        }
    }
}
