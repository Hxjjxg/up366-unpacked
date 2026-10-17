package com.up366.qmui.qqface;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIQQFaceCompiler {
    private static final int SPAN_COLUMN = 2;
    private android.util.LruCache<java.lang.CharSequence, com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList> mCache = new android.util.LruCache<>(30);
    private com.up366.qmui.qqface.IQMUIQQFaceManager mQQFaceManager;
    private static final java.util.Map<com.up366.qmui.qqface.IQMUIQQFaceManager, com.up366.qmui.qqface.QMUIQQFaceCompiler> sInstanceMap = new java.util.HashMap(4);
    private static com.up366.qmui.qqface.IQMUIQQFaceManager sDefaultQQFaceManager = new com.up366.qmui.qqface.QMUINoQQFaceManager();

    public enum ElementType {
        TEXT,
        DRAWABLE,
        SPECIAL_BOUNDS_DRAWABLE,
        SPAN,
        NEXTLINE
    }

    public static void setDefaultQQFaceManager(com.up366.qmui.qqface.IQMUIQQFaceManager iQMUIQQFaceManager) {
        sDefaultQQFaceManager = iQMUIQQFaceManager;
    }

    public static com.up366.qmui.qqface.QMUIQQFaceCompiler getDefaultInstance() {
        return getInstance(sDefaultQQFaceManager);
    }

    public static com.up366.qmui.qqface.QMUIQQFaceCompiler getInstance(com.up366.qmui.qqface.IQMUIQQFaceManager iQMUIQQFaceManager) {
        java.util.Map<com.up366.qmui.qqface.IQMUIQQFaceManager, com.up366.qmui.qqface.QMUIQQFaceCompiler> map = sInstanceMap;
        com.up366.qmui.qqface.QMUIQQFaceCompiler qMUIQQFaceCompiler = map.get(iQMUIQQFaceManager);
        if (qMUIQQFaceCompiler != null) {
            return qMUIQQFaceCompiler;
        }
        com.up366.qmui.qqface.QMUIQQFaceCompiler qMUIQQFaceCompiler2 = new com.up366.qmui.qqface.QMUIQQFaceCompiler(iQMUIQQFaceManager);
        map.put(iQMUIQQFaceManager, qMUIQQFaceCompiler2);
        return qMUIQQFaceCompiler2;
    }

    private QMUIQQFaceCompiler(com.up366.qmui.qqface.IQMUIQQFaceManager iQMUIQQFaceManager) {
        this.mQQFaceManager = iQMUIQQFaceManager;
    }

    public int getSpecialBoundsMaxHeight() {
        return this.mQQFaceManager.getSpecialDrawableMaxHeight();
    }

    public com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList compile(java.lang.CharSequence charSequence) {
        if (com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(charSequence)) {
            return null;
        }
        return compile(charSequence, 0, charSequence.length());
    }

    public com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList compile(java.lang.CharSequence charSequence, int i, int i2) {
        return compile(charSequence, i, i2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList compile(java.lang.CharSequence charSequence, int i, int i2, boolean z) {
        com.up366.qmui.span.QMUITouchableSpan[] qMUITouchableSpanArr;
        int[] iArr;
        int[] iArr2 = null;
        if (com.up366.qmui.util.QMUILangHelper.isNullOrEmpty(charSequence)) {
            return null;
        }
        if (i < 0 || i >= charSequence.length()) {
            throw new java.lang.IllegalArgumentException("start must >= 0 and < text.length");
        }
        if (i2 <= i) {
            throw new java.lang.IllegalArgumentException("end must > start");
        }
        int length = charSequence.length();
        int i3 = i2 > length ? length : i2;
        int i4 = 0;
        if (z || !(charSequence instanceof android.text.Spannable)) {
            qMUITouchableSpanArr = null;
            iArr = null;
        } else {
            final android.text.Spannable spannable = (android.text.Spannable) charSequence;
            com.up366.qmui.span.QMUITouchableSpan[] qMUITouchableSpanArr2 = (com.up366.qmui.span.QMUITouchableSpan[]) spannable.getSpans(0, charSequence.length() - 1, com.up366.qmui.span.QMUITouchableSpan.class);
            java.util.Arrays.sort(qMUITouchableSpanArr2, new java.util.Comparator<com.up366.qmui.span.QMUITouchableSpan>() { // from class: com.up366.qmui.qqface.QMUIQQFaceCompiler.1
                @Override // java.util.Comparator
                public int compare(com.up366.qmui.span.QMUITouchableSpan qMUITouchableSpan, com.up366.qmui.span.QMUITouchableSpan qMUITouchableSpan2) {
                    int spanStart = spannable.getSpanStart(qMUITouchableSpan);
                    int spanStart2 = spannable.getSpanStart(qMUITouchableSpan2);
                    if (spanStart > spanStart2) {
                        return 1;
                    }
                    return spanStart == spanStart2 ? 0 : -1;
                }
            });
            int i5 = qMUITouchableSpanArr2.length > 0 ? 1 : 0;
            if (i5 != 0) {
                iArr2 = new int[qMUITouchableSpanArr2.length * 2];
                while (i4 < qMUITouchableSpanArr2.length) {
                    int i6 = i4 * 2;
                    iArr2[i6] = spannable.getSpanStart(qMUITouchableSpanArr2[i4]);
                    iArr2[i6 + 1] = spannable.getSpanEnd(qMUITouchableSpanArr2[i4]);
                    i4++;
                }
            }
            qMUITouchableSpanArr = qMUITouchableSpanArr2;
            iArr = iArr2;
            i4 = i5;
        }
        com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList elementList = this.mCache.get(charSequence);
        if (i4 == 0 && elementList != null && i == elementList.getStart() && i3 == elementList.getEnd()) {
            return elementList;
        }
        com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList elementListRealCompile = realCompile(charSequence, i, i3, qMUITouchableSpanArr, iArr);
        this.mCache.put(charSequence, elementListRealCompile);
        return elementListRealCompile;
    }

    public void setCache(android.util.LruCache<java.lang.CharSequence, com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList> lruCache) {
        this.mCache = lruCache;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList realCompile(java.lang.CharSequence r18, int r19, int r20, com.up366.qmui.span.QMUITouchableSpan[] r21, int[] r22) {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.qmui.qqface.QMUIQQFaceCompiler.realCompile(java.lang.CharSequence, int, int, com.up366.qmui.span.QMUITouchableSpan[], int[]):com.up366.qmui.qqface.QMUIQQFaceCompiler$ElementList");
    }

    public static class Element {
        private com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList mChildList;
        private int mDrawableRes;
        private android.graphics.drawable.Drawable mSpecialBoundsDrawable;
        private java.lang.CharSequence mText;
        private com.up366.qmui.span.QMUITouchableSpan mTouchableSpan;
        private com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType mType;

        public com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType getType() {
            return this.mType;
        }

        public java.lang.CharSequence getText() {
            return this.mText;
        }

        public int getDrawableRes() {
            return this.mDrawableRes;
        }

        public com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementList getChildList() {
            return this.mChildList;
        }

        public com.up366.qmui.span.QMUITouchableSpan getTouchableSpan() {
            return this.mTouchableSpan;
        }

        public android.graphics.drawable.Drawable getSpecialBoundsDrawable() {
            return this.mSpecialBoundsDrawable;
        }

        public static com.up366.qmui.qqface.QMUIQQFaceCompiler.Element createTextElement(java.lang.CharSequence charSequence) {
            com.up366.qmui.qqface.QMUIQQFaceCompiler.Element element = new com.up366.qmui.qqface.QMUIQQFaceCompiler.Element();
            element.mType = com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.TEXT;
            element.mText = charSequence;
            return element;
        }

        public static com.up366.qmui.qqface.QMUIQQFaceCompiler.Element createDrawableElement(int i) {
            com.up366.qmui.qqface.QMUIQQFaceCompiler.Element element = new com.up366.qmui.qqface.QMUIQQFaceCompiler.Element();
            element.mType = com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.DRAWABLE;
            element.mDrawableRes = i;
            return element;
        }

        public static com.up366.qmui.qqface.QMUIQQFaceCompiler.Element createSpeaicalBoundsDrawableElement(android.graphics.drawable.Drawable drawable) {
            com.up366.qmui.qqface.QMUIQQFaceCompiler.Element element = new com.up366.qmui.qqface.QMUIQQFaceCompiler.Element();
            element.mType = com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.SPECIAL_BOUNDS_DRAWABLE;
            element.mSpecialBoundsDrawable = drawable;
            return element;
        }

        public static com.up366.qmui.qqface.QMUIQQFaceCompiler.Element createTouchSpanElement(java.lang.CharSequence charSequence, com.up366.qmui.span.QMUITouchableSpan qMUITouchableSpan, com.up366.qmui.qqface.QMUIQQFaceCompiler qMUIQQFaceCompiler) {
            com.up366.qmui.qqface.QMUIQQFaceCompiler.Element element = new com.up366.qmui.qqface.QMUIQQFaceCompiler.Element();
            element.mType = com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.SPAN;
            element.mChildList = qMUIQQFaceCompiler.compile(charSequence, 0, charSequence.length(), true);
            element.mTouchableSpan = qMUITouchableSpan;
            return element;
        }

        public static com.up366.qmui.qqface.QMUIQQFaceCompiler.Element createNextLineElement() {
            com.up366.qmui.qqface.QMUIQQFaceCompiler.Element element = new com.up366.qmui.qqface.QMUIQQFaceCompiler.Element();
            element.mType = com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.NEXTLINE;
            return element;
        }
    }

    public static class ElementList {
        private int mEnd;
        private int mStart;
        private int mQQFaceCount = 0;
        private int mNewLineCount = 0;
        private java.util.List<com.up366.qmui.qqface.QMUIQQFaceCompiler.Element> mElements = new java.util.ArrayList();

        public ElementList(int i, int i2) {
            this.mStart = i;
            this.mEnd = i2;
        }

        public int getStart() {
            return this.mStart;
        }

        public int getEnd() {
            return this.mEnd;
        }

        public int getNewLineCount() {
            return this.mNewLineCount;
        }

        public int getQQFaceCount() {
            return this.mQQFaceCount;
        }

        public void add(com.up366.qmui.qqface.QMUIQQFaceCompiler.Element element) {
            if (element.getType() == com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.DRAWABLE) {
                this.mQQFaceCount++;
            } else if (element.getType() == com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.NEXTLINE) {
                this.mNewLineCount++;
            } else if (element.getType() == com.up366.qmui.qqface.QMUIQQFaceCompiler.ElementType.SPAN && element.getChildList() != null) {
                this.mQQFaceCount += element.getChildList().getQQFaceCount();
                this.mNewLineCount += element.getChildList().getNewLineCount();
            }
            this.mElements.add(element);
        }

        public java.util.List<com.up366.qmui.qqface.QMUIQQFaceCompiler.Element> getElements() {
            return this.mElements;
        }
    }
}
