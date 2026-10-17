package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public abstract class QMUIDialogBuilder<T extends com.up366.qmui.widget.dialog.QMUIDialogBuilder> {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private static com.up366.qmui.widget.dialog.QMUIDialogBuilder.OnProvideDefaultTheme sOnProvideDefaultTheme;
    private android.content.Context mContext;
    protected com.up366.qmui.widget.dialog.QMUIDialog mDialog;
    protected com.up366.qmui.widget.dialog.QMUIDialogView mDialogView;
    private com.up366.qmui.widget.dialog.QMUIDialogView.OnDecorationListener mOnDecorationListener;
    protected com.up366.qmui.widget.dialog.QMUIDialogRootLayout mRootView;
    private com.up366.qmui.skin.QMUISkinManager mSkinManager;
    protected java.lang.String mTitle;
    private boolean mCancelable = true;
    private boolean mCanceledOnTouchOutside = true;
    protected java.util.List<com.up366.qmui.widget.dialog.QMUIDialogAction> mActions = new java.util.ArrayList();
    private int mActionContainerOrientation = 0;
    private boolean mChangeAlphaForPressOrDisable = true;
    private int mActionDividerThickness = 0;
    private int mActionDividerColorAttr = com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_action_divider_color;
    private int mActionDividerInsetStart = 0;
    private int mActionDividerInsetEnd = 0;
    private int mActionDividerColor = 0;
    private boolean mCheckKeyboardOverlay = false;
    private float mMaxPercent = 0.75f;

    public interface OnProvideDefaultTheme {
        int getThemeForBuilder(com.up366.qmui.widget.dialog.QMUIDialogBuilder qMUIDialogBuilder);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    protected void configRootLayout(com.up366.qmui.widget.dialog.QMUIDialogRootLayout qMUIDialogRootLayout) {
    }

    protected void onAfterCreate(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogRootLayout qMUIDialogRootLayout, android.content.Context context) {
    }

    protected abstract android.view.View onCreateContent(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView, android.content.Context context);

    protected void onOverlayOccurredInMeasure() {
    }

    public static void setOnProvideDefaultTheme(com.up366.qmui.widget.dialog.QMUIDialogBuilder.OnProvideDefaultTheme onProvideDefaultTheme) {
        sOnProvideDefaultTheme = onProvideDefaultTheme;
    }

    public QMUIDialogBuilder(android.content.Context context) {
        this.mContext = context;
    }

    public android.content.Context getBaseContext() {
        return this.mContext;
    }

    public T setTitle(java.lang.String str) {
        if (str != null && str.length() > 0) {
            this.mTitle = str + this.mContext.getString(com.qmuiteam.qmui.R.string.qmui_tool_fixellipsize);
        }
        return this;
    }

    public T setTitle(int i) {
        return (T) setTitle(this.mContext.getResources().getString(i));
    }

    public T setCancelable(boolean z) {
        this.mCancelable = z;
        return this;
    }

    public T setCanceledOnTouchOutside(boolean z) {
        this.mCanceledOnTouchOutside = z;
        return this;
    }

    public T setOnDecorationListener(com.up366.qmui.widget.dialog.QMUIDialogView.OnDecorationListener onDecorationListener) {
        this.mOnDecorationListener = onDecorationListener;
        return this;
    }

    public T setActionContainerOrientation(int i) {
        this.mActionContainerOrientation = i;
        return this;
    }

    public T setChangeAlphaForPressOrDisable(boolean z) {
        this.mChangeAlphaForPressOrDisable = z;
        return this;
    }

    public T setActionDivider(int i, int i2, int i3, int i4) {
        this.mActionDividerThickness = i;
        this.mActionDividerColorAttr = i2;
        this.mActionDividerInsetStart = i3;
        this.mActionDividerInsetEnd = i4;
        return this;
    }

    public T setActionDividerInsetAndThickness(int i, int i2, int i3) {
        this.mActionDividerThickness = i;
        this.mActionDividerInsetStart = i2;
        this.mActionDividerInsetEnd = i3;
        return this;
    }

    public T setActionDividerColorAttr(int i) {
        this.mActionDividerColorAttr = i;
        return this;
    }

    public T setActionDividerColor(int i) {
        this.mActionDividerColor = i;
        this.mActionDividerColorAttr = 0;
        return this;
    }

    public T setCheckKeyboardOverlay(boolean z) {
        this.mCheckKeyboardOverlay = z;
        return this;
    }

    public T setSkinManager(com.up366.qmui.skin.QMUISkinManager qMUISkinManager) {
        this.mSkinManager = qMUISkinManager;
        return this;
    }

    public T setMaxPercent(float f) {
        this.mMaxPercent = f;
        return this;
    }

    public T addAction(com.up366.qmui.widget.dialog.QMUIDialogAction qMUIDialogAction) {
        if (qMUIDialogAction != null) {
            this.mActions.add(qMUIDialogAction);
        }
        return this;
    }

    public T addAction(int i, com.up366.qmui.widget.dialog.QMUIDialogAction.ActionListener actionListener) {
        return (T) addAction(0, i, actionListener);
    }

    public T addAction(java.lang.CharSequence charSequence, com.up366.qmui.widget.dialog.QMUIDialogAction.ActionListener actionListener) {
        return (T) addAction(0, charSequence, 1, actionListener);
    }

    public T addAction(int i, int i2, com.up366.qmui.widget.dialog.QMUIDialogAction.ActionListener actionListener) {
        return (T) addAction(i, i2, 1, actionListener);
    }

    public T addAction(int i, java.lang.CharSequence charSequence, com.up366.qmui.widget.dialog.QMUIDialogAction.ActionListener actionListener) {
        return (T) addAction(i, charSequence, 1, actionListener);
    }

    public T addAction(int i, int i2, int i3, com.up366.qmui.widget.dialog.QMUIDialogAction.ActionListener actionListener) {
        return (T) addAction(i, this.mContext.getResources().getString(i2), i3, actionListener);
    }

    public T addAction(int i, java.lang.CharSequence charSequence, int i2, com.up366.qmui.widget.dialog.QMUIDialogAction.ActionListener actionListener) {
        this.mActions.add(new com.up366.qmui.widget.dialog.QMUIDialogAction(charSequence).iconRes(i).prop(i2).onClick(actionListener));
        return this;
    }

    protected boolean hasTitle() {
        java.lang.String str = this.mTitle;
        return (str == null || str.length() == 0) ? false : true;
    }

    public com.up366.qmui.widget.dialog.QMUIDialog show() {
        com.up366.qmui.widget.dialog.QMUIDialog qMUIDialogCreate = create();
        qMUIDialogCreate.show();
        return qMUIDialogCreate;
    }

    public com.up366.qmui.widget.dialog.QMUIDialog create() {
        int themeForBuilder;
        com.up366.qmui.widget.dialog.QMUIDialogBuilder.OnProvideDefaultTheme onProvideDefaultTheme = sOnProvideDefaultTheme;
        if (onProvideDefaultTheme != null && (themeForBuilder = onProvideDefaultTheme.getThemeForBuilder(this)) > 0) {
            return create(themeForBuilder);
        }
        return create(com.qmuiteam.qmui.R.style.QMUI_Dialog);
    }

    public com.up366.qmui.widget.dialog.QMUIDialog create(int i) {
        com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog = new com.up366.qmui.widget.dialog.QMUIDialog(this.mContext, i);
        this.mDialog = qMUIDialog;
        android.content.Context context = qMUIDialog.getContext();
        this.mDialogView = onCreateDialogView(context);
        com.up366.qmui.widget.dialog.QMUIDialogRootLayout qMUIDialogRootLayout = new com.up366.qmui.widget.dialog.QMUIDialogRootLayout(context, this.mDialogView, onCreateDialogLayoutParams());
        this.mRootView = qMUIDialogRootLayout;
        qMUIDialogRootLayout.setCheckKeyboardOverlay(this.mCheckKeyboardOverlay);
        this.mRootView.setOverlayOccurInMeasureCallback(new com.up366.qmui.widget.dialog.QMUIDialogRootLayout.OverlayOccurInMeasureCallback() { // from class: com.up366.qmui.widget.dialog.QMUIDialogBuilder.1
            @Override // com.up366.qmui.widget.dialog.QMUIDialogRootLayout.OverlayOccurInMeasureCallback
            public void call() {
                com.up366.qmui.widget.dialog.QMUIDialogBuilder.this.onOverlayOccurredInMeasure();
            }
        });
        this.mRootView.setMaxPercent(this.mMaxPercent);
        configRootLayout(this.mRootView);
        com.up366.qmui.widget.dialog.QMUIDialogView dialogView = this.mRootView.getDialogView();
        this.mDialogView = dialogView;
        dialogView.setOnDecorationListener(this.mOnDecorationListener);
        android.view.View viewOnCreateTitle = onCreateTitle(this.mDialog, this.mDialogView, context);
        android.view.View viewOnCreateOperatorLayout = onCreateOperatorLayout(this.mDialog, this.mDialogView, context);
        android.view.View viewOnCreateContent = onCreateContent(this.mDialog, this.mDialogView, context);
        checkAndSetId(viewOnCreateTitle, com.qmuiteam.qmui.R.id.qmui_dialog_title_id);
        checkAndSetId(viewOnCreateOperatorLayout, com.qmuiteam.qmui.R.id.qmui_dialog_operator_layout_id);
        checkAndSetId(viewOnCreateContent, com.qmuiteam.qmui.R.id.qmui_dialog_content_id);
        if (viewOnCreateTitle != null) {
            android.view.ViewGroup.LayoutParams layoutParamsOnCreateTitleLayoutParams = onCreateTitleLayoutParams(context);
            if (viewOnCreateContent != null) {
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParamsOnCreateTitleLayoutParams).bottomToTop = viewOnCreateContent.getId();
            } else if (viewOnCreateOperatorLayout != null) {
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParamsOnCreateTitleLayoutParams).bottomToTop = viewOnCreateOperatorLayout.getId();
            } else {
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParamsOnCreateTitleLayoutParams).bottomToBottom = 0;
            }
            this.mDialogView.addView(viewOnCreateTitle, layoutParamsOnCreateTitleLayoutParams);
        }
        if (viewOnCreateContent != null) {
            android.view.ViewGroup.LayoutParams layoutParamsOnCreateContentLayoutParams = onCreateContentLayoutParams(context);
            if (viewOnCreateTitle != null) {
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParamsOnCreateContentLayoutParams).topToBottom = viewOnCreateTitle.getId();
            } else {
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParamsOnCreateContentLayoutParams).topToTop = 0;
            }
            if (viewOnCreateOperatorLayout != null) {
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParamsOnCreateContentLayoutParams).bottomToTop = viewOnCreateOperatorLayout.getId();
            } else {
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParamsOnCreateContentLayoutParams).bottomToBottom = 0;
            }
            this.mDialogView.addView(viewOnCreateContent, layoutParamsOnCreateContentLayoutParams);
        }
        if (viewOnCreateOperatorLayout != null) {
            android.view.ViewGroup.LayoutParams layoutParamsOnCreateOperatorLayoutLayoutParams = onCreateOperatorLayoutLayoutParams(context);
            if (viewOnCreateContent != null) {
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParamsOnCreateOperatorLayoutLayoutParams).topToBottom = viewOnCreateContent.getId();
            } else if (viewOnCreateTitle != null) {
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParamsOnCreateOperatorLayoutLayoutParams).topToBottom = viewOnCreateTitle.getId();
            } else {
                ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParamsOnCreateOperatorLayoutLayoutParams).topToTop = 0;
            }
            this.mDialogView.addView(viewOnCreateOperatorLayout, layoutParamsOnCreateOperatorLayoutLayoutParams);
        }
        this.mDialog.addContentView(this.mRootView, new android.view.ViewGroup.LayoutParams(-2, -2));
        this.mDialog.setCancelable(this.mCancelable);
        this.mDialog.setCanceledOnTouchOutside(this.mCanceledOnTouchOutside);
        this.mDialog.setSkinManager(this.mSkinManager);
        onAfterCreate(this.mDialog, this.mRootView, context);
        return this.mDialog;
    }

    private void checkAndSetId(android.view.View view, int i) {
        if (view == null || view.getId() != -1) {
            return;
        }
        view.setId(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void skinConfigDialogView(com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView) {
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.background(com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_bg);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) qMUIDialogView, qMUISkinValueBuilderAcquire);
        com.up366.qmui.skin.QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
    }

    protected void skinConfigTitleView(android.widget.TextView textView) {
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.textColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_title_text_color);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(textView, qMUISkinValueBuilderAcquire);
        com.up366.qmui.skin.QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
    }

    protected void skinConfigActionContainer(android.view.ViewGroup viewGroup) {
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.topSeparator(com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_action_container_separator_color);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(viewGroup, qMUISkinValueBuilderAcquire);
        com.up366.qmui.skin.QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
    }

    protected com.up366.qmui.widget.dialog.QMUIDialogView onCreateDialogView(android.content.Context context) {
        com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView = new com.up366.qmui.widget.dialog.QMUIDialogView(context);
        qMUIDialogView.setBackground(com.up366.qmui.util.QMUIResHelper.getAttrDrawable(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_bg));
        qMUIDialogView.setRadius(com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_dialog_radius));
        skinConfigDialogView(qMUIDialogView);
        return qMUIDialogView;
    }

    protected android.widget.FrameLayout.LayoutParams onCreateDialogLayoutParams() {
        return new android.widget.FrameLayout.LayoutParams(-2, -2);
    }

    protected android.view.View onCreateTitle(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView, android.content.Context context) {
        if (!hasTitle()) {
            return null;
        }
        androidx.appcompat.widget.AppCompatTextView qMUISpanTouchFixTextView = new com.up366.qmui.widget.textview.QMUISpanTouchFixTextView(context);
        qMUISpanTouchFixTextView.setId(com.qmuiteam.qmui.R.id.qmui_dialog_title_id);
        qMUISpanTouchFixTextView.setText(this.mTitle);
        com.up366.qmui.util.QMUIResHelper.assignTextViewWithAttr(qMUISpanTouchFixTextView, com.qmuiteam.qmui.R.attr.qmui_dialog_title_style);
        skinConfigTitleView(qMUISpanTouchFixTextView);
        return qMUISpanTouchFixTextView;
    }

    protected androidx.constraintlayout.widget.ConstraintLayout.LayoutParams onCreateTitleLayoutParams(android.content.Context context) {
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(0, -2);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.topToTop = 0;
        layoutParams.verticalChainStyle = 2;
        return layoutParams;
    }

    protected com.up366.qmui.widget.QMUIWrapContentScrollView wrapWithScroll(android.view.View view) {
        com.up366.qmui.widget.QMUIWrapContentScrollView qMUIWrapContentScrollView = new com.up366.qmui.widget.QMUIWrapContentScrollView(view.getContext());
        qMUIWrapContentScrollView.addView(view);
        qMUIWrapContentScrollView.setVerticalScrollBarEnabled(false);
        return qMUIWrapContentScrollView;
    }

    protected androidx.constraintlayout.widget.ConstraintLayout.LayoutParams onCreateContentLayoutParams(android.content.Context context) {
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(0, -2);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.constrainedHeight = true;
        return layoutParams;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected android.view.View onCreateOperatorLayout(com.up366.qmui.widget.dialog.QMUIDialog r17, com.up366.qmui.widget.dialog.QMUIDialogView r18, android.content.Context r19) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.qmui.widget.dialog.QMUIDialogBuilder.onCreateOperatorLayout(com.up366.qmui.widget.dialog.QMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogView, android.content.Context):android.view.View");
    }

    protected androidx.constraintlayout.widget.ConstraintLayout.LayoutParams onCreateOperatorLayoutLayoutParams(android.content.Context context) {
        androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(0, -2);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.verticalChainStyle = 2;
        return layoutParams;
    }

    private android.view.View createActionContainerSpace(android.content.Context context) {
        android.widget.Space space = new android.widget.Space(context);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        space.setLayoutParams(layoutParams);
        return space;
    }

    public java.util.List<com.up366.qmui.widget.dialog.QMUIDialogAction> getPositiveAction() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.up366.qmui.widget.dialog.QMUIDialogAction qMUIDialogAction : this.mActions) {
            if (qMUIDialogAction.getActionProp() == 0) {
                arrayList.add(qMUIDialogAction);
            }
        }
        return arrayList;
    }
}
