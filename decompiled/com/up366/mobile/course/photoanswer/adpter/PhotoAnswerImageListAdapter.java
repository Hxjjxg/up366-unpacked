package com.up366.mobile.course.photoanswer.adpter;

/* JADX INFO: compiled from: PhotoAnswerImageListAdapter.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
@kotlin.Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002)*B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0014H\u0016J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0014H\u0016J\b\u0010#\u001a\u00020\u0014H\u0016J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004J\u000e\u0010%\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0014J\u0014\u0010&\u001a\u00020\u00162\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00150(R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R.\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006+"}, d2 = {"Lcom/up366/mobile/course/photoanswer/adpter/PhotoAnswerImageListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/up366/mobile/common/base/BaseRecyclerAdapter$BaseViewHolder;", "holders", "", "Lcom/up366/mobile/common/base/BaseRecyclerAdapter$DataHolder;", "mRecyclerVew", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Ljava/util/List;Landroidx/recyclerview/widget/RecyclerView;)V", "getMRecyclerVew", "()Landroidx/recyclerview/widget/RecyclerView;", "disableClick", "", "getDisableClick", "()Z", "setDisableClick", "(Z)V", "itemListener", "Lkotlin/Function2;", "", "Lcom/up366/mobile/course/photoanswer/logic/model/PhotoAnswerImageInfo;", "", "getItemListener", "()Lkotlin/jvm/functions/Function2;", "setItemListener", "(Lkotlin/jvm/functions/Function2;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "position", "onBindViewHolder", "holder", "getItemCount", "getPages", "setPageSelectPosition", "setDataS", "pages", "", "MyCalculateDiff", "MyAdapterListUpdateCallback", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PhotoAnswerImageListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder> {
    private volatile boolean disableClick;
    private java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> holders;
    private kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo, kotlin.Unit> itemListener;
    private final androidx.recyclerview.widget.RecyclerView mRecyclerVew;

    public PhotoAnswerImageListAdapter(java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> list, androidx.recyclerview.widget.RecyclerView recyclerView) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "holders");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(recyclerView, "mRecyclerVew");
        this.holders = list;
        this.mRecyclerVew = recyclerView;
    }

    public final androidx.recyclerview.widget.RecyclerView getMRecyclerVew() {
        return this.mRecyclerVew;
    }

    public final boolean getDisableClick() {
        return this.disableClick;
    }

    public final void setDisableClick(boolean z) {
        this.disableClick = z;
    }

    public final kotlin.jvm.functions.Function2<java.lang.Integer, com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo, kotlin.Unit> getItemListener() {
        return this.itemListener;
    }

    public final void setItemListener(kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo, kotlin.Unit> function2) {
        this.itemListener = function2;
    }

    public com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        android.content.Context context = parent.getContext();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return new com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder(new com.up366.mobile.course.photoanswer.view.ItemPhotoAnswerView(context));
    }

    public int getItemViewType(int position) {
        return this.holders.get(position).viewType;
    }

    public void onBindViewHolder(final com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder holder, int position) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(holder, "holder");
        java.lang.Object obj = this.holders.get(position).o;
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo");
        final com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo = (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) obj;
        android.view.View view = holder.itemView;
        kotlin.jvm.internal.Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.up366.mobile.course.photoanswer.view.ItemPhotoAnswerView");
        ((com.up366.mobile.course.photoanswer.view.ItemPhotoAnswerView) view).setData(photoAnswerImageInfo);
        android.view.View view2 = holder.itemView;
        kotlin.jvm.internal.Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.up366.mobile.course.photoanswer.view.ItemPhotoAnswerView");
        ((com.up366.mobile.course.photoanswer.view.ItemPhotoAnswerView) view2).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view3) {
                com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter.onBindViewHolder$lambda$0(this.f$0, holder, photoAnswerImageInfo, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter photoAnswerImageListAdapter, com.up366.mobile.common.base.BaseRecyclerAdapter.BaseViewHolder baseViewHolder, com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo photoAnswerImageInfo, android.view.View view) {
        kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo, kotlin.Unit> function2;
        if (photoAnswerImageListAdapter.disableClick || (function2 = photoAnswerImageListAdapter.itemListener) == null) {
            return;
        }
        function2.invoke(java.lang.Integer.valueOf(photoAnswerImageListAdapter.mRecyclerVew.getChildAdapterPosition(baseViewHolder.itemView)), photoAnswerImageInfo);
    }

    public int getItemCount() {
        return this.holders.size();
    }

    /* JADX INFO: compiled from: PhotoAnswerImageListAdapter.kt */
    @kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/up366/mobile/course/photoanswer/adpter/PhotoAnswerImageListAdapter$MyCalculateDiff;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldDatas", "", "Lcom/up366/mobile/common/base/BaseRecyclerAdapter$DataHolder;", "newDatas", "<init>", "(Lcom/up366/mobile/course/photoanswer/adpter/PhotoAnswerImageListAdapter;Ljava/util/List;Ljava/util/List;)V", "getOldDatas", "()Ljava/util/List;", "getNewDatas", "getOldListSize", "", "getNewListSize", "objectEquals", "", "a", "", "b", "areItemsTheSame", "oldItemPosition", "newItemPosition", "areContentsTheSame", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class MyCalculateDiff extends androidx.recyclerview.widget.DiffUtil.Callback {
        private final java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> newDatas;
        private final java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> oldDatas;
        final /* synthetic */ com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter this$0;

        public MyCalculateDiff(com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter photoAnswerImageListAdapter, java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> list, java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> list2) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "oldDatas");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list2, "newDatas");
            this.this$0 = photoAnswerImageListAdapter;
            this.oldDatas = list;
            this.newDatas = list2;
        }

        public final java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> getNewDatas() {
            return this.newDatas;
        }

        public final java.util.List<com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder> getOldDatas() {
            return this.oldDatas;
        }

        public int getOldListSize() {
            return this.oldDatas.size();
        }

        public int getNewListSize() {
            return this.newDatas.size();
        }

        private final boolean objectEquals(java.lang.Object a, java.lang.Object b) {
            return a == b || (a != null && kotlin.jvm.internal.Intrinsics.areEqual(a, b));
        }

        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.oldDatas.get(oldItemPosition);
            com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder2 = this.newDatas.get(newItemPosition);
            return dataHolder.viewType == dataHolder2.viewType && objectEquals(dataHolder.o, dataHolder2.o) && objectEquals(dataHolder.o2, dataHolder2.o2);
        }

        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder = this.oldDatas.get(oldItemPosition);
            com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder2 = this.newDatas.get(newItemPosition);
            return dataHolder.viewType == dataHolder2.viewType && objectEquals(dataHolder.o, dataHolder2.o) && objectEquals(dataHolder.o2, dataHolder2.o2);
        }
    }

    /* JADX INFO: compiled from: PhotoAnswerImageListAdapter.kt */
    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/up366/mobile/course/photoanswer/adpter/PhotoAnswerImageListAdapter$MyAdapterListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "mAdapter", "Lcom/up366/mobile/course/photoanswer/adpter/PhotoAnswerImageListAdapter;", "<init>", "(Lcom/up366/mobile/course/photoanswer/adpter/PhotoAnswerImageListAdapter;Lcom/up366/mobile/course/photoanswer/adpter/PhotoAnswerImageListAdapter;)V", "getMAdapter", "()Lcom/up366/mobile/course/photoanswer/adpter/PhotoAnswerImageListAdapter;", "onInserted", "", "position", "", com.up366.medialibrary.config.PictureConstants.EXTRA_DATA_COUNT, "onRemoved", "onMoved", "fromPosition", "toPosition", "onChanged", com.igexin.assist.sdk.AssistPushConsts.MSG_TYPE_PAYLOAD, "", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class MyAdapterListUpdateCallback implements androidx.recyclerview.widget.ListUpdateCallback {
        private final com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter mAdapter;
        final /* synthetic */ com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter this$0;

        public MyAdapterListUpdateCallback(com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter photoAnswerImageListAdapter, com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter photoAnswerImageListAdapter2) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(photoAnswerImageListAdapter2, "mAdapter");
            this.this$0 = photoAnswerImageListAdapter;
            this.mAdapter = photoAnswerImageListAdapter2;
        }

        public final com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter getMAdapter() {
            return this.mAdapter;
        }

        public void onInserted(int position, int count) {
            this.this$0.getMRecyclerVew().scrollToPosition(position);
            this.mAdapter.notifyItemRangeInserted(position, count);
        }

        public void onRemoved(int position, int count) {
            this.this$0.getMRecyclerVew().scrollToPosition(position);
            this.mAdapter.notifyItemRangeRemoved(position, count);
        }

        public void onMoved(int fromPosition, int toPosition) {
            this.this$0.getMRecyclerVew().scrollToPosition(fromPosition);
            this.mAdapter.notifyItemMoved(fromPosition, toPosition);
        }

        public void onChanged(int position, int count, java.lang.Object payload) {
            this.this$0.getMRecyclerVew().scrollToPosition(position);
            this.mAdapter.notifyItemRangeChanged(position, count, payload);
        }
    }

    public final java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> getPages() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder dataHolder : this.holders) {
            if (dataHolder.viewType == 1) {
                java.lang.Object obj = dataHolder.o;
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo");
                arrayList.add((com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) obj);
            }
        }
        return arrayList;
    }

    public final void setPageSelectPosition(int position) {
        java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> pages = getPages();
        java.util.Iterator<T> it = pages.iterator();
        while (it.hasNext()) {
            ((com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) it.next()).setUiSelected(false);
        }
        if (position < 0) {
            setDataS(pages);
            return;
        }
        pages.get(position).setUiSelected(true);
        setDataS(pages);
        this.mRecyclerVew.scrollToPosition(position);
    }

    public final void setDataS(java.util.List<com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo> pages) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pages, "pages");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = kotlin.collections.CollectionsKt.sortedWith(pages, new java.util.Comparator() { // from class: com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter$setDataS$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return kotlin.comparisons.ComparisonsKt.compareValues(java.lang.Integer.valueOf(((com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) t).getImageIndex()), java.lang.Integer.valueOf(((com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) t2).getImageIndex()));
            }
        }).iterator();
        while (it.hasNext()) {
            arrayList.add(new com.up366.mobile.common.base.BaseRecyclerAdapter.DataHolder(1, (com.up366.mobile.course.photoanswer.logic.model.PhotoAnswerImageInfo) it.next()));
        }
        androidx.recyclerview.widget.DiffUtil.DiffResult diffResultCalculateDiff = androidx.recyclerview.widget.DiffUtil.calculateDiff(new com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter.MyCalculateDiff(this, this.holders, arrayList));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
        this.holders = arrayList;
        notifyDataSetChanged();
        diffResultCalculateDiff.dispatchUpdatesTo(new com.up366.mobile.course.photoanswer.adpter.PhotoAnswerImageListAdapter.MyAdapterListUpdateCallback(this, this));
    }
}
