package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TitleBarView extends com.google.android.material.appbar.AppBarLayout {
    public com.up366.mobile.databinding.TitleBarViewLayoutBinding binding;
    private float elevation;
    private boolean hasStatusBar;
    private boolean lightMode;
    private int[] location;
    private java.util.List<com.up366.mobile.common.views.TitleBarView.MenuHolder> menus;
    private java.util.List<com.up366.mobile.common.views.TitleBarView.MenuHolder> menusRight;
    private android.content.DialogInterface.OnDismissListener menusRightDismissListener;
    private boolean showBack;
    private boolean showFindCourse;
    private boolean showMessage;
    private boolean showTitle;
    private int statusBarHeight;
    private int titleColor;
    private java.lang.String titleContent;
    private int type;
    private android.view.Window window;

    public TitleBarView(android.content.Context context) {
        super(context);
        this.type = 0;
        this.showFindCourse = false;
        this.showMessage = false;
        this.showBack = true;
        this.showTitle = true;
        this.titleColor = 0;
        this.lightMode = false;
        this.menus = new java.util.ArrayList();
        this.menusRight = new java.util.ArrayList();
        this.location = new int[2];
        init(context, null, 0);
    }

    public TitleBarView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.type = 0;
        this.showFindCourse = false;
        this.showMessage = false;
        this.showBack = true;
        this.showTitle = true;
        this.titleColor = 0;
        this.lightMode = false;
        this.menus = new java.util.ArrayList();
        this.menusRight = new java.util.ArrayList();
        this.location = new int[2];
        init(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        setClipChildren(false);
        this.binding = (com.up366.mobile.databinding.TitleBarViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.title_bar_view_layout, this, true);
        if (attributeSet != null) {
            android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.TitleBarView);
            this.type = typedArrayObtainStyledAttributes.getInt(1, 0);
            this.showBack = typedArrayObtainStyledAttributes.getBoolean(4, true);
            this.showMessage = typedArrayObtainStyledAttributes.getBoolean(6, false);
            this.showFindCourse = typedArrayObtainStyledAttributes.getBoolean(5, false);
            typedArrayObtainStyledAttributes.getBoolean(3, false);
            this.showTitle = typedArrayObtainStyledAttributes.getBoolean(8, true);
            this.lightMode = typedArrayObtainStyledAttributes.getBoolean(2, false);
            this.titleContent = typedArrayObtainStyledAttributes.getString(10);
            this.titleColor = typedArrayObtainStyledAttributes.getColor(9, com.up366.qmui.widget.QMUIProgressBar.DEFAULT_TEXT_COLOR);
            this.elevation = typedArrayObtainStyledAttributes.getDimension(0, getContext().getResources().getDimension(com.up366.mobile.R.dimen.title_bar_elevation));
            typedArrayObtainStyledAttributes.recycle();
        }
        com.up366.mobile.common.utils.ViewUtil.gone(this.binding.back, this.binding.message, this.binding.findCourse, this.binding.title, this.binding.arrow, this.binding.rightText, this.binding.rightIcon, this.binding.leftText);
        if (this.showMessage) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.message);
        }
        if (this.showBack) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.back);
        }
        if (this.showFindCourse) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.findCourse);
        }
        if (this.showTitle) {
            com.up366.mobile.common.utils.ViewUtil.visible(this.binding.title);
            if (!com.up366.common.StringUtils.isEmptyOrNull(this.titleContent)) {
                this.binding.title.setText(this.titleContent);
            }
        }
        setType(this.type);
        this.binding.title.setTextColor(this.titleColor);
        if (android.os.Build.MODEL.contains("OPPO R9s") || android.os.Build.MODEL.contains("G750-T01")) {
            android.view.ViewGroup.LayoutParams layoutParams = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) this.binding.title.getLayoutParams();
            ((androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) layoutParams).width = com.up366.common.DpUtilsUp.dp2px(350.0f);
            this.binding.title.setLayoutParams(layoutParams);
        }
        setUpStatusBarLightMode(this.lightMode);
        this.binding.line.setVisibility(4);
        android.animation.StateListAnimator stateListAnimator = new android.animation.StateListAnimator();
        stateListAnimator.addState(new int[]{android.R.attr.enabled}, android.animation.ObjectAnimator.ofFloat(this, "elevation", this.elevation).setDuration(300L));
        stateListAnimator.addState(new int[0], android.animation.ObjectAnimator.ofFloat(this, "elevation", this.elevation).setDuration(0L));
        setStateListAnimator(stateListAnimator);
        this.statusBarHeight = 0;
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.statusBarHeight = getResources().getDimensionPixelSize(identifier);
        }
    }

    public void setType(int i) {
        this.type = i;
        if (i == 0) {
            this.binding.back.setType(1);
            this.binding.message.setIconType(1);
            this.binding.findCourse.setType(1);
            this.binding.arrow.setImageResource(com.up366.mobile.R.drawable.title_arrow_white);
            return;
        }
        this.binding.back.setType(0);
        this.binding.message.setIconType(0);
        this.binding.findCourse.setType(0);
        this.binding.arrow.setImageResource(com.up366.mobile.R.drawable.title_arrow_dark);
    }

    public void addDropDownMenuItem(java.lang.String str, android.view.View.OnClickListener onClickListener) {
        if (this.menus.size() == 0) {
            this.binding.arrow.setVisibility(0);
            this.binding.title.getLayoutParams().width = -2;
            this.binding.title.setMaxWidth(com.up366.common.DpUtilsUp.dp2px(200.0f));
            this.binding.title.setPadding(0, 0, 0, 0);
            this.binding.title.requestLayout();
            com.up366.mobile.common.utils.ViewUtil.bindOnClickListener((android.view.View) this.binding.title, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.TitleBarView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$addDropDownMenuItem$0(view);
                }
            });
            com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(this.binding.arrow, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.TitleBarView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$addDropDownMenuItem$1(view);
                }
            });
        }
        this.menus.add(new com.up366.mobile.common.views.TitleBarView.MenuHolder(str, onClickListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addDropDownMenuItem$0(android.view.View view) {
        showDropDownMenus(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addDropDownMenuItem$1(android.view.View view) {
        showDropDownMenus(1);
    }

    public void showArrow() {
        this.binding.arrow.setVisibility(0);
        this.binding.title.getLayoutParams().width = -2;
        this.binding.title.setMaxWidth(com.up366.common.DpUtilsUp.dp2px(200.0f));
        this.binding.title.setPadding(0, 0, 0, 0);
        this.binding.title.requestLayout();
    }

    public void removeDropDownMenuItem() {
        if (this.menus.size() != 0) {
            this.menus.clear();
        }
    }

    public void removeRightDropDownMenuItem() {
        if (this.menusRight.size() != 0) {
            this.menusRight.clear();
        }
    }

    public void addRightDropDownMenuItem(java.lang.String str, android.view.View.OnClickListener onClickListener) {
        this.menusRight.add(new com.up366.mobile.common.views.TitleBarView.MenuHolder(str, onClickListener));
    }

    public void setRightDropDownMenuDissmissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
        this.menusRightDismissListener = onDismissListener;
    }

    public void showRightDropDownMenu() {
        showDropDownMenus(0);
    }

    public void showRightDropDownMenu(int i, int i2, int i3, int i4, java.lang.String str) {
        showDropDownMenus(0, i, i2, i3, i4, str);
    }

    private void showDropDownMenus(int i) {
        showDropDownMenus(i, 0, -1, getContext().getResources().getColor(com.up366.mobile.R.color.textBlack), -1, "");
    }

    private void showDropDownMenus(final int i, int i2, int i3, int i4, int i5, java.lang.String str) {
        android.view.View viewInflate;
        final androidx.appcompat.app.AppCompatDialog appCompatDialog = new androidx.appcompat.app.AppCompatDialog(getContext(), com.up366.mobile.R.style.TitleBarDropDown);
        if (i == 1) {
            com.up366.mobile.common.utils.AnimUtils.roate1(this.binding.arrow);
            viewInflate = android.view.LayoutInflater.from(getContext()).inflate(com.up366.mobile.R.layout.titleview_dropdown_layout, (android.view.ViewGroup) null);
        } else {
            viewInflate = android.view.LayoutInflater.from(getContext()).inflate(com.up366.mobile.R.layout.titleview_dropdown_layout_arrow, (android.view.ViewGroup) null);
        }
        android.view.View view = viewInflate;
        if (i3 != -1) {
            view.findViewById(com.up366.mobile.R.id.recycleView).setBackgroundColor(i3);
            view.findViewById(com.up366.mobile.R.id.dropdown_upview).setBackgroundColor(i3);
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) view.findViewById(com.up366.mobile.R.id.recycleView);
        if (i2 != 0) {
            recyclerView.setMinimumWidth(i2);
        }
        initTitleMenus(i, appCompatDialog, recyclerView, i4, i5, str);
        appCompatDialog.setContentView(view);
        android.view.Window window = appCompatDialog.getWindow();
        if (window != null) {
            android.view.View decorView = window.getDecorView();
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.title_bar_height);
            if (i == 1) {
                window.setGravity(48);
                window.getDecorView().setPadding(0, dimensionPixelSize, 0, decorView.getPaddingBottom());
                android.graphics.Point point = new android.graphics.Point();
                window.getWindowManager().getDefaultDisplay().getSize(point);
                view.getLayoutParams().width = point.x;
            } else {
                window.setGravity(8388661);
                window.getDecorView().setPadding(decorView.getPaddingLeft(), dimensionPixelSize, decorView.getPaddingRight() / 4, decorView.getPaddingBottom());
            }
            window.getDecorView().setBackgroundColor(16777215);
            window.getDecorView().setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.up366.mobile.common.views.TitleBarView$$ExternalSyntheticLambda3
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(android.view.View view2, android.view.MotionEvent motionEvent) {
                    return com.up366.mobile.common.views.TitleBarView.lambda$showDropDownMenus$2(appCompatDialog, view2, motionEvent);
                }
            });
        }
        appCompatDialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.views.TitleBarView$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                this.f$0.lambda$showDropDownMenus$3(i, appCompatDialog, dialogInterface);
            }
        });
        appCompatDialog.show();
    }

    static /* synthetic */ boolean lambda$showDropDownMenus$2(android.app.Dialog dialog, android.view.View view, android.view.MotionEvent motionEvent) {
        dialog.dismiss();
        return view.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDropDownMenus$3(int i, android.app.Dialog dialog, android.content.DialogInterface dialogInterface) {
        if (i == 1) {
            com.up366.mobile.common.utils.AnimUtils.roate2(this.binding.arrow);
        }
        android.content.DialogInterface.OnDismissListener onDismissListener = this.menusRightDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }

    private void initTitleMenus(int i, android.app.Dialog dialog, androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3, java.lang.String str) {
        recyclerView.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new com.up366.mobile.common.views.RecyclerViewDivider(getContext()).height(1).color(1722460842).padding(com.up366.common.DpUtilsUp.dp2px(10.0f)));
        recyclerView.setAdapter(new com.up366.mobile.common.views.TitleBarView.AnonymousClass1(i, i2, str, i3, dialog));
    }

    /* JADX INFO: renamed from: com.up366.mobile.common.views.TitleBarView$1, reason: invalid class name */
    class AnonymousClass1 extends com.up366.mobile.common.base.BaseRecyclerAdapter {
        final /* synthetic */ android.app.Dialog val$dialog;
        final /* synthetic */ java.lang.String val$selContent;
        final /* synthetic */ int val$selTextColor;
        final /* synthetic */ int val$textColor;
        final /* synthetic */ int val$type;

        @Override // com.up366.mobile.common.base.BaseRecyclerAdapter
        public int getItemViewType(int i) {
            return 1;
        }

        AnonymousClass1(int i, int i2, java.lang.String str, int i3, android.app.Dialog dialog) {
            this.val$type = i;
            this.val$textColor = i2;
            this.val$selContent = str;
            this.val$selTextColor = i3;
            this.val$dialog = dialog;
        }

        public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(inflate(viewGroup, com.up366.mobile.R.layout.titleview_dropdown_layout_item));
        }

        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
            final com.up366.mobile.common.views.TitleBarView.MenuHolder menuHolder;
            if (this.val$type == 1) {
                menuHolder = (com.up366.mobile.common.views.TitleBarView.MenuHolder) com.up366.mobile.common.views.TitleBarView.this.menus.get(i);
            } else {
                menuHolder = (com.up366.mobile.common.views.TitleBarView.MenuHolder) com.up366.mobile.common.views.TitleBarView.this.menusRight.get(i);
            }
            android.widget.TextView textView = (android.widget.TextView) viewHolder.itemView.findViewById(2131362710);
            if (this.val$type == 1) {
                textView.setGravity(17);
            }
            textView.setTextColor(this.val$textColor);
            if (menuHolder.name.equals(this.val$selContent)) {
                textView.setTextColor(this.val$selTextColor);
            }
            textView.setText(menuHolder.name);
            android.view.View viewFindViewById = viewHolder.itemView.findViewById(2131362710);
            final android.app.Dialog dialog = this.val$dialog;
            viewFindViewById.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.TitleBarView$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.common.views.TitleBarView.AnonymousClass1.lambda$onBindViewHolder$0(menuHolder, dialog, view);
                }
            });
        }

        static /* synthetic */ void lambda$onBindViewHolder$0(com.up366.mobile.common.views.TitleBarView.MenuHolder menuHolder, android.app.Dialog dialog, android.view.View view) {
            menuHolder.listener.onClick(view);
            dialog.dismiss();
        }

        @Override // com.up366.mobile.common.base.BaseRecyclerAdapter
        public int getItemCount() {
            if (this.val$type == 1) {
                return com.up366.mobile.common.views.TitleBarView.this.menus.size();
            }
            return com.up366.mobile.common.views.TitleBarView.this.menusRight.size();
        }
    }

    public void setBackgroundAlpha(float f) {
        setAlpha(f);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        getLocationOnScreen(this.location);
        post(new java.lang.Runnable() { // from class: com.up366.mobile.common.views.TitleBarView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onLayout$4();
            }
        });
        super.onLayout(z, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLayout$4() {
        this.binding.getRoot().setPadding(0, this.location[1] > 0 ? 0 : this.statusBarHeight, 0, 0);
    }

    public void setTitleColor(int i) {
        this.binding.title.setTextColor(i);
    }

    public void showTitle(boolean z) {
        this.binding.title.setVisibility(z ? 0 : 8);
    }

    public void showMessage(boolean z) {
        this.binding.message.setVisibility(z ? 0 : 8);
    }

    public void showFindCourse(boolean z) {
        this.binding.findCourse.setVisibility(z ? 0 : 8);
    }

    public void showBack(boolean z) {
        this.binding.back.setVisibility(z ? 0 : 8);
    }

    public void setBackImageResource(int i) {
        this.binding.back.setImageResource(i);
    }

    public void setTitle(java.lang.String str) {
        this.binding.title.setText(str);
    }

    protected void onMeasure(int i, int i2) {
        android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i), 0);
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.title_bar_height), 0);
        getLocationOnScreen(this.location);
        if (this.location[1] <= 0) {
            iMakeMeasureSpec += this.statusBarHeight;
        }
        this.binding.getRoot().setPadding(0, this.location[1] > 0 ? 0 : this.statusBarHeight, 0, 0);
        super.onMeasure(i, iMakeMeasureSpec);
    }

    private void setStatusBarLightMode(boolean z) {
        this.lightMode = z;
        if (this.binding.getRoot().getBackground() == null) {
            this.binding.getRoot().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable() { // from class: com.up366.mobile.common.views.TitleBarView.2
                android.graphics.Paint paint = new android.graphics.Paint(1);

                @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
                public void draw(android.graphics.Canvas canvas) {
                    if (!android.os.Build.MODEL.equals("SM-N9008S") && !com.up366.mobile.common.utils.PlatformUtils.isHorizontalWideScreen(com.up366.mobile.common.views.TitleBarView.this.getActivity()) && com.up366.mobile.common.views.TitleBarView.this.lightMode && com.up366.mobile.common.views.TitleBarView.this.location[1] == 0) {
                        this.paint.setColor(855638016);
                        this.paint.setStyle(android.graphics.Paint.Style.FILL);
                        canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), com.up366.mobile.common.views.TitleBarView.this.statusBarHeight, this.paint);
                    }
                }
            });
        }
        this.binding.getRoot().postInvalidate();
    }

    public void setUpStatusBarLightMode(boolean z) {
        if (isInEditMode()) {
            return;
        }
        int i = z ? 9216 : 1024;
        if (this.window == null) {
            this.window = getActivity().getWindow();
        }
        this.window.getDecorView().setSystemUiVisibility(i);
    }

    public void setOnBackClickListener(android.view.View.OnClickListener onClickListener) {
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener((android.view.View) this.binding.back, onClickListener);
    }

    public void setWindow(android.view.Window window) {
        this.window = window;
    }

    public android.app.Activity getActivity() {
        android.content.Context context = getContext();
        if (context instanceof android.app.Activity) {
            return (android.app.Activity) context;
        }
        if (context instanceof android.content.ContextWrapper) {
            return (android.app.Activity) ((android.content.ContextWrapper) getContext()).getBaseContext();
        }
        return com.up366.common.global.GB.get().getCurrentActivity();
    }

    public void addRightButton(int i, android.view.View.OnClickListener onClickListener) {
        this.binding.rightIcon.setImageResource(i);
        com.up366.mobile.common.utils.ViewUtil.bindOnClickListener((android.view.View) this.binding.rightIcon, onClickListener);
        showRightButton(true);
    }

    public void showRightButton(boolean z) {
        this.binding.rightIcon.setVisibility(z ? 0 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class MenuHolder {
        android.view.View.OnClickListener listener;
        java.lang.String name;

        MenuHolder(java.lang.String str, android.view.View.OnClickListener onClickListener) {
            this.name = str;
            this.listener = onClickListener;
        }
    }
}
