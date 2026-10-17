package com.up366.mobile.contentprovider;

/* JADX INFO: compiled from: LoginContentProvider.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016JM\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J1\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0016J;\u0010\u0017\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u001b"}, d2 = {"Lcom/up366/mobile/contentprovider/LoginContentProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "onCreate", "", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LoginContentProvider extends android.content.ContentProvider {
    public static final java.lang.String AUTHORITY = "com.up366.mobile.provider";
    private static final android.net.Uri CONTENT_URI;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.contentprovider.LoginContentProvider.Companion INSTANCE = new com.up366.mobile.contentprovider.LoginContentProvider.Companion(null);

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    /* JADX INFO: compiled from: LoginContentProvider.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/up366/mobile/contentprovider/LoginContentProvider$Companion;", "", "<init>", "()V", "AUTHORITY", "", "CONTENT_URI", "Landroid/net/Uri;", "getCONTENT_URI", "()Landroid/net/Uri;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final android.net.Uri getCONTENT_URI() {
            return com.up366.mobile.contentprovider.LoginContentProvider.CONTENT_URI;
        }
    }

    static {
        android.net.Uri uri = android.net.Uri.parse("content://com.up366.mobile.provider/loginInfo");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        CONTENT_URI = uri;
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] projection, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String sortOrder) throws android.content.pm.PackageManager.NameNotFoundException {
        android.content.pm.PackageInfo packageInfo;
        android.content.pm.PackageManager packageManager;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        java.lang.String string = uri.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        android.net.Uri uri2 = CONTENT_URI;
        com.up366.common.log.Logger.error("LoginContentProvider query: " + (!kotlin.jvm.internal.Intrinsics.areEqual(uri2.toString(), string)));
        if (!kotlin.jvm.internal.Intrinsics.areEqual(uri2.toString(), string)) {
            throw new java.lang.IllegalArgumentException("Unsupported URI: " + uri);
        }
        android.content.Context context = getContext();
        java.lang.String nameForUid = (context == null || (packageManager = context.getPackageManager()) == null) ? null : packageManager.getNameForUid(android.os.Binder.getCallingUid());
        com.up366.common.log.Logger.error("LoginContentProvider query: " + nameForUid);
        if (!kotlin.jvm.internal.Intrinsics.areEqual(nameForUid, "com.up366.mobile.dict")) {
            throw new java.lang.SecurityException("Unauthorized access");
        }
        android.content.Context context2 = getContext();
        android.content.pm.PackageManager packageManager2 = context2 != null ? context2.getPackageManager() : null;
        android.content.pm.PackageInfo packageInfo2 = packageManager2 != null ? packageManager2.getPackageInfo(nameForUid, 64) : null;
        if (packageManager2 != null) {
            android.content.Context context3 = getContext();
            java.lang.String packageName = context3 != null ? context3.getPackageName() : null;
            kotlin.jvm.internal.Intrinsics.checkNotNull(packageName);
            packageInfo = packageManager2.getPackageInfo(packageName, 64);
        } else {
            packageInfo = null;
        }
        android.content.pm.Signature[] signatureArr = packageInfo2 != null ? packageInfo2.signatures : null;
        android.content.pm.Signature[] signatureArr2 = packageInfo != null ? packageInfo.signatures : null;
        if (signatureArr == null || signatureArr2 == null || !java.util.Arrays.equals(signatureArr, signatureArr2)) {
            throw new java.lang.SecurityException("Signature mismatch");
        }
        android.database.MatrixCursor matrixCursor = new android.database.MatrixCursor(new java.lang.String[]{"userInfo"});
        matrixCursor.addRow(new java.lang.String[]{com.up366.mobile.common.logic.Auth.getUserInfo().getUsername() + "#" + com.up366.mobile.common.logic.Auth.getUserInfo().getUid() + "#" + com.up366.mobile.common.logic.Auth.getUserInfo().getOrganId() + "#" + com.up366.mobile.common.logic.Auth.getPassword()});
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues values) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        throw new java.lang.UnsupportedOperationException("Insert operation is not supported");
    }

    @Override // android.content.ContentProvider
    public int delete(android.net.Uri uri, java.lang.String selection, java.lang.String[] selectionArgs) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        throw new java.lang.UnsupportedOperationException("Delete operation is not supported");
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues values, java.lang.String selection, java.lang.String[] selectionArgs) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        throw new java.lang.UnsupportedOperationException("Update operation is not supported");
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uri, "uri");
        return "vnd.android.cursor.item/com.up366.mobile.provider.loginInfo";
    }
}
