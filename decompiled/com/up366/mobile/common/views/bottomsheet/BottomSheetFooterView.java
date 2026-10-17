package com.up366.mobile.common.views.bottomsheet;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BottomSheetFooterView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.BottomSheetFooterViewBinding b;

    public BottomSheetFooterView(android.content.Context context) {
        super(context);
        this.b = (com.up366.mobile.databinding.BottomSheetFooterViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.bottom_sheet_footer_view, this, true);
    }

    public void setButton(java.lang.String str, android.view.View.OnClickListener onClickListener) {
        this.b.footerBtn.setText(str);
        this.b.footerBtn.setOnClickListener(onClickListener);
    }
}
