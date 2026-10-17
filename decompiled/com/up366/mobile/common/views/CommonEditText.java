package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CommonEditText extends androidx.appcompat.widget.AppCompatEditText {
    public CommonEditText(android.content.Context context) {
        this(context, null);
    }

    public CommonEditText(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.editTextStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonEditText(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            return;
        }
        noActionMode(this);
    }

    private void noActionMode(android.widget.EditText editText) {
        editText.setCustomSelectionActionModeCallback(new android.view.ActionMode.Callback() { // from class: com.up366.mobile.common.views.CommonEditText.1
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
    }
}
