package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TrendView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.ViewTrendViewBinding binding;

    public TrendView(android.content.Context context) {
        this(context, null);
    }

    public TrendView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrendView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.binding = (com.up366.mobile.databinding.ViewTrendViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.view_trend_view, this, true);
    }

    public void setAxis(java.lang.String[] strArr, int i, int i2) {
        this.binding.lsvShowChart.setAxis(strArr, i, i2);
    }

    public void setTitle(int i, java.lang.String str) {
        this.binding.ivTrendTitle.setImageResource(i);
        this.binding.tvTrendTitle.setText(str);
    }

    public void setLastCompare(int i, java.lang.String str) {
        this.binding.ivLastCompare.setVisibility(0);
        this.binding.ivLastCompare.setImageResource(i);
        this.binding.tvLastCompare.setVisibility(0);
        this.binding.tvLastCompare.setText(str);
    }

    public void setChartYTitle(java.lang.String str) {
        this.binding.tvChartYTitle.setText(str);
    }

    public void setVisibleSchoolAndEarthLineColor() {
        this.binding.rbEarthLineColor.setVisibility(0);
        this.binding.rbSchoolLineColor.setVisibility(0);
    }

    public void setData(int[] iArr, int[] iArr2, int[] iArr3, java.lang.String[] strArr) {
        this.binding.lsvShowChart.setData(iArr, iArr2, iArr3, strArr);
    }

    public void setShowToast(boolean z) {
        this.binding.lsvShowChart.setShowToast(z);
    }
}
