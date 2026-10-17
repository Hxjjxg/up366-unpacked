package com.up366.qmui.link;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUILinkify {
    public static final int ALL = 15;
    public static final int EMAIL_ADDRESSES = 2;
    public static final int MAP_ADDRESSES = 8;
    private static final int MAX_NUMBER = 21;
    public static final int PHONE_NUMBERS = 4;
    private static final int PHONE_NUMBER_MINIMUM_DIGITS = 7;
    private static final java.lang.String UrlEndAppendNextChars = "[$]";
    public static final int WEB_URLS = 1;
    public static final java.util.regex.Pattern WECHAT_PHONE = java.util.regex.Pattern.compile("\\+?(\\d{2,8}([- ]?\\d{3,8}){2,6}|\\d{5,20})");
    public static final java.util.regex.Pattern NOT_PHONE = java.util.regex.Pattern.compile("^\\d+(\\.\\d+)+(-\\d+)*$");
    public static final com.up366.qmui.link.QMUILinkify.WebUrlMatcher QMUI_WEB_URL_MATCHER = new com.up366.qmui.link.QMUILinkify.WebUrlMatcher() { // from class: com.up366.qmui.link.QMUILinkify.1
        @Override // com.up366.qmui.link.QMUILinkify.WebUrlMatcher
        public java.util.regex.Pattern getPattern() {
            return com.up366.qmui.link.QMUILinkify.WebUrlPattern.WEB_URL;
        }
    };
    private static com.up366.qmui.link.QMUILinkify.WebUrlMatcher sWebUrlMatcher = new com.up366.qmui.link.QMUILinkify.WebUrlMatcher() { // from class: com.up366.qmui.link.QMUILinkify.2
        @Override // com.up366.qmui.link.QMUILinkify.WebUrlMatcher
        public java.util.regex.Pattern getPattern() {
            return android.util.Patterns.WEB_URL;
        }
    };
    public static final com.up366.qmui.link.QMUILinkify.MatchFilter sUrlMatchFilter = new com.up366.qmui.link.QMUILinkify.MatchFilter() { // from class: com.up366.qmui.link.QMUILinkify.3
        @Override // com.up366.qmui.link.QMUILinkify.MatchFilter
        public final boolean acceptMatch(java.lang.CharSequence charSequence, int i, int i2) {
            for (int i3 = i; i3 < i2; i3++) {
                try {
                    if (charSequence.charAt(i3) > 256) {
                        return false;
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            try {
                char cCharAt = charSequence.charAt(i2);
                if (cCharAt < 256 && com.up366.qmui.link.QMUILinkify.UrlEndAppendNextChars.indexOf(cCharAt) < 0) {
                    if (!java.lang.Character.isWhitespace(cCharAt)) {
                        return false;
                    }
                }
            } catch (java.lang.Exception unused2) {
            }
            if (i == 0) {
                return true;
            }
            return charSequence.charAt(i - 1) != '@';
        }
    };
    public static final com.up366.qmui.link.QMUILinkify.MatchFilter sPhoneNumberMatchFilter = new com.up366.qmui.link.QMUILinkify.MatchFilter() { // from class: com.up366.qmui.link.QMUILinkify.4
        @Override // com.up366.qmui.link.QMUILinkify.MatchFilter
        public final boolean acceptMatch(java.lang.CharSequence charSequence, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                if (java.lang.Character.isDigit(charSequence.charAt(i)) && (i3 = i3 + 1) >= 7) {
                    return true;
                }
                i++;
            }
            return false;
        }
    };
    public static final com.up366.qmui.link.QMUILinkify.TransformFilter sPhoneNumberTransformFilter = new com.up366.qmui.link.QMUILinkify.TransformFilter() { // from class: com.up366.qmui.link.QMUILinkify.5
        @Override // com.up366.qmui.link.QMUILinkify.TransformFilter
        public final java.lang.String transformUrl(java.util.regex.Matcher matcher, java.lang.String str) {
            return android.util.Patterns.digitsAndPlusOnly(matcher);
        }
    };

    public interface MatchFilter {
        boolean acceptMatch(java.lang.CharSequence charSequence, int i, int i2);
    }

    public interface TransformFilter {
        java.lang.String transformUrl(java.util.regex.Matcher matcher, java.lang.String str);
    }

    public interface WebUrlMatcher {
        java.util.regex.Pattern getPattern();
    }

    public static void useQmuiWebUrlMatcher() {
        sWebUrlMatcher = QMUI_WEB_URL_MATCHER;
    }

    public static void setWebUrlMatcher(com.up366.qmui.link.QMUILinkify.WebUrlMatcher webUrlMatcher) {
        sWebUrlMatcher = webUrlMatcher;
    }

    public static boolean addLinks(android.text.Spannable spannable, int i, android.content.res.ColorStateList colorStateList, android.content.res.ColorStateList colorStateList2, com.up366.qmui.span.QMUIOnSpanClickListener qMUIOnSpanClickListener) {
        if (i == 0) {
            return false;
        }
        android.text.style.URLSpan[] uRLSpanArr = (android.text.style.URLSpan[]) spannable.getSpans(0, spannable.length(), android.text.style.URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        java.util.ArrayList<com.up366.qmui.link.QMUILinkify.LinkSpec> arrayList = new java.util.ArrayList();
        if ((i & 1) != 0) {
            gatherLinks(arrayList, spannable, sWebUrlMatcher.getPattern(), new java.lang.String[]{com.up366.mobile.cloud.PrivateCloudMgr.HTTP, "https://", "rtsp://"}, sUrlMatchFilter, null);
        }
        if ((i & 2) != 0) {
            gatherLinks(arrayList, spannable, android.util.Patterns.EMAIL_ADDRESS, new java.lang.String[]{"mailto:"}, null, null);
        }
        if ((i & 4) != 0) {
            gatherPhoneLinks(arrayList, spannable, WECHAT_PHONE, new java.util.regex.Pattern[]{NOT_PHONE}, new java.lang.String[]{"tel:"}, sPhoneNumberMatchFilter, sPhoneNumberTransformFilter);
        }
        if ((i & 8) != 0) {
            gatherMapLinks(arrayList, spannable);
        }
        pruneOverlaps(arrayList);
        if (arrayList.size() == 0) {
            return false;
        }
        for (com.up366.qmui.link.QMUILinkify.LinkSpec linkSpec : arrayList) {
            applyLink(linkSpec.url, linkSpec.start, linkSpec.end, spannable, colorStateList, colorStateList2, qMUIOnSpanClickListener);
        }
        return true;
    }

    public static boolean addLinks(android.widget.TextView textView, int i, android.content.res.ColorStateList colorStateList, android.content.res.ColorStateList colorStateList2, com.up366.qmui.span.QMUIOnSpanClickListener qMUIOnSpanClickListener) {
        if (i == 0) {
            return false;
        }
        java.lang.CharSequence text = textView.getText();
        if (text instanceof android.text.Spannable) {
            if (!addLinks((android.text.Spannable) text, i, colorStateList, colorStateList2, qMUIOnSpanClickListener)) {
                return false;
            }
            addLinkMovementMethod(textView);
            return true;
        }
        android.text.SpannableString spannableStringValueOf = android.text.SpannableString.valueOf(text);
        if (!addLinks(spannableStringValueOf, i, colorStateList, colorStateList2, qMUIOnSpanClickListener)) {
            return false;
        }
        addLinkMovementMethod(textView);
        textView.setText(spannableStringValueOf);
        return true;
    }

    private static void addLinkMovementMethod(android.widget.TextView textView) {
        android.text.method.MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || !(movementMethod instanceof android.text.method.LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        }
    }

    public static void addLinks(android.widget.TextView textView, java.util.regex.Pattern pattern, java.lang.String str) {
        addLinks(textView, pattern, str, (com.up366.qmui.link.QMUILinkify.MatchFilter) null, (com.up366.qmui.link.QMUILinkify.TransformFilter) null);
    }

    public static void addLinks(android.widget.TextView textView, java.util.regex.Pattern pattern, java.lang.String str, com.up366.qmui.link.QMUILinkify.MatchFilter matchFilter, com.up366.qmui.link.QMUILinkify.TransformFilter transformFilter) {
        android.text.SpannableString spannableStringValueOf = android.text.SpannableString.valueOf(textView.getText());
        if (addLinks(spannableStringValueOf, pattern, str, matchFilter, transformFilter)) {
            textView.setText(spannableStringValueOf);
            addLinkMovementMethod(textView);
        }
    }

    public static boolean addLinks(android.text.Spannable spannable, java.util.regex.Pattern pattern, java.lang.String str) {
        return addLinks(spannable, pattern, str, (com.up366.qmui.link.QMUILinkify.MatchFilter) null, (com.up366.qmui.link.QMUILinkify.TransformFilter) null);
    }

    public static boolean addLinks(android.text.Spannable spannable, java.util.regex.Pattern pattern, java.lang.String str, com.up366.qmui.link.QMUILinkify.MatchFilter matchFilter, com.up366.qmui.link.QMUILinkify.TransformFilter transformFilter) {
        java.lang.String lowerCase = str == null ? "" : str.toLowerCase(java.util.Locale.ROOT);
        java.util.regex.Matcher matcher = pattern.matcher(spannable);
        boolean z = false;
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (matchFilter != null ? matchFilter.acceptMatch(spannable, iStart, iEnd) : true) {
                applyLink(makeUrl(matcher.group(0), new java.lang.String[]{lowerCase}, matcher, transformFilter), iStart, iEnd, spannable, null, null, null);
                z = true;
            }
        }
        return z;
    }

    private static void applyLink(java.lang.String str, int i, int i2, android.text.Spannable spannable, final android.content.res.ColorStateList colorStateList, final android.content.res.ColorStateList colorStateList2, com.up366.qmui.span.QMUIOnSpanClickListener qMUIOnSpanClickListener) {
        spannable.setSpan(new com.up366.qmui.link.QMUILinkify.StyleableURLSpan(str, qMUIOnSpanClickListener) { // from class: com.up366.qmui.link.QMUILinkify.6
            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(android.text.TextPaint textPaint) {
                android.content.res.ColorStateList colorStateList3 = colorStateList;
                if (colorStateList3 != null) {
                    int colorForState = colorStateList3.getColorForState(new int[]{android.R.attr.state_enabled, -16842919}, 0);
                    int colorForState2 = colorStateList.getColorForState(new int[]{android.R.attr.state_pressed}, colorForState);
                    if (this.mPressed) {
                        colorForState = colorForState2;
                    }
                    textPaint.linkColor = colorForState;
                }
                android.content.res.ColorStateList colorStateList4 = colorStateList2;
                if (colorStateList4 != null) {
                    int colorForState3 = colorStateList4.getColorForState(new int[]{android.R.attr.state_enabled, -16842919}, 0);
                    int colorForState4 = colorStateList2.getColorForState(new int[]{android.R.attr.state_pressed}, colorForState3);
                    if (this.mPressed) {
                        colorForState3 = colorForState4;
                    }
                    textPaint.bgColor = colorForState3;
                }
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }
        }, i, i2, 33);
    }

    private static abstract class StyleableURLSpan extends android.text.style.URLSpan implements com.up366.qmui.link.ITouchableSpan {
        protected com.up366.qmui.span.QMUIOnSpanClickListener mOnSpanClickListener;
        protected boolean mPressed;
        protected java.lang.String mUrl;

        public StyleableURLSpan(java.lang.String str, com.up366.qmui.span.QMUIOnSpanClickListener qMUIOnSpanClickListener) {
            super(str);
            this.mPressed = false;
            this.mUrl = str;
            this.mOnSpanClickListener = qMUIOnSpanClickListener;
        }

        @Override // com.up366.qmui.link.ITouchableSpan
        public void setPressed(boolean z) {
            this.mPressed = z;
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan, com.up366.qmui.link.ITouchableSpan
        public void onClick(android.view.View view) {
            if (this.mOnSpanClickListener.onSpanClick(this.mUrl)) {
                return;
            }
            super.onClick(view);
        }
    }

    private static java.lang.String makeUrl(java.lang.String str, java.lang.String[] strArr, java.util.regex.Matcher matcher, com.up366.qmui.link.QMUILinkify.TransformFilter transformFilter) {
        boolean z;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            java.lang.String str2 = strArr[i];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                z = true;
                if (!str.regionMatches(false, 0, str2, 0, str2.length())) {
                    str = str2 + str.substring(str2.length());
                }
            } else {
                i++;
            }
        }
        if (z) {
            return str;
        }
        return strArr[0] + str;
    }

    private static void gatherLinks(java.util.ArrayList<com.up366.qmui.link.QMUILinkify.LinkSpec> arrayList, android.text.Spannable spannable, java.util.regex.Pattern pattern, java.lang.String[] strArr, com.up366.qmui.link.QMUILinkify.MatchFilter matchFilter, com.up366.qmui.link.QMUILinkify.TransformFilter transformFilter) {
        java.util.regex.Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, iStart, iEnd)) {
                com.up366.qmui.link.QMUILinkify.LinkSpec linkSpec = new com.up366.qmui.link.QMUILinkify.LinkSpec();
                linkSpec.url = makeUrl(matcher.group(0), strArr, matcher, transformFilter);
                linkSpec.start = iStart;
                linkSpec.end = iEnd;
                arrayList.add(linkSpec);
            }
        }
    }

    private static void gatherPhoneLinks(java.util.ArrayList<com.up366.qmui.link.QMUILinkify.LinkSpec> arrayList, android.text.Spannable spannable, java.util.regex.Pattern pattern, java.util.regex.Pattern[] patternArr, java.lang.String[] strArr, com.up366.qmui.link.QMUILinkify.MatchFilter matchFilter, com.up366.qmui.link.QMUILinkify.TransformFilter transformFilter) {
        java.util.regex.Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            if (!isInExcepts(matcher.group(), patternArr)) {
                int iStart = matcher.start();
                int iEnd = matcher.end();
                if (matchFilter == null || matchFilter.acceptMatch(spannable, iStart, iEnd)) {
                    com.up366.qmui.link.QMUILinkify.LinkSpec linkSpec = new com.up366.qmui.link.QMUILinkify.LinkSpec();
                    linkSpec.url = makeUrl(matcher.group(0), strArr, matcher, transformFilter);
                    linkSpec.start = iStart;
                    linkSpec.end = iEnd;
                    arrayList.add(linkSpec);
                }
            }
        }
    }

    private static boolean isInExcepts(java.lang.CharSequence charSequence, java.util.regex.Pattern[] patternArr) {
        for (java.util.regex.Pattern pattern : patternArr) {
            if (pattern.matcher(charSequence).find()) {
                return true;
            }
        }
        return isTooLarge(charSequence);
    }

    private static boolean isTooLarge(java.lang.CharSequence charSequence) {
        if (charSequence.length() <= 21) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (java.lang.Character.isDigit(charSequence.charAt(i2)) && (i = i + 1) > 21) {
                return true;
            }
        }
        return false;
    }

    private static void gatherMapLinks(java.util.ArrayList<com.up366.qmui.link.QMUILinkify.LinkSpec> arrayList, android.text.Spannable spannable) {
        int iIndexOf;
        java.lang.String string = spannable.toString();
        int i = 0;
        while (true) {
            try {
                java.lang.String strFindAddress = android.webkit.WebView.findAddress(string);
                if (strFindAddress != null && (iIndexOf = string.indexOf(strFindAddress)) >= 0) {
                    com.up366.qmui.link.QMUILinkify.LinkSpec linkSpec = new com.up366.qmui.link.QMUILinkify.LinkSpec();
                    int length = strFindAddress.length() + iIndexOf;
                    linkSpec.start = iIndexOf + i;
                    i += length;
                    linkSpec.end = i;
                    string = string.substring(length);
                    try {
                        linkSpec.url = "geo:0,0?q=" + java.net.URLEncoder.encode(strFindAddress, "UTF-8");
                        arrayList.add(linkSpec);
                    } catch (java.io.UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (java.lang.UnsupportedOperationException unused2) {
                return;
            }
        }
    }

    private static void pruneOverlaps(java.util.ArrayList<com.up366.qmui.link.QMUILinkify.LinkSpec> arrayList) {
        int i;
        java.util.Collections.sort(arrayList, new java.util.Comparator<com.up366.qmui.link.QMUILinkify.LinkSpec>() { // from class: com.up366.qmui.link.QMUILinkify.7
            @Override // java.util.Comparator
            public final int compare(com.up366.qmui.link.QMUILinkify.LinkSpec linkSpec, com.up366.qmui.link.QMUILinkify.LinkSpec linkSpec2) {
                if (linkSpec.start < linkSpec2.start) {
                    return -1;
                }
                if (linkSpec.start <= linkSpec2.start && linkSpec.end >= linkSpec2.end) {
                    return linkSpec.end > linkSpec2.end ? -1 : 0;
                }
                return 1;
            }
        });
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size - 1) {
            com.up366.qmui.link.QMUILinkify.LinkSpec linkSpec = arrayList.get(i2);
            int i3 = i2 + 1;
            com.up366.qmui.link.QMUILinkify.LinkSpec linkSpec2 = arrayList.get(i3);
            if (linkSpec.start <= linkSpec2.start && linkSpec.end > linkSpec2.start) {
                if (linkSpec2.end > linkSpec.end && linkSpec.end - linkSpec.start <= linkSpec2.end - linkSpec2.start) {
                    i = linkSpec.end - linkSpec.start < linkSpec2.end - linkSpec2.start ? i2 : -1;
                } else {
                    i = i3;
                }
                if (i != -1) {
                    arrayList.remove(i);
                    size--;
                }
            }
            i2 = i3;
        }
    }

    private static class LinkSpec {
        int end;
        int start;
        java.lang.String url;

        private LinkSpec() {
        }
    }

    private static class WebUrlPattern {
        private static final java.lang.String[] EXT = {com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_TOP, "com", "net", "org", "edu", "gov", "int", "mil", "tel", "biz", "cc", "tv", "info", "zw", "name", "hk", "mobi", "asia", "cd", "travel", "pro", "museum", "coop", "aero", "ad", "ae", "af", "ag", "ai", "al", "am", "an", "ao", "aq", "ar", "as", "at", "au", "aw", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", com.igexin.push.core.b.ac, "bj", "bm", "bn", "bo", "br", "bs", "bt", "bv", "bw", "by", "bz", com.igexin.push.core.b.ab, "cc", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cq", "cr", "cu", "cv", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "es", "et", "ev", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gh", "gi", "gl", "gm", "gn", "gp", "gr", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", com.igexin.push.core.b.C, "ie", "il", "in", "io", "iq", "ir", "is", com.igexin.push.g.q.f, "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "mg", "mh", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nt", "nu", "nz", "om", "qa", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "pt", "pw", "py", "re", "ro", "ru", "rw", "sa", com.up366.common.http.EncryptInterceptor.ENC_HEADER_KEY, com.igexin.push.g.q.e, "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", com.igexin.push.core.b.ad, "su", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tm", "tn", "to", "tp", "tr", "tt", "tv", "tw", "tz", com.igexin.push.g.q.d, "ug", "uk", com.igexin.push.g.q.a, "uy", "va", "vc", "ve", "vg", "vn", "vu", "wf", "ws", "ye", "yu", "za", "zm", "zr"};
        private static final java.lang.String IP_ADDRESS = "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))";
        private static final java.lang.String LABEL_CHAR = "a-zA-Z0-9[ -\ud7ff豈-\ufdcfﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]";
        private static final java.lang.String PATH_AND_QUERY = "[/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-\ufdcfﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*";
        private static final java.lang.String PORT_NUMBER = "\\:\\d{1,5}";
        private static final java.lang.String PROTOCOL = "(?i:http|https|rtsp)://";
        private static final java.lang.String UCS_CHAR = "[ -\ud7ff豈-\ufdcfﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]]";
        private static java.util.regex.Pattern WEB_URL;

        private WebUrlPattern() {
        }

        static {
            int i = 0;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("(");
            while (true) {
                java.lang.String[] strArr = EXT;
                if (i < strArr.length) {
                    if (i != 0) {
                        sb.append("|");
                    }
                    sb.append(strArr[i]);
                    i++;
                } else {
                    sb.append(")");
                    WEB_URL = java.util.regex.Pattern.compile("(((?i:http|https|rtsp)://)?(((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))|" + ("((?:(www\\.|[a-zA-Z\\.\\-]+\\.)?[a-zA-Z0-9\\-]+)\\." + sb.toString() + ")") + ")(\\:\\d{1,5})?([/\\?](?:(?:[a-zA-Z0-9[ -\ud7ff豈-\ufdcfﷰ-\uffef𐀀-\u1fffd𠀀-\u2fffd𰀀-\u3fffd\u40000-\u4fffd\u50000-\u5fffd\u60000-\u6fffd\u70000-\u7fffd\u80000-\u8fffd\u90000-\u9fffd\ua0000-\uafffd\ub0000-\ubfffd\uc0000-\ucfffd\ud0000-\udfffd\ue1000-\uefffd&&[^ [\u2000-\u200a]\u2028\u2029 \u3000]];/\\?:@&=#~\\-\\.\\+!\\*'\\(\\),_\\$])|(?:%[a-fA-F0-9]{2}))*)?)");
                    return;
                }
            }
        }
    }
}
