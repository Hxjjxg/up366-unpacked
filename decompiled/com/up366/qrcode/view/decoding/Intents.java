package com.up366.qrcode.view.decoding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class Intents {
    private Intents() {
    }

    public static final class Scan {
        public static final java.lang.String ACTION = "com.google.zxing.client.android.SCAN";
        public static final java.lang.String CHARACTER_SET = "CHARACTER_SET";
        public static final java.lang.String DATA_MATRIX_MODE = "DATA_MATRIX_MODE";
        public static final java.lang.String MODE = "SCAN_MODE";
        public static final java.lang.String ONE_D_MODE = "ONE_D_MODE";
        public static final java.lang.String PRODUCT_MODE = "PRODUCT_MODE";
        public static final java.lang.String QR_CODE_MODE = "QR_CODE_MODE";
        public static final java.lang.String RESULT = "SCAN_RESULT";
        public static final java.lang.String RESULT_FORMAT = "SCAN_RESULT_FORMAT";
        public static final java.lang.String SAVE_HISTORY = "SAVE_HISTORY";
        public static final java.lang.String SCAN_FORMATS = "SCAN_FORMATS";

        private Scan() {
        }
    }

    public static final class Encode {
        public static final java.lang.String ACTION = "com.google.zxing.client.android.ENCODE";
        public static final java.lang.String DATA = "ENCODE_DATA";
        public static final java.lang.String FORMAT = "ENCODE_FORMAT";
        public static final java.lang.String TYPE = "ENCODE_TYPE";

        private Encode() {
        }
    }

    public static final class SearchBookContents {
        public static final java.lang.String ACTION = "com.google.zxing.client.android.SEARCH_BOOK_CONTENTS";
        public static final java.lang.String ISBN = "ISBN";
        public static final java.lang.String QUERY = "QUERY";

        private SearchBookContents() {
        }
    }

    public static final class WifiConnect {
        public static final java.lang.String ACTION = "com.google.zxing.client.android.WIFI_CONNECT";
        public static final java.lang.String PASSWORD = "PASSWORD";
        public static final java.lang.String SSID = "SSID";
        public static final java.lang.String TYPE = "TYPE";

        private WifiConnect() {
        }
    }

    public static final class Share {
        public static final java.lang.String ACTION = "com.google.zxing.client.android.SHARE";

        private Share() {
        }
    }
}
