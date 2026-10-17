package com.up366.medialibrary.common.compress;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class Luban {
    private static final java.lang.String TAG = "Luban";
    private final int compressQuality;
    private final int dataCount;
    private final boolean focusAlpha;
    private int index;
    private final boolean isAutoRotating;
    private final boolean isCamera;
    private final com.up366.medialibrary.common.compress.OnCompressListener mCompressListener;
    private final com.up366.medialibrary.common.compress.CompressionPredicate mCompressionPredicate;
    private final int mLeastCompressSize;
    private final java.lang.String mNewFileName;
    private final java.util.List<java.lang.String> mPaths;
    private final com.up366.medialibrary.common.compress.OnRenameListener mRenameListener;
    private final java.util.List<com.up366.medialibrary.common.compress.InputStreamProvider> mStreamProviders;
    private java.lang.String mTargetDir;
    private final java.util.List<com.up366.medialibrary.model.LocalMedia> mediaList;

    static /* synthetic */ int access$1408(com.up366.medialibrary.common.compress.Luban luban) {
        int i = luban.index;
        luban.index = i + 1;
        return i;
    }

    private Luban(com.up366.medialibrary.common.compress.Luban.Builder builder) {
        this.index = -1;
        this.mPaths = builder.mPaths;
        this.mediaList = builder.mediaList;
        this.dataCount = builder.dataCount;
        this.mTargetDir = builder.mTargetDir;
        this.mNewFileName = builder.mNewFileName;
        this.mRenameListener = builder.mRenameListener;
        this.mStreamProviders = builder.mStreamProviders;
        this.mCompressListener = builder.mCompressListener;
        this.mLeastCompressSize = builder.mLeastCompressSize;
        this.mCompressionPredicate = builder.mCompressionPredicate;
        this.compressQuality = builder.compressQuality;
        this.isAutoRotating = builder.isAutoRotating;
        this.focusAlpha = builder.focusAlpha;
        this.isCamera = builder.isCamera;
    }

    public static com.up366.medialibrary.common.compress.Luban.Builder with(android.content.Context context) {
        return new com.up366.medialibrary.common.compress.Luban.Builder(context);
    }

    private java.io.File getImageCacheFile(android.content.Context context, com.up366.medialibrary.common.compress.InputStreamProvider inputStreamProvider, java.lang.String str) {
        java.lang.String string;
        java.io.File imageCacheDir;
        if (android.text.TextUtils.isEmpty(this.mTargetDir) && (imageCacheDir = getImageCacheDir(context)) != null) {
            this.mTargetDir = imageCacheDir.getAbsolutePath();
        }
        try {
            com.up366.medialibrary.model.LocalMedia media = inputStreamProvider.getMedia();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.mTargetDir);
            if (media.isCut()) {
                java.lang.String createFileName = com.up366.medialibrary.common.utils.DateUtils.getCreateFileName("IMG_CMP_");
                sb.append("/");
                sb.append(createFileName);
                if (android.text.TextUtils.isEmpty(str)) {
                    str = com.up366.medialibrary.common.utils.MimeTypeUtils.JPG;
                }
                sb.append(str);
                string = sb.toString();
            } else {
                java.lang.String encryptionValue = com.up366.medialibrary.common.utils.StringUtils.getEncryptionValue(media.getId(), media.getWidth(), media.getHeight());
                sb.append("/IMG_CMP_");
                sb.append(encryptionValue);
                if (android.text.TextUtils.isEmpty(str)) {
                    str = com.up366.medialibrary.common.utils.MimeTypeUtils.JPG;
                }
                sb.append(str);
                string = sb.toString();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            string = "";
        }
        return new java.io.File(string);
    }

    private java.io.File getImageCustomFile(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(this.mTargetDir)) {
            java.io.File imageCacheDir = getImageCacheDir(context);
            this.mTargetDir = imageCacheDir != null ? imageCacheDir.getAbsolutePath() : "";
        }
        return new java.io.File(this.mTargetDir + "/" + str);
    }

    private static java.io.File getImageCacheDir(android.content.Context context) {
        java.io.File externalFilesDir = context.getExternalFilesDir(android.os.Environment.DIRECTORY_PICTURES);
        if (externalFilesDir != null) {
            if (externalFilesDir.mkdirs() || (externalFilesDir.exists() && externalFilesDir.isDirectory())) {
                return externalFilesDir;
            }
            return null;
        }
        if (android.util.Log.isLoggable(TAG, 6)) {
            android.util.Log.e(TAG, "default disk cache dir is null");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launch(final android.content.Context context) {
        java.util.List<com.up366.medialibrary.common.compress.InputStreamProvider> list = this.mStreamProviders;
        if (list == null || this.mPaths == null || (list.size() == 0 && this.mCompressListener != null)) {
            this.mCompressListener.onError(new java.lang.NullPointerException("image file cannot be null"));
            return;
        }
        final java.util.Iterator<com.up366.medialibrary.common.compress.InputStreamProvider> it = this.mStreamProviders.iterator();
        com.up366.medialibrary.common.compress.OnCompressListener onCompressListener = this.mCompressListener;
        if (onCompressListener != null) {
            onCompressListener.onStart();
        }
        com.up366.medialibrary.common.utils.PictureThreadUtils.executeByIo(new com.up366.medialibrary.common.utils.PictureThreadUtils.SimpleTask<java.util.List<com.up366.medialibrary.model.LocalMedia>>() { // from class: com.up366.medialibrary.common.compress.Luban.1
            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            public java.util.List<com.up366.medialibrary.model.LocalMedia> doInBackground() {
                java.io.File fileCompress;
                java.lang.String absolutePath;
                java.io.File fileCompress2;
                com.up366.medialibrary.common.compress.Luban.this.index = -1;
                while (true) {
                    if (!it.hasNext()) {
                        return null;
                    }
                    try {
                        com.up366.medialibrary.common.compress.Luban.access$1408(com.up366.medialibrary.common.compress.Luban.this);
                        com.up366.medialibrary.common.compress.InputStreamProvider inputStreamProvider = (com.up366.medialibrary.common.compress.InputStreamProvider) it.next();
                        if (inputStreamProvider.getMedia().isCompressed()) {
                            if (inputStreamProvider.getMedia().isCut() || !new java.io.File(inputStreamProvider.getMedia().getCompressPath()).exists()) {
                                fileCompress2 = com.up366.medialibrary.common.compress.Luban.this.compress(context, inputStreamProvider);
                            } else {
                                fileCompress2 = new java.io.File(inputStreamProvider.getMedia().getCompressPath());
                            }
                            absolutePath = fileCompress2.getAbsolutePath();
                        } else if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(inputStreamProvider.getMedia().getPath()) && android.text.TextUtils.isEmpty(inputStreamProvider.getMedia().getCutPath())) {
                            absolutePath = inputStreamProvider.getMedia().getPath();
                        } else {
                            if (!com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(inputStreamProvider.getMedia().getMimeType())) {
                                fileCompress = com.up366.medialibrary.common.compress.Luban.this.compress(context, inputStreamProvider);
                            } else {
                                fileCompress = new java.io.File(inputStreamProvider.getPath());
                            }
                            absolutePath = fileCompress.getAbsolutePath();
                        }
                        if (com.up366.medialibrary.common.compress.Luban.this.mediaList != null && com.up366.medialibrary.common.compress.Luban.this.mediaList.size() > 0) {
                            com.up366.medialibrary.model.LocalMedia localMedia = (com.up366.medialibrary.model.LocalMedia) com.up366.medialibrary.common.compress.Luban.this.mediaList.get(com.up366.medialibrary.common.compress.Luban.this.index);
                            boolean zIsHttp = com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(absolutePath);
                            boolean zIsVideo = com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(localMedia.getMimeType());
                            localMedia.setCompressed((zIsHttp || zIsVideo || android.text.TextUtils.isEmpty(absolutePath)) ? false : true);
                            if (zIsHttp || zIsVideo) {
                                absolutePath = null;
                            }
                            localMedia.setCompressPath(absolutePath);
                            localMedia.setAndroidQToPath(com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() ? localMedia.getCompressPath() : null);
                            if (com.up366.medialibrary.common.compress.Luban.this.index == com.up366.medialibrary.common.compress.Luban.this.mediaList.size() - 1) {
                                return com.up366.medialibrary.common.compress.Luban.this.mediaList;
                            }
                            continue;
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                    it.remove();
                }
            }

            @Override // com.up366.medialibrary.common.utils.PictureThreadUtils.Task
            public void onSuccess(java.util.List<com.up366.medialibrary.model.LocalMedia> list2) {
                com.up366.medialibrary.common.utils.PictureThreadUtils.cancel(com.up366.medialibrary.common.utils.PictureThreadUtils.getIoPool());
                if (com.up366.medialibrary.common.compress.Luban.this.mCompressListener == null) {
                    return;
                }
                if (list2 != null) {
                    com.up366.medialibrary.common.compress.Luban.this.mCompressListener.onSuccess(list2);
                } else {
                    com.up366.medialibrary.common.compress.Luban.this.mCompressListener.onError(new java.lang.Throwable("Failed to compress file"));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.io.File get(com.up366.medialibrary.common.compress.InputStreamProvider inputStreamProvider, android.content.Context context) throws java.io.IOException {
        try {
            return new com.up366.medialibrary.common.compress.Engine(context, inputStreamProvider, getImageCacheFile(context, inputStreamProvider, com.up366.medialibrary.common.compress.Checker.SINGLE.extSuffix(inputStreamProvider.getMedia().getMimeType())), this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
        } finally {
            inputStreamProvider.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.util.List<com.up366.medialibrary.model.LocalMedia> get(android.content.Context context) throws java.lang.Exception {
        java.io.File fileCompress;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<com.up366.medialibrary.common.compress.InputStreamProvider> it = this.mStreamProviders.iterator();
        while (it.hasNext()) {
            com.up366.medialibrary.common.compress.InputStreamProvider next = it.next();
            if (next.getMedia() != null) {
                com.up366.medialibrary.model.LocalMedia media = next.getMedia();
                if (media.isCompressed()) {
                    if (!media.isCut() && new java.io.File(media.getCompressPath()).exists()) {
                        fileCompress = new java.io.File(media.getCompressPath());
                    } else {
                        fileCompress = compress(context, next);
                    }
                    java.lang.String absolutePath = fileCompress.getAbsolutePath();
                    media.setCompressed(true);
                    media.setCompressPath(absolutePath);
                    media.setAndroidQToPath(com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() ? absolutePath : null);
                    arrayList.add(media);
                } else {
                    boolean z = com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(media.getPath()) && android.text.TextUtils.isEmpty(media.getCutPath());
                    boolean zIsVideo = com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(media.getMimeType());
                    java.lang.String absolutePath2 = ((z || zIsVideo) ? new java.io.File(media.getPath()) : compress(context, next)).getAbsolutePath();
                    boolean z2 = !android.text.TextUtils.isEmpty(absolutePath2) && com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(absolutePath2);
                    media.setCompressed((zIsVideo || z2) ? false : true);
                    if (zIsVideo || z2) {
                        absolutePath2 = null;
                    }
                    media.setCompressPath(absolutePath2);
                    media.setAndroidQToPath(com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() ? media.getCompressPath() : null);
                    arrayList.add(media);
                }
                it.remove();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.io.File compress(android.content.Context context, com.up366.medialibrary.common.compress.InputStreamProvider inputStreamProvider) throws java.lang.Exception {
        try {
            return compressRealLocalMedia(context, inputStreamProvider);
        } finally {
            inputStreamProvider.close();
        }
    }

    private java.io.File compressReal(android.content.Context context, com.up366.medialibrary.common.compress.InputStreamProvider inputStreamProvider) throws java.io.IOException {
        java.lang.String strExtSuffix = com.up366.medialibrary.common.compress.Checker.SINGLE.extSuffix(inputStreamProvider.getMedia() != null ? inputStreamProvider.getMedia().getMimeType() : "");
        java.io.File imageCacheFile = getImageCacheFile(context, inputStreamProvider, strExtSuffix);
        com.up366.medialibrary.common.compress.OnRenameListener onRenameListener = this.mRenameListener;
        if (onRenameListener != null) {
            imageCacheFile = getImageCustomFile(context, onRenameListener.rename(inputStreamProvider.getPath()));
        }
        java.io.File file = imageCacheFile;
        com.up366.medialibrary.common.compress.CompressionPredicate compressionPredicate = this.mCompressionPredicate;
        if (compressionPredicate != null) {
            if (compressionPredicate.apply(inputStreamProvider.getPath()) && com.up366.medialibrary.common.compress.Checker.SINGLE.needCompress(this.mLeastCompressSize, inputStreamProvider.getPath())) {
                return new com.up366.medialibrary.common.compress.Engine(context, inputStreamProvider, file, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
            }
            return new java.io.File(inputStreamProvider.getPath());
        }
        if (strExtSuffix.startsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.GIF)) {
            return new java.io.File(inputStreamProvider.getPath());
        }
        if (com.up366.medialibrary.common.compress.Checker.SINGLE.needCompress(this.mLeastCompressSize, inputStreamProvider.getPath())) {
            return new com.up366.medialibrary.common.compress.Engine(context, inputStreamProvider, file, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
        }
        return new java.io.File(inputStreamProvider.getPath());
    }

    private java.io.File compressRealLocalMedia(android.content.Context context, com.up366.medialibrary.common.compress.InputStreamProvider inputStreamProvider) throws java.lang.Exception {
        java.lang.String str;
        java.io.File file;
        com.up366.medialibrary.model.LocalMedia media = inputStreamProvider.getMedia();
        java.lang.String cutPath = media.isCut() ? media.getCutPath() : media.getRealPath();
        java.lang.String strExtSuffix = com.up366.medialibrary.common.compress.Checker.SINGLE.extSuffix(media.getMimeType());
        java.io.File imageCacheFile = getImageCacheFile(context, inputStreamProvider, strExtSuffix);
        if (android.text.TextUtils.isEmpty(this.mNewFileName)) {
            str = "";
        } else {
            java.lang.String strRename = (this.isCamera || this.dataCount == 1) ? this.mNewFileName : com.up366.medialibrary.common.utils.StringUtils.rename(this.mNewFileName);
            str = strRename;
            imageCacheFile = getImageCustomFile(context, strRename);
        }
        if (imageCacheFile.exists()) {
            return imageCacheFile;
        }
        if (this.mCompressionPredicate != null) {
            if (strExtSuffix.startsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.GIF)) {
                if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
                    if (media.isCut()) {
                        return new java.io.File(media.getCutPath());
                    }
                    return new java.io.File(com.up366.medialibrary.common.utils.AndroidQTransformUtils.copyPathToAndroidQ(context, inputStreamProvider.getMedia().getId(), inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str));
                }
                return new java.io.File(cutPath);
            }
            boolean zNeedCompressToLocalMedia = com.up366.medialibrary.common.compress.Checker.SINGLE.needCompressToLocalMedia(this.mLeastCompressSize, cutPath);
            if (this.mCompressionPredicate.apply(cutPath) && zNeedCompressToLocalMedia) {
                file = new com.up366.medialibrary.common.compress.Engine(context, inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
            } else if (zNeedCompressToLocalMedia) {
                file = new com.up366.medialibrary.common.compress.Engine(context, inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
            } else {
                if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
                    java.lang.String cutPath2 = media.isCut() ? media.getCutPath() : com.up366.medialibrary.common.utils.AndroidQTransformUtils.copyPathToAndroidQ(context, media.getId(), inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str);
                    if (!android.text.TextUtils.isEmpty(cutPath2)) {
                        cutPath = cutPath2;
                    }
                    return new java.io.File(cutPath);
                }
                file = new java.io.File(cutPath);
            }
            return file;
        }
        if (strExtSuffix.startsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.GIF)) {
            if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
                java.lang.String cutPath3 = media.isCut() ? media.getCutPath() : com.up366.medialibrary.common.utils.AndroidQTransformUtils.copyPathToAndroidQ(context, media.getId(), inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str);
                if (!android.text.TextUtils.isEmpty(cutPath3)) {
                    cutPath = cutPath3;
                }
                return new java.io.File(cutPath);
            }
            return new java.io.File(cutPath);
        }
        if (com.up366.medialibrary.common.compress.Checker.SINGLE.needCompressToLocalMedia(this.mLeastCompressSize, cutPath)) {
            return new com.up366.medialibrary.common.compress.Engine(context, inputStreamProvider, imageCacheFile, this.focusAlpha, this.compressQuality, this.isAutoRotating).compress();
        }
        if (com.up366.medialibrary.common.utils.SdkVersionUtils.isQ()) {
            java.lang.String cutPath4 = media.isCut() ? media.getCutPath() : com.up366.medialibrary.common.utils.AndroidQTransformUtils.copyPathToAndroidQ(context, media.getId(), inputStreamProvider.getPath(), media.getWidth(), media.getHeight(), media.getMimeType(), str);
            if (!android.text.TextUtils.isEmpty(cutPath4)) {
                cutPath = cutPath4;
            }
            return new java.io.File(cutPath);
        }
        return new java.io.File(cutPath);
    }

    public static class Builder {
        private int compressQuality;
        private final android.content.Context context;
        private int dataCount;
        private boolean focusAlpha;
        private boolean isAutoRotating;
        private boolean isCamera;
        private com.up366.medialibrary.common.compress.OnCompressListener mCompressListener;
        private com.up366.medialibrary.common.compress.CompressionPredicate mCompressionPredicate;
        private java.lang.String mNewFileName;
        private com.up366.medialibrary.common.compress.OnRenameListener mRenameListener;
        private java.lang.String mTargetDir;
        private int mLeastCompressSize = 100;
        private final java.util.List<java.lang.String> mPaths = new java.util.ArrayList();
        private java.util.List<com.up366.medialibrary.model.LocalMedia> mediaList = new java.util.ArrayList();
        private final java.util.List<com.up366.medialibrary.common.compress.InputStreamProvider> mStreamProviders = new java.util.ArrayList();

        public com.up366.medialibrary.common.compress.Luban.Builder putGear(int i) {
            return this;
        }

        Builder(android.content.Context context) {
            this.context = context;
        }

        private com.up366.medialibrary.common.compress.Luban build() {
            return new com.up366.medialibrary.common.compress.Luban(this);
        }

        public com.up366.medialibrary.common.compress.Luban.Builder load(com.up366.medialibrary.common.compress.InputStreamProvider inputStreamProvider) {
            this.mStreamProviders.add(inputStreamProvider);
            return this;
        }

        public <T> com.up366.medialibrary.common.compress.Luban.Builder loadMediaData(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
            this.mediaList = list;
            this.dataCount = list.size();
            java.util.Iterator<com.up366.medialibrary.model.LocalMedia> it = list.iterator();
            while (it.hasNext()) {
                load(it.next());
            }
            return this;
        }

        private com.up366.medialibrary.common.compress.Luban.Builder load(final com.up366.medialibrary.model.LocalMedia localMedia) {
            this.mStreamProviders.add(new com.up366.medialibrary.common.compress.InputStreamAdapter() { // from class: com.up366.medialibrary.common.compress.Luban.Builder.1
                @Override // com.up366.medialibrary.common.compress.InputStreamAdapter
                public java.io.InputStream openInternal() throws java.io.IOException {
                    if (com.up366.medialibrary.common.utils.MimeTypeUtils.isContent(localMedia.getPath()) && !localMedia.isCut()) {
                        if (!localMedia.isToSandboxPath()) {
                            return com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(com.up366.medialibrary.common.compress.Luban.Builder.this.context, android.net.Uri.parse(localMedia.getPath()));
                        }
                        return new java.io.FileInputStream(localMedia.getAndroidQToPath());
                    }
                    if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(localMedia.getPath()) && android.text.TextUtils.isEmpty(localMedia.getCutPath())) {
                        return null;
                    }
                    return new java.io.FileInputStream(localMedia.isCut() ? localMedia.getCutPath() : localMedia.getPath());
                }

                @Override // com.up366.medialibrary.common.compress.InputStreamProvider
                public java.lang.String getPath() {
                    if (localMedia.isCut()) {
                        return localMedia.getCutPath();
                    }
                    return localMedia.isToSandboxPath() ? localMedia.getAndroidQToPath() : localMedia.getPath();
                }

                @Override // com.up366.medialibrary.common.compress.InputStreamProvider
                public com.up366.medialibrary.model.LocalMedia getMedia() {
                    return localMedia;
                }
            });
            return this;
        }

        public com.up366.medialibrary.common.compress.Luban.Builder load(final android.net.Uri uri) {
            this.mStreamProviders.add(new com.up366.medialibrary.common.compress.InputStreamAdapter() { // from class: com.up366.medialibrary.common.compress.Luban.Builder.2
                @Override // com.up366.medialibrary.common.compress.InputStreamProvider
                public com.up366.medialibrary.model.LocalMedia getMedia() {
                    return null;
                }

                @Override // com.up366.medialibrary.common.compress.InputStreamAdapter
                public java.io.InputStream openInternal() {
                    return com.up366.medialibrary.lib.PictureContentResolver.getContentResolverOpenInputStream(com.up366.medialibrary.common.compress.Luban.Builder.this.context, uri);
                }

                @Override // com.up366.medialibrary.common.compress.InputStreamProvider
                public java.lang.String getPath() {
                    return uri.getPath();
                }
            });
            return this;
        }

        public com.up366.medialibrary.common.compress.Luban.Builder load(final java.io.File file) {
            this.mStreamProviders.add(new com.up366.medialibrary.common.compress.InputStreamAdapter() { // from class: com.up366.medialibrary.common.compress.Luban.Builder.3
                @Override // com.up366.medialibrary.common.compress.InputStreamProvider
                public com.up366.medialibrary.model.LocalMedia getMedia() {
                    return null;
                }

                @Override // com.up366.medialibrary.common.compress.InputStreamAdapter
                public java.io.InputStream openInternal() throws java.io.IOException {
                    return new java.io.FileInputStream(file);
                }

                @Override // com.up366.medialibrary.common.compress.InputStreamProvider
                public java.lang.String getPath() {
                    return file.getAbsolutePath();
                }
            });
            return this;
        }

        public com.up366.medialibrary.common.compress.Luban.Builder load(final java.lang.String str) {
            this.mStreamProviders.add(new com.up366.medialibrary.common.compress.InputStreamAdapter() { // from class: com.up366.medialibrary.common.compress.Luban.Builder.4
                @Override // com.up366.medialibrary.common.compress.InputStreamProvider
                public com.up366.medialibrary.model.LocalMedia getMedia() {
                    return null;
                }

                @Override // com.up366.medialibrary.common.compress.InputStreamAdapter
                public java.io.InputStream openInternal() throws java.io.IOException {
                    return new java.io.FileInputStream(str);
                }

                @Override // com.up366.medialibrary.common.compress.InputStreamProvider
                public java.lang.String getPath() {
                    return str;
                }
            });
            return this;
        }

        public <T> com.up366.medialibrary.common.compress.Luban.Builder load(java.util.List<T> list) {
            for (T t : list) {
                if (t instanceof java.lang.String) {
                    load((java.lang.String) t);
                } else if (t instanceof java.io.File) {
                    load((java.io.File) t);
                } else if (t instanceof android.net.Uri) {
                    load((android.net.Uri) t);
                } else {
                    throw new java.lang.IllegalArgumentException("Incoming data type exception, it must be String, File, Uri or Bitmap");
                }
            }
            return this;
        }

        @java.lang.Deprecated
        public com.up366.medialibrary.common.compress.Luban.Builder setRenameListener(com.up366.medialibrary.common.compress.OnRenameListener onRenameListener) {
            this.mRenameListener = onRenameListener;
            return this;
        }

        public com.up366.medialibrary.common.compress.Luban.Builder setCompressListener(com.up366.medialibrary.common.compress.OnCompressListener onCompressListener) {
            this.mCompressListener = onCompressListener;
            return this;
        }

        public com.up366.medialibrary.common.compress.Luban.Builder setTargetDir(java.lang.String str) {
            this.mTargetDir = str;
            return this;
        }

        public com.up366.medialibrary.common.compress.Luban.Builder setNewCompressFileName(java.lang.String str) {
            this.mNewFileName = str;
            return this;
        }

        public com.up366.medialibrary.common.compress.Luban.Builder isCamera(boolean z) {
            this.isCamera = z;
            return this;
        }

        @java.lang.Deprecated
        public com.up366.medialibrary.common.compress.Luban.Builder setFocusAlpha(boolean z) {
            this.focusAlpha = z;
            return this;
        }

        public com.up366.medialibrary.common.compress.Luban.Builder setCompressQuality(int i) {
            this.compressQuality = i;
            return this;
        }

        public com.up366.medialibrary.common.compress.Luban.Builder isAutoRotating(boolean z) {
            this.isAutoRotating = z;
            return this;
        }

        public com.up366.medialibrary.common.compress.Luban.Builder ignoreBy(int i) {
            this.mLeastCompressSize = i;
            return this;
        }

        public com.up366.medialibrary.common.compress.Luban.Builder filter(com.up366.medialibrary.common.compress.CompressionPredicate compressionPredicate) {
            this.mCompressionPredicate = compressionPredicate;
            return this;
        }

        public void launch() {
            build().launch(this.context);
        }

        public java.io.File get(final java.lang.String str) throws java.io.IOException {
            return build().get(new com.up366.medialibrary.common.compress.InputStreamAdapter() { // from class: com.up366.medialibrary.common.compress.Luban.Builder.5
                @Override // com.up366.medialibrary.common.compress.InputStreamProvider
                public com.up366.medialibrary.model.LocalMedia getMedia() {
                    return null;
                }

                @Override // com.up366.medialibrary.common.compress.InputStreamAdapter
                public java.io.InputStream openInternal() throws java.io.IOException {
                    return new java.io.FileInputStream(str);
                }

                @Override // com.up366.medialibrary.common.compress.InputStreamProvider
                public java.lang.String getPath() {
                    return str;
                }
            }, this.context);
        }

        public java.util.List<com.up366.medialibrary.model.LocalMedia> get() throws java.lang.Exception {
            return build().get(this.context);
        }
    }
}
