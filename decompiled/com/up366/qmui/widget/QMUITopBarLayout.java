package com.up366.qmui.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUITopBarLayout extends com.up366.qmui.layout.QMUIFrameLayout implements com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider {
    private androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> mDefaultSkinAttrs;
    private com.up366.qmui.widget.QMUITopBar mTopBar;

    public QMUITopBarLayout(android.content.Context context) {
        this(context, null);
    }

    public QMUITopBarLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUITopBarStyle);
    }

    public QMUITopBarLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap = new androidx.collection.SimpleArrayMap<>(2);
        this.mDefaultSkinAttrs = simpleArrayMap;
        simpleArrayMap.put(com.up366.qmui.skin.QMUISkinValueBuilder.BOTTOM_SEPARATOR, java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_topbar_separator_color));
        this.mDefaultSkinAttrs.put("background", java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_topbar_bg));
        com.up366.qmui.widget.QMUITopBar qMUITopBar = new com.up366.qmui.widget.QMUITopBar(context, attributeSet, i);
        this.mTopBar = qMUITopBar;
        qMUITopBar.setBackground(null);
        this.mTopBar.updateBottomDivider(0, 0, 0, 0);
        addView(this.mTopBar, new android.widget.FrameLayout.LayoutParams(-1, this.mTopBar.getTopBarHeight()));
    }

    public com.up366.qmui.widget.QMUITopBar getTopBar() {
        return this.mTopBar;
    }

    public void setCenterView(android.view.View view) {
        this.mTopBar.setCenterView(view);
    }

    public com.up366.qmui.qqface.QMUIQQFaceView setTitle(int i) {
        return this.mTopBar.setTitle(i);
    }

    public com.up366.qmui.qqface.QMUIQQFaceView setTitle(java.lang.String str) {
        return this.mTopBar.setTitle(str);
    }

    public void showTitleView(boolean z) {
        this.mTopBar.showTitleView(z);
    }

    public com.up366.qmui.qqface.QMUIQQFaceView setSubTitle(int i) {
        return this.mTopBar.setSubTitle(i);
    }

    public com.up366.qmui.qqface.QMUIQQFaceView setSubTitle(java.lang.String str) {
        return this.mTopBar.setSubTitle(str);
    }

    public void setTitleGravity(int i) {
        this.mTopBar.setTitleGravity(i);
    }

    public void addLeftView(android.view.View view, int i) {
        this.mTopBar.addLeftView(view, i);
    }

    public void addLeftView(android.view.View view, int i, android.widget.RelativeLayout.LayoutParams layoutParams) {
        this.mTopBar.addLeftView(view, i, layoutParams);
    }

    public void addRightView(android.view.View view, int i) {
        this.mTopBar.addRightView(view, i);
    }

    public void addRightView(android.view.View view, int i, android.widget.RelativeLayout.LayoutParams layoutParams) {
        this.mTopBar.addRightView(view, i, layoutParams);
    }

    public com.up366.qmui.alpha.QMUIAlphaImageButton addRightImageButton(int i, int i2) {
        return this.mTopBar.addRightImageButton(i, i2);
    }

    public com.up366.qmui.alpha.QMUIAlphaImageButton addLeftImageButton(int i, int i2) {
        return this.mTopBar.addLeftImageButton(i, i2);
    }

    public android.widget.Button addLeftTextButton(int i, int i2) {
        return this.mTopBar.addLeftTextButton(i, i2);
    }

    public android.widget.Button addLeftTextButton(java.lang.String str, int i) {
        return this.mTopBar.addLeftTextButton(str, i);
    }

    public android.widget.Button addRightTextButton(int i, int i2) {
        return this.mTopBar.addRightTextButton(i, i2);
    }

    public android.widget.Button addRightTextButton(java.lang.String str, int i) {
        return this.mTopBar.addRightTextButton(str, i);
    }

    public com.up366.qmui.alpha.QMUIAlphaImageButton addLeftBackImageButton() {
        return this.mTopBar.addLeftBackImageButton();
    }

    public void removeAllLeftViews() {
        this.mTopBar.removeAllLeftViews();
    }

    public void removeAllRightViews() {
        this.mTopBar.removeAllRightViews();
    }

    public void removeCenterViewAndTitleView() {
        this.mTopBar.removeCenterViewAndTitleView();
    }

    public void setBackgroundAlpha(int i) {
        getBackground().mutate().setAlpha(i);
    }

    public int computeAndSetBackgroundAlpha(int i, int i2, int i3) {
        int iMax = (int) (java.lang.Math.max(0.0d, java.lang.Math.min((i - i2) / (i3 - i2), 1.0d)) * 255.0d);
        setBackgroundAlpha(iMax);
        return iMax;
    }

    public void setDefaultSkinAttr(java.lang.String str, int i) {
        this.mDefaultSkinAttrs.put(str, java.lang.Integer.valueOf(i));
    }

    @Override // com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> getDefaultSkinAttrs() {
        return this.mDefaultSkinAttrs;
    }
}
