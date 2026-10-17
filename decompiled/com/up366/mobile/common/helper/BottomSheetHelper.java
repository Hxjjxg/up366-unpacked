package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BottomSheetHelper {
    private java.lang.String bottomBtn;
    private java.util.List<com.up366.mobile.common.views.bottomsheet.BottomSheetModel> contents;
    private final android.content.Context context;
    private android.content.DialogInterface.OnDismissListener dismissListener;
    private com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener footerListener;
    private android.view.View footerView;
    private boolean itemDisSelectedVisible;
    private com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener itemListener;
    private java.lang.String title;
    private boolean itemClickDismiss = true;
    private com.up366.qmui.widget.dialog.QMUIBottomSheet bottomSheet = null;
    private int marginStart = 0;

    public interface OnClickListener<T> {
        void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, com.up366.mobile.common.views.bottomsheet.BottomSheetModel<T> bottomSheetModel);
    }

    public BottomSheetHelper(android.content.Context context) {
        this.context = context;
    }

    public void show() {
        final com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder bottomListSheetBuilder = new com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder(this.context);
        bottomListSheetBuilder.setNeedRightMark(true).setAllowDrag(true).setCheckedIndex(-1).setRightMarkSelectedFalseVisible(this.itemDisSelectedVisible).setOnSheetItemClickListener(new com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder.OnSheetItemClickListener() { // from class: com.up366.mobile.common.helper.BottomSheetHelper$$ExternalSyntheticLambda0
            @Override // com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder.OnSheetItemClickListener
            public final void onClick(com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, android.view.View view, int i, java.lang.String str) {
                this.f$0.lambda$show$0(bottomListSheetBuilder, qMUIBottomSheet, view, i, str);
            }
        }).setOnBottomDialogDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.helper.BottomSheetHelper$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                this.f$0.lambda$show$1(dialogInterface);
            }
        });
        addHeadView(bottomListSheetBuilder);
        addFooterView(bottomListSheetBuilder);
        addContentView(bottomListSheetBuilder);
        com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheetBuild = bottomListSheetBuilder.build();
        this.bottomSheet = qMUIBottomSheetBuild;
        qMUIBottomSheetBuild.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$0(com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder bottomListSheetBuilder, com.up366.qmui.widget.dialog.QMUIBottomSheet qMUIBottomSheet, android.view.View view, int i, java.lang.String str) {
        if (this.itemClickDismiss) {
            qMUIBottomSheet.dismiss();
        }
        com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener onClickListener = this.itemListener;
        if (onClickListener != null) {
            onClickListener.onClick(qMUIBottomSheet, this.contents.get(i));
        }
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < this.contents.size()) {
                com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel = this.contents.get(i2);
                if (i2 != i) {
                    z = false;
                }
                bottomSheetModel.setSelected(z);
                i2++;
            } else {
                this.contents.get(i).setSelected(true);
                bottomListSheetBuilder.updateCheckedIndex(i);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$1(android.content.DialogInterface dialogInterface) {
        android.content.DialogInterface.OnDismissListener onDismissListener = this.dismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public com.up366.qmui.widget.dialog.QMUIBottomSheet getBottomSheet() {
        return this.bottomSheet;
    }

    public void setTitleMarginStart(int i) {
        this.marginStart = i;
    }

    private void addContentView(com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder bottomListSheetBuilder) {
        for (com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel : this.contents) {
            if (bottomSheetModel.isSelected()) {
                bottomListSheetBuilder.setCheckedIndex(this.contents.indexOf(bottomSheetModel));
            }
            if (bottomSheetModel.getDrawableId() == 0) {
                bottomListSheetBuilder.addItem(bottomSheetModel.getContent());
            } else {
                bottomListSheetBuilder.addItem(this.context.getResources().getDrawable(bottomSheetModel.getDrawableId()), bottomSheetModel.getContent());
            }
        }
    }

    private void addHeadView(com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder bottomListSheetBuilder) {
        if (com.up366.common.StringUtils.isEmptyOrNull(this.title)) {
            return;
        }
        com.up366.mobile.common.views.bottomsheet.BottomSheetHeaderView bottomSheetHeaderView = new com.up366.mobile.common.views.bottomsheet.BottomSheetHeaderView(this.context);
        bottomSheetHeaderView.setTitleText(this.title);
        int i = this.marginStart;
        if (i > 0) {
            bottomSheetHeaderView.setMarginStart(i);
        }
        bottomSheetHeaderView.setCloseClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.helper.BottomSheetHelper$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$addHeadView$2(view);
            }
        });
        bottomListSheetBuilder.setHeaderView(bottomSheetHeaderView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addHeadView$2(android.view.View view) {
        this.bottomSheet.dismiss();
    }

    private void addFooterView(com.up366.qmui.widget.dialog.QMUIBottomSheet.BottomListSheetBuilder bottomListSheetBuilder) {
        if (!com.up366.common.StringUtils.isEmptyOrNull(this.bottomBtn)) {
            com.up366.mobile.common.views.bottomsheet.BottomSheetFooterView bottomSheetFooterView = new com.up366.mobile.common.views.bottomsheet.BottomSheetFooterView(this.context);
            bottomSheetFooterView.setButton(this.bottomBtn, new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.helper.BottomSheetHelper$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.lambda$addFooterView$3(view);
                }
            });
            bottomListSheetBuilder.addContentFooterView(bottomSheetFooterView);
        } else {
            android.view.View view = this.footerView;
            if (view != null) {
                bottomListSheetBuilder.addContentFooterView(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addFooterView$3(android.view.View view) {
        com.up366.mobile.common.views.bottomsheet.BottomSheetModel bottomSheetModel = new com.up366.mobile.common.views.bottomsheet.BottomSheetModel();
        java.util.Iterator<com.up366.mobile.common.views.bottomsheet.BottomSheetModel> it = this.contents.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.up366.mobile.common.views.bottomsheet.BottomSheetModel next = it.next();
            if (next.isSelected()) {
                bottomSheetModel = next;
                break;
            }
        }
        com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener onClickListener = this.footerListener;
        if (onClickListener != null) {
            onClickListener.onClick(this.bottomSheet, bottomSheetModel);
        }
    }

    public com.up366.mobile.common.helper.BottomSheetHelper setTitle(java.lang.String str) {
        this.title = str;
        return this;
    }

    public com.up366.mobile.common.helper.BottomSheetHelper setFooterView(android.view.View view) {
        this.footerView = view;
        return this;
    }

    public com.up366.mobile.common.helper.BottomSheetHelper setContents(java.util.List<com.up366.mobile.common.views.bottomsheet.BottomSheetModel> list) {
        this.contents = list;
        return this;
    }

    public com.up366.mobile.common.helper.BottomSheetHelper setItemClickListener(com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener<?> onClickListener) {
        this.itemListener = onClickListener;
        return this;
    }

    public com.up366.mobile.common.helper.BottomSheetHelper setOnDismissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
        this.dismissListener = onDismissListener;
        return this;
    }

    public com.up366.mobile.common.helper.BottomSheetHelper setItemDisSelectedVisible(boolean z) {
        this.itemDisSelectedVisible = z;
        return this;
    }

    public com.up366.mobile.common.helper.BottomSheetHelper setBottomBtn(java.lang.String str) {
        this.bottomBtn = str;
        return this;
    }

    public com.up366.mobile.common.helper.BottomSheetHelper setFooterListener(com.up366.mobile.common.helper.BottomSheetHelper.OnClickListener<?> onClickListener) {
        this.footerListener = onClickListener;
        return this;
    }

    public com.up366.mobile.common.helper.BottomSheetHelper setItemClickDismiss(boolean z) {
        this.itemClickDismiss = z;
        return this;
    }
}
