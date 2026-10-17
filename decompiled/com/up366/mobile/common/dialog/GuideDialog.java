package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GuideDialog {
    android.app.Dialog dialog;
    private boolean hasShow;
    private final int type;

    GuideDialog(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialog(android.app.Dialog dialog) {
        this.dialog = dialog;
    }

    public synchronized void show() {
        if (!this.hasShow) {
            this.hasShow = true;
            this.dialog.show();
        }
    }

    public static class Builder {
        private android.content.DialogInterface.OnDismissListener dismissListener;
        private android.view.View[] focusViews;
        private int layoutId;
        private int type;
        private int focusId = com.up366.mobile.R.id.focus;
        private boolean hasLine = false;
        private boolean isBottom = false;
        private boolean drawRect = true;
        private android.util.SparseArray<android.view.View.OnClickListener> clickMap = new android.util.SparseArray<>();

        public com.up366.mobile.common.dialog.GuideDialog.Builder setType(int i) {
            this.type = i;
            return this;
        }

        public com.up366.mobile.common.dialog.GuideDialog.Builder setLayoutId(int i) {
            this.layoutId = i;
            return this;
        }

        public com.up366.mobile.common.dialog.GuideDialog.Builder setFocusId(int i) {
            this.focusId = i;
            return this;
        }

        public com.up366.mobile.common.dialog.GuideDialog.Builder setHasLine(boolean z) {
            this.hasLine = z;
            return this;
        }

        public com.up366.mobile.common.dialog.GuideDialog.Builder setBottom(boolean z) {
            this.isBottom = z;
            return this;
        }

        public com.up366.mobile.common.dialog.GuideDialog.Builder setDrawRect(boolean z) {
            this.drawRect = z;
            return this;
        }

        public com.up366.mobile.common.dialog.GuideDialog.Builder setFocusViews(android.view.View[] viewArr) {
            this.focusViews = viewArr;
            return this;
        }

        public com.up366.mobile.common.dialog.GuideDialog.Builder setClick(int i, android.view.View.OnClickListener onClickListener) {
            this.clickMap.put(i, onClickListener);
            return this;
        }

        public com.up366.mobile.common.dialog.GuideDialog.Builder setOnDismissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
            this.dismissListener = onDismissListener;
            return this;
        }

        public com.up366.mobile.common.dialog.GuideDialog build() {
            android.view.View view = this.focusViews[0];
            final android.app.Dialog dialog = new android.app.Dialog(view.getContext(), com.up366.mobile.R.style.GuideDialog);
            dialog.setContentView(this.layoutId);
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setOnDismissListener(this.dismissListener);
            for (final int i = 0; i < this.clickMap.size(); i++) {
                dialog.findViewById(this.clickMap.keyAt(i)).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.GuideDialog$Builder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view2) {
                        this.f$0.lambda$build$0(dialog, i, view2);
                    }
                });
            }
            android.content.Context context = view.getContext();
            com.up366.mobile.common.dialog.GuideDialog.DarkLayerDrawable darkLayerDrawable = new com.up366.mobile.common.dialog.GuideDialog.DarkLayerDrawable(dp2px(context, 2.0f), -dp2px(context, 10.0f), -dp2px(context, 10.0f), dp2px(context, 9.0f), dp2px(context, 6.0f), this.hasLine, this.isBottom, this.drawRect, this.focusViews);
            dialog.getWindow().getDecorView().setBackgroundDrawable(darkLayerDrawable);
            android.view.View viewFindViewById = dialog.findViewById(this.focusId);
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            layoutParams.leftMargin = darkLayerDrawable.left;
            layoutParams.topMargin = darkLayerDrawable.top;
            viewFindViewById.getParent().setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.GuideDialog$Builder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view2) {
                    dialog.dismiss();
                }
            });
            com.up366.mobile.common.dialog.GuideDialog guideDialog = new com.up366.mobile.common.dialog.GuideDialog(this.type);
            guideDialog.setDialog(dialog);
            return guideDialog;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$build$0(android.app.Dialog dialog, int i, android.view.View view) {
            dialog.dismiss();
            this.clickMap.valueAt(i).onClick(view);
        }

        public int dp2px(android.content.Context context, float f) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
    }

    static class DarkLayerDrawable extends android.graphics.drawable.Drawable {
        private static final java.lang.String TAG = "DarkLayerDrawable";
        private float dashGap;
        private boolean drawRect;
        private boolean hasLine;
        public int left;
        private android.graphics.Paint paint = new android.graphics.Paint(1);
        private android.graphics.Paint paintDarkBg = new android.graphics.Paint(1);
        private android.graphics.Paint paintDash = new android.graphics.Paint(1);
        private float radius;
        private android.graphics.RectF rect;
        private android.graphics.RectF rectDash;
        public int top;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(android.graphics.ColorFilter colorFilter) {
        }

        public DarkLayerDrawable(float f, float f2, float f3, float f4, float f5, boolean z, boolean z2, boolean z3, android.view.View[] viewArr) {
            this.radius = f4;
            this.dashGap = f5;
            this.hasLine = z;
            this.drawRect = z3;
            this.paint.setColor(1727987712);
            this.paintDarkBg.setColor(1711276032);
            this.paintDash.setColor(-1);
            this.paintDash.setStrokeWidth(f);
            this.paintDash.setStyle(android.graphics.Paint.Style.STROKE);
            for (android.view.View view : viewArr) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int width = view.getWidth();
                int height = view.getHeight();
                android.graphics.RectF rectF = this.rect;
                if (rectF == null) {
                    this.rect = new android.graphics.RectF(iArr[0], iArr[1], r3 + width, r14 + height);
                } else {
                    rectF.union(iArr[0], iArr[1], r3 + width, r14 + height);
                }
            }
            this.rect.inset(f2, f2);
            android.graphics.RectF rectF2 = new android.graphics.RectF(this.rect);
            this.rectDash = rectF2;
            rectF2.inset(f3, f3);
            this.left = (int) this.rect.centerX();
            android.graphics.RectF rectF3 = this.rect;
            this.top = (int) (z2 ? rectF3.bottom : rectF3.top);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(android.graphics.Canvas canvas) {
            canvas.drawColor(-1442840576);
            this.paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
            if (this.drawRect) {
                android.graphics.RectF rectF = this.rect;
                float f = this.radius;
                canvas.drawRoundRect(rectF, f, f, this.paint);
            }
            this.paint.setXfermode(null);
            if (this.hasLine) {
                android.graphics.Path path = new android.graphics.Path();
                android.graphics.RectF rectF2 = this.rectDash;
                float f2 = this.radius;
                path.addRoundRect(rectF2, f2, f2, android.graphics.Path.Direction.CW);
                android.graphics.Paint paint = this.paintDash;
                float f3 = this.dashGap;
                paint.setPathEffect(new android.graphics.DashPathEffect(new float[]{f3, f3}, 4.0f));
                canvas.drawPath(path, this.paintDash);
            }
        }
    }
}
