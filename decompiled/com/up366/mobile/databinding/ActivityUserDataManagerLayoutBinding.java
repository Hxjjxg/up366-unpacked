package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ActivityUserDataManagerLayoutBinding implements androidx.viewbinding.ViewBinding {
    public final com.up366.mobile.common.views.TitleBackView back;
    public final android.widget.Button btnDelete;
    public final com.up366.mobile.common.views.UserDataManagerItemView read;
    private final androidx.constraintlayout.widget.ConstraintLayout rootView;
    public final android.widget.TextView subTitle;
    public final android.widget.TextView title;
    public final com.up366.mobile.common.views.UserDataManagerItemView video;
    public final com.up366.mobile.common.views.UserDataManagerItemView voice;
    public final com.up366.mobile.common.views.UserDataManagerItemView write;

    private ActivityUserDataManagerLayoutBinding(androidx.constraintlayout.widget.ConstraintLayout constraintLayout, com.up366.mobile.common.views.TitleBackView titleBackView, android.widget.Button button, com.up366.mobile.common.views.UserDataManagerItemView userDataManagerItemView, android.widget.TextView textView, android.widget.TextView textView2, com.up366.mobile.common.views.UserDataManagerItemView userDataManagerItemView2, com.up366.mobile.common.views.UserDataManagerItemView userDataManagerItemView3, com.up366.mobile.common.views.UserDataManagerItemView userDataManagerItemView4) {
        this.rootView = constraintLayout;
        this.back = titleBackView;
        this.btnDelete = button;
        this.read = userDataManagerItemView;
        this.subTitle = textView;
        this.title = textView2;
        this.video = userDataManagerItemView2;
        this.voice = userDataManagerItemView3;
        this.write = userDataManagerItemView4;
    }

    public androidx.constraintlayout.widget.ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.ActivityUserDataManagerLayoutBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.ActivityUserDataManagerLayoutBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.activity_user_data_manager_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.ActivityUserDataManagerLayoutBinding bind(android.view.View view) {
        int i = 2131361949;
        com.up366.mobile.common.views.TitleBackView titleBackView = (com.up366.mobile.common.views.TitleBackView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131361949);
        if (titleBackView != null) {
            i = com.up366.mobile.R.id.btn_delete;
            android.widget.Button button = (android.widget.Button) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.btn_delete);
            if (button != null) {
                i = com.up366.mobile.R.id.read;
                com.up366.mobile.common.views.UserDataManagerItemView userDataManagerItemView = (com.up366.mobile.common.views.UserDataManagerItemView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.read);
                if (userDataManagerItemView != null) {
                    i = com.up366.mobile.R.id.sub_title;
                    android.widget.TextView textView = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.sub_title);
                    if (textView != null) {
                        i = 2131363459;
                        android.widget.TextView textView2 = (android.widget.TextView) androidx.viewbinding.ViewBindings.findChildViewById(view, 2131363459);
                        if (textView2 != null) {
                            i = com.up366.mobile.R.id.video;
                            com.up366.mobile.common.views.UserDataManagerItemView userDataManagerItemView2 = (com.up366.mobile.common.views.UserDataManagerItemView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.video);
                            if (userDataManagerItemView2 != null) {
                                i = com.up366.mobile.R.id.voice;
                                com.up366.mobile.common.views.UserDataManagerItemView userDataManagerItemView3 = (com.up366.mobile.common.views.UserDataManagerItemView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.voice);
                                if (userDataManagerItemView3 != null) {
                                    i = com.up366.mobile.R.id.write;
                                    com.up366.mobile.common.views.UserDataManagerItemView userDataManagerItemView4 = (com.up366.mobile.common.views.UserDataManagerItemView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.write);
                                    if (userDataManagerItemView4 != null) {
                                        return new com.up366.mobile.databinding.ActivityUserDataManagerLayoutBinding((androidx.constraintlayout.widget.ConstraintLayout) view, titleBackView, button, userDataManagerItemView, textView, textView2, userDataManagerItemView2, userDataManagerItemView3, userDataManagerItemView4);
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
