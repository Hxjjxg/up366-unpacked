package com.up366.mobile.book.studyviews.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V1WellDownView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.V1WellDownViewLayoutBinding b;
    private android.view.View.OnClickListener backToCatalogListener;
    private android.view.View.OnClickListener nextUnitListener;

    public V1WellDownView(android.content.Context context) {
        this(context, null);
    }

    public V1WellDownView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public V1WellDownView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            android.view.View.inflate(context, com.up366.mobile.R.layout.v1_well_down_view_layout, this);
        } else {
            this.b = (com.up366.mobile.databinding.V1WellDownViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.v1_well_down_view_layout, this, true);
        }
    }

    public void setNextUnitListener(android.view.View.OnClickListener onClickListener) {
        this.nextUnitListener = onClickListener;
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.b.gameOverNextUnit, onClickListener);
    }

    public void setBackToCatalogListener(android.view.View.OnClickListener onClickListener) {
        this.backToCatalogListener = onClickListener;
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.b.gameOverBackCatalog, onClickListener);
    }
}
