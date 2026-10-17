package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BlueButtonBottomView extends android.widget.FrameLayout {
    private static final int KILL_TYPE_KILL_WORD = 2;
    private static final int KILL_TYPE_SELECT_WORD = 3;
    private static final int KILL_TYPE_WRONG = 1;
    private static final int REPLAY_AGAIN = 4;
    private com.up366.mobile.databinding.CourseWrongDetailBottomViewBinding b;
    private android.content.Context context;
    private int killType;

    public BlueButtonBottomView(android.content.Context context) {
        super(context);
        this.killType = 1;
        this.context = context;
        init(null);
    }

    public BlueButtonBottomView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.killType = 1;
        this.context = context;
        init(attributeSet);
    }

    public BlueButtonBottomView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.killType = 1;
        this.context = context;
        init(attributeSet);
    }

    private void init(android.util.AttributeSet attributeSet) {
        java.lang.String str;
        this.b = (com.up366.mobile.databinding.CourseWrongDetailBottomViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.course_wrong_detail_bottom_view, this, true);
        if (attributeSet == null) {
            return;
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.BlueButtonBottomView);
        this.killType = typedArrayObtainStyledAttributes.getInt(0, 1);
        typedArrayObtainStyledAttributes.recycle();
        int i = this.killType;
        if (i == 2) {
            str = "单词跟读";
        } else if (i == 3) {
            str = "词义选择";
        } else {
            str = i != 4 ? "消灭错题" : "重新提交";
        }
        this.b.killQuestion.setText(str);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.b.killQuestion.setEnabled(z);
    }

    @Override // android.view.View
    public void setOnClickListener(android.view.View.OnClickListener onClickListener) {
        this.b.killQuestion.setOnClickListener(onClickListener);
    }
}
