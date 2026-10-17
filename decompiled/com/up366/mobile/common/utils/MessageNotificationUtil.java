package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MessageNotificationUtil {
    public static java.lang.String msg = "{\"content\":\"你的练习成绩是13.5分，快来看看吧！\",\"ext\":{\"classComment\":false,\"classHomeworkComment\":false,\"comment\":false,\"commentType\":0,\"courseId\":0,\"needShow\":false,\"noticeId\":0,\"personComment\":false,\"personHomeworkComment\":false,\"showType\":0,\"updateAccountNotice\":false},\"extend\":\"{\\\"url\\\":\\\"http://www.baidu.com\\\"}\",\"formatSendTime\":\"16:46\",\"from\":\"up0172\",\"messageListPrefix\":\"\",\"msgId\":\"60E535328740D12F7E1FCC1BD8B3394C\",\"msgType\":1,\"pushId\":\"60E535328740D12F7E1FCC1BD8B3394C\",\"readFlag\":0,\"readTime\":0,\"rowId\":3,\"selected\":false,\"sendTime\":1684140395423,\"subject\":\"你有一份新的练习报告\",\"toUid\":0,\"type\":0}";

    public static void showNotification(com.up366.mobile.common.logic.model.Messages messages) {
        if (com.up366.mobile.common.utils.AppFuncController.func(com.up366.mobile.common.utils.AppFuncController.FUNC_NOTICE).isInBlackList() || com.up366.mobile.common.utils.PlatformUtils.isClosePad() || !com.up366.mobile.user.setting.PushMessageHelper.getInst().getPushMessageState()) {
            return;
        }
        android.content.Context applicationContext = com.up366.common.global.GB.get().getApplicationContext();
        createChannelByMessage(applicationContext, messages);
        androidx.core.app.NotificationCompat.Builder lights = new androidx.core.app.NotificationCompat.Builder(applicationContext, getChannelIdNameByMessage(messages)[0]).setSmallIcon(com.up366.mobile.R.mipmap.ic_launcher).setContentTitle(messages.getSubject()).setContentText(messages.getContent().replaceAll("<script .*?(/>|/script>)", " ").replaceAll("<link .*?(/>|/link>)", " ").replaceAll("<style .*?(/>|/style>)", " ").replaceAll("<.*?>", " ").replaceAll(" +", " ")).setAutoCancel(true).setLights(-16711936, 3000, 1000);
        android.content.Intent intentDefaultMessageDetailIntent = defaultMessageDetailIntent(applicationContext, messages);
        if (messages.getContent().contains("up366mobile://")) {
            intentDefaultMessageDetailIntent = defaultProxyActivityIntent(applicationContext, messages.getContent().substring(messages.getContent().indexOf("up366mobile://")));
        }
        java.lang.String extend = messages.getExtend();
        if (!com.up366.common.StringUtils.isEmptyOrNull(extend)) {
            java.lang.String string = com.alibaba.fastjson.JSONObject.parseObject(extend).getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
            if (!com.up366.common.StringUtils.isEmptyOrNull(string)) {
                intentDefaultMessageDetailIntent = defaultProxyActivityIntent(applicationContext, string);
            }
        }
        lights.setContentIntent(android.app.PendingIntent.getActivity(applicationContext, 0, intentDefaultMessageDetailIntent, 201326592));
        androidx.core.app.NotificationManagerCompat.from(applicationContext).notify(messages.getMsgId().hashCode(), lights.build());
        ring();
    }

    private static android.content.Intent defaultMessageDetailIntent(android.content.Context context, com.up366.mobile.common.logic.model.Messages messages) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.user.message.UserMessageDetailActivity.class);
        intent.putExtra("message", messages);
        intent.setAction(java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        return intent;
    }

    private static android.content.Intent defaultProxyActivityIntent(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.jump.JumpProxyActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("data", com.up366.mobile.jump.JumpUtils.encodeUrl(str));
        intent.setAction(java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
        return intent;
    }

    private static void createChannelByMessage(android.content.Context context, com.up366.mobile.common.logic.model.Messages messages) {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            java.lang.String[] channelIdNameByMessage = getChannelIdNameByMessage(messages);
            createNotificationChannel(context, channelIdNameByMessage[0], channelIdNameByMessage[1], 3);
        }
    }

    private static java.lang.String[] getChannelIdNameByMessage(com.up366.mobile.common.logic.model.Messages messages) {
        return new java.lang.String[]{"notify", "消息通知"};
    }

    private static void createNotificationChannel(android.content.Context context, java.lang.String str, java.lang.String str2, int i) {
        android.app.NotificationChannel notificationChannelM = com.up366.mobile.book.helper.Tools$$ExternalSyntheticApiModelOutline0.m(str, str2, i);
        notificationChannelM.enableLights(true);
        notificationChannelM.setLightColor(-65536);
        notificationChannelM.setShowBadge(true);
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) context.getSystemService(com.igexin.push.core.b.n);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannelM);
        }
    }

    public static void clearNotification(com.up366.mobile.common.logic.model.Messages messages) {
        androidx.core.app.NotificationManagerCompat.from(com.up366.common.global.GB.get().getApplicationContext()).cancel(messages.getMsgId().hashCode());
    }

    private static void ring() {
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            return;
        }
        com.up366.mobile.common.utils.DataPostDelay.doIfNoCache("RingtoneManager", 5, new com.up366.mobile.common.utils.MessageNotificationUtil.AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.utils.MessageNotificationUtil$1, reason: invalid class name */
    class AnonymousClass1 implements java.lang.Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.utils.MessageNotificationUtil$1$$ExternalSyntheticLambda0
                @Override // com.up366.common.task.Task
                public final void run() {
                    android.media.RingtoneManager.getRingtone(com.up366.common.global.GB.get().getApplicationContext(), android.media.RingtoneManager.getDefaultUri(2)).play();
                }
            });
        }
    }
}
