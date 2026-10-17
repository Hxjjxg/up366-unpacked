package com.igexin.push.core;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class n {
    private static final java.lang.String b = "PushMessageExecutor";
    private static java.util.Set<java.lang.String> d;
    private static volatile com.igexin.push.core.n f;
    private final java.util.Map<java.lang.String, com.igexin.push.extension.mod.PushMessageInterface> c;
    protected java.util.HashMap<java.lang.String, java.lang.String> a = new java.util.HashMap<>();
    private final java.util.Map<java.lang.String, java.lang.String> e = new java.util.concurrent.ConcurrentHashMap();

    private n() {
        d = new java.util.HashSet();
        this.c = new java.util.HashMap();
        d.add(com.igexin.push.core.b.s);
        d.add(com.igexin.push.core.b.n);
        d.add(com.igexin.push.core.b.o);
        d.add(com.igexin.push.core.b.p);
        d.add(com.igexin.push.core.b.q);
        d.add(com.igexin.push.core.b.r);
        d.add(com.igexin.push.core.b.m);
        d.add(com.igexin.push.core.b.u);
        d.add(com.igexin.push.core.b.v);
        d.add(com.igexin.push.core.b.w);
        d.add(com.igexin.push.core.b.x);
        d.add(com.igexin.push.core.b.y);
        d.add(com.igexin.push.core.b.t);
        d.add(com.igexin.push.core.b.z);
    }

    public static com.igexin.push.core.n a() {
        if (f == null) {
            synchronized (com.igexin.push.core.n.class) {
                if (f == null) {
                    f = new com.igexin.push.core.n();
                }
            }
        }
        return f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private com.igexin.push.extension.mod.PushMessageInterface a(java.lang.String str) {
        com.igexin.push.extension.mod.PushMessageInterface pushMessageInterface;
        com.igexin.push.core.n nVar;
        java.lang.ClassLoader classLoaderB;
        java.lang.Class<?> clsLoadClass;
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        com.igexin.push.extension.mod.PushMessageInterface pushMessageInterface2 = null;
        try {
            if (!this.a.containsKey(str) || (classLoaderB = com.igexin.push.core.e.b(str)) == null || (clsLoadClass = classLoaderB.loadClass(this.a.get(str))) == null) {
                pushMessageInterface = null;
            } else {
                pushMessageInterface = (com.igexin.push.extension.mod.PushMessageInterface) clsLoadClass.newInstance();
                try {
                    this.c.put(str, pushMessageInterface);
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.igexin.c.a.c.a.a(th);
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            pushMessageInterface = null;
        }
        if (pushMessageInterface != null) {
            return pushMessageInterface;
        }
        if (!android.text.TextUtils.isEmpty(str) && d.contains(str) && (pushMessageInterface2 = this.c.get(str)) == null) {
            str.hashCode();
            byte b2 = -1;
            switch (str.hashCode()) {
                case -1664373827:
                    if (str.equals(com.igexin.push.core.b.t)) {
                        b2 = 0;
                    }
                    break;
                case -1618888868:
                    if (str.equals(com.igexin.push.core.b.y)) {
                        b2 = 1;
                    }
                    break;
                case -1352939875:
                    if (str.equals(com.igexin.push.core.b.p)) {
                        b2 = 2;
                    }
                    break;
                case -1218913434:
                    if (str.equals(com.igexin.push.core.b.o)) {
                        b2 = 3;
                    }
                    break;
                case -631641375:
                    if (str.equals(com.igexin.push.core.b.x)) {
                        b2 = 4;
                    }
                    break;
                case 3178851:
                    if (str.equals(com.igexin.push.core.b.s)) {
                        b2 = 5;
                    }
                    break;
                case 3392903:
                    if (str.equals(com.igexin.push.core.b.m)) {
                        b2 = 6;
                    }
                    break;
                case 106852524:
                    if (str.equals(com.igexin.push.core.b.r)) {
                        b2 = 7;
                    }
                    break;
                case 595233003:
                    if (str.equals(com.igexin.push.core.b.n)) {
                        b2 = 8;
                    }
                    break;
                case 790184760:
                    if (str.equals(com.igexin.push.core.b.w)) {
                        b2 = 9;
                    }
                    break;
                case 961723282:
                    if (str.equals(com.igexin.push.core.b.z)) {
                        b2 = 10;
                    }
                    break;
                case 1316799103:
                    if (str.equals(com.igexin.push.core.b.q)) {
                        b2 = com.igexin.push.core.b.n.l;
                    }
                    break;
                case 1316819890:
                    if (str.equals(com.igexin.push.core.b.u)) {
                        b2 = 12;
                    }
                    break;
                case 1536890905:
                    if (str.equals(com.igexin.push.core.b.v)) {
                        b2 = 13;
                    }
                    break;
            }
            switch (b2) {
                case 0:
                    nVar = this;
                    nVar.c.put(com.igexin.push.core.b.t, new com.igexin.push.core.a.c.n());
                    break;
                case 1:
                    nVar = this;
                    nVar.c.put(com.igexin.push.core.b.y, new com.igexin.push.core.a.c.c());
                    break;
                case 2:
                    nVar = this;
                    nVar.c.put(com.igexin.push.core.b.p, new com.igexin.push.core.a.c.k());
                    break;
                case 3:
                    nVar = this;
                    nVar.c.put(com.igexin.push.core.b.o, new com.igexin.push.core.a.c.m());
                    break;
                case 4:
                    nVar = this;
                    nVar.c.put(com.igexin.push.core.b.x, new com.igexin.push.core.a.c.d());
                    break;
                case 5:
                    nVar = this;
                    nVar.c.put(com.igexin.push.core.b.s, new com.igexin.push.core.a.c.f());
                    break;
                case 6:
                    nVar = this;
                    nVar.c.put(com.igexin.push.core.b.m, new com.igexin.push.core.a.c.e());
                    break;
                case 7:
                    nVar = this;
                    nVar.c.put(com.igexin.push.core.b.r, new com.igexin.push.core.a.c.i());
                    break;
                case 8:
                    nVar = this;
                    nVar.c.put(com.igexin.push.core.b.n, new com.igexin.push.core.a.c.h());
                    break;
                case 9:
                    nVar = this;
                    nVar.c.put(com.igexin.push.core.b.w, new com.igexin.push.core.a.c.b());
                    break;
                case 10:
                    nVar = this;
                    nVar.c.put(com.igexin.push.core.b.z, new com.igexin.push.core.a.c.g());
                    break;
                case 11:
                    nVar = this;
                    nVar.c.put(com.igexin.push.core.b.q, new com.igexin.push.core.a.c.j());
                    break;
                case 12:
                    nVar = this;
                    nVar.c.put(com.igexin.push.core.b.u, new com.igexin.push.core.a.c.l());
                    break;
                case 13:
                    nVar = this;
                    nVar.c.put(com.igexin.push.core.b.v, new com.igexin.push.core.a.c.a());
                    break;
                default:
                    nVar = this;
                    break;
            }
            pushMessageInterface2 = nVar.c.get(str);
        }
        return pushMessageInterface2;
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = com.igexin.push.core.b.U;
        messageObtain.obj = bundle;
        com.igexin.push.core.d.a.a.a(messageObtain);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private com.igexin.push.extension.mod.PushMessageInterface b(java.lang.String str) {
        com.igexin.push.core.n nVar;
        if (android.text.TextUtils.isEmpty(str) || !d.contains(str)) {
            return null;
        }
        com.igexin.push.extension.mod.PushMessageInterface pushMessageInterface = this.c.get(str);
        if (pushMessageInterface != null) {
            return pushMessageInterface;
        }
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case -1664373827:
                if (str.equals(com.igexin.push.core.b.t)) {
                    b2 = 0;
                }
                break;
            case -1618888868:
                if (str.equals(com.igexin.push.core.b.y)) {
                    b2 = 1;
                }
                break;
            case -1352939875:
                if (str.equals(com.igexin.push.core.b.p)) {
                    b2 = 2;
                }
                break;
            case -1218913434:
                if (str.equals(com.igexin.push.core.b.o)) {
                    b2 = 3;
                }
                break;
            case -631641375:
                if (str.equals(com.igexin.push.core.b.x)) {
                    b2 = 4;
                }
                break;
            case 3178851:
                if (str.equals(com.igexin.push.core.b.s)) {
                    b2 = 5;
                }
                break;
            case 3392903:
                if (str.equals(com.igexin.push.core.b.m)) {
                    b2 = 6;
                }
                break;
            case 106852524:
                if (str.equals(com.igexin.push.core.b.r)) {
                    b2 = 7;
                }
                break;
            case 595233003:
                if (str.equals(com.igexin.push.core.b.n)) {
                    b2 = 8;
                }
                break;
            case 790184760:
                if (str.equals(com.igexin.push.core.b.w)) {
                    b2 = 9;
                }
                break;
            case 961723282:
                if (str.equals(com.igexin.push.core.b.z)) {
                    b2 = 10;
                }
                break;
            case 1316799103:
                if (str.equals(com.igexin.push.core.b.q)) {
                    b2 = com.igexin.push.core.b.n.l;
                }
                break;
            case 1316819890:
                if (str.equals(com.igexin.push.core.b.u)) {
                    b2 = 12;
                }
                break;
            case 1536890905:
                if (str.equals(com.igexin.push.core.b.v)) {
                    b2 = 13;
                }
                break;
        }
        switch (b2) {
            case 0:
                nVar = this;
                nVar.c.put(com.igexin.push.core.b.t, new com.igexin.push.core.a.c.n());
                break;
            case 1:
                nVar = this;
                nVar.c.put(com.igexin.push.core.b.y, new com.igexin.push.core.a.c.c());
                break;
            case 2:
                nVar = this;
                nVar.c.put(com.igexin.push.core.b.p, new com.igexin.push.core.a.c.k());
                break;
            case 3:
                nVar = this;
                nVar.c.put(com.igexin.push.core.b.o, new com.igexin.push.core.a.c.m());
                break;
            case 4:
                nVar = this;
                nVar.c.put(com.igexin.push.core.b.x, new com.igexin.push.core.a.c.d());
                break;
            case 5:
                nVar = this;
                nVar.c.put(com.igexin.push.core.b.s, new com.igexin.push.core.a.c.f());
                break;
            case 6:
                nVar = this;
                nVar.c.put(com.igexin.push.core.b.m, new com.igexin.push.core.a.c.e());
                break;
            case 7:
                nVar = this;
                nVar.c.put(com.igexin.push.core.b.r, new com.igexin.push.core.a.c.i());
                break;
            case 8:
                nVar = this;
                nVar.c.put(com.igexin.push.core.b.n, new com.igexin.push.core.a.c.h());
                break;
            case 9:
                nVar = this;
                nVar.c.put(com.igexin.push.core.b.w, new com.igexin.push.core.a.c.b());
                break;
            case 10:
                nVar = this;
                nVar.c.put(com.igexin.push.core.b.z, new com.igexin.push.core.a.c.g());
                break;
            case 11:
                nVar = this;
                nVar.c.put(com.igexin.push.core.b.q, new com.igexin.push.core.a.c.j());
                break;
            case 12:
                nVar = this;
                nVar.c.put(com.igexin.push.core.b.u, new com.igexin.push.core.a.c.l());
                break;
            case 13:
                nVar = this;
                nVar.c.put(com.igexin.push.core.b.v, new com.igexin.push.core.a.c.a());
                break;
            default:
                nVar = this;
                break;
        }
        return nVar.c.get(str);
    }

    public static void b() {
        try {
            if (!android.text.TextUtils.isEmpty(com.igexin.push.config.d.C) && !com.igexin.push.a.i.equals(com.igexin.push.config.d.C)) {
                java.util.List<java.lang.String> listAsList = java.util.Arrays.asList(com.igexin.push.config.d.C.split(com.igexin.push.core.b.an));
                if (listAsList.isEmpty()) {
                    return;
                }
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator<java.util.Map.Entry<java.lang.String, com.igexin.push.extension.mod.PushTaskBean>> it = com.igexin.push.core.e.ah.entrySet().iterator();
                while (it.hasNext()) {
                    java.util.Map.Entry<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> next = it.next();
                    java.lang.String key = next.getKey();
                    com.igexin.push.extension.mod.PushTaskBean value = next.getValue();
                    if (!android.text.TextUtils.isEmpty(key)) {
                        for (java.lang.String str : listAsList) {
                            if (!android.text.TextUtils.isEmpty(str) && key.startsWith(str)) {
                                arrayList.add(value.getTaskId());
                                it.remove();
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                java.lang.String[] strArr = new java.lang.String[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    strArr[i] = (java.lang.String) arrayList.get(i);
                }
                com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[]{"taskid"}, strArr);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void b(org.json.JSONObject jSONObject, com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
        try {
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("condition");
            java.util.HashMap map = new java.util.HashMap();
            if (jSONObject2.has("wifi")) {
                map.put("wifi", jSONObject2.getString("wifi"));
            }
            if (jSONObject2.has("screenOn")) {
                map.put("screenOn", jSONObject2.getString("screenOn"));
            }
            if (jSONObject2.has("ssid")) {
                map.put("ssid", jSONObject2.getString("ssid"));
                if (jSONObject2.has("bssid")) {
                    map.put("bssid", jSONObject2.getString("bssid"));
                }
            }
            if (jSONObject2.has("duration")) {
                java.lang.String string = jSONObject2.getString("duration");
                if (string.contains("-")) {
                    int iIndexOf = string.indexOf("-");
                    java.lang.String strSubstring = string.substring(0, iIndexOf);
                    java.lang.String strSubstring2 = string.substring(iIndexOf + 1, string.length());
                    map.put("startTime", strSubstring);
                    map.put("endTime", strSubstring2);
                }
            }
            if (jSONObject2.has("netConnected")) {
                map.put("netConnected", jSONObject2.getString("netConnected"));
            }
            if (jSONObject2.has("expireTime")) {
                java.lang.String string2 = jSONObject2.getString("expireTime");
                if (!android.text.TextUtils.isEmpty(string2) && android.text.TextUtils.isDigitsOnly(string2)) {
                    map.put("expireTime", string2);
                }
            }
            pushTaskBean.setConditionMap(map);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private void c(java.lang.String str, java.lang.String str2) {
        if (str2 == null || str == null) {
            return;
        }
        try {
            com.igexin.push.core.a.b.d();
            java.lang.String strA = com.igexin.push.core.a.b.a(str, str2);
            com.igexin.push.extension.mod.PushTaskBean pushTaskBean = com.igexin.push.core.e.ah.get(strA);
            if (pushTaskBean == null) {
                return;
            }
            if (pushTaskBean.getStatus() == com.igexin.push.core.b.ag) {
                com.igexin.c.a.c.a.b(b, " has execute ".concat(java.lang.String.valueOf(strA)));
                return;
            }
            pushTaskBean.setStatus(com.igexin.push.core.b.ag);
            com.igexin.c.a.c.a.b(b, " do processActionExecute ".concat(java.lang.String.valueOf(strA)));
            if (b(str, str2) != com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success) {
                pushTaskBean.setStatus(com.igexin.push.core.b.af);
                return;
            }
            com.igexin.push.core.e.c.a();
            com.igexin.push.core.e.c.a(com.igexin.push.core.b.ag, str);
            pushTaskBean.setStatus(com.igexin.push.core.b.ag);
            if (a(str, str2, "1")) {
                return;
            }
            com.igexin.push.core.e.c.a();
            com.igexin.push.core.e.c.a(com.igexin.push.core.b.af, str);
            pushTaskBean.setStatus(com.igexin.push.core.b.af);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void e() {
        com.igexin.c.a.c.a.a("PushMessageExecutor|--------checkConditionStatus the pushMessageMap from db because log gkt...", new java.lang.Object[0]);
        try {
            if (com.igexin.push.g.c.a(java.lang.System.currentTimeMillis())) {
                com.igexin.c.a.c.a.b(b, "message in silent time , ignored...");
                return;
            }
            if (d()) {
                return;
            }
            for (java.util.Map.Entry<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> entry : com.igexin.push.core.e.ah.entrySet()) {
                try {
                    entry.getKey();
                    com.igexin.push.extension.mod.PushTaskBean value = entry.getValue();
                    if (value != null && value.getStatus() == com.igexin.push.core.b.af) {
                        java.lang.String taskId = value.getTaskId();
                        java.util.Map<java.lang.String, java.lang.String> conditionMap = value.getConditionMap();
                        if (conditionMap == null) {
                            return;
                        }
                        if (a(conditionMap, taskId, value)) {
                            a(taskId, value.getMessageId());
                        }
                    }
                } catch (java.lang.Exception e) {
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("PushMessageExecutor|" + e.toString(), new java.lang.Object[0]);
                }
            }
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PushMessageExecutor|" + e2.toString(), new java.lang.Object[0]);
        }
    }

    private boolean f() {
        if (com.igexin.push.core.e.ah.isEmpty() && com.igexin.push.core.e.w.getAndSet(false)) {
            android.database.Cursor cursorA = null;
            try {
                cursorA = com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[]{"status"}, new java.lang.String[]{"0"}, null, null);
                if (cursorA != null) {
                    while (cursorA.moveToNext()) {
                        byte[] blob = cursorA.getBlob(cursorA.getColumnIndex("msgextra"));
                        try {
                            org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(com.igexin.c.b.a.c(cursorA.getBlob(cursorA.getColumnIndex("info")))));
                            java.lang.String string = jSONObject.getString(com.igexin.push.core.b.C);
                            java.lang.String string2 = jSONObject.getString("appid");
                            java.lang.String string3 = jSONObject.getString("messageid");
                            java.lang.String string4 = jSONObject.getString("taskid");
                            java.lang.String string5 = jSONObject.getString("appkey");
                            org.json.JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
                            com.igexin.push.core.a.b.d();
                            java.lang.String strA = com.igexin.push.core.a.b.a(string4, string3);
                            com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
                            pushTaskBean.setAppid(string2);
                            pushTaskBean.setMessageId(string3);
                            pushTaskBean.setTaskId(string4);
                            pushTaskBean.setId(string);
                            pushTaskBean.setAppKey(string5);
                            pushTaskBean.setCurrentActionid(1);
                            pushTaskBean.setStatus(cursorA.getInt(cursorA.getColumnIndex("status")));
                            if (blob != null) {
                                pushTaskBean.setMsgExtra(blob);
                            }
                            if (jSONObject.has("condition")) {
                                b(jSONObject, pushTaskBean);
                            }
                            if (jSONArray.length() > 0) {
                                if (a(jSONObject, pushTaskBean)) {
                                    com.igexin.push.core.e.ah.put(strA, pushTaskBean);
                                } else {
                                    com.igexin.c.a.c.a.a(b, "load task from db parseActionChains error, " + jSONObject.toString());
                                    com.igexin.c.a.c.a.a("PushMessageExecutor|load task from db parseActionChains error, " + jSONObject.toString(), new java.lang.Object[0]);
                                }
                            }
                        } catch (org.json.JSONException e) {
                            com.igexin.c.a.c.a.a(e);
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                try {
                    com.igexin.c.a.c.a.a(th);
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
            if (cursorA != null) {
            }
        }
        return com.igexin.push.core.e.ah.isEmpty();
    }

    private void g() {
        try {
            java.util.List<android.net.wifi.ScanResult> listJ = com.igexin.push.g.o.j();
            this.e.clear();
            if (listJ == null || listJ.isEmpty()) {
                return;
            }
            for (int i = 0; i < listJ.size(); i++) {
                this.e.put(listJ.get(i).BSSID, listJ.get(i).SSID);
                java.lang.String str = listJ.get(i).BSSID;
                java.lang.String str2 = listJ.get(i).SSID;
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final void a(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra("taskid");
        java.lang.String stringExtra2 = intent.getStringExtra("messageid");
        java.lang.String stringExtra3 = intent.getStringExtra("actionid");
        java.lang.String stringExtra4 = intent.getStringExtra("accesstoken");
        java.lang.String stringExtra5 = intent.getStringExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL);
        java.lang.String stringExtra6 = intent.getStringExtra("intentUri");
        java.lang.String stringExtra7 = intent.getStringExtra(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_PAYLOAD);
        java.lang.String stringExtra8 = intent.hasExtra("title") ? intent.getStringExtra("title") : "";
        java.lang.String stringExtra9 = intent.hasExtra(com.igexin.sdk.FlymePushReceiver.CONTENT) ? intent.getStringExtra(com.igexin.sdk.FlymePushReceiver.CONTENT) : "";
        int intExtra = intent.getIntExtra("notifID", 0);
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) com.igexin.push.core.e.l.getSystemService(com.igexin.push.core.b.n);
        if (intExtra != 0) {
            notificationManager.cancel(intExtra);
        } else if (com.igexin.push.core.e.ai.containsKey(stringExtra)) {
            intExtra = com.igexin.push.core.e.ai.get(stringExtra).intValue();
            notificationManager.cancel(intExtra);
        }
        com.igexin.push.core.e.ai.remove(stringExtra);
        if (stringExtra4.equals(com.igexin.push.core.e.an)) {
            com.igexin.push.core.l.a().b(stringExtra, stringExtra2, stringExtra8, stringExtra9, stringExtra5, stringExtra6, stringExtra7);
            b(stringExtra, stringExtra2, stringExtra3);
        }
    }

    public final boolean a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (java.lang.Thread.currentThread().getId() == com.igexin.push.core.d.a.a.a()) {
            return b(str, str2, str3);
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("actionid", str3);
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = com.igexin.push.core.b.S;
        messageObtain.obj = bundle;
        return com.igexin.push.core.d.a.a.a(messageObtain);
    }

    public final boolean a(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str, com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
        java.lang.String str2;
        if (!com.igexin.push.g.c.b(str)) {
            if (map != null && map.size() != 0) {
                if ((!map.containsKey("expireTime") || java.lang.Long.parseLong(map.get("expireTime")) >= java.lang.System.currentTimeMillis()) && (!map.containsKey("endTime") || java.lang.Long.parseLong(map.get("endTime")) >= java.lang.System.currentTimeMillis())) {
                    if (map.containsKey("wifi")) {
                        int i = java.lang.Integer.parseInt(map.get("wifi"));
                        com.igexin.push.g.c.c();
                        if (i != com.igexin.push.core.e.x) {
                            return false;
                        }
                    }
                    if (map.containsKey("screenOn")) {
                        int i2 = java.lang.Integer.parseInt(map.get("screenOn"));
                        com.igexin.push.g.c.d();
                        if (i2 != com.igexin.push.core.e.y) {
                            return false;
                        }
                    }
                    if (map.containsKey("ssid")) {
                        str2 = map.get("ssid");
                        try {
                            java.util.List<android.net.wifi.ScanResult> listJ = com.igexin.push.g.o.j();
                            this.e.clear();
                            if (listJ != null && !listJ.isEmpty()) {
                                for (int i3 = 0; i3 < listJ.size(); i3++) {
                                    this.e.put(listJ.get(i3).BSSID, listJ.get(i3).SSID);
                                    java.lang.String str3 = listJ.get(i3).BSSID;
                                    java.lang.String str4 = listJ.get(i3).SSID;
                                }
                            }
                        } catch (java.lang.Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                        if (!this.e.containsValue(str2)) {
                            return false;
                        }
                    } else {
                        str2 = "";
                    }
                    if (map.containsKey("bssid")) {
                        java.lang.String str5 = map.get("bssid");
                        if (!this.e.containsKey(str5)) {
                            return false;
                        }
                        java.lang.String str6 = this.e.get(str5);
                        if (str6 != null && !str6.equals(str2)) {
                            return false;
                        }
                    }
                    if (map.containsKey("startTime") && java.lang.Long.parseLong(map.get("startTime")) > java.lang.System.currentTimeMillis()) {
                        return false;
                    }
                    if (map.containsKey("netConnected")) {
                        try {
                            if (java.lang.Integer.parseInt(map.get("netConnected")) != com.igexin.push.g.c.e()) {
                                return false;
                            }
                        } catch (java.lang.Exception e) {
                            com.igexin.c.a.c.a.a(e);
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        com.igexin.push.core.e.c.a();
        com.igexin.push.core.e.c.a(com.igexin.push.core.b.ah, str);
        pushTaskBean.setStatus(com.igexin.push.core.b.ag);
        return false;
    }

    public final boolean a(org.json.JSONObject jSONObject, com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
        com.igexin.c.a.c.a.a("PushMessageExecutor------parse pushmessage actionchain json start-------", new java.lang.Object[0]);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            org.json.JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
            for (int i = 0; i < jSONArray.length(); i++) {
                java.lang.String string = ((org.json.JSONObject) jSONArray.get(i)).getString("type");
                if (!this.a.containsKey(string) && !d.contains(string)) {
                    com.igexin.c.a.c.a.a("PushMessageExecutor|" + string + " not support~", new java.lang.Object[0]);
                    return false;
                }
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                org.json.JSONObject jSONObject2 = (org.json.JSONObject) jSONArray.get(i2);
                java.lang.String string2 = jSONObject2.getString("type");
                com.igexin.c.a.c.a.a("PushMessageExecutor|start parse type = ".concat(java.lang.String.valueOf(string2)), new java.lang.Object[0]);
                com.igexin.push.extension.mod.PushMessageInterface pushMessageInterfaceA = a(string2);
                if (pushMessageInterfaceA != null) {
                    arrayList.add(pushMessageInterfaceA.parseAction(jSONObject2));
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        pushTaskBean.setActionChains(arrayList);
        com.igexin.c.a.c.a.b(b, "------parse pushmessage actionchain json end-------");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01ba A[Catch: all -> 0x023a, LOOP:0: B:40:0x0172->B:53:0x01ba, LOOP_END, TryCatch #1 {all -> 0x023a, blocks: (B:29:0x00f0, B:31:0x00f9, B:33:0x0112, B:35:0x014f, B:36:0x0157, B:38:0x015d, B:39:0x0160, B:40:0x0172, B:42:0x0178, B:44:0x018d, B:46:0x0193, B:52:0x01a1, B:53:0x01ba, B:54:0x01bd, B:73:0x0236, B:55:0x01c1, B:57:0x01c6, B:58:0x01cc, B:61:0x01d6, B:63:0x01e4, B:64:0x01e7, B:65:0x01eb, B:67:0x0200, B:68:0x0223, B:70:0x0231), top: B:104:0x00f0, outer: #2, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(org.json.JSONObject r19, byte[] r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.n.a(org.json.JSONObject, byte[], boolean):boolean");
    }

    public final com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState b(java.lang.String str, java.lang.String str2) {
        com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState actionPrepareState = com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
        com.igexin.push.core.a.b.d();
        com.igexin.push.extension.mod.PushTaskBean pushTaskBean = com.igexin.push.core.e.ah.get(com.igexin.push.core.a.b.a(str, str2));
        if (pushTaskBean == null) {
            return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.stop;
        }
        int i = 0;
        boolean z = false;
        for (com.igexin.push.extension.mod.BaseActionBean baseActionBean : pushTaskBean.getActionChains()) {
            com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState actionPrepareStatePrepareExecuteAction = com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.stop;
            if (baseActionBean == null) {
                return actionPrepareStatePrepareExecuteAction;
            }
            if (!z && com.igexin.push.core.b.r.equals(baseActionBean.getType())) {
                z = true;
            }
            com.igexin.push.extension.mod.PushMessageInterface pushMessageInterfaceA = a(baseActionBean.getType());
            if (pushMessageInterfaceA != null) {
                actionPrepareStatePrepareExecuteAction = pushMessageInterfaceA.prepareExecuteAction(pushTaskBean, baseActionBean);
            } else {
                baseActionBean.getType();
            }
            if (actionPrepareState == com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success) {
                actionPrepareState = actionPrepareStatePrepareExecuteAction;
            }
            if (actionPrepareStatePrepareExecuteAction == com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.wait) {
                i++;
            }
        }
        return (i == 0 || z || com.igexin.push.core.e.a(str, java.lang.Integer.valueOf(i))) ? actionPrepareState : com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
    }

    public final boolean b(java.lang.String str, java.lang.String str2, final java.lang.String str3) {
        com.igexin.push.extension.mod.PushMessageInterface pushMessageInterfaceA;
        com.igexin.push.core.a.b.d();
        java.lang.String strA = com.igexin.push.core.a.b.a(str, str2);
        com.igexin.c.a.c.a.b(b, "executePushMessageAction taskid:" + str + ", actionid:" + str3);
        final com.igexin.push.extension.mod.PushTaskBean pushTaskBean = com.igexin.push.core.e.ah.get(strA);
        if (pushTaskBean == null) {
            android.database.Cursor cursorA = null;
            try {
                cursorA = com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[]{"taskid", "messageid"}, new java.lang.String[]{str, str2}, null, null);
            } catch (java.lang.Throwable th) {
                try {
                    com.igexin.c.a.c.a.a(th);
                    if (cursorA != null) {
                    }
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
            if (cursorA != null && cursorA.getCount() > 0) {
                while (cursorA.moveToNext()) {
                    a().a(new org.json.JSONObject(new java.lang.String(com.igexin.c.b.a.c(cursorA.getBlob(cursorA.getColumnIndexOrThrow("info"))))), cursorA.getBlob(cursorA.getColumnIndexOrThrow("msgextra")), false);
                    com.igexin.push.extension.mod.PushTaskBean pushTaskBean2 = com.igexin.push.core.e.ah.get(str + ":" + str2);
                    if (pushTaskBean2 == null) {
                        return false;
                    }
                    pushTaskBean = pushTaskBean2;
                }
                if (cursorA != null) {
                    cursorA.close();
                }
            }
            if (cursorA != null) {
                cursorA.close();
            }
            return false;
        }
        int executeTimes = pushTaskBean.getExecuteTimes();
        if (executeTimes >= 50) {
            try {
                com.igexin.push.core.e.ah.remove(strA);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
                com.igexin.c.a.c.a.a("PushMessageExecutor|" + e.toString(), new java.lang.Object[0]);
            }
            return true;
        }
        pushTaskBean.setExecuteTimes(executeTimes + 1);
        com.igexin.sdk.main.FeedbackImpl.getInstance().asyncFeedback(new java.lang.Runnable() { // from class: com.igexin.push.core.n.2
            @Override // java.lang.Runnable
            public final void run() {
                com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, str3);
            }
        });
        try {
            com.igexin.push.extension.mod.BaseActionBean baseAction = pushTaskBean.getBaseAction(str3);
            if (baseAction != null && (pushMessageInterfaceA = a(baseAction.getType())) != null) {
                return pushMessageInterfaceA.executeAction(pushTaskBean, baseAction);
            }
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
        }
        return false;
    }

    public final void c() {
        try {
            if (com.igexin.push.g.c.a(java.lang.System.currentTimeMillis())) {
                com.igexin.c.a.c.a.b(b, "message in silent time , ignored...");
                return;
            }
            if (f()) {
                return;
            }
            for (java.util.Map.Entry<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> entry : com.igexin.push.core.e.ah.entrySet()) {
                try {
                    entry.getKey();
                    com.igexin.push.extension.mod.PushTaskBean value = entry.getValue();
                    if (value != null && value.getStatus() == com.igexin.push.core.b.af) {
                        java.lang.String taskId = value.getTaskId();
                        java.util.Map<java.lang.String, java.lang.String> conditionMap = value.getConditionMap();
                        if (conditionMap == null) {
                            return;
                        }
                        if (a(conditionMap, taskId, value)) {
                            a(taskId, value.getMessageId());
                        }
                    }
                } catch (java.lang.Exception e) {
                    com.igexin.c.a.c.a.a(e);
                    com.igexin.c.a.c.a.a("PushMessageExecutor|" + e.toString(), new java.lang.Object[0]);
                }
            }
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("PushMessageExecutor|" + e2.toString(), new java.lang.Object[0]);
        }
    }

    public final boolean d() {
        android.database.Cursor cursorA = null;
        try {
            cursorA = com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[]{"status"}, new java.lang.String[]{"0"}, null, null);
            if (cursorA != null) {
                while (cursorA.moveToNext()) {
                    byte[] blob = cursorA.getBlob(cursorA.getColumnIndex("msgextra"));
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(com.igexin.c.b.a.c(cursorA.getBlob(cursorA.getColumnIndex("info")))));
                        java.lang.String string = jSONObject.getString(com.igexin.push.core.b.C);
                        java.lang.String string2 = jSONObject.getString("appid");
                        java.lang.String string3 = jSONObject.getString("messageid");
                        java.lang.String string4 = jSONObject.getString("taskid");
                        java.lang.String string5 = jSONObject.getString("appkey");
                        org.json.JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
                        com.igexin.push.core.a.b.d();
                        java.lang.String strA = com.igexin.push.core.a.b.a(string4, string3);
                        com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
                        pushTaskBean.setAppid(string2);
                        pushTaskBean.setMessageId(string3);
                        pushTaskBean.setTaskId(string4);
                        pushTaskBean.setId(string);
                        pushTaskBean.setAppKey(string5);
                        pushTaskBean.setCurrentActionid(1);
                        pushTaskBean.setStatus(cursorA.getInt(cursorA.getColumnIndex("status")));
                        if (blob != null) {
                            pushTaskBean.setMsgExtra(blob);
                        }
                        if (jSONObject.has("condition")) {
                            b(jSONObject, pushTaskBean);
                        }
                        if (jSONArray.length() > 0) {
                            if (!a(jSONObject, pushTaskBean)) {
                                com.igexin.c.a.c.a.a(b, "load task from db parseActionChains error because load gkt, " + jSONObject.toString());
                                com.igexin.c.a.c.a.a("PushMessageExecutor|load task from db parseActionChains error because load gkt, " + jSONObject.toString(), new java.lang.Object[0]);
                            } else if (!com.igexin.push.core.e.ah.containsKey(strA)) {
                                com.igexin.push.core.e.ah.put(strA, pushTaskBean);
                            }
                        }
                    } catch (org.json.JSONException e) {
                        com.igexin.c.a.c.a.a(e);
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
        if (cursorA != null) {
        }
        return com.igexin.push.core.e.ah.isEmpty();
    }
}
