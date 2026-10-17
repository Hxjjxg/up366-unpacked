package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIDialogMenuItemView extends com.up366.qmui.layout.QMUIConstraintLayout {
    private int index;
    private boolean mIsChecked;
    private com.up366.qmui.widget.dialog.QMUIDialogMenuItemView.MenuItemViewListener mListener;

    public interface MenuItemViewListener {
        void onClick(int i);
    }

    protected void notifyCheckChange(boolean z) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QMUIDialogMenuItemView(android.content.Context context) {
        super(context, null, com.qmuiteam.qmui.R.attr.qmui_dialog_menu_item_style);
        this.index = -1;
        this.mIsChecked = false;
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.background(com.qmuiteam.qmui.R.attr.qmui_skin_support_s_dialog_menu_item_bg);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this, qMUISkinValueBuilderAcquire);
        com.up366.qmui.skin.QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
    }

    public static android.widget.TextView createItemTextView(android.content.Context context) {
        androidx.appcompat.widget.AppCompatTextView qMUISpanTouchFixTextView = new com.up366.qmui.widget.textview.QMUISpanTouchFixTextView(context);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, com.qmuiteam.qmui.R.styleable.QMUIDialogMenuTextStyleDef, com.qmuiteam.qmui.R.attr.qmui_dialog_menu_item_style, 0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMenuTextStyleDef_android_gravity) {
                qMUISpanTouchFixTextView.setGravity(typedArrayObtainStyledAttributes.getInt(index, -1));
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMenuTextStyleDef_android_textColor) {
                qMUISpanTouchFixTextView.setTextColor(typedArrayObtainStyledAttributes.getColorStateList(index));
            } else if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMenuTextStyleDef_android_textSize) {
                qMUISpanTouchFixTextView.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        qMUISpanTouchFixTextView.setId(android.view.View.generateViewId());
        qMUISpanTouchFixTextView.setSingleLine(true);
        qMUISpanTouchFixTextView.setEllipsize(android.text.TextUtils.TruncateAt.MIDDLE);
        qMUISpanTouchFixTextView.setDuplicateParentStateEnabled(false);
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.textColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_menu_item_text_color);
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) qMUISpanTouchFixTextView, qMUISkinValueBuilderAcquire);
        com.up366.qmui.skin.QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
        return qMUISpanTouchFixTextView;
    }

    public int getMenuIndex() {
        return this.index;
    }

    public void setMenuIndex(int i) {
        this.index = i;
    }

    public boolean isChecked() {
        return this.mIsChecked;
    }

    public void setChecked(boolean z) {
        this.mIsChecked = z;
        notifyCheckChange(z);
    }

    public void setListener(com.up366.qmui.widget.dialog.QMUIDialogMenuItemView.MenuItemViewListener menuItemViewListener) {
        if (!isClickable()) {
            setClickable(true);
        }
        this.mListener = menuItemViewListener;
    }

    public boolean performClick() {
        com.up366.qmui.widget.dialog.QMUIDialogMenuItemView.MenuItemViewListener menuItemViewListener = this.mListener;
        if (menuItemViewListener != null) {
            menuItemViewListener.onClick(this.index);
        }
        return super.performClick();
    }

    public static class TextItemView extends com.up366.qmui.widget.dialog.QMUIDialogMenuItemView {
        protected android.widget.TextView mTextView;

        public TextItemView(android.content.Context context) {
            super(context);
            init();
        }

        public TextItemView(android.content.Context context, java.lang.CharSequence charSequence) {
            super(context);
            init();
            setText(charSequence);
        }

        private void init() {
            this.mTextView = createItemTextView(getContext());
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(0, 0);
            layoutParams.leftToLeft = 0;
            layoutParams.rightToRight = 0;
            layoutParams.bottomToBottom = 0;
            layoutParams.topToTop = 0;
            addView(this.mTextView, layoutParams);
        }

        public void setText(java.lang.CharSequence charSequence) {
            this.mTextView.setText(charSequence);
        }

        @java.lang.Deprecated
        public void setTextColor(int i) {
            this.mTextView.setTextColor(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void setTextColorAttr(int i) {
            this.mTextView.setTextColor(com.up366.qmui.skin.QMUISkinHelper.getSkinColor(this, i));
            com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
            qMUISkinValueBuilderAcquire.textColor(i);
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mTextView, qMUISkinValueBuilderAcquire);
            com.up366.qmui.skin.QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
        }
    }

    public static class MarkItemView extends com.up366.qmui.widget.dialog.QMUIDialogMenuItemView {
        private androidx.appcompat.widget.AppCompatImageView mCheckedView;
        private android.content.Context mContext;
        private android.widget.TextView mTextView;

        public MarkItemView(android.content.Context context) {
            super(context);
            this.mContext = context;
            androidx.appcompat.widget.AppCompatImageView appCompatImageView = new androidx.appcompat.widget.AppCompatImageView(this.mContext);
            this.mCheckedView = appCompatImageView;
            appCompatImageView.setId(android.view.View.generateViewId());
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, com.qmuiteam.qmui.R.styleable.QMUIDialogMenuMarkDef, com.qmuiteam.qmui.R.attr.qmui_dialog_menu_item_style, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            int dimensionPixelSize = 0;
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMenuMarkDef_qmui_dialog_menu_item_check_mark_margin_hor) {
                    dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMenuMarkDef_qmui_dialog_menu_item_mark_drawable) {
                    this.mCheckedView.setImageDrawable(com.up366.qmui.util.QMUIResHelper.getAttrDrawable(context, typedArrayObtainStyledAttributes, index));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
            qMUISkinValueBuilderAcquire.src(com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_mark_drawable);
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mCheckedView, qMUISkinValueBuilderAcquire);
            com.up366.qmui.skin.QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.rightToRight = 0;
            layoutParams.topToTop = 0;
            layoutParams.bottomToBottom = 0;
            addView(this.mCheckedView, layoutParams);
            this.mTextView = createItemTextView(this.mContext);
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(0, 0);
            layoutParams2.leftToLeft = 0;
            layoutParams2.topToTop = 0;
            layoutParams2.bottomToBottom = 0;
            layoutParams2.rightToLeft = this.mCheckedView.getId();
            layoutParams2.rightMargin = dimensionPixelSize;
            addView(this.mTextView, layoutParams2);
            this.mCheckedView.setVisibility(4);
        }

        public MarkItemView(android.content.Context context, java.lang.CharSequence charSequence) {
            this(context);
            setText(charSequence);
        }

        public void setText(java.lang.CharSequence charSequence) {
            this.mTextView.setText(charSequence);
        }

        @Override // com.up366.qmui.widget.dialog.QMUIDialogMenuItemView
        protected void notifyCheckChange(boolean z) {
            this.mCheckedView.setVisibility(z ? 0 : 4);
        }
    }

    public static class CheckItemView extends com.up366.qmui.widget.dialog.QMUIDialogMenuItemView {
        private androidx.appcompat.widget.AppCompatImageView mCheckedView;
        private android.content.Context mContext;
        private android.widget.TextView mTextView;

        public CheckItemView(android.content.Context context, boolean z) {
            super(context);
            this.mContext = context;
            androidx.appcompat.widget.AppCompatImageView appCompatImageView = new androidx.appcompat.widget.AppCompatImageView(this.mContext);
            this.mCheckedView = appCompatImageView;
            appCompatImageView.setId(android.view.View.generateViewId());
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, com.qmuiteam.qmui.R.styleable.QMUIDialogMenuCheckDef, com.qmuiteam.qmui.R.attr.qmui_dialog_menu_item_style, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            int dimensionPixelSize = 0;
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMenuCheckDef_qmui_dialog_menu_item_check_mark_margin_hor) {
                    dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMenuCheckDef_qmui_dialog_menu_item_check_drawable) {
                    this.mCheckedView.setImageDrawable(com.up366.qmui.util.QMUIResHelper.getAttrDrawable(context, typedArrayObtainStyledAttributes, index));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.topToTop = 0;
            layoutParams.bottomToBottom = 0;
            if (z) {
                layoutParams.rightToRight = 0;
            } else {
                layoutParams.leftToLeft = 0;
            }
            com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
            qMUISkinValueBuilderAcquire.src(com.qmuiteam.qmui.R.attr.qmui_skin_support_s_dialog_check_drawable);
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mCheckedView, qMUISkinValueBuilderAcquire);
            com.up366.qmui.skin.QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
            addView(this.mCheckedView, layoutParams);
            this.mTextView = createItemTextView(this.mContext);
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(0, 0);
            if (z) {
                layoutParams2.leftToLeft = 0;
                layoutParams2.rightToLeft = this.mCheckedView.getId();
                layoutParams2.rightMargin = dimensionPixelSize;
            } else {
                layoutParams2.rightToRight = 0;
                layoutParams2.leftToRight = this.mCheckedView.getId();
                layoutParams2.leftMargin = dimensionPixelSize;
            }
            layoutParams2.topToTop = 0;
            layoutParams2.bottomToBottom = 0;
            addView(this.mTextView, layoutParams2);
        }

        public CheckItemView(android.content.Context context, boolean z, java.lang.CharSequence charSequence) {
            this(context, z);
            setText(charSequence);
        }

        public void setText(java.lang.CharSequence charSequence) {
            this.mTextView.setText(charSequence);
        }

        public java.lang.CharSequence getText() {
            return this.mTextView.getText();
        }

        @Override // com.up366.qmui.widget.dialog.QMUIDialogMenuItemView
        protected void notifyCheckChange(boolean z) {
            com.up366.qmui.util.QMUIViewHelper.safeSetImageViewSelected(this.mCheckedView, z);
        }
    }
}
