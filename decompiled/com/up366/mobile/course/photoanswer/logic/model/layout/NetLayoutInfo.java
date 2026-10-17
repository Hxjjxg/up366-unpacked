package com.up366.mobile.course.photoanswer.logic.model.layout;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class NetLayoutInfo {
    private java.util.List<com.up366.mobile.course.photoanswer.logic.model.layout.NetBlock> blocks;
    private com.up366.mobile.course.photoanswer.logic.model.layout.NetImageInfo image;

    public com.up366.mobile.course.photoanswer.logic.model.layout.NetImageInfo getImage() {
        return this.image;
    }

    public void setImage(com.up366.mobile.course.photoanswer.logic.model.layout.NetImageInfo netImageInfo) {
        this.image = netImageInfo;
    }

    public java.util.List<com.up366.mobile.course.photoanswer.logic.model.layout.NetBlock> getBlocks() {
        return this.blocks;
    }

    public void setBlocks(java.util.List<com.up366.mobile.course.photoanswer.logic.model.layout.NetBlock> list) {
        this.blocks = list;
    }
}
