package com.up366.photopicker.ui;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class GuideWebReloadHelper {

    public interface Hooks {
        void onBeforeLoad();

        void onBeforeRealLoad();

        void onEmptyUrl();
    }

    private GuideWebReloadHelper() {
    }

    public static void reload(android.webkit.WebView webView, java.lang.String str, final com.up366.photopicker.ui.GuideWebFlowCoordinator guideWebFlowCoordinator, long j, boolean z, java.lang.String str2, final com.up366.photopicker.ui.GuideWebReloadHelper.Hooks hooks, com.up366.photopicker.ui.GuideWebLoadScheduler.ProceedChecker proceedChecker, com.up366.photopicker.ui.GuideWebLoadScheduler.LogDelegate logDelegate) {
        guideWebFlowCoordinator.resetForLoad(str);
        if (hooks != null) {
            hooks.onBeforeLoad();
        }
        if (str != null && !str.isEmpty()) {
            guideWebFlowCoordinator.markPrepareBlank();
            com.up366.photopicker.ui.GuideWebLoadScheduler.prepareAndLoad(webView, str, j, z, str2, null, new java.lang.Runnable() { // from class: com.up366.photopicker.ui.GuideWebReloadHelper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    com.up366.photopicker.ui.GuideWebReloadHelper.lambda$reload$0(hooks, guideWebFlowCoordinator);
                }
            }, proceedChecker, logDelegate);
        } else if (hooks != null) {
            hooks.onEmptyUrl();
        }
    }

    static /* synthetic */ void lambda$reload$0(com.up366.photopicker.ui.GuideWebReloadHelper.Hooks hooks, com.up366.photopicker.ui.GuideWebFlowCoordinator guideWebFlowCoordinator) {
        if (hooks != null) {
            hooks.onBeforeRealLoad();
        }
        guideWebFlowCoordinator.clearPrepareBlank();
    }
}
