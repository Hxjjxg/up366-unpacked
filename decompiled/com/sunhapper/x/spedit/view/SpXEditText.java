package com.sunhapper.x.spedit.view;

/* JADX INFO: compiled from: SpXEditText.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/sunhapper/x/spedit/view/SpXEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mKeyEventProxy", "Lcom/sunhapper/x/spedit/view/KeyEventProxy;", "handleKeyEvent", "", "event", "Landroid/view/KeyEvent;", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "setKeyEventProxy", "", "keyEventProxy", "CustomInputConnectionWrapper", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
public final class SpXEditText extends androidx.appcompat.widget.AppCompatEditText {
    private java.util.HashMap _$_findViewCache;
    private com.sunhapper.x.spedit.view.KeyEventProxy mKeyEventProxy;

    public void _$_clearFindViewByIdCache() {
        java.util.HashMap map = this._$_findViewCache;
        if (map != null) {
            map.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public android.view.View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new java.util.HashMap();
        }
        android.view.View view = (android.view.View) this._$_findViewCache.get(java.lang.Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        android.view.View viewFindViewById = findViewById(i);
        this._$_findViewCache.put(java.lang.Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SpXEditText(android.content.Context context) {
        super(context);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
        this.mKeyEventProxy = new com.sunhapper.x.spedit.view.DefaultKeyEventProxy();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.sunhapper.x.spedit.mention.watcher.SpanChangedWatcher());
        arrayList.add(new com.sunhapper.x.spedit.gif.watcher.GifWatcher((android.view.View) this));
        setEditableFactory(new com.sunhapper.x.spedit.view.SpXEditableFactory(arrayList));
        setOnKeyListener(new android.view.View.OnKeyListener() { // from class: com.sunhapper.x.spedit.view.SpXEditText.1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(android.view.View view, int i, android.view.KeyEvent keyEvent) {
                com.sunhapper.x.spedit.view.SpXEditText spXEditText = com.sunhapper.x.spedit.view.SpXEditText.this;
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(keyEvent, "event");
                return spXEditText.handleKeyEvent(keyEvent);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SpXEditText(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        this.mKeyEventProxy = new com.sunhapper.x.spedit.view.DefaultKeyEventProxy();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.sunhapper.x.spedit.mention.watcher.SpanChangedWatcher());
        arrayList.add(new com.sunhapper.x.spedit.gif.watcher.GifWatcher((android.view.View) this));
        setEditableFactory(new com.sunhapper.x.spedit.view.SpXEditableFactory(arrayList));
        setOnKeyListener(new android.view.View.OnKeyListener() { // from class: com.sunhapper.x.spedit.view.SpXEditText.1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(android.view.View view, int i, android.view.KeyEvent keyEvent) {
                com.sunhapper.x.spedit.view.SpXEditText spXEditText = com.sunhapper.x.spedit.view.SpXEditText.this;
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(keyEvent, "event");
                return spXEditText.handleKeyEvent(keyEvent);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SpXEditText(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        this.mKeyEventProxy = new com.sunhapper.x.spedit.view.DefaultKeyEventProxy();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.sunhapper.x.spedit.mention.watcher.SpanChangedWatcher());
        arrayList.add(new com.sunhapper.x.spedit.gif.watcher.GifWatcher((android.view.View) this));
        setEditableFactory(new com.sunhapper.x.spedit.view.SpXEditableFactory(arrayList));
        setOnKeyListener(new android.view.View.OnKeyListener() { // from class: com.sunhapper.x.spedit.view.SpXEditText.1
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(android.view.View view, int i2, android.view.KeyEvent keyEvent) {
                com.sunhapper.x.spedit.view.SpXEditText spXEditText = com.sunhapper.x.spedit.view.SpXEditText.this;
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(keyEvent, "event");
                return spXEditText.handleKeyEvent(keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean handleKeyEvent(android.view.KeyEvent event) {
        com.sunhapper.x.spedit.view.KeyEventProxy keyEventProxy = this.mKeyEventProxy;
        android.text.Editable text = getText();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(text, "text");
        return keyEventProxy.onKeyEvent(event, text);
    }

    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo outAttrs) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(outAttrs, "outAttrs");
        android.view.inputmethod.InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(outAttrs);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(inputConnectionOnCreateInputConnection, "super.onCreateInputConnection(outAttrs)");
        return new com.sunhapper.x.spedit.view.SpXEditText.CustomInputConnectionWrapper(this, inputConnectionOnCreateInputConnection, true);
    }

    /* JADX INFO: compiled from: SpXEditText.kt */
    @kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/sunhapper/x/spedit/view/SpXEditText$CustomInputConnectionWrapper;", "Landroid/view/inputmethod/InputConnectionWrapper;", "target", "Landroid/view/inputmethod/InputConnection;", "mutable", "", "(Lcom/sunhapper/x/spedit/view/SpXEditText;Landroid/view/inputmethod/InputConnection;Z)V", "deleteSurroundingText", "beforeLength", "", "afterLength", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
    private final class CustomInputConnectionWrapper extends android.view.inputmethod.InputConnectionWrapper {
        final /* synthetic */ com.sunhapper.x.spedit.view.SpXEditText this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomInputConnectionWrapper(com.sunhapper.x.spedit.view.SpXEditText spXEditText, android.view.inputmethod.InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(inputConnection, "target");
            this.this$0 = spXEditText;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int beforeLength, int afterLength) {
            if (beforeLength == 1 && afterLength == 0) {
                return sendKeyEvent(new android.view.KeyEvent(0, 67)) && sendKeyEvent(new android.view.KeyEvent(1, 67));
            }
            return super.deleteSurroundingText(beforeLength, afterLength);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(android.view.KeyEvent event) {
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(event, "event");
            return this.this$0.handleKeyEvent(event) || super.sendKeyEvent(event);
        }
    }

    public final void setKeyEventProxy(com.sunhapper.x.spedit.view.KeyEventProxy keyEventProxy) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(keyEventProxy, "keyEventProxy");
        this.mKeyEventProxy = keyEventProxy;
    }
}
