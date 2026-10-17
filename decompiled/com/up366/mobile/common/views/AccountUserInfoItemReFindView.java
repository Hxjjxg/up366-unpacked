package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AccountUserInfoItemReFindView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.AccountUserinfoReFindItemViewLayoutBinding b;

    public AccountUserInfoItemReFindView(android.content.Context context) {
        this(context, null);
    }

    public AccountUserInfoItemReFindView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountUserInfoItemReFindView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.AccountUserinfoReFindItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.account_userinfo_re_find_item_view_layout, this, true);
    }

    public void setData(final android.view.View.OnClickListener onClickListener) {
        this.b.reFind.setText(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("这不是我的账号？").append("重新查找").setSpan(new android.text.style.ClickableSpan() { // from class: com.up366.mobile.common.views.AccountUserInfoItemReFindView.1
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
                onClickListener.onClick(view);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(android.text.TextPaint textPaint) {
                textPaint.setColor(textPaint.linkColor);
                textPaint.setUnderlineText(false);
            }
        }).build());
        this.b.reFind.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
    }
}
