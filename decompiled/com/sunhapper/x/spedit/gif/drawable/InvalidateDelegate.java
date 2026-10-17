package com.sunhapper.x.spedit.gif.drawable;

/* JADX INFO: compiled from: InvalidateDelegate.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0016J \u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/sunhapper/x/spedit/gif/drawable/InvalidateDelegate;", "Lcom/sunhapper/x/spedit/gif/drawable/InvalidateDrawable;", "Landroid/graphics/drawable/Drawable$Callback;", "()V", "mRefreshListeners", "", "Lcom/sunhapper/x/spedit/gif/listener/RefreshListener;", "getMRefreshListeners", "()Ljava/util/Collection;", "setMRefreshListeners", "(Ljava/util/Collection;)V", "addRefreshListener", "", "callback", "invalidateDrawable", "who", "Landroid/graphics/drawable/Drawable;", "refresh", "removeRefreshListener", "scheduleDrawable", "what", "Ljava/lang/Runnable;", "when", "", "unscheduleDrawable", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
public final class InvalidateDelegate implements com.sunhapper.x.spedit.gif.drawable.InvalidateDrawable, android.graphics.drawable.Drawable.Callback {
    private java.util.Collection<com.sunhapper.x.spedit.gif.listener.RefreshListener> mRefreshListeners = new java.util.ArrayList();

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(android.graphics.drawable.Drawable who, java.lang.Runnable what, long when) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(who, "who");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(what, "what");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(android.graphics.drawable.Drawable who, java.lang.Runnable what) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(who, "who");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(what, "what");
    }

    @Override // com.sunhapper.x.spedit.gif.drawable.InvalidateDrawable
    public java.util.Collection<com.sunhapper.x.spedit.gif.listener.RefreshListener> getMRefreshListeners() {
        return this.mRefreshListeners;
    }

    @Override // com.sunhapper.x.spedit.gif.drawable.InvalidateDrawable
    public void setMRefreshListeners(java.util.Collection<com.sunhapper.x.spedit.gif.listener.RefreshListener> collection) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(collection, "<set-?>");
        this.mRefreshListeners = collection;
    }

    @Override // com.sunhapper.x.spedit.gif.drawable.InvalidateDrawable
    public void addRefreshListener(com.sunhapper.x.spedit.gif.listener.RefreshListener callback) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(callback, "callback");
        getMRefreshListeners().add(callback);
    }

    @Override // com.sunhapper.x.spedit.gif.drawable.InvalidateDrawable
    public void removeRefreshListener(com.sunhapper.x.spedit.gif.listener.RefreshListener callback) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(callback, "callback");
        getMRefreshListeners().remove(callback);
    }

    @Override // com.sunhapper.x.spedit.gif.drawable.InvalidateDrawable
    public void refresh() {
        java.util.Collection<com.sunhapper.x.spedit.gif.listener.RefreshListener> mRefreshListeners = getMRefreshListeners();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : mRefreshListeners) {
            if (((com.sunhapper.x.spedit.gif.listener.RefreshListener) obj).onRefresh()) {
                arrayList.add(obj);
            }
        }
        setMRefreshListeners(kotlin.collections.CollectionsKt.toMutableList(arrayList));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(android.graphics.drawable.Drawable who) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(who, "who");
        refresh();
    }
}
