package com.up366.mobile.common.helper;

/* JADX INFO: compiled from: UserFunAccreditHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0005J\u0014\u0010\u001d\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/up366/mobile/common/helper/UserFunAccreditHelper;", "", "<init>", "()V", "FUN_ID_FREE_P1P", "", "FUN_ID_PAPER_EXPORT", "FUN_ID_PACKAGE", "FUN_ID_CODE_ANSWER", "FUN_ID_HAND_REVIEW", "STUDY_CARD", "FUN_ID_WRONG_NOTE", "FUN_ID_WORD_NOTE", "FUN_ID_SCHOOL_HOUSE", "CODE_ERROR", "", "CODE_NO_FUN", "CODE_HAS_FUN", "FUN_KEYS", "checkUseFunAsync", "", "funKey", "callBack", "Lcom/up366/common/callback/ICallbackCodeInfo;", "checkFunctionPermission", "Lcom/up366/mobile/common/helper/UserFunAccreditHelper$PermissionResult;", "hasCached", "", "canUseFun", "save", "funList", "", "Lcom/up366/mobile/common/logic/model/UserFunAccredit;", "PermissionResult", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserFunAccreditHelper {
    public static final int CODE_ERROR = -1;
    public static final int CODE_HAS_FUN = 1;
    public static final int CODE_NO_FUN = 0;
    public static final java.lang.String FUN_ID_CODE_ANSWER = "4";
    public static final java.lang.String FUN_ID_FREE_P1P = "1";
    public static final java.lang.String FUN_ID_HAND_REVIEW = "7";
    public static final java.lang.String FUN_ID_PACKAGE = "3";
    public static final java.lang.String FUN_ID_PAPER_EXPORT = "2";
    public static final java.lang.String FUN_ID_SCHOOL_HOUSE = "77";
    public static final java.lang.String FUN_ID_WORD_NOTE = "75";
    public static final java.lang.String FUN_ID_WRONG_NOTE = "74";
    public static final java.lang.String FUN_KEYS = "UserFunAccreditHelper_func_list";
    public static final com.up366.mobile.common.helper.UserFunAccreditHelper INSTANCE = new com.up366.mobile.common.helper.UserFunAccreditHelper();
    public static final java.lang.String STUDY_CARD = "64";

    private UserFunAccreditHelper() {
    }

    /* JADX INFO: compiled from: UserFunAccreditHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/up366/mobile/common/helper/UserFunAccreditHelper$PermissionResult;", "", "<init>", "()V", "HasPermission", "NoPermission", "Error", "Lcom/up366/mobile/common/helper/UserFunAccreditHelper$PermissionResult$Error;", "Lcom/up366/mobile/common/helper/UserFunAccreditHelper$PermissionResult$HasPermission;", "Lcom/up366/mobile/common/helper/UserFunAccreditHelper$PermissionResult$NoPermission;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class PermissionResult {
        public /* synthetic */ PermissionResult(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: UserFunAccreditHelper.kt */
        @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/up366/mobile/common/helper/UserFunAccreditHelper$PermissionResult$HasPermission;", "Lcom/up366/mobile/common/helper/UserFunAccreditHelper$PermissionResult;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class HasPermission extends com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult {
            private final java.lang.String message;

            /* JADX WARN: Illegal instructions before constructor call */
            public HasPermission() {
                java.lang.String str = null;
                this(str, 1, str);
            }

            public static /* synthetic */ com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.HasPermission copy$default(com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.HasPermission hasPermission, java.lang.String str, int i, java.lang.Object obj) {
                if ((i & 1) != 0) {
                    str = hasPermission.message;
                }
                return hasPermission.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final java.lang.String getMessage() {
                return this.message;
            }

            public final com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.HasPermission copy(java.lang.String message) {
                return new com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.HasPermission(message);
            }

            public boolean equals(java.lang.Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.HasPermission) && kotlin.jvm.internal.Intrinsics.areEqual(this.message, ((com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.HasPermission) other).message);
            }

            public int hashCode() {
                java.lang.String str = this.message;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public java.lang.String toString() {
                return "HasPermission(message=" + this.message + ")";
            }

            public HasPermission(java.lang.String str) {
                super(null);
                this.message = str;
            }

            public /* synthetic */ HasPermission(java.lang.String str, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final java.lang.String getMessage() {
                return this.message;
            }
        }

        private PermissionResult() {
        }

        /* JADX INFO: compiled from: UserFunAccreditHelper.kt */
        @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/up366/mobile/common/helper/UserFunAccreditHelper$PermissionResult$NoPermission;", "Lcom/up366/mobile/common/helper/UserFunAccreditHelper$PermissionResult;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class NoPermission extends com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult {
            private final java.lang.String message;

            public static /* synthetic */ com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.NoPermission copy$default(com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.NoPermission noPermission, java.lang.String str, int i, java.lang.Object obj) {
                if ((i & 1) != 0) {
                    str = noPermission.message;
                }
                return noPermission.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final java.lang.String getMessage() {
                return this.message;
            }

            public final com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.NoPermission copy(java.lang.String message) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
                return new com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.NoPermission(message);
            }

            public boolean equals(java.lang.Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.NoPermission) && kotlin.jvm.internal.Intrinsics.areEqual(this.message, ((com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.NoPermission) other).message);
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public java.lang.String toString() {
                return "NoPermission(message=" + this.message + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NoPermission(java.lang.String str) {
                super(null);
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "message");
                this.message = str;
            }

            public final java.lang.String getMessage() {
                return this.message;
            }
        }

        /* JADX INFO: compiled from: UserFunAccreditHelper.kt */
        @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/up366/mobile/common/helper/UserFunAccreditHelper$PermissionResult$Error;", "Lcom/up366/mobile/common/helper/UserFunAccreditHelper$PermissionResult;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class Error extends com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult {
            private final java.lang.String message;

            public static /* synthetic */ com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.Error copy$default(com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.Error error, java.lang.String str, int i, java.lang.Object obj) {
                if ((i & 1) != 0) {
                    str = error.message;
                }
                return error.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final java.lang.String getMessage() {
                return this.message;
            }

            public final com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.Error copy(java.lang.String message) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
                return new com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.Error(message);
            }

            public boolean equals(java.lang.Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.Error) && kotlin.jvm.internal.Intrinsics.areEqual(this.message, ((com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.Error) other).message);
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public java.lang.String toString() {
                return "Error(message=" + this.message + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(java.lang.String str) {
                super(null);
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "message");
                this.message = str;
            }

            public final java.lang.String getMessage() {
                return this.message;
            }
        }
    }

    public final void checkUseFunAsync(final java.lang.String funKey, final com.up366.common.callback.ICallbackCodeInfo callBack) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(funKey, "funKey");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(callBack, "callBack");
        com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.helper.UserFunAccreditHelper$$ExternalSyntheticLambda0
            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
            @Override // com.up366.common.task.Task
            public final void run() throws kotlin.NoWhenBranchMatchedException {
                com.up366.mobile.common.helper.UserFunAccreditHelper.checkUseFunAsync$lambda$0(funKey, callBack);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    public static final void checkUseFunAsync$lambda$0(java.lang.String str, com.up366.common.callback.ICallbackCodeInfo iCallbackCodeInfo) throws kotlin.NoWhenBranchMatchedException {
        try {
            com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult permissionResultCheckFunctionPermission = INSTANCE.checkFunctionPermission(str);
            if (permissionResultCheckFunctionPermission instanceof com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.HasPermission) {
                java.lang.String message = ((com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.HasPermission) permissionResultCheckFunctionPermission).getMessage();
                if (message == null) {
                    message = "有权限";
                }
                iCallbackCodeInfo.onResult(1, message);
                return;
            }
            if (permissionResultCheckFunctionPermission instanceof com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.NoPermission) {
                java.lang.String message2 = ((com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.NoPermission) permissionResultCheckFunctionPermission).getMessage();
                if (message2 == null) {
                    message2 = "没有权限";
                }
                iCallbackCodeInfo.onResult(0, message2);
                return;
            }
            if (!(permissionResultCheckFunctionPermission instanceof com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.Error)) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            java.lang.String message3 = ((com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.Error) permissionResultCheckFunctionPermission).getMessage();
            if (message3 == null) {
                message3 = "获取失败";
            }
            iCallbackCodeInfo.onResult(-1, message3);
        } catch (java.lang.Exception e) {
            iCallbackCodeInfo.onResult(-1, "权限检查异常: " + e.getMessage());
        }
    }

    private final com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult checkFunctionPermission(java.lang.String funKey) {
        int i = 1;
        java.lang.String str = null;
        if (hasCached()) {
            if (canUseFun(funKey)) {
                return new com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.HasPermission(str, i, str);
            }
            return new com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.NoPermission("没有该功能权限");
        }
        try {
            com.up366.common.http.NetHolder<com.up366.mobile.common.logic.model.UrlAppStuConfigInfo> netHolderFetchAllSync = com.up366.mobile.common.logic.Auth.cur().config().fetchAllSync();
            if (netHolderFetchAllSync.resp.isError()) {
                throw new java.lang.RuntimeException(netHolderFetchAllSync.resp.getInfo());
            }
            if (canUseFun(funKey)) {
                return new com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.HasPermission(str, i, str);
            }
            return new com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.NoPermission("没有该功能权限");
        } catch (java.lang.Exception e) {
            return new com.up366.mobile.common.helper.UserFunAccreditHelper.PermissionResult.Error("获取权限失败: " + e.getMessage());
        }
    }

    private final boolean hasCached() {
        try {
            return ((java.util.List) com.up366.mobile.common.logic.Auth.cur().cache().get(FUN_KEYS, new com.alibaba.fastjson.TypeReference<java.util.List<? extends com.up366.mobile.common.logic.model.UserFunAccredit>>() { // from class: com.up366.mobile.common.helper.UserFunAccreditHelper.hasCached.1
            }, (java.lang.Object) null)) != null;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public final boolean canUseFun(java.lang.String funKey) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(funKey, "funKey");
        java.util.List list = (java.util.List) com.up366.mobile.common.logic.Auth.cur().cache().get(FUN_KEYS, new com.alibaba.fastjson.TypeReference<java.util.List<? extends com.up366.mobile.common.logic.model.UserFunAccredit>>() { // from class: com.up366.mobile.common.helper.UserFunAccreditHelper$canUseFun$funs$1
        }, (java.lang.Object) null);
        if (list == null || list.isEmpty()) {
            return false;
        }
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            if (android.text.TextUtils.equals(((com.up366.mobile.common.logic.model.UserFunAccredit) it.next()).getFuncId(), funKey)) {
                return true;
            }
        }
        return false;
    }

    public final void save(java.util.List<com.up366.mobile.common.logic.model.UserFunAccredit> funList) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(funList, "funList");
        com.up366.mobile.common.logic.Auth.cur().cache().put(FUN_KEYS, funList, com.up366.mobile.common.logic.model.AppCacheInfo.TIME_DAY_10);
        com.up366.common.log.Logger.info("TAG - AppConfigMgr - fetchAllSync - funlist : " + com.alibaba.fastjson.JSON.toJSONString(funList));
    }
}
