package com.up366.common.log;

/* JADX INFO: compiled from: KmpLogFileQueue.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bJ\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/up366/common/log/KmpLogFilePendingQueue;", "", "capacity", "", "<init>", "(I)V", "records", "Lkotlin/collections/ArrayDeque;", "Lcom/up366/common/log/KmpLogFileRecord;", "size", "getSize", "()I", "value", "", "droppedCount", "getDroppedCount", "()J", "offer", "", "record", "pollBatch", "", "maxBatchSize", "kmpLog_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KmpLogFilePendingQueue {
    private final int capacity;
    private long droppedCount;
    private final kotlin.collections.ArrayDeque<com.up366.common.log.KmpLogFileRecord> records;

    public KmpLogFilePendingQueue() {
        this(0, 1, null);
    }

    public KmpLogFilePendingQueue(int i) {
        this.capacity = i;
        this.records = new kotlin.collections.ArrayDeque<>();
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("File log queue capacity must be positive".toString());
        }
    }

    public /* synthetic */ KmpLogFilePendingQueue(int i, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1024 : i);
    }

    public final int getSize() {
        return this.records.size();
    }

    public final long getDroppedCount() {
        return this.droppedCount;
    }

    public final boolean offer(com.up366.common.log.KmpLogFileRecord record) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(record, "record");
        if (this.records.size() >= this.capacity) {
            int i = 0;
            if (!com.up366.common.log.KmpLogFileQueueKt.isImportantFileLog(record.getLevel())) {
                this.droppedCount++;
                return false;
            }
            java.util.Iterator it = this.records.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                if (!com.up366.common.log.KmpLogFileQueueKt.isImportantFileLog(((com.up366.common.log.KmpLogFileRecord) it.next()).getLevel())) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
            }
            this.droppedCount++;
            this.records.addLast(record);
            return true;
        }
        this.records.addLast(record);
        return true;
    }

    public static /* synthetic */ java.util.List pollBatch$default(com.up366.common.log.KmpLogFilePendingQueue kmpLogFilePendingQueue, int i, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            i = 64;
        }
        return kmpLogFilePendingQueue.pollBatch(i);
    }

    public final java.util.List<com.up366.common.log.KmpLogFileRecord> pollBatch(int maxBatchSize) {
        com.up366.common.log.KmpLogFileRecord kmpLogFileRecord;
        if (maxBatchSize <= 0) {
            throw new java.lang.IllegalArgumentException("File log batch size must be positive".toString());
        }
        com.up366.common.log.KmpLogFileRecord kmpLogFileRecord2 = (com.up366.common.log.KmpLogFileRecord) this.records.removeFirstOrNull();
        if (kmpLogFileRecord2 == null) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(java.lang.Math.min(maxBatchSize, this.records.size() + 1));
        java.util.ArrayList arrayList2 = arrayList;
        arrayList2.add(kmpLogFileRecord2);
        while (arrayList.size() < maxBatchSize && (kmpLogFileRecord = (com.up366.common.log.KmpLogFileRecord) this.records.firstOrNull()) != null && kotlin.jvm.internal.Intrinsics.areEqual(kmpLogFileRecord.getDirectoryPath(), kmpLogFileRecord2.getDirectoryPath()) && kotlin.jvm.internal.Intrinsics.areEqual(kmpLogFileRecord.getFileName(), kmpLogFileRecord2.getFileName())) {
            arrayList2.add(this.records.removeFirst());
        }
        return arrayList;
    }
}
