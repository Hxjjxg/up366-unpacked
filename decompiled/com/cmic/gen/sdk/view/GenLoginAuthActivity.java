package com.cmic.gen.sdk.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class GenLoginAuthActivity extends android.app.Activity implements android.view.View.OnClickListener {
    protected static final java.lang.String J = "GenLoginAuthActivity";
    private java.lang.String A;
    private com.cmic.gen.sdk.view.GenAuthThemeConfig C;
    private int D;
    private int E;
    private boolean F;
    private android.widget.ImageView G;
    android.widget.RelativeLayout H;
    private android.app.Dialog I;
    private android.os.Handler a;
    private android.content.Context b;
    private android.widget.RelativeLayout c;
    private com.cmic.gen.sdk.g1 d;
    private com.cmic.gen.sdk.g1 e;
    private com.cmic.gen.sdk.g1 f;
    private com.cmic.gen.sdk.g1 g;
    private com.cmic.gen.sdk.g1 h;
    private java.util.ArrayList<com.cmic.gen.sdk.g1> i;
    private java.util.ArrayList<java.lang.String> j;
    private java.lang.String[] k;
    private java.lang.String[] l;
    private com.cmic.gen.sdk.i m;
    private com.cmic.gen.sdk.auth.a n;
    private android.widget.CheckBox p;
    private android.widget.RelativeLayout q;
    private android.widget.RelativeLayout r;
    private com.cmic.gen.sdk.auth.GenTokenListener v;
    private android.widget.RelativeLayout x;
    private java.lang.String y;
    private java.lang.String o = "";
    private long s = 0;
    private int t = 0;
    private com.cmic.gen.sdk.view.GenLoginAuthActivity.n u = null;
    private boolean w = true;
    private java.lang.String z = "";
    private java.lang.String B = "";

    class a implements android.view.View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.cmic.gen.sdk.view.GenLoginAuthActivity.this.p.setChecked(!com.cmic.gen.sdk.view.GenLoginAuthActivity.this.p.isChecked());
        }
    }

    class b extends android.text.method.LinkMovementMethod {
        b() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(android.widget.TextView textView, android.text.Spannable spannable, android.view.MotionEvent motionEvent) {
            boolean zOnTouchEvent = super.onTouchEvent(textView, spannable, motionEvent);
            if (!zOnTouchEvent && motionEvent.getAction() == 1) {
                android.view.ViewParent parent = textView.getParent();
                if (parent instanceof android.view.ViewGroup) {
                    return ((android.view.ViewGroup) parent).performClick();
                }
            }
            return zOnTouchEvent;
        }
    }

    class c implements com.cmic.gen.sdk.view.AuthLoginCallBack {
        c() {
        }

        @Override // com.cmic.gen.sdk.view.AuthLoginCallBack
        public void onAuthLoginCallBack(boolean z) {
            if (z) {
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.p.setChecked(true);
                com.cmic.gen.sdk.view.GenLoginAuthActivity.a(com.cmic.gen.sdk.view.GenLoginAuthActivity.this, 1);
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.a();
            }
        }
    }

    class d implements android.content.DialogInterface.OnKeyListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
            return i == 4;
        }
    }

    class e implements java.lang.Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.cmic.gen.sdk.view.GenLoginAuthActivity.this.setVisible(true);
            int[] iArr = new int[2];
            com.cmic.gen.sdk.view.GenLoginAuthActivity.this.r.getLocationOnScreen(iArr);
            int i = iArr[1];
            java.lang.String str = com.cmic.gen.sdk.view.GenLoginAuthActivity.J;
            com.cmic.gen.sdk.h0.a(str, "mPhoneLayout" + iArr[1]);
            com.cmic.gen.sdk.view.GenLoginAuthActivity.this.c.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            com.cmic.gen.sdk.h0.a(str, "mPhoneLayout" + iArr[1]);
            com.cmic.gen.sdk.view.GenLoginAuthActivity.this.q.getLocationOnScreen(iArr);
            int i3 = iArr[1];
            com.cmic.gen.sdk.h0.a(str, "mPhoneLayout" + iArr[1]);
            if (i <= i2 && i <= i3) {
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.r.setFocusableInTouchMode(true);
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.r.requestFocus();
            } else if (i2 < i3) {
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.c.setFocusableInTouchMode(true);
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.c.requestFocus();
            } else {
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.p.setFocusableInTouchMode(true);
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.p.requestFocus();
            }
        }
    }

    class f implements android.content.DialogInterface.OnKeyListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.d.a();
            }
            return true;
        }
    }

    class g implements android.content.DialogInterface.OnKeyListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.e.a();
            }
            return true;
        }
    }

    class h implements android.content.DialogInterface.OnKeyListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.f.a();
            }
            return true;
        }
    }

    class i implements android.content.DialogInterface.OnKeyListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.g.a();
            }
            return true;
        }
    }

    class j implements android.content.DialogInterface.OnKeyListener {
        j() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(android.content.DialogInterface dialogInterface, int i, android.view.KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.h.a();
            }
            return true;
        }
    }

    class k implements com.cmic.gen.sdk.view.a.InterfaceC0008a {
        k() {
        }

        @Override // com.cmic.gen.sdk.view.a.InterfaceC0008a
        public void a() {
            com.cmic.gen.sdk.view.GenLoginAuthActivity.this.a.removeCallbacksAndMessages(null);
            if (com.cmic.gen.sdk.view.GenLoginAuthActivity.this.d != null && com.cmic.gen.sdk.view.GenLoginAuthActivity.this.d.isShowing()) {
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.d.dismiss();
            }
            if (com.cmic.gen.sdk.view.GenLoginAuthActivity.this.e != null && com.cmic.gen.sdk.view.GenLoginAuthActivity.this.e.isShowing()) {
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.e.dismiss();
            }
            com.cmic.gen.sdk.view.GenLoginAuthActivity.this.a(true);
        }
    }

    class l implements android.widget.CompoundButton.OnCheckedChangeListener {
        l() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
            if (com.cmic.gen.sdk.view.GenLoginAuthActivity.this.C.getGenCheckedChangeListener() != null) {
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.C.getGenCheckedChangeListener().onCheckedChanged(z);
            }
            if (z) {
                if (com.cmic.gen.sdk.view.GenLoginAuthActivity.this.G != null) {
                    com.cmic.gen.sdk.view.GenLoginAuthActivity.this.G.setVisibility(0);
                }
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.c.setEnabled(true);
                try {
                    android.widget.CheckBox checkBox = com.cmic.gen.sdk.view.GenLoginAuthActivity.this.p;
                    com.cmic.gen.sdk.view.GenLoginAuthActivity genLoginAuthActivity = com.cmic.gen.sdk.view.GenLoginAuthActivity.this;
                    checkBox.setBackgroundResource(com.cmic.gen.sdk.z0.b(genLoginAuthActivity, genLoginAuthActivity.C.getCheckedImgPath()));
                } catch (java.lang.Exception unused) {
                    com.cmic.gen.sdk.view.GenLoginAuthActivity.this.p.setBackgroundResource(com.cmic.gen.sdk.z0.b(com.cmic.gen.sdk.view.GenLoginAuthActivity.this, "umcsdk_check_image"));
                }
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.p.setContentDescription("复选框 已勾选 " + com.cmic.gen.sdk.view.GenLoginAuthActivity.this.A);
                return;
            }
            if (com.cmic.gen.sdk.view.GenLoginAuthActivity.this.G != null) {
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.G.setVisibility(4);
            }
            com.cmic.gen.sdk.view.GenLoginAuthActivity.this.c.setEnabled(com.cmic.gen.sdk.view.GenLoginAuthActivity.this.k());
            try {
                android.widget.CheckBox checkBox2 = com.cmic.gen.sdk.view.GenLoginAuthActivity.this.p;
                com.cmic.gen.sdk.view.GenLoginAuthActivity genLoginAuthActivity2 = com.cmic.gen.sdk.view.GenLoginAuthActivity.this;
                checkBox2.setBackgroundResource(com.cmic.gen.sdk.z0.b(genLoginAuthActivity2, genLoginAuthActivity2.C.getUncheckedImgPath()));
            } catch (java.lang.Exception unused2) {
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.p.setBackgroundResource(com.cmic.gen.sdk.z0.b(com.cmic.gen.sdk.view.GenLoginAuthActivity.this, "umcsdk_uncheck_image"));
            }
            com.cmic.gen.sdk.view.GenLoginAuthActivity.this.p.setContentDescription("复选框 请双击勾选 " + com.cmic.gen.sdk.view.GenLoginAuthActivity.this.A);
        }
    }

    class m extends com.cmic.gen.sdk.k1.a {
        final /* synthetic */ java.lang.String b;

        class a implements java.lang.Runnable {
            final /* synthetic */ android.graphics.Bitmap a;

            a(android.graphics.Bitmap bitmap) {
                this.a = bitmap;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x00fb  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x012d  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x01b1  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    Method dump skipped, instruction units count: 470
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cmic.gen.sdk.view.GenLoginAuthActivity.m.a.run():void");
            }
        }

        m(java.lang.String str) {
            this.b = str;
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            android.graphics.Bitmap bitmapDecodeStream;
            try {
                java.io.File externalFilesDir = com.cmic.gen.sdk.view.GenLoginAuthActivity.this.b.getExternalFilesDir("LogoFile");
                if (!externalFilesDir.exists()) {
                    java.lang.String str = com.cmic.gen.sdk.view.GenLoginAuthActivity.J;
                    com.cmic.gen.sdk.h0.c(str, "logo文件夹不存在");
                    if (!externalFilesDir.mkdirs()) {
                        com.cmic.gen.sdk.h0.c(str, "logo文件夹创建失败");
                    }
                }
                java.lang.String absolutePath = new java.io.File(externalFilesDir + "/" + com.cmic.gen.sdk.j0.a(this.b)).getAbsolutePath();
                java.lang.String str2 = com.cmic.gen.sdk.view.GenLoginAuthActivity.J;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("logo文件路径");
                sb.append(absolutePath);
                com.cmic.gen.sdk.h0.c(str2, sb.toString());
                java.io.File file = new java.io.File(absolutePath);
                if (file.isFile() && file.exists()) {
                    com.cmic.gen.sdk.h0.c(str2, "读取本地文件");
                    bitmapDecodeStream = android.graphics.BitmapFactory.decodeFile(absolutePath);
                } else {
                    com.cmic.gen.sdk.h0.c(str2, "读取网络文件");
                    bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(new java.net.URL(this.b).openStream());
                    try {
                        bitmapDecodeStream.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, new java.io.FileOutputStream(absolutePath));
                        com.cmic.gen.sdk.h0.c(str2, "保存文件到本地");
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.H.post(new com.cmic.gen.sdk.view.GenLoginAuthActivity.m.a(bitmapDecodeStream));
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private static class n extends android.os.Handler {
        java.lang.ref.WeakReference<com.cmic.gen.sdk.view.GenLoginAuthActivity> a;

        n(com.cmic.gen.sdk.view.GenLoginAuthActivity genLoginAuthActivity) {
            this.a = new java.lang.ref.WeakReference<>(genLoginAuthActivity);
        }

        private void a(android.os.Message message) {
            com.cmic.gen.sdk.view.GenLoginAuthActivity genLoginAuthActivity = this.a.get();
            if (genLoginAuthActivity == null || message.what != 1) {
                return;
            }
            genLoginAuthActivity.l();
            genLoginAuthActivity.o();
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            try {
                a(message);
            } catch (java.lang.Exception e) {
                com.cmic.gen.sdk.f0.D.add(e);
                e.printStackTrace();
            }
        }
    }

    private static class o extends com.cmic.gen.sdk.k1.a {
        java.lang.ref.WeakReference<com.cmic.gen.sdk.view.GenLoginAuthActivity> b;
        java.lang.ref.WeakReference<com.cmic.gen.sdk.view.GenLoginAuthActivity.p> c;

        class a implements com.cmic.gen.sdk.d {
            final /* synthetic */ com.cmic.gen.sdk.view.GenLoginAuthActivity a;

            a(com.cmic.gen.sdk.view.GenLoginAuthActivity genLoginAuthActivity) {
                this.a = genLoginAuthActivity;
            }

            @Override // com.cmic.gen.sdk.d
            public void a(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.i iVar, org.json.JSONObject jSONObject) {
                if (com.cmic.gen.sdk.view.GenLoginAuthActivity.o.this.b()) {
                    long jA = iVar.a("loginTime", 0L);
                    java.lang.String strC = iVar.c("phonescrip");
                    if (jA != 0) {
                        iVar.b("loginTime", java.lang.System.currentTimeMillis() - jA);
                    }
                    if (!"103000".equals(str) || android.text.TextUtils.isEmpty(strC)) {
                        this.a.w = false;
                        com.cmic.gen.sdk.o.a("authClickFailed");
                    } else {
                        com.cmic.gen.sdk.o.a("authClickSuccess");
                        this.a.w = true;
                    }
                    this.a.a(str, str2, iVar, jSONObject);
                    try {
                        java.lang.Thread.sleep(1000L);
                    } catch (java.lang.InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.a.u.sendEmptyMessage(1);
                }
            }
        }

        protected o(com.cmic.gen.sdk.view.GenLoginAuthActivity genLoginAuthActivity, com.cmic.gen.sdk.view.GenLoginAuthActivity.p pVar) {
            this.b = new java.lang.ref.WeakReference<>(genLoginAuthActivity);
            this.c = new java.lang.ref.WeakReference<>(pVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            com.cmic.gen.sdk.view.GenLoginAuthActivity.p pVar = this.c.get();
            if (this.b.get() == null || pVar == null) {
                return false;
            }
            return pVar.a(false);
        }

        @Override // com.cmic.gen.sdk.k1.a
        protected void a() {
            com.cmic.gen.sdk.view.GenLoginAuthActivity genLoginAuthActivity = this.b.get();
            genLoginAuthActivity.m.b("logintype", 1);
            com.cmic.gen.sdk.u0.a(true, false);
            genLoginAuthActivity.n.b(genLoginAuthActivity.m, new com.cmic.gen.sdk.view.GenLoginAuthActivity.o.a(genLoginAuthActivity));
        }
    }

    private class p implements java.lang.Runnable {
        private com.cmic.gen.sdk.i a;
        private boolean b;

        p(com.cmic.gen.sdk.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a(true)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("resultCode", "102507");
                    jSONObject.put("resultString", "请求超时");
                } catch (org.json.JSONException e) {
                    e.printStackTrace();
                }
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.w = false;
                com.cmic.gen.sdk.o.a("authClickFailed");
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.u.sendEmptyMessage(1);
                long jA = this.a.a("loginTime", 0L);
                if (jA != 0) {
                    this.a.b("loginTime", java.lang.System.currentTimeMillis() - jA);
                }
                com.cmic.gen.sdk.view.GenLoginAuthActivity.this.a("102507", "请求超时", this.a, jSONObject);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(boolean z) {
            boolean z2;
            z2 = this.b;
            this.b = z;
            return !z2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        try {
            int id = view.getId();
            if (id != 17476) {
                if (id == 26214) {
                    a(false);
                    return;
                } else {
                    if (id != 34952) {
                        return;
                    }
                    if (this.p.isChecked()) {
                        this.p.setChecked(false);
                        return;
                    } else {
                        this.p.setChecked(true);
                        return;
                    }
                }
            }
            if (!this.p.isChecked()) {
                if (this.C.getGenAuthLoginListener() != null) {
                    com.cmic.gen.sdk.o.a("PrivacyNotSelectedCustom");
                    this.C.getGenAuthLoginListener().onAuthLoginListener(this.b, new com.cmic.gen.sdk.view.GenLoginAuthActivity.c());
                    return;
                }
                if (this.C.getPrivacyAnimation() != null) {
                    com.cmic.gen.sdk.o.a("PrivacyNotSelectedShake");
                    android.content.Context context = this.b;
                    this.q.startAnimation(android.view.animation.AnimationUtils.loadAnimation(context, com.cmic.gen.sdk.z0.a(context, this.C.getPrivacyAnimation())));
                    return;
                }
                if (this.C.getGenCheckBoxListener() != null) {
                    com.cmic.gen.sdk.o.a("PrivacyNotSelectedPopup");
                    this.C.getGenCheckBoxListener().onLoginClick(this.b, null);
                    return;
                } else if (!android.text.TextUtils.isEmpty(this.C.getCheckTipText())) {
                    com.cmic.gen.sdk.o.a("PrivacyNotSelectedToast");
                    android.widget.Toast.makeText(this.b, this.C.getCheckTipText(), 1).show();
                    return;
                }
            }
            this.t++;
            a();
        } catch (java.lang.Exception e2) {
            com.cmic.gen.sdk.f0.D.add(e2);
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            try {
                finish();
            } catch (java.lang.Exception e2) {
                if (this.m == null) {
                    this.m = new com.cmic.gen.sdk.i(0);
                }
                this.m.a().A.add(e2);
                com.cmic.gen.sdk.h0.b(J, e2.toString());
                e2.printStackTrace();
                a("200025", "发生未知错误", this.m, null);
                return;
            }
        }
        this.b = this;
        com.cmic.gen.sdk.view.GenAuthThemeConfig authThemeConfig = com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance((android.content.Context) this).getAuthThemeConfig();
        this.C = authThemeConfig;
        if (authThemeConfig != null) {
            if (authThemeConfig.getThemeId() != -1) {
                setTheme(this.C.getThemeId());
            }
            if (this.C.getAuthPageActIn() != null && this.C.getActivityOut() != null) {
                overridePendingTransition(com.cmic.gen.sdk.z0.a(this, this.C.getAuthPageActIn()), com.cmic.gen.sdk.z0.a(this, this.C.getActivityOut()));
            }
        }
        com.cmic.gen.sdk.o.a("authPageIn");
        this.s = java.lang.System.currentTimeMillis();
        this.n = com.cmic.gen.sdk.auth.a.a(this);
        f();
        i();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            this.a.removeCallbacksAndMessages(null);
            com.cmic.gen.sdk.o.a("timeOnAuthPage", (java.lang.System.currentTimeMillis() - this.s) + "");
            if (this.p.isChecked()) {
                com.cmic.gen.sdk.o.a("authPrivacyState", "1");
            } else {
                com.cmic.gen.sdk.o.a("authPrivacyState", "0");
            }
            com.cmic.gen.sdk.o.a(this.b.getApplicationContext(), this.m);
            com.cmic.gen.sdk.o.a();
            this.I = null;
            com.cmic.gen.sdk.view.a.a().c();
            this.u.removeCallbacksAndMessages(null);
        } catch (java.lang.Exception e2) {
            com.cmic.gen.sdk.h0.b(J, "GenLoginAuthActivity clear failed");
            com.cmic.gen.sdk.f0.D.add(e2);
            e2.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, android.view.KeyEvent keyEvent) {
        if (i2 != 4 || keyEvent.isCanceled() || keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (this.C.getGenBackPressedListener() != null) {
            this.C.getGenBackPressedListener().onBackPressed();
        }
        if (this.C.getWindowWidth() != 0 && !this.C.isBackButton()) {
            return true;
        }
        a(false);
        return true;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            android.widget.RelativeLayout relativeLayout = this.c;
            if (relativeLayout != null) {
                relativeLayout.postDelayed(new com.cmic.gen.sdk.view.GenLoginAuthActivity.e(), 500L);
            }
            com.cmic.gen.sdk.i iVar = this.m;
            if (iVar != null) {
                iVar.b("loginMethod", "loginAuth");
            }
            com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance((android.content.Context) this).loginPageInCallBack("200087");
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            this.m.a().A.add(e2);
            a("200025", "发生未知错误", this.m, null);
        }
    }

    private java.lang.String c() {
        this.A = this.C.getPrivacy();
        if (this.C.isPrivacyBookSymbol()) {
            this.y = java.lang.String.format("《%s》", this.y);
        }
        if (this.A.contains(com.cmic.gen.sdk.view.GenAuthThemeConfig.PLACEHOLDER)) {
            this.A = this.A.replace(com.cmic.gen.sdk.view.GenAuthThemeConfig.PLACEHOLDER, this.y);
        }
        return this.A;
    }

    private android.widget.TextView d() {
        android.widget.TextView textView = new android.widget.TextView(this);
        if (this.C.getAppLanguageType() == 1) {
            textView.setText("本頁面由中國移動香港有限公司開發提供");
        } else if (this.C.getAppLanguageType() == 2) {
            textView.setText("Powered by China Mobile Hong Kong Ltd.");
        } else {
            textView.setText("本页面由中国移动香港有限公司开发提供");
        }
        if (this.C.getProvideTextBold()) {
            textView.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
        }
        try {
            textView.setTextColor(this.C.getProvideTextColor());
        } catch (java.lang.Exception unused) {
            textView.setTextColor(-13421773);
        }
        try {
            textView.setTextSize(2, this.C.getProvideTextSize());
        } catch (java.lang.Exception unused2) {
            textView.setTextSize(2, 18.0f);
        }
        return textView;
    }

    private android.widget.RelativeLayout e() {
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(this);
        this.q = relativeLayout;
        relativeLayout.setHorizontalGravity(1);
        this.q.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -2));
        int checkedImgWidth = this.C.getCheckedImgWidth();
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.cmic.gen.sdk.r1.a(this.b, java.lang.Math.max(checkedImgWidth, 30)), com.cmic.gen.sdk.r1.a(this.b, java.lang.Math.max(this.C.getCheckedImgHeight(), 30)));
        if (this.C.getCheckBoxLocation() == 1) {
            layoutParams.addRule(15, -1);
        }
        android.widget.RelativeLayout relativeLayout2 = new android.widget.RelativeLayout(this);
        this.x = relativeLayout2;
        relativeLayout2.setId(34952);
        this.x.setLayoutParams(layoutParams);
        android.widget.CheckBox checkBox = new android.widget.CheckBox(this);
        this.p = checkBox;
        checkBox.setChecked(false);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(com.cmic.gen.sdk.r1.a(this.b, this.C.getCheckedImgWidth()), com.cmic.gen.sdk.r1.a(this.b, this.C.getCheckedImgHeight()));
        layoutParams2.setMargins(com.cmic.gen.sdk.r1.a(this.b, checkedImgWidth > 30 ? 0.0f : 30 - checkedImgWidth), 0, 0, 0);
        layoutParams2.addRule(11, -1);
        if (this.C.getCheckBoxLocation() == 1) {
            layoutParams2.addRule(15, -1);
        }
        this.p.setLayoutParams(layoutParams2);
        this.x.addView(this.p);
        this.q.addView(this.x);
        android.widget.TextView textView = new android.widget.TextView(this);
        textView.setTextSize(2, this.C.getPrivacyTextSize());
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(com.cmic.gen.sdk.r1.a(this.b, 5.0f), 0, 0, com.cmic.gen.sdk.r1.a(this.b, 5.0f));
        layoutParams3.addRule(1, 34952);
        textView.setLayoutParams(layoutParams3);
        this.q.addView(textView);
        textView.setTextColor(this.C.getClauseBaseColor());
        android.text.SpannableString spannableStringA = com.cmic.gen.sdk.r1.a(this, this.A, this.y, this.z, this.d, this.i, this.j);
        android.graphics.Typeface typefaceDefaultFromStyle = android.graphics.Typeface.defaultFromStyle(0);
        for (int i2 = 0; i2 < this.A.length(); i2++) {
            if (this.A.charAt(i2) == 12289) {
                spannableStringA.setSpan(new android.text.style.StyleSpan(typefaceDefaultFromStyle.getStyle()), i2, i2 + 1, 33);
            }
        }
        textView.setText(spannableStringA);
        textView.setLineSpacing(8.0f, 1.0f);
        textView.setIncludeFontPadding(false);
        if (this.C.isPrivacyTextBold()) {
            textView.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
        }
        if (this.C.isPrivacyTextGravityCenter()) {
            textView.setGravity(17);
        }
        textView.setHighlightColor(getResources().getColor(android.R.color.transparent));
        if (!this.C.isCheckBoxAccurateClick()) {
            this.q.setOnClickListener(new com.cmic.gen.sdk.view.GenLoginAuthActivity.a());
        }
        textView.setMovementMethod(new com.cmic.gen.sdk.view.GenLoginAuthActivity.b());
        this.p.setButtonDrawable(new android.graphics.drawable.ColorDrawable());
        try {
            this.p.setBackgroundResource(com.cmic.gen.sdk.z0.b(this, this.C.getUncheckedImgPath()));
        } catch (java.lang.Exception unused) {
            this.p.setBackgroundResource(com.cmic.gen.sdk.z0.b(this, "umcsdk_uncheck_image"));
        }
        return this.q;
    }

    private void f() {
        com.cmic.gen.sdk.i iVarA = com.cmic.gen.sdk.r0.a(getIntent().getStringExtra("traceId"));
        this.m = iVarA;
        if (iVarA == null) {
            this.m = new com.cmic.gen.sdk.i(0);
        }
        this.v = com.cmic.gen.sdk.r0.b(this.m.a("traceId", ""));
        getWindowManager().getDefaultDisplay().getMetrics(new android.util.DisplayMetrics());
        this.a = new android.os.Handler(getMainLooper());
        this.u = new com.cmic.gen.sdk.view.GenLoginAuthActivity.n(this);
        this.o = this.m.c("securityphone");
        java.lang.String str = J;
        com.cmic.gen.sdk.h0.a(str, "mSecurityPhone value is " + this.o);
        java.lang.String strA = this.m.a("operatortype", "");
        com.cmic.gen.sdk.h0.a(str, "operator value is " + strA);
        java.lang.String strA2 = com.cmic.gen.sdk.h1.a("operator1", "");
        java.lang.String strA3 = com.cmic.gen.sdk.h1.a("operator2", "");
        java.lang.String strA4 = com.cmic.gen.sdk.h1.a("operator3", "");
        java.lang.String strA5 = com.cmic.gen.sdk.h1.a("operator4", "");
        if (android.text.TextUtils.isEmpty(strA2) || android.text.TextUtils.isEmpty(strA3) || android.text.TextUtils.isEmpty(strA4) || android.text.TextUtils.isEmpty(strA5)) {
            a(strA);
        } else {
            com.cmic.gen.sdk.h0.a(str, "读取接口协议配置缓存 ");
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(com.cmic.gen.sdk.h1.a("operator" + strA, ""));
                java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
                this.k = new java.lang.String[3];
                java.lang.String[] strArr = new java.lang.String[3];
                for (int i2 = 0; itKeys.hasNext() && i2 < 3; i2++) {
                    java.lang.String next = itKeys.next();
                    java.lang.String str2 = J;
                    com.cmic.gen.sdk.h0.a(str2, "读取接口协议 " + jSONObject.optString(next).split("\\^")[0]);
                    com.cmic.gen.sdk.h0.a(str2, "读取接口协议url " + jSONObject.optString(next).split("\\^")[1]);
                    this.k[i2] = jSONObject.optString(next).split("\\^")[0];
                    strArr[i2] = jSONObject.optString(next).split("\\^")[1];
                }
                this.y = this.k[this.C.getAppLanguageType()];
                this.z = strArr[this.C.getAppLanguageType()];
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                a(strA);
            }
        }
        int privacyDialogThemeId = this.C.getPrivacyDialogThemeId();
        if (privacyDialogThemeId == -1) {
            privacyDialogThemeId = 16973840;
        }
        com.cmic.gen.sdk.g1 g1Var = new com.cmic.gen.sdk.g1(this.b, privacyDialogThemeId, this.y, this.z);
        this.d = g1Var;
        g1Var.setOnKeyListener(new com.cmic.gen.sdk.view.GenLoginAuthActivity.f());
        this.i = new java.util.ArrayList<>();
        this.j = new java.util.ArrayList<>();
        if (!android.text.TextUtils.isEmpty(this.C.getClauseUrl())) {
            com.cmic.gen.sdk.g1 g1Var2 = new com.cmic.gen.sdk.g1(this.b, privacyDialogThemeId, this.C.getClauseName(), this.C.getClauseUrl());
            this.e = g1Var2;
            g1Var2.setOnKeyListener(new com.cmic.gen.sdk.view.GenLoginAuthActivity.g());
            this.i.add(this.e);
            this.j.add(this.C.getClauseName());
        }
        if (!android.text.TextUtils.isEmpty(this.C.getClauseUrl2())) {
            com.cmic.gen.sdk.g1 g1Var3 = new com.cmic.gen.sdk.g1(this.b, privacyDialogThemeId, this.C.getClauseName2(), this.C.getClauseUrl2());
            this.f = g1Var3;
            g1Var3.setOnKeyListener(new com.cmic.gen.sdk.view.GenLoginAuthActivity.h());
            this.i.add(this.f);
            this.j.add(this.C.getClauseName2());
        }
        if (!android.text.TextUtils.isEmpty(this.C.getClauseUrl3())) {
            com.cmic.gen.sdk.g1 g1Var4 = new com.cmic.gen.sdk.g1(this.b, privacyDialogThemeId, this.C.getClauseName3(), this.C.getClauseUrl3());
            this.g = g1Var4;
            g1Var4.setOnKeyListener(new com.cmic.gen.sdk.view.GenLoginAuthActivity.i());
            this.i.add(this.g);
            this.j.add(this.C.getClauseName3());
        }
        if (!android.text.TextUtils.isEmpty(this.C.getClauseUrl4())) {
            com.cmic.gen.sdk.g1 g1Var5 = new com.cmic.gen.sdk.g1(this.b, android.R.style.Theme.Translucent.NoTitleBar, this.C.getClauseName4(), this.C.getClauseUrl4());
            this.h = g1Var5;
            g1Var5.setOnKeyListener(new com.cmic.gen.sdk.view.GenLoginAuthActivity.j());
            this.i.add(this.h);
            this.j.add(this.C.getClauseName4());
        }
        c();
        if (this.C.isPrivacyBookSymbol()) {
            for (int i3 = 0; i3 < this.j.size(); i3++) {
                java.lang.String str3 = java.lang.String.format("《%s》", this.j.get(i3));
                this.A = this.A.replaceFirst(this.j.get(i3), str3);
                this.j.set(i3, str3);
            }
        }
        com.cmic.gen.sdk.view.a.a().a(new com.cmic.gen.sdk.view.GenLoginAuthActivity.k());
    }

    private android.widget.RelativeLayout g() {
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(this);
        this.c = relativeLayout;
        relativeLayout.setId(17476);
        this.c.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(com.cmic.gen.sdk.r1.a(this.b, this.C.getLogBtnWidth()), com.cmic.gen.sdk.r1.a(this.b, this.C.getLogBtnHeight())));
        android.widget.TextView textView = new android.widget.TextView(this);
        textView.setTextSize(2, this.C.getLogBtnTextSize());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setLayoutParams(layoutParams);
        if (this.C.isLogBtnTextBold()) {
            textView.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
        }
        this.c.addView(textView);
        textView.setText(this.C.getLogBtnText());
        try {
            textView.setTextColor(this.C.getLogBtnTextColor());
        } catch (java.lang.Exception unused) {
            textView.setTextColor(-1);
        }
        try {
            this.c.setBackgroundResource(com.cmic.gen.sdk.z0.b(this.b, this.C.getLogBtnBackgroundPath()));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            this.c.setBackgroundResource(com.cmic.gen.sdk.z0.b(this.b, "umcsdk_login_btn_bg"));
        }
        return this.c;
    }

    private void h() {
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(this);
        this.r = relativeLayout;
        relativeLayout.setId(13107);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        this.r.setLayoutParams(layoutParams);
        android.widget.TextView textView = new android.widget.TextView(this);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        textView.setGravity(15);
        int numberOffsetX = this.C.getNumberOffsetX();
        if (numberOffsetX == 0) {
            layoutParams.addRule(13);
        } else if (numberOffsetX > 0) {
            float f2 = numberOffsetX;
            if ((this.E - textView.getWidth()) - com.cmic.gen.sdk.r1.a(this.b, f2) > 0) {
                layoutParams2.setMargins(com.cmic.gen.sdk.r1.a(this.b, f2), 0, 0, 0);
            } else {
                com.cmic.gen.sdk.h0.a(J, "RelativeLayout.ALIGN_PARENT_RIGHT");
                layoutParams2.addRule(11);
            }
        }
        try {
            textView.setTextSize(2, this.C.getNumberSize());
            textView.setContentDescription(this.o.replace("****", "星星星星").replaceAll("(.{1})", "$1 "));
        } catch (java.lang.Exception unused) {
            textView.setTextSize(2, 18.0f);
        }
        com.cmic.gen.sdk.l0.a(textView, this.o);
        if (this.C.isNumberBold()) {
            textView.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
        }
        textView.setId(30583);
        this.r.addView(textView, layoutParams2);
        try {
            textView.setTextColor(this.C.getNumberColor());
        } catch (java.lang.Exception unused2) {
            textView.setTextColor(-13421773);
        }
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        this.r.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        com.cmic.gen.sdk.h0.a(J, "mPhoneLayout.getMeasuredHeight()=" + this.r.getMeasuredHeight());
    }

    private void j() {
        java.lang.String strA = com.cmic.gen.sdk.h1.a("imageUrl", "");
        java.lang.String strA2 = com.cmic.gen.sdk.h1.a("displayLogo", "");
        java.lang.String str = J;
        com.cmic.gen.sdk.h0.c(str, "logoimgUrl=" + strA);
        com.cmic.gen.sdk.h0.c(str, "displaylogo=" + strA2);
        com.cmic.gen.sdk.h0.c(str, "config.isDisplayLogo()=" + this.C.isDisplayLogo());
        if (!android.text.TextUtils.isEmpty(strA) && strA2.equals("1") && this.C.isDisplayLogo()) {
            android.widget.ImageView imageView = new android.widget.ImageView(this.b);
            this.G = imageView;
            imageView.setVisibility(4);
            com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.view.GenLoginAuthActivity.m(strA));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        return (android.text.TextUtils.isEmpty(this.C.getCheckTipText()) && this.C.getGenCheckBoxListener() == null && this.C.getPrivacyAnimation() == null && this.C.getGenAuthLoginListener() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.c.setClickable(true);
        this.p.setClickable(true);
    }

    private void p() {
        this.c.setClickable(false);
        this.p.setClickable(false);
    }

    public void l() {
        try {
            com.cmic.gen.sdk.h0.b(J, "loginClickComplete");
            if (this.C.getGenLoginClickListener() == null || !this.F) {
                android.app.Dialog dialog = this.I;
                if (dialog != null && dialog.isShowing()) {
                    this.I.dismiss();
                }
            } else {
                this.F = false;
                this.C.getGenLoginClickListener().onLoginClickComplete(this.b, null);
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m() {
        com.cmic.gen.sdk.h0.b(J, "loginClickStart");
        try {
            this.F = true;
            if (this.C.getGenLoginClickListener() != null) {
                this.C.getGenLoginClickListener().onLoginClickStart(this.b, null);
            } else {
                android.app.Dialog dialog = this.I;
                if (dialog != null) {
                    dialog.show();
                    return;
                }
                android.app.AlertDialog alertDialogCreate = new android.app.AlertDialog.Builder(this).create();
                this.I = alertDialogCreate;
                alertDialogCreate.setCancelable(false);
                this.I.setCanceledOnTouchOutside(false);
                this.I.setOnKeyListener(new com.cmic.gen.sdk.view.GenLoginAuthActivity.d());
                android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(this.I.getContext());
                relativeLayout.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -2));
                android.widget.ImageView imageView = new android.widget.ImageView(this.I.getContext());
                imageView.setImageResource(com.cmic.gen.sdk.z0.b(this.b, "umcsdk_dialog_loading"));
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(80, 80);
                layoutParams.addRule(13, -1);
                relativeLayout.addView(imageView, layoutParams);
                if (this.I.getWindow() != null) {
                    this.I.getWindow().setDimAmount(0.0f);
                }
                this.I.setContentView(relativeLayout);
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        com.cmic.gen.sdk.h0.b(J, "loginClickStart");
    }

    public void n() {
        this.a.removeCallbacksAndMessages(null);
        com.cmic.gen.sdk.g1 g1Var = this.d;
        if (g1Var != null && g1Var.isShowing()) {
            this.d.dismiss();
        }
        com.cmic.gen.sdk.g1 g1Var2 = this.e;
        if (g1Var2 != null && g1Var2.isShowing()) {
            this.e.dismiss();
        }
        l();
        this.I = null;
        android.widget.RelativeLayout relativeLayout = this.q;
        if (relativeLayout != null) {
            relativeLayout.clearAnimation();
        }
        com.cmic.gen.sdk.view.a.a().b = 0;
        finish();
        if (this.C.getAuthPageActOut() == null || this.C.getActivityIn() == null) {
            return;
        }
        overridePendingTransition(com.cmic.gen.sdk.z0.a(this, this.C.getActivityIn()), com.cmic.gen.sdk.z0.a(this, this.C.getAuthPageActOut()));
    }

    private void b() {
        int privacyMarginLeft;
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.r.getLayoutParams();
        if (this.C.getNumFieldOffsetY() <= 0 && this.C.getNumFieldOffsetY_B() >= 0) {
            if (this.C.getNumFieldOffsetY_B() > 0 && (this.D - this.r.getMeasuredHeight()) - com.cmic.gen.sdk.r1.a(this.b, this.C.getNumFieldOffsetY_B()) > 0) {
                com.cmic.gen.sdk.h0.a(J, "numberField_bottom");
                layoutParams.addRule(12, -1);
                layoutParams.setMargins(0, 0, 0, com.cmic.gen.sdk.r1.a(this.b, this.C.getNumFieldOffsetY_B()));
            } else {
                layoutParams.addRule(10, -1);
            }
        } else {
            int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            this.r.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            java.lang.String str = J;
            com.cmic.gen.sdk.h0.a(str, "mPhoneLayout.getMeasuredHeight()=" + this.r.getMeasuredHeight());
            if (this.C.getNumFieldOffsetY() > 0 && (this.D - this.r.getMeasuredHeight()) - com.cmic.gen.sdk.r1.a(this.b, this.C.getNumFieldOffsetY()) > 0) {
                com.cmic.gen.sdk.h0.a(str, "numberField_top");
                layoutParams.addRule(10, -1);
                layoutParams.setMargins(0, com.cmic.gen.sdk.r1.a(this.b, this.C.getNumFieldOffsetY()), 0, 0);
            } else {
                layoutParams.addRule(12, -1);
            }
        }
        this.r.setLayoutParams(layoutParams);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.c.getLayoutParams();
        int iMax = java.lang.Math.max(this.C.getLogBtnMarginLeft(), 0);
        int iMax2 = java.lang.Math.max(this.C.getLogBtnMarginRight(), 0);
        if (this.C.getLogBtnOffsetY() <= 0 && this.C.getLogBtnOffsetY_B() >= 0) {
            if (this.C.getLogBtnOffsetY_B() > 0 && this.D - com.cmic.gen.sdk.r1.a(this.b, this.C.getLogBtnHeight() + this.C.getLogBtnOffsetY_B()) > 0) {
                com.cmic.gen.sdk.h0.a(J, "logBtn_bottom");
                layoutParams2.addRule(12, -1);
                layoutParams2.setMargins(com.cmic.gen.sdk.r1.a(this.b, iMax), 0, com.cmic.gen.sdk.r1.a(this.b, iMax2), com.cmic.gen.sdk.r1.a(this.b, this.C.getLogBtnOffsetY_B()));
            } else {
                layoutParams2.addRule(10, -1);
                layoutParams2.setMargins(com.cmic.gen.sdk.r1.a(this.b, iMax), 0, com.cmic.gen.sdk.r1.a(this.b, iMax2), 0);
            }
        } else if (this.C.getLogBtnOffsetY() > 0 && this.D - com.cmic.gen.sdk.r1.a(this.b, this.C.getLogBtnHeight() + this.C.getLogBtnOffsetY()) > 0) {
            com.cmic.gen.sdk.h0.a(J, "logBtn_top");
            layoutParams2.addRule(10, -1);
            layoutParams2.setMargins(com.cmic.gen.sdk.r1.a(this.b, iMax), com.cmic.gen.sdk.r1.a(this.b, this.C.getLogBtnOffsetY()), com.cmic.gen.sdk.r1.a(this.b, iMax2), 0);
        } else {
            layoutParams2.addRule(12, -1);
            layoutParams2.setMargins(com.cmic.gen.sdk.r1.a(this.b, iMax), 0, com.cmic.gen.sdk.r1.a(this.b, iMax2), 0);
        }
        this.c.setLayoutParams(layoutParams2);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) this.q.getLayoutParams();
        if (this.C.getPrivacyMarginLeft() >= 0) {
            privacyMarginLeft = this.C.getCheckedImgWidth() > 30 ? this.C.getPrivacyMarginLeft() : this.C.getPrivacyMarginLeft() - (30 - this.C.getCheckedImgWidth());
        } else {
            privacyMarginLeft = this.C.getCheckedImgWidth() > 30 ? 0 : -(30 - this.C.getCheckedImgWidth());
        }
        int iMax3 = java.lang.Math.max(this.C.getPrivacyMarginRight(), 0);
        int iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
        this.q.measure(iMakeMeasureSpec2, iMakeMeasureSpec2);
        if (this.C.getPrivacyOffsetY() <= 0 && this.C.getPrivacyOffsetY_B() >= 0) {
            if (this.C.getPrivacyOffsetY_B() > 0 && (this.D - this.q.getMeasuredHeight()) - com.cmic.gen.sdk.r1.a(this.b, this.C.getPrivacyOffsetY_B()) > 0) {
                com.cmic.gen.sdk.h0.a(J, "privacy_bottom=" + this.q.getMeasuredHeight());
                layoutParams3.addRule(12, -1);
                layoutParams3.setMargins(com.cmic.gen.sdk.r1.a(this.b, (float) privacyMarginLeft), 0, com.cmic.gen.sdk.r1.a(this.b, (float) iMax3), com.cmic.gen.sdk.r1.a(this.b, (float) this.C.getPrivacyOffsetY_B()));
            } else {
                layoutParams3.addRule(10, -1);
                layoutParams3.setMargins(com.cmic.gen.sdk.r1.a(this.b, privacyMarginLeft), 0, com.cmic.gen.sdk.r1.a(this.b, iMax3), 0);
                com.cmic.gen.sdk.h0.a(J, "privacy_top");
            }
        } else if (this.C.getPrivacyOffsetY() > 0 && (this.D - this.q.getMeasuredHeight()) - com.cmic.gen.sdk.r1.a(this.b, this.C.getPrivacyOffsetY()) > 0) {
            com.cmic.gen.sdk.h0.a(J, "privacy_top = " + this.q.getMeasuredHeight());
            layoutParams3.addRule(10, -1);
            layoutParams3.setMargins(com.cmic.gen.sdk.r1.a(this.b, (float) privacyMarginLeft), com.cmic.gen.sdk.r1.a(this.b, (float) this.C.getPrivacyOffsetY()), com.cmic.gen.sdk.r1.a(this.b, (float) iMax3), 0);
        } else {
            com.cmic.gen.sdk.h0.a(J, "privacy_bottom=" + privacyMarginLeft);
            layoutParams3.addRule(12, -1);
            layoutParams3.setMargins(com.cmic.gen.sdk.r1.a(this.b, (float) privacyMarginLeft), 0, com.cmic.gen.sdk.r1.a(this.b, (float) iMax3), 0);
        }
        this.q.setLayoutParams(layoutParams3);
    }

    static /* synthetic */ int a(com.cmic.gen.sdk.view.GenLoginAuthActivity genLoginAuthActivity, int i2) {
        int i3 = genLoginAuthActivity.t + i2;
        genLoginAuthActivity.t = i3;
        return i3;
    }

    private void i() {
        getWindow().addFlags(67108864);
        getWindow().addFlags(134217728);
        if (this.C.getStatusBarColor() != 0) {
            getWindow().addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
            getWindow().clearFlags(67108864);
            getWindow().setStatusBarColor(this.C.getStatusBarColor());
            getWindow().setNavigationBarColor(this.C.getStatusBarColor());
        }
        int i2 = this.C.isLightColor() ? io.objectbox.model.PropertyFlags.UNSIGNED : 0;
        if (this.C.isNavHidden()) {
            i2 |= 4098;
        }
        getWindow().getDecorView().setSystemUiVisibility(i2);
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(this);
        this.H = relativeLayout;
        relativeLayout.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        android.view.View contentView = this.C.getContentView();
        if (contentView != null) {
            android.view.ViewParent parent = contentView.getParent();
            if (parent != null) {
                ((android.view.ViewGroup) parent).removeView(contentView);
            }
            this.H.addView(contentView);
        } else if (this.C.getLayoutResID() != -1) {
            getLayoutInflater().inflate(this.C.getLayoutResID(), this.H);
        }
        setContentView(this.H);
        int requestedOrientation = getRequestedOrientation();
        this.D = com.cmic.gen.sdk.r1.a(this.b);
        int iB = com.cmic.gen.sdk.r1.b(this.b);
        this.E = iB;
        if ((requestedOrientation == 1 && iB > this.D) || (requestedOrientation == 0 && iB < this.D)) {
            this.E = this.D;
            this.D = iB;
        }
        com.cmic.gen.sdk.h0.a(J, "orientation = " + requestedOrientation + "--screenWidth = " + this.E + "--screenHeight = " + this.D);
        android.view.WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (this.C.getWindowWidth() != 0) {
            getWindow().getWindowManager().getDefaultDisplay().getMetrics(new android.util.DisplayMetrics());
            getWindowManager().getDefaultDisplay().getSize(new android.graphics.Point());
            attributes.width = com.cmic.gen.sdk.r1.a(this.b, this.C.getWindowWidth());
            int iA = com.cmic.gen.sdk.r1.a(this.b, this.C.getWindowHeight());
            attributes.height = iA;
            this.E = attributes.width;
            this.D = iA;
            attributes.x = com.cmic.gen.sdk.r1.a(this.b, this.C.getWindowX());
            if (this.C.getWindowBottom() == 1) {
                getWindow().setGravity(80);
            } else {
                attributes.y = com.cmic.gen.sdk.r1.a(this.b, this.C.getWindowY());
            }
            getWindow().setAttributes(attributes);
        }
        this.H.setFitsSystemWindows(this.C.isFitsSystemWindows());
        this.H.setClipToPadding(true);
        try {
            h();
            this.H.addView(this.r);
            this.H.addView(g());
            this.H.addView(e());
            b();
            j();
            a(this.H);
            this.c.setOnClickListener(this);
            this.x.setOnClickListener(this);
            this.p.setOnCheckedChangeListener(new com.cmic.gen.sdk.view.GenLoginAuthActivity.l());
            o();
            try {
                if (this.C.isPrivacyState()) {
                    android.widget.ImageView imageView = this.G;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    this.p.setChecked(true);
                    this.p.setBackgroundResource(com.cmic.gen.sdk.z0.b(this, this.C.getCheckedImgPath()));
                    this.c.setEnabled(true);
                    this.p.setContentDescription("复选框 已勾选 " + this.A);
                    return;
                }
                this.p.setChecked(false);
                android.widget.ImageView imageView2 = this.G;
                if (imageView2 != null) {
                    imageView2.setVisibility(4);
                }
                this.c.setEnabled(k());
                this.p.setBackgroundResource(com.cmic.gen.sdk.z0.b(this, this.C.getUncheckedImgPath()));
                this.p.setContentDescription("复选框 请双击勾选 " + this.A);
            } catch (java.lang.Exception unused) {
                this.p.setChecked(false);
            }
        } catch (java.lang.Exception e2) {
            com.cmic.gen.sdk.f0.D.add(e2);
            e2.printStackTrace();
            com.cmic.gen.sdk.h0.b(J, e2.toString());
            a("200040", "UI资源加载异常", this.m, null);
        }
    }

    public void a(java.lang.String str) {
        if (this.C.getAppLanguageType() == 1) {
            this.k = com.cmic.gen.sdk.l.b;
            this.l = com.cmic.gen.sdk.l.e;
            this.B = com.cmic.gen.sdk.l.h[1];
        } else if (this.C.getAppLanguageType() == 2) {
            this.k = com.cmic.gen.sdk.l.c;
            this.l = com.cmic.gen.sdk.l.f;
            this.B = com.cmic.gen.sdk.l.h[2];
        } else {
            this.k = com.cmic.gen.sdk.l.a;
            this.l = com.cmic.gen.sdk.l.d;
            this.B = com.cmic.gen.sdk.l.h[0];
        }
        if (str.equals("1")) {
            this.y = this.k[0];
            this.z = this.l[0];
        } else if (str.equals("3")) {
            this.y = this.k[1];
            this.z = this.l[1];
        } else if (str.equals("2")) {
            this.y = this.k[2];
            this.z = this.l[2];
        } else {
            this.y = this.k[3];
            this.z = this.l[3];
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.widget.RelativeLayout r12) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.gen.sdk.view.GenLoginAuthActivity.a(android.widget.RelativeLayout):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        try {
            com.cmic.gen.sdk.o.a("authPageOut");
            a("200020", "登录页面关闭", this.m, null);
        } catch (java.lang.Exception e2) {
            com.cmic.gen.sdk.f0.D.add(e2);
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            if (this.t >= 5) {
                android.widget.Toast.makeText(this.b, "网络不稳定,请返回重试其他登录方式", 1).show();
                this.c.setClickable(true);
                return;
            }
            java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
                com.cmic.gen.sdk.h0.b("stack", stackTraceElement.getClassName());
                java.lang.String className = stackTraceElement.getClassName();
                if (!android.text.TextUtils.isEmpty(className) && className.contains("com.cmic.gen.sdk.activity") && !sb.toString().contains(className)) {
                    sb.append(className);
                    sb.append(";");
                }
            }
            this.m.b("loginTime", java.lang.System.currentTimeMillis());
            java.lang.String strA = this.m.a("traceId", "");
            if (!android.text.TextUtils.isEmpty(strA) && com.cmic.gen.sdk.r0.d(strA)) {
                java.lang.String strC = com.cmic.gen.sdk.x1.c();
                this.m.b("traceId", strC);
                com.cmic.gen.sdk.r0.a(strC, this.v);
            }
            m();
            p();
            com.cmic.gen.sdk.view.GenLoginAuthActivity.p pVar = new com.cmic.gen.sdk.view.GenLoginAuthActivity.p(this.m);
            this.a.postDelayed(pVar, com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance((android.content.Context) this).getOverTime());
            com.cmic.gen.sdk.k1.a(new com.cmic.gen.sdk.view.GenLoginAuthActivity.o(this, pVar));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.i iVar, org.json.JSONObject jSONObject) {
        try {
            if (this.a == null) {
                this.a = new android.os.Handler(getMainLooper());
                this.u = new com.cmic.gen.sdk.view.GenLoginAuthActivity.n(this);
            }
            this.a.removeCallbacksAndMessages(null);
            if ("103000".equals(str)) {
                if (com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance((android.content.Context) this) == null || com.cmic.gen.sdk.r0.b(iVar.c("traceId")) == null) {
                    return;
                }
                iVar.b("keepListener", true);
                com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance((android.content.Context) this).callBackResult(str, str2, iVar, jSONObject);
                return;
            }
            if ("200020".equals(str)) {
                if (com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance((android.content.Context) this) != null) {
                    if (com.cmic.gen.sdk.r0.b(iVar.c("traceId")) != null) {
                        com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance((android.content.Context) this).callBackResult(str, str2, iVar, jSONObject);
                        n();
                        return;
                    } else {
                        n();
                        return;
                    }
                }
                return;
            }
            iVar.b("keepListener", true);
            com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance((android.content.Context) this).callBackResult(str, str2, iVar, jSONObject);
        } catch (java.lang.Exception e2) {
            com.cmic.gen.sdk.h0.b(J, "CallbackResult:未知错误");
            e2.printStackTrace();
        }
    }
}
