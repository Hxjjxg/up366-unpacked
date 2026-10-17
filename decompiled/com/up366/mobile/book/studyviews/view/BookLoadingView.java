package com.up366.mobile.book.studyviews.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BookLoadingView extends android.widget.FrameLayout {
    public static final int TYPE_DOWNLOAD = 7;
    public static final int TYPE_DOWNLOAD_CANCLE = 6;
    public static final int TYPE_DOWNLOAD_FAILED = 4;
    public static final int TYPE_DOWNLOAD_PROGRESS = 2;
    public static final int TYPE_DOWNLOAD_SUCCESS = 5;
    public static final int TYPE_DOWNLOAD_UNZIP = 3;
    public static final int TYPE_DOWNLOAD_UPDATE = 1;
    public static final int TYPE_DOWNLOAD_VALID_FAILD = 8;
    public static final int TYPE_LOADING = 0;
    public static final int TYPE_LOAD_ERROR = -1;
    public static final int TYPE_LOAD_URL_ERROR = -2;
    private final com.up366.mobile.databinding.ContentDownloadFragmentLayoutBinding b;
    private int currentType;
    private final java.lang.Runnable loadingMonitor;
    private final java.lang.ref.WeakReference<com.up366.mobile.book.studyviews.view.BookLoadingView> weakView;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        com.up366.mobile.book.studyviews.view.BookLoadingView bookLoadingView = this.weakView.get();
        if (bookLoadingView != null && bookLoadingView.getVisibility() == 0 && bookLoadingView.isAttachedToWindow()) {
            com.up366.common.log.Logger.error(com.up366.mobile.book.helper.Tools.studyAlarmLog(com.up366.mobile.book.helper.Tools.AlarmCode._004003001));
        }
    }

    public BookLoadingView(android.content.Context context) {
        this(context, null);
    }

    public BookLoadingView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BookLoadingView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentType = 0;
        this.weakView = new java.lang.ref.WeakReference<>(this);
        this.loadingMonitor = new java.lang.Runnable() { // from class: com.up366.mobile.book.studyviews.view.BookLoadingView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        setClickable(true);
        com.up366.mobile.databinding.ContentDownloadFragmentLayoutBinding contentDownloadFragmentLayoutBinding = (com.up366.mobile.databinding.ContentDownloadFragmentLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.content_download_fragment_layout, this, true);
        this.b = contentDownloadFragmentLayoutBinding;
        contentDownloadFragmentLayoutBinding.titleBar.setVisibility(8);
        contentDownloadFragmentLayoutBinding.tip.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        contentDownloadFragmentLayoutBinding.progress.setOnAnimPercentUpdateListener(new com.up366.mobile.common.views.DownloadProgressView.IOnAnimProgressUpdateListener() { // from class: com.up366.mobile.book.studyviews.view.BookLoadingView$$ExternalSyntheticLambda1
            @Override // com.up366.mobile.common.views.DownloadProgressView.IOnAnimProgressUpdateListener
            public final void onUpdate(int i2) {
                this.f$0.lambda$new$1(i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(int i) {
        if (i < 0) {
            this.b.percentText.setVisibility(4);
        } else {
            this.b.percentText.setVisibility(0);
            this.b.percentText.setText(com.up366.common.StringUtils.format("%d%%", java.lang.Integer.valueOf(i)));
        }
    }

    @Override // android.view.View
    public android.view.ViewGroup.LayoutParams getLayoutParams() {
        android.view.ViewGroup.LayoutParams layoutParams = super.getLayoutParams();
        return layoutParams == null ? new android.view.ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    public void setShowTitleBar(boolean z) {
        this.b.titleBar.setVisibility(z ? 0 : 8);
    }

    public void setTitle(java.lang.String str) {
        this.b.titleBar.setTitle(str);
    }

    public void setData(int i) {
        setData(i, 0, null, null);
    }

    public void setData(int i, java.lang.String str, android.view.View.OnClickListener onClickListener) {
        setData(i, 0, str, onClickListener);
    }

    public void setData(int i, int i2, java.lang.String str, android.view.View.OnClickListener onClickListener) {
        setData(i, i2, str, 0, onClickListener);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void setData(int i, int i2, java.lang.String str, int i3, android.view.View.OnClickListener onClickListener) {
        com.up366.mobile.book.helper.ContentDownloadHelper contentDownloadHelper = getContext() instanceof com.up366.mobile.book.StudyActivity ? ((com.up366.mobile.book.StudyActivity) getContext()).contentDownloadHelper : null;
        com.up366.common.download.DownloadInfo currentDownloadInfo = contentDownloadHelper != null ? contentDownloadHelper.getCurrentDownloadInfo() : null;
        this.currentType = i;
        switch (i) {
            case -2:
                this.b.animationView.setVisibility(4);
                this.b.error.setVisibility(0);
                this.b.progress.setState(2);
                this.b.percentText.setVisibility(4);
                this.b.tip.setText(getRetrySpan(null, onClickListener));
                break;
            case -1:
                this.b.animationView.setVisibility(4);
                this.b.error.setVisibility(0);
                if (this.b.progress.getProgress() > 0) {
                    this.b.progress.setState(3);
                    this.b.percentText.setVisibility(0);
                } else {
                    this.b.progress.setState(2);
                    this.b.percentText.setVisibility(4);
                }
                this.b.tip.setText("加载失败");
                break;
            case 0:
            case 1:
            case 3:
            case 8:
                this.b.progress.setState(0);
                this.b.tip.setText("准备中，马上就好哦");
                this.b.animationView.setVisibility(0);
                this.b.error.setVisibility(4);
                break;
            case 2:
                if (i2 > 0) {
                    this.b.progress.setProgress(i2);
                    this.b.progress.setState(1);
                    this.b.tip.setText("准备中，马上就好哦");
                }
                break;
            case 4:
                this.b.animationView.setVisibility(4);
                this.b.error.setVisibility(0);
                if (this.b.progress.getProgress() > 0) {
                    this.b.progress.setState(3);
                    this.b.percentText.setVisibility(0);
                } else {
                    this.b.progress.setState(2);
                    this.b.percentText.setVisibility(4);
                }
                this.b.tip.setText(getRetrySpan(currentDownloadInfo, onClickListener));
                if (!com.up366.common.StringUtils.isEmptyOrNull(str)) {
                    if (str.contains("Response")) {
                        com.up366.common.log.Logger.info("TAG - BookLoadingView - setData TYPE_DOWNLOAD_FAILED - info = [" + str + "]");
                        str = "下载失败";
                    }
                    if (i3 == -117) {
                        com.up366.mobile.common.dialog.AppDialog.create(getContext()).title("下载失败").message("手机好像出错了，请联系班级助教~").btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.studyviews.view.BookLoadingView$$ExternalSyntheticLambda2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(android.view.View view) {
                                com.up366.mobile.book.StaticTimeStudyLoadingHelper.INSTANCE.endLoading();
                            }
                        }).setBtnCloseVisibility(8).setCancelable(false).show();
                    } else {
                        com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this, str);
                    }
                }
                break;
            case 5:
                com.up366.mobile.book.StaticTimeStudyLoadingHelper.INSTANCE.endDownload();
                this.b.progress.setState(0);
                this.b.tip.setText("准备中，马上就好哦");
                this.b.animationView.setVisibility(0);
                this.b.error.setVisibility(4);
                break;
            case 6:
                this.b.animationView.setVisibility(4);
                this.b.error.setVisibility(0);
                this.b.progress.setState(3);
                this.b.tip.setText(getRetrySpan(currentDownloadInfo, onClickListener));
                break;
            case 7:
                com.up366.mobile.book.StaticTimeStudyLoadingHelper.INSTANCE.startDownload();
                this.b.progress.setState(0);
                if (!com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().isPrivateCloudState(currentDownloadInfo)) {
                    this.b.tip.setText("准备中，马上就好哦");
                } else {
                    this.b.tip.setText("你学校的服务器正在准备资源\n请耐心等待");
                }
                this.b.animationView.setVisibility(0);
                this.b.error.setVisibility(4);
                break;
        }
        removeCallbacks(this.loadingMonitor);
        if (i == 0) {
            postDelayed(this.loadingMonitor, 60000L);
        }
    }

    private java.lang.CharSequence getRetrySpan(com.up366.common.download.DownloadInfo downloadInfo, final android.view.View.OnClickListener onClickListener) {
        java.lang.String str;
        if (!com.up366.mobile.common.logic.Auth.cur().getPrivateCloudMgr().isPrivateCloudState(downloadInfo)) {
            str = "加载失败，";
        } else {
            str = "你学校的服务器还没准备好\n请";
        }
        return new com.up366.mobile.common.utils.SpannableStringBuilderUtil().append(str).append("点击重试").setSpan(new android.text.style.ClickableSpan() { // from class: com.up366.mobile.book.studyviews.view.BookLoadingView.1
            @Override // android.text.style.ClickableSpan
            public void onClick(android.view.View view) {
                onClickListener.onClick(com.up366.mobile.book.studyviews.view.BookLoadingView.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(android.text.TextPaint textPaint) {
                textPaint.setColor(textPaint.linkColor);
                textPaint.setUnderlineText(false);
            }
        }).build();
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    public boolean isDownloading() {
        com.up366.common.log.Logger.info("TAG - BookLoadingView - isDownloading - " + this.currentType);
        int i = this.currentType;
        return i == -1 || i == 1 || i == 2 || i == 3 || i == 4 || i == 6 || i == 7 || i == 8;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0) {
            com.up366.mobile.book.StaticTimeStudyLoadingHelper.INSTANCE.endLoading();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.loadingMonitor);
    }
}
