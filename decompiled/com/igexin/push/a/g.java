package com.igexin.push.a;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public final class g extends com.igexin.push.a.b {
    public static boolean a;
    private final java.lang.String b = "popupAct";
    private final java.util.ArrayList<com.igexin.push.core.i.a.f> c = new java.util.ArrayList<>();

    /* JADX INFO: renamed from: com.igexin.push.a.g$1, reason: invalid class name */
    final class AnonymousClass1 implements com.igexin.push.a.c<com.igexin.push.core.b.m.b> {
        final /* synthetic */ java.util.concurrent.atomic.AtomicLong a;
        final /* synthetic */ android.app.Activity b;
        final /* synthetic */ com.igexin.push.extension.mod.PushTaskBean c;
        final /* synthetic */ android.content.Context d;

        AnonymousClass1(java.util.concurrent.atomic.AtomicLong atomicLong, android.app.Activity activity, com.igexin.push.extension.mod.PushTaskBean pushTaskBean, android.content.Context context) {
            this.a = atomicLong;
            this.b = activity;
            this.c = pushTaskBean;
            this.d = context;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(com.igexin.push.core.b.m.b bVar) {
            try {
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                if (jCurrentTimeMillis - this.a.getAndSet(jCurrentTimeMillis) < 350) {
                    com.igexin.c.a.c.a.b("popupAct", "repetition click");
                    return;
                }
                if (bVar.o.getAction().isClosePopup()) {
                    this.b.finish();
                }
                com.igexin.push.a.g.a(bVar, this.c, this.d);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }

        @Override // com.igexin.push.a.c
        public final /* synthetic */ void a(com.igexin.push.core.b.m.b bVar) {
            com.igexin.push.core.b.m.b bVar2 = bVar;
            try {
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                if (jCurrentTimeMillis - this.a.getAndSet(jCurrentTimeMillis) < 350) {
                    com.igexin.c.a.c.a.b("popupAct", "repetition click");
                    return;
                }
                if (bVar2.o.getAction().isClosePopup()) {
                    this.b.finish();
                }
                com.igexin.push.a.g.a(bVar2, this.c, this.d);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.a.g$2, reason: invalid class name */
    final class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.igexin.push.core.b.m a;
        final /* synthetic */ com.igexin.push.extension.mod.PushTaskBean b;

        AnonymousClass2(com.igexin.push.core.b.m mVar, com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
            this.a = mVar;
            this.b = pushTaskBean;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.igexin.push.core.l lVarA = com.igexin.push.core.l.a();
            com.igexin.sdk.message.GTPopupMessage gTPopupMessage = this.a.j;
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("action", com.igexin.sdk.PushConsts.ACTION_POPUP_SHOW);
            bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_POPUP_SHOW, gTPopupMessage);
            lVarA.a(bundle);
            com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(this.b, this.a.i, com.igexin.push.core.b.B);
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.a.g$3, reason: invalid class name */
    static class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.igexin.push.core.b.m.b a;
        final /* synthetic */ com.igexin.push.extension.mod.PushTaskBean b;
        final /* synthetic */ android.content.Context c;

        AnonymousClass3(com.igexin.push.core.b.m.b bVar, com.igexin.push.extension.mod.PushTaskBean pushTaskBean, android.content.Context context) {
            this.a = bVar;
            this.b = pushTaskBean;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.igexin.push.core.l lVarA = com.igexin.push.core.l.a();
            com.igexin.sdk.message.GTPopupMessage gTPopupMessage = this.a.o;
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.setClassLoader(com.igexin.sdk.message.GTPopupMessage.class.getClassLoader());
            bundle.putInt("action", com.igexin.sdk.PushConsts.ACTION_POPUP_CLICKED);
            bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_POPUP_CLICKED, gTPopupMessage);
            lVarA.a(bundle);
            com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(this.b, this.a.p, com.igexin.push.core.b.B);
            com.igexin.sdk.message.GTPopupMessage.GtAction action = this.a.o.getAction();
            java.lang.String actionType = action.getActionType();
            if (com.igexin.push.core.b.m.a.intent.name().equals(actionType)) {
                new com.igexin.push.core.a.c.k();
                com.igexin.push.core.a.c.k.a(action.getIntent(), this.c);
                return;
            }
            if (!com.igexin.push.core.b.m.a.url.name().equals(actionType)) {
                com.igexin.push.core.b.m.a.closePopup.name().equals(actionType);
                return;
            }
            new com.igexin.push.core.a.c.l();
            java.lang.String url = action.getUrl();
            android.content.Context context = this.c;
            try {
                if (android.text.TextUtils.isEmpty(url)) {
                    return;
                }
                com.igexin.push.core.b.s sVar = new com.igexin.push.core.b.s();
                sVar.a = url;
                com.igexin.push.core.a.c.l.a(sVar, com.igexin.push.core.b.A);
                android.content.Intent intent = new android.content.Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setFlags(268435456);
                intent.setPackage(sVar.d);
                intent.setData(android.net.Uri.parse(sVar.a()));
                context.startActivity(intent);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.a.g$4, reason: invalid class name */
    final class AnonymousClass4 implements android.view.View.OnClickListener {
        final /* synthetic */ com.igexin.push.a.c a;
        final /* synthetic */ com.igexin.push.core.b.m.b b;

        AnonymousClass4(com.igexin.push.a.c cVar, com.igexin.push.core.b.m.b bVar) {
            this.a = cVar;
            this.b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(android.view.View view) {
            this.a.a(this.b);
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.a.g$9, reason: invalid class name */
    final class AnonymousClass9 implements com.igexin.push.a.e.a<byte[]> {
        final /* synthetic */ com.igexin.push.core.b.m.b a;
        final /* synthetic */ android.content.Context b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ com.igexin.push.a.d e;

        AnonymousClass9(com.igexin.push.core.b.m.b bVar, android.content.Context context, int i, int i2, com.igexin.push.a.d dVar) {
            this.a = bVar;
            this.b = context;
            this.c = i;
            this.d = i2;
            this.e = dVar;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(byte[] bArr) {
            try {
                com.igexin.c.a.c.a.b("popupAct", "movie duration is 0 use glide " + this.a.h);
                com.igexin.push.core.i.a.f fVarA = new com.igexin.push.core.i.a.a(this.b).a(java.nio.ByteBuffer.wrap(bArr), this.c, this.d);
                fVarA.b();
                com.igexin.push.core.i.a.e eVarA = fVarA.c();
                this.e.setImageDrawable(eVarA);
                com.igexin.push.core.i.a.k.a(!eVarA.d, "You cannot restart a currently running animation.");
                com.igexin.push.core.i.a.h hVar = eVarA.c.a;
                com.igexin.push.core.i.a.k.a(!hVar.c, "Can't restart a running animation");
                hVar.d = true;
                if (hVar.i != null) {
                    hVar.i = null;
                }
                eVarA.start();
                com.igexin.push.a.g.this.c.add(fVarA);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }

        @Override // com.igexin.push.a.e.a
        public final /* synthetic */ void a(byte[] bArr) {
            byte[] bArr2 = bArr;
            try {
                com.igexin.c.a.c.a.b("popupAct", "movie duration is 0 use glide " + this.a.h);
                com.igexin.push.core.i.a.f fVarA = new com.igexin.push.core.i.a.a(this.b).a(java.nio.ByteBuffer.wrap(bArr2), this.c, this.d);
                fVarA.b();
                com.igexin.push.core.i.a.e eVarA = fVarA.c();
                this.e.setImageDrawable(eVarA);
                com.igexin.push.core.i.a.k.a(!eVarA.d, "You cannot restart a currently running animation.");
                com.igexin.push.core.i.a.h hVar = eVarA.c.a;
                com.igexin.push.core.i.a.k.a(!hVar.c, "Can't restart a running animation");
                hVar.d = true;
                if (hVar.i != null) {
                    hVar.i = null;
                }
                eVarA.start();
                com.igexin.push.a.g.this.c.add(fVarA);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }

        @Override // com.igexin.push.a.e.a
        public final void a(java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static int a(com.igexin.push.core.b.m.b bVar) {
        java.lang.String str = bVar.b;
        str.hashCode();
        if (str.equals("center")) {
            return 17;
        }
        return !str.equals(com.up366.photopicker.ui.crop.CropActivity.DRAG_HANDLE_RIGHT) ? 8388611 : 8388613;
    }

    private android.view.View a(final com.igexin.push.core.b.m.b bVar, final android.content.Context context, com.igexin.push.a.c<com.igexin.push.core.b.m.b> cVar) {
        int i;
        android.view.View textView;
        if (bVar == null) {
            return null;
        }
        java.lang.String str = bVar.a;
        str.hashCode();
        switch (str) {
            case "button":
                android.widget.Button button = new android.widget.Button(context);
                button.setAllCaps(false);
                textView = button;
                break;
            case "column":
            case "row":
            case "view":
                android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
                linearLayout.setOrientation(!"row".equals(bVar.a) ? 1 : 0);
                android.view.View viewA = a(bVar, linearLayout, cVar);
                if (bVar.g != null) {
                    for (i = 0; i < bVar.g.size(); i++) {
                        linearLayout.addView(a(bVar.g.get(i), context, cVar));
                    }
                }
                return viewA;
            case "image":
            case "image_button":
                final com.igexin.push.a.d dVar = new com.igexin.push.a.d(context);
                android.view.View viewA2 = a(bVar, dVar, cVar);
                dVar.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                try {
                    if (!android.text.TextUtils.isEmpty(bVar.h)) {
                        if (bVar.h.endsWith(com.up366.medialibrary.common.utils.MimeTypeUtils.GIF)) {
                            final int iA = bVar.a();
                            final int iB = bVar.b();
                            com.igexin.push.a.e.b(bVar.h, new com.igexin.push.a.e.a<android.graphics.Movie>() { // from class: com.igexin.push.a.g.5
                                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                                private void a2(android.graphics.Movie movie) {
                                    if (movie.duration() == 0) {
                                        com.igexin.push.a.g.a(com.igexin.push.a.g.this, bVar, context, iA, iB, dVar);
                                        return;
                                    }
                                    com.igexin.push.a.d dVar2 = dVar;
                                    dVar2.a = movie;
                                    dVar2.b = 0L;
                                    dVar2.c = 0;
                                    dVar2.setLayerType(1, null);
                                    dVar2.setImageDrawable(null);
                                    dVar2.requestLayout();
                                    dVar2.invalidate();
                                    com.igexin.push.a.d dVar3 = dVar;
                                    if (dVar3.d) {
                                        dVar3.d = false;
                                        if (dVar3.a != null) {
                                            dVar3.b = android.os.SystemClock.uptimeMillis() - ((long) dVar3.c);
                                            dVar3.invalidate();
                                        }
                                    }
                                }

                                @Override // com.igexin.push.a.e.a
                                public final /* synthetic */ void a(android.graphics.Movie movie) {
                                    android.graphics.Movie movie2 = movie;
                                    if (movie2.duration() == 0) {
                                        com.igexin.push.a.g.a(com.igexin.push.a.g.this, bVar, context, iA, iB, dVar);
                                        return;
                                    }
                                    com.igexin.push.a.d dVar2 = dVar;
                                    dVar2.a = movie2;
                                    dVar2.b = 0L;
                                    dVar2.c = 0;
                                    dVar2.setLayerType(1, null);
                                    dVar2.setImageDrawable(null);
                                    dVar2.requestLayout();
                                    dVar2.invalidate();
                                    com.igexin.push.a.d dVar3 = dVar;
                                    if (dVar3.d) {
                                        dVar3.d = false;
                                        if (dVar3.a != null) {
                                            dVar3.b = android.os.SystemClock.uptimeMillis() - ((long) dVar3.c);
                                            dVar3.invalidate();
                                        }
                                    }
                                }

                                @Override // com.igexin.push.a.e.a
                                public final void a(java.lang.Throwable th) {
                                    com.igexin.c.a.c.a.a(th);
                                }
                            });
                        } else {
                            com.igexin.push.a.e.a(bVar.h, bVar.a(), new com.igexin.push.a.e.a<android.graphics.Bitmap>() { // from class: com.igexin.push.a.g.6
                                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                                private void a2(android.graphics.Bitmap bitmap) {
                                    dVar.setImageBitmap(bitmap);
                                }

                                @Override // com.igexin.push.a.e.a
                                public final /* synthetic */ void a(android.graphics.Bitmap bitmap) {
                                    dVar.setImageBitmap(bitmap);
                                }

                                @Override // com.igexin.push.a.e.a
                                public final void a(java.lang.Throwable th) {
                                    com.igexin.c.a.c.a.a(th);
                                }
                            });
                        }
                    }
                    break;
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
                return viewA2;
            case "label":
                textView = new android.widget.TextView(context);
                break;
            default:
                throw new java.lang.RuntimeException("can't find type " + bVar.a);
        }
        return a(bVar, textView, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.view.View a(final com.igexin.push.core.b.m.b r6, final android.view.View r7, final com.igexin.push.a.c<com.igexin.push.core.b.m.b> r8) {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.a.g.a(com.igexin.push.core.b.m$b, android.view.View, com.igexin.push.a.c):android.view.View");
    }

    private android.widget.LinearLayout a(com.igexin.push.a.c cVar, com.igexin.push.core.b.m mVar, android.content.Context context) {
        com.igexin.push.core.b.m.b bVar = mVar.a;
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(bVar.m);
        if (bVar.o != null) {
            com.igexin.sdk.message.GTPopupMessage.GtAction action = bVar.o.getAction();
            if (action.isClosePopup() || !com.igexin.push.core.b.m.a.closePopup.name().equals(action.getActionType())) {
                linearLayout.setOnClickListener(new com.igexin.push.a.g.AnonymousClass4(cVar, bVar));
            } else {
                linearLayout.setClickable(true);
                linearLayout.setFocusable(true);
            }
        }
        android.view.View viewA = a(mVar.b, context, (com.igexin.push.a.c<com.igexin.push.core.b.m.b>) cVar);
        if (viewA != null) {
            linearLayout.addView(viewA);
        }
        return linearLayout;
    }

    static /* synthetic */ void a(com.igexin.push.a.g gVar, com.igexin.push.core.b.m.b bVar, android.content.Context context, int i, int i2, com.igexin.push.a.d dVar) {
        com.igexin.push.a.e.a(bVar.h, gVar.new AnonymousClass9(bVar, context, i, i2, dVar));
    }

    private void a(com.igexin.push.core.b.m.b bVar, android.content.Context context, int i, int i2, com.igexin.push.a.d dVar) {
        com.igexin.push.a.e.a(bVar.h, new com.igexin.push.a.g.AnonymousClass9(bVar, context, i, i2, dVar));
    }

    static /* synthetic */ void a(com.igexin.push.core.b.m.b bVar, com.igexin.push.extension.mod.PushTaskBean pushTaskBean, android.content.Context context) {
        com.igexin.b.a.a().a.execute(new com.igexin.push.a.g.AnonymousClass3(bVar, pushTaskBean, context));
    }

    private static void b(com.igexin.push.core.b.m.b bVar, com.igexin.push.extension.mod.PushTaskBean pushTaskBean, android.content.Context context) {
        com.igexin.b.a.a().a.execute(new com.igexin.push.a.g.AnonymousClass3(bVar, pushTaskBean, context));
    }

    private void c(android.app.Activity activity) {
        android.content.Intent intent = activity.getIntent();
        try {
            a = true;
            android.content.Context applicationContext = activity.getApplicationContext();
            com.getui.gtc.base.GtcProvider.setContext(applicationContext);
            try {
                if (android.os.Build.VERSION.SDK_INT != 26) {
                    if (1 == applicationContext.getResources().getConfiguration().orientation) {
                        activity.setRequestedOrientation(7);
                    } else {
                        activity.setRequestedOrientation(6);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
            java.util.concurrent.atomic.AtomicLong atomicLong = new java.util.concurrent.atomic.AtomicLong(0L);
            com.igexin.push.core.b.m mVar = (com.igexin.push.core.b.m) intent.getExtras().getSerializable("bean");
            com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
            pushTaskBean.setAppid(mVar.e);
            pushTaskBean.setMessageId(mVar.f);
            pushTaskBean.setTaskId(mVar.g);
            pushTaskBean.setAppKey(mVar.h);
            com.igexin.push.core.b.m.a(applicationContext);
            com.igexin.push.a.g.AnonymousClass1 anonymousClass1 = new com.igexin.push.a.g.AnonymousClass1(atomicLong, activity, pushTaskBean, applicationContext);
            com.igexin.push.core.b.m.b bVar = mVar.a;
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(applicationContext);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
            linearLayout.setBackgroundColor(bVar.m);
            if (bVar.o != null) {
                com.igexin.sdk.message.GTPopupMessage.GtAction action = bVar.o.getAction();
                if (action.isClosePopup() || !com.igexin.push.core.b.m.a.closePopup.name().equals(action.getActionType())) {
                    linearLayout.setOnClickListener(new com.igexin.push.a.g.AnonymousClass4(anonymousClass1, bVar));
                } else {
                    linearLayout.setClickable(true);
                    linearLayout.setFocusable(true);
                }
            }
            android.view.View viewA = a(mVar.b, applicationContext, anonymousClass1);
            if (viewA != null) {
                linearLayout.addView(viewA);
            }
            activity.setContentView(linearLayout);
            com.igexin.b.a.a().a.execute(new com.igexin.push.a.g.AnonymousClass2(mVar, pushTaskBean));
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
            activity.finish();
        }
    }

    @Override // com.igexin.push.a.b
    public final void a(android.app.Activity activity) {
        try {
            if (android.os.Build.VERSION.SDK_INT == 26) {
                activity.finish();
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    @Override // com.igexin.push.a.b
    public final boolean a() {
        return false;
    }

    @Override // com.igexin.push.a.b
    public final void b(android.app.Activity activity) {
        android.content.Intent intent = activity.getIntent();
        try {
            a = true;
            android.content.Context applicationContext = activity.getApplicationContext();
            com.getui.gtc.base.GtcProvider.setContext(applicationContext);
            try {
                if (android.os.Build.VERSION.SDK_INT != 26) {
                    if (1 == applicationContext.getResources().getConfiguration().orientation) {
                        activity.setRequestedOrientation(7);
                    } else {
                        activity.setRequestedOrientation(6);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
            java.util.concurrent.atomic.AtomicLong atomicLong = new java.util.concurrent.atomic.AtomicLong(0L);
            com.igexin.push.core.b.m mVar = (com.igexin.push.core.b.m) intent.getExtras().getSerializable("bean");
            com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
            pushTaskBean.setAppid(mVar.e);
            pushTaskBean.setMessageId(mVar.f);
            pushTaskBean.setTaskId(mVar.g);
            pushTaskBean.setAppKey(mVar.h);
            com.igexin.push.core.b.m.a(applicationContext);
            com.igexin.push.a.g.AnonymousClass1 anonymousClass1 = new com.igexin.push.a.g.AnonymousClass1(atomicLong, activity, pushTaskBean, applicationContext);
            com.igexin.push.core.b.m.b bVar = mVar.a;
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(applicationContext);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
            linearLayout.setBackgroundColor(bVar.m);
            if (bVar.o != null) {
                com.igexin.sdk.message.GTPopupMessage.GtAction action = bVar.o.getAction();
                if (action.isClosePopup() || !com.igexin.push.core.b.m.a.closePopup.name().equals(action.getActionType())) {
                    linearLayout.setOnClickListener(new com.igexin.push.a.g.AnonymousClass4(anonymousClass1, bVar));
                } else {
                    linearLayout.setClickable(true);
                    linearLayout.setFocusable(true);
                }
            }
            android.view.View viewA = a(mVar.b, applicationContext, anonymousClass1);
            if (viewA != null) {
                linearLayout.addView(viewA);
            }
            activity.setContentView(linearLayout);
            com.igexin.b.a.a().a.execute(new com.igexin.push.a.g.AnonymousClass2(mVar, pushTaskBean));
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
            activity.finish();
        }
    }

    @Override // com.igexin.push.a.b
    public final boolean b() {
        return false;
    }

    @Override // com.igexin.push.a.b
    public final void c() {
    }

    @Override // com.igexin.push.a.b
    public final void d() {
    }

    @Override // com.igexin.push.a.b
    public final void e() {
    }

    @Override // com.igexin.push.a.b
    public final void f() {
    }

    @Override // com.igexin.push.a.b
    public final void g() {
    }

    @Override // com.igexin.push.a.b
    public final void h() {
    }

    @Override // com.igexin.push.a.b
    public final void i() {
        a = false;
        for (com.igexin.push.core.i.a.f fVar : this.c) {
            if (fVar != null) {
                fVar.f();
            }
        }
        this.c.clear();
    }

    @Override // com.igexin.push.a.b
    public final void j() {
    }

    @Override // com.igexin.push.a.b
    public final void k() {
    }
}
