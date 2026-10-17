package com.up366.qmui.nestedScroll;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIContinuousNestedTopWebView extends com.up366.qmui.widget.webview.QMUIWebView implements com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView {
    public static final java.lang.String KEY_SCROLL_INFO = "@qmui_scroll_info_top_webview";
    private com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier mScrollNotifier;

    public QMUIContinuousNestedTopWebView(android.content.Context context) {
        super(context);
        init();
    }

    public QMUIContinuousNestedTopWebView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public QMUIContinuousNestedTopWebView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setVerticalScrollBarEnabled(false);
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int consumeScroll(int i) {
        int iMin;
        int scrollY = getScrollY();
        int scrollOffsetRange = getScrollOffsetRange();
        int iMax = java.lang.Math.max(0, java.lang.Math.min(scrollY, scrollOffsetRange));
        if (i < 0) {
            iMin = java.lang.Math.max(i, -iMax);
        } else {
            iMin = i > 0 ? java.lang.Math.min(i, scrollOffsetRange - iMax) : 0;
        }
        scrollBy(0, iMin);
        return i - iMin;
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int getCurrentScroll() {
        return java.lang.Math.max(0, java.lang.Math.min(getScrollY(), getScrollOffsetRange()));
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedTopView
    public int getScrollOffsetRange() {
        return computeVerticalScrollRange() - getHeight();
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void injectScrollNotifier(com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.mScrollNotifier = onScrollNotifier;
    }

    @Override // com.up366.qmui.widget.webview.QMUIWebView, android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier = this.mScrollNotifier;
        if (onScrollNotifier != null) {
            onScrollNotifier.notify(getCurrentScroll(), getScrollOffsetRange());
        }
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void saveScrollInfo(android.os.Bundle bundle) {
        bundle.putInt(KEY_SCROLL_INFO, getScrollY());
    }

    @Override // com.up366.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void restoreScrollInfo(android.os.Bundle bundle) {
        exec("javascript:scrollTo(0, " + com.up366.qmui.util.QMUIDisplayHelper.px2dp(getContext(), bundle.getInt(KEY_SCROLL_INFO, 0)) + ")");
    }

    private void exec(java.lang.String str) {
        evaluateJavascript(str, null);
    }
}
