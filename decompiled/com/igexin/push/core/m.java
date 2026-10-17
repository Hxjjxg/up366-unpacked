package com.igexin.push.core;

import com.igexin.push.config.a.AnonymousClass3;
import com.igexin.push.config.a.AnonymousClass4;
import com.igexin.push.core.e.f.AnonymousClass27;
import com.igexin.push.core.e.f.AnonymousClass28;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class m {
    private static final java.lang.String a = "PushController";
    private static com.igexin.push.core.m b;

    private m() {
    }

    public static com.igexin.push.core.m a() {
        if (b == null) {
            b = new com.igexin.push.core.m();
        }
        return b;
    }

    private static void a(int i) {
        com.igexin.push.config.d.e = i;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass3(), false, true);
        if (com.igexin.push.core.e.u) {
            java.lang.System.currentTimeMillis();
            com.igexin.c.a.c.a.a("setHeartbeatInterval heartbeatReq", new java.lang.Object[0]);
            if (java.lang.System.currentTimeMillis() - com.igexin.push.core.e.Y > com.igexin.push.config.c.s) {
                com.igexin.push.core.e.Y = java.lang.System.currentTimeMillis();
                com.igexin.push.core.a.b.d();
                com.igexin.push.core.a.b.f();
            }
        }
    }

    public static void a(int i, int i2) {
        com.igexin.push.config.d.b = i;
        com.igexin.push.config.d.c = i2;
        com.igexin.push.config.a.a().b();
        com.igexin.push.f.f.a().c();
        com.igexin.c.a.c.a.d.a().a("[PushController] setSilentTime success");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v7 */
    private static void a(android.os.Bundle bundle) {
        int i;
        int i2;
        java.lang.String string = bundle.getString("action");
        com.igexin.c.a.c.a.a("PushController|action pushmanager action = ".concat(java.lang.String.valueOf(string)), new java.lang.Object[0]);
        if (android.text.TextUtils.isEmpty(string)) {
        }
        string.hashCode();
        byte b2 = -1;
        switch (string.hashCode()) {
            case -1710807787:
                if (string.equals("queryPushOnLine")) {
                    b2 = 0;
                }
                break;
            case -1673882831:
                if (string.equals("setVivoBadgeNum")) {
                    b2 = 1;
                }
                break;
            case -1411528570:
                if (string.equals("setNotificationIcon")) {
                    b2 = 2;
                }
                break;
            case -1166665294:
                if (string.equals(com.igexin.sdk.PushConsts.QUERY_TAG)) {
                    b2 = 3;
                }
                break;
            case -1092138459:
                if (string.equals("setOppoBadgeNum")) {
                    b2 = 4;
                }
                break;
            case -957964269:
                if (string.equals("bindAlias")) {
                    b2 = 5;
                }
                break;
            case -908867308:
                if (string.equals("setHwBadgeNum")) {
                    b2 = 6;
                }
                break;
            case -905799720:
                if (string.equals("setTag")) {
                    b2 = 7;
                }
                break;
            case -889524838:
                if (string.equals("unbindAlias")) {
                    b2 = 8;
                }
                break;
            case -850755092:
                if (string.equals("turnOffPush")) {
                    b2 = 9;
                }
                break;
            case -479268212:
                if (string.equals("registerPushActivity")) {
                    b2 = 10;
                }
                break;
            case -344351336:
                if (string.equals("sendApplinkFeedback")) {
                    b2 = com.igexin.push.core.b.n.l;
                }
                break;
            case -159289499:
                if (string.equals("setBadgeNum")) {
                    b2 = 12;
                }
                break;
            case -101965284:
                if (string.equals("setLinkMerge")) {
                    b2 = 13;
                }
                break;
            case -12797509:
                if (string.equals("setGuardOptions")) {
                    b2 = 14;
                }
                break;
            case 329771905:
                if (string.equals("setDeviceToken")) {
                    b2 = 15;
                }
                break;
            case 495464132:
                if (string.equals("setSilentTime")) {
                    b2 = 16;
                }
                break;
            case 539767084:
                if (string.equals("setSocketTimeout")) {
                    b2 = 17;
                }
                break;
            case 556182983:
                if (string.equals("registerUserService")) {
                    b2 = 18;
                }
                break;
            case 691453791:
                if (string.equals("sendMessage")) {
                    b2 = 19;
                }
                break;
            case 999002527:
                if (string.equals("setHeartbeatInterval")) {
                    b2 = 20;
                }
                break;
            case 1809534414:
                if (string.equals("setFenceLabels")) {
                    b2 = 21;
                }
                break;
            case 1841202202:
                if (string.equals("sendFeedbackMessage")) {
                    b2 = 22;
                }
                break;
        }
        switch (b2) {
            case 0:
                com.igexin.push.core.l.a().b();
                break;
            case 1:
                com.igexin.push.g.d.b(bundle.getInt("badgeNum"), true);
                break;
            case 2:
                com.igexin.push.core.e.aK = bundle.getString("smallIcon", "");
                com.igexin.push.core.e.aL = bundle.getString("largeIcon", "");
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass27(com.igexin.push.core.e.aK, com.igexin.push.core.e.aL), false, true);
                com.igexin.c.a.c.a.d.a().a("[PushController] setNotificationIcon success");
                break;
            case 3:
                java.lang.String string2 = bundle.getString("sn");
                if (!android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    if (java.lang.System.currentTimeMillis() - com.igexin.push.core.e.c < com.igexin.push.config.d.a * 1000 && com.igexin.push.core.e.d != null) {
                        java.lang.String str = com.igexin.push.core.e.d;
                        com.igexin.c.a.c.a.a("PushController|query tag already cache, tag = " + com.igexin.push.core.e.d, new java.lang.Object[0]);
                        com.igexin.push.core.l.a().a(string2, "0", com.igexin.push.core.e.d);
                    } else {
                        try {
                            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                            org.json.JSONObject jSONObject = new org.json.JSONObject();
                            try {
                                jSONObject.put("action", "query_tag");
                                jSONObject.put(com.igexin.push.core.b.C, java.lang.String.valueOf(jCurrentTimeMillis));
                                jSONObject.put("cid", com.igexin.push.core.e.A);
                                jSONObject.put("appid", com.igexin.push.core.e.a);
                                jSONObject.put("sn", string2);
                            } catch (java.lang.Exception e) {
                                com.igexin.c.a.c.a.a(e);
                            }
                            java.lang.String string3 = jSONObject.toString();
                            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.n(jCurrentTimeMillis, string3, com.igexin.push.core.b.n.l, jCurrentTimeMillis));
                            com.igexin.push.d.c.o oVar = new com.igexin.push.d.c.o();
                            oVar.c = 128;
                            oVar.e = com.igexin.push.core.b.O;
                            oVar.f = string3;
                            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, oVar, false);
                            com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
                            if (com.igexin.push.core.e.c != jCurrentTimeMillis) {
                                com.igexin.push.core.e.c = jCurrentTimeMillis;
                                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass28(), false, true);
                            }
                            com.igexin.c.a.c.a.a("PushController｜queryTag", new java.lang.Object[0]);
                        } catch (java.lang.Exception e2) {
                            com.igexin.c.a.c.a.a(e2);
                            return;
                        }
                    }
                }
                break;
            case 4:
                com.igexin.push.g.d.c(bundle.getInt("badgeNum"), true);
                break;
            case 5:
                java.lang.String string4 = bundle.getString("alias");
                java.lang.String string5 = bundle.getString("sn");
                com.igexin.c.a.c.a.a("PushController|onPushManagerMessage bindAlias...", new java.lang.Object[0]);
                if (!android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
                    long j = com.igexin.push.core.e.aa;
                    if (jCurrentTimeMillis2 - com.igexin.push.core.e.aa <= 1000) {
                        com.igexin.c.a.c.a.a("PushController|bindAlias frequently called", new java.lang.Object[0]);
                    } else {
                        java.lang.String str2 = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date(jCurrentTimeMillis2));
                        if (com.igexin.push.core.e.Z != null) {
                            java.lang.String str3 = com.igexin.push.core.e.Z;
                        }
                        if (str2.equals(com.igexin.push.core.e.Z)) {
                            i = 0;
                        } else {
                            com.igexin.push.core.e.f.a().d(str2);
                            i = 0;
                            com.igexin.push.core.e.f.a().a(0);
                        }
                        int i3 = com.igexin.push.core.e.ab;
                        com.igexin.c.a.c.a.a("-> CoreRuntimeInfo.opAliasTimes:" + com.igexin.push.core.e.ab, new java.lang.Object[i]);
                        if (com.igexin.push.core.e.ab >= 100) {
                            com.igexin.c.a.c.a.a("PushController|bindAlias times exceed", new java.lang.Object[i]);
                            com.igexin.c.a.c.a.d.a().a("bindAlias : " + string4 + ", failed, , the number of calls per day cannot exceed 100");
                            com.igexin.push.core.l.a().b(string5, "30003");
                        } else {
                            com.igexin.c.a.c.a.a("start bindAlias ###", new java.lang.Object[i]);
                            com.igexin.push.core.e.aa = jCurrentTimeMillis2;
                            com.igexin.push.core.e.f.a().a(com.igexin.push.core.e.ab + 1);
                            a(string4, string5, i, true);
                        }
                    }
                } else {
                    com.igexin.c.a.c.a.d.a().a("bindAlias : " + string4 + ", failed, has not get clientid");
                    com.igexin.push.core.l.a().b(string5, "30005");
                }
                break;
            case 6:
                com.igexin.push.g.d.a(bundle.getInt("badgeNum"), true);
                break;
            case 7:
                boolean z = com.igexin.push.config.d.k;
                if (com.igexin.push.config.d.k) {
                    java.lang.String string6 = bundle.getString("tags");
                    java.lang.String string7 = bundle.getString("sn");
                    if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                        com.igexin.c.a.c.a.d.a().a("setTag : " + string6 + ", failed, has not get clientid");
                        com.igexin.push.core.l.a().a(string7, "20008");
                    } else {
                        try {
                            long jCurrentTimeMillis3 = java.lang.System.currentTimeMillis();
                            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                            try {
                                jSONObject2.put("action", "set_tag");
                                jSONObject2.put(com.igexin.push.core.b.C, java.lang.String.valueOf(jCurrentTimeMillis3));
                                jSONObject2.put("cid", com.igexin.push.core.e.A);
                                jSONObject2.put("appid", com.igexin.push.core.e.a);
                                jSONObject2.put("tags", java.net.URLEncoder.encode(string6, com.igexin.push.g.s.b));
                                jSONObject2.put("sn", string7);
                            } catch (java.lang.Exception e3) {
                                com.igexin.c.a.c.a.a(e3);
                            }
                            com.igexin.push.core.e.e = string6.replaceAll(com.igexin.push.core.b.an, " ");
                            java.lang.String string8 = jSONObject2.toString();
                            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.n(jCurrentTimeMillis3, string8, (byte) 2, com.igexin.push.core.e.u ? jCurrentTimeMillis3 : 0L));
                            com.igexin.push.d.c.o oVar2 = new com.igexin.push.d.c.o();
                            oVar2.c = 128;
                            oVar2.e = com.igexin.push.core.b.O;
                            oVar2.f = string8;
                            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, oVar2, false);
                            com.igexin.c.a.c.a.a("settag", new java.lang.Object[0]);
                        } catch (java.lang.Exception e4) {
                            com.igexin.c.a.c.a.a(e4);
                            return;
                        }
                    }
                }
                break;
            case 8:
                java.lang.String string9 = bundle.getString("alias");
                java.lang.String string10 = bundle.getString("sn");
                boolean z2 = bundle.getBoolean("isSeft");
                com.igexin.c.a.c.a.a("PushController|onPushManagerMessage unbindAlias...", new java.lang.Object[0]);
                if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    com.igexin.c.a.c.a.d.a().a("unbindAlias : " + string9 + ", failed, has not get clientid");
                    com.igexin.push.core.l.a().c(string10, "30005");
                } else if (!z2 || !android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    long jCurrentTimeMillis4 = java.lang.System.currentTimeMillis();
                    long j2 = com.igexin.push.core.e.aa;
                    if (jCurrentTimeMillis4 - com.igexin.push.core.e.aa <= 1000) {
                        com.igexin.c.a.c.a.a("PushController|unbindAlias frequently called", new java.lang.Object[0]);
                    } else {
                        java.lang.String str4 = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date(jCurrentTimeMillis4));
                        java.lang.String str5 = com.igexin.push.core.e.Z;
                        if (str4.equals(com.igexin.push.core.e.Z)) {
                            i2 = 0;
                        } else {
                            com.igexin.push.core.e.f.a().d(str4);
                            i2 = 0;
                            com.igexin.push.core.e.f.a().a(0);
                        }
                        int i4 = com.igexin.push.core.e.ab;
                        if (com.igexin.push.core.e.ab >= 100) {
                            com.igexin.c.a.c.a.a("PushController|unbindAlias times exceed", new java.lang.Object[i2]);
                            com.igexin.c.a.c.a.d.a().a("unbindAlias : " + string9 + ", failed, , the number of calls per day cannot exceed 100");
                            com.igexin.push.core.l.a().c(string10, "30003");
                        } else {
                            com.igexin.c.a.c.a.a("start unbindAlias ###", new java.lang.Object[i2]);
                            com.igexin.push.core.e.aa = jCurrentTimeMillis4;
                            com.igexin.push.core.e.f.a().a(com.igexin.push.core.e.ab + 1);
                            a(string9, string10, true, z2);
                        }
                    }
                }
                break;
            case 9:
                com.igexin.push.core.d dVar = com.igexin.push.core.d.a.a;
                if (com.igexin.push.core.e.l != null) {
                    com.igexin.push.core.d.d.a().a(com.igexin.push.core.d.d.f, java.lang.Boolean.FALSE);
                    com.igexin.push.core.e.s = false;
                    com.igexin.push.core.e.v = false;
                    dVar.h.b();
                }
                com.igexin.assist.sdk.AssistPushManager.getInstance().turnOffPush(com.igexin.push.core.e.l);
                break;
            case 10:
            case 18:
                com.igexin.push.core.e.a();
                break;
            case 11:
                java.lang.String string11 = bundle.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
                boolean z3 = com.igexin.push.config.d.E;
                if (!android.text.TextUtils.isEmpty(string11)) {
                    try {
                        android.net.Uri uri = android.net.Uri.parse(string11);
                        java.lang.String host = uri.getHost();
                        java.lang.String queryParameter = uri.getQueryParameter(com.igexin.push.core.d.d.f);
                        if (!android.text.TextUtils.isEmpty(host) && !android.text.TextUtils.isEmpty(queryParameter)) {
                            if (!com.igexin.push.config.d.E) {
                                com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is false, not feedback", new java.lang.Object[0]);
                            } else if (!com.igexin.push.g.c.c(host)) {
                                com.igexin.c.a.c.a.a("PushController|checkIsWhiteApplinkDomain is false, not feedback", new java.lang.Object[0]);
                            } else {
                                com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is true and checkIsWhiteApplinkDomain is true, to feedback", new java.lang.Object[0]);
                                com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
                                pushTaskBean.setTaskId("getuiapplinkup");
                                pushTaskBean.setMessageId(queryParameter);
                                pushTaskBean.setAppid(com.igexin.push.core.e.a);
                                com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, com.igexin.sdk.PushConsts.SEND_MESSAGE_ERROR);
                            }
                        }
                        com.igexin.c.a.c.a.a("PushController|url " + string11 + " is invalid", new java.lang.Object[0]);
                    } catch (java.lang.Exception e5) {
                        com.igexin.c.a.c.a.a(e5);
                        com.igexin.c.a.c.a.a("PushController|" + e5.toString(), new java.lang.Object[0]);
                        return;
                    }
                }
                break;
            case 12:
                if (com.igexin.push.g.o.d().equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_HW) || com.igexin.push.g.o.d().equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_HON)) {
                    com.igexin.push.g.d.a(bundle.getInt("badgeNum"), true);
                } else if (com.igexin.push.g.o.d().equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_OPPO)) {
                    com.igexin.push.g.d.c(bundle.getInt("badgeNum"), true);
                } else if (com.igexin.push.g.o.d().equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_VIVO)) {
                    com.igexin.push.g.d.b(bundle.getInt("badgeNum"), true);
                }
                break;
            case 13:
                boolean z4 = bundle.getBoolean("enable", true);
                com.igexin.push.config.e.a(z4, z4);
                com.igexin.push.core.e.a();
                com.igexin.c.a.c.a.d.a().a("[PushController] setLinkMerge success");
                break;
            case 14:
                com.igexin.push.config.e.a(bundle.getBoolean("guardMe", true), bundle.getBoolean("guardOthers", true));
                com.igexin.push.core.e.a();
                com.igexin.c.a.c.a.d.a().a("[PushController] setGuardOptions success");
                break;
            case 15:
                try {
                    java.lang.String string12 = bundle.getString(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_TOKEN, "");
                    if (!android.text.TextUtils.isEmpty(string12) && com.igexin.push.core.e.b().booleanValue() && !string12.equals(com.igexin.push.core.e.I)) {
                        com.igexin.push.core.e.f.a().b(string12);
                        if (com.igexin.push.core.e.u) {
                            com.igexin.c.a.c.a.b(a, "online, send addphoneinfo");
                            com.igexin.push.core.a.b.d().i();
                        }
                    }
                    com.igexin.c.a.c.a.d.a().a("[PushController] setDeviceToken success ".concat(java.lang.String.valueOf(string12)));
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                    return;
                }
                break;
            case 16:
                boolean z5 = com.igexin.push.config.d.l;
                if (com.igexin.push.config.d.l) {
                    int i5 = bundle.getInt("beginHour", 0);
                    int i6 = bundle.getInt("duration", 0);
                    com.igexin.push.core.e.l.getPackageName();
                    a(i5, i6);
                    com.igexin.assist.sdk.AssistPushManager.getInstance().setSilentTime(com.igexin.push.core.e.l, i5, i6);
                }
                break;
            case 17:
                boolean z6 = com.igexin.push.config.d.n;
                if (com.igexin.push.config.d.n) {
                    int i7 = bundle.getInt("submitTimeoutEvent", 0);
                    com.igexin.push.core.e.l.getPackageName();
                    com.igexin.push.config.d.f = i7;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass4(), false, true);
                }
                break;
            case 19:
                boolean z7 = com.igexin.push.config.d.j;
                com.igexin.c.a.c.a.a("PushController onPushManagerMessage recevie action : sendMessage", new java.lang.Object[0]);
                if (com.igexin.push.config.d.j) {
                    java.lang.String string13 = bundle.getString("taskid");
                    byte[] byteArray = bundle.getByteArray("extraData");
                    com.igexin.c.a.c.a.a("PushController receive broadcast msg data , task id : " + string13 + " ######@##@@@#", new java.lang.Object[0]);
                    if (com.igexin.push.core.e.A != null) {
                        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                        long jCurrentTimeMillis5 = java.lang.System.currentTimeMillis();
                        try {
                            jSONObject3.put("action", "sendmessage");
                            jSONObject3.put(com.igexin.push.core.b.C, java.lang.String.valueOf(jCurrentTimeMillis5));
                            jSONObject3.put("cid", com.igexin.push.core.e.A);
                            jSONObject3.put("appid", com.igexin.push.core.e.a);
                            jSONObject3.put("taskid", string13);
                            jSONObject3.put("extraData", android.util.Base64.encodeToString(byteArray, 0));
                            java.lang.String string14 = jSONObject3.toString();
                            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.n(jCurrentTimeMillis5, string14, (byte) 6, jCurrentTimeMillis5));
                            com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                            bVar.c = 128;
                            bVar.b = (int) jCurrentTimeMillis5;
                            bVar.e = com.igexin.push.core.e.A;
                            bVar.f = string14;
                            bVar.g = byteArray;
                            bVar.h = com.igexin.push.core.e.A;
                            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
                            if (string13 != null && string13.startsWith("4T5@S_")) {
                                com.igexin.c.a.c.a.a("PushController sending lbs report message : ".concat(java.lang.String.valueOf(string14)), new java.lang.Object[0]);
                                break;
                            }
                        } catch (java.lang.Throwable th2) {
                            com.igexin.c.a.c.a.a(th2);
                            return;
                        }
                    }
                }
                break;
            case 20:
                boolean z8 = com.igexin.push.config.d.m;
                if (com.igexin.push.config.d.m) {
                    int i8 = bundle.getInt("interval", 0);
                    com.igexin.push.core.e.l.getPackageName();
                    com.igexin.push.config.d.e = i8;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass3(), false, true);
                    if (com.igexin.push.core.e.u) {
                        java.lang.System.currentTimeMillis();
                        com.igexin.c.a.c.a.a("setHeartbeatInterval heartbeatReq", new java.lang.Object[0]);
                        if (java.lang.System.currentTimeMillis() - com.igexin.push.core.e.Y > com.igexin.push.config.c.s) {
                            com.igexin.push.core.e.Y = java.lang.System.currentTimeMillis();
                            com.igexin.push.core.a.b.d();
                            com.igexin.push.core.a.b.f();
                        }
                    }
                }
                break;
            case 21:
                if (!android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    com.igexin.push.g.i.a(com.igexin.push.core.e.l, com.igexin.push.core.e.g, com.igexin.push.core.e.aO, bundle.getString("labels"));
                } else {
                    com.igexin.c.a.c.a.d.a().a("set fence labels failed, has not get clientid");
                    com.igexin.push.core.l.a().b("40008");
                }
                break;
            case 22:
                boolean z9 = com.igexin.push.config.d.o;
                int i9 = com.igexin.push.core.e.am;
                if (com.igexin.push.config.d.o && com.igexin.push.core.e.am <= 200) {
                    java.lang.String string15 = bundle.getString("taskid");
                    java.lang.String string16 = bundle.getString("messageid");
                    java.lang.String string17 = bundle.getString("actionid");
                    java.lang.String str6 = string15 + ":" + string16 + ":" + string17;
                    if (com.igexin.push.core.e.al.get(str6) == null) {
                        long jCurrentTimeMillis6 = java.lang.System.currentTimeMillis();
                        com.igexin.push.extension.mod.PushTaskBean pushTaskBean2 = new com.igexin.push.extension.mod.PushTaskBean();
                        pushTaskBean2.setTaskId(string15);
                        pushTaskBean2.setMessageId(string16);
                        pushTaskBean2.setAppid(com.igexin.push.core.e.a);
                        com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean2, string17);
                        com.igexin.push.core.e.am++;
                        com.igexin.push.core.e.al.put(str6, java.lang.Long.valueOf(jCurrentTimeMillis6));
                    }
                    break;
                }
                break;
        }
    }

    private static void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            android.net.Uri uri = android.net.Uri.parse(str);
            java.lang.String host = uri.getHost();
            java.lang.String queryParameter = uri.getQueryParameter(com.igexin.push.core.d.d.f);
            if (!android.text.TextUtils.isEmpty(host) && !android.text.TextUtils.isEmpty(queryParameter)) {
                if (!com.igexin.push.config.d.E) {
                    com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is false, not feedback", new java.lang.Object[0]);
                    return;
                }
                if (!com.igexin.push.g.c.c(host)) {
                    com.igexin.c.a.c.a.a("PushController|checkIsWhiteApplinkDomain is false, not feedback", new java.lang.Object[0]);
                    return;
                }
                com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is true and checkIsWhiteApplinkDomain is true, to feedback", new java.lang.Object[0]);
                com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
                pushTaskBean.setTaskId("getuiapplinkup");
                pushTaskBean.setMessageId(queryParameter);
                pushTaskBean.setAppid(com.igexin.push.core.e.a);
                com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, com.igexin.sdk.PushConsts.SEND_MESSAGE_ERROR);
                return;
            }
            com.igexin.c.a.c.a.a("PushController|url " + str + " is invalid", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a("PushController|" + e.toString(), new java.lang.Object[0]);
        }
    }

    private static void a(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            com.igexin.c.a.c.a.d.a().a("setTag : " + str + ", failed, has not get clientid");
            com.igexin.push.core.l.a().a(str2, "20008");
            return;
        }
        try {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("action", "set_tag");
                jSONObject.put(com.igexin.push.core.b.C, java.lang.String.valueOf(jCurrentTimeMillis));
                jSONObject.put("cid", com.igexin.push.core.e.A);
                jSONObject.put("appid", com.igexin.push.core.e.a);
                jSONObject.put("tags", java.net.URLEncoder.encode(str, com.igexin.push.g.s.b));
                jSONObject.put("sn", str2);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            com.igexin.push.core.e.e = str.replaceAll(com.igexin.push.core.b.an, " ");
            java.lang.String string = jSONObject.toString();
            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.n(jCurrentTimeMillis, string, (byte) 2, com.igexin.push.core.e.u ? jCurrentTimeMillis : 0L));
            com.igexin.push.d.c.o oVar = new com.igexin.push.d.c.o();
            oVar.c = 128;
            oVar.e = com.igexin.push.core.b.O;
            oVar.f = string;
            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, oVar, false);
            com.igexin.c.a.c.a.a("settag", new java.lang.Object[0]);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static void a(java.lang.String str, java.lang.String str2, boolean z) {
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            com.igexin.c.a.c.a.d.a().a("unbindAlias : " + str + ", failed, has not get clientid");
            com.igexin.push.core.l.a().c(str2, "30005");
            return;
        }
        if (z && android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            return;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long j = com.igexin.push.core.e.aa;
        if (jCurrentTimeMillis - com.igexin.push.core.e.aa <= 1000) {
            com.igexin.c.a.c.a.a("PushController|unbindAlias frequently called", new java.lang.Object[0]);
            return;
        }
        java.lang.String str3 = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date(jCurrentTimeMillis));
        java.lang.String str4 = com.igexin.push.core.e.Z;
        if (!str3.equals(com.igexin.push.core.e.Z)) {
            com.igexin.push.core.e.f.a().d(str3);
            com.igexin.push.core.e.f.a().a(0);
        }
        int i = com.igexin.push.core.e.ab;
        if (com.igexin.push.core.e.ab < 100) {
            com.igexin.c.a.c.a.a("start unbindAlias ###", new java.lang.Object[0]);
            com.igexin.push.core.e.aa = jCurrentTimeMillis;
            com.igexin.push.core.e.f.a().a(com.igexin.push.core.e.ab + 1);
            a(str, str2, true, z);
            return;
        }
        com.igexin.c.a.c.a.a("PushController|unbindAlias times exceed", new java.lang.Object[0]);
        com.igexin.c.a.c.a.d.a().a("unbindAlias : " + str + ", failed, , the number of calls per day cannot exceed 100");
        com.igexin.push.core.l.a().c(str2, "30003");
    }

    public static void a(java.lang.String str, java.lang.String str2, boolean z, boolean z2) {
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            return;
        }
        try {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            java.lang.String str3 = z ? "unbind_alias" : "bind_alias";
            byte b2 = z ? (byte) 8 : (byte) 7;
            try {
                jSONObject.put("action", str3);
                jSONObject.put(com.igexin.push.core.b.C, java.lang.String.valueOf(jCurrentTimeMillis));
                jSONObject.put("cid", com.igexin.push.core.e.A);
                jSONObject.put("appid", com.igexin.push.core.e.a);
                jSONObject.put("alias", str);
                jSONObject.put("sn", str2);
                if (z) {
                    jSONObject.put("is_self", z2);
                }
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            java.lang.String string = jSONObject.toString();
            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.n(jCurrentTimeMillis, string, b2, com.igexin.push.core.e.u ? jCurrentTimeMillis : 0L));
            com.igexin.push.d.c.o oVar = new com.igexin.push.d.c.o();
            oVar.c = 128;
            oVar.e = com.igexin.push.core.b.O;
            oVar.f = string;
            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, oVar, false);
            com.igexin.c.a.c.a.a(str3 + " = " + string, new java.lang.Object[0]);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static void a(java.lang.String str, byte[] bArr) {
        if (com.igexin.push.core.e.A != null) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            try {
                jSONObject.put("action", "sendmessage");
                jSONObject.put(com.igexin.push.core.b.C, java.lang.String.valueOf(jCurrentTimeMillis));
                jSONObject.put("cid", com.igexin.push.core.e.A);
                jSONObject.put("appid", com.igexin.push.core.e.a);
                jSONObject.put("taskid", str);
                jSONObject.put("extraData", android.util.Base64.encodeToString(bArr, 0));
                java.lang.String string = jSONObject.toString();
                com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.n(jCurrentTimeMillis, string, (byte) 6, jCurrentTimeMillis));
                com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                bVar.c = 128;
                bVar.b = (int) jCurrentTimeMillis;
                bVar.e = com.igexin.push.core.e.A;
                bVar.f = string;
                bVar.g = bArr;
                bVar.h = com.igexin.push.core.e.A;
                com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, bVar, false);
                if (str == null || !str.startsWith("4T5@S_")) {
                    return;
                }
                com.igexin.c.a.c.a.a("PushController sending lbs report message : ".concat(java.lang.String.valueOf(string)), new java.lang.Object[0]);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    private static void b(int i) {
        com.igexin.push.config.d.f = i;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass4(), false, true);
    }

    private static void b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            return;
        }
        if (java.lang.System.currentTimeMillis() - com.igexin.push.core.e.c < com.igexin.push.config.d.a * 1000 && com.igexin.push.core.e.d != null) {
            java.lang.String str2 = com.igexin.push.core.e.d;
            com.igexin.c.a.c.a.a("PushController|query tag already cache, tag = " + com.igexin.push.core.e.d, new java.lang.Object[0]);
            com.igexin.push.core.l.a().a(str, "0", com.igexin.push.core.e.d);
            return;
        }
        try {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("action", "query_tag");
                jSONObject.put(com.igexin.push.core.b.C, java.lang.String.valueOf(jCurrentTimeMillis));
                jSONObject.put("cid", com.igexin.push.core.e.A);
                jSONObject.put("appid", com.igexin.push.core.e.a);
                jSONObject.put("sn", str);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            java.lang.String string = jSONObject.toString();
            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.n(jCurrentTimeMillis, string, com.igexin.push.core.b.n.l, jCurrentTimeMillis));
            com.igexin.push.d.c.o oVar = new com.igexin.push.d.c.o();
            oVar.c = 128;
            oVar.e = com.igexin.push.core.b.O;
            oVar.f = string;
            com.igexin.push.core.d.a.a.h.a("C-" + com.igexin.push.core.e.A, oVar, false);
            com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
            if (com.igexin.push.core.e.c != jCurrentTimeMillis) {
                com.igexin.push.core.e.c = jCurrentTimeMillis;
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass28(), false, true);
            }
            com.igexin.c.a.c.a.a("PushController｜queryTag", new java.lang.Object[0]);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static void b(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.A)) {
            com.igexin.c.a.c.a.d.a().a("bindAlias : " + str + ", failed, has not get clientid");
            com.igexin.push.core.l.a().b(str2, "30005");
            return;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        long j = com.igexin.push.core.e.aa;
        if (jCurrentTimeMillis - com.igexin.push.core.e.aa <= 1000) {
            com.igexin.c.a.c.a.a("PushController|bindAlias frequently called", new java.lang.Object[0]);
            return;
        }
        java.lang.String str3 = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).format(new java.util.Date(jCurrentTimeMillis));
        if (com.igexin.push.core.e.Z != null) {
            java.lang.String str4 = com.igexin.push.core.e.Z;
        }
        if (!str3.equals(com.igexin.push.core.e.Z)) {
            com.igexin.push.core.e.f.a().d(str3);
            com.igexin.push.core.e.f.a().a(0);
        }
        int i = com.igexin.push.core.e.ab;
        com.igexin.c.a.c.a.a("-> CoreRuntimeInfo.opAliasTimes:" + com.igexin.push.core.e.ab, new java.lang.Object[0]);
        if (com.igexin.push.core.e.ab < 100) {
            com.igexin.c.a.c.a.a("start bindAlias ###", new java.lang.Object[0]);
            com.igexin.push.core.e.aa = jCurrentTimeMillis;
            com.igexin.push.core.e.f.a().a(com.igexin.push.core.e.ab + 1);
            a(str, str2, false, true);
            return;
        }
        com.igexin.c.a.c.a.a("PushController|bindAlias times exceed", new java.lang.Object[0]);
        com.igexin.c.a.c.a.d.a().a("bindAlias : " + str + ", failed, , the number of calls per day cannot exceed 100");
        com.igexin.push.core.l.a().b(str2, "30003");
    }
}
