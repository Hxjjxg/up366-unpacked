package com.up366.mobile.course.photoanswer.common;

/* JADX INFO: compiled from: PhotoCorrectMediaUtils.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/up366/mobile/course/photoanswer/common/PhotoCorrectMediaUtils;", "", "<init>", "()V", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoCorrectMediaUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.course.photoanswer.common.PhotoCorrectMediaUtils.Companion INSTANCE = new com.up366.mobile.course.photoanswer.common.PhotoCorrectMediaUtils.Companion(null);

    /* JADX INFO: compiled from: PhotoCorrectMediaUtils.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"Lcom/up366/mobile/course/photoanswer/common/PhotoCorrectMediaUtils$Companion;", "", "<init>", "()V", "takePictureVoice", "", "playNextPageVoice", "playVoice", "rawId", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void takePictureVoice() {
            playVoice(com.up366.mobile.R.raw.camera_take_picture);
        }

        public final void playNextPageVoice() {
            playVoice(com.up366.mobile.R.raw.p1p_change_next);
        }

        private final void playVoice(int rawId) {
            final android.media.MediaPlayer mediaPlayerCreate = android.media.MediaPlayer.create(com.up366.common.global.GB.get().getApplicationContext(), rawId);
            mediaPlayerCreate.start();
            mediaPlayerCreate.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() { // from class: com.up366.mobile.course.photoanswer.common.PhotoCorrectMediaUtils$Companion$$ExternalSyntheticLambda0
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(android.media.MediaPlayer mediaPlayer) {
                    mediaPlayerCreate.release();
                }
            });
        }
    }
}
