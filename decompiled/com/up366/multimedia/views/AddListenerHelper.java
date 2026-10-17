package com.up366.multimedia.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
class AddListenerHelper {
    private static final com.up366.multimedia.views.AddListenerHelper inst = new com.up366.multimedia.views.AddListenerHelper();

    private AddListenerHelper() {
    }

    public static com.up366.multimedia.views.AddListenerHelper getInst() {
        return inst;
    }

    android.view.View.OnClickListener initDefaultAddClickListener(final boolean isSupportVideo, final boolean supportZoom, final int maxDuration) {
        return new android.view.View.OnClickListener() { // from class: com.up366.multimedia.views.AddListenerHelper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.multimedia.views.AddListenerHelper.lambda$initDefaultAddClickListener$1(supportZoom, isSupportVideo, maxDuration, view);
            }
        };
    }

    static /* synthetic */ void lambda$initDefaultAddClickListener$1(boolean z, boolean z2, final int i, android.view.View view) {
        com.up366.multimedia.util.MediaHelper.getInstance().getBuilder().setTakePhotoSupportZoom(z);
        java.lang.String[] strArr = {"拍照", "相册选取"};
        if (z2) {
            strArr = new java.lang.String[]{"拍照", "相册选取", "录视频"};
        }
        final com.flyco.dialog.widget.ActionSheetDialog actionSheetDialog = new com.flyco.dialog.widget.ActionSheetDialog(com.up366.common.global.GB.get().getCurrentActivity(), strArr, (android.view.View) null);
        actionSheetDialog.title("请选择方式");
        actionSheetDialog.titleTextSize_SP(13.0f);
        actionSheetDialog.setOnOperItemClickL(new com.flyco.dialog.listener.OnOperItemClickL() { // from class: com.up366.multimedia.views.AddListenerHelper$$ExternalSyntheticLambda1
            public final void onOperItemClick(android.widget.AdapterView adapterView, android.view.View view2, int i2, long j) {
                com.up366.multimedia.views.AddListenerHelper.lambda$initDefaultAddClickListener$0(i, actionSheetDialog, adapterView, view2, i2, j);
            }
        });
        actionSheetDialog.show();
    }

    static /* synthetic */ void lambda$initDefaultAddClickListener$0(int i, com.flyco.dialog.widget.ActionSheetDialog actionSheetDialog, android.widget.AdapterView adapterView, android.view.View view, int i2, long j) {
        if (i2 == 0) {
            com.up366.multimedia.util.SkipUtil.toTakePhoto();
        } else if (i2 == 1) {
            com.up366.multimedia.util.SkipUtil.toAlbum();
        } else {
            com.up366.multimedia.util.VideoRecordUtil.startRecorder(com.up366.common.global.GB.get().getCurrentActivity(), i);
        }
        actionSheetDialog.dismiss();
    }
}
