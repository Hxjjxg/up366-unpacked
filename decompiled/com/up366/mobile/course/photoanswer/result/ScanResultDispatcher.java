package com.up366.mobile.course.photoanswer.result;

/* JADX INFO: compiled from: ScanResultDispatcher.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/up366/mobile/course/photoanswer/result/ScanResultDispatcher;", "", "context", "Lcom/up366/mobile/course/photoanswer/result/ScanResultContext;", "<init>", "(Lcom/up366/mobile/course/photoanswer/result/ScanResultContext;)V", "handlerMap", "", "", "Lcom/up366/mobile/course/photoanswer/result/ScanResultHandler;", "register", "", "defaultHandler", "Lcom/up366/mobile/course/photoanswer/result/handlers/DefaultHandler;", "dispatch", "", "result", "Lcom/up366/mobile/course/photoanswer/logic/model/ScanOnePageResult;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScanResultDispatcher {
    private final com.up366.mobile.course.photoanswer.result.ScanResultContext context;
    private final com.up366.mobile.course.photoanswer.result.handlers.DefaultHandler defaultHandler;
    private final java.util.Map<java.lang.Integer, com.up366.mobile.course.photoanswer.result.ScanResultHandler> handlerMap;

    public ScanResultDispatcher(com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scanResultContext, "context");
        this.context = scanResultContext;
        this.handlerMap = new java.util.LinkedHashMap();
        register();
        this.defaultHandler = new com.up366.mobile.course.photoanswer.result.handlers.DefaultHandler();
    }

    private final void register() {
        this.handlerMap.put(0, new com.up366.mobile.course.photoanswer.result.handlers.OkHandler());
        this.handlerMap.put(-101, new com.up366.mobile.course.photoanswer.result.handlers.NetErrorHandler());
        this.handlerMap.put(-106, new com.up366.mobile.course.photoanswer.result.handlers.NetErrorHandler());
        this.handlerMap.put(-1000, new com.up366.mobile.course.photoanswer.result.handlers.NetErrorHandler());
        this.handlerMap.put(java.lang.Integer.valueOf(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerStatus.V3_LAYOUT_INFO_NET_ERROR), new com.up366.mobile.course.photoanswer.result.handlers.NetErrorHandler());
        this.handlerMap.put(-1001, new com.up366.mobile.course.photoanswer.result.handlers.NetErrorHandler());
        this.handlerMap.put(-109, new com.up366.mobile.course.photoanswer.result.handlers.DistortHandler());
        this.handlerMap.put(-104, new com.up366.mobile.course.photoanswer.result.handlers.RepeatHandler());
        this.handlerMap.put(-102, new com.up366.mobile.course.photoanswer.result.handlers.NoMatchPaperCodeHandler());
        this.handlerMap.put(-100, new com.up366.mobile.course.photoanswer.result.handlers.NoPaperCodeHandler());
        this.handlerMap.put(-110, new com.up366.mobile.course.photoanswer.result.handlers.NotNewPaperHandler());
        this.handlerMap.put(-107, new com.up366.mobile.course.photoanswer.result.handlers.PageNumberHandler());
        this.handlerMap.put(-112, new com.up366.mobile.course.photoanswer.result.handlers.LayoutCheckFailedHandler());
        this.handlerMap.put(-111, new com.up366.mobile.course.photoanswer.result.handlers.A4onA3Handler());
        this.handlerMap.put(-105, new com.up366.mobile.course.photoanswer.result.handlers.NoMatchFirstPaperCodeHandler());
        this.handlerMap.put(-103, new com.up366.mobile.course.photoanswer.result.handlers.ScanOnePageErrorHandler());
    }

    public final boolean dispatch(com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult result) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        com.up366.mobile.course.photoanswer.result.handlers.DefaultHandler defaultHandler = this.handlerMap.get(java.lang.Integer.valueOf(result.getCode()));
        if (defaultHandler == null) {
            defaultHandler = this.defaultHandler;
        }
        if (result.getCode() == -110) {
            com.up366.mobile.course.photoanswer.result.ScanResultContext scanResultContext = this.context;
            scanResultContext.setCountNotAnswerSheet(scanResultContext.getCountNotAnswerSheet() + 1);
        } else {
            this.context.setCountNotAnswerSheet(0);
        }
        return defaultHandler.handle(result, this.context);
    }
}
