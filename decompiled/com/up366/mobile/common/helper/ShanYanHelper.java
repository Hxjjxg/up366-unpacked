package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ShanYanHelper {
    private static com.up366.mobile.common.helper.ShanYanHelper instance;
    private int lastFetchCode;
    private long lastFetchTime;
    private android.graphics.Paint paint;
    private boolean hasInit = false;
    private boolean hasLoadPhoneInfo = false;
    private boolean ready = false;
    private java.util.List<com.up366.common.callback.ICallbackCode> listeners = new java.util.ArrayList();

    static /* synthetic */ void lambda$getPhoneInfo$1(int i) {
    }

    public static com.up366.mobile.common.helper.ShanYanHelper getInstance() {
        if (instance == null) {
            synchronized (com.up366.mobile.common.helper.ShanYanHelper.class) {
                if (instance == null) {
                    instance = new com.up366.mobile.common.helper.ShanYanHelper();
                }
            }
        }
        return instance;
    }

    private ShanYanHelper() {
        android.graphics.Paint paint = new android.graphics.Paint(1);
        this.paint = paint;
        paint.setColor(-13421773);
        this.paint.setTextSize(com.up366.common.DpUtilsUp.sp2px(27.0f));
        this.paint.setFakeBoldText(true);
    }

    public void init(android.content.Context context, final com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) {
        if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            iCallbackCodeInfo.onResult(-1, "no need");
        } else if (this.hasInit) {
            iCallbackCodeInfo.onResult(0, "success");
        } else {
            com.chuanglan.shanyan_sdk.OneKeyLoginManager.getInstance().getIEnable(false);
            com.chuanglan.shanyan_sdk.OneKeyLoginManager.getInstance().init(context, com.up366.mobile.BuildConfig.SHANYAN_APP_ID, new com.chuanglan.shanyan_sdk.listener.InitListener() { // from class: com.up366.mobile.common.helper.ShanYanHelper$$ExternalSyntheticLambda7
                @Override // com.chuanglan.shanyan_sdk.listener.InitListener
                public final void getInitStatus(int i, java.lang.String str) {
                    this.f$0.lambda$init$0(iCallbackCodeInfo, i, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo, int i, java.lang.String str) {
        if (i == 1022) {
            this.hasInit = true;
        }
        com.up366.common.log.Logger.info("TAG - ShanYanHelper - getInitStatus - code = [" + i + "], result = [" + str + "]");
        iCallbackCodeInfo.onResult(i, str);
    }

    public void getPhoneInfo(final com.up366.common.callback.ICallbackCode iCallbackCode) {
        if (iCallbackCode == null) {
            iCallbackCode = new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.common.helper.ShanYanHelper$$ExternalSyntheticLambda4
                @Override // com.up366.common.callback.ICallbackCode
                public final void onResult(int i) {
                    com.up366.mobile.common.helper.ShanYanHelper.lambda$getPhoneInfo$1(i);
                }
            };
        }
        init(com.up366.common.global.GB.get().getApplicationContext(), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.helper.ShanYanHelper$$ExternalSyntheticLambda5
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str) {
                this.f$0.lambda$getPhoneInfo$3(iCallbackCode, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPhoneInfo$3(com.up366.common.callback.ICallbackCode iCallbackCode, int i, java.lang.String str) {
        if (!this.hasInit) {
            iCallbackCode.onResult(-1);
            return;
        }
        if (this.listeners.size() > 0) {
            this.listeners.add(iCallbackCode);
        } else {
            if (android.os.SystemClock.uptimeMillis() - this.lastFetchTime < com.igexin.push.config.c.i) {
                iCallbackCode.onResult(this.lastFetchCode);
                return;
            }
            this.listeners.add(iCallbackCode);
            com.up366.common.log.Logger.info("TAG - ShanYanHelper - getPhoneInfoStatus - start");
            com.chuanglan.shanyan_sdk.OneKeyLoginManager.getInstance().getPhoneInfo(new com.chuanglan.shanyan_sdk.listener.GetPhoneInfoListener() { // from class: com.up366.mobile.common.helper.ShanYanHelper$$ExternalSyntheticLambda6
                @Override // com.chuanglan.shanyan_sdk.listener.GetPhoneInfoListener
                public final void getPhoneInfoStatus(int i2, java.lang.String str2) {
                    this.f$0.lambda$getPhoneInfo$2(i2, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPhoneInfo$2(int i, java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ShanYanHelper - getPhoneInfoStatus - end : code = [" + i + "], result = [" + str + "]");
        this.lastFetchTime = android.os.SystemClock.uptimeMillis();
        if (i == 1022) {
            this.lastFetchCode = 0;
            java.util.Iterator<com.up366.common.callback.ICallbackCode> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onResult(0);
            }
        } else {
            this.lastFetchCode = -2;
            java.util.Iterator<com.up366.common.callback.ICallbackCode> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                it2.next().onResult(-2);
            }
        }
        this.listeners.clear();
    }

    public void openLoginAuth(final android.content.Context context, final android.view.ViewGroup viewGroup, final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.lang.String str4, final com.up366.common.callback.ICallbackCodeInfoObj<java.lang.String> iCallbackCodeInfoObj) {
        getPhoneInfo(new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.common.helper.ShanYanHelper$$ExternalSyntheticLambda3
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                this.f$0.lambda$openLoginAuth$4(context, viewGroup, str, str2, str3, str4, iCallbackCodeInfoObj, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openLoginAuth$4(android.content.Context context, android.view.ViewGroup viewGroup, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, int i) {
        if (i == 0) {
            doOpenLoginAuth(context, viewGroup, str, str2, str3, str4, iCallbackCodeInfoObj);
        } else {
            iCallbackCodeInfoObj.onResult(-1, "", null);
        }
    }

    public void finishAuthActivity() {
        com.chuanglan.shanyan_sdk.OneKeyLoginManager.getInstance().finishAuthActivity();
    }

    private void doOpenLoginAuth(android.content.Context context, android.view.ViewGroup viewGroup, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, final com.up366.common.callback.ICallbackCodeInfoObj<java.lang.String> iCallbackCodeInfoObj) {
        final com.up366.mobile.databinding.ShanyanPrivacyTipLayoutBinding shanyanPrivacyTipLayoutBinding = (com.up366.mobile.databinding.ShanyanPrivacyTipLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.shanyan_privacy_tip_layout, (android.view.ViewGroup) null, false);
        final android.widget.Toast[] toastArr = {toast};
        android.widget.Toast toast = new android.widget.Toast(context) { // from class: com.up366.mobile.common.helper.ShanYanHelper.1
            @Override // android.widget.Toast
            public void show() {
                shanyanPrivacyTipLayoutBinding.getRoot().requestLayout();
                android.widget.Toast toast2 = toastArr[0];
                int[] iArr = new int[2];
                com.chuanglan.shanyan_sdk.OneKeyLoginManager.getInstance().getPrivacyCheckBox().getLocationInWindow(iArr);
                toast2.setGravity(51, iArr[0] - com.up366.common.DpUtilsUp.dp2px(8.0f), iArr[1] - com.up366.common.DpUtilsUp.dp2px(85.0f));
                super.show();
            }
        };
        shanyanPrivacyTipLayoutBinding.text.setText(str4);
        toast.setView(shanyanPrivacyTipLayoutBinding.getRoot());
        toast.setDuration(1);
        com.chuanglan.shanyan_sdk.OneKeyLoginManager.getInstance().setAuthThemeConfig(new com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig.Builder().setStatusBarColor(-1).setLightColor(false).setNavText("").setNavReturnImgPath(getReturnDrawable(context)).addCustomView(getTitleView(context, str), false, false, null).addCustomView(getNumTipView(context), false, false, null).addCustomView(getChangeNumView(context, str3), false, false, new com.chuanglan.shanyan_sdk.listener.ShanYanCustomInterface() { // from class: com.up366.mobile.common.helper.ShanYanHelper$$ExternalSyntheticLambda0
            @Override // com.chuanglan.shanyan_sdk.listener.ShanYanCustomInterface
            public final void onClick(android.content.Context context2, android.view.View view) {
                com.up366.mobile.common.helper.ShanYanHelper.lambda$doOpenLoginAuth$6(iCallbackCodeInfoObj, context2, view);
            }
        }).setNumberSize(26).setNumberBold(true).setNumFieldOffsetY(190).setSloganOffsetY(230).setSloganTextColor(-6710887).setSloganTextSize(14).setLogBtnText(str2).setLogBtnTextSize(18).setLogBtnImgPath(com.up366.mobile.common.utils.ViewUtil.getDrawable(context, com.up366.mobile.R.drawable.b8_btn_blue_background)).setLogBtnTextBold(true).setLogBtnOffsetY(290).setAppPrivacyOne("使用许可协议", com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.LICENSE_URL)).setAppPrivacyTwo("隐私政策", com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.PRIVACY_URL)).setAppPrivacyThree("儿童隐私保护政策", com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.BABY_PRIVACY_URL)).setPrivacyTextSize(12).setAppPrivacyColor(context.getResources().getColor(com.up366.mobile.R.color.c5), context.getResources().getColor(com.up366.mobile.R.color.c1)).setPrivacyNameUnderline(true).setPrivacyText("同意", "、", "、", "和", "并授权天学网获得本机号码").setPrivacyOffsetY(352).setCheckBoxHidden(false).setPrivacyState(false).setUncheckedImgPath(com.up366.mobile.common.utils.ViewUtil.getDrawable(context, com.up366.mobile.R.drawable.icon_license_uncheck)).setCheckedImgPath(com.up366.mobile.common.utils.ViewUtil.getDrawable(context, com.up366.mobile.R.drawable.icon_license_check)).setCheckBoxMargin(0, 0, 6, 20).setPrivacyCustomToastText("请勾选协议").setPrivacyCustomToast(toast).setSloganHidden(true).setLoadingView(viewGroup).build(), null);
        com.chuanglan.shanyan_sdk.OneKeyLoginManager.getInstance().openLoginAuth(false, new com.chuanglan.shanyan_sdk.listener.OpenLoginAuthListener() { // from class: com.up366.mobile.common.helper.ShanYanHelper$$ExternalSyntheticLambda1
            @Override // com.chuanglan.shanyan_sdk.listener.OpenLoginAuthListener
            public final void getOpenLoginAuthStatus(int i, java.lang.String str5) {
                com.up366.mobile.common.helper.ShanYanHelper.lambda$doOpenLoginAuth$7(iCallbackCodeInfoObj, i, str5);
            }
        }, new com.chuanglan.shanyan_sdk.listener.OneKeyLoginListener() { // from class: com.up366.mobile.common.helper.ShanYanHelper$$ExternalSyntheticLambda2
            @Override // com.chuanglan.shanyan_sdk.listener.OneKeyLoginListener
            public final void getOneKeyLoginStatus(int i, java.lang.String str5) {
                com.up366.mobile.common.helper.ShanYanHelper.lambda$doOpenLoginAuth$8(iCallbackCodeInfoObj, i, str5);
            }
        });
    }

    static /* synthetic */ void lambda$doOpenLoginAuth$6(com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, android.content.Context context, android.view.View view) {
        com.up366.common.log.Logger.info("TAG - ShanYanHelper - onClick - 换个手机号");
        iCallbackCodeInfoObj.onResult(2, "", null);
        com.up366.common.task.TaskUtils.postMainTaskDelay(1000L, new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.ShanYanHelper$$ExternalSyntheticLambda8
            @Override // com.up366.common.task.Task
            public final void run() {
                com.chuanglan.shanyan_sdk.OneKeyLoginManager.getInstance().finishAuthActivity();
            }
        });
    }

    static /* synthetic */ void lambda$doOpenLoginAuth$7(com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, int i, java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ShanYanHelper - getOpenLoginAuthStatus - code = [" + i + "], result = [" + str + "]");
        if (i == 1000) {
            iCallbackCodeInfoObj.onResult(0, "", null);
        } else {
            iCallbackCodeInfoObj.onResult(-1, "", null);
        }
    }

    static /* synthetic */ void lambda$doOpenLoginAuth$8(com.up366.common.callback.ICallbackCodeInfoObj iCallbackCodeInfoObj, int i, java.lang.String str) {
        com.up366.common.log.Logger.info("TAG - ShanYanHelper - getOneKeyLoginStatus - code = [" + i + "], result = [" + str + "]");
        if (i == 1000) {
            iCallbackCodeInfoObj.onResult(1, "", com.alibaba.fastjson.JSON.parseObject(str).getString(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN));
        } else if (i == 1011) {
            iCallbackCodeInfoObj.onResult(3, "", null);
        } else {
            iCallbackCodeInfoObj.onResult(-2, "", null);
        }
    }

    private android.graphics.drawable.Drawable getReturnDrawable(android.content.Context context) {
        return new android.graphics.drawable.Drawable(context) { // from class: com.up366.mobile.common.helper.ShanYanHelper.2
            final android.graphics.drawable.Drawable drawable;
            final /* synthetic */ android.content.Context val$context;

            @Override // android.graphics.drawable.Drawable
            public int getOpacity() {
                return -3;
            }

            @Override // android.graphics.drawable.Drawable
            public void setAlpha(int i) {
            }

            @Override // android.graphics.drawable.Drawable
            public void setColorFilter(android.graphics.ColorFilter colorFilter) {
            }

            {
                this.val$context = context;
                this.drawable = com.up366.mobile.common.utils.ViewUtil.getDrawable(context, com.up366.mobile.R.drawable.icon_close);
            }

            @Override // android.graphics.drawable.Drawable
            public void draw(android.graphics.Canvas canvas) {
                this.drawable.draw(canvas);
            }
        };
    }

    private android.view.View getTitleView(android.content.Context context, java.lang.String str) {
        android.widget.TextView textView = new android.widget.TextView(context);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(com.up366.common.DpUtilsUp.dp2px(37.5f), 0, 0, 0);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        textView.setLayoutParams(layoutParams);
        textView.setText(str);
        textView.setTextSize(27.0f);
        textView.setTextColor(-13421773);
        textView.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
        return textView;
    }

    private android.view.View getNumTipView(android.content.Context context) {
        android.widget.TextView textView = new android.widget.TextView(context);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, com.up366.common.DpUtilsUp.dp2px(150.0f), 0, 0);
        layoutParams.addRule(14);
        layoutParams.addRule(10);
        textView.setLayoutParams(layoutParams);
        textView.setText("本机号码");
        textView.setTextSize(16.0f);
        textView.setTextColor(-13421773);
        return textView;
    }

    private android.view.View getChangeNumView(android.content.Context context, java.lang.String str) {
        android.widget.TextView textView = new android.widget.TextView(context);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        int iDp2px = com.up366.common.DpUtilsUp.dp2px(30.0f);
        textView.setPadding(iDp2px, iDp2px, iDp2px, iDp2px);
        textView.setLayoutParams(layoutParams);
        textView.setText(str);
        textView.setTextSize(14.0f);
        textView.setTextColor(-10715905);
        return textView;
    }
}
