package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TitleBarDropDownDialogRight {
    private final android.content.Context context;
    private int offsetX = 0;
    private final android.view.View view;

    public TitleBarDropDownDialogRight(android.view.View view) {
        this.context = view.getContext();
        this.view = view;
    }

    public void show(java.util.List<com.up366.mobile.common.views.TitleBarDropDownDialogRight.MenuHolder> list) {
        final androidx.appcompat.app.AppCompatDialog appCompatDialog = new androidx.appcompat.app.AppCompatDialog(this.context, com.up366.mobile.R.style.TitleBarTopRightDropDown);
        final android.view.View viewInflate = android.view.LayoutInflater.from(this.context).inflate(com.up366.mobile.R.layout.dropdown_layout_arrow_small, (android.view.ViewGroup) null);
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) viewInflate.findViewById(com.up366.mobile.R.id.recycleView);
        initTitleMenus(appCompatDialog, recyclerView, list);
        appCompatDialog.setContentView(viewInflate);
        final android.view.Window window = appCompatDialog.getWindow();
        if (window != null) {
            final android.view.View decorView = window.getDecorView();
            window.setGravity(8388661);
            ((android.widget.FrameLayout.LayoutParams) viewInflate.getLayoutParams()).setMargins(0, 0, com.up366.common.DpUtilsUp.dp2px(20.0f) - this.offsetX, 0);
            window.getDecorView().setBackgroundColor(16777215);
            window.getDecorView().setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.up366.mobile.common.views.TitleBarDropDownDialogRight$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    return com.up366.mobile.common.views.TitleBarDropDownDialogRight.lambda$show$0(appCompatDialog, view, motionEvent);
                }
            });
            final int[] iArr = new int[1];
            window.getDecorView().setPadding(decorView.getPaddingLeft(), iArr[0], decorView.getPaddingRight() / 4, decorView.getPaddingBottom());
            recyclerView.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() { // from class: com.up366.mobile.common.views.TitleBarDropDownDialogRight$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    this.f$0.lambda$show$1(viewInflate, iArr, window, decorView, view, i, i2, i3, i4, i5, i6, i7, i8);
                }
            });
        }
        appCompatDialog.show();
    }

    static /* synthetic */ boolean lambda$show$0(android.app.Dialog dialog, android.view.View view, android.view.MotionEvent motionEvent) {
        dialog.dismiss();
        return view.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$1(android.view.View view, int[] iArr, android.view.Window window, android.view.View view2, android.view.View view3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i9 = iArr2[1];
        this.view.getLocationOnScreen(iArr2);
        int height = iArr2[1] + this.view.getHeight();
        if (i9 != height) {
            iArr[0] = iArr[0] + (height - i9);
            window.getDecorView().setPadding(view2.getPaddingLeft(), iArr[0], view2.getPaddingRight() / 4, view2.getPaddingBottom());
        }
    }

    private void initTitleMenus(android.app.Dialog dialog, androidx.recyclerview.widget.RecyclerView recyclerView, java.util.List<com.up366.mobile.common.views.TitleBarDropDownDialogRight.MenuHolder> list) {
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(this.context));
        recyclerView.addItemDecoration(new com.up366.mobile.common.views.RecyclerViewDivider(this.context).height(1).color(1722460842));
        recyclerView.setAdapter(new com.up366.mobile.common.views.TitleBarDropDownDialogRight.AnonymousClass1(list, dialog));
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.views.TitleBarDropDownDialogRight$1, reason: invalid class name */
    class AnonymousClass1 extends com.up366.mobile.common.base.BaseRecyclerAdapter {
        final /* synthetic */ android.app.Dialog val$dialog;
        final /* synthetic */ java.util.List val$menus;

        @Override // com.up366.mobile.common.base.BaseRecyclerAdapter
        public int getItemViewType(int i) {
            return 1;
        }

        AnonymousClass1(java.util.List list, android.app.Dialog dialog) {
            this.val$menus = list;
            this.val$dialog = dialog;
        }

        public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(inflate(com.up366.mobile.R.layout.titleview_dropdown_layout_item));
        }

        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
            final com.up366.mobile.common.views.TitleBarDropDownDialogRight.MenuHolder menuHolder = (com.up366.mobile.common.views.TitleBarDropDownDialogRight.MenuHolder) this.val$menus.get(i);
            ((android.widget.TextView) viewHolder.itemView.findViewById(2131362710)).setText(menuHolder.name);
            android.view.View viewFindViewById = viewHolder.itemView.findViewById(2131362710);
            final android.app.Dialog dialog = this.val$dialog;
            viewFindViewById.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.TitleBarDropDownDialogRight$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.common.views.TitleBarDropDownDialogRight.AnonymousClass1.lambda$onBindViewHolder$0(menuHolder, dialog, view);
                }
            });
        }

        static /* synthetic */ void lambda$onBindViewHolder$0(com.up366.mobile.common.views.TitleBarDropDownDialogRight.MenuHolder menuHolder, android.app.Dialog dialog, android.view.View view) {
            menuHolder.listener.onClick(view);
            dialog.dismiss();
        }

        @Override // com.up366.mobile.common.base.BaseRecyclerAdapter
        public int getItemCount() {
            return this.val$menus.size();
        }
    }

    public void setOffset(int i) {
        this.offsetX = i;
    }

    public static class MenuHolder {
        public boolean isChecked;
        public android.view.View.OnClickListener listener;
        public java.lang.String name;

        public MenuHolder(java.lang.String str, android.view.View.OnClickListener onClickListener) {
            this.name = str;
            this.listener = onClickListener;
        }
    }
}
