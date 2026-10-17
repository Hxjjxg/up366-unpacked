package com.up366.mobile.course.photoanswer.logic;

/* JADX INFO: compiled from: PhotoAnswerLogic.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rJ*\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J,\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u0007H\u0002J2\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000fJ\u000e\u0010#\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010$\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001aJ\u0006\u0010(\u001a\u00020&J\b\u0010)\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010*\u001a\u00020\u001a2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180,H\u0002J\u0006\u0010-\u001a\u00020\tJ&\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u000f2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000fJ(\u00102\u001a\u00020\r2\u0006\u00103\u001a\u0002042\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u00105\u001a\u0004\u0018\u0001042\u0006\u0010/\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/PhotoAnswerLogic;", "", "scanSession", "Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;", "<init>", "(Lcom/up366/mobile/course/photoanswer/logic/helper/ScanEngineHelper2$Session;)V", "lastCode", "", "cacheHelper", "Lcom/up366/mobile/course/answersheet/AnswerSheetCacheHelper;", "scanPaperGeneralSubmitData", "Lcom/alibaba/fastjson/JSONObject;", "scanOnePage", "Lcom/up366/mobile/course/photoanswer/logic/model/ScanOnePageResult;", "filepath", "", "scanOnePageResult", "defaultPageNo", "scanOnePageAutoFix", "buildScanOnePageResult", "code", "pageModel", "Lcom/up366/mobile/course/photoanswer/logic/model/PaperCodeModel;", "imageInfo", "Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerImageInfo;", "isV3Paper", "", "scanImage", "autoFix", "createScanOnePageResult", "pageData", "layoutJson", "fetchLayoutInfoSync", "checkPaperCode", "paperCode", "retryByFetchPaperCode", "retryByFetchLayoutInfo", "submitTask", "", "isForce", "submitTaskV2", "getScanPaperGeneralSubmitData", "checkForceHasFullImage", "submitData", "", "getCacheHelper", "scanV3OnePage", "localPath", "paramPaperCode", "paramPaperNo", "getRecognitionResult", "fileInfo", "Lcom/up366/mobile/common/utils/alifile/FileMapInfo;", "doUploadFileSync", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerLogic {
    private final com.up366.mobile.course.answersheet.AnswerSheetCacheHelper cacheHelper;
    private int lastCode;
    private com.alibaba.fastjson.JSONObject scanPaperGeneralSubmitData;
    private final com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session scanSession;

    public PhotoAnswerLogic(com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(session, "scanSession");
        this.scanSession = session;
        this.cacheHelper = new com.up366.mobile.course.answersheet.AnswerSheetCacheHelper();
    }

    public final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePage(java.lang.String filepath) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(filepath, "filepath");
        com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel paperCodeModelRecognizePaperCode = com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE.recognizePaperCode(this.scanSession, filepath);
        if (paperCodeModelRecognizePaperCode.getErrorCode() != 0) {
            if (this.cacheHelper.getPaperCode().length() > 0) {
                paperCodeModelRecognizePaperCode.setErrorCode(0);
                paperCodeModelRecognizePaperCode.setPaperCode(this.cacheHelper.getPaperCode());
                return scanImage$default(this, filepath, paperCodeModelRecognizePaperCode, false, 0, 12, null);
            }
            if (paperCodeModelRecognizePaperCode.getErrorCode() == 23 || paperCodeModelRecognizePaperCode.getErrorCode() == 30 || paperCodeModelRecognizePaperCode.getErrorCode() == 34) {
                com.up366.common.log.Logger.error(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("recognizePaperCode", "error " + paperCodeModelRecognizePaperCode.getErrorCode()));
                com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject("{}");
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(object, "parseObject(...)");
                com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo = new com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo(filepath, object);
                photoAnswerImageInfo.updateErrorCode(paperCodeModelRecognizePaperCode.getErrorCode());
                return buildScanOnePageResult(-110, paperCodeModelRecognizePaperCode, photoAnswerImageInfo, false);
            }
            com.up366.common.log.Logger.error(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("recognizePaperCode", "error " + paperCodeModelRecognizePaperCode.getErrorCode()));
            com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLogAlarm(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002004, paperCodeModelRecognizePaperCode.getErrorCode(), (24 & 4) != 0 ? null : null, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null, (24 & 32) != 0 ? null : new java.lang.String[]{filepath});
            return buildScanOnePageResult(-100, paperCodeModelRecognizePaperCode, null, false);
        }
        int iCheckPaperCode = checkPaperCode(paperCodeModelRecognizePaperCode);
        if (iCheckPaperCode != 0) {
            return buildScanOnePageResult(iCheckPaperCode, paperCodeModelRecognizePaperCode, null, false);
        }
        int iFetchLayoutInfoSync = fetchLayoutInfoSync(paperCodeModelRecognizePaperCode);
        if (iFetchLayoutInfoSync != 0) {
            return buildScanOnePageResult(iFetchLayoutInfoSync, paperCodeModelRecognizePaperCode, null, false);
        }
        return scanImage$default(this, filepath, paperCodeModelRecognizePaperCode, false, 0, 12, null);
    }

    public final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePage(com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult, int defaultPageNo) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scanOnePageResult, "scanOnePageResult");
        com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel paperCodeModel = scanOnePageResult.getPaperCodeModel();
        java.lang.String filePath = paperCodeModel.getFilePath();
        kotlin.jvm.internal.Intrinsics.checkNotNull(filePath);
        return scanImage(filePath, paperCodeModel, false, defaultPageNo);
    }

    public final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageAutoFix(com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scanOnePageResult, "scanOnePageResult");
        com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel paperCodeModel = scanOnePageResult.getPaperCodeModel();
        com.up366.mobile.course.photoanswer.logic.helper.TXPathHelper tXPathHelper = com.up366.mobile.course.photoanswer.logic.helper.TXPathHelper.INSTANCE;
        java.lang.String filePath = paperCodeModel.getFilePath();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
        java.lang.String takePhotoCropPath = tXPathHelper.getTakePhotoCropPath(filePath);
        com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.Companion companion = com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE;
        java.lang.String filePath2 = paperCodeModel.getFilePath();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(filePath2, "getFilePath(...)");
        companion.setPhotoStatusFixed(filePath2, true);
        return scanImage(takePhotoCropPath, paperCodeModel, true, 0);
    }

    private final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult buildScanOnePageResult(int code, com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel pageModel, com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo imageInfo, boolean isV3Paper) {
        com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResult = new com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult();
        this.lastCode = code;
        scanOnePageResult.setV3Paper(isV3Paper);
        scanOnePageResult.setCode(code);
        scanOnePageResult.setPaperCodeModel(pageModel);
        scanOnePageResult.setImageInfo(imageInfo);
        return scanOnePageResult;
    }

    static /* synthetic */ com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanImage$default(com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic photoAnswerLogic, java.lang.String str, com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel paperCodeModel, boolean z, int i, int i2, java.lang.Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return photoAnswerLogic.scanImage(str, paperCodeModel, z, i);
    }

    private final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanImage(java.lang.String filepath, com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel pageModel, boolean autoFix, int defaultPageNo) {
        com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo;
        com.alibaba.fastjson.JSONObject layoutJson = this.cacheHelper.getLayoutJson();
        kotlin.jvm.internal.Intrinsics.checkNotNull(layoutJson);
        java.lang.String jSONString = layoutJson.toJSONString();
        if (autoFix) {
            com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2 scanEngineHelper2 = com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE;
            com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session = this.scanSession;
            kotlin.jvm.internal.Intrinsics.checkNotNull(jSONString);
            java.lang.String paperCode = pageModel.getPaperCode();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(paperCode, "getPaperCode(...)");
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(scanEngineHelper2.scanOneImageAutoFix(session, filepath, jSONString, paperCode, defaultPageNo));
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(object, "parseObject(...)");
            photoAnswerImageInfo = new com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo(filepath, object);
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.setPhotoStatusFixedSuccess(filepath, photoAnswerImageInfo.isCorrectStatusOK());
        } else {
            com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2 scanEngineHelper22 = com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.INSTANCE;
            com.up366.mobile.course.photoanswer.logic.helper.ScanEngineHelper2.Session session2 = this.scanSession;
            kotlin.jvm.internal.Intrinsics.checkNotNull(jSONString);
            java.lang.String paperCode2 = pageModel.getPaperCode();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(paperCode2, "getPaperCode(...)");
            com.alibaba.fastjson.JSONObject object2 = com.alibaba.fastjson.JSON.parseObject(scanEngineHelper22.scanOneImage(session2, filepath, jSONString, paperCode2, defaultPageNo));
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(object2, "parseObject(...)");
            photoAnswerImageInfo = new com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo(filepath, object2);
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.setPhotoStatusSuccess(filepath, photoAnswerImageInfo.isCorrectStatusOK());
        }
        com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo2 = photoAnswerImageInfo;
        com.up366.common.log.Logger.error(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("scanOneImage", "errorCode : " + photoAnswerImageInfo2.getErrorCode()));
        return createScanOnePageResult$default(this, photoAnswerImageInfo2, pageModel, jSONString, filepath, false, 16, null);
    }

    static /* synthetic */ com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult createScanOnePageResult$default(com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic photoAnswerLogic, com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo, com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel paperCodeModel, java.lang.String str, java.lang.String str2, boolean z, int i, java.lang.Object obj) {
        if ((i & 16) != 0) {
            z = false;
        }
        return photoAnswerLogic.createScanOnePageResult(photoAnswerImageInfo, paperCodeModel, str, str2, z);
    }

    private final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult createScanOnePageResult(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo pageData, com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel pageModel, java.lang.String layoutJson, java.lang.String filepath, boolean isV3Paper) {
        if (pageData.getErrorCode() == 28) {
            return buildScanOnePageResult(0, pageModel, pageData, isV3Paper);
        }
        if (!pageData.isCorrectStatusOK()) {
            if (pageData.getErrorCode() == 27 || pageData.getErrorCode() == 31) {
                com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLogAlarm(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002005, pageData.getErrorCode(), (24 & 4) != 0 ? null : null, (24 & 8) != 0 ? null : layoutJson, (24 & 16) != 0 ? null : pageModel.getPaperCode(), (24 & 32) != 0 ? null : new java.lang.String[]{filepath});
                return buildScanOnePageResult(-107, pageModel, pageData, isV3Paper);
            }
            if (pageData.getErrorCode() == 29) {
                com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLogAlarm(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002006, pageData.getErrorCode(), (24 & 4) != 0 ? null : null, (24 & 8) != 0 ? null : layoutJson, (24 & 16) != 0 ? null : pageModel.getPaperCode(), (24 & 32) != 0 ? null : new java.lang.String[]{filepath});
                return buildScanOnePageResult(-112, pageModel, pageData, isV3Paper);
            }
            if (pageData.getErrorCode() == 33) {
                com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLogAlarm(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002006, pageData.getErrorCode(), (24 & 4) != 0 ? null : null, (24 & 8) != 0 ? null : layoutJson, (24 & 16) != 0 ? null : pageModel.getPaperCode(), (24 & 32) != 0 ? null : new java.lang.String[]{filepath});
                return buildScanOnePageResult(-111, pageModel, pageData, isV3Paper);
            }
            if (pageData.getErrorCode() == 36) {
                com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLogWithUploadFile("hasDistort", "status36 ", filepath);
                if (this.lastCode != -109) {
                    com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLogAlarm(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002006, pageData.getErrorCode(), (24 & 4) != 0 ? null : null, (24 & 8) != 0 ? null : layoutJson, (24 & 16) != 0 ? null : pageModel.getPaperCode(), (24 & 32) != 0 ? null : new java.lang.String[]{filepath});
                    return buildScanOnePageResult(-109, pageModel, pageData, isV3Paper);
                }
                return buildScanOnePageResult(0, pageModel, pageData, isV3Paper);
            }
            if (pageModel.getErrorCode() != 23 && pageModel.getErrorCode() != 30 && pageModel.getErrorCode() != 34) {
                com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLogAlarm(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002006, pageData.getErrorCode(), (24 & 4) != 0 ? null : null, (24 & 8) != 0 ? null : layoutJson, (24 & 16) != 0 ? null : pageModel.getPaperCode(), (24 & 32) != 0 ? null : new java.lang.String[]{filepath});
                return buildScanOnePageResult(-103, pageModel, pageData, isV3Paper);
            }
            return buildScanOnePageResult(-110, pageModel, pageData, isV3Paper);
        }
        if (pageData.getImageIndex() > pageData.getTotalImageCount()) {
            com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLogAlarm(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002005, pageData.getErrorCode(), (24 & 4) != 0 ? null : null, (24 & 8) != 0 ? null : layoutJson, (24 & 16) != 0 ? null : pageModel.getPaperCode(), (24 & 32) != 0 ? null : new java.lang.String[]{filepath});
            return buildScanOnePageResult(-107, pageModel, pageData, isV3Paper);
        }
        if (this.cacheHelper.checkSamePageNumber(pageData)) {
            return buildScanOnePageResult(-104, pageModel, pageData, isV3Paper);
        }
        return buildScanOnePageResult(0, pageModel, pageData, isV3Paper);
    }

    private final int fetchLayoutInfoSync(com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel pageModel) {
        java.util.Map layoutJson;
        if (kotlin.jvm.internal.Intrinsics.areEqual(pageModel.getPaperCode(), this.cacheHelper.getLayoutJsonPaperCode()) && (layoutJson = this.cacheHelper.getLayoutJson()) != null && !layoutJson.isEmpty()) {
            return 0;
        }
        com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper photoAnswerNetDataHelper = com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper.INSTANCE;
        java.lang.String paperCode = pageModel.getPaperCode();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(paperCode, "getPaperCode(...)");
        com.up366.common.http.NetHolder<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerLayoutInfo> netHolderFetchLayoutInfoSync = photoAnswerNetDataHelper.fetchLayoutInfoSync(paperCode);
        if (netHolderFetchLayoutInfoSync.resp.isError()) {
            com.up366.common.log.Logger.error(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("TakePhoto", "fetchLayoutInfoSync error"));
            return -101;
        }
        com.up366.mobile.course.answersheet.AnswerSheetCacheHelper answerSheetCacheHelper = this.cacheHelper;
        java.lang.String paperCode2 = pageModel.getPaperCode();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(paperCode2, "getPaperCode(...)");
        answerSheetCacheHelper.setLayoutJson(paperCode2, netHolderFetchLayoutInfoSync.info.getLayoutJson());
        return 0;
    }

    private final int checkPaperCode(com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel pageModel) {
        if (this.cacheHelper.getPaperCode().length() > 0) {
            return !kotlin.jvm.internal.Intrinsics.areEqual(this.cacheHelper.getPaperCode(), pageModel.getPaperCode()) ? -105 : 0;
        }
        java.lang.String paperCode = pageModel.getPaperCode();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(paperCode, "getPaperCode(...)");
        int iCheckPaperCode = checkPaperCode(paperCode);
        if (iCheckPaperCode == -102) {
            com.up366.mobile.course.p1p.log.P1pLogHelper p1pLogHelper = com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE;
            java.lang.String paperCode2 = pageModel.getPaperCode();
            java.lang.String filePath = pageModel.getFilePath();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
            p1pLogHelper.buildLogAlarm(com.up366.mobile.common.helper.AlarmLogHelper.P1p._006002003, 1, (24 & 4) != 0 ? null : null, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : paperCode2, (24 & 32) != 0 ? null : new java.lang.String[]{filePath});
        }
        return iCheckPaperCode;
    }

    public final int checkPaperCode(java.lang.String paperCode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paperCode, "paperCode");
        com.up366.common.http.NetHolder<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerCheckResult> netHolderCheckLayoutIdSync = com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerNetDataHelper.INSTANCE.checkLayoutIdSync(paperCode, this.cacheHelper.getData());
        if (netHolderCheckLayoutIdSync.resp.isError()) {
            if (netHolderCheckLayoutIdSync.resp.getCode() == 1) {
                com.up366.common.log.Logger.error(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("checkLayoutIdSync", "error " + netHolderCheckLayoutIdSync.resp));
                return -102;
            }
            com.up366.common.log.Logger.error(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("checkLayoutIdSync", "error no net, " + netHolderCheckLayoutIdSync.resp.getCode()));
            return -106;
        }
        if (netHolderCheckLayoutIdSync.info.getCheckResult() != 1) {
            com.up366.common.log.Logger.error(com.up366.mobile.course.p1p.log.P1pLogHelper.INSTANCE.buildLog("checkLayoutIdSync", "error " + netHolderCheckLayoutIdSync.info));
            return -102;
        }
        this.cacheHelper.setPaperCode(paperCode);
        return 0;
    }

    public final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult retryByFetchPaperCode(com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel pageModel) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pageModel, "pageModel");
        int iCheckPaperCode = checkPaperCode(pageModel);
        if (iCheckPaperCode != 0) {
            return buildScanOnePageResult(iCheckPaperCode, pageModel, null, false);
        }
        int iFetchLayoutInfoSync = fetchLayoutInfoSync(pageModel);
        if (iFetchLayoutInfoSync != 0) {
            return buildScanOnePageResult(iFetchLayoutInfoSync, pageModel, null, false);
        }
        java.lang.String filePath = pageModel.getFilePath();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
        return scanImage$default(this, filePath, pageModel, false, 0, 12, null);
    }

    public final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult retryByFetchLayoutInfo(com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel pageModel) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pageModel, "pageModel");
        int iFetchLayoutInfoSync = fetchLayoutInfoSync(pageModel);
        if (iFetchLayoutInfoSync != 0) {
            return buildScanOnePageResult(iFetchLayoutInfoSync, pageModel, null, false);
        }
        java.lang.String filePath = pageModel.getFilePath();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(filePath, "getFilePath(...)");
        return scanImage$default(this, filePath, pageModel, false, 0, 12, null);
    }

    public final void submitTask(final boolean isForce) {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic.submitTask$lambda$2(this.f$0, isForce);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitTask$lambda$2(com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic photoAnswerLogic, boolean z) {
        com.alibaba.fastjson.JSONObject jSONObjectBuildOcrTaskJson;
        java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> imageList = photoAnswerLogic.cacheHelper.getImageList();
        if (imageList.isEmpty()) {
            return;
        }
        com.up366.common.log.Logger.info("submitTask submitData size:" + imageList.size() + " ,submitData:" + imageList);
        java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> list = imageList;
        java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> listSortedWith = kotlin.collections.CollectionsKt.sortedWith(list, new java.util.Comparator() { // from class: com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic$submitTask$lambda$2$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return kotlin.comparisons.ComparisonsKt.compareValues(java.lang.Integer.valueOf(((com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) t).getImageIndex()), java.lang.Integer.valueOf(((com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) t2).getImageIndex()));
            }
        });
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        if (z) {
            if (!photoAnswerLogic.checkForceHasFullImage(listSortedWith)) {
                jSONObjectBuildOcrTaskJson = com.up366.mobile.course.answersheet.AnswerSheetSubmitTaskJsonBuilderUtils.INSTANCE.buildForceTaskJson(listSortedWith, linkedHashSet, photoAnswerLogic.cacheHelper);
            } else {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (java.lang.Object obj : list) {
                    if (((com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) obj).isCorrectStatus()) {
                        arrayList.add(obj);
                    }
                }
                jSONObjectBuildOcrTaskJson = com.up366.mobile.course.answersheet.AnswerSheetSubmitTaskJsonBuilderUtils.INSTANCE.buildOcrTaskJson(arrayList, linkedHashSet, photoAnswerLogic.cacheHelper);
            }
        } else {
            jSONObjectBuildOcrTaskJson = com.up366.mobile.course.answersheet.AnswerSheetSubmitTaskJsonBuilderUtils.INSTANCE.buildOcrTaskJson(imageList, linkedHashSet, photoAnswerLogic.cacheHelper);
        }
        com.up366.mobile.course.answersheet.AnswerSheetSubmitHelper.INSTANCE.submit(linkedHashSet, jSONObjectBuildOcrTaskJson, photoAnswerLogic.cacheHelper.getStudyTaskId(), photoAnswerLogic.cacheHelper.getCourseId());
    }

    public final void submitTaskV2() {
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic.submitTaskV2$lambda$3(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void submitTaskV2$lambda$3(com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic photoAnswerLogic) {
        java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> imageList = photoAnswerLogic.cacheHelper.getImageList();
        if (imageList.isEmpty()) {
            return;
        }
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        com.alibaba.fastjson.JSONObject jSONObjectBuildOcrTaskJson = com.up366.mobile.course.answersheet.AnswerSheetSubmitTaskJsonBuilderUtils.INSTANCE.buildOcrTaskJson(imageList, linkedHashSet, photoAnswerLogic.cacheHelper);
        java.util.Map jSONObject = new com.alibaba.fastjson.JSONObject();
        photoAnswerLogic.scanPaperGeneralSubmitData = jSONObject;
        kotlin.jvm.internal.Intrinsics.checkNotNull(jSONObject);
        jSONObject.put("paperId", photoAnswerLogic.cacheHelper.getPaperId());
        java.util.Map map = photoAnswerLogic.scanPaperGeneralSubmitData;
        kotlin.jvm.internal.Intrinsics.checkNotNull(map);
        map.put("paperData", jSONObjectBuildOcrTaskJson);
        com.up366.mobile.course.answersheet.AnswerSheetSubmitHelper.INSTANCE.submit(linkedHashSet, photoAnswerLogic.cacheHelper.getSubmitKey());
    }

    public final com.alibaba.fastjson.JSONObject getScanPaperGeneralSubmitData() {
        return this.scanPaperGeneralSubmitData;
    }

    private final boolean checkForceHasFullImage(java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> submitData) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : submitData) {
            if (((com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) obj).isCorrectStatus()) {
                arrayList.add(obj);
            }
        }
        java.util.ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty() || this.cacheHelper.getNetLayoutImageCount() != arrayList2.size()) {
            return false;
        }
        return this.cacheHelper.checkBlocks(arrayList2);
    }

    public final com.up366.mobile.course.answersheet.AnswerSheetCacheHelper getCacheHelper() {
        return this.cacheHelper;
    }

    public static /* synthetic */ com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanV3OnePage$default(com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic photoAnswerLogic, java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return photoAnswerLogic.scanV3OnePage(str, str2, str3);
    }

    public final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanV3OnePage(java.lang.String localPath, java.lang.String paramPaperCode, java.lang.String paramPaperNo) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(localPath, "localPath");
        com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel paperCodeModel = new com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel();
        java.lang.String str = paramPaperCode;
        paperCodeModel.setPaperCode((str == null || str.length() == 0) ? "" : paramPaperCode);
        paperCodeModel.setFilePath(localPath);
        kotlin.Unit unit = kotlin.Unit.INSTANCE;
        com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult scanOnePageResultBuildScanOnePageResult = buildScanOnePageResult(-1000, paperCodeModel, null, true);
        try {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoDoUploadFileSync = doUploadFileSync(localPath);
            if (fileMapInfoDoUploadFileSync == null) {
                throw new java.lang.Exception("upload file failed for " + localPath);
            }
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.appendUploadDuration((int) (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
            return getRecognitionResult(fileMapInfoDoUploadFileSync, paramPaperCode, paramPaperNo);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - Tools - uploadFile - error " + e.getMessage() + " \n " + kotlin.ExceptionsKt.stackTraceToString(e));
            return scanOnePageResultBuildScanOnePageResult;
        }
    }

    static /* synthetic */ com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult getRecognitionResult$default(com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic photoAnswerLogic, com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo, java.lang.String str, java.lang.String str2, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return photoAnswerLogic.getRecognitionResult(fileMapInfo, str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final com.up366.mobile.course.photoanswer.logic.model.ScanOnePageResult getRecognitionResult(final com.up366.mobile.common.utils.alifile.FileMapInfo fileInfo, final java.lang.String paramPaperCode, final java.lang.String paramPaperNo) throws java.lang.InterruptedException {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.up366.common.http.NetHolder netHolderPostSync = com.up366.common.http.HttpUtilsUp.postSync(new com.up366.common.http.RequestParams<java.lang.String>() { // from class: com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic$getRecognitionResult$holder$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(com.up366.mobile.common.http.HttpMgrUtils.SMART_PAPER_RECOGNIZE);
            }

            @Override // com.up366.common.http.RequestParams
            public void initParams(java.util.Map<java.lang.String, java.lang.Object> params) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(params, "params");
                super.initParams(params);
                params.put("picUrl", fileInfo.getUrl());
                params.put("paperVersion", "v3");
                java.lang.String str = paramPaperCode;
                if (str != null && str.length() != 0) {
                    params.put("paperCode", paramPaperCode);
                }
                java.lang.String str2 = paramPaperNo;
                if (str2 == null || str2.length() == 0) {
                    return;
                }
                params.put("pageNo", paramPaperNo);
            }
        });
        com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.appendV3ScanDuration((int) (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        if (netHolderPostSync.resp.isError()) {
            com.up366.common.log.Logger.info("TAG - Tools - getRecognitionResult - error " + netHolderPostSync.resp);
            com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel paperCodeModel = new com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel();
            java.lang.String str = paramPaperCode;
            if (str == null || str.length() == 0) {
                paramPaperCode = "";
            }
            paperCodeModel.setPaperCode(paramPaperCode);
            paperCodeModel.setFilePath(fileInfo.getPath());
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
            return buildScanOnePageResult(-1001, paperCodeModel, null, true);
        }
        java.lang.String path = fileInfo.getPath();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSON.parseObject(((java.lang.String) netHolderPostSync.info).toString());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(object, "parseObject(...)");
        com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo = new com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo(path, object);
        photoAnswerImageInfo.setV3Paper(true);
        java.lang.String url = fileInfo.getUrl();
        photoAnswerImageInfo.setUploadedImageUrl(url != null ? url : "");
        com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel paperCodeModel2 = new com.up366.mobile.course.photoanswer.logic.model.PaperCodeModel();
        paperCodeModel2.setPaperCode(photoAnswerImageInfo.getPaperCode());
        paperCodeModel2.setErrorCode(photoAnswerImageInfo.getErrorCode());
        paperCodeModel2.setImageIndex(photoAnswerImageInfo.getImageIndex());
        paperCodeModel2.setFilePath(fileInfo.getPath());
        com.up366.common.log.Logger.info("TAG - Tools - getRecognitionResult -" + netHolderPostSync.info);
        if (com.up366.common.StringUtils.isEmptyOrNull(paperCodeModel2.getPaperCode())) {
            if (paperCodeModel2.getErrorCode() == 24 || paperCodeModel2.getErrorCode() == 25 || paperCodeModel2.getErrorCode() == 26) {
                return buildScanOnePageResult(-100, paperCodeModel2, null, true);
            }
            java.lang.String path2 = fileInfo.getPath();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
            return createScanOnePageResult(photoAnswerImageInfo, paperCodeModel2, "", path2, true);
        }
        int iCheckPaperCode = checkPaperCode(paperCodeModel2);
        if (iCheckPaperCode != 0) {
            return buildScanOnePageResult(iCheckPaperCode, paperCodeModel2, null, true);
        }
        if (fetchLayoutInfoSync(paperCodeModel2) != 0) {
            return buildScanOnePageResult(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerStatus.V3_LAYOUT_INFO_NET_ERROR, paperCodeModel2, null, true);
        }
        com.alibaba.fastjson.JSONObject layoutJson = this.cacheHelper.getLayoutJson();
        kotlin.jvm.internal.Intrinsics.checkNotNull(layoutJson);
        java.lang.String jSONString = layoutJson.toJSONString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
        java.lang.String path3 = fileInfo.getPath();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(path3, "getPath(...)");
        return createScanOnePageResult(photoAnswerImageInfo, paperCodeModel2, jSONString, path3, true);
    }

    private final com.up366.mobile.common.utils.alifile.FileMapInfo doUploadFileSync(java.lang.String localPath) {
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.common.FileUtilsUp.isFileExists(localPath) ? com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(localPath, com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getExtensionName(localPath), com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366) : null;
        if (fileMapInfoSaveSync == null) {
            com.up366.common.log.Logger.error("TAG - Tools - uploadFile - saveSync failed for " + localPath);
            return null;
        }
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        final boolean[] zArr = {false};
        com.up366.mobile.common.utils.alifile.AliFileMgrV2.uploadFile(fileMapInfoSaveSync, new com.up366.mobile.common.utils.alifile.IOSSCallback() { // from class: com.up366.mobile.course.photoanswer.logic.PhotoAnswerLogic.doUploadFileSync.1
            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onSuccess() {
                zArr[0] = true;
                countDownLatch.countDown();
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onFailure(int code, java.lang.String info) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
                com.up366.common.log.Logger.error("TAG - Tools - uploadFile - onFailure code: " + code + ", info: " + info);
                zArr[0] = false;
                countDownLatch.countDown();
            }

            @Override // com.up366.mobile.common.utils.alifile.IOSSCallback
            public void onProgress(long currentSize, long totalSize) {
                com.up366.common.log.Logger.info("TAG - Tools - uploadFile - progress " + currentSize + " / " + totalSize);
            }
        });
        try {
            countDownLatch.await(1L, java.util.concurrent.TimeUnit.HOURS);
        } catch (java.lang.InterruptedException e) {
            com.up366.common.log.Logger.info("TAG - LogMgr - doUploadFileRecordSync - ", e);
        }
        if (zArr[0]) {
            return fileMapInfoSaveSync;
        }
        return null;
    }
}
