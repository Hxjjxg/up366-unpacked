package com.up366.qmui.skin;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUISkinValueBuilder {
    public static final java.lang.String ALPHA = "alpha";
    public static final java.lang.String BACKGROUND = "background";
    public static final java.lang.String BG_TINT_COLOR = "bgTintColor";
    public static final java.lang.String BORDER = "border";
    public static final java.lang.String BOTTOM_SEPARATOR = "bottomSeparator";
    public static final java.lang.String HINT_COLOR = "hintColor";
    public static final java.lang.String LEFT_SEPARATOR = "LeftSeparator";
    public static final java.lang.String MORE_BG_COLOR = "moreBgColor";
    public static final java.lang.String MORE_TEXT_COLOR = "moreTextColor";
    public static final java.lang.String PROGRESS_COLOR = "progressColor";
    public static final java.lang.String RIGHT_SEPARATOR = "rightSeparator";
    public static final java.lang.String SECOND_TEXT_COLOR = "secondTextColor";
    public static final java.lang.String SRC = "src";
    public static final java.lang.String TEXT_COLOR = "textColor";
    public static final java.lang.String TEXT_COMPOUND_BOTTOM_SRC = "tcbSrc";
    public static final java.lang.String TEXT_COMPOUND_LEFT_SRC = "tclSrc";
    public static final java.lang.String TEXT_COMPOUND_RIGHT_SRC = "tcrSrc";
    public static final java.lang.String TEXT_COMPOUND_TINT_COLOR = "tcTintColor";
    public static final java.lang.String TEXT_COMPOUND_TOP_SRC = "tctSrc";
    public static final java.lang.String TINT_COLOR = "tintColor";
    public static final java.lang.String TOP_SEPARATOR = "topSeparator";
    public static final java.lang.String UNDERLINE = "underline";
    private static java.util.LinkedList<com.up366.qmui.skin.QMUISkinValueBuilder> sValueBuilderPool;
    private java.util.HashMap<java.lang.String, java.lang.String> mValues = new java.util.HashMap<>();

    public static com.up366.qmui.skin.QMUISkinValueBuilder acquire() {
        java.util.LinkedList<com.up366.qmui.skin.QMUISkinValueBuilder> linkedList = sValueBuilderPool;
        if (linkedList == null) {
            return new com.up366.qmui.skin.QMUISkinValueBuilder();
        }
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderPoll = linkedList.poll();
        return qMUISkinValueBuilderPoll != null ? qMUISkinValueBuilderPoll : new com.up366.qmui.skin.QMUISkinValueBuilder();
    }

    public static void release(com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilder) {
        qMUISkinValueBuilder.clear();
        if (sValueBuilderPool == null) {
            sValueBuilderPool = new java.util.LinkedList<>();
        }
        if (sValueBuilderPool.size() < 2) {
            sValueBuilderPool.push(qMUISkinValueBuilder);
        }
    }

    private QMUISkinValueBuilder() {
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder background(int i) {
        this.mValues.put("background", java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder background(java.lang.String str) {
        this.mValues.put("background", str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder underline(int i) {
        this.mValues.put(UNDERLINE, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder underline(java.lang.String str) {
        this.mValues.put(UNDERLINE, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder moreTextColor(int i) {
        this.mValues.put(MORE_TEXT_COLOR, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder moreTextColor(java.lang.String str) {
        this.mValues.put(MORE_TEXT_COLOR, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder moreBgColor(int i) {
        this.mValues.put(MORE_BG_COLOR, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder moreBgColor(java.lang.String str) {
        this.mValues.put(MORE_BG_COLOR, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder textCompoundTintColor(int i) {
        this.mValues.put(TEXT_COMPOUND_TINT_COLOR, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder textCompoundTintColor(java.lang.String str) {
        this.mValues.put(TEXT_COMPOUND_TINT_COLOR, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder textCompoundTopSrc(int i) {
        this.mValues.put(TEXT_COMPOUND_TOP_SRC, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder textCompoundTopSrc(java.lang.String str) {
        this.mValues.put(TEXT_COMPOUND_TOP_SRC, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder textCompoundRightSrc(int i) {
        this.mValues.put(TEXT_COMPOUND_RIGHT_SRC, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder textCompoundRightSrc(java.lang.String str) {
        this.mValues.put(TEXT_COMPOUND_RIGHT_SRC, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder textCompoundBottomSrc(int i) {
        this.mValues.put(TEXT_COMPOUND_BOTTOM_SRC, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder textCompoundBottomSrc(java.lang.String str) {
        this.mValues.put(TEXT_COMPOUND_BOTTOM_SRC, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder textCompoundLeftSrc(int i) {
        this.mValues.put(TEXT_COMPOUND_LEFT_SRC, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder textCompoundLeftSrc(java.lang.String str) {
        this.mValues.put(TEXT_COMPOUND_LEFT_SRC, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder textColor(int i) {
        this.mValues.put(TEXT_COLOR, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder textColor(java.lang.String str) {
        this.mValues.put(TEXT_COLOR, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder hintColor(int i) {
        this.mValues.put(HINT_COLOR, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder hintColor(java.lang.String str) {
        this.mValues.put(HINT_COLOR, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder progressColor(int i) {
        this.mValues.put(PROGRESS_COLOR, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder progressColor(java.lang.String str) {
        this.mValues.put(PROGRESS_COLOR, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder src(int i) {
        this.mValues.put(SRC, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder src(java.lang.String str) {
        this.mValues.put(SRC, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder border(int i) {
        this.mValues.put(BORDER, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder border(java.lang.String str) {
        this.mValues.put(BORDER, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder topSeparator(int i) {
        this.mValues.put(TOP_SEPARATOR, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder topSeparator(java.lang.String str) {
        this.mValues.put(TOP_SEPARATOR, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder rightSeparator(int i) {
        this.mValues.put(RIGHT_SEPARATOR, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder rightSeparator(java.lang.String str) {
        this.mValues.put(RIGHT_SEPARATOR, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder bottomSeparator(int i) {
        this.mValues.put(BOTTOM_SEPARATOR, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder bottomSeparator(java.lang.String str) {
        this.mValues.put(BOTTOM_SEPARATOR, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder leftSeparator(int i) {
        this.mValues.put(LEFT_SEPARATOR, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder leftSeparator(java.lang.String str) {
        this.mValues.put(LEFT_SEPARATOR, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder alpha(int i) {
        this.mValues.put(ALPHA, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder alpha(java.lang.String str) {
        this.mValues.put(ALPHA, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder tintColor(int i) {
        this.mValues.put(TINT_COLOR, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder tintColor(java.lang.String str) {
        this.mValues.put(TINT_COLOR, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder bgTintColor(int i) {
        this.mValues.put(BG_TINT_COLOR, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder bgTintColor(java.lang.String str) {
        this.mValues.put(BG_TINT_COLOR, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder secondTextColor(int i) {
        this.mValues.put(SECOND_TEXT_COLOR, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder secondTextColor(java.lang.String str) {
        this.mValues.put(SECOND_TEXT_COLOR, str);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder custom(java.lang.String str, int i) {
        this.mValues.put(str, java.lang.String.valueOf(i));
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder custom(java.lang.String str, java.lang.String str2) {
        this.mValues.put(str, str2);
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder clear() {
        this.mValues.clear();
        return this;
    }

    public com.up366.qmui.skin.QMUISkinValueBuilder convertFrom(java.lang.String str) {
        for (java.lang.String str2 : str.split("[|]")) {
            java.lang.String[] strArrSplit = str2.split(":");
            if (strArrSplit.length == 2) {
                this.mValues.put(strArrSplit[0].trim(), strArrSplit[1].trim());
            }
        }
        return this;
    }

    public boolean isEmpty() {
        return this.mValues.isEmpty();
    }

    public java.lang.String build() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = true;
        for (java.lang.String str : this.mValues.keySet()) {
            java.lang.String str2 = this.mValues.get(str);
            if (str2 != null && !str2.isEmpty()) {
                if (!z) {
                    sb.append("|");
                }
                sb.append(str);
                sb.append(":");
                sb.append(str2);
                z = false;
            }
        }
        return sb.toString();
    }

    public void release() {
        release(this);
    }
}
