package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: PhotoCorrectNoRegisterDialog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/PhotoCorrectNoRegisterDialog;", "Lcom/up366/mobile/course/photoanswer/dialog/BasePhotoCorrectDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "b", "Lcom/up366/mobile/databinding/PhotoCorrectNoRegisterBinding;", "btnType", "", "onAttachedToWindow", "", "setErrorCount", "errorCount", "isAllowAutoFix", "", "setErrorCode", "errorCode", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoCorrectNoRegisterDialog extends com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog {
    private final com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding b;
    private int btnType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoCorrectNoRegisterDialog(android.content.Context context) {
        super(context, 0, 2, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding photoCorrectNoRegisterBindingInflate = com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding.inflate(android.view.LayoutInflater.from(context), null, false);
        this.b = photoCorrectNoRegisterBindingInflate;
        setContentView(photoCorrectNoRegisterBindingInflate.getRoot());
        setCancelable(false);
        photoCorrectNoRegisterBindingInflate.btnLeft.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoCorrectNoRegisterDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoCorrectNoRegisterDialog._init_$lambda$0(this.f$0, view);
            }
        });
        photoCorrectNoRegisterBindingInflate.btnRight.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.PhotoCorrectNoRegisterDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.PhotoCorrectNoRegisterDialog._init_$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(com.up366.mobile.course.photoanswer.dialog.PhotoCorrectNoRegisterDialog photoCorrectNoRegisterDialog, android.view.View view) {
        photoCorrectNoRegisterDialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = photoCorrectNoRegisterDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        callBack.onCallback(0, java.lang.Integer.valueOf(photoCorrectNoRegisterDialog.btnType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(com.up366.mobile.course.photoanswer.dialog.PhotoCorrectNoRegisterDialog photoCorrectNoRegisterDialog, android.view.View view) {
        photoCorrectNoRegisterDialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = photoCorrectNoRegisterDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback.DefaultImpls.onCallback$default(callBack, 1, null, 2, null);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        android.view.Window window = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window);
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(attributes, "getAttributes(...)");
        attributes.gravity = 17;
        attributes.width = com.up366.common.DpUtilsUp.dp2px(270.0f);
        attributes.height = -2;
        android.view.Window window2 = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window2);
        window2.getDecorView().setPadding(0, 0, 0, 0);
        android.view.Window window3 = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window3);
        window3.setAttributes(attributes);
        super.onAttachedToWindow();
    }

    public static /* synthetic */ com.up366.mobile.course.photoanswer.dialog.PhotoCorrectNoRegisterDialog setErrorCount$default(com.up366.mobile.course.photoanswer.dialog.PhotoCorrectNoRegisterDialog photoCorrectNoRegisterDialog, int i, boolean z, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return photoCorrectNoRegisterDialog.setErrorCount(i, z);
    }

    public final com.up366.mobile.course.photoanswer.dialog.PhotoCorrectNoRegisterDialog setErrorCount(int errorCount, boolean isAllowAutoFix) {
        if (com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isAutoFix() && isAllowAutoFix) {
            this.b.btnLeft.setVisibility(0);
            this.b.btnLeft.setText("自动补齐");
            this.btnType = 2;
            return this;
        }
        com.up366.common.log.Logger.info("errorCount = " + errorCount + com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.checkLessSingleRetryCount(errorCount) + "  " + com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isSingleHidden() + "  " + com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isOnline());
        if (com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.checkLessSingleRetryCount(errorCount) || com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isSingleHidden()) {
            this.b.btnLeft.setVisibility(8);
            return this;
        }
        if (com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isOnline()) {
            this.b.btnLeft.setVisibility(0);
            this.b.btnLeft.setText("在线作答");
            this.btnType = 1;
        } else if (com.up366.mobile.course.p1p.helper.P1pConfigDataHelper.INSTANCE.isForceUse()) {
            this.b.btnLeft.setVisibility(0);
            this.b.btnLeft.setText("就用这张");
            this.btnType = 0;
        } else {
            this.b.btnLeft.setVisibility(8);
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.up366.mobile.course.photoanswer.dialog.PhotoCorrectNoRegisterDialog setErrorCode(int r2) {
        /*
            r1 = this;
            r0 = 37
            if (r2 == r0) goto L58
            r0 = 38
            if (r2 == r0) goto L4d
            switch(r2) {
                case 12: goto L58;
                case 13: goto L42;
                case 14: goto L37;
                case 15: goto L2c;
                case 16: goto L4d;
                case 17: goto L21;
                case 18: goto L16;
                default: goto Lb;
            }
        Lb:
            com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding r2 = r1.b
            android.widget.ImageView r2 = r2.bottomTipImg
            r0 = 2131231718(0x7f0803e6, float:1.8079525E38)
            r2.setImageResource(r0)
            goto L62
        L16:
            com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding r2 = r1.b
            android.widget.ImageView r2 = r2.bottomTipImg
            r0 = 2131231723(0x7f0803eb, float:1.8079535E38)
            r2.setImageResource(r0)
            goto L62
        L21:
            com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding r2 = r1.b
            android.widget.ImageView r2 = r2.bottomTipImg
            r0 = 2131231721(0x7f0803e9, float:1.807953E38)
            r2.setImageResource(r0)
            goto L62
        L2c:
            com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding r2 = r1.b
            android.widget.ImageView r2 = r2.bottomTipImg
            r0 = 2131231719(0x7f0803e7, float:1.8079527E38)
            r2.setImageResource(r0)
            goto L62
        L37:
            com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding r2 = r1.b
            android.widget.ImageView r2 = r2.bottomTipImg
            r0 = 2131231724(0x7f0803ec, float:1.8079537E38)
            r2.setImageResource(r0)
            goto L62
        L42:
            com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding r2 = r1.b
            android.widget.ImageView r2 = r2.bottomTipImg
            r0 = 2131231722(0x7f0803ea, float:1.8079533E38)
            r2.setImageResource(r0)
            goto L62
        L4d:
            com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding r2 = r1.b
            android.widget.ImageView r2 = r2.bottomTipImg
            r0 = 2131231720(0x7f0803e8, float:1.8079529E38)
            r2.setImageResource(r0)
            goto L62
        L58:
            com.up366.mobile.databinding.PhotoCorrectNoRegisterBinding r2 = r1.b
            android.widget.ImageView r2 = r2.bottomTipImg
            r0 = 2131231725(0x7f0803ed, float:1.807954E38)
            r2.setImageResource(r0)
        L62:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.course.photoanswer.dialog.PhotoCorrectNoRegisterDialog.setErrorCode(int):com.up366.mobile.course.photoanswer.dialog.PhotoCorrectNoRegisterDialog");
    }
}
