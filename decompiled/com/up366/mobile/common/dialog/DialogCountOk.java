package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DialogCountOk {
    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void showCountOkDialog(android.app.Activity r4, int r5, final android.view.View.OnClickListener r6) {
        /*
            com.up366.mobile.common.dialog.BaseDialog r0 = new com.up366.mobile.common.dialog.BaseDialog
            r0.<init>(r4)
            r4 = 2131558573(0x7f0d00ad, float:1.8742466E38)
            com.up366.mobile.common.dialog.BaseDialog r4 = r0.create(r4)
            r1 = 2131362272(0x7f0a01e0, float:1.834432E38)
            int[] r2 = new int[]{r1}
            com.up366.mobile.common.dialog.DialogCountOk$$ExternalSyntheticLambda0 r3 = new com.up366.mobile.common.dialog.DialogCountOk$$ExternalSyntheticLambda0
            r3.<init>()
            r4.setOnClickListener(r2, r3)
            r4 = 0
            r0.setCancelable(r4)
            r6 = 2131362275(0x7f0a01e3, float:1.8344326E38)
            java.lang.String r2 = "网络异常！"
            r0.setText(r6, r2)
            android.view.View r6 = r0.getView(r1)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r6.setEnabled(r4)
            r4 = 1
            r1 = 2131362274(0x7f0a01e2, float:1.8344324E38)
            if (r5 == r4) goto L48
            r4 = 2
            if (r5 == r4) goto L41
            r4 = 3
            if (r5 == r4) goto L48
            r4 = 4
            if (r5 == r4) goto L41
            goto L4e
        L41:
            java.lang.String r4 = "当前网络不稳定\n请检查网络后重试，或者咨询助教哦~"
            r0.setText(r1, r4)
            goto L4e
        L48:
            java.lang.String r4 = "当前网络不稳定，请检查网络后重试"
            r0.setText(r1, r4)
        L4e:
            java.lang.String r4 = "我知道了"
            setCountDown(r6, r4)
            r0.showIfNot()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.common.dialog.DialogCountOk.showCountOkDialog(android.app.Activity, int, android.view.View$OnClickListener):void");
    }

    static /* synthetic */ void lambda$showCountOkDialog$0(com.up366.mobile.common.dialog.BaseDialog baseDialog, android.view.View.OnClickListener onClickListener, android.view.View view) {
        baseDialog.dismiss();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    private static void setCountDown(final android.widget.TextView textView, final java.lang.String str) {
        new android.os.CountDownTimer(com.igexin.push.config.c.s, 1000L) { // from class: com.up366.mobile.common.dialog.DialogCountOk.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                textView.setText(com.up366.common.StringUtils.format("%s(%ds)", str, java.lang.Long.valueOf((j + 1000) / 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                textView.setEnabled(true);
                textView.setText(str);
            }
        }.start();
    }
}
