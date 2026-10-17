package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ClipBoardHelper {
    private final android.content.Context context;

    public ClipBoardHelper(android.content.Context context) {
        this.context = context;
    }

    public java.lang.String getText() {
        android.content.ClipData primaryClip = ((android.content.ClipboardManager) this.context.getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() == 0) {
            return "";
        }
        return primaryClip.getItemAt(0).getText().toString();
    }

    public void copyTextToClipboard(java.lang.String str) {
        android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) this.context.getSystemService("clipboard");
        android.content.ClipData clipDataNewPlainText = android.content.ClipData.newPlainText("text", str.trim());
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
    }
}
