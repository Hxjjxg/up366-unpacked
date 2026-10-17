package com.up366.mobile.common.event;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class LoadWebViewEvent extends com.android.tools.r8.RecordTag {
    public static final int STATE_FAILED_SHOW_LOADING_ERROR = 3;
    public static final int STATE_LOADING_SHOW_LOADING = 1;
    public static final int STATE_SUCCESS_HIDE_LOADING = 2;
    public static final int TYPE_2019_COMMON_WEBVIEW = 3;
    public static final int TYPE_2023_COMMON_WEBVIEW = 2;
    public static final int TYPE_PAPER_RESOURCE = 1;
    private final int state;
    private final int type;

    private /* synthetic */ boolean $record$equals(java.lang.Object obj) {
        if (obj != null && getClass() == obj.getClass()) {
            return java.util.Arrays.equals($record$getFieldsAsObjects(), ((com.up366.mobile.common.event.LoadWebViewEvent) obj).$record$getFieldsAsObjects());
        }
        return false;
    }

    private /* synthetic */ java.lang.Object[] $record$getFieldsAsObjects() {
        return new java.lang.Object[]{java.lang.Integer.valueOf(this.type), java.lang.Integer.valueOf(this.state)};
    }

    public LoadWebViewEvent(int type, int state) {
        this.type = type;
        this.state = state;
    }

    public final boolean equals(java.lang.Object obj) {
        return $record$equals(obj);
    }

    public final int hashCode() {
        return com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticBackport0.m(getClass(), $record$getFieldsAsObjects());
    }

    public int state() {
        return this.state;
    }

    public final java.lang.String toString() {
        return com.up366.mobile.common.logic.AppConfigMgr$$ExternalSyntheticBackport0.m($record$getFieldsAsObjects(), com.up366.mobile.common.event.LoadWebViewEvent.class, "type;state");
    }

    public int type() {
        return this.type;
    }
}
