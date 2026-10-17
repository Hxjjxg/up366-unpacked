package com.up366.medialibrary.common.animators;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class AlphaInAnimationAdapter extends com.up366.medialibrary.common.animators.BaseAnimationAdapter {
    private static final float DEFAULT_ALPHA_FROM = 0.0f;
    private final float mFrom;

    public AlphaInAnimationAdapter(androidx.recyclerview.widget.RecyclerView.Adapter adapter) {
        this(adapter, 0.0f);
    }

    public AlphaInAnimationAdapter(androidx.recyclerview.widget.RecyclerView.Adapter adapter, float f) {
        super(adapter);
        this.mFrom = f;
    }

    @Override // com.up366.medialibrary.common.animators.BaseAnimationAdapter
    protected android.animation.Animator[] getAnimators(android.view.View view) {
        return new android.animation.Animator[]{android.animation.ObjectAnimator.ofFloat(view, com.up366.qmui.skin.QMUISkinValueBuilder.ALPHA, this.mFrom, 1.0f)};
    }
}
