package com.zx.module.exception;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class ZXBizException extends com.zx.module.exception.ZXModuleException {
    private final java.lang.String bizMessage;
    private final int code;

    public ZXBizException(int i, java.lang.String str) {
        super("ZXBizException: code=" + i + ", bizMessage=" + str);
        this.code = i;
        this.bizMessage = str;
    }

    public java.lang.String getBizMessage() {
        return this.bizMessage;
    }

    public int getCode() {
        return this.code;
    }
}
