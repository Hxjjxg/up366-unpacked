package com.up366.mobile.common.compat;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class FastJsonParserHacker {
    private static volatile boolean sHacked;

    static {
        hack();
        sHacked = false;
    }

    public static void hack() {
        if (sHacked) {
            return;
        }
        synchronized (com.up366.mobile.common.compat.FastJsonParserHacker.class) {
            if (sHacked) {
                return;
            }
            try {
                com.alibaba.fastjson.parser.ParserConfig globalInstance = com.alibaba.fastjson.parser.ParserConfig.getGlobalInstance();
                globalInstance.putDeserializer(java.lang.Integer.TYPE, com.up366.mobile.common.compat.FastJsonParserHacker.IntegerCodec.INSTANCE);
                globalInstance.putDeserializer(java.lang.Integer.class, com.up366.mobile.common.compat.FastJsonParserHacker.IntegerCodec.INSTANCE);
                globalInstance.putDeserializer(java.lang.Long.TYPE, com.up366.mobile.common.compat.FastJsonParserHacker.IntegerCodec.INSTANCE);
                globalInstance.putDeserializer(java.lang.Long.class, com.up366.mobile.common.compat.FastJsonParserHacker.IntegerCodec.INSTANCE);
                sHacked = true;
            } catch (java.lang.Throwable th) {
                com.up366.common.log.Logger.error("TAG - FastJsonParserHacker - hack", th);
                com.up366.mobile.common.onlinelog.OpLog.report("error-hack-fastjson", android.util.Log.getStackTraceString(th));
            }
        }
    }

    public static final class IntegerCodec implements com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
        public static final com.up366.mobile.common.compat.FastJsonParserHacker.IntegerCodec INSTANCE = new com.up366.mobile.common.compat.FastJsonParserHacker.IntegerCodec();

        public int getFastMatchToken() {
            return 2;
        }

        private IntegerCodec() {
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: com.alibaba.fastjson.JSONException */
        public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) throws com.alibaba.fastjson.JSONException {
            com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i = jSONLexer.token();
            if (i == 8) {
                jSONLexer.nextToken(16);
                return null;
            }
            if (i == 2) {
                long jLongValue = jSONLexer.longValue();
                jSONLexer.nextToken(16);
                return (T) castNumber(java.lang.Long.valueOf(jLongValue), type);
            }
            if (i == 3) {
                java.math.BigDecimal bigDecimalDecimalValue = jSONLexer.decimalValue();
                jSONLexer.nextToken(16);
                return (T) castNumber(bigDecimalDecimalValue, type);
            }
            java.lang.Object obj2 = defaultJSONParser.parse();
            if (obj2 == null) {
                return null;
            }
            if (obj2 instanceof java.lang.Number) {
                return (T) castNumber((java.lang.Number) obj2, type);
            }
            if ((obj2 instanceof java.lang.String) && ((java.lang.String) obj2).length() > 0) {
                try {
                    return (T) castNumber(new java.math.BigDecimal((java.lang.String) obj2), type);
                } catch (java.lang.Exception unused) {
                }
            }
            throw new com.alibaba.fastjson.JSONException("Cannot cast to " + type + ", field : " + obj + ", value : " + obj2);
        }

        private <T> T castNumber(java.lang.Number number, java.lang.reflect.Type type) {
            if (type == java.lang.Long.TYPE || type == java.lang.Long.class) {
                return (T) java.lang.Long.valueOf(number.longValue());
            }
            return (T) java.lang.Integer.valueOf(number.intValue());
        }
    }
}
