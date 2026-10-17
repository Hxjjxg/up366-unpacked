package com.igexin.base.api;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class Logger implements com.igexin.base.a.a {
    private com.igexin.base.a.a mBase;

    public static class Builder {
        private com.igexin.base.a.c mLog = new com.igexin.base.a.c();

        public com.igexin.base.api.Logger build() {
            return new com.igexin.base.api.Logger(this.mLog);
        }

        public com.igexin.base.api.Logger.Builder enableLog(boolean z) {
            this.mLog.enableLog(z);
            return this;
        }

        public com.igexin.base.api.Logger.Builder setPath(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                throw null;
            }
            this.mLog.f = str;
            return this;
        }

        public com.igexin.base.api.Logger.Builder setPeriodicCondition(int i, long j) {
            com.igexin.base.a.c cVar = this.mLog;
            int iMax = java.lang.Math.max(0, i);
            long jMax = java.lang.Math.max(0L, j);
            cVar.b = iMax;
            cVar.c = jMax;
            return this;
        }

        public com.igexin.base.api.Logger.Builder setRc4Key(java.lang.String str) {
            if (!android.text.TextUtils.isEmpty(str) && com.igexin.base.util.a.a.a(str.getBytes())) {
                this.mLog.e = str;
            }
            return this;
        }
    }

    private Logger(com.igexin.base.a.a aVar) {
        this.mBase = aVar;
    }

    @Override // com.igexin.base.a.a
    public final void enableLog(boolean z) {
        this.mBase.enableLog(z);
    }

    @Override // com.igexin.base.a.a
    public final boolean isEnabled() {
        return this.mBase.isEnabled();
    }

    @Override // com.igexin.base.a.a
    public final void log(java.lang.String str) {
        this.mBase.log(str);
    }
}
