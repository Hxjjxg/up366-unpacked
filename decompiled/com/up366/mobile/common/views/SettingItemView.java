package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SettingItemView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.SettingItemViewLayoutBinding b;

    public SettingItemView(android.content.Context context) {
        this(context, null);
    }

    public SettingItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SettingItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(android.util.AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.SettingItemView);
        java.lang.String string = typedArrayObtainStyledAttributes.getString(7);
        int color = typedArrayObtainStyledAttributes.getColor(8, -15658735);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(1, false);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(6, false);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(3, false);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(4, false);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(2, true);
        java.lang.String string2 = typedArrayObtainStyledAttributes.getString(0);
        int color2 = typedArrayObtainStyledAttributes.getColor(5, -15658735);
        typedArrayObtainStyledAttributes.recycle();
        com.up366.mobile.databinding.SettingItemViewLayoutBinding settingItemViewLayoutBinding = (com.up366.mobile.databinding.SettingItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.setting_item_view_layout, this, true);
        this.b = settingItemViewLayoutBinding;
        settingItemViewLayoutBinding.cursor.setVisibility(z ? 0 : 8);
        this.b.redPoint.setVisibility(z3 ? 0 : 8);
        this.b.btnSwitch.setVisibility(z2 ? 0 : 8);
        this.b.text.setTextColor(color);
        this.b.text.setText(string);
        this.b.textRight.setVisibility(z4 ? 0 : 8);
        this.b.textRight.setTextColor(color2);
        this.b.textRight.setText(string2);
        this.b.line.setVisibility(z5 ? 0 : 8);
    }

    public void setText(java.lang.String str) {
        this.b.text.setText(str);
    }

    public void setTextTypeface(android.graphics.Typeface typeface) {
        this.b.text.setTypeface(typeface);
    }

    public void setShowRedPoint(boolean z) {
        this.b.redPoint.setVisibility(z ? 0 : 8);
    }

    public void setRightText(java.lang.String str) {
        if (this.b.textRight.getVisibility() != 0) {
            this.b.textRight.setVisibility(0);
        }
        this.b.textRight.setText(str);
    }

    public void setRightTextClickListener(android.view.View.OnClickListener onClickListener) {
        this.b.textRight.setOnClickListener(onClickListener);
    }

    public void setRightTextColor(int i) {
        this.b.textRight.setTextColor(i);
    }

    public void setSwitchBtn(boolean z) {
        this.b.btnSwitch.setChecked(z);
    }

    public void toggle() {
        this.b.btnSwitch.toggle();
    }

    public void setOnCheckedChangeListener(com.up366.mobile.common.views.SwitchButton.IOnCheckedChangeListener iOnCheckedChangeListener) {
        this.b.btnSwitch.setOnCheckedChangeListener(iOnCheckedChangeListener);
    }

    public void setRightDrawable(int i) {
        this.b.cursor.setVisibility(0);
        this.b.cursor.setImageResource(i);
    }

    public void setTextRightMaxEms(int i) {
        this.b.textRight.setVisibility(0);
        this.b.textRight.setMaxEms(i);
    }
}
