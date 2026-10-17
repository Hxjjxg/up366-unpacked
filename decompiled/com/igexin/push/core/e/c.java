package com.igexin.push.core.e;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class c implements com.igexin.push.core.e.a {
    private static com.igexin.push.core.e.c c;
    private java.util.ArrayList<com.igexin.push.core.b.k> d;
    private boolean e;
    private java.lang.String b = "MessageDataManager";
    public int a = -1;

    /* JADX INFO: renamed from: com.igexin.push.core.e.c$1, reason: invalid class name */
    public class AnonymousClass1 extends com.igexin.push.b.d {
        public AnonymousClass1() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws java.lang.Exception {
            android.database.Cursor cursorA = null;
            try {
                com.igexin.push.b.b bVar = com.igexin.push.core.d.a.a.i;
                cursorA = bVar.a("message", new java.lang.String[]{"status"}, new java.lang.String[]{"0"}, null, null);
                if (cursorA != null) {
                    while (cursorA.moveToNext()) {
                        byte[] blob = cursorA.getBlob(cursorA.getColumnIndex("info"));
                        long j = cursorA.getLong(cursorA.getColumnIndex("createtime"));
                        try {
                            org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(com.igexin.c.b.a.c(blob)));
                            java.lang.String string = jSONObject.getString("taskid");
                            if (jSONObject.has("condition") && !com.igexin.push.core.e.c.b(jSONObject) && java.lang.System.currentTimeMillis() - j > 259200000) {
                                java.lang.String unused = com.igexin.push.core.e.c.this.b;
                                com.igexin.c.a.c.a.a(com.igexin.push.core.e.c.this.b + "|del condition taskid = " + string, new java.lang.Object[0]);
                                bVar.a("message", new java.lang.String[]{"taskid"}, new java.lang.String[]{string});
                            }
                        } catch (java.lang.Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    }
                }
            } catch (java.lang.Throwable th2) {
                try {
                    com.igexin.c.a.c.a.a(th2);
                    if (cursorA != null) {
                        cursorA.close();
                    }
                } finally {
                    if (cursorA != null) {
                        cursorA.close();
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.core.e.c$2, reason: invalid class name */
    public class AnonymousClass2 extends com.igexin.push.b.d {
        public AnonymousClass2() {
        }

        @Override // com.igexin.push.b.d
        public final void a_() throws java.lang.Exception {
            com.igexin.push.core.d.a.a.i.a("message", "createtime <= ".concat(java.lang.String.valueOf(java.lang.System.currentTimeMillis() - 604800000)));
        }
    }

    public static com.igexin.push.core.e.c a() {
        if (c == null) {
            synchronized (com.igexin.push.core.e.c.class) {
                if (c == null) {
                    c = new com.igexin.push.core.e.c();
                }
            }
        }
        return c;
    }

    public static void a(int i, java.lang.String str) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("status", java.lang.Integer.valueOf(i));
        com.igexin.push.core.d.a.a.i.a("message", contentValues, new java.lang.String[]{"taskid"}, new java.lang.String[]{str});
    }

    private void a(android.content.ContentValues contentValues) {
        try {
            if (this.a == -1) {
                this.a = b();
            }
            if (this.a < 1000) {
                if (com.igexin.push.core.d.a.a.i.a("message", contentValues) != -1) {
                    this.a++;
                    return;
                }
                return;
            }
            int iA = com.igexin.push.core.d.a.a.i.a("message", "id IN (SELECT id from message where status IS NULL or status=1 or status=2 order by id asc limit 250)");
            this.a -= iA;
            if (iA < 250) {
                this.a -= com.igexin.push.core.d.a.a.i.a("message", "id IN (SELECT id from message where status=0 order by id asc limit " + (250 - iA) + ")");
            }
            if (com.igexin.push.core.d.a.a.i.a("message", contentValues) != -1) {
                this.a++;
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase, java.util.ArrayList<com.igexin.push.core.b.k> arrayList) {
        try {
            for (com.igexin.push.core.b.k kVar : arrayList) {
                byte[] bArr = kVar.e;
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put(com.igexin.push.core.b.C, java.lang.Long.valueOf(kVar.a));
                contentValues.put("messageid", kVar.b);
                contentValues.put("taskid", kVar.c);
                contentValues.put("appid", kVar.d);
                if (bArr != null) {
                    contentValues.put("info", bArr);
                }
                if (kVar.f != null) {
                    contentValues.put("msgextra", kVar.f);
                }
                contentValues.put("key", kVar.g);
                contentValues.put("status", java.lang.Integer.valueOf(kVar.h));
                contentValues.put("createtime", java.lang.Long.valueOf(kVar.i));
                sQLiteDatabase.insert("message", null, contentValues);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        arrayList.clear();
    }

    public static void a(java.lang.String str, int i, int i2) {
        android.database.Cursor cursorA;
        if (i2 == 0) {
            return;
        }
        android.database.Cursor cursorA2 = null;
        try {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("notify_status", java.lang.Integer.valueOf(i));
            if (i == com.igexin.push.core.b.ai) {
                cursorA = com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[]{com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID}, new java.lang.String[]{str}, new java.lang.String[]{"redisplay_num", "redisplay_duration", "redisplay_freq"}, null);
                if (cursorA != null) {
                    try {
                        if (cursorA.getCount() != 0) {
                            if (cursorA.moveToFirst()) {
                                int i3 = cursorA.getInt(cursorA.getColumnIndex("redisplay_num"));
                                long j = cursorA.getLong(cursorA.getColumnIndex("redisplay_duration"));
                                contentValues.put("redisplay_num", java.lang.Integer.valueOf(i3 + 1));
                                contentValues.put("expect_redisplay_time", java.lang.Long.valueOf((java.lang.System.currentTimeMillis() / 1000) + j));
                            }
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        cursorA2 = cursorA;
                        try {
                            com.igexin.c.a.c.a.a(th);
                            if (cursorA2 != null) {
                                cursorA2.close();
                                return;
                            }
                            return;
                        } finally {
                            if (cursorA2 != null) {
                                cursorA2.close();
                            }
                        }
                    }
                }
                if (cursorA != null) {
                    cursorA.close();
                    return;
                }
                return;
            }
            cursorA = null;
            com.igexin.push.core.d.a.a.i.a("message", contentValues, new java.lang.String[]{"taskid"}, new java.lang.String[]{str});
            com.igexin.push.f.e eVarA = com.igexin.push.f.e.a();
            try {
                cursorA2 = com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[0], "status = '1' and notify_status = '1' and redisplay_freq != '0' and redisplay_num <= redisplay_freq  order by expect_redisplay_time asc limit 1");
                if (cursorA2 != null && cursorA2.getCount() == 1 && cursorA2.moveToFirst()) {
                    eVarA.b = cursorA2.getLong(cursorA2.getColumnIndex("expect_redisplay_time"));
                } else {
                    eVarA.b = Long.MAX_VALUE;
                }
                long j2 = eVarA.b;
                java.lang.System.currentTimeMillis();
            } catch (java.lang.Throwable th2) {
                try {
                    com.igexin.c.a.c.a.a(th2);
                    com.igexin.c.a.c.a.b(eVarA.a, " get next redisplay message fail" + th2.toString());
                    if (cursorA2 != null) {
                    }
                } finally {
                    if (cursorA2 != null) {
                        cursorA2.close();
                    }
                }
            }
            if (cursorA != null) {
                cursorA.close();
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    public static boolean a(java.lang.String str) {
        boolean z = false;
        android.database.Cursor cursorA = null;
        try {
            cursorA = com.igexin.push.core.d.a.a.i.a("message", new java.lang.String[]{"taskid"}, new java.lang.String[]{str}, null, null);
            if (cursorA != null) {
                if (cursorA.getCount() > 0) {
                    z = true;
                }
            }
            return z;
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursorA != null) {
                    cursorA.close();
                }
                return false;
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
    }

    public static int b() {
        android.database.Cursor cursorA = null;
        try {
            cursorA = com.igexin.push.core.d.a.a.i.a("message", null, null, null, null);
            if (cursorA != null) {
                return cursorA.getCount();
            }
            if (cursorA == null) {
                return 0;
            }
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursorA == null) {
                    return 0;
                }
            } finally {
                if (cursorA != null) {
                    cursorA.close();
                }
            }
        }
        cursorA.close();
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(org.json.JSONObject jSONObject) {
        try {
            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("condition");
            if (jSONObject2.has("wifi") || jSONObject2.has("screenOn") || jSONObject2.has("ssid") || jSONObject2.has("duration")) {
                return false;
            }
            return !jSONObject2.has("netConnected");
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return true;
        }
    }

    private void c() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.e.c.AnonymousClass1(), false, true);
    }

    private void d() {
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.e.c.AnonymousClass2(), false, true);
    }

    private static void e() {
    }

    private void e(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        android.database.Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query("message", null, "status =?", new java.lang.String[]{"0"}, null, null, null, null);
            if (cursorQuery != null) {
                java.util.ArrayList<com.igexin.push.core.b.k> arrayList = new java.util.ArrayList<>();
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new com.igexin.push.core.b.k(cursorQuery.getInt(cursorQuery.getColumnIndex(com.igexin.push.core.b.C)), cursorQuery.getString(cursorQuery.getColumnIndex("messageid")), cursorQuery.getString(cursorQuery.getColumnIndex("taskid")), cursorQuery.getString(cursorQuery.getColumnIndex("appid")), cursorQuery.getBlob(cursorQuery.getColumnIndexOrThrow("info")), cursorQuery.getBlob(cursorQuery.getColumnIndex("msgextra")), cursorQuery.getString(cursorQuery.getColumnIndex("key")), cursorQuery.getInt(cursorQuery.getColumnIndex("status")), cursorQuery.getLong(cursorQuery.getColumnIndex("createtime"))));
                }
                try {
                    this.d = arrayList;
                    arrayList.size();
                } catch (java.lang.Throwable th) {
                    th = th;
                    try {
                        com.igexin.c.a.c.a.a(th);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                            return;
                        }
                        return;
                    } finally {
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    @Override // com.igexin.push.core.e.a
    public final void a(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        java.util.ArrayList<com.igexin.push.core.b.k> arrayList;
        if (!this.e || (arrayList = this.d) == null || arrayList.size() <= 0) {
            return;
        }
        java.util.ArrayList<com.igexin.push.core.b.k> arrayList2 = this.d;
        try {
            for (com.igexin.push.core.b.k kVar : arrayList2) {
                byte[] bArr = kVar.e;
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put(com.igexin.push.core.b.C, java.lang.Long.valueOf(kVar.a));
                contentValues.put("messageid", kVar.b);
                contentValues.put("taskid", kVar.c);
                contentValues.put("appid", kVar.d);
                if (bArr != null) {
                    contentValues.put("info", bArr);
                }
                if (kVar.f != null) {
                    contentValues.put("msgextra", kVar.f);
                }
                contentValues.put("key", kVar.g);
                contentValues.put("status", java.lang.Integer.valueOf(kVar.h));
                contentValues.put("createtime", java.lang.Long.valueOf(kVar.i));
                sQLiteDatabase.insert("message", null, contentValues);
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        arrayList2.clear();
    }

    @Override // com.igexin.push.core.e.a
    public final void b(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void c(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
    }

    public final void d(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        this.e = true;
        android.database.Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteDatabase.query("message", null, "status =?", new java.lang.String[]{"0"}, null, null, null, null);
            if (cursorQuery != null) {
                java.util.ArrayList<com.igexin.push.core.b.k> arrayList = new java.util.ArrayList<>();
                while (cursorQuery.moveToNext()) {
                    arrayList.add(new com.igexin.push.core.b.k(cursorQuery.getInt(cursorQuery.getColumnIndex(com.igexin.push.core.b.C)), cursorQuery.getString(cursorQuery.getColumnIndex("messageid")), cursorQuery.getString(cursorQuery.getColumnIndex("taskid")), cursorQuery.getString(cursorQuery.getColumnIndex("appid")), cursorQuery.getBlob(cursorQuery.getColumnIndexOrThrow("info")), cursorQuery.getBlob(cursorQuery.getColumnIndex("msgextra")), cursorQuery.getString(cursorQuery.getColumnIndex("key")), cursorQuery.getInt(cursorQuery.getColumnIndex("status")), cursorQuery.getLong(cursorQuery.getColumnIndex("createtime"))));
                }
                this.d = arrayList;
                arrayList.size();
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (java.lang.Throwable th) {
            try {
                com.igexin.c.a.c.a.a(th);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } finally {
            }
        }
    }
}
