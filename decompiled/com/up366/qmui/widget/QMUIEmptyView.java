package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIEmptyView extends androidx.constraintlayout.widget.ConstraintLayout {
    protected android.widget.Button mButton;
    private android.widget.TextView mDetailTextView;
    private com.up366.qmui.widget.QMUILoadingView mLoadingView;
    private android.widget.TextView mTitleTextView;

    public QMUIEmptyView(android.content.Context context) {
        this(context, null);
    }

    public QMUIEmptyView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIEmptyView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUIEmptyView);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUIEmptyView_qmui_show_loading, false);
        java.lang.String string = typedArrayObtainStyledAttributes.getString(com.qmuiteam.qmui.R.styleable.QMUIEmptyView_qmui_title_text);
        java.lang.String string2 = typedArrayObtainStyledAttributes.getString(com.qmuiteam.qmui.R.styleable.QMUIEmptyView_qmui_detail_text);
        java.lang.String string3 = typedArrayObtainStyledAttributes.getString(com.qmuiteam.qmui.R.styleable.QMUIEmptyView_qmui_btn_text);
        typedArrayObtainStyledAttributes.recycle();
        show(z, string, string2, string3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        android.view.LayoutInflater.from(getContext()).inflate(com.qmuiteam.qmui.R.layout.qmui_empty_view, (android.view.ViewGroup) this, true);
        this.mLoadingView = (com.up366.qmui.widget.QMUILoadingView) findViewById(com.qmuiteam.qmui.R.id.empty_view_loading);
        this.mTitleTextView = (android.widget.TextView) findViewById(com.qmuiteam.qmui.R.id.empty_view_title);
        this.mDetailTextView = (android.widget.TextView) findViewById(com.qmuiteam.qmui.R.id.empty_view_detail);
        this.mButton = (android.widget.Button) findViewById(com.qmuiteam.qmui.R.id.empty_view_button);
    }

    public void show(boolean z, java.lang.String str, java.lang.String str2, java.lang.String str3, android.view.View.OnClickListener onClickListener) {
        setLoadingShowing(z);
        setTitleText(str);
        setDetailText(str2);
        setButton(str3, onClickListener);
        show();
    }

    public void show(boolean z) {
        setLoadingShowing(z);
        setTitleText(null);
        setDetailText(null);
        setButton(null, null);
        show();
    }

    public void show(java.lang.String str, java.lang.String str2) {
        setLoadingShowing(false);
        setTitleText(str);
        setDetailText(str2);
        setButton(null, null);
        show();
    }

    public void show() {
        setVisibility(0);
    }

    public void hide() {
        setVisibility(8);
        setLoadingShowing(false);
        setTitleText(null);
        setDetailText(null);
        setButton(null, null);
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    public boolean isLoading() {
        return this.mLoadingView.getVisibility() == 0;
    }

    public void setLoadingShowing(boolean z) {
        this.mLoadingView.setVisibility(z ? 0 : 8);
    }

    public void setTitleText(java.lang.String str) {
        this.mTitleTextView.setText(str);
        this.mTitleTextView.setVisibility(str != null ? 0 : 8);
    }

    public void setDetailText(java.lang.String str) {
        this.mDetailTextView.setText(str);
        this.mDetailTextView.setVisibility(str != null ? 0 : 8);
    }

    @com.up366.qmui.skin.annotation.QMUISkinChangeNotAdapted
    public void setTitleColor(int i) {
        this.mTitleTextView.setTextColor(i);
    }

    @com.up366.qmui.skin.annotation.QMUISkinChangeNotAdapted
    public void setDetailColor(int i) {
        this.mDetailTextView.setTextColor(i);
    }

    public void setTitleSkinValue(com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilder) {
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mTitleTextView, qMUISkinValueBuilder);
    }

    public void setDetailSkinValue(com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilder) {
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mDetailTextView, qMUISkinValueBuilder);
    }

    public void setLoadingSkinValue(com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilder) {
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mLoadingView, qMUISkinValueBuilder);
    }

    public void setBtnSkinValue(com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilder) {
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mButton, qMUISkinValueBuilder);
    }

    public void setButton(java.lang.String str, android.view.View.OnClickListener onClickListener) {
        this.mButton.setText(str);
        this.mButton.setVisibility(str != null ? 0 : 8);
        this.mButton.setOnClickListener(onClickListener);
    }
}
