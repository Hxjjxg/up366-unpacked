package io.objectbox.converter;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class FlexObjectConverter implements io.objectbox.converter.PropertyConverter<java.lang.Object, byte[]> {
    private static final java.util.concurrent.atomic.AtomicReference<io.objectbox.flatbuffers.FlexBuffersBuilder> cachedBuilder = new java.util.concurrent.atomic.AtomicReference<>();

    java.lang.Object convertToKey(java.lang.String str) {
        return str;
    }

    @Override // io.objectbox.converter.PropertyConverter
    public byte[] convertToDatabaseValue(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        java.util.concurrent.atomic.AtomicReference<io.objectbox.flatbuffers.FlexBuffersBuilder> atomicReference = cachedBuilder;
        io.objectbox.flatbuffers.FlexBuffersBuilder andSet = atomicReference.getAndSet(null);
        if (andSet == null) {
            andSet = new io.objectbox.flatbuffers.FlexBuffersBuilder(new io.objectbox.flatbuffers.ArrayReadWriteBuf(512), 3);
        }
        addValue(andSet, obj);
        java.nio.ByteBuffer byteBufferFinish = andSet.finish();
        byte[] bArr = new byte[byteBufferFinish.limit()];
        byteBufferFinish.get(bArr);
        if (byteBufferFinish.limit() <= 262144) {
            andSet.clear();
            atomicReference.getAndSet(andSet);
        }
        return bArr;
    }

    private void addValue(io.objectbox.flatbuffers.FlexBuffersBuilder flexBuffersBuilder, java.lang.Object obj) {
        if (obj instanceof java.util.Map) {
            addMap(flexBuffersBuilder, null, (java.util.Map) obj);
            return;
        }
        if (obj instanceof java.util.List) {
            addVector(flexBuffersBuilder, null, (java.util.List) obj);
            return;
        }
        if (obj instanceof java.lang.String) {
            flexBuffersBuilder.putString((java.lang.String) obj);
            return;
        }
        if (obj instanceof java.lang.Boolean) {
            flexBuffersBuilder.putBoolean(((java.lang.Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof java.lang.Byte) {
            flexBuffersBuilder.putInt(((java.lang.Byte) obj).intValue());
            return;
        }
        if (obj instanceof java.lang.Short) {
            flexBuffersBuilder.putInt(((java.lang.Short) obj).intValue());
            return;
        }
        if (obj instanceof java.lang.Integer) {
            flexBuffersBuilder.putInt(((java.lang.Integer) obj).intValue());
            return;
        }
        if (obj instanceof java.lang.Long) {
            flexBuffersBuilder.putInt(((java.lang.Long) obj).longValue());
            return;
        }
        if (obj instanceof java.lang.Float) {
            flexBuffersBuilder.putFloat(((java.lang.Float) obj).floatValue());
            return;
        }
        if (obj instanceof java.lang.Double) {
            flexBuffersBuilder.putFloat(((java.lang.Double) obj).doubleValue());
        } else if (obj instanceof byte[]) {
            flexBuffersBuilder.putBlob((byte[]) obj);
        } else {
            throw new java.lang.IllegalArgumentException("Values of this type are not supported: " + obj.getClass().getSimpleName());
        }
    }

    protected void checkMapKeyType(java.lang.Object obj) {
        if (!(obj instanceof java.lang.String)) {
            throw new java.lang.IllegalArgumentException("Map keys must be String");
        }
    }

    private void addMap(io.objectbox.flatbuffers.FlexBuffersBuilder flexBuffersBuilder, java.lang.String str, java.util.Map<java.lang.Object, java.lang.Object> map) {
        int iStartMap = flexBuffersBuilder.startMap();
        for (java.util.Map.Entry<java.lang.Object, java.lang.Object> entry : map.entrySet()) {
            java.lang.Object key = entry.getKey();
            java.lang.Object value = entry.getValue();
            if (key == null || value == null) {
                throw new java.lang.IllegalArgumentException("Map keys or values must not be null");
            }
            checkMapKeyType(key);
            java.lang.String string = key.toString();
            if (value instanceof java.util.Map) {
                addMap(flexBuffersBuilder, string, (java.util.Map) value);
            } else if (value instanceof java.util.List) {
                addVector(flexBuffersBuilder, string, (java.util.List) value);
            } else if (value instanceof java.lang.String) {
                flexBuffersBuilder.putString(string, (java.lang.String) value);
            } else if (value instanceof java.lang.Boolean) {
                flexBuffersBuilder.putBoolean(string, ((java.lang.Boolean) value).booleanValue());
            } else if (value instanceof java.lang.Byte) {
                flexBuffersBuilder.putInt(string, ((java.lang.Byte) value).intValue());
            } else if (value instanceof java.lang.Short) {
                flexBuffersBuilder.putInt(string, ((java.lang.Short) value).intValue());
            } else if (value instanceof java.lang.Integer) {
                flexBuffersBuilder.putInt(string, ((java.lang.Integer) value).intValue());
            } else if (value instanceof java.lang.Long) {
                flexBuffersBuilder.putInt(string, ((java.lang.Long) value).longValue());
            } else if (value instanceof java.lang.Float) {
                flexBuffersBuilder.putFloat(string, ((java.lang.Float) value).floatValue());
            } else if (value instanceof java.lang.Double) {
                flexBuffersBuilder.putFloat(string, ((java.lang.Double) value).doubleValue());
            } else if (value instanceof byte[]) {
                flexBuffersBuilder.putBlob(string, (byte[]) value);
            } else {
                throw new java.lang.IllegalArgumentException("Map values of this type are not supported: " + value.getClass().getSimpleName());
            }
        }
        flexBuffersBuilder.endMap(str, iStartMap);
    }

    private void addVector(io.objectbox.flatbuffers.FlexBuffersBuilder flexBuffersBuilder, java.lang.String str, java.util.List<java.lang.Object> list) {
        int iStartVector = flexBuffersBuilder.startVector();
        for (java.lang.Object obj : list) {
            if (obj == null) {
                throw new java.lang.IllegalArgumentException("List elements must not be null");
            }
            if (obj instanceof java.util.Map) {
                addMap(flexBuffersBuilder, null, (java.util.Map) obj);
            } else if (obj instanceof java.util.List) {
                addVector(flexBuffersBuilder, null, (java.util.List) obj);
            } else if (obj instanceof java.lang.String) {
                flexBuffersBuilder.putString((java.lang.String) obj);
            } else if (obj instanceof java.lang.Boolean) {
                flexBuffersBuilder.putBoolean(((java.lang.Boolean) obj).booleanValue());
            } else if (obj instanceof java.lang.Byte) {
                flexBuffersBuilder.putInt(((java.lang.Byte) obj).intValue());
            } else if (obj instanceof java.lang.Short) {
                flexBuffersBuilder.putInt(((java.lang.Short) obj).intValue());
            } else if (obj instanceof java.lang.Integer) {
                flexBuffersBuilder.putInt(((java.lang.Integer) obj).intValue());
            } else if (obj instanceof java.lang.Long) {
                flexBuffersBuilder.putInt(((java.lang.Long) obj).longValue());
            } else if (obj instanceof java.lang.Float) {
                flexBuffersBuilder.putFloat(((java.lang.Float) obj).floatValue());
            } else if (obj instanceof java.lang.Double) {
                flexBuffersBuilder.putFloat(((java.lang.Double) obj).doubleValue());
            } else if (obj instanceof byte[]) {
                flexBuffersBuilder.putBlob((byte[]) obj);
            } else {
                throw new java.lang.IllegalArgumentException("List values of this type are not supported: " + obj.getClass().getSimpleName());
            }
        }
        flexBuffersBuilder.endVector(str, iStartVector, false, false);
    }

    @Override // io.objectbox.converter.PropertyConverter
    public java.lang.Object convertToEntityProperty(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        io.objectbox.flatbuffers.FlexBuffers.Reference root = io.objectbox.flatbuffers.FlexBuffers.getRoot(new io.objectbox.flatbuffers.ArrayReadWriteBuf(bArr, bArr.length));
        if (root.isMap()) {
            return buildMap(root.asMap());
        }
        if (root.isVector()) {
            return buildList(root.asVector());
        }
        if (root.isString()) {
            return root.asString();
        }
        if (root.isBoolean()) {
            return java.lang.Boolean.valueOf(root.asBoolean());
        }
        if (root.isInt()) {
            if (shouldRestoreAsLong(root)) {
                return java.lang.Long.valueOf(root.asLong());
            }
            return java.lang.Integer.valueOf(root.asInt());
        }
        if (root.isFloat()) {
            return java.lang.Double.valueOf(root.asFloat());
        }
        if (root.isBlob()) {
            return root.asBlob().getBytes();
        }
        throw new java.lang.IllegalArgumentException("FlexBuffers type is not supported: " + root.getType());
    }

    protected boolean shouldRestoreAsLong(io.objectbox.flatbuffers.FlexBuffers.Reference reference) {
        try {
            java.lang.reflect.Field declaredField = reference.getClass().getDeclaredField("parentWidth");
            declaredField.setAccessible(true);
            return ((java.lang.Integer) declaredField.get(reference)).intValue() == 8;
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException("FlexMapConverter could not determine FlexBuffers integer bit width.", e);
        }
    }

    private java.util.Map<java.lang.Object, java.lang.Object> buildMap(io.objectbox.flatbuffers.FlexBuffers.Map map) {
        int size = map.size();
        io.objectbox.flatbuffers.FlexBuffers.KeyVector keyVectorKeys = map.keys();
        io.objectbox.flatbuffers.FlexBuffers.Vector vectorValues = map.values();
        java.util.HashMap map2 = new java.util.HashMap((int) ((((double) size) / 0.75d) + 1.0d));
        for (int i = 0; i < size; i++) {
            java.lang.Object objConvertToKey = convertToKey(keyVectorKeys.get(i).toString());
            io.objectbox.flatbuffers.FlexBuffers.Reference reference = vectorValues.get(i);
            if (reference.isMap()) {
                map2.put(objConvertToKey, buildMap(reference.asMap()));
            } else if (reference.isVector()) {
                map2.put(objConvertToKey, buildList(reference.asVector()));
            } else if (reference.isString()) {
                map2.put(objConvertToKey, reference.asString());
            } else if (reference.isBoolean()) {
                map2.put(objConvertToKey, java.lang.Boolean.valueOf(reference.asBoolean()));
            } else if (reference.isInt()) {
                if (shouldRestoreAsLong(reference)) {
                    map2.put(objConvertToKey, java.lang.Long.valueOf(reference.asLong()));
                } else {
                    map2.put(objConvertToKey, java.lang.Integer.valueOf(reference.asInt()));
                }
            } else if (reference.isFloat()) {
                map2.put(objConvertToKey, java.lang.Double.valueOf(reference.asFloat()));
            } else if (reference.isBlob()) {
                map2.put(objConvertToKey, reference.asBlob().getBytes());
            } else {
                throw new java.lang.IllegalArgumentException("Map values of this type are not supported: " + reference.getClass().getSimpleName());
            }
        }
        return map2;
    }

    private java.util.List<java.lang.Object> buildList(io.objectbox.flatbuffers.FlexBuffers.Vector vector) {
        int size = vector.size();
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        java.lang.Boolean boolValueOf = null;
        for (int i = 0; i < size; i++) {
            io.objectbox.flatbuffers.FlexBuffers.Reference reference = vector.get(i);
            if (reference.isMap()) {
                arrayList.add(buildMap(reference.asMap()));
            } else if (reference.isVector()) {
                arrayList.add(buildList(reference.asVector()));
            } else if (reference.isString()) {
                arrayList.add(reference.asString());
            } else if (reference.isBoolean()) {
                arrayList.add(java.lang.Boolean.valueOf(reference.asBoolean()));
            } else if (reference.isInt()) {
                if (boolValueOf == null) {
                    boolValueOf = java.lang.Boolean.valueOf(shouldRestoreAsLong(reference));
                }
                if (boolValueOf.booleanValue()) {
                    arrayList.add(java.lang.Long.valueOf(reference.asLong()));
                } else {
                    arrayList.add(java.lang.Integer.valueOf(reference.asInt()));
                }
            } else if (reference.isFloat()) {
                arrayList.add(java.lang.Double.valueOf(reference.asFloat()));
            } else if (reference.isBlob()) {
                arrayList.add(reference.asBlob().getBytes());
            } else {
                throw new java.lang.IllegalArgumentException("List values of this type are not supported: " + reference.getClass().getSimpleName());
            }
        }
        return arrayList;
    }
}
