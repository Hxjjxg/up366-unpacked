package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class e1 {
    public static final java.util.regex.Pattern c = java.util.regex.Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final java.util.regex.Pattern d = java.util.regex.Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    public final java.lang.String a;
    public final java.lang.String b;

    public e1(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.a = str;
        this.b = str4;
    }

    public static com.zx.a.I8b7.e1 a(java.lang.String str) {
        java.util.regex.Matcher matcher = c.matcher(str);
        if (!matcher.lookingAt()) {
            throw new java.lang.IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        java.lang.String strGroup = matcher.group(1);
        java.util.Locale locale = java.util.Locale.US;
        java.lang.String lowerCase = strGroup.toLowerCase(locale);
        java.lang.String lowerCase2 = matcher.group(2).toLowerCase(locale);
        java.util.regex.Matcher matcher2 = d.matcher(str);
        java.lang.String str2 = null;
        for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("Parameter is not formatted correctly: \"");
                sbA.append(str.substring(iEnd));
                sbA.append("\" for: \"");
                sbA.append(str);
                sbA.append('\"');
                throw new java.lang.IllegalArgumentException(sbA.toString());
            }
            java.lang.String strGroup2 = matcher2.group(1);
            if (strGroup2 != null && strGroup2.equalsIgnoreCase("charset")) {
                java.lang.String strGroup3 = matcher2.group(2);
                if (strGroup3 == null) {
                    strGroup3 = matcher2.group(3);
                } else if (strGroup3.startsWith("'") && strGroup3.endsWith("'") && strGroup3.length() > 2) {
                    strGroup3 = strGroup3.substring(1, strGroup3.length() - 1);
                }
                if (str2 != null && !strGroup3.equalsIgnoreCase(str2)) {
                    throw new java.lang.IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + strGroup3 + "\" for: \"" + str + '\"');
                }
                str2 = strGroup3;
            }
        }
        return new com.zx.a.I8b7.e1(str, lowerCase, lowerCase2, str2);
    }

    public static com.zx.a.I8b7.e1 b(java.lang.String str) {
        try {
            return a(str);
        } catch (java.lang.IllegalArgumentException unused) {
            return null;
        }
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.zx.a.I8b7.e1) && ((com.zx.a.I8b7.e1) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public java.lang.String toString() {
        return this.a;
    }

    public java.nio.charset.Charset a() {
        java.nio.charset.Charset charset = java.nio.charset.StandardCharsets.UTF_8;
        try {
            java.lang.String str = this.b;
            return str != null ? java.nio.charset.Charset.forName(str) : charset;
        } catch (java.lang.IllegalArgumentException unused) {
            return charset;
        }
    }
}
