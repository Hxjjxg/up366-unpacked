package com.up366.mobile.book;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StudyActivityDialog extends com.up366.mobile.book.StudyActivity {
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
        this.bitmap = (android.graphics.Bitmap) com.up366.mobile.common.logic.Auth.cur().cache().loadMemorySync("dict-bitmap");
        this.rootView.setBackground(new android.graphics.drawable.ColorDrawable() { // from class: com.up366.mobile.book.StudyActivityDialog.1
            android.graphics.Paint paint = new android.graphics.Paint();

            @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
            public void draw(android.graphics.Canvas canvas) {
                super.draw(canvas);
                if (com.up366.mobile.book.StudyActivityDialog.this.bitmap != null && !com.up366.mobile.book.StudyActivityDialog.this.bitmap.isRecycled()) {
                    canvas.drawBitmap(com.up366.mobile.book.StudyActivityDialog.this.bitmap, 0.0f, -com.flyco.dialog.utils.StatusBarUtils.getHeight(com.up366.mobile.book.StudyActivityDialog.this), this.paint);
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
        this.space.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.up366.mobile.book.StudyActivityDialog$$ExternalSyntheticLambda0
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
            this.contentWrapper.animate().translationY(iDp2px * 6).alpha(0.0f).setInterpolator(new android.view.animation.DecelerateInterpolator()).setDuration(300L).setListener(new com.up366.mobile.book.StudyActivityDialog.AnonymousClass2()).start();
        }
    }

    /* JADX INFO: renamed from: com.up366.mobile.book.StudyActivityDialog$2, reason: invalid class name */
    class AnonymousClass2 extends android.animation.AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            super.onAnimationEnd(animator);
            com.up366.mobile.book.StudyActivityDialog.this.setOnFinishListener(new java.lang.Runnable() { // from class: com.up366.mobile.book.StudyActivityDialog$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAnimationEnd$0();
                }
            });
            com.up366.mobile.book.StudyActivityDialog.super.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAnimationEnd$0() {
            com.up366.mobile.book.StudyActivityDialog.this.overridePendingTransition(0, com.up366.mobile.R.anim.fade_out_duration300);
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
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.book.StudyActivityDialog.class);
        intent.putExtra("exercise_type", com.up366.mobile.common.onlinelog.OpLogData.ExerciseType.TX_DICT);
        intent.putExtra(com.up366.greendao.ExerciseDataDao.TABLENAME, str);
        android.graphics.Bitmap bitmapCreateBitmap = android.graphics.Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics.Bitmap.Config.ARGB_4444);
        view.draw(new android.graphics.Canvas(bitmapCreateBitmap));
        com.up366.mobile.common.logic.Auth.cur().cache().putMemorySync("dict-bitmap", bitmapCreateBitmap, 86400000L);
        activity.startActivity(intent);
    }
}
