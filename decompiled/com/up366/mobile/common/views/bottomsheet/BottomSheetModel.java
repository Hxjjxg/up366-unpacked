package com.up366.mobile.common.views.bottomsheet;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BottomSheetModel<T> {
    private java.lang.String content;
    private T data;
    private int drawableId;
    private boolean isSelected;

    public java.lang.String getContent() {
        return this.content;
    }

    public void setContent(java.lang.String str) {
        this.content = str;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setSelected(boolean z) {
        this.isSelected = z;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }

    public int getDrawableId() {
        return this.drawableId;
    }

    public void setDrawableId(int i) {
        this.drawableId = i;
    }
}
