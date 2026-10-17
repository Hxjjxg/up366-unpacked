package com.up366.qmui.widget.pullLayout;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIPullRefreshView extends androidx.appcompat.widget.AppCompatImageView implements com.up366.qmui.widget.pullLayout.QMUIPullLayout.ActionPullWatcherView, com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider {
    static final int CIRCLE_DIAMETER = 40;
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final int MAX_ALPHA = 255;
    private static final float TRIM_OFFSET = 0.4f;
    private static final float TRIM_RATE = 0.85f;
    private static androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> sDefaultSkinAttrs;
    private int mCircleDiameter;
    private androidx.swiperefreshlayout.widget.CircularProgressDrawable mProgress;

    public void doRefresh() {
    }

    static {
        androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> simpleArrayMap = new androidx.collection.SimpleArrayMap<>(4);
        sDefaultSkinAttrs = simpleArrayMap;
        simpleArrayMap.put(com.up366.qmui.skin.QMUISkinValueBuilder.TINT_COLOR, java.lang.Integer.valueOf(com.qmuiteam.qmui.R.attr.qmui_skin_support_pull_refresh_view_color));
    }

    public QMUIPullRefreshView(android.content.Context context) {
        this(context, null);
    }

    public QMUIPullRefreshView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgress = new androidx.swiperefreshlayout.widget.CircularProgressDrawable(context);
        setColorSchemeColors(com.up366.qmui.util.QMUIResHelper.getAttrColor(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_pull_refresh_view_color));
        this.mProgress.setStyle(0);
        this.mProgress.setAlpha(MAX_ALPHA);
        this.mProgress.setArrowScale(0.8f);
        setImageDrawable(this.mProgress);
        this.mCircleDiameter = (int) (getResources().getDisplayMetrics().density * 40.0f);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = this.mCircleDiameter;
        setMeasuredDimension(i3, i3);
    }

    @Override // com.up366.qmui.widget.pullLayout.QMUIPullLayout.ActionPullWatcherView
    public void onActionTriggered() {
        this.mProgress.start();
    }

    @Override // com.up366.qmui.widget.pullLayout.QMUIPullLayout.ActionPullWatcherView
    public void onActionFinished() {
        this.mProgress.stop();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mProgress.stop();
    }

    @Override // com.up366.qmui.widget.pullLayout.QMUIPullLayout.ActionPullWatcherView
    public void onPull(com.up366.qmui.widget.pullLayout.QMUIPullLayout.PullAction pullAction, int i) {
        if (this.mProgress.isRunning()) {
            return;
        }
        int targetTriggerOffset = pullAction.getTargetTriggerOffset();
        float fMin = java.lang.Math.min(targetTriggerOffset, i) * TRIM_RATE;
        float f = targetTriggerOffset;
        float f2 = (i * TRIM_OFFSET) / f;
        this.mProgress.setArrowEnabled(true);
        this.mProgress.setStartEndTrim(0.0f, fMin / f);
        this.mProgress.setProgressRotation(f2);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
            } else {
                this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
            }
            setImageDrawable(null);
            this.mProgress.setStyle(i);
            setImageDrawable(this.mProgress);
        }
    }

    public void stop() {
        this.mProgress.stop();
    }

    public void setColorSchemeResources(int... iArr) {
        android.content.Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = androidx.core.content.ContextCompat.getColor(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        this.mProgress.setColorSchemeColors(iArr);
    }

    @Override // com.up366.qmui.skin.defaultAttr.IQMUISkinDefaultAttrProvider
    public androidx.collection.SimpleArrayMap<java.lang.String, java.lang.Integer> getDefaultSkinAttrs() {
        return sDefaultSkinAttrs;
    }
}
