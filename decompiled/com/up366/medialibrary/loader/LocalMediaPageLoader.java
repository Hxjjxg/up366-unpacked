package com.up366.medialibrary.loader;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class LocalMediaPageLoader extends com.up366.medialibrary.loader.IBridgeMediaLoader {
    private static final java.lang.String COLUMN_BUCKET_ID = "bucket_id";
    private static final java.lang.String COLUMN_COUNT = "count";
    private static final long FILE_SIZE_UNIT = 1048576;
    private static final java.lang.String GROUP_BY_BUCKET_Id = " GROUP BY (bucket_id";
    private static final java.lang.String NOT_GIF = " AND (mime_type!='image/gif' AND mime_type!='image/*')";
    private static final java.lang.String NOT_GIF_UNKNOWN = "!='image/*'";
    private static final java.lang.String ORDER_BY = "_id DESC";
    private static final java.lang.String TAG = "LocalMediaPageLoader";
    private final com.up366.medialibrary.config.PictureSelectionConfig config;
    private final android.content.Context mContext;
    private static final android.net.Uri QUERY_URI = android.provider.MediaStore.Files.getContentUri("external");
    private static final java.lang.String COLUMN_BUCKET_DISPLAY_NAME = "bucket_display_name";
    private static final java.lang.String[] PROJECTION_29 = {"_id", "bucket_id", COLUMN_BUCKET_DISPLAY_NAME, "mime_type"};
    private static final java.lang.String[] PROJECTION = {"_id", "_data", "bucket_id", COLUMN_BUCKET_DISPLAY_NAME, "mime_type", "COUNT(*) AS count"};
    private static final java.lang.String[] PROJECTION_PAGE = {"_id", "_data", "mime_type", "width", "height", "duration", "_size", COLUMN_BUCKET_DISPLAY_NAME, "_display_name", "bucket_id", "date_added"};
    private static volatile long lastLoadDbTime = 0;

    public LocalMediaPageLoader(android.content.Context context, com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig) {
        this.mContext = context;
        this.config = pictureSelectionConfig;
    }

    private static java.lang.String getSelectionArgsForAllMediaCondition(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("(media_type=?");
        sb.append(str3);
        sb.append(" OR media_type=? AND ");
        sb.append(str);
        sb.append(") AND ");
        sb.append(str2);
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            return sb.toString();
        }
        sb.append(") GROUP BY (bucket_id");
        return sb.toString();
    }

    private static java.lang.String getSelectionArgsForImageMediaCondition(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            sb.append("media_type=?");
            sb.append(str);
            sb.append(" AND ");
            sb.append(str2);
            return sb.toString();
        }
        sb.append("(media_type=?");
        sb.append(str);
        sb.append(") AND ");
        sb.append(str2);
        sb.append(") GROUP BY (bucket_id");
        return sb.toString();
    }

    private static java.lang.String getSelectionArgsForVideoOrAudioMediaCondition(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            sb.append("media_type=?");
            sb.append(str);
            sb.append(" AND ");
            sb.append(str2);
            return sb.toString();
        }
        sb.append("(media_type=?");
        sb.append(str);
        sb.append(") AND ");
        sb.append(str2);
        sb.append(") GROUP BY (bucket_id");
        return sb.toString();
    }

    private static java.lang.String[] getSelectionArgsForAllMediaType() {
        return new java.lang.String[]{java.lang.String.valueOf(1), java.lang.String.valueOf(3)};
    }

    private static java.lang.String[] getSelectionArgsForSingleMediaType(int i) {
        return new java.lang.String[]{java.lang.String.valueOf(i)};
    }

    private static java.lang.String[] getSelectionArgsForPageSingleMediaType(int i, long j) {
        return j == -1 ? new java.lang.String[]{java.lang.String.valueOf(i)} : new java.lang.String[]{java.lang.String.valueOf(i), com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Long.valueOf(j))};
    }

    @Override // com.up366.medialibrary.loader.IBridgeMediaLoader
    public java.lang.String getFirstCover(long j) throws java.lang.Throwable {
        android.database.Cursor cursor;
        android.database.Cursor cursor2 = null;
        try {
            android.database.Cursor cursorQuery = com.up366.medialibrary.common.utils.SdkVersionUtils.isR() ? this.mContext.getContentResolver().query(QUERY_URI, new java.lang.String[]{"_id", "mime_type", "_data"}, com.up366.medialibrary.common.utils.MediaUtils.createQueryArgsBundle(getPageSelection(j), getPageSelectionArgs(j), 1, 0), null) : this.mContext.getContentResolver().query(QUERY_URI, new java.lang.String[]{"_id", "mime_type", "_data"}, getPageSelection(j), getPageSelectionArgs(j), "_id DESC limit 1 offset 0");
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.getCount() > 0) {
                        if (!cursorQuery.moveToFirst()) {
                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                                cursorQuery.close();
                            }
                            return null;
                        }
                        java.lang.String realPathUri = com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() ? com.up366.medialibrary.common.utils.MimeTypeUtils.getRealPathUri(cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id")), cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("mime_type"))) : cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                        return realPathUri;
                    }
                } catch (java.lang.Exception e) {
                    cursor = cursorQuery;
                    e = e;
                    try {
                        e.printStackTrace();
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null && !cursor2.isClosed()) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    cursor2 = cursorQuery;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null && !cursorQuery.isClosed()) {
                cursorQuery.close();
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            cursor = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
        return null;
    }

    @Override // com.up366.medialibrary.loader.IBridgeMediaLoader
    public void loadPageMediaData(long j, int i, int i2, com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMedia> onQueryDataResultListener) {
        loadPageMediaData(j, i, i2, this.config.pageSize, onQueryDataResultListener);
    }

    @Override // com.up366.medialibrary.loader.IBridgeMediaLoader
    public void loadPageMediaData(long j, int i, com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMedia> onQueryDataResultListener) {
        loadPageMediaData(j, i, this.config.pageSize, this.config.pageSize, onQueryDataResultListener);
    }

    @Override // com.up366.medialibrary.loader.IBridgeMediaLoader
    public void loadPageMediaData(final long j, final int i, final int i2, final int i3, final com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMedia> onQueryDataResultListener) {
        com.up366.medialibrary.common.utils.PictureThreadUtils.executeByIo(new com.up366.medialibrary.common.utils.PictureThreadUtils.SimpleTask<com.up366.medialibrary.model.MediaDbData>() { // from class: com.up366.medialibrary.loader.LocalMediaPageLoader.1
            /* JADX WARN: Removed duplicated region for block: B:112:0x0255 A[EDGE_INSN: B:112:0x0255->B:77:0x0255 BREAK  A[LOOP:0: B:17:0x0117->B:78:0x0256], SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x0184 A[Catch: all -> 0x028d, Exception -> 0x028f, PHI: r3
  0x0184: PHI (r3v13 java.lang.String) = (r3v12 java.lang.String), (r3v17 java.lang.String), (r3v17 java.lang.String) binds: [B:30:0x0162, B:36:0x017b, B:38:0x0181] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x028f, blocks: (B:3:0x0005, B:5:0x000c, B:14:0x008e, B:16:0x009a, B:17:0x0117, B:19:0x0125, B:20:0x0129, B:22:0x0137, B:24:0x0144, B:26:0x014e, B:75:0x024f, B:29:0x015c, B:31:0x0164, B:33:0x016a, B:35:0x0173, B:37:0x017d, B:34:0x016f, B:40:0x0184, B:42:0x018e, B:45:0x0199, B:47:0x01a3, B:50:0x01ae, B:52:0x01dc, B:56:0x01f2, B:58:0x01f8, B:60:0x0202, B:63:0x0210, B:65:0x021a, B:74:0x0234, B:79:0x0262, B:83:0x026d, B:6:0x003f, B:11:0x0065, B:10:0x0048), top: B:109:0x0005, outer: #1 }] */
            /* JADX WARN: Removed duplicated region for block: B:78:0x0256 A[LOOP:0: B:17:0x0117->B:78:0x0256, LOOP_END] */
            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.up366.medialibrary.model.MediaDbData doInBackground() {
                /*
                    Method dump skipped, instruction units count: 716
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.up366.medialibrary.loader.LocalMediaPageLoader.AnonymousClass1.doInBackground():com.up366.medialibrary.model.MediaDbData");
            }

            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            public void onSuccess(com.up366.medialibrary.model.MediaDbData mediaDbData) {
                com.up366.medialibrary.common.utils.PictureThreadUtils.cancel(com.up366.medialibrary.common.utils.PictureThreadUtils.getIoPool());
                com.up366.medialibrary.listener.OnQueryDataResultListener onQueryDataResultListener2 = onQueryDataResultListener;
                if (onQueryDataResultListener2 != null) {
                    onQueryDataResultListener2.onComplete(mediaDbData.data != null ? mediaDbData.data : new java.util.ArrayList(), i, mediaDbData.isHasNextMore);
                }
            }
        });
    }

    @Override // com.up366.medialibrary.loader.IBridgeMediaLoader
    public void loadOnlyInAppDirectoryAllMedia(final com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMediaFolder> onQueryDataResultListener) {
        com.up366.medialibrary.common.utils.PictureThreadUtils.executeByIo(new com.up366.medialibrary.common.utils.PictureThreadUtils.SimpleTask<com.up366.medialibrary.model.LocalMediaFolder>() { // from class: com.up366.medialibrary.loader.LocalMediaPageLoader.2
            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            public com.up366.medialibrary.model.LocalMediaFolder doInBackground() {
                return com.up366.medialibrary.loader.SandboxFileLoader.loadInAppSandboxFolderFile(com.up366.medialibrary.loader.LocalMediaPageLoader.this.mContext, com.up366.medialibrary.loader.LocalMediaPageLoader.this.config.sandboxFolderPath);
            }

            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            public void onSuccess(com.up366.medialibrary.model.LocalMediaFolder localMediaFolder) {
                com.up366.medialibrary.common.utils.PictureThreadUtils.cancel(com.up366.medialibrary.common.utils.PictureThreadUtils.getIoPool());
                com.up366.medialibrary.listener.OnQueryDataResultListener onQueryDataResultListener2 = onQueryDataResultListener;
                if (onQueryDataResultListener2 != null) {
                    onQueryDataResultListener2.onComplete(localMediaFolder);
                }
            }
        });
    }

    @Override // com.up366.medialibrary.loader.IBridgeMediaLoader
    public void loadAllMedia(com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMediaFolder> onQueryDataResultListener) {
        if (com.up366.medialibrary.common.utils.MMKVUtils.getInst().getMediaCount() == 0) {
            loadFromDb(onQueryDataResultListener);
            return;
        }
        if (onQueryDataResultListener != null) {
            onQueryDataResultListener.onComplete(com.up366.medialibrary.common.utils.MMKVUtils.getInst().getCacheMediaDatas());
        }
        if (java.lang.System.currentTimeMillis() - lastLoadDbTime > 15000) {
            loadFromDb(onQueryDataResultListener);
        }
    }

    private void loadFromDb(final com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMediaFolder> onQueryDataResultListener) {
        lastLoadDbTime = java.lang.System.currentTimeMillis();
        com.up366.medialibrary.common.utils.PictureThreadUtils.executeByIo(new com.up366.medialibrary.common.utils.PictureThreadUtils.SimpleTask<java.util.List<com.up366.medialibrary.model.LocalMediaFolder>>() { // from class: com.up366.medialibrary.loader.LocalMediaPageLoader.3
            /* JADX WARN: Removed duplicated region for block: B:86:0x026b  */
            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.util.List<com.up366.medialibrary.model.LocalMediaFolder> doInBackground() throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 628
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.up366.medialibrary.loader.LocalMediaPageLoader.AnonymousClass3.doInBackground():java.util.List");
            }

            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            public void onSuccess(java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) {
                com.up366.medialibrary.common.utils.PictureThreadUtils.cancel(com.up366.medialibrary.common.utils.PictureThreadUtils.getIoPool());
                com.up366.common.log.Logger.error("loadAllMedia .... 44444 ");
                com.up366.medialibrary.listener.OnQueryDataResultListener onQueryDataResultListener2 = onQueryDataResultListener;
                if (onQueryDataResultListener2 != null) {
                    onQueryDataResultListener2.onComplete((java.util.List) list);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void synchronousFirstCover(java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) throws java.lang.Throwable {
        for (int i = 0; i < list.size(); i++) {
            com.up366.medialibrary.model.LocalMediaFolder localMediaFolder = list.get(i);
            if (localMediaFolder != null) {
                java.lang.String value = com.up366.medialibrary.common.utils.MMKVUtils.getInst().getValue(localMediaFolder.getBucketId());
                if ("".equals(value)) {
                    value = getFirstCover(localMediaFolder.getBucketId());
                    com.up366.medialibrary.common.utils.MMKVUtils.getInst().putValue(localMediaFolder.getBucketId(), value);
                }
                if (!android.text.TextUtils.isEmpty(value)) {
                    localMediaFolder.setFirstImagePath(value);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String getFirstUri(android.database.Cursor cursor) {
        return com.up366.medialibrary.common.utils.MimeTypeUtils.getRealPathUri(cursor.getLong(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("mime_type")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String getFirstCoverMimeType(android.database.Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("mime_type"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String getFirstUrl(android.database.Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("_data"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getPageSelection(long j) {
        java.lang.String durationCondition = getDurationCondition();
        java.lang.String fileSizeCondition = getFileSizeCondition();
        java.lang.String queryMimeCondition = getQueryMimeCondition();
        int i = this.config.chooseMode;
        if (i == 0) {
            return getPageSelectionArgsForAllMediaCondition(j, queryMimeCondition, durationCondition, fileSizeCondition);
        }
        if (i == 1) {
            return getPageSelectionArgsForImageMediaCondition(j, queryMimeCondition, fileSizeCondition);
        }
        if (i == 2 || i == 3) {
            return getPageSelectionArgsForVideoOrAudioMediaCondition(j, queryMimeCondition, durationCondition, fileSizeCondition);
        }
        return null;
    }

    private static java.lang.String getPageSelectionArgsForAllMediaCondition(long j, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("(media_type=?");
        sb.append(str);
        sb.append(" OR media_type=? AND ");
        sb.append(str2);
        sb.append(") AND ");
        if (j == -1) {
            sb.append(str3);
            return sb.toString();
        }
        sb.append("bucket_id=? AND ");
        sb.append(str3);
        return sb.toString();
    }

    private static java.lang.String getPageSelectionArgsForImageMediaCondition(long j, java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("(media_type=?");
        if (j == -1) {
            sb.append(str);
            sb.append(") AND ");
            sb.append(str2);
            return sb.toString();
        }
        sb.append(str);
        sb.append(") AND bucket_id=? AND ");
        sb.append(str2);
        return sb.toString();
    }

    private static java.lang.String getPageSelectionArgsForVideoOrAudioMediaCondition(long j, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("(media_type=?");
        sb.append(str);
        sb.append(" AND ");
        sb.append(str2);
        sb.append(") AND ");
        if (j == -1) {
            sb.append(str3);
            return sb.toString();
        }
        sb.append("bucket_id=? AND ");
        sb.append(str3);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String[] getPageSelectionArgs(long j) {
        int i = this.config.chooseMode;
        if (i == 0) {
            if (j == -1) {
                return new java.lang.String[]{java.lang.String.valueOf(1), java.lang.String.valueOf(3)};
            }
            return new java.lang.String[]{java.lang.String.valueOf(1), java.lang.String.valueOf(3), com.up366.medialibrary.common.utils.ValueOf.toString(java.lang.Long.valueOf(j))};
        }
        if (i == 1) {
            return getSelectionArgsForPageSingleMediaType(1, j);
        }
        if (i == 2) {
            return getSelectionArgsForPageSingleMediaType(3, j);
        }
        if (i != 3) {
            return null;
        }
        return getSelectionArgsForPageSingleMediaType(2, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getSelection() {
        java.lang.String fileSizeCondition = getFileSizeCondition();
        java.lang.String queryMimeCondition = getQueryMimeCondition();
        int i = this.config.chooseMode;
        if (i == 0) {
            return getSelectionArgsForAllMediaCondition(getDurationCondition(), fileSizeCondition, queryMimeCondition);
        }
        if (i == 1) {
            return getSelectionArgsForImageMediaCondition(queryMimeCondition, fileSizeCondition);
        }
        if (i == 2 || i == 3) {
            return getSelectionArgsForVideoOrAudioMediaCondition(queryMimeCondition, fileSizeCondition);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String[] getSelectionArgs() {
        int i = this.config.chooseMode;
        if (i == 0) {
            return getSelectionArgsForAllMediaType();
        }
        if (i == 1) {
            return getSelectionArgsForSingleMediaType(1);
        }
        if (i == 2) {
            return getSelectionArgsForSingleMediaType(3);
        }
        if (i != 3) {
            return null;
        }
        return getSelectionArgsForSingleMediaType(2);
    }

    private java.lang.String getDurationCondition() {
        return java.lang.String.format(java.util.Locale.CHINA, "%d <%s duration and duration <= %d", java.lang.Long.valueOf(java.lang.Math.max(0L, this.config.videoMinSecond)), java.lang.Math.max(0L, (long) this.config.videoMinSecond) == 0 ? "" : "=", java.lang.Long.valueOf(this.config.videoMaxSecond == 0 ? Long.MAX_VALUE : this.config.videoMaxSecond));
    }

    private java.lang.String getFileSizeCondition() {
        return java.lang.String.format(java.util.Locale.CHINA, "%d <%s _size and _size <= %d", java.lang.Long.valueOf(java.lang.Math.max(0L, this.config.filterMinFileSize)), java.lang.Math.max(0L, this.config.filterMinFileSize) == 0 ? "" : "=", java.lang.Long.valueOf(this.config.filterMaxFileSize == 0 ? Long.MAX_VALUE : this.config.filterMaxFileSize));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String getQueryMimeCondition() {
        /*
            r10 = this;
            com.up366.medialibrary.config.PictureSelectionConfig r0 = r10.config
            java.util.HashSet<java.lang.String> r0 = r0.queryMimeTypeHashSet
            if (r0 != 0) goto Lb
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
        Lb:
            com.up366.medialibrary.config.PictureSelectionConfig r1 = r10.config
            java.lang.String r1 = r1.specifiedFormat
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L1c
            com.up366.medialibrary.config.PictureSelectionConfig r1 = r10.config
            java.lang.String r1 = r1.specifiedFormat
            r0.add(r1)
        L1c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.Iterator r2 = r0.iterator()
            r3 = -1
        L26:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L9f
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L39
            goto L26
        L39:
            com.up366.medialibrary.config.PictureSelectionConfig r5 = r10.config
            int r5 = r5.chooseMode
            int r6 = com.up366.medialibrary.common.utils.MimeTypeUtils.ofVideo()
            java.lang.String r7 = "audio"
            java.lang.String r8 = "image"
            if (r5 != r6) goto L54
            boolean r5 = r4.startsWith(r8)
            if (r5 != 0) goto L26
            boolean r5 = r4.startsWith(r7)
            if (r5 == 0) goto L85
            goto L26
        L54:
            com.up366.medialibrary.config.PictureSelectionConfig r5 = r10.config
            int r5 = r5.chooseMode
            int r6 = com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage()
            java.lang.String r9 = "video"
            if (r5 != r6) goto L6e
            boolean r5 = r4.startsWith(r7)
            if (r5 != 0) goto L26
            boolean r5 = r4.startsWith(r9)
            if (r5 == 0) goto L85
            goto L26
        L6e:
            com.up366.medialibrary.config.PictureSelectionConfig r5 = r10.config
            int r5 = r5.chooseMode
            int r6 = com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio()
            if (r5 != r6) goto L85
            boolean r5 = r4.startsWith(r9)
            if (r5 != 0) goto L26
            boolean r5 = r4.startsWith(r8)
            if (r5 == 0) goto L85
            goto L26
        L85:
            int r3 = r3 + 1
            if (r3 != 0) goto L8c
            java.lang.String r5 = " AND "
            goto L8e
        L8c:
            java.lang.String r5 = " OR "
        L8e:
            r1.append(r5)
            java.lang.String r5 = "mime_type='"
            r1.append(r5)
            r1.append(r4)
            java.lang.String r4 = "'"
            r1.append(r4)
            goto L26
        L9f:
            com.up366.medialibrary.config.PictureSelectionConfig r2 = r10.config
            int r2 = r2.chooseMode
            int r3 = com.up366.medialibrary.common.utils.MimeTypeUtils.ofVideo()
            if (r2 == r3) goto Lbe
            com.up366.medialibrary.config.PictureSelectionConfig r2 = r10.config
            boolean r2 = r2.isGif
            if (r2 != 0) goto Lbe
            java.lang.String r2 = com.up366.medialibrary.common.utils.MimeTypeUtils.ofGIF()
            boolean r0 = r0.contains(r2)
            if (r0 != 0) goto Lbe
            java.lang.String r0 = " AND (mime_type!='image/gif' AND mime_type!='image/*')"
            r1.append(r0)
        Lbe:
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.medialibrary.loader.LocalMediaPageLoader.getQueryMimeCondition():java.lang.String");
    }
}
