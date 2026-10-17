package com.up366.photopicker.ui;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class GuideWebFlowCoordinator {
    private static final java.lang.String PREPARE_BLANK_URL = "about:blank";
    private java.lang.String currentUrl = "";
    private boolean hasMainFrameError = false;
    private com.up366.photopicker.ui.GuideWebFlowCoordinator.BlankLoadReason blankLoadReason = com.up366.photopicker.ui.GuideWebFlowCoordinator.BlankLoadReason.NONE;
    private boolean hasCommittedVisible = false;
    private java.lang.String lastPageStartedUrl = "";
    private java.lang.String lastPageFinishedUrl = "";

    public enum BlankLoadReason {
        NONE,
        PREPARE
    }

    public enum PageDecision {
        WAIT,
        REVEAL,
        SHOW_ERROR
    }

    public void resetForLoad(java.lang.String str) {
        this.currentUrl = safeUrl(str);
        this.hasMainFrameError = false;
        this.blankLoadReason = com.up366.photopicker.ui.GuideWebFlowCoordinator.BlankLoadReason.NONE;
        this.hasCommittedVisible = false;
        this.lastPageStartedUrl = "";
        this.lastPageFinishedUrl = "";
    }

    public void markPrepareBlank() {
        this.blankLoadReason = com.up366.photopicker.ui.GuideWebFlowCoordinator.BlankLoadReason.PREPARE;
    }

    public void clearPrepareBlank() {
        this.blankLoadReason = com.up366.photopicker.ui.GuideWebFlowCoordinator.BlankLoadReason.NONE;
    }

    public boolean onPageStarted(java.lang.String str) {
        this.lastPageStartedUrl = safeUrl(str);
        if (isPreparingBlankUrl(str)) {
            return false;
        }
        this.hasCommittedVisible = false;
        return true;
    }

    public com.up366.photopicker.ui.GuideWebFlowCoordinator.PageDecision onPageFinished(java.lang.String str, java.lang.String str2, int i, int i2) {
        this.lastPageFinishedUrl = safeUrl(str);
        if (this.hasMainFrameError) {
            return com.up366.photopicker.ui.GuideWebFlowCoordinator.PageDecision.SHOW_ERROR;
        }
        if (PREPARE_BLANK_URL.equals(str) && this.blankLoadReason == com.up366.photopicker.ui.GuideWebFlowCoordinator.BlankLoadReason.PREPARE) {
            this.blankLoadReason = com.up366.photopicker.ui.GuideWebFlowCoordinator.BlankLoadReason.NONE;
            return com.up366.photopicker.ui.GuideWebFlowCoordinator.PageDecision.WAIT;
        }
        this.blankLoadReason = com.up366.photopicker.ui.GuideWebFlowCoordinator.BlankLoadReason.NONE;
        return canReveal(str2, i, i2) ? com.up366.photopicker.ui.GuideWebFlowCoordinator.PageDecision.REVEAL : com.up366.photopicker.ui.GuideWebFlowCoordinator.PageDecision.WAIT;
    }

    public boolean onPageCommitVisible(java.lang.String str, java.lang.String str2, int i, int i2) {
        this.hasCommittedVisible = true;
        return (this.hasMainFrameError || PREPARE_BLANK_URL.equals(str) || !canReveal(str2, i, i2)) ? false : true;
    }

    public void onMainFrameFailure() {
        this.hasMainFrameError = true;
        this.blankLoadReason = com.up366.photopicker.ui.GuideWebFlowCoordinator.BlankLoadReason.NONE;
    }

    public boolean canReveal(java.lang.String str, int i, int i2) {
        return com.up366.photopicker.ui.GuideWebLoadDecider.canRevealContent(this.currentUrl, str, this.hasMainFrameError, isPreparingBlankUrl(str), this.hasCommittedVisible, i, i2);
    }

    public boolean isPreparingBlankUrl(java.lang.String str) {
        return PREPARE_BLANK_URL.equals(str) && this.blankLoadReason != com.up366.photopicker.ui.GuideWebFlowCoordinator.BlankLoadReason.NONE;
    }

    public java.lang.String getCurrentUrl() {
        return this.currentUrl;
    }

    public boolean hasMainFrameError() {
        return this.hasMainFrameError;
    }

    public com.up366.photopicker.ui.GuideWebFlowCoordinator.BlankLoadReason getBlankLoadReason() {
        return this.blankLoadReason;
    }

    public boolean hasCommittedVisible() {
        return this.hasCommittedVisible;
    }

    public java.lang.String getLastPageStartedUrl() {
        return this.lastPageStartedUrl;
    }

    public java.lang.String getLastPageFinishedUrl() {
        return this.lastPageFinishedUrl;
    }

    private java.lang.String safeUrl(java.lang.String str) {
        return str == null ? "" : str;
    }
}
