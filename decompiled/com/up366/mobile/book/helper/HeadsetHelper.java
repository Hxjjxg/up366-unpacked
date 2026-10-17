package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class HeadsetHelper {
    public static final int HEADSET_PLUGGED = 1;
    public static final int HEADSET_UN_PLUGGED = 0;
    private android.media.AudioDeviceCallback audioDeviceCallback;
    private final android.media.AudioManager audioManager;
    private final android.content.Context context;
    private int lastHeadsetState = -1;
    private com.up366.mobile.book.helper.HeadsetHelper.IOnStateChangeListener listener = null;
    private com.up366.mobile.book.helper.HeadsetHelper.HeadsetPlugReceiver receiver;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @interface HeadsetState {
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface IOnReceiverChangeListener {
        void onChange();
    }

    public interface IOnStateChangeListener {
        void onChange(int i);
    }

    public HeadsetHelper(android.content.Context context) {
        this.context = context;
        android.media.AudioManager audioManager = (android.media.AudioManager) context.getSystemService(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_AUDIO);
        this.audioManager = audioManager;
        try {
            audioManager.setMode(0);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - HeadsetHelper - HeadsetHelper - " + e.getMessage(), e);
        }
        setListener(new com.up366.mobile.book.helper.HeadsetHelper.IOnStateChangeListener() { // from class: com.up366.mobile.book.helper.HeadsetHelper$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.HeadsetHelper.IOnStateChangeListener
            public final void onChange(int i) {
                com.up366.mobile.book.helper.HeadsetHelper.lambda$new$0(i);
            }
        });
    }

    static /* synthetic */ void lambda$new$0(int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("TAG - headsetHelper.listener state:");
        sb.append(i);
        sb.append(" isPlugged:");
        sb.append(i == 1);
        com.up366.common.log.Logger.info(sb.toString());
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("type", "_EVT_HEADSET_STATUS_CHANGE_");
        com.alibaba.fastjson.JSONObject jSONObject2 = new com.alibaba.fastjson.JSONObject();
        jSONObject2.put("status", java.lang.Integer.valueOf(i == 1 ? 1 : 0));
        jSONObject.put("detail", jSONObject2);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.JSGlobalEvent(jSONObject.toJSONString()));
    }

    public void register() {
        android.media.AudioDeviceCallback audioDeviceCallback = new android.media.AudioDeviceCallback() { // from class: com.up366.mobile.book.helper.HeadsetHelper.1
            @Override // android.media.AudioDeviceCallback
            public void onAudioDevicesAdded(android.media.AudioDeviceInfo[] audioDeviceInfoArr) {
                com.up366.mobile.book.helper.HeadsetHelper headsetHelper = com.up366.mobile.book.helper.HeadsetHelper.this;
                headsetHelper.notifyAudioDeviceChanged(headsetHelper.audioManager, com.up366.mobile.book.helper.HeadsetHelper.this.listener);
            }

            @Override // android.media.AudioDeviceCallback
            public void onAudioDevicesRemoved(android.media.AudioDeviceInfo[] audioDeviceInfoArr) {
                com.up366.mobile.book.helper.HeadsetHelper headsetHelper = com.up366.mobile.book.helper.HeadsetHelper.this;
                headsetHelper.notifyAudioDeviceChanged(headsetHelper.audioManager, com.up366.mobile.book.helper.HeadsetHelper.this.listener);
            }
        };
        this.audioDeviceCallback = audioDeviceCallback;
        this.audioManager.registerAudioDeviceCallback(audioDeviceCallback, new android.os.Handler(android.os.Looper.getMainLooper()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$register$1() {
        notifyAudioDeviceChanged(this.audioManager, this.listener);
    }

    public void unRegister() {
        com.up366.mobile.book.helper.HeadsetHelper.HeadsetPlugReceiver headsetPlugReceiver = this.receiver;
        if (headsetPlugReceiver != null) {
            this.context.unregisterReceiver(headsetPlugReceiver);
        }
        android.media.AudioDeviceCallback audioDeviceCallback = this.audioDeviceCallback;
        if (audioDeviceCallback != null) {
            this.audioManager.unregisterAudioDeviceCallback(audioDeviceCallback);
        }
    }

    public void setListener(com.up366.mobile.book.helper.HeadsetHelper.IOnStateChangeListener iOnStateChangeListener) {
        this.listener = iOnStateChangeListener;
    }

    public int getHeadsetState() {
        return getHeadsetState(this.audioManager);
    }

    static class HeadsetPlugReceiver extends android.content.BroadcastReceiver {
        private final com.up366.mobile.book.helper.HeadsetHelper.IOnReceiverChangeListener listener;

        public HeadsetPlugReceiver(com.up366.mobile.book.helper.HeadsetHelper.IOnReceiverChangeListener iOnReceiverChangeListener) {
            this.listener = iOnReceiverChangeListener;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            this.listener.onChange();
        }
    }

    private int getHeadsetState(android.media.AudioManager audioManager) {
        for (android.media.AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
            int type = audioDeviceInfo.getType();
            if (type == 3 || type == 4 || type == 7 || type == 8 || type == 22 || type == 23) {
                return 1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAudioDeviceChanged(final android.media.AudioManager audioManager, final com.up366.mobile.book.helper.HeadsetHelper.IOnStateChangeListener iOnStateChangeListener) {
        com.up366.common.task.TaskUtils.postLazyTaskMain("audio-device-changed", 100, new com.up366.common.task.Task() { // from class: com.up366.mobile.book.helper.HeadsetHelper$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$notifyAudioDeviceChanged$2(audioManager, iOnStateChangeListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyAudioDeviceChanged$2(android.media.AudioManager audioManager, com.up366.mobile.book.helper.HeadsetHelper.IOnStateChangeListener iOnStateChangeListener) throws java.lang.Exception {
        int headsetState = getHeadsetState(audioManager);
        if (headsetState != this.lastHeadsetState) {
            this.lastHeadsetState = headsetState;
            iOnStateChangeListener.onChange(headsetState);
        }
    }
}
