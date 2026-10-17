package com.up366.multimedia.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class GlobalClickHelper {
    private java.util.Set<com.up366.multimedia.views.PictureVideoGridView> gridViews = new java.util.HashSet();
    private static com.up366.multimedia.util.GlobalClickHelper helper = new com.up366.multimedia.util.GlobalClickHelper();
    private static boolean hasAdd = false;

    public static com.up366.multimedia.util.GlobalClickHelper getInst() {
        return helper;
    }

    public synchronized void removeListenerOnDetached(com.up366.multimedia.views.PictureVideoGridView gridView) {
        this.gridViews.remove(gridView);
        if (this.gridViews.size() == 0) {
            hasAdd = false;
            android.view.View viewFindViewById = gridView.getRootView().findViewById(android.R.id.content);
            if (viewFindViewById == null) {
                com.up366.common.log.Logger.error("removeListenerOnDetached error: view is null");
                return;
            }
            viewFindViewById.setOnClickListener(null);
        }
    }

    public synchronized void addGlobalClickOnAttached(com.up366.multimedia.views.PictureVideoGridView gridView) {
        this.gridViews.add(gridView);
        if (hasAdd) {
            return;
        }
        hasAdd = true;
        android.view.View viewFindViewById = gridView.getRootView().findViewById(android.R.id.content);
        if (viewFindViewById == null) {
            com.up366.common.log.Logger.error("addGlobalClickOnAttached error: view is null");
        } else {
            viewFindViewById.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.multimedia.util.GlobalClickHelper$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f$0.m1331xb9057455(view);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$addGlobalClickOnAttached$0$com-up366-multimedia-util-GlobalClickHelper, reason: not valid java name */
    /* synthetic */ void m1331xb9057455(android.view.View view) {
        java.util.Iterator<com.up366.multimedia.views.PictureVideoGridView> it = this.gridViews.iterator();
        while (it.hasNext()) {
            it.next().setEditMode(false);
        }
    }
}
