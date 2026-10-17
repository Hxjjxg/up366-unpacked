package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BreakReminderUtils {
    private static final java.lang.String STUDY_TIME = "localStudyLength";
    private static volatile boolean isInBackground;
    private static android.os.CountDownTimer timer;
    private static long mMoveToForegroundTime = java.lang.System.currentTimeMillis();
    private static long mMoveToBackgroundTime = java.lang.System.currentTimeMillis();

    public static void init() {
        androidx.lifecycle.ProcessLifecycleOwner.get().getLifecycle().addObserver(new com.up366.mobile.common.views.BreakReminderUtils.MyAppLifecycleListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showDialog() {
        android.app.Activity currentActivity;
        if (!com.up366.mobile.common.logic.Auth.isAuth() || (currentActivity = com.up366.common.global.GB.get().getCurrentActivity()) == null || currentActivity.isDestroyed() || currentActivity.isFinishing()) {
            return;
        }
        android.widget.Toast toast = new android.widget.Toast(currentActivity);
        toast.setView(android.view.View.inflate(currentActivity, com.up366.mobile.R.layout.break_remaind_toast_layout, null));
        toast.setDuration(1);
        toast.setGravity(55, 0, 0);
        toast.show();
    }

    static class MyAppLifecycleListener implements androidx.lifecycle.LifecycleObserver {
        MyAppLifecycleListener() {
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        @androidx.lifecycle.OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_CREATE)
        public void onAppCreate() throws kotlin.NoWhenBranchMatchedException {
            com.up366.mobile.AppStateMonitor.INSTANCE.onBoot();
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        @androidx.lifecycle.OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START)
        public void onMoveToForeground() throws kotlin.NoWhenBranchMatchedException {
            com.up366.mobile.AppStateMonitor.INSTANCE.onForeground();
            com.up366.mobile.common.screenshot.ScreenShotManager.getInstance().startListen();
            com.up366.mobile.common.views.BreakReminderUtils.mMoveToForegroundTime = java.lang.System.currentTimeMillis();
            if (com.up366.mobile.common.views.BreakReminderUtils.mMoveToForegroundTime - com.up366.mobile.common.views.BreakReminderUtils.mMoveToBackgroundTime > com.up366.mobile.common.logic.model.AppCacheInfo.TIME_MINUTE_5 || com.up366.mobile.common.views.BreakReminderUtils.timer == null) {
                if (com.up366.mobile.common.views.BreakReminderUtils.timer != null) {
                    com.up366.mobile.common.views.BreakReminderUtils.timer.cancel();
                } else {
                    com.up366.mobile.common.views.BreakReminderUtils.timer = new com.up366.mobile.common.views.BreakReminderUtils.MyAppLifecycleListener.AnonymousClass1(com.igexin.push.config.c.B, 60000L);
                }
                com.up366.mobile.common.views.BreakReminderUtils.timer.start();
            }
            com.up366.mobile.common.views.BreakReminderUtils.isInBackground = false;
        }

        /* JADX INFO: renamed from: com.up366.mobile.common.views.BreakReminderUtils$MyAppLifecycleListener$1, reason: invalid class name */
        class AnonymousClass1 extends android.os.CountDownTimer {
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            AnonymousClass1(long j, long j2) {
                super(j, j2);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (!com.up366.mobile.common.views.BreakReminderUtils.isInBackground) {
                    com.up366.common.task.TaskUtils.postMainTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.views.BreakReminderUtils$MyAppLifecycleListener$1$$ExternalSyntheticLambda0
                        @Override // com.up366.common.task.Task
                        public final void run() {
                            com.up366.mobile.common.views.BreakReminderUtils.showDialog();
                        }
                    });
                }
                com.up366.mobile.common.views.BreakReminderUtils.timer.start();
            }
        }

        @androidx.lifecycle.OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP)
        public void onMoveToBackground() {
            com.up366.mobile.AppStateMonitor.INSTANCE.onBackGround();
            com.up366.mobile.common.screenshot.ScreenShotManager.getInstance().stopListen();
            com.up366.mobile.common.views.BreakReminderUtils.isInBackground = true;
            com.up366.mobile.common.views.BreakReminderUtils.saveStudyLength();
            com.up366.mobile.common.views.BreakReminderUtils.mMoveToBackgroundTime = java.lang.System.currentTimeMillis();
        }
    }

    public static void saveStudyLength() {
        long jLongValue;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("上次本地存储时间：");
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyyMMdd", java.util.Locale.CHINA);
        java.lang.String str = simpleDateFormat.format(new java.util.Date(java.lang.System.currentTimeMillis()));
        java.lang.String str2 = simpleDateFormat.format(java.lang.Long.valueOf(mMoveToForegroundTime));
        java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString(STUDY_TIME + com.up366.mobile.common.logic.Auth.UID(), "");
        sb.append(string);
        sb.append("\n开始学习时间：");
        sb.append(com.up366.common.TimeUtils.formatTime(mMoveToForegroundTime, "yyyy-MM-dd HH:mm:ss"));
        sb.append("\n当前时间：");
        sb.append(com.up366.common.TimeUtils.formatTime(java.lang.System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        sb.append("\n");
        if (!str2.equals(str)) {
            sb.append("发生跨夜行为\n");
            jLongValue = 0;
            try {
                jLongValue = java.lang.System.currentTimeMillis() - simpleDateFormat.parse(str).getTime();
                sb.append("自凌晨之后的学习时长:");
                sb.append(jLongValue);
                sb.append("\n");
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        } else {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - mMoveToForegroundTime;
            sb.append("未发生跨夜行为，本次学习时长：");
            sb.append(jCurrentTimeMillis);
            sb.append("\n");
            jLongValue = (com.up366.common.StringUtils.isEmptyOrNull(string) || !str.equals(com.alibaba.fastjson.JSONObject.parseObject(string).getString("formatTime"))) ? jCurrentTimeMillis : com.alibaba.fastjson.JSONObject.parseObject(string).getLong("studyLength").longValue() + jCurrentTimeMillis;
        }
        sb.append("累计学习时长：");
        sb.append(jLongValue);
        sb.append("\n保存的本地数据：");
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("studyLength", java.lang.Long.valueOf(jLongValue));
        jSONObject.put("formatTime", str);
        com.up366.mobile.common.utils.PreferenceUtils.putString(STUDY_TIME + com.up366.mobile.common.logic.Auth.UID(), jSONObject.toJSONString());
        sb.append(jSONObject);
        sb.append("\n");
        com.up366.common.log.Logger.info(com.alibaba.fastjson.JSON.toJSONString(sb.toString()));
    }

    public static long getStudyLength() {
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyyMMdd", java.util.Locale.CHINA);
        java.lang.String str = simpleDateFormat.format(new java.util.Date(java.lang.System.currentTimeMillis()));
        java.lang.String str2 = simpleDateFormat.format(java.lang.Long.valueOf(mMoveToForegroundTime));
        java.lang.String string = com.up366.mobile.common.utils.PreferenceUtils.getString(STUDY_TIME + com.up366.mobile.common.logic.Auth.UID(), "");
        if (!str2.equals(str)) {
            try {
                return java.lang.System.currentTimeMillis() - simpleDateFormat.parse(str).getTime();
            } catch (java.text.ParseException e) {
                e.printStackTrace();
                return 0L;
            }
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - mMoveToForegroundTime;
        return (com.up366.common.StringUtils.isEmptyOrNull(string) || !str.equals(com.alibaba.fastjson.JSONObject.parseObject(string).getString("formatTime"))) ? jCurrentTimeMillis : jCurrentTimeMillis + com.alibaba.fastjson.JSONObject.parseObject(string).getLong("studyLength").longValue();
    }

    public static java.lang.String getStudyLengthString() {
        java.lang.String str;
        long studyLength = getStudyLength();
        if (studyLength < 60000) {
            return "1分钟";
        }
        long j = (studyLength / 1000) / 60;
        int i = (int) ((j / 60) % 24);
        int i2 = (int) (j % 60);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (i > 0) {
            str = i + "小时";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(i2);
        sb.append("分钟");
        return sb.toString();
    }

    public static boolean isInBackground() {
        return isInBackground;
    }
}
