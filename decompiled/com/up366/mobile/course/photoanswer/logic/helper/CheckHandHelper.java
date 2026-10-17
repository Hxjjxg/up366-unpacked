package com.up366.mobile.course.photoanswer.logic.helper;

/* JADX INFO: compiled from: CheckHandHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0013\u001a\u00020\nJ\b\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/helper/CheckHandHelper;", "", "<init>", "()V", "imageLabeler", "Lcom/google/mlkit/vision/label/ImageLabeler;", "checkList", "", "Lcom/up366/mobile/course/photoanswer/logic/helper/CheckHandHelper$HandCheckResult;", "runStatus", "", "start", "", "stop", "isRunning", "detectInImage", "", "bitmap", "Landroid/graphics/Bitmap;", "isNoHand", "reset", "checkStatus", "HandCheckStatus", "HandCheckResult", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CheckHandHelper {
    public static final com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper INSTANCE = new com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper();
    private static java.util.List<com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult> checkList;
    private static final com.google.mlkit.vision.label.ImageLabeler imageLabeler;
    private static volatile boolean runStatus;

    private CheckHandHelper() {
    }

    static {
        com.google.mlkit.vision.label.ImageLabeler client = com.google.mlkit.vision.label.ImageLabeling.getClient(com.google.mlkit.vision.label.defaults.ImageLabelerOptions.DEFAULT_OPTIONS);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        imageLabeler = client;
        checkList = new java.util.ArrayList();
    }

    /* JADX INFO: compiled from: CheckHandHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/helper/CheckHandHelper$HandCheckStatus;", "", "<init>", "()V", "HAND_CHECK_STATUS_HOLD", "", "HAND_CHECK_STATUS_HAND_ENTER", "HAND_CHECK_STATUS_HAND_LEAVE", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class HandCheckStatus {
        public static final int HAND_CHECK_STATUS_HAND_ENTER = 1;
        public static final int HAND_CHECK_STATUS_HAND_LEAVE = 2;
        public static final int HAND_CHECK_STATUS_HOLD = 0;
        public static final com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckStatus INSTANCE = new com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckStatus();

        private HandCheckStatus() {
        }
    }

    /* JADX INFO: compiled from: CheckHandHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/helper/CheckHandHelper$HandCheckResult;", "", "hasHand", "", "labelList", "", "<init>", "(ZLjava/lang/String;)V", "getHasHand", "()Z", "getLabelList", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class HandCheckResult {
        private final boolean hasHand;
        private final java.lang.String labelList;

        public static /* synthetic */ com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult copy$default(com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult handCheckResult, boolean z, java.lang.String str, int i, java.lang.Object obj) {
            if ((i & 1) != 0) {
                z = handCheckResult.hasHand;
            }
            if ((i & 2) != 0) {
                str = handCheckResult.labelList;
            }
            return handCheckResult.copy(z, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getHasHand() {
            return this.hasHand;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final java.lang.String getLabelList() {
            return this.labelList;
        }

        public final com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult copy(boolean hasHand, java.lang.String labelList) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(labelList, "labelList");
            return new com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult(hasHand, labelList);
        }

        public boolean equals(java.lang.Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult)) {
                return false;
            }
            com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult handCheckResult = (com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult) other;
            return this.hasHand == handCheckResult.hasHand && kotlin.jvm.internal.Intrinsics.areEqual(this.labelList, handCheckResult.labelList);
        }

        public int hashCode() {
            return (com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticBackport0.m(this.hasHand) * 31) + this.labelList.hashCode();
        }

        public java.lang.String toString() {
            return "HandCheckResult(hasHand=" + this.hasHand + ", labelList=" + this.labelList + ")";
        }

        public HandCheckResult(boolean z, java.lang.String str) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "labelList");
            this.hasHand = z;
            this.labelList = str;
        }

        public final boolean getHasHand() {
            return this.hasHand;
        }

        public final java.lang.String getLabelList() {
            return this.labelList;
        }
    }

    public final void start() {
        runStatus = true;
        reset();
    }

    public final void stop() {
        runStatus = false;
    }

    public final boolean isRunning() {
        return runStatus;
    }

    public final int detectInImage(android.graphics.Bitmap bitmap) throws java.lang.InterruptedException {
        if (!runStatus) {
            return 0;
        }
        final java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        com.google.mlkit.vision.label.ImageLabeler imageLabeler2 = imageLabeler;
        kotlin.jvm.internal.Intrinsics.checkNotNull(bitmap);
        com.google.android.gms.tasks.Task taskProcess = imageLabeler2.process(com.google.mlkit.vision.common.InputImage.fromBitmap(bitmap, 0));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(taskProcess, "process(...)");
        taskProcess.addOnCompleteListener(new com.google.android.gms.tasks.OnCompleteListener() { // from class: com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper$$ExternalSyntheticLambda0
            public final void onComplete(com.google.android.gms.tasks.Task task) {
                com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.detectInImage$lambda$1(countDownLatch, task);
            }
        });
        countDownLatch.await();
        if (checkList.size() > 6) {
            checkList.remove(0);
        }
        return checkStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectInImage$lambda$1(java.util.concurrent.CountDownLatch countDownLatch, com.google.android.gms.tasks.Task task) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(task, "task1");
        boolean z = false;
        if (task.getResult() == null) {
            java.util.List<com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult> list = checkList;
            java.lang.String jSONString = com.alibaba.fastjson.JSON.toJSONString(new java.util.ArrayList());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
            list.add(new com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult(false, jSONString));
            countDownLatch.countDown();
            return;
        }
        java.lang.Object result = task.getResult();
        kotlin.jvm.internal.Intrinsics.checkNotNull(result);
        java.lang.Iterable iterable = (java.lang.Iterable) result;
        if (!(iterable instanceof java.util.Collection) || !((java.util.Collection) iterable).isEmpty()) {
            java.util.Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                java.lang.String text = ((com.google.mlkit.vision.label.ImageLabel) it.next()).getText();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                if (kotlin.text.StringsKt.contains$default(text, "Hand", false, 2, (java.lang.Object) null)) {
                    z = true;
                    break;
                }
            }
        }
        java.util.List<com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult> list2 = checkList;
        java.lang.String jSONString2 = com.alibaba.fastjson.JSON.toJSONString(task.getResult());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jSONString2, "toJSONString(...)");
        list2.add(new com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult(z, jSONString2));
        countDownLatch.countDown();
    }

    public final boolean isNoHand() {
        java.util.List listTakeLast = kotlin.collections.CollectionsKt.takeLast(checkList, 3);
        if ((listTakeLast instanceof java.util.Collection) && listTakeLast.isEmpty()) {
            return true;
        }
        java.util.Iterator it = listTakeLast.iterator();
        while (it.hasNext()) {
            if (!(!((com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult) it.next()).getHasHand())) {
                return false;
            }
        }
        return true;
    }

    private final void reset() {
        java.util.ArrayList arrayList = new java.util.ArrayList(6);
        for (int i = 0; i < 6; i++) {
            arrayList.add(new com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult(false, ""));
        }
        checkList = kotlin.collections.CollectionsKt.toMutableList(kotlin.collections.CollectionsKt.toList(arrayList));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int checkStatus() {
        /*
            r4 = this;
            java.util.List<com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper$HandCheckResult> r0 = com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.checkList
            r1 = 3
            java.util.List r0 = kotlin.collections.CollectionsKt.takeLast(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r2 = r0 instanceof java.util.Collection
            r3 = 1
            if (r2 == 0) goto L19
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L19
            goto L8e
        L19:
            java.util.Iterator r0 = r0.iterator()
        L1d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L8e
            java.lang.Object r2 = r0.next()
            com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper$HandCheckResult r2 = (com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult) r2
            boolean r2 = r2.getHasHand()
            if (r2 != 0) goto L1d
            java.util.List<com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper$HandCheckResult> r0 = com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.checkList
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.take(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r2 = r0 instanceof java.util.Collection
            if (r2 == 0) goto L47
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L47
            goto L5e
        L47:
            java.util.Iterator r0 = r0.iterator()
        L4b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L5e
            java.lang.Object r2 = r0.next()
            com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper$HandCheckResult r2 = (com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult) r2
            boolean r2 = r2.getHasHand()
            if (r2 != 0) goto L4b
            goto L8b
        L5e:
            java.util.List<com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper$HandCheckResult> r0 = com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.checkList
            java.util.List r0 = kotlin.collections.CollectionsKt.takeLast(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L74
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L74
            goto L8d
        L74:
            java.util.Iterator r0 = r0.iterator()
        L78:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L8d
            java.lang.Object r1 = r0.next()
            com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper$HandCheckResult r1 = (com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.HandCheckResult) r1
            boolean r1 = r1.getHasHand()
            r1 = r1 ^ r3
            if (r1 != 0) goto L78
        L8b:
            r3 = 0
            goto L8e
        L8d:
            r3 = 2
        L8e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.course.photoanswer.logic.helper.CheckHandHelper.checkStatus():int");
    }
}
