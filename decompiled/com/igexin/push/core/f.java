package com.igexin.push.core;

import com.igexin.push.core.d.AnonymousClass1;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class f extends android.os.HandlerThread {
    public f() {
        super("CoreThread");
    }

    @Override // android.os.HandlerThread
    protected final void onLooperPrepared() {
        com.igexin.push.core.d dVar = com.igexin.push.core.d.a.a;
        try {
            com.igexin.push.core.e.a(dVar.a);
            com.igexin.push.config.b.a();
            com.igexin.push.config.b.b();
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            intentFilter.addAction(com.igexin.push.core.b.L);
            intentFilter.addAction(com.igexin.push.core.b.N);
            intentFilter.addAction("com.igexin.action.notification.click");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            if (android.os.Build.VERSION.SDK_INT > 33) {
                dVar.a.registerReceiver(com.igexin.push.core.i.a(), intentFilter, com.igexin.push.core.e.ac, null, 4);
            } else {
                dVar.a.registerReceiver(com.igexin.push.core.i.a(), intentFilter, com.igexin.push.core.e.ac, null);
            }
            com.igexin.push.b.a aVar = new com.igexin.push.b.a();
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.core.e.f.a());
            aVar.a((com.igexin.push.core.e.a) com.igexin.push.config.a.a());
            aVar.b((com.igexin.push.core.e.a) com.igexin.push.core.e.e.a());
            aVar.b((com.igexin.push.core.e.a) com.igexin.push.core.e.c.a());
            dVar.f.a((com.igexin.c.a.d.f) aVar, true, false);
            com.igexin.push.core.d.b.d().a();
            com.igexin.c.a.b.e eVar = dVar.f;
            android.content.Context context = dVar.a;
            if (!eVar.I) {
                if (!com.igexin.push.g.o.l()) {
                    eVar.v = (android.os.PowerManager) context.getSystemService("power");
                    eVar.D = true;
                    eVar.w = (android.app.AlarmManager) context.getSystemService("alarm");
                    try {
                        if (android.os.Build.VERSION.SDK_INT >= 31) {
                            eVar.t = ((java.lang.Boolean) android.app.AlarmManager.class.getDeclaredMethod("canScheduleExactAlarms", null).invoke(eVar.w, null)).booleanValue();
                        } else {
                            eVar.t = true;
                        }
                    } catch (java.lang.Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                    com.igexin.c.a.d.g.AnonymousClass1 anonymousClass1 = new com.igexin.c.a.d.g.AnonymousClass1(context);
                    if (android.os.Build.VERSION.SDK_INT > 33) {
                        context.registerReceiver(eVar, anonymousClass1, com.igexin.push.core.e.ac, null, 4);
                    } else {
                        context.registerReceiver(eVar, anonymousClass1, com.igexin.push.core.e.ac, null);
                    }
                    eVar.B = "AlarmNioTaskSchedule." + context.getPackageName();
                    if (android.os.Build.VERSION.SDK_INT > 33) {
                        context.registerReceiver(eVar, new android.content.IntentFilter(eVar.B), com.igexin.push.core.e.ac, null, 4);
                    } else {
                        context.registerReceiver(eVar, new android.content.IntentFilter(eVar.B), com.igexin.push.core.e.ac, null);
                    }
                    int i = (com.igexin.push.g.o.a(context) < 31 || android.os.Build.VERSION.SDK_INT < 30) ? 134217728 : 201326592;
                    eVar.x = new android.content.Intent("AlarmTaskSchedule." + context.getPackageName());
                    eVar.y = android.app.PendingIntent.getBroadcast(context, eVar.hashCode(), eVar.x, i);
                    eVar.hashCode();
                    eVar.z = new android.content.Intent(eVar.B);
                    eVar.A = android.app.PendingIntent.getBroadcast(context, eVar.hashCode() + 2, eVar.z, i);
                    eVar.hashCode();
                }
                eVar.p.start();
                try {
                    java.lang.Thread.yield();
                } catch (java.lang.Throwable th2) {
                    com.igexin.c.a.c.a.a(th2);
                }
                eVar.I = true;
            }
            com.igexin.c.a.b.e eVar2 = dVar.f;
            byte[] bArrA = com.igexin.c.b.a.a(com.igexin.push.core.e.L.getBytes());
            eVar2.e = bArrA;
            eVar2.f = com.igexin.c.b.a.a(bArrA);
            if (eVar2.f != null) {
                new java.lang.String(eVar2.f);
            }
            com.igexin.push.core.e.ae = dVar.f.a((com.igexin.c.a.d.f) com.igexin.push.f.b.b.g(), false, true);
            com.igexin.push.core.e.af = dVar.f.a((com.igexin.c.a.d.f) com.igexin.push.f.b.e.g(), true, true);
            com.igexin.push.c.c.a();
            com.igexin.push.c.c.b();
            dVar.b();
            dVar.d = com.igexin.push.core.a.b.d();
            dVar.h.a();
            com.igexin.push.core.e.m.set(true);
            while (!dVar.c.isEmpty()) {
                android.os.Message messagePoll = dVar.c.poll();
                if (messagePoll != null && dVar.b != null) {
                    dVar.b.sendMessage(messagePoll);
                }
            }
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) dVar.new AnonymousClass1(), true);
        } catch (java.lang.Throwable th3) {
            th = th3;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.StackTraceElement[] stackTrace = th.getStackTrace();
            while (th.getCause() != null) {
                th = th.getCause();
            }
            sb.append(th.toString());
            sb.append("\n");
            for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
            java.lang.String string = sb.toString();
            com.igexin.c.a.c.a.b("CoreLogic", string);
            com.igexin.c.a.c.a.d.a().a("[CoreLogic] ------ CoreLogic init failed = " + string + " ------");
        }
    }
}
