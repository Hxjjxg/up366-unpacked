package com.up366.mobile.book.helper.recordv2;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final /* synthetic */ class CommonRecordHelper$$ExternalSyntheticLambda3 implements com.up366.asecengine.asecmgr.ISpeechStatCallBack {
    public final /* synthetic */ com.up366.mobile.book.helper.recordv2.CommonRecordHelper f$0;

    public /* synthetic */ CommonRecordHelper$$ExternalSyntheticLambda3(com.up366.mobile.book.helper.recordv2.CommonRecordHelper commonRecordHelper) {
        this.f$0 = commonRecordHelper;
    }

    @Override // com.up366.asecengine.asecmgr.ISpeechStatCallBack
    public final void onMediaStateResult(com.up366.asecengine.englishengine.AsecSession asecSession, int i) {
        this.f$0.handleStateChange(asecSession, i);
    }
}
