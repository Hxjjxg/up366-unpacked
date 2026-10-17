package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class FixedLinearGradientProgressBarDrawable extends android.graphics.drawable.ColorDrawable {
    private android.graphics.Rect bounds = new android.graphics.Rect();
    private final android.graphics.drawable.Drawable drawable0;
    private final android.graphics.drawable.Drawable drawable2;
    private int level;

    public FixedLinearGradientProgressBarDrawable(android.widget.ProgressBar progressBar) {
        android.graphics.drawable.LayerDrawable layerDrawable = (android.graphics.drawable.LayerDrawable) progressBar.getProgressDrawable();
        this.drawable0 = layerDrawable.getDrawable(0);
        this.drawable2 = layerDrawable.getDrawable(2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        this.level = i;
        return true;
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public void draw(android.graphics.Canvas canvas) {
        int iWidth = canvas.getClipBounds().width();
        int iHeight = canvas.getClipBounds().height();
        int i = (this.level * iWidth) / 10000;
        this.bounds.set(0, 0, iWidth, iHeight);
        this.drawable0.setBounds(this.bounds);
        this.bounds.set(0, 0, i, iHeight);
        this.drawable2.setBounds(this.bounds);
        this.drawable2.setLevel(10000);
        this.drawable0.draw(canvas);
        this.drawable2.draw(canvas);
    }
}
