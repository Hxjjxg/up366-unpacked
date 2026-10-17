package com.up366.multimedia.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AttachmentAudioPositionEvent {
    public final java.lang.String audioId;
    public final int curPos;
    public final int duration;

    public AttachmentAudioPositionEvent(java.lang.String audioId, int curPos, int duration) {
        this.audioId = audioId;
        this.curPos = curPos;
        this.duration = duration;
    }
}
