package com.up366.mobile.book.studyviews.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ChapterHeadView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.BookChapterHeadLayoutBinding b;
    private final android.content.Context context;
    private com.up366.mobile.book.model.TreeBookChapter data;

    public ChapterHeadView(android.content.Context context) {
        this(context, null);
    }

    public ChapterHeadView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChapterHeadView(final android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        setWillNotDraw(false);
        com.up366.mobile.databinding.BookChapterHeadLayoutBinding bookChapterHeadLayoutBinding = (com.up366.mobile.databinding.BookChapterHeadLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.book_chapter_head_layout, this, true);
        this.b = bookChapterHeadLayoutBinding;
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(bookChapterHeadLayoutBinding.buyBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.studyviews.view.ChapterHeadView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$0(view);
            }
        });
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.b.continueLearn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.studyviews.view.ChapterHeadView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$1(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(android.view.View view) {
        com.up366.mobile.common.utils.ToastPopupUtil.show(this.b.buyBtn, "抱歉，不支持该功能");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$new$1(android.content.Context context, android.view.View view) {
        com.up366.mobile.book.model.BookInfoStudy book = this.data.getBook();
        com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo = com.up366.mobile.common.logic.Auth.cur().bookProgress().get(book.getBookId());
        com.up366.mobile.book.model.CatalogChapter chapter = this.data.getChapter(bookScheduleInfo.getChapterId());
        if (book.getBookType() == 2) {
            chapter = this.data.getChapter(bookScheduleInfo.getPageId());
        } else if (book.getPackType() == 6 && this.data.getChapter(bookScheduleInfo.getPageId()) != null) {
            chapter = this.data.getChapter(bookScheduleInfo.getPageId());
        }
        com.up366.mobile.book.model.CatalogPage page = this.data.getPage(bookScheduleInfo.getPageId());
        if (chapter == null && page == null) {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) context, "章节内容不存在");
            return;
        }
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo();
        if (chapter != null) {
            openConfigInfo.chapterId = chapter.obj.getId();
            openConfigInfo.pageNo = chapter.getPageNo();
            openConfigInfo.title = chapter.obj.getName();
        }
        if (page != null) {
            openConfigInfo.pageId = page.obj.getId();
            openConfigInfo.pageNo = page.getPageNo();
            openConfigInfo.title = page.obj.getName();
        }
        ((com.up366.mobile.book.StudyActivity) context).openPage(openConfigInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLayoutParams().width = -1;
        requestLayout();
    }

    public void setData(com.up366.mobile.book.model.TreeBookChapter treeBookChapter) {
        this.data = treeBookChapter;
        initViewData();
    }

    private void initViewData() {
        com.up366.mobile.book.model.BookInfoStudy book = this.data.getBook();
        boolean zIsHasBuy = book.isHasBuy();
        long endTime = book.getEndTime();
        book.isShelf();
        book.getBookType();
        com.up366.common.BitmapUtilsUp.display(this.b.bookPic, book.getBigPicture(), com.up366.mobile.R.drawable.default_book3);
        if (zIsHasBuy) {
            com.up366.mobile.common.utils.ViewUtil.gone(this.b.timeTip, this.b.price, this.b.buyBtn, this.b.hasBuyTipContent, this.b.noBuyText);
            if (endTime != 0) {
                if (book.getRemainDay() < 15) {
                    com.up366.mobile.common.utils.ViewUtil.visible(this.b.noBuyText);
                    this.b.timeTip.setText(com.up366.common.StringUtils.format("使用倒计时%d天", java.lang.Integer.valueOf(book.getRemainDay())));
                    this.b.buyBtn.setText("续费");
                } else {
                    this.b.hasBuyTipContent.setVisibility(0);
                    this.b.remainTime.setText(java.lang.String.valueOf(book.getRemainDay()));
                }
            }
        } else {
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.timeTip, this.b.price, this.b.buyBtn, this.b.noBuyText);
            com.up366.mobile.common.utils.ViewUtil.gone(this.b.hasBuyTipContent);
            if (book.getValidDays() > 0) {
                this.b.timeTip.setText(com.up366.common.StringUtils.format("购买后可以使用%d天", java.lang.Integer.valueOf(book.getValidDays())));
            } else {
                com.up366.mobile.common.utils.ViewUtil.gone(this.b.timeTip);
            }
            android.text.SpannableString spannableString = new android.text.SpannableString(com.up366.common.StringUtils.format("¥%.2f", java.lang.Float.valueOf(book.getPrice())));
            spannableString.setSpan(new android.text.style.RelativeSizeSpan(0.7f), 0, 1, 17);
            this.b.price.setText(spannableString);
        }
        com.up366.mobile.book.model.BookScheduleInfo bookScheduleInfo = com.up366.mobile.common.logic.Auth.cur().bookProgress().get(book.getBookId());
        if (bookScheduleInfo.getLastStudyTime() > 0) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.continueLearn);
            this.b.lastTime.setText(bookScheduleInfo.getLastStudyTimeStr());
            this.b.lastPosition.setText(bookScheduleInfo.getShortSchedule());
            return;
        }
        com.up366.mobile.common.utils.ViewUtil.gone(this.b.continueLearn);
    }
}
