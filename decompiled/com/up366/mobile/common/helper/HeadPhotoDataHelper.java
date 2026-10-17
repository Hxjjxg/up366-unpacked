package com.up366.mobile.common.helper;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class HeadPhotoDataHelper {
    public java.util.List<com.up366.mobile.common.helper.HeadPhotoDataHelper.PhotoData> getDatas() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.up366.mobile.common.helper.HeadPhotoDataHelper.PhotoData(1, "天学小天 ", "https://up366-bucket1.oss-cn-beijing.aliyuncs.com/2020/05/31/f626b8d0a28e11ea8f035ba1e0f2fe34/2189710d5d5534dce8c72e3c96892c46.png"));
        arrayList.add(new com.up366.mobile.common.helper.HeadPhotoDataHelper.PhotoData(2, "宇航员小天 ", "https://up366-bucket1.oss-cn-beijing.aliyuncs.com/2020/05/31/abaa4560a28e11ea8f035ba1e0f2fe34/15bb829c7ea7cc7d5a7942df12de0fa1.png"));
        arrayList.add(new com.up366.mobile.common.helper.HeadPhotoDataHelper.PhotoData(3, "王者小天 ", "https://up366-bucket1.oss-cn-beijing.aliyuncs.com/2020/05/30/89b46c60a28e11ea8f035ba1e0f2fe34/03364d940aec92cf704181849f74f36b.png"));
        arrayList.add(new com.up366.mobile.common.helper.HeadPhotoDataHelper.PhotoData(4, "学习侠小天 ", "https://up366-bucket1.oss-cn-beijing.aliyuncs.com/2020/05/31/d113e860a28e11ea8f035ba1e0f2fe34/059f45f15f0c5aab74ebd1006d0df37d.png"));
        arrayList.add(new com.up366.mobile.common.helper.HeadPhotoDataHelper.PhotoData(5, "爱心小天 ", "https://up366-bucket1.oss-cn-beijing.aliyuncs.com/2020/05/30/4c8403b0a28d11ea8f035ba1e0f2fe34/d6fb9588e0335ddc0773a685a31ef52a.png"));
        arrayList.add(new com.up366.mobile.common.helper.HeadPhotoDataHelper.PhotoData(6, "美食家小天 ", "https://up366-bucket1.oss-cn-beijing.aliyuncs.com/2020/05/30/e9e13380a28d11ea8f035ba1e0f2fe34/9bc2d24d0d584c5b357839d16c9e48bd.png"));
        arrayList.add(new com.up366.mobile.common.helper.HeadPhotoDataHelper.PhotoData(7, "奋斗的小天 ", "https://up366-bucket1.oss-cn-beijing.aliyuncs.com/2020/05/30/10ddab80a28e11ea8f035ba1e0f2fe34/a08d20a806edf8d09d7d5a344a2d50ff.png"));
        arrayList.add(new com.up366.mobile.common.helper.HeadPhotoDataHelper.PhotoData(8, "博士小天 ", "https://up366-bucket1.oss-cn-beijing.aliyuncs.com/2020/05/30/b8330020a28d11ea8f035ba1e0f2fe34/2e8899b2daf7b92929af381e727d38c4.png"));
        arrayList.add(new com.up366.mobile.common.helper.HeadPhotoDataHelper.PhotoData(9, "医生小天 ", "https://up366-bucket1.oss-cn-beijing.aliyuncs.com/2020/05/30/5072fbb0a28e11ea8f035ba1e0f2fe34/41c22d280e4687579796dd4ee2ec3460.png"));
        arrayList.add(new com.up366.mobile.common.helper.HeadPhotoDataHelper.PhotoData(10, "阳光小天 ", "https://up366-bucket1.oss-cn-beijing.aliyuncs.com/2020/05/30/3395ea20a28e11ea8f035ba1e0f2fe34/89b1ac10654c68a81bea5c778640e71c.png"));
        return arrayList;
    }

    public static class PhotoData {
        private int displayOrder;
        private java.lang.String name;
        private java.lang.String picPath;
        private boolean selected;

        public PhotoData(int i, java.lang.String str, java.lang.String str2) {
            this.picPath = str2;
            this.name = str;
            this.displayOrder = i;
        }

        public java.lang.String getPicPath() {
            return this.picPath;
        }

        public void setPicPath(java.lang.String str) {
            this.picPath = str;
        }

        public java.lang.String getName() {
            return this.name;
        }

        public void setName(java.lang.String str) {
            this.name = str;
        }

        public int getDisplayOrder() {
            return this.displayOrder;
        }

        public void setDisplayOrder(int i) {
            this.displayOrder = i;
        }

        public boolean isSelected() {
            return this.selected;
        }

        public void setSelected(boolean z) {
            this.selected = z;
        }
    }
}
