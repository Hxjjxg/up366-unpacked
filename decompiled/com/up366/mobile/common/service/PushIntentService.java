package com.up366.mobile.common.service;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PushIntentService extends com.igexin.sdk.GTIntentService {
    public PushIntentService() {
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveServicePid(android.content.Context context, int i) {
        com.up366.common.log.Logger.debug("onReceiveServicePid : " + i);
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveMessageData(android.content.Context context, com.igexin.sdk.message.GTTransmitMessage gTTransmitMessage) {
        boolean zSendFeedbackMessage = com.igexin.sdk.PushManager.getInstance().sendFeedbackMessage(context, gTTransmitMessage.getTaskId(), gTTransmitMessage.getMessageId(), com.igexin.sdk.PushConsts.MIN_FEEDBACK_ACTION);
        com.up366.common.log.Logger.debug("onReceiveMessageData : ".concat(new java.lang.String(gTTransmitMessage.getPayload())));
        com.up366.common.log.Logger.debug("送达回执 ： " + zSendFeedbackMessage);
        handleMessagePush(new java.lang.String(gTTransmitMessage.getPayload()));
    }

    private void handleMessagePush(java.lang.String str) {
        try {
            executeMessagePush((com.up366.mobile.common.logic.model.Messages) com.alibaba.fastjson.JSON.parseObject(str, com.up366.mobile.common.logic.model.Messages.class));
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("Exception e:" + e.getMessage());
        }
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveClientId(android.content.Context context, java.lang.String str) {
        com.up366.common.log.Logger.debug("onReceiveClientId -> clientid = " + str);
        com.up366.mobile.common.onlinelog.OpLog.report("push_client_id", str);
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveOnlineState(android.content.Context context, boolean z) {
        com.up366.common.log.Logger.debug("onReceiveOnlineState : " + z);
        com.up366.common.NetworkUtilsUp.checkNetworkConnect();
        com.up366.common.task.TaskUtils.postLazyTaskGlobal("PushIntentService#onReceiveOnlineState", new com.up366.common.task.Task() { // from class: com.up366.mobile.common.service.PushIntentService$$ExternalSyntheticLambda1
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.service.PushIntentService.lambda$onReceiveOnlineState$0();
            }
        });
    }

    static /* synthetic */ void lambda$onReceiveOnlineState$0() throws java.lang.Exception {
        com.up366.mobile.common.utils.DownloadHelper.resetAllowNonWiFiState();
        if (com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.mobile.common.logic.Auth.cur().logMgr().startBatchQueue();
        }
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveCommandResult(android.content.Context context, com.igexin.sdk.message.GTCmdMessage gTCmdMessage) {
        com.up366.common.log.Logger.debug("onReceiveCommandResult" + gTCmdMessage);
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onNotificationMessageArrived(android.content.Context context, com.igexin.sdk.message.GTNotificationMessage gTNotificationMessage) {
        com.up366.common.log.Logger.info("TAG - PushIntentService - onNotificationMessageArrived - context = [" + context + "], gtNotificationMessage = [" + gTNotificationMessage + "]");
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onNotificationMessageClicked(android.content.Context context, com.igexin.sdk.message.GTNotificationMessage gTNotificationMessage) {
        com.up366.common.log.Logger.info("TAG - PushIntentService - onNotificationMessageClicked - context = [" + context + "], gtNotificationMessage = [" + gTNotificationMessage + "]");
    }

    private void executeMessagePush(com.up366.mobile.common.logic.model.Messages messages) {
        if (com.up366.mobile.common.onlinelog.LocalLogTool.handle(messages)) {
            return;
        }
        if (!com.up366.mobile.common.logic.Auth.isAuth()) {
            com.up366.common.log.Logger.error("executeMessagePush no auth :" + messages.toString());
        } else {
            if (messages.getSendTime() > com.up366.mobile.common.logic.Auth.cur().info().getLastUploadClientTime()) {
                if (!messages.getContent().contains("up366mobile://")) {
                    com.up366.mobile.common.logic.Auth.cur().info().saveUserMessage(messages);
                }
                com.up366.mobile.common.logic.Auth.cur().info().fetchUserMessageList();
                com.up366.mobile.common.utils.MessageNotificationUtil.showNotification(messages);
                return;
            }
            com.up366.common.log.Logger.error("msg data" + messages.toString() + "  lastUploadClientIdTime :" + com.up366.mobile.common.logic.Auth.cur().info().getLastUploadClientTime());
        }
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.common.event.NetStatusChangeEvent netStatusChangeEvent) {
        com.up366.common.task.TaskUtils.postLazyTaskGlobal("PushIntentService#onReceiveOnlineState", new com.up366.common.task.Task() { // from class: com.up366.mobile.common.service.PushIntentService$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                com.up366.mobile.common.service.PushIntentService.lambda$onMessageEvent$1();
            }
        });
    }

    static /* synthetic */ void lambda$onMessageEvent$1() throws java.lang.Exception {
        com.up366.mobile.common.utils.DownloadHelper.resetAllowNonWiFiState();
        if (com.up366.common.NetworkUtilsUp.isConnected()) {
            com.up366.mobile.common.logic.Auth.cur().logMgr().startBatchQueue();
        }
    }
}
