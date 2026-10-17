package com.up366.multimediav2;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class DataBinderMapperImpl extends androidx.databinding.DataBinderMapper {
    private static final android.util.SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYANSWERSMARTCAMERA = 1;
    private static final int LAYOUT_ACTIVITYCROP = 2;
    private static final int LAYOUT_DIALOGANSWERSMARTCAMERAGUIDE = 3;

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray(3);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(com.up366.multimediav2.R.layout.activity_answer_smart_camera, 1);
        sparseIntArray.put(com.up366.multimediav2.R.layout.activity_crop, 2);
        sparseIntArray.put(com.up366.multimediav2.R.layout.dialog_answer_smart_camera_guide, 3);
    }

    public androidx.databinding.ViewDataBinding getDataBinder(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        java.lang.Object tag = view.getTag();
        if (tag == null) {
            throw new java.lang.RuntimeException("view must have a tag");
        }
        if (i2 == 1) {
            if ("layout/activity_answer_smart_camera_0".equals(tag)) {
                return new com.up366.multimediav2.databinding.ActivityAnswerSmartCameraBindingImpl(dataBindingComponent, view);
            }
            throw new java.lang.IllegalArgumentException("The tag for activity_answer_smart_camera is invalid. Received: " + tag);
        }
        if (i2 == 2) {
            if ("layout/activity_crop_0".equals(tag)) {
                return new com.up366.multimediav2.databinding.ActivityCropBindingImpl(dataBindingComponent, view);
            }
            throw new java.lang.IllegalArgumentException("The tag for activity_crop is invalid. Received: " + tag);
        }
        if (i2 != 3) {
            return null;
        }
        if ("layout/dialog_answer_smart_camera_guide_0".equals(tag)) {
            return new com.up366.multimediav2.databinding.DialogAnswerSmartCameraGuideBindingImpl(dataBindingComponent, view);
        }
        throw new java.lang.IllegalArgumentException("The tag for dialog_answer_smart_camera_guide is invalid. Received: " + tag);
    }

    public androidx.databinding.ViewDataBinding getDataBinder(androidx.databinding.DataBindingComponent dataBindingComponent, android.view.View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new java.lang.RuntimeException("view must have a tag");
    }

    public int getLayoutId(java.lang.String str) {
        java.lang.Integer num;
        if (str == null || (num = com.up366.multimediav2.DataBinderMapperImpl.InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public java.lang.String convertBrIdToString(int i) {
        return com.up366.multimediav2.DataBinderMapperImpl.InnerBrLookup.sKeys.get(i);
    }

    public java.util.List<androidx.databinding.DataBinderMapper> collectDependencies() {
        java.util.ArrayList arrayList = new java.util.ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final android.util.SparseArray<java.lang.String> sKeys;

        private InnerBrLookup() {
        }

        static {
            android.util.SparseArray<java.lang.String> sparseArray = new android.util.SparseArray<>(1);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    private static class InnerLayoutIdLookup {
        static final java.util.HashMap<java.lang.String, java.lang.Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            java.util.HashMap<java.lang.String, java.lang.Integer> map = new java.util.HashMap<>(3);
            sKeys = map;
            map.put("layout/activity_answer_smart_camera_0", java.lang.Integer.valueOf(com.up366.multimediav2.R.layout.activity_answer_smart_camera));
            map.put("layout/activity_crop_0", java.lang.Integer.valueOf(com.up366.multimediav2.R.layout.activity_crop));
            map.put("layout/dialog_answer_smart_camera_guide_0", java.lang.Integer.valueOf(com.up366.multimediav2.R.layout.dialog_answer_smart_camera_guide));
        }
    }
}
