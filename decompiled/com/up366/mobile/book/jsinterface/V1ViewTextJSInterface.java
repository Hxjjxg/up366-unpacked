package com.up366.mobile.book.jsinterface;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V1ViewTextJSInterface {
    private com.up366.mobile.book.helper.V1AudioHelper audioMgr;
    private com.up366.mobile.book.jsinterface.V1ViewTextJSInterface.TextViewAudioCtrl ctrl;

    public interface TextViewAudioCtrl {
        void pausePlay();

        void resumePlay();
    }

    public V1ViewTextJSInterface(com.up366.mobile.book.jsinterface.V1ViewTextJSInterface.TextViewAudioCtrl textViewAudioCtrl, com.up366.mobile.book.helper.V1AudioHelper v1AudioHelper) {
        this.ctrl = textViewAudioCtrl;
        this.audioMgr = v1AudioHelper;
    }

    @android.webkit.JavascriptInterface
    public void pause() {
        this.ctrl.pausePlay();
    }

    @android.webkit.JavascriptInterface
    public void start() {
        this.ctrl.resumePlay();
    }

    @android.webkit.JavascriptInterface
    public void stopPlay() {
        this.ctrl.pausePlay();
        this.audioMgr.stopPlay();
    }

    @android.webkit.JavascriptInterface
    public void toPlay(int i) {
        this.audioMgr.toPlay(i);
        this.ctrl.resumePlay();
    }

    @android.webkit.JavascriptInterface
    public int getCurrentTime() {
        return this.audioMgr.getCurrentTime();
    }

    @android.webkit.JavascriptInterface
    public boolean isFristStartQuesDetail() {
        if (!com.up366.mobile.common.utils.PreferenceUtils.getBoolean("firstStartQuesDetail", true)) {
            return false;
        }
        com.up366.mobile.common.utils.PreferenceUtils.putBoolean("firstStartQuesDetail", false);
        return true;
    }
}
