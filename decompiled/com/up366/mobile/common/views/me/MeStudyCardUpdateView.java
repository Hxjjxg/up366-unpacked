package com.up366.mobile.common.views.me;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class MeStudyCardUpdateView extends android.widget.FrameLayout {
    public MeStudyCardUpdateView(android.content.Context context) {
        super(context);
        initAttr(context, null, 0);
    }

    public MeStudyCardUpdateView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        initAttr(context, attributeSet, 0);
    }

    public MeStudyCardUpdateView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttr(context, attributeSet, i);
    }

    private void initAttr(final android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        ((com.up366.mobile.databinding.MeStudyCardUpdateViewLayoutBinding) androidx.databinding.DataBindingUtil.inflate(android.view.LayoutInflater.from(getContext()), com.up366.mobile.R.layout.me_study_card_update_view_layout, this, true)).toUpdateBtn.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.views.me.MeStudyCardUpdateView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.mobile.commonui.webview.CommonJsBridgeWebViewActivity.open(context, com.up366.common.global.GB.get().getServerUrl(com.up366.mobile.BuildConfig.STUDY_CARD_URL) + "?userId=" + com.up366.mobile.common.logic.Auth.UID());
            }
        });
    }
}
