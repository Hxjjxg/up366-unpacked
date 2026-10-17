package com.up366.mobile.main;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PromotionDiagramHelper {
    public long duration;
    public java.lang.String imagePath;
    private com.alibaba.fastjson.JSONObject promotionDiagramConfig;
    public boolean show;
    private com.up366.mobile.common.utils.CountDownTimer timer;
    private final java.util.List<java.lang.Runnable> waitingTasks = new java.util.ArrayList();
    private boolean hasDone = false;
    private boolean hasShow = false;
    private boolean hasInit = false;

    public void init() {
        this.show = com.up366.mobile.common.logic.Auth.cur().config().isShowPromotionDiagram();
        this.imagePath = com.up366.mobile.common.logic.Auth.cur().config().getPromotionDiagramImagePath();
        this.duration = com.up366.mobile.common.logic.Auth.cur().config().getPromotionDiagramShowDuration();
        this.promotionDiagramConfig = com.up366.mobile.common.logic.Auth.cur().config().getPromotionDiagramConfig();
        this.hasInit = true;
        onResume();
    }

    public void showPromotionDiagram(final android.view.View view, final android.widget.ImageView imageView, final android.view.View view2, final com.up366.mobile.common.views.ShapeableTextView shapeableTextView, com.up366.mobile.common.views.ShapeableTextView shapeableTextView2) {
        this.hasShow = true;
        view2.setVisibility(0);
        shapeableTextView.setVisibility(0);
        shapeableTextView2.setVisibility(0);
        com.bumptech.glide.Glide.with(imageView.getContext()).load(this.imagePath).apply(new com.bumptech.glide.request.RequestOptions()).into(imageView);
        shapeableTextView.setText(com.up366.common.StringUtils.format("%ds", java.lang.Long.valueOf(((this.duration - 1) / 1000) + 1)));
        com.up366.mobile.common.utils.CountDownTimer countDownTimer = new com.up366.mobile.common.utils.CountDownTimer(this.duration, 1000L) { // from class: com.up366.mobile.main.PromotionDiagramHelper.1
            @Override // com.up366.mobile.common.utils.CountDownTimer
            public void onTick(long j) {
                shapeableTextView.setText(com.up366.common.StringUtils.format("%ds", java.lang.Long.valueOf((j / 1000) + 1)));
            }

            @Override // com.up366.mobile.common.utils.CountDownTimer
            public void onFinish() {
                view.setEnabled(false);
                com.up366.mobile.main.PromotionDiagramHelper.this.hideMaskLayout(view2, imageView);
            }
        };
        this.timer = countDownTimer;
        countDownTimer.start();
        com.alibaba.fastjson.JSONObject jSONObject = this.promotionDiagramConfig;
        if (jSONObject != null) {
            final java.lang.String string = jSONObject.getString("title");
            if (!android.text.TextUtils.isEmpty(string)) {
                com.up366.mobile.common.onlinelog.OpLog.report("promotion", (androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject>) new androidx.core.util.Consumer() { // from class: com.up366.mobile.main.PromotionDiagramHelper$$ExternalSyntheticLambda3
                    public final void accept(java.lang.Object obj) {
                        com.up366.mobile.main.PromotionDiagramHelper.lambda$showPromotionDiagram$0(string, (com.alibaba.fastjson.JSONObject) obj);
                    }
                });
            }
        }
        shapeableTextView2.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.PromotionDiagramHelper$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view3) {
                this.f$0.lambda$showPromotionDiagram$1(view3);
            }
        });
        final android.app.Activity activity = (android.app.Activity) imageView.getContext();
        view.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.PromotionDiagramHelper$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view3) {
                this.f$0.lambda$showPromotionDiagram$4(activity, view3);
            }
        });
    }

    static /* synthetic */ void lambda$showPromotionDiagram$0(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) {
        jSONObject.put("type", "show");
        jSONObject.put("title", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPromotionDiagram$1(android.view.View view) {
        this.timer.cancel();
        this.timer.onFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPromotionDiagram$4(android.app.Activity activity, android.view.View view) {
        view.setEnabled(false);
        com.alibaba.fastjson.JSONObject jSONObject = this.promotionDiagramConfig;
        if (jSONObject == null) {
            view.setEnabled(true);
            return;
        }
        final java.lang.String string = jSONObject.getString("title");
        if (!android.text.TextUtils.isEmpty(string)) {
            com.up366.mobile.common.onlinelog.OpLog.report("promotion", (androidx.core.util.Consumer<com.alibaba.fastjson.JSONObject>) new androidx.core.util.Consumer() { // from class: com.up366.mobile.main.PromotionDiagramHelper$$ExternalSyntheticLambda1
                public final void accept(java.lang.Object obj) {
                    com.up366.mobile.main.PromotionDiagramHelper.lambda$showPromotionDiagram$2(string, (com.alibaba.fastjson.JSONObject) obj);
                }
            });
        }
        java.lang.String string2 = this.promotionDiagramConfig.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.BOOK_ID);
        java.lang.String string3 = this.promotionDiagramConfig.getString(com.up366.mobile.common.onlinelog.OpLogData.Behavior.TASK_ID);
        int intValue = this.promotionDiagramConfig.containsKey("bookType") ? this.promotionDiagramConfig.getIntValue("bookType") : 1;
        com.up366.mobile.book.model.BookInfoStudy bookInfoStudy = new com.up366.mobile.book.model.BookInfoStudy();
        bookInfoStudy.setBookId(string2);
        bookInfoStudy.setBookType(intValue);
        this.timer.pause();
        view.postDelayed(new java.lang.Runnable() { // from class: com.up366.mobile.main.PromotionDiagramHelper$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showPromotionDiagram$3();
            }
        }, 300L);
        bookInfoStudy.setCourseId(-1);
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo();
        openConfigInfo.chapterId = null;
        openConfigInfo.pageNo = -1;
        openConfigInfo.range = null;
        openConfigInfo.taskId = string3;
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.up366.mobile.book.StudyActivity.class);
        intent.putExtra("cfg", openConfigInfo);
        intent.putExtra("book", bookInfoStudy);
        activity.startActivity(intent);
    }

    static /* synthetic */ void lambda$showPromotionDiagram$2(java.lang.String str, com.alibaba.fastjson.JSONObject jSONObject) {
        jSONObject.put("type", "click");
        jSONObject.put("title", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPromotionDiagram$3() {
        this.timer.onFinish();
    }

    public void hideMaskLayout(final android.view.View view, final android.widget.ImageView imageView) {
        view.animate().alpha(0.0f).setDuration(200L).withEndAction(new java.lang.Runnable() { // from class: com.up366.mobile.main.PromotionDiagramHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hideMaskLayout$5(view, imageView);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideMaskLayout$5(android.view.View view, android.widget.ImageView imageView) {
        view.setAlpha(1.0f);
        imageView.setBackground(null);
        imageView.setImageBitmap(null);
        view.setVisibility(4);
        this.hasDone = true;
        onResume();
    }

    public void onResume() {
        if (this.hasDone && this.hasInit) {
            for (java.lang.Runnable runnable : this.waitingTasks) {
                java.util.Objects.requireNonNull(runnable);
                com.up366.common.task.TaskUtils.postMainTask(new com.up366.mobile.book.StudyActivity$$ExternalSyntheticLambda2(runnable));
            }
            this.waitingTasks.clear();
        }
    }

    public void onDestroy() {
        com.up366.mobile.common.utils.CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void waitTask(java.lang.Runnable runnable) {
        if (this.hasDone || (!this.hasShow && this.hasInit)) {
            runnable.run();
        } else {
            this.waitingTasks.add(runnable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postDialogQueueTask(android.content.Context context, java.lang.Runnable runnable) {
        if (context instanceof com.up366.mobile.main.MainActivity) {
            ((com.up366.mobile.main.MainActivity) context).promotionDiagramHelper.waitTask(runnable);
        } else {
            runnable.run();
        }
    }
}
