package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CourseCountHelper {
    private final com.up366.mobile.common.views.TitleBarView titleBar;

    public CourseCountHelper(com.up366.mobile.common.views.TitleBarView titleBarView, final com.up366.mobile.book.model.BookInfoStudy bookInfoStudy) {
        this.titleBar = titleBarView;
        if (bookInfoStudy.getCourseId() > 0) {
            titleBarView.binding.rightText.setText("统计");
            titleBarView.binding.rightText.setVisibility(8);
            com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(titleBarView.binding.rightText, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.helper.CourseCountHelper$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.book.helper.CourseCountHelper.lambda$new$0(bookInfoStudy, view);
                }
            });
        }
    }

    static /* synthetic */ void lambda$new$0(com.up366.mobile.book.model.BookInfoStudy bookInfoStudy, android.view.View view) {
        if (!com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show(com.up366.common.global.GB.get().getCurrentActivity(), "请先连接网络");
            return;
        }
        android.content.Intent intent = new android.content.Intent(view.getContext(), (java.lang.Class<?>) com.up366.mobile.course.count.CountActivity.class);
        intent.putExtra("book", bookInfoStudy);
        view.getContext().startActivity(intent);
    }

    public void showDashboard() {
        this.titleBar.binding.rightText.setVisibility(0);
    }
}
