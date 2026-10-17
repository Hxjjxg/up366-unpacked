package com.up366.multimedia.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class AlbumHelper {
    public static final int ALBUM_TYPE_ALL = 0;
    public static final int ALBUM_TYPE_IMAGE = 1;
    public static final int ALBUM_TYPE_VIDEO = 2;
    public static final java.lang.String INTENT_KEY_ALBUM_IMAGE_TYPE = "image_type";
    public static final java.lang.String INTENT_KEY_ALBUM_TYPE = "album_type";
    private static com.up366.multimedia.util.AlbumHelper instance;
    private java.util.List<com.up366.multimedia.util.AlbumHelper.ImageBucket> bucketList = new java.util.ArrayList();
    private java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> imageItemList = new java.util.ArrayList();

    public static class ImageBucket {
        public java.lang.String bucketName;
        public java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> imageList = new java.util.ArrayList();
        public boolean isSelected = false;
    }

    private AlbumHelper() {
    }

    public static com.up366.multimedia.util.AlbumHelper getHelper() {
        if (instance == null) {
            instance = new com.up366.multimedia.util.AlbumHelper();
        }
        return instance;
    }

    private void buildImagesBucketList(android.content.Context context, int albumType) {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        this.bucketList.clear();
        this.imageItemList.clear();
        java.util.ArrayList<com.up366.multimedia.util.AlbumHelper.ImageItem> arrayList = new java.util.ArrayList();
        if (albumType == 0) {
            arrayList.addAll(getLocalImageList(context));
            arrayList.addAll(getLocalVideoList(context));
        }
        if (albumType == 1) {
            arrayList.addAll(getLocalImageList(context));
        }
        if (albumType == 2) {
            arrayList.addAll(getLocalVideoList(context));
        }
        for (com.up366.multimedia.util.AlbumHelper.ImageItem imageItem : arrayList) {
            com.up366.multimedia.util.AlbumHelper.ImageBucket imageBucket = (com.up366.multimedia.util.AlbumHelper.ImageBucket) linkedHashMap.get(imageItem.bucketId);
            if (imageBucket == null) {
                imageBucket = new com.up366.multimedia.util.AlbumHelper.ImageBucket();
                this.bucketList.add(imageBucket);
                linkedHashMap.put(imageItem.bucketId, imageBucket);
                imageBucket.imageList = new java.util.ArrayList();
                imageBucket.bucketName = imageItem.bucketName;
            }
            imageBucket.imageList.add(imageItem);
            this.imageItemList.add(imageItem);
        }
        com.up366.multimedia.util.AlbumHelper.ImageBucket imageBucket2 = new com.up366.multimedia.util.AlbumHelper.ImageBucket();
        imageBucket2.bucketName = "所有文件";
        imageBucket2.isSelected = true;
        imageBucket2.imageList = this.imageItemList;
        this.bucketList.add(0, imageBucket2);
        java.util.Iterator<com.up366.multimedia.util.AlbumHelper.ImageBucket> it = this.bucketList.iterator();
        while (it.hasNext()) {
            java.util.Collections.sort(it.next().imageList, new java.util.Comparator() { // from class: com.up366.multimedia.util.AlbumHelper$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(java.lang.Object obj, java.lang.Object obj2) {
                    return java.lang.Long.compare(((com.up366.multimedia.util.AlbumHelper.ImageItem) obj2).dateAdd, ((com.up366.multimedia.util.AlbumHelper.ImageItem) obj).dateAdd);
                }
            });
        }
    }

    public java.util.List<com.up366.multimedia.util.AlbumHelper.ImageBucket> getImageBuckets(android.content.Context context, int albumType) {
        try {
            buildImagesBucketList(context, albumType);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getImageList error: " + e.getMessage(), e);
        }
        return this.bucketList;
    }

    public java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> getImageList(android.content.Context context, int albumType, java.lang.String imageType) {
        try {
            buildImagesBucketList(context, albumType);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("getImageList error: " + e.getMessage(), e);
        }
        if (!com.up366.common.StringUtils.isEmptyOrNull(imageType)) {
            java.util.Iterator<com.up366.multimedia.util.AlbumHelper.ImageItem> it = this.imageItemList.iterator();
            while (it.hasNext()) {
                java.lang.String str = it.next().imagePath;
                if (!str.contains(".")) {
                    it.remove();
                } else if (!imageType.contains(str.substring(str.lastIndexOf(".") + 1))) {
                    it.remove();
                }
            }
        }
        return this.imageItemList;
    }

    public static class ImageItem implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.up366.multimedia.util.AlbumHelper.ImageItem> CREATOR = new android.os.Parcelable.Creator<com.up366.multimedia.util.AlbumHelper.ImageItem>() { // from class: com.up366.multimedia.util.AlbumHelper.ImageItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.up366.multimedia.util.AlbumHelper.ImageItem createFromParcel(android.os.Parcel source) {
                return new com.up366.multimedia.util.AlbumHelper.ImageItem(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.up366.multimedia.util.AlbumHelper.ImageItem[] newArray(int size) {
                return new com.up366.multimedia.util.AlbumHelper.ImageItem[size];
            }
        };
        public java.lang.String bucketId;
        public java.lang.String bucketName;
        public long dateAdd;
        public long duration;
        public java.lang.String imageId;
        public java.lang.String imagePath;
        public boolean isSelected;
        public android.net.Uri uri;
        public java.lang.String videoPath;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public ImageItem() {
            this.isSelected = false;
        }

        public ImageItem(java.lang.String imageId, java.lang.String imagePath, long dateAdd) {
            this.isSelected = false;
            this.imageId = imageId;
            this.imagePath = imagePath;
            this.dateAdd = dateAdd;
        }

        public ImageItem(java.lang.String imageId, java.lang.String imagePath, java.lang.String videoPath) {
            this.isSelected = false;
            this.imageId = imageId;
            this.imagePath = imagePath;
            this.videoPath = videoPath;
        }

        public ImageItem(java.lang.String imageId, java.lang.String imagePath, java.lang.String videoPath, long dateAdd, java.lang.String bucketId, java.lang.String bucketName, android.net.Uri uri, long duration) {
            this.isSelected = false;
            this.imageId = imageId;
            this.imagePath = imagePath;
            this.videoPath = videoPath;
            this.dateAdd = dateAdd;
            this.bucketId = bucketId;
            this.bucketName = bucketName;
            this.uri = uri;
            this.duration = duration;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel dest, int i) {
            dest.writeString(this.imageId);
            dest.writeString(this.imagePath);
            dest.writeBooleanArray(new boolean[]{this.isSelected});
            dest.writeLong(this.dateAdd);
            dest.writeString(this.videoPath);
            dest.writeString(this.bucketId);
            dest.writeString(this.bucketName);
            dest.writeParcelable(this.uri, i);
        }

        protected ImageItem(android.os.Parcel in) {
            this.isSelected = false;
            this.imageId = in.readString();
            this.imagePath = in.readString();
            boolean[] zArr = new boolean[1];
            in.readBooleanArray(zArr);
            this.isSelected = zArr[0];
            this.dateAdd = in.readLong();
            this.videoPath = in.readString();
            this.bucketId = in.readString();
            this.bucketName = in.readString();
            this.uri = (android.net.Uri) in.readParcelable(android.net.Uri.class.getClassLoader());
        }
    }

    private static java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> getLocalImageList(android.content.Context context) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursorQuery = context.getContentResolver().query(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new java.lang.String[]{"_id", com.up366.medialibrary.config.PictureConstants.EXTRA_BUCKET_ID, "_data", "date_added", "bucket_display_name"}, null, null, "date_added desc");
        if (cursorQuery != null) {
            try {
                try {
                } catch (java.lang.Exception e) {
                    com.up366.common.log.Logger.error("getLocalImageList error :" + e.getMessage(), e);
                    if (cursorQuery != null) {
                    }
                }
                if (cursorQuery.moveToFirst()) {
                    do {
                        arrayList.add(parseImageCursor(cursorQuery));
                    } while (cursorQuery.moveToNext());
                    return arrayList;
                }
                return arrayList;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<com.up366.multimedia.util.AlbumHelper.ImageItem> getLocalVideoList(android.content.Context r8) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.ContentResolver r1 = r8.getContentResolver()
            java.lang.String r6 = "date_added"
            java.lang.String r7 = "bucket_display_name"
            java.lang.String r2 = "_id"
            java.lang.String r3 = "bucket_id"
            java.lang.String r4 = "_data"
            java.lang.String r5 = "duration"
            java.lang.String[] r3 = new java.lang.String[]{r2, r3, r4, r5, r6, r7}
            android.net.Uri r2 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI
            r5 = 0
            java.lang.String r6 = "date_added DESC LIMIT 2147483647 OFFSET 0"
            r4 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)
            if (r8 != 0) goto L26
            return r0
        L26:
            int r1 = r8.getCount()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            if (r1 != 0) goto L36
            boolean r1 = r8.isClosed()
            if (r1 != 0) goto L35
            r8.close()
        L35:
            return r0
        L36:
            r8.moveToFirst()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
        L39:
            com.up366.multimedia.util.AlbumHelper$ImageItem r1 = parseVideoCursor(r8)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r0.add(r1)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            boolean r1 = r8.moveToNext()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            if (r1 != 0) goto L39
            boolean r1 = r8.isClosed()
            if (r1 != 0) goto L60
            goto L5d
        L4d:
            r0 = move-exception
            goto L61
        L4f:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()     // Catch: java.lang.Throwable -> L4d
            com.up366.common.log.Logger.error(r2, r1)     // Catch: java.lang.Throwable -> L4d
            boolean r1 = r8.isClosed()
            if (r1 != 0) goto L60
        L5d:
            r8.close()
        L60:
            return r0
        L61:
            boolean r1 = r8.isClosed()
            if (r1 != 0) goto L6a
            r8.close()
        L6a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.multimedia.util.AlbumHelper.getLocalVideoList(android.content.Context):java.util.List");
    }

    private static com.up366.multimedia.util.AlbumHelper.ImageItem parseVideoCursor(android.database.Cursor cur) {
        long j = cur.getLong(cur.getColumnIndexOrThrow("_id"));
        java.lang.String string = cur.getString(cur.getColumnIndexOrThrow("_data"));
        long j2 = cur.getLong(cur.getColumnIndexOrThrow("date_added"));
        java.lang.String string2 = cur.getString(cur.getColumnIndexOrThrow(com.up366.medialibrary.config.PictureConstants.EXTRA_BUCKET_ID));
        java.lang.String string3 = cur.getString(cur.getColumnIndexOrThrow("bucket_display_name"));
        long j3 = cur.getLong(cur.getColumnIndexOrThrow("duration"));
        return new com.up366.multimedia.util.AlbumHelper.ImageItem(j + "", "", string, j2, string2, string3, android.content.ContentUris.withAppendedId(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, j), j3);
    }

    private static com.up366.multimedia.util.AlbumHelper.ImageItem parseImageCursor(android.database.Cursor cur) {
        long j = cur.getLong(cur.getColumnIndexOrThrow("_id"));
        return new com.up366.multimedia.util.AlbumHelper.ImageItem(j + "", cur.getString(cur.getColumnIndexOrThrow("_data")), "", cur.getLong(cur.getColumnIndexOrThrow("date_added")), cur.getString(cur.getColumnIndexOrThrow(com.up366.medialibrary.config.PictureConstants.EXTRA_BUCKET_ID)), cur.getString(cur.getColumnIndexOrThrow("bucket_display_name")), android.content.ContentUris.withAppendedId(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, j), 0L);
    }
}
