package com.up366.multimedia.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class TopPopupAdapter extends android.widget.BaseAdapter {
    private android.content.Context context;
    private java.util.List<com.up366.multimedia.util.AlbumHelper.ImageBucket> buckets = new java.util.ArrayList();
    private int curSelectedPosition = 0;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public TopPopupAdapter(android.content.Context context) {
        this.context = context;
    }

    public void setDatas(java.util.List<com.up366.multimedia.util.AlbumHelper.ImageBucket> buckets) {
        this.buckets = buckets;
        notifyDataSetChanged();
    }

    public void setSelectedPosition(int position) {
        for (com.up366.multimedia.util.AlbumHelper.ImageBucket imageBucket : this.buckets) {
            this.buckets.get(this.curSelectedPosition).isSelected = false;
        }
        this.buckets.get(position).isSelected = true;
        this.curSelectedPosition = position;
        notifyDataSetChanged();
    }

    public java.util.List<com.up366.multimedia.util.AlbumHelper.ImageBucket> getDatas() {
        return this.buckets;
    }

    public int getCurSelectedPosition() {
        return this.curSelectedPosition;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.buckets.size();
    }

    @Override // android.widget.Adapter
    public java.lang.Object getItem(int i) {
        return this.buckets.get(i);
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int pos, android.view.View convertView, android.view.ViewGroup viewGroup) {
        com.up366.multimedia.dialog.TopPopupAdapter.ViewHolder viewHolder;
        java.lang.String str;
        if (convertView == null) {
            convertView = android.view.LayoutInflater.from(this.context).inflate(com.afollestad.materialcamera.R.layout.media_popup_dialog_select_folder, (android.view.ViewGroup) null);
            viewHolder = new com.up366.multimedia.dialog.TopPopupAdapter.ViewHolder();
            viewHolder.imageView = (android.widget.ImageView) convertView.findViewById(com.afollestad.materialcamera.R.id.media_dialog_tip_image);
            viewHolder.folderName = (android.widget.TextView) convertView.findViewById(com.afollestad.materialcamera.R.id.media_dialog_album_name);
            viewHolder.fileNum = (android.widget.TextView) convertView.findViewById(com.afollestad.materialcamera.R.id.media_dialog_pic_num);
            viewHolder.selectView = (android.widget.ImageView) convertView.findViewById(com.afollestad.materialcamera.R.id.media_dialog_select_view);
            viewHolder.imageView.setAdjustViewBounds(true);
            viewHolder.imageView.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (com.up366.multimedia.dialog.TopPopupAdapter.ViewHolder) convertView.getTag();
        }
        com.up366.multimedia.util.AlbumHelper.ImageBucket imageBucket = this.buckets.get(pos);
        if (imageBucket.imageList.size() == 0) {
            str = "";
        } else {
            str = imageBucket.imageList.get(0).imagePath;
        }
        com.up366.common.BitmapUtilsUp.display(viewHolder.imageView, str, com.afollestad.materialcamera.R.drawable.media_default);
        viewHolder.folderName.setText(imageBucket.bucketName);
        viewHolder.fileNum.setText(java.lang.String.valueOf(imageBucket.imageList.size()) + "张");
        com.up366.common.BitmapUtilsUp.display(viewHolder.selectView, imageBucket.isSelected ? com.afollestad.materialcamera.R.drawable.radio_selected : com.afollestad.materialcamera.R.drawable.radio_unslected);
        return convertView;
    }

    private class ViewHolder {
        public android.widget.TextView fileNum;
        public android.widget.TextView folderName;
        public android.widget.ImageView imageView;
        public android.widget.ImageView selectView;

        private ViewHolder() {
        }
    }
}
