package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CourseTitleTextView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.CourseTitleTextViewLayoutBinding b;

    public CourseTitleTextView(android.content.Context context) {
        this(context, null);
    }

    public CourseTitleTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CourseTitleTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.CourseTitleTextViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.course_title_text_view_layout, this, true);
    }

    public void setData(java.lang.String str) {
        this.b.text.setText(str);
    }
}
