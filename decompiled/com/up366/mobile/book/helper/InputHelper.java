package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class InputHelper {
    private final com.up366.mobile.book.webview.StudyPageWebView webView;

    public InputHelper(com.up366.mobile.book.webview.StudyPageWebView studyPageWebView) {
        this.webView = studyPageWebView;
    }

    public void showIMM(boolean z) {
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) this.webView.getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            com.up366.common.log.Logger.error("TAG - 2018/5/27 AppInfoHelper showIMM imm == null");
        } else if (z) {
            inputMethodManager.showSoftInput(this.webView, 1);
        } else {
            inputMethodManager.hideSoftInputFromWindow(this.webView.getWindowToken(), 2);
        }
    }

    public void showInput(java.lang.String str, java.lang.String str2) {
        final android.widget.EditText editText = new android.widget.EditText(this.webView.getContext());
        editText.requestFocus();
        editText.setSingleLine();
        if (!com.up366.common.StringUtils.isEmptyOrNull(str)) {
            editText.setText(str);
            editText.setSelection(str.length());
        }
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this.webView.getContext());
        if (com.up366.common.StringUtils.isEmptyOrNull(str2)) {
            str2 = "请输入:";
        }
        builder.setTitle(str2).setView(editText).setPositiveButton("确定", new android.content.DialogInterface.OnClickListener() { // from class: com.up366.mobile.book.helper.InputHelper$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(android.content.DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showInput$0(editText, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInput$0(android.widget.EditText editText, android.content.DialogInterface dialogInterface, int i) {
        java.lang.String string = editText.getText().toString();
        if (com.up366.common.StringUtils.isEmptyOrNull(string)) {
            return;
        }
        com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray();
        jSONArray.add("input");
        jSONArray.add(string);
        java.lang.String jSONString = jSONArray.toJSONString();
        this.webView.callJSMethod("onInputCallBack(%s)", jSONString.substring(1, jSONString.length() - 1));
    }
}
