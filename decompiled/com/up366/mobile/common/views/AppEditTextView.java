package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppEditTextView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.AppEditTextViewLayoutBinding b;
    private boolean clearEnable;
    private com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener editActionListener;
    private boolean eyeEnable;
    private int inputType;
    private com.up366.mobile.common.views.AppEditTextView.IOnChangeListener listener;

    public interface IOnChangeListener {
        void onChange(com.up366.mobile.common.views.AppEditTextView appEditTextView);
    }

    public interface IOnEditActionListener {
        void onSearch(com.up366.mobile.common.views.AppEditTextView appEditTextView);
    }

    public AppEditTextView(android.content.Context context) {
        this(context, null);
    }

    public AppEditTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppEditTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.inputType = 1;
        com.up366.mobile.databinding.AppEditTextViewLayoutBinding appEditTextViewLayoutBinding = (com.up366.mobile.databinding.AppEditTextViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.app_edit_text_view_layout, this, true);
        this.b = appEditTextViewLayoutBinding;
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.AppEditTextView);
            java.lang.String string = typedArrayObtainStyledAttributes.getString(2);
            java.lang.String string2 = typedArrayObtainStyledAttributes.getString(7);
            int i2 = typedArrayObtainStyledAttributes.getInt(4, 0);
            java.lang.String string3 = typedArrayObtainStyledAttributes.getString(6);
            boolean z = typedArrayObtainStyledAttributes.getBoolean(5, false);
            this.inputType = typedArrayObtainStyledAttributes.getInt(8, 1);
            this.clearEnable = typedArrayObtainStyledAttributes.getBoolean(0, true);
            this.eyeEnable = typedArrayObtainStyledAttributes.getBoolean(1, false);
            int i3 = typedArrayObtainStyledAttributes.getInt(3, 0);
            typedArrayObtainStyledAttributes.recycle();
            setUpImeOption(i3);
            appEditTextViewLayoutBinding.edit.setHint(" " + string);
            appEditTextViewLayoutBinding.edit.setText(string2);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(new android.text.InputFilter() { // from class: com.up366.mobile.common.views.AppEditTextView$$ExternalSyntheticLambda3
                @Override // android.text.InputFilter
                public final java.lang.CharSequence filter(java.lang.CharSequence charSequence, int i4, int i5, android.text.Spanned spanned, int i6, int i7) {
                    return this.f$0.lambda$new$0(charSequence, i4, i5, spanned, i6, i7);
                }
            });
            appEditTextViewLayoutBinding.edit.setCustomSelectionActionModeCallback(new android.view.ActionMode.Callback() { // from class: com.up366.mobile.common.views.AppEditTextView.1
                @Override // android.view.ActionMode.Callback
                public boolean onActionItemClicked(android.view.ActionMode actionMode, android.view.MenuItem menuItem) {
                    return true;
                }

                @Override // android.view.ActionMode.Callback
                public boolean onCreateActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
                    return false;
                }

                @Override // android.view.ActionMode.Callback
                public void onDestroyActionMode(android.view.ActionMode actionMode) {
                }

                @Override // android.view.ActionMode.Callback
                public boolean onPrepareActionMode(android.view.ActionMode actionMode, android.view.Menu menu) {
                    return false;
                }
            });
            if (i2 > 0) {
                arrayList.add(new android.text.InputFilter.LengthFilter(i2));
            }
            appEditTextViewLayoutBinding.edit.setFilters((android.text.InputFilter[]) arrayList.toArray(new android.text.InputFilter[0]));
            if (com.up366.common.StringUtils.isEmptyOrNull(string3)) {
                appEditTextViewLayoutBinding.rightBtn.setVisibility(8);
            } else {
                appEditTextViewLayoutBinding.rightBtn.setVisibility(0);
                appEditTextViewLayoutBinding.rightBtn.setText(string3);
            }
            appEditTextViewLayoutBinding.rightBtn.setEnabled(z);
            int i4 = this.inputType;
            if (i4 == 1) {
                appEditTextViewLayoutBinding.edit.setInputType(1);
            } else if (i4 == 2) {
                appEditTextViewLayoutBinding.edit.setInputType(129);
            } else if (i4 == 3) {
                appEditTextViewLayoutBinding.edit.setInputType(2);
            } else if (i4 == 4) {
                appEditTextViewLayoutBinding.edit.setInputType(3);
            }
            refreshClearState();
            appEditTextViewLayoutBinding.clear.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.AppEditTextView$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$new$1(view);
                }
            });
            appEditTextViewLayoutBinding.eye.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.AppEditTextView$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$new$2(view);
                }
            });
        }
        appEditTextViewLayoutBinding.edit.addTextChangedListener(new com.up366.mobile.common.adapter.TextWatcherAdapter() { // from class: com.up366.mobile.common.views.AppEditTextView.2
            @Override // com.up366.mobile.common.adapter.TextWatcherAdapter, android.text.TextWatcher
            public void onTextChanged(java.lang.CharSequence charSequence, int i5, int i6, int i7) {
                com.up366.mobile.common.views.AppEditTextView.this.refreshClearState();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ java.lang.CharSequence lambda$new$0(java.lang.CharSequence charSequence, int i, int i2, android.text.Spanned spanned, int i3, int i4) {
        if (!com.up366.common.ValidateUtilsUp.containsEmoji(charSequence.toString())) {
            return null;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.show(this, "不能输入表情符号哦");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(android.view.View view) {
        this.b.edit.setText("");
        refreshClearState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(android.view.View view) {
        this.b.eye.toggle();
        int selectionStart = this.b.edit.getSelectionStart();
        int selectionEnd = this.b.edit.getSelectionEnd();
        if (this.b.eye.isChecked()) {
            this.b.edit.setInputType(145);
        } else {
            this.b.edit.setInputType(129);
        }
        this.b.edit.setSelection(selectionStart, selectionEnd);
    }

    private void setUpImeOption(int i) {
        if (i == 1) {
            this.b.edit.setImeOptions(3);
            this.b.edit.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() { // from class: com.up366.mobile.common.views.AppEditTextView$$ExternalSyntheticLambda0
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(android.widget.TextView textView, int i2, android.view.KeyEvent keyEvent) {
                    return this.f$0.lambda$setUpImeOption$3(textView, i2, keyEvent);
                }
            });
        } else if (i == 2) {
            this.b.edit.setImeOptions(5);
            this.b.edit.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() { // from class: com.up366.mobile.common.views.AppEditTextView$$ExternalSyntheticLambda1
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(android.widget.TextView textView, int i2, android.view.KeyEvent keyEvent) {
                    return this.f$0.lambda$setUpImeOption$4(textView, i2, keyEvent);
                }
            });
        } else if (i == 3) {
            this.b.edit.setImeOptions(2);
            this.b.edit.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() { // from class: com.up366.mobile.common.views.AppEditTextView$$ExternalSyntheticLambda2
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(android.widget.TextView textView, int i2, android.view.KeyEvent keyEvent) {
                    return this.f$0.lambda$setUpImeOption$5(textView, i2, keyEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setUpImeOption$3(android.widget.TextView textView, int i, android.view.KeyEvent keyEvent) {
        com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener iOnEditActionListener;
        if (i != 3 || (iOnEditActionListener = this.editActionListener) == null) {
            return false;
        }
        iOnEditActionListener.onSearch(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setUpImeOption$4(android.widget.TextView textView, int i, android.view.KeyEvent keyEvent) {
        com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener iOnEditActionListener;
        if (i != 5 || (iOnEditActionListener = this.editActionListener) == null) {
            return false;
        }
        iOnEditActionListener.onSearch(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setUpImeOption$5(android.widget.TextView textView, int i, android.view.KeyEvent keyEvent) {
        com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener iOnEditActionListener;
        if (i != 2 || (iOnEditActionListener = this.editActionListener) == null) {
            return false;
        }
        iOnEditActionListener.onSearch(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshClearState() {
        java.lang.String string = this.b.edit.getText().toString();
        if (this.clearEnable && !com.up366.common.StringUtils.isEmptyOrNull(string)) {
            this.b.clear.setVisibility(0);
        } else {
            this.b.clear.setVisibility(8);
        }
        if (this.eyeEnable && !com.up366.common.StringUtils.isEmptyOrNull(string)) {
            this.b.eye.setVisibility(0);
        } else {
            this.b.eye.setVisibility(8);
        }
        com.up366.mobile.common.views.AppEditTextView.IOnChangeListener iOnChangeListener = this.listener;
        if (iOnChangeListener != null) {
            iOnChangeListener.onChange(this);
        }
        if (string.length() > 0) {
            if (this.inputType != 2) {
                this.b.edit.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
                return;
            } else {
                this.b.edit.setTypeface(android.graphics.Typeface.MONOSPACE);
                return;
            }
        }
        this.b.edit.setTypeface(android.graphics.Typeface.DEFAULT);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.b.edit.setEnabled(z);
        this.clearEnable = false;
        this.b.clear.setVisibility(8);
    }

    public void setHint(java.lang.CharSequence charSequence) {
        this.b.edit.setHint(charSequence);
    }

    public void setOnChangeListener(com.up366.mobile.common.views.AppEditTextView.IOnChangeListener iOnChangeListener) {
        this.listener = iOnChangeListener;
        if (iOnChangeListener != null) {
            iOnChangeListener.onChange(this);
        }
    }

    public void setOnEditActionListener(com.up366.mobile.common.views.AppEditTextView.IOnEditActionListener iOnEditActionListener) {
        this.editActionListener = iOnEditActionListener;
    }

    public java.lang.CharSequence getText() {
        return this.b.edit.getText();
    }

    public java.lang.String getTrimText() {
        return this.b.edit.getText().toString().trim();
    }

    public void setRightEnable(boolean z) {
        this.b.rightBtn.setEnabled(z);
    }

    public void setRightClickListener(android.view.View.OnClickListener onClickListener) {
        this.b.rightBtn.setOnClickListener(onClickListener);
    }

    public void setRightText(java.lang.CharSequence charSequence) {
        this.b.rightBtn.setText(charSequence);
    }

    public void setText(java.lang.CharSequence charSequence) {
        this.b.edit.setText(charSequence);
        try {
            if (this.b.edit.getText() != null) {
                this.b.edit.setSelection(this.b.edit.length());
            }
        } catch (java.lang.Exception e) {
            com.up366.mobile.common.onlinelog.OpLog.record("AppEditTextView_setTextError", e.getMessage());
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        this.b.edit.setFocusable(z);
        this.b.edit.setFocusableInTouchMode(z);
    }

    public void showSoftInput(boolean z) {
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) this.b.edit.getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            com.up366.common.log.Logger.error("TAG - AppEditTextView showIMM imm == null");
        } else if (z) {
            this.b.edit.requestFocus();
            inputMethodManager.showSoftInput(this.b.edit, 1);
        } else {
            inputMethodManager.hideSoftInputFromWindow(this.b.edit.getWindowToken(), 2);
        }
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(android.view.View.OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.b.edit.setOnFocusChangeListener(onFocusChangeListener);
    }
}
