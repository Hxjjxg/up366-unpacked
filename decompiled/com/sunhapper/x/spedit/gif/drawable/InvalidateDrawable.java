package com.sunhapper.x.spedit.gif.drawable;

/* JADX INFO: compiled from: InvalidateDrawable.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\nH&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H&R\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/sunhapper/x/spedit/gif/drawable/InvalidateDrawable;", "", "mRefreshListeners", "", "Lcom/sunhapper/x/spedit/gif/listener/RefreshListener;", "getMRefreshListeners", "()Ljava/util/Collection;", "setMRefreshListeners", "(Ljava/util/Collection;)V", "addRefreshListener", "", "callback", "refresh", "removeRefreshListener", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
public interface InvalidateDrawable {
    void addRefreshListener(com.sunhapper.x.spedit.gif.listener.RefreshListener callback);

    java.util.Collection<com.sunhapper.x.spedit.gif.listener.RefreshListener> getMRefreshListeners();

    void refresh();

    void removeRefreshListener(com.sunhapper.x.spedit.gif.listener.RefreshListener callback);

    void setMRefreshListeners(java.util.Collection<com.sunhapper.x.spedit.gif.listener.RefreshListener> collection);
}
