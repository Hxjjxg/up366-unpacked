package com.up366.asecengine.englishengine.log;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class RecordTraceLogger {
    public static final java.lang.String RECORD_PAGE = "study_record";
    private static final java.lang.String TAG = "ASES-REC-TRACE";
    private final long startTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
    private final java.lang.String traceId;

    private RecordTraceLogger(java.lang.String str) {
        this.traceId = str;
    }

    public static com.up366.asecengine.englishengine.log.RecordTraceLogger create(com.up366.asecengine.englishengine.AsecSession asecSession) {
        return new com.up366.asecengine.englishengine.log.RecordTraceLogger(asecSession.getSessionId() + "_" + com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond());
    }

    public java.lang.String getTraceId() {
        return this.traceId;
    }

    private void log(com.up366.asecengine.englishengine.log.RecordTraceEvent recordTraceEvent, java.lang.String str) {
        com.up366.common.log.Logger.info("ASES-REC-TRACE " + ("traceId=" + this.traceId + " event=" + recordTraceEvent.name() + " t=" + (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - this.startTime) + "ms " + str));
    }

    private void logError(com.up366.asecengine.englishengine.log.RecordTraceEvent recordTraceEvent, java.lang.String str, java.lang.Throwable th) {
        com.up366.common.log.Logger.error("ASES-REC-TRACE " + ("traceId=" + this.traceId + " event=" + recordTraceEvent.name() + " t=" + (com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - this.startTime) + "ms " + str), th);
    }

    public void onStart() {
        log(com.up366.asecengine.englishengine.log.RecordTraceEvent.START, "");
    }

    public void onAudioInit(android.media.AudioRecord audioRecord, boolean z) {
        if (audioRecord == null) {
            log(com.up366.asecengine.englishengine.log.RecordTraceEvent.AUDIO_INIT, "AudioRecord=null");
            return;
        }
        log(com.up366.asecengine.englishengine.log.RecordTraceEvent.AUDIO_INIT, "sampleRate=" + audioRecord.getSampleRate() + " channelCount=" + audioRecord.getChannelCount() + " bufferFrames=" + audioRecord.getBufferSizeInFrames() + " state=" + audioRecord.getState() + " newFactory=" + z);
    }

    public void onLoopBreak(java.lang.String str, int i) {
        log(com.up366.asecengine.englishengine.log.RecordTraceEvent.LOOP_BREAK, "reason=" + str + " state=" + i);
    }

    public void onReadError(int i) {
        log(com.up366.asecengine.englishengine.log.RecordTraceEvent.READ_ERROR, "readSize=" + i);
    }

    public void onReadSummary(int i, int i2, java.lang.String str, boolean z, long j, long j2, int i3, int i4, long j3, int i5, int i6) {
        com.up366.asecengine.englishengine.log.RecordTraceLogger.RecordSummary recordSummary = new com.up366.asecengine.englishengine.log.RecordTraceLogger.RecordSummary();
        recordSummary.setSessionCode(i);
        recordSummary.setSessionExtCode(i2);
        recordSummary.setUseNewRecordFactory(z);
        recordSummary.setReadCount(j);
        recordSummary.setAudioDataSize(j2);
        recordSummary.setAllZeroCount(i3);
        recordSummary.setFirstReadSize(i4);
        recordSummary.setFirstReadTime(j3);
        recordSummary.setFirstNonZeroIndex(i5);
        recordSummary.setReadSizeZeroCount(i6);
        recordSummary.setMessage(str);
        recordSummary.setDuration(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond() - this.startTime);
        recordSummary.setStartTime(com.up366.common.TimeUtils.formatTime(this.startTime, "yyyy-MM-dd HH:mm:ss.SSS"));
        java.lang.String jSONString = com.alibaba.fastjson.JSON.toJSONString(recordSummary);
        log(com.up366.asecengine.englishengine.log.RecordTraceEvent.READ_SUMMARY, "summary=" + jSONString);
        com.up366.common.global.GB.get().sendLog(RECORD_PAGE, jSONString);
    }

    public void onTmpFileState(java.io.File file) {
        if (file == null) {
            return;
        }
        log(com.up366.asecengine.englishengine.log.RecordTraceEvent.TMP_FILE_STATE, "exists=" + file.exists() + " size=" + file.length() + " path=" + file.getAbsolutePath());
    }

    public void onFinalFileState(java.io.File file) {
        if (file == null) {
            return;
        }
        log(com.up366.asecengine.englishengine.log.RecordTraceEvent.FINAL_FILE_STATE, "exists=" + file.exists() + " size=" + file.length());
    }

    public void onStop(boolean z) {
        log(z ? com.up366.asecengine.englishengine.log.RecordTraceEvent.FORCE_STOP : com.up366.asecengine.englishengine.log.RecordTraceEvent.STOP, "");
    }

    public void onError(java.lang.String str, java.lang.Throwable th) {
        logError(com.up366.asecengine.englishengine.log.RecordTraceEvent.ERROR, str, th);
    }

    public static final class RecordSummary {
        private int allZeroCount;
        private long audioDataSize;
        private long duration;
        private int firstNonZeroIndex;
        private int firstReadSize;
        private long firstReadTime;
        private java.lang.String message;
        private long readCount;
        private int readSizeZeroCount;
        private int sessionCode;
        private int sessionExtCode;
        private java.lang.String startTime;
        private boolean useNewRecordFactory;

        public int getSessionCode() {
            return this.sessionCode;
        }

        public void setSessionCode(int i) {
            this.sessionCode = i;
        }

        public int getSessionExtCode() {
            return this.sessionExtCode;
        }

        public void setSessionExtCode(int i) {
            this.sessionExtCode = i;
        }

        public boolean isUseNewRecordFactory() {
            return this.useNewRecordFactory;
        }

        public void setUseNewRecordFactory(boolean z) {
            this.useNewRecordFactory = z;
        }

        public long getReadCount() {
            return this.readCount;
        }

        public void setReadCount(long j) {
            this.readCount = j;
        }

        public long getAudioDataSize() {
            return this.audioDataSize;
        }

        public void setAudioDataSize(long j) {
            this.audioDataSize = j;
        }

        public int getAllZeroCount() {
            return this.allZeroCount;
        }

        public void setAllZeroCount(int i) {
            this.allZeroCount = i;
        }

        public int getFirstReadSize() {
            return this.firstReadSize;
        }

        public void setFirstReadSize(int i) {
            this.firstReadSize = i;
        }

        public long getFirstReadTime() {
            return this.firstReadTime;
        }

        public void setFirstReadTime(long j) {
            this.firstReadTime = j;
        }

        public int getFirstNonZeroIndex() {
            return this.firstNonZeroIndex;
        }

        public void setFirstNonZeroIndex(int i) {
            this.firstNonZeroIndex = i;
        }

        public int getReadSizeZeroCount() {
            return this.readSizeZeroCount;
        }

        public void setReadSizeZeroCount(int i) {
            this.readSizeZeroCount = i;
        }

        public java.lang.String getMessage() {
            return this.message;
        }

        public void setMessage(java.lang.String str) {
            this.message = str;
        }

        public long getDuration() {
            return this.duration;
        }

        public void setDuration(long j) {
            this.duration = j;
        }

        public java.lang.String getStartTime() {
            return this.startTime;
        }

        public void setStartTime(java.lang.String str) {
            this.startTime = str;
        }
    }
}
