package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class an {
    public static final com.unicom.online.account.kernel.ak b = new com.unicom.online.account.kernel.ak();

    public static java.lang.String b(java.util.TreeMap treeMap) throws java.lang.Exception {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.util.Map.Entry entry : treeMap.entrySet()) {
                java.lang.String str = (java.lang.String) entry.getKey();
                java.lang.Object value = entry.getValue();
                if (value != null && com.unicom.online.account.kernel.bh.c(str).booleanValue()) {
                    java.lang.String strEncode = java.net.URLEncoder.encode(value.toString(), "UTF-8");
                    sb.append(str);
                    sb.append("=");
                    sb.append(strEncode);
                    sb.append("&");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        } catch (java.lang.Exception e) {
            android.util.Log.e("TAG", "getURLParames: " + e.getMessage());
            throw new java.lang.Exception("http请求参数出错");
        }
    }

    public static void c(final android.content.Context context) {
        b.newThread(new java.lang.Runnable() { // from class: com.unicom.online.account.kernel.an$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                com.unicom.online.account.kernel.an.b(context);
            }
        }).start();
    }

    public static java.lang.String b(java.lang.String str) {
        java.lang.String strC;
        try {
            java.lang.String strC2 = com.unicom.online.account.kernel.ao.c();
            try {
                strC = com.unicom.online.account.kernel.b.c(str, strC2.substring(0, 16), strC2.substring(16, 32));
            } catch (java.lang.Exception e) {
                com.unicom.online.account.kernel.as.b(e);
                strC = null;
            }
            java.security.PublicKey publicKeyGeneratePublic = java.security.KeyFactory.getInstance("RSA").generatePublic(new java.security.spec.X509EncodedKeySpec(com.unicom.online.account.kernel.aq.b("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCqlsahFVMRr61qP/zUqXJlhwhEAR6ynO9ldpawnABDwDiHDymSzsSyyHKE2mS3178d0gGJ5v0TnpNh3+IiOQknpRUvAvXeA9P8DkCNBZBSwCEHo74xQ1+TLMk7f0Qn45GfMipLO0ryYCR4Xg4zE8TubqJ2oyy9pi/QoBdtjx+vJwIDAQAB")));
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            java.lang.String strB = com.unicom.online.account.kernel.aq.b(cipher.doFinal(strC2.getBytes()));
            java.lang.String strB2 = com.unicom.online.account.kernel.au.b(com.unicom.online.account.kernel.ao.j + "?params=" + strC + "&paramsKey=" + strB);
            java.util.TreeMap treeMap = new java.util.TreeMap();
            java.util.HashMap map = new java.util.HashMap(16);
            treeMap.put("params", strC);
            treeMap.put("paramsKey", strB);
            treeMap.put("sign", strB2);
            map.put("sign", strB2);
            map.put("api-protocol", "1.1");
            try {
                return b(treeMap);
            } catch (java.lang.Exception e2) {
                com.unicom.online.account.kernel.as.b(e2);
                return "";
            }
        } catch (java.lang.Exception e3) {
            com.unicom.online.account.kernel.as.b(e3);
            android.util.Log.d("TAG", "run: " + e3.toString());
            return null;
        }
    }

    public static void b() {
        com.unicom.online.account.kernel.d dVar = com.unicom.online.account.kernel.u.c;
        dVar.b = 0;
        dVar.c = 0L;
        com.unicom.online.account.kernel.bg bgVar = dVar.f;
        if (bgVar != null) {
            bgVar.b = "";
            bgVar.c = 0L;
            bgVar.d = 0L;
            bgVar.e = 0L;
        }
        com.unicom.online.account.kernel.bg bgVar2 = dVar.g;
        if (bgVar2 != null) {
            bgVar2.b = "";
            bgVar2.c = 0L;
            bgVar2.d = 0L;
            bgVar2.e = 0L;
        }
        com.unicom.online.account.kernel.bg bgVar3 = dVar.h;
        if (bgVar3 != null) {
            bgVar3.b = "";
            bgVar3.c = 0L;
            bgVar3.d = 0L;
            bgVar3.e = 0L;
        }
        com.unicom.online.account.kernel.bg bgVar4 = dVar.i;
        if (bgVar4 != null) {
            bgVar4.b = "";
            bgVar4.c = 0L;
            bgVar4.d = 0L;
            bgVar4.e = 0L;
        }
    }

    public static void b(android.content.Context context) {
        java.lang.String string = "";
        try {
            if (com.unicom.online.account.kernel.at.c <= 0) {
                string = null;
            } else {
                java.lang.String str = "at" + ((com.unicom.online.account.kernel.at.b + com.unicom.online.account.kernel.at.c) - 1);
                try {
                    try {
                        string = context.getSharedPreferences("cuAuthCacheName", 0).getString("OAlog" + str + str, "");
                    } catch (java.lang.Exception e) {
                        e.getMessage();
                    }
                } catch (java.lang.Exception unused) {
                    com.unicom.online.account.kernel.at.c = 0;
                    string = null;
                }
            }
            if (string == null) {
                return;
            }
            java.lang.String strB = com.unicom.online.account.kernel.ai.b("https://" + com.unicom.online.account.kernel.ao.g + com.unicom.online.account.kernel.ao.j, string);
            if (strB.contains("\"code\":0")) {
                "缓存日志上传成功: ".concat(strB);
                java.lang.String str2 = "at" + ((com.unicom.online.account.kernel.at.b + com.unicom.online.account.kernel.at.c) - 1);
                android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences("cuAuthCacheName", 0).edit();
                editorEdit.remove("OAlog" + str2 + str2);
                editorEdit.commit();
                int i = com.unicom.online.account.kernel.at.c;
                if (i >= 1) {
                    com.unicom.online.account.kernel.at.c = i - 1;
                } else {
                    com.unicom.online.account.kernel.at.c = 0;
                }
            }
        } catch (java.lang.Exception e2) {
            com.unicom.online.account.kernel.as.b(e2);
        }
    }

    public static void b(java.lang.String str, android.content.Context context) {
        try {
            try {
                java.lang.String strB = b(str);
                if (com.unicom.online.account.kernel.bh.c(strB).booleanValue()) {
                    if (com.unicom.online.account.kernel.ai.b("https://" + com.unicom.online.account.kernel.ao.g + com.unicom.online.account.kernel.ao.j, strB).contains("\"code\":0")) {
                        c(context);
                    } else {
                        com.unicom.online.account.kernel.at.b(context, strB);
                    }
                }
            } catch (java.lang.Exception e) {
                com.unicom.online.account.kernel.as.b(e);
            }
        } finally {
            b();
        }
    }

    public static void b(final android.content.Context context, final java.lang.String str) {
        if (com.unicom.online.account.kernel.ap.b) {
            b.newThread(new java.lang.Runnable() { // from class: com.unicom.online.account.kernel.an$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    com.unicom.online.account.kernel.an.b(str, context);
                }
            }).start();
        }
    }
}
