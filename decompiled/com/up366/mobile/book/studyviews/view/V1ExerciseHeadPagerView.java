package com.up366.mobile.book.studyviews.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class V1ExerciseHeadPagerView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.V1ExerciseHeadPagerViewLayoutBinding b;
    private android.view.View.OnClickListener chapterListener;
    private int page;
    private int total;

    public V1ExerciseHeadPagerView(android.content.Context context) {
        this(context, null);
    }

    public V1ExerciseHeadPagerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public V1ExerciseHeadPagerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            android.view.View.inflate(context, com.up366.mobile.R.layout.v1_exercise_head_pager_view_layout, this);
        } else {
            this.b = (com.up366.mobile.databinding.V1ExerciseHeadPagerViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.v1_exercise_head_pager_view_layout, this, true);
        }
    }

    public void setTotal(int i) {
        this.total = i;
    }

    public void setPage(int i) {
        this.page = i;
        initCircleLayout(i);
    }

    private void initCircleLayout(int i) {
        int i2;
        int i3;
        int i4 = this.total;
        android.widget.LinearLayout linearLayout = this.b.exerciseHeadCircleLayout;
        linearLayout.removeAllViews();
        android.widget.ImageView imageView = new android.widget.ImageView(getContext());
        imageView.setBackgroundResource(com.up366.mobile.R.drawable.zuoti_zhangjiebofang_btn);
        imageView.setLayoutParams(new android.widget.LinearLayout.LayoutParams(com.up366.common.DpUtilsUp.dp2px(30.0f), com.up366.common.DpUtilsUp.dp2px(30.0f)));
        imageView.setId(com.up366.mobile.R.id.exercise_big_audio);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(imageView, this.chapterListener);
        linearLayout.addView(imageView);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("&nbsp;");
        int i5 = i + 1;
        if (i4 < 12) {
            int i6 = 0;
            while (i6 < i4) {
                i6++;
                addTextPage(java.lang.String.valueOf(i6), i5 == i6, sb);
            }
        }
        if (i4 > 11) {
            addTextPage(java.lang.String.valueOf(1), i5 == 1, sb);
            if (i5 < 7) {
                i3 = 8;
                i2 = 1;
            } else if (i5 <= 6 || i5 >= i4 - 4) {
                i2 = i4 - 8;
                i3 = i4;
            } else {
                i2 = i - 3;
                i3 = i + 4;
            }
            if (i2 != 1) {
                addTextPage("…", false, sb);
            }
            while (i2 < i3) {
                i2++;
                addTextPage(java.lang.String.valueOf(i2), i5 == i2, sb);
            }
            if (i3 != i4) {
                addTextPage("…", false, sb);
                addTextPage(java.lang.String.valueOf(i4), i5 == i4, sb);
            }
            sb.append("&nbsp;");
        }
        android.widget.TextView textView = new android.widget.TextView(getContext());
        textView.setText(android.text.Html.fromHtml(sb.toString()));
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(12.0f);
        linearLayout.addView(textView);
        android.widget.ImageView imageView2 = new android.widget.ImageView(getContext());
        imageView2.setBackgroundResource(com.up366.mobile.R.drawable.yzb);
        if (i5 == i4 + 1) {
            imageView2.setBackgroundResource(com.up366.mobile.R.drawable.yzb_sel);
        }
        imageView2.setLayoutParams(new android.widget.LinearLayout.LayoutParams(com.up366.common.DpUtilsUp.dp2px(20.0f), com.up366.common.DpUtilsUp.dp2px(20.0f)));
        linearLayout.addView(imageView2);
    }

    private void addTextPage(java.lang.String str, boolean z, java.lang.StringBuilder sb) {
        sb.append("&nbsp;&nbsp;<font color=\"");
        if (z) {
            sb.append("#2b95e6");
            sb.append("\">");
            sb.append("<big><big>" + str + "</big></big>");
        } else {
            sb.append("#c4c4c4");
            sb.append("\">");
            sb.append(str);
        }
        sb.append("</font>&nbsp;&nbsp;");
    }

    public void setChapterListener(android.view.View.OnClickListener onClickListener) {
        this.chapterListener = onClickListener;
    }
}
