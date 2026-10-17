package com.up366.mobile.book.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class LocalMediaHelper {
    private final com.up366.mobile.book.helper.V7LocalMediaHelper localMediaHelper;
    private final com.up366.mobile.book.helper.V6RegisterHelper registerHelper;

    public LocalMediaHelper(android.app.Activity activity, com.up366.mobile.book.helper.V6RegisterHelper v6RegisterHelper) {
        this.registerHelper = v6RegisterHelper;
        this.localMediaHelper = new com.up366.mobile.book.helper.V7LocalMediaHelper(activity);
    }

    public void saveToGallery(java.lang.String str) throws java.lang.Throwable {
        this.localMediaHelper.saveToGallery(str, new com.up366.mobile.book.helper.V7LocalMediaHelper.ISaveGalleryCallback() { // from class: com.up366.mobile.book.helper.LocalMediaHelper$$ExternalSyntheticLambda0
            @Override // com.up366.mobile.book.helper.V7LocalMediaHelper.ISaveGalleryCallback
            public final void onResult(int i) {
                this.f$0.lambda$saveToGallery$0(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveToGallery$0(int i) {
        com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
        jSONObject.put("code", java.lang.Integer.valueOf(i));
        this.registerHelper.callJsEvent(com.up366.mobile.book.helper.V6RegisterHelper.EVT_SAVE_TO_GALLERYPRO, "(%s)", jSONObject.toJSONString());
    }
}
