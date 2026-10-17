package com.up366.mobile.common.views.me;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MeHomeMyBookItemView extends android.widget.FrameLayout {
    com.up366.mobile.databinding.MeHomeMyBooItemViewLayoutBinding binding;

    public MeHomeMyBookItemView(android.content.Context context) {
        super(context);
        this.binding = (com.up366.mobile.databinding.MeHomeMyBooItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.me_home_my_boo_item_view_layout, this, true);
    }

    public void setData(final com.up366.mobile.common.logic.model.MyBook myBook) {
        com.up366.common.BitmapUtilsUp.display(this.binding.bookPicture, myBook.getBookPic(), com.up366.mobile.R.drawable.default_book_picture);
        this.binding.tipNew.setVisibility(myBook.isNew() ? 0 : 4);
        this.binding.bookPictureNameBg.setVisibility(myBook.isTextBook() ? 0 : 4);
        this.binding.bookPictureName.setVisibility(myBook.isTextBook() ? 0 : 4);
        this.binding.downShelfTip.setVisibility(4);
        if (myBook.getIsShelf() == 2 && !myBook.isHasBuy()) {
            this.binding.downShelfTip.setVisibility(0);
            this.binding.bookPictureName.setTextColor(-3289651);
        }
        if (!myBook.isTextBook() && com.up366.common.StringUtils.isEmptyOrNull(myBook.getBookPic())) {
            this.binding.bookPictureName.setVisibility(0);
        }
        this.binding.bookPictureName.setText(myBook.getBookName());
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.me.MeHomeMyBookItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.me.book.MeBookUtil.skip(view, myBook, com.up366.mobile.me.book.MeBookUtil.getCourseListFromCacheEvent());
            }
        });
    }
}
