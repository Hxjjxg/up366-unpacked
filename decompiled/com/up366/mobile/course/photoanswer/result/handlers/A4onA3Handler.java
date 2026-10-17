package com.up366.mobile.course.photoanswer.result.handlers;

/* JADX INFO: compiled from: A4onA3Handler.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/up366/mobile/course/photoanswer/result/handlers/A4onA3Handler;", "Lcom/up366/mobile/course/photoanswer/result/ScanResultHandler;", "<init>", "()V", "handle", "", "result", "Lcom/up366/mobile/course/photoanswer/logic/model/ScanOnePageResult;", "context", "Lcom/up366/mobile/course/photoanswer/result/ScanResultContext;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class A4onA3Handler implements com.up366.mobile.course.photoanswer.result.ScanResultHandler {
    @Override // com.up366.mobile.course.photoanswer.result.ScanResultHandler
    public boolean handle(com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult result, com.up366.mobile.course.photoanswer.result.ScanResultContext context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        context.setErrorCount(context.getErrorCount() + 1);
        com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.showDialogByType$default(context.getActivity(), com.up366.mobile.course.photoanswer.dialog.DialogType.ERROR_RS_2A4_ON_1A3, context.getErrorCount(), result, null, 8, null);
        return true;
    }
}
