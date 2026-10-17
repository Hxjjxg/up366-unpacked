package com.up366.medialibrary.third.photoview;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
class Compat {
    Compat() {
    }

    public static void postOnAnimation(android.view.View view, java.lang.Runnable runnable) {
        postOnAnimationJellyBean(view, runnable);
    }

    private static void postOnAnimationJellyBean(android.view.View view, java.lang.Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
