package com.up366.medialibrary.common.decoration;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class WrapContentLinearLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {
    public WrapContentLinearLayoutManager(android.content.Context context) {
        super(context);
    }

    public WrapContentLinearLayoutManager(android.content.Context context, int i, boolean z) {
        super(context, i, z);
    }

    public WrapContentLinearLayoutManager(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.Recycler recycler, androidx.recyclerview.widget.RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (java.lang.IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
