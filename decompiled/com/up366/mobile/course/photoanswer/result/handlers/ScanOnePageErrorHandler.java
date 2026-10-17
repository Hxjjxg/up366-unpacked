package com.up366.mobile.course.photoanswer.result.handlers;

/* JADX INFO: compiled from: ScanOnePageErrorHandler.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u0010"}, d2 = {"Lcom/up366/mobile/course/photoanswer/result/handlers/ScanOnePageErrorHandler;", "Lcom/up366/mobile/course/photoanswer/result/ScanResultHandler;", "<init>", "()V", "handle", "", "result", "Lcom/up366/mobile/course/photoanswer/logic/model/ScanOnePageResult;", "context", "Lcom/up366/mobile/course/photoanswer/result/ScanResultContext;", "handleSomeError", "", "errorCode", "", "handleUnpackPage", "handleAutoFixResult", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScanOnePageErrorHandler implements com.up366.mobile.course.photoanswer.result.ScanResultHandler {
    @Override // com.up366.mobile.course.photoanswer.result.ScanResultHandler
    public boolean handle(com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult result, com.up366.mobile.course.photoanswer.result.ScanResultContext context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo = result.getImageInfo();
        kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo);
        int errorCode = imageInfo.getErrorCode();
        if (errorCode == 42) {
            handleUnpackPage(result, context);
            return true;
        }
        if (!kotlin.collections.ArraysKt.contains(new java.lang.Integer[]{12, 13, 14, 15, 16, 17, 18, 19, 37, 38}, java.lang.Integer.valueOf(errorCode))) {
            return false;
        }
        handleSomeError(errorCode, result, context);
        return true;
    }

    private final void handleSomeError(int errorCode, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult result, com.up366.mobile.course.photoanswer.result.ScanResultContext context) {
        context.setErrorCount(context.getErrorCount() + 1);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        java.util.Map map = (java.util.Map) jSONObject;
        map.put("errorCount", java.lang.Integer.valueOf(context.getErrorCount()));
        map.put("errorCode", java.lang.Integer.valueOf(errorCode));
        map.put("isAllowAutoFix", java.lang.Boolean.valueOf(!result.getIsV3Paper()));
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.showDialog((android.app.Activity) context.getActivity(), com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_REGISTER, new com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler.AnonymousClass1(context, result, this), jSONObject);
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler$handleSomeError$1, reason: invalid class name */
    /* JADX INFO: compiled from: ScanOnePageErrorHandler.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/up366/mobile/course/photoanswer/result/handlers/ScanOnePageErrorHandler$handleSomeError$1", "Lcom/up366/mobile/course/photoanswer/dialog/Dialog2Helper$IDialogCallback;", "onCallback", "", "code", "", "info", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback {
        final /* synthetic */ com.up366.mobile.course.photoanswer.result.ScanResultContext $context;
        final /* synthetic */ com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult $result;
        final /* synthetic */ com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler this$0;

        AnonymousClass1(com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler scanOnePageErrorHandler) {
            this.$context = scanResultContext;
            this.$result = scanOnePageResult;
            this.this$0 = scanOnePageErrorHandler;
        }

        @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
        public void onCallback(int code, java.lang.Object info) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
            if (code == 0) {
                int iIntValue = ((java.lang.Integer) info).intValue();
                if (iIntValue == 1) {
                    this.$context.getActivity().skipOnlineAnswer();
                    return;
                }
                if (iIntValue == 2) {
                    final com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext = this.$context;
                    final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult = this.$result;
                    final com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler scanOnePageErrorHandler = this.this$0;
                    com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler$handleSomeError$1$$ExternalSyntheticLambda0
                        @Override // com.up366.common.task.Task
                        public final void run() {
                            com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler.AnonymousClass1.onCallback$lambda$2(scanResultContext, scanOnePageResult, scanOnePageErrorHandler);
                        }
                    });
                    return;
                }
                com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo = this.$result.getImageInfo();
                kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo);
                imageInfo.setForceUse(true);
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity activity = this.$context.getActivity();
                com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo2 = this.$result.getImageInfo();
                kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo2);
                activity.addImageAndShow(imageInfo2);
                this.$context.getCameraController().startAnalyze();
                return;
            }
            this.$context.getCameraController().startAnalyze();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCallback$lambda$2(final com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext, final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, final com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler scanOnePageErrorHandler) {
            final com.up366.mobile.course.photoanswer.dialog.PhotoAnswerAutoFixingDialog photoAnswerAutoFixingDialog = new com.up366.mobile.course.photoanswer.dialog.PhotoAnswerAutoFixingDialog((android.content.Context) scanResultContext.getActivity());
            photoAnswerAutoFixingDialog.show();
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler$handleSomeError$1$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler.AnonymousClass1.onCallback$lambda$2$lambda$1(scanResultContext, scanOnePageResult, photoAnswerAutoFixingDialog, scanOnePageErrorHandler);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCallback$lambda$2$lambda$1(final com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, final com.up366.mobile.course.photoanswer.dialog.PhotoAnswerAutoFixingDialog photoAnswerAutoFixingDialog, final com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler scanOnePageErrorHandler) {
            final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResultScanOnePageAutoFix = scanResultContext.getLogic().scanOnePageAutoFix(scanOnePageResult);
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler$handleSomeError$1$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler.AnonymousClass1.onCallback$lambda$2$lambda$1$lambda$0(photoAnswerAutoFixingDialog, scanOnePageErrorHandler, scanOnePageResultScanOnePageAutoFix, scanResultContext);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCallback$lambda$2$lambda$1$lambda$0(com.up366.mobile.course.photoanswer.dialog.PhotoAnswerAutoFixingDialog photoAnswerAutoFixingDialog, com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler scanOnePageErrorHandler, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext) {
            photoAnswerAutoFixingDialog.dismiss();
            scanOnePageErrorHandler.handleAutoFixResult(scanOnePageResult, scanResultContext);
        }
    }

    private final void handleUnpackPage(com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult result, com.up366.mobile.course.photoanswer.result.ScanResultContext context) {
        context.setErrorCount(context.getErrorCount() + 1);
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        java.util.Map map = (java.util.Map) jSONObject;
        map.put("errorCount", java.lang.Integer.valueOf(context.getErrorCount()));
        map.put("isAllowAutoFix", java.lang.Boolean.valueOf(!result.getIsV3Paper()));
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE.showDialog((android.app.Activity) context.getActivity(), com.up366.mobile.course.photoanswer.dialog.DialogType.BINDING_DEFECT, new com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler.C00811(context, result, this), jSONObject);
    }

    /* JADX INFO: renamed from: com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler$handleUnpackPage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ScanOnePageErrorHandler.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/up366/mobile/course/photoanswer/result/handlers/ScanOnePageErrorHandler$handleUnpackPage$1", "Lcom/up366/mobile/course/photoanswer/dialog/Dialog2Helper$IDialogCallback;", "onCallback", "", "code", "", "info", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C00811 implements com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback {
        final /* synthetic */ com.up366.mobile.course.photoanswer.result.ScanResultContext $context;
        final /* synthetic */ com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult $result;
        final /* synthetic */ com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler this$0;

        C00811(com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler scanOnePageErrorHandler) {
            this.$context = scanResultContext;
            this.$result = scanOnePageResult;
            this.this$0 = scanOnePageErrorHandler;
        }

        @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
        public void onCallback(int code, java.lang.Object info) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
            if (code == 0) {
                int iIntValue = ((java.lang.Integer) info).intValue();
                if (iIntValue == 1) {
                    this.$context.getActivity().skipOnlineAnswer();
                    return;
                }
                if (iIntValue == 2) {
                    final com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext = this.$context;
                    final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult = this.$result;
                    final com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler scanOnePageErrorHandler = this.this$0;
                    com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler$handleUnpackPage$1$$ExternalSyntheticLambda0
                        @Override // com.up366.common.task.Task
                        public final void run() {
                            com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler.C00811.onCallback$lambda$2(scanResultContext, scanOnePageResult, scanOnePageErrorHandler);
                        }
                    });
                    return;
                }
                com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo = this.$result.getImageInfo();
                kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo);
                imageInfo.setForceUse(true);
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity activity = this.$context.getActivity();
                com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo2 = this.$result.getImageInfo();
                kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo2);
                activity.addImageAndShow(imageInfo2);
                this.$context.getCameraController().startAnalyze();
                return;
            }
            this.$context.getCameraController().startAnalyze();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCallback$lambda$2(final com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext, final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, final com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler scanOnePageErrorHandler) {
            final com.up366.mobile.course.photoanswer.dialog.PhotoAnswerAutoFixingDialog photoAnswerAutoFixingDialog = new com.up366.mobile.course.photoanswer.dialog.PhotoAnswerAutoFixingDialog((android.content.Context) scanResultContext.getActivity());
            photoAnswerAutoFixingDialog.show();
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler$handleUnpackPage$1$$ExternalSyntheticLambda2
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler.C00811.onCallback$lambda$2$lambda$1(scanResultContext, scanOnePageResult, photoAnswerAutoFixingDialog, scanOnePageErrorHandler);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCallback$lambda$2$lambda$1(final com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, final com.up366.mobile.course.photoanswer.dialog.PhotoAnswerAutoFixingDialog photoAnswerAutoFixingDialog, final com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler scanOnePageErrorHandler) {
            final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResultScanOnePageAutoFix = scanResultContext.getLogic().scanOnePageAutoFix(scanOnePageResult);
            com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler$handleUnpackPage$1$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() {
                    com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler.C00811.onCallback$lambda$2$lambda$1$lambda$0(photoAnswerAutoFixingDialog, scanOnePageErrorHandler, scanOnePageResultScanOnePageAutoFix, scanResultContext);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onCallback$lambda$2$lambda$1$lambda$0(com.up366.mobile.course.photoanswer.dialog.PhotoAnswerAutoFixingDialog photoAnswerAutoFixingDialog, com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler scanOnePageErrorHandler, com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext) {
            photoAnswerAutoFixingDialog.dismiss();
            scanOnePageErrorHandler.handleAutoFixResult(scanOnePageResult, scanResultContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAutoFixResult(com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult result, com.up366.mobile.course.photoanswer.result.ScanResultContext context) {
        try {
            com.up366.mobile.course.photoanswer.logic.helper.TXPathHelper tXPathHelper = com.up366.mobile.course.photoanswer.logic.helper.TXPathHelper.INSTANCE;
            java.lang.String filePath = result.getPaperCodeModel().getFilePath();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
            java.lang.String takePhotoCropPath = tXPathHelper.getTakePhotoCropPath(filePath);
            java.util.Map jSONObject = new com.alibaba.fastjson.JSONObject();
            jSONObject.put("code", java.lang.Integer.valueOf(result.getCode()));
            java.lang.String strSubstring = takePhotoCropPath.substring(kotlin.text.StringsKt.lastIndexOf$default(takePhotoCropPath, "/", 0, false, 6, (java.lang.Object) null) + 1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            jSONObject.put("localPath", strSubstring);
            jSONObject.put("status", "补角成功");
            java.util.Map map = jSONObject;
            com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo = result.getImageInfo();
            map.put("engineCode", java.lang.Integer.valueOf(imageInfo != null ? imageInfo.getErrorCode() : -1));
            if (result.getCode() != 0 && result.getCode() != -104) {
                jSONObject.put("status", "补角失败");
            }
            com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLogWithUploadFile("autoFixResult", (com.alibaba.fastjson.JSONObject) jSONObject, takePhotoCropPath);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("handleAutoFixResult error: " + e.getMessage());
        }
        if (context.getActivity().scanOnePageResultOk(result)) {
            return;
        }
        if (result.getCode() == -104) {
            com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity activity = context.getActivity();
            com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo2 = result.getImageInfo();
            kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo2);
            activity.addImageAndShow(imageInfo2);
            com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity activity2 = context.getActivity();
            com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo3 = result.getImageInfo();
            kotlin.jvm.internal.Intrinsics.checkNotNull(imageInfo3);
            activity2.promptPageRepeat(imageInfo3);
            return;
        }
        context.getActivity().showDialogByType(com.up366.mobile.course.photoanswer.dialog.DialogType.COMMON_ERROR_DIALOG, context.getErrorCount(), result, "补角失败");
    }
}
