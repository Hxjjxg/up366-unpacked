package com.up366.mobile.course.unfamiliarWords.popup;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class ListPopupWindowAdapter extends android.widget.BaseAdapter {
    private java.util.List<com.up366.mobile.course.unfamiliarWords.popup.ListPopupItem> items;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public ListPopupWindowAdapter(java.util.List<com.up366.mobile.course.unfamiliarWords.popup.ListPopupItem> list) {
        this.items = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size();
    }

    @Override // android.widget.Adapter
    public com.up366.mobile.course.unfamiliarWords.popup.ListPopupItem getItem(int i) {
        return this.items.get(i);
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        com.up366.mobile.course.unfamiliarWords.popup.ListPopupWindowAdapter.ViewHolder viewHolder;
        if (view == null) {
            view = android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.up366.mobile.R.layout.item_list_popup, (android.view.ViewGroup) null);
            ((android.widget.CheckedTextView) view.findViewById(2131363383)).setChecked(this.items.get(i).isChecked());
            view.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -2));
            viewHolder = new com.up366.mobile.course.unfamiliarWords.popup.ListPopupWindowAdapter.ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (com.up366.mobile.course.unfamiliarWords.popup.ListPopupWindowAdapter.ViewHolder) view.getTag();
        }
        viewHolder.tvTitle.setText(getItem(i).getTitle());
        viewHolder.ivImage.setImageResource(getItem(i).getImageRes());
        return view;
    }

    static class ViewHolder {
        android.widget.ImageView ivImage;
        android.widget.TextView tvTitle;

        ViewHolder(android.view.View view) {
            this.tvTitle = (android.widget.TextView) view.findViewById(2131363383);
            this.ivImage = (android.widget.ImageView) view.findViewById(2131362573);
        }
    }
}
