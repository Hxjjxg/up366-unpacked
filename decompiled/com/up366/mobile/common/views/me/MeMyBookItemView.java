package com.up366.mobile.common.views.me;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MeMyBookItemView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.MeMyBookItemViewLayoutBinding binding;

    public MeMyBookItemView(android.content.Context context) {
        super(context);
        this.binding = (com.up366.mobile.databinding.MeMyBookItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.me_my_book_item_view_layout, this, true);
    }

    public void setData(final com.up366.mobile.common.logic.model.MyBook myBook) {
        com.up366.mobile.common.utils.ViewUtil.invisible(this.binding.tipText, this.binding.tipNew, this.binding.tipEndTime);
        com.up366.mobile.common.utils.ViewUtil.gone(this.binding.downShelfTip);
        this.binding.gotoTryBtn.setBackgroundResource(com.up366.mobile.R.drawable.b3_btn_red_background);
        this.binding.bookName.setTextColor(getResources().getColor(com.up366.mobile.R.color.font_c4));
        this.binding.rootView.setBackgroundResource(com.up366.mobile.R.drawable.white_background_5dp);
        com.up366.common.BitmapUtilsUp.display(this.binding.bookPicture, myBook.getBookPic(), com.up366.mobile.R.drawable.default_book_picture);
        if (myBook.getIsShelf() == 2 && !myBook.isHasBuy()) {
            this.binding.gotoTryBtn.setBackgroundResource(com.up366.mobile.R.drawable.b3_btn_gray_background);
            this.binding.bookName.setTextColor(-3289651);
            this.binding.rootView.setBackgroundResource(com.up366.mobile.R.drawable.gray_background_5dp);
            this.binding.downShelfTip.setVisibility(0);
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.tipText);
            this.binding.tipText.setBackgroundResource(com.up366.mobile.R.drawable.btn_outline_background_ffcdcdcd);
            this.binding.tipText.setTextColor(-3289651);
            this.binding.tipText.setText(myBook.getEndDate() != 0 ? "已过期" : "未授权");
        } else if (!myBook.isHasBuy()) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.tipText);
            this.binding.tipText.setBackgroundResource(com.up366.mobile.R.drawable.btn_outline_background_ff5656);
            this.binding.tipText.setTextColor(-43434);
            this.binding.tipText.setText(myBook.getEndDate() != 0 ? "已过期" : "未授权");
        } else if (myBook.getEndDate() > 0 && !com.up366.mobile.common.logic.Auth.cur().book().isZeroPrice(myBook.getCurCourseId(), myBook.getBookId())) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.tipEndTime);
            java.lang.String time = com.up366.common.TimeUtils.formatTime(myBook.getEndDate(), "yyyy-MM-dd");
            this.binding.tipEndTime.setText("有效期：" + time);
        }
        if (myBook.isHasBuy() && myBook.getRemainDay() <= 15 && myBook.getRemainDay() > 0 && !com.up366.mobile.common.logic.Auth.cur().book().isZeroPrice(myBook.getCurCourseId(), myBook.getBookId())) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.tipText);
            this.binding.tipText.setTextColor(-31663);
            this.binding.tipText.setBackgroundResource(com.up366.mobile.R.drawable.btn_outline_background_ff8451);
            this.binding.tipText.setText(com.up366.common.StringUtils.format("%d天后到期", java.lang.Integer.valueOf(myBook.getRemainDay())));
        }
        this.binding.tipNew.setVisibility(myBook.isNew() ? 0 : 4);
        this.binding.bookName.setText(myBook.getBookName());
        this.binding.gotoStudyBtn.setVisibility(0);
        this.binding.gotoTryBtn.setVisibility(4);
        this.binding.gotoStudyBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.me.MeMyBookItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setData$0(myBook, view);
            }
        });
        this.binding.gotoTryBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.me.MeMyBookItemView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setData$1(myBook, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$0(com.up366.mobile.common.logic.model.MyBook myBook, android.view.View view) {
        startActivity(view.getContext(), myBook);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setData$1(com.up366.mobile.common.logic.model.MyBook myBook, android.view.View view) {
        startActivity(view.getContext(), myBook);
    }

    private void startActivity(android.content.Context context, com.up366.mobile.common.logic.model.MyBook myBook) {
        com.up366.mobile.common.utils.ViewDataInvalidRecord.$("me_fragment_book_study").invalid();
        if (myBook.getCurCourseId() > 0) {
            com.up366.mobile.me.book.MeBookUtil.skip(this, myBook);
        } else {
            com.up366.mobile.me.book.MeBookUtil.skip(this, myBook, com.up366.mobile.me.book.MeBookUtil.getCourseListFromCacheEvent());
        }
    }
}
