package com.up366.asecengine.englishengine.v2.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AsecOnlineScoringConfig {
    public static final int DEFAULT_PACKET_RETRY_MAX_COUNT = 0;
    public static final long DEFAULT_STOP_ACK_WAIT_MS = 100;
    public static final long MAX_STOP_ACK_WAIT_MS = 3000;
    public static final long MIN_STOP_ACK_WAIT_MS = 50;
    private com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig webSocketConfig;
    private com.alibaba.fastjson.JSONObject onlineScoringParameters = new com.alibaba.fastjson.JSONObject();
    private long stopAckWaitMs = 100;
    private int packetRetryMaxCount = 0;
    private com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy autoResumePolicy = new com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy();

    public com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig getWebSocketConfig() {
        return this.webSocketConfig;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig setWebSocketConfig(com.up366.asecengine.englishengine.v2.model.AsecWebSocketConfig asecWebSocketConfig) {
        this.webSocketConfig = asecWebSocketConfig;
        return this;
    }

    public com.alibaba.fastjson.JSONObject getOnlineScoringParameters() {
        return com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.cloneObject(this.onlineScoringParameters);
    }

    public com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig setOnlineScoringParameters(com.alibaba.fastjson.JSONObject jSONObject) {
        com.alibaba.fastjson.JSONObject jSONObjectCloneObject;
        if (jSONObject == null) {
            jSONObjectCloneObject = new com.alibaba.fastjson.JSONObject();
        } else {
            jSONObjectCloneObject = com.up366.asecengine.englishengine.v2.AsecOnlineJsonHelper.cloneObject(jSONObject);
        }
        this.onlineScoringParameters = jSONObjectCloneObject;
        return this;
    }

    public long getStopAckWaitMs() {
        return this.stopAckWaitMs;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig setStopAckWaitMs(long j) {
        if (j < 50) {
            this.stopAckWaitMs = 50L;
        } else if (j > MAX_STOP_ACK_WAIT_MS) {
            this.stopAckWaitMs = MAX_STOP_ACK_WAIT_MS;
        } else {
            this.stopAckWaitMs = j;
        }
        return this;
    }

    public int getPacketRetryMaxCount() {
        return this.packetRetryMaxCount;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig setPacketRetryMaxCount(int i) {
        this.packetRetryMaxCount = java.lang.Math.max(0, i);
        return this;
    }

    public com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy getAutoResumePolicy() {
        return this.autoResumePolicy.copy();
    }

    public com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig setAutoResumePolicy(com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy asecOnlineAutoResumePolicy) {
        com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy asecOnlineAutoResumePolicyCopy;
        if (asecOnlineAutoResumePolicy == null) {
            asecOnlineAutoResumePolicyCopy = new com.up366.asecengine.englishengine.v2.model.AsecOnlineAutoResumePolicy();
        } else {
            asecOnlineAutoResumePolicyCopy = asecOnlineAutoResumePolicy.copy();
        }
        this.autoResumePolicy = asecOnlineAutoResumePolicyCopy;
        return this;
    }
}
