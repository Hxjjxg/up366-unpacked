package com.up366.mobile.course.photoanswer;

/* JADX INFO: compiled from: PhotoAnswerGuideActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/up366/mobile/course/photoanswer/PhotoAnswerGuideActivity;", "Lcom/up366/mobile/common/base/BaseActivity;", "<init>", "()V", "binding", "Lcom/up366/mobile/databinding/PhotoAnswerGuideAcivityLayoutBinding;", "taskInfo", "", "fromType", "curIndex", "", "lastClickTime", "", "getCurrentPageName", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "handleViewByIndex", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerGuideActivity extends com.up366.mobile.common.base.BaseActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.Companion INSTANCE = new com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.Companion(null);
    private com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding binding;
    private long lastClickTime;
    private java.lang.String taskInfo = "";
    private java.lang.String fromType = "";
    private int curIndex = 1;

    @kotlin.jvm.JvmStatic
    public static final void openPage(android.content.Context context, com.up366.mobile.course.photoanswer.model.ScanPaperModel scanPaperModel) {
        INSTANCE.openPage(context, scanPaperModel);
    }

    @kotlin.jvm.JvmStatic
    public static final void openPage(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
        INSTANCE.openPage(context, taskInfoV2);
    }

    @kotlin.jvm.JvmStatic
    public static final void openPage(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, java.lang.String str) {
        INSTANCE.openPage(context, taskInfoV2, str);
    }

    @Override // com.up366.mobile.common.base.BaseActivity
    public java.lang.String getCurrentPageName() {
        return "smartroom_take_picture_guide";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = (com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding) androidx.databinding.DataBindingUtil.setContentView((android.app.Activity) this, com.up366.mobile.R.layout.photo_answer_guide_acivity_layout);
        this.taskInfo = java.lang.String.valueOf(getIntent().getStringExtra(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.KEY_INTENT_DATA));
        this.fromType = java.lang.String.valueOf(getIntent().getStringExtra(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.KEY_INTENT_FROM_TYPE));
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding = this.binding;
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding2 = null;
        if (photoAnswerGuideAcivityLayoutBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            photoAnswerGuideAcivityLayoutBinding = null;
        }
        photoAnswerGuideAcivityLayoutBinding.btnNext.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.onCreate$lambda$0(this.f$0, view);
            }
        });
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding3 = this.binding;
        if (photoAnswerGuideAcivityLayoutBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            photoAnswerGuideAcivityLayoutBinding3 = null;
        }
        photoAnswerGuideAcivityLayoutBinding3.btnNextTwo.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.onCreate$lambda$1(this.f$0, view);
            }
        });
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding4 = this.binding;
        if (photoAnswerGuideAcivityLayoutBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            photoAnswerGuideAcivityLayoutBinding4 = null;
        }
        photoAnswerGuideAcivityLayoutBinding4.btnPrevTwo.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.onCreate$lambda$2(this.f$0, view);
            }
        });
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding5 = this.binding;
        if (photoAnswerGuideAcivityLayoutBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            photoAnswerGuideAcivityLayoutBinding5 = null;
        }
        photoAnswerGuideAcivityLayoutBinding5.btnPrev.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.onCreate$lambda$3(this.f$0, view);
            }
        });
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding6 = this.binding;
        if (photoAnswerGuideAcivityLayoutBinding6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            photoAnswerGuideAcivityLayoutBinding2 = photoAnswerGuideAcivityLayoutBinding6;
        }
        photoAnswerGuideAcivityLayoutBinding2.btnIKnow.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.onCreate$lambda$5(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity photoAnswerGuideActivity, android.view.View view) {
        int i = photoAnswerGuideActivity.curIndex + 1;
        photoAnswerGuideActivity.curIndex = i;
        photoAnswerGuideActivity.handleViewByIndex(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity photoAnswerGuideActivity, android.view.View view) {
        int i = photoAnswerGuideActivity.curIndex + 1;
        photoAnswerGuideActivity.curIndex = i;
        photoAnswerGuideActivity.handleViewByIndex(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity photoAnswerGuideActivity, android.view.View view) {
        int i = photoAnswerGuideActivity.curIndex - 1;
        photoAnswerGuideActivity.curIndex = i;
        photoAnswerGuideActivity.handleViewByIndex(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity photoAnswerGuideActivity, android.view.View view) {
        int i = photoAnswerGuideActivity.curIndex - 1;
        photoAnswerGuideActivity.curIndex = i;
        photoAnswerGuideActivity.handleViewByIndex(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onCreate$lambda$5(final com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity photoAnswerGuideActivity, android.view.View view) {
        if (java.lang.System.currentTimeMillis() - photoAnswerGuideActivity.lastClickTime < com.up366.asecengine.englishengine.v2.model.AsecOnlineScoringConfig.MAX_STOP_ACK_WAIT_MS) {
            return;
        }
        photoAnswerGuideActivity.lastClickTime = java.lang.System.currentTimeMillis();
        com.up366.mobile.common.utils.PreferenceUtils.putBoolean("showPhotoAnswerGuide", false);
        INSTANCE.skipPhotoAnswer((android.content.Context) photoAnswerGuideActivity, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity$$ExternalSyntheticLambda0
            @Override // com.up366.common.callback.ICallbackCode
            public final void onResult(int i) {
                com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.onCreate$lambda$5$lambda$4(this.f$0, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onCreate$lambda$5$lambda$4(com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity photoAnswerGuideActivity, int i) {
        if (i == 1) {
            com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.INSTANCE.startActivity((android.content.Context) photoAnswerGuideActivity, photoAnswerGuideActivity.taskInfo, photoAnswerGuideActivity.fromType);
        } else {
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.InitPhotoAnswerErrorNoCameraEvent());
        }
        photoAnswerGuideActivity.finish();
    }

    private final void handleViewByIndex(int curIndex) {
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding = this.binding;
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding2 = null;
        if (photoAnswerGuideAcivityLayoutBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            photoAnswerGuideAcivityLayoutBinding = null;
        }
        photoAnswerGuideAcivityLayoutBinding.btnNext.setVisibility(8);
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding3 = this.binding;
        if (photoAnswerGuideAcivityLayoutBinding3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            photoAnswerGuideAcivityLayoutBinding3 = null;
        }
        photoAnswerGuideAcivityLayoutBinding3.btnLayoutTwo.setVisibility(8);
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding4 = this.binding;
        if (photoAnswerGuideAcivityLayoutBinding4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            photoAnswerGuideAcivityLayoutBinding4 = null;
        }
        photoAnswerGuideAcivityLayoutBinding4.btnLayoutThree.setVisibility(8);
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding5 = this.binding;
        if (photoAnswerGuideAcivityLayoutBinding5 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            photoAnswerGuideAcivityLayoutBinding5 = null;
        }
        photoAnswerGuideAcivityLayoutBinding5.image1.setVisibility(8);
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding6 = this.binding;
        if (photoAnswerGuideAcivityLayoutBinding6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            photoAnswerGuideAcivityLayoutBinding6 = null;
        }
        photoAnswerGuideAcivityLayoutBinding6.image2.setVisibility(8);
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding7 = this.binding;
        if (photoAnswerGuideAcivityLayoutBinding7 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            photoAnswerGuideAcivityLayoutBinding7 = null;
        }
        photoAnswerGuideAcivityLayoutBinding7.image3.setVisibility(8);
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding8 = this.binding;
        if (photoAnswerGuideAcivityLayoutBinding8 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            photoAnswerGuideAcivityLayoutBinding8 = null;
        }
        photoAnswerGuideAcivityLayoutBinding8.image4.setVisibility(8);
        if (curIndex == 1) {
            com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding9 = this.binding;
            if (photoAnswerGuideAcivityLayoutBinding9 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                photoAnswerGuideAcivityLayoutBinding9 = null;
            }
            photoAnswerGuideAcivityLayoutBinding9.image1.setVisibility(0);
            com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding10 = this.binding;
            if (photoAnswerGuideAcivityLayoutBinding10 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                photoAnswerGuideAcivityLayoutBinding2 = photoAnswerGuideAcivityLayoutBinding10;
            }
            photoAnswerGuideAcivityLayoutBinding2.btnNext.setVisibility(0);
            return;
        }
        if (curIndex == 2) {
            com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding11 = this.binding;
            if (photoAnswerGuideAcivityLayoutBinding11 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                photoAnswerGuideAcivityLayoutBinding11 = null;
            }
            photoAnswerGuideAcivityLayoutBinding11.image2.setVisibility(0);
            com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding12 = this.binding;
            if (photoAnswerGuideAcivityLayoutBinding12 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                photoAnswerGuideAcivityLayoutBinding2 = photoAnswerGuideAcivityLayoutBinding12;
            }
            photoAnswerGuideAcivityLayoutBinding2.btnLayoutTwo.setVisibility(0);
            return;
        }
        if (curIndex == 3) {
            com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding13 = this.binding;
            if (photoAnswerGuideAcivityLayoutBinding13 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                photoAnswerGuideAcivityLayoutBinding13 = null;
            }
            photoAnswerGuideAcivityLayoutBinding13.image3.setVisibility(0);
            com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding14 = this.binding;
            if (photoAnswerGuideAcivityLayoutBinding14 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                photoAnswerGuideAcivityLayoutBinding2 = photoAnswerGuideAcivityLayoutBinding14;
            }
            photoAnswerGuideAcivityLayoutBinding2.btnLayoutTwo.setVisibility(0);
            return;
        }
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding15 = this.binding;
        if (photoAnswerGuideAcivityLayoutBinding15 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            photoAnswerGuideAcivityLayoutBinding15 = null;
        }
        photoAnswerGuideAcivityLayoutBinding15.image4.setVisibility(0);
        com.up366.mobile.databinding.PhotoAnswerGuideAcivityLayoutBinding photoAnswerGuideAcivityLayoutBinding16 = this.binding;
        if (photoAnswerGuideAcivityLayoutBinding16 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            photoAnswerGuideAcivityLayoutBinding2 = photoAnswerGuideAcivityLayoutBinding16;
        }
        photoAnswerGuideAcivityLayoutBinding2.btnLayoutThree.setVisibility(0);
    }

    /* JADX INFO: compiled from: PhotoAnswerGuideActivity.kt */
    @kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0003¨\u0006\u0011"}, d2 = {"Lcom/up366/mobile/course/photoanswer/PhotoAnswerGuideActivity$Companion;", "", "<init>", "()V", "openPage", "", "context", "Landroid/content/Context;", "taskInfoV2", "Lcom/up366/mobile/course/task/TaskInfoV2;", "fromType", "", "paperModel", "Lcom/up366/mobile/course/photoanswer/model/ScanPaperModel;", "skipPhotoAnswer", "callback", "Lcom/up366/common/callback/ICallbackCode;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final void openPage(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(taskInfoV2, "taskInfoV2");
            openPage(context, taskInfoV2, com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.FROM_TYPE_TASK_INFO);
        }

        @kotlin.jvm.JvmStatic
        public final void openPage(final android.content.Context context, final com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, final java.lang.String fromType) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(taskInfoV2, "taskInfoV2");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fromType, "fromType");
            if (com.up366.mobile.common.utils.PreferenceUtils.getBoolean("showPhotoAnswerGuide", true)) {
                android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.class);
                intent.putExtra(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.KEY_INTENT_DATA, com.alibaba.fastjson.JSON.toJSONString(taskInfoV2));
                intent.putExtra(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.KEY_INTENT_FROM_TYPE, fromType);
                context.startActivity(intent);
                return;
            }
            skipPhotoAnswer(context, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity$Companion$$ExternalSyntheticLambda0
                @Override // com.up366.common.callback.ICallbackCode
                public final void onResult(int i) {
                    com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.Companion.openPage$lambda$0(context, taskInfoV2, fromType, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void openPage$lambda$0(android.content.Context context, com.up366.mobile.course.task.TaskInfoV2 taskInfoV2, java.lang.String str, int i) {
            if (i == 1) {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.Companion companion = com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.INSTANCE;
                java.lang.String jSONString = com.alibaba.fastjson.JSON.toJSONString(taskInfoV2);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
                companion.startActivity(context, jSONString, str);
                return;
            }
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.InitPhotoAnswerErrorNoCameraEvent());
        }

        @kotlin.jvm.JvmStatic
        public final void openPage(final android.content.Context context, final com.up366.mobile.course.photoanswer.model.ScanPaperModel paperModel) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(paperModel, "paperModel");
            if (com.up366.mobile.common.utils.PreferenceUtils.getBoolean("showPhotoAnswerGuide", true)) {
                android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.class);
                intent.putExtra(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.KEY_INTENT_DATA, com.alibaba.fastjson.JSON.toJSONString(paperModel));
                intent.putExtra(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.KEY_INTENT_FROM_TYPE, paperModel.getFromType());
                context.startActivity(intent);
                return;
            }
            skipPhotoAnswer(context, new com.up366.common.callback.ICallbackCode() { // from class: com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity$Companion$$ExternalSyntheticLambda1
                @Override // com.up366.common.callback.ICallbackCode
                public final void onResult(int i) {
                    com.up366.mobile.course.photoanswer.PhotoAnswerGuideActivity.Companion.openPage$lambda$1(context, paperModel, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void openPage$lambda$1(android.content.Context context, com.up366.mobile.course.photoanswer.model.ScanPaperModel scanPaperModel, int i) {
            if (i == 1) {
                com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.Companion companion = com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity.INSTANCE;
                java.lang.String jSONString = com.alibaba.fastjson.JSON.toJSONString(scanPaperModel);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jSONString, "toJSONString(...)");
                java.lang.String fromType = scanPaperModel.getFromType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(fromType, "getFromType(...)");
                companion.startActivity(context, jSONString, fromType);
                return;
            }
            com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.InitPhotoAnswerErrorNoCameraEvent());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void skipPhotoAnswer(android.content.Context context, com.up366.common.callback.ICallbackCode callback) {
            callback.onResult(context.getPackageManager().hasSystemFeature("android.hardware.camera") ? 1 : 0);
        }
    }
}
