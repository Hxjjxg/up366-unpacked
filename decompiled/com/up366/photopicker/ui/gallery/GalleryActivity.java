package com.up366.photopicker.ui.gallery;

/* JADX INFO: compiled from: GalleryActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J-\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00142\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\"2\u0006\u0010#\u001a\u00020$H\u0016¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0017H\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/up366/photopicker/ui/gallery/GalleryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "btnBack", "Landroid/widget/ImageButton;", "btnCancel", "Landroid/widget/TextView;", "btnConfirm", "Landroid/widget/Button;", "configJson", "", "galleryRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "isMultiSelect", "", "photoList", "", "Lcom/up366/photopicker/ui/gallery/PhotoItem;", "selectedIndices", "", "", "selectedPhotoPaths", "checkStoragePermissionAndLoad", "", "finishWithLaunchFailure", "result", "Lcom/up366/photopicker/PhotoPickerLaunchResult;", "loadPhotos", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "returnPhotos", "returnSinglePhoto", com.up366.asecengine.englishengine.v2.model.AsecParagraphScoringConfig.DATA_TYPE_PATH, "Companion", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GalleryActivity extends androidx.appcompat.app.AppCompatActivity {
    private static final int REQUEST_STORAGE = 2001;
    private android.widget.ImageButton btnBack;
    private android.widget.TextView btnCancel;
    private android.widget.Button btnConfirm;
    private java.lang.String configJson;
    private androidx.recyclerview.widget.RecyclerView galleryRecycler;
    private final java.util.List<com.up366.photopicker.ui.gallery.PhotoItem> photoList = new java.util.ArrayList();
    private final java.util.Set<java.lang.Integer> selectedIndices = new java.util.LinkedHashSet();
    private final java.util.List<java.lang.String> selectedPhotoPaths = new java.util.ArrayList();
    private boolean isMultiSelect = true;

    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.up366.photopicker.R.layout.up366_photo_picker_activity_gallery);
        this.configJson = getIntent().getStringExtra("config");
        this.isMultiSelect = getIntent().getBooleanExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_GALLERY_MULTI_SELECT, true);
        com.up366.common.log.Logger.info("GalleryActivity onCreate, isMultiSelect=" + this.isMultiSelect);
        androidx.recyclerview.widget.RecyclerView recyclerViewFindViewById = findViewById(com.up366.photopicker.R.id.galleryRecycler);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(R.id.galleryRecycler)");
        this.galleryRecycler = recyclerViewFindViewById;
        android.view.View viewFindViewById = findViewById(com.up366.photopicker.R.id.btnBack);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.btnBack)");
        this.btnBack = (android.widget.ImageButton) viewFindViewById;
        android.view.View viewFindViewById2 = findViewById(com.up366.photopicker.R.id.btnCancel);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.btnCancel)");
        this.btnCancel = (android.widget.TextView) viewFindViewById2;
        android.view.View viewFindViewById3 = findViewById(com.up366.photopicker.R.id.btnConfirm);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.btnConfirm)");
        this.btnConfirm = (android.widget.Button) viewFindViewById3;
        android.widget.ImageButton imageButton = this.btnBack;
        android.widget.Button button = null;
        if (imageButton == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            imageButton = null;
        }
        com.up366.photopicker.ui.SafeClickKt.enablePressedAlphaFeedback$default(imageButton, 0.0f, 0.0f, 3, null);
        android.widget.TextView textView = this.btnCancel;
        if (textView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
            textView = null;
        }
        com.up366.photopicker.ui.SafeClickKt.enablePressedAlphaFeedback$default(textView, 0.0f, 0.0f, 3, null);
        android.widget.Button button2 = this.btnConfirm;
        if (button2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            button2 = null;
        }
        com.up366.photopicker.ui.SafeClickKt.enablePressedAlphaFeedback$default(button2, 0.0f, 0.0f, 3, null);
        android.widget.ImageButton imageButton2 = this.btnBack;
        if (imageButton2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnBack");
            imageButton2 = null;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(imageButton2, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.gallery.GalleryActivity.onCreate.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, com.igexin.push.g.q.f);
                com.up366.photopicker.ui.gallery.GalleryActivity.this.finish();
            }
        }, 1, null);
        android.widget.TextView textView2 = this.btnCancel;
        if (textView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
            textView2 = null;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(textView2, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.gallery.GalleryActivity.onCreate.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, com.igexin.push.g.q.f);
                com.up366.photopicker.ui.gallery.GalleryActivity.this.finish();
            }
        }, 1, null);
        android.widget.Button button3 = this.btnConfirm;
        if (button3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            button3 = null;
        }
        com.up366.photopicker.ui.SafeClickKt.setSafeClickListener$default(button3, 0L, new kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit>() { // from class: com.up366.photopicker.ui.gallery.GalleryActivity.onCreate.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke((android.view.View) obj);
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(android.view.View view) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, com.igexin.push.g.q.f);
                com.up366.photopicker.ui.gallery.GalleryActivity.this.returnPhotos();
            }
        }, 1, null);
        android.widget.Button button4 = this.btnConfirm;
        if (button4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
        } else {
            button = button4;
        }
        button.setVisibility(this.isMultiSelect ? 0 : 8);
        checkStoragePermissionAndLoad();
    }

    private final void checkStoragePermissionAndLoad() {
        java.lang.String[] strArr;
        com.up366.common.log.Logger.info("GalleryActivity 检查相册权限");
        if (android.os.Build.VERSION.SDK_INT >= 33) {
            strArr = new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.READ_MEDIA_IMAGES};
        } else {
            strArr = new java.lang.String[]{com.up366.mobile.common.utils.permissions.Permission.READ_EXTERNAL_STORAGE};
        }
        for (java.lang.String str : strArr) {
            if (checkSelfPermission(str) != 0) {
                com.up366.common.log.Logger.info("GalleryActivity 请求相册权限");
                requestPermissions(strArr, REQUEST_STORAGE);
                return;
            }
        }
        com.up366.common.log.Logger.info("GalleryActivity 相册权限已授予");
        loadPhotos();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int requestCode, java.lang.String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(permissions, "permissions");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_STORAGE) {
            if (!(grantResults.length == 0)) {
                for (int i : grantResults) {
                    if (i == 0) {
                    }
                }
                com.up366.common.log.Logger.info("GalleryActivity 相册权限申请通过");
                loadPhotos();
                return;
            }
        }
        com.up366.common.log.Logger.error("GalleryActivity 相册权限被拒绝");
        finishWithLaunchFailure(new com.up366.photopicker.PhotoPickerLaunchResult(false, com.up366.photopicker.PhotoPickerErrorCode.PERMISSION_DENIED, com.up366.photopicker.PhotoPicker.getPermissionDeniedMessage((android.content.Context) this)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void finishWithLaunchFailure(com.up366.photopicker.PhotoPickerLaunchResult result) {
        com.up366.common.log.Logger.error("GalleryActivity 启动失败 errorCode=" + result.getErrorCode() + " message=" + result.getErrorMessage());
        android.widget.Toast.makeText((android.content.Context) this, result.getErrorMessage(), 0).show();
        setResult(0, com.up366.photopicker.PhotoPicker.INSTANCE.createLaunchResultIntent$photopicker_release(result));
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void loadPhotos() {
        com.up366.common.log.Logger.info("GalleryActivity 开始加载系统相册图片");
        android.database.Cursor cursorQuery = getContentResolver().query(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new java.lang.String[]{"_id", "_display_name", "_data"}, null, null, "date_added DESC");
        android.widget.Button button = null;
        if (cursorQuery != null) {
            android.database.Cursor cursor = cursorQuery;
            try {
                android.database.Cursor cursor2 = cursor;
                int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("_id");
                int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow("_display_name");
                int columnIndexOrThrow3 = cursor2.getColumnIndexOrThrow("_data");
                while (cursor2.moveToNext()) {
                    long j = cursor2.getLong(columnIndexOrThrow);
                    java.lang.String string = cursor2.getString(columnIndexOrThrow2);
                    java.lang.String string2 = cursor2.getString(columnIndexOrThrow3);
                    android.net.Uri uriWithAppendedId = android.content.ContentUris.withAppendedId(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, j);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(MediaStor…EXTERNAL_CONTENT_URI, id)");
                    java.util.List<com.up366.photopicker.ui.gallery.PhotoItem> list = this.photoList;
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "name");
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string2, "data");
                    list.add(new com.up366.photopicker.ui.gallery.PhotoItem(j, string, string2, uriWithAppendedId));
                }
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
                kotlin.io.CloseableKt.closeFinally(cursor, (java.lang.Throwable) null);
            } finally {
            }
        }
        com.up366.common.log.Logger.info("GalleryActivity 相册图片加载完成 count=" + this.photoList.size());
        int i = getResources().getConfiguration().screenWidthDp;
        boolean z = i >= 600;
        int i2 = (int) (5 * getResources().getDisplayMetrics().density);
        int iCoerceIn = kotlin.ranges.RangesKt.coerceIn(i / (z ? 110 : 92), 4, z ? 8 : 4);
        androidx.recyclerview.widget.RecyclerView recyclerView = this.galleryRecycler;
        if (recyclerView == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("galleryRecycler");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager((android.content.Context) this, iCoerceIn));
        androidx.recyclerview.widget.RecyclerView recyclerView2 = this.galleryRecycler;
        if (recyclerView2 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("galleryRecycler");
            recyclerView2 = null;
        }
        recyclerView2.setPadding(0, i2, 0, i2);
        androidx.recyclerview.widget.RecyclerView recyclerView3 = this.galleryRecycler;
        if (recyclerView3 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("galleryRecycler");
            recyclerView3 = null;
        }
        recyclerView3.setClipToPadding(false);
        androidx.recyclerview.widget.RecyclerView recyclerView4 = this.galleryRecycler;
        if (recyclerView4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("galleryRecycler");
            recyclerView4 = null;
        }
        recyclerView4.addItemDecoration(new com.up366.photopicker.ui.gallery.GridSpacingItemDecoration(iCoerceIn, i2, false));
        if (z) {
            int i3 = (int) (12 * getResources().getDisplayMetrics().density);
            androidx.recyclerview.widget.RecyclerView recyclerView5 = this.galleryRecycler;
            if (recyclerView5 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("galleryRecycler");
                recyclerView5 = null;
            }
            recyclerView5.setPadding(i3, i2, i3, i2);
            android.widget.Button button2 = this.btnConfirm;
            if (button2 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
                button2 = null;
            }
            android.view.ViewGroup.LayoutParams layoutParams = button2.getLayoutParams();
            kotlin.jvm.internal.Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            android.view.ViewGroup.LayoutParams layoutParams2 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams;
            int i4 = (int) ((i >= 840 ? 180 : 96) * getResources().getDisplayMetrics().density);
            layoutParams2.setMarginStart(i4);
            layoutParams2.setMarginEnd(i4);
            android.widget.Button button3 = this.btnConfirm;
            if (button3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
                button3 = null;
            }
            button3.setLayoutParams(layoutParams2);
        }
        com.up366.photopicker.ui.gallery.GalleryRecyclerAdapter galleryRecyclerAdapter = new com.up366.photopicker.ui.gallery.GalleryRecyclerAdapter(this.photoList, new java.util.LinkedHashSet(), this.isMultiSelect, new kotlin.jvm.functions.Function2<java.lang.Integer, java.lang.Boolean, kotlin.Unit>() { // from class: com.up366.photopicker.ui.gallery.GalleryActivity$loadPhotos$adapter$1
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                invoke(((java.lang.Number) obj).intValue(), ((java.lang.Boolean) obj2).booleanValue());
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(int i5, boolean z2) {
                java.lang.String string3;
                if (z2) {
                    this.this$0.selectedIndices.add(java.lang.Integer.valueOf(i5));
                    this.this$0.selectedPhotoPaths.add(((com.up366.photopicker.ui.gallery.PhotoItem) this.this$0.photoList.get(i5)).getData());
                } else {
                    this.this$0.selectedIndices.remove(java.lang.Integer.valueOf(i5));
                    this.this$0.selectedPhotoPaths.remove(((com.up366.photopicker.ui.gallery.PhotoItem) this.this$0.photoList.get(i5)).getData());
                }
                com.up366.common.log.Logger.info("GalleryActivity 选择状态变化 count=" + this.this$0.selectedPhotoPaths.size());
                android.widget.Button button4 = this.this$0.btnConfirm;
                android.widget.Button button5 = null;
                if (button4 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
                    button4 = null;
                }
                button4.setEnabled(!this.this$0.selectedPhotoPaths.isEmpty());
                android.widget.Button button6 = this.this$0.btnConfirm;
                if (button6 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
                } else {
                    button5 = button6;
                }
                if (!this.this$0.selectedPhotoPaths.isEmpty()) {
                    string3 = this.this$0.getString(com.up366.photopicker.R.string.up366_photo_picker_confirm) + " (" + this.this$0.selectedPhotoPaths.size() + ')';
                } else {
                    string3 = this.this$0.getString(com.up366.photopicker.R.string.up366_photo_picker_confirm);
                }
                button5.setText(string3);
            }
        }, new kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit>() { // from class: com.up366.photopicker.ui.gallery.GalleryActivity$loadPhotos$adapter$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object obj) {
                invoke(((java.lang.Number) obj).intValue());
                return kotlin.Unit.INSTANCE;
            }

            public final void invoke(int i5) {
                if (this.this$0.isMultiSelect) {
                    return;
                }
                com.up366.photopicker.ui.gallery.GalleryActivity galleryActivity = this.this$0;
                galleryActivity.returnSinglePhoto(((com.up366.photopicker.ui.gallery.PhotoItem) galleryActivity.photoList.get(i5)).getData());
            }
        });
        androidx.recyclerview.widget.RecyclerView recyclerView6 = this.galleryRecycler;
        if (recyclerView6 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("galleryRecycler");
            recyclerView6 = null;
        }
        recyclerView6.setAdapter(galleryRecyclerAdapter);
        android.widget.Button button4 = this.btnConfirm;
        if (button4 == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
        } else {
            button = button4;
        }
        button.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void returnSinglePhoto(java.lang.String path) {
        com.up366.common.log.Logger.info("GalleryActivity 返回单张图片 path=" + path);
        android.content.Intent intent = new android.content.Intent();
        com.up366.photopicker.PhotoPicker.INSTANCE.putResults$photopicker_release(intent, com.up366.photopicker.PhotoPicker.buildPhotoResults$photopicker_release$default(com.up366.photopicker.PhotoPicker.INSTANCE, kotlin.collections.CollectionsKt.listOf(path), false, 2, null));
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void returnPhotos() {
        com.up366.common.log.Logger.info("GalleryActivity 返回多张图片 count=" + this.selectedPhotoPaths.size());
        android.content.Intent intent = new android.content.Intent();
        com.up366.photopicker.PhotoPicker.INSTANCE.putResults$photopicker_release(intent, com.up366.photopicker.PhotoPicker.buildPhotoResults$photopicker_release$default(com.up366.photopicker.PhotoPicker.INSTANCE, this.selectedPhotoPaths, false, 2, null));
        setResult(-1, intent);
        finish();
    }
}
