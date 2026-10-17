package com.up366.medialibrary;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class PictureSelector {
    private final java.lang.ref.WeakReference<android.app.Activity> mActivity;
    private final java.lang.ref.WeakReference<androidx.fragment.app.Fragment> mFragment;

    private PictureSelector(android.app.Activity activity) {
        this(activity, null);
    }

    private PictureSelector(androidx.fragment.app.Fragment fragment) {
        this(fragment.getActivity(), fragment);
    }

    private PictureSelector(android.app.Activity activity, androidx.fragment.app.Fragment fragment) {
        this.mActivity = new java.lang.ref.WeakReference<>(activity);
        this.mFragment = new java.lang.ref.WeakReference<>(fragment);
    }

    public static com.up366.medialibrary.PictureSelector create(android.app.Activity activity) {
        return new com.up366.medialibrary.PictureSelector(activity);
    }

    public static com.up366.medialibrary.PictureSelector create(androidx.fragment.app.Fragment fragment) {
        return new com.up366.medialibrary.PictureSelector(fragment);
    }

    public com.up366.medialibrary.PictureSelectionModel openGallery(int i) {
        return new com.up366.medialibrary.PictureSelectionModel(this, i);
    }

    public com.up366.medialibrary.PictureSelectionModel openCamera(int i) {
        return new com.up366.medialibrary.PictureSelectionModel(this, i, true);
    }

    public com.up366.medialibrary.PictureSelectionModel themeStyle(int i) {
        return new com.up366.medialibrary.PictureSelectionModel(this, com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage()).theme(i);
    }

    public com.up366.medialibrary.PictureSelectionModel setPictureStyle(com.up366.medialibrary.common.style.PictureParameterStyle pictureParameterStyle) {
        return new com.up366.medialibrary.PictureSelectionModel(this, com.up366.medialibrary.common.utils.MimeTypeUtils.ofImage()).setPictureStyle(pictureParameterStyle);
    }

    public static java.util.List<com.up366.medialibrary.model.LocalMedia> obtainMultipleResult(android.content.Intent intent) {
        if (intent != null) {
            java.util.ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_RESULT_SELECTION);
            return parcelableArrayListExtra == null ? new java.util.ArrayList() : parcelableArrayListExtra;
        }
        return new java.util.ArrayList();
    }

    public static android.content.Intent putIntentResult(java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        return new android.content.Intent().putParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_RESULT_SELECTION, (java.util.ArrayList) list);
    }

    public static java.util.List<com.up366.medialibrary.model.LocalMedia> obtainSelectorList(android.os.Bundle bundle) {
        if (bundle != null) {
            return bundle.getParcelableArrayList(com.up366.medialibrary.config.PictureConstants.EXTRA_SELECT_LIST);
        }
        return null;
    }

    public static void saveSelectorList(android.os.Bundle bundle, java.util.List<com.up366.medialibrary.model.LocalMedia> list) {
        bundle.putParcelableArrayList(com.up366.medialibrary.config.PictureConstants.EXTRA_SELECT_LIST, (java.util.ArrayList) list);
    }

    public void externalPicturePreview(int i, java.util.List<com.up366.medialibrary.model.LocalMedia> list, int i2) {
        if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (getActivity() != null) {
            android.content.Intent intent = new android.content.Intent(getActivity(), (java.lang.Class<?>) com.up366.medialibrary.activity.PictureExternalPreviewActivity.class);
            intent.putParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PREVIEW_SELECT_LIST, (java.util.ArrayList) list);
            intent.putExtra("position", i);
            getActivity().startActivity(intent);
            android.app.Activity activity = getActivity();
            if (i2 == 0) {
                i2 = com.up366.medialibrary.R.anim.picture_anim_enter;
            }
            activity.overridePendingTransition(i2, com.up366.medialibrary.R.anim.picture_anim_fade_in);
            return;
        }
        throw new java.lang.NullPointerException("Starting the PictureSelector Activity cannot be empty ");
    }

    public void externalPicturePreview(int i, java.lang.String str, java.util.List<com.up366.medialibrary.model.LocalMedia> list, int i2) {
        if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (getActivity() != null) {
            android.content.Intent intent = new android.content.Intent(getActivity(), (java.lang.Class<?>) com.up366.medialibrary.activity.PictureExternalPreviewActivity.class);
            intent.putParcelableArrayListExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_PREVIEW_SELECT_LIST, (java.util.ArrayList) list);
            intent.putExtra("position", i);
            intent.putExtra(com.up366.medialibrary.config.PictureConstants.EXTRA_DIRECTORY_PATH, str);
            getActivity().startActivity(intent);
            android.app.Activity activity = getActivity();
            if (i2 == 0) {
                i2 = com.up366.medialibrary.R.anim.picture_anim_enter;
            }
            activity.overridePendingTransition(i2, com.up366.medialibrary.R.anim.picture_anim_fade_in);
            return;
        }
        throw new java.lang.NullPointerException("Starting the PictureSelector Activity cannot be empty ");
    }

    public void externalPictureVideo(java.lang.String str) {
        if (com.up366.medialibrary.common.utils.DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (getActivity() != null) {
            com.up366.medialibrary.activity.PictureVideoPlayActivity.openActivity(getActivity(), str);
            return;
        }
        throw new java.lang.NullPointerException("Starting the PictureSelector Activity cannot be empty ");
    }

    android.app.Activity getActivity() {
        return this.mActivity.get();
    }

    androidx.fragment.app.Fragment getFragment() {
        java.lang.ref.WeakReference<androidx.fragment.app.Fragment> weakReference = this.mFragment;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
