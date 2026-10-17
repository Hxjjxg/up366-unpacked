package com.up366.medialibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MediaMoreConfigBuilder {
    private boolean showMoreBtn = false;
    private com.up366.medialibrary.listener.MoreActionListener actionListener = new com.up366.medialibrary.listener.MoreActionListener() { // from class: com.up366.medialibrary.MediaMoreConfigBuilder$$ExternalSyntheticLambda0
        @Override // com.up366.medialibrary.listener.MoreActionListener
        public final void onClick(android.view.View view, com.up366.medialibrary.model.AttachmentInfo attachmentInfo) {
            com.up366.medialibrary.MediaMoreConfigBuilder.lambda$new$0(view, attachmentInfo);
        }
    };

    static /* synthetic */ void lambda$new$0(android.view.View view, com.up366.medialibrary.model.AttachmentInfo attachmentInfo) {
    }

    public com.up366.medialibrary.MediaMoreConfigBuilder setShowMoreBtn(boolean z) {
        this.showMoreBtn = z;
        return this;
    }

    public com.up366.medialibrary.MediaMoreConfigBuilder setActionListener(com.up366.medialibrary.listener.MoreActionListener moreActionListener) {
        this.actionListener = moreActionListener;
        return this;
    }

    public com.up366.medialibrary.MediaMoreConfig build() {
        com.up366.medialibrary.MediaMoreConfig mediaMoreConfig = new com.up366.medialibrary.MediaMoreConfig();
        mediaMoreConfig.setActionListener(this.actionListener);
        mediaMoreConfig.setShowMoreBtn(this.showMoreBtn);
        return mediaMoreConfig;
    }
}
