package com.up366.mobile.user.message;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class UserMessageDetailActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.ActivityUserMessageDetailBinding binding;
    private com.up366.mobile.user.message.MessageJS js;
    private com.up366.mobile.common.logic.model.Messages messages;

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "smartroom_message_detail";
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) throws java.lang.Throwable {
        super.onCreate(bundle);
        com.up366.mobile.common.logic.model.Messages messages = (com.up366.mobile.common.logic.model.Messages) getIntent().getSerializableExtra("message");
        this.messages = messages;
        if (messages == null) {
            com.up366.common.log.Logger.error("open message detail error , message is null");
            finish();
            return;
        }
        if (!com.up366.common.StringUtils.isEmptyOrNull(messages.getMsgId()) && !this.messages.getMsgId().equals(this.messages.getPushId())) {
            com.up366.mobile.common.logic.Auth.cur().info().fetchUserMessageInfo(this.messages.getMsgId(), this.messages.getType());
        }
        this.binding = (com.up366.mobile.databinding.ActivityUserMessageDetailBinding) androidx.databinding.DataBindingUtil.setContentView(this, com.up366.mobile.R.layout.activity_user_message_detail);
        this.js = new com.up366.mobile.user.message.MessageJS(this);
        com.up366.qmui.util.QMUIStatusBarHelper.setStatusBarLightMode(this);
        this.binding.massageDetailWebview.setWebChromeClient(new android.webkit.WebChromeClient());
        this.binding.massageDetailWebview.setWebViewClient(new android.webkit.WebViewClient() { // from class: com.up366.mobile.user.message.UserMessageDetailActivity.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
                if (str.contains("http")) {
                    android.content.Intent intent = new android.content.Intent((android.content.Context) com.up366.mobile.user.message.UserMessageDetailActivity.this, (java.lang.Class<?>) com.up366.mobile.commonui.CommonWebViewActivity.class);
                    intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, str);
                    com.up366.mobile.user.message.UserMessageDetailActivity.this.startActivity(intent);
                    return true;
                }
                if (!str.contains("up366mobile://write")) {
                    return true;
                }
                com.up366.mobile.jump.JumpProxyActivity.skip(com.up366.mobile.user.message.UserMessageDetailActivity.this, str);
                return true;
            }
        });
        this.binding.massageDetailWebview.addJavascriptInterface(this.js, "jsObj");
        this.binding.massageDetailWebview.setVerticalScrollBarEnabled(false);
        android.webkit.WebSettings settings = this.binding.massageDetailWebview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        showMessageTitle();
        loadData(this.messages);
        com.up366.common.EventBusUtilsUp.register(this);
    }

    private void showMessageTitle() {
        if (this.messages != null) {
            this.binding.tvMessageTitle.setText(this.messages.getSubject());
        }
    }

    private void loadData(com.up366.mobile.common.logic.model.Messages messages) throws java.lang.Throwable {
        com.alibaba.fastjson.JSONObject object;
        if (messages.getMsgType() == 3 && (object = com.alibaba.fastjson.JSON.parseObject(messages.getExtend())) != null && object.containsKey(com.up366.mobile.commonui.CommonWebViewActivity.URL)) {
            android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.binding.massageDetailWebview.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.binding.massageDetailWebview.loadUrl(object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL));
            return;
        }
        this.js.setMessages(messages);
        java.lang.String assetFile = com.up366.common.FileUtilsUp.getAssetFile("message.html");
        java.lang.String content = messages.getContent();
        if (!com.up366.common.StringUtils.isEmptyOrNull(content) && content.contains("href")) {
            this.binding.massageDetailWebview.loadDataWithBaseURL(null, assetFile.replace("{{content}}", content).replace("{{messageTime}}", this.js.getMessageTime()).replace("{{title}}", this.js.getTitle()), "text/html", com.igexin.push.g.s.b, null);
        } else {
            this.binding.massageDetailWebview.loadDataWithBaseURL(null, assetFile.replace("{{content}}", java.util.regex.Pattern.compile("(?<!href=\")(https?://\\S+)(?!\")").matcher(content).replaceAll("<a href=\"$1\">$1</a>")).replace("{{messageTime}}", this.js.getMessageTime()).replace("{{title}}", this.js.getTitle()), "text/html", com.igexin.push.g.s.b, null);
        }
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        boolean zIsTaskRoot = isTaskRoot();
        com.up366.common.EventBusUtilsUp.unregister(this);
        com.up366.mobile.common.utils.WebViewCleanupUtils.destroy(this.binding.massageDetailWebview, "jsObj");
        this.js = null;
        super.onDestroy();
        if (zIsTaskRoot) {
            startActivity(new android.content.Intent((android.content.Context) this, (java.lang.Class<?>) com.up366.mobile.main.MainActivity.class));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.MessageInfoLoad messageInfoLoad) throws java.lang.Throwable {
        if (messageInfoLoad.resp != null && messageInfoLoad.resp.isError()) {
            if (messageInfoLoad.resp.getInfo().contains("找不到该消息")) {
                return;
            }
            com.up366.mobile.common.utils.ToastPopupUtil.show((android.app.Activity) this, "获取失败：" + messageInfoLoad.resp.getInfo());
            return;
        }
        loadData(messageInfoLoad.result);
    }
}
