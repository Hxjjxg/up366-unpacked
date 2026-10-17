package com.up366.mobile.course.photoanswer.dialog;

/* JADX INFO: compiled from: TestDialogHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/TestDialogHelper;", "", "<init>", "()V", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TestDialogHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.Companion INSTANCE = new com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.Companion(null);
    private static com.up366.mobile.course.photoanswer.dialog.DialogType curType = com.up366.mobile.course.photoanswer.dialog.DialogType.NET_4G_DIALOG;
    private static final com.up366.mobile.course.photoanswer.dialog.TestDialogHelper$Companion$dialogCallback$1 dialogCallback = new com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback() { // from class: com.up366.mobile.course.photoanswer.dialog.TestDialogHelper$Companion$dialogCallback$1
        @Override // com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.IDialogCallback
        public void onCallback(int code, java.lang.Object info) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(info, "info");
            com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.INSTANCE.testShowDialog(com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.INSTANCE.nextDialog());
        }
    };

    /* JADX INFO: compiled from: TestDialogHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\r"}, d2 = {"Lcom/up366/mobile/course/photoanswer/dialog/TestDialogHelper$Companion;", "", "<init>", "()V", "curType", "Lcom/up366/mobile/course/photoanswer/dialog/DialogType;", "dialogCallback", "com/up366/mobile/course/photoanswer/dialog/TestDialogHelper$Companion$dialogCallback$1", "Lcom/up366/mobile/course/photoanswer/dialog/TestDialogHelper$Companion$dialogCallback$1;", "nextDialog", "testShowDialog", "", "type", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final com.up366.mobile.course.photoanswer.dialog.DialogType nextDialog() {
            if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.NO_ANSWER_SHEET) {
                if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.FETCH_DATA_NET_ERROR_DIALOG) {
                    if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.NET_4G_DIALOG) {
                        if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_MATCH_FIRST_PAPER_CODE) {
                            if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_MATCH_SHEET) {
                                if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.NO_PAPER_CODE_DIALOG) {
                                    if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_NEW_ANSWER_SHEET) {
                                        if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_REGISTER) {
                                            if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.TOO_MORE_ANSWER_SHEET) {
                                                if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.TOO_BLUR) {
                                                    if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.UPDATE_PAPER_NUMBER) {
                                                        if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.SUBMIT_ANSWER_TIP_DIALOG) {
                                                            if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.SUBMIT_ANSWER_ERROR_DIALOG) {
                                                                if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.SUBMIT_ANSWER_UPLOADING_DIALOG) {
                                                                    if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.LOOK_SCORE_TIP_DIALOG) {
                                                                        if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.COMMON_ERROR_DIALOG) {
                                                                            if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType != com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_FULL_DIALOG) {
                                                                                if (com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType == com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_FULL_BLOCKS_DIALOG) {
                                                                                    return com.up366.mobile.course.photoanswer.dialog.DialogType.EXIT_ACTIVITY_DIALOG;
                                                                                }
                                                                                return com.up366.mobile.course.photoanswer.dialog.DialogType.NO_ANSWER_SHEET;
                                                                            }
                                                                            return com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_FULL_BLOCKS_DIALOG;
                                                                        }
                                                                        return com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_FULL_DIALOG;
                                                                    }
                                                                    return com.up366.mobile.course.photoanswer.dialog.DialogType.COMMON_ERROR_DIALOG;
                                                                }
                                                                return com.up366.mobile.course.photoanswer.dialog.DialogType.LOOK_SCORE_TIP_DIALOG;
                                                            }
                                                            return com.up366.mobile.course.photoanswer.dialog.DialogType.SUBMIT_ANSWER_UPLOADING_DIALOG;
                                                        }
                                                        return com.up366.mobile.course.photoanswer.dialog.DialogType.SUBMIT_ANSWER_ERROR_DIALOG;
                                                    }
                                                    return com.up366.mobile.course.photoanswer.dialog.DialogType.SUBMIT_ANSWER_TIP_DIALOG;
                                                }
                                                return com.up366.mobile.course.photoanswer.dialog.DialogType.UPDATE_PAPER_NUMBER;
                                            }
                                            return com.up366.mobile.course.photoanswer.dialog.DialogType.TOO_BLUR;
                                        }
                                        return com.up366.mobile.course.photoanswer.dialog.DialogType.TOO_MORE_ANSWER_SHEET;
                                    }
                                    return com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_REGISTER;
                                }
                                return com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_NEW_ANSWER_SHEET;
                            }
                            return com.up366.mobile.course.photoanswer.dialog.DialogType.NO_PAPER_CODE_DIALOG;
                        }
                        return com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_MATCH_SHEET;
                    }
                    return com.up366.mobile.course.photoanswer.dialog.DialogType.NOT_MATCH_FIRST_PAPER_CODE;
                }
                return com.up366.mobile.course.photoanswer.dialog.DialogType.NET_4G_DIALOG;
            }
            return com.up366.mobile.course.photoanswer.dialog.DialogType.FETCH_DATA_NET_ERROR_DIALOG;
        }

        public static /* synthetic */ void testShowDialog$default(com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.Companion companion, com.up366.mobile.course.photoanswer.dialog.DialogType dialogType, int i, java.lang.Object obj) {
            if ((i & 1) != 0) {
                dialogType = com.up366.mobile.course.photoanswer.dialog.DialogType.NO_ANSWER_SHEET;
            }
            companion.testShowDialog(dialogType);
        }

        public final void testShowDialog(com.up366.mobile.course.photoanswer.dialog.DialogType type) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
            com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.curType = type;
            com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.testShowDialog$default(com.up366.mobile.course.photoanswer.dialog.Dialog2Helper.INSTANCE, type, com.up366.mobile.course.photoanswer.dialog.TestDialogHelper.dialogCallback, null, 4, null);
        }
    }
}
