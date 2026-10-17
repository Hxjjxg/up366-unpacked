package com.up366.mobile.course.p1p.helper.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class DefaultConfig {
    public static final int DEFAULT_ENGINE_MIN_BLUR = 50;
    public static final int DEFAULT_MIN_BLUR = 40;
    private int defaultType = 1;
    private int singleErrorHidden = 0;
    private int assembleRetryCount = 1;
    private int singleRetryCount = 2;
    private int enableEngineBlur = 1;
    private int enableEngineBlurForceUse = 0;
    private int blurMinValue = 40;
    private int enableAlumSelect = 0;
    private int engineBlurMinValue = 50;
    private int enableEngineCheckImage = 1;
    private java.lang.String disableCheckImageUids = "";
    private int useCameraX = 0;
    private int autofix = 1;
    private int maxNoLabelSeconds = 10;
    private int maxNotPhotoSeconds = 5;

    public int getDefaultType() {
        return this.defaultType;
    }

    public void setDefaultType(int i) {
        this.defaultType = i;
    }

    public int getSingleErrorHidden() {
        return this.singleErrorHidden;
    }

    public void setSingleErrorHidden(int i) {
        this.singleErrorHidden = i;
    }

    public int getAssembleRetryCount() {
        return this.assembleRetryCount;
    }

    public void setAssembleRetryCount(int i) {
        this.assembleRetryCount = i;
    }

    public int getSingleRetryCount() {
        return this.singleRetryCount;
    }

    public void setSingleRetryCount(int i) {
        this.singleRetryCount = i;
    }

    public boolean isOnline() {
        return this.defaultType == 1;
    }

    public boolean isForceUse() {
        return this.defaultType == 0;
    }

    public int getBlurMinValue() {
        return this.blurMinValue;
    }

    public void setBlurMinValue(int i) {
        this.blurMinValue = i;
    }

    public int getEngineBlurMinValue() {
        return this.engineBlurMinValue;
    }

    public void setEngineBlurMinValue(int i) {
        this.engineBlurMinValue = i;
    }

    public int getEnableEngineBlur() {
        return this.enableEngineBlur;
    }

    public void setEnableEngineBlur(int i) {
        this.enableEngineBlur = i;
    }

    public int getEnableEngineBlurForceUse() {
        return this.enableEngineBlurForceUse;
    }

    public void setEnableEngineBlurForceUse(int i) {
        this.enableEngineBlurForceUse = i;
    }

    public int getEnableAlumSelect() {
        return this.enableAlumSelect;
    }

    public void setEnableAlumSelect(int i) {
        this.enableAlumSelect = i;
    }

    public int getEnableEngineCheckImage() {
        return this.enableEngineCheckImage;
    }

    public void setEnableEngineCheckImage(int i) {
        this.enableEngineCheckImage = i;
    }

    public java.lang.String getDisableCheckImageUids() {
        return this.disableCheckImageUids;
    }

    public void setDisableCheckImageUids(java.lang.String str) {
        this.disableCheckImageUids = str;
    }

    public int getUseCameraX() {
        return this.useCameraX;
    }

    public void setUseCameraX(int i) {
        this.useCameraX = i;
    }

    public int getAutofix() {
        return this.autofix;
    }

    public void setAutofix(int i) {
        this.autofix = i;
    }

    public int getMaxNoLabelSeconds() {
        return this.maxNoLabelSeconds;
    }

    public void setMaxNoLabelSeconds(int i) {
        this.maxNoLabelSeconds = i;
    }

    public int getMaxNotPhotoSeconds() {
        return this.maxNotPhotoSeconds;
    }

    public void setMaxNotPhotoSeconds(int i) {
        this.maxNotPhotoSeconds = i;
    }
}
