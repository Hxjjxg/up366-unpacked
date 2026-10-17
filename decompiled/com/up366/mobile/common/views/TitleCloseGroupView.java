package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class TitleCloseGroupView extends androidx.appcompat.widget.AppCompatImageView {
    private static int activityId;
    private static final android.util.SparseArray<com.up366.mobile.common.views.TitleCloseGroupView.Holder> map = new android.util.SparseArray<>();
    private android.app.Activity activity;
    private int aid;
    private java.lang.String group;
    private com.up366.mobile.common.views.TitleCloseGroupView.IOnCloseListener onCloseListener;

    public interface IOnCloseListener {
        void onClose();
    }

    public TitleCloseGroupView(android.content.Context context) {
        this(context, null);
    }

    public TitleCloseGroupView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TitleCloseGroupView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aid = -1;
        if (!isInEditMode()) {
            this.activity = getActivity();
        }
        init(attributeSet);
    }

    private void init(android.util.AttributeSet attributeSet) {
        if (attributeSet == null || isInEditMode()) {
            setScaleType(android.widget.ImageView.ScaleType.CENTER);
            setImageResource(com.up366.mobile.R.drawable.icon_close);
            return;
        }
        android.content.res.TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.up366.mobile.R.styleable.TitleCloseGroupView);
        this.group = typedArrayObtainStyledAttributes.getString(0);
        typedArrayObtainStyledAttributes.recycle();
        setScaleType(android.widget.ImageView.ScaleType.CENTER);
        setImageResource(com.up366.mobile.R.drawable.icon_close_black);
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.TitleCloseGroupView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$init$0(view);
            }
        });
        android.content.res.TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(com.up366.mobile.R.style.selectableItemBackgroundBorderless, new int[]{android.R.attr.background});
        setBackground(typedArrayObtainStyledAttributes2.getDrawable(0));
        typedArrayObtainStyledAttributes2.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(android.view.View view) {
        if (this.group == null) {
            throw new java.lang.IllegalStateException("TitleCloseGroupView，需要设置 group 属性");
        }
        com.up366.mobile.common.views.TitleCloseGroupView.IOnCloseListener iOnCloseListener = this.onCloseListener;
        if (iOnCloseListener != null) {
            iOnCloseListener.onClose();
        }
        for (int size = map.size(); size > 0; size--) {
            android.util.SparseArray<com.up366.mobile.common.views.TitleCloseGroupView.Holder> sparseArray = map;
            int i = size - 1;
            com.up366.mobile.common.views.TitleCloseGroupView.Holder holderValueAt = sparseArray.valueAt(i);
            if (this.group.equals(holderValueAt.group)) {
                holderValueAt.activity.finish();
                sparseArray.removeAt(i);
            }
        }
        cleanMap();
    }

    private void cleanMap() {
        for (int size = map.size(); size > 0; size--) {
            android.util.SparseArray<com.up366.mobile.common.views.TitleCloseGroupView.Holder> sparseArray = map;
            int i = size - 1;
            if (sparseArray.valueAt(i).activity.isFinishing()) {
                sparseArray.removeAt(i);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.title_bar_height), 0);
        int iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(com.up366.mobile.R.dimen.title_bar_height), 0);
        super.onMeasure(i, i2);
        setMeasuredDimension(iMakeMeasureSpec, iMakeMeasureSpec2);
    }

    private android.app.Activity getActivity() {
        if (getContext() instanceof android.app.Activity) {
            return (android.app.Activity) getContext();
        }
        if (!(getContext() instanceof android.content.ContextWrapper)) {
            return null;
        }
        android.content.Context baseContext = ((android.content.ContextWrapper) getContext()).getBaseContext();
        if (baseContext instanceof androidx.appcompat.view.ContextThemeWrapper) {
            baseContext = ((androidx.appcompat.view.ContextThemeWrapper) baseContext).getBaseContext();
        }
        return (android.app.Activity) baseContext;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.aid < 0) {
            int i = activityId;
            activityId = i + 1;
            this.aid = i;
        }
        map.put(this.aid, new com.up366.mobile.common.views.TitleCloseGroupView.Holder(this.group, this.activity));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cleanMap();
    }

    public android.os.Parcelable onSaveInstanceState() {
        com.up366.mobile.common.views.TitleCloseGroupView.SavedState savedState = new com.up366.mobile.common.views.TitleCloseGroupView.SavedState(super.onSaveInstanceState());
        savedState.aid = this.aid;
        map.put(this.aid, new com.up366.mobile.common.views.TitleCloseGroupView.Holder(this.group, this.activity));
        return savedState;
    }

    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        com.up366.mobile.common.views.TitleCloseGroupView.SavedState savedState = (com.up366.mobile.common.views.TitleCloseGroupView.SavedState) parcelable;
        int i = savedState.aid;
        this.aid = i;
        map.put(i, new com.up366.mobile.common.views.TitleCloseGroupView.Holder(this.group, this.activity));
        super.onRestoreInstanceState(savedState.getSuperState());
    }

    static class SavedState extends android.view.View.BaseSavedState {
        public static final android.os.Parcelable.Creator<com.up366.mobile.common.views.TitleCloseGroupView.SavedState> CREATOR = new android.os.Parcelable.Creator<com.up366.mobile.common.views.TitleCloseGroupView.SavedState>() { // from class: com.up366.mobile.common.views.TitleCloseGroupView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.up366.mobile.common.views.TitleCloseGroupView.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.up366.mobile.common.views.TitleCloseGroupView.SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.up366.mobile.common.views.TitleCloseGroupView.SavedState[] newArray(int i) {
                return new com.up366.mobile.common.views.TitleCloseGroupView.SavedState[i];
            }
        };
        int aid;

        SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
            this.aid = -1;
        }

        private SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.aid = -1;
            this.aid = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.aid);
        }
    }

    static class Holder {
        android.app.Activity activity;
        java.lang.String group;

        public Holder(java.lang.String str, android.app.Activity activity) {
            this.group = str;
            this.activity = activity;
        }
    }

    public void setOnCloseListener(com.up366.mobile.common.views.TitleCloseGroupView.IOnCloseListener iOnCloseListener) {
        this.onCloseListener = iOnCloseListener;
    }
}
