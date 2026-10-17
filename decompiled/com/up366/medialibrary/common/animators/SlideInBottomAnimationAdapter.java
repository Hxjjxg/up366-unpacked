package com.up366.medialibrary.common.animators;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SlideInBottomAnimationAdapter extends com.up366.medialibrary.common.animators.BaseAnimationAdapter {
    public SlideInBottomAnimationAdapter(androidx.recyclerview.widget.RecyclerView.Adapter adapter) {
        super(adapter);
    }

    @Override // com.up366.medialibrary.common.animators.BaseAnimationAdapter
    protected android.animation.Animator[] getAnimators(android.view.View view) {
        return new android.animation.Animator[]{android.animation.ObjectAnimator.ofFloat(view, "translationY", view.getMeasuredHeight(), 0.0f)};
    }
}
