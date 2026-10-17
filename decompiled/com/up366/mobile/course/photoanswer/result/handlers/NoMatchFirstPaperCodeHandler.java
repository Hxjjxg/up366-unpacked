package com.up366.mobile.course.photoanswer.result.handlers;

/* JADX INFO: compiled from: NoMatchFirstPaperCodeHandler.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/up366/mobile/course/photoanswer/result/handlers/NoMatchFirstPaperCodeHandler;", "Lcom/up366/mobile/course/photoanswer/result/ScanResultHandler;", "<init>", "()V", "handle", "", "result", "Lcom/up366/mobile/course/photoanswer/logic/model/ScanOnePageResult;", "context", "Lcom/up366/mobile/course/photoanswer/result/ScanResultContext;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NoMatchFirstPaperCodeHandler implements com.up366.mobile.course.photoanswer.result.ScanResultHandler {
    @Override // com.up366.mobile.course.photoanswer.result.ScanResultHandler
    public boolean handle(com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult result, com.up366.mobile.course.photoanswer.result.ScanResultContext context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        ((java.util.Map) jSONObject).put("paperCode", context.getLogic().getCacheHelper().getPaperCode());
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.showDialog((android.app.Activity) context.getActivity(), com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_MATCH_FIRST_PAPER_CODE, new com.up366.mobile.course.photoanswer.result.handlers.NoMatchFirstPaperCodeHandler.AnonymousClass1(context, result), jSONObject);
        return true;
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.photoanswer.result.handlers.NoMatchFirstPaperCodeHandler$handle$1, reason: invalid class name */
    /* JADX INFO: compiled from: NoMatchFirstPaperCodeHandler.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/up366/mobile/course/photoanswer/result/handlers/NoMatchFirstPaperCodeHandler$handle$1", "Lcom/up366/mobile/course/photoanswer/dialog/Dialog2Helper$IDialogCallback;", "onCallback", "", "code", "", "info", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback {
        final /* synthetic */ com.up366.mobile.course.photoanswer.result.ScanResultContext $context;
        final /* synthetic */ com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult $result;

        AnonymousClass1(com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult) {
            this.$context = scanResultContext;
            this.$result = scanOnePageResult;
        }

        @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
        public void onCallback(int code, final java.lang.Object info) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
            if (code == 0) {
                this.$context.getCameraController().startAnalyze();
                return;
            }
            this.$context.getActivity().showLoadingView();
            final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult = this.$result;
            final com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext = this.$context;
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.result.handlers.NoMatchFirstPaperCodeHandler$handle$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.course.photoanswer.result.handlers.NoMatchFirstPaperCodeHandler.AnonymousClass1.onCallback$lambda$0(info, scanOnePageResult, scanResultContext);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCallback$lambda$0(java.lang.Object obj, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            scanOnePageResult.getPaperCodeModel().setPaperCode((java.lang.String) obj);
            com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResultScanOnePage = scanResultContext.getLogic().scanOnePage(scanOnePageResult, 0);
            scanResultContext.getActivity().hideLoadingView();
            scanResultContext.getActivity().handleResult(scanOnePageResultScanOnePage);
        }
    }
}
