package com.chuanglan.shanyan_sdk.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class ShanYanOneKeyActivity extends android.app.Activity {
    public static java.lang.ref.WeakReference<com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity> mLoginActivityWeakReference;
    private int A;
    private com.chuanglan.shanyan_sdk.listener.OpenLoginAuthCallbaks C;
    private java.lang.Object D;
    private android.widget.TextView a;
    private android.widget.TextView b;
    private android.widget.TextView c;
    private android.widget.TextView d;
    private android.widget.Button e;
    private android.widget.ImageView f;
    private android.widget.ImageView g;
    private android.content.Context h;
    private com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig i;
    private android.widget.RelativeLayout j;
    private android.widget.RelativeLayout k;
    private android.widget.RelativeLayout l;
    private android.widget.RelativeLayout m;
    private android.widget.RelativeLayout n;
    private android.widget.CheckBox q;
    private android.view.ViewGroup r;
    private android.view.ViewGroup s;
    private android.view.ViewGroup t;
    private android.view.ViewGroup u;
    private com.chuanglan.shanyan_sdk.C0064u v;
    private long w;
    private long x;
    private long y;
    private java.lang.String z;
    private java.util.ArrayList o = null;
    private com.chuanglan.shanyan_sdk.s0 p = null;
    private int B = 0;

    class a implements java.lang.Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "ShanYanOneKeyActivity onBackInvoked");
            com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity shanYanOneKeyActivity = com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this;
            shanYanOneKeyActivity.a(shanYanOneKeyActivity.i.isBackPressedAvailable());
        }
    }

    class b implements android.view.View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.a(true);
        }
    }

    class c implements android.view.View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            try {
                if (com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.q.isChecked()) {
                    com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.o();
                } else {
                    com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.p();
                }
            } catch (java.lang.Exception e) {
                com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.a("LoginButtonClick Exception=" + e);
            }
        }
    }

    class d implements android.view.View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.q.performClick();
        }
    }

    class e implements android.widget.CompoundButton.OnCheckedChangeListener {
        e() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
            if (z) {
                com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity shanYanOneKeyActivity = com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this;
                shanYanOneKeyActivity.a(shanYanOneKeyActivity.q, com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.i.getCheckedImgPath(), "umcsdk_check_image");
                com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.a(2, 1, "选中协议复选框");
            } else {
                com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity shanYanOneKeyActivity2 = com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this;
                shanYanOneKeyActivity2.a(shanYanOneKeyActivity2.q, com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.i.getUncheckedImgPath(), "umcsdk_uncheck_image");
                com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.a(2, 0, "取消选中协议复选框");
            }
        }
    }

    class f implements android.view.View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            if (com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.p.a) {
                com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.finish();
            }
            if (com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.p.g != null) {
                com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.p.g.onClick(com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.h, view);
            }
        }
    }

    class g implements android.view.View.OnClickListener {
        final /* synthetic */ com.chuanglan.shanyan_sdk.r0 a;

        g(com.chuanglan.shanyan_sdk.r0 r0Var) {
            this.a = r0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            if (this.a.a) {
                com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.finish();
            }
            com.chuanglan.shanyan_sdk.listener.ShanYanCustomInterface shanYanCustomInterface = this.a.d;
            if (shanYanCustomInterface != null) {
                shanYanCustomInterface.onClick(com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.this.h, view);
            }
        }
    }

    private void A() {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "setViews");
        G();
        n();
        v();
        w();
        z();
        e();
        B();
    }

    private void B() {
        try {
            if (this.i.isBackNavigationEnabled() && com.chuanglan.shanyan_sdk.view.a.a()) {
                this.D = com.chuanglan.shanyan_sdk.view.a.a((android.app.Activity) this, (java.lang.Runnable) new com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.a());
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private void C() {
        if (this.i.isNavReturnImgHidden()) {
            this.k.setVisibility(8);
            return;
        }
        this.k.setVisibility(0);
        a(this.f, this.i.getNavReturnImgPath(), "umcsdk_return_bg");
        com.chuanglan.shanyan_sdk.w0.a(this.h, this.k, this.i.getNavReturnBtnOffsetX(), this.i.getNavReturnBtnOffsetY(), this.i.getNavReturnBtnOffsetRightX(), this.i.getReturnBtnWidth(), this.i.getReturnBtnHeight(), this.f);
    }

    private void D() {
        if (com.chuanglan.shanyan_sdk.AbstractC0049f.a(this.i.getNavText())) {
            this.b.setVisibility(8);
            return;
        }
        this.b.setVisibility(0);
        this.b.setText(this.i.getNavText());
        this.b.setTextColor(this.i.getNavTextColor());
        this.b.setTextSize(this.i.isTextSizeIsdp() ? 1 : 2, this.i.getNavTextSize());
        this.b.setTypeface(android.graphics.Typeface.defaultFromStyle(this.i.isNavTextBold() ? 1 : 0));
    }

    private void E() {
        if (this.i.isAuthNavHidden()) {
            this.j.setVisibility(8);
            return;
        }
        this.j.setVisibility(0);
        this.j.setBackgroundColor(this.i.getNavColor());
        if (this.i.isAuthNavTransparent()) {
            this.j.getBackground().setAlpha(0);
        }
        D();
        C();
    }

    private void F() {
        boolean zIsCustomPrivacyAlertViewAutoShow = this.i.isCustomPrivacyAlertViewAutoShow();
        com.chuanglan.shanyan_sdk.Q.a("UIShanYanLogger", "showPrivacyToast", java.lang.Boolean.valueOf(this.u == null), java.lang.Boolean.valueOf(this.i.isCustomPrivacyAlertViewAutoShow()));
        android.view.ViewGroup viewGroup = this.u;
        if (viewGroup != null && zIsCustomPrivacyAlertViewAutoShow) {
            viewGroup.setVisibility(0);
            this.u.setOnClickListener(null);
        }
        if (this.i.isPrivacyToastHidden()) {
            return;
        }
        if (this.i.getPrivacyCustomToast() != null) {
            this.i.getPrivacyCustomToast().show();
        } else if (this.i.getPrivacyCustomToastText() != null) {
            com.chuanglan.shanyan_sdk.AbstractC0046c.a(this.h, this.i.getPrivacyCustomToastText());
        } else {
            com.chuanglan.shanyan_sdk.AbstractC0046c.a(this.h, "请勾选协议");
        }
    }

    private void G() {
        com.chuanglan.shanyan_sdk.tool.a aVarB = com.chuanglan.shanyan_sdk.tool.a.b();
        com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfigA = aVarB.a();
        com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfigC = aVarB.c();
        if (shanYanUIConfigC == null) {
            shanYanUIConfigC = shanYanUIConfigA;
        }
        if (this.A != 1) {
            shanYanUIConfigA = shanYanUIConfigC;
        }
        this.i = shanYanUIConfigA;
    }

    private void g() {
        if (this.i.getLogBtnBackgroundColor() == -1) {
            a(this.e, this.i.getLogBtnBackgroundPath(), "umcsdk_login_btn_bg");
            return;
        }
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setCornerRadius(com.chuanglan.shanyan_sdk.AbstractC0046c.a(this.h, 25.0f));
        gradientDrawable.setColor(this.i.getLogBtnBackgroundColor());
        this.e.setBackground(gradientDrawable);
    }

    private void h() {
        if (this.i.isLogoHidden()) {
            this.g.setVisibility(8);
            return;
        }
        this.g.setVisibility(0);
        if (this.i.getLogoImgPath() != null) {
            this.g.setImageDrawable(this.i.getLogoImgPath());
        } else {
            this.g.setBackgroundResource(this.h.getResources().getIdentifier("umcsdk_mobile_logo", "drawable", com.chuanglan.shanyan_sdk.C0065v.g().c(this.h)));
        }
        a(this.g, this.i.getLogoImgPath(), "umcsdk_mobile_logo");
        com.chuanglan.shanyan_sdk.w0.a(this.h, this.g, this.i.getLogoOffsetX(), this.i.getLogoOffsetY(), this.i.getLogoOffsetBottomY(), this.i.getLogoWidth(), this.i.getLogoHeight());
    }

    private void i() {
        this.a.setText(com.chuanglan.shanyan_sdk.AbstractC0055l.p);
        this.a.setTextColor(this.i.getNumberColor());
        this.a.setTextSize(this.i.isTextSizeIsdp() ? 1 : 2, this.i.getNumberSize());
        this.a.setTypeface(android.graphics.Typeface.defaultFromStyle(this.i.isNumberBold() ? 1 : 0));
        com.chuanglan.shanyan_sdk.w0.a(this.h, this.a, this.i.getNumFieldOffsetX(), this.i.getNumFieldOffsetY(), this.i.getNumFieldOffsetBottomY(), this.i.getNumFieldWidth(), this.i.getNumFieldHeight());
    }

    private void j() {
        if (this.i.isCheckBoxHidden()) {
            this.m.setVisibility(8);
            return;
        }
        this.m.setVisibility(0);
        com.chuanglan.shanyan_sdk.w0.a(this.h, this.m, this.i.getCbMarginLeft(), this.i.getCbMarginTop(), this.i.getCbMarginRigth(), this.i.getCbMarginBottom(), this.i.getCbLeft(), this.i.getCbTop());
        com.chuanglan.shanyan_sdk.w0.a(this.h, this.q, this.i.getCheckboxWidth(), this.i.getCheckboxWidth());
        if (this.i.isPrivacyState()) {
            this.q.setChecked(true);
            a(this.q, this.i.getCheckedImgPath(), "umcsdk_check_image");
        } else {
            this.q.setChecked(false);
            a(this.q, this.i.getUncheckedImgPath(), "umcsdk_uncheck_image");
        }
    }

    private void k() {
        com.chuanglan.shanyan_sdk.t0.h().a(this.q);
        j();
        this.d.setTextSize(this.i.isTextSizeIsdp() ? 1 : 2, this.i.getPrivacyTextSize());
        this.d.setTypeface(android.graphics.Typeface.defaultFromStyle(this.i.isPrivacyTextBold() ? 1 : 0));
        if (this.i.getPrivacyTextLineSpacingAdd() != -1.0f && this.i.getPrivacyTextLineSpacingMult() != -1.0f) {
            this.d.setLineSpacing(this.i.getPrivacyTextLineSpacingAdd(), this.i.getPrivacyTextLineSpacingMult());
        }
        com.chuanglan.shanyan_sdk.AbstractC0063t.a(this.i, this.h, this.d, this.r, this.z);
    }

    private void l() {
        if (this.i.isSloganHidden()) {
            this.c.setVisibility(8);
            return;
        }
        this.c.setVisibility(0);
        this.c.setText(com.chuanglan.shanyan_sdk.f0.c(this.z));
        this.c.setTextColor(this.i.getSloganTextColor());
        this.c.setTextSize(this.i.isTextSizeIsdp() ? 1 : 2, this.i.getSloganTextSize());
        this.c.setTypeface(android.graphics.Typeface.defaultFromStyle(this.i.isSloganTextBold() ? 1 : 0));
        com.chuanglan.shanyan_sdk.w0.a(this.h, this.c, this.i.getSloganOffsetX(), this.i.getSloganOffsetY(), this.i.getSloganOffsetBottomY());
    }

    private void m() {
        if (this.i.getAuthBgVideoPath() == null) {
            com.chuanglan.shanyan_sdk.C0064u c0064u = this.v;
            if (c0064u != null) {
                this.n.removeView(c0064u);
                this.v = null;
                return;
            }
            return;
        }
        if (this.v == null) {
            com.chuanglan.shanyan_sdk.C0064u c0064u2 = new com.chuanglan.shanyan_sdk.C0064u(this.h);
            this.v = c0064u2;
            c0064u2.setOnCompletionListener(null);
            this.v.setOnPreparedListener(null);
            this.v.setOnErrorListener(null);
            this.n.addView(this.v, 0, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        }
        com.chuanglan.shanyan_sdk.w0.a(this.v, this.h, this.i.getAuthBgVideoPath());
    }

    private void n() {
        com.chuanglan.shanyan_sdk.z0.a(this, this.i.isAuthFlagSecureEnable());
        b(true);
        if (this.i.isDialogTheme()) {
            com.chuanglan.shanyan_sdk.z0.a(this, this.i);
            com.chuanglan.shanyan_sdk.z0.a(this, this.i.getDialogDimAmount());
        }
        com.chuanglan.shanyan_sdk.z0.b(this, this.i.isFullScreen());
        if (!this.i.isFullScreen()) {
            com.chuanglan.shanyan_sdk.z0.c(this, this.i);
        }
        com.chuanglan.shanyan_sdk.z0.a(this.n, this.i.isFitsSystemWindows());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "handleCheckedLogin count", java.lang.Integer.valueOf(this.B));
        this.e.setClickable(false);
        this.B++;
        y();
        com.chuanglan.shanyan_sdk.E.a().a(4, java.lang.System.currentTimeMillis(), android.os.SystemClock.uptimeMillis());
        a(3, 1, "点击登录按钮（协议框已勾选）");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "handleUncheckedLogin");
        this.s.setVisibility(8);
        F();
        a(3, 0, "点击登录按钮（协议框未勾选）");
    }

    private void q() {
        java.lang.String str = com.chuanglan.shanyan_sdk.AbstractC0055l.m;
        this.z = str;
        com.chuanglan.shanyan_sdk.AbstractC0055l.q = str;
        android.content.Intent intent = getIntent();
        this.y = intent.getLongExtra("beginTime", java.lang.System.currentTimeMillis());
        this.w = intent.getLongExtra("stepStartTime", android.os.SystemClock.uptimeMillis());
        this.x = intent.getLongExtra("methodStartTime", java.lang.System.currentTimeMillis());
    }

    private void r() {
        mLoginActivityWeakReference = new java.lang.ref.WeakReference<>(this);
        this.h = getApplicationContext();
        this.A = getResources().getConfiguration().orientation;
        this.i = com.chuanglan.shanyan_sdk.tool.a.b().a();
        this.t = (android.view.ViewGroup) getWindow().getDecorView();
        this.n = (android.widget.RelativeLayout) findViewById(com.chuanglan.shanyan_sdk.O.a(this.h).b("shanyan_view_login_layout"));
        this.l = (android.widget.RelativeLayout) findViewById(com.chuanglan.shanyan_sdk.O.a(this.h).b("shanyan_view_login_boby"));
        this.j = (android.widget.RelativeLayout) findViewById(com.chuanglan.shanyan_sdk.O.a(this.h).b("shanyan_view_navigationbar_include"));
        this.f = (android.widget.ImageView) findViewById(com.chuanglan.shanyan_sdk.O.a(this.h).b("shanyan_view_navigationbar_back"));
        this.k = (android.widget.RelativeLayout) findViewById(com.chuanglan.shanyan_sdk.O.a(this.h).b("shanyan_view_navigationbar_back_root"));
        this.b = (android.widget.TextView) findViewById(com.chuanglan.shanyan_sdk.O.a(this.h).b("shanyan_view_navigationbar_title"));
        this.g = (android.widget.ImageView) findViewById(com.chuanglan.shanyan_sdk.O.a(this.h).b("shanyan_view_log_image"));
        this.a = (android.widget.TextView) findViewById(com.chuanglan.shanyan_sdk.O.a(this.h).b("shanyan_view_tv_per_code"));
        this.e = (android.widget.Button) findViewById(com.chuanglan.shanyan_sdk.O.a(this.h).b("shanyan_view_bt_one_key_login"));
        this.c = (android.widget.TextView) findViewById(com.chuanglan.shanyan_sdk.O.a(this.h).b("shanyan_view_identify_tv"));
        this.r = (android.view.ViewGroup) findViewById(com.chuanglan.shanyan_sdk.O.a(this.h).b("shanyan_view_privacy_include"));
        this.d = (android.widget.TextView) findViewById(com.chuanglan.shanyan_sdk.O.a(this.h).b("shanyan_view_privacy_text"));
        this.q = (android.widget.CheckBox) findViewById(com.chuanglan.shanyan_sdk.O.a(this.h).b("shanyan_view_privacy_checkbox"));
        this.m = (android.widget.RelativeLayout) findViewById(com.chuanglan.shanyan_sdk.O.a(this.h).b("shanyan_view_privacy_checkbox_rootlayout"));
    }

    private void s() {
        if (com.chuanglan.shanyan_sdk.AbstractC0055l.T != null) {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "ShanYanOneKeyActivity onActivityCreated");
            com.chuanglan.shanyan_sdk.AbstractC0055l.T.onActivityCreated(this);
        }
    }

    private void t() {
        com.chuanglan.shanyan_sdk.listener.OpenLoginAuthCallbaks openLoginAuthCallbaks = this.C;
        if (openLoginAuthCallbaks != null) {
            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.OPEN_PAGE_SUCCESS_CODE;
            openLoginAuthCallbaks.openPageSuccessed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c(), this.y, this.w, this.x);
        }
    }

    private void u() {
        if (this.o.isEmpty()) {
            return;
        }
        for (com.chuanglan.shanyan_sdk.r0 r0Var : this.o) {
            if (((android.view.View) r0Var.c.getParent()) != null) {
                if (r0Var.b) {
                    this.j.removeView(r0Var.c);
                } else {
                    this.l.removeView(r0Var.c);
                }
            }
        }
    }

    private void v() {
        c();
        E();
        h();
        i();
        f();
        l();
        k();
    }

    private void w() {
        if (this.o == null) {
            this.o = new java.util.ArrayList();
        }
        u();
        if (this.i.getCustomViews() != null) {
            this.o.clear();
            this.o.addAll(this.i.getCustomViews());
            for (int i = 0; i < this.o.size(); i++) {
                com.chuanglan.shanyan_sdk.r0 r0Var = (com.chuanglan.shanyan_sdk.r0) this.o.get(i);
                if (r0Var.b) {
                    this.j.addView(r0Var.c, 0);
                } else {
                    this.l.addView(r0Var.c, 0);
                }
                r0Var.c.setOnClickListener(new com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.g(r0Var));
            }
        }
    }

    private void x() {
        this.C = new com.chuanglan.shanyan_sdk.e0(this.h);
        this.k.setOnClickListener(new com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.b());
        this.e.setOnClickListener(new com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.c());
        this.m.setOnClickListener(new com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.d());
        this.q.setOnCheckedChangeListener(new com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.e());
    }

    private void y() {
        android.view.ViewGroup viewGroup = this.s;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            this.s.setOnClickListener(null);
        }
    }

    private void z() {
        android.view.View view;
        com.chuanglan.shanyan_sdk.s0 s0Var = this.p;
        if (s0Var != null && (view = s0Var.f) != null && ((android.view.View) view.getParent()) != null) {
            this.l.removeView(this.p.f);
        }
        if (this.i.getRelativeCustomView() != null) {
            this.p = this.i.getRelativeCustomView();
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutParams.setMargins(com.chuanglan.shanyan_sdk.AbstractC0046c.a(this.h, this.p.b), com.chuanglan.shanyan_sdk.AbstractC0046c.a(this.h, this.p.c), com.chuanglan.shanyan_sdk.AbstractC0046c.a(this.h, this.p.d), com.chuanglan.shanyan_sdk.AbstractC0046c.a(this.h, this.p.e));
            layoutParams.addRule(14);
            layoutParams.addRule(3, com.chuanglan.shanyan_sdk.O.a(this).b("shanyan_view_bt_one_key_login"));
            layoutParams.addRule(2, com.chuanglan.shanyan_sdk.O.a(this).b("shanyan_view_privacy_include"));
            this.p.f.setLayoutParams(layoutParams);
            this.l.addView(this.p.f, 0);
            this.p.f.setOnClickListener(new com.chuanglan.shanyan_sdk.view.ShanYanOneKeyActivity.f());
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        try {
            b(false);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "ShanYanOneKeyActivity finish Exception=", e2);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            int i = configuration.orientation;
            com.chuanglan.shanyan_sdk.Q.a("UIShanYanLogger", "configurationChanged", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(this.A));
            if (this.A != i) {
                this.A = i;
                A();
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "ShanYanOneKeyActivity onConfigurationChanged Exception=", e2);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (bundle != null) {
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "recreate and savedInstanceState is not null");
                finish();
                return;
            }
            setContentView(com.chuanglan.shanyan_sdk.O.a(this).c("layout_shanyan_login"));
            r();
            q();
            x();
            A();
            t();
            s();
        } catch (java.lang.Exception e2) {
            b("onCreate Exception=" + e2);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (!isChangingConfigurations() && com.chuanglan.shanyan_sdk.t0.h().n()) {
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "ShanYanOneKeyActivity onDestroy without callback, fire USER_CANCEL");
            com.chuanglan.shanyan_sdk.S s = new com.chuanglan.shanyan_sdk.S(this.h);
            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.USER_CANCEL_CODE;
            s.getTokenFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c(), this.z, this.y, this.w, this.x);
        }
        try {
            com.chuanglan.shanyan_sdk.AbstractC0055l.U.set(true);
            java.lang.Object obj = this.D;
            if (obj != null) {
                com.chuanglan.shanyan_sdk.view.a.a(this, obj);
                this.D = null;
            }
            android.widget.RelativeLayout relativeLayout = this.n;
            if (relativeLayout != null) {
                com.chuanglan.shanyan_sdk.x0.a(relativeLayout);
                this.n = null;
            }
            java.util.ArrayList arrayList = this.o;
            if (arrayList != null) {
                arrayList.clear();
                this.o = null;
            }
            android.widget.RelativeLayout relativeLayout2 = this.j;
            if (relativeLayout2 != null) {
                com.chuanglan.shanyan_sdk.x0.a(relativeLayout2);
                this.j = null;
            }
            android.widget.RelativeLayout relativeLayout3 = this.l;
            if (relativeLayout3 != null) {
                com.chuanglan.shanyan_sdk.x0.a(relativeLayout3);
                this.l = null;
            }
            com.chuanglan.shanyan_sdk.C0064u c0064u = this.v;
            if (c0064u != null) {
                c0064u.setOnCompletionListener(null);
                this.v.setOnPreparedListener(null);
                this.v.setOnErrorListener(null);
                this.v = null;
            }
            android.widget.Button button = this.e;
            if (button != null) {
                com.chuanglan.shanyan_sdk.x0.a(button);
                this.e = null;
            }
            android.widget.CheckBox checkBox = this.q;
            if (checkBox != null) {
                checkBox.setOnCheckedChangeListener(null);
                this.q.setOnClickListener(null);
                this.q = null;
            }
            android.widget.RelativeLayout relativeLayout4 = this.k;
            if (relativeLayout4 != null) {
                com.chuanglan.shanyan_sdk.x0.a(relativeLayout4);
                this.k = null;
            }
            android.widget.RelativeLayout relativeLayout5 = this.m;
            if (relativeLayout5 != null) {
                com.chuanglan.shanyan_sdk.x0.a(relativeLayout5);
                this.m = null;
            }
            android.view.ViewGroup viewGroup = this.t;
            if (viewGroup != null) {
                com.chuanglan.shanyan_sdk.x0.a(viewGroup);
                this.t = null;
            }
            com.chuanglan.shanyan_sdk.tool.a.b().d();
            android.view.ViewGroup viewGroup2 = this.r;
            if (viewGroup2 != null) {
                com.chuanglan.shanyan_sdk.x0.a(viewGroup2);
                this.r = null;
            }
            com.chuanglan.shanyan_sdk.t0.h().e();
            this.a = null;
            this.f = null;
            this.b = null;
            this.g = null;
            this.c = null;
            this.d = null;
            this.l = null;
            com.chuanglan.shanyan_sdk.F.c().a();
            if (com.chuanglan.shanyan_sdk.AbstractC0055l.T != null) {
                com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "ShanYanOneKeyActivity onActivityDestroyed");
                com.chuanglan.shanyan_sdk.AbstractC0055l.T.onActivityDestroyed(this);
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "onDestroy Exception", e2);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "ShanYanOneKeyActivity onKeyDown");
        a(this.i.isBackPressedAvailable());
        return true;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.v == null || this.i.getAuthBgVideoPath() == null) {
            return;
        }
        com.chuanglan.shanyan_sdk.w0.a(this.v, this.h, this.i.getAuthBgVideoPath());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.chuanglan.shanyan_sdk.C0064u c0064u = this.v;
        if (c0064u != null) {
            c0064u.stopPlayback();
        }
    }

    private void b(boolean z) {
        java.lang.String enterAnim = this.i.getEnterAnim();
        java.lang.String exitAnim = this.i.getExitAnim();
        if (enterAnim == null && exitAnim == null) {
            return;
        }
        int iA = com.chuanglan.shanyan_sdk.O.a(this.h).a(enterAnim);
        int iA2 = com.chuanglan.shanyan_sdk.O.a(this.h).a(exitAnim);
        if (android.os.Build.VERSION.SDK_INT >= 34) {
            com.getui.gtc.a.f$.ExternalSyntheticApiModelOutline0.m(this, !z ? 1 : 0, iA, iA2);
        } else {
            overridePendingTransition(iA, iA2);
        }
    }

    private void c() {
        if (this.i.getAuthBgVideoPath() != null) {
            m();
        } else if (this.i.getAuthBgGifPath() != null) {
            d();
        } else {
            a(this.n, this.i.getAuthBGImgPath(), "umcsdk_shanyan_authbackground");
        }
    }

    private void d() {
        try {
            com.chuanglan.shanyan_sdk.F.c().a(getResources().openRawResource(this.h.getResources().getIdentifier(this.i.getAuthBgGifPath(), "drawable", com.chuanglan.shanyan_sdk.C0065v.g().c(this.h)))).a(this.n);
        } catch (java.lang.Exception e2) {
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "Error loading GIF background", e2);
        }
    }

    private void e() {
        b();
        a();
    }

    private void f() {
        com.chuanglan.shanyan_sdk.t0.h().a(this.e);
        this.e.setClickable(true);
        this.e.setText(this.i.getLogBtnText());
        this.e.setTextColor(this.i.getLogBtnTextColor());
        this.e.setTextSize(this.i.isTextSizeIsdp() ? 1 : 2, this.i.getLogBtnTextSize());
        this.e.setTypeface(android.graphics.Typeface.defaultFromStyle(this.i.isLogBtnTextBold() ? 1 : 0));
        g();
        com.chuanglan.shanyan_sdk.w0.b(this.h, this.e, this.i.getLogBtnOffsetX(), this.i.getLogBtnOffsetY(), this.i.getLogBtnOffsetBottomY(), this.i.getLogBtnWidth(), this.i.getLogBtnHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str) {
        com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", str);
        com.chuanglan.shanyan_sdk.S s = new com.chuanglan.shanyan_sdk.S(this.h);
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.SDK_EXCEPTION_CODE;
        s.getTokenFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c() + str, this.z, this.y, this.w, this.x);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, java.lang.String str) {
        com.chuanglan.shanyan_sdk.listener.AuthPageActionListener authPageActionListener = com.chuanglan.shanyan_sdk.AbstractC0055l.S;
        if (authPageActionListener != null) {
            authPageActionListener.setAuthPageActionListener(i, i2, str);
        }
    }

    private void a() {
        android.view.ViewGroup viewGroup = this.u;
        if (viewGroup != null && viewGroup.getParent() != null) {
            this.n.removeView(this.u);
            this.u = null;
        }
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) this.i.getCustomPrivacyAlertView();
        com.chuanglan.shanyan_sdk.Q.a("UIShanYanLogger", "customView", java.lang.Boolean.valueOf(viewGroup2 == null));
        if (viewGroup2 != null) {
            this.u = viewGroup2;
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.u.setLayoutParams(layoutParams);
            this.u.setOnClickListener(null);
            this.u.setVisibility(8);
            this.n.addView(this.u);
            this.u.bringToFront();
        }
    }

    private void b(java.lang.String str) {
        com.chuanglan.shanyan_sdk.listener.OpenLoginAuthCallbaks openLoginAuthCallbaks = this.C;
        if (openLoginAuthCallbaks != null) {
            com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.SDK_EXCEPTION_CODE;
            openLoginAuthCallbaks.openPageFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c() + str, this.z, this.y, this.w, this.x);
        }
    }

    private void b() {
        android.view.ViewGroup viewGroup = this.s;
        if (viewGroup != null && viewGroup.getParent() != null) {
            this.l.removeView(this.s);
            this.s = null;
        }
        android.view.View loadingView = this.i.getLoadingView();
        if (loadingView != null) {
            this.s = (android.view.ViewGroup) loadingView;
        } else {
            this.s = (android.view.ViewGroup) com.chuanglan.shanyan_sdk.O.a(this).c("layout_shanyan_loading_item");
        }
        if (this.s != null) {
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.s.setLayoutParams(layoutParams);
            this.s.setOnClickListener(null);
            this.s.setVisibility(8);
            this.l.addView(this.s);
            this.s.bringToFront();
        }
        com.chuanglan.shanyan_sdk.t0.h().a(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.view.View view, android.graphics.drawable.Drawable drawable, java.lang.String str) {
        if (drawable != null) {
            if (view instanceof android.widget.ImageView) {
                ((android.widget.ImageView) view).setImageDrawable(drawable);
                return;
            } else {
                view.setBackground(drawable);
                return;
            }
        }
        int identifier = this.h.getResources().getIdentifier(str, "drawable", com.chuanglan.shanyan_sdk.C0065v.g().c(this.h));
        if (identifier != 0) {
            if (view instanceof android.widget.ImageView) {
                ((android.widget.ImageView) view).setImageResource(identifier);
            } else {
                view.setBackgroundResource(identifier);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.chuanglan.shanyan_sdk.S s = new com.chuanglan.shanyan_sdk.S(this.h);
        com.chuanglan.shanyan_sdk.EnumC0060q enumC0060q = com.chuanglan.shanyan_sdk.EnumC0060q.USER_CANCEL_CODE;
        s.getTokenFailed(enumC0060q.d(), enumC0060q.b(), enumC0060q.e(), enumC0060q.c(), this.z, this.y, this.w, this.x);
        if (z) {
            finish();
        }
    }
}
