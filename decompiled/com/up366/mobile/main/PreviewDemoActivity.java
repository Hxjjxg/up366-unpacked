package com.up366.mobile.main;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public class PreviewDemoActivity extends com.up366.mobile.common.base.BaseActivity {
    private com.up366.mobile.databinding.PreviewDemoActivityLayoutBinding b;

    @Override // com.up366.mobile.common.base.BaseActivity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.up366.mobile.databinding.PreviewDemoActivityLayoutBinding previewDemoActivityLayoutBindingInflate = com.up366.mobile.databinding.PreviewDemoActivityLayoutBinding.inflate(getLayoutInflater());
        this.b = previewDemoActivityLayoutBindingInflate;
        setContentView(previewDemoActivityLayoutBindingInflate.getRoot());
        getWindow().setStatusBarColor(getResources().getColor(com.up366.mobile.R.color.c1));
        this.b.getRoot().getRootView().setSystemUiVisibility(this.b.getRoot().getSystemUiVisibility() & (-8193));
        java.lang.String[] strArr = {"https://h5.up366.cn/ciwangzhengba", "https://h5.up366.cn/peiyindaren", "https://h5.up366.cn/duyidu", "https://h5.up366.cn/xieyixie"};
        this.b.item1.setDataPreview(com.up366.mobile.R.drawable.icon_word_race, "词王争霸", com.up366.common.global.GB.get().getServerUrl(strArr[0]), true);
        this.b.item2.setDataPreview(com.up366.mobile.R.drawable.icon_dubbing, "配音达人", com.up366.common.global.GB.get().getServerUrl(strArr[1]), false);
        this.b.item3.setDataPreview(com.up366.mobile.R.drawable.icon_read_it, "读一读", com.up366.common.global.GB.get().getServerUrl(strArr[2]), false);
        this.b.item4.setDataPreview(com.up366.mobile.R.drawable.icon_write_it, "写一写", com.up366.common.global.GB.get().getServerUrl(strArr[3]), false);
        this.b.btnAll.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.PreviewDemoActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f$0.lambda$onCreate$0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(android.view.View view) {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        if (com.up366.mobile.common.utils.DataPostDelay.isNoOutOfDate("press_back")) {
            finishAffinity();
        } else {
            com.up366.mobile.common.utils.DataPostDelay.addCacheFlag("press_back", 3);
            com.up366.mobile.common.utils.ToastPopupUtil.showInfo((android.app.Activity) this, "再按一次返回键退出应用。");
        }
    }
}
