package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIDialogView extends com.up366.qmui.layout.QMUIConstraintLayout {
    private com.up366.qmui.widget.dialog.QMUIDialogView.OnDecorationListener mOnDecorationListener;

    public interface OnDecorationListener {
        void onDraw(android.graphics.Canvas canvas, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView);

        void onDrawOver(android.graphics.Canvas canvas, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView);
    }

    public QMUIDialogView(android.content.Context context) {
        this(context, null);
    }

    public QMUIDialogView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIDialogView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnDecorationListener(com.up366.qmui.widget.dialog.QMUIDialogView.OnDecorationListener onDecorationListener) {
        this.mOnDecorationListener = onDecorationListener;
    }

    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        com.up366.qmui.widget.dialog.QMUIDialogView.OnDecorationListener onDecorationListener = this.mOnDecorationListener;
        if (onDecorationListener != null) {
            onDecorationListener.onDraw(canvas, this);
        }
    }

    @Override // com.up366.qmui.layout.QMUIConstraintLayout
    public void dispatchDraw(android.graphics.Canvas canvas) {
        super.dispatchDraw(canvas);
        com.up366.qmui.widget.dialog.QMUIDialogView.OnDecorationListener onDecorationListener = this.mOnDecorationListener;
        if (onDecorationListener != null) {
            onDecorationListener.onDrawOver(canvas, this);
        }
    }
}
