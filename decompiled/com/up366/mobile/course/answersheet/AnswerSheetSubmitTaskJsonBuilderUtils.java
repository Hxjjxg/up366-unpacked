package com.up366.mobile.course.answersheet;

/* JADX INFO: compiled from: AnswerSheetSubmitTaskJsonBuilderUtils.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J$\u0010\u0014\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002J\u001e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002J*\u0010\u0017\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J8\u0010\u001c\u001a\u00020\u00192\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0005H\u0002J$\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\f2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0005H\u0002J2\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0005H\u0002J.\u0010 \u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\b\b\u0002\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0002J\u001e\u0010$\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002J\u0012\u0010%\u001a\u0004\u0018\u00010\u00072\u0006\u0010&\u001a\u00020\u0006H\u0002J$\u0010'\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\f2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0005H\u0002J$\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0005H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/up366/mobile/course/answersheet/AnswerSheetSubmitTaskJsonBuilderUtils;", "", "<init>", "()V", "cacheMap", "", "", "Lcom/up366/mobile/common/utils/alifile/FileMapInfo;", "buildOcrTaskJson", "Lcom/alibaba/fastjson/JSONObject;", "submitData", "", "Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerImageInfo;", "imageInfoSet", "", "cacheHelper", "Lcom/up366/mobile/course/answersheet/AnswerSheetCacheHelper;", "getWarpFlag", "", "sortedSubmitData", "buildPicBaseList", "buildPicBase", "data", "buildForceTaskJson", "buildStudyInfo", "Lcom/alibaba/fastjson/JSONArray;", com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, "buildPicList", "netBlocksMap", "buildV3Pic", "buildV2Pic", "buildPicOriginal", "force", "", "buildV3PicOriginal", "buildV2PicOriginal", "loadFileMapInfo", "filePath", "buildBlockList", "getReplaceQuestionBlock", "engineBlock", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnswerSheetSubmitTaskJsonBuilderUtils {
    public static final com.up366.mobile.course.answersheet.AnswerSheetSubmitTaskJsonBuilderUtils INSTANCE = new com.up366.mobile.course.answersheet.AnswerSheetSubmitTaskJsonBuilderUtils();
    private static java.util.Map<java.lang.String, com.up366.mobile.common.utils.alifile.FileMapInfo> cacheMap = new java.util.LinkedHashMap();

    private AnswerSheetSubmitTaskJsonBuilderUtils() {
    }

    public final com.alibaba.fastjson.JSONObject buildOcrTaskJson(java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> submitData, java.util.Set<com.up366.mobile.common.utils.alifile.FileMapInfo> imageInfoSet, com.up366.mobile.course.answersheet.AnswerSheetCacheHelper cacheHelper) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(submitData, "submitData");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageInfoSet, "imageInfoSet");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cacheHelper, "cacheHelper");
        com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.setSubmitType(1);
        cacheMap.clear();
        java.lang.String studyTaskId = cacheHelper.getStudyTaskId();
        java.lang.String courseId = cacheHelper.getCourseId();
        java.lang.String paperCode = cacheHelper.getPaperCode();
        java.util.Map<java.lang.Integer, com.alibaba.fastjson.JSONObject> layoutJsonBlocksMap = cacheHelper.getLayoutJsonBlocksMap();
        java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> listSortedWith = kotlin.collections.CollectionsKt.sortedWith(submitData, new java.util.Comparator() { // from class: com.up366.mobile.course.answersheet.AnswerSheetSubmitTaskJsonBuilderUtils$buildOcrTaskJson$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return kotlin.comparisons.ComparisonsKt.compareValues(java.lang.Integer.valueOf(((com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) t).getImageIndex()), java.lang.Integer.valueOf(((com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) t2).getImageIndex()));
            }
        });
        java.util.Map jSONObject = new com.alibaba.fastjson.JSONObject();
        java.util.Map map = jSONObject;
        map.put("studyInfo", buildStudyInfo(studyTaskId, courseId));
        map.put("picList", buildPicList(listSortedWith, imageInfoSet, layoutJsonBlocksMap));
        map.put("normalSubmit", 0);
        map.put("pageFault", 0);
        map.put("layoutId", paperCode);
        map.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
        map.put("studyDate", com.up366.common.TimeUtils.formatTime(java.lang.System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        map.put("picOriginal", buildPicOriginal$default(this, listSortedWith, imageInfoSet, false, 4, null));
        map.put("picMark", "");
        map.put("warpFlag", java.lang.Integer.valueOf(getWarpFlag(listSortedWith)));
        map.put("picBase", buildPicBaseList(listSortedWith, imageInfoSet));
        if (com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.getEnterTime() != 0) {
            map.put("start", java.lang.Long.valueOf(com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.getEnterTime()));
            map.put("durtation", java.lang.Long.valueOf(com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.getStaticDuration()));
        }
        return jSONObject;
    }

    private final int getWarpFlag(java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> sortedSubmitData) {
        java.util.Iterator<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> it = sortedSubmitData.iterator();
        while (it.hasNext()) {
            if (it.next().getErrorCode() == 36) {
                return 1;
            }
        }
        return 0;
    }

    private final java.lang.String buildPicBaseList(java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> submitData, java.util.Set<com.up366.mobile.common.utils.alifile.FileMapInfo> imageInfoSet) throws java.lang.InterruptedException {
        java.lang.String strBuildPicBase;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo : submitData) {
            if (photoAnswerImageInfo.getIsV3Paper()) {
                strBuildPicBase = photoAnswerImageInfo.getPicBase();
            } else {
                strBuildPicBase = buildPicBase(photoAnswerImageInfo, imageInfoSet);
            }
            if (!com.up366.common.StringUtils.isEmptyOrNull(strBuildPicBase)) {
                sb.append(strBuildPicBase);
                sb.append(com.igexin.push.core.b.an);
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        java.lang.String string = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final java.lang.String buildPicBase(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo data, java.util.Set<com.up366.mobile.common.utils.alifile.FileMapInfo> imageInfoSet) throws java.lang.InterruptedException {
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadFileMapInfo = loadFileMapInfo(data.getPicBase());
        if (fileMapInfoLoadFileMapInfo == null) {
            com.up366.common.log.Logger.error("buildPicList error fileMapInfo is null");
            return "";
        }
        imageInfoSet.add(fileMapInfoLoadFileMapInfo);
        java.lang.String url = fileMapInfoLoadFileMapInfo.getUrl();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
        return url;
    }

    public final com.alibaba.fastjson.JSONObject buildForceTaskJson(java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> submitData, java.util.Set<com.up366.mobile.common.utils.alifile.FileMapInfo> imageInfoSet, com.up366.mobile.course.answersheet.AnswerSheetCacheHelper cacheHelper) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(submitData, "submitData");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imageInfoSet, "imageInfoSet");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cacheHelper, "cacheHelper");
        com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.setSubmitType(2);
        cacheMap.clear();
        java.lang.String studyTaskId = cacheHelper.getStudyTaskId();
        java.lang.String courseId = cacheHelper.getCourseId();
        java.lang.String paperCode = cacheHelper.getPaperCode();
        java.util.Map jSONObject = new com.alibaba.fastjson.JSONObject();
        java.util.Map map = jSONObject;
        map.put("studyInfo", buildStudyInfo(studyTaskId, courseId));
        map.put("picList", new com.alibaba.fastjson.JSONArray());
        map.put("normalSubmit", 1);
        map.put("pageFault", 0);
        map.put("layoutId", paperCode);
        map.put("uid", java.lang.Integer.valueOf(com.up366.mobile.common.logic.Auth.UID()));
        map.put("studyDate", com.up366.common.TimeUtils.formatTime(java.lang.System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        map.put("picOriginal", buildPicOriginal(submitData, imageInfoSet, true));
        map.put("picMark", "");
        map.put("warpFlag", 0);
        if (com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.getEnterTime() != 0) {
            map.put("start", java.lang.Long.valueOf(com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.getEnterTime()));
            map.put("durtation", java.lang.Long.valueOf(com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.INSTANCE.getStaticDuration()));
        }
        return jSONObject;
    }

    private final com.alibaba.fastjson.JSONArray buildStudyInfo(java.lang.String studyTaskId, java.lang.String courseId) {
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        java.util.Map jSONObject = new com.alibaba.fastjson.JSONObject();
        java.util.Map map = jSONObject;
        map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, studyTaskId);
        map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.COURSE_ID, courseId);
        jSONArray.add(jSONObject);
        return jSONArray;
    }

    private final com.alibaba.fastjson.JSONArray buildPicList(java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> submitData, java.util.Set<com.up366.mobile.common.utils.alifile.FileMapInfo> imageInfoSet, java.util.Map<java.lang.Integer, com.alibaba.fastjson.JSONObject> netBlocksMap) throws java.lang.InterruptedException {
        com.alibaba.fastjson.JSONObject jSONObjectBuildV3Pic;
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        for (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo : submitData) {
            if (!photoAnswerImageInfo.getIsV3Paper()) {
                jSONObjectBuildV3Pic = buildV2Pic(photoAnswerImageInfo, imageInfoSet, netBlocksMap);
            } else {
                jSONObjectBuildV3Pic = buildV3Pic(photoAnswerImageInfo, netBlocksMap);
            }
            jSONArray.add(jSONObjectBuildV3Pic);
        }
        return jSONArray;
    }

    private final com.alibaba.fastjson.JSONObject buildV3Pic(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo data, java.util.Map<java.lang.Integer, com.alibaba.fastjson.JSONObject> netBlocksMap) {
        java.util.Map jSONObject = new com.alibaba.fastjson.JSONObject();
        java.util.Map map = jSONObject;
        map.put("picBase", data.getPicBase());
        map.put("warpFlag", 0);
        map.put("blockList", buildBlockList(data, netBlocksMap));
        map.put("picOriginalUrl", data.getFilePath());
        map.put("picSource", 1);
        map.put(com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_TOP, java.lang.Integer.valueOf(data.getBaseY()));
        map.put(com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_LEFT, java.lang.Integer.valueOf(data.getBaseX()));
        return jSONObject;
    }

    private final com.alibaba.fastjson.JSONObject buildV2Pic(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo data, java.util.Set<com.up366.mobile.common.utils.alifile.FileMapInfo> imageInfoSet, java.util.Map<java.lang.Integer, com.alibaba.fastjson.JSONObject> netBlocksMap) throws java.lang.InterruptedException {
        java.lang.String url;
        java.lang.String url2;
        java.util.Map jSONObject = new com.alibaba.fastjson.JSONObject();
        int i = data.getErrorCode() == 36 ? 1 : 0;
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadFileMapInfo = loadFileMapInfo(data.getPicBase());
        if (fileMapInfoLoadFileMapInfo == null) {
            com.up366.common.log.Logger.error("buildPicList error picBaseInfo is null");
        } else {
            imageInfoSet.add(fileMapInfoLoadFileMapInfo);
        }
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadFileMapInfo2 = loadFileMapInfo(data.getFilePath());
        if (fileMapInfoLoadFileMapInfo2 == null) {
            com.up366.common.log.Logger.error("buildPicList error fileMapInfo is null");
        } else {
            imageInfoSet.add(fileMapInfoLoadFileMapInfo2);
        }
        java.util.Map map = jSONObject;
        java.lang.String str = "";
        if (fileMapInfoLoadFileMapInfo == null || (url = fileMapInfoLoadFileMapInfo.getUrl()) == null) {
            url = "";
        }
        map.put("picBase", url);
        map.put("warpFlag", java.lang.Integer.valueOf(i));
        map.put("blockList", buildBlockList(data, netBlocksMap));
        if (fileMapInfoLoadFileMapInfo2 != null && (url2 = fileMapInfoLoadFileMapInfo2.getUrl()) != null) {
            str = url2;
        }
        map.put("picOriginalUrl", str);
        map.put("picSource", 1);
        map.put(com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_TOP, java.lang.Integer.valueOf(data.getBaseY()));
        map.put(com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_LEFT, java.lang.Integer.valueOf(data.getBaseX()));
        return jSONObject;
    }

    static /* synthetic */ java.lang.String buildPicOriginal$default(com.up366.mobile.course.answersheet.AnswerSheetSubmitTaskJsonBuilderUtils answerSheetSubmitTaskJsonBuilderUtils, java.util.List list, java.util.Set set, boolean z, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return answerSheetSubmitTaskJsonBuilderUtils.buildPicOriginal(list, set, z);
    }

    private final java.lang.String buildPicOriginal(java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> submitData, java.util.Set<com.up366.mobile.common.utils.alifile.FileMapInfo> imageInfoSet, boolean force) throws java.lang.InterruptedException {
        java.lang.String strBuildV3PicOriginal;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo : submitData) {
            if (!photoAnswerImageInfo.getIsV3Paper()) {
                strBuildV3PicOriginal = buildV2PicOriginal(photoAnswerImageInfo, imageInfoSet);
            } else {
                strBuildV3PicOriginal = buildV3PicOriginal(photoAnswerImageInfo, force);
            }
            if (!com.up366.common.StringUtils.isEmptyOrNull(strBuildV3PicOriginal)) {
                sb.append(strBuildV3PicOriginal);
                sb.append(com.igexin.push.core.b.an);
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        java.lang.String string = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final java.lang.String buildV3PicOriginal(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo data, boolean force) {
        if (force) {
            return data.getV3ForceSubmitOriginalUrl();
        }
        return data.getFilePath();
    }

    private final java.lang.String buildV2PicOriginal(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo data, java.util.Set<com.up366.mobile.common.utils.alifile.FileMapInfo> imageInfoSet) throws java.lang.InterruptedException {
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoLoadFileMapInfo = loadFileMapInfo(data.getFilePath());
        if (fileMapInfoLoadFileMapInfo == null) {
            com.up366.common.log.Logger.error("buildPicList error fileMapInfo is null");
            return "";
        }
        imageInfoSet.add(fileMapInfoLoadFileMapInfo);
        java.lang.String url = fileMapInfoLoadFileMapInfo.getUrl();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
        return url;
    }

    private final com.up366.mobile.common.utils.alifile.FileMapInfo loadFileMapInfo(java.lang.String filePath) throws java.lang.InterruptedException {
        if (filePath.length() == 0) {
            com.up366.common.log.Logger.error("loadFileMapInfo error filePath is empty");
            return null;
        }
        if (!com.up366.common.FileUtilsUp.isFileExists(filePath)) {
            com.up366.common.log.Logger.error("loadFileMapInfo error filePath:" + filePath + " not exists");
            return null;
        }
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfo = cacheMap.get(filePath);
        if (fileMapInfo != null) {
            com.up366.common.log.Logger.info("loadFileMapInfo cache success filePath:" + filePath + " url:" + fileMapInfo.getUrl());
            return fileMapInfo;
        }
        com.up366.mobile.common.utils.alifile.FileMapInfo fileMapInfoSaveSync = com.up366.mobile.common.logic.Auth.cur().fileMgr().saveSync(filePath, com.up366.medialibrary.common.utils.MimeTypeUtils.JPG, com.up366.mobile.common.utils.alifile.AliFileMgrV2.BIZ_UP366, com.up366.mobile.common.utils.alifile.OssObjectKey.INSTANCE.getObjectKey(filePath, com.up366.medialibrary.common.utils.MimeTypeUtils.JPG));
        if (fileMapInfoSaveSync != null) {
            com.up366.common.log.Logger.info("loadFileMapInfo saveSync filePath:" + filePath + " url:" + fileMapInfoSaveSync.getUrl());
        }
        cacheMap.put(filePath, fileMapInfoSaveSync);
        return fileMapInfoSaveSync;
    }

    private final com.alibaba.fastjson.JSONArray buildBlockList(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo data, java.util.Map<java.lang.Integer, com.alibaba.fastjson.JSONObject> netBlocksMap) {
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        com.alibaba.fastjson.JSONArray blocks = data.getBlocks();
        int size = blocks.size();
        for (int i = 0; i < size; i++) {
            com.alibaba.fastjson.JSONObject jSONObject = blocks.getJSONObject(i);
            kotlin.jvm.internal.Intrinsics.checkNotNull(jSONObject);
            java.util.Map replaceQuestionBlock = getReplaceQuestionBlock(jSONObject, netBlocksMap);
            replaceQuestionBlock.put("rect", jSONObject.getJSONArray("rect"));
            jSONArray.add(replaceQuestionBlock);
        }
        return jSONArray;
    }

    private final com.alibaba.fastjson.JSONObject getReplaceQuestionBlock(com.alibaba.fastjson.JSONObject engineBlock, java.util.Map<java.lang.Integer, com.alibaba.fastjson.JSONObject> netBlocksMap) {
        int intValue = engineBlock.getIntValue("blockNo");
        com.alibaba.fastjson.JSONObject jSONObject = netBlocksMap.get(java.lang.Integer.valueOf(intValue));
        if (jSONObject == null) {
            com.up366.common.log.Logger.error("getReplaceQuestionBlock error block is null blockNo:" + intValue);
            jSONObject = new com.alibaba.fastjson.JSONObject();
        }
        if (!jSONObject.containsKey(com.up366.mobile.book.helper.V9ResourceHelper.DIR_QUESTIONS)) {
            return jSONObject;
        }
        com.alibaba.fastjson.JSONArray jSONArray = jSONObject.getJSONArray(com.up366.mobile.book.helper.V9ResourceHelper.DIR_QUESTIONS);
        com.alibaba.fastjson.JSONArray jSONArray2 = engineBlock.getJSONArray(com.up366.mobile.book.helper.V9ResourceHelper.DIR_QUESTIONS);
        com.alibaba.fastjson.JSONArray jSONArray3 = new com.alibaba.fastjson.JSONArray();
        int size = jSONArray.size();
        for (int i = 0; i < size; i++) {
            com.alibaba.fastjson.JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
            java.util.Map jSONObject3 = jSONArray.getJSONObject(i);
            if (jSONObject3.containsKey("rect")) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(jSONObject3);
                jSONObject3.put("rect", jSONObject2.get("rect"));
            }
            if (jSONObject3.containsKey("rectAnswer")) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(jSONObject3);
                jSONObject3.put("rectAnswer", jSONObject2.get("rectAnswer"));
            }
            if (jSONObject3.containsKey("rectNoOCR")) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(jSONObject3);
                jSONObject3.put("rectNoOCR", jSONObject2.get("rectNoOCR"));
            }
            jSONArray3.add(jSONObject3);
        }
        return jSONObject;
    }
}
