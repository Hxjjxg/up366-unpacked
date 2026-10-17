package com.up366.mobile.common.views;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class UpdateCustomProgressDialog extends android.app.AlertDialog {
    private boolean mHasStarted;
    private int mMax;
    private java.lang.CharSequence mMessage;
    private android.widget.ProgressBar mProgress;
    private android.widget.TextView mProgressMessage;
    private android.widget.TextView mProgressNumber;
    private java.lang.String mProgressNumberFormat;
    private android.widget.TextView mProgressPercent;
    private java.text.NumberFormat mProgressPercentFormat;
    private int mProgressVal;

    public UpdateCustomProgressDialog(android.content.Context context) {
        super(context);
        initFormats();
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.up366.mobile.R.layout.update_download_custom_progress);
        this.mProgress = (android.widget.ProgressBar) findViewById(com.up366.mobile.R.id.custom_progress);
        this.mProgressNumber = (android.widget.TextView) findViewById(com.up366.mobile.R.id.progress_total_size);
        this.mProgressPercent = (android.widget.TextView) findViewById(com.up366.mobile.R.id.progress_percent);
        this.mProgressMessage = (android.widget.TextView) findViewById(com.up366.mobile.R.id.progress_message);
        onProgressChanged();
        java.lang.CharSequence charSequence = this.mMessage;
        if (charSequence != null) {
            setMessage(charSequence);
        }
        int i = this.mMax;
        if (i > 0) {
            setMax(i);
        }
        int i2 = this.mProgressVal;
        if (i2 > 0) {
            setProgress(i2);
        }
    }

    private void initFormats() {
        this.mProgressNumberFormat = "%1.2fM/%2.2fM";
        java.text.NumberFormat percentInstance = java.text.NumberFormat.getPercentInstance();
        this.mProgressPercentFormat = percentInstance;
        percentInstance.setMaximumFractionDigits(0);
    }

    private void onProgressChanged() {
        updateProgress();
    }

    public int getMax() {
        android.widget.ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            return progressBar.getMax();
        }
        return this.mMax;
    }

    public void setMax(int i) {
        android.widget.ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            progressBar.setMax(i);
            onProgressChanged();
        } else {
            this.mMax = i;
        }
    }

    public void setProgress(int i) {
        if (this.mHasStarted) {
            this.mProgress.setProgress(i);
            onProgressChanged();
        } else {
            this.mProgressVal = i;
        }
    }

    @Override // android.app.AlertDialog
    public void setMessage(java.lang.CharSequence charSequence) {
        android.widget.TextView textView = this.mProgressMessage;
        if (textView != null) {
            textView.setText(charSequence);
        } else {
            this.mMessage = charSequence;
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        this.mHasStarted = true;
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.mHasStarted = false;
    }

    private void updateProgress() {
        double progress = this.mProgress.getProgress();
        double d = progress / 1048576.0d;
        double max = this.mProgress.getMax();
        double d2 = max / 1048576.0d;
        java.lang.String str = this.mProgressNumberFormat;
        if (str != null) {
            this.mProgressNumber.setText(java.lang.String.format(str, java.lang.Double.valueOf(d), java.lang.Double.valueOf(d2)));
        } else {
            this.mProgressNumber.setText("");
        }
        if (this.mProgressPercentFormat != null) {
            android.text.SpannableString spannableString = new android.text.SpannableString(this.mProgressPercentFormat.format(progress / max));
            spannableString.setSpan(new android.text.style.StyleSpan(1), 0, spannableString.length(), 33);
            this.mProgressPercent.setText(spannableString);
            return;
        }
        this.mProgressPercent.setText("");
    }
}
