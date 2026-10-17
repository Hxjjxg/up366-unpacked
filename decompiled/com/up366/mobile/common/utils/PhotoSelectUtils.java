package com.up366.mobile.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PhotoSelectUtils {
    public static void showPictureDialog(final android.content.Context context, final java.lang.String str, final boolean z, final boolean z2, final boolean z3) {
        final java.lang.Runnable runnable = new java.lang.Runnable() { // from class: com.up366.mobile.common.utils.PhotoSelectUtils$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                android.content.Context context2 = context;
                com.up366.mobile.common.utils.PermissionUtils.checkPermission(context2, new java.lang.String[]{"相机权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, context2.getString(com.up366.mobile.R.string.permission_camera), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.utils.PhotoSelectUtils$$ExternalSyntheticLambda2
                    @Override // com.up366.common.callback.ICallbackCodeInfo
                    public final void onResult(int i, java.lang.String str2) {
                        com.up366.mobile.common.utils.PhotoSelectUtils.lambda$showPictureDialog$0(z, i, str2);
                    }
                });
            }
        };
        if (com.up366.mobile.common.utils.PlatformUtils.isClosePad()) {
            runnable.run();
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel = new com.up366.mobile.common.views.bottomsheet.BottomSheetModel();
        bottomSheetModel.setContent("拍照");
        bottomSheetModel.setData("拍照");
        arrayList.add(bottomSheetModel);
        com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel2 = new com.up366.mobile.common.views.bottomsheet.BottomSheetModel();
        bottomSheetModel2.setContent("相册选择");
        bottomSheetModel2.setData("相册选择");
        arrayList.add(bottomSheetModel2);
        new com.up366.mobile.common.helper.BottomSheetHelper(context).setTitle("选择方式").setContents(arrayList).setItemClickListener(new com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener() { // from class: com.up366.mobile.common.utils.PhotoSelectUtils$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener
            public final void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel3) {
                com.up366.mobile.common.utils.PhotoSelectUtils.lambda$showPictureDialog$3(runnable, context, str, z3, z, qMUIBottomSheet, bottomSheetModel3);
            }
        }).show();
    }

    static /* synthetic */ void lambda$showPictureDialog$0(boolean z, int i, java.lang.String str) {
        if (i == 0) {
            com.up366.multimedia.util.MediaHelper.getInstance().getBuilder().setTakePhotoSupportZoom(z);
            com.up366.multimedia.util.SkipUtil.toTakePhoto();
        }
    }

    static /* synthetic */ void lambda$showPictureDialog$3(java.lang.Runnable runnable, android.content.Context context, java.lang.String str, final boolean z, final boolean z2, com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel) {
        if ("拍照".equals(bottomSheetModel.getData())) {
            runnable.run();
            qMUIBottomSheet.dismiss();
        } else {
            com.up366.mobile.common.utils.PermissionUtils.checkReadStoragePermission(context, str, new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.common.utils.PhotoSelectUtils$$ExternalSyntheticLambda3
                @Override // com.up366.common.callback.ICallbackCodeInfo
                public final void onResult(int i, java.lang.String str2) {
                    com.up366.mobile.common.utils.PhotoSelectUtils.lambda$showPictureDialog$2(z, z2, i, str2);
                }
            });
        }
    }

    static /* synthetic */ void lambda$showPictureDialog$2(boolean z, boolean z2, int i, java.lang.String str) {
        if (i == 0) {
            com.up366.multimedia.util.MediaHelper.getInstance().getBuilder().setSelectPictureSupportZoom(z);
            if (z2) {
                com.up366.multimedia.util.SkipUtil.toAlbum();
            } else {
                com.up366.multimedia.util.SkipUtil.toAlbum("curViewId");
            }
        }
    }
}
