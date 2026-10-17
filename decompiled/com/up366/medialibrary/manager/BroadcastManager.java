package com.up366.medialibrary.manager;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BroadcastManager {
    public static final java.lang.String ACTION_DELETE_PREVIEW_POSITION = "com.up366.medialibrary.action.delete_preview_position";
    private static final java.lang.String TAG = "BroadcastManager";
    private java.lang.String action;
    private android.content.Intent intent;
    private androidx.localbroadcastmanager.content.LocalBroadcastManager localBroadcastManager;

    public static com.up366.medialibrary.manager.BroadcastManager getInstance(android.content.Context context) {
        com.up366.medialibrary.manager.BroadcastManager broadcastManager = new com.up366.medialibrary.manager.BroadcastManager();
        broadcastManager.localBroadcastManager = androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(context.getApplicationContext());
        return broadcastManager;
    }

    public com.up366.medialibrary.manager.BroadcastManager intent(android.content.Intent intent) {
        this.intent = intent;
        return this;
    }

    public com.up366.medialibrary.manager.BroadcastManager action(java.lang.String str) {
        this.action = str;
        return this;
    }

    public com.up366.medialibrary.manager.BroadcastManager extras(android.os.Bundle bundle) {
        createIntent();
        android.content.Intent intent = this.intent;
        if (intent == null) {
            android.util.Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtras(bundle);
        return this;
    }

    public com.up366.medialibrary.manager.BroadcastManager put(java.lang.String str, java.util.ArrayList<? extends android.os.Parcelable> arrayList) {
        createIntent();
        android.content.Intent intent = this.intent;
        if (intent == null) {
            android.util.Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, arrayList);
        return this;
    }

    public com.up366.medialibrary.manager.BroadcastManager put(java.lang.String str, android.os.Parcelable[] parcelableArr) {
        createIntent();
        android.content.Intent intent = this.intent;
        if (intent == null) {
            android.util.Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, parcelableArr);
        return this;
    }

    public com.up366.medialibrary.manager.BroadcastManager put(java.lang.String str, android.os.Parcelable parcelable) {
        createIntent();
        android.content.Intent intent = this.intent;
        if (intent == null) {
            android.util.Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, parcelable);
        return this;
    }

    public com.up366.medialibrary.manager.BroadcastManager put(java.lang.String str, float f) {
        createIntent();
        android.content.Intent intent = this.intent;
        if (intent == null) {
            android.util.Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, f);
        return this;
    }

    public com.up366.medialibrary.manager.BroadcastManager put(java.lang.String str, double d) {
        createIntent();
        android.content.Intent intent = this.intent;
        if (intent == null) {
            android.util.Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, d);
        return this;
    }

    public com.up366.medialibrary.manager.BroadcastManager put(java.lang.String str, long j) {
        createIntent();
        android.content.Intent intent = this.intent;
        if (intent == null) {
            android.util.Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, j);
        return this;
    }

    public com.up366.medialibrary.manager.BroadcastManager put(java.lang.String str, boolean z) {
        createIntent();
        android.content.Intent intent = this.intent;
        if (intent == null) {
            android.util.Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, z);
        return this;
    }

    public com.up366.medialibrary.manager.BroadcastManager put(java.lang.String str, int i) {
        createIntent();
        android.content.Intent intent = this.intent;
        if (intent == null) {
            android.util.Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, i);
        return this;
    }

    public com.up366.medialibrary.manager.BroadcastManager put(java.lang.String str, java.lang.String str2) {
        createIntent();
        android.content.Intent intent = this.intent;
        if (intent == null) {
            android.util.Log.e(TAG, "intent create failed");
            return this;
        }
        intent.putExtra(str, str2);
        return this;
    }

    private void createIntent() {
        if (this.intent == null) {
            android.util.Log.d(TAG, "intent is not created");
        }
        if (this.intent == null) {
            if (!android.text.TextUtils.isEmpty(this.action)) {
                this.intent = new android.content.Intent(this.action);
            }
            android.util.Log.d(TAG, "intent created with action");
        }
    }

    public void broadcast() {
        java.lang.String str;
        createIntent();
        android.content.Intent intent = this.intent;
        if (intent == null || (str = this.action) == null) {
            return;
        }
        intent.setAction(str);
        androidx.localbroadcastmanager.content.LocalBroadcastManager localBroadcastManager = this.localBroadcastManager;
        if (localBroadcastManager != null) {
            localBroadcastManager.sendBroadcast(this.intent);
        }
    }

    public void registerReceiver(android.content.BroadcastReceiver broadcastReceiver, java.util.List<java.lang.String> list) {
        if (broadcastReceiver == null || list == null) {
            return;
        }
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        if (list != null) {
            java.util.Iterator<java.lang.String> it = list.iterator();
            while (it.hasNext()) {
                intentFilter.addAction(it.next());
            }
        }
        androidx.localbroadcastmanager.content.LocalBroadcastManager localBroadcastManager = this.localBroadcastManager;
        if (localBroadcastManager != null) {
            localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public void registerReceiver(android.content.BroadcastReceiver broadcastReceiver, java.lang.String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        registerReceiver(broadcastReceiver, java.util.Arrays.asList(strArr));
    }

    public void unregisterReceiver(android.content.BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return;
        }
        try {
            this.localBroadcastManager.unregisterReceiver(broadcastReceiver);
        } catch (java.lang.Exception unused) {
        }
    }

    public void unregisterReceiver(android.content.BroadcastReceiver broadcastReceiver, java.lang.String... strArr) {
        unregisterReceiver(broadcastReceiver);
    }
}
