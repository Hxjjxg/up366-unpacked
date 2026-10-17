package com.up366.asecengine.englishengine.v2.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsecRecordV2Config {
    private com.up366.asecengine.englishengine.v2.model.AsecLocalScoringConfig localScoringConfig;
    private com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig onlineScoringConfig;
    private java.lang.String recordId;
    private java.lang.Integer userId;
    private java.lang.String wavPath;
    private int dualModeStartPolicy = 0;
    private int fftStyle = 0;
    private int samplingRate = 12;
    private int scoringType = 0;

    public java.lang.String getRecordId() {
        return this.recordId;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecRecordV2Config setRecordId(java.lang.String str) {
        this.recordId = str;
        return this;
    }

    public java.lang.String getWavPath() {
        return this.wavPath;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecRecordV2Config setWavPath(java.lang.String str) {
        this.wavPath = str;
        return this;
    }

    public int getFftStyle() {
        return this.fftStyle;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecRecordV2Config setFftStyle(int i) {
        this.fftStyle = i;
        return this;
    }

    public int getSamplingRate() {
        return this.samplingRate;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecRecordV2Config setSamplingRate(int i) {
        if (i <= 0) {
            i = 12;
        }
        this.samplingRate = i;
        return this;
    }

    public int getScoringType() {
        return this.scoringType;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecRecordV2Config setScoringType(int i) {
        this.scoringType = i;
        return this;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig getOnlineScoringConfig() {
        return this.onlineScoringConfig;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecRecordV2Config setOnlineScoringConfig(com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig asecOnlineScoringConfig) {
        this.onlineScoringConfig = asecOnlineScoringConfig;
        return this;
    }

    public int getDualModeStartPolicy() {
        return this.dualModeStartPolicy;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecRecordV2Config setDualModeStartPolicy(int i) {
        if (i != 1) {
            this.dualModeStartPolicy = 0;
        } else {
            this.dualModeStartPolicy = i;
        }
        return this;
    }

    public java.lang.Integer getUserId() {
        return this.userId;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecRecordV2Config setUserId(java.lang.Integer num) {
        this.userId = num;
        return this;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecLocalScoringConfig getLocalScoringConfig() {
        return this.localScoringConfig;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecRecordV2Config setLocalScoringConfig(com.up366.asecengine.englishengine.v2.model.AsecLocalScoringConfig asecLocalScoringConfig) {
        this.localScoringConfig = asecLocalScoringConfig;
        return this;
    }
}
