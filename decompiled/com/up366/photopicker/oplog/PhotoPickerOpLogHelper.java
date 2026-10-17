package com.up366.photopicker.oplog;

/* JADX INFO: compiled from: PhotoPickerOpLogHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0002J$\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u001a\u0010!\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\"\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\u0004J\u001a\u0010$\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ,\u0010%\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ.\u0010'\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Lcom/up366/photopicker/oplog/PhotoPickerOpLogHelper;", "", "()V", com.up366.mobile.common.onlinelog.OpLogData.Event.CLICK, "", "getCLICK", "()Ljava/lang/String;", "DEFULT_PRODUCT_TYPE", "", com.up366.mobile.common.onlinelog.OpLogData.Event.ENTER_PAGE, "getENTER_PAGE", com.up366.mobile.common.onlinelog.OpLogData.Event.LEAVE_PAGE, "getLEAVE_PAGE", "isReshoot", "", "()Z", "setReshoot", "(Z)V", "productType", "getProductType", "()I", "setProductType", "(I)V", "addExtData", "", "extData", "Lcom/alibaba/fastjson/JSONObject;", "key", "value", "click", "activity", "Landroid/app/Activity;", "control", "enterPage", "init", "configJson", "leavePage", "log", "event", "other", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PhotoPickerOpLogHelper {
    private static boolean isReshoot;
    public static final com.up366.photopicker.oplog.PhotoPickerOpLogHelper INSTANCE = new com.up366.photopicker.oplog.PhotoPickerOpLogHelper();
    private static final java.lang.String ENTER_PAGE = com.up366.mobile.common.onlinelog.OpLogData.Event.ENTER_PAGE;
    private static final java.lang.String CLICK = com.up366.mobile.common.onlinelog.OpLogData.Event.CLICK;
    private static final java.lang.String LEAVE_PAGE = com.up366.mobile.common.onlinelog.OpLogData.Event.LEAVE_PAGE;
    private static final int DEFULT_PRODUCT_TYPE = com.up366.common.download.DownloadInfo.ERR_UNKNOWN;
    private static int productType = com.up366.common.download.DownloadInfo.ERR_UNKNOWN;

    private PhotoPickerOpLogHelper() {
    }

    public final java.lang.String getENTER_PAGE() {
        return ENTER_PAGE;
    }

    public final java.lang.String getCLICK() {
        return CLICK;
    }

    public final java.lang.String getLEAVE_PAGE() {
        return LEAVE_PAGE;
    }

    public final int getProductType() {
        return productType;
    }

    public final void setProductType(int i) {
        productType = i;
    }

    public final boolean isReshoot() {
        return isReshoot;
    }

    public final void setReshoot(boolean z) {
        isReshoot = z;
    }

    public final void log(android.app.Activity activity, java.lang.String control, java.lang.String event, com.alibaba.fastjson.JSONObject extData) {
        java.lang.String str;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        if (kotlin.jvm.internal.Intrinsics.areEqual("com.lingxi.txai", com.up366.common.global.GB.get().getApplicationId())) {
            if (!(activity instanceof com.up366.photopicker.ui.crop.CropActivity)) {
                str = "aiapp_answer_camera";
            } else {
                str = "aiapp_answer_crop";
            }
        } else if (!(activity instanceof com.up366.photopicker.ui.crop.CropActivity)) {
            str = "answer_camera";
        } else {
            str = "answer_crop";
        }
        if (extData == null) {
            extData = new com.alibaba.fastjson.JSONObject();
        }
        int i = productType;
        if (i != DEFULT_PRODUCT_TYPE) {
            addExtData(extData, "productType", java.lang.Integer.valueOf(i));
        }
        com.up366.common.global.GB.getOpLogUp().reportOpLog(str, control, event, extData);
    }

    private final void addExtData(com.alibaba.fastjson.JSONObject extData, java.lang.String key, java.lang.Object value) {
        if (extData != null) {
            ((java.util.Map) extData).put(key, value);
        }
    }

    public final void init(java.lang.String configJson) {
        int intValue;
        boolean zBooleanValue = false;
        if (com.up366.common.StringUtils.isEmptyOrNull(configJson)) {
            isReshoot = false;
            productType = DEFULT_PRODUCT_TYPE;
            return;
        }
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(configJson);
            if (object.containsKey("productType")) {
                intValue = object.getIntValue("productType");
            } else {
                intValue = DEFULT_PRODUCT_TYPE;
            }
            productType = intValue;
            if (object.containsKey("isReshoot")) {
                java.lang.Boolean bool = object.getBoolean("isReshoot");
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "{\n                config…isReshoot\")\n            }");
                zBooleanValue = bool.booleanValue();
            }
            isReshoot = zBooleanValue;
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.info("PhotoPickerOpLogHelper init config error: " + configJson, e);
        }
    }

    public static /* synthetic */ void enterPage$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper photoPickerOpLogHelper, android.app.Activity activity, com.alibaba.fastjson.JSONObject jSONObject, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            jSONObject = null;
        }
        photoPickerOpLogHelper.enterPage(activity, jSONObject);
    }

    public final void enterPage(android.app.Activity activity, com.alibaba.fastjson.JSONObject extData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        log(activity, null, ENTER_PAGE, extData);
    }

    public static /* synthetic */ void leavePage$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper photoPickerOpLogHelper, android.app.Activity activity, com.alibaba.fastjson.JSONObject jSONObject, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            jSONObject = null;
        }
        photoPickerOpLogHelper.leavePage(activity, jSONObject);
    }

    public final void leavePage(android.app.Activity activity, com.alibaba.fastjson.JSONObject extData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        log(activity, null, LEAVE_PAGE, extData);
    }

    public static /* synthetic */ void click$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper photoPickerOpLogHelper, android.app.Activity activity, java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            jSONObject = null;
        }
        photoPickerOpLogHelper.click(activity, str, jSONObject);
    }

    public final void click(android.app.Activity activity, java.lang.String control, com.alibaba.fastjson.JSONObject extData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        log(activity, control, CLICK, extData);
    }

    public static /* synthetic */ void other$default(com.up366.photopicker.oplog.PhotoPickerOpLogHelper photoPickerOpLogHelper, android.app.Activity activity, java.lang.String str, java.lang.String str2, com.alibaba.fastjson.JSONObject jSONObject, int i, java.lang.Object obj) {
        if ((i & 8) != 0) {
            jSONObject = null;
        }
        photoPickerOpLogHelper.other(activity, str, str2, jSONObject);
    }

    public final void other(android.app.Activity activity, java.lang.String control, java.lang.String event, com.alibaba.fastjson.JSONObject extData) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(activity, "activity");
        log(activity, control, event, extData);
    }
}
