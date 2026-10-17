package com.warkiz.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class Indicator {
    private final android.content.Context mContext;
    private android.widget.PopupWindow mIndicator;
    private com.warkiz.widget.ArrowView mIndicatorArrow;
    private int mIndicatorColor;
    private final android.view.View mIndicatorCustomTopContentView;
    private final android.view.View mIndicatorCustomView;
    private android.widget.TextView mIndicatorText;
    private final int mIndicatorTextColor;
    private final int mIndicatorTextSize;
    private final int mIndicatorType;
    private int[] mLocation = new int[2];
    private final com.warkiz.widget.IndicatorSeekBar mSeekBar;
    private android.widget.LinearLayout mTopContentView;
    private final int mWindowWidth;

    Indicator(android.content.Context context, com.warkiz.widget.IndicatorSeekBar indicatorSeekBar, com.warkiz.widget.BuilderParams builderParams) {
        this.mContext = context;
        this.mSeekBar = indicatorSeekBar;
        this.mIndicatorColor = builderParams.mIndicatorColor;
        this.mIndicatorType = builderParams.mIndicatorType;
        this.mIndicatorCustomView = builderParams.mIndicatorCustomView;
        this.mIndicatorCustomTopContentView = builderParams.mIndicatorCustomTopContentView;
        this.mIndicatorTextSize = builderParams.mIndicatorTextSize;
        this.mIndicatorTextColor = builderParams.mIndicatorTextColor;
        initIndicator();
        this.mWindowWidth = getWindowWidth();
    }

    private void initIndicator() {
        android.view.View viewFindViewById;
        android.view.View viewInflate = null;
        if (this.mIndicatorType == 2) {
            android.view.View view = this.mIndicatorCustomView;
            if (view != null) {
                int identifier = this.mContext.getResources().getIdentifier("isb_progress", com.igexin.push.core.b.C, this.mContext.getApplicationContext().getPackageName());
                if (identifier > 0 && (viewFindViewById = view.findViewById(identifier)) != null) {
                    if (viewFindViewById instanceof android.widget.TextView) {
                        android.widget.TextView textView = (android.widget.TextView) viewFindViewById;
                        this.mIndicatorText = textView;
                        textView.setText(java.lang.String.valueOf(this.mSeekBar.getProgress()));
                        this.mIndicatorText.setTextSize(com.warkiz.widget.IndicatorUtils.px2sp(this.mContext, this.mIndicatorTextSize));
                        this.mIndicatorText.setTextColor(this.mIndicatorTextColor);
                    } else {
                        throw new java.lang.ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
                    }
                }
                viewInflate = view;
            }
        } else {
            viewInflate = android.view.View.inflate(this.mContext, com.warkiz.widget.R.layout.indicator, null);
            this.mTopContentView = (android.widget.LinearLayout) viewInflate.findViewById(com.warkiz.widget.R.id.indicator_container);
            com.warkiz.widget.ArrowView arrowView = (com.warkiz.widget.ArrowView) viewInflate.findViewById(com.warkiz.widget.R.id.indicator_arrow);
            this.mIndicatorArrow = arrowView;
            arrowView.setColor(this.mIndicatorColor);
            android.widget.TextView textView2 = (android.widget.TextView) viewInflate.findViewById(com.warkiz.widget.R.id.isb_progress);
            this.mIndicatorText = textView2;
            textView2.setText(java.lang.String.valueOf(this.mSeekBar.getProgress()));
            this.mIndicatorText.setTextSize(com.warkiz.widget.IndicatorUtils.px2sp(this.mContext, this.mIndicatorTextSize));
            this.mIndicatorText.setTextColor(this.mIndicatorTextColor);
            this.mTopContentView.setBackground(getGradientDrawable());
            if (this.mIndicatorCustomTopContentView != null) {
                int identifier2 = this.mContext.getResources().getIdentifier("isb_progress", com.igexin.push.core.b.C, this.mContext.getApplicationContext().getPackageName());
                android.view.View view2 = this.mIndicatorCustomTopContentView;
                if (identifier2 > 0 && view2.findViewById(identifier2) != null) {
                    setIndicatorTopContentView(view2, identifier2);
                } else {
                    setIndicatorTopContentView(view2);
                }
            }
        }
        if (viewInflate != null) {
            viewInflate.measure(0, 0);
            this.mIndicator = new android.widget.PopupWindow(viewInflate, -2, -2, false);
        }
    }

    private android.graphics.drawable.GradientDrawable getGradientDrawable() {
        android.graphics.drawable.GradientDrawable gradientDrawable;
        if (this.mIndicatorType == 0) {
            gradientDrawable = (android.graphics.drawable.GradientDrawable) this.mContext.getResources().getDrawable(com.warkiz.widget.R.drawable.indicator_square_corners);
        } else {
            gradientDrawable = (android.graphics.drawable.GradientDrawable) this.mContext.getResources().getDrawable(com.warkiz.widget.R.drawable.indicator_rounded_corners);
        }
        gradientDrawable.setColor(this.mIndicatorColor);
        return gradientDrawable;
    }

    private int getWindowWidth() {
        return ((android.view.WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    private int getIndicatorScreenX() {
        this.mSeekBar.getLocationOnScreen(this.mLocation);
        return this.mLocation[0];
    }

    private void adjustArrow(float f) {
        if (this.mIndicatorType == 2) {
            return;
        }
        if (getIndicatorScreenX() + f < this.mIndicator.getContentView().getMeasuredWidth() / 2) {
            setMargin(-((int) (((this.mIndicator.getContentView().getMeasuredWidth() / 2) - r0) - f)), -1, -1, -1);
        } else if ((this.mWindowWidth - r0) - f < this.mIndicator.getContentView().getMeasuredWidth() / 2) {
            setMargin((int) ((this.mIndicator.getContentView().getMeasuredWidth() / 2) - ((this.mWindowWidth - r0) - f)), -1, -1, -1);
        } else {
            setMargin(0, 0, 0, 0);
        }
    }

    private void setMargin(int i, int i2, int i3, int i4) {
        com.warkiz.widget.ArrowView arrowView = this.mIndicatorArrow;
        if (arrowView != null && (arrowView.getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams)) {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) this.mIndicatorArrow.getLayoutParams();
            if (i == -1) {
                i = marginLayoutParams.leftMargin;
            }
            if (i2 == -1) {
                i2 = marginLayoutParams.topMargin;
            }
            if (i3 == -1) {
                i3 = marginLayoutParams.rightMargin;
            }
            if (i4 == -1) {
                i4 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i, i2, i3, i4);
            this.mIndicatorArrow.requestLayout();
        }
    }

    void update(float f, int i, int i2) {
        if (this.mIndicator != null) {
            if (this.mIndicatorText != null) {
                if (hasTextArray(i)) {
                    if (i2 >= this.mSeekBar.getTextArray().length) {
                        this.mIndicatorText.setText("");
                    } else {
                        this.mIndicatorText.setText(this.mSeekBar.getTextArray()[i2]);
                    }
                } else {
                    this.mIndicatorText.setText(this.mSeekBar.getProgressString());
                }
                this.mIndicator.getContentView().measure(0, 0);
            }
            this.mIndicator.update(this.mSeekBar, (int) (f - (r0.getContentView().getMeasuredWidth() / 2)), -(this.mSeekBar.getMeasuredHeight() + this.mIndicator.getContentView().getMeasuredHeight() + this.mSeekBar.getPaddingTop() + com.warkiz.widget.IndicatorUtils.dp2px(this.mContext, 2.0f)), -1, -1);
            adjustArrow(f);
        }
    }

    void showIndicator(float f, int i, int i2) {
        android.widget.PopupWindow popupWindow = this.mIndicator;
        if (popupWindow == null || popupWindow.isShowing()) {
            return;
        }
        if (this.mIndicatorText != null) {
            if (hasTextArray(i)) {
                if (i2 >= this.mSeekBar.getTextArray().length) {
                    this.mIndicatorText.setText("");
                } else {
                    this.mIndicatorText.setText(this.mSeekBar.getTextArray()[i2]);
                }
            } else {
                this.mIndicatorText.setText(this.mSeekBar.getProgressString());
            }
            this.mIndicator.getContentView().measure(0, 0);
        }
        this.mIndicator.showAsDropDown(this.mSeekBar, (int) (f - (r6.getContentView().getMeasuredWidth() / 2.0f)), -(this.mSeekBar.getMeasuredHeight() + this.mIndicator.getContentView().getMeasuredHeight() + this.mSeekBar.getPaddingTop() + com.warkiz.widget.IndicatorUtils.dp2px(this.mContext, 2.0f)));
        adjustArrow(f);
    }

    private boolean hasTextArray(int i) {
        java.lang.CharSequence[] textArray = this.mSeekBar.getTextArray();
        return i == 3 && textArray != null && textArray.length > 0;
    }

    void hideIndicator() {
        android.widget.PopupWindow popupWindow = this.mIndicator;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.mIndicator.dismiss();
    }

    public void setIndicatorTopContentView(android.view.View view) {
        this.mTopContentView.removeAllViews();
        view.setBackground(getGradientDrawable());
        this.mTopContentView.addView(view);
    }

    public void setIndicatorTopContentLayout(int i) {
        this.mTopContentView.removeAllViews();
        android.view.View viewInflate = android.view.View.inflate(this.mContext, i, null);
        viewInflate.setBackground(getGradientDrawable());
        this.mTopContentView.addView(viewInflate);
    }

    public void setIndicatorTopContentView(android.view.View view, int i) {
        android.view.View viewFindViewById = view.findViewById(i);
        if (viewFindViewById == null) {
            throw new java.lang.IllegalArgumentException(" can not find the TextView in indicator topContentView by id: " + i);
        }
        if (!(viewFindViewById instanceof android.widget.TextView)) {
            throw new java.lang.ClassCastException(" the view identified by progressTextViewId can not be cast to TextView. ");
        }
        this.mIndicatorText = (android.widget.TextView) viewFindViewById;
        this.mTopContentView.removeAllViews();
        view.setBackground(getGradientDrawable());
        this.mTopContentView.addView(view);
    }

    public boolean isShowing() {
        android.widget.PopupWindow popupWindow = this.mIndicator;
        return popupWindow != null && popupWindow.isShowing();
    }

    public void setCustomIndicator(android.view.View view) {
        this.mIndicator.setContentView(view);
    }

    public void setProgressTextView(android.widget.TextView textView) {
        this.mIndicatorText = textView;
    }
}
