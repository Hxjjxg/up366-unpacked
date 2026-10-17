package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SkipKilledEvent {
    private final int classify;
    private final int wordCount;

    public SkipKilledEvent(int i, int i2) {
        this.classify = i;
        this.wordCount = i2;
    }

    public int getClassify() {
        return this.classify;
    }

    public int getWordCount() {
        return this.wordCount;
    }
}
