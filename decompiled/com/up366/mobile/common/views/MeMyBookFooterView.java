package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MeMyBookFooterView extends android.widget.LinearLayout {
    private final com.up366.mobile.databinding.MeMyBookSelectorFooterViewBinding binding;
    private android.view.View.OnClickListener listener;

    public MeMyBookFooterView(final android.content.Context context) {
        super(context);
        com.up366.mobile.databinding.MeMyBookSelectorFooterViewBinding meMyBookSelectorFooterViewBinding = (com.up366.mobile.databinding.MeMyBookSelectorFooterViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.me_my_book_selector_footer_view, this, true);
        this.binding = meMyBookSelectorFooterViewBinding;
        meMyBookSelectorFooterViewBinding.footerText.setText(new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append("以前没有我想要加入的班级？").append("点击加入").setSpan(new android.text.style.ClickableSpan() { // from class: com.up366.mobile.common.views.MeMyBookFooterView.1
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
            }
        }).build());
        meMyBookSelectorFooterViewBinding.footerText.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.MeMyBookFooterView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$1(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(final android.content.Context context, android.view.View view) {
        this.listener.onClick(view);
        com.up366.common.task.TaskUtils.postMainTaskDelay(250L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.MeMyBookFooterView$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.views.MeMyBookFooterView.lambda$new$0(context);
            }
        });
    }

    static /* synthetic */ void lambda$new$0(android.content.Context context) throws java.lang.Exception {
        if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("该版本不支持");
        } else {
            com.up366.mobile.me.teacherclass.MeAddTeachingClassActivity.openPage(context);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(android.view.View.OnClickListener onClickListener) {
        this.listener = onClickListener;
    }
}
