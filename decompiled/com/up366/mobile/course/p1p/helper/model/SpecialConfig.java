package com.up366.mobile.course.p1p.helper.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class SpecialConfig {
    private static final int DEFAULT_VALUE = -99;
    private java.util.List<java.lang.Integer> organIds;
    private int defaultType = -99;
    private int singleErrorHidden = -99;
    private int assembleRetryCount = -99;
    private int singleRetryCount = -99;
    private int enableEngineBlur = -99;
    private int enableEngineBlurForceUse = -99;
    private int blurMinValue = -99;
    private int engineBlurMinValue = -99;
    private int enableAlumSelect = -99;
    private int enableEngineCheckImage = -99;
    private int useCameraX = -99;
    private int autofix = -99;
    private int maxNoLabelSeconds = -99;
    private int maxNotPhotoSeconds = -99;

    public java.util.List<java.lang.Integer> getOrganIds() {
        return this.organIds;
    }

    public void setOrganIds(java.util.List<java.lang.Integer> list) {
        this.organIds = list;
    }

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

    public com.up366.mobile.course.p1p.helper.model.DefaultConfig getP1pConfigData(com.up366.mobile.course.p1p.helper.model.DefaultConfig defaultConfig) {
        int i = this.defaultType;
        if (i != -99) {
            defaultConfig.setDefaultType(i);
        }
        int i2 = this.singleErrorHidden;
        if (i2 != -99) {
            defaultConfig.setSingleErrorHidden(i2);
        }
        int i3 = this.assembleRetryCount;
        if (i3 != -99) {
            defaultConfig.setAssembleRetryCount(i3);
        }
        int i4 = this.singleRetryCount;
        if (i4 != -99) {
            defaultConfig.setSingleRetryCount(i4);
        }
        int i5 = this.blurMinValue;
        if (i5 != -99) {
            defaultConfig.setBlurMinValue(i5);
        }
        int i6 = this.engineBlurMinValue;
        if (i6 != -99) {
            defaultConfig.setEngineBlurMinValue(i6);
        }
        int i7 = this.enableEngineBlur;
        if (i7 != -99) {
            defaultConfig.setEnableEngineBlur(i7);
        }
        int i8 = this.enableEngineBlurForceUse;
        if (i8 != -99) {
            defaultConfig.setEnableEngineBlurForceUse(i8);
        }
        int i9 = this.enableAlumSelect;
        if (i9 != -99) {
            defaultConfig.setEnableAlumSelect(i9);
        }
        int i10 = this.enableEngineCheckImage;
        if (i10 != -99) {
            defaultConfig.setEnableEngineCheckImage(i10);
        }
        int i11 = this.useCameraX;
        if (i11 != -99) {
            defaultConfig.setUseCameraX(i11);
        }
        int i12 = this.autofix;
        if (i12 != -99) {
            defaultConfig.setAutofix(i12);
        }
        int i13 = this.maxNoLabelSeconds;
        if (i13 != -99) {
            defaultConfig.setMaxNoLabelSeconds(i13);
        }
        int i14 = this.maxNotPhotoSeconds;
        if (i14 != -99) {
            defaultConfig.setMaxNotPhotoSeconds(i14);
        }
        return defaultConfig;
    }
}
