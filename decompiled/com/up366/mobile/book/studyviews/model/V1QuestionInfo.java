package com.up366.mobile.book.studyviews.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V1QuestionInfo implements java.io.Serializable {
    public static final int FAULT_QUESTION = 0;
    public static final int REAL_QUESTION = 1;
    private static final long serialVersionUID = -5092071767239166968L;
    private java.lang.String delay;
    private int display;
    private int flag;
    private java.lang.String mp3;
    private java.lang.String questionId;
    private final java.lang.String kJsonFlag = "flag";
    private final java.lang.String kJsonQuestionId = "questionId";
    private final java.lang.String kJsonMp3 = "mp3";
    private final java.lang.String kJsonDelay = "delay";
    private final java.lang.String kJsonDisplay = "display";
    private int duration = 0;

    public V1QuestionInfo() {
    }

    public V1QuestionInfo(com.alibaba.fastjson.JSONObject jSONObject) {
        int iIntValue = 0;
        try {
            this.flag = jSONObject.getIntValue("flag");
            if (jSONObject.containsKey("questionId")) {
                this.questionId = jSONObject.getString("questionId");
            }
            if (jSONObject.containsKey("mp3")) {
                this.mp3 = jSONObject.getString("mp3");
            }
            if (jSONObject.containsKey("delay")) {
                this.delay = jSONObject.getString("delay");
            }
            if (jSONObject.containsKey("display")) {
                java.lang.String string = jSONObject.getString("display");
                if (!"".equals(string)) {
                    iIntValue = java.lang.Integer.valueOf(string).intValue();
                }
                this.display = iIntValue;
            }
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error(e.getMessage());
        }
    }

    public int getFlag() {
        return this.flag;
    }

    public void setFlag(int i) {
        this.flag = i;
    }

    public java.lang.String getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(java.lang.String str) {
        this.questionId = str;
    }

    public java.lang.String getMp3() {
        return this.mp3;
    }

    public void setMp3(java.lang.String str) {
        this.mp3 = str;
    }

    public java.lang.String getDelay() {
        return this.delay;
    }

    public void setDelay(java.lang.String str) {
        this.delay = str;
    }

    public int getDisplay() {
        return this.display;
    }

    public void setDisplay(int i) {
        this.display = i;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int i) {
        this.duration = i;
    }
}
