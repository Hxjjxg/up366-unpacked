package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class CheckableImageView extends androidx.appcompat.widget.AppCompatImageView implements android.widget.Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED = {android.R.attr.state_checked};
    private boolean mChecked;

    public CheckableImageView(android.content.Context context) {
        this(context, null);
    }

    public CheckableImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CheckableImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        androidx.core.view.ViewCompat.setAccessibilityDelegate(this, new androidx.core.view.AccessibilityDelegateCompat() { // from class: com.up366.mobile.common.views.CheckableImageView.1
            public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setChecked(com.up366.mobile.common.views.CheckableImageView.this.isChecked());
            }

            public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setCheckable(true);
                accessibilityNodeInfoCompat.setChecked(com.up366.mobile.common.views.CheckableImageView.this.isChecked());
            }
        });
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.mChecked != z) {
            this.mChecked = z;
            refreshDrawableState();
            sendAccessibilityEvent(io.objectbox.model.PropertyFlags.INDEX_HASH);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.mChecked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.mChecked);
    }

    public int[] onCreateDrawableState(int i) {
        if (this.mChecked) {
            int[] iArr = DRAWABLE_STATE_CHECKED;
            return mergeDrawableStates(super.onCreateDrawableState(i + iArr.length), iArr);
        }
        return super.onCreateDrawableState(i);
    }
}
