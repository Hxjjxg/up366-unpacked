package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PaddingStatusBarView extends android.view.View {
    private boolean lightMode;
    private int[] location;
    private int statusBarHeight;
    private android.view.Window window;

    public PaddingStatusBarView(android.content.Context context) {
        this(context, null);
    }

    public PaddingStatusBarView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PaddingStatusBarView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.location = new int[2];
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setUpPaddingStatusBar();
        setUpStatusBarLightMode(true);
    }

    private void setUpPaddingStatusBar() {
        getLocationOnScreen(this.location);
        if (this.location[1] == 0) {
            this.statusBarHeight = 0;
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                this.statusBarHeight = getResources().getDimensionPixelSize(identifier);
            }
            if (getLayoutParams().height != this.statusBarHeight) {
                getLayoutParams().height = this.statusBarHeight;
                requestLayout();
            }
        }
    }

    public void setUpStatusBarLightMode(boolean z) {
        if (isInEditMode()) {
            return;
        }
        int i = z ? 9216 : 1024;
        if (this.window == null) {
            this.window = getActivity().getWindow();
        }
        this.window.getDecorView().setSystemUiVisibility(i);
    }

    public void setWindow(android.view.Window window) {
        this.window = window;
    }

    private void setStatusBarLightMode(boolean z) {
        this.lightMode = z;
        if (getBackground() == null) {
            setBackgroundDrawable(new android.graphics.drawable.ColorDrawable() { // from class: com.up366.mobile.common.views.PaddingStatusBarView.1
                android.graphics.Paint paint = new android.graphics.Paint(1);

                @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
                public void draw(android.graphics.Canvas canvas) {
                    if (!android.os.Build.MODEL.equals("SM-N9008S") && com.up366.mobile.common.views.PaddingStatusBarView.this.lightMode && com.up366.mobile.common.views.PaddingStatusBarView.this.location[1] == 0) {
                        this.paint.setColor(855638016);
                        this.paint.setStyle(android.graphics.Paint.Style.FILL);
                        canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), com.up366.mobile.common.views.PaddingStatusBarView.this.statusBarHeight, this.paint);
                    }
                }
            });
        }
        postInvalidate();
    }

    public android.app.Activity getActivity() {
        android.content.Context context = getContext();
        if (context instanceof android.app.Activity) {
            return (android.app.Activity) context;
        }
        if (context instanceof android.content.ContextWrapper) {
            return (android.app.Activity) ((android.content.ContextWrapper) getContext()).getBaseContext();
        }
        return com.up366.common.global.GB.get().getCurrentActivity();
    }
}
