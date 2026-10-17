package com.up366.asecengine.englishengine.v2.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsecParagraphScoringConfig {
    public static final java.lang.String DATA_TYPE_JSON = "json";
    public static final java.lang.String DATA_TYPE_PATH = "path";
    public static final int SCOPE_SUB_RESOURCE = 1;
    public static final int SCOPE_WHOLE = 0;
    private java.lang.String ruleData;
    private java.lang.String sourceData;
    private int scope = 0;
    private java.lang.String sourceDataType = DATA_TYPE_PATH;
    private java.lang.String ruleDataType = DATA_TYPE_PATH;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface DataType {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Scope {
    }

    public static com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig wholeFromPath(java.lang.String str) {
        return new com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig().setScope(0).setSourceData(str).setSourceDataType(DATA_TYPE_PATH);
    }

    public static com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig wholeFromJson(java.lang.String str) {
        return new com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig().setScope(0).setSourceData(str).setSourceDataType(DATA_TYPE_JSON);
    }

    public static com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig subResourceFromPath(java.lang.String str, java.lang.String str2) {
        return new com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig().setScope(1).setSourceData(str).setSourceDataType(DATA_TYPE_PATH).setRuleData(str2).setRuleDataType(DATA_TYPE_PATH);
    }

    public static com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig subResourceFromJson(java.lang.String str, java.lang.String str2) {
        return new com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig().setScope(1).setSourceData(str).setSourceDataType(DATA_TYPE_JSON).setRuleData(str2).setRuleDataType(DATA_TYPE_JSON);
    }

    public int getScope() {
        return this.scope;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig setScope(int i) {
        this.scope = i;
        return this;
    }

    public java.lang.String getSourceData() {
        return this.sourceData;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig setSourceData(java.lang.String str) {
        this.sourceData = str;
        return this;
    }

    public java.lang.String getSourceDataType() {
        return this.sourceDataType;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig setSourceDataType(java.lang.String str) {
        this.sourceDataType = str;
        return this;
    }

    public java.lang.String getRuleData() {
        return this.ruleData;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig setRuleData(java.lang.String str) {
        this.ruleData = str;
        return this;
    }

    public java.lang.String getRuleDataType() {
        return this.ruleDataType;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig setRuleDataType(java.lang.String str) {
        this.ruleDataType = str;
        return this;
    }

    public void validate() {
        int i = this.scope;
        if (i != 0 && i != 1) {
            throw new java.lang.IllegalArgumentException("未知的段落评分范围：" + this.scope);
        }
        validateData("段落原始评分资源", this.sourceData, this.sourceDataType);
        if (this.scope == 1) {
            validateData("段落子资源规则", this.ruleData, this.ruleDataType);
        }
    }

    private void validateData(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (str2 == null || str2.trim().length() == 0) {
            throw new java.lang.IllegalArgumentException(str + "不能为空");
        }
        if (DATA_TYPE_PATH.equals(str3) || DATA_TYPE_JSON.equals(str3)) {
            return;
        }
        throw new java.lang.IllegalArgumentException(str + "类型只支持 path 或 json");
    }
}
