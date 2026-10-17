package com.up366.qmui.qqface;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIQQFaceView extends android.view.View {
    private static final java.lang.String TAG = "QMUIQQFaceView";
    private static final java.lang.String mEllipsizeText = "...";
    private com.up366.qmui.qqface.QMUIQQFaceCompiler mCompiler;
    private int mContentCalMaxWidth;
    private int mCurrentCalLine;
    private int mCurrentCalWidth;
    private int mCurrentDrawBaseLine;
    private int mCurrentDrawLine;
    private com.up366.qmui.span.QMUITouchableSpan mCurrentDrawSpan;
    private int mCurrentDrawUsedWidth;
    private android.graphics.Paint mDecorationPaint;
    private com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList mElementList;
    private android.text.TextUtils.TruncateAt mEllipsize;
    private int mEllipsizeTextLength;
    private int mFirstBaseLine;
    private int mFontHeight;
    private int mGravity;
    private boolean mIncludePad;
    private boolean mIsExecutedMiddleEllipsize;
    private boolean mIsInDrawSpan;
    private boolean mIsNeedEllipsize;
    private boolean mIsNeedUnderlineForMoreText;
    private boolean mIsSingleLine;
    private boolean mIsTouchDownInMoreText;
    private boolean mJumpHandleMeasureAndDraw;
    private int mLastCalContentWidth;
    private int mLastCalLimitWidth;
    private int mLastCalLines;
    private int mLastNeedStopLineRecord;
    private int mLineSpace;
    private int mLines;
    private android.content.res.ColorStateList mLinkUnderLineColor;
    private int mLinkUnderLineHeight;
    private com.up366.qmui.qqface.QMUIQQFaceView.QQFaceViewListener mListener;
    private int mMaxLine;
    private int mMaxWidth;
    private int mMiddleEllipsizeWidthRecord;
    private android.content.res.ColorStateList mMoreActionBgColor;
    private android.content.res.ColorStateList mMoreActionColor;
    private java.lang.String mMoreActionText;
    private int mMoreActionTextLength;
    private android.graphics.Rect mMoreHitRect;
    private int mNeedDrawLine;
    private boolean mNeedReCalculateLines;
    private boolean mOpenQQFace;
    private java.lang.CharSequence mOriginText;
    private android.text.TextPaint mPaint;
    private int mParagraphShowCount;
    private int mParagraphSpace;
    private com.up366.qmui.qqface.QMUIQQFaceView.PressCancelAction mPendingPressCancelAction;
    private final int[] mPressedState;
    private int mQQFaceSize;
    private int mQQFaceSizeAddon;
    private java.util.HashMap<com.up366.qmui.qqface.QMUIQQFaceCompiler.Element, com.up366.qmui.qqface.QMUIQQFaceView.SpanInfo> mSpanInfos;
    private int mSpecialDrawablePadding;
    private android.content.res.ColorStateList mTextColor;
    private int mTextSize;
    com.up366.qmui.qqface.QMUIQQFaceView.SpanInfo mTouchSpanInfo;
    private android.graphics.Typeface mTypeface;
    private boolean needReCalculateFontHeight;

    public interface QQFaceViewListener {
        void onCalculateLinesChange(int i);

        void onMoreTextClick();
    }

    public QMUIQQFaceView(android.content.Context context) {
        this(context, null);
    }

    public QMUIQQFaceView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.qmuiteam.qmui.R.attr.QMUIQQFaceStyle);
    }

    public QMUIQQFaceView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOpenQQFace = true;
        this.mLineSpace = -1;
        this.mQQFaceSize = 0;
        this.mMaxLine = Integer.MAX_VALUE;
        this.mIsSingleLine = false;
        this.mLines = 0;
        this.mSpanInfos = new java.util.HashMap<>();
        this.mIsTouchDownInMoreText = false;
        this.mMoreHitRect = new android.graphics.Rect();
        this.mMoreActionTextLength = 0;
        this.mEllipsizeTextLength = 0;
        this.mEllipsize = android.text.TextUtils.TruncateAt.END;
        this.mIsNeedEllipsize = false;
        this.mNeedDrawLine = 0;
        this.mParagraphShowCount = 0;
        this.mQQFaceSizeAddon = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mPendingPressCancelAction = null;
        this.mJumpHandleMeasureAndDraw = false;
        this.mIncludePad = true;
        this.mTypeface = null;
        this.mParagraphSpace = 0;
        this.mSpecialDrawablePadding = 0;
        this.mGravity = 0;
        this.mPressedState = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        this.mIsNeedUnderlineForMoreText = false;
        this.mLinkUnderLineHeight = 1;
        this.mTouchSpanInfo = null;
        this.needReCalculateFontHeight = true;
        this.mCurrentCalWidth = 0;
        this.mCurrentCalLine = 0;
        this.mContentCalMaxWidth = 0;
        this.mNeedReCalculateLines = false;
        this.mLastCalLimitWidth = 0;
        this.mLastCalContentWidth = 0;
        this.mLastCalLines = 0;
        this.mIsInDrawSpan = false;
        this.mMiddleEllipsizeWidthRecord = -1;
        this.mIsExecutedMiddleEllipsize = false;
        this.mLastNeedStopLineRecord = -1;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUIQQFaceView, i, 0);
        this.mQQFaceSizeAddon = -com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 2);
        this.mTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIQQFaceView_android_textSize, com.up366.qmui.util.QMUIDisplayHelper.dp2px(context, 14));
        this.mTextColor = typedArrayObtainStyledAttributes.getColorStateList(com.qmuiteam.qmui.R.styleable.QMUIQQFaceView_android_textColor);
        this.mIsSingleLine = typedArrayObtainStyledAttributes.getBoolean(com.qmuiteam.qmui.R.styleable.QMUIQQFaceView_android_singleLine, false);
        this.mMaxLine = typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUIQQFaceView_android_maxLines, this.mMaxLine);
        setLineSpace(typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.qmuiteam.qmui.R.styleable.QMUIQQFaceView_android_lineSpacingExtra, 0));
        int i2 = typedArrayObtainStyledAttributes.getInt(com.qmuiteam.qmui.R.styleable.QMUIQQFaceView_android_ellipsize, -1);
        if (i2 == 1) {
            this.mEllipsize = android.text.TextUtils.TruncateAt.START;
        } else if (i2 == 2) {
            this.mEllipsize = android.text.TextUtils.TruncateAt.MIDDLE;
        } else if (i2 == 3) {
            this.mEllipsize = android.text.TextUtils.TruncateAt.END;
        } else {
            this.mEllipsize = null;
        }
        this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIQQFaceView_android_maxWidth, this.mMaxWidth);
        this.mSpecialDrawablePadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.qmuiteam.qmui.R.styleable.QMUIQQFaceView_qmui_special_drawable_padding, 0);
        java.lang.String string = typedArrayObtainStyledAttributes.getString(com.qmuiteam.qmui.R.styleable.QMUIQQFaceView_android_text);
        if (!com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(string)) {
            this.mOriginText = string;
        }
        this.mMoreActionText = typedArrayObtainStyledAttributes.getString(com.qmuiteam.qmui.R.styleable.QMUIQQFaceView_qmui_more_action_text);
        this.mMoreActionColor = typedArrayObtainStyledAttributes.getColorStateList(com.qmuiteam.qmui.R.styleable.QMUIQQFaceView_qmui_more_action_color);
        this.mMoreActionBgColor = typedArrayObtainStyledAttributes.getColorStateList(com.qmuiteam.qmui.R.styleable.QMUIQQFaceView_qmui_more_action_bg_color);
        typedArrayObtainStyledAttributes.recycle();
        android.text.TextPaint textPaint = new android.text.TextPaint();
        this.mPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.mPaint.setTextSize(this.mTextSize);
        this.mEllipsizeTextLength = (int) java.lang.Math.ceil(this.mPaint.measureText(mEllipsizeText));
        measureMoreActionTextLength();
        android.graphics.Paint paint = new android.graphics.Paint();
        this.mDecorationPaint = paint;
        paint.setAntiAlias(true);
        this.mDecorationPaint.setStyle(android.graphics.Paint.Style.FILL);
        setCompiler(com.up366.qmui.qqface.QMUIQQFaceCompiler.getDefaultInstance());
    }

    public void setOpenQQFace(boolean z) {
        this.mOpenQQFace = z;
    }

    public void setGravity(int i) {
        this.mGravity = i;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setMaxWidth(int i) {
        if (this.mMaxWidth != i) {
            this.mMaxWidth = i;
            requestLayout();
        }
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.mSpanInfos.isEmpty() && this.mMoreHitRect.isEmpty()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0 && !this.mIsTouchDownInMoreText && this.mTouchSpanInfo == null) {
            return super.onTouchEvent(motionEvent);
        }
        com.up366.qmui.qqface.QMUIQQFaceView.PressCancelAction pressCancelAction = this.mPendingPressCancelAction;
        if (pressCancelAction != null) {
            pressCancelAction.run();
            this.mPendingPressCancelAction = null;
        }
        if (action == 0) {
            this.mTouchSpanInfo = null;
            this.mIsTouchDownInMoreText = false;
            if (this.mMoreHitRect.contains(x, y)) {
                this.mIsTouchDownInMoreText = true;
                invalidate(this.mMoreHitRect);
            } else {
                java.util.Iterator<com.up366.qmui.qqface.QMUIQQFaceView.SpanInfo> it = this.mSpanInfos.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.up366.qmui.qqface.QMUIQQFaceView.SpanInfo next = it.next();
                    if (next.onTouch(x, y)) {
                        this.mTouchSpanInfo = next;
                        break;
                    }
                }
            }
            com.up366.qmui.qqface.QMUIQQFaceView.SpanInfo spanInfo = this.mTouchSpanInfo;
            if (spanInfo != null) {
                spanInfo.setPressed(true);
                this.mTouchSpanInfo.invalidateSpan();
            } else if (!this.mIsTouchDownInMoreText) {
                return super.onTouchEvent(motionEvent);
            }
        } else if (action == 1) {
            com.up366.qmui.qqface.QMUIQQFaceView.SpanInfo spanInfo2 = this.mTouchSpanInfo;
            if (spanInfo2 != null) {
                spanInfo2.onClick();
                this.mPendingPressCancelAction = new com.up366.qmui.qqface.QMUIQQFaceView.PressCancelAction(this.mTouchSpanInfo);
                postDelayed(new java.lang.Runnable() { // from class: com.up366.qmui.qqface.QMUIQQFaceView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.up366.qmui.qqface.QMUIQQFaceView.this.mPendingPressCancelAction != null) {
                            com.up366.qmui.qqface.QMUIQQFaceView.this.mPendingPressCancelAction.run();
                        }
                    }
                }, 100L);
            } else if (this.mIsTouchDownInMoreText) {
                com.up366.qmui.qqface.QMUIQQFaceView.QQFaceViewListener qQFaceViewListener = this.mListener;
                if (qQFaceViewListener != null) {
                    qQFaceViewListener.onMoreTextClick();
                } else if (isClickable()) {
                    performClick();
                }
                this.mIsTouchDownInMoreText = false;
                invalidate(this.mMoreHitRect);
            }
        } else if (action == 2) {
            com.up366.qmui.qqface.QMUIQQFaceView.SpanInfo spanInfo3 = this.mTouchSpanInfo;
            if (spanInfo3 != null && !spanInfo3.onTouch(x, y)) {
                this.mTouchSpanInfo.setPressed(false);
                this.mTouchSpanInfo.invalidateSpan();
                this.mTouchSpanInfo = null;
            } else if (this.mIsTouchDownInMoreText && !this.mMoreHitRect.contains(x, y)) {
                this.mIsTouchDownInMoreText = false;
                invalidate(this.mMoreHitRect);
            }
        } else if (action == 3) {
            this.mPendingPressCancelAction = null;
            com.up366.qmui.qqface.QMUIQQFaceView.SpanInfo spanInfo4 = this.mTouchSpanInfo;
            if (spanInfo4 != null) {
                spanInfo4.setPressed(false);
                this.mTouchSpanInfo.invalidateSpan();
            } else if (this.mIsTouchDownInMoreText) {
                this.mIsTouchDownInMoreText = false;
                invalidate(this.mMoreHitRect);
            }
        }
        return true;
    }

    public void setCompiler(com.up366.qmui.qqface.QMUIQQFaceCompiler qMUIQQFaceCompiler) {
        if (this.mCompiler != qMUIQQFaceCompiler) {
            this.mCompiler = qMUIQQFaceCompiler;
            setText(this.mOriginText, false);
        }
    }

    public void setTypeface(android.graphics.Typeface typeface) {
        if (this.mTypeface != typeface) {
            this.mTypeface = typeface;
            this.needReCalculateFontHeight = true;
            this.mPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTypeface(android.graphics.Typeface typeface, int i) {
        android.graphics.Typeface typefaceCreate;
        if (i > 0) {
            if (typeface == null) {
                typefaceCreate = android.graphics.Typeface.defaultFromStyle(i);
            } else {
                typefaceCreate = android.graphics.Typeface.create(typeface, i);
            }
            setTypeface(typefaceCreate);
            int i2 = (~(typefaceCreate != null ? typefaceCreate.getStyle() : 0)) & i;
            this.mPaint.setFakeBoldText((i2 & 1) != 0);
            this.mPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.mPaint.setFakeBoldText(false);
        this.mPaint.setTextSkewX(0.0f);
        setTypeface(typeface);
    }

    public void setParagraphSpace(int i) {
        if (this.mParagraphSpace != i) {
            this.mParagraphSpace = i;
            requestLayout();
            invalidate();
        }
    }

    public void setMoreActionText(java.lang.String str) {
        java.lang.String str2 = this.mMoreActionText;
        if (str2 == null || !str2.equals(str)) {
            this.mMoreActionText = str;
            measureMoreActionTextLength();
            requestLayout();
            invalidate();
        }
    }

    public void setLinkUnderLineColor(int i) {
        setLinkUnderLineColor(android.content.res.ColorStateList.valueOf(i));
    }

    public void setLinkUnderLineColor(android.content.res.ColorStateList colorStateList) {
        if (this.mLinkUnderLineColor != colorStateList) {
            this.mLinkUnderLineColor = colorStateList;
            invalidate();
        }
    }

    public void setLinkUnderLineHeight(int i) {
        if (this.mLinkUnderLineHeight != i) {
            this.mLinkUnderLineHeight = i;
            invalidate();
        }
    }

    public void setNeedUnderlineForMoreText(boolean z) {
        if (this.mIsNeedUnderlineForMoreText != z) {
            this.mIsNeedUnderlineForMoreText = z;
            invalidate();
        }
    }

    public void setMoreActionColor(int i) {
        setMoreActionColor(android.content.res.ColorStateList.valueOf(i));
    }

    public void setMoreActionColor(android.content.res.ColorStateList colorStateList) {
        if (this.mMoreActionColor != colorStateList) {
            this.mMoreActionColor = colorStateList;
            invalidate();
        }
    }

    public void setMoreActionBgColor(int i) {
        setMoreActionBgColor(android.content.res.ColorStateList.valueOf(i));
    }

    public void setMoreActionBgColor(android.content.res.ColorStateList colorStateList) {
        if (this.mMoreActionBgColor != colorStateList) {
            this.mMoreActionBgColor = colorStateList;
            invalidate();
        }
    }

    private void measureMoreActionTextLength() {
        if (com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(this.mMoreActionText)) {
            this.mMoreActionTextLength = 0;
        } else {
            this.mMoreActionTextLength = (int) java.lang.Math.ceil(this.mPaint.measureText(this.mMoreActionText));
        }
    }

    public void setSpecialDrawablePadding(int i) {
        if (this.mSpecialDrawablePadding != i) {
            this.mSpecialDrawablePadding = i;
            requestLayout();
            invalidate();
        }
    }

    public void setIncludeFontPadding(boolean z) {
        if (this.mIncludePad != z) {
            this.needReCalculateFontHeight = true;
            this.mIncludePad = z;
            requestLayout();
            invalidate();
        }
    }

    public void setQQFaceSizeAddon(int i) {
        if (this.mQQFaceSizeAddon != i) {
            this.mQQFaceSizeAddon = i;
            this.mNeedReCalculateLines = true;
            requestLayout();
            invalidate();
        }
    }

    public void setLineSpace(int i) {
        if (this.mLineSpace != i) {
            this.mLineSpace = i;
            requestLayout();
            invalidate();
        }
    }

    public void setEllipsize(android.text.TextUtils.TruncateAt truncateAt) {
        if (this.mEllipsize != truncateAt) {
            this.mEllipsize = truncateAt;
            requestLayout();
            invalidate();
        }
    }

    public void setMaxLine(int i) {
        if (this.mMaxLine != i) {
            this.mMaxLine = i;
            requestLayout();
            invalidate();
        }
    }

    public int getMaxLine() {
        return this.mMaxLine;
    }

    public int getLineCount() {
        return this.mLines;
    }

    public boolean isNeedEllipsize() {
        return this.mIsNeedEllipsize;
    }

    public void setSingleLine(boolean z) {
        if (this.mIsSingleLine != z) {
            this.mIsSingleLine = z;
            requestLayout();
            invalidate();
        }
    }

    public void setTextColor(int i) {
        setTextColor(android.content.res.ColorStateList.valueOf(i));
    }

    public void setTextColor(android.content.res.ColorStateList colorStateList) {
        if (this.mTextColor != colorStateList) {
            this.mTextColor = colorStateList;
            invalidate();
        }
    }

    public android.text.TextPaint getPaint() {
        return this.mPaint;
    }

    public void setTextSize(int i) {
        if (this.mTextSize != i) {
            this.mTextSize = i;
            this.mPaint.setTextSize(i);
            this.needReCalculateFontHeight = true;
            this.mNeedReCalculateLines = true;
            this.mEllipsizeTextLength = (int) java.lang.Math.ceil(this.mPaint.measureText(mEllipsizeText));
            measureMoreActionTextLength();
            requestLayout();
            invalidate();
        }
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public java.lang.CharSequence getText() {
        return this.mOriginText;
    }

    public android.graphics.Rect getMoreHitRect() {
        return this.mMoreHitRect;
    }

    public void setText(java.lang.CharSequence charSequence) {
        setText(charSequence, true);
    }

    private void setText(java.lang.CharSequence charSequence, boolean z) {
        com.up366.qmui.qqface.QMUIQQFaceCompiler qMUIQQFaceCompiler;
        if (z && com.up366.qmui.util.QMUILangHelper.objectEquals(charSequence, this.mOriginText)) {
            return;
        }
        this.mOriginText = charSequence;
        setContentDescription(charSequence);
        if (this.mOpenQQFace && this.mCompiler == null) {
            throw new java.lang.RuntimeException("mCompiler == null");
        }
        this.mSpanInfos.clear();
        if (com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(this.mOriginText)) {
            this.mElementList = null;
            requestLayout();
            invalidate();
            return;
        }
        if (this.mOpenQQFace && (qMUIQQFaceCompiler = this.mCompiler) != null) {
            com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList elementListCompile = qMUIQQFaceCompiler.compile(this.mOriginText);
            this.mElementList = elementListCompile;
            java.util.List<com.up366.qmui.qqface.QMUIQQFaceCompiler.Element> elements = elementListCompile.getElements();
            if (elements != null) {
                for (int i = 0; i < elements.size(); i++) {
                    com.up366.qmui.qqface.QMUIQQFaceCompiler.Element element = elements.get(i);
                    if (element.getType() == com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.SPAN) {
                        this.mSpanInfos.put(element, new com.up366.qmui.qqface.QMUIQQFaceView.SpanInfo(element.getTouchableSpan()));
                    }
                }
            }
        } else {
            this.mElementList = new com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList(0, this.mOriginText.length());
            java.lang.String[] strArrSplit = this.mOriginText.toString().split("\\n");
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                this.mElementList.add(com.up366.qmui.qqface.QMUIQQFaceCompiler.Element.createTextElement(strArrSplit[i2]));
                if (i2 != strArrSplit.length - 1) {
                    this.mElementList.add(com.up366.qmui.qqface.QMUIQQFaceCompiler.Element.createNextLineElement());
                }
            }
        }
        this.mNeedReCalculateLines = true;
        if (getLayoutParams() == null) {
            return;
        }
        if (getLayoutParams().width == -2 || getLayoutParams().height == -2) {
            requestLayout();
            invalidate();
            return;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (getWidth() <= paddingLeft || getHeight() <= paddingBottom) {
            return;
        }
        this.mLines = 0;
        calculateLinesAndContentWidth(getWidth());
        int i3 = this.mNeedDrawLine;
        int height = getHeight() - paddingBottom;
        int i4 = this.mLineSpace;
        calculateNeedDrawLine(java.lang.Math.min((height + i4) / (this.mFontHeight + i4), this.mMaxLine));
        if (i3 == this.mNeedDrawLine) {
            invalidate();
        } else {
            requestLayout();
            invalidate();
        }
    }

    protected int calculateFontHeight() {
        if (this.needReCalculateFontHeight) {
            android.graphics.Paint.FontMetricsInt fontMetricsInt = this.mPaint.getFontMetricsInt();
            if (fontMetricsInt == null) {
                this.mQQFaceSize = 0;
                this.mFontHeight = 0;
            } else {
                this.needReCalculateFontHeight = false;
                int fontHeightCalTop = getFontHeightCalTop(fontMetricsInt, this.mIncludePad);
                int fontHeightCalBottom = getFontHeightCalBottom(fontMetricsInt, this.mIncludePad) - fontHeightCalTop;
                this.mQQFaceSize = this.mQQFaceSizeAddon + fontHeightCalBottom;
                int iMax = java.lang.Math.max(this.mQQFaceSize, this.mCompiler.getSpecialBoundsMaxHeight());
                if (fontHeightCalBottom >= iMax) {
                    this.mFontHeight = fontHeightCalBottom;
                    this.mFirstBaseLine = -fontHeightCalTop;
                } else {
                    this.mFontHeight = iMax;
                    this.mFirstBaseLine = (-fontHeightCalTop) + ((iMax - fontHeightCalBottom) / 2);
                }
            }
        }
        return this.mFontHeight;
    }

    public int getFontHeight() {
        return this.mFontHeight;
    }

    public int getLineSpace() {
        return this.mLineSpace;
    }

    protected int getFontHeightCalTop(android.graphics.Paint.FontMetricsInt fontMetricsInt, boolean z) {
        return z ? fontMetricsInt.top : fontMetricsInt.ascent;
    }

    protected int getFontHeightCalBottom(android.graphics.Paint.FontMetricsInt fontMetricsInt, boolean z) {
        return z ? fontMetricsInt.bottom : fontMetricsInt.descent;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        if (getPaddingLeft() != i || getPaddingRight() != i3) {
            this.mNeedReCalculateLines = true;
        }
        super.setPadding(i, i2, i3, i4);
    }

    protected int calculateLinesAndContentWidth(int i) {
        if (i <= getPaddingRight() + getPaddingLeft() || isElementEmpty()) {
            this.mLines = 0;
            this.mParagraphShowCount = 0;
            this.mLastCalLines = 0;
            this.mLastCalContentWidth = 0;
            return 0;
        }
        if (!this.mNeedReCalculateLines && this.mLastCalLimitWidth == i) {
            this.mLines = this.mLastCalLines;
            return this.mLastCalContentWidth;
        }
        this.mLastCalLimitWidth = i;
        java.util.List<com.up366.qmui.qqface.QMUIQQFaceCompiler.Element> elements = this.mElementList.getElements();
        this.mCurrentCalLine = 1;
        this.mCurrentCalWidth = getPaddingLeft();
        calculateLinesInner(elements, i);
        int i2 = this.mCurrentCalLine;
        if (i2 != this.mLines) {
            com.up366.qmui.qqface.QMUIQQFaceView.QQFaceViewListener qQFaceViewListener = this.mListener;
            if (qQFaceViewListener != null) {
                qQFaceViewListener.onCalculateLinesChange(i2);
            }
            this.mLines = this.mCurrentCalLine;
        }
        if (this.mLines == 1) {
            this.mLastCalContentWidth = this.mCurrentCalWidth + getPaddingRight();
        } else {
            this.mLastCalContentWidth = i;
        }
        this.mLastCalLines = this.mLines;
        return this.mLastCalContentWidth;
    }

    private void calculateNeedDrawLine(int i) {
        int i2 = this.mLines;
        this.mNeedDrawLine = i2;
        if (this.mIsSingleLine) {
            this.mNeedDrawLine = java.lang.Math.min(1, i2);
        } else if (i < i2) {
            this.mNeedDrawLine = i;
        }
        this.mIsNeedEllipsize = this.mLines > this.mNeedDrawLine;
    }

    private void calculateLinesInner(java.util.List<com.up366.qmui.qqface.QMUIQQFaceCompiler.Element> list, int i) {
        int i2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i - getPaddingRight();
        for (int i3 = 0; i3 < list.size() && !this.mJumpHandleMeasureAndDraw; i3++) {
            if (this.mCurrentCalLine > this.mMaxLine) {
                android.text.TextUtils.TruncateAt truncateAt = android.text.TextUtils.TruncateAt.END;
            }
            com.up366.qmui.qqface.QMUIQQFaceCompiler.Element element = list.get(i3);
            if (element.getType() == com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.DRAWABLE) {
                int i4 = this.mCurrentCalWidth;
                int i5 = this.mQQFaceSize;
                if (i4 + i5 > paddingRight) {
                    gotoCalNextLine(paddingLeft);
                    this.mCurrentCalWidth += this.mQQFaceSize;
                } else if (i4 + i5 == paddingRight) {
                    gotoCalNextLine(paddingLeft);
                } else {
                    this.mCurrentCalWidth = i4 + i5;
                }
                if (paddingRight - paddingLeft < this.mQQFaceSize) {
                    this.mJumpHandleMeasureAndDraw = true;
                }
            } else if (element.getType() == com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.TEXT) {
                measureText(element.getText(), paddingLeft, paddingRight);
            } else if (element.getType() == com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.SPAN) {
                com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList childList = element.getChildList();
                com.up366.qmui.span.QMUITouchableSpan touchableSpan = element.getTouchableSpan();
                if (childList != null && childList.getElements().size() > 0) {
                    if (touchableSpan == null) {
                        calculateLinesInner(childList.getElements(), i);
                    } else {
                        calculateLinesInner(childList.getElements(), i);
                    }
                }
            } else if (element.getType() == com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.NEXTLINE) {
                gotoCalNextLine(paddingLeft, true);
            } else if (element.getType() == com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.SPECIAL_BOUNDS_DRAWABLE) {
                int intrinsicWidth = element.getSpecialBoundsDrawable().getIntrinsicWidth();
                if (i3 == 0 || i3 == list.size() - 1) {
                    i2 = this.mSpecialDrawablePadding;
                } else {
                    i2 = this.mSpecialDrawablePadding * 2;
                }
                int i6 = intrinsicWidth + i2;
                int i7 = this.mCurrentCalWidth;
                if (i7 + i6 > paddingRight) {
                    gotoCalNextLine(paddingLeft);
                    this.mCurrentCalWidth += i6;
                } else if (i7 + i6 == paddingRight) {
                    gotoCalNextLine(paddingLeft);
                } else {
                    this.mCurrentCalWidth = i7 + i6;
                }
                if (paddingRight - paddingLeft < i6) {
                    this.mJumpHandleMeasureAndDraw = true;
                }
            }
        }
    }

    private boolean isElementEmpty() {
        com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList elementList = this.mElementList;
        return elementList == null || elementList.getElements() == null || this.mElementList.getElements().isEmpty();
    }

    private void setContentCalMaxWidth(int i) {
        this.mContentCalMaxWidth = java.lang.Math.max(i, this.mContentCalMaxWidth);
    }

    private void gotoCalNextLine(int i) {
        gotoCalNextLine(i, false);
    }

    private void gotoCalNextLine(int i, boolean z) {
        this.mCurrentCalLine++;
        setContentCalMaxWidth(this.mCurrentCalWidth);
        this.mCurrentCalWidth = i;
        if (z) {
            android.text.TextUtils.TruncateAt truncateAt = this.mEllipsize;
            if (truncateAt == null) {
                this.mParagraphShowCount++;
            } else {
                if (truncateAt != android.text.TextUtils.TruncateAt.END || this.mCurrentCalLine > this.mMaxLine) {
                    return;
                }
                this.mParagraphShowCount++;
            }
        }
    }

    private void measureText(java.lang.CharSequence charSequence, int i, int i2) {
        int length = charSequence.length();
        float[] fArr = new float[length];
        this.mPaint.getTextWidths(charSequence.toString(), fArr);
        int i3 = i2 - i;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        for (int i4 = 0; i4 < length; i4++) {
            if (i3 < fArr[i4]) {
                this.mJumpHandleMeasureAndDraw = true;
                return;
            }
            if (java.lang.System.currentTimeMillis() - jCurrentTimeMillis > 2000) {
                com.up366.qmui.QMUILog.d(TAG, "measureText: text = %s, mCurrentCalWidth = %d, widthStart = %d, widthEnd = %d", charSequence, java.lang.Integer.valueOf(this.mCurrentCalWidth), java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
                this.mJumpHandleMeasureAndDraw = true;
                return;
            } else {
                if (this.mCurrentCalWidth + fArr[i4] > i2) {
                    gotoCalNextLine(i);
                }
                this.mCurrentCalWidth = (int) (((double) this.mCurrentCalWidth) + java.lang.Math.ceil(fArr[i4]));
            }
        }
    }

    public void setListener(com.up366.qmui.qqface.QMUIQQFaceView.QQFaceViewListener qQFaceViewListener) {
        this.mListener = qQFaceViewListener;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingTop;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        this.mJumpHandleMeasureAndDraw = false;
        calculateFontHeight();
        int mode = android.view.View.MeasureSpec.getMode(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        this.mLines = 0;
        this.mParagraphShowCount = 0;
        if (mode != 0 && mode != 1073741824) {
            java.lang.CharSequence charSequence = this.mOriginText;
            size = (charSequence == null || charSequence.length() == 0) ? 0 : calculateLinesAndContentWidth(java.lang.Math.min(size, this.mMaxWidth));
        } else {
            calculateLinesAndContentWidth(size);
        }
        if (this.mJumpHandleMeasureAndDraw) {
            setMeasuredDimension(size, mode2 != Integer.MIN_VALUE ? size2 : 0);
            return;
        }
        int iMin = this.mMaxLine;
        if (mode2 == Integer.MIN_VALUE) {
            int paddingTop2 = (size2 - getPaddingTop()) - getPaddingBottom();
            int i9 = this.mLineSpace;
            iMin = java.lang.Math.min((paddingTop2 + i9) / (this.mFontHeight + i9), this.mMaxLine);
            calculateNeedDrawLine(iMin);
            paddingTop = getPaddingTop() + getPaddingBottom();
            i3 = this.mNeedDrawLine;
            if (i3 < 2) {
                i7 = this.mFontHeight;
                i8 = i3 * i7;
            } else {
                int i10 = this.mFontHeight;
                i4 = ((i3 - 1) * (this.mLineSpace + i10)) + i10;
                i5 = this.mParagraphShowCount;
                i6 = this.mParagraphSpace;
                i8 = i4 + (i5 * i6);
            }
        } else if (mode2 != 1073741824) {
            calculateNeedDrawLine(iMin);
            paddingTop = getPaddingTop() + getPaddingBottom();
            i3 = this.mNeedDrawLine;
            if (i3 < 2) {
                i7 = this.mFontHeight;
                i8 = i3 * i7;
            } else {
                int i11 = this.mFontHeight;
                i4 = ((i3 - 1) * (this.mLineSpace + i11)) + i11;
                i5 = this.mParagraphShowCount;
                i6 = this.mParagraphSpace;
                i8 = i4 + (i5 * i6);
            }
        } else {
            int paddingTop3 = (size2 - getPaddingTop()) - getPaddingBottom();
            int i12 = this.mLineSpace;
            iMin = java.lang.Math.min((paddingTop3 + i12) / (this.mFontHeight + i12), this.mMaxLine);
            calculateNeedDrawLine(iMin);
            setMeasuredDimension(size, size2);
            android.util.Log.v(TAG, "mLines = " + this.mLines + " ; width = " + size + " ; height = " + size2 + " ; maxLine = " + iMin + "; measure time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        }
        size2 = paddingTop + i8;
        setMeasuredDimension(size, size2);
        android.util.Log.v(TAG, "mLines = " + this.mLines + " ; width = " + size + " ; height = " + size2 + " ; maxLine = " + iMin + "; measure time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        if (this.mJumpHandleMeasureAndDraw || this.mOriginText == null || this.mLines == 0 || isElementEmpty()) {
            return;
        }
        pickTextPaintColor();
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.List<com.up366.qmui.qqface.QMUIQQFaceCompiler.Element> elements = this.mElementList.getElements();
        this.mCurrentDrawBaseLine = getPaddingTop() + this.mFirstBaseLine;
        this.mCurrentDrawLine = 1;
        setStartDrawUsedWidth(getPaddingLeft(), (getWidth() - getPaddingLeft()) - getPaddingRight());
        this.mIsExecutedMiddleEllipsize = false;
        drawElements(canvas, elements, (getWidth() - getPaddingLeft()) - getPaddingRight());
        android.util.Log.v(TAG, "onDraw spend time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private void pickTextPaintColor() {
        android.content.res.ColorStateList colorStateList = this.mTextColor;
        if (colorStateList != null) {
            int defaultColor = colorStateList.getDefaultColor();
            if (isPressed()) {
                this.mPaint.setColor(this.mTextColor.getColorForState(this.mPressedState, defaultColor));
            } else {
                this.mPaint.setColor(defaultColor);
            }
        }
    }

    private void drawElements(android.graphics.Canvas canvas, java.util.List<com.up366.qmui.qqface.QMUIQQFaceCompiler.Element> list, int i) {
        int normalTextColor;
        int paddingLeft = getPaddingLeft();
        int i2 = i + paddingLeft;
        if (this.mIsNeedEllipsize && this.mEllipsize == android.text.TextUtils.TruncateAt.START) {
            canvas.drawText(mEllipsizeText, 0, 3, paddingLeft, this.mFirstBaseLine, (android.graphics.Paint) this.mPaint);
        }
        int i3 = 0;
        while (i3 < list.size()) {
            com.up366.qmui.qqface.QMUIQQFaceCompiler.Element element = list.get(i3);
            com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType type = element.getType();
            if (type == com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.DRAWABLE) {
                onDrawQQFace(canvas, element.getDrawableRes(), null, paddingLeft, i2, i3 == 0, i3 == list.size() - 1);
            } else if (type == com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.SPECIAL_BOUNDS_DRAWABLE) {
                onDrawQQFace(canvas, 0, element.getSpecialBoundsDrawable(), paddingLeft, i2, i3 == 0, i3 == list.size() - 1);
            } else if (type == com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.TEXT) {
                java.lang.CharSequence text = element.getText();
                float[] fArr = new float[text.length()];
                this.mPaint.getTextWidths(text.toString(), fArr);
                onDrawText(canvas, text, fArr, 0, paddingLeft, i2);
            } else if (type == com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.SPAN) {
                com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList childList = element.getChildList();
                this.mCurrentDrawSpan = element.getTouchableSpan();
                com.up366.qmui.qqface.QMUIQQFaceView.SpanInfo spanInfo = this.mSpanInfos.get(element);
                if (childList != null && !childList.getElements().isEmpty()) {
                    if (this.mCurrentDrawSpan == null) {
                        drawElements(canvas, childList.getElements(), i);
                    } else {
                        this.mIsInDrawSpan = true;
                        if (spanInfo != null) {
                            spanInfo.setStart(this.mCurrentDrawLine, this.mCurrentDrawUsedWidth);
                        }
                        if (this.mCurrentDrawSpan.isPressed()) {
                            normalTextColor = this.mCurrentDrawSpan.getPressedTextColor();
                        } else {
                            normalTextColor = this.mCurrentDrawSpan.getNormalTextColor();
                        }
                        if (normalTextColor == 0) {
                            pickTextPaintColor();
                        } else {
                            this.mPaint.setColor(normalTextColor);
                        }
                        drawElements(canvas, childList.getElements(), i);
                        pickTextPaintColor();
                        if (spanInfo != null) {
                            spanInfo.setEnd(this.mCurrentDrawLine, this.mCurrentDrawUsedWidth);
                        }
                        this.mIsInDrawSpan = false;
                    }
                }
            } else if (type == com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.NEXTLINE) {
                int i4 = this.mEllipsizeTextLength + this.mMoreActionTextLength;
                if (this.mIsNeedEllipsize && this.mEllipsize == android.text.TextUtils.TruncateAt.END && this.mCurrentDrawUsedWidth <= i2 - i4 && this.mCurrentDrawLine == this.mNeedDrawLine) {
                    drawText(canvas, mEllipsizeText, 0, 3, this.mEllipsizeTextLength);
                    this.mCurrentDrawUsedWidth += this.mEllipsizeTextLength;
                    drawMoreActionText(canvas, i2);
                    return;
                }
                toNewDrawLine(paddingLeft, true, i);
            } else {
                continue;
            }
            i3++;
        }
    }

    private void drawMoreActionText(android.graphics.Canvas canvas, int i) {
        int defaultColor;
        if (com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(this.mMoreActionText)) {
            return;
        }
        android.content.res.ColorStateList colorStateList = this.mMoreActionColor;
        if (colorStateList == null) {
            colorStateList = this.mTextColor;
        }
        int defaultColor2 = 0;
        if (colorStateList != null) {
            defaultColor = colorStateList.getDefaultColor();
            if (this.mIsTouchDownInMoreText) {
                defaultColor = colorStateList.getColorForState(this.mPressedState, defaultColor);
            }
        } else {
            defaultColor = 0;
        }
        android.content.res.ColorStateList colorStateList2 = this.mMoreActionBgColor;
        if (colorStateList2 != null) {
            defaultColor2 = colorStateList2.getDefaultColor();
            if (this.mIsTouchDownInMoreText) {
                defaultColor2 = this.mMoreActionBgColor.getColorForState(this.mPressedState, defaultColor2);
            }
        }
        int paddingTop = getPaddingTop();
        int i2 = this.mCurrentDrawLine;
        if (i2 > 1) {
            paddingTop += (i2 - 1) * (this.mFontHeight + this.mLineSpace);
        }
        android.graphics.Rect rect = this.mMoreHitRect;
        int i3 = this.mCurrentDrawUsedWidth;
        rect.set(i3, paddingTop, this.mMoreActionTextLength + i3, this.mFontHeight + paddingTop);
        if (defaultColor2 != 0) {
            this.mDecorationPaint.setColor(defaultColor2);
            this.mDecorationPaint.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawRect(this.mMoreHitRect, this.mDecorationPaint);
        }
        this.mPaint.setColor(defaultColor);
        java.lang.String str = this.mMoreActionText;
        canvas.drawText(str, 0, str.length(), this.mCurrentDrawUsedWidth, this.mCurrentDrawBaseLine, (android.graphics.Paint) this.mPaint);
        if (this.mIsNeedUnderlineForMoreText && this.mLinkUnderLineHeight > 0) {
            android.content.res.ColorStateList colorStateList3 = this.mLinkUnderLineColor;
            if (colorStateList3 == null) {
                colorStateList3 = this.mTextColor;
            }
            if (colorStateList3 != null) {
                int defaultColor3 = colorStateList3.getDefaultColor();
                if (this.mIsTouchDownInMoreText) {
                    defaultColor3 = colorStateList3.getColorForState(this.mPressedState, defaultColor3);
                }
                this.mDecorationPaint.setColor(defaultColor3);
                this.mDecorationPaint.setStyle(android.graphics.Paint.Style.STROKE);
                this.mDecorationPaint.setStrokeWidth(this.mLinkUnderLineHeight);
                canvas.drawLine(this.mMoreHitRect.left, this.mMoreHitRect.bottom, this.mMoreHitRect.right, this.mMoreHitRect.bottom, this.mDecorationPaint);
            }
        }
        pickTextPaintColor();
    }

    private void toNewDrawLine(int i, int i2) {
        toNewDrawLine(i, false, i2);
    }

    private void toNewDrawLine(int i, boolean z, int i2) {
        android.text.TextUtils.TruncateAt truncateAt;
        int i3 = ((z && ((truncateAt = this.mEllipsize) == null || truncateAt == android.text.TextUtils.TruncateAt.END)) ? this.mParagraphSpace : 0) + this.mLineSpace;
        this.mCurrentDrawLine++;
        if (this.mIsNeedEllipsize) {
            if (this.mEllipsize == android.text.TextUtils.TruncateAt.START) {
                if (this.mCurrentDrawLine > (this.mLines - this.mNeedDrawLine) + 1) {
                    this.mCurrentDrawBaseLine += this.mFontHeight + i3;
                }
            } else if (this.mEllipsize != android.text.TextUtils.TruncateAt.MIDDLE || !this.mIsExecutedMiddleEllipsize || this.mMiddleEllipsizeWidthRecord == -1) {
                this.mCurrentDrawBaseLine += this.mFontHeight + i3;
            }
            android.text.TextUtils.TruncateAt truncateAt2 = this.mEllipsize;
            if (truncateAt2 != null && truncateAt2 != android.text.TextUtils.TruncateAt.END && this.mCurrentDrawBaseLine > getHeight() - getPaddingBottom()) {
                com.up366.qmui.QMUILog.d(TAG, "draw outside the visible height, the ellipsize is inaccurate: mEllipsize = %s; mCurrentDrawLine = %d; mNeedDrawLine = %d;viewWidth = %d; viewHeight = %d; paddingLeft = %d; paddingRight = %d; paddingTop = %d; paddingBottom = %d; text = %s", this.mEllipsize.name(), java.lang.Integer.valueOf(this.mCurrentDrawLine), java.lang.Integer.valueOf(this.mNeedDrawLine), java.lang.Integer.valueOf(getWidth()), java.lang.Integer.valueOf(getHeight()), java.lang.Integer.valueOf(getPaddingLeft()), java.lang.Integer.valueOf(getPaddingRight()), java.lang.Integer.valueOf(getPaddingTop()), java.lang.Integer.valueOf(getPaddingBottom()), this.mOriginText);
            }
        } else {
            this.mCurrentDrawBaseLine += this.mFontHeight + i3;
        }
        setStartDrawUsedWidth(i, i2);
    }

    private void setStartDrawUsedWidth(int i, int i2) {
        if (this.mIsNeedEllipsize) {
            this.mCurrentDrawUsedWidth = i;
            return;
        }
        if (this.mCurrentDrawLine == this.mNeedDrawLine) {
            int i3 = this.mGravity;
            if (i3 == 17) {
                this.mCurrentDrawUsedWidth = ((i2 - (this.mCurrentCalWidth - i)) / 2) + i;
                return;
            } else if (i3 == 5) {
                this.mCurrentDrawUsedWidth = (i2 - (this.mCurrentCalWidth - i)) + i;
                return;
            } else {
                this.mCurrentDrawUsedWidth = i;
                return;
            }
        }
        this.mCurrentDrawUsedWidth = i;
    }

    private void onRealDrawText(android.graphics.Canvas canvas, java.lang.CharSequence charSequence, float[] fArr, int i, int i2, int i3) {
        int i4 = this.mCurrentDrawUsedWidth;
        int i5 = i;
        while (i < fArr.length) {
            if (i4 + fArr[i] > i3) {
                drawText(canvas, charSequence, i5, i, i3 - this.mCurrentDrawUsedWidth);
                toNewDrawLine(i2, i3 - i2);
                i4 = this.mCurrentDrawUsedWidth;
                i5 = i;
            }
            i4 = (int) (i4 + fArr[i]);
            i++;
        }
        if (i5 < fArr.length) {
            drawText(canvas, charSequence, i5, fArr.length, i4 - this.mCurrentDrawUsedWidth);
            this.mCurrentDrawUsedWidth = i4;
        }
    }

    private int getMiddleEllipsizeLine() {
        int i = this.mNeedDrawLine;
        if (i % 2 == 0) {
            return i / 2;
        }
        return (i + 1) / 2;
    }

    private void onDrawText(android.graphics.Canvas canvas, java.lang.CharSequence charSequence, float[] fArr, int i, int i2, int i3) {
        int i4 = i;
        if (i4 >= charSequence.length()) {
            return;
        }
        if (this.mIsNeedEllipsize) {
            if (this.mEllipsize == android.text.TextUtils.TruncateAt.START) {
                int i5 = this.mCurrentDrawLine;
                int i6 = this.mLines;
                int i7 = this.mNeedDrawLine;
                if (i5 > i6 - i7) {
                    onRealDrawText(canvas, charSequence, fArr, i, i2, i3);
                    return;
                }
                if (i5 < i6 - i7) {
                    while (i4 < charSequence.length()) {
                        int i8 = this.mCurrentDrawUsedWidth;
                        float f = fArr[i4];
                        if (i8 + f <= i3) {
                            this.mCurrentDrawUsedWidth = (int) (i8 + f);
                            i4++;
                        } else {
                            toNewDrawLine(i2, i3 - i2);
                            onDrawText(canvas, charSequence, fArr, i4, i2, i3);
                            return;
                        }
                    }
                    return;
                }
                int i9 = this.mCurrentCalWidth + this.mEllipsizeTextLength;
                while (i4 < charSequence.length()) {
                    int i10 = this.mCurrentDrawUsedWidth;
                    float f2 = fArr[i4];
                    if (i10 + f2 <= i9) {
                        this.mCurrentDrawUsedWidth = (int) (i10 + f2);
                        i4++;
                    } else {
                        int i11 = i4 + 1;
                        if (i10 <= i9) {
                            i4 = i11;
                        }
                        toNewDrawLine(this.mEllipsizeTextLength + i2, i3 - i2);
                        onDrawText(canvas, charSequence, fArr, i4, i2, i3);
                        return;
                    }
                }
                return;
            }
            if (this.mEllipsize == android.text.TextUtils.TruncateAt.MIDDLE) {
                int middleEllipsizeLine = getMiddleEllipsizeLine();
                int i12 = this.mCurrentDrawLine;
                if (i12 < middleEllipsizeLine) {
                    int i13 = this.mCurrentDrawUsedWidth;
                    for (int i14 = i4; i14 < fArr.length; i14++) {
                        float f3 = i13;
                        float f4 = fArr[i14];
                        if (f3 + f4 > i3) {
                            int i15 = i14;
                            drawText(canvas, charSequence, i, i15, i3 - this.mCurrentDrawUsedWidth);
                            toNewDrawLine(i2, i3 - i2);
                            onDrawText(canvas, charSequence, fArr, i15, i2, i3);
                            return;
                        }
                        i13 = (int) (f3 + f4);
                    }
                    drawText(canvas, charSequence, i, charSequence.length(), i13 - this.mCurrentDrawUsedWidth);
                    this.mCurrentDrawUsedWidth = i13;
                    return;
                }
                if (i12 == middleEllipsizeLine) {
                    if (this.mIsExecutedMiddleEllipsize) {
                        handleTextAfterMiddleEllipsize(canvas, charSequence, fArr, i, middleEllipsizeLine, i2, i3);
                        return;
                    }
                    int i16 = ((i3 + i2) / 2) - (this.mEllipsizeTextLength / 2);
                    int i17 = this.mCurrentDrawUsedWidth;
                    for (int i18 = i4; i18 < fArr.length; i18++) {
                        float f5 = i17;
                        float f6 = fArr[i18];
                        if (f5 + f6 > i16) {
                            drawText(canvas, charSequence, i, i18, i17 - this.mCurrentDrawUsedWidth);
                            this.mCurrentDrawUsedWidth = i17;
                            drawText(canvas, mEllipsizeText, 0, 3, this.mEllipsizeTextLength);
                            this.mMiddleEllipsizeWidthRecord = this.mCurrentDrawUsedWidth + this.mEllipsizeTextLength;
                            this.mIsExecutedMiddleEllipsize = true;
                            handleTextAfterMiddleEllipsize(canvas, charSequence, fArr, i18, middleEllipsizeLine, i2, i3);
                            return;
                        }
                        i17 = (int) (f5 + f6);
                    }
                    drawText(canvas, charSequence, i, charSequence.length(), i17 - this.mCurrentDrawUsedWidth);
                    this.mCurrentDrawUsedWidth = i17;
                    return;
                }
                handleTextAfterMiddleEllipsize(canvas, charSequence, fArr, i, middleEllipsizeLine, i2, i3);
                return;
            }
            int i19 = this.mCurrentDrawLine;
            int i20 = this.mNeedDrawLine;
            if (i19 < i20) {
                int i21 = this.mCurrentDrawUsedWidth;
                for (int i22 = i4; i22 < fArr.length; i22++) {
                    float f7 = i21;
                    float f8 = fArr[i22];
                    if (f7 + f8 > i3) {
                        int i23 = i22;
                        drawText(canvas, charSequence, i, i23, i3 - this.mCurrentDrawUsedWidth);
                        toNewDrawLine(i2, i3 - i2);
                        onDrawText(canvas, charSequence, fArr, i23, i2, i3);
                        return;
                    }
                    i21 = (int) (f7 + f8);
                }
                drawText(canvas, charSequence, i, fArr.length, i21 - this.mCurrentDrawUsedWidth);
                this.mCurrentDrawUsedWidth = i21;
                return;
            }
            if (i19 == i20) {
                int i24 = this.mMoreActionTextLength;
                if (this.mEllipsize == android.text.TextUtils.TruncateAt.END) {
                    i24 += this.mEllipsizeTextLength;
                }
                int i25 = this.mCurrentDrawUsedWidth;
                for (int i26 = i4; i26 < fArr.length; i26++) {
                    float f9 = i25;
                    float f10 = fArr[i26];
                    if (f9 + f10 > i3 - i24) {
                        drawText(canvas, charSequence, i, i26, i25 - this.mCurrentDrawUsedWidth);
                        this.mCurrentDrawUsedWidth = i25;
                        if (this.mEllipsize == android.text.TextUtils.TruncateAt.END) {
                            drawText(canvas, mEllipsizeText, 0, 3, this.mEllipsizeTextLength);
                            this.mCurrentDrawUsedWidth += this.mEllipsizeTextLength;
                        }
                        drawMoreActionText(canvas, i3);
                        toNewDrawLine(i2, i3 - i2);
                        return;
                    }
                    i25 = (int) (f9 + f10);
                }
                drawText(canvas, charSequence, i, fArr.length, i25 - this.mCurrentDrawUsedWidth);
                this.mCurrentDrawUsedWidth = i25;
                return;
            }
            return;
        }
        onRealDrawText(canvas, charSequence, fArr, 0, i2, i3);
    }

    private void handleTextAfterMiddleEllipsize(android.graphics.Canvas canvas, java.lang.CharSequence charSequence, float[] fArr, int i, int i2, int i3, int i4) {
        int i5 = i;
        if (i5 >= charSequence.length()) {
            return;
        }
        int i6 = this.mMiddleEllipsizeWidthRecord;
        if (i6 == -1) {
            onRealDrawText(canvas, charSequence, fArr, i, i3, i4);
            return;
        }
        int i7 = this.mNeedDrawLine - i2;
        int i8 = this.mCurrentCalWidth;
        int i9 = (i4 - i8) - (i6 - i3);
        int i10 = this.mLines - i7;
        if (i9 > 0) {
            i10--;
        }
        int i11 = i9 > 0 ? i4 - i9 : i6 - (i4 - i8);
        int i12 = this.mCurrentDrawLine;
        if (i12 < i10) {
            while (i5 < fArr.length) {
                int i13 = this.mCurrentDrawUsedWidth;
                float f = fArr[i5];
                if (i13 + f <= i4) {
                    this.mCurrentDrawUsedWidth = (int) (i13 + f);
                    i5++;
                } else {
                    toNewDrawLine(i3, i3 - i4);
                    handleTextAfterMiddleEllipsize(canvas, charSequence, fArr, i5, i2, i3, i4);
                    return;
                }
            }
            return;
        }
        if (i12 == i10) {
            while (i5 < fArr.length) {
                int i14 = this.mCurrentDrawUsedWidth;
                float f2 = fArr[i5];
                if (i14 + f2 <= i11) {
                    this.mCurrentDrawUsedWidth = (int) (i14 + f2);
                    i5++;
                } else {
                    int i15 = i5 + 1;
                    if (i14 < i11) {
                        i5 = i15;
                    }
                    this.mCurrentDrawUsedWidth = this.mMiddleEllipsizeWidthRecord;
                    this.mMiddleEllipsizeWidthRecord = -1;
                    this.mLastNeedStopLineRecord = i10;
                    onRealDrawText(canvas, charSequence, fArr, i5, i3, i4);
                    return;
                }
            }
            return;
        }
        onRealDrawText(canvas, charSequence, fArr, i, i3, i4);
    }

    private void drawText(android.graphics.Canvas canvas, java.lang.CharSequence charSequence, int i, int i2, int i3) {
        com.up366.qmui.span.QMUITouchableSpan qMUITouchableSpan;
        com.up366.qmui.span.QMUITouchableSpan qMUITouchableSpan2;
        if (i2 <= i || i2 > charSequence.length() || i >= charSequence.length()) {
            return;
        }
        if (this.mIsInDrawSpan && (qMUITouchableSpan2 = this.mCurrentDrawSpan) != null) {
            int pressedBackgroundColor = qMUITouchableSpan2.isPressed() ? this.mCurrentDrawSpan.getPressedBackgroundColor() : this.mCurrentDrawSpan.getNormalBackgroundColor();
            if (pressedBackgroundColor != 0) {
                this.mDecorationPaint.setColor(pressedBackgroundColor);
                this.mDecorationPaint.setStyle(android.graphics.Paint.Style.FILL);
                int i4 = this.mCurrentDrawUsedWidth;
                int i5 = this.mCurrentDrawBaseLine;
                int i6 = this.mFirstBaseLine;
                canvas.drawRect(i4, i5 - i6, i4 + i3, (i5 - i6) + this.mFontHeight, this.mDecorationPaint);
            }
        }
        canvas.drawText(charSequence, i, i2, this.mCurrentDrawUsedWidth, this.mCurrentDrawBaseLine, this.mPaint);
        if (!this.mIsInDrawSpan || (qMUITouchableSpan = this.mCurrentDrawSpan) == null || !qMUITouchableSpan.isNeedUnderline() || this.mLinkUnderLineHeight <= 0) {
            return;
        }
        android.content.res.ColorStateList colorStateList = this.mLinkUnderLineColor;
        if (colorStateList == null) {
            colorStateList = this.mTextColor;
        }
        if (colorStateList != null) {
            int defaultColor = colorStateList.getDefaultColor();
            if (this.mCurrentDrawSpan.isPressed()) {
                defaultColor = colorStateList.getColorForState(this.mPressedState, defaultColor);
            }
            this.mDecorationPaint.setColor(defaultColor);
            this.mDecorationPaint.setStyle(android.graphics.Paint.Style.STROKE);
            this.mDecorationPaint.setStrokeWidth(this.mLinkUnderLineHeight);
            int i7 = (this.mCurrentDrawBaseLine - this.mFirstBaseLine) + this.mFontHeight;
            float f = i7;
            canvas.drawLine(this.mCurrentDrawUsedWidth, f, r11 + i3, f, this.mDecorationPaint);
        }
    }

    private void onDrawQQFace(android.graphics.Canvas canvas, int i, android.graphics.drawable.Drawable drawable, int i2, int i3, boolean z, boolean z2) {
        int intrinsicWidth;
        if (i != -1 || drawable == null) {
            intrinsicWidth = this.mQQFaceSize;
        } else {
            intrinsicWidth = drawable.getIntrinsicWidth() + ((z || z2) ? this.mSpecialDrawablePadding : this.mSpecialDrawablePadding * 2);
        }
        int i4 = intrinsicWidth;
        if (this.mIsNeedEllipsize) {
            if (this.mEllipsize == android.text.TextUtils.TruncateAt.START) {
                int i5 = this.mCurrentDrawLine;
                int i6 = this.mLines;
                int i7 = this.mNeedDrawLine;
                if (i5 > i6 - i7) {
                    onRealDrawQQFace(canvas, i, drawable, i7 - i6, i2, i3, z, z2);
                    return;
                }
                if (i5 < i6 - i7) {
                    int i8 = this.mCurrentDrawUsedWidth;
                    if (i4 + i8 > i3) {
                        toNewDrawLine(i2, i3 - i2);
                        onDrawQQFace(canvas, i, drawable, i2, i3, z, z2);
                        return;
                    } else {
                        this.mCurrentDrawUsedWidth = i8 + i4;
                        return;
                    }
                }
                int i9 = this.mCurrentCalWidth;
                int i10 = this.mEllipsizeTextLength;
                int i11 = i9 + i10;
                int i12 = this.mCurrentDrawUsedWidth;
                if (i4 + i12 < i11) {
                    this.mCurrentDrawUsedWidth = i12 + i4;
                    return;
                } else {
                    toNewDrawLine(i2 + i10, i3 - i2);
                    return;
                }
            }
            if (this.mEllipsize == android.text.TextUtils.TruncateAt.MIDDLE) {
                int middleEllipsizeLine = getMiddleEllipsizeLine();
                int i13 = this.mCurrentDrawLine;
                if (i13 < middleEllipsizeLine) {
                    if (this.mCurrentDrawUsedWidth + i4 > i3) {
                        onRealDrawQQFace(canvas, i, drawable, 0, i2, i3, z, z2);
                        return;
                    } else {
                        drawQQFace(canvas, i, drawable, i13, z, z2);
                        this.mCurrentDrawUsedWidth += i4;
                        return;
                    }
                }
                if (i13 == middleEllipsizeLine) {
                    int width = getWidth() / 2;
                    int i14 = this.mEllipsizeTextLength;
                    int i15 = width - (i14 / 2);
                    if (this.mIsExecutedMiddleEllipsize) {
                        handleQQFaceAfterMiddleEllipsize(canvas, i, drawable, i2, i3, middleEllipsizeLine, z, z2);
                        return;
                    }
                    if (this.mCurrentDrawUsedWidth + i4 <= i15) {
                        drawQQFace(canvas, i, drawable, this.mCurrentDrawLine, z, z2);
                        this.mCurrentDrawUsedWidth += i4;
                        return;
                    } else {
                        drawText(canvas, mEllipsizeText, 0, 3, i14);
                        this.mMiddleEllipsizeWidthRecord = this.mCurrentDrawUsedWidth + this.mEllipsizeTextLength;
                        this.mIsExecutedMiddleEllipsize = true;
                        handleQQFaceAfterMiddleEllipsize(canvas, i, drawable, i2, i3, middleEllipsizeLine, z, z2);
                        return;
                    }
                }
                handleQQFaceAfterMiddleEllipsize(canvas, i, drawable, i2, i3, middleEllipsizeLine, z, z2);
                return;
            }
            int i16 = this.mCurrentDrawLine;
            int i17 = this.mNeedDrawLine;
            if (i16 != i17) {
                if (i16 < i17) {
                    if (this.mCurrentDrawUsedWidth + i4 > i3) {
                        onRealDrawQQFace(canvas, i, drawable, 0, i2, i3, z, z2);
                        return;
                    } else {
                        drawQQFace(canvas, i, drawable, i16, z, z2);
                        this.mCurrentDrawUsedWidth += i4;
                        return;
                    }
                }
                return;
            }
            int i18 = this.mMoreActionTextLength;
            if (this.mEllipsize == android.text.TextUtils.TruncateAt.END) {
                i18 += this.mEllipsizeTextLength;
            }
            int i19 = this.mCurrentDrawUsedWidth;
            int i20 = i3 - i18;
            if (i4 + i19 >= i20) {
                if (i19 + i4 == i20) {
                    drawQQFace(canvas, i, drawable, this.mCurrentDrawLine, z, z2);
                    this.mCurrentDrawUsedWidth += i4;
                }
                if (this.mEllipsize == android.text.TextUtils.TruncateAt.END) {
                    drawText(canvas, mEllipsizeText, 0, 3, this.mEllipsizeTextLength);
                    this.mCurrentDrawUsedWidth += this.mEllipsizeTextLength;
                }
                drawMoreActionText(canvas, i3);
                toNewDrawLine(i2, i3 - i2);
                return;
            }
            drawQQFace(canvas, i, drawable, this.mCurrentDrawLine, z, z2);
            this.mCurrentDrawUsedWidth += i4;
            return;
        }
        onRealDrawQQFace(canvas, i, drawable, 0, i2, i3, z, z2);
    }

    private void handleQQFaceAfterMiddleEllipsize(android.graphics.Canvas canvas, int i, android.graphics.drawable.Drawable drawable, int i2, int i3, int i4, boolean z, boolean z2) {
        int intrinsicWidth;
        if (i != 0) {
            intrinsicWidth = this.mQQFaceSize;
        } else {
            intrinsicWidth = drawable.getIntrinsicWidth() + ((z || z2) ? this.mSpecialDrawablePadding : this.mSpecialDrawablePadding * 2);
        }
        int i5 = this.mMiddleEllipsizeWidthRecord;
        if (i5 == -1) {
            onRealDrawQQFace(canvas, i, drawable, i4 - this.mLastNeedStopLineRecord, i2, i3, z, z2);
            return;
        }
        int i6 = this.mNeedDrawLine - i4;
        int i7 = this.mCurrentCalWidth;
        int i8 = (i3 - i7) - (i5 - i2);
        int i9 = this.mLines - i6;
        if (i8 > 0) {
            i9--;
        }
        int i10 = i8 > 0 ? i3 - i8 : i5 - (i3 - i7);
        int i11 = this.mCurrentDrawLine;
        if (i11 < i9) {
            int i12 = this.mCurrentDrawUsedWidth;
            if (intrinsicWidth + i12 > i3) {
                toNewDrawLine(i2, i3 - i2);
                onDrawQQFace(canvas, i, drawable, i2, i3, z, z2);
                return;
            } else {
                this.mCurrentDrawUsedWidth = i12 + intrinsicWidth;
                return;
            }
        }
        if (i11 == i9) {
            int i13 = this.mCurrentDrawUsedWidth;
            if (intrinsicWidth + i13 <= i10) {
                this.mCurrentDrawUsedWidth = i13 + intrinsicWidth;
                return;
            }
            boolean z3 = i13 >= i10;
            this.mCurrentDrawUsedWidth = i5;
            this.mMiddleEllipsizeWidthRecord = -1;
            this.mLastNeedStopLineRecord = i9;
            if (z3) {
                onDrawQQFace(canvas, i, drawable, i2, i3, z, z2);
                return;
            }
            return;
        }
        onRealDrawQQFace(canvas, i, drawable, i4 - i9, i2, i3, z, z2);
    }

    private void onRealDrawQQFace(android.graphics.Canvas canvas, int i, android.graphics.drawable.Drawable drawable, int i2, int i3, int i4, boolean z, boolean z2) {
        int intrinsicWidth;
        if (i != 0 || drawable == null) {
            intrinsicWidth = this.mQQFaceSize;
        } else {
            intrinsicWidth = drawable.getIntrinsicWidth() + ((z || z2) ? this.mSpecialDrawablePadding : this.mSpecialDrawablePadding * 2);
        }
        int i5 = intrinsicWidth;
        if (this.mCurrentDrawUsedWidth + i5 > i4) {
            toNewDrawLine(i3, i4 - i3);
        }
        drawQQFace(canvas, i, drawable, this.mCurrentDrawLine + i2, z, z2);
        this.mCurrentDrawUsedWidth += i5;
    }

    private void drawQQFace(android.graphics.Canvas canvas, int i, android.graphics.drawable.Drawable drawable, int i2, boolean z, boolean z2) {
        int intrinsicWidth;
        com.up366.qmui.span.QMUITouchableSpan qMUITouchableSpan;
        com.up366.qmui.span.QMUITouchableSpan qMUITouchableSpan2;
        android.graphics.drawable.Drawable drawable2 = i != 0 ? androidx.core.content.ContextCompat.getDrawable(getContext(), i) : drawable;
        if (i != 0 || drawable == null) {
            intrinsicWidth = this.mQQFaceSize;
        } else {
            intrinsicWidth = drawable.getIntrinsicWidth() + ((z || z2) ? this.mSpecialDrawablePadding : this.mSpecialDrawablePadding * 2);
        }
        if (drawable2 == null) {
            return;
        }
        if (i != 0) {
            int i3 = this.mFontHeight;
            int i4 = this.mQQFaceSize;
            int i5 = (i3 - i4) / 2;
            drawable2.setBounds(0, i5, i4, i5 + i4);
        } else {
            int i6 = z2 ? this.mSpecialDrawablePadding : 0;
            int intrinsicWidth2 = drawable2.getIntrinsicWidth();
            int intrinsicHeight = drawable2.getIntrinsicHeight();
            int i7 = this.mFontHeight;
            if (intrinsicHeight > i7) {
                intrinsicWidth2 = (int) (intrinsicWidth2 * (i7 / intrinsicHeight));
                intrinsicHeight = i7;
            }
            int i8 = (i7 - intrinsicHeight) / 2;
            drawable2.setBounds(i6, i8, intrinsicWidth2 + i6, intrinsicHeight + i8);
        }
        int paddingTop = getPaddingTop();
        if (i2 > 1) {
            paddingTop = this.mCurrentDrawBaseLine - this.mFirstBaseLine;
        }
        canvas.save();
        canvas.translate(this.mCurrentDrawUsedWidth, paddingTop);
        if (this.mIsInDrawSpan && (qMUITouchableSpan2 = this.mCurrentDrawSpan) != null) {
            int pressedBackgroundColor = qMUITouchableSpan2.isPressed() ? this.mCurrentDrawSpan.getPressedBackgroundColor() : this.mCurrentDrawSpan.getNormalBackgroundColor();
            if (pressedBackgroundColor != 0) {
                this.mDecorationPaint.setColor(pressedBackgroundColor);
                this.mDecorationPaint.setStyle(android.graphics.Paint.Style.FILL);
                canvas.drawRect(0.0f, 0.0f, intrinsicWidth, this.mFontHeight, this.mDecorationPaint);
            }
        }
        drawable2.draw(canvas);
        if (this.mIsInDrawSpan && (qMUITouchableSpan = this.mCurrentDrawSpan) != null && qMUITouchableSpan.isNeedUnderline() && this.mLinkUnderLineHeight > 0) {
            android.content.res.ColorStateList colorStateList = this.mLinkUnderLineColor;
            if (colorStateList == null) {
                colorStateList = this.mTextColor;
            }
            if (colorStateList != null) {
                int defaultColor = colorStateList.getDefaultColor();
                if (this.mCurrentDrawSpan.isPressed()) {
                    defaultColor = colorStateList.getColorForState(this.mPressedState, defaultColor);
                }
                this.mDecorationPaint.setColor(defaultColor);
                this.mDecorationPaint.setStyle(android.graphics.Paint.Style.STROKE);
                this.mDecorationPaint.setStrokeWidth(this.mLinkUnderLineHeight);
                int i9 = this.mFontHeight;
                canvas.drawLine(0.0f, i9, intrinsicWidth, i9, this.mDecorationPaint);
            }
        }
        canvas.restore();
    }

    private class SpanInfo {
        public static final int NOT_SET = -1;
        private com.up366.qmui.link.ITouchableSpan mTouchableSpan;
        private int mStartPoint = -1;
        private int mEndPoint = -1;
        private int mStartLine = -1;
        private int mEndLine = -1;

        public SpanInfo(com.up366.qmui.link.ITouchableSpan iTouchableSpan) {
            this.mTouchableSpan = iTouchableSpan;
        }

        public void setStart(int i, int i2) {
            this.mStartLine = i;
            this.mStartPoint = i2;
        }

        public void setPressed(boolean z) {
            this.mTouchableSpan.setPressed(z);
        }

        public void setEnd(int i, int i2) {
            this.mEndLine = i;
            this.mEndPoint = i2;
        }

        public void onClick() {
            this.mTouchableSpan.onClick(com.up366.qmui.qqface.QMUIQQFaceView.this);
        }

        public void invalidateSpan() {
            int paddingTop = com.up366.qmui.qqface.QMUIQQFaceView.this.getPaddingTop();
            int i = this.mStartLine;
            if (i > 1) {
                paddingTop += (i - 1) * (com.up366.qmui.qqface.QMUIQQFaceView.this.mFontHeight + com.up366.qmui.qqface.QMUIQQFaceView.this.mLineSpace);
            }
            int i2 = ((this.mEndLine - 1) * (com.up366.qmui.qqface.QMUIQQFaceView.this.mFontHeight + com.up366.qmui.qqface.QMUIQQFaceView.this.mLineSpace)) + paddingTop + com.up366.qmui.qqface.QMUIQQFaceView.this.mFontHeight;
            android.graphics.Rect rect = new android.graphics.Rect();
            rect.top = paddingTop;
            rect.bottom = i2;
            rect.left = com.up366.qmui.qqface.QMUIQQFaceView.this.getPaddingLeft();
            rect.right = com.up366.qmui.qqface.QMUIQQFaceView.this.getWidth() - com.up366.qmui.qqface.QMUIQQFaceView.this.getPaddingRight();
            if (this.mStartLine == this.mEndLine) {
                rect.left = this.mStartPoint;
                rect.right = this.mEndPoint;
            }
            com.up366.qmui.qqface.QMUIQQFaceView.this.invalidate(rect);
        }

        public boolean onTouch(int i, int i2) {
            int paddingTop = com.up366.qmui.qqface.QMUIQQFaceView.this.getPaddingTop();
            int i3 = this.mStartLine;
            if (i3 > 1) {
                paddingTop += (i3 - 1) * (com.up366.qmui.qqface.QMUIQQFaceView.this.mFontHeight + com.up366.qmui.qqface.QMUIQQFaceView.this.mLineSpace);
            }
            int paddingTop2 = ((this.mEndLine - 1) * (com.up366.qmui.qqface.QMUIQQFaceView.this.mFontHeight + com.up366.qmui.qqface.QMUIQQFaceView.this.mLineSpace)) + com.up366.qmui.qqface.QMUIQQFaceView.this.getPaddingTop() + com.up366.qmui.qqface.QMUIQQFaceView.this.mFontHeight;
            if (i2 < paddingTop || i2 > paddingTop2) {
                return false;
            }
            if (this.mStartLine == this.mEndLine) {
                return i >= this.mStartPoint && i <= this.mEndPoint;
            }
            int i4 = paddingTop + com.up366.qmui.qqface.QMUIQQFaceView.this.mFontHeight;
            int i5 = paddingTop2 - com.up366.qmui.qqface.QMUIQQFaceView.this.mFontHeight;
            if (i2 <= i4 || i2 >= i5) {
                return i2 <= i4 ? i >= this.mStartPoint : i <= this.mEndPoint;
            }
            if (this.mEndLine - this.mStartLine == 1) {
                return i >= this.mStartPoint && i <= this.mEndPoint;
            }
            return true;
        }
    }

    public static class PressCancelAction implements java.lang.Runnable {
        private java.lang.ref.WeakReference<com.up366.qmui.qqface.QMUIQQFaceView.SpanInfo> mWeakReference;

        public PressCancelAction(com.up366.qmui.qqface.QMUIQQFaceView.SpanInfo spanInfo) {
            this.mWeakReference = new java.lang.ref.WeakReference<>(spanInfo);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.up366.qmui.qqface.QMUIQQFaceView.SpanInfo spanInfo = this.mWeakReference.get();
            if (spanInfo != null) {
                spanInfo.setPressed(false);
                spanInfo.invalidateSpan();
            }
        }
    }
}
