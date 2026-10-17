package com.up366.mobile.course.wrongnote.modle;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WordNoteInfo implements java.io.Serializable {
    public static final int WORD_KILLED = 1;
    public static final int WORD_NOT_KILLED = 0;
    private java.lang.String bookId;
    private int classify;
    private int degree;
    private java.lang.String example;
    private java.lang.String frequent;
    private java.lang.String grade;
    private java.lang.String important;
    private java.lang.String inflection;
    private java.lang.String netFile;
    private java.lang.String paraphrase;
    private java.lang.String phonetic;
    private java.lang.String phrase;
    private java.lang.String picFile;
    private java.lang.String source;
    private int sourceTimes;
    private java.lang.String stageId;
    private int updateTime;
    private java.lang.String videoFile;
    private int viewType;
    private java.lang.String voiceFile;
    private java.lang.String wbNo;
    private java.lang.String word;
    private int wordCompletes;
    private java.lang.String wordDesc;
    private java.lang.String wordId;
    private int wordTimes;
    private java.lang.String wordPinYin = "";
    private int state = 4;
    private int status = 0;

    public java.lang.String getWordId() {
        return this.wordId;
    }

    public void setWordId(java.lang.String str) {
        this.wordId = str;
    }

    public int getWordCompletes() {
        return this.wordCompletes;
    }

    public int getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(int i) {
        this.updateTime = i;
    }

    public void setWordCompletes(int i) {
        this.wordCompletes = i;
    }

    public java.lang.String getWord() {
        return this.word;
    }

    public java.lang.String getWordPinYin() {
        return this.wordPinYin;
    }

    public void setWord(java.lang.String str) {
        this.word = str;
        com.pinyinsearch.model.PinyinSearchUnit pinyinSearchUnit = new com.pinyinsearch.model.PinyinSearchUnit(str);
        com.pinyinsearch.util.PinyinUtil.parse(pinyinSearchUnit);
        this.wordPinYin = com.pinyinsearch.util.PinyinUtil.getSortKey(pinyinSearchUnit).toLowerCase().replaceAll("[^a-z ]*", "");
    }

    public java.lang.String getParaphrase() {
        return this.paraphrase;
    }

    public void setParaphrase(java.lang.String str) {
        this.paraphrase = str;
    }

    public java.lang.String getVoiceFile() {
        return this.voiceFile;
    }

    public void setVoiceFile(java.lang.String str) {
        this.voiceFile = str;
    }

    public java.lang.String getNetFile() {
        return this.netFile;
    }

    public void setNetFile(java.lang.String str) {
        this.netFile = str;
    }

    public int getDegree() {
        return this.degree;
    }

    public void setDegree(int i) {
        this.degree = i;
    }

    public int getWordTimes() {
        return this.wordTimes;
    }

    public void setWordTimes(int i) {
        this.wordTimes = i;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setViewType(int i) {
        this.viewType = i;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setState(int i) {
        this.state = i;
    }

    public int getState() {
        return this.state;
    }

    public java.lang.String getFrequent() {
        return this.frequent;
    }

    public void setFrequent(java.lang.String str) {
        this.frequent = str;
    }

    public java.lang.String getGrade() {
        return this.grade;
    }

    public void setGrade(java.lang.String str) {
        this.grade = str;
    }

    public java.lang.String getImportant() {
        return this.important;
    }

    public void setImportant(java.lang.String str) {
        this.important = str;
    }

    public java.lang.String getInflection() {
        return this.inflection;
    }

    public void setInflection(java.lang.String str) {
        this.inflection = str;
    }

    public java.lang.String getPhrase() {
        return this.phrase;
    }

    public void setPhrase(java.lang.String str) {
        this.phrase = str;
    }

    public java.lang.String getSource() {
        return this.source;
    }

    public void setSource(java.lang.String str) {
        this.source = str;
    }

    public java.lang.String getStageId() {
        return this.stageId;
    }

    public void setStageId(java.lang.String str) {
        this.stageId = str;
    }

    public java.lang.String getWbNo() {
        return this.wbNo;
    }

    public void setWbNo(java.lang.String str) {
        this.wbNo = str;
    }

    public java.lang.String getWordDesc() {
        return this.wordDesc;
    }

    public void setWordDesc(java.lang.String str) {
        this.wordDesc = str;
    }

    public java.lang.String getPhonetic() {
        return this.phonetic;
    }

    public void setPhonetic(java.lang.String str) {
        this.phonetic = str;
    }

    public java.lang.String getExample() {
        return this.example;
    }

    public void setExample(java.lang.String str) {
        this.example = str;
    }

    public java.lang.String getPicFile() {
        return this.picFile;
    }

    public void setPicFile(java.lang.String str) {
        this.picFile = str;
    }

    public java.lang.String getVideoFile() {
        return this.videoFile;
    }

    public void setVideoFile(java.lang.String str) {
        this.videoFile = str;
    }

    public void setWordPinYin(java.lang.String str) {
        this.wordPinYin = str;
    }

    public int getClassify() {
        return this.classify;
    }

    public void setClassify(int i) {
        this.classify = i;
    }

    public int getSourceTimes() {
        return this.sourceTimes;
    }

    public void setSourceTimes(int i) {
        this.sourceTimes = i;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.course.wrongnote.modle.WordNoteInfo wordNoteInfo = (com.up366.mobile.course.wrongnote.modle.WordNoteInfo) obj;
        if (this.degree != wordNoteInfo.degree || this.wordTimes != wordNoteInfo.wordTimes || this.viewType != wordNoteInfo.viewType || this.sourceTimes != wordNoteInfo.sourceTimes || this.wordCompletes != wordNoteInfo.wordCompletes || this.state != wordNoteInfo.state || this.classify != wordNoteInfo.classify) {
            return false;
        }
        java.lang.String str = this.frequent;
        if (str == null ? wordNoteInfo.frequent != null : !str.equals(wordNoteInfo.frequent)) {
            return false;
        }
        java.lang.String str2 = this.grade;
        if (str2 == null ? wordNoteInfo.grade != null : !str2.equals(wordNoteInfo.grade)) {
            return false;
        }
        java.lang.String str3 = this.important;
        if (str3 == null ? wordNoteInfo.important != null : !str3.equals(wordNoteInfo.important)) {
            return false;
        }
        java.lang.String str4 = this.inflection;
        if (str4 == null ? wordNoteInfo.inflection != null : !str4.equals(wordNoteInfo.inflection)) {
            return false;
        }
        java.lang.String str5 = this.phrase;
        if (str5 == null ? wordNoteInfo.phrase != null : !str5.equals(wordNoteInfo.phrase)) {
            return false;
        }
        java.lang.String str6 = this.source;
        if (str6 == null ? wordNoteInfo.source != null : !str6.equals(wordNoteInfo.source)) {
            return false;
        }
        java.lang.String str7 = this.stageId;
        if (str7 == null ? wordNoteInfo.stageId != null : !str7.equals(wordNoteInfo.stageId)) {
            return false;
        }
        java.lang.String str8 = this.wbNo;
        if (str8 == null ? wordNoteInfo.wbNo != null : !str8.equals(wordNoteInfo.wbNo)) {
            return false;
        }
        java.lang.String str9 = this.wordDesc;
        if (str9 == null ? wordNoteInfo.wordDesc != null : !str9.equals(wordNoteInfo.wordDesc)) {
            return false;
        }
        java.lang.String str10 = this.phonetic;
        if (str10 == null ? wordNoteInfo.phonetic != null : !str10.equals(wordNoteInfo.phonetic)) {
            return false;
        }
        java.lang.String str11 = this.example;
        if (str11 == null ? wordNoteInfo.example != null : !str11.equals(wordNoteInfo.example)) {
            return false;
        }
        java.lang.String str12 = this.picFile;
        if (str12 == null ? wordNoteInfo.picFile != null : !str12.equals(wordNoteInfo.picFile)) {
            return false;
        }
        java.lang.String str13 = this.videoFile;
        if (str13 == null ? wordNoteInfo.videoFile != null : !str13.equals(wordNoteInfo.videoFile)) {
            return false;
        }
        java.lang.String str14 = this.wordId;
        if (str14 == null ? wordNoteInfo.wordId != null : !str14.equals(wordNoteInfo.wordId)) {
            return false;
        }
        java.lang.String str15 = this.word;
        if (str15 == null ? wordNoteInfo.word != null : !str15.equals(wordNoteInfo.word)) {
            return false;
        }
        java.lang.String str16 = this.paraphrase;
        if (str16 == null ? wordNoteInfo.paraphrase != null : !str16.equals(wordNoteInfo.paraphrase)) {
            return false;
        }
        java.lang.String str17 = this.voiceFile;
        if (str17 == null ? wordNoteInfo.voiceFile != null : !str17.equals(wordNoteInfo.voiceFile)) {
            return false;
        }
        java.lang.String str18 = this.netFile;
        if (str18 == null ? wordNoteInfo.netFile != null : !str18.equals(wordNoteInfo.netFile)) {
            return false;
        }
        java.lang.String str19 = this.wordPinYin;
        if (str19 == null ? wordNoteInfo.wordPinYin != null : !str19.equals(wordNoteInfo.wordPinYin)) {
            return false;
        }
        java.lang.String str20 = this.bookId;
        java.lang.String str21 = wordNoteInfo.bookId;
        return str20 != null ? str20.equals(str21) : str21 == null;
    }

    public int hashCode() {
        java.lang.String str = this.frequent;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        java.lang.String str2 = this.grade;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.important;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        java.lang.String str4 = this.inflection;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        java.lang.String str5 = this.phrase;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        java.lang.String str6 = this.source;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        java.lang.String str7 = this.stageId;
        int iHashCode7 = (iHashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        java.lang.String str8 = this.wbNo;
        int iHashCode8 = (iHashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        java.lang.String str9 = this.wordDesc;
        int iHashCode9 = (iHashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        java.lang.String str10 = this.phonetic;
        int iHashCode10 = (iHashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        java.lang.String str11 = this.example;
        int iHashCode11 = (iHashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        java.lang.String str12 = this.picFile;
        int iHashCode12 = (iHashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        java.lang.String str13 = this.videoFile;
        int iHashCode13 = (iHashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        java.lang.String str14 = this.wordId;
        int iHashCode14 = (iHashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        java.lang.String str15 = this.word;
        int iHashCode15 = (iHashCode14 + (str15 != null ? str15.hashCode() : 0)) * 31;
        java.lang.String str16 = this.paraphrase;
        int iHashCode16 = (iHashCode15 + (str16 != null ? str16.hashCode() : 0)) * 31;
        java.lang.String str17 = this.voiceFile;
        int iHashCode17 = (iHashCode16 + (str17 != null ? str17.hashCode() : 0)) * 31;
        java.lang.String str18 = this.netFile;
        int iHashCode18 = (((((((((((iHashCode17 + (str18 != null ? str18.hashCode() : 0)) * 31) + this.degree) * 31) + this.wordTimes) * 31) + this.viewType) * 31) + this.sourceTimes) * 31) + this.wordCompletes) * 31;
        java.lang.String str19 = this.wordPinYin;
        int iHashCode19 = (iHashCode18 + (str19 != null ? str19.hashCode() : 0)) * 31;
        java.lang.String str20 = this.bookId;
        return ((((iHashCode19 + (str20 != null ? str20.hashCode() : 0)) * 31) + this.state) * 31) + this.classify;
    }
}
