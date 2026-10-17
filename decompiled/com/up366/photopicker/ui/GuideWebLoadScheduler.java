package com.up366.photopicker.ui;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class GuideWebLoadScheduler {
    private static final java.lang.String PREPARE_BLANK_URL = "about:blank";

    public interface LogDelegate {
        void debug(java.lang.String str);

        void error(java.lang.String str, java.lang.Throwable th);
    }

    public interface ProceedChecker {
        boolean canProceed();
    }

    private GuideWebLoadScheduler() {
    }

    public static void prepareAndLoad(final android.webkit.WebView webView, final java.lang.String str, long j, boolean z, final java.lang.String str2, java.lang.Runnable runnable, final java.lang.Runnable runnable2, final com.up366.photopicker.ui.GuideWebLoadScheduler.ProceedChecker proceedChecker, final com.up366.photopicker.ui.GuideWebLoadScheduler.LogDelegate logDelegate) {
        if (runnable != null) {
            runnable.run();
        }
        try {
            webView.stopLoading();
            if (z) {
                webView.clearCache(true);
            }
            webView.clearHistory();
        } catch (java.lang.Exception e) {
            if (logDelegate != null) {
                logDelegate.error(str2 + " 清理缓存/历史失败", e);
            }
        }
        if (logDelegate != null) {
            logDelegate.debug(str2 + " -> load about:blank");
        }
        try {
            webView.loadUrl(PREPARE_BLANK_URL);
        } catch (java.lang.Exception e2) {
            if (logDelegate != null) {
                logDelegate.error(str2 + " 预清屏 about:blank 失败", e2);
            }
        }
        webView.postDelayed(new java.lang.Runnable() { // from class: com.up366.photopicker.ui.GuideWebLoadScheduler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                com.up366.photopicker.ui.GuideWebLoadScheduler.lambda$prepareAndLoad$0(proceedChecker, logDelegate, str2, str, runnable2, webView);
            }
        }, j);
    }

    static /* synthetic */ void lambda$prepareAndLoad$0(com.up366.photopicker.ui.GuideWebLoadScheduler.ProceedChecker proceedChecker, com.up366.photopicker.ui.GuideWebLoadScheduler.LogDelegate logDelegate, java.lang.String str, java.lang.String str2, java.lang.Runnable runnable, android.webkit.WebView webView) {
        if (proceedChecker == null || proceedChecker.canProceed()) {
            if (logDelegate != null) {
                logDelegate.debug(str + " 延迟结束，开始真正加载 url=" + str2);
            }
            if (runnable != null) {
                runnable.run();
            }
            try {
                webView.loadUrl(str2);
            } catch (java.lang.Exception e) {
                if (logDelegate != null) {
                    logDelegate.error(str + " 真正加载失败 url=" + str2, e);
                }
            }
        }
    }
}
