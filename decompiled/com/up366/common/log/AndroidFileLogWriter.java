package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogPlatform.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/up366/common/log/AndroidFileLogWriter;", "", "<init>", "()V", "queueLock", "Ljava/util/concurrent/locks/ReentrantLock;", "queueNotEmpty", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/locks/Condition;", "queue", "Lcom/up366/common/log/KmpLogFilePendingQueue;", "worker", "Ljava/lang/Thread;", "enqueue", "", "record", "Lcom/up366/common/log/KmpLogFileRecord;", "consumeLoop", "", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AndroidFileLogWriter {
    public static final com.up366.common.log.AndroidFileLogWriter INSTANCE;
    private static final com.up366.common.log.KmpLogFilePendingQueue queue;
    private static final java.util.concurrent.locks.ReentrantLock queueLock;
    private static final java.util.concurrent.locks.Condition queueNotEmpty;
    private static final java.lang.Thread worker;

    private AndroidFileLogWriter() {
    }

    static {
        final com.up366.common.log.AndroidFileLogWriter androidFileLogWriter = new com.up366.common.log.AndroidFileLogWriter();
        INSTANCE = androidFileLogWriter;
        java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        queueLock = reentrantLock;
        queueNotEmpty = reentrantLock.newCondition();
        queue = new com.up366.common.log.KmpLogFilePendingQueue(0, 1, null);
        java.lang.Thread thread = new java.lang.Thread(new java.lang.Runnable() { // from class: com.up366.common.log.AndroidFileLogWriter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.consumeLoop();
            }
        }, "KmpLogFileWriter");
        thread.setDaemon(true);
        thread.setPriority(1);
        thread.start();
        worker = thread;
    }

    public final boolean enqueue(com.up366.common.log.KmpLogFileRecord record) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(record, "record");
        java.util.concurrent.locks.ReentrantLock reentrantLock = queueLock;
        reentrantLock.lock();
        try {
            boolean zOffer = queue.offer(record);
            if (zOffer) {
                queueNotEmpty.signal();
            }
            return zOffer;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void consumeLoop() {
        com.up366.common.log.KmpLogFilePendingQueue kmpLogFilePendingQueue;
        while (true) {
            try {
                java.util.concurrent.locks.ReentrantLock reentrantLock = queueLock;
                reentrantLock.lock();
                while (true) {
                    try {
                        kmpLogFilePendingQueue = queue;
                        if (kmpLogFilePendingQueue.getSize() != 0) {
                            break;
                        } else {
                            queueNotEmpty.await();
                        }
                    } catch (java.lang.Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                }
                java.util.List listPollBatch$default = com.up366.common.log.KmpLogFilePendingQueue.pollBatch$default(kmpLogFilePendingQueue, 0, 1, null);
                reentrantLock.unlock();
                try {
                    kotlin.Result.Companion companion = kotlin.Result.Companion;
                    com.up366.common.log.AndroidFileLogWriter androidFileLogWriter = this;
                    com.up366.common.log.KmpLogFileRecord kmpLogFileRecord = (com.up366.common.log.KmpLogFileRecord) kotlin.collections.CollectionsKt.first(listPollBatch$default);
                    com.up366.common.log.KmpLogPlatformKt.appendPlatformLogFile(kmpLogFileRecord.getDirectoryPath(), kmpLogFileRecord.getFileName(), kotlin.collections.CollectionsKt.joinToString$default(listPollBatch$default, "", (java.lang.CharSequence) null, (java.lang.CharSequence) null, 0, (java.lang.CharSequence) null, new kotlin.jvm.internal.PropertyReference1Impl() { // from class: com.up366.common.log.AndroidFileLogWriter$consumeLoop$1$1
                        public java.lang.Object get(java.lang.Object obj) {
                            return ((com.up366.common.log.KmpLogFileRecord) obj).getLine();
                        }
                    }, 30, (java.lang.Object) null));
                    kotlin.Result.constructor-impl(kotlin.Unit.INSTANCE);
                } catch (java.lang.Throwable th2) {
                    kotlin.Result.Companion companion2 = kotlin.Result.Companion;
                    kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(th2));
                }
            } catch (java.lang.InterruptedException unused) {
            }
        }
    }
}
