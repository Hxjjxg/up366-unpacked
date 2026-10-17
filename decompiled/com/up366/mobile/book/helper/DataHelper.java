package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class DataHelper {
    public int saveData(java.lang.String str, java.lang.String str2) {
        try {
            com.up366.mobile.book.model.SpeechDataInfo speechDataInfo = new com.up366.mobile.book.model.SpeechDataInfo(str, str2, com.up366.common.TimeUtils.formatTime(com.up366.common.TimeUtils.getCurrentNtpTimeInMillisecond(), "yyyy-MM-dd HH:mm:ss"));
            com.up366.greendao.SpeechDataInfoDao speechDataInfoDao = com.up366.mobile.common.logic.Auth.cur().db().getSpeechDataInfoDao();
            if (com.up366.common.StringUtils.isEmptyOrNull(str2)) {
                deleteData(str);
                return 1;
            }
            speechDataInfoDao.insertOrReplace(speechDataInfo);
            return 1;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - DataHelper - saveData - ", e);
            return 0;
        }
    }

    public int deleteData(java.lang.String str) {
        try {
            com.up366.mobile.common.logic.Auth.cur().db().getSpeechDataInfoDao().queryBuilder().where(com.up366.greendao.SpeechDataInfoDao.Properties.Guid.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).buildDelete().executeDeleteWithoutDetachingEntities();
            return 1;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - DataHelper - deleteData - ", e);
            return 0;
        }
    }

    public java.lang.String loadData(java.lang.String str) {
        try {
            com.up366.mobile.book.model.SpeechDataInfo speechDataInfo = (com.up366.mobile.book.model.SpeechDataInfo) com.up366.mobile.common.logic.Auth.cur().db().getSpeechDataInfoDao().queryBuilder().where(com.up366.greendao.SpeechDataInfoDao.Properties.Guid.eq(str), new org.greenrobot.greendao.query.WhereCondition[0]).unique();
            if (speechDataInfo != null) {
                return speechDataInfo.getData();
            }
            return "";
        } catch (android.database.sqlite.SQLiteBlobTooBigException unused) {
            long j = 10485760;
            while (j < 104857600) {
                try {
                    com.up366.common.log.Logger.info("TAG - DataHelper - loadData - with window size:" + j);
                    com.up366.mobile.book.model.SpeechDataInfo speechDataInfoRawQuerySpeechDataInfo = rawQuerySpeechDataInfo(str, j);
                    if (speechDataInfoRawQuerySpeechDataInfo != null) {
                        return speechDataInfoRawQuerySpeechDataInfo.getData();
                    }
                    continue;
                } catch (android.database.sqlite.SQLiteBlobTooBigException unused2) {
                    j *= 2;
                }
            }
            return "";
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("TAG - DataHelper - loadData - " + e.getMessage(), e);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.up366.mobile.book.model.SpeechDataInfo rawQuerySpeechDataInfo(java.lang.String r3, long r4) {
        /*
            r2 = this;
            com.up366.mobile.common.logic.Manager r0 = com.up366.mobile.common.logic.Auth.cur()
            com.up366.greendao.DaoSession r0 = r0.db()
            org.greenrobot.greendao.database.Database r0 = r0.getDatabase()
            java.lang.Object r0 = r0.getRawDatabase()
            android.database.sqlite.SQLiteDatabase r0 = (android.database.sqlite.SQLiteDatabase) r0
            java.lang.String r1 = r0.getPath()
            android.database.CursorWindow r4 = androidx.core.database.CursorWindowCompat.create(r1, r4)
            java.lang.String r5 = "select guid, data, data1 from speech_data_info where guid = ?;"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L71
            android.database.Cursor r3 = r0.rawQuery(r5, r3)     // Catch: java.lang.Throwable -> L71
            r5 = r3
            android.database.sqlite.SQLiteCursor r5 = (android.database.sqlite.SQLiteCursor) r5     // Catch: java.lang.Throwable -> L65
            r5.setWindow(r4)     // Catch: java.lang.Throwable -> L65
            boolean r5 = r3.moveToNext()     // Catch: java.lang.Throwable -> L65
            if (r5 == 0) goto L59
            com.up366.mobile.book.model.SpeechDataInfo r5 = new com.up366.mobile.book.model.SpeechDataInfo     // Catch: java.lang.Throwable -> L65
            r5.<init>()     // Catch: java.lang.Throwable -> L65
            r0 = 0
            java.lang.String r0 = r3.getString(r0)     // Catch: java.lang.Throwable -> L65
            r5.setGuid(r0)     // Catch: java.lang.Throwable -> L65
            r0 = 1
            java.lang.String r0 = r3.getString(r0)     // Catch: java.lang.Throwable -> L65
            r5.setData(r0)     // Catch: java.lang.Throwable -> L65
            r0 = 2
            java.lang.String r0 = r3.getString(r0)     // Catch: java.lang.Throwable -> L65
            r5.setData1(r0)     // Catch: java.lang.Throwable -> L65
            if (r3 == 0) goto L53
            r3.close()     // Catch: java.lang.Throwable -> L71
        L53:
            if (r4 == 0) goto L58
            r4.close()
        L58:
            return r5
        L59:
            if (r3 == 0) goto L5e
            r3.close()     // Catch: java.lang.Throwable -> L71
        L5e:
            if (r4 == 0) goto L63
            r4.close()
        L63:
            r3 = 0
            return r3
        L65:
            r5 = move-exception
            if (r3 == 0) goto L70
            r3.close()     // Catch: java.lang.Throwable -> L6c
            goto L70
        L6c:
            r3 = move-exception
            r5.addSuppressed(r3)     // Catch: java.lang.Throwable -> L71
        L70:
            throw r5     // Catch: java.lang.Throwable -> L71
        L71:
            r3 = move-exception
            if (r4 == 0) goto L7c
            r4.close()     // Catch: java.lang.Throwable -> L78
            goto L7c
        L78:
            r4 = move-exception
            r3.addSuppressed(r4)
        L7c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.helper.DataHelper.rawQuerySpeechDataInfo(java.lang.String, long):com.up366.mobile.book.model.SpeechDataInfo");
    }
}
