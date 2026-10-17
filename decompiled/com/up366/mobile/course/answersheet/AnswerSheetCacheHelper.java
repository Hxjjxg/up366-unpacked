package com.up366.mobile.course.answersheet;

/* JADX INFO: compiled from: AnswerSheetCacheHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\nJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000bJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001fJ\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\bJ\b\u0010\"\u001a\u00020\u001bH\u0002J\b\u0010#\u001a\u00020\u001bH\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000bJ\u0006\u0010'\u001a\u00020\u001bJ\u0006\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020%J\u0006\u0010*\u001a\u00020%J\u0014\u0010*\u001a\u00020%2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001fJ\u0006\u0010,\u001a\u00020%J\u0016\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000eJ\u0006\u00100\u001a\u00020%J\u0006\u00101\u001a\u00020\u0001J\u000e\u00102\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0001J\u0006\u00103\u001a\u00020\bJ\u0006\u00104\u001a\u00020\bJ\u0006\u00105\u001a\u00020\bJ\u0006\u00106\u001a\u00020\bJ\u0006\u00107\u001a\u00020\bJ\u0006\u00108\u001a\u00020\bJ\u0010\u00109\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\bJ\b\u0010:\u001a\u0004\u0018\u00010\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/up366/mobile/course/answersheet/AnswerSheetCacheHelper;", "", "<init>", "()V", "dataInfo", "layoutJson", "Lcom/alibaba/fastjson/JSONObject;", "paperCode", "", "imageDataMap", "", "Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerImageInfo;", "uploadKey", "totalPageCount", "", "curWebViewId", "layoutJsonPaperCode", "setLayoutJson", "getNetLayoutImageCount", "getLayoutJson", "getLayoutJsonPaperCode", "setPaperCode", "getPaperCode", "getLayoutJsonBlocks", "Lcom/alibaba/fastjson/JSONArray;", "getLayoutJsonBlocksMap", "onDestroy", "", "addImage", "paperData", "getImageList", "", "removeImage", "filePath", "updatePaperCodeAfterDelete", "updateTotalPageCount", "checkSamePageNumber", "", "data", "resetUploadKey", "getUploadKey", "checkFull", "checkBlocks", "photoImageInfoList", "hasForceUseImage", "updateImageStatus", "image1", "rsError", "hasNewAnswerSheet", "getData", "setData", "getCourseId", "getStudyTaskId", "getContentId", "getJobName", "getPaperId", "getSubmitKey", "setCurWebViewId", "getCurWebViewId", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnswerSheetCacheHelper {
    private java.lang.String curWebViewId;
    private java.lang.Object dataInfo;
    private com.alibaba.fastjson.JSONObject layoutJson;
    private java.lang.String paperCode = "";
    private java.util.Map<java.lang.String, com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> imageDataMap = new java.util.LinkedHashMap();
    private java.lang.String uploadKey = "";
    private int totalPageCount = 100;
    private java.lang.String layoutJsonPaperCode = "";

    public final com.up366.mobile.course.answersheet.AnswerSheetCacheHelper setLayoutJson(java.lang.String paperCode, java.lang.String layoutJson) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paperCode, "paperCode");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(layoutJson, "layoutJson");
        try {
            this.layoutJsonPaperCode = paperCode;
            this.layoutJson = com.alibaba.fastjson.JSON.parseObject(layoutJson);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("setLayoutJson error  ," + layoutJson, e);
        }
        return this;
    }

    public final int getNetLayoutImageCount() {
        try {
            com.alibaba.fastjson.JSONObject jSONObject = this.layoutJson;
            kotlin.jvm.internal.Intrinsics.checkNotNull(jSONObject);
            java.lang.Integer integer = jSONObject.getJSONObject(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE).getInteger("imageCount");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(integer, "getInteger(...)");
            return integer.intValue();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getNetLayoutImageCount error  ," + this.layoutJson, e);
            return 0;
        }
    }

    public final com.alibaba.fastjson.JSONObject getLayoutJson() {
        return this.layoutJson;
    }

    public final java.lang.String getLayoutJsonPaperCode() {
        return this.layoutJsonPaperCode;
    }

    public final com.up366.mobile.course.answersheet.AnswerSheetCacheHelper setPaperCode(java.lang.String paperCode) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paperCode, "paperCode");
        this.paperCode = paperCode;
        return this;
    }

    public final java.lang.String getPaperCode() {
        return this.paperCode;
    }

    public final com.alibaba.fastjson.JSONArray getLayoutJsonBlocks() {
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        try {
            com.alibaba.fastjson.JSONObject jSONObject = this.layoutJson;
            kotlin.jvm.internal.Intrinsics.checkNotNull(jSONObject);
            com.alibaba.fastjson.JSONArray jSONArray2 = jSONObject.getJSONArray("blocks");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jSONArray2, "getJSONArray(...)");
            return jSONArray2;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getLayoutJsonBlocks error " + this.layoutJson, e);
            return jSONArray;
        }
    }

    public final java.util.Map<java.lang.Integer, com.alibaba.fastjson.JSONObject> getLayoutJsonBlocksMap() {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        com.alibaba.fastjson.JSONArray layoutJsonBlocks = getLayoutJsonBlocks();
        int size = layoutJsonBlocks.size();
        for (int i = 0; i < size; i++) {
            com.alibaba.fastjson.JSONObject jSONObject = layoutJsonBlocks.getJSONObject(i);
            linkedHashMap.put(java.lang.Integer.valueOf(jSONObject.getIntValue("blockNo")), jSONObject);
        }
        return linkedHashMap;
    }

    public final void onDestroy() {
        this.dataInfo = null;
        this.paperCode = "";
        this.imageDataMap.clear();
        this.totalPageCount = 0;
        this.layoutJson = null;
    }

    public final void addImage(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo paperData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paperData, "paperData");
        int imageIndex = paperData.isCorrectStatus() ? paperData.getImageIndex() : -1;
        if (imageIndex != -1) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo>> it = this.imageDataMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().getImageIndex() == imageIndex) {
                    it.remove();
                }
            }
        }
        this.imageDataMap.put(paperData.getSourceImageFilePath(), paperData);
        if (paperData.isCorrectStatus()) {
            this.totalPageCount = paperData.getTotalImageCount();
        }
    }

    public final java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> getImageList() {
        return kotlin.collections.CollectionsKt.toList(this.imageDataMap.values());
    }

    public final void removeImage(java.lang.String filePath) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.imageDataMap.remove(filePath);
        updateTotalPageCount();
        updatePaperCodeAfterDelete();
    }

    private final void updatePaperCodeAfterDelete() {
        java.util.Iterator<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> it = this.imageDataMap.values().iterator();
        while (it.hasNext()) {
            if (it.next().isCorrectStatus()) {
                return;
            }
        }
        this.paperCode = "";
    }

    private final void updateTotalPageCount() {
        this.totalPageCount = 0;
        if (this.imageDataMap.isEmpty()) {
            return;
        }
        for (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo : this.imageDataMap.values()) {
            if (photoAnswerImageInfo.isCorrectStatus()) {
                this.totalPageCount = photoAnswerImageInfo.getTotalImageCount();
                return;
            }
        }
    }

    public final boolean checkSamePageNumber(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo data) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        if (this.imageDataMap.isEmpty() || !data.isCorrectStatus()) {
            return false;
        }
        for (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo : this.imageDataMap.values()) {
            if (photoAnswerImageInfo.isCorrectStatus() && photoAnswerImageInfo.getImageIndex() == data.getImageIndex()) {
                return true;
            }
        }
        return false;
    }

    public final void resetUploadKey() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        int iRandom = kotlin.ranges.RangesKt.random(new kotlin.ranges.IntRange(0, 100), kotlin.random.Random.Default);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(jCurrentTimeMillis);
        sb.append(iRandom);
        this.uploadKey = sb.toString();
    }

    public final java.lang.String getUploadKey() {
        return this.uploadKey;
    }

    public final boolean checkFull() {
        int i = this.totalPageCount;
        if (1 <= i) {
            int i2 = 1;
            while (true) {
                java.util.Iterator<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> it = this.imageDataMap.values().iterator();
                while (it.hasNext()) {
                    if (it.next().getImageIndex() == i2) {
                        if (i2 == i) {
                            break;
                        }
                        i2++;
                    }
                }
                return false;
            }
        }
        return true;
    }

    public final boolean checkBlocks() {
        return checkBlocks(kotlin.collections.CollectionsKt.toList(this.imageDataMap.values()));
    }

    public final boolean checkBlocks(java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> photoImageInfoList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(photoImageInfoList, "photoImageInfoList");
        com.alibaba.fastjson.JSONArray layoutJsonBlocks = getLayoutJsonBlocks();
        if (layoutJsonBlocks.isEmpty()) {
            return false;
        }
        java.util.Iterator it = kotlin.collections.CollectionsKt.sortedWith(photoImageInfoList, new java.util.Comparator() { // from class: com.up366.mobile.course.answersheet.AnswerSheetCacheHelper$checkBlocks$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return kotlin.comparisons.ComparisonsKt.compareValues(java.lang.Integer.valueOf(((com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) t).getImageIndex()), java.lang.Integer.valueOf(((com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) t2).getImageIndex()));
            }
        }).iterator();
        while (it.hasNext()) {
            com.alibaba.fastjson.JSONArray blocks = ((com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) it.next()).getBlocks();
            int size = blocks.size();
            for (int i = 0; i < size; i++) {
                com.alibaba.fastjson.JSONObject jSONObject = blocks.getJSONObject(i);
                int size2 = layoutJsonBlocks.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    if (layoutJsonBlocks.getJSONObject(i2).getIntValue("blockNo") == jSONObject.getIntValue("blockNo")) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    public final boolean hasForceUseImage() {
        java.util.Iterator<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> it = this.imageDataMap.values().iterator();
        while (it.hasNext()) {
            if (it.next().getIsForceUse()) {
                return true;
            }
        }
        return false;
    }

    public final void updateImageStatus(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo image1, int rsError) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(image1, "image1");
        com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo = this.imageDataMap.get(image1.getSourceImageFilePath());
        if (photoAnswerImageInfo == null) {
            return;
        }
        photoAnswerImageInfo.updateErrorCode(rsError);
    }

    public final boolean hasNewAnswerSheet() {
        if (this.imageDataMap.isEmpty()) {
            return false;
        }
        java.util.Iterator<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> it = this.imageDataMap.values().iterator();
        while (it.hasNext()) {
            if (it.next().isCorrectStatus()) {
                return true;
            }
        }
        return false;
    }

    public final java.lang.Object getData() {
        java.lang.Object obj = this.dataInfo;
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
        return obj;
    }

    public final com.up366.mobile.course.answersheet.AnswerSheetCacheHelper setData(java.lang.Object data) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        this.dataInfo = data;
        return this;
    }

    public final java.lang.String getCourseId() {
        java.lang.Object obj = this.dataInfo;
        if (obj instanceof com.up366.mobile.course.task.TaskInfoV2) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.up366.mobile.course.task.TaskInfoV2");
            return java.lang.String.valueOf(((com.up366.mobile.course.task.TaskInfoV2) obj).getCourseId());
        }
        return "";
    }

    public final java.lang.String getStudyTaskId() {
        java.lang.Object obj = this.dataInfo;
        if (obj instanceof com.up366.mobile.course.task.TaskInfoV2) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.up366.mobile.course.task.TaskInfoV2");
            java.lang.String jobId = ((com.up366.mobile.course.task.TaskInfoV2) obj).getJobId();
            kotlin.jvm.internal.Intrinsics.checkNotNull(jobId);
            return jobId;
        }
        return "";
    }

    public final java.lang.String getContentId() {
        java.lang.Object obj = this.dataInfo;
        if (obj instanceof com.up366.mobile.course.task.TaskInfoV2) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.up366.mobile.course.task.TaskInfoV2");
            java.lang.String contentId = ((com.up366.mobile.course.task.TaskInfoV2) obj).getContentId();
            kotlin.jvm.internal.Intrinsics.checkNotNull(contentId);
            return contentId;
        }
        return "";
    }

    public final java.lang.String getJobName() {
        java.lang.Object obj = this.dataInfo;
        if (obj instanceof com.up366.mobile.course.task.TaskInfoV2) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.up366.mobile.course.task.TaskInfoV2");
            java.lang.String jobName = ((com.up366.mobile.course.task.TaskInfoV2) obj).getJobName();
            kotlin.jvm.internal.Intrinsics.checkNotNull(jobName);
            return jobName;
        }
        if (obj instanceof com.up366.mobile.course.photoanswer.model.ScanPaperModel) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.up366.mobile.course.photoanswer.model.ScanPaperModel");
            java.lang.String jobName2 = ((com.up366.mobile.course.photoanswer.model.ScanPaperModel) obj).getJobName();
            kotlin.jvm.internal.Intrinsics.checkNotNull(jobName2);
            return jobName2;
        }
        return "";
    }

    public final java.lang.String getPaperId() {
        java.lang.Object obj = this.dataInfo;
        if (obj instanceof com.up366.mobile.course.photoanswer.model.ScanPaperModel) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.up366.mobile.course.photoanswer.model.ScanPaperModel");
            java.lang.String paperId = ((com.up366.mobile.course.photoanswer.model.ScanPaperModel) obj).getPaperId();
            kotlin.jvm.internal.Intrinsics.checkNotNull(paperId);
            return paperId;
        }
        return "";
    }

    public final java.lang.String getSubmitKey() {
        java.lang.Object obj = this.dataInfo;
        if (obj instanceof com.up366.mobile.course.photoanswer.model.ScanPaperModel) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.up366.mobile.course.photoanswer.model.ScanPaperModel");
            java.lang.String paperIdSubmitKey = ((com.up366.mobile.course.photoanswer.model.ScanPaperModel) obj).getPaperIdSubmitKey();
            kotlin.jvm.internal.Intrinsics.checkNotNull(paperIdSubmitKey);
            return paperIdSubmitKey;
        }
        if (obj instanceof com.up366.mobile.course.task.TaskInfoV2) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.up366.mobile.course.task.TaskInfoV2");
            java.lang.String jobId = ((com.up366.mobile.course.task.TaskInfoV2) obj).getJobId();
            kotlin.jvm.internal.Intrinsics.checkNotNull(jobId);
            return jobId;
        }
        return "";
    }

    public final com.up366.mobile.course.answersheet.AnswerSheetCacheHelper setCurWebViewId(java.lang.String curWebViewId) {
        this.curWebViewId = curWebViewId;
        return this;
    }

    public final java.lang.String getCurWebViewId() {
        return this.curWebViewId;
    }
}
