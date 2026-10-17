package com.up366.multimedia.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class VideoRecordUtil {
    public static void startRecorder(android.content.Context context, int maxDuration) {
        java.io.File file = new java.io.File(com.up366.common.global.GB.getCallBack().getImgCacheDir());
        if (!file.exists() && !file.mkdirs()) {
            throw new java.lang.RuntimeException("Unable to create save directory, make sure WRITE_EXTERNAL_STORAGE permission is granted.");
        }
        new com.afollestad.materialcamera.MaterialCamera((android.app.Activity) context).forceCamera1().allowRetry(true).autoSubmit(false).saveDir(file).primaryColorAttr(com.afollestad.materialcamera.R.attr.colorPrimary).showPortraitWarning(false).defaultToFrontFacing(false).retryExits(false).restartTimerOnRetry(false).continueTimerInPlayback(false).countdownSeconds(maxDuration).videoEncodingBitRate(1024000).audioEncodingBitRate(50000).qualityProfile(1).videoPreferredHeight(1080).videoPreferredAspect(1.3333334f).maxAllowedFileSize(31457280L).iconRecord(com.afollestad.materialcamera.R.drawable.mcam_action_capture).iconStop(com.afollestad.materialcamera.R.drawable.mcam_action_stop).iconFrontCamera(com.afollestad.materialcamera.R.drawable.mcam_camera_front).iconRearCamera(com.afollestad.materialcamera.R.drawable.mcam_camera_rear).iconPlay(com.afollestad.materialcamera.R.drawable.play_btn_start).iconPause(com.afollestad.materialcamera.R.drawable.play_btn_pause).iconRestart(com.afollestad.materialcamera.R.drawable.play_btn_start).labelRetry(com.afollestad.materialcamera.R.string.mcam_retry).labelConfirm(com.afollestad.materialcamera.R.string.mcam_use_video).audioDisabled(false).start(com.up366.multimedia.util.SkipUtil.CAMERA_RQ);
    }
}
