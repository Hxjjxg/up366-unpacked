package java8.util.stream;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
enum StreamOpFlag {
    DISTINCT(0, set(java8.util.stream.StreamOpFlag.Type.SPLITERATOR).set(java8.util.stream.StreamOpFlag.Type.STREAM).setAndClear(java8.util.stream.StreamOpFlag.Type.OP)),
    SORTED(1, set(java8.util.stream.StreamOpFlag.Type.SPLITERATOR).set(java8.util.stream.StreamOpFlag.Type.STREAM).setAndClear(java8.util.stream.StreamOpFlag.Type.OP)),
    ORDERED(2, set(java8.util.stream.StreamOpFlag.Type.SPLITERATOR).set(java8.util.stream.StreamOpFlag.Type.STREAM).setAndClear(java8.util.stream.StreamOpFlag.Type.OP).clear(java8.util.stream.StreamOpFlag.Type.TERMINAL_OP).clear(java8.util.stream.StreamOpFlag.Type.UPSTREAM_TERMINAL_OP)),
    SIZED(3, set(java8.util.stream.StreamOpFlag.Type.SPLITERATOR).set(java8.util.stream.StreamOpFlag.Type.STREAM).clear(java8.util.stream.StreamOpFlag.Type.OP)),
    SHORT_CIRCUIT(12, set(java8.util.stream.StreamOpFlag.Type.OP).set(java8.util.stream.StreamOpFlag.Type.TERMINAL_OP));

    private static final int CLEAR_BITS = 2;
    private static final int FLAG_MASK;
    private static final int FLAG_MASK_IS;
    private static final int FLAG_MASK_NOT;
    static final int INITIAL_OPS_VALUE;
    static final int IS_DISTINCT;
    static final int IS_ORDERED;
    static final int IS_SHORT_CIRCUIT;
    static final int IS_SIZED;
    static final int IS_SORTED;
    static final int NOT_DISTINCT;
    static final int NOT_ORDERED;
    static final int NOT_SIZED;
    static final int NOT_SORTED;
    static final int OP_MASK;
    private static final int PRESERVE_BITS = 3;
    private static final int SET_BITS = 1;
    static final int SPLITERATOR_CHARACTERISTICS_MASK;
    static final int STREAM_MASK;
    static final int TERMINAL_OP_MASK;
    static final int UPSTREAM_TERMINAL_OP_MASK;
    private final int bitPosition;
    private final int clear;
    private final java.util.Map<java8.util.stream.StreamOpFlag.Type, java.lang.Integer> maskTable;
    private final int preserve;
    private final int set;

    enum Type {
        SPLITERATOR,
        STREAM,
        OP,
        TERMINAL_OP,
        UPSTREAM_TERMINAL_OP
    }

    static {
        java8.util.stream.StreamOpFlag streamOpFlag = DISTINCT;
        java8.util.stream.StreamOpFlag streamOpFlag2 = SORTED;
        java8.util.stream.StreamOpFlag streamOpFlag3 = ORDERED;
        java8.util.stream.StreamOpFlag streamOpFlag4 = SIZED;
        java8.util.stream.StreamOpFlag streamOpFlag5 = SHORT_CIRCUIT;
        SPLITERATOR_CHARACTERISTICS_MASK = createMask(java8.util.stream.StreamOpFlag.Type.SPLITERATOR);
        int iCreateMask = createMask(java8.util.stream.StreamOpFlag.Type.STREAM);
        STREAM_MASK = iCreateMask;
        OP_MASK = createMask(java8.util.stream.StreamOpFlag.Type.OP);
        TERMINAL_OP_MASK = createMask(java8.util.stream.StreamOpFlag.Type.TERMINAL_OP);
        UPSTREAM_TERMINAL_OP_MASK = createMask(java8.util.stream.StreamOpFlag.Type.UPSTREAM_TERMINAL_OP);
        FLAG_MASK = createFlagMask();
        FLAG_MASK_IS = iCreateMask;
        int i = iCreateMask << 1;
        FLAG_MASK_NOT = i;
        INITIAL_OPS_VALUE = iCreateMask | i;
        IS_DISTINCT = streamOpFlag.set;
        NOT_DISTINCT = streamOpFlag.clear;
        IS_SORTED = streamOpFlag2.set;
        NOT_SORTED = streamOpFlag2.clear;
        IS_ORDERED = streamOpFlag3.set;
        NOT_ORDERED = streamOpFlag3.clear;
        IS_SIZED = streamOpFlag4.set;
        NOT_SIZED = streamOpFlag4.clear;
        IS_SHORT_CIRCUIT = streamOpFlag5.set;
    }

    private static java8.util.stream.StreamOpFlag.MaskBuilder set(java8.util.stream.StreamOpFlag.Type type) {
        return new java8.util.stream.StreamOpFlag.MaskBuilder(new java.util.EnumMap(java8.util.stream.StreamOpFlag.Type.class)).set(type);
    }

    private static class MaskBuilder {
        final java.util.Map<java8.util.stream.StreamOpFlag.Type, java.lang.Integer> map;

        MaskBuilder(java.util.Map<java8.util.stream.StreamOpFlag.Type, java.lang.Integer> map) {
            this.map = map;
        }

        java8.util.stream.StreamOpFlag.MaskBuilder mask(java8.util.stream.StreamOpFlag.Type type, java.lang.Integer num) {
            this.map.put(type, num);
            return this;
        }

        java8.util.stream.StreamOpFlag.MaskBuilder set(java8.util.stream.StreamOpFlag.Type type) {
            return mask(type, 1);
        }

        java8.util.stream.StreamOpFlag.MaskBuilder clear(java8.util.stream.StreamOpFlag.Type type) {
            return mask(type, 2);
        }

        java8.util.stream.StreamOpFlag.MaskBuilder setAndClear(java8.util.stream.StreamOpFlag.Type type) {
            return mask(type, 3);
        }

        java.util.Map<java8.util.stream.StreamOpFlag.Type, java.lang.Integer> build() {
            java.util.Map<java8.util.stream.StreamOpFlag.Type, java.lang.Integer> map = this.map;
            int i = 0;
            if (map instanceof java.util.concurrent.ConcurrentMap) {
                java.util.concurrent.ConcurrentMap concurrentMap = (java.util.concurrent.ConcurrentMap) map;
                java8.util.stream.StreamOpFlag.Type[] typeArrValues = java8.util.stream.StreamOpFlag.Type.values();
                int length = typeArrValues.length;
                while (i < length) {
                    concurrentMap.putIfAbsent(typeArrValues[i], 0);
                    i++;
                }
                return concurrentMap;
            }
            java8.util.stream.StreamOpFlag.Type[] typeArrValues2 = java8.util.stream.StreamOpFlag.Type.values();
            int length2 = typeArrValues2.length;
            while (i < length2) {
                java8.util.Maps.putIfAbsent(this.map, typeArrValues2[i], 0);
                i++;
            }
            return this.map;
        }
    }

    StreamOpFlag(int i, java8.util.stream.StreamOpFlag.MaskBuilder maskBuilder) {
        this.maskTable = maskBuilder.build();
        int i2 = i * 2;
        this.bitPosition = i2;
        this.set = 1 << i2;
        this.clear = 2 << i2;
        this.preserve = 3 << i2;
    }

    int set() {
        return this.set;
    }

    int clear() {
        return this.clear;
    }

    boolean isStreamFlag() {
        return this.maskTable.get(java8.util.stream.StreamOpFlag.Type.STREAM).intValue() > 0;
    }

    boolean isKnown(int i) {
        return (i & this.preserve) == this.set;
    }

    boolean isCleared(int i) {
        return (i & this.preserve) == this.clear;
    }

    boolean isPreserved(int i) {
        int i2 = this.preserve;
        return (i & i2) == i2;
    }

    boolean canSet(java8.util.stream.StreamOpFlag.Type type) {
        return (this.maskTable.get(type).intValue() & 1) > 0;
    }

    private static int createMask(java8.util.stream.StreamOpFlag.Type type) {
        int iIntValue = 0;
        for (java8.util.stream.StreamOpFlag streamOpFlag : values()) {
            iIntValue |= streamOpFlag.maskTable.get(type).intValue() << streamOpFlag.bitPosition;
        }
        return iIntValue;
    }

    private static int createFlagMask() {
        int i = 0;
        for (java8.util.stream.StreamOpFlag streamOpFlag : values()) {
            i |= streamOpFlag.preserve;
        }
        return i;
    }

    private static int getMask(int i) {
        if (i == 0) {
            return FLAG_MASK;
        }
        return ~(((i & FLAG_MASK_NOT) >> 1) | ((FLAG_MASK_IS & i) << 1) | i);
    }

    static int combineOpFlags(int i, int i2) {
        return i | (i2 & getMask(i));
    }

    static int toStreamFlags(int i) {
        return i & ((~i) >> 1) & FLAG_MASK_IS;
    }

    static int toCharacteristics(int i) {
        return i & SPLITERATOR_CHARACTERISTICS_MASK;
    }

    static int fromCharacteristics(java8.util.Spliterator<?> spliterator) {
        int iCharacteristics = spliterator.characteristics();
        if ((iCharacteristics & 4) != 0 && spliterator.getComparator() != null) {
            return SPLITERATOR_CHARACTERISTICS_MASK & iCharacteristics & (-5);
        }
        return SPLITERATOR_CHARACTERISTICS_MASK & iCharacteristics;
    }

    static int fromCharacteristics(int i) {
        return i & SPLITERATOR_CHARACTERISTICS_MASK;
    }
}
