package com.up366.medialibrary.common.dialog;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class PhotoItemSelectedDialog extends androidx.fragment.app.DialogFragment implements android.view.View.OnClickListener {
    public static final int IMAGE_CAMERA = 0;
    public static final int VIDEO_CAMERA = 1;
    private com.up366.medialibrary.listener.OnItemClickListener onItemClickListener;

    public static com.up366.medialibrary.common.dialog.PhotoItemSelectedDialog newInstance() {
        return new com.up366.medialibrary.common.dialog.PhotoItemSelectedDialog();
    }

    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        if (getDialog() != null) {
            getDialog().requestWindowFeature(1);
            if (getDialog().getWindow() != null) {
                getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            }
        }
        return layoutInflater.inflate(com.up366.medialibrary.R.layout.picture_dialog_camera_selected, viewGroup);
    }

    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        android.widget.TextView textView = (android.widget.TextView) view.findViewById(com.up366.medialibrary.R.id.picture_tv_photo);
        android.widget.TextView textView2 = (android.widget.TextView) view.findViewById(com.up366.medialibrary.R.id.picture_tv_video);
        android.widget.TextView textView3 = (android.widget.TextView) view.findViewById(com.up366.medialibrary.R.id.picture_tv_cancel);
        textView2.setOnClickListener(this);
        textView.setOnClickListener(this);
        textView3.setOnClickListener(this);
    }

    public void onStart() {
        super.onStart();
        initDialogStyle();
    }

    private void initDialogStyle() {
        android.view.Window window;
        android.app.Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(com.up366.medialibrary.common.utils.ScreenUtils.getScreenWidth(getContext()), -2);
        window.setGravity(80);
        window.setWindowAnimations(com.up366.medialibrary.R.style.PictureThemeDialogFragmentAnim);
    }

    public void setOnItemClickListener(com.up366.medialibrary.listener.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        if (this.onItemClickListener != null) {
            if (id == com.up366.medialibrary.R.id.picture_tv_photo) {
                this.onItemClickListener.onItemClick(view, 0);
            }
            if (id == com.up366.medialibrary.R.id.picture_tv_video) {
                this.onItemClickListener.onItemClick(view, 1);
            }
        }
        dismissAllowingStateLoss();
    }

    public void show(androidx.fragment.app.FragmentManager fragmentManager, java.lang.String str) {
        androidx.fragment.app.FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.add(this, str);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
