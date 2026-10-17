package com.up366.mobile.course.task;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class TaskInfoV2 implements java.lang.Comparable<com.up366.mobile.course.task.TaskInfoV2> {
    public static final int ARISE_TYPE_FOLLOW = 2;
    public static final int ARISE_TYPE_TIMING = 1;
    public static final int TASK_STATUS_CURRENT = 1;
    public static final int TASK_STATUS_HISTORY = 2;
    public static final int TYPE_CUOTI = 4;
    public static final int TYPE_HUODONG = 7;
    public static final int TYPE_MOKAO = 11;
    public static final int TYPE_RUOXIANG = 8;
    public static final int TYPE_SHENGCI = 5;
    public static final int TYPE_TAOTI = 1;
    public static final int TYPE_ZHIBOKE = 6;
    public static final int TYPE_ZHUANGXIANG = 2;
    public static final int TYPE_ZUOYE = 3;
    private long ariseTime;
    private int ariseType;
    private int assignId;
    private long beginTime;
    private java.lang.String contentId;
    private int courseId;
    private java.lang.String courseName;
    private int displayOrder;
    private long endTime;
    private com.up366.mobile.course.task.TaskInfoV2.ExtParam extParam;
    private java.lang.String extParamString;
    private int flevel;
    private boolean isFinish;
    private java.lang.String jobComment;
    private java.lang.String jobId;
    private java.lang.String jobName;
    private transient java.lang.String jobNamePinYin;
    private java.lang.String jobScore;
    private transient int markStatus;
    private java.lang.Long rowId;
    private java.lang.String statement;
    private int studyPlanId;
    private java.lang.String studyTaskPid;
    private long submitTime;
    private int type;
    private transient int uploadStatus = -100;
    private transient boolean hasStart = true;
    private transient int batchNum = 0;
    private boolean noAnswer = false;
    private int returnState = 0;
    private java.lang.String returnCode = "0";

    public TaskInfoV2(java.lang.Long l, java.lang.String str, int i, int i2, long j, long j2, java.lang.String str2, java.lang.String str3, java.lang.String str4, boolean z, java.lang.String str5, int i3, java.lang.String str6, java.lang.String str7, int i4, long j3, int i5, int i6, long j4, int i7, java.lang.String str8, java.lang.String str9) {
        this.rowId = l;
        this.jobId = str;
        this.type = i;
        this.assignId = i2;
        this.beginTime = j;
        this.endTime = j2;
        this.jobName = str2;
        this.contentId = str3;
        this.extParamString = str4;
        this.isFinish = z;
        this.courseName = str5;
        this.courseId = i3;
        this.jobComment = str6;
        this.jobScore = str7;
        this.studyPlanId = i4;
        this.ariseTime = j3;
        this.ariseType = i5;
        this.displayOrder = i6;
        this.submitTime = j4;
        this.flevel = i7;
        this.studyTaskPid = str8;
        this.statement = str9;
    }

    public TaskInfoV2() {
    }

    public java.lang.String getStudyTaskPid() {
        return this.studyTaskPid;
    }

    public void setStudyTaskPid(java.lang.String str) {
        this.studyTaskPid = str;
    }

    public int getFlevel() {
        return this.flevel;
    }

    public void setFlevel(int i) {
        this.flevel = i;
    }

    public int getBatchNum() {
        return this.batchNum;
    }

    public void setBatchNum(int i) {
        this.batchNum = i;
    }

    public boolean isTimingTask() {
        return this.ariseType == 1;
    }

    public int getUploadStatus() {
        return this.uploadStatus;
    }

    public void setUploadStatus(int i) {
        this.uploadStatus = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public long getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(long j) {
        this.beginTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public java.lang.String getJobName() {
        return this.jobName;
    }

    public void setJobName(java.lang.String str) {
        this.jobName = str;
    }

    public java.lang.String getContentId() {
        return this.contentId;
    }

    public void setContentId(java.lang.String str) {
        this.contentId = str;
    }

    public java.lang.String getJobId() {
        return this.jobId;
    }

    public void setJobId(java.lang.String str) {
        this.jobId = str;
    }

    public int getStudyPlanId() {
        return this.studyPlanId;
    }

    public void setStudyPlanId(int i) {
        this.studyPlanId = i;
    }

    public long getAriseTime() {
        return this.ariseTime;
    }

    public void setAriseTime(long j) {
        this.ariseTime = j;
    }

    public int getAriseType() {
        return this.ariseType;
    }

    public void setAriseType(int i) {
        this.ariseType = i;
    }

    public com.up366.mobile.course.task.TaskInfoV2.ExtParam getExtParam() {
        if (this.extParam == null && !com.up366.common.StringUtils.isEmptyOrNull(this.extParamString)) {
            this.extParam = (com.up366.mobile.course.task.TaskInfoV2.ExtParam) com.alibaba.fastjson.JSON.parseObject(this.extParamString, com.up366.mobile.course.task.TaskInfoV2.ExtParam.class);
        }
        if (this.extParam == null) {
            this.extParam = new com.up366.mobile.course.task.TaskInfoV2.ExtParam();
        }
        return this.extParam;
    }

    public void setExtParam(com.up366.mobile.course.task.TaskInfoV2.ExtParam extParam) {
        if (extParam != null) {
            this.extParamString = com.alibaba.fastjson.JSON.toJSONString(extParam);
        }
        this.extParam = extParam;
    }

    public boolean isFinish() {
        return this.type == 3 ? getExtParam().getStuStatus() > 1 : getExtParam().getTaskStatus() == 1;
    }

    public boolean isHistory() {
        return this.isFinish || isFinish() || this.endTime < com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
    }

    public void setFinish(boolean z) {
        this.isFinish = z;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        if (getTaskWeight() - taskInfoV2.getTaskWeight() > 0) {
            return -1;
        }
        return getTaskWeight() - taskInfoV2.getTaskWeight() == 0 ? 0 : 1;
    }

    private long getTaskWeight() {
        long j;
        long j2;
        long j3;
        long currentNtpTimeInMillisecond = com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond();
        if (this.type == 6) {
            j = 4611686018427387903L;
            if (this.isFinish) {
                return 4611686018427387903L - this.beginTime;
            }
            j2 = this.beginTime;
            if (j2 < currentNtpTimeInMillisecond) {
                j3 = currentNtpTimeInMillisecond - j2;
                return j3 + j;
            }
            return 1152921504606846975L - (j2 - currentNtpTimeInMillisecond);
        }
        j = 2305843009213693951L;
        if (this.isFinish) {
            j3 = this.endTime;
            return j3 + j;
        }
        if (getBeginTime() < currentNtpTimeInMillisecond) {
            return 2305843009213693951L - (this.endTime - currentNtpTimeInMillisecond);
        }
        j2 = this.beginTime;
        return 1152921504606846975L - (j2 - currentNtpTimeInMillisecond);
    }

    public java.lang.String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(java.lang.String str) {
        this.courseName = str;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public void setCourseId(int i) {
        this.courseId = i;
    }

    public java.lang.String getJobComment() {
        return this.jobComment;
    }

    public void setJobComment(java.lang.String str) {
        this.jobComment = str;
    }

    public java.lang.String getJobScore() {
        return this.jobScore;
    }

    public void setJobScore(java.lang.String str) {
        this.jobScore = str;
    }

    public int getAssignId() {
        return this.assignId;
    }

    public void setAssignId(int i) {
        this.assignId = i;
    }

    public java.lang.String getJobNamePinYin() {
        if (android.text.TextUtils.isEmpty(this.jobNamePinYin)) {
            this.jobNamePinYin = com.up366.mobile.book.helper.PinYinHelper.INSTANCE.getPinYinString(this.jobName);
        }
        return this.jobNamePinYin;
    }

    public void setJobNamePinYin(java.lang.String str) {
        this.jobNamePinYin = str;
    }

    public java.lang.String getExtParamString() {
        return this.extParamString;
    }

    public void setExtParamString(java.lang.String str) {
        this.extParamString = str;
    }

    public boolean isHasStart() {
        return this.hasStart;
    }

    public void setHasStart(boolean z) {
        this.hasStart = z;
    }

    public int getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(int i) {
        this.displayOrder = i;
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public boolean getIsFinish() {
        return this.isFinish;
    }

    public void setIsFinish(boolean z) {
        this.isFinish = z;
    }

    public boolean getHasStart() {
        return this.hasStart;
    }

    public long getSubmitTime() {
        return this.submitTime;
    }

    public void setSubmitTime(long j) {
        this.submitTime = j;
    }

    public java.lang.String getStatement() {
        return this.statement;
    }

    public void setStatement(java.lang.String str) {
        this.statement = str;
    }

    public int getMarkStatus() {
        return this.markStatus;
    }

    public void setMarkStatus(int i) {
        this.markStatus = i;
    }

    public boolean isUploading() {
        int i = this.uploadStatus;
        return i == 0 || i == 1 || i == -1;
    }

    public static void saveSubmitTaskId(java.lang.String str) {
        com.up366.mobile.common.utils.PreferenceUtils.putString("new_submit_task_id", str);
    }

    public boolean isNewSubmit() {
        return this.jobId.equals(com.up366.mobile.common.utils.PreferenceUtils.getString("new_submit_task_id", ""));
    }

    public void setHistoryNoAnswer(boolean z) {
        this.noAnswer = z;
    }

    public boolean isHistoryNoAnswer() {
        return this.noAnswer;
    }

    public boolean getNoAnswer() {
        return this.noAnswer;
    }

    public void setNoAnswer(boolean z) {
        this.noAnswer = z;
    }

    public int getReturnState() {
        return this.returnState;
    }

    public void setReturnState(int i) {
        this.returnState = i;
    }

    public java.lang.String getReturnCode() {
        return this.returnCode;
    }

    public void setReturnCode(java.lang.String str) {
        this.returnCode = str;
    }

    public static class ExtParam {
        private int activityType;
        private java.lang.String bookId;
        private java.lang.String bookName;
        private int bookType;
        private java.lang.String chapterId;
        private int difficulty;
        private int duration;
        public int isPublished;
        private java.lang.String knowledgeId;
        private java.lang.String pageId;
        private java.lang.String paperId;
        private int playType;
        private int publishScore;
        private long publishTime;
        private int publishType;
        private int questionType;
        private java.lang.String roomId;
        private int scoreTime;
        private int stageId;
        private int stuStatus;
        private int subjectId;
        private long submitTime;
        public int taskKillFlag;
        private double taskScore;
        private int taskStatus;
        private int taskType;
        private int uid;
        private java.lang.String xotParam;

        public int getTaskPublishType(int i) {
            return i == 1 ? this.publishType : this.scoreTime;
        }

        public int getTaskPublishedStatus(int i) {
            return i == 1 ? this.isPublished : this.publishScore;
        }

        public int getPublishType() {
            return this.publishType;
        }

        public void setPublishType(int i) {
            this.publishType = i;
        }

        public int getIsPublished() {
            return this.isPublished;
        }

        public void setIsPublished(int i) {
            this.isPublished = i;
        }

        public java.lang.String getKnowledgeId() {
            return this.knowledgeId;
        }

        public void setKnowledgeId(java.lang.String str) {
            this.knowledgeId = str;
        }

        public int getDifficulty() {
            return this.difficulty;
        }

        public void setDifficulty(int i) {
            this.difficulty = i;
        }

        public long getPublishTime() {
            return this.publishTime;
        }

        public void setPublishTime(long j) {
            this.publishTime = j;
        }

        public java.lang.String getPaperId() {
            return this.paperId;
        }

        public void setPaperId(java.lang.String str) {
            this.paperId = str;
        }

        public java.lang.String getXotParam() {
            return this.xotParam;
        }

        public void setXotParam(java.lang.String str) {
            this.xotParam = str;
        }

        public int getDuration() {
            return this.duration;
        }

        public void setDuration(int i) {
            this.duration = i;
        }

        public int getUid() {
            return this.uid;
        }

        public void setUid(int i) {
            this.uid = i;
        }

        public int getStuStatus() {
            return this.stuStatus;
        }

        public void setStuStatus(int i) {
            this.stuStatus = i;
        }

        public int getActivityType() {
            return this.activityType;
        }

        public void setActivityType(int i) {
            this.activityType = i;
        }

        public java.lang.String getBookId() {
            return this.bookId;
        }

        public void setBookId(java.lang.String str) {
            this.bookId = str;
        }

        public java.lang.String getChapterId() {
            return this.chapterId;
        }

        public void setChapterId(java.lang.String str) {
            this.chapterId = str;
        }

        public java.lang.String getPageId() {
            return this.pageId;
        }

        public void setPageId(java.lang.String str) {
            this.pageId = str;
        }

        public int getTaskType() {
            return this.taskType;
        }

        public void setTaskType(int i) {
            this.taskType = i;
        }

        public double getTaskScore() {
            return this.taskScore;
        }

        public void setTaskScore(double d) {
            this.taskScore = d;
        }

        public int getBookType() {
            return this.bookType;
        }

        public void setBookType(int i) {
            this.bookType = i;
        }

        public java.lang.String getRoomId() {
            return this.roomId;
        }

        public void setRoomId(java.lang.String str) {
            this.roomId = str;
        }

        public int getPlayType() {
            return this.playType;
        }

        public void setPlayType(int i) {
            this.playType = i;
        }

        public java.lang.String getBookName() {
            return this.bookName;
        }

        public void setBookName(java.lang.String str) {
            this.bookName = str;
        }

        public int getStageId() {
            return this.stageId;
        }

        public void setStageId(int i) {
            this.stageId = i;
        }

        public int getSubjectId() {
            return this.subjectId;
        }

        public void setSubjectId(int i) {
            this.subjectId = i;
        }

        public int getScoreTime() {
            return this.scoreTime;
        }

        public void setScoreTime(int i) {
            this.scoreTime = i;
        }

        public int getPublishScore() {
            return this.publishScore;
        }

        public void setPublishScore(int i) {
            this.publishScore = i;
        }

        public int getTaskStatus() {
            return this.taskStatus;
        }

        public void setTaskStatus(int i) {
            this.taskStatus = i;
        }

        public long getSubmitTime() {
            return this.submitTime;
        }

        public void setSubmitTime(long j) {
            this.submitTime = j;
        }

        public int getQuestionType() {
            return this.questionType;
        }

        public void setQuestionType(int i) {
            this.questionType = i;
        }

        private java.lang.String getParamFromXotParam(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(this.xotParam)) {
                return "";
            }
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(this.xotParam);
            return object.containsKey(str) ? object.getString(str) : "";
        }

        public int getPaperType() {
            java.lang.String paramFromXotParam = getParamFromXotParam("paperType");
            if (android.text.TextUtils.isEmpty(paramFromXotParam)) {
                return 5;
            }
            try {
                return java.lang.Integer.parseInt(paramFromXotParam);
            } catch (java.lang.Exception unused) {
                return 5;
            }
        }

        public boolean canReTest() {
            java.lang.String paramFromXotParam = getParamFromXotParam("reTest");
            if (android.text.TextUtils.isEmpty(paramFromXotParam)) {
                return false;
            }
            try {
                return java.lang.Integer.parseInt(paramFromXotParam) == 1;
            } catch (java.lang.Exception unused) {
                return false;
            }
        }

        public boolean canPaperAnswer() {
            return canDownload() || canTakePhotoAnswer();
        }

        public boolean canDownload() {
            if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
                return false;
            }
            return "1".equals(getParamFromXotParam("downloadFlag"));
        }

        public boolean canTakePhotoAnswer() {
            return "1".equals(getParamFromXotParam("uploadFlag"));
        }

        public boolean isDisableStuPhotoAnswer() {
            return "1".equals(getParamFromXotParam("disabledStuPhotoAnswer"));
        }

        public boolean canOnlineAnswer() {
            return !"1".equals(getParamFromXotParam("disabledOnline"));
        }

        public boolean isHiddenTask() {
            return "1".equals(getParamFromXotParam("hiddenFlag"));
        }

        public boolean isPastExerciseCanRetest() {
            java.lang.String paramFromXotParam = getParamFromXotParam("pastExercise");
            return "1".equals(paramFromXotParam) || com.up366.common.StringUtils.isEmptyOrNull(paramFromXotParam);
        }

        public long getTestDuration() {
            java.lang.String paramFromXotParam = getParamFromXotParam("testDuration");
            if (android.text.TextUtils.isEmpty(paramFromXotParam)) {
                return 0L;
            }
            try {
                return java.lang.Long.parseLong(paramFromXotParam);
            } catch (java.lang.Exception unused) {
                return 0L;
            }
        }

        public java.lang.String getFileMd5() {
            return getParamFromXotParam("fileMd5");
        }
    }
}
