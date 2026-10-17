package com.sunhapper.x.spedit.view;

/* JADX INFO: compiled from: SpXTextView.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/sunhapper/x/spedit/view/SpXTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setText", "", "text", "", "type", "Landroid/widget/TextView$BufferType;", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
public final class SpXTextView extends androidx.appcompat.widget.AppCompatTextView {
    private java.util.HashMap _$_findViewCache;

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
    public SpXTextView(android.content.Context context) {
        super(context);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.sunhapper.x.spedit.gif.watcher.GifWatcher((android.view.View) this));
        setSpannableFactory(new com.sunhapper.x.spedit.view.SpXSpannableFactory(arrayList));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SpXTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.sunhapper.x.spedit.gif.watcher.GifWatcher((android.view.View) this));
        setSpannableFactory(new com.sunhapper.x.spedit.view.SpXSpannableFactory(arrayList));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SpXTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.sunhapper.x.spedit.gif.watcher.GifWatcher((android.view.View) this));
        setSpannableFactory(new com.sunhapper.x.spedit.view.SpXSpannableFactory(arrayList));
    }

    public void setText(java.lang.CharSequence text, android.widget.TextView.BufferType type) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(text, "text");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(type, "type");
        super.setText(text, android.widget.TextView.BufferType.SPANNABLE);
    }
}
