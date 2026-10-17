package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AppMenuItemView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.AppMenuItemViewLayoutBinding b;

    public AppMenuItemView(android.content.Context context) {
        this(context, null);
    }

    public AppMenuItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppMenuItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.AppMenuItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.app_menu_item_view_layout, this, true);
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.AppMenuItemView);
            java.lang.String string = typedArrayObtainStyledAttributes.getString(2);
            java.lang.String string2 = typedArrayObtainStyledAttributes.getString(1);
            android.graphics.drawable.Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
            this.b.title.setText(string);
            this.b.subTitle.setText(string2);
            if (drawable != null) {
                this.b.icon.setImageDrawable(drawable);
            } else {
                this.b.icon.setVisibility(8);
            }
            setClickable(true);
        }
    }
}
