package com.up366.mobile.book.exercise.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ExerciseData {
    public static final int MARK_NO = 0;
    public static final int MARK_YES = 1;
    public static final int SUBMIT_NO = 0;
    public static final int SUBMIT_YES = 1;
    private long answerTime;
    private java.lang.String answerXml;
    private int curPage;
    private long enterTime;
    private java.lang.String exerciseId;
    private int halfRightNum;
    private int hasMark;
    private boolean hasPause;
    private int hasSubmit;
    private java.lang.String markXml;
    private java.lang.String paperXml;
    private java.lang.String qstWordMap;
    private int questionNum;
    private java.lang.String resourceDir;
    private int rightNum;
    private java.lang.Long rowId;
    private float score;
    private java.lang.String standardXml;
    private long startTime;
    private long submitTime;
    private float totalScore;
    private int version;
    private java.lang.String wordIds;
    private int wrongWordSize;

    public ExerciseData() {
        this.version = 0;
    }

    public ExerciseData(java.lang.Long l, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, int i, int i2, int i3, float f, long j, long j2, long j3, int i4, float f2, int i5, int i6, int i7, java.lang.String str7, int i8, java.lang.String str8, long j4, boolean z) {
        this.rowId = l;
        this.exerciseId = str;
        this.paperXml = str2;
        this.standardXml = str3;
        this.answerXml = str4;
        this.markXml = str5;
        this.resourceDir = str6;
        this.hasSubmit = i;
        this.hasMark = i2;
        this.curPage = i3;
        this.score = f;
        this.startTime = j;
        this.submitTime = j2;
        this.answerTime = j3;
        this.version = i4;
        this.totalScore = f2;
        this.questionNum = i5;
        this.rightNum = i6;
        this.wrongWordSize = i7;
        this.wordIds = str7;
        this.halfRightNum = i8;
        this.qstWordMap = str8;
        this.enterTime = j4;
        this.hasPause = z;
    }

    public void resetEnterTime() {
        this.enterTime = android.os.SystemClock.elapsedRealtime();
    }

    public void resetAllTime() {
        this.answerTime = 0L;
        this.startTime = 0L;
        this.submitTime = 0L;
        this.enterTime = android.os.SystemClock.elapsedRealtime();
    }

    public void startExercise() {
        resetAllTime();
        this.startTime = android.os.SystemClock.elapsedRealtime();
        this.markXml = "";
        this.hasSubmit = 0;
        this.hasMark = 0;
        setAnswerXml("");
    }

    public void resetExercise() {
        resetAllTime();
        this.markXml = "";
        this.hasSubmit = 0;
        this.hasMark = 0;
        setAnswerXml("");
    }

    public void addTime() {
        if (hasSubmit()) {
            return;
        }
        this.answerTime += android.os.SystemClock.elapsedRealtime() - this.enterTime;
        resetEnterTime();
    }

    public java.lang.String getExerciseId() {
        return this.exerciseId;
    }

    public void setExerciseId(java.lang.String str) {
        this.exerciseId = str;
    }

    public java.lang.String getPaperXml() {
        return this.paperXml;
    }

    public void setPaperXml(java.lang.String str) {
        this.paperXml = str;
    }

    public java.lang.String getStandardXml() {
        return this.standardXml;
    }

    public void setStandardXml(java.lang.String str) {
        this.standardXml = str;
    }

    public java.lang.String getAnswerXml() {
        return this.answerXml;
    }

    public void setAnswerXml(java.lang.String str) {
        this.answerXml = str;
    }

    public java.lang.String getMarkXml() {
        return this.markXml;
    }

    public void setMarkXml(java.lang.String str) {
        this.markXml = str;
    }

    public int getHasSubmit() {
        return this.hasSubmit;
    }

    public void setHasSubmit(int i) {
        this.hasSubmit = i;
    }

    public int getHasMark() {
        return this.hasMark;
    }

    public void setHasMark(int i) {
        this.hasMark = i;
    }

    public boolean hasMarked() {
        return 1 == this.hasMark;
    }

    public int getCurPage() {
        return this.curPage;
    }

    public void setCurPage(int i) {
        this.curPage = i;
    }

    public float getScore() {
        return this.score;
    }

    public void setScore(float f) {
        this.score = f;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setSubmitTime() {
        this.submitTime = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
    }

    public long getSubmitTime() {
        return this.submitTime;
    }

    public void setSubmitTime(long j) {
        this.submitTime = j;
    }

    public long getAnswerTime() {
        return this.answerTime;
    }

    public void setAnswerTime(long j) {
        this.answerTime = j;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public float getTotalScore() {
        return this.totalScore;
    }

    public void setTotalScore(float f) {
        this.totalScore = f;
    }

    public int getQuestionNum() {
        return this.questionNum;
    }

    public void setQuestionNum(int i) {
        this.questionNum = i;
    }

    public int getRightNum() {
        return this.rightNum;
    }

    public void setRightNum(int i) {
        this.rightNum = i;
    }

    public int getWrongWordSize() {
        return this.wrongWordSize;
    }

    public void setWrongWordSize(int i) {
        this.wrongWordSize = i;
    }

    public java.lang.String getWordIds() {
        return this.wordIds;
    }

    public void setWordIds(java.lang.String str) {
        this.wordIds = str;
    }

    public boolean hasPause() {
        return this.hasPause;
    }

    public void resume() {
        this.hasPause = false;
        resetEnterTime();
    }

    public void pause() {
        addTime();
        com.up366.mobile.common.logic.Auth.cur().db().getExerciseDataDao().insertOrReplace(this);
        this.hasPause = true;
    }

    public void save() {
        addTime();
        com.up366.mobile.common.logic.Auth.cur().db().getExerciseDataDao().insertOrReplace(this);
    }

    public boolean hasSubmit() {
        return this.hasSubmit == 1;
    }

    public java.lang.String getResourceDir() {
        return this.resourceDir;
    }

    public void setResourceDir(java.lang.String str) {
        this.resourceDir = str;
    }

    public java.lang.String getLocalResourceDir() {
        if (this.resourceDir.startsWith("http")) {
            return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppExternalCacheDir(), "exercise", "res", this.exerciseId);
        }
        return this.resourceDir;
    }

    public java.lang.String getAnswerDir() {
        return com.up366.common.FileUtilsUp.join(com.up366.mobile.common.utils.AppFileUtils.getAppInternalFilesDir(), java.lang.String.valueOf(com.up366.mobile.common.logic.Auth.UID()), this.exerciseId);
    }

    public int getWrongNum() {
        return (this.questionNum - this.rightNum) - this.halfRightNum;
    }

    public int getHalfRightNum() {
        return this.halfRightNum;
    }

    public void setHalfRightNum(int i) {
        this.halfRightNum = i;
    }

    public java.lang.String getQstWordMap() {
        return this.qstWordMap;
    }

    public void setQstWordMap(java.lang.String str) {
        this.qstWordMap = str;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public long getEnterTime() {
        return this.enterTime;
    }

    public void setEnterTime(long j) {
        this.enterTime = j;
    }

    public boolean getHasPause() {
        return this.hasPause;
    }

    public void setHasPause(boolean z) {
        this.hasPause = z;
    }
}
