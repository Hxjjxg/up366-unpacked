package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class InterestSelectCourseItemView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.InterestSelectCourseItemViewLayoutBinding b;

    public InterestSelectCourseItemView(android.content.Context context) {
        this(context, null);
    }

    public InterestSelectCourseItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterestSelectCourseItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.InterestSelectCourseItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.interest_select_course_item_view_layout, this, true);
    }

    public void setData(final com.up366.mobile.course.mgr.CourseInfo courseInfo, final com.up366.common.callback.ICallbackCodeInfoObj<com.up366.mobile.course.mgr.CourseInfo> iCallbackCodeInfoObj) {
        this.b.text.setText(courseInfo.getCourseName());
        this.b.check.setChecked(courseInfo.isCheck());
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.InterestSelectCourseItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                iCallbackCodeInfoObj.onResult(0, null, courseInfo);
            }
        });
    }
}
