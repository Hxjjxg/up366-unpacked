package com.up366.mobile.course.wrongnote.modle;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class NoteCountInfo {
    private int wnCount;
    private int wordCount;

    public int getWnCount() {
        return this.wnCount;
    }

    public void setWnCount(int i) {
        this.wnCount = i;
    }

    public int getWordCount() {
        return this.wordCount;
    }

    public void setWordCount(int i) {
        this.wordCount = i;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.course.wrongnote.modle.NoteCountInfo noteCountInfo = (com.up366.mobile.course.wrongnote.modle.NoteCountInfo) obj;
        return this.wnCount == noteCountInfo.wnCount && this.wordCount == noteCountInfo.wordCount;
    }

    public int hashCode() {
        return (this.wnCount * 31) + this.wordCount;
    }
}
