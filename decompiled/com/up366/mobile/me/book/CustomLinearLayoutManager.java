package com.up366.mobile.me.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class CustomLinearLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {
    public boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public CustomLinearLayoutManager(android.content.Context context) {
        super(context);
    }

    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (java.lang.Exception e) {
            com.up366.mobile.common.onlinelog.OpLog.record("LAYOUT-ERROR", "onLayoutChildren: " + e.getMessage());
        }
    }

    public int scrollVerticallyBy(int i, androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
        try {
            return super.scrollVerticallyBy(i, recycler, state);
        } catch (java.lang.Exception e) {
            com.up366.mobile.common.onlinelog.OpLog.record("LAYOUT-ERROR", "scrollVerticallyBy: " + e.getMessage());
            return 0;
        }
    }

    public int scrollHorizontallyBy(int i, androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
        try {
            super.scrollHorizontallyBy(i, recycler, state);
            return 0;
        } catch (java.lang.Exception e) {
            com.up366.mobile.common.onlinelog.OpLog.record("LAYOUT-ERROR", "scrollHorizontallyBy: " + e.getMessage());
            return 0;
        }
    }
}
