package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class x0 {
    public static void a(android.view.View view) {
        if (view == null) {
            return;
        }
        if (!(view instanceof android.view.ViewGroup)) {
            view.setOnClickListener(null);
            return;
        }
        try {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(viewGroup.getChildAt(i));
            }
            viewGroup.removeAllViews();
            viewGroup.setOnClickListener(null);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
