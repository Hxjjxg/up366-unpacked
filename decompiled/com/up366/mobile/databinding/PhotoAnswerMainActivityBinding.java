package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class PhotoAnswerMainActivityBinding implements androidx.viewbinding.ViewBinding {
    public final android.widget.TextView alumTv;
    public final android.widget.TextView autoTip;
    public final com.up366.mobile.course.p1p.view.GraphicOverlay borderView;
    public final android.widget.ImageButton btBack;
    public final androidx.constraintlayout.widget.ConstraintLayout clPhotoResult;
    public final androidx.constraintlayout.widget.ConstraintLayout clRoot;
    public final androidx.constraintlayout.widget.ConstraintLayout clShowPage;
    public final androidx.constraintlayout.widget.ConstraintLayout clSmartCamera;
    public final androidx.constraintlayout.widget.ConstraintLayout clSmartCameraBottom;
    public final androidx.constraintlayout.widget.ConstraintLayout clTitleBack;
    public final android.widget.ImageButton ibDelete;
    public final android.widget.TextView ibGuide;
    public final android.widget.ImageButton ibShowPageRetract;
    public final android.widget.ImageView ivLoading;
    public final android.widget.ImageView ivPhotoResultBg;
    public final android.widget.ImageView ivReadyTips;
    public final com.up366.mobile.course.p1p.view.P1pScanImageView ivResultShow;
    public final androidx.constraintlayout.widget.ConstraintLayout loadingLayout;
    public final androidx.camera.view.PreviewView previewView;
    public final android.view.TextureView previewView1;
    public final android.widget.FrameLayout previewViewHolder;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final androidx.recyclerview.widget.RecyclerView rvPageList;
    public final android.widget.TextView scanTips;
    public final android.widget.TextView takePhotoBtn;
    public final android.widget.LinearLayout tipTextLayout;
    public final android.widget.TextView tipTxt;
    public final com.up366.mobile.common.views.MarqueTextView title;
    public final androidx.constraintlayout.widget.ConstraintLayout tvReadyTips;
    public final com.up366.qmui.widget.roundwidget.QMUIRoundButton tvStart;
    public final com.up366.qmui.widget.roundwidget.QMUIRoundButton tvSubmit;
    public final android.view.View vAnim;
    public final android.view.View vScreenMask;
    public final androidx.viewpager.widget.ViewPager vpImagesShow;

    private PhotoAnswerMainActivityBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, android.widget.TextView textView, android.widget.TextView textView2, com.up366.mobile.course.p1p.view.GraphicOverlay graphicOverlay, android.widget.ImageButton imageButton, androidx.constraintlayout.widget.ConstraintLayout constraintLayout2, androidx.constraintlayout.widget.ConstraintLayout constraintLayout3, androidx.constraintlayout.widget.ConstraintLayout constraintLayout4, androidx.constraintlayout.widget.ConstraintLayout constraintLayout5, androidx.constraintlayout.widget.ConstraintLayout constraintLayout6, androidx.constraintlayout.widget.ConstraintLayout constraintLayout7, android.widget.ImageButton imageButton2, android.widget.TextView textView3, android.widget.ImageButton imageButton3, android.widget.ImageView imageView, android.widget.ImageView imageView2, android.widget.ImageView imageView3, com.up366.mobile.course.p1p.view.P1pScanImageView p1pScanImageView, androidx.constraintlayout.widget.ConstraintLayout constraintLayout8, androidx.camera.view.PreviewView previewView, android.view.TextureView textureView, android.widget.FrameLayout frameLayout, androidx.recyclerview.widget.RecyclerView recyclerView, android.widget.TextView textView4, android.widget.TextView textView5, android.widget.LinearLayout linearLayout, android.widget.TextView textView6, com.up366.mobile.common.views.MarqueTextView marqueTextView, androidx.constraintlayout.widget.ConstraintLayout constraintLayout9, com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton, com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton2, android.view.View view, android.view.View view2, androidx.viewpager.widget.ViewPager viewPager) {
        this.rootView = constraintLayout;
        this.alumTv = textView;
        this.autoTip = textView2;
        this.borderView = graphicOverlay;
        this.btBack = imageButton;
        this.clPhotoResult = constraintLayout2;
        this.clRoot = constraintLayout3;
        this.clShowPage = constraintLayout4;
        this.clSmartCamera = constraintLayout5;
        this.clSmartCameraBottom = constraintLayout6;
        this.clTitleBack = constraintLayout7;
        this.ibDelete = imageButton2;
        this.ibGuide = textView3;
        this.ibShowPageRetract = imageButton3;
        this.ivLoading = imageView;
        this.ivPhotoResultBg = imageView2;
        this.ivReadyTips = imageView3;
        this.ivResultShow = p1pScanImageView;
        this.loadingLayout = constraintLayout8;
        this.previewView = previewView;
        this.previewView1 = textureView;
        this.previewViewHolder = frameLayout;
        this.rvPageList = recyclerView;
        this.scanTips = textView4;
        this.takePhotoBtn = textView5;
        this.tipTextLayout = linearLayout;
        this.tipTxt = textView6;
        this.title = marqueTextView;
        this.tvReadyTips = constraintLayout9;
        this.tvStart = qMUIRoundButton;
        this.tvSubmit = qMUIRoundButton2;
        this.vAnim = view;
        this.vScreenMask = view2;
        this.vpImagesShow = viewPager;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.PhotoAnswerMainActivityBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.PhotoAnswerMainActivityBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.photo_answer_main_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.PhotoAnswerMainActivityBinding bind(android.view.View view) {
        int i = com.up366.mobile.R.id.alum_tv;
        android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.alum_tv);
        if (textView != null) {
            i = com.up366.mobile.R.id.auto_tip;
            android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.auto_tip);
            if (textView2 != null) {
                i = com.up366.mobile.R.id.border_view;
                com.up366.mobile.course.p1p.view.GraphicOverlay graphicOverlay = (com.up366.mobile.course.p1p.view.GraphicOverlay) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.border_view);
                if (graphicOverlay != null) {
                    i = com.up366.mobile.R.id.bt_back;
                    android.widget.ImageButton imageButton = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.bt_back);
                    if (imageButton != null) {
                        i = com.up366.mobile.R.id.cl_photo_result;
                        androidx.constraintlayout.widget.ConstraintLayout constraintLayoutFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.cl_photo_result);
                        if (constraintLayoutFindChildViewById != null) {
                            androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) view;
                            i = com.up366.mobile.R.id.cl_show_page;
                            androidx.constraintlayout.widget.ConstraintLayout constraintLayoutFindChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.cl_show_page);
                            if (constraintLayoutFindChildViewById2 != null) {
                                i = com.up366.mobile.R.id.cl_smart_camera;
                                androidx.constraintlayout.widget.ConstraintLayout constraintLayoutFindChildViewById3 = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.cl_smart_camera);
                                if (constraintLayoutFindChildViewById3 != null) {
                                    i = com.up366.mobile.R.id.cl_smart_camera_bottom;
                                    androidx.constraintlayout.widget.ConstraintLayout constraintLayoutFindChildViewById4 = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.cl_smart_camera_bottom);
                                    if (constraintLayoutFindChildViewById4 != null) {
                                        i = com.up366.mobile.R.id.cl_title_back;
                                        androidx.constraintlayout.widget.ConstraintLayout constraintLayoutFindChildViewById5 = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.cl_title_back);
                                        if (constraintLayoutFindChildViewById5 != null) {
                                            i = com.up366.mobile.R.id.ib_delete;
                                            android.widget.ImageButton imageButton2 = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ib_delete);
                                            if (imageButton2 != null) {
                                                i = com.up366.mobile.R.id.ib_guide;
                                                android.widget.TextView textView3 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ib_guide);
                                                if (textView3 != null) {
                                                    i = com.up366.mobile.R.id.ib_show_page_retract;
                                                    android.widget.ImageButton imageButton3 = (android.widget.ImageButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.ib_show_page_retract);
                                                    if (imageButton3 != null) {
                                                        i = com.up366.mobile.R.id.iv_loading;
                                                        android.widget.ImageView imageView = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_loading);
                                                        if (imageView != null) {
                                                            i = com.up366.mobile.R.id.iv_photo_result_bg;
                                                            android.widget.ImageView imageView2 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_photo_result_bg);
                                                            if (imageView2 != null) {
                                                                i = com.up366.mobile.R.id.iv_ready_tips;
                                                                android.widget.ImageView imageView3 = (android.widget.ImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_ready_tips);
                                                                if (imageView3 != null) {
                                                                    i = com.up366.mobile.R.id.iv_result_show;
                                                                    com.up366.mobile.course.p1p.view.P1pScanImageView p1pScanImageView = (com.up366.mobile.course.p1p.view.P1pScanImageView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.iv_result_show);
                                                                    if (p1pScanImageView != null) {
                                                                        i = com.up366.mobile.R.id.loading_layout;
                                                                        androidx.constraintlayout.widget.ConstraintLayout constraintLayoutFindChildViewById6 = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.loading_layout);
                                                                        if (constraintLayoutFindChildViewById6 != null) {
                                                                            i = com.up366.mobile.R.id.preview_view;
                                                                            androidx.camera.view.PreviewView previewViewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.preview_view);
                                                                            if (previewViewFindChildViewById != null) {
                                                                                i = com.up366.mobile.R.id.preview_view1;
                                                                                android.view.TextureView textureView = (android.view.TextureView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.preview_view1);
                                                                                if (textureView != null) {
                                                                                    i = com.up366.mobile.R.id.preview_view_holder;
                                                                                    android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.preview_view_holder);
                                                                                    if (frameLayout != null) {
                                                                                        i = com.up366.mobile.R.id.rv_page_list;
                                                                                        androidx.recyclerview.widget.RecyclerView recyclerViewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.rv_page_list);
                                                                                        if (recyclerViewFindChildViewById != null) {
                                                                                            i = com.up366.mobile.R.id.scanTips;
                                                                                            android.widget.TextView textView4 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.scanTips);
                                                                                            if (textView4 != null) {
                                                                                                i = com.up366.mobile.R.id.take_photo_btn;
                                                                                                android.widget.TextView textView5 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.take_photo_btn);
                                                                                                if (textView5 != null) {
                                                                                                    i = com.up366.mobile.R.id.tip_text_layout;
                                                                                                    android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tip_text_layout);
                                                                                                    if (linearLayout != null) {
                                                                                                        i = com.up366.mobile.R.id.tip_txt;
                                                                                                        android.widget.TextView textView6 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tip_txt);
                                                                                                        if (textView6 != null) {
                                                                                                            i = 2131363459;
                                                                                                            com.up366.mobile.common.views.MarqueTextView marqueTextView = (com.up366.mobile.common.views.MarqueTextView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131363459);
                                                                                                            if (marqueTextView != null) {
                                                                                                                i = com.up366.mobile.R.id.tv_ready_tips;
                                                                                                                androidx.constraintlayout.widget.ConstraintLayout constraintLayoutFindChildViewById7 = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_ready_tips);
                                                                                                                if (constraintLayoutFindChildViewById7 != null) {
                                                                                                                    i = com.up366.mobile.R.id.tv_start;
                                                                                                                    com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton = (com.up366.qmui.widget.roundwidget.QMUIRoundButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_start);
                                                                                                                    if (qMUIRoundButton != null) {
                                                                                                                        i = com.up366.mobile.R.id.tv_submit;
                                                                                                                        com.up366.qmui.widget.roundwidget.QMUIRoundButton qMUIRoundButton2 = (com.up366.qmui.widget.roundwidget.QMUIRoundButton) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.tv_submit);
                                                                                                                        if (qMUIRoundButton2 != null) {
                                                                                                                            i = com.up366.mobile.R.id.v_anim;
                                                                                                                            android.view.View viewFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.v_anim);
                                                                                                                            if (viewFindChildViewById != null) {
                                                                                                                                i = com.up366.mobile.R.id.v_screen_mask;
                                                                                                                                android.view.View viewFindChildViewById2 = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.v_screen_mask);
                                                                                                                                if (viewFindChildViewById2 != null) {
                                                                                                                                    i = com.up366.mobile.R.id.vp_images_show;
                                                                                                                                    androidx.viewpager.widget.ViewPager viewPagerFindChildViewById = androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.vp_images_show);
                                                                                                                                    if (viewPagerFindChildViewById != null) {
                                                                                                                                        return new com.up366.mobile.databinding.PhotoAnswerMainActivityBinding(constraintLayout, textView, textView2, graphicOverlay, imageButton, constraintLayoutFindChildViewById, constraintLayout, constraintLayoutFindChildViewById2, constraintLayoutFindChildViewById3, constraintLayoutFindChildViewById4, constraintLayoutFindChildViewById5, imageButton2, textView3, imageButton3, imageView, imageView2, imageView3, p1pScanImageView, constraintLayoutFindChildViewById6, previewViewFindChildViewById, textureView, frameLayout, recyclerViewFindChildViewById, textView4, textView5, linearLayout, textView6, marqueTextView, constraintLayoutFindChildViewById7, qMUIRoundButton, qMUIRoundButton2, viewFindChildViewById, viewFindChildViewById2, viewPagerFindChildViewById);
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
