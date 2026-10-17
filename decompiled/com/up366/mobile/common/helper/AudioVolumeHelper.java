package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AudioVolumeHelper {
    public static void checkVolume() {
        android.media.AudioManager audioManager = (android.media.AudioManager) com.up366.common.global.GB.get().getApplicationContext().getSystemService(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_AUDIO);
        if (audioManager != null && audioManager.getStreamVolume(3) == 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("当前设备处于静音状态");
            com.up366.common.log.Logger.info("TAG - AudioVolumeHelper - checkVolume - 当前设备处于静音状态");
        }
    }
}
