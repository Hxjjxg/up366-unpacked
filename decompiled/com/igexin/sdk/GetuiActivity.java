package com.igexin.sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class GetuiActivity extends android.app.Activity {
    private com.igexin.push.a.b activityAction;

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.igexin.push.a.b bVar = this.activityAction;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        com.igexin.push.a.a.a();
        com.igexin.push.a.b bVarA = com.igexin.push.a.a.a(this);
        this.activityAction = bVarA;
        if (bVarA != null) {
            bVarA.b(this);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.igexin.push.a.b bVar = this.activityAction;
        if (bVar != null) {
            bVar.i();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }
}
