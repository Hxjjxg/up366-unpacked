package com.up366.multimediav2.dialog;

/* JADX INFO: compiled from: SmartCameraGuideDialog.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0010R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/up366/multimediav2/dialog/SmartCameraGuideDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "FREE_GUIDE_TIPS", "", "", "[Ljava/lang/String;", "b", "Lcom/up366/multimediav2/databinding/DialogAnswerSmartCameraGuideBinding;", "getContext", "()Landroid/content/Context;", "dialog", "Landroid/app/Dialog;", "dismiss", "", "isShowing", "", "setDismissListener", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "show", "GuidePagerAdapter", "multimediav2_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SmartCameraGuideDialog {
    private final java.lang.String[] FREE_GUIDE_TIPS;
    private final com.up366.multimediav2.databinding.DialogAnswerSmartCameraGuideBinding b;
    private final android.content.Context context;
    private final android.app.Dialog dialog;

    public SmartCameraGuideDialog(android.content.Context context) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        android.app.Dialog dialog = new android.app.Dialog(context, com.up366.multimediav2.R.style.AppDialogThemeMinWidth82);
        this.dialog = dialog;
        androidx.databinding.ViewDataBinding viewDataBindingInflate = androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.multimediav2.R.layout.dialog_answer_smart_camera_guide, (android.view.ViewGroup) null, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewDataBindingInflate, "inflate(LayoutInflater.f…amera_guide, null, false)");
        com.up366.multimediav2.databinding.DialogAnswerSmartCameraGuideBinding dialogAnswerSmartCameraGuideBinding = (com.up366.multimediav2.databinding.DialogAnswerSmartCameraGuideBinding) viewDataBindingInflate;
        this.b = dialogAnswerSmartCameraGuideBinding;
        this.FREE_GUIDE_TIPS = new java.lang.String[]{"深色背景拍摄任意纸张，剪裁只保留英文", "光线均匀，纸张上无其他物体影子", "手机与纸张尽量平行，避免图片倾斜"};
        dialog.setContentView(dialogAnswerSmartCameraGuideBinding.getRoot());
        dialog.setCanceledOnTouchOutside(false);
        dialogAnswerSmartCameraGuideBinding.ibClose.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimediav2.dialog.SmartCameraGuideDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimediav2.dialog.SmartCameraGuideDialog._init_$lambda$0(this.f$0, view);
            }
        });
        dialogAnswerSmartCameraGuideBinding.vpContentShow.setOffscreenPageLimit(1);
    }

    public final android.content.Context getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(com.up366.multimediav2.dialog.SmartCameraGuideDialog smartCameraGuideDialog, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(smartCameraGuideDialog, "this$0");
        smartCameraGuideDialog.dismiss();
    }

    public final com.up366.multimediav2.dialog.SmartCameraGuideDialog setDismissListener(android.content.DialogInterface.OnDismissListener dismissListener) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dismissListener, "dismissListener");
        this.dialog.setOnDismissListener(dismissListener);
        return this;
    }

    public final void dismiss() {
        this.dialog.dismiss();
    }

    public final boolean isShowing() {
        return this.dialog.isShowing();
    }

    public final void show() {
        com.up366.multimediav2.dialog.SmartCameraGuideDialog.GuidePagerAdapter guidePagerAdapter = new com.up366.multimediav2.dialog.SmartCameraGuideDialog.GuidePagerAdapter();
        this.b.viewPagerIndex.setCount(guidePagerAdapter.getCount());
        this.b.viewPagerIndex.setPosition(0);
        this.b.tvOperationTips.setText(this.FREE_GUIDE_TIPS[0]);
        this.b.vpContentShow.setAdapter(guidePagerAdapter);
        this.b.vpContentShow.addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener() { // from class: com.up366.multimediav2.dialog.SmartCameraGuideDialog.show.1
            public void onPageSelected(int position) {
                com.up366.multimediav2.dialog.SmartCameraGuideDialog.this.b.viewPagerIndex.setPosition(position);
                com.up366.multimediav2.dialog.SmartCameraGuideDialog.this.b.tvOperationTips.setText(com.up366.multimediav2.dialog.SmartCameraGuideDialog.this.FREE_GUIDE_TIPS[position]);
            }
        });
        this.b.vpContentShow.setCurrentItem(0, true);
        this.dialog.show();
    }

    /* JADX INFO: compiled from: SmartCameraGuideDialog.kt */
    @kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/up366/multimediav2/dialog/SmartCameraGuideDialog$GuidePagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "(Lcom/up366/multimediav2/dialog/SmartCameraGuideDialog;)V", "mapView", "Landroid/util/SparseArray;", "Landroid/view/View;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "arg", "multimediav2_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class GuidePagerAdapter extends androidx.viewpager.widget.PagerAdapter {
        private final android.util.SparseArray<android.view.View> mapView = new android.util.SparseArray<>();

        public GuidePagerAdapter() {
        }

        public int getCount() {
            return com.up366.multimediav2.dialog.SmartCameraGuideDialog.this.FREE_GUIDE_TIPS.length;
        }

        public boolean isViewFromObject(android.view.View view, java.lang.Object arg) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arg, "arg");
            return kotlin.jvm.internal.Intrinsics.areEqual(view, arg);
        }

        public void destroyItem(android.view.ViewGroup container, int position, java.lang.Object object) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(object, "object");
            container.removeView(this.mapView.get(position));
        }

        public java.lang.Object instantiateItem(android.view.ViewGroup container, int position) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
            android.view.View view = this.mapView.get(position);
            if (view == null) {
                android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
                android.view.View lottieAnimationView = new com.airbnb.lottie.LottieAnimationView(com.up366.multimediav2.dialog.SmartCameraGuideDialog.this.getContext());
                lottieAnimationView.setRepeatCount(-1);
                lottieAnimationView.setRepeatMode(1);
                android.view.View view2 = lottieAnimationView;
                ((com.airbnb.lottie.LottieAnimationView) view2).setLayoutParams(layoutParams);
                this.mapView.put(position, view2);
                view = view2;
            }
            if (position == 0) {
                ((com.airbnb.lottie.LottieAnimationView) view).setAnimation("multi_media_v2_photo_correct_guide_crop.zip");
            } else if (position == 1) {
                ((com.airbnb.lottie.LottieAnimationView) view).setAnimation("multi_media_v2_photo_correct_guide_shadow.zip");
            } else if (position == 2) {
                ((com.airbnb.lottie.LottieAnimationView) view).setAnimation("multi_media_v2_photo_correct_guide_lean.zip");
            }
            if (view instanceof com.airbnb.lottie.LottieAnimationView) {
                ((com.airbnb.lottie.LottieAnimationView) view).playAnimation();
            }
            container.addView(view);
            return view;
        }
    }
}
