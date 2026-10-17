package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class IfHelper {
    private java.util.HashMap<java.lang.Integer, java.lang.Boolean> resultMap = new java.util.HashMap<>();
    private boolean r = false;

    public interface ICallback {
        void onResult();
    }

    public com.up366.mobile.common.helper.IfHelper IF(boolean z, com.up366.mobile.common.helper.IfHelper.ICallback iCallback) {
        java.lang.Boolean bool = this.resultMap.get(-1);
        if (bool == null) {
            bool = false;
        }
        if (bool.booleanValue()) {
            return this;
        }
        this.r |= z;
        this.resultMap.put(-1, java.lang.Boolean.valueOf(z));
        if (z) {
            iCallback.onResult();
        }
        return this;
    }

    public com.up366.mobile.common.helper.IfHelper IF(int i, boolean z, com.up366.mobile.common.helper.IfHelper.ICallback iCallback) {
        java.lang.Boolean bool = this.resultMap.get(java.lang.Integer.valueOf(i));
        if (bool == null) {
            bool = false;
        }
        if (bool.booleanValue()) {
            return this;
        }
        this.r |= z;
        this.resultMap.put(java.lang.Integer.valueOf(i), java.lang.Boolean.valueOf(z));
        if (z) {
            iCallback.onResult();
        }
        return this;
    }

    public void DEFAULT(com.up366.mobile.common.helper.IfHelper.ICallback iCallback) {
        if (this.r) {
            return;
        }
        iCallback.onResult();
    }

    public void DEFAULT(int i, com.up366.mobile.common.helper.IfHelper.ICallback iCallback) {
        java.lang.Boolean bool = this.resultMap.get(java.lang.Integer.valueOf(i));
        if (bool == null) {
            bool = false;
        }
        if (bool.booleanValue()) {
            return;
        }
        iCallback.onResult();
    }
}
