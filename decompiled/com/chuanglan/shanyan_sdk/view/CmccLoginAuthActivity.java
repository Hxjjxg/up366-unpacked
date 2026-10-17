package com.chuanglan.shanyan_sdk.view;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public class CmccLoginAuthActivity extends com.cmic.gen.sdk.view.GenLoginAuthActivity {
    private void q() {
        android.widget.RelativeLayout relativeLayout;
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) ((android.view.ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0);
        if (viewGroup == null || (relativeLayout = (android.widget.RelativeLayout) viewGroup.findViewById(17476)) == null) {
            return;
        }
        relativeLayout.performClick();
    }

    private void r() {
        try {
            android.view.Window window = getWindow();
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            window.addFlags(24);
            attributes.alpha = 0.0f;
            attributes.width = 1;
            attributes.height = 1;
            attributes.x = 0;
            attributes.y = 0;
            window.setAttributes(attributes);
        } catch (java.lang.Exception e) {
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "CMCC-SDK initInvisibleWindow Exception", e);
        }
    }

    @Override // com.cmic.gen.sdk.view.GenLoginAuthActivity, android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        r();
    }

    @Override // com.cmic.gen.sdk.view.GenLoginAuthActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "CMCC-SDK GenLoginAuthActivity onDestroy");
    }

    @Override // com.cmic.gen.sdk.view.GenLoginAuthActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            q();
            com.chuanglan.shanyan_sdk.Q.a("ProcessShanYanLogger", "CMCC-SDK start onResume");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "CMCC-SDK loadLibrary Exception", e);
            finish();
        }
    }
}
