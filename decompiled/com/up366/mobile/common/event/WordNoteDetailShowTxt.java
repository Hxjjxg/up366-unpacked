package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WordNoteDetailShowTxt {
    public static final int TYPE_CHINESE = 1;
    public static final int TYPE_ENGLISH = 2;
    private int curPage;
    private boolean isChecked;
    private int type;

    public WordNoteDetailShowTxt(int i, boolean z, int i2) {
        this.type = i;
        this.isChecked = z;
        this.curPage = i2;
    }

    public WordNoteDetailShowTxt(int i) {
        this.curPage = i;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getCurPage() {
        return this.curPage;
    }

    public void setCurPage(int i) {
        this.curPage = i;
    }
}
