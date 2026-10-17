package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TaskYearItemView extends android.widget.LinearLayout {
    private com.up366.mobile.databinding.ViewItemTaskYearBinding b;

    public TaskYearItemView(android.content.Context context) {
        this(context, null);
    }

    public TaskYearItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TaskYearItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.ViewItemTaskYearBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.view_item_task_year, this, true);
    }

    public void setYear(java.lang.String str) {
        this.b.tvYear.setText(str + "年");
    }
}
