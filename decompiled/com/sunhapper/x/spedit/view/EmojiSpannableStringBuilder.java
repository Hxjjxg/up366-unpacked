package com.sunhapper.x.spedit.view;

/* JADX INFO: compiled from: EmojiSpannableStringBuilder.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u0013\b\u0010\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0010\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B+\b\u0010\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0011H\u0016J\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u0018\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J9\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H!0 \"\u0004\b\u0000\u0010!2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\t2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u0002H!\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\u000f2\u0006\u0010'\u001a\u00020\u0013H\u0002J\u0018\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u0006H\u0016J(\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010+\u001a\u00020,2\n\u0010-\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002J\u0012\u0010+\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010\u0013H\u0002J$\u0010/\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\n\u00101\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016J\u0010\u00102\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u00103\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u0006H\u0016J0\u00103\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010*\u001a\u00020\u00062\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0016J(\u00106\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0018\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\tH\u0016J\b\u0010:\u001a\u00020\u0016H\u0002R\u0012\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/sunhapper/x/spedit/view/EmojiSpannableStringBuilder;", "Landroid/text/SpannableStringBuilder;", "watcherClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "text", "", "(Ljava/lang/Class;Ljava/lang/CharSequence;)V", "start", "", "end", "(Ljava/lang/Class;Ljava/lang/CharSequence;II)V", "mWatcherClass", "mWatchers", "Ljava/util/ArrayList;", "Lcom/sunhapper/x/spedit/view/EmojiSpannableStringBuilder$WatcherWrapper;", "append", "", "what", "", "flags", "beginBatchEdit", "", "blockWatchers", "delete", "endBatchEdit", "fireWatchers", "getSpanEnd", "tag", "getSpanFlags", "getSpanStart", "getSpans", "", "T", "queryStart", "queryEnd", "kind", "(IILjava/lang/Class;)[Ljava/lang/Object;", "getWatcherFor", "object", "insert", "where", "tb", "isWatcher", "", "clazz", "obj", "nextSpanTransition", "limit", "type", "removeSpan", com.up366.mobile.common.onlinelog.OpLogData.Control.NAVIGATION_REPLACE, "tbstart", "tbend", "setSpan", "subSequence", "startIndex", "endIndex", "unblockwatchers", "Companion", "WatcherWrapper", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
public final class EmojiSpannableStringBuilder extends android.text.SpannableStringBuilder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.Companion INSTANCE = new com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.Companion(null);
    private final java.lang.Class<?> mWatcherClass;
    private final java.util.ArrayList<com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.WatcherWrapper> mWatchers;

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final /* bridge */ char charAt(int i) {
        return get(i);
    }

    public /* bridge */ char get(int i) {
        return super.charAt(i);
    }

    public /* bridge */ int getLength() {
        return super.length();
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public EmojiSpannableStringBuilder(java.lang.Class<?> cls) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(cls, "watcherClass");
        this.mWatchers = new java.util.ArrayList<>();
        this.mWatcherClass = cls;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiSpannableStringBuilder(java.lang.Class<?> cls, java.lang.CharSequence charSequence) {
        super(charSequence);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(cls, "watcherClass");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(charSequence, "text");
        this.mWatchers = new java.util.ArrayList<>();
        this.mWatcherClass = cls;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiSpannableStringBuilder(java.lang.Class<?> cls, java.lang.CharSequence charSequence, int i, int i2) {
        super(charSequence, i, i2);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(cls, "watcherClass");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(charSequence, "text");
        this.mWatchers = new java.util.ArrayList<>();
        this.mWatcherClass = cls;
    }

    private final boolean isWatcher(java.lang.Object obj) {
        return obj != null && isWatcher(obj.getClass());
    }

    private final boolean isWatcher(java.lang.Class<?> clazz) {
        return kotlin.jvm.internal.Intrinsics.areEqual(this.mWatcherClass, clazz);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public java.lang.CharSequence subSequence(int startIndex, int endIndex) {
        return new com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder(this.mWatcherClass, this, startIndex, endIndex);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(java.lang.Object what, int start, int end, int flags) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(what, "what");
        if (isWatcher(what)) {
            com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.WatcherWrapper watcherWrapper = new com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.WatcherWrapper(what);
            this.mWatchers.add(watcherWrapper);
            what = watcherWrapper;
        }
        super.setSpan(what, start, end, flags);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public <T> T[] getSpans(int queryStart, int queryEnd, java.lang.Class<T> kind) throws kotlin.TypeCastException {
        if (kind != null && isWatcher((java.lang.Class<?>) kind)) {
            com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.WatcherWrapper[] watcherWrapperArr = (com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.WatcherWrapper[]) super.getSpans(queryStart, queryEnd, com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.WatcherWrapper.class);
            java.lang.Object objNewInstance = java.lang.reflect.Array.newInstance((java.lang.Class<?>) kind, watcherWrapperArr.length);
            if (objNewInstance == null) {
                throw new kotlin.TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            T[] tArr = (T[]) ((java.lang.Object[]) objNewInstance);
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(watcherWrapperArr, "spans");
            int length = watcherWrapperArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                tArr[i2] = watcherWrapperArr[i].getMObject();
                i++;
                i2++;
            }
            return tArr;
        }
        T[] tArr2 = (T[]) super.getSpans(queryStart, queryEnd, kind);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(tArr2, "super.getSpans(queryStart, queryEnd, kind)");
        return tArr2;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(java.lang.Object what) {
        com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.WatcherWrapper watcherFor;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(what, "what");
        if (isWatcher(what)) {
            watcherFor = getWatcherFor(what);
            if (watcherFor != null) {
                what = watcherFor;
            }
        } else {
            watcherFor = null;
        }
        super.removeSpan(what);
        if (watcherFor != null) {
            this.mWatchers.remove(watcherFor);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(java.lang.Object tag) {
        com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.WatcherWrapper watcherFor;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(tag, "tag");
        if (isWatcher(tag) && (watcherFor = getWatcherFor(tag)) != null) {
            tag = watcherFor;
        }
        return super.getSpanStart(tag);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(java.lang.Object tag) {
        com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.WatcherWrapper watcherFor;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(tag, "tag");
        if (isWatcher(tag) && (watcherFor = getWatcherFor(tag)) != null) {
            tag = watcherFor;
        }
        return super.getSpanEnd(tag);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(java.lang.Object tag) {
        com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.WatcherWrapper watcherFor;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(tag, "tag");
        if (isWatcher(tag) && (watcherFor = getWatcherFor(tag)) != null) {
            tag = watcherFor;
        }
        return super.getSpanFlags(tag);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int start, int limit, java.lang.Class<?> type) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(type, "type");
        if (isWatcher(type)) {
            type = com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.WatcherWrapper.class;
        }
        return super.nextSpanTransition(start, limit, type);
    }

    private final com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.WatcherWrapper getWatcherFor(java.lang.Object object) {
        int size = this.mWatchers.size();
        for (int i = 0; i < size; i++) {
            com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.WatcherWrapper watcherWrapper = this.mWatchers.get(i);
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(watcherWrapper, "mWatchers[i]");
            com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder.WatcherWrapper watcherWrapper2 = watcherWrapper;
            if (watcherWrapper2.getMObject() == object) {
                return watcherWrapper2;
            }
        }
        return null;
    }

    public final void beginBatchEdit() {
        blockWatchers();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
    public final void endBatchEdit() throws kotlin.TypeCastException {
        unblockwatchers();
        fireWatchers();
    }

    private final void blockWatchers() {
        int size = this.mWatchers.size();
        for (int i = 0; i < size; i++) {
            this.mWatchers.get(i).blockCalls$SpEditText_release();
        }
    }

    private final void unblockwatchers() {
        int size = this.mWatchers.size();
        for (int i = 0; i < size; i++) {
            this.mWatchers.get(i).unblockCalls$SpEditText_release();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
    private final void fireWatchers() throws kotlin.TypeCastException {
        int size = this.mWatchers.size();
        for (int i = 0; i < size; i++) {
            this.mWatchers.get(i).onTextChanged(this, 0, length(), length());
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public android.text.SpannableStringBuilder replace(int start, int end, java.lang.CharSequence tb) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(tb, "tb");
        blockWatchers();
        super.replace(start, end, tb);
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public android.text.SpannableStringBuilder replace(int start, int end, java.lang.CharSequence tb, int tbstart, int tbend) {
        int i;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(tb, "tb");
        blockWatchers();
        if (end < start) {
            i = start;
            start = end;
        } else {
            i = end;
        }
        if (start != i && tbstart != tbend) {
            super.replace(start, i, "", 0, 0);
            super.insert(start, tb, tbstart, tbend);
        } else {
            super.replace(start, i, tb, tbstart, tbend);
        }
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public android.text.SpannableStringBuilder insert(int where, java.lang.CharSequence tb) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(tb, "tb");
        super.insert(where, tb);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public android.text.SpannableStringBuilder insert(int where, java.lang.CharSequence tb, int start, int end) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(tb, "tb");
        super.insert(where, tb, start, end);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public android.text.SpannableStringBuilder delete(int start, int end) {
        super.delete(start, end);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public android.text.SpannableStringBuilder append(java.lang.CharSequence text) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        super.append(text);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public android.text.SpannableStringBuilder append(char text) {
        super.append(text);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public android.text.SpannableStringBuilder append(java.lang.CharSequence text, int start, int end) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        super.append(text, start, end);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public android.text.SpannableStringBuilder append(java.lang.CharSequence text, java.lang.Object what, int flags) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(what, "what");
        super.append(text, what, flags);
        return this;
    }

    /* JADX INFO: compiled from: EmojiSpannableStringBuilder.kt */
    @kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\r\u0010\u0014\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J(\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0016J8\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0016J(\u0010#\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0016J(\u0010$\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\r\u0010&\u001a\u00020\u000bH\u0000¢\u0006\u0002\b'R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006("}, d2 = {"Lcom/sunhapper/x/spedit/view/EmojiSpannableStringBuilder$WatcherWrapper;", "Landroid/text/TextWatcher;", "Landroid/text/SpanWatcher;", "mObject", "", "(Ljava/lang/Object;)V", "mBlockCalls", "Ljava/util/concurrent/atomic/AtomicInteger;", "getMObject", "()Ljava/lang/Object;", "afterTextChanged", "", com.igexin.push.core.d.d.g, "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", com.up366.medialibrary.config.PictureConstants.EXTRA_DATA_COUNT, "after", "blockCalls", "blockCalls$SpEditText_release", "isImageSpan", "", "span", "onSpanAdded", "text", "Landroid/text/Spannable;", "what", "end", "onSpanChanged", "ostart", "oend", "nstart", "nend", "onSpanRemoved", "onTextChanged", "before", "unblockCalls", "unblockCalls$SpEditText_release", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
    private static final class WatcherWrapper implements android.text.TextWatcher, android.text.SpanWatcher {
        private final java.util.concurrent.atomic.AtomicInteger mBlockCalls;
        private final java.lang.Object mObject;

        public WatcherWrapper(java.lang.Object obj) {
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(obj, "mObject");
            this.mObject = obj;
            this.mBlockCalls = new java.util.concurrent.atomic.AtomicInteger(0);
        }

        public final java.lang.Object getMObject() {
            return this.mObject;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence s, int start, int count, int after) throws kotlin.TypeCastException {
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(s, com.igexin.push.core.d.d.g);
            java.lang.Object obj = this.mObject;
            if (obj == null) {
                throw new kotlin.TypeCastException("null cannot be cast to non-null type android.text.TextWatcher");
            }
            ((android.text.TextWatcher) obj).beforeTextChanged(s, start, count, after);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence s, int start, int before, int count) throws kotlin.TypeCastException {
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(s, com.igexin.push.core.d.d.g);
            java.lang.Object obj = this.mObject;
            if (obj == null) {
                throw new kotlin.TypeCastException("null cannot be cast to non-null type android.text.TextWatcher");
            }
            ((android.text.TextWatcher) obj).onTextChanged(s, start, before, count);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
        @Override // android.text.TextWatcher
        public void afterTextChanged(android.text.Editable s) throws kotlin.TypeCastException {
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(s, com.igexin.push.core.d.d.g);
            java.lang.Object obj = this.mObject;
            if (obj == null) {
                throw new kotlin.TypeCastException("null cannot be cast to non-null type android.text.TextWatcher");
            }
            ((android.text.TextWatcher) obj).afterTextChanged(s);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
        @Override // android.text.SpanWatcher
        public void onSpanAdded(android.text.Spannable text, java.lang.Object what, int start, int end) throws kotlin.TypeCastException {
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(what, "what");
            if (this.mBlockCalls.get() <= 0 || !isImageSpan(what)) {
                java.lang.Object obj = this.mObject;
                if (obj == null) {
                    throw new kotlin.TypeCastException("null cannot be cast to non-null type android.text.SpanWatcher");
                }
                ((android.text.SpanWatcher) obj).onSpanAdded(text, what, start, end);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
        @Override // android.text.SpanWatcher
        public void onSpanRemoved(android.text.Spannable text, java.lang.Object what, int start, int end) throws kotlin.TypeCastException {
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(what, "what");
            if (this.mBlockCalls.get() <= 0 || !isImageSpan(what)) {
                java.lang.Object obj = this.mObject;
                if (obj == null) {
                    throw new kotlin.TypeCastException("null cannot be cast to non-null type android.text.SpanWatcher");
                }
                ((android.text.SpanWatcher) obj).onSpanRemoved(text, what, start, end);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
        @Override // android.text.SpanWatcher
        public void onSpanChanged(android.text.Spannable text, java.lang.Object what, int ostart, int oend, int nstart, int nend) throws kotlin.TypeCastException {
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(what, "what");
            if (this.mBlockCalls.get() <= 0 || !isImageSpan(what)) {
                java.lang.Object obj = this.mObject;
                if (obj == null) {
                    throw new kotlin.TypeCastException("null cannot be cast to non-null type android.text.SpanWatcher");
                }
                ((android.text.SpanWatcher) obj).onSpanChanged(text, what, ostart, oend, nstart, nend);
            }
        }

        public final void blockCalls$SpEditText_release() {
            this.mBlockCalls.incrementAndGet();
        }

        public final void unblockCalls$SpEditText_release() {
            this.mBlockCalls.decrementAndGet();
        }

        private final boolean isImageSpan(java.lang.Object span) {
            return span instanceof android.text.style.ImageSpan;
        }
    }

    /* JADX INFO: compiled from: EmojiSpannableStringBuilder.kt */
    @kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/sunhapper/x/spedit/view/EmojiSpannableStringBuilder$Companion;", "", "()V", "create", "Lcom/sunhapper/x/spedit/view/EmojiSpannableStringBuilder;", "clazz", "Ljava/lang/Class;", "text", "", "create$SpEditText_release", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder create$SpEditText_release(java.lang.Class<?> clazz, java.lang.CharSequence text) {
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(clazz, "clazz");
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
            return new com.sunhapper.x.spedit.view.EmojiSpannableStringBuilder(clazz, text);
        }
    }
}
