package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UserDataManagerItemView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.UserDataManagerItemViewLayoutBinding b;

    public UserDataManagerItemView(android.content.Context context) {
        this(context, null);
    }

    public UserDataManagerItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UserDataManagerItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.up366.mobile.databinding.UserDataManagerItemViewLayoutBinding userDataManagerItemViewLayoutBindingInflate = com.up366.mobile.databinding.UserDataManagerItemViewLayoutBinding.inflate(android.view.LayoutInflater.from(context), this, true);
        this.b = userDataManagerItemViewLayoutBindingInflate;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.UserDataManagerItemView);
        java.lang.String string = typedArrayObtainStyledAttributes.getString(1);
        java.lang.String string2 = typedArrayObtainStyledAttributes.getString(0);
        typedArrayObtainStyledAttributes.recycle();
        userDataManagerItemViewLayoutBindingInflate.title.setText(string);
        userDataManagerItemViewLayoutBindingInflate.description.setText(string2);
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.UserDataManagerItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(android.view.View view) {
        this.b.check.toggle();
    }

    public boolean isChecked() {
        return this.b.check.isChecked();
    }

    public void setChecked(boolean z) {
        this.b.check.setChecked(z);
    }

    public void setOnCheckedChangeListener(android.widget.CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.b.check.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}
