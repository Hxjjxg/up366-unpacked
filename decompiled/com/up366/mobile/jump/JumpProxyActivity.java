package com.up366.mobile.jump;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class JumpProxyActivity extends com.up366.mobile.common.base.BaseActivity {
    private java.lang.String jumpUrl = null;

    @Override // com.up366.mobile.common.base.BaseActivity
    protected boolean startActivityBeforeCheck() {
        return false;
    }

    public static void skip(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.jump.JumpProxyActivity.class);
        intent.putExtra("data", str);
        intent.putExtra("type", 0);
        context.startActivity(intent);
    }

    public static void skipByWx(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.main.MainActivity.class);
        android.content.Intent intent2 = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.jump.JumpProxyActivity.class);
        intent2.putExtra("data", str);
        intent2.putExtra("type", 1);
        context.startActivities(new android.content.Intent[]{intent, intent2});
    }

    public static void skipChat(android.content.Context context, java.lang.String str) {
        com.up366.mobile.common.onlinelog.OpLog.record("skipChat", com.up366.mobile.common.logic.Auth.UID() + ": " + str);
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.jump.JumpProxyActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("data", "up366mobile://chat?groupid=" + str);
        intent.putExtra("type", 0);
        context.startActivity(intent);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.up366.mobile.R.layout.jump_proxy_activity_layout);
        if (getIntent().getIntExtra("type", 0) == 1) {
            setTheme(com.up366.mobile.R.style.AppTheme);
            findViewById(com.up366.mobile.R.id.root_view).setBackgroundColor(-1);
        }
        com.up366.common.task.TaskUtils.postMainTaskDelay(10L, new com.up366.common.task.Task() { // from class: com.up366.mobile.jump.JumpProxyActivity$$ExternalSyntheticLambda0
            @Override // com.up366.common.task.Task
            public final void run() throws java.lang.Exception {
                this.f$0.lambda$onCreate$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$onCreate$0() throws java.lang.Exception {
        com.up366.mobile.common.utils.ToastPopupUtil.showLoading((android.app.Activity) this, "正在加载");
        initIntent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initIntent() {
        java.lang.String strDecodeUrl = com.up366.mobile.jump.JumpUtils.decodeUrl(getIntent().getStringExtra("data"));
        com.up366.common.log.Logger.info("initIntent  " + strDecodeUrl);
        if (com.up366.common.StringUtils.isEmptyOrNull(strDecodeUrl)) {
            java.lang.String dataString = getIntent().getDataString();
            if (com.up366.common.StringUtils.isEmptyOrNull(dataString)) {
                com.up366.mobile.jump.JumpIntentUtils.onJumpError(this, "跳转信息为空...");
            }
            strDecodeUrl = dataString.replace("up366mobile://?", "");
            if (com.up366.common.StringUtils.isEmptyOrNull(strDecodeUrl)) {
                com.up366.mobile.jump.JumpIntentUtils.onJumpError(this, null);
                return;
            }
        }
        this.jumpUrl = strDecodeUrl;
        int iJudgeUrlType = com.up366.mobile.jump.JumpUtils.judgeUrlType(strDecodeUrl);
        com.up366.common.log.Logger.info("initIntent  jumpType " + iJudgeUrlType + "   " + strDecodeUrl);
        switch (iJudgeUrlType) {
            case 0:
                com.up366.mobile.jump.JumpIntentUtils.onJumpToBookImmediately(this, strDecodeUrl);
                break;
            case 1:
                com.up366.mobile.jump.JumpIntentUtils.onJumpToBookWithToken(this, strDecodeUrl);
                break;
            case 2:
                if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
                    com.up366.mobile.jump.JumpIntentUtils.onJumpJustStr(this, "扫一扫功能暂不支持网址二维码");
                } else {
                    com.up366.mobile.jump.JumpIntentUtils.onJumpWebview(this, strDecodeUrl);
                }
                break;
            case 3:
                com.up366.mobile.jump.JumpIntentUtils.onJumpJustStr(this, strDecodeUrl);
                break;
            case 4:
                com.up366.mobile.jump.JumpIntentUtils.onJumpToBookWithNantong(this, strDecodeUrl);
                break;
            case 5:
            case 9:
            default:
                com.up366.mobile.jump.JumpIntentUtils.onJumpError(this, "未知错误...");
                break;
            case 6:
                com.up366.mobile.jump.JumpIntentUtils.onJumpToDailyWriteTry(this, strDecodeUrl);
                break;
            case 7:
                com.up366.mobile.jump.JumpIntentUtils.onJumpToNewJobDetail(this, strDecodeUrl);
                break;
            case 8:
                com.up366.mobile.jump.JumpIntentUtils.onJumpToBookCommon(this, strDecodeUrl);
                break;
            case 10:
                com.up366.mobile.jump.JumpIntentUtils.onJssdkWebView(this, strDecodeUrl);
                break;
        }
    }
}
