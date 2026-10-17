package com.warkiz.widget;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class BuilderParams {
    int mBackgroundTrackSize;
    android.content.Context mContext;
    int mIndicatorTextSize;
    int mProgressTrackSize;
    int mTextSize;
    int mThumbSize;
    int mTickSize;
    int mSeekBarType = 0;
    float mMax = 100.0f;
    float mMin = 0.0f;
    float mProgress = 0.0f;
    boolean mClearPadding = false;
    boolean mIsFloatProgress = false;
    int mIndicatorType = 0;
    boolean mShowIndicator = true;
    int mIndicatorColor = android.graphics.Color.parseColor("#FF4081");
    int mIndicatorTextColor = android.graphics.Color.parseColor("#FFFFFF");
    android.view.View mIndicatorCustomView = null;
    android.view.View mIndicatorCustomTopContentView = null;
    int mBackgroundTrackColor = android.graphics.Color.parseColor("#D7D7D7");
    int mProgressTrackColor = android.graphics.Color.parseColor("#FF4081");
    boolean mTrackRoundedCorners = true;
    int mTickNum = 5;
    int mTickType = 1;
    int mTickColor = android.graphics.Color.parseColor("#FF4081");
    boolean mTickHideBothEnds = false;
    boolean mTickOnThumbLeftHide = false;
    android.graphics.drawable.Drawable mTickDrawable = null;
    int mTextColor = android.graphics.Color.parseColor("#FF4081");
    java.lang.String mLeftEndText = null;
    java.lang.String mRightEndText = null;
    java.lang.CharSequence[] mTextArray = null;
    int mThumbColor = android.graphics.Color.parseColor("#FF4081");
    android.graphics.drawable.Drawable mThumbDrawable = null;
    boolean mThumbProgressStay = false;

    BuilderParams(android.content.Context context) {
        this.mContext = context;
        this.mIndicatorTextSize = com.warkiz.widget.IndicatorUtils.sp2px(context, 13.0f);
        this.mBackgroundTrackSize = com.warkiz.widget.IndicatorUtils.dp2px(this.mContext, 2.0f);
        this.mProgressTrackSize = com.warkiz.widget.IndicatorUtils.dp2px(this.mContext, 2.0f);
        this.mTickSize = com.warkiz.widget.IndicatorUtils.dp2px(this.mContext, 8.0f);
        this.mTextSize = com.warkiz.widget.IndicatorUtils.sp2px(this.mContext, 13.0f);
        this.mThumbSize = com.warkiz.widget.IndicatorUtils.dp2px(this.mContext, 18.0f);
    }
}
