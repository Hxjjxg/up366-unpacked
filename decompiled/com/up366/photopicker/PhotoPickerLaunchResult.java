package com.up366.photopicker;

/* JADX INFO: compiled from: PhotoPickerLaunchResult.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/up366/photopicker/PhotoPickerLaunchResult;", "", "success", "", "errorCode", "", "errorMessage", "(ZLjava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/String;", "getErrorMessage", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "toWebPayload", "", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PhotoPickerLaunchResult {
    private final java.lang.String errorCode;
    private final java.lang.String errorMessage;
    private final boolean success;

    public static /* synthetic */ com.up366.photopicker.PhotoPickerLaunchResult copy$default(com.up366.photopicker.PhotoPickerLaunchResult photoPickerLaunchResult, boolean z, java.lang.String str, java.lang.String str2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = photoPickerLaunchResult.success;
        }
        if ((i & 2) != 0) {
            str = photoPickerLaunchResult.errorCode;
        }
        if ((i & 4) != 0) {
            str2 = photoPickerLaunchResult.errorMessage;
        }
        return photoPickerLaunchResult.copy(z, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final java.lang.String getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final java.lang.String getErrorMessage() {
        return this.errorMessage;
    }

    public final com.up366.photopicker.PhotoPickerLaunchResult copy(boolean success, java.lang.String errorCode, java.lang.String errorMessage) {
        return new com.up366.photopicker.PhotoPickerLaunchResult(success, errorCode, errorMessage);
    }

    public boolean equals(java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof com.up366.photopicker.PhotoPickerLaunchResult)) {
            return false;
        }
        com.up366.photopicker.PhotoPickerLaunchResult photoPickerLaunchResult = (com.up366.photopicker.PhotoPickerLaunchResult) other;
        return this.success == photoPickerLaunchResult.success && kotlin.jvm.internal.Intrinsics.areEqual(this.errorCode, photoPickerLaunchResult.errorCode) && kotlin.jvm.internal.Intrinsics.areEqual(this.errorMessage, photoPickerLaunchResult.errorMessage);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        java.lang.String str = this.errorCode;
        int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        java.lang.String str2 = this.errorMessage;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public java.lang.String toString() {
        return "PhotoPickerLaunchResult(success=" + this.success + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ')';
    }

    public PhotoPickerLaunchResult(boolean z, java.lang.String str, java.lang.String str2) {
        this.success = z;
        this.errorCode = str;
        this.errorMessage = str2;
    }

    public /* synthetic */ PhotoPickerLaunchResult(boolean z, java.lang.String str, java.lang.String str2, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final java.lang.String getErrorCode() {
        return this.errorCode;
    }

    public final java.lang.String getErrorMessage() {
        return this.errorMessage;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> toWebPayload() {
        return kotlin.collections.MapsKt.mapOf(new kotlin.Pair[]{kotlin.TuplesKt.to("success", java.lang.Boolean.valueOf(this.success)), kotlin.TuplesKt.to("errorCode", this.errorCode), kotlin.TuplesKt.to("errorMessage", this.errorMessage)});
    }
}
