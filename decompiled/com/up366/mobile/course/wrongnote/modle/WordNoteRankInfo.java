package com.up366.mobile.course.wrongnote.modle;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WordNoteRankInfo {
    private int killedCount;
    private int killedCountLately;
    private java.lang.String rankNamePinYin;
    private java.lang.String realname;
    private int uid;
    private int wordCount;

    public java.lang.String getRankNamePinYin() {
        return this.rankNamePinYin;
    }

    public void setRankNamePinYin(java.lang.String str) {
        this.rankNamePinYin = str;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUid(int i) {
        this.uid = i;
    }

    public java.lang.String getRealname() {
        return this.realname;
    }

    public void setRealname(java.lang.String str) {
        this.realname = str;
        com.pinyinsearch.model.PinyinSearchUnit pinyinSearchUnit = new com.pinyinsearch.model.PinyinSearchUnit(str);
        com.pinyinsearch.util.PinyinUtil.parse(pinyinSearchUnit);
        this.rankNamePinYin = com.pinyinsearch.util.PinyinUtil.getSortKey(pinyinSearchUnit).toLowerCase().replaceAll("[^0-z]*", "");
    }

    public int getKilledCount() {
        return this.killedCount;
    }

    public void setKilledCount(int i) {
        this.killedCount = i;
    }

    public int getWordCount() {
        return this.wordCount;
    }

    public void setWordCount(int i) {
        this.wordCount = i;
    }

    public int getKilledCountLately() {
        return this.killedCountLately;
    }

    public void setKilledCountLately(int i) {
        this.killedCountLately = i;
    }
}
