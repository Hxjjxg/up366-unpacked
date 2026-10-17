package com.up366.mobile.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class BaseDialog extends android.app.Dialog {
    private com.up366.mobile.common.dialog.BaseDialog.BackPressedListener backListener;
    private android.content.Context context;
    private int[] noDismissIds;
    private android.view.View.OnClickListener onClickListener;
    private android.view.View.OnClickListener outOnClickListener;
    android.content.DialogInterface.OnDismissListener sourceListener;

    public interface BackPressedListener {
        void onBackPressed();
    }

    public BaseDialog(android.content.Context context) {
        super(context, com.up366.mobile.R.style.no_frame_dialog);
        this.onClickListener = new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.BaseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.up366.mobile.common.dialog.BaseDialog.this.noDismissIds == null || com.up366.mobile.common.dialog.BaseDialog.this.noDismissIds.length == 0) {
                    com.up366.mobile.common.dialog.BaseDialog.this.dismiss();
                } else {
                    int id = view.getId();
                    int[] iArr = com.up366.mobile.common.dialog.BaseDialog.this.noDismissIds;
                    int length = iArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            com.up366.mobile.common.dialog.BaseDialog.this.dismiss();
                            break;
                        } else if (iArr[i] == id) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (com.up366.mobile.common.dialog.BaseDialog.this.outOnClickListener != null) {
                    com.up366.mobile.common.dialog.BaseDialog.this.outOnClickListener.onClick(view);
                }
            }
        };
        this.context = context;
        setOnDissmissListener(null);
    }

    public BaseDialog(android.content.Context context, int i) {
        super(context, i);
        this.onClickListener = new android.view.View.OnClickListener() { // from class: com.up366.mobile.common.dialog.BaseDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.up366.mobile.common.dialog.BaseDialog.this.noDismissIds == null || com.up366.mobile.common.dialog.BaseDialog.this.noDismissIds.length == 0) {
                    com.up366.mobile.common.dialog.BaseDialog.this.dismiss();
                } else {
                    int id = view.getId();
                    int[] iArr = com.up366.mobile.common.dialog.BaseDialog.this.noDismissIds;
                    int length = iArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            com.up366.mobile.common.dialog.BaseDialog.this.dismiss();
                            break;
                        } else if (iArr[i2] == id) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                if (com.up366.mobile.common.dialog.BaseDialog.this.outOnClickListener != null) {
                    com.up366.mobile.common.dialog.BaseDialog.this.outOnClickListener.onClick(view);
                }
            }
        };
        this.context = context;
        setOnDissmissListener(null);
    }

    public com.up366.mobile.common.dialog.BaseDialog create(int i) {
        android.view.LayoutInflater.from(getContext()).inflate(i, (android.view.ViewGroup) null);
        setContentView(i);
        return this;
    }

    public com.up366.mobile.common.dialog.BaseDialog create(android.view.View view) {
        setContentView(view);
        return this;
    }

    public com.up366.mobile.common.dialog.BaseDialog defaultCreate() {
        setContentView(com.up366.mobile.R.layout.dialog_common_layout);
        return this;
    }

    public com.up366.mobile.common.dialog.BaseDialog setOnClickListener(int[] iArr, android.view.View.OnClickListener onClickListener) {
        this.outOnClickListener = onClickListener;
        for (int i : iArr) {
            android.view.View viewFindViewById = findViewById(i);
            if (viewFindViewById != null) {
                com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(viewFindViewById, this.onClickListener);
            } else {
                com.up366.common.log.Logger.error("BaseDialog.setOnClickListener : view id = " + i + " not found!");
            }
        }
        return this;
    }

    public com.up366.mobile.common.dialog.BaseDialog setOnClickListener(int[] iArr, int[] iArr2, android.view.View.OnClickListener onClickListener) {
        this.outOnClickListener = onClickListener;
        this.noDismissIds = iArr2;
        for (int i : iArr) {
            android.view.View viewFindViewById = findViewById(i);
            if (viewFindViewById != null) {
                com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(viewFindViewById, this.onClickListener);
            } else {
                com.up366.common.log.Logger.error("BaseDialog.setOnClickListener : view id = " + i + " not found!");
            }
        }
        for (int i2 : iArr2) {
            android.view.View viewFindViewById2 = findViewById(i2);
            if (viewFindViewById2 != null) {
                com.up366.mobile.common.utils.ViewUtil.bindOnClickListener(viewFindViewById2, this.onClickListener);
            } else {
                com.up366.common.log.Logger.error("BaseDialog.setOnClickListener : view id = " + i2 + " not found!");
            }
        }
        return this;
    }

    public com.up366.mobile.common.dialog.BaseDialog setText(int i, java.lang.Object obj) {
        android.view.View viewFindViewById = findViewById(i);
        if (viewFindViewById == null || obj == null || !(viewFindViewById instanceof android.widget.TextView)) {
            com.up366.common.log.Logger.error("setText error : " + viewFindViewById + " data :" + obj + " is textview ? " + (viewFindViewById instanceof android.widget.TextView));
            return this;
        }
        android.widget.TextView textView = (android.widget.TextView) viewFindViewById;
        if (obj instanceof java.lang.Integer) {
            textView.setText(((java.lang.Integer) obj).intValue());
        } else if (obj instanceof java.lang.String) {
            textView.setText((java.lang.String) obj);
        } else if (obj instanceof android.text.Spanned) {
            textView.setText((android.text.Spanned) obj);
        } else {
            com.up366.common.log.Logger.warn("setText error : don't suport " + obj.getClass());
        }
        return this;
    }

    public com.up366.mobile.common.dialog.BaseDialog setTextColor(int i, int i2) {
        android.view.View viewFindViewById = findViewById(i);
        if (!(viewFindViewById instanceof android.widget.TextView)) {
            com.up366.common.log.Logger.error("setTextColor error : " + viewFindViewById + " is textview ? ");
            return this;
        }
        ((android.widget.TextView) viewFindViewById).setTextColor(i2);
        return this;
    }

    public com.up366.mobile.common.dialog.BaseDialog setVisible(int[] iArr, int i) {
        if (iArr == null) {
            com.up366.common.log.Logger.error("BaseDialog.setVisible  error : ids is null");
            return this;
        }
        for (int i2 : iArr) {
            android.view.View viewFindViewById = findViewById(i2);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(i);
            } else {
                com.up366.common.log.Logger.warn("BaseDialog.setVisible : view id = " + i2 + " not found!");
            }
        }
        return this;
    }

    public android.view.View getView(int i) {
        return findViewById(i);
    }

    public void addView(int i, android.view.View view) {
        ((android.view.ViewGroup) getView(i)).addView(view);
    }

    public void showIfNot() {
        show();
    }

    @Override // android.app.Dialog
    public void show() {
        if (isShowing()) {
            return;
        }
        java.lang.Object obj = this.context;
        if (obj instanceof com.up366.mobile.common.base.BaseActivity) {
            if (((com.up366.mobile.common.base.BaseActivity) obj).hasFinished()) {
                return;
            } else {
                ((com.up366.mobile.common.base.BaseActivity) this.context).registerDialog(this);
            }
        }
        super.show();
    }

    public com.up366.mobile.common.dialog.BaseDialog setOnDissmissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
        setOnDismissListener(onDismissListener);
        return this;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        com.up366.mobile.common.dialog.BaseDialog.BackPressedListener backPressedListener = this.backListener;
        if (backPressedListener != null) {
            backPressedListener.onBackPressed();
        }
    }

    public com.up366.mobile.common.dialog.BaseDialog setBackListener(com.up366.mobile.common.dialog.BaseDialog.BackPressedListener backPressedListener) {
        this.backListener = backPressedListener;
        return this;
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
        this.sourceListener = onDismissListener;
        super.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() { // from class: com.up366.mobile.common.dialog.BaseDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(android.content.DialogInterface dialogInterface) {
                this.f$0.lambda$setOnDismissListener$0(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnDismissListener$0(android.content.DialogInterface dialogInterface) {
        android.content.DialogInterface.OnDismissListener onDismissListener = this.sourceListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
        java.lang.Object obj = this.context;
        if (obj instanceof com.up366.mobile.common.base.BaseActivity) {
            ((com.up366.mobile.common.base.BaseActivity) obj).unRegisterDialog(this);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(final android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            com.up366.mobile.common.onlinelog.ActionLogRecord.recordActionDown(motionEvent);
        }
        if (motionEvent.getAction() == 1 && getWindow() != null) {
            com.up366.common.task.TaskUtils.postGlobalTask(new com.up366.common.task.Task() { // from class: com.up366.mobile.common.dialog.BaseDialog$$ExternalSyntheticLambda1
                @Override // com.up366.common.task.Task
                public final void run() throws java.lang.Exception {
                    this.f$0.lambda$dispatchTouchEvent$1(motionEvent);
                }
            });
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatchTouchEvent$1(android.view.MotionEvent motionEvent) throws java.lang.Exception {
        com.up366.mobile.common.onlinelog.ActionLogRecord.record(getWindow(), motionEvent);
    }
}
