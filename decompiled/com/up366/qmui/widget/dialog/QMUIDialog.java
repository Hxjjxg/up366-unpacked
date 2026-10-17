package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIDialog extends com.up366.qmui.widget.dialog.QMUIBaseDialog {
    private android.content.Context mBaseContext;

    public QMUIDialog(android.content.Context context) {
        this(context, com.qmuiteam.qmui.R.style.QMUI_Dialog);
    }

    public QMUIDialog(android.content.Context context, int i) {
        super(context, i);
        this.mBaseContext = context;
        init();
    }

    private void init() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }

    public void showWithImmersiveCheck(android.app.Activity activity) {
        android.view.Window window = getWindow();
        if (window == null) {
            return;
        }
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        if ((systemUiVisibility & 1024) == 1024 || (systemUiVisibility & 4) == 4) {
            window.setFlags(8, 8);
            window.getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility());
            super.show();
            window.clearFlags(8);
            return;
        }
        super.show();
    }

    public void showWithImmersiveCheck() {
        android.content.Context context = this.mBaseContext;
        if (!(context instanceof android.app.Activity)) {
            super.show();
        } else {
            showWithImmersiveCheck((android.app.Activity) context);
        }
    }

    public static class MessageDialogBuilder extends com.up366.qmui.widget.dialog.QMUIDialogBuilder<com.up366.qmui.widget.dialog.QMUIDialog.MessageDialogBuilder> {
        protected java.lang.CharSequence mMessage;

        public MessageDialogBuilder(android.content.Context context) {
            super(context);
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.MessageDialogBuilder setMessage(java.lang.CharSequence charSequence) {
            this.mMessage = charSequence;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.MessageDialogBuilder setMessage(int i) {
            return setMessage(getBaseContext().getResources().getString(i));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v5, types: [android.view.View, android.widget.TextView, com.up366.qmui.widget.textview.QMUISpanTouchFixTextView] */
        @Override // com.up366.qmui.widget.dialog.QMUIDialogBuilder
        protected android.view.View onCreateContent(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView, android.content.Context context) {
            java.lang.CharSequence charSequence = this.mMessage;
            if (charSequence == null || charSequence.length() == 0) {
                return null;
            }
            ?? qMUISpanTouchFixTextView = new com.up366.qmui.widget.textview.QMUISpanTouchFixTextView(context);
            assignMessageTvWithAttr(qMUISpanTouchFixTextView, hasTitle(), com.qmuiteam.qmui.R.attr.qmui_dialog_message_content_style);
            qMUISpanTouchFixTextView.setText(this.mMessage);
            qMUISpanTouchFixTextView.setMovementMethodDefault();
            com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
            qMUISkinValueBuilderAcquire.textColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_message_text_color);
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) qMUISpanTouchFixTextView, qMUISkinValueBuilderAcquire);
            com.up366.qmui.skin.QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
            return wrapWithScroll(qMUISpanTouchFixTextView);
        }

        @Override // com.up366.qmui.widget.dialog.QMUIDialogBuilder
        protected android.view.View onCreateTitle(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView, android.content.Context context) {
            java.lang.CharSequence charSequence;
            android.view.View viewOnCreateTitle = super.onCreateTitle(qMUIDialog, qMUIDialogView, context);
            if (viewOnCreateTitle != null && ((charSequence = this.mMessage) == null || charSequence.length() == 0)) {
                android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, com.qmuiteam.qmui.R.styleable.QMUIDialogTitleTvCustomDef, com.qmuiteam.qmui.R.attr.qmui_dialog_title_style, 0);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i);
                    if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogTitleTvCustomDef_qmui_paddingBottomWhenNotContent) {
                        viewOnCreateTitle.setPadding(viewOnCreateTitle.getPaddingLeft(), viewOnCreateTitle.getPaddingTop(), viewOnCreateTitle.getPaddingRight(), typedArrayObtainStyledAttributes.getDimensionPixelSize(index, viewOnCreateTitle.getPaddingBottom()));
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }
            return viewOnCreateTitle;
        }

        public static void assignMessageTvWithAttr(android.widget.TextView textView, boolean z, int i) {
            com.up366.qmui.util.QMUIResHelper.assignTextViewWithAttr(textView, i);
            if (z) {
                return;
            }
            android.content.res.TypedArray typedArrayObtainStyledAttributes = textView.getContext().obtainStyledAttributes(null, com.qmuiteam.qmui.R.styleable.QMUIDialogMessageTvCustomDef, i, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMessageTvCustomDef_qmui_paddingTopWhenNotTitle) {
                    textView.setPadding(textView.getPaddingLeft(), typedArrayObtainStyledAttributes.getDimensionPixelSize(index, textView.getPaddingTop()), textView.getPaddingRight(), textView.getPaddingBottom());
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class CheckBoxMessageDialogBuilder extends com.up366.qmui.widget.dialog.QMUIDialogBuilder<com.up366.qmui.widget.dialog.QMUIDialog.CheckBoxMessageDialogBuilder> {
        private boolean mIsChecked;
        protected java.lang.String mMessage;
        private com.up366.qmui.widget.textview.QMUISpanTouchFixTextView mTextView;

        public CheckBoxMessageDialogBuilder(android.content.Context context) {
            super(context);
            this.mIsChecked = false;
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.CheckBoxMessageDialogBuilder setMessage(java.lang.String str) {
            this.mMessage = str;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.CheckBoxMessageDialogBuilder setMessage(int i) {
            return setMessage(getBaseContext().getResources().getString(i));
        }

        public boolean isChecked() {
            return this.mIsChecked;
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.CheckBoxMessageDialogBuilder setChecked(boolean z) {
            if (this.mIsChecked != z) {
                this.mIsChecked = z;
                com.up366.qmui.widget.textview.QMUISpanTouchFixTextView qMUISpanTouchFixTextView = this.mTextView;
                if (qMUISpanTouchFixTextView != null) {
                    qMUISpanTouchFixTextView.setSelected(z);
                }
            }
            return this;
        }

        @Override // com.up366.qmui.widget.dialog.QMUIDialogBuilder
        protected android.view.View onCreateContent(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView, android.content.Context context) {
            java.lang.String str = this.mMessage;
            if (str == null || str.length() == 0) {
                return null;
            }
            com.up366.qmui.widget.textview.QMUISpanTouchFixTextView qMUISpanTouchFixTextView = new com.up366.qmui.widget.textview.QMUISpanTouchFixTextView(context);
            this.mTextView = qMUISpanTouchFixTextView;
            qMUISpanTouchFixTextView.setMovementMethodDefault();
            com.up366.qmui.widget.dialog.QMUIDialog.MessageDialogBuilder.assignMessageTvWithAttr(this.mTextView, hasTitle(), com.qmuiteam.qmui.R.attr.qmui_dialog_message_content_style);
            this.mTextView.setText(this.mMessage);
            android.graphics.drawable.Drawable skinDrawable = com.up366.qmui.skin.QMUISkinHelper.getSkinDrawable(this.mTextView, com.qmuiteam.qmui.R.attr.qmui_skin_support_s_dialog_check_drawable);
            if (skinDrawable != null) {
                skinDrawable.setBounds(0, 0, skinDrawable.getIntrinsicWidth(), skinDrawable.getIntrinsicHeight());
                this.mTextView.setCompoundDrawables(skinDrawable, null, null, null);
            }
            com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
            qMUISkinValueBuilderAcquire.textColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_message_text_color);
            qMUISkinValueBuilderAcquire.textCompoundLeftSrc(com.qmuiteam.qmui.R.attr.qmui_skin_support_s_dialog_check_drawable);
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mTextView, qMUISkinValueBuilderAcquire);
            com.up366.qmui.skin.QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
            this.mTextView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.qmui.widget.dialog.QMUIDialog.CheckBoxMessageDialogBuilder.1
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.up366.qmui.widget.dialog.QMUIDialog.CheckBoxMessageDialogBuilder.this.setChecked(!r2.mIsChecked);
                }
            });
            this.mTextView.setSelected(this.mIsChecked);
            return wrapWithScroll(this.mTextView);
        }

        @java.lang.Deprecated
        public com.up366.qmui.widget.textview.QMUISpanTouchFixTextView getTextView() {
            return this.mTextView;
        }
    }

    public static class EditTextDialogBuilder extends com.up366.qmui.widget.dialog.QMUIDialogBuilder<com.up366.qmui.widget.dialog.QMUIDialog.EditTextDialogBuilder> {
        private java.lang.CharSequence mDefaultText;
        protected android.widget.EditText mEditText;
        private int mInputType;
        protected java.lang.String mPlaceholder;
        protected androidx.appcompat.widget.AppCompatImageView mRightImageView;
        private android.text.TextWatcher mTextWatcher;
        protected android.text.method.TransformationMethod mTransformationMethod;

        protected void configRightImageView(androidx.appcompat.widget.AppCompatImageView appCompatImageView, android.widget.EditText editText) {
        }

        public EditTextDialogBuilder(android.content.Context context) {
            super(context);
            this.mInputType = 1;
            this.mDefaultText = null;
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.EditTextDialogBuilder setPlaceholder(java.lang.String str) {
            this.mPlaceholder = str;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.EditTextDialogBuilder setPlaceholder(int i) {
            return setPlaceholder(getBaseContext().getResources().getString(i));
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.EditTextDialogBuilder setDefaultText(java.lang.CharSequence charSequence) {
            this.mDefaultText = charSequence;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.EditTextDialogBuilder setTransformationMethod(android.text.method.TransformationMethod transformationMethod) {
            this.mTransformationMethod = transformationMethod;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.EditTextDialogBuilder setInputType(int i) {
            this.mInputType = i;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.EditTextDialogBuilder setTextWatcher(android.text.TextWatcher textWatcher) {
            this.mTextWatcher = textWatcher;
            return this;
        }

        @Override // com.up366.qmui.widget.dialog.QMUIDialogBuilder
        protected androidx.constraintlayout.widget.ConstraintLayout.LayoutParams onCreateContentLayoutParams(android.content.Context context) {
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParamsOnCreateContentLayoutParams = super.onCreateContentLayoutParams(context);
            int attrDimen = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_dialog_padding_horizontal);
            layoutParamsOnCreateContentLayoutParams.leftMargin = attrDimen;
            layoutParamsOnCreateContentLayoutParams.rightMargin = attrDimen;
            layoutParamsOnCreateContentLayoutParams.topMargin = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_dialog_edit_margin_top);
            layoutParamsOnCreateContentLayoutParams.bottomMargin = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_dialog_edit_margin_bottom);
            return layoutParamsOnCreateContentLayoutParams;
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View, com.up366.qmui.layout.QMUIConstraintLayout] */
        @Override // com.up366.qmui.widget.dialog.QMUIDialogBuilder
        protected android.view.View onCreateContent(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView, android.content.Context context) {
            ?? qMUIConstraintLayout = new com.up366.qmui.layout.QMUIConstraintLayout(context);
            qMUIConstraintLayout.onlyShowBottomDivider(0, 0, com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_dialog_edit_bottom_line_height), com.up366.qmui.util.QMUIResHelper.getAttrColor(context, com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_edit_bottom_line_color));
            com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
            qMUISkinValueBuilderAcquire.bottomSeparator(com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_edit_bottom_line_color);
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) qMUIConstraintLayout, qMUISkinValueBuilderAcquire);
            androidx.appcompat.widget.AppCompatEditText appCompatEditText = new androidx.appcompat.widget.AppCompatEditText(context);
            this.mEditText = appCompatEditText;
            appCompatEditText.setBackgroundResource(0);
            com.up366.qmui.widget.dialog.QMUIDialog.MessageDialogBuilder.assignMessageTvWithAttr(this.mEditText, hasTitle(), com.qmuiteam.qmui.R.attr.qmui_dialog_edit_content_style);
            this.mEditText.setFocusable(true);
            this.mEditText.setFocusableInTouchMode(true);
            this.mEditText.setImeOptions(2);
            this.mEditText.setId(com.qmuiteam.qmui.R.id.qmui_dialog_edit_input);
            if (!com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(this.mDefaultText)) {
                this.mEditText.setText(this.mDefaultText);
            }
            android.text.TextWatcher textWatcher = this.mTextWatcher;
            if (textWatcher != null) {
                this.mEditText.addTextChangedListener(textWatcher);
            }
            qMUISkinValueBuilderAcquire.clear();
            qMUISkinValueBuilderAcquire.textColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_edit_text_color);
            qMUISkinValueBuilderAcquire.hintColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_dialog_edit_text_hint_color);
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mEditText, qMUISkinValueBuilderAcquire);
            com.up366.qmui.skin.QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
            androidx.appcompat.widget.AppCompatImageView appCompatImageView = new androidx.appcompat.widget.AppCompatImageView(context);
            this.mRightImageView = appCompatImageView;
            appCompatImageView.setId(com.qmuiteam.qmui.R.id.qmui_dialog_edit_right_icon);
            this.mRightImageView.setVisibility(8);
            configRightImageView(this.mRightImageView, this.mEditText);
            android.text.method.TransformationMethod transformationMethod = this.mTransformationMethod;
            if (transformationMethod != null) {
                this.mEditText.setTransformationMethod(transformationMethod);
            } else {
                this.mEditText.setInputType(this.mInputType);
            }
            java.lang.String str = this.mPlaceholder;
            if (str != null) {
                this.mEditText.setHint(str);
            }
            qMUIConstraintLayout.addView(this.mEditText, createEditTextLayoutParams(context));
            qMUIConstraintLayout.addView(this.mRightImageView, createRightIconLayoutParams(context));
            return qMUIConstraintLayout;
        }

        protected androidx.constraintlayout.widget.ConstraintLayout.LayoutParams createEditTextLayoutParams(android.content.Context context) {
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(0, -2);
            layoutParams.leftToLeft = 0;
            layoutParams.topToTop = 0;
            layoutParams.rightToLeft = com.qmuiteam.qmui.R.id.qmui_dialog_edit_right_icon;
            layoutParams.rightToRight = com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 5);
            layoutParams.goneRightMargin = 0;
            return layoutParams;
        }

        protected androidx.constraintlayout.widget.ConstraintLayout.LayoutParams createRightIconLayoutParams(android.content.Context context) {
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.rightToRight = 0;
            layoutParams.bottomToBottom = com.qmuiteam.qmui.R.id.qmui_dialog_edit_input;
            return layoutParams;
        }

        @Override // com.up366.qmui.widget.dialog.QMUIDialogBuilder
        protected void onAfterCreate(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogRootLayout qMUIDialogRootLayout, android.content.Context context) {
            super.onAfterCreate(qMUIDialog, qMUIDialogRootLayout, context);
            final android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) context.getSystemService("input_method");
            qMUIDialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.qmui.widget.dialog.QMUIDialog.EditTextDialogBuilder.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(android.content.DialogInterface dialogInterface) {
                    inputMethodManager.hideSoftInputFromWindow(com.up366.qmui.widget.dialog.QMUIDialog.EditTextDialogBuilder.this.mEditText.getWindowToken(), 0);
                }
            });
            this.mEditText.postDelayed(new java.lang.Runnable() { // from class: com.up366.qmui.widget.dialog.QMUIDialog.EditTextDialogBuilder.2
                @Override // java.lang.Runnable
                public void run() {
                    com.up366.qmui.widget.dialog.QMUIDialog.EditTextDialogBuilder.this.mEditText.requestFocus();
                    inputMethodManager.showSoftInput(com.up366.qmui.widget.dialog.QMUIDialog.EditTextDialogBuilder.this.mEditText, 0);
                }
            }, 300L);
        }

        @java.lang.Deprecated
        public android.widget.EditText getEditText() {
            return this.mEditText;
        }

        public android.widget.ImageView getRightImageView() {
            return this.mRightImageView;
        }
    }

    public static class MenuBaseDialogBuilder<T extends com.up366.qmui.widget.dialog.QMUIDialogBuilder> extends com.up366.qmui.widget.dialog.QMUIDialogBuilder<T> {
        protected java.util.ArrayList<com.up366.qmui.widget.dialog.QMUIDialogMenuItemView> mMenuItemViews;
        protected java.util.ArrayList<com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory> mMenuItemViewsFactoryList;

        public interface ItemViewFactory {
            com.up366.qmui.widget.dialog.QMUIDialogMenuItemView createItemView(android.content.Context context);
        }

        protected void onItemClick(int i) {
        }

        public MenuBaseDialogBuilder(android.content.Context context) {
            super(context);
            this.mMenuItemViews = new java.util.ArrayList<>();
            this.mMenuItemViewsFactoryList = new java.util.ArrayList<>();
        }

        public void clear() {
            this.mMenuItemViewsFactoryList.clear();
        }

        @java.lang.Deprecated
        public T addItem(final com.up366.qmui.widget.dialog.QMUIDialogMenuItemView qMUIDialogMenuItemView, final android.content.DialogInterface.OnClickListener onClickListener) {
            qMUIDialogMenuItemView.setMenuIndex(this.mMenuItemViewsFactoryList.size());
            qMUIDialogMenuItemView.setListener(new com.up366.qmui.widget.dialog.QMUIDialogMenuItemView.MenuItemViewListener() { // from class: com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.1
                @Override // com.up366.qmui.widget.dialog.QMUIDialogMenuItemView.MenuItemViewListener
                public void onClick(int i) {
                    com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.this.onItemClick(i);
                    android.content.DialogInterface.OnClickListener onClickListener2 = onClickListener;
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.this.mDialog, i);
                    }
                }
            });
            this.mMenuItemViewsFactoryList.add(new com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory() { // from class: com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.2
                @Override // com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory
                public com.up366.qmui.widget.dialog.QMUIDialogMenuItemView createItemView(android.content.Context context) {
                    return qMUIDialogMenuItemView;
                }
            });
            return this;
        }

        public T addItem(final com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory itemViewFactory, final android.content.DialogInterface.OnClickListener onClickListener) {
            this.mMenuItemViewsFactoryList.add(new com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory() { // from class: com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.3
                @Override // com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory
                public com.up366.qmui.widget.dialog.QMUIDialogMenuItemView createItemView(android.content.Context context) {
                    com.up366.qmui.widget.dialog.QMUIDialogMenuItemView qMUIDialogMenuItemViewCreateItemView = itemViewFactory.createItemView(context);
                    qMUIDialogMenuItemViewCreateItemView.setMenuIndex(com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.this.mMenuItemViewsFactoryList.indexOf(this));
                    qMUIDialogMenuItemViewCreateItemView.setListener(new com.up366.qmui.widget.dialog.QMUIDialogMenuItemView.MenuItemViewListener() { // from class: com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.3.1
                        @Override // com.up366.qmui.widget.dialog.QMUIDialogMenuItemView.MenuItemViewListener
                        public void onClick(int i) {
                            com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.this.onItemClick(i);
                            if (onClickListener != null) {
                                onClickListener.onClick(com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.this.mDialog, i);
                            }
                        }
                    });
                    return qMUIDialogMenuItemViewCreateItemView;
                }
            });
            return this;
        }

        @Override // com.up366.qmui.widget.dialog.QMUIDialogBuilder
        protected android.view.View onCreateContent(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView, android.content.Context context) {
            com.up366.qmui.layout.QMUILinearLayout qMUILinearLayout = new com.up366.qmui.layout.QMUILinearLayout(context);
            qMUILinearLayout.setOrientation(1);
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, com.qmuiteam.qmui.R.styleable.QMUIDialogMenuContainerStyleDef, com.qmuiteam.qmui.R.attr.qmui_dialog_menu_container_style, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            int dimensionPixelSize = 0;
            int dimensionPixelSize2 = 0;
            int dimensionPixelSize3 = 0;
            int dimensionPixelSize4 = 0;
            int dimensionPixelSize5 = 0;
            int dimensionPixelSize6 = -1;
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMenuContainerStyleDef_android_paddingTop) {
                    dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize2);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMenuContainerStyleDef_android_paddingBottom) {
                    dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize4);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMenuContainerStyleDef_qmui_dialog_menu_container_single_padding_vertical) {
                    dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMenuContainerStyleDef_qmui_dialog_menu_container_padding_top_when_title_exist) {
                    dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize3);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMenuContainerStyleDef_qmui_dialog_menu_container_padding_bottom_when_action_exist) {
                    dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize5);
                } else if (index == com.qmuiteam.qmui.R.styleable.QMUIDialogMenuContainerStyleDef_qmui_dialog_menu_item_height) {
                    dimensionPixelSize6 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dimensionPixelSize6);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.mMenuItemViewsFactoryList.size() == 1) {
                dimensionPixelSize4 = dimensionPixelSize;
            } else {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!hasTitle()) {
                dimensionPixelSize3 = dimensionPixelSize;
            }
            if (this.mActions.size() <= 0) {
                dimensionPixelSize5 = dimensionPixelSize4;
            }
            qMUILinearLayout.setPadding(0, dimensionPixelSize3, 0, dimensionPixelSize5);
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, dimensionPixelSize6);
            layoutParams.gravity = 16;
            this.mMenuItemViews.clear();
            java.util.Iterator<com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory> it = this.mMenuItemViewsFactoryList.iterator();
            while (it.hasNext()) {
                androidx.constraintlayout.widget.ConstraintLayout constraintLayoutCreateItemView = it.next().createItemView(context);
                qMUILinearLayout.addView((android.view.View) constraintLayoutCreateItemView, (android.view.ViewGroup.LayoutParams) layoutParams);
                this.mMenuItemViews.add((com.up366.qmui.widget.dialog.QMUIDialogMenuItemView) constraintLayoutCreateItemView);
            }
            return wrapWithScroll(qMUILinearLayout);
        }
    }

    public static class MenuDialogBuilder extends com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder<com.up366.qmui.widget.dialog.QMUIDialog.MenuDialogBuilder> {
        public MenuDialogBuilder(android.content.Context context) {
            super(context);
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.MenuDialogBuilder addItems(java.lang.CharSequence[] charSequenceArr, android.content.DialogInterface.OnClickListener onClickListener) {
            for (java.lang.CharSequence charSequence : charSequenceArr) {
                addItem(charSequence, onClickListener);
            }
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.MenuDialogBuilder addItem(final java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
            addItem(new com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory() { // from class: com.up366.qmui.widget.dialog.QMUIDialog.MenuDialogBuilder.1
                @Override // com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory
                public com.up366.qmui.widget.dialog.QMUIDialogMenuItemView createItemView(android.content.Context context) {
                    return new com.up366.qmui.widget.dialog.QMUIDialogMenuItemView.TextItemView(context, charSequence);
                }
            }, onClickListener);
            return this;
        }
    }

    public static class CheckableDialogBuilder extends com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder<com.up366.qmui.widget.dialog.QMUIDialog.CheckableDialogBuilder> {
        private int mCheckedIndex;

        public CheckableDialogBuilder(android.content.Context context) {
            super(context);
            this.mCheckedIndex = -1;
        }

        public int getCheckedIndex() {
            return this.mCheckedIndex;
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.CheckableDialogBuilder setCheckedIndex(int i) {
            this.mCheckedIndex = i;
            return this;
        }

        @Override // com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder, com.up366.qmui.widget.dialog.QMUIDialogBuilder
        protected android.view.View onCreateContent(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView, android.content.Context context) {
            android.view.View viewOnCreateContent = super.onCreateContent(qMUIDialog, qMUIDialogView, context);
            int i = this.mCheckedIndex;
            if (i > -1 && i < this.mMenuItemViews.size()) {
                this.mMenuItemViews.get(this.mCheckedIndex).setChecked(true);
            }
            return viewOnCreateContent;
        }

        @Override // com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder
        protected void onItemClick(int i) {
            for (int i2 = 0; i2 < this.mMenuItemViews.size(); i2++) {
                com.up366.qmui.widget.dialog.QMUIDialogMenuItemView qMUIDialogMenuItemView = this.mMenuItemViews.get(i2);
                if (i2 == i) {
                    qMUIDialogMenuItemView.setChecked(true);
                    this.mCheckedIndex = i;
                } else {
                    qMUIDialogMenuItemView.setChecked(false);
                }
            }
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.CheckableDialogBuilder addItems(java.lang.CharSequence[] charSequenceArr, android.content.DialogInterface.OnClickListener onClickListener) {
            for (final java.lang.CharSequence charSequence : charSequenceArr) {
                addItem(new com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory() { // from class: com.up366.qmui.widget.dialog.QMUIDialog.CheckableDialogBuilder.1
                    @Override // com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory
                    public com.up366.qmui.widget.dialog.QMUIDialogMenuItemView createItemView(android.content.Context context) {
                        return new com.up366.qmui.widget.dialog.QMUIDialogMenuItemView.MarkItemView(context, charSequence);
                    }
                }, onClickListener);
            }
            return this;
        }
    }

    public static class MultiCheckableDialogBuilder extends com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder<com.up366.qmui.widget.dialog.QMUIDialog.MultiCheckableDialogBuilder> {
        private java.util.BitSet mCheckedItems;

        public MultiCheckableDialogBuilder(android.content.Context context) {
            super(context);
            this.mCheckedItems = new java.util.BitSet();
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.MultiCheckableDialogBuilder setCheckedItems(java.util.BitSet bitSet) {
            this.mCheckedItems.clear();
            this.mCheckedItems.or(bitSet);
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.MultiCheckableDialogBuilder setCheckedItems(int[] iArr) {
            this.mCheckedItems.clear();
            if (iArr != null && iArr.length > 0) {
                for (int i : iArr) {
                    this.mCheckedItems.set(i);
                }
            }
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.MultiCheckableDialogBuilder addItems(java.lang.CharSequence[] charSequenceArr, android.content.DialogInterface.OnClickListener onClickListener) {
            for (final java.lang.CharSequence charSequence : charSequenceArr) {
                addItem(new com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory() { // from class: com.up366.qmui.widget.dialog.QMUIDialog.MultiCheckableDialogBuilder.1
                    @Override // com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder.ItemViewFactory
                    public com.up366.qmui.widget.dialog.QMUIDialogMenuItemView createItemView(android.content.Context context) {
                        return new com.up366.qmui.widget.dialog.QMUIDialogMenuItemView.CheckItemView(context, true, charSequence);
                    }
                }, onClickListener);
            }
            return this;
        }

        @Override // com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder, com.up366.qmui.widget.dialog.QMUIDialogBuilder
        protected android.view.View onCreateContent(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView, android.content.Context context) {
            android.view.View viewOnCreateContent = super.onCreateContent(qMUIDialog, qMUIDialogView, context);
            for (int i = 0; i < this.mMenuItemViews.size(); i++) {
                this.mMenuItemViews.get(i).setChecked(this.mCheckedItems.get(i));
            }
            return viewOnCreateContent;
        }

        @Override // com.up366.qmui.widget.dialog.QMUIDialog.MenuBaseDialogBuilder
        protected void onItemClick(int i) {
            com.up366.qmui.widget.dialog.QMUIDialogMenuItemView qMUIDialogMenuItemView = this.mMenuItemViews.get(i);
            qMUIDialogMenuItemView.setChecked(!qMUIDialogMenuItemView.isChecked());
            this.mCheckedItems.set(i, qMUIDialogMenuItemView.isChecked());
        }

        public java.util.BitSet getCheckedItemRecord() {
            return (java.util.BitSet) this.mCheckedItems.clone();
        }

        public int[] getCheckedItemIndexes() {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int size = this.mMenuItemViews.size();
            for (int i = 0; i < size; i++) {
                com.up366.qmui.widget.dialog.QMUIDialogMenuItemView qMUIDialogMenuItemView = this.mMenuItemViews.get(i);
                if (qMUIDialogMenuItemView.isChecked()) {
                    arrayList.add(java.lang.Integer.valueOf(qMUIDialogMenuItemView.getMenuIndex()));
                }
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((java.lang.Integer) arrayList.get(i2)).intValue();
            }
            return iArr;
        }

        protected boolean existCheckedItem() {
            return !this.mCheckedItems.isEmpty();
        }
    }

    public static class CustomDialogBuilder extends com.up366.qmui.widget.dialog.QMUIDialogBuilder {
        private int mLayoutId;

        public CustomDialogBuilder(android.content.Context context) {
            super(context);
        }

        public com.up366.qmui.widget.dialog.QMUIDialog.CustomDialogBuilder setLayout(int i) {
            this.mLayoutId = i;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.up366.qmui.widget.dialog.QMUIDialogBuilder
        protected android.view.View onCreateContent(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView, android.content.Context context) {
            return android.view.LayoutInflater.from(context).inflate(this.mLayoutId, (android.view.ViewGroup) qMUIDialogView, false);
        }
    }

    public static abstract class AutoResizeDialogBuilder extends com.up366.qmui.widget.dialog.QMUIDialogBuilder {
        protected android.widget.ScrollView mScrollView;

        public abstract android.view.View onBuildContent(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, android.content.Context context);

        public AutoResizeDialogBuilder(android.content.Context context) {
            super(context);
            setCheckKeyboardOverlay(true);
        }

        @Override // com.up366.qmui.widget.dialog.QMUIDialogBuilder
        protected android.view.View onCreateContent(com.up366.qmui.widget.dialog.QMUIDialog qMUIDialog, com.up366.qmui.widget.dialog.QMUIDialogView qMUIDialogView, android.content.Context context) {
            com.up366.qmui.widget.QMUIWrapContentScrollView qMUIWrapContentScrollViewWrapWithScroll = wrapWithScroll(onBuildContent(qMUIDialog, context));
            this.mScrollView = qMUIWrapContentScrollViewWrapWithScroll;
            return qMUIWrapContentScrollViewWrapWithScroll;
        }
    }
}
