package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TitleMessageView extends android.widget.FrameLayout {
    private final com.up366.mobile.databinding.MessageViewBinding b;

    public TitleMessageView(android.content.Context context) {
        this(context, null);
    }

    public TitleMessageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TitleMessageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.up366.mobile.databinding.MessageViewBinding messageViewBinding = (com.up366.mobile.databinding.MessageViewBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.message_view, this, true);
        this.b = messageViewBinding;
        com.up366.mobile.common.utils.ViewUtil.gone(messageViewBinding.tvNum);
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.TitleMessageView);
            int i2 = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            messageViewBinding.msgIcon.setImageResource(i2 == 1 ? com.up366.mobile.R.drawable.icon_news_white : com.up366.mobile.R.drawable.icon_news);
        }
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.TitleMessageView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(android.view.View view) {
        getContext().startActivity(new android.content.Intent(getContext(), (java.lang.Class<?>) com.up366.mobile.user.message.UserMessageActivity.class));
    }

    public void setIconType(int i) {
        this.b.msgIcon.setImageResource(i == 1 ? com.up366.mobile.R.drawable.icon_news_white : com.up366.mobile.R.drawable.icon_news);
    }

    public void setMsgNum(int i) {
        if (i > 0) {
            this.b.tvNum.setText(java.lang.String.valueOf(i));
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.tvNum);
        } else {
            com.up366.mobile.common.utils.ViewUtil.gone(this.b.tvNum);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.title_bar_height), 0), android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.title_bar_height), 0));
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.MessageLoad messageLoad) {
        if (messageLoad.resp == null || !messageLoad.resp.isError()) {
            if (!com.up366.mobile.common.logic.Auth.isAuth() || messageLoad.result == null || messageLoad.result.size() == 0) {
                com.up366.mobile.common.utils.ViewUtil.gone(this.b.tvNum);
                return;
            }
            java.util.Iterator<com.up366.mobile.common.logic.model.Messages> it = messageLoad.result.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().getReadFlag() == 0) {
                    i++;
                }
            }
            if (i == 0) {
                com.up366.mobile.common.utils.ViewUtil.gone(this.b.tvNum);
                return;
            }
            com.up366.mobile.common.dialog.MessageCommonDialog.handleCommentMessage(messageLoad.result);
            com.up366.mobile.common.dialog.AccountNotifyDialog.handleCommentMessage(messageLoad.result);
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.tvNum);
            this.b.tvNum.setText(i < 100 ? java.lang.String.valueOf(i) : "99+");
        }
    }
}
