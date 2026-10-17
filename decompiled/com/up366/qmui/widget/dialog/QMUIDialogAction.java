package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIDialogAction {
    public static final int ACTION_PROP_NEGATIVE = 2;
    public static final int ACTION_PROP_NEUTRAL = 1;
    public static final int ACTION_PROP_POSITIVE = 0;
    private int mActionProp;
    private com.up366.qmui.layout.QMUIButton mButton;
    private int mIconRes;
    private boolean mIsEnabled;
    private com.up366.qmui.widget.dialog.QMUIDialogAction.ActionListener mOnClickListener;
    private int mSkinBackgroundAttr;
    private int mSkinIconTintColorAttr;
    private int mSkinSeparatorColorAttr;
    private int mSkinTextColorAttr;
    private java.lang.CharSequence mStr;

    public interface ActionListener {
        void onClick(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, int i);
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Prop {
    }

    public QMUIDialogAction(android.content.Context context, int i) {
        this(context.getResources().getString(i));
    }

    public QMUIDialogAction(java.lang.CharSequence charSequence) {
        this(charSequence, (com.up366.qmui.widget.dialog.QMUIDialogAction.ActionListener) null);
    }

    public QMUIDialogAction(android.content.Context context, int i, com.up366.qmui.widget.dialog.QMUIDialogAction.ActionListener actionListener) {
        this(context.getResources().getString(i), actionListener);
    }

    public QMUIDialogAction(java.lang.CharSequence charSequence, com.up366.qmui.widget.dialog.QMUIDialogAction.ActionListener actionListener) {
        this.mIconRes = 0;
        this.mActionProp = 1;
        this.mSkinTextColorAttr = 0;
        this.mSkinBackgroundAttr = 0;
        this.mSkinIconTintColorAttr = 0;
        this.mSkinSeparatorColorAttr = com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_action_divider_color;
        this.mIsEnabled = true;
        this.mStr = charSequence;
        this.mOnClickListener = actionListener;
    }

    public com.up366.qmui.widget.dialog.QMUIDialogAction prop(int i) {
        this.mActionProp = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIDialogAction iconRes(int i) {
        this.mIconRes = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIDialogAction onClick(com.up366.qmui.widget.dialog.QMUIDialogAction.ActionListener actionListener) {
        this.mOnClickListener = actionListener;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIDialogAction skinTextColorAttr(int i) {
        this.mSkinTextColorAttr = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIDialogAction skinBackgroundAttr(int i) {
        this.mSkinBackgroundAttr = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIDialogAction skinIconTintColorAttr(int i) {
        this.mSkinIconTintColorAttr = i;
        return this;
    }

    com.up366.qmui.widget.dialog.QMUIDialogAction skinSeparatorColorAttr(int i) {
        this.mSkinSeparatorColorAttr = i;
        return this;
    }

    public com.up366.qmui.widget.dialog.QMUIDialogAction setEnabled(boolean z) {
        this.mIsEnabled = z;
        com.up366.qmui.layout.QMUIButton qMUIButton = this.mButton;
        if (qMUIButton != null) {
            qMUIButton.setEnabled(z);
        }
        return this;
    }

    public com.up366.qmui.layout.QMUIButton buildActionView(final com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, final int i) {
        com.up366.qmui.layout.QMUIButton qMUIButtonGenerateActionButton = generateActionButton(qMUIDialog.getContext(), this.mStr, this.mIconRes, this.mSkinBackgroundAttr, this.mSkinTextColorAttr, this.mSkinIconTintColorAttr);
        this.mButton = qMUIButtonGenerateActionButton;
        qMUIButtonGenerateActionButton.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.qmui.widget.dialog.QMUIDialogAction.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.up366.qmui.widget.dialog.QMUIDialogAction.this.mOnClickListener == null || !com.up366.qmui.widget.dialog.QMUIDialogAction.this.mButton.isEnabled()) {
                    return;
                }
                com.up366.qmui.widget.dialog.QMUIDialogAction.this.mOnClickListener.onClick(qMUIDialog, i);
            }
        });
        return this.mButton;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ef  */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.view.View, com.up366.qmui.layout.QMUIButton] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.up366.qmui.layout.QMUIButton generateActionButton(android.content.Context r17, java.lang.CharSequence r18, int r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.qmui.widget.dialog.QMUIDialogAction.generateActionButton(android.content.Context, java.lang.CharSequence, int, int, int, int):com.up366.qmui.layout.QMUIButton");
    }

    public int getActionProp() {
        return this.mActionProp;
    }
}
