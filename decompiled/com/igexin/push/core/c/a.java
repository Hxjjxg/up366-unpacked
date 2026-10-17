package com.igexin.push.core.c;

import com.igexin.push.core.e.f.AnonymousClass39;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class a implements com.igexin.push.core.e.a {
    private static final java.lang.String a = "BIDataManager";
    private static com.igexin.push.core.c.a b;

    /* JADX INFO: renamed from: com.igexin.push.core.c.a$2, reason: invalid class name */
    final class AnonymousClass2 implements java.util.Comparator<com.igexin.push.core.b.v> {
        AnonymousClass2() {
        }

        private static int a(com.igexin.push.core.b.v vVar, com.igexin.push.core.b.v vVar2) {
            if (vVar.c.equals(vVar2.c)) {
                return 0;
            }
            return vVar.c.compareTo(vVar2.c);
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(com.igexin.push.core.b.v vVar, com.igexin.push.core.b.v vVar2) {
            com.igexin.push.core.b.v vVar3 = vVar;
            com.igexin.push.core.b.v vVar4 = vVar2;
            if (vVar3.c.equals(vVar4.c)) {
                return 0;
            }
            return vVar3.c.compareTo(vVar4.c);
        }
    }

    private static int a(android.content.pm.ApplicationInfo applicationInfo, android.app.AppOpsManager appOpsManager, android.content.pm.PackageManager packageManager) {
        try {
            if (applicationInfo.packageName.equals(com.igexin.push.core.e.g)) {
                return com.igexin.push.g.c.b(com.igexin.push.core.e.l) ? 1 : 0;
            }
            if (android.os.Build.VERSION.SDK_INT < 31 || !com.igexin.push.config.d.aa) {
                return -1;
            }
            if (android.os.Build.VERSION.SDK_INT >= 33 && applicationInfo.targetSdkVersion >= 33) {
                try {
                    return packageManager.checkPermission(com.up366.mobile.common.utils.permissions.Permission.POST_NOTIFICATIONS, applicationInfo.packageName) == 0 ? 1 : 0;
                } catch (java.lang.Throwable unused) {
                    java.lang.String[] strArr = com.igexin.push.g.l.a(applicationInfo.packageName, 4096).requestedPermissions;
                    if (strArr == null || !new java.util.HashSet(java.util.Arrays.asList(strArr)).contains(com.up366.mobile.common.utils.permissions.Permission.POST_NOTIFICATIONS)) {
                        return 0;
                    }
                }
            }
            java.lang.Class<?> cls = java.lang.Class.forName(android.app.AppOpsManager.class.getName());
            java.lang.Integer num = (java.lang.Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(java.lang.Integer.class);
            num.intValue();
            java.lang.Class<?> cls2 = java.lang.Integer.TYPE;
            return ((java.lang.Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, java.lang.String.class).invoke(appOpsManager, num, java.lang.Integer.valueOf(applicationInfo.uid), applicationInfo.packageName)).intValue() != 0 ? 0 : 1;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return -1;
        }
    }

    private static long a(java.lang.String str) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("type", (java.lang.Integer) 10);
        contentValues.put("data", str);
        contentValues.put("time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        return com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, contentValues);
    }

    public static com.igexin.push.core.c.a a() {
        if (b == null) {
            b = new com.igexin.push.core.c.a();
        }
        return b;
    }

    static /* synthetic */ void a(com.igexin.push.core.c.a aVar, java.util.List list) {
        com.igexin.push.core.c.a.AnonymousClass2 anonymousClass2 = aVar.new AnonymousClass2();
        android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) com.igexin.push.core.e.l.getSystemService("appops");
        android.content.pm.PackageManager packageManager = com.igexin.push.core.e.l.getPackageManager();
        java.util.List<android.content.pm.PackageInfo> listA = com.igexin.push.g.o.a();
        for (int i = 0; i < listA.size(); i++) {
            try {
                android.content.pm.PackageInfo packageInfo = listA.get(i);
                android.content.pm.ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if ((applicationInfo.flags & 1) <= 0) {
                    com.igexin.push.core.b.v vVar = new com.igexin.push.core.b.v();
                    vVar.a = applicationInfo.loadLabel(packageManager).toString();
                    vVar.c = applicationInfo.packageName;
                    vVar.b = java.lang.String.valueOf(packageInfo.versionCode);
                    vVar.d = packageInfo.versionName;
                    vVar.e = a(applicationInfo, appOpsManager, packageManager);
                    list.add(vVar);
                }
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        java.util.Collections.sort(list, anonymousClass2);
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        try {
            if (android.text.TextUtils.isEmpty(str) || com.igexin.push.core.b.m.equals(str) || !com.igexin.push.config.d.R.booleanValue()) {
                return;
            }
            if ((java.lang.System.currentTimeMillis() - com.igexin.push.core.e.aw) - (com.igexin.push.config.d.S * 1000) < 0) {
                com.igexin.c.a.c.a.b(a, "type253 in Interval = " + com.igexin.push.config.d.S);
                return;
            }
            java.lang.Boolean bool = com.igexin.push.config.d.R;
            long j = com.igexin.push.config.d.S;
            long j2 = com.igexin.push.config.d.S;
            com.igexin.c.a.c.a.a(a, "start up id type253Enable = " + com.igexin.push.config.d.R + " ，type253Interval = " + com.igexin.push.config.d.S);
            java.lang.String strM = com.igexin.push.g.o.m();
            java.lang.String strH = com.igexin.push.g.o.h();
            java.lang.String str3 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str3);
            sb.append("|");
            sb.append(com.igexin.push.core.e.C);
            sb.append("|");
            sb.append(com.igexin.push.core.e.a);
            sb.append("|");
            sb.append(str);
            sb.append("|");
            if (strH == null || com.igexin.push.core.b.m.equals(strH)) {
                strH = "";
            }
            sb.append(strH);
            sb.append("|");
            if (strM == null || com.igexin.push.core.b.m.equals(strM)) {
                strM = "";
            }
            sb.append(strM);
            sb.append("|");
            sb.append(str2);
            sb.append("||ANDROID");
            java.lang.String string = sb.toString();
            com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl();
            com.igexin.c.a.c.a.a("BIDataManager| upload253 = ".concat(java.lang.String.valueOf(string)), new java.lang.Object[0]);
            byte[] bytes = string.getBytes();
            com.igexin.push.core.e.f.a().d(java.lang.System.currentTimeMillis());
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.a.a(new com.igexin.push.core.h.e(com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl(), bytes, com.igexin.push.config.c.D)), false, true);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void a(java.util.ArrayList<java.lang.String> arrayList) {
        com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, new java.lang.String[]{com.igexin.push.core.b.C}, (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]));
    }

    private void a(java.util.List<com.igexin.push.core.b.v> list) {
        com.igexin.push.core.c.a.AnonymousClass2 anonymousClass2 = new com.igexin.push.core.c.a.AnonymousClass2();
        android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) com.igexin.push.core.e.l.getSystemService("appops");
        android.content.pm.PackageManager packageManager = com.igexin.push.core.e.l.getPackageManager();
        java.util.List<android.content.pm.PackageInfo> listA = com.igexin.push.g.o.a();
        for (int i = 0; i < listA.size(); i++) {
            try {
                android.content.pm.PackageInfo packageInfo = listA.get(i);
                android.content.pm.ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if ((applicationInfo.flags & 1) <= 0) {
                    com.igexin.push.core.b.v vVar = new com.igexin.push.core.b.v();
                    vVar.a = applicationInfo.loadLabel(packageManager).toString();
                    vVar.c = applicationInfo.packageName;
                    vVar.b = java.lang.String.valueOf(packageInfo.versionCode);
                    vVar.d = packageInfo.versionName;
                    vVar.e = a(applicationInfo, appOpsManager, packageManager);
                    list.add(vVar);
                }
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        java.util.Collections.sort(list, anonymousClass2);
    }

    public static void b() {
        java.lang.String str;
        if (!com.igexin.push.g.c.e()) {
            str = " upload type144 network false";
        } else if (com.igexin.push.config.d.V) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if ((jCurrentTimeMillis - com.igexin.push.core.e.ay) - (com.igexin.push.config.d.W * 1000) >= 0) {
                try {
                    java.lang.String[] strArrB = com.igexin.assist.sdk.a.a().b();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date()));
                    sb.append("|");
                    sb.append(com.igexin.push.core.e.A);
                    sb.append("|");
                    sb.append(com.igexin.push.core.e.a);
                    sb.append("|");
                    sb.append(com.igexin.push.core.e.C);
                    sb.append("|");
                    sb.append(com.igexin.push.config.d.T ? com.igexin.push.g.o.q() : "");
                    sb.append("|");
                    sb.append(com.igexin.push.g.o.d());
                    sb.append("|");
                    sb.append(com.igexin.assist.util.AssistUtils.getDeviceBrand().toLowerCase());
                    sb.append("|");
                    sb.append(strArrB[0]);
                    sb.append("|");
                    sb.append(strArrB[1]);
                    sb.append("|");
                    sb.append(com.igexin.push.g.o.n());
                    sb.append("|");
                    sb.append(com.igexin.push.g.o.o());
                    com.igexin.push.core.e.f.a().e(jCurrentTimeMillis);
                    com.igexin.c.a.c.a.b("UploadBITask", "upload type144 data = " + sb.toString());
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.a.a(new com.igexin.push.core.h.e(com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl(), sb.toString().getBytes(), com.igexin.push.config.c.E)), false, true);
                    return;
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                    return;
                }
            }
            str = "type144 in Interval = " + com.igexin.push.config.d.W;
        } else {
            str = " isUpload type144 Enable false";
        }
        com.igexin.c.a.c.a.b(a, str);
    }

    private static void b(java.util.ArrayList<java.lang.String> arrayList) {
        com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, new java.lang.String[]{"rowid"}, (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0051 A[DONT_GENERATE, PHI: r1
  0x0051: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v3 android.database.Cursor) binds: [B:13:0x004f, B:9:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<com.igexin.push.core.b.c> c() {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            com.igexin.push.core.d r2 = com.igexin.push.core.d.a.a()     // Catch: java.lang.Throwable -> L4b
            com.igexin.push.b.b r3 = r2.i     // Catch: java.lang.Throwable -> L4b
            java.lang.String r4 = "bidata"
            java.lang.String r2 = "type"
            java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L4b
            java.lang.String r2 = "10"
            java.lang.String[] r6 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L4b
            java.lang.String r8 = ""
            r7 = 0
            android.database.Cursor r1 = r3.a(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L48
        L24:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L4b
            if (r2 == 0) goto L48
            r2 = 0
            int r4 = r1.getInt(r2)     // Catch: java.lang.Throwable -> L4b
            r2 = 1
            java.lang.String r5 = r1.getString(r2)     // Catch: java.lang.Throwable -> L4b
            r2 = 2
            int r6 = r1.getInt(r2)     // Catch: java.lang.Throwable -> L4b
            r2 = 3
            long r7 = r1.getLong(r2)     // Catch: java.lang.Throwable -> L4b
            com.igexin.push.core.b.c r2 = new com.igexin.push.core.b.c     // Catch: java.lang.Throwable -> L4b
            r3 = r2
            r3.<init>(r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L4b
            r0.add(r2)     // Catch: java.lang.Throwable -> L4b
            goto L24
        L48:
            if (r1 == 0) goto L54
            goto L51
        L4b:
            r2 = move-exception
            com.igexin.c.a.c.a.a(r2)     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L54
        L51:
            r1.close()
        L54:
            return r0
        L55:
            r0 = move-exception
            if (r1 == 0) goto L5b
            r1.close()
        L5b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.c.a.c():java.util.List");
    }

    private static void d() {
        android.database.Cursor cursor = null;
        try {
            android.database.Cursor cursorA = com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, null, null, new java.lang.String[]{"COUNT(*)"}, null);
            if (cursorA == null) {
                if (cursorA != null) {
                    cursorA.close();
                    return;
                }
                return;
            }
            cursorA.moveToNext();
            long j = cursorA.getLong(0);
            cursorA.close();
            long j2 = j - 200;
            if (j2 > 0) {
                com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, "id IN(SELECT id FROM bidata ORDER BY time ASC LIMIT " + j2 + ")");
                com.igexin.c.a.c.a.b(a, "delete bidata " + j2 + " old expired data");
            }
            if (cursorA != null) {
                cursorA.close();
            }
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    public final void a(boolean z) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() - com.igexin.push.core.e.R;
        if (!z || jCurrentTimeMillis - 86400000 >= 0) {
            com.igexin.c.a.c.a.a(a.concat(z ? ", over 24h, start upload AL" : "data change start upload AL"), new java.lang.Object[0]);
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.d() { // from class: com.igexin.push.core.c.a.1
                @Override // com.igexin.push.f.d
                public final void b() {
                    try {
                        com.igexin.push.core.e.f fVarA = com.igexin.push.core.e.f.a();
                        long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
                        if (jCurrentTimeMillis2 != com.igexin.push.core.e.R) {
                            com.igexin.push.core.e.R = jCurrentTimeMillis2;
                            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass39(), false, true);
                        }
                        java.util.ArrayList arrayList = new java.util.ArrayList();
                        com.igexin.push.core.c.a.a(com.igexin.push.core.c.a.this, arrayList);
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        try {
                            jSONObject.put("action", "reportapplist");
                            jSONObject.put("session_last", com.igexin.push.core.e.z);
                            org.json.JSONArray jSONArray = new org.json.JSONArray();
                            int size = arrayList.size();
                            for (int i = 0; i < size; i++) {
                                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                                jSONObject2.put("appid", ((com.igexin.push.core.b.v) arrayList.get(i)).c);
                                jSONObject2.put("name", ((com.igexin.push.core.b.v) arrayList.get(i)).a);
                                jSONObject2.put("version", ((com.igexin.push.core.b.v) arrayList.get(i)).b);
                                jSONObject2.put("versionName", ((com.igexin.push.core.b.v) arrayList.get(i)).d);
                                jSONObject2.put("notificationEnabled", ((com.igexin.push.core.b.v) arrayList.get(i)).e);
                                jSONArray.put(jSONObject2);
                            }
                            jSONObject.put("applist", jSONArray);
                        } catch (java.lang.Exception e) {
                            com.igexin.c.a.c.a.a(e);
                        }
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.a.a(new com.igexin.push.core.h.a(com.igexin.push.config.SDKUrlConfig.getBiUploadServiceUrl(), jSONObject.toString().getBytes())), false, true);
                        com.igexin.c.a.c.a.a("reportAL", new java.lang.Object[0]);
                        if (com.igexin.push.config.d.ac) {
                            com.igexin.c.a.c.a.a("reportAL = " + jSONObject.toString(), new java.lang.Object[0]);
                        }
                    } catch (java.lang.Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                }
            }, false, true);
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void c(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        android.database.Cursor cursor = null;
        try {
            android.database.Cursor cursorA = com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, null, null, new java.lang.String[]{"COUNT(*)"}, null);
            if (cursorA == null) {
                if (cursorA != null) {
                    cursorA.close();
                    return;
                }
                return;
            }
            cursorA.moveToNext();
            long j = cursorA.getLong(0);
            cursorA.close();
            long j2 = j - 200;
            if (j2 > 0) {
                com.igexin.push.core.d.a.a.i.a(com.igexin.push.core.b.ae, "id IN(SELECT id FROM bidata ORDER BY time ASC LIMIT " + j2 + ")");
                com.igexin.c.a.c.a.b(a, "delete bidata " + j2 + " old expired data");
            }
            if (cursorA != null) {
                cursorA.close();
            }
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }
}
