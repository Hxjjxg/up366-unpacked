package com.up366.qmui.qqface;

/* JADX INFO: loaded from: E:\up366_re\dump\classes11.dex */
public interface IQMUIQQFaceManager {
    int getDoubleUnicodeEmoji(int i, int i2);

    int getEmojiResource(int i);

    int getQQfaceResource(java.lang.CharSequence charSequence);

    int getSoftbankEmojiResource(char c);

    android.graphics.drawable.Drawable getSpecialBoundsDrawable(java.lang.CharSequence charSequence);

    int getSpecialDrawableMaxHeight();

    boolean maybeEmoji(int i);

    boolean maybeSoftBankEmoji(char c);
}
