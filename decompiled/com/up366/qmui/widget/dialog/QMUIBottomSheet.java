package com.up366.qmui.widget.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIBottomSheet extends com.up366.qmui.widget.dialog.QMUIBaseDialog {
    private static final java.lang.String TAG = "QMUIBottomSheet";
    private boolean mAnimateToCancel;
    private boolean mAnimateToDismiss;
    private com.up366.qmui.widget.dialog.QMUIBottomSheetBehavior<com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout> mBehavior;
    private com.up366.qmui.widget.dialog.QMUIBottomSheet.OnBottomSheetShowListener mOnBottomSheetShowListener;
    private com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout mRootView;

    public interface OnBottomSheetShowListener {
        void onShow();
    }

    public QMUIBottomSheet(android.content.Context context) {
        this(context, com.qmuiteam.qmui.R.style.QMUI_BottomSheet);
    }

    public QMUIBottomSheet(android.content.Context context, int i) {
        super(context, i);
        this.mAnimateToCancel = false;
        this.mAnimateToDismiss = false;
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) android.view.View.inflate(context, com.qmuiteam.qmui.R.layout.qmui_bottom_sheet_dialog, null);
        this.mRootView = (com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout) viewGroup.findViewById(com.qmuiteam.qmui.R.id.bottom_sheet);
        com.up366.qmui.widget.dialog.QMUIBottomSheetBehavior<com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout> qMUIBottomSheetBehavior = new com.up366.qmui.widget.dialog.QMUIBottomSheetBehavior<>();
        this.mBehavior = qMUIBottomSheetBehavior;
        qMUIBottomSheetBehavior.setHideable(this.cancelable);
        this.mBehavior.addBottomSheetCallback(new com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback() { // from class: com.up366.qmui.widget.dialog.QMUIBottomSheet.1
            public void onSlide(android.view.View view, float f) {
            }

            public void onStateChanged(android.view.View view, int i2) {
                if (i2 == 5) {
                    if (!com.up366.qmui.widget.dialog.QMUIBottomSheet.this.mAnimateToCancel) {
                        if (com.up366.qmui.widget.dialog.QMUIBottomSheet.this.mAnimateToDismiss) {
                            com.up366.qmui.widget.dialog.QMUIBottomSheet.this.dismiss();
                            return;
                        } else {
                            com.up366.qmui.widget.dialog.QMUIBottomSheet.this.cancel();
                            return;
                        }
                    }
                    com.up366.qmui.widget.dialog.QMUIBottomSheet.this.cancel();
                }
            }
        });
        this.mBehavior.setPeekHeight(0);
        this.mBehavior.setAllowDrag(false);
        this.mBehavior.setSkipCollapsed(true);
        this.mRootView.getLayoutParams().setBehavior(this.mBehavior);
        viewGroup.findViewById(com.qmuiteam.qmui.R.id.touch_outside).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.qmui.widget.dialog.QMUIBottomSheet.2
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.up366.qmui.widget.dialog.QMUIBottomSheet.this.mBehavior.getState() != 2 && com.up366.qmui.widget.dialog.QMUIBottomSheet.this.cancelable && com.up366.qmui.widget.dialog.QMUIBottomSheet.this.isShowing() && com.up366.qmui.widget.dialog.QMUIBottomSheet.this.shouldWindowCloseOnTouchOutside()) {
                    com.up366.qmui.widget.dialog.QMUIBottomSheet.this.cancel();
                }
            }
        });
        this.mRootView.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.up366.qmui.widget.dialog.QMUIBottomSheet.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                return true;
            }
        });
        super.setContentView(viewGroup, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.up366.qmui.widget.dialog.QMUIBaseDialog
    protected void onSetCancelable(boolean z) {
        super.onSetCancelable(z);
        this.mBehavior.setHideable(z);
    }

    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        android.view.Window window = getWindow();
        if (window != null) {
            window.clearFlags(67108864);
            window.addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
            window.setLayout(-1, -1);
        }
        androidx.core.view.ViewCompat.requestApplyInsets(this.mRootView);
    }

    @Override // com.up366.qmui.widget.dialog.QMUIBaseDialog
    protected void onStart() {
        super.onStart();
        if (this.mBehavior.getState() == 5) {
            this.mBehavior.setState(4);
        }
    }

    public void cancel() {
        if (this.mBehavior.getState() == 5) {
            this.mAnimateToCancel = false;
            super.cancel();
        } else {
            this.mAnimateToCancel = true;
            this.mBehavior.setState(5);
        }
    }

    public void dismiss() {
        if (this.mBehavior.getState() == 5) {
            this.mAnimateToDismiss = false;
            super.dismiss();
        } else {
            this.mAnimateToDismiss = true;
            this.mBehavior.setState(5);
        }
    }

    public void setOnBottomSheetShowListener(com.up366.qmui.widget.dialog.QMUIBottomSheet.OnBottomSheetShowListener onBottomSheetShowListener) {
        this.mOnBottomSheetShowListener = onBottomSheetShowListener;
    }

    public void setRadius(int i) {
        this.mRootView.setRadius(i, 3);
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout getRootView() {
        return this.mRootView;
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheetBehavior<com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout> getBehavior() {
        return this.mBehavior;
    }

    public void show() {
        super.show();
        com.up366.qmui.widget.dialog.QMUIBottomSheet.OnBottomSheetShowListener onBottomSheetShowListener = this.mOnBottomSheetShowListener;
        if (onBottomSheetShowListener != null) {
            onBottomSheetShowListener.onShow();
        }
        if (this.mBehavior.getState() != 3) {
            this.mRootView.postOnAnimation(new java.lang.Runnable() { // from class: com.up366.qmui.widget.dialog.QMUIBottomSheet.4
                @Override // java.lang.Runnable
                public void run() {
                    com.up366.qmui.widget.dialog.QMUIBottomSheet.this.mBehavior.setState(3);
                }
            });
        }
        this.mAnimateToCancel = false;
        this.mAnimateToDismiss = false;
    }

    public void setContentView(android.view.View view) {
        throw new java.lang.IllegalStateException("Use addContentView(View, ConstraintLayout.LayoutParams) for replacement");
    }

    public void setContentView(int i) {
        throw new java.lang.IllegalStateException("Use addContentView(int) for replacement");
    }

    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        throw new java.lang.IllegalStateException("Use addContentView(View, LinearLayout.LayoutParams) for replacement");
    }

    public void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        throw new java.lang.IllegalStateException("Use addContentView(View, LinearLayout.LayoutParams) for replacement");
    }

    public void addContentView(android.view.View view, android.widget.LinearLayout.LayoutParams layoutParams) {
        this.mRootView.addView(view, layoutParams);
    }

    public void addContentView(android.view.View view) {
        this.mRootView.addView(view, new android.widget.LinearLayout.LayoutParams(-1, -2));
    }

    public void addContentView(int i) {
        android.view.LayoutInflater.from(this.mRootView.getContext()).inflate(i, (android.view.ViewGroup) this.mRootView, true);
    }

    public static class BottomListSheetBuilder extends com.up366.qmui.widget.dialog.QMUIBottomSheetBaseBuilder<com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder> {
        private com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter adapter;
        private int mCheckedIndex;
        private java.util.List<android.view.View> mContentFooterViews;
        private java.util.List<android.view.View> mContentHeaderViews;
        private boolean mGravityCenter;
        private java.util.List<com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel> mItems;
        private boolean mNeedRightMark;
        private com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder.OnSheetItemClickListener mOnSheetItemClickListener;
        private boolean mRightMarkSelectedFalseVisible;
        private android.view.View sheetHeaderView;

        public interface OnSheetItemClickListener {
            void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, android.view.View view, int i, java.lang.String str);
        }

        public BottomListSheetBuilder(android.content.Context context) {
            this(context, false);
        }

        public BottomListSheetBuilder(android.content.Context context, boolean z) {
            super(context);
            this.mRightMarkSelectedFalseVisible = false;
            this.mGravityCenter = false;
            this.mItems = new java.util.ArrayList();
            this.mNeedRightMark = z;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder setCheckedIndex(int i) {
            this.mCheckedIndex = i;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder setNeedRightMark(boolean z) {
            this.mNeedRightMark = z;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder setRightMarkSelectedFalseVisible(boolean z) {
            this.mRightMarkSelectedFalseVisible = z;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder setGravityCenter(boolean z) {
            this.mGravityCenter = z;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder setOnSheetItemClickListener(com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder.OnSheetItemClickListener onSheetItemClickListener) {
            this.mOnSheetItemClickListener = onSheetItemClickListener;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder addItem(com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel qMUIBottomSheetListItemModel) {
            this.mItems.add(qMUIBottomSheetListItemModel);
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder addItem(java.lang.String str) {
            this.mItems.add(new com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel(str, str));
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder addItem(android.graphics.drawable.Drawable drawable, java.lang.String str) {
            this.mItems.add(new com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel(str, str).image(drawable));
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder addItem(java.lang.String str, java.lang.String str2) {
            this.mItems.add(new com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel(str, str2));
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder addItem(int i, java.lang.String str, java.lang.String str2) {
            this.mItems.add(new com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel(str, str2).image(i));
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder addItem(int i, java.lang.String str, java.lang.String str2, boolean z) {
            this.mItems.add(new com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel(str, str2).image(i).redPoint(z));
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder addItem(int i, java.lang.CharSequence charSequence, java.lang.String str, boolean z, boolean z2) {
            this.mItems.add(new com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel(charSequence, str).image(i).redPoint(z).disabled(z2));
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder setHeaderView(android.view.View view) {
            this.sheetHeaderView = view;
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder addContentHeaderView(android.view.View view) {
            if (this.mContentHeaderViews == null) {
                this.mContentHeaderViews = new java.util.ArrayList();
            }
            this.mContentHeaderViews.add(view);
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder addContentFooterView(android.view.View view) {
            if (this.mContentFooterViews == null) {
                this.mContentFooterViews = new java.util.ArrayList();
            }
            this.mContentFooterViews.add(view);
            return this;
        }

        public void updateCheckedIndex(int i) {
            this.mCheckedIndex = i;
            this.adapter.setCheckedIndex(i);
        }

        @Override // com.up366.qmui.widget.dialog.QMUIBottomSheetBaseBuilder
        protected android.view.View onCreateTitleView(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, android.content.Context context) {
            android.view.View view = this.sheetHeaderView;
            return view != null ? view : super.onCreateTitleView(qMUIBottomSheet, qMUIBottomSheetRootLayout, context);
        }

        @Override // com.up366.qmui.widget.dialog.QMUIBottomSheetBaseBuilder
        protected android.view.View onCreateContentView(final com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, android.content.Context context) {
            android.widget.LinearLayout linearLayout;
            androidx.recyclerview.widget.RecyclerView recyclerView = new androidx.recyclerview.widget.RecyclerView(context);
            recyclerView.setOverScrollMode(2);
            com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter qMUIBottomSheetListAdapter = new com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter(this.mNeedRightMark, this.mRightMarkSelectedFalseVisible, this.mGravityCenter);
            this.adapter = qMUIBottomSheetListAdapter;
            recyclerView.setAdapter(qMUIBottomSheetListAdapter);
            recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(context) { // from class: com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder.1
                public androidx.recyclerview.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
                    return new androidx.recyclerview.widget.RecyclerView.LayoutParams(-1, -2);
                }
            });
            recyclerView.addItemDecoration(new com.up366.qmui.widget.dialog.QMUIBottomSheetListItemDecoration(context));
            java.util.List<android.view.View> list = this.mContentHeaderViews;
            android.widget.LinearLayout linearLayout2 = null;
            if (list == null || list.size() <= 0) {
                linearLayout = null;
            } else {
                linearLayout = new android.widget.LinearLayout(context);
                linearLayout.setOrientation(1);
                for (android.view.View view : this.mContentHeaderViews) {
                    if (view.getParent() != null) {
                        ((android.view.ViewGroup) view.getParent()).removeView(view);
                    }
                    linearLayout.addView(view, new android.widget.LinearLayout.LayoutParams(-1, -2));
                }
            }
            java.util.List<android.view.View> list2 = this.mContentFooterViews;
            if (list2 != null && list2.size() > 0) {
                linearLayout2 = new android.widget.LinearLayout(context);
                linearLayout2.setOrientation(1);
                for (android.view.View view2 : this.mContentFooterViews) {
                    if (view2.getParent() != null) {
                        ((android.view.ViewGroup) view2.getParent()).removeView(view2);
                    }
                    linearLayout2.addView(view2, new android.widget.LinearLayout.LayoutParams(-1, -2));
                }
            }
            this.adapter.setData(linearLayout, linearLayout2, this.mItems);
            this.adapter.setOnItemClickListener(new com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.OnItemClickListener() { // from class: com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder.2
                @Override // com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.OnItemClickListener
                public void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheetListAdapter.VH vh, int i, com.up366.qmui.widget.dialog.QMUIBottomSheetListItemModel qMUIBottomSheetListItemModel) {
                    if (com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder.this.mOnSheetItemClickListener != null) {
                        com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder.this.mOnSheetItemClickListener.onClick(qMUIBottomSheet, vh.itemView, i, qMUIBottomSheetListItemModel.tag);
                    }
                }
            });
            this.adapter.setCheckedIndex(this.mCheckedIndex);
            recyclerView.scrollToPosition(this.mCheckedIndex + (linearLayout == null ? 0 : 1));
            return recyclerView;
        }
    }

    public static class BottomGridSheetBuilder extends com.up366.qmui.widget.dialog.QMUIBottomSheetBaseBuilder<com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder> implements android.view.View.OnClickListener {
        public static final com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder.ItemViewFactory DEFAULT_ITEM_VIEW_FACTORY = new com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder.DefaultItemViewFactory();
        public static final int FIRST_LINE = 0;
        public static final int SECOND_LINE = 1;
        private java.util.ArrayList<com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel> mFirstLineItems;
        private com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder.ItemViewFactory mItemViewFactory;
        private com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder.OnSheetItemClickListener mOnSheetItemClickListener;
        private java.util.ArrayList<com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel> mSecondLineItems;

        public interface ItemViewFactory {
            com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemView create(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel qMUIBottomSheetGridItemModel);
        }

        public interface OnSheetItemClickListener {
            void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, android.view.View view);
        }

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        public @interface Style {
        }

        public static class DefaultItemViewFactory implements com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder.ItemViewFactory {
            @Override // com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder.ItemViewFactory
            public com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemView create(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel qMUIBottomSheetGridItemModel) {
                com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemView qMUIBottomSheetGridItemView = new com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemView(qMUIBottomSheet.getContext());
                qMUIBottomSheetGridItemView.render(qMUIBottomSheetGridItemModel);
                return qMUIBottomSheetGridItemView;
            }
        }

        public BottomGridSheetBuilder(android.content.Context context) {
            super(context);
            this.mItemViewFactory = DEFAULT_ITEM_VIEW_FACTORY;
            this.mFirstLineItems = new java.util.ArrayList<>();
            this.mSecondLineItems = new java.util.ArrayList<>();
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder addItem(com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel qMUIBottomSheetGridItemModel, int i) {
            if (i == 0) {
                this.mFirstLineItems.add(qMUIBottomSheetGridItemModel);
            } else if (i == 1) {
                this.mSecondLineItems.add(qMUIBottomSheetGridItemModel);
            }
            return this;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder addItem(int i, java.lang.CharSequence charSequence, int i2) {
            return addItem(i, charSequence, charSequence, i2, 0);
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder addItem(int i, java.lang.CharSequence charSequence, java.lang.Object obj, int i2) {
            return addItem(i, charSequence, obj, i2, 0);
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder addItem(int i, java.lang.CharSequence charSequence, java.lang.Object obj, int i2, int i3) {
            return addItem(i, charSequence, obj, i2, i3, null);
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder addItem(int i, java.lang.CharSequence charSequence, java.lang.Object obj, int i2, int i3, android.graphics.Typeface typeface) {
            return addItem(new com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel(charSequence, obj).image(i).subscript(i3).typeface(typeface), i2);
        }

        public void setItemViewFactory(com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder.ItemViewFactory itemViewFactory) {
            this.mItemViewFactory = itemViewFactory;
        }

        public com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder setOnSheetItemClickListener(com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder.OnSheetItemClickListener onSheetItemClickListener) {
            this.mOnSheetItemClickListener = onSheetItemClickListener;
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomGridSheetBuilder.OnSheetItemClickListener onSheetItemClickListener = this.mOnSheetItemClickListener;
            if (onSheetItemClickListener != null) {
                onSheetItemClickListener.onClick(this.mDialog, view);
            }
        }

        @Override // com.up366.qmui.widget.dialog.QMUIBottomSheetBaseBuilder
        protected android.view.View onCreateContentView(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.qmui.widget.dialog.QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, android.content.Context context) {
            java.util.ArrayList arrayList;
            java.util.ArrayList arrayList2 = null;
            if (this.mFirstLineItems.isEmpty() && this.mSecondLineItems.isEmpty()) {
                return null;
            }
            if (this.mFirstLineItems.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new java.util.ArrayList();
                java.util.Iterator<com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel> it = this.mFirstLineItems.iterator();
                while (it.hasNext()) {
                    com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemView qMUIBottomSheetGridItemViewCreate = this.mItemViewFactory.create(qMUIBottomSheet, it.next());
                    qMUIBottomSheetGridItemViewCreate.setOnClickListener(this);
                    arrayList.add(new android.util.Pair(qMUIBottomSheetGridItemViewCreate, new android.widget.LinearLayout.LayoutParams(-2, -2)));
                }
            }
            if (!this.mSecondLineItems.isEmpty()) {
                arrayList2 = new java.util.ArrayList();
                java.util.Iterator<com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemModel> it2 = this.mSecondLineItems.iterator();
                while (it2.hasNext()) {
                    com.up366.qmui.widget.dialog.QMUIBottomSheetGridItemView qMUIBottomSheetGridItemViewCreate2 = this.mItemViewFactory.create(qMUIBottomSheet, it2.next());
                    qMUIBottomSheetGridItemViewCreate2.setOnClickListener(this);
                    arrayList2.add(new android.util.Pair(qMUIBottomSheetGridItemViewCreate2, new android.widget.LinearLayout.LayoutParams(-2, -2)));
                }
            }
            return new com.up366.qmui.widget.dialog.QMUIBottomSheetGridLineLayout(this.mDialog, arrayList, arrayList2);
        }
    }
}
