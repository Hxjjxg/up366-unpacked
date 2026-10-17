package com.up366.mobile.course.wrongnote.modle;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WrongNoteBookInfo {
    private java.lang.String bookId;
    private java.lang.String bookName;
    private boolean isSelect;

    public WrongNoteBookInfo() {
    }

    public WrongNoteBookInfo(java.lang.String str, java.lang.String str2, boolean z) {
        this.bookId = str;
        this.bookName = str2;
        this.isSelect = z;
    }

    public WrongNoteBookInfo(java.lang.String str, java.lang.String str2) {
        this.bookId = str;
        this.bookName = str2;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public java.lang.String getBookId() {
        return this.bookId;
    }

    public void setBookId(java.lang.String str) {
        this.bookId = str;
    }

    public java.lang.String getBookName() {
        return this.bookName;
    }

    public void setBookName(java.lang.String str) {
        this.bookName = str;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo wrongNoteBookInfo = (com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo) obj;
        if (this.isSelect != wrongNoteBookInfo.isSelect) {
            return false;
        }
        java.lang.String str = this.bookId;
        if (str == null ? wrongNoteBookInfo.bookId != null : !str.equals(wrongNoteBookInfo.bookId)) {
            return false;
        }
        java.lang.String str2 = this.bookName;
        java.lang.String str3 = wrongNoteBookInfo.bookName;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        java.lang.String str = this.bookId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        java.lang.String str2 = this.bookName;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.isSelect ? 1 : 0);
    }
}
