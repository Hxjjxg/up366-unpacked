package com.up366.bottomsheet;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BottomSheetBuilder {
    private final android.app.Activity activity;
    private final com.up366.bottomsheet.BottomSheetBuilder.CustomBottomSheet bottomSheet;
    private android.view.View contentView;

    public BottomSheetBuilder(android.app.Activity activity) {
        this.bottomSheet = new com.up366.bottomsheet.BottomSheetBuilder.CustomBottomSheet(activity);
        this.activity = activity;
    }

    public com.up366.bottomsheet.BottomSheetBuilder setView(android.view.View view) {
        this.contentView = view;
        return this;
    }

    public void show() {
        this.bottomSheet.setCustomView(this.contentView);
        if (com.up366.bottomsheet.ScreenHelper.isNavigationBarExist(this.activity)) {
            this.bottomSheet.content.getLayoutParams().bottomMargin = com.up366.bottomsheet.ScreenHelper.getNavigationBarHeight(this.activity);
        }
        this.bottomSheet.showAtLocation(this.activity.getWindow().getDecorView(), 80, 0, 0);
        this.bottomSheet.setClippingEnabled(false);
    }

    public void dismiss() {
        this.bottomSheet.dismiss();
    }

    static class CustomBottomSheet extends android.widget.PopupWindow {
        private final android.view.ViewGroup content;

        public CustomBottomSheet(android.content.Context context) {
            android.view.View viewInflate = android.view.LayoutInflater.from(context).inflate(com.up366.bottomsheet.R.layout.custom_bottom_layout, (android.view.ViewGroup) null);
            this.content = (android.view.ViewGroup) viewInflate.findViewById(com.up366.bottomsheet.R.id.contentView);
            viewInflate.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.up366.bottomsheet.BottomSheetBuilder$CustomBottomSheet$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    return this.f$0.m26x19e15975(view, motionEvent);
                }
            });
            setContentView(viewInflate);
            setOutsideTouchable(true);
            setWidth(-1);
            setHeight(-1);
            setClippingEnabled(false);
            setFocusable(true);
            setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(-1342177280));
            setAnimationStyle(com.up366.bottomsheet.R.style.bottom_sheet_anim);
        }

        /* JADX INFO: renamed from: lambda$new$0$com-up366-bottomsheet-BottomSheetBuilder$CustomBottomSheet, reason: not valid java name */
        /* synthetic */ boolean m26x19e15975(android.view.View view, android.view.MotionEvent motionEvent) {
            int top = this.content.getTop();
            int y = (int) motionEvent.getY();
            if (motionEvent.getAction() == 1 && y < top) {
                dismiss();
            }
            return true;
        }

        public void setCustomView(android.view.View view) {
            this.content.addView(view, new android.view.ViewGroup.LayoutParams(-1, -2));
        }
    }
}
