package com.up366.mobile.book.helper.recorder;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ParseHtmlResultV2 {
    private boolean isRej;
    private java.lang.String result;
    private float score;
    private com.up366.asecengine.englishengine.AsecSession session;

    ParseHtmlResultV2(com.up366.asecengine.englishengine.AsecSession asecSession, float f, boolean z) {
        this.session = asecSession;
        this.score = f;
        this.isRej = z;
    }

    public float getScore() {
        return this.score;
    }

    public java.lang.String getResult() {
        return this.result;
    }

    com.up366.mobile.book.helper.recorder.ParseHtmlResultV2 invoke() {
        java.lang.String htmlResult = this.session.getHtmlResult();
        this.result = htmlResult;
        java.lang.String strReplaceAll = htmlResult.replaceAll("'", "\\\\'");
        this.result = strReplaceAll;
        if (this.isRej) {
            this.score = 0.0f;
            java.lang.String strReplaceAll2 = strReplaceAll.replaceAll("<span[^>]+>", "");
            this.result = strReplaceAll2;
            java.lang.String strReplaceAll3 = strReplaceAll2.replaceAll("</span>", "");
            this.result = strReplaceAll3;
            java.lang.String[] strArrSplit = strReplaceAll3.split(" ");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.lang.String str : strArrSplit) {
                sb.append("<span style=\"color:red;\">");
                sb.append(str);
                sb.append("</span> ");
            }
            this.result = sb.toString();
        }
        return this;
    }
}
