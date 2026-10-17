package com.up366.medialibrary.third.ucrop;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UCrop {
    public static final java.lang.String EXTRA_ASPECT_RATIO_X = "com.up366.medialibrary.third.ucrop.AspectRatioX";
    public static final java.lang.String EXTRA_ASPECT_RATIO_Y = "com.up366.medialibrary.third.ucrop.AspectRatioY";
    public static final java.lang.String EXTRA_EDITOR_IMAGE = "com.up366.medialibrary.third.ucrop.EditorImage";
    public static final java.lang.String EXTRA_ERROR = "com.up366.medialibrary.third.ucrop.Error";
    public static final java.lang.String EXTRA_INPUT_URI = "com.up366.medialibrary.third.ucrop.InputUri";
    public static final java.lang.String EXTRA_MAX_SIZE_X = "com.up366.medialibrary.third.ucrop.MaxSizeX";
    public static final java.lang.String EXTRA_MAX_SIZE_Y = "com.up366.medialibrary.third.ucrop.MaxSizeY";
    public static final java.lang.String EXTRA_OUTPUT_CROP_ASPECT_RATIO = "com.up366.medialibrary.third.ucrop.CropAspectRatio";
    public static final java.lang.String EXTRA_OUTPUT_IMAGE_HEIGHT = "com.up366.medialibrary.third.ucrop.ImageHeight";
    public static final java.lang.String EXTRA_OUTPUT_IMAGE_WIDTH = "com.up366.medialibrary.third.ucrop.ImageWidth";
    public static final java.lang.String EXTRA_OUTPUT_OFFSET_X = "com.up366.medialibrary.third.ucrop.OffsetX";
    public static final java.lang.String EXTRA_OUTPUT_OFFSET_Y = "com.up366.medialibrary.third.ucrop.OffsetY";
    public static final java.lang.String EXTRA_OUTPUT_URI = "com.up366.medialibrary.third.ucrop.OutputUri";
    private static final java.lang.String EXTRA_PREFIX = "com.up366.medialibrary.third.ucrop";
    public static final int MIN_SIZE = 10;
    public static final int REQUEST_CROP = 69;
    public static final int REQUEST_MULTI_CROP = 609;
    public static final int RESULT_ERROR = 96;
    private final android.content.Intent mCropIntent = new android.content.Intent();
    private final android.os.Bundle mCropOptionsBundle;

    public static com.up366.medialibrary.third.ucrop.UCrop of(android.net.Uri uri, android.net.Uri uri2) {
        return new com.up366.medialibrary.third.ucrop.UCrop(uri, uri2);
    }

    private UCrop(android.net.Uri uri, android.net.Uri uri2) {
        android.os.Bundle bundle = new android.os.Bundle();
        this.mCropOptionsBundle = bundle;
        bundle.putParcelable(EXTRA_INPUT_URI, uri);
        bundle.putParcelable(EXTRA_OUTPUT_URI, uri2);
    }

    public com.up366.medialibrary.third.ucrop.UCrop withAspectRatio(float f, float f2) {
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_X, f);
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_Y, f2);
        return this;
    }

    public com.up366.medialibrary.third.ucrop.UCrop useSourceImageAspectRatio() {
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_X, 0.0f);
        this.mCropOptionsBundle.putFloat(EXTRA_ASPECT_RATIO_Y, 0.0f);
        return this;
    }

    public com.up366.medialibrary.third.ucrop.UCrop withMaxResultSize(int i, int i2) {
        if (i < 10) {
            i = 10;
        }
        if (i2 < 10) {
            i2 = 10;
        }
        this.mCropOptionsBundle.putInt(EXTRA_MAX_SIZE_X, i);
        this.mCropOptionsBundle.putInt(EXTRA_MAX_SIZE_Y, i2);
        return this;
    }

    public com.up366.medialibrary.third.ucrop.UCrop withOptions(com.up366.medialibrary.third.ucrop.UCrop.Options options) {
        this.mCropOptionsBundle.putAll(options.getOptionBundle());
        return this;
    }

    public void startAnimationActivity(android.app.Activity activity, int i) {
        if (i != 0) {
            start(activity, 69, i);
        } else {
            start(activity, 69);
        }
    }

    public void start(android.app.Activity activity, int i, int i2) {
        activity.startActivityForResult(getIntent(activity), i);
        activity.overridePendingTransition(i2, com.up366.medialibrary.R.anim.ucrop_anim_fade_in);
    }

    public void start(android.app.Activity activity, int i) {
        activity.startActivityForResult(getIntent(activity), i);
    }

    public void start(androidx.appcompat.app.AppCompatActivity appCompatActivity) {
        start(appCompatActivity, 69);
    }

    public void start(androidx.appcompat.app.AppCompatActivity appCompatActivity, int i) {
        appCompatActivity.startActivityForResult(getIntent(appCompatActivity), i);
    }

    public void start(android.content.Context context, androidx.fragment.app.Fragment fragment) {
        start(context, fragment, 69);
    }

    public void start(android.content.Context context, androidx.fragment.app.Fragment fragment, int i) {
        fragment.startActivityForResult(getIntent(context), i);
    }

    public void startAnimationMultipleCropActivity(android.app.Activity activity, int i) {
        if (i != 0) {
            startMultiple(activity, REQUEST_MULTI_CROP, i);
        } else {
            startMultiple(activity, REQUEST_MULTI_CROP);
        }
    }

    public void startMultiple(android.app.Activity activity, int i, int i2) {
        activity.startActivityForResult(getMultipleIntent(activity), i);
        activity.overridePendingTransition(i2, com.up366.medialibrary.R.anim.ucrop_anim_fade_in);
    }

    public void startMultiple(android.app.Activity activity) {
        start(activity, REQUEST_MULTI_CROP);
    }

    public void startMultiple(android.app.Activity activity, int i) {
        activity.startActivityForResult(getMultipleIntent(activity), i);
    }

    public android.content.Intent getMultipleIntent(android.content.Context context) {
        this.mCropIntent.setClass(context, com.up366.medialibrary.third.ucrop.PictureMultiCuttingActivity.class);
        this.mCropIntent.putExtras(this.mCropOptionsBundle);
        return this.mCropIntent;
    }

    public android.content.Intent getIntent(android.content.Context context) {
        this.mCropIntent.setClass(context, com.up366.medialibrary.third.ucrop.UCropActivity.class);
        this.mCropIntent.putExtras(this.mCropOptionsBundle);
        return this.mCropIntent;
    }

    public static android.net.Uri getOutput(android.content.Intent intent) {
        return (android.net.Uri) intent.getParcelableExtra(EXTRA_OUTPUT_URI);
    }

    public static int getOutputImageWidth(android.content.Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_IMAGE_WIDTH, -1);
    }

    public static int getOutputImageHeight(android.content.Intent intent) {
        return intent.getIntExtra(EXTRA_OUTPUT_IMAGE_HEIGHT, -1);
    }

    public static float getOutputCropAspectRatio(android.content.Intent intent) {
        return intent.getFloatExtra(EXTRA_OUTPUT_CROP_ASPECT_RATIO, 0.0f);
    }

    public static java.lang.Throwable getError(android.content.Intent intent) {
        return (java.lang.Throwable) intent.getSerializableExtra(EXTRA_ERROR);
    }

    public static java.util.ArrayList<com.up366.medialibrary.model.LocalMedia> getMultipleOutput(android.content.Intent intent) {
        return intent.getParcelableArrayListExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_OUTPUT_URI_LIST);
    }

    public static class Options {
        public static final java.lang.String EXTRA_ACTIVITY_ORIENTATION = "com.up366.medialibrary.third.ucrop.activityOrientation";
        public static final java.lang.String EXTRA_ALLOWED_GESTURES = "com.up366.medialibrary.third.ucrop.AllowedGestures";
        public static final java.lang.String EXTRA_ASPECT_RATIO_OPTIONS = "com.up366.medialibrary.third.ucrop.AspectRatioOptions";
        public static final java.lang.String EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT = "com.up366.medialibrary.third.ucrop.AspectRatioSelectedByDefault";
        public static final java.lang.String EXTRA_CAMERA = "com.up366.medialibrary.third.ucrop.isCamera";
        public static final java.lang.String EXTRA_CIRCLE_DIMMED_LAYER = "com.up366.medialibrary.third.ucrop.CircleDimmedLayer";
        public static final java.lang.String EXTRA_CIRCLE_STROKE_WIDTH_LAYER = "com.up366.medialibrary.third.ucrop.CircleStrokeWidth";
        public static final java.lang.String EXTRA_COMPRESSION_FORMAT_NAME = "com.up366.medialibrary.third.ucrop.CompressionFormatName";
        public static final java.lang.String EXTRA_COMPRESSION_QUALITY = "com.up366.medialibrary.third.ucrop.CompressionQuality";
        public static final java.lang.String EXTRA_CROP_FRAME_COLOR = "com.up366.medialibrary.third.ucrop.CropFrameColor";
        public static final java.lang.String EXTRA_CROP_FRAME_STROKE_WIDTH = "com.up366.medialibrary.third.ucrop.CropFrameStrokeWidth";
        public static final java.lang.String EXTRA_CROP_GRID_COLOR = "com.up366.medialibrary.third.ucrop.CropGridColor";
        public static final java.lang.String EXTRA_CROP_GRID_COLUMN_COUNT = "com.up366.medialibrary.third.ucrop.CropGridColumnCount";
        public static final java.lang.String EXTRA_CROP_GRID_ROW_COUNT = "com.up366.medialibrary.third.ucrop.CropGridRowCount";
        public static final java.lang.String EXTRA_CROP_GRID_STROKE_WIDTH = "com.up366.medialibrary.third.ucrop.CropGridStrokeWidth";
        public static final java.lang.String EXTRA_CUT_CROP = "com.up366.medialibrary.third.ucrop.cuts";
        public static final java.lang.String EXTRA_DIMMED_LAYER_BORDER_COLOR = "com.up366.medialibrary.third.ucrop.DimmedLayerBorderColor";
        public static final java.lang.String EXTRA_DIMMED_LAYER_COLOR = "com.up366.medialibrary.third.ucrop.DimmedLayerColor";
        public static final java.lang.String EXTRA_DRAG_CROP_FRAME = "com.up366.medialibrary.third.ucrop.DragCropFrame";
        public static final java.lang.String EXTRA_DRAG_SMOOTH_CENTER = "com.up366.medialibrary.third.ucrop.DragSmoothToCenter";
        public static final java.lang.String EXTRA_EDITOR_IMAGE = "com.up366.medialibrary.third.ucrop.EditorImage";
        public static final java.lang.String EXTRA_FREE_STYLE_CROP = "com.up366.medialibrary.third.ucrop.FreeStyleCrop";
        public static final java.lang.String EXTRA_FREE_STYLE_CROP_MODE = "com.up366.medialibrary.third.ucrop.FreeStyleCropMode";
        public static final java.lang.String EXTRA_HIDE_BOTTOM_CONTROLS = "com.up366.medialibrary.third.ucrop.HideBottomControls";
        public static final java.lang.String EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = "com.up366.medialibrary.third.ucrop.ImageToCropBoundsAnimDuration";
        public static final java.lang.String EXTRA_INPUT_IMAGE_HEIGHT = "com.up366.medialibrary.third.ucrop.InputImageHeight";
        public static final java.lang.String EXTRA_INPUT_IMAGE_WIDTH = "com.up366.medialibrary.third.ucrop.InputImageWidth";
        public static final java.lang.String EXTRA_MAX_BITMAP_SIZE = "com.up366.medialibrary.third.ucrop.MaxBitmapSize";
        public static final java.lang.String EXTRA_MAX_SCALE_MULTIPLIER = "com.up366.medialibrary.third.ucrop.MaxScaleMultiplier";
        public static final java.lang.String EXTRA_MULTIPLE_RECYCLERANIMATION = ".isMultipleAnimation";
        public static final java.lang.String EXTRA_NAV_BAR_COLOR = "com.up366.medialibrary.third.ucrop.navBarColor";
        public static final java.lang.String EXTRA_OUTPUT_URI_LIST = "com.up366.medialibrary.third.ucrop.OutputUriList";
        public static final java.lang.String EXTRA_RENAME_CROP_FILENAME = "com.up366.medialibrary.third.ucrop.RenameCropFileName";
        public static final java.lang.String EXTRA_ROTATE = "com.up366.medialibrary.third.ucrop.rotate";
        public static final java.lang.String EXTRA_SCALE = "com.up366.medialibrary.third.ucrop.scale";
        public static final java.lang.String EXTRA_SHOW_CROP_FRAME = "com.up366.medialibrary.third.ucrop.ShowCropFrame";
        public static final java.lang.String EXTRA_SHOW_CROP_GRID = "com.up366.medialibrary.third.ucrop.ShowCropGrid";
        public static final java.lang.String EXTRA_SKIP_MULTIPLE_CROP = "com.up366.medialibrary.third.ucrop.skip_multiple_crop";
        public static final java.lang.String EXTRA_STATUS_BAR_COLOR = "com.up366.medialibrary.third.ucrop.StatusBarColor";
        public static final java.lang.String EXTRA_TOOL_BAR_COLOR = "com.up366.medialibrary.third.ucrop.ToolbarColor";
        public static final java.lang.String EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE = "com.up366.medialibrary.third.ucrop.UcropColorControlsWidgetActive";
        public static final java.lang.String EXTRA_UCROP_COLOR_WIDGET_ACTIVE = "com.up366.medialibrary.third.ucrop.UcropColorWidgetActive";
        public static final java.lang.String EXTRA_UCROP_LOGO_COLOR = "com.up366.medialibrary.third.ucrop.UcropLogoColor";
        public static final java.lang.String EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR = "com.up366.medialibrary.third.ucrop.UcropRootViewBackgroundColor";
        public static final java.lang.String EXTRA_UCROP_TITLE_TEXT_TOOLBAR = "com.up366.medialibrary.third.ucrop.UcropToolbarTitleText";
        public static final java.lang.String EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE = "com.up366.medialibrary.third.ucrop.UcropToolbarCancelDrawable";
        public static final java.lang.String EXTRA_UCROP_WIDGET_COLOR_TOOLBAR = "com.up366.medialibrary.third.ucrop.UcropToolbarWidgetColor";
        public static final java.lang.String EXTRA_UCROP_WIDGET_CROP_DRAWABLE = "com.up366.medialibrary.third.ucrop.UcropToolbarCropDrawable";
        public static final java.lang.String EXTRA_UCROP_WIDGET_CROP_OPEN_WHITE_STATUSBAR = "com.up366.medialibrary.third.ucrop.openWhiteStatusBar";
        public static final java.lang.String EXTRA_WINDOW_EXIT_ANIMATION = "com.up366.medialibrary.third.ucrop.WindowAnimation";
        public static final java.lang.String EXTRA_WITH_VIDEO_IMAGE = "com.up366.medialibrary.third.ucrop.isWithVideoImage";
        private final android.os.Bundle mOptionBundle = new android.os.Bundle();

        public android.os.Bundle getOptionBundle() {
            return this.mOptionBundle;
        }

        public void setCompressionFormat(android.graphics.Bitmap.CompressFormat compressFormat) {
            this.mOptionBundle.putString(EXTRA_COMPRESSION_FORMAT_NAME, compressFormat.name());
        }

        public void setCompressionQuality(int i) {
            this.mOptionBundle.putInt(EXTRA_COMPRESSION_QUALITY, i);
        }

        public void setRequestedOrientation(int i) {
            this.mOptionBundle.putInt(EXTRA_ACTIVITY_ORIENTATION, i);
        }

        public void setRenameCropFileName(java.lang.String str) {
            this.mOptionBundle.putString(EXTRA_RENAME_CROP_FILENAME, str);
        }

        public void isCamera(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_CAMERA, z);
        }

        public void isMultipleRecyclerAnimation(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_MULTIPLE_RECYCLERANIMATION, z);
        }

        public void setCutListData(java.util.ArrayList<com.up366.medialibrary.model.LocalMedia> arrayList) {
            this.mOptionBundle.putParcelableArrayList(EXTRA_CUT_CROP, arrayList);
        }

        public void isWithVideoImage(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_WITH_VIDEO_IMAGE, z);
        }

        public void setAllowedGestures(int i, int i2, int i3) {
            this.mOptionBundle.putIntArray(EXTRA_ALLOWED_GESTURES, new int[]{i, i2, i3});
        }

        public void setMaxScaleMultiplier(float f) {
            this.mOptionBundle.putFloat(EXTRA_MAX_SCALE_MULTIPLIER, f);
        }

        public void setImageToCropBoundsAnimDuration(int i) {
            this.mOptionBundle.putInt(EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, i);
        }

        public void setMaxBitmapSize(int i) {
            this.mOptionBundle.putInt(EXTRA_MAX_BITMAP_SIZE, i);
        }

        public void setDimmedLayerColor(int i) {
            this.mOptionBundle.putInt(EXTRA_DIMMED_LAYER_COLOR, i);
        }

        public void setDimmedLayerBorderColor(int i) {
            if (i != 0) {
                this.mOptionBundle.putInt(EXTRA_DIMMED_LAYER_BORDER_COLOR, i);
            }
        }

        public void setCircleStrokeWidth(int i) {
            if (i > 0) {
                this.mOptionBundle.putInt(EXTRA_CIRCLE_STROKE_WIDTH_LAYER, i);
            }
        }

        public void setCircleDimmedLayer(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_CIRCLE_DIMMED_LAYER, z);
        }

        public void setShowCropFrame(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_SHOW_CROP_FRAME, z);
        }

        public void setCropFrameColor(int i) {
            this.mOptionBundle.putInt(EXTRA_CROP_FRAME_COLOR, i);
        }

        public void setCropFrameStrokeWidth(int i) {
            this.mOptionBundle.putInt(EXTRA_CROP_FRAME_STROKE_WIDTH, i);
        }

        public void setShowCropGrid(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_SHOW_CROP_GRID, z);
        }

        public void setDragFrameEnabled(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_DRAG_CROP_FRAME, z);
        }

        public void setCropGridRowCount(int i) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_ROW_COUNT, i);
        }

        public void setScaleEnabled(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_SCALE, z);
        }

        public void setRotateEnabled(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_ROTATE, z);
        }

        public void setCropGridColumnCount(int i) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_COLUMN_COUNT, i);
        }

        public void setCropGridColor(int i) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_COLOR, i);
        }

        public void setCropGridStrokeWidth(int i) {
            this.mOptionBundle.putInt(EXTRA_CROP_GRID_STROKE_WIDTH, i);
        }

        public void setToolbarColor(int i) {
            this.mOptionBundle.putInt(EXTRA_TOOL_BAR_COLOR, i);
        }

        public void isOpenWhiteStatusBar(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_UCROP_WIDGET_CROP_OPEN_WHITE_STATUSBAR, z);
        }

        public void setStatusBarColor(int i) {
            this.mOptionBundle.putInt(EXTRA_STATUS_BAR_COLOR, i);
        }

        public void setActiveWidgetColor(int i) {
            this.mOptionBundle.putInt(EXTRA_UCROP_COLOR_WIDGET_ACTIVE, i);
        }

        public void setActiveControlsWidgetColor(int i) {
            this.mOptionBundle.putInt(EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, i);
        }

        public void setToolbarWidgetColor(int i) {
            this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, i);
        }

        public void setToolbarTitle(java.lang.String str) {
            this.mOptionBundle.putString(EXTRA_UCROP_TITLE_TEXT_TOOLBAR, str);
        }

        public void setToolbarCancelDrawable(int i) {
            this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, i);
        }

        public void setToolbarCropDrawable(int i) {
            this.mOptionBundle.putInt(EXTRA_UCROP_WIDGET_CROP_DRAWABLE, i);
        }

        public void setLogoColor(int i) {
            this.mOptionBundle.putInt(EXTRA_UCROP_LOGO_COLOR, i);
        }

        public void isMultipleSkipCrop(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_SKIP_MULTIPLE_CROP, z);
        }

        public void setHideBottomControls(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_HIDE_BOTTOM_CONTROLS, z);
        }

        public void setEditorImage(boolean z) {
            this.mOptionBundle.putBoolean("com.up366.medialibrary.third.ucrop.EditorImage", z);
        }

        public void setFreeStyleCropEnabled(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_FREE_STYLE_CROP, z);
        }

        public void setFreestyleCropMode(int i) {
            this.mOptionBundle.putInt(EXTRA_FREE_STYLE_CROP_MODE, i);
        }

        public void setCropDragSmoothToCenter(boolean z) {
            this.mOptionBundle.putBoolean(EXTRA_DRAG_SMOOTH_CENTER, z);
        }

        public void setCropExitAnimation(int i) {
            this.mOptionBundle.putInt(EXTRA_WINDOW_EXIT_ANIMATION, i);
        }

        public void setInputImageWidth(int i) {
            this.mOptionBundle.putInt(EXTRA_INPUT_IMAGE_WIDTH, i);
        }

        public void setInputImageHeight(int i) {
            this.mOptionBundle.putInt(EXTRA_INPUT_IMAGE_HEIGHT, i);
        }

        public void setNavBarColor(int i) {
            if (i != 0) {
                this.mOptionBundle.putInt(EXTRA_NAV_BAR_COLOR, i);
            }
        }

        public void setAspectRatioOptions(int i, com.up366.medialibrary.third.ucrop.model.AspectRatio... aspectRatioArr) {
            if (i > aspectRatioArr.length) {
                throw new java.lang.IllegalArgumentException(java.lang.String.format(java.util.Locale.US, "Index [selectedByDefault = %d] cannot be higher than aspect ratio options count [count = %d].", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(aspectRatioArr.length)));
            }
            this.mOptionBundle.putInt(EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, i);
            this.mOptionBundle.putParcelableArrayList(EXTRA_ASPECT_RATIO_OPTIONS, new java.util.ArrayList<>(java.util.Arrays.asList(aspectRatioArr)));
        }

        public void setRootViewBackgroundColor(int i) {
            this.mOptionBundle.putInt(EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, i);
        }

        public void withAspectRatio(float f, float f2) {
            this.mOptionBundle.putFloat(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_ASPECT_RATIO_X, f);
            this.mOptionBundle.putFloat(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_ASPECT_RATIO_Y, f2);
        }

        public void useSourceImageAspectRatio() {
            this.mOptionBundle.putFloat(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_ASPECT_RATIO_X, 0.0f);
            this.mOptionBundle.putFloat(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_ASPECT_RATIO_Y, 0.0f);
        }

        public void withMaxResultSize(int i, int i2) {
            this.mOptionBundle.putInt(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_MAX_SIZE_X, i);
            this.mOptionBundle.putInt(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_MAX_SIZE_Y, i2);
        }
    }
}
