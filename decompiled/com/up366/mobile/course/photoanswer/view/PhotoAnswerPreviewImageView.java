package com.up366.mobile.course.photoanswer.view;

/* JADX INFO: compiled from: PhotoAnswerPreviewImageView.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/up366/mobile/course/photoanswer/view/PhotoAnswerPreviewImageView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "b", "Lcom/up366/mobile/databinding/ViewP1pImageLookBackBinding;", "showPage", "", "data", "Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerImageInfo;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerPreviewImageView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.ViewP1pImageLookBackBinding b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoAnswerPreviewImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        com.up366.mobile.databinding.ViewP1pImageLookBackBinding viewP1pImageLookBackBindingInflate = com.up366.mobile.databinding.ViewP1pImageLookBackBinding.inflate(android.view.LayoutInflater.from(context), this, true);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewP1pImageLookBackBindingInflate, "inflate(...)");
        this.b = viewP1pImageLookBackBindingInflate;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhotoAnswerPreviewImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhotoAnswerPreviewImageView(android.content.Context context) {
        this(context, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void showPage(com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo data) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        this.b.scivShow.setImage(com.davemorrissey.labs.subscaleview.ImageSource.uri(android.net.Uri.fromFile(new java.io.File(data.getPreviewFilePath()))));
    }
}
