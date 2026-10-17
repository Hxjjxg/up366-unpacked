package com.cmic.gen.sdk;

/* JADX INFO: compiled from: UmcActivityUtil.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class r1 {

    /* JADX INFO: compiled from: UmcActivityUtil.java */
    class a extends android.text.style.ClickableSpan {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.cmic.gen.sdk.view.GenAuthThemeConfig b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ com.cmic.gen.sdk.g1 e;

        a(android.content.Context context, com.cmic.gen.sdk.view.GenAuthThemeConfig genAuthThemeConfig, java.lang.String str, java.lang.String str2, com.cmic.gen.sdk.g1 g1Var) {
            this.a = context;
            this.b = genAuthThemeConfig;
            this.c = str;
            this.d = str2;
            this.e = g1Var;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(android.view.View view) {
            com.cmic.gen.sdk.r1.b(this.b, this.c, this.d);
            com.cmic.gen.sdk.g1 g1Var = this.e;
            if (g1Var == null || g1Var.isShowing()) {
                return;
            }
            this.e.show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(android.text.TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            try {
                textPaint.setColor(com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(this.a).getAuthThemeConfig().getClauseColor());
            } catch (java.lang.Exception unused) {
                textPaint.setColor(-16007674);
            }
        }
    }

    /* JADX INFO: compiled from: UmcActivityUtil.java */
    class b extends android.text.style.ClickableSpan {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.cmic.gen.sdk.view.GenAuthThemeConfig b;
        final /* synthetic */ java.util.ArrayList c;
        final /* synthetic */ java.util.ArrayList d;

        b(android.content.Context context, com.cmic.gen.sdk.view.GenAuthThemeConfig genAuthThemeConfig, java.util.ArrayList arrayList, java.util.ArrayList arrayList2) {
            this.a = context;
            this.b = genAuthThemeConfig;
            this.c = arrayList;
            this.d = arrayList2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(android.view.View view) {
            com.cmic.gen.sdk.r1.b(this.b, (java.lang.String) this.c.get(0), this.b.getClauseUrl());
            if (this.d.get(0) == null || ((com.cmic.gen.sdk.g1) this.d.get(0)).isShowing()) {
                return;
            }
            ((com.cmic.gen.sdk.g1) this.d.get(0)).show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(android.text.TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            try {
                textPaint.setColor(com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(this.a).getAuthThemeConfig().getClauseColor());
            } catch (java.lang.Exception unused) {
                textPaint.setColor(-16007674);
            }
        }
    }

    /* JADX INFO: compiled from: UmcActivityUtil.java */
    class c extends android.text.style.ClickableSpan {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.cmic.gen.sdk.view.GenAuthThemeConfig b;
        final /* synthetic */ java.util.ArrayList c;
        final /* synthetic */ java.util.ArrayList d;

        c(android.content.Context context, com.cmic.gen.sdk.view.GenAuthThemeConfig genAuthThemeConfig, java.util.ArrayList arrayList, java.util.ArrayList arrayList2) {
            this.a = context;
            this.b = genAuthThemeConfig;
            this.c = arrayList;
            this.d = arrayList2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(android.view.View view) {
            com.cmic.gen.sdk.r1.b(this.b, (java.lang.String) this.c.get(1), this.b.getClauseUrl2());
            if (this.d.get(1) == null || ((com.cmic.gen.sdk.g1) this.d.get(1)).isShowing()) {
                return;
            }
            ((com.cmic.gen.sdk.g1) this.d.get(1)).show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(android.text.TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            try {
                textPaint.setColor(com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(this.a).getAuthThemeConfig().getClauseColor());
            } catch (java.lang.Exception unused) {
                textPaint.setColor(-16007674);
            }
        }
    }

    /* JADX INFO: compiled from: UmcActivityUtil.java */
    class d extends android.text.style.ClickableSpan {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.cmic.gen.sdk.view.GenAuthThemeConfig b;
        final /* synthetic */ java.util.ArrayList c;
        final /* synthetic */ java.util.ArrayList d;

        d(android.content.Context context, com.cmic.gen.sdk.view.GenAuthThemeConfig genAuthThemeConfig, java.util.ArrayList arrayList, java.util.ArrayList arrayList2) {
            this.a = context;
            this.b = genAuthThemeConfig;
            this.c = arrayList;
            this.d = arrayList2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(android.view.View view) {
            com.cmic.gen.sdk.r1.b(this.b, (java.lang.String) this.c.get(2), this.b.getClauseUrl3());
            if (this.d.get(2) == null || ((com.cmic.gen.sdk.g1) this.d.get(2)).isShowing()) {
                return;
            }
            ((com.cmic.gen.sdk.g1) this.d.get(2)).show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(android.text.TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            try {
                textPaint.setColor(com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(this.a).getAuthThemeConfig().getClauseColor());
            } catch (java.lang.Exception unused) {
                textPaint.setColor(-16007674);
            }
        }
    }

    /* JADX INFO: compiled from: UmcActivityUtil.java */
    class e extends android.text.style.ClickableSpan {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.cmic.gen.sdk.view.GenAuthThemeConfig b;
        final /* synthetic */ java.util.ArrayList c;
        final /* synthetic */ java.util.ArrayList d;

        e(android.content.Context context, com.cmic.gen.sdk.view.GenAuthThemeConfig genAuthThemeConfig, java.util.ArrayList arrayList, java.util.ArrayList arrayList2) {
            this.a = context;
            this.b = genAuthThemeConfig;
            this.c = arrayList;
            this.d = arrayList2;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(android.view.View view) {
            com.cmic.gen.sdk.r1.b(this.b, (java.lang.String) this.c.get(3), this.b.getClauseUrl4());
            if (this.d.get(3) == null || ((com.cmic.gen.sdk.g1) this.d.get(3)).isShowing()) {
                return;
            }
            ((com.cmic.gen.sdk.g1) this.d.get(3)).show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(android.text.TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            try {
                textPaint.setColor(com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(this.a).getAuthThemeConfig().getClauseColor());
            } catch (java.lang.Exception unused) {
                textPaint.setColor(-16007674);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.cmic.gen.sdk.view.GenAuthThemeConfig genAuthThemeConfig, java.lang.String str, java.lang.String str2) {
        if (genAuthThemeConfig.getClauseClickListener() != null) {
            genAuthThemeConfig.getClauseClickListener().onClauseClick(str, str2);
        }
    }

    public static android.text.SpannableString a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.cmic.gen.sdk.g1 g1Var, java.util.ArrayList<com.cmic.gen.sdk.g1> arrayList, java.util.ArrayList<java.lang.String> arrayList2) {
        int iIndexOf;
        com.cmic.gen.sdk.h0.a("getClauseSpannableString", str);
        android.text.SpannableString spannableString = new android.text.SpannableString(str);
        try {
            com.cmic.gen.sdk.view.GenAuthThemeConfig authThemeConfig = com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(context).getAuthThemeConfig();
            com.cmic.gen.sdk.r1.a aVar = new com.cmic.gen.sdk.r1.a(context, authThemeConfig, str2, str3, g1Var);
            com.cmic.gen.sdk.r1.b bVar = arrayList.size() >= 1 ? new com.cmic.gen.sdk.r1.b(context, authThemeConfig, arrayList2, arrayList) : null;
            com.cmic.gen.sdk.r1.c cVar = arrayList.size() >= 2 ? new com.cmic.gen.sdk.r1.c(context, authThemeConfig, arrayList2, arrayList) : null;
            com.cmic.gen.sdk.r1.d dVar = arrayList.size() >= 3 ? new com.cmic.gen.sdk.r1.d(context, authThemeConfig, arrayList2, arrayList) : null;
            com.cmic.gen.sdk.r1.e eVar = arrayList.size() == 4 ? new com.cmic.gen.sdk.r1.e(context, authThemeConfig, arrayList2, arrayList) : null;
            com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(context).getAuthThemeConfig();
            int iIndexOf2 = str.indexOf(str2);
            spannableString.setSpan(aVar, iIndexOf2, str2.length() + iIndexOf2, 34);
            if (arrayList.size() >= 1) {
                java.lang.String str4 = arrayList2.get(0);
                iIndexOf = str.indexOf(str4);
                spannableString.setSpan(bVar, iIndexOf, str4.length() + iIndexOf, 34);
            } else {
                iIndexOf = 0;
            }
            if (arrayList.size() >= 2) {
                int length = iIndexOf + arrayList2.get(0).length();
                java.lang.String str5 = arrayList2.get(1);
                iIndexOf = str.indexOf(str5, length);
                spannableString.setSpan(cVar, iIndexOf, str5.length() + iIndexOf, 34);
            }
            if (arrayList.size() >= 3) {
                int length2 = arrayList2.get(1).length() + iIndexOf;
                java.lang.String str6 = arrayList2.get(2);
                int iIndexOf3 = str.indexOf(str6, length2);
                spannableString.setSpan(dVar, iIndexOf3, str6.length() + iIndexOf3, 34);
            }
            if (arrayList.size() == 4) {
                int length3 = iIndexOf + arrayList2.get(2).length();
                java.lang.String str7 = arrayList2.get(3);
                int iIndexOf4 = str.indexOf(str7, length3);
                spannableString.setSpan(eVar, iIndexOf4, str7.length() + iIndexOf4, 34);
            }
            return spannableString;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return spannableString;
        }
    }

    public static int b(android.content.Context context) {
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static android.widget.RelativeLayout a(android.content.Context context, android.view.View view, int i, int i2, java.lang.String str, android.view.View.OnClickListener onClickListener) {
        com.cmic.gen.sdk.view.GenAuthThemeConfig authThemeConfig = com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(context).getAuthThemeConfig();
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(context);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, view != null ? -2 : a(context, 49.0f));
        layoutParams.addRule(10, -1);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setId(i);
        android.widget.TextView textView = new android.widget.TextView(context);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        textView.setLayoutParams(layoutParams2);
        textView.setTextColor(authThemeConfig.getNavTextColor());
        textView.setTextSize(2, authThemeConfig.getNavTextSize());
        textView.setText(str);
        textView.setId(3355443);
        if (view != null) {
            relativeLayout.addView(view);
            if (view instanceof android.view.ViewGroup) {
                ((android.view.ViewGroup) view).addView(textView);
            } else {
                relativeLayout.addView(textView);
            }
            return relativeLayout;
        }
        relativeLayout.addView(textView);
        android.widget.ImageButton imageButton = new android.widget.ImageButton(context);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(a(context, authThemeConfig.getNavReturnImgWidth()), a(context, authThemeConfig.getNavReturnImgHeight()));
        layoutParams3.addRule(9, -1);
        layoutParams3.addRule(15, -1);
        layoutParams3.setMargins(a(context, 12.0f), 0, 0, 0);
        imageButton.setLayoutParams(layoutParams3);
        imageButton.setId(i2);
        imageButton.setOnClickListener(onClickListener);
        imageButton.setBackgroundColor(0);
        relativeLayout.addView(imageButton);
        try {
            relativeLayout.setBackgroundColor(com.cmic.gen.sdk.auth.GenAuthnHelper.getInstance(context).getAuthThemeConfig().getNavColor());
        } catch (java.lang.Exception unused) {
            relativeLayout.setBackgroundColor(-16742704);
        }
        imageButton.setImageResource(com.cmic.gen.sdk.z0.b(context, "umcsdk_return_bg"));
        return relativeLayout;
    }

    public static int a(android.content.Context context, float f) {
        if (f < 0.0f) {
            return (int) f;
        }
        try {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (java.lang.Exception unused) {
            return (int) f;
        }
    }

    public static int a(android.content.Context context) {
        android.view.WindowManager windowManager = (android.view.WindowManager) context.getSystemService("window");
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }
}
