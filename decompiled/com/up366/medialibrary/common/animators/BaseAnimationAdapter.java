package com.up366.medialibrary.common.animators;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public abstract class BaseAnimationAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    private androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> mAdapter;
    private int mDuration = 250;
    private android.view.animation.Interpolator mInterpolator = new android.view.animation.LinearInterpolator();
    private int mLastPosition = -1;
    private boolean isFirstOnly = true;

    protected abstract android.animation.Animator[] getAnimators(android.view.View view);

    public BaseAnimationAdapter(androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> adapter) {
        this.mAdapter = adapter;
    }

    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
        return this.mAdapter.onCreateViewHolder(viewGroup, i);
    }

    public void registerAdapterDataObserver(androidx.recyclerview.widget.RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.mAdapter.registerAdapterDataObserver(adapterDataObserver);
    }

    public void unregisterAdapterDataObserver(androidx.recyclerview.widget.RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.mAdapter.unregisterAdapterDataObserver(adapterDataObserver);
    }

    public void onAttachedToRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mAdapter.onAttachedToRecyclerView(recyclerView);
    }

    public void onDetachedFromRecyclerView(androidx.recyclerview.widget.RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mAdapter.onDetachedFromRecyclerView(recyclerView);
    }

    public void onViewAttachedToWindow(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        this.mAdapter.onViewAttachedToWindow(viewHolder);
    }

    public void onViewDetachedFromWindow(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        this.mAdapter.onViewDetachedFromWindow(viewHolder);
    }

    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int i) {
        this.mAdapter.onBindViewHolder(viewHolder, i);
        int adapterPosition = viewHolder.getAdapterPosition();
        if (!this.isFirstOnly || adapterPosition > this.mLastPosition) {
            for (android.animation.Animator animator : getAnimators(viewHolder.itemView)) {
                animator.setDuration(this.mDuration).start();
                animator.setInterpolator(this.mInterpolator);
            }
            this.mLastPosition = adapterPosition;
            return;
        }
        com.up366.medialibrary.common.animators.ViewHelper.clear(viewHolder.itemView);
    }

    public void onViewRecycled(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder) {
        this.mAdapter.onViewRecycled(viewHolder);
        super.onViewRecycled(viewHolder);
    }

    public int getItemCount() {
        return this.mAdapter.getItemCount();
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setInterpolator(android.view.animation.Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setStartPosition(int i) {
        this.mLastPosition = i;
    }

    public void setFirstOnly(boolean z) {
        this.isFirstOnly = z;
    }

    public int getItemViewType(int i) {
        return this.mAdapter.getItemViewType(i);
    }

    public androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> getWrappedAdapter() {
        return this.mAdapter;
    }

    public long getItemId(int i) {
        return this.mAdapter.getItemId(i);
    }
}
