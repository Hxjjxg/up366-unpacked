package com.up366.mobile.course.photoanswer;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class PhotoAnswerOpenHelper {
    public static void openScanPaper(final android.content.Context context, final java.lang.String str) {
        com.up366.mobile.common.utils.PermissionUtils.checkPermission(context, new java.lang.String[]{"相机权限"}, new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.CAMERA}, com.up366.mobile.common.utils.ViewUtil.getString(com.up366.mobile.R.string.permission_camera), new com.up366.common.callback.ICallbackCodeInfo() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerOpenHelper$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCodeInfo
            public final void onResult(int i, java.lang.String str2) {
                com.up366.mobile.course.photoanswer.PhotoAnswerOpenHelper.lambda$openScanPaper$0(str, context, i, str2);
            }
        });
    }

    static /* synthetic */ void lambda$openScanPaper$0(java.lang.String str, android.content.Context context, int i, java.lang.String str2) {
        if (i == 0) {
            com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.openPage(context, (com.up366.mobile.course.task.TaskInfoV2) com.alibaba.fastjson.JSON.parseObject(str, com.up366.mobile.course.task.TaskInfoV2.class));
        }
    }
}
