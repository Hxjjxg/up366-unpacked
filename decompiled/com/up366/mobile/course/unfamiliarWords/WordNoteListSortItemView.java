package com.up366.mobile.course.unfamiliarWords;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class WordNoteListSortItemView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.WordNoteListSortItemBinding b;
    private int curPage;
    private android.content.Context mContext;
    private java.util.Map<java.lang.Integer, java.lang.String> sortIdMap;
    private java.util.Map<java.lang.String, java.lang.String> sortStrMap;

    public WordNoteListSortItemView(android.content.Context context) {
        this(context, null);
    }

    public WordNoteListSortItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WordNoteListSortItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = (com.up366.mobile.databinding.WordNoteListSortItemBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(context), com.up366.mobile.R.layout.word_note_list_sort_item, this, true);
        this.mContext = context;
        initMap();
    }

    public void setCurPage(int i) {
        this.curPage = i;
    }

    public void setSortModel(final com.up366.mobile.course.unfamiliarWords.SortModel sortModel) {
        this.b.tvHideChinese.setChecked(sortModel.isChineseHidden());
        this.b.tvHideChinese.setText(sortModel.isChineseHidden() ? "显示中文" : "隐藏中文");
        this.b.tvHideChinese.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListSortItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setSortModel$0(sortModel, view);
            }
        });
        this.b.tvHideEnglish.setChecked(sortModel.isEnglishHidden());
        this.b.tvHideEnglish.setText(sortModel.isEnglishHidden() ? "显示英文" : "隐藏英文");
        this.b.tvHideEnglish.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListSortItemView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setSortModel$1(sortModel, view);
            }
        });
        this.b.tvSelectAndSort.setChecked(false);
        this.b.tvSelectAndSort.setText(this.sortStrMap.get(sortModel.getOrderField()));
        this.b.tvSelectAndSort.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListSortItemView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setSortModel$2(sortModel, view);
            }
        });
        this.b.ivSort.setImageDrawable(this.mContext.getDrawable(sortModel.isOrderDesc() ? com.up366.mobile.R.drawable.icon_sort_down : com.up366.mobile.R.drawable.icon_sort_up));
        this.b.ivSort.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListSortItemView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$setSortModel$3(sortModel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSortModel$0(com.up366.mobile.course.unfamiliarWords.SortModel sortModel, android.view.View view) {
        sortModel.setChineseHidden(!sortModel.isChineseHidden());
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteDetailShowTxt(this.curPage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSortModel$1(com.up366.mobile.course.unfamiliarWords.SortModel sortModel, android.view.View view) {
        sortModel.setEnglishHidden(!sortModel.isEnglishHidden());
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteDetailShowTxt(this.curPage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSortModel$2(com.up366.mobile.course.unfamiliarWords.SortModel sortModel, android.view.View view) {
        this.b.tvSelectAndSort.setChecked(true);
        showListPopupWindow(this.b.tvSelectAndSort, sortModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSortModel$3(com.up366.mobile.course.unfamiliarWords.SortModel sortModel, android.view.View view) {
        sortModel.setOrderDesc(!sortModel.isOrderDesc());
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteNeedRefreshListEvent(this.curPage, sortModel));
    }

    private void initMap() {
        java.util.HashMap map = new java.util.HashMap();
        this.sortIdMap = map;
        map.put(java.lang.Integer.valueOf(com.up366.mobile.R.id.addCount), "加入次数");
        this.sortIdMap.put(java.lang.Integer.valueOf(com.up366.mobile.R.id.ABCOrder), "字母顺序");
        this.sortIdMap.put(java.lang.Integer.valueOf(com.up366.mobile.R.id.addTime), "加入时间");
        java.util.HashMap map2 = new java.util.HashMap();
        this.sortStrMap = map2;
        map2.put(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD_TIMES, "加入次数");
        this.sortStrMap.put(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD, "字母顺序");
        this.sortStrMap.put(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_UPDATE_TIME, "加入时间");
    }

    private void showListPopupWindow(android.view.View view, final com.up366.mobile.course.unfamiliarWords.SortModel sortModel) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.up366.mobile.course.unfamiliarWords.popup.ListPopupItem("加入次数"));
        arrayList.add(new com.up366.mobile.course.unfamiliarWords.popup.ListPopupItem("字母顺序"));
        arrayList.add(new com.up366.mobile.course.unfamiliarWords.popup.ListPopupItem("加入时间"));
        for (com.up366.mobile.course.unfamiliarWords.popup.ListPopupItem listPopupItem : arrayList) {
            listPopupItem.setChecked(this.b.tvSelectAndSort.getText().toString().equals(listPopupItem.getTitle()));
        }
        final android.widget.ListPopupWindow listPopupWindowCreateListPopupWindow = createListPopupWindow(view, -2, arrayList);
        listPopupWindowCreateListPopupWindow.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() { // from class: com.up366.mobile.course.unfamiliarWords.WordNoteListSortItemView$$ExternalSyntheticLambda4
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(android.widget.AdapterView adapterView, android.view.View view2, int i, long j) {
                this.f$0.lambda$showListPopupWindow$4(listPopupWindowCreateListPopupWindow, sortModel, adapterView, view2, i, j);
            }
        });
        listPopupWindowCreateListPopupWindow.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showListPopupWindow$4(android.widget.ListPopupWindow listPopupWindow, com.up366.mobile.course.unfamiliarWords.SortModel sortModel, android.widget.AdapterView adapterView, android.view.View view, int i, long j) {
        listPopupWindow.dismiss();
        if (i == 0) {
            this.b.tvSelectAndSort.setText("加入次数");
            sortModel.setOrderField(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD_TIMES);
        } else if (i == 1) {
            this.b.tvSelectAndSort.setText("字母顺序");
            sortModel.setOrderField(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_WORD);
        } else if (i == 2) {
            this.b.tvSelectAndSort.setText("加入时间");
            sortModel.setOrderField(com.up366.mobile.course.unfamiliarWords.SortModel.FIELD_UPDATE_TIME);
        }
        this.b.tvSelectAndSort.setChecked(false);
        com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.WordNoteNeedRefreshListEvent(this.curPage, sortModel));
    }

    private android.widget.ListPopupWindow createListPopupWindow(android.view.View view, int i, java.util.List<com.up366.mobile.course.unfamiliarWords.popup.ListPopupItem> list) {
        android.widget.ListPopupWindow listPopupWindow = new android.widget.ListPopupWindow(this.mContext);
        com.up366.mobile.course.unfamiliarWords.popup.ListPopupWindowAdapter listPopupWindowAdapter = new com.up366.mobile.course.unfamiliarWords.popup.ListPopupWindowAdapter(list);
        listPopupWindow.setBackgroundDrawable(com.up366.mobile.common.utils.ViewUtil.getDrawable(this.mContext, com.up366.mobile.R.drawable.bg_corner_7_ffffffff));
        listPopupWindow.setAnchorView(view);
        listPopupWindow.setWidth(i);
        listPopupWindow.setHorizontalOffset(-20);
        listPopupWindow.setAdapter(listPopupWindowAdapter);
        return listPopupWindow;
    }
}
