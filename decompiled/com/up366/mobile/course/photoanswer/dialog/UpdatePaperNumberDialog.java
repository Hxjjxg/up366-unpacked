package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: UpdatePaperNumberDialog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/UpdatePaperNumberDialog;", "Lcom/up366/mobile/course/photoanswer/dialog/BasePhotoCorrectDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "b", "Lcom/up366/mobile/databinding/PhotoCorrectUpdatePaperNumberDialogBinding;", "setData", "jsonObject", "Lcom/alibaba/fastjson/JSONObject;", "onAttachedToWindow", "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UpdatePaperNumberDialog extends com.up366.mobile.course.photoanswer.dialog.BasePhotoCorrectDialog {
    private final com.up366.mobile.databinding.PhotoCorrectUpdatePaperNumberDialogBinding b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdatePaperNumberDialog(android.content.Context context) {
        super(context, 0, 2, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.mobile.databinding.PhotoCorrectUpdatePaperNumberDialogBinding photoCorrectUpdatePaperNumberDialogBindingInflate = com.up366.mobile.databinding.PhotoCorrectUpdatePaperNumberDialogBinding.inflate(android.view.LayoutInflater.from(context), null, false);
        this.b = photoCorrectUpdatePaperNumberDialogBindingInflate;
        setContentView((android.view.View) photoCorrectUpdatePaperNumberDialogBindingInflate.getRoot());
        setCancelable(false);
        photoCorrectUpdatePaperNumberDialogBindingInflate.btnLeft.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.UpdatePaperNumberDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.UpdatePaperNumberDialog._init_$lambda$0(this.f$0, view);
            }
        });
        photoCorrectUpdatePaperNumberDialogBindingInflate.btnRight.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.dialog.UpdatePaperNumberDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.dialog.UpdatePaperNumberDialog._init_$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(com.up366.mobile.course.photoanswer.dialog.UpdatePaperNumberDialog updatePaperNumberDialog, android.view.View view) {
        updatePaperNumberDialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = updatePaperNumberDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback.DefaultImpls.onCallback$default(callBack, 0, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(com.up366.mobile.course.photoanswer.dialog.UpdatePaperNumberDialog updatePaperNumberDialog, android.view.View view) {
        updatePaperNumberDialog.dismiss();
        com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback callBack = updatePaperNumberDialog.getCallBack();
        kotlin.jvm.internal.Intrinsics.checkNotNull(callBack);
        callBack.onCallback(1, java.lang.Integer.valueOf(updatePaperNumberDialog.b.wheel.getCurrentItem() + 1));
    }

    public final com.up366.mobile.course.photoanswer.dialog.UpdatePaperNumberDialog setData(com.alibaba.fastjson.JSONObject jsonObject) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        java.lang.Object obj = jsonObject.get("isA3");
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        final int iIntValue = ((java.lang.Integer) obj).intValue();
        java.lang.Object obj2 = jsonObject.get("totalPageNo");
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        final int iIntValue2 = ((java.lang.Integer) obj2).intValue();
        this.b.wheel.setAdapter(new com.up366.view.wheelview.adapter.WheelAdapter<java.lang.String>() { // from class: com.up366.mobile.course.photoanswer.dialog.UpdatePaperNumberDialog$setData$adapter$1
            @Override // com.up366.view.wheelview.adapter.WheelAdapter
            /* JADX INFO: renamed from: getItemsCount, reason: from getter */
            public int get$totalPageNo() {
                return iIntValue2;
            }

            @Override // com.up366.view.wheelview.adapter.WheelAdapter
            public java.lang.String getItem(int index) {
                if (iIntValue != 1) {
                    return "第" + (index + 1) + "页";
                }
                int i = index * 2;
                return "第" + (i + 1) + "、" + (i + 2) + "页";
            }

            @Override // com.up366.view.wheelview.adapter.WheelAdapter
            public int indexOf(java.lang.String text) {
                java.lang.String str = text;
                if (str == null || str.length() == 0) {
                    return 0;
                }
                int i = java.lang.Integer.parseInt((java.lang.String) kotlin.text.StringsKt.split$default(kotlin.text.StringsKt.replace$default(kotlin.text.StringsKt.replace$default(text, "第", "", false, 4, (java.lang.Object) null), "页", "", false, 4, (java.lang.Object) null), new java.lang.String[]{"、"}, false, 0, 6, (java.lang.Object) null).get(0)) - 1;
                return iIntValue == 1 ? i / 2 : i;
            }
        });
        this.b.wheel.setItemsVisibleCount(3);
        this.b.wheel.setCurrentItem(0);
        this.b.wheel.setCyclic(false);
        return this;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        android.view.Window window = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window);
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(attributes, "getAttributes(...)");
        attributes.gravity = 17;
        attributes.width = com.up366.common.DpUtilsUp.dp2px(280.0f);
        attributes.height = com.up366.common.DpUtilsUp.dp2px(300.0f);
        android.view.Window window2 = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window2);
        window2.getDecorView().setPadding(0, 0, 0, 0);
        android.view.Window window3 = getWindow();
        kotlin.jvm.internal.Intrinsics.checkNotNull(window3);
        window3.setAttributes(attributes);
        super.onAttachedToWindow();
    }
}
