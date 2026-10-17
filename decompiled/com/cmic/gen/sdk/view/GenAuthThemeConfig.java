package com.cmic.gen.sdk.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class GenAuthThemeConfig {
    public static final java.lang.String PLACEHOLDER = "$$运营商条款$$";
    private int A;
    private int A0;
    private int B;
    private int B0;
    private int C;
    private int C0;
    private int D;
    private int D0;
    private int E;
    private int E0;
    private boolean F;
    private boolean F0;
    private int G;
    private java.lang.String G0;
    private int H;
    private java.lang.String H0;
    private int I;
    private java.lang.String I0;
    private int J;
    private java.lang.String J0;
    private java.lang.String K;
    private int K0;
    private boolean L;
    private int L0;
    private int M;
    private int M0;
    private boolean N;
    private int N0;
    private int O;
    private int O0;
    private java.lang.String P;
    private int P0;
    private int Q;
    private int Q0;
    private int R;
    private int R0;
    private int S;
    private boolean S0;
    private int T;
    private boolean T0;
    private int U;
    private java.lang.String U0;
    private int V;
    private java.lang.String W;
    private boolean X;
    private com.cmic.gen.sdk.view.GenBackPressedListener Y;
    private com.cmic.gen.sdk.view.GenLoginClickListener Z;
    private final boolean a;
    private com.cmic.gen.sdk.view.GenCheckBoxListener a0;
    private int b;
    private com.cmic.gen.sdk.view.GenCheckedChangeListener b0;
    private boolean c;
    private com.cmic.gen.sdk.view.GenAuthLoginListener c0;
    private android.view.View d;
    private com.cmic.gen.sdk.view.ClauseClickListener d0;
    private int e;
    private java.lang.String e0;
    private int f;
    private java.lang.String f0;
    private java.lang.String g;
    private int g0;
    private boolean h;
    private int h0;
    private int i;
    private boolean i0;
    private int j;
    private java.lang.String j0;
    private int k;
    private boolean k0;
    private boolean l;
    private java.lang.String l0;
    private int m;
    private java.lang.String m0;
    private java.lang.String n;
    private java.lang.String n0;
    private int o;
    private java.lang.String o0;
    private int p;
    private java.lang.String p0;
    private android.widget.ImageView.ScaleType q;
    private java.lang.String q0;
    private int r;
    private java.lang.String r0;
    private int s;
    private java.lang.String s0;
    private int t;
    private boolean t0;
    private int u;
    private int u0;
    private int v;
    private boolean v0;
    private android.widget.ImageView.ScaleType w;
    private boolean w0;
    private boolean x;
    private int x0;
    private int y;
    private int y0;
    private boolean z;
    private boolean z0;

    public java.lang.String getActivityIn() {
        return this.J0;
    }

    public java.lang.String getActivityOut() {
        return this.H0;
    }

    public int getAppLanguageType() {
        return this.R0;
    }

    public java.lang.String getAuthPageActIn() {
        return this.G0;
    }

    public java.lang.String getAuthPageActOut() {
        return this.I0;
    }

    public int getCheckBoxLocation() {
        return this.A0;
    }

    public java.lang.String getCheckTipText() {
        if (this.X) {
            int i = this.R0;
            this.W = i == 1 ? "請勾選同意服務條款" : i == 2 ? "Please check to agree to the terms of service" : "请勾选同意服务条款";
        }
        return this.W;
    }

    public int getCheckedImgHeight() {
        return this.h0;
    }

    public java.lang.String getCheckedImgPath() {
        return this.e0;
    }

    public int getCheckedImgWidth() {
        return this.g0;
    }

    public int getClauseBaseColor() {
        return this.x0;
    }

    public com.cmic.gen.sdk.view.ClauseClickListener getClauseClickListener() {
        return this.d0;
    }

    public int getClauseColor() {
        return this.y0;
    }

    public int getClauseLayoutResID() {
        return this.f;
    }

    public java.lang.String getClauseLayoutReturnID() {
        return this.g;
    }

    public java.lang.String getClauseName() {
        return this.l0;
    }

    public java.lang.String getClauseName2() {
        return this.n0;
    }

    public java.lang.String getClauseName3() {
        return this.p0;
    }

    public java.lang.String getClauseName4() {
        return this.r0;
    }

    public int getClauseStatusColor() {
        return this.m;
    }

    public java.lang.String getClauseUrl() {
        return this.m0;
    }

    public java.lang.String getClauseUrl2() {
        return this.o0;
    }

    public java.lang.String getClauseUrl3() {
        return this.q0;
    }

    public java.lang.String getClauseUrl4() {
        return this.s0;
    }

    public android.view.View getContentView() {
        return this.d;
    }

    public com.cmic.gen.sdk.view.GenAuthLoginListener getGenAuthLoginListener() {
        return this.c0;
    }

    public com.cmic.gen.sdk.view.GenBackPressedListener getGenBackPressedListener() {
        return this.Y;
    }

    public com.cmic.gen.sdk.view.GenCheckBoxListener getGenCheckBoxListener() {
        return this.a0;
    }

    public com.cmic.gen.sdk.view.GenCheckedChangeListener getGenCheckedChangeListener() {
        return this.b0;
    }

    public com.cmic.gen.sdk.view.GenLoginClickListener getGenLoginClickListener() {
        return this.Z;
    }

    public int getLayoutResID() {
        return this.e;
    }

    public java.lang.String getLogBtnBackgroundPath() {
        return this.P;
    }

    public int getLogBtnHeight() {
        return this.R;
    }

    public int getLogBtnMarginLeft() {
        return this.S;
    }

    public int getLogBtnMarginRight() {
        return this.T;
    }

    public int getLogBtnOffsetY() {
        return this.U;
    }

    public int getLogBtnOffsetY_B() {
        return this.V;
    }

    public java.lang.String getLogBtnText() {
        if (this.L) {
            int i = this.R0;
            this.K = i == 1 ? "本機號碼登錄" : i == 2 ? "Login" : this.K;
        }
        return this.K;
    }

    public int getLogBtnTextColor() {
        return this.O;
    }

    public int getLogBtnTextSize() {
        return this.M;
    }

    public int getLogBtnWidth() {
        return this.Q;
    }

    public int getLogoHeight() {
        return this.s;
    }

    public int getLogoOffsetX() {
        return this.t;
    }

    public int getLogoOffsetY() {
        return this.u;
    }

    public int getLogoOffsetY_B() {
        return this.v;
    }

    public android.widget.ImageView.ScaleType getLogoScaleType() {
        return this.w;
    }

    public int getLogoWidth() {
        return this.r;
    }

    public int getNavColor() {
        return this.k;
    }

    public int getNavReturnImgHeight() {
        return this.p;
    }

    public java.lang.String getNavReturnImgPath() {
        return this.n;
    }

    public android.widget.ImageView.ScaleType getNavReturnImgScaleType() {
        return this.q;
    }

    public int getNavReturnImgWidth() {
        return this.o;
    }

    public int getNavTextColor() {
        return this.j;
    }

    public int getNavTextSize() {
        return this.i;
    }

    public int getNumFieldOffsetY() {
        return this.C;
    }

    public int getNumFieldOffsetY_B() {
        return this.D;
    }

    public int getNumberColor() {
        return this.A;
    }

    public int getNumberOffsetX() {
        return this.B;
    }

    public int getNumberSize() {
        return this.y;
    }

    public java.lang.String getPrivacy() {
        if (!this.k0) {
            return this.j0;
        }
        int i = this.R0;
        return java.lang.String.format(i == 1 ? "登錄即同意%s並使用本機號碼登錄" : i == 2 ? "By logging in, you agree to the %s and use your local phone number to log in" : "登录即同意%s并使用本机号码登录", PLACEHOLDER);
    }

    public java.lang.String getPrivacyAnimation() {
        return this.U0;
    }

    public int getPrivacyDialogThemeId() {
        return this.Q0;
    }

    public int getPrivacyMarginLeft() {
        return this.B0;
    }

    public int getPrivacyMarginRight() {
        return this.C0;
    }

    public int getPrivacyOffsetY() {
        return this.D0;
    }

    public int getPrivacyOffsetY_B() {
        return this.E0;
    }

    public int getPrivacyTextSize() {
        return this.u0;
    }

    public boolean getProvideTextBold() {
        return this.F;
    }

    public int getProvideTextColor() {
        return this.G;
    }

    public int getProvideTextOffsetX() {
        return this.H;
    }

    public int getProvideTextOffsetY() {
        return this.I;
    }

    public int getProvideTextOffsetY_B() {
        return this.J;
    }

    public int getProvideTextSize() {
        return this.E;
    }

    public int getStatusBarColor() {
        return this.b;
    }

    public int getThemeId() {
        return this.P0;
    }

    public java.lang.String getUncheckedImgPath() {
        return this.f0;
    }

    public boolean getWebStorage() {
        return this.a;
    }

    public int getWindowBottom() {
        return this.O0;
    }

    public int getWindowHeight() {
        return this.L0;
    }

    public int getWindowWidth() {
        return this.K0;
    }

    public int getWindowX() {
        return this.M0;
    }

    public int getWindowY() {
        return this.N0;
    }

    public boolean isBackButton() {
        return this.T0;
    }

    public boolean isCheckBoxAccurateClick() {
        return this.t0;
    }

    public boolean isDisplayLogo() {
        return this.x;
    }

    public boolean isFitsSystemWindows() {
        return this.S0;
    }

    public boolean isGetWebViewTitle() {
        return this.h;
    }

    public boolean isLightColor() {
        return this.c;
    }

    public boolean isLogBtnTextBold() {
        return this.N;
    }

    public boolean isNavHidden() {
        return this.l;
    }

    public boolean isNumberBold() {
        return this.z;
    }

    public boolean isPrivacyBookSymbol() {
        return this.F0;
    }

    public boolean isPrivacyPageFullScreen() {
        return this.v0;
    }

    public boolean isPrivacyState() {
        return this.i0;
    }

    public boolean isPrivacyTextBold() {
        return this.w0;
    }

    public boolean isPrivacyTextGravityCenter() {
        return this.z0;
    }

    private GenAuthThemeConfig(com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder builder) {
        this.L = true;
        this.p0 = null;
        this.q0 = null;
        this.r0 = null;
        this.s0 = null;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        this.m = builder.m;
        this.n = builder.n;
        this.o = builder.o;
        this.p = builder.p;
        this.q = builder.q;
        this.t = builder.t;
        this.r = builder.r;
        this.s = builder.s;
        this.u = builder.u;
        this.v = builder.v;
        this.w = builder.w;
        this.x = builder.x;
        this.y = builder.y;
        this.z = builder.z;
        this.A = builder.A;
        this.B = builder.B;
        this.C = builder.C;
        this.D = builder.D;
        this.E = builder.E;
        this.F = builder.F;
        this.G = builder.G;
        this.H = builder.H;
        this.I = builder.I;
        this.J = builder.J;
        this.K = builder.K;
        this.L = builder.L;
        this.M = builder.M;
        this.N = builder.N;
        this.O = builder.O;
        this.P = builder.P;
        this.Q = builder.Q;
        this.R = builder.R;
        this.S = builder.S;
        this.T = builder.T;
        this.U = builder.U;
        this.V = builder.V;
        this.W = builder.W;
        this.X = builder.X;
        this.Y = builder.Y;
        this.Z = builder.Z;
        this.a0 = builder.a0;
        this.b0 = builder.b0;
        this.d0 = builder.c0;
        this.e0 = builder.e0;
        this.f0 = builder.f0;
        this.g0 = builder.g0;
        this.h0 = builder.h0;
        this.t0 = builder.i0;
        this.i0 = builder.j0;
        this.v0 = builder.v0;
        this.j0 = builder.l0;
        this.k0 = builder.k0;
        this.l0 = builder.m0;
        this.m0 = builder.n0;
        this.n0 = builder.o0;
        this.o0 = builder.p0;
        this.p0 = builder.q0;
        this.q0 = builder.r0;
        this.r0 = builder.s0;
        this.s0 = builder.t0;
        this.u0 = builder.u0;
        this.w0 = builder.w0;
        this.x0 = builder.x0;
        this.y0 = builder.y0;
        this.z0 = builder.z0;
        this.B0 = builder.A0;
        this.C0 = builder.B0;
        this.D0 = builder.C0;
        this.E0 = builder.D0;
        this.F0 = builder.E0;
        this.A0 = builder.F0;
        this.G0 = builder.G0;
        this.H0 = builder.H0;
        this.I0 = builder.I0;
        this.J0 = builder.J0;
        this.K0 = builder.K0;
        this.L0 = builder.L0;
        this.M0 = builder.M0;
        this.N0 = builder.N0;
        this.O0 = builder.O0;
        this.P0 = builder.P0;
        this.Q0 = builder.Q0;
        this.R0 = builder.R0;
        this.S0 = builder.S0;
        this.T0 = builder.T0;
        this.U0 = builder.U0;
        this.a = builder.a;
        this.c0 = builder.d0;
    }

    public static class Builder {
        private int F0;
        private java.lang.String G0;
        private java.lang.String H0;
        private java.lang.String I0;
        private java.lang.String J0;
        private int K0;
        private int L0;
        private int M0;
        private int N0;
        private java.lang.String U0;
        private java.lang.String W;
        private boolean X;
        private com.cmic.gen.sdk.view.GenBackPressedListener Y;
        private com.cmic.gen.sdk.view.GenLoginClickListener Z;
        public boolean a;
        private com.cmic.gen.sdk.view.GenCheckBoxListener a0;
        private com.cmic.gen.sdk.view.GenCheckedChangeListener b0;
        private com.cmic.gen.sdk.view.ClauseClickListener c0;
        private com.cmic.gen.sdk.view.GenAuthLoginListener d0;
        private java.lang.String g;
        private boolean h;
        private boolean l;
        private android.widget.ImageView.ScaleType w;
        private int b = 0;
        private boolean c = false;
        private android.view.View d = null;
        private int e = -1;
        private int f = -1;
        private int i = 17;
        private int j = -1;
        private int k = -16742704;
        private int m = -16742704;
        private java.lang.String n = "return_bg";
        private int o = -2;
        private int p = -2;
        private android.widget.ImageView.ScaleType q = android.widget.ImageView.ScaleType.CENTER;
        private int r = 58;
        private int s = 20;
        private int t = -1;
        private int u = -1;
        private int v = -1;
        private boolean x = true;
        private int y = 18;
        private boolean z = false;
        private int A = -16742704;
        private int B = 0;
        private int C = 184;
        private int D = 0;
        private int E = 12;
        private boolean F = false;
        private int G = -16742704;
        private int H = -1;
        private int I = -1;
        private int J = -1;
        private java.lang.String K = "本机号码一键登录";
        private boolean L = true;
        private int M = 15;
        private boolean N = false;
        private int O = -1;
        private java.lang.String P = "umcsdk_login_btn_bg";
        private int Q = -1;
        private int R = 36;
        private int S = 46;
        private int T = 46;
        private int U = 254;
        private int V = 0;
        private java.lang.String e0 = "umcsdk_check_image";
        private java.lang.String f0 = "umcsdk_uncheck_image";
        private int g0 = 9;
        private int h0 = 9;
        private boolean i0 = false;
        private boolean j0 = false;
        private boolean k0 = true;
        private java.lang.String l0 = "登录即同意$$运营商条款$$并使用本机号码登录";
        private java.lang.String m0 = null;
        private java.lang.String n0 = null;
        private java.lang.String o0 = null;
        private java.lang.String p0 = null;
        private java.lang.String q0 = null;
        private java.lang.String r0 = null;
        private java.lang.String s0 = null;
        private java.lang.String t0 = null;
        private int u0 = 10;
        private boolean v0 = false;
        private boolean w0 = false;
        private int x0 = -10066330;
        private int y0 = -16007674;
        private boolean z0 = false;
        private int A0 = 52;
        private int B0 = 52;
        private int C0 = 0;
        private int D0 = 30;
        private boolean E0 = true;
        private int O0 = 0;
        private int P0 = -1;
        private int Q0 = android.R.style.Theme.Translucent.NoTitleBar;
        private int R0 = 0;
        private boolean S0 = true;
        private boolean T0 = true;

        public com.cmic.gen.sdk.view.GenAuthThemeConfig build() {
            return new com.cmic.gen.sdk.view.GenAuthThemeConfig(this);
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder displayLogo(boolean z) {
            this.x = z;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setAppLanguageType(int i) {
            this.R0 = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setAuthContentView(android.view.View view) {
            this.d = view;
            this.e = -1;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setAuthLayoutResID(int i) {
            this.e = i;
            this.d = null;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setAuthPageActIn(java.lang.String str, java.lang.String str2) {
            this.G0 = str;
            this.H0 = str2;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setAuthPageActOut(java.lang.String str, java.lang.String str2) {
            this.I0 = str2;
            this.J0 = str;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setAuthPageWindowMode(int i, int i2) {
            this.K0 = i;
            this.L0 = i2;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setAuthPageWindowOffset(int i, int i2) {
            this.M0 = i;
            this.N0 = i2;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setBackButton(boolean z) {
            this.T0 = z;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setCheckBoxAccurateClick(boolean z) {
            this.i0 = z;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setCheckBoxImgPath(java.lang.String str, java.lang.String str2, int i, int i2) {
            this.e0 = str;
            this.f0 = str2;
            this.g0 = i;
            this.h0 = i2;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setCheckBoxLocation(int i) {
            this.F0 = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setCheckTipText(java.lang.String str) {
            boolean z = android.text.TextUtils.isEmpty(str) || str.length() > 100;
            this.X = z;
            if (z) {
                str = "请勾选同意服务条款";
            }
            this.W = str;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setCheckedImgPath(java.lang.String str) {
            this.e0 = str;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setClauseClickListener(com.cmic.gen.sdk.view.ClauseClickListener clauseClickListener) {
            this.c0 = clauseClickListener;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setClauseColor(int i, int i2) {
            this.x0 = i;
            this.y0 = i2;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setClauseLayoutResID(int i, java.lang.String str) {
            this.f = i;
            this.g = str;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setClauseStatusColor(int i) {
            this.m = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setClauseTheme(int i) {
            this.Q0 = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setFitsSystemWindows(boolean z) {
            this.S0 = z;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setGenAuthLoginListener(com.cmic.gen.sdk.view.GenAuthLoginListener genAuthLoginListener) {
            this.d0 = genAuthLoginListener;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setGenBackPressedListener(com.cmic.gen.sdk.view.GenBackPressedListener genBackPressedListener) {
            this.Y = genBackPressedListener;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setGenCheckBoxListener(com.cmic.gen.sdk.view.GenCheckBoxListener genCheckBoxListener) {
            this.a0 = genCheckBoxListener;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setGenCheckedChangeListener(com.cmic.gen.sdk.view.GenCheckedChangeListener genCheckedChangeListener) {
            this.b0 = genCheckedChangeListener;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setLogBtn(int i, int i2) {
            this.Q = i;
            this.R = i2;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setLogBtnClickListener(com.cmic.gen.sdk.view.GenLoginClickListener genLoginClickListener) {
            this.Z = genLoginClickListener;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setLogBtnImgPath(java.lang.String str) {
            this.P = str;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setLogBtnMargin(int i, int i2) {
            this.S = i;
            this.T = i2;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setLogBtnOffsetY(int i) {
            this.U = i;
            this.V = 0;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setLogBtnOffsetY_B(int i) {
            this.V = i;
            this.U = 0;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setLogBtnText(java.lang.String str) {
            if (!android.text.TextUtils.isEmpty(str) && !java.util.regex.Pattern.compile("^\\s*\\n*$").matcher(str).matches()) {
                this.K = str;
                this.L = false;
            }
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setLogBtnTextColor(int i) {
            this.O = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setLogo(int i, int i2) {
            this.r = i;
            this.s = i2;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setLogoOffsetX(int i) {
            this.t = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setLogoOffsetY(int i) {
            this.u = i;
            this.v = -1;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setLogoOffsetY_B(int i) {
            this.v = i;
            this.u = -1;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setLogoScaleType(android.widget.ImageView.ScaleType scaleType) {
            this.w = scaleType;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setNavColor(int i) {
            this.k = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setNavHidden(boolean z) {
            this.l = z;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setNavTextColor(int i) {
            this.j = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setNavTextGetWebViewTittle(boolean z) {
            this.h = z;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setNavTextSize(int i) {
            this.i = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setNumFieldOffsetY(int i) {
            this.C = i;
            this.D = 0;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setNumFieldOffsetY_B(int i) {
            this.D = i;
            this.C = 0;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setNumberColor(int i) {
            this.A = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setNumberOffsetX(int i) {
            this.B = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setNumberSize(int i, boolean z) {
            if (i > 8) {
                this.y = i;
                this.z = z;
            }
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setPrivacyAlignment(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9) {
            if (str.contains(com.cmic.gen.sdk.view.GenAuthThemeConfig.PLACEHOLDER)) {
                this.k0 = false;
                this.l0 = str;
                this.m0 = str2;
                this.n0 = str3;
                this.o0 = str4;
                this.p0 = str5;
                this.q0 = str6;
                this.r0 = str7;
                this.s0 = str8;
                this.t0 = str9;
            }
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setPrivacyAnimation(java.lang.String str) {
            this.U0 = str;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setPrivacyBookSymbol(boolean z) {
            this.E0 = z;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setPrivacyMargin(int i, int i2) {
            this.A0 = i;
            this.B0 = i2;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setPrivacyOffsetY(int i) {
            this.C0 = i;
            this.D0 = 0;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setPrivacyOffsetY_B(int i) {
            this.D0 = i;
            this.C0 = 0;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setPrivacyPageFullScreen(boolean z) {
            this.v0 = z;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setPrivacyState(boolean z) {
            this.j0 = z;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setPrivacyText(int i, int i2, int i3, boolean z, boolean z2) {
            this.u0 = i;
            this.x0 = i2;
            this.y0 = i3;
            this.z0 = z;
            this.w0 = z2;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setProvideTextColor(int i) {
            this.G = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setProvideTextOffsetX(int i) {
            this.H = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setProvideTextOffsetY(int i) {
            this.I = i;
            this.J = -1;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setProvideTextOffsetY_B(int i) {
            this.J = i;
            this.I = -1;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setProvideTextSize(int i, boolean z) {
            if (i > 3) {
                this.E = i;
            }
            this.F = z;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setStatusBar(int i, boolean z) {
            this.b = i;
            this.c = z;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setThemeId(int i) {
            this.P0 = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setUncheckedImgPath(java.lang.String str) {
            this.f0 = str;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setWebDomStorage(boolean z) {
            this.a = z;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setWindowBottom(int i) {
            this.O0 = i;
            return this;
        }

        public com.cmic.gen.sdk.view.GenAuthThemeConfig.Builder setLogBtnText(java.lang.String str, int i, int i2, boolean z) {
            if (!android.text.TextUtils.isEmpty(str) && !java.util.regex.Pattern.compile("^\\s*\\n*$").matcher(str).matches()) {
                this.K = str;
                this.L = false;
            }
            this.O = i;
            this.M = i2;
            this.N = z;
            return this;
        }
    }
}
