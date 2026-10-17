package com.up366.mobile.main;

/* JADX INFO: compiled from: NoMessageCodeTipHelper.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/up366/mobile/main/NoMessageCodeTipHelper;", "", "<init>", "()V", "Companion", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NoMessageCodeTipHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final com.up366.mobile.main.NoMessageCodeTipHelper.Companion INSTANCE = new com.up366.mobile.main.NoMessageCodeTipHelper.Companion(null);

    /* JADX INFO: compiled from: NoMessageCodeTipHelper.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/up366/mobile/main/NoMessageCodeTipHelper$Companion;", "", "<init>", "()V", "initView", "", "view", "Landroid/view/View;", "app_normalRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initView$lambda$1$lambda$0(android.view.View view) {
        }

        private Companion() {
        }

        public final void initView(final android.view.View view) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
            com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.NoMessageCodeTipHelper$Companion$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view2) {
                    com.up366.mobile.main.NoMessageCodeTipHelper.Companion.initView$lambda$1(view, view2);
                }
            }, view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void initView$lambda$1(android.view.View view, android.view.View view2) {
            android.content.Context context = view.getContext();
            com.up366.mobile.common.dialog.AppDialog.create(context).title(context.getString(com.up366.mobile.R.string.code_no_send_title)).messageTitle(context.getString(com.up366.mobile.R.string.code_no_send_content)).setMessageLeft().btnOne("我知道了", new android.view.View.OnClickListener() { // from class: com.up366.mobile.main.NoMessageCodeTipHelper$Companion$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view3) {
                    com.up366.mobile.main.NoMessageCodeTipHelper.Companion.initView$lambda$1$lambda$0(view3);
                }
            }).setBtnCloseVisibility(4).show();
        }
    }
}
