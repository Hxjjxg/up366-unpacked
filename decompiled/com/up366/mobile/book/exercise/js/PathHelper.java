package com.up366.mobile.book.exercise.js;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PathHelper {
    private final com.up366.mobile.book.exercise.ExerciseDataHelper dataHelper;

    public PathHelper(com.up366.mobile.book.exercise.ExerciseDataHelper exerciseDataHelper) {
        this.dataHelper = exerciseDataHelper;
    }

    public java.lang.String getCurrentPath() {
        return this.dataHelper.d.getLocalResourceDir();
    }

    public java.lang.String getVoiceRecordPath(java.lang.String str) {
        return com.up366.common.FileUtilsUp.join(this.dataHelper.d.getAnswerDir(), str + com.up366.medialibrary.common.utils.MimeTypeUtils.WAV);
    }
}
