package com.up366.mobile.databinding;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public final class ActivityPhotographSkillBinding implements androidx.viewbinding.ViewBinding {
    public final com.up366.mobile.common.views.TitleBarView rbvRecognitionSkillBack;
    private final android.widget.RelativeLayout rootView;

    private ActivityPhotographSkillBinding(android.widget.RelativeLayout relativeLayout, com.up366.mobile.common.views.TitleBarView titleBarView) {
        this.rootView = relativeLayout;
        this.rbvRecognitionSkillBack = titleBarView;
    }

    public android.widget.RelativeLayout getRoot() {
        return this.rootView;
    }

    public static com.up366.mobile.databinding.ActivityPhotographSkillBinding inflate(android.view.LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static com.up366.mobile.databinding.ActivityPhotographSkillBinding inflate(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, boolean z) {
        android.view.View viewInflate = layoutInflater.inflate(com.up366.mobile.R.layout.activity_photograph_skill, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static com.up366.mobile.databinding.ActivityPhotographSkillBinding bind(android.view.View view) {
        com.up366.mobile.common.views.TitleBarView titleBarView = (com.up366.mobile.common.views.TitleBarView) androidx.viewbinding.ViewBindings.findChildViewById(view, com.up366.mobile.R.id.rbv_recognition_skill_back);
        if (titleBarView != null) {
            return new com.up366.mobile.databinding.ActivityPhotographSkillBinding((android.widget.RelativeLayout) view, titleBarView);
        }
        throw new java.lang.NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(com.up366.mobile.R.id.rbv_recognition_skill_back)));
    }
}
