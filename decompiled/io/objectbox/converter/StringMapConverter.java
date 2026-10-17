package io.objectbox.converter;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class StringMapConverter implements io.objectbox.converter.PropertyConverter<java.util.Map<java.lang.String, java.lang.String>, byte[]> {
    private static final java.util.concurrent.atomic.AtomicReference<io.objectbox.flatbuffers.FlexBuffersBuilder> cachedBuilder = new java.util.concurrent.atomic.AtomicReference<>();

    @Override // io.objectbox.converter.PropertyConverter
    public byte[] convertToDatabaseValue(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return null;
        }
        io.objectbox.flatbuffers.FlexBuffersBuilder andSet = cachedBuilder.getAndSet(null);
        if (andSet == null) {
            andSet = new io.objectbox.flatbuffers.FlexBuffersBuilder(new io.objectbox.flatbuffers.ArrayReadWriteBuf(512), 3);
        }
        int iStartMap = andSet.startMap();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                throw new java.lang.IllegalArgumentException("Map keys or values must not be null");
            }
            andSet.putString(entry.getKey(), entry.getValue());
        }
        andSet.endMap(null, iStartMap);
        java.nio.ByteBuffer byteBufferFinish = andSet.finish();
        byte[] bArr = new byte[byteBufferFinish.limit()];
        byteBufferFinish.get(bArr);
        if (byteBufferFinish.limit() <= 262144) {
            andSet.clear();
            cachedBuilder.getAndSet(andSet);
        }
        return bArr;
    }

    @Override // io.objectbox.converter.PropertyConverter
    public java.util.Map<java.lang.String, java.lang.String> convertToEntityProperty(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        io.objectbox.flatbuffers.FlexBuffers.Map mapAsMap = io.objectbox.flatbuffers.FlexBuffers.getRoot(new io.objectbox.flatbuffers.ArrayReadWriteBuf(bArr, bArr.length)).asMap();
        int size = mapAsMap.size();
        io.objectbox.flatbuffers.FlexBuffers.KeyVector keyVectorKeys = mapAsMap.keys();
        io.objectbox.flatbuffers.FlexBuffers.Vector vectorValues = mapAsMap.values();
        java.util.HashMap map = new java.util.HashMap((int) ((((double) size) / 0.75d) + 1.0d));
        for (int i = 0; i < size; i++) {
            map.put(keyVectorKeys.get(i).toString(), vectorValues.get(i).asString());
        }
        return map;
    }
}
