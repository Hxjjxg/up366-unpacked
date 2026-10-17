package com.chuanglan.shanyan_sdk;

/* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class AbstractC0063t {

    /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.t$a */
    class a implements android.view.View.OnClickListener {
        final /* synthetic */ int a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig e;
        final /* synthetic */ android.content.Context f;

        a(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig, android.content.Context context) {
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = shanYanUIConfig;
            this.f = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            try {
                com.chuanglan.shanyan_sdk.listener.OnClickPrivacyListener onClickPrivacyListener = com.chuanglan.shanyan_sdk.AbstractC0055l.Q;
                if (onClickPrivacyListener != null) {
                    onClickPrivacyListener.getOnClickPrivacyStatus(this.a, "" + this.b, this.c);
                }
                com.chuanglan.shanyan_sdk.listener.AuthPageActionListener authPageActionListener = com.chuanglan.shanyan_sdk.AbstractC0055l.S;
                if (authPageActionListener != null) {
                    authPageActionListener.setAuthPageActionListener(1, this.a, this.b + "|" + this.c);
                }
                com.chuanglan.shanyan_sdk.listener.PricacyOnClickListener pricacyOnClickListener = com.chuanglan.shanyan_sdk.AbstractC0055l.R;
                if (pricacyOnClickListener != null) {
                    pricacyOnClickListener.onClick(this.d, this.b);
                }
                if (this.e.isPrivacyActivityEnabled()) {
                    com.chuanglan.shanyan_sdk.AbstractC0044a.a(this.f, this.d, this.b);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "clickableSpan1 Exception_e=", e);
            }
        }
    }

    /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.t$b */
    static class b extends android.text.method.LinkMovementMethod {
        private static com.chuanglan.shanyan_sdk.AbstractC0063t.b a;

        b() {
        }

        public static android.text.method.MovementMethod getInstance() {
            if (a == null) {
                a = new com.chuanglan.shanyan_sdk.AbstractC0063t.b();
            }
            return a;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(android.widget.TextView textView, android.text.Spannable spannable, android.view.MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1) {
                return super.onTouchEvent(textView, spannable, motionEvent);
            }
            try {
                float x = motionEvent.getX();
                float totalPaddingLeft = (x - textView.getTotalPaddingLeft()) + textView.getScrollX();
                float y = (motionEvent.getY() - textView.getTotalPaddingTop()) + textView.getScrollY();
                android.text.Layout layout = textView.getLayout();
                if (layout == null) {
                    return super.onTouchEvent(textView, spannable, motionEvent);
                }
                int lineForVertical = layout.getLineForVertical((int) y);
                if (lineForVertical >= 0 && lineForVertical < layout.getLineCount()) {
                    int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, totalPaddingLeft);
                    android.text.style.ClickableSpan[] clickableSpanArr = (android.text.style.ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, android.text.style.ClickableSpan.class);
                    if (clickableSpanArr.length == 0) {
                        return false;
                    }
                    android.text.style.ClickableSpan clickableSpan = clickableSpanArr[0];
                    int spanStart = spannable.getSpanStart(clickableSpan);
                    int spanEnd = spannable.getSpanEnd(clickableSpan);
                    int lineForOffset = layout.getLineForOffset(spanStart);
                    int lineForOffset2 = layout.getLineForOffset(spanEnd);
                    if (lineForVertical >= lineForOffset && lineForVertical <= lineForOffset2) {
                        float primaryHorizontal = lineForVertical == lineForOffset ? layout.getPrimaryHorizontal(spanStart) : layout.getLineLeft(lineForVertical);
                        float primaryHorizontal2 = lineForVertical == lineForOffset2 ? layout.getPrimaryHorizontal(spanEnd) : layout.getLineRight(lineForVertical);
                        if (primaryHorizontal > primaryHorizontal2) {
                            float f = primaryHorizontal;
                            primaryHorizontal = primaryHorizontal2;
                            primaryHorizontal2 = f;
                        }
                        if (totalPaddingLeft >= primaryHorizontal && totalPaddingLeft <= primaryHorizontal2) {
                            clickableSpan.onClick(textView);
                            return true;
                        }
                    }
                    return false;
                }
                return super.onTouchEvent(textView, spannable, motionEvent);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return super.onTouchEvent(textView, spannable, motionEvent);
            }
        }
    }

    /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.t$c */
    static class c extends android.text.style.ClickableSpan {
        private final boolean a;
        private final android.view.View.OnClickListener b;

        public c(boolean z, android.view.View.OnClickListener onClickListener) {
            this.a = z;
            this.b = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(android.view.View view) {
            this.b.onClick(view);
            if (view instanceof android.widget.TextView) {
                ((android.widget.TextView) view).setHighlightColor(0);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(android.text.TextPaint textPaint) {
            super.updateDrawState(textPaint);
            try {
                if (this.a) {
                    textPaint.setUnderlineText(true);
                } else {
                    textPaint.setUnderlineText(false);
                }
                textPaint.setColor(0);
                textPaint.clearShadowLayer();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig, android.content.Context context, android.widget.TextView textView, android.view.View view, java.lang.String str) {
        android.text.SpannableStringBuilder spannableStringBuilder;
        java.lang.String name;
        android.text.SpannableStringBuilder spannableStringBuilder2 = null;
        try {
            try {
                int clauseColor = shanYanUIConfig.getClauseColor();
                int clauseBaseColor = shanYanUIConfig.getClauseBaseColor();
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.List<com.chuanglan.shanyan_sdk.tool.ConfigPrivacyBean> morePrivacy = shanYanUIConfig.getMorePrivacy();
                if (shanYanUIConfig.isOperatorPrivacyAtLast()) {
                    if (morePrivacy != null) {
                        arrayList.addAll(morePrivacy);
                    }
                    arrayList.add(new com.chuanglan.shanyan_sdk.tool.ConfigPrivacyBean(com.chuanglan.shanyan_sdk.AbstractC0055l.n, com.chuanglan.shanyan_sdk.AbstractC0055l.o, clauseColor));
                } else {
                    arrayList.add(new com.chuanglan.shanyan_sdk.tool.ConfigPrivacyBean(com.chuanglan.shanyan_sdk.AbstractC0055l.n, com.chuanglan.shanyan_sdk.AbstractC0055l.o, clauseColor));
                    if (morePrivacy != null) {
                        arrayList.addAll(morePrivacy);
                    }
                    ((com.chuanglan.shanyan_sdk.tool.ConfigPrivacyBean) arrayList.get(0)).setMidStr(shanYanUIConfig.getPrivacyTextMidOne());
                }
                spannableStringBuilder = new android.text.SpannableStringBuilder(a(shanYanUIConfig, arrayList).toString());
                int i = 0;
                while (i < arrayList.size()) {
                    try {
                        if (shanYanUIConfig.isPrivacySmhHidden()) {
                            name = ((com.chuanglan.shanyan_sdk.tool.ConfigPrivacyBean) arrayList.get(i)).getName();
                        } else {
                            name = "《" + ((com.chuanglan.shanyan_sdk.tool.ConfigPrivacyBean) arrayList.get(i)).getName() + "》";
                        }
                        java.lang.String str2 = name;
                        int color = ((com.chuanglan.shanyan_sdk.tool.ConfigPrivacyBean) arrayList.get(i)).getColor();
                        java.lang.String url = ((com.chuanglan.shanyan_sdk.tool.ConfigPrivacyBean) arrayList.get(i)).getUrl();
                        a(spannableStringBuilder, str2, color == 0 ? clauseColor : color, shanYanUIConfig.isPrivacyNameUnderline(), new com.chuanglan.shanyan_sdk.AbstractC0063t.a(i, (shanYanUIConfig.getPrivacyTitleArray() == null || shanYanUIConfig.getPrivacyTitleArray().length <= i) ? ((com.chuanglan.shanyan_sdk.tool.ConfigPrivacyBean) arrayList.get(i)).getTitle() : shanYanUIConfig.getPrivacyTitleArray()[i], str, url, shanYanUIConfig, context));
                        i++;
                        clauseColor = clauseColor;
                        arrayList = arrayList;
                    } catch (java.lang.Exception e) {
                        e = e;
                        spannableStringBuilder2 = spannableStringBuilder;
                        e.printStackTrace();
                        if (spannableStringBuilder2 != null) {
                            spannableStringBuilder2.clear();
                            spannableStringBuilder2.clearSpans();
                            return;
                        }
                        return;
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (spannableStringBuilder != null) {
                            spannableStringBuilder.clear();
                            spannableStringBuilder.clearSpans();
                        }
                        throw th;
                    }
                }
                a(context, view, shanYanUIConfig);
                textView.setMovementMethod(com.chuanglan.shanyan_sdk.AbstractC0063t.b.getInstance());
                textView.setTextColor(clauseBaseColor);
                textView.setHighlightColor(0);
                if (shanYanUIConfig.isPrivacyOffsetGravityLeft()) {
                    textView.setGravity(3);
                } else {
                    textView.setGravity(17);
                }
                textView.setText(spannableStringBuilder);
                spannableStringBuilder.clear();
                spannableStringBuilder.clearSpans();
            } catch (java.lang.Throwable th2) {
                th = th2;
                spannableStringBuilder = null;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    private static java.lang.StringBuilder a(com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig, java.util.List list) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(shanYanUIConfig.getPrivacyTextHead());
        for (int i = 0; i < list.size(); i++) {
            sb.append(shanYanUIConfig.isPrivacySmhHidden() ? ((com.chuanglan.shanyan_sdk.tool.ConfigPrivacyBean) list.get(i)).getName() : "《" + ((com.chuanglan.shanyan_sdk.tool.ConfigPrivacyBean) list.get(i)).getName() + "》");
            if (i < list.size() - 1) {
                sb.append(((com.chuanglan.shanyan_sdk.tool.ConfigPrivacyBean) list.get(i)).getMidStr());
            }
        }
        sb.append(shanYanUIConfig.getPrivacyTextEnd());
        return sb;
    }

    private static void a(android.content.Context context, android.view.View view, com.chuanglan.shanyan_sdk.tool.ShanYanUIConfig shanYanUIConfig) {
        int privacyOffsetY = shanYanUIConfig.getPrivacyOffsetY();
        int privacyOffsetBottomY = shanYanUIConfig.getPrivacyOffsetBottomY();
        int privacyOffsetX = shanYanUIConfig.getPrivacyOffsetX();
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = new android.view.ViewGroup.MarginLayoutParams(layoutParams);
        int iA = a(context, privacyOffsetY);
        int iA2 = a(context, privacyOffsetBottomY);
        float f = privacyOffsetX;
        int iA3 = a(context, f);
        double d = privacyOffsetX;
        if (d == -1.0d && privacyOffsetY == -1.0d) {
            marginLayoutParams.setMargins(0, 0, 0, iA2);
        } else if (d != -1.0d && privacyOffsetY == -1.0d) {
            marginLayoutParams.setMargins(iA3, 0, 0, iA2);
        } else if (d == -1.0d && privacyOffsetY != -1.0d) {
            marginLayoutParams.setMargins(0, iA, 0, 0);
        } else if (d != -1.0d && privacyOffsetY != -1.0d) {
            marginLayoutParams.setMargins(iA3, iA, 0, 0);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(marginLayoutParams);
        if (d == -1.0d && privacyOffsetY == -1.0d) {
            layoutParams2.leftMargin = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, 40.0f);
            layoutParams2.rightMargin = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, 60.0f);
            layoutParams2.addRule(12);
            layoutParams2.addRule(14);
        } else if (d != -1.0d && privacyOffsetY == -1.0d) {
            layoutParams2.leftMargin = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, f);
            layoutParams2.rightMargin = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, f);
            layoutParams2.addRule(12);
            if (shanYanUIConfig.isPrivacyGravityHorizontalCenter()) {
                layoutParams2.addRule(14);
            } else {
                layoutParams2.addRule(9);
            }
        } else if (d == -1.0d && privacyOffsetY != -1.0d) {
            layoutParams2.leftMargin = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, 40.0f);
            layoutParams2.rightMargin = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, 60.0f);
            layoutParams2.addRule(10);
            layoutParams2.addRule(14);
        } else if (d != -1.0d && privacyOffsetY != -1.0d) {
            layoutParams2.leftMargin = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, f);
            layoutParams2.rightMargin = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, f);
            layoutParams2.addRule(10);
            if (shanYanUIConfig.isPrivacyGravityHorizontalCenter()) {
                layoutParams2.addRule(14);
            } else {
                layoutParams2.addRule(9);
            }
        }
        if (shanYanUIConfig.getPrivacyWidth() != -1) {
            layoutParams2.width = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, shanYanUIConfig.getPrivacyWidth());
        }
        view.setLayoutParams(layoutParams2);
    }

    private static int a(android.content.Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    static void a(android.text.SpannableStringBuilder spannableStringBuilder, java.lang.String str, int i, boolean z, android.view.View.OnClickListener onClickListener) {
        int iIndexOf;
        if (android.text.TextUtils.isEmpty(spannableStringBuilder) || android.text.TextUtils.isEmpty(str) || (iIndexOf = spannableStringBuilder.toString().indexOf(str)) < 0) {
            return;
        }
        int length = str.length() + iIndexOf;
        spannableStringBuilder.setSpan(new com.chuanglan.shanyan_sdk.AbstractC0063t.c(z, onClickListener), iIndexOf, length, 17);
        spannableStringBuilder.setSpan(new android.text.style.ForegroundColorSpan(i), iIndexOf, length, 17);
    }
}
