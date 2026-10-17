package com.up366.mobile.course.wrongnote.modle;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WordNoteFromInfo {
    public static final int FROM_TYPE_TEXTBOOK = 4;
    public static final int FROM_TYPE_VIEWTEXT = 2;
    public static final int FROM_TYPE_WORD = 1;
    public static final int FROM_TYPE_WORD_DICTIONARY = 3;
    private int addCount;
    private long addTime;
    private java.lang.String bookId;
    private int degree;
    private java.lang.String example;
    private java.lang.String fromMemo;
    private int fromType;
    private boolean isDetailShown;
    private java.lang.String netFile;
    private java.lang.String paraphrase;
    private java.lang.String phonetic;
    private java.lang.String picFile;
    private java.lang.String qstId;
    private int state = 4;
    private java.lang.String videoFile;
    private java.lang.String voiceFile;
    private java.lang.String word;
    private java.lang.String wordId;

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public java.lang.String getWordId() {
        return this.wordId;
    }

    public void setWordId(java.lang.String str) {
        this.wordId = str;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public java.lang.String getQstId() {
        return this.qstId;
    }

    public void setQstId(java.lang.String str) {
        this.qstId = str;
    }

    public int getFromType() {
        return this.fromType;
    }

    public void setFromType(int i) {
        this.fromType = i;
    }

    public long getAddTime() {
        return this.addTime;
    }

    public void setAddTime(long j) {
        this.addTime = j;
    }

    public java.lang.String getFromMemo() {
        return this.fromMemo;
    }

    public void setFromMemo(java.lang.String str) {
        this.fromMemo = str;
    }

    public java.lang.String getWord() {
        return this.word;
    }

    public void setWord(java.lang.String str) {
        this.word = str;
    }

    public java.lang.String getParaphrase() {
        return this.paraphrase;
    }

    public void setParaphrase(java.lang.String str) {
        this.paraphrase = str;
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

    public java.lang.String getNetFile() {
        return this.netFile;
    }

    public void setNetFile(java.lang.String str) {
        this.netFile = str;
    }

    public java.lang.String getVoiceFile() {
        return this.voiceFile;
    }

    public void setVoiceFile(java.lang.String str) {
        this.voiceFile = str;
    }

    public int getDegree() {
        return this.degree;
    }

    public void setDegree(int i) {
        this.degree = i;
    }

    public int getAddCount() {
        return this.addCount;
    }

    public void setAddCount(int i) {
        this.addCount = i;
    }

    public boolean isDetailShown() {
        return this.isDetailShown;
    }

    public void setDetailShown(boolean z) {
        this.isDetailShown = z;
    }
}
