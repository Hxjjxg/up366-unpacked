package com.up366.photopicker.ui;

/* JADX INFO: compiled from: PreviewActivity.kt */
/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/up366/photopicker/ui/PreviewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "photopicker_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PreviewActivity extends androidx.appcompat.app.AppCompatActivity {
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.up366.photopicker.R.layout.up366_photo_picker_activity_preview);
        java.lang.String stringExtra = getIntent().getStringExtra(com.up366.photopicker.PhotoPickerConstants.EXTRA_PREVIEW_PATH);
        com.up366.common.log.Logger.info("PreviewActivity onCreate, path=" + stringExtra);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.up366.photopicker.R.id.previewImage);
        imageView.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.up366.photopicker.ui.PreviewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                com.up366.photopicker.ui.PreviewActivity.onCreate$lambda$0(this.f$0, view);
            }
        });
        java.lang.String str = stringExtra;
        if (str != null && str.length() != 0) {
            com.bumptech.glide.Glide.with((androidx.fragment.app.FragmentActivity) this).load(stringExtra).into(imageView);
        }
        getWindow().getDecorView().setSystemUiVisibility(4102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(com.up366.photopicker.ui.PreviewActivity previewActivity, android.view.View view) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(previewActivity, "this$0");
        previewActivity.finish();
    }
}
