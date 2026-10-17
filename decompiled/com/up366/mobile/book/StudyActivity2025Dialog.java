package com.up366.mobile.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyActivity2025Dialog extends com.up366.mobile.book.StudyActivity {
    private android.graphics.Bitmap bitmap;
    public android.view.View content;
    public com.up366.mobile.common.views.ClipCornerLayout contentWrapper;
    public android.view.View space;

    @Override // com.up366.mobile.book.StudyActivity, com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        overridePendingTransition(com.up366.mobile.R.anim.fade_in_duration300, com.up366.mobile.R.anim.no_ani);
        super.onCreate(bundle);
        this.space = findViewById(com.up366.mobile.R.id.space);
        this.content = findViewById(2131362178);
        this.contentWrapper = (com.up366.mobile.common.views.ClipCornerLayout) findViewById(com.up366.mobile.R.id.content_wrapper);
        this.titleBar.setVisibility(8);
        initViewData();
        this.content.setAlpha(0.99f);
    }

    private void initViewData() {
        this.titleBar.setUpStatusBarLightMode(false);
        this.space.setVisibility(0);
        this.bitmap = (android.graphics.Bitmap) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync("dialog-2025-bitmap");
        this.rootView.setBackground(new android.graphics.drawable.ColorDrawable() { // from class: com.up366.mobile.book.StudyActivity2025Dialog.1
            android.graphics.Paint paint = new android.graphics.Paint();

            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void draw(android.graphics.Canvas canvas) {
                super.draw(canvas);
                if (com.up366.mobile.book.StudyActivity2025Dialog.this.bitmap != null && !com.up366.mobile.book.StudyActivity2025Dialog.this.bitmap.isRecycled()) {
                    canvas.drawBitmap(com.up366.mobile.book.StudyActivity2025Dialog.this.bitmap, 0.0f, -com.flyco.dialog.utils.StatusBarUtils.getHeight(com.up366.mobile.book.StudyActivity2025Dialog.this), this.paint);
                }
                canvas.drawColor(-1728053248);
            }
        });
        int iDp2px = com.up366.common.DpUtilsUp.dp2px(20.0f);
        this.content.setBackgroundColor(-1);
        this.contentWrapper.setRadius(iDp2px, iDp2px, 0, 0);
        this.contentWrapper.setTranslationY(iDp2px * 6);
        this.contentWrapper.setAlpha(0.0f);
        this.contentWrapper.animate().translationY(0.0f).alpha(1.0f).setInterpolator(new android.view.animation.DecelerateInterpolator()).setDuration(300L).start();
        this.space.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.up366.mobile.book.StudyActivity2025Dialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                return this.f$0.lambda$initViewData$0(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initViewData$0(android.view.View view, android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            finish();
            return true;
        }
        this.space.performClick();
        return true;
    }

    @Override // com.up366.mobile.book.StudyActivity, com.up366.mobile.common.base.BaseActivity
    public void finish() {
        int iDp2px = com.up366.common.DpUtilsUp.dp2px(20.0f);
        com.up366.mobile.common.views.ClipCornerLayout clipCornerLayout = this.contentWrapper;
        if (clipCornerLayout == null) {
            super.finish();
        } else {
            clipCornerLayout.animate().cancel();
            this.contentWrapper.animate().translationY(iDp2px * 6).alpha(0.0f).setInterpolator(new android.view.animation.DecelerateInterpolator()).setDuration(300L).setListener(new com.up366.mobile.book.StudyActivity2025Dialog.AnonymousClass2()).start();
        }
    }

    /* JADX INFO: renamed from: com.up366.mobile.book.StudyActivity2025Dialog$2, reason: invalid class name */
    class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
            com.up366.mobile.book.StudyActivity2025Dialog.this.setOnFinishListener(new java.lang.Runnable() { // from class: com.up366.mobile.book.StudyActivity2025Dialog$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAnimationEnd$0();
                }
            });
            com.up366.mobile.book.StudyActivity2025Dialog.super.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAnimationEnd$0() {
            com.up366.mobile.book.StudyActivity2025Dialog.this.overridePendingTransition(0, com.up366.mobile.R.anim.fade_out_duration300);
        }
    }

    @Override // com.up366.mobile.book.StudyActivity, com.up366.mobile.common.base.BaseActivity
    protected void onDestroy() {
        super.onDestroy();
        this.rootView.setBackground(null);
        android.graphics.Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.bitmap = null;
        }
        if (isFinishing()) {
            com.up366.mobile.common.logic.Auth.cur().cache().clear("dict-bitmap");
        }
    }

    public static void openDict(android.app.Activity activity, android.view.View view, java.lang.String str) {
        try {
            com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(str);
            if (!object.containsKey(com.up366.mobile.commonui.CommonWebViewActivity.URL)) {
                com.up366.mobile.common.utils.ToastPopupUtil.show(activity, "缺少必要数据" + str);
                return;
            }
            java.lang.String string = object.getString(com.up366.mobile.commonui.CommonWebViewActivity.URL);
            android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity2025Dialog.class);
            com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
            bookInfoStudy.setBookId(com.up366.mobile.book.helper.Tools.common2025BookId);
            bookInfoStudy.setBookType(1);
            com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo();
            openConfigInfo.openUrl = com.up366.common.global.GB.get().getServerUrl(string);
            openConfigInfo.chapterId = null;
            openConfigInfo.pageNo = -1;
            openConfigInfo.range = null;
            openConfigInfo.bookId = com.up366.mobile.book.helper.Tools.common2025BookId;
            openConfigInfo.exerciseData = str;
            openConfigInfo.packType = 9;
            intent.putExtra("cfg", openConfigInfo);
            intent.putExtra("book", bookInfoStudy);
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics.Bitmap.Config.ARGB_4444);
            view.draw(new android.graphics.Canvas(bitmapCreateBitmap));
            com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("dialog-2025-bitmap", bitmapCreateBitmap, 86400000L);
            activity.startActivity(intent);
        } catch (java.lang.Exception e) {
            com.up366.common.log.Logger.error("StudyActivity2025Dialog - openDict - error - params:" + str, e);
            com.up366.mobile.common.utils.ToastPopupUtil.show(activity, "数据解析错误");
        }
    }

    public static void openDebugPage(android.app.Activity activity, android.view.View view, java.lang.String str, java.lang.String str2) {
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity2025Dialog.class);
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        bookInfoStudy.setBookId(com.up366.mobile.book.helper.Tools.common2025BookId);
        bookInfoStudy.setBookType(1);
        bookInfoStudy.setPackType(9);
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo();
        openConfigInfo.title = str;
        openConfigInfo.openUrl = str2;
        openConfigInfo.chapterId = null;
        openConfigInfo.pageNo = -1;
        openConfigInfo.range = null;
        openConfigInfo.bookId = com.up366.mobile.book.helper.Tools.common2025BookId;
        openConfigInfo.packType = 9;
        intent.putExtra("cfg", openConfigInfo);
        intent.putExtra("book", bookInfoStudy);
        if (view != null && view.getWidth() > 0 && view.getHeight() > 0) {
            android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics.Bitmap.Config.ARGB_4444);
            view.draw(new android.graphics.Canvas(bitmapCreateBitmap));
            com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("dialog-2025-bitmap", bitmapCreateBitmap, 86400000L);
        }
        activity.startActivity(intent);
    }
}
