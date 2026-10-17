package com.sunhapper.x.spedit.gif.span;

/* JADX INFO: compiled from: GifIsoheightImageSpan.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011B\u001f\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0012B\u0017\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0002\u0010\u0014B\u001f\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0015B\u000f\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018B\u0017\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0019B\u0017\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u001aB\u001f\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u001bJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016¨\u0006\u001e"}, d2 = {"Lcom/sunhapper/x/spedit/gif/span/GifIsoheightImageSpan;", "Lcom/sunhapper/x/spedit/gif/span/IsoheightImageSpan;", "Lcom/sunhapper/x/spedit/gif/span/RefreshSpan;", "d", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "verticalAlignment", "", "(Landroid/graphics/drawable/Drawable;I)V", "source", "", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;I)V", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;)V", "(Landroid/content/Context;Landroid/net/Uri;I)V", "resourceId", "(Landroid/content/Context;I)V", "(Landroid/content/Context;II)V", "b", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "(Landroid/graphics/Bitmap;I)V", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "(Landroid/content/Context;Landroid/graphics/Bitmap;I)V", "getInvalidateDrawable", "Lcom/sunhapper/x/spedit/gif/drawable/InvalidateDrawable;", "SpEditText_release"}, k = 1, mv = {1, 1, 15})
public class GifIsoheightImageSpan extends com.sunhapper.x.spedit.gif.span.IsoheightImageSpan implements com.sunhapper.x.spedit.gif.span.RefreshSpan {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifIsoheightImageSpan(android.graphics.drawable.Drawable drawable) {
        super(drawable);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(drawable, "d");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifIsoheightImageSpan(android.graphics.drawable.Drawable drawable, int i) {
        super(drawable, i);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(drawable, "d");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifIsoheightImageSpan(android.graphics.drawable.Drawable drawable, java.lang.String str) {
        super(drawable, str);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(drawable, "d");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(str, "source");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifIsoheightImageSpan(android.graphics.drawable.Drawable drawable, java.lang.String str, int i) {
        super(drawable, str, i);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(drawable, "d");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(str, "source");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifIsoheightImageSpan(android.content.Context context, android.net.Uri uri) {
        super(context, uri);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(uri, "uri");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifIsoheightImageSpan(android.content.Context context, android.net.Uri uri, int i) {
        super(context, uri, i);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(uri, "uri");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifIsoheightImageSpan(android.content.Context context, int i) {
        super(context, i);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifIsoheightImageSpan(android.content.Context context, int i, int i2) {
        super(context, i, i2);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifIsoheightImageSpan(android.graphics.Bitmap bitmap) {
        super(bitmap);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(bitmap, "b");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifIsoheightImageSpan(android.graphics.Bitmap bitmap, int i) {
        super(bitmap, i);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(bitmap, "b");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifIsoheightImageSpan(android.content.Context context, android.graphics.Bitmap bitmap) {
        super(context, bitmap);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(bitmap, "b");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifIsoheightImageSpan(android.content.Context context, android.graphics.Bitmap bitmap, int i) {
        super(context, bitmap, i);
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(context, "context");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(bitmap, "b");
    }

    @Override // com.sunhapper.x.spedit.gif.span.RefreshSpan
    public com.sunhapper.x.spedit.gif.drawable.InvalidateDrawable getInvalidateDrawable() {
        java.lang.Object resizedDrawable = getResizedDrawable();
        if (resizedDrawable instanceof com.sunhapper.x.spedit.gif.drawable.InvalidateDrawable) {
            return (com.sunhapper.x.spedit.gif.drawable.InvalidateDrawable) resizedDrawable;
        }
        return null;
    }
}
