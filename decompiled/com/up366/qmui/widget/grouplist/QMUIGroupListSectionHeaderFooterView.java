package com.up366.qmui.widget.grouplist;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIGroupListSectionHeaderFooterView extends android.widget.LinearLayout {
    private android.widget.TextView mTextView;

    public QMUIGroupListSectionHeaderFooterView(android.content.Context context) {
        this(context, (android.util.AttributeSet) null, com.qmuiteam.qmui.R.attr.QMUIGroupListSectionViewStyle);
    }

    public QMUIGroupListSectionHeaderFooterView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUIGroupListSectionViewStyle);
    }

    public QMUIGroupListSectionHeaderFooterView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public QMUIGroupListSectionHeaderFooterView(android.content.Context context, java.lang.CharSequence charSequence) {
        this(context);
        setText(charSequence);
    }

    public QMUIGroupListSectionHeaderFooterView(android.content.Context context, java.lang.CharSequence charSequence, boolean z) {
        this(context);
        if (z) {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), 0);
        }
        setText(charSequence);
    }

    private void init(android.content.Context context) {
        android.view.LayoutInflater.from(context).inflate(com.qmuiteam.qmui.R.layout.qmui_group_list_section_layout, (android.view.ViewGroup) this, true);
        setGravity(80);
        this.mTextView = (android.widget.TextView) findViewById(com.qmuiteam.qmui.R.id.group_list_section_header_textView);
    }

    public void setText(java.lang.CharSequence charSequence) {
        if (com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(charSequence)) {
            this.mTextView.setVisibility(8);
        } else {
            this.mTextView.setVisibility(0);
        }
        this.mTextView.setText(charSequence);
    }

    public android.widget.TextView getTextView() {
        return this.mTextView;
    }

    public void setTextGravity(int i) {
        this.mTextView.setGravity(i);
    }
}
