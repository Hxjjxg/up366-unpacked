package com.zx.a.I8b7;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class j implements java.lang.Runnable {
    public static volatile java.util.concurrent.atomic.AtomicBoolean b = new java.util.concurrent.atomic.AtomicBoolean(false);
    public long a;

    public j(long j) {
        this.a = j;
    }

    public static org.json.JSONObject a(com.zx.a.I8b7.j jVar, int i, java.lang.String str) throws java.lang.Throwable {
        jVar.getClass();
        java.lang.String strC = com.zx.a.I8b7.w.c(str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5se07mkN71qsSJHjZ2Z0+Z+4L\nlLvf2sz7Md38VAa3EmAOvI7vZp3hbAxicL724ylcmisTPtZQhT/9C+25AELqy9PN\n9JmzKpwoVTUoJvxG4BoyT49+gGVl6s6zo1byNoHUzTfkmRfmC9MC53HvG8GwKP5x\ntcdptFjAIcgIR7oAWQIDAQAB\n");
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(str.getBytes(java.nio.charset.StandardCharsets.UTF_8), "AES");
        javax.crypto.spec.IvParameterSpec ivParameterSpec = new javax.crypto.spec.IvParameterSpec("0000000000000000".getBytes(java.nio.charset.StandardCharsets.UTF_8));
        java.lang.StringBuilder sbA = com.zx.a.I8b7.q3.a("timeStamp=");
        sbA.append(java.lang.System.currentTimeMillis());
        java.lang.String strA = com.zx.a.I8b7.w.a(com.zx.a.I8b7.w.b("AES/CBC/PKCS5Padding", secretKeySpec, ivParameterSpec, sbA.toString().getBytes(java.nio.charset.StandardCharsets.UTF_8)));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String strA2 = com.zx.a.I8b7.w.a(com.zx.a.I8b7.w.a("9390333828Android-30100json" + strC + strA + "1.1", "CCCYQFh5vMFY3K5k04mrkQtFes1rlLCo"));
        sb.append("appId=9390333828&clientType=");
        com.zx.a.I8b7.y3.a(com.zx.a.I8b7.y3.a(com.zx.a.I8b7.y3.a(com.zx.a.I8b7.y3.a(com.zx.a.I8b7.y3.a(sb, "Android-30100", "&", sb, "format="), com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_JSON, "&", sb, "version="), "1.1", "&", sb, "paramKey="), strC, "&", sb, "paramStr="), strA, "&", sb, "sign=").append(strA2);
        org.json.JSONObject jSONObject = new org.json.JSONObject("{\"method\": \"POST\", \"url\": \"https://id6.me/gw/preuniq.do\", \"header\": {\"Charset\": \"UTF-8\", \"Content-type\": \"application/x-www-form-urlencoded; charset=UTF-8\" }, \"reqBody\": \"" + sb.toString() + "\", \"respBody\": \"\", \"bzt\": " + i + "}");
        jSONObject.put("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
        return jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.x2.c.a.a(new com.zx.a.I8b7.j.a());
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.c3.a(th);
        }
    }

    public class a implements com.zx.a.I8b7.x2.b {
        public a() {
        }

        @Override // com.zx.a.I8b7.x2.b
        public void a(android.net.Network network) {
            if (com.zx.a.I8b7.j.b.getAndSet(true)) {
                com.zx.a.I8b7.j.b.set(false);
            } else {
                b(network);
            }
        }

        public final void b(android.net.Network network) {
            try {
                int iC = com.zx.a.I8b7.j4.c(com.zx.a.I8b7.x3.a);
                if (iC == 2) {
                    java.lang.String strSubstring = java.util.UUID.randomUUID().toString().replaceAll("-", "").substring(0, 16);
                    org.json.JSONObject jSONObjectA = com.zx.a.I8b7.j.a(com.zx.a.I8b7.j.this, iC, strSubstring);
                    org.json.JSONObject jSONObjectA2 = network != null ? com.zx.a.I8b7.k0.a(network, jSONObjectA) : com.zx.a.I8b7.l0.a(jSONObjectA);
                    java.lang.String string = jSONObjectA2.getString("respBody");
                    int i = jSONObjectA2.getInt("bzt");
                    org.json.JSONObject jSONObject = new org.json.JSONObject(string);
                    int i2 = jSONObject.getInt("result");
                    java.lang.String strOptString = jSONObject.optString("data");
                    if (i2 == 0 && !android.text.TextUtils.isEmpty(strOptString)) {
                        org.json.JSONObject jSONObjectA3 = com.zx.a.I8b7.j.a(com.zx.a.I8b7.j.this, strSubstring, strOptString);
                        jSONObjectA3.put("tokenGenerationTs", com.zx.a.I8b7.j.this.a);
                        com.zx.a.I8b7.s.a(i, jSONObjectA3);
                    }
                }
                com.zx.a.I8b7.j.b.set(false);
            } catch (java.lang.Throwable th) {
                try {
                    com.zx.a.I8b7.j.b.set(false);
                } catch (java.lang.Throwable unused) {
                }
                com.zx.a.I8b7.c3.a(th.getMessage());
            }
        }

        @Override // com.zx.a.I8b7.x2.b
        public void a(int i, java.lang.String str) {
            if (com.zx.a.I8b7.j.b.getAndSet(true)) {
                com.zx.a.I8b7.j.b.set(false);
            }
        }

        @Override // com.zx.a.I8b7.x2.b
        public void a() {
            if (com.zx.a.I8b7.j.b.getAndSet(true)) {
                com.zx.a.I8b7.j.b.set(false);
            } else {
                b(null);
            }
        }
    }

    public static org.json.JSONObject a(com.zx.a.I8b7.j jVar, java.lang.String str, java.lang.String str2) throws javax.crypto.BadPaddingException, org.json.JSONException, javax.crypto.NoSuchPaddingException, javax.crypto.IllegalBlockSizeException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        jVar.getClass();
        byte[] bytes = str.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        java.security.SecureRandom secureRandom = com.zx.a.I8b7.w.a;
        return new org.json.JSONObject(new java.lang.String(com.zx.a.I8b7.w.a("AES/CBC/PKCS5Padding", new javax.crypto.spec.SecretKeySpec(bytes, "AES"), new javax.crypto.spec.IvParameterSpec("0000000000000000".getBytes(java.nio.charset.StandardCharsets.UTF_8)), com.zx.a.I8b7.w.a(str2)), java.nio.charset.StandardCharsets.UTF_8));
    }
}
