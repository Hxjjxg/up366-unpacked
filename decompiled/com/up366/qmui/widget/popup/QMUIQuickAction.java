package com.up366.qmui.widget.popup;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIQuickAction extends com.up366.qmui.widget.popup.QMUINormalPopup<com.up366.qmui.widget.popup.QMUIQuickAction> {
    private int mActionHeight;
    private int mActionWidth;
    private java.util.ArrayList<com.up366.qmui.widget.popup.QMUIQuickAction.Action> mActions;
    private int mMoreArrowWidth;
    private int mPaddingHor;
    private boolean mShowMoreArrowIfNeeded;

    public interface OnClickListener {
        void onClick(com.up366.qmui.widget.popup.QMUIQuickAction qMUIQuickAction, com.up366.qmui.widget.popup.QMUIQuickAction.Action action, int i);
    }

    public QMUIQuickAction(android.content.Context context, int i, int i2) {
        super(context, i, i2);
        this.mActions = new java.util.ArrayList<>();
        this.mActionWidth = -2;
        this.mShowMoreArrowIfNeeded = true;
        this.mActionHeight = i2;
        this.mMoreArrowWidth = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_quick_action_more_arrow_width);
        this.mPaddingHor = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_quick_action_padding_hor);
    }

    public com.up366.qmui.widget.popup.QMUIQuickAction moreArrowWidth(int i) {
        this.mMoreArrowWidth = i;
        return this;
    }

    public com.up366.qmui.widget.popup.QMUIQuickAction paddingHor(int i) {
        this.mPaddingHor = i;
        return this;
    }

    public com.up366.qmui.widget.popup.QMUIQuickAction actionWidth(int i) {
        this.mActionWidth = i;
        return this;
    }

    public com.up366.qmui.widget.popup.QMUIQuickAction actionHeight(int i) {
        this.mActionHeight = i;
        return this;
    }

    public com.up366.qmui.widget.popup.QMUIQuickAction addAction(com.up366.qmui.widget.popup.QMUIQuickAction.Action action) {
        this.mActions.add(action);
        return this;
    }

    public com.up366.qmui.widget.popup.QMUIQuickAction showMoreArrowIfNeeded(boolean z) {
        this.mShowMoreArrowIfNeeded = z;
        return this;
    }

    @Override // com.up366.qmui.widget.popup.QMUINormalPopup
    protected int proxyWidth(int i) {
        int i2;
        if (i > 0 && (i2 = this.mActionWidth) > 0) {
            int size = i2 * this.mActions.size();
            int i3 = this.mPaddingHor;
            if (i >= size + (i3 * 2)) {
                return super.proxyWidth(i);
            }
            int i4 = this.mMoreArrowWidth;
            int i5 = this.mActionWidth;
            return (i5 * (((i - i3) - i4) / i5)) + i3 + i4;
        }
        return super.proxyWidth(i);
    }

    @Override // com.up366.qmui.widget.popup.QMUINormalPopup
    public com.up366.qmui.widget.popup.QMUIQuickAction show(android.view.View view) {
        view((android.view.View) createContentView());
        return (com.up366.qmui.widget.popup.QMUIQuickAction) super.show(view);
    }

    private androidx.constraintlayout.widget.ConstraintLayout createContentView() {
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = new androidx.constraintlayout.widget.ConstraintLayout(this.mContext);
        final androidx.recyclerview.widget.RecyclerView recyclerView = new androidx.recyclerview.widget.RecyclerView(this.mContext);
        recyclerView.setLayoutManager(new com.up366.qmui.widget.popup.QMUIQuickAction.LayoutManager(this.mContext));
        recyclerView.setId(android.view.View.generateViewId());
        int i = this.mPaddingHor;
        recyclerView.setPadding(i, 0, i, 0);
        recyclerView.setClipToPadding(false);
        final com.up366.qmui.widget.popup.QMUIQuickAction.Adapter adapter = new com.up366.qmui.widget.popup.QMUIQuickAction.Adapter();
        adapter.submitList(this.mActions);
        recyclerView.setAdapter(adapter);
        constraintLayout.addView(recyclerView);
        if (this.mShowMoreArrowIfNeeded) {
            androidx.appcompat.widget.AppCompatImageView appCompatImageViewCreateMoreArrowView = createMoreArrowView(true);
            androidx.appcompat.widget.AppCompatImageView appCompatImageViewCreateMoreArrowView2 = createMoreArrowView(false);
            appCompatImageViewCreateMoreArrowView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.qmui.widget.popup.QMUIQuickAction.1
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    recyclerView.smoothScrollToPosition(0);
                }
            });
            appCompatImageViewCreateMoreArrowView2.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.qmui.widget.popup.QMUIQuickAction.2
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                }
            });
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(this.mMoreArrowWidth, 0);
            layoutParams.leftToLeft = recyclerView.getId();
            layoutParams.topToTop = recyclerView.getId();
            layoutParams.bottomToBottom = recyclerView.getId();
            constraintLayout.addView(appCompatImageViewCreateMoreArrowView, layoutParams);
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(this.mMoreArrowWidth, 0);
            layoutParams2.rightToRight = recyclerView.getId();
            layoutParams2.topToTop = recyclerView.getId();
            layoutParams2.bottomToBottom = recyclerView.getId();
            constraintLayout.addView(appCompatImageViewCreateMoreArrowView2, layoutParams2);
            recyclerView.addItemDecoration(new com.up366.qmui.widget.popup.QMUIQuickAction.ItemDecoration(appCompatImageViewCreateMoreArrowView, appCompatImageViewCreateMoreArrowView2));
        }
        return constraintLayout;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, androidx.appcompat.widget.AppCompatImageView, com.up366.qmui.widget.QMUIRadiusImageView2] */
    protected androidx.appcompat.widget.AppCompatImageView createMoreArrowView(boolean z) {
        ?? qMUIRadiusImageView2 = new com.up366.qmui.widget.QMUIRadiusImageView2(this.mContext);
        com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
        if (z) {
            qMUIRadiusImageView2.setPadding(this.mPaddingHor, 0, 0, 0);
            qMUISkinValueBuilderAcquire.src(com.qmuiteam.qmui.R.attr.qmui_skin_support_quick_action_more_left_arrow);
        } else {
            qMUIRadiusImageView2.setPadding(0, 0, this.mPaddingHor, 0);
            qMUISkinValueBuilderAcquire.src(com.qmuiteam.qmui.R.attr.qmui_skin_support_quick_action_more_right_arrow);
        }
        qMUISkinValueBuilderAcquire.tintColor(com.qmuiteam.qmui.R.attr.qmui_skin_support_quick_action_more_tint_color);
        int bgColor = getBgColor();
        int bgColorAttr = getBgColorAttr();
        if (bgColor != -1) {
            qMUIRadiusImageView2.setBackgroundColor(bgColor);
        } else if (bgColorAttr != 0) {
            qMUISkinValueBuilderAcquire.background(bgColorAttr);
        }
        com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) qMUIRadiusImageView2, qMUISkinValueBuilderAcquire);
        qMUIRadiusImageView2.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        qMUIRadiusImageView2.setVisibility(8);
        qMUIRadiusImageView2.setAlpha(0.0f);
        qMUISkinValueBuilderAcquire.release();
        return qMUIRadiusImageView2;
    }

    private class ItemDecoration extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
        private androidx.appcompat.widget.AppCompatImageView leftMoreArrowView;
        private androidx.appcompat.widget.AppCompatImageView rightMoreArrowView;
        private boolean isLeftMoreShown = false;
        private boolean isRightMoreShown = false;
        private boolean isFirstDraw = true;
        private int TOGGLE_DURATION = 60;
        private java.lang.Runnable leftHideEndAction = new java.lang.Runnable() { // from class: com.up366.qmui.widget.popup.QMUIQuickAction.ItemDecoration.1
            @Override // java.lang.Runnable
            public void run() {
                com.up366.qmui.widget.popup.QMUIQuickAction.ItemDecoration.this.leftMoreArrowView.setVisibility(8);
            }
        };
        private java.lang.Runnable rightHideEndAction = new java.lang.Runnable() { // from class: com.up366.qmui.widget.popup.QMUIQuickAction.ItemDecoration.2
            @Override // java.lang.Runnable
            public void run() {
                com.up366.qmui.widget.popup.QMUIQuickAction.ItemDecoration.this.rightMoreArrowView.setVisibility(8);
            }
        };

        public ItemDecoration(androidx.appcompat.widget.AppCompatImageView appCompatImageView, androidx.appcompat.widget.AppCompatImageView appCompatImageView2) {
            this.leftMoreArrowView = appCompatImageView;
            this.rightMoreArrowView = appCompatImageView2;
        }

        public void onDrawOver(android.graphics.Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state) {
            if (recyclerView.canScrollHorizontally(-1)) {
                if (!this.isLeftMoreShown) {
                    this.isLeftMoreShown = true;
                    this.leftMoreArrowView.setVisibility(0);
                    if (this.isFirstDraw) {
                        this.leftMoreArrowView.setAlpha(1.0f);
                    } else {
                        this.leftMoreArrowView.animate().alpha(1.0f).setDuration(this.TOGGLE_DURATION).start();
                    }
                }
            } else if (this.isLeftMoreShown) {
                this.isLeftMoreShown = false;
                this.leftMoreArrowView.animate().alpha(0.0f).setDuration(this.TOGGLE_DURATION).withEndAction(this.leftHideEndAction).start();
            }
            if (recyclerView.canScrollHorizontally(1)) {
                if (!this.isRightMoreShown) {
                    this.isRightMoreShown = true;
                    this.rightMoreArrowView.setVisibility(0);
                    if (this.isFirstDraw) {
                        this.rightMoreArrowView.setAlpha(1.0f);
                    } else {
                        this.rightMoreArrowView.animate().setDuration(this.TOGGLE_DURATION).alpha(1.0f).start();
                    }
                }
            } else if (this.isRightMoreShown) {
                this.isRightMoreShown = false;
                this.rightMoreArrowView.animate().alpha(0.0f).setDuration(this.TOGGLE_DURATION).withEndAction(this.rightHideEndAction).start();
            }
            this.isFirstDraw = false;
        }
    }

    private class LayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {
        private static final float MILLISECONDS_PER_INCH = 0.01f;

        public LayoutManager(android.content.Context context) {
            super(context, 0, false);
        }

        public androidx.recyclerview.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return new androidx.recyclerview.widget.RecyclerView.LayoutParams(com.up366.qmui.widget.popup.QMUIQuickAction.this.mActionWidth, com.up366.qmui.widget.popup.QMUIQuickAction.this.mActionHeight);
        }

        public void smoothScrollToPosition(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.State state, int i) {
            androidx.recyclerview.widget.LinearSmoothScroller linearSmoothScroller = new androidx.recyclerview.widget.LinearSmoothScroller(recyclerView.getContext()) { // from class: com.up366.qmui.widget.popup.QMUIQuickAction.LayoutManager.1
                protected int calculateTimeForScrolling(int i2) {
                    return 100;
                }
            };
            linearSmoothScroller.setTargetPosition(i);
            startSmoothScroll(linearSmoothScroller);
        }
    }

    private static class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener {
        private com.up366.qmui.widget.popup.QMUIQuickAction.VH.Callback callback;

        interface Callback {
            void onClick(android.view.View view, int i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public VH(com.up366.qmui.widget.popup.QMUIQuickAction.ItemView itemView, com.up366.qmui.widget.popup.QMUIQuickAction.VH.Callback callback) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.callback = callback;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            this.callback.onClick(view, getAdapterPosition());
        }
    }

    private class DiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.up366.qmui.widget.popup.QMUIQuickAction.Action> {
        private DiffCallback() {
        }

        public boolean areItemsTheSame(com.up366.qmui.widget.popup.QMUIQuickAction.Action action, com.up366.qmui.widget.popup.QMUIQuickAction.Action action2) {
            return java.util.Objects.equals(action.text, action2.text) && action.icon == action2.icon && action.iconAttr == action2.iconAttr && action.onClickListener == action2.onClickListener;
        }

        public boolean areContentsTheSame(com.up366.qmui.widget.popup.QMUIQuickAction.Action action, com.up366.qmui.widget.popup.QMUIQuickAction.Action action2) {
            return action.textColorAttr == action2.textColorAttr && action.iconTintColorAttr == action2.iconTintColorAttr;
        }
    }

    protected com.up366.qmui.widget.popup.QMUIQuickAction.ItemView createItemView() {
        return new com.up366.qmui.widget.popup.QMUIQuickAction.DefaultItemView(this.mContext);
    }

    private class Adapter extends androidx.recyclerview.widget.ListAdapter<com.up366.qmui.widget.popup.QMUIQuickAction.Action, com.up366.qmui.widget.popup.QMUIQuickAction.VH> implements com.up366.qmui.widget.popup.QMUIQuickAction.VH.Callback {
        protected Adapter() {
            super(new com.up366.qmui.widget.popup.QMUIQuickAction.DiffCallback());
        }

        public com.up366.qmui.widget.popup.QMUIQuickAction.VH onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            return new com.up366.qmui.widget.popup.QMUIQuickAction.VH(com.up366.qmui.widget.popup.QMUIQuickAction.this.createItemView(), this);
        }

        @Override // com.up366.qmui.widget.popup.QMUIQuickAction.VH.Callback
        public void onClick(android.view.View view, int i) {
            com.up366.qmui.widget.popup.QMUIQuickAction.Action action = (com.up366.qmui.widget.popup.QMUIQuickAction.Action) getItem(i);
            com.up366.qmui.widget.popup.QMUIQuickAction.OnClickListener onClickListener = action.onClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(com.up366.qmui.widget.popup.QMUIQuickAction.this, action, i);
            }
        }

        public void onBindViewHolder(com.up366.qmui.widget.popup.QMUIQuickAction.VH vh, int i) {
            ((com.up366.qmui.widget.popup.QMUIQuickAction.ItemView) vh.itemView).render((com.up366.qmui.widget.popup.QMUIQuickAction.Action) getItem(i));
        }
    }

    public static class Action {
        android.graphics.drawable.Drawable icon;
        int iconRes;
        com.up366.qmui.widget.popup.QMUIQuickAction.OnClickListener onClickListener;
        java.lang.CharSequence text;
        int iconAttr = 0;
        int textColorAttr = com.qmuiteam.qmui.R.attr.qmui_skin_support_quick_action_item_tint_color;
        int iconTintColorAttr = com.qmuiteam.qmui.R.attr.qmui_skin_support_quick_action_item_tint_color;

        public com.up366.qmui.widget.popup.QMUIQuickAction.Action iconAttr(int i) {
            this.iconAttr = i;
            return this;
        }

        public com.up366.qmui.widget.popup.QMUIQuickAction.Action icon(android.graphics.drawable.Drawable drawable) {
            this.icon = drawable;
            return this;
        }

        public com.up366.qmui.widget.popup.QMUIQuickAction.Action icon(int i) {
            this.iconRes = i;
            return this;
        }

        public com.up366.qmui.widget.popup.QMUIQuickAction.Action onClick(com.up366.qmui.widget.popup.QMUIQuickAction.OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
            return this;
        }

        public com.up366.qmui.widget.popup.QMUIQuickAction.Action text(java.lang.CharSequence charSequence) {
            this.text = charSequence;
            return this;
        }

        public com.up366.qmui.widget.popup.QMUIQuickAction.Action textColorAttr(int i) {
            this.textColorAttr = i;
            return this;
        }

        public com.up366.qmui.widget.popup.QMUIQuickAction.Action iconTintColorAttr(int i) {
            this.iconTintColorAttr = i;
            return this;
        }
    }

    public static abstract class ItemView extends com.up366.qmui.layout.QMUIConstraintLayout {
        public abstract void render(com.up366.qmui.widget.popup.QMUIQuickAction.Action action);

        public ItemView(android.content.Context context) {
            super(context);
        }

        public ItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class DefaultItemView extends com.up366.qmui.widget.popup.QMUIQuickAction.ItemView {
        private androidx.appcompat.widget.AppCompatImageView mIconView;
        private android.widget.TextView mTextView;

        public DefaultItemView(android.content.Context context) {
            this(context, null);
        }

        public DefaultItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            int attrDimen = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_quick_action_item_padding_hor);
            int attrDimen2 = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_quick_action_item_padding_ver);
            setPadding(attrDimen, attrDimen2, attrDimen, attrDimen2);
            androidx.appcompat.widget.AppCompatImageView appCompatImageView = new androidx.appcompat.widget.AppCompatImageView(context);
            this.mIconView = appCompatImageView;
            appCompatImageView.setId(com.up366.qmui.util.QMUIViewHelper.generateViewId());
            android.widget.TextView textView = new android.widget.TextView(context);
            this.mTextView = textView;
            textView.setId(com.up366.qmui.util.QMUIViewHelper.generateViewId());
            this.mTextView.setTextSize(10.0f);
            this.mTextView.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
            setChangeAlphaWhenPress(true);
            setChangeAlphaWhenDisable(true);
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.leftToLeft = 0;
            layoutParams.rightToRight = 0;
            layoutParams.topToTop = 0;
            layoutParams.bottomToTop = this.mTextView.getId();
            layoutParams.verticalChainStyle = 2;
            addView(this.mIconView, layoutParams);
            androidx.constraintlayout.widget.ConstraintLayout.LayoutParams layoutParams2 = new androidx.constraintlayout.widget.ConstraintLayout.LayoutParams(-2, -2);
            layoutParams2.leftToLeft = 0;
            layoutParams2.rightToRight = 0;
            layoutParams2.topToBottom = this.mIconView.getId();
            layoutParams2.bottomToBottom = 0;
            layoutParams2.topMargin = com.up366.qmui.util.QMUIResHelper.getAttrDimen(context, com.qmuiteam.qmui.R.attr.qmui_quick_action_item_middle_space);
            layoutParams2.verticalChainStyle = 2;
            layoutParams2.goneTopMargin = 0;
            addView(this.mTextView, layoutParams2);
        }

        @Override // com.up366.qmui.widget.popup.QMUIQuickAction.ItemView
        public void render(com.up366.qmui.widget.popup.QMUIQuickAction.Action action) {
            com.up366.qmui.skin.QMUISkinValueBuilder qMUISkinValueBuilderAcquire = com.up366.qmui.skin.QMUISkinValueBuilder.acquire();
            if (action.icon != null || action.iconRes != 0) {
                if (action.icon != null) {
                    this.mIconView.setImageDrawable(action.icon.mutate());
                } else {
                    this.mIconView.setImageResource(action.iconRes);
                }
                if (action.iconTintColorAttr != 0) {
                    qMUISkinValueBuilderAcquire.tintColor(action.iconTintColorAttr);
                }
                this.mIconView.setVisibility(0);
                com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mIconView, qMUISkinValueBuilderAcquire);
            } else if (action.iconAttr != 0) {
                qMUISkinValueBuilderAcquire.src(action.iconAttr);
                this.mIconView.setVisibility(0);
                com.up366.qmui.skin.QMUISkinHelper.setSkinValue((android.view.View) this.mIconView, qMUISkinValueBuilderAcquire);
            } else {
                this.mIconView.setVisibility(8);
            }
            this.mTextView.setText(action.text);
            qMUISkinValueBuilderAcquire.clear();
            qMUISkinValueBuilderAcquire.textColor(action.textColorAttr);
            com.up366.qmui.skin.QMUISkinHelper.setSkinValue(this.mTextView, qMUISkinValueBuilderAcquire);
            qMUISkinValueBuilderAcquire.release();
        }
    }
}
