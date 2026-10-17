package com.up366.mobile.course.photoanswer.result.handlers;

/* JADX INFO: compiled from: PageNumberHandler.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/up366/mobile/course/photoanswer/result/handlers/PageNumberHandler;", "Lcom/up366/mobile/course/photoanswer/result/ScanResultHandler;", "<init>", "()V", "handle", "", "result", "Lcom/up366/mobile/course/photoanswer/logic/model/ScanOnePageResult;", "context", "Lcom/up366/mobile/course/photoanswer/result/ScanResultContext;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PageNumberHandler implements com.up366.mobile.course.photoanswer.result.ScanResultHandler {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.course.photoanswer.result.ScanResultHandler
    public boolean handle(com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult result, com.up366.mobile.course.photoanswer.result.ScanResultContext context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        java.util.Map map = (java.util.Map) jSONObject;
        com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo = result.getImageInfo();
        kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo);
        map.put("isA3", java.lang.Integer.valueOf(imageInfo.isA3() ? 1 : 0));
        com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo2 = result.getImageInfo();
        kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo2);
        map.put("totalPageNo", java.lang.Integer.valueOf(imageInfo2.getTotalImageCount()));
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.showDialog((android.app.Activity) context.getActivity(), com.up366.mobile.course.photoanswer.dialog.DialogType.UPDATE_PAPER_NUMBER, new com.up366.mobile.course.photoanswer.result.handlers.PageNumberHandler.AnonymousClass1(context, result), jSONObject);
        return true;
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.photoanswer.result.handlers.PageNumberHandler$handle$1, reason: invalid class name */
    /* JADX INFO: compiled from: PageNumberHandler.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/up366/mobile/course/photoanswer/result/handlers/PageNumberHandler$handle$1", "Lcom/up366/mobile/course/photoanswer/dialog/Dialog2Helper$IDialogCallback;", "onCallback", "", "code", "", "info", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback {
        final /* synthetic */ com.up366.mobile.course.photoanswer.result.ScanResultContext $context;
        final /* synthetic */ com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult $result;

        AnonymousClass1(com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult) {
            this.$context = scanResultContext;
            this.$result = scanOnePageResult;
        }

        @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
        public void onCallback(int code, java.lang.Object info) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
            if (code == 0) {
                this.$context.restartAnalyze();
                return;
            }
            final int iIntValue = ((java.lang.Integer) info).intValue();
            this.$context.getActivity().showLoadingView();
            final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult = this.$result;
            final com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext = this.$context;
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.result.handlers.PageNumberHandler$handle$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.course.photoanswer.result.handlers.PageNumberHandler.AnonymousClass1.onCallback$lambda$1(scanOnePageResult, scanResultContext, iIntValue);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCallback$lambda$1(com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, final com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext, int i) {
            final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResultScanOnePage;
            if (scanOnePageResult.getIsV3Paper()) {
                com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic logic = scanResultContext.getLogic();
                java.lang.String filePath = scanOnePageResult.getPaperCodeModel().getFilePath();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
                scanOnePageResultScanOnePage = com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic.scanV3OnePage$default(logic, filePath, null, java.lang.String.valueOf(i), 2, null);
            } else {
                scanOnePageResultScanOnePage = scanResultContext.getLogic().scanOnePage(scanOnePageResult, i);
            }
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.result.handlers.PageNumberHandler$handle$1$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.course.photoanswer.result.handlers.PageNumberHandler.AnonymousClass1.onCallback$lambda$1$lambda$0(scanResultContext, scanOnePageResultScanOnePage);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCallback$lambda$1$lambda$0(com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult) {
            scanResultContext.getActivity().hideLoadingView();
            scanResultContext.getActivity().handleResult(scanOnePageResult);
        }
    }
}
