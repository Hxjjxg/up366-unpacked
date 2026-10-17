package com.up366.mobile.common.logic.model;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Messages implements java.io.Serializable {
    public static final int HAS_READ = 1;
    public static final int NO_READ = 0;
    private static final long serialVersionUID = -3178599057080333486L;
    private java.lang.String content;
    private com.up366.mobile.common.logic.model.Messages.Extend ext;
    private java.lang.String extend;
    private java.lang.String from;
    private java.lang.String msgId;
    private int msgType;
    private java.lang.String pushId;
    private int readFlag;
    private long readTime;
    private java.lang.Long rowId;
    private boolean selected;
    private long sendTime;
    private java.lang.String subject;
    private int toUid;
    private int type;

    public Messages() {
        this.selected = false;
    }

    public Messages(java.lang.Long l, java.lang.String str, java.lang.String str2, long j, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i, int i2, int i3, int i4, long j2, java.lang.String str6, boolean z) {
        this.rowId = l;
        this.pushId = str;
        this.msgId = str2;
        this.sendTime = j;
        this.content = str3;
        this.subject = str4;
        this.from = str5;
        this.msgType = i;
        this.toUid = i2;
        this.readFlag = i3;
        this.type = i4;
        this.readTime = j2;
        this.extend = str6;
        this.selected = z;
    }

    public void setPushId(java.lang.String str) {
        this.pushId = str;
    }

    public java.lang.String getPushId() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.pushId)) {
            this.pushId = this.msgId;
        }
        return this.pushId;
    }

    public int getToUid() {
        return this.toUid;
    }

    public void setToUid(int i) {
        this.toUid = i;
    }

    public long getReadTime() {
        return this.readTime;
    }

    public void setReadTime(long j) {
        this.readTime = j;
    }

    public boolean hasRead() {
        return getReadFlag() == 1;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }

    public void setMsgId(java.lang.String str) {
        this.msgId = str;
    }

    public java.lang.String getMsgId() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.msgId)) {
            this.msgId = this.pushId;
        }
        return this.msgId;
    }

    public void setSendTime(long j) {
        this.sendTime = j;
    }

    public long getSendTime() {
        return this.sendTime;
    }

    public java.lang.String getFormatSendTime() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - (java.lang.System.currentTimeMillis() % 86400000);
        long j = jCurrentTimeMillis - 28800000;
        long j2 = this.sendTime;
        if (j2 >= j) {
            return com.up366.common.TimeUtils.formatTime(j2, "HH:mm");
        }
        if (j2 >= jCurrentTimeMillis - 115200000) {
            return "昨天" + com.up366.common.TimeUtils.formatTime(this.sendTime, "HH:mm");
        }
        return com.up366.common.TimeUtils.formatTime(j2, "MM-dd HH:mm");
    }

    public void setContent(java.lang.String str) {
        this.content = str;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public void setSubject(java.lang.String str) {
        this.subject = str;
    }

    public java.lang.String getSubject() {
        return this.subject;
    }

    public void setFrom(java.lang.String str) {
        this.from = str;
    }

    public java.lang.String getFrom() {
        return this.from;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public void setReadFlag(int i) {
        this.readFlag = i;
    }

    public int getReadFlag() {
        return this.readFlag;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public java.lang.String getExtend() {
        return this.extend;
    }

    public void setExtend(java.lang.String str) {
        this.extend = str;
    }

    public com.up366.mobile.common.logic.model.Messages.Extend getExt() {
        com.up366.mobile.common.logic.model.Messages.Extend extend = this.ext;
        if (extend != null) {
            return extend;
        }
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.extend)) {
            try {
                this.ext = (com.up366.mobile.common.logic.model.Messages.Extend) com.alibaba.fastjson.JSON.parseObject(this.extend, com.up366.mobile.common.logic.model.Messages.Extend.class);
            } catch (java.lang.Exception unused) {
            }
        }
        if (this.ext == null) {
            this.ext = new com.up366.mobile.common.logic.model.Messages.Extend();
        }
        return this.ext;
    }

    public static class Extend implements java.io.Serializable {
        private static final long serialVersionUID = 5029943451831513706L;
        java.lang.String bookId;
        int commentType;
        int courseId;
        int noticeId;
        java.lang.String realname;
        int showType;
        java.lang.String studyTaskId;
        java.lang.String studyTaskName;
        java.lang.String type;
        java.lang.String username;
        int bookType = 1;
        int optype = -99;

        public java.lang.String getStudyTaskName() {
            return this.studyTaskName;
        }

        public void setStudyTaskName(java.lang.String str) {
            this.studyTaskName = str;
        }

        public java.lang.String getStudyTaskId() {
            return this.studyTaskId;
        }

        public void setStudyTaskId(java.lang.String str) {
            this.studyTaskId = str;
        }

        public boolean isNeedShow() {
            return this.showType == 1 || isPersonComment();
        }

        public boolean isComment() {
            return "comment".equals(this.type);
        }

        public boolean isUpdateAccountNotice() {
            return "account".equals(this.type);
        }

        public boolean isPersonComment() {
            return this.commentType == 0 && isComment() && com.up366.common.StringUtils.isEmptyOrNull(this.studyTaskId);
        }

        public boolean isPersonHomeworkComment() {
            return this.commentType == 0 && isComment() && !com.up366.common.StringUtils.isEmptyOrNull(this.studyTaskId);
        }

        public boolean isClassHomeworkComment() {
            return this.commentType == 1 && isComment() && !com.up366.common.StringUtils.isEmptyOrNull(this.studyTaskId);
        }

        public boolean isClassComment() {
            return this.commentType == 1 && isComment() && com.up366.common.StringUtils.isEmptyOrNull(this.studyTaskId);
        }

        public boolean isExtendOpTypeMessage() {
            return this.optype != -99;
        }

        public int getShowType() {
            return this.showType;
        }

        public void setShowType(int i) {
            this.showType = i;
        }

        public int getCourseId() {
            return this.courseId;
        }

        public void setCourseId(int i) {
            this.courseId = i;
        }

        public int getNoticeId() {
            return this.noticeId;
        }

        public void setNoticeId(int i) {
            this.noticeId = i;
        }

        public java.lang.String getType() {
            return this.type;
        }

        public void setType(java.lang.String str) {
            this.type = str;
        }

        public int getCommentType() {
            return this.commentType;
        }

        public void setCommentType(int i) {
            this.commentType = i;
        }

        public java.lang.String getUsername() {
            return this.username;
        }

        public void setUsername(java.lang.String str) {
            this.username = str;
        }

        public java.lang.String getRealname() {
            return this.realname;
        }

        public void setRealname(java.lang.String str) {
            this.realname = str;
        }

        public java.lang.String getBookId() {
            return this.bookId;
        }

        public void setBookId(java.lang.String str) {
            this.bookId = str;
        }

        public int getBookType() {
            return this.bookType;
        }

        public void setBookType(int i) {
            this.bookType = i;
        }

        public int getOptype() {
            return this.optype;
        }

        public void setOptype(int i) {
            this.optype = i;
        }
    }

    public java.lang.String getMessageListPrefix() {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.extend)) {
            return "";
        }
        if (getExt().isPersonComment()) {
            return "#个人点评#";
        }
        if (getExt().isPersonHomeworkComment()) {
            return "#个人练习点评#";
        }
        if (getExt().isClassComment()) {
            return "#班级点评#";
        }
        return getExt().isClassHomeworkComment() ? "#班级练习点评#" : "";
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.common.logic.model.Messages messages = (com.up366.mobile.common.logic.model.Messages) obj;
        if (this.toUid != messages.toUid) {
            return false;
        }
        java.lang.String str = this.pushId;
        if (str == null ? messages.pushId == null : str.equals(messages.pushId)) {
            if (this.msgId.equals(messages.msgId)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        java.lang.String str = this.pushId;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.msgId.hashCode()) * 31) + this.toUid;
    }

    public java.lang.String toString() {
        return "Messages{ msgId='" + this.msgId + "', pushId='" + this.pushId + "', sendTime=" + this.sendTime + ", content='" + this.content + "', subject='" + this.subject + "', from='" + this.from + "', msgType=" + this.msgType + ", toUid=" + this.toUid + ", readFlag=" + this.readFlag + ", type=" + this.type + ", readTime=" + this.readTime + ", extend='" + this.extend + "', selected=" + this.selected + '}';
    }

    public java.lang.Long getRowId() {
        return this.rowId;
    }

    public void setRowId(java.lang.Long l) {
        this.rowId = l;
    }

    public boolean getSelected() {
        return this.selected;
    }
}
