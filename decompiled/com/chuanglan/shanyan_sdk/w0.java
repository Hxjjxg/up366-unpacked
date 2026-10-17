package com.chuanglan.shanyan_sdk;

/* JADX INFO: loaded from: E:\up366_re\dump\classes15.dex */
public abstract class w0 {

    class a implements android.media.MediaPlayer.OnCompletionListener {
        final /* synthetic */ com.chuanglan.shanyan_sdk.C0064u a;

        /* JADX INFO: renamed from: com.chuanglan.shanyan_sdk.w0$a$a, reason: collision with other inner class name */
        class C0002a implements android.media.MediaPlayer.OnInfoListener {
            C0002a() {
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(android.media.MediaPlayer mediaPlayer, int i, int i2) {
                return false;
            }
        }

        a(com.chuanglan.shanyan_sdk.C0064u c0064u) {
            this.a = c0064u;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(android.media.MediaPlayer mediaPlayer) {
            this.a.start();
            mediaPlayer.setOnInfoListener(new com.chuanglan.shanyan_sdk.w0.a.C0002a());
        }
    }

    class b implements android.media.MediaPlayer.OnPreparedListener {
        final /* synthetic */ com.chuanglan.shanyan_sdk.C0064u a;

        class a implements android.media.MediaPlayer.OnInfoListener {
            a() {
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(android.media.MediaPlayer mediaPlayer, int i, int i2) {
                if (i != 3) {
                    return true;
                }
                com.chuanglan.shanyan_sdk.w0.b.this.a.setBackgroundColor(0);
                return true;
            }
        }

        b(com.chuanglan.shanyan_sdk.C0064u c0064u) {
            this.a = c0064u;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(android.media.MediaPlayer mediaPlayer) {
            mediaPlayer.setOnInfoListener(new com.chuanglan.shanyan_sdk.w0.b.a());
        }
    }

    class c implements android.media.MediaPlayer.OnErrorListener {
        c() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(android.media.MediaPlayer mediaPlayer, int i, int i2) {
            return true;
        }
    }

    public static void a(android.content.Context context, android.view.View view, int i, int i2) {
        try {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i2);
            layoutParams.width = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i);
            view.setLayoutParams(layoutParams);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(android.content.Context context, android.view.View view, int i, int i2, int i3, int i4, int i5) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = new android.view.ViewGroup.MarginLayoutParams(layoutParams);
        int iA = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i2);
        int iA2 = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i);
        int iA3 = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i3);
        if (i == -1 && i3 == -1) {
            marginLayoutParams.setMargins(0, iA, 0, 0);
        } else if (i == -1 && i3 != -1) {
            marginLayoutParams.setMargins(0, 0, 0, iA3);
        } else if (i != -1 && i3 == -1) {
            marginLayoutParams.setMargins(iA2, iA, 0, 0);
        } else if (i != -1 && i3 != -1) {
            marginLayoutParams.setMargins(iA2, 0, 0, iA3);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(marginLayoutParams);
        if (i5 != -1) {
            layoutParams2.height = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i5);
        }
        if (i4 == -1) {
            layoutParams2.leftMargin = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, 47.0f);
            layoutParams2.rightMargin = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, 47.0f);
        } else {
            layoutParams2.width = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i4);
        }
        if (i == -1 && i3 == -1) {
            layoutParams2.addRule(10);
            layoutParams2.addRule(14);
        } else if (i == -1 && i3 != -1) {
            layoutParams2.addRule(12);
            layoutParams2.addRule(14);
        } else if (i != -1 && i3 == -1) {
            layoutParams2.addRule(10);
            layoutParams2.addRule(9);
        } else if (i != -1 && i3 != -1) {
            layoutParams2.addRule(12);
            layoutParams2.addRule(9);
        }
        view.setLayoutParams(layoutParams2);
    }

    public static void a(android.content.Context context, android.view.View view, int i, int i2, int i3, int i4, int i5) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = new android.view.ViewGroup.MarginLayoutParams(layoutParams);
        int iA = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i2);
        int iA2 = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i);
        int iA3 = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i3);
        if (i == -1 && i3 == -1) {
            marginLayoutParams.setMargins(0, iA, 0, 0);
        } else if (i == -1 && i3 != -1) {
            marginLayoutParams.setMargins(0, 0, 0, iA3);
        } else if (i != -1 && i3 == -1) {
            marginLayoutParams.setMargins(iA2, iA, 0, 0);
        } else if (i != -1 && i3 != -1) {
            marginLayoutParams.setMargins(iA2, 0, 0, iA3);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(marginLayoutParams);
        if (i5 != -1) {
            layoutParams2.height = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i5);
        }
        if (i4 != -1) {
            layoutParams2.width = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i4);
        }
        if (i == -1 && i3 == -1) {
            layoutParams2.addRule(10);
            layoutParams2.addRule(14);
        } else if (i == -1 && i3 != -1) {
            layoutParams2.addRule(12);
            layoutParams2.addRule(14);
        } else if (i != -1 && i3 == -1) {
            layoutParams2.addRule(10);
            layoutParams2.addRule(9);
        } else if (i != -1 && i3 != -1) {
            layoutParams2.addRule(12);
            layoutParams2.addRule(9);
        }
        view.setLayoutParams(layoutParams2);
    }

    public static void a(android.content.Context context, android.view.View view, int i, int i2, int i3, int i4, int i5, android.widget.ImageView imageView) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = new android.view.ViewGroup.MarginLayoutParams(layoutParams);
        int iA = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i2);
        int iA2 = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i);
        int iA3 = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i3);
        if (i2 == -1 && i3 == -1) {
            marginLayoutParams.setMargins(iA2, 0, 0, 0);
        } else if (i2 == -1 && i3 != -1) {
            marginLayoutParams.setMargins(0, 0, iA3, 0);
        } else if (i2 != -1 && i3 == -1) {
            marginLayoutParams.setMargins(iA2, iA, 0, 0);
        } else if (i2 != -1 && i3 != -1) {
            marginLayoutParams.setMargins(0, iA, iA3, 0);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(marginLayoutParams);
        android.view.ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
        if (i5 != -1) {
            layoutParams3.height = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i5);
        } else {
            layoutParams3.height = -2;
        }
        if (i4 == -1) {
            layoutParams3.width = -2;
        } else {
            layoutParams3.width = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i4);
        }
        imageView.setLayoutParams(layoutParams3);
        if (i2 == -1 && i3 == -1) {
            layoutParams2.addRule(9);
            layoutParams2.addRule(15);
        } else if (i2 == -1 && i3 != -1) {
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
        } else if (i2 != -1 && i3 == -1) {
            layoutParams2.addRule(10);
            layoutParams2.addRule(9);
        } else if (i2 != -1 && i3 != -1) {
            layoutParams2.addRule(10);
            layoutParams2.addRule(11);
        }
        view.setLayoutParams(layoutParams2);
    }

    public static void a(android.content.Context context, android.view.View view, int i, int i2, int i3) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = new android.view.ViewGroup.MarginLayoutParams(view.getLayoutParams());
        int iA = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i2);
        int iA2 = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i);
        int iA3 = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i3);
        if (i == -1 && i3 == -1) {
            marginLayoutParams.setMargins(0, iA, 0, 0);
        } else if (i == -1 && i3 != -1) {
            marginLayoutParams.setMargins(0, 0, 0, iA3);
        } else if (i != -1 && i3 == -1) {
            marginLayoutParams.setMargins(iA2, iA, 0, 0);
        } else if (i != -1 && i3 != -1) {
            marginLayoutParams.setMargins(iA2, 0, 0, iA3);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(marginLayoutParams);
        if (i == -1 && i3 == -1) {
            layoutParams2.addRule(10);
            layoutParams2.addRule(14);
        } else if (i == -1 && i3 != -1) {
            layoutParams2.addRule(12);
            layoutParams2.addRule(14);
        } else if (i != -1 && i3 == -1) {
            layoutParams2.addRule(10);
            layoutParams2.addRule(9);
        } else if (i != -1 && i3 != -1) {
            layoutParams2.addRule(12);
            layoutParams2.addRule(9);
        }
        view.setLayoutParams(layoutParams2);
    }

    public static void a(android.content.Context context, android.widget.RelativeLayout relativeLayout, int i, int i2, int i3, int i4, int i5, int i6) {
        try {
            android.view.ViewGroup.MarginLayoutParams marginLayoutParams = new android.view.ViewGroup.MarginLayoutParams((android.view.ViewGroup.MarginLayoutParams) relativeLayout.getLayoutParams());
            int iA = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i);
            int iA2 = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i2);
            int iA3 = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i3);
            int iA4 = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i4);
            int iA5 = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i5);
            int iA6 = com.chuanglan.shanyan_sdk.AbstractC0046c.a(context, i6);
            relativeLayout.setPadding(iA, iA2, iA3, iA4);
            if (i5 != -1 && i6 != -1) {
                marginLayoutParams.setMargins((-iA) + iA5, (-iA2) + iA6, 0, 0);
            } else if (i5 != -1 && i6 == -1) {
                marginLayoutParams.setMargins((-iA) + iA5, 0, 0, 0);
            } else if (i5 == -1 && i6 != -1) {
                marginLayoutParams.setMargins(0, (-iA2) + iA6, 0, 0);
            } else {
                marginLayoutParams.setMargins(0, 0, 0, 0);
            }
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(marginLayoutParams);
            if (i6 != -1) {
                layoutParams.addRule(10);
            } else {
                layoutParams.addRule(15);
            }
            layoutParams.addRule(9);
            relativeLayout.setLayoutParams(layoutParams);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(com.chuanglan.shanyan_sdk.C0064u c0064u, android.content.Context context, java.lang.String str) {
        android.net.Uri uri;
        android.media.MediaMetadataRetriever mediaMetadataRetriever;
        android.graphics.Bitmap frameAtTime = null;
        try {
            try {
                try {
                    uri = android.net.Uri.parse(str);
                    c0064u.setVideoURI(uri);
                    c0064u.setVisibility(0);
                    mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                try {
                    try {
                        if (!str.startsWith(com.up366.mobile.cloud.PrivateCloudMgr.HTTP) && !str.startsWith("https://")) {
                            mediaMetadataRetriever.setDataSource(context, uri);
                        } else {
                            mediaMetadataRetriever.setDataSource(str, new java.util.HashMap());
                        }
                        frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                        mediaMetadataRetriever.release();
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                        mediaMetadataRetriever.release();
                    }
                    c0064u.setBackground(new android.graphics.drawable.BitmapDrawable(context.getResources(), frameAtTime));
                    c0064u.start();
                    c0064u.setOnCompletionListener(new com.chuanglan.shanyan_sdk.w0.a(c0064u));
                    c0064u.setOnPreparedListener(new com.chuanglan.shanyan_sdk.w0.b(c0064u));
                    c0064u.setOnErrorListener(new com.chuanglan.shanyan_sdk.w0.c());
                    if (frameAtTime != null) {
                        try {
                            frameAtTime.isRecycled();
                        } catch (java.lang.Exception e3) {
                            com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "startBgVideo Exception_e=", e3);
                            e3.printStackTrace();
                        }
                    }
                } catch (java.lang.Throwable th) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (java.lang.Exception e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (java.lang.Exception e5) {
                e5.printStackTrace();
                if (0 != 0) {
                    try {
                        frameAtTime.isRecycled();
                    } catch (java.lang.Exception e6) {
                        com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "startBgVideo Exception_e=", e6);
                        e6.printStackTrace();
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            if (0 != 0) {
                try {
                    frameAtTime.isRecycled();
                } catch (java.lang.Exception e7) {
                    com.chuanglan.shanyan_sdk.Q.d("ExceptionShanYanLogger", "startBgVideo Exception_e=", e7);
                    e7.printStackTrace();
                }
            }
            throw th2;
        }
    }
}
