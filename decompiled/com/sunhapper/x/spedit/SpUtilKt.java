package com.sunhapper.x.spedit;

/* JADX INFO: compiled from: SpUtil.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\f"}, d2 = {"createGifDrawableSpan", "Landroid/text/Spannable;", "gifDrawable", "Landroid/graphics/drawable/Drawable;", "text", "", "createResizeGifDrawableSpan", "insertSpannableString", "", "editable", "Landroid/text/Editable;", "insertSpan", "SpEditText_release"}, k = 2, mv = {1, 1, 15})
public final class SpUtilKt {
    public static final android.text.Spannable createResizeGifDrawableSpan(android.graphics.drawable.Drawable drawable, java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(drawable, "gifDrawable");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(charSequence, "text");
        android.text.SpannableString spannableString = new android.text.SpannableString(charSequence);
        spannableString.setSpan(new com.sunhapper.x.spedit.gif.span.ResizeIsoheightImageSpan(drawable), 0, charSequence.length(), 33);
        return spannableString;
    }

    public static final android.text.Spannable createGifDrawableSpan(android.graphics.drawable.Drawable drawable, java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(drawable, "gifDrawable");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(charSequence, "text");
        com.sunhapper.x.spedit.gif.span.GifIsoheightImageSpan gifIsoheightImageSpan = new com.sunhapper.x.spedit.gif.span.GifIsoheightImageSpan(drawable);
        android.text.SpannableString spannableString = new android.text.SpannableString(charSequence);
        spannableString.setSpan(gifIsoheightImageSpan, 0, spannableString.length(), 33);
        return spannableString;
    }

    public static final void insertSpannableString(android.text.Editable editable, java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(editable, "editable");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(charSequence, "text");
        android.text.Editable editable2 = editable;
        int selectionStart = android.text.Selection.getSelectionStart(editable2);
        int selectionEnd = android.text.Selection.getSelectionEnd(editable2);
        if (selectionEnd < selectionStart) {
            selectionStart = selectionEnd;
            selectionEnd = selectionStart;
        }
        editable.replace(selectionStart, selectionEnd, charSequence);
    }

    public static final void insertSpan(android.text.Editable editable, java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(editable, "$this$insertSpan");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(charSequence, "text");
        int spanStart = editable.getSpanStart(android.text.Selection.SELECTION_START);
        int spanEnd = editable.getSpanEnd(android.text.Selection.SELECTION_START);
        if (spanEnd < spanStart) {
            spanEnd = spanStart;
            spanStart = spanEnd;
        }
        editable.replace(spanStart, spanEnd, charSequence);
    }
}
