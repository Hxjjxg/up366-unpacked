package com.up366.mobile.common.views.bottomsheet;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BottomSheetHeaderView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.BottomSheetHeaderViewBinding b;

    public BottomSheetHeaderView(android.content.Context context) {
        super(context);
        this.b = (com.up366.mobile.databinding.BottomSheetHeaderViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.bottom_sheet_header_view, this, true);
    }

    public void setTitleText(java.lang.String str) {
        this.b.tvTitle.setText(str);
    }

    public void setMarginStart(int i) {
        this.b.tvTitle.getLayoutParams().setMarginStart(i);
    }

    public void setCloseClickListener(android.view.View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.b.ivClose.setVisibility(8);
        } else {
            this.b.ivClose.setVisibility(0);
            this.b.ivClose.setOnClickListener(onClickListener);
        }
    }
}
