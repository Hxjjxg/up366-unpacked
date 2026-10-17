package com.up366.medialibrary.third.ucrop.util;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class SelectedStateListDrawable extends android.graphics.drawable.StateListDrawable {
    private final int mSelectionColor;

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    public SelectedStateListDrawable(android.graphics.drawable.Drawable drawable, int i) {
        this.mSelectionColor = i;
        addState(new int[]{android.R.attr.state_selected}, drawable);
        addState(new int[0], drawable);
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z = false;
        for (int i : iArr) {
            if (i == 16842913) {
                z = true;
            }
        }
        if (z) {
            super.setColorFilter(androidx.core.graphics.BlendModeColorFilterCompat.createBlendModeColorFilterCompat(this.mSelectionColor, androidx.core.graphics.BlendModeCompat.SRC_ATOP));
        } else {
            super.clearColorFilter();
        }
        return super.onStateChange(iArr);
    }
}
