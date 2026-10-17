package com.up366.medialibrary.common.utils;

/* JADX INFO: loaded from: E:\up366_re\dump\classes09.dex */
public class StringUtils {
    public static void tempTextFont(android.widget.TextView textView, int i) {
        java.lang.String string;
        java.lang.String strTrim = textView.getText().toString().trim();
        if (i == com.up366.medialibrary.common.utils.MimeTypeUtils.ofAudio()) {
            string = textView.getContext().getString(com.up366.medialibrary.R.string.picture_empty_audio_title);
        } else {
            string = textView.getContext().getString(com.up366.medialibrary.R.string.picture_empty_title);
        }
        java.lang.String str = string + strTrim;
        android.text.SpannableString spannableString = new android.text.SpannableString(str);
        spannableString.setSpan(new android.text.style.RelativeSizeSpan(0.8f), string.length(), str.length(), 33);
        textView.setText(spannableString);
    }

    public static int stringToInt(java.lang.String str) {
        if (java.util.regex.Pattern.compile("^[-\\+]?[\\d]+$").matcher(str).matches()) {
            return com.up366.medialibrary.common.utils.ValueOf.toInt(str);
        }
        return 0;
    }

    public static java.lang.String getMsg(android.content.Context context, java.lang.String str, int i) {
        return com.up366.medialibrary.common.utils.MimeTypeUtils.isVideo(str) ? context.getString(com.up366.medialibrary.R.string.picture_message_video_max_num, java.lang.Integer.valueOf(i)) : com.up366.medialibrary.common.utils.MimeTypeUtils.isHasAudio(str) ? context.getString(com.up366.medialibrary.R.string.picture_message_audio_max_num, java.lang.Integer.valueOf(i)) : context.getString(com.up366.medialibrary.R.string.picture_message_max_num, java.lang.Integer.valueOf(i));
    }

    public static java.lang.String rename(java.lang.String str) {
        try {
            return str.substring(0, str.lastIndexOf(".")) + "_" + com.up366.medialibrary.common.utils.DateUtils.getCreateFileName() + str.substring(str.lastIndexOf("."));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static java.lang.String renameSuffix(java.lang.String str, java.lang.String str2) {
        try {
            return str.substring(0, str.lastIndexOf(".")) + str2;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static java.lang.String getEncryptionValue(long j, int i, int i2) {
        if (i == 0 && i2 == 0) {
            return j + "_" + java.lang.System.currentTimeMillis();
        }
        return j + "_" + i + i2;
    }
}
