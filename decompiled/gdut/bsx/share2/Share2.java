package gdut.bsx.share2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class Share2 {
    private static final java.lang.String TAG = "Share2";
    private android.app.Activity activity;
    private java.lang.String componentClassName;
    private java.lang.String componentPackageName;
    private java.lang.String contentText;
    private java.lang.String contentType;
    private boolean forcedUseSystemChooser;
    private int requestCode;
    private android.net.Uri shareFileUri;
    private java.lang.String title;

    private Share2(gdut.bsx.share2.Share2.Builder builder) {
        this.activity = builder.activity;
        this.contentType = builder.contentType;
        this.title = builder.title;
        this.shareFileUri = builder.shareFileUri;
        this.contentText = builder.textContent;
        this.componentPackageName = builder.componentPackageName;
        this.componentClassName = builder.componentClassName;
        this.requestCode = builder.requestCode;
        this.forcedUseSystemChooser = builder.forcedUseSystemChooser;
    }

    public void shareBySystem() {
        if (checkShareParam()) {
            android.content.Intent intentCreateShareIntent = createShareIntent();
            if (intentCreateShareIntent == null) {
                android.util.Log.e(TAG, "shareBySystem cancel.");
                return;
            }
            if (this.title == null) {
                this.title = "";
            }
            if (this.forcedUseSystemChooser) {
                intentCreateShareIntent = android.content.Intent.createChooser(intentCreateShareIntent, this.title);
            }
            if (intentCreateShareIntent.resolveActivity(this.activity.getPackageManager()) != null) {
                try {
                    int i = this.requestCode;
                    if (i != -1) {
                        this.activity.startActivityForResult(intentCreateShareIntent, i);
                    } else {
                        this.activity.startActivity(intentCreateShareIntent);
                    }
                } catch (java.lang.Exception e) {
                    android.util.Log.e(TAG, android.util.Log.getStackTraceString(e));
                }
            }
        }
    }

    private android.content.Intent createShareIntent() {
        android.content.Intent intent;
        intent = new android.content.Intent();
        intent.setAction("android.intent.action.SEND");
        intent.addFlags(268435456);
        intent.addCategory("android.intent.category.DEFAULT");
        if (!android.text.TextUtils.isEmpty(this.componentPackageName) && !android.text.TextUtils.isEmpty(this.componentClassName)) {
            intent.setComponent(new android.content.ComponentName(this.componentPackageName, this.componentClassName));
        }
        java.lang.String str = this.contentType;
        str.hashCode();
        switch (str) {
            case "audio/*":
            case "*/*":
            case "video/*":
            case "image/*":
                intent.setAction("android.intent.action.SEND");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setType(this.contentType);
                intent.putExtra("android.intent.extra.STREAM", this.shareFileUri);
                intent.addFlags(268435456);
                intent.addFlags(1);
                android.util.Log.d(TAG, "Share uri: " + this.shareFileUri.toString());
                return intent;
            case "text/plain":
                intent.putExtra("android.intent.extra.TEXT", this.contentText);
                intent.setType(gdut.bsx.share2.ShareContentType.TEXT);
                return intent;
            default:
                android.util.Log.e(TAG, this.contentType + " is not support share type.");
                return null;
        }
    }

    private boolean checkShareParam() {
        if (this.activity == null) {
            android.util.Log.e(TAG, "activity is null.");
            return false;
        }
        if (android.text.TextUtils.isEmpty(this.contentType)) {
            android.util.Log.e(TAG, "Share content type is empty.");
            return false;
        }
        if (gdut.bsx.share2.ShareContentType.TEXT.equals(this.contentType)) {
            if (!android.text.TextUtils.isEmpty(this.contentText)) {
                return true;
            }
            android.util.Log.e(TAG, "Share text context is empty.");
            return false;
        }
        if (this.shareFileUri != null) {
            return true;
        }
        android.util.Log.e(TAG, "Share file path is null.");
        return false;
    }

    public static class Builder {
        private android.app.Activity activity;
        private java.lang.String componentClassName;
        private java.lang.String componentPackageName;
        private android.net.Uri shareFileUri;
        private java.lang.String textContent;
        private java.lang.String title;
        private java.lang.String contentType = gdut.bsx.share2.ShareContentType.FILE;
        private int requestCode = -1;
        private boolean forcedUseSystemChooser = true;

        public Builder(android.app.Activity activity) {
            this.activity = activity;
        }

        public gdut.bsx.share2.Share2.Builder setContentType(java.lang.String str) {
            this.contentType = str;
            return this;
        }

        public gdut.bsx.share2.Share2.Builder setTitle(java.lang.String str) {
            this.title = str;
            return this;
        }

        public gdut.bsx.share2.Share2.Builder setShareFileUri(android.net.Uri uri) {
            this.shareFileUri = uri;
            return this;
        }

        public gdut.bsx.share2.Share2.Builder setTextContent(java.lang.String str) {
            this.textContent = str;
            return this;
        }

        public gdut.bsx.share2.Share2.Builder setShareToComponent(java.lang.String str, java.lang.String str2) {
            this.componentPackageName = str;
            this.componentClassName = str2;
            return this;
        }

        public gdut.bsx.share2.Share2.Builder setOnActivityResult(int i) {
            this.requestCode = i;
            return this;
        }

        public gdut.bsx.share2.Share2.Builder forcedUseSystemChooser(boolean z) {
            this.forcedUseSystemChooser = z;
            return this;
        }

        public gdut.bsx.share2.Share2 build() {
            return new gdut.bsx.share2.Share2(this);
        }
    }
}
