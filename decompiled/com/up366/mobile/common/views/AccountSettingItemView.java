package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AccountSettingItemView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.AccountSettingItemViewLayoutBinding b;

    public AccountSettingItemView(android.content.Context context) {
        this(context, null);
    }

    public AccountSettingItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountSettingItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.up366.mobile.databinding.AccountSettingItemViewLayoutBinding accountSettingItemViewLayoutBinding = (com.up366.mobile.databinding.AccountSettingItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.account_setting_item_view_layout, this, true);
        this.b = accountSettingItemViewLayoutBinding;
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.AccountSettingItemView);
            java.lang.String string = typedArrayObtainStyledAttributes.getString(2);
            java.lang.String string2 = typedArrayObtainStyledAttributes.getString(0);
            if (typedArrayObtainStyledAttributes.hasValue(1)) {
                accountSettingItemViewLayoutBinding.subTitle.setTextColor(typedArrayObtainStyledAttributes.getColor(1, com.up366.qmui.widget.QMUIProgressBar.DEFAULT_PROGRESS_COLOR));
            }
            accountSettingItemViewLayoutBinding.title.setText(string);
            accountSettingItemViewLayoutBinding.subTitle.setText(string2);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setSubTitle(java.lang.CharSequence charSequence) {
        this.b.subTitle.setText(charSequence);
    }

    public void setSubTitleColor(int i) {
        this.b.subTitle.setTextColor(i);
    }
}
