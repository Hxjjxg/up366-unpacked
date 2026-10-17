package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class f {
    public final /* synthetic */ com.unicom.online.account.kernel.i b;

    public f(com.unicom.online.account.kernel.i iVar) {
        this.b = iVar;
    }

    public final void b(int i, int i2, java.lang.String str) {
        java.lang.String str2;
        java.lang.String strB;
        synchronized (this.b) {
            if (this.b.e == null) {
                return;
            }
            if (i2 == 1) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                    int iOptInt = jSONObject.optInt("code");
                    java.lang.String strOptString = jSONObject.optString("msg");
                    java.lang.String strOptString2 = jSONObject.optString("data");
                    java.lang.String strOptString3 = jSONObject.optString("seq");
                    if (com.unicom.online.account.kernel.bh.b(strOptString3).booleanValue()) {
                        strOptString3 = com.unicom.online.account.kernel.bp.c();
                    }
                    java.lang.String str3 = strOptString3;
                    com.unicom.online.account.kernel.as.b("Code =" + iOptInt);
                    com.unicom.online.account.kernel.av avVar = this.b.e;
                    if (iOptInt == 100) {
                        java.lang.String strC = com.unicom.online.account.kernel.ao.c();
                        java.lang.String strSubstring = strC.substring(0, 16);
                        java.lang.String strSubstring2 = strC.substring(16, 32);
                        if (com.unicom.online.account.kernel.ap.g) {
                            byte[] bArrB = com.unicom.online.account.kernel.aq.b(strOptString2);
                            byte[] bytes = strSubstring.getBytes();
                            byte[] bytes2 = strSubstring2.getBytes();
                            com.unicom.online.account.kernel.ad.c.getClass();
                            strB = new java.lang.String(com.unicom.online.account.kernel.bc.b(bytes, bytes2, bArrB, 2));
                        } else {
                            try {
                                strB = com.unicom.online.account.kernel.b.b(strOptString2, strSubstring, strSubstring2);
                            } catch (java.lang.Exception e) {
                                com.unicom.online.account.kernel.as.b(e);
                                strB = null;
                            }
                        }
                        if (android.text.TextUtils.isEmpty(strB)) {
                            com.unicom.online.account.kernel.as.b("\nmsg=" + strOptString + "\ndata=" + strOptString2 + "\nseq=" + str3 + "\n", 2);
                            this.b.e.b(i, 410002, "返回数据异常", strOptString2, str3);
                        } else {
                            com.unicom.online.account.kernel.as.b("\nmsg=" + strOptString + "\ncontent=" + strB + "\nseq=" + str3 + "\n", 2);
                            this.b.e.b(strOptString, strB, str3);
                        }
                    } else {
                        if (iOptInt != -2 || android.text.TextUtils.isEmpty(com.unicom.online.account.kernel.ao.t)) {
                            str2 = strOptString;
                        } else {
                            str2 = strOptString + "apn is " + com.unicom.online.account.kernel.ao.t;
                        }
                        com.unicom.online.account.kernel.as.b("\nmsg=" + str2 + "\ndata=" + strOptString2 + "\nseq=" + str3 + "\n", 2);
                        this.b.e.b(i, iOptInt, str2, strOptString2, str3);
                    }
                } catch (java.lang.Exception e2) {
                    com.unicom.online.account.kernel.as.b("\nresponse=" + str + "\n", 2);
                    this.b.e.b(i, 410002, "返回数据异常" + e2.getMessage(), str, "");
                }
            } else {
                com.unicom.online.account.kernel.as.b("\nresponse=" + str + "\n", 2);
                this.b.e.b(i, i2, str, "", com.unicom.online.account.kernel.bp.c());
            }
            com.unicom.online.account.kernel.i iVar = this.b;
            iVar.e = null;
            iVar.b("请求完成");
        }
    }
}
