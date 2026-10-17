package com.up366.mobile.course.photoanswer.logic.model;

/* JADX INFO: compiled from: PhotoAnswerImageInfo.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\rJ\u0006\u0010!\u001a\u00020\rJ\u0006\u0010\"\u001a\u00020\u001fJ\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u001fJ\u0006\u0010'\u001a\u00020\u001fJ\u0006\u0010(\u001a\u00020\u001fJ\u0006\u0010)\u001a\u00020\u001fJ\u0006\u0010*\u001a\u00020\u0003J\u0006\u0010+\u001a\u00020\u0003J\u0006\u0010,\u001a\u00020\u0003J\u0006\u0010-\u001a\u00020\u0003J\u0006\u0010.\u001a\u00020\u0003J\b\u0010/\u001a\u00020\u0003H\u0016J\u0013\u00100\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00102\u001a\u00020\u001fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010¨\u00063"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerImageInfo;", "", "sourceImageFilePath", "", "engineImageInfo", "Lcom/alibaba/fastjson/JSONObject;", "<init>", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;)V", "getSourceImageFilePath", "()Ljava/lang/String;", "getEngineImageInfo", "()Lcom/alibaba/fastjson/JSONObject;", "isForceUse", "", "()Z", "setForceUse", "(Z)V", "uiSelected", "getUiSelected", "setUiSelected", "uploadedImageUrl", "getUploadedImageUrl", "setUploadedImageUrl", "(Ljava/lang/String;)V", "isV3Paper", "setV3Paper", "isA3", "getPaperCode", "updateErrorCode", "", "errorCode", "", "isCorrectStatus", "isCorrectStatusOK", "getErrorCode", "getErrorMessage", "getBlocks", "Lcom/alibaba/fastjson/JSONArray;", "getBaseY", "getBaseX", "getTotalImageCount", "getImageIndex", "getFilePath", "getPreviewFilePath", "getPicBase", "getEngineOriginalImageFileName", "getV3ForceSubmitOriginalUrl", "toString", "equals", "other", "hashCode", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerImageInfo {
    private final com.alibaba.fastjson.JSONObject engineImageInfo;
    private transient boolean isForceUse;
    private boolean isV3Paper;
    private final java.lang.String sourceImageFilePath;
    private transient boolean uiSelected;
    private transient java.lang.String uploadedImageUrl;

    public PhotoAnswerImageInfo(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "sourceImageFilePath");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jSONObject, "engineImageInfo");
        this.sourceImageFilePath = str;
        this.engineImageInfo = jSONObject;
        this.uploadedImageUrl = "";
    }

    public /* synthetic */ PhotoAnswerImageInfo(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, jSONObject);
    }

    public final com.alibaba.fastjson.JSONObject getEngineImageInfo() {
        return this.engineImageInfo;
    }

    public final java.lang.String getSourceImageFilePath() {
        return this.sourceImageFilePath;
    }

    /* JADX INFO: renamed from: isForceUse, reason: from getter */
    public final boolean getIsForceUse() {
        return this.isForceUse;
    }

    public final void setForceUse(boolean z) {
        this.isForceUse = z;
    }

    public final boolean getUiSelected() {
        return this.uiSelected;
    }

    public final void setUiSelected(boolean z) {
        this.uiSelected = z;
    }

    public final java.lang.String getUploadedImageUrl() {
        return this.uploadedImageUrl;
    }

    public final void setUploadedImageUrl(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uploadedImageUrl = str;
    }

    /* JADX INFO: renamed from: isV3Paper, reason: from getter */
    public final boolean getIsV3Paper() {
        return this.isV3Paper;
    }

    public final void setV3Paper(boolean z) {
        this.isV3Paper = z;
    }

    public final boolean isA3() {
        try {
            java.lang.Boolean bool = this.engineImageInfo.getBoolean("isA3");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "getBoolean(...)");
            return bool.booleanValue();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("isA3 error  ," + this.engineImageInfo, e);
            return false;
        }
    }

    public final java.lang.String getPaperCode() {
        try {
            java.lang.String string = this.engineImageInfo.getString("paperID");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getPaperCode error  ," + this.engineImageInfo, e);
            return "";
        }
    }

    public final void updateErrorCode(int errorCode) {
        this.engineImageInfo.put("errorCode", java.lang.Integer.valueOf(errorCode));
    }

    public final boolean isCorrectStatus() {
        return getErrorCode() == 0 || getErrorCode() == 36 || getErrorCode() == 28;
    }

    public final boolean isCorrectStatusOK() {
        return getErrorCode() == 0 || getErrorCode() == 28;
    }

    public final int getErrorCode() {
        try {
            java.lang.Integer integer = this.engineImageInfo.getInteger("errorCode");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(integer, "getInteger(...)");
            return integer.intValue();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getErrorCode error  ," + this.engineImageInfo, e);
            return -1;
        }
    }

    public final java.lang.String getErrorMessage() {
        try {
            java.lang.String string = this.engineImageInfo.getString("errorMessage");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getErrorMessage error  ," + this.engineImageInfo, e);
            return "";
        }
    }

    public final com.alibaba.fastjson.JSONArray getBlocks() {
        try {
            com.alibaba.fastjson.JSONArray jSONArray = this.engineImageInfo.getJSONArray("blocks");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
            return jSONArray;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getBlocks error  ," + this.engineImageInfo, e);
            return new com.alibaba.fastjson.JSONArray();
        }
    }

    public final int getBaseY() {
        try {
            java.lang.Integer integer = this.engineImageInfo.getInteger("basey");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(integer, "getInteger(...)");
            return integer.intValue();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getBaseY error  ," + this.engineImageInfo, e);
            return 0;
        }
    }

    public final int getBaseX() {
        try {
            java.lang.Integer integer = this.engineImageInfo.getInteger("basex");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(integer, "getInteger(...)");
            return integer.intValue();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getBaseX error  ," + this.engineImageInfo, e);
            return 0;
        }
    }

    public final int getTotalImageCount() {
        try {
            java.lang.Integer integer = this.engineImageInfo.getInteger("totalImageCount");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(integer, "getInteger(...)");
            return integer.intValue();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getTotalImageCount error  ," + this.engineImageInfo, e);
            return 0;
        }
    }

    public final int getImageIndex() {
        try {
            java.lang.Integer integer = this.engineImageInfo.getInteger("imageIndex");
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(integer, "getInteger(...)");
            return integer.intValue();
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getImageIndex error  ," + this.engineImageInfo, e);
            return 0;
        }
    }

    public final java.lang.String getFilePath() {
        try {
            java.lang.String string = this.engineImageInfo.getString("convertFileName");
            if (this.isV3Paper) {
                if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
                    return this.sourceImageFilePath;
                }
                kotlin.jvm.internal.Intrinsics.checkNotNull(string);
                return string;
            }
            java.lang.String str = string;
            if (str != null && str.length() != 0 && com.up366.common.FileUtilsUp.isFileExists(string)) {
                return string;
            }
            return this.sourceImageFilePath;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getFilePath error  ," + this.engineImageInfo, e);
            return this.sourceImageFilePath;
        }
    }

    public final java.lang.String getPreviewFilePath() {
        if (this.isV3Paper && com.up366.common.FileUtilsUp.isFileExists(this.sourceImageFilePath)) {
            return this.sourceImageFilePath;
        }
        return getFilePath();
    }

    public final java.lang.String getPicBase() {
        try {
            java.lang.String string = this.engineImageInfo.getString("imageOriginalFileName");
            if (this.isV3Paper) {
                if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
                    return this.sourceImageFilePath;
                }
                kotlin.jvm.internal.Intrinsics.checkNotNull(string);
                return string;
            }
            java.lang.String str = string;
            if (str != null && str.length() != 0 && com.up366.common.FileUtilsUp.isFileExists(string)) {
                return string;
            }
            return this.sourceImageFilePath;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getPicBase error  ," + this.engineImageInfo, e);
            return "";
        }
    }

    public final java.lang.String getEngineOriginalImageFileName() {
        try {
            java.lang.String string = this.engineImageInfo.getString("imageOriginalFileName");
            return string == null ? "" : string;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getEngineOriginalImageFileName error  ," + this.engineImageInfo, e);
            return "";
        }
    }

    public final java.lang.String getV3ForceSubmitOriginalUrl() {
        java.lang.String engineOriginalImageFileName = getEngineOriginalImageFileName();
        return !com.up366.common.StringUtils.isEmptyOrNull(engineOriginalImageFileName) ? engineOriginalImageFileName : this.uploadedImageUrl;
    }

    public java.lang.String toString() {
        java.lang.String string = this.engineImageInfo.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo");
        com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo = (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.engineImageInfo, photoAnswerImageInfo.engineImageInfo) && this.isForceUse == photoAnswerImageInfo.isForceUse && this.uiSelected == photoAnswerImageInfo.uiSelected && kotlin.jvm.internal.Intrinsics.areEqual(this.sourceImageFilePath, photoAnswerImageInfo.sourceImageFilePath) && this.isV3Paper == photoAnswerImageInfo.isV3Paper;
    }

    public int hashCode() {
        return (((((this.engineImageInfo.hashCode() * 31) + com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticBackport0.m(this.isForceUse)) * 31) + com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticBackport0.m(this.uiSelected)) * 31) + this.sourceImageFilePath.hashCode();
    }
}
