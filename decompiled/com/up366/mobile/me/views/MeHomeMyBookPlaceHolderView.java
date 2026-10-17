package com.up366.mobile.me.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class MeHomeMyBookPlaceHolderView extends android.widget.LinearLayout {
    public MeHomeMyBookPlaceHolderView(android.content.Context context) {
        this(context, null);
    }

    public MeHomeMyBookPlaceHolderView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MeHomeMyBookPlaceHolderView(final android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.me_fragment_my_book_place_holder_view, this, true);
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.me.views.MeHomeMyBookPlaceHolderView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.me.book.MeMyBookActivity.openPage(context);
            }
        });
    }
}
