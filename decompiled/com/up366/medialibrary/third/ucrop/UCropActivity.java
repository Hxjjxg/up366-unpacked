package com.up366.medialibrary.third.ucrop;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UCropActivity extends androidx.appcompat.app.AppCompatActivity {
    public static final int ALL = 3;
    private static final long CONTROLS_ANIMATION_DURATION = 50;
    public static final android.graphics.Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = android.graphics.Bitmap.CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
    public static final int SCALE = 1;
    private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
    private static final int TABS_COUNT = 3;
    private static final java.lang.String TAG = "UCropActivity";
    private boolean isDragFrame;
    private boolean isOpenWhiteStatusBar;
    private boolean isRotateEnabled;
    private boolean isScaleEnabled;
    private int mActiveControlsWidgetColor;
    private int mActiveWidgetColor;
    protected android.view.View mBlockingView;
    private androidx.transition.Transition mControlsTransition;
    private com.up366.medialibrary.third.ucrop.view.GestureCropImageView mGestureCropImageView;
    private android.view.ViewGroup mLayoutAspectRatio;
    private android.view.ViewGroup mLayoutRotate;
    private android.view.ViewGroup mLayoutScale;
    private int mLogoColor;
    private com.up366.medialibrary.third.ucrop.view.OverlayView mOverlayView;
    private int mRootViewBackgroundColor;
    protected int mScreenWidth;
    protected boolean mShowBottomControls;
    private int mStatusBarColor;
    private android.widget.TextView mTextViewRotateAngle;
    private android.widget.TextView mTextViewScalePercent;
    private int mToolbarCancelDrawable;
    private int mToolbarColor;
    private int mToolbarCropDrawable;
    private java.lang.String mToolbarTitle;
    private int mToolbarWidgetColor;
    private com.up366.medialibrary.third.ucrop.view.UCropView mUCropView;
    private android.view.ViewGroup mWrapperStateAspectRatio;
    private android.view.ViewGroup mWrapperStateRotate;
    private android.view.ViewGroup mWrapperStateScale;
    protected android.widget.RelativeLayout uCropPhotoBox;
    private boolean mShowLoader = true;
    private java.util.List<android.view.ViewGroup> mCropAspectRatioViews = new java.util.ArrayList();
    private java.util.List<com.up366.medialibrary.third.ucrop.view.widget.AspectRatioTextView> mAspectRatioTextViews = new java.util.ArrayList();
    private android.graphics.Bitmap.CompressFormat mCompressFormat = DEFAULT_COMPRESS_FORMAT;
    private int mCompressQuality = 90;
    private int[] mAllowedGestures = {1, 2, 3};
    private com.up366.medialibrary.third.ucrop.view.TransformImageView.TransformImageListener mImageListener = new com.up366.medialibrary.third.ucrop.view.TransformImageView.TransformImageListener() { // from class: com.up366.medialibrary.third.ucrop.UCropActivity.1
        @Override // com.up366.medialibrary.third.ucrop.view.TransformImageView.TransformImageListener
        public void onRotate(float f) {
            com.up366.medialibrary.third.ucrop.UCropActivity.this.setAngleText(f);
        }

        @Override // com.up366.medialibrary.third.ucrop.view.TransformImageView.TransformImageListener
        public void onScale(float f) {
            com.up366.medialibrary.third.ucrop.UCropActivity.this.setScaleText(f);
        }

        @Override // com.up366.medialibrary.third.ucrop.view.TransformImageView.TransformImageListener
        public void onLoadComplete() {
            com.up366.medialibrary.third.ucrop.UCropActivity.this.mUCropView.animate().alpha(1.0f).setDuration(300L).setInterpolator(new android.view.animation.AccelerateInterpolator());
            com.up366.medialibrary.third.ucrop.UCropActivity.this.mBlockingView.setClickable(!com.up366.medialibrary.third.ucrop.UCropActivity.this.isOnTouch());
            com.up366.medialibrary.third.ucrop.UCropActivity.this.mShowLoader = false;
            com.up366.medialibrary.third.ucrop.UCropActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // com.up366.medialibrary.third.ucrop.view.TransformImageView.TransformImageListener
        public void onLoadFailure(java.lang.Exception exc) {
            com.up366.medialibrary.third.ucrop.UCropActivity.this.setResultError(exc);
            com.up366.medialibrary.third.ucrop.UCropActivity.this.onBackPressed();
        }
    };
    private final android.view.View.OnClickListener mStateClickListener = new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.third.ucrop.UCropActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            if (view.isSelected()) {
                return;
            }
            com.up366.medialibrary.third.ucrop.UCropActivity.this.setWidgetState(view.getId());
        }
    };

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface GestureTypes {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected android.app.Activity getCurrentActivity() {
        return this;
    }

    public boolean isImmersive() {
        return true;
    }

    public void immersive() {
        com.up366.medialibrary.common.utils.ImmersiveManage.immersiveAboveAPI23(this, this.mStatusBarColor, this.mToolbarColor, this.isOpenWhiteStatusBar);
    }

    static {
        androidx.appcompat.app.AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        android.content.Intent intent = getIntent();
        setNewRequestedOrientation(intent);
        getCustomOptionsData(intent);
        if (isImmersive()) {
            immersive();
        }
        setContentView(com.up366.medialibrary.R.layout.ucrop_activity_photobox);
        this.mScreenWidth = com.up366.medialibrary.common.utils.ScreenUtils.getScreenWidth(this);
        setupViews(intent);
        setNavBar();
        setImageData(intent);
        setInitialState();
        addBlockingView();
    }

    protected void setNewRequestedOrientation(android.content.Intent intent) {
        int intExtra = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_ACTIVITY_ORIENTATION, -1);
        if (getRequestedOrientation() != intExtra) {
            setRequestedOrientation(intExtra);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getCustomOptionsData(android.content.Intent intent) {
        this.isOpenWhiteStatusBar = intent.getBooleanExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_UCROP_WIDGET_CROP_OPEN_WHITE_STATUSBAR, false);
        this.mStatusBarColor = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_STATUS_BAR_COLOR, androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.ucrop_color_statusbar));
        int intExtra = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_TOOL_BAR_COLOR, androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.ucrop_color_toolbar));
        this.mToolbarColor = intExtra;
        if (intExtra == 0) {
            this.mToolbarColor = androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.ucrop_color_toolbar);
        }
        if (this.mStatusBarColor == 0) {
            this.mStatusBarColor = androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.ucrop_color_statusbar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(com.up366.medialibrary.R.menu.ucrop_menu_activity, menu);
        android.view.MenuItem menuItemFindItem = menu.findItem(com.up366.medialibrary.R.id.menu_loader);
        android.graphics.drawable.Drawable icon = menuItemFindItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(androidx.core.graphics.BlendModeColorFilterCompat.createBlendModeColorFilterCompat(this.mToolbarWidgetColor, androidx.core.graphics.BlendModeCompat.SRC_ATOP));
                menuItemFindItem.setIcon(icon);
            } catch (java.lang.IllegalStateException e) {
                android.util.Log.i(TAG, java.lang.String.format("%s - %s", e.getMessage(), "必須指定輸入以及輸出的 Uri"));
            }
            ((android.graphics.drawable.Animatable) menuItemFindItem.getIcon()).start();
        }
        android.view.MenuItem menuItemFindItem2 = menu.findItem(com.up366.medialibrary.R.id.menu_crop);
        android.graphics.drawable.Drawable drawable = androidx.core.content.ContextCompat.getDrawable(this, this.mToolbarCropDrawable);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(androidx.core.graphics.BlendModeColorFilterCompat.createBlendModeColorFilterCompat(this.mToolbarWidgetColor, androidx.core.graphics.BlendModeCompat.SRC_ATOP));
            menuItemFindItem2.setIcon(drawable);
        }
        return true;
    }

    public boolean onPrepareOptionsMenu(android.view.Menu menu) {
        menu.findItem(com.up366.medialibrary.R.id.menu_crop).setVisible(!this.mShowLoader);
        menu.findItem(com.up366.medialibrary.R.id.menu_loader).setVisible(this.mShowLoader);
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        if (menuItem.getItemId() == com.up366.medialibrary.R.id.menu_crop) {
            cropAndSaveImage();
            return true;
        }
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onStop() {
        super.onStop();
        com.up366.medialibrary.third.ucrop.view.GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        if (gestureCropImageView != null) {
            gestureCropImageView.cancelAllAnimations();
        }
    }

    protected void setImageData(android.content.Intent intent) {
        android.net.Uri uri = (android.net.Uri) intent.getParcelableExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_INPUT_URI);
        android.net.Uri uri2 = (android.net.Uri) intent.getParcelableExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_URI);
        processOptions(intent);
        if (uri != null && uri2 != null) {
            try {
                boolean zIsOnTouch = isOnTouch(uri);
                this.mGestureCropImageView.setRotateEnabled(zIsOnTouch ? this.isRotateEnabled : zIsOnTouch);
                com.up366.medialibrary.third.ucrop.view.GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
                if (zIsOnTouch) {
                    zIsOnTouch = this.isScaleEnabled;
                }
                gestureCropImageView.setScaleEnabled(zIsOnTouch);
                this.mGestureCropImageView.setImageUri(uri, uri2, intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_INPUT_IMAGE_WIDTH, 0), intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_INPUT_IMAGE_HEIGHT, 0));
                return;
            } catch (java.lang.Exception e) {
                setResultError(e);
                onBackPressed();
                return;
            }
        }
        setResultError(new java.lang.NullPointerException("在你的 App 內复写颜色资源 (ucrop_color_toolbar_widget) 使 5.0 以前裝置正常运作"));
        onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOnTouch() {
        android.net.Uri uri = (android.net.Uri) getIntent().getParcelableExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_INPUT_URI);
        if (uri == null) {
            return true;
        }
        return isOnTouch(uri);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isOnTouch(android.net.Uri uri) {
        if (uri == null) {
            return true;
        }
        if (com.up366.medialibrary.common.utils.MimeTypeUtils.isHttp(uri.toString())) {
            return !com.up366.medialibrary.common.utils.MimeTypeUtils.isGifForSuffix(com.up366.medialibrary.common.utils.MimeTypeUtils.getLastImgType(uri.toString()));
        }
        java.lang.String mimeTypeFromMediaContentUri = com.up366.medialibrary.common.utils.MimeTypeUtils.getMimeTypeFromMediaContentUri(this, uri);
        if (mimeTypeFromMediaContentUri.endsWith(gdut.bsx.share2.ShareContentType.IMAGE)) {
            mimeTypeFromMediaContentUri = com.up366.medialibrary.common.utils.MimeTypeUtils.getImageMimeType(com.up366.medialibrary.common.utils.PictureFileUtils.getPath(this, uri));
        }
        return !com.up366.medialibrary.common.utils.MimeTypeUtils.isGif(mimeTypeFromMediaContentUri);
    }

    private void processOptions(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_COMPRESSION_FORMAT_NAME);
        android.graphics.Bitmap.CompressFormat compressFormatValueOf = !android.text.TextUtils.isEmpty(stringExtra) ? android.graphics.Bitmap.CompressFormat.valueOf(stringExtra) : null;
        if (compressFormatValueOf == null) {
            compressFormatValueOf = DEFAULT_COMPRESS_FORMAT;
        }
        this.mCompressFormat = compressFormatValueOf;
        this.mCompressQuality = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_COMPRESSION_QUALITY, 90);
        this.mOverlayView.setDimmedBorderColor(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_DIMMED_LAYER_BORDER_COLOR, getResources().getColor(com.up366.medialibrary.R.color.ucrop_color_default_crop_frame)));
        this.isDragFrame = intent.getBooleanExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_DRAG_CROP_FRAME, true);
        this.mOverlayView.setDimmedStrokeWidth(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_CIRCLE_STROKE_WIDTH_LAYER, 1));
        this.isScaleEnabled = intent.getBooleanExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_SCALE, true);
        this.isRotateEnabled = intent.getBooleanExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_ROTATE, true);
        int[] intArrayExtra = intent.getIntArrayExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_ALLOWED_GESTURES);
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.mAllowedGestures = intArrayExtra;
        }
        this.mGestureCropImageView.setMaxBitmapSize(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_MAX_BITMAP_SIZE, 0));
        this.mGestureCropImageView.setMaxScaleMultiplier(intent.getFloatExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_MAX_SCALE_MULTIPLIER, 10.0f));
        this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 500));
        int intExtra = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_FREE_STYLE_CROP_MODE, -1);
        if (intExtra == -1 || intExtra > 2) {
            this.mOverlayView.setFreestyleCropEnabled(intent.getBooleanExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_FREE_STYLE_CROP, false));
        } else {
            this.mOverlayView.setFreestyleCropMode(intExtra);
        }
        this.mOverlayView.setDragSmoothToCenter(intent.getBooleanExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_DRAG_SMOOTH_CENTER, false));
        this.mOverlayView.setDragFrame(this.isDragFrame);
        this.mOverlayView.setDimmedColor(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_DIMMED_LAYER_COLOR, getResources().getColor(com.up366.medialibrary.R.color.ucrop_color_default_dimmed)));
        this.mOverlayView.setCircleDimmedLayer(intent.getBooleanExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_CIRCLE_DIMMED_LAYER, false));
        this.mOverlayView.setShowCropFrame(intent.getBooleanExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_SHOW_CROP_FRAME, true));
        this.mOverlayView.setCropFrameColor(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_CROP_FRAME_COLOR, getResources().getColor(com.up366.medialibrary.R.color.ucrop_color_default_crop_frame)));
        this.mOverlayView.setCropFrameStrokeWidth(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_CROP_FRAME_STROKE_WIDTH, getResources().getDimensionPixelSize(com.up366.medialibrary.R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.mOverlayView.setShowCropGrid(intent.getBooleanExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_SHOW_CROP_GRID, true));
        this.mOverlayView.setCropGridRowCount(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_CROP_GRID_ROW_COUNT, 2));
        this.mOverlayView.setCropGridColumnCount(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_CROP_GRID_COLUMN_COUNT, 2));
        this.mOverlayView.setCropGridColor(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_CROP_GRID_COLOR, getResources().getColor(com.up366.medialibrary.R.color.ucrop_color_default_crop_grid)));
        this.mOverlayView.setCropGridStrokeWidth(intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_CROP_GRID_STROKE_WIDTH, getResources().getDimensionPixelSize(com.up366.medialibrary.R.dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_ASPECT_RATIO_X, 0.0f);
        float floatExtra2 = intent.getFloatExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_ASPECT_RATIO_Y, 0.0f);
        int intExtra2 = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        java.util.ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (floatExtra > 0.0f && floatExtra2 > 0.0f) {
            android.view.ViewGroup viewGroup = this.mWrapperStateAspectRatio;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.mGestureCropImageView.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra != null && intExtra2 < parcelableArrayListExtra.size()) {
            this.mGestureCropImageView.setTargetAspectRatio(((com.up366.medialibrary.third.ucrop.model.AspectRatio) parcelableArrayListExtra.get(intExtra2)).getAspectRatioX() / ((com.up366.medialibrary.third.ucrop.model.AspectRatio) parcelableArrayListExtra.get(intExtra2)).getAspectRatioY());
        } else {
            this.mGestureCropImageView.setTargetAspectRatio(0.0f);
        }
        int intExtra3 = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_MAX_SIZE_X, 0);
        int intExtra4 = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_MAX_SIZE_Y, 0);
        if (intExtra3 <= 0 || intExtra4 <= 0) {
            return;
        }
        this.mGestureCropImageView.setMaxResultImageSizeX(intExtra3);
        this.mGestureCropImageView.setMaxResultImageSizeY(intExtra4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void setupViews(android.content.Intent intent) {
        this.mStatusBarColor = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_STATUS_BAR_COLOR, androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.ucrop_color_statusbar));
        this.mToolbarColor = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_TOOL_BAR_COLOR, androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.ucrop_color_toolbar));
        this.mActiveWidgetColor = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_UCROP_COLOR_WIDGET_ACTIVE, androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.ucrop_color_widget_background));
        this.mActiveControlsWidgetColor = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.ucrop_color_active_controls_color));
        this.mToolbarWidgetColor = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.ucrop_color_toolbar_widget));
        this.mToolbarCancelDrawable = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, com.up366.medialibrary.R.drawable.ucrop_ic_cross);
        this.mToolbarCropDrawable = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_UCROP_WIDGET_CROP_DRAWABLE, com.up366.medialibrary.R.drawable.ucrop_ic_done);
        java.lang.String stringExtra = intent.getStringExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_UCROP_TITLE_TEXT_TOOLBAR);
        this.mToolbarTitle = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(com.up366.medialibrary.R.string.ucrop_label_edit_photo);
        }
        this.mToolbarTitle = stringExtra;
        this.mLogoColor = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_UCROP_LOGO_COLOR, androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.ucrop_color_default_logo));
        this.mShowBottomControls = !intent.getBooleanExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_HIDE_BOTTOM_CONTROLS, false);
        this.mRootViewBackgroundColor = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, androidx.core.content.ContextCompat.getColor(this, com.up366.medialibrary.R.color.ucrop_color_crop_background));
        setupAppBar();
        initiateRootViews();
        if (this.mShowBottomControls) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) ((android.view.ViewGroup) findViewById(com.up366.medialibrary.R.id.ucrop_photobox)).findViewById(com.up366.medialibrary.R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            viewGroup.setBackgroundColor(this.mRootViewBackgroundColor);
            android.view.LayoutInflater.from(this).inflate(com.up366.medialibrary.R.layout.ucrop_controls, viewGroup, true);
            androidx.transition.AutoTransition autoTransition = new androidx.transition.AutoTransition();
            this.mControlsTransition = autoTransition;
            autoTransition.setDuration(50L);
            android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) findViewById(com.up366.medialibrary.R.id.state_aspect_ratio);
            this.mWrapperStateAspectRatio = viewGroup2;
            viewGroup2.setOnClickListener(this.mStateClickListener);
            android.view.ViewGroup viewGroup3 = (android.view.ViewGroup) findViewById(com.up366.medialibrary.R.id.state_rotate);
            this.mWrapperStateRotate = viewGroup3;
            viewGroup3.setOnClickListener(this.mStateClickListener);
            android.view.ViewGroup viewGroup4 = (android.view.ViewGroup) findViewById(com.up366.medialibrary.R.id.state_scale);
            this.mWrapperStateScale = viewGroup4;
            viewGroup4.setOnClickListener(this.mStateClickListener);
            this.mLayoutAspectRatio = (android.view.ViewGroup) findViewById(com.up366.medialibrary.R.id.layout_aspect_ratio);
            this.mLayoutRotate = (android.view.ViewGroup) findViewById(com.up366.medialibrary.R.id.layout_rotate_wheel);
            this.mLayoutScale = (android.view.ViewGroup) findViewById(com.up366.medialibrary.R.id.layout_scale_wheel);
            setupAspectRatioWidget(intent);
            setupRotateWidget();
            setupScaleWidget();
            setupStatesWrapper();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setupAppBar() {
        setStatusBarColor(this.mStatusBarColor);
        androidx.appcompat.widget.Toolbar toolbarFindViewById = findViewById(com.up366.medialibrary.R.id.toolbar);
        toolbarFindViewById.setBackgroundColor(this.mToolbarColor);
        toolbarFindViewById.setTitleTextColor(this.mToolbarWidgetColor);
        android.widget.TextView textView = (android.widget.TextView) toolbarFindViewById.findViewById(com.up366.medialibrary.R.id.toolbar_title);
        textView.setTextColor(this.mToolbarWidgetColor);
        textView.setText(this.mToolbarTitle);
        android.graphics.drawable.Drawable drawableMutate = androidx.appcompat.content.res.AppCompatResources.getDrawable(this, this.mToolbarCancelDrawable).mutate();
        drawableMutate.setColorFilter(androidx.core.graphics.BlendModeColorFilterCompat.createBlendModeColorFilterCompat(this.mToolbarWidgetColor, androidx.core.graphics.BlendModeCompat.SRC_ATOP));
        toolbarFindViewById.setNavigationIcon(drawableMutate);
        setSupportActionBar(toolbarFindViewById);
        androidx.appcompat.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void initiateRootViews() {
        this.uCropPhotoBox = (android.widget.RelativeLayout) findViewById(com.up366.medialibrary.R.id.ucrop_photobox);
        com.up366.medialibrary.third.ucrop.view.UCropView uCropView = (com.up366.medialibrary.third.ucrop.view.UCropView) findViewById(com.up366.medialibrary.R.id.ucrop);
        this.mUCropView = uCropView;
        this.mGestureCropImageView = uCropView.getCropImageView();
        this.mOverlayView = this.mUCropView.getOverlayView();
        this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
        ((android.widget.ImageView) findViewById(com.up366.medialibrary.R.id.image_view_logo)).setColorFilter(this.mLogoColor, android.graphics.PorterDuff.Mode.SRC_ATOP);
        findViewById(com.up366.medialibrary.R.id.ucrop_frame).setBackgroundColor(this.mRootViewBackgroundColor);
    }

    private void setupStatesWrapper() {
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.up366.medialibrary.R.id.image_view_state_scale);
        android.widget.ImageView imageView2 = (android.widget.ImageView) findViewById(com.up366.medialibrary.R.id.image_view_state_rotate);
        android.widget.ImageView imageView3 = (android.widget.ImageView) findViewById(com.up366.medialibrary.R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new com.up366.medialibrary.third.ucrop.util.SelectedStateListDrawable(imageView.getDrawable(), this.mActiveControlsWidgetColor));
        imageView2.setImageDrawable(new com.up366.medialibrary.third.ucrop.util.SelectedStateListDrawable(imageView2.getDrawable(), this.mActiveControlsWidgetColor));
        imageView3.setImageDrawable(new com.up366.medialibrary.third.ucrop.util.SelectedStateListDrawable(imageView3.getDrawable(), this.mActiveControlsWidgetColor));
    }

    private void setNavBar() {
        int intExtra = getIntent().getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_NAV_BAR_COLOR, 0);
        if (intExtra != 0) {
            getWindow().setNavigationBarColor(intExtra);
        }
    }

    private void setStatusBarColor(int i) {
        android.view.Window window = getWindow();
        if (window != null) {
            window.addFlags(com.up366.qmui.widget.tab.QMUITab.SIGN_COUNT_VIEW_LAYOUT_VERTICAL_CENTER);
            window.setStatusBarColor(i);
        }
    }

    private void setupAspectRatioWidget(android.content.Intent intent) {
        int intExtra = intent.getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        java.util.ArrayList<com.up366.medialibrary.third.ucrop.model.AspectRatio> parcelableArrayListExtra = intent.getParcelableArrayListExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            parcelableArrayListExtra = new java.util.ArrayList();
            parcelableArrayListExtra.add(new com.up366.medialibrary.third.ucrop.model.AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new com.up366.medialibrary.third.ucrop.model.AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new com.up366.medialibrary.third.ucrop.model.AspectRatio(getString(com.up366.medialibrary.R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new com.up366.medialibrary.third.ucrop.model.AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new com.up366.medialibrary.third.ucrop.model.AspectRatio(null, 16.0f, 9.0f));
            intExtra = 2;
        }
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) findViewById(com.up366.medialibrary.R.id.layout_aspect_ratio);
        int i = -1;
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        if (getCurrentActivity() instanceof com.up366.medialibrary.third.ucrop.PictureMultiCuttingActivity) {
            this.mAspectRatioTextViews = new java.util.ArrayList();
            this.mCropAspectRatioViews = new java.util.ArrayList();
        }
        for (com.up366.medialibrary.third.ucrop.model.AspectRatio aspectRatio : parcelableArrayListExtra) {
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) getLayoutInflater().inflate(com.up366.medialibrary.R.layout.ucrop_aspect_ratio, (android.view.ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            com.up366.medialibrary.third.ucrop.view.widget.AspectRatioTextView aspectRatioTextView = (com.up366.medialibrary.third.ucrop.view.widget.AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.mActiveControlsWidgetColor);
            aspectRatioTextView.setAspectRatio(aspectRatio);
            this.mAspectRatioTextViews.add(aspectRatioTextView);
            linearLayout.addView(frameLayout);
            this.mCropAspectRatioViews.add(frameLayout);
        }
        this.mCropAspectRatioViews.get(intExtra).setSelected(true);
        for (android.view.ViewGroup viewGroup : this.mCropAspectRatioViews) {
            i++;
            viewGroup.setTag(java.lang.Integer.valueOf(i));
            viewGroup.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.third.ucrop.UCropActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.setTargetAspectRatio(((com.up366.medialibrary.third.ucrop.view.widget.AspectRatioTextView) ((android.view.ViewGroup) view).getChildAt(0)).getAspectRatio(view.isSelected()));
                    com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
                    if (view.isSelected()) {
                        return;
                    }
                    for (android.view.ViewGroup viewGroup2 : com.up366.medialibrary.third.ucrop.UCropActivity.this.mCropAspectRatioViews) {
                        viewGroup2.setSelected(viewGroup2 == view);
                    }
                }
            });
        }
    }

    private void setupRotateWidget() {
        this.mTextViewRotateAngle = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.text_view_rotate);
        ((com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView) findViewById(com.up366.medialibrary.R.id.rotate_scroll_wheel)).setScrollingListener(new com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener() { // from class: com.up366.medialibrary.third.ucrop.UCropActivity.3
            @Override // com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScroll(float f, float f2) {
                com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.postRotate(f / 42.0f);
            }

            @Override // com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollEnd() {
                com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            @Override // com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollStart() {
                com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView) findViewById(com.up366.medialibrary.R.id.rotate_scroll_wheel)).setMiddleLineColor(this.mActiveWidgetColor);
        findViewById(com.up366.medialibrary.R.id.wrapper_reset_rotate).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.third.ucrop.UCropActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.up366.medialibrary.third.ucrop.UCropActivity.this.resetRotation();
            }
        });
        findViewById(com.up366.medialibrary.R.id.wrapper_rotate_by_angle).setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.medialibrary.third.ucrop.UCropActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                com.up366.medialibrary.third.ucrop.UCropActivity.this.rotateByAngle(90);
            }
        });
    }

    private void setupScaleWidget() {
        this.mTextViewScalePercent = (android.widget.TextView) findViewById(com.up366.medialibrary.R.id.text_view_scale);
        ((com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView) findViewById(com.up366.medialibrary.R.id.scale_scroll_wheel)).setScrollingListener(new com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener() { // from class: com.up366.medialibrary.third.ucrop.UCropActivity.6
            @Override // com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScroll(float f, float f2) {
                if (f > 0.0f) {
                    com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.zoomInImage(com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.getCurrentScale() + (f * ((com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.getMaxScale() - com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                } else {
                    com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.zoomOutImage(com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.getCurrentScale() + (f * ((com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.getMaxScale() - com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                }
            }

            @Override // com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollEnd() {
                com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            @Override // com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollStart() {
                com.up366.medialibrary.third.ucrop.UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((com.up366.medialibrary.third.ucrop.view.widget.HorizontalProgressWheelView) findViewById(com.up366.medialibrary.R.id.scale_scroll_wheel)).setMiddleLineColor(this.mActiveWidgetColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAngleText(float f) {
        android.widget.TextView textView = this.mTextViewRotateAngle;
        if (textView != null) {
            textView.setText(java.lang.String.format(java.util.Locale.getDefault(), "%.1f°", java.lang.Float.valueOf(f)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScaleText(float f) {
        android.widget.TextView textView = this.mTextViewScalePercent;
        if (textView != null) {
            textView.setText(java.lang.String.format(java.util.Locale.getDefault(), "%d%%", java.lang.Integer.valueOf((int) (f * 100.0f))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetRotation() {
        com.up366.medialibrary.third.ucrop.view.GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        gestureCropImageView.postRotate(-gestureCropImageView.getCurrentAngle());
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotateByAngle(int i) {
        this.mGestureCropImageView.postRotate(i);
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    protected void setInitialState() {
        if (this.mShowBottomControls) {
            if (this.mWrapperStateAspectRatio.getVisibility() == 0) {
                setWidgetState(com.up366.medialibrary.R.id.state_aspect_ratio);
                return;
            } else {
                setWidgetState(com.up366.medialibrary.R.id.state_scale);
                return;
            }
        }
        setAllowedGestures(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidgetState(int i) {
        if (this.mShowBottomControls) {
            this.mWrapperStateAspectRatio.setSelected(i == com.up366.medialibrary.R.id.state_aspect_ratio);
            this.mWrapperStateRotate.setSelected(i == com.up366.medialibrary.R.id.state_rotate);
            this.mWrapperStateScale.setSelected(i == com.up366.medialibrary.R.id.state_scale);
            this.mLayoutAspectRatio.setVisibility(i == com.up366.medialibrary.R.id.state_aspect_ratio ? 0 : 8);
            this.mLayoutRotate.setVisibility(i == com.up366.medialibrary.R.id.state_rotate ? 0 : 8);
            this.mLayoutScale.setVisibility(i == com.up366.medialibrary.R.id.state_scale ? 0 : 8);
            changeSelectedTab(i);
            if (i == com.up366.medialibrary.R.id.state_scale) {
                setAllowedGestures(0);
            } else if (i == com.up366.medialibrary.R.id.state_rotate) {
                setAllowedGestures(1);
            } else {
                setAllowedGestures(2);
            }
        }
    }

    private void changeSelectedTab(int i) {
        androidx.transition.TransitionManager.beginDelayedTransition((android.view.ViewGroup) findViewById(com.up366.medialibrary.R.id.ucrop_photobox), this.mControlsTransition);
        this.mWrapperStateScale.findViewById(com.up366.medialibrary.R.id.text_view_scale).setVisibility(i == com.up366.medialibrary.R.id.state_scale ? 0 : 8);
        this.mWrapperStateAspectRatio.findViewById(com.up366.medialibrary.R.id.text_view_crop).setVisibility(i == com.up366.medialibrary.R.id.state_aspect_ratio ? 0 : 8);
        this.mWrapperStateRotate.findViewById(com.up366.medialibrary.R.id.text_view_rotate).setVisibility(i != com.up366.medialibrary.R.id.state_rotate ? 8 : 0);
    }

    private void setAllowedGestures(int i) {
        if (isOnTouch()) {
            com.up366.medialibrary.third.ucrop.view.GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
            boolean z = this.isScaleEnabled;
            boolean z2 = false;
            if (z && this.mShowBottomControls) {
                int i2 = this.mAllowedGestures[i];
                z = i2 == 3 || i2 == 1;
            }
            gestureCropImageView.setScaleEnabled(z);
            com.up366.medialibrary.third.ucrop.view.GestureCropImageView gestureCropImageView2 = this.mGestureCropImageView;
            boolean z3 = this.isRotateEnabled;
            if (z3 && this.mShowBottomControls) {
                int i3 = this.mAllowedGestures[i];
                if (i3 == 3 || i3 == 2) {
                    z2 = true;
                }
            } else {
                z2 = z3;
            }
            gestureCropImageView2.setRotateEnabled(z2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void addBlockingView() {
        if (this.mBlockingView == null) {
            this.mBlockingView = new android.view.View(this);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, com.up366.medialibrary.R.id.toolbar);
            this.mBlockingView.setLayoutParams(layoutParams);
            this.mBlockingView.setClickable(true);
        }
        ((android.widget.RelativeLayout) findViewById(com.up366.medialibrary.R.id.ucrop_photobox)).addView(this.mBlockingView);
    }

    protected void cropAndSaveImage() {
        this.mBlockingView.setClickable(true);
        this.mShowLoader = true;
        supportInvalidateOptionsMenu();
        this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, new com.up366.medialibrary.third.ucrop.callback.BitmapCropCallback() { // from class: com.up366.medialibrary.third.ucrop.UCropActivity.8
            @Override // com.up366.medialibrary.third.ucrop.callback.BitmapCropCallback
            public void onBitmapCropped(android.net.Uri uri, int i, int i2, int i3, int i4) {
                com.up366.medialibrary.third.ucrop.UCropActivity uCropActivity = com.up366.medialibrary.third.ucrop.UCropActivity.this;
                uCropActivity.setResultUri(uri, uCropActivity.mGestureCropImageView.getTargetAspectRatio(), i, i2, i3, i4);
                if (com.up366.medialibrary.third.ucrop.UCropActivity.this.getCurrentActivity() instanceof com.up366.medialibrary.third.ucrop.PictureMultiCuttingActivity) {
                    return;
                }
                com.up366.medialibrary.third.ucrop.UCropActivity.this.onBackPressed();
            }

            @Override // com.up366.medialibrary.third.ucrop.callback.BitmapCropCallback
            public void onCropFailure(java.lang.Throwable th) {
                com.up366.medialibrary.third.ucrop.UCropActivity.this.setResultError(th);
                com.up366.medialibrary.third.ucrop.UCropActivity.this.onBackPressed();
            }
        });
    }

    protected void setResultUri(android.net.Uri uri, float f, int i, int i2, int i3, int i4) {
        setResult(-1, new android.content.Intent().putExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_URI, uri).putExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, f).putExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, i3).putExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, i4).putExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_OFFSET_X, i).putExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_OUTPUT_OFFSET_Y, i2).putExtra("com.up366.medialibrary.third.ucrop.EditorImage", getIntent().getBooleanExtra("com.up366.medialibrary.third.ucrop.EditorImage", false)));
    }

    protected void setResultError(java.lang.Throwable th) {
        setResult(96, new android.content.Intent().putExtra(com.up366.medialibrary.third.ucrop.UCrop.EXTRA_ERROR, th));
    }

    public void onBackPressed() {
        closeActivity();
    }

    protected void closeActivity() {
        finish();
        exitAnimation();
    }

    protected void exitAnimation() {
        int intExtra = getIntent().getIntExtra(com.up366.medialibrary.third.ucrop.UCrop.Options.EXTRA_WINDOW_EXIT_ANIMATION, 0);
        int i = com.up366.medialibrary.R.anim.ucrop_anim_fade_in;
        if (intExtra == 0) {
            intExtra = com.up366.medialibrary.R.anim.ucrop_close;
        }
        overridePendingTransition(i, intExtra);
    }
}
