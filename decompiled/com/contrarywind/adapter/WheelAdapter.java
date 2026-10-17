package com.contrarywind.adapter;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class WheelAdapter<T> {
    public abstract T getItem(int i);

    public abstract int getItemsCount();

    public abstract int indexOf(T t);

    public T getItemCenter(int i) {
        return getItem(i);
    }
}
