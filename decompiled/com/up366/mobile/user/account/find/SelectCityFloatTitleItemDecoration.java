package com.up366.mobile.user.account.find;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class SelectCityFloatTitleItemDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    private int holderObj = -124567;
    private android.view.View holderView;

    SelectCityFloatTitleItemDecoration() {
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setColor(-5592406);
        paint.setStrokeWidth(1.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDrawOver(android.graphics.Canvas r9, androidx.recyclerview.widget.RecyclerView r10, androidx.recyclerview.widget.RecyclerView.State r11) {
        /*
            r8 = this;
            r11 = 0
            r0 = r11
        L2:
            int r1 = r10.getChildCount()
            if (r0 >= r1) goto L1e
            android.view.View r1 = r10.getChildAt(r0)
            int r2 = r1.getTop()
            r3 = 20
            if (r2 > r3) goto L1b
            int r2 = r1.getBottom()
            if (r2 <= 0) goto L1b
            goto L1f
        L1b:
            int r0 = r0 + 1
            goto L2
        L1e:
            r1 = 0
        L1f:
            if (r1 != 0) goto L22
            return
        L22:
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r10.getAdapter()
            int r2 = r10.getChildAdapterPosition(r1)
            r3 = -1
            if (r2 != r3) goto L2e
            return
        L2e:
            r4 = r0
            com.up366.mobile.common.base.BaseRecyclerAdapter r4 = (com.up366.mobile.common.base.BaseRecyclerAdapter) r4
            java.util.List r4 = r4.getDatas()
            r5 = r2
        L36:
            r6 = -9995(0xffffffffffffd8f5, float:NaN)
            if (r5 < 0) goto L44
            int r7 = r0.getItemViewType(r5)
            if (r7 != r6) goto L41
            goto L45
        L41:
            int r5 = r5 + (-1)
            goto L36
        L44:
            r5 = r3
        L45:
            if (r2 != r5) goto L4e
            int r7 = r1.getTop()
            if (r7 <= 0) goto L4e
            return
        L4e:
            if (r5 != r3) goto L51
            return
        L51:
            int r3 = r4.size()
            if (r2 >= r3) goto L60
            r3 = 1
            int r2 = r2 + r3
            int r0 = r0.getItemViewType(r2)
            if (r0 != r6) goto L60
            goto L61
        L60:
            r3 = r11
        L61:
            if (r3 == 0) goto L74
            android.view.View r0 = r8.getHolderView(r10, r5)
            int r0 = r0.getMeasuredHeight()
            int r1 = r1.getBottom()
            int r1 = r1 - r0
            if (r1 <= 0) goto L73
            goto L74
        L73:
            r11 = r1
        L74:
            r9.save()
            r0 = 0
            float r11 = (float) r11
            r9.translate(r0, r11)
            android.view.View r10 = r8.getHolderView(r10, r5)
            r10.draw(r9)
            r9.restore()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.user.account.find.SelectCityFloatTitleItemDecoration.onDrawOver(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    private android.view.View getHolderView(androidx.recyclerview.widget.RecyclerView recyclerView, int i) {
        android.view.View viewFindViewByPosition = recyclerView.getLayoutManager().findViewByPosition(i);
        if (viewFindViewByPosition != null) {
            return viewFindViewByPosition;
        }
        androidx.recyclerview.widget.RecyclerView.Adapter adapter = recyclerView.getAdapter();
        com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = ((com.up366.mobile.common.base.BaseRecyclerAdapter) adapter).getDatas().get(i);
        if (dataHolder.hashCode() == this.holderObj) {
            return this.holderView;
        }
        this.holderObj = dataHolder.hashCode();
        androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolderCreateViewHolder = adapter.createViewHolder(recyclerView, adapter.getItemViewType(i));
        adapter.bindViewHolder(viewHolderCreateViewHolder, i);
        android.view.View view = viewHolderCreateViewHolder.itemView;
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), com.up366.medialibrary.common.utils.PictureFileUtils.GB), android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, recyclerView.getMeasuredWidth(), view.getMeasuredHeight());
        android.view.View view2 = viewHolderCreateViewHolder.itemView;
        this.holderView = view2;
        return view2;
    }
}
