package com.up366.mobile.course.photoanswer.viewmodel;

/* JADX INFO: compiled from: TipTxtViewModel.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/up366/mobile/course/photoanswer/viewmodel/TipTxtViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_status", "Landroidx/lifecycle/MutableLiveData;", "Lcom/up366/mobile/course/photoanswer/logic/model/TipTextStatus;", "status", "Landroidx/lifecycle/LiveData;", "getStatus", "()Landroidx/lifecycle/LiveData;", "updateStatus", "", "newStatus", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TipTxtViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<com.up366.mobile.course.photoanswer.logic.model.TipTextStatus> _status = new androidx.lifecycle.MutableLiveData<>();

    public final androidx.lifecycle.LiveData<com.up366.mobile.course.photoanswer.logic.model.TipTextStatus> getStatus() {
        return this._status;
    }

    public final void updateStatus(final com.up366.mobile.course.photoanswer.logic.model.TipTextStatus newStatus) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newStatus, "newStatus");
        com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel.updateStatus$lambda$0(this.f$0, newStatus);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateStatus$lambda$0(com.up366.mobile.course.photoanswer.viewmodel.TipTxtViewModel tipTxtViewModel, com.up366.mobile.course.photoanswer.logic.model.TipTextStatus tipTextStatus) {
        tipTxtViewModel._status.setValue(tipTextStatus);
    }
}
