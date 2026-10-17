package com.up366.mobile.commonui.condition;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BooksSelectView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.BooksSelectViewBinding b;
    private com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo bookInfo;
    private android.content.Context context;

    public BooksSelectView(android.content.Context context) {
        this(context, null);
    }

    public BooksSelectView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BooksSelectView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.BooksSelectViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.books_select_view, this, true);
        this.context = context;
        init();
    }

    private void init() {
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.commonui.condition.BooksSelectView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(android.view.View view) {
        this.b.selectBtn.setVisibility(0);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.BookSelectChange(this.bookInfo.getBookId()));
    }

    public void setBookInfo(com.up366.mobile.course.wrongnote.modle.WrongNoteBookInfo wrongNoteBookInfo) {
        this.bookInfo = wrongNoteBookInfo;
        this.b.selectBtn.setVisibility(wrongNoteBookInfo.isSelect() ? 0 : 4);
        this.b.bookName.setText(wrongNoteBookInfo.getBookName());
    }
}
