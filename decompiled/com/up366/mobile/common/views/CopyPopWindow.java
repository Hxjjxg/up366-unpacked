package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CopyPopWindow {
    public static void longClickCopy(final android.widget.TextView textView) {
        textView.setOnLongClickListener(new android.view.View.OnLongClickListener() { // from class: com.up366.mobile.common.views.CopyPopWindow$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(android.view.View view) {
                return com.up366.mobile.common.views.CopyPopWindow.lambda$longClickCopy$0(textView, view);
            }
        });
    }

    static /* synthetic */ boolean lambda$longClickCopy$0(android.widget.TextView textView, android.view.View view) {
        new com.up366.mobile.common.views.CopyPopWindow().show(textView);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.view.View, com.up366.mobile.common.views.CopyPopWindow$ArrowTextView] */
    public void show(final android.widget.TextView... textViewArr) {
        final android.widget.TextView textView = textViewArr[0];
        ?? arrowTextView = new com.up366.mobile.common.views.CopyPopWindow.ArrowTextView(textView.getContext());
        arrowTextView.setText("复制");
        arrowTextView.setPadding(dp2px(textView.getContext(), 15.0f), dp2px(textView.getContext(), 10.0f), dp2px(textView.getContext(), 15.0f), dp2px(textView.getContext(), 20.0f));
        arrowTextView.setTextColor(-1);
        arrowTextView.measure(0, 0);
        final android.widget.PopupWindow popupWindow = new android.widget.PopupWindow((android.view.View) textView, arrowTextView.getMeasuredWidth(), arrowTextView.getMeasuredHeight(), true);
        popupWindow.setContentView(arrowTextView);
        if (arrowTextView.getLayoutParams() == null) {
            arrowTextView.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        }
        popupWindow.showAsDropDown(textView, arrowTextView.getMeasuredWidth(), (-textView.getHeight()) - arrowTextView.getMeasuredHeight());
        popupWindow.setClippingEnabled(false);
        final android.graphics.drawable.Drawable[] drawableArr = new android.graphics.drawable.Drawable[textViewArr.length];
        for (int i = 0; i < textViewArr.length; i++) {
            android.widget.TextView textView2 = textViewArr[i];
            drawableArr[i] = textView2.getBackground();
            textView2.setBackground(new android.graphics.drawable.ColorDrawable(1716483067));
        }
        popupWindow.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() { // from class: com.up366.mobile.common.views.CopyPopWindow$$ExternalSyntheticLambda1
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                com.up366.mobile.common.views.CopyPopWindow.lambda$show$1(textViewArr, drawableArr);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener((android.view.View) arrowTextView, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.CopyPopWindow$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.common.views.CopyPopWindow.lambda$show$2(popupWindow, textView, textViewArr, view);
            }
        });
    }

    static /* synthetic */ void lambda$show$1(android.widget.TextView[] textViewArr, android.graphics.drawable.Drawable[] drawableArr) {
        for (int i = 0; i < textViewArr.length; i++) {
            textViewArr[i].setBackground(drawableArr[i]);
        }
    }

    static /* synthetic */ void lambda$show$2(android.widget.PopupWindow popupWindow, android.widget.TextView textView, android.widget.TextView[] textViewArr, android.view.View view) {
        popupWindow.dismiss();
        android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) textView.getContext().getSystemService("clipboard");
        java.lang.String str = "";
        for (android.widget.TextView textView2 : textViewArr) {
            str = (str + ((java.lang.Object) textView2.getText())) + "\n\n";
        }
        android.content.ClipData clipDataNewPlainText = android.content.ClipData.newPlainText("text", str.trim());
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
    }

    class ArrowTextView extends androidx.appcompat.widget.AppCompatTextView {
        private android.graphics.Paint paint;
        private android.graphics.RectF rect;

        public ArrowTextView(android.content.Context context) {
            super(context);
            android.graphics.Paint paint = new android.graphics.Paint(1);
            this.paint = paint;
            paint.setColor(-13421773);
            this.rect = new android.graphics.RectF();
        }

        public ArrowTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public ArrowTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        protected void onDraw(android.graphics.Canvas canvas) {
            float fDp2px = com.up366.mobile.common.views.CopyPopWindow.this.dp2px(getContext(), 20.0f);
            this.rect.set(0.0f, 0.0f, getWidth(), getHeight() - (fDp2px / 2.0f));
            canvas.drawRoundRect(this.rect, com.up366.mobile.common.views.CopyPopWindow.this.dp2px(getContext(), 5.0f), com.up366.mobile.common.views.CopyPopWindow.this.dp2px(getContext(), 5.0f), this.paint);
            canvas.save();
            canvas.translate(this.rect.centerX(), this.rect.height() - fDp2px);
            canvas.rotate(45.0f, 0.0f, 0.0f);
            this.rect.set(0.0f, 0.0f, fDp2px, fDp2px);
            canvas.drawRect(this.rect, this.paint);
            canvas.restore();
            super.onDraw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dp2px(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
