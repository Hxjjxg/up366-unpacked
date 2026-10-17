package com.up366.photopicker.ui.gallery;

/* JADX INFO: compiled from: GalleryRecyclerAdapter.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0019B[\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\f\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\bH\u0016J\u001c\u0010\u0012\u001a\u00020\r2\n\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/up366/photopicker/ui/gallery/GalleryRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/up366/photopicker/ui/gallery/GalleryRecyclerAdapter$Holder;", "items", "", "Lcom/up366/photopicker/ui/gallery/PhotoItem;", "selected", "", "", "isMultiSelect", "", "onSelectChanged", "Lkotlin/Function2;", "", "onPhotoClick", "Lkotlin/Function1;", "(Ljava/util/List;Ljava/util/Set;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GalleryRecyclerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.up366.photopicker.ui.gallery.GalleryRecyclerAdapter.Holder> {
    private final boolean isMultiSelect;
    private final java.util.List<com.up366.photopicker.ui.gallery.PhotoItem> items;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onPhotoClick;
    private final kotlin.jvm.functions.Function2<java.lang.Integer, java.lang.Boolean, kotlin.Unit> onSelectChanged;
    private final java.util.Set<java.lang.Integer> selected;

    public /* synthetic */ GalleryRecyclerAdapter(java.util.List list, java.util.Set set, boolean z, kotlin.jvm.functions.Function2 function2, kotlin.jvm.functions.Function1 function1, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(list, set, z, function2, (i & 16) != 0 ? null : function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GalleryRecyclerAdapter(java.util.List<com.up366.photopicker.ui.gallery.PhotoItem> list, java.util.Set<java.lang.Integer> set, boolean z, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Boolean, kotlin.Unit> function2, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> function1) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "items");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "selected");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(function2, "onSelectChanged");
        this.items = list;
        this.selected = set;
        this.isMultiSelect = z;
        this.onSelectChanged = function2;
        this.onPhotoClick = function1;
    }

    /* JADX INFO: compiled from: GalleryRecyclerAdapter.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/up366/photopicker/ui/gallery/GalleryRecyclerAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Lcom/up366/photopicker/ui/gallery/GalleryRecyclerAdapter;Landroid/view/View;)V", "check", "Landroid/widget/ImageView;", "getCheck", "()Landroid/widget/ImageView;", com.up366.medialibrary.common.utils.MimeTypeUtils.MIME_TYPE_PREFIX_IMAGE, "getImage", "overlay", "getOverlay", "()Landroid/view/View;", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.ImageView check;
        private final android.widget.ImageView image;
        private final android.view.View overlay;
        final /* synthetic */ com.up366.photopicker.ui.gallery.GalleryRecyclerAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holder(com.up366.photopicker.ui.gallery.GalleryRecyclerAdapter galleryRecyclerAdapter, android.view.View view) {
            super(view);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "v");
            this.this$0 = galleryRecyclerAdapter;
            android.view.View viewFindViewById = view.findViewById(com.up366.photopicker.R.id.galleryImage);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById, "v.findViewById(R.id.galleryImage)");
            this.image = (android.widget.ImageView) viewFindViewById;
            android.view.View viewFindViewById2 = view.findViewById(com.up366.photopicker.R.id.selectedOverlay);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "v.findViewById(R.id.selectedOverlay)");
            this.overlay = viewFindViewById2;
            android.view.View viewFindViewById3 = view.findViewById(com.up366.photopicker.R.id.selectedCheck);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "v.findViewById(R.id.selectedCheck)");
            this.check = (android.widget.ImageView) viewFindViewById3;
        }

        public final android.widget.ImageView getImage() {
            return this.image;
        }

        public final android.view.View getOverlay() {
            return this.overlay;
        }

        public final android.widget.ImageView getCheck() {
            return this.check;
        }
    }

    public com.up366.photopicker.ui.gallery.GalleryRecyclerAdapter.Holder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        android.view.View viewInflate = android.view.LayoutInflater.from(parent.getContext()).inflate(com.up366.photopicker.R.layout.up366_photo_picker_item_gallery_photo, parent, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(viewInflate, "v");
        return new com.up366.photopicker.ui.gallery.GalleryRecyclerAdapter.Holder(this, viewInflate);
    }

    public void onBindViewHolder(com.up366.photopicker.ui.gallery.GalleryRecyclerAdapter.Holder holder, final int position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        try {
            com.bumptech.glide.Glide.with(holder.getImage().getContext()).load(this.items.get(position).getUri()).centerCrop().placeholder(com.up366.photopicker.R.drawable.up366_photo_picker_ic_counter_badge).into(holder.getImage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        boolean zContains = this.selected.contains(java.lang.Integer.valueOf(position));
        holder.getOverlay().setVisibility((this.isMultiSelect && zContains) ? 0 : 8);
        holder.getCheck().setVisibility(this.isMultiSelect ? 0 : 8);
        holder.getCheck().setImageResource(zContains ? com.up366.photopicker.R.drawable.photo_picker_gally_checked : com.up366.photopicker.R.drawable.photo_picker_gally_unchecked);
        holder.itemView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.gallery.GalleryRecyclerAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.photopicker.ui.gallery.GalleryRecyclerAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(com.up366.photopicker.ui.gallery.GalleryRecyclerAdapter galleryRecyclerAdapter, int i, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(galleryRecyclerAdapter, "this$0");
        if (!galleryRecyclerAdapter.isMultiSelect) {
            kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> function1 = galleryRecyclerAdapter.onPhotoClick;
            if (function1 != null) {
                function1.invoke(java.lang.Integer.valueOf(i));
                return;
            }
            return;
        }
        boolean z = !galleryRecyclerAdapter.selected.contains(java.lang.Integer.valueOf(i));
        java.util.Set<java.lang.Integer> set = galleryRecyclerAdapter.selected;
        java.lang.Integer numValueOf = java.lang.Integer.valueOf(i);
        if (z) {
            set.add(numValueOf);
        } else {
            set.remove(numValueOf);
        }
        galleryRecyclerAdapter.onSelectChanged.invoke(java.lang.Integer.valueOf(i), java.lang.Boolean.valueOf(z));
        galleryRecyclerAdapter.notifyItemChanged(i);
    }

    public int getItemCount() {
        return this.items.size();
    }
}
