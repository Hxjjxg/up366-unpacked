package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUITipDialog extends com.up366.qmui.widget.dialog.QMUIBaseDialog {
    public QMUITipDialog(android.content.Context context) {
        this(context, com.qmuiteam.qmui.R.style.QMUI_TipDialog);
    }

    public QMUITipDialog(android.content.Context context, int i) {
        super(context, i);
        setCanceledOnTouchOutside(false);
    }

    public static class Builder {
        public static final int ICON_TYPE_FAIL = 3;
        public static final int ICON_TYPE_INFO = 4;
        public static final int ICON_TYPE_LOADING = 1;
        public static final int ICON_TYPE_NOTHING = 0;
        public static final int ICON_TYPE_SUCCESS = 2;
        private android.content.Context mContext;
        private int mCurrentIconType = 0;
        private com.up366.qmui.skin.QMUISkinManager mSkinManager;
        private java.lang.CharSequence mTipWord;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface IconType {
        }

        public Builder(android.content.Context context) {
            this.mContext = context;
        }

        public com.up366.qmui.widget.dialog.QMUITipDialog.Builder setIconType(int i) {
            this.mCurrentIconType = i;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUITipDialog.Builder setTipWord(java.lang.CharSequence charSequence) {
            this.mTipWord = charSequence;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUITipDialog.Builder setSkinManager(com.up366.qmui.skin.QMUISkinManager qMUISkinManager) {
            this.mSkinManager = qMUISkinManager;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUITipDialog create() {
            return create(true);
        }

        public com.up366.qmui.widget.dialog.QMUITipDialog create(boolean z) {
            return create(z, com.qmuiteam.qmui.R.style.QMUI_TipDialog);
        }

        public com.up366.qmui.widget.dialog.QMUITipDialog create(boolean z, int i) {
            android.graphics.drawable.Drawable attrDrawable;
            com.up366.qmui.widget.dialog.QMUITipDialog qMUITipDialog = new com.up366.qmui.widget.dialog.QMUITipDialog(this.mContext, i);
            qMUITipDialog.setCancelable(z);
            qMUITipDialog.setSkinManager(this.mSkinManager);
            android.content.Context context = qMUITipDialog.getContext();
            com.up366.qmui.widget.dialog.QMUITipDialogView qMUITipDialogView = new com.up366.qmui.widget.dialog.QMUITipDialogView(context);
            com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
            int i2 = this.mCurrentIconType;
            if (i2 == 1) {
                com.up366.qmui.widget.QMUILoadingView qMUILoadingView = new com.up366.qmui.widget.QMUILoadingView(context);
                qMUILoadingView.setColor(com.up366.qmui.util.QMUIResHelper.getAttrColor(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_tip_dialog_loading_color));
                qMUILoadingView.setSize(com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_tip_dialog_loading_size));
                qMUISkinValueBuilderAcquire.tintColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_tip_dialog_loading_color);
                com.up366.qmui.skin.QMUISkinHelper.setSkinValue(qMUILoadingView, qMUISkinValueBuilderAcquire);
                qMUITipDialogView.addView(qMUILoadingView, onCreateIconOrLoadingLayoutParams(context));
            } else if (i2 == 2 || i2 == 3 || i2 == 4) {
                androidx.appcompat.widget.AppCompatImageView appCompatImageView = new androidx.appcompat.widget.AppCompatImageView(this.mContext);
                qMUISkinValueBuilderAcquire.clear();
                int i3 = this.mCurrentIconType;
                if (i3 == 2) {
                    attrDrawable = com.up366.qmui.util.QMUIResHelper.getAttrDrawable(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_tip_dialog_icon_success_src);
                    qMUISkinValueBuilderAcquire.src(com.qmuiteam.qmui.R.attr.qmui_skin_support_tip_dialog_icon_success_src);
                } else if (i3 == 3) {
                    attrDrawable = com.up366.qmui.util.QMUIResHelper.getAttrDrawable(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_tip_dialog_icon_error_src);
                    qMUISkinValueBuilderAcquire.src(com.qmuiteam.qmui.R.attr.qmui_skin_support_tip_dialog_icon_error_src);
                } else {
                    attrDrawable = com.up366.qmui.util.QMUIResHelper.getAttrDrawable(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_tip_dialog_icon_info_src);
                    qMUISkinValueBuilderAcquire.src(com.qmuiteam.qmui.R.attr.qmui_skin_support_tip_dialog_icon_info_src);
                }
                appCompatImageView.setImageDrawable(attrDrawable);
                com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) appCompatImageView, qMUISkinValueBuilderAcquire);
                qMUITipDialogView.addView((android.view.View) appCompatImageView, onCreateIconOrLoadingLayoutParams(context));
            }
            java.lang.CharSequence charSequence = this.mTipWord;
            if (charSequence != null && charSequence.length() > 0) {
                androidx.appcompat.widget.AppCompatTextView qMUISpanTouchFixTextView = new com.up366.qmui.widget.textview.QMUISpanTouchFixTextView(this.mContext);
                qMUISpanTouchFixTextView.setEllipsize(android.text.TextUtils.TruncateAt.END);
                qMUISpanTouchFixTextView.setGravity(17);
                qMUISpanTouchFixTextView.setTextSize(0, com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_tip_dialog_text_size));
                qMUISpanTouchFixTextView.setTextColor(com.up366.qmui.util.QMUIResHelper.getAttrColor(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_tip_dialog_text_color));
                qMUISpanTouchFixTextView.setText(this.mTipWord);
                qMUISkinValueBuilderAcquire.clear();
                qMUISkinValueBuilderAcquire.textColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_tip_dialog_text_color);
                com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) qMUISpanTouchFixTextView, qMUISkinValueBuilderAcquire);
                qMUITipDialogView.addView((android.view.View) qMUISpanTouchFixTextView, onCreateTextLayoutParams(context, this.mCurrentIconType));
            }
            qMUISkinValueBuilderAcquire.release();
            qMUITipDialog.setContentView(qMUITipDialogView);
            return qMUITipDialog;
        }

        protected android.widget.LinearLayout.LayoutParams onCreateIconOrLoadingLayoutParams(android.content.Context context) {
            return new android.widget.LinearLayout.LayoutParams(-2, -2);
        }

        protected android.widget.LinearLayout.LayoutParams onCreateTextLayoutParams(android.content.Context context, int i) {
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
            if (i != 0) {
                layoutParams.topMargin = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_tip_dialog_text_margin_top);
            }
            return layoutParams;
        }
    }

    public static class CustomBuilder {
        private int mContentLayoutId;
        private android.content.Context mContext;
        private com.up366.qmui.skin.QMUISkinManager mSkinManager;

        public CustomBuilder(android.content.Context context) {
            this.mContext = context;
        }

        public com.up366.qmui.widget.dialog.QMUITipDialog.CustomBuilder setSkinManager(com.up366.qmui.skin.QMUISkinManager qMUISkinManager) {
            this.mSkinManager = qMUISkinManager;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUITipDialog.CustomBuilder setContent(int i) {
            this.mContentLayoutId = i;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUITipDialog create() {
            com.up366.qmui.widget.dialog.QMUITipDialog qMUITipDialog = new com.up366.qmui.widget.dialog.QMUITipDialog(this.mContext);
            qMUITipDialog.setSkinManager(this.mSkinManager);
            android.content.Context context = qMUITipDialog.getContext();
            com.up366.qmui.widget.dialog.QMUITipDialogView qMUITipDialogView = new com.up366.qmui.widget.dialog.QMUITipDialogView(context);
            android.view.LayoutInflater.from(context).inflate(this.mContentLayoutId, (android.view.ViewGroup) qMUITipDialogView, true);
            qMUITipDialog.setContentView(qMUITipDialogView);
            return qMUITipDialog;
        }
    }
}
