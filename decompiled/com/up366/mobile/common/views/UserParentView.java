package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UserParentView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.MeBindingParentViewLayoutBinding b;

    public UserParentView(android.content.Context context) {
        this(context, null);
    }

    public UserParentView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UserParentView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.MeBindingParentViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.me_binding_parent_view_layout, this, true);
    }
}
