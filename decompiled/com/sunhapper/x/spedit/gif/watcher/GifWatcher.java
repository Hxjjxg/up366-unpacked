package com.sunhapper.x.spedit.gif.watcher;

/* JADX INFO: compiled from: GifWatcher.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J8\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0016J(\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/sunhapper/x/spedit/gif/watcher/GifWatcher;", "Landroid/text/SpanWatcher;", "Lcom/sunhapper/x/spedit/gif/listener/RefreshListener;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "mLastTime", "", "mViewWeakReference", "Ljava/lang/ref/WeakReference;", "onRefresh", "", "onSpanAdded", "", "text", "Landroid/text/Spannable;", "what", "", "start", "", "end", "onSpanChanged", "ostart", "oend", "nstart", "nend", "onSpanRemoved", "Companion", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
public final class GifWatcher implements android.text.SpanWatcher, com.sunhapper.x.spedit.gif.listener.RefreshListener {
    private static final int REFRESH_INTERVAL = 60;
    private long mLastTime;
    private final java.lang.ref.WeakReference<android.view.View> mViewWeakReference;

    @Override // android.text.SpanWatcher
    public void onSpanChanged(android.text.Spannable text, java.lang.Object what, int ostart, int oend, int nstart, int nend) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(what, "what");
    }

    public GifWatcher(android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(view, "view");
        this.mViewWeakReference = new java.lang.ref.WeakReference<>(view);
    }

    @Override // android.text.SpanWatcher
    public void onSpanAdded(android.text.Spannable text, java.lang.Object what, int start, int end) {
        com.sunhapper.x.spedit.gif.drawable.InvalidateDrawable invalidateDrawable;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(what, "what");
        if (!(what instanceof com.sunhapper.x.spedit.gif.span.RefreshSpan) || (invalidateDrawable = ((com.sunhapper.x.spedit.gif.span.RefreshSpan) what).getInvalidateDrawable()) == null) {
            return;
        }
        invalidateDrawable.addRefreshListener(this);
    }

    @Override // android.text.SpanWatcher
    public void onSpanRemoved(android.text.Spannable text, java.lang.Object what, int start, int end) {
        com.sunhapper.x.spedit.gif.drawable.InvalidateDrawable invalidateDrawable;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(what, "what");
        if (!(what instanceof com.sunhapper.x.spedit.gif.span.RefreshSpan) || (invalidateDrawable = ((com.sunhapper.x.spedit.gif.span.RefreshSpan) what).getInvalidateDrawable()) == null) {
            return;
        }
        invalidateDrawable.removeRefreshListener(this);
    }

    @Override // com.sunhapper.x.spedit.gif.listener.RefreshListener
    public boolean onRefresh() {
        android.view.View view = this.mViewWeakReference.get();
        if (view == null) {
            return false;
        }
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(view, "mViewWeakReference.get() ?: return false");
        android.content.Context context = view.getContext();
        if (context instanceof android.app.Activity) {
            if (((android.app.Activity) context).isDestroyed()) {
                this.mViewWeakReference.clear();
                return false;
            }
            if (((android.app.Activity) context).isFinishing()) {
                this.mViewWeakReference.clear();
                return false;
            }
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (jCurrentTimeMillis - this.mLastTime <= 60) {
            return true;
        }
        this.mLastTime = jCurrentTimeMillis;
        view.invalidate();
        return true;
    }
}
