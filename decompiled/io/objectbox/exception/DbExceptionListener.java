package io.objectbox.exception;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface DbExceptionListener {
    void onDbException(java.lang.Exception exc);

    /* JADX INFO: renamed from: io.objectbox.exception.DbExceptionListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void cancelCurrentException() {
            io.objectbox.exception.DbExceptionListenerJni.nativeCancelCurrentException();
        }
    }
}
