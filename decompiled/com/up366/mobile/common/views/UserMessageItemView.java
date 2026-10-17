package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UserMessageItemView extends android.widget.LinearLayout {
    private com.up366.mobile.databinding.UserMessageItemViewBinding binding;
    private com.up366.mobile.common.logic.model.Messages messages;

    public UserMessageItemView(android.content.Context context) {
        super(context);
        init();
    }

    public UserMessageItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public UserMessageItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.binding = (com.up366.mobile.databinding.UserMessageItemViewBinding) androidx.databinding.DataBindingUtil.inflate(com.up366.common.global.GB.get().getCurrentActivity().getLayoutInflater(), com.up366.mobile.R.layout.user_message_item_view, this, true);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.UserMessageItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(android.view.View view) {
        this.messages.setReadFlag(1);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.UpdateMessageReadFlag(this.messages));
        android.content.Intent intent = new android.content.Intent(view.getContext(), (java.lang.Class<?>) com.up366.mobile.user.message.UserMessageDetailActivity.class);
        intent.putExtra("message", this.messages);
        view.getContext().startActivity(intent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLayoutParams().width = -1;
        requestLayout();
    }

    public void setData(com.up366.mobile.common.logic.model.Messages messages) {
        this.messages = messages;
        if (messages.getExt().isComment()) {
            if (messages.getExt().isPersonHomeworkComment() || messages.getExt().isClassHomeworkComment()) {
                this.binding.ivMsgIcon.setImageResource(com.up366.mobile.R.drawable.icon_msg_comment_task);
            } else {
                this.binding.ivMsgIcon.setImageResource(com.up366.mobile.R.drawable.icon_msg_comment);
            }
        } else {
            this.binding.ivMsgIcon.setImageResource(com.up366.mobile.R.drawable.icon_message_notice);
        }
        this.binding.tvMsgEndTime.setText(messages.getFormatSendTime());
        this.binding.tvMsgTitle.setText(messages.getSubject());
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("<a[^>]*>(.*?)</a>").matcher(messages.getContent().split("\n")[0]);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        while (matcher.find()) {
            java.lang.String strGroup = matcher.group(1);
            if (strGroup != null) {
                matcher.appendReplacement(stringBuffer, strGroup);
            }
        }
        matcher.appendTail(stringBuffer);
        this.binding.tvMsgContent.setText(stringBuffer);
        if (messages.getReadFlag() == 0) {
            this.binding.civMsgNoRead.setVisibility(0);
        } else {
            this.binding.civMsgNoRead.setVisibility(8);
        }
    }
}
