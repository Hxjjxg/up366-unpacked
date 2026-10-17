package com.up366.medialibrary.loader;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class SandboxFileLoader {
    public static com.up366.medialibrary.model.LocalMediaFolder loadInAppSandboxFolderFile(android.content.Context context, java.lang.String str) throws java.io.IOException {
        java.util.List<com.up366.medialibrary.model.LocalMedia> listLoadInAppSandboxFile = loadInAppSandboxFile(context, str);
        if (listLoadInAppSandboxFile == null || listLoadInAppSandboxFile.size() <= 0) {
            return null;
        }
        com.up366.medialibrary.common.utils.SortUtils.sortLocalMediaAddedTime(listLoadInAppSandboxFile);
        com.up366.medialibrary.model.LocalMedia localMedia = listLoadInAppSandboxFile.get(0);
        com.up366.medialibrary.model.LocalMediaFolder localMediaFolder = new com.up366.medialibrary.model.LocalMediaFolder();
        localMediaFolder.setName(localMedia.getParentFolderName());
        localMediaFolder.setFirstImagePath(localMedia.getPath());
        localMediaFolder.setFirstMimeType(localMedia.getMimeType());
        localMediaFolder.setBucketId(localMedia.getBucketId());
        localMediaFolder.setImageNum(listLoadInAppSandboxFile.size());
        localMediaFolder.setData(listLoadInAppSandboxFile);
        return localMediaFolder;
    }

    public static java.util.List<com.up366.medialibrary.model.LocalMedia> loadInAppSandboxFile(android.content.Context context, java.lang.String str) throws java.io.IOException {
        java.io.File[] fileArrListFiles;
        long duration;
        int height;
        int i;
        int iOfImage;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.File file = new java.io.File(str);
        if (!file.exists() || (fileArrListFiles = file.listFiles(new java.io.FileFilter() { // from class: com.up366.medialibrary.loader.SandboxFileLoader.1
            @Override // java.io.FileFilter
            public boolean accept(java.io.File file2) {
                return !file2.isDirectory();
            }
        })) == null) {
            return arrayList;
        }
        for (java.io.File file2 : fileArrListFiles) {
            java.lang.String absolutePath = file2.getAbsolutePath();
            long length = file2.length();
            java.lang.String mimeTypeFromMediaContentUri = com.up366.medialibrary.common.utils.MimeTypeUtils.getMimeTypeFromMediaContentUri(context, android.net.Uri.fromFile(file2));
            java.lang.String name = file2.getParentFile() != null ? file2.getParentFile().getName() : "";
            long j = com.up366.medialibrary.common.utils.ValueOf.toLong(java.lang.Integer.valueOf(name.hashCode()));
            long jLastModified = file2.lastModified() / 1000;
            if (com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(mimeTypeFromMediaContentUri)) {
                com.up366.medialibrary.model.MediaExtraInfo videoSize = com.up366.medialibrary.common.utils.MediaUtils.getVideoSize(context, absolutePath);
                int width = videoSize.getWidth();
                int height2 = videoSize.getHeight();
                duration = videoSize.getDuration();
                iOfImage = com.up366.medialibrary.common.utils.MimeTypeUtils.ofVideo();
                i = width;
                height = height2;
            } else {
                com.up366.medialibrary.model.MediaExtraInfo imageSize = com.up366.medialibrary.common.utils.MediaUtils.getImageSize(context, absolutePath);
                int width2 = imageSize.getWidth();
                duration = 0;
                height = imageSize.getHeight();
                i = width2;
                iOfImage = com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage();
            }
            com.up366.medialibrary.model.LocalMedia localMedia = com.up366.medialibrary.model.LocalMedia.parseLocalMedia(jLastModified, absolutePath, absolutePath, file2.getName(), name, duration, iOfImage, mimeTypeFromMediaContentUri, i, height, length, j, jLastModified);
            localMedia.setAndroidQToPath(com.up366.medialibrary.common.utils.SdkVersionUtils.isQ() ? absolutePath : null);
            arrayList.add(localMedia);
        }
        return arrayList;
    }
}
