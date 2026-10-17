package io.objectbox.exception;

/* JADX INFO: compiled from: DbExceptionListener.java */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class DbExceptionListenerJni {
    static native void nativeCancelCurrentException();

    static native void nativeThrowException(long j, int i);

    DbExceptionListenerJni() {
    }
}
