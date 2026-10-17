package com.up366.medialibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MediaMoreConfig {
    private com.up366.medialibrary.listener.MoreActionListener actionListener;
    private boolean showMoreBtn;

    protected MediaMoreConfig() {
    }

    public boolean isShowMoreBtn() {
        return this.showMoreBtn;
    }

    public void setShowMoreBtn(boolean z) {
        this.showMoreBtn = z;
    }

    public com.up366.medialibrary.listener.MoreActionListener getActionListener() {
        return this.actionListener;
    }

    public void setActionListener(com.up366.medialibrary.listener.MoreActionListener moreActionListener) {
        this.actionListener = moreActionListener;
    }
}
