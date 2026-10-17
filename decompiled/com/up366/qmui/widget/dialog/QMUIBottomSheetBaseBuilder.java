package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class QMUIBottomSheetBaseBuilder<T extends com.up366.qmui.widget.dialog.QMUIBottomSheetBaseBuilder> {
    private boolean mAddCancelBtn;
    private java.lang.String mCancelText;
    private android.content.Context mContext;
    protected com.up366.qmui.widget.dialog.QMUIBottomSheet mDialog;
    private android.content.DialogInterface.OnDismissListener mOnBottomDialogDismissListener;
    private com.up366.qmui.skin.QMUISkinManager mSkinManager;
    private java.lang.CharSequence mTitle;
    private int mRadius = -1;
    private boolean mAllowDrag = false;
    private com.up366.qmui.widget.dialog.QMUIBottomSheetBehavior.DownDragDecisionMaker mDownDragDecisionMaker = null;

    protected void onAddCustomViewAfterContent(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, android.content.Context context) {
    }

    protected void onAddCustomViewBetweenTitleAndContent(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, android.content.Context context) {
    }

    protected abstract android.view.View onCreateContentView(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, android.content.Context context);

    public QMUIBottomSheetBaseBuilder(android.content.Context context) {
        this.mContext = context;
    }

    public T setTitle(java.lang.CharSequence charSequence) {
        this.mTitle = charSequence;
        return this;
    }

    protected boolean hasTitle() {
        java.lang.CharSequence charSequence = this.mTitle;
        return (charSequence == null || charSequence.length() == 0) ? false : true;
    }

    public T setAllowDrag(boolean z) {
        this.mAllowDrag = z;
        return this;
    }

    public T setSkinManager(com.up366.qmui.skin.QMUISkinManager qMUISkinManager) {
        this.mSkinManager = qMUISkinManager;
        return this;
    }

    public T setDownDragDecisionMaker(com.up366.qmui.widget.dialog.QMUIBottomSheetBehavior.DownDragDecisionMaker downDragDecisionMaker) {
        this.mDownDragDecisionMaker = downDragDecisionMaker;
        return this;
    }

    public T setAddCancelBtn(boolean z) {
        this.mAddCancelBtn = z;
        return this;
    }

    public T setCancelText(java.lang.String str) {
        this.mCancelText = str;
        return this;
    }

    public T setRadius(int i) {
        this.mRadius = i;
        return this;
    }

    public T setOnBottomDialogDismissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
        this.mOnBottomDialogDismissListener = onDismissListener;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheet build() {
        return build(com.qmuiteam.qmui.R.style.QMUI_BottomSheet);
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheet build(int i) {
        com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet = new com.up366.qmui.widget.dialog.QMUIBottomSheet(this.mContext, i);
        this.mDialog = qMUIBottomSheet;
        android.content.Context context = qMUIBottomSheet.getContext();
        com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout rootView = this.mDialog.getRootView();
        rootView.removeAllViews();
        android.view.View viewOnCreateTitleView = onCreateTitleView(this.mDialog, rootView, context);
        if (viewOnCreateTitleView != null) {
            this.mDialog.addContentView(viewOnCreateTitleView);
        }
        onAddCustomViewBetweenTitleAndContent(this.mDialog, rootView, context);
        android.view.View viewOnCreateContentView = onCreateContentView(this.mDialog, rootView, context);
        if (viewOnCreateContentView != null) {
            this.mDialog.addContentView(viewOnCreateContentView);
        }
        onAddCustomViewAfterContent(this.mDialog, rootView, context);
        if (this.mAddCancelBtn) {
            com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet2 = this.mDialog;
            qMUIBottomSheet2.addContentView(onCreateCancelBtn(qMUIBottomSheet2, rootView, context), new android.widget.LinearLayout.LayoutParams(-1, com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_cancel_btn_height)));
        }
        android.content.DialogInterface.OnDismissListener onDismissListener = this.mOnBottomDialogDismissListener;
        if (onDismissListener != null) {
            this.mDialog.setOnDismissListener(onDismissListener);
        }
        int i2 = this.mRadius;
        if (i2 != -1) {
            this.mDialog.setRadius(i2);
        }
        this.mDialog.setSkinManager(this.mSkinManager);
        com.up366.qmui.widget.dialog.QMUIBottomSheetBehavior<com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout> behavior = this.mDialog.getBehavior();
        behavior.setAllowDrag(this.mAllowDrag);
        behavior.setDownDragDecisionMaker(this.mDownDragDecisionMaker);
        return this.mDialog;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.View, android.widget.TextView, com.up366.qmui.widget.textview.QMUISpanTouchFixTextView] */
    protected android.view.View onCreateTitleView(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, android.content.Context context) {
        if (!hasTitle()) {
            return null;
        }
        ?? qMUISpanTouchFixTextView = new com.up366.qmui.widget.textview.QMUISpanTouchFixTextView(context);
        qMUISpanTouchFixTextView.setId(com.qmuiteam.qmui.R.id.qmui_bottom_sheet_title);
        qMUISpanTouchFixTextView.setText(this.mTitle);
        qMUISpanTouchFixTextView.onlyShowBottomDivider(0, 0, 1, com.up366.qmui.util.QMUIResHelper.getAttrColor(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_separator_color));
        com.up366.qmui.util.QMUIResHelper.assignTextViewWithAttr(qMUISpanTouchFixTextView, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_title_style);
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.textColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_title_text_color);
        qMUISkinValueBuilderAcquire.bottomSeparator(com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_separator_color);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) qMUISpanTouchFixTextView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
        return qMUISpanTouchFixTextView;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View, android.widget.TextView, com.up366.qmui.layout.QMUIButton] */
    protected android.view.View onCreateCancelBtn(final com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, android.content.Context context) {
        ?? qMUIButton = new com.up366.qmui.layout.QMUIButton(context);
        qMUIButton.setId(com.qmuiteam.qmui.R.id.qmui_bottom_sheet_cancel);
        java.lang.String str = this.mCancelText;
        if (str == null || str.isEmpty()) {
            this.mCancelText = context.getString(com.qmuiteam.qmui.R.string.qmui_cancel);
        }
        qMUIButton.setPadding(0, 0, 0, 0);
        qMUIButton.setBackground(com.up366.qmui.util.QMUIResHelper.getAttrDrawable(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_cancel_bg));
        qMUIButton.setText(this.mCancelText);
        com.up366.qmui.util.QMUIResHelper.assignTextViewWithAttr(qMUIButton, com.qmuiteam.qmui.R.attr.qmui_bottom_sheet_cancel_style);
        qMUIButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.qmui.widget.dialog.QMUIBottomSheetBaseBuilder.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                qMUIBottomSheet.cancel();
            }
        });
        qMUIButton.onlyShowTopDivider(0, 0, 1, com.up366.qmui.util.QMUIResHelper.getAttrColor(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_separator_color));
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.textColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_cancel_text_color);
        qMUISkinValueBuilderAcquire.topSeparator(com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_separator_color);
        qMUISkinValueBuilderAcquire.background(com.qmuiteam.qmui.R.attr.qmui_skin_support_bottom_sheet_cancel_bg);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) qMUIButton, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
        return qMUIButton;
    }
}
