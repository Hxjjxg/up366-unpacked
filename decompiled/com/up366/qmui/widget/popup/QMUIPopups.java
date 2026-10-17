package com.up366.qmui.widget.popup;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class QMUIPopups {
    public static com.up366.qmui.widget.popup.QMUIPopup popup(android.content.Context context) {
        return new com.up366.qmui.widget.popup.QMUIPopup(context, -2, -2);
    }

    public static com.up366.qmui.widget.popup.QMUIPopup popup(android.content.Context context, int i) {
        return new com.up366.qmui.widget.popup.QMUIPopup(context, i, -2);
    }

    public static com.up366.qmui.widget.popup.QMUIPopup popup(android.content.Context context, int i, int i2) {
        return new com.up366.qmui.widget.popup.QMUIPopup(context, i, i2);
    }

    public static com.up366.qmui.widget.popup.QMUIPopup listPopup(android.content.Context context, int i, int i2, android.widget.BaseAdapter baseAdapter, android.widget.AdapterView.OnItemClickListener onItemClickListener) {
        com.up366.qmui.widget.QMUIWrapContentListView qMUIWrapContentListView = new com.up366.qmui.widget.QMUIWrapContentListView(context, i2);
        qMUIWrapContentListView.setAdapter((android.widget.ListAdapter) baseAdapter);
        qMUIWrapContentListView.setVerticalScrollBarEnabled(false);
        qMUIWrapContentListView.setOnItemClickListener(onItemClickListener);
        qMUIWrapContentListView.setDivider(null);
        return popup(context, i).view(qMUIWrapContentListView);
    }

    public static com.up366.qmui.widget.popup.QMUIFullScreenPopup fullScreenPopup(android.content.Context context) {
        return new com.up366.qmui.widget.popup.QMUIFullScreenPopup(context);
    }

    public static com.up366.qmui.widget.popup.QMUIQuickAction quickAction(android.content.Context context, int i, int i2) {
        return new com.up366.qmui.widget.popup.QMUIQuickAction(context, -2, i2).actionWidth(i).actionHeight(i2);
    }
}
