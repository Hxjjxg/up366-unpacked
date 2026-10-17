package com.up366.mobile.course.photoanswer.logic.cameraAlum;

/* JADX INFO: compiled from: StaticTimeHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/StaticTimeHelper;", "", "<init>", "()V", "Companion", "PhotoStatus", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StaticTimeHelper {
    private static long enterTime;
    private static boolean hasStart;
    private static long pauseDuration;
    private static long pauseTime;
    private static long starTime;
    private static int submitType;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.Companion INSTANCE = new com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.Companion(null);
    private static java.util.ArrayList<java.lang.Long> times = new java.util.ArrayList<>();
    private static int paperCount = -1;
    private static java.lang.String studyTaskId = "";
    private static java.lang.String cacheStaticKey = "";
    private static java.util.List<java.lang.Integer> scanDuration = new java.util.ArrayList();
    private static java.util.List<java.lang.Integer> uploadDuration = new java.util.ArrayList();
    private static java.util.Map<java.lang.String, com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus> photoStatusMap = new java.util.LinkedHashMap();

    /* JADX INFO: compiled from: StaticTimeHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0086\u0003\u0018\u00002\u00020\u0001:\u00017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000fJ\u0016\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\rJ\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\u0016\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\bJ\u0016\u0010$\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\bJ\u0016\u0010&\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\bJ\u000e\u0010(\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\rJ\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\rJ\u0006\u0010,\u001a\u00020\u001bJ\u0006\u0010-\u001a\u00020\u001bJ\u0006\u0010.\u001a\u00020\u001bJ\b\u0010/\u001a\u00020\u001bH\u0002J\u0006\u00100\u001a\u00020\u001bJ\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u0005J\u000e\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u000fJ\u000e\u00105\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u000fJ\u000e\u00106\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\nj\b\u0012\u0004\u0012\u00020\u0005`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/StaticTimeHelper$Companion;", "", "<init>", "()V", "enterTime", "", "starTime", "hasStart", "", "times", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "paperCount", "", com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, "", "submitType", "cacheStaticKey", "pauseTime", "pauseDuration", "scanDuration", "", "uploadDuration", "photoStatusMap", "", "Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/StaticTimeHelper$PhotoStatus;", "setSubmitType", "", "setPaperCount", "layoutJson", "addPhotoStatus", "imagePath", "type", "getPhotoStatusKey", "setPhotoStatusSuccess", "success", "setPhotoStatusFixed", "fixed", "setPhotoStatusFixedSuccess", "fixedSuccess", "onCreate", "appendScanDuration", "duration", "appendV3ScanDuration", "start", "end", "reset", "appendTime", "onDestroy", "getEnterTime", "getStaticDuration", "onResume", "staticKey", "onPause", "appendUploadDuration", "SubmitType", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: compiled from: StaticTimeHelper.kt */
        @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/StaticTimeHelper$Companion$SubmitType;", "", "<init>", "()V", "NO_SUBMIT", "", "NORMAL_SUBMIT", "FORCE_SUBMIT", "ONLINE_ANSWER", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class SubmitType {
            public static final int FORCE_SUBMIT = 2;
            public static final com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.Companion.SubmitType INSTANCE = new com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.Companion.SubmitType();
            public static final int NORMAL_SUBMIT = 1;
            public static final int NO_SUBMIT = 0;
            public static final int ONLINE_ANSWER = 3;

            private SubmitType() {
            }
        }

        public final void setSubmitType(int submitType) {
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.submitType = submitType;
        }

        public final void setPaperCount(java.lang.String layoutJson) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(layoutJson, "layoutJson");
            try {
                com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.paperCount = com.alibaba.fastjson.JSON.parseObject(layoutJson).getJSONObject(com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE).getInteger("imageCount").intValue();
            } catch (java.lang.Exception e) {
                com.up366.common.log.Logger.error("setPaperCount error  ," + layoutJson, e);
                com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.paperCount = -1;
            }
        }

        public final void addPhotoStatus(java.lang.String imagePath, int type) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imagePath, "imagePath");
            java.lang.String photoStatusKey = getPhotoStatusKey(imagePath);
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.photoStatusMap.put(photoStatusKey, new com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus(photoStatusKey, type));
        }

        private final java.lang.String getPhotoStatusKey(java.lang.String imagePath) {
            java.lang.String strSubstring = imagePath.substring(kotlin.text.StringsKt.lastIndexOf$default(imagePath, "/", 0, false, 6, (java.lang.Object) null) + 1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return (java.lang.String) kotlin.text.StringsKt.split$default(strSubstring, new java.lang.String[]{"_"}, false, 0, 6, (java.lang.Object) null).get(0);
        }

        public final void setPhotoStatusSuccess(java.lang.String imagePath, boolean success) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imagePath, "imagePath");
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus photoStatus = (com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus) com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.photoStatusMap.get(getPhotoStatusKey(imagePath));
            if (photoStatus != null) {
                photoStatus.setSuccess(success);
            }
        }

        public final void setPhotoStatusFixed(java.lang.String imagePath, boolean fixed) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imagePath, "imagePath");
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus photoStatus = (com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus) com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.photoStatusMap.get(getPhotoStatusKey(imagePath));
            if (photoStatus != null) {
                photoStatus.setFixed(fixed);
            }
        }

        public final void setPhotoStatusFixedSuccess(java.lang.String imagePath, boolean fixedSuccess) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(imagePath, "imagePath");
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus photoStatus = (com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus) com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.photoStatusMap.get(getPhotoStatusKey(imagePath));
            if (photoStatus != null) {
                photoStatus.setFixedSuccess(fixedSuccess);
            }
        }

        public final void onCreate(java.lang.String studyTaskId) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(studyTaskId, com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID);
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.enterTime = java.lang.System.currentTimeMillis();
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.studyTaskId = studyTaskId;
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.submitType = 0;
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.times.clear();
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.scanDuration.clear();
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.photoStatusMap.clear();
        }

        public final void appendScanDuration(int duration) {
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.scanDuration.add(java.lang.Integer.valueOf(duration));
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.uploadDuration.add(0);
        }

        public final void appendV3ScanDuration(int duration) {
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.scanDuration.add(java.lang.Integer.valueOf(duration));
        }

        public final void start() {
            if (com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.hasStart) {
                return;
            }
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.hasStart = true;
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.starTime = java.lang.System.currentTimeMillis();
        }

        public final void end() {
            if (com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.hasStart) {
                com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.hasStart = false;
                appendTime();
            }
        }

        public final void reset() {
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.hasStart = false;
        }

        private final void appendTime() {
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.times.add(java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.starTime));
        }

        public final void onDestroy() {
            if (com.up366.common.StringUtils.isEmptyOrNull(com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.studyTaskId) || com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.times.isEmpty() || com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.times.size() == 0) {
                return;
            }
            final kotlin.jvm.internal.Ref.IntRef intRef = new kotlin.jvm.internal.Ref.IntRef();
            final kotlin.jvm.internal.Ref.IntRef intRef2 = new kotlin.jvm.internal.Ref.IntRef();
            final kotlin.jvm.internal.Ref.IntRef intRef3 = new kotlin.jvm.internal.Ref.IntRef();
            final kotlin.jvm.internal.Ref.IntRef intRef4 = new kotlin.jvm.internal.Ref.IntRef();
            final kotlin.jvm.internal.Ref.IntRef intRef5 = new kotlin.jvm.internal.Ref.IntRef();
            final kotlin.jvm.internal.Ref.IntRef intRef6 = new kotlin.jvm.internal.Ref.IntRef();
            for (com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus photoStatus : com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.photoStatusMap.values()) {
                if (photoStatus.getType() == 1) {
                    intRef.element++;
                    if (photoStatus.getSuccess()) {
                        intRef2.element++;
                    }
                    if (photoStatus.getFixed()) {
                        intRef5.element++;
                        if (photoStatus.getFixedSuccess()) {
                            intRef6.element++;
                        }
                    }
                } else {
                    intRef3.element++;
                    if (photoStatus.getSuccess()) {
                        intRef4.element++;
                    }
                    if (photoStatus.getFixed()) {
                        intRef5.element++;
                        if (photoStatus.getFixedSuccess()) {
                            intRef6.element++;
                        }
                    }
                }
            }
            com.up366.mobile.common.onlinelog.OpLog.report("P1P", "单张拍摄时长", (androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject>) new androidx.core.util.Consumer() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper$Companion$$ExternalSyntheticLambda0
                public final void accept(java.lang.Object obj) {
                    com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.Companion.onDestroy$lambda$0(intRef, intRef2, intRef3, intRef4, intRef5, intRef6, (com.alibaba.fastjson.JSONObject) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDestroy$lambda$0(kotlin.jvm.internal.Ref.IntRef intRef, kotlin.jvm.internal.Ref.IntRef intRef2, kotlin.jvm.internal.Ref.IntRef intRef3, kotlin.jvm.internal.Ref.IntRef intRef4, kotlin.jvm.internal.Ref.IntRef intRef5, kotlin.jvm.internal.Ref.IntRef intRef6, com.alibaba.fastjson.JSONObject jSONObject) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jSONObject, "ext");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int size = com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.times.size();
            for (int i = 0; i < size; i++) {
                java.lang.Object obj = com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.times.get(i);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                sb.append(((java.lang.Number) obj).longValue());
                if (i != com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.times.size() - 1) {
                    sb.append(com.igexin.push.core.b.an);
                }
            }
            java.util.Map map = (java.util.Map) jSONObject;
            map.put("duration", sb.toString());
            map.put("paperCount", java.lang.Integer.valueOf(com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.paperCount));
            map.put("picCount", java.lang.Integer.valueOf(com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.times.size()));
            map.put(com.up366.mobile.common.onlinelog.OpLogData.Behavior.STUDY_TASK_ID, com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.studyTaskId);
            map.put("submit", java.lang.Integer.valueOf(com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.submitType));
            map.put("scanDuration", kotlin.collections.CollectionsKt.joinToString$default(com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.scanDuration, com.igexin.push.core.b.an, (java.lang.CharSequence) null, (java.lang.CharSequence) null, 0, (java.lang.CharSequence) null, (kotlin.jvm.functions.Function1) null, 62, (java.lang.Object) null));
            map.put("uploadDuration", kotlin.collections.CollectionsKt.joinToString$default(com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.uploadDuration, com.igexin.push.core.b.an, (java.lang.CharSequence) null, (java.lang.CharSequence) null, 0, (java.lang.CharSequence) null, (kotlin.jvm.functions.Function1) null, 62, (java.lang.Object) null));
            map.put("autoTotal", java.lang.Integer.valueOf(intRef.element));
            map.put("autoSuccess", java.lang.Integer.valueOf(intRef2.element));
            map.put("manualTotal", java.lang.Integer.valueOf(intRef3.element));
            map.put("manualSuccess", java.lang.Integer.valueOf(intRef4.element));
            map.put("flagFixTotal", java.lang.Integer.valueOf(intRef5.element));
            map.put("flagFixSuccess", java.lang.Integer.valueOf(intRef6.element));
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.times.clear();
        }

        public final long getEnterTime() {
            return com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.enterTime;
        }

        public final long getStaticDuration() {
            return (java.lang.System.currentTimeMillis() - com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.enterTime) - com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.pauseDuration;
        }

        public final void onResume(java.lang.String staticKey) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(staticKey, "staticKey");
            if (!kotlin.jvm.internal.Intrinsics.areEqual(com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.cacheStaticKey, staticKey) || com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.pauseTime == 0) {
                com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.pauseDuration = 0L;
                com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.pauseTime = 0L;
            } else {
                com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.pauseDuration += java.lang.System.currentTimeMillis() - com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.pauseTime;
                com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.pauseTime = 0L;
            }
        }

        public final void onPause(java.lang.String staticKey) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(staticKey, "staticKey");
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.cacheStaticKey = staticKey;
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.pauseTime = java.lang.System.currentTimeMillis();
        }

        public final void appendUploadDuration(int duration) {
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.uploadDuration.add(java.lang.Integer.valueOf(duration));
        }
    }

    /* JADX INFO: compiled from: StaticTimeHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/StaticTimeHelper$PhotoStatus;", "", "key", "", "type", "", "<init>", "(Ljava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getType", "()I", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "fixed", "getFixed", "setFixed", "fixedSuccess", "getFixedSuccess", "setFixedSuccess", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class PhotoStatus {
        private boolean fixed;
        private boolean fixedSuccess;
        private final java.lang.String key;
        private boolean success;
        private final int type;

        public static /* synthetic */ com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus copy$default(com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus photoStatus, java.lang.String str, int i, int i2, java.lang.Object obj) {
            if ((i2 & 1) != 0) {
                str = photoStatus.key;
            }
            if ((i2 & 2) != 0) {
                i = photoStatus.type;
            }
            return photoStatus.copy(str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final java.lang.String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public final com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus copy(java.lang.String key, int type) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(key, "key");
            return new com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus(key, type);
        }

        public boolean equals(java.lang.Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus)) {
                return false;
            }
            com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus photoStatus = (com.up366.mobile.course.photoanswer.logic.cameraAlum.StaticTimeHelper.PhotoStatus) other;
            return kotlin.jvm.internal.Intrinsics.areEqual(this.key, photoStatus.key) && this.type == photoStatus.type;
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.type;
        }

        public java.lang.String toString() {
            return "PhotoStatus(key=" + this.key + ", type=" + this.type + ")";
        }

        public PhotoStatus(java.lang.String str, int i) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "key");
            this.key = str;
            this.type = i;
        }

        public final java.lang.String getKey() {
            return this.key;
        }

        public final int getType() {
            return this.type;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final void setSuccess(boolean z) {
            this.success = z;
        }

        public final boolean getFixed() {
            return this.fixed;
        }

        public final void setFixed(boolean z) {
            this.fixed = z;
        }

        public final boolean getFixedSuccess() {
            return this.fixedSuccess;
        }

        public final void setFixedSuccess(boolean z) {
            this.fixedSuccess = z;
        }
    }
}
