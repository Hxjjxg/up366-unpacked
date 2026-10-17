package io.objectbox.android;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ObjectBoxDataSource<T> extends androidx.paging.PositionalDataSource<T> {
    private final io.objectbox.reactive.DataObserver<java.util.List<T>> observer;
    private final io.objectbox.query.Query<T> query;

    public static class Factory<Item> extends androidx.paging.DataSource.Factory<java.lang.Integer, Item> {
        private final io.objectbox.query.Query<Item> query;

        public Factory(io.objectbox.query.Query<Item> query) {
            this.query = query;
        }

        public androidx.paging.DataSource<java.lang.Integer, Item> create() {
            return new io.objectbox.android.ObjectBoxDataSource(this.query);
        }
    }

    public ObjectBoxDataSource(io.objectbox.query.Query<T> query) {
        this.query = query;
        io.objectbox.reactive.DataObserver<java.util.List<T>> dataObserver = new io.objectbox.reactive.DataObserver() { // from class: io.objectbox.android.ObjectBoxDataSource$$ExternalSyntheticLambda0
            @Override // io.objectbox.reactive.DataObserver
            public final void onData(java.lang.Object obj) {
                this.f$0.m1395lambda$new$0$ioobjectboxandroidObjectBoxDataSource((java.util.List) obj);
            }
        };
        this.observer = dataObserver;
        query.subscribe().onlyChanges().weak().observer(dataObserver);
    }

    /* JADX INFO: renamed from: lambda$new$0$io-objectbox-android-ObjectBoxDataSource, reason: not valid java name */
    /* synthetic */ void m1395lambda$new$0$ioobjectboxandroidObjectBoxDataSource(java.util.List list) {
        invalidate();
    }

    public void loadInitial(androidx.paging.PositionalDataSource.LoadInitialParams loadInitialParams, androidx.paging.PositionalDataSource.LoadInitialCallback<T> loadInitialCallback) {
        int iCount = (int) this.query.count();
        if (iCount == 0) {
            loadInitialCallback.onResult(java.util.Collections.emptyList(), 0, 0);
            return;
        }
        int iComputeInitialLoadPosition = computeInitialLoadPosition(loadInitialParams, iCount);
        int iComputeInitialLoadSize = computeInitialLoadSize(loadInitialParams, iComputeInitialLoadPosition, iCount);
        java.util.List<T> listLoadRange = loadRange(iComputeInitialLoadPosition, iComputeInitialLoadSize);
        if (listLoadRange.size() == iComputeInitialLoadSize) {
            loadInitialCallback.onResult(listLoadRange, iComputeInitialLoadPosition, iCount);
        } else {
            invalidate();
        }
    }

    public void loadRange(androidx.paging.PositionalDataSource.LoadRangeParams loadRangeParams, androidx.paging.PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        loadRangeCallback.onResult(loadRange(loadRangeParams.startPosition, loadRangeParams.loadSize));
    }

    private java.util.List<T> loadRange(int i, int i2) {
        return this.query.find(i, i2);
    }
}
