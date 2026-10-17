package com.up366.mobile.course.homework.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class AnswerDataOfTest {
    private com.up366.mobile.course.homework.model.AnswerDataOfTest.PaperInfo paperInfo;
    private com.up366.mobile.course.homework.model.AnswerDataOfTest.TestInfo testInfo;
    private com.up366.mobile.course.homework.model.AnswerDataOfTest.UserAnswer userAnswer;

    public com.up366.mobile.course.homework.model.AnswerDataOfTest.TestInfo getTestInfo() {
        return this.testInfo;
    }

    public void setTestInfo(com.up366.mobile.course.homework.model.AnswerDataOfTest.TestInfo testInfo) {
        this.testInfo = testInfo;
    }

    public com.up366.mobile.course.homework.model.AnswerDataOfTest.UserAnswer getUserAnswer() {
        return this.userAnswer;
    }

    public void setUserAnswer(com.up366.mobile.course.homework.model.AnswerDataOfTest.UserAnswer userAnswer) {
        this.userAnswer = userAnswer;
    }

    public com.up366.mobile.course.homework.model.AnswerDataOfTest.PaperInfo getPaperInfo() {
        return this.paperInfo;
    }

    public void setPaperInfo(com.up366.mobile.course.homework.model.AnswerDataOfTest.PaperInfo paperInfo) {
        this.paperInfo = paperInfo;
    }

    public class TestInfo {
        private long addTime;
        private long beginTime;
        private int duration;
        private long endTime;
        private java.lang.String paperId;
        private java.lang.String parameters;
        private java.lang.String spid;
        private java.lang.String testId;
        private java.lang.String testName;
        private int testType;

        public TestInfo() {
        }

        public long getAddTime() {
            return this.addTime;
        }

        public void setAddTime(long j) {
            this.addTime = j;
        }

        public long getBeginTime() {
            return this.beginTime;
        }

        public void setBeginTime(long j) {
            this.beginTime = j;
        }

        public int getDuration() {
            return this.duration;
        }

        public void setDuration(int i) {
            this.duration = i;
        }

        public long getEndTime() {
            return this.endTime;
        }

        public void setEndTime(long j) {
            this.endTime = j;
        }

        public java.lang.String getPaperId() {
            return this.paperId;
        }

        public void setPaperId(java.lang.String str) {
            this.paperId = str;
        }

        public java.lang.String getParameters() {
            return this.parameters;
        }

        public void setParameters(java.lang.String str) {
            this.parameters = str;
        }

        public java.lang.String getSpid() {
            return this.spid;
        }

        public void setSpid(java.lang.String str) {
            this.spid = str;
        }

        public java.lang.String getTestId() {
            return this.testId;
        }

        public void setTestId(java.lang.String str) {
            this.testId = str;
        }

        public java.lang.String getTestName() {
            return this.testName;
        }

        public void setTestName(java.lang.String str) {
            this.testName = str;
        }

        public int getTestType() {
            return this.testType;
        }

        public void setTestType(int i) {
            this.testType = i;
        }
    }

    public class UserAnswer {
        private java.lang.String answerData;
        private long beginTime;
        private int duration;
        private long endTime;
        private java.lang.String markComment;
        private java.lang.String markData;
        private float score;
        private int testStatus;

        public UserAnswer() {
        }

        public java.lang.String getMarkComment() {
            return this.markComment;
        }

        public void setMarkComment(java.lang.String str) {
            this.markComment = str;
        }

        public java.lang.String getAnswerData() {
            return this.answerData;
        }

        public void setAnswerData(java.lang.String str) {
            this.answerData = str;
        }

        public long getBeginTime() {
            return this.beginTime;
        }

        public void setBeginTime(long j) {
            this.beginTime = j;
        }

        public int getDuration() {
            return this.duration;
        }

        public void setDuration(int i) {
            this.duration = i;
        }

        public long getEndTime() {
            return this.endTime;
        }

        public void setEndTime(long j) {
            this.endTime = j;
        }

        public java.lang.String getMarkData() {
            return this.markData;
        }

        public void setMarkData(java.lang.String str) {
            this.markData = str;
        }

        public float getScore() {
            return this.score;
        }

        public void setScore(float f) {
            this.score = f;
        }

        public int getTestStatus() {
            return this.testStatus;
        }

        public void setTestStatus(int i) {
            this.testStatus = i;
        }
    }

    public class PaperInfo {
        private java.lang.String answerData;
        private java.lang.String cdnurl;
        private java.lang.String paperData;
        private float score;

        public PaperInfo() {
        }

        public float getScore() {
            return this.score;
        }

        public void setScore(float f) {
            this.score = f;
        }

        public java.lang.String getCdnurl() {
            return this.cdnurl;
        }

        public void setCdnurl(java.lang.String str) {
            this.cdnurl = str;
        }

        public java.lang.String getPaperData() {
            return this.paperData;
        }

        public void setPaperData(java.lang.String str) {
            this.paperData = str;
        }

        public java.lang.String getAnswerData() {
            return this.answerData;
        }

        public void setAnswerData(java.lang.String str) {
            this.answerData = str;
        }
    }
}
