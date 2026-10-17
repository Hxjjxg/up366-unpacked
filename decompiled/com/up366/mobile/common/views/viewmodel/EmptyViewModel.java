package com.up366.mobile.common.views.viewmodel;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class EmptyViewModel {
    public static final int TYPE_DEFAULT = -1;
    public static final int TYPE_NO_DATA = 3;
    public static final int TYPE_NO_NETWORK = 1;
    public static final int TYPE_SYSTEM_ERROR = 2;
    private boolean isLoading;
    private java.lang.String leftBtn;
    private android.view.View.OnClickListener leftBtnListener;
    private java.lang.String rightBtn;
    private android.view.View.OnClickListener rightBtnListener;
    private int tipImage;
    private java.lang.String tipMessage;

    private EmptyViewModel() {
    }

    public int getTipImage() {
        return this.tipImage;
    }

    public java.lang.String getTipMessage() {
        return this.tipMessage;
    }

    public java.lang.String getLeftBtn() {
        return this.leftBtn;
    }

    public java.lang.String getRightBtn() {
        return this.rightBtn;
    }

    public android.view.View.OnClickListener getLeftBtnListener() {
        return this.leftBtnListener;
    }

    public android.view.View.OnClickListener getRightBtnListener() {
        return this.rightBtnListener;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.up366.mobile.common.views.viewmodel.EmptyViewModel emptyViewModel = (com.up366.mobile.common.views.viewmodel.EmptyViewModel) obj;
        if (this.tipImage != emptyViewModel.tipImage || this.isLoading != emptyViewModel.isLoading) {
            return false;
        }
        java.lang.String str = this.tipMessage;
        if (str == null ? emptyViewModel.tipMessage != null : !str.equals(emptyViewModel.tipMessage)) {
            return false;
        }
        java.lang.String str2 = this.leftBtn;
        if (str2 == null ? emptyViewModel.leftBtn != null : !str2.equals(emptyViewModel.leftBtn)) {
            return false;
        }
        java.lang.String str3 = this.rightBtn;
        if (str3 == null ? emptyViewModel.rightBtn != null : !str3.equals(emptyViewModel.rightBtn)) {
            return false;
        }
        android.view.View.OnClickListener onClickListener = this.leftBtnListener;
        if (onClickListener == null ? emptyViewModel.leftBtnListener != null : !onClickListener.equals(emptyViewModel.leftBtnListener)) {
            return false;
        }
        android.view.View.OnClickListener onClickListener2 = this.rightBtnListener;
        android.view.View.OnClickListener onClickListener3 = emptyViewModel.rightBtnListener;
        return onClickListener2 != null ? onClickListener2.equals(onClickListener3) : onClickListener3 == null;
    }

    public int hashCode() {
        int i = this.tipImage * 31;
        java.lang.String str = this.tipMessage;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.leftBtn;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.rightBtn;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        android.view.View.OnClickListener onClickListener = this.leftBtnListener;
        int iHashCode4 = (iHashCode3 + (onClickListener != null ? onClickListener.hashCode() : 0)) * 31;
        android.view.View.OnClickListener onClickListener2 = this.rightBtnListener;
        return ((iHashCode4 + (onClickListener2 != null ? onClickListener2.hashCode() : 0)) * 31) + (this.isLoading ? 1 : 0);
    }

    public static class Builder {
        private boolean isLoading;
        private java.lang.String leftBtn;
        private android.view.View.OnClickListener leftBtnListener;
        private java.lang.String rightBtn;
        private android.view.View.OnClickListener rightBtnListener;
        private int tipImage;
        private java.lang.String tipMessage;
        private int type = -1;

        public com.up366.mobile.common.views.viewmodel.EmptyViewModel build() {
            int i = this.type;
            if (i == 1) {
                noNetworkModel();
            } else if (i == 2) {
                systemError();
            } else if (i == 3) {
                noData();
            }
            com.up366.mobile.common.views.viewmodel.EmptyViewModel emptyViewModel = new com.up366.mobile.common.views.viewmodel.EmptyViewModel();
            emptyViewModel.isLoading = this.isLoading;
            emptyViewModel.leftBtn = this.leftBtn;
            emptyViewModel.leftBtnListener = this.leftBtnListener;
            emptyViewModel.rightBtn = this.rightBtn;
            emptyViewModel.rightBtnListener = this.rightBtnListener;
            emptyViewModel.tipImage = this.tipImage;
            emptyViewModel.tipMessage = this.tipMessage;
            return emptyViewModel;
        }

        private void noData() {
            this.tipImage = com.up366.mobile.R.drawable.bg_empty_state5;
            this.tipMessage = "没有数据";
        }

        private void noNetworkModel() {
            this.tipImage = com.up366.mobile.R.drawable.bg_empty_state6;
            this.tipMessage = "啊！不要啊！网络怎么可以这么差！";
            this.leftBtn = "查看帮助";
            this.rightBtn = "点击重试";
            this.leftBtnListener = new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.viewmodel.EmptyViewModel$Builder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    com.up366.mobile.commonui.LookHelpActivity.openPage(view.getContext());
                }
            };
            if (this.rightBtnListener == null) {
                this.rightBtnListener = new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.viewmodel.EmptyViewModel$Builder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        com.up366.mobile.common.utils.ToastPopupUtil.show("需要自定义事件");
                    }
                };
            }
        }

        public void systemError() {
            this.tipImage = com.up366.mobile.R.drawable.bg_empty_state4;
            this.tipMessage = "服务器异常，请稍后重试哦~";
            this.rightBtn = "点击重试";
            if (this.rightBtnListener == null) {
                this.rightBtnListener = new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.viewmodel.EmptyViewModel$Builder$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(android.view.View view) {
                        com.up366.mobile.common.utils.ToastPopupUtil.show("需要自定义事件");
                    }
                };
            }
        }

        public com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder setTipImage(int i) {
            this.tipImage = i;
            return this;
        }

        public com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder setTipMessage(java.lang.String str) {
            this.tipMessage = str;
            return this;
        }

        public com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder setLeftBtn(java.lang.String str) {
            this.leftBtn = str;
            return this;
        }

        public com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder setRightBtn(java.lang.String str) {
            this.rightBtn = str;
            return this;
        }

        public com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder setLeftBtnListener(android.view.View.OnClickListener onClickListener) {
            this.leftBtnListener = onClickListener;
            return this;
        }

        public com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder setRightBtnListener(android.view.View.OnClickListener onClickListener) {
            this.rightBtnListener = onClickListener;
            return this;
        }

        public com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder setLoading(boolean z) {
            this.isLoading = z;
            return this;
        }

        public com.up366.mobile.common.views.viewmodel.EmptyViewModel.Builder setType(int i) {
            this.type = i;
            return this;
        }
    }
}
