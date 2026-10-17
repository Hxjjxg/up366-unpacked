package com.up366.medialibrary.loader;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@java.lang.Deprecated
public final class LocalMediaLoader extends com.up366.medialibrary.loader.IBridgeMediaLoader {
    private static final long FILE_SIZE_UNIT = 1048576;
    private static final int MAX_SORT_SIZE = 60;
    private static final java.lang.String NOT_GIF = " AND (mime_type!='image/gif' AND mime_type!='image/*')";
    private static final java.lang.String NOT_GIF_UNKNOWN = "!='image/*'";
    private static final java.lang.String ORDER_BY = "_id DESC";
    private final com.up366.medialibrary.config.PictureSelectionConfig config;
    private final boolean isAndroidQ = com.up366.medialibrary.common.utils.SdkVersionUtils.isQ();
    private final android.content.Context mContext;
    private static final android.net.Uri QUERY_URI = android.provider.MediaStore.Files.getContentUri("external");
    private static final java.lang.String[] PROJECTION = {"_id", "_data", "mime_type", "width", "height", "duration", "_size", "bucket_display_name", "_display_name", com.up366.medialibrary.config.PictureConstants.EXTRA_BUCKET_ID, "date_added"};

    private static java.lang.String getSelectionArgsForVideoOrAudioMediaCondition(java.lang.String str, java.lang.String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    private static java.lang.String getSelectionArgsForAllMediaCondition(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return "(media_type=?" + str3 + " OR media_type=? AND " + str + ") AND " + str2;
    }

    private static java.lang.String getSelectionArgsForImageMediaCondition(java.lang.String str, java.lang.String str2) {
        return "media_type=?" + str2 + " AND " + str;
    }

    private static java.lang.String[] getSelectionArgsForAllMediaType() {
        return new java.lang.String[]{java.lang.String.valueOf(1), java.lang.String.valueOf(3)};
    }

    private static java.lang.String[] getSelectionArgsForSingleMediaType(int i) {
        return new java.lang.String[]{java.lang.String.valueOf(i)};
    }

    public LocalMediaLoader(android.content.Context context, com.up366.medialibrary.config.PictureSelectionConfig pictureSelectionConfig) {
        this.mContext = context.getApplicationContext();
        this.config = pictureSelectionConfig;
    }

    @Override // com.up366.medialibrary.loader.IBridgeMediaLoader
    public void loadOnlyInAppDirectoryAllMedia(final com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMediaFolder> onQueryDataResultListener) {
        com.up366.medialibrary.common.utils.PictureThreadUtils.executeByIo(new com.up366.medialibrary.common.utils.PictureThreadUtils.SimpleTask<com.up366.medialibrary.model.LocalMediaFolder>() { // from class: com.up366.medialibrary.loader.LocalMediaLoader.1
            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            public com.up366.medialibrary.model.LocalMediaFolder doInBackground() {
                return com.up366.medialibrary.loader.SandboxFileLoader.loadInAppSandboxFolderFile(com.up366.medialibrary.loader.LocalMediaLoader.this.mContext, com.up366.medialibrary.loader.LocalMediaLoader.this.config.sandboxFolderPath);
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
    public void loadAllMedia(final com.up366.medialibrary.listener.OnQueryDataResultListener<com.up366.medialibrary.model.LocalMediaFolder> onQueryDataResultListener) {
        com.up366.medialibrary.common.utils.PictureThreadUtils.executeByIo(new com.up366.medialibrary.common.utils.PictureThreadUtils.SimpleTask<java.util.List<com.up366.medialibrary.model.LocalMediaFolder>>() { // from class: com.up366.medialibrary.loader.LocalMediaLoader.2
            /* JADX WARN: Removed duplicated region for block: B:102:0x023e A[EDGE_INSN: B:102:0x023e->B:64:0x023e BREAK  A[LOOP:0: B:7:0x00c0->B:80:0x02f2], SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0117 A[Catch: all -> 0x0307, Exception -> 0x0309, PHI: r5
  0x0117: PHI (r5v7 java.lang.String) = (r5v6 java.lang.String), (r5v28 java.lang.String), (r5v28 java.lang.String) binds: [B:15:0x00f5, B:21:0x010e, B:23:0x0114] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x0309, blocks: (B:4:0x002d, B:6:0x003d, B:7:0x00c0, B:9:0x00ce, B:10:0x00d2, B:12:0x00e4, B:14:0x00ef, B:16:0x00f7, B:18:0x00fd, B:20:0x0106, B:22:0x0110, B:62:0x0238, B:64:0x023e, B:66:0x0252, B:68:0x0278, B:70:0x027e, B:71:0x0286, B:72:0x0289, B:74:0x028f, B:76:0x02be, B:78:0x02d7, B:77:0x02cb, B:19:0x0102, B:25:0x0117, B:27:0x0121, B:30:0x013a, B:32:0x0144, B:35:0x014f, B:37:0x0187, B:41:0x019f, B:43:0x01a5, B:45:0x01af, B:49:0x01c4, B:51:0x01ce, B:61:0x01eb), top: B:99:0x002d, outer: #1 }] */
            /* JADX WARN: Removed duplicated region for block: B:80:0x02f2 A[LOOP:0: B:7:0x00c0->B:80:0x02f2, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:95:0x0324 A[DONT_GENERATE] */
            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.util.List<com.up366.medialibrary.model.LocalMediaFolder> doInBackground() {
                /*
                    Method dump skipped, instruction units count: 814
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.up366.medialibrary.loader.LocalMediaLoader.AnonymousClass2.doInBackground():java.util.List");
            }

            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            public void onSuccess(java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) {
                com.up366.medialibrary.common.utils.PictureThreadUtils.cancel(com.up366.medialibrary.common.utils.PictureThreadUtils.getIoPool());
                com.up366.medialibrary.listener.OnQueryDataResultListener onQueryDataResultListener2 = onQueryDataResultListener;
                if (onQueryDataResultListener2 != null) {
                    onQueryDataResultListener2.onComplete((java.util.List) list);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String getSelection() {
        java.lang.String durationCondition = getDurationCondition();
        java.lang.String fileSizeCondition = getFileSizeCondition();
        java.lang.String queryMimeCondition = getQueryMimeCondition();
        int i = this.config.chooseMode;
        if (i == 0) {
            return getSelectionArgsForAllMediaCondition(durationCondition, fileSizeCondition, queryMimeCondition);
        }
        if (i == 1) {
            return getSelectionArgsForImageMediaCondition(fileSizeCondition, queryMimeCondition);
        }
        if (i == 2) {
            return getSelectionArgsForVideoOrAudioMediaCondition(fileSizeCondition, queryMimeCondition);
        }
        if (i != 3) {
            return null;
        }
        return getSelectionArgsForVideoOrAudioMediaCondition(durationCondition, queryMimeCondition);
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

    /* JADX INFO: Access modifiers changed from: private */
    public com.up366.medialibrary.model.LocalMediaFolder getImageFolder(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.List<com.up366.medialibrary.model.LocalMediaFolder> list) {
        if (!this.config.isFallbackVersion) {
            for (com.up366.medialibrary.model.LocalMediaFolder localMediaFolder : list) {
                java.lang.String name = localMediaFolder.getName();
                if (!android.text.TextUtils.isEmpty(name) && name.equals(str3)) {
                    return localMediaFolder;
                }
            }
            com.up366.medialibrary.model.LocalMediaFolder localMediaFolder2 = new com.up366.medialibrary.model.LocalMediaFolder();
            localMediaFolder2.setName(str3);
            localMediaFolder2.setFirstImagePath(str);
            localMediaFolder2.setFirstMimeType(str2);
            list.add(localMediaFolder2);
            return localMediaFolder2;
        }
        java.io.File parentFile = new java.io.File(str).getParentFile();
        for (com.up366.medialibrary.model.LocalMediaFolder localMediaFolder3 : list) {
            java.lang.String name2 = localMediaFolder3.getName();
            if (!android.text.TextUtils.isEmpty(name2) && parentFile != null && name2.equals(parentFile.getName())) {
                return localMediaFolder3;
            }
        }
        com.up366.medialibrary.model.LocalMediaFolder localMediaFolder4 = new com.up366.medialibrary.model.LocalMediaFolder();
        localMediaFolder4.setName(parentFile != null ? parentFile.getName() : "");
        localMediaFolder4.setFirstImagePath(str);
        localMediaFolder4.setFirstMimeType(str2);
        list.add(localMediaFolder4);
        return localMediaFolder4;
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
        throw new UnsupportedOperationException("Method not decompiled: com.up366.medialibrary.loader.LocalMediaLoader.getQueryMimeCondition():java.lang.String");
    }
}
