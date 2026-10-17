package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIDialogBlockBuilder extends com.up366.qmui.widget.dialog.QMUIDialogBuilder<com.up366.qmui.widget.dialog.QMUIDialogBlockBuilder> {
    private java.lang.CharSequence mContent;

    public QMUIDialogBlockBuilder(android.content.Context context) {
        super(context);
        setActionDivider(1, com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_action_divider_color, 0, 0);
    }

    public com.up366.qmui.widget.dialog.QMUIDialogBlockBuilder setContent(java.lang.CharSequence charSequence) {
        this.mContent = charSequence;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIDialogBlockBuilder setContent(int i) {
        this.mContent = getBaseContext().getResources().getString(i);
        return this;
    }

    @Override // com.up366.qmui.widget.dialog.QMUIDialogBuilder
    protected android.view.View onCreateTitle(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView, android.content.Context context) {
        java.lang.CharSequence charSequence;
        android.view.View viewOnCreateTitle = super.onCreateTitle(qMUIDialog, qMUIDialogView, context);
        if (viewOnCreateTitle != null && ((charSequence = this.mContent) == null || charSequence.length() == 0)) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, com.qmuiteam.qmui.R.styleable.QMUIDialogTitleTvCustomDef, com.qmuiteam.qmui.R.attr.qmui_dialog_title_style, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogTitleTvCustomDef_qmui_paddingBottomWhenNotContent) {
                    viewOnCreateTitle.setPadding(viewOnCreateTitle.getPaddingLeft(), viewOnCreateTitle.getPaddingTop(), viewOnCreateTitle.getPaddingRight(), typedArrayObtainStyledAttributes.getDimensionPixelSize(index, viewOnCreateTitle.getPaddingBottom()));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        return viewOnCreateTitle;
    }

    @Override // com.up366.qmui.widget.dialog.QMUIDialogBuilder
    protected android.view.View onCreateContent(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView, android.content.Context context) {
        java.lang.CharSequence charSequence = this.mContent;
        if (charSequence == null || charSequence.length() <= 0) {
            return null;
        }
        androidx.appcompat.widget.AppCompatTextView qMUISpanTouchFixTextView = new com.up366.qmui.widget.textview.QMUISpanTouchFixTextView(context);
        com.up366.qmui.util.QMUIResHelper.assignTextViewWithAttr(qMUISpanTouchFixTextView, com.qmuiteam.qmui.R.attr.qmui_dialog_message_content_style);
        if (!hasTitle()) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, com.qmuiteam.qmui.R.styleable.QMUIDialogMessageTvCustomDef, com.qmuiteam.qmui.R.attr.qmui_dialog_message_content_style, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMessageTvCustomDef_qmui_paddingTopWhenNotTitle) {
                    qMUISpanTouchFixTextView.setPadding(qMUISpanTouchFixTextView.getPaddingLeft(), typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qMUISpanTouchFixTextView.getPaddingTop()), qMUISpanTouchFixTextView.getPaddingRight(), qMUISpanTouchFixTextView.getPaddingBottom());
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        qMUISpanTouchFixTextView.setText(this.mContent);
        return wrapWithScroll(qMUISpanTouchFixTextView);
    }

    @Override // com.up366.qmui.widget.dialog.QMUIDialogBuilder
    public com.up366.qmui.widget.dialog.QMUIDialog create(int i) {
        setActionContainerOrientation(1);
        return super.create(i);
    }
}
