package com.up366.asecengine.englishengine.v2.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsecLocalScoringConfig {
    private java.lang.String netFiles;
    private com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig paragraphScoringConfig;
    private int partType = 3;
    private boolean async = false;
    private int jsonType = 0;
    private int barNum = 12;
    private java.util.List<com.up366.asecengine.model.KeyValue> sessionParams = new java.util.ArrayList();

    public int getPartType() {
        return this.partType;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecLocalScoringConfig setPartType(int i) {
        this.partType = i;
        return this;
    }

    public java.lang.String getNetFiles() {
        return this.netFiles;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecLocalScoringConfig setNetFiles(java.lang.String str) {
        this.netFiles = str;
        return this;
    }

    public boolean isAsync() {
        return this.async;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecLocalScoringConfig setAsync(boolean z) {
        this.async = z;
        return this;
    }

    public int getJsonType() {
        return this.jsonType;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecLocalScoringConfig setJsonType(int i) {
        this.jsonType = i;
        return this;
    }

    public int getBarNum() {
        return this.barNum;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecLocalScoringConfig setBarNum(int i) {
        if (i <= 0) {
            i = 12;
        }
        this.barNum = i;
        return this;
    }

    public java.util.List<com.up366.asecengine.model.KeyValue> getSessionParams() {
        return this.sessionParams;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecLocalScoringConfig setSessionParams(java.util.List<com.up366.asecengine.model.KeyValue> list) {
        if (list == null) {
            list = new java.util.ArrayList<>();
        }
        this.sessionParams = list;
        return this;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig getParagraphScoringConfig() {
        return this.paragraphScoringConfig;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecLocalScoringConfig setParagraphScoringConfig(com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig asecParagraphScoringConfig) {
        this.paragraphScoringConfig = asecParagraphScoringConfig;
        return this;
    }
}
