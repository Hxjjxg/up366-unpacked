package com.up366.mobile.book.studyviews.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class ChapterItemView extends android.widget.FrameLayout {
    private com.up366.mobile.book.studyviews.ChapterAdapter adapter;
    private com.up366.mobile.databinding.BookChapterItemLayoutBinding b;
    private int bLevel;
    private float baseDp;
    private com.up366.mobile.book.model.TreeBookChapter bookChapterInfo;
    private android.content.Context context;
    private float dp16;
    private float dp27;
    private boolean hasSub;
    private int level;
    private int lineType;
    private int marginLeft;
    private com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage> node;
    private android.graphics.Paint paint;
    private int vlMode;

    public ChapterItemView(android.content.Context context) {
        this(context, null, 0);
    }

    public ChapterItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChapterItemView(final android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.level = 1;
        this.lineType = 2;
        this.dp16 = 48.0f;
        this.dp27 = 81.0f;
        this.baseDp = 48.0f;
        this.context = context;
        this.bookChapterInfo = ((com.up366.mobile.book.StudyActivity) context).bookChapterInfo;
        setWillNotDraw(false);
        android.graphics.Paint paint = new android.graphics.Paint();
        this.paint = paint;
        paint.setColor(1717986918);
        if (isInEditMode()) {
            android.view.View.inflate(context, com.up366.mobile.R.layout.book_chapter_item_layout, this);
            return;
        }
        this.b = (com.up366.mobile.databinding.BookChapterItemLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.book_chapter_item_layout, this, true);
        this.dp16 = com.up366.common.DpUtilsUp.dp2px(16.0f);
        this.dp27 = com.up366.common.DpUtilsUp.dp2px(27.0f);
        this.baseDp = com.up366.common.DpUtilsUp.dp2px(16.0f);
        this.marginLeft = com.up366.common.DpUtilsUp.dp2px(27.0f);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this, new android.view.View.OnClickListener() { // from class: com.up366.mobile.book.studyviews.view.ChapterItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$new$0(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$new$0(android.content.Context context, android.view.View view) {
        if (this.b.lock.getVisibility() == 0) {
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo(this, "该章节被锁定，暂时无法学习哦~");
            return;
        }
        if (this.node.hasSub) {
            this.adapter.onItemClick(this.node);
            return;
        }
        com.up366.mobile.book.model.OpenConfigInfo openConfigInfo = new com.up366.mobile.book.model.OpenConfigInfo();
        openConfigInfo.chapterId = this.node.obj.obj.getId();
        openConfigInfo.pageNo = this.node.obj.getPageNo();
        openConfigInfo.title = this.node.obj.obj.getName();
        ((com.up366.mobile.book.StudyActivity) context).openPage(openConfigInfo);
    }

    public ChapterItemView(android.content.Context context, com.up366.mobile.book.studyviews.ChapterAdapter chapterAdapter) {
        this(context);
        this.adapter = chapterAdapter;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        int i = (int) (this.baseDp + (this.dp27 * this.level));
        if (this.hasSub) {
            int i2 = this.lineType;
            if (i2 == 1) {
                float f = i;
                canvas.drawLine(f, 0.0f, f, height / 2, this.paint);
            } else if (i2 == 2) {
                float f2 = i;
                canvas.drawLine(f2, 0.0f, f2, height, this.paint);
            } else if (i2 == 3) {
                float f3 = i;
                canvas.drawLine(f3, height / 2, f3, height, this.paint);
            }
        }
        int i3 = this.vlMode;
        for (int i4 = this.level - 1; i4 > 0; i4--) {
            if (((i3 >> i4) & 1) == 1) {
                float f4 = this.baseDp;
                float f5 = this.dp27;
                float f6 = i4;
                canvas.drawLine(f4 + (f5 * f6), 0.0f, f4 + (f5 * f6), height, this.paint);
            }
        }
        float f7 = height - 1;
        canvas.drawLine(this.baseDp + (this.dp27 * this.bLevel) + this.dp16, f7, width, f7, this.paint);
    }

    public void setLineType(int i) {
        this.lineType = i;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setHasSub(boolean z) {
        this.hasSub = z;
    }

    public void setbLevel(int i) {
        this.bLevel = i;
    }

    public void setVlMode(int i) {
        this.vlMode = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLayoutParams().width = -1;
        requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setNode(com.up366.mobile.book.model.TreeNode<com.up366.mobile.book.model.CatalogPage> r6) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.up366.mobile.book.studyviews.view.ChapterItemView.setNode(com.up366.mobile.book.model.TreeNode):void");
    }

    private void initLockState() {
        com.up366.mobile.common.utils.ViewUtil.gone(this.b.cursor, this.b.lock, this.b.score);
        com.up366.mobile.book.model.ChapterInfo chapterInfo = this.node.obj.obj;
        if (!chapterInfo.isFree()) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.lock);
            return;
        }
        if (chapterInfo.isLock() || this.node.obj.isInLockChapter()) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.b.lock);
            return;
        }
        if (this.node.hasSub) {
            return;
        }
        com.up366.mobile.common.utils.ViewUtil.visible(this.b.cursor, this.b.score);
        com.up366.mobile.book.model.BookTaskFinishedInfo bookTaskFinishedInfo = this.bookChapterInfo.getTaskMap().get(this.node.obj.obj.getId());
        if (this.node.obj instanceof com.up366.mobile.book.model.CatalogChapter) {
            if (bookTaskFinishedInfo == null) {
                bookTaskFinishedInfo = ((com.up366.mobile.book.model.CatalogChapter) this.node.obj).taskInfo;
            }
            java.util.List<com.up366.mobile.book.model.CatalogChapter> list = ((com.up366.mobile.book.model.CatalogChapter) this.node.obj).tasks;
            if (list.size() > 0) {
                bookTaskFinishedInfo = this.bookChapterInfo.getTaskMap().get(list.get(0).obj.getId());
            }
        }
        if (bookTaskFinishedInfo == null || (bookTaskFinishedInfo.getPercent() == 0.0f && bookTaskFinishedInfo.getScore() == 0.0f)) {
            this.b.score.setText("");
        } else {
            this.b.score.setText(com.up366.common.StringUtils.format("%.1f ", java.lang.Float.valueOf(bookTaskFinishedInfo.getScore())).replace(".0", ""));
        }
    }
}
