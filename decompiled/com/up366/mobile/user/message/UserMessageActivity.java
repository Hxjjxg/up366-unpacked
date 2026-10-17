package com.up366.mobile.user.message;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class UserMessageActivity extends com.up366.mobile.common.base.BaseActivity {
    private static final java.lang.String TAG = "UserMessageActivity";
    private com.up366.mobile.databinding.UserMessageActivityLayoutBinding binding;
    private com.up366.mobile.user.message.UserMessageAdpter messageAdpter;
    com.up366.qmui.recyclerView.QMUIRVItemSwipeAction swipeAction;
    private java.util.List<com.up366.mobile.common.logic.model.Messages> messages = new java.util.ArrayList();
    private boolean firstPullDown = true;

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "smartroom_message";
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.common.EventBusUtilsUp.register(this);
        this.binding = (com.up366.mobile.databinding.UserMessageActivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.user_message_activity_layout);
        new com.up366.mobile.common.helper.AppBarRefreshLayoutHelper().binding(this.binding.appBar, this.binding.refreshLayout, this.binding.recycleView);
        this.messageAdpter = new com.up366.mobile.user.message.UserMessageAdpter(this);
        this.binding.recycleView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this));
        this.binding.recycleView.setAdapter(this.messageAdpter);
        com.up366.qmui.recyclerView.QMUIRVItemSwipeAction qMUIRVItemSwipeAction = new com.up366.qmui.recyclerView.QMUIRVItemSwipeAction(false, new com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.Callback() { // from class: com.up366.mobile.user.message.UserMessageActivity.1
            @Override // com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.Callback
            public int getSwipeDirection(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
                return viewHolder instanceof com.up366.qmui.recyclerView.QMUISwipeViewHolder ? 1 : 0;
            }

            @Override // com.up366.qmui.recyclerView.QMUIRVItemSwipeAction.Callback
            public void onClickAction(com.up366.qmui.recyclerView.QMUIRVItemSwipeAction qMUIRVItemSwipeAction2, androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, com.up366.qmui.recyclerView.QMUISwipeAction qMUISwipeAction) {
                super.onClickAction(qMUIRVItemSwipeAction2, viewHolder, qMUISwipeAction);
                if (viewHolder instanceof com.up366.qmui.recyclerView.QMUISwipeViewHolder) {
                    com.up366.mobile.user.message.UserMessageActivity.this.handleDeleteClick(viewHolder.getAdapterPosition());
                }
            }
        });
        this.swipeAction = qMUIRVItemSwipeAction;
        qMUIRVItemSwipeAction.attachToRecyclerView(this.binding.recycleView);
        this.binding.refreshLayout.setOnPullDownListener(new com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener() { // from class: com.up366.mobile.user.message.UserMessageActivity$$ExternalSyntheticLambda2
            @Override // com.ylw.pullrefreshlibrary.PullRefreshLayout.OnPullDownListener
            public final void onRefresh() {
                com.up366.mobile.common.logic.Auth.cur().info().fetchUserMessageList();
            }
        });
        this.binding.ivMsgUnread.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.message.UserMessageActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$1(view);
            }
        });
        this.binding.refreshLayout.doRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(android.view.View view) {
        handleSetAllReadClick();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onResume() {
        super.onResume();
        if (androidx.core.app.NotificationManagerCompat.from(this).areNotificationsEnabled()) {
            this.binding.noNotification.setVisibility(8);
        } else {
            this.binding.noNotification.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDeleteClick(int i) {
        com.up366.mobile.common.logic.model.Messages messagesRemove = this.messages.remove(i);
        com.up366.mobile.common.logic.Auth.cur().info().deleteMessages(messagesRemove);
        com.up366.common.log.Logger.info("UserMeessageActivity handleDeleteClick position=" + i + "  message=" + messagesRemove.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void handleSetAllReadClick() {
        java.util.Iterator<com.up366.mobile.common.logic.model.Messages> it = this.messages.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().getReadFlag() == 0) {
                z = true;
            }
        }
        if (z) {
            updateReadMessageToWeb();
        } else {
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "消息已全部已读");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateReadMessageToWeb() {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "设置全部已读中");
        com.up366.mobile.common.logic.Auth.cur().info().updateMarkReadAllMessage(new com.up366.common.callback.ICallbackResponse() { // from class: com.up366.mobile.user.message.UserMessageActivity$$ExternalSyntheticLambda5
            @Override // com.up366.common.callback.ICallbackResponse
            public final void onResult(com.up366.common.http.Response response, java.lang.Object obj) {
                this.f$0.lambda$updateReadMessageToWeb$3(response, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$updateReadMessageToWeb$3(com.up366.common.http.Response response, java.lang.Object obj) {
        com.up366.mobile.common.utils.ToastPopupUtil.dismiss((android.app.Activity) this);
        if (response.isError()) {
            com.up366.common.log.Logger.error("UserMessageActivity handleSetAllReadClick set all message readed error " + response.toString());
            com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, getResources().getString(com.up366.mobile.R.string.wrong_net_error));
            return;
        }
        com.up366.common.log.Logger.info("UserMessageActivity HandleSetAllReadClick set all message readed success");
        com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "消息已全部已读");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.up366.mobile.common.logic.model.Messages messages : this.messages) {
            if (messages.getReadFlag() == 0) {
                messages.setReadFlag(1);
                arrayList.add(messages);
            }
        }
        com.up366.mobile.common.logic.Auth.cur().info().updateAll(arrayList);
        com.up366.common.task.TaskUtils.postMainTaskDelay(500L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.message.UserMessageActivity$$ExternalSyntheticLambda4
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.common.logic.Auth.cur().info().loadMessageList();
            }
        });
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.UpdateMessageReadFlag updateMessageReadFlag) {
        java.util.Iterator<com.up366.mobile.common.logic.model.Messages> it = this.messages.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.up366.mobile.common.logic.model.Messages next = it.next();
            if (next.getMsgId().equals(updateMessageReadFlag.m.getMsgId())) {
                next.setReadFlag(1);
                break;
            }
        }
        com.up366.mobile.common.logic.Auth.cur().info().updateMessage(updateMessageReadFlag.m);
        com.up366.common.task.TaskUtils.postMainTaskDelay(500L, new com.up366.common.task.Task() { // from class: com.up366.mobile.user.message.UserMessageActivity$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() {
                com.up366.mobile.common.logic.Auth.cur().info().loadMessageList();
            }
        });
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.MessageLoad messageLoad) {
        if (messageLoad.resp != null) {
            this.binding.refreshLayout.complete();
        }
        if (messageLoad.resp != null && messageLoad.resp.isError()) {
            com.up366.common.log.Logger.info("UserMessageActivity onMessageEvent resp error code=" + messageLoad.resp.getCode() + " info=" + messageLoad.resp.getInfo() + " messages size=" + this.messages.size());
            showNetErrorView();
            return;
        }
        this.messages = messageLoad.result;
        showNoReadNumber(messageLoad.resp);
        this.messageAdpter.reset();
        this.messageAdpter.lambda$setDatas$0(com.up366.mobile.common.utils.DataHolderUtils.convertToDataHolder(this.messages));
        if (messageLoad.resp == null || !this.firstPullDown) {
            return;
        }
        this.firstPullDown = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showNetErrorView() {
        if (this.messages.size() == 0) {
            com.up366.mobile.common.views.viewmodel.EmptyViewModel emptyViewModelBuild = new com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder().setType(1).setRightBtnListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.user.message.UserMessageActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$showNetErrorView$5(view);
                }
            }).build();
            this.messageAdpter.reset();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(-1, emptyViewModelBuild));
            this.messageAdpter.lambda$setDatas$0(arrayList);
            return;
        }
        com.up366.mobile.common.utils.ToastPopupUtil.showError((android.app.Activity) this, getResources().getString(com.up366.mobile.R.string.wrong_net_error));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showNetErrorView$5(android.view.View view) {
        this.binding.refreshLayout.doRefresh();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showNoReadNumber(com.up366.common.http.Response response) {
        java.util.Iterator<com.up366.mobile.common.logic.model.Messages> it = this.messages.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getReadFlag() == 0) {
                i++;
            }
        }
        if (i == 0) {
            this.binding.ivMsgUnread.setImageResource(com.up366.mobile.R.drawable.message_already_clean);
            if (response != null && !this.firstPullDown && !this.messages.isEmpty()) {
                com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "没有未读的消息");
            }
        } else {
            this.binding.ivMsgUnread.setImageResource(com.up366.mobile.R.drawable.message_clean);
        }
        this.binding.tvMsgUnreadNumber.setText(i + "条消息未读");
    }
}
