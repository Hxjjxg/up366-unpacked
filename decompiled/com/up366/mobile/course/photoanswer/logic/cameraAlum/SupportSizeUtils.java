package com.up366.mobile.course.photoanswer.logic.cameraAlum;

/* JADX INFO: compiled from: SupportSizeUtils.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/SupportSizeUtils;", "", "<init>", "()V", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SupportSizeUtils {
    private static final int MAX_CAPTURE_CANDIDATES = 4;
    private static final float TARGET_ASPECT_RATIO = 1.3333334f;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.course.photoanswer.logic.cameraAlum.SupportSizeUtils.Companion INSTANCE = new com.up366.mobile.course.photoanswer.logic.cameraAlum.SupportSizeUtils.Companion(null);
    private static final java.util.List<android.util.Size> fallbackCaptureSizes = kotlin.collections.CollectionsKt.listOf(new android.util.Size[]{new android.util.Size(1920, 1440), new android.util.Size(1600, 1200), new android.util.Size(1280, 960), new android.util.Size(1024, 768)});

    /* JADX INFO: compiled from: SupportSizeUtils.kt */
    @kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/cameraAlum/SupportSizeUtils$Companion;", "", "<init>", "()V", "MAX_CAPTURE_CANDIDATES", "", "TARGET_ASPECT_RATIO", "", "fallbackCaptureSizes", "", "Landroid/util/Size;", "getSupportSize", "context", "Landroid/content/Context;", "getCaptureSizeCandidates", "findPreferredSize", "supportSizes", "isNearTargetAspectRatio", "", "size", "getSupportedResolutions", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final android.util.Size getSupportSize(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            return (android.util.Size) kotlin.collections.CollectionsKt.first(getCaptureSizeCandidates(context));
        }

        public final java.util.List<android.util.Size> getCaptureSizeCandidates(android.content.Context context) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            java.util.List<android.util.Size> supportedResolutions = getSupportedResolutions(context);
            if (supportedResolutions.isEmpty()) {
                return com.up366.mobile.course.photoanswer.logic.cameraAlum.SupportSizeUtils.fallbackCaptureSizes;
            }
            java.util.List<android.util.Size> listSortedWith = kotlin.collections.CollectionsKt.sortedWith(kotlin.collections.CollectionsKt.distinct(supportedResolutions), new java.util.Comparator() { // from class: com.up366.mobile.course.photoanswer.logic.cameraAlum.SupportSizeUtils$Companion$getCaptureSizeCandidates$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    android.util.Size size = (android.util.Size) t2;
                    android.util.Size size2 = (android.util.Size) t;
                    return kotlin.comparisons.ComparisonsKt.compareValues(java.lang.Long.valueOf(((long) size.getWidth()) * ((long) size.getHeight())), java.lang.Long.valueOf(((long) size2.getWidth()) * ((long) size2.getHeight())));
                }
            });
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Object obj : listSortedWith) {
                if (com.up366.mobile.course.photoanswer.logic.cameraAlum.SupportSizeUtils.INSTANCE.isNearTargetAspectRatio((android.util.Size) obj)) {
                    arrayList.add(obj);
                }
            }
            java.util.ArrayList arrayList2 = arrayList;
            if (!(!arrayList2.isEmpty())) {
                arrayList2 = listSortedWith;
            }
            android.util.Size sizeFindPreferredSize = findPreferredSize(arrayList2);
            java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
            linkedHashSet.add(sizeFindPreferredSize);
            for (android.util.Size size : arrayList2) {
                if (size.getWidth() <= sizeFindPreferredSize.getWidth() && size.getHeight() <= sizeFindPreferredSize.getHeight()) {
                    linkedHashSet.add(size);
                }
                if (linkedHashSet.size() >= 4) {
                    break;
                }
            }
            java.util.LinkedHashSet linkedHashSet2 = linkedHashSet;
            com.up366.common.log.Logger.info("supportSizes:" + listSortedWith + ", captureCandidates:" + kotlin.collections.CollectionsKt.toList(linkedHashSet2));
            return kotlin.collections.CollectionsKt.toList(linkedHashSet2);
        }

        private final android.util.Size findPreferredSize(java.util.List<android.util.Size> supportSizes) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Object obj : supportSizes) {
                android.util.Size size = (android.util.Size) obj;
                if (size.getWidth() >= 3200 && size.getHeight() >= 2400) {
                    arrayList.add(obj);
                }
            }
            java.util.ArrayList arrayList2 = arrayList;
            if (!(!arrayList2.isEmpty())) {
                android.util.Size size2 = (android.util.Size) kotlin.collections.CollectionsKt.firstOrNull(supportSizes);
                return size2 == null ? (android.util.Size) kotlin.collections.CollectionsKt.first(com.up366.mobile.course.photoanswer.logic.cameraAlum.SupportSizeUtils.fallbackCaptureSizes) : size2;
            }
            java.util.Iterator it = arrayList2.iterator();
            if (!it.hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            java.lang.Object next = it.next();
            if (it.hasNext()) {
                android.util.Size size3 = (android.util.Size) next;
                long width = ((long) size3.getWidth()) * ((long) size3.getHeight());
                do {
                    java.lang.Object next2 = it.next();
                    android.util.Size size4 = (android.util.Size) next2;
                    long width2 = ((long) size4.getWidth()) * ((long) size4.getHeight());
                    if (width > width2) {
                        next = next2;
                        width = width2;
                    }
                } while (it.hasNext());
            }
            return (android.util.Size) next;
        }

        private final boolean isNearTargetAspectRatio(android.util.Size size) {
            return java.lang.Math.abs((((float) size.getWidth()) / ((float) size.getHeight())) - com.up366.mobile.course.photoanswer.logic.cameraAlum.SupportSizeUtils.TARGET_ASPECT_RATIO) <= 0.05f;
        }

        private final java.util.List<android.util.Size> getSupportedResolutions(android.content.Context context) {
            java.lang.Object obj;
            java.util.List listEmptyList;
            try {
                kotlin.Result.Companion companion = kotlin.Result.Companion;
                com.up366.mobile.course.photoanswer.logic.cameraAlum.SupportSizeUtils.Companion companion2 = this;
                java.lang.Object systemService = context.getSystemService("camera");
                kotlin.jvm.internal.Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
                android.hardware.camera2.CameraManager cameraManager = (android.hardware.camera2.CameraManager) systemService;
                java.lang.String[] cameraIdList = cameraManager.getCameraIdList();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cameraIdList, "getCameraIdList(...)");
                int length = cameraIdList.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        android.hardware.camera2.CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraIdList[i]);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(cameraCharacteristics, "getCameraCharacteristics(...)");
                        java.lang.Integer num = (java.lang.Integer) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.LENS_FACING);
                        if (num != null && num.intValue() == 1) {
                            android.hardware.camera2.params.StreamConfigurationMap streamConfigurationMap = (android.hardware.camera2.params.StreamConfigurationMap) cameraCharacteristics.get(android.hardware.camera2.CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                            android.util.Size[] outputSizes = streamConfigurationMap != null ? streamConfigurationMap.getOutputSizes(256) : null;
                            if (outputSizes != null) {
                                listEmptyList = kotlin.collections.ArraysKt.toList(outputSizes);
                                break;
                            }
                        }
                        i++;
                    } else {
                        listEmptyList = kotlin.collections.CollectionsKt.emptyList();
                        break;
                    }
                }
                obj = kotlin.Result.constructor-impl(listEmptyList);
            } catch (java.lang.Throwable th) {
                kotlin.Result.Companion companion3 = kotlin.Result.Companion;
                obj = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(th));
            }
            java.lang.Throwable th2 = kotlin.Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                com.up366.common.log.Logger.error("getSupportedResolutions error:" + th2.getMessage(), th2);
                obj = com.up366.mobile.course.photoanswer.logic.cameraAlum.SupportSizeUtils.fallbackCaptureSizes;
            }
            return (java.util.List) obj;
        }
    }
}
