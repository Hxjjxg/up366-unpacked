package com.igexin.push.core.b;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class m extends com.igexin.push.extension.mod.BaseActionBean implements java.io.Serializable {
    private static boolean k = true;
    private static int l;
    private static int m;
    public com.igexin.push.core.b.m.b a;
    public com.igexin.push.core.b.m.b b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;
    public java.lang.String i;
    public com.igexin.sdk.message.GTPopupMessage j;

    public enum a {
        closePopup,
        intent,
        url
    }

    public static class b implements java.io.Serializable {
        private java.lang.String A;
        private java.lang.String B;
        private java.lang.String C;
        private java.lang.String D;
        private java.lang.String E;
        private float F;
        private float G;
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;
        public java.lang.String d;
        public java.lang.String e;
        public java.lang.String f;
        public java.util.ArrayList<com.igexin.push.core.b.m.b> g;
        public java.lang.String h;
        public boolean i;
        public java.lang.String j;
        public java.lang.String k;
        public int l;
        public int m;
        public int n;
        public com.igexin.sdk.message.GTPopupMessage o;
        public java.lang.String p;
        float q = 0.0f;
        private java.lang.String r;
        private java.lang.String s;
        private java.lang.String t;
        private java.lang.String u;
        private java.lang.String v;
        private java.lang.String w;
        private java.lang.String x;
        private java.lang.String y;
        private java.lang.String z;

        public b(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2, float f, float f2) {
            java.lang.String str3;
            org.json.JSONObject jSONObjectOptJSONObject;
            if (jSONObject == null) {
                return;
            }
            this.F = f;
            this.G = f2;
            this.a = jSONObject.optString("type");
            org.json.JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("layout");
            if (jSONObjectOptJSONObject2 != null) {
                this.b = jSONObjectOptJSONObject2.optString("align");
                this.r = jSONObjectOptJSONObject2.optString("width", null);
                this.s = jSONObjectOptJSONObject2.optString("height", null);
                org.json.JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("margin");
                if (jSONObjectOptJSONObject3 != null) {
                    this.u = jSONObjectOptJSONObject3.optString(com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_TOP, null);
                    this.v = jSONObjectOptJSONObject3.optString(com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_BOTTOM, null);
                    this.w = jSONObjectOptJSONObject3.optString(com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_RIGHT, null);
                    this.x = jSONObjectOptJSONObject3.optString(com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_LEFT, null);
                }
                org.json.JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("padding");
                if (jSONObjectOptJSONObject4 != null) {
                    this.y = jSONObjectOptJSONObject4.optString(com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_TOP, null);
                    this.z = jSONObjectOptJSONObject4.optString(com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_BOTTOM, null);
                    this.A = jSONObjectOptJSONObject4.optString(com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_RIGHT, null);
                    this.B = jSONObjectOptJSONObject4.optString(com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_LEFT, null);
                }
                this.t = jSONObjectOptJSONObject2.optString("maxHeight");
            }
            org.json.JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("properties");
            if (jSONObjectOptJSONObject5 != null) {
                this.d = jSONObjectOptJSONObject5.optString("name", "");
                this.e = jSONObjectOptJSONObject5.optString("elementType");
                this.f = jSONObjectOptJSONObject5.optString("elementId", "");
                this.h = jSONObjectOptJSONObject5.optString(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE);
                this.C = jSONObjectOptJSONObject5.optString("cornerRadius", null);
                this.k = jSONObjectOptJSONObject5.optString("text");
                this.D = jSONObjectOptJSONObject5.optString("font", null);
                this.c = jSONObjectOptJSONObject5.optString("textAlign", null);
                this.i = "bold".equals(jSONObjectOptJSONObject5.optString("fontWeight"));
                org.json.JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject5.optJSONObject("color");
                if (jSONObjectOptJSONObject6 != null) {
                    str3 = "";
                    this.l = android.graphics.Color.argb((int) (jSONObjectOptJSONObject6.optDouble("a") * 255.0d), (int) jSONObjectOptJSONObject6.optDouble("r"), (int) jSONObjectOptJSONObject6.optDouble("g"), (int) jSONObjectOptJSONObject6.optDouble("b"));
                } else {
                    str3 = "";
                }
                org.json.JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject5.optJSONObject("backgroundColor");
                if (jSONObjectOptJSONObject7 != null) {
                    this.m = android.graphics.Color.argb((int) (jSONObjectOptJSONObject7.optDouble("a") * 255.0d), (int) jSONObjectOptJSONObject7.optDouble("r"), (int) jSONObjectOptJSONObject7.optDouble("g"), (int) jSONObjectOptJSONObject7.optDouble("b"));
                }
                this.E = jSONObjectOptJSONObject5.optString("borderWidth", null);
                org.json.JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject5.optJSONObject("borderColor");
                if (jSONObjectOptJSONObject8 != null) {
                    this.n = android.graphics.Color.argb((int) (jSONObjectOptJSONObject8.optDouble("a") * 255.0d), (int) jSONObjectOptJSONObject8.optDouble("r"), (int) jSONObjectOptJSONObject8.optDouble("g"), (int) jSONObjectOptJSONObject8.optDouble("b"));
                }
                this.j = jSONObjectOptJSONObject5.optString("backgroundImage");
            } else {
                str3 = "";
            }
            org.json.JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject("action");
            if (jSONObjectOptJSONObject9 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject9.optJSONObject("ANDROID")) != null) {
                com.igexin.sdk.message.GTPopupMessage gTPopupMessage = new com.igexin.sdk.message.GTPopupMessage();
                gTPopupMessage.setElementType(this.e);
                com.igexin.sdk.message.GTPopupMessage.GtAction gtAction = new com.igexin.sdk.message.GTPopupMessage.GtAction(jSONObjectOptJSONObject.optString("actionType"), jSONObjectOptJSONObject.optString("intent"), jSONObjectOptJSONObject.optString(com.up366.mobile.commonui.CommonWebViewActivity.URL), jSONObjectOptJSONObject.optBoolean("closePopup", false));
                java.lang.String str4 = this.f;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(this.d);
                sb.append(android.text.TextUtils.isEmpty(this.k) ? str3 : "-" + this.k);
                com.igexin.sdk.message.GTPopupMessage.EventProperties eventProperties = new com.igexin.sdk.message.GTPopupMessage.EventProperties(str, str2, str4, sb.toString());
                gTPopupMessage.setAction(gtAction);
                gTPopupMessage.setEventProperties(eventProperties);
                this.o = gTPopupMessage;
                this.p = jSONObjectOptJSONObject.optString("clickActionId", str3);
            }
            org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("subviews");
            if (jSONArrayOptJSONArray != null) {
                this.g = new java.util.ArrayList<>();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.g.add(new com.igexin.push.core.b.m.b(jSONArrayOptJSONArray.optJSONObject(i), str, str2, f, f2));
                }
            }
        }

        private static float a(java.lang.String str) {
            if (str == null || !str.contains("px")) {
                return 0.0f;
            }
            return (float) (((double) com.igexin.push.core.e.l.getResources().getDisplayMetrics().scaledDensity) * java.lang.Double.parseDouble(str.substring(0, str.length() - 2)));
        }

        private static int a(java.lang.String str, float f, float f2) {
            if (str == null || !str.contains("px")) {
                return -2;
            }
            return (int) ((((double) (com.igexin.push.core.b.m.k ? java.lang.Math.min(com.igexin.push.core.b.m.m / f2, com.igexin.push.core.b.m.l / f) : java.lang.Math.min(com.igexin.push.core.b.m.m / f, com.igexin.push.core.b.m.l / f2))) * java.lang.Double.parseDouble(str.substring(0, str.length() - 2))) + 0.5d);
        }

        private java.lang.Object a(java.lang.String str, java.lang.Object obj) {
            if (this.q == 0.0f) {
                this.q = com.igexin.push.core.e.l.getResources().getDisplayMetrics().density;
            }
            if (str == null || !str.contains("px")) {
                return obj;
            }
            double d = java.lang.Double.parseDouble(str.substring(0, str.length() - 2));
            return obj instanceof java.lang.Float ? java.lang.Double.valueOf(d * ((double) this.q)) : obj instanceof java.lang.Integer ? java.lang.Integer.valueOf((int) ((d * ((double) this.q)) + 0.5d)) : java.lang.Integer.valueOf((int) ((d * ((double) this.q)) + 0.5d));
        }

        private static java.lang.Object a(java.lang.String str, java.lang.Object obj, float f, float f2) {
            float f3;
            int i;
            if (str == null || !str.contains("px")) {
                return obj;
            }
            if (com.igexin.push.core.b.m.k) {
                f3 = com.igexin.push.core.b.m.m / f2;
                i = com.igexin.push.core.b.m.l;
            } else {
                f3 = com.igexin.push.core.b.m.l / f2;
                i = com.igexin.push.core.b.m.m;
            }
            float fMin = java.lang.Math.min(f3, i / f);
            float f4 = java.lang.Float.parseFloat(str.substring(0, str.length() - 2));
            if (obj instanceof java.lang.Float) {
                return java.lang.Float.valueOf(f4 * fMin);
            }
            boolean z = obj instanceof java.lang.Integer;
            return java.lang.Integer.valueOf((int) ((f4 * fMin) + 0.5f));
        }

        public final int a() {
            return a(this.r, this.F, this.G);
        }

        public final int b() {
            return a(this.s, this.F, this.G);
        }

        public final int c() {
            return ((java.lang.Integer) a(this.u, 0, this.F, this.G)).intValue();
        }

        public final int d() {
            return ((java.lang.Integer) a(this.v, 0, this.F, this.G)).intValue();
        }

        public final int e() {
            return ((java.lang.Integer) a(this.w, 0, this.F, this.G)).intValue();
        }

        public final int f() {
            return ((java.lang.Integer) a(this.x, 0, this.F, this.G)).intValue();
        }

        public final int g() {
            return ((java.lang.Integer) a(this.y, 0, this.F, this.G)).intValue();
        }

        public final int h() {
            return ((java.lang.Integer) a(this.z, 0, this.F, this.G)).intValue();
        }

        public final int i() {
            return ((java.lang.Integer) a(this.A, 0, this.F, this.G)).intValue();
        }

        public final int j() {
            return ((java.lang.Integer) a(this.B, 0, this.F, this.G)).intValue();
        }

        public final int k() {
            return ((java.lang.Integer) a(this.C, 0, this.F, this.G)).intValue();
        }

        public final float l() {
            return ((java.lang.Float) a(this.D, java.lang.Float.valueOf(0.0f), this.F, this.G)).floatValue();
        }

        public final int m() {
            return ((java.lang.Integer) a(this.E, 0, this.F, this.G)).intValue();
        }

        public final int n() {
            return ((java.lang.Integer) a(this.t, 0, this.F, this.G)).intValue();
        }
    }

    public static void a(android.content.Context context) {
        int i;
        int i2 = context.getResources().getConfiguration().orientation;
        android.util.DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int iMin = java.lang.Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        if (i2 == 1) {
            k = true;
            l = iMin;
            i = displayMetrics.heightPixels;
        } else {
            k = false;
            l = iMin;
            i = displayMetrics.widthPixels;
        }
        m = i;
    }

    private void a(java.lang.String str) {
        this.e = str;
    }

    private void a(org.json.JSONObject jSONObject) {
        float f;
        float f2;
        org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("statisticsInfo");
        if (jSONObjectOptJSONObject != null) {
            this.c = jSONObjectOptJSONObject.optString("planName", "");
            this.d = jSONObjectOptJSONObject.optString("nodeName", "");
        }
        org.json.JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("properties");
        if (jSONObjectOptJSONObject2 != null) {
            java.lang.String strOptString = jSONObjectOptJSONObject2.optString("baseWidth");
            java.lang.String strOptString2 = jSONObjectOptJSONObject2.optString("baseHeight");
            f = java.lang.Float.parseFloat(strOptString.substring(0, strOptString.length() - 2));
            f2 = java.lang.Float.parseFloat(strOptString2.substring(0, strOptString2.length() - 2));
        } else {
            f = 1.0f;
            f2 = 1.0f;
        }
        this.i = jSONObject.optString("showActionId", "");
        float f3 = f;
        float f4 = f2;
        this.a = new com.igexin.push.core.b.m.b(jSONObject.optJSONObject("mask"), this.c, this.d, f3, f4);
        this.b = new com.igexin.push.core.b.m.b(jSONObject.optJSONObject("template"), this.c, this.d, f3, f4);
        com.igexin.sdk.message.GTPopupMessage.EventProperties eventProperties = new com.igexin.sdk.message.GTPopupMessage.EventProperties(this.c, this.d, "", "");
        com.igexin.sdk.message.GTPopupMessage gTPopupMessage = new com.igexin.sdk.message.GTPopupMessage();
        gTPopupMessage.setEventProperties(eventProperties);
        this.j = gTPopupMessage;
    }

    private void b(java.lang.String str) {
        this.f = str;
    }

    private void c(java.lang.String str) {
        this.g = str;
    }

    private java.lang.String d() {
        return this.g;
    }

    private void d(java.lang.String str) {
        this.h = str;
    }

    private java.lang.String e() {
        return this.i;
    }

    private com.igexin.sdk.message.GTPopupMessage f() {
        return this.j;
    }

    private com.igexin.push.core.b.m.b g() {
        return this.b;
    }

    private com.igexin.push.core.b.m.b h() {
        return this.a;
    }

    private java.lang.String i() {
        return this.e;
    }

    private java.lang.String j() {
        return this.h;
    }

    private java.lang.String k() {
        return this.f;
    }
}
