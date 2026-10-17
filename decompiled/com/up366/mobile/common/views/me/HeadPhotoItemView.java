package com.up366.mobile.common.views.me;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class HeadPhotoItemView extends android.widget.FrameLayout {
    private com.up366.mobile.databinding.MePhotoItemViewLayoutBinding binding;
    private com.up366.mobile.common.logic.model.UserPhoto photoData;

    public HeadPhotoItemView(android.content.Context context) {
        super(context);
        initAttr(context, null, 0);
    }

    public HeadPhotoItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        initAttr(context, attributeSet, 0);
    }

    public HeadPhotoItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttr(context, attributeSet, i);
    }

    private void initAttr(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        this.binding = (com.up366.mobile.databinding.MePhotoItemViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.me_photo_item_view_layout, this, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.up366.common.EventBusUtilsUp.register(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.up366.common.EventBusUtilsUp.unregister(this);
    }

    public void setData(final com.up366.mobile.common.logic.model.UserPhoto userPhoto) {
        this.photoData = userPhoto;
        com.up366.common.BitmapUtilsUp.display(this.binding.image, userPhoto.getUrl(), com.up366.mobile.R.drawable.icon_head_photo_default);
        this.binding.headLayout.setBackgroundResource(userPhoto.isSelected() ? com.up366.mobile.R.drawable.white_background_10dp_width1dp : com.up366.mobile.R.drawable.white_background_10dp);
        this.binding.text.setText(userPhoto.getPhotoName());
        setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.me.HeadPhotoItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.common.EventBusUtilsUp.post(new com.up366.mobile.common.event.SelectHeadPhotoEvent(userPhoto));
            }
        });
    }

    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void onMessageEvent(com.up366.mobile.common.event.SelectHeadPhotoEvent selectHeadPhotoEvent) {
        com.up366.mobile.common.logic.model.UserPhoto userPhoto = this.photoData;
        userPhoto.setSelected(userPhoto.getUid().equals(selectHeadPhotoEvent.photoData.getUid()));
        setData(this.photoData);
    }
}
