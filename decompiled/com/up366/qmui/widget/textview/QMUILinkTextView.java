package com.up366.qmui.widget.textview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUILinkTextView extends com.up366.qmui.alpha.QMUIAlphaTextView implements com.up366.qmui.span.QMUIOnSpanClickListener {
    public static int AUTO_LINK_MASK_REQUIRED = 7;
    private static java.util.Set<java.lang.String> AUTO_LINK_SCHEME_INTERRUPTED = null;
    private static final long DOUBLE_TAP_TIMEOUT;
    private static final int MSG_CHECK_DOUBLE_TAP_TIMEOUT = 1000;
    private static final java.lang.String TAG = "LinkTextView";
    private static final long TAP_TIMEOUT = 200;
    private int mAutoLinkMaskCompat;
    private long mDownMillis;
    private android.content.res.ColorStateList mLinkBgColor;
    private android.content.res.ColorStateList mLinkTextColor;
    private com.up366.qmui.widget.textview.QMUILinkTextView.OnLinkClickListener mOnLinkClickListener;
    private com.up366.qmui.widget.textview.QMUILinkTextView.OnLinkLongClickListener mOnLinkLongClickListener;
    private java.lang.CharSequence mOriginText;
    private android.os.Handler mSingleTapConfirmedHandler;

    public interface OnLinkClickListener {
        void onMailLinkClick(java.lang.String str);

        void onTelLinkClick(java.lang.String str);

        void onWebUrlLinkClick(java.lang.String str);
    }

    public interface OnLinkLongClickListener {
        void onLongClick(java.lang.String str);
    }

    static {
        java.util.HashSet hashSet = new java.util.HashSet();
        AUTO_LINK_SCHEME_INTERRUPTED = hashSet;
        hashSet.add("tel");
        AUTO_LINK_SCHEME_INTERRUPTED.add("mailto");
        AUTO_LINK_SCHEME_INTERRUPTED.add("http");
        AUTO_LINK_SCHEME_INTERRUPTED.add("https");
        DOUBLE_TAP_TIMEOUT = android.view.ViewConfiguration.getDoubleTapTimeout();
    }

    public QMUILinkTextView(android.content.Context context) {
        this(context, null);
        this.mLinkBgColor = null;
        this.mLinkTextColor = androidx.core.content.ContextCompat.getColorStateList(context, com.qmuiteam.qmui.R.color.qmui_s_link_color);
    }

    public QMUILinkTextView(android.content.Context context, android.content.res.ColorStateList colorStateList, android.content.res.ColorStateList colorStateList2) {
        this(context, null);
        this.mLinkBgColor = colorStateList2;
        this.mLinkTextColor = colorStateList;
    }

    public QMUILinkTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOriginText = null;
        this.mDownMillis = 0L;
        this.mSingleTapConfirmedHandler = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.up366.qmui.widget.textview.QMUILinkTextView.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (1000 != message.what) {
                    return;
                }
                android.util.Log.d(com.up366.qmui.widget.textview.QMUILinkTextView.TAG, "handleMessage: " + message.obj);
                if (message.obj instanceof java.lang.String) {
                    java.lang.String str = (java.lang.String) message.obj;
                    if (com.up366.qmui.widget.textview.QMUILinkTextView.this.mOnLinkClickListener == null || android.text.TextUtils.isEmpty(str)) {
                        return;
                    }
                    java.lang.String lowerCase = str.toLowerCase();
                    if (lowerCase.startsWith("tel:")) {
                        com.up366.qmui.widget.textview.QMUILinkTextView.this.mOnLinkClickListener.onTelLinkClick(android.net.Uri.parse(str).getSchemeSpecificPart());
                    } else if (lowerCase.startsWith("mailto:")) {
                        com.up366.qmui.widget.textview.QMUILinkTextView.this.mOnLinkClickListener.onMailLinkClick(android.net.Uri.parse(str).getSchemeSpecificPart());
                    } else if (lowerCase.startsWith("http") || lowerCase.startsWith("https")) {
                        com.up366.qmui.widget.textview.QMUILinkTextView.this.mOnLinkClickListener.onWebUrlLinkClick(str);
                    }
                }
            }
        };
        this.mAutoLinkMaskCompat = getAutoLinkMask() | AUTO_LINK_MASK_REQUIRED;
        setAutoLinkMask(0);
        setMovementMethodCompat(com.up366.qmui.link.QMUILinkTouchMovementMethod.getInstance());
        setHighlightColor(0);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.qmuiteam.qmui.R.styleable.QMUILinkTextView);
        this.mLinkBgColor = typedArrayObtainStyledAttributes.getColorStateList(com.qmuiteam.qmui.R.styleable.QMUILinkTextView_qmui_linkBackgroundColor);
        this.mLinkTextColor = typedArrayObtainStyledAttributes.getColorStateList(com.qmuiteam.qmui.R.styleable.QMUILinkTextView_qmui_linkTextColor);
        typedArrayObtainStyledAttributes.recycle();
        java.lang.CharSequence charSequence = this.mOriginText;
        if (charSequence != null) {
            setText(charSequence);
        }
        setChangeAlphaWhenPress(false);
    }

    public void setOnLinkClickListener(com.up366.qmui.widget.textview.QMUILinkTextView.OnLinkClickListener onLinkClickListener) {
        this.mOnLinkClickListener = onLinkClickListener;
    }

    public void setOnLinkLongClickListener(com.up366.qmui.widget.textview.QMUILinkTextView.OnLinkLongClickListener onLinkLongClickListener) {
        this.mOnLinkLongClickListener = onLinkLongClickListener;
    }

    public int getAutoLinkMaskCompat() {
        return this.mAutoLinkMaskCompat;
    }

    public void setAutoLinkMaskCompat(int i) {
        this.mAutoLinkMaskCompat = i;
    }

    public void addAutoLinkMaskCompat(int i) {
        this.mAutoLinkMaskCompat = i | this.mAutoLinkMaskCompat;
    }

    public void removeAutoLinkMaskCompat(int i) {
        this.mAutoLinkMaskCompat = (~i) & this.mAutoLinkMaskCompat;
    }

    public void setLinkColor(android.content.res.ColorStateList colorStateList) {
        this.mLinkTextColor = colorStateList;
    }

    public void setText(java.lang.CharSequence charSequence, android.widget.TextView.BufferType bufferType) {
        this.mOriginText = charSequence;
        if (!android.text.TextUtils.isEmpty(charSequence)) {
            android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder(charSequence);
            com.up366.qmui.link.QMUILinkify.addLinks(spannableStringBuilder, this.mAutoLinkMaskCompat, this.mLinkTextColor, this.mLinkBgColor, this);
            charSequence = spannableStringBuilder;
        }
        super.setText(charSequence, bufferType);
    }

    @Override // com.up366.qmui.span.QMUIOnSpanClickListener
    public boolean onSpanClick(java.lang.String str) {
        if (str == null) {
            android.util.Log.w(TAG, "onSpanClick interrupt null text");
            return true;
        }
        long jUptimeMillis = android.os.SystemClock.uptimeMillis() - this.mDownMillis;
        android.util.Log.w(TAG, "onSpanClick clickUpTime: " + jUptimeMillis);
        if (this.mSingleTapConfirmedHandler.hasMessages(1000)) {
            disallowOnSpanClickInterrupt();
            return true;
        }
        if (200 < jUptimeMillis) {
            android.util.Log.w(TAG, "onSpanClick interrupted because of TAP_TIMEOUT: " + jUptimeMillis);
            return true;
        }
        java.lang.String scheme = android.net.Uri.parse(str).getScheme();
        if (scheme != null) {
            scheme = scheme.toLowerCase();
        }
        if (!AUTO_LINK_SCHEME_INTERRUPTED.contains(scheme)) {
            return false;
        }
        long j = DOUBLE_TAP_TIMEOUT - jUptimeMillis;
        this.mSingleTapConfirmedHandler.removeMessages(1000);
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 1000;
        messageObtain.obj = str;
        this.mSingleTapConfirmedHandler.sendMessageDelayed(messageObtain, j);
        return true;
    }

    @Override // com.up366.qmui.widget.textview.QMUISpanTouchFixTextView
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            boolean zHasMessages = this.mSingleTapConfirmedHandler.hasMessages(1000);
            android.util.Log.w(TAG, "onTouchEvent hasSingleTap: " + zHasMessages);
            if (!zHasMessages) {
                this.mDownMillis = android.os.SystemClock.uptimeMillis();
            } else {
                android.util.Log.w(TAG, "onTouchEvent disallow onSpanClick mSingleTapConfirmedHandler because of DOUBLE TAP");
                disallowOnSpanClickInterrupt();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void disallowOnSpanClickInterrupt() {
        this.mSingleTapConfirmedHandler.removeMessages(1000);
        this.mDownMillis = 0L;
    }

    protected boolean performSpanLongClick(java.lang.String str) {
        com.up366.qmui.widget.textview.QMUILinkTextView.OnLinkLongClickListener onLinkLongClickListener = this.mOnLinkLongClickListener;
        if (onLinkLongClickListener == null) {
            return false;
        }
        onLinkLongClickListener.onLongClick(str);
        return true;
    }

    @Override // com.up366.qmui.widget.textview.QMUISpanTouchFixTextView
    public boolean performLongClick() {
        int selectionEnd = getSelectionEnd();
        if (selectionEnd > 0) {
            return performSpanLongClick(getText().subSequence(getSelectionStart(), selectionEnd).toString()) || super.performLongClick();
        }
        return super.performLongClick();
    }
}
