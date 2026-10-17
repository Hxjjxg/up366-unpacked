package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class VoiceUtils {
    private static com.up366.medialibrary.common.utils.VoiceUtils instance;
    private int soundID;
    private android.media.SoundPool soundPool;

    public static com.up366.medialibrary.common.utils.VoiceUtils getInstance() {
        if (instance == null) {
            synchronized (com.up366.medialibrary.common.utils.VoiceUtils.class) {
                if (instance == null) {
                    instance = new com.up366.medialibrary.common.utils.VoiceUtils();
                }
            }
        }
        return instance;
    }

    public void init(android.content.Context context) {
        initPool(context);
    }

    private void initPool(android.content.Context context) {
        if (this.soundPool == null) {
            android.media.SoundPool soundPool = new android.media.SoundPool(1, 3, 0);
            this.soundPool = soundPool;
            this.soundID = soundPool.load(context.getApplicationContext(), com.up366.medialibrary.R.raw.picture_music, 1);
        }
    }

    public void play() {
        android.media.SoundPool soundPool = this.soundPool;
        if (soundPool != null) {
            soundPool.play(this.soundID, 0.1f, 0.5f, 0, 1, 1.0f);
        }
    }

    public void releaseSoundPool() {
        try {
            android.media.SoundPool soundPool = this.soundPool;
            if (soundPool != null) {
                soundPool.release();
                this.soundPool = null;
            }
            instance = null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
