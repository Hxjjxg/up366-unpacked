package com.igexin.push.core.a.c;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class h implements com.igexin.push.extension.mod.PushMessageInterface {
    private static final java.lang.String a = com.igexin.push.core.b.f + com.igexin.push.core.a.c.h.class.getName();
    private static final int b = 131;
    private static final java.lang.String c = "push_small";

    /* JADX INFO: renamed from: com.igexin.push.core.a.c.h$2, reason: invalid class name */
    final class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.app.NotificationManager a;
        final /* synthetic */ int b;
        final /* synthetic */ com.igexin.push.extension.mod.PushTaskBean c;

        AnonymousClass2(android.app.NotificationManager notificationManager, int i, com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
            this.a = notificationManager;
            this.b = i;
            this.c = pushTaskBean;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                android.service.notification.StatusBarNotification[] activeNotifications = this.a.getActiveNotifications();
                if (activeNotifications != null && activeNotifications.length > 0) {
                    for (android.service.notification.StatusBarNotification statusBarNotification : activeNotifications) {
                        if (statusBarNotification.getId() == this.b) {
                            return;
                        }
                    }
                }
                java.lang.String unused = com.igexin.push.core.a.c.h.a;
                com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(this.c, "10160", "show notification failed");
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    enum a {
        UNSET(0),
        BIG_IMAGE(1),
        LONG_TEXT(2),
        PURE_IMAGE(3);

        int e;

        a(int i) {
            this.e = i;
        }

        private int a() {
            return this.e;
        }
    }

    private static int a(com.igexin.push.core.b.l lVar, boolean z) {
        int identifier = 0;
        if (!z) {
            if (!android.text.TextUtils.isEmpty(com.igexin.push.core.e.aL) && (identifier = com.igexin.push.core.e.l.getResources().getIdentifier(com.igexin.push.core.e.aL, "drawable", com.igexin.push.core.e.g)) == 0) {
                identifier = com.igexin.push.core.e.l.getResources().getIdentifier(com.igexin.push.core.e.aL, "mipmap", com.igexin.push.core.e.g);
            }
            int identifier2 = com.igexin.push.core.e.l.getResources().getIdentifier("push", "drawable", com.igexin.push.core.e.g);
            if (identifier2 == 0) {
                identifier2 = com.igexin.push.core.e.l.getResources().getIdentifier("push", "mipmap", com.igexin.push.core.e.g);
            }
            if (android.text.TextUtils.isEmpty(lVar.f) || com.igexin.push.core.b.m.equals(lVar.f)) {
                return identifier > 0 ? identifier : identifier2;
            }
            if (lVar.f.startsWith("@")) {
                java.lang.String str = lVar.f;
                return str.substring(1, str.length()).endsWith("email") ? android.R.drawable.sym_action_email : android.R.drawable.sym_def_app_icon;
            }
            int identifier3 = com.igexin.push.core.e.l.getResources().getIdentifier(lVar.f, "drawable", com.igexin.push.core.e.g);
            if (identifier3 == 0) {
                identifier3 = com.igexin.push.core.e.l.getResources().getIdentifier(lVar.f, "mipmap", com.igexin.push.core.e.g);
            }
            return identifier3 > 0 ? identifier3 : identifier > 0 ? identifier : identifier2;
        }
        if (!android.text.TextUtils.isEmpty(com.igexin.push.core.e.aK)) {
            int identifier4 = com.igexin.push.core.e.l.getResources().getIdentifier(com.igexin.push.core.e.aK, "drawable", com.igexin.push.core.e.g);
            if (identifier4 == 0) {
                identifier4 = com.igexin.push.core.e.l.getResources().getIdentifier(com.igexin.push.core.e.aK, "mipmap", com.igexin.push.core.e.g);
            }
            if (identifier4 > 0) {
                return identifier4;
            }
        }
        int identifier5 = com.igexin.push.core.e.l.getResources().getIdentifier(c, "drawable", com.igexin.push.core.e.g);
        if (identifier5 == 0) {
            identifier5 = com.igexin.push.core.e.l.getResources().getIdentifier(c, "mipmap", com.igexin.push.core.e.g);
        }
        if (identifier5 != 0) {
            com.igexin.c.a.c.a.a(a + "|push_small.png is set, use default push_small", new java.lang.Object[0]);
            return identifier5;
        }
        java.lang.String str2 = a;
        com.igexin.c.a.c.a.a(str2, "|push_small.png is missing");
        com.igexin.c.a.c.a.a(str2 + "|push_small.png is missing", new java.lang.Object[0]);
        return com.igexin.push.core.e.l.getApplicationInfo().icon;
    }

    private static int a(java.lang.String str) {
        int iCharAt = 0;
        for (int i = 0; i != str.length(); i++) {
            iCharAt = (iCharAt * b) + str.charAt(i);
        }
        if (iCharAt == Integer.MIN_VALUE) {
            iCharAt = 1;
        }
        return java.lang.Math.abs(iCharAt);
    }

    private static android.app.Notification a(java.lang.String str, int i, com.igexin.push.core.b.l lVar) {
        android.app.Notification.Builder builder;
        if (android.text.TextUtils.isEmpty(str) || com.igexin.push.core.e.aj.containsKey(str) || android.os.Build.VERSION.SDK_INT < 24) {
            return null;
        }
        com.igexin.push.core.e.aj.put(str, new java.util.HashSet<>());
        android.app.PendingIntent pendingIntentB = b(str);
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            builder = new android.app.Notification.Builder(com.igexin.push.core.e.l);
            android.app.NotificationManager notificationManager = (android.app.NotificationManager) com.igexin.push.core.e.l.getSystemService(com.igexin.push.core.b.n);
            try {
                java.lang.reflect.Constructor<?> constructor = java.lang.Class.forName("android.app.NotificationChannel").getConstructor(java.lang.String.class, java.lang.CharSequence.class, java.lang.Integer.TYPE);
                java.lang.Class<?> cls = notificationManager.getClass();
                if (((android.os.Parcelable) cls.getMethod("getNotificationChannel", java.lang.String.class).invoke(notificationManager, lVar.j)) == null) {
                    cls.getMethod("createNotificationChannel", java.lang.Class.forName("android.app.NotificationChannel")).invoke(notificationManager, (android.os.Parcelable) constructor.newInstance(lVar.j, lVar.k, java.lang.Integer.valueOf(lVar.l)));
                }
                builder.getClass().getMethod("setChannelId", java.lang.String.class).invoke(builder, lVar.j);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        } else {
            builder = new android.app.Notification.Builder(com.igexin.push.core.e.l);
        }
        android.app.Notification notificationBuild = builder.setContentTitle("summary").setContentText("summary").setDeleteIntent(pendingIntentB).setAutoCancel(false).setGroup(str).setSmallIcon(i).setGroupSummary(true).build();
        if (android.text.TextUtils.isEmpty(lVar.w)) {
            return notificationBuild;
        }
        builder.setCategory(lVar.w);
        return notificationBuild;
    }

    private static android.app.PendingIntent a(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, int i2, com.igexin.push.core.b.l lVar) {
        android.content.Intent intent = new android.content.Intent();
        intent.putExtra("taskid", str2);
        intent.putExtra("messageid", str3);
        intent.putExtra("appid", com.igexin.push.core.e.a);
        intent.putExtra("actionid", lVar.getDoActionId());
        intent.putExtra("accesstoken", com.igexin.push.core.e.aC);
        intent.putExtra("notifID", i2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(lVar.h);
        intent.putExtra("notifyStyle", sb.toString());
        intent.putExtra(com.igexin.push.core.b.C, lVar.y);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(lVar.C);
        intent.putExtra("bigStyle", sb2.toString());
        intent.putExtra("isFloat", false);
        intent.putExtra("checkpackage", com.igexin.push.core.e.l.getPackageName());
        intent.putExtra("feedbackid", lVar.getActionId().substring(lVar.getActionId().length() - 1));
        java.lang.String str4 = lVar.a;
        if (str4 == null) {
            str4 = "";
        }
        intent.putExtra("title", str4);
        java.lang.String str5 = lVar.b;
        if (str5 == null) {
            str5 = "";
        }
        intent.putExtra(com.igexin.sdk.FlymePushReceiver.CONTENT, str5);
        intent.putExtra("redisplayFreq", i);
        intent.putExtra("groupId", str);
        java.lang.String str6 = lVar.t;
        if (str6 == null) {
            str6 = "";
        }
        intent.putExtra(com.up366.mobile.commonui.CommonWebViewActivity.URL, str6);
        java.lang.String str7 = lVar.u;
        if (str7 == null) {
            str7 = "";
        }
        intent.putExtra("intentUri", str7);
        java.lang.String str8 = lVar.v;
        intent.putExtra(com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_PAYLOAD, str8 != null ? str8 : "");
        try {
            android.content.Intent intent2 = new android.content.Intent(com.igexin.push.core.e.l, (java.lang.Class<?>) com.igexin.sdk.GetuiActivity.class);
            intent2.setFlags(268435456);
            intent2.putExtra("action", "com.igexin.action.notification.click");
            intent2.putExtra("broadcast_intent", intent);
            return android.app.PendingIntent.getActivity(com.igexin.push.core.e.l, new java.util.Random().nextInt(1000), intent2, 201326592);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            android.content.Intent intent3 = new android.content.Intent("com.igexin.action.notification.click");
            intent3.setAction("com.igexin.action.notification.click");
            intent3.putExtra("action", "com.igexin.action.notification.click");
            intent3.putExtra("broadcast_intent", intent);
            return android.app.PendingIntent.getBroadcast(com.igexin.push.core.e.l, new java.util.Random().nextInt(1000), intent3, 201326592);
        }
    }

    private static android.app.PendingIntent a(java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.igexin.push.core.b.l lVar) {
        try {
            android.content.Context context = com.igexin.push.core.e.l;
            com.igexin.push.core.a.b.d();
            android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.igexin.push.core.a.b.a(com.igexin.push.core.e.l));
            intent.putExtra("taskid", str3);
            intent.putExtra("messageid", str4);
            intent.putExtra("appid", com.igexin.push.core.e.a);
            intent.putExtra("appkey", str2);
            intent.putExtra("actionid", lVar.getDoActionId());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(lVar.h);
            intent.putExtra("notifyStyle", sb.toString());
            intent.putExtra(com.igexin.push.core.b.C, lVar.y);
            intent.putExtra("feedbackid", lVar.getActionId().substring(lVar.getActionId().length() + (-1)));
            intent.putExtra("action", "com.igexin.action.notification.delete");
            intent.putExtra("redisplayFreq", i);
            intent.putExtra("groupId", str);
            return android.app.PendingIntent.getService(com.igexin.push.core.e.l, new java.util.Random().nextInt(1000), intent, (com.igexin.push.g.o.a(com.igexin.push.core.e.l) < 31 || android.os.Build.VERSION.SDK_INT < 30) ? 134217728 : 201326592);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a(a + "|getDelPendingIntent err：" + e.toString(), new java.lang.Object[0]);
            return null;
        }
    }

    private static android.graphics.Bitmap a(com.igexin.push.core.b.l lVar) {
        android.graphics.Bitmap bitmapA;
        java.lang.String str = lVar.D;
        if (android.text.TextUtils.isEmpty(str)) {
            bitmapA = null;
        } else {
            bitmapA = com.igexin.push.g.m.a(str);
            java.lang.String str2 = a;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("|use net logo bitmap is null = ");
            sb.append(bitmapA == null);
            com.igexin.c.a.c.a.a(str2, sb.toString());
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(str2);
            sb2.append("|use net logo bitmap is null = ");
            sb2.append(bitmapA == null);
            com.igexin.c.a.c.a.a(sb2.toString(), new java.lang.Object[0]);
        }
        if (bitmapA == null) {
            return android.graphics.BitmapFactory.decodeResource(com.igexin.push.core.e.l.getResources(), a(lVar, false));
        }
        return bitmapA;
    }

    private static void a(android.app.Notification notification) {
        if (com.igexin.push.g.a.b() || android.os.Build.VERSION.SDK_INT >= 24) {
            return;
        }
        try {
            java.lang.reflect.Field field = java.lang.Class.forName("com.android.internal.R$id").getField("right_icon");
            field.setAccessible(true);
            int i = field.getInt(null);
            if (notification.contentView != null) {
                notification.contentView.setViewVisibility(i, 8);
                notification.bigContentView.setViewVisibility(i, 8);
            }
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }

    private static void a(android.app.Notification notification, com.igexin.push.core.b.l lVar) {
        notification.defaults = 4;
        notification.ledARGB = -16711936;
        notification.ledOnMS = 1000;
        notification.ledOffMS = 3000;
        notification.flags = 1;
        notification.flags = lVar.e ? notification.flags | 16 : notification.flags | 32;
        if (lVar.c) {
            notification.defaults |= 2;
        }
        if (lVar.d) {
            if (android.text.TextUtils.isEmpty(lVar.p)) {
                notification.defaults |= 1;
            } else {
                notification.sound = c(lVar.p);
            }
        }
        if (lVar.o > 0) {
            com.igexin.push.g.d.a(lVar.o, false);
            com.igexin.push.g.d.c(lVar.o, false);
            com.igexin.push.g.d.b(lVar.o, false);
        }
        notification.icon = a(lVar, true);
    }

    private static void a(com.igexin.push.core.b.l lVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.igexin.push.core.l.a().a(str, str2, str3, str4, lVar.t, lVar.u, lVar.v);
    }

    private void a(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.core.b.l lVar, int i) {
        int i2;
        java.lang.String str;
        boolean z;
        android.graphics.Bitmap bitmapDecodeResource;
        android.app.Notification.Style styleBigText;
        android.graphics.Bitmap bitmapA;
        int i3 = lVar.r;
        java.lang.String appKey = pushTaskBean.getAppKey();
        java.lang.String taskId = pushTaskBean.getTaskId();
        java.lang.String messageId = pushTaskBean.getMessageId();
        java.lang.String str2 = lVar.q;
        com.igexin.push.core.e.ai.put(taskId, java.lang.Integer.valueOf(i));
        com.igexin.push.core.a.b.d();
        com.igexin.push.extension.mod.PushTaskBean pushTaskBean2 = com.igexin.push.core.e.ah.get(com.igexin.push.core.a.b.a(taskId, messageId));
        if (pushTaskBean2 != null) {
            byte[] msgExtra = pushTaskBean2.getMsgExtra();
            if (msgExtra != null) {
                lVar.v = new java.lang.String(msgExtra);
            }
            for (com.igexin.push.extension.mod.BaseActionBean baseActionBean : pushTaskBean2.getActionChains()) {
                if (baseActionBean instanceof com.igexin.push.core.b.s) {
                    java.lang.String str3 = ((com.igexin.push.core.b.s) baseActionBean).a;
                    if (str3 == null) {
                        str3 = "";
                    }
                    lVar.t = str3;
                }
                if (baseActionBean instanceof com.igexin.push.core.b.r) {
                    java.lang.String str4 = ((com.igexin.push.core.b.r) baseActionBean).b;
                    lVar.u = str4 != null ? str4 : "";
                }
            }
        }
        int iA = a(lVar, true);
        if (iA != 0 && com.igexin.push.core.e.l.getResources().getDrawable(iA) == null) {
            com.igexin.c.a.c.a.a(a + "|showNotification smallIconId: " + iA + " couldn't find resource", new java.lang.Object[0]);
            return;
        }
        android.app.Notification notificationA = a(str2, iA, lVar);
        android.app.PendingIntent pendingIntentA = a(str2, i3, taskId, messageId, i, lVar);
        android.app.PendingIntent pendingIntentA2 = a(str2, i3, appKey, taskId, messageId, lVar);
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) com.igexin.push.core.e.l.getSystemService(com.igexin.push.core.b.n);
        android.app.Notification.Builder builderB = android.os.Build.VERSION.SDK_INT >= 26 ? b(lVar) : new android.app.Notification.Builder(com.igexin.push.core.e.l);
        java.lang.String str5 = lVar.a;
        java.lang.String str6 = lVar.b;
        java.lang.String str7 = lVar.D;
        if (android.text.TextUtils.isEmpty(str7)) {
            i2 = i3;
            str = messageId;
            z = false;
            bitmapDecodeResource = null;
        } else {
            bitmapDecodeResource = com.igexin.push.g.m.a(str7);
            java.lang.String str8 = a;
            str = messageId;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("|use net logo bitmap is null = ");
            i2 = i3;
            sb.append(bitmapDecodeResource == null);
            com.igexin.c.a.c.a.a(str8, sb.toString());
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(str8);
            sb2.append("|use net logo bitmap is null = ");
            sb2.append(bitmapDecodeResource == null);
            z = false;
            com.igexin.c.a.c.a.a(sb2.toString(), new java.lang.Object[0]);
        }
        if (bitmapDecodeResource == null) {
            bitmapDecodeResource = android.graphics.BitmapFactory.decodeResource(com.igexin.push.core.e.l.getResources(), a(lVar, z));
        }
        builderB.setSmallIcon(iA).setTicker(lVar.b).setWhen(java.lang.System.currentTimeMillis()).setContentTitle(str5).setContentIntent(pendingIntentA).setContentText(str6).setDeleteIntent(pendingIntentA2);
        if (!android.text.TextUtils.isEmpty(lVar.w)) {
            builderB.setCategory(lVar.w);
        }
        if (bitmapDecodeResource != null) {
            builderB.setLargeIcon(bitmapDecodeResource);
        }
        builderB.setShowWhen(true);
        if (android.os.Build.VERSION.SDK_INT >= 24 && !android.text.TextUtils.isEmpty(lVar.i)) {
            try {
                builderB.setColor(android.graphics.Color.parseColor(lVar.i));
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
        if (lVar.C == com.igexin.push.core.a.c.h.a.BIG_IMAGE.e) {
            java.lang.String str9 = lVar.E;
            if (!android.text.TextUtils.isEmpty(str9) && (bitmapA = com.igexin.push.g.m.a(str9)) != null) {
                builderB.setPriority(lVar.x);
                styleBigText = new android.app.Notification.BigPictureStyle().bigPicture(bitmapA);
                builderB.setStyle(styleBigText);
            }
        } else if (lVar.C == com.igexin.push.core.a.c.h.a.LONG_TEXT.e) {
            java.lang.String str10 = lVar.B;
            if (!android.text.TextUtils.isEmpty(str10)) {
                builderB.setPriority(lVar.x);
                styleBigText = new android.app.Notification.BigTextStyle().bigText(str10);
                builderB.setStyle(styleBigText);
            }
        }
        if (lVar.z && (lVar.c || lVar.d)) {
            builderB.setPriority(2);
        }
        if (!android.text.TextUtils.isEmpty(str2) && android.os.Build.VERSION.SDK_INT >= 24 && com.igexin.push.core.e.aj.containsKey(str2)) {
            builderB.setGroup(str2);
            builderB.setGroupSummary(false);
            java.util.HashSet<java.lang.String> hashSet = com.igexin.push.core.e.aj.get(str2) == null ? new java.util.HashSet<>() : com.igexin.push.core.e.aj.get(str2);
            hashSet.add(taskId);
            com.igexin.push.core.e.aj.put(str2, hashSet);
        }
        builderB.setWhen(java.lang.System.currentTimeMillis());
        android.app.Notification notification = builderB.getNotification();
        notification.defaults = 4;
        notification.ledARGB = -16711936;
        notification.ledOnMS = 1000;
        notification.ledOffMS = 3000;
        notification.flags = 1;
        notification.flags = lVar.e ? notification.flags | 16 : notification.flags | 32;
        if (lVar.c) {
            notification.defaults |= 2;
        }
        if (lVar.d) {
            if (android.text.TextUtils.isEmpty(lVar.p)) {
                notification.defaults |= 1;
            } else {
                notification.sound = c(lVar.p);
            }
        }
        if (lVar.o > 0) {
            com.igexin.push.g.d.a(lVar.o, false);
            com.igexin.push.g.d.c(lVar.o, false);
            com.igexin.push.g.d.b(lVar.o, false);
        }
        notification.icon = a(lVar, true);
        a(notification);
        if (!android.text.TextUtils.isEmpty(str2) && notificationA != null) {
            int iA2 = a(str2);
            com.igexin.push.core.e.ak.put(str2, java.lang.Integer.valueOf(iA2));
            notificationManager.notify(iA2, notificationA);
        }
        com.igexin.c.a.c.a.a(a + "|showNotification notification:" + i, new java.lang.Object[0]);
        if (i2 > 0) {
            notificationManager.cancel(i);
        }
        notificationManager.notify(i, notification);
        com.igexin.push.core.l.a().a(taskId, str, str5, str6, lVar.t, lVar.u, lVar.v);
        try {
            if (!android.text.TextUtils.isEmpty(com.igexin.push.config.d.ad) && !com.igexin.push.config.d.ad.equals(com.igexin.push.core.b.m) && com.igexin.push.core.e.J == 1) {
                java.lang.String[] strArrSplit = com.igexin.push.config.d.ad.split(com.igexin.push.core.b.an);
                if (!com.igexin.push.config.d.ad.equals("*")) {
                    if (strArrSplit != null && strArrSplit.length > 0) {
                        for (java.lang.String str11 : strArrSplit) {
                            if (!str11.equalsIgnoreCase(com.igexin.push.core.e.G)) {
                            }
                        }
                    }
                }
                try {
                    com.igexin.b.a.a().b().schedule(new com.igexin.push.core.a.c.h.AnonymousClass2(notificationManager, i, pushTaskBean), 300L, java.util.concurrent.TimeUnit.MILLISECONDS);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    com.igexin.c.a.c.a.a(th);
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final com.igexin.push.extension.mod.BaseActionBean baseActionBean, final int i) {
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6 = "width=" + com.igexin.push.core.e.k + "&height=" + com.igexin.push.core.e.j;
        if (str.contains(str6)) {
            str4 = str;
        } else {
            if (str.indexOf("?") > 0) {
                str5 = str + "&" + str6;
            } else {
                str5 = str + "?" + str6;
            }
            str4 = str5;
        }
        com.igexin.push.core.h.b bVar = new com.igexin.push.core.h.b(str4, str, str2, baseActionBean, i, new com.igexin.push.core.h.d() { // from class: com.igexin.push.core.a.c.h.1
            @Override // com.igexin.push.core.h.d
            public final void a() {
                if (((com.igexin.push.core.b.l) baseActionBean).H >= 3) {
                    ((com.igexin.push.core.b.l) baseActionBean).F = true;
                }
                if (((com.igexin.push.core.b.l) baseActionBean).I >= 3) {
                    ((com.igexin.push.core.b.l) baseActionBean).G = true;
                }
                if (!((com.igexin.push.core.b.l) baseActionBean).F || !((com.igexin.push.core.b.l) baseActionBean).G) {
                    com.igexin.push.core.a.c.h.this.a(str, str2, str3, baseActionBean, i);
                    return;
                }
                if (com.igexin.push.core.e.a(str2) == 0) {
                    com.igexin.push.core.e.c.a();
                    com.igexin.push.core.e.c.a(com.igexin.push.core.b.ag, str2);
                    java.util.Map<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> map = com.igexin.push.core.e.ah;
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.extension.mod.PushTaskBean pushTaskBean = map.get(com.igexin.push.core.a.b.a(str2, str3));
                    if (pushTaskBean != null) {
                        pushTaskBean.setStatus(com.igexin.push.core.b.ag);
                    }
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.a(str2, str3, "1");
                }
            }

            @Override // com.igexin.push.core.h.d
            public final void a(com.igexin.push.extension.mod.BaseActionBean baseActionBean2) {
                int i2 = i;
                if (i2 == 2) {
                    ((com.igexin.push.core.b.l) baseActionBean).F = true;
                } else if (i2 == 8) {
                    ((com.igexin.push.core.b.l) baseActionBean).G = true;
                }
                com.igexin.push.core.b.l lVar = (com.igexin.push.core.b.l) baseActionBean2;
                if (lVar.F && lVar.G && com.igexin.push.core.e.a(str2) == 0) {
                    com.igexin.push.core.e.c.a();
                    com.igexin.push.core.e.c.a(com.igexin.push.core.b.ag, str2);
                    java.util.Map<java.lang.String, com.igexin.push.extension.mod.PushTaskBean> map = com.igexin.push.core.e.ah;
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.extension.mod.PushTaskBean pushTaskBean = map.get(com.igexin.push.core.a.b.a(str2, str3));
                    if (pushTaskBean != null) {
                        pushTaskBean.setStatus(com.igexin.push.core.b.ag);
                    }
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.a(str2, str3, "1");
                }
            }
        });
        if (i == 2) {
            ((com.igexin.push.core.b.l) baseActionBean).H++;
        } else if (i == 8) {
            ((com.igexin.push.core.b.l) baseActionBean).I++;
        }
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.a.e(bVar), false, true);
    }

    private static android.app.Notification.Builder b(com.igexin.push.core.b.l lVar) {
        android.app.Notification.Builder builder = new android.app.Notification.Builder(com.igexin.push.core.e.l);
        android.app.NotificationManager notificationManager = (android.app.NotificationManager) com.igexin.push.core.e.l.getSystemService(com.igexin.push.core.b.n);
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.NotificationChannel");
            java.lang.reflect.Constructor<?> constructor = cls.getConstructor(java.lang.String.class, java.lang.CharSequence.class, java.lang.Integer.TYPE);
            java.lang.Class<?> cls2 = notificationManager.getClass();
            if (((android.os.Parcelable) cls2.getMethod("getNotificationChannel", java.lang.String.class).invoke(notificationManager, lVar.j)) == null) {
                android.os.Parcelable parcelable = (android.os.Parcelable) constructor.newInstance(lVar.j, lVar.k, java.lang.Integer.valueOf(lVar.l));
                java.lang.reflect.Method method = cls2.getMethod("createNotificationChannel", java.lang.Class.forName("android.app.NotificationChannel"));
                java.lang.reflect.Method method2 = cls.getMethod("enableVibration", java.lang.Boolean.TYPE);
                java.lang.reflect.Method method3 = cls.getMethod("setSound", android.net.Uri.class, android.media.AudioAttributes.class);
                method2.invoke(parcelable, java.lang.Boolean.valueOf(lVar.c));
                if (!lVar.d) {
                    method3.invoke(parcelable, null, null);
                } else if (!android.text.TextUtils.isEmpty(lVar.p)) {
                    method3.invoke(parcelable, c(lVar.p), null);
                }
                method.invoke(notificationManager, parcelable);
            }
            builder.getClass().getMethod("setChannelId", java.lang.String.class).invoke(builder, lVar.j);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return builder;
    }

    private static android.app.PendingIntent b(java.lang.String str) {
        try {
            android.content.Context context = com.igexin.push.core.e.l;
            com.igexin.push.core.a.b.d();
            android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.igexin.push.core.a.b.a(com.igexin.push.core.e.l));
            intent.putExtra("isSummary", true);
            intent.putExtra("action", "com.igexin.action.notification.delete");
            intent.putExtra("groupId", str);
            return android.app.PendingIntent.getService(com.igexin.push.core.e.l, new java.util.Random().nextInt(1000), intent, (com.igexin.push.g.o.a(com.igexin.push.core.e.l) < 31 || android.os.Build.VERSION.SDK_INT < 30) ? 134217728 : 201326592);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private static android.net.Uri c(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            return android.net.Uri.parse("android.resource://" + com.igexin.push.core.e.l.getPackageName() + "/raw/" + str.toLowerCase());
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0386  */
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean executeAction(com.igexin.push.extension.mod.PushTaskBean r25, com.igexin.push.extension.mod.BaseActionBean r26) {
        /*
            Method dump skipped, instruction units count: 985
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.c.h.executeAction(com.igexin.push.extension.mod.PushTaskBean, com.igexin.push.extension.mod.BaseActionBean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
    @Override // com.igexin.push.extension.mod.PushMessageInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.igexin.push.extension.mod.BaseActionBean parseAction(org.json.JSONObject r19) {
        /*
            Method dump skipped, instruction units count: 705
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.c.h.parseAction(org.json.JSONObject):com.igexin.push.extension.mod.BaseActionBean");
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState prepareExecuteAction(com.igexin.push.extension.mod.PushTaskBean pushTaskBean, com.igexin.push.extension.mod.BaseActionBean baseActionBean) {
        boolean z;
        if (!(baseActionBean instanceof com.igexin.push.core.b.l)) {
            return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.stop;
        }
        com.igexin.push.core.b.l lVar = (com.igexin.push.core.b.l) baseActionBean;
        java.lang.String str = lVar.g;
        java.lang.String str2 = lVar.A;
        java.lang.String taskId = pushTaskBean.getTaskId();
        java.lang.String messageId = pushTaskBean.getMessageId();
        boolean z2 = true;
        if (str2 != null) {
            java.lang.String strA = com.igexin.push.g.k.a(str2);
            if (strA.equals("")) {
                lVar.G = false;
                z = true;
            } else {
                lVar.E = strA;
                z = false;
            }
        } else {
            z = false;
        }
        if (str != null) {
            java.lang.String strA2 = com.igexin.push.g.k.a(str);
            if ("".equals(strA2)) {
                lVar.F = false;
            } else {
                lVar.D = strA2;
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (!z2 && !z) {
            return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.success;
        }
        if (z2) {
            a(str, taskId, messageId, baseActionBean, 2);
        }
        if (z) {
            a(str2, taskId, messageId, baseActionBean, 8);
        }
        return com.igexin.push.extension.mod.PushMessageInterface.ActionPrepareState.wait;
    }
}
