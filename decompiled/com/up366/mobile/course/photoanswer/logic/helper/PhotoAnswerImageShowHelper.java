package com.up366.mobile.course.photoanswer.logic.helper;

/* JADX INFO: compiled from: PhotoAnswerImageShowHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u001c\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0014\u0010!\u001a\u00020\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020\u0019H\u0002J\u0010\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0017R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/helper/PhotoAnswerImageShowHelper;", "", "activity", "Lcom/up366/mobile/course/photoanswer/PhotoAnswerMainActivity;", "<init>", "(Lcom/up366/mobile/course/photoanswer/PhotoAnswerMainActivity;)V", "currentIndex", "", "clShowPage", "Landroidx/constraintlayout/widget/ConstraintLayout;", "clSmartCamera", "vpImagesShow", "Landroidx/viewpager/widget/ViewPager;", "ibShowPageRetract", "Landroid/widget/ImageButton;", "ibDelete", "autoTip", "Landroid/widget/TextView;", "btBack", "expendAnim", "Landroid/animation/ObjectAnimator;", "retractAnim", "adapter", "Lcom/up366/mobile/course/photoanswer/logic/helper/PhotoAnswerImageShowHelper$ImageShowAdapter;", "setupView", "", "setupViewPager", "setupAnimation", "showPageImage", "position", "pages", "", "Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerImageInfo;", "deletePageResult", "newPages", "isShowing", "", "expendShowView", "retractShowView", "notifyUI", "ImageShowAdapter", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerImageShowHelper {
    private final com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity activity;
    private final com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper.ImageShowAdapter adapter;
    private final android.widget.TextView autoTip;
    private final android.widget.ImageButton btBack;
    private final androidx.constraintlayout.widget.ConstraintLayout clShowPage;
    private final androidx.constraintlayout.widget.ConstraintLayout clSmartCamera;
    private int currentIndex;
    private final android.animation.ObjectAnimator expendAnim;
    private final android.widget.ImageButton ibDelete;
    private final android.widget.ImageButton ibShowPageRetract;
    private final android.animation.ObjectAnimator retractAnim;
    private final androidx.viewpager.widget.ViewPager vpImagesShow;

    public PhotoAnswerImageShowHelper(com.up366.mobile.course.photoanswer.PhotoAnswerMainActivity photoAnswerMainActivity) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(photoAnswerMainActivity, "activity");
        this.activity = photoAnswerMainActivity;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = photoAnswerMainActivity.getBinding().clShowPage;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constraintLayout, "clShowPage");
        this.clShowPage = constraintLayout;
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout2 = photoAnswerMainActivity.getBinding().clSmartCamera;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constraintLayout2, "clSmartCamera");
        this.clSmartCamera = constraintLayout2;
        androidx.viewpager.widget.ViewPager viewPager = photoAnswerMainActivity.getBinding().vpImagesShow;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewPager, "vpImagesShow");
        this.vpImagesShow = viewPager;
        android.widget.ImageButton imageButton = photoAnswerMainActivity.getBinding().ibShowPageRetract;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(imageButton, "ibShowPageRetract");
        this.ibShowPageRetract = imageButton;
        android.widget.ImageButton imageButton2 = photoAnswerMainActivity.getBinding().ibDelete;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(imageButton2, "ibDelete");
        this.ibDelete = imageButton2;
        android.widget.TextView textView = photoAnswerMainActivity.getBinding().autoTip;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(textView, "autoTip");
        this.autoTip = textView;
        android.widget.ImageButton imageButton3 = photoAnswerMainActivity.getBinding().btBack;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(imageButton3, "btBack");
        this.btBack = imageButton3;
        android.animation.ObjectAnimator duration = android.animation.ObjectAnimator.ofFloat(constraintLayout, "translationY", constraintLayout2.getMeasuredHeight(), 0.0f).setDuration(250L);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(duration, "setDuration(...)");
        this.expendAnim = duration;
        android.animation.ObjectAnimator duration2 = android.animation.ObjectAnimator.ofFloat(constraintLayout, "translationY", 0.0f, constraintLayout2.getMeasuredHeight()).setDuration(250L);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(duration2, "setDuration(...)");
        this.retractAnim = duration2;
        this.adapter = new com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper.ImageShowAdapter();
        setupView();
        setupViewPager();
        setupAnimation();
    }

    private final void setupView() {
        this.ibShowPageRetract.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.retractShowView(true);
            }
        });
        float f = android.content.res.Resources.getSystem().getDisplayMetrics().density * 20;
        android.graphics.drawable.ShapeDrawable shapeDrawable = new android.graphics.drawable.ShapeDrawable(new android.graphics.drawable.shapes.RoundRectShape(new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f}, null, null));
        shapeDrawable.getPaint().setColor(android.graphics.Color.parseColor("#FFE6E4E0"));
        this.vpImagesShow.setBackground(shapeDrawable);
        this.vpImagesShow.setClipToOutline(true);
        this.vpImagesShow.setClipChildren(true);
    }

    private final void setupViewPager() {
        this.vpImagesShow.setAdapter(this.adapter);
        this.vpImagesShow.addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener() { // from class: com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper.setupViewPager.1
            public void onPageSelected(int position) {
                com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo item = com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper.this.adapter.getItem(position);
                if (item != null) {
                    com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper photoAnswerImageShowHelper = com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper.this;
                    photoAnswerImageShowHelper.currentIndex = position;
                    photoAnswerImageShowHelper.activity.onPageSelectedShow(position, item);
                }
            }
        });
    }

    private final void setupAnimation() {
        this.retractAnim.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper.setupAnimation.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animation) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(animation, "animation");
                com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper.this.clShowPage.setVisibility(8);
                com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper.this.btBack.setVisibility(0);
                com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper.this.activity.closePageImageShow();
            }
        });
    }

    /* JADX INFO: compiled from: PhotoAnswerImageShowHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u001aJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010\u001c\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/up366/mobile/course/photoanswer/logic/helper/PhotoAnswerImageShowHelper$ImageShowAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "<init>", "(Lcom/up366/mobile/course/photoanswer/logic/helper/PhotoAnswerImageShowHelper;)V", "pages", "", "Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerImageInfo;", "viewCache", "Landroid/util/SparseArray;", "Lcom/up366/mobile/course/photoanswer/view/PhotoAnswerPreviewImageView;", "getCount", "", "isViewFromObject", "", "view", "Landroid/view/View;", "obj", "", "instantiateItem", "container", "Landroid/view/ViewGroup;", "position", "destroyItem", "", "submitList", "list", "", "getItem", "size", "getItemPosition", "object", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class ImageShowAdapter extends androidx.viewpager.widget.PagerAdapter {
        private final java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> pages = new java.util.ArrayList();
        private final android.util.SparseArray<com.up366.mobile.course.photoanswer.view.PhotoAnswerPreviewImageView> viewCache = new android.util.SparseArray<>();

        public int getItemPosition(java.lang.Object object) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(object, "object");
            return -2;
        }

        public ImageShowAdapter() {
        }

        public int getCount() {
            return this.pages.size();
        }

        public boolean isViewFromObject(android.view.View view, java.lang.Object obj) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(obj, "obj");
            return kotlin.jvm.internal.Intrinsics.areEqual(view, obj);
        }

        public java.lang.Object instantiateItem(android.view.ViewGroup container, int position) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
            com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo = (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) kotlin.collections.CollectionsKt.getOrNull(this.pages, position);
            if (photoAnswerImageInfo == null) {
                return new android.view.View(container.getContext());
            }
            com.up366.mobile.course.photoanswer.view.PhotoAnswerPreviewImageView photoAnswerPreviewImageView = this.viewCache.get(position);
            if (photoAnswerPreviewImageView == null) {
                android.content.Context context = container.getContext();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                photoAnswerPreviewImageView = new com.up366.mobile.course.photoanswer.view.PhotoAnswerPreviewImageView(context);
                photoAnswerPreviewImageView.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
                this.viewCache.put(position, photoAnswerPreviewImageView);
            }
            photoAnswerPreviewImageView.showPage(photoAnswerImageInfo);
            container.addView(photoAnswerPreviewImageView);
            return photoAnswerPreviewImageView;
        }

        public void destroyItem(android.view.ViewGroup container, int position, java.lang.Object obj) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(obj, "obj");
            android.view.View view = obj instanceof android.view.View ? (android.view.View) obj : null;
            if (view != null) {
                container.removeView(view);
            }
        }

        public final void submitList(java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> list) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "list");
            this.pages.clear();
            this.pages.addAll(list);
            if (this.pages.size() == 0) {
                this.viewCache.clear();
            }
            notifyDataSetChanged();
        }

        public final com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo getItem(int position) {
            return (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) kotlin.collections.CollectionsKt.getOrNull(this.pages, position);
        }

        public final int size() {
            return this.pages.size();
        }
    }

    public final void showPageImage(int position, java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> pages) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pages, "pages");
        this.adapter.submitList(pages);
        if (pages.isEmpty()) {
            retractShowView(true);
            return;
        }
        int iCoerceAtLeast = kotlin.ranges.RangesKt.coerceAtLeast(kotlin.ranges.RangesKt.coerceAtMost(position, kotlin.collections.CollectionsKt.getLastIndex(pages)), 0);
        this.currentIndex = iCoerceAtLeast;
        if (!isShowing()) {
            expendShowView();
        }
        this.vpImagesShow.setCurrentItem(iCoerceAtLeast, false);
        com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo item = this.adapter.getItem(iCoerceAtLeast);
        if (item != null) {
            this.activity.onPageSelectedShow(iCoerceAtLeast, item);
        }
    }

    public final void deletePageResult(java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> newPages) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newPages, "newPages");
        int size = this.adapter.size();
        this.adapter.submitList(newPages);
        if (size > newPages.size()) {
            com.up366.mobile.common.utils.ToastPopupUtil.show("删除成功");
        }
        if (newPages.isEmpty()) {
            retractShowView(true);
            return;
        }
        int iCoerceAtLeast = kotlin.ranges.RangesKt.coerceAtLeast(kotlin.ranges.RangesKt.coerceAtMost(this.currentIndex, kotlin.collections.CollectionsKt.getLastIndex(newPages)), 0);
        this.currentIndex = iCoerceAtLeast;
        this.vpImagesShow.setCurrentItem(iCoerceAtLeast, false);
    }

    public final boolean isShowing() {
        return this.clShowPage.getVisibility() == 0;
    }

    private final void expendShowView() {
        this.activity.setActivityIsShowing(false);
        if (this.clShowPage.getVisibility() == 0) {
            return;
        }
        this.btBack.setVisibility(8);
        this.clShowPage.setVisibility(0);
        this.expendAnim.start();
    }

    public static /* synthetic */ void retractShowView$default(com.up366.mobile.course.photoanswer.logic.helper.PhotoAnswerImageShowHelper photoAnswerImageShowHelper, boolean z, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        photoAnswerImageShowHelper.retractShowView(z);
    }

    public final void retractShowView(boolean notifyUI) {
        this.activity.setActivityIsShowing(true);
        if (this.clShowPage.getVisibility() == 8) {
            return;
        }
        this.ibDelete.setVisibility(8);
        this.autoTip.setVisibility(0);
        this.retractAnim.start();
    }
}
